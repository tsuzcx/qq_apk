package com.tencent.mm.plugin.game.chatroom.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.neattextview.textview.view.NeatTextView;

public class f
  extends g
{
  private NeatTextView CuX;
  
  public f(View paramView, int paramInt)
  {
    super(paramView, paramInt);
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(211585);
    this.CuX.aL(this.mContext.getString(f.h.Cui));
    AppMethodBeat.o(211585);
  }
  
  protected final View evF()
  {
    AppMethodBeat.i(211584);
    View localView = LayoutInflater.from(this.mContext).inflate(f.f.CtM, null);
    this.CuX = ((NeatTextView)localView.findViewById(f.e.CsO));
    AppMethodBeat.o(211584);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.f
 * JD-Core Version:    0.7.0.1
 */