package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.ui.base.aa;

public class FavVoiceBaseView
  extends LinearLayout
  implements o.a
{
  private o Aee;
  private ImageButton AiO;
  private a AiP;
  private int duration;
  private int hIY;
  private String path = "";
  private ViewGroup xCX;
  private TextView xCY;
  private TextView xxU;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void es(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    Log.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path))
    {
      this.AiP.stop();
      this.xCY.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.xCY.setKeepScreenOn(true);
    this.AiP.begin();
    AppMethodBeat.o(106951);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.AiP.isPaused) });
    if (this.AiP.isPaused) {
      this.AiP.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).bgE();
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
    this.Aee.stopPlay();
    this.AiP.stop();
    this.xCY.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.xCX = ((ViewGroup)findViewById(q.e.voice_player_progress_bg));
    this.xxU = ((TextView)findViewById(q.e.voice_player_length));
    this.xCY = ((TextView)findViewById(q.e.voice_player_progress));
    this.AiO = ((ImageButton)findViewById(q.e.voice_player_btn));
    this.AiP = new a((byte)0);
    this.AiO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((com.tencent.mm.n.a.dm(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dl(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dp(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
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
          if (FavVoiceBaseView.h(FavVoiceBaseView.this).dxE()) {
            FavVoiceBaseView.this.pausePlay();
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
    pausePlay();
    AppMethodBeat.o(106953);
  }
  
  public final boolean pausePlay()
  {
    AppMethodBeat.i(106950);
    Log.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.Aee.pausePlay();
    a locala = this.AiP;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.AiQ.AiO.setImageResource(q.h.voicepost_beginicon);
    locala.AiQ.AiO.setContentDescription(locala.AiQ.getContext().getResources().getString(q.i.app_play));
    this.xCY.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public void setVoiceHelper(o paramo)
  {
    AppMethodBeat.i(106949);
    this.Aee = paramo;
    this.Aee.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends MMHandler
  {
    boolean isPaused;
    int muX;
    float xDe;
    float xDf;
    int xDg;
    
    private a() {}
    
    private void hi(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.xDe = com.tencent.mm.plugin.fav.a.b.jh(paramInt);
      this.xDf = this.xDe;
      this.xDg = com.tencent.mm.cd.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.Q(FavVoiceBaseView.this.getContext(), (int)this.xDe));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(q.h.voicepost_beginicon);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(q.i.app_play));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.xDg);
      AppMethodBeat.o(106942);
    }
    
    public final void begin()
    {
      AppMethodBeat.i(106943);
      stop();
      this.isPaused = false;
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(q.h.voicepost_pauseicon);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(q.i.app_pause));
      sendEmptyMessage(4096);
      AppMethodBeat.o(106943);
    }
    
    public final void bgE()
    {
      AppMethodBeat.i(106945);
      this.muX = ((int)((1.0F - this.xDf / this.xDe) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.xDg)) + this.xDg);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.Q(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.xDf), (int)this.xDe)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.muX);
      AppMethodBeat.o(106945);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(106946);
      this.xDf = Math.max(0.0F, this.xDf - 0.256F);
      bgE();
      if (this.xDf <= 0.1F)
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
      hi(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */