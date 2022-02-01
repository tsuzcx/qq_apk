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
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int dhE;
  private int duration;
  private TextView oPO;
  private ViewGroup oUN;
  private TextView oUO;
  private String path = "";
  private n qJS;
  private ImageButton qOm;
  private a qOn;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean cpz()
  {
    AppMethodBeat.i(106950);
    ac.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.qJS.cpz();
    a locala = this.qOn;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.qOo.qOm.setImageResource(2131691385);
    locala.qOo.qOm.setContentDescription(locala.qOo.getContext().getResources().getString(2131755856));
    this.oUO.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public final void cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    ac.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bs.bG(paramString, "").equals(this.path))
    {
      this.qOn.stop();
      this.oUO.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.oUO.setKeepScreenOn(true);
    this.qOn.begin();
    AppMethodBeat.o(106951);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.qOn.isPaused) });
    if (this.qOn.isPaused) {
      this.qOn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).ajG();
          AppMethodBeat.o(106940);
        }
      }, 128L);
    }
    AppMethodBeat.o(106947);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(106952);
    ac.d("MicroMsg.FavVoiceBaseView", "stop play");
    this.qJS.stopPlay();
    this.qOn.stop();
    this.oUO.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.oUN = ((ViewGroup)findViewById(2131306507));
    this.oPO = ((TextView)findViewById(2131306505));
    this.oUO = ((TextView)findViewById(2131306506));
    this.qOm = ((ImageButton)findViewById(2131306504));
    this.qOn = new a((byte)0);
    this.qOm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        if ((com.tencent.mm.r.a.ci(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.ck(paramAnonymousView.getContext())))
        {
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.YD()) && (!bs.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(106941);
          return;
        }
        if (!bs.bG(FavVoiceBaseView.g(FavVoiceBaseView.this), "").equals(FavVoiceBaseView.h(FavVoiceBaseView.this).path))
        {
          FavVoiceBaseView.i(FavVoiceBaseView.this);
          AppMethodBeat.o(106941);
          return;
        }
        if (FavVoiceBaseView.h(FavVoiceBaseView.this).caY())
        {
          FavVoiceBaseView.this.cpz();
          AppMethodBeat.o(106941);
          return;
        }
        if (!FavVoiceBaseView.j(FavVoiceBaseView.this)) {
          FavVoiceBaseView.i(FavVoiceBaseView.this);
        }
        AppMethodBeat.o(106941);
      }
    });
    AppMethodBeat.o(106948);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(106953);
    cpz();
    AppMethodBeat.o(106953);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(106949);
    this.qJS = paramn;
    this.qJS.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends ao
  {
    int fZQ;
    boolean isPaused;
    float oUU;
    float oUV;
    int oUW;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void AZ(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.oUU = b.qw(paramInt);
      this.oUV = this.oUU;
      this.oUW = com.tencent.mm.cc.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.F(FavVoiceBaseView.this.getContext(), (int)this.oUU));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691385);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755856));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.oUW);
      AppMethodBeat.o(106942);
    }
    
    public final void ajG()
    {
      AppMethodBeat.i(106945);
      this.fZQ = ((int)((1.0F - this.oUV / this.oUU) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.oUW)) + this.oUW);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.F(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.oUV), (int)this.oUU)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.fZQ);
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
      this.oUV = Math.max(0.0F, this.oUV - 0.256F);
      ajG();
      if (this.oUV <= 0.1F)
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
      AZ(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */