package com.tencent.mm.plugin.game.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bf;
import com.tencent.mm.f.a.bf.a;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.c.f;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.plugin.game.chatroom.view.b;
import com.tencent.mm.plugin.game.chatroom.view.b.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameMoreChatRoomUI
  extends ChatRoomBaseUI
  implements i
{
  private long Cuy;
  private long Cuz;
  private Lbs CvP;
  private a Cwv;
  private List<BanAction> Cww;
  private IListener Cwx;
  private Context mContext;
  private String mFilter;
  private boolean mIsRunning;
  private LoadMoreRecyclerView tAK;
  
  public GameMoreChatRoomUI()
  {
    AppMethodBeat.i(211335);
    this.Cww = new LinkedList();
    this.mIsRunning = false;
    this.Cwx = new IListener() {};
    AppMethodBeat.o(211335);
  }
  
  /* Error */
  private void evS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 84
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 55	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:mIsRunning	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 86
    //   16: ldc 88
    //   18: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 84
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 55	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:mIsRunning	Z
    //   34: new 95	com/tencent/mm/plugin/game/chatroom/c/f
    //   37: dup
    //   38: aload_0
    //   39: getfield 97	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:mFilter	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 99	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI:CvP	Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;
    //   46: invokespecial 102	com/tencent/mm/plugin/game/chatroom/c/f:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;)V
    //   49: astore_1
    //   50: invokestatic 108	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   53: aload_1
    //   54: iconst_0
    //   55: invokevirtual 113	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   58: pop
    //   59: ldc 84
    //   61: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -38 -> 26
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	GameMoreChatRoomUI
    //   49	5	1	localf	f
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	67	finally
    //   29	64	67	finally
  }
  
  public final long evK()
  {
    return 1199L;
  }
  
  public final long evL()
  {
    return 11L;
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
    return f.f.CtS;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211337);
    super.onCreate(paramBundle);
    this.mContext = this;
    this.Cuz = getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Cuy = getIntent().getLongExtra("game_report_ssid", 0L);
    boolean bool = au.auk(getResources().getColor(f.b.white));
    paramBundle = getContentView();
    int i = getResources().getColor(f.b.white);
    if (!bool) {
      bool = true;
    }
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.f(paramBundle, i, bool);
      setActionbarColor(getResources().getColor(f.b.white));
      setNavigationbarColor(getResources().getColor(f.b.white));
      setMMTitle(f.h.Cuf);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(210859);
          GameMoreChatRoomUI.this.finish();
          AppMethodBeat.o(210859);
          return false;
        }
      });
      this.tAK = ((LoadMoreRecyclerView)findViewById(f.e.Csx));
      this.tAK.setOnLoadingStateChangedListener(new LoadMoreRecyclerView.a()
      {
        public final void clj()
        {
          AppMethodBeat.i(210788);
          GameMoreChatRoomUI.a(GameMoreChatRoomUI.this);
          AppMethodBeat.o(210788);
        }
      });
      this.Cwv = new a();
      this.tAK.setAdapter(this.Cwv);
      this.tAK.setItemAnimator(null);
      paramBundle = getIntent().getByteArrayExtra("chat_room_lbs");
      if (paramBundle != null) {
        this.CvP = new Lbs();
      }
      try
      {
        this.CvP.parseFrom(paramBundle);
        label226:
        h.aGY().a(5048, this);
        this.tAK.setLoadingView(f.f.CtU);
        this.tAK.showLoading(true);
        evS();
        paramBundle = com.tencent.mm.game.report.d.jTj;
        d.a.a(0L, this.Cuy, this.Cuz, "", "", "");
        EventCenter.instance.addListener(this.Cwx);
        AppMethodBeat.o(211337);
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
    AppMethodBeat.i(211339);
    super.onDestroy();
    h.aGY().b(5048, this);
    EventCenter.instance.removeListener(this.Cwx);
    b.evV();
    AppMethodBeat.o(211339);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(211345);
    if (paramq.getType() == 5048)
    {
      this.mIsRunning = false;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (GetMoreChatroomResponse)d.c.b(((f)paramq).jTk.lBS);
        paramq = this.Cwv;
        Object localObject = paramString.chatroom_info_list;
        LinkedList localLinkedList = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(new com.tencent.mm.plugin.game.chatroom.d.a((ChatroomRecInfo)((Iterator)localObject).next()));
        }
        if (!Util.isNullOrNil(localLinkedList))
        {
          if (!paramq.CwD)
          {
            paramq.CwD = true;
            localObject = com.tencent.mm.game.report.d.jTj;
            d.a.a(1102L, paramq.Cwy.Cuy, paramq.Cwy.Cuz, "", "", "");
          }
          paramq.CwB.addAll(localLinkedList);
          paramq.alc.notifyChanged();
        }
        this.mFilter = paramString.chatroom_filter;
        if (!paramString.has_next) {
          this.tAK.showLoading(false);
        }
        this.Cww.clear();
        if (paramString.ban_action_list != null) {
          this.Cww.addAll(paramString.ban_action_list);
        }
      }
    }
    AppMethodBeat.o(211345);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<b.c>
  {
    List<com.tencent.mm.plugin.game.chatroom.d.a> CwB;
    private List<String> CwC;
    boolean CwD;
    
    public a()
    {
      AppMethodBeat.i(210982);
      this.CwB = new LinkedList();
      this.CwC = new ArrayList();
      this.CwD = false;
      AppMethodBeat.o(210982);
    }
    
    /* Error */
    private void aIV(String paramString)
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
      //   11: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:CwB	Ljava/util/List;
      //   14: invokeinterface 60 1 0
      //   19: if_icmpge +78 -> 97
      //   22: aload_0
      //   23: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:CwB	Ljava/util/List;
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
      //   58: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:CwB	Ljava/util/List;
      //   61: aload_0
      //   62: getfield 36	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:CwB	Ljava/util/List;
      //   65: iload_2
      //   66: invokeinterface 64 2 0
      //   71: invokeinterface 92 2 0
      //   76: pop
      //   77: aload_0
      //   78: iload_2
      //   79: invokevirtual 95	com/tencent/mm/plugin/game/chatroom/ui/GameMoreChatRoomUI$a:cN	(I)V
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
      AppMethodBeat.i(210983);
      int i = this.CwB.size();
      AppMethodBeat.o(210983);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameMoreChatRoomUI
 * JD-Core Version:    0.7.0.1
 */