package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.b;
import com.tencent.mm.chatroom.d.d;
import com.tencent.mm.chatroom.d.e;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI
  extends MMActivity
  implements k.a
{
  private x ftP;
  private String fxo;
  private GridView fyV;
  private b fzi;
  private p tipDialog;
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(12842);
    if (paramm != null) {
      ac.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", new Object[] { paramString, paramm.cZV, Integer.valueOf(paramm.jRj) });
    }
    AppMethodBeat.o(12842);
  }
  
  protected final c cu(View paramView)
  {
    AppMethodBeat.i(12843);
    c localc = new c();
    localc.fuY = ((ImageView)paramView.findViewById(2131304237));
    localc.fzg = ((TextView)paramView.findViewById(2131304234));
    AppMethodBeat.o(12843);
    return localc;
  }
  
  public int getLayoutId()
  {
    return 2131495335;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12841);
    super.initView();
    setMMTitle(2131762637);
    this.fyV = ((GridView)findViewById(2131302149));
    this.fzi = new b(this);
    this.fyV.setAdapter(this.fzi);
    this.fyV.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.fyV.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12825);
        int j = (int)(SeeRoomManagerUI.this.getResources().getDimension(2131165191) + SeeRoomManagerUI.this.getResources().getDimension(2131165508) + SeeRoomManagerUI.this.getResources().getDimension(2131165574));
        int i = j;
        if (SeeRoomManagerUI.a(SeeRoomManagerUI.this).getCount() / 4 > 0) {
          i = j * (SeeRoomManagerUI.a(SeeRoomManagerUI.this).getCount() / 4 + 1);
        }
        SeeRoomManagerUI.b(SeeRoomManagerUI.this).setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.b(SeeRoomManagerUI.this).getWidth(), i));
        AppMethodBeat.o(12825);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12826);
        SeeRoomManagerUI.this.finish();
        AppMethodBeat.o(12826);
        return true;
      }
    });
    AppMethodBeat.o(12841);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(12844);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      if (paramIntent == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.w("MicroMsg.SeeRoomManagerUI", "[onActivityResult] data is null? %s resultCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(12844);
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    ac.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.fxo, Integer.valueOf(paramInt1), paramIntent });
    if (bs.isNullOrNil(paramIntent))
    {
      ac.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
      AppMethodBeat.o(12844);
      return;
    }
    Object localObject = paramIntent.split(",");
    paramIntent = new LinkedList();
    int i = localObject.length;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      paramIntent.add(localObject[paramInt2]);
      paramInt2 += 1;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12844);
      return;
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = h.b((Context)localObject, getString(2131762571), false, null);
      if (w.wp(this.fxo))
      {
        new b(this.fxo, paramIntent).aBB().a(this).b(new a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new e(this.fxo, paramIntent).aBB().a(this).b(new a() {});
      AppMethodBeat.o(12844);
      return;
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = h.b((Context)localObject, getString(2131762594), false, null);
      if (w.wp(this.fxo))
      {
        new d(this.fxo, paramIntent).aBB().a(this).b(new a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new com.tencent.mm.chatroom.d.f(this.fxo, paramIntent).aBB().a(this).b(new a() {});
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12839);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().add(this);
    this.fxo = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12839);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12840);
    super.onDestroy();
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().remove(this);
    AppMethodBeat.o(12840);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    public ai contact;
    public int type;
    
    public a(int paramInt, ai paramai)
    {
      this.type = paramInt;
      this.contact = paramai;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeRoomManagerUI.a> dataList;
    private com.tencent.mm.av.a.a.c fze;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12831);
      this.dataList = new ArrayList();
      this.mContext = paramContext;
      WN();
      notifyDataSetChanged();
      this$1 = new c.a();
      SeeRoomManagerUI.this.hKx = true;
      SeeRoomManagerUI.this.gKm = true;
      SeeRoomManagerUI.this.hKI = 2131690013;
      this.fze = SeeRoomManagerUI.this.aFT();
      AppMethodBeat.o(12831);
    }
    
    private void WN()
    {
      AppMethodBeat.i(12833);
      this.dataList.clear();
      SeeRoomManagerUI.a(SeeRoomManagerUI.this, ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(bs.nullAsNil(SeeRoomManagerUI.c(SeeRoomManagerUI.this))));
      if (SeeRoomManagerUI.d(SeeRoomManagerUI.this) == null)
      {
        AppMethodBeat.o(12833);
        return;
      }
      Iterator localIterator = SeeRoomManagerUI.d(SeeRoomManagerUI.this).aDl().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (SeeRoomManagerUI.d(SeeRoomManagerUI.this).aMU((String)localObject))
        {
          ac.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", new Object[] { localObject });
          localObject = ((k)g.ab(k.class)).awB().aNt((String)localObject);
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 1, (ai)localObject));
        }
      }
      if (u.axw().equals(SeeRoomManagerUI.d(SeeRoomManagerUI.this).field_roomowner))
      {
        this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 2, null));
        if (this.dataList.size() > 1) {
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 3, null));
        }
      }
      AppMethodBeat.o(12833);
    }
    
    private SeeRoomManagerUI.a kI(int paramInt)
    {
      AppMethodBeat.i(12835);
      SeeRoomManagerUI.a locala = (SeeRoomManagerUI.a)this.dataList.get(paramInt);
      AppMethodBeat.o(12835);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12834);
      int i = this.dataList.size();
      AppMethodBeat.o(12834);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12836);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131495276, null);
        paramViewGroup = SeeRoomManagerUI.this.cu(localView);
      }
      for (;;)
      {
        paramView = kI(paramInt);
        if (paramView != null) {
          break;
        }
        ac.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12836);
        return localView;
        SeeRoomManagerUI.c localc = (SeeRoomManagerUI.c)paramView.getTag();
        paramViewGroup = localc;
        localView = paramView;
        if (localc == null)
        {
          paramViewGroup = SeeRoomManagerUI.this.cu(paramView);
          localView = paramView;
        }
      }
      if (paramView.type == 1)
      {
        paramViewGroup.fzg.setVisibility(0);
        paramView = paramView.contact;
        paramViewGroup.fzg.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramView.field_username, paramViewGroup.fzg));
        a.b.c(paramViewGroup.fuY, paramView.field_username);
      }
      for (;;)
      {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12830);
            paramAnonymousView = (SeeRoomManagerUI.a)SeeRoomManagerUI.b.this.dataList.get(paramInt);
            if (paramAnonymousView.type == 1)
            {
              paramAnonymousView = ((SeeRoomManagerUI.a)SeeRoomManagerUI.b.this.dataList.get(paramInt)).contact;
              SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramAnonymousView.field_username, SeeRoomManagerUI.b.a(SeeRoomManagerUI.b.this, paramAnonymousView), paramAnonymousView.field_nickname);
              AppMethodBeat.o(12830);
              return;
            }
            if (paramAnonymousView.type == 2)
            {
              paramAnonymousView = new Intent(SeeRoomManagerUI.this, SelectAddRoomManagerUI.class);
              paramAnonymousView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(SeeRoomManagerUI.this));
              SeeRoomManagerUI.this.startActivityForResult(paramAnonymousView, 0);
              AppMethodBeat.o(12830);
              return;
            }
            if (paramAnonymousView.type == 3)
            {
              paramAnonymousView = new Intent(SeeRoomManagerUI.this, SelectDelRoomManagerUI.class);
              paramAnonymousView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(SeeRoomManagerUI.this));
              paramAnonymousView.putExtra("RoomManagers", SeeRoomManagerUI.e(SeeRoomManagerUI.this));
              SeeRoomManagerUI.this.startActivityForResult(paramAnonymousView, 1);
            }
            AppMethodBeat.o(12830);
          }
        });
        AppMethodBeat.o(12836);
        return localView;
        if (paramView.type == 2)
        {
          paramViewGroup.fzg.setVisibility(4);
          paramViewGroup.fuY.setImageResource(2131231164);
        }
        else if (paramView.type == 3)
        {
          paramViewGroup.fzg.setVisibility(4);
          paramViewGroup.fuY.setImageResource(2131231165);
        }
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(12832);
      super.notifyDataSetChanged();
      SeeRoomManagerUI.b(SeeRoomManagerUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12829);
          int j = (int)(SeeRoomManagerUI.this.getResources().getDimension(2131165191) + SeeRoomManagerUI.this.getResources().getDimension(2131165508) + SeeRoomManagerUI.this.getResources().getDimension(2131165574));
          int i = j;
          if (SeeRoomManagerUI.a(SeeRoomManagerUI.this).getCount() / 4 > 0) {
            i = j * (SeeRoomManagerUI.a(SeeRoomManagerUI.this).getCount() / 4 + 1);
          }
          SeeRoomManagerUI.b(SeeRoomManagerUI.this).setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.b(SeeRoomManagerUI.this).getWidth(), i));
          AppMethodBeat.o(12829);
        }
      });
      AppMethodBeat.o(12832);
    }
  }
  
  final class c
  {
    public ImageView fuY;
    public TextView fzg;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */