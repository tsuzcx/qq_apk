package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.h.t.f;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$c
  implements f.a
{
  private b$c(b paramb) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(139952);
    ab.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "onPlayError, ExoPlaybackException", new Object[0]);
    if (this.bIP.yb()) {
      b.a(this.bIP, false);
    }
    Object localObject = null;
    if (parame != null)
    {
      i = 0;
      int j;
      while ((parame instanceof e))
      {
        Throwable localThrowable = parame.getCause();
        j = ((e)parame).type + 100;
        i = j;
        if (j == 1) {
          i = j + ((e)parame).avt;
        }
        localObject = localThrowable;
        parame = localThrowable;
      }
      if (localObject != null)
      {
        if ((localObject instanceof s.c))
        {
          j = i - 4000;
          if (localObject.toString().contains("Unable to connect"))
          {
            boolean bool = c.isNetworkAvailable(this.bIP.zF);
            ab.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", localObject, "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + localObject.toString(), new Object[0]);
            if (!bool)
            {
              this.bIP.bN(j, -2);
              AppMethodBeat.o(139952);
              return;
            }
            this.bIP.bN(j, -3);
            AppMethodBeat.o(139952);
            return;
          }
          i = j;
          if (!(localObject instanceof s.e)) {
            break label504;
          }
          parame = localObject.toString();
          if (parame.contains("403"))
          {
            this.bIP.bN(j, -10);
            AppMethodBeat.o(139952);
            return;
          }
          if (parame.contains("404"))
          {
            this.bIP.bN(j, -11);
            AppMethodBeat.o(139952);
            return;
          }
          if (parame.contains("500"))
          {
            this.bIP.bN(j, -12);
            AppMethodBeat.o(139952);
            return;
          }
          if (parame.contains("502"))
          {
            this.bIP.bN(j, -13);
            AppMethodBeat.o(139952);
            return;
          }
          this.bIP.bN(j, -30);
          AppMethodBeat.o(139952);
          return;
        }
        if ((localObject instanceof q))
        {
          ab.i("MicroMsg.SameLayer.ExoMediaPlayer", c.yf());
          this.bIP.bN(i - 4001, -1);
          AppMethodBeat.o(139952);
          return;
        }
        if ((localObject instanceof IllegalStateException))
        {
          ab.i("MicroMsg.SameLayer.ExoMediaPlayer", c.yf());
          this.bIP.bN(i - 4002, -1);
          AppMethodBeat.o(139952);
          return;
        }
        if ((localObject instanceof b.a))
        {
          ab.i("MicroMsg.SameLayer.ExoMediaPlayer", c.yf());
          this.bIP.bN(i - 4003, -1);
          AppMethodBeat.o(139952);
          return;
        }
        if ((localObject instanceof t.f))
        {
          ab.i("MicroMsg.SameLayer.ExoMediaPlayer", c.yf());
          this.bIP.bN(i - 4004, -1);
          AppMethodBeat.o(139952);
          return;
        }
      }
    }
    int i = -4999;
    label504:
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", c.fG(30));
    this.bIP.bN(i, -1);
    AppMethodBeat.o(139952);
  }
  
  public final void aF(boolean paramBoolean)
  {
    AppMethodBeat.i(139950);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean) {
      b.a(this.bIP, true);
    }
    AppMethodBeat.o(139950);
  }
  
  public final void ai(int paramInt)
  {
    AppMethodBeat.i(139949);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(139949);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(139948);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + paramp.speed + ", " + paramp.pitch + "]");
    AppMethodBeat.o(139948);
  }
  
  public final void b(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(139951);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + paramBoolean + ", playbackState=" + paramInt);
    this.bIP.yd();
    AppMethodBeat.o(139951);
  }
  
  public final void na()
  {
    AppMethodBeat.i(139945);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
    AppMethodBeat.o(139945);
  }
  
  public final void nb()
  {
    AppMethodBeat.i(139947);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
    AppMethodBeat.o(139947);
  }
  
  public final void nc()
  {
    AppMethodBeat.i(139946);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
    AppMethodBeat.o(139946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */