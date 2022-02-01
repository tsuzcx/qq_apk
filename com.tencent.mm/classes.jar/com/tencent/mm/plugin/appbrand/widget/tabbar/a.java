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
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public f oEB;
  protected LinearLayout oEC;
  protected String oED;
  protected int oEE;
  protected int oEF;
  protected LinkedList<a> oEG;
  public LinkedList<Pair<d, d>> oEH;
  private int oEI;
  private b oEJ;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135519);
    this.oEI = 0;
    this.oEG = new LinkedList();
    this.oEH = new LinkedList();
    this.oEB = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.oEC = new LinearLayout(paramContext);
    this.oEC.setOrientation(0);
    this.oEC.setGravity(16);
    this.oEC.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.oEC);
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
        while (i < a.this.oEG.size())
        {
          a.this.a(a.this.oEC.getChildAt(i), (a.a)a.this.oEG.get(i));
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
  
  public final void AI(int paramInt)
  {
    AppMethodBeat.i(135523);
    ((a)this.oEG.get(this.oEI)).oEY = false;
    if ((paramInt > 0) && (paramInt < this.oEG.size())) {}
    for (this.oEI = paramInt;; this.oEI = 0)
    {
      ((a)this.oEG.get(this.oEI)).oEY = true;
      refreshView();
      AppMethodBeat.o(135523);
      return;
    }
  }
  
  public final void a(int paramInt, String paramString, d paramd1, d paramd2)
  {
    AppMethodBeat.i(135524);
    if (paramInt >= this.oEG.size())
    {
      AppMethodBeat.o(135524);
      return;
    }
    a locala = (a)this.oEG.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.cdg() == null) {
        paramString = locala.oEW;
      }
      locala.oEW = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.cdg() == null) {
        paramString = locala.oEX;
      }
      locala.oEX = paramString;
    }
    refreshView();
    AppMethodBeat.o(135524);
  }
  
  protected final void a(View paramView, a parama)
  {
    AppMethodBeat.i(135531);
    final RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131296920);
    final ImageView localImageView1 = (ImageView)paramView.findViewById(2131296921);
    final TextView localTextView1 = (TextView)paramView.findViewById(2131296919);
    final ImageView localImageView2 = (ImageView)paramView.findViewById(2131296924);
    final TextView localTextView2 = (TextView)paramView.findViewById(2131296925);
    View localView = paramView.findViewById(2131296923);
    int i;
    if ("top".equals(this.oED))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.oEY)
      {
        localView.setBackgroundColor(this.oEF);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.oFb, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.oFa.isEmpty()) {
          break label592;
        }
        i = 4;
        label180:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.oFa);
        localTextView1.setTextColor(parama.oFc);
        if (!parama.oEZ) {
          break label597;
        }
        i = 0;
        label213:
        localImageView2.setVisibility(i);
        if ((!parama.oEY) || (parama.oEX.cdg() == null)) {
          break label602;
        }
        parama.oEX.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(135506);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.this.b(paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(135506);
          }
        });
        parama.oEX.cdf();
        label260:
        localTextView2.setText(parama.mText);
        if (!parama.oEY) {
          break label629;
        }
        localTextView2.setTextColor(this.oEF);
      }
    }
    for (;;)
    {
      if (!"top".equals(this.oED)) {
        localTextView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(135508);
            int i = localTextView2.getMeasuredWidth() - localImageView1.getMeasuredWidth() >> 1;
            if ((i > 0) && (localImageView1.getVisibility() != 8))
            {
              localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
              int j = a.this.getResources().getDimensionPixelSize(2131165886) - i;
              if (localLayoutParams.leftMargin != j)
              {
                localLayoutParams.leftMargin = j;
                localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
              }
              localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
              i = a.this.getResources().getDimensionPixelSize(2131165887) - i;
              if (localLayoutParams.leftMargin != i)
              {
                localLayoutParams.leftMargin = i;
                localRelativeLayout.updateViewLayout(localImageView2, localLayoutParams);
              }
              AppMethodBeat.o(135508);
              return;
            }
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
            i = a.this.getResources().getDimensionPixelSize(2131165886);
            if (localLayoutParams.leftMargin != i)
            {
              localLayoutParams.leftMargin = i;
              localRelativeLayout.updateViewLayout(localTextView1, localLayoutParams);
            }
            localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
            i = a.this.getResources().getDimensionPixelSize(2131165887);
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
      if (parama.oEW.cdg() != null) {
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
      parama.oEW.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(135507);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.this.b(paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(135507);
        }
      });
      parama.oEW.cdf();
      break label260;
      label629:
      localTextView2.setTextColor(this.oEE);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(219635);
    a locala = new a();
    locala.oEW = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(135510);
        super.a(paramAnonymousString, paramAnonymousd);
        Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(135510);
      }
    });
    locala.oEX = new b(paramString4, new c()
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
    this.oEH.add(new Pair(locala.oEW, locala.oEX));
    if ((locala.mText == null) && ((locala.oEW.cdg() == null) || (locala.oEX.cdg() == null)))
    {
      Log.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(219635);
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          int i = a.this.oEC.indexOfChild(paramAnonymousView);
          a.this.AI(i);
          a.this.cdd();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135512);
        }
      });
      this.oEG.add(locala);
      this.oEC.addView(paramAppBrandTabBarItem);
      AppMethodBeat.o(219635);
      return;
      paramAppBrandTabBarItem = new AppBrandTabBarItem(getContext());
    }
  }
  
  public final void aD(boolean paramBoolean)
  {
    AppMethodBeat.i(135527);
    int j = getHeight();
    int i;
    final ObjectAnimator localObjectAnimator;
    if ("top".equals(this.oED))
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
  
  public final int agk(String paramString)
  {
    AppMethodBeat.i(135533);
    LinkedList localLinkedList = this.oEG;
    String str = l.dM(paramString);
    Iterator localIterator = this.oEG.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a)localIterator.next();
    } while (!l.dM(paramString.mUrl).equals(str));
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
  
  protected final void cdd()
  {
    AppMethodBeat.i(135530);
    if (this.oEJ != null) {
      this.oEJ.aq(this.oEI, ((a)this.oEG.get(this.oEI)).mUrl);
    }
    AppMethodBeat.o(135530);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(135525);
    int j = g.cu(paramString3, 0);
    int k = g.cu(paramString4, -1);
    int i = 0;
    if (i < this.oEG.size())
    {
      if (i == paramInt)
      {
        ((a)this.oEG.get(i)).cde();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a)this.oEG.get(i)).oEZ = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a)this.oEG.get(i)).oFa = paramString2;
          ((a)this.oEG.get(i)).oFb = j;
          ((a)this.oEG.get(i)).oFc = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a)this.oEG.get(i)).oEZ = false;
          ((a)this.oEG.get(i)).oFa = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(135525);
  }
  
  public final void eQ(final boolean paramBoolean)
  {
    AppMethodBeat.i(135526);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135513);
          a.this.eQ(paramBoolean);
          AppMethodBeat.o(135513);
        }
      });
      AppMethodBeat.o(135526);
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.oED))
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
    return this.oED;
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
    this.oEJ = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.oED = paramString;
  }
  
  public static final class a
  {
    public String mText;
    public String mUrl;
    public d oEW;
    public d oEX;
    public boolean oEY;
    public boolean oEZ;
    public String oFa;
    public int oFb;
    public int oFc;
    
    public a()
    {
      AppMethodBeat.i(135518);
      this.oEY = false;
      cde();
      AppMethodBeat.o(135518);
    }
    
    final void cde()
    {
      this.oEZ = false;
      this.oFa = "";
      this.oFb = 0;
      this.oFc = -1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void aq(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a
 * JD-Core Version:    0.7.0.1
 */