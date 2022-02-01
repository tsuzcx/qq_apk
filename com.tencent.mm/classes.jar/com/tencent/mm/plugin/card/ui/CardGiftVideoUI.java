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
import com.tencent.mm.av.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private boolean ftN;
  private boolean isAnimated;
  private CardGiftInfo ocP;
  private ImageView ocQ;
  private ProgressBar ocS;
  private ao ocT;
  private Bundle ocU;
  private e ocV;
  private int ocW;
  private int ocX;
  private int ocY;
  private int ocZ;
  private RelativeLayout odY;
  private h odZ;
  private RelativeLayout oea;
  private ImageView oeb;
  TextView oec;
  private MMPinProgressBtn oed;
  private TextView oee;
  private au oef;
  private String videoPath;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(113388);
    this.ocT = new ao(Looper.getMainLooper());
    this.isAnimated = false;
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    this.oef = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(113385);
        if (CardGiftVideoUI.e(CardGiftVideoUI.this).isPlaying())
        {
          CardGiftVideoUI localCardGiftVideoUI = CardGiftVideoUI.this;
          int i = CardGiftVideoUI.e(CardGiftVideoUI.this).getCurrentPosition() / 1000;
          if ((localCardGiftVideoUI.oec != null) && (localCardGiftVideoUI.duration > 0))
          {
            int j = localCardGiftVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localCardGiftVideoUI.oec.setText(i + "\"");
          }
        }
        AppMethodBeat.o(113385);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(113388);
  }
  
  private void Vd(String paramString)
  {
    AppMethodBeat.i(113390);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    if (!i.eA(paramString))
    {
      ac.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    this.odZ.setVideoPath(paramString);
    AppMethodBeat.o(113390);
  }
  
  private void bSm()
  {
    AppMethodBeat.i(113391);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(getContext());
    }
    if (bs.isNullOrNil(this.videoPath))
    {
      ac.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      AppMethodBeat.o(113391);
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.odZ, new View.OnCreateContextMenuListener()new n.d
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
          paramAnonymousMenuItem = u.Ek(CardGiftVideoUI.a(CardGiftVideoUI.this));
          if (bs.isNullOrNil(paramAnonymousMenuItem))
          {
            Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131764682), 1).show();
            AppMethodBeat.o(113379);
            return;
          }
          Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymousMenuItem) }), 1).show();
          q.k(paramAnonymousMenuItem, CardGiftVideoUI.this);
        }
      }
    });
    AppMethodBeat.o(113391);
  }
  
  public final void Vc(String paramString) {}
  
  public final void bSg()
  {
    AppMethodBeat.i(113398);
    this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
    this.ocV.a(this.odY, this.ocQ, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113384);
        new ao().post(new Runnable()
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
  
  public final void cC(String paramString, final int paramInt)
  {
    AppMethodBeat.i(113402);
    if (paramString.equals(this.ocP.nUK)) {
      this.ocT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113376);
          if (CardGiftVideoUI.h(CardGiftVideoUI.this) != null)
          {
            if (this.hIC == 0)
            {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
              AppMethodBeat.o(113376);
              return;
            }
            if (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 0) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(0);
            }
            ac.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hIC) });
            if ((CardGiftVideoUI.h(CardGiftVideoUI.this).getMax() != this.hIC) && (this.hIC > 0)) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setMax(this.hIC);
            }
            CardGiftVideoUI.h(CardGiftVideoUI.this).setProgress(paramInt);
          }
          AppMethodBeat.o(113376);
        }
      });
    }
    AppMethodBeat.o(113402);
  }
  
  public final void dZ(int paramInt1, int paramInt2) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113397);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      bSg();
      AppMethodBeat.o(113397);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113397);
    return bool;
  }
  
  public final int eP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void eR(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113403);
    if (paramString1.equals(this.ocP.nUK))
    {
      this.ocT.post(new Runnable()
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
    if (paramString1.equals(this.ocP.nUL))
    {
      this.ocT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113378);
          if (bs.isNullOrNil(CardGiftVideoUI.a(CardGiftVideoUI.this)))
          {
            CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
            Object localObject = new c.a();
            ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
            o.aFC();
            ((c.a)localObject).hKO = null;
            ((c.a)localObject).gKe = m.UK(paramString2);
            ((c.a)localObject).hKA = 1;
            ((c.a)localObject).hKx = true;
            ((c.a)localObject).hKv = true;
            localObject = ((c.a)localObject).aFT();
            o.aFB().a(paramString2, CardGiftVideoUI.f(CardGiftVideoUI.this), (c)localObject);
          }
          AppMethodBeat.o(113378);
        }
      });
      AppMethodBeat.o(113403);
      return;
    }
    ac.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[] { paramString1 });
    AppMethodBeat.o(113403);
  }
  
  public int getLayoutId()
  {
    return 2131493284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113392);
    this.odY = ((RelativeLayout)findViewById(2131306409));
    this.oea = ((RelativeLayout)findViewById(2131306392));
    this.oeb = ((ImageView)findViewById(2131306398));
    this.oec = ((TextView)findViewById(2131306332));
    this.oed = ((MMPinProgressBtn)findViewById(2131306379));
    this.ocS = ((ProgressBar)findViewById(2131306352));
    this.oee = ((TextView)findViewById(2131306403));
    this.odZ = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.odZ.setMute(this.ftN);
    this.odZ.setVideoCallback(this);
    this.oea.addView((View)this.odZ, localLayoutParams);
    this.ocQ = ((ImageView)findViewById(2131300336));
    this.odY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(113380);
        CardGiftVideoUI.this.bSg();
        AppMethodBeat.o(113380);
        return true;
      }
    });
    ((View)this.odZ).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113381);
        CardGiftVideoUI.this.bSg();
        AppMethodBeat.o(113381);
      }
    });
    this.ocV = new e(this);
    AppMethodBeat.o(113392);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(113401);
    ac.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.odZ.p(0.0D);
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
    this.ocU = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.Uc() != null) {
      com.tencent.mm.booter.a.Uc().Ue();
    }
    this.ocP = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.ftN = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.ocP == null) {}
    for (paramBundle = "null";; paramBundle = this.ocP.toString())
    {
      ac.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      ac.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.ftN) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      bSm();
      if (this.ocP != null) {
        break;
      }
      ac.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(113389);
      return;
    }
    if (!bs.isNullOrNil(this.ocP.nUK))
    {
      com.tencent.mm.plugin.card.d.a.g(this.ocP.nUL, this.ocP.nUO, this.ocP.nUW, 2);
      com.tencent.mm.plugin.card.d.a.g(this.ocP.nUK, this.ocP.nUN, this.ocP.nUV, 1);
      AppMethodBeat.o(113389);
      return;
    }
    ac.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(113389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113396);
    this.odZ.stop();
    this.oef.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(113396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113399);
    setResult(0);
    this.odZ.stop();
    ac.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(113399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113395);
    this.odZ.pause();
    super.onPause();
    AppMethodBeat.o(113395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113394);
    if (!bs.isNullOrNil(this.videoPath)) {
      Vd(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(113394);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113393);
    Bundle localBundle = this.ocU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ac.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113393);
      return;
      label63:
      this.ocW = getIntent().getIntExtra("img_top", 0);
      this.ocX = getIntent().getIntExtra("img_left", 0);
      this.ocY = getIntent().getIntExtra("img_width", 0);
      this.ocZ = getIntent().getIntExtra("img_height", 0);
      this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
      if (localBundle == null) {
        this.odY.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
  
  public final void rB()
  {
    AppMethodBeat.i(113400);
    setResult(-1);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113386);
        ac.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.oei) });
        if (this.oei)
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
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113387);
        ac.d("MicroMsg.CardGiftVideoUI", "hide loading.");
        if ((CardGiftVideoUI.g(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.g(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.g(CardGiftVideoUI.this).setVisibility(8);
        }
        if ((CardGiftVideoUI.h(CardGiftVideoUI.this) != null) && (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 8)) {
          CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
        }
        AppMethodBeat.o(113387);
      }
    });
    this.odZ.start();
    this.duration = (this.odZ.getDuration() / 1000);
    this.oef.au(500L, 500L);
    ac.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(113400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */