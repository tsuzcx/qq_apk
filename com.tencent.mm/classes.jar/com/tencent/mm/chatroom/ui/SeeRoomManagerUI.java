package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.chatroom.c.b;
import com.tencent.mm.chatroom.c.d;
import com.tencent.mm.ck.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI
  extends MMActivity
  implements j.a
{
  private u dnL;
  private String dpx;
  private GridView dqY;
  private b drg;
  private p tipDialog;
  
  public final void a(String paramString, l paraml)
  {
    if (paraml != null) {
      y.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", new Object[] { paramString, paraml.bGt, Integer.valueOf(paraml.gbI) });
    }
  }
  
  protected final c bL(View paramView)
  {
    c localc = new c();
    localc.doU = ((ImageView)paramView.findViewById(a.e.roominfo_img));
    localc.drf = ((TextView)paramView.findViewById(a.e.roominfo_contact_name_for_span));
    return localc;
  }
  
  protected final int getLayoutId()
  {
    return a.f.see_room_manager_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    setMMTitle(a.i.room_manager_title);
    this.dqY = ((GridView)findViewById(a.e.manager_gridview));
    this.drg = new b(this);
    this.dqY.setAdapter(this.drg);
    this.dqY.setOnTouchListener(new SeeRoomManagerUI.1(this));
    this.dqY.post(new SeeRoomManagerUI.2(this));
    setBackBtn(new SeeRoomManagerUI.3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      if (paramIntent == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.w("MicroMsg.SeeRoomManagerUI", "[onActivityResult] data is null? %s resultCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    y.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.dpx, Integer.valueOf(paramInt1), paramIntent });
    if (bk.bl(paramIntent))
    {
      y.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
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
    default: 
      return;
    case 0: 
      localObject = this.mController.uMN;
      getString(a.i.app_tip);
      this.tipDialog = h.b((Context)localObject, getString(a.i.room_add_manager_handle), false, null);
      new b(this.dpx, paramIntent).Km().b(this).b(new SeeRoomManagerUI.4(this, paramIntent));
      return;
    }
    localObject = this.mController.uMN;
    getString(a.i.app_tip);
    this.tipDialog = h.b((Context)localObject, getString(a.i.room_del_manager_handle), false, null);
    new d(this.dpx, paramIntent).Km().b(this).b(new SeeRoomManagerUI.5(this, paramIntent));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().c(this);
    this.dpx = getIntent().getStringExtra("RoomInfo_Id");
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().d(this);
  }
  
  public final class a
  {
    public ad dnp;
    public int type;
    
    public a(int paramInt, ad paramad)
    {
      this.type = paramInt;
      this.dnp = paramad;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    List<SeeRoomManagerUI.a> dataList = new ArrayList();
    private com.tencent.mm.as.a.a.c drd;
    Context mContext;
    
    public b(Context paramContext)
    {
      this.mContext = paramContext;
      xO();
      notifyDataSetChanged();
      this$1 = new c.a();
      SeeRoomManagerUI.this.erf = true;
      SeeRoomManagerUI.this.erC = true;
      SeeRoomManagerUI.this.eru = a.h.default_avatar;
      this.drd = SeeRoomManagerUI.this.OV();
    }
    
    private SeeRoomManagerUI.a gm(int paramInt)
    {
      return (SeeRoomManagerUI.a)this.dataList.get(paramInt);
    }
    
    private void xO()
    {
      this.dataList.clear();
      SeeRoomManagerUI.a(SeeRoomManagerUI.this, ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(bk.pm(SeeRoomManagerUI.c(SeeRoomManagerUI.this))));
      if (SeeRoomManagerUI.d(SeeRoomManagerUI.this) == null) {}
      do
      {
        do
        {
          return;
          Iterator localIterator = SeeRoomManagerUI.d(SeeRoomManagerUI.this).MN().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            if (SeeRoomManagerUI.d(SeeRoomManagerUI.this).aaM((String)localObject))
            {
              y.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", new Object[] { localObject });
              localObject = ((j)g.r(j.class)).Fw().abl((String)localObject);
              this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 1, (ad)localObject));
            }
          }
        } while (!q.Gj().equals(SeeRoomManagerUI.d(SeeRoomManagerUI.this).field_roomowner));
        this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 2, null));
      } while (this.dataList.size() <= 1);
      this.dataList.add(new SeeRoomManagerUI.a(SeeRoomManagerUI.this, 3, null));
    }
    
    public final int getCount()
    {
      return this.dataList.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, a.f.roominfo_contact, null);
        paramViewGroup = SeeRoomManagerUI.this.bL(localView);
      }
      for (;;)
      {
        paramView = gm(paramInt);
        if (paramView != null) {
          break;
        }
        y.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        return localView;
        SeeRoomManagerUI.c localc = (SeeRoomManagerUI.c)paramView.getTag();
        paramViewGroup = localc;
        localView = paramView;
        if (localc == null)
        {
          paramViewGroup = SeeRoomManagerUI.this.bL(paramView);
          localView = paramView;
        }
      }
      if (paramView.type == 1)
      {
        paramViewGroup.drf.setVisibility(0);
        paramView = paramView.dnp;
        paramViewGroup.drf.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, paramView.field_username, paramViewGroup.drf));
        a.b.a(paramViewGroup.doU, paramView.field_username);
      }
      for (;;)
      {
        localView.setOnClickListener(new SeeRoomManagerUI.b.2(this, paramInt));
        return localView;
        if (paramView.type == 2)
        {
          paramViewGroup.drf.setVisibility(4);
          paramViewGroup.doU.setImageResource(a.d.big_add_selector);
        }
        else if (paramView.type == 3)
        {
          paramViewGroup.drf.setVisibility(4);
          paramViewGroup.doU.setImageResource(a.d.big_del_selector);
        }
      }
    }
    
    public final void notifyDataSetChanged()
    {
      super.notifyDataSetChanged();
      SeeRoomManagerUI.b(SeeRoomManagerUI.this).post(new SeeRoomManagerUI.b.1(this));
    }
  }
  
  final class c
  {
    public ImageView doU;
    public TextView drf;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */