package com.tencent.mm.openim.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.openim.a.e;
import com.tencent.mm.openim.a.e.a.a;
import com.tencent.mm.openim.a.g;
import com.tencent.mm.openim.a.l;
import com.tencent.mm.openim.api.a;
import com.tencent.mm.openim.api.c.a;
import com.tencent.mm.openim.api.c.b;
import com.tencent.mm.openim.api.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenIMKefuService;", "Lcom/tencent/mm/openim/api/IOpenIMKefuService;", "()V", "canShowWhenSearch", "", "clearContact", "", "closeOpenImKfConversation", "username", "", "callback", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;", "createOpenImKfConversation", "request", "Lcom/tencent/mm/openim/api/OpenIMKefuOpContactRequest;", "fetchContact", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactRequest;", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "getCardContent", "Lcom/tencent/mm/openim/contact/OpenIMKefuContactCardContent;", "content", "getContact", "getContactSync", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "insertContact", "needUpdateContact", "contact", "Lcom/tencent/mm/storage/Contact;", "onAccountInit", "onAccountRelease", "replaceContact", "sendOpenImKfCard", "toUsername", "cardSendingUsername", "sendOpenImKfCardMsg", "cardMsgContent", "setMute", "testNameCard", "targetUsername", "from", "unSetMute", "updateOpenImKfServiceConversation", "childCvs", "Lcom/tencent/mm/storage/Conversation;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  implements com.tencent.mm.openim.api.c
{
  public static final y.a psX;
  
  static
  {
    AppMethodBeat.i(235825);
    psX = new y.a((byte)0);
    AppMethodBeat.o(235825);
  }
  
  private static boolean a(com.tencent.mm.openim.a.c paramc)
  {
    AppMethodBeat.i(235820);
    if (paramc == null)
    {
      AppMethodBeat.o(235820);
      return false;
    }
    boolean bool = l.a(paramc);
    AppMethodBeat.o(235820);
    return bool;
  }
  
  public static void cd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235823);
    if (paramString2 == null)
    {
      AppMethodBeat.o(235823);
      return;
    }
    paramString2 = URLDecoder.decode(paramString2, "UTF-8");
    t.e locale = t.OH(paramString1);
    locale.toUser = paramString1;
    locale.content = paramString2;
    paramString1 = locale.wF(67);
    paramString1.eQp = 1;
    paramString1.oNj = 5;
    paramString1 = paramString1.bKW();
    kotlin.g.b.s.s(paramString1, "get(toUsername)\n        …d(5)\n            .build()");
    paramString1.aXz();
    AppMethodBeat.o(235823);
  }
  
  public final void Ee(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235882);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; (i != 0) || (!au.bwQ(paramString)); i = 0)
    {
      AppMethodBeat.o(235882);
      return;
    }
    com.tencent.mm.openim.a.c localc = l.RS(paramString);
    if (localc == null)
    {
      localObject1 = null;
      Log.d("MicroMsg.OpenIMKefuService", "alvinluo setMute username: %s, ct.username: %s", new Object[] { paramString, localObject1 });
      if ((localc != null) && (localc.maN != 0L))
      {
        localObject1 = (CharSequence)localc.field_username;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label167;
        }
        i = 1;
        label121:
        if (i == 0) {
          break label184;
        }
      }
      if (localc != null) {
        break label172;
      }
    }
    label167:
    label172:
    for (localObject1 = localObject2;; localObject1 = Long.valueOf(localc.maN))
    {
      Log.e("MicroMsg.OpenIMKefuService", "alvinluo setMute contact invalid username: %s, contactId: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(235882);
      return;
      localObject1 = localc.field_username;
      break;
      i = 0;
      break label121;
    }
    label184:
    localc.field_type |= 0x200;
    a(localc);
    ((com.tencent.mm.openim.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.b.class)).Ee(paramString);
    AppMethodBeat.o(235882);
  }
  
  public final void Ef(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235885);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; (i != 0) || (!au.bwQ(paramString)); i = 0)
    {
      AppMethodBeat.o(235885);
      return;
    }
    com.tencent.mm.openim.a.c localc = l.RS(paramString);
    if (localc == null)
    {
      localObject1 = null;
      Log.d("MicroMsg.OpenIMKefuService", "alvinluo unSetMute username: %s, ct.username: %s", new Object[] { paramString, localObject1 });
      if ((localc != null) && (localc.maN != 0L))
      {
        localObject1 = (CharSequence)localc.field_username;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label167;
        }
        i = 1;
        label121:
        if (i == 0) {
          break label184;
        }
      }
      if (localc != null) {
        break label172;
      }
    }
    label167:
    label172:
    for (localObject1 = localObject2;; localObject1 = Long.valueOf(localc.maN))
    {
      Log.e("MicroMsg.OpenIMKefuService", "alvinluo unSetMute contact invalid username: %s, contactId: %s", new Object[] { paramString, localObject1 });
      AppMethodBeat.o(235885);
      return;
      localObject1 = localc.field_username;
      break;
      i = 0;
      break label121;
    }
    label184:
    localc.field_type &= 0xFFFFFDFF;
    a(localc);
    ((com.tencent.mm.openim.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.b.class)).Ef(paramString);
    AppMethodBeat.o(235885);
  }
  
  public final com.tencent.mm.openim.a.c RC(String paramString)
  {
    AppMethodBeat.i(235835);
    paramString = l.RS(paramString);
    AppMethodBeat.o(235835);
    return paramString;
  }
  
  public final e RD(String paramString)
  {
    AppMethodBeat.i(235855);
    paramString = g.RD(paramString);
    AppMethodBeat.o(235855);
    return paramString;
  }
  
  public final void RE(String paramString)
  {
    AppMethodBeat.i(235857);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    com.tencent.mm.openim.a.k.RE(str);
    AppMethodBeat.o(235857);
  }
  
  public final boolean V(au paramau)
  {
    AppMethodBeat.i(235842);
    if (paramau == null)
    {
      AppMethodBeat.o(235842);
      return false;
    }
    g localg = g.prW;
    boolean bool = g.V(paramau);
    AppMethodBeat.o(235842);
    return bool;
  }
  
  public final void a(i parami, c.a parama)
  {
    AppMethodBeat.i(235831);
    l.a(parami, parama);
    AppMethodBeat.o(235831);
  }
  
  public final void a(com.tencent.mm.openim.api.k paramk)
  {
    AppMethodBeat.i(235864);
    kotlin.g.b.s.u(paramk, "request");
    l.b(paramk);
    AppMethodBeat.o(235864);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(235829);
    paramString = new i(paramString);
    paramString.prl = false;
    paramString.prn = false;
    paramString.prm = true;
    l.a(paramString, parama);
    AppMethodBeat.o(235829);
  }
  
  public final void a(String paramString, c.b paramb)
  {
    AppMethodBeat.i(235869);
    l.b(paramString, paramb);
    AppMethodBeat.o(235869);
  }
  
  public final void aj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(235877);
    Log.i("MicroMsg.OpenIMKefuService", "alvinluo testNameCard %s", new Object[] { paramString });
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235877);
      return;
    }
    localObject = new cc();
    ((cc)localObject).BS(paramString);
    if (paramBoolean)
    {
      i = 0;
      ((cc)localObject).pI(i);
      if (!paramBoolean) {
        break label413;
      }
      i = 3;
      label94:
      ((cc)localObject).setStatus(i);
      ((cc)localObject).setType(67);
      ((cc)localObject).setCreateTime(br.bCJ());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<msg");
      localStringBuilder.append(" username=").append("\"" + "25984993900277866@kefu.openim" + '"');
      localStringBuilder.append(" nickname=\"测试用客服\"");
      localStringBuilder.append(" sex=\"1\"");
      localStringBuilder.append(" bigheadimgurl=").append("\"" + "https://wwcdn.weixin.qq.com/node/wework/images/avatar4.c4b5b964d6.png" + '"');
      localStringBuilder.append(" smallheadimgurl=").append("\"" + "https://wwcdn.weixin.qq.com/node/wework/images/avatar4.c4b5b964d6.png" + '"');
      localStringBuilder.append(" openimappid=\"3552365301\"");
      localStringBuilder.append(" openimdesc=\"腾讯\"");
      localStringBuilder.append(" openimdescicon=\"https://wwcdn.weixin.qq.com/node/wework/images/uncert21.png\"");
      localStringBuilder.append(" ticket=\"test_ticket\"");
      localStringBuilder.append(" />");
      ah localah = ah.aiuX;
      ((cc)localObject).setContent(localStringBuilder.toString());
      Log.i("MicroMsg.OpenIMKefuService", "alvinluo testNameCard xml: %s", new Object[] { ((fi)localObject).field_content });
      if (!paramBoolean) {
        break label418;
      }
      br.B((cc)localObject);
    }
    for (;;)
    {
      paramString = new com.tencent.mm.modelavatar.j();
      paramString.username = "25984993900277866@kefu.openim";
      paramString.jZY = 3;
      paramString.gX(true);
      paramString.osN = "https://wwcdn.weixin.qq.com/node/wework/images/avatar4.c4b5b964d6.png";
      paramString.osM = "https://wwcdn.weixin.qq.com/node/wework/images/avatar4.c4b5b964d6.png";
      paramString.eQp = -1;
      q.bFE().b(paramString);
      AppMethodBeat.o(235877);
      return;
      i = 1;
      break;
      label413:
      i = 2;
      break label94;
      label418:
      cd(paramString, ((fi)localObject).field_content);
    }
  }
  
  public final void b(i parami, final c.a parama)
  {
    AppMethodBeat.i(235839);
    l.c(parami, (c.a)new b(parami, parama));
    AppMethodBeat.o(235839);
  }
  
  public final void bRV()
  {
    AppMethodBeat.i(235844);
    l locall = l.psh;
    com.tencent.mm.kernel.h.aZW().a(4010, (com.tencent.mm.am.h)locall);
    com.tencent.mm.kernel.h.aZW().a(6849, (com.tencent.mm.am.h)locall);
    com.tencent.mm.kernel.h.aZW().a(5997, (com.tencent.mm.am.h)locall);
    AppMethodBeat.o(235844);
  }
  
  public final void bRW()
  {
    AppMethodBeat.i(235852);
    g localg = g.prW;
    g.bRW();
    AppMethodBeat.o(235852);
  }
  
  public final boolean bRX()
  {
    AppMethodBeat.i(235888);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(6, (List)new ArrayList(), "opencustomerservicemsg", 1);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      AppMethodBeat.o(235888);
      return true;
    }
    AppMethodBeat.o(235888);
    return false;
  }
  
  public final boolean ca(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235871);
    Log.i("MicroMsg.OpenIMKefuService", "alvinluo sendOpenImkfCard toUsername: %s, cardSendingUsername: %s", new Object[] { paramString1, paramString2 });
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label93;
        }
      }
    }
    label93:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label98;
      }
      AppMethodBeat.o(235871);
      return false;
      i = 0;
      break;
    }
    label98:
    localObject = e.prN;
    paramString1 = (kotlin.g.a.b)new y.c(paramString1, this);
    kotlin.g.b.s.u(paramString2, "toSendUsername");
    kotlin.g.b.s.u(paramString1, "callback");
    localObject = new i(paramString2);
    ((i)localObject).prm = false;
    PBool localPBool = new PBool();
    ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).a((i)localObject, (c.a)new e.a.a(localPBool, paramString1, "<msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", paramString2));
    boolean bool = localPBool.value;
    AppMethodBeat.o(235871);
    return bool;
  }
  
  public final void d(bb parambb)
  {
    AppMethodBeat.i(235861);
    com.tencent.mm.openim.a.k.d(parambb);
    AppMethodBeat.o(235861);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(235848);
    l locall = l.psh;
    com.tencent.mm.kernel.h.aZW().b(4010, (com.tencent.mm.am.h)locall);
    com.tencent.mm.kernel.h.aZW().b(6849, (com.tencent.mm.am.h)locall);
    com.tencent.mm.kernel.h.aZW().b(5997, (com.tencent.mm.am.h)locall);
    AppMethodBeat.o(235848);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/model/OpenIMKefuService$fetchContact$1", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "onFinish", "", "result", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "onTryFetch", "username", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c.a
  {
    b(i parami, c.a parama) {}
    
    public final void RF(String paramString)
    {
      AppMethodBeat.i(235816);
      Log.i("MicroMsg.OpenIMKefuService", "alvinluo fetchContact onTryFetch: %s", new Object[] { paramString });
      c.a locala = parama;
      if (locala != null) {
        locala.RF(paramString);
      }
      AppMethodBeat.o(235816);
    }
    
    public final void a(com.tencent.mm.openim.api.j paramj)
    {
      Object localObject2 = null;
      AppMethodBeat.i(235813);
      String str1;
      String str2;
      if (paramj == null)
      {
        localObject1 = null;
        str1 = this.pso.prk;
        str2 = this.pso.url;
        if (localObject1 != null) {
          break label92;
        }
      }
      label92:
      for (Object localObject1 = localObject2;; localObject1 = ((a)localObject1).bRU())
      {
        Log.i("MicroMsg.OpenIMKefuService", "alvinluo fetchContact username: %s, url: %s, contact: %s", new Object[] { str1, str2, localObject1 });
        localObject1 = parama;
        if (localObject1 != null) {
          ((c.a)localObject1).a(paramj);
        }
        AppMethodBeat.o(235813);
        return;
        localObject1 = paramj.prp;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.y
 * JD-Core Version:    0.7.0.1
 */