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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, k.a
{
  private com.tencent.mm.ui.tools.m contextMenuHelper;
  int duration;
  private boolean iYs;
  private boolean isAnimated;
  private Bundle twA;
  private f twB;
  private int twC;
  private int twD;
  private int twE;
  private int twF;
  private CardGiftInfo twv;
  private ImageView tww;
  private ProgressBar twy;
  private MMHandler twz;
  private RelativeLayout txG;
  private k txH;
  private RelativeLayout txI;
  private ImageView txJ;
  TextView txK;
  private MMPinProgressBtn txL;
  private TextView txM;
  private MTimerHandler txN;
  private String videoPath;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(113388);
    this.twz = new MMHandler(Looper.getMainLooper());
    this.isAnimated = false;
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(113385);
        if (CardGiftVideoUI.e(CardGiftVideoUI.this).isPlaying())
        {
          CardGiftVideoUI localCardGiftVideoUI = CardGiftVideoUI.this;
          int i = CardGiftVideoUI.e(CardGiftVideoUI.this).getCurrentPosition() / 1000;
          if ((localCardGiftVideoUI.txK != null) && (localCardGiftVideoUI.duration > 0))
          {
            int j = localCardGiftVideoUI.duration - i;
            i = j;
            if (j < 0) {
              i = 0;
            }
            localCardGiftVideoUI.txK.setText(i + "\"");
          }
        }
        AppMethodBeat.o(113385);
        return true;
      }
    }, true);
    this.duration = 0;
    AppMethodBeat.o(113388);
  }
  
  private void arv(String paramString)
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
    if (!com.tencent.mm.vfs.u.agG(paramString))
    {
      Log.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(113390);
      return;
    }
    this.txH.setVideoPath(paramString);
    AppMethodBeat.o(113390);
  }
  
  private void cJy()
  {
    AppMethodBeat.i(113391);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new com.tencent.mm.ui.tools.m(getContext());
    }
    if (Util.isNullOrNil(this.videoPath))
    {
      Log.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      AppMethodBeat.o(113391);
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.txH, new View.OnCreateContextMenuListener()new q.g
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(113375);
        paramAnonymousContextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(a.g.tkR));
        AppMethodBeat.o(113375);
      }
    }, new q.g()
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
            public final void bT(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(244738);
              Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(a.g.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous2String2) }), 1).show();
              com.tencent.mm.pluginsdk.ui.tools.u.refreshMediaScanner(paramAnonymous2String2, CardGiftVideoUI.this.getContext());
              AppMethodBeat.o(244738);
            }
            
            public final void bU(String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(244740);
              Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(a.g.video_file_save_failed), 1).show();
              AppMethodBeat.o(244740);
            }
          });
        }
      }
    });
    AppMethodBeat.o(113391);
  }
  
  public final void aru(String paramString) {}
  
  public final void cJs()
  {
    AppMethodBeat.i(113398);
    this.twB.V(this.twD, this.twC, this.twE, this.twF);
    this.twB.a(this.txG, this.tww, new f.c()
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
      cJs();
      AppMethodBeat.o(113397);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113397);
    return bool;
  }
  
  public final void dj(String paramString, final int paramInt)
  {
    AppMethodBeat.i(113402);
    if (paramString.equals(this.twv.toq)) {
      this.twz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113376);
          if (CardGiftVideoUI.h(CardGiftVideoUI.this) != null)
          {
            if (this.lPA == 0)
            {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(8);
              AppMethodBeat.o(113376);
              return;
            }
            if (CardGiftVideoUI.h(CardGiftVideoUI.this).getVisibility() != 0) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setVisibility(0);
            }
            Log.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lPA) });
            if ((CardGiftVideoUI.h(CardGiftVideoUI.this).getMax() != this.lPA) && (this.lPA > 0)) {
              CardGiftVideoUI.h(CardGiftVideoUI.this).setMax(this.lPA);
            }
            CardGiftVideoUI.h(CardGiftVideoUI.this).setProgress(paramInt);
          }
          AppMethodBeat.o(113376);
        }
      });
    }
    AppMethodBeat.o(113402);
  }
  
  public final void eM(int paramInt1, int paramInt2) {}
  
  public final int fE(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void fK(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113403);
    if (paramString1.equals(this.twv.toq))
    {
      this.twz.post(new Runnable()
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
    if (paramString1.equals(this.twv.tor))
    {
      this.twz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(113378);
          if (Util.isNullOrNil(CardGiftVideoUI.a(CardGiftVideoUI.this)))
          {
            CardGiftVideoUI.f(CardGiftVideoUI.this).setVisibility(0);
            Object localObject = new c.a();
            ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
            q.bmm();
            ((c.a)localObject).lRV = null;
            ((c.a)localObject).fullPath = com.tencent.mm.plugin.card.model.m.arc(paramString2);
            ((c.a)localObject).lRG = 1;
            ((c.a)localObject).lRD = true;
            ((c.a)localObject).lRB = true;
            localObject = ((c.a)localObject).bmL();
            q.bml().a(paramString2, CardGiftVideoUI.f(CardGiftVideoUI.this), (c)localObject);
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
    return a.e.tii;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113392);
    this.txG = ((RelativeLayout)findViewById(a.d.video_ui_root));
    this.txI = ((RelativeLayout)findViewById(a.d.video_root));
    this.txJ = ((ImageView)findViewById(a.d.video_thumb));
    this.txK = ((TextView)findViewById(a.d.video_duration));
    this.txL = ((MMPinProgressBtn)findViewById(a.d.video_progress));
    this.twy = ((ProgressBar)findViewById(a.d.video_loading));
    this.txM = ((TextView)findViewById(a.d.video_tips));
    this.txH = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.txH.setMute(this.iYs);
    this.txH.setVideoCallback(this);
    this.txI.addView((View)this.txH, localLayoutParams);
    this.tww = ((ImageView)findViewById(a.d.gallery_bg));
    this.txG.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(113380);
        CardGiftVideoUI.this.cJs();
        AppMethodBeat.o(113380);
        return true;
      }
    });
    ((View)this.txH).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        CardGiftVideoUI.this.cJs();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(113381);
      }
    });
    this.twB = new f(this);
    AppMethodBeat.o(113392);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(113401);
    Log.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.txH.q(0.0D);
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
    this.twA = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.aql() != null) {
      com.tencent.mm.booter.a.aql().aqn();
    }
    this.twv = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.iYs = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.twv == null) {}
    for (paramBundle = "null";; paramBundle = this.twv.toString())
    {
      Log.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      Log.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.iYs) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      cJy();
      if (this.twv != null) {
        break;
      }
      Log.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(113389);
      return;
    }
    if (!Util.isNullOrNil(this.twv.toq))
    {
      com.tencent.mm.plugin.card.d.a.g(this.twv.tor, this.twv.tou, this.twv.toC, 2);
      com.tencent.mm.plugin.card.d.a.g(this.twv.toq, this.twv.tot, this.twv.toB, 1);
      AppMethodBeat.o(113389);
      return;
    }
    Log.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(113389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113396);
    this.txH.stop();
    this.txN.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(113396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113399);
    setResult(0);
    this.txH.stop();
    Log.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(113399);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113395);
    this.txH.pause();
    super.onPause();
    AppMethodBeat.o(113395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113394);
    if (!Util.isNullOrNil(this.videoPath)) {
      arv(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(113394);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113393);
    Bundle localBundle = this.twA;
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
      this.twC = getIntent().getIntExtra("img_top", 0);
      this.twD = getIntent().getIntExtra("img_left", 0);
      this.twE = getIntent().getIntExtra("img_width", 0);
      this.twF = getIntent().getIntExtra("img_height", 0);
      this.twB.V(this.twD, this.twC, this.twE, this.twF);
      if (localBundle == null) {
        this.txG.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
  
  public final void qX()
  {
    AppMethodBeat.i(113400);
    setResult(-1);
    this.twz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113386);
        Log.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.txR) });
        if (this.txR)
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
    this.twz.post(new Runnable()
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
    this.txH.start();
    this.duration = (this.txH.getDuration() / 1000);
    this.txN.startTimer(500L);
    Log.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(113400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */