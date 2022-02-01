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
import com.tencent.mm.al.a.a;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.chatroom.d.d;
import com.tencent.mm.chatroom.d.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI
  extends MMActivity
  implements k.a
{
  private ab fLO;
  private String fQB;
  private GridView fSi;
  private b fSv;
  private p tipDialog;
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(12842);
    if (paramm != null) {
      ad.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", new Object[] { paramString, paramm.dln, Integer.valueOf(paramm.dtK) });
    }
    AppMethodBeat.o(12842);
  }
  
  protected final c cu(View paramView)
  {
    AppMethodBeat.i(12843);
    c localc = new c();
    localc.fOf = ((ImageView)paramView.findViewById(2131304237));
    localc.fSt = ((TextView)paramView.findViewById(2131304234));
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
    this.fSi = ((GridView)findViewById(2131302149));
    this.fSv = new b(this);
    this.fSi.setAdapter(this.fSv);
    this.fSi.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213549);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomManagerUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/SeeRoomManagerUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(213549);
        return true;
      }
    });
    this.fSi.post(new Runnable()
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
        ad.w("MicroMsg.SeeRoomManagerUI", "[onActivityResult] data is null? %s resultCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(12844);
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    ad.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.fQB, Integer.valueOf(paramInt1), paramIntent });
    if (bt.isNullOrNil(paramIntent))
    {
      ad.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
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
      if (w.zk(this.fQB))
      {
        new com.tencent.mm.chatroom.d.b(this.fQB, paramIntent).aED().a(this).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new e(this.fQB, paramIntent).aED().a(this).b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(12844);
      return;
      localObject = getContext();
      getString(2131755906);
      this.tipDialog = h.b((Context)localObject, getString(2131762594), false, null);
      if (w.zk(this.fQB))
      {
        new d(this.fQB, paramIntent).aED().a(this).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new com.tencent.mm.chatroom.d.f(this.fQB, paramIntent).aED().a(this).b(new com.tencent.mm.vending.c.a() {});
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12839);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().add(this);
    this.fQB = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12839);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12840);
    super.onDestroy();
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().remove(this);
    AppMethodBeat.o(12840);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    public am contact;
    public int type;
    
    public a(int paramInt, am paramam)
    {
      this.type = paramInt;
      this.contact = paramam;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeRoomManagerUI.a> dataList;
    private com.tencent.mm.aw.a.a.c fSr;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12831);
      this.dataList = new ArrayList();
      this.mContext = paramContext;
      Zh();
      notifyDataSetChanged();
      this$1 = new c.a();
      SeeRoomManagerUI.this.idr = true;
      SeeRoomManagerUI.this.hdX = true;
      SeeRoomManagerUI.this.idD = 2131690013;
      this.fSr = SeeRoomManagerUI.this.aJc();
      AppMethodBeat.o(12831);
    }
    
    private void Zh()
    {
      AppMethodBeat.i(12833);
      this.dataList.clear();
      SeeRoomManagerUI.a(SeeRoomManagerUI.this, ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(bt.nullAsNil(SeeRoomManagerUI.c(SeeRoomManagerUI.this))));
      if (SeeRoomManagerUI.d(SeeRoomManagerUI.this) == null)
      {
        AppMethodBeat.o(12833);
        return;
      }
      Iterator localIterator = SeeRoomManagerUI.d(SeeRoomManagerUI.this).aGo().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (SeeRoomManagerUI.d(SeeRoomManagerUI.this).aSH((String)localObject))
        {
          ad.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", new Object[] { localObject });
          localObject = ((l)g.ab(l.class)).azp().Bf((String)localObject);
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 1, (am)localObject));
        }
      }
      if (u.aAm().equals(SeeRoomManagerUI.d(SeeRoomManagerUI.this).field_roomowner))
      {
        this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 2, null));
        if (this.dataList.size() > 1) {
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 3, null));
        }
      }
      AppMethodBeat.o(12833);
    }
    
    private SeeRoomManagerUI.a lh(int paramInt)
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
        paramView = lh(paramInt);
        if (paramView != null) {
          break;
        }
        ad.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
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
        paramViewGroup.fSt.setVisibility(0);
        paramView = paramView.contact;
        paramViewGroup.fSt.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramView.field_username, paramViewGroup.fSt));
        a.b.c(paramViewGroup.fOf, paramView.field_username);
      }
      for (;;)
      {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12830);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomManagerUI$ManagerAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = (SeeRoomManagerUI.a)SeeRoomManagerUI.b.this.dataList.get(paramInt);
            if (paramAnonymousView.type == 1)
            {
              paramAnonymousView = ((SeeRoomManagerUI.a)SeeRoomManagerUI.b.this.dataList.get(paramInt)).contact;
              SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramAnonymousView.field_username, SeeRoomManagerUI.b.a(SeeRoomManagerUI.b.this, paramAnonymousView), paramAnonymousView.field_nickname);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomManagerUI$ManagerAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12830);
              return;
              if (paramAnonymousView.type == 2)
              {
                paramAnonymousView = new Intent(SeeRoomManagerUI.this, SelectAddRoomManagerUI.class);
                paramAnonymousView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(SeeRoomManagerUI.this));
                SeeRoomManagerUI.this.startActivityForResult(paramAnonymousView, 0);
              }
              else if (paramAnonymousView.type == 3)
              {
                paramAnonymousView = new Intent(SeeRoomManagerUI.this, SelectDelRoomManagerUI.class);
                paramAnonymousView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(SeeRoomManagerUI.this));
                paramAnonymousView.putExtra("RoomManagers", SeeRoomManagerUI.e(SeeRoomManagerUI.this));
                SeeRoomManagerUI.this.startActivityForResult(paramAnonymousView, 1);
              }
            }
          }
        });
        AppMethodBeat.o(12836);
        return localView;
        if (paramView.type == 2)
        {
          paramViewGroup.fSt.setVisibility(4);
          paramViewGroup.fOf.setImageResource(2131231164);
        }
        else if (paramView.type == 3)
        {
          paramViewGroup.fSt.setVisibility(4);
          paramViewGroup.fOf.setImageResource(2131231165);
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
    public ImageView fOf;
    public TextView fSt;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */