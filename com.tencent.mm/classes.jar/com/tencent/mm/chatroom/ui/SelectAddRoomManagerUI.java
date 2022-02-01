package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.r.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean fvZ;
  private HashSet<String> fwa;
  
  public SelectAddRoomManagerUI()
  {
    AppMethodBeat.i(12912);
    this.fvZ = false;
    this.fwa = new HashSet();
    AppMethodBeat.o(12912);
  }
  
  private void VV()
  {
    AppMethodBeat.i(12918);
    if (this.fwr.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12918);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12918);
  }
  
  protected final void VS()
  {
    AppMethodBeat.i(12913);
    super.VS();
    this.fvZ = false;
    Iterator localIterator = this.fql.awt().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.fql.aHz(str)) {
        this.fwa.add(str);
      }
    }
    AppMethodBeat.o(12913);
  }
  
  public final boolean VT()
  {
    return true;
  }
  
  protected final HashSet<String> VU()
  {
    return this.fwa;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12917);
    super.a(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.fwC.contact.ZX();
    ad.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.fwC.contact.field_username, str, paramView.fwC.contact.ZW() });
    paramView.fwG.performClick();
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
    if (this.fvZ)
    {
      str = getString(2131762699);
      setMMTitle(str);
      if (!this.fvZ) {
        break label93;
      }
      str = getString(2131758039);
      local1 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12911);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Contact", bt.n(SelectAddRoomManagerUI.a(SelectAddRoomManagerUI.this), ","));
          SelectAddRoomManagerUI.this.setResult(-1, paramAnonymousMenuItem);
          SelectAddRoomManagerUI.this.finish();
          SelectAddRoomManagerUI.this.hideVKB();
          AppMethodBeat.o(12911);
          return false;
        }
      };
      if (!this.fvZ) {
        break label103;
      }
    }
    label93:
    label103:
    for (r.b localb = r.b.FOC;; localb = r.b.FOB)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      VV();
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
    VV();
    AppMethodBeat.o(12915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */