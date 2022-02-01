package com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/HorizontalWidthAdaptLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "batchLayoutView", "", "preLayoutViewList", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "childY", "generateLayoutParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/HorizontalWidthAdaptLayout$LayoutParams;", "getSize", "defaultSize", "widthMeasureSpec", "onLayout", "arg0", "", "l", "t", "r", "b", "onMeasure", "heightMeasureSpec", "LayoutParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HorizontalWidthAdaptLayout
  extends ViewGroup
{
  public HorizontalWidthAdaptLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(326649);
    AppMethodBeat.o(326649);
  }
  
  public HorizontalWidthAdaptLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(326651);
    AppMethodBeat.o(326651);
  }
  
  private final void e(ArrayList<View> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(326663);
    Object localObject1 = paramArrayList.iterator();
    int i = 0;
    Object localObject2;
    int m;
    int n;
    for (int j = 0; ((Iterator)localObject1).hasNext(); j = n + (k + m) + j)
    {
      localObject2 = (View)((Iterator)localObject1).next();
      Object localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null)
      {
        paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.HorizontalWidthAdaptLayout.LayoutParams");
        AppMethodBeat.o(326663);
        throw paramArrayList;
      }
      localObject3 = (LayoutParams)localObject3;
      k = ((View)localObject2).getMeasuredWidth();
      m = ((LayoutParams)localObject3).getMarginStart();
      n = ((LayoutParams)localObject3).getMarginEnd();
      i = k.qu(i, ((View)localObject2).getMeasuredHeight());
    }
    int k = (getMeasuredWidth() - j) / 2;
    j = getPaddingStart();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (View)paramArrayList.next();
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.HorizontalWidthAdaptLayout.LayoutParams");
        AppMethodBeat.o(326663);
        throw paramArrayList;
      }
      localObject2 = (LayoutParams)localObject2;
      m = (i - ((View)localObject1).getMeasuredHeight()) / 2;
      ((View)localObject1).layout(k + j + ((LayoutParams)localObject2).leftMargin, ((LayoutParams)localObject2).topMargin + paramInt + m, k + j + ((View)localObject1).getMeasuredWidth() + ((LayoutParams)localObject2).leftMargin, m + (((View)localObject1).getMeasuredHeight() + paramInt + ((LayoutParams)localObject2).topMargin));
      j = ((View)localObject1).getMeasuredWidth() + ((LayoutParams)localObject2).leftMargin + ((LayoutParams)localObject2).rightMargin + j;
    }
    AppMethodBeat.o(326663);
  }
  
  private static int fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(326655);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default: 
      AppMethodBeat.o(326655);
      return paramInt1;
    case 1073741824: 
      AppMethodBeat.o(326655);
      return paramInt2;
    }
    paramInt1 = k.qv(paramInt1, paramInt2);
    AppMethodBeat.o(326655);
    return paramInt1;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(326672);
    paramInt2 = getPaddingStart();
    paramInt3 = getPaddingTop();
    Object localObject1 = new ArrayList();
    paramInt4 = 0;
    int j = getChildCount();
    int i;
    if (j > 0)
    {
      i = paramInt4 + 1;
      View localView = getChildAt(paramInt4);
      int k = localView.getMeasuredWidth();
      int m = localView.getMeasuredHeight();
      Object localObject2 = localView.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.HorizontalWidthAdaptLayout.LayoutParams");
        AppMethodBeat.o(326672);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LayoutParams)localObject2;
      paramInt1 = paramInt3;
      paramInt4 = paramInt2;
      if (paramInt2 + k + ((LayoutParams)localObject2).leftMargin + ((LayoutParams)localObject2).rightMargin > getMeasuredWidth())
      {
        e((ArrayList)localObject1, paramInt3);
        ((ArrayList)localObject1).clear();
        paramInt1 = paramInt3 + (((LayoutParams)localObject2).topMargin + m);
        paramInt4 = getPaddingStart();
      }
      ((ArrayList)localObject1).add(localView);
      paramInt2 = ((LayoutParams)localObject2).leftMargin;
      paramInt2 = paramInt4 + (((LayoutParams)localObject2).rightMargin + (paramInt2 + k));
      if (i < j) {}
    }
    for (;;)
    {
      e((ArrayList)localObject1, paramInt1);
      ((ArrayList)localObject1).clear();
      AppMethodBeat.o(326672);
      return;
      paramInt4 = i;
      paramInt3 = paramInt1;
      break;
      paramInt1 = paramInt3;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(326667);
    int i1 = fq(0, paramInt1);
    int i2 = getChildCount();
    int m;
    int i;
    int j;
    int n;
    int k;
    if (i2 > 0)
    {
      m = 0;
      i = 0;
      j = 0;
      n = m + 1;
      Object localObject1 = getChildAt(m);
      if (((View)localObject1).getVisibility() != 8)
      {
        measureChildWithMargins((View)localObject1, paramInt1, 0, paramInt2, 0);
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.HorizontalWidthAdaptLayout.LayoutParams");
          AppMethodBeat.o(326667);
          throw ((Throwable)localObject1);
        }
        localObject2 = (LayoutParams)localObject2;
        k = j;
        if (m == 0) {
          k = ((View)localObject1).getMeasuredHeight() + ((LayoutParams)localObject2).topMargin + ((LayoutParams)localObject2).bottomMargin;
        }
        m = i;
        j = k;
        if (((View)localObject1).getMeasuredWidth() + i + ((LayoutParams)localObject2).leftMargin + ((LayoutParams)localObject2).rightMargin > i1)
        {
          j = k + (((View)localObject1).getMeasuredHeight() + ((LayoutParams)localObject2).topMargin + ((LayoutParams)localObject2).bottomMargin);
          m = 0;
        }
        i = ((View)localObject1).getMeasuredWidth();
        k = ((LayoutParams)localObject2).leftMargin;
        k = ((LayoutParams)localObject2).rightMargin + (i + k) + m;
        i = j;
        j = k;
        label222:
        if (n < i2) {}
      }
    }
    for (;;)
    {
      setMeasuredDimension(fq(0, paramInt1), fq(i + getPaddingTop() + getPaddingBottom(), paramInt2));
      AppMethodBeat.o(326667);
      return;
      m = n;
      k = i;
      i = j;
      j = k;
      break;
      k = j;
      j = i;
      i = k;
      break label222;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/HorizontalWidthAdaptLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.HorizontalWidthAdaptLayout
 * JD-Core Version:    0.7.0.1
 */