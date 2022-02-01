package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
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
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.tencent.kinda.R.styleable;
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
    AppMethodBeat.i(18237);
    this.mYogaNode = YogaNodeFactory.create();
    this.mYogaNodes = new HashMap();
    this.mYogaNode.setData(this);
    this.mYogaNode.setMeasureFunction(new ViewMeasureFunction());
    if (paramAttributeSet != null) {}
    for (paramContext = new LayoutParams(paramContext, paramAttributeSet);; paramContext = (LayoutParams)generateDefaultLayoutParams())
    {
      applyLayoutParams(paramContext, this.mYogaNode, this);
      AppMethodBeat.o(18237);
      return;
    }
  }
  
  protected static void applyLayoutParams(LayoutParams paramLayoutParams, YogaNode paramYogaNode, View paramView)
  {
    AppMethodBeat.i(18254);
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
      if (j == R.styleable.yoga_yg_alignContent) {
        paramYogaNode.setAlignContent(YogaAlign.fromInt(Math.round(f)));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == R.styleable.yoga_yg_alignItems) {
          paramYogaNode.setAlignItems(YogaAlign.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_alignSelf) {
          paramYogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_aspectRatio) {
          paramYogaNode.setAspectRatio(f);
        } else if (j == R.styleable.yoga_yg_borderLeft) {
          paramYogaNode.setBorder(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_borderTop) {
          paramYogaNode.setBorder(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_borderRight) {
          paramYogaNode.setBorder(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_borderBottom) {
          paramYogaNode.setBorder(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_borderStart) {
          paramYogaNode.setBorder(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_borderEnd) {
          paramYogaNode.setBorder(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_borderHorizontal) {
          paramYogaNode.setBorder(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_borderVertical) {
          paramYogaNode.setBorder(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_borderAll) {
          paramYogaNode.setBorder(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_direction) {
          paramYogaNode.setDirection(YogaDirection.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_display) {
          paramYogaNode.setDisplay(YogaDisplay.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_flex) {
          paramYogaNode.setFlex(f);
        } else if (j == R.styleable.yoga_yg_flexBasis) {
          paramYogaNode.setFlexBasis(f);
        } else if (j == R.styleable.yoga_yg_flexDirection) {
          paramYogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_flexGrow) {
          paramYogaNode.setFlexGrow(f);
        } else if (j == R.styleable.yoga_yg_flexShrink) {
          paramYogaNode.setFlexShrink(f);
        } else if (j == R.styleable.yoga_yg_height) {
          paramYogaNode.setHeight(f);
        } else if (j == R.styleable.yoga_yg_marginLeft) {
          paramYogaNode.setMargin(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_justifyContent) {
          paramYogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_marginTop) {
          paramYogaNode.setMargin(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_marginRight) {
          paramYogaNode.setMargin(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_marginBottom) {
          paramYogaNode.setMargin(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_marginStart) {
          paramYogaNode.setMargin(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_marginEnd) {
          paramYogaNode.setMargin(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_marginHorizontal) {
          paramYogaNode.setMargin(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_marginVertical) {
          paramYogaNode.setMargin(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_marginAll) {
          paramYogaNode.setMargin(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_maxHeight) {
          paramYogaNode.setMaxHeight(f);
        } else if (j == R.styleable.yoga_yg_maxWidth) {
          paramYogaNode.setMaxWidth(f);
        } else if (j == R.styleable.yoga_yg_minHeight) {
          paramYogaNode.setMinHeight(f);
        } else if (j == R.styleable.yoga_yg_minWidth) {
          paramYogaNode.setMinWidth(f);
        } else if (j == R.styleable.yoga_yg_overflow) {
          paramYogaNode.setOverflow(YogaOverflow.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_paddingLeft) {
          paramYogaNode.setPadding(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_paddingTop) {
          paramYogaNode.setPadding(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_paddingRight) {
          paramYogaNode.setPadding(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_paddingBottom) {
          paramYogaNode.setPadding(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_paddingStart) {
          paramYogaNode.setPadding(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_paddingEnd) {
          paramYogaNode.setPadding(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_paddingHorizontal) {
          paramYogaNode.setPadding(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_paddingVertical) {
          paramYogaNode.setPadding(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_paddingAll) {
          paramYogaNode.setPadding(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_positionLeft) {
          paramYogaNode.setPosition(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_positionTop) {
          paramYogaNode.setPosition(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_positionRight) {
          paramYogaNode.setPosition(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_positionBottom) {
          paramYogaNode.setPosition(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_positionStart) {
          paramYogaNode.setPosition(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_positionEnd) {
          paramYogaNode.setPosition(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_positionHorizontal) {
          paramYogaNode.setPosition(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_positionVertical) {
          paramYogaNode.setPosition(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_positionAll) {
          paramYogaNode.setPosition(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_positionType) {
          paramYogaNode.setPositionType(YogaPositionType.fromInt(Math.round(f)));
        } else if (j == R.styleable.yoga_yg_width) {
          paramYogaNode.setWidth(f);
        } else if (j == R.styleable.yoga_yg_wrap) {
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
        if (j == R.styleable.yoga_yg_marginLeft) {
          paramYogaNode.setMarginAuto(YogaEdge.LEFT);
        }
      }
      else {
        label1306:
        if (paramView.endsWith("%"))
        {
          f = Float.parseFloat(paramView.substring(0, paramView.length() - 1));
          if (j != R.styleable.yoga_yg_flexBasis) {
            break label1497;
          }
          paramYogaNode.setFlexBasisPercent(f);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == R.styleable.yoga_yg_marginTop)
        {
          paramYogaNode.setMarginAuto(YogaEdge.TOP);
          break label1306;
        }
        if (j == R.styleable.yoga_yg_marginRight)
        {
          paramYogaNode.setMarginAuto(YogaEdge.RIGHT);
          break label1306;
        }
        if (j == R.styleable.yoga_yg_marginBottom)
        {
          paramYogaNode.setMarginAuto(YogaEdge.BOTTOM);
          break label1306;
        }
        if (j == R.styleable.yoga_yg_marginStart)
        {
          paramYogaNode.setMarginAuto(YogaEdge.START);
          break label1306;
        }
        if (j == R.styleable.yoga_yg_marginEnd)
        {
          paramYogaNode.setMarginAuto(YogaEdge.END);
          break label1306;
        }
        if (j == R.styleable.yoga_yg_marginHorizontal)
        {
          paramYogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
          break label1306;
        }
        if (j == R.styleable.yoga_yg_marginVertical)
        {
          paramYogaNode.setMarginAuto(YogaEdge.VERTICAL);
          break label1306;
        }
        if (j != R.styleable.yoga_yg_marginAll) {
          break label1306;
        }
        paramYogaNode.setMarginAuto(YogaEdge.ALL);
        break label1306;
        label1497:
        if (j == R.styleable.yoga_yg_height) {
          paramYogaNode.setHeightPercent(f);
        } else if (j == R.styleable.yoga_yg_marginLeft) {
          paramYogaNode.setMarginPercent(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_marginTop) {
          paramYogaNode.setMarginPercent(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_marginRight) {
          paramYogaNode.setMarginPercent(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_marginBottom) {
          paramYogaNode.setMarginPercent(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_marginStart) {
          paramYogaNode.setMarginPercent(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_marginEnd) {
          paramYogaNode.setMarginPercent(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_marginHorizontal) {
          paramYogaNode.setMarginPercent(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_marginVertical) {
          paramYogaNode.setMarginPercent(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_marginAll) {
          paramYogaNode.setMarginPercent(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_maxHeight) {
          paramYogaNode.setMaxHeightPercent(f);
        } else if (j == R.styleable.yoga_yg_maxWidth) {
          paramYogaNode.setMaxWidthPercent(f);
        } else if (j == R.styleable.yoga_yg_minHeight) {
          paramYogaNode.setMinHeightPercent(f);
        } else if (j == R.styleable.yoga_yg_minWidth) {
          paramYogaNode.setMinWidthPercent(f);
        } else if (j == R.styleable.yoga_yg_paddingLeft) {
          paramYogaNode.setPaddingPercent(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_paddingTop) {
          paramYogaNode.setPaddingPercent(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_paddingRight) {
          paramYogaNode.setPaddingPercent(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_paddingBottom) {
          paramYogaNode.setPaddingPercent(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_paddingStart) {
          paramYogaNode.setPaddingPercent(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_paddingEnd) {
          paramYogaNode.setPaddingPercent(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_paddingHorizontal) {
          paramYogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_paddingVertical) {
          paramYogaNode.setPaddingPercent(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_paddingAll) {
          paramYogaNode.setPaddingPercent(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_positionLeft) {
          paramYogaNode.setPositionPercent(YogaEdge.LEFT, f);
        } else if (j == R.styleable.yoga_yg_positionTop) {
          paramYogaNode.setPositionPercent(YogaEdge.TOP, f);
        } else if (j == R.styleable.yoga_yg_positionRight) {
          paramYogaNode.setPositionPercent(YogaEdge.RIGHT, f);
        } else if (j == R.styleable.yoga_yg_positionBottom) {
          paramYogaNode.setPositionPercent(YogaEdge.BOTTOM, f);
        } else if (j == R.styleable.yoga_yg_positionStart) {
          paramYogaNode.setPositionPercent(YogaEdge.START, f);
        } else if (j == R.styleable.yoga_yg_positionEnd) {
          paramYogaNode.setPositionPercent(YogaEdge.END, f);
        } else if (j == R.styleable.yoga_yg_positionHorizontal) {
          paramYogaNode.setPositionPercent(YogaEdge.HORIZONTAL, f);
        } else if (j == R.styleable.yoga_yg_positionVertical) {
          paramYogaNode.setPositionPercent(YogaEdge.VERTICAL, f);
        } else if (j == R.styleable.yoga_yg_positionAll) {
          paramYogaNode.setPositionPercent(YogaEdge.ALL, f);
        } else if (j == R.styleable.yoga_yg_width) {
          paramYogaNode.setWidthPercent(f);
        }
      }
    }
    AppMethodBeat.o(18254);
  }
  
  private void applyLayoutRecursive(YogaNode paramYogaNode, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(18250);
    View localView = (View)paramYogaNode.getData();
    if ((localView != null) && (localView != this))
    {
      if (localView.getVisibility() == 8)
      {
        AppMethodBeat.o(18250);
        return;
      }
      i = Math.round(paramYogaNode.getLayoutX() + paramFloat1);
      j = Math.round(paramYogaNode.getLayoutY() + paramFloat2);
      localView.measure(View.MeasureSpec.makeMeasureSpec(Math.round(paramYogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(paramYogaNode.getLayoutHeight()), 1073741824));
      localView.layout(i, j, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + j);
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
    AppMethodBeat.o(18250);
  }
  
  private void createLayout(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18253);
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
    this.mYogaNode.calculateLayout((0.0F / 0.0F), (0.0F / 0.0F));
    AppMethodBeat.o(18253);
  }
  
  private void removeViewFromYogaTree(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(18249);
    YogaNode localYogaNode1 = (YogaNode)this.mYogaNodes.get(paramView);
    if (localYogaNode1 == null)
    {
      AppMethodBeat.o(18249);
      return;
    }
    YogaNode localYogaNode2 = localYogaNode1.getOwner();
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
          this.mYogaNode.calculateLayout((0.0F / 0.0F), (0.0F / 0.0F));
        }
        AppMethodBeat.o(18249);
        return;
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(18239);
    this.mYogaNode.setMeasureFunction(null);
    if ((paramView instanceof VirtualYogaLayout))
    {
      ((VirtualYogaLayout)paramView).transferChildren(this);
      paramView = ((VirtualYogaLayout)paramView).getYogaNode();
      this.mYogaNode.addChildAt(paramView, this.mYogaNode.getChildCount());
      AppMethodBeat.o(18239);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    if (this.mYogaNodes.containsKey(paramView))
    {
      AppMethodBeat.o(18239);
      return;
    }
    if ((paramView instanceof YogaLayout))
    {
      paramLayoutParams = ((YogaLayout)paramView).getYogaNode();
      applyLayoutParams((LayoutParams)paramView.getLayoutParams(), paramLayoutParams, paramView);
      this.mYogaNodes.put(paramView, paramLayoutParams);
      this.mYogaNode.addChildAt(paramLayoutParams, this.mYogaNode.getChildCount());
      AppMethodBeat.o(18239);
      return;
    }
    if (this.mYogaNodes.containsKey(paramView)) {}
    for (paramLayoutParams = (YogaNode)this.mYogaNodes.get(paramView);; paramLayoutParams = YogaNodeFactory.create())
    {
      paramLayoutParams.setData(paramView);
      paramLayoutParams.setMeasureFunction(new ViewMeasureFunction());
      break;
    }
  }
  
  public void addView(View paramView, YogaNode paramYogaNode)
  {
    AppMethodBeat.i(208217);
    this.mYogaNode.setMeasureFunction(null);
    if (!(paramView instanceof YogaLayout))
    {
      paramYogaNode.setData(paramView);
      paramYogaNode.setMeasureFunction(new ViewMeasureFunction());
    }
    this.mYogaNodes.put(paramView, paramYogaNode);
    this.mYogaNode.addChildAt(paramYogaNode, this.mYogaNode.getChildCount());
    super.addView(paramView, getChildCount(), new LayoutParams(-1, -1));
    AppMethodBeat.o(208217);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(18256);
    LayoutParams localLayoutParams = new LayoutParams(-1, -1);
    AppMethodBeat.o(18256);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(18255);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(18255);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(18257);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(18257);
    return paramLayoutParams;
  }
  
  public YogaNode getYogaNode()
  {
    return this.mYogaNode;
  }
  
  public YogaNode getYogaNodeForView(View paramView)
  {
    AppMethodBeat.i(18238);
    paramView = (YogaNode)this.mYogaNodes.get(paramView);
    AppMethodBeat.o(18238);
    return paramView;
  }
  
  public void invalidate(View paramView)
  {
    AppMethodBeat.i(18248);
    if (this.mYogaNodes.containsKey(paramView))
    {
      ((YogaNode)this.mYogaNodes.get(paramView)).dirty();
      AppMethodBeat.o(18248);
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
    AppMethodBeat.o(18248);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(18251);
    if (!(getParent() instanceof YogaLayout)) {
      createLayout(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
    }
    applyLayoutRecursive(this.mYogaNode, 0.0F, 0.0F);
    AppMethodBeat.o(18251);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18252);
    if (!(getParent() instanceof YogaLayout)) {
      createLayout(paramInt1, paramInt2);
    }
    setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
    AppMethodBeat.o(18252);
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(18246);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      removeViewFromYogaTree(getChildAt(i), false);
      i += 1;
    }
    super.removeAllViews();
    AppMethodBeat.o(18246);
  }
  
  public void removeAllViewsInLayout()
  {
    AppMethodBeat.i(18247);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      removeViewFromYogaTree(getChildAt(i), true);
      i += 1;
    }
    super.removeAllViewsInLayout();
    AppMethodBeat.o(18247);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(18241);
    removeViewFromYogaTree(paramView, false);
    super.removeView(paramView);
    AppMethodBeat.o(18241);
  }
  
  public void removeViewAt(int paramInt)
  {
    AppMethodBeat.i(18242);
    removeViewFromYogaTree(getChildAt(paramInt), false);
    super.removeViewAt(paramInt);
    AppMethodBeat.o(18242);
  }
  
  public void removeViewInLayout(View paramView)
  {
    AppMethodBeat.i(18243);
    removeViewFromYogaTree(paramView, true);
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(18243);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18244);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      removeViewFromYogaTree(getChildAt(i), false);
      i += 1;
    }
    super.removeViews(paramInt1, paramInt2);
    AppMethodBeat.o(18244);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18245);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      removeViewFromYogaTree(getChildAt(i), true);
      i += 1;
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
    AppMethodBeat.o(18245);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    SparseArray<Float> numericAttributes;
    SparseArray<String> stringAttributes;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(18234);
      this.numericAttributes = new SparseArray();
      this.stringAttributes = new SparseArray();
      if (paramInt1 >= 0) {
        this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(paramInt1));
      }
      if (paramInt2 >= 0) {
        this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(paramInt2));
      }
      AppMethodBeat.o(18234);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(18235);
      this.numericAttributes = new SparseArray();
      this.stringAttributes = new SparseArray();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.yoga);
      if (this.width >= 0) {
        this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(this.width));
      }
      if (this.height >= 0) {
        this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(this.height));
      }
      int j = paramContext.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramContext.getIndex(i);
        paramAttributeSet = new TypedValue();
        paramContext.getValue(k, paramAttributeSet);
        if (paramAttributeSet.type == 5) {
          this.numericAttributes.put(k, Float.valueOf(paramContext.getDimensionPixelSize(k, 0)));
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramAttributeSet.type == 3) {
            this.stringAttributes.put(k, paramContext.getString(k));
          } else {
            this.numericAttributes.put(k, Float.valueOf(paramContext.getFloat(k, 0.0F)));
          }
        }
      }
      paramContext.recycle();
      AppMethodBeat.o(18235);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(18233);
      if ((paramLayoutParams instanceof LayoutParams))
      {
        this.numericAttributes = ((LayoutParams)paramLayoutParams).numericAttributes.clone();
        this.stringAttributes = ((LayoutParams)paramLayoutParams).stringAttributes.clone();
        AppMethodBeat.o(18233);
        return;
      }
      this.numericAttributes = new SparseArray();
      this.stringAttributes = new SparseArray();
      if (paramLayoutParams.width >= 0) {
        this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(this.width));
      }
      if (paramLayoutParams.height >= 0) {
        this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(this.height));
      }
      AppMethodBeat.o(18233);
    }
  }
  
  public static class ViewMeasureFunction
    implements YogaMeasureFunction
  {
    private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode paramYogaMeasureMode)
    {
      if (paramYogaMeasureMode == YogaMeasureMode.AT_MOST) {
        return -2147483648;
      }
      if (paramYogaMeasureMode == YogaMeasureMode.EXACTLY) {
        return 1073741824;
      }
      return 0;
    }
    
    public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
    {
      AppMethodBeat.i(18236);
      paramYogaNode = (View)paramYogaNode.getData();
      if ((paramYogaNode == null) || ((paramYogaNode instanceof YogaLayout)))
      {
        l = YogaMeasureOutput.make(0, 0);
        AppMethodBeat.o(18236);
        return l;
      }
      paramYogaNode.measure(View.MeasureSpec.makeMeasureSpec((int)paramFloat1, viewMeasureSpecFromYogaMeasureMode(paramYogaMeasureMode1)), View.MeasureSpec.makeMeasureSpec((int)paramFloat2, viewMeasureSpecFromYogaMeasureMode(paramYogaMeasureMode2)));
      long l = YogaMeasureOutput.make(paramYogaNode.getMeasuredWidth(), paramYogaNode.getMeasuredHeight());
      AppMethodBeat.o(18236);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.facebook.yoga.android.YogaLayout
 * JD-Core Version:    0.7.0.1
 */