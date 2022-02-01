package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;

public class FavVoiceBaseView
  extends LinearLayout
  implements o.a
{
  private int duration;
  private int fEi;
  private String path = "";
  private TextView urz;
  private ViewGroup uwy;
  private TextView uwz;
  private o wHQ;
  private ImageButton wMr;
  private a wMs;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    Log.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path))
    {
      this.wMs.stop();
      this.uwz.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.uwz.setKeepScreenOn(true);
    this.wMs.begin();
    AppMethodBeat.o(106951);
  }
  
  public final boolean djP()
  {
    AppMethodBeat.i(106950);
    Log.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.wHQ.djP();
    a locala = this.wMs;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.wMt.wMr.setImageResource(s.h.voicepost_beginicon);
    locala.wMt.wMr.setContentDescription(locala.wMt.getContext().getResources().getString(s.i.app_play));
    this.uwz.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.wMs.isPaused) });
    if (this.wMs.isPaused) {
      this.wMs.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).aMU();
          AppMethodBeat.o(106940);
        }
      }, 128L);
    }
    AppMethodBeat.o(106947);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(106952);
    Log.d("MicroMsg.FavVoiceBaseView", "stop play");
    this.wHQ.stopPlay();
    this.wMs.stop();
    this.uwz.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.uwy = ((ViewGroup)findViewById(s.e.voice_player_progress_bg));
    this.urz = ((TextView)findViewById(s.e.voice_player_length));
    this.uwz = ((TextView)findViewById(s.e.voice_player_progress));
    this.wMr = ((ImageButton)findViewById(s.e.voice_player_btn));
    this.wMs = new a((byte)0);
    this.wMr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((com.tencent.mm.q.a.cy(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cw(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cB(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.avA()) && (!Util.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          w.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if (!Util.nullAs(FavVoiceBaseView.g(FavVoiceBaseView.this), "").equals(FavVoiceBaseView.h(FavVoiceBaseView.this).path)) {
          FavVoiceBaseView.i(FavVoiceBaseView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
          if (FavVoiceBaseView.h(FavVoiceBaseView.this).cTl()) {
            FavVoiceBaseView.this.djP();
          } else if (!FavVoiceBaseView.j(FavVoiceBaseView.this)) {
            FavVoiceBaseView.i(FavVoiceBaseView.this);
          }
        }
      }
    });
    AppMethodBeat.o(106948);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(106953);
    djP();
    AppMethodBeat.o(106953);
  }
  
  public void setVoiceHelper(o paramo)
  {
    AppMethodBeat.i(106949);
    this.wHQ = paramo;
    this.wHQ.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends MMHandler
  {
    boolean isPaused;
    int jUG;
    float uwF;
    float uwG;
    int uwH;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void Jl(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.uwF = com.tencent.mm.plugin.fav.a.b.GW(paramInt);
      this.uwG = this.uwF;
      this.uwH = com.tencent.mm.ci.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.N(FavVoiceBaseView.this.getContext(), (int)this.uwF));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(s.h.voicepost_beginicon);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(s.i.app_play));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.uwH);
      AppMethodBeat.o(106942);
    }
    
    public final void aMU()
    {
      AppMethodBeat.i(106945);
      this.jUG = ((int)((1.0F - this.uwG / this.uwF) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.uwH)) + this.uwH);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.N(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.uwG), (int)this.uwF)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.jUG);
      AppMethodBeat.o(106945);
    }
    
    @SuppressLint({"ResourceType"})
    public final void begin()
    {
      AppMethodBeat.i(106943);
      stop();
      this.isPaused = false;
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(s.h.voicepost_pauseicon);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(s.i.app_pause));
      sendEmptyMessage(4096);
      AppMethodBeat.o(106943);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(106946);
      this.uwG = Math.max(0.0F, this.uwG - 0.256F);
      aMU();
      if (this.uwG <= 0.1F)
      {
        AppMethodBeat.o(106946);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(106946);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(106944);
      this.isPaused = false;
      removeMessages(4096);
      Jl(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */