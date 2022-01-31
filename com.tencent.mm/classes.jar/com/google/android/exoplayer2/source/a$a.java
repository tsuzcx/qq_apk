package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import java.io.IOException;

public final class a$a
{
  public final a aHM;
  private final long aHN;
  public final Handler handler;
  
  public a$a(Handler paramHandler, a parama)
  {
    this(paramHandler, parama, (byte)0);
  }
  
  private a$a(Handler paramHandler, a parama, byte paramByte)
  {
    if (parama != null) {}
    for (paramHandler = (Handler)com.google.android.exoplayer2.i.a.E(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.aHM = parama;
      this.aHN = 0L;
      return;
    }
  }
  
  public final void a(i parami, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if (this.aHM != null) {
      this.handler.post(new a.a.2(this, parami, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
  }
  
  public final void a(i parami, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    if (this.aHM != null) {
      this.handler.post(new a.a.4(this, parami, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramIOException, paramBoolean));
    }
  }
  
  public final void a(i parami, long paramLong1, long paramLong2, long paramLong3)
  {
    a(parami, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
  }
  
  public final void a(i parami, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
  {
    a(parami, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
  }
  
  public final void b(i parami, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if (this.aHM != null) {
      this.handler.post(new a.a.3(this, parami, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
  }
  
  public final void b(i parami, long paramLong1, long paramLong2, long paramLong3)
  {
    b(parami, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
  }
  
  public final void mx()
  {
    this.handler.post(new a.a.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */