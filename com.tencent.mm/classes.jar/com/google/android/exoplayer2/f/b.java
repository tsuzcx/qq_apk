package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.g;
import java.nio.ByteBuffer;

public abstract class b
  extends g<h, i, f>
  implements e
{
  private final String name;
  
  protected b(String paramString)
  {
    super(new h[2], new i[2]);
    this.name = paramString;
    if (this.aBa == this.aAY.length) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      paramString = this.aAY;
      int j = paramString.length;
      while (i < j)
      {
        paramString[i].dd(1024);
        i += 1;
      }
    }
  }
  
  private f a(h paramh, i parami, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramh.aAS;
      localObject = c(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).limit(), paramBoolean);
      parami.a(paramh.aAT, (d)localObject, paramh.awY);
      parami.flags &= 0x7FFFFFFF;
      return null;
    }
    catch (f paramh) {}
    return paramh;
  }
  
  protected final void a(i parami)
  {
    super.a(parami);
  }
  
  public final void aa(long paramLong) {}
  
  protected abstract d c(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b
 * JD-Core Version:    0.7.0.1
 */