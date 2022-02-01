package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.t.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean gAj;
  private HashSet<String> gAk;
  
  public SelectAddRoomManagerUI()
  {
    AppMethodBeat.i(12912);
    this.gAj = false;
    this.gAk = new HashSet();
    AppMethodBeat.o(12912);
  }
  
  private void ani()
  {
    AppMethodBeat.i(12918);
    if (this.gAB.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12918);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12918);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12917);
    super.a(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.gAM.contact.arJ();
    Log.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.gAM.contact.field_username, str, paramView.gAM.contact.arI() });
    paramView.gAQ.performClick();
    AppMethodBeat.o(12917);
  }
  
  protected final void anf()
  {
    AppMethodBeat.i(12913);
    super.anf();
    this.gAj = false;
    Iterator localIterator = this.gtd.bax().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.gtd.bjf(str)) {
        this.gAk.add(str);
      }
    }
    AppMethodBeat.o(12913);
  }
  
  public final boolean ang()
  {
    return true;
  }
  
  protected final HashSet<String> anh()
  {
    return this.gAk;
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
    label43:
    MenuItem.OnMenuItemClickListener local1;
    if (this.gAj)
    {
      str = getString(2131764782);
      setMMTitle(str);
      if (!this.gAj) {
        break label93;
      }
      str = getString(2131758291);
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
      if (!this.gAj) {
        break label103;
      }
    }
    label93:
    label103:
    for (t.b localb = t.b.OGV;; localb = t.b.OGU)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      ani();
      AppMethodBeat.o(12914);
      return;
      str = getString(2131764781);
      break;
      str = getString(2131755858);
      break label43;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12915);
    super.z(paramInt, paramBoolean);
    ani();
    AppMethodBeat.o(12915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */