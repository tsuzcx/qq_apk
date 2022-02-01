package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPagePreview;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "wxUsername", "", "contactType", "", "poster_finderusername", "scene", "(Ljava/lang/String;ILjava/lang/String;I)V", "TAG", "getContactType", "()I", "getPoster_finderusername", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewRequest;", "getScene", "getWxUsername", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends c<bym>
{
  private final int AAF;
  private final String AAG;
  private byl AAH;
  private final String TAG;
  private final String hLv;
  private final int scene;
  
  public at(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(336221);
    this.hLv = paramString1;
    this.AAF = paramInt1;
    this.AAG = paramString2;
    this.scene = paramInt2;
    this.TAG = "Finder.CgiFinderUserPagePreview";
    this.AAH = new byl();
    paramString1 = this.AAH;
    paramString2 = bi.ABn;
    paramString1.ZEc = bi.a(this.Auc);
    this.AAH.hLv = this.hLv;
    this.AAH.ZJt = this.AAF;
    this.AAH.AAG = this.AAG;
    this.AAH.scene = this.scene;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.AAH);
    paramString2 = new bym();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderuserpagepreview";
    paramString1.funcId = 6611;
    c(paramString1.bEF());
    Log.i(this.TAG, "init wxUsername " + this.hLv + "， " + this.AAG);
    AppMethodBeat.o(336221);
  }
  
  public final b dVi()
  {
    return b.Hdf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */