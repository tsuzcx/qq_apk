package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Lcom/tencent/mm/autogen/table/BaseFinderConversation;", "()V", "contact", "Lcom/tencent/mm/storage/Contact;", "getContact", "()Lcom/tencent/mm/storage/Contact;", "setContact", "(Lcom/tencent/mm/storage/Contact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "equals", "", "other", "", "getContentSpan", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "", "isTopPlace", "isTopPlaceUIStyle", "prepare", "", "Companion", "plugin-finder_release"})
public final class c
  extends ce
{
  private static final com.tencent.mm.sdk.e.c.a info;
  public static final a rTB;
  public an contact;
  public String nickname;
  CharSequence rTA;
  
  static
  {
    AppMethodBeat.i(201690);
    rTB = new a((byte)0);
    info = ce.VD();
    AppMethodBeat.o(201690);
  }
  
  public final boolean cAw()
  {
    return this.field_placedFlag > 0L;
  }
  
  public final boolean cAx()
  {
    AppMethodBeat.i(201689);
    if ((this.field_placedFlag > 0L) && ((p.i(this.field_sessionId, "findersayhisessionholder") ^ true)))
    {
      AppMethodBeat.o(201689);
      return true;
    }
    AppMethodBeat.o(201689);
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
    AppMethodBeat.i(201687);
    com.tencent.mm.sdk.e.c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(201687);
    return locala;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(201688);
    if (p.i(this.field_sessionId, "findersayhisessionholder"))
    {
      this.nickname = ak.getContext().getString(2131766832);
      localObject = (CharSequence)this.nickname;
      this.rTA = ((CharSequence)localObject);
      AppMethodBeat.o(201688);
      return;
    }
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(this.field_sessionId);
    localObject = this.contact;
    if (localObject != null) {}
    for (localObject = ((an)localObject).adG();; localObject = null)
    {
      this.nickname = ((String)localObject);
      localObject = this.contact;
      if (localObject != null)
      {
        CharSequence localCharSequence = ((an)localObject).fuf();
        localObject = localCharSequence;
        if (localCharSequence != null) {
          break;
        }
      }
      localObject = (CharSequence)k.c(ak.getContext(), (CharSequence)this.nickname);
      break;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation$Companion;", "", "()V", "ACTION_DISABLE", "", "ACTION_ENABLE", "CAN_SEND_MSG", "READ_STATUS_READ", "READ_STATUS_UNREAD", "SCENE_FINDER", "SCENE_WX", "TYPE_GREET", "TYPE_HELLO_BOX", "TYPE_NORMAL", "UNABLE_SEND_MSG", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.c
 * JD-Core Version:    0.7.0.1
 */