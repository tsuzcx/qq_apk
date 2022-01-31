package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.a;

public class FavChatVoiceView
  extends TextView
  implements n.a
{
  private Context context;
  private int cve;
  private int duration;
  private boolean isRunning;
  private n muE;
  private AlphaAnimation mvO;
  private AnimationDrawable mvP;
  private String path;
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73938);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(73938);
  }
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73939);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(73939);
  }
  
  private void bxr()
  {
    AppMethodBeat.i(73940);
    this.mvO = new AlphaAnimation(0.1F, 1.0F);
    this.mvO.setDuration(1000L);
    this.mvO.setRepeatCount(-1);
    this.mvO.setRepeatMode(2);
    this.mvP = new a();
    Drawable localDrawable = getResources().getDrawable(2131231098);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231099);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231100);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    this.mvP.setOneShot(false);
    this.mvP.setVisible(true, true);
    AppMethodBeat.o(73940);
  }
  
  public final void bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(73945);
    if (!this.path.equals(paramString)) {
      stopPlay();
    }
    AppMethodBeat.o(73945);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(73946);
    stopPlay();
    AppMethodBeat.o(73946);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(73941);
    super.onFinishInflate();
    setOnClickListener(new FavChatVoiceView.1(this));
    AppMethodBeat.o(73941);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(73947);
    stopPlay();
    AppMethodBeat.o(73947);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(73944);
    this.muE = paramn;
    this.muE.a(this);
    AppMethodBeat.o(73944);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(73943);
    ab.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.mvO != null) && (this.mvO.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131231097), null, null, null);
    this.mvP.stop();
    this.muE.stopPlay();
    AppMethodBeat.o(73943);
  }
  
  public final void u(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(73942);
    this.path = bo.bf(paramString1, "");
    this.cve = paramInt;
    setText(paramString2);
    AppMethodBeat.o(73942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */