package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, j.a
{
  private l contextMenuHelper;
  int duration;
  private boolean guh;
  private boolean isAnimated;
  private ProgressBar qaB;
  private MMHandler qaC;
  private Bundle qaD;
  private e qaE;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  private CardGiftInfo qay;
  private ImageView qaz;
  private RelativeLayout qbI;
  private j qbJ;
  private RelativeLayout qbK;
  private ImageView qbL;
  TextView qbM;
  private MMPinProgressBtn qbN;
  private TextView qbO;
  private MTimerHandler qbP;
  private String videoPath;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(113388);
    this.qaC = new MMHandler(Looper.getMainLooper());
    this.isAnimated = false;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.qbP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(113385);
        if (CardGiftVideoUI.e(CardGiftVideoUI.this).isPlaying())
        {
          CardGiftVideoUI localCardGiftVideoUI = CardGiftVideoUI.this;
          int i = CardGiftVideoUI.e(CardGiftVideoUI.this).getCurrentPosition() / 1000;
          if ((localCardGiftVideoUI.qbM != null) && (localCardGiftVideoUI.duration > 0))
          {
            int j = localCardGiftVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localCardGiftVideoUI.qbM.setText(i + "\"");
          }
        }
        AppMethodBeat.o(113385);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(113388);
  }
  
  private void ajI(String paramString)
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
    if (!com.tencent.mm.vfs.s.YS(paramString))
    {
      Log.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    this.qbJ.setVideoPath(paramString);
    AppMethodBeat.o(113390);
  }
  
  private void cvW()
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
    this.contextMenuHelper.a((VideoTextureView)this.qbJ, new View.OnCreateContextMenuListener()new o.g
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(113375);
        paramAnonymousContextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(2131757094));
        AppMethodBeat.o(113375);
      }
    }, new o.g()
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
          p.b(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.a(CardGiftVideoUI.this), new p.a()
          {
            public final void bP(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(201319);
              Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(2131767076, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
              com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(paramAnonymous2String2, CardGiftVideoUI.this.getContext());
              AppMethodBeat.o(201319);
            }
            
            public final void bQ(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(201320);
              Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(2131767075), 1).show();
              AppMethodBeat.o(201320);
            }
          });
        }
      }
    });
    AppMethodBeat.o(113391);
  }
  
  public final void ajH(String paramString) {}
  
  public final void cP(String paramString, final int paramInt)
  {
    AppMethodBeat.i(113402);
    if (paramString.equals(this.qay.pSq)) {
      this.qaC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113376);
          if (CardGiftVideoUI.h(CardGiftVideoUI.this) != null)
          {
            if (this.iZf == 0)
            {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
              AppMethodBeat.o(113376);
              return;
            }
            if (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 0) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(0);
            }
            Log.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.iZf) });
            if ((CardGiftVideoUI.h(CardGiftVideoUI.this).getMax() != this.iZf) && (this.iZf > 0)) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setMax(this.iZf);
            }
            CardGiftVideoUI.h(CardGiftVideoUI.this).setProgress(paramInt);
          }
          AppMethodBeat.o(113376);
        }
      });
    }
    AppMethodBeat.o(113402);
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(113398);
    this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
    this.qaE.a(this.qbI, this.qaz, new e.c()
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
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113397);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      cvQ();
      AppMethodBeat.o(113397);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113397);
    return bool;
  }
  
  public final void eo(int paramInt1, int paramInt2) {}
  
  public final int fh(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void fw(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113403);
    if (paramString1.equals(this.qay.pSq))
    {
      this.qaC.post(new Runnable()
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
    if (paramString1.equals(this.qay.pSr))
    {
      this.qaC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113378);
          if (Util.isNullOrNil(CardGiftVideoUI.a(CardGiftVideoUI.this)))
          {
            CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
            Object localObject = new c.a();
            ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
            q.bcW();
            ((c.a)localObject).jbw = null;
            ((c.a)localObject).fullPath = m.ajp(paramString2);
            ((c.a)localObject).jbi = 1;
            ((c.a)localObject).jbf = true;
            ((c.a)localObject).jbd = true;
            localObject = ((c.a)localObject).bdv();
            q.bcV().a(paramString2, CardGiftVideoUI.f(CardGiftVideoUI.this), (c)localObject);
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
  
  public int getLayoutId()
  {
    return 2131493373;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113392);
    this.qbI = ((RelativeLayout)findViewById(2131309840));
    this.qbK = ((RelativeLayout)findViewById(2131309821));
    this.qbL = ((ImageView)findViewById(2131309829));
    this.qbM = ((TextView)findViewById(2131309754));
    this.qbN = ((MMPinProgressBtn)findViewById(2131309808));
    this.qaB = ((ProgressBar)findViewById(2131309778));
    this.qbO = ((TextView)findViewById(2131309834));
    this.qbJ = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.qbJ.setMute(this.guh);
    this.qbJ.setVideoCallback(this);
    this.qbK.addView((View)this.qbJ, localLayoutParams);
    this.qaz = ((ImageView)findViewById(2131301854));
    this.qbI.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(113380);
        CardGiftVideoUI.this.cvQ();
        AppMethodBeat.o(113380);
        return true;
      }
    });
    ((View)this.qbJ).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        CardGiftVideoUI.this.cvQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113381);
      }
    });
    this.qaE = new e(this);
    AppMethodBeat.o(113392);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(113401);
    Log.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.qbJ.q(0.0D);
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
    this.qaD = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.akp() != null) {
      com.tencent.mm.booter.a.akp().akr();
    }
    this.qay = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.guh = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.qay == null) {}
    for (paramBundle = "null";; paramBundle = this.qay.toString())
    {
      Log.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      Log.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.guh) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      cvW();
      if (this.qay != null) {
        break;
      }
      Log.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(113389);
      return;
    }
    if (!Util.isNullOrNil(this.qay.pSq))
    {
      com.tencent.mm.plugin.card.d.a.g(this.qay.pSr, this.qay.pSu, this.qay.pSC, 2);
      com.tencent.mm.plugin.card.d.a.g(this.qay.pSq, this.qay.pSt, this.qay.pSB, 1);
      AppMethodBeat.o(113389);
      return;
    }
    Log.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(113389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113396);
    this.qbJ.stop();
    this.qbP.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(113396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113399);
    setResult(0);
    this.qbJ.stop();
    Log.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(113399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113395);
    this.qbJ.pause();
    super.onPause();
    AppMethodBeat.o(113395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113394);
    if (!Util.isNullOrNil(this.videoPath)) {
      ajI(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(113394);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113393);
    Bundle localBundle = this.qaD;
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
      this.qaF = getIntent().getIntExtra("img_top", 0);
      this.qaG = getIntent().getIntExtra("img_left", 0);
      this.qaH = getIntent().getIntExtra("img_width", 0);
      this.qaI = getIntent().getIntExtra("img_height", 0);
      this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
      if (localBundle == null) {
        this.qbI.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
  
  public final void tf()
  {
    AppMethodBeat.i(113400);
    setResult(-1);
    this.qaC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113386);
        Log.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.qbT) });
        if (this.qbT)
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
    this.qaC.post(new Runnable()
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
    this.qbJ.start();
    this.duration = (this.qbJ.getDuration() / 1000);
    this.qbP.startTimer(500L);
    Log.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(113400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */