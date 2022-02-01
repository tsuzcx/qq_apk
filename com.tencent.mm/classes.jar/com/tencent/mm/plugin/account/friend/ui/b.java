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
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<bfo> gYE;
  private LinkedList<ctl> iAd;
  private final LayoutInflater kgB;
  boolean kgC;
  private boolean[] kgD;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.kgB = paramLayoutInflater;
  }
  
  public final void a(LinkedList<ctl> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.iAd = paramLinkedList;
    }
    for (;;)
    {
      this.kgD = new boolean[this.iAd.size()];
      AppMethodBeat.o(131225);
      return;
      this.iAd = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((ctl)paramLinkedList.get(i)).Ltr) {
          this.iAd.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] boI()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.kgD;
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
    if (j < this.iAd.size())
    {
      if (this.kgD[j] == 0) {
        break label115;
      }
      localObject[i] = ((ctl)this.iAd.get(j)).UserName;
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
    if (this.kgC)
    {
      if (this.gYE == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.gYE.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.iAd != null)
    {
      i = this.iAd.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.kgC)
    {
      localObject = this.gYE.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.iAd.get(paramInt);
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
    if (this.kgC)
    {
      localObject = (bfo)this.gYE.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.kgB.inflate(2131495084, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.kgE = ((TextView)localView.findViewById(2131306333));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.kgE.setText(((bfo)localObject).LPg);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    ctl localctl = (ctl)this.iAd.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.kgB.inflate(2131495083, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.gwR = ((TextView)localView.findViewById(2131302731));
      paramViewGroup.kgF = ((TextView)localView.findViewById(2131302729));
      paramViewGroup.kgH = ((CheckBox)localView.findViewById(2131302732));
      paramViewGroup.kgG = ((TextView)localView.findViewById(2131302718));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.ah(a.class)).getInviteFriendOpenStg()).Tf(localctl.UserName)) {
        break label379;
      }
      paramViewGroup.kgG.setVisibility(0);
      label279:
      TextView localTextView = paramViewGroup.gwR;
      if (localctl == null) {
        break label470;
      }
      paramView = localctl.LoI;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label391;
      }
      label307:
      localTextView.setText(paramView);
      localObject = paramViewGroup.kgF;
      if (localctl == null) {
        break label570;
      }
      if (localctl.Mjk != 0) {
        break label476;
      }
      paramView = localctl.UserName;
    }
    label391:
    label570:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.kgH.setChecked(this.kgD[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label379:
      paramViewGroup.kgG.setVisibility(8);
      break label279;
      localObject = localctl.oUJ;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = new p(localctl.rBx).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = localctl.KPz;
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
      if (localctl.Mjk == 2)
      {
        paramView = localctl.UserName;
      }
      else
      {
        if (localctl.Mjk == 1)
        {
          paramView = localctl.UserName;
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
  
  public final void vl(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.kgD.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.kgD;
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
    TextView gwR;
    TextView kgE;
    TextView kgF;
    TextView kgG;
    CheckBox kgH;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */