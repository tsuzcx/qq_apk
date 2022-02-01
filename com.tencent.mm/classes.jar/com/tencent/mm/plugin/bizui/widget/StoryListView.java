package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StoryListView
  extends ListView
{
  private boolean nUM;
  
  public StoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(123723);
    if (!this.nUM) {
      super.layoutChildren();
    }
    AppMethodBeat.o(123723);
  }
  
  public void setBlockLayoutChildren(boolean paramBoolean)
  {
    this.nUM = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.widget.StoryListView
 * JD-Core Version:    0.7.0.1
 */