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
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.m;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  protected int uRA;
  protected int uRB;
  protected LinkedList<b> uRC;
  public LinkedList<Pair<d, d>> uRD;
  private int uRE;
  private c uRF;
  public f uRx;
  protected LinearLayout uRy;
  protected String uRz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.uRE = 0;
    this.uRC = new LinkedList();
    this.uRD = new LinkedList();
    this.uRx = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.uRy = new LinearLayout(paramContext);
    this.uRy.setOrientation(0);
    this.uRy.setGravity(16);
    this.uRy.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.uRy);
    AppMethodBeat.o(135519);
  }
  
  private void a(final Animator paramAnimator, final Runnable paramRunnable)
  {
    AppMethodBeat.i(135528);
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(324137);
        if (paramRunnable != null) {
          a.this.post(paramRunnable);
        }
        paramAnimator.removeListener(this);
        AppMethodBeat.o(324137);
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
        AppMethodBeat.i(324134);
        int i = 0;
        while (i < a.this.uRC.size())
        {
          a.this.a(a.this.uRy.getChildAt(i), (a.b)a.this.uRC.get(i));
          i += 1;
        }
        AppMethodBeat.o(324134);
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
  
  public final void EO(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((b)this.uRC.get(this.uRE)).uRY = false;
    if ((paramInt > 0) && (paramInt < this.uRC.size())) {}
    for (this.uRE = paramInt;; this.uRE = 0)
    {
      ((b)this.uRC.get(this.uRE)).uRY = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public final void W(final boolean paramBoolean)
  {
    AppMethodBeat.i(135527);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324140);
          a.this.W(paramBoolean);
          AppMethodBeat.o(324140);
        }
      });
      AppMethodBeat.o(135527);
      return;
    }
    if ((getParent() instanceof a)) {
      ((a)getParent()).cEd();
    }
    if (!paramBoolean)
    {
      setVisibility(0);
      if ((getParent() instanceof a)) {
        ((a)getParent()).cEe();
      }
      AppMethodBeat.o(135527);
      return;
    }
    int j = getHeight();
    if ("top".equals(this.uRz)) {}
    for (int i = -1;; i = 1)
    {
      final ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { i * j, 0.0F });
      localObjectAnimator.setDuration(250L);
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135517);
          a.this.setVisibility(0);
          a.a(a.this, localObjectAnimator, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(324138);
              if ((a.this.getParent() instanceof a.a)) {
                ((a.a)a.this.getParent()).cEe();
              }
              AppMethodBeat.o(324138);
            }
          });
          AppMethodBeat.o(135517);
        }
      });
      AppMethodBeat.o(135527);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, d paramd1, d paramd2)
  {
    AppMethodBeat.i(135524);
    if (paramInt >= this.uRC.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    b localb = (b)this.uRC.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = localb.mText;
    }
    localb.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.cSZ() == null) {
        paramString = localb.uRW;
      }
      localb.uRW = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.cSZ() == null) {
        paramString = localb.uRX;
      }
      localb.uRX = paramString;
    }
    refreshView();
    AppMethodBeat.o(135524);
  }
  
  protected final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(135531);
    final RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(a.d.app_brand_tab_bar_item_container);
    final ImageView localImageView1 = (ImageView)paramView.findViewById(a.d.app_brand_tab_bar_item_icon);
    final TextView localTextView1 = (TextView)paramView.findViewById(a.d.app_brand_tab_bar_item_badge);
    final ImageView localImageView2 = (ImageView)paramView.findViewById(a.d.app_brand_tab_bar_item_red_dot);
    final TextView localTextView2 = (TextView)paramView.findViewById(a.d.app_brand_tab_bar_item_text);
    View localView = paramView.findViewById(a.d.app_brand_tab_bar_item_indicator);
    final boolean bool = com.tencent.mm.cd.a.mq(getContext());
    Log.d("MicroMsg.AppBrandPageTabBar", "setItemView, useLargerText: ".concat(String.valueOf(bool)));
    int i;
    if ("top".equals(this.uRz))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, (int)(fromDPToPix(getContext(), 40) * com.tencent.mm.cd.a.jO(getContext())), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(0, fromDPToPix(getContext(), 14) * com.tencent.mm.cd.a.jO(getContext()));
      if (paramb.uRY)
      {
        localView.setBackgroundColor(this.uRB);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(paramb.uSb, PorterDuff.Mode.SRC_ATOP);
        }
        if (!paramb.uSa.isEmpty()) {
          break label729;
        }
        i = 4;
        label231:
        localTextView1.setVisibility(i);
        localTextView1.setText(paramb.uSa);
        localTextView1.setTextColor(paramb.uSc);
        if (!paramb.uRZ) {
          break label734;
        }
        i = 0;
        label264:
        localImageView2.setVisibility(i);
        if ((!paramb.uRY) || (paramb.uRX.cSZ() == null)) {
          break label739;
        }
        paramb.uRX.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(324126);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(324126);
          }
        });
        paramb.uRX.cSY();
        label311:
        localTextView2.setText(paramb.mText);
        if (!paramb.uRY) {
          break label766;
        }
        localTextView2.setTextColor(this.uRB);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.uRz)) {
        localTextView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(324136);
            int i;
            if (bool)
            {
              i = a.ab(a.this.getContext(), -12);
              if (!bool) {
                break label202;
              }
            }
            label202:
            for (int j = a.ab(a.this.getContext(), -1);; j = a.ab(a.this.getContext(), -3))
            {
              int k = localTextView2.getMeasuredWidth() - localImageView1.getMeasuredWidth() >> 1;
              if ((k <= 0) || (localImageView1.getVisibility() == 8)) {
                break label218;
              }
              localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
              i -= k;
              if (localLayoutParams.leftMargin != i)
              {
                localLayoutParams.leftMargin = i;
                localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
              }
              localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
              i = j + k;
              Log.d("MicroMsg.AppBrandPageTabBar", "setItemView, marginRight: ".concat(String.valueOf(i)));
              if (localLayoutParams.rightMargin != i)
              {
                localLayoutParams.rightMargin = i;
                localRelativeLayout.updateViewLayout(localImageView2, localLayoutParams);
              }
              AppMethodBeat.o(324136);
              return;
              i = a.ab(a.this.getContext(), -8);
              break;
            }
            label218:
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
            if (localLayoutParams.leftMargin != i)
            {
              localLayoutParams.leftMargin = i;
              localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
            }
            localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
            if (localLayoutParams.rightMargin != j)
            {
              localLayoutParams.rightMargin = j;
              localRelativeLayout.updateViewLayout(localImageView2, localLayoutParams);
            }
            AppMethodBeat.o(324136);
          }
        });
      }
      AppMethodBeat.o(135531);
      return;
      localView.setVisibility(4);
      break;
      if (paramb.uRW.cSZ() != null) {
        if ((paramb.mText != null) && (!paramb.mText.equals("")))
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, (int)(fromDPToPix(getContext(), 56) * com.tencent.mm.cd.a.jO(getContext())), 1.0F));
          localImageView1.setVisibility(0);
          if (bool)
          {
            i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 34);
            label473:
            localImageView1.getLayoutParams().width = i;
            localImageView1.getLayoutParams().height = i;
            localTextView2.setVisibility(0);
            localTextView2.setTextSize(0, fromDPToPix(getContext(), 12) * com.tencent.mm.cd.a.jO(getContext()));
          }
        }
      }
      for (;;)
      {
        localView.setVisibility(4);
        break;
        i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 28);
        break label473;
        paramView.setLayoutParams(new LinearLayout.LayoutParams(0, (int)(fromDPToPix(getContext(), 48) * com.tencent.mm.cd.a.jO(getContext())), 1.0F));
        localImageView1.setVisibility(0);
        if (bool) {}
        for (i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 34);; i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 28))
        {
          localImageView1.getLayoutParams().width = i;
          localImageView1.getLayoutParams().height = i;
          localTextView2.setVisibility(8);
          break;
        }
        if ((paramb.mText != null) && (!paramb.mText.equals("")))
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, (int)(fromDPToPix(getContext(), 49) * com.tencent.mm.cd.a.jO(getContext())), 1.0F));
          localImageView1.setVisibility(8);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(0, fromDPToPix(getContext(), 16) * com.tencent.mm.cd.a.jO(getContext()));
        }
      }
      label729:
      i = 0;
      break label231;
      label734:
      i = 4;
      break label264;
      label739:
      paramb.uRW.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(324123);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(324123);
        }
      });
      paramb.uRW.cSY();
      break label311;
      label766:
      localTextView2.setTextColor(this.uRA);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(324162);
    final b localb = new b();
    localb.uRW = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135510);
        super.a(paramAnonymousString, paramAnonymousd);
        Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135510);
      }
    });
    localb.uRX = new b(paramString4, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135511);
        super.a(paramAnonymousString, paramAnonymousd);
        Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135511);
      }
    });
    localb.mText = paramString2;
    localb.mUrl = paramString1;
    this.uRD.add(new Pair(localb.uRW, localb.uRX));
    if ((localb.mText == null) && ((localb.uRW.cSZ() == null) || (localb.uRX.cSZ() == null)))
    {
      Log.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(324162);
      return;
    }
    if (paramAppBrandTabBarItem != null) {}
    for (;;)
    {
      a(paramAppBrandTabBarItem, localb);
      com.tencent.mm.plugin.appbrand.widget.a.c.a(paramAppBrandTabBarItem, new kotlin.g.a.a() {}, null);
      paramAppBrandTabBarItem.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(324142);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          int i = a.this.uRy.indexOfChild(paramAnonymousView);
          a.this.EO(i);
          a.this.cSW();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(324142);
        }
      });
      this.uRC.add(localb);
      this.uRy.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(324162);
      return;
      paramAppBrandTabBarItem = new AppBrandTabBarItem(getContext());
    }
  }
  
  public final int ahl(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.uRC;
    String str = m.fL(paramString);
    Iterator localIterator = this.uRC.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (b)localIterator.next();
    } while (!m.fL(paramString.mUrl).equals(str));
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
        AppMethodBeat.i(324129);
        paramImageView.setImageBitmap(paramBitmap);
        AppMethodBeat.o(324129);
      }
    });
    AppMethodBeat.o(135532);
  }
  
  protected final void cSW()
  {
    AppMethodBeat.i(135530);
    if (this.uRF != null) {
      this.uRF.aD(this.uRE, ((b)this.uRC.get(this.uRE)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = i.dq(paramString3, 0);
    int k = i.dq(paramString4, -1);
    int i = 0;
    if (i < this.uRC.size())
    {
      if (i == paramInt)
      {
        ((b)this.uRC.get(i)).cSX();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((b)this.uRC.get(i)).uRZ = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((b)this.uRC.get(i)).uSa = paramString2;
          ((b)this.uRC.get(i)).uSb = j;
          ((b)this.uRC.get(i)).uSc = k;
        }
        else if ("none".equals(paramString1))
        {
          ((b)this.uRC.get(i)).uRZ = false;
          ((b)this.uRC.get(i)).uSa = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public final void gc(final boolean paramBoolean)
  {
    AppMethodBeat.i(135526);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135514);
          a.this.gc(paramBoolean);
          AppMethodBeat.o(135514);
        }
      });
      AppMethodBeat.o(135526);
      return;
    }
    if ((getParent() instanceof a)) {
      ((a)getParent()).kn(paramBoolean);
    }
    if (!paramBoolean)
    {
      setVisibility(8);
      if ((getParent() instanceof a)) {
        getParent();
      }
      AppMethodBeat.o(135526);
      return;
    }
    int j = getHeight();
    if ("top".equals(this.uRz)) {}
    for (int i = -1;; i = 1)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, i * j });
      localObjectAnimator.setDuration(250L);
      a(localObjectAnimator, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135515);
          a.this.setVisibility(8);
          if ((a.this.getParent() instanceof a.a)) {
            a.this.getParent();
          }
          AppMethodBeat.o(135515);
        }
      });
      AppMethodBeat.o(135526);
      return;
    }
  }
  
  public String getPosition()
  {
    return this.uRz;
  }
  
  public final void l(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
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
  
  public void setClickListener(c paramc)
  {
    this.uRF = paramc;
  }
  
  public void setPosition(String paramString)
  {
    this.uRz = paramString;
  }
  
  public static abstract interface a
    extends ViewParent
  {
    public abstract void cEd();
    
    public abstract void cEe();
    
    public abstract void kn(boolean paramBoolean);
  }
  
  public static final class b
  {
    public String mText;
    public String mUrl;
    public d uRW;
    public d uRX;
    public boolean uRY;
    public boolean uRZ;
    public String uSa;
    public int uSb;
    public int uSc;
    
    public b()
    {
      AppMethodBeat.i(135518);
      this.uRY = false;
      cSX();
      AppMethodBeat.o(135518);
    }
    
    final void cSX()
    {
      this.uRZ = false;
      this.uSa = "";
      this.uSb = 0;
      this.uSc = -1;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aD(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */