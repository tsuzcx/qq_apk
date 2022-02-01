package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoGetDetail;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDetailResponse;", "videoId", "", "username", "", "videoNonceId", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getVideoId", "()J", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ak
  extends c<cwe>
{
  public static final a xce;
  public final long xcd;
  
  static
  {
    AppMethodBeat.i(287186);
    xce = new a((byte)0);
    AppMethodBeat.o(287186);
  }
  
  public ak(long paramLong, String paramString1, String paramString2, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(287185);
    this.xcd = paramLong;
    cwd localcwd = new cwd();
    as localas = as.xco;
    localcwd.TFa = as.b(parambid);
    localcwd.xcd = this.xcd;
    localcwd.username = paramString1;
    localcwd.SWw = paramString2;
    localcwd.scene = paramInt;
    paramString2 = new d.a();
    paramString2.TW("/cgi-bin/micromsg-bin/megavideodetail");
    paramString2.vD(4195);
    paramString2.c((a)localcwd);
    paramString2.d((a)new cwe());
    c(paramString2.bgN());
    Log.i("CgiMegaVideoGetDetail", "videoId " + this.xcd + " username " + paramString1);
    AppMethodBeat.o(287185);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoGetDetail$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */