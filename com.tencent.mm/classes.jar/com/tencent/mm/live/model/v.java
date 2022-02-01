package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends f
{
  public static final v.a nam;
  public String liveId = "";
  public String mIA = "";
  public String thumbUrl = "";
  
  static
  {
    AppMethodBeat.i(246533);
    nam = new v.a((byte)0);
    AppMethodBeat.o(246533);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246539);
    if ((paramb != null) && (paramb.type == 60)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("<mmlive>");
        paramStringBuilder.append("<live_id>");
        paramStringBuilder.append(k.b.Hg(this.liveId));
        paramStringBuilder.append("</live_id>");
        paramStringBuilder.append("</mmlive>");
      }
      AppMethodBeat.o(246539);
      return;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(246550);
    if ((paramb != null) && (paramb.type == 60)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        s.checkNotNull(paramMap);
        paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.mmlive.live_id"));
        s.s(paramb, "nullAsNil(values!![\".msg.appmsg.mmlive.live_id\"])");
        this.liveId = paramb;
        paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.title"));
        s.s(paramb, "nullAsNil(values!![\".msg.appmsg.title\"])");
        this.mIA = paramb;
        paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.thumburl"));
        s.s(paramMap, "nullAsNil(values!![\".msg.appmsg.thumburl\"])");
        this.thumbUrl = paramMap;
        Log.i("MicroMsg.ShareLiveAppMsgPiece", toString());
      }
      AppMethodBeat.o(246550);
      return;
    }
  }
  
  public final f biW()
  {
    AppMethodBeat.i(246545);
    f localf = (f)new v();
    AppMethodBeat.o(246545);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246559);
    String str = "ShareLiveAppMsgPiece(liveId='" + this.liveId + "', liveName='" + this.mIA + "', thumbUrl='" + this.thumbUrl + "')";
    AppMethodBeat.o(246559);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.model.v
 * JD-Core Version:    0.7.0.1
 */