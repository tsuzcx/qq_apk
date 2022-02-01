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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int dtc;
  private int duration;
  private String path = "";
  private TextView pty;
  private ViewGroup pyx;
  private TextView pyy;
  private n rtU;
  private ImageButton ryl;
  private a rym;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean cve()
  {
    AppMethodBeat.i(106950);
    ad.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.rtU.cve();
    a locala = this.rym;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.ryn.ryl.setImageResource(2131691385);
    locala.ryn.ryl.setContentDescription(locala.ryn.getContext().getResources().getString(2131755856));
    this.pyy.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public final void cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    ad.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.bI(paramString, "").equals(this.path))
    {
      this.rym.stop();
      this.pyy.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.pyy.setKeepScreenOn(true);
    this.rym.begin();
    AppMethodBeat.o(106951);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.rym.isPaused) });
    if (this.rym.isPaused) {
      this.rym.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).ams();
          AppMethodBeat.o(106940);
        }
      }, 128L);
    }
    AppMethodBeat.o(106947);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(106952);
    ad.d("MicroMsg.FavVoiceBaseView", "stop play");
    this.rtU.stopPlay();
    this.rym.stop();
    this.pyy.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.pyx = ((ViewGroup)findViewById(2131306507));
    this.pty = ((TextView)findViewById(2131306505));
    this.pyy = ((TextView)findViewById(2131306506));
    this.ryl = ((ImageButton)findViewById(2131306504));
    this.rym = new a((byte)0);
    this.ryl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((com.tencent.mm.s.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.s.a.cd(paramAnonymousView.getContext())) || (com.tencent.mm.s.a.ch(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.abf()) && (!bt.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if (!bt.bI(FavVoiceBaseView.g(FavVoiceBaseView.this), "").equals(FavVoiceBaseView.h(FavVoiceBaseView.this).path)) {
          FavVoiceBaseView.i(FavVoiceBaseView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
          if (FavVoiceBaseView.h(FavVoiceBaseView.this).cfC()) {
            FavVoiceBaseView.this.cve();
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
    cve();
    AppMethodBeat.o(106953);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(106949);
    this.rtU = paramn;
    this.rtU.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends ap
  {
    int gtm;
    boolean isPaused;
    float pyE;
    float pyF;
    int pyG;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void BH(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.pyE = com.tencent.mm.plugin.fav.a.b.sv(paramInt);
      this.pyF = this.pyE;
      this.pyG = com.tencent.mm.cc.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.G(FavVoiceBaseView.this.getContext(), (int)this.pyE));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691385);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755856));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.pyG);
      AppMethodBeat.o(106942);
    }
    
    public final void ams()
    {
      AppMethodBeat.i(106945);
      this.gtm = ((int)((1.0F - this.pyF / this.pyE) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.pyG)) + this.pyG);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.G(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.pyF), (int)this.pyE)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.gtm);
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
      this.pyF = Math.max(0.0F, this.pyF - 0.256F);
      ams();
      if (this.pyF <= 0.1F)
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
      BH(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */