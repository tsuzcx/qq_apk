package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectDelRoomManagerUI
  extends SelectMemberUI
{
  private boolean drF = false;
  private List<String> drQ = new ArrayList();
  
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
    ((SelectMemberUI.c)paramView.getTag()).dsn.performClick();
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
    SelectDelRoomManagerUI.1 local1;
    if (this.drF)
    {
      str = getString(a.i.room_select_delete_manager);
      setMMTitle(str);
      if (!this.drF) {
        break label83;
      }
      str = getString(a.i.delete_room_member);
      local1 = new SelectDelRoomManagerUI.1(this);
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
    Object localObject1 = getIntent().getStringExtra("RoomManagers");
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.drQ.add(localObject2);
        i += 1;
      }
    }
    this.drF = true;
  }
  
  public final boolean xS()
  {
    return true;
  }
  
  protected final boolean xW()
  {
    return false;
  }
  
  protected final BaseAdapter xX()
  {
    return super.xX();
  }
  
  protected final List<String> xY()
  {
    return this.drQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */