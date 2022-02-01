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
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

final class b
  extends BaseAdapter
{
  LinkedList<atp> glo;
  private LinkedList<ccl> hDb;
  private final LayoutInflater jfG;
  boolean jfH;
  private boolean[] jfI;
  
  public b(LayoutInflater paramLayoutInflater)
  {
    this.jfG = paramLayoutInflater;
  }
  
  public final void a(LinkedList<ccl> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(131225);
    if (paramInt < 0) {
      this.hDb = paramLinkedList;
    }
    for (;;)
    {
      this.jfI = new boolean[this.hDb.size()];
      AppMethodBeat.o(131225);
      return;
      this.hDb = new LinkedList();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        if (paramInt == ((ccl)paramLinkedList.get(i)).Gfa) {
          this.hDb.add(paramLinkedList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public final String[] aTx()
  {
    AppMethodBeat.i(131226);
    Object localObject = this.jfI;
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
    if (j < this.hDb.size())
    {
      if (this.jfI[j] == 0) {
        break label115;
      }
      localObject[i] = ((ccl)this.hDb.get(j)).nDo;
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
    if (this.jfH)
    {
      if (this.glo == null)
      {
        AppMethodBeat.o(131227);
        return 0;
      }
      i = this.glo.size();
      AppMethodBeat.o(131227);
      return i;
    }
    if (this.hDb != null)
    {
      i = this.hDb.size();
      AppMethodBeat.o(131227);
      return i;
    }
    AppMethodBeat.o(131227);
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(131228);
    if (this.jfH)
    {
      localObject = this.glo.get(paramInt);
      AppMethodBeat.o(131228);
      return localObject;
    }
    Object localObject = this.hDb.get(paramInt);
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
    if (this.jfH)
    {
      localObject = (atp)this.glo.get(paramInt);
      if ((paramView == null) || (((a)paramView.getTag()).type != 2))
      {
        localView = this.jfG.inflate(2131494492, paramViewGroup, false);
        paramView = new a();
        paramView.type = 2;
        paramView.jfJ = ((TextView)localView.findViewById(2131303558));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.jfJ.setText(((atp)localObject).GrE);
        AppMethodBeat.o(131229);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    ccl localccl = (ccl)this.hDb.get(paramInt);
    if ((paramView == null) || (((a)paramView.getTag()).type != 1))
    {
      localView = this.jfG.inflate(2131494491, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.type = 1;
      paramViewGroup.fPC = ((TextView)localView.findViewById(2131301077));
      paramViewGroup.jfK = ((TextView)localView.findViewById(2131301075));
      paramViewGroup.jfM = ((CheckBox)localView.findViewById(2131301078));
      paramViewGroup.jfL = ((TextView)localView.findViewById(2131301064));
      localView.setTag(paramViewGroup);
      if (!((q)((a)g.ad(a.class)).getInviteFriendOpenStg()).JI(localccl.nDo)) {
        break label379;
      }
      paramViewGroup.jfL.setVisibility(0);
      label279:
      TextView localTextView = paramViewGroup.fPC;
      if (localccl == null) {
        break label470;
      }
      paramView = localccl.GaD;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label391;
      }
      label307:
      localTextView.setText(paramView);
      localObject = paramViewGroup.jfK;
      if (localccl == null) {
        break label570;
      }
      if (localccl.GKD != 0) {
        break label476;
      }
      paramView = localccl.nDo;
    }
    label391:
    label570:
    for (;;)
    {
      ((TextView)localObject).setText(paramView);
      paramViewGroup.jfM.setChecked(this.jfI[paramInt]);
      AppMethodBeat.o(131229);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label379:
      paramViewGroup.jfL.setVisibility(8);
      break label279;
      localObject = localccl.nEt;
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = new p(localccl.qdX).toString();
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (((String)localObject).length() > 0) {
          break label307;
        }
      }
      localObject = localccl.FDt;
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
      if (localccl.GKD == 2)
      {
        paramView = localccl.nDo;
      }
      else
      {
        if (localccl.GKD == 1)
        {
          paramView = localccl.nDo;
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
  
  public final void rs(int paramInt)
  {
    AppMethodBeat.i(131224);
    if ((paramInt < 0) || (paramInt >= this.jfI.length))
    {
      AppMethodBeat.o(131224);
      return;
    }
    boolean[] arrayOfBoolean = this.jfI;
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
    TextView fPC;
    TextView jfJ;
    TextView jfK;
    TextView jfL;
    CheckBox jfM;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.b
 * JD-Core Version:    0.7.0.1
 */