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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private SparseArray<String> zjr;
  private int zjs;
  private final int zkb;
  private final int zkc;
  private final int zkd;
  List<ArrayList<c>> zke;
  d zkf;
  private boolean zkg;
  private int zkh;
  private int zki;
  private boolean zkj;
  private boolean zkk;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.zkb = 3;
    this.zkc = 9;
    this.zkd = 3;
    this.zke = new ArrayList();
    this.zjr = null;
    this.zkg = true;
    this.zkh = 0;
    this.zki = 0;
    this.zkj = false;
    this.zkk = false;
    this.mContext = paramContext;
    this.zjs = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private boolean Qf(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.zkh > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.zke.get(j)).size();
        j += 1;
      }
      if (this.zki > 3)
      {
        j = 3;
        if (i < 9) {
          break label117;
        }
        if ((!this.zkg) || (paramInt != j)) {
          break label96;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.zki;
      break;
      label96:
      if ((paramInt == this.zki) && (!this.zkg)) {
        bool = true;
      } else {
        label117:
        bool = false;
      }
    }
  }
  
  private String Qg(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.zjr == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.zjr.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.zke.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).zkI.type;
      localObject = Qg(m);
      j = 0;
      k = 0;
      if (Util.isNullOrNil((String)localObject)) {
        break label680;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.zke.size() - 1) {
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
        paramb.zkA.setText((CharSequence)localObject);
        paramb.zkA.setVisibility(0);
        paramb.zkB.setVisibility(8);
        paramb.zkC.setVisibility(0);
        paramb.zkA.setMinHeight(a.egO());
        paramb.zkC.setBackgroundColor(e.eht());
        localObject = paramb.zkz;
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
        paramb.setBackground(this.mContext.getResources().getDrawable(2131233856));
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
        if (((ArrayList)this.zke.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.zke.get(paramInt1 - 1)).get(0)).zkI.type) {
          break;
        }
        i = 1;
        break;
        label355:
        j = i;
        if (m == ((c)((ArrayList)this.zke.get(paramInt1 + 1)).get(0)).zkI.type) {
          break label680;
        }
        paramInt1 = 1;
        break label104;
        paramb.zkA.setVisibility(8);
        paramb.zkB.setVisibility(8);
        paramb.zkC.setVisibility(8);
        break label163;
        paramb.zkA.setVisibility(8);
        paramb.zkB.setVisibility(8);
        paramb.zkC.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label459:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.zko.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = z((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.egM(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.zko.setVisibility(4);
          paramb.setOnClickListener(null);
          paramb.setEnabled(false);
          paramb.setClickable(false);
          a(locala);
        }
        label630:
        if (i != 1) {
          paramb.setBackground(this.mContext.getResources().getDrawable(2131233857));
        } else {
          paramb.setBackground(this.mContext.getResources().getDrawable(2131233860));
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
    final MallFunction localMallFunction = paramc.zkI;
    final int i = paramc.zkJ;
    locala.zku = localMallFunction.zku;
    locala.zkt = localMallFunction.zkt;
    com.tencent.mm.plugin.mall.b.a.d(locala.zkp, locala.zkt, 2131691057);
    locala.zkr.setText(localMallFunction.edq);
    locala.zkq.setVisibility(8);
    if ((localMallFunction.Icf != null) && (!Util.isNullOrNil(localMallFunction.Icf.Icn)) && (b(localMallFunction)))
    {
      if (d.fSk().aVx(localMallFunction.kHR) != null)
      {
        Log.w("MicroMsg.FunctionListAdapter", "show the news : " + d.fSk().aVx(localMallFunction.kHR).Icn);
        locala.zks.setText(localMallFunction.Icf.Icn);
        locala.zks.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.t(locala.zkq, locala.zku);
        locala.zkq.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66034);
          }
        });
        locala.zko.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.zks.setVisibility(4);
      }
    }
    if ((localMallFunction.Icf != null) && (localMallFunction.Icf.Icr == 1))
    {
      locala.zks.setText(localMallFunction.Icf.Icn);
      locala.zks.setVisibility(0);
    }
    for (;;)
    {
      locala.zkq.setImageBitmap(null);
      locala.zkq.setVisibility(8);
      break;
      locala.zks.setText("");
      locala.zks.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.zkv.setVisibility(0);
    parama.zkw.setVisibility(4);
    parama.zkx.setVisibility(4);
    parama.zky.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.zky.setVisibility(4);
    if (paramInt1 == 0) {
      parama.zkw.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.zkv.setVisibility(0);
      parama.zkx.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.zkw.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.zkw.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.zkv.setVisibility(4);
      parama.zkx.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.zkv.setVisibility(0);
    parama.zkx.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.Icf != null) && (!Util.isNullOrNil(paramMallFunction.Icf.Icn)) && (b(paramMallFunction)) && (d.fSk().aVx(paramMallFunction.kHR) != null))
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
    MallNews localMallNews = d.fSk().aVx(paramMallFunction.kHR);
    if ((localMallNews == null) || (Util.isNullOrNil(localMallNews.FJm)) || (!localMallNews.FJm.equals(paramMallFunction.Icf.FJm)))
    {
      Log.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.Icf.FJm, paramMallFunction.edq });
      d.fSk().b(paramMallFunction.Icf);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.Icl))
      {
        Log.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
        AppMethodBeat.o(66047);
        return false;
      }
      Log.d("MicroMsg.FunctionListAdapter", "still old news and should show");
      AppMethodBeat.o(66047);
      return true;
    }
    AppMethodBeat.o(66047);
    return false;
  }
  
  private boolean egR()
  {
    AppMethodBeat.i(66044);
    if (this.zke.size() > 3)
    {
      Object localObject = (ArrayList)this.zke.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).zkI.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.zkI.type == i) {
            if (a(localc.zkI))
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
  
  private View z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66041);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(2131495420, paramViewGroup, false);
    locala.zko = paramViewGroup.findViewById(2131304356);
    locala.zkp = ((ImageView)paramViewGroup.findViewById(2131304353));
    locala.zkr = ((TextView)paramViewGroup.findViewById(2131304358));
    locala.zks = ((TextView)paramViewGroup.findViewById(2131304352));
    locala.zkq = ((ImageView)paramViewGroup.findViewById(2131305365));
    locala.zkv = ((ImageView)paramViewGroup.findViewById(2131299713));
    locala.zkw = ((ImageView)paramViewGroup.findViewById(2131299711));
    locala.zkx = ((ImageView)paramViewGroup.findViewById(2131299703));
    locala.zky = ((ImageView)paramViewGroup.findViewById(2131299707));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  public final void ax(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.zke.clear();
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
          localc.zkJ = (i + j);
          localc.zkI = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.zke.add(localArrayList);
        }
        i += j;
      }
      this.zkh = 0;
      this.zki = 0;
      paramArrayList = this.zke.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).zkI.type))
        {
          this.zkh += localArrayList.size();
          this.zki += 1;
          i = ((c)localArrayList.get(0)).zkI.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.zki -= 1;
      this.zjr = k.egL().Qd(this.zjs).zjr;
      this.zkj = egR();
      Log.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.zkj) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.zke.size();
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
    boolean bool2 = Qf(paramInt);
    if (this.zkh > 9) {
      if (this.zki <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.zke.size())) {}
      for (boolean bool1 = Qf(paramInt + 1);; bool1 = false)
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
            localView = this.mInflater.inflate(2131495413, paramViewGroup, false);
            paramView.zkz = ((LinearLayout)localView.findViewById(2131304349));
            paramView.zkA = ((TextView)localView.findViewById(2131304348));
            paramView.zkB = localView.findViewById(2131299682);
            paramView.zkC = localView.findViewById(2131303202);
            paramView.zkD = localView.findViewById(2131304477);
            paramView.zkF = ((TextView)localView.findViewById(2131304478));
            paramView.zkE = ((ImageView)localView.findViewById(2131304476));
            paramView.zkG = localView.findViewById(2131304879);
            paramView.zkH = localView.findViewById(2131297677);
            paramView.zkD.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(66033);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
            paramViewGroup.zkA.setVisibility(8);
            paramViewGroup.zkB.setVisibility(8);
            paramViewGroup.zkC.setVisibility(8);
            paramViewGroup.zkD.setVisibility(0);
            paramViewGroup.zkE.setImageResource(2131690737);
            paramViewGroup.zkE.setColorFilter(this.mContext.getResources().getColor(2131100685), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.zkE.setPivotX(paramViewGroup.zkE.getWidth() / 2);
            paramViewGroup.zkE.setPivotY(paramViewGroup.zkE.getHeight() / 2);
            paramViewGroup.zkE.setRotation(90.0F);
            paramViewGroup.zkF.setText(this.mContext.getString(2131762877));
            if ((!this.zkj) || (this.zkk)) {
              break label504;
            }
            paramViewGroup.zkG.setVisibility(0);
            label400:
            if (!this.zkg) {
              break label516;
            }
            paramViewGroup.zkz.setVisibility(8);
            paramViewGroup.zkF.setText(this.mContext.getString(2131762877));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.zkH.setBackgroundColor(e.eht());
            paramViewGroup.zkH.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.zki;
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
            paramViewGroup.zkG.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.zkz.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.zkE.setImageResource(2131690737);
            paramViewGroup.zkE.setColorFilter(this.mContext.getResources().getColor(2131100685), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.zkE.setPivotX(paramViewGroup.zkE.getWidth() / 2);
            paramViewGroup.zkE.setPivotY(paramViewGroup.zkE.getHeight() / 2);
            paramViewGroup.zkE.setRotation(270.0F);
            paramViewGroup.zkF.setText(this.mContext.getString(2131762875));
            break label433;
            label629:
            if ((j > 0) && (this.zkg) && (paramInt >= j) && (paramInt <= this.zki))
            {
              paramViewGroup.zkz.setVisibility(8);
              paramViewGroup.zkD.setVisibility(8);
              paramViewGroup.zkG.setVisibility(8);
              paramViewGroup.zkA.setVisibility(8);
              paramViewGroup.zkB.setVisibility(8);
              paramViewGroup.zkC.setVisibility(8);
              break label433;
            }
            paramViewGroup.zkz.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.zkD.setVisibility(8);
            paramViewGroup.zkG.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.zkH.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View zko = null;
    public ImageView zkp = null;
    public ImageView zkq = null;
    public TextView zkr = null;
    public TextView zks = null;
    public String zkt = null;
    public String zku = null;
    public ImageView zkv = null;
    public ImageView zkw = null;
    public ImageView zkx = null;
    public ImageView zky = null;
    
    a() {}
  }
  
  final class b
  {
    TextView zkA;
    View zkB;
    View zkC;
    View zkD;
    ImageView zkE;
    TextView zkF;
    View zkG = null;
    View zkH;
    LinearLayout zkz;
    
    b() {}
  }
  
  final class c
  {
    MallFunction zkI;
    int zkJ;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, MallFunction paramMallFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */