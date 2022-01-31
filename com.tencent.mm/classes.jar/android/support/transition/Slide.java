package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class Slide
  extends Visibility
{
  private static final TimeInterpolator ru = new DecelerateInterpolator();
  private static final TimeInterpolator rv = new AccelerateInterpolator();
  private static final Slide.a sA = new Slide.5();
  private static final Slide.a sB = new Slide.6();
  private static final Slide.a sv = new Slide.1();
  private static final Slide.a sx = new Slide.2();
  private static final Slide.a sy = new Slide.3();
  private static final Slide.a sz = new Slide.4();
  private Slide.a st = sB;
  private int su = 80;
  
  public Slide()
  {
    setSlideEdge(80);
  }
  
  public Slide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ac.sJ);
    int i = g.a(paramContext, (XmlPullParser)paramAttributeSet, "slideEdge", 0, 80);
    paramContext.recycle();
    setSlideEdge(i);
  }
  
  private static void c(ah paramah)
  {
    View localView = paramah.view;
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    paramah.values.put("android:slide:screenPosition", arrayOfInt);
  }
  
  private void setSlideEdge(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Invalid slide direction");
    case 3: 
      this.st = sv;
    }
    for (;;)
    {
      this.su = paramInt;
      ab localab = new ab();
      localab.ss = paramInt;
      a(localab);
      return;
      this.st = sy;
      continue;
      this.st = sz;
      continue;
      this.st = sB;
      continue;
      this.st = sx;
      continue;
      this.st = sA;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ah paramah)
  {
    if (paramah == null) {
      return null;
    }
    int[] arrayOfInt = (int[])paramah.values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.st.b(paramViewGroup, paramView);
    float f4 = this.st.c(paramViewGroup, paramView);
    return aj.a(paramView, paramah, arrayOfInt[0], arrayOfInt[1], f1, f2, f3, f4, rv);
  }
  
  public final Animator a(ViewGroup paramViewGroup, View paramView, ah paramah1, ah paramah2)
  {
    if (paramah2 == null) {
      return null;
    }
    paramah1 = (int[])paramah2.values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.st.b(paramViewGroup, paramView);
    float f4 = this.st.c(paramViewGroup, paramView);
    return aj.a(paramView, paramah2, paramah1[0], paramah1[1], f3, f4, f1, f2, ru);
  }
  
  public final void a(ah paramah)
  {
    super.a(paramah);
    c(paramah);
  }
  
  public final void b(ah paramah)
  {
    super.b(paramah);
    c(paramah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.Slide
 * JD-Core Version:    0.7.0.1
 */