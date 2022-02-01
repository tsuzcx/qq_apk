package com.tencent.mm.plugin.gamelife.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.j.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "afterConversationUpdate", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConversationUpdate", "isConsumed", "", "checkMsgInfoForDigest", "msg", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "dealEmojiMd5", "", "md5", "interceptDigest", "onConversationMsgEmpty", "storage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conv", "Companion", "plugin-gamelife_release"})
public final class g
  implements com.tencent.mm.plugin.messenger.foundation.a.g
{
  public static final g.a ycc;
  
  static
  {
    AppMethodBeat.i(241379);
    ycc = new g.a((byte)0);
    AppMethodBeat.o(241379);
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(241377);
    p.h(paramc, "notifyInfo");
    p.h(paramArrayOfBoolean, "isConsumed");
    String str = paramc.talker;
    if ((!as.bju(str)) || (paramca == null))
    {
      AppMethodBeat.o(241377);
      return;
    }
    e locale = ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage();
    com.tencent.mm.plugin.gamelife.j.a locala = ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getSessionInfoStorage().aBc(str);
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
      AppMethodBeat.o(241377);
      return;
      i = 0;
      break;
    }
    label171:
    a locala1;
    long l;
    if (paramca.ajL() != 0L)
    {
      p.g(str, "sessionId");
      locala1 = locale.aBa(str);
      localObject1 = paramc.hIs;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ca)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((ca)localObject2).ajN() != 1) && (((ca)localObject2).dOQ()))
          {
            localObject2 = k.b.HD(((ca)localObject2).getContent());
            if (localObject2 != null)
            {
              localObject2 = ((k.b)localObject2).iyY;
              if (localObject2 != null) {
                locala1.field_digestPrefix = ((String)((Map)localObject2).get(LocaleUtil.getApplicationLanguage()));
              }
            }
          }
        }
      }
      l = locala1.field_lastMsgID;
      if ((paramca != null) && (paramca.gDn()) && (paramca.ajP() != null))
      {
        localObject1 = paramca.ajP();
        if ((localObject1 != null) && (((String)localObject1).length() == 32))
        {
          localObject2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getEmojiMgr().amp((String)localObject1);
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
          Object localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).aST();
          p.g(localObject3, "MMKernel.service(IMessen…ass.java).conversationStg");
          ((bw)localObject3).Xh().a(paramca, (PString)localObject1, (PString)localObject2, localPInt, false);
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
      if (p.j(paramc.zqn, "insert"))
      {
        i = paramc.tYD;
        locala1.field_unReadCount = (i + j);
        locala1.field_lastMsgID = paramca.ajL();
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
        ((b)com.tencent.mm.kernel.g.af(b.class)).a(j.listOf(new String[] { locala1.field_talker, locala1.field_selfUserName }), (b.c)g.b.ycd);
        locale.insertNotify((IAutoDBItem)locala1, false);
        locale.doNotify("single", 2, locala1);
        Log.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] isNew=" + bool + " notifyFunc:" + paramc.zqn + " delId:" + paramc.zqq + " conLastMsgId:" + l + " sessionId=" + str + " talker=" + locala1.field_talker + ' ' + f.a(locala1));
      }
      for (;;)
      {
        paramArrayOfBoolean[0] = true;
        AppMethodBeat.o(241377);
        return;
        localObject1 = null;
        break;
        localObject1 = MMApplicationContext.getContext().getString(2131755793);
        break label422;
        if ((paramca == null) || (!paramca.dOQ()))
        {
          localObject1 = null;
          break label422;
        }
        localObject1 = k.b.aD(paramca.getContent(), paramca.ajQ());
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
        if (p.j(paramc.zqn, "delete"))
        {
          Log.i("GameLife.ConversationUpdateCallback", "[updateGameLifeConversation] delete msg");
          if (paramc.zqq != l) {
            break label682;
          }
          locale.update(locala1.systemRowid, (IAutoDBItem)locala1, false);
          locale.doNotify("single", 8, locala1);
          break label682;
        }
        locale.update(locala1.systemRowid, (IAutoDBItem)locala1, false);
        locale.doNotify("single", 1, locala1);
        break label682;
        p.g(str, "sessionId");
        paramca = locale.aBa(str);
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
    AppMethodBeat.i(241378);
    Log.i("GameLife.ConversationUpdateCallback", "msgInfo = " + paramca + ", conversation = " + paramaz + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(241378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.g
 * JD-Core Version:    0.7.0.1
 */