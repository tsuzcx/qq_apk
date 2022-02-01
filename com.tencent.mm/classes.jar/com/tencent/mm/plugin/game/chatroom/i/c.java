package com.tencent.mm.plugin.game.chatroom.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgImgCard;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemImgCardVH;", "Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgImg", "Landroid/widget/ImageView;", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "playImg", "bindMsgData", "", "msg", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;", "fillBodyView", "parentView", "Landroid/view/ViewGroup;", "onItemClick", "v", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends k
{
  private ImageView Ili;
  private MMNeat7extView Ilj;
  private ImageView wEG;
  
  public c(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275946);
    AppMethodBeat.o(275946);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275960);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhN, null);
    View localView = paramViewGroup.findViewById(h.e.Igd);
    s.s(localView, "bodyView.findViewById(R.id.img_card_bg)");
    this.wEG = ((ImageView)localView);
    localView = paramViewGroup.findViewById(h.e.Igc);
    s.s(localView, "bodyView.findViewById(R.…age_card_video_play_icon)");
    this.Ili = ((ImageView)localView);
    localView = paramViewGroup.findViewById(h.e.Igb);
    s.s(localView, "bodyView.findViewById(R.id.image_card_desc)");
    this.Ilj = ((MMNeat7extView)localView);
    s.s(paramViewGroup, "bodyView");
    AppMethodBeat.o(275960);
    return paramViewGroup;
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    Object localObject2 = null;
    AppMethodBeat.i(275974);
    Object localObject1;
    ChatroomMsgImgCard localChatroomMsgImgCard;
    ImageView localImageView;
    if (paramChatroomMsgPack != null)
    {
      localObject1 = paramChatroomMsgPack.msg_content;
      if (localObject1 != null)
      {
        localChatroomMsgImgCard = ((MsgContent)localObject1).chatroom_img_card;
        if (localChatroomMsgImgCard != null)
        {
          e.a.a locala = new e.a.a();
          locala.IYs = false;
          com.tencent.mm.plugin.game.d.e locale = com.tencent.mm.plugin.game.d.e.fIb();
          localImageView = this.wEG;
          localObject1 = localImageView;
          if (localImageView == null)
          {
            s.bIx("bgImg");
            localObject1 = null;
          }
          locale.a((ImageView)localObject1, localChatroomMsgImgCard.pic_url, locala.fIc());
          if (!localChatroomMsgImgCard.show_video_play) {
            break label161;
          }
          localImageView = this.Ili;
          localObject1 = localImageView;
          if (localImageView == null)
          {
            s.bIx("playImg");
            localObject1 = null;
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = this.Ilj;
          if (localObject1 != null) {
            break label191;
          }
          s.bIx("descTv");
          localObject1 = localObject2;
        }
      }
    }
    label161:
    label191:
    for (;;)
    {
      ((MMNeat7extView)localObject1).aZ((CharSequence)localChatroomMsgImgCard.desc);
      super.a(paramChatroomMsgPack);
      AppMethodBeat.o(275974);
      return;
      localImageView = this.Ili;
      localObject1 = localImageView;
      if (localImageView == null)
      {
        s.bIx("playImg");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(8);
      break;
    }
  }
  
  protected final void fCM()
  {
    AppMethodBeat.i(275984);
    Object localObject = this.Ily;
    if (localObject != null)
    {
      localObject = ((ChatroomMsgPack)localObject).msg_content;
      if (localObject != null)
      {
        localObject = ((MsgContent)localObject).chatroom_img_card;
        if ((localObject != null) && (!fCS()))
        {
          switch (com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, ((ChatroomMsgImgCard)localObject).img_jump_info, 0, null))
          {
          default: 
            AppMethodBeat.o(275984);
            return;
          case 1: 
            AppMethodBeat.o(275984);
            return;
          case 2: 
            AppMethodBeat.o(275984);
            return;
          }
          AppMethodBeat.o(275984);
          return;
        }
      }
    }
    AppMethodBeat.o(275984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.c
 * JD-Core Version:    0.7.0.1
 */