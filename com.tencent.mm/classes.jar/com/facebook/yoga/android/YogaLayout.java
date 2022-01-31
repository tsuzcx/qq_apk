package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class YogaLayout
  extends ViewGroup
{
  private final YogaNode mYogaNode;
  private final Map<View, YogaNode> mYogaNodes;
  
  public YogaLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public YogaLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public YogaLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(144213);
    this.mYogaNode = new YogaNode();
    this.mYogaNodes = new HashMap();
    this.mYogaNode.setData(this);
    this.mYogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
    if (paramAttributeSet != null) {}
    for (paramContext = new YogaLayout.LayoutParams(paramContext, paramAttributeSet);; paramContext = (YogaLayout.LayoutParams)generateDefaultLayoutParams())
    {
      applyLayoutParams(paramContext, this.mYogaNode, this);
      AppMethodBeat.o(144213);
      return;
    }
  }
  
  protected static void applyLayoutParams(YogaLayout.LayoutParams paramLayoutParams, YogaNode paramYogaNode, View paramView)
  {
    AppMethodBeat.i(144230);
    if ((Build.VERSION.SDK_INT >= 17) && (paramView.getResources().getConfiguration().getLayoutDirection() == 1)) {
      paramYogaNode.setDirection(YogaDirection.RTL);
    }
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      Rect localRect = new Rect();
      if (paramView.getPadding(localRect))
      {
        paramYogaNode.setPadding(YogaEdge.LEFT, localRect.left);
        paramYogaNode.setPadding(YogaEdge.TOP, localRect.top);
        paramYogaNode.setPadding(YogaEdge.RIGHT, localRect.right);
        paramYogaNode.setPadding(YogaEdge.BOTTOM, localRect.bottom);
      }
    }
    int i = 0;
    int j;
    float f;
    if (i < paramLayoutParams.numericAttributes.size())
    {
      j = paramLayoutParams.numericAttributes.keyAt(i);
      f = ((Float)paramLayoutParams.numericAttributes.valueAt(i)).floatValue();
      if (j == 0) {
        paramYogaNode.setAlignContent(YogaAlign.fromInt(Math.round(f)));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 1) {
          paramYogaNode.setAlignItems(YogaAlign.fromInt(Math.round(f)));
        } else if (j == 2) {
          paramYogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(f)));
        } else if (j == 3) {
          paramYogaNode.setAspectRatio(f);
        } else if (j == 4) {
          paramYogaNode.setBorder(YogaEdge.LEFT, f);
        } else if (j == 5) {
          paramYogaNode.setBorder(YogaEdge.TOP, f);
        } else if (j == 6) {
          paramYogaNode.setBorder(YogaEdge.RIGHT, f);
        } else if (j == 7) {
          paramYogaNode.setBorder(YogaEdge.BOTTOM, f);
        } else if (j == 8) {
          paramYogaNode.setBorder(YogaEdge.START, f);
        } else if (j == 9) {
          paramYogaNode.setBorder(YogaEdge.END, f);
        } else if (j == 10) {
          paramYogaNode.setBorder(YogaEdge.HORIZONTAL, f);
        } else if (j == 11) {
          paramYogaNode.setBorder(YogaEdge.VERTICAL, f);
        } else if (j == 12) {
          paramYogaNode.setBorder(YogaEdge.ALL, f);
        } else if (j == 13) {
          paramYogaNode.setDirection(YogaDirection.fromInt(Math.round(f)));
        } else if (j == 14) {
          paramYogaNode.setDisplay(YogaDisplay.fromInt(Math.round(f)));
        } else if (j == 15) {
          paramYogaNode.setFlex(f);
        } else if (j == 16) {
          paramYogaNode.setFlexBasis(f);
        } else if (j == 17) {
          paramYogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(f)));
        } else if (j == 18) {
          paramYogaNode.setFlexGrow(f);
        } else if (j == 19) {
          paramYogaNode.setFlexShrink(f);
        } else if (j == 20) {
          paramYogaNode.setHeight(f);
        } else if (j == 22) {
          paramYogaNode.setMargin(YogaEdge.LEFT, f);
        } else if (j == 21) {
          paramYogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(f)));
        } else if (j == 23) {
          paramYogaNode.setMargin(YogaEdge.TOP, f);
        } else if (j == 24) {
          paramYogaNode.setMargin(YogaEdge.RIGHT, f);
        } else if (j == 25) {
          paramYogaNode.setMargin(YogaEdge.BOTTOM, f);
        } else if (j == 26) {
          paramYogaNode.setMargin(YogaEdge.START, f);
        } else if (j == 27) {
          paramYogaNode.setMargin(YogaEdge.END, f);
        } else if (j == 28) {
          paramYogaNode.setMargin(YogaEdge.HORIZONTAL, f);
        } else if (j == 29) {
          paramYogaNode.setMargin(YogaEdge.VERTICAL, f);
        } else if (j == 30) {
          paramYogaNode.setMargin(YogaEdge.ALL, f);
        } else if (j == 31) {
          paramYogaNode.setMaxHeight(f);
        } else if (j == 32) {
          paramYogaNode.setMaxWidth(f);
        } else if (j == 33) {
          paramYogaNode.setMinHeight(f);
        } else if (j == 34) {
          paramYogaNode.setMinWidth(f);
        } else if (j == 35) {
          paramYogaNode.setOverflow(YogaOverflow.fromInt(Math.round(f)));
        } else if (j == 36) {
          paramYogaNode.setPadding(YogaEdge.LEFT, f);
        } else if (j == 37) {
          paramYogaNode.setPadding(YogaEdge.TOP, f);
        } else if (j == 38) {
          paramYogaNode.setPadding(YogaEdge.RIGHT, f);
        } else if (j == 39) {
          paramYogaNode.setPadding(YogaEdge.BOTTOM, f);
        } else if (j == 40) {
          paramYogaNode.setPadding(YogaEdge.START, f);
        } else if (j == 41) {
          paramYogaNode.setPadding(YogaEdge.END, f);
        } else if (j == 42) {
          paramYogaNode.setPadding(YogaEdge.HORIZONTAL, f);
        } else if (j == 43) {
          paramYogaNode.setPadding(YogaEdge.VERTICAL, f);
        } else if (j == 44) {
          paramYogaNode.setPadding(YogaEdge.ALL, f);
        } else if (j == 45) {
          paramYogaNode.setPosition(YogaEdge.LEFT, f);
        } else if (j == 46) {
          paramYogaNode.setPosition(YogaEdge.TOP, f);
        } else if (j == 47) {
          paramYogaNode.setPosition(YogaEdge.RIGHT, f);
        } else if (j == 48) {
          paramYogaNode.setPosition(YogaEdge.BOTTOM, f);
        } else if (j == 49) {
          paramYogaNode.setPosition(YogaEdge.START, f);
        } else if (j == 50) {
          paramYogaNode.setPosition(YogaEdge.END, f);
        } else if (j == 51) {
          paramYogaNode.setPosition(YogaEdge.HORIZONTAL, f);
        } else if (j == 52) {
          paramYogaNode.setPosition(YogaEdge.VERTICAL, f);
        } else if (j == 53) {
          paramYogaNode.setPosition(YogaEdge.ALL, f);
        } else if (j == 54) {
          paramYogaNode.setPositionType(YogaPositionType.fromInt(Math.round(f)));
        } else if (j == 55) {
          paramYogaNode.setWidth(f);
        } else if (j == 56) {
          paramYogaNode.setWrap(YogaWrap.fromInt(Math.round(f)));
        }
      }
    }
    i = 0;
    if (i < paramLayoutParams.stringAttributes.size())
    {
      j = paramLayoutParams.stringAttributes.keyAt(i);
      paramView = (String)paramLayoutParams.stringAttributes.valueAt(i);
      if (paramView.equals("auto"))
      {
        if (j == 22) {
          paramYogaNode.setMarginAuto(YogaEdge.LEFT);
        }
      }
      else {
        label1240:
        if (paramView.endsWith("%"))
        {
          f = Float.parseFloat(paramView.substring(0, paramView.length() - 1));
          if (j != 16) {
            break label1422;
          }
          paramYogaNode.setFlexBasisPercent(f);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 23)
        {
          paramYogaNode.setMarginAuto(YogaEdge.TOP);
          break label1240;
        }
        if (j == 24)
        {
          paramYogaNode.setMarginAuto(YogaEdge.RIGHT);
          break label1240;
        }
        if (j == 25)
        {
          paramYogaNode.setMarginAuto(YogaEdge.BOTTOM);
          break label1240;
        }
        if (j == 26)
        {
          paramYogaNode.setMarginAuto(YogaEdge.START);
          break label1240;
        }
        if (j == 27)
        {
          paramYogaNode.setMarginAuto(YogaEdge.END);
          break label1240;
        }
        if (j == 28)
        {
          paramYogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
          break label1240;
        }
        if (j == 29)
        {
          paramYogaNode.setMarginAuto(YogaEdge.VERTICAL);
          break label1240;
        }
        if (j != 30) {
          break label1240;
        }
        paramYogaNode.setMarginAuto(YogaEdge.ALL);
        break label1240;
        label1422:
        if (j == 20) {
          paramYogaNode.setHeightPercent(f);
        } else if (j == 22) {
          paramYogaNode.setMarginPercent(YogaEdge.LEFT, f);
        } else if (j == 23) {
          paramYogaNode.setMarginPercent(YogaEdge.TOP, f);
        } else if (j == 24) {
          paramYogaNode.setMarginPercent(YogaEdge.RIGHT, f);
        } else if (j == 25) {
          paramYogaNode.setMarginPercent(YogaEdge.BOTTOM, f);
        } else if (j == 26) {
          paramYogaNode.setMarginPercent(YogaEdge.START, f);
        } else if (j == 27) {
          paramYogaNode.setMarginPercent(YogaEdge.END, f);
        } else if (j == 28) {
          paramYogaNode.setMarginPercent(YogaEdge.HORIZONTAL, f);
        } else if (j == 29) {
          paramYogaNode.setMarginPercent(YogaEdge.VERTICAL, f);
        } else if (j == 30) {
          paramYogaNode.setMarginPercent(YogaEdge.ALL, f);
        } else if (j == 31) {
          paramYogaNode.setMaxHeightPercent(f);
        } else if (j == 32) {
          paramYogaNode.setMaxWidthPercent(f);
        } else if (j == 33) {
          paramYogaNode.setMinHeightPercent(f);
        } else if (j == 34) {
          paramYogaNode.setMinWidthPercent(f);
        } else if (j == 36) {
          paramYogaNode.setPaddingPercent(YogaEdge.LEFT, f);
        } else if (j == 37) {
          paramYogaNode.setPaddingPercent(YogaEdge.TOP, f);
        } else if (j == 38) {
          paramYogaNode.setPaddingPercent(YogaEdge.RIGHT, f);
        } else if (j == 39) {
          paramYogaNode.setPaddingPercent(YogaEdge.BOTTOM, f);
        } else if (j == 40) {
          paramYogaNode.setPaddingPercent(YogaEdge.START, f);
        } else if (j == 41) {
          paramYogaNode.setPaddingPercent(YogaEdge.END, f);
        } else if (j == 42) {
          paramYogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, f);
        } else if (j == 43) {
          paramYogaNode.setPaddingPercent(YogaEdge.VERTICAL, f);
        } else if (j == 44) {
          paramYogaNode.setPaddingPercent(YogaEdge.ALL, f);
        } else if (j == 45) {
          paramYogaNode.setPositionPercent(YogaEdge.LEFT, f);
        } else if (j == 46) {
          paramYogaNode.setPositionPercent(YogaEdge.TOP, f);
        } else if (j == 47) {
          paramYogaNode.setPositionPercent(YogaEdge.RIGHT, f);
        } else if (j == 48) {
          paramYogaNode.setPositionPercent(YogaEdge.BOTTOM, f);
        } else if (j == 49) {
          paramYogaNode.setPositionPercent(YogaEdge.START, f);
        } else if (j == 50) {
          paramYogaNode.setPositionPercent(YogaEdge.END, f);
        } else if (j == 51) {
          paramYogaNode.setPositionPercent(YogaEdge.HORIZONTAL, f);
        } else if (j == 52) {
          paramYogaNode.setPositionPercent(YogaEdge.VERTICAL, f);
        } else if (j == 53) {
          paramYogaNode.setPositionPercent(YogaEdge.ALL, f);
        } else if (j == 55) {
          paramYogaNode.setWidthPercent(f);
        }
      }
    }
    AppMethodBeat.o(144230);
  }
  
  private void applyLayoutRecursive(YogaNode paramYogaNode, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(144226);
    View localView = (View)paramYogaNode.getData();
    if ((localView != null) && (localView != this))
    {
      if (localView.getVisibility() == 8)
      {
        AppMethodBeat.o(144226);
        return;
      }
      localView.measure(View.MeasureSpec.makeMeasureSpec(Math.round(paramYogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(paramYogaNode.getLayoutHeight()), 1073741824));
      localView.layout(Math.round(paramYogaNode.getLayoutX() + paramFloat1), Math.round(paramYogaNode.getLayoutY() + paramFloat2), Math.round(paramYogaNode.getLayoutX() + paramFloat1 + paramYogaNode.getLayoutWidth()), Math.round(paramYogaNode.getLayoutY() + paramFloat2 + paramYogaNode.getLayoutHeight()));
    }
    int j = paramYogaNode.getChildCount();
    int i = 0;
    if (i < j)
    {
      if (equals(localView)) {
        applyLayoutRecursive(paramYogaNode.getChildAt(i), paramFloat1, paramFloat2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!(localView instanceof YogaLayout)) {
          applyLayoutRecursive(paramYogaNode.getChildAt(i), paramYogaNode.getLayoutX() + paramFloat1, paramYogaNode.getLayoutY() + paramFloat2);
        }
      }
    }
    AppMethodBeat.o(144226);
  }
  
  private void createLayout(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144229);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    if (paramInt2 == 1073741824) {
      this.mYogaNode.setHeight(j);
    }
    if (paramInt1 == 1073741824) {
      this.mYogaNode.setWidth(i);
    }
    if (paramInt2 == -2147483648) {
      this.mYogaNode.setMaxHeight(j);
    }
    if (paramInt1 == -2147483648) {
      this.mYogaNode.setMaxWidth(i);
    }
    if (paramInt2 == 0) {
      this.mYogaNode.setHeightAuto();
    }
    this.mYogaNode.calculateLayout(1.0E+021F, 1.0E+021F);
    AppMethodBeat.o(144229);
  }
  
  private void removeViewFromYogaTree(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(144225);
    YogaNode localYogaNode1 = (YogaNode)this.mYogaNodes.get(paramView);
    if (localYogaNode1 == null)
    {
      AppMethodBeat.o(144225);
      return;
    }
    YogaNode localYogaNode2 = localYogaNode1.getParent();
    int i = 0;
    for (;;)
    {
      if (i < localYogaNode2.getChildCount())
      {
        if (localYogaNode2.getChildAt(i).equals(localYogaNode1)) {
          localYogaNode2.removeChildAt(i);
        }
      }
      else
      {
        localYogaNode1.setData(null);
        this.mYogaNodes.remove(paramView);
        if (paramBoolean) {
          this.mYogaNode.calculateLayout(1.0E+021F, 1.0E+021F);
        }
        AppMethodBeat.o(144225);
        return;
      }
      i += 1;
    }
  }
  
  public YogaNode addView(View paramView, YogaNode paramYogaNode)
  {
    AppMethodBeat.i(144216);
    this.mYogaNode.setMeasureFunction(null);
    if (!(paramView instanceof YogaLayout))
    {
      paramYogaNode.setData(paramView);
      paramYogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
    }
    this.mYogaNodes.put(paramView, paramYogaNode);
    this.mYogaNode.addChildAt(paramYogaNode, this.mYogaNode.getChildCount());
    super.addView(paramView, getChildCount(), new YogaLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(144216);
    return paramYogaNode;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(144215);
    this.mYogaNode.setMeasureFunction(null);
    if ((paramView instanceof VirtualYogaLayout))
    {
      ((VirtualYogaLayout)paramView).transferChildren(this);
      paramView = ((VirtualYogaLayout)paramView).getYogaNode();
      this.mYogaNode.addChildAt(paramView, this.mYogaNode.getChildCount());
      AppMethodBeat.o(144215);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    if (this.mYogaNodes.containsKey(paramView))
    {
      AppMethodBeat.o(144215);
      return;
    }
    if ((paramView instanceof YogaLayout))
    {
      paramLayoutParams = ((YogaLayout)paramView).getYogaNode();
      applyLayoutParams((YogaLayout.LayoutParams)paramView.getLayoutParams(), paramLayoutParams, paramView);
      this.mYogaNodes.put(paramView, paramLayoutParams);
      this.mYogaNode.addChildAt(paramLayoutParams, this.mYogaNode.getChildCount());
      AppMethodBeat.o(144215);
      return;
    }
    if (this.mYogaNodes.containsKey(paramView)) {}
    for (paramLayoutParams = (YogaNode)this.mYogaNodes.get(paramView);; paramLayoutParams = new YogaNode())
    {
      paramLayoutParams.setData(paramView);
      paramLayoutParams.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
      break;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof YogaLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(144232);
    YogaLayout.LayoutParams localLayoutParams = new YogaLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(144232);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(144231);
    paramAttributeSet = new YogaLayout.LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(144231);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(144233);
    paramLayoutParams = new YogaLayout.LayoutParams(paramLayoutParams);
    AppMethodBeat.o(144233);
    return paramLayoutParams;
  }
  
  public YogaNode getYogaNode()
  {
    return this.mYogaNode;
  }
  
  public YogaNode getYogaNodeForView(View paramView)
  {
    AppMethodBeat.i(144214);
    paramView = (YogaNode)this.mYogaNodes.get(paramView);
    AppMethodBeat.o(144214);
    return paramView;
  }
  
  public void invalidate(View paramView)
  {
    AppMethodBeat.i(144224);
    if (this.mYogaNodes.containsKey(paramView))
    {
      ((YogaNode)this.mYogaNodes.get(paramView)).dirty();
      AppMethodBeat.o(144224);
      return;
    }
    int j = this.mYogaNode.getChildCount();
    int i = 0;
    while (i < j)
    {
      YogaNode localYogaNode = this.mYogaNode.getChildAt(i);
      if ((localYogaNode.getData() instanceof YogaLayout)) {
        ((YogaLayout)localYogaNode.getData()).invalidate(paramView);
      }
      i += 1;
    }
    invalidate();
    AppMethodBeat.o(144224);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(144227);
    if (!(getParent() instanceof YogaLayout)) {
      createLayout(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
    }
    applyLayoutRecursive(this.mYogaNode, 0.0F, 0.0F);
    AppMethodBeat.o(144227);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144228);
    if (!(getParent() instanceof YogaLayout)) {
      createLayout(paramInt1, paramInt2);
    }
    setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
    AppMethodBeat.o(144228);
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(144222);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      removeViewFromYogaTree(getChildAt(i), false);
      i += 1;
    }
    super.removeAllViews();
    AppMethodBeat.o(144222);
  }
  
  public void removeAllViewsInLayout()
  {
    AppMethodBeat.i(144223);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      removeViewFromYogaTree(getChildAt(i), true);
      i += 1;
    }
    super.removeAllViewsInLayout();
    AppMethodBeat.o(144223);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(144217);
    removeViewFromYogaTree(paramView, false);
    super.removeView(paramView);
    AppMethodBeat.o(144217);
  }
  
  public void removeViewAt(int paramInt)
  {
    AppMethodBeat.i(144218);
    removeViewFromYogaTree(getChildAt(paramInt), false);
    super.removeViewAt(paramInt);
    AppMethodBeat.o(144218);
  }
  
  public void removeViewInLayout(View paramView)
  {
    AppMethodBeat.i(144219);
    removeViewFromYogaTree(paramView, true);
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(144219);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144220);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      removeViewFromYogaTree(getChildAt(i), false);
      i += 1;
    }
    super.removeViews(paramInt1, paramInt2);
    AppMethodBeat.o(144220);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144221);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      removeViewFromYogaTree(getChildAt(i), true);
      i += 1;
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
    AppMethodBeat.o(144221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.android.YogaLayout
 * JD-Core Version:    0.7.0.1
 */