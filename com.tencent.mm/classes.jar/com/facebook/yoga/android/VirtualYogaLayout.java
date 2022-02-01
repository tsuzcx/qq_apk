package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VirtualYogaLayout
  extends ViewGroup
{
  private final List<View> mChildren;
  private final YogaNode mYogaNode;
  private final Map<View, YogaNode> mYogaNodes;
  
  public VirtualYogaLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(18223);
    this.mChildren = new LinkedList();
    this.mYogaNodes = new HashMap();
    this.mYogaNode = YogaNodeFactory.create();
    AppMethodBeat.o(18223);
  }
  
  public VirtualYogaLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VirtualYogaLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(18224);
    this.mChildren = new LinkedList();
    this.mYogaNodes = new HashMap();
    this.mYogaNode = YogaNodeFactory.create();
    YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(paramContext, paramAttributeSet), this.mYogaNode, this);
    AppMethodBeat.o(18224);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(18225);
    if ((paramView instanceof VirtualYogaLayout))
    {
      ((VirtualYogaLayout)paramView).transferChildren(this);
      paramView = ((VirtualYogaLayout)paramView).getYogaNode();
      this.mYogaNode.addChildAt(paramView, this.mYogaNode.getChildCount());
      AppMethodBeat.o(18225);
      return;
    }
    YogaNode localYogaNode = YogaNodeFactory.create();
    YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(paramLayoutParams), localYogaNode, paramView);
    localYogaNode.setData(paramView);
    localYogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
    this.mYogaNode.addChildAt(localYogaNode, this.mYogaNode.getChildCount());
    addView(paramView, localYogaNode);
    AppMethodBeat.o(18225);
  }
  
  public void addView(View paramView, YogaNode paramYogaNode)
  {
    AppMethodBeat.i(18226);
    this.mChildren.add(paramView);
    this.mYogaNodes.put(paramView, paramYogaNode);
    AppMethodBeat.o(18226);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof YogaLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(18230);
    YogaLayout.LayoutParams localLayoutParams = new YogaLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(18230);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(18229);
    paramAttributeSet = new YogaLayout.LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(18229);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(18231);
    paramLayoutParams = new YogaLayout.LayoutParams(paramLayoutParams);
    AppMethodBeat.o(18231);
    return paramLayoutParams;
  }
  
  public YogaNode getYogaNode()
  {
    return this.mYogaNode;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(18228);
    RuntimeException localRuntimeException = new RuntimeException("Attempting to layout a VirtualYogaLayout");
    AppMethodBeat.o(18228);
    throw localRuntimeException;
  }
  
  protected void transferChildren(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18227);
    Iterator localIterator;
    View localView;
    if ((paramViewGroup instanceof VirtualYogaLayout))
    {
      localIterator = this.mChildren.iterator();
      while (localIterator.hasNext())
      {
        localView = (View)localIterator.next();
        ((VirtualYogaLayout)paramViewGroup).addView(localView, (YogaNode)this.mYogaNodes.get(localView));
      }
    }
    if ((paramViewGroup instanceof YogaLayout))
    {
      localIterator = this.mChildren.iterator();
      while (localIterator.hasNext())
      {
        localView = (View)localIterator.next();
        ((YogaLayout)paramViewGroup).addView(localView, (YogaNode)this.mYogaNodes.get(localView));
      }
    }
    paramViewGroup = new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + paramViewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
    AppMethodBeat.o(18227);
    throw paramViewGroup;
    this.mChildren.clear();
    AppMethodBeat.o(18227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.yoga.android.VirtualYogaLayout
 * JD-Core Version:    0.7.0.1
 */