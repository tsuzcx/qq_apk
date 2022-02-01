package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class FragmentContainerView
  extends FrameLayout
{
  private ArrayList<View> bCF;
  private ArrayList<View> bCG;
  private boolean bCH;
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193879);
    this.bCH = true;
    if (paramAttributeSet != null)
    {
      String str1 = paramAttributeSet.getClassAttribute();
      String str2 = "class";
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.FragmentContainerView);
      paramAttributeSet = str2;
      paramContext = str1;
      if (str1 == null)
      {
        paramContext = localTypedArray.getString(a.c.FragmentContainerView_android_name);
        paramAttributeSet = "android:name";
      }
      localTypedArray.recycle();
      if ((paramContext != null) && (!isInEditMode()))
      {
        paramContext = new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + paramAttributeSet + "=\"" + paramContext + "\"");
        AppMethodBeat.o(193879);
        throw paramContext;
      }
    }
    AppMethodBeat.o(193879);
  }
  
  FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet, FragmentManager paramFragmentManager)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193890);
    this.bCH = true;
    String str = paramAttributeSet.getClassAttribute();
    Object localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.FragmentContainerView);
    Object localObject1 = str;
    if (str == null) {
      localObject1 = ((TypedArray)localObject2).getString(a.c.FragmentContainerView_android_name);
    }
    str = ((TypedArray)localObject2).getString(a.c.FragmentContainerView_android_tag);
    ((TypedArray)localObject2).recycle();
    int i = getId();
    localObject2 = paramFragmentManager.findFragmentById(i);
    if ((localObject1 != null) && (localObject2 == null))
    {
      if (i <= 0)
      {
        if (str != null) {}
        for (paramContext = " with tag ".concat(String.valueOf(str));; paramContext = "")
        {
          paramContext = new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + (String)localObject1 + paramContext);
          AppMethodBeat.o(193890);
          throw paramContext;
        }
      }
      localObject1 = paramFragmentManager.getFragmentFactory().d(paramContext.getClassLoader(), (String)localObject1);
      ((Fragment)localObject1).onInflate(paramContext, paramAttributeSet, null);
      paramContext = paramFragmentManager.beginTransaction();
      paramContext.bBq = true;
      ((Fragment)localObject1).mContainer = this;
      paramContext.a(getId(), (Fragment)localObject1, str).FZ();
    }
    paramFragmentManager.onContainerAvailable(this);
    AppMethodBeat.o(193890);
  }
  
  private void aZ(View paramView)
  {
    AppMethodBeat.i(193894);
    if ((this.bCG != null) && (this.bCG.contains(paramView)))
    {
      if (this.bCF == null) {
        this.bCF = new ArrayList();
      }
      this.bCF.add(paramView);
    }
    AppMethodBeat.o(193894);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(193949);
    if (FragmentManager.getViewFragment(paramView) == null)
    {
      paramView = new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + paramView + " is not associated with a Fragment.");
      AppMethodBeat.o(193949);
      throw paramView;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(193949);
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    AppMethodBeat.i(193955);
    if (FragmentManager.getViewFragment(paramView) == null)
    {
      paramView = new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + paramView + " is not associated with a Fragment.");
      AppMethodBeat.o(193955);
      throw paramView;
    }
    paramBoolean = super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
    AppMethodBeat.o(193955);
    return paramBoolean;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193914);
    if ((this.bCH) && (this.bCF != null))
    {
      int i = 0;
      while (i < this.bCF.size())
      {
        super.drawChild(paramCanvas, (View)this.bCF.get(i), getDrawingTime());
        i += 1;
      }
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(193914);
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(193925);
    if ((this.bCH) && (this.bCF != null) && (this.bCF.size() > 0) && (this.bCF.contains(paramView)))
    {
      AppMethodBeat.o(193925);
      return false;
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(193925);
    return bool;
  }
  
  public final void endViewTransition(View paramView)
  {
    AppMethodBeat.i(193940);
    if (this.bCG != null)
    {
      this.bCG.remove(paramView);
      if ((this.bCF != null) && (this.bCF.remove(paramView))) {
        this.bCH = true;
      }
    }
    super.endViewTransition(paramView);
    AppMethodBeat.o(193940);
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(193910);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).dispatchApplyWindowInsets(new WindowInsets(paramWindowInsets));
      i += 1;
    }
    AppMethodBeat.o(193910);
    return paramWindowInsets;
  }
  
  public final void removeAllViewsInLayout()
  {
    AppMethodBeat.i(194004);
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      aZ(getChildAt(i));
      i -= 1;
    }
    super.removeAllViewsInLayout();
    AppMethodBeat.o(194004);
  }
  
  protected final void removeDetachedView(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(194014);
    if (paramBoolean) {
      aZ(paramView);
    }
    super.removeDetachedView(paramView, paramBoolean);
    AppMethodBeat.o(194014);
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(193978);
    aZ(paramView);
    super.removeView(paramView);
    AppMethodBeat.o(193978);
  }
  
  public final void removeViewAt(int paramInt)
  {
    AppMethodBeat.i(193966);
    aZ(getChildAt(paramInt));
    super.removeViewAt(paramInt);
    AppMethodBeat.o(193966);
  }
  
  public final void removeViewInLayout(View paramView)
  {
    AppMethodBeat.i(193971);
    aZ(paramView);
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(193971);
  }
  
  public final void removeViews(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193988);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      aZ(getChildAt(i));
      i += 1;
    }
    super.removeViews(paramInt1, paramInt2);
    AppMethodBeat.o(193988);
  }
  
  public final void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193996);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      aZ(getChildAt(i));
      i += 1;
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
    AppMethodBeat.o(193996);
  }
  
  final void setDrawDisappearingViewsLast(boolean paramBoolean)
  {
    this.bCH = paramBoolean;
  }
  
  public final void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    AppMethodBeat.i(193902);
    if (Build.VERSION.SDK_INT < 18)
    {
      super.setLayoutTransition(paramLayoutTransition);
      AppMethodBeat.o(193902);
      return;
    }
    paramLayoutTransition = new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    AppMethodBeat.o(193902);
    throw paramLayoutTransition;
  }
  
  public final void startViewTransition(View paramView)
  {
    AppMethodBeat.i(193932);
    if (paramView.getParent() == this)
    {
      if (this.bCG == null) {
        this.bCG = new ArrayList();
      }
      this.bCG.add(paramView);
    }
    super.startViewTransition(paramView);
    AppMethodBeat.o(193932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.FragmentContainerView
 * JD-Core Version:    0.7.0.1
 */