package com.tencent.mm.plugin.game.media.background;

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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.vfs.y;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements i.a
{
  RelativeLayout IAX;
  private FakeVideoViewLayer IAY;
  private long IAZ;
  private long IBa;
  int duration;
  TextView nhp;
  private String videoPath;
  ImageView wAT;
  com.tencent.mm.ui.tools.f wAY;
  private RelativeLayout wBI;
  private i wCd;
  private MTimerHandler wCj;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.nhp != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.nhp.setText(i + "\"");
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
    if ((this.wCd instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.wCd).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(41205);
    setResult(-1);
    this.wCd.start();
    this.duration = ((int)(this.IBa - this.IAZ) / 1000);
    this.wCj.startTimer(500L);
    this.wCd.H(this.IAZ);
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
  
  public final void fG(int paramInt1, int paramInt2) {}
  
  public int getLayoutId()
  {
    return h.f.HZj;
  }
  
  public final int gw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.wCd.isPlaying()) && (this.wCd.getCurrentPosition() >= this.IBa) && (this.IBa < this.wCd.getDuration()))
    {
      Log.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.wCd.getCurrentPosition()), Long.valueOf(this.IBa), Long.valueOf(this.IAZ) });
      this.wCd.c(this.IAZ, true);
    }
    AppMethodBeat.o(41207);
    return 0;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(41206);
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.IAZ) });
    this.wCd.H(this.IAZ);
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
    if (com.tencent.mm.booter.a.aKj() != null) {
      com.tencent.mm.booter.a.aKj().aKl();
    }
    this.IAX = ((RelativeLayout)findViewById(h.e.video_ui_root));
    this.wAT = ((ImageView)findViewById(h.e.gallery_bg));
    this.wBI = ((RelativeLayout)findViewById(h.e.video_root));
    this.nhp = ((TextView)findViewById(h.e.video_duration));
    this.wCd = new GameFakeVideoView(this);
    this.wCd.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.wBI.addView((View)this.wCd, paramBundle);
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
    Object localObject = e.NDU;
    paramBundle = e.aSP(paramBundle);
    if ((paramBundle == null) || (paramBundle.gGF() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.gGF().NId;
    Log.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.gGD();
    this.IAZ = ((ami)localObject).startTime;
    this.IBa = ((ami)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.NDM;
    this.IAY = com.tencent.mm.plugin.recordvideo.background.a.jo(this);
    this.wBI.addView(this.IAY, new ViewGroup.LayoutParams(-1, -1));
    this.IAY.setFakeVideoInfo(paramBundle);
    this.wCd.setMute(this.IAY.NRY);
    this.wBI.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.wAY.a(paramAnonymousView.IAX, paramAnonymousView.wAT, new GameFakeVideoUI.3(paramAnonymousView), null);
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.wAY = new com.tencent.mm.ui.tools.f(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.wCd.stop();
    this.IAY.gJH();
    this.wCj.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.wCd.stop();
    Log.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.wCd.pause();
    this.IAY.gJG();
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
      if (!y.ZC(str))
      {
        Log.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.wCd.setVideoPath(str);
        this.IAY.Br(false);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */