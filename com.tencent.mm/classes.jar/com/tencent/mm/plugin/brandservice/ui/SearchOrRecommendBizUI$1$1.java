package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.sdk.platformtools.y;

final class SearchOrRecommendBizUI$1$1
  implements Runnable
{
  SearchOrRecommendBizUI$1$1(SearchOrRecommendBizUI.1 param1, f paramf) {}
  
  public final void run()
  {
    y.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
    this.ieg.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.1.1
 * JD-Core Version:    0.7.0.1
 */