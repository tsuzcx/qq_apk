package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class ap
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  final dzp contextObj;
  
  public ap(dzp paramdzp)
  {
    this.contextObj = paramdzp;
    this.TAG = "Finder.NetSceneFinderBase";
    if (fRR())
    {
      paramdzp = b.qFq;
      paramdzp = this.contextObj;
      if (paramdzp == null) {
        break label92;
      }
    }
    label92:
    for (int i = paramdzp.qqE;; i = 0)
    {
      b.ahp(i);
      paramdzp = this.contextObj;
      if (paramdzp != null) {
        ad.i(this.TAG, "Create commentScene:" + paramdzp.qqE + " fromCommentScene:" + paramdzp.LiL);
      }
      return;
    }
  }
  
  public boolean fRR()
  {
    return false;
  }
  
  public final void k(FinderObject paramFinderObject)
  {
    d.g.b.k.h(paramFinderObject, "finderObject");
    dzp localdzp = this.contextObj;
    if (localdzp != null)
    {
      b localb = b.qFq;
      b.j(paramFinderObject.id, localdzp.qqE, paramFinderObject.sessionBuffer);
    }
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = a.qIC;
    a.w(paramInt2, paramInt3, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */