package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPagePreview;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "wxUsername", "", "contactType", "", "poster_finderusername", "scene", "(Ljava/lang/String;ILjava/lang/String;I)V", "TAG", "getContactType", "()I", "getPoster_finderusername", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewRequest;", "getScene", "getWxUsername", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ad
  extends c<bla>
{
  private final String TAG;
  private final String fGe;
  private final int scene;
  private bkz xbK;
  private final int xbL;
  private final String xbM;
  
  public ad(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(286240);
    this.fGe = paramString1;
    this.xbL = paramInt1;
    this.xbM = paramString2;
    this.scene = paramInt2;
    this.TAG = "Finder.CgiFinderUserPagePreview";
    this.xbK = new bkz();
    paramString1 = this.xbK;
    paramString2 = ao.xcj;
    paramString1.SDi = ao.a(this.xbu);
    this.xbK.fGe = this.fGe;
    this.xbK.SGE = this.xbL;
    this.xbK.xbM = this.xbM;
    this.xbK.scene = this.scene;
    paramString1 = new d.a();
    paramString1.c((a)this.xbK);
    paramString2 = new bla();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderuserpagepreview");
    paramString1.vD(6611);
    c(paramString1.bgN());
    Log.i(this.TAG, "init wxUsername " + this.fGe + "， " + this.xbM);
    AppMethodBeat.o(286240);
  }
  
  public final b dnF()
  {
    return b.BvV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */