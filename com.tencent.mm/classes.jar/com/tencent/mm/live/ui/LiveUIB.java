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
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.view.LiveReplayVideoView;
import com.tencent.mm.live.view.LiveReplayVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"})
public final class LiveUIB
  extends MMActivity
{
  private final String TAG = "MicroMsg.LiveUIB";
  private LiveReplayVideoView kIt;
  private int kIu;
  private int kIv;
  
  public final int getLayoutId()
  {
    return b.f.live_replay_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(194361);
    Log.i(this.TAG, "onCreate (" + hashCode() + ')');
    setTheme(b.i.AppTheme_DarkMode_NoTitleTransparent);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(3);
    this.kIv = getIntent().getIntExtra("FROM_SENCE", 2);
    paramBundle = u.kwz;
    if (u.aOr().TyE) {}
    for (int i = 1;; i = 0)
    {
      this.kIu = i;
      this.kIt = ((LiveReplayVideoView)findViewById(b.e.live_replay_video_view));
      paramBundle = this.kIt;
      if (paramBundle != null) {
        paramBundle.setOnCloseClickListener((kotlin.g.a.b)new a(this));
      }
      paramBundle = this.kIt;
      if (paramBundle != null)
      {
        Object localObject1 = u.kwz;
        localObject1 = u.aOr().SMa;
        Object localObject2 = paramBundle.kLo;
        if (localObject2 != null) {
          ((RedesignVideoPlayerSeekBar)localObject2).setIsPlay(true);
        }
        localObject2 = paramBundle.kLl;
        if (localObject2 != null) {
          ((v)localObject2).seekTo(0L);
        }
        localObject2 = paramBundle.kLl;
        if (localObject2 != null) {
          ((v)localObject2).aM(false);
        }
        paramBundle.kLr = false;
        localObject2 = paramBundle.titleTv;
        Context localContext = paramBundle.getContext();
        u localu = u.kwz;
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)u.aOr().Srb));
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
          localObject1 = new h(Uri.parse((String)localObject1), paramBundle.bfN, paramBundle.eventHandler, (com.google.android.exoplayer2.source.b)new LiveReplayVideoView.a(paramBundle));
          localObject2 = paramBundle.kLl;
          if (localObject2 != null) {
            ((v)localObject2).a((k)localObject1);
          }
          localObject1 = paramBundle.kLl;
          if (localObject1 != null) {
            ((v)localObject1).aM(true);
          }
          paramBundle.aRn();
        }
      }
      paramBundle = this.kIt;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVideoSeekBarDragCallback((a)new b(this));
      AppMethodBeat.o(194361);
      return;
    }
    AppMethodBeat.o(194361);
  }
  
  public final void onDestroy()
  {
    long l2 = 0L;
    AppMethodBeat.i(194383);
    Log.i(this.TAG, "onDestroy (" + hashCode() + ')');
    Object localObject1 = this.kIt;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    int j;
    if (localObject1 != null)
    {
      localObject2 = u.kwz;
      localObject2 = u.aOm();
      localObject3 = u.kwz;
      long l3 = u.aOr().klE;
      localObject3 = u.kwz;
      localObject3 = u.aOr().Srb;
      localObject4 = u.kwz;
      localObject4 = u.aOt();
      v localv = ((LiveReplayVideoView)localObject1).kLl;
      if (localv != null)
      {
        l1 = localv.getDuration();
        localObject1 = ((LiveReplayVideoView)localObject1).kLl;
        if (localObject1 != null) {
          l2 = ((v)localObject1).getCurrentPosition();
        }
        e.a((String)localObject2, l3, (String)localObject3, (String)localObject4, l1, l2);
      }
    }
    else
    {
      super.onDestroy();
      localObject1 = u.kwz;
      localObject1 = u.aOm();
      localObject2 = u.kwz;
      l1 = u.aOr().klE;
      localObject2 = u.kwz;
      localObject2 = u.aOr().Srb;
      localObject3 = u.kwz;
      localObject3 = u.aOt();
      j = this.kIv;
      localObject4 = u.kwz;
      if (!u.aOr().TyE) {
        break label319;
      }
    }
    label319:
    for (int i = 1;; i = 0)
    {
      e.a((String)localObject1, l1, (String)localObject2, (String)localObject3, j, i, this.kIu);
      localObject1 = this.kIt;
      if (localObject1 == null) {
        break label324;
      }
      ((LiveReplayVideoView)localObject1).kLt.removeCallbacks((Runnable)((LiveReplayVideoView)localObject1).kLv);
      localObject2 = ((LiveReplayVideoView)localObject1).kLl;
      if (localObject2 != null) {
        ((v)localObject2).release();
      }
      localObject2 = ((LiveReplayVideoView)localObject1).kLl;
      if (localObject2 != null) {
        ((v)localObject2).b((q.a)localObject1);
      }
      ((LiveReplayVideoView)localObject1).kLl = null;
      AppMethodBeat.o(194383);
      return;
      l1 = 0L;
      break;
    }
    label324:
    AppMethodBeat.o(194383);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(194385);
    Log.i(this.TAG, "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(194385);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(194368);
    Log.i(this.TAG, "onPause (" + hashCode() + ')');
    super.onPause();
    AppMethodBeat.o(194368);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(194365);
    Log.i(this.TAG, "onResume (" + hashCode() + ')');
    super.onResume();
    AppMethodBeat.o(194365);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<View, x>
  {
    a(LiveUIB paramLiveUIB)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a
  {
    b(LiveUIB paramLiveUIB)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIB
 * JD-Core Version:    0.7.0.1
 */