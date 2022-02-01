package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoGetDetail;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDetailResponse;", "videoId", "", "username", "", "videoNonceId", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getVideoId", "()J", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
  extends c<dnj>
{
  public static final a ABf;
  public final long ABg;
  
  static
  {
    AppMethodBeat.i(336475);
    ABf = new a((byte)0);
    AppMethodBeat.o(336475);
  }
  
  public bd(long paramLong, String paramString1, String paramString2, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336463);
    this.ABg = paramLong;
    dni localdni = new dni();
    bn localbn = bn.ABz;
    localdni.aaUG = bn.b(parambui);
    localdni.ABg = this.ABg;
    localdni.username = paramString1;
    localdni.aahV = paramString2;
    localdni.scene = paramInt;
    paramString2 = new c.a();
    paramString2.uri = "/cgi-bin/micromsg-bin/megavideodetail";
    paramString2.funcId = 4195;
    paramString2.otE = ((a)localdni);
    paramString2.otF = ((a)new dnj());
    c(paramString2.bEF());
    Log.i("CgiMegaVideoGetDetail", "videoId " + this.ABg + " username " + paramString1);
    AppMethodBeat.o(336463);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoGetDetail$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bd
 * JD-Core Version:    0.7.0.1
 */