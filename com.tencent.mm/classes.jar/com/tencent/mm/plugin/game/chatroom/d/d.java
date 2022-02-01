package com.tencent.mm.plugin.game.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/data/SimpleUserInfo;", "", "id", "", "nickName", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getId", "getNickName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final String avatar;
  public final String id;
  public final String nickName;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(275641);
    this.id = paramString1;
    this.nickName = paramString2;
    this.avatar = paramString3;
    AppMethodBeat.o(275641);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(275654);
    if (this == paramObject)
    {
      AppMethodBeat.o(275654);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(275654);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.id, paramObject.id))
    {
      AppMethodBeat.o(275654);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(275654);
      return false;
    }
    if (!s.p(this.avatar, paramObject.avatar))
    {
      AppMethodBeat.o(275654);
      return false;
    }
    AppMethodBeat.o(275654);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(275650);
    int i = this.id.hashCode();
    int j = this.nickName.hashCode();
    int k = this.avatar.hashCode();
    AppMethodBeat.o(275650);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275645);
    String str = "SimpleUserInfo(id=" + this.id + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ')';
    AppMethodBeat.o(275645);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.d.d
 * JD-Core Version:    0.7.0.1
 */