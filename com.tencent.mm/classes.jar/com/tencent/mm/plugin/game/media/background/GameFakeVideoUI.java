package com.tencent.mm.plugin.game.media.background;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.vfs.u;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements k.a
{
  RelativeLayout CGN;
  private FakeVideoViewLayer CGO;
  private long CGP;
  private long CGQ;
  int duration;
  TextView kEb;
  com.tencent.mm.ui.tools.f twB;
  ImageView tww;
  private k txH;
  private MTimerHandler txN;
  private RelativeLayout txl;
  private String videoPath;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.kEb != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.kEb.setText(i + "\"");
          }
        }
        AppMethodBeat.o(41195);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(41198);
  }
  
  private void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(41203);
    if ((this.txH instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.txH).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final void eM(int paramInt1, int paramInt2) {}
  
  public final int fE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.txH.isPlaying()) && (this.txH.getCurrentPosition() >= this.CGQ) && (this.CGQ < this.txH.getDuration()))
    {
      Log.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.txH.getCurrentPosition()), Long.valueOf(this.CGQ), Long.valueOf(this.CGP) });
      this.txH.b(this.CGP, true);
    }
    AppMethodBeat.o(41207);
    return 0;
  }
  
  public int getLayoutId()
  {
    return g.f.Cnb;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(41206);
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.CGP) });
    this.txH.q(this.CGP);
    AppMethodBeat.o(41206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41199);
    super.onCreate(paramBundle);
    hideTitleView();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.aql() != null) {
      com.tencent.mm.booter.a.aql().aqn();
    }
    this.CGN = ((RelativeLayout)findViewById(g.e.video_ui_root));
    this.tww = ((ImageView)findViewById(g.e.gallery_bg));
    this.txl = ((RelativeLayout)findViewById(g.e.video_root));
    this.kEb = ((TextView)findViewById(g.e.video_duration));
    this.txH = new GameFakeVideoView(this);
    this.txH.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.txl.addView((View)this.txH, paramBundle);
    paramBundle = getIntent().getStringExtra("game_bg_mix_fake_local_id");
    if ((paramBundle == null) || (!paramBundle.startsWith("weixin://bgmixid/")))
    {
      setResult(101);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    paramBundle = paramBundle.replace("weixin://bgmixid/", "");
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "bgMixTaskId:%s", new Object[] { paramBundle });
    Object localObject = e.HGz;
    paramBundle = e.aVH(paramBundle);
    if ((paramBundle == null) || (paramBundle.fuP() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.fuP().HLf;
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.fuN();
    this.CGP = ((ajd)localObject).startTime;
    this.CGQ = ((ajd)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.HGl;
    this.CGO = com.tencent.mm.plugin.recordvideo.background.a.hN(this);
    this.txl.addView(this.CGO, new ViewGroup.LayoutParams(-1, -1));
    this.CGO.setFakeVideoInfo(paramBundle);
    this.txH.setMute(this.CGO.HVi);
    this.txl.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.twB.a(paramAnonymousView.CGN, paramAnonymousView.tww, new GameFakeVideoUI.3(paramAnonymousView), null);
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.twB = new com.tencent.mm.ui.tools.f(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.txH.stop();
    this.CGO.fxU();
    this.txN.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.txH.stop();
    Log.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.txH.pause();
    this.CGO.fxT();
    super.onPause();
    setKeepScreenOn(false);
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(41201);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41200);
    String str;
    if (!Util.isNullOrNil(this.videoPath))
    {
      str = this.videoPath;
      if (!Util.isNullOrNil(str)) {
        break label67;
      }
      Log.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
    }
    for (;;)
    {
      super.onResume();
      setKeepScreenOn(true);
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(41200);
      return;
      label67:
      if (!u.agG(str))
      {
        Log.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.txH.setVideoPath(str);
        this.CGO.wR(false);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qX()
  {
    AppMethodBeat.i(41205);
    setResult(-1);
    this.txH.start();
    this.duration = ((int)(this.CGQ - this.CGP) / 1000);
    this.txN.startTimer(500L);
    this.txH.q(this.CGP);
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */