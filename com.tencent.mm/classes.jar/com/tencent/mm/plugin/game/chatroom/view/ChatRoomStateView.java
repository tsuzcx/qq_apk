package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bm;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomSeq;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Notification;
import com.tencent.mm.plugin.game.autogen.chatroom.NotificationBar;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatRoomStateView
  extends LinearLayout
{
  public ImageView IpA;
  public TextView IpB;
  private List<Integer> IpC;
  private Notification IpD;
  public String IpE;
  public MTimerHandler IpF;
  private MTimerHandler IpG;
  public ChatMemberListView Ipw;
  public View Ipx;
  public ImageView Ipy;
  public TextView Ipz;
  public String lBQ;
  private Context mContext;
  public View plc;
  
  public ChatRoomStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276252);
    this.IpC = new CopyOnWriteArrayList();
    this.IpF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(276280);
        if (!Util.isNullOrNil(ChatRoomStateView.a(ChatRoomStateView.this))) {
          ChatRoomStateView.b(ChatRoomStateView.this);
        }
        for (;;)
        {
          AppMethodBeat.o(276280);
          return true;
          ChatRoomStateView.c(ChatRoomStateView.this).setText("");
          ChatRoomStateView.c(ChatRoomStateView.this).setVisibility(8);
        }
      }
    }, false);
    this.IpG = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(276254);
        if (ChatRoomStateView.d(ChatRoomStateView.this) != null) {
          ChatRoomStateView.d(ChatRoomStateView.this).setVisibility(8);
        }
        ChatRoomStateView.e(ChatRoomStateView.this);
        AppMethodBeat.o(276254);
        return true;
      }
    }, false);
    ci(paramContext);
    AppMethodBeat.o(276252);
  }
  
  public ChatRoomStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276261);
    this.IpC = new CopyOnWriteArrayList();
    this.IpF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(276280);
        if (!Util.isNullOrNil(ChatRoomStateView.a(ChatRoomStateView.this))) {
          ChatRoomStateView.b(ChatRoomStateView.this);
        }
        for (;;)
        {
          AppMethodBeat.o(276280);
          return true;
          ChatRoomStateView.c(ChatRoomStateView.this).setText("");
          ChatRoomStateView.c(ChatRoomStateView.this).setVisibility(8);
        }
      }
    }, false);
    this.IpG = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(276254);
        if (ChatRoomStateView.d(ChatRoomStateView.this) != null) {
          ChatRoomStateView.d(ChatRoomStateView.this).setVisibility(8);
        }
        ChatRoomStateView.e(ChatRoomStateView.this);
        AppMethodBeat.o(276254);
        return true;
      }
    }, false);
    ci(paramContext);
    AppMethodBeat.o(276261);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(276270);
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(h.f.IhH, this);
    this.Ipw = ((ChatMemberListView)findViewById(h.e.Ifn));
    AppMethodBeat.o(276270);
  }
  
  private static void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(276275);
    com.tencent.mm.plugin.game.d.e.fIb().p(paramImageView, paramString);
    AppMethodBeat.o(276275);
  }
  
  public final void a(final NotificationBar paramNotificationBar)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(276356);
        if ((paramNotificationBar == null) || (Util.isNullOrNil(paramNotificationBar.notification_list)))
        {
          AppMethodBeat.o(276356);
          return;
        }
        paramNotificationBar = (Notification)paramNotificationBar.notification_list.get(0);
        if (this.IpC.contains(Integer.valueOf(paramNotificationBar.id)))
        {
          Log.i("GameChatRoom.ChatRoomStateView", "duplicate notification id:%d", new Object[] { Integer.valueOf(paramNotificationBar.id) });
          AppMethodBeat.o(276356);
          continue;
        }
        if (this.IpD == null) {
          break;
        }
      }
      finally {}
      if (this.IpD.priority <= paramNotificationBar.priority) {
        break;
      }
      Log.i("GameChatRoom.ChatRoomStateView", "new noticationId[%d] priority[%d] < showing notificationId[%d] priority[%d]", new Object[] { Integer.valueOf(paramNotificationBar.id), Integer.valueOf(paramNotificationBar.priority), Integer.valueOf(this.IpD.id), Integer.valueOf(this.IpD.priority) });
      AppMethodBeat.o(276356);
    }
    if ((this.plc == null) || (paramNotificationBar == null)) {}
    for (;;)
    {
      this.IpG.startTimer(paramNotificationBar.disappear_second * 1000, 0L);
      AppMethodBeat.o(276356);
      break;
      Log.d("GameChatRoom.ChatRoomStateView", "show notification id:%d", new Object[] { Integer.valueOf(paramNotificationBar.id) });
      this.IpD = paramNotificationBar;
      this.Ipx.setVisibility(0);
      this.Ipx.setClickable(false);
      if (paramNotificationBar.jump_info != null)
      {
        this.Ipx.setClickable(true);
        this.Ipx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(276258);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (!com.tencent.mm.plugin.game.chatroom.e.aFq(ChatRoomStateView.f(ChatRoomStateView.this)).IdU)
            {
              if ((paramNotificationBar.jump_info.jump_type != 3) || (paramNotificationBar.jump_info.chatroom_seq == null)) {
                break label178;
              }
              paramAnonymousView = new bm();
              paramAnonymousView.hBz.channelId = paramNotificationBar.jump_info.chatroom_seq.channel_id;
              paramAnonymousView.hBz.seq = paramNotificationBar.jump_info.chatroom_seq.seq;
              paramAnonymousView.hBz.highlight = true;
              paramAnonymousView.publish();
            }
            for (;;)
            {
              if (paramNotificationBar.click_after_close) {
                ChatRoomStateView.a(ChatRoomStateView.this, paramNotificationBar, 2);
              }
              a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(276258);
              return;
              label178:
              com.tencent.mm.plugin.game.chatroom.e.a(ChatRoomStateView.g(ChatRoomStateView.this), paramNotificationBar.jump_info, 0, null);
            }
          }
        });
      }
      Integer localInteger;
      if (paramNotificationBar.background_color != null)
      {
        localInteger = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(paramNotificationBar.background_color.dark_color));
        if (localInteger != null) {
          ((GradientDrawable)this.Ipx.getBackground()).setColor(localInteger.intValue());
        }
      }
      if (!Util.isNullOrNil(paramNotificationBar.left_icon_url))
      {
        this.Ipy.setVisibility(0);
        if ((!(this.Ipy.getTag() instanceof String)) || (!this.Ipy.getTag().equals(paramNotificationBar.left_icon_url)))
        {
          this.Ipy.setTag(paramNotificationBar.left_icon_url);
          l(this.Ipy, paramNotificationBar.left_icon_url);
        }
      }
      for (;;)
      {
        this.Ipz.setText(paramNotificationBar.wording);
        if (paramNotificationBar.word_color != null)
        {
          localInteger = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(paramNotificationBar.word_color.dark_color));
          if (localInteger != null) {
            this.Ipz.setTextColor(localInteger.intValue());
          }
        }
        if (Util.isNullOrNil(paramNotificationBar.right_icon_url)) {
          break label572;
        }
        this.IpA.setVisibility(0);
        if ((!(this.IpA.getTag() instanceof String)) || (!this.IpA.getTag().equals(paramNotificationBar.right_icon_url)))
        {
          this.IpA.setTag(paramNotificationBar.right_icon_url);
          l(this.IpA, paramNotificationBar.right_icon_url);
        }
        this.IpA.setClickable(false);
        if (!paramNotificationBar.right_icon_can_close) {
          break;
        }
        this.IpA.setClickable(true);
        this.IpA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(276255);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ChatRoomStateView.a(ChatRoomStateView.this, paramNotificationBar, 3);
            a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(276255);
          }
        });
        break;
        this.Ipy.setVisibility(8);
      }
      label572:
      this.IpA.setVisibility(8);
    }
  }
  
  public final void fDs()
  {
    AppMethodBeat.i(276363);
    if (!Util.isNullOrNil(this.IpE))
    {
      this.IpB.setTextColor(this.mContext.getResources().getColor(h.b.BW_100_Alpha_0_5));
      this.IpB.setText(this.IpE);
      this.IpB.setVisibility(0);
      this.IpB.setTag(Integer.valueOf(1));
    }
    AppMethodBeat.o(276363);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(276329);
    super.onAttachedToWindow();
    AppMethodBeat.o(276329);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(276337);
    super.onDetachedFromWindow();
    if (this.IpF != null) {
      this.IpF.stopTimer();
    }
    if (this.IpG != null) {
      this.IpG.stopTimer();
    }
    AppMethodBeat.o(276337);
  }
  
  public void setPremadeCardInfo(String paramString)
  {
    AppMethodBeat.i(276321);
    this.Ipw.setPremadeCardInfo(paramString);
    AppMethodBeat.o(276321);
  }
  
  public void setStateChangeListener(com.tencent.mm.plugin.game.chatroom.b.e parame)
  {
    AppMethodBeat.i(276324);
    this.Ipw.setStateChangeListener(parame);
    AppMethodBeat.o(276324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomStateView
 * JD-Core Version:    0.7.0.1
 */