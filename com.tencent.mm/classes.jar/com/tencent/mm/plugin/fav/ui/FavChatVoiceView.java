package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;

public class FavChatVoiceView
  extends TextView
  implements n.a
{
  private Context context;
  private int dkj;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation orc;
  private AnimationDrawable ord;
  private String path;
  private n qbm;
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106623);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(106623);
  }
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106624);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(106624);
  }
  
  private void aGa()
  {
    AppMethodBeat.i(106625);
    this.orc = new AlphaAnimation(0.1F, 1.0F);
    this.orc.setDuration(1000L);
    this.orc.setRepeatCount(-1);
    this.orc.setRepeatMode(2);
    this.ord = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    this.ord.setOneShot(false);
    this.ord.setVisible(true, true);
    AppMethodBeat.o(106625);
  }
  
  public final void cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(106630);
    if (!this.path.equals(paramString)) {
      stopPlay();
    }
    AppMethodBeat.o(106630);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(106631);
    stopPlay();
    AppMethodBeat.o(106631);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106626);
    super.onFinishInflate();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106622);
        String str2 = FavChatVoiceView.a(FavChatVoiceView.this);
        if (FavChatVoiceView.b(FavChatVoiceView.this).bTK()) {}
        for (String str1 = "true";; str1 = "false")
        {
          ad.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, FavChatVoiceView.b(FavChatVoiceView.this).path });
          if ((!com.tencent.mm.r.a.ce(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.r.a.cc(FavChatVoiceView.c(FavChatVoiceView.this)))) {
            break;
          }
          AppMethodBeat.o(106622);
          return;
        }
        if ((!e.XG()) && (!bt.isNullOrNil(FavChatVoiceView.a(FavChatVoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(106622);
          return;
        }
        if ((bt.by(FavChatVoiceView.a(FavChatVoiceView.this), "").equals(FavChatVoiceView.b(FavChatVoiceView.this).path)) && (FavChatVoiceView.b(FavChatVoiceView.this).bTK()))
        {
          FavChatVoiceView.this.stopPlay();
          AppMethodBeat.o(106622);
          return;
        }
        FavChatVoiceView.d(FavChatVoiceView.this);
        AppMethodBeat.o(106622);
      }
    });
    AppMethodBeat.o(106626);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(106632);
    stopPlay();
    AppMethodBeat.o(106632);
  }
  
  public void setVoiceHelper(n paramn)
  {
    AppMethodBeat.i(106629);
    this.qbm = paramn;
    this.qbm.a(this);
    AppMethodBeat.o(106629);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(106628);
    ad.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.orc != null) && (this.orc.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.ord.stop();
    this.qbm.stopPlay();
    AppMethodBeat.o(106628);
  }
  
  public final void z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(106627);
    this.path = bt.by(paramString1, "");
    this.dkj = paramInt;
    setText(paramString2);
    AppMethodBeat.o(106627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */