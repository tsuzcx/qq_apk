package com.tencent.mm.plugin.game.ui.chat_tab;

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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.gamelife.a.c.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameHotMsgView
  extends MRecyclerView
{
  private MStorage.IOnStorageChange Dbi;
  private com.tencent.mm.pluginsdk.d.a Dbj;
  private a Dbr;
  private Context mContext;
  
  public GameHotMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195077);
    this.Dbi = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(190140);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(190140);
      }
    };
    this.Dbj = new com.tencent.mm.pluginsdk.d.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(203674);
        if ((paramAnonymousIEvent instanceof jo)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(203674);
      }
    };
    init();
    AppMethodBeat.o(195077);
  }
  
  public GameHotMsgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195080);
    this.Dbi = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(190140);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(190140);
      }
    };
    this.Dbj = new com.tencent.mm.pluginsdk.d.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(203674);
        if ((paramAnonymousIEvent instanceof jo)) {
          GameHotMsgView.a(GameHotMsgView.this);
        }
        AppMethodBeat.o(203674);
      }
    };
    init();
    AppMethodBeat.o(195080);
  }
  
  private void init()
  {
    AppMethodBeat.i(195085);
    this.mContext = getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    localLinearLayoutManager.setOrientation(0);
    setLayoutManager(localLinearLayoutManager);
    this.Dbr = new a();
    setAdapter(this.Dbr);
    ezH();
    AppMethodBeat.o(195085);
  }
  
  final void ezH()
  {
    AppMethodBeat.i(195092);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).a(new c.a()
    {
      public final void fx(List<com.tencent.mm.plugin.gamelife.e.a> paramAnonymousList)
      {
        AppMethodBeat.i(198157);
        final LinkedList localLinkedList = new LinkedList();
        if (!Util.isNullOrNil(paramAnonymousList))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          do
          {
            if (!paramAnonymousList.hasNext()) {
              break;
            }
            localObject = (com.tencent.mm.plugin.gamelife.e.a)paramAnonymousList.next();
            GameHotMsgView.b localb = new GameHotMsgView.b(GameHotMsgView.this, (byte)0);
            localb.msgType = 1;
            localb.coZ = (((com.tencent.mm.plugin.gamelife.e.a)localObject).field_updateTime / 1000L);
            localb.DbA = ((com.tencent.mm.plugin.gamelife.e.a)localObject);
            localLinkedList.add(localb);
          } while (localLinkedList.size() < 13);
        }
        paramAnonymousList = new GameHotMsgView.b(GameHotMsgView.this, (byte)0);
        paramAnonymousList.msgType = 2;
        Object localObject = ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().TH(1);
        if (localObject != null)
        {
          paramAnonymousList.coZ = ((o)localObject).field_receiveTime;
          paramAnonymousList.DbB = ((o)localObject);
        }
        localLinkedList.add(paramAnonymousList);
        paramAnonymousList = new GameHotMsgView.b(GameHotMsgView.this, (byte)0);
        paramAnonymousList.msgType = 3;
        localObject = ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().TH(2);
        if (localObject != null)
        {
          paramAnonymousList.coZ = ((o)localObject).field_receiveTime;
          paramAnonymousList.DbB = ((o)localObject);
        }
        localLinkedList.add(paramAnonymousList);
        Log.i("MicroMsg.GameHotMsgView", "origion conversation size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
        Collections.sort(localLinkedList);
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200258);
            if (localLinkedList.size() > 15)
            {
              GameHotMsgView.b(GameHotMsgView.this).setData(localLinkedList.subList(0, 15));
              AppMethodBeat.o(200258);
              return;
            }
            GameHotMsgView.b(GameHotMsgView.this).setData(localLinkedList);
            AppMethodBeat.o(200258);
          }
        });
        AppMethodBeat.o(198157);
      }
    });
    AppMethodBeat.o(195092);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(195087);
    super.onAttachedToWindow();
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.Dbi);
    com.tencent.mm.pluginsdk.d.a.a(jo.class.getName(), this.Dbj);
    Log.i("MicroMsg.GameHotMsgView", "onAttachedToWindow");
    AppMethodBeat.o(195087);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(195089);
    super.onDetachedFromWindow();
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.Dbi);
    com.tencent.mm.pluginsdk.d.a.b(jo.class.getName(), this.Dbj);
    Log.i("MicroMsg.GameHotMsgView", "onDetachedFromWindow");
    AppMethodBeat.o(195089);
  }
  
  final class a
    extends RecyclerView.a<a>
  {
    private List<GameHotMsgView.b> Dbv;
    
    public a()
    {
      AppMethodBeat.i(194057);
      this.Dbv = new LinkedList();
      AppMethodBeat.o(194057);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(194059);
      int i = this.Dbv.size();
      AppMethodBeat.o(194059);
      return i;
    }
    
    public final void setData(List<GameHotMsgView.b> paramList)
    {
      AppMethodBeat.i(194060);
      this.Dbv.clear();
      if (!Util.isNullOrNil(paramList)) {
        this.Dbv.addAll(paramList);
      }
      this.alc.notifyChanged();
      AppMethodBeat.o(194060);
    }
    
    final class a
      extends RecyclerView.v
    {
      TextView Dbw;
      TextView rUM;
      TextView sJm;
      ImageView vpB;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(208936);
        this.vpB = ((ImageView)paramView.findViewById(g.e.Chy));
        this.rUM = ((TextView)paramView.findViewById(g.e.Chz));
        this.Dbw = ((TextView)paramView.findViewById(g.e.ClS));
        this.sJm = ((TextView)paramView.findViewById(g.e.dYv));
        AppMethodBeat.o(208936);
      }
    }
  }
  
  final class b
    implements Comparable<b>
  {
    com.tencent.mm.plugin.gamelife.e.a DbA;
    o DbB;
    long coZ;
    int msgType;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameHotMsgView
 * JD-Core Version:    0.7.0.1
 */