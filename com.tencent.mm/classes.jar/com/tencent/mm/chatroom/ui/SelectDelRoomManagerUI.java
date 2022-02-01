package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectDelRoomManagerUI
  extends SelectMemberUI
{
  private boolean gAj;
  private List<String> gAu;
  
  public SelectDelRoomManagerUI()
  {
    AppMethodBeat.i(12939);
    this.gAj = false;
    this.gAu = new ArrayList();
    AppMethodBeat.o(12939);
  }
  
  private void ani()
  {
    AppMethodBeat.i(12946);
    if (this.gAB.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12946);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12946);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12943);
    super.a(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).gAQ.performClick();
    AppMethodBeat.o(12943);
  }
  
  protected final void anf()
  {
    AppMethodBeat.i(12940);
    super.anf();
    Object localObject1 = getIntent().getStringExtra("RoomManagers");
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.gAu.add(localObject2);
        i += 1;
      }
    }
    this.gAj = true;
    AppMethodBeat.o(12940);
  }
  
  public final boolean ang()
  {
    return true;
  }
  
  protected final boolean ank()
  {
    return false;
  }
  
  protected final BaseAdapter anl()
  {
    AppMethodBeat.i(12944);
    BaseAdapter localBaseAdapter = super.anl();
    AppMethodBeat.o(12944);
    return localBaseAdapter;
  }
  
  protected final List<String> anm()
  {
    return this.gAu;
  }
  
  public void finish()
  {
    AppMethodBeat.i(12942);
    hideVKB();
    super.finish();
    AppMethodBeat.o(12942);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12941);
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
          AppMethodBeat.i(12938);
          if (SelectDelRoomManagerUI.a(SelectDelRoomManagerUI.this))
          {
            h.a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(2131764678), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(12937);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("Select_Contact", Util.listToString(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
                SelectDelRoomManagerUI.this.setResult(-1, paramAnonymous2DialogInterface);
                SelectDelRoomManagerUI.this.finish();
                AppMethodBeat.o(12937);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(12938);
            return true;
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
          SelectDelRoomManagerUI.this.setResult(-1, paramAnonymousMenuItem);
          SelectDelRoomManagerUI.this.finish();
          AppMethodBeat.o(12938);
          return true;
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
      AppMethodBeat.o(12941);
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
    AppMethodBeat.i(12945);
    super.z(paramInt, paramBoolean);
    ani();
    AppMethodBeat.o(12945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */