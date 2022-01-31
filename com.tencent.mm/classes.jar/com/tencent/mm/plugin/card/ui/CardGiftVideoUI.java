package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, e.a
{
  private l contextMenuHelper;
  int duration;
  private boolean efg;
  private boolean isAnimated;
  private com.tencent.mm.ui.tools.e kip;
  private ImageView kuA;
  private ProgressBar kuD;
  private ak kuE;
  private Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  private CardGiftInfo kuz;
  private RelativeLayout kvF;
  private com.tencent.mm.pluginsdk.ui.tools.e kvG;
  private RelativeLayout kvH;
  private ImageView kvI;
  TextView kvJ;
  private MMPinProgressBtn kvK;
  private TextView kvL;
  private ap kvM;
  private String videoPath;
  
  public CardGiftVideoUI()
  {
    AppMethodBeat.i(88461);
    this.kuE = new ak(Looper.getMainLooper());
    this.isAnimated = false;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.kvM = new ap(new CardGiftVideoUI.10(this), true);
    this.duration = 0;
    AppMethodBeat.o(88461);
  }
  
  private void Ih(String paramString)
  {
    AppMethodBeat.i(88463);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
      AppMethodBeat.o(88463);
      return;
    }
    if (!com.tencent.mm.vfs.e.cN(paramString))
    {
      ab.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      AppMethodBeat.o(88463);
      return;
    }
    this.kvG.setVideoPath(paramString);
    AppMethodBeat.o(88463);
  }
  
  private void bec()
  {
    AppMethodBeat.i(88464);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(getContext());
    }
    if (bo.isNullOrNil(this.videoPath))
    {
      ab.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      AppMethodBeat.o(88464);
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.kvG, new CardGiftVideoUI.1(this), new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(88452);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(88452);
          return;
          paramAnonymousMenuItem = u.vs(CardGiftVideoUI.a(CardGiftVideoUI.this));
          if (bo.isNullOrNil(paramAnonymousMenuItem))
          {
            Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131304521), 1).show();
            AppMethodBeat.o(88452);
            return;
          }
          Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(2131304522, new Object[] { paramAnonymousMenuItem }), 1).show();
          n.a(paramAnonymousMenuItem, CardGiftVideoUI.this);
        }
      }
    });
    AppMethodBeat.o(88464);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(88474);
    ab.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.kvG.A(0.0D);
    AppMethodBeat.o(88474);
  }
  
  public final void Ig(String paramString) {}
  
  public final void bO(String paramString, int paramInt)
  {
    AppMethodBeat.i(88475);
    if (paramString.equals(this.kuz.kmE)) {
      this.kuE.post(new CardGiftVideoUI.2(this, paramInt));
    }
    AppMethodBeat.o(88475);
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(88471);
    this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
    this.kip.a(this.kvF, this.kuA, new CardGiftVideoUI.9(this), null);
    AppMethodBeat.o(88471);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88470);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      bdV();
      AppMethodBeat.o(88470);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(88470);
    return bool;
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88476);
    if (paramString1.equals(this.kuz.kmE))
    {
      this.kuE.post(new CardGiftVideoUI.3(this, paramString2));
      AppMethodBeat.o(88476);
      return;
    }
    if (paramString1.equals(this.kuz.kmF))
    {
      this.kuE.post(new CardGiftVideoUI.4(this, paramString2));
      AppMethodBeat.o(88476);
      return;
    }
    ab.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[] { paramString1 });
    AppMethodBeat.o(88476);
  }
  
  public int getLayoutId()
  {
    return 2130968942;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88465);
    this.kvF = ((RelativeLayout)findViewById(2131822188));
    this.kvH = ((RelativeLayout)findViewById(2131822190));
    this.kvI = ((ImageView)findViewById(2131822189));
    this.kvJ = ((TextView)findViewById(2131822191));
    this.kvK = ((MMPinProgressBtn)findViewById(2131822192));
    this.kuD = ((ProgressBar)findViewById(2131821842));
    this.kvL = ((TextView)findViewById(2131822194));
    this.kvG = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.kvG.setMute(this.efg);
    this.kvG.setVideoCallback(this);
    this.kvH.addView((View)this.kvG, localLayoutParams);
    this.kuA = ((ImageView)findViewById(2131822135));
    this.kuA.setLayerType(2, null);
    this.kvF.setOnTouchListener(new CardGiftVideoUI.6(this));
    ((View)this.kvG).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(88454);
        CardGiftVideoUI.this.bdV();
        AppMethodBeat.o(88454);
      }
    });
    this.kip = new com.tencent.mm.ui.tools.e(this);
    AppMethodBeat.o(88465);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(88473);
    setResult(-1);
    this.kuE.post(new CardGiftVideoUI.11(this));
    this.kuE.post(new CardGiftVideoUI.12(this));
    this.kvG.start();
    this.duration = (this.kvG.getDuration() / 1000);
    this.kvM.ag(500L, 500L);
    ab.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
    AppMethodBeat.o(88473);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88462);
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    hideTitleView();
    this.kuF = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.Ia() != null) {
      com.tencent.mm.booter.a.Ia().Ic();
    }
    this.kuz = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.efg = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.kuz == null) {}
    for (paramBundle = "null";; paramBundle = this.kuz.toString())
    {
      ab.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      ab.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.efg) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      bec();
      if (this.kuz != null) {
        break;
      }
      ab.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      AppMethodBeat.o(88462);
      return;
    }
    if (!bo.isNullOrNil(this.kuz.kmE))
    {
      com.tencent.mm.plugin.card.d.a.h(this.kuz.kmF, this.kuz.kmI, this.kuz.kmR, 2);
      com.tencent.mm.plugin.card.d.a.h(this.kuz.kmE, this.kuz.kmH, this.kuz.kmQ, 1);
      AppMethodBeat.o(88462);
      return;
    }
    ab.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
    AppMethodBeat.o(88462);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88469);
    this.kvG.stop();
    this.kvM.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
    AppMethodBeat.o(88469);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88472);
    setResult(0);
    this.kvG.stop();
    ab.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(88472);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(88468);
    this.kvG.pause();
    super.onPause();
    AppMethodBeat.o(88468);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88467);
    if (!bo.isNullOrNil(this.videoPath)) {
      Ih(this.videoPath);
    }
    super.onResume();
    AppMethodBeat.o(88467);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(88466);
    Bundle localBundle = this.kuF;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ab.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(88466);
      return;
      label63:
      this.kuG = getIntent().getIntExtra("img_top", 0);
      this.kuH = getIntent().getIntExtra("img_left", 0);
      this.kuI = getIntent().getIntExtra("img_width", 0);
      this.kuJ = getIntent().getIntExtra("img_height", 0);
      this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
      if (localBundle == null) {
        this.kvF.getViewTreeObserver().addOnPreDrawListener(new CardGiftVideoUI.8(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */