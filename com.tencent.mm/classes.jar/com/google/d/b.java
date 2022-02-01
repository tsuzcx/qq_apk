package com.google.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
  implements ce
{
  protected int memoizedHashCode = 0;
  
  @Deprecated
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
  {
    a.addAll(paramIterable, (List)paramCollection);
  }
  
  protected static <T> void addAll(Iterable<T> paramIterable, List<? super T> paramList)
  {
    a.addAll(paramIterable, paramList);
  }
  
  protected static void checkByteStringIsUtf8(h paramh)
  {
    if (!paramh.ZW()) {
      throw new IllegalArgumentException("Byte string is not UTF-8.");
    }
  }
  
  private Class<b<MessageType, BuilderType>> getClassInternal()
  {
    return getClass();
  }
  
  private String getSerializingExceptionMessage(String paramString)
  {
    return "Serializing " + getClass().getName() + " to a " + paramString + " threw an IOException (should never happen).";
  }
  
  int getMemoizedSerializedSize()
  {
    throw new UnsupportedOperationException();
  }
  
  int getSerializedSize(dc paramdc)
  {
    int j = getMemoizedSerializedSize();
    int i = j;
    if (j == -1)
    {
      i = paramdc.bH(this);
      setMemoizedSerializedSize(i);
    }
    return i;
  }
  
  protected final int getSerializedSizeInternal()
  {
    return cv.aja().bK(this).bH(this);
  }
  
  protected final boolean isInitializedInternal()
  {
    return cv.aja().bK(this).bI(this);
  }
  
  protected void makeImmutableInternal()
  {
    cv.aja().O(getClassInternal()).bu(this);
  }
  
  /* Error */
  protected void mergeFromInternal(i parami, at paramat)
  {
    // Byte code:
    //   0: invokestatic 104	com/google/d/cv:aja	()Lcom/google/d/cv;
    //   3: aload_0
    //   4: invokespecial 116	com/google/d/b:getClassInternal	()Ljava/lang/Class;
    //   7: invokevirtual 120	com/google/d/cv:O	(Ljava/lang/Class;)Lcom/google/d/dc;
    //   10: astore_3
    //   11: aload_1
    //   12: getfield 136	com/google/d/i:dIU	Lcom/google/d/j;
    //   15: ifnull +18 -> 33
    //   18: aload_1
    //   19: getfield 136	com/google/d/i:dIU	Lcom/google/d/j;
    //   22: astore_1
    //   23: aload_3
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: invokeinterface 139 4 0
    //   32: return
    //   33: new 141	com/google/d/j
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 144	com/google/d/j:<init>	(Lcom/google/d/i;)V
    //   41: astore_1
    //   42: goto -19 -> 23
    //   45: astore_1
    //   46: aload_1
    //   47: aload_0
    //   48: putfield 148	com/google/d/bk:dST	Lcom/google/d/ce;
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: new 128	com/google/d/bk
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 151	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_0
    //   65: putfield 148	com/google/d/bk:dST	Lcom/google/d/ce;
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	b
    //   0	70	1	parami	i
    //   0	70	2	paramat	at
    //   10	14	3	localdc	dc
    // Exception table:
    //   from	to	target	type
    //   0	23	45	com/google/d/bk
    //   23	32	45	com/google/d/bk
    //   33	42	45	com/google/d/bk
    //   0	23	53	java/io/IOException
    //   23	32	53	java/io/IOException
    //   33	42	53	java/io/IOException
  }
  
  dl newUninitializedMessageException()
  {
    return new dl();
  }
  
  void setMemoizedSerializedSize(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      k localk = k.C(arrayOfByte);
      writeTo(localk);
      localk.aaN();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(getSerializingExceptionMessage("byte array"), localIOException);
    }
  }
  
  public h toByteString()
  {
    try
    {
      Object localObject = h.jL(getSerializedSize());
      writeTo(((h.f)localObject).dIQ);
      localObject = ((h.f)localObject).aab();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(getSerializingExceptionMessage("ByteString"), localIOException);
    }
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream)
  {
    int i = getSerializedSize();
    paramOutputStream = k.c(paramOutputStream, k.kc(k.kv(i) + i));
    paramOutputStream.ke(i);
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream = k.c(paramOutputStream, k.kc(getSerializedSize()));
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
  
  protected final void writeToInternal(k paramk)
  {
    dc localdc = cv.aja().O(getClassInternal());
    if (paramk.dJn != null) {}
    for (paramk = paramk.dJn;; paramk = new l(paramk))
    {
      localdc.a(this, paramk);
      return;
    }
  }
  
  public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
    implements ce.a
  {
    @Deprecated
    protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
    {
      addAll(paramIterable, (List)paramCollection);
    }
    
    protected static <T> void addAll(Iterable<T> paramIterable, List<? super T> paramList)
    {
      bj.checkNotNull(paramIterable);
      if ((paramIterable instanceof bp))
      {
        Object localObject = ((bp)paramIterable).aiu();
        paramIterable = (bp)paramList;
        int j = paramList.size();
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = paramList.next();
          if (localObject == null)
          {
            paramList = "Element at index " + (paramIterable.size() - j) + " is null.";
            int i = paramIterable.size() - 1;
            while (i >= j)
            {
              paramIterable.remove(i);
              i -= 1;
            }
            throw new NullPointerException(paramList);
          }
          if ((localObject instanceof h)) {
            paramIterable.d((h)localObject);
          } else {
            paramIterable.add((String)localObject);
          }
        }
      }
      if ((paramIterable instanceof ct))
      {
        paramList.addAll((Collection)paramIterable);
        return;
      }
      addAllCheckingNulls(paramIterable, paramList);
    }
    
    private static <T> void addAllCheckingNulls(Iterable<T> paramIterable, List<? super T> paramList)
    {
      Object localObject;
      int i;
      if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection)))
      {
        localObject = (ArrayList)paramList;
        i = paramList.size();
        ((ArrayList)localObject).ensureCapacity(((Collection)paramIterable).size() + i);
      }
      int j = paramList.size();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        localObject = paramIterable.next();
        if (localObject == null)
        {
          paramIterable = "Element at index " + (paramList.size() - j) + " is null.";
          i = paramList.size() - 1;
          while (i >= j)
          {
            paramList.remove(i);
            i -= 1;
          }
          throw new NullPointerException(paramIterable);
        }
        paramList.add(localObject);
      }
    }
    
    private String getReadingExceptionMessage(String paramString)
    {
      return "Reading " + getClass().getName() + " from a " + paramString + " threw an IOException (should never happen).";
    }
    
    protected static dl newUninitializedMessageException(ce paramce)
    {
      return new dl();
    }
    
    public abstract BuilderType clone();
    
    protected abstract BuilderType internalMergeFrom(MessageType paramMessageType);
    
    public boolean mergeDelimitedFrom(InputStream paramInputStream)
    {
      return mergeDelimitedFrom(paramInputStream, at.ahJ());
    }
    
    public boolean mergeDelimitedFrom(InputStream paramInputStream, at paramat)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return false;
      }
      mergeFrom(new a(paramInputStream, i.b(i, paramInputStream)), paramat);
      return true;
    }
    
    public BuilderType mergeFrom(ce paramce)
    {
      if (!getDefaultInstanceForType().getClass().isInstance(paramce)) {
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
      }
      return internalMergeFrom((b)paramce);
    }
    
    public BuilderType mergeFrom(h paramh)
    {
      try
      {
        paramh = paramh.ZX();
        mergeFrom(paramh);
        paramh.jM(0);
        return this;
      }
      catch (bk paramh)
      {
        throw paramh;
      }
      catch (IOException paramh)
      {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), paramh);
      }
    }
    
    public BuilderType mergeFrom(h paramh, at paramat)
    {
      try
      {
        paramh = paramh.ZX();
        mergeFrom(paramh, paramat);
        paramh.jM(0);
        return this;
      }
      catch (bk paramh)
      {
        throw paramh;
      }
      catch (IOException paramh)
      {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), paramh);
      }
    }
    
    public BuilderType mergeFrom(i parami)
    {
      return mergeFrom(parami, at.ahJ());
    }
    
    public abstract BuilderType mergeFrom(i parami, at paramat);
    
    public BuilderType mergeFrom(InputStream paramInputStream)
    {
      paramInputStream = i.u(paramInputStream);
      mergeFrom(paramInputStream);
      paramInputStream.jM(0);
      return this;
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream, at paramat)
    {
      paramInputStream = i.u(paramInputStream);
      mergeFrom(paramInputStream, paramat);
      paramInputStream.jM(0);
      return this;
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte)
    {
      return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        paramArrayOfByte = i.r(paramArrayOfByte, paramInt1, paramInt2);
        mergeFrom(paramArrayOfByte);
        paramArrayOfByte.jM(0);
        return this;
      }
      catch (bk paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), paramArrayOfByte);
      }
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, at paramat)
    {
      try
      {
        paramArrayOfByte = i.r(paramArrayOfByte, paramInt1, paramInt2);
        mergeFrom(paramArrayOfByte, paramat);
        paramArrayOfByte.jM(0);
        return this;
      }
      catch (bk paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), paramArrayOfByte);
      }
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, at paramat)
    {
      return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramat);
    }
    
    static final class a
      extends FilterInputStream
    {
      private int limit;
      
      a(InputStream paramInputStream, int paramInt)
      {
        super();
        this.limit = paramInt;
      }
      
      public final int available()
      {
        return Math.min(super.available(), this.limit);
      }
      
      public final int read()
      {
        int i;
        if (this.limit <= 0) {
          i = -1;
        }
        int j;
        do
        {
          return i;
          j = super.read();
          i = j;
        } while (j < 0);
        this.limit -= 1;
        return j;
      }
      
      public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        if (this.limit <= 0) {
          paramInt1 = -1;
        }
        do
        {
          return paramInt1;
          paramInt2 = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.limit));
          paramInt1 = paramInt2;
        } while (paramInt2 < 0);
        this.limit -= paramInt2;
        return paramInt2;
      }
      
      public final long skip(long paramLong)
      {
        paramLong = super.skip(Math.min(paramLong, this.limit));
        if (paramLong >= 0L) {
          this.limit = ((int)(this.limit - paramLong));
        }
        return paramLong;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.b
 * JD-Core Version:    0.7.0.1
 */