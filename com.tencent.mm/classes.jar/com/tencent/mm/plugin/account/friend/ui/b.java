package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<apv> fRN;
  private LinkedList<bxu> hkS;
  private final LayoutInflater iMw;
  boolean iMx;
  private boolean[] iMy;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.iMw = paramLayoutInflater;
  }
  
  public final void a(LinkedList<bxu> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.hkS = paramLinkedList;
    }
    for (;;)
    {
      this.iMy = new boolean[this.hkS.size()];
      AppMethodBeat.o(131225);
      return;
      this.hkS = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((bxu)paramLinkedList.get(i)).Exx) {
          this.hkS.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] aQl()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.iMy;
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
    if (j < this.hkS.size())
    {
      if (this.iMy[j] == 0) {
        break label115;
      }
      localObject[i] = ((bxu)this.hkS.get(j)).ncR;
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
    if (this.iMx)
    {
      if (this.fRN == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.fRN.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.hkS != null)
    {
      i = this.hkS.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.iMx)
    {
      localObject = this.fRN.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.hkS.get(paramInt);
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
    if (this.iMx)
    {
      localObject = (apv)this.fRN.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.iMw.inflate(2131494492, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.iMz = ((TextView)localView.findViewById(2131303558));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.iMz.setText(((apv)localObject).EIM);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    bxu localbxu = (bxu)this.hkS.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.iMw.inflate(2131494491, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.fwp = ((TextView)localView.findViewById(2131301077));
      paramViewGroup.iMA = ((TextView)localView.findViewById(2131301075));
      paramViewGroup.iMC = ((CheckBox)localView.findViewById(2131301078));
      paramViewGroup.iMB = ((TextView)localView.findViewById(2131301064));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.ad(a.class)).getInviteFriendOpenStg()).Gt(localbxu.ncR)) {
        break label379;
      }
      paramViewGroup.iMB.setVisibility(0);
      label279:
      TextView localTextView = paramViewGroup.fwp;
      if (localbxu == null) {
        break label470;
      }
      paramView = localbxu.Etm;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label391;
      }
      label307:
      localTextView.setText(paramView);
      localObject = paramViewGroup.iMA;
      if (localbxu == null) {
        break label570;
      }
      if (localbxu.Fbe != 0) {
        break label476;
      }
      paramView = localbxu.ncR;
    }
    label391:
    label570:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.iMC.setChecked(this.iMy[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label379:
      paramViewGroup.iMB.setVisibility(8);
      break label279;
      localObject = localbxu.ndW;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = new p(localbxu.pAs).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = localbxu.DXX;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      label470:
      paramView = "";
      break label307;
      label476:
      if (localbxu.Fbe == 2)
      {
        paramView = localbxu.ncR;
      }
      else
      {
        if (localbxu.Fbe == 1)
        {
          paramView = localbxu.ncR;
          if (!bs.isNullOrNil(paramView))
          {
            paramView = paramView.split("@");
            if ((paramView == null) || (paramView.length < 2) || (bs.isNullOrNil(paramView[0])))
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
  
  public final void qS(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.iMy.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.iMy;
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
    TextView fwp;
    TextView iMA;
    TextView iMB;
    CheckBox iMC;
    TextView iMz;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */