package com.tencent.mm.plugin.game.chatroom.i;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgNotice;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;

public class e
  extends k
{
  private MMNeat7extView DQt;
  private n Ilo;
  
  public e(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275926);
    this.Ilo = new n();
    AppMethodBeat.o(275926);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275937);
    if (paramViewGroup != null)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhT, paramViewGroup, false);
      this.DQt = ((MMNeat7extView)paramViewGroup.findViewById(h.e.IfN));
      this.DQt.setOnTouchListener(new l(this.DQt, new s(this.DQt.getContext())));
      AppMethodBeat.o(275937);
      return paramViewGroup;
    }
    AppMethodBeat.o(275937);
    return null;
  }
  
  protected final void a(final ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275948);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_notice == null) || (paramChatroomMsgPack.msg_content.chatroom_notice.chatroom_msg_tpl == null))
    {
      AppMethodBeat.o(275948);
      return;
    }
    LinkedList localLinkedList = paramChatroomMsgPack.msg_content.chatroom_notice.chatroom_msg_tpl.tpl_block_list;
    this.Ilo.a(this.mContext, localLinkedList, fCS(), new m()
    {
      public final void b(SpannableStringBuilder paramAnonymousSpannableStringBuilder)
      {
        AppMethodBeat.i(275888);
        e.a(e.this).aZ(paramAnonymousSpannableStringBuilder);
        AppMethodBeat.o(275888);
      }
      
      public final void rB(long paramAnonymousLong)
      {
        AppMethodBeat.i(275893);
        d.mty.a(1L, paramAnonymousLong, e.this.Ijq, e.this.Ijr, paramChatroomMsgPack.seq, paramChatroomMsgPack.from_username, e.this.IjE);
        AppMethodBeat.o(275893);
      }
    });
    AppMethodBeat.o(275948);
  }
  
  protected final boolean fCN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.e
 * JD-Core Version:    0.7.0.1
 */