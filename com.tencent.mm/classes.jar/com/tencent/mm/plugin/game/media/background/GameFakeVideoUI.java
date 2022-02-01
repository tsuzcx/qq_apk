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
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.i;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements h.a
{
  int duration;
  TextView gAs;
  ImageView ocQ;
  com.tencent.mm.ui.tools.e ocV;
  private RelativeLayout odF;
  private h odZ;
  private au oef;
  RelativeLayout tbC;
  private FakeVideoViewLayer tbD;
  private long tbE;
  private long tbF;
  private String videoPath;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.oef = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.gAs != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.gAs.setText(i + "\"");
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
    if ((this.odZ instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.odZ).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final void dZ(int paramInt1, int paramInt2) {}
  
  public final int eP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.odZ.isPlaying()) && (this.odZ.getCurrentPosition() >= this.tbF) && (this.tbF < this.odZ.getDuration()))
    {
      ac.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.odZ.getCurrentPosition()), Long.valueOf(this.tbF), Long.valueOf(this.tbE) });
      this.odZ.d(this.tbE, true);
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
    ac.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.tbE) });
    this.odZ.p(this.tbE);
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
    if (com.tencent.mm.booter.a.Uc() != null) {
      com.tencent.mm.booter.a.Uc().Ue();
    }
    this.tbC = ((RelativeLayout)findViewById(2131306409));
    this.ocQ = ((ImageView)findViewById(2131300336));
    this.odF = ((RelativeLayout)findViewById(2131306392));
    this.gAs = ((TextView)findViewById(2131306332));
    this.odZ = new GameFakeVideoView(this);
    this.odZ.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.odF.addView((View)this.odZ, paramBundle);
    paramBundle = getIntent().getStringExtra("game_bg_mix_fake_local_id");
    if ((paramBundle == null) || (!paramBundle.startsWith("weixin://bgmixid/")))
    {
      setResult(101);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    paramBundle = paramBundle.replace("weixin://bgmixid/", "");
    ac.i("MicroMsg.Haowan.GameFakeVideoUI", "bgMixTaskId:%s", new Object[] { paramBundle });
    Object localObject = g.wmx;
    paramBundle = g.aqy(paramBundle);
    if ((paramBundle == null) || (paramBundle.duk() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.duk().wqF;
    ac.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.dui();
    this.tbE = ((adp)localObject).startTime;
    this.tbF = ((adp)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.wme;
    this.tbD = com.tencent.mm.plugin.recordvideo.background.a.fT(this);
    this.odF.addView(this.tbD, new ViewGroup.LayoutParams(-1, -1));
    this.tbD.setFakeVideoInfo(paramBundle);
    this.odZ.setMute(this.tbD.wyv);
    this.odF.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.ocV.a(paramAnonymousView.tbC, paramAnonymousView.ocQ, new GameFakeVideoUI.3(paramAnonymousView), null);
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.ocV = new com.tencent.mm.ui.tools.e(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.odZ.stop();
    this.tbD.dwz();
    this.oef.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.odZ.stop();
    ac.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.odZ.pause();
    this.tbD.dwy();
    super.onPause();
    setKeepScreenOn(false);
    f.e(false, true, true);
    AppMethodBeat.o(41201);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41200);
    String str;
    if (!bs.isNullOrNil(this.videoPath))
    {
      str = this.videoPath;
      if (!bs.isNullOrNil(str)) {
        break label67;
      }
      ac.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is null, fail~!!!");
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
      if (!i.eA(str))
      {
        ac.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.odZ.setVideoPath(str);
        this.tbD.pA(false);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rB()
  {
    AppMethodBeat.i(41205);
    setResult(-1);
    this.odZ.start();
    this.duration = ((int)(this.tbF - this.tbE) / 1000);
    this.oef.au(500L, 500L);
    this.odZ.p(this.tbE);
    ac.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */