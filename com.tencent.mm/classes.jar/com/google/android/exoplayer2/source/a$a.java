package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class a$a
{
  public final a aOG;
  private final long aOH;
  public final Handler handler;
  
  public a$a(Handler paramHandler, a parama)
  {
    this(paramHandler, parama, (byte)0);
  }
  
  private a$a(Handler paramHandler, a parama, byte paramByte)
  {
    AppMethodBeat.i(95435);
    if (parama != null) {}
    for (paramHandler = (Handler)com.google.android.exoplayer2.i.a.checkNotNull(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.aOG = parama;
      this.aOH = 0L;
      AppMethodBeat.o(95435);
      return;
    }
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(95436);
    if (this.aOG != null) {
      this.handler.post(new a.a.1(this, paramj, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3));
    }
    AppMethodBeat.o(95436);
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    AppMethodBeat.i(95438);
    if (this.aOG != null) {
      this.handler.post(new a.a.2(this, paramj, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
    AppMethodBeat.o(95438);
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    AppMethodBeat.i(95442);
    if (this.aOG != null) {
      this.handler.post(new a.a.4(this, paramj, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramIOException, paramBoolean));
    }
    AppMethodBeat.o(95442);
  }
  
  public final void a(j paramj, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(95437);
    a(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(95437);
  }
  
  public final void a(j paramj, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
  {
    AppMethodBeat.i(95441);
    a(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
    AppMethodBeat.o(95441);
  }
  
  public final void b(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    AppMethodBeat.i(95440);
    if (this.aOG != null) {
      this.handler.post(new a.a.3(this, paramj, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
    AppMethodBeat.o(95440);
  }
  
  public final void b(j paramj, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(95439);
    b(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(95439);
  }
  
  public final void oR()
  {
    AppMethodBeat.i(95443);
    this.handler.post(new a.a.6(this));
    AppMethodBeat.o(95443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.7.0.1
 */