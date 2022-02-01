package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "authIcon", "", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authJob", "", "getAuthJob", "()Ljava/lang/String;", "setAuthJob", "(Ljava/lang/String;)V", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class a
  extends f
{
  public String nickname = "";
  public String ruB = "";
  public String sjh = "";
  public int sji;
  public String username = "";
  
  public final String Tn()
  {
    return this.nickname;
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    k.h(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(bs.aLw(this.username)).append("</username><avatar>").append(k.b.vB(this.ruB)).append("</avatar><nickname>").append(bs.aLw(this.nickname)).append("</nickname><auth_job>").append(bs.aLw(this.sjh)).append("</auth_job><auth_icon>").append(this.sji).append("</auth_icon></findernamecard>");
    AppMethodBeat.o(168865);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    k.h(paramMap, "values");
    paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    k.g(paramb, "Util.nullAsNil(values.ge…indernamecard.username\"))");
    this.username = paramb;
    paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    k.g(paramb, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
    this.ruB = paramb;
    paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    k.g(paramb, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
    this.nickname = paramb;
    paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    k.g(paramb, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
    this.sjh = paramb;
    this.sji = bs.aLy((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon"));
    AppMethodBeat.o(168866);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(168864);
    Object localObject = new a();
    ((a)localObject).username = this.username;
    ((a)localObject).ruB = this.ruB;
    ((a)localObject).nickname = this.nickname;
    ((a)localObject).sjh = this.sjh;
    ((a)localObject).sji = this.sji;
    localObject = (f)localObject;
    AppMethodBeat.o(168864);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.a
 * JD-Core Version:    0.7.0.1
 */