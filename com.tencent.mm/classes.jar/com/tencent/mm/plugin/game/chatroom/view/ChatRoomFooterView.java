package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.d;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.ui.GameMoreChatRoomUI;
import com.tencent.mm.ui.ar;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ChatRoomFooterView
  extends LinearLayout
{
  private long Cuy;
  private long Cuz;
  private Lbs CvP;
  private View CwZ;
  List<BanAction> Cww;
  View Cxa;
  private ImageView Cxb;
  JumpInfo Cxc;
  private Context mContext;
  
  public ChatRoomFooterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(210898);
    this.Cww = new LinkedList();
    initView();
    AppMethodBeat.o(210898);
  }
  
  public ChatRoomFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210899);
    this.Cww = new LinkedList();
    initView();
    AppMethodBeat.o(210899);
  }
  
  public ChatRoomFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210900);
    this.Cww = new LinkedList();
    initView();
    AppMethodBeat.o(210900);
  }
  
  private void initView()
  {
    AppMethodBeat.i(210902);
    this.mContext = getContext();
    this.Cuz = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Cuy = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    LayoutInflater.from(this.mContext).inflate(f.f.CtB, this, true);
    this.CwZ = findViewById(f.e.CsN);
    this.Cxa = findViewById(f.e.CsM);
    this.Cxb = ((ImageView)findViewById(f.e.CsJ));
    if (ar.isDarkMode()) {
      this.Cxb.setImageResource(f.d.CrZ);
    }
    for (;;)
    {
      this.CwZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(210941);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomFooterView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          if (ChatRoomFooterView.a(ChatRoomFooterView.this) != null) {
            e.a(ChatRoomFooterView.b(ChatRoomFooterView.this), ChatRoomFooterView.a(ChatRoomFooterView.this), 0, null);
          }
          for (;;)
          {
            paramAnonymousView = d.jTj;
            d.a.a(1003L, 1L, 6L, 0L, ChatRoomFooterView.d(ChatRoomFooterView.this), ChatRoomFooterView.e(ChatRoomFooterView.this), "", "", "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomFooterView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210941);
            return;
            paramAnonymousView = new Intent(ChatRoomFooterView.b(ChatRoomFooterView.this), GameMoreChatRoomUI.class);
            if (ChatRoomFooterView.c(ChatRoomFooterView.this) != null) {}
            try
            {
              paramAnonymousView.putExtra("chat_room_lbs", ChatRoomFooterView.c(ChatRoomFooterView.this).toByteArray());
              label161:
              paramAnonymousView.putExtra("game_report_ssid", 0L);
              paramAnonymousView.putExtra("game_report_sourceid", 1003L);
              localObject = ChatRoomFooterView.b(ChatRoomFooterView.this);
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/game/chatroom/view/ChatRoomFooterView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject).startActivity((Intent)paramAnonymousView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomFooterView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            catch (IOException localIOException)
            {
              break label161;
            }
          }
        }
      });
      d.a locala = d.jTj;
      d.a.a(1003L, 1L, 1L, 0L, this.Cuy, this.Cuz, "", "", "");
      AppMethodBeat.o(210902);
      return;
      this.Cxb.setImageResource(f.d.Csa);
    }
  }
  
  public void setLbsInfo(Lbs paramLbs)
  {
    this.CvP = paramLbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomFooterView
 * JD-Core Version:    0.7.0.1
 */