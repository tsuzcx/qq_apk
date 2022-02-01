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
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.k.i;
import kotlin.t;
import kotlin.z;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FlowTextMixView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemSpacing", "lineSpacing", "lines", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FlowTextMixView$MeasureLine;", "maxWidth", "getMeasureLine", "index", "lineCount", "measuredLineCount", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setItemSpacing", "size", "setMaxWidth", "maxPixels", "tryInitAttrs", "Companion", "MeasureLine", "plugin-finder_release"})
public class FlowTextMixView
  extends FrameLayout
{
  public static final a Bcl;
  private final ArrayList<b> Bck;
  private int itemSpacing;
  private int lineSpacing;
  private int maxWidth;
  
  static
  {
    AppMethodBeat.i(291507);
    Bcl = new a((byte)0);
    AppMethodBeat.o(291507);
  }
  
  public FlowTextMixView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291505);
    this.Bck = new ArrayList();
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(291505);
  }
  
  public FlowTextMixView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(291506);
    this.Bck = new ArrayList();
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(291506);
  }
  
  private final b RF(int paramInt)
  {
    AppMethodBeat.i(291503);
    if (this.Bck.size() <= paramInt)
    {
      localObject = new b(paramInt, this.itemSpacing, this.lineSpacing);
      this.Bck.add(localObject);
      AppMethodBeat.o(291503);
      return localObject;
    }
    Object localObject = this.Bck.get(paramInt);
    p.j(localObject, "lines[index]");
    localObject = (b)localObject;
    AppMethodBeat.o(291503);
    return localObject;
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(291497);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.FlowTextMixView);
    try
    {
      this.itemSpacing = paramContext.getDimensionPixelSize(b.l.FlowTextMixView_itemSpace, 0);
      this.lineSpacing = paramContext.getDimensionPixelSize(b.l.FlowTextMixView_lineSpace, 0);
      this.maxWidth = paramContext.getDimensionPixelSize(b.l.FlowTextMixView_maxWidth, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(291497);
    }
  }
  
  public final int ejs()
  {
    AppMethodBeat.i(291501);
    Iterator localIterator1 = ((Iterable)this.Bck).iterator();
    int i = 0;
    int j;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)((b)localIterator1.next()).Bcm).iterator();
      j = 0;
      label56:
      if (localIterator2.hasNext())
      {
        View localView = (View)localIterator2.next();
        if ((!(localView instanceof TextView)) || (((TextView)localView).getLineCount() <= 1) || (j >= ((TextView)localView).getLineCount())) {
          break label149;
        }
        j = ((TextView)localView).getLineCount();
      }
    }
    label149:
    for (;;)
    {
      break label56;
      int k = i;
      if (j > 1) {
        k = i + (j - 1);
      }
      i = k + 1;
      break;
      AppMethodBeat.o(291501);
      return i;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(291504);
    paramInt2 = getPaddingStart();
    paramInt3 = getPaddingTop();
    Object localObject1 = this.Bck.iterator();
    b localb;
    int i;
    label74:
    Object localObject3;
    Object localObject4;
    if (((Iterator)localObject1).hasNext())
    {
      localb = (b)((Iterator)localObject1).next();
      i = 0;
      Object localObject2 = (Iterable)localb.Bcm;
      paramInt4 = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      paramInt1 = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (paramInt4 < 0) {
          j.iBO();
        }
        localObject3 = (View)localObject3;
        int j = paramInt2;
        if (paramInt4 > 0) {
          j = paramInt2 + this.itemSpacing;
        }
        localObject4 = ((View)localObject3).getLayoutParams();
        if (localObject4 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(291504);
          throw ((Throwable)localObject1);
        }
        int k = ((FrameLayout.LayoutParams)localObject4).getMarginStart();
        localObject4 = ((View)localObject3).getLayoutParams();
        if (localObject4 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(291504);
          throw ((Throwable)localObject1);
        }
        paramInt2 = ((FrameLayout.LayoutParams)localObject4).topMargin;
        k += j;
        if (i <= 0)
        {
          paramInt2 += (localb.mBH - ((View)localObject3).getMeasuredHeight()) / 2 + paramInt3;
          label236:
          ((View)localObject3).layout(k, paramInt2, ((View)localObject3).getMeasuredWidth() + k, ((View)localObject3).getMeasuredHeight() + paramInt2);
          paramInt2 = j + a.eQ((View)localObject3);
          if (!(localObject3 instanceof TextView)) {
            break label393;
          }
          i = a.v((TextView)localObject3);
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
      paramInt3 = localb.Bco + paramInt3;
      break;
      AppMethodBeat.o(291504);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291500);
    if (View.MeasureSpec.getMode(paramInt1) != 0) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(291500);
      throw ((Throwable)localObject);
    }
    int j;
    label116:
    View localView;
    b localb;
    if (this.maxWidth > 0)
    {
      paramInt1 = i.ow(this.maxWidth, View.MeasureSpec.getSize(paramInt1));
      j = paramInt1 - getPaddingStart() - getPaddingEnd();
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(j, -2147483648), paramInt2);
      this.Bck.clear();
      int k = getChildCount();
      i = 0;
      paramInt1 = 0;
      if (i >= k) {
        break label258;
      }
      localView = getChildAt(i);
      p.j(localView, "child");
      paramInt2 = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localb = RF(paramInt1);
        paramInt2 = a.eQ(localView);
        if (paramInt2 <= j) {
          break label217;
        }
        localObject = localb;
        paramInt2 = paramInt1;
        if (localb.Bcn > 0)
        {
          paramInt2 = paramInt1 + 1;
          localObject = RF(paramInt2);
        }
        ((b)localObject).addView(localView);
      }
    }
    for (;;)
    {
      i += 1;
      paramInt1 = paramInt2;
      break label116;
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      break;
      label217:
      if (paramInt2 + localb.Bcp <= j)
      {
        localb.addView(localView);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt2 = paramInt1 + 1;
        RF(paramInt2).addView(localView);
      }
    }
    label258:
    Object localObject = ((Iterable)this.Bck).iterator();
    paramInt2 = 0;
    paramInt1 = 0;
    if (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      i = localb.Bco;
      if (paramInt1 >= localb.Bcn) {
        break label404;
      }
      paramInt1 = localb.Bcn;
    }
    label404:
    for (;;)
    {
      paramInt2 = i + paramInt2;
      break;
      if (paramInt1 > j) {
        Log.e("FlowTextMixView", "[onMeasure] newMeasuredWidth=" + paramInt1 + ", measuredMaxWidth=" + j);
      }
      setMeasuredDimension(Math.min(j, paramInt1) + getPaddingStart() + getPaddingEnd(), getPaddingTop() + paramInt2 + getPaddingBottom());
      AppMethodBeat.o(291500);
      return;
    }
  }
  
  public final void setItemSpacing(int paramInt)
  {
    AppMethodBeat.i(291498);
    this.itemSpacing = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(291498);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(291502);
    this.maxWidth = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(291502);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FlowTextMixView$Companion;", "", "()V", "TAG", "", "getChildEndWidth", "", "child", "Landroid/view/View;", "getChildRealHeight", "getChildRealWidth", "getTextViewLastLineHeight", "Landroid/widget/TextView;", "getTextViewLastLineTop", "getTextViewLastLineWidth", "plugin-finder_release"})
  public static final class a
  {
    static int eQ(View paramView)
    {
      AppMethodBeat.i(269045);
      Object localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(269045);
        throw paramView;
      }
      int j = ((FrameLayout.LayoutParams)localObject).getMarginStart();
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(269045);
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
        AppMethodBeat.o(269045);
        return i + (j + k);
        Layout localLayout = ((TextView)localObject).getLayout();
        i = ((TextView)localObject).getLineCount();
        kotlin.g.b.l locall = kotlin.g.b.l.aaBt;
        i = localLayout.getOffsetForHorizontal(i - 1, kotlin.g.b.l.iCk());
        i = a.dm(((TextView)localObject).getLayout().getPrimaryHorizontal(i));
        break;
      }
    }
    
    static int v(TextView paramTextView)
    {
      AppMethodBeat.i(269046);
      if (paramTextView.getLayout() == null)
      {
        AppMethodBeat.o(269046);
        return 0;
      }
      int i = paramTextView.getLayout().getLineTop(paramTextView.getLineCount() - 1);
      AppMethodBeat.o(269046);
      return i;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FlowTextMixView$MeasureLine;", "", "index", "", "horizontalSpacing", "verticalSpacing", "(III)V", "endWidth", "getEndWidth", "()I", "setEndWidth", "(I)V", "getHorizontalSpacing", "getIndex", "lastTextLineTop", "getLastTextLineTop", "setLastTextLineTop", "measuredHeight", "getMeasuredHeight", "setMeasuredHeight", "realHeight", "getRealHeight", "setRealHeight", "realWidth", "getRealWidth", "setRealWidth", "getVerticalSpacing", "views", "Ljava/util/ArrayList;", "Landroid/view/View;", "getViews", "()Ljava/util/ArrayList;", "addView", "", "child", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final ArrayList<View> Bcm;
    int Bcn;
    int Bco;
    int Bcp;
    private int Bcq;
    private final int horizontalSpacing;
    private final int index;
    int mBH;
    private final int verticalSpacing;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(226127);
      this.index = paramInt1;
      this.horizontalSpacing = paramInt2;
      this.verticalSpacing = paramInt3;
      this.Bcm = new ArrayList();
      AppMethodBeat.o(226127);
    }
    
    public final void addView(View paramView)
    {
      AppMethodBeat.i(226124);
      p.k(paramView, "child");
      this.Bcm.add(paramView);
      this.Bcn += this.horizontalSpacing;
      this.Bcp += this.horizontalSpacing;
      int i = this.Bcp;
      FlowTextMixView.a locala = FlowTextMixView.Bcl;
      this.Bcp = (i + FlowTextMixView.a.eQ(paramView));
      i = this.Bcn;
      locala = FlowTextMixView.Bcl;
      this.Bcn = (i + FlowTextMixView.a.eR(paramView));
      if (this.mBH < paramView.getMeasuredHeight()) {
        this.mBH = paramView.getMeasuredHeight();
      }
      locala = FlowTextMixView.Bcl;
      i = FlowTextMixView.a.eS(paramView) + this.verticalSpacing;
      if ((paramView instanceof TextView))
      {
        locala = FlowTextMixView.Bcl;
        this.Bcq = FlowTextMixView.a.v((TextView)paramView);
      }
      for (;;)
      {
        if (this.Bco < i) {
          this.Bco = i;
        }
        AppMethodBeat.o(226124);
        return;
        i += this.Bcq;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.index != paramObject.index) || (this.horizontalSpacing != paramObject.horizontalSpacing) || (this.verticalSpacing != paramObject.verticalSpacing)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return (this.index * 31 + this.horizontalSpacing) * 31 + this.verticalSpacing;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(226128);
      String str = "MeasureLine(index=" + this.index + ", horizontalSpacing=" + this.horizontalSpacing + ", verticalSpacing=" + this.verticalSpacing + ")";
      AppMethodBeat.o(226128);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FlowTextMixView
 * JD-Core Version:    0.7.0.1
 */