package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d.a;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.w.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectDelMemberUI
  extends SelectMemberUI
{
  private int jhS;
  
  private void atk()
  {
    AppMethodBeat.i(12935);
    if (this.jkF.size() > 0)
    {
      updateOptionMenuText(1, getString(a.i.delete_room_member) + "(" + this.jkF.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(12935);
      return;
    }
    updateOptionMenuText(1, getString(a.i.delete_room_member));
    enableOptionMenu(1, false);
    AppMethodBeat.o(12935);
  }
  
  protected final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12933);
    super.B(paramInt, paramBoolean);
    atk();
    AppMethodBeat.o(12933);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12934);
    super.a(paramView, paramInt, paramLong);
    if (getContentLV().getAdapter() == this.jkD)
    {
      paramView = (d.a)paramView.getTag();
      if ((paramView.iZG != null) && ((paramView.iZG.getTag() instanceof String)))
      {
        paramView = (String)paramView.iZG.getTag();
        if (!this.jkF.contains(paramView)) {
          break label104;
        }
        this.jkF.remove(paramView);
      }
      for (;;)
      {
        atk();
        this.jkD.notifyDataSetChanged();
        AppMethodBeat.o(12934);
        return;
        label104:
        this.jkF.add(paramView);
      }
    }
    ((SelectMemberUI.c)paramView.getTag()).jkW.performClick();
    AppMethodBeat.o(12934);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(191227);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.jkF.contains(parama.contact.field_username);
      AppMethodBeat.o(191227);
      return bool;
    }
    AppMethodBeat.o(191227);
    return false;
  }
  
  protected final void atg()
  {
    AppMethodBeat.i(12929);
    super.atg();
    this.jhS = getIntent().getIntExtra("room_member_count", 0);
    AppMethodBeat.o(12929);
  }
  
  public final boolean ath()
  {
    return true;
  }
  
  protected final boolean ati()
  {
    return false;
  }
  
  protected final HashSet<String> atl()
  {
    AppMethodBeat.i(12932);
    HashSet localHashSet = super.atl();
    if (atq().Rh(z.bcZ()))
    {
      AppMethodBeat.o(12932);
      return localHashSet;
    }
    Iterator localIterator = atq().bjL().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((atq().bvA(str)) || (atq().Rh(str))) {
        localHashSet.add(str);
      }
    }
    AppMethodBeat.o(12932);
    return localHashSet;
  }
  
  public void finish()
  {
    AppMethodBeat.i(12931);
    hideVKB();
    super.finish();
    AppMethodBeat.o(12931);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12930);
    super.initView();
    setMMTitle(getString(a.i.jgB) + "(" + this.jhS + ")");
    addTextOptionMenu(1, getString(a.i.delete_room_member), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12928);
        h.a(SelectDelMemberUI.this, SelectDelMemberUI.this.getString(a.i.jfW), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(12927);
            paramAnonymous2DialogInterface = new Intent();
            paramAnonymous2DialogInterface.putExtra("Select_Contact", Util.listToString(SelectDelMemberUI.a(SelectDelMemberUI.this), ","));
            SelectDelMemberUI.this.setResult(-1, paramAnonymous2DialogInterface);
            SelectDelMemberUI.this.finish();
            AppMethodBeat.o(12927);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(12928);
        return false;
      }
    }, null, w.b.Wap);
    atk();
    AppMethodBeat.o(12930);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI
 * JD-Core Version:    0.7.0.1
 */