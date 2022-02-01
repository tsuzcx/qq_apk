package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "authIcon", "", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authIconUrl", "", "getAuthIconUrl", "()Ljava/lang/String;", "setAuthIconUrl", "(Ljava/lang/String;)V", "authJob", "getAuthJob", "setAuthJob", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class a
  extends f
{
  public String authIconUrl = "";
  public String nickname = "";
  public String sjU = "";
  public String tfJ = "";
  public int tfK;
  public String username = "";
  
  public final String VC()
  {
    return this.nickname;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    p.h(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(bt.aRc(this.username)).append("</username><avatar>").append(k.b.ys(this.sjU)).append("</avatar><nickname>").append(bt.aRc(this.nickname)).append("</nickname><auth_job>").append(bt.aRc(this.tfJ)).append("</auth_job><auth_icon>").append(this.tfK).append("</auth_icon><auth_icon_url>").append(bt.aRc(this.authIconUrl)).append("</auth_icon_url></findernamecard>");
    AppMethodBeat.o(168865);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    p.h(paramMap, "values");
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.username\"))");
    this.username = paramb;
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    p.g(paramb, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
    this.sjU = paramb;
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
    this.nickname = paramb;
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    p.g(paramb, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
    this.tfJ = paramb;
    this.tfK = bt.aRe((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon"));
    paramMap = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon_url"));
    p.g(paramMap, "Util.nullAsNil(values.ge…namecard.auth_icon_url\"))");
    this.authIconUrl = paramMap;
    AppMethodBeat.o(168866);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(168864);
    Object localObject = new a();
    ((a)localObject).username = this.username;
    ((a)localObject).sjU = this.sjU;
    ((a)localObject).nickname = this.nickname;
    ((a)localObject).tfJ = this.tfJ;
    ((a)localObject).tfK = this.tfK;
    ((a)localObject).authIconUrl = this.authIconUrl;
    localObject = (f)localObject;
    AppMethodBeat.o(168864);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.a
 * JD-Core Version:    0.7.0.1
 */