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
  
  public abstract void ty();
  
  public static final class a
  {
    public final a bkg;
    private final long bkh;
    public final Handler handler;
    
    public a(Handler paramHandler, a parama)
    {
      this(paramHandler, parama, 0L);
    }
    
    public a(Handler paramHandler, a parama, long paramLong)
    {
      AppMethodBeat.i(92566);
      if (parama != null) {}
      for (paramHandler = (Handler)com.google.android.exoplayer2.i.a.checkNotNull(paramHandler);; paramHandler = null)
      {
        this.handler = paramHandler;
        this.bkg = parama;
        this.bkh = paramLong;
        AppMethodBeat.o(92566);
        return;
      }
    }
    
    public final void a(final int paramInt1, final Format paramFormat, final int paramInt2, final Object paramObject, final long paramLong)
    {
      AppMethodBeat.i(92575);
      if (this.bkg != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92564);
            a.a.this.bkg.a(paramInt1, paramFormat, a.a.a(a.a.this, paramLong));
            AppMethodBeat.o(92564);
          }
        });
      }
      AppMethodBeat.o(92575);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3)
    {
      AppMethodBeat.i(92568);
      if (this.bkg != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92560);
            a.a.this.bkg.a(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), this.bkq);
            AppMethodBeat.o(92560);
          }
        });
      }
      AppMethodBeat.o(92568);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
    {
      AppMethodBeat.i(92570);
      if (this.bkg != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92561);
            a.a.this.bkg.b(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), paramLong5);
            AppMethodBeat.o(92561);
          }
        });
      }
      AppMethodBeat.o(92570);
    }
    
    public final void a(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5, IOException paramIOException, final boolean paramBoolean)
    {
      AppMethodBeat.i(92574);
      if (this.bkg != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92563);
            a.a.this.bkg.a(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), paramLong5, paramBoolean, this.bkt, this.bku, this.bkv);
            AppMethodBeat.o(92563);
          }
        });
      }
      AppMethodBeat.o(92574);
    }
    
    public final void a(j paramj, int paramInt, long paramLong)
    {
      AppMethodBeat.i(92567);
      a(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong);
      AppMethodBeat.o(92567);
    }
    
    public final void a(j paramj, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(92569);
      a(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(92569);
    }
    
    public final void a(j paramj, int paramInt, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(92573);
      a(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
      AppMethodBeat.o(92573);
    }
    
    public final void b(final j paramj, final int paramInt1, final int paramInt2, final Format paramFormat, final int paramInt3, final Object paramObject, final long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
    {
      AppMethodBeat.i(92572);
      if (this.bkg != null) {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(92562);
            a.a.this.bkg.c(paramj, paramInt2, paramFormat, a.a.a(a.a.this, paramLong1), a.a.a(a.a.this, paramLong3), paramLong5);
            AppMethodBeat.o(92562);
          }
        });
      }
      AppMethodBeat.o(92572);
    }
    
    public final void b(j paramj, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(92571);
      b(paramj, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
      AppMethodBeat.o(92571);
    }
    
    public final void tz()
    {
      AppMethodBeat.i(92576);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(92565);
          a.a.this.bkg.ty();
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