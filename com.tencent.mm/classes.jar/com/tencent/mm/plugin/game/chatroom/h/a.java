package com.tencent.mm.plugin.game.chatroom.h;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgApp;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.sdk.platformtools.Util;

public class a
  extends g
{
  private ImageView CuQ;
  private Button CuR;
  private TextView CuS;
  private TextView CuT;
  private TextView CuU;
  
  public a(View paramView, int paramInt)
  {
    super(paramView, paramInt);
  }
  
  protected final void a(ChatroomMsgPack paramChatroomMsgPack)
  {
    AppMethodBeat.i(210952);
    if ((paramChatroomMsgPack == null) || (paramChatroomMsgPack.msg_content == null) || (paramChatroomMsgPack.msg_content.chatroom_app == null))
    {
      AppMethodBeat.o(210952);
      return;
    }
    paramChatroomMsgPack = paramChatroomMsgPack.msg_content.chatroom_app;
    this.CuS.setText(paramChatroomMsgPack.title);
    if (!Util.isNullOrNil(paramChatroomMsgPack.des))
    {
      this.CuT.setVisibility(0);
      this.CuT.setText(paramChatroomMsgPack.des);
      if (Util.isNullOrNil(paramChatroomMsgPack.second_des)) {
        break label158;
      }
      this.CuU.setVisibility(0);
      this.CuU.setText(paramChatroomMsgPack.second_des);
    }
    for (;;)
    {
      this.CuR.setText(paramChatroomMsgPack.button_des);
      com.tencent.mm.plugin.game.d.e.eAa().a(null, paramChatroomMsgPack.bg_pic_url, null, new e.b()
      {
        public final void a(View paramAnonymousView, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(211320);
          a.a(a.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212316);
              if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
                a.a(a.this).setImageBitmap(paramAnonymousBitmap);
              }
              AppMethodBeat.o(212316);
            }
          });
          AppMethodBeat.o(211320);
        }
      });
      AppMethodBeat.o(210952);
      return;
      this.CuT.setVisibility(8);
      break;
      label158:
      this.CuU.setVisibility(8);
    }
  }
  
  protected final View evF()
  {
    AppMethodBeat.i(210951);
    View localView = LayoutInflater.from(this.mContext).inflate(f.f.CtF, null);
    this.CuQ = ((ImageView)localView.findViewById(f.e.Csh));
    this.CuR = ((Button)localView.findViewById(f.e.Csg));
    this.CuR.setClickable(false);
    this.CuS = ((TextView)localView.findViewById(f.e.app_msg_title));
    this.CuT = ((TextView)localView.findViewById(f.e.Csi));
    this.CuU = ((TextView)localView.findViewById(f.e.Csj));
    AppMethodBeat.o(210951);
    return localView;
  }
  
  protected final void evG()
  {
    AppMethodBeat.i(210954);
    long l;
    if ((this.Cvf != null) && (this.Cvf.msg_content != null) && (this.Cvf.msg_content.chatroom_app != null) && (!com.tencent.mm.plugin.game.chatroom.e.aIP(this.iZU))) {
      switch (com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, this.Cvf.msg_content.chatroom_app.jump_info, 0, null))
      {
      default: 
        AppMethodBeat.o(210954);
        return;
      case 1: 
        l = 6L;
      }
    }
    for (;;)
    {
      d.a locala = d.jTj;
      d.a.a(1L, l, this.Cuy, this.Cuz, this.Cvf.seq, this.Cvf.from_username);
      AppMethodBeat.o(210954);
      return;
      l = 7L;
      continue;
      l = 28L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.a
 * JD-Core Version:    0.7.0.1
 */