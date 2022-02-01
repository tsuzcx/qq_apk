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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private final int vPX;
  private final int vPY;
  private final int vPZ;
  private SparseArray<String> vPn;
  private int vPo;
  List<ArrayList<c>> vQa;
  d vQb;
  private boolean vQc;
  private int vQd;
  private int vQe;
  private boolean vQf;
  private boolean vQg;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.vPX = 3;
    this.vPY = 9;
    this.vPZ = 3;
    this.vQa = new ArrayList();
    this.vPn = null;
    this.vQc = true;
    this.vQd = 0;
    this.vQe = 0;
    this.vQf = false;
    this.vQg = false;
    this.mContext = paramContext;
    this.vPo = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private boolean Kd(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.vQd > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.vQa.get(j)).size();
        j += 1;
      }
      if (this.vQe > 3)
      {
        j = 3;
        if (i < 9) {
          break label117;
        }
        if ((!this.vQc) || (paramInt != j)) {
          break label96;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.vQe;
      break;
      label96:
      if ((paramInt == this.vQe) && (!this.vQc)) {
        bool = true;
      } else {
        label117:
        bool = false;
      }
    }
  }
  
  private String Ke(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.vPn == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.vPn.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.vQa.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).vQE.type;
      localObject = Ke(m);
      j = 0;
      k = 0;
      if (bu.isNullOrNil((String)localObject)) {
        break label680;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.vQa.size() - 1) {
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
        paramb.vQw.setText((CharSequence)localObject);
        paramb.vQw.setVisibility(0);
        paramb.vQx.setVisibility(8);
        paramb.vQy.setVisibility(0);
        paramb.vQw.setMinHeight(a.dnc());
        paramb.vQy.setBackgroundColor(e.dnH());
        localObject = paramb.vQv;
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
        if (((ArrayList)this.vQa.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.vQa.get(paramInt1 - 1)).get(0)).vQE.type) {
          break;
        }
        i = 1;
        break;
        label355:
        j = i;
        if (m == ((c)((ArrayList)this.vQa.get(paramInt1 + 1)).get(0)).vQE.type) {
          break label680;
        }
        paramInt1 = 1;
        break label104;
        paramb.vQw.setVisibility(8);
        paramb.vQx.setVisibility(8);
        paramb.vQy.setVisibility(8);
        break label163;
        paramb.vQw.setVisibility(8);
        paramb.vQx.setVisibility(8);
        paramb.vQy.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label459:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.vQk.setVisibility(4);
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
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.dna(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.vQk.setVisibility(4);
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
    final MallFunction localMallFunction = paramc.vQE;
    final int i = paramc.vQF;
    locala.vQq = localMallFunction.vQq;
    locala.vQp = localMallFunction.vQp;
    com.tencent.mm.plugin.mall.b.a.d(locala.vQl, locala.vQp, 2131690773);
    locala.vQn.setText(localMallFunction.dLB);
    locala.vQm.setVisibility(8);
    if ((localMallFunction.DsT != null) && (!bu.isNullOrNil(localMallFunction.DsT.Dtb)) && (b(localMallFunction)))
    {
      if (d.eKF().aFY(localMallFunction.jFZ) != null)
      {
        ae.w("MicroMsg.FunctionListAdapter", "show the news : " + d.eKF().aFY(localMallFunction.jFZ).Dtb);
        locala.vQo.setText(localMallFunction.DsT.Dtb);
        locala.vQo.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.q(locala.vQm, locala.vQq);
        locala.vQm.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66034);
          }
        });
        locala.vQk.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.vQo.setVisibility(4);
      }
    }
    if ((localMallFunction.DsT != null) && (localMallFunction.DsT.Dtg == 1))
    {
      locala.vQo.setText(localMallFunction.DsT.Dtb);
      locala.vQo.setVisibility(0);
    }
    for (;;)
    {
      locala.vQm.setImageBitmap(null);
      locala.vQm.setVisibility(8);
      break;
      locala.vQo.setText("");
      locala.vQo.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.vQr.setVisibility(0);
    parama.vQs.setVisibility(4);
    parama.vQt.setVisibility(4);
    parama.vQu.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.vQu.setVisibility(4);
    if (paramInt1 == 0) {
      parama.vQs.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.vQr.setVisibility(0);
      parama.vQt.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.vQs.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.vQs.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.vQr.setVisibility(4);
      parama.vQt.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.vQr.setVisibility(0);
    parama.vQt.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.DsT != null) && (!bu.isNullOrNil(paramMallFunction.DsT.Dtb)) && (b(paramMallFunction)) && (d.eKF().aFY(paramMallFunction.jFZ) != null))
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
    MallNews localMallNews = d.eKF().aFY(paramMallFunction.jFZ);
    if ((localMallNews == null) || (bu.isNullOrNil(localMallNews.ByB)) || (!localMallNews.ByB.equals(paramMallFunction.DsT.ByB)))
    {
      ae.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.DsT.ByB, paramMallFunction.dLB });
      d.eKF().b(paramMallFunction.DsT);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.DsZ))
      {
        ae.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
        AppMethodBeat.o(66047);
        return false;
      }
      ae.d("MicroMsg.FunctionListAdapter", "still old news and should show");
      AppMethodBeat.o(66047);
      return true;
    }
    AppMethodBeat.o(66047);
    return false;
  }
  
  private boolean dnf()
  {
    AppMethodBeat.i(66044);
    if (this.vQa.size() > 3)
    {
      Object localObject = (ArrayList)this.vQa.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).vQE.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.vQE.type == i) {
            if (a(localc.vQE))
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
    locala.vQk = paramViewGroup.findViewById(2131302017);
    locala.vQl = ((ImageView)paramViewGroup.findViewById(2131302014));
    locala.vQn = ((TextView)paramViewGroup.findViewById(2131302019));
    locala.vQo = ((TextView)paramViewGroup.findViewById(2131302013));
    locala.vQm = ((ImageView)paramViewGroup.findViewById(2131302795));
    locala.vQr = ((ImageView)paramViewGroup.findViewById(2131299169));
    locala.vQs = ((ImageView)paramViewGroup.findViewById(2131299167));
    locala.vQt = ((ImageView)paramViewGroup.findViewById(2131299159));
    locala.vQu = ((ImageView)paramViewGroup.findViewById(2131299163));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  public final void aj(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.vQa.clear();
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
          localc.vQF = (i + j);
          localc.vQE = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.vQa.add(localArrayList);
        }
        i += j;
      }
      this.vQd = 0;
      this.vQe = 0;
      paramArrayList = this.vQa.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).vQE.type))
        {
          this.vQd += localArrayList.size();
          this.vQe += 1;
          i = ((c)localArrayList.get(0)).vQE.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.vQe -= 1;
      this.vPn = k.dmZ().Kb(this.vPo).vPn;
      this.vQf = dnf();
      ae.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.vQf) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.vQa.size();
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
    boolean bool2 = Kd(paramInt);
    if (this.vQd > 9) {
      if (this.vQe <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.vQa.size())) {}
      for (boolean bool1 = Kd(paramInt + 1);; bool1 = false)
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
            paramView.vQv = ((LinearLayout)localView.findViewById(2131302010));
            paramView.vQw = ((TextView)localView.findViewById(2131302009));
            paramView.vQx = localView.findViewById(2131299154);
            paramView.vQy = localView.findViewById(2131301426);
            paramView.vQz = localView.findViewById(2131302138);
            paramView.vQB = ((TextView)localView.findViewById(2131302139));
            paramView.vQA = ((ImageView)localView.findViewById(2131302137));
            paramView.vQC = localView.findViewById(2131302469);
            paramView.vQD = localView.findViewById(2131297448);
            paramView.vQz.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(66033);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
            paramViewGroup.vQw.setVisibility(8);
            paramViewGroup.vQx.setVisibility(8);
            paramViewGroup.vQy.setVisibility(8);
            paramViewGroup.vQz.setVisibility(0);
            paramViewGroup.vQA.setImageResource(2131690517);
            paramViewGroup.vQA.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.vQA.setPivotX(paramViewGroup.vQA.getWidth() / 2);
            paramViewGroup.vQA.setPivotY(paramViewGroup.vQA.getHeight() / 2);
            paramViewGroup.vQA.setRotation(90.0F);
            paramViewGroup.vQB.setText(this.mContext.getString(2131761090));
            if ((!this.vQf) || (this.vQg)) {
              break label504;
            }
            paramViewGroup.vQC.setVisibility(0);
            label400:
            if (!this.vQc) {
              break label516;
            }
            paramViewGroup.vQv.setVisibility(8);
            paramViewGroup.vQB.setText(this.mContext.getString(2131761090));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.vQD.setBackgroundColor(e.dnH());
            paramViewGroup.vQD.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.vQe;
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
            paramViewGroup.vQC.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.vQv.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.vQA.setImageResource(2131690517);
            paramViewGroup.vQA.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.vQA.setPivotX(paramViewGroup.vQA.getWidth() / 2);
            paramViewGroup.vQA.setPivotY(paramViewGroup.vQA.getHeight() / 2);
            paramViewGroup.vQA.setRotation(270.0F);
            paramViewGroup.vQB.setText(this.mContext.getString(2131761088));
            break label433;
            label629:
            if ((j > 0) && (this.vQc) && (paramInt >= j) && (paramInt <= this.vQe))
            {
              paramViewGroup.vQv.setVisibility(8);
              paramViewGroup.vQz.setVisibility(8);
              paramViewGroup.vQC.setVisibility(8);
              paramViewGroup.vQw.setVisibility(8);
              paramViewGroup.vQx.setVisibility(8);
              paramViewGroup.vQy.setVisibility(8);
              break label433;
            }
            paramViewGroup.vQv.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.vQz.setVisibility(8);
            paramViewGroup.vQC.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.vQD.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View vQk = null;
    public ImageView vQl = null;
    public ImageView vQm = null;
    public TextView vQn = null;
    public TextView vQo = null;
    public String vQp = null;
    public String vQq = null;
    public ImageView vQr = null;
    public ImageView vQs = null;
    public ImageView vQt = null;
    public ImageView vQu = null;
    
    a() {}
  }
  
  final class b
  {
    ImageView vQA;
    TextView vQB;
    View vQC = null;
    View vQD;
    LinearLayout vQv;
    TextView vQw;
    View vQx;
    View vQy;
    View vQz;
    
    b() {}
  }
  
  final class c
  {
    MallFunction vQE;
    int vQF;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, MallFunction paramMallFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */