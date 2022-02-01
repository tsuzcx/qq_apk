package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "authIcon", "", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authIconUrl", "", "getAuthIconUrl", "()Ljava/lang/String;", "setAuthIconUrl", "(Ljava/lang/String;)V", "authJob", "getAuthJob", "setAuthJob", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class a
  extends f
{
  public String authIconUrl = "";
  public String nickname = "";
  public String ssR = "";
  public String tqC = "";
  public int tqD;
  public String username = "";
  
  public final String VK()
  {
    return this.nickname;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(bu.aSz(this.username)).append("</username><avatar>").append(k.b.zc(this.ssR)).append("</avatar><nickname>").append(bu.aSz(this.nickname)).append("</nickname><auth_job>").append(bu.aSz(this.tqC)).append("</auth_job><auth_icon>").append(this.tqD).append("</auth_icon><auth_icon_url>").append(bu.aSz(this.authIconUrl)).append("</auth_icon_url></findernamecard>");
    AppMethodBeat.o(168865);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    p.h(paramMap, "values");
    paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.username\"))");
    this.username = paramb;
    paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    p.g(paramb, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
    this.ssR = paramb;
    paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
    this.nickname = paramb;
    paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
    this.tqC = paramb;
    this.tqD = bu.aSB((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon"));
    paramMap = bu.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon_url"));
    p.g(paramMap, "Util.nullAsNil(values.ge…namecard.auth_icon_url\"))");
    this.authIconUrl = paramMap;
    AppMethodBeat.o(168866);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(168864);
    Object localObject = new a();
    ((a)localObject).username = this.username;
    ((a)localObject).ssR = this.ssR;
    ((a)localObject).nickname = this.nickname;
    ((a)localObject).tqC = this.tqC;
    ((a)localObject).tqD = this.tqD;
    ((a)localObject).authIconUrl = this.authIconUrl;
    localObject = (f)localObject;
    AppMethodBeat.o(168864);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.a
 * JD-Core Version:    0.7.0.1
 */