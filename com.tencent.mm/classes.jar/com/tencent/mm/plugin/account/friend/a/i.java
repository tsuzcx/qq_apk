package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  public Context context;
  public List<String[]> guG;
  public int[] gvA;
  public LinkedList<bai> gxk;
  private LinkedList<bai> gxl;
  private List<String[]> gxm;
  private i.a gxn;
  public b gxo;
  private b.b gxp;
  int showType;
  
  public i(Context paramContext, i.a parama, int paramInt)
  {
    AppMethodBeat.i(108344);
    this.gxk = new LinkedList();
    this.gxl = new LinkedList();
    this.gxm = new LinkedList();
    this.showType = 1;
    this.gxo = new b(new i.1(this));
    this.gxp = null;
    this.context = paramContext;
    this.showType = paramInt;
    this.gxn = parama;
    this.gvA = new int[this.gxk.size()];
    AppMethodBeat.o(108344);
  }
  
  private void a(bai parambai, String[] paramArrayOfString)
  {
    AppMethodBeat.i(108349);
    Iterator localIterator = this.gxl.iterator();
    while (localIterator.hasNext())
    {
      bai localbai = (bai)localIterator.next();
      if ((localbai.qsu != null) && (parambai.qsu != null) && (localbai.qsu.equals(parambai.qsu)))
      {
        ab.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(108349);
        return;
      }
    }
    this.gxl.add(parambai);
    parambai = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.gxm.add(new String[] { parambai, paramArrayOfString });
    AppMethodBeat.o(108349);
  }
  
  public final boolean aqm()
  {
    if ((this.gvA == null) || (this.gvA.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.gvA.length) {
        break label68;
      }
      j = this.gvA[i];
      if (this.showType != 1) {
        break;
      }
    } while (j == 0);
    while ((this.showType != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final void dw(boolean paramBoolean)
  {
    AppMethodBeat.i(108346);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.showType == 1)
    {
      i = 0;
      if (i < this.gvA.length)
      {
        arrayOfInt = this.gvA;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.showType == 2)
    {
      i = 0;
      if (i < this.gvA.length)
      {
        arrayOfInt = this.gvA;
        if (paramBoolean) {}
        for (j = 2;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(108346);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108350);
    int i = this.gxk.size();
    AppMethodBeat.o(108350);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(108352);
    long l = ((bai)this.gxk.get(paramInt)).hashCode();
    AppMethodBeat.o(108352);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.gvA;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.showType == 1)
      {
        i = k;
        if (n == 1) {
          i = k + 1;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (this.showType == 2)
        {
          i = k;
          if (n == 2) {
            i = k + 1;
          }
        }
      }
    }
    return k;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108353);
    if (this.showType == 1)
    {
      if (this.gxp == null) {
        this.gxp = new i.2(this);
      }
      if (this.gxo != null) {
        this.gxo.a(paramInt, this.gxp);
      }
    }
    bai localbai = (bai)this.gxk.get(paramInt);
    i.b localb;
    if (paramView == null)
    {
      localb = new i.b();
      if (this.showType == 1)
      {
        paramView = View.inflate(this.context, 2130969583, null);
        localb.gvI = ((TextView)paramView.findViewById(2131824136));
        localb.gxt = ((TextView)paramView.findViewById(2131824141));
        localb.gxu = ((Button)paramView.findViewById(2131824139));
        localb.gxv = ((Button)paramView.findViewById(2131824140));
        localb.gxs = ((ImageView)paramView.findViewById(2131824135));
        localb.gxw = ((TextView)paramView.findViewById(2131824137));
        localb.gxx = ((TextView)paramView.findViewById(2131824138));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.gxx.setOnClickListener(new i.3(this, paramInt));
        if (this.showType != 1) {
          break label513;
        }
        if (bo.isNullOrNil(((String[])this.gxm.get(paramInt))[1])) {
          break label472;
        }
        paramViewGroup.gvI.setText(((String[])this.gxm.get(paramInt))[1]);
        label270:
        paramViewGroup.gxu.setOnClickListener(new i.4(this, paramInt));
        a.b.c(paramViewGroup.gxs, localbai.jJA);
        label298:
        switch (this.gvA[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(108353);
      return paramView;
      paramViewGroup = localb;
      if (this.showType != 2) {
        break;
      }
      paramView = View.inflate(this.context, 2130969584, null);
      localb.gvI = ((TextView)paramView.findViewById(2131824136));
      localb.gxt = ((TextView)paramView.findViewById(2131824141));
      localb.gxu = ((Button)paramView.findViewById(2131824139));
      localb.gxv = ((Button)paramView.findViewById(2131824140));
      localb.gxw = ((TextView)paramView.findViewById(2131824137));
      localb.gxx = ((TextView)paramView.findViewById(2131824138));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (i.b)paramView.getTag();
      break;
      label472:
      if (bo.isNullOrNil(localbai.jKG))
      {
        paramViewGroup.gvI.setText(localbai.jJA);
        break label270;
      }
      paramViewGroup.gvI.setText(localbai.jKG);
      break label270;
      label513:
      if (this.showType != 2) {
        break label298;
      }
      paramViewGroup.gvI.setText(((String[])this.gxm.get(paramInt))[1]);
      paramViewGroup.gxv.setOnClickListener(new i.5(this, paramInt));
      break label298;
      paramViewGroup.gxu.setVisibility(8);
      paramViewGroup.gxt.setVisibility(0);
      paramViewGroup.gxw.setVisibility(0);
      paramViewGroup.gxx.setVisibility(0);
      continue;
      paramViewGroup.gxu.setVisibility(8);
      paramViewGroup.gxt.setVisibility(0);
      paramViewGroup.gxw.setVisibility(0);
      paramViewGroup.gxx.setVisibility(0);
      continue;
      paramViewGroup.gxu.setVisibility(8);
      paramViewGroup.gxv.setVisibility(8);
      paramViewGroup.gxt.setVisibility(0);
      paramViewGroup.gxw.setVisibility(0);
      paramViewGroup.gxx.setVisibility(0);
      continue;
      if (this.showType == 1)
      {
        paramViewGroup.gxt.setVisibility(8);
        paramViewGroup.gxu.setVisibility(0);
        paramViewGroup.gxv.setVisibility(8);
        paramViewGroup.gxw.setVisibility(8);
        paramViewGroup.gxx.setVisibility(8);
      }
      else if (this.showType == 2)
      {
        paramViewGroup.gxt.setVisibility(8);
        paramViewGroup.gxu.setVisibility(8);
        paramViewGroup.gxv.setVisibility(0);
        paramViewGroup.gxw.setVisibility(8);
        paramViewGroup.gxx.setVisibility(8);
      }
    }
  }
  
  public final bai mR(int paramInt)
  {
    AppMethodBeat.i(108351);
    bai localbai = (bai)this.gxk.get(paramInt);
    AppMethodBeat.o(108351);
    return localbai;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108347);
    super.notifyDataSetChanged();
    if (this.gxn != null) {
      this.gxn.notifyDataSetChanged();
    }
    AppMethodBeat.o(108347);
  }
  
  public final void r(LinkedList<bai> paramLinkedList)
  {
    AppMethodBeat.i(108348);
    if (paramLinkedList != null)
    {
      this.gxl.clear();
      this.gxk.clear();
      this.gxm.clear();
      Iterator localIterator1 = this.guG.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          bai localbai = (bai)localIterator2.next();
          if (this.showType == 1)
          {
            if (((localbai.jJS == 1) || (localbai.jJS == 0)) && (!bo.isNullOrNil(arrayOfString[2])) && (localbai.qsu.equals(com.tencent.mm.a.g.w(arrayOfString[2].getBytes())))) {
              a(localbai, arrayOfString);
            }
          }
          else if ((this.showType == 2) && (localbai.jJS == 2) && (!bo.isNullOrNil(arrayOfString[2])) && (localbai.qsu.equals(com.tencent.mm.a.g.w(arrayOfString[2].getBytes())))) {
            a(localbai, arrayOfString);
          }
        }
      }
    }
    this.gvA = new int[this.gxl.size()];
    this.gxk.addAll(this.gxl);
    this.gxl.clear();
    AppMethodBeat.o(108348);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(108345);
    if (this.showType == 1) {
      this.gvA[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(108345);
      return;
      if (this.showType == 2) {
        this.gvA[paramInt] = 2;
      }
    }
  }
  
  public final void xg(String paramString)
  {
    AppMethodBeat.i(108354);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.gxm.size())
    {
      if (this.gvA[i] == 2) {
        localArrayList.add(((String[])this.gxm.get(i))[0]);
      }
      i += 1;
    }
    paramString = new ai(paramString, localArrayList);
    com.tencent.mm.kernel.g.Rc().a(paramString, 0);
    AppMethodBeat.o(108354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */