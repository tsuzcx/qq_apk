package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.s.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean drF = false;
  private HashSet<String> drG = new HashSet();
  
  private void xU()
  {
    if (this.drY.size() > 0)
    {
      enableOptionMenu(1, true);
      return;
    }
    enableOptionMenu(1, false);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    super.a(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.dsj.dnp.Bq();
    y.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.dsj.dnp.field_username, str, paramView.dsj.dnp.Bp() });
    paramView.dsn.performClick();
  }
  
  public void finish()
  {
    XM();
    super.finish();
  }
  
  protected final void initView()
  {
    super.initView();
    String str;
    label39:
    SelectAddRoomManagerUI.1 local1;
    if (this.drF)
    {
      str = getString(a.i.room_select_delete_manager);
      setMMTitle(str);
      if (!this.drF) {
        break label83;
      }
      str = getString(a.i.delete_room_member);
      local1 = new SelectAddRoomManagerUI.1(this);
      if (!this.drF) {
        break label94;
      }
    }
    label83:
    label94:
    for (s.b localb = s.b.uNy;; localb = s.b.uNx)
    {
      a(1, str, local1, localb);
      xU();
      return;
      str = getString(a.i.room_select_add_manager);
      break;
      str = getString(a.i.app_finish);
      break label39;
    }
  }
  
  protected final void u(int paramInt, boolean paramBoolean)
  {
    super.u(paramInt, paramBoolean);
    xU();
  }
  
  protected final void xR()
  {
    super.xR();
    this.drF = false;
    Iterator localIterator = this.dnL.MN().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.dnL.aaM(str)) {
        this.drG.add(str);
      }
    }
  }
  
  public final boolean xS()
  {
    return true;
  }
  
  protected final HashSet<String> xT()
  {
    return this.drG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */