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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"})
public final class LiveUIB
  extends MMActivity
{
  private final String TAG = "MicroMsg.LiveUIB";
  private LiveReplayVideoView gYn;
  private int gYo;
  private int gYp;
  
  public final int getLayoutId()
  {
    return 2131496335;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(212790);
    ad.i(this.TAG, "onCreate (" + hashCode() + ')');
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
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(3);
    this.gYp = getIntent().getIntExtra("FROM_SENCE", 2);
    paramBundle = g.gOr;
    if (g.ans().GOH) {}
    for (int i = 1;; i = 0)
    {
      this.gYo = i;
      this.gYn = ((LiveReplayVideoView)findViewById(2131307748));
      paramBundle = this.gYn;
      if (paramBundle != null) {
        paramBundle.setOnCloseClickListener((b)new LiveUIB.a(this));
      }
      paramBundle = this.gYn;
      if (paramBundle != null)
      {
        Object localObject1 = g.gOr;
        localObject1 = g.ans().GOF;
        Object localObject2 = paramBundle.hbm;
        if (localObject2 != null) {
          ((RedesignVideoPlayerSeekBar)localObject2).setIsPlay(true);
        }
        localObject2 = paramBundle.hbj;
        if (localObject2 != null) {
          ((v)localObject2).seekTo(0L);
        }
        localObject2 = paramBundle.hbj;
        if (localObject2 != null) {
          ((v)localObject2).aP(false);
        }
        paramBundle.hbp = false;
        localObject2 = paramBundle.titleTv;
        Context localContext = paramBundle.getContext();
        g localg = g.gOr;
        ((TextView)localObject2).setText((CharSequence)k.c(localContext, (CharSequence)g.ans().Gbw));
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
          localObject1 = new h(Uri.parse((String)localObject1), paramBundle.bwq, paramBundle.eventHandler, (com.google.android.exoplayer2.source.a)new LiveReplayVideoView.a(paramBundle));
          localObject2 = paramBundle.hbj;
          if (localObject2 != null) {
            ((v)localObject2).a((i)localObject1);
          }
          localObject1 = paramBundle.hbj;
          if (localObject1 != null) {
            ((v)localObject1).aP(true);
          }
          paramBundle.aqC();
        }
      }
      paramBundle = this.gYn;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVideoSeekBarDragCallback((d.g.a.a)new LiveUIB.b(this));
      AppMethodBeat.o(212790);
      return;
    }
    AppMethodBeat.o(212790);
  }
  
  public final void onDestroy()
  {
    long l2 = 0L;
    AppMethodBeat.i(212793);
    ad.i(this.TAG, "onDestroy (" + hashCode() + ')');
    Object localObject1 = this.gYn;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    int j;
    if (localObject1 != null)
    {
      localObject2 = g.gOr;
      localObject2 = g.anm();
      localObject3 = g.gOr;
      long l3 = g.ans().Fsa;
      localObject3 = g.gOr;
      localObject3 = g.ans().Gbw;
      localObject4 = g.gOr;
      localObject4 = g.anu();
      v localv = ((LiveReplayVideoView)localObject1).hbj;
      if (localv != null)
      {
        l1 = localv.getDuration();
        localObject1 = ((LiveReplayVideoView)localObject1).hbj;
        if (localObject1 != null) {
          l2 = ((v)localObject1).getCurrentPosition();
        }
        e.a((String)localObject2, l3, (String)localObject3, (String)localObject4, l1, l2);
      }
    }
    else
    {
      super.onDestroy();
      localObject1 = g.gOr;
      localObject1 = g.anm();
      localObject2 = g.gOr;
      l1 = g.ans().Fsa;
      localObject2 = g.gOr;
      localObject2 = g.ans().Gbw;
      localObject3 = g.gOr;
      localObject3 = g.anu();
      j = this.gYp;
      localObject4 = g.gOr;
      if (!g.ans().GOH) {
        break label319;
      }
    }
    label319:
    for (int i = 1;; i = 0)
    {
      e.a((String)localObject1, l1, (String)localObject2, (String)localObject3, j, i, this.gYo);
      localObject1 = this.gYn;
      if (localObject1 == null) {
        break label324;
      }
      ((LiveReplayVideoView)localObject1).hbr.removeCallbacks((Runnable)((LiveReplayVideoView)localObject1).hbt);
      localObject2 = ((LiveReplayVideoView)localObject1).hbj;
      if (localObject2 != null) {
        ((v)localObject2).release();
      }
      localObject2 = ((LiveReplayVideoView)localObject1).hbj;
      if (localObject2 != null) {
        ((v)localObject2).b((q.a)localObject1);
      }
      ((LiveReplayVideoView)localObject1).hbj = null;
      AppMethodBeat.o(212793);
      return;
      l1 = 0L;
      break;
    }
    label324:
    AppMethodBeat.o(212793);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(212794);
    ad.i(this.TAG, "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(212794);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(212792);
    ad.i(this.TAG, "onPause (" + hashCode() + ')');
    super.onPause();
    AppMethodBeat.o(212792);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212791);
    ad.i(this.TAG, "onResume (" + hashCode() + ')');
    super.onResume();
    AppMethodBeat.o(212791);
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