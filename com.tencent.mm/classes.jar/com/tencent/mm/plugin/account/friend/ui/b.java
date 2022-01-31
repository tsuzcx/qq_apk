package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  private final LayoutInflater exe;
  private LinkedList<bgc> fjy;
  LinkedList<aee> gzh;
  boolean gzi;
  private boolean[] gzj;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.exe = paramLayoutInflater;
  }
  
  public final void a(LinkedList<bgc> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(108564);
    if (paramInt < 0) {
      this.fjy = paramLinkedList;
    }
    for (;;)
    {
      this.gzj = new boolean[this.fjy.size()];
      AppMethodBeat.o(108564);
      return;
      this.fjy = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((bgc)paramLinkedList.get(i)).wRe) {
          this.fjy.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] aqU()
  {
    AppMethodBeat.i(108565);
    Object localObject = this.gzj;
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
    if (j < this.fjy.size())
    {
      if (this.gzj[j] == 0) {
        break label115;
      }
      localObject[i] = ((bgc)this.fjy.get(j)).jJA;
      i += 1;
    }
    label115:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(108565);
      return localObject;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108566);
    int i;
    if (this.gzi)
    {
      if (this.gzh == null)
      {
        AppMethodBeat.o(108566);
        return 0;
      }
      i = this.gzh.size();
      AppMethodBeat.o(108566);
      return i;
    }
    if (this.fjy != null)
    {
      i = this.fjy.size();
      AppMethodBeat.o(108566);
      return i;
    }
    AppMethodBeat.o(108566);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(108567);
    if (this.gzi)
    {
      localObject = this.gzh.get(paramInt);
      AppMethodBeat.o(108567);
      return localObject;
    }
    Object localObject = this.fjy.get(paramInt);
    AppMethodBeat.o(108567);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108568);
    Object localObject;
    View localView;
    if (this.gzi)
    {
      localObject = (aee)this.gzh.get(paramInt);
      if ((paramView == null) || (((b.a)paramView.getTag()).type != 2))
      {
        localView = this.exe.inflate(2130969914, paramViewGroup, false);
        paramView = new b.a();
        paramView.type = 2;
        paramView.gzk = ((TextView)localView.findViewById(2131825160));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.gzk.setText(((aee)localObject).wXb);
        AppMethodBeat.o(108568);
        return localView;
        paramViewGroup = (b.a)paramView.getTag();
        localView = paramView;
      }
    }
    bgc localbgc = (bgc)this.fjy.get(paramInt);
    if ((paramView == null) || (((b.a)paramView.getTag()).type != 1))
    {
      localView = this.exe.inflate(2130969913, paramViewGroup, false);
      paramViewGroup = new b.a();
      paramViewGroup.type = 1;
      paramViewGroup.ejj = ((TextView)localView.findViewById(2131825158));
      paramViewGroup.gzl = ((TextView)localView.findViewById(2131825159));
      paramViewGroup.gzn = ((CheckBox)localView.findViewById(2131823963));
      paramViewGroup.gzm = ((TextView)localView.findViewById(2131823962));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.G(a.class)).getInviteFriendOpenStg()).xm(localbgc.jJA)) {
        break label379;
      }
      paramViewGroup.gzm.setVisibility(0);
      label279:
      TextView localTextView = paramViewGroup.ejj;
      if (localbgc == null) {
        break label470;
      }
      paramView = localbgc.wNM;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label391;
      }
      label307:
      localTextView.setText(paramView);
      localObject = paramViewGroup.gzl;
      if (localbgc == null) {
        break label570;
      }
      if (localbgc.xmj != 0) {
        break label476;
      }
      paramView = localbgc.jJA;
    }
    label391:
    label570:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.gzn.setChecked(this.gzj[paramInt]);
      AppMethodBeat.o(108568);
      return localView;
      paramViewGroup = (b.a)paramView.getTag();
      localView = paramView;
      break;
      label379:
      paramViewGroup.gzm.setVisibility(8);
      break label279;
      localObject = localbgc.jKG;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = new p(localbgc.lGw).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = localbgc.wvs;
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
      if (localbgc.xmj == 2)
      {
        paramView = localbgc.jJA;
      }
      else
      {
        if (localbgc.xmj == 1)
        {
          paramView = localbgc.jJA;
          if (!bo.isNullOrNil(paramView))
          {
            paramView = paramView.split("@");
            if ((paramView == null) || (paramView.length < 2) || (bo.isNullOrNil(paramView[0])))
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
  
  public final void mW(int paramInt)
  {
    AppMethodBeat.i(108563);
    if ((paramInt < 0) || (paramInt >= this.gzj.length))
    {
      AppMethodBeat.o(108563);
      return;
    }
    boolean[] arrayOfBoolean = this.gzj;
    if (arrayOfBoolean[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      super.notifyDataSetChanged();
      AppMethodBeat.o(108563);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */