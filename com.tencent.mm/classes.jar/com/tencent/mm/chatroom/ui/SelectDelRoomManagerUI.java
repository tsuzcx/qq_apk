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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectDelRoomManagerUI
  extends SelectMemberUI
{
  private boolean fSW;
  private List<String> fTh;
  
  public SelectDelRoomManagerUI()
  {
    AppMethodBeat.i(12939);
    this.fSW = false;
    this.fTh = new ArrayList();
    AppMethodBeat.o(12939);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(12946);
    if (this.fTo.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(12946);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(12946);
  }
  
  protected final void Zj()
  {
    AppMethodBeat.i(12940);
    super.Zj();
    Object localObject1 = getIntent().getStringExtra("RoomManagers");
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.fTh.add(localObject2);
        i += 1;
      }
    }
    this.fSW = true;
    AppMethodBeat.o(12940);
  }
  
  public final boolean Zk()
  {
    return true;
  }
  
  protected final boolean Zo()
  {
    return false;
  }
  
  protected final BaseAdapter Zp()
  {
    AppMethodBeat.i(12944);
    BaseAdapter localBaseAdapter = super.Zp();
    AppMethodBeat.o(12944);
    return localBaseAdapter;
  }
  
  protected final List<String> Zq()
  {
    return this.fTh;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12943);
    super.a(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).fTD.performClick();
    AppMethodBeat.o(12943);
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
    if (this.fSW)
    {
      str = getString(2131762699);
      setMMTitle(str);
      if (!this.fSW) {
        break label93;
      }
      str = getString(2131758039);
      local1 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12938);
          if (SelectDelRoomManagerUI.a(SelectDelRoomManagerUI.this))
          {
            h.a(SelectDelRoomManagerUI.this, SelectDelRoomManagerUI.this.getString(2131762598), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(12937);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("Select_Contact", bt.m(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
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
          paramAnonymousMenuItem.putExtra("Select_Contact", bt.m(SelectDelRoomManagerUI.b(SelectDelRoomManagerUI.this), ","));
          SelectDelRoomManagerUI.this.setResult(-1, paramAnonymousMenuItem);
          SelectDelRoomManagerUI.this.finish();
          AppMethodBeat.o(12938);
          return true;
        }
      };
      if (!this.fSW) {
        break label103;
      }
    }
    label93:
    label103:
    for (s.b localb = s.b.JbT;; localb = s.b.JbS)
    {
      addTextOptionMenu(1, str, local1, null, localb);
      Zm();
      AppMethodBeat.o(12941);
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
    AppMethodBeat.i(12945);
    super.v(paramInt, paramBoolean);
    Zm();
    AppMethodBeat.o(12945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI
 * JD-Core Version:    0.7.0.1
 */