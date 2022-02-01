package com.tencent.mm.plugin.game.chatroom.h;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgNotice;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

public class b
  extends g
{
  private NeatTextView CuX;
  private j CuY;
  
  public b(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(211790);
    this.CuY = new j();
    AppMethodBeat.o(211790);
  }
  
  protected final void a(final ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(211793);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_notice == null) || (paramChatroomMsgPack.msg_content.chatroom_notice.chatroom_msg_tpl == null))
    {
      AppMethodBeat.o(211793);
      return;
    }
    LinkedList localLinkedList = paramChatroomMsgPack.msg_content.chatroom_notice.chatroom_msg_tpl.tpl_block_list;
    this.CuY.a(this.mContext, localLinkedList, e.aIP(this.iZU), new i()
    {
      public final void NM(long paramAnonymousLong)
      {
        AppMethodBeat.i(212091);
        d.a locala = d.jTj;
        d.a.a(1L, paramAnonymousLong, b.this.Cuy, b.this.Cuz, paramChatroomMsgPack.seq, paramChatroomMsgPack.from_username);
        AppMethodBeat.o(212091);
      }
      
      public final void b(SpannableStringBuilder paramAnonymousSpannableStringBuilder)
      {
        AppMethodBeat.i(212089);
        b.a(b.this).aL(paramAnonymousSpannableStringBuilder);
        AppMethodBeat.o(212089);
      }
    });
    AppMethodBeat.o(211793);
  }
  
  protected final View evF()
  {
    AppMethodBeat.i(211792);
    View localView = LayoutInflater.from(this.mContext).inflate(f.f.CtK, null);
    this.CuX = ((NeatTextView)localView.findViewById(f.e.CsO));
    this.CuX.setOnTouchListener(new h(this.CuX, new o(this.CuX.getContext())));
    AppMethodBeat.o(211792);
    return localView;
  }
  
  protected final boolean evH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.b
 * JD-Core Version:    0.7.0.1
 */