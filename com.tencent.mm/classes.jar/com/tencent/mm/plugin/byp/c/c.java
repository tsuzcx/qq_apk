package com.tencent.mm.plugin.byp.c;

import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.t.a;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.plugin.byp.b.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/config/BaseSendMsgInterceptors;", "Lcom/tencent/mm/plugin/byp/config/DefaultSendMsgInterceptors;", "()V", "checkIfYourFile", "", "params", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$SendMsgParams;", "createCdnImageCgi", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$BuildResult;", "createEmojiCgi", "createTextCgi", "createVideoCgi", "getBizType", "", "getSenderBySessionId", "", "sessionId", "getTalkerBySessionId", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends d
{
  public abstract String akk(String paramString);
  
  public abstract String akl(String paramString);
  
  public abstract boolean b(t.e parame);
  
  public final t.a c(t.e parame)
  {
    t.a locala = new t.a();
    s.checkNotNull(parame);
    String str1 = parame.toUser;
    s.s(str1, "sessionId");
    String str2 = akk(str1);
    parame.hQQ = akl(str1);
    int i = dis();
    String str3 = parame.hQQ;
    s.s(str3, "params!!.fromUser");
    String str4 = parame.content;
    s.s(str4, "params!!.content");
    parame = new com.tencent.mm.plugin.byp.b.d(i, str1, str3, str2, str4, parame.msgId);
    locala.oNa = parame.hzO.field_msgId;
    locala.hEi = ((p)parame);
    return locala;
  }
  
  public final t.a d(t.e parame)
  {
    t.a locala = new t.a();
    if ((parame instanceof t))
    {
      if (((t)parame).oNj == 1) {
        return super.d(parame);
      }
      if (((t)parame).oNj == 4)
      {
        if (!b(parame)) {
          break label196;
        }
        String str1 = ((t)parame).oJJ.field_toUser;
        s.s(str1, "videoParams.cdnResult.field_toUser");
        Object localObject = akk(str1);
        ((t)parame).toUser = ((String)localObject);
        ((t)parame).hQQ = akl(str1);
        localObject = new l(((t)parame).fileName, ((t)parame).oJI, ((t)parame).oJJ, ((t)parame).oJK);
        int i = dis();
        String str2 = ((t)parame).hQQ;
        s.s(str2, "params.fromUser");
        parame = ((t)parame).toUser;
        s.s(parame, "params.toUser");
        locala.hEi = ((p)new e(i, str1, str2, parame, (l)localObject));
      }
    }
    return locala;
    label196:
    return super.d(parame);
  }
  
  public abstract int dis();
  
  public final t.a e(t.e parame)
  {
    t.a locala = new t.a();
    if ((parame instanceof com.tencent.mm.modelimage.d))
    {
      String str1 = ((com.tencent.mm.modelimage.d)parame).toUser;
      s.s(str1, "sessionId");
      String str2 = akk(str1);
      ((com.tencent.mm.modelimage.d)parame).hQQ = akl(str1);
      int i = dis();
      String str3 = ((com.tencent.mm.modelimage.d)parame).hQQ;
      s.s(str3, "params.fromUser");
      locala.hEi = ((p)new com.tencent.mm.plugin.byp.b.c(i, str1, str3, str2, (com.tencent.mm.modelimage.d)parame));
    }
    return locala;
  }
  
  public t.a f(t.e parame)
  {
    return new t.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c.c
 * JD-Core Version:    0.7.0.1
 */