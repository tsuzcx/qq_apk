package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bm;
import com.tencent.mm.autogen.a.kr;
import com.tencent.mm.autogen.a.nb;
import com.tencent.mm.autogen.a.pr;
import com.tencent.mm.autogen.a.qf;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.Channel;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.LocalCacheChatMsg;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import com.tencent.mm.plugin.game.autogen.chatroom.NoticeMsg;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteInfo;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.plugin.game.chatroom.b.d;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.chatroom.i.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameChatListView
  extends MRecyclerView
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.game.chatroom.b.e, com.tencent.mm.plugin.game.chatroom.channel.b
{
  public List<Channel> IjD;
  private int IjE;
  private long Ijq;
  private long Ijr;
  private com.tencent.mm.plugin.game.chatroom.b.c IlU;
  private JumpInfo IlV;
  private ChatroomJumpInfo IlW;
  private Map<String, b.e> IlY;
  private String Ima;
  private long Imb;
  public b IqW;
  public int IqX;
  private boolean IqY;
  private long IqZ;
  private long Ira;
  public View Irb;
  private TextView Irc;
  private ImageView Ird;
  private View Ire;
  private TextView Irf;
  private c Irg;
  private boolean Irh;
  private boolean Iri;
  private Map<Long, List<ChatroomMsgPack>> Irj;
  public List<ChatroomMsgPack> Irk;
  private boolean Irl;
  private List<d> Irm;
  private String Irn;
  private long Iro;
  private long Irp;
  private IListener Irq;
  private String lBQ;
  private LinearLayoutManager lDn;
  private Context mContext;
  private boolean mIsForeground;
  
  public GameChatListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276402);
    this.IqX = 1;
    this.IlY = new HashMap();
    this.IqY = true;
    this.IqZ = 0L;
    this.Ira = 0L;
    this.Irh = true;
    this.Iri = true;
    this.Irj = new ConcurrentHashMap();
    this.Irk = new CopyOnWriteArrayList();
    this.Irl = true;
    this.Irm = new LinkedList();
    this.Iro = -1L;
    this.Irp = 0L;
    this.Irq = new IListener(f.hfK) {};
    init(paramContext);
    AppMethodBeat.o(276402);
  }
  
  public GameChatListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276413);
    this.IqX = 1;
    this.IlY = new HashMap();
    this.IqY = true;
    this.IqZ = 0L;
    this.Ira = 0L;
    this.Irh = true;
    this.Iri = true;
    this.Irj = new ConcurrentHashMap();
    this.Irk = new CopyOnWriteArrayList();
    this.Irl = true;
    this.Irm = new LinkedList();
    this.Iro = -1L;
    this.Irp = 0L;
    this.Irq = new IListener(f.hfK) {};
    init(paramContext);
    AppMethodBeat.o(276413);
  }
  
  private void Xm(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(276446);
        if ((this.Irb == null) || (this.Irb.getTag() != null))
        {
          AppMethodBeat.o(276446);
          return;
        }
        if (paramInt <= 0) {
          break label187;
        }
        if (this.Irb.getVisibility() == 8) {
          com.tencent.mm.game.report.d.mty.a(14L, 1L, this.Ijq, this.Ijr, 0L, "", this.IjE);
        }
        this.Irb.setVisibility(0);
        if (!com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IjE))
        {
          this.Ird.setImageResource(h.g.icons_filled_previous);
          if (paramInt < 1000) {
            break label151;
          }
          this.Irc.setText(this.mContext.getString(h.h.IiQ));
          AppMethodBeat.o(276446);
          continue;
        }
        this.Ird.setImageResource(h.g.game_chat_tips_icon_down);
      }
      finally {}
      continue;
      label151:
      this.Irc.setText(this.mContext.getString(h.h.IiS, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(276446);
      continue;
      label187:
      this.Irb.setVisibility(8);
      AppMethodBeat.o(276446);
    }
  }
  
  private void a(List<ChatroomMsgPack> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(276418);
    if (paramList == null)
    {
      AppMethodBeat.o(276418);
      return;
    }
    b.a(this.IqW, paramList, paramInt, paramLong, null);
    AppMethodBeat.o(276418);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(276438);
    this.mContext = paramContext;
    this.Ijr = ((Activity)paramContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)paramContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.lDn = new LinearLayoutManager();
    setLayoutManager(this.lDn);
    setItemAnimator(null);
    this.IqW = new b();
    this.IqW.bf(true);
    setAdapter(this.IqW);
    a(new RecyclerView.l()
    {
      int uRj = 0;
      int vBs = 0;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(276494);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatListView$7", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        int i;
        if ((paramAnonymousInt == 0) && (GameChatListView.j(GameChatListView.this) != null))
        {
          if ((GameChatListView.k(GameChatListView.this)) && (this.uRj == GameChatListView.f(GameChatListView.this).getItemCount() - 1)) {
            GameChatListView.j(GameChatListView.this).b(GameChatListView.f(GameChatListView.this));
          }
          boolean bool = com.tencent.mm.plugin.game.chatroom.g.a.Xe(GameChatListView.a(GameChatListView.this));
          if (GameChatListView.l(GameChatListView.this))
          {
            i = this.vBs;
            if (!bool) {
              break label187;
            }
          }
        }
        label187:
        for (paramAnonymousInt = 1;; paramAnonymousInt = 50)
        {
          if (i < paramAnonymousInt) {
            GameChatListView.j(GameChatListView.this).a(GameChatListView.f(GameChatListView.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$7", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(276494);
          return;
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(276499);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatListView$7", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        this.vBs = paramAnonymousRecyclerView.Ju();
        this.uRj = paramAnonymousRecyclerView.Jw();
        paramAnonymousInt1 = paramAnonymousRecyclerView.getChildCount();
        paramAnonymousInt2 = paramAnonymousRecyclerView.getItemCount();
        if (paramAnonymousInt1 + this.vBs >= paramAnonymousInt2)
        {
          GameChatListView.a(GameChatListView.this, true);
          GameChatListView.b.d(GameChatListView.f(GameChatListView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$7", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(276499);
          return;
          GameChatListView.a(GameChatListView.this, false);
        }
      }
    });
    this.Irg = new c()
    {
      public final void a(GameChatListView.b paramAnonymousb)
      {
        AppMethodBeat.i(276498);
        GameChatListView.b(GameChatListView.this, false);
        if (paramAnonymousb.Irx.size() > 0) {}
        for (long l = ((ChatroomMsgPack)paramAnonymousb.Irx.get(0)).seq;; l = 0L)
        {
          Log.i("GameChatRoom.GameChatListView", "onTopLoadMore topSeq:%d", new Object[] { Long.valueOf(l) });
          paramAnonymousb = new com.tencent.mm.plugin.game.chatroom.c.e(GameChatListView.m(GameChatListView.this), 0L, l, 1, 0L, GameChatListView.a(GameChatListView.this));
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousb, 0);
          AppMethodBeat.o(276498);
          return;
        }
      }
      
      public final void b(GameChatListView.b paramAnonymousb)
      {
        AppMethodBeat.i(276503);
        GameChatListView.c(GameChatListView.this, false);
        if (paramAnonymousb.Irx.size() > 0) {}
        for (long l = ((ChatroomMsgPack)paramAnonymousb.Irx.get(paramAnonymousb.Irx.size() - 1)).seq;; l = 0L)
        {
          Log.i("GameChatRoom.GameChatListView", "onBottomLoadMore, bottomSeq:%d", new Object[] { Long.valueOf(l) });
          paramAnonymousb = new com.tencent.mm.plugin.game.chatroom.c.e(GameChatListView.m(GameChatListView.this), l, 0L, 2, 0L, GameChatListView.a(GameChatListView.this));
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousb, 0);
          AppMethodBeat.o(276503);
          return;
        }
      }
    };
    AppMethodBeat.o(276438);
  }
  
  private void setNoticeTag(d paramd)
  {
    AppMethodBeat.i(276428);
    if (paramd == null)
    {
      AppMethodBeat.o(276428);
      return;
    }
    Log.i("GameChatRoom.GameChatListView", "setNoticeTag, Seq:%d, text:%s", new Object[] { Long.valueOf(paramd.IrN.seq), paramd.IrN.notice_text });
    long l;
    if (this.Ire != null)
    {
      this.Ire.setVisibility(0);
      this.Irf.setText(paramd.IrN.notice_text);
      com.tencent.mm.game.report.d.mty.a(2L, 1L, this.Ijq, this.Ijr, paramd.IrN.seq, "", this.IjE);
      this.Ire.setTag(Long.valueOf(paramd.IrN.seq));
      this.Irj.clear();
      b localb = this.IqW;
      l = paramd.IrN.seq;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)localb.Irr.getLayoutManager();
      i = localLinearLayoutManager.Ju();
      int j = localLinearLayoutManager.Jw();
      Log.i("GameChatRoom.GameChatListView", "notifyAtEvent, atSeq:%d, firstVisibleItem:%d, lastVisibleItem:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
      if (i > j) {
        break label357;
      }
      if ((i < 0) || (i >= localb.Irx.size()) || (((ChatroomMsgPack)localb.Irx.get(i)).seq != l)) {
        break label350;
      }
      localb.fV(i);
    }
    label350:
    label357:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        l = paramd.IrN.seq - 2L;
        Log.i("GameChatRoom.GameChatListView", "pre fetch at page, seq:%d", new Object[] { Long.valueOf(l) });
        paramd = new com.tencent.mm.plugin.game.chatroom.c.e(this.lBQ, l, 0L, 6, paramd.IrN.seq, this.IjE);
        com.tencent.mm.kernel.h.aZW().a(paramd, 0);
      }
      AppMethodBeat.o(276428);
      return;
      i += 1;
      break;
    }
  }
  
  public final void K(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(276583);
    if (paramLong < 0L)
    {
      this.Irb.setTag(null);
      this.Irb.performClick();
      AppMethodBeat.o(276583);
      return;
    }
    if (paramBoolean) {
      this.Iro = paramLong;
    }
    Object localObject = (List)this.Irj.get(Long.valueOf(paramLong));
    if (!Util.isNullOrNil((List)localObject))
    {
      Log.i("GameChatRoom.GameChatListView", "locatePosition, use prefetch msg, seq:%d", new Object[] { Long.valueOf(paramLong) });
      a((List)localObject, 4, paramLong);
      AppMethodBeat.o(276583);
      return;
    }
    Log.i("GameChatRoom.GameChatListView", "locatePosition, request msg, seq:%d", new Object[] { Long.valueOf(paramLong) });
    localObject = new com.tencent.mm.plugin.game.chatroom.c.e(this.lBQ, paramLong - 2L, 0L, 4, paramLong, this.IjE);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(276583);
  }
  
  public final void M(int paramInt, List<Channel> paramList)
  {
    AppMethodBeat.i(276580);
    this.IjE = paramInt;
    if (com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IjE)) {}
    for (String str = "";; str = "#" + this.IjE)
    {
      this.Irn = str;
      this.IjD = paramList;
      AppMethodBeat.o(276580);
      return;
    }
  }
  
  public final void Xg(int paramInt) {}
  
  public final void a(pr parampr)
  {
    AppMethodBeat.i(276568);
    this.Irp = this.IqZ;
    Log.i("GameChatRoom.GameChatListView", "onResume, channelId:%d", new Object[] { Integer.valueOf(this.IjE) });
    this.mIsForeground = true;
    b(parampr);
    AppMethodBeat.o(276568);
  }
  
  public final void a(List<ChatroomMsgPack> paramList1, int paramInt, List<ChatroomMsgPack> paramList2)
  {
    AppMethodBeat.i(276577);
    if (paramList1 == null)
    {
      AppMethodBeat.o(276577);
      return;
    }
    b.a(this.IqW, paramList1, paramInt, 0L, paramList2);
    AppMethodBeat.o(276577);
  }
  
  public final void a(List<ChatroomMsgPack> paramList1, List<NoticeMsg> paramList, long paramLong, List<ChatroomMsgPack> paramList2)
  {
    Object localObject;
    try
    {
      AppMethodBeat.i(276572);
      if (!this.Irl) {
        break label256;
      }
      this.Irh = true;
      this.Iri = true;
      this.IqY = true;
      this.IqZ = 0L;
      this.Irp = 0L;
      this.Ira = paramLong;
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("noticeMsgList:[");
      if (!Util.isNullOrNil(paramList))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          NoticeMsg localNoticeMsg = (NoticeMsg)paramList.next();
          d locald = new d((byte)0);
          locald.IrN = localNoticeMsg;
          this.Irm.add(locald);
          ((StringBuffer)localObject).append("(seq:" + localNoticeMsg.seq + ", text:" + localNoticeMsg.notice_text + ", highlight:" + localNoticeMsg.highlight + ") ");
        }
      }
      ((StringBuffer)localObject).append("]");
    }
    finally {}
    Log.i("GameChatRoom.GameChatListView", "lastReceiveSeq:%d, %s", new Object[] { Long.valueOf(this.Ira), ((StringBuffer)localObject).toString() });
    paramList = new nb();
    paramList.hPo.hPp = true;
    paramList.publish();
    label256:
    b.F(paramList2, this.Irk);
    paramList = this.Irj.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      paramLong = ((Long)((Map.Entry)localObject).getKey()).longValue();
      localObject = (List)((Map.Entry)localObject).getValue();
      b.F(paramList2, (List)localObject);
      this.Irj.put(Long.valueOf(paramLong), localObject);
    }
    a(paramList1, 3, paramList2);
    AppMethodBeat.o(276572);
  }
  
  /* Error */
  public final void aFt(String paramString)
  {
    // Byte code:
    //   0: ldc_w 672
    //   3: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 675	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +10 -> 20
    //   13: ldc_w 672
    //   16: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: new 677	com/tencent/mm/autogen/a/kr
    //   23: dup
    //   24: invokespecial 678	com/tencent/mm/autogen/a/kr:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: getfield 682	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   32: iconst_1
    //   33: putfield 687	com/tencent/mm/autogen/a/kr$a:hAf	I
    //   36: aload_3
    //   37: getfield 682	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   40: new 548	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 689
    //   47: invokespecial 553	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 610	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 544	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irn	Ljava/lang/String;
    //   58: invokevirtual 610	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: putfield 692	com/tencent/mm/autogen/a/kr$a:key	Ljava/lang/String;
    //   67: aload_3
    //   68: invokevirtual 693	com/tencent/mm/autogen/a/kr:publish	()Z
    //   71: pop
    //   72: aload_3
    //   73: getfield 682	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   76: getfield 697	com/tencent/mm/autogen/a/kr$a:value	[B
    //   79: astore_3
    //   80: aload_3
    //   81: invokestatic 700	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   84: ifne +90 -> 174
    //   87: new 702	com/tencent/mm/plugin/game/autogen/chatroom/LocalCacheChatMsg
    //   90: dup
    //   91: invokespecial 703	com/tencent/mm/plugin/game/autogen/chatroom/LocalCacheChatMsg:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: aload_3
    //   97: invokevirtual 707	com/tencent/mm/plugin/game/autogen/chatroom/LocalCacheChatMsg:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   100: pop
    //   101: iconst_1
    //   102: istore_2
    //   103: aload_1
    //   104: ifnull +70 -> 174
    //   107: iload_2
    //   108: ifeq +66 -> 174
    //   111: ldc_w 408
    //   114: ldc_w 709
    //   117: iconst_1
    //   118: anewarray 282	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: getfield 227	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:IjE	I
    //   127: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload_0
    //   135: ldc_w 711
    //   138: invokestatic 715	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   141: checkcast 711	com/tencent/mm/plugin/game/chatroom/b/b
    //   144: aload_1
    //   145: getfield 718	com/tencent/mm/plugin/game/autogen/chatroom/LocalCacheChatMsg:host_user_name	Ljava/lang/String;
    //   148: invokeinterface 722 2 0
    //   153: putfield 502	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:IlU	Lcom/tencent/mm/plugin/game/chatroom/b/c;
    //   156: aload_0
    //   157: getfield 502	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:IlU	Lcom/tencent/mm/plugin/game/chatroom/b/c;
    //   160: ifnull +14 -> 174
    //   163: aload_0
    //   164: aload_1
    //   165: getfield 726	com/tencent/mm/plugin/game/autogen/chatroom/LocalCacheChatMsg:chatroom_msg_list	Ljava/util/LinkedList;
    //   168: bipush 8
    //   170: aconst_null
    //   171: invokevirtual 308	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:a	(Ljava/util/List;ILjava/util/List;)V
    //   174: ldc_w 672
    //   177: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_1
    //   184: iconst_0
    //   185: istore_2
    //   186: goto -83 -> 103
    //   189: astore_3
    //   190: goto -6 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	GameChatListView
    //   0	193	1	paramString	String
    //   102	84	2	i	int
    //   27	70	3	localObject	Object
    //   189	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   87	95	181	java/io/IOException
    //   95	101	189	java/io/IOException
  }
  
  public final void ap(Map<String, b.e> paramMap)
  {
    AppMethodBeat.i(276571);
    if (paramMap != null)
    {
      this.IlY.clear();
      this.IlY.putAll(paramMap);
      this.IqW.fDC();
    }
    AppMethodBeat.o(276571);
  }
  
  /* Error */
  public final void b(pr parampr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 737
    //   5: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +39 -> 48
    //   12: aload_0
    //   13: getfield 201	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irb	Landroid/view/View;
    //   16: invokevirtual 207	android/view/View:getTag	()Ljava/lang/Object;
    //   19: ifnull +20 -> 39
    //   22: aload_0
    //   23: getfield 201	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irb	Landroid/view/View;
    //   26: bipush 8
    //   28: invokevirtual 235	android/view/View:setVisibility	(I)V
    //   31: aload_0
    //   32: getfield 201	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irb	Landroid/view/View;
    //   35: aconst_null
    //   36: invokevirtual 440	android/view/View:setTag	(Ljava/lang/Object;)V
    //   39: ldc_w 737
    //   42: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: getfield 227	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:IjE	I
    //   52: invokestatic 241	com/tencent/mm/plugin/game/chatroom/g$a:Xd	(I)Z
    //   55: ifne +13 -> 68
    //   58: aload_0
    //   59: getfield 227	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:IjE	I
    //   62: invokestatic 740	com/tencent/mm/plugin/game/chatroom/g$a:Xf	(I)Z
    //   65: ifeq +89 -> 154
    //   68: aload_1
    //   69: getfield 746	com/tencent/mm/autogen/a/pr:hSS	Lcom/tencent/mm/autogen/a/pr$a;
    //   72: getfield 751	com/tencent/mm/autogen/a/pr$a:title	Ljava/lang/String;
    //   75: invokestatic 675	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   78: ifne +76 -> 154
    //   81: aload_0
    //   82: getfield 201	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irb	Landroid/view/View;
    //   85: iconst_0
    //   86: invokevirtual 235	android/view/View:setVisibility	(I)V
    //   89: aload_0
    //   90: getfield 201	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irb	Landroid/view/View;
    //   93: aload_1
    //   94: getfield 746	com/tencent/mm/autogen/a/pr:hSS	Lcom/tencent/mm/autogen/a/pr$a;
    //   97: getfield 754	com/tencent/mm/autogen/a/pr$a:wording	Ljava/lang/String;
    //   100: invokevirtual 440	android/view/View:setTag	(Ljava/lang/Object;)V
    //   103: aload_0
    //   104: getfield 201	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irb	Landroid/view/View;
    //   107: new 14	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$2
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 755	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$2:<init>	(Lcom/tencent/mm/plugin/game/chatroom/view/GameChatListView;)V
    //   115: aload_1
    //   116: getfield 746	com/tencent/mm/autogen/a/pr:hSS	Lcom/tencent/mm/autogen/a/pr$a;
    //   119: getfield 758	com/tencent/mm/autogen/a/pr$a:hST	J
    //   122: ldc2_w 395
    //   125: lmul
    //   126: invokevirtual 762	android/view/View:postDelayed	(Ljava/lang/Runnable;J)Z
    //   129: pop
    //   130: aload_0
    //   131: getfield 255	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Irc	Landroid/widget/TextView;
    //   134: aload_1
    //   135: getfield 746	com/tencent/mm/autogen/a/pr:hSS	Lcom/tencent/mm/autogen/a/pr$a;
    //   138: getfield 751	com/tencent/mm/autogen/a/pr$a:title	Ljava/lang/String;
    //   141: invokevirtual 274	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   144: aload_0
    //   145: getfield 243	com/tencent/mm/plugin/game/chatroom/view/GameChatListView:Ird	Landroid/widget/ImageView;
    //   148: getstatic 765	com/tencent/mm/plugin/game/chatroom/h$g:icons_left_down_arrow	I
    //   151: invokevirtual 253	android/widget/ImageView:setImageResource	(I)V
    //   154: ldc_w 737
    //   157: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: goto -115 -> 45
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	GameChatListView
    //   0	168	1	parampr	pr
    // Exception table:
    //   from	to	target	type
    //   2	8	163	finally
    //   12	39	163	finally
    //   39	45	163	finally
    //   48	68	163	finally
    //   68	154	163	finally
    //   154	160	163	finally
  }
  
  public final void fCF()
  {
    AppMethodBeat.i(276582);
    int i = this.lDn.Ju();
    int j = this.lDn.Jw();
    final int k = this.IqW.getItemCount() - 1;
    if ((k < i) || (k > j)) {
      this.lDn.bo(k, 0);
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276486);
        View localView = GameChatListView.h(GameChatListView.this).findViewByPosition(k);
        if (localView != null)
        {
          int i = GameChatListView.this.getMeasuredHeight();
          int j = localView.getMeasuredHeight();
          GameChatListView.h(GameChatListView.this).bo(k, i - j);
        }
        AppMethodBeat.o(276486);
      }
    });
    AppMethodBeat.o(276582);
  }
  
  public void getFirstPageData()
  {
    AppMethodBeat.i(276573);
    if (!com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IjE))
    {
      com.tencent.mm.plugin.game.chatroom.c.e locale = new com.tencent.mm.plugin.game.chatroom.c.e(this.lBQ, 0L, 9223372036854775807L, 3, 0L, this.IjE);
      com.tencent.mm.kernel.h.aZW().a(locale, 0);
    }
    AppMethodBeat.o(276573);
  }
  
  public final void hw(View paramView)
  {
    AppMethodBeat.i(276581);
    if (this.Irb != null)
    {
      AppMethodBeat.o(276581);
      return;
    }
    this.Irb = paramView.findViewById(h.e.Ihi);
    this.Irc = ((TextView)paramView.findViewById(h.e.Ihj));
    this.Ird = ((ImageView)paramView.findViewById(h.e.Ihh));
    if (!com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IjE)) {
      this.Ird.setImageResource(h.g.icons_filled_previous);
    }
    if (this.Irb != null) {
      this.Irb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(276502);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatListView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          Log.i("GameChatRoom.GameChatListView", "click new msg tag, cache list size:%d", new Object[] { Integer.valueOf(GameChatListView.c(GameChatListView.this).size()) });
          GameChatListView.b(GameChatListView.this).setVisibility(8);
          if (GameChatListView.b(GameChatListView.this).getTag() != null) {
            if ((GameChatListView.b(GameChatListView.this).getTag() instanceof String))
            {
              paramAnonymousView = (String)GameChatListView.b(GameChatListView.this).getTag();
              GameChatListView.b(GameChatListView.this).setTag(null);
              com.tencent.threadpool.h.ahAA.o(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(276408);
                  pr localpr = new pr();
                  localpr.hSS.opType = 3;
                  localpr.hSS.wording = paramAnonymousView;
                  localpr.publish();
                  AppMethodBeat.o(276408);
                }
              }, 200L);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(276502);
            return;
            paramAnonymousView = "";
            break;
            if (!com.tencent.mm.plugin.game.chatroom.g.a.Xd(GameChatListView.a(GameChatListView.this)))
            {
              paramAnonymousView = new bm();
              paramAnonymousView.hBz.channelId = com.tencent.mm.plugin.game.chatroom.g.a.Ieu;
              paramAnonymousView.publish();
              com.tencent.mm.game.report.d.mty.a(14L, 2L, GameChatListView.d(GameChatListView.this), GameChatListView.e(GameChatListView.this), 0L, "", GameChatListView.a(GameChatListView.this));
            }
            else if (GameChatListView.c(GameChatListView.this).size() > 0)
            {
              GameChatListView.a(GameChatListView.this, GameChatListView.c(GameChatListView.this));
            }
            else
            {
              paramAnonymousView = GameChatListView.this;
              localObject = com.tencent.mm.hellhoundlib.b.c.a(GameChatListView.f(GameChatListView.this).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
              paramAnonymousView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        }
      });
    }
    this.Ire = paramView.findViewById(h.e.IeM);
    this.Ire.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276492);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatListView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        GameChatListView.g(GameChatListView.this).setVisibility(8);
        if ((GameChatListView.g(GameChatListView.this).getTag() instanceof Long))
        {
          long l = ((Long)GameChatListView.g(GameChatListView.this).getTag()).longValue();
          com.tencent.mm.game.report.d.mty.a(2L, 2L, GameChatListView.d(GameChatListView.this), GameChatListView.e(GameChatListView.this), l, "", GameChatListView.a(GameChatListView.this));
          GameChatListView.this.K(l, false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276492);
      }
    });
    this.Irf = ((TextView)paramView.findViewById(h.e.IeN));
    AppMethodBeat.o(276581);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(276564);
    super.onAttachedToWindow();
    com.tencent.mm.kernel.h.aZW().a(4562, this);
    this.Irq.alive();
    AppMethodBeat.o(276564);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(276566);
    super.onDetachedFromWindow();
    com.tencent.mm.kernel.h.aZW().b(4562, this);
    this.Irq.dead();
    Object localObject = this.IqW.Irx;
    if ((this.IlU != null) && (!Util.isNullOrNil(this.lBQ)))
    {
      if (Util.isNullOrNil((List)localObject)) {
        break label205;
      }
      int i = 0;
      int j = ((List)localObject).size();
      if (((List)localObject).size() > 20) {
        i = ((List)localObject).size() - 20;
      }
      localObject = ((List)localObject).subList(i, j);
    }
    for (;;)
    {
      LocalCacheChatMsg localLocalCacheChatMsg = new LocalCacheChatMsg();
      localLocalCacheChatMsg.chatroom_msg_list.addAll((Collection)localObject);
      localLocalCacheChatMsg.host_user_name = this.IlU.getUserName();
      localObject = new kr();
      ((kr)localObject).hMp.hAf = 2;
      ((kr)localObject).hMp.key = ("cache_game_chat_msg#" + this.lBQ + this.Irn);
      try
      {
        ((kr)localObject).hMp.value = localLocalCacheChatMsg.toByteArray();
        label193:
        ((kr)localObject).publish();
        AppMethodBeat.o(276566);
        return;
        label205:
        localObject = new LinkedList();
      }
      catch (IOException localIOException)
      {
        break label193;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(276569);
    Log.i("GameChatRoom.GameChatListView", "onPause, channelId:%d", new Object[] { Integer.valueOf(this.IjE) });
    this.mIsForeground = false;
    if (com.tencent.mm.plugin.game.chatroom.g.a.Xd(this.IjE)) {
      b.c(this.IqW);
    }
    if (this.Irb.getTag() != null)
    {
      pr localpr = new pr();
      localpr.hSS.opType = 2;
      localpr.publish();
    }
    AppMethodBeat.o(276569);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(276570);
    if (paramp.getType() == 4562)
    {
      paramString = (com.tencent.mm.plugin.game.chatroom.c.e)paramp;
      Log.i("GameChatRoom.GameChatListView", "GetGameChatRoomMsg callback, localChannelId:%d, requestChannelId:%d", new Object[] { Integer.valueOf(this.IjE), Integer.valueOf(paramString.fCA().channel_id) });
      if (this.IjE != paramString.fCA().channel_id)
      {
        AppMethodBeat.o(276570);
        return;
      }
      if (paramString.Ijd == 1) {
        this.Irh = true;
      }
      while ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (GetChatroomMsgResponse)c.c.b(paramString.mtC.otC);
        if (paramString.Ijd == 6)
        {
          if (!Util.isNullOrNil(paramp.msg_pack_list))
          {
            this.Irj.put(Long.valueOf(paramString.Ije), paramp.msg_pack_list);
            AppMethodBeat.o(276570);
            return;
            if (paramString.Ijd == 2) {
              this.Iri = true;
            }
          }
        }
        else
        {
          if (paramString.Ijd == 4)
          {
            a(paramp.msg_pack_list, paramString.Ijd, paramString.Ije);
            AppMethodBeat.o(276570);
            return;
          }
          a(paramp.msg_pack_list, paramString.Ijd, null);
        }
      }
    }
    AppMethodBeat.o(276570);
  }
  
  public void setChatRoomInfo(String paramString)
  {
    AppMethodBeat.i(276578);
    this.lBQ = paramString;
    paramString = com.tencent.mm.game.report.d.mty;
    d.a.f(1304L, this.Ijq, this.Ijr);
    AppMethodBeat.o(276578);
  }
  
  public void setChatRoomJumpInfo(ChatroomJumpInfo paramChatroomJumpInfo)
  {
    this.IlW = paramChatroomJumpInfo;
  }
  
  public void setHostContact(com.tencent.mm.plugin.game.chatroom.b.c paramc)
  {
    this.IlU = paramc;
  }
  
  public void setJumpFirstSeq(long paramLong)
  {
    AppMethodBeat.i(276575);
    this.Imb = paramLong;
    if (this.IqW != null)
    {
      b localb = this.IqW;
      Iterator localIterator = localb.IrB.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).Imb = localb.Irr.Imb;
      }
    }
    AppMethodBeat.o(276575);
  }
  
  public void setPreloadInfo(JumpInfo paramJumpInfo)
  {
    this.IlV = paramJumpInfo;
  }
  
  public void setPremadeCardInfo(String paramString)
  {
    AppMethodBeat.i(276579);
    this.Ima = paramString;
    this.IqW.fDC();
    AppMethodBeat.o(276579);
  }
  
  final class a
    extends androidx.recyclerview.widget.g.a
  {
    private Set<Long> Irv;
    private List<ChatroomMsgPack> uoj;
    private List<ChatroomMsgPack> uok;
    
    public a(List<ChatroomMsgPack> paramList, List<Long> paramList1)
    {
      AppMethodBeat.i(276456);
      this.Irv = new HashSet();
      this.uoj = paramList;
      this.uok = paramList1;
      Collection localCollection;
      if (localCollection != null) {
        this.Irv.addAll(localCollection);
      }
      AppMethodBeat.o(276456);
    }
    
    private static boolean c(ChatroomMsgPack paramChatroomMsgPack)
    {
      return (paramChatroomMsgPack.msg_options != null) && (paramChatroomMsgPack.msg_options.cli_local_data != null);
    }
    
    private boolean d(ChatroomMsgPack paramChatroomMsgPack)
    {
      AppMethodBeat.i(276464);
      if (this.Irv.contains(Long.valueOf(paramChatroomMsgPack.seq)))
      {
        AppMethodBeat.o(276464);
        return true;
      }
      AppMethodBeat.o(276464);
      return false;
    }
    
    public final int If()
    {
      AppMethodBeat.i(276470);
      int i = this.uoj.size();
      AppMethodBeat.o(276470);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(276478);
      int i = this.uok.size();
      AppMethodBeat.o(276478);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276485);
      ChatroomMsgPack localChatroomMsgPack1 = (ChatroomMsgPack)this.uoj.get(paramInt1);
      ChatroomMsgPack localChatroomMsgPack2 = (ChatroomMsgPack)this.uok.get(paramInt2);
      if (localChatroomMsgPack1.seq == localChatroomMsgPack2.seq)
      {
        AppMethodBeat.o(276485);
        return true;
      }
      AppMethodBeat.o(276485);
      return false;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276490);
      ChatroomMsgPack localChatroomMsgPack1 = (ChatroomMsgPack)this.uoj.get(paramInt1);
      ChatroomMsgPack localChatroomMsgPack2 = (ChatroomMsgPack)this.uok.get(paramInt2);
      if ((!c(localChatroomMsgPack1)) && (!c(localChatroomMsgPack2)) && (!d(localChatroomMsgPack1)) && (!d(localChatroomMsgPack2)))
      {
        AppMethodBeat.o(276490);
        return true;
      }
      AppMethodBeat.o(276490);
      return false;
    }
  }
  
  public final class b
    extends RecyclerView.a<k>
  {
    public Map<String, b.d> IrA;
    public Set<k> IrB;
    private b.b IrC;
    private Set<Long> IrD;
    private List<Long> IrE;
    private boolean IrF;
    private long IrG;
    private int Irw;
    List<ChatroomMsgPack> Irx;
    private List<ChatroomMsgPack> Iry;
    private Map<String, ChatroomMsgPack> Irz;
    
    public b()
    {
      AppMethodBeat.i(276473);
      this.Irw = 0;
      this.Irx = new LinkedList();
      this.Iry = new LinkedList();
      this.Irz = new ConcurrentHashMap();
      this.IrA = new ConcurrentHashMap();
      this.IrB = new HashSet();
      this.IrC = new b.b();
      this.IrD = new HashSet();
      this.IrE = new ArrayList();
      this.IrF = false;
      this.IrG = -1L;
      AppMethodBeat.o(276473);
    }
    
    private void D(List<ChatroomMsgPack> paramList1, List<ChatroomMsgPack> paramList2)
    {
      AppMethodBeat.i(276495);
      if (!com.tencent.mm.plugin.game.chatroom.g.a.Xe(GameChatListView.a(GameChatListView.this)))
      {
        AppMethodBeat.o(276495);
        return;
      }
      long l4 = 0L;
      long l1 = 9223372036854775807L;
      int i = 0;
      while (i < paramList1.size())
      {
        long l2 = ((ChatroomMsgPack)paramList1.get(i)).seq;
        long l3 = l4;
        if (l2 > l4) {
          l3 = l2;
        }
        l4 = l1;
        if (l2 < l1) {
          l4 = l2;
        }
        i += 1;
        l1 = l4;
        l4 = l3;
      }
      paramList2 = paramList2.iterator();
      for (;;)
      {
        if (!paramList2.hasNext()) {
          break label255;
        }
        ChatroomMsgPack localChatroomMsgPack1 = (ChatroomMsgPack)paramList2.next();
        if (localChatroomMsgPack1.channel_id == GameChatListView.a(GameChatListView.this))
        {
          if ((GameChatListView.n(GameChatListView.this)) || (paramList1.size() == 0) || ((localChatroomMsgPack1.seq >= l1) && (localChatroomMsgPack1.seq <= l4))) {
            paramList1.add(localChatroomMsgPack1);
          }
        }
        else
        {
          Iterator localIterator = paramList1.iterator();
          if (localIterator.hasNext())
          {
            ChatroomMsgPack localChatroomMsgPack2 = (ChatroomMsgPack)localIterator.next();
            if (localChatroomMsgPack1.seq != localChatroomMsgPack2.seq) {
              break;
            }
            localIterator.remove();
          }
        }
      }
      label255:
      AppMethodBeat.o(276495);
    }
    
    private static List<Long> E(List<ChatroomMsgPack> paramList1, List<ChatroomMsgPack> paramList2)
    {
      AppMethodBeat.i(276520);
      ArrayList localArrayList = new ArrayList();
      if ((Util.isNullOrNil(paramList1)) || (Util.isNullOrNil(paramList2)))
      {
        AppMethodBeat.o(276520);
        return localArrayList;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        ChatroomMsgPack localChatroomMsgPack1 = (ChatroomMsgPack)paramList1.next();
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          ChatroomMsgPack localChatroomMsgPack2 = (ChatroomMsgPack)localIterator.next();
          if ((localChatroomMsgPack1.seq == localChatroomMsgPack2.seq) && ((localChatroomMsgPack2.msg_options == null) || (localChatroomMsgPack2.msg_options.cli_local_data == null)))
          {
            paramList2.set(paramList2.indexOf(localChatroomMsgPack2), localChatroomMsgPack1);
            localArrayList.add(Long.valueOf(localChatroomMsgPack1.seq));
          }
        }
      }
      AppMethodBeat.o(276520);
      return localArrayList;
    }
    
    private void a(List<ChatroomMsgPack> paramList1, int paramInt, long paramLong, List<ChatroomMsgPack> paramList2)
    {
      Object localObject1;
      label115:
      long l;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(276513);
          if (paramInt == 4)
          {
            if (Util.isNullOrNil(paramList1)) {
              continue;
            }
            localObject1 = paramList1.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            if (((ChatroomMsgPack)((Iterator)localObject1).next()).seq != paramLong) {
              continue;
            }
            i = 1;
            if (i == 0) {
              rD(paramLong);
            }
          }
          if ((!Util.isNullOrNil(paramList1)) || (!Util.isNullOrNil(paramList2))) {
            break label203;
          }
          if (paramInt == 1)
          {
            if (com.tencent.mm.plugin.game.chatroom.g.a.Xe(GameChatListView.a(GameChatListView.this))) {
              break label195;
            }
            GameChatListView.b(GameChatListView.this, false);
            AppMethodBeat.o(276513);
            return;
            i = 0;
            continue;
          }
          if (paramInt == 2)
          {
            if (!com.tencent.mm.plugin.game.chatroom.g.a.Xe(GameChatListView.a(GameChatListView.this))) {
              GameChatListView.c(GameChatListView.this, false);
            }
            GameChatListView.c(GameChatListView.this).clear();
            Log.i("GameChatRoom.GameChatListView", "clear msg list cache 1");
            AppMethodBeat.o(276513);
            continue;
          }
          if (paramInt != 4) {
            break label195;
          }
        }
        finally {}
        GameChatListView.o(GameChatListView.this);
        label195:
        AppMethodBeat.o(276513);
        continue;
        label203:
        localObject1 = paramList1;
        if (paramList1 == null) {
          localObject1 = new ArrayList();
        }
        paramList1 = paramList2;
        if (paramList2 == null) {
          paramList1 = new ArrayList();
        }
        Log.i("GameChatRoom.GameChatListView", "add chatItem list size:%d, dataFromType:%d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramInt) });
        Log.d("GameChatRoom.GameChatListView", "new list:%s", new Object[] { io((List)localObject1) });
        Log.d("GameChatRoom.GameChatListView", "before list:%s", new Object[] { io(this.Irx) });
        paramList2 = new LinkedList();
        paramList2.addAll(this.Irx);
        l = System.currentTimeMillis();
        this.Irw = 0;
        switch (paramInt)
        {
        case 6: 
          AppMethodBeat.o(276513);
        }
      }
      this.Irx.addAll(0, (Collection)localObject1);
      int i = 0;
      label408:
      Object localObject2;
      label772:
      for (;;)
      {
        D(this.Irx, paramList1);
        localObject1 = this.Irx;
        localObject2 = new TreeSet(new Comparator() {});
        ((Set)localObject2).addAll((Collection)localObject1);
        this.Irx = new ArrayList((Collection)localObject2);
        if ((paramInt != 4) && (this.Irx.size() > 0) && (GameChatListView.c(GameChatListView.this).size() > 0) && (((ChatroomMsgPack)this.Irx.get(this.Irx.size() - 1)).seq >= ((ChatroomMsgPack)GameChatListView.c(GameChatListView.this).get(GameChatListView.c(GameChatListView.this).size() - 1)).seq))
        {
          GameChatListView.c(GameChatListView.this).clear();
          Log.i("GameChatRoom.GameChatListView", "clear msg list cache 2");
        }
        this.Irx.removeAll(this.Iry);
        this.Iry.clear();
        Log.d("GameChatRoom.GameChatListView", "after list:%s", new Object[] { io(this.Irx) });
        if ((!com.tencent.mm.plugin.game.chatroom.g.a.Xe(GameChatListView.a(GameChatListView.this))) && (i != 0) && (this.Irx.size() > 0))
        {
          paramLong = ((ChatroomMsgPack)this.Irx.get(this.Irx.size() - 1)).seq;
          if (GameChatListView.r(GameChatListView.this) < paramLong) {
            this.IrF = true;
          }
        }
        if (this.IrF) {
          this.IrG = fDB();
        }
        paramList1 = E(paramList1, this.Irx);
        if (paramInt != 4) {
          break label1448;
        }
        this.bZE.notifyChanged();
        label732:
        switch (this.Irw)
        {
        case 0: 
          k(1, false, true);
          k(2, true, false);
          Log.d("GameChatRoom.GameChatListView", "add msg to list cost time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(276513);
          break label115;
          this.Irx.addAll((Collection)localObject1);
          i = 0;
          continue;
          GameChatListView.b(GameChatListView.this, true);
          GameChatListView.c(GameChatListView.this, true);
          this.IrC.reset();
          this.IrD.clear();
          paramList2.clear();
          if (GameChatListView.c(GameChatListView.this).size() == 0) {
            GameChatListView.c(GameChatListView.this).addAll(this.Irx);
          }
          this.Irx.clear();
          this.Irz.clear();
          this.Irx.addAll((Collection)localObject1);
          this.Irw = 1;
          GameChatListView.o(GameChatListView.this);
          if (GameChatListView.j(GameChatListView.this) != null) {
            GameChatListView.j(GameChatListView.this).a(GameChatListView.f(GameChatListView.this));
          }
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276194);
              Iterator localIterator = GameChatListView.b.h(GameChatListView.b.this).iterator();
              while (localIterator.hasNext())
              {
                k localk = (k)localIterator.next();
                if ((localk.Ily != null) && (localk.Ily.seq == GameChatListView.C(GameChatListView.this)))
                {
                  localk.IlX = GameChatListView.C(GameChatListView.this);
                  localk.fCP();
                  GameChatListView.D(GameChatListView.this);
                }
              }
              AppMethodBeat.o(276194);
            }
          }, 2000L);
          i = 0;
        }
      }
      if (this.Irx.size() > 0) {
        paramLong = ((ChatroomMsgPack)this.Irx.get(this.Irx.size() - 1)).seq;
      }
      for (;;)
      {
        if (i < ((List)localObject1).size())
        {
          localObject2 = (ChatroomMsgPack)((List)localObject1).get(i);
          ((ChatroomMsgPack)localObject2).seq = paramLong;
          ((List)localObject1).set(i, localObject2);
          this.Irz.put(((ChatroomMsgPack)localObject2).cli_msg_id, localObject2);
          i += 1;
        }
        else
        {
          this.Irx.addAll((Collection)localObject1);
          this.Irw = 3;
          i = 0;
          break label408;
          if (GameChatListView.p(GameChatListView.this)) {
            this.Irx.clear();
          }
          if (GameChatListView.c(GameChatListView.this).size() == 0)
          {
            this.Irx.addAll((Collection)localObject1);
            if (GameChatListView.n(GameChatListView.this)) {
              this.Irw = 4;
            }
          }
          for (;;)
          {
            if (GameChatListView.p(GameChatListView.this))
            {
              GameChatListView.o(GameChatListView.this);
              GameChatListView.q(GameChatListView.this);
              this.Irw = 3;
              i = 1;
              break;
              GameChatListView.c(GameChatListView.this).addAll((Collection)localObject1);
              localObject1 = GameChatListView.this;
              localObject2 = GameChatListView.c(GameChatListView.this);
              TreeSet localTreeSet = new TreeSet(new Comparator() {});
              localTreeSet.addAll((Collection)localObject2);
              GameChatListView.b((GameChatListView)localObject1, new ArrayList(localTreeSet));
              Log.d("GameChatRoom.GameChatListView", "add new msg to cache");
              continue;
              GameChatListView.b(GameChatListView.this, true);
              GameChatListView.c(GameChatListView.this, true);
              this.IrC.reset();
              this.IrD.clear();
              this.Irx.clear();
              this.Irx.addAll((Collection)localObject1);
              this.Irw = 3;
              GameChatListView.c(GameChatListView.this).clear();
              Log.i("GameChatRoom.GameChatListView", "clear msg list cache 3");
              i = 0;
              break;
              GameChatListView.b(GameChatListView.this, false);
              GameChatListView.c(GameChatListView.this, false);
              this.Irx.addAll((Collection)localObject1);
              this.Irw = 3;
              i = 0;
              break;
              label1448:
              g.a(new GameChatListView.a(GameChatListView.this, paramList2, this.Irx, paramList1)).a(new androidx.recyclerview.widget.q()
              {
                public final void aR(final int paramAnonymousInt1, final int paramAnonymousInt2)
                {
                  AppMethodBeat.i(276187);
                  GameChatListView.f(GameChatListView.this).bA(paramAnonymousInt1, paramAnonymousInt2);
                  if (com.tencent.mm.plugin.game.chatroom.g.a.Xe(GameChatListView.a(GameChatListView.this))) {
                    com.tencent.threadpool.h.ahAA.o(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(276379);
                        GameChatListView.f(GameChatListView.this).e(paramAnonymousInt1, paramAnonymousInt2 + 10, null);
                        AppMethodBeat.o(276379);
                      }
                    }, 0L);
                  }
                  Log.d("GameChatRoom.GameChatListView", "test AdapterDiffCallback, channelId:%d, onInserted，postion:%d, count:%d", new Object[] { Integer.valueOf(GameChatListView.a(GameChatListView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                  AppMethodBeat.o(276187);
                }
                
                public final void aS(int paramAnonymousInt1, int paramAnonymousInt2)
                {
                  AppMethodBeat.i(276197);
                  GameChatListView.f(GameChatListView.this).bB(paramAnonymousInt1, paramAnonymousInt2);
                  Log.d("GameChatRoom.GameChatListView", "test AdapterDiffCallback, channelId:%d, onRemoved，postion:%d, count:%d", new Object[] { Integer.valueOf(GameChatListView.a(GameChatListView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                  AppMethodBeat.o(276197);
                }
                
                public final void aW(int paramAnonymousInt1, int paramAnonymousInt2)
                {
                  AppMethodBeat.i(276202);
                  GameChatListView.f(GameChatListView.this).bz(paramAnonymousInt1, paramAnonymousInt2);
                  Log.d("GameChatRoom.GameChatListView", "test AdapterDiffCallback, channelId:%d, onMoved，fromPosition:%d, toPosition:%d", new Object[] { Integer.valueOf(GameChatListView.a(GameChatListView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                  AppMethodBeat.o(276202);
                }
                
                public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                {
                  AppMethodBeat.i(276209);
                  GameChatListView.f(GameChatListView.this).e(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
                  Log.d("GameChatRoom.GameChatListView", "test AdapterDiffCallback, channelId:%d, onChanged，position:%d, count:%d", new Object[] { Integer.valueOf(GameChatListView.a(GameChatListView.this)), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                  AppMethodBeat.o(276209);
                }
              });
              break label732;
              paramList1 = GameChatListView.this;
              paramList2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramList1, paramList2.aYi(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "scrollToPosition", "(I)V");
              paramList1.scrollToPosition(((Integer)paramList2.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramList1, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "scrollToPosition", "(I)V");
              break label772;
              paramList1 = GameChatListView.this;
              paramList2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramList1, paramList2.aYi(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
              paramList1.smoothScrollToPosition(((Integer)paramList2.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramList1, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
              break label772;
              if (GameChatListView.f(GameChatListView.this).getItemCount() <= 0) {
                break label772;
              }
              paramList1 = GameChatListView.this;
              paramList2 = com.tencent.mm.hellhoundlib.b.c.a(GameChatListView.f(GameChatListView.this).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramList1, paramList2.aYi(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "scrollToPosition", "(I)V");
              paramList1.scrollToPosition(((Integer)paramList2.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramList1, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "scrollToPosition", "(I)V");
              break label772;
              if (GameChatListView.f(GameChatListView.this).getItemCount() <= 0) {
                break label772;
              }
              paramList1 = GameChatListView.this;
              paramList2 = com.tencent.mm.hellhoundlib.b.c.a(GameChatListView.f(GameChatListView.this).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramList1, paramList2.aYi(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
              paramList1.smoothScrollToPosition(((Integer)paramList2.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramList1, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "doScroll", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
              break label772;
            }
          }
          i = 0;
          break label408;
          paramLong = 9223372036854765807L;
          break label1894;
          break;
          break label772;
          label1894:
          i = 0;
        }
      }
    }
    
    private long fDB()
    {
      AppMethodBeat.i(276530);
      if (this.IrG != -1L)
      {
        l = this.IrG;
        AppMethodBeat.o(276530);
        return l;
      }
      int i = this.Irx.size() - 1;
      while (i > 0)
      {
        if ((((ChatroomMsgPack)this.Irx.get(i)).seq > GameChatListView.r(GameChatListView.this)) && (((ChatroomMsgPack)this.Irx.get(i - 1)).seq <= GameChatListView.r(GameChatListView.this)))
        {
          l = ((ChatroomMsgPack)this.Irx.get(i)).seq;
          AppMethodBeat.o(276530);
          return l;
        }
        i -= 1;
      }
      long l = this.IrG;
      AppMethodBeat.o(276530);
      return l;
    }
    
    private static String io(List<ChatroomMsgPack> paramList)
    {
      AppMethodBeat.i(276483);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("[");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localStringBuffer.append(((ChatroomMsgPack)paramList.next()).seq);
        localStringBuffer.append(",");
      }
      localStringBuffer.append("]");
      paramList = localStringBuffer.toString();
      AppMethodBeat.o(276483);
      return paramList;
    }
    
    private void ip(List<ChatroomMsgPack> paramList)
    {
      AppMethodBeat.i(276539);
      if ((Util.isNullOrNil(paramList)) || (Util.isNullOrNil(GameChatListView.i(GameChatListView.this))))
      {
        AppMethodBeat.o(276539);
        return;
      }
      long l3 = 0L;
      paramList = paramList.iterator();
      long l1 = 9223372036854775807L;
      Object localObject;
      long l2;
      if (paramList.hasNext())
      {
        localObject = (ChatroomMsgPack)paramList.next();
        l2 = l3;
        if (((ChatroomMsgPack)localObject).seq > l3) {
          l2 = ((ChatroomMsgPack)localObject).seq;
        }
        if (((ChatroomMsgPack)localObject).seq >= l1) {
          break label188;
        }
        l1 = ((ChatroomMsgPack)localObject).seq;
      }
      label188:
      for (;;)
      {
        l3 = l2;
        break;
        paramList = GameChatListView.i(GameChatListView.this).iterator();
        while (paramList.hasNext())
        {
          localObject = (GameChatListView.d)paramList.next();
          if ((((GameChatListView.d)localObject).IrN.seq >= l1) && (((GameChatListView.d)localObject).IrN.seq <= l3)) {
            ((GameChatListView.d)localObject).mhq = true;
          }
        }
        AppMethodBeat.o(276539);
        return;
      }
    }
    
    private void k(final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
    {
      AppMethodBeat.i(276525);
      if (!com.tencent.mm.plugin.game.chatroom.g.a.Xd(GameChatListView.a(GameChatListView.this)))
      {
        AppMethodBeat.o(276525);
        return;
      }
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276189);
          if (paramInt == 1) {}
          int k;
          int i;
          int j;
          for (long l = GameChatListView.s(GameChatListView.this);; l = GameChatListView.t(GameChatListView.this))
          {
            if (l <= 0L) {
              break label208;
            }
            k = 0;
            i = 0;
            if (GameChatListView.c(GameChatListView.this).size() <= 0) {
              break label214;
            }
            j = GameChatListView.c(GameChatListView.this).size() - 1;
            while ((j >= 0) && (((ChatroomMsgPack)GameChatListView.c(GameChatListView.this).get(j)).seq > l) && (!GameChatListView.b.a(GameChatListView.b.this, (ChatroomMsgPack)GameChatListView.c(GameChatListView.this).get(j))))
            {
              i += 1;
              j -= 1;
            }
          }
          for (;;)
          {
            if (paramBoolean1)
            {
              qf localqf = new qf();
              localqf.hTp.hTq = i;
              localqf.publish();
            }
            if (paramBoolean2) {
              GameChatListView.a(GameChatListView.this, i);
            }
            label208:
            AppMethodBeat.o(276189);
            return;
            label214:
            if (GameChatListView.b.g(GameChatListView.b.this).size() <= 0)
            {
              AppMethodBeat.o(276189);
              return;
            }
            j = GameChatListView.b.g(GameChatListView.b.this).size() - 1;
            i = k;
            while ((j >= 0) && (((ChatroomMsgPack)GameChatListView.b.g(GameChatListView.b.this).get(j)).seq > l) && (!GameChatListView.b.a(GameChatListView.b.this, (ChatroomMsgPack)GameChatListView.b.g(GameChatListView.b.this).get(j))))
            {
              i += 1;
              j -= 1;
            }
          }
        }
      }, 200L);
      AppMethodBeat.o(276525);
    }
    
    private void rD(long paramLong)
    {
      AppMethodBeat.i(276534);
      Iterator localIterator = GameChatListView.i(GameChatListView.this).iterator();
      while (localIterator.hasNext())
      {
        GameChatListView.d locald = (GameChatListView.d)localIterator.next();
        if (locald.IrN.seq == paramLong)
        {
          locald.mhq = true;
          AppMethodBeat.o(276534);
          return;
        }
      }
      AppMethodBeat.o(276534);
    }
    
    public final void fDC()
    {
      AppMethodBeat.i(276562);
      Log.i("GameChatRoom.GameChatListView", "updateUserStateInViewScope size:%d", new Object[] { Integer.valueOf(this.IrB.size()) });
      Iterator localIterator = this.IrB.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if ((localk.Ily != null) && (localk.Ily.msg_content != null) && (localk.Ily.msg_content.chatroom_text != null)) {
          Log.d("GameChatRoom.GameChatListView", "updateUserStateInViewScope content:%s", new Object[] { localk.Ily.msg_content.chatroom_text.content });
        }
        localk.aq(GameChatListView.z(GameChatListView.this));
        localk.Ima = GameChatListView.A(GameChatListView.this);
        localk.fCR();
      }
      AppMethodBeat.o(276562);
    }
    
    /* Error */
    public final void fp(String paramString, int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 757
      //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_1
      //   9: invokestatic 760	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifne +16 -> 28
      //   15: aload_0
      //   16: getfield 76	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:Irz	Ljava/util/Map;
      //   19: aload_1
      //   20: invokeinterface 763 2 0
      //   25: ifne +12 -> 37
      //   28: ldc_w 757
      //   31: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aload_0
      //   35: monitorexit
      //   36: return
      //   37: aload_0
      //   38: getfield 76	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:Irz	Ljava/util/Map;
      //   41: aload_1
      //   42: invokeinterface 679 2 0
      //   47: checkcast 132	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack
      //   50: astore_1
      //   51: aload_0
      //   52: getfield 69	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:Irx	Ljava/util/List;
      //   55: aload_1
      //   56: invokeinterface 188 2 0
      //   61: istore_3
      //   62: iload_3
      //   63: iflt +79 -> 142
      //   66: aload_1
      //   67: getfield 178	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   70: ifnull +72 -> 142
      //   73: aload_1
      //   74: getfield 178	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   77: getfield 184	com/tencent/mm/plugin/game/autogen/chatroom/MsgOptions:cli_local_data	Lcom/tencent/mm/bx/b;
      //   80: ifnull +62 -> 142
      //   83: aload_1
      //   84: getfield 178	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   87: getfield 184	com/tencent/mm/plugin/game/autogen/chatroom/MsgOptions:cli_local_data	Lcom/tencent/mm/bx/b;
      //   90: invokevirtual 769	com/tencent/mm/bx/b:toByteArray	()[B
      //   93: invokestatic 774	com/tencent/mm/b/o:Z	([B)J
      //   96: invokestatic 780	com/tencent/mm/plugin/game/chatroom/e:rA	(J)I
      //   99: istore 4
      //   101: aload_1
      //   102: getfield 178	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   105: new 765	com/tencent/mm/bx/b
      //   108: dup
      //   109: iload 4
      //   111: iconst_4
      //   112: ishl
      //   113: iload_2
      //   114: ior
      //   115: i2l
      //   116: invokestatic 784	com/tencent/mm/b/o:dV	(J)[B
      //   119: invokespecial 787	com/tencent/mm/bx/b:<init>	([B)V
      //   122: putfield 184	com/tencent/mm/plugin/game/autogen/chatroom/MsgOptions:cli_local_data	Lcom/tencent/mm/bx/b;
      //   125: aload_0
      //   126: getfield 69	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:Irx	Ljava/util/List;
      //   129: iload_3
      //   130: aload_1
      //   131: invokeinterface 192 3 0
      //   136: pop
      //   137: aload_0
      //   138: iload_3
      //   139: invokevirtual 790	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:fV	(I)V
      //   142: ldc_w 757
      //   145: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   148: goto -114 -> 34
      //   151: astore_1
      //   152: aload_0
      //   153: monitorexit
      //   154: aload_1
      //   155: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	b
      //   0	156	1	paramString	String
      //   0	156	2	paramInt	int
      //   61	78	3	i	int
      //   99	14	4	j	int
      // Exception table:
      //   from	to	target	type
      //   2	28	151	finally
      //   28	34	151	finally
      //   37	62	151	finally
      //   66	142	151	finally
      //   142	148	151	finally
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276560);
      int i = this.Irx.size();
      AppMethodBeat.o(276560);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(276559);
      ChatroomMsgPack localChatroomMsgPack = (ChatroomMsgPack)this.Irx.get(paramInt);
      paramInt = com.tencent.mm.plugin.game.chatroom.d.jc(localChatroomMsgPack.msg_type, localChatroomMsgPack.msg_sub_type);
      AppMethodBeat.o(276559);
      return paramInt;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(GameChatListView.b paramb);
    
    public abstract void b(GameChatListView.b paramb);
  }
  
  static class d
  {
    public NoticeMsg IrN;
    public boolean mhq = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatListView
 * JD-Core Version:    0.7.0.1
 */