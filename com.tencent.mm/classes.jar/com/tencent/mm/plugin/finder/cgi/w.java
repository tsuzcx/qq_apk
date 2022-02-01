package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class w
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  final anm contextObj;
  
  public w(anm paramanm)
  {
    this.contextObj = paramanm;
    this.TAG = "Finder.NetSceneFinderBase";
    if (csf())
    {
      paramanm = d.rxr;
      paramanm = this.contextObj;
      if (paramanm == null) {
        break label92;
      }
    }
    label92:
    for (int i = paramanm.rfR;; i = 0)
    {
      d.DU(i);
      paramanm = this.contextObj;
      if (paramanm != null) {
        ac.i(this.TAG, "Create commentScene:" + paramanm.rfR + " fromCommentScene:" + paramanm.seo);
      }
      return;
    }
  }
  
  public boolean csf()
  {
    return false;
  }
  
  public final void d(FinderObject paramFinderObject)
  {
    d.g.b.k.h(paramFinderObject, "finderObject");
    anm localanm = this.contextObj;
    if (localanm != null)
    {
      d locald = d.rxr;
      d.d(paramFinderObject.id, localanm.rfR, paramFinderObject.sessionBuffer);
    }
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = a.rBD;
    a.w(paramInt2, paramInt3, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */