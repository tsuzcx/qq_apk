package com.tencent.mm.plugin.game.chatroom.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.g;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.neattextview.textview.view.NeatTextView;

public class d
  extends g
{
  private NeatTextView CuX;
  
  public d(View paramView, int paramInt)
  {
    super(paramView, paramInt);
  }
  
  protected final void Tr(int paramInt)
  {
    AppMethodBeat.i(211017);
    if (paramInt == 1001)
    {
      ClipboardHelper.setText(this.CuX.ikC());
      h.cN(this.mContext, this.mContext.getString(f.h.app_copy_ok));
    }
    AppMethodBeat.o(211017);
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(211013);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_text == null))
    {
      AppMethodBeat.o(211013);
      return;
    }
    this.CuX.aL(l.c(this.mContext, paramChatroomMsgPack.msg_content.chatroom_text.content));
    AppMethodBeat.o(211013);
  }
  
  protected final void b(o paramo)
  {
    AppMethodBeat.i(211016);
    if (paramo.findItem(1001) == null) {
      paramo.a(1001, 0, this.mContext.getString(f.h.app_copy), f.g.icons_filled_copy, false);
    }
    AppMethodBeat.o(211016);
  }
  
  protected final View evF()
  {
    AppMethodBeat.i(211010);
    View localView = LayoutInflater.from(this.mContext).inflate(f.f.CtM, null);
    this.CuX = ((NeatTextView)localView.findViewById(f.e.CsO));
    AppMethodBeat.o(211010);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.d
 * JD-Core Version:    0.7.0.1
 */