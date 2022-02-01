package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bf;
import com.tencent.mm.f.a.bf.a;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatRoomListView
  extends MRecyclerView
  implements i, com.tencent.mm.plugin.game.chatroom.b.a
{
  private long Cuy;
  private long Cuz;
  public Lbs CvP;
  private List<BanAction> Cww;
  private IListener Cwx;
  private b Cxe;
  public com.tencent.mm.plugin.game.chatroom.g.b Cxf;
  private ChatRoomFooterView Cxg;
  private int Cxh;
  private JumpInfo Cxi;
  private com.tencent.mm.modelgeo.b.a iQJ;
  public Context mContext;
  
  public ChatRoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210625);
    this.Cww = new LinkedList();
    this.Cwx = new IListener() {};
    this.iQJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(210867);
        Log.i("MicroMsg.ChatRoomListView", "getLocation isOK:%b, longitude:%f, latitude:%f", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2) });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211283);
            com.tencent.mm.modelgeo.d.blq().b(ChatRoomListView.b(ChatRoomListView.this));
            AppMethodBeat.o(211283);
          }
        });
        if (paramAnonymousBoolean)
        {
          ChatRoomListView.a(ChatRoomListView.this, new Lbs());
          ChatRoomListView.c(ChatRoomListView.this).longitude = paramAnonymousFloat1;
          ChatRoomListView.c(ChatRoomListView.this).latitude = paramAnonymousFloat2;
        }
        ChatRoomListView.d(ChatRoomListView.this).setLbsInfo(ChatRoomListView.c(ChatRoomListView.this));
        ChatRoomListView.e(ChatRoomListView.this);
        AppMethodBeat.o(210867);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(210625);
  }
  
  public ChatRoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210626);
    this.Cww = new LinkedList();
    this.Cwx = new IListener() {};
    this.iQJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(210867);
        Log.i("MicroMsg.ChatRoomListView", "getLocation isOK:%b, longitude:%f, latitude:%f", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2) });
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211283);
            com.tencent.mm.modelgeo.d.blq().b(ChatRoomListView.b(ChatRoomListView.this));
            AppMethodBeat.o(211283);
          }
        });
        if (paramAnonymousBoolean)
        {
          ChatRoomListView.a(ChatRoomListView.this, new Lbs());
          ChatRoomListView.c(ChatRoomListView.this).longitude = paramAnonymousFloat1;
          ChatRoomListView.c(ChatRoomListView.this).latitude = paramAnonymousFloat2;
        }
        ChatRoomListView.d(ChatRoomListView.this).setLbsInfo(ChatRoomListView.c(ChatRoomListView.this));
        ChatRoomListView.e(ChatRoomListView.this);
        AppMethodBeat.o(210867);
        return false;
      }
    };
    init(paramContext);
    AppMethodBeat.o(210626);
  }
  
  private void evT()
  {
    AppMethodBeat.i(210634);
    com.tencent.mm.plugin.game.chatroom.c.h localh = new com.tencent.mm.plugin.game.chatroom.c.h(this.CvP);
    com.tencent.mm.kernel.h.aGY().a(localh, 0);
    AppMethodBeat.o(210634);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(210635);
    this.mContext = paramContext;
    this.Cuz = ((Activity)paramContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Cuy = ((Activity)paramContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.Cxf = new com.tencent.mm.plugin.game.chatroom.g.b(com.tencent.mm.plugin.game.chatroom.b.a.CrN, this);
    paramContext = new LinearLayoutManager();
    paramContext.setOrientation(1);
    setLayoutManager(paramContext);
    setItemAnimator(null);
    this.Cxe = new b();
    setAdapter(this.Cxe);
    this.Cxg = new ChatRoomFooterView(this.mContext);
    Log.i("MicroMsg.ChatRoomListView", "one min footer height:%d", new Object[] { Integer.valueOf(this.Cxh) });
    this.Cxg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210849);
        ChatRoomListView.a(ChatRoomListView.this, ChatRoomListView.d(ChatRoomListView.this).getHeight());
        int i = ChatRoomListView.this.getHeight();
        int j = ChatRoomListView.this.computeVerticalScrollExtent();
        int k = ChatRoomListView.this.computeVerticalScrollRange();
        Log.i("MicroMsg.ChatRoomListView", "mMinFooterHeight:%d, listViewHeight:%d, extentHeight:%d, rangeHeight:%d", new Object[] { Integer.valueOf(ChatRoomListView.f(ChatRoomListView.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        i = (j - k - ChatRoomListView.f(ChatRoomListView.this)) / 2;
        if (i > 0)
        {
          ChatRoomFooterView localChatRoomFooterView = ChatRoomListView.d(ChatRoomListView.this);
          localChatRoomFooterView.Cxa.setVisibility(0);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localChatRoomFooterView.Cxa.getLayoutParams();
          localLayoutParams.topMargin += i;
          localLayoutParams.bottomMargin = (i + localLayoutParams.bottomMargin);
          localChatRoomFooterView.Cxa.setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(210849);
      }
    });
    AppMethodBeat.o(210635);
  }
  
  public final void a(com.tencent.mm.plugin.game.chatroom.b.a parama, com.tencent.mm.cd.a parama1)
  {
    AppMethodBeat.i(210632);
    switch (6.Cwr[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210632);
      return;
      if ((parama1 instanceof LocalMyChatRoom))
      {
        parama = (LocalMyChatRoom)parama1;
        this.Cxe.fs(parama.my_chatroom_info_list);
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(210629);
    super.onAttachedToWindow();
    com.tencent.mm.kernel.h.aGY().a(4631, this);
    EventCenter.instance.addListener(this.Cwx);
    AppMethodBeat.o(210629);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(210630);
    super.onDetachedFromWindow();
    com.tencent.mm.kernel.h.aGY().b(4631, this);
    com.tencent.mm.modelgeo.d.blq().b(this.iQJ);
    this.Cxf.evE();
    EventCenter.instance.removeListener(this.Cwx);
    b.evV();
    AppMethodBeat.o(210630);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(210631);
    if (paramq.getType() == 4631)
    {
      paramString = (GetCanJoinChatroomResponse)d.c.b(((com.tencent.mm.plugin.game.chatroom.c.h)paramq).jTk.lBS);
      if (!paramString.show_entrance)
      {
        Log.i("MicroMsg.ChatRoomListView", "show_entrance: false");
        this.Cxf.evE();
        paramString = this.Cxe;
        paramString.CwB.clear();
        paramString.alc.notifyChanged();
        AppMethodBeat.o(210631);
        return;
      }
      this.Cxi = paramString.create_jump_info;
      paramq = com.tencent.mm.game.report.d.jTj;
      d.a.a(1003L, 2L, 1L, 0L, this.Cuy, this.Cuz, "", "", "");
      this.Cxe.ft(paramString.chatroom_info_list);
      if (paramString.ban_action_list != null)
      {
        this.Cww.addAll(paramString.ban_action_list);
        paramq = this.Cxg;
        LinkedList localLinkedList = paramString.ban_action_list;
        paramString = paramString.find_more_jump_info;
        if (localLinkedList != null) {
          paramq.Cww.addAll(localLinkedList);
        }
        paramq.Cxc = paramString;
      }
    }
    AppMethodBeat.o(210631);
  }
  
  public final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(210627);
    Log.i("MicroMsg.ChatRoomListView", "grant location permission, result:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      com.tencent.mm.modelgeo.d.blq().a(this.iQJ, true);
      AppMethodBeat.o(210627);
      return;
    }
    evT();
    AppMethodBeat.o(210627);
  }
  
  final class a
    extends h.a
  {
    private List<com.tencent.mm.plugin.game.chatroom.d.a> rgi;
    private List<com.tencent.mm.plugin.game.chatroom.d.a> rgj;
    
    public a(List<com.tencent.mm.plugin.game.chatroom.d.a> paramList)
    {
      this.rgi = paramList;
      Object localObject;
      this.rgj = localObject;
    }
    
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210715);
      Object localObject2 = (com.tencent.mm.plugin.game.chatroom.d.a)this.rgi.get(paramInt1);
      Object localObject1 = (com.tencent.mm.plugin.game.chatroom.d.a)this.rgj.get(paramInt2);
      localObject2 = b.a((com.tencent.mm.plugin.game.chatroom.d.a)localObject2);
      localObject1 = b.a((com.tencent.mm.plugin.game.chatroom.d.a)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && (Util.nullAsNil(((ChatroomData)localObject2).chatroom_name).equals(((ChatroomData)localObject1).chatroom_name)))
      {
        AppMethodBeat.o(210715);
        return true;
      }
      AppMethodBeat.o(210715);
      return false;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      return false;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(210713);
      int i = this.rgi.size();
      AppMethodBeat.o(210713);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(210714);
      int i = this.rgj.size();
      AppMethodBeat.o(210714);
      return i;
    }
  }
  
  final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    List<com.tencent.mm.plugin.game.chatroom.d.a> CwB;
    private List<String> CwC;
    private com.tencent.mm.plugin.game.chatroom.d.a Cxn;
    private com.tencent.mm.plugin.game.chatroom.d.a Cxo;
    private boolean Cxp;
    
    public b()
    {
      AppMethodBeat.i(210770);
      this.CwB = new CopyOnWriteArrayList();
      this.Cxn = new com.tencent.mm.plugin.game.chatroom.d.a(1, ChatRoomListView.g(ChatRoomListView.this).getString(f.h.Cup));
      this.Cxo = new com.tencent.mm.plugin.game.chatroom.d.a(3, ChatRoomListView.g(ChatRoomListView.this).getString(f.h.Cus));
      this.Cxp = false;
      this.CwC = new ArrayList();
      AppMethodBeat.o(210770);
    }
    
    private ChatroomData Ts(int paramInt)
    {
      AppMethodBeat.i(210780);
      if ((paramInt >= this.CwB.size()) || (paramInt < 0))
      {
        AppMethodBeat.o(210780);
        return null;
      }
      Object localObject = (com.tencent.mm.plugin.game.chatroom.d.a)this.CwB.get(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(210780);
        return null;
      }
      localObject = b.a((com.tencent.mm.plugin.game.chatroom.d.a)localObject);
      AppMethodBeat.o(210780);
      return localObject;
    }
    
    /* Error */
    private void aIV(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 104
      //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: iconst_0
      //   8: istore_2
      //   9: iload_2
      //   10: aload_0
      //   11: getfield 39	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:CwB	Ljava/util/List;
      //   14: invokeinterface 87 1 0
      //   19: if_icmpge +78 -> 97
      //   22: aload_0
      //   23: getfield 39	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:CwB	Ljava/util/List;
      //   26: iload_2
      //   27: invokeinterface 91 2 0
      //   32: checkcast 41	com/tencent/mm/plugin/game/chatroom/d/a
      //   35: invokestatic 97	com/tencent/mm/plugin/game/chatroom/view/b:a	(Lcom/tencent/mm/plugin/game/chatroom/d/a;)Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomData;
      //   38: astore_3
      //   39: aload_3
      //   40: ifnull +50 -> 90
      //   43: aload_3
      //   44: getfield 110	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomData:chatroom_name	Ljava/lang/String;
      //   47: invokestatic 116	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   50: aload_1
      //   51: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   54: ifeq +36 -> 90
      //   57: aload_0
      //   58: getfield 39	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:CwB	Ljava/util/List;
      //   61: aload_0
      //   62: getfield 39	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:CwB	Ljava/util/List;
      //   65: iload_2
      //   66: invokeinterface 91 2 0
      //   71: invokeinterface 125 2 0
      //   76: pop
      //   77: aload_0
      //   78: iload_2
      //   79: invokevirtual 128	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:cN	(I)V
      //   82: ldc 104
      //   84: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_0
      //   88: monitorexit
      //   89: return
      //   90: iload_2
      //   91: iconst_1
      //   92: iadd
      //   93: istore_2
      //   94: goto -85 -> 9
      //   97: ldc 104
      //   99: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private void evU()
    {
      AppMethodBeat.i(210774);
      if (ChatRoomListView.j(ChatRoomListView.this) == null)
      {
        AppMethodBeat.o(210774);
        return;
      }
      int i = this.CwB.indexOf(this.Cxn);
      int j = this.CwB.indexOf(this.Cxo);
      if (i >= 0)
      {
        this.Cxn.CuD = ChatRoomListView.j(ChatRoomListView.this);
        this.Cxo.CuD = null;
      }
      for (this.Cxo.CuC = ChatRoomListView.g(ChatRoomListView.this).getString(f.h.Cus);; this.Cxo.CuC = ChatRoomListView.g(ChatRoomListView.this).getString(f.h.Cur))
      {
        if (i >= 0) {
          cL(i);
        }
        if (j >= 0) {
          cL(j);
        }
        AppMethodBeat.o(210774);
        return;
        this.Cxn.CuD = null;
        this.Cxo.CuD = ChatRoomListView.j(ChatRoomListView.this);
      }
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(210776);
      Object localObject = null;
      switch (paramInt)
      {
      default: 
        paramViewGroup = localObject;
      }
      for (;;)
      {
        AppMethodBeat.o(210776);
        return paramViewGroup;
        paramViewGroup = new b.d(LayoutInflater.from(ChatRoomListView.g(ChatRoomListView.this)).inflate(f.f.CtC, paramViewGroup, false));
        continue;
        paramViewGroup = new b.b(LayoutInflater.from(ChatRoomListView.g(ChatRoomListView.this)).inflate(f.f.CtV, paramViewGroup, false));
        continue;
        paramViewGroup = new b.c(LayoutInflater.from(ChatRoomListView.g(ChatRoomListView.this)).inflate(f.f.CtW, paramViewGroup, false));
      }
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(210777);
      if (paramv == null)
      {
        AppMethodBeat.o(210777);
        return;
      }
      int i;
      ChatroomData localChatroomData;
      int j;
      if (Ts(paramInt) != null) {
        if (getItemViewType(paramInt) == 2)
        {
          i = paramInt - this.CwB.indexOf(this.Cxn);
          localChatroomData = Ts(paramInt);
          j = getItemViewType(paramInt);
          if ((localChatroomData != null) && (!this.CwC.contains(localChatroomData.chatroom_name))) {
            break label172;
          }
        }
      }
      for (;;)
      {
        ((b.a)paramv).a((com.tencent.mm.plugin.game.chatroom.d.a)this.CwB.get(paramInt), ChatRoomListView.c(ChatRoomListView.this), i, ChatRoomListView.h(ChatRoomListView.this), ChatRoomListView.i(ChatRoomListView.this), ChatRoomListView.k(ChatRoomListView.this));
        AppMethodBeat.o(210777);
        return;
        if (getItemViewType(paramInt) == 4)
        {
          i = paramInt - this.CwB.indexOf(this.Cxo);
          break;
        }
        i = 0;
        break;
        label172:
        this.CwC.add(localChatroomData.chatroom_name);
        d.a locala;
        if (j == 2)
        {
          locala = com.tencent.mm.game.report.d.jTj;
          d.a.a(1001L, i, 1L, 0L, ChatRoomListView.h(ChatRoomListView.this), ChatRoomListView.i(ChatRoomListView.this), localChatroomData.appid, localChatroomData.chatroom_name, "");
        }
        else if (j == 4)
        {
          locala = com.tencent.mm.game.report.d.jTj;
          d.a.a(1002L, i, 1L, 0L, ChatRoomListView.h(ChatRoomListView.this), ChatRoomListView.i(ChatRoomListView.this), localChatroomData.appid, localChatroomData.chatroom_name, "");
        }
      }
    }
    
    public final void fs(List<MyChatroomInfo> paramList)
    {
      LinkedList localLinkedList;
      Object localObject;
      try
      {
        AppMethodBeat.i(210772);
        if (paramList == null) {
          break label205;
        }
        localLinkedList = new LinkedList();
        localLinkedList.addAll(this.CwB);
        localObject = new LinkedList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(new com.tencent.mm.plugin.game.chatroom.d.a(2, (MyChatroomInfo)localIterator.next()));
        }
        k = this.CwB.indexOf(this.Cxn);
      }
      finally {}
      int k;
      int j = this.CwB.indexOf(this.Cxo);
      int i = j;
      if (j < 0) {
        i = this.CwB.size();
      }
      if (paramList.size() == 0)
      {
        paramList = this.CwB.subList(0, i);
        this.CwB.removeAll(paramList);
      }
      for (;;)
      {
        androidx.recyclerview.widget.h.a(new ChatRoomListView.a(ChatRoomListView.this, localLinkedList, this.CwB)).a(new ChatRoomListView.b.1(this));
        evU();
        label205:
        AppMethodBeat.o(210772);
        return;
        if (k < 0)
        {
          this.CwB.add(0, this.Cxn);
          this.CwB.addAll(1, (Collection)localObject);
          if (this.Cxp) {
            continue;
          }
          this.Cxp = true;
          paramList = new JSONObject();
        }
        try
        {
          paramList.put("GroupNum", ((List)localObject).size());
          label280:
          localObject = com.tencent.mm.game.report.d.jTj;
          d.a.a(1001L, 0L, 1L, 0L, ChatRoomListView.h(ChatRoomListView.this), ChatRoomListView.i(ChatRoomListView.this), "", "", URLEncoder.encode(paramList.toString()));
          continue;
          paramList = this.CwB.subList(1, i);
          this.CwB.removeAll(paramList);
          this.CwB.addAll(1, (Collection)localObject);
        }
        catch (JSONException localJSONException)
        {
          break label280;
        }
      }
    }
    
    public final void ft(List<ChatroomRecInfo> paramList)
    {
      LinkedList localLinkedList;
      try
      {
        AppMethodBeat.i(210773);
        this.CwB.add(this.Cxo);
        evU();
        if (!Util.isNullOrNil(paramList))
        {
          localLinkedList = new LinkedList();
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            localLinkedList.add(new com.tencent.mm.plugin.game.chatroom.d.a(4, (ChatroomRecInfo)paramList.next()));
          }
          if (localLinkedList.size() != 0) {
            break label198;
          }
        }
      }
      finally {}
      label198:
      for (int i = 0;; i = 1)
      {
        this.CwB.addAll(localLinkedList);
        this.alc.notifyChanged();
        for (;;)
        {
          if (i != 0)
          {
            ChatRoomListView.d(ChatRoomListView.this).Cxa.setVisibility(8);
            paramList = com.tencent.mm.game.report.d.jTj;
            d.a.a(1002L, 0L, 1L, 0L, ChatRoomListView.h(ChatRoomListView.this), ChatRoomListView.i(ChatRoomListView.this), "", "", "");
          }
          ChatRoomListView.this.dG(ChatRoomListView.d(ChatRoomListView.this));
          AppMethodBeat.o(210773);
          return;
          i = 0;
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(210778);
      int i = this.CwB.size();
      AppMethodBeat.o(210778);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(210779);
      paramInt = ((com.tencent.mm.plugin.game.chatroom.d.a)this.CwB.get(paramInt)).fNO;
      AppMethodBeat.o(210779);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView
 * JD-Core Version:    0.7.0.1
 */