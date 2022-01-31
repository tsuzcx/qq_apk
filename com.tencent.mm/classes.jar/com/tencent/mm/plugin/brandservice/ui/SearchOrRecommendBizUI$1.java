package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;

final class SearchOrRecommendBizUI$1
  implements com.tencent.mm.ai.f
{
  SearchOrRecommendBizUI$1(SearchOrRecommendBizUI paramSearchOrRecommendBizUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(14041);
    if (paramm == null)
    {
      ab.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
      AppMethodBeat.o(14041);
      return;
    }
    if (paramm.getType() != 456)
    {
      ab.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
      AppMethodBeat.o(14041);
      return;
    }
    g.Rc().b(456, this);
    ab.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = com.tencent.mm.plugin.brandservice.b.f.aWs();
      if (SearchOrRecommendBizUI.a(this.jUT) != null) {
        break label169;
      }
      paramString = null;
      if ((paramString != null) && (paramm != null) && (paramm.size() > 0)) {
        if (paramString.getCount() != 0) {
          break label189;
        }
      }
    }
    label169:
    label189:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString.jUM = paramm;
      if (paramInt1 != 0) {
        al.d(new SearchOrRecommendBizUI.1.1(this, paramString));
      }
      AppMethodBeat.o(14041);
      return;
      paramString = (f)SearchOrRecommendBizUI.a(this.jUT).getAdapter();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.1
 * JD-Core Version:    0.7.0.1
 */