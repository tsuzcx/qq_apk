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
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<ams> fOc;
  private LinkedList<btd> gKs;
  private final LayoutInflater imq;
  boolean imr;
  private boolean[] ims;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.imq = paramLayoutInflater;
  }
  
  public final void a(LinkedList<btd> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.gKs = paramLinkedList;
    }
    for (;;)
    {
      this.ims = new boolean[this.gKs.size()];
      AppMethodBeat.o(131225);
      return;
      this.gKs = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((btd)paramLinkedList.get(i)).Der) {
          this.gKs.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] aJu()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.ims;
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
    if (j < this.gKs.size())
    {
      if (this.ims[j] == 0) {
        break label115;
      }
      localObject[i] = ((btd)this.gKs.get(j)).mAQ;
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
    if (this.imr)
    {
      if (this.fOc == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.fOc.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.gKs != null)
    {
      i = this.gKs.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.imr)
    {
      localObject = this.fOc.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.gKs.get(paramInt);
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
    if (this.imr)
    {
      localObject = (ams)this.fOc.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.imq.inflate(2131494492, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.imt = ((TextView)localView.findViewById(2131303558));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.imt.setText(((ams)localObject).DnM);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    btd localbtd = (btd)this.gKs.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.imq.inflate(2131494491, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.fsI = ((TextView)localView.findViewById(2131301077));
      paramViewGroup.imu = ((TextView)localView.findViewById(2131301075));
      paramViewGroup.imw = ((CheckBox)localView.findViewById(2131301078));
      paramViewGroup.imv = ((TextView)localView.findViewById(2131301064));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.ad(a.class)).getInviteFriendOpenStg()).Cq(localbtd.mAQ)) {
        break label379;
      }
      paramViewGroup.imv.setVisibility(0);
      label279:
      TextView localTextView = paramViewGroup.fsI;
      if (localbtd == null) {
        break label470;
      }
      paramView = localbtd.Dap;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label391;
      }
      label307:
      localTextView.setText(paramView);
      localObject = paramViewGroup.imu;
      if (localbtd == null) {
        break label570;
      }
      if (localbtd.DFK != 0) {
        break label476;
      }
      paramView = localbtd.mAQ;
    }
    label391:
    label570:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.imw.setChecked(this.ims[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label379:
      paramViewGroup.imv.setVisibility(8);
      break label279;
      localObject = localbtd.mBV;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = new p(localbtd.oXh).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = localbtd.CFx;
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
      if (localbtd.DFK == 2)
      {
        paramView = localbtd.mAQ;
      }
      else
      {
        if (localbtd.DFK == 1)
        {
          paramView = localbtd.mAQ;
          if (!bt.isNullOrNil(paramView))
          {
            paramView = paramView.split("@");
            if ((paramView == null) || (paramView.length < 2) || (bt.isNullOrNil(paramView[0])))
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
  
  public final void qf(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.ims.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.ims;
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
    TextView fsI;
    TextView imt;
    TextView imu;
    TextView imv;
    CheckBox imw;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */