package com.tencent.mm.plugin.findersdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/CgiFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "topic", "", "topicType", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "()Ljava/lang/String;", "getTopicType", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<bbg>
{
  public static final a HcD;
  private final bve ACr;
  private final int Auy;
  private final Long Bjx;
  private final b lastBuffer;
  private final String topic;
  
  static
  {
    AppMethodBeat.i(273913);
    HcD = new a((byte)0);
    AppMethodBeat.o(273913);
  }
  
  public a(String paramString, Long paramLong)
  {
    super(null);
    AppMethodBeat.i(273903);
    this.topic = paramString;
    this.Auy = 4;
    this.Bjx = paramLong;
    this.lastBuffer = null;
    this.ACr = null;
    paramString = new bbf();
    paramString.Auy = this.Auy;
    paramString.topic = this.topic;
    paramString.ZEQ = this.lastBuffer;
    paramLong = this.Bjx;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      paramString.Avd = this.Bjx.longValue();
    }
    paramString.ACr = this.ACr;
    paramLong = new c.a();
    paramLong.otE = ((com.tencent.mm.bx.a)paramString);
    paramLong.funcId = 817;
    paramLong.otF = ((com.tencent.mm.bx.a)new bbg());
    paramLong.uri = "/cgi-bin/micromsg-bin/findergettopiclist";
    c(paramLong.bEF());
    Log.i("Finder.CgiFinderGetTopicFeed", "NetSceneFinderGetTopicFeed get word init: " + this.topic + ", " + this.Bjx);
    AppMethodBeat.o(273903);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/CgiFinderGetTopicFeed$Companion;", "", "()V", "TAG", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a
 * JD-Core Version:    0.7.0.1
 */