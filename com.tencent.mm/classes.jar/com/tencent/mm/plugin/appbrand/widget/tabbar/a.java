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
import android.widget.TextView;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  protected int nuA;
  protected int nuB;
  protected LinkedList<a> nuC;
  public LinkedList<Pair<d, d>> nuD;
  private int nuE;
  private a.b nuF;
  public f nux;
  public LinearLayout nuy;
  protected String nuz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.nuE = 0;
    this.nuC = new LinkedList();
    this.nuD = new LinkedList();
    this.nux = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.nuy = new LinearLayout(paramContext);
    this.nuy.setOrientation(0);
    this.nuy.setGravity(16);
    this.nuy.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.nuy);
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
        while (i < a.this.nuC.size())
        {
          a.this.a(a.this.nuy.getChildAt(i), (a.a)a.this.nuC.get(i));
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
  
  public final int Wr(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.nuC;
    String str = k.dt(paramString);
    Iterator localIterator = this.nuC.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a)localIterator.next();
    } while (!k.dt(paramString.mUrl).equals(str));
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
    if (paramInt >= this.nuC.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    a locala = (a)this.nuC.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.bGH() == null) {
        paramString = locala.nuS;
      }
      locala.nuS = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.bGH() == null) {
        paramString = locala.nuT;
      }
      locala.nuT = paramString;
    }
    refreshView();
    AppMethodBeat.o(135524);
  }
  
  protected void a(View paramView, a parama)
  {
    AppMethodBeat.i(135531);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131307143);
    final ImageView localImageView1 = (ImageView)paramView.findViewById(2131307144);
    TextView localTextView1 = (TextView)paramView.findViewById(2131307142);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131307147);
    TextView localTextView2 = (TextView)paramView.findViewById(2131307148);
    View localView = paramView.findViewById(2131307146);
    int i;
    if ("top".equals(this.nuz))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.nuU)
      {
        localView.setBackgroundColor(this.nuB);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.nuX, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.nuW.isEmpty()) {
          break label592;
        }
        i = 4;
        label180:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.nuW);
        localTextView1.setTextColor(parama.nuY);
        if (!parama.nuV) {
          break label597;
        }
        i = 0;
        label213:
        localImageView2.setVisibility(i);
        if ((!parama.nuU) || (parama.nuT.bGH() == null)) {
          break label602;
        }
        parama.nuT.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(135506);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(135506);
          }
        });
        parama.nuT.bGG();
        label260:
        localTextView2.setText(parama.mText);
        if (!parama.nuU) {
          break label629;
        }
        localTextView2.setTextColor(this.nuB);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.nuz)) {
        localTextView2.post(new a.4(this, localTextView2, localImageView1, localTextView1, localRelativeLayout, localImageView2));
      }
      AppMethodBeat.o(135531);
      return;
      localView.setVisibility(4);
      break;
      if (parama.nuS.bGH() != null) {
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
      parama.nuS.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(135507);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(135507);
        }
      });
      parama.nuS.bGG();
      break label260;
      label629:
      localTextView2.setTextColor(this.nuA);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(208028);
    a locala = new a();
    locala.nuS = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135510);
        super.a(paramAnonymousString, paramAnonymousd);
        ae.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135510);
      }
    });
    locala.nuT = new b(paramString4, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135511);
        super.a(paramAnonymousString, paramAnonymousd);
        ae.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135511);
      }
    });
    locala.mText = paramString2;
    locala.mUrl = paramString1;
    this.nuD.add(new Pair(locala.nuS, locala.nuT));
    if ((locala.mText == null) && ((locala.nuS.bGH() == null) || (locala.nuT.bGH() == null)))
    {
      ae.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(208028);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          int i = a.this.nuy.indexOfChild(paramAnonymousView);
          a.this.xc(i);
          a.this.bGE();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135512);
        }
      });
      this.nuC.add(locala);
      this.nuy.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(208028);
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
    if ("top".equals(this.nuz))
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
  
  public final void bGE()
  {
    AppMethodBeat.i(135530);
    if (this.nuF != null) {
      this.nuF.ao(this.nuE, ((a)this.nuC.get(this.nuE)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = g.ck(paramString3, 0);
    int k = g.ck(paramString4, -1);
    int i = 0;
    if (i < this.nuC.size())
    {
      if (i == paramInt)
      {
        ((a)this.nuC.get(i)).bGF();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a)this.nuC.get(i)).nuV = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a)this.nuC.get(i)).nuW = paramString2;
          ((a)this.nuC.get(i)).nuX = j;
          ((a)this.nuC.get(i)).nuY = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a)this.nuC.get(i)).nuV = false;
          ((a)this.nuC.get(i)).nuW = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public final void dX(final boolean paramBoolean)
  {
    AppMethodBeat.i(135526);
    if (!ar.isMainThread())
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135513);
          a.this.dX(paramBoolean);
          AppMethodBeat.o(135513);
        }
      });
      AppMethodBeat.o(135526);
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.nuz))
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
    return this.nuz;
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
  
  public void setClickListener(a.b paramb)
  {
    this.nuF = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.nuz = paramString;
  }
  
  public final void xc(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((a)this.nuC.get(this.nuE)).nuU = false;
    if ((paramInt > 0) && (paramInt < this.nuC.size())) {}
    for (this.nuE = paramInt;; this.nuE = 0)
    {
      ((a)this.nuC.get(this.nuE)).nuU = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public static final class a
  {
    public String mText;
    public String mUrl;
    public d nuS;
    public d nuT;
    public boolean nuU;
    public boolean nuV;
    public String nuW;
    public int nuX;
    public int nuY;
    
    public a()
    {
      AppMethodBeat.i(135518);
      this.nuU = false;
      bGF();
      AppMethodBeat.o(135518);
    }
    
    final void bGF()
    {
      this.nuV = false;
      this.nuW = "";
      this.nuX = 0;
      this.nuY = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */