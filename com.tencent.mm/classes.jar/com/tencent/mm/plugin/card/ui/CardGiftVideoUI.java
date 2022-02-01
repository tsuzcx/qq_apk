package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.y;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, i.a
{
  private l contextMenuHelper;
  int duration;
  private boolean isAnimated;
  private boolean lAj;
  private String videoPath;
  private CardGiftInfo wAS;
  private ImageView wAT;
  private ProgressBar wAV;
  private MMHandler wAW;
  private Bundle wAX;
  private f wAY;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  private RelativeLayout wCc;
  private i wCd;
  private RelativeLayout wCe;
  private ImageView wCf;
  TextView wCg;
  private MMPinProgressBtn wCh;
  private TextView wCi;
  private MTimerHandler wCj;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(113388);
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.isAnimated = false;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(113385);
        if (CardGiftVideoUI.e(CardGiftVideoUI.this).isPlaying())
        {
          CardGiftVideoUI localCardGiftVideoUI = CardGiftVideoUI.this;
          int i = CardGiftVideoUI.e(CardGiftVideoUI.this).getCurrentPosition() / 1000;
          if ((localCardGiftVideoUI.wCg != null) && (localCardGiftVideoUI.duration > 0))
          {
            int j = localCardGiftVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localCardGiftVideoUI.wCg.setText(i + "\"");
          }
        }
        AppMethodBeat.o(113385);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(113388);
  }
  
  private void ala(String paramString)
  {
    AppMethodBeat.i(113390);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    if (!y.ZC(paramString))
    {
      Log.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    this.wCd.setVideoPath(paramString);
    AppMethodBeat.o(113390);
  }
  
  private void dmP()
  {
    AppMethodBeat.i(113391);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(getContext());
    }
    if (Util.isNullOrNil(this.videoPath))
    {
      Log.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      AppMethodBeat.o(113391);
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.wCd, new View.OnCreateContextMenuListener()new u.i
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(113375);
        paramAnonymousContextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(a.g.wpq));
        AppMethodBeat.o(113375);
      }
    }, new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(113379);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(113379);
          return;
          ExportFileUtil.b(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.a(CardGiftVideoUI.this), new ExportFileUtil.a()
          {
            public final void cg(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(293809);
              Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(a.g.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
              t.refreshMediaScanner(paramAnonymous2String2, CardGiftVideoUI.this.getContext());
              AppMethodBeat.o(293809);
            }
            
            public final void ch(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(293810);
              Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(a.g.video_file_save_failed), 1).show();
              AppMethodBeat.o(293810);
            }
          });
        }
      }
    });
    AppMethodBeat.o(113391);
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(113400);
    setResult(-1);
    this.wAW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113386);
        Log.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.wCn) });
        if (this.wCn)
        {
          ((View)CardGiftVideoUI.e(CardGiftVideoUI.this)).setVisibility(0);
          CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(8);
          AppMethodBeat.o(113386);
          return;
        }
        ((View)CardGiftVideoUI.e(CardGiftVideoUI.this)).setVisibility(8);
        CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
        AppMethodBeat.o(113386);
      }
    });
    this.wAW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113387);
        Log.d("MicroMsg.CardGiftVideoUI", "hide loading.");
        if ((CardGiftVideoUI.g(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.g(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.g(CardGiftVideoUI.this).setVisibility(8);
        }
        if ((CardGiftVideoUI.h(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113387);
      }
    });
    this.wCd.start();
    this.duration = (this.wCd.getDuration() / 1000);
    this.wCj.startTimer(500L);
    Log.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(113400);
  }
  
  public final void akZ(String paramString) {}
  
  public final void dK(String paramString, final int paramInt)
  {
    AppMethodBeat.i(113402);
    if (paramString.equals(this.wAS.wsQ)) {
      this.wAW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113376);
          if (CardGiftVideoUI.h(CardGiftVideoUI.this) != null)
          {
            if (this.oIj == 0)
            {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
              AppMethodBeat.o(113376);
              return;
            }
            if (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 0) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(0);
            }
            Log.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oIj) });
            if ((CardGiftVideoUI.h(CardGiftVideoUI.this).getMax() != this.oIj) && (this.oIj > 0)) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setMax(this.oIj);
            }
            CardGiftVideoUI.h(CardGiftVideoUI.this).setProgress(paramInt);
          }
          AppMethodBeat.o(113376);
        }
      });
    }
    AppMethodBeat.o(113402);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113397);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      dmJ();
      AppMethodBeat.o(113397);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113397);
    return bool;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(113398);
    this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
    this.wAY.a(this.wCc, this.wAT, new f.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113384);
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(113383);
            CardGiftVideoUI.this.finish();
            CardGiftVideoUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(113383);
          }
        });
        AppMethodBeat.o(113384);
      }
      
      public final void onAnimationStart() {}
    }, null);
    AppMethodBeat.o(113398);
  }
  
  public final void fG(int paramInt1, int paramInt2) {}
  
  public int getLayoutId()
  {
    return a.e.wmG;
  }
  
  public final void gj(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113403);
    if (paramString1.equals(this.wAS.wsQ))
    {
      this.wAW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113377);
          CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(8);
          CardGiftVideoUI.a(CardGiftVideoUI.this, paramString2);
          CardGiftVideoUI.b(CardGiftVideoUI.this, CardGiftVideoUI.a(CardGiftVideoUI.this));
          CardGiftVideoUI.i(CardGiftVideoUI.this);
          AppMethodBeat.o(113377);
        }
      });
      AppMethodBeat.o(113403);
      return;
    }
    if (paramString1.equals(this.wAS.wsR))
    {
      this.wAW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113378);
          if (Util.isNullOrNil(CardGiftVideoUI.a(CardGiftVideoUI.this)))
          {
            CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
            Object localObject = new c.a();
            ((c.a)localObject).prefixPath = b.bmz();
            ((c.a)localObject).oKH = r.bKf();
            ((c.a)localObject).fullPath = m.akH(paramString2);
            ((c.a)localObject).oKs = 1;
            ((c.a)localObject).oKp = true;
            ((c.a)localObject).oKn = true;
            localObject = ((c.a)localObject).bKx();
            r.bKe().a(paramString2, CardGiftVideoUI.f(CardGiftVideoUI.this), (c)localObject);
          }
          AppMethodBeat.o(113378);
        }
      });
      AppMethodBeat.o(113403);
      return;
    }
    Log.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[] { paramString1 });
    AppMethodBeat.o(113403);
  }
  
  public final int gw(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113392);
    this.wCc = ((RelativeLayout)findViewById(a.d.video_ui_root));
    this.wCe = ((RelativeLayout)findViewById(a.d.video_root));
    this.wCf = ((ImageView)findViewById(a.d.video_thumb));
    this.wCg = ((TextView)findViewById(a.d.video_duration));
    this.wCh = ((MMPinProgressBtn)findViewById(a.d.video_progress));
    this.wAV = ((ProgressBar)findViewById(a.d.video_loading));
    this.wCi = ((TextView)findViewById(a.d.video_tips));
    this.wCd = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.wCd.setMute(this.lAj);
    this.wCd.setVideoCallback(this);
    this.wCe.addView((View)this.wCd, localLayoutParams);
    this.wAT = ((ImageView)findViewById(a.d.gallery_bg));
    this.wCc.setOnTouchListener(new CardGiftVideoUI.6(this));
    ((View)this.wCd).setOnClickListener(new CardGiftVideoUI.7(this));
    this.wAY = new f(this);
    AppMethodBeat.o(113392);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(113401);
    Log.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.wCd.H(0.0D);
    AppMethodBeat.o(113401);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113389);
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    hideTitleView();
    this.wAX = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.aKj() != null) {
      com.tencent.mm.booter.a.aKj().aKl();
    }
    this.wAS = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.lAj = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.wAS == null) {}
    for (paramBundle = "null";; paramBundle = this.wAS.toString())
    {
      Log.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      Log.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.lAj) });
      initView();
      com.tencent.mm.plugin.card.c.a.a(this);
      dmP();
      if (this.wAS != null) {
        break;
      }
      Log.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(113389);
      return;
    }
    if (!Util.isNullOrNil(this.wAS.wsQ))
    {
      com.tencent.mm.plugin.card.c.a.h(this.wAS.wsR, this.wAS.wsU, this.wAS.wtb, 2);
      com.tencent.mm.plugin.card.c.a.h(this.wAS.wsQ, this.wAS.wsT, this.wAS.wta, 1);
      AppMethodBeat.o(113389);
      return;
    }
    Log.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(113389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113396);
    this.wCd.stop();
    this.wCj.stopTimer();
    com.tencent.mm.plugin.card.c.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(113396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113399);
    setResult(0);
    this.wCd.stop();
    Log.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(113399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113395);
    this.wCd.pause();
    super.onPause();
    AppMethodBeat.o(113395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113394);
    if (!Util.isNullOrNil(this.videoPath)) {
      ala(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(113394);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113393);
    Bundle localBundle = this.wAX;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      Log.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113393);
      return;
      label63:
      this.wAZ = getIntent().getIntExtra("img_top", 0);
      this.wBa = getIntent().getIntExtra("img_left", 0);
      this.wBb = getIntent().getIntExtra("img_width", 0);
      this.wBc = getIntent().getIntExtra("img_height", 0);
      this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
      if (localBundle == null) {
        this.wCc.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(113382);
            CardGiftVideoUI.b(CardGiftVideoUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
            CardGiftVideoUI.d(CardGiftVideoUI.this).a(CardGiftVideoUI.b(CardGiftVideoUI.this), CardGiftVideoUI.c(CardGiftVideoUI.this), null);
            AppMethodBeat.o(113382);
            return true;
          }
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */