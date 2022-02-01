package com.tencent.mm.plugin.findersdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/CgiFinderGetTopicFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "topic", "", "topicType", "", "refObjectId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/Long;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getRefObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTopic", "()Ljava/lang/String;", "getTopicType", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "finder-sdk_release"})
public final class a
  extends c<avy>
{
  public static final a Bvu;
  private final b lastBuffer;
  private final String topic;
  private final int wXA;
  private final Long xJH;
  private final biv xcZ;
  
  static
  {
    AppMethodBeat.i(208821);
    Bvu = new a((byte)0);
    AppMethodBeat.o(208821);
  }
  
  public a(String paramString, Long paramLong)
  {
    super(null);
    AppMethodBeat.i(208820);
    this.topic = paramString;
    this.wXA = 4;
    this.xJH = paramLong;
    this.lastBuffer = null;
    this.xcZ = null;
    paramString = new avx();
    paramString.wXA = this.wXA;
    paramString.topic = this.topic;
    paramString.SDI = this.lastBuffer;
    paramLong = this.xJH;
    if (paramLong != null)
    {
      ((Number)paramLong).longValue();
      paramString.wZw = this.xJH.longValue();
    }
    paramString.xcZ = this.xcZ;
    paramLong = new d.a();
    paramLong.c((com.tencent.mm.cd.a)paramString);
    paramLong.vD(817);
    paramLong.d((com.tencent.mm.cd.a)new avy());
    paramLong.TW("/cgi-bin/micromsg-bin/findergettopiclist");
    c(paramLong.bgN());
    Log.i("Finder.CgiFinderGetTopicFeed", "NetSceneFinderGetTopicFeed get word init: " + this.topic + ", " + this.xJH);
    AppMethodBeat.o(208820);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/CgiFinderGetTopicFeed$Companion;", "", "()V", "TAG", "", "finder-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a
 * JD-Core Version:    0.7.0.1
 */