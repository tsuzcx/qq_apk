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
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public f npn;
  public LinearLayout npo;
  protected String npp;
  protected int npq;
  protected int npr;
  protected LinkedList<a> nps;
  public LinkedList<Pair<d, d>> npt;
  private int npu;
  private b npv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.npu = 0;
    this.nps = new LinkedList();
    this.npt = new LinkedList();
    this.npn = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.npo = new LinearLayout(paramContext);
    this.npo.setOrientation(0);
    this.npo.setGravity(16);
    this.npo.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.npo);
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
        while (i < a.this.nps.size())
        {
          a.this.a(a.this.npo.getChildAt(i), (a.a)a.this.nps.get(i));
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
  
  public final int VF(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.nps;
    String str = k.dr(paramString);
    Iterator localIterator = this.nps.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a)localIterator.next();
    } while (!k.dr(paramString.mUrl).equals(str));
    for (;;)
    {
      int i = localLinkedList.indexOf(paramString);
      AppMethodBeat.o(135533);
      return i;
      paramString = null;
    }
  }
  
  public final void a(int paramInt, String paramString, d paramd1, d paramd2)
  {
    AppMethodBeat.i(135524);
    if (paramInt >= this.nps.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    a locala = (a)this.nps.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.bFM() == null) {
        paramString = locala.npI;
      }
      locala.npI = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.bFM() == null) {
        paramString = locala.npJ;
      }
      locala.npJ = paramString;
    }
    refreshView();
    AppMethodBeat.o(135524);
  }
  
  protected void a(View paramView, a parama)
  {
    AppMethodBeat.i(135531);
    final RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131307143);
    final ImageView localImageView1 = (ImageView)paramView.findViewById(2131307144);
    final TextView localTextView1 = (TextView)paramView.findViewById(2131307142);
    final ImageView localImageView2 = (ImageView)paramView.findViewById(2131307147);
    final TextView localTextView2 = (TextView)paramView.findViewById(2131307148);
    View localView = paramView.findViewById(2131307146);
    int i;
    if ("top".equals(this.npp))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.npK)
      {
        localView.setBackgroundColor(this.npr);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.npN, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.npM.isEmpty()) {
          break label592;
        }
        i = 4;
        label180:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.npM);
        localTextView1.setTextColor(parama.npO);
        if (!parama.npL) {
          break label597;
        }
        i = 0;
        label213:
        localImageView2.setVisibility(i);
        if ((!parama.npK) || (parama.npJ.bFM() == null)) {
          break label602;
        }
        parama.npJ.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(135506);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(135506);
          }
        });
        parama.npJ.bFL();
        label260:
        localTextView2.setText(parama.mText);
        if (!parama.npK) {
          break label629;
        }
        localTextView2.setTextColor(this.npr);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.npp)) {
        localTextView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(135508);
            int i = localTextView2.getMeasuredWidth() - localImageView1.getMeasuredWidth() >> 1;
            if ((i > 0) && (localImageView1.getVisibility() != 8))
            {
              localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
              int j = a.this.getResources().getDimensionPixelSize(2131165860) - i;
              if (localLayoutParams.leftMargin != j)
              {
                localLayoutParams.leftMargin = j;
                localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
              }
              localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
              i = a.this.getResources().getDimensionPixelSize(2131165861) - i;
              if (localLayoutParams.leftMargin != i)
              {
                localLayoutParams.leftMargin = i;
                localRelativeLayout.updateViewLayout(localImageView2, localLayoutParams);
              }
              AppMethodBeat.o(135508);
              return;
            }
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
            i = a.this.getResources().getDimensionPixelSize(2131165860);
            if (localLayoutParams.leftMargin != i)
            {
              localLayoutParams.leftMargin = i;
              localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
            }
            localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
            i = a.this.getResources().getDimensionPixelSize(2131165861);
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
      if (parama.npI.bFM() != null) {
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
      parama.npI.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(135507);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(135507);
        }
      });
      parama.npI.bFL();
      break label260;
      label629:
      localTextView2.setTextColor(this.npq);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(197473);
    a locala = new a();
    locala.npI = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135510);
        super.a(paramAnonymousString, paramAnonymousd);
        ad.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135510);
      }
    });
    locala.npJ = new b(paramString4, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135511);
        super.a(paramAnonymousString, paramAnonymousd);
        ad.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135511);
      }
    });
    locala.mText = paramString2;
    locala.mUrl = paramString1;
    this.npt.add(new Pair(locala.npI, locala.npJ));
    if ((locala.mText == null) && ((locala.npI.bFM() == null) || (locala.npJ.bFM() == null)))
    {
      ad.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(197473);
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          int i = a.this.npo.indexOfChild(paramAnonymousView);
          a.this.wX(i);
          a.this.bFJ();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135512);
        }
      });
      this.nps.add(locala);
      this.npo.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(197473);
      return;
      paramAppBrandTabBarItem = new AppBrandTabBarItem(getContext());
    }
  }
  
  public final void aF(boolean paramBoolean)
  {
    AppMethodBeat.i(135527);
    int j = getHeight();
    int i;
    final ObjectAnimator localObjectAnimator;
    if ("top".equals(this.npp))
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
  
  public final void b(final Bitmap paramBitmap, final ImageView paramImageView)
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
  
  public final void bFJ()
  {
    AppMethodBeat.i(135530);
    if (this.npv != null) {
      this.npv.ao(this.npu, ((a)this.nps.get(this.npu)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = g.cg(paramString3, 0);
    int k = g.cg(paramString4, -1);
    int i = 0;
    if (i < this.nps.size())
    {
      if (i == paramInt)
      {
        ((a)this.nps.get(i)).bFK();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a)this.nps.get(i)).npL = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a)this.nps.get(i)).npM = paramString2;
          ((a)this.nps.get(i)).npN = j;
          ((a)this.nps.get(i)).npO = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a)this.nps.get(i)).npL = false;
          ((a)this.nps.get(i)).npM = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public final void dV(boolean paramBoolean)
  {
    AppMethodBeat.i(135526);
    if (!aq.isMainThread())
    {
      aq.f(new a.9(this, paramBoolean));
      AppMethodBeat.o(135526);
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.npp))
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
    return this.npp;
  }
  
  public final void j(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
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
    this.npv = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.npp = paramString;
  }
  
  public final void wX(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((a)this.nps.get(this.npu)).npK = false;
    if ((paramInt > 0) && (paramInt < this.nps.size())) {}
    for (this.npu = paramInt;; this.npu = 0)
    {
      ((a)this.nps.get(this.npu)).npK = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public static final class a
  {
    public String mText;
    public String mUrl;
    public d npI;
    public d npJ;
    public boolean npK;
    public boolean npL;
    public String npM;
    public int npN;
    public int npO;
    
    public a()
    {
      AppMethodBeat.i(135518);
      this.npK = false;
      bFK();
      AppMethodBeat.o(135518);
    }
    
    final void bFK()
    {
      this.npL = false;
      this.npM = "";
      this.npN = 0;
      this.npO = -1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void ao(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */