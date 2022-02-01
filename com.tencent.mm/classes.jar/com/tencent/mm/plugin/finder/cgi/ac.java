package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class ac
  extends n
  implements k
{
  private final String TAG;
  public final aqy rIl;
  
  public ac(aqy paramaqy)
  {
    this.rIl = paramaqy;
    this.TAG = "Finder.NetSceneFinderBase";
    if (cxU())
    {
      paramaqy = h.soM;
      paramaqy = this.rIl;
      if (paramaqy == null) {
        break label92;
      }
    }
    label92:
    for (int i = paramaqy.rTD;; i = 0)
    {
      h.EY(i);
      paramaqy = this.rIl;
      if (paramaqy != null) {
        ad.i(this.TAG, "Create commentScene:" + paramaqy.rTD + " fromCommentScene:" + paramaqy.tcl);
      }
      return;
    }
  }
  
  public boolean cxU()
  {
    return false;
  }
  
  public final void d(FinderObject paramFinderObject)
  {
    p.h(paramFinderObject, "finderObject");
    aqy localaqy = this.rIl;
    if (localaqy != null)
    {
      h localh = h.soM;
      h.d(paramFinderObject.id, localaqy.rTD, paramFinderObject.sessionBuffer);
    }
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = a.suA;
    a.w(paramInt2, paramInt3, paramString);
    paramq = a.suA;
    a.x(paramInt2, paramInt3, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ac
 * JD-Core Version:    0.7.0.1
 */