package com.tencent.mm.plugin.game.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.du;
import com.tencent.mm.plugin.game.chatroom.d.d;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends du
{
  public static final IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(275679);
    nVV = du.aJm();
    AppMethodBeat.o(275679);
  }
  
  public final d fCH()
  {
    AppMethodBeat.i(275690);
    d locald = new d(this.field_userName, this.field_nickName, this.field_avatarURL);
    AppMethodBeat.o(275690);
    return locald;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.c
 * JD-Core Version:    0.7.0.1
 */