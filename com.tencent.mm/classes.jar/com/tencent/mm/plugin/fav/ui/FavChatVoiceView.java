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
import com.tencent.mm.hellhoundlib.b.b;
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
  private int dtc;
  private int duration;
  private boolean isRunning;
  private String path;
  private AlphaAnimation pym;
  private AnimationDrawable pyn;
  private n rtU;
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106623);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aPY();
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
    aPY();
    AppMethodBeat.o(106624);
  }
  
  private void aPY()
  {
    AppMethodBeat.i(106625);
    this.pym = new AlphaAnimation(0.1F, 1.0F);
    this.pym.setDuration(1000L);
    this.pym.setRepeatCount(-1);
    this.pym.setRepeatMode(2);
    this.pyn = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    this.pyn.setOneShot(false);
    this.pyn.setVisible(true, true);
    AppMethodBeat.o(106625);
  }
  
  public final void cx(String paramString, int paramInt)
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
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        String str = FavChatVoiceView.a(FavChatVoiceView.this);
        if (FavChatVoiceView.b(FavChatVoiceView.this).cfC()) {}
        for (localObject = "true";; localObject = "false")
        {
          ad.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, FavChatVoiceView.b(FavChatVoiceView.this).path });
          if ((!com.tencent.mm.s.a.cf(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.s.a.cd(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.s.a.ch(FavChatVoiceView.c(FavChatVoiceView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((!e.abf()) && (!bt.isNullOrNil(FavChatVoiceView.a(FavChatVoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((bt.bI(FavChatVoiceView.a(FavChatVoiceView.this), "").equals(FavChatVoiceView.b(FavChatVoiceView.this).path)) && (FavChatVoiceView.b(FavChatVoiceView.this).cfC())) {
          FavChatVoiceView.this.stopPlay();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
          FavChatVoiceView.d(FavChatVoiceView.this);
        }
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
    this.rtU = paramn;
    this.rtU.a(this);
    AppMethodBeat.o(106629);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(106628);
    ad.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.pym != null) && (this.pym.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pyn.stop();
    this.rtU.stopPlay();
    AppMethodBeat.o(106628);
  }
  
  public final void z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(106627);
    this.path = bt.bI(paramString1, "");
    this.dtc = paramInt;
    setText(paramString2);
    AppMethodBeat.o(106627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */