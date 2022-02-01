package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class r<_Resp extends cqk>
  extends com.tencent.mm.ak.a<_Resp>
{
  private final String TAG;
  final anm contextObj;
  
  public r(anm paramanm)
  {
    AppMethodBeat.i(201155);
    this.contextObj = paramanm;
    this.TAG = "Finder.FinderCgi";
    if (csf())
    {
      paramanm = d.rxr;
      paramanm = this.contextObj;
      if (paramanm == null) {
        break label102;
      }
    }
    label102:
    for (int i = paramanm.rfR;; i = 0)
    {
      d.DU(i);
      paramanm = this.contextObj;
      if (paramanm == null) {
        break;
      }
      ac.i(this.TAG, "Create commentScene:" + paramanm.rfR + " fromCommentScene:" + paramanm.seo);
      AppMethodBeat.o(201155);
      return;
    }
    AppMethodBeat.o(201155);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn)
  {
    AppMethodBeat.i(201154);
    k.h(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramn);
    param_Resp = com.tencent.mm.plugin.finder.spam.a.rBD;
    com.tencent.mm.plugin.finder.spam.a.w(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(201154);
  }
  
  public boolean csf()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */