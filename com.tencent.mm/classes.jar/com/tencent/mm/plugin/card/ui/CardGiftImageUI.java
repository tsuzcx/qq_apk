package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.l;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI
  extends MMActivity
  implements a.a
{
  private l igW;
  private String imgPath;
  private boolean isAnimated;
  private e kip;
  private ImageView kuA;
  private RelativeLayout kuB;
  private MMGestureGallery kuC;
  private ProgressBar kuD;
  private ak kuE;
  private Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  private CardGiftImageUI.a kuK;
  private CardGiftInfo kuz;
  
  public CardGiftImageUI()
  {
    AppMethodBeat.i(88403);
    this.kuE = new ak(Looper.getMainLooper());
    this.isAnimated = false;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    AppMethodBeat.o(88403);
  }
  
  public final void Ig(String paramString) {}
  
  public final void bO(String paramString, int paramInt)
  {
    AppMethodBeat.i(88412);
    this.kuE.post(new CardGiftImageUI.7(this));
    AppMethodBeat.o(88412);
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(88411);
    this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
    this.kip.a(this.kuB, this.kuA, new CardGiftImageUI.6(this), null);
    AppMethodBeat.o(88411);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88410);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      bdV();
      AppMethodBeat.o(88410);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(88410);
    return bool;
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88413);
    this.kuE.post(new CardGiftImageUI.8(this, paramString2));
    AppMethodBeat.o(88413);
  }
  
  public int getLayoutId()
  {
    return 2130968938;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88405);
    this.kuA = ((ImageView)findViewById(2131822135));
    this.kuA.setLayerType(2, null);
    this.kuD = ((ProgressBar)findViewById(2131822138));
    this.kuB = ((RelativeLayout)findViewById(2131822136));
    this.kuC = ((MMGestureGallery)findViewById(2131822137));
    this.kuC.setVerticalFadingEdgeEnabled(false);
    this.kuC.setHorizontalFadingEdgeEnabled(false);
    this.kuK = new CardGiftImageUI.a(this, (byte)0);
    this.kuC.setAdapter(this.kuK);
    this.kuC.setSingleClickOverListener(new CardGiftImageUI.1(this));
    this.kuC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(88394);
        h.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).cwt());
        AppMethodBeat.o(88394);
        return true;
      }
    });
    this.kip = new e(this);
    AppMethodBeat.o(88405);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88404);
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    hideTitleView();
    this.kuF = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.kuz = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.kuz == null) {}
    for (paramBundle = "null";; paramBundle = this.kuz.toString())
    {
      ab.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      ab.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.imgPath });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      if ((this.kuz == null) || (bo.isNullOrNil(this.kuz.kmD))) {
        break;
      }
      com.tencent.mm.plugin.card.d.a.h(this.kuz.kmD, this.kuz.kmG, this.kuz.kmP, 2);
      AppMethodBeat.o(88404);
      return;
    }
    ab.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
    AppMethodBeat.o(88404);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88409);
    super.onDestroy();
    com.tencent.mm.plugin.card.d.a.b(this);
    AppMethodBeat.o(88409);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(88408);
    super.onPause();
    AppMethodBeat.o(88408);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88407);
    super.onResume();
    if (this.kuK != null) {
      this.kuK.notifyDataSetChanged();
    }
    AppMethodBeat.o(88407);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(88406);
    Bundle localBundle = this.kuF;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ab.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(88406);
      return;
      label63:
      this.kuG = getIntent().getIntExtra("img_top", 0);
      this.kuH = getIntent().getIntExtra("img_left", 0);
      this.kuI = getIntent().getIntExtra("img_width", 0);
      this.kuJ = getIntent().getIntExtra("img_height", 0);
      this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
      if (localBundle == null) {
        this.kuB.getViewTreeObserver().addOnPreDrawListener(new CardGiftImageUI.5(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI
 * JD-Core Version:    0.7.0.1
 */