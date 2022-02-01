package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.c;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI
  extends MMActivity
  implements a.a
{
  private String dyy;
  private MMGestureGallery iUH;
  private boolean isAnimated;
  private com.tencent.mm.ui.tools.l lvx;
  private CardGiftInfo oGi;
  private ImageView oGj;
  private RelativeLayout oGk;
  private ProgressBar oGl;
  private ap oGm;
  private Bundle oGn;
  private e oGo;
  private int oGp;
  private int oGq;
  private int oGr;
  private int oGs;
  private a oGt;
  
  public CardGiftImageUI()
  {
    AppMethodBeat.i(113328);
    this.oGm = new ap(Looper.getMainLooper());
    this.isAnimated = false;
    this.oGp = 0;
    this.oGq = 0;
    this.oGr = 0;
    this.oGs = 0;
    AppMethodBeat.o(113328);
  }
  
  public final void YL(String paramString) {}
  
  public final void bWL()
  {
    AppMethodBeat.i(113336);
    this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
    this.oGo.a(this.oGk, this.oGj, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113324);
        new ap().post(new Runnable()
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
  
  public final void cF(String paramString, int paramInt)
  {
    AppMethodBeat.i(113337);
    this.oGm.post(new Runnable()
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
      ad.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      bWL();
      AppMethodBeat.o(113335);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113335);
    return bool;
  }
  
  public final void fb(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113338);
    this.oGm.post(new Runnable()
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
    this.oGj = ((ImageView)findViewById(2131300336));
    this.oGl = ((ProgressBar)findViewById(2131300950));
    this.oGk = ((RelativeLayout)findViewById(2131300960));
    this.iUH = ((MMGestureGallery)findViewById(2131300335));
    this.iUH.setVerticalFadingEdgeEnabled(false);
    this.iUH.setHorizontalFadingEdgeEnabled(false);
    this.oGt = new a((byte)0);
    this.iUH.setAdapter(this.oGt);
    this.iUH.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aRp()
      {
        AppMethodBeat.i(113318);
        CardGiftImageUI.this.bWL();
        AppMethodBeat.o(113318);
      }
    });
    this.iUH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113319);
        h.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).fKy());
        AppMethodBeat.o(113319);
        return true;
      }
    });
    this.oGo = new e(this);
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
    this.oGn = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.oGi = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.oGi == null) {}
    for (paramBundle = "null";; paramBundle = this.oGi.toString())
    {
      ad.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      ad.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.dyy });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      if ((this.oGi == null) || (bt.isNullOrNil(this.oGi.oye))) {
        break;
      }
      com.tencent.mm.plugin.card.d.a.g(this.oGi.oye, this.oGi.oyh, this.oGi.oyp, 2);
      AppMethodBeat.o(113329);
      return;
    }
    ad.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
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
    if (this.oGt != null) {
      this.oGt.notifyDataSetChanged();
    }
    AppMethodBeat.o(113332);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113331);
    Bundle localBundle = this.oGn;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ad.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113331);
      return;
      label63:
      this.oGp = getIntent().getIntExtra("img_top", 0);
      this.oGq = getIntent().getIntExtra("img_left", 0);
      this.oGr = getIntent().getIntExtra("img_width", 0);
      this.oGs = getIntent().getIntExtra("img_height", 0);
      this.oGo.R(this.oGq, this.oGp, this.oGr, this.oGs);
      if (localBundle == null) {
        this.oGk.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113327);
      Object localObject = u.IT(CardGiftImageUI.b(CardGiftImageUI.this));
      if (localObject == null)
      {
        ad.w("MicroMsg.CardGiftImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), 2131493308, null);
          ((ImageView)((View)localObject).findViewById(2131300943)).setImageResource(2131690066);
          ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(113327);
        return localObject;
      }
      paramViewGroup = paramViewGroup.getContext();
      if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
        paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), (byte)0);
      }
      for (;;)
      {
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.setMaxZoomDoubleTab(true);
        AppMethodBeat.o(113327);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI
 * JD-Core Version:    0.7.0.1
 */