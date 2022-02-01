package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "value", "", "authIcon", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authIconUrl", "", "getAuthIconUrl", "()Ljava/lang/String;", "setAuthIconUrl", "(Ljava/lang/String;)V", "authJob", "getAuthJob", "setAuthJob", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "shareNameCard", "Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "getShareNameCard", "()Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "setShareNameCard", "(Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;)V", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class e
  extends f
{
  public bjd Bvc;
  public String Bvd;
  public int Bve;
  public String authIconUrl;
  public String avatar;
  public String nickname;
  public String username;
  
  public e()
  {
    AppMethodBeat.i(208698);
    this.Bvc = new bjd();
    this.username = "";
    this.avatar = "";
    this.nickname = "";
    this.Bvd = "";
    this.authIconUrl = "";
    AppMethodBeat.o(208698);
  }
  
  public final void Sf(int paramInt)
  {
    this.Bvc.Bve = paramInt;
    this.Bve = paramInt;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    p.k(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(Util.escapeStringForXml(this.username)).append("</username><avatar>").append(k.b.OR(this.avatar)).append("</avatar><nickname>").append(Util.escapeStringForXml(this.nickname)).append("</nickname><auth_job>").append(Util.escapeStringForXml(this.Bvd)).append("</auth_job><auth_icon>").append(this.Bve).append("</auth_icon><auth_icon_url>").append(Util.escapeStringForXml(this.authIconUrl)).append("</auth_icon_url></findernamecard>");
    AppMethodBeat.o(168865);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    p.k(paramMap, "values");
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    p.j(paramb, "Util.nullAsNil(values.ge…indernamecard.username\"))");
    setUsername(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    p.j(paramb, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
    setAvatar(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    p.j(paramb, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
    setNickname(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    p.j(paramb, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
    aGL(paramb);
    Sf(Util.safeParseInt((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon")));
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon_url"));
    p.j(paramMap, "Util.nullAsNil(values.ge…namecard.auth_icon_url\"))");
    this.authIconUrl = paramMap;
    this.Bvc.username = this.username;
    this.Bvc.avatar = this.avatar;
    this.Bvc.nickname = this.nickname;
    this.Bvc.Bvd = this.Bvd;
    this.Bvc.Bve = this.Bve;
    AppMethodBeat.o(168866);
  }
  
  public final void aGL(String paramString)
  {
    AppMethodBeat.i(208694);
    p.k(paramString, "value");
    this.Bvc.Bvd = paramString;
    this.Bvd = paramString;
    AppMethodBeat.o(208694);
  }
  
  public final void aGM(String paramString)
  {
    AppMethodBeat.i(208695);
    p.k(paramString, "<set-?>");
    this.authIconUrl = paramString;
    AppMethodBeat.o(208695);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(168864);
    Object localObject = new e();
    ((e)localObject).setUsername(this.username);
    ((e)localObject).setAvatar(this.avatar);
    ((e)localObject).setNickname(this.nickname);
    ((e)localObject).aGL(this.Bvd);
    ((e)localObject).Sf(this.Bve);
    ((e)localObject).authIconUrl = this.authIconUrl;
    ((e)localObject).Bvc = this.Bvc;
    localObject = (f)localObject;
    AppMethodBeat.o(168864);
    return localObject;
  }
  
  public final String getNickname()
  {
    return this.nickname;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(208692);
    p.k(paramString, "value");
    this.Bvc.avatar = paramString;
    this.avatar = paramString;
    AppMethodBeat.o(208692);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(208693);
    p.k(paramString, "value");
    this.Bvc.nickname = paramString;
    this.nickname = paramString;
    AppMethodBeat.o(208693);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(208691);
    p.k(paramString, "value");
    this.Bvc.username = paramString;
    this.username = paramString;
    AppMethodBeat.o(208691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.e
 * JD-Core Version:    0.7.0.1
 */