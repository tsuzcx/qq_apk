package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Lcom/tencent/mm/autogen/table/BaseFinderConversation;", "()V", "contact", "Lcom/tencent/mm/storage/Contact;", "getContact", "()Lcom/tencent/mm/storage/Contact;", "setContact", "(Lcom/tencent/mm/storage/Contact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "equals", "", "other", "", "getContentSpan", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "", "isTopPlace", "isTopPlaceUIStyle", "prepare", "", "Companion", "plugin-finder_release"})
public final class c
  extends ce
{
  private static final com.tencent.mm.sdk.e.c.a info;
  public static final a rLn;
  public am contact;
  public String nickname;
  CharSequence rLm;
  
  static
  {
    AppMethodBeat.i(201263);
    rLn = new a((byte)0);
    info = ce.Vv();
    AppMethodBeat.o(201263);
  }
  
  public final boolean cyS()
  {
    return this.field_placedFlag > 0L;
  }
  
  public final boolean cyT()
  {
    AppMethodBeat.i(201262);
    if ((this.field_placedFlag > 0L) && ((p.i(this.field_sessionId, "findersayhisessionholder") ^ true)))
    {
      AppMethodBeat.o(201262);
      return true;
    }
    AppMethodBeat.o(201262);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof c))
    {
      bool1 = bool2;
      if (((c)paramObject).systemRowid == this.systemRowid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(201260);
    com.tencent.mm.sdk.e.c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(201260);
    return locala;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(201261);
    if (p.i(this.field_sessionId, "findersayhisessionholder"))
    {
      this.nickname = aj.getContext().getString(2131766832);
      localObject = (CharSequence)this.nickname;
      this.rLm = ((CharSequence)localObject);
      AppMethodBeat.o(201261);
      return;
    }
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(this.field_sessionId);
    localObject = this.contact;
    if (localObject != null) {}
    for (localObject = ((am)localObject).adv();; localObject = null)
    {
      this.nickname = ((String)localObject);
      localObject = this.contact;
      if (localObject != null)
      {
        CharSequence localCharSequence = ((am)localObject).fqf();
        localObject = localCharSequence;
        if (localCharSequence != null) {
          break;
        }
      }
      localObject = (CharSequence)k.c(aj.getContext(), (CharSequence)this.nickname);
      break;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation$Companion;", "", "()V", "ACTION_DISABLE", "", "ACTION_ENABLE", "CAN_SEND_MSG", "READ_STATUS_READ", "READ_STATUS_UNREAD", "SCENE_FINDER", "SCENE_WX", "TYPE_GREET", "TYPE_HELLO_BOX", "TYPE_NORMAL", "UNABLE_SEND_MSG", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.c
 * JD-Core Version:    0.7.0.1
 */