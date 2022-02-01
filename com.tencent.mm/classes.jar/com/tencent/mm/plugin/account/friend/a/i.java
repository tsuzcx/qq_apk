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
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  int dDG;
  public List<String[]> kbT;
  public LinkedList<cik> ket;
  private LinkedList<cik> keu;
  private List<String[]> kev;
  private a kew;
  public com.tencent.mm.ui.applet.b kex;
  private b.b kez;
  public int[] pt;
  
  public i(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.ket = new LinkedList();
    this.keu = new LinkedList();
    this.kev = new LinkedList();
    this.dDG = 1;
    this.kex = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Ta(String paramAnonymousString)
      {
        AppMethodBeat.i(130999);
        paramAnonymousString = c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(130999);
        return paramAnonymousString;
      }
    });
    this.kez = null;
    this.context = paramContext;
    this.dDG = paramInt;
    this.kew = parama;
    this.pt = new int[this.ket.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(cik paramcik, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.keu.iterator();
    while (localIterator.hasNext())
    {
      cik localcik = (cik)localIterator.next();
      if ((localcik.Cyk != null) && (paramcik.Cyk != null) && (localcik.Cyk.equals(paramcik.Cyk)))
      {
        Log.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.keu.add(paramcik);
    paramcik = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.kev.add(new String[] { paramcik, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void SZ(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.kev.size())
    {
      if (this.pt[i] == 2) {
        localArrayList.add(((String[])this.kev.get(i))[0]);
      }
      i += 1;
    }
    paramString = new al(paramString, localArrayList);
    com.tencent.mm.kernel.g.azz().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean bnV()
  {
    if ((this.pt == null) || (this.pt.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.pt.length) {
        break label68;
      }
      j = this.pt[i];
      if (this.dDG != 1) {
        break;
      }
    } while (j == 0);
    while ((this.dDG != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(131011);
    int i = this.ket.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((cik)this.ket.get(paramInt)).hashCode();
    AppMethodBeat.o(131013);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.pt;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.dDG == 1)
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
        if (this.dDG == 2)
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
    if (this.dDG == 1)
    {
      if (this.kez == null) {
        this.kez = new b.b()
        {
          public final int bnW()
          {
            AppMethodBeat.i(131001);
            int i = i.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String vg(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i.this.getCount()))
            {
              Log.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = i.this.vf(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((cik)localObject).UserName;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.kex != null) {
        this.kex.a(paramInt, this.kez);
      }
    }
    cik localcik = (cik)this.ket.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.dDG == 1)
      {
        paramView = View.inflate(this.context, 2131494186, null);
        localb.kcS = ((TextView)paramView.findViewById(2131304752));
        localb.keD = ((TextView)paramView.findViewById(2131304745));
        localb.keE = ((Button)paramView.findViewById(2131304746));
        localb.keF = ((Button)paramView.findViewById(2131304748));
        localb.keC = ((ImageView)paramView.findViewById(2131301778));
        localb.keG = ((TextView)paramView.findViewById(2131304753));
        localb.keH = ((TextView)paramView.findViewById(2131304756));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.keH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = i.this;
            int i = paramInt;
            if (paramAnonymousView.dDG == 1) {
              paramAnonymousView.pt[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.dDG == 2) {
                paramAnonymousView.pt[i] = 0;
              }
            }
          }
        });
        if (this.dDG != 1) {
          break label514;
        }
        if (Util.isNullOrNil(((String[])this.kev.get(paramInt))[1])) {
          break label473;
        }
        paramViewGroup.kcS.setText(((String[])this.kev.get(paramInt))[1]);
        label270:
        paramViewGroup.keE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            i.this.select(paramInt);
            a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131003);
          }
        });
        a.b.c(paramViewGroup.keC, localcik.UserName);
        label298:
        switch (this.pt[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131014);
      return paramView;
      paramViewGroup = localb;
      if (this.dDG != 2) {
        break;
      }
      paramView = View.inflate(this.context, 2131494187, null);
      localb.kcS = ((TextView)paramView.findViewById(2131304752));
      localb.keD = ((TextView)paramView.findViewById(2131304745));
      localb.keE = ((Button)paramView.findViewById(2131304746));
      localb.keF = ((Button)paramView.findViewById(2131304748));
      localb.keG = ((TextView)paramView.findViewById(2131304753));
      localb.keH = ((TextView)paramView.findViewById(2131304756));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label473:
      if (Util.isNullOrNil(localcik.oUJ))
      {
        paramViewGroup.kcS.setText(localcik.UserName);
        break label270;
      }
      paramViewGroup.kcS.setText(localcik.oUJ);
      break label270;
      label514:
      if (this.dDG != 2) {
        break label298;
      }
      paramViewGroup.kcS.setText(((String[])this.kev.get(paramInt))[1]);
      paramViewGroup.keF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          i.this.select(paramInt);
          a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131004);
        }
      });
      break label298;
      paramViewGroup.keE.setVisibility(8);
      paramViewGroup.keD.setVisibility(0);
      paramViewGroup.keG.setVisibility(0);
      paramViewGroup.keH.setVisibility(0);
      continue;
      paramViewGroup.keE.setVisibility(8);
      paramViewGroup.keD.setVisibility(0);
      paramViewGroup.keG.setVisibility(0);
      paramViewGroup.keH.setVisibility(0);
      continue;
      paramViewGroup.keE.setVisibility(8);
      paramViewGroup.keF.setVisibility(8);
      paramViewGroup.keD.setVisibility(0);
      paramViewGroup.keG.setVisibility(0);
      paramViewGroup.keH.setVisibility(0);
      continue;
      if (this.dDG == 1)
      {
        paramViewGroup.keD.setVisibility(8);
        paramViewGroup.keE.setVisibility(0);
        paramViewGroup.keF.setVisibility(8);
        paramViewGroup.keG.setVisibility(8);
        paramViewGroup.keH.setVisibility(8);
      }
      else if (this.dDG == 2)
      {
        paramViewGroup.keD.setVisibility(8);
        paramViewGroup.keE.setVisibility(8);
        paramViewGroup.keF.setVisibility(0);
        paramViewGroup.keG.setVisibility(8);
        paramViewGroup.keH.setVisibility(8);
      }
    }
  }
  
  public final void gk(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.dDG == 1)
    {
      i = 0;
      if (i < this.pt.length)
      {
        arrayOfInt = this.pt;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.dDG == 2)
    {
      i = 0;
      if (i < this.pt.length)
      {
        arrayOfInt = this.pt;
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
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(131008);
    super.notifyDataSetChanged();
    if (this.kew != null) {
      this.kew.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final void s(LinkedList<cik> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.keu.clear();
      this.ket.clear();
      this.kev.clear();
      Iterator localIterator1 = this.kbT.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          cik localcik = (cik)localIterator2.next();
          if (this.dDG == 1)
          {
            if (((localcik.oTW == 1) || (localcik.oTW == 0)) && (!Util.isNullOrNil(arrayOfString[2])) && (localcik.Cyk.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localcik, arrayOfString);
            }
          }
          else if ((this.dDG == 2) && (localcik.oTW == 2) && (!Util.isNullOrNil(arrayOfString[2])) && (localcik.Cyk.equals(com.tencent.mm.b.g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localcik, arrayOfString);
          }
        }
      }
    }
    this.pt = new int[this.keu.size()];
    this.ket.addAll(this.keu);
    this.keu.clear();
    AppMethodBeat.o(131009);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.dDG == 1) {
      this.pt[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.dDG == 2) {
        this.pt[paramInt] = 2;
      }
    }
  }
  
  public final cik vf(int paramInt)
  {
    AppMethodBeat.i(131012);
    cik localcik = (cik)this.ket.get(paramInt);
    AppMethodBeat.o(131012);
    return localcik;
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    TextView kcS;
    ImageView keC;
    TextView keD;
    Button keE;
    Button keF;
    TextView keG;
    TextView keH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */