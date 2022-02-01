package com.tencent.mm.plugin.game.chatroom.i;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgEmoji;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.f.a;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.view.GameChatEmojiView;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemEmojiVH;", "Lcom/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bodyView", "chatRoomEmoji", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgEmoji;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiMd5", "", "emojiView", "Lcom/tencent/mm/plugin/game/chatroom/view/GameChatEmojiView;", "vHashcode", "bindMsgData", "", "msg", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;", "createEmojiInfo", "msgEmoji", "fillBodyView", "parentView", "Landroid/view/ViewGroup;", "onItemClick", "v", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends k
{
  public static final b.a Ilc;
  private static final String TAG;
  private View Ild;
  private GameChatEmojiView Ile;
  private String Ilf;
  private ChatroomMsgEmoji Ilg;
  private b Ilh;
  private EmojiInfo mgK;
  
  static
  {
    AppMethodBeat.i(275975);
    Ilc = new b.a((byte)0);
    TAG = "GameChatRoom.GameChatItemEmojiVH";
    AppMethodBeat.o(275975);
  }
  
  public b(View paramView, int paramInt)
  {
    super(paramView, paramInt);
    AppMethodBeat.i(275954);
    this.Ilh = this;
    AppMethodBeat.o(275954);
  }
  
  private static final void a(b paramb, EmojiInfo paramEmojiInfo, ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275964);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramEmojiInfo, "$this_run");
    paramb = paramb.Ile;
    if (paramb != null) {
      paramb.a(paramEmojiInfo, paramChatroomMsgPack.seq);
    }
    AppMethodBeat.o(275964);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275991);
    if (this.Ild == null)
    {
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhM, null);
      kotlin.g.b.s.s(paramViewGroup, "from(mContext).inflate(R…ame_chat_msg_emoji, null)");
      this.Ild = paramViewGroup;
      View localView = this.Ild;
      paramViewGroup = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("bodyView");
        paramViewGroup = null;
      }
      this.Ile = ((GameChatEmojiView)paramViewGroup.findViewById(h.e.IfM));
    }
    paramViewGroup = this.Ild;
    if (paramViewGroup == null)
    {
      kotlin.g.b.s.bIx("bodyView");
      AppMethodBeat.o(275991);
      return null;
    }
    AppMethodBeat.o(275991);
    return paramViewGroup;
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(276013);
    Object localObject;
    ChatroomMsgEmoji localChatroomMsgEmoji;
    EmojiInfo localEmojiInfo;
    if (paramChatroomMsgPack != null)
    {
      localObject = paramChatroomMsgPack.msg_content;
      if (localObject != null)
      {
        localChatroomMsgEmoji = ((MsgContent)localObject).chatroom_emoji;
        if (localChatroomMsgEmoji != null)
        {
          this.Ilg = localChatroomMsgEmoji;
          localObject = localChatroomMsgEmoji.md5;
          kotlin.g.b.s.s(localObject, "it.md5");
          int i;
          if (((CharSequence)localObject).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label642;
            }
            this.Ilf = localChatroomMsgEmoji.md5;
            localEmojiInfo = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(localChatroomMsgEmoji.md5);
            localObject = localEmojiInfo;
            if (localEmojiInfo == null)
            {
              localEmojiInfo = new EmojiInfo();
              localEmojiInfo.field_catalog = 84;
              localEmojiInfo.field_reserved4 |= EmojiInfo.akmb;
              f.a.fCp();
              localObject = localEmojiInfo;
              if (localChatroomMsgEmoji != null) {
                if ((!Util.isNullOrNil(localChatroomMsgEmoji.md5)) && (!Util.isNullOrNil(localEmojiInfo.field_md5)))
                {
                  localObject = localEmojiInfo;
                  if (!localChatroomMsgEmoji.md5.equals(localEmojiInfo.field_md5)) {}
                }
                else
                {
                  localEmojiInfo.field_md5 = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.md5, localEmojiInfo.field_md5);
                  localEmojiInfo.field_cdnUrl = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.cdnurl, localEmojiInfo.field_cdnUrl);
                  localEmojiInfo.field_thumbUrl = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.thumburl, localEmojiInfo.field_thumbUrl);
                  localEmojiInfo.field_designerID = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.designerid, localEmojiInfo.field_designerID);
                  localEmojiInfo.field_encrypturl = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.encrypturl, localEmojiInfo.field_encrypturl);
                  localEmojiInfo.field_aeskey = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.aeskey, localEmojiInfo.field_aeskey);
                  localEmojiInfo.field_groupId = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.productid, localEmojiInfo.field_groupId);
                  localEmojiInfo.field_externUrl = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.externurl, localEmojiInfo.field_externUrl);
                  localEmojiInfo.field_externMd5 = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.externmd5, localEmojiInfo.field_externMd5);
                  localEmojiInfo.field_activityid = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.activityid, localEmojiInfo.field_activityid);
                  localEmojiInfo.field_attachedText = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.attachedtext, localEmojiInfo.field_attachedText);
                  localEmojiInfo.field_attachTextColor = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.attachedtextcolor, localEmojiInfo.field_attachTextColor);
                  localEmojiInfo.field_lensId = com.tencent.mm.plugin.game.chatroom.f.gP(localChatroomMsgEmoji.lensid, localEmojiInfo.field_lensId);
                  localEmojiInfo.field_width = Util.nullAs(Integer.valueOf(localChatroomMsgEmoji.width), localEmojiInfo.field_width);
                  localEmojiInfo.field_height = Util.nullAs(Integer.valueOf(localChatroomMsgEmoji.height), localEmojiInfo.field_height);
                  localObject = localEmojiInfo;
                }
              }
            }
            this.mgK = ((EmojiInfo)localObject);
            localEmojiInfo = this.mgK;
            if (localEmojiInfo == null) {
              break label642;
            }
            String str1 = TAG;
            String str2 = localChatroomMsgEmoji.md5;
            i = this.Ilh.hashCode();
            localObject = this.Ile;
            if (localObject != null) {
              break label591;
            }
            localObject = null;
            label507:
            Log.d(str1, "set emoji info to view，md5:%s, hashcode:%d, view_hashcode:%d", new Object[] { str2, Integer.valueOf(i), localObject });
            localObject = this.Ile;
            if (localObject != null) {
              break label602;
            }
            localObject = null;
            label546:
            if (!(localObject instanceof String)) {
              break label653;
            }
            localObject = this.Ile;
            if (localObject != null) {
              break label610;
            }
          }
          label591:
          label602:
          label610:
          for (localObject = null;; localObject = ((GameChatEmojiView)localObject).getTag())
          {
            if (localObject != null) {
              break label618;
            }
            paramChatroomMsgPack = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(276013);
            throw paramChatroomMsgPack;
            i = 0;
            break;
            localObject = Integer.valueOf(((GameChatEmojiView)localObject).hashCode());
            break label507;
            localObject = ((GameChatEmojiView)localObject).getTag();
            break label546;
          }
          label618:
          if (!kotlin.g.b.s.p((String)localObject, localChatroomMsgEmoji.md5)) {
            break label653;
          }
          Log.d(TAG, "same emoji info");
        }
      }
    }
    for (;;)
    {
      label642:
      super.a(paramChatroomMsgPack);
      AppMethodBeat.o(276013);
      return;
      label653:
      com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda0(this, localEmojiInfo, paramChatroomMsgPack), 50L);
      localObject = this.Ile;
      if (localObject != null) {
        ((GameChatEmojiView)localObject).setTag(localChatroomMsgEmoji.md5);
      }
    }
  }
  
  protected final void fCM()
  {
    AppMethodBeat.i(276029);
    Object localObject = (CharSequence)this.Ilf;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if ((i == 0) && (this.mgK != null))
      {
        localObject = this.mgK;
        if ((localObject == null) || (((EmojiInfo)localObject).aqJ() != true)) {
          break label75;
        }
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label80;
      }
      AppMethodBeat.o(276029);
      return;
      i = 0;
      break;
    }
    label80:
    if (((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      ((d)com.tencent.mm.kernel.h.ax(d.class)).kg(this.mContext);
      AppMethodBeat.o(276029);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("custom_smiley_preview_md5", this.Ilf);
    ((Intent)localObject).putExtra("emoji_info", (Parcelable)this.mgK);
    EmojiInfo localEmojiInfo = this.mgK;
    if ((localEmojiInfo != null) && (localEmojiInfo.field_catalog != EmojiGroupInfo.aklF) && (localEmojiInfo.field_catalog != EmojiGroupInfo.aklE) && (localEmojiInfo.field_catalog != EmojiGroupInfo.aklD)) {
      ((Intent)localObject).putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
    }
    c.b(this.mContext, "emoji", ".ui.CustomSmileyPreviewUI", (Intent)localObject, 1111);
    AppMethodBeat.o(276029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.b
 * JD-Core Version:    0.7.0.1
 */