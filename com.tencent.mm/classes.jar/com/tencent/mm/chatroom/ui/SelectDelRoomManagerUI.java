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
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectDelRoomManagerUI
  extends SelectMemberUI
{
  private boolean jkm;
  private List<String> jkx;
  
  public SelectDelRoomManagerUI()
  {
    AppMethodBeat.i(12939);
    this.jkm = false;
    this.jkx = new ArrayList();
    AppMethodBeat.o(12939);
  }
  
  private void atk()
  {
    AppMethodBeat.i(12946);
    if (this.jkF.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12946);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12946);
  }
  
  protected final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12945);
    super.B(paramInt, paramBoolean);
    atk();
    AppMethodBeat.o(12945);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12943);
    super.a(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).jkW.performClick();
    AppMethodBeat.o(12943);
  }
  
  protected final void atg()
  {
    AppMethodBeat.i(12940);
    super.atg();
    Object localObject1 = getIntent().getStringExtra("RoomManagers");
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.jkx.add(localObject2);
        i += 1;
      }
    }
    this.jkm = true;
    AppMethodBeat.o(12940);
  }
  
  public final boolean ath()
  {
    return true;
  }
  
  protected final boolean ati()
  {
    return false;
  }
  
  protected final boolean atm()
  {
    return false;
  }
  
  protected final BaseAdapter atn()
  {
    AppMethodBeat.i(12944);
    BaseAdapter localBaseAdapter = super.atn();
    AppMethodBeat.o(12944);
    return localBaseAdapter;
  }
  
  protected final List<String> ato()
  {
    return this.jkx;
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
          AppMethodBeat.i(12938);
          if (SelectDelRoomManagerUI.a(SelectDelRoomManagerUI.this))
          {
            h.a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(a.i.jfW), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      AppMethodBeat.o(12941);
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
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */