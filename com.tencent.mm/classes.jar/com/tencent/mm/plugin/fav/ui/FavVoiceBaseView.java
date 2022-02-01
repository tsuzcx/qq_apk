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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int dLt;
  private int duration;
  private String path = "";
  private TextView qPt;
  private ViewGroup qUs;
  private TextView qUt;
  private n tbL;
  private ImageButton tgc;
  private a tgd;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean cUJ()
  {
    AppMethodBeat.i(106950);
    Log.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.tbL.cUJ();
    a locala = this.tgd;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.tge.tgc.setImageResource(2131691719);
    locala.tge.tgc.setContentDescription(locala.tge.getContext().getResources().getString(2131755942));
    this.qUt.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public final void dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    Log.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path))
    {
      this.tgd.stop();
      this.qUt.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.qUt.setKeepScreenOn(true);
    this.tgd.begin();
    AppMethodBeat.o(106951);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.tgd.isPaused) });
    if (this.tgd.isPaused) {
      this.tgd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).aED();
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
    this.tbL.stopPlay();
    this.tgd.stop();
    this.qUt.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.qUs = ((ViewGroup)findViewById(2131309967));
    this.qPt = ((TextView)findViewById(2131309965));
    this.qUt = ((TextView)findViewById(2131309966));
    this.tgc = ((ImageButton)findViewById(2131309964));
    this.tgd = new a((byte)0);
    this.tgc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((com.tencent.mm.q.a.cC(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cA(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cE(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          u.g(paramAnonymousView.getContext(), null);
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
          if (FavVoiceBaseView.h(FavVoiceBaseView.this).cEF()) {
            FavVoiceBaseView.this.cUJ();
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
    cUJ();
    AppMethodBeat.o(106953);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(106949);
    this.tbL = paramn;
    this.tbL.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends MMHandler
  {
    int hiI;
    boolean isPaused;
    float qUA;
    int qUB;
    float qUz;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void FD(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.qUz = com.tencent.mm.plugin.fav.a.b.AO(paramInt);
      this.qUA = this.qUz;
      this.qUB = com.tencent.mm.cb.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.J(FavVoiceBaseView.this.getContext(), (int)this.qUz));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691719);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755942));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.qUB);
      AppMethodBeat.o(106942);
    }
    
    public final void aED()
    {
      AppMethodBeat.i(106945);
      this.hiI = ((int)((1.0F - this.qUA / this.qUz) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.qUB)) + this.qUB);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.J(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.qUA), (int)this.qUz)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.hiI);
      AppMethodBeat.o(106945);
    }
    
    @SuppressLint({"ResourceType"})
    public final void begin()
    {
      AppMethodBeat.i(106943);
      stop();
      this.isPaused = false;
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691720);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755924));
      sendEmptyMessage(4096);
      AppMethodBeat.o(106943);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(106946);
      this.qUA = Math.max(0.0F, this.qUA - 0.256F);
      aED();
      if (this.qUA <= 0.1F)
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
      FD(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */