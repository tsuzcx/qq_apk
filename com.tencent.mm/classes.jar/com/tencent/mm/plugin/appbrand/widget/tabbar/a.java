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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public f mOQ;
  public LinearLayout mOR;
  protected String mOS;
  protected int mOT;
  protected int mOU;
  protected LinkedList<a> mOV;
  public LinkedList<Pair<d, d>> mOW;
  private int mOX;
  private b mOY;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.mOX = 0;
    this.mOV = new LinkedList();
    this.mOW = new LinkedList();
    this.mOQ = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.mOR = new LinearLayout(paramContext);
    this.mOR.setOrientation(0);
    this.mOR.setGravity(16);
    this.mOR.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.mOR);
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
        while (i < a.this.mOV.size())
        {
          a.this.a(a.this.mOR.getChildAt(i), (a.a)a.this.mOV.get(i));
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
  
  public final int Si(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.mOV;
    String str = k.cp(paramString);
    Iterator localIterator = this.mOV.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a)localIterator.next();
    } while (!k.cp(paramString.mUrl).equals(str));
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
    if (paramInt >= this.mOV.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    a locala = (a)this.mOV.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.bBK() == null) {
        paramString = locala.mPl;
      }
      locala.mPl = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.bBK() == null) {
        paramString = locala.mPm;
      }
      locala.mPm = paramString;
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
    if ("top".equals(this.mOS))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.mPn)
      {
        localView.setBackgroundColor(this.mOU);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.mPq, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.mPp.isEmpty()) {
          break label592;
        }
        i = 4;
        label180:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.mPp);
        localTextView1.setTextColor(parama.mPr);
        if (!parama.mPo) {
          break label597;
        }
        i = 0;
        label213:
        localImageView2.setVisibility(i);
        if ((!parama.mPn) || (parama.mPm.bBK() == null)) {
          break label602;
        }
        parama.mPm.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(135506);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(135506);
          }
        });
        parama.mPm.bBJ();
        label260:
        localTextView2.setText(parama.mText);
        if (!parama.mPn) {
          break label629;
        }
        localTextView2.setTextColor(this.mOU);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.mOS)) {
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
      if (parama.mPl.bBK() != null) {
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
      parama.mPl.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(135507);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(135507);
        }
      });
      parama.mPl.bBJ();
      break label260;
      label629:
      localTextView2.setTextColor(this.mOT);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(193552);
    a locala = new a();
    locala.mPl = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135510);
        super.a(paramAnonymousString, paramAnonymousd);
        ac.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135510);
      }
    });
    locala.mPm = new b(paramString4, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135511);
        super.a(paramAnonymousString, paramAnonymousd);
        ac.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135511);
      }
    });
    locala.mText = paramString2;
    locala.mUrl = paramString1;
    this.mOW.add(new Pair(locala.mPl, locala.mPm));
    if ((locala.mText == null) && ((locala.mPl.bBK() == null) || (locala.mPm.bBK() == null)))
    {
      ac.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(193552);
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
          int i = a.this.mOR.indexOfChild(paramAnonymousView);
          a.this.ws(i);
          a.this.bBH();
          AppMethodBeat.o(135512);
        }
      });
      this.mOV.add(locala);
      this.mOR.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(193552);
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
    if ("top".equals(this.mOS))
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
  
  public final void bBH()
  {
    AppMethodBeat.i(135530);
    if (this.mOY != null) {
      this.mOY.am(this.mOX, ((a)this.mOV.get(this.mOX)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = g.cd(paramString3, 0);
    int k = g.cd(paramString4, -1);
    int i = 0;
    if (i < this.mOV.size())
    {
      if (i == paramInt)
      {
        ((a)this.mOV.get(i)).bBI();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a)this.mOV.get(i)).mPo = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a)this.mOV.get(i)).mPp = paramString2;
          ((a)this.mOV.get(i)).mPq = j;
          ((a)this.mOV.get(i)).mPr = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a)this.mOV.get(i)).mPo = false;
          ((a)this.mOV.get(i)).mPp = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public final void dT(final boolean paramBoolean)
  {
    AppMethodBeat.i(135526);
    if (!ap.isMainThread())
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135513);
          a.this.dT(paramBoolean);
          AppMethodBeat.o(135513);
        }
      });
      AppMethodBeat.o(135526);
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.mOS))
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
    return this.mOS;
  }
  
  public final void k(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
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
    this.mOY = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.mOS = paramString;
  }
  
  public final void ws(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((a)this.mOV.get(this.mOX)).mPn = false;
    if ((paramInt > 0) && (paramInt < this.mOV.size())) {}
    for (this.mOX = paramInt;; this.mOX = 0)
    {
      ((a)this.mOV.get(this.mOX)).mPn = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public static final class a
  {
    public d mPl;
    public d mPm;
    public boolean mPn;
    public boolean mPo;
    public String mPp;
    public int mPq;
    public int mPr;
    public String mText;
    public String mUrl;
    
    public a()
    {
      AppMethodBeat.i(135518);
      this.mPn = false;
      bBI();
      AppMethodBeat.o(135518);
    }
    
    final void bBI()
    {
      this.mPo = false;
      this.mPp = "";
      this.mPq = 0;
      this.mPr = -1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void am(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */