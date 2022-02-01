package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Lcom/tencent/mm/autogen/table/BaseFinderConversation;", "()V", "contact", "Lcom/tencent/mm/storage/Contact;", "getContact", "()Lcom/tencent/mm/storage/Contact;", "setContact", "(Lcom/tencent/mm/storage/Contact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "equals", "", "other", "", "getContentSpan", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "", "isTopPlace", "isTopPlaceUIStyle", "prepare", "", "Companion", "plugin-finder_release"})
public final class d
  extends cg
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a xgd;
  public as contact;
  public String nickname;
  public CharSequence xgc;
  
  static
  {
    AppMethodBeat.i(282645);
    xgd = new a((byte)0);
    info = cg.aoY();
    AppMethodBeat.o(282645);
  }
  
  public final boolean dpl()
  {
    return this.field_placedFlag > 0L;
  }
  
  public final boolean dpm()
  {
    AppMethodBeat.i(282644);
    if ((this.field_placedFlag > 0L) && ((p.h(this.field_sessionId, "findersayhisessionholder") ^ true)) && ((p.h(this.field_sessionId, "finderaliassessionholder") ^ true)))
    {
      AppMethodBeat.o(282644);
      return true;
    }
    AppMethodBeat.o(282644);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof d))
    {
      bool1 = bool2;
      if (((d)paramObject).systemRowid == this.systemRowid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(282642);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.j(localMAutoDBInfo, "info");
    AppMethodBeat.o(282642);
    return localMAutoDBInfo;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(282643);
    if (p.h(this.field_sessionId, "findersayhisessionholder")) {
      this.nickname = MMApplicationContext.getContext().getString(b.j.finder_message_say_hi_holder);
    }
    for (Object localObject = (CharSequence)this.nickname;; localObject = (CharSequence)this.nickname)
    {
      this.xgc = ((CharSequence)localObject);
      AppMethodBeat.o(282643);
      return;
      if (!p.h(this.field_sessionId, "finderaliassessionholder")) {
        break;
      }
      localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject = com.tencent.mm.plugin.finder.api.d.a.dnj().getNickname();
      this.nickname = MMApplicationContext.getContext().getString(b.j.finder_message_alias_holder, new Object[] { localObject });
    }
    localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.contact = ((n)localObject).bbL().RG(this.field_sessionId);
    localObject = this.contact;
    if (localObject != null) {}
    for (localObject = ((as)localObject).ays();; localObject = null)
    {
      this.nickname = ((String)localObject);
      localObject = this.contact;
      if (localObject != null)
      {
        CharSequence localCharSequence = ((as)localObject).hxW();
        localObject = localCharSequence;
        if (localCharSequence != null) {
          break;
        }
      }
      localObject = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.nickname);
      break;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation$Companion;", "", "()V", "ACTION_DISABLE", "", "ACTION_ENABLE", "CAN_SEND_MSG", "READ_STATUS_READ", "READ_STATUS_UNREAD", "SCENE_FINDER", "SCENE_WX", "TYPE_ALIAS", "TYPE_ALIAS_BOX", "TYPE_GREET", "TYPE_HELLO_BOX", "TYPE_NORMAL", "UNABLE_SEND_MSG", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.d
 * JD-Core Version:    0.7.0.1
 */