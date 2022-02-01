package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.w.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean jkm;
  private HashSet<String> jkn;
  
  public SelectAddRoomManagerUI()
  {
    AppMethodBeat.i(12912);
    this.jkm = false;
    this.jkn = new HashSet();
    AppMethodBeat.o(12912);
  }
  
  private void atk()
  {
    AppMethodBeat.i(12918);
    if (this.jkF.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12918);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12918);
  }
  
  protected final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12915);
    super.B(paramInt, paramBoolean);
    atk();
    AppMethodBeat.o(12915);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12917);
    super.a(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.jkS.contact.ays();
    Log.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.jkS.contact.field_username, str, paramView.jkS.contact.ayr() });
    paramView.jkW.performClick();
    AppMethodBeat.o(12917);
  }
  
  protected final void atg()
  {
    AppMethodBeat.i(12913);
    super.atg();
    this.jkm = false;
    Iterator localIterator = this.iXp.bjL().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.iXp.bvA(str)) {
        this.jkn.add(str);
      }
    }
    AppMethodBeat.o(12913);
  }
  
  public final boolean ath()
  {
    return true;
  }
  
  protected final boolean ati()
  {
    return false;
  }
  
  protected final HashSet<String> atj()
  {
    return this.jkn;
  }
  
  public void finish()
  {
    AppMethodBeat.i(12916);
    hideVKB();
    super.finish();
    AppMethodBeat.o(12916);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12914);
    super.initView();
    String str;
    label45:
    MenuItem.OnMenuItemClickListener local1;
    if (this.jkm)
    {
      str = getString(a.i.jgD);
      setMMTitle(str);
      if (!this.jkm) {
        break label96;
      }
      str = getString(a.i.delete_room_member);
      local1 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12911);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectAddRoomManagerUI.a(SelectAddRoomManagerUI.this), ","));
          SelectAddRoomManagerUI.this.setResult(-1, paramAnonymousMenuItem);
          SelectAddRoomManagerUI.this.finish();
          SelectAddRoomManagerUI.this.hideVKB();
          AppMethodBeat.o(12911);
          return false;
        }
      };
      if (!this.jkm) {
        break label107;
      }
    }
    label96:
    label107:
    for (w.b localb = w.b.Wap;; localb = w.b.Wao)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      atk();
      AppMethodBeat.o(12914);
      return;
      str = getString(a.i.jgC);
      break;
      str = getString(a.i.app_finish);
      break label45;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */