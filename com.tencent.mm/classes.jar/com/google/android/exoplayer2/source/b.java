package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public abstract interface b
{
  public abstract void a(int paramInt, Format paramFormat, long paramLong);
  
  public abstract void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean);
  
  public abstract void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void vl();
  
  public static final class a
  {
    public final b bvb;
    private final long bvc;
    public final Handler handler;
    
    public a(Handler paramHandler, b paramb)
    {
      this(paramHandler, paramb, (byte)0);
    }
    
    private a(Handler paramHandler, b paramb, byte paramByte)
    {
      AppMethodBeat.i(196038);
      if (paramb != null) {}
      for (paramHandler = (Handler)a.checkNotNull(paramHandler);; paramHandler = null)
      {
        this.handler = paramHandler;
        this.bvb = paramb;
        this.bvc = 0L;
        AppMethodBeat.o(196038);
        return;
      }
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3)
    {
      AppMethodBeat.i(92568);
      if (this.bvb != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92560);
            b.a.this.bvb.a(paramj, paramInt2, paramFormat, b.a.a(b.a.this, paramLong1), b.a.a(b.a.this, paramLong3), this.bvl);
            AppMethodBeat.o(92560);
          }
        });
      }
      AppMethodBeat.o(92568);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
    {
      AppMethodBeat.i(92570);
      if (this.bvb != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92561);
            b.a.this.bvb.b(paramj, paramInt2, paramFormat, b.a.a(b.a.this, paramLong1), b.a.a(b.a.this, paramLong3), paramLong5);
            AppMethodBeat.o(92561);
          }
        });
      }
      AppMethodBeat.o(92570);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5, IOException paramIOException, final boolean paramBoolean)
    {
      AppMethodBeat.i(92574);
      if (this.bvb != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92563);
            b.a.this.bvb.a(paramj, paramInt2, paramFormat, b.a.a(b.a.this, paramLong1), b.a.a(b.a.this, paramLong3), paramLong5, paramBoolean, this.bvo, this.bvp, this.bvq);
            AppMethodBeat.o(92563);
          }
        });
      }
      AppMethodBeat.o(92574);
    }
    
    public final void a(j paramj, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(196039);
      a(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(196039);
    }
    
    public final void a(j paramj, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(196041);
      a(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
      AppMethodBeat.o(196041);
    }
    
    public final void b(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
    {
      AppMethodBeat.i(92572);
      if (this.bvb != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92562);
            b.a.this.bvb.c(paramj, paramInt2, paramFormat, b.a.a(b.a.this, paramLong1), b.a.a(b.a.this, paramLong3), paramLong5);
            AppMethodBeat.o(92562);
          }
        });
      }
      AppMethodBeat.o(92572);
    }
    
    public final void b(j paramj, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(196040);
      b(paramj, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(196040);
    }
    
    public final void vm()
    {
      AppMethodBeat.i(92576);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(92565);
          b.a.this.bvb.vl();
          AppMethodBeat.o(92565);
        }
      });
      AppMethodBeat.o(92576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b
 * JD-Core Version:    0.7.0.1
 */