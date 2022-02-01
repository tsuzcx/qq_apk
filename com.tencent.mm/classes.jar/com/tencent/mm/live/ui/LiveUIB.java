package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.view.LiveReplayVideoView;
import com.tencent.mm.live.view.LiveReplayVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"})
public final class LiveUIB
  extends MMActivity
{
  private final String TAG = "MicroMsg.LiveUIB";
  private LiveReplayVideoView gED;
  private int gEE;
  private int gEF;
  
  public final int getLayoutId()
  {
    return 2131496335;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(190500);
    ac.i(this.TAG, "onCreate (" + hashCode() + ')');
    setTheme(2131820571);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      d.g.b.k.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      d.g.b.k.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      d.g.b.k.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(3);
    this.gEF = getIntent().getIntExtra("FROM_SENCE", 2);
    paramBundle = g.guG;
    if (g.akF().Ffd) {}
    for (int i = 1;; i = 0)
    {
      this.gEE = i;
      this.gED = ((LiveReplayVideoView)findViewById(2131307748));
      paramBundle = this.gED;
      if (paramBundle != null) {
        paramBundle.setOnCloseClickListener((b)new LiveUIB.a(this));
      }
      paramBundle = this.gED;
      if (paramBundle != null)
      {
        Object localObject1 = g.guG;
        localObject1 = g.akF().Ffb;
        Object localObject2 = paramBundle.gHC;
        if (localObject2 != null) {
          ((RedesignVideoPlayerSeekBar)localObject2).setIsPlay(true);
        }
        localObject2 = paramBundle.gHz;
        if (localObject2 != null) {
          ((v)localObject2).seekTo(0L);
        }
        localObject2 = paramBundle.gHz;
        if (localObject2 != null) {
          ((v)localObject2).aO(false);
        }
        paramBundle.gHF = false;
        localObject2 = paramBundle.titleTv;
        Context localContext = paramBundle.getContext();
        g localg = g.guG;
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)g.akF().Eud));
        paramBundle.setVisibility(0);
        localObject2 = (CharSequence)localObject1;
        if (localObject2 != null)
        {
          i = j;
          if (((CharSequence)localObject2).length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0)
        {
          localObject1 = new h(Uri.parse((String)localObject1), paramBundle.blV, paramBundle.eventHandler, (com.google.android.exoplayer2.source.a)new LiveReplayVideoView.a(paramBundle));
          localObject2 = paramBundle.gHz;
          if (localObject2 != null) {
            ((v)localObject2).a((i)localObject1);
          }
          localObject1 = paramBundle.gHz;
          if (localObject1 != null) {
            ((v)localObject1).aO(true);
          }
          paramBundle.anQ();
        }
      }
      paramBundle = this.gED;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVideoSeekBarDragCallback((d.g.a.a)new LiveUIB.b(this));
      AppMethodBeat.o(190500);
      return;
    }
    AppMethodBeat.o(190500);
  }
  
  public final void onDestroy()
  {
    long l2 = 0L;
    AppMethodBeat.i(190503);
    ac.i(this.TAG, "onDestroy (" + hashCode() + ')');
    Object localObject1 = this.gED;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    int j;
    if (localObject1 != null)
    {
      localObject2 = g.guG;
      localObject2 = g.akA();
      localObject3 = g.guG;
      long l3 = g.akF().DMV;
      localObject3 = g.guG;
      localObject3 = g.akF().Eud;
      localObject4 = g.guG;
      localObject4 = g.akH();
      v localv = ((LiveReplayVideoView)localObject1).gHz;
      if (localv != null)
      {
        l1 = localv.getDuration();
        localObject1 = ((LiveReplayVideoView)localObject1).gHz;
        if (localObject1 != null) {
          l2 = ((v)localObject1).getCurrentPosition();
        }
        e.a((String)localObject2, l3, (String)localObject3, (String)localObject4, l1, l2);
      }
    }
    else
    {
      super.onDestroy();
      localObject1 = g.guG;
      localObject1 = g.akA();
      localObject2 = g.guG;
      l1 = g.akF().DMV;
      localObject2 = g.guG;
      localObject2 = g.akF().Eud;
      localObject3 = g.guG;
      localObject3 = g.akH();
      j = this.gEF;
      localObject4 = g.guG;
      if (!g.akF().Ffd) {
        break label319;
      }
    }
    label319:
    for (int i = 1;; i = 0)
    {
      e.a((String)localObject1, l1, (String)localObject2, (String)localObject3, j, i, this.gEE);
      localObject1 = this.gED;
      if (localObject1 == null) {
        break label324;
      }
      ((LiveReplayVideoView)localObject1).gHH.removeCallbacks((Runnable)((LiveReplayVideoView)localObject1).gHJ);
      localObject2 = ((LiveReplayVideoView)localObject1).gHz;
      if (localObject2 != null) {
        ((v)localObject2).release();
      }
      localObject2 = ((LiveReplayVideoView)localObject1).gHz;
      if (localObject2 != null) {
        ((v)localObject2).b((q.a)localObject1);
      }
      ((LiveReplayVideoView)localObject1).gHz = null;
      AppMethodBeat.o(190503);
      return;
      l1 = 0L;
      break;
    }
    label324:
    AppMethodBeat.o(190503);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190504);
    ac.i(this.TAG, "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(190504);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(190502);
    ac.i(this.TAG, "onPause (" + hashCode() + ')');
    super.onPause();
    AppMethodBeat.o(190502);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(190501);
    ac.i(this.TAG, "onResume (" + hashCode() + ')');
    super.onResume();
    AppMethodBeat.o(190501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIB
 * JD-Core Version:    0.7.0.1
 */