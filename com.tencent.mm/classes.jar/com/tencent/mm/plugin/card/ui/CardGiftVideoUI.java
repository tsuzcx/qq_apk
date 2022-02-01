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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.i;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, h.a
{
  private l contextMenuHelper;
  int duration;
  private boolean fqj;
  private boolean isAnimated;
  private RelativeLayout nAY;
  private h nAZ;
  private RelativeLayout nBa;
  private ImageView nBb;
  TextView nBc;
  private MMPinProgressBtn nBd;
  private TextView nBe;
  private av nBf;
  private CardGiftInfo nzP;
  private ImageView nzQ;
  private ProgressBar nzS;
  private ap nzT;
  private Bundle nzU;
  private e nzV;
  private int nzW;
  private int nzX;
  private int nzY;
  private int nzZ;
  private String videoPath;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(113388);
    this.nzT = new ap(Looper.getMainLooper());
    this.isAnimated = false;
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.nBf = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(113385);
        if (CardGiftVideoUI.e(CardGiftVideoUI.this).isPlaying())
        {
          CardGiftVideoUI localCardGiftVideoUI = CardGiftVideoUI.this;
          int i = CardGiftVideoUI.e(CardGiftVideoUI.this).getCurrentPosition() / 1000;
          if ((localCardGiftVideoUI.nBc != null) && (localCardGiftVideoUI.duration > 0))
          {
            int j = localCardGiftVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localCardGiftVideoUI.nBc.setText(i + "\"");
          }
        }
        AppMethodBeat.o(113385);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(113388);
  }
  
  private void QR(String paramString)
  {
    AppMethodBeat.i(113390);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    if (!i.eK(paramString))
    {
      ad.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    this.nAZ.setVideoPath(paramString);
    AppMethodBeat.o(113390);
  }
  
  private void bKZ()
  {
    AppMethodBeat.i(113391);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(getContext());
    }
    if (bt.isNullOrNil(this.videoPath))
    {
      ad.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      AppMethodBeat.o(113391);
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.nAZ, new View.OnCreateContextMenuListener()new n.d
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(113375);
        paramAnonymousContextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(2131756924));
        AppMethodBeat.o(113375);
      }
    }, new n.d()
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
          paramAnonymousMenuItem = u.Af(CardGiftVideoUI.a(CardGiftVideoUI.this));
          if (bt.isNullOrNil(paramAnonymousMenuItem))
          {
            Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131764682), 1).show();
            AppMethodBeat.o(113379);
            return;
          }
          Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131764683, new Object[] { paramAnonymousMenuItem }), 1).show();
          q.k(paramAnonymousMenuItem, CardGiftVideoUI.this);
        }
      }
    });
    AppMethodBeat.o(113391);
  }
  
  public final void QQ(String paramString) {}
  
  public final void bKT()
  {
    AppMethodBeat.i(113398);
    this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
    this.nzV.a(this.nAY, this.nzQ, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113384);
        new ap().post(new Runnable()
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
  
  public final void cx(String paramString, final int paramInt)
  {
    AppMethodBeat.i(113402);
    if (paramString.equals(this.nzP.nrK)) {
      this.nzT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113376);
          if (CardGiftVideoUI.h(CardGiftVideoUI.this) != null)
          {
            if (this.hhZ == 0)
            {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
              AppMethodBeat.o(113376);
              return;
            }
            if (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 0) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(0);
            }
            ad.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hhZ) });
            if ((CardGiftVideoUI.h(CardGiftVideoUI.this).getMax() != this.hhZ) && (this.hhZ > 0)) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setMax(this.hhZ);
            }
            CardGiftVideoUI.h(CardGiftVideoUI.this).setProgress(paramInt);
          }
          AppMethodBeat.o(113376);
        }
      });
    }
    AppMethodBeat.o(113402);
  }
  
  public final void dY(int paramInt1, int paramInt2) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113397);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      bKT();
      AppMethodBeat.o(113397);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113397);
    return bool;
  }
  
  public final void eE(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113403);
    if (paramString1.equals(this.nzP.nrK))
    {
      this.nzT.post(new Runnable()
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
    if (paramString1.equals(this.nzP.nrL))
    {
      this.nzT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113378);
          if (bt.isNullOrNil(CardGiftVideoUI.a(CardGiftVideoUI.this)))
          {
            CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
            Object localObject = new c.a();
            ((c.a)localObject).prefixPath = b.aih();
            o.ayK();
            ((c.a)localObject).hkl = null;
            ((c.a)localObject).gjt = m.Qy(paramString2);
            ((c.a)localObject).hjX = 1;
            ((c.a)localObject).hjU = true;
            ((c.a)localObject).hjS = true;
            localObject = ((c.a)localObject).azc();
            o.ayJ().a(paramString2, CardGiftVideoUI.f(CardGiftVideoUI.this), (c)localObject);
          }
          AppMethodBeat.o(113378);
        }
      });
      AppMethodBeat.o(113403);
      return;
    }
    ad.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[] { paramString1 });
    AppMethodBeat.o(113403);
  }
  
  public final int eM(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131493284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113392);
    this.nAY = ((RelativeLayout)findViewById(2131306409));
    this.nBa = ((RelativeLayout)findViewById(2131306392));
    this.nBb = ((ImageView)findViewById(2131306398));
    this.nBc = ((TextView)findViewById(2131306332));
    this.nBd = ((MMPinProgressBtn)findViewById(2131306379));
    this.nzS = ((ProgressBar)findViewById(2131306352));
    this.nBe = ((TextView)findViewById(2131306403));
    this.nAZ = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.nAZ.setMute(this.fqj);
    this.nAZ.setVideoCallback(this);
    this.nBa.addView((View)this.nAZ, localLayoutParams);
    this.nzQ = ((ImageView)findViewById(2131300336));
    this.nAY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(113380);
        CardGiftVideoUI.this.bKT();
        AppMethodBeat.o(113380);
        return true;
      }
    });
    ((View)this.nAZ).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113381);
        CardGiftVideoUI.this.bKT();
        AppMethodBeat.o(113381);
      }
    });
    this.nzV = new e(this);
    AppMethodBeat.o(113392);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(113401);
    ad.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.nAZ.q(0.0D);
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
    this.nzU = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.Ti() != null) {
      com.tencent.mm.booter.a.Ti().Tk();
    }
    this.nzP = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.fqj = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.nzP == null) {}
    for (paramBundle = "null";; paramBundle = this.nzP.toString())
    {
      ad.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      ad.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.fqj) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      bKZ();
      if (this.nzP != null) {
        break;
      }
      ad.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(113389);
      return;
    }
    if (!bt.isNullOrNil(this.nzP.nrK))
    {
      com.tencent.mm.plugin.card.d.a.g(this.nzP.nrL, this.nzP.nrO, this.nzP.nrW, 2);
      com.tencent.mm.plugin.card.d.a.g(this.nzP.nrK, this.nzP.nrN, this.nzP.nrV, 1);
      AppMethodBeat.o(113389);
      return;
    }
    ad.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(113389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113396);
    this.nAZ.stop();
    this.nBf.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(113396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113399);
    setResult(0);
    this.nAZ.stop();
    ad.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(113399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113395);
    this.nAZ.pause();
    super.onPause();
    AppMethodBeat.o(113395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113394);
    if (!bt.isNullOrNil(this.videoPath)) {
      QR(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(113394);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113393);
    Bundle localBundle = this.nzU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ad.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113393);
      return;
      label63:
      this.nzW = getIntent().getIntExtra("img_top", 0);
      this.nzX = getIntent().getIntExtra("img_left", 0);
      this.nzY = getIntent().getIntExtra("img_width", 0);
      this.nzZ = getIntent().getIntExtra("img_height", 0);
      this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
      if (localBundle == null) {
        this.nAY.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
  
  public final void rq()
  {
    AppMethodBeat.i(113400);
    setResult(-1);
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113386);
        ad.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.nBi) });
        if (this.nBi)
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
    this.nzT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113387);
        ad.d("MicroMsg.CardGiftVideoUI", "hide loading.");
        if ((CardGiftVideoUI.g(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.g(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.g(CardGiftVideoUI.this).setVisibility(8);
        }
        if ((CardGiftVideoUI.h(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113387);
      }
    });
    this.nAZ.start();
    this.duration = (this.nAZ.getDuration() / 1000);
    this.nBf.av(500L, 500L);
    ad.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(113400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */