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
    RE();
  }
  
  private f a(h paramh, i parami, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramh.cKQ;
      localObject = b(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).limit(), paramBoolean);
      parami.a(paramh.timeUs, (d)localObject, paramh.cGY);
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
  
  protected abstract d b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
  
  public final void cy(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b
 * JD-Core Version:    0.7.0.1
 */