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
import com.tencent.mm.am.d;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.crg;
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
  public int[] bBW;
  public Context context;
  int fwp;
  public List<String[]> mTs;
  public LinkedList<crg> mVT;
  private LinkedList<crg> mVU;
  private List<String[]> mVV;
  private a mVW;
  public com.tencent.mm.ui.applet.b mVX;
  private b.b mVY;
  
  public i(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.mVT = new LinkedList();
    this.mVU = new LinkedList();
    this.mVV = new LinkedList();
    this.fwp = 1;
    this.mVX = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap aaG(String paramAnonymousString)
      {
        AppMethodBeat.i(130999);
        paramAnonymousString = d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(130999);
        return paramAnonymousString;
      }
    });
    this.mVY = null;
    this.context = paramContext;
    this.fwp = paramInt;
    this.mVW = parama;
    this.bBW = new int[this.mVT.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(crg paramcrg, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.mVU.iterator();
    while (localIterator.hasNext())
    {
      crg localcrg = (crg)localIterator.next();
      if ((localcrg.Izj != null) && (paramcrg.Izj != null) && (localcrg.Izj.equals(paramcrg.Izj)))
      {
        Log.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.mVU.add(paramcrg);
    paramcrg = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.mVV.add(new String[] { paramcrg, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void aaF(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mVV.size())
    {
      if (this.bBW[i] == 2) {
        localArrayList.add(((String[])this.mVV.get(i))[0]);
      }
      i += 1;
    }
    paramString = new al(paramString, localArrayList);
    h.aGY().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean bye()
  {
    if ((this.bBW == null) || (this.bBW.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.bBW.length) {
        break label68;
      }
      j = this.bBW[i];
      if (this.fwp != 1) {
        break;
      }
    } while (j == 0);
    while ((this.fwp != 2) || (j != 0))
    {
      i += 1;
      break;
    }
    return false;
    label68:
    return true;
  }
  
  public final void gW(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.fwp == 1)
    {
      i = 0;
      if (i < this.bBW.length)
      {
        arrayOfInt = this.bBW;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.fwp == 2)
    {
      i = 0;
      if (i < this.bBW.length)
      {
        arrayOfInt = this.bBW;
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
    int i = this.mVT.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((crg)this.mVT.get(paramInt)).hashCode();
    AppMethodBeat.o(131013);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.bBW;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.fwp == 1)
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
        if (this.fwp == 2)
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
    if (this.fwp == 1)
    {
      if (this.mVY == null) {
        this.mVY = new b.b()
        {
          public final int byf()
          {
            AppMethodBeat.i(131001);
            int i = i.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String yk(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= i.this.getCount()))
            {
              Log.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = i.this.yj(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((crg)localObject).UserName;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.mVX != null) {
        this.mVX.a(paramInt, this.mVY);
      }
    }
    crg localcrg = (crg)this.mVT.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.fwp == 1)
      {
        paramView = View.inflate(this.context, a.d.find_friend_add_item, null);
        localb.mUr = ((TextView)paramView.findViewById(a.c.mobile_friend_name));
        localb.mWc = ((TextView)paramView.findViewById(a.c.mobile_friend_add_state));
        localb.mWd = ((Button)paramView.findViewById(a.c.mobile_friend_add_tv));
        localb.mWe = ((Button)paramView.findViewById(a.c.mobile_friend_invite_tv));
        localb.mWb = ((ImageView)paramView.findViewById(a.c.friend_avatar_iv));
        localb.mWf = ((TextView)paramView.findViewById(a.c.mobile_friend_selected));
        localb.mWg = ((TextView)paramView.findViewById(a.c.mobile_friend_unselect));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.mWg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = i.this;
            int i = paramInt;
            if (paramAnonymousView.fwp == 1) {
              paramAnonymousView.bBW[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.fwp == 2) {
                paramAnonymousView.bBW[i] = 0;
              }
            }
          }
        });
        if (this.fwp != 1) {
          break label528;
        }
        if (Util.isNullOrNil(((String[])this.mVV.get(paramInt))[1])) {
          break label487;
        }
        paramViewGroup.mUr.setText(((String[])this.mVV.get(paramInt))[1]);
        label278:
        paramViewGroup.mWd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            i.this.select(paramInt);
            a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131003);
          }
        });
        a.b.c(paramViewGroup.mWb, localcrg.UserName);
        label306:
        switch (this.bBW[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131014);
      return paramView;
      paramViewGroup = localb;
      if (this.fwp != 2) {
        break;
      }
      paramView = View.inflate(this.context, a.d.find_friend_item, null);
      localb.mUr = ((TextView)paramView.findViewById(a.c.mobile_friend_name));
      localb.mWc = ((TextView)paramView.findViewById(a.c.mobile_friend_add_state));
      localb.mWd = ((Button)paramView.findViewById(a.c.mobile_friend_add_tv));
      localb.mWe = ((Button)paramView.findViewById(a.c.mobile_friend_invite_tv));
      localb.mWf = ((TextView)paramView.findViewById(a.c.mobile_friend_selected));
      localb.mWg = ((TextView)paramView.findViewById(a.c.mobile_friend_unselect));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label487:
      if (Util.isNullOrNil(localcrg.rWI))
      {
        paramViewGroup.mUr.setText(localcrg.UserName);
        break label278;
      }
      paramViewGroup.mUr.setText(localcrg.rWI);
      break label278;
      label528:
      if (this.fwp != 2) {
        break label306;
      }
      paramViewGroup.mUr.setText(((String[])this.mVV.get(paramInt))[1]);
      paramViewGroup.mWe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          i.this.select(paramInt);
          a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131004);
        }
      });
      break label306;
      paramViewGroup.mWd.setVisibility(8);
      paramViewGroup.mWc.setVisibility(0);
      paramViewGroup.mWf.setVisibility(0);
      paramViewGroup.mWg.setVisibility(0);
      continue;
      paramViewGroup.mWd.setVisibility(8);
      paramViewGroup.mWc.setVisibility(0);
      paramViewGroup.mWf.setVisibility(0);
      paramViewGroup.mWg.setVisibility(0);
      continue;
      paramViewGroup.mWd.setVisibility(8);
      paramViewGroup.mWe.setVisibility(8);
      paramViewGroup.mWc.setVisibility(0);
      paramViewGroup.mWf.setVisibility(0);
      paramViewGroup.mWg.setVisibility(0);
      continue;
      if (this.fwp == 1)
      {
        paramViewGroup.mWc.setVisibility(8);
        paramViewGroup.mWd.setVisibility(0);
        paramViewGroup.mWe.setVisibility(8);
        paramViewGroup.mWf.setVisibility(8);
        paramViewGroup.mWg.setVisibility(8);
      }
      else if (this.fwp == 2)
      {
        paramViewGroup.mWc.setVisibility(8);
        paramViewGroup.mWd.setVisibility(8);
        paramViewGroup.mWe.setVisibility(0);
        paramViewGroup.mWf.setVisibility(8);
        paramViewGroup.mWg.setVisibility(8);
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(131008);
    super.notifyDataSetChanged();
    if (this.mVW != null) {
      this.mVW.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.fwp == 1) {
      this.bBW[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.fwp == 2) {
        this.bBW[paramInt] = 2;
      }
    }
  }
  
  public final void t(LinkedList<crg> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.mVU.clear();
      this.mVT.clear();
      this.mVV.clear();
      Iterator localIterator1 = this.mTs.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          crg localcrg = (crg)localIterator2.next();
          if (this.fwp == 1)
          {
            if (((localcrg.rVU == 1) || (localcrg.rVU == 0)) && (!Util.isNullOrNil(arrayOfString[2])) && (localcrg.Izj.equals(g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localcrg, arrayOfString);
            }
          }
          else if ((this.fwp == 2) && (localcrg.rVU == 2) && (!Util.isNullOrNil(arrayOfString[2])) && (localcrg.Izj.equals(g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localcrg, arrayOfString);
          }
        }
      }
    }
    this.bBW = new int[this.mVU.size()];
    this.mVT.addAll(this.mVU);
    this.mVU.clear();
    AppMethodBeat.o(131009);
  }
  
  public final crg yj(int paramInt)
  {
    AppMethodBeat.i(131012);
    crg localcrg = (crg)this.mVT.get(paramInt);
    AppMethodBeat.o(131012);
    return localcrg;
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    TextView mUr;
    ImageView mWb;
    TextView mWc;
    Button mWd;
    Button mWe;
    TextView mWf;
    TextView mWg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i
 * JD-Core Version:    0.7.0.1
 */