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
import com.tencent.mm.plugin.account.friend.model.n;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<caj> miW;
  private LinkedList<duc> nUC;
  private final LayoutInflater pUI;
  boolean pUJ;
  private boolean[] pUK;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.pUI = paramLayoutInflater;
  }
  
  public final void a(LinkedList<duc> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.nUC = paramLinkedList;
    }
    for (;;)
    {
      this.pUK = new boolean[this.nUC.size()];
      AppMethodBeat.o(131225);
      return;
      this.nUC = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((duc)paramLinkedList.get(i)).ZvY) {
          this.nUC.add((duc)paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] bXF()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.pUK;
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
    if (j < this.nUC.size())
    {
      if (this.pUK[j] == 0) {
        break label115;
      }
      localObject[i] = ((duc)this.nUC.get(j)).UserName;
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
    if (this.pUJ)
    {
      if (this.miW == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.miW.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.nUC != null)
    {
      i = this.nUC.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.pUJ)
    {
      localObject = this.miW.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.nUC.get(paramInt);
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
    if (this.pUJ)
    {
      localObject = (caj)this.miW.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.pUI.inflate(a.d.inviteqqfriendsgroup_item, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.pUL = ((TextView)localView.findViewById(a.c.qq_friend_group_name));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.pUL.setText(((caj)localObject).aajr);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    duc localduc = (duc)this.nUC.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.pUI.inflate(a.d.inviteqqfriends_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.lDe = ((TextView)localView.findViewById(a.c.inviteqqfriends_nickname_tv));
      paramViewGroup.pUM = ((TextView)localView.findViewById(a.c.inviteqqfriends_email_tv));
      paramViewGroup.pUO = ((CheckBox)localView.findViewById(a.c.inviteqqfriends_send_cb));
      paramViewGroup.pUN = ((TextView)localView.findViewById(a.c.invite_friends_open_already_state));
      localView.setTag(paramViewGroup);
      if (!((n)((a)h.az(a.class)).getInviteFriendOpenStg()).Te(localduc.UserName)) {
        break label386;
      }
      paramViewGroup.pUN.setVisibility(0);
      label286:
      TextView localTextView = paramViewGroup.lDe;
      if (localduc == null) {
        break label477;
      }
      paramView = localduc.Zpa;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label398;
      }
      label314:
      localTextView.setText(paramView);
      localObject = paramViewGroup.pUM;
      if (localduc == null) {
        break label577;
      }
      if (localduc.aaIA != 0) {
        break label483;
      }
      paramView = localduc.UserName;
    }
    label386:
    label398:
    label577:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.pUO.setChecked(this.pUK[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      paramViewGroup.pUN.setVisibility(8);
      break label286;
      localObject = localduc.vhX;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label314;
        }
      }
      localObject = new p(localduc.yth).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label314;
        }
      }
      localObject = localduc.YNN;
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
      if (localduc.aaIA == 2)
      {
        paramView = localduc.UserName;
      }
      else
      {
        if (localduc.aaIA == 1)
        {
          paramView = localduc.UserName;
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
  
  public final void yv(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.pUK.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.pUK;
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
    TextView lDe;
    TextView pUL;
    TextView pUM;
    TextView pUN;
    CheckBox pUO;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */