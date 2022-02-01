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
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private SparseArray<String> EOI;
  private int EOJ;
  private boolean EPA;
  private final int EPr;
  private final int EPs;
  private final int EPt;
  List<ArrayList<c>> EPu;
  d EPv;
  private boolean EPw;
  private int EPx;
  private int EPy;
  private boolean EPz;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.EPr = 3;
    this.EPs = 9;
    this.EPt = 3;
    this.EPu = new ArrayList();
    this.EOI = null;
    this.EPw = true;
    this.EPx = 0;
    this.EPy = 0;
    this.EPz = false;
    this.EPA = false;
    this.mContext = paramContext;
    this.EOJ = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private View F(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66041);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(a.g.mall_index_function_item, paramViewGroup, false);
    locala.EPE = paramViewGroup.findViewById(a.f.mall_index_function_item_main);
    locala.EPF = ((ImageView)paramViewGroup.findViewById(a.f.mall_index_function_icon));
    locala.EPH = ((TextView)paramViewGroup.findViewById(a.f.mall_index_function_name));
    locala.EPI = ((TextView)paramViewGroup.findViewById(a.f.mall_index_function_activity));
    locala.EPG = ((ImageView)paramViewGroup.findViewById(a.f.new_pic_holder));
    locala.EPL = ((ImageView)paramViewGroup.findViewById(a.f.divider_top));
    locala.EPM = ((ImageView)paramViewGroup.findViewById(a.f.divider_right));
    locala.EPN = ((ImageView)paramViewGroup.findViewById(a.f.divider_bottom));
    locala.EPO = ((ImageView)paramViewGroup.findViewById(a.f.divider_left));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  private boolean Wr(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.EPx > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.EPu.get(j)).size();
        j += 1;
      }
      if (this.EPy > 3)
      {
        j = 3;
        if (i < 9) {
          break label117;
        }
        if ((!this.EPw) || (paramInt != j)) {
          break label96;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.EPy;
      break;
      label96:
      if ((paramInt == this.EPy) && (!this.EPw)) {
        bool = true;
      } else {
        label117:
        bool = false;
      }
    }
  }
  
  private String Ws(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.EOI == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.EOI.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.EPu.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).EPY.type;
      localObject = Ws(m);
      j = 0;
      k = 0;
      if (Util.isNullOrNil((String)localObject)) {
        break label683;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.EPu.size() - 1) {
          break label356;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label104:
      if (i != 0)
      {
        paramb.EPQ.setText((CharSequence)localObject);
        paramb.EPQ.setVisibility(0);
        paramb.EPR.setVisibility(8);
        paramb.EPS.setVisibility(0);
        paramb.EPQ.setMinHeight(a.eQu());
        paramb.EPS.setBackgroundColor(e.eRa());
        localObject = paramb.EPP;
        ((LinearLayout)localObject).setFocusable(true);
        i = 0;
        if (i >= 3) {
          break label677;
        }
        if ((i >= ((LinearLayout)localObject).getChildCount()) || (((LinearLayout)localObject).getChildAt(i) == null)) {
          break label524;
        }
        paramb = ((LinearLayout)localObject).getChildAt(i);
        paramb.setVisibility(0);
        if (i >= localList.size()) {
          break label460;
        }
        a(paramb, (c)localList.get(i), i, paramInt2);
        label249:
        if ((paramInt2 != 0) || (paramInt1 == 0)) {
          break label657;
        }
        if (i != 0) {
          break label631;
        }
        paramb.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_bottomleft_selector));
      }
      label524:
      label657:
      for (;;)
      {
        label163:
        label178:
        i += 1;
        break label178;
        i = k;
        if (((ArrayList)this.EPu.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.EPu.get(paramInt1 - 1)).get(0)).EPY.type) {
          break;
        }
        i = 1;
        break;
        label356:
        j = i;
        if (m == ((c)((ArrayList)this.EPu.get(paramInt1 + 1)).get(0)).EPY.type) {
          break label683;
        }
        paramInt1 = 1;
        break label104;
        paramb.EPQ.setVisibility(8);
        paramb.EPR.setVisibility(8);
        paramb.EPS.setVisibility(8);
        break label163;
        paramb.EPQ.setVisibility(8);
        paramb.EPR.setVisibility(8);
        paramb.EPS.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label460:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.EPE.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = F((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.eQs(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.EPE.setVisibility(4);
          paramb.setOnClickListener(null);
          paramb.setEnabled(false);
          paramb.setClickable(false);
          a(locala);
        }
        label631:
        if (i != 1) {
          paramb.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_bottomright_selector));
        } else {
          paramb.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_selector));
        }
      }
      label677:
      AppMethodBeat.o(66040);
      return;
      label683:
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
    final MallFunction localMallFunction = paramc.EPY;
    final int i = paramc.EPZ;
    locala.EPK = localMallFunction.EPK;
    locala.EPJ = localMallFunction.EPJ;
    com.tencent.mm.plugin.mall.b.a.f(locala.EPF, locala.EPJ, a.h.mall_index_icon_default);
    locala.EPH.setText(localMallFunction.fXz);
    locala.EPG.setVisibility(8);
    if ((localMallFunction.OUr != null) && (!Util.isNullOrNil(localMallFunction.OUr.OUz)) && (b(localMallFunction)))
    {
      if (d.gKP().bhg(localMallFunction.nBK) != null)
      {
        Log.w("MicroMsg.FunctionListAdapter", "show the news : " + d.gKP().bhg(localMallFunction.nBK).OUz);
        locala.EPI.setText(localMallFunction.OUr.OUz);
        locala.EPI.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.s(locala.EPG, locala.EPK);
        locala.EPG.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66034);
          }
        });
        locala.EPE.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.EPI.setVisibility(4);
      }
    }
    if ((localMallFunction.OUr != null) && (localMallFunction.OUr.OUD == 1))
    {
      locala.EPI.setText(localMallFunction.OUr.OUz);
      locala.EPI.setVisibility(0);
    }
    for (;;)
    {
      locala.EPG.setImageBitmap(null);
      locala.EPG.setVisibility(8);
      break;
      locala.EPI.setText("");
      locala.EPI.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.EPL.setVisibility(0);
    parama.EPM.setVisibility(4);
    parama.EPN.setVisibility(4);
    parama.EPO.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.EPO.setVisibility(4);
    if (paramInt1 == 0) {
      parama.EPM.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.EPL.setVisibility(0);
      parama.EPN.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.EPM.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.EPM.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.EPL.setVisibility(4);
      parama.EPN.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.EPL.setVisibility(0);
    parama.EPN.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.OUr != null) && (!Util.isNullOrNil(paramMallFunction.OUr.OUz)) && (b(paramMallFunction)) && (d.gKP().bhg(paramMallFunction.nBK) != null))
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
    MallNews localMallNews = d.gKP().bhg(paramMallFunction.nBK);
    if ((localMallNews == null) || (Util.isNullOrNil(localMallNews.oym)) || (!localMallNews.oym.equals(paramMallFunction.OUr.oym)))
    {
      Log.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.OUr.oym, paramMallFunction.fXz });
      d.gKP().b(paramMallFunction.OUr);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.OUx))
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
  
  private boolean eQx()
  {
    AppMethodBeat.i(66044);
    if (this.EPu.size() > 3)
    {
      Object localObject = (ArrayList)this.EPu.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).EPY.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.EPY.type == i) {
            if (a(localc.EPY))
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
  
  public final void aE(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.EPu.clear();
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
          localc.EPZ = (i + j);
          localc.EPY = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.EPu.add(localArrayList);
        }
        i += j;
      }
      this.EPx = 0;
      this.EPy = 0;
      paramArrayList = this.EPu.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).EPY.type))
        {
          this.EPx += localArrayList.size();
          this.EPy += 1;
          i = ((c)localArrayList.get(0)).EPY.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.EPy -= 1;
      this.EOI = k.eQr().Wp(this.EOJ).EOI;
      this.EPz = eQx();
      Log.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.EPz) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.EPu.size();
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
    boolean bool2 = Wr(paramInt);
    if (this.EPx > 9) {
      if (this.EPy <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.EPu.size())) {}
      for (boolean bool1 = Wr(paramInt + 1);; bool1 = false)
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
            localView = this.mInflater.inflate(a.g.mall_function_list_line, paramViewGroup, false);
            paramView.EPP = ((LinearLayout)localView.findViewById(a.f.mall_function_list_line_container));
            paramView.EPQ = ((TextView)localView.findViewById(a.f.mall_fucntion_list_section_title));
            paramView.EPR = localView.findViewById(a.f.divider);
            paramView.EPS = localView.findViewById(a.f.line_margin);
            paramView.EPT = localView.findViewById(a.f.mall_show_more_function_switch);
            paramView.EPV = ((TextView)localView.findViewById(a.f.mall_show_more_tv));
            paramView.EPU = ((ImageView)localView.findViewById(a.f.mall_show_more_arrow));
            paramView.EPW = localView.findViewById(a.f.more_function_reddot);
            paramView.EPX = localView.findViewById(a.f.bottom_gap);
            paramView.EPT.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(66033);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
            paramViewGroup.EPQ.setVisibility(8);
            paramViewGroup.EPR.setVisibility(8);
            paramViewGroup.EPS.setVisibility(8);
            paramViewGroup.EPT.setVisibility(0);
            paramViewGroup.EPU.setImageResource(a.h.icons_outlined_arrow);
            paramViewGroup.EPU.setColorFilter(this.mContext.getResources().getColor(a.c.link_color), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.EPU.setPivotX(paramViewGroup.EPU.getWidth() / 2);
            paramViewGroup.EPU.setPivotY(paramViewGroup.EPU.getHeight() / 2);
            paramViewGroup.EPU.setRotation(90.0F);
            paramViewGroup.EPV.setText(this.mContext.getString(a.i.mall_index_show_more));
            if ((!this.EPz) || (this.EPA)) {
              break label504;
            }
            paramViewGroup.EPW.setVisibility(0);
            label400:
            if (!this.EPw) {
              break label516;
            }
            paramViewGroup.EPP.setVisibility(8);
            paramViewGroup.EPV.setText(this.mContext.getString(a.i.mall_index_show_more));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.EPX.setBackgroundColor(e.eRa());
            paramViewGroup.EPX.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.EPy;
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
            paramViewGroup.EPW.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.EPP.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.EPU.setImageResource(a.h.icons_outlined_arrow);
            paramViewGroup.EPU.setColorFilter(this.mContext.getResources().getColor(a.c.link_color), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.EPU.setPivotX(paramViewGroup.EPU.getWidth() / 2);
            paramViewGroup.EPU.setPivotY(paramViewGroup.EPU.getHeight() / 2);
            paramViewGroup.EPU.setRotation(270.0F);
            paramViewGroup.EPV.setText(this.mContext.getString(a.i.mall_index_hide_more));
            break label433;
            label629:
            if ((j > 0) && (this.EPw) && (paramInt >= j) && (paramInt <= this.EPy))
            {
              paramViewGroup.EPP.setVisibility(8);
              paramViewGroup.EPT.setVisibility(8);
              paramViewGroup.EPW.setVisibility(8);
              paramViewGroup.EPQ.setVisibility(8);
              paramViewGroup.EPR.setVisibility(8);
              paramViewGroup.EPS.setVisibility(8);
              break label433;
            }
            paramViewGroup.EPP.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.EPT.setVisibility(8);
            paramViewGroup.EPW.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.EPX.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View EPE = null;
    public ImageView EPF = null;
    public ImageView EPG = null;
    public TextView EPH = null;
    public TextView EPI = null;
    public String EPJ = null;
    public String EPK = null;
    public ImageView EPL = null;
    public ImageView EPM = null;
    public ImageView EPN = null;
    public ImageView EPO = null;
    
    a() {}
  }
  
  final class b
  {
    LinearLayout EPP;
    TextView EPQ;
    View EPR;
    View EPS;
    View EPT;
    ImageView EPU;
    TextView EPV;
    View EPW = null;
    View EPX;
    
    b() {}
  }
  
  final class c
  {
    MallFunction EPY;
    int EPZ;
    
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