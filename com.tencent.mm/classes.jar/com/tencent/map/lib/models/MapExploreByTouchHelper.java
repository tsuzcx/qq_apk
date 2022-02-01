package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.support.v4.view.t;
import android.support.v4.widget.j;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class MapExploreByTouchHelper
  extends j
{
  protected static final int MAP_ACTION_CLICKED = 1;
  protected static final int NO_ITEM = -1;
  protected List<AccessibleTouchItem> accessibleTouchItems = new ArrayList();
  
  public MapExploreByTouchHelper(View paramView)
  {
    super(paramView);
  }
  
  protected abstract int getTargetPoiItemIdx(float paramFloat1, float paramFloat2);
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    int j = getTargetPoiItemIdx(paramFloat1, paramFloat2);
    int i = j;
    if (j == -1) {
      i = -2147483648;
    }
    return i;
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    int i = 0;
    while (i < this.accessibleTouchItems.size())
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  protected abstract boolean onItemClicked(int paramInt);
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 == 16) {
      return onItemClicked(paramInt1);
    }
    return false;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramInt >= this.accessibleTouchItems.size())
    {
      paramAccessibilityEvent.getText().add("");
      return;
    }
    AccessibleTouchItem localAccessibleTouchItem = (AccessibleTouchItem)this.accessibleTouchItems.get(paramInt);
    if (localAccessibleTouchItem == null) {
      throw new IllegalArgumentException("Invalid virtual view id");
    }
    paramAccessibilityEvent.getText().add(localAccessibleTouchItem.getContentDescription());
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, c paramc)
  {
    if (paramInt >= this.accessibleTouchItems.size())
    {
      paramc.setText("");
      paramc.setBoundsInParent(new Rect());
      return;
    }
    AccessibleTouchItem localAccessibleTouchItem = (AccessibleTouchItem)this.accessibleTouchItems.get(paramInt);
    if (localAccessibleTouchItem == null) {
      throw new IllegalArgumentException("Invalid virtual view id");
    }
    paramc.setText(localAccessibleTouchItem.getContentDescription());
    paramc.setBoundsInParent(localAccessibleTouchItem.getBounds());
    paramc.addAction(16);
  }
  
  public void onTalkBackActivate(View paramView)
  {
    t.a(paramView, this);
  }
  
  public void onTalkBackDeActivate(View paramView)
  {
    t.a(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.models.MapExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */