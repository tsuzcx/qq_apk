package com.tencent.mm.plugin.game.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bl;
import com.tencent.mm.autogen.a.bl.a;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.chatroom.view.b;
import com.tencent.mm.plugin.game.chatroom.view.b.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameMoreChatRoomUI
  extends ChatRoomBaseUI
  implements com.tencent.mm.am.h
{
  private long Ijq;
  private long Ijr;
  private Lbs ImF;
  private a InM;
  private List<BanAction> InN;
  private IListener InO;
  private Context mContext;
  private boolean mIsRunning;
  private String pQv;
  private LoadMoreRecyclerView wFj;
  
  public GameMoreChatRoomUI()
  {
    AppMethodBeat.i(276054);
    this.InN = new LinkedList();
    this.mIsRunning = false;
    this.InO = new IListener(f.hfK) {};
    AppMethodBeat.o(276054);
  }
  
  /* Error */
  private void fDo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 95
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 55	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:mIsRunning	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 97
    //   16: ldc 99
    //   18: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 95
    //   23: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 55	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:mIsRunning	Z
    //   34: new 106	com/tencent/mm/plugin/game/chatroom/c/h
    //   37: dup
    //   38: aload_0
    //   39: getfield 108	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:pQv	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 94	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:ImF	Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;
    //   46: invokespecial 111	com/tencent/mm/plugin/game/chatroom/c/h:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;)V
    //   49: astore_1
    //   50: invokestatic 117	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   53: aload_1
    //   54: iconst_0
    //   55: invokevirtual 122	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   58: pop
    //   59: ldc 95
    //   61: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -38 -> 26
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	GameMoreChatRoomUI
    //   49	5	1	localh	com.tencent.mm.plugin.game.chatroom.c.h
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	67	finally
    //   29	64	67	finally
  }
  
  public final long fCZ()
  {
    return 1199L;
  }
  
  public final long fDa()
  {
    return 11L;
  }
  
  public int getLayoutId()
  {
    return h.f.Iie;
  }
  
  public final long getSourceId()
  {
    return this.Ijr;
  }
  
  public final long getSsid()
  {
    return this.Ijq;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276107);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.Ijr = getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = getIntent().getLongExtra("game_report_ssid", 0L);
    boolean bool = bb.aAF(getResources().getColor(h.b.white));
    paramBundle = getContentView();
    int i = getResources().getColor(h.b.white);
    if (!bool) {
      bool = true;
    }
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.h(paramBundle, i, bool);
      setActionbarColor(getResources().getColor(h.b.white));
      setNavigationbarColor(getResources().getColor(h.b.white));
      setMMTitle(h.h.IiA);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(276065);
          GameMoreChatRoomUI.this.finish();
          AppMethodBeat.o(276065);
          return false;
        }
      });
      this.wFj = ((LoadMoreRecyclerView)findViewById(h.e.Ife));
      this.wFj.setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
      {
        public final void onLoadMore(LoadMoreRecyclerView paramAnonymousLoadMoreRecyclerView, RecyclerView.a paramAnonymousa)
        {
          AppMethodBeat.i(276058);
          GameMoreChatRoomUI.a(GameMoreChatRoomUI.this);
          AppMethodBeat.o(276058);
        }
      });
      this.InM = new a();
      this.wFj.setAdapter(this.InM);
      this.wFj.setItemAnimator(null);
      paramBundle = getIntent().getByteArrayExtra("chat_room_lbs");
      if (paramBundle != null) {
        this.ImF = new Lbs();
      }
      try
      {
        this.ImF.parseFrom(paramBundle);
        label226:
        com.tencent.mm.kernel.h.aZW().a(5048, this);
        this.wFj.setLoadingView(h.f.Iii);
        this.wFj.showLoading(true);
        fDo();
        paramBundle = d.mty;
        d.a.a(0L, this.Ijq, this.Ijr, "", "", "");
        this.InO.alive();
        AppMethodBeat.o(276107);
        return;
        bool = false;
      }
      catch (IOException paramBundle)
      {
        break label226;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(276114);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(5048, this);
    this.InO.dead();
    b.fDt();
    AppMethodBeat.o(276114);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(276149);
    if (paramp.getType() == 5048)
    {
      this.mIsRunning = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (GetMoreChatroomResponse)c.c.b(((com.tencent.mm.plugin.game.chatroom.c.h)paramp).mtC.otC);
        paramp = this.InM;
        Object localObject = paramString.chatroom_info_list;
        LinkedList localLinkedList = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(new com.tencent.mm.plugin.game.chatroom.d.a((ChatroomRecInfo)((Iterator)localObject).next()));
        }
        if (!Util.isNullOrNil(localLinkedList))
        {
          if (!paramp.InU)
          {
            paramp.InU = true;
            localObject = d.mty;
            d.a.a(1102L, paramp.InP.Ijq, paramp.InP.Ijr, "", "", "");
          }
          paramp.InS.addAll(localLinkedList);
          paramp.bZE.notifyChanged();
        }
        this.pQv = paramString.chatroom_filter;
        if (!paramString.has_next) {
          this.wFj.showLoading(false);
        }
        this.InN.clear();
        if (paramString.ban_action_list != null) {
          this.InN.addAll(paramString.ban_action_list);
        }
      }
    }
    AppMethodBeat.o(276149);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<b.c>
  {
    List<com.tencent.mm.plugin.game.chatroom.d.a> InS;
    private List<String> InT;
    boolean InU;
    
    public a()
    {
      AppMethodBeat.i(276032);
      this.InS = new LinkedList();
      this.InT = new ArrayList();
      this.InU = false;
      AppMethodBeat.o(276032);
    }
    
    /* Error */
    private void aFE(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 54
      //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: iconst_0
      //   8: istore_2
      //   9: iload_2
      //   10: aload_0
      //   11: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:InS	Ljava/util/List;
      //   14: invokeinterface 60 1 0
      //   19: if_icmpge +78 -> 97
      //   22: aload_0
      //   23: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:InS	Ljava/util/List;
      //   26: iload_2
      //   27: invokeinterface 64 2 0
      //   32: checkcast 66	com/tencent/mm/plugin/game/chatroom/d/a
      //   35: invokestatic 71	com/tencent/mm/plugin/game/chatroom/view/b:a	(Lcom/tencent/mm/plugin/game/chatroom/d/a;)Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomData;
      //   38: astore_3
      //   39: aload_3
      //   40: ifnull +50 -> 90
      //   43: aload_3
      //   44: getfield 77	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomData:chatroom_name	Ljava/lang/String;
      //   47: invokestatic 83	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   50: aload_1
      //   51: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   54: ifeq +36 -> 90
      //   57: aload_0
      //   58: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:InS	Ljava/util/List;
      //   61: aload_0
      //   62: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:InS	Ljava/util/List;
      //   65: iload_2
      //   66: invokeinterface 64 2 0
      //   71: invokeinterface 92 2 0
      //   76: pop
      //   77: aload_0
      //   78: iload_2
      //   79: invokevirtual 95	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:fX	(I)V
      //   82: ldc 54
      //   84: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_0
      //   88: monitorexit
      //   89: return
      //   90: iload_2
      //   91: iconst_1
      //   92: iadd
      //   93: istore_2
      //   94: goto -85 -> 9
      //   97: ldc 54
      //   99: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   102: goto -15 -> 87
      //   105: astore_1
      //   106: aload_0
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	110	0	this	a
      //   0	110	1	paramString	String
      //   8	86	2	i	int
      //   38	6	3	localChatroomData	com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData
      // Exception table:
      //   from	to	target	type
      //   2	7	105	finally
      //   9	39	105	finally
      //   43	87	105	finally
      //   97	102	105	finally
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276050);
      int i = this.InS.size();
      AppMethodBeat.o(276050);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameMoreChatRoomUI
 * JD-Core Version:    0.7.0.1
 */