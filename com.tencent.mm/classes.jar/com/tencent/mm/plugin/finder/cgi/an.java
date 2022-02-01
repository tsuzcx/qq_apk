package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class an<_Resp extends cld>
  extends com.tencent.mm.al.a<_Resp>
{
  private final String TAG;
  final dzp contextObj;
  
  public an(dzp paramdzp)
  {
    AppMethodBeat.i(197278);
    this.contextObj = paramdzp;
    this.TAG = "Finder.FinderCgi";
    if (fRR())
    {
      paramdzp = b.qFq;
      paramdzp = this.contextObj;
      if (paramdzp == null) {
        break label102;
      }
    }
    label102:
    for (int i = paramdzp.qqE;; i = 0)
    {
      b.ahp(i);
      paramdzp = this.contextObj;
      if (paramdzp == null) {
        break;
      }
      ad.i(this.TAG, "Create commentScene:" + paramdzp.qqE + " fromCommentScene:" + paramdzp.LiL);
      AppMethodBeat.o(197278);
      return;
    }
    AppMethodBeat.o(197278);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, n paramn)
  {
    AppMethodBeat.i(197277);
    k.h(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramn);
    param_Resp = com.tencent.mm.plugin.finder.spam.a.qIC;
    com.tencent.mm.plugin.finder.spam.a.w(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(197277);
  }
  
  public boolean fRR()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.an
 * JD-Core Version:    0.7.0.1
 */