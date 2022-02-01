package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  public Context context;
  int dmr;
  public List<String[]> jdQ;
  public LinkedList<bvd> jgq;
  private LinkedList<bvd> jgr;
  private List<String[]> jgs;
  private a jgt;
  public com.tencent.mm.ui.applet.b jgu;
  private b.b jgv;
  public int[] pq;
  
  public i(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.jgq = new LinkedList();
    this.jgr = new LinkedList();
    this.jgs = new LinkedList();
    this.dmr = 1;
    this.jgu = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Kc(String paramAnonymousString)
      {
        AppMethodBeat.i(130999);
        paramAnonymousString = c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(130999);
        return paramAnonymousString;
      }
    });
    this.jgv = null;
    this.context = paramContext;
    this.dmr = paramInt;
    this.jgt = parama;
    this.pq = new int[this.jgq.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(bvd parambvd, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.jgr.iterator();
    while (localIterator.hasNext())
    {
      bvd localbvd = (bvd)localIterator.next();
      if ((localbvd.yxn != null) && (parambvd.yxn != null) && (localbvd.yxn.equals(parambvd.yxn)))
      {
        ae.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.jgr.add(parambvd);
    parambvd = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.jgs.add(new String[] { parambvd, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void Kb(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jgs.size())
    {
      if (this.pq[i] == 2) {
        localArrayList.add(((String[])this.jgs.get(i))[0]);
      }
      i += 1;
    }
    paramString = new al(paramString, localArrayList);
    com.tencent.mm.kernel.g.ajj().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean aTj()
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
      if (this.dmr != 1) {
        break;
      }
    } while (j == 0);
    while ((this.dmr != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final void fr(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.dmr == 1)
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
    else if (this.dmr == 2)
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
    int i = this.jgq.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((bvd)this.jgq.get(paramInt)).hashCode();
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
      if (this.dmr == 1)
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
        if (this.dmr == 2)
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
    if (this.dmr == 1)
    {
      if (this.jgv == null) {
        this.jgv = new b.b()
        {
          public final int aTk()
          {
            AppMethodBeat.i(131001);
            int i = i.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String rq(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i.this.getCount()))
            {
              ae.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = i.this.rp(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((bvd)localObject).nIJ;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.jgu != null) {
        this.jgu.a(paramInt, this.jgv);
      }
    }
    bvd localbvd = (bvd)this.jgq.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.dmr == 1)
      {
        paramView = View.inflate(this.context, 2131494006, null);
        localb.jeP = ((TextView)paramView.findViewById(2131302355));
        localb.jgz = ((TextView)paramView.findViewById(2131302348));
        localb.jgA = ((Button)paramView.findViewById(2131302349));
        localb.jgB = ((Button)paramView.findViewById(2131302351));
        localb.jgy = ((ImageView)paramView.findViewById(2131300291));
        localb.jgC = ((TextView)paramView.findViewById(2131302356));
        localb.jgD = ((TextView)paramView.findViewById(2131302359));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.jgD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = i.this;
            int i = paramInt;
            if (paramAnonymousView.dmr == 1) {
              paramAnonymousView.pq[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.dmr == 2) {
                paramAnonymousView.pq[i] = 0;
              }
            }
          }
        });
        if (this.dmr != 1) {
          break label514;
        }
        if (bu.isNullOrNil(((String[])this.jgs.get(paramInt))[1])) {
          break label473;
        }
        paramViewGroup.jeP.setText(((String[])this.jgs.get(paramInt))[1]);
        label270:
        paramViewGroup.jgA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            i.this.select(paramInt);
            a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131003);
          }
        });
        a.b.c(paramViewGroup.jgy, localbvd.nIJ);
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
      if (this.dmr != 2) {
        break;
      }
      paramView = View.inflate(this.context, 2131494007, null);
      localb.jeP = ((TextView)paramView.findViewById(2131302355));
      localb.jgz = ((TextView)paramView.findViewById(2131302348));
      localb.jgA = ((Button)paramView.findViewById(2131302349));
      localb.jgB = ((Button)paramView.findViewById(2131302351));
      localb.jgC = ((TextView)paramView.findViewById(2131302356));
      localb.jgD = ((TextView)paramView.findViewById(2131302359));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label473:
      if (bu.isNullOrNil(localbvd.nJO))
      {
        paramViewGroup.jeP.setText(localbvd.nIJ);
        break label270;
      }
      paramViewGroup.jeP.setText(localbvd.nJO);
      break label270;
      label514:
      if (this.dmr != 2) {
        break label298;
      }
      paramViewGroup.jeP.setText(((String[])this.jgs.get(paramInt))[1]);
      paramViewGroup.jgB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          i.this.select(paramInt);
          a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131004);
        }
      });
      break label298;
      paramViewGroup.jgA.setVisibility(8);
      paramViewGroup.jgz.setVisibility(0);
      paramViewGroup.jgC.setVisibility(0);
      paramViewGroup.jgD.setVisibility(0);
      continue;
      paramViewGroup.jgA.setVisibility(8);
      paramViewGroup.jgz.setVisibility(0);
      paramViewGroup.jgC.setVisibility(0);
      paramViewGroup.jgD.setVisibility(0);
      continue;
      paramViewGroup.jgA.setVisibility(8);
      paramViewGroup.jgB.setVisibility(8);
      paramViewGroup.jgz.setVisibility(0);
      paramViewGroup.jgC.setVisibility(0);
      paramViewGroup.jgD.setVisibility(0);
      continue;
      if (this.dmr == 1)
      {
        paramViewGroup.jgz.setVisibility(8);
        paramViewGroup.jgA.setVisibility(0);
        paramViewGroup.jgB.setVisibility(8);
        paramViewGroup.jgC.setVisibility(8);
        paramViewGroup.jgD.setVisibility(8);
      }
      else if (this.dmr == 2)
      {
        paramViewGroup.jgz.setVisibility(8);
        paramViewGroup.jgA.setVisibility(8);
        paramViewGroup.jgB.setVisibility(0);
        paramViewGroup.jgC.setVisibility(8);
        paramViewGroup.jgD.setVisibility(8);
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(131008);
    super.notifyDataSetChanged();
    if (this.jgt != null) {
      this.jgt.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final bvd rp(int paramInt)
  {
    AppMethodBeat.i(131012);
    bvd localbvd = (bvd)this.jgq.get(paramInt);
    AppMethodBeat.o(131012);
    return localbvd;
  }
  
  public final void s(LinkedList<bvd> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.jgr.clear();
      this.jgq.clear();
      this.jgs.clear();
      Iterator localIterator1 = this.jdQ.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          bvd localbvd = (bvd)localIterator2.next();
          if (this.dmr == 1)
          {
            if (((localbvd.nJb == 1) || (localbvd.nJb == 0)) && (!bu.isNullOrNil(arrayOfString[2])) && (localbvd.yxn.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localbvd, arrayOfString);
            }
          }
          else if ((this.dmr == 2) && (localbvd.nJb == 2) && (!bu.isNullOrNil(arrayOfString[2])) && (localbvd.yxn.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localbvd, arrayOfString);
          }
        }
      }
    }
    this.pq = new int[this.jgr.size()];
    this.jgq.addAll(this.jgr);
    this.jgr.clear();
    AppMethodBeat.o(131009);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.dmr == 1) {
      this.pq[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.dmr == 2) {
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
    TextView jeP;
    Button jgA;
    Button jgB;
    TextView jgC;
    TextView jgD;
    ImageView jgy;
    TextView jgz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */