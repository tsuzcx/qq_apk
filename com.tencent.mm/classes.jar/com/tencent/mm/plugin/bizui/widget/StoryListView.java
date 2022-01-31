package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class StoryListView
  extends ListView
{
  private boolean hTb;
  
  public StoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void layoutChildren()
  {
    if (!this.hTb) {
      super.layoutChildren();
    }
  }
  
  public void setBlockLayoutChildren(boolean paramBoolean)
  {
    this.hTb = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.widget.StoryListView
 * JD-Core Version:    0.7.0.1
 */