package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class w<_Resp extends cwj>
  extends com.tencent.mm.ak.a<_Resp>
{
  private final String TAG;
  final arn rQw;
  
  public w(arn paramarn)
  {
    AppMethodBeat.i(201513);
    this.rQw = paramarn;
    this.TAG = "Finder.FinderCgi";
    if (czv())
    {
      paramarn = i.syT;
      paramarn = this.rQw;
      if (paramarn == null) {
        break label102;
      }
    }
    label102:
    for (int i = paramarn.sch;; i = 0)
    {
      i.Fu(i);
      paramarn = this.rQw;
      if (paramarn == null) {
        break;
      }
      ae.i(this.TAG, "Create commentScene:" + paramarn.sch + " fromCommentScene:" + paramarn.tnf);
      AppMethodBeat.o(201513);
      return;
    }
    AppMethodBeat.o(201513);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn)
  {
    AppMethodBeat.i(201512);
    p.h(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramn);
    param_Resp = com.tencent.mm.plugin.finder.spam.a.sEK;
    com.tencent.mm.plugin.finder.spam.a.w(paramInt1, paramInt2, paramString);
    param_Resp = com.tencent.mm.plugin.finder.spam.a.sEK;
    com.tencent.mm.plugin.finder.spam.a.x(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(201512);
  }
  
  public boolean czv()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */