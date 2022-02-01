package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.AbstractInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChatRoomListCard
  extends MRecyclerView
{
  private static int bkR = 0;
  private long Ijq;
  private long Ijr;
  private a IoO;
  private Context mContext;
  
  public ChatRoomListCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276331);
    init(paramContext);
    AppMethodBeat.o(276331);
  }
  
  public ChatRoomListCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276339);
    init(paramContext);
    AppMethodBeat.o(276339);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(276348);
    this.mContext = paramContext;
    this.Ijr = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    d.a locala = d.mty;
    d.a.b(0L, 1L, this.Ijq, this.Ijr);
    bkR = com.tencent.mm.cd.a.fromDPToPix(paramContext, 400);
    paramContext = new LinearLayoutManager();
    paramContext.setOrientation(1);
    setLayoutManager(paramContext);
    setItemAnimator(null);
    this.IoO = new a();
    setAdapter(this.IoO);
    AppMethodBeat.o(276348);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(276389);
    super.onAttachedToWindow();
    Log.i("MicroMsg.ChatRoomListCard", "onAttachedToWindow");
    AppMethodBeat.o(276389);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(276396);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.ChatRoomListCard", "onDetachedFromWindow");
    AppMethodBeat.o(276396);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276382);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i = paramInt2;
    if (bkR <= j)
    {
      i = paramInt2;
      if (bkR > 0) {
        i = View.MeasureSpec.makeMeasureSpec(Float.valueOf(bkR).intValue(), -2147483648);
      }
    }
    super.onMeasure(paramInt1, i);
    AppMethodBeat.o(276382);
  }
  
  public void setData(List<MyChatroomInfo> paramList)
  {
    AppMethodBeat.i(276377);
    if (this.IoO != null)
    {
      a locala = this.IoO;
      if (paramList != null)
      {
        locala.IoP.clear();
        locala.IoP.addAll(paramList);
        locala.bZE.notifyChanged();
      }
    }
    AppMethodBeat.o(276377);
  }
  
  final class a
    extends RecyclerView.a<RecyclerView.v>
  {
    List<MyChatroomInfo> IoP;
    private List<String> IoQ;
    
    a()
    {
      AppMethodBeat.i(276322);
      this.IoP = new LinkedList();
      this.IoQ = new ArrayList();
      AppMethodBeat.o(276322);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(276328);
      paramViewGroup = new ChatRoomListCard.b(ChatRoomListCard.this, LayoutInflater.from(ChatRoomListCard.a(ChatRoomListCard.this)).inflate(h.f.IhB, paramViewGroup, false));
      AppMethodBeat.o(276328);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(276351);
      if ((paramv == null) || (paramInt >= this.IoP.size()))
      {
        AppMethodBeat.o(276351);
        return;
      }
      ChatRoomListCard.b localb = (ChatRoomListCard.b)paramv;
      paramv = (MyChatroomInfo)this.IoP.get(paramInt);
      localb.mPosition = paramInt;
      localb.IoW = paramv;
      StringBuilder localStringBuilder;
      int i;
      if (localb.IoW.unread_msg_count > 0L)
      {
        localb.IoU.setVisibility(0);
        localStringBuilder = new StringBuilder();
        if ((localb.IoW.abstract_info == null) || (Util.isNullOrNil(localb.IoW.abstract_info.abstract_desc))) {
          break label577;
        }
        localStringBuilder.append(localb.IoW.abstract_info.abstract_desc);
        localStringBuilder.append(" ");
        i = localStringBuilder.length();
        if (localb.IoW.abstract_info.word_color == null) {
          break label572;
        }
        if (!aw.isDarkMode()) {
          break label458;
        }
        paramv = localb.IoW.abstract_info.word_color.dark_color;
        label188:
        paramv = com.tencent.mm.plugin.game.chatroom.e.aFs(paramv);
      }
      for (;;)
      {
        if (!Util.isNullOrNil(localb.IoW.last_msg_desc)) {
          localStringBuilder.append(localb.IoW.last_msg_desc);
        }
        for (;;)
        {
          Object localObject1 = paramv;
          if (paramv == null) {
            localObject1 = Integer.valueOf(ChatRoomListCard.a(localb.IoR).getResources().getColor(h.b.red_bg_color));
          }
          paramv = new SpannableString(localStringBuilder);
          paramv.setSpan(new ForegroundColorSpan(((Integer)localObject1).intValue()), 0, i, 33);
          localb.IoV.setText(paramv);
          paramv = localObject2;
          if (localb.IoW.chatroom_info != null)
          {
            paramv = localObject2;
            if (localb.IoW.chatroom_info.chatroom_data != null)
            {
              localb.IoS.setText(localb.IoW.chatroom_info.chatroom_data.room_name);
              com.tencent.mm.plugin.game.d.e.fIb().p(localb.IoT, localb.IoW.chatroom_info.chatroom_data.chatroom_icon);
              paramv = localb.IoW.chatroom_info.chatroom_data;
            }
          }
          if ((paramv != null) && (!this.IoQ.contains(paramv.chatroom_name)))
          {
            this.IoQ.add(paramv.chatroom_name);
            paramv = d.mty;
            d.a.b(paramInt + 1, 1L, ChatRoomListCard.b(ChatRoomListCard.this), ChatRoomListCard.c(ChatRoomListCard.this));
          }
          AppMethodBeat.o(276351);
          return;
          localb.IoU.setVisibility(8);
          break;
          label458:
          paramv = localb.IoW.abstract_info.word_color.light_color;
          break label188;
          if ((localb.IoW.chatroom_info != null) && (localb.IoW.chatroom_info.last_chatroom_msg != null)) {
            localStringBuilder.append(ChatRoomListCard.b.b(localb.IoW.chatroom_info.last_chatroom_msg));
          } else if ((localb.IoW.chatroom_info != null) && (localb.IoW.chatroom_info.chatroom_data != null)) {
            localStringBuilder.append(localb.IoW.chatroom_info.chatroom_data.announcement);
          }
        }
        label572:
        paramv = null;
        continue;
        label577:
        paramv = null;
        i = 0;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276357);
      int i = this.IoP.size();
      AppMethodBeat.o(276357);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    TextView IoS;
    ImageView IoT;
    View IoU;
    TextView IoV;
    MyChatroomInfo IoW;
    int mPosition;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(276304);
      this.IoS = ((TextView)paramView.findViewById(h.e.Iff));
      this.IoT = ((ImageView)paramView.findViewById(h.e.Ifc));
      this.IoU = paramView.findViewById(h.e.gbj);
      this.IoV = ((TextView)paramView.findViewById(h.e.IeZ));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276309);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomListCard$RoomCardVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = d.mty;
          d.a.b(ChatRoomListCard.b.a(ChatRoomListCard.b.this) + 1, 2L, ChatRoomListCard.b(ChatRoomListCard.this), ChatRoomListCard.c(ChatRoomListCard.this));
          if ((ChatRoomListCard.b.b(ChatRoomListCard.b.this) != null) && (ChatRoomListCard.b.b(ChatRoomListCard.b.this).chatroom_info != null) && (ChatRoomListCard.b.b(ChatRoomListCard.b.this).chatroom_info.chatroom_data != null))
          {
            com.tencent.mm.plugin.game.chatroom.b.IdQ = false;
            paramAnonymousView = new Bundle();
            paramAnonymousView.putString("chat_room_title", ChatRoomListCard.b.b(ChatRoomListCard.b.this).chatroom_info.chatroom_data.room_name);
            ((com.tencent.mm.plugin.game.chatroom.a.a)h.az(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(ChatRoomListCard.a(ChatRoomListCard.this), ChatRoomListCard.b.b(ChatRoomListCard.b.this).chatroom_info.chatroom_data.chatroom_name, ChatRoomListCard.b.b(ChatRoomListCard.b.this).chatroom_info.chatroom_data.chatroom_icon, null, false, 9999L, 0L, paramAnonymousView, null, true);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomListCard$RoomCardVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276309);
        }
      });
      AppMethodBeat.o(276304);
    }
    
    static String b(ChatroomMsgPack paramChatroomMsgPack)
    {
      if ((paramChatroomMsgPack != null) && (paramChatroomMsgPack.msg_content != null) && (paramChatroomMsgPack.msg_content.chatroom_text != null)) {
        return paramChatroomMsgPack.msg_content.chatroom_text.content;
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomListCard
 * JD-Core Version:    0.7.0.1
 */