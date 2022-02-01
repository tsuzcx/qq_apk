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
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.s;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements j.a
{
  int duration;
  TextView hPF;
  com.tencent.mm.ui.tools.e qaE;
  ImageView qaz;
  private j qbJ;
  private MTimerHandler qbP;
  private RelativeLayout qbo;
  private String videoPath;
  RelativeLayout xCN;
  private FakeVideoViewLayer xCO;
  private long xCP;
  private long xCQ;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.qbP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.hPF != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.hPF.setText(i + "\"");
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
    if ((this.qbJ instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.qbJ).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final void eo(int paramInt1, int paramInt2) {}
  
  public final int fh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.qbJ.isPlaying()) && (this.qbJ.getCurrentPosition() >= this.xCQ) && (this.xCQ < this.qbJ.getDuration()))
    {
      Log.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.qbJ.getCurrentPosition()), Long.valueOf(this.xCQ), Long.valueOf(this.xCP) });
      this.qbJ.d(this.xCP, true);
    }
    AppMethodBeat.o(41207);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131494858;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(41206);
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.xCP) });
    this.qbJ.q(this.xCP);
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
    if (com.tencent.mm.booter.a.akp() != null) {
      com.tencent.mm.booter.a.akp().akr();
    }
    this.xCN = ((RelativeLayout)findViewById(2131309840));
    this.qaz = ((ImageView)findViewById(2131301854));
    this.qbo = ((RelativeLayout)findViewById(2131309821));
    this.hPF = ((TextView)findViewById(2131309754));
    this.qbJ = new GameFakeVideoView(this);
    this.qbJ.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.qbo.addView((View)this.qbJ, paramBundle);
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
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    paramBundle = com.tencent.mm.plugin.recordvideo.background.e.aLf(paramBundle);
    if ((paramBundle == null) || (paramBundle.eIK() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.eIK().BOz;
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.eII();
    this.xCP = ((aio)localObject).startTime;
    this.xCQ = ((aio)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.BKb;
    this.xCO = com.tencent.mm.plugin.recordvideo.background.a.gN(this);
    this.qbo.addView(this.xCO, new ViewGroup.LayoutParams(-1, -1));
    this.xCO.setFakeVideoInfo(paramBundle);
    this.qbJ.setMute(this.xCO.BYt);
    this.qbo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.qaE.a(paramAnonymousView.xCN, paramAnonymousView.qaz, new GameFakeVideoUI.3(paramAnonymousView), null);
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.qaE = new com.tencent.mm.ui.tools.e(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.qbJ.stop();
    this.xCO.eLB();
    this.qbP.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.qbJ.stop();
    Log.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.qbJ.pause();
    this.xCO.eLA();
    super.onPause();
    setKeepScreenOn(false);
    f.e(false, true, true);
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
      f.e(true, true, true);
      AppMethodBeat.o(41200);
      return;
      label67:
      if (!s.YS(str))
      {
        Log.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.qbJ.setVideoPath(str);
        this.xCO.tv(false);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tf()
  {
    AppMethodBeat.i(41205);
    setResult(-1);
    this.qbJ.start();
    this.duration = ((int)(this.xCQ - this.xCP) / 1000);
    this.qbP.startTimer(500L);
    this.qbJ.q(this.xCP);
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */