package com.tencent.mm.plugin.game.chatroom.i;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgApp;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class a
  extends k
{
  private ImageView IkU;
  private Button IkV;
  private TextView IkW;
  private TextView IkX;
  private TextView IkY;
  
  public a(View paramView, int paramInt)
  {
    super(paramView, paramInt);
  }
  
  protected final View K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275955);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(h.f.IhL, null);
    this.IkU = ((ImageView)paramViewGroup.findViewById(h.e.IeJ));
    this.IkV = ((Button)paramViewGroup.findViewById(h.e.IeI));
    this.IkV.setClickable(false);
    this.IkW = ((TextView)paramViewGroup.findViewById(h.e.app_msg_title));
    this.IkX = ((TextView)paramViewGroup.findViewById(h.e.IeK));
    this.IkY = ((TextView)paramViewGroup.findViewById(h.e.IeL));
    AppMethodBeat.o(275955);
    return paramViewGroup;
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(275962);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_app == null))
    {
      AppMethodBeat.o(275962);
      return;
    }
    final ChatroomMsgApp localChatroomMsgApp = paramChatroomMsgPack.msg_content.chatroom_app;
    this.IkW.setText(localChatroomMsgApp.title);
    label109:
    GradientDrawable localGradientDrawable;
    if (!Util.isNullOrNil(localChatroomMsgApp.des))
    {
      this.IkX.setVisibility(0);
      this.IkX.setText(localChatroomMsgApp.des);
      if (Util.isNullOrNil(localChatroomMsgApp.second_des)) {
        break label225;
      }
      this.IkY.setVisibility(0);
      this.IkY.setText(localChatroomMsgApp.second_des);
      localGradientDrawable = (GradientDrawable)this.IkV.getBackground();
      if (localGradientDrawable != null) {
        if ((localChatroomMsgApp.button_bg_color == null) || (localChatroomMsgApp.button_bg_color.dark_color == null)) {
          break label264;
        }
      }
    }
    label264:
    for (paramChatroomMsgPack = localChatroomMsgApp.button_bg_color.dark_color;; paramChatroomMsgPack = null)
    {
      localGradientDrawable.setColor(com.tencent.mm.plugin.game.chatroom.e.fo(paramChatroomMsgPack, h.b.UN_Brand));
      this.IkV.setText(localChatroomMsgApp.button_des);
      paramChatroomMsgPack = this.IkU.getTag();
      if (((paramChatroomMsgPack instanceof String)) && (((String)paramChatroomMsgPack).equals(localChatroomMsgApp.bg_pic_url)))
      {
        Log.d("GameChatRoom.GameChatItemAppVH", "dont need reload picture");
        AppMethodBeat.o(275962);
        return;
        this.IkX.setVisibility(8);
        break;
        label225:
        this.IkY.setVisibility(8);
        break label109;
      }
      com.tencent.mm.plugin.game.d.e.fIb().a(null, localChatroomMsgApp.bg_pic_url, null, new e.b()
      {
        public final void a(View paramAnonymousView, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(275912);
          a.a(a.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275921);
              if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
              {
                a.a(a.this).setTag(a.1.this.IkZ.bg_pic_url);
                a.a(a.this).setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(275921);
            }
          });
          AppMethodBeat.o(275912);
        }
      });
      AppMethodBeat.o(275962);
      return;
    }
  }
  
  protected final void fCM()
  {
    AppMethodBeat.i(275969);
    long l;
    if ((this.Ily != null) && (this.Ily.msg_content != null) && (this.Ily.msg_content.chatroom_app != null) && (!fCS())) {
      switch (com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, this.Ily.msg_content.chatroom_app.jump_info, 0, null))
      {
      default: 
        AppMethodBeat.o(275969);
        return;
      case 1: 
        l = 6L;
      }
    }
    for (;;)
    {
      d.mty.a(1L, l, this.Ijq, this.Ijr, this.Ily.seq, this.Ily.from_username, this.IjE);
      AppMethodBeat.o(275969);
      return;
      l = 7L;
      continue;
      l = 28L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.a
 * JD-Core Version:    0.7.0.1
 */