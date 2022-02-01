package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "Lcom/tencent/mm/autogen/table/BaseGameLifeConversation;", "()V", "contact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "getContact", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "setContact", "(Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "bindContact", "", "equals", "", "other", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDigestSpan", "getReportSessionType", "", "hashCode", "", "isHistory", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends cv
{
  private static final c.a info;
  public static final a uJF;
  String nickname;
  public CharSequence rTA;
  public com.tencent.mm.plugin.gamelife.d.a uJE;
  
  static
  {
    AppMethodBeat.i(212100);
    uJF = new a((byte)0);
    c.a locala = cv.VD();
    p.g(locala, "initAutoDBInfo(GameLifeConversation::class.java)");
    info = locala;
    AppMethodBeat.o(212100);
  }
  
  public final long ddx()
  {
    AppMethodBeat.i(212095);
    if (ddy())
    {
      AppMethodBeat.o(212095);
      return 103L;
    }
    AppMethodBeat.o(212095);
    return 101L;
  }
  
  public final boolean ddy()
  {
    AppMethodBeat.i(212096);
    boolean bool = p.i(this.field_sessionId, "@gamelifehistory");
    AppMethodBeat.o(212096);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(212097);
    if ((a)this == paramObject)
    {
      AppMethodBeat.o(212097);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.i(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(212097);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.conversation.GameLifeConversation");
      AppMethodBeat.o(212097);
      throw paramObject;
    }
    if ((p.i(this.field_sessionId, ((a)paramObject).field_sessionId) ^ true))
    {
      AppMethodBeat.o(212097);
      return false;
    }
    AppMethodBeat.o(212097);
    return true;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(212098);
    String str = this.field_sessionId;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(212098);
      return i;
    }
    AppMethodBeat.o(212098);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212099);
    String str = "GameLifeConversation(talker:" + this.field_talker + " sessionId:" + this.field_sessionId + " self:" + this.field_selfUserName + " nickname:" + this.nickname + ')';
    AppMethodBeat.o(212099);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation$Companion;", "", "()V", "DIGEST_FLAG_GIFT", "", "GAME_CONVERSATION_FLAG_PLACED_TOP", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.a
 * JD-Core Version:    0.7.0.1
 */