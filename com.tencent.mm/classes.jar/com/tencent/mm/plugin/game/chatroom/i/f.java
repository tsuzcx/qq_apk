package com.tencent.mm.plugin.game.chatroom.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgShareLink;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemShareLink;", "Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "rightImg", "Landroid/widget/ImageView;", "titleTv", "bindMsgData", "", "msg", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;", "fillBodyView", "parentView", "Landroid/view/ViewGroup;", "onItemClick", "v", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends k
{
  private MMNeat7extView Ilj;
  private MMNeat7extView Ilr;
  private ImageView ycj;
  
  public f(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275925);
    AppMethodBeat.o(275925);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275929);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhU, null);
    View localView = paramViewGroup.findViewById(h.e.IgX);
    s.s(localView, "bodyView.findViewById(R.id.share_link_right_pic)");
    this.ycj = ((ImageView)localView);
    localView = paramViewGroup.findViewById(h.e.IgY);
    s.s(localView, "bodyView.findViewById(R.id.share_link_title)");
    this.Ilr = ((MMNeat7extView)localView);
    localView = paramViewGroup.findViewById(h.e.IgW);
    s.s(localView, "bodyView.findViewById(R.id.share_link_desc)");
    this.Ilj = ((MMNeat7extView)localView);
    s.s(paramViewGroup, "bodyView");
    AppMethodBeat.o(275929);
    return paramViewGroup;
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    Object localObject2 = null;
    AppMethodBeat.i(275942);
    Object localObject1;
    ChatroomMsgShareLink localChatroomMsgShareLink;
    ImageView localImageView;
    if (paramChatroomMsgPack != null)
    {
      localObject1 = paramChatroomMsgPack.msg_content;
      if (localObject1 != null)
      {
        localChatroomMsgShareLink = ((MsgContent)localObject1).chatroom_share_link;
        if (localChatroomMsgShareLink != null)
        {
          if (!Util.isNullOrNil(localChatroomMsgShareLink.pic_url)) {
            break label193;
          }
          localImageView = this.ycj;
          localObject1 = localImageView;
          if (localImageView == null)
          {
            s.bIx("rightImg");
            localObject1 = null;
          }
          ((ImageView)localObject1).setVisibility(8);
          e.a.a locala = new e.a.a();
          locala.IYs = false;
          com.tencent.mm.plugin.game.d.e locale = com.tencent.mm.plugin.game.d.e.fIb();
          localImageView = this.ycj;
          localObject1 = localImageView;
          if (localImageView == null)
          {
            s.bIx("rightImg");
            localObject1 = null;
          }
          locale.a((ImageView)localObject1, localChatroomMsgShareLink.pic_url, locala.fIc());
          localObject1 = this.Ilr;
          if (localObject1 != null) {
            break label222;
          }
          s.bIx("titleTv");
          localObject1 = null;
          label142:
          ((MMNeat7extView)localObject1).aZ((CharSequence)localChatroomMsgShareLink.title);
          localObject1 = this.Ilj;
          if (localObject1 != null) {
            break label225;
          }
          s.bIx("descTv");
          localObject1 = localObject2;
        }
      }
    }
    label193:
    label222:
    label225:
    for (;;)
    {
      ((MMNeat7extView)localObject1).aZ((CharSequence)localChatroomMsgShareLink.desc);
      super.a(paramChatroomMsgPack);
      AppMethodBeat.o(275942);
      return;
      localImageView = this.ycj;
      localObject1 = localImageView;
      if (localImageView == null)
      {
        s.bIx("rightImg");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(0);
      break;
      break label142;
    }
  }
  
  protected final void fCM()
  {
    AppMethodBeat.i(275950);
    Object localObject = this.Ily;
    if (localObject != null)
    {
      localObject = ((ChatroomMsgPack)localObject).msg_content;
      if (localObject != null)
      {
        localObject = ((MsgContent)localObject).chatroom_share_link;
        if ((localObject != null) && (!fCS()))
        {
          switch (com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, ((ChatroomMsgShareLink)localObject).jump_info, 0, null))
          {
          default: 
            AppMethodBeat.o(275950);
            return;
          case 1: 
            AppMethodBeat.o(275950);
            return;
          case 2: 
            AppMethodBeat.o(275950);
            return;
          }
          AppMethodBeat.o(275950);
          return;
        }
      }
    }
    AppMethodBeat.o(275950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.f
 * JD-Core Version:    0.7.0.1
 */