package com.tencent.mm.plugin.gamelife.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.byp.c.a.a;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater;", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "()V", "convStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getConvStorage", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "convStorage$delegate", "Lkotlin/Lazy;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "sessionInfoStorage$delegate", "tempLastMsgId", "", "getTempLastMsgId", "()J", "setTempLastMsgId", "(J)V", "afterConvUpdate", "", "conversation", "insertCount", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "afterConversationUpdate", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConvUpdate", "checkMsgInfoForDigest", "msg", "dealEmojiMd5", "", "md5", "getConversation", "sessionId", "getDigest", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater$DigestData;", "getSessionInfo", "interceptDigest", "onConversationMsgEmpty", "saveConversationAndNotify", "support", "updateConversation", "conv", "sessionInfo", "lastMsgInfo", "digestData", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.byp.c.a<com.tencent.mm.plugin.gamelife.k.a, a>
{
  public static final g.a Jbx;
  private final j AFU;
  private final j Jby;
  private long Jbz;
  
  static
  {
    AppMethodBeat.i(268155);
    Jbx = new g.a((byte)0);
    AppMethodBeat.o(268155);
  }
  
  public g()
  {
    AppMethodBeat.i(268125);
    this.AFU = k.cm((kotlin.g.a.a)g.c.JbB);
    this.Jby = k.cm((kotlin.g.a.a)b.JbA);
    AppMethodBeat.o(268125);
  }
  
  private a aHE(String paramString)
  {
    AppMethodBeat.i(268138);
    s.u(paramString, "sessionId");
    paramString = fIv().aHD(paramString);
    AppMethodBeat.o(268138);
    return paramString;
  }
  
  private static final void aw(Map paramMap)
  {
    AppMethodBeat.i(268146);
    Log.i("GameLife.ConversationUpdateCallback", s.X("contact prefetch result: ", paramMap));
    AppMethodBeat.o(268146);
  }
  
  private final e fIv()
  {
    AppMethodBeat.i(268132);
    e locale = (e)this.Jby.getValue();
    AppMethodBeat.o(268132);
    return locale;
  }
  
  public final void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc) {}
  
  public final a.a aD(cc paramcc)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(268228);
    s.u(paramcc, "latestMsg");
    PString localPString = new PString();
    Object localObject1;
    if ((paramcc != null) && (paramcc.jbG()) && (paramcc.field_imgPath != null))
    {
      localObject3 = paramcc.field_imgPath;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject3).length() == 32) {
          localObject1 = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi((String)localObject3);
        }
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = "[" + localObject1 + ']';
        if (localObject1 != null) {
          break label286;
        }
        localObject1 = new PString();
        localObject2 = new PString();
        localObject3 = new PInt();
        ((n)h.ax(n.class)).bzG().aDH().a(paramcc, (PString)localObject1, (PString)localObject2, (PInt)localObject3, false);
        localObject1 = ((PString)localObject1).value;
      }
    }
    label286:
    for (;;)
    {
      localPString.value = ((String)localObject1);
      paramcc = new a.a(localPString, new PString());
      AppMethodBeat.o(268228);
      return paramcc;
      localObject1 = MMApplicationContext.getContext().getString(d.f.app_emoji);
      break;
      localObject1 = localObject3;
      if (paramcc == null) {
        break;
      }
      localObject1 = localObject3;
      if (!paramcc.fxR()) {
        break;
      }
      localObject2 = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      localObject1 = localObject3;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject3;
      if (((k.b)localObject2).type != 66) {
        break;
      }
      localObject1 = ((k.b)localObject2).title;
      break;
    }
  }
  
  public final boolean akf(String paramString)
  {
    AppMethodBeat.i(268194);
    s.u(paramString, "sessionId");
    boolean bool = au.bwW(paramString);
    AppMethodBeat.o(268194);
    return bool;
  }
  
  public final void aki(String paramString)
  {
    AppMethodBeat.i(268209);
    s.u(paramString, "sessionId");
    paramString = aHE(paramString);
    Log.i("GameLife.ConversationUpdateCallback", s.X("[onConversationMsgEmpty] ", Long.valueOf(paramString.systemRowid)));
    if (paramString.systemRowid > 0L)
    {
      paramString.field_digest = "";
      fIv().update(paramString.systemRowid, (IAutoDBItem)paramString, false);
      fIv().doNotify(paramString.field_talker, 8, paramString);
    }
    AppMethodBeat.o(268209);
  }
  
  public final void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(268179);
    Log.i("GameLife.ConversationUpdateCallback", "msgInfo = " + paramcc + ", conversation = " + parambb + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(268179);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<e>
  {
    public static final b JbA;
    
    static
    {
      AppMethodBeat.i(268108);
      JbA = new b();
      AppMethodBeat.o(268108);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.g
 * JD-Core Version:    0.7.0.1
 */