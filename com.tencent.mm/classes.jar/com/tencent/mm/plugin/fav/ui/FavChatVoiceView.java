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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class FavChatVoiceView
  extends TextView
  implements n.a
{
  private Context context;
  private int dLt;
  private int duration;
  private boolean isRunning;
  private String path;
  private AlphaAnimation qUh;
  private AnimationDrawable qUi;
  private n tbL;
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106623);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    blc();
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
    blc();
    AppMethodBeat.o(106624);
  }
  
  private void blc()
  {
    AppMethodBeat.i(106625);
    this.qUh = new AlphaAnimation(0.1F, 1.0F);
    this.qUh.setDuration(1000L);
    this.qUh.setRepeatCount(-1);
    this.qUh.setRepeatMode(2);
    this.qUi = new com.tencent.mm.ui.f.a();
    Drawable localDrawable = getResources().getDrawable(2131689907);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689908);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689909);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    this.qUi.setOneShot(false);
    this.qUi.setVisible(true, true);
    AppMethodBeat.o(106625);
  }
  
  public final void I(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(106627);
    this.path = Util.nullAs(paramString1, "");
    this.dLt = paramInt;
    setText(paramString2);
    AppMethodBeat.o(106627);
  }
  
  public final void dt(String paramString, int paramInt)
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
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        String str = FavChatVoiceView.a(FavChatVoiceView.this);
        if (FavChatVoiceView.b(FavChatVoiceView.this).cEF()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, FavChatVoiceView.b(FavChatVoiceView.this).path });
          if ((!com.tencent.mm.q.a.cC(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.q.a.cA(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.q.a.cE(FavChatVoiceView.c(FavChatVoiceView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(FavChatVoiceView.a(FavChatVoiceView.this))))
        {
          u.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((Util.nullAs(FavChatVoiceView.a(FavChatVoiceView.this), "").equals(FavChatVoiceView.b(FavChatVoiceView.this).path)) && (FavChatVoiceView.b(FavChatVoiceView.this).cEF())) {
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
    this.tbL = paramn;
    this.tbL.a(this);
    AppMethodBeat.o(106629);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(106628);
    Log.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.qUh != null) && (this.qUh.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689906), null, null, null);
    this.qUi.stop();
    this.tbL.stopPlay();
    AppMethodBeat.o(106628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */