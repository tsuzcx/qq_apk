package com.tencent.mm.plugin.game.chatroom.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.be;
import com.tencent.mm.f.a.bf;
import com.tencent.mm.f.a.sp;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.game.autogen.chatroom.AtInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.Broadcast;
import com.tencent.mm.plugin.game.autogen.chatroom.BroadcastMessage;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomBanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomButton;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomPreloadInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.KickOutChatroomMemberResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.RealtimeControlInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SlotList;
import com.tencent.mm.plugin.game.autogen.chatroom.UserBanAction;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.c.j;
import com.tencent.mm.plugin.game.chatroom.c.k;
import com.tencent.mm.plugin.game.chatroom.c.n;
import com.tencent.mm.plugin.game.chatroom.c.o;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.game.chatroom.f.d;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView;
import com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.a;
import com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.b;
import com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.b.1;
import com.tencent.mm.plugin.game.chatroom.view.ChatRoomStateView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.1;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.2;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.b;
import com.tencent.mm.plugin.game.chatroom.view.JoinChatRoomConfirmView;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class GameChatRoomUI
  extends ChatRoomBaseUI
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.game.chatroom.b.a
{
  private long Cuy;
  private long Cuz;
  private String CvL;
  private boolean CvM;
  private ChatroomData CvN;
  private ChatroomUserData CvO;
  private Lbs CvP;
  private ImageView CvQ;
  private ImageView CvR;
  private ImageView CvS;
  private TextView CvT;
  private TextView CvU;
  private ChatRoomStateView CvV;
  private GameChatListView CvW;
  private TextView CvX;
  private View CvY;
  private GameChatCommentFooter CvZ;
  private JoinChatRoomConfirmView Cwa;
  private View Cwb;
  private com.tencent.mm.plugin.game.chatroom.g.c Cwd;
  private com.tencent.mm.plugin.game.chatroom.g.a Cwe;
  private boolean Cwf;
  private JumpInfo Cwg;
  private JumpInfo Cwh;
  private JumpInfo Cwi;
  private String Cwj;
  private View Cwk;
  private c.a Cwl;
  private IListener Cwm;
  private BroadcastReceiver Cwn;
  private View NSY;
  private ChatroomButton NSZ;
  private String iSn;
  private String iZU;
  private Context mContext;
  private View mrI;
  private View sHR;
  
  public GameChatRoomUI()
  {
    AppMethodBeat.i(211491);
    this.Cwf = false;
    this.Cwm = new IListener() {};
    this.Cwn = new GameChatRoomUI.6(this);
    AppMethodBeat.o(211491);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Lbs paramLbs, boolean paramBoolean1, long paramLong1, long paramLong2, ActivityOptions paramActivityOptions, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(211494);
    if (!(paramContext instanceof Activity))
    {
      Log.i("GameChatRoom.GameChatRoomUI", "context is not activity");
      AppMethodBeat.o(211494);
      return;
    }
    Intent localIntent = new Intent(paramContext, GameChatRoomUI.class);
    localIntent.putExtra("chat_room_name", paramString1);
    localIntent.putExtra("chat_room_icon", paramString2);
    if (paramLbs != null) {}
    try
    {
      localIntent.putExtra("chat_room_lbs", paramLbs.toByteArray());
      label71:
      localIntent.putExtra("chat_room_auto_join", paramBoolean1);
      localIntent.putExtra("game_report_sourceid", paramLong2);
      localIntent.putExtra("game_report_ssid", paramLong1);
      localIntent.putExtra("back_to_room_list", paramBoolean2);
      localIntent.putExtra("disable_game_page_swipe", paramBoolean3);
      if (paramActivityOptions != null)
      {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt, paramActivityOptions.toBundle());
        AppMethodBeat.o(211494);
        return;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      ((Activity)paramContext).overridePendingTransition(com.tencent.mm.plugin.game.chatroom.f.a.CrW, com.tencent.mm.plugin.game.chatroom.f.a.CrY);
      AppMethodBeat.o(211494);
      return;
    }
    catch (IOException paramString1)
    {
      break label71;
    }
  }
  
  private void a(RealtimeControlInfo paramRealtimeControlInfo)
  {
    AppMethodBeat.i(211526);
    if ((paramRealtimeControlInfo == null) || (Util.nullAsNil(this.Cwj).equals(paramRealtimeControlInfo.version)))
    {
      AppMethodBeat.o(211526);
      return;
    }
    this.Cwj = paramRealtimeControlInfo.version;
    this.CvS.setVisibility(0);
    com.tencent.mm.plugin.game.chatroom.e.bL(this.iZU, false);
    Object localObject1 = "";
    if ((paramRealtimeControlInfo.chatroom_ban_action != null) && (paramRealtimeControlInfo.chatroom_ban_action.ban_action != null) && (paramRealtimeControlInfo.chatroom_ban_action.ban_action.type == 1)) {
      localObject1 = paramRealtimeControlInfo.chatroom_ban_action.ban_action.desc;
    }
    for (int j = 1;; j = 0)
    {
      Object localObject2;
      int i;
      if ((paramRealtimeControlInfo.user_ban_action != null) && (paramRealtimeControlInfo.user_ban_action.ban_action_list != null))
      {
        localObject2 = paramRealtimeControlInfo.user_ban_action.ban_action_list.iterator();
        for (i = 0; ((Iterator)localObject2).hasNext(); i = 1)
        {
          BanAction localBanAction = (BanAction)((Iterator)localObject2).next();
          if (localBanAction.type != 3) {
            break label498;
          }
          if (j != 0) {
            break label493;
          }
          localObject1 = localBanAction.desc;
        }
      }
      for (;;)
      {
        if ((j != 0) || (i != 0)) {
          aIU((String)localObject1);
        }
        while (!Util.isNullOrNil(paramRealtimeControlInfo.update_user_data_list))
        {
          localObject1 = paramRealtimeControlInfo.update_user_data_list.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ChatroomUserData)((Iterator)localObject1).next();
            ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).a((ChatroomUserData)localObject2);
          }
          evP();
        }
        Log.d("GameChatRoom.GameChatRoomUI", "user_chatroom_relation:%d", new Object[] { Integer.valueOf(paramRealtimeControlInfo.user_chatroom_relation) });
        if (paramRealtimeControlInfo.user_chatroom_relation == 3)
        {
          if (!this.Cwf)
          {
            this.Cwf = true;
            localObject1 = new o(this.iZU, 1, 0L);
            com.tencent.mm.kernel.h.aGY().a((q)localObject1, 0);
            if (Util.isNullOrNil(paramRealtimeControlInfo.kick_out_wording)) {}
            for (paramRealtimeControlInfo = this.mContext.getString(f.h.Cud);; paramRealtimeControlInfo = paramRealtimeControlInfo.kick_out_wording)
            {
              paramRealtimeControlInfo = new com.tencent.mm.ui.widget.a.f.a(this.mContext).bBl(paramRealtimeControlInfo).HL(false);
              paramRealtimeControlInfo.Qlf = true;
              paramRealtimeControlInfo.b(new f.c()
              {
                public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(210877);
                  GameChatRoomUI.this.hideVKB();
                  if (paramAnonymousBoolean) {
                    GameChatRoomUI.i(GameChatRoomUI.this);
                  }
                  GameChatRoomUI.m(GameChatRoomUI.this);
                  AppMethodBeat.o(210877);
                }
              }).icF().show();
              AppMethodBeat.o(211526);
              return;
            }
          }
        }
        else if (paramRealtimeControlInfo.user_chatroom_relation == 1)
        {
          if (this.Cwa != null)
          {
            this.Cwa.setVisibility(8);
            AppMethodBeat.o(211526);
          }
        }
        else
        {
          evO();
          this.Cwa.a(this.iSn, this.CvN, this.CvO, this.CvP, this.Cwg);
          this.CvS.setVisibility(8);
          com.tencent.mm.plugin.game.chatroom.e.bL(this.iZU, true);
        }
        AppMethodBeat.o(211526);
        return;
        label493:
        i = 1;
        break;
        label498:
        break;
        i = 0;
      }
    }
  }
  
  private void aIT(String paramString)
  {
    AppMethodBeat.i(211522);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211522);
      return;
    }
    if (this.CvQ.getTag() != null)
    {
      AppMethodBeat.o(211522);
      return;
    }
    this.CvQ.setTag(paramString);
    com.tencent.mm.plugin.game.d.e.eAa().a(null, paramString, null, new e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(292800);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          com.tencent.e.h.ZvG.be(new GameChatRoomUI.9.1(this, paramAnonymousBitmap));
        }
        AppMethodBeat.o(292800);
      }
    });
    AppMethodBeat.o(211522);
  }
  
  private void aIU(String paramString)
  {
    AppMethodBeat.i(211529);
    this.CvX.setClickable(false);
    TextView localTextView = this.CvX;
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = this.mContext.getString(f.h.Cue);
    }
    localTextView.setHint(str);
    this.NSY.setClickable(false);
    this.Cwb.setVisibility(4);
    AppMethodBeat.o(211529);
  }
  
  private void evO()
  {
    AppMethodBeat.i(211528);
    if ((this.CvZ != null) && (this.CvZ.getVisibility() != 8)) {
      this.CvZ.setVisibility(8);
    }
    AppMethodBeat.o(211528);
  }
  
  private void evP()
  {
    AppMethodBeat.i(211531);
    this.CvX.setClickable(true);
    this.CvX.setHint(f.h.Cum);
    this.NSY.setClickable(true);
    if ((this.NSZ != null) && (this.NSZ.button_jump_info != null))
    {
      this.Cwb.setVisibility(0);
      AppMethodBeat.o(211531);
      return;
    }
    this.Cwb.setVisibility(4);
    AppMethodBeat.o(211531);
  }
  
  private void evQ()
  {
    int i = 0;
    AppMethodBeat.i(211534);
    this.CvZ.setVisibility(8);
    finish();
    if ((getIntent().getBooleanExtra("back_to_room_list", false)) && (!com.tencent.mm.plugin.game.luggage.b.gp(this.mContext)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("from_find_more_friend", false);
      if (this.Cuz != 0L) {
        i = (int)this.Cuz;
      }
      for (;;)
      {
        localIntent.putExtra("game_report_from_scene", i);
        localIntent.putExtra("start_time", System.currentTimeMillis());
        localIntent.putExtra("disable_game_page_swipe", true);
        localIntent.putExtra("game_from_detail_back", true);
        localIntent.putExtra("game_report_sourceid", this.Cuz);
        localIntent.putExtra("game_report_ssid", this.Cuy);
        localIntent.putExtra("default_game_tab_chat_type", true);
        com.tencent.mm.by.c.b(this.mContext, "game", ".ui.GameCenterUI", localIntent);
        AppMethodBeat.o(211534);
        return;
        if (this.Cuy != 0L) {
          i = (int)this.Cuy;
        }
      }
    }
    overridePendingTransition(com.tencent.mm.plugin.game.chatroom.f.a.CrY, com.tencent.mm.plugin.game.chatroom.f.a.CrX);
    AppMethodBeat.o(211534);
  }
  
  private void evR()
  {
    AppMethodBeat.i(211535);
    if ((this.Cwh != null) && (!Util.isNullOrNil(this.Cwh.jump_url))) {
      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, this.Cwh.jump_url, null);
    }
    AppMethodBeat.o(211535);
  }
  
  public final void a(b.a parama, com.tencent.mm.cd.a parama1)
  {
    AppMethodBeat.i(211496);
    switch (7.Cwr[parama.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(211496);
        return;
      } while (!(parama1 instanceof ReceiveChatroomMsgResponse));
      localObject1 = (ReceiveChatroomMsgResponse)parama1;
      parama = this.CvW;
      parama1 = ((ReceiveChatroomMsgResponse)localObject1).msg_pack_list;
      localObject1 = ((ReceiveChatroomMsgResponse)localObject1).at_info;
      if ((parama.CyN) && (localObject1 != null) && (!Util.isNullOrNil(((AtInfo)localObject1).seq_list))) {
        parama.CyO.addAll(((AtInfo)localObject1).seq_list);
      }
      parama.w(parama1, 3);
      AppMethodBeat.o(211496);
      return;
    } while (!(parama1 instanceof GetChatroomRealtimeInfoResponse));
    parama = (GetChatroomRealtimeInfoResponse)parama1;
    Object localObject1 = this.CvV;
    Object localObject2 = parama.at_info;
    if ((localObject2 != null) && (!Util.isNullOrNil(((AtInfo)localObject2).seq_list))) {
      ((ChatRoomStateView)localObject1).CxE.addAll(((AtInfo)localObject2).seq_list);
    }
    localObject2 = parama.broadcast;
    label194:
    Object localObject3;
    if ((localObject2 == null) || (Util.isNullOrNil(((Broadcast)localObject2).message_list)))
    {
      ((ChatRoomStateView)localObject1).a(parama.notification_bar);
      if (parama.slot_list != null)
      {
        localObject2 = ((ChatRoomStateView)localObject1).Cxw;
        localObject1 = parama.slot_list.slot_list;
        localObject2 = ((ChatMemberListView)localObject2).CwE;
        if (localObject1 != null)
        {
          ((List)localObject1).add(ChatMemberListView.b(((ChatMemberListView.b)localObject2).CwL));
          localObject3 = new LinkedList();
          ((List)localObject3).addAll(((ChatMemberListView.b)localObject2).CwM);
          ((ChatMemberListView.b)localObject2).CwM.clear();
          ((ChatMemberListView.b)localObject2).CwM.addAll((Collection)localObject1);
          androidx.recyclerview.widget.h.a(new ChatMemberListView.a(((ChatMemberListView.b)localObject2).CwL, (List)localObject3, ((ChatMemberListView.b)localObject2).CwM)).a(new ChatMemberListView.b.1((ChatMemberListView.b)localObject2));
        }
      }
      if ((parama.slot_list == null) || (Util.isNullOrNil(parama.slot_list.head_desc))) {
        break label458;
      }
      this.CvU.setText(((GetChatroomRealtimeInfoResponse)parama1).slot_list.head_desc);
      this.CvU.setVisibility(0);
    }
    for (;;)
    {
      a(parama.control_info);
      break;
      localObject3 = (BroadcastMessage)((Broadcast)localObject2).message_list.get(0);
      Log.d("GameChatRoom.ChatRoomStateView", "parseBroadcast, broadcast list size:%d, firstContent:%s", new Object[] { Integer.valueOf(((Broadcast)localObject2).message_list.size()), ((BroadcastMessage)localObject3).wording });
      ((ChatRoomStateView)localObject1).Cxx.setText(((BroadcastMessage)localObject3).wording);
      ((ChatRoomStateView)localObject1).CxF.startTimer(2000L, 0L);
      break label194;
      label458:
      this.CvU.setText("");
      this.CvU.setVisibility(8);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(211518);
    GameChatCommentFooter localGameChatCommentFooter = this.CvZ;
    int i;
    String str2;
    String str1;
    int j;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      if (paramKeyEvent.getAction() == 0)
      {
        if (localGameChatCommentFooter.getCharAtCursor() != ' ') {
          break label126;
        }
        localGameChatCommentFooter.Cyu = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (localGameChatCommentFooter.Cyu))
      {
        localGameChatCommentFooter.Cyu = false;
        i = localGameChatCommentFooter.getSelectionStart();
        str2 = localGameChatCommentFooter.getLastText();
        str1 = str2.substring(0, i);
        j = str1.lastIndexOf('@');
        if ((j < str1.length()) && (j >= 0)) {
          break label135;
        }
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(211518);
      return bool;
      label126:
      localGameChatCommentFooter.Cyu = false;
      break;
      label135:
      str1 = str1.substring(0, j);
      str2 = str2.substring(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append(str2);
      localGameChatCommentFooter.setLastText(localStringBuilder.toString());
      localGameChatCommentFooter.kFl.setSelection(j);
    }
  }
  
  public final long evK()
  {
    return 1399L;
  }
  
  public final long evL()
  {
    return 13L;
  }
  
  public final long evM()
  {
    return this.Cuy;
  }
  
  public final long evN()
  {
    return this.Cuz;
  }
  
  public int getLayoutId()
  {
    return f.f.CtN;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(211508);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      paramIntent = new com.tencent.mm.plugin.game.chatroom.c.b(this.iZU);
      com.tencent.mm.kernel.h.aGY().a(paramIntent, 0);
      AppMethodBeat.o(211508);
      return;
    }
    if (paramInt1 == 12) {
      evR();
    }
    AppMethodBeat.o(211508);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(211504);
    GameChatCommentFooter localGameChatCommentFooter = this.CvZ;
    if (localGameChatCommentFooter.getVisibility() == 0) {
      localGameChatCommentFooter.setVisibility(8);
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        super.onBackPressed();
        evQ();
      }
      AppMethodBeat.o(211504);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211493);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Cwk = findViewById(f.e.action_bar_container);
    if ((this.Cwk == null) || (!com.tencent.mm.ui.statusbar.c.XMC)) {}
    Object localObject;
    for (;;)
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setActionbarColor(getContext().getResources().getColor(f.b.transparent));
      getSupportActionBar().hide();
      setNavigationbarColor(getResources().getColor(f.b.black));
      this.mContext = this;
      this.iZU = getIntent().getStringExtra("chat_room_name");
      if (!Util.isNullOrNil(this.iZU)) {
        break;
      }
      Log.i("GameChatRoom.GameChatRoomUI", "chat room name is null");
      evQ();
      AppMethodBeat.o(211493);
      return;
      paramBundle = com.tencent.mm.ui.statusbar.c.bA(this);
      localObject = new c.a()
      {
        public final void BF(int paramAnonymousInt)
        {
          AppMethodBeat.i(292785);
          GameChatRoomUI.f(GameChatRoomUI.this).setPadding(0, paramAnonymousInt, 0, 0);
          com.tencent.mm.ui.statusbar.d.e(GameChatRoomUI.this.getWindow());
          AppMethodBeat.o(292785);
        }
      };
      this.Cwl = ((c.a)localObject);
      paramBundle.a((c.a)localObject);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.e(getWindow());
    }
    this.mrI = findViewById(f.e.root_view);
    paramBundle = new com.tencent.mm.ui.statusbar.b(this);
    ((RelativeLayout)this.mrI).addView(paramBundle, new RelativeLayout.LayoutParams(-1, -1));
    paramBundle.addView(LayoutInflater.from(this).inflate(f.f.CtP, paramBundle, false), new FrameLayout.LayoutParams(-1, -1));
    com.tencent.mm.plugin.game.chatroom.b.CrK = false;
    this.Cuz = getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Cuy = getIntent().getLongExtra("game_report_ssid", 0L);
    paramBundle = com.tencent.mm.game.report.d.jTj;
    com.tencent.mm.game.report.d.LW(this.iZU);
    paramBundle = com.tencent.mm.game.report.d.jTj;
    com.tencent.mm.game.report.d.LX("");
    Log.i("GameChatRoom.GameChatRoomUI", "chat_room_name:%s", new Object[] { this.iZU });
    this.CvL = getIntent().getStringExtra("chat_room_icon");
    this.CvM = getIntent().getBooleanExtra("chat_room_auto_join", false);
    paramBundle = getIntent().getByteArrayExtra("chat_room_lbs");
    if ((paramBundle != null) && (paramBundle.length > 0)) {
      this.CvP = new Lbs();
    }
    try
    {
      this.CvP.parseFrom(paramBundle);
      label387:
      this.CvQ = ((ImageView)findViewById(f.e.Csl));
      localObject = this.CvQ;
      long l = System.currentTimeMillis();
      paramBundle = BitmapUtil.getBitmapNative(f.d.Csc);
      Log.i("GameChatRoom.GameChatUtils", "getDefaultChatRoomBg end, cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (paramBundle == null)
      {
        ((ImageView)localObject).setImageBitmap(paramBundle);
        this.CvQ.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(292801);
            Log.i("GameChatRoom.GameChatRoomUI", "mask bg height:%d, width:%d", new Object[] { Integer.valueOf(GameChatRoomUI.g(GameChatRoomUI.this).getHeight()), Integer.valueOf(GameChatRoomUI.g(GameChatRoomUI.this).getWidth()) });
            GameChatRoomUI.g(GameChatRoomUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GameChatRoomUI.a(GameChatRoomUI.this, GameChatRoomUI.h(GameChatRoomUI.this));
            AppMethodBeat.o(292801);
          }
        });
        this.CvR = ((ImageView)findViewById(f.e.Csr));
        this.CvR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(292806);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            GameChatRoomUI.i(GameChatRoomUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292806);
          }
        });
        this.CvS = ((ImageView)findViewById(f.e.Css));
        this.CvS.setOnClickListener(new GameChatRoomUI.12(this));
        this.CvT = ((TextView)findViewById(f.e.CsE));
        this.CvU = ((TextView)findViewById(f.e.CsD));
        this.CvV = ((ChatRoomStateView)findViewById(f.e.CsC));
        paramBundle = this.CvV;
        localObject = this.mrI;
        paramBundle.mrI = ((View)localObject);
        paramBundle.Cxx = ((TextView)((View)localObject).findViewById(f.e.Cse));
        paramBundle.Cxy = ((View)localObject).findViewById(f.e.Csp);
        paramBundle.Cxz = ((ImageView)((View)localObject).findViewById(f.e.Ctl));
        paramBundle.CxA = ((TextView)((View)localObject).findViewById(f.e.notification_content));
        paramBundle.CxB = ((ImageView)((View)localObject).findViewById(f.e.Ctm));
        paramBundle.CvW = ((GameChatListView)((View)localObject).findViewById(f.e.CsP));
        this.CvV.setChatRoomInfo(this.iZU);
        this.CvZ = ((GameChatCommentFooter)findViewById(f.e.comment_footer));
        this.CvW = ((GameChatListView)findViewById(f.e.CsP));
        paramBundle = this.CvW;
        localObject = this.mrI;
        paramBundle.CyG = ((TextView)((View)localObject).findViewById(f.e.Cts));
        if (paramBundle.CyG != null) {
          paramBundle.CyG.setOnClickListener(new GameChatListView.1(paramBundle));
        }
        paramBundle.CyH = ((TextView)((View)localObject).findViewById(f.e.Csk));
        paramBundle.CyH.setOnClickListener(new GameChatListView.2(paramBundle));
        this.CvW.setChatRoomInfo(this.iZU);
        this.sHR = findViewById(f.e.bottom_layout);
        this.CvY = findViewById(f.e.Cte);
        this.CvY.setOnClickListener(new GameChatRoomUI.13(this));
        this.CvX = ((TextView)findViewById(f.e.CsG));
        this.CvX.setOnClickListener(new GameChatRoomUI.14(this));
        this.CvX.setClickable(false);
        this.NSY = findViewById(f.e.emoji_btn);
        this.NSY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(212126);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            GameChatRoomUI.l(GameChatRoomUI.this).oG(0, 0);
            paramAnonymousView = com.tencent.mm.game.report.d.jTj;
            d.a.a(1L, 2L, GameChatRoomUI.d(GameChatRoomUI.this), GameChatRoomUI.e(GameChatRoomUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212126);
          }
        });
        this.NSY.setClickable(false);
        this.CvZ.setFooterActionListener(new GameChatRoomUI.3(this));
        paramBundle = this.CvZ;
        localObject = new MMEditText.a()
        {
          public final void onBack()
          {
            AppMethodBeat.i(211471);
            if (GameChatRoomUI.l(GameChatRoomUI.this).getVisibility() == 0)
            {
              GameChatRoomUI.l(GameChatRoomUI.this).setVisibility(8);
              AppMethodBeat.o(211471);
              return;
            }
            GameChatRoomUI.i(GameChatRoomUI.this);
            AppMethodBeat.o(211471);
          }
        };
        if (paramBundle.kFl != null) {
          paramBundle.kFl.setBackListener((MMEditText.a)localObject);
        }
        this.Cwa = ((JoinChatRoomConfirmView)findViewById(f.e.CsW));
        this.Cwb = findViewById(f.e.Cto);
        com.tencent.mm.kernel.h.aGY().a(4391, this);
        com.tencent.mm.kernel.h.aGY().a(4993, this);
        com.tencent.mm.kernel.h.aGY().a(4897, this);
        com.tencent.mm.kernel.h.aGY().a(4596, this);
        this.Cwd = new com.tencent.mm.plugin.game.chatroom.g.c(b.a.CrL, this);
        this.Cwe = new com.tencent.mm.plugin.game.chatroom.g.a(b.a.CrM, this);
        if (!this.CvM) {
          break label1254;
        }
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.i(this.iZU, this.CvP, false, this.Cuy, this.Cuz);
        com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      }
      for (;;)
      {
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.a(this.iZU);
        com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
        EventCenter.instance.addListener(this.Cwm);
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mm.game.ACTION_QUIT_CHAT_ROOM");
        registerReceiver(this.Cwn, paramBundle, com.tencent.mm.plugin.game.a.CfL, null);
        if (Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrr, Long.valueOf(0L))) == 0L) {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrr, Long.valueOf(Util.nowSecond()));
        }
        paramBundle = com.tencent.mm.game.report.d.jTj;
        d.a.e(0L, this.Cuy, this.Cuz);
        paramBundle = com.tencent.mm.game.report.d.jTj;
        d.a.a(0L, 1L, this.Cuy, this.Cuz);
        AppMethodBeat.o(211493);
        return;
        paramBundle = com.tencent.mm.plugin.game.chatroom.e.ab(paramBundle.copy(paramBundle.getConfig(), true));
        break;
        label1254:
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.b(this.iZU);
        com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      }
    }
    catch (IOException paramBundle)
    {
      break label387;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(211514);
    Object localObject = new sp();
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.ui.statusbar.c.bA(this).b(this.Cwl);
    super.onDestroy();
    localObject = new k(this.iZU);
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    localObject = this.CvZ;
    if (((GameChatCommentFooter)localObject).jPN != null)
    {
      Log.i("GameChatRoom.GameChatCommentFooter", "commentfooter release");
      ((GameChatCommentFooter)localObject).jPN.hjm();
      ((GameChatCommentFooter)localObject).jPN.destroy();
    }
    if (((GameChatCommentFooter)localObject).kFl != null) {
      ((GameChatCommentFooter)localObject).kFl.destroy();
    }
    com.tencent.mm.kernel.h.aGY().b(4391, this);
    com.tencent.mm.kernel.h.aGY().b(4993, this);
    com.tencent.mm.kernel.h.aGY().b(4897, this);
    com.tencent.mm.kernel.h.aGY().b(4596, this);
    EventCenter.instance.removeListener(this.Cwm);
    unregisterReceiver(this.Cwn);
    if (this.Cwd != null)
    {
      localObject = this.Cwd;
      Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "stopKeepAlive");
      ((com.tencent.mm.plugin.game.chatroom.g.c)localObject).puH = false;
      ((com.tencent.mm.plugin.game.chatroom.g.c)localObject).CuI = null;
      com.tencent.mm.kernel.h.aGY().b(4302, (com.tencent.mm.an.i)localObject);
    }
    if (this.Cwe != null)
    {
      localObject = this.Cwe;
      Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "stopKeepAlive");
      ((com.tencent.mm.plugin.game.chatroom.g.a)localObject).puH = false;
      ((com.tencent.mm.plugin.game.chatroom.g.a)localObject).CuI = null;
      com.tencent.mm.kernel.h.aGY().b(4316, (com.tencent.mm.an.i)localObject);
    }
    com.tencent.mm.plugin.game.luggage.h.destroy();
    com.tencent.mm.plugin.game.chatroom.b.CrK = false;
    localObject = this.iZU;
    com.tencent.mm.plugin.game.chatroom.b.CrJ.remove(localObject);
    AppMethodBeat.o(211514);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(211513);
    super.onPause();
    AppMethodBeat.o(211513);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(211511);
    super.onResume();
    AppMethodBeat.o(211511);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(211499);
    int i = paramq.getType();
    if (i == 4391)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (GetChatroomBaseInfoResponse)d.c.b(((com.tencent.mm.plugin.game.chatroom.c.b)paramq).jTk.lBS);
        this.CvO = paramString.current_user_data;
        this.CvN = paramString.current_chatroom_data;
        if ((this.CvO == null) || (this.CvN == null))
        {
          Log.i("GameChatRoom.GameChatRoomUI", "chatroom data is null");
          evQ();
          AppMethodBeat.o(211499);
          return;
        }
        if (paramString.preload_info != null)
        {
          this.Cwg = paramString.preload_info.preload_create_account_jump_info;
          this.Cwh = paramString.preload_info.preload_profile_jump_info;
        }
        this.Cwi = this.CvN.chatroom_member_jump_info;
        Object localObject1;
        if (this.CvV != null)
        {
          Object localObject2 = this.CvV;
          paramq = this.Cwh;
          localObject1 = this.Cwi;
          localObject2 = ((ChatRoomStateView)localObject2).Cxw;
          ((ChatMemberListView)localObject2).CwI = paramq;
          ((ChatMemberListView)localObject2).CwJ = ((JumpInfo)localObject1);
        }
        if (this.CvW != null) {
          this.CvW.setPreloadInfo(this.Cwh);
        }
        evR();
        paramq = com.tencent.mm.game.report.d.jTj;
        com.tencent.mm.game.report.d.LX(this.CvN.appid);
        this.NSZ = paramString.chatroom_button;
        if ((this.NSZ != null) && (this.NSZ.button_jump_info != null))
        {
          this.Cwb.setVisibility(0);
          this.Cwb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(210904);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              long l;
              if (!com.tencent.mm.plugin.game.chatroom.e.aIP(GameChatRoomUI.a(GameChatRoomUI.this))) {
                switch (com.tencent.mm.plugin.game.chatroom.e.a(GameChatRoomUI.b(GameChatRoomUI.this), GameChatRoomUI.c(GameChatRoomUI.this).button_jump_info, 0, null))
                {
                default: 
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(210904);
                  return;
                case 1: 
                  l = 6L;
                }
              }
              for (;;)
              {
                paramAnonymousView = com.tencent.mm.game.report.d.jTj;
                d.a.a(2L, l, GameChatRoomUI.d(GameChatRoomUI.this), GameChatRoomUI.e(GameChatRoomUI.this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(210904);
                return;
                l = 7L;
                continue;
                l = 28L;
              }
            }
          });
        }
        for (;;)
        {
          this.CvL = this.CvN.chatroom_icon;
          aIT(this.CvL);
          this.iSn = this.CvO.username;
          ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(this.CvO);
          paramq = ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).aIN(this.iSn);
          if (paramq != null)
          {
            this.CvW.setHostContact(paramq);
            this.CvZ.setCanAtAll(paramq.evA());
          }
          this.CvT.setText(l.c(this, this.CvN.room_name));
          if (!this.Cwd.puH)
          {
            paramq = this.Cwd;
            localObject1 = this.iZU;
            paramq.puH = true;
            Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "startKeepAlive chatroomName：%s, seq: %d", new Object[] { localObject1, Long.valueOf(0L) });
            com.tencent.mm.kernel.h.aGY().a(4302, paramq);
            paramq.ay((String)localObject1, 0L);
          }
          if (!this.Cwe.puH)
          {
            paramq = this.Cwe;
            localObject1 = this.iZU;
            paramq.puH = true;
            Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "startKeepAlive chatroomName：%s, version: %s", new Object[] { localObject1, "" });
            com.tencent.mm.kernel.h.aGY().a(4316, paramq);
            paramq.hM((String)localObject1, "");
          }
          a(paramString.control_info);
          AppMethodBeat.o(211499);
          return;
          this.Cwb.setVisibility(4);
        }
      }
    }
    else if (i == 4993)
    {
      paramString = (SendChatroomMsgRequest)d.b.b(((n)paramq).jTk.lBR);
      if (paramString.msg_pack == null) {
        break label1019;
      }
    }
    label1013:
    label1016:
    label1019:
    for (paramString = paramString.msg_pack.cli_msg_id;; paramString = "")
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = this.CvW.CyC;
        paramq.ez(paramString, 0);
        paramq.CyV.remove(paramString);
        AppMethodBeat.o(211499);
        return;
      }
      this.CvW.CyC.ez(paramString, 2);
      AppMethodBeat.o(211499);
      return;
      if (i == 4897)
      {
        paramq = (JoinChatroomResponse)d.c.b(((com.tencent.mm.plugin.game.chatroom.c.i)paramq).jTk.lBS);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramq.need_jump_create_account)
          {
            com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, paramq.create_account_jump_info, 11, null);
            paramString = new com.tencent.mm.plugin.game.chatroom.c.b(this.iZU);
            com.tencent.mm.kernel.h.aGY().a(paramString, 0);
            AppMethodBeat.o(211499);
            return;
          }
          w.cR(this.mContext, MMApplicationContext.getResources().getString(f.h.Cua));
          this.Cwa.setVisibility(8);
          paramString = new com.tencent.mm.plugin.game.chatroom.c.b(this.iZU);
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
          paramString = new bf();
          paramString.fwX.opType = 1;
          paramString.fwX.fwY = this.iZU;
          EventCenter.instance.publish(paramString);
          AppMethodBeat.o(211499);
          return;
        }
        paramString = MMApplicationContext.getResources().getString(f.h.CtZ);
        if ((paramq == null) || (Util.isNullOrNil(paramq.errmsg))) {
          break label1016;
        }
        paramString = paramq.errmsg;
      }
      for (;;)
      {
        w.cS(this.mContext, paramString);
        if (this.Cwa.getVisibility() == 8)
        {
          paramString = new com.tencent.mm.plugin.game.chatroom.c.b(this.iZU);
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        }
        AppMethodBeat.o(211499);
        return;
        if (i == 4596)
        {
          paramq = (KickOutChatroomMemberResponse)d.c.b(((j)paramq).jTk.lBS);
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            w.cR(this.mContext, MMApplicationContext.getResources().getString(f.h.Cuc));
            AppMethodBeat.o(211499);
            return;
          }
          paramString = MMApplicationContext.getResources().getString(f.h.Cub);
          if ((paramq == null) || (Util.isNullOrNil(paramq.errmsg))) {
            break label1013;
          }
          paramString = paramq.errmsg;
        }
        for (;;)
        {
          w.cS(this.mContext, paramString);
          AppMethodBeat.o(211499);
          return;
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(211520);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Cwk != null))
    {
      this.Cwk.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.e(getWindow());
    }
    AppMethodBeat.o(211520);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(211515);
    if (!getIntent().getBooleanExtra("disable_game_page_swipe", false))
    {
      AppMethodBeat.o(211515);
      return true;
    }
    AppMethodBeat.o(211515);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI
 * JD-Core Version:    0.7.0.1
 */