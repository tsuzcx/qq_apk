package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  private Context context;
  public List<String[]> fcV;
  public int[] fdQ;
  public LinkedList<auc> ffC = new LinkedList();
  private LinkedList<auc> ffD = new LinkedList();
  private List<String[]> ffE = new LinkedList();
  private i.a ffF;
  public b ffG = new b(new i.1(this));
  private b.b ffH = null;
  int showType = 1;
  
  public i(Context paramContext, i.a parama, int paramInt)
  {
    this.context = paramContext;
    this.showType = paramInt;
    this.ffF = parama;
    this.fdQ = new int[this.ffC.size()];
  }
  
  private void a(auc paramauc, String[] paramArrayOfString)
  {
    Iterator localIterator = this.ffD.iterator();
    while (localIterator.hasNext())
    {
      auc localauc = (auc)localIterator.next();
      if ((localauc.nFs != null) && (paramauc.nFs != null) && (localauc.nFs.equals(paramauc.nFs)))
      {
        y.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        return;
      }
    }
    this.ffD.add(paramauc);
    paramauc = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.ffE.add(new String[] { paramauc, paramArrayOfString });
  }
  
  public final boolean WK()
  {
    if ((this.fdQ == null) || (this.fdQ.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.fdQ.length) {
        break label68;
      }
      j = this.fdQ[i];
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
  
  public final void cu(boolean paramBoolean)
  {
    int i;
    int[] arrayOfInt;
    int j;
    if (this.showType == 1)
    {
      i = 0;
      if (i < this.fdQ.length)
      {
        arrayOfInt = this.fdQ;
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
      if (i < this.fdQ.length)
      {
        arrayOfInt = this.fdQ;
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
  }
  
  public final int getCount()
  {
    return this.ffC.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return ((auc)this.ffC.get(paramInt)).hashCode();
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.fdQ;
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
    if (this.showType == 1)
    {
      if (this.ffH == null) {
        this.ffH = new i.2(this);
      }
      if (this.ffG != null) {
        this.ffG.a(paramInt, this.ffH);
      }
    }
    auc localauc = (auc)this.ffC.get(paramInt);
    i.b localb;
    if (paramView == null)
    {
      localb = new i.b();
      if (this.showType == 1)
      {
        paramView = View.inflate(this.context, a.e.find_friend_add_item, null);
        localb.fdY = ((TextView)paramView.findViewById(a.d.mobile_friend_name));
        localb.ffL = ((TextView)paramView.findViewById(a.d.mobile_friend_add_state));
        localb.ffM = ((Button)paramView.findViewById(a.d.mobile_friend_add_tv));
        localb.ffN = ((Button)paramView.findViewById(a.d.mobile_friend_invite_tv));
        localb.ffK = ((ImageView)paramView.findViewById(a.d.friend_avatar_iv));
        localb.ffO = ((TextView)paramView.findViewById(a.d.mobile_friend_selected));
        localb.ffP = ((TextView)paramView.findViewById(a.d.mobile_friend_unselect));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.ffP.setOnClickListener(new i.3(this, paramInt));
        if (this.showType != 1) {
          break label515;
        }
        if (bk.bl(((String[])this.ffE.get(paramInt))[1])) {
          break label474;
        }
        paramViewGroup.fdY.setText(((String[])this.ffE.get(paramInt))[1]);
        label273:
        paramViewGroup.ffM.setOnClickListener(new i.4(this, paramInt));
        a.b.a(paramViewGroup.ffK, localauc.hPY);
        label301:
        switch (this.fdQ[paramInt])
        {
        }
      }
    }
    label474:
    do
    {
      return paramView;
      paramViewGroup = localb;
      if (this.showType != 2) {
        break;
      }
      paramView = View.inflate(this.context, a.e.find_friend_item, null);
      localb.fdY = ((TextView)paramView.findViewById(a.d.mobile_friend_name));
      localb.ffL = ((TextView)paramView.findViewById(a.d.mobile_friend_add_state));
      localb.ffM = ((Button)paramView.findViewById(a.d.mobile_friend_add_tv));
      localb.ffN = ((Button)paramView.findViewById(a.d.mobile_friend_invite_tv));
      localb.ffO = ((TextView)paramView.findViewById(a.d.mobile_friend_selected));
      localb.ffP = ((TextView)paramView.findViewById(a.d.mobile_friend_unselect));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (i.b)paramView.getTag();
      break;
      if (bk.bl(localauc.hRf))
      {
        paramViewGroup.fdY.setText(localauc.hPY);
        break label273;
      }
      paramViewGroup.fdY.setText(localauc.hRf);
      break label273;
      if (this.showType != 2) {
        break label301;
      }
      paramViewGroup.fdY.setText(((String[])this.ffE.get(paramInt))[1]);
      paramViewGroup.ffN.setOnClickListener(new i.5(this, paramInt));
      break label301;
      paramViewGroup.ffM.setVisibility(8);
      paramViewGroup.ffL.setVisibility(0);
      paramViewGroup.ffO.setVisibility(0);
      paramViewGroup.ffP.setVisibility(0);
      return paramView;
      paramViewGroup.ffM.setVisibility(8);
      paramViewGroup.ffL.setVisibility(0);
      paramViewGroup.ffO.setVisibility(0);
      paramViewGroup.ffP.setVisibility(0);
      return paramView;
      paramViewGroup.ffM.setVisibility(8);
      paramViewGroup.ffN.setVisibility(8);
      paramViewGroup.ffL.setVisibility(0);
      paramViewGroup.ffO.setVisibility(0);
      paramViewGroup.ffP.setVisibility(0);
      return paramView;
      if (this.showType == 1)
      {
        paramViewGroup.ffL.setVisibility(8);
        paramViewGroup.ffM.setVisibility(0);
        paramViewGroup.ffN.setVisibility(8);
        paramViewGroup.ffO.setVisibility(8);
        paramViewGroup.ffP.setVisibility(8);
        return paramView;
      }
    } while (this.showType != 2);
    label515:
    paramViewGroup.ffL.setVisibility(8);
    paramViewGroup.ffM.setVisibility(8);
    paramViewGroup.ffN.setVisibility(0);
    paramViewGroup.ffO.setVisibility(8);
    paramViewGroup.ffP.setVisibility(8);
    return paramView;
  }
  
  public final void jV(int paramInt)
  {
    if (this.showType == 1) {
      this.fdQ[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      if (this.showType == 2) {
        this.fdQ[paramInt] = 2;
      }
    }
  }
  
  public final auc jW(int paramInt)
  {
    return (auc)this.ffC.get(paramInt);
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (this.ffF != null) {
      this.ffF.notifyDataSetChanged();
    }
  }
  
  public final void pL(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ffE.size())
    {
      if (this.fdQ[i] == 2) {
        localArrayList.add(((String[])this.ffE.get(i))[0]);
      }
      i += 1;
    }
    paramString = new ai(paramString, localArrayList);
    com.tencent.mm.kernel.g.Dk().a(paramString, 0);
  }
  
  public final void r(LinkedList<auc> paramLinkedList)
  {
    if (paramLinkedList != null)
    {
      this.ffD.clear();
      this.ffC.clear();
      this.ffE.clear();
      Iterator localIterator1 = this.fcV.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          auc localauc = (auc)localIterator2.next();
          if (this.showType == 1)
          {
            if (((localauc.hQq == 1) || (localauc.hQq == 0)) && (!bk.bl(arrayOfString[2])) && (localauc.nFs.equals(com.tencent.mm.a.g.o(arrayOfString[2].getBytes())))) {
              a(localauc, arrayOfString);
            }
          }
          else if ((this.showType == 2) && (localauc.hQq == 2) && (!bk.bl(arrayOfString[2])) && (localauc.nFs.equals(com.tencent.mm.a.g.o(arrayOfString[2].getBytes())))) {
            a(localauc, arrayOfString);
          }
        }
      }
    }
    this.fdQ = new int[this.ffD.size()];
    this.ffC.addAll(this.ffD);
    this.ffD.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */