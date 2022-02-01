package com.tencent.mm.live.ui;

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
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.view.LiveReplayVideoView;
import com.tencent.mm.live.view.LiveReplayVideoView.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIB;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "fromSence", "", "liveReplayVideoView", "Lcom/tencent/mm/live/view/LiveReplayVideoView;", "mReplayStatusBegin", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "setWindowStyle", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveUIB
  extends MMActivity
{
  private final String TAG = "MicroMsg.LiveUIB";
  private LiveReplayVideoView nkW;
  private int nkX;
  private int nkY;
  
  public final int getLayoutId()
  {
    return b.f.live_replay_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(246298);
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
      getWindow().getDecorView().setSystemUiVisibility(1280);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(3);
    this.nkY = getIntent().getIntExtra("FROM_SENCE", 2);
    paramBundle = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.bie().aaNm) {}
    for (int i = 1;; i = 0)
    {
      this.nkX = i;
      this.nkW = ((LiveReplayVideoView)findViewById(b.e.live_replay_video_view));
      paramBundle = this.nkW;
      if (paramBundle != null) {
        paramBundle.setOnCloseClickListener((kotlin.g.a.b)new LiveUIB.a(this));
      }
      paramBundle = this.nkW;
      if (paramBundle != null)
      {
        Object localObject1 = com.tencent.mm.live.model.u.mZl;
        localObject1 = com.tencent.mm.live.model.u.bie().ZRm;
        Object localObject2 = paramBundle.nnr;
        if (localObject2 != null) {
          ((RedesignVideoPlayerSeekBar)localObject2).setIsPlay(true);
        }
        localObject2 = paramBundle.nno;
        if (localObject2 != null) {
          ((v)localObject2).seekTo(0L);
        }
        localObject2 = paramBundle.nno;
        if (localObject2 != null) {
          ((v)localObject2).bv(false);
        }
        paramBundle.nnu = false;
        localObject2 = paramBundle.titleTv;
        Context localContext = paramBundle.getContext();
        com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
        ((TextView)localObject2).setText((CharSequence)p.b(localContext, (CharSequence)com.tencent.mm.live.model.u.bie().Zqd));
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
          localObject1 = new h(Uri.parse((String)localObject1), paramBundle.cZG, paramBundle.eventHandler, (com.google.android.exoplayer2.source.b)new LiveReplayVideoView.a(paramBundle));
          localObject2 = paramBundle.nno;
          if (localObject2 != null) {
            ((v)localObject2).a((k)localObject1);
          }
          localObject1 = paramBundle.nno;
          if (localObject1 != null) {
            ((v)localObject1).bv(true);
          }
          paramBundle.blb();
        }
      }
      paramBundle = this.nkW;
      if (paramBundle != null) {
        paramBundle.setVideoSeekBarDragCallback((a)new b(this));
      }
      AppMethodBeat.o(246298);
      return;
    }
  }
  
  public final void onDestroy()
  {
    long l2 = 0L;
    AppMethodBeat.i(246328);
    Log.i(this.TAG, "onDestroy (" + hashCode() + ')');
    Object localObject1 = this.nkW;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    v localv;
    long l1;
    label124:
    int j;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.live.model.u.mZl;
      localObject2 = com.tencent.mm.live.model.u.bhZ();
      localObject3 = com.tencent.mm.live.model.u.mZl;
      long l3 = com.tencent.mm.live.model.u.bie().mMJ;
      localObject3 = com.tencent.mm.live.model.u.mZl;
      localObject3 = com.tencent.mm.live.model.u.bie().Zqd;
      localObject4 = com.tencent.mm.live.model.u.mZl;
      localObject4 = com.tencent.mm.live.model.u.big();
      localv = ((LiveReplayVideoView)localObject1).nno;
      if (localv == null)
      {
        l1 = 0L;
        localObject1 = ((LiveReplayVideoView)localObject1).nno;
        if (localObject1 != null) {
          break label312;
        }
        e.a((String)localObject2, l3, (String)localObject3, (String)localObject4, l1, l2);
      }
    }
    else
    {
      super.onDestroy();
      localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = com.tencent.mm.live.model.u.bhZ();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      l1 = com.tencent.mm.live.model.u.bie().mMJ;
      localObject2 = com.tencent.mm.live.model.u.mZl;
      localObject2 = com.tencent.mm.live.model.u.bie().Zqd;
      localObject3 = com.tencent.mm.live.model.u.mZl;
      localObject3 = com.tencent.mm.live.model.u.big();
      j = this.nkY;
      localObject4 = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.bie().aaNm) {
        break label322;
      }
    }
    label312:
    label322:
    for (int i = 1;; i = 0)
    {
      e.a((String)localObject1, l1, (String)localObject2, (String)localObject3, j, i, this.nkX);
      localObject1 = this.nkW;
      if (localObject1 != null)
      {
        ((LiveReplayVideoView)localObject1).nnw.removeCallbacks((Runnable)((LiveReplayVideoView)localObject1).nny);
        localObject2 = ((LiveReplayVideoView)localObject1).nno;
        if (localObject2 != null) {
          ((v)localObject2).release();
        }
        localObject2 = ((LiveReplayVideoView)localObject1).nno;
        if (localObject2 != null) {
          ((v)localObject2).b((q.a)localObject1);
        }
        ((LiveReplayVideoView)localObject1).nno = null;
      }
      AppMethodBeat.o(246328);
      return;
      l1 = localv.getDuration();
      break;
      l2 = ((v)localObject1).getCurrentPosition();
      break label124;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(246333);
    Log.i(this.TAG, "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(246333);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(246316);
    Log.i(this.TAG, "onPause (" + hashCode() + ')');
    super.onPause();
    AppMethodBeat.o(246316);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(246309);
    Log.i(this.TAG, "onResume (" + hashCode() + ')');
    super.onResume();
    AppMethodBeat.o(246309);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements a
  {
    b(LiveUIB paramLiveUIB)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIB
 * JD-Core Version:    0.7.0.1
 */