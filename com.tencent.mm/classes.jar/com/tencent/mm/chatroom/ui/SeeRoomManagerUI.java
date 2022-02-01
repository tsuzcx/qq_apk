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
import com.tencent.mm.chatroom.d.d;
import com.tencent.mm.chatroom.d.e;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private ah gtd;
  private String gxP;
  private b gzI;
  private GridView gzv;
  private q tipDialog;
  
  protected final c cj(View paramView)
  {
    AppMethodBeat.i(12843);
    c localc = new c();
    localc.gvv = ((ImageView)paramView.findViewById(2131307155));
    localc.gzG = ((TextView)paramView.findViewById(2131307152));
    AppMethodBeat.o(12843);
    return localc;
  }
  
  public int getLayoutId()
  {
    return 2131496196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12841);
    super.initView();
    setMMTitle(2131764720);
    this.gzv = ((GridView)findViewById(2131304488));
    this.gzI = new b(this);
    this.gzv.setAdapter(this.gzI);
    this.gzv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.gzv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12825);
        int j = (int)(SeeRoomManagerUI.this.getResources().getDimension(2131165194) + SeeRoomManagerUI.this.getResources().getDimension(2131165526) + SeeRoomManagerUI.this.getResources().getDimension(2131165592));
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
        Log.w("MicroMsg.SeeRoomManagerUI", "[onActivityResult] data is null? %s resultCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(12844);
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.gxP, Integer.valueOf(paramInt1), paramIntent });
    if (Util.isNullOrNil(paramIntent))
    {
      Log.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
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
      getString(2131755998);
      this.tipDialog = h.a((Context)localObject, getString(2131764649), false, null);
      if (ab.Ix(this.gxP))
      {
        new com.tencent.mm.chatroom.d.b(this.gxP, paramIntent).aYI().a(this).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new e(this.gxP, paramIntent).aYI().a(this).b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(12844);
      return;
      localObject = getContext();
      getString(2131755998);
      this.tipDialog = h.a((Context)localObject, getString(2131764674), false, null);
      if (ab.Ix(this.gxP))
      {
        new d(this.gxP, paramIntent).aYI().a(this).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new com.tencent.mm.chatroom.d.f(this.gxP, paramIntent).aYI().a(this).b(new com.tencent.mm.vending.c.a() {});
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12839);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().add(this);
    this.gxP = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12839);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12840);
    super.onDestroy();
    ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().remove(this);
    AppMethodBeat.o(12840);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(12842);
    if (paramMStorageEventData != null) {
      Log.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", new Object[] { paramString, paramMStorageEventData.event, Integer.valueOf(paramMStorageEventData.eventId) });
    }
    AppMethodBeat.o(12842);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    public as contact;
    public int type;
    
    public a(int paramInt, as paramas)
    {
      this.type = paramInt;
      this.contact = paramas;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeRoomManagerUI.a> dataList;
    private com.tencent.mm.av.a.a.c gzE;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12831);
      this.dataList = new ArrayList();
      this.mContext = paramContext;
      and();
      notifyDataSetChanged();
      this$1 = new com.tencent.mm.av.a.a.c.a();
      SeeRoomManagerUI.this.jbf = true;
      SeeRoomManagerUI.this.hZF = true;
      SeeRoomManagerUI.this.jbq = 2131690042;
      this.gzE = SeeRoomManagerUI.this.bdv();
      AppMethodBeat.o(12831);
    }
    
    private void and()
    {
      AppMethodBeat.i(12833);
      this.dataList.clear();
      SeeRoomManagerUI.a(SeeRoomManagerUI.this, ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(Util.nullAsNil(SeeRoomManagerUI.c(SeeRoomManagerUI.this))));
      if (SeeRoomManagerUI.d(SeeRoomManagerUI.this) == null)
      {
        AppMethodBeat.o(12833);
        return;
      }
      Iterator localIterator = SeeRoomManagerUI.d(SeeRoomManagerUI.this).bax().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (SeeRoomManagerUI.d(SeeRoomManagerUI.this).bjf((String)localObject))
        {
          Log.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", new Object[] { localObject });
          localObject = ((l)g.af(l.class)).aSN().Kn((String)localObject);
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 1, (as)localObject));
        }
      }
      if (z.aTY().equals(SeeRoomManagerUI.d(SeeRoomManagerUI.this).field_roomowner))
      {
        this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 2, null));
        if (this.dataList.size() > 1) {
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 3, null));
        }
      }
      AppMethodBeat.o(12833);
    }
    
    private SeeRoomManagerUI.a ol(int paramInt)
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
        localView = View.inflate(this.mContext, 2131496126, null);
        paramViewGroup = SeeRoomManagerUI.this.cj(localView);
      }
      for (;;)
      {
        paramView = ol(paramInt);
        if (paramView != null) {
          break;
        }
        Log.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12836);
        return localView;
        SeeRoomManagerUI.c localc = (SeeRoomManagerUI.c)paramView.getTag();
        paramViewGroup = localc;
        localView = paramView;
        if (localc == null)
        {
          paramViewGroup = SeeRoomManagerUI.this.cj(paramView);
          localView = paramView;
        }
      }
      if (paramView.type == 1)
      {
        paramViewGroup.gzG.setVisibility(0);
        paramView = paramView.contact;
        paramViewGroup.gzG.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramView.field_username, paramViewGroup.gzG));
        a.b.c(paramViewGroup.gvv, paramView.field_username);
      }
      for (;;)
      {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12830);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomManagerUI$ManagerAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
          paramViewGroup.gzG.setVisibility(4);
          paramViewGroup.gvv.setImageResource(2131231212);
        }
        else if (paramView.type == 3)
        {
          paramViewGroup.gzG.setVisibility(4);
          paramViewGroup.gvv.setImageResource(2131231213);
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
          int j = (int)(SeeRoomManagerUI.this.getResources().getDimension(2131165194) + SeeRoomManagerUI.this.getResources().getDimension(2131165526) + SeeRoomManagerUI.this.getResources().getDimension(2131165592));
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
    public ImageView gvv;
    public TextView gzG;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */