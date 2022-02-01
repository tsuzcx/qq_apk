package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public abstract interface a
{
  public abstract void a(int paramInt, Format paramFormat, long paramLong);
  
  public abstract void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean);
  
  public abstract void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void tG();
  
  public static final class a
  {
    public final a bkL;
    private final long bkM;
    public final Handler handler;
    
    public a(Handler paramHandler, a parama)
    {
      this(paramHandler, parama, (byte)0);
    }
    
    private a(Handler paramHandler, a parama, byte paramByte)
    {
      AppMethodBeat.i(195769);
      if (parama != null) {}
      for (paramHandler = (Handler)com.google.android.exoplayer2.i.a.checkNotNull(paramHandler);; paramHandler = null)
      {
        this.handler = paramHandler;
        this.bkL = parama;
        this.bkM = 0L;
        AppMethodBeat.o(195769);
        return;
      }
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3)
    {
      AppMethodBeat.i(92568);
      if (this.bkL != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92560);
            a.a.this.bkL.a(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), this.bkV);
            AppMethodBeat.o(92560);
          }
        });
      }
      AppMethodBeat.o(92568);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
    {
      AppMethodBeat.i(92570);
      if (this.bkL != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92561);
            a.a.this.bkL.b(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), paramLong5);
            AppMethodBeat.o(92561);
          }
        });
      }
      AppMethodBeat.o(92570);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5, IOException paramIOException, final boolean paramBoolean)
    {
      AppMethodBeat.i(92574);
      if (this.bkL != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92563);
            a.a.this.bkL.a(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), paramLong5, paramBoolean, this.bkY, this.bkZ, this.bla);
            AppMethodBeat.o(92563);
          }
        });
      }
      AppMethodBeat.o(92574);
    }
    
    public final void a(j paramj, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(195770);
      a(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(195770);
    }
    
    public final void a(j paramj, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(195772);
      a(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
      AppMethodBeat.o(195772);
    }
    
    public final void b(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
    {
      AppMethodBeat.i(92572);
      if (this.bkL != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92562);
            a.a.this.bkL.c(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), paramLong5);
            AppMethodBeat.o(92562);
          }
        });
      }
      AppMethodBeat.o(92572);
    }
    
    public final void b(j paramj, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(195771);
      b(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(195771);
    }
    
    public final void tH()
    {
      AppMethodBeat.i(92576);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(92565);
          a.a.this.bkL.tG();
          AppMethodBeat.o(92565);
        }
      });
      AppMethodBeat.o(92576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a
 * JD-Core Version:    0.7.0.1
 */