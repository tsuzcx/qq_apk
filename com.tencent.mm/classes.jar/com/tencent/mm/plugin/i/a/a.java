package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "authIcon", "", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authJob", "", "getAuthJob", "()Ljava/lang/String;", "setAuthJob", "(Ljava/lang/String;)V", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class a
  extends f
{
  public String nickname = "";
  public String qDs = "";
  public String raP = "";
  public int raQ;
  public String username = "";
  
  public final String Su()
  {
    return this.nickname;
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168866);
    k.h(paramMap, "values");
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.username"));
    k.g(paramb, "Util.nullAsNil(values.ge…indernamecard.username\"))");
    this.username = paramb;
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.avatar"));
    k.g(paramb, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
    this.qDs = paramb;
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.nickname"));
    k.g(paramb, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
    this.nickname = paramb;
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.findernamecard.auth_job"));
    k.g(paramb, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
    this.raP = paramb;
    this.raQ = bt.aGh((String)paramMap.get(".msg.appmsg.findernamecard.auth_icon"));
    AppMethodBeat.o(168866);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(168864);
    Object localObject = new a();
    ((a)localObject).username = this.username;
    ((a)localObject).qDs = this.qDs;
    ((a)localObject).nickname = this.nickname;
    ((a)localObject).raP = this.raP;
    ((a)localObject).raQ = this.raQ;
    localObject = (f)localObject;
    AppMethodBeat.o(168864);
    return localObject;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168865);
    k.h(paramStringBuilder, "sb");
    paramStringBuilder.append("<findernamecard><username>").append(bt.aGf(this.username)).append("</username><avatar>").append(k.b.ry(this.qDs)).append("</avatar><nickname>").append(bt.aGf(this.nickname)).append("</nickname><auth_job>").append(bt.aGf(this.raP)).append("</auth_job><auth_icon>").append(this.raQ).append("</auth_icon></findernamecard>");
    AppMethodBeat.o(168865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.a
 * JD-Core Version:    0.7.0.1
 */