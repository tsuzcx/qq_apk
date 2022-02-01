package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.y.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectAddRoomManagerUI
  extends SelectMemberUI
{
  private boolean lMQ;
  private HashSet<String> lMR;
  
  public SelectAddRoomManagerUI()
  {
    AppMethodBeat.i(12912);
    this.lMQ = false;
    this.lMR = new HashSet();
    AppMethodBeat.o(12912);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(12918);
    if (this.lNj.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12918);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12918);
  }
  
  protected final void a(View paramView, LinearLayout paramLinearLayout, ImageButton paramImageButton, int paramInt, String paramString)
  {
    AppMethodBeat.i(241543);
    super.a(paramView, paramLinearLayout, paramImageButton, paramInt, paramString);
    aNr();
    AppMethodBeat.o(241543);
  }
  
  protected final void aNn()
  {
    AppMethodBeat.i(12913);
    super.aNn();
    this.lMQ = false;
    Iterator localIterator = this.lzy.bHw().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.lzy.bvK(str)) {
        this.lMR.add(str);
      }
    }
    AppMethodBeat.o(12913);
  }
  
  public final boolean aNo()
  {
    return true;
  }
  
  protected final boolean aNp()
  {
    return false;
  }
  
  protected final HashSet<String> aNq()
  {
    return this.lMR;
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
    if (this.lMQ)
    {
      str = getString(a.i.lIQ);
      setMMTitle(str);
      if (!this.lMQ) {
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
      if (!this.lMQ) {
        break label107;
      }
    }
    label96:
    label107:
    for (y.b localb = y.b.adEK;; localb = y.b.adEJ)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      aNr();
      AppMethodBeat.o(12914);
      return;
      str = getString(a.i.lIP);
      break;
      str = getString(a.i.app_finish);
      break label45;
    }
  }
  
  protected final void onItemClick(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12917);
    super.onItemClick(paramView, paramInt, paramLong);
    paramView = (SelectMemberUI.c)paramView.getTag();
    String str = paramView.lNx.contact.aSV();
    Log.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { paramView.lNx.contact.field_username, str, paramView.lNx.contact.aSU() });
    paramView.lNB.performClick();
    AppMethodBeat.o(12917);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */