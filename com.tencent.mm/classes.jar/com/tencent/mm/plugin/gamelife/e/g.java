package com.tencent.mm.plugin.gamelife.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.plugin.gamelife.j.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConversationUpdate", "isConsumed", "", "checkMsgInfoForDigest", "msg", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "dealEmojiMd5", "", "md5", "interceptDigest", "onConversationMsgEmpty", "storage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conv", "Companion", "plugin-gamelife_release"})
public final class g
  implements i
{
  public static final g.a DhI;
  
  static
  {
    AppMethodBeat.i(204211);
    DhI = new g.a((byte)0);
    AppMethodBeat.o(204211);
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(204208);
    p.k(paramc, "notifyInfo");
    p.k(paramArrayOfBoolean, "isConsumed");
    String str = paramc.talker;
    if ((!as.bvQ(str)) || (paramca == null))
    {
      AppMethodBeat.o(204208);
      return;
    }
    e locale = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    com.tencent.mm.plugin.gamelife.j.a locala = ((PluginGameLife)h.ag(PluginGameLife.class)).getSessionInfoStorage().aKP(str);
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
      Log.e("GameLife.ConversationUpdateCallback", "getSessionInfo invalid: ".concat(String.valueOf(locala)));
      AppMethodBeat.o(204208);
      return;
      i = 0;
      break;
    }
    label171:
    a locala1;
    long l;
    if (paramca.apG() != 0L)
    {
      p.j(str, "sessionId");
      locala1 = locale.aKN(str);
      localObject1 = paramc.kvM;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ca)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((ca)localObject2).apA() != 1) && (((ca)localObject2).erk()))
          {
            localObject2 = k.b.OQ(((ca)localObject2).getContent());
            if (localObject2 != null)
            {
              localObject2 = ((k.b)localObject2).loq;
              if (localObject2 != null) {
                locala1.field_digestPrefix = ((String)((Map)localObject2).get(LocaleUtil.getApplicationLanguage()));
              }
            }
          }
        }
      }
      l = locala1.field_lastMsgID;
      if ((paramca != null) && (paramca.hzB()) && (paramca.apK() != null))
      {
        localObject1 = paramca.apK();
        if ((localObject1 != null) && (((String)localObject1).length() == 32))
        {
          localObject2 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
          p.j(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getEmojiMgr().auh((String)localObject1);
          if (Util.isNullOrNil((String)localObject1)) {
            break label796;
          }
          localObject1 = "[" + (String)localObject1 + ']';
          label422:
          if (localObject1 != null) {
            break label1082;
          }
          localObject1 = new PString();
          localObject2 = new PString();
          PInt localPInt = new PInt();
          Object localObject3 = h.ae(n.class);
          p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
          localObject3 = ((n)localObject3).bbR();
          p.j(localObject3, "MMKernel.service(IMessen…ass.java).conversationStg");
          ((bw)localObject3).abK().a(paramca, (PString)localObject1, (PString)localObject2, localPInt, false);
          localObject1 = ((PString)localObject1).value;
        }
      }
    }
    label559:
    label1082:
    for (;;)
    {
      locala1.field_digest = ((String)localObject1);
      locala1.field_updateTime = paramca.getCreateTime();
      int j = locala1.field_unReadCount;
      boolean bool;
      if (p.h(paramc.EVM, "insert"))
      {
        i = paramc.xKO;
        locala1.field_unReadCount = (i + j);
        locala1.field_lastMsgID = paramca.apG();
        locala1.field_talker = locala.field_talker;
        locala1.field_selfUserName = locala.field_selfUserName;
        if (locala1.systemRowid > 0L) {
          break label896;
        }
        bool = true;
        label611:
        if (!bool) {
          break label902;
        }
        ((b)h.ae(b.class)).a(j.listOf(new String[] { locala1.field_talker, locala1.field_selfUserName }), (b.c)g.b.DhJ);
        locale.insertNotify((IAutoDBItem)locala1, false);
        locale.doNotify("single", 2, locala1);
        Log.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] isNew=" + bool + " notifyFunc:" + paramc.EVM + " delId:" + paramc.EVP + " conLastMsgId:" + l + " sessionId=" + str + " talker=" + locala1.field_talker + ' ' + f.a(locala1));
      }
      for (;;)
      {
        paramArrayOfBoolean[0] = true;
        AppMethodBeat.o(204208);
        return;
        localObject1 = null;
        break;
        localObject1 = MMApplicationContext.getContext().getString(d.f.app_emoji);
        break label422;
        if ((paramca == null) || (!paramca.erk()))
        {
          localObject1 = null;
          break label422;
        }
        localObject1 = k.b.aG(paramca.getContent(), paramca.apL());
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
        break label422;
        i = 0;
        break label559;
        bool = false;
        break label611;
        if (p.h(paramc.EVM, "delete"))
        {
          Log.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] delete msg");
          if (paramc.EVP != l) {
            break label682;
          }
          locale.update(locala1.systemRowid, (IAutoDBItem)locala1, false);
          locale.doNotify("single", 8, locala1);
          break label682;
        }
        locale.update(locala1.systemRowid, (IAutoDBItem)locala1, false);
        locale.doNotify("single", 1, locala1);
        break label682;
        p.j(str, "sessionId");
        paramca = locale.aKN(str);
        Log.i("GameLife.ConversationUpdateCallback", "[onConversationMsgEmpty] " + paramca.systemRowid);
        if (paramca.systemRowid > 0L)
        {
          paramca.field_digest = "";
          locale.update(paramca.systemRowid, (IAutoDBItem)paramca, false);
          locale.doNotify(paramca.field_talker, 8, paramca);
        }
      }
    }
  }
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc) {}
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(204210);
    Log.i("GameLife.ConversationUpdateCallback", "msgInfo = " + paramca + ", conversation = " + paramaz + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(204210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.g
 * JD-Core Version:    0.7.0.1
 */