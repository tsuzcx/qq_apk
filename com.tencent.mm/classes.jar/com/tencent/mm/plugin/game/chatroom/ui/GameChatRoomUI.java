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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.api.t;
import com.tencent.mm.autogen.a.bk;
import com.tencent.mm.autogen.a.bk.a;
import com.tencent.mm.autogen.a.bl;
import com.tencent.mm.autogen.a.nb;
import com.tencent.mm.autogen.a.pr;
import com.tencent.mm.autogen.a.xo;
import com.tencent.mm.b.o;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.Broadcast;
import com.tencent.mm.plugin.game.autogen.chatroom.BroadcastMessage;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomBanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomButton;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomEnterInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomPanel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomPreloadInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.EnterLeadSpeakInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ExportExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.FirstEnterNotify;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomPanelResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.KickOutCardInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgBaseInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import com.tencent.mm.plugin.game.autogen.chatroom.PremadeCardInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.RealtimeControlInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.RobotInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.SlotList;
import com.tencent.mm.plugin.game.autogen.chatroom.TeamIcon;
import com.tencent.mm.plugin.game.autogen.chatroom.UserBanAction;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.b.d;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.c.n;
import com.tencent.mm.plugin.game.chatroom.channel.ChatChannelFragment;
import com.tencent.mm.plugin.game.chatroom.channel.ChatChannelPage;
import com.tencent.mm.plugin.game.chatroom.channel.ChatChannelPage.4;
import com.tencent.mm.plugin.game.chatroom.f.a;
import com.tencent.mm.plugin.game.chatroom.h.a;
import com.tencent.mm.plugin.game.chatroom.h.c;
import com.tencent.mm.plugin.game.chatroom.h.d;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView;
import com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.b;
import com.tencent.mm.plugin.game.chatroom.view.ChatRoomPanelController;
import com.tencent.mm.plugin.game.chatroom.view.ChatRoomStateView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.10;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.b;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.b;
import com.tencent.mm.plugin.game.chatroom.view.JoinConfirmView;
import com.tencent.mm.plugin.game.chatroom.view.PanelGridView;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class GameChatRoomUI
  extends ChatRoomBaseUI
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.game.chatroom.b.a
{
  private int IjF;
  private IListener IjM;
  private long IjY;
  private long Ijq;
  private long Ijr;
  private String ImB;
  private boolean ImC;
  private ChatroomData ImD;
  private ChatroomUserData ImE;
  private Lbs ImF;
  private ImageView ImG;
  private ImageView ImH;
  private ImageView ImI;
  private TextView ImJ;
  private TextView ImK;
  private ChatRoomStateView ImL;
  private ChatChannelPage ImM;
  private TextView ImN;
  private WeImageView ImO;
  private View ImP;
  private GameChatCommentFooter ImQ;
  private JoinConfirmView ImR;
  private View ImS;
  private TextView ImT;
  private View ImU;
  private ImageView ImV;
  private TextView ImW;
  private com.tencent.mm.plugin.game.chatroom.h.c ImX;
  private com.tencent.mm.plugin.game.chatroom.h.a ImY;
  private boolean ImZ;
  private boolean Ina;
  private JumpInfo Inb;
  private JumpInfo Inc;
  private JumpInfo Ind;
  private JumpInfo Ine;
  private ChatroomExternInfo Inf;
  private String Ing;
  private JumpInfo Inh;
  private String Ini;
  private ChatroomButton Inj;
  private boolean Ink;
  private int Inl;
  private boolean Inm;
  private boolean Inn;
  private String Ino;
  private ExportExternInfo Inp;
  private ChatroomEnterInfo Inq;
  private ChatroomPanel Inr;
  private boolean Ins;
  private boolean Int;
  private com.tencent.mm.plugin.game.chatroom.l.b Inu;
  private View Inv;
  private c.a Inw;
  private IListener Inx;
  private BroadcastReceiver Iny;
  private IListener Inz;
  private String lBQ;
  private String luk;
  private Context mContext;
  private View plc;
  private View vNn;
  private boolean xHi;
  
  public GameChatRoomUI()
  {
    AppMethodBeat.i(276108);
    this.IjF = -1;
    this.IjY = -1L;
    this.ImZ = false;
    this.Ina = false;
    this.Ink = false;
    this.Inl = 0;
    this.Inm = false;
    this.Inn = true;
    this.xHi = false;
    this.Ins = false;
    this.Int = false;
    this.Inx = new IListener(com.tencent.mm.app.f.hfK) {};
    this.IjM = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Iny = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(276025);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_QUIT_CHAT_ROOM".equals(paramAnonymousIntent.getAction())) && (GameChatRoomUI.this != null) && (!GameChatRoomUI.this.isFinishing()))
        {
          paramAnonymousContext = paramAnonymousIntent.getStringExtra("chatroom_name");
          if (Util.nullAsNil(GameChatRoomUI.a(GameChatRoomUI.this)).equals(paramAnonymousContext))
          {
            Log.i("GameChatRoom.GameChatRoomUI", "GameChatRoomUI exit!");
            GameChatRoomUI.j(GameChatRoomUI.this);
          }
        }
        AppMethodBeat.o(276025);
      }
    };
    this.Inz = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(276108);
  }
  
  private void a(int paramInt1, int paramInt2, MsgOptions paramMsgOptions, MsgContent paramMsgContent)
  {
    AppMethodBeat.i(276184);
    b.d locald = new b.d();
    locald.userName = this.luk;
    locald.hBy = this.lBQ;
    locald.msgType = paramInt1;
    locald.channelId = paramInt2;
    if (paramMsgOptions != null)
    {
      locald.Iee = paramMsgOptions;
      if ((!Util.isNullOrNil(locald.Iee.at_list)) && (locald.Iee.at_list.contains(getString(h.h.Iiq)))) {
        com.tencent.mm.plugin.game.chatroom.k.a.aFF(this.lBQ);
      }
    }
    locald.Ief = paramMsgContent;
    paramMsgOptions = new com.tencent.mm.plugin.game.chatroom.c.p(locald);
    com.tencent.mm.kernel.h.aZW().a(paramMsgOptions, 0);
    paramMsgOptions = this.ImM;
    if (paramMsgOptions.IjQ != null)
    {
      Iterator localIterator = paramMsgOptions.IjQ.Ijz.iterator();
      while (localIterator.hasNext())
      {
        paramMsgOptions = (ChatChannelFragment)localIterator.next();
        if ((paramMsgOptions.IjA != null) && (paramMsgOptions.xVI))
        {
          GameChatListView localGameChatListView = paramMsgOptions.IjA;
          localGameChatListView.IqW.IrA.put(locald.Ied, locald);
          ChatroomMsgPack localChatroomMsgPack = new ChatroomMsgPack();
          localChatroomMsgPack.msg_type = locald.msgType;
          localChatroomMsgPack.from_username = locald.userName;
          localChatroomMsgPack.cli_msg_id = locald.Ied;
          localChatroomMsgPack.send_time = (System.currentTimeMillis() / 1000L);
          localChatroomMsgPack.msg_content = locald.Ief;
          paramMsgContent = locald.Iee;
          paramMsgOptions = paramMsgContent;
          if (paramMsgContent == null) {
            paramMsgOptions = new MsgOptions();
          }
          paramMsgOptions.cli_local_data = new com.tencent.mm.bx.b(o.dV(localGameChatListView.IqX << 4 | 0x1));
          localChatroomMsgPack.msg_options = paramMsgOptions;
          localChatroomMsgPack.channel_id = locald.channelId;
          localGameChatListView.IqX += 1;
          paramMsgOptions = new LinkedList();
          paramMsgOptions.add(localChatroomMsgPack);
          localGameChatListView.a(paramMsgOptions, 5, null);
        }
      }
    }
    AppMethodBeat.o(276184);
  }
  
  private void a(final RealtimeControlInfo paramRealtimeControlInfo)
  {
    AppMethodBeat.i(276167);
    if ((paramRealtimeControlInfo == null) || (Util.nullAsNil(this.Ini).equals(paramRealtimeControlInfo.version)))
    {
      AppMethodBeat.o(276167);
      return;
    }
    this.Ini = paramRealtimeControlInfo.version;
    this.ImI.setVisibility(0);
    com.tencent.mm.plugin.game.chatroom.e.cf(this.lBQ, false);
    this.Ink = paramRealtimeControlInfo.disable_emoji;
    Object localObject1;
    Object localObject2;
    if (!Util.isNullOrNil(paramRealtimeControlInfo.update_user_data_list))
    {
      localObject1 = paramRealtimeControlInfo.update_user_data_list.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ChatroomUserData)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a((ChatroomUserData)localObject2);
      }
      this.Inu.a(paramRealtimeControlInfo.update_user_data_list, this.ImD.admin_info);
      localObject1 = ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).aFo(this.luk);
      if (localObject1 != null)
      {
        this.ImM.setHostContact((com.tencent.mm.plugin.game.chatroom.b.c)localObject1);
        this.ImQ.setCanAtAll(((com.tencent.mm.plugin.game.chatroom.b.c)localObject1).fCv());
      }
    }
    Log.d("GameChatRoom.GameChatRoomUI", "user_chatroom_relation:%d", new Object[] { Integer.valueOf(paramRealtimeControlInfo.user_chatroom_relation) });
    final boolean bool;
    label312:
    Object localObject3;
    if (paramRealtimeControlInfo.user_chatroom_relation == 3)
    {
      this.Inu.fDN();
      if (!this.ImZ)
      {
        this.ImZ = true;
        localObject1 = new com.tencent.mm.plugin.game.chatroom.c.s(this.lBQ, 1, 0L);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        if (Util.isNullOrNil(paramRealtimeControlInfo.kick_out_wording))
        {
          localObject1 = this.mContext.getString(h.h.Iiw);
          if ((paramRealtimeControlInfo.kick_out_card_info != null) && (!Util.isNullOrNil(paramRealtimeControlInfo.kick_out_card_info.right_button_wording))) {
            break label665;
          }
          bool = true;
          localObject2 = new com.tencent.mm.ui.widget.a.g.a(this.mContext);
          localObject3 = ((com.tencent.mm.ui.widget.a.g.a)localObject2).bDE((String)localObject1).NF(false);
          ((com.tencent.mm.ui.widget.a.g.a)localObject3).Xdm = true;
          if (!bool) {
            break label671;
          }
          localObject1 = this.mContext.getString(h.h.app_i_known);
          label361:
          ((com.tencent.mm.ui.widget.a.g.a)localObject3).bDI((String)localObject1).b(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(275992);
              GameChatRoomUI.this.hideVKB();
              GameChatRoomUI.j(GameChatRoomUI.this);
              GameChatRoomUI.f(GameChatRoomUI.this);
              if ((!bool) && (paramRealtimeControlInfo.kick_out_card_info != null)) {
                com.tencent.mm.plugin.game.chatroom.e.a(GameChatRoomUI.c(GameChatRoomUI.this), paramRealtimeControlInfo.kick_out_card_info.right_button_jump_info, 0, null);
              }
              AppMethodBeat.o(275992);
            }
          });
          if (!bool)
          {
            ((com.tencent.mm.ui.widget.a.g.a)localObject2).Xdm = false;
            ((com.tencent.mm.ui.widget.a.g.a)localObject2).bDJ(this.mContext.getString(h.h.app_i_known)).a(new g.c()
            {
              public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(275988);
                GameChatRoomUI.this.hideVKB();
                GameChatRoomUI.j(GameChatRoomUI.this);
                GameChatRoomUI.f(GameChatRoomUI.this);
                AppMethodBeat.o(275988);
              }
            });
          }
          ((com.tencent.mm.ui.widget.a.g.a)localObject2).jHM().show();
        }
      }
      else
      {
        label429:
        if ((paramRealtimeControlInfo.premade_card_info != null) && (paramRealtimeControlInfo.premade_card_info.team_icon_info != null))
        {
          fDe();
          this.ImT.setText(paramRealtimeControlInfo.premade_card_info.team_icon_info.desc);
          this.Inh = paramRealtimeControlInfo.premade_card_info.team_icon_info.jump_info;
          this.Ing = paramRealtimeControlInfo.premade_card_info.premade_info;
          if (this.ImL != null) {
            this.ImL.setPremadeCardInfo(this.Ing);
          }
          if (this.ImM != null) {
            this.ImM.setPremadeCardInfo(this.Ing);
          }
        }
        localObject1 = "";
        if ((paramRealtimeControlInfo.chatroom_ban_action == null) || (paramRealtimeControlInfo.chatroom_ban_action.ban_action == null) || (paramRealtimeControlInfo.chatroom_ban_action.ban_action.type != 1)) {
          break label886;
        }
        localObject1 = paramRealtimeControlInfo.chatroom_ban_action.ban_action.desc;
      }
    }
    label665:
    label671:
    label873:
    label878:
    label886:
    for (int j = 1;; j = 0)
    {
      int i;
      if ((paramRealtimeControlInfo.user_ban_action != null) && (paramRealtimeControlInfo.user_ban_action.ban_action_list != null))
      {
        localObject2 = paramRealtimeControlInfo.user_ban_action.ban_action_list.iterator();
        i = 0;
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (BanAction)((Iterator)localObject2).next();
            if (((BanAction)localObject3).type != 3) {
              break label878;
            }
            if (j != 0) {
              break label873;
            }
            localObject1 = ((BanAction)localObject3).desc;
            i = 1;
            continue;
            localObject1 = paramRealtimeControlInfo.kick_out_wording;
            break;
            bool = false;
            break label312;
            localObject1 = paramRealtimeControlInfo.kick_out_card_info.right_button_wording;
            break label361;
            if (paramRealtimeControlInfo.user_chatroom_relation == 1)
            {
              if (this.ImR != null) {
                this.ImR.setVisibility(8);
              }
              fDb();
              break label429;
            }
            fDc();
            if (this.ImR.getVisibility() != 0)
            {
              this.ImR.setVisibility(0);
              if (this.Inq == null) {
                break label790;
              }
              this.ImR.a(this.Inq, this.ImD, this.ImE, this.ImF, this.Inb);
            }
            for (;;)
            {
              this.ImI.setVisibility(8);
              com.tencent.mm.plugin.game.chatroom.e.cf(this.lBQ, true);
              break;
              this.ImR.b(this.luk, this.ImD, this.ImE, this.ImF, this.Inb, this.Inf);
            }
          }
        }
      }
      for (;;)
      {
        if ((j != 0) || (i != 0))
        {
          this.Inm = false;
          aFD((String)localObject1);
        }
        for (;;)
        {
          this.ImQ.setShowCustom(paramRealtimeControlInfo.enable_custom_emoji);
          AppMethodBeat.o(276167);
          return;
          this.Inm = true;
          fDd();
        }
        i = 1;
        break;
        break;
        i = 0;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, Lbs paramLbs, boolean paramBoolean1, long paramLong1, long paramLong2, ActivityOptions paramActivityOptions, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, Bundle paramBundle, int paramInt2, long paramLong3)
  {
    AppMethodBeat.i(276122);
    if (!(paramContext instanceof Activity))
    {
      Log.i("GameChatRoom.GameChatRoomUI", "context is not activity");
      AppMethodBeat.o(276122);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.game.chatroom.e.wd(false);
    if ((com.tencent.mm.plugin.game.chatroom.b.IdS) && (!bool))
    {
      Log.i("GameChatRoom.GameChatRoomUI", "We are only allowed one chatroom at a time");
      AppMethodBeat.o(276122);
      return false;
    }
    Intent localIntent = new Intent();
    if (com.tencent.mm.plugin.game.chatroom.e.fCo())
    {
      localIntent.setClass(paramContext, GameChatRoomAffinityUI.class);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.putExtra("chat_room_name", paramString1);
      localIntent.putExtra("chat_room_icon", paramString2);
      if (paramLbs != null) {}
      try
      {
        localIntent.putExtra("chat_room_lbs", paramLbs.toByteArray());
        label148:
        localIntent.putExtra("chat_room_auto_join", paramBoolean1);
        localIntent.putExtra("game_report_sourceid", paramLong2);
        localIntent.putExtra("game_report_ssid", paramLong1);
        localIntent.putExtra("back_to_room_list", paramBoolean2);
        localIntent.putExtra("disable_game_page_swipe", paramBoolean3);
        localIntent.putExtra("target_channel_id", paramInt2);
        localIntent.putExtra("target_seq", paramLong3);
        if (paramActivityOptions != null)
        {
          localIntent.putExtra("need_exit_anim", true);
          ((Activity)paramContext).startActivityForResult(localIntent, paramInt1, paramActivityOptions.toBundle());
        }
        for (;;)
        {
          AppMethodBeat.o(276122);
          return true;
          localIntent.setClass(paramContext, GameChatRoomUI.class);
          break;
          com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI", "enterGameChatRoom", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;ZJJLandroid/app/ActivityOptions;ZZILandroid/os/Bundle;IJ)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
          ((Activity)paramContext).overridePendingTransition(MMFragmentActivity.a.adFr, MMFragmentActivity.a.adFs);
        }
      }
      catch (IOException paramString1)
      {
        break label148;
      }
    }
  }
  
  private void aFC(String paramString)
  {
    AppMethodBeat.i(276143);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(276143);
      return;
    }
    if (this.ImG.getTag() != null)
    {
      AppMethodBeat.o(276143);
      return;
    }
    this.ImG.setTag(paramString);
    com.tencent.mm.plugin.game.d.e.fIb().a(null, paramString, null, new e.b()
    {
      public final void a(View paramAnonymousView, final Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(276040);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276009);
              final Bitmap localBitmap = com.tencent.mm.plugin.game.chatroom.e.c(paramAnonymousBitmap, GameChatRoomUI.h(GameChatRoomUI.this).getHeight(), GameChatRoomUI.h(GameChatRoomUI.this).getWidth());
              if (localBitmap != null)
              {
                Log.i("GameChatRoom.GameChatRoomUI", "resultBitmap height:%d, width:%d", new Object[] { Integer.valueOf(localBitmap.getHeight()), Integer.valueOf(localBitmap.getWidth()) });
                com.tencent.threadpool.h.ahAA.bk(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(276003);
                    GameChatRoomUI.h(GameChatRoomUI.this).setImageBitmap(localBitmap);
                    AppMethodBeat.o(276003);
                  }
                });
              }
              AppMethodBeat.o(276009);
            }
          });
        }
        AppMethodBeat.o(276040);
      }
    });
    AppMethodBeat.o(276143);
  }
  
  private void aFD(String paramString)
  {
    AppMethodBeat.i(276199);
    this.ImN.setClickable(false);
    TextView localTextView = this.ImN;
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = this.mContext.getString(h.h.Iiy);
    }
    localTextView.setHint(str);
    this.ImN.setHintTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.BW_100_Alpha_0_5));
    this.ImO.setClickable(false);
    this.ImO.setIconColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.BW_100_Alpha_0_2));
    fDf();
    fDh();
    com.tencent.mm.plugin.game.chatroom.e.cg(this.lBQ, true);
    AppMethodBeat.o(276199);
  }
  
  private void destroy()
  {
    AppMethodBeat.i(276136);
    if (this.xHi)
    {
      AppMethodBeat.o(276136);
      return;
    }
    Log.i("GameChatRoom.GameChatRoomUI", "destroy()");
    this.xHi = true;
    com.tencent.mm.plugin.game.chatroom.b.IdQ = false;
    n localn = new n(this.lBQ);
    com.tencent.mm.kernel.h.aZW().a(localn, 0);
    com.tencent.mm.ui.statusbar.c.ch(this).b(this.Inw);
    this.ImQ.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(4391, this);
    com.tencent.mm.kernel.h.aZW().b(4993, this);
    com.tencent.mm.kernel.h.aZW().b(4897, this);
    com.tencent.mm.kernel.h.aZW().b(4596, this);
    com.tencent.mm.kernel.h.aZW().b(5072, this);
    f.a.fCp().release();
    this.Inx.dead();
    this.IjM.dead();
    this.Inz.dead();
    unregisterReceiver(this.Iny);
    if (this.ImX != null) {
      this.ImX.fCJ();
    }
    if (this.ImY != null) {
      this.ImY.fCJ();
    }
    com.tencent.mm.plugin.game.luggage.h.destroy();
    com.tencent.mm.plugin.game.chatroom.e.aFr(this.lBQ);
    com.tencent.mm.plugin.game.chatroom.b.IdS = false;
    if (!com.tencent.mm.plugin.game.chatroom.e.fCo()) {
      com.tencent.mm.plugin.game.chatroom.e.wd(true);
    }
    AppMethodBeat.o(276136);
  }
  
  private void fDb()
  {
    AppMethodBeat.i(276171);
    if ((this.ImD == null) || (this.ImE == null))
    {
      AppMethodBeat.o(276171);
      return;
    }
    this.Inu.a(this.ImD.chatroom_name, this.ImD.admin_info, this.ImE.can_at_all, this.ImE.username);
    AppMethodBeat.o(276171);
  }
  
  private void fDc()
  {
    AppMethodBeat.i(276193);
    if ((this.ImQ != null) && (this.ImQ.getVisibility() != 8)) {
      this.ImQ.setVisibility(8);
    }
    AppMethodBeat.o(276193);
  }
  
  private void fDd()
  {
    AppMethodBeat.i(276207);
    if ((this.Inm) && (this.Inn))
    {
      this.ImN.setClickable(true);
      localTextView = this.ImN;
      if (Util.isNullOrNil(this.Ino))
      {
        str = this.mContext.getString(h.h.IiP);
        localTextView.setHint(str);
        this.ImN.setHintTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.BW_100_Alpha_0_8));
        this.ImO.setClickable(true);
        this.ImO.setIconColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.White));
        if (this.Inh == null) {
          break label170;
        }
        fDe();
        if (this.Inr == null) {
          break label177;
        }
        fDg();
        com.tencent.mm.plugin.game.chatroom.e.cg(this.lBQ, false);
      }
    }
    label170:
    label177:
    while (!this.Inn) {
      for (;;)
      {
        if (!this.ImN.isClickable())
        {
          fDf();
          fDh();
        }
        AppMethodBeat.o(276207);
        return;
        str = this.Ino;
        continue;
        fDf();
        continue;
        fDh();
      }
    }
    TextView localTextView = this.ImN;
    if (Util.isNullOrNil(this.Ino)) {}
    for (String str = this.mContext.getString(h.h.IiP);; str = this.Ino)
    {
      localTextView.setHint(str);
      break;
    }
  }
  
  private void fDe()
  {
    AppMethodBeat.i(276214);
    this.ImS.setVisibility(0);
    this.Ins = true;
    AppMethodBeat.o(276214);
  }
  
  private void fDf()
  {
    AppMethodBeat.i(276219);
    View localView = this.ImS;
    if (this.Ins) {}
    for (int i = 4;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(276219);
      return;
    }
  }
  
  private void fDg()
  {
    AppMethodBeat.i(276224);
    this.ImU.setVisibility(0);
    this.Int = true;
    AppMethodBeat.o(276224);
  }
  
  private void fDh()
  {
    AppMethodBeat.i(276230);
    View localView = this.ImU;
    if (this.Int) {}
    for (int i = 4;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(276230);
      return;
    }
  }
  
  private boolean fDi()
  {
    AppMethodBeat.i(276245);
    if ((getIntent().getBooleanExtra("back_to_room_list", false)) && (!com.tencent.mm.plugin.game.luggage.b.fEl()) && (!com.tencent.mm.plugin.game.chatroom.e.m(this)))
    {
      AppMethodBeat.o(276245);
      return true;
    }
    AppMethodBeat.o(276245);
    return false;
  }
  
  private boolean fDj()
  {
    AppMethodBeat.i(276251);
    if ((com.tencent.mm.plugin.game.chatroom.e.hI(this)) && (!com.tencent.mm.plugin.game.chatroom.e.m(this)) && (com.tencent.mm.plugin.game.chatroom.e.fCo()))
    {
      AppMethodBeat.o(276251);
      return true;
    }
    AppMethodBeat.o(276251);
    return false;
  }
  
  private void fDk()
  {
    int i = 0;
    AppMethodBeat.i(276262);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_find_more_friend", false);
    if (this.Ijr != 0L) {
      i = (int)this.Ijr;
    }
    for (;;)
    {
      localIntent.putExtra("game_report_from_scene", i);
      localIntent.putExtra("start_time", System.currentTimeMillis());
      localIntent.putExtra("disable_game_page_swipe", true);
      localIntent.putExtra("game_from_detail_back", true);
      localIntent.putExtra("game_report_sourceid", this.Ijr);
      localIntent.putExtra("game_report_ssid", this.Ijq);
      localIntent.putExtra("default_game_tab_chat_type", true);
      if (fDj()) {
        localIntent.putExtra("game_from_chatroom_detail", true);
      }
      com.tencent.mm.br.c.b(this.mContext, "game", ".ui.GameCenterUI", localIntent);
      AppMethodBeat.o(276262);
      return;
      if (this.Ijq != 0L) {
        i = (int)this.Ijq;
      }
    }
  }
  
  private void fDl()
  {
    AppMethodBeat.i(276268);
    if ((this.Inc != null) && (!Util.isNullOrNil(this.Inc.jump_url))) {
      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, this.Inc.jump_url, null);
    }
    AppMethodBeat.o(276268);
  }
  
  private void fDm()
  {
    AppMethodBeat.i(276273);
    if ((this.Ind != null) && (!Util.isNullOrNil(this.Ind.jump_url))) {
      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, this.Ind.jump_url, null);
    }
    AppMethodBeat.o(276273);
  }
  
  private boolean wf(boolean paramBoolean)
  {
    AppMethodBeat.i(276242);
    this.ImQ.setVisibility(8);
    if (((!com.tencent.mm.plugin.game.chatroom.e.fCo()) || (!paramBoolean) || (!com.tencent.mm.plugin.game.chatroom.e.m(this))) && ((!com.tencent.mm.plugin.game.chatroom.e.fCo()) || (!paramBoolean) || (!com.tencent.mm.plugin.game.chatroom.e.hI(this)))) {
      com.tencent.mm.plugin.game.chatroom.e.fCo();
    }
    if (!fDi()) {
      if ((getIntent().getBooleanExtra("need_exit_anim", false)) && (!com.tencent.mm.plugin.game.chatroom.e.m(this)))
      {
        finish();
        overridePendingTransition(h.a.Iey, h.a.Iex);
      }
    }
    for (;;)
    {
      if (fDj()) {
        new xo().publish();
      }
      AppMethodBeat.o(276242);
      return false;
      if (com.tencent.mm.plugin.game.chatroom.e.m(this))
      {
        Object localObject = new Intent("android.intent.action.MAIN");
        ((Intent)localObject).setFlags(268435456);
        ((Intent)localObject).addCategory("android.intent.category.HOME");
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI", "finishPage", "(Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI", "finishPage", "(Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
      }
      else
      {
        finish();
        continue;
        finish();
        fDk();
      }
    }
  }
  
  public final void a(b.c paramc, com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(276496);
    switch (13.InI[paramc.ordinal()])
    {
    }
    Object localObject1;
    do
    {
      do
      {
        AppMethodBeat.o(276496);
        return;
      } while (!(parama instanceof ReceiveChatroomMsgResponse));
      localObject1 = (ReceiveChatroomMsgResponse)parama;
      localObject2 = this.ImM;
      paramc = ((ReceiveChatroomMsgResponse)localObject1).msg_pack_list;
      parama = ((ReceiveChatroomMsgResponse)localObject1).notice_msg_list;
      long l = ((ReceiveChatroomMsgResponse)localObject1).last_received_seq;
      localObject1 = ((ReceiveChatroomMsgResponse)localObject1).refresh_msg_pack_list;
      if (((ChatChannelPage)localObject2).IjQ != null)
      {
        localObject2 = ((ChatChannelPage)localObject2).IjQ.Ijz.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ChatChannelFragment localChatChannelFragment = (ChatChannelFragment)((Iterator)localObject2).next();
          if (localChatChannelFragment.IjA != null) {
            if (com.tencent.mm.plugin.game.chatroom.g.a.Xd(localChatChannelFragment.IjE))
            {
              localChatChannelFragment.IjA.a(paramc, parama, l, (List)localObject1);
            }
            else
            {
              LinkedList localLinkedList = new LinkedList();
              if (paramc != null)
              {
                Iterator localIterator = paramc.iterator();
                while (localIterator.hasNext())
                {
                  ChatroomMsgPack localChatroomMsgPack = (ChatroomMsgPack)localIterator.next();
                  if (localChatroomMsgPack.channel_id == localChatChannelFragment.IjE) {
                    localLinkedList.add(localChatroomMsgPack);
                  }
                }
              }
              localChatChannelFragment.IjA.a(localLinkedList, new LinkedList(), l, (List)localObject1);
            }
          }
        }
      }
      AppMethodBeat.o(276496);
      return;
    } while (!(parama instanceof GetChatroomRealtimeInfoResponse));
    paramc = (GetChatroomRealtimeInfoResponse)parama;
    parama = this.ImL;
    if (paramc.slot_list != null)
    {
      parama.IpE = paramc.slot_list.head_desc;
      if ((parama.IpB.getVisibility() == 8) || (parama.IpB.getTag() != null)) {
        parama.fDs();
      }
    }
    Object localObject2 = paramc.broadcast;
    if ((localObject2 == null) || (Util.isNullOrNil(((Broadcast)localObject2).message_list))) {}
    for (;;)
    {
      parama.a(paramc.notification_bar);
      if (paramc.slot_list != null)
      {
        parama = parama.Ipw;
        localObject1 = paramc.slot_list.slot_list;
        parama.Iog.setData((List)localObject1);
      }
      a(paramc.control_info);
      break;
      localObject1 = (BroadcastMessage)((Broadcast)localObject2).message_list.get(0);
      Log.d("GameChatRoom.ChatRoomStateView", "parseBroadcast, broadcast list size:%d, firstContent:%s", new Object[] { Integer.valueOf(((Broadcast)localObject2).message_list.size()), ((BroadcastMessage)localObject1).wording });
      if (((BroadcastMessage)localObject1).color != null)
      {
        localObject2 = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(((BroadcastMessage)localObject1).color.dark_color));
        if (localObject2 != null) {
          parama.IpB.setTextColor(((Integer)localObject2).intValue());
        }
      }
      parama.IpB.setVisibility(0);
      parama.IpB.setText(((BroadcastMessage)localObject1).wording);
      parama.IpB.setTag(null);
      parama.IpF.startTimer(((BroadcastMessage)localObject1).disappear_second * 1000, 0L);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(276557);
    GameChatCommentFooter localGameChatCommentFooter = this.ImQ;
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
        localGameChatCommentFooter.IqD = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (localGameChatCommentFooter.IqD))
      {
        localGameChatCommentFooter.IqD = false;
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
      AppMethodBeat.o(276557);
      return bool;
      label126:
      localGameChatCommentFooter.IqD = false;
      break;
      label135:
      str1 = str1.substring(0, j);
      str2 = str2.substring(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append(str2);
      localGameChatCommentFooter.setLastText(localStringBuilder.toString());
      localGameChatCommentFooter.nir.setSelection(j);
    }
  }
  
  public final long fCZ()
  {
    return 1399L;
  }
  
  public final long fDa()
  {
    return 13L;
  }
  
  public int getLayoutId()
  {
    return h.f.IhY;
  }
  
  public final long getSourceId()
  {
    return this.Ijr;
  }
  
  public final long getSsid()
  {
    return this.Ijq;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(276529);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      paramIntent = new com.tencent.mm.plugin.game.chatroom.c.c(this.lBQ, this.ImF, this.Inp);
      com.tencent.mm.kernel.h.aZW().a(paramIntent, 0);
      AppMethodBeat.o(276529);
      return;
    }
    if (paramInt1 == 12)
    {
      fDl();
      AppMethodBeat.o(276529);
      return;
    }
    if (paramInt1 == 13) {
      fDm();
    }
    AppMethodBeat.o(276529);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(276524);
    GameChatCommentFooter localGameChatCommentFooter = this.ImQ;
    if (localGameChatCommentFooter.getVisibility() == 0) {
      localGameChatCommentFooter.setVisibility(8);
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        wf(true);
      }
      AppMethodBeat.o(276524);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276471);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Inu = ((com.tencent.mm.plugin.game.chatroom.l.b)ai.a(this, null).q(com.tencent.mm.plugin.game.chatroom.l.b.class));
    if (!com.tencent.mm.plugin.game.chatroom.e.hI(this)) {
      com.tencent.mm.plugin.game.chatroom.e.wd(true);
    }
    if (!com.tencent.mm.plugin.game.chatroom.b.IdQ)
    {
      com.tencent.mm.plugin.game.chatroom.b.IdQ = true;
      getIntent().putExtra("game_report_sourceid", 0);
      getIntent().putExtra("game_report_ssid", 9999L);
      getIntent().putExtra("target_channel_id", -1);
      getIntent().putExtra("target_seq", -1L);
    }
    com.tencent.mm.plugin.game.chatroom.b.IdS = true;
    this.Inv = findViewById(h.e.action_bar_container);
    if ((this.Inv == null) || (!com.tencent.mm.ui.statusbar.c.afCQ)) {}
    Object localObject;
    for (;;)
    {
      Log.i("GameChatRoom.GameChatRoomUI", "onCreate, isMultiTaskOpened:%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.game.chatroom.e.fCo()) });
      getWindow().getDecorView().setSystemUiVisibility(1280);
      setActionbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.transparent));
      getSupportActionBar().hide();
      setNavigationbarColor(getResources().getColor(com.tencent.mm.plugin.game.chatroom.h.b.black));
      this.mContext = this;
      this.lBQ = getIntent().getStringExtra("chat_room_name");
      if (!Util.isNullOrNil(this.lBQ)) {
        break;
      }
      Log.i("GameChatRoom.GameChatRoomUI", "chat room name is null");
      wf(false);
      AppMethodBeat.o(276471);
      return;
      paramBundle = com.tencent.mm.ui.statusbar.c.ch(this);
      localObject = new c.a()
      {
        public final void onStatusBarHeightChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(276020);
          GameChatRoomUI.g(GameChatRoomUI.this).setPadding(0, paramAnonymousInt, 0, 0);
          com.tencent.mm.ui.statusbar.d.g(GameChatRoomUI.this.getWindow());
          AppMethodBeat.o(276020);
        }
      };
      this.Inw = ((c.a)localObject);
      paramBundle.a((c.a)localObject);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    this.plc = findViewById(h.e.root_view);
    paramBundle = new com.tencent.mm.ui.statusbar.b(this);
    ((RelativeLayout)this.plc).addView(paramBundle, new RelativeLayout.LayoutParams(-1, -1));
    paramBundle.addView(LayoutInflater.from(this).inflate(h.f.Iia, paramBundle, false), new FrameLayout.LayoutParams(-1, -1));
    this.Ijr = getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = getIntent().getLongExtra("game_report_ssid", 0L);
    this.IjF = ((Activity)this.mContext).getIntent().getIntExtra("target_channel_id", -1);
    this.IjY = ((Activity)this.mContext).getIntent().getLongExtra("target_seq", -1L);
    this.Inp = new ExportExternInfo();
    this.Inp.sourceid = this.Ijr;
    this.Inp.ssid = this.Ijq;
    paramBundle = com.tencent.mm.game.report.d.mty;
    com.tencent.mm.game.report.d.EF(this.lBQ);
    paramBundle = com.tencent.mm.game.report.d.mty;
    com.tencent.mm.game.report.d.EG("");
    Log.i("GameChatRoom.GameChatRoomUI", "chat_room_name:%s", new Object[] { this.lBQ });
    this.ImB = getIntent().getStringExtra("chat_room_icon");
    this.ImC = getIntent().getBooleanExtra("chat_room_auto_join", false);
    paramBundle = getIntent().getByteArrayExtra("chat_room_lbs");
    if ((paramBundle != null) && (paramBundle.length > 0)) {
      this.ImF = new Lbs();
    }
    try
    {
      this.ImF.parseFrom(paramBundle);
      label589:
      com.tencent.mm.kernel.h.aZW().a(4391, this);
      com.tencent.mm.kernel.h.aZW().a(4993, this);
      com.tencent.mm.kernel.h.aZW().a(4897, this);
      com.tencent.mm.kernel.h.aZW().a(4596, this);
      com.tencent.mm.kernel.h.aZW().a(5072, this);
      paramBundle = f.a.fCp();
      com.tencent.mm.kernel.h.baD().mCm.a(697, paramBundle.Iej);
      this.Inx.alive();
      this.IjM.alive();
      this.Inz.alive();
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mm.game.ACTION_QUIT_CHAT_ROOM");
      registerReceiver(this.Iny, paramBundle, com.tencent.mm.plugin.game.a.HRS, null);
      this.ImG = ((ImageView)findViewById(h.e.IeO));
      localObject = this.ImG;
      long l = System.currentTimeMillis();
      paramBundle = BitmapUtil.getBitmapNative(h.d.IeF);
      Log.i("GameChatRoom.GameChatUtils", "getDefaultChatRoomBg end, cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      boolean bool;
      if (paramBundle == null)
      {
        ((ImageView)localObject).setImageBitmap(paramBundle);
        this.ImG.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(276041);
            Log.i("GameChatRoom.GameChatRoomUI", "mask bg height:%d, width:%d", new Object[] { Integer.valueOf(GameChatRoomUI.h(GameChatRoomUI.this).getHeight()), Integer.valueOf(GameChatRoomUI.h(GameChatRoomUI.this).getWidth()) });
            GameChatRoomUI.h(GameChatRoomUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GameChatRoomUI.a(GameChatRoomUI.this, GameChatRoomUI.i(GameChatRoomUI.this));
            AppMethodBeat.o(276041);
          }
        });
        this.ImH = ((ImageView)findViewById(h.e.IeX));
        this.ImH.setOnClickListener(new GameChatRoomUI.18(this));
        this.ImI = ((ImageView)findViewById(h.e.IeY));
        this.ImI.setOnClickListener(new GameChatRoomUI.21(this));
        this.ImJ = ((TextView)findViewById(h.e.Ifm));
        com.tencent.mm.ui.a.v(this.ImJ, h.c.BodyTextSize);
        paramBundle = getIntent().getStringExtra("chat_room_title");
        this.ImJ.setText(paramBundle);
        this.ImK = ((TextView)findViewById(h.e.Ifl));
        com.tencent.mm.ui.a.v(this.ImK, h.c.SmallestTextSize);
        this.ImL = ((ChatRoomStateView)findViewById(h.e.Ifk));
        paramBundle = this.ImL;
        localObject = this.plc;
        paramBundle.plc = ((View)localObject);
        paramBundle.Ipx = ((View)localObject).findViewById(h.e.IeV);
        paramBundle.Ipy = ((ImageView)((View)localObject).findViewById(h.e.IgF));
        paramBundle.Ipz = ((TextView)((View)localObject).findViewById(h.e.notification_content));
        paramBundle.IpA = ((ImageView)((View)localObject).findViewById(h.e.IgG));
        paramBundle = this.ImL;
        localObject = this.lBQ;
        TextView localTextView = this.ImK;
        paramBundle.lBQ = ((String)localObject);
        paramBundle.Ipw.setChatRoomName((String)localObject);
        paramBundle.IpB = localTextView;
        this.ImQ = ((GameChatCommentFooter)findViewById(h.e.comment_footer));
        this.ImM = ((ChatChannelPage)findViewById(h.e.IeR));
        this.ImM.setUICallback(new com.tencent.mm.plugin.game.chatroom.b.d()
        {
          public final void a(boolean paramAnonymousBoolean, Channel paramAnonymousChannel)
          {
            AppMethodBeat.i(276049);
            if (GameChatRoomUI.m(GameChatRoomUI.this) != null)
            {
              GameChatRoomUI.m(GameChatRoomUI.this).setChannelInfo(paramAnonymousChannel);
              GameChatRoomUI.m(GameChatRoomUI.this).a(paramAnonymousBoolean, paramAnonymousChannel, false);
            }
            AppMethodBeat.o(276049);
          }
          
          public final void an(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(276043);
            GameChatRoomUI.a(GameChatRoomUI.this, paramAnonymousBoolean);
            if (!paramAnonymousBoolean)
            {
              GameChatRoomUI.b(GameChatRoomUI.this, paramAnonymousString);
              AppMethodBeat.o(276043);
              return;
            }
            GameChatRoomUI.c(GameChatRoomUI.this, paramAnonymousString);
            GameChatRoomUI.l(GameChatRoomUI.this);
            AppMethodBeat.o(276043);
          }
        });
        this.ImL.setStateChangeListener(new com.tencent.mm.plugin.game.chatroom.b.e()
        {
          public final void Xg(int paramAnonymousInt)
          {
            AppMethodBeat.i(276000);
            GameChatRoomUI.b(GameChatRoomUI.this, paramAnonymousInt);
            GameChatRoomUI.n(GameChatRoomUI.this).Xg(paramAnonymousInt);
            AppMethodBeat.o(276000);
          }
          
          public final void ap(Map<String, b.e> paramAnonymousMap)
          {
            AppMethodBeat.i(275996);
            GameChatRoomUI.n(GameChatRoomUI.this).ap(paramAnonymousMap);
            AppMethodBeat.o(275996);
          }
        });
        this.vNn = findViewById(h.e.bottom_layout);
        this.ImP = findViewById(h.e.Igq);
        this.ImP.setOnClickListener(new GameChatRoomUI.3(this));
        this.ImN = ((TextView)findViewById(h.e.Ift));
        this.ImN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(275997);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            GameChatRoomUI.m(GameChatRoomUI.this).setVisibility(0);
            com.tencent.mm.game.report.d.mty.a(1L, 2L, GameChatRoomUI.p(GameChatRoomUI.this), GameChatRoomUI.q(GameChatRoomUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(275997);
          }
        });
        this.ImN.setClickable(false);
        this.ImO = ((WeImageView)findViewById(h.e.emoji_btn));
        this.ImO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(275987);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            GameChatRoomUI.m(GameChatRoomUI.this).jf(0, 0);
            com.tencent.mm.game.report.d.mty.a(1L, 2L, GameChatRoomUI.p(GameChatRoomUI.this), GameChatRoomUI.q(GameChatRoomUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(275987);
          }
        });
        this.ImO.setClickable(false);
        this.ImQ.setFooterActionListener(new GameChatCommentFooter.b()
        {
          public final void c(t paramAnonymoust)
          {
            AppMethodBeat.i(275995);
            if (paramAnonymoust == null)
            {
              AppMethodBeat.o(275995);
              return;
            }
            if (GameChatRoomUI.r(GameChatRoomUI.this))
            {
              aa.dc(GameChatRoomUI.c(GameChatRoomUI.this), GameChatRoomUI.c(GameChatRoomUI.this).getString(h.h.Iiz));
              AppMethodBeat.o(275995);
              return;
            }
            GameChatRoomUI.a(GameChatRoomUI.this, paramAnonymoust);
            AppMethodBeat.o(275995);
          }
          
          public final void d(String paramAnonymousString, List paramAnonymousList, int paramAnonymousInt)
          {
            AppMethodBeat.i(275989);
            Log.v("GameChatRoom.GameChatRoomUI", "comment send requested");
            GameChatRoomUI.a(GameChatRoomUI.this, paramAnonymousString, paramAnonymousList, paramAnonymousInt);
            paramAnonymousString = GameChatRoomUI.m(GameChatRoomUI.this);
            paramAnonymousString.IqF.clear();
            paramAnonymousString.nir.setText("");
            AppMethodBeat.o(275989);
          }
          
          public final void fDn()
          {
            AppMethodBeat.i(276004);
            GameChatRoomUI.n(GameChatRoomUI.this).fCF();
            AppMethodBeat.o(276004);
          }
          
          public final void wg(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(276001);
            if (paramAnonymousBoolean)
            {
              GameChatRoomUI.s(GameChatRoomUI.this).setVisibility(0);
              com.tencent.threadpool.h.ahAA.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(276028);
                  Object localObject1 = GameChatRoomUI.n(GameChatRoomUI.this);
                  if (((ChatChannelPage)localObject1).IjQ != null)
                  {
                    localObject1 = ((ChatChannelPage)localObject1).IjQ.Ijz.iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      Object localObject2 = (ChatChannelFragment)((Iterator)localObject1).next();
                      if (((ChatChannelFragment)localObject2).IjA != null)
                      {
                        localObject2 = ((ChatChannelFragment)localObject2).IjA;
                        ((GameChatListView)localObject2).Irb.setVisibility(8);
                        ((GameChatListView)localObject2).Irb.setTag(null);
                        Log.i("GameChatRoom.GameChatListView", "adjustKeyboard, cache list size:%d", new Object[] { Integer.valueOf(((GameChatListView)localObject2).Irk.size()) });
                        if (((GameChatListView)localObject2).Irk.size() > 0) {
                          ((GameChatListView)localObject2).a(((GameChatListView)localObject2).Irk, 7, null);
                        }
                        ((GameChatListView)localObject2).fCF();
                      }
                    }
                  }
                  AppMethodBeat.o(276028);
                }
              }, 250L);
              AppMethodBeat.o(276001);
              return;
            }
            GameChatRoomUI.s(GameChatRoomUI.this).setVisibility(8);
            GameChatRoomUI.n(GameChatRoomUI.this).fCF();
            AppMethodBeat.o(276001);
          }
        });
        paramBundle = this.ImQ;
        localObject = new MMEditText.a()
        {
          public final void onBack()
          {
            AppMethodBeat.i(275986);
            if (GameChatRoomUI.m(GameChatRoomUI.this).getVisibility() == 0)
            {
              GameChatRoomUI.m(GameChatRoomUI.this).setVisibility(8);
              AppMethodBeat.o(275986);
              return;
            }
            GameChatRoomUI.j(GameChatRoomUI.this);
            AppMethodBeat.o(275986);
          }
        };
        if (paramBundle.nir != null) {
          paramBundle.nir.setBackListener((MMEditText.a)localObject);
        }
        this.ImR = ((JoinConfirmView)findViewById(h.e.Igh));
        this.ImS = findViewById(h.e.IgS);
        this.ImT = ((TextView)findViewById(h.e.IgT));
        this.ImU = findViewById(h.e.IgI);
        this.ImV = ((ImageView)findViewById(h.e.IgJ));
        this.ImW = ((TextView)findViewById(h.e.IgK));
        paramBundle = this.ImM;
        localObject = this.plc;
        if (paramBundle.plc == null)
        {
          paramBundle.plc = ((View)localObject);
          paramBundle.IjO = ((TabLayout)((View)localObject).findViewById(h.e.EGE));
        }
        paramBundle = this.ImM.aFu(this.lBQ);
        if (paramBundle == null) {
          break label1640;
        }
        bool = true;
        label1394:
        Log.i("GameChatRoom.GameChatRoomUI", "last cache channelInfo exist:%b", new Object[] { Boolean.valueOf(bool) });
        this.ImM.a(this.lBQ, paramBundle);
        this.ImX = new com.tencent.mm.plugin.game.chatroom.h.c(b.c.IdZ, this);
        this.ImY = new com.tencent.mm.plugin.game.chatroom.h.a(b.c.Iea, this);
        if (!this.ImC) {
          break label1646;
        }
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.m(this.lBQ, this.ImF, false, this.Ijq, this.Ijr);
        com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      }
      for (;;)
      {
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.b(this.lBQ);
        com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.f(this.lBQ);
        com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
        if (Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acST, Long.valueOf(0L))) == 0L) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acST, Long.valueOf(Util.nowSecond()));
        }
        paramBundle = com.tencent.mm.game.report.d.mty;
        d.a.f(0L, this.Ijq, this.Ijr);
        com.tencent.mm.game.report.d.mty.a(0L, 1L, this.Ijq, this.Ijr);
        AppMethodBeat.o(276471);
        return;
        paramBundle = com.tencent.mm.plugin.game.chatroom.e.an(paramBundle.copy(paramBundle.getConfig(), true));
        break;
        label1640:
        bool = false;
        break label1394;
        label1646:
        paramBundle = new com.tencent.mm.plugin.game.chatroom.c.c(this.lBQ, this.ImF, this.Inp);
        com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      }
    }
    catch (IOException paramBundle)
    {
      break label589;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(276547);
    super.onDestroy();
    Log.i("GameChatRoom.GameChatRoomUI", "onDestroy");
    destroy();
    AppMethodBeat.o(276547);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(276480);
    super.onNewIntent(paramIntent);
    Log.i("GameChatRoom.GameChatRoomUI", "onNewIntent");
    if (com.tencent.mm.plugin.game.chatroom.e.hI(this))
    {
      finish();
      destroy();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(276480);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(276541);
    super.onPause();
    Log.d("GameChatRoom.GameChatRoomUI", "onPause");
    Object localObject = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
    com.tencent.mm.plugin.game.chatroom.j.a.setScene(2);
    if (this.ImQ != null)
    {
      localObject = this.ImQ;
      if (((GameChatCommentFooter)localObject).moD != null) {
        ((GameChatCommentFooter)localObject).moD.onPause();
      }
      if (((GameChatCommentFooter)localObject).Iqy != null) {
        ((GameChatCommentFooter)localObject).Iqy.hide();
      }
      ((GameChatCommentFooter)localObject).nir.onPause();
    }
    AppMethodBeat.o(276541);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(276536);
    super.onResume();
    Log.d("GameChatRoom.GameChatRoomUI", "onResume");
    Object localObject = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
    com.tencent.mm.plugin.game.chatroom.j.a.setScene(1);
    if (this.ImQ != null)
    {
      localObject = this.ImQ;
      if ((((GameChatCommentFooter)localObject).moD != null) && (((GameChatCommentFooter)localObject).moD.getVisibility() == 0)) {
        ((GameChatCommentFooter)localObject).moD.onResume();
      }
      if (((GameChatCommentFooter)localObject).state == 0) {
        ((GameChatCommentFooter)localObject).postDelayed(new GameChatCommentFooter.10((GameChatCommentFooter)localObject), 200L);
      }
    }
    if (this.ImM != null)
    {
      localObject = this.ImM;
      if (((ChatChannelPage)localObject).IjP != null) {
        ((ChatChannelPage)localObject).postDelayed(new ChatChannelPage.4((ChatChannelPage)localObject), 1000L);
      }
    }
    AppMethodBeat.o(276536);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(276517);
    int i = paramp.getType();
    Object localObject2;
    Object localObject1;
    if (i == 4391)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (GetChatroomBaseInfoResponse)c.c.b(((com.tencent.mm.plugin.game.chatroom.c.c)paramp).mtC.otC);
        this.ImE = paramString.current_user_data;
        this.ImD = paramString.current_chatroom_data;
        this.Inf = paramString.extern_info;
        this.ImM.setChatRoomJumpInfo(paramString.jump_info);
        this.Inq = paramString.chatroom_enter_info;
        if ((this.ImE == null) || (this.ImD == null))
        {
          Log.i("GameChatRoom.GameChatRoomUI", "chatroom data is null");
          wf(false);
          AppMethodBeat.o(276517);
          return;
        }
        if (this.ImM != null) {
          this.ImM.a(this.lBQ, paramString.channel_info);
        }
        if (paramString.msg_base_info != null)
        {
          this.ImM.setJumpFirstSeq(paramString.msg_base_info.chatroom_first_seq);
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275993);
              if (paramString.msg_base_info.enter_lead_speak_info != null)
              {
                pr localpr = new pr();
                localpr.hSS.opType = 1;
                localpr.hSS.title = paramString.msg_base_info.enter_lead_speak_info.jump_wording;
                localpr.hSS.wording = paramString.msg_base_info.enter_lead_speak_info.lead_speak_wording;
                localpr.hSS.hST = paramString.msg_base_info.enter_lead_speak_info.disappear_second;
                localpr.publish();
              }
              AppMethodBeat.o(275993);
            }
          }, 1000L);
        }
        if (paramString.preload_info != null)
        {
          this.Inb = paramString.preload_info.preload_create_account_jump_info;
          this.Inc = paramString.preload_info.preload_profile_jump_info;
          this.Ind = paramString.preload_info.preload_premade_h5_jump_info;
        }
        if (!Util.isNullOrNil(paramString.robot_info_list))
        {
          paramp = (RobotInfo)paramString.robot_info_list.get(0);
          if ((paramp != null) && (!Util.isNullOrNil(paramp.username)))
          {
            if (this.ImQ != null) {
              this.ImQ.setRobotUserName(paramp.username);
            }
            this.Inu.IsB = paramp.username;
            ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(paramp.username, null);
          }
        }
        this.Ine = this.ImD.chatroom_member_jump_info;
        if (this.ImL != null)
        {
          localObject2 = this.ImL;
          paramp = this.Inc;
          localObject1 = this.Ine;
          localObject2 = ((ChatRoomStateView)localObject2).Ipw;
          ((ChatMemberListView)localObject2).IlV = paramp;
          ((ChatMemberListView)localObject2).Iok = ((JumpInfo)localObject1);
        }
        if (this.ImM != null) {
          this.ImM.setPreloadInfo(this.Inc);
        }
        fDl();
        fDm();
        paramp = com.tencent.mm.game.report.d.mty;
        com.tencent.mm.game.report.d.EG(this.ImD.appid);
        this.Inj = paramString.chatroom_button;
        this.ImS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(276033);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((!com.tencent.mm.plugin.game.chatroom.e.aFq(GameChatRoomUI.a(GameChatRoomUI.this)).IdU) && (GameChatRoomUI.b(GameChatRoomUI.this) != null))
            {
              if ((GameChatRoomUI.b(GameChatRoomUI.this).jump_type != 1) || (GameChatRoomUI.d(GameChatRoomUI.this) == null) || (Util.isNullOrNil(GameChatRoomUI.d(GameChatRoomUI.this).jump_url)) || (!Util.nullAsNil(GameChatRoomUI.d(GameChatRoomUI.this).preload_id).equals(GameChatRoomUI.b(GameChatRoomUI.this).preload_id))) {
                break label168;
              }
              com.tencent.mm.plugin.game.luggage.h.a(GameChatRoomUI.d(GameChatRoomUI.this).jump_url, new com.tencent.mm.plugin.game.luggage.h.b()
              {
                public final void at(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
                {
                  AppMethodBeat.i(276017);
                  Log.i("GameChatRoom.GameChatRoomUI", "right bottom, checkPreload,  hasPreload:[%b], result[%b]", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
                  Object localObject;
                  if (paramAnonymous2Boolean1) {
                    localObject = new JSONObject();
                  }
                  try
                  {
                    ((JSONObject)localObject).put("premade_info", GameChatRoomUI.e(GameChatRoomUI.this));
                    ((JSONObject)localObject).put("raw_url", GameChatRoomUI.b(GameChatRoomUI.this).jump_url);
                    ((JSONObject)localObject).put("source_id", 1305L);
                    label93:
                    localObject = URLEncoder.encode(((JSONObject)localObject).toString());
                    int i = com.tencent.mm.plugin.game.chatroom.e.a(GameChatRoomUI.c(GameChatRoomUI.this), GameChatRoomUI.d(GameChatRoomUI.this), 13, (String)localObject);
                    Log.i("GameChatRoom.GameChatRoomUI", "use preload premade url: %s", new Object[] { GameChatRoomUI.d(GameChatRoomUI.this).jump_url });
                    for (;;)
                    {
                      GameChatRoomUI.a(GameChatRoomUI.this, i);
                      AppMethodBeat.o(276017);
                      return;
                      i = com.tencent.mm.plugin.game.chatroom.e.a(GameChatRoomUI.c(GameChatRoomUI.this), GameChatRoomUI.b(GameChatRoomUI.this), 0, null);
                    }
                  }
                  catch (JSONException localJSONException)
                  {
                    break label93;
                  }
                }
              });
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(276033);
              return;
              label168:
              int i = com.tencent.mm.plugin.game.chatroom.e.a(GameChatRoomUI.c(GameChatRoomUI.this), GameChatRoomUI.b(GameChatRoomUI.this), 0, null);
              GameChatRoomUI.a(GameChatRoomUI.this, i);
            }
          }
        });
        if ((this.Inj != null) && (this.Inj.button_jump_info != null))
        {
          this.Inh = this.Inj.button_jump_info;
          fDe();
        }
        for (;;)
        {
          this.ImB = this.ImD.chatroom_icon;
          aFC(this.ImB);
          this.luk = this.ImE.username;
          if (this.ImQ != null) {
            this.ImQ.setHostUserName(this.luk);
          }
          ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(this.ImE);
          paramp = ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).aFo(this.luk);
          if (paramp != null)
          {
            this.ImM.setHostContact(paramp);
            this.ImQ.setCanAtAll(paramp.fCv());
          }
          this.ImJ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.ImD.room_name));
          if (!this.ImX.szN) {
            this.ImX.aFB(this.lBQ);
          }
          if (!this.ImY.szN) {
            this.ImY.iQ(this.lBQ, "");
          }
          a(paramString.control_info);
          if ((paramString.first_enter_notify != null) && (paramString.first_enter_notify.jump_info != null)) {
            com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, paramString.first_enter_notify.jump_info, 0, null);
          }
          AppMethodBeat.o(276517);
          return;
          fDf();
        }
      }
    }
    else
    {
      if (i == 4993)
      {
        localObject1 = (SendChatroomMsgRequest)c.b.b(((com.tencent.mm.plugin.game.chatroom.c.p)paramp).mtC.otB);
        paramString = "";
        if (((SendChatroomMsgRequest)localObject1).msg_pack != null) {
          paramString = ((SendChatroomMsgRequest)localObject1).msg_pack.cli_msg_id;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = this.ImM;
          if (((ChatChannelPage)localObject1).IjQ != null) {
            localObject1 = ((ChatChannelPage)localObject1).IjQ.Ijz.iterator();
          }
        }
        else
        {
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ChatChannelFragment)((Iterator)localObject1).next();
            if (((ChatChannelFragment)localObject2).IjA != null)
            {
              localObject2 = ((ChatChannelFragment)localObject2).IjA.IqW;
              ((GameChatListView.b)localObject2).fp(paramString, 0);
              ((GameChatListView.b)localObject2).IrA.remove(paramString);
              continue;
              localObject1 = this.ImM;
              if (((ChatChannelPage)localObject1).IjQ != null)
              {
                localObject1 = ((ChatChannelPage)localObject1).IjQ.Ijz.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (ChatChannelFragment)((Iterator)localObject1).next();
                  if (((ChatChannelFragment)localObject2).IjA != null) {
                    ((ChatChannelFragment)localObject2).IjA.IqW.fp(paramString, 2);
                  }
                }
              }
            }
          }
        }
        paramString = (SendChatroomMsgResponse)c.c.b(((com.tencent.mm.plugin.game.chatroom.c.p)paramp).mtC.otC);
        if ((!Util.isNullOrNil(paramString.send_notice)) && (!this.Ina))
        {
          paramString = new com.tencent.mm.ui.widget.a.g.a(this.mContext).bDE(paramString.send_notice).NF(false);
          paramString.Xdm = true;
          paramString.bDI(this.mContext.getString(h.h.app_i_know)).b(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(276023);
              GameChatRoomUI.f(GameChatRoomUI.this);
              AppMethodBeat.o(276023);
            }
          }).jHM().show();
        }
        AppMethodBeat.o(276517);
        return;
      }
      if (i == 4897)
      {
        localObject1 = (JoinChatroomResponse)c.c.b(((com.tencent.mm.plugin.game.chatroom.c.m)paramp).mtC.otC);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (((JoinChatroomResponse)localObject1).need_jump_create_account)
          {
            com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, ((JoinChatroomResponse)localObject1).create_account_jump_info, 11, null);
            paramString = new com.tencent.mm.plugin.game.chatroom.c.c(this.lBQ, this.ImF, this.Inp);
            com.tencent.mm.kernel.h.aZW().a(paramString, 0);
            AppMethodBeat.o(276517);
            return;
          }
          aa.db(this.mContext, MMApplicationContext.getResources().getString(h.h.Iit));
          this.ImR.setVisibility(8);
          paramString = new com.tencent.mm.plugin.game.chatroom.c.c(this.lBQ, this.ImF, this.Inp);
          com.tencent.mm.kernel.h.aZW().a(paramString, 0);
          paramString = new bl();
          paramString.hBx.opType = 1;
          paramString.hBx.hBy = this.lBQ;
          paramString.publish();
          AppMethodBeat.o(276517);
          return;
        }
        paramp = MMApplicationContext.getResources().getString(h.h.Iis);
        paramString = paramp;
        if (localObject1 != null)
        {
          paramString = paramp;
          if (!Util.isNullOrNil(((JoinChatroomResponse)localObject1).errmsg)) {
            paramString = ((JoinChatroomResponse)localObject1).errmsg;
          }
        }
        aa.dc(this.mContext, paramString);
        if (this.ImR.getVisibility() == 8)
        {
          paramString = new com.tencent.mm.plugin.game.chatroom.c.c(this.lBQ, this.ImF, this.Inp);
          com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        }
        if (((JoinChatroomResponse)localObject1).chatroom_full_jump_info != null) {
          com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, ((JoinChatroomResponse)localObject1).chatroom_full_jump_info, 0, null);
        }
        AppMethodBeat.o(276517);
        return;
      }
      if (i == 4596)
      {
        AppMethodBeat.o(276517);
        throw null;
      }
      if (i == 5072)
      {
        paramString = c.c.b(((com.tencent.mm.plugin.game.chatroom.c.f)paramp).mtC.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomPanelResponse");
          AppMethodBeat.o(276517);
          throw paramString;
        }
        this.Inr = ((GetChatroomPanelResponse)paramString).chatroom_panel;
        this.ImU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(276024);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = new ChatRoomPanelController(GameChatRoomUI.c(GameChatRoomUI.this));
            localObject = GameChatRoomUI.t(GameChatRoomUI.this);
            if ((localObject == null) || (Util.isNullOrNil((List)((ChatroomPanel)localObject).panel_list))) {}
            j localj;
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(276024);
              return;
              paramAnonymousView.IjW = new j(paramAnonymousView.getContext(), 0, 0, true, (byte)0);
              localj = paramAnonymousView.IjW;
            } while ((localj == null) || (localj.isShowing()));
            int m = (((ChatroomPanel)localObject).panel_list.size() - 1) / 8 + 1;
            paramAnonymousView.setDotView(m);
            if (m > 0) {}
            int k;
            label321:
            for (int i = 0;; i = k)
            {
              k = i + 1;
              View localView = LayoutInflater.from(paramAnonymousView.getContext()).inflate(h.f.IhD, (ViewGroup)paramAnonymousView.findViewById(h.e.Ifp), false);
              PanelGridView localPanelGridView = (PanelGridView)localView.findViewById(h.e.Ifg);
              ((MMFlipper)paramAnonymousView.findViewById(h.e.Ifp)).addView(localView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
              if (((ChatroomPanel)localObject).panel_list.size() > (i + 1) * 8) {}
              for (int j = (i + 1) * 8;; j = ((ChatroomPanel)localObject).panel_list.size())
              {
                localPanelGridView.setData(((ChatroomPanel)localObject).panel_list.subList(i * 8, j));
                if (k < m) {
                  break label321;
                }
                localj.F((View)paramAnonymousView, 0, 0);
                localj.dDn();
                break;
              }
            }
          }
        });
        if (this.Inr != null)
        {
          com.tencent.mm.plugin.game.d.e.fIb().p(this.ImV, this.Inr.panel_icon);
          this.ImW.setText(this.Inr.panel_text);
          if (this.ImN.isClickable()) {
            fDg();
          }
        }
      }
    }
    AppMethodBeat.o(276517);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(276533);
    super.onStart();
    Log.d("GameChatRoom.GameChatRoomUI", "onStart");
    AppMethodBeat.o(276533);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(276545);
    super.onStop();
    Log.d("GameChatRoom.GameChatRoomUI", "onStop");
    AppMethodBeat.o(276545);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(276558);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Inv != null))
    {
      this.Inv.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    AppMethodBeat.o(276558);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(276551);
    if (!getIntent().getBooleanExtra("disable_game_page_swipe", false))
    {
      AppMethodBeat.o(276551);
      return true;
    }
    AppMethodBeat.o(276551);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI
 * JD-Core Version:    0.7.0.1
 */