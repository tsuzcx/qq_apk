package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.bl;
import com.tencent.mm.autogen.a.bl.a;
import com.tencent.mm.autogen.a.kr;
import com.tencent.mm.autogen.a.lc;
import com.tencent.mm.autogen.a.xo;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpDetail;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.ContentBlock;
import com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.HalfScreen;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ShowIcon;
import com.tencent.mm.plugin.game.autogen.chatroom.WeappJumpInfo;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.protobuf.cm;
import com.tencent.mm.plugin.game.protobuf.cx;
import com.tencent.mm.plugin.game.protobuf.dh;
import com.tencent.mm.plugin.game.protobuf.er;
import com.tencent.mm.plugin.game.protobuf.r;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.j.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatRoomListView
  extends MRecyclerView
  implements com.tencent.mm.am.h
{
  private long Ijq;
  private long Ijr;
  private Lbs ImF;
  private List<BanAction> InN;
  private IListener InO;
  public b IoZ;
  private ChatRoomFooterView Ipa;
  private int Ipb;
  private JumpInfo Ipc;
  private GetCanJoinChatroomResponse Ipd;
  private LocalMyChatRoom Ipe;
  private boolean Ipf;
  private IListener Ipg;
  private IListener Iph;
  public com.tencent.mm.modelgeo.b.a lsF;
  public Context mContext;
  
  public ChatRoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276404);
    this.InN = new LinkedList();
    this.Ipf = false;
    this.Ipg = new IListener(com.tencent.mm.app.f.hfK)
    {
      /* Error */
      private boolean a(lc paramAnonymouslc)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 50
        //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_1
        //   8: getfield 54	com/tencent/mm/autogen/a/lc:hMN	Lcom/tencent/mm/autogen/a/lc$a;
        //   11: getfield 60	com/tencent/mm/autogen/a/lc$a:hMO	[B
        //   14: astore_2
        //   15: new 62	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom
        //   18: dup
        //   19: invokespecial 65	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:<init>	()V
        //   22: astore_1
        //   23: aload_1
        //   24: aload_2
        //   25: invokevirtual 69	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:parseFrom	([B)Lcom/tencent/mm/bx/a;
        //   28: pop
        //   29: aload_0
        //   30: getfield 13	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$1:Ipi	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
        //   33: aload_1
        //   34: invokestatic 72	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:a	(Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;)Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;
        //   37: pop
        //   38: aload_0
        //   39: getfield 13	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$1:Ipi	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
        //   42: invokestatic 75	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:a	(Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;)Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b;
        //   45: aload_1
        //   46: getfield 79	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:my_chatroom_info_list	Ljava/util/LinkedList;
        //   49: invokevirtual 85	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:il	(Ljava/util/List;)V
        //   52: ldc 50
        //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_0
        //   58: monitorexit
        //   59: iconst_0
        //   60: ireturn
        //   61: astore_2
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_0
        //   67: monitorexit
        //   68: aload_1
        //   69: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	70	0	this	1
        //   0	70	1	paramAnonymouslc	lc
        //   14	11	2	arrayOfByte	byte[]
        //   61	1	2	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   23	29	61	java/io/IOException
        //   2	23	65	finally
        //   23	29	65	finally
        //   29	57	65	finally
      }
    };
    this.InO = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Iph = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lsF = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(276372);
        Log.i("MicroMsg.ChatRoomListView", "getLocation isOK:%b, longitude:%f, latitude:%f", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2) });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276509);
            com.tencent.mm.modelgeo.d.bJl().a(ChatRoomListView.c(ChatRoomListView.this));
            AppMethodBeat.o(276509);
          }
        });
        if (paramAnonymousBoolean)
        {
          ChatRoomListView.a(ChatRoomListView.this, new Lbs());
          ChatRoomListView.d(ChatRoomListView.this).longitude = paramAnonymousFloat1;
          ChatRoomListView.d(ChatRoomListView.this).latitude = paramAnonymousFloat2;
        }
        ChatRoomListView.e(ChatRoomListView.this).setLbsInfo(ChatRoomListView.d(ChatRoomListView.this));
        ChatRoomListView.f(ChatRoomListView.this);
        AppMethodBeat.o(276372);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(276404);
  }
  
  public ChatRoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276412);
    this.InN = new LinkedList();
    this.Ipf = false;
    this.Ipg = new IListener(com.tencent.mm.app.f.hfK)
    {
      /* Error */
      private boolean a(lc paramAnonymouslc)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 50
        //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_1
        //   8: getfield 54	com/tencent/mm/autogen/a/lc:hMN	Lcom/tencent/mm/autogen/a/lc$a;
        //   11: getfield 60	com/tencent/mm/autogen/a/lc$a:hMO	[B
        //   14: astore_2
        //   15: new 62	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom
        //   18: dup
        //   19: invokespecial 65	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:<init>	()V
        //   22: astore_1
        //   23: aload_1
        //   24: aload_2
        //   25: invokevirtual 69	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:parseFrom	([B)Lcom/tencent/mm/bx/a;
        //   28: pop
        //   29: aload_0
        //   30: getfield 13	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$1:Ipi	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
        //   33: aload_1
        //   34: invokestatic 72	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:a	(Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;)Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;
        //   37: pop
        //   38: aload_0
        //   39: getfield 13	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$1:Ipi	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
        //   42: invokestatic 75	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:a	(Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;)Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b;
        //   45: aload_1
        //   46: getfield 79	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:my_chatroom_info_list	Ljava/util/LinkedList;
        //   49: invokevirtual 85	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:il	(Ljava/util/List;)V
        //   52: ldc 50
        //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_0
        //   58: monitorexit
        //   59: iconst_0
        //   60: ireturn
        //   61: astore_2
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_0
        //   67: monitorexit
        //   68: aload_1
        //   69: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	70	0	this	1
        //   0	70	1	paramAnonymouslc	lc
        //   14	11	2	arrayOfByte	byte[]
        //   61	1	2	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   23	29	61	java/io/IOException
        //   2	23	65	finally
        //   23	29	65	finally
        //   29	57	65	finally
      }
    };
    this.InO = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Iph = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lsF = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(276372);
        Log.i("MicroMsg.ChatRoomListView", "getLocation isOK:%b, longitude:%f, latitude:%f", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2) });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276509);
            com.tencent.mm.modelgeo.d.bJl().a(ChatRoomListView.c(ChatRoomListView.this));
            AppMethodBeat.o(276509);
          }
        });
        if (paramAnonymousBoolean)
        {
          ChatRoomListView.a(ChatRoomListView.this, new Lbs());
          ChatRoomListView.d(ChatRoomListView.this).longitude = paramAnonymousFloat1;
          ChatRoomListView.d(ChatRoomListView.this).latitude = paramAnonymousFloat2;
        }
        ChatRoomListView.e(ChatRoomListView.this).setLbsInfo(ChatRoomListView.d(ChatRoomListView.this));
        ChatRoomListView.f(ChatRoomListView.this);
        AppMethodBeat.o(276372);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(276412);
  }
  
  private void Xk(int paramInt)
  {
    AppMethodBeat.i(276437);
    d.a locala = com.tencent.mm.game.report.d.mty;
    d.a.a(1004L, 0L, 1L, paramInt, this.Ijq, this.Ijr, "", "", "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acSS, Integer.valueOf(1));
    AppMethodBeat.o(276437);
  }
  
  private void fDq()
  {
    AppMethodBeat.i(276430);
    int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSW, Integer.valueOf(0)));
    Object localObject1 = (Activity)this.mContext;
    if ((i > 0) || (((Activity)localObject1).isFinishing()) || (((Activity)localObject1).isDestroyed()))
    {
      AppMethodBeat.o(276430);
      return;
    }
    if ((com.tencent.mm.plugin.game.commlib.a.fDY() != null) && (com.tencent.mm.plugin.game.commlib.a.fDY().IHS != null) && (com.tencent.mm.plugin.game.commlib.a.fDY().IHS.ILm != null))
    {
      Object localObject3 = com.tencent.mm.plugin.game.commlib.a.fDY().IHS.ILm;
      Object localObject2 = ((cx)localObject3).IKX;
      localObject1 = ((cx)localObject3).IKY;
      JumpInfo localJumpInfo = new JumpInfo();
      localJumpInfo.jump_url = ((cx)localObject3).IGI;
      localJumpInfo.jump_type = ((cx)localObject3).IHl;
      if (localObject2 != null)
      {
        localObject3 = new WeappJumpInfo();
        ((WeappJumpInfo)localObject3).appid = ((er)localObject2).appid;
        ((WeappJumpInfo)localObject3).path = ((er)localObject2).path;
        localJumpInfo.weapp_jump_info = ((WeappJumpInfo)localObject3);
      }
      if (localObject1 != null)
      {
        localObject2 = new HalfScreen();
        ((HalfScreen)localObject2).screen_height_dp = ((cm)localObject1).IKL;
        ((HalfScreen)localObject2).screen_height_percent = ((cm)localObject1).IKM;
        ((HalfScreen)localObject2).type = ((cm)localObject1).vhJ;
        localJumpInfo.half_screen = ((HalfScreen)localObject2);
      }
      com.tencent.mm.plugin.game.chatroom.e.a(this.mContext, localJumpInfo, 0, null);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSW, Integer.valueOf(1));
    }
    AppMethodBeat.o(276430);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(276419);
    this.mContext = paramContext;
    this.Ijr = ((Activity)paramContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)paramContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.Ipf = ((Activity)paramContext).getIntent().getBooleanExtra("game_from_chatroom_detail", false);
    if (this.Ipf) {
      fDq();
    }
    paramContext = new LinearLayoutManager();
    paramContext.setOrientation(1);
    setLayoutManager(paramContext);
    setItemAnimator(null);
    this.IoZ = new b();
    setAdapter(this.IoZ);
    this.Ipa = new ChatRoomFooterView(this.mContext);
    Log.i("MicroMsg.ChatRoomListView", "one min footer height:%d", new Object[] { Integer.valueOf(this.Ipb) });
    this.Ipa.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276364);
        ChatRoomListView.a(ChatRoomListView.this, ChatRoomListView.e(ChatRoomListView.this).getHeight());
        int i = ChatRoomListView.this.getHeight();
        int j = ChatRoomListView.this.computeVerticalScrollExtent();
        int k = ChatRoomListView.this.computeVerticalScrollRange();
        Log.i("MicroMsg.ChatRoomListView", "mMinFooterHeight:%d, listViewHeight:%d, extentHeight:%d, rangeHeight:%d", new Object[] { Integer.valueOf(ChatRoomListView.g(ChatRoomListView.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        i = (j - k - ChatRoomListView.g(ChatRoomListView.this)) / 2;
        if (i > 0)
        {
          ChatRoomFooterView localChatRoomFooterView = ChatRoomListView.e(ChatRoomListView.this);
          localChatRoomFooterView.IoJ.setVisibility(0);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localChatRoomFooterView.IoJ.getLayoutParams();
          localLayoutParams.topMargin += i;
          localLayoutParams.bottomMargin = (i + localLayoutParams.bottomMargin);
          localChatRoomFooterView.IoJ.setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(276364);
      }
    });
    AppMethodBeat.o(276419);
  }
  
  public final void a(GetCanJoinChatroomResponse paramGetCanJoinChatroomResponse, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(276550);
      if (paramGetCanJoinChatroomResponse == null) {
        AppMethodBeat.o(276550);
      }
      for (;;)
      {
        return;
        Log.i("MicroMsg.ChatRoomListView", "attachRecommendData, useCache:%b", new Object[] { Boolean.valueOf(paramBoolean) });
        if (paramGetCanJoinChatroomResponse.show_entrance) {
          break;
        }
        Log.i("MicroMsg.ChatRoomListView", "show_entrance: false");
        paramGetCanJoinChatroomResponse = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
        com.tencent.mm.plugin.game.chatroom.j.a.stopService();
        paramGetCanJoinChatroomResponse = this.IoZ;
        paramGetCanJoinChatroomResponse.InS.clear();
        paramGetCanJoinChatroomResponse.bZE.notifyChanged();
        eu(this.Ipa);
        AppMethodBeat.o(276550);
      }
      this.Ipc = paramGetCanJoinChatroomResponse.create_jump_info;
    }
    finally {}
    Object localObject = com.tencent.mm.game.report.d.mty;
    d.a.a(1003L, 2L, 1L, 0L, this.Ijq, this.Ijr, "", "", "");
    this.IoZ.im(paramGetCanJoinChatroomResponse.chatroom_info_list);
    ChatroomJumpDetail localChatroomJumpDetail2;
    ChatroomJumpDetail localChatroomJumpDetail1;
    if (paramGetCanJoinChatroomResponse.ban_action_list != null)
    {
      this.InN.clear();
      this.InN.addAll(paramGetCanJoinChatroomResponse.ban_action_list);
      localObject = this.Ipa;
      LinkedList localLinkedList = paramGetCanJoinChatroomResponse.ban_action_list;
      localChatroomJumpDetail2 = paramGetCanJoinChatroomResponse.find_more_chatroom_jump_info;
      localChatroomJumpDetail1 = paramGetCanJoinChatroomResponse.chatroom_rank_jump_info;
      if (localLinkedList != null)
      {
        ((ChatRoomFooterView)localObject).InN.clear();
        ((ChatRoomFooterView)localObject).InN.addAll(localLinkedList);
      }
      if (localChatroomJumpDetail2 != null)
      {
        ((ChatRoomFooterView)localObject).IoD.setVisibility(0);
        if (localChatroomJumpDetail2.show_icon == null) {
          break label479;
        }
        ((ChatRoomFooterView)localObject).IoE.setVisibility(0);
        if (!aw.isDarkMode()) {
          break label467;
        }
        paramGetCanJoinChatroomResponse = localChatroomJumpDetail2.show_icon.dark_icon;
        label278:
        com.tencent.mm.plugin.game.d.e.fIb().p(((ChatRoomFooterView)localObject).IoE, paramGetCanJoinChatroomResponse);
        label289:
        ((ChatRoomFooterView)localObject).IoF.setText(localChatroomJumpDetail2.desc);
        ((ChatRoomFooterView)localObject).IoD.setOnClickListener(new ChatRoomFooterView.1((ChatRoomFooterView)localObject, localChatroomJumpDetail2));
        paramGetCanJoinChatroomResponse = com.tencent.mm.game.report.d.mty;
        d.a.a(1003L, 1L, 1L, 0L, ((ChatRoomFooterView)localObject).Ijq, ((ChatRoomFooterView)localObject).Ijr, "", "", "");
      }
      if (localChatroomJumpDetail1 != null)
      {
        ((ChatRoomFooterView)localObject).IoG.setVisibility(0);
        if (localChatroomJumpDetail1.show_icon == null) {
          break label503;
        }
        ((ChatRoomFooterView)localObject).IoH.setVisibility(0);
        if (!aw.isDarkMode()) {
          break label491;
        }
        paramGetCanJoinChatroomResponse = localChatroomJumpDetail1.show_icon.dark_icon;
        label389:
        com.tencent.mm.plugin.game.d.e.fIb().p(((ChatRoomFooterView)localObject).IoH, paramGetCanJoinChatroomResponse);
      }
    }
    for (;;)
    {
      ((ChatRoomFooterView)localObject).IoI.setText(localChatroomJumpDetail1.desc);
      ((ChatRoomFooterView)localObject).IoG.setOnClickListener(new ChatRoomFooterView.2((ChatRoomFooterView)localObject, localChatroomJumpDetail1));
      paramGetCanJoinChatroomResponse = com.tencent.mm.game.report.d.mty;
      d.a.a(1003L, 3L, 1L, 0L, ((ChatRoomFooterView)localObject).Ijq, ((ChatRoomFooterView)localObject).Ijr, "", "", "");
      AppMethodBeat.o(276550);
      break;
      label467:
      paramGetCanJoinChatroomResponse = localChatroomJumpDetail2.show_icon.light_icon;
      break label278;
      label479:
      ((ChatRoomFooterView)localObject).IoE.setVisibility(8);
      break label289;
      label491:
      paramGetCanJoinChatroomResponse = localChatroomJumpDetail1.show_icon.light_icon;
      break label389;
      label503:
      ((ChatRoomFooterView)localObject).IoH.setVisibility(8);
    }
  }
  
  public final void fDp()
  {
    AppMethodBeat.i(276528);
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSS, Integer.valueOf(0))) <= 0)
    {
      localObject = new c.a();
      ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getfirstenterinfo";
      ((c.a)localObject).funcId = 5139;
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      GetFirstEnterInfoRequest localGetFirstEnterInfoRequest = new GetFirstEnterInfoRequest();
      if (this.ImF != null) {
        localGetFirstEnterInfoRequest.lbs_info = this.ImF;
      }
      ((c.a)localObject).otE = localGetFirstEnterInfoRequest;
      ((c.a)localObject).otF = new GetFirstEnterInfoResponse();
      z.a(((c.a)localObject).bEF(), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(276352);
          Log.i("MicroMsg.ChatRoomListView", "showFirstGuidance, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if ((((Activity)ChatRoomListView.h(ChatRoomListView.this)).isFinishing()) || (((Activity)ChatRoomListView.h(ChatRoomListView.this)).isDestroyed()))
          {
            AppMethodBeat.o(276352);
            return 0;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = (GetFirstEnterInfoResponse)c.c.b(paramAnonymousc.otC);
            if (paramAnonymousString != null)
            {
              if (paramAnonymousString.enter_jump_info == null) {
                break label131;
              }
              com.tencent.mm.plugin.game.chatroom.e.a(ChatRoomListView.h(ChatRoomListView.this), paramAnonymousString.enter_jump_info, 0, null);
              ChatRoomListView.m(ChatRoomListView.this);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(276352);
            return 0;
            label131:
            if (!Util.isNullOrNil(paramAnonymousString.content_list))
            {
              paramAnonymousp = new SpannableStringBuilder();
              Iterator localIterator = paramAnonymousString.content_list.iterator();
              paramAnonymousInt1 = 0;
              while (localIterator.hasNext())
              {
                ContentBlock localContentBlock = (ContentBlock)localIterator.next();
                if (!Util.isNullOrNil(localContentBlock.content))
                {
                  paramAnonymousString = localContentBlock.color;
                  if (paramAnonymousString == null) {
                    paramAnonymousString = null;
                  }
                  for (;;)
                  {
                    paramAnonymousc = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(paramAnonymousString));
                    paramAnonymousString = paramAnonymousc;
                    if (paramAnonymousc == null) {
                      paramAnonymousString = Integer.valueOf(ChatRoomListView.h(ChatRoomListView.this).getResources().getColor(h.b.FG_2));
                    }
                    paramAnonymousp.append(localContentBlock.content);
                    paramAnonymousp.setSpan(new ForegroundColorSpan(paramAnonymousString.intValue()), paramAnonymousInt1, localContentBlock.content.length() + paramAnonymousInt1, 33);
                    paramAnonymousInt1 = paramAnonymousp.length();
                    break;
                    if (aw.isDarkMode()) {
                      paramAnonymousString = paramAnonymousString.dark_color;
                    } else {
                      paramAnonymousString = paramAnonymousString.light_color;
                    }
                  }
                }
              }
              if (paramAnonymousp.length() == 0)
              {
                AppMethodBeat.o(276352);
                return 0;
              }
              ChatRoomListView.a(ChatRoomListView.this, paramAnonymousp);
            }
          }
        }
      });
    }
    Object localObject = new com.tencent.mm.plugin.game.chatroom.c.j(this.ImF);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(276528);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(276532);
    super.onAttachedToWindow();
    com.tencent.mm.kernel.h.aZW().a(4631, this);
    this.InO.alive();
    this.Ipg.alive();
    this.Iph.alive();
    AppMethodBeat.o(276532);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(276537);
    super.onDetachedFromWindow();
    com.tencent.mm.kernel.h.aZW().b(4631, this);
    com.tencent.mm.modelgeo.d.bJl().a(this.lsF);
    this.InO.dead();
    this.Ipg.dead();
    this.Iph.dead();
    b.fDt();
    kr localkr;
    if (this.Ipd != null)
    {
      localkr = new kr();
      localkr.hMp.hAf = 2;
      localkr.hMp.key = "cache_chatroom_recommend";
    }
    try
    {
      localkr.hMp.value = this.Ipd.toByteArray();
      label101:
      localkr.publish();
      if (this.Ipe != null)
      {
        localkr = new kr();
        localkr.hMp.hAf = 2;
        localkr.hMp.key = "cache_my_chatroom";
      }
      try
      {
        localkr.hMp.value = this.Ipe.toByteArray();
        label153:
        localkr.publish();
        AppMethodBeat.o(276537);
        return;
      }
      catch (IOException localIOException1)
      {
        break label153;
      }
    }
    catch (IOException localIOException2)
    {
      break label101;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(276544);
    if ((paramp.getType() == 4631) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (GetCanJoinChatroomResponse)c.c.b(((com.tencent.mm.plugin.game.chatroom.c.j)paramp).mtC.otC);
      this.Ipd = paramString;
      a(paramString, false);
    }
    AppMethodBeat.o(276544);
  }
  
  final class a
    extends g.a
  {
    private List<com.tencent.mm.plugin.game.chatroom.d.a> uoj;
    private List<com.tencent.mm.plugin.game.chatroom.d.a> uok;
    
    public a(List<com.tencent.mm.plugin.game.chatroom.d.a> paramList)
    {
      this.uoj = paramList;
      Object localObject;
      this.uok = localObject;
    }
    
    public final int If()
    {
      AppMethodBeat.i(276174);
      int i = this.uoj.size();
      AppMethodBeat.o(276174);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(276181);
      int i = this.uok.size();
      AppMethodBeat.o(276181);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276185);
      Object localObject2 = (com.tencent.mm.plugin.game.chatroom.d.a)this.uoj.get(paramInt1);
      Object localObject1 = (com.tencent.mm.plugin.game.chatroom.d.a)this.uok.get(paramInt2);
      localObject2 = b.a((com.tencent.mm.plugin.game.chatroom.d.a)localObject2);
      localObject1 = b.a((com.tencent.mm.plugin.game.chatroom.d.a)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && (Util.nullAsNil(((ChatroomData)localObject2).chatroom_name).equals(((ChatroomData)localObject1).chatroom_name)))
      {
        AppMethodBeat.o(276185);
        return true;
      }
      AppMethodBeat.o(276185);
      return false;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      return false;
    }
  }
  
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    List<com.tencent.mm.plugin.game.chatroom.d.a> InS;
    private List<String> InT;
    private com.tencent.mm.plugin.game.chatroom.d.a Ipm;
    private com.tencent.mm.plugin.game.chatroom.d.a Ipn;
    private boolean Ipo;
    private Map<Object, b.c.c> Ipp;
    
    public b()
    {
      AppMethodBeat.i(276179);
      this.InS = new CopyOnWriteArrayList();
      this.Ipm = new com.tencent.mm.plugin.game.chatroom.d.a(1, ChatRoomListView.h(ChatRoomListView.this).getString(h.h.IiR));
      this.Ipn = new com.tencent.mm.plugin.game.chatroom.d.a(3, ChatRoomListView.h(ChatRoomListView.this).getString(h.h.IiU));
      this.Ipo = false;
      this.InT = new ArrayList();
      this.Ipp = new HashMap();
      AppMethodBeat.o(276179);
    }
    
    private ChatroomData Xl(int paramInt)
    {
      AppMethodBeat.i(276203);
      if ((paramInt >= this.InS.size()) || (paramInt < 0))
      {
        AppMethodBeat.o(276203);
        return null;
      }
      Object localObject = (com.tencent.mm.plugin.game.chatroom.d.a)this.InS.get(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(276203);
        return null;
      }
      localObject = b.a((com.tencent.mm.plugin.game.chatroom.d.a)localObject);
      AppMethodBeat.o(276203);
      return localObject;
    }
    
    /* Error */
    private void aFE(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 114
      //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: iconst_0
      //   8: istore_2
      //   9: iload_2
      //   10: aload_0
      //   11: getfield 44	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:InS	Ljava/util/List;
      //   14: invokeinterface 97 1 0
      //   19: if_icmpge +78 -> 97
      //   22: aload_0
      //   23: getfield 44	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:InS	Ljava/util/List;
      //   26: iload_2
      //   27: invokeinterface 101 2 0
      //   32: checkcast 46	com/tencent/mm/plugin/game/chatroom/d/a
      //   35: invokestatic 107	com/tencent/mm/plugin/game/chatroom/view/b:a	(Lcom/tencent/mm/plugin/game/chatroom/d/a;)Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomData;
      //   38: astore_3
      //   39: aload_3
      //   40: ifnull +50 -> 90
      //   43: aload_3
      //   44: getfield 120	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomData:chatroom_name	Ljava/lang/String;
      //   47: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   50: aload_1
      //   51: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   54: ifeq +36 -> 90
      //   57: aload_0
      //   58: getfield 44	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:InS	Ljava/util/List;
      //   61: aload_0
      //   62: getfield 44	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:InS	Ljava/util/List;
      //   65: iload_2
      //   66: invokeinterface 101 2 0
      //   71: invokeinterface 135 2 0
      //   76: pop
      //   77: aload_0
      //   78: iload_2
      //   79: invokevirtual 138	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:fX	(I)V
      //   82: ldc 114
      //   84: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_0
      //   88: monitorexit
      //   89: return
      //   90: iload_2
      //   91: iconst_1
      //   92: iadd
      //   93: istore_2
      //   94: goto -85 -> 9
      //   97: ldc 114
      //   99: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   102: goto -15 -> 87
      //   105: astore_1
      //   106: aload_0
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	110	0	this	b
      //   0	110	1	paramString	String
      //   8	86	2	i	int
      //   38	6	3	localChatroomData	ChatroomData
      // Exception table:
      //   from	to	target	type
      //   2	7	105	finally
      //   9	39	105	finally
      //   43	87	105	finally
      //   97	102	105	finally
    }
    
    private void fDr()
    {
      AppMethodBeat.i(276186);
      if (ChatRoomListView.k(ChatRoomListView.this) == null)
      {
        AppMethodBeat.o(276186);
        return;
      }
      int i = this.InS.indexOf(this.Ipm);
      int j = this.InS.indexOf(this.Ipn);
      if (i >= 0)
      {
        this.Ipm.Ikf = ChatRoomListView.k(ChatRoomListView.this);
        this.Ipn.Ikf = null;
      }
      for (this.Ipn.Ike = ChatRoomListView.h(ChatRoomListView.this).getString(h.h.IiU);; this.Ipn.Ike = ChatRoomListView.h(ChatRoomListView.this).getString(h.h.IiT))
      {
        if (i >= 0) {
          fV(i);
        }
        if (j >= 0) {
          fV(j);
        }
        AppMethodBeat.o(276186);
        return;
        this.Ipm.Ikf = null;
        this.Ipn.Ikf = ChatRoomListView.k(ChatRoomListView.this);
      }
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(276241);
      Object localObject = null;
      switch (paramInt)
      {
      default: 
        paramViewGroup = localObject;
      }
      for (;;)
      {
        AppMethodBeat.o(276241);
        return paramViewGroup;
        paramViewGroup = new b.d(LayoutInflater.from(ChatRoomListView.h(ChatRoomListView.this)).inflate(h.f.IhE, paramViewGroup, false));
        continue;
        paramViewGroup = new b.b(LayoutInflater.from(ChatRoomListView.h(ChatRoomListView.this)).inflate(h.f.Iij, paramViewGroup, false));
        continue;
        paramViewGroup = new b.c(LayoutInflater.from(ChatRoomListView.h(ChatRoomListView.this)).inflate(h.f.Iik, paramViewGroup, false));
      }
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(276250);
      if (paramv == null)
      {
        AppMethodBeat.o(276250);
        return;
      }
      int i;
      Object localObject;
      int j;
      if (Xl(paramInt) != null) {
        if (getItemViewType(paramInt) == 2)
        {
          i = paramInt - this.InS.indexOf(this.Ipm);
          localObject = Xl(paramInt);
          j = getItemViewType(paramInt);
          if ((localObject != null) && (!this.InT.contains(((ChatroomData)localObject).chatroom_name))) {
            break label214;
          }
        }
      }
      for (;;)
      {
        if ((paramv instanceof b.c)) {
          ((b.c)paramv).Ipp = this.Ipp;
        }
        ((b.a)paramv).a((com.tencent.mm.plugin.game.chatroom.d.a)this.InS.get(paramInt), ChatRoomListView.d(ChatRoomListView.this), i, ChatRoomListView.i(ChatRoomListView.this), ChatRoomListView.j(ChatRoomListView.this), ChatRoomListView.l(ChatRoomListView.this));
        if ((paramv instanceof b.d))
        {
          paramv = (b.d)paramv;
          localObject = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
          paramv.a(com.tencent.mm.plugin.game.chatroom.j.a.fCX());
        }
        AppMethodBeat.o(276250);
        return;
        if (getItemViewType(paramInt) == 4)
        {
          i = paramInt - this.InS.indexOf(this.Ipn);
          break;
        }
        i = 0;
        break;
        label214:
        this.InT.add(((ChatroomData)localObject).chatroom_name);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("reportStr", ((ChatroomData)localObject).report_str);
          label251:
          if (j == 2)
          {
            locala = com.tencent.mm.game.report.d.mty;
            d.a.a(1001L, i, 1L, 0L, ChatRoomListView.i(ChatRoomListView.this), ChatRoomListView.j(ChatRoomListView.this), ((ChatroomData)localObject).appid, ((ChatroomData)localObject).chatroom_name, localJSONObject.toString());
            continue;
          }
          if (j != 4) {
            continue;
          }
          d.a locala = com.tencent.mm.game.report.d.mty;
          d.a.a(1002L, i, 1L, 0L, ChatRoomListView.i(ChatRoomListView.this), ChatRoomListView.j(ChatRoomListView.this), ((ChatroomData)localObject).appid, ((ChatroomData)localObject).chatroom_name, localJSONObject.toString());
        }
        catch (Exception localException)
        {
          break label251;
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276257);
      int i = this.InS.size();
      AppMethodBeat.o(276257);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(276264);
      paramInt = ((com.tencent.mm.plugin.game.chatroom.d.a)this.InS.get(paramInt)).itemType;
      AppMethodBeat.o(276264);
      return paramInt;
    }
    
    public final void il(List<MyChatroomInfo> paramList)
    {
      LinkedList localLinkedList;
      Object localObject;
      try
      {
        AppMethodBeat.i(276221);
        if (paramList == null) {
          break label206;
        }
        localLinkedList = new LinkedList();
        localLinkedList.addAll(this.InS);
        localObject = new LinkedList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(new com.tencent.mm.plugin.game.chatroom.d.a(2, (MyChatroomInfo)localIterator.next()));
        }
        k = this.InS.indexOf(this.Ipm);
      }
      finally {}
      int k;
      int j = this.InS.indexOf(this.Ipn);
      int i = j;
      if (j < 0) {
        i = this.InS.size();
      }
      if (paramList.size() == 0)
      {
        paramList = this.InS.subList(0, i);
        this.InS.removeAll(paramList);
      }
      for (;;)
      {
        g.a(new ChatRoomListView.a(ChatRoomListView.this, localLinkedList, this.InS)).a(new androidx.recyclerview.widget.q()
        {
          public final void aR(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(276505);
            Log.d("MicroMsg.ChatRoomListView", "onInserted");
            ChatRoomListView.b.this.bA(paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(276505);
          }
          
          public final void aS(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(276508);
            Log.d("MicroMsg.ChatRoomListView", "onRemoved");
            ChatRoomListView.b.this.bB(paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(276508);
          }
          
          public final void aW(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(276515);
            Log.d("MicroMsg.ChatRoomListView", "onMoved, fromPosition:%d, toPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            ChatRoomListView.b.this.bz(paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(276515);
          }
          
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(276519);
            ChatRoomListView.b.this.by(paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(276519);
          }
        });
        fDr();
        label206:
        AppMethodBeat.o(276221);
        return;
        if (k < 0)
        {
          this.InS.add(0, this.Ipm);
          this.InS.addAll(1, (Collection)localObject);
          if (this.Ipo) {
            continue;
          }
          this.Ipo = true;
          paramList = new JSONObject();
        }
        try
        {
          paramList.put("GroupNum", ((List)localObject).size());
          label282:
          localObject = com.tencent.mm.game.report.d.mty;
          d.a.a(1001L, 0L, 1L, 0L, ChatRoomListView.i(ChatRoomListView.this), ChatRoomListView.j(ChatRoomListView.this), "", "", paramList.toString());
          continue;
          paramList = this.InS.subList(1, i);
          this.InS.removeAll(paramList);
          this.InS.addAll(1, (Collection)localObject);
        }
        catch (JSONException localJSONException)
        {
          break label282;
        }
      }
    }
    
    public final void im(List<ChatroomRecInfo> paramList)
    {
      LinkedList localLinkedList;
      try
      {
        AppMethodBeat.i(276231);
        i = this.InS.indexOf(this.Ipn);
        if (i >= 0) {
          this.InS.removeAll(this.InS.subList(i, this.InS.size()));
        }
        ChatRoomListView.this.eu(ChatRoomListView.e(ChatRoomListView.this));
        this.InS.add(this.Ipn);
        fDr();
        if (!Util.isNullOrNil(paramList))
        {
          localLinkedList = new LinkedList();
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            localLinkedList.add(new com.tencent.mm.plugin.game.chatroom.d.a(4, (ChatroomRecInfo)paramList.next()));
          }
          if (localLinkedList.size() != 0) {
            break label279;
          }
        }
      }
      finally {}
      label279:
      for (int i = 0;; i = 1)
      {
        this.InS.addAll(localLinkedList);
        this.bZE.notifyChanged();
        if (i != 0)
        {
          ChatRoomListView.e(ChatRoomListView.this).IoJ.setVisibility(8);
          paramList = com.tencent.mm.game.report.d.mty;
          d.a.a(1002L, 0L, 1L, 0L, ChatRoomListView.i(ChatRoomListView.this), ChatRoomListView.j(ChatRoomListView.this), "", "", "");
        }
        for (;;)
        {
          ChatRoomListView.this.et(ChatRoomListView.e(ChatRoomListView.this));
          AppMethodBeat.o(276231);
          return;
          i = 0;
          break;
          ChatRoomListView.e(ChatRoomListView.this).IoJ.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView
 * JD-Core Version:    0.7.0.1
 */