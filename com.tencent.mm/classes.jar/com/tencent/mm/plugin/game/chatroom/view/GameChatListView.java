package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.h.c;
import androidx.recyclerview.widget.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.sp;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameChatListView
  extends MRecyclerView
  implements i
{
  private long Cuy;
  private long Cuz;
  private com.tencent.mm.plugin.game.chatroom.b.c Cvr;
  private JumpInfo CwI;
  public b CyC;
  public int CyD;
  private boolean CyE;
  private long CyF;
  public TextView CyG;
  public TextView CyH;
  private c CyI;
  private boolean CyJ;
  private boolean CyK;
  private List<ChatroomMsgPack> CyL;
  public List<ChatroomMsgPack> CyM;
  public boolean CyN;
  public Set<Long> CyO;
  long CyP;
  private String iZU;
  public LinearLayoutManager jbn;
  private Context mContext;
  
  public GameChatListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(211841);
    this.CyD = 1;
    this.CyE = true;
    this.CyF = 0L;
    this.CyJ = true;
    this.CyK = true;
    this.CyL = new CopyOnWriteArrayList();
    this.CyM = new CopyOnWriteArrayList();
    this.CyN = true;
    this.CyO = new LinkedHashSet();
    this.CyP = 9223372036854775807L;
    init(paramContext);
    AppMethodBeat.o(211841);
  }
  
  public GameChatListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211844);
    this.CyD = 1;
    this.CyE = true;
    this.CyF = 0L;
    this.CyJ = true;
    this.CyK = true;
    this.CyL = new CopyOnWriteArrayList();
    this.CyM = new CopyOnWriteArrayList();
    this.CyN = true;
    this.CyO = new LinkedHashSet();
    this.CyP = 9223372036854775807L;
    init(paramContext);
    AppMethodBeat.o(211844);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(211869);
    this.mContext = paramContext;
    this.Cuz = ((Activity)paramContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Cuy = ((Activity)paramContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.jbn = new LinearLayoutManager();
    setLayoutManager(this.jbn);
    setItemAnimator(null);
    this.CyC = new b();
    this.CyC.aw(true);
    setAdapter(this.CyC);
    a(new RecyclerView.l()
    {
      int rFX = 0;
      int svC = 0;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(211826);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatListView$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (GameChatListView.h(GameChatListView.this) != null))
        {
          if ((GameChatListView.i(GameChatListView.this)) && (this.rFX == GameChatListView.c(GameChatListView.this).getItemCount() - 1)) {
            GameChatListView.h(GameChatListView.this).b(GameChatListView.c(GameChatListView.this));
          }
          if ((GameChatListView.j(GameChatListView.this)) && (this.svC == 0)) {
            GameChatListView.h(GameChatListView.this).a(GameChatListView.c(GameChatListView.this));
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(211826);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(211827);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatListView$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager();
        this.svC = paramAnonymousRecyclerView.kJ();
        this.rFX = paramAnonymousRecyclerView.kL();
        paramAnonymousInt1 = paramAnonymousRecyclerView.getChildCount();
        paramAnonymousInt2 = paramAnonymousRecyclerView.getItemCount();
        if (paramAnonymousInt1 + this.svC >= paramAnonymousInt2)
        {
          GameChatListView.a(GameChatListView.this, true);
          GameChatListView.a(GameChatListView.this, 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(211827);
          return;
          GameChatListView.a(GameChatListView.this, false);
        }
      }
    });
    this.CyI = new c()
    {
      public final void a(GameChatListView.b paramAnonymousb)
      {
        AppMethodBeat.i(211299);
        GameChatListView.b(GameChatListView.this, false);
        if (paramAnonymousb.CyS.size() > 0) {}
        for (long l = ((ChatroomMsgPack)paramAnonymousb.CyS.get(0)).seq;; l = 0L)
        {
          Log.i("GameChatRoom.GameChatListView", "onTopLoadMore topSeq:%d", new Object[] { Long.valueOf(l) });
          paramAnonymousb = new com.tencent.mm.plugin.game.chatroom.c.d(GameChatListView.k(GameChatListView.this), 0L, l, 1);
          h.aGY().a(paramAnonymousb, 0);
          AppMethodBeat.o(211299);
          return;
        }
      }
      
      public final void b(GameChatListView.b paramAnonymousb)
      {
        AppMethodBeat.i(211301);
        GameChatListView.c(GameChatListView.this, false);
        if (paramAnonymousb.CyS.size() > 0) {}
        for (long l = ((ChatroomMsgPack)paramAnonymousb.CyS.get(paramAnonymousb.CyS.size() - 1)).seq;; l = 0L)
        {
          Log.i("GameChatRoom.GameChatListView", "onBottomLoadMore, bottomSeq:%d", new Object[] { Long.valueOf(l) });
          paramAnonymousb = new com.tencent.mm.plugin.game.chatroom.c.d(GameChatListView.k(GameChatListView.this), l, 0L, 2);
          h.aGY().a(paramAnonymousb, 0);
          AppMethodBeat.o(211301);
          return;
        }
      }
    };
    AppMethodBeat.o(211869);
  }
  
  private void setAtTag(long paramLong)
  {
    AppMethodBeat.i(211866);
    Log.i("GameChatRoom.GameChatListView", "setAtTag, atSeq:%d", new Object[] { Long.valueOf(paramLong) });
    Object localObject;
    if (this.CyH != null)
    {
      this.CyH.setVisibility(0);
      localObject = com.tencent.mm.game.report.d.jTj;
      d.a.a(2L, 1L, this.Cuy, this.Cuz, paramLong, "");
      this.CyH.setTag(Long.valueOf(paramLong));
      this.CyL.clear();
      localObject = this.CyC;
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)((b)localObject).CyQ.getLayoutManager();
      i = localLinearLayoutManager.kJ();
      int j = localLinearLayoutManager.kL();
      Log.i("GameChatRoom.GameChatListView", "notifyAtEvent, atSeq:%d, firstVisibleItem:%d, lastVisibleItem:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j) });
      if (i > j) {
        break label274;
      }
      if ((i < 0) || (i >= ((b)localObject).CyS.size()) || (((ChatroomMsgPack)((b)localObject).CyS.get(i)).seq != paramLong)) {
        break label267;
      }
      ((b)localObject).cL(i);
    }
    label267:
    label274:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramLong -= 2L;
        Log.i("GameChatRoom.GameChatListView", "pre fetch at page, seq:%d", new Object[] { Long.valueOf(paramLong) });
        localObject = new com.tencent.mm.plugin.game.chatroom.c.d(this.iZU, paramLong, 0L, 6);
        h.aGY().a((q)localObject, 0);
      }
      AppMethodBeat.o(211866);
      return;
      i += 1;
      break;
    }
  }
  
  public Set<Long> getAllAtMeSeq()
  {
    return this.CyO;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(211849);
    super.onAttachedToWindow();
    h.aGY().a(4562, this);
    AppMethodBeat.o(211849);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(211851);
    super.onDetachedFromWindow();
    h.aGY().b(4562, this);
    AppMethodBeat.o(211851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(211855);
    if (paramq.getType() == 4562)
    {
      paramString = (com.tencent.mm.plugin.game.chatroom.c.d)paramq;
      if (paramString.Cuw == 1) {
        this.CyJ = true;
      }
      while ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (GetChatroomMsgResponse)d.c.b(paramString.jTk.lBS);
        if (paramString.Cuw == 6)
        {
          if (!Util.isNullOrNil(paramq.msg_pack_list))
          {
            this.CyL.addAll(paramq.msg_pack_list);
            AppMethodBeat.o(211855);
            return;
            if (paramString.Cuw == 2) {
              this.CyK = true;
            }
          }
        }
        else {
          w(paramq.msg_pack_list, paramString.Cuw);
        }
      }
    }
    AppMethodBeat.o(211855);
  }
  
  public void setChatRoomInfo(String paramString)
  {
    AppMethodBeat.i(211860);
    this.iZU = paramString;
    paramString = com.tencent.mm.game.report.d.jTj;
    d.a.e(1304L, this.Cuy, this.Cuz);
    AppMethodBeat.o(211860);
  }
  
  public void setHostContact(com.tencent.mm.plugin.game.chatroom.b.c paramc)
  {
    this.Cvr = paramc;
  }
  
  public void setPreloadInfo(JumpInfo paramJumpInfo)
  {
    this.CwI = paramJumpInfo;
  }
  
  public final void w(List<ChatroomMsgPack> paramList, int paramInt)
  {
    AppMethodBeat.i(211858);
    if (paramList == null)
    {
      AppMethodBeat.o(211858);
      return;
    }
    b.a(this.CyC, paramList, paramInt);
    AppMethodBeat.o(211858);
  }
  
  final class a
    extends h.c<ChatroomMsgPack>
  {
    private a() {}
  }
  
  public final class b
    extends r<ChatroomMsgPack, g>
  {
    List<ChatroomMsgPack> CyS;
    private List<ChatroomMsgPack> CyT;
    private Map<String, ChatroomMsgPack> CyU;
    public Map<String, b.b> CyV;
    private List<Long> CyW;
    
    public b()
    {
      this(new GameChatListView.a(GameChatListView.this, (byte)0));
      AppMethodBeat.i(210827);
      AppMethodBeat.o(210827);
    }
    
    private b()
    {
      super();
      AppMethodBeat.i(210828);
      this.CyS = new LinkedList();
      this.CyT = new LinkedList();
      this.CyU = new ConcurrentHashMap();
      this.CyV = new ConcurrentHashMap();
      this.CyW = new ArrayList();
      AppMethodBeat.o(210828);
    }
    
    private static String fu(List<ChatroomMsgPack> paramList)
    {
      AppMethodBeat.i(210829);
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
      AppMethodBeat.o(210829);
      return paramList;
    }
    
    private void w(List<ChatroomMsgPack> paramList, int paramInt)
    {
      label103:
      label111:
      long l2;
      int m;
      int i1;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210834);
          if (!Util.isNullOrNil(paramList)) {
            break label111;
          }
          if (paramInt == 1)
          {
            GameChatListView.b(GameChatListView.this, false);
            AppMethodBeat.o(210834);
            return;
          }
          if (paramInt == 2)
          {
            GameChatListView.c(GameChatListView.this, false);
            GameChatListView.a(GameChatListView.this).clear();
            Log.i("GameChatRoom.GameChatListView", "clear msg list cache 1");
            AppMethodBeat.o(210834);
            continue;
          }
          if (paramInt != 4) {
            break label103;
          }
        }
        finally {}
        paramList = new sp();
        EventCenter.instance.publish(paramList);
        AppMethodBeat.o(210834);
        continue;
        Log.i("GameChatRoom.GameChatListView", "add chatItem list size:%d, dataFromType:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramInt) });
        Log.d("GameChatRoom.GameChatListView", "new list:%s", new Object[] { fu(paramList) });
        Log.d("GameChatRoom.GameChatListView", "before list:%s", new Object[] { fu(this.CyS) });
        l2 = System.currentTimeMillis();
        k = 0;
        m = 0;
        i = 0;
        i1 = this.CyS.size();
        switch (paramInt)
        {
        case 6: 
          label248:
          AppMethodBeat.o(210834);
        }
      }
      this.CyS.addAll(0, paramList);
      int i = 0;
      int k = 0;
      int j = 0;
      label276:
      paramList = this.CyS;
      Object localObject = new TreeSet(new Comparator() {});
      ((Set)localObject).addAll(paramList);
      this.CyS = new ArrayList((Collection)localObject);
      label436:
      long l1;
      label682:
      label830:
      int n;
      if ((paramInt != 4) && (this.CyS.size() > 0) && (GameChatListView.a(GameChatListView.this).size() > 0) && (((ChatroomMsgPack)this.CyS.get(this.CyS.size() - 1)).seq >= ((ChatroomMsgPack)GameChatListView.a(GameChatListView.this).get(GameChatListView.a(GameChatListView.this).size() - 1)).seq))
      {
        GameChatListView.a(GameChatListView.this).clear();
        Log.i("GameChatRoom.GameChatListView", "clear msg list cache 2");
        break label1703;
        this.alc.notifyChanged();
        for (;;)
        {
          paramList = this.CyT.iterator();
          while (paramList.hasNext())
          {
            localObject = (ChatroomMsgPack)paramList.next();
            i = this.CyS.indexOf(localObject);
            if (i >= 0)
            {
              cN(i);
              Log.i("GameChatRoom.GameChatListView", "notifyItemRemoved，seq:%d, index: %d", new Object[] { Long.valueOf(((ChatroomMsgPack)localObject).seq), Integer.valueOf(i) });
            }
          }
          i = this.CyS.size();
          this.CyS.addAll(paramList);
          k = 0;
          j = 0;
          break;
          GameChatListView.b(GameChatListView.this, true);
          GameChatListView.c(GameChatListView.this, true);
          GameChatListView.a(GameChatListView.this).addAll(this.CyS);
          this.CyS.clear();
          this.CyU.clear();
          i = this.CyS.size();
          this.CyS.addAll(paramList);
          k = 0;
          j = 1;
          break;
          if (this.CyS.size() <= 0) {
            break label1692;
          }
          l1 = ((ChatroomMsgPack)this.CyS.get(this.CyS.size() - 1)).seq;
          break label1717;
          while (i < paramList.size())
          {
            localObject = (ChatroomMsgPack)paramList.get(i);
            ((ChatroomMsgPack)localObject).seq = l1;
            paramList.set(i, localObject);
            this.CyU.put(((ChatroomMsgPack)localObject).cli_msg_id, localObject);
            i += 1;
          }
          i = this.CyS.size();
          this.CyS.addAll(paramList);
          k = 0;
          j = 0;
          m = 1;
          break;
          j = this.CyS.size();
          if (GameChatListView.a(GameChatListView.this).size() == 0)
          {
            this.CyS.addAll(paramList);
            if (!GameChatListView.l(GameChatListView.this)) {
              break label1722;
            }
            m = 1;
            i = 0;
            if (!GameChatListView.m(GameChatListView.this)) {
              break label1676;
            }
            GameChatListView.n(GameChatListView.this);
            GameChatListView.o(GameChatListView.this);
            k = i;
            n = 0;
            m = 1;
            i = j;
            j = n;
            break;
          }
          GameChatListView.a(GameChatListView.this).addAll(paramList);
          paramList = GameChatListView.this;
          localObject = GameChatListView.a(GameChatListView.this);
          TreeSet localTreeSet = new TreeSet(new Comparator() {});
          localTreeSet.addAll((Collection)localObject);
          GameChatListView.b(paramList, new ArrayList(localTreeSet));
          i = 1;
          Log.d("GameChatRoom.GameChatListView", "add new msg to cache");
          break label1722;
          GameChatListView.b(GameChatListView.this, true);
          GameChatListView.c(GameChatListView.this, true);
          this.CyS.clear();
          i = this.CyS.size();
          this.CyS.addAll(paramList);
          GameChatListView.a(GameChatListView.this).clear();
          Log.i("GameChatRoom.GameChatListView", "clear msg list cache 3");
          k = 0;
          j = 0;
          m = 1;
          break;
          label1036:
          aG(i, this.CyS.size() - i1);
          Log.i("GameChatRoom.GameChatListView", "notifyItemRangeInserted， start：%d， size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.CyS.size() - i1) });
        }
        this.CyS.removeAll(this.CyT);
        this.CyT.clear();
        Log.d("GameChatRoom.GameChatListView", "after list:%s", new Object[] { fu(this.CyS) });
        if (j != 0)
        {
          paramList = GameChatListView.this;
          localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramList, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "addData", "(Ljava/util/List;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
          paramList.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "addData", "(Ljava/util/List;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        for (;;)
        {
          if (GameChatListView.p(GameChatListView.this) > 0L)
          {
            j = 0;
            paramInt = 0;
            if (k == 0) {
              break label1588;
            }
            if (GameChatListView.a(GameChatListView.this).size() <= 0)
            {
              AppMethodBeat.o(210834);
              break;
              if ((m == 0) || (GameChatListView.c(GameChatListView.this).getItemCount() <= 0)) {
                continue;
              }
              if (paramInt == 3)
              {
                paramList = GameChatListView.this;
                localObject = com.tencent.mm.hellhoundlib.b.c.a(GameChatListView.c(GameChatListView.this).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.b(paramList, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "addData", "(Ljava/util/List;I)V", "Undefined", "scrollToPosition", "(I)V");
                paramList.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "addData", "(Ljava/util/List;I)V", "Undefined", "scrollToPosition", "(I)V");
                continue;
              }
              paramList = GameChatListView.this;
              localObject = com.tencent.mm.hellhoundlib.b.c.a(GameChatListView.c(GameChatListView.this).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramList, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "addData", "(Ljava/util/List;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
              paramList.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/plugin/game/chatroom/view/GameChatListView$GameChatRoomAdapter", "addData", "(Ljava/util/List;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
              continue;
            }
            i = GameChatListView.a(GameChatListView.this).size() - 1;
            while ((i >= 0) && (((ChatroomMsgPack)GameChatListView.a(GameChatListView.this).get(i)).seq > GameChatListView.p(GameChatListView.this)))
            {
              paramInt += 1;
              i -= 1;
            }
          }
        }
      }
      for (;;)
      {
        GameChatListView.a(GameChatListView.this, paramInt);
        Log.d("GameChatRoom.GameChatListView", "add msg to list cost time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        AppMethodBeat.o(210834);
        break;
        label1588:
        if (this.CyS.size() <= 0)
        {
          AppMethodBeat.o(210834);
          break;
        }
        i = this.CyS.size() - 1;
        paramInt = j;
        while (i >= 0)
        {
          l1 = ((ChatroomMsgPack)this.CyS.get(i)).seq;
          long l3 = GameChatListView.p(GameChatListView.this);
          if (l1 <= l3) {
            break;
          }
          paramInt += 1;
          i -= 1;
        }
        continue;
        label1676:
        k = i;
        n = 0;
        i = j;
        j = n;
        break label276;
        label1692:
        l1 = 9223372036854765807L;
        break label1717;
        break label248;
        label1703:
        if (paramInt == 4) {
          break label436;
        }
        if (paramInt != 7) {
          break label1036;
        }
        break label436;
        label1717:
        i = 0;
        break label682;
        label1722:
        m = k;
        break label830;
      }
    }
    
    /* Error */
    public final void ez(String paramString, int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 506
      //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_1
      //   9: invokestatic 509	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifne +16 -> 28
      //   15: aload_0
      //   16: getfield 66	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:CyU	Ljava/util/Map;
      //   19: aload_1
      //   20: invokeinterface 512 2 0
      //   25: ifne +12 -> 37
      //   28: ldc_w 506
      //   31: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aload_0
      //   35: monitorexit
      //   36: return
      //   37: aload_0
      //   38: getfield 66	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:CyU	Ljava/util/Map;
      //   41: aload_1
      //   42: invokeinterface 461 2 0
      //   47: checkcast 116	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack
      //   50: astore_1
      //   51: aload_0
      //   52: getfield 59	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:CyS	Ljava/util/List;
      //   55: aload_1
      //   56: invokeinterface 244 2 0
      //   61: istore_3
      //   62: iload_3
      //   63: iflt +79 -> 142
      //   66: aload_1
      //   67: getfield 516	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   70: ifnull +72 -> 142
      //   73: aload_1
      //   74: getfield 516	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   77: getfield 522	com/tencent/mm/plugin/game/autogen/chatroom/MsgOptions:cli_local_data	Lcom/tencent/mm/cd/b;
      //   80: ifnull +62 -> 142
      //   83: aload_1
      //   84: getfield 516	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   87: getfield 522	com/tencent/mm/plugin/game/autogen/chatroom/MsgOptions:cli_local_data	Lcom/tencent/mm/cd/b;
      //   90: invokevirtual 528	com/tencent/mm/cd/b:toByteArray	()[B
      //   93: invokestatic 534	com/tencent/mm/b/o:Z	([B)J
      //   96: invokestatic 540	com/tencent/mm/plugin/game/chatroom/e:NL	(J)I
      //   99: istore 4
      //   101: aload_1
      //   102: getfield 516	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:msg_options	Lcom/tencent/mm/plugin/game/autogen/chatroom/MsgOptions;
      //   105: new 524	com/tencent/mm/cd/b
      //   108: dup
      //   109: iload 4
      //   111: iconst_4
      //   112: ishl
      //   113: iload_2
      //   114: ior
      //   115: i2l
      //   116: invokestatic 544	com/tencent/mm/b/o:bA	(J)[B
      //   119: invokespecial 547	com/tencent/mm/cd/b:<init>	([B)V
      //   122: putfield 522	com/tencent/mm/plugin/game/autogen/chatroom/MsgOptions:cli_local_data	Lcom/tencent/mm/cd/b;
      //   125: aload_0
      //   126: getfield 59	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:CyS	Ljava/util/List;
      //   129: iload_3
      //   130: aload_1
      //   131: invokeinterface 262 3 0
      //   136: pop
      //   137: aload_0
      //   138: iload_3
      //   139: invokevirtual 550	com/tencent/mm/plugin/game/chatroom/view/GameChatListView$b:cL	(I)V
      //   142: ldc_w 506
      //   145: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(210836);
      int i = this.CyS.size();
      AppMethodBeat.o(210836);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(210835);
      ChatroomMsgPack localChatroomMsgPack = (ChatroomMsgPack)this.CyS.get(paramInt);
      paramInt = com.tencent.mm.plugin.game.chatroom.d.hC(localChatroomMsgPack.msg_type, localChatroomMsgPack.msg_sub_type);
      AppMethodBeat.o(210835);
      return paramInt;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(GameChatListView.b paramb);
    
    public abstract void b(GameChatListView.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatListView
 * JD-Core Version:    0.7.0.1
 */