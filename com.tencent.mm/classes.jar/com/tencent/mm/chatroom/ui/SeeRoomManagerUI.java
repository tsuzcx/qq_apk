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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.chatroom.d.d;
import com.tencent.mm.chatroom.d.e;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private ah iXp;
  private String jhR;
  private b jjL;
  private GridView jjy;
  private s tipDialog;
  
  protected final c cC(View paramView)
  {
    AppMethodBeat.i(12843);
    c localc = new c();
    localc.iZG = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    localc.jjJ = ((TextView)paramView.findViewById(a.e.roominfo_contact_name_for_span));
    AppMethodBeat.o(12843);
    return localc;
  }
  
  public int getLayoutId()
  {
    return a.f.jel;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12841);
    super.initView();
    setMMTitle(a.i.jgh);
    this.jjy = ((GridView)findViewById(a.e.jcV));
    this.jjL = new b(this);
    this.jjy.setAdapter(this.jjL);
    this.jjy.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.jjy.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12825);
        int j = (int)(SeeRoomManagerUI.this.getResources().getDimension(a.c.BigPadding) + SeeRoomManagerUI.this.getResources().getDimension(a.c.NormalAvatarSize) + SeeRoomManagerUI.this.getResources().getDimension(a.c.SmallerTextSize));
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
    Log.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.jhR, Integer.valueOf(paramInt1), paramIntent });
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
      getString(a.i.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(a.i.jfI), false, null);
      if (ab.PP(this.jhR))
      {
        new com.tencent.mm.chatroom.d.b(this.jhR, paramIntent).bhW().a(this).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new e(this.jhR, paramIntent).bhW().a(this).b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(12844);
      return;
      localObject = getContext();
      getString(a.i.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(a.i.jfT), false, null);
      if (ab.PP(this.jhR))
      {
        new d(this.jhR, paramIntent).bhW().a(this).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(12844);
        return;
      }
      new com.tencent.mm.chatroom.d.f(this.jhR, paramIntent).bhW().a(this).b(new com.tencent.mm.vending.c.a() {});
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12839);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().add(this);
    this.jhR = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12839);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12840);
    super.onDestroy();
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().remove(this);
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
    private c jjH;
    Context mContext;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(12831);
      this.dataList = new ArrayList();
      this.mContext = paramContext;
      ate();
      notifyDataSetChanged();
      this$1 = new com.tencent.mm.ay.a.a.c.a();
      SeeRoomManagerUI.this.lRD = true;
      SeeRoomManagerUI.this.kOl = true;
      SeeRoomManagerUI.this.lRP = a.h.default_avatar;
      this.jjH = SeeRoomManagerUI.this.bmL();
      AppMethodBeat.o(12831);
    }
    
    private void ate()
    {
      AppMethodBeat.i(12833);
      this.dataList.clear();
      SeeRoomManagerUI.a(SeeRoomManagerUI.this, ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(Util.nullAsNil(SeeRoomManagerUI.c(SeeRoomManagerUI.this))));
      if (SeeRoomManagerUI.d(SeeRoomManagerUI.this) == null)
      {
        AppMethodBeat.o(12833);
        return;
      }
      Iterator localIterator = SeeRoomManagerUI.d(SeeRoomManagerUI.this).bjL().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (SeeRoomManagerUI.d(SeeRoomManagerUI.this).bvA((String)localObject))
        {
          Log.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", new Object[] { localObject });
          localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject);
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 1, (as)localObject));
        }
      }
      if (z.bcZ().equals(SeeRoomManagerUI.d(SeeRoomManagerUI.this).field_roomowner))
      {
        this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 2, null));
        if (this.dataList.size() > 1) {
          this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 3, null));
        }
      }
      AppMethodBeat.o(12833);
    }
    
    private SeeRoomManagerUI.a qA(int paramInt)
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
        localView = View.inflate(this.mContext, a.f.roominfo_contact, null);
        paramViewGroup = SeeRoomManagerUI.this.cC(localView);
      }
      for (;;)
      {
        paramView = qA(paramInt);
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
          paramViewGroup = SeeRoomManagerUI.this.cC(paramView);
          localView = paramView;
        }
      }
      if (paramView.type == 1)
      {
        paramViewGroup.jjJ.setVisibility(0);
        paramView = paramView.contact;
        paramViewGroup.jjJ.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramView.field_username, paramViewGroup.jjJ));
        a.b.c(paramViewGroup.iZG, paramView.field_username);
      }
      for (;;)
      {
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12830);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeRoomManagerUI$ManagerAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
          paramViewGroup.jjJ.setVisibility(4);
          paramViewGroup.iZG.setImageResource(a.d.big_add_selector);
        }
        else if (paramView.type == 3)
        {
          paramViewGroup.jjJ.setVisibility(4);
          paramViewGroup.iZG.setImageResource(a.d.big_del_selector);
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
          int j = (int)(SeeRoomManagerUI.this.getResources().getDimension(a.c.BigPadding) + SeeRoomManagerUI.this.getResources().getDimension(a.c.NormalAvatarSize) + SeeRoomManagerUI.this.getResources().getDimension(a.c.SmallerTextSize));
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
    public ImageView iZG;
    public TextView jjJ;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */