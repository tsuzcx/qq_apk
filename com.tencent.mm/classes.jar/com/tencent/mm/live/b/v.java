package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class v
  extends f
{
  public static final a kwN;
  public String kie = "";
  public String kwM = "";
  public String thumbUrl = "";
  
  static
  {
    AppMethodBeat.i(196310);
    kwN = new a((byte)0);
    AppMethodBeat.o(196310);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196293);
    if (paramb != null)
    {
      if ((paramb.type == 60) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.OR(this.kwM));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
        AppMethodBeat.o(196293);
      }
    }
    else
    {
      AppMethodBeat.o(196293);
      return;
    }
    AppMethodBeat.o(196293);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(196300);
    if (paramb != null)
    {
      if (paramb.type == 60)
      {
        if (paramMap == null) {
          p.iCn();
        }
        paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        p.j(paramb, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
        this.kwM = paramb;
        paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        p.j(paramb, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
        this.kie = paramb;
        paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        p.j(paramMap, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        Log.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(196300);
      return;
    }
    AppMethodBeat.o(196300);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(196294);
    f localf = (f)new v();
    AppMethodBeat.o(196294);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196302);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.kwM + "', liveName='" + this.kie + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(196302);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.v
 * JD-Core Version:    0.7.0.1
 */