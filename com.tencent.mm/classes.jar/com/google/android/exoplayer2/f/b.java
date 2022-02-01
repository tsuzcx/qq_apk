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
    if (this.aWs == this.aWq.length) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      paramString = this.aWq;
      int j = paramString.length;
      while (i < j)
      {
        paramString[i].dO(1024);
        i += 1;
      }
    }
  }
  
  private f a(h paramh, i parami, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramh.aIq;
      localObject = b(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).limit(), paramBoolean);
      parami.a(paramh.timeUs, (d)localObject, paramh.aSr);
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
  
  public final void al(long paramLong) {}
  
  protected abstract d b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b
 * JD-Core Version:    0.7.0.1
 */