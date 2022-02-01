package com.tencent.mm.plugin.gamelife.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af.b;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.t.a;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.byp.c.c;
import com.tencent.mm.plugin.byp.c.e.a;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.f.g;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig;", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig;", "()V", "TAG", "", "convUpdateCallback", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "getConvUpdateCallback", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "convUpdateCallback$delegate", "Lkotlin/Lazy;", "getContactInterceptor", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getContactInterceptor$delegate", "sendMsgInterceptor", "Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig$GameLifeCreateSendMsgInterceptor;", "getSendMsgInterceptor", "()Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig$GameLifeCreateSendMsgInterceptor;", "sendMsgInterceptor$delegate", "getAvatarInterceptors", "Landroid/util/Pair;", "", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "getConversationUpdateCallback", "getICreateSendMsgInterceptor", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig$ICreateSendMsgInterceptor;", "getSyncHandler", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "name", "GameLifeCreateSendMsgInterceptor", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.byp.c.e
{
  private final j AGX;
  private final j AGY;
  private final j Jba;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(268078);
    this.TAG = "GameLifeMsgConfig";
    this.Jba = k.cm((kotlin.g.a.a)b.Jbb);
    this.AGX = k.cm((kotlin.g.a.a)d.Jbd);
    this.AGY = k.cm((kotlin.g.a.a)c.Jbc);
    AppMethodBeat.o(268078);
  }
  
  public final bx.a diu()
  {
    AppMethodBeat.i(268095);
    bx.a locala = ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).diu();
    s.s(locala, "service(IGameLifeContact…ss.java).contactExtension");
    AppMethodBeat.o(268095);
    return locala;
  }
  
  public final List<com.tencent.mm.plugin.byp.a.a> div()
  {
    AppMethodBeat.i(268099);
    List localList = kotlin.a.p.listOf(new com.tencent.mm.plugin.gamelife.h.e());
    AppMethodBeat.o(268099);
    return localList;
  }
  
  public final e.a diw()
  {
    AppMethodBeat.i(268107);
    e.a locala = (e.a)this.AGX.getValue();
    AppMethodBeat.o(268107);
    return locala;
  }
  
  public final af.b dix()
  {
    AppMethodBeat.i(268114);
    af.b localb = (af.b)this.AGY.getValue();
    AppMethodBeat.o(268114);
    return localb;
  }
  
  public final Pair<List<String>, j.a> diy()
  {
    AppMethodBeat.i(268122);
    Object localObject = kotlin.a.p.listOf(new String[] { "@gamelife", "@gamelifesess" });
    j.a locala = com.tencent.mm.pluginsdk.ui.a.b.iKa();
    if ((locala instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      localObject = new Pair(localObject, new com.tencent.mm.plugin.gamelife.g.d(((com.tencent.mm.pluginsdk.ui.b)locala).XXP));
      AppMethodBeat.o(268122);
      return localObject;
    }
    AppMethodBeat.o(268122);
    return null;
  }
  
  public final String name()
  {
    return "GameLifeMsgConfig";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig$GameLifeCreateSendMsgInterceptor;", "Lcom/tencent/mm/plugin/byp/config/BaseSendMsgInterceptors;", "()V", "checkIfYourFile", "", "params", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$SendMsgParams;", "createEmojiCgi", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$BuildResult;", "getBizType", "", "getSenderBySessionId", "", "sessionId", "getTalkerBySessionId", "support", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
  {
    public final String akk(String paramString)
    {
      AppMethodBeat.i(268082);
      s.u(paramString, "sessionId");
      paramString = ((f)h.ax(f.class)).aHz(paramString).aJK();
      s.s(paramString, "service(IGameLifeSession…ssionId(sessionId).talker");
      AppMethodBeat.o(268082);
      return paramString;
    }
    
    public final String akl(String paramString)
    {
      AppMethodBeat.i(268091);
      s.u(paramString, "sessionId");
      paramString = ((f)h.ax(f.class)).aHz(paramString).getSelfUsername();
      s.s(paramString, "service(IGameLifeSession…d(sessionId).selfUsername");
      AppMethodBeat.o(268091);
      return paramString;
    }
    
    public final boolean b(t.e parame)
    {
      AppMethodBeat.i(268102);
      s.u(parame, "params");
      if (((parame instanceof t)) && (at.bvP(((t)parame).fileName)))
      {
        AppMethodBeat.o(268102);
        return true;
      }
      AppMethodBeat.o(268102);
      return false;
    }
    
    public final int dis()
    {
      return 3;
    }
    
    public final t.a f(t.e parame)
    {
      AppMethodBeat.i(268113);
      t.a locala = new t.a();
      if ((parame instanceof com.tencent.mm.plugin.emoji.a))
      {
        String str1 = ((com.tencent.mm.plugin.emoji.a)parame).toUser;
        Object localObject = (com.tencent.mm.plugin.emoji.a)parame;
        s.s(str1, "sessionId");
        ((t.e)localObject).toUser = akk(str1);
        ((com.tencent.mm.plugin.emoji.a)parame).hQQ = akl(str1);
        localObject = ((com.tencent.mm.plugin.emoji.a)parame).hQQ;
        s.s(localObject, "params.fromUser");
        String str2 = ((com.tencent.mm.plugin.emoji.a)parame).toUser;
        s.s(str2, "params.toUser");
        EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.a)parame).mgK;
        s.s(localEmojiInfo, "params.emojiInfo");
        locala.hEi = ((com.tencent.mm.am.p)new com.tencent.mm.plugin.byp.b.b(3, str1, (String)localObject, str2, localEmojiInfo, ((com.tencent.mm.plugin.emoji.a)parame).msgId));
      }
      AppMethodBeat.o(268113);
      return locala;
    }
    
    public final boolean g(t.e parame)
    {
      AppMethodBeat.i(268072);
      s.checkNotNull(parame);
      if ((au.bwW(parame.toUser)) || (b(parame)))
      {
        AppMethodBeat.o(268072);
        return true;
      }
      AppMethodBeat.o(268072);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<g>
  {
    public static final b Jbb;
    
    static
    {
      AppMethodBeat.i(268073);
      Jbb = new b();
      AppMethodBeat.o(268073);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.e.d>
  {
    public static final c Jbc;
    
    static
    {
      AppMethodBeat.i(268079);
      Jbc = new c();
      AppMethodBeat.o(268079);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig$GameLifeCreateSendMsgInterceptor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<a.a>
  {
    public static final d Jbd;
    
    static
    {
      AppMethodBeat.i(268074);
      Jbd = new d();
      AppMethodBeat.o(268074);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.a
 * JD-Core Version:    0.7.0.1
 */