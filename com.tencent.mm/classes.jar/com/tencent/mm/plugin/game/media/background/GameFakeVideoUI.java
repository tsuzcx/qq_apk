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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.i;

@com.tencent.mm.ui.base.a(3)
public class GameFakeVideoUI
  extends MMActivity
  implements h.a
{
  int duration;
  TextView gUc;
  private RelativeLayout oGY;
  ImageView oGj;
  com.tencent.mm.ui.tools.e oGo;
  private h oHt;
  private av oHz;
  RelativeLayout tZs;
  private FakeVideoViewLayer tZt;
  private long tZu;
  private long tZv;
  private String videoPath;
  
  public GameFakeVideoUI()
  {
    AppMethodBeat.i(41198);
    this.oHz = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41195);
        if (GameFakeVideoUI.a(GameFakeVideoUI.this).isPlaying())
        {
          GameFakeVideoUI localGameFakeVideoUI = GameFakeVideoUI.this;
          int i = (int)(GameFakeVideoUI.a(GameFakeVideoUI.this).getCurrentPosition() - GameFakeVideoUI.b(GameFakeVideoUI.this)) / 1000;
          if ((localGameFakeVideoUI.gUc != null) && (localGameFakeVideoUI.duration > 0))
          {
            int j = localGameFakeVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localGameFakeVideoUI.gUc.setText(i + "\"");
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
    if ((this.oHt instanceof GameFakeVideoView)) {
      ((GameFakeVideoView)this.oHt).setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(41203);
  }
  
  public final int eT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41207);
    if ((this.oHt.isPlaying()) && (this.oHt.getCurrentPosition() >= this.tZv) && (this.tZv < this.oHt.getDuration()))
    {
      ad.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", new Object[] { Integer.valueOf(this.oHt.getCurrentPosition()), Long.valueOf(this.tZv), Long.valueOf(this.tZu) });
      this.oHt.d(this.tZu, true);
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
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", new Object[] { Long.valueOf(this.tZu) });
    this.oHt.p(this.tZu);
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
    if (com.tencent.mm.booter.a.Wt() != null) {
      com.tencent.mm.booter.a.Wt().Wv();
    }
    this.tZs = ((RelativeLayout)findViewById(2131306409));
    this.oGj = ((ImageView)findViewById(2131300336));
    this.oGY = ((RelativeLayout)findViewById(2131306392));
    this.gUc = ((TextView)findViewById(2131306332));
    this.oHt = new GameFakeVideoView(this);
    this.oHt.setVideoCallback(this);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(13);
    this.oGY.addView((View)this.oHt, paramBundle);
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
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    paramBundle = com.tencent.mm.plugin.recordvideo.background.e.avy(paramBundle);
    if ((paramBundle == null) || (paramBundle.dEG() == null))
    {
      setResult(102);
      finish();
      AppMethodBeat.o(41199);
      return;
    }
    this.videoPath = paramBundle.dEG().xyw;
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", new Object[] { this.videoPath });
    localObject = paramBundle.dEE();
    this.tZu = ((afy)localObject).startTime;
    this.tZv = ((afy)localObject).endTime;
    localObject = com.tencent.mm.plugin.recordvideo.background.a.xua;
    this.tZt = com.tencent.mm.plugin.recordvideo.background.a.fY(this);
    this.oGY.addView(this.tZt, new ViewGroup.LayoutParams(-1, -1));
    this.tZt.setFakeVideoInfo(paramBundle);
    this.oHt.setMute(this.tZt.xHG);
    this.oGY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(41194);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/background/GameFakeVideoUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        paramAnonymousView = GameFakeVideoUI.this;
        paramAnonymousView.oGo.a(paramAnonymousView.tZs, paramAnonymousView.oGj, new GameFakeVideoUI.3(paramAnonymousView), null);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/media/background/GameFakeVideoUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(41194);
        return true;
      }
    });
    this.oGo = new com.tencent.mm.ui.tools.e(this);
    AppMethodBeat.o(41199);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41202);
    this.oHt.stop();
    this.tZt.dHl();
    this.oHz.stopTimer();
    super.onDestroy();
    AppMethodBeat.o(41202);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41204);
    setResult(0);
    this.oHt.stop();
    ad.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(41204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41201);
    this.oHt.pause();
    this.tZt.dHk();
    super.onPause();
    setKeepScreenOn(false);
    f.e(false, true, true);
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
      f.e(true, true, true);
      AppMethodBeat.o(41200);
      return;
      label67:
      if (!i.fv(str))
      {
        ad.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { str });
        setResult(0);
        finish();
      }
      else
      {
        this.oHt.setVideoPath(str);
        this.tZt.pW(false);
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
    this.oHt.start();
    this.duration = ((int)(this.tZv - this.tZu) / 1000);
    this.oHz.az(500L, 500L);
    this.oHt.p(this.tZu);
    ad.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(41205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.GameFakeVideoUI
 * JD-Core Version:    0.7.0.1
 */