package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPagePreview;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "wxUsername", "", "(Ljava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewRequest;", "getWxUsername", "()Ljava/lang/String;", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ac
  extends an<bea>
{
  private final String TAG;
  private final String dMW;
  private bdz tuc;
  
  public ac(String paramString)
  {
    super(null);
    AppMethodBeat.i(242294);
    this.dMW = paramString;
    this.TAG = "Finder.CgiFinderUserPagePreview";
    this.tuc = new bdz();
    paramString = this.tuc;
    Object localObject = am.tuw;
    paramString.LAI = am.a(this.ttO);
    this.tuc.dMW = this.dMW;
    paramString = new d.a();
    paramString.c((a)this.tuc);
    localObject = new bea();
    ((bea)localObject).setBaseResponse(new BaseResponse());
    ((bea)localObject).getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)localObject);
    paramString.MB("/cgi-bin/micromsg-bin/finderuserpagepreview");
    paramString.sG(6611);
    c(paramString.aXF());
    Log.i(this.TAG, "init wxUsername " + this.dMW);
    AppMethodBeat.o(242294);
  }
  
  public final b cXS()
  {
    return b.tyf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ac
 * JD-Core Version:    0.7.0.1
 */