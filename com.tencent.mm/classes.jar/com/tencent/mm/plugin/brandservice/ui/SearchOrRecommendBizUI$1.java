package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class SearchOrRecommendBizUI$1
  implements com.tencent.mm.ah.f
{
  SearchOrRecommendBizUI$1(SearchOrRecommendBizUI paramSearchOrRecommendBizUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm == null) {
      y.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
    }
    do
    {
      return;
      if (paramm.getType() != 456)
      {
        y.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
        return;
      }
      g.Dk().b(456, this);
      y.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramm = com.tencent.mm.plugin.brandservice.b.f.axu();
    if (SearchOrRecommendBizUI.a(this.ief) == null)
    {
      paramString = null;
      label96:
      if ((paramString == null) || (paramm == null) || (paramm.size() <= 0)) {
        break label163;
      }
      if (paramString.getCount() != 0) {
        break label165;
      }
    }
    label163:
    label165:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString.idY = paramm;
      if (paramInt1 == 0) {
        break;
      }
      ai.d(new SearchOrRecommendBizUI.1.1(this, paramString));
      return;
      paramString = (f)SearchOrRecommendBizUI.a(this.ief).getAdapter();
      break label96;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.1
 * JD-Core Version:    0.7.0.1
 */