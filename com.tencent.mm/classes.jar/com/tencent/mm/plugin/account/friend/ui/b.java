package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  private LinkedList<ayz> dTx;
  LinkedList<zn> fhA;
  boolean fhB;
  private boolean[] fhC;
  private final LayoutInflater fhz;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.fhz = paramLayoutInflater;
  }
  
  public final String[] Xq()
  {
    Object localObject = this.fhC;
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
    if (j < this.dTx.size())
    {
      if (this.fhC[j] == 0) {
        break label105;
      }
      localObject[i] = ((ayz)this.dTx.get(j)).hPY;
      i += 1;
    }
    label105:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  public final void a(LinkedList<ayz> paramLinkedList, int paramInt)
  {
    if (paramInt < 0) {
      this.dTx = paramLinkedList;
    }
    for (;;)
    {
      this.fhC = new boolean[this.dTx.size()];
      return;
      this.dTx = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((ayz)paramLinkedList.get(i)).sTj) {
          this.dTx.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.fhB) {
      if (this.fhA != null) {}
    }
    while (this.dTx == null)
    {
      return 0;
      return this.fhA.size();
    }
    return this.dTx.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.fhB) {
      return this.fhA.get(paramInt);
    }
    return this.dTx.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    View localView;
    if (this.fhB)
    {
      localObject = (zn)this.fhA.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.fhz.inflate(a.e.inviteqqfriendsgroup_item, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.fhD = ((TextView)localView.findViewById(a.d.qq_friend_group_name));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.fhD.setText(((zn)localObject).sYM);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    ayz localayz = (ayz)this.dTx.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.fhz.inflate(a.e.inviteqqfriends_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.drB = ((TextView)localView.findViewById(a.d.inviteqqfriends_nickname_tv));
      paramViewGroup.fhE = ((TextView)localView.findViewById(a.d.inviteqqfriends_email_tv));
      paramViewGroup.fhG = ((CheckBox)localView.findViewById(a.d.inviteqqfriends_send_cb));
      paramViewGroup.fhF = ((TextView)localView.findViewById(a.d.invite_friends_open_already_state));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.t(a.class)).getInviteFriendOpenStg()).pQ(localayz.hPY)) {
        break label371;
      }
      paramViewGroup.fhF.setVisibility(0);
      label276:
      TextView localTextView = paramViewGroup.drB;
      if (localayz == null) {
        break label462;
      }
      paramView = localayz.sPt;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label383;
      }
      label304:
      localTextView.setText(paramView);
      localObject = paramViewGroup.fhE;
      if (localayz == null) {
        break label562;
      }
      if (localayz.tmx != 0) {
        break label468;
      }
      paramView = localayz.hPY;
    }
    label562:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.fhG.setChecked(this.fhC[paramInt]);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label371:
      paramViewGroup.fhF.setVisibility(8);
      break label276;
      label383:
      localObject = localayz.hRf;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label304;
        }
      }
      localObject = new o(localayz.jwX).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label304;
        }
      }
      localObject = localayz.sAY;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label304;
        }
      }
      label462:
      paramView = "";
      break label304;
      label468:
      if (localayz.tmx == 2)
      {
        paramView = localayz.hPY;
      }
      else
      {
        if (localayz.tmx == 1)
        {
          paramView = localayz.hPY;
          if (!bk.bl(paramView))
          {
            paramView = paramView.split("@");
            if ((paramView == null) || (paramView.length < 2) || (bk.bl(paramView[0])))
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
  
  public final void kb(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.fhC.length)) {
      return;
    }
    boolean[] arrayOfBoolean = this.fhC;
    if (this.fhC[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      super.notifyDataSetChanged();
      return;
    }
  }
  
  static final class a
  {
    TextView drB;
    TextView fhD;
    TextView fhE;
    TextView fhF;
    CheckBox fhG;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */