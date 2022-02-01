package com.tencent.mm.plugin.game.chatroom.i;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgSys;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;

public class g
  extends k
{
  private MMNeat7extView DQt;
  private n Ilo;
  
  public g(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275924);
    this.Ilo = new n();
    AppMethodBeat.o(275924);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275935);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhV, null);
    this.DQt = ((MMNeat7extView)paramViewGroup.findViewById(h.e.IfN));
    this.DQt.setOnTouchListener(new l(this.DQt, new s(this.DQt.getContext())));
    AppMethodBeat.o(275935);
    return paramViewGroup;
  }
  
  protected final void a(final ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275944);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_sys == null) || (paramChatroomMsgPack.msg_content.chatroom_sys.chatroom_msg_tpl == null))
    {
      AppMethodBeat.o(275944);
      return;
    }
    LinkedList localLinkedList = paramChatroomMsgPack.msg_content.chatroom_sys.chatroom_msg_tpl.tpl_block_list;
    this.Ilo.a(this.mContext, localLinkedList, fCS(), new m()
    {
      public final void b(SpannableStringBuilder paramAnonymousSpannableStringBuilder)
      {
        AppMethodBeat.i(275906);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        String str = paramChatroomMsgPack.msg_content.chatroom_sys.title;
        if (!Util.isNullOrNil(str))
        {
          SpannableString localSpannableString = new SpannableString(p.b(g.this.mContext, str));
          localSpannableString.setSpan(new com.tencent.mm.plugin.game.chatroom.view.a(str, g.this.mContext.getResources().getColor(h.b.BW_100_Alpha_0_3), g.this.mContext.getResources().getColor(h.b.BW_100_Alpha_0_8), (int)(com.tencent.mm.view.d.e(g.this.mContext, 10.0F) * com.tencent.mm.cd.a.getScaleSize(g.this.mContext)), com.tencent.mm.view.d.e(g.this.mContext, 13.0F), com.tencent.mm.view.d.e(g.this.mContext, 6.0F), com.tencent.mm.view.d.e(g.this.mContext, 6.0F), com.tencent.mm.view.d.e(g.this.mContext, 3.0F), com.tencent.mm.view.d.e(g.this.mContext, 3.0F)), 0, str.length(), 33);
          localSpannableStringBuilder.append(localSpannableString).append("  ").append(paramAnonymousSpannableStringBuilder);
        }
        for (;;)
        {
          g.a(g.this).aZ(localSpannableStringBuilder);
          AppMethodBeat.o(275906);
          return;
          localSpannableStringBuilder.append(paramAnonymousSpannableStringBuilder);
        }
      }
      
      public final void rB(long paramAnonymousLong)
      {
        AppMethodBeat.i(275919);
        com.tencent.mm.game.report.d.mty.a(1L, paramAnonymousLong, g.this.Ijq, g.this.Ijr, paramChatroomMsgPack.seq, paramChatroomMsgPack.from_username, g.this.IjE);
        AppMethodBeat.o(275919);
      }
    });
    AppMethodBeat.o(275944);
  }
  
  protected final boolean fCN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.g
 * JD-Core Version:    0.7.0.1
 */