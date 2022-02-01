package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<bmp> jJE;
  private LinkedList<dck> lpz;
  private final LayoutInflater mYa;
  boolean mYb;
  private boolean[] mYc;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.mYa = paramLayoutInflater;
  }
  
  public final void a(LinkedList<dck> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.lpz = paramLinkedList;
    }
    for (;;)
    {
      this.mYc = new boolean[this.lpz.size()];
      AppMethodBeat.o(131225);
      return;
      this.lpz = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((dck)paramLinkedList.get(i)).SvP) {
          this.lpz.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] byR()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.mYc;
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (localObject[i] != 0) {
        k = j + 1;
      }
      i += 1;
    }
    localObject = new String[j];
    i = 0;
    j = 0;
    if (j < this.lpz.size())
    {
      if (this.mYc[j] == 0) {
        break label115;
      }
      localObject[i] = ((dck)this.lpz.get(j)).UserName;
      i += 1;
    }
    label115:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(131226);
      return localObject;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(131227);
    int i;
    if (this.mYb)
    {
      if (this.jJE == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.jJE.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.lpz != null)
    {
      i = this.lpz.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.mYb)
    {
      localObject = this.jJE.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.lpz.get(paramInt);
    AppMethodBeat.o(131228);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131229);
    Object localObject;
    View localView;
    if (this.mYb)
    {
      localObject = (bmp)this.jJE.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.mYa.inflate(a.d.inviteqqfriendsgroup_item, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.mYd = ((TextView)localView.findViewById(a.c.qq_friend_group_name));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.mYd.setText(((bmp)localObject).SXx);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    dck localdck = (dck)this.lpz.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.mYa.inflate(a.d.inviteqqfriends_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.jbe = ((TextView)localView.findViewById(a.c.inviteqqfriends_nickname_tv));
      paramViewGroup.mYe = ((TextView)localView.findViewById(a.c.inviteqqfriends_email_tv));
      paramViewGroup.mYg = ((CheckBox)localView.findViewById(a.c.inviteqqfriends_send_cb));
      paramViewGroup.mYf = ((TextView)localView.findViewById(a.c.invite_friends_open_already_state));
      localView.setTag(paramViewGroup);
      if (!((q)((a)h.ag(a.class)).getInviteFriendOpenStg()).aaL(localdck.UserName)) {
        break label386;
      }
      paramViewGroup.mYf.setVisibility(0);
      label286:
      TextView localTextView = paramViewGroup.jbe;
      if (localdck == null) {
        break label477;
      }
      paramView = localdck.Sqe;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label398;
      }
      label314:
      localTextView.setText(paramView);
      localObject = paramViewGroup.mYe;
      if (localdck == null) {
        break label577;
      }
      if (localdck.TtY != 0) {
        break label483;
      }
      paramView = localdck.UserName;
    }
    label386:
    label398:
    label577:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.mYg.setChecked(this.mYc[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      paramViewGroup.mYf.setVisibility(8);
      break label286;
      localObject = localdck.rWI;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label314;
        }
      }
      localObject = new p(localdck.vhf).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label314;
        }
      }
      localObject = localdck.RQx;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label314;
        }
      }
      label477:
      paramView = "";
      break label314;
      label483:
      if (localdck.TtY == 2)
      {
        paramView = localdck.UserName;
      }
      else
      {
        if (localdck.TtY == 1)
        {
          paramView = localdck.UserName;
          if (!Util.isNullOrNil(paramView))
          {
            paramView = paramView.split("@");
            if ((paramView == null) || (paramView.length < 2) || (Util.isNullOrNil(paramView[0])))
            {
              paramView = "";
              continue;
            }
            paramView = "@" + paramView[0];
            continue;
          }
        }
        paramView = "";
      }
    }
  }
  
  public final void yp(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.mYc.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.mYc;
    if (arrayOfBoolean[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      super.notifyDataSetChanged();
      AppMethodBeat.o(131224);
      return;
    }
  }
  
  static final class a
  {
    TextView jbe;
    TextView mYd;
    TextView mYe;
    TextView mYf;
    CheckBox mYg;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */