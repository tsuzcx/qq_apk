package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "value", "", "authIcon", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authIconUrl", "", "getAuthIconUrl", "()Ljava/lang/String;", "setAuthIconUrl", "(Ljava/lang/String;)V", "authJob", "getAuthJob", "setAuthJob", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "shareNameCard", "Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "getShareNameCard", "()Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "setShareNameCard", "(Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;)V", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f
{
  public bvk HbW;
  public String HbX;
  public int HbY;
  public String authIconUrl;
  public String avatar;
  public String nickname;
  public String username;
  
  public e()
  {
    AppMethodBeat.i(273979);
    this.HbW = new bvk();
    this.username = "";
    this.avatar = "";
    this.nickname = "";
    this.HbX = "";
    this.authIconUrl = "";
    AppMethodBeat.o(273979);
  }
  
  public final void Vy(int paramInt)
  {
    this.HbW.HbY = paramInt;
    this.HbY = paramInt;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(Util.escapeStringForXml(this.username)).append("</username><avatar>").append(k.b.Hg(this.avatar)).append("</avatar><nickname>").append(Util.escapeStringForXml(this.nickname)).append("</nickname><auth_job>").append(Util.escapeStringForXml(this.HbX)).append("</auth_job><auth_icon>").append(this.HbY).append("</auth_icon><auth_icon_url>").append(Util.escapeStringForXml(this.authIconUrl)).append("</auth_icon_url></findernamecard>");
    AppMethodBeat.o(168865);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    s.u(paramMap, "values");
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    s.s(paramb, "nullAsNil(values.get(\".m…indernamecard.username\"))");
    setUsername(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    s.s(paramb, "nullAsNil(values.get(\".m….findernamecard.avatar\"))");
    setAvatar(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    s.s(paramb, "nullAsNil(values.get(\".m…indernamecard.nickname\"))");
    setNickname(paramb);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    s.s(paramb, "nullAsNil(values.get(\".m…indernamecard.auth_job\"))");
    aDa(paramb);
    Vy(Util.safeParseInt((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon")));
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon_url"));
    s.s(paramMap, "nullAsNil(values.get(\".m…namecard.auth_icon_url\"))");
    this.authIconUrl = paramMap;
    this.HbW.username = this.username;
    this.HbW.avatar = this.avatar;
    this.HbW.nickname = this.nickname;
    this.HbW.HbX = this.HbX;
    this.HbW.HbY = this.HbY;
    AppMethodBeat.o(168866);
  }
  
  public final void aDa(String paramString)
  {
    AppMethodBeat.i(274006);
    s.u(paramString, "value");
    this.HbW.HbX = paramString;
    this.HbX = paramString;
    AppMethodBeat.o(274006);
  }
  
  public final void aDb(String paramString)
  {
    AppMethodBeat.i(274012);
    s.u(paramString, "<set-?>");
    this.authIconUrl = paramString;
    AppMethodBeat.o(274012);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(168864);
    Object localObject = new e();
    ((e)localObject).setUsername(this.username);
    ((e)localObject).setAvatar(this.avatar);
    ((e)localObject).setNickname(this.nickname);
    ((e)localObject).aDa(this.HbX);
    ((e)localObject).Vy(this.HbY);
    ((e)localObject).authIconUrl = this.authIconUrl;
    ((e)localObject).HbW = this.HbW;
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
    AppMethodBeat.i(273990);
    s.u(paramString, "value");
    this.HbW.avatar = paramString;
    this.avatar = paramString;
    AppMethodBeat.o(273990);
  }
  
  public final void setNickname(String paramString)
  {
    AppMethodBeat.i(273998);
    s.u(paramString, "value");
    this.HbW.nickname = paramString;
    this.nickname = paramString;
    AppMethodBeat.o(273998);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(273982);
    s.u(paramString, "value");
    this.HbW.username = paramString;
    this.username = paramString;
    AppMethodBeat.o(273982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.e
 * JD-Core Version:    0.7.0.1
 */