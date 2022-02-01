package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.sp;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.Notification;
import com.tencent.mm.plugin.game.autogen.chatroom.NotificationBar;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatRoomStateView
  extends LinearLayout
{
  public GameChatListView CvW;
  public TextView CxA;
  public ImageView CxB;
  private List<Integer> CxC;
  private Notification CxD;
  public Set<Long> CxE;
  public MTimerHandler CxF;
  private MTimerHandler CxG;
  private IListener CxH;
  public ChatMemberListView Cxw;
  public TextView Cxx;
  public View Cxy;
  public ImageView Cxz;
  private String iZU;
  private Context mContext;
  public View mrI;
  
  public ChatRoomStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210671);
    this.CxC = new CopyOnWriteArrayList();
    this.CxE = new TreeSet(new Comparator() {});
    this.CxF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(210743);
        ChatRoomStateView.a(ChatRoomStateView.this).setText("");
        AppMethodBeat.o(210743);
        return true;
      }
    }, false);
    this.CxG = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(212584);
        if (ChatRoomStateView.b(ChatRoomStateView.this) != null) {
          ChatRoomStateView.b(ChatRoomStateView.this).setVisibility(8);
        }
        ChatRoomStateView.c(ChatRoomStateView.this);
        AppMethodBeat.o(212584);
        return true;
      }
    }, false);
    this.CxH = new IListener() {};
    bv(paramContext);
    AppMethodBeat.o(210671);
  }
  
  public ChatRoomStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210672);
    this.CxC = new CopyOnWriteArrayList();
    this.CxE = new TreeSet(new Comparator() {});
    this.CxF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(210743);
        ChatRoomStateView.a(ChatRoomStateView.this).setText("");
        AppMethodBeat.o(210743);
        return true;
      }
    }, false);
    this.CxG = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(212584);
        if (ChatRoomStateView.b(ChatRoomStateView.this) != null) {
          ChatRoomStateView.b(ChatRoomStateView.this).setVisibility(8);
        }
        ChatRoomStateView.c(ChatRoomStateView.this);
        AppMethodBeat.o(212584);
        return true;
      }
    }, false);
    this.CxH = new IListener() {};
    bv(paramContext);
    AppMethodBeat.o(210672);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(210677);
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(f.f.CtD, this);
    this.Cxw = ((ChatMemberListView)findViewById(f.e.CsF));
    AppMethodBeat.o(210677);
  }
  
  private static void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(210678);
    com.tencent.mm.plugin.game.d.e.eAa().o(paramImageView, paramString);
    AppMethodBeat.o(210678);
  }
  
  public final void a(final NotificationBar paramNotificationBar)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210676);
        if ((paramNotificationBar == null) || (Util.isNullOrNil(paramNotificationBar.notification_list)))
        {
          AppMethodBeat.o(210676);
          return;
        }
        paramNotificationBar = (Notification)paramNotificationBar.notification_list.get(0);
        if (this.CxC.contains(Integer.valueOf(paramNotificationBar.id)))
        {
          Log.i("GameChatRoom.ChatRoomStateView", "duplicate notification id:%d", new Object[] { Integer.valueOf(paramNotificationBar.id) });
          AppMethodBeat.o(210676);
          continue;
        }
        if (this.CxD == null) {
          break;
        }
      }
      finally {}
      if (this.CxD.priority <= paramNotificationBar.priority) {
        break;
      }
      Log.i("GameChatRoom.ChatRoomStateView", "new noticationId[%d] priority[%d] < showing notificationId[%d] priority[%d]", new Object[] { Integer.valueOf(paramNotificationBar.id), Integer.valueOf(paramNotificationBar.priority), Integer.valueOf(this.CxD.id), Integer.valueOf(this.CxD.priority) });
      AppMethodBeat.o(210676);
    }
    if ((this.mrI == null) || (paramNotificationBar == null)) {}
    for (;;)
    {
      this.CxG.startTimer(paramNotificationBar.disappear_second * 1000, 0L);
      AppMethodBeat.o(210676);
      break;
      Log.d("GameChatRoom.ChatRoomStateView", "show notification id:%d", new Object[] { Integer.valueOf(paramNotificationBar.id) });
      this.CxD = paramNotificationBar;
      this.Cxy.setVisibility(0);
      this.Cxy.setClickable(false);
      if (paramNotificationBar.jump_info != null)
      {
        this.Cxy.setClickable(true);
        this.Cxy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(211986);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (!com.tencent.mm.plugin.game.chatroom.e.aIP(ChatRoomStateView.d(ChatRoomStateView.this)))
            {
              com.tencent.mm.plugin.game.chatroom.e.a(ChatRoomStateView.e(ChatRoomStateView.this), paramNotificationBar.jump_info, 0, null);
              if (paramNotificationBar.click_after_close) {
                ChatRoomStateView.a(ChatRoomStateView.this, paramNotificationBar, 2);
              }
            }
            a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(211986);
          }
        });
      }
      int i;
      if (paramNotificationBar.background_color != null)
      {
        i = com.tencent.mm.plugin.game.chatroom.e.aIQ(Util.nullAsNil(paramNotificationBar.background_color.dark_color));
        if (i != -1) {
          ((GradientDrawable)this.Cxy.getBackground()).setColor(i);
        }
      }
      if (!Util.isNullOrNil(paramNotificationBar.left_icon_url))
      {
        this.Cxz.setVisibility(0);
        if ((!(this.Cxz.getTag() instanceof String)) || (!this.Cxz.getTag().equals(paramNotificationBar.left_icon_url)))
        {
          this.Cxz.setTag(paramNotificationBar.left_icon_url);
          i(this.Cxz, paramNotificationBar.left_icon_url);
        }
      }
      for (;;)
      {
        this.CxA.setText(paramNotificationBar.wording);
        if (paramNotificationBar.word_color != null)
        {
          i = com.tencent.mm.plugin.game.chatroom.e.aIQ(Util.nullAsNil(paramNotificationBar.word_color.dark_color));
          if (i != -1) {
            this.CxA.setTextColor(i);
          }
        }
        if (Util.isNullOrNil(paramNotificationBar.right_icon_url)) {
          break label568;
        }
        this.CxB.setVisibility(0);
        if ((!(this.CxB.getTag() instanceof String)) || (!this.CxB.getTag().equals(paramNotificationBar.right_icon_url)))
        {
          this.CxB.setTag(paramNotificationBar.right_icon_url);
          i(this.CxB, paramNotificationBar.right_icon_url);
        }
        this.CxB.setClickable(false);
        if (!paramNotificationBar.right_icon_can_close) {
          break;
        }
        this.CxB.setClickable(true);
        this.CxB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(211641);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            ChatRoomStateView.a(ChatRoomStateView.this, paramNotificationBar, 3);
            a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomStateView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(211641);
          }
        });
        break;
        this.Cxz.setVisibility(8);
      }
      label568:
      this.CxB.setVisibility(8);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(210674);
    super.onAttachedToWindow();
    EventCenter.instance.addListener(this.CxH);
    AppMethodBeat.o(210674);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(210675);
    super.onDetachedFromWindow();
    EventCenter.instance.removeListener(this.CxH);
    AppMethodBeat.o(210675);
  }
  
  public void setChatRoomInfo(String paramString)
  {
    AppMethodBeat.i(210673);
    this.iZU = paramString;
    this.Cxw.setChatRoomName(paramString);
    AppMethodBeat.o(210673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomStateView
 * JD-Core Version:    0.7.0.1
 */