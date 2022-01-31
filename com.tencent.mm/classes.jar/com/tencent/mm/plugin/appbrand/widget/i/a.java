package com.tencent.mm.plugin.appbrand.widget.i;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.LinkedList;

public class a
  extends FrameLayout
{
  public f jwC;
  protected LinearLayout jwD;
  private ImageView jwE;
  protected String jwF;
  protected int jwG;
  protected int jwH;
  protected LinkedList<a.a> jwI;
  public LinkedList<Pair<d, d>> jwJ;
  private int jwK;
  private b jwL;
  private int mHeight;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(87543);
    this.mHeight = 0;
    this.jwK = 0;
    this.jwI = new LinkedList();
    this.jwJ = new LinkedList();
    this.jwC = new f();
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.jwE = new ImageView(paramContext);
    this.jwE.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    addView(this.jwE);
    this.jwD = new LinearLayout(paramContext);
    this.jwD.setOrientation(0);
    this.jwD.setGravity(16);
    this.jwD.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.jwD);
    AppMethodBeat.o(87543);
  }
  
  private void a(Animator paramAnimator, Runnable paramRunnable)
  {
    AppMethodBeat.i(87551);
    paramAnimator.addListener(new a.11(this, paramRunnable));
    paramAnimator.start();
    AppMethodBeat.o(87551);
  }
  
  private static int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(138234);
    paramInt = Math.round(paramContext.getResources().getDisplayMetrics().density * paramInt);
    AppMethodBeat.o(138234);
    return paramInt;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(87552);
    post(new a.12(this));
    AppMethodBeat.o(87552);
  }
  
  public final int Gc(String paramString)
  {
    AppMethodBeat.i(87556);
    LinkedList localLinkedList = this.jwI;
    String str = h.cg(paramString);
    Iterator localIterator = this.jwI.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (a.a)localIterator.next();
    } while (!h.cg(paramString.mUrl).equals(str));
    for (;;)
    {
      int i = localLinkedList.indexOf(paramString);
      AppMethodBeat.o(87556);
      return i;
      paramString = null;
    }
  }
  
  public final void a(int paramInt, String paramString, d paramd1, d paramd2)
  {
    AppMethodBeat.i(87547);
    if (paramInt >= this.jwI.size())
    {
      AppMethodBeat.o(87547);
      return;
    }
    a.a locala = (a.a)this.jwI.get(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = locala.mText;
    }
    locala.mText = str;
    if (paramd1 != null)
    {
      paramString = paramd1;
      if (paramd1.aSr() == null) {
        paramString = locala.jwU;
      }
      locala.jwU = paramString;
    }
    if (paramd2 != null)
    {
      paramString = paramd2;
      if (paramd2.aSr() == null) {
        paramString = locala.jwV;
      }
      locala.jwV = paramString;
    }
    refreshView();
    AppMethodBeat.o(87547);
  }
  
  protected final void a(View paramView, a.a parama)
  {
    int j = 0;
    AppMethodBeat.i(87554);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131820929);
    TextView localTextView1 = (TextView)paramView.findViewById(2131821427);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131821428);
    TextView localTextView2 = (TextView)paramView.findViewById(2131820676);
    View localView = paramView.findViewById(2131821429);
    int i;
    if ("top".equals(this.jwF))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.jwW)
      {
        localView.setBackgroundColor(this.jwH);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.jwZ, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.jwY.isEmpty()) {
          break label522;
        }
        i = 4;
        label171:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.jwY);
        localTextView1.setTextColor(parama.jxa);
        if (!parama.jwX) {
          break label527;
        }
        i = j;
        label205:
        localImageView2.setVisibility(i);
        if ((!parama.jwW) || (parama.jwV.aSr() == null)) {
          break label532;
        }
        parama.jwV.a(new a.2(this, localImageView1));
        parama.jwV.aSq();
      }
    }
    for (;;)
    {
      localTextView2.setText(parama.mText);
      if (!parama.jwW) {
        break label559;
      }
      localTextView2.setTextColor(this.jwH);
      AppMethodBeat.o(87554);
      return;
      localView.setVisibility(4);
      break;
      if (parama.jwU.aSr() != null) {
        if (parama.mText != null)
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
        localImageView1.getLayoutParams().width = fromDPToPix(getContext(), 36);
        localImageView1.getLayoutParams().height = fromDPToPix(getContext(), 36);
        localTextView2.setVisibility(8);
        continue;
        if (parama.mText != null)
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 49), 1.0F));
          localImageView1.setVisibility(8);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 16.0F);
        }
      }
      label522:
      i = 0;
      break label171;
      label527:
      i = 4;
      break label205;
      label532:
      parama.jwU.a(new a.3(this, localImageView1));
      parama.jwU.aSq();
    }
    label559:
    localTextView2.setTextColor(this.jwG);
    AppMethodBeat.o(87554);
  }
  
  protected final void aSo()
  {
    AppMethodBeat.i(87553);
    if (this.jwL != null) {
      this.jwL.Z(this.jwK, ((a.a)this.jwI.get(this.jwK)).mUrl);
    }
    AppMethodBeat.o(87553);
  }
  
  public final void aw(boolean paramBoolean)
  {
    AppMethodBeat.i(87550);
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.jwF))
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
      post(new a.10(this, localObjectAnimator));
      AppMethodBeat.o(87550);
      return;
      i = 1;
      break;
    }
  }
  
  protected final void b(Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(87555);
    paramImageView.post(new a.4(this, paramImageView, paramBitmap));
    AppMethodBeat.o(87555);
  }
  
  public final void c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(87548);
    int j = v.by(paramString3, 0);
    int k = v.by(paramString4, -1);
    int i = 0;
    if (i < this.jwI.size())
    {
      if (i == paramInt)
      {
        ((a.a)this.jwI.get(i)).aSp();
        if (!"redDot".equals(paramString1)) {
          break label93;
        }
        ((a.a)this.jwI.get(i)).jwX = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label93:
        if ("text".equals(paramString1))
        {
          ((a.a)this.jwI.get(i)).jwY = paramString2;
          ((a.a)this.jwI.get(i)).jwZ = j;
          ((a.a)this.jwI.get(i)).jxa = k;
        }
        else if ("none".equals(paramString1))
        {
          ((a.a)this.jwI.get(i)).jwX = false;
          ((a.a)this.jwI.get(i)).jwY = "";
        }
      }
    }
    refreshView();
    AppMethodBeat.o(87548);
  }
  
  public final void fw(boolean paramBoolean)
  {
    AppMethodBeat.i(87549);
    if (!al.isMainThread())
    {
      al.d(new a.8(this, paramBoolean));
      AppMethodBeat.o(87549);
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.jwF))
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
      a(localObjectAnimator, new a.9(this));
      AppMethodBeat.o(87549);
      return;
      i = 1;
      break;
    }
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(87544);
    post(new a.1(this, paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(87544);
  }
  
  public String getPosition()
  {
    return this.jwF;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(87545);
    a.a locala = new a.a();
    locala.jwU = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(87534);
        super.a(paramAnonymousString, paramAnonymousd);
        ab.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(87534);
      }
    });
    locala.jwV = new b(paramString4, new a.6(this));
    locala.mText = paramString2;
    locala.mUrl = paramString1;
    this.jwJ.add(new Pair(locala.jwU, locala.jwV));
    if ((locala.mText == null) && ((locala.jwU.aSr() == null) || (locala.jwV.aSr() == null)))
    {
      ab.e("MicroMsg.AppBrandPageTabBar", "illegal data");
      AppMethodBeat.o(87545);
      return;
    }
    paramString1 = (ViewGroup)LayoutInflater.from(getContext()).inflate(2130968743, this.jwD, false);
    a(paramString1, locala);
    paramString1.setOnClickListener(new a.7(this));
    this.jwI.add(locala);
    this.jwD.addView(paramString1);
    AppMethodBeat.o(87545);
  }
  
  public final void qX(int paramInt)
  {
    AppMethodBeat.i(87546);
    ((a.a)this.jwI.get(this.jwK)).jwW = false;
    if ((paramInt > 0) && (paramInt < this.jwI.size())) {}
    for (this.jwK = paramInt;; this.jwK = 0)
    {
      ((a.a)this.jwI.get(this.jwK)).jwW = true;
      refreshView();
      AppMethodBeat.o(87546);
      return;
    }
  }
  
  public void setClickListener(b paramb)
  {
    this.jwL = paramb;
  }
  
  public void setPosition(String paramString)
  {
    this.jwF = paramString;
  }
  
  public static abstract interface b
  {
    public abstract void Z(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.a
 * JD-Core Version:    0.7.0.1
 */