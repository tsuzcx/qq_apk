package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class y
  extends f
{
  public static final a hJt;
  public String hJs = "";
  public String hwb = "";
  public String thumbUrl = "";
  
  static
  {
    AppMethodBeat.i(207737);
    hJt = new a((byte)0);
    AppMethodBeat.o(207737);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207733);
    if (paramb != null)
    {
      if ((paramb.type == 60) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.HE(this.hJs));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
        AppMethodBeat.o(207733);
      }
    }
    else
    {
      AppMethodBeat.o(207733);
      return;
    }
    AppMethodBeat.o(207733);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(207735);
    if (paramb != null)
    {
      if (paramb.type == 60)
      {
        if (paramMap == null) {
          p.hyc();
        }
        paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        p.g(paramb, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
        this.hJs = paramb;
        paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        p.g(paramb, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
        this.hwb = paramb;
        paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        p.g(paramMap, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        Log.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(207735);
      return;
    }
    AppMethodBeat.o(207735);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(207734);
    f localf = (f)new y();
    AppMethodBeat.o(207734);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207736);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.hJs + "', liveName='" + this.hwb + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(207736);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.y
 * JD-Core Version:    0.7.0.1
 */