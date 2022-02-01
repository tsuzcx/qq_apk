package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.a.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.tools.l;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI
  extends MMActivity
  implements a.a
{
  private String hQn;
  private boolean isAnimated;
  private MMGestureGallery pIt;
  private l sLE;
  private CardGiftInfo wAS;
  private ImageView wAT;
  private RelativeLayout wAU;
  private ProgressBar wAV;
  private MMHandler wAW;
  private Bundle wAX;
  private f wAY;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  private a wBd;
  
  public CardGiftImageUI()
  {
    AppMethodBeat.i(113328);
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.isAnimated = false;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    AppMethodBeat.o(113328);
  }
  
  public final void akZ(String paramString) {}
  
  public final void dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(113337);
    this.wAW.post(new Runnable()
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
      Log.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      dmJ();
      AppMethodBeat.o(113335);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113335);
    return bool;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(113336);
    this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
    this.wAY.a(this.wAU, this.wAT, new f.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113324);
        new MMHandler().post(new Runnable()
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
  
  public int getLayoutId()
  {
    return a.e.wmE;
  }
  
  public final void gj(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113338);
    this.wAW.post(new Runnable()
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
  
  public void initView()
  {
    AppMethodBeat.i(113330);
    this.wAT = ((ImageView)findViewById(a.d.gallery_bg));
    this.wAV = ((ProgressBar)findViewById(a.d.wki));
    this.wAU = ((RelativeLayout)findViewById(a.d.wkj));
    this.pIt = ((MMGestureGallery)findViewById(a.d.gallery));
    this.pIt.setVerticalFadingEdgeEnabled(false);
    this.pIt.setHorizontalFadingEdgeEnabled(false);
    this.wBd = new a((byte)0);
    this.pIt.setAdapter(this.wBd);
    this.pIt.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void singleClickOver()
      {
        AppMethodBeat.i(113318);
        CardGiftImageUI.this.dmJ();
        AppMethodBeat.o(113318);
      }
    });
    this.pIt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113319);
        k.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).jDd());
        AppMethodBeat.o(113319);
        return true;
      }
    });
    this.wAY = new f(this);
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
    this.wAX = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.wAS = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.wAS == null) {}
    for (paramBundle = "null";; paramBundle = this.wAS.toString())
    {
      Log.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      Log.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.hQn });
      initView();
      com.tencent.mm.plugin.card.c.a.a(this);
      if ((this.wAS == null) || (Util.isNullOrNil(this.wAS.wsP))) {
        break;
      }
      com.tencent.mm.plugin.card.c.a.h(this.wAS.wsP, this.wAS.wsS, this.wAS.wsZ, 2);
      AppMethodBeat.o(113329);
      return;
    }
    Log.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
    AppMethodBeat.o(113329);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113334);
    super.onDestroy();
    com.tencent.mm.plugin.card.c.a.b(this);
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
    if (this.wBd != null) {
      this.wBd.notifyDataSetChanged();
    }
    AppMethodBeat.o(113332);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113331);
    Bundle localBundle = this.wAX;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      Log.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113331);
      return;
      label63:
      this.wAZ = getIntent().getIntExtra("img_top", 0);
      this.wBa = getIntent().getIntExtra("img_left", 0);
      this.wBb = getIntent().getIntExtra("img_width", 0);
      this.wBc = getIntent().getIntExtra("img_height", 0);
      this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
      if (localBundle == null) {
        this.wAU.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
      Object localObject = r.Sg(CardGiftImageUI.b(CardGiftImageUI.this));
      if (localObject == null)
      {
        Log.w("MicroMsg.CardGiftImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), a.e.wnd, null);
          ((ImageView)((View)localObject).findViewById(a.d.image_iv)).setImageResource(a.f.download_image_icon);
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
        paramView.dU(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI
 * JD-Core Version:    0.7.0.1
 */