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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  int dcz;
  public List<String[]> ihG;
  public LinkedList<bly> ikh;
  private LinkedList<bly> iki;
  private List<String[]> ikj;
  private a ikk;
  public b ikl;
  private b.b ikm;
  public int[] mv;
  
  public i(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.ikh = new LinkedList();
    this.iki = new LinkedList();
    this.ikj = new LinkedList();
    this.dcz = 1;
    this.ikl = new b(new i.1(this));
    this.ikm = null;
    this.context = paramContext;
    this.dcz = paramInt;
    this.ikk = parama;
    this.mv = new int[this.ikh.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(bly parambly, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.iki.iterator();
    while (localIterator.hasNext())
    {
      bly localbly = (bly)localIterator.next();
      if ((localbly.vJI != null) && (parambly.vJI != null) && (localbly.vJI.equals(parambly.vJI)))
      {
        ad.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.iki.add(parambly);
    parambly = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.ikj.add(new String[] { parambly, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void Ck(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ikj.size())
    {
      if (this.mv[i] == 2) {
        localArrayList.add(((String[])this.ikj.get(i))[0]);
      }
      i += 1;
    }
    paramString = new al(paramString, localArrayList);
    com.tencent.mm.kernel.g.aeS().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean aIH()
  {
    if ((this.mv == null) || (this.mv.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.mv.length) {
        break label68;
      }
      j = this.mv[i];
      if (this.dcz != 1) {
        break;
      }
    } while (j == 0);
    while ((this.dcz != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final void eS(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.dcz == 1)
    {
      i = 0;
      if (i < this.mv.length)
      {
        arrayOfInt = this.mv;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.dcz == 2)
    {
      i = 0;
      if (i < this.mv.length)
      {
        arrayOfInt = this.mv;
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
    int i = this.ikh.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((bly)this.ikh.get(paramInt)).hashCode();
    AppMethodBeat.o(131013);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.mv;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.dcz == 1)
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
        if (this.dcz == 2)
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
    if (this.dcz == 1)
    {
      if (this.ikm == null) {
        this.ikm = new b.b()
        {
          public final int aII()
          {
            AppMethodBeat.i(131001);
            int i = i.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String qa(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i.this.getCount()))
            {
              ad.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = i.this.pZ(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((bly)localObject).mAQ;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.ikl != null) {
        this.ikl.a(paramInt, this.ikm);
      }
    }
    bly localbly = (bly)this.ikh.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.dcz == 1)
      {
        paramView = View.inflate(this.context, 2131494006, null);
        localb.iiF = ((TextView)paramView.findViewById(2131302355));
        localb.ikq = ((TextView)paramView.findViewById(2131302348));
        localb.ikr = ((Button)paramView.findViewById(2131302349));
        localb.iks = ((Button)paramView.findViewById(2131302351));
        localb.ikp = ((ImageView)paramView.findViewById(2131300291));
        localb.ikt = ((TextView)paramView.findViewById(2131302356));
        localb.iku = ((TextView)paramView.findViewById(2131302359));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.iku.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            paramAnonymousView = i.this;
            int i = paramInt;
            if (paramAnonymousView.dcz == 1) {
              paramAnonymousView.mv[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.dcz == 2) {
                paramAnonymousView.mv[i] = 0;
              }
            }
          }
        });
        if (this.dcz != 1) {
          break label514;
        }
        if (bt.isNullOrNil(((String[])this.ikj.get(paramInt))[1])) {
          break label473;
        }
        paramViewGroup.iiF.setText(((String[])this.ikj.get(paramInt))[1]);
        label270:
        paramViewGroup.ikr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            i.this.select(paramInt);
            AppMethodBeat.o(131003);
          }
        });
        a.b.c(paramViewGroup.ikp, localbly.mAQ);
        label298:
        switch (this.mv[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131014);
      return paramView;
      paramViewGroup = localb;
      if (this.dcz != 2) {
        break;
      }
      paramView = View.inflate(this.context, 2131494007, null);
      localb.iiF = ((TextView)paramView.findViewById(2131302355));
      localb.ikq = ((TextView)paramView.findViewById(2131302348));
      localb.ikr = ((Button)paramView.findViewById(2131302349));
      localb.iks = ((Button)paramView.findViewById(2131302351));
      localb.ikt = ((TextView)paramView.findViewById(2131302356));
      localb.iku = ((TextView)paramView.findViewById(2131302359));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label473:
      if (bt.isNullOrNil(localbly.mBV))
      {
        paramViewGroup.iiF.setText(localbly.mAQ);
        break label270;
      }
      paramViewGroup.iiF.setText(localbly.mBV);
      break label270;
      label514:
      if (this.dcz != 2) {
        break label298;
      }
      paramViewGroup.iiF.setText(((String[])this.ikj.get(paramInt))[1]);
      paramViewGroup.iks.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          i.this.select(paramInt);
          AppMethodBeat.o(131004);
        }
      });
      break label298;
      paramViewGroup.ikr.setVisibility(8);
      paramViewGroup.ikq.setVisibility(0);
      paramViewGroup.ikt.setVisibility(0);
      paramViewGroup.iku.setVisibility(0);
      continue;
      paramViewGroup.ikr.setVisibility(8);
      paramViewGroup.ikq.setVisibility(0);
      paramViewGroup.ikt.setVisibility(0);
      paramViewGroup.iku.setVisibility(0);
      continue;
      paramViewGroup.ikr.setVisibility(8);
      paramViewGroup.iks.setVisibility(8);
      paramViewGroup.ikq.setVisibility(0);
      paramViewGroup.ikt.setVisibility(0);
      paramViewGroup.iku.setVisibility(0);
      continue;
      if (this.dcz == 1)
      {
        paramViewGroup.ikq.setVisibility(8);
        paramViewGroup.ikr.setVisibility(0);
        paramViewGroup.iks.setVisibility(8);
        paramViewGroup.ikt.setVisibility(8);
        paramViewGroup.iku.setVisibility(8);
      }
      else if (this.dcz == 2)
      {
        paramViewGroup.ikq.setVisibility(8);
        paramViewGroup.ikr.setVisibility(8);
        paramViewGroup.iks.setVisibility(0);
        paramViewGroup.ikt.setVisibility(8);
        paramViewGroup.iku.setVisibility(8);
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(131008);
    super.notifyDataSetChanged();
    if (this.ikk != null) {
      this.ikk.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final bly pZ(int paramInt)
  {
    AppMethodBeat.i(131012);
    bly localbly = (bly)this.ikh.get(paramInt);
    AppMethodBeat.o(131012);
    return localbly;
  }
  
  public final void s(LinkedList<bly> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.iki.clear();
      this.ikh.clear();
      this.ikj.clear();
      Iterator localIterator1 = this.ihG.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          bly localbly = (bly)localIterator2.next();
          if (this.dcz == 1)
          {
            if (((localbly.mBi == 1) || (localbly.mBi == 0)) && (!bt.isNullOrNil(arrayOfString[2])) && (localbly.vJI.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localbly, arrayOfString);
            }
          }
          else if ((this.dcz == 2) && (localbly.mBi == 2) && (!bt.isNullOrNil(arrayOfString[2])) && (localbly.vJI.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localbly, arrayOfString);
          }
        }
      }
    }
    this.mv = new int[this.iki.size()];
    this.ikh.addAll(this.iki);
    this.iki.clear();
    AppMethodBeat.o(131009);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.dcz == 1) {
      this.mv[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.dcz == 2) {
        this.mv[paramInt] = 2;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    TextView iiF;
    ImageView ikp;
    TextView ikq;
    Button ikr;
    Button iks;
    TextView ikt;
    TextView iku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */