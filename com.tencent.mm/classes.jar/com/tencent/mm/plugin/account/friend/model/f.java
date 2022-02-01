package com.tencent.mm.plugin.account.friend.model;

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
import com.tencent.mm.am.s;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  public Context context;
  public int[] duY;
  int hAN;
  public List<String[]> pPZ;
  public LinkedList<dib> pSA;
  private LinkedList<dib> pSB;
  private List<String[]> pSC;
  private a pSD;
  public com.tencent.mm.ui.applet.b pSE;
  private b.b pSF;
  
  public f(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(131005);
    this.pSA = new LinkedList();
    this.pSB = new LinkedList();
    this.pSC = new LinkedList();
    this.hAN = 1;
    this.pSE = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap getHeadImg(String paramAnonymousString)
      {
        AppMethodBeat.i(130999);
        paramAnonymousString = d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(130999);
        return paramAnonymousString;
      }
    });
    this.pSF = null;
    this.context = paramContext;
    this.hAN = paramInt;
    this.pSD = parama;
    this.duY = new int[this.pSA.size()];
    AppMethodBeat.o(131005);
  }
  
  private void a(dib paramdib, String[] paramArrayOfString)
  {
    AppMethodBeat.i(131010);
    Iterator localIterator = this.pSB.iterator();
    while (localIterator.hasNext())
    {
      dib localdib = (dib)localIterator.next();
      if ((localdib.OzQ != null) && (paramdib.OzQ != null) && (localdib.OzQ.equals(paramdib.OzQ)))
      {
        Log.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
        AppMethodBeat.o(131010);
        return;
      }
    }
    this.pSB.add(paramdib);
    paramdib = paramArrayOfString[2];
    paramArrayOfString = paramArrayOfString[1];
    this.pSC.add(new String[] { paramdib, paramArrayOfString });
    AppMethodBeat.o(131010);
  }
  
  public final void SZ(String paramString)
  {
    AppMethodBeat.i(131015);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.pSC.size())
    {
      if (this.duY[i] == 2) {
        localArrayList.add(((String[])this.pSC.get(i))[0]);
      }
      i += 1;
    }
    paramString = new ai(paramString, localArrayList);
    h.aZW().a(paramString, 0);
    AppMethodBeat.o(131015);
  }
  
  public final boolean bWS()
  {
    if ((this.duY == null) || (this.duY.length == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      i = 0;
      if (i >= this.duY.length) {
        break label68;
      }
      j = this.duY[i];
      if (this.hAN != 1) {
        break;
      }
    } while (j == 0);
    while ((this.hAN != 2) || (j != 0))
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
    int i = this.pSA.size();
    AppMethodBeat.o(131011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(131013);
    long l = ((dib)this.pSA.get(paramInt)).hashCode();
    AppMethodBeat.o(131013);
    return l;
  }
  
  public final int getSelectCount()
  {
    int[] arrayOfInt = this.duY;
    int m = arrayOfInt.length;
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int n = arrayOfInt[j];
      int i;
      if (this.hAN == 1)
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
        if (this.hAN == 2)
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
    if (this.hAN == 1)
    {
      if (this.pSF == null) {
        this.pSF = new b.b()
        {
          public final int bWT()
          {
            AppMethodBeat.i(131001);
            int i = f.this.getCount();
            AppMethodBeat.o(131001);
            return i;
          }
          
          public final String yq(int paramAnonymousInt)
          {
            AppMethodBeat.i(131000);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= f.this.getCount()))
            {
              Log.e("MicroMsg.FriendAdapter", "pos is invalid");
              AppMethodBeat.o(131000);
              return null;
            }
            Object localObject = f.this.yp(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(131000);
              return null;
            }
            localObject = ((dib)localObject).UserName;
            AppMethodBeat.o(131000);
            return localObject;
          }
        };
      }
      if (this.pSE != null) {
        this.pSE.a(paramInt, this.pSF);
      }
    }
    dib localdib = (dib)this.pSA.get(paramInt);
    b localb;
    if (paramView == null)
    {
      localb = new b();
      if (this.hAN == 1)
      {
        paramView = View.inflate(this.context, a.d.find_friend_add_item, null);
        localb.pQZ = ((TextView)paramView.findViewById(a.c.mobile_friend_name));
        localb.pSI = ((TextView)paramView.findViewById(a.c.mobile_friend_add_state));
        localb.pSJ = ((Button)paramView.findViewById(a.c.mobile_friend_add_tv));
        localb.pSK = ((Button)paramView.findViewById(a.c.mobile_friend_invite_tv));
        localb.avatar = ((ImageView)paramView.findViewById(a.c.friend_avatar_iv));
        localb.pSL = ((TextView)paramView.findViewById(a.c.mobile_friend_selected));
        localb.pSM = ((TextView)paramView.findViewById(a.c.mobile_friend_unselect));
        paramView.setTag(localb);
        paramViewGroup = localb;
        paramViewGroup.pSM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131002);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = f.this;
            int i = paramInt;
            if (paramAnonymousView.hAN == 1) {
              paramAnonymousView.duY[i] = 0;
            }
            for (;;)
            {
              paramAnonymousView.notifyDataSetChanged();
              a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(131002);
              return;
              if (paramAnonymousView.hAN == 2) {
                paramAnonymousView.duY[i] = 0;
              }
            }
          }
        });
        if (this.hAN != 1) {
          break label528;
        }
        if (Util.isNullOrNil(((String[])this.pSC.get(paramInt))[1])) {
          break label487;
        }
        paramViewGroup.pQZ.setText(((String[])this.pSC.get(paramInt))[1]);
        label278:
        paramViewGroup.pSJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131003);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            f.this.select(paramInt);
            a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(131003);
          }
        });
        a.b.g(paramViewGroup.avatar, localdib.UserName);
        label306:
        switch (this.duY[paramInt])
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131014);
      return paramView;
      paramViewGroup = localb;
      if (this.hAN != 2) {
        break;
      }
      paramView = View.inflate(this.context, a.d.find_friend_item, null);
      localb.pQZ = ((TextView)paramView.findViewById(a.c.mobile_friend_name));
      localb.pSI = ((TextView)paramView.findViewById(a.c.mobile_friend_add_state));
      localb.pSJ = ((Button)paramView.findViewById(a.c.mobile_friend_add_tv));
      localb.pSK = ((Button)paramView.findViewById(a.c.mobile_friend_invite_tv));
      localb.pSL = ((TextView)paramView.findViewById(a.c.mobile_friend_selected));
      localb.pSM = ((TextView)paramView.findViewById(a.c.mobile_friend_unselect));
      paramView.setTag(localb);
      paramViewGroup = localb;
      break;
      paramViewGroup = (b)paramView.getTag();
      break;
      label487:
      if (Util.isNullOrNil(localdib.vhX))
      {
        paramViewGroup.pQZ.setText(localdib.UserName);
        break label278;
      }
      paramViewGroup.pQZ.setText(localdib.vhX);
      break label278;
      label528:
      if (this.hAN != 2) {
        break label306;
      }
      paramViewGroup.pQZ.setText(((String[])this.pSC.get(paramInt))[1]);
      paramViewGroup.pSK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131004);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          f.this.select(paramInt);
          a.a(this, "com/tencent/mm/plugin/account/friend/model/FriendAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131004);
        }
      });
      break label306;
      paramViewGroup.pSJ.setVisibility(8);
      paramViewGroup.pSI.setVisibility(0);
      paramViewGroup.pSL.setVisibility(0);
      paramViewGroup.pSM.setVisibility(0);
      continue;
      paramViewGroup.pSJ.setVisibility(8);
      paramViewGroup.pSI.setVisibility(0);
      paramViewGroup.pSL.setVisibility(0);
      paramViewGroup.pSM.setVisibility(0);
      continue;
      paramViewGroup.pSJ.setVisibility(8);
      paramViewGroup.pSK.setVisibility(8);
      paramViewGroup.pSI.setVisibility(0);
      paramViewGroup.pSL.setVisibility(0);
      paramViewGroup.pSM.setVisibility(0);
      continue;
      if (this.hAN == 1)
      {
        paramViewGroup.pSI.setVisibility(8);
        paramViewGroup.pSJ.setVisibility(0);
        paramViewGroup.pSK.setVisibility(8);
        paramViewGroup.pSL.setVisibility(8);
        paramViewGroup.pSM.setVisibility(8);
      }
      else if (this.hAN == 2)
      {
        paramViewGroup.pSI.setVisibility(8);
        paramViewGroup.pSJ.setVisibility(8);
        paramViewGroup.pSK.setVisibility(0);
        paramViewGroup.pSL.setVisibility(8);
        paramViewGroup.pSM.setVisibility(8);
      }
    }
  }
  
  public final void hM(boolean paramBoolean)
  {
    AppMethodBeat.i(131007);
    int i;
    int[] arrayOfInt;
    int j;
    if (this.hAN == 1)
    {
      i = 0;
      if (i < this.duY.length)
      {
        arrayOfInt = this.duY;
        if (paramBoolean) {}
        for (j = 1;; j = 0)
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
    }
    else if (this.hAN == 2)
    {
      i = 0;
      if (i < this.duY.length)
      {
        arrayOfInt = this.duY;
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
    if (this.pSD != null) {
      this.pSD.notifyDataSetChanged();
    }
    AppMethodBeat.o(131008);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(131006);
    if (this.hAN == 1) {
      this.duY[paramInt] = 1;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(131006);
      return;
      if (this.hAN == 2) {
        this.duY[paramInt] = 2;
      }
    }
  }
  
  public final void w(LinkedList<dib> paramLinkedList)
  {
    AppMethodBeat.i(131009);
    if (paramLinkedList != null)
    {
      this.pSB.clear();
      this.pSA.clear();
      this.pSC.clear();
      Iterator localIterator1 = this.pPZ.iterator();
      while (localIterator1.hasNext())
      {
        String[] arrayOfString = (String[])localIterator1.next();
        Iterator localIterator2 = paramLinkedList.iterator();
        while (localIterator2.hasNext())
        {
          dib localdib = (dib)localIterator2.next();
          if (this.hAN == 1)
          {
            if (((localdib.vhk == 1) || (localdib.vhk == 0)) && (!Util.isNullOrNil(arrayOfString[2])) && (localdib.OzQ.equals(g.getMessageDigest(arrayOfString[2].getBytes())))) {
              a(localdib, arrayOfString);
            }
          }
          else if ((this.hAN == 2) && (localdib.vhk == 2) && (!Util.isNullOrNil(arrayOfString[2])) && (localdib.OzQ.equals(g.getMessageDigest(arrayOfString[2].getBytes())))) {
            a(localdib, arrayOfString);
          }
        }
      }
    }
    this.duY = new int[this.pSB.size()];
    this.pSA.addAll(this.pSB);
    this.pSB.clear();
    AppMethodBeat.o(131009);
  }
  
  public final dib yp(int paramInt)
  {
    AppMethodBeat.i(131012);
    dib localdib = (dib)this.pSA.get(paramInt);
    AppMethodBeat.o(131012);
    return localdib;
  }
  
  public static abstract interface a
  {
    public abstract void notifyDataSetChanged();
  }
  
  static final class b
  {
    ImageView avatar;
    TextView pQZ;
    TextView pSI;
    Button pSJ;
    Button pSK;
    TextView pSL;
    TextView pSM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.f
 * JD-Core Version:    0.7.0.1
 */