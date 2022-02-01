package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import androidx.core.g.z;
import androidx.customview.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class MapExploreByTouchHelper
  extends a
{
  protected static final int MAP_ACTION_CLICKED = 1;
  protected static final int NO_ITEM = -1;
  public List<AccessibleTouchItem> accessibleTouchItems = new ArrayList();
  
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
  
  public void onPopulateNodeForVirtualView(int paramInt, d paramd)
  {
    if (paramInt >= this.accessibleTouchItems.size())
    {
      paramd.setText("");
      paramd.k(new Rect());
      return;
    }
    AccessibleTouchItem localAccessibleTouchItem = (AccessibleTouchItem)this.accessibleTouchItems.get(paramInt);
    if (localAccessibleTouchItem == null) {
      throw new IllegalArgumentException("Invalid virtual view id");
    }
    paramd.setText(localAccessibleTouchItem.getContentDescription());
    paramd.k(localAccessibleTouchItem.getBounds());
    paramd.eu(16);
  }
  
  public void onTalkBackActivate(View paramView)
  {
    z.a(paramView, this);
  }
  
  public void onTalkBackDeActivate(View paramView)
  {
    z.a(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.lib.models.MapExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */