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
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int dui;
  private int duration;
  private TextView pAc;
  private ViewGroup pFb;
  private TextView pFc;
  private String path = "";
  private n rCg;
  private ImageButton rGw;
  private a rGx;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    ae.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bu.bI(paramString, "").equals(this.path))
    {
      this.rGx.stop();
      this.pFc.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.pFc.setKeepScreenOn(true);
    this.rGx.begin();
    AppMethodBeat.o(106951);
  }
  
  public final boolean cwF()
  {
    AppMethodBeat.i(106950);
    ae.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.rCg.cwF();
    a locala = this.rGx;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.rGy.rGw.setImageResource(2131691385);
    locala.rGy.rGw.setContentDescription(locala.rGy.getContext().getResources().getString(2131755856));
    this.pFc.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.rGx.isPaused) });
    if (this.rGx.isPaused) {
      this.rGx.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).amH();
          AppMethodBeat.o(106940);
        }
      }, 128L);
    }
    AppMethodBeat.o(106947);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(106952);
    ae.d("MicroMsg.FavVoiceBaseView", "stop play");
    this.rCg.stopPlay();
    this.rGx.stop();
    this.pFc.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.pFb = ((ViewGroup)findViewById(2131306507));
    this.pAc = ((TextView)findViewById(2131306505));
    this.pFc = ((TextView)findViewById(2131306506));
    this.rGw = ((ImageButton)findViewById(2131306504));
    this.rGx = new a((byte)0);
    this.rGw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((com.tencent.mm.r.a.ch(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cj(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.abo()) && (!bu.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if (!bu.bI(FavVoiceBaseView.g(FavVoiceBaseView.this), "").equals(FavVoiceBaseView.h(FavVoiceBaseView.this).path)) {
          FavVoiceBaseView.i(FavVoiceBaseView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
          if (FavVoiceBaseView.h(FavVoiceBaseView.this).cgS()) {
            FavVoiceBaseView.this.cwF();
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
    cwF();
    AppMethodBeat.o(106953);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(106949);
    this.rCg = paramn;
    this.rCg.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends aq
  {
    int gvT;
    boolean isPaused;
    float pFi;
    float pFj;
    int pFk;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void BT(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.pFi = com.tencent.mm.plugin.fav.a.b.sI(paramInt);
      this.pFj = this.pFi;
      this.pFk = com.tencent.mm.cb.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.G(FavVoiceBaseView.this.getContext(), (int)this.pFi));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691385);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755856));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.pFk);
      AppMethodBeat.o(106942);
    }
    
    public final void amH()
    {
      AppMethodBeat.i(106945);
      this.gvT = ((int)((1.0F - this.pFj / this.pFi) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.pFk)) + this.pFk);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.G(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.pFj), (int)this.pFi)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.gvT);
      AppMethodBeat.o(106945);
    }
    
    @SuppressLint({"ResourceType"})
    public final void begin()
    {
      AppMethodBeat.i(106943);
      stop();
      this.isPaused = false;
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691386);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755838));
      sendEmptyMessage(4096);
      AppMethodBeat.o(106943);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(106946);
      this.pFj = Math.max(0.0F, this.pFj - 0.256F);
      amH();
      if (this.pFj <= 0.1F)
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
      BT(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */