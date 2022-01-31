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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class FavVoiceBaseView
  extends LinearLayout
  implements n.a
{
  private int bNM;
  private int duration;
  private n kai;
  private ViewGroup kdA;
  private TextView kdB;
  private ImageButton kdC;
  private TextView kdD;
  private a kdE;
  private String path = "";
  
  public FavVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean aQm()
  {
    y.i("MicroMsg.FavVoiceBaseView", "pause play");
    boolean bool = this.kai.aQm();
    a locala = this.kdE;
    locala.isPaused = true;
    locala.removeMessages(4096);
    locala.kdF.kdC.setImageResource(n.h.voicepost_beginicon);
    locala.kdF.kdC.setContentDescription(locala.kdF.getContext().getResources().getString(n.i.app_play));
    this.kdB.setKeepScreenOn(false);
    return bool;
  }
  
  public final void bj(String paramString, int paramInt)
  {
    y.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bk.aM(paramString, "").equals(this.path))
    {
      this.kdE.stop();
      this.kdB.setKeepScreenOn(false);
      return;
    }
    this.kdB.setKeepScreenOn(true);
    this.kdE.begin();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    y.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[] { Boolean.valueOf(this.kdE.isPaused) });
    if (this.kdE.isPaused) {
      this.kdE.postDelayed(new FavVoiceBaseView.1(this), 128L);
    }
  }
  
  public final void onFinish()
  {
    y.d("MicroMsg.FavVoiceBaseView", "stop play");
    this.kai.stopPlay();
    this.kdE.stop();
    this.kdB.setKeepScreenOn(false);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kdA = ((ViewGroup)findViewById(n.e.voice_player_progress_bg));
    this.kdD = ((TextView)findViewById(n.e.voice_player_length));
    this.kdB = ((TextView)findViewById(n.e.voice_player_progress));
    this.kdC = ((ImageButton)findViewById(n.e.voice_player_btn));
    this.kdE = new a((byte)0);
    this.kdC.setOnClickListener(new FavVoiceBaseView.2(this));
  }
  
  public final void onPause()
  {
    aQm();
  }
  
  public void setVoiceHelper(n paramn)
  {
    this.kai = paramn;
    this.kai.a(this);
  }
  
  private final class a
    extends ah
  {
    boolean isPaused;
    float kdG;
    float kdH;
    int kdI;
    int kdJ;
    
    private a() {}
    
    public final void aRr()
    {
      this.kdI = ((int)((1.0F - this.kdH / this.kdG) * (FavVoiceBaseView.e(FavVoiceBaseView.this).getWidth() - this.kdJ)) + this.kdJ);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(j.x(FavVoiceBaseView.this.getContext(), Math.min((int)Math.ceil(this.kdH), (int)this.kdG)));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.kdI);
    }
    
    @SuppressLint({"ResourceType"})
    public final void begin()
    {
      stop();
      this.isPaused = false;
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(n.h.voicepost_pauseicon);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(n.i.app_pause));
      sendEmptyMessage(4096);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      this.kdH = Math.max(0.0F, this.kdH - 0.256F);
      aRr();
      if (this.kdH <= 0.1F) {
        return;
      }
      sendEmptyMessageDelayed(4096, 256L);
    }
    
    public final void stop()
    {
      this.isPaused = false;
      removeMessages(4096);
      int i = FavVoiceBaseView.d(FavVoiceBaseView.this);
      this.isPaused = false;
      this.kdG = b.ck(i);
      this.kdH = this.kdG;
      this.kdJ = a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
      FavVoiceBaseView.a(FavVoiceBaseView.this).setText(j.x(FavVoiceBaseView.this.getContext(), (int)this.kdG));
      FavVoiceBaseView.b(FavVoiceBaseView.this).setImageResource(n.h.voicepost_beginicon);
      FavVoiceBaseView.b(FavVoiceBaseView.this).setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(n.i.app_play));
      FavVoiceBaseView.c(FavVoiceBaseView.this).setWidth(this.kdJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */