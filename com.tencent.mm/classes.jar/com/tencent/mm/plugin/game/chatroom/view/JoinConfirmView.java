package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomEnterInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/JoinConfirmView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sourceId", "", "ssid", "attachToExternalConfirmData", "", "enterInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomEnterInfo;", "chatRoomData", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomData;", "userData", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomUserData;", "lbs", "Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;", "preloadCreateAccount", "Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;", "attachToNormalConfirmData", "userName", "", "chatRoomExternInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomExternInfo;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JoinConfirmView
  extends LinearLayout
{
  private long InY;
  private long ssid;
  
  public JoinConfirmView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JoinConfirmView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276459);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(276459);
      throw paramContext;
    }
    this.InY = ((Activity)paramContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.ssid = ((Activity)paramContext).getIntent().getLongExtra("game_report_ssid", 0L);
    AppMethodBeat.o(276459);
  }
  
  public final void a(ChatroomEnterInfo paramChatroomEnterInfo, ChatroomData paramChatroomData, ChatroomUserData paramChatroomUserData, Lbs paramLbs, JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(276477);
    s.u(paramChatroomEnterInfo, "enterInfo");
    removeAllViews();
    JoinRoomExternalConfirmView localJoinRoomExternalConfirmView = new JoinRoomExternalConfirmView(getContext());
    localJoinRoomExternalConfirmView.aI(this.ssid, this.InY);
    addView((View)localJoinRoomExternalConfirmView);
    localJoinRoomExternalConfirmView.b(paramChatroomEnterInfo, paramChatroomData, paramChatroomUserData, paramLbs, paramJumpInfo);
    AppMethodBeat.o(276477);
  }
  
  public final void b(String paramString, ChatroomData paramChatroomData, ChatroomUserData paramChatroomUserData, Lbs paramLbs, JumpInfo paramJumpInfo, ChatroomExternInfo paramChatroomExternInfo)
  {
    AppMethodBeat.i(276466);
    removeAllViews();
    JoinChatRoomConfirmView localJoinChatRoomConfirmView = new JoinChatRoomConfirmView(getContext());
    localJoinChatRoomConfirmView.aI(this.ssid, this.InY);
    addView((View)localJoinChatRoomConfirmView);
    localJoinChatRoomConfirmView.a(paramString, paramChatroomData, paramChatroomUserData, paramLbs, paramJumpInfo, paramChatroomExternInfo);
    AppMethodBeat.o(276466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.JoinConfirmView
 * JD-Core Version:    0.7.0.1
 */