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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;

public class FavChatVoiceView
  extends TextView
  implements n.a
{
  private Context context;
  private int dui;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation pEQ;
  private AnimationDrawable pER;
  private String path;
  private n rCg;
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106623);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aQx();
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
    aQx();
    AppMethodBeat.o(106624);
  }
  
  private void aQx()
  {
    AppMethodBeat.i(106625);
    this.pEQ = new AlphaAnimation(0.1F, 1.0F);
    this.pEQ.setDuration(1000L);
    this.pEQ.setRepeatCount(-1);
    this.pEQ.setRepeatMode(2);
    this.pER = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    this.pER.setOneShot(false);
    this.pER.setVisible(true, true);
    AppMethodBeat.o(106625);
  }
  
  public final void B(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(106627);
    this.path = bu.bI(paramString1, "");
    this.dui = paramInt;
    setText(paramString2);
    AppMethodBeat.o(106627);
  }
  
  public final void cB(String paramString, int paramInt)
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        String str = FavChatVoiceView.a(FavChatVoiceView.this);
        if (FavChatVoiceView.b(FavChatVoiceView.this).cgS()) {}
        for (localObject = "true";; localObject = "false")
        {
          ae.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, FavChatVoiceView.b(FavChatVoiceView.this).path });
          if ((!com.tencent.mm.r.a.ch(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.r.a.cf(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.r.a.cj(FavChatVoiceView.c(FavChatVoiceView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((!e.abo()) && (!bu.isNullOrNil(FavChatVoiceView.a(FavChatVoiceView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((bu.bI(FavChatVoiceView.a(FavChatVoiceView.this), "").equals(FavChatVoiceView.b(FavChatVoiceView.this).path)) && (FavChatVoiceView.b(FavChatVoiceView.this).cgS())) {
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
    this.rCg = paramn;
    this.rCg.a(this);
    AppMethodBeat.o(106629);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(106628);
    ae.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.pEQ != null) && (this.pEQ.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pER.stop();
    this.rCg.stopPlay();
    AppMethodBeat.o(106628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */