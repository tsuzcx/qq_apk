package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectDelMemberUI
  extends SelectMemberUI
{
  private int gxQ;
  
  private void ani()
  {
    AppMethodBeat.i(12935);
    if (this.gAB.size() > 0)
    {
      updateOptionMenuText(1, getString(2131758291) + "(" + this.gAB.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(12935);
      return;
    }
    updateOptionMenuText(1, getString(2131758291));
    enableOptionMenu(1, false);
    AppMethodBeat.o(12935);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12934);
    super.a(paramView, paramInt, paramLong);
    ((SelectMemberUI.c)paramView.getTag()).gAQ.performClick();
    AppMethodBeat.o(12934);
  }
  
  protected final void anf()
  {
    AppMethodBeat.i(12929);
    super.anf();
    this.gxQ = getIntent().getIntExtra("room_member_count", 0);
    AppMethodBeat.o(12929);
  }
  
  public final boolean ang()
  {
    return true;
  }
  
  protected final HashSet<String> anj()
  {
    AppMethodBeat.i(12932);
    HashSet localHashSet = super.anj();
    if (ano().JO(z.aTY()))
    {
      AppMethodBeat.o(12932);
      return localHashSet;
    }
    Iterator localIterator = ano().bax().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((ano().bjf(str)) || (ano().JO(str))) {
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
    setMMTitle(getString(2131764780) + "(" + this.gxQ + ")");
    addTextOptionMenu(1, getString(2131758291), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12928);
        h.a(SelectDelMemberUI.this, SelectDelMemberUI.this.getString(2131764678), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    }, null, t.b.OGV);
    ani();
    AppMethodBeat.o(12930);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12933);
    super.z(paramInt, paramBoolean);
    ani();
    AppMethodBeat.o(12933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI
 * JD-Core Version:    0.7.0.1
 */