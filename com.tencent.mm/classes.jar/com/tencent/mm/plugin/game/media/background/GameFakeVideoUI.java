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
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.i;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements h.a
{
  int duration;
  TextView kuO;
  private RelativeLayout nAF;
  private h nAZ;
  private av nBf;
  ImageView nzQ;
  e nzV;
  RelativeLayout rTK;
  private FakeVideoViewLayer rTL;
  private long rTM;
  private long rTN;
  private String videoPath;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.nBf = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.kuO != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.kuO.setText(i + "\"");
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
    if ((this.nAZ instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.nAZ).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final void dY(int paramInt1, int paramInt2) {}
  
  public final int eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.nAZ.isPlaying()) && (this.nAZ.getCurrentPosition() >= this.rTN) && (this.rTN < this.nAZ.getDuration()))
    {
      ad.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.nAZ.getCurrentPosition()), Long.valueOf(this.rTN), Long.valueOf(this.rTM) });
      this.nAZ.d(this.rTM, true);
    }
    AppMethodBeat.o(41207);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131494296;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(41206);
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.rTM) });
    this.nAZ.q(this.rTM);
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
    if (com.tencent.mm.booter.a.Ti() != null) {
      com.tencent.mm.booter.a.Ti().Tk();
    }
    this.rTK = ((RelativeLayout)findViewById(2131306409));
    this.nzQ = ((ImageView)findViewById(2131300336));
    this.nAF = ((RelativeLayout)findViewById(2131306392));
    this.kuO = ((TextView)findViewById(2131306332));
    this.nAZ = new GameFakeVideoView(this);
    this.nAZ.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.nAF.addView((View)this.nAZ, paramBundle);
    paramBundle = getIntent().getStringExtra("game_bg_mix_fake_local_id");
    if ((paramBundle == null) || (!paramBundle.startsWith("weixin://bgmixid/")))
    {
      setResult(101);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    paramBundle = paramBundle.replace("weixin://bgmixid/", "");
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "bgMixTaskId:%s", new Object[] { paramBundle });
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    paramBundle = com.tencent.mm.plugin.recordvideo.background.f.alz(paramBundle);
    if ((paramBundle == null) || (paramBundle.dgC() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.dgC().vhT;
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.dgA();
    this.rTM = ((acq)localObject).startTime;
    this.rTN = ((acq)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.vdo;
    this.rTL = com.tencent.mm.plugin.recordvideo.background.a.fI(this);
    this.nAF.addView(this.rTL, new ViewGroup.LayoutParams(-1, -1));
    this.rTL.setFakeVideoInfo(paramBundle);
    this.nAZ.setMute(this.rTL.vpE);
    this.nAF.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.nzV.a(paramAnonymousView.rTK, paramAnonymousView.nzQ, new GameFakeVideoUI.3(paramAnonymousView), null);
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.nzV = new e(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.nAZ.stop();
    this.rTL.diG();
    this.nBf.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.nAZ.stop();
    ad.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.nAZ.pause();
    this.rTL.diF();
    super.onPause();
    setKeepScreenOn(false);
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(41201);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41200);
    String str;
    if (!bt.isNullOrNil(this.videoPath))
    {
      str = this.videoPath;
      if (!bt.isNullOrNil(str)) {
        break label67;
      }
      ad.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is null, fail~!!!");
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
      if (!i.eK(str))
      {
        ad.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.nAZ.setVideoPath(str);
        this.rTL.oC(false);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rq()
  {
    AppMethodBeat.i(41205);
    setResult(-1);
    this.nAZ.start();
    this.duration = ((int)(this.rTN - this.rTM) / 1000);
    this.nBf.av(500L, 500L);
    this.nAZ.q(this.rTM);
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */