package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.tools.l;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI
  extends MMActivity
  implements a.a
{
  private String dmK;
  private MMGestureGallery iBx;
  private boolean isAnimated;
  private l kYv;
  private CardGiftInfo ocP;
  private ImageView ocQ;
  private RelativeLayout ocR;
  private ProgressBar ocS;
  private ao ocT;
  private Bundle ocU;
  private e ocV;
  private int ocW;
  private int ocX;
  private int ocY;
  private int ocZ;
  private CardGiftImageUI.a oda;
  
  public CardGiftImageUI()
  {
    AppMethodBeat.i(113328);
    this.ocT = new ao(Looper.getMainLooper());
    this.isAnimated = false;
    this.ocW = 0;
    this.ocX = 0;
    this.ocY = 0;
    this.ocZ = 0;
    AppMethodBeat.o(113328);
  }
  
  public final void Vc(String paramString) {}
  
  public final void bSg()
  {
    AppMethodBeat.i(113336);
    this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
    this.ocV.a(this.ocR, this.ocQ, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113324);
        new ao().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(113323);
            CardGiftImageUI.this.finish();
            CardGiftImageUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(113323);
          }
        });
        AppMethodBeat.o(113324);
      }
      
      public final void onAnimationStart() {}
    }, null);
    AppMethodBeat.o(113336);
  }
  
  public final void cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(113337);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113325);
        if (CardGiftImageUI.f(CardGiftImageUI.this).getVisibility() != 0) {
          CardGiftImageUI.f(CardGiftImageUI.this).setVisibility(0);
        }
        AppMethodBeat.o(113325);
      }
    });
    AppMethodBeat.o(113337);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113335);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      bSg();
      AppMethodBeat.o(113335);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113335);
    return bool;
  }
  
  public final void eR(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113338);
    this.ocT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113326);
        if (CardGiftImageUI.f(CardGiftImageUI.this).getVisibility() != 8) {
          CardGiftImageUI.f(CardGiftImageUI.this).setVisibility(8);
        }
        CardGiftImageUI.a(CardGiftImageUI.this, paramString2);
        CardGiftImageUI.g(CardGiftImageUI.this);
        CardGiftImageUI.h(CardGiftImageUI.this).notifyDataSetChanged();
        AppMethodBeat.o(113326);
      }
    });
    AppMethodBeat.o(113338);
  }
  
  public int getLayoutId()
  {
    return 2131493280;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113330);
    this.ocQ = ((ImageView)findViewById(2131300336));
    this.ocS = ((ProgressBar)findViewById(2131300950));
    this.ocR = ((RelativeLayout)findViewById(2131300960));
    this.iBx = ((MMGestureGallery)findViewById(2131300335));
    this.iBx.setVerticalFadingEdgeEnabled(false);
    this.iBx.setHorizontalFadingEdgeEnabled(false);
    this.oda = new CardGiftImageUI.a(this, (byte)0);
    this.iBx.setAdapter(this.oda);
    this.iBx.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aOd()
      {
        AppMethodBeat.i(113318);
        CardGiftImageUI.this.bSg();
        AppMethodBeat.o(113318);
      }
    });
    this.iBx.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113319);
        h.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).ftL());
        AppMethodBeat.o(113319);
        return true;
      }
    });
    this.ocV = new e(this);
    AppMethodBeat.o(113330);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113329);
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    super.onCreate(paramBundle);
    hideTitleView();
    this.ocU = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.ocP = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.ocP == null) {}
    for (paramBundle = "null";; paramBundle = this.ocP.toString())
    {
      ac.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      ac.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.dmK });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      if ((this.ocP == null) || (bs.isNullOrNil(this.ocP.nUJ))) {
        break;
      }
      com.tencent.mm.plugin.card.d.a.g(this.ocP.nUJ, this.ocP.nUM, this.ocP.nUU, 2);
      AppMethodBeat.o(113329);
      return;
    }
    ac.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
    AppMethodBeat.o(113329);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113334);
    super.onDestroy();
    com.tencent.mm.plugin.card.d.a.b(this);
    AppMethodBeat.o(113334);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113333);
    super.onPause();
    AppMethodBeat.o(113333);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113332);
    super.onResume();
    if (this.oda != null) {
      this.oda.notifyDataSetChanged();
    }
    AppMethodBeat.o(113332);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113331);
    Bundle localBundle = this.ocU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ac.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113331);
      return;
      label63:
      this.ocW = getIntent().getIntExtra("img_top", 0);
      this.ocX = getIntent().getIntExtra("img_left", 0);
      this.ocY = getIntent().getIntExtra("img_width", 0);
      this.ocZ = getIntent().getIntExtra("img_height", 0);
      this.ocV.R(this.ocX, this.ocW, this.ocY, this.ocZ);
      if (localBundle == null) {
        this.ocR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(113322);
            CardGiftImageUI.c(CardGiftImageUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
            CardGiftImageUI.e(CardGiftImageUI.this).a(CardGiftImageUI.c(CardGiftImageUI.this), CardGiftImageUI.d(CardGiftImageUI.this), null);
            AppMethodBeat.o(113322);
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
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI
 * JD-Core Version:    0.7.0.1
 */