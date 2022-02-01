package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d.a;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.y.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectRoomFollowMemberManagerUI
  extends SelectMemberUI
{
  private HashSet<String> lMR;
  
  public SelectRoomFollowMemberManagerUI()
  {
    AppMethodBeat.i(241796);
    this.lMR = new HashSet();
    AppMethodBeat.o(241796);
  }
  
  private void eB(boolean paramBoolean)
  {
    AppMethodBeat.i(241802);
    Iterator localIterator;
    int i;
    label88:
    String str;
    if (this.lNj.size() > 0)
    {
      updateOptionMenuText(1, getString(a.i.app_finish) + "(" + this.lNj.size() + ")");
      if (this.lNj.size() != this.lMR.size()) {
        break label198;
      }
      localIterator = this.lNj.iterator();
      i = 1;
      if (!localIterator.hasNext()) {
        break label142;
      }
      str = (String)localIterator.next();
      if (this.lMR.contains(str)) {
        break label228;
      }
      i = 0;
    }
    label142:
    label198:
    label228:
    for (;;)
    {
      break label88;
      updateOptionMenuText(1, getString(a.i.app_finish));
      break;
      int j = i;
      if (i == 0)
      {
        localIterator = this.lMR.iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
          if (!this.lNj.contains(str)) {
            i = 0;
          }
        }
        j = 0;
      }
      if (j == 0)
      {
        enableOptionMenu(1, paramBoolean);
        AppMethodBeat.o(241802);
        return;
      }
      enableOptionMenu(1, false);
      AppMethodBeat.o(241802);
      return;
    }
  }
  
  protected final void a(View paramView, LinearLayout paramLinearLayout, ImageButton paramImageButton, int paramInt, String paramString)
  {
    AppMethodBeat.i(241821);
    onItemClick(paramView, paramInt, 0L);
    AppMethodBeat.o(241821);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(241828);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.lNj.contains(parama.contact.field_username);
      AppMethodBeat.o(241828);
      return bool;
    }
    AppMethodBeat.o(241828);
    return false;
  }
  
  protected final void aNn()
  {
    AppMethodBeat.i(241812);
    super.aNn();
    if ((this.lzy.field_localChatRoomWatchMembers == null) || (this.lzy.field_localChatRoomWatchMembers.YGK == null))
    {
      AppMethodBeat.o(241812);
      return;
    }
    Iterator localIterator = this.lzy.field_localChatRoomWatchMembers.YGK.iterator();
    while (localIterator.hasNext())
    {
      zi localzi = (zi)localIterator.next();
      if ((!Util.isNullOrNil(localzi.UserName)) && (!this.lMR.contains(localzi.UserName)) && (this.lzy.bHw().contains(localzi.UserName))) {
        this.lMR.add(localzi.UserName);
      }
    }
    this.lNj.addAll(this.lMR);
    AppMethodBeat.o(241812);
  }
  
  public final boolean aNo()
  {
    return true;
  }
  
  protected final List<String> aNv()
  {
    AppMethodBeat.i(241831);
    List localList = this.lzy.bHw();
    AppMethodBeat.o(241831);
    return localList;
  }
  
  public void finish()
  {
    AppMethodBeat.i(241823);
    hideVKB();
    super.finish();
    AppMethodBeat.o(241823);
  }
  
  public void initView()
  {
    AppMethodBeat.i(241820);
    super.initView();
    setMMTitle(getString(a.i.lIS));
    addTextOptionMenu(1, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(241785);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectRoomFollowMemberManagerUI.a(SelectRoomFollowMemberManagerUI.this), ","));
        SelectRoomFollowMemberManagerUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectRoomFollowMemberManagerUI.this.finish();
        AppMethodBeat.o(241785);
        return false;
      }
    }, null, y.b.adEJ);
    eB(false);
    AppMethodBeat.o(241820);
  }
  
  protected final void onItemClick(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(241826);
    super.onItemClick(paramView, paramInt, paramLong);
    Object localObject1;
    if (getContentLV().getAdapter() == this.lNh)
    {
      localObject1 = (d.a)paramView.getTag();
      if ((((d.a)localObject1).lBC == null) || (!(((d.a)localObject1).lBC.getTag() instanceof String))) {
        break label403;
      }
      localObject1 = (String)((d.a)localObject1).lBC.getTag();
    }
    for (;;)
    {
      if (!this.lNj.contains(localObject1))
      {
        paramInt = this.lNj.size();
        Object localObject2 = RoomSpecialFollowMemberManagerUI.lLe;
        if (paramInt >= RoomSpecialFollowMemberManagerUI.a.aNf())
        {
          paramView = getContext();
          paramInt = a.i.lIU;
          localObject1 = new StringBuilder();
          localObject2 = RoomSpecialFollowMemberManagerUI.lLe;
          k.a(paramView, getString(paramInt, new Object[] { RoomSpecialFollowMemberManagerUI.a.aNf() }), "", getString(a.i.app_i_know), false, null);
          AppMethodBeat.o(241826);
          return;
          localObject2 = (SelectMemberUI.c)paramView.getTag();
          localObject1 = ((SelectMemberUI.c)localObject2).lNx.contact.field_username;
          Log.d("MicroMsg.SelectAddRoomManagerUI", "[onItemClick] username:%s remark:%s", new Object[] { localObject1, ((SelectMemberUI.c)localObject2).lNx.contact.aSV(), ((SelectMemberUI.c)localObject2).lNx.contact.aSU() });
          continue;
        }
      }
      if (getContentLV().getAdapter() == this.lNh)
      {
        paramView = (d.a)paramView.getTag();
        if ((paramView.lBC != null) && ((paramView.lBC.getTag() instanceof String)))
        {
          if (!this.lNj.contains(localObject1)) {
            break label324;
          }
          this.lNj.remove(localObject1);
          this.lNh.notifyDataSetChanged();
        }
      }
      for (;;)
      {
        eB(true);
        AppMethodBeat.o(241826);
        return;
        label324:
        this.lNj.add(localObject1);
        break;
        paramView = (SelectMemberUI.c)paramView.getTag();
        if (this.lNj.contains(localObject1))
        {
          this.lNj.remove(localObject1);
          paramView.lNA.setImageResource(a.d.checkbox_unselected);
        }
        else
        {
          this.lNj.add(localObject1);
          paramView.lNA.setImageResource(a.h.checkbox_selected);
        }
      }
      label403:
      localObject1 = "";
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectRoomFollowMemberManagerUI
 * JD-Core Version:    0.7.0.1
 */