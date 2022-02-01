package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.da;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "Lcom/tencent/mm/autogen/table/BaseGameLifeConversation;", "()V", "contact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "getContact", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "setContact", "(Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "bindContact", "", "equals", "", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDigestSpan", "getReportSessionType", "", "hashCode", "", "isHistory", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends da
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a.a ybW;
  String nickname;
  public CharSequence tyr;
  public com.tencent.mm.plugin.gamelife.d.a ybV;
  
  static
  {
    AppMethodBeat.i(241340);
    ybW = new a.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = da.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(GameLifeConversation::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(241340);
  }
  
  public final long dXi()
  {
    AppMethodBeat.i(241335);
    if (dXj())
    {
      AppMethodBeat.o(241335);
      return 103L;
    }
    AppMethodBeat.o(241335);
    return 101L;
  }
  
  public final boolean dXj()
  {
    AppMethodBeat.i(241336);
    boolean bool = p.j(this.field_sessionId, "@gamelifehistory");
    AppMethodBeat.o(241336);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(241337);
    if ((a)this == paramObject)
    {
      AppMethodBeat.o(241337);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.j(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(241337);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.conversation.GameLifeConversation");
      AppMethodBeat.o(241337);
      throw paramObject;
    }
    if ((p.j(this.field_sessionId, ((a)paramObject).field_sessionId) ^ true))
    {
      AppMethodBeat.o(241337);
      return false;
    }
    AppMethodBeat.o(241337);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(241338);
    String str = this.field_sessionId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(241338);
      return i;
    }
    AppMethodBeat.o(241338);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241339);
    String str = "GameLifeConversation(talker:" + this.field_talker + " sessionId:" + this.field_sessionId + " self:" + this.field_selfUserName + " nickname:" + this.nickname + ')';
    AppMethodBeat.o(241339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.a
 * JD-Core Version:    0.7.0.1
 */