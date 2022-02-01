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
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;

public class FavChatVoiceView
  extends TextView
  implements o.a
{
  private o Aee;
  private boolean Uz;
  private Context context;
  private int duration;
  private int hIY;
  private String path;
  private AlphaAnimation xCM;
  private AnimationDrawable xCN;
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106623);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(106623);
  }
  
  public FavChatVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106624);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(106624);
  }
  
  private void bTa()
  {
    AppMethodBeat.i(106625);
    this.xCM = new AlphaAnimation(0.1F, 1.0F);
    this.xCM.setDuration(1000L);
    this.xCM.setRepeatCount(-1);
    this.xCM.setRepeatMode(2);
    this.xCN = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = getResources().getDrawable(q.h.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(q.h.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(q.h.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    this.xCN.setOneShot(false);
    this.xCN.setVisible(true, true);
    AppMethodBeat.o(106625);
  }
  
  public final void M(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(106627);
    this.path = Util.nullAs(paramString1, "");
    this.hIY = paramInt;
    setText(paramString2);
    AppMethodBeat.o(106627);
  }
  
  public final void es(String paramString, int paramInt)
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
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        String str = FavChatVoiceView.a(FavChatVoiceView.this);
        if (FavChatVoiceView.b(FavChatVoiceView.this).dxE()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, FavChatVoiceView.b(FavChatVoiceView.this).path });
          if ((!com.tencent.mm.n.a.dm(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.n.a.dl(FavChatVoiceView.c(FavChatVoiceView.this))) && (!com.tencent.mm.n.a.dp(FavChatVoiceView.c(FavChatVoiceView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(FavChatVoiceView.a(FavChatVoiceView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(106622);
          return;
        }
        if ((Util.nullAs(FavChatVoiceView.a(FavChatVoiceView.this), "").equals(FavChatVoiceView.b(FavChatVoiceView.this).path)) && (FavChatVoiceView.b(FavChatVoiceView.this).dxE())) {
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
  
  public void setVoiceHelper(o paramo)
  {
    AppMethodBeat.i(106629);
    this.Aee = paramo;
    this.Aee.a(this);
    AppMethodBeat.o(106629);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(106628);
    Log.d("MicroMsg.FavChatVoiceView", "stop play");
    if ((this.xCM != null) && (this.xCM.isInitialized())) {
      setAnimation(null);
    }
    this.Uz = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(q.h.chatfrom_voice_playing_new), null, null, null);
    this.xCN.stop();
    this.Aee.stopPlay();
    AppMethodBeat.o(106628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView
 * JD-Core Version:    0.7.0.1
 */