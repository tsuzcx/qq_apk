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
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public f mmP;
  public LinearLayout mmQ;
  protected String mmR;
  protected int mmS;
  protected int mmT;
  protected LinkedList<a> mmU;
  public LinkedList<Pair<d, d>> mmV;
  private int mmW;
  private a.b mmX;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.mmW = 0;
    this.mmU = new LinkedList();
    this.mmV = new LinkedList();
    this.mmP = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.mmQ = new LinearLayout(paramContext);
    this.mmQ.setOrientation(0);
    this.mmQ.setGravity(16);
    this.mmQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.mmQ);
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
        while (i < a.this.mmU.size())
        {
          a.this.a(a.this.mmQ.getChildAt(i), (a.a)a.this.mmU.get(i));
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
  
  public final int NZ(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.mmU;
    String str = k.cA(paramString);
    Iterator localIterator = this.mmU.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a)localIterator.next();
    } while (!k.cA(paramString.mUrl).equals(str));
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
    if (paramInt >= this.mmU.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    a locala = (a)this.mmU.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.buN() == null) {
        paramString = locala.mnk;
      }
      locala.mnk = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.buN() == null) {
        paramString = locala.mnl;
      }
      locala.mnl = paramString;
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
    if ("top".equals(this.mmR))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.mnm)
      {
        localView.setBackgroundColor(this.mmT);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.mnp, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.mno.isEmpty()) {
          break label592;
        }
        i = 4;
        label180:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.mno);
        localTextView1.setTextColor(parama.mnq);
        if (!parama.mnn) {
          break label597;
        }
        i = 0;
        label213:
        localImageView2.setVisibility(i);
        if ((!parama.mnm) || (parama.mnl.buN() == null)) {
          break label602;
        }
        parama.mnl.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(135506);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(135506);
          }
        });
        parama.mnl.buM();
        label260:
        localTextView2.setText(parama.mText);
        if (!parama.mnm) {
          break label629;
        }
        localTextView2.setTextColor(this.mmT);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.mmR)) {
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
      if (parama.mnk.buN() != null) {
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
      parama.mnk.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(135507);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(135507);
        }
      });
      parama.mnk.buM();
      break label260;
      label629:
      localTextView2.setTextColor(this.mmS);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(194548);
    a locala = new a();
    locala.mnk = new b(paramString3, new a.6(this));
    locala.mnl = new b(paramString4, new a.7(this));
    locala.mText = paramString2;
    locala.mUrl = paramString1;
    this.mmV.add(new Pair(locala.mnk, locala.mnl));
    if ((locala.mText == null) && ((locala.mnk.buN() == null) || (locala.mnl.buN() == null)))
    {
      ad.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(194548);
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
          int i = a.this.mmQ.indexOfChild(paramAnonymousView);
          a.this.vB(i);
          a.this.buK();
          AppMethodBeat.o(135512);
        }
      });
      this.mmU.add(locala);
      this.mmQ.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(194548);
      return;
      paramAppBrandTabBarItem = new AppBrandTabBarItem(getContext());
    }
  }
  
  public final void aF(boolean paramBoolean)
  {
    AppMethodBeat.i(135527);
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.mmR))
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
      post(new a.11(this, localObjectAnimator));
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
  
  public final void buK()
  {
    AppMethodBeat.i(135530);
    if (this.mmX != null) {
      this.mmX.al(this.mmW, ((a)this.mmU.get(this.mmW)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = g.bY(paramString3, 0);
    int k = g.bY(paramString4, -1);
    int i = 0;
    if (i < this.mmU.size())
    {
      if (i == paramInt)
      {
        ((a)this.mmU.get(i)).buL();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a)this.mmU.get(i)).mnn = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a)this.mmU.get(i)).mno = paramString2;
          ((a)this.mmU.get(i)).mnp = j;
          ((a)this.mmU.get(i)).mnq = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a)this.mmU.get(i)).mnn = false;
          ((a)this.mmU.get(i)).mno = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public String getPosition()
  {
    return this.mmR;
  }
  
  public final void hH(boolean paramBoolean)
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
    if ("top".equals(this.mmR))
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
      a(localObjectAnimator, new a.10(this));
      AppMethodBeat.o(135526);
      return;
      i = 1;
      break;
    }
  }
  
  public final void i(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
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
    this.mmX = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.mmR = paramString;
  }
  
  public final void vB(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((a)this.mmU.get(this.mmW)).mnm = false;
    if ((paramInt > 0) && (paramInt < this.mmU.size())) {}
    for (this.mmW = paramInt;; this.mmW = 0)
    {
      ((a)this.mmU.get(this.mmW)).mnm = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public static final class a
  {
    public String mText;
    public String mUrl;
    public d mnk;
    public d mnl;
    public boolean mnm;
    public boolean mnn;
    public String mno;
    public int mnp;
    public int mnq;
    
    public a()
    {
      AppMethodBeat.i(135518);
      this.mnm = false;
      buL();
      AppMethodBeat.o(135518);
    }
    
    final void buL()
    {
      this.mnn = false;
      this.mno = "";
      this.mnp = 0;
      this.mnq = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */