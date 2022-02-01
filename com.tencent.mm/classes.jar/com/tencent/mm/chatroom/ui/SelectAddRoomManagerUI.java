package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.s.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean fzG;
  private HashSet<String> fzH;
  
  public SelectAddRoomManagerUI()
  {
    AppMethodBeat.i(12912);
    this.fzG = false;
    this.fzH = new HashSet();
    AppMethodBeat.o(12912);
  }
  
  private void WT()
  {
    AppMethodBeat.i(12918);
    if (this.fzY.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12918);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12918);
  }
  
  protected final void WQ()
  {
    AppMethodBeat.i(12913);
    super.WQ();
    this.fzG = false;
    Iterator localIterator = this.ftP.aDl().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.ftP.aMU(str)) {
        this.fzH.add(str);
      }
    }
    AppMethodBeat.o(12913);
  }
  
  public final boolean WR()
  {
    return true;
  }
  
  protected final HashSet<String> WS()
  {
    return this.fzH;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12917);
    super.a(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.fAj.contact.aaS();
    ac.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.fAj.contact.field_username, str, paramView.fAj.contact.aaR() });
    paramView.fAn.performClick();
    AppMethodBeat.o(12917);
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
    if (this.fzG)
    {
      str = getString(2131762699);
      setMMTitle(str);
      if (!this.fzG) {
        break label93;
      }
      str = getString(2131758039);
      local1 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12911);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Contact", bs.n(SelectAddRoomManagerUI.a(SelectAddRoomManagerUI.this), ","));
          SelectAddRoomManagerUI.this.setResult(-1, paramAnonymousMenuItem);
          SelectAddRoomManagerUI.this.finish();
          SelectAddRoomManagerUI.this.hideVKB();
          AppMethodBeat.o(12911);
          return false;
        }
      };
      if (!this.fzG) {
        break label103;
      }
    }
    label93:
    label103:
    for (s.b localb = s.b.Hon;; localb = s.b.Hom)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      WT();
      AppMethodBeat.o(12914);
      return;
      str = getString(2131762698);
      break;
      str = getString(2131755779);
      break label43;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void v(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12915);
    super.v(paramInt, paramBoolean);
    WT();
    AppMethodBeat.o(12915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */