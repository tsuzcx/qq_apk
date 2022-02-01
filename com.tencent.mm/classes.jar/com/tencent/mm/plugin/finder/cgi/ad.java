package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class ad
  extends n
  implements k
{
  private final String TAG;
  public final arn rQw;
  
  public ad(arn paramarn)
  {
    this.rQw = paramarn;
    this.TAG = "Finder.NetSceneFinderBase";
    if (czv())
    {
      paramarn = i.syT;
      paramarn = this.rQw;
      if (paramarn == null) {
        break label92;
      }
    }
    label92:
    for (int i = paramarn.sch;; i = 0)
    {
      i.Fu(i);
      paramarn = this.rQw;
      if (paramarn != null) {
        ae.i(this.TAG, "Create commentScene:" + paramarn.sch + " fromCommentScene:" + paramarn.tnf);
      }
      return;
    }
  }
  
  public boolean czv()
  {
    return false;
  }
  
  public final void d(FinderObject paramFinderObject)
  {
    p.h(paramFinderObject, "finderObject");
    arn localarn = this.rQw;
    if (localarn != null)
    {
      i locali = i.syT;
      i.d(paramFinderObject.id, localarn.sch, paramFinderObject.sessionBuffer);
    }
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = a.sEK;
    a.w(paramInt2, paramInt3, paramString);
    paramq = a.sEK;
    a.x(paramInt2, paramInt3, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */