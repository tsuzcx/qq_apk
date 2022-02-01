package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.k.l;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public f rGl;
  protected LinearLayout rGm;
  protected String rGn;
  protected int rGo;
  protected int rGp;
  protected LinkedList<a> rGq;
  public LinkedList<Pair<d, d>> rGr;
  private int rGs;
  private b rGt;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.rGs = 0;
    this.rGq = new LinkedList();
    this.rGr = new LinkedList();
    this.rGl = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.rGm = new LinearLayout(paramContext);
    this.rGm.setOrientation(0);
    this.rGm.setGravity(16);
    this.rGm.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.rGm);
    AppMethodBeat.o(135519);
  }
  
  private void a(Animator paramAnimator, final Runnable paramRunnable)
  {
    AppMethodBeat.i(135528);
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(135516);
        if (paramRunnable != null) {
          a.this.post(paramRunnable);
        }
        AppMethodBeat.o(135516);
      }
    });
    paramAnimator.start();
    AppMethodBeat.o(135528);
  }
  
  private static int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(135534);
    paramInt = Math.round(paramContext.getResources().getDisplayMetrics().density * paramInt);
    AppMethodBeat.o(135534);
    return paramInt;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(135529);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135517);
        int i = 0;
        while (i < a.this.rGq.size())
        {
          a.this.a(a.this.rGm.getChildAt(i), (a.a)a.this.rGq.get(i));
          i += 1;
        }
        AppMethodBeat.o(135517);
      }
    });
    AppMethodBeat.o(135529);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(135521);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(135521);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(135521);
  }
  
  public final void Eo(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((a)this.rGq.get(this.rGs)).rGI = false;
    if ((paramInt > 0) && (paramInt < this.rGq.size())) {}
    for (this.rGs = paramInt;; this.rGs = 0)
    {
      ((a)this.rGq.get(this.rGs)).rGI = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public final void T(boolean paramBoolean)
  {
    AppMethodBeat.i(135527);
    int j = getHeight();
    int i;
    final ObjectAnimator localObjectAnimator;
    if ("top".equals(this.rGn))
    {
      i = -1;
      localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { i * j, 0.0F });
      if (!paramBoolean) {
        break label92;
      }
    }
    label92:
    for (long l = 250L;; l = 0L)
    {
      localObjectAnimator.setDuration(l);
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135515);
          a.this.setVisibility(0);
          a.a(a.this, localObjectAnimator);
          AppMethodBeat.o(135515);
        }
      });
      AppMethodBeat.o(135527);
      return;
      i = 1;
      break;
    }
  }
  
  public final void a(int paramInt, String paramString, d paramd1, d paramd2)
  {
    AppMethodBeat.i(135524);
    if (paramInt >= this.rGq.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    a locala = (a)this.rGq.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.cqs() == null) {
        paramString = locala.rGG;
      }
      locala.rGG = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.cqs() == null) {
        paramString = locala.rGH;
      }
      locala.rGH = paramString;
    }
    refreshView();
    AppMethodBeat.o(135524);
  }
  
  protected final void a(View paramView, a parama)
  {
    AppMethodBeat.i(135531);
    final RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(a.d.app_brand_tab_bar_item_container);
    final ImageView localImageView1 = (ImageView)paramView.findViewById(a.d.app_brand_tab_bar_item_icon);
    final TextView localTextView1 = (TextView)paramView.findViewById(a.d.app_brand_tab_bar_item_badge);
    final ImageView localImageView2 = (ImageView)paramView.findViewById(a.d.app_brand_tab_bar_item_red_dot);
    final TextView localTextView2 = (TextView)paramView.findViewById(a.d.app_brand_tab_bar_item_text);
    View localView = paramView.findViewById(a.d.app_brand_tab_bar_item_indicator);
    int i;
    if ("top".equals(this.rGn))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.rGI)
      {
        localView.setBackgroundColor(this.rGp);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.rGL, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.rGK.isEmpty()) {
          break label592;
        }
        i = 4;
        label180:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.rGK);
        localTextView1.setTextColor(parama.rGM);
        if (!parama.rGJ) {
          break label597;
        }
        i = 0;
        label213:
        localImageView2.setVisibility(i);
        if ((!parama.rGI) || (parama.rGH.cqs() == null)) {
          break label602;
        }
        parama.rGH.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(135506);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(135506);
          }
        });
        parama.rGH.cqr();
        label260:
        localTextView2.setText(parama.mText);
        if (!parama.rGI) {
          break label629;
        }
        localTextView2.setTextColor(this.rGp);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.rGn)) {
        localTextView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(135508);
            int i = localTextView2.getMeasuredWidth() - localImageView1.getMeasuredWidth() >> 1;
            if ((i > 0) && (localImageView1.getVisibility() != 8))
            {
              localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
              int j = a.this.getResources().getDimensionPixelSize(com.tencent.luggage.wxa.a.b.app_brand_tabbar_item_badge_default_margin_start) - i;
              if (localLayoutParams.leftMargin != j)
              {
                localLayoutParams.leftMargin = j;
                localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
              }
              localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
              i = a.this.getResources().getDimensionPixelSize(com.tencent.luggage.wxa.a.b.app_brand_tabbar_item_reddot_default_margin_start) - i;
              if (localLayoutParams.leftMargin != i)
              {
                localLayoutParams.leftMargin = i;
                localRelativeLayout.updateViewLayout(localImageView2, localLayoutParams);
              }
              AppMethodBeat.o(135508);
              return;
            }
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
            i = a.this.getResources().getDimensionPixelSize(com.tencent.luggage.wxa.a.b.app_brand_tabbar_item_badge_default_margin_start);
            if (localLayoutParams.leftMargin != i)
            {
              localLayoutParams.leftMargin = i;
              localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
            }
            localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
            i = a.this.getResources().getDimensionPixelSize(com.tencent.luggage.wxa.a.b.app_brand_tabbar_item_reddot_default_margin_start);
            if (localLayoutParams.leftMargin != i)
            {
              localLayoutParams.leftMargin = i;
              localRelativeLayout.updateViewLayout(localImageView2, localLayoutParams);
            }
            AppMethodBeat.o(135508);
          }
        });
      }
      AppMethodBeat.o(135531);
      return;
      localView.setVisibility(4);
      break;
      if (parama.rGG.cqs() != null) {
        if ((parama.mText != null) && (!parama.mText.equals("")))
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 54), 1.0F));
          localImageView1.setVisibility(0);
          localImageView1.getLayoutParams().width = fromDPToPix(getContext(), 32);
          localImageView1.getLayoutParams().height = fromDPToPix(getContext(), 28);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 12.0F);
        }
      }
      for (;;)
      {
        localView.setVisibility(4);
        break;
        paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 48), 1.0F));
        localImageView1.setVisibility(0);
        localImageView1.getLayoutParams().width = fromDPToPix(getContext(), 32);
        localImageView1.getLayoutParams().height = fromDPToPix(getContext(), 28);
        localTextView2.setVisibility(8);
        continue;
        if ((parama.mText != null) && (!parama.mText.equals("")))
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 49), 1.0F));
          localImageView1.setVisibility(8);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 16.0F);
        }
      }
      label592:
      i = 0;
      break label180;
      label597:
      i = 4;
      break label213;
      label602:
      parama.rGG.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(135507);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(135507);
        }
      });
      parama.rGG.cqr();
      break label260;
      label629:
      localTextView2.setTextColor(this.rGo);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(242585);
    a locala = new a();
    locala.rGG = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135510);
        super.a(paramAnonymousString, paramAnonymousd);
        Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135510);
      }
    });
    locala.rGH = new b(paramString4, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135511);
        super.a(paramAnonymousString, paramAnonymousd);
        Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135511);
      }
    });
    locala.mText = paramString2;
    locala.mUrl = paramString1;
    this.rGr.add(new Pair(locala.rGG, locala.rGH));
    if ((locala.mText == null) && ((locala.rGG.cqs() == null) || (locala.rGH.cqs() == null)))
    {
      Log.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(242585);
      return;
    }
    if (paramAppBrandTabBarItem != null) {}
    for (;;)
    {
      a(paramAppBrandTabBarItem, locala);
      paramAppBrandTabBarItem.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135512);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          int i = a.this.rGm.indexOfChild(paramAnonymousView);
          a.this.Eo(i);
          a.this.cqp();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135512);
        }
      });
      this.rGq.add(locala);
      this.rGm.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(242585);
      return;
      paramAppBrandTabBarItem = new AppBrandTabBarItem(getContext());
    }
  }
  
  public final int anN(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.rGq;
    String str = l.eo(paramString);
    Iterator localIterator = this.rGq.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a)localIterator.next();
    } while (!l.eo(paramString.mUrl).equals(str));
    for (;;)
    {
      int i = localLinkedList.indexOf(paramString);
      AppMethodBeat.o(135533);
      return i;
      paramString = null;
    }
  }
  
  protected final void b(final Bitmap paramBitmap, final ImageView paramImageView)
  {
    AppMethodBeat.i(135532);
    paramImageView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135509);
        paramImageView.setImageBitmap(paramBitmap);
        AppMethodBeat.o(135509);
      }
    });
    AppMethodBeat.o(135532);
  }
  
  protected final void cqp()
  {
    AppMethodBeat.i(135530);
    if (this.rGt != null) {
      this.rGt.as(this.rGs, ((a)this.rGq.get(this.rGs)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = g.cO(paramString3, 0);
    int k = g.cO(paramString4, -1);
    int i = 0;
    if (i < this.rGq.size())
    {
      if (i == paramInt)
      {
        ((a)this.rGq.get(i)).cqq();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a)this.rGq.get(i)).rGJ = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a)this.rGq.get(i)).rGK = paramString2;
          ((a)this.rGq.get(i)).rGL = j;
          ((a)this.rGq.get(i)).rGM = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a)this.rGq.get(i)).rGJ = false;
          ((a)this.rGq.get(i)).rGK = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public final void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(135526);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new a.9(this, paramBoolean));
      AppMethodBeat.o(135526);
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.rGn))
    {
      i = -1;
      localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, i * j });
      if (!paramBoolean) {
        break label116;
      }
    }
    label116:
    for (long l = 250L;; l = 0L)
    {
      localObjectAnimator.setDuration(l);
      a(localObjectAnimator, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135514);
          a.this.setVisibility(8);
          AppMethodBeat.o(135514);
        }
      });
      AppMethodBeat.o(135526);
      return;
      i = 1;
      break;
    }
  }
  
  public String getPosition()
  {
    return this.rGn;
  }
  
  public final void m(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(135520);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135505);
        a.a(a.this, paramString1, paramString2);
        a.b(a.this, paramString3, paramString4);
        a.a(a.this);
        AppMethodBeat.o(135505);
      }
    });
    AppMethodBeat.o(135520);
  }
  
  public void setClickListener(b paramb)
  {
    this.rGt = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.rGn = paramString;
  }
  
  public static final class a
  {
    public String mText;
    public String mUrl;
    public d rGG;
    public d rGH;
    public boolean rGI;
    public boolean rGJ;
    public String rGK;
    public int rGL;
    public int rGM;
    
    public a()
    {
      AppMethodBeat.i(135518);
      this.rGI = false;
      cqq();
      AppMethodBeat.o(135518);
    }
    
    final void cqq()
    {
      this.rGJ = false;
      this.rGK = "";
      this.rGL = 0;
      this.rGM = -1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void as(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */