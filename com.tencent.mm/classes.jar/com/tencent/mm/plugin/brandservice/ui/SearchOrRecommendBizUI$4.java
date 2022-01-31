package com.tencent.mm.plugin.brandservice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;

final class SearchOrRecommendBizUI$4
  implements View.OnTouchListener
{
  SearchOrRecommendBizUI$4(SearchOrRecommendBizUI paramSearchOrRecommendBizUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    SearchOrRecommendBizUI.b(this.ief).clearFocus();
    this.ief.XM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.4
 * JD-Core Version:    0.7.0.1
 */