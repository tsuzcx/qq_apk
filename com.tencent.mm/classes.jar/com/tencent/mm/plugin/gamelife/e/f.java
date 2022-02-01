package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.bu;
import d.a.j;
import d.g.b.p;
import java.util.Iterator;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConversationUpdate", "isConsumed", "", "checkMsgInfoForDigestFlag", "msg", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "interceptDigest", "", "onConversationMsgEmpty", "storage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conv", "Companion", "plugin-gamelife_release"})
public final class f
  implements com.tencent.mm.plugin.messenger.foundation.a.g
{
  public static final a uyi;
  
  static
  {
    AppMethodBeat.i(211365);
    uyi = new a((byte)0);
    AppMethodBeat.o(211365);
  }
  
  public final void a(bu parambu, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(211363);
    p.h(paramc, "notifyInfo");
    p.h(paramArrayOfBoolean, "isConsumed");
    String str = paramc.talker;
    if ((!am.aSV(str)) || (parambu == null))
    {
      AppMethodBeat.o(211363);
      return;
    }
    d locald = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
    com.tencent.mm.plugin.gamelife.i.a locala = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getSessionInfoStorage().amI(str);
    Object localObject1 = (CharSequence)locala.field_selfUserName;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)locala.field_talker;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label165;
        }
      }
    }
    label165:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label171;
      }
      ad.e("GameLife.ConversationUpdateCallback", "getSessionInfo invalid: ".concat(String.valueOf(locala)));
      AppMethodBeat.o(211363);
      return;
      i = 0;
      break;
    }
    label171:
    a locala1;
    long l;
    if (parambu.VP() != 0L)
    {
      p.g(str, "sessionId");
      locala1 = locald.amG(str);
      localObject1 = paramc.gNE;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bu)((Iterator)localObject1).next();
          if (((localObject2 == null) || (((bu)localObject2).VR() != 1)) && (localObject2 != null) && (((bu)localObject2).getType() == 905969713)) {
            locala1.field_digestFlag |= 1L;
          }
        }
      }
      l = locala1.field_lastMsgID;
      if ((parambu == null) || (!parambu.cTc()))
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label926;
        }
        localObject1 = new PString();
        localObject2 = new PString();
        PInt localPInt = new PInt();
        Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
        localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).azv();
        p.g(localObject3, "MMKernel.service(IMessen…ass.java).conversationStg");
        ((bq)localObject3).Na().a(parambu, (PString)localObject1, (PString)localObject2, localPInt, false);
        localObject1 = ((PString)localObject1).value;
      }
    }
    label926:
    for (;;)
    {
      locala1.field_digest = ((String)localObject1);
      locala1.field_updateTime = parambu.getCreateTime();
      int j = locala1.field_unReadCount;
      label439:
      boolean bool;
      if (p.i(paramc.vKe, "insert"))
      {
        i = paramc.scY;
        locala1.field_unReadCount = (i + j);
        locala1.field_lastMsgID = parambu.VP();
        locala1.field_talker = locala.field_talker;
        locala1.field_selfUserName = locala.field_selfUserName;
        if (locala1.systemRowid > 0L) {
          break label740;
        }
        bool = true;
        label491:
        if (!bool) {
          break label746;
        }
        ((b)com.tencent.mm.kernel.g.ab(b.class)).a(j.listOf(new String[] { locala1.field_talker, locala1.field_selfUserName }), (b.c)f.b.uyj);
        locald.insertNotify((com.tencent.mm.sdk.e.c)locala1, false);
        locald.doNotify("single", 2, locala1);
        label562:
        ad.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] isNew=" + bool + " notifyFunc:" + paramc.vKe + " delId:" + paramc.vKh + " conLastMsgId:" + l + " sessionId=" + str + " talker=" + locala1.field_talker + ' ' + e.a(locala1));
      }
      for (;;)
      {
        paramArrayOfBoolean[0] = true;
        AppMethodBeat.o(211363);
        return;
        localObject1 = k.b.aA(parambu.getContent(), parambu.VU());
        if (localObject1 != null) {
          switch (((k.b)localObject1).type)
          {
          default: 
            localObject1 = null;
            break;
          case 66: 
            localObject1 = ((k.b)localObject1).title;
            break;
          }
        }
        localObject1 = null;
        break;
        i = 0;
        break label439;
        label740:
        bool = false;
        break label491;
        label746:
        if (p.i(paramc.vKe, "delete"))
        {
          ad.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] delete msg");
          if (paramc.vKh != l) {
            break label562;
          }
          locald.update(locala1.systemRowid, (com.tencent.mm.sdk.e.c)locala1, false);
          locald.doNotify("single", 8, locala1);
          break label562;
        }
        locald.update(locala1.systemRowid, (com.tencent.mm.sdk.e.c)locala1, false);
        locald.doNotify("single", 1, locala1);
        break label562;
        p.g(str, "sessionId");
        parambu = locald.amG(str);
        ad.i("GameLife.ConversationUpdateCallback", "[onConversationMsgEmpty] " + parambu.systemRowid);
        if (parambu.systemRowid > 0L)
        {
          parambu.field_digest = "";
          locald.update(parambu.systemRowid, (com.tencent.mm.sdk.e.c)parambu, false);
          locald.doNotify(parambu.field_talker, 8, parambu);
        }
      }
    }
  }
  
  public final void a(bu parambu, at paramat, boolean paramBoolean, i.c paramc) {}
  
  public final void b(bu parambu, at paramat, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(211364);
    ad.i("GameLife.ConversationUpdateCallback", "msgInfo = " + parambu + ", conversation = " + paramat + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(211364);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.f
 * JD-Core Version:    0.7.0.1
 */