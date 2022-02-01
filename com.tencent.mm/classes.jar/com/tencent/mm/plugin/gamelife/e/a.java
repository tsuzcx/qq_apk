package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.de;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "Lcom/tencent/mm/autogen/table/BaseGameLifeConversation;", "()V", "contact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "getContact", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "setContact", "(Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "bindContact", "", "equals", "", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDigestSpan", "getReportSessionType", "", "hashCode", "", "isHistory", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends de
{
  public static final a.a DhB;
  private static final IAutoDBItem.MAutoDBInfo info;
  public com.tencent.mm.plugin.gamelife.d.a DhA;
  String nickname;
  public CharSequence xgc;
  
  static
  {
    AppMethodBeat.i(203391);
    DhB = new a.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = de.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(GameLifeConversation::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(203391);
  }
  
  public final long eAr()
  {
    AppMethodBeat.i(203377);
    if (eAs())
    {
      AppMethodBeat.o(203377);
      return 103L;
    }
    AppMethodBeat.o(203377);
    return 101L;
  }
  
  public final boolean eAs()
  {
    AppMethodBeat.i(203379);
    boolean bool = p.h(this.field_sessionId, "@gamelifehistory");
    AppMethodBeat.o(203379);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203383);
    if ((a)this == paramObject)
    {
      AppMethodBeat.o(203383);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.h(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(203383);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.conversation.GameLifeConversation");
      AppMethodBeat.o(203383);
      throw paramObject;
    }
    if ((p.h(this.field_sessionId, ((a)paramObject).field_sessionId) ^ true))
    {
      AppMethodBeat.o(203383);
      return false;
    }
    AppMethodBeat.o(203383);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203386);
    String str = this.field_sessionId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(203386);
      return i;
    }
    AppMethodBeat.o(203386);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203389);
    String str = "GameLifeConversation(talker:" + this.field_talker + " sessionId:" + this.field_sessionId + " self:" + this.field_selfUserName + " nickname:" + this.nickname + ')';
    AppMethodBeat.o(203389);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.a
 * JD-Core Version:    0.7.0.1
 */