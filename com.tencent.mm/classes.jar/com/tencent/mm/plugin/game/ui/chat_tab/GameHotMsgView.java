package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kp;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.tools.v;
import com.tencent.threadpool.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameHotMsgView
  extends MRecyclerView
{
  private a IVF;
  private MStorage.IOnStorageChange IVw;
  private IListenerMStorage IVx;
  private long Ijq;
  private long Ijr;
  private Context mContext;
  
  public GameHotMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276657);
    this.IVw = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(276680);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.f.a)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(276680);
      }
    };
    this.IVx = new IListenerMStorage()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(276635);
        if ((paramAnonymousIEvent instanceof kp)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(276635);
      }
    };
    init();
    AppMethodBeat.o(276657);
  }
  
  public GameHotMsgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276667);
    this.IVw = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(276680);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.f.a)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(276680);
      }
    };
    this.IVx = new IListenerMStorage()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(276635);
        if ((paramAnonymousIEvent instanceof kp)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(276635);
      }
    };
    init();
    AppMethodBeat.o(276667);
  }
  
  private void init()
  {
    AppMethodBeat.i(276679);
    this.mContext = getContext();
    this.Ijr = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    localLinearLayoutManager.setOrientation(0);
    setLayoutManager(localLinearLayoutManager);
    this.IVF = new a();
    setAdapter(this.IVF);
    fHH();
    AppMethodBeat.o(276679);
  }
  
  final void fHH()
  {
    AppMethodBeat.i(276728);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).a(new com.tencent.mm.plugin.gamelife.a.c.a()
    {
      public final void it(List<com.tencent.mm.plugin.gamelife.f.a> paramAnonymousList)
      {
        AppMethodBeat.i(276663);
        final LinkedList localLinkedList = new LinkedList();
        if (!Util.isNullOrNil(paramAnonymousList))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          do
          {
            if (!paramAnonymousList.hasNext()) {
              break;
            }
            localObject = (com.tencent.mm.plugin.gamelife.f.a)paramAnonymousList.next();
            GameHotMsgView.b localb = new GameHotMsgView.b(GameHotMsgView.this, (byte)0);
            localb.msgType = 1;
            localb.egK = (((com.tencent.mm.plugin.gamelife.f.a)localObject).field_updateTime / 1000L);
            localb.IVU = ((com.tencent.mm.plugin.gamelife.f.a)localObject);
            localLinkedList.add(localb);
          } while (localLinkedList.size() < 13);
        }
        final int i = localLinkedList.size();
        paramAnonymousList = new GameHotMsgView.b(GameHotMsgView.this, (byte)0);
        paramAnonymousList.msgType = 2;
        Object localObject = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().XB(1);
        if (localObject != null)
        {
          paramAnonymousList.egK = ((o)localObject).field_receiveTime;
          paramAnonymousList.IVV = ((o)localObject);
        }
        localLinkedList.add(paramAnonymousList);
        paramAnonymousList = new GameHotMsgView.b(GameHotMsgView.this, (byte)0);
        paramAnonymousList.msgType = 3;
        localObject = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().XB(2);
        if (localObject != null)
        {
          paramAnonymousList.egK = ((o)localObject).field_receiveTime;
          paramAnonymousList.IVV = ((o)localObject);
        }
        localLinkedList.add(paramAnonymousList);
        Log.i("MicroMsg.GameHotMsgView", "origion conversation size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
        Collections.sort(localLinkedList);
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276625);
            if (localLinkedList.size() > 15)
            {
              GameHotMsgView.b(GameHotMsgView.this).P(localLinkedList.subList(0, 15), i);
              AppMethodBeat.o(276625);
              return;
            }
            GameHotMsgView.b(GameHotMsgView.this).P(localLinkedList, i);
            AppMethodBeat.o(276625);
          }
        });
        AppMethodBeat.o(276663);
      }
    });
    AppMethodBeat.o(276728);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(276717);
    super.onAttachedToWindow();
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.IVw);
    IListenerMStorage.a(kp.class.getName(), this.IVx);
    Log.i("MicroMsg.GameHotMsgView", "onAttachedToWindow");
    AppMethodBeat.o(276717);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(276723);
    super.onDetachedFromWindow();
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.IVw);
    IListenerMStorage.b(kp.class.getName(), this.IVx);
    Log.i("MicroMsg.GameHotMsgView", "onDetachedFromWindow");
    AppMethodBeat.o(276723);
  }
  
  final class a
    extends RecyclerView.a<a>
  {
    private int IVK;
    private List<GameHotMsgView.b> IVL;
    
    public a()
    {
      AppMethodBeat.i(276621);
      this.IVL = new LinkedList();
      AppMethodBeat.o(276621);
    }
    
    public final void P(List<GameHotMsgView.b> paramList, int paramInt)
    {
      AppMethodBeat.i(276640);
      this.IVK = paramInt;
      this.IVL.clear();
      if (!Util.isNullOrNil(paramList)) {
        this.IVL.addAll(paramList);
      }
      this.bZE.notifyChanged();
      AppMethodBeat.o(276640);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276633);
      int i = this.IVL.size();
      AppMethodBeat.o(276633);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      boolean IVM;
      boolean IVN;
      Map<String, Boolean> IVO;
      boolean IVP;
      TextView IVQ;
      TextView vPl;
      TextView vgb;
      ImageView yBT;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(276589);
        this.IVM = false;
        this.IVN = false;
        this.IVO = new HashMap();
        this.IVP = true;
        this.yBT = ((ImageView)paramView.findViewById(h.e.HTG));
        this.vgb = ((TextView)paramView.findViewById(h.e.HTH));
        this.IVQ = ((TextView)paramView.findViewById(h.e.HYa));
        this.IVQ.setBackgroundResource(v.nH(GameHotMsgView.c(GameHotMsgView.this)));
        this.vPl = ((TextView)paramView.findViewById(h.e.gbj));
        AppMethodBeat.o(276589);
      }
    }
  }
  
  final class b
    implements Comparable<b>
  {
    com.tencent.mm.plugin.gamelife.f.a IVU;
    o IVV;
    long egK;
    int msgType;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameHotMsgView
 * JD-Core Version:    0.7.0.1
 */