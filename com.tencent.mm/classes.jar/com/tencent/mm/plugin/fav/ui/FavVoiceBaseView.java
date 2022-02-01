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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int dkj;
  private int duration;
  private TextView omo;
  private ViewGroup orn;
  private TextView oro;
  private String path = "";
  private n qbm;
  private ImageButton qfK;
  private a qfL;
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean chS()
  {
    AppMethodBeat.i(106950);
    ad.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.qbm.chS();
    a locala = this.qfL;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.qfM.qfK.setImageResource(2131691385);
    locala.qfM.qfK.setContentDescription(locala.qfM.getContext().getResources().getString(2131755856));
    this.oro.setKeepScreenOn(false);
    AppMethodBeat.o(106950);
    return bool;
  }
  
  public final void cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(106951);
    ad.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.by(paramString, "").equals(this.path))
    {
      this.qfL.stop();
      this.oro.setKeepScreenOn(false);
      AppMethodBeat.o(106951);
      return;
    }
    this.oro.setKeepScreenOn(true);
    this.qfL.begin();
    AppMethodBeat.o(106951);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106947);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.qfL.isPaused) });
    if (this.qfL.isPaused) {
      this.qfL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106940);
          FavVoiceBaseView.f(FavVoiceBaseView.this).akk();
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
    this.qbm.stopPlay();
    this.qfL.stop();
    this.oro.setKeepScreenOn(false);
    AppMethodBeat.o(106952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106948);
    super.onFinishInflate();
    this.orn = ((ViewGroup)findViewById(2131306507));
    this.omo = ((TextView)findViewById(2131306505));
    this.oro = ((TextView)findViewById(2131306506));
    this.qfK = ((ImageButton)findViewById(2131306504));
    this.qfL = new a((byte)0);
    this.qfK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106941);
        if ((com.tencent.mm.r.a.ce(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cc(paramAnonymousView.getContext())))
        {
          AppMethodBeat.o(106941);
          return;
        }
        if ((!e.XG()) && (!bt.isNullOrNil(FavVoiceBaseView.g(FavVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(106941);
          return;
        }
        if (!bt.by(FavVoiceBaseView.g(FavVoiceBaseView.this), "").equals(FavVoiceBaseView.h(FavVoiceBaseView.this).path))
        {
          FavVoiceBaseView.i(FavVoiceBaseView.this);
          AppMethodBeat.o(106941);
          return;
        }
        if (FavVoiceBaseView.h(FavVoiceBaseView.this).bTK())
        {
          FavVoiceBaseView.this.chS();
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
    chS();
    AppMethodBeat.o(106953);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(106949);
    this.qbm = paramn;
    this.qbm.a(this);
    AppMethodBeat.o(106949);
  }
  
  final class a
    extends ap
  {
    int fVV;
    boolean isPaused;
    float oru;
    float orv;
    int orw;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void Ah(int paramInt)
    {
      AppMethodBeat.i(106942);
      this.isPaused = false;
      this.oru = b.mI(paramInt);
      this.orv = this.oru;
      this.orw = com.tencent.mm.cd.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.C(FavVoiceBaseView.this.getContext(), (int)this.oru));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131691385);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131755856));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.orw);
      AppMethodBeat.o(106942);
    }
    
    public final void akk()
    {
      AppMethodBeat.i(106945);
      this.fVV = ((int)((1.0F - this.orv / this.oru) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.orw)) + this.orw);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(m.C(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.orv), (int)this.oru)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.fVV);
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
      this.orv = Math.max(0.0F, this.orv - 0.256F);
      akk();
      if (this.orv <= 0.1F)
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
      Ah(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(106944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */