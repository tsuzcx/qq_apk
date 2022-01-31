package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@com.tencent.mm.ui.base.a(3)
public class CardGiftVideoUI
  extends MMActivity
  implements a.a, f.a
{
  private j contextMenuHelper;
  private boolean dnJ;
  int duration = 0;
  private com.tencent.mm.ui.tools.e itA;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  private CardGiftInfo its;
  private ImageView itt;
  private ProgressBar itw;
  private ah itx = new ah(Looper.getMainLooper());
  private Bundle ity;
  private boolean itz = false;
  private RelativeLayout iuB;
  private f iuC;
  private RelativeLayout iuD;
  private ImageView iuE;
  TextView iuF;
  private MMPinProgressBtn iuG;
  private TextView iuH;
  private am iuI = new am(new CardGiftVideoUI.10(this), true);
  private String videoPath;
  
  private void aBT()
  {
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new j(this.mController.uMN);
    }
    if (bk.bl(this.videoPath))
    {
      y.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
      return;
    }
    this.contextMenuHelper.a((VideoTextureView)this.iuC, new CardGiftVideoUI.1(this), new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          return;
        }
        paramAnonymousMenuItem = u.of(CardGiftVideoUI.a(CardGiftVideoUI.this));
        if (bk.bl(paramAnonymousMenuItem))
        {
          Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(a.g.video_file_save_failed), 1).show();
          return;
        }
        Toast.makeText(CardGiftVideoUI.this, CardGiftVideoUI.this.getString(a.g.video_file_saved, new Object[] { paramAnonymousMenuItem }), 1).show();
        l.a(paramAnonymousMenuItem, CardGiftVideoUI.this);
      }
    });
  }
  
  private void yF(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
      setResult(0);
      finish();
      return;
    }
    if (!com.tencent.mm.vfs.e.bK(paramString))
    {
      y.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[] { paramString });
      setResult(0);
      finish();
      return;
    }
    this.iuC.setVideoPath(paramString);
  }
  
  public final void aBR()
  {
    this.itA.E(this.itC, this.itB, this.itD, this.itE);
    this.itA.a(this.iuB, this.itt, new CardGiftVideoUI.9(this), null);
  }
  
  public final void bm(String paramString, int paramInt)
  {
    if (paramString.equals(this.its.ilH)) {
      this.itx.post(new CardGiftVideoUI.2(this, paramInt));
    }
  }
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void cx(String paramString1, String paramString2)
  {
    if (paramString1.equals(this.its.ilH))
    {
      this.itx.post(new CardGiftVideoUI.3(this, paramString2));
      return;
    }
    if (paramString1.equals(this.its.ilI))
    {
      this.itx.post(new CardGiftVideoUI.4(this, paramString2));
      return;
    }
    y.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[] { paramString1 });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
      aBR();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final void fail(String paramString) {}
  
  protected final int getLayoutId()
  {
    return a.e.card_gift_video_ui;
  }
  
  protected final void initView()
  {
    this.iuB = ((RelativeLayout)findViewById(a.d.video_ui_root));
    this.iuD = ((RelativeLayout)findViewById(a.d.video_root));
    this.iuE = ((ImageView)findViewById(a.d.video_thumb));
    this.iuF = ((TextView)findViewById(a.d.video_duration));
    this.iuG = ((MMPinProgressBtn)findViewById(a.d.video_progress));
    this.itw = ((ProgressBar)findViewById(a.d.video_loading));
    this.iuH = ((TextView)findViewById(a.d.video_tips));
    this.iuC = new VideoTextureView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(13);
    this.iuC.setMute(this.dnJ);
    this.iuC.setVideoCallback(this);
    this.iuD.addView((View)this.iuC, localLayoutParams);
    this.itt = ((ImageView)findViewById(a.d.gallery_bg));
    this.itt.setLayerType(2, null);
    this.iuB.setOnTouchListener(new CardGiftVideoUI.6(this));
    ((View)this.iuC).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        CardGiftVideoUI.this.aBR();
      }
    });
    this.itA = new com.tencent.mm.ui.tools.e(this);
  }
  
  public final void kA()
  {
    setResult(-1);
    this.itx.post(new CardGiftVideoUI.11(this));
    this.itx.post(new CardGiftVideoUI.12(this));
    this.iuC.start();
    this.duration = (this.iuC.getDuration() / 1000);
    this.iuI.S(500L, 500L);
    y.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[] { Integer.valueOf(this.duration) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.ity = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    if (com.tencent.mm.booter.a.vR() != null) {
      com.tencent.mm.booter.a.vR().vT();
    }
    this.its = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    this.videoPath = getIntent().getStringExtra("key_video_path");
    this.dnJ = getIntent().getBooleanExtra("key_is_mute", false);
    if (this.its == null) {}
    for (paramBundle = "null";; paramBundle = this.its.toString())
    {
      y.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", new Object[] { paramBundle });
      y.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[] { this.videoPath, Boolean.valueOf(this.dnJ) });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      aBT();
      if (this.its != null) {
        break;
      }
      y.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
      return;
    }
    if (!bk.bl(this.its.ilH))
    {
      com.tencent.mm.plugin.card.d.a.g(this.its.ilI, this.its.ilL, this.its.ilU, 2);
      com.tencent.mm.plugin.card.d.a.g(this.its.ilH, this.its.ilK, this.its.ilT, 1);
      return;
    }
    y.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
  }
  
  protected void onDestroy()
  {
    this.iuC.stop();
    this.iuI.stopTimer();
    com.tencent.mm.plugin.card.d.a.b(this);
    super.onDestroy();
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    setResult(0);
    this.iuC.stop();
    y.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  protected void onPause()
  {
    this.iuC.pause();
    super.onPause();
  }
  
  protected void onResume()
  {
    if (!bk.bl(this.videoPath)) {
      yF(this.videoPath);
    }
    super.onResume();
  }
  
  public void onStart()
  {
    Bundle localBundle = this.ity;
    if (!this.itz)
    {
      this.itz = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label51;
      }
      y.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      return;
      label51:
      this.itB = getIntent().getIntExtra("img_top", 0);
      this.itC = getIntent().getIntExtra("img_left", 0);
      this.itD = getIntent().getIntExtra("img_width", 0);
      this.itE = getIntent().getIntExtra("img_height", 0);
      this.itA.E(this.itC, this.itB, this.itD, this.itE);
      if (localBundle == null) {
        this.iuB.getViewTreeObserver().addOnPreDrawListener(new CardGiftVideoUI.8(this));
      }
    }
  }
  
  public final void ug()
  {
    y.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    this.iuC.x(0.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI
 * JD-Core Version:    0.7.0.1
 */