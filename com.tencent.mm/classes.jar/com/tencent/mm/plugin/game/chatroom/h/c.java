package com.tencent.mm.plugin.game.chatroom.h;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgSys;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.view.a;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

public class c
  extends g
{
  private NeatTextView CuX;
  private j CuY;
  
  public c(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(210706);
    this.CuY = new j();
    AppMethodBeat.o(210706);
  }
  
  protected final void a(final ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(210708);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_sys == null) || (paramChatroomMsgPack.msg_content.chatroom_sys.chatroom_msg_tpl == null))
    {
      AppMethodBeat.o(210708);
      return;
    }
    LinkedList localLinkedList = paramChatroomMsgPack.msg_content.chatroom_sys.chatroom_msg_tpl.tpl_block_list;
    this.CuY.a(this.mContext, localLinkedList, e.aIP(this.iZU), new i()
    {
      public final void NM(long paramAnonymousLong)
      {
        AppMethodBeat.i(211933);
        d.a locala = com.tencent.mm.game.report.d.jTj;
        d.a.a(1L, paramAnonymousLong, c.this.Cuy, c.this.Cuz, paramChatroomMsgPack.seq, paramChatroomMsgPack.from_username);
        AppMethodBeat.o(211933);
      }
      
      public final void b(SpannableStringBuilder paramAnonymousSpannableStringBuilder)
      {
        AppMethodBeat.i(211931);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        String str = paramChatroomMsgPack.msg_content.chatroom_sys.title;
        if (!Util.isNullOrNil(str))
        {
          SpannableString localSpannableString = new SpannableString(l.c(c.this.mContext, str));
          localSpannableString.setSpan(new a(str, c.this.mContext.getResources().getColor(f.b.BW_100_Alpha_0_3), c.this.mContext.getResources().getColor(f.b.BW_100_Alpha_0_8), com.tencent.mm.view.d.e(c.this.mContext, 10.0F), com.tencent.mm.view.d.e(c.this.mContext, 13.0F), com.tencent.mm.view.d.e(c.this.mContext, 6.0F), com.tencent.mm.view.d.e(c.this.mContext, 6.0F), com.tencent.mm.view.d.e(c.this.mContext, 3.0F), com.tencent.mm.view.d.e(c.this.mContext, 3.0F)), 0, str.length(), 33);
          localSpannableStringBuilder.append(localSpannableString).append("  ").append(paramAnonymousSpannableStringBuilder);
        }
        for (;;)
        {
          c.a(c.this).aL(localSpannableStringBuilder);
          AppMethodBeat.o(211931);
          return;
          localSpannableStringBuilder.append(paramAnonymousSpannableStringBuilder);
        }
      }
    });
    AppMethodBeat.o(210708);
  }
  
  protected final View evF()
  {
    AppMethodBeat.i(210707);
    View localView = LayoutInflater.from(this.mContext).inflate(f.f.CtL, null);
    this.CuX = ((NeatTextView)localView.findViewById(f.e.CsO));
    this.CuX.setOnTouchListener(new h(this.CuX, new o(this.CuX.getContext())));
    AppMethodBeat.o(210707);
    return localView;
  }
  
  protected final boolean evH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.c
 * JD-Core Version:    0.7.0.1
 */