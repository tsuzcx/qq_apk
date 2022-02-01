package com.tencent.mm.plugin.game.chatroom.i;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.b.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;

public class i
  extends k
{
  private MMNeat7extView DQt;
  private n Ilo;
  
  public i(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275928);
    this.Ilo = new n();
    AppMethodBeat.o(275928);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275953);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhW, null);
    this.DQt = ((MMNeat7extView)paramViewGroup.findViewById(h.e.IfN));
    this.DQt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.l(this.DQt, new s(this.DQt.getContext()))
    {
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(275884);
        Log.i("GameChatRoom.GameChatItemTplVH", "onLongPress");
        Object localObject = jQV();
        if ((localObject != null) && ((((b)localObject).ahaT instanceof com.tencent.mm.plugin.game.chatroom.view.d)))
        {
          localObject = (com.tencent.mm.plugin.game.chatroom.view.d)((b)localObject).ahaT;
          if ((((com.tencent.mm.plugin.game.chatroom.view.d)localObject).mData instanceof l))
          {
            l locall = (l)((com.tencent.mm.plugin.game.chatroom.view.d)localObject).mData;
            if ((!Util.isNullOrNil(locall.userName)) && (locall.Imp)) {
              i.a(i.this, ((l)((com.tencent.mm.plugin.game.chatroom.view.d)localObject).mData).userName);
            }
          }
        }
        super.onLongPress(paramAnonymousMotionEvent);
        AppMethodBeat.o(275884);
      }
    });
    AppMethodBeat.o(275953);
    return paramViewGroup;
  }
  
  protected final void a(final ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275959);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_tpl == null))
    {
      AppMethodBeat.o(275959);
      return;
    }
    LinkedList localLinkedList = paramChatroomMsgPack.msg_content.chatroom_tpl.tpl_block_list;
    this.Ilo.a(this.mContext, localLinkedList, fCS(), new m()
    {
      public final void b(SpannableStringBuilder paramAnonymousSpannableStringBuilder)
      {
        AppMethodBeat.i(275905);
        i.a(i.this).aZ(paramAnonymousSpannableStringBuilder);
        AppMethodBeat.o(275905);
      }
      
      public final void rB(long paramAnonymousLong)
      {
        AppMethodBeat.i(275911);
        com.tencent.mm.game.report.d.mty.a(1L, paramAnonymousLong, i.this.Ijq, i.this.Ijr, paramChatroomMsgPack.seq, paramChatroomMsgPack.from_username, i.this.IjE);
        AppMethodBeat.o(275911);
      }
    });
    AppMethodBeat.o(275959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.i
 * JD-Core Version:    0.7.0.1
 */