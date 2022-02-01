package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Lcom/tencent/mm/autogen/table/BaseFinderConversation;", "()V", "contact", "Lcom/tencent/mm/storage/Contact;", "getContact", "()Lcom/tencent/mm/storage/Contact;", "setContact", "(Lcom/tencent/mm/storage/Contact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "equals", "", "other", "", "getContentSpan", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "", "isTopPlace", "isTopPlaceUIStyle", "prepare", "", "Companion", "plugin-finder_release"})
public final class c
  extends cf
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a tys;
  public as contact;
  public String nickname;
  public CharSequence tyr;
  
  static
  {
    AppMethodBeat.i(242703);
    tys = new a((byte)0);
    info = cf.ajs();
    AppMethodBeat.o(242703);
  }
  
  public final boolean cZv()
  {
    return this.field_placedFlag > 0L;
  }
  
  public final boolean cZw()
  {
    AppMethodBeat.i(242702);
    if ((this.field_placedFlag > 0L) && ((p.j(this.field_sessionId, "findersayhisessionholder") ^ true)))
    {
      AppMethodBeat.o(242702);
      return true;
    }
    AppMethodBeat.o(242702);
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(242700);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(242700);
    return localMAutoDBInfo;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(242701);
    if (p.j(this.field_sessionId, "findersayhisessionholder"))
    {
      this.nickname = MMApplicationContext.getContext().getString(2131760263);
      localObject = (CharSequence)this.nickname;
      this.tyr = ((CharSequence)localObject);
      AppMethodBeat.o(242701);
      return;
    }
    Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(this.field_sessionId);
    localObject = this.contact;
    if (localObject != null) {}
    for (localObject = ((as)localObject).arJ();; localObject = null)
    {
      this.nickname = ((String)localObject);
      localObject = this.contact;
      if (localObject != null)
      {
        CharSequence localCharSequence = ((as)localObject).gBL();
        localObject = localCharSequence;
        if (localCharSequence != null) {
          break;
        }
      }
      localObject = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.nickname);
      break;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation$Companion;", "", "()V", "ACTION_DISABLE", "", "ACTION_ENABLE", "CAN_SEND_MSG", "READ_STATUS_READ", "READ_STATUS_UNREAD", "SCENE_FINDER", "SCENE_WX", "TYPE_GREET", "TYPE_HELLO_BOX", "TYPE_NORMAL", "UNABLE_SEND_MSG", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.c
 * JD-Core Version:    0.7.0.1
 */