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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int cZX;
  public Context context;
  public List<String[]> iHO;
  public LinkedList<bpw> iKo;
  private LinkedList<bpw> iKp;
  private List<String[]> iKq;
  private a iKr;
  public b iKs;
  private b.b iKt;
  public int[] nw;
  
  public i(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.iKo = new LinkedList();
    this.iKp = new LinkedList();
    this.iKq = new LinkedList();
    this.cZX = 1;
    this.iKs = new b(new b.a()
    {
      public final Bitmap Go(String paramAnonymousString)
      {
        AppMethodBeat.i(130999);
        paramAnonymousString = c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(130999);
        return paramAnonymousString;
      }
    });
    this.iKt = null;
    this.context = paramContext;
    this.cZX = paramInt;
    this.iKr = parama;
    this.nw = new int[this.iKo.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(bpw parambpw, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.iKp.iterator();
    while (localIterator.hasNext())
    {
      bpw localbpw = (bpw)localIterator.next();
      if ((localbpw.wTM != null) && (parambpw.wTM != null) && (localbpw.wTM.equals(parambpw.wTM)))
      {
        ac.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.iKp.add(parambpw);
    parambpw = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.iKq.add(new String[] { parambpw, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void Gn(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.iKq.size())
    {
      if (this.nw[i] == 2) {
        localArrayList.add(((String[])this.iKq.get(i))[0]);
      }
      i += 1;
    }
    paramString = new al(paramString, localArrayList);
    com.tencent.mm.kernel.g.agi().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean aPy()
  {
    if ((this.nw == null) || (this.nw.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.nw.length) {
        break label68;
      }
      j = this.nw[i];
      if (this.cZX != 1) {
        break;
      }
    } while (j == 0);
    while ((this.cZX != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final void fm(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.cZX == 1)
    {
      i = 0;
      if (i < this.nw.length)
      {
        arrayOfInt = this.nw;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.cZX == 2)
    {
      i = 0;
      if (i < this.nw.length)
      {
        arrayOfInt = this.nw;
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
    int i = this.iKo.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((bpw)this.iKo.get(paramInt)).hashCode();
    AppMethodBeat.o(131013);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.nw;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.cZX == 1)
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
        if (this.cZX == 2)
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
    if (this.cZX == 1)
    {
      if (this.iKt == null) {
        this.iKt = new b.b()
        {
          public final int aPz()
          {
            AppMethodBeat.i(131001);
            int i = i.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String qN(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i.this.getCount()))
            {
              ac.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = i.this.qM(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((bpw)localObject).ncR;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.iKs != null) {
        this.iKs.a(paramInt, this.iKt);
      }
    }
    bpw localbpw = (bpw)this.iKo.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.cZX == 1)
      {
        paramView = View.inflate(this.context, 2131494006, null);
        localb.iIN = ((TextView)paramView.findViewById(2131302355));
        localb.iKx = ((TextView)paramView.findViewById(2131302348));
        localb.iKy = ((Button)paramView.findViewById(2131302349));
        localb.iKz = ((Button)paramView.findViewById(2131302351));
        localb.iKw = ((ImageView)paramView.findViewById(2131300291));
        localb.iKA = ((TextView)paramView.findViewById(2131302356));
        localb.iKB = ((TextView)paramView.findViewById(2131302359));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.iKB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            paramAnonymousView = i.this;
            int i = paramInt;
            if (paramAnonymousView.cZX == 1) {
              paramAnonymousView.nw[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.cZX == 2) {
                paramAnonymousView.nw[i] = 0;
              }
            }
          }
        });
        if (this.cZX != 1) {
          break label514;
        }
        if (bs.isNullOrNil(((String[])this.iKq.get(paramInt))[1])) {
          break label473;
        }
        paramViewGroup.iIN.setText(((String[])this.iKq.get(paramInt))[1]);
        label270:
        paramViewGroup.iKy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            i.this.select(paramInt);
            AppMethodBeat.o(131003);
          }
        });
        a.b.c(paramViewGroup.iKw, localbpw.ncR);
        label298:
        switch (this.nw[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131014);
      return paramView;
      paramViewGroup = localb;
      if (this.cZX != 2) {
        break;
      }
      paramView = View.inflate(this.context, 2131494007, null);
      localb.iIN = ((TextView)paramView.findViewById(2131302355));
      localb.iKx = ((TextView)paramView.findViewById(2131302348));
      localb.iKy = ((Button)paramView.findViewById(2131302349));
      localb.iKz = ((Button)paramView.findViewById(2131302351));
      localb.iKA = ((TextView)paramView.findViewById(2131302356));
      localb.iKB = ((TextView)paramView.findViewById(2131302359));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label473:
      if (bs.isNullOrNil(localbpw.ndW))
      {
        paramViewGroup.iIN.setText(localbpw.ncR);
        break label270;
      }
      paramViewGroup.iIN.setText(localbpw.ndW);
      break label270;
      label514:
      if (this.cZX != 2) {
        break label298;
      }
      paramViewGroup.iIN.setText(((String[])this.iKq.get(paramInt))[1]);
      paramViewGroup.iKz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          i.this.select(paramInt);
          AppMethodBeat.o(131004);
        }
      });
      break label298;
      paramViewGroup.iKy.setVisibility(8);
      paramViewGroup.iKx.setVisibility(0);
      paramViewGroup.iKA.setVisibility(0);
      paramViewGroup.iKB.setVisibility(0);
      continue;
      paramViewGroup.iKy.setVisibility(8);
      paramViewGroup.iKx.setVisibility(0);
      paramViewGroup.iKA.setVisibility(0);
      paramViewGroup.iKB.setVisibility(0);
      continue;
      paramViewGroup.iKy.setVisibility(8);
      paramViewGroup.iKz.setVisibility(8);
      paramViewGroup.iKx.setVisibility(0);
      paramViewGroup.iKA.setVisibility(0);
      paramViewGroup.iKB.setVisibility(0);
      continue;
      if (this.cZX == 1)
      {
        paramViewGroup.iKx.setVisibility(8);
        paramViewGroup.iKy.setVisibility(0);
        paramViewGroup.iKz.setVisibility(8);
        paramViewGroup.iKA.setVisibility(8);
        paramViewGroup.iKB.setVisibility(8);
      }
      else if (this.cZX == 2)
      {
        paramViewGroup.iKx.setVisibility(8);
        paramViewGroup.iKy.setVisibility(8);
        paramViewGroup.iKz.setVisibility(0);
        paramViewGroup.iKA.setVisibility(8);
        paramViewGroup.iKB.setVisibility(8);
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(131008);
    super.notifyDataSetChanged();
    if (this.iKr != null) {
      this.iKr.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final bpw qM(int paramInt)
  {
    AppMethodBeat.i(131012);
    bpw localbpw = (bpw)this.iKo.get(paramInt);
    AppMethodBeat.o(131012);
    return localbpw;
  }
  
  public final void s(LinkedList<bpw> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.iKp.clear();
      this.iKo.clear();
      this.iKq.clear();
      Iterator localIterator1 = this.iHO.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          bpw localbpw = (bpw)localIterator2.next();
          if (this.cZX == 1)
          {
            if (((localbpw.ndj == 1) || (localbpw.ndj == 0)) && (!bs.isNullOrNil(arrayOfString[2])) && (localbpw.wTM.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localbpw, arrayOfString);
            }
          }
          else if ((this.cZX == 2) && (localbpw.ndj == 2) && (!bs.isNullOrNil(arrayOfString[2])) && (localbpw.wTM.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localbpw, arrayOfString);
          }
        }
      }
    }
    this.nw = new int[this.iKp.size()];
    this.iKo.addAll(this.iKp);
    this.iKp.clear();
    AppMethodBeat.o(131009);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.cZX == 1) {
      this.nw[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.cZX == 2) {
        this.nw[paramInt] = 2;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    TextView iIN;
    TextView iKA;
    TextView iKB;
    ImageView iKw;
    TextView iKx;
    Button iKy;
    Button iKz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */