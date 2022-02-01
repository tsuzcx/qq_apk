package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class w<_Resp extends cvp>
  extends com.tencent.mm.al.a<_Resp>
{
  private final String TAG;
  final aqy rIl;
  
  public w(aqy paramaqy)
  {
    AppMethodBeat.i(201095);
    this.rIl = paramaqy;
    this.TAG = "Finder.FinderCgi";
    if (cxU())
    {
      paramaqy = h.soM;
      paramaqy = this.rIl;
      if (paramaqy == null) {
        break label102;
      }
    }
    label102:
    for (int i = paramaqy.rTD;; i = 0)
    {
      h.EY(i);
      paramaqy = this.rIl;
      if (paramaqy == null) {
        break;
      }
      ad.i(this.TAG, "Create commentScene:" + paramaqy.rTD + " fromCommentScene:" + paramaqy.tcl);
      AppMethodBeat.o(201095);
      return;
    }
    AppMethodBeat.o(201095);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn)
  {
    AppMethodBeat.i(201094);
    p.h(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramn);
    param_Resp = com.tencent.mm.plugin.finder.spam.a.suA;
    com.tencent.mm.plugin.finder.spam.a.w(paramInt1, paramInt2, paramString);
    param_Resp = com.tencent.mm.plugin.finder.spam.a.suA;
    com.tencent.mm.plugin.finder.spam.a.x(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(201094);
  }
  
  public boolean cxU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */