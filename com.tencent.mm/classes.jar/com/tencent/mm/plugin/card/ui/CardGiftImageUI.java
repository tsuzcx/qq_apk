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
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
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
  private String dRr;
  private boolean isAnimated;
  private MMGestureGallery jUy;
  private l mHj;
  private RelativeLayout qaA;
  private ProgressBar qaB;
  private MMHandler qaC;
  private Bundle qaD;
  private e qaE;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  private a qaJ;
  private CardGiftInfo qay;
  private ImageView qaz;
  
  public CardGiftImageUI()
  {
    AppMethodBeat.i(113328);
    this.qaC = new MMHandler(Looper.getMainLooper());
    this.isAnimated = false;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    AppMethodBeat.o(113328);
  }
  
  public final void ajH(String paramString) {}
  
  public final void cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(113337);
    this.qaC.post(new Runnable()
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
  
  public final void cvQ()
  {
    AppMethodBeat.i(113336);
    this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
    this.qaE.a(this.qaA, this.qaz, new e.c()
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
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113335);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      cvQ();
      AppMethodBeat.o(113335);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113335);
    return bool;
  }
  
  public final void fw(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113338);
    this.qaC.post(new Runnable()
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
    return 2131493369;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113330);
    this.qaz = ((ImageView)findViewById(2131301854));
    this.qaB = ((ProgressBar)findViewById(2131302583));
    this.qaA = ((RelativeLayout)findViewById(2131302596));
    this.jUy = ((MMGestureGallery)findViewById(2131301853));
    this.jUy.setVerticalFadingEdgeEnabled(false);
    this.jUy.setHorizontalFadingEdgeEnabled(false);
    this.qaJ = new a((byte)0);
    this.jUy.setAdapter(this.qaJ);
    this.jUy.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void bmt()
      {
        AppMethodBeat.i(113318);
        CardGiftImageUI.this.cvQ();
        AppMethodBeat.o(113318);
      }
    });
    this.jUy.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113319);
        h.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).gXI());
        AppMethodBeat.o(113319);
        return true;
      }
    });
    this.qaE = new e(this);
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
    this.qaD = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.qay = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.qay == null) {}
    for (paramBundle = "null";; paramBundle = this.qay.toString())
    {
      Log.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      Log.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.dRr });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      if ((this.qay == null) || (Util.isNullOrNil(this.qay.pSp))) {
        break;
      }
      com.tencent.mm.plugin.card.d.a.g(this.qay.pSp, this.qay.pSs, this.qay.pSA, 2);
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
    if (this.qaJ != null) {
      this.qaJ.notifyDataSetChanged();
    }
    AppMethodBeat.o(113332);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113331);
    Bundle localBundle = this.qaD;
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
      this.qaF = getIntent().getIntExtra("img_top", 0);
      this.qaG = getIntent().getIntExtra("img_left", 0);
      this.qaH = getIntent().getIntExtra("img_width", 0);
      this.qaI = getIntent().getIntExtra("img_height", 0);
      this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
      if (localBundle == null) {
        this.qaA.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
      Object localObject = u.Sq(CardGiftImageUI.b(CardGiftImageUI.this));
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
          localObject = View.inflate(paramViewGroup.getContext(), 2131493398, null);
          ((ImageView)((View)localObject).findViewById(2131302573)).setImageResource(2131690098);
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
        paramView.cN(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI
 * JD-Core Version:    0.7.0.1
 */