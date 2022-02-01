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
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.view.LiveReplayVideoView;
import com.tencent.mm.live.view.LiveReplayVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.a;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"})
public final class LiveUIB
  extends MMActivity
{
  private final String TAG = "MicroMsg.LiveUIB";
  private LiveReplayVideoView hTU;
  private int hTV;
  private int hTW;
  
  public final int getLayoutId()
  {
    return 2131495275;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(208379);
    Log.i(this.TAG, "onCreate (" + hashCode() + ')');
    setTheme(2131820572);
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
    this.hTW = getIntent().getIntExtra("FROM_SENCE", 2);
    paramBundle = x.hJf;
    if (x.aGr().MnK) {}
    for (int i = 1;; i = 0)
    {
      this.hTV = i;
      this.hTU = ((LiveReplayVideoView)findViewById(2131303534));
      paramBundle = this.hTU;
      if (paramBundle != null) {
        paramBundle.setOnCloseClickListener((kotlin.g.a.b)new LiveUIB.a(this));
      }
      paramBundle = this.hTU;
      if (paramBundle != null)
      {
        Object localObject1 = x.hJf;
        localObject1 = x.aGr().MnI;
        Object localObject2 = paramBundle.hWM;
        if (localObject2 != null) {
          ((RedesignVideoPlayerSeekBar)localObject2).setIsPlay(true);
        }
        localObject2 = paramBundle.hWJ;
        if (localObject2 != null) {
          ((v)localObject2).seekTo(0L);
        }
        localObject2 = paramBundle.hWJ;
        if (localObject2 != null) {
          ((v)localObject2).aO(false);
        }
        paramBundle.hWP = false;
        localObject2 = paramBundle.titleTv;
        Context localContext = paramBundle.getContext();
        x localx = x.hJf;
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)x.aGr().LpF));
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
          localObject1 = new h(Uri.parse((String)localObject1), paramBundle.bwl, paramBundle.eventHandler, (com.google.android.exoplayer2.source.b)new LiveReplayVideoView.a(paramBundle));
          localObject2 = paramBundle.hWJ;
          if (localObject2 != null) {
            ((v)localObject2).a((k)localObject1);
          }
          localObject1 = paramBundle.hWJ;
          if (localObject1 != null) {
            ((v)localObject1).aO(true);
          }
          paramBundle.aJp();
        }
      }
      paramBundle = this.hTU;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVideoSeekBarDragCallback((a)new LiveUIB.b(this));
      AppMethodBeat.o(208379);
      return;
    }
    AppMethodBeat.o(208379);
  }
  
  public final void onDestroy()
  {
    long l2 = 0L;
    AppMethodBeat.i(208382);
    Log.i(this.TAG, "onDestroy (" + hashCode() + ')');
    Object localObject1 = this.hTU;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    int j;
    if (localObject1 != null)
    {
      localObject2 = x.hJf;
      localObject2 = x.aGm();
      localObject3 = x.hJf;
      long l3 = x.aGr().hyH;
      localObject3 = x.hJf;
      localObject3 = x.aGr().LpF;
      localObject4 = x.hJf;
      localObject4 = x.aGt();
      v localv = ((LiveReplayVideoView)localObject1).hWJ;
      if (localv != null)
      {
        l1 = localv.getDuration();
        localObject1 = ((LiveReplayVideoView)localObject1).hWJ;
        if (localObject1 != null) {
          l2 = ((v)localObject1).getCurrentPosition();
        }
        e.a((String)localObject2, l3, (String)localObject3, (String)localObject4, l1, l2);
      }
    }
    else
    {
      super.onDestroy();
      localObject1 = x.hJf;
      localObject1 = x.aGm();
      localObject2 = x.hJf;
      l1 = x.aGr().hyH;
      localObject2 = x.hJf;
      localObject2 = x.aGr().LpF;
      localObject3 = x.hJf;
      localObject3 = x.aGt();
      j = this.hTW;
      localObject4 = x.hJf;
      if (!x.aGr().MnK) {
        break label319;
      }
    }
    label319:
    for (int i = 1;; i = 0)
    {
      e.a((String)localObject1, l1, (String)localObject2, (String)localObject3, j, i, this.hTV);
      localObject1 = this.hTU;
      if (localObject1 == null) {
        break label324;
      }
      ((LiveReplayVideoView)localObject1).hWR.removeCallbacks((Runnable)((LiveReplayVideoView)localObject1).hWT);
      localObject2 = ((LiveReplayVideoView)localObject1).hWJ;
      if (localObject2 != null) {
        ((v)localObject2).release();
      }
      localObject2 = ((LiveReplayVideoView)localObject1).hWJ;
      if (localObject2 != null) {
        ((v)localObject2).b((q.a)localObject1);
      }
      ((LiveReplayVideoView)localObject1).hWJ = null;
      AppMethodBeat.o(208382);
      return;
      l1 = 0L;
      break;
    }
    label324:
    AppMethodBeat.o(208382);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(208383);
    Log.i(this.TAG, "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(208383);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(208381);
    Log.i(this.TAG, "onPause (" + hashCode() + ')');
    super.onPause();
    AppMethodBeat.o(208381);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(208380);
    Log.i(this.TAG, "onResume (" + hashCode() + ')');
    super.onResume();
    AppMethodBeat.o(208380);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIB
 * JD-Core Version:    0.7.0.1
 */