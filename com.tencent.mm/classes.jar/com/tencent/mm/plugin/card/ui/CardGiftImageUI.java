package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.j;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI
  extends MMActivity
  implements a.a
{
  private j gGp;
  private String imgPath;
  private e itA;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  private CardGiftImageUI.a itF;
  private CardGiftInfo its;
  private ImageView itt;
  private RelativeLayout itu;
  private MMGestureGallery itv;
  private ProgressBar itw;
  private ah itx = new ah(Looper.getMainLooper());
  private Bundle ity;
  private boolean itz = false;
  
  public final void aBR()
  {
    this.itA.E(this.itC, this.itB, this.itD, this.itE);
    this.itA.a(this.itu, this.itt, new CardGiftImageUI.6(this), null);
  }
  
  public final void bm(String paramString, int paramInt)
  {
    this.itx.post(new CardGiftImageUI.7(this));
  }
  
  public final void cx(String paramString1, String paramString2)
  {
    this.itx.post(new CardGiftImageUI.8(this, paramString2));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      aBR();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final void fail(String paramString) {}
  
  protected final int getLayoutId()
  {
    return a.e.card_gift_image_ui;
  }
  
  protected final void initView()
  {
    this.itt = ((ImageView)findViewById(a.d.gallery_bg));
    this.itt.setLayerType(2, null);
    this.itw = ((ProgressBar)findViewById(a.d.image_loading));
    this.itu = ((RelativeLayout)findViewById(a.d.image_root));
    this.itv = ((MMGestureGallery)findViewById(a.d.gallery));
    this.itv.setVerticalFadingEdgeEnabled(false);
    this.itv.setHorizontalFadingEdgeEnabled(false);
    this.itF = new CardGiftImageUI.a(this, (byte)0);
    this.itv.setAdapter(this.itF);
    this.itv.setSingleClickOverListener(new CardGiftImageUI.1(this));
    this.itv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        h.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).bJQ());
        return true;
      }
    });
    this.itA = new e(this);
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
    this.its = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.its == null) {}
    for (paramBundle = "null";; paramBundle = this.its.toString())
    {
      y.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      y.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.imgPath });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      if ((this.its == null) || (bk.bl(this.its.ilG))) {
        break;
      }
      com.tencent.mm.plugin.card.d.a.g(this.its.ilG, this.its.ilJ, this.its.ilS, 2);
      return;
    }
    y.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.plugin.card.d.a.b(this);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.itF != null) {
      this.itF.notifyDataSetChanged();
    }
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
      y.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
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
        this.itu.getViewTreeObserver().addOnPreDrawListener(new CardGiftImageUI.5(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI
 * JD-Core Version:    0.7.0.1
 */