package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.model.q;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.s.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectDelMemberUI
  extends SelectMemberUI
{
  private int dpy;
  
  private void xU()
  {
    if (this.drY.size() > 0)
    {
      updateOptionMenuText(1, getString(a.i.delete_room_member) + "(" + this.drY.size() + ")");
      enableOptionMenu(1, true);
      return;
    }
    updateOptionMenuText(1, getString(a.i.delete_room_member));
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
    setMMTitle(getString(a.i.room_see_room_member) + "(" + this.dpy + ")");
    a(1, getString(a.i.delete_room_member), new SelectDelMemberUI.1(this), s.b.uNy);
    xU();
  }
  
  protected final void u(int paramInt, boolean paramBoolean)
  {
    super.u(paramInt, paramBoolean);
    xU();
  }
  
  protected final void xR()
  {
    super.xR();
    this.dpy = getIntent().getIntExtra("room_member_count", 0);
  }
  
  public final boolean xS()
  {
    return true;
  }
  
  protected final HashSet<String> xV()
  {
    HashSet localHashSet = super.xV();
    if (ya().aaP(q.Gj())) {
      return localHashSet;
    }
    Iterator localIterator = ya().MN().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((ya().aaM(str)) || (ya().aaP(str))) {
        localHashSet.add(str);
      }
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI
 * JD-Core Version:    0.7.0.1
 */