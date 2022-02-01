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
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.view.LiveReplayVideoView;
import com.tencent.mm.live.view.LiveReplayVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"})
public final class LiveUIB
  extends MMActivity
{
  private LiveReplayVideoView Kyd;
  private int Kye;
  private int Kyf;
  private final String TAG = "MicroMsg.LiveUIB";
  
  public final int getLayoutId()
  {
    return 2131496326;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(203259);
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
    this.Kyf = getIntent().getIntExtra("FROM_SENCE", 2);
    paramBundle = f.rGw;
    if (f.eNG().Lzd) {}
    for (int i = 1;; i = 0)
    {
      this.Kye = i;
      this.Kyd = ((LiveReplayVideoView)findViewById(2131307665));
      paramBundle = this.Kyd;
      if (paramBundle != null) {
        paramBundle.setOnCloseClickListener((b)new LiveUIB.a(this));
      }
      paramBundle = this.Kyd;
      if (paramBundle != null)
      {
        Object localObject1 = f.rGw;
        localObject1 = f.eNG().Lzb;
        Object localObject2 = paramBundle.KAT;
        if (localObject2 != null) {
          ((RedesignVideoPlayerSeekBar)localObject2).setIsPlay(true);
        }
        localObject2 = paramBundle.vqg;
        if (localObject2 != null) {
          ((v)localObject2).seekTo(0L);
        }
        localObject2 = paramBundle.vqg;
        if (localObject2 != null) {
          ((v)localObject2).aO(false);
        }
        paramBundle.KAV = false;
        localObject2 = paramBundle.titleTv;
        Context localContext = paramBundle.getContext();
        f localf = f.rGw;
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)f.eNG().LwZ));
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
          localObject1 = new h(Uri.parse((String)localObject1), paramBundle.blq, paramBundle.eventHandler, (com.google.android.exoplayer2.source.a)new LiveReplayVideoView.a(paramBundle));
          localObject2 = paramBundle.vqg;
          if (localObject2 != null) {
            ((v)localObject2).a((j)localObject1);
          }
          localObject1 = paramBundle.vqg;
          if (localObject1 != null) {
            ((v)localObject1).aO(true);
          }
          paramBundle.fQC();
        }
      }
      paramBundle = this.Kyd;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVideoSeekBarDragCallback((d.g.a.a)new LiveUIB.b(this));
      AppMethodBeat.o(203259);
      return;
    }
    AppMethodBeat.o(203259);
  }
  
  public final void onDestroy()
  {
    long l2 = 0L;
    AppMethodBeat.i(203262);
    ad.i(this.TAG, "onDestroy (" + hashCode() + ')');
    Object localObject1 = this.Kyd;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    int j;
    if (localObject1 != null)
    {
      localObject2 = f.rGw;
      localObject2 = f.eNB();
      localObject3 = f.rGw;
      long l3 = f.eNG().LwA;
      localObject3 = f.rGw;
      localObject3 = f.eNG().LwZ;
      localObject4 = f.rGw;
      localObject4 = f.eNI();
      v localv = ((LiveReplayVideoView)localObject1).vqg;
      if (localv != null)
      {
        l1 = localv.getDuration();
        localObject1 = ((LiveReplayVideoView)localObject1).vqg;
        if (localObject1 != null) {
          l2 = ((v)localObject1).getCurrentPosition();
        }
        e.a((String)localObject2, l3, (String)localObject3, (String)localObject4, l1, l2);
      }
    }
    else
    {
      super.onDestroy();
      localObject1 = f.rGw;
      localObject1 = f.eNB();
      localObject2 = f.rGw;
      l1 = f.eNG().LwA;
      localObject2 = f.rGw;
      localObject2 = f.eNG().LwZ;
      localObject3 = f.rGw;
      localObject3 = f.eNI();
      j = this.Kyf;
      localObject4 = f.rGw;
      if (!f.eNG().Lzd) {
        break label319;
      }
    }
    label319:
    for (int i = 1;; i = 0)
    {
      e.a((String)localObject1, l1, (String)localObject2, (String)localObject3, j, i, this.Kye);
      localObject1 = this.Kyd;
      if (localObject1 == null) {
        break label324;
      }
      ((LiveReplayVideoView)localObject1).KAX.removeCallbacks((Runnable)((LiveReplayVideoView)localObject1).KAZ);
      localObject2 = ((LiveReplayVideoView)localObject1).vqg;
      if (localObject2 != null) {
        ((v)localObject2).release();
      }
      localObject2 = ((LiveReplayVideoView)localObject1).vqg;
      if (localObject2 != null) {
        ((v)localObject2).b((q.a)localObject1);
      }
      ((LiveReplayVideoView)localObject1).vqg = null;
      AppMethodBeat.o(203262);
      return;
      l1 = 0L;
      break;
    }
    label324:
    AppMethodBeat.o(203262);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(203263);
    ad.i(this.TAG, "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(203263);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203261);
    ad.i(this.TAG, "onPause (" + hashCode() + ')');
    super.onPause();
    AppMethodBeat.o(203261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203260);
    ad.i(this.TAG, "onResume (" + hashCode() + ')');
    super.onResume();
    AppMethodBeat.o(203260);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIB
 * JD-Core Version:    0.7.0.1
 */