package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;

final class BizSearchResultItemContainer$a
{
  View ida;
  View idb;
  View idc;
  
  private void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    View localView = this.ida;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      this.idb.setVisibility(8);
      localView = this.idc;
      if (!paramBoolean2) {
        break label56;
      }
    }
    label56:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public final void ov(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      v(false, false);
      return;
    case 1: 
      v(true, false);
      return;
    case 2: 
      v(false, true);
      return;
    }
    v(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.a
 * JD-Core Version:    0.7.0.1
 */