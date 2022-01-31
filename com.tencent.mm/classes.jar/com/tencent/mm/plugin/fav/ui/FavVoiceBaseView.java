package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int cve;
  private int duration;
  private n muE;
  private ViewGroup myk;
  private TextView myl;
  private ImageButton mym;
  private TextView myn;
  private a myo;
  private String path = "";
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(74179);
    ab.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bo.bf(paramString, "").equals(this.path))
    {
      this.myo.stop();
      this.myl.setKeepScreenOn(false);
      AppMethodBeat.o(74179);
      return;
    }
    this.myl.setKeepScreenOn(true);
    this.myo.begin();
    AppMethodBeat.o(74179);
  }
  
  public final boolean bwB()
  {
    AppMethodBeat.i(74178);
    ab.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.muE.bwB();
    a locala = this.myo;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.myp.mym.setImageResource(2131232175);
    locala.myp.mym.setContentDescription(locala.myp.getContext().getResources().getString(2131297039));
    this.myl.setKeepScreenOn(false);
    AppMethodBeat.o(74178);
    return bool;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(74175);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.myo.isPaused) });
    if (this.myo.isPaused) {
      this.myo.postDelayed(new FavVoiceBaseView.1(this), 128L);
    }
    AppMethodBeat.o(74175);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(74180);
    ab.d("MicroMsg.FavVoiceBaseView", "stop play");
    this.muE.stopPlay();
    this.myo.stop();
    this.myl.setKeepScreenOn(false);
    AppMethodBeat.o(74180);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(74176);
    super.onFinishInflate();
    this.myk = ((ViewGroup)findViewById(2131824125));
    this.myn = ((TextView)findViewById(2131824124));
    this.myl = ((TextView)findViewById(2131824126));
    this.mym = ((ImageButton)findViewById(2131824123));
    this.myo = new a((byte)0);
    this.mym.setOnClickListener(new FavVoiceBaseView.2(this));
    AppMethodBeat.o(74176);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(74181);
    bwB();
    AppMethodBeat.o(74181);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(74177);
    this.muE = paramn;
    this.muE.a(this);
    AppMethodBeat.o(74177);
  }
  
  final class a
    extends ak
  {
    boolean isPaused;
    float myq;
    float myr;
    int mys;
    int myt;
    
    private a() {}
    
    @SuppressLint({"ResourceType"})
    private void vY(int paramInt)
    {
      AppMethodBeat.i(74170);
      this.isPaused = false;
      this.myq = b.hi(paramInt);
      this.myr = this.myq;
      this.myt = a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(j.C(FavVoiceBaseView.this.getContext(), (int)this.myq));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131232175);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131297039));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.myt);
      AppMethodBeat.o(74170);
    }
    
    public final void Vf()
    {
      AppMethodBeat.i(74173);
      this.mys = ((int)((1.0F - this.myr / this.myq) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.myt)) + this.myt);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(j.C(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.myr), (int)this.myq)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.mys);
      AppMethodBeat.o(74173);
    }
    
    @SuppressLint({"ResourceType"})
    public final void begin()
    {
      AppMethodBeat.i(74171);
      stop();
      this.isPaused = false;
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(2131232176);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(2131297021));
      sendEmptyMessage(4096);
      AppMethodBeat.o(74171);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(74174);
      this.myr = Math.max(0.0F, this.myr - 0.256F);
      Vf();
      if (this.myr <= 0.1F)
      {
        AppMethodBeat.o(74174);
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
      AppMethodBeat.o(74174);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(74172);
      this.isPaused = false;
      removeMessages(4096);
      vY(FavVoiceBaseView.d(FavVoiceBaseView.this));
      AppMethodBeat.o(74172);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */