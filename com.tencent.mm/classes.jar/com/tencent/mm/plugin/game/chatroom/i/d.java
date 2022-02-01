package com.tencent.mm.plugin.game.chatroom.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgImgLink;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemMsgImgLinkVH;", "Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "landscapeImg", "Landroid/widget/ImageView;", "maskView", "playIcon", "portraitImg", "videoTime", "Landroid/widget/TextView;", "bindMsgData", "", "msg", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;", "fillBodyView", "parentView", "Landroid/view/ViewGroup;", "onItemClick", "v", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends k
{
  public static final d.a Ilk;
  private static final String TAG;
  private ImageView Ill;
  private ImageView Ilm;
  private TextView Iln;
  private View maskView;
  private ImageView vMs;
  
  static
  {
    AppMethodBeat.i(275941);
    Ilk = new d.a((byte)0);
    TAG = "GameChatRoom.GameChatItemMsgImgLinkVH";
    AppMethodBeat.o(275941);
  }
  
  public d(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275933);
    AppMethodBeat.o(275933);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275951);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhO, null);
    View localView = paramViewGroup.findViewById(h.e.IfO);
    s.s(localView, "bodyView.findViewById(R.….game_chat_landscape_img)");
    this.Ill = ((ImageView)localView);
    localView = paramViewGroup.findViewById(h.e.IfQ);
    s.s(localView, "bodyView.findViewById(R.id.game_chat_portrait_img)");
    this.Ilm = ((ImageView)localView);
    localView = paramViewGroup.findViewById(h.e.IfS);
    s.s(localView, "bodyView.findViewById(R.…ame_chat_video_play_icon)");
    this.vMs = ((ImageView)localView);
    localView = paramViewGroup.findViewById(h.e.IfT);
    s.s(localView, "bodyView.findViewById(R.id.game_chat_video_time)");
    this.Iln = ((TextView)localView);
    localView = paramViewGroup.findViewById(h.e.IfR);
    s.s(localView, "bodyView.findViewById(R.id.game_chat_video_mask)");
    this.maskView = localView;
    s.s(paramViewGroup, "bodyView");
    AppMethodBeat.o(275951);
    return paramViewGroup;
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    Object localObject3 = null;
    AppMethodBeat.i(275966);
    Object localObject1;
    Object localObject2;
    if (paramChatroomMsgPack != null)
    {
      localObject1 = paramChatroomMsgPack.msg_content;
      if (localObject1 != null)
      {
        Object localObject4 = ((MsgContent)localObject1).chatroom_img_link;
        if (localObject4 != null)
        {
          com.tencent.mm.plugin.game.d.e locale;
          if ((((ChatroomMsgImgLink)localObject4).pic_width == 0) || (((ChatroomMsgImgLink)localObject4).pic_height == 0))
          {
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            localObject5 = ((ImageView)localObject1).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject5).width = a.fromDPToPix(this.mContext, 140);
            ((ViewGroup.LayoutParams)localObject5).height = a.fromDPToPix(this.mContext, 78);
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
            localObject2 = this.Ilm;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
            ((ImageView)localObject1).setVisibility(8);
            localObject5 = new e.a.a();
            ((e.a.a)localObject5).IYs = false;
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            if (((ImageView)localObject1).getVisibility() != 0) {
              break label932;
            }
            locale = com.tencent.mm.plugin.game.d.e.fIb();
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            locale.a((ImageView)localObject1, ((ChatroomMsgImgLink)localObject4).pic_url, ((e.a.a)localObject5).fIc());
            label251:
            localObject2 = this.Iln;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("videoTime");
              localObject1 = null;
            }
            ((TextView)localObject1).setVisibility(8);
            localObject2 = this.vMs;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("playIcon");
              localObject1 = null;
            }
            ((ImageView)localObject1).setVisibility(8);
            localObject2 = this.maskView;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("maskView");
              localObject1 = null;
            }
            ((View)localObject1).setVisibility(8);
            if (((ChatroomMsgImgLink)localObject4).type != 1) {
              break label1221;
            }
            localObject2 = this.Iln;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("videoTime");
              localObject1 = null;
            }
            ((TextView)localObject1).setVisibility(0);
            localObject1 = this.Iln;
            if (localObject1 != null) {
              break label974;
            }
            s.bIx("videoTime");
            localObject1 = null;
            label371:
            ((TextView)localObject1).setText((CharSequence)Util.formatSecToMin(((ChatroomMsgImgLink)localObject4).playtime));
            localObject2 = this.vMs;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("playIcon");
              localObject1 = null;
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject2 = this.maskView;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("maskView");
              localObject1 = null;
            }
            ((View)localObject1).setVisibility(0);
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            if (((ImageView)localObject1).getVisibility() != 0) {
              break label980;
            }
            localObject1 = this.Ill;
            if (localObject1 != null) {
              break label977;
            }
            s.bIx("landscapeImg");
            localObject1 = null;
          }
          for (;;)
          {
            localObject4 = this.vMs;
            localObject2 = localObject4;
            if (localObject4 == null)
            {
              s.bIx("playIcon");
              localObject2 = null;
            }
            localObject2 = ((ImageView)localObject2).getLayoutParams();
            if (localObject2 != null) {
              break label1002;
            }
            paramChatroomMsgPack = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(275966);
            throw paramChatroomMsgPack;
            if (((ChatroomMsgImgLink)localObject4).pic_width > ((ChatroomMsgImgLink)localObject4).pic_height)
            {
              localObject2 = this.Ill;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("landscapeImg");
                localObject1 = null;
              }
              ((ImageView)localObject1).setVisibility(0);
              localObject2 = this.Ill;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("landscapeImg");
                localObject1 = null;
              }
              if (((ImageView)localObject1).getWidth() == ((ChatroomMsgImgLink)localObject4).pic_width)
              {
                localObject2 = this.Ill;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("landscapeImg");
                  localObject1 = null;
                }
                if (((ImageView)localObject1).getHeight() == ((ChatroomMsgImgLink)localObject4).pic_height) {}
              }
              else
              {
                localObject2 = this.Ill;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("landscapeImg");
                  localObject1 = null;
                }
                localObject5 = ((ImageView)localObject1).getLayoutParams();
                ((ViewGroup.LayoutParams)localObject5).width = a.fromDPToPix(this.mContext, 140);
                ((ViewGroup.LayoutParams)localObject5).height = ((int)(((ViewGroup.LayoutParams)localObject5).width * ((ChatroomMsgImgLink)localObject4).pic_height / ((ChatroomMsgImgLink)localObject4).pic_width));
                localObject2 = this.Ill;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("landscapeImg");
                  localObject1 = null;
                }
                ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              }
              localObject2 = this.Ilm;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("portraitImg");
                localObject1 = null;
              }
              ((ImageView)localObject1).setVisibility(8);
              break;
            }
            localObject2 = this.Ill;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("landscapeImg");
              localObject1 = null;
            }
            ((ImageView)localObject1).setVisibility(8);
            localObject2 = this.Ilm;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
            ((ImageView)localObject1).setVisibility(0);
            localObject2 = this.Ilm;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
            if (((ImageView)localObject1).getWidth() == ((ChatroomMsgImgLink)localObject4).pic_width)
            {
              localObject2 = this.Ilm;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("portraitImg");
                localObject1 = null;
              }
              if (((ImageView)localObject1).getHeight() == ((ChatroomMsgImgLink)localObject4).pic_height) {
                break;
              }
            }
            localObject2 = this.Ilm;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
            localObject5 = ((ImageView)localObject1).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject5).height = a.fromDPToPix(this.mContext, 140);
            ((ViewGroup.LayoutParams)localObject5).width = ((int)(((ViewGroup.LayoutParams)localObject5).height * ((ChatroomMsgImgLink)localObject4).pic_width / ((ChatroomMsgImgLink)localObject4).pic_height));
            localObject2 = this.Ilm;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
            ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
            break;
            label932:
            locale = com.tencent.mm.plugin.game.d.e.fIb();
            localObject2 = this.Ilm;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
            locale.a((ImageView)localObject1, ((ChatroomMsgImgLink)localObject4).pic_url, ((e.a.a)localObject5).fIc());
            break label251;
            label974:
            break label371;
            label977:
            continue;
            label980:
            localObject1 = this.Ilm;
            if (localObject1 == null)
            {
              s.bIx("portraitImg");
              localObject1 = null;
            }
          }
          label1002:
          Object localObject5 = (RelativeLayout.LayoutParams)localObject2;
          ((RelativeLayout.LayoutParams)localObject5).addRule(13);
          localObject4 = this.vMs;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("playIcon");
            localObject2 = null;
          }
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          localObject4 = this.Iln;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("videoTime");
            localObject2 = null;
          }
          localObject2 = ((TextView)localObject2).getLayoutParams();
          if (localObject2 == null)
          {
            paramChatroomMsgPack = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(275966);
            throw paramChatroomMsgPack;
          }
          localObject5 = (RelativeLayout.LayoutParams)localObject2;
          ((RelativeLayout.LayoutParams)localObject5).addRule(8, ((ImageView)localObject1).getId());
          ((RelativeLayout.LayoutParams)localObject5).addRule(7, ((ImageView)localObject1).getId());
          localObject4 = this.Iln;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("videoTime");
            localObject2 = null;
          }
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          localObject4 = this.maskView;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("maskView");
            localObject2 = null;
          }
          localObject2 = ((View)localObject2).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).height = ((ImageView)localObject1).getLayoutParams().height;
          ((ViewGroup.LayoutParams)localObject2).width = ((ImageView)localObject1).getLayoutParams().width;
          localObject1 = this.maskView;
          if (localObject1 != null) {
            break label1232;
          }
          s.bIx("maskView");
          localObject1 = localObject3;
        }
      }
    }
    label1221:
    label1232:
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      super.a(paramChatroomMsgPack);
      AppMethodBeat.o(275966);
      return;
    }
  }
  
  protected final void fCM()
  {
    AppMethodBeat.i(275979);
    Object localObject = this.Ily;
    long l;
    if (localObject != null)
    {
      localObject = ((ChatroomMsgPack)localObject).msg_content;
      if (localObject != null)
      {
        localObject = ((MsgContent)localObject).chatroom_img_link;
        if ((localObject != null) && (!fCS())) {
          switch (com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, ((ChatroomMsgImgLink)localObject).jump_info, 0, null))
          {
          default: 
            AppMethodBeat.o(275979);
            return;
          case 1: 
            l = 6L;
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.game.report.d.a.a(com.tencent.mm.game.report.d.mty, 1L, l, this.Ijq, this.Ijr, this.Ily.seq, this.Ily.from_username, this.IjE);
      AppMethodBeat.o(275979);
      return;
      l = 7L;
      continue;
      l = 28L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.d
 * JD-Core Version:    0.7.0.1
 */