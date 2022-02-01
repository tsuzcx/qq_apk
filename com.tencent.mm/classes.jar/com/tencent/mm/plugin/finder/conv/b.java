package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ck;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Lcom/tencent/mm/autogen/table/BaseFinderConversation;", "()V", "contact", "Lcom/tencent/mm/storage/Contact;", "getContact", "()Lcom/tencent/mm/storage/Contact;", "setContact", "(Lcom/tencent/mm/storage/Contact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "equals", "", "other", "", "getContentSpan", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "", "isTopPlace", "isTopPlaceUIStyle", "prepare", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ck
{
  public static final a AFx;
  private static final IAutoDBItem.MAutoDBInfo info;
  public CharSequence AFy;
  au contact;
  public String nickname;
  
  static
  {
    AppMethodBeat.i(336065);
    AFx = new a((byte)0);
    info = ck.aJm();
    AppMethodBeat.o(336065);
  }
  
  public final CharSequence dWM()
  {
    AppMethodBeat.i(336109);
    Object localObject1 = MMApplicationContext.getContext();
    Object localObject2 = (CharSequence)this.field_editingMsg;
    if ((localObject2 == null) || (kotlin.n.n.bp((CharSequence)localObject2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = p.b((Context)localObject1, (CharSequence)this.field_digest);
      s.s(localObject1, "spanForSmiley(context, field_digest)");
      localObject1 = (CharSequence)localObject1;
      AppMethodBeat.o(336109);
      return localObject1;
    }
    localObject2 = new SpannableStringBuilder((CharSequence)((Context)localObject1).getString(e.h.finder_message_draf));
    ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(((Context)localObject1).getResources().getColor(e.b.red_text_color)), 0, ((SpannableStringBuilder)localObject2).length(), 33);
    ((SpannableStringBuilder)localObject2).append((CharSequence)" ").append((CharSequence)p.b((Context)localObject1, (CharSequence)this.field_editingMsg));
    localObject1 = (CharSequence)localObject2;
    AppMethodBeat.o(336109);
    return localObject1;
  }
  
  public final boolean dWN()
  {
    return this.field_placedFlag > 0L;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      bool1 = bool2;
      if (((b)paramObject).systemRowid == this.systemRowid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(336075);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(336075);
    return localMAutoDBInfo;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(336093);
    if (s.p(this.field_sessionId, "findersayhisessionholder")) {
      this.nickname = MMApplicationContext.getContext().getString(e.h.finder_message_say_hi_holder);
    }
    for (Object localObject = (CharSequence)this.nickname;; localObject = (CharSequence)this.nickname)
    {
      this.AFy = ((CharSequence)localObject);
      AppMethodBeat.o(336093);
      return;
      if (!s.p(this.field_sessionId, "finderaliassessionholder")) {
        break;
      }
      localObject = d.AwY;
      localObject = d.a.dUd().getNickname();
      this.nickname = MMApplicationContext.getContext().getString(e.h.finder_message_alias_holder, new Object[] { localObject });
    }
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.field_sessionId);
    localObject = this.contact;
    if (localObject == null)
    {
      localObject = null;
      label141:
      this.nickname = ((String)localObject);
      localObject = this.contact;
      if (localObject != null) {
        break label191;
      }
    }
    label191:
    for (CharSequence localCharSequence = null;; localCharSequence = ((au)localObject).acDG)
    {
      localObject = localCharSequence;
      if (localCharSequence != null) {
        break;
      }
      localObject = (CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)this.nickname);
      break;
      localObject = ((au)localObject).aSV();
      break label141;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversation$Companion;", "", "()V", "ACTION_DISABLE", "", "ACTION_ENABLE", "CAN_SEND_MSG", "READ_STATUS_READ", "READ_STATUS_UNREAD", "SCENE_FINDER", "SCENE_WX", "TYPE_ALIAS", "TYPE_ALIAS_BOX", "TYPE_GREET", "TYPE_HELLO_BOX", "TYPE_NORMAL", "UNABLE_SEND_MSG", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.b
 * JD-Core Version:    0.7.0.1
 */