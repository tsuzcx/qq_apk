package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.do;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "Lcom/tencent/mm/autogen/table/BaseGameLifeConversation;", "()V", "contact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "getContact", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "setContact", "(Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "bindContact", "", "equals", "", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDigestSpan", "getReportSessionType", "", "hashCode", "", "isHistory", "toString", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends do
{
  public static final a.a Jbr;
  private static final IAutoDBItem.MAutoDBInfo info;
  public CharSequence AFy;
  public com.tencent.mm.plugin.gamelife.e.a Jbs;
  String nickname;
  
  static
  {
    AppMethodBeat.i(268150);
    Jbr = new a.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = do.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(GameLifeConversation::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(268150);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(268186);
    if (this == paramObject)
    {
      AppMethodBeat.o(268186);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(268186);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.conversation.GameLifeConversation");
      AppMethodBeat.o(268186);
      throw paramObject;
    }
    if (!s.p(this.field_sessionId, ((a)paramObject).field_sessionId))
    {
      AppMethodBeat.o(268186);
      return false;
    }
    AppMethodBeat.o(268186);
    return true;
  }
  
  public final long fIr()
  {
    AppMethodBeat.i(268159);
    if (fIs())
    {
      AppMethodBeat.o(268159);
      return 103L;
    }
    AppMethodBeat.o(268159);
    return 101L;
  }
  
  public final boolean fIs()
  {
    AppMethodBeat.i(268169);
    boolean bool = s.p(this.field_sessionId, "@gamelifehistory");
    AppMethodBeat.o(268169);
    return bool;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(268197);
    String str = this.field_sessionId;
    if (str == null)
    {
      AppMethodBeat.o(268197);
      return 0;
    }
    int i = str.hashCode();
    AppMethodBeat.o(268197);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268210);
    String str = "GameLifeConversation(talker:" + this.field_talker + " sessionId:" + this.field_sessionId + " self:" + this.field_selfUserName + " nickname:" + this.nickname + ')';
    AppMethodBeat.o(268210);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.a
 * JD-Core Version:    0.7.0.1
 */