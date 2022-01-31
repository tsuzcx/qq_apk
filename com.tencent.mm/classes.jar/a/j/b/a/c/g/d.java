package a.j.b.a.c.g;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class d
  implements Iterable<Byte>
{
  public static final d Cre;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Cre = new p(new byte[0]);
      return;
    }
  }
  
  public static d B(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new p(arrayOfByte);
  }
  
  private static d a(Iterator<d> paramIterator, int paramInt)
  {
    assert (paramInt > 0);
    if (paramInt == 1) {
      return (d)paramIterator.next();
    }
    int i = paramInt >>> 1;
    return a(paramIterator, i).a(a(paramIterator, paramInt - i));
  }
  
  public static d ayY(String paramString)
  {
    try
    {
      paramString = new p(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static d cB(byte[] paramArrayOfByte)
  {
    return B(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static d.b emp()
  {
    return new d.b();
  }
  
  public static d x(Iterable<d> paramIterable)
  {
    ArrayList localArrayList;
    if (!(paramIterable instanceof Collection))
    {
      localArrayList = new ArrayList();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add((d)paramIterable.next());
      }
    }
    for (paramIterable = localArrayList; paramIterable.isEmpty(); paramIterable = (Collection)paramIterable) {
      return Cre;
    }
    return a(paramIterable.iterator(), paramIterable.size());
  }
  
  public final d a(d paramd)
  {
    int i = size();
    int j = paramd.size();
    if (i + j >= 2147483647L) {
      throw new IllegalArgumentException(53 + "ByteString would be too long: " + i + "+" + j);
    }
    return u.a(this, paramd);
  }
  
  final void a(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException(30 + "Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException(23 + "Length < 0: " + paramInt2);
    }
    if (paramInt1 + paramInt2 > size()) {
      throw new IndexOutOfBoundsException(39 + "Source end offset exceeded: " + (paramInt1 + paramInt2));
    }
    if (paramInt2 > 0) {
      b(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  protected abstract int aQ(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int aR(int paramInt1, int paramInt2, int paramInt3);
  
  abstract void b(OutputStream paramOutputStream, int paramInt1, int paramInt2);
  
  public final String dqj()
  {
    try
    {
      String str = toString("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  public abstract d.a emm();
  
  public abstract boolean emn();
  
  public abstract e emo();
  
  protected abstract int emq();
  
  protected abstract boolean emr();
  
  protected abstract int ems();
  
  public final void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException(30 + "Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException(30 + "Target offset < 0: " + paramInt2);
    }
    if (paramInt3 < 0) {
      throw new IndexOutOfBoundsException(23 + "Length < 0: " + paramInt3);
    }
    if (paramInt1 + paramInt3 > size()) {
      throw new IndexOutOfBoundsException(34 + "Source end offset < 0: " + (paramInt1 + paramInt3));
    }
    if (paramInt2 + paramInt3 > paramArrayOfByte.length) {
      throw new IndexOutOfBoundsException(34 + "Target end offset < 0: " + (paramInt2 + paramInt3));
    }
    if (paramInt3 > 0) {
      i(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int size();
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return j.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    i(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public abstract String toString(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.g.d
 * JD-Core Version:    0.7.0.1
 */