package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import d.a.j;
import d.g.b.p;
import java.util.Iterator;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConversationUpdate", "isConsumed", "", "checkMsgInfoForDigest", "msg", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "interceptDigest", "", "onConversationMsgEmpty", "storage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conv", "Companion", "plugin-gamelife_release"})
public final class f
  implements com.tencent.mm.plugin.messenger.foundation.a.g
{
  public static final a uJL;
  
  static
  {
    AppMethodBeat.i(212136);
    uJL = new a((byte)0);
    AppMethodBeat.o(212136);
  }
  
  public final void a(bv parambv, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(212134);
    p.h(paramc, "notifyInfo");
    p.h(paramArrayOfBoolean, "isConsumed");
    String str = paramc.talker;
    if ((!an.aUv(str)) || (parambv == null))
    {
      AppMethodBeat.o(212134);
      return;
    }
    d locald = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
    com.tencent.mm.plugin.gamelife.j.a locala = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getSessionInfoStorage().anJ(str);
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
      ae.e("GameLife.ConversationUpdateCallback", "getSessionInfo invalid: ".concat(String.valueOf(locala)));
      AppMethodBeat.o(212134);
      return;
      i = 0;
      break;
    }
    label171:
    a locala1;
    long l;
    if (parambv.VX() != 0L)
    {
      p.g(str, "sessionId");
      locala1 = locald.anH(str);
      localObject1 = paramc.gQn;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bv)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((bv)localObject2).VZ() != 1) && (((bv)localObject2).cVH()))
          {
            localObject2 = k.b.zb(((bv)localObject2).getContent());
            if (localObject2 != null)
            {
              localObject2 = ((k.b)localObject2).hES;
              if (localObject2 != null) {
                locala1.field_digestPrefix = ((String)((Map)localObject2).get(ad.fom()));
              }
            }
          }
        }
      }
      l = locala1.field_lastMsgID;
      if ((parambv == null) || (!parambv.cVH()))
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label954;
        }
        localObject1 = new PString();
        localObject2 = new PString();
        PInt localPInt = new PInt();
        Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
        localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).azL();
        p.g(localObject3, "MMKernel.service(IMessen…ass.java).conversationStg");
        ((br)localObject3).MV().a(parambv, (PString)localObject1, (PString)localObject2, localPInt, false);
        localObject1 = ((PString)localObject1).value;
      }
    }
    label518:
    label954:
    for (;;)
    {
      locala1.field_digest = ((String)localObject1);
      locala1.field_updateTime = parambv.getCreateTime();
      int j = locala1.field_unReadCount;
      label466:
      boolean bool;
      if (p.i(paramc.vWi, "insert"))
      {
        i = paramc.slP;
        locala1.field_unReadCount = (i + j);
        locala1.field_lastMsgID = parambv.VX();
        locala1.field_talker = locala.field_talker;
        locala1.field_selfUserName = locala.field_selfUserName;
        if (locala1.systemRowid > 0L) {
          break label768;
        }
        bool = true;
        if (!bool) {
          break label774;
        }
        ((b)com.tencent.mm.kernel.g.ab(b.class)).a(j.listOf(new String[] { locala1.field_talker, locala1.field_selfUserName }), (b.c)f.b.uJM);
        locald.insertNotify((com.tencent.mm.sdk.e.c)locala1, false);
        locald.doNotify("single", 2, locala1);
        label589:
        ae.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] isNew=" + bool + " notifyFunc:" + paramc.vWi + " delId:" + paramc.vWl + " conLastMsgId:" + l + " sessionId=" + str + " talker=" + locala1.field_talker + ' ' + e.a(locala1));
      }
      for (;;)
      {
        paramArrayOfBoolean[0] = true;
        AppMethodBeat.o(212134);
        return;
        localObject1 = k.b.aB(parambv.getContent(), parambv.Wc());
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
        break label466;
        bool = false;
        break label518;
        if (p.i(paramc.vWi, "delete"))
        {
          ae.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] delete msg");
          if (paramc.vWl != l) {
            break label589;
          }
          locald.update(locala1.systemRowid, (com.tencent.mm.sdk.e.c)locala1, false);
          locald.doNotify("single", 8, locala1);
          break label589;
        }
        locald.update(locala1.systemRowid, (com.tencent.mm.sdk.e.c)locala1, false);
        locald.doNotify("single", 1, locala1);
        break label589;
        p.g(str, "sessionId");
        parambv = locald.anH(str);
        ae.i("GameLife.ConversationUpdateCallback", "[onConversationMsgEmpty] " + parambv.systemRowid);
        if (parambv.systemRowid > 0L)
        {
          parambv.field_digest = "";
          locald.update(parambv.systemRowid, (com.tencent.mm.sdk.e.c)parambv, false);
          locald.doNotify(parambv.field_talker, 8, parambv);
        }
      }
    }
  }
  
  public final void a(bv parambv, au paramau, boolean paramBoolean, i.c paramc) {}
  
  public final void b(bv parambv, au paramau, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(212135);
    ae.i("GameLife.ConversationUpdateCallback", "msgInfo = " + parambv + ", conversation = " + paramau + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(212135);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.f
 * JD-Core Version:    0.7.0.1
 */