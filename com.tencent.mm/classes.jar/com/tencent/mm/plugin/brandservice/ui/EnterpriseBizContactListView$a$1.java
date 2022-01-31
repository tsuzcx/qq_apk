package com.tencent.mm.plugin.brandservice.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.brandservice.b.h;

final class EnterpriseBizContactListView$a$1
  implements View.OnCreateContextMenuListener
{
  EnterpriseBizContactListView$a$1(EnterpriseBizContactListView.a parama, int paramInt) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(this.kX, 1, 0, b.h.enterprise_longclick_disable_sub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.1
 * JD-Core Version:    0.7.0.1
 */