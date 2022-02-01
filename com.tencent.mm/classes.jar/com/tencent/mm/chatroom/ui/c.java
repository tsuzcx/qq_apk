package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.aj;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/ChatRoomMember;Landroid/view/View;Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;)V", "avatarIV", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "nicknameTVWithEmoji", "Landroid/widget/TextView;", "fillContent", "", "ct", "Lcom/tencent/mm/storage/Contact;", "position", "", "getDisplayName", "", "getNickName", "Landroid/text/SpannableString;", "username", "textView", "IFollowMemberCallback", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
{
  final Context context;
  ImageView lBC;
  private final c.a lKO;
  TextView lKP;
  aj lzy;
  
  public c(Context paramContext, aj paramaj, View paramView, c.a parama)
  {
    super(paramView);
    AppMethodBeat.i(241625);
    this.context = paramContext;
    this.lzy = paramaj;
    this.lKO = parama;
    this.lBC = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    this.lKP = ((TextView)paramView.findViewById(a.e.lEE));
    AppMethodBeat.o(241625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */