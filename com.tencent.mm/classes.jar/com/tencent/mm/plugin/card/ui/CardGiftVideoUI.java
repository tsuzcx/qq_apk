package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.o;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, h.a
{
  private l contextMenuHelper;
  int duration;
  private boolean fOX;
  private boolean isAnimated;
  private CardGiftInfo oMK;
  private ImageView oML;
  private ProgressBar oMN;
  private aq oMO;
  private Bundle oMP;
  private e oMQ;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  private RelativeLayout oNU;
  private h oNV;
  private RelativeLayout oNW;
  private ImageView oNX;
  TextView oNY;
  private MMPinProgressBtn oNZ;
  private TextView oOa;
  private aw oOb;
  private String videoPath;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(113388);
    this.oMO = new aq(Looper.getMainLooper());
    this.isAnimated = false;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.oOb = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(113385);
        if (CardGiftVideoUI.e(CardGiftVideoUI.this).isPlaying())
        {
          CardGiftVideoUI localCardGiftVideoUI = CardGiftVideoUI.this;
          int i = CardGiftVideoUI.e(CardGiftVideoUI.this).getCurrentPosition() / 1000;
          if ((localCardGiftVideoUI.oNY != null) && (localCardGiftVideoUI.duration > 0))
          {
            int j = localCardGiftVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localCardGiftVideoUI.oNY.setText(i + "\"");
          }
        }
        AppMethodBeat.o(113385);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(113388);
  }
  
  private void ZD(String paramString)
  {
    AppMethodBeat.i(113390);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    if (!o.fB(paramString))
    {
      ae.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    this.oNV.setVideoPath(paramString);
    AppMethodBeat.o(113390);
  }
  
  private void bYg()
  {
    AppMethodBeat.i(113391);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(getContext());
    }
    if (bu.isNullOrNil(this.videoPath))
    {
      ae.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      AppMethodBeat.o(113391);
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.oNV, new View.OnCreateContextMenuListener()new n.e
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(113375);
        paramAnonymousContextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(2131756924));
        AppMethodBeat.o(113375);
      }
    }, new n.e()
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
          paramAnonymousMenuItem = u.Ib(CardGiftVideoUI.a(CardGiftVideoUI.this));
          if (bu.isNullOrNil(paramAnonymousMenuItem))
          {
            Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131764682), 1).show();
            AppMethodBeat.o(113379);
            return;
          }
          Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramAnonymousMenuItem) }), 1).show();
          com.tencent.mm.pluginsdk.ui.tools.q.k(paramAnonymousMenuItem, CardGiftVideoUI.this);
        }
      }
    });
    AppMethodBeat.o(113391);
  }
  
  public final void ZC(String paramString) {}
  
  public final void bYa()
  {
    AppMethodBeat.i(113398);
    this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
    this.oMQ.a(this.oNU, this.oML, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113384);
        new aq().post(new Runnable()
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
  
  public final void cJ(String paramString, final int paramInt)
  {
    AppMethodBeat.i(113402);
    if (paramString.equals(this.oMK.oEH)) {
      this.oMO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113376);
          if (CardGiftVideoUI.h(CardGiftVideoUI.this) != null)
          {
            if (this.iej == 0)
            {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
              AppMethodBeat.o(113376);
              return;
            }
            if (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 0) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(0);
            }
            ae.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.iej) });
            if ((CardGiftVideoUI.h(CardGiftVideoUI.this).getMax() != this.iej) && (this.iej > 0)) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setMax(this.iej);
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
      ae.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      bYa();
      AppMethodBeat.o(113397);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113397);
    return bool;
  }
  
  public final int eU(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void eb(int paramInt1, int paramInt2) {}
  
  public final void ff(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113403);
    if (paramString1.equals(this.oMK.oEH))
    {
      this.oMO.post(new Runnable()
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
    if (paramString1.equals(this.oMK.oEI))
    {
      this.oMO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113378);
          if (bu.isNullOrNil(CardGiftVideoUI.a(CardGiftVideoUI.this)))
          {
            CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
            Object localObject = new c.a();
            ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
            com.tencent.mm.av.q.aJc();
            ((c.a)localObject).igB = null;
            ((c.a)localObject).hgD = m.Zk(paramString2);
            ((c.a)localObject).ign = 1;
            ((c.a)localObject).igk = true;
            ((c.a)localObject).igi = true;
            localObject = ((c.a)localObject).aJu();
            com.tencent.mm.av.q.aJb().a(paramString2, CardGiftVideoUI.f(CardGiftVideoUI.this), (c)localObject);
          }
          AppMethodBeat.o(113378);
        }
      });
      AppMethodBeat.o(113403);
      return;
    }
    ae.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[] { paramString1 });
    AppMethodBeat.o(113403);
  }
  
  public int getLayoutId()
  {
    return 2131493284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113392);
    this.oNU = ((RelativeLayout)findViewById(2131306409));
    this.oNW = ((RelativeLayout)findViewById(2131306392));
    this.oNX = ((ImageView)findViewById(2131306398));
    this.oNY = ((TextView)findViewById(2131306332));
    this.oNZ = ((MMPinProgressBtn)findViewById(2131306379));
    this.oMN = ((ProgressBar)findViewById(2131306352));
    this.oOa = ((TextView)findViewById(2131306403));
    this.oNV = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.oNV.setMute(this.fOX);
    this.oNV.setVideoCallback(this);
    this.oNW.addView((View)this.oNV, localLayoutParams);
    this.oML = ((ImageView)findViewById(2131300336));
    this.oNU.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(113380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftVideoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        CardGiftVideoUI.this.bYa();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/card/ui/CardGiftVideoUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(113380);
        return true;
      }
    });
    ((View)this.oNV).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        CardGiftVideoUI.this.bYa();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113381);
      }
    });
    this.oMQ = new e(this);
    AppMethodBeat.o(113392);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(113401);
    ae.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.oNV.p(0.0D);
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
    this.oMP = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.WB() != null) {
      com.tencent.mm.booter.a.WB().WD();
    }
    this.oMK = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.fOX = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.oMK == null) {}
    for (paramBundle = "null";; paramBundle = this.oMK.toString())
    {
      ae.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      ae.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.fOX) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      bYg();
      if (this.oMK != null) {
        break;
      }
      ae.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(113389);
      return;
    }
    if (!bu.isNullOrNil(this.oMK.oEH))
    {
      com.tencent.mm.plugin.card.d.a.g(this.oMK.oEI, this.oMK.oEL, this.oMK.oET, 2);
      com.tencent.mm.plugin.card.d.a.g(this.oMK.oEH, this.oMK.oEK, this.oMK.oES, 1);
      AppMethodBeat.o(113389);
      return;
    }
    ae.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(113389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113396);
    this.oNV.stop();
    this.oOb.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(113396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113399);
    setResult(0);
    this.oNV.stop();
    ae.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(113399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113395);
    this.oNV.pause();
    super.onPause();
    AppMethodBeat.o(113395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113394);
    if (!bu.isNullOrNil(this.videoPath)) {
      ZD(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(113394);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113393);
    Bundle localBundle = this.oMP;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ae.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113393);
      return;
      label63:
      this.oMR = getIntent().getIntExtra("img_top", 0);
      this.oMS = getIntent().getIntExtra("img_left", 0);
      this.oMT = getIntent().getIntExtra("img_width", 0);
      this.oMU = getIntent().getIntExtra("img_height", 0);
      this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
      if (localBundle == null) {
        this.oNU.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
  
  public final void ta()
  {
    AppMethodBeat.i(113400);
    setResult(-1);
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113386);
        ae.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.oOe) });
        if (this.oOe)
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
    this.oMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113387);
        ae.d("MicroMsg.CardGiftVideoUI", "hide loading.");
        if ((CardGiftVideoUI.g(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.g(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.g(CardGiftVideoUI.this).setVisibility(8);
        }
        if ((CardGiftVideoUI.h(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113387);
      }
    });
    this.oNV.start();
    this.duration = (this.oNV.getDuration() / 1000);
    this.oOb.ay(500L, 500L);
    ae.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(113400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */