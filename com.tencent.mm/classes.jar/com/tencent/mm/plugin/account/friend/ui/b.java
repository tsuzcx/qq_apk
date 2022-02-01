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
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<auf> gnJ;
  private LinkedList<cdf> hFT;
  boolean jiA;
  private boolean[] jiB;
  private final LayoutInflater jiz;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.jiz = paramLayoutInflater;
  }
  
  public final void a(LinkedList<cdf> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.hFT = paramLinkedList;
    }
    for (;;)
    {
      this.jiB = new boolean[this.hFT.size()];
      AppMethodBeat.o(131225);
      return;
      this.hFT = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((cdf)paramLinkedList.get(i)).GxI) {
          this.hFT.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] aTW()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.jiB;
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
    if (j < this.hFT.size())
    {
      if (this.jiB[j] == 0) {
        break label115;
      }
      localObject[i] = ((cdf)this.hFT.get(j)).nIJ;
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
    if (this.jiA)
    {
      if (this.gnJ == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.gnJ.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.hFT != null)
    {
      i = this.hFT.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.jiA)
    {
      localObject = this.gnJ.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.hFT.get(paramInt);
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
    if (this.jiA)
    {
      localObject = (auf)this.gnJ.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.jiz.inflate(2131494492, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.jiC = ((TextView)localView.findViewById(2131303558));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.jiC.setText(((auf)localObject).GLc);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    cdf localcdf = (cdf)this.hFT.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.jiz.inflate(2131494491, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.fRI = ((TextView)localView.findViewById(2131301077));
      paramViewGroup.jiD = ((TextView)localView.findViewById(2131301075));
      paramViewGroup.jiF = ((CheckBox)localView.findViewById(2131301078));
      paramViewGroup.jiE = ((TextView)localView.findViewById(2131301064));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.ad(a.class)).getInviteFriendOpenStg()).Kh(localcdf.nIJ)) {
        break label379;
      }
      paramViewGroup.jiE.setVisibility(0);
      label279:
      TextView localTextView = paramViewGroup.fRI;
      if (localcdf == null) {
        break label470;
      }
      paramView = localcdf.Gtk;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label391;
      }
      label307:
      localTextView.setText(paramView);
      localObject = paramViewGroup.jiD;
      if (localcdf == null) {
        break label570;
      }
      if (localcdf.Hee != 0) {
        break label476;
      }
      paramView = localcdf.nIJ;
    }
    label391:
    label570:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.jiF.setChecked(this.jiB[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label379:
      paramViewGroup.jiE.setVisibility(8);
      break label279;
      localObject = localcdf.nJO;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = new p(localcdf.qkC).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = localcdf.FVO;
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
      if (localcdf.Hee == 2)
      {
        paramView = localcdf.nIJ;
      }
      else
      {
        if (localcdf.Hee == 1)
        {
          paramView = localcdf.nIJ;
          if (!bu.isNullOrNil(paramView))
          {
            paramView = paramView.split("@");
            if ((paramView == null) || (paramView.length < 2) || (bu.isNullOrNil(paramView[0])))
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
  
  public final void rv(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.jiB.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.jiB;
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
    TextView fRI;
    TextView jiC;
    TextView jiD;
    TextView jiE;
    CheckBox jiF;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */