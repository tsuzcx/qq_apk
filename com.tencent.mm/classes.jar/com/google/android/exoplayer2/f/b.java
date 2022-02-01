package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.a;
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
    sb();
  }
  
  private f a(h paramh, i parami, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramh.aQU;
      localObject = b(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).limit(), paramBoolean);
      parami.a(paramh.timeUs, (d)localObject, paramh.aNc);
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
  
  public final void ak(long paramLong) {}
  
  protected abstract d b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b
 * JD-Core Version:    0.7.0.1
 */