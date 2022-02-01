package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Buffer
  implements BufferedSource, BufferedSink, Cloneable
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int REPLACEMENT_CHARACTER = 65533;
  Segment head;
  long size;
  
  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    while ((paramLong > 0L) || (paramBoolean))
    {
      Segment localSegment = writableSegment(1);
      int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
      i = paramInputStream.read(localSegment.data, localSegment.limit, i);
      if (i == -1)
      {
        if (paramBoolean) {
          return;
        }
        throw new EOFException();
      }
      localSegment.limit += i;
      this.size += i;
      paramLong -= i;
    }
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public void clear()
  {
    try
    {
      skip(this.size);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (this.size == 0L) {
      return localBuffer;
    }
    localBuffer.head = new Segment(this.head);
    Segment localSegment1 = localBuffer.head;
    Segment localSegment2 = localBuffer.head;
    Segment localSegment3 = localBuffer.head;
    localSegment2.prev = localSegment3;
    localSegment1.next = localSegment3;
    for (localSegment1 = this.head.next;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == this.head)
      {
        localBuffer.size = this.size;
        return localBuffer;
      }
      localBuffer.head.prev.push(new Segment(localSegment1));
    }
  }
  
  public void close() {}
  
  public long completeSegmentByteCount()
  {
    long l2 = this.size;
    if (l2 == 0L) {
      return 0L;
    }
    Segment localSegment = this.head.prev;
    long l1 = l2;
    if (localSegment.limit < 8192)
    {
      l1 = l2;
      if (localSegment.owner) {
        l1 = l2 - (localSegment.limit - localSegment.pos);
      }
    }
    return l1;
  }
  
  public Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }
  
  public Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    for (Segment localSegment = this.head;; localSegment = localSegment.next)
    {
      if (paramLong1 < localSegment.limit - localSegment.pos)
      {
        while (paramLong2 > 0L)
        {
          int i = (int)(localSegment.pos + paramLong1);
          int j = (int)Math.min(localSegment.limit - i, paramLong2);
          paramOutputStream.write(localSegment.data, i, j);
          paramLong2 -= j;
          paramLong1 = 0L;
          localSegment = localSegment.next;
        }
        break;
      }
      paramLong1 -= localSegment.limit - localSegment.pos;
    }
  }
  
  public Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramBuffer.size += paramLong2;
    Segment localSegment1 = this.head;
    label50:
    label67:
    Segment localSegment2;
    if (paramLong1 < localSegment1.limit - localSegment1.pos) {
      if (paramLong2 > 0L)
      {
        localSegment2 = new Segment(localSegment1);
        localSegment2.pos = ((int)(localSegment2.pos + paramLong1));
        localSegment2.limit = Math.min(localSegment2.pos + (int)paramLong2, localSegment2.limit);
        if (paramBuffer.head != null) {
          break label202;
        }
        localSegment2.prev = localSegment2;
        localSegment2.next = localSegment2;
        paramBuffer.head = localSegment2;
      }
    }
    for (;;)
    {
      paramLong2 -= localSegment2.limit - localSegment2.pos;
      paramLong1 = 0L;
      localSegment1 = localSegment1.next;
      break label67;
      break;
      paramLong1 -= localSegment1.limit - localSegment1.pos;
      localSegment1 = localSegment1.next;
      break label50;
      label202:
      paramBuffer.head.prev.push(localSegment2);
    }
  }
  
  public BufferedSink emit()
  {
    return this;
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    if (this.size != paramObject.size) {
      return false;
    }
    if (this.size == 0L) {
      return true;
    }
    Segment localSegment = this.head;
    paramObject = paramObject.head;
    int i = localSegment.pos;
    int j = paramObject.pos;
    long l1 = 0L;
    if (l1 >= this.size) {
      return true;
    }
    long l2 = Math.min(localSegment.limit - i, paramObject.limit - j);
    int m = 0;
    int k = i;
    i = j;
    j = k;
    k = m;
    label117:
    if (k >= l2)
    {
      if (j != localSegment.limit) {
        break label223;
      }
      localSegment = localSegment.next;
      j = localSegment.pos;
    }
    label223:
    for (;;)
    {
      if (i == paramObject.limit) {
        paramObject = paramObject.next;
      }
      for (k = paramObject.pos;; k = i)
      {
        l1 += l2;
        i = j;
        j = k;
        break;
        if (localSegment.data[j] != paramObject.data[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
        break label117;
      }
    }
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  public byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    for (Segment localSegment = this.head;; localSegment = localSegment.next)
    {
      int i = localSegment.limit - localSegment.pos;
      if (paramLong < i) {
        return localSegment.data[(localSegment.pos + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int k = ((Segment)localObject).pos;
    int m = ((Segment)localObject).limit;
    int i = j;
    j = k;
    for (;;)
    {
      if (j >= m)
      {
        Segment localSegment = ((Segment)localObject).next;
        j = i;
        localObject = localSegment;
        if (localSegment != this.head) {
          break;
        }
        return i;
      }
      i = i * 31 + localObject.data[j];
      j += 1;
    }
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.head;
    if (localObject1 == null) {
      return -1L;
    }
    long l = 0L;
    do
    {
      int j = ((Segment)localObject1).limit - ((Segment)localObject1).pos;
      if (paramLong < j) {
        break;
      }
      paramLong -= j;
      l += j;
      localObject2 = ((Segment)localObject1).next;
      localObject1 = localObject2;
    } while (localObject2 != this.head);
    return -1L;
    Object localObject2 = ((Segment)localObject1).data;
    int i = (int)(((Segment)localObject1).pos + paramLong);
    int k = ((Segment)localObject1).limit;
    for (;;)
    {
      if (i >= k)
      {
        paramLong = 0L;
        break;
      }
      if (localObject2[i] == paramByte) {
        return i + l - ((Segment)localObject1).pos;
      }
      i += 1;
    }
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    if (paramByteString.size() == 0) {
      throw new IllegalArgumentException("bytes is empty");
    }
    do
    {
      paramLong += 1L;
      paramLong = indexOf(paramByteString.getByte(0), paramLong);
      if (paramLong == -1L) {
        return -1L;
      }
    } while (!rangeEquals(paramLong, paramByteString));
    return paramLong;
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject = this.head;
    if (localObject == null) {
      return -1L;
    }
    long l1 = 0L;
    byte[] arrayOfByte = paramByteString.toByteArray();
    paramByteString = (ByteString)localObject;
    int j = paramByteString.limit - paramByteString.pos;
    if (paramLong >= j) {}
    for (paramLong -= j;; paramLong = 0L)
    {
      l1 += j;
      localObject = paramByteString.next;
      paramByteString = (ByteString)localObject;
      if (localObject != this.head) {
        break;
      }
      return -1L;
      localObject = paramByteString.data;
      paramLong = paramByteString.pos + paramLong;
      long l2 = paramByteString.limit;
      if (paramLong < l2) {
        break label131;
      }
    }
    label131:
    int k = localObject[((int)paramLong)];
    int m = arrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= m)
      {
        paramLong += 1L;
        break;
      }
      if (k == arrayOfByte[i]) {
        return l1 + paramLong - paramByteString.pos;
      }
      i += 1;
    }
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
      {
        return (int)Math.min(Buffer.this.size, 2147483647L);
      }
      
      public void close() {}
      
      public int read()
      {
        if (Buffer.this.size > 0L) {
          return Buffer.this.readByte() & 0xFF;
        }
        return -1;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return Buffer.this.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        return Buffer.this + ".inputStream()";
      }
    };
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close() {}
      
      public void flush() {}
      
      public String toString()
      {
        return this + ".outputStream()";
      }
      
      public void write(int paramAnonymousInt)
      {
        Buffer.this.writeByte((byte)paramAnonymousInt);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Buffer.this.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    int j = paramByteString.size();
    if (this.size - paramLong < j) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      if (getByte(i + paramLong) != paramByteString.getByte(i)) {
        break;
      }
      i += 1;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, paramInt2);
      localSegment.pos += paramInt2;
      this.size -= paramInt2;
      paramInt1 = paramInt2;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return paramInt2;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.size == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.size) {
      l = this.size;
    }
    paramBuffer.write(this, l);
    return l;
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    long l = this.size;
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public byte readByte()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    this.size -= 1L;
    if (k == j)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return b;
    }
    localSegment.pos = k;
    return b;
  }
  
  public byte[] readByteArray()
  {
    try
    {
      byte[] arrayOfByte = readByteArray(this.size);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public byte[] readByteArray(long paramLong)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  public ByteString readByteString()
  {
    return new ByteString(readByteArray());
  }
  
  public ByteString readByteString(long paramLong)
    throws EOFException
  {
    return new ByteString(readByteArray(paramLong));
  }
  
  public long readDecimalLong()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int m = 0;
    int n = 0;
    int j = 0;
    long l3 = -7L;
    Object localObject = this.head;
    byte[] arrayOfByte = ((Segment)localObject).data;
    int k = ((Segment)localObject).pos;
    int i1 = ((Segment)localObject).limit;
    long l1 = l2;
    int i = m;
    m = k;
    l2 = l3;
    k = n;
    if (m >= i1)
    {
      label86:
      if (m != i1) {
        break label348;
      }
      this.head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (j == 0)
      {
        n = k;
        l3 = l2;
        m = i;
        l2 = l1;
        if (this.head != null) {
          break;
        }
      }
      this.size -= i;
      if (k == 0) {
        break label358;
      }
      return l1;
      n = arrayOfByte[m];
      if ((n >= 48) && (n <= 57))
      {
        int i2 = 48 - n;
        if ((l1 < -922337203685477580L) || ((l1 == -922337203685477580L) && (i2 < l2)))
        {
          localObject = new Buffer().writeDecimalLong(l1).writeByte(n);
          if (k == 0) {
            ((Buffer)localObject).readByte();
          }
          throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
        }
        l1 = l1 * 10L + i2;
      }
      for (;;)
      {
        m += 1;
        i += 1;
        break;
        if ((n != 45) || (i != 0)) {
          break label310;
        }
        k = 1;
        l2 -= 1L;
      }
      label310:
      if (i == 0) {
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(n));
      }
      j = 1;
      break label86;
      label348:
      ((Segment)localObject).pos = m;
    }
    label358:
    return -l1;
  }
  
  public Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    readFrom(paramInputStream, 9223372036854775807L, true);
    return this;
  }
  
  public Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    readFrom(paramInputStream, paramLong, false);
    return this;
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws EOFException
  {
    if (this.size < paramLong)
    {
      paramBuffer.write(this, this.size);
      throw new EOFException();
    }
    paramBuffer.write(this, paramLong);
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return;
      }
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    if (this.size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l1 = 0L;
    int i = 0;
    int k = 0;
    Object localObject = this.head;
    byte[] arrayOfByte = ((Segment)localObject).data;
    int m = ((Segment)localObject).pos;
    int n = ((Segment)localObject).limit;
    long l2 = l1;
    int j = i;
    label60:
    if (m >= n)
    {
      if (m != n) {
        break label317;
      }
      this.head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (k == 0)
      {
        i = j;
        l1 = l2;
        if (this.head != null) {
          break;
        }
      }
      this.size -= j;
      return l2;
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0x0 & l2) != 0L)
        {
          localObject = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i1);
          throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
          if ((i1 >= 97) && (i1 <= 102))
          {
            i = i1 - 97 + 10;
          }
          else if ((i1 >= 65) && (i1 <= 70))
          {
            i = i1 - 65 + 10;
          }
          else
          {
            if (j == 0) {
              throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
            }
            k = 1;
            break;
          }
        }
      }
      l2 = l2 << 4 | i;
      m += 1;
      j += 1;
      break label60;
      label317:
      ((Segment)localObject).pos = m;
    }
  }
  
  public int readInt()
  {
    if (this.size < 4L) {
      throw new IllegalStateException("size < 4: " + this.size);
    }
    Segment localSegment = this.head;
    int j = localSegment.pos;
    int i = localSegment.limit;
    if (i - j < 4) {
      return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.size -= 4L;
    if (n == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return j;
    }
    localSegment.pos = n;
    return j;
  }
  
  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public long readLong()
  {
    if (this.size < 8L) {
      throw new IllegalStateException("size < 8: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 8) {
      return (readInt() & 0xFFFFFFFF) << 32 | readInt() & 0xFFFFFFFF;
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    long l1 = arrayOfByte[k];
    k = j + 1;
    long l2 = arrayOfByte[j];
    j = k + 1;
    long l3 = arrayOfByte[k];
    k = j + 1;
    long l4 = arrayOfByte[j];
    j = k + 1;
    long l5 = arrayOfByte[k];
    k = j + 1;
    long l6 = arrayOfByte[j];
    j = k + 1;
    long l7 = arrayOfByte[k];
    k = j + 1;
    l1 = (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
    this.size -= 8L;
    if (k == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return l1;
    }
    localSegment.pos = k;
    return l1;
  }
  
  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }
  
  public short readShort()
  {
    if (this.size < 2L) {
      throw new IllegalStateException("size < 2: " + this.size);
    }
    Segment localSegment = this.head;
    int k = localSegment.pos;
    int i = localSegment.limit;
    if (i - k < 2) {
      return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
    }
    byte[] arrayOfByte = localSegment.data;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.size -= 2L;
    if (m == i)
    {
      this.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localSegment.pos = m;
    }
  }
  
  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    Segment localSegment;
    String str;
    do
    {
      return paramCharset;
      localSegment = this.head;
      if (localSegment.pos + paramLong > localSegment.limit) {
        return new String(readByteArray(paramLong), paramCharset);
      }
      str = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
      localSegment.pos = ((int)(localSegment.pos + paramLong));
      this.size -= paramLong;
      paramCharset = str;
    } while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return str;
  }
  
  public String readString(Charset paramCharset)
  {
    try
    {
      paramCharset = readString(this.size, paramCharset);
      return paramCharset;
    }
    catch (EOFException paramCharset)
    {
      throw new AssertionError(paramCharset);
    }
  }
  
  public String readUtf8()
  {
    try
    {
      String str = readString(this.size, Util.UTF_8);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public int readUtf8CodePoint()
    throws EOFException
  {
    if (this.size == 0L) {
      throw new EOFException();
    }
    int m = getByte(0L);
    int i;
    int j;
    int k;
    if ((m & 0x80) == 0)
    {
      i = m & 0x7F;
      j = 1;
      k = 0;
    }
    while (this.size < j)
    {
      throw new EOFException("size < " + j + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(m) + ")");
      if ((m & 0xE0) == 192)
      {
        i = m & 0x1F;
        j = 2;
        k = 128;
      }
      else if ((m & 0xF0) == 224)
      {
        i = m & 0xF;
        j = 3;
        k = 2048;
      }
      else if ((m & 0xF8) == 240)
      {
        i = m & 0x7;
        j = 4;
        k = 65536;
      }
      else
      {
        skip(1L);
        j = 65533;
      }
    }
    label278:
    do
    {
      return j;
      m = 1;
      for (;;)
      {
        if (m >= j)
        {
          skip(j);
          if (i <= 1114111) {
            break label278;
          }
          return 65533;
        }
        int n = getByte(m);
        if ((n & 0xC0) != 128) {
          break;
        }
        i = i << 6 | n & 0x3F;
        m += 1;
      }
      skip(m);
      return 65533;
      if ((i >= 55296) && (i <= 57343)) {
        return 65533;
      }
      j = i;
    } while (i >= k);
    return 65533;
  }
  
  public String readUtf8Line()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.size != 0L) {
        return readUtf8(this.size);
      }
      return null;
    }
    return readUtf8Line(l);
  }
  
  String readUtf8Line(long paramLong)
    throws EOFException
  {
    if ((paramLong > 0L) && (getByte(paramLong - 1L) == 13))
    {
      str = readUtf8(paramLong - 1L);
      skip(2L);
      return str;
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public String readUtf8LineStrict()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      Buffer localBuffer = new Buffer();
      copyTo(localBuffer, 0L, Math.min(32L, this.size));
      throw new EOFException("\\n not found: size=" + size() + " content=" + localBuffer.readByteString().hex() + "...");
    }
    return readUtf8Line(l);
  }
  
  public boolean request(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public void require(long paramLong)
    throws EOFException
  {
    if (this.size < paramLong) {
      throw new EOFException();
    }
  }
  
  List<Integer> segmentSizes()
  {
    Object localObject;
    if (this.head == null)
    {
      localObject = Collections.emptyList();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
    for (Segment localSegment = this.head.next;; localSegment = localSegment.next)
    {
      localObject = localArrayList;
      if (localSegment == this.head) {
        break;
      }
      localArrayList.add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
  }
  
  public long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
    throws EOFException
  {
    for (;;)
    {
      if (paramLong <= 0L) {
        return;
      }
      if (this.head == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.head.limit - this.head.pos);
      this.size -= i;
      long l = paramLong - i;
      Segment localSegment = this.head;
      localSegment.pos += i;
      paramLong = l;
      if (this.head.pos == this.head.limit)
      {
        localSegment = this.head;
        this.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
        paramLong = l;
      }
    }
  }
  
  public ByteString snapshot()
  {
    if (this.size > 2147483647L) {
      throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }
    return snapshot((int)this.size);
  }
  
  public ByteString snapshot(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    return new SegmentedByteString(this, paramInt);
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 87	okio/Buffer:size	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +7 -> 13
    //   9: ldc_w 485
    //   12: areturn
    //   13: aload_0
    //   14: getfield 87	okio/Buffer:size	J
    //   17: ldc2_w 486
    //   20: lcmp
    //   21: ifgt +39 -> 60
    //   24: aload_0
    //   25: invokevirtual 106	okio/Buffer:clone	()Lokio/Buffer;
    //   28: invokevirtual 429	okio/Buffer:readByteString	()Lokio/ByteString;
    //   31: astore_1
    //   32: ldc_w 489
    //   35: iconst_2
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: getfield 87	okio/Buffer:size	J
    //   45: invokestatic 494	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_1
    //   52: invokevirtual 432	okio/ByteString:hex	()Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 498	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: areturn
    //   60: ldc_w 500
    //   63: invokestatic 506	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   66: astore_2
    //   67: aload_2
    //   68: aload_0
    //   69: getfield 109	okio/Buffer:head	Lokio/Segment;
    //   72: getfield 76	okio/Segment:data	[B
    //   75: aload_0
    //   76: getfield 109	okio/Buffer:head	Lokio/Segment;
    //   79: getfield 132	okio/Segment:pos	I
    //   82: aload_0
    //   83: getfield 109	okio/Buffer:head	Lokio/Segment;
    //   86: getfield 67	okio/Segment:limit	I
    //   89: aload_0
    //   90: getfield 109	okio/Buffer:head	Lokio/Segment;
    //   93: getfield 132	okio/Segment:pos	I
    //   96: isub
    //   97: invokevirtual 509	java/security/MessageDigest:update	([BII)V
    //   100: aload_0
    //   101: getfield 109	okio/Buffer:head	Lokio/Segment;
    //   104: getfield 118	okio/Segment:next	Lokio/Segment;
    //   107: astore_1
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 109	okio/Buffer:head	Lokio/Segment;
    //   113: if_acmpne +37 -> 150
    //   116: ldc_w 511
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_0
    //   126: getfield 87	okio/Buffer:size	J
    //   129: invokestatic 494	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: aload_2
    //   136: invokevirtual 514	java/security/MessageDigest:digest	()[B
    //   139: invokestatic 518	okio/ByteString:of	([B)Lokio/ByteString;
    //   142: invokevirtual 432	okio/ByteString:hex	()Ljava/lang/String;
    //   145: aastore
    //   146: invokestatic 498	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   149: areturn
    //   150: aload_2
    //   151: aload_1
    //   152: getfield 76	okio/Segment:data	[B
    //   155: aload_1
    //   156: getfield 132	okio/Segment:pos	I
    //   159: aload_1
    //   160: getfield 67	okio/Segment:limit	I
    //   163: aload_1
    //   164: getfield 132	okio/Segment:pos	I
    //   167: isub
    //   168: invokevirtual 509	java/security/MessageDigest:update	([BII)V
    //   171: aload_1
    //   172: getfield 118	okio/Segment:next	Lokio/Segment;
    //   175: astore_1
    //   176: goto -68 -> 108
    //   179: astore_1
    //   180: new 97	java/lang/AssertionError
    //   183: dup
    //   184: invokespecial 519	java/lang/AssertionError:<init>	()V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	Buffer
    //   31	145	1	localObject	Object
    //   179	1	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   66	85	2	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   60	108	179	java/security/NoSuchAlgorithmException
    //   108	150	179	java/security/NoSuchAlgorithmException
    //   150	176	179	java/security/NoSuchAlgorithmException
  }
  
  Segment writableSegment(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 8192)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2;
    Segment localSegment1;
    if (this.head == null)
    {
      this.head = SegmentPool.take();
      localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment1 = this.head;
      localSegment3.prev = localSegment1;
      localSegment2.next = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment2 = this.head.prev;
      if (localSegment2.limit + paramInt > 8192) {
        break;
      }
      localSegment1 = localSegment2;
    } while (localSegment2.owner);
    return localSegment2.push(SegmentPool.take());
  }
  
  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramByteString.write(this);
    return this;
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    for (;;)
    {
      if (paramInt1 >= i)
      {
        this.size += paramInt2;
        return this;
      }
      Segment localSegment = writableSegment(1);
      int j = Math.min(i - paramInt1, 8192 - localSegment.limit);
      System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, j);
      paramInt1 += j;
      localSegment.limit += j;
    }
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
    throws IOException
  {
    for (;;)
    {
      if (paramLong <= 0L) {
        return this;
      }
      long l = paramSource.read(this, paramLong);
      if (l == -1L) {
        throw new EOFException();
      }
      paramLong -= l;
    }
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramBuffer == this) {
      throw new IllegalArgumentException("source == this");
    }
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    if (paramLong <= 0L) {
      return;
    }
    if (paramLong < paramBuffer.head.limit - paramBuffer.head.pos)
    {
      if (this.head != null)
      {
        localSegment1 = this.head.prev;
        if ((localSegment1 == null) || (!localSegment1.owner)) {
          break label179;
        }
        l = localSegment1.limit;
        if (!localSegment1.shared) {
          break label169;
        }
      }
      label169:
      for (int i = 0;; i = localSegment1.pos)
      {
        if (paramLong + l - i > 8192L) {
          break label179;
        }
        paramBuffer.head.writeTo(localSegment1, (int)paramLong);
        paramBuffer.size -= paramLong;
        this.size += paramLong;
        return;
        localSegment1 = null;
        break;
      }
      label179:
      paramBuffer.head = paramBuffer.head.split((int)paramLong);
    }
    Segment localSegment1 = paramBuffer.head;
    long l = localSegment1.limit - localSegment1.pos;
    paramBuffer.head = localSegment1.pop();
    if (this.head == null)
    {
      this.head = localSegment1;
      localSegment1 = this.head;
      Segment localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment2.prev = localSegment3;
      localSegment1.next = localSegment3;
    }
    for (;;)
    {
      paramBuffer.size -= l;
      this.size += l;
      paramLong -= l;
      break;
      this.head.prev.push(localSegment1).compact();
    }
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, 8192L);
      if (l2 == -1L) {
        return l1;
      }
    }
  }
  
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.size += 1L;
    return this;
  }
  
  public Buffer writeDecimalLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = 0;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    int i;
    int k;
    Segment localSegment;
    byte[] arrayOfByte;
    if (l < 100000000L) {
      if (l < 10000L) {
        if (l < 100L) {
          if (l < 10L)
          {
            i = 1;
            k = i;
            if (j != 0) {
              k = i + 1;
            }
            localSegment = writableSegment(k);
            arrayOfByte = localSegment.data;
            i = localSegment.limit + k;
          }
        }
      }
    }
    for (;;)
    {
      if (l == 0L)
      {
        if (j != 0) {
          arrayOfByte[(i - 1)] = 45;
        }
        localSegment.limit += k;
        this.size += k;
        return this;
        i = 2;
        break;
        if (l < 1000L)
        {
          i = 3;
          break;
        }
        i = 4;
        break;
        if (l < 1000000L)
        {
          if (l < 100000L)
          {
            i = 5;
            break;
          }
          i = 6;
          break;
        }
        if (l < 10000000L)
        {
          i = 7;
          break;
        }
        i = 8;
        break;
        if (l < 1000000000000L)
        {
          if (l < 10000000000L)
          {
            if (l < 1000000000L)
            {
              i = 9;
              break;
            }
            i = 10;
            break;
          }
          if (l < 100000000000L)
          {
            i = 11;
            break;
          }
          i = 12;
          break;
        }
        if (l < 1000000000000000L)
        {
          if (l < 10000000000000L)
          {
            i = 13;
            break;
          }
          if (l < 100000000000000L)
          {
            i = 14;
            break;
          }
          i = 15;
          break;
        }
        if (l < 100000000000000000L)
        {
          if (l < 10000000000000000L)
          {
            i = 16;
            break;
          }
          i = 17;
          break;
        }
        if (l < 1000000000000000000L)
        {
          i = 18;
          break;
        }
        i = 19;
        break;
      }
      int m = (int)(l % 10L);
      i -= 1;
      arrayOfByte[i] = DIGITS[m];
      l /= 10L;
    }
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment localSegment = writableSegment(j);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit + j - 1;
    int k = localSegment.limit;
    for (;;)
    {
      if (i < k)
      {
        localSegment.limit += j;
        this.size += j;
        return this;
      }
      arrayOfByte[i] = DIGITS[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
  }
  
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 4L;
    return this;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    this.size += 8L;
    return this;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    this.size += 2L;
    return this;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramCharset.equals(Util.UTF_8)) {
      return writeUtf8(paramString);
    }
    paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
    return write(paramString, 0, paramString.length);
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Object localObject1 = this.head;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (paramLong <= 0L) {
        return this;
      }
      int i = (int)Math.min(paramLong, localObject2.limit - localObject2.pos);
      paramOutputStream.write(localObject2.data, localObject2.pos, i);
      localObject2.pos += i;
      this.size -= i;
      long l = paramLong - i;
      localObject1 = localObject2;
      paramLong = l;
      if (localObject2.pos == localObject2.limit)
      {
        localObject1 = localObject2.pop();
        this.head = ((Segment)localObject1);
        SegmentPool.recycle(localObject2);
        paramLong = l;
      }
    }
  }
  
  public Buffer writeUtf8(String paramString)
  {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        return this;
      }
      int k = paramString.charAt(paramInt1);
      int i;
      if (k < 128)
      {
        Segment localSegment = writableSegment(1);
        byte[] arrayOfByte = localSegment.data;
        i = localSegment.limit - paramInt1;
        int j = Math.min(paramInt2, 8192 - i);
        arrayOfByte[(i + paramInt1)] = ((byte)k);
        paramInt1 += 1;
        for (;;)
        {
          if (paramInt1 >= j) {}
          do
          {
            i = paramInt1 + i - localSegment.limit;
            localSegment.limit += i;
            this.size += i;
            break;
            k = paramString.charAt(paramInt1);
          } while (k >= 128);
          arrayOfByte[(i + paramInt1)] = ((byte)k);
          paramInt1 += 1;
        }
      }
      if (k < 2048)
      {
        writeByte(k >> 6 | 0xC0);
        writeByte(k & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((k < 55296) || (k > 57343))
      {
        writeByte(k >> 12 | 0xE0);
        writeByte(k >> 6 & 0x3F | 0x80);
        writeByte(k & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 < paramInt2) {}
        for (i = paramString.charAt(paramInt1 + 1);; i = 0)
        {
          if ((k <= 56319) && (i >= 56320) && (i <= 57343)) {
            break label450;
          }
          writeByte(63);
          paramInt1 += 1;
          break;
        }
        label450:
        i = 65536 + ((0xFFFF27FF & k) << 10 | 0xFFFF23FF & i);
        writeByte(i >> 18 | 0xF0);
        writeByte(i >> 12 & 0x3F | 0x80);
        writeByte(i >> 6 & 0x3F | 0x80);
        writeByte(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
  }
  
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343)) {
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
      }
      writeByte(paramInt >> 12 | 0xE0);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      writeByte(paramInt >> 18 | 0xF0);
      writeByte(paramInt >> 12 & 0x3F | 0x80);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     okio.Buffer
 * JD-Core Version:    0.7.0.1
 */