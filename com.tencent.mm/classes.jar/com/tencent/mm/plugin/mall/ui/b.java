package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private final int vDT;
  private final int vDU;
  private final int vDV;
  List<ArrayList<c>> vDW;
  d vDX;
  private boolean vDY;
  private int vDZ;
  private SparseArray<String> vDj;
  private int vDk;
  private int vEa;
  private boolean vEb;
  private boolean vEc;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.vDT = 3;
    this.vDU = 9;
    this.vDV = 3;
    this.vDW = new ArrayList();
    this.vDj = null;
    this.vDY = true;
    this.vDZ = 0;
    this.vEa = 0;
    this.vEb = false;
    this.vEc = false;
    this.mContext = paramContext;
    this.vDk = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private boolean JE(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.vDZ > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.vDW.get(j)).size();
        j += 1;
      }
      if (this.vEa > 3)
      {
        j = 3;
        if (i < 9) {
          break label117;
        }
        if ((!this.vDY) || (paramInt != j)) {
          break label96;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.vEa;
      break;
      label96:
      if ((paramInt == this.vEa) && (!this.vDY)) {
        bool = true;
      } else {
        label117:
        bool = false;
      }
    }
  }
  
  private String JF(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.vDj == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.vDj.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.vDW.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).vEA.type;
      localObject = JF(m);
      j = 0;
      k = 0;
      if (bt.isNullOrNil((String)localObject)) {
        break label680;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.vDW.size() - 1) {
          break label355;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label104:
      if (i != 0)
      {
        paramb.vEs.setText((CharSequence)localObject);
        paramb.vEs.setVisibility(0);
        paramb.vEt.setVisibility(8);
        paramb.vEu.setVisibility(0);
        paramb.vEs.setMinHeight(a.dkd());
        paramb.vEu.setBackgroundColor(e.dkH());
        localObject = paramb.vEr;
        ((LinearLayout)localObject).setFocusable(true);
        i = 0;
        if (i >= 3) {
          break label674;
        }
        if ((i >= ((LinearLayout)localObject).getChildCount()) || (((LinearLayout)localObject).getChildAt(i) == null)) {
          break label523;
        }
        paramb = ((LinearLayout)localObject).getChildAt(i);
        paramb.setVisibility(0);
        if (i >= localList.size()) {
          break label459;
        }
        a(paramb, (c)localList.get(i), i, paramInt2);
        label249:
        if ((paramInt2 != 0) || (paramInt1 == 0)) {
          break label655;
        }
        if (i != 0) {
          break label630;
        }
        paramb.setBackground(this.mContext.getResources().getDrawable(2131233198));
      }
      label523:
      label655:
      for (;;)
      {
        label163:
        label178:
        i += 1;
        break label178;
        i = k;
        if (((ArrayList)this.vDW.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.vDW.get(paramInt1 - 1)).get(0)).vEA.type) {
          break;
        }
        i = 1;
        break;
        label355:
        j = i;
        if (m == ((c)((ArrayList)this.vDW.get(paramInt1 + 1)).get(0)).vEA.type) {
          break label680;
        }
        paramInt1 = 1;
        break label104;
        paramb.vEs.setVisibility(8);
        paramb.vEt.setVisibility(8);
        paramb.vEu.setVisibility(8);
        break label163;
        paramb.vEs.setVisibility(8);
        paramb.vEt.setVisibility(8);
        paramb.vEu.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label459:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.vEg.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = u((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.dkb(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.vEg.setVisibility(4);
          paramb.setOnClickListener(null);
          paramb.setEnabled(false);
          paramb.setClickable(false);
          a(locala);
        }
        label630:
        if (i != 1) {
          paramb.setBackground(this.mContext.getResources().getDrawable(2131233199));
        } else {
          paramb.setBackground(this.mContext.getResources().getDrawable(2131233200));
        }
      }
      label674:
      AppMethodBeat.o(66040);
      return;
      label680:
      paramInt1 = 0;
      i = j;
    }
  }
  
  private void a(View paramView, c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66046);
    if (paramView == null)
    {
      AppMethodBeat.o(66046);
      return;
    }
    a locala = (a)paramView.getTag();
    final MallFunction localMallFunction = paramc.vEA;
    final int i = paramc.vEB;
    locala.vEm = localMallFunction.vEm;
    locala.vEl = localMallFunction.vEl;
    com.tencent.mm.plugin.mall.b.a.d(locala.vEh, locala.vEl, 2131690773);
    locala.vEj.setText(localMallFunction.dKm);
    locala.vEi.setVisibility(8);
    if ((localMallFunction.Dbp != null) && (!bt.isNullOrNil(localMallFunction.Dbp.Dbx)) && (b(localMallFunction)))
    {
      if (d.eGX().aEE(localMallFunction.jDb) != null)
      {
        ad.w("MicroMsg.FunctionListAdapter", "show the news : " + d.eGX().aEE(localMallFunction.jDb).Dbx);
        locala.vEk.setText(localMallFunction.Dbp.Dbx);
        locala.vEk.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.q(locala.vEi, locala.vEm);
        locala.vEi.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66034);
          }
        });
        locala.vEg.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.vEk.setVisibility(4);
      }
    }
    if ((localMallFunction.Dbp != null) && (localMallFunction.Dbp.DbC == 1))
    {
      locala.vEk.setText(localMallFunction.Dbp.Dbx);
      locala.vEk.setVisibility(0);
    }
    for (;;)
    {
      locala.vEi.setImageBitmap(null);
      locala.vEi.setVisibility(8);
      break;
      locala.vEk.setText("");
      locala.vEk.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.vEn.setVisibility(0);
    parama.vEo.setVisibility(4);
    parama.vEp.setVisibility(4);
    parama.vEq.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.vEq.setVisibility(4);
    if (paramInt1 == 0) {
      parama.vEo.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.vEn.setVisibility(0);
      parama.vEp.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.vEo.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.vEo.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.vEn.setVisibility(4);
      parama.vEp.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.vEn.setVisibility(0);
    parama.vEp.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.Dbp != null) && (!bt.isNullOrNil(paramMallFunction.Dbp.Dbx)) && (b(paramMallFunction)) && (d.eGX().aEE(paramMallFunction.jDb) != null))
    {
      AppMethodBeat.o(66045);
      return true;
    }
    AppMethodBeat.o(66045);
    return false;
  }
  
  private static boolean b(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66047);
    MallNews localMallNews = d.eGX().aEE(paramMallFunction.jDb);
    if ((localMallNews == null) || (bt.isNullOrNil(localMallNews.Bhd)) || (!localMallNews.Bhd.equals(paramMallFunction.Dbp.Bhd)))
    {
      ad.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.Dbp.Bhd, paramMallFunction.dKm });
      d.eGX().b(paramMallFunction.Dbp);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.Dbv))
      {
        ad.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
        AppMethodBeat.o(66047);
        return false;
      }
      ad.d("MicroMsg.FunctionListAdapter", "still old news and should show");
      AppMethodBeat.o(66047);
      return true;
    }
    AppMethodBeat.o(66047);
    return false;
  }
  
  private boolean dkg()
  {
    AppMethodBeat.i(66044);
    if (this.vDW.size() > 3)
    {
      Object localObject = (ArrayList)this.vDW.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).vEA.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.vEA.type == i) {
            if (a(localc.vEA))
            {
              AppMethodBeat.o(66044);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66044);
    return false;
  }
  
  private View u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66041);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(2131494693, paramViewGroup, false);
    locala.vEg = paramViewGroup.findViewById(2131302017);
    locala.vEh = ((ImageView)paramViewGroup.findViewById(2131302014));
    locala.vEj = ((TextView)paramViewGroup.findViewById(2131302019));
    locala.vEk = ((TextView)paramViewGroup.findViewById(2131302013));
    locala.vEi = ((ImageView)paramViewGroup.findViewById(2131302795));
    locala.vEn = ((ImageView)paramViewGroup.findViewById(2131299169));
    locala.vEo = ((ImageView)paramViewGroup.findViewById(2131299167));
    locala.vEp = ((ImageView)paramViewGroup.findViewById(2131299159));
    locala.vEq = ((ImageView)paramViewGroup.findViewById(2131299163));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  public final void aj(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.vDW.clear();
    if (paramArrayList != null)
    {
      int i = 0;
      ArrayList localArrayList;
      while (i < paramArrayList.size())
      {
        localArrayList = new ArrayList();
        int j = 0;
        while ((j < 3) && (i + j < paramArrayList.size()))
        {
          if (j > 0)
          {
            int k = i + j - 1;
            if ((k >= 0) && (((MallFunction)paramArrayList.get(k)).type != ((MallFunction)paramArrayList.get(i + j)).type)) {
              break;
            }
          }
          c localc = new c();
          localc.vEB = (i + j);
          localc.vEA = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.vDW.add(localArrayList);
        }
        i += j;
      }
      this.vDZ = 0;
      this.vEa = 0;
      paramArrayList = this.vDW.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).vEA.type))
        {
          this.vDZ += localArrayList.size();
          this.vEa += 1;
          i = ((c)localArrayList.get(0)).vEA.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.vEa -= 1;
      this.vDj = k.dka().JC(this.vDk).vDj;
      this.vEb = dkg();
      ad.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.vEb) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.vDW.size();
    AppMethodBeat.o(66037);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 3;
    AppMethodBeat.i(66039);
    boolean bool2 = JE(paramInt);
    if (this.vDZ > 9) {
      if (this.vEa <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.vDW.size())) {}
      for (boolean bool1 = JE(paramInt + 1);; bool1 = false)
      {
        if (bool2) {
          i = 1;
        }
        for (;;)
        {
          label74:
          View localView;
          if (paramView == null)
          {
            paramView = new b();
            localView = this.mInflater.inflate(2131494687, paramViewGroup, false);
            paramView.vEr = ((LinearLayout)localView.findViewById(2131302010));
            paramView.vEs = ((TextView)localView.findViewById(2131302009));
            paramView.vEt = localView.findViewById(2131299154);
            paramView.vEu = localView.findViewById(2131301426);
            paramView.vEv = localView.findViewById(2131302138);
            paramView.vEx = ((TextView)localView.findViewById(2131302139));
            paramView.vEw = ((ImageView)localView.findViewById(2131302137));
            paramView.vEy = localView.findViewById(2131302469);
            paramView.vEz = localView.findViewById(2131297448);
            paramView.vEv.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(66033);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                paramAnonymousView = b.this;
                if (!b.a(b.this)) {}
                for (boolean bool = true;; bool = false)
                {
                  b.a(paramAnonymousView, bool);
                  b.b(b.this);
                  b.this.notifyDataSetChanged();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(66033);
                  return;
                }
              }
            });
            localView.setTag(paramView);
            paramViewGroup = paramView;
            label244:
            if (!bool2) {
              break label629;
            }
            paramViewGroup.vEs.setVisibility(8);
            paramViewGroup.vEt.setVisibility(8);
            paramViewGroup.vEu.setVisibility(8);
            paramViewGroup.vEv.setVisibility(0);
            paramViewGroup.vEw.setImageResource(2131690517);
            paramViewGroup.vEw.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.vEw.setPivotX(paramViewGroup.vEw.getWidth() / 2);
            paramViewGroup.vEw.setPivotY(paramViewGroup.vEw.getHeight() / 2);
            paramViewGroup.vEw.setRotation(90.0F);
            paramViewGroup.vEx.setText(this.mContext.getString(2131761090));
            if ((!this.vEb) || (this.vEc)) {
              break label504;
            }
            paramViewGroup.vEy.setVisibility(0);
            label400:
            if (!this.vDY) {
              break label516;
            }
            paramViewGroup.vEr.setVisibility(8);
            paramViewGroup.vEx.setText(this.mContext.getString(2131761090));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.vEz.setBackgroundColor(e.dkH());
            paramViewGroup.vEz.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.vEa;
            break;
            if (!bool1) {
              break label761;
            }
            i = 2;
            break label74;
            paramViewGroup = (b)paramView.getTag();
            localView = paramView;
            break label244;
            label504:
            paramViewGroup.vEy.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.vEr.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.vEw.setImageResource(2131690517);
            paramViewGroup.vEw.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.vEw.setPivotX(paramViewGroup.vEw.getWidth() / 2);
            paramViewGroup.vEw.setPivotY(paramViewGroup.vEw.getHeight() / 2);
            paramViewGroup.vEw.setRotation(270.0F);
            paramViewGroup.vEx.setText(this.mContext.getString(2131761088));
            break label433;
            label629:
            if ((j > 0) && (this.vDY) && (paramInt >= j) && (paramInt <= this.vEa))
            {
              paramViewGroup.vEr.setVisibility(8);
              paramViewGroup.vEv.setVisibility(8);
              paramViewGroup.vEy.setVisibility(8);
              paramViewGroup.vEs.setVisibility(8);
              paramViewGroup.vEt.setVisibility(8);
              paramViewGroup.vEu.setVisibility(8);
              break label433;
            }
            paramViewGroup.vEr.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.vEv.setVisibility(8);
            paramViewGroup.vEy.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.vEz.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View vEg = null;
    public ImageView vEh = null;
    public ImageView vEi = null;
    public TextView vEj = null;
    public TextView vEk = null;
    public String vEl = null;
    public String vEm = null;
    public ImageView vEn = null;
    public ImageView vEo = null;
    public ImageView vEp = null;
    public ImageView vEq = null;
    
    a() {}
  }
  
  final class b
  {
    LinearLayout vEr;
    TextView vEs;
    View vEt;
    View vEu;
    View vEv;
    ImageView vEw;
    TextView vEx;
    View vEy = null;
    View vEz;
    
    b() {}
  }
  
  final class c
  {
    MallFunction vEA;
    int vEB;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, MallFunction paramMallFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */