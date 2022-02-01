package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.applet.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  public Context context;
  int dlp;
  public List<String[]> jaX;
  private a jdA;
  public com.tencent.mm.ui.applet.b jdB;
  private b.b jdC;
  public LinkedList<buj> jdx;
  private LinkedList<buj> jdy;
  private List<String[]> jdz;
  public int[] pq;
  
  public i(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.jdx = new LinkedList();
    this.jdy = new LinkedList();
    this.jdz = new LinkedList();
    this.dlp = 1;
    this.jdB = new com.tencent.mm.ui.applet.b(new i.1(this));
    this.jdC = null;
    this.context = paramContext;
    this.dlp = paramInt;
    this.jdA = parama;
    this.pq = new int[this.jdx.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(buj parambuj, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.jdy.iterator();
    while (localIterator.hasNext())
    {
      buj localbuj = (buj)localIterator.next();
      if ((localbuj.yhw != null) && (parambuj.yhw != null) && (localbuj.yhw.equals(parambuj.yhw)))
      {
        ad.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.jdy.add(parambuj);
    parambuj = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.jdz.add(new String[] { parambuj, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void JC(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdz.size())
    {
      if (this.pq[i] == 2) {
        localArrayList.add(((String[])this.jdz.get(i))[0]);
      }
      i += 1;
    }
    paramString = new al(paramString, localArrayList);
    com.tencent.mm.kernel.g.aiU().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean aSK()
  {
    if ((this.pq == null) || (this.pq.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.pq.length) {
        break label68;
      }
      j = this.pq[i];
      if (this.dlp != 1) {
        break;
      }
    } while (j == 0);
    while ((this.dlp != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.dlp == 1)
    {
      i = 0;
      if (i < this.pq.length)
      {
        arrayOfInt = this.pq;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.dlp == 2)
    {
      i = 0;
      if (i < this.pq.length)
      {
        arrayOfInt = this.pq;
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
    AppMethodBeat.o(131007);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(131011);
    int i = this.jdx.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((buj)this.jdx.get(paramInt)).hashCode();
    AppMethodBeat.o(131013);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.pq;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.dlp == 1)
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
        if (this.dlp == 2)
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
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(131014);
    if (this.dlp == 1)
    {
      if (this.jdC == null) {
        this.jdC = new b.b()
        {
          public final int aSL()
          {
            AppMethodBeat.i(131001);
            int i = i.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String rn(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i.this.getCount()))
            {
              ad.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = i.this.rm(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((buj)localObject).nDo;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.jdB != null) {
        this.jdB.a(paramInt, this.jdC);
      }
    }
    buj localbuj = (buj)this.jdx.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.dlp == 1)
      {
        paramView = View.inflate(this.context, 2131494006, null);
        localb.jbW = ((TextView)paramView.findViewById(2131302355));
        localb.jdG = ((TextView)paramView.findViewById(2131302348));
        localb.jdH = ((Button)paramView.findViewById(2131302349));
        localb.jdI = ((Button)paramView.findViewById(2131302351));
        localb.jdF = ((ImageView)paramView.findViewById(2131300291));
        localb.jdJ = ((TextView)paramView.findViewById(2131302356));
        localb.jdK = ((TextView)paramView.findViewById(2131302359));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.jdK.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = i.this;
            int i = paramInt;
            if (paramAnonymousView.dlp == 1) {
              paramAnonymousView.pq[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.dlp == 2) {
                paramAnonymousView.pq[i] = 0;
              }
            }
          }
        });
        if (this.dlp != 1) {
          break label514;
        }
        if (bt.isNullOrNil(((String[])this.jdz.get(paramInt))[1])) {
          break label473;
        }
        paramViewGroup.jbW.setText(((String[])this.jdz.get(paramInt))[1]);
        label270:
        paramViewGroup.jdH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            i.this.select(paramInt);
            a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131003);
          }
        });
        a.b.c(paramViewGroup.jdF, localbuj.nDo);
        label298:
        switch (this.pq[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131014);
      return paramView;
      paramViewGroup = localb;
      if (this.dlp != 2) {
        break;
      }
      paramView = View.inflate(this.context, 2131494007, null);
      localb.jbW = ((TextView)paramView.findViewById(2131302355));
      localb.jdG = ((TextView)paramView.findViewById(2131302348));
      localb.jdH = ((Button)paramView.findViewById(2131302349));
      localb.jdI = ((Button)paramView.findViewById(2131302351));
      localb.jdJ = ((TextView)paramView.findViewById(2131302356));
      localb.jdK = ((TextView)paramView.findViewById(2131302359));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label473:
      if (bt.isNullOrNil(localbuj.nEt))
      {
        paramViewGroup.jbW.setText(localbuj.nDo);
        break label270;
      }
      paramViewGroup.jbW.setText(localbuj.nEt);
      break label270;
      label514:
      if (this.dlp != 2) {
        break label298;
      }
      paramViewGroup.jbW.setText(((String[])this.jdz.get(paramInt))[1]);
      paramViewGroup.jdI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          i.this.select(paramInt);
          a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131004);
        }
      });
      break label298;
      paramViewGroup.jdH.setVisibility(8);
      paramViewGroup.jdG.setVisibility(0);
      paramViewGroup.jdJ.setVisibility(0);
      paramViewGroup.jdK.setVisibility(0);
      continue;
      paramViewGroup.jdH.setVisibility(8);
      paramViewGroup.jdG.setVisibility(0);
      paramViewGroup.jdJ.setVisibility(0);
      paramViewGroup.jdK.setVisibility(0);
      continue;
      paramViewGroup.jdH.setVisibility(8);
      paramViewGroup.jdI.setVisibility(8);
      paramViewGroup.jdG.setVisibility(0);
      paramViewGroup.jdJ.setVisibility(0);
      paramViewGroup.jdK.setVisibility(0);
      continue;
      if (this.dlp == 1)
      {
        paramViewGroup.jdG.setVisibility(8);
        paramViewGroup.jdH.setVisibility(0);
        paramViewGroup.jdI.setVisibility(8);
        paramViewGroup.jdJ.setVisibility(8);
        paramViewGroup.jdK.setVisibility(8);
      }
      else if (this.dlp == 2)
      {
        paramViewGroup.jdG.setVisibility(8);
        paramViewGroup.jdH.setVisibility(8);
        paramViewGroup.jdI.setVisibility(0);
        paramViewGroup.jdJ.setVisibility(8);
        paramViewGroup.jdK.setVisibility(8);
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(131008);
    super.notifyDataSetChanged();
    if (this.jdA != null) {
      this.jdA.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final buj rm(int paramInt)
  {
    AppMethodBeat.i(131012);
    buj localbuj = (buj)this.jdx.get(paramInt);
    AppMethodBeat.o(131012);
    return localbuj;
  }
  
  public final void s(LinkedList<buj> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.jdy.clear();
      this.jdx.clear();
      this.jdz.clear();
      Iterator localIterator1 = this.jaX.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          buj localbuj = (buj)localIterator2.next();
          if (this.dlp == 1)
          {
            if (((localbuj.nDG == 1) || (localbuj.nDG == 0)) && (!bt.isNullOrNil(arrayOfString[2])) && (localbuj.yhw.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localbuj, arrayOfString);
            }
          }
          else if ((this.dlp == 2) && (localbuj.nDG == 2) && (!bt.isNullOrNil(arrayOfString[2])) && (localbuj.yhw.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localbuj, arrayOfString);
          }
        }
      }
    }
    this.pq = new int[this.jdy.size()];
    this.jdx.addAll(this.jdy);
    this.jdy.clear();
    AppMethodBeat.o(131009);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.dlp == 1) {
      this.pq[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.dlp == 2) {
        this.pq[paramInt] = 2;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    TextView jbW;
    ImageView jdF;
    TextView jdG;
    Button jdH;
    Button jdI;
    TextView jdJ;
    TextView jdK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */