package com.tencent.mm.plugin.byp.c;

import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater;", "SESSION", "CONVERSATION", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "()V", "afterConvUpdate", "", "conversation", "insertCount", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "(Ljava/lang/Object;ILcom/tencent/mm/storage/MsgInfo;)V", "afterConversationUpdate", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConvUpdate", "(Ljava/lang/Object;Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;)V", "beforeConversationUpdate", "isConsumed", "", "getConversation", "sessionId", "", "(Ljava/lang/String;)Ljava/lang/Object;", "getDigest", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater$DigestData;", "getInsertCount", "getSessionInfo", "onConversationMsgEmpty", "saveConversationAndNotify", "(Ljava/lang/Object;)V", "support", "updateConversation", "oldOrEmptyConv", "sessionInfo", "lastMsgInfo", "digestData", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater$DigestData;ILcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;)Ljava/lang/Object;", "DigestData", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<SESSION, CONVERSATION>
  implements i
{
  public abstract CONVERSATION a(CONVERSATION paramCONVERSATION, SESSION paramSESSION, cc paramcc, a.a parama, int paramInt, i.c paramc);
  
  public final void a(cc paramcc, i.c paramc, boolean[] paramArrayOfBoolean)
  {
    s.u(paramc, "notifyInfo");
    s.u(paramArrayOfBoolean, "isConsumed");
    String str = paramc.talker;
    if ((str == null) || (!akf(str))) {
      return;
    }
    if (paramcc == null) {
      paramcc = null;
    }
    for (;;)
    {
      if (paramcc == null) {
        ((a)this).aki(str);
      }
      paramArrayOfBoolean[0] = true;
      return;
      if (paramcc.field_msgId != 0L)
      {
        i = 1;
        label69:
        if (i == 0) {
          break label89;
        }
      }
      for (;;)
      {
        if (paramcc != null) {
          break label94;
        }
        paramcc = null;
        break;
        i = 0;
        break label69;
        label89:
        paramcc = null;
      }
      label94:
      a.a locala = aD(paramcc);
      s.u(paramc, "notifyInfo");
      if (s.p(paramc.KRm, "insert")) {}
      for (int i = paramc.apS;; i = 0)
      {
        Object localObject = akh(str);
        a(localObject, paramc);
        paramc = a(localObject, akg(str), paramcc, locala, i, paramc);
        if (paramc != null) {
          break label174;
        }
        paramcc = null;
        break;
      }
      label174:
      eu(paramc);
      a(paramc, i, paramcc);
      paramcc = ah.aiuX;
    }
  }
  
  public void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc) {}
  
  public abstract void a(CONVERSATION paramCONVERSATION, int paramInt, cc paramcc);
  
  public abstract void a(CONVERSATION paramCONVERSATION, i.c paramc);
  
  public a.a aD(cc paramcc)
  {
    s.u(paramcc, "latestMsg");
    by localby = ((n)h.ax(n.class)).bzG();
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    PInt localPInt = new PInt();
    localby.aDH().a(paramcc, localPString1, localPString2, localPInt, false);
    return new a.a(localPString1, localPString2);
  }
  
  public abstract boolean akf(String paramString);
  
  public abstract SESSION akg(String paramString);
  
  public abstract CONVERSATION akh(String paramString);
  
  public abstract void aki(String paramString);
  
  public void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc) {}
  
  public abstract void eu(CONVERSATION paramCONVERSATION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c.a
 * JD-Core Version:    0.7.0.1
 */