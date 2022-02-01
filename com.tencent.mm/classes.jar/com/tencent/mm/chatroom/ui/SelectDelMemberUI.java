package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d.a;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.y.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectDelMemberUI
  extends SelectMemberUI
{
  private int lKi;
  
  private void aNr()
  {
    AppMethodBeat.i(12935);
    if (this.lNj.size() > 0)
    {
      updateOptionMenuText(1, getString(a.i.delete_room_member) + "(" + this.lNj.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(12935);
      return;
    }
    updateOptionMenuText(1, getString(a.i.delete_room_member));
    enableOptionMenu(1, false);
    AppMethodBeat.o(12935);
  }
  
  protected final void a(View paramView, LinearLayout paramLinearLayout, ImageButton paramImageButton, int paramInt, String paramString)
  {
    AppMethodBeat.i(241584);
    super.a(paramView, paramLinearLayout, paramImageButton, paramInt, paramString);
    aNr();
    AppMethodBeat.o(241584);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(241588);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.lNj.contains(parama.contact.field_username);
      AppMethodBeat.o(241588);
      return bool;
    }
    AppMethodBeat.o(241588);
    return false;
  }
  
  protected final void aNn()
  {
    AppMethodBeat.i(12929);
    super.aNn();
    this.lKi = getIntent().getIntExtra("room_member_count", 0);
    AppMethodBeat.o(12929);
  }
  
  public final boolean aNo()
  {
    return true;
  }
  
  protected final boolean aNp()
  {
    return false;
  }
  
  protected final HashSet<String> aNs()
  {
    AppMethodBeat.i(12932);
    HashSet localHashSet = super.aNs();
    if (aNx().Jf(z.bAM()))
    {
      AppMethodBeat.o(12932);
      return localHashSet;
    }
    Iterator localIterator = aNx().bHw().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((aNx().bvK(str)) || (aNx().Jf(str))) {
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
    setMMTitle(getString(a.i.lIO) + "(" + this.lKi + ")");
    addTextOptionMenu(1, getString(a.i.delete_room_member), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12928);
        k.a(SelectDelMemberUI.this, SelectDelMemberUI.this.getString(a.i.lIi), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    }, null, y.b.adEK);
    aNr();
    AppMethodBeat.o(12930);
  }
  
  protected final void onItemClick(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12934);
    super.onItemClick(paramView, paramInt, paramLong);
    if (getContentLV().getAdapter() == this.lNh)
    {
      paramView = (d.a)paramView.getTag();
      if ((paramView.lBC != null) && ((paramView.lBC.getTag() instanceof String)))
      {
        paramView = (String)paramView.lBC.getTag();
        if (!this.lNj.contains(paramView)) {
          break label104;
        }
        this.lNj.remove(paramView);
      }
      for (;;)
      {
        aNr();
        this.lNh.notifyDataSetChanged();
        AppMethodBeat.o(12934);
        return;
        label104:
        this.lNj.add(paramView);
      }
    }
    ((SelectMemberUI.c)paramView.getTag()).lNB.performClick();
    AppMethodBeat.o(12934);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI
 * JD-Core Version:    0.7.0.1
 */