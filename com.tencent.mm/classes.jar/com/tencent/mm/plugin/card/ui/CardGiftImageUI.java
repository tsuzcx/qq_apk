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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  private String dzD;
  private MMGestureGallery iXA;
  private boolean isAnimated;
  private com.tencent.mm.ui.tools.l lzV;
  private CardGiftInfo oMK;
  private ImageView oML;
  private RelativeLayout oMM;
  private ProgressBar oMN;
  private aq oMO;
  private Bundle oMP;
  private e oMQ;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  private a oMV;
  
  public CardGiftImageUI()
  {
    AppMethodBeat.i(113328);
    this.oMO = new aq(Looper.getMainLooper());
    this.isAnimated = false;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    AppMethodBeat.o(113328);
  }
  
  public final void ZC(String paramString) {}
  
  public final void bYa()
  {
    AppMethodBeat.i(113336);
    this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
    this.oMQ.a(this.oMM, this.oML, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(113324);
        new aq().post(new Runnable()
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
  
  public final void cJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(113337);
    this.oMO.post(new Runnable()
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
      ae.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
      bYa();
      AppMethodBeat.o(113335);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113335);
    return bool;
  }
  
  public final void ff(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(113338);
    this.oMO.post(new Runnable()
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
    this.oML = ((ImageView)findViewById(2131300336));
    this.oMN = ((ProgressBar)findViewById(2131300950));
    this.oMM = ((RelativeLayout)findViewById(2131300960));
    this.iXA = ((MMGestureGallery)findViewById(2131300335));
    this.iXA.setVerticalFadingEdgeEnabled(false);
    this.iXA.setHorizontalFadingEdgeEnabled(false);
    this.oMV = new a((byte)0);
    this.iXA.setAdapter(this.oMV);
    this.iXA.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aRO()
      {
        AppMethodBeat.i(113318);
        CardGiftImageUI.this.bYa();
        AppMethodBeat.o(113318);
      }
    });
    this.iXA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(113319);
        h.a(CardGiftImageUI.this, CardGiftImageUI.a(CardGiftImageUI.this).fOP());
        AppMethodBeat.o(113319);
        return true;
      }
    });
    this.oMQ = new e(this);
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
    this.oMP = paramBundle;
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.oMK = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    if (this.oMK == null) {}
    for (paramBundle = "null";; paramBundle = this.oMK.toString())
    {
      ae.d("MicroMsg.CardGiftImageUI", "cardGiftInfo:%s", new Object[] { paramBundle });
      ae.i("MicroMsg.CardGiftImageUI", "imgPath:%s", new Object[] { this.dzD });
      initView();
      com.tencent.mm.plugin.card.d.a.a(this);
      if ((this.oMK == null) || (bu.isNullOrNil(this.oMK.oEG))) {
        break;
      }
      com.tencent.mm.plugin.card.d.a.g(this.oMK.oEG, this.oMK.oEJ, this.oMK.oER, 2);
      AppMethodBeat.o(113329);
      return;
    }
    ae.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
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
    if (this.oMV != null) {
      this.oMV.notifyDataSetChanged();
    }
    AppMethodBeat.o(113332);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(113331);
    Bundle localBundle = this.oMP;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12) {
        break label63;
      }
      ae.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    }
    for (;;)
    {
      super.onStart();
      AppMethodBeat.o(113331);
      return;
      label63:
      this.oMR = getIntent().getIntExtra("img_top", 0);
      this.oMS = getIntent().getIntExtra("img_left", 0);
      this.oMT = getIntent().getIntExtra("img_width", 0);
      this.oMU = getIntent().getIntExtra("img_height", 0);
      this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
      if (localBundle == null) {
        this.oMM.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
      Object localObject = u.Js(CardGiftImageUI.b(CardGiftImageUI.this));
      if (localObject == null)
      {
        ae.w("MicroMsg.CardGiftImageUI", "get image fail");
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