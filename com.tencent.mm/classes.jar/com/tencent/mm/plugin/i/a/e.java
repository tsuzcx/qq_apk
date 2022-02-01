package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "value", "", "authIcon", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authIconUrl", "", "getAuthIconUrl", "()Ljava/lang/String;", "setAuthIconUrl", "(Ljava/lang/String;)V", "authJob", "getAuthJob", "setAuthJob", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "shareNameCard", "Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "getShareNameCard", "()Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "setShareNameCard", "(Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;)V", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class e
  extends f
{
  public String authIconUrl;
  public String nickname;
  public String uNR;
  public String username;
  public bci wDW;
  public String wDX;
  public int wDY;
  
  public e()
  {
    AppMethodBeat.i(208777);
    this.wDW = new bci();
    this.username = "";
    this.uNR = "";
    this.nickname = "";
    this.wDX = "";
    this.authIconUrl = "";
    AppMethodBeat.o(208777);
  }
  
  public final void ML(int paramInt)
  {
    this.wDW.wDY = paramInt;
    this.wDY = paramInt;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(Util.escapeStringForXml(this.username)).append("</username><avatar>").append(k.b.HE(this.uNR)).append("</avatar><nickname>").append(Util.escapeStringForXml(this.nickname)).append("</nickname><auth_job>").append(Util.escapeStringForXml(this.wDX)).append("</auth_job><auth_icon>").append(this.wDY).append("</auth_icon><auth_icon_url>").append(Util.escapeStringForXml(this.authIconUrl)).append("</auth_icon_url></findernamecard>");
    AppMethodBeat.o(168865);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    p.h(paramMap, "values");
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.username\"))");
    setUsername(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    p.g(paramb, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
    setAvatar(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
    setNickname(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
    axa(paramb);
    ML(Util.safeParseInt((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon")));
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon_url"));
    p.g(paramMap, "Util.nullAsNil(values.ge…namecard.auth_icon_url\"))");
    this.authIconUrl = paramMap;
    this.wDW.username = this.username;
    this.wDW.uNR = this.uNR;
    this.wDW.nickname = this.nickname;
    this.wDW.wDX = this.wDX;
    this.wDW.wDY = this.wDY;
    AppMethodBeat.o(168866);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(168864);
    Object localObject = new e();
    ((e)localObject).setUsername(this.username);
    ((e)localObject).setAvatar(this.uNR);
    ((e)localObject).setNickname(this.nickname);
    ((e)localObject).axa(this.wDX);
    ((e)localObject).ML(this.wDY);
    ((e)localObject).authIconUrl = this.authIconUrl;
    ((e)localObject).wDW = this.wDW;
    localObject = (f)localObject;
    AppMethodBeat.o(168864);
    return localObject;
  }
  
  public final void axa(String paramString)
  {
    AppMethodBeat.i(208775);
    p.h(paramString, "value");
    this.wDW.wDX = paramString;
    this.wDX = paramString;
    AppMethodBeat.o(208775);
  }
  
  public final void axb(String paramString)
  {
    AppMethodBeat.i(208776);
    p.h(paramString, "<set-?>");
    this.authIconUrl = paramString;
    AppMethodBeat.o(208776);
  }
  
  public final String getNickname()
  {
    return this.nickname;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(208773);
    p.h(paramString, "value");
    this.wDW.uNR = paramString;
    this.uNR = paramString;
    AppMethodBeat.o(208773);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(208774);
    p.h(paramString, "value");
    this.wDW.nickname = paramString;
    this.nickname = paramString;
    AppMethodBeat.o(208774);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(208772);
    p.h(paramString, "value");
    this.wDW.username = paramString;
    this.username = paramString;
    AppMethodBeat.o(208772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.e
 * JD-Core Version:    0.7.0.1
 */