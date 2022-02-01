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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.o;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements h.a
{
  int duration;
  TextView gWL;
  ImageView oML;
  com.tencent.mm.ui.tools.e oMQ;
  private RelativeLayout oNA;
  private h oNV;
  private aw oOb;
  RelativeLayout uku;
  private FakeVideoViewLayer ukv;
  private long ukw;
  private long ukx;
  private String videoPath;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.oOb = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.gWL != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.gWL.setText(i + "\"");
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
    if ((this.oNV instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.oNV).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final int eU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.oNV.isPlaying()) && (this.oNV.getCurrentPosition() >= this.ukx) && (this.ukx < this.oNV.getDuration()))
    {
      ae.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.oNV.getCurrentPosition()), Long.valueOf(this.ukx), Long.valueOf(this.ukw) });
      this.oNV.d(this.ukw, true);
    }
    AppMethodBeat.o(41207);
    return 0;
  }
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  public int getLayoutId()
  {
    return 2131494296;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(41206);
    ae.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.ukw) });
    this.oNV.p(this.ukw);
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
    if (com.tencent.mm.booter.a.WB() != null) {
      com.tencent.mm.booter.a.WB().WD();
    }
    this.uku = ((RelativeLayout)findViewById(2131306409));
    this.oML = ((ImageView)findViewById(2131300336));
    this.oNA = ((RelativeLayout)findViewById(2131306392));
    this.gWL = ((TextView)findViewById(2131306332));
    this.oNV = new GameFakeVideoView(this);
    this.oNV.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.oNA.addView((View)this.oNV, paramBundle);
    paramBundle = getIntent().getStringExtra("game_bg_mix_fake_local_id");
    if ((paramBundle == null) || (!paramBundle.startsWith("weixin://bgmixid/")))
    {
      setResult(101);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    paramBundle = paramBundle.replace("weixin://bgmixid/", "");
    ae.i("MicroMsg.Haowan.GameFakeVideoUI", "bgMixTaskId:%s", new Object[] { paramBundle });
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.xKl;
    paramBundle = com.tencent.mm.plugin.recordvideo.background.e.awN(paramBundle);
    if ((paramBundle == null) || (paramBundle.dHX() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.dHX().xOs;
    ae.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.dHV();
    this.ukw = ((agh)localObject).startTime;
    this.ukx = ((agh)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.xJX;
    this.ukv = com.tencent.mm.plugin.recordvideo.background.a.ge(this);
    this.oNA.addView(this.ukv, new ViewGroup.LayoutParams(-1, -1));
    this.ukv.setFakeVideoInfo(paramBundle);
    this.oNV.setMute(this.ukv.xXB);
    this.oNA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/background/GameFakeVideoUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.oMQ.a(paramAnonymousView.uku, paramAnonymousView.oML, new GameFakeVideoUI.3(paramAnonymousView), null);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/media/background/GameFakeVideoUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.oMQ = new com.tencent.mm.ui.tools.e(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.oNV.stop();
    this.ukv.dKC();
    this.oOb.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.oNV.stop();
    ae.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.oNV.pause();
    this.ukv.dKB();
    super.onPause();
    setKeepScreenOn(false);
    f.e(false, true, true);
    AppMethodBeat.o(41201);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41200);
    String str;
    if (!bu.isNullOrNil(this.videoPath))
    {
      str = this.videoPath;
      if (!bu.isNullOrNil(str)) {
        break label67;
      }
      ae.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is null, fail~!!!");
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
      if (!o.fB(str))
      {
        ae.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.oNV.setVideoPath(str);
        this.ukv.qe(false);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(41205);
    setResult(-1);
    this.oNV.start();
    this.duration = ((int)(this.ukx - this.ukw) / 1000);
    this.oOb.ay(500L, 500L);
    this.oNV.p(this.ukw);
    ae.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */