package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FlowTextMixView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemSpacing", "lineSpacing", "lines", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FlowTextMixView$MeasureLine;", "maxWidth", "measuredListener", "Lkotlin/Function0;", "", "getMeasuredListener", "()Lkotlin/jvm/functions/Function0;", "setMeasuredListener", "(Lkotlin/jvm/functions/Function0;)V", "getMeasureLine", "index", "lineCount", "measuredLineCount", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setItemSpacing", "size", "setMaxWidth", "maxPixels", "tryInitAttrs", "Companion", "MeasureLine", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FlowTextMixView
  extends FrameLayout
{
  public static final a GEj;
  public final ArrayList<b> GEk;
  private kotlin.g.a.a<ah> GEl;
  private int itemSpacing;
  private int lineSpacing;
  private int maxWidth;
  
  static
  {
    AppMethodBeat.i(344171);
    GEj = new a((byte)0);
    AppMethodBeat.o(344171);
  }
  
  public FlowTextMixView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344144);
    this.GEk = new ArrayList();
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(344144);
  }
  
  public FlowTextMixView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344150);
    this.GEk = new ArrayList();
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(344150);
  }
  
  private final b UJ(int paramInt)
  {
    AppMethodBeat.i(344167);
    if (this.GEk.size() <= paramInt)
    {
      localObject = new b(paramInt, this.itemSpacing, this.lineSpacing);
      this.GEk.add(localObject);
      AppMethodBeat.o(344167);
      return localObject;
    }
    Object localObject = this.GEk.get(paramInt);
    s.s(localObject, "{\n            lines[index]\n        }");
    localObject = (b)localObject;
    AppMethodBeat.o(344167);
    return localObject;
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(344158);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e.j.FlowTextMixView);
    s.s(paramContext, "context.obtainStyledAttr…tyleable.FlowTextMixView)");
    try
    {
      this.itemSpacing = paramContext.getDimensionPixelSize(e.j.FlowTextMixView_itemSpace, 0);
      this.lineSpacing = paramContext.getDimensionPixelSize(e.j.FlowTextMixView_lineSpace, 0);
      this.maxWidth = paramContext.getDimensionPixelSize(e.j.FlowTextMixView_maxWidth, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(344158);
    }
  }
  
  public final kotlin.g.a.a<ah> getMeasuredListener()
  {
    return this.GEl;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(344204);
    paramInt2 = getPaddingStart();
    paramInt3 = getPaddingTop();
    Object localObject1 = this.GEk.iterator();
    b localb;
    int i;
    label74:
    Object localObject3;
    Object localObject4;
    if (((Iterator)localObject1).hasNext())
    {
      localb = (b)((Iterator)localObject1).next();
      i = 0;
      Object localObject2 = (Iterable)localb.GEm;
      paramInt4 = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      paramInt1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (paramInt4 < 0) {
          p.kkW();
        }
        localObject3 = (View)localObject3;
        int j = paramInt2;
        if (paramInt4 > 0) {
          j = paramInt2 + this.itemSpacing;
        }
        localObject4 = ((View)localObject3).getLayoutParams();
        if (localObject4 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(344204);
          throw ((Throwable)localObject1);
        }
        int k = ((FrameLayout.LayoutParams)localObject4).getMarginStart();
        localObject4 = ((View)localObject3).getLayoutParams();
        if (localObject4 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(344204);
          throw ((Throwable)localObject1);
        }
        paramInt2 = ((FrameLayout.LayoutParams)localObject4).topMargin;
        k += j;
        if (i <= 0)
        {
          paramInt2 += (localb.pyp - ((View)localObject3).getMeasuredHeight()) / 2 + paramInt3;
          label236:
          ((View)localObject3).layout(k, paramInt2, ((View)localObject3).getMeasuredWidth() + k, ((View)localObject3).getMeasuredHeight() + paramInt2);
          paramInt2 = j + a.ha((View)localObject3);
          if (!(localObject3 instanceof TextView)) {
            break label393;
          }
          i = a.x((TextView)localObject3);
          localObject3 = (TextView)localObject3;
          if (((TextView)localObject3).getLayout() != null) {
            break label333;
          }
          paramInt1 = 0;
        }
      }
    }
    label393:
    for (;;)
    {
      paramInt4 += 1;
      break label74;
      paramInt2 += paramInt3 + i + (paramInt1 - ((View)localObject3).getMeasuredHeight()) / 2;
      break label236;
      label333:
      localObject4 = new Rect();
      ((TextView)localObject3).getLayout().getLineBounds(((TextView)localObject3).getLineCount() - 1, (Rect)localObject4);
      paramInt1 = ((Rect)localObject4).height();
      continue;
      paramInt2 = getPaddingStart();
      paramInt3 = localb.GEo + paramInt3;
      break;
      AppMethodBeat.o(344204);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(344192);
    int k;
    int m;
    int i;
    if (this.maxWidth > 0)
    {
      paramInt1 = k.qv(this.maxWidth, View.MeasureSpec.getSize(paramInt1));
      k = paramInt1 - getPaddingStart() - getPaddingEnd();
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(k, -2147483648), paramInt2);
      this.GEk.clear();
      m = getChildCount();
      if (m > 0) {
        i = 0;
      }
    }
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      int j = i + 1;
      View localView = getChildAt(i);
      paramInt2 = paramInt1;
      b localb;
      Object localObject;
      if (localView.getVisibility() != 8)
      {
        localb = UJ(paramInt1);
        s.s(localView, "child");
        paramInt2 = a.ha(localView);
        if (paramInt2 > k)
        {
          localObject = localb;
          paramInt2 = paramInt1;
          if (localb.GEn > 0)
          {
            paramInt2 = paramInt1 + 1;
            localObject = UJ(paramInt2);
          }
          ((b)localObject).addView(localView);
        }
      }
      else
      {
        label156:
        if (j < m) {
          break label340;
        }
        localObject = ((Iterable)this.GEk).iterator();
        paramInt2 = 0;
        paramInt1 = 0;
        label181:
        if (!((Iterator)localObject).hasNext()) {
          break label280;
        }
        localb = (b)((Iterator)localObject).next();
        i = localb.GEo;
        if (paramInt1 >= localb.GEn) {
          break label337;
        }
        paramInt1 = localb.GEn;
      }
      label280:
      label337:
      for (;;)
      {
        paramInt2 = i + paramInt2;
        break label181;
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        break;
        if (paramInt2 + localb.GEp <= k)
        {
          localb.addView(localView);
          paramInt2 = paramInt1;
          break label156;
        }
        paramInt2 = paramInt1 + 1;
        UJ(paramInt2).addView(localView);
        break label156;
        setMeasuredDimension(Math.min(k, paramInt1) + getPaddingStart() + getPaddingEnd(), getPaddingTop() + paramInt2 + getPaddingBottom());
        localObject = this.GEl;
        if (localObject != null) {
          ((kotlin.g.a.a)localObject).invoke();
        }
        AppMethodBeat.o(344192);
        return;
      }
      label340:
      i = j;
    }
  }
  
  public final void setItemSpacing(int paramInt)
  {
    AppMethodBeat.i(344183);
    this.itemSpacing = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(344183);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(344196);
    this.maxWidth = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(344196);
  }
  
  public final void setMeasuredListener(kotlin.g.a.a<ah> parama)
  {
    this.GEl = parama;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FlowTextMixView$Companion;", "", "()V", "TAG", "", "getChildEndWidth", "", "child", "Landroid/view/View;", "getChildRealHeight", "getChildRealWidth", "getTextViewLastLineHeight", "Landroid/widget/TextView;", "getTextViewLastLineTop", "getTextViewLastLineWidth", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int ha(View paramView)
    {
      AppMethodBeat.i(345526);
      Object localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(345526);
        throw paramView;
      }
      int j = ((FrameLayout.LayoutParams)localObject).getMarginStart();
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(345526);
        throw paramView;
      }
      int k = ((FrameLayout.LayoutParams)localObject).getMarginEnd();
      if ((paramView instanceof TextView))
      {
        localObject = (TextView)paramView;
        if (((TextView)localObject).getLayout() == null) {
          i = 0;
        }
      }
      for (int i = ((TextView)paramView).getPaddingStart() + i + ((TextView)paramView).getPaddingEnd();; i = paramView.getMeasuredWidth())
      {
        AppMethodBeat.o(345526);
        return i + (j + k);
        i = ((TextView)localObject).getLayout().getOffsetForHorizontal(((TextView)localObject).getLineCount() - 1, 3.4028235E+38F);
        i = kotlin.h.a.eH(((TextView)localObject).getLayout().getPrimaryHorizontal(i));
        break;
      }
    }
    
    static int x(TextView paramTextView)
    {
      AppMethodBeat.i(345529);
      if (paramTextView.getLayout() == null)
      {
        AppMethodBeat.o(345529);
        return 0;
      }
      int i = paramTextView.getLayout().getLineTop(paramTextView.getLineCount() - 1);
      AppMethodBeat.o(345529);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FlowTextMixView$MeasureLine;", "", "index", "", "horizontalSpacing", "verticalSpacing", "(III)V", "endWidth", "getEndWidth", "()I", "setEndWidth", "(I)V", "getHorizontalSpacing", "getIndex", "lastTextLineTop", "getLastTextLineTop", "setLastTextLineTop", "measuredHeight", "getMeasuredHeight", "setMeasuredHeight", "realHeight", "getRealHeight", "setRealHeight", "realWidth", "getRealWidth", "setRealWidth", "getVerticalSpacing", "views", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViews", "()Ljava/util/ArrayList;", "addView", "", "child", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final ArrayList<View> GEm;
    int GEn;
    int GEo;
    int GEp;
    private int GEq;
    private final int horizontalSpacing;
    private final int index;
    int pyp;
    private final int verticalSpacing;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(345443);
      this.index = paramInt1;
      this.horizontalSpacing = paramInt2;
      this.verticalSpacing = paramInt3;
      this.GEm = new ArrayList();
      AppMethodBeat.o(345443);
    }
    
    public final void addView(View paramView)
    {
      AppMethodBeat.i(345451);
      s.u(paramView, "child");
      this.GEm.add(paramView);
      this.GEn += this.horizontalSpacing;
      this.GEp += this.horizontalSpacing;
      int i = this.GEp;
      FlowTextMixView.a locala = FlowTextMixView.GEj;
      this.GEp = (i + FlowTextMixView.a.ha(paramView));
      i = this.GEn;
      locala = FlowTextMixView.GEj;
      this.GEn = (i + FlowTextMixView.a.hb(paramView));
      if (this.pyp < paramView.getMeasuredHeight()) {
        this.pyp = paramView.getMeasuredHeight();
      }
      locala = FlowTextMixView.GEj;
      i = FlowTextMixView.a.hc(paramView) + this.verticalSpacing;
      if ((paramView instanceof TextView))
      {
        locala = FlowTextMixView.GEj;
        this.GEq = FlowTextMixView.a.x((TextView)paramView);
      }
      for (;;)
      {
        if (this.GEo < i) {
          this.GEo = i;
        }
        AppMethodBeat.o(345451);
        return;
        i += this.GEq;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.index != paramObject.index) {
          return false;
        }
        if (this.horizontalSpacing != paramObject.horizontalSpacing) {
          return false;
        }
      } while (this.verticalSpacing == paramObject.verticalSpacing);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.index * 31 + this.horizontalSpacing) * 31 + this.verticalSpacing;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(345453);
      String str = "MeasureLine(index=" + this.index + ", horizontalSpacing=" + this.horizontalSpacing + ", verticalSpacing=" + this.verticalSpacing + ')';
      AppMethodBeat.o(345453);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FlowTextMixView
 * JD-Core Version:    0.7.0.1
 */