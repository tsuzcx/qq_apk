package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class FavChatVoiceView
  extends TextView
  implements n.a
{
  private int bNM;
  private Context context;
  private int duration = -1;
  private boolean isRunning = false;
  private n kai;
  private AlphaAnimation kbs;
  private AnimationDrawable kbt;
  private String path = "";
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    aRd();
  }
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    aRd();
  }
  
  private void aRd()
  {
    this.kbs = new AlphaAnimation(0.1F, 1.0F);
    this.kbs.setDuration(1000L);
    this.kbs.setRepeatCount(-1);
    this.kbs.setRepeatMode(2);
    this.kbt = new AnimationDrawable();
    Drawable localDrawable = getResources().getDrawable(n.h.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(n.h.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(n.h.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    this.kbt.setOneShot(false);
    this.kbt.setVisible(true, true);
  }
  
  public final void bj(String paramString, int paramInt)
  {
    if (!this.path.equals(paramString)) {
      stopPlay();
    }
  }
  
  public final void onFinish()
  {
    stopPlay();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(new FavChatVoiceView.1(this));
  }
  
  public final void onPause()
  {
    stopPlay();
  }
  
  public void setVoiceHelper(n paramn)
  {
    this.kai = paramn;
    this.kai.a(this);
  }
  
  public final void stopPlay()
  {
    y.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.kbs != null) && (this.kbs.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(n.h.chatfrom_voice_playing_new), null, null, null);
    this.kbt.stop();
    this.kai.stopPlay();
  }
  
  public final void v(String paramString1, int paramInt, String paramString2)
  {
    this.path = bk.aM(paramString1, "");
    this.bNM = paramInt;
    setText(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */