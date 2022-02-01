package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;

public class XExpandableListView
  extends ExpandableListView
{
  public XExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public XExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aj = 2147483647;
    setEdgeEffectEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.XExpandableListView
 * JD-Core Version:    0.7.0.1
 */