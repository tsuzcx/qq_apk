package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.fhm;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private SparseArray<String> EOI;
  private final int EPr;
  List<ArrayList<c>> EPu;
  d EQa;
  private boolean EQb;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(276958);
    this.EPr = 4;
    this.EPu = new ArrayList();
    this.EOI = null;
    this.EQb = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(276958);
  }
  
  private void a(View paramView, c paramc)
  {
    AppMethodBeat.i(276965);
    if (paramView == null)
    {
      AppMethodBeat.o(276965);
      return;
    }
    paramView = (a)paramView.getTag();
    final bmw localbmw = paramc.EQf;
    final int i = paramc.EPZ;
    if (ar.isDarkMode())
    {
      paramView.iconUrl = localbmw.SXF.UHB.UHH;
      com.tencent.mm.plugin.mall.b.a.f(paramView.EPF, paramView.iconUrl, a.h.mall_index_icon_default);
      paramView.EPH.setText(localbmw.SXF.CMP);
      n(paramView.EPH, a.eQv());
      if (localbmw.SXL == null) {
        break label303;
      }
      paramView.EPI.setText(localbmw.SXL);
      paramView.EPI.setVisibility(0);
      n(paramView.EPI, a.eQv());
      this.EQb = true;
      label137:
      if ((localbmw.SXG == null) || (localbmw.SXG.UHu == null) || (!b(localbmw))) {
        break label342;
      }
      if (!ar.isDarkMode()) {
        break label324;
      }
      paramView.EPK = localbmw.SXG.UHu.UHH;
      label185:
      com.tencent.mm.plugin.mall.b.a.s(paramView.EPG, paramView.EPK);
      paramView.EPG.setVisibility(0);
      ((RelativeLayout.LayoutParams)paramView.EPG.getLayoutParams()).setMargins(a.eQv() / 2 - 1, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 7), 0, 0);
      new StringBuilder().append(localbmw.SXF.UHA);
    }
    for (;;)
    {
      paramView.EPE.setVisibility(0);
      paramView.EPE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233311);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.v("MicroMsg.FunctionListAdapterNew", "on Click");
          if (c.a(c.this) != null) {
            c.a(c.this).a(i, localbmw);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233311);
        }
      });
      AppMethodBeat.o(276965);
      return;
      paramView.iconUrl = localbmw.SXF.UHB.UHG;
      break;
      label303:
      paramView.EPI.setText("");
      paramView.EPI.setVisibility(8);
      break label137;
      label324:
      paramView.EPK = localbmw.SXG.UHu.UHG;
      break label185;
      label342:
      paramView.EPG.setImageBitmap(null);
      paramView.EPG.setVisibility(8);
    }
  }
  
  public static boolean a(bmw parambmw)
  {
    AppMethodBeat.i(276966);
    if ((parambmw.SXG != null) && (parambmw.SXG.UHu != null) && (b(parambmw)) && (d.gKP().bhg(parambmw.SXF.UHA) != null))
    {
      AppMethodBeat.o(276966);
      return true;
    }
    AppMethodBeat.o(276966);
    return false;
  }
  
  private static boolean b(bmw parambmw)
  {
    AppMethodBeat.i(276967);
    MallNews localMallNews = d.gKP().bhg(parambmw.SXF.UHA);
    if ((localMallNews == null) || (Util.isNullOrNil(localMallNews.oym)) || (!localMallNews.oym.equals(parambmw.SXG.UHt)))
    {
      Log.d("MicroMsg.FunctionListAdapterNew", "old news null or should be replaced %s %s", new Object[] { Integer.valueOf(parambmw.SXG.UHt), parambmw.SXF.CMP });
      localMallNews = new MallNews(parambmw.SXF.UHA);
      localMallNews.oym = parambmw.SXG.UHt;
      d.gKP().b(localMallNews);
      AppMethodBeat.o(276967);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.OUx))
      {
        Log.d("MicroMsg.FunctionListAdapterNew", "still old news or clicked, then should not show");
        AppMethodBeat.o(276967);
        return false;
      }
      Log.d("MicroMsg.FunctionListAdapterNew", "still old news and should show");
      AppMethodBeat.o(276967);
      return true;
    }
    AppMethodBeat.o(276967);
    return false;
  }
  
  private static void n(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(276969);
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView.setMaxEms(new StaticLayout(paramTextView.getText(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0));
    AppMethodBeat.o(276969);
  }
  
  public final void aE(ArrayList<bmw> paramArrayList)
  {
    AppMethodBeat.i(276959);
    this.EPu.clear();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while ((j < 4) && (i + j < paramArrayList.size()))
        {
          if (j > 0)
          {
            int k = i + j - 1;
            if ((k >= 0) && (((bmw)paramArrayList.get(k)).SXM != ((bmw)paramArrayList.get(i + j)).SXM)) {
              break;
            }
          }
          c localc = new c();
          localc.EPZ = (i + j);
          localc.EQf = ((bmw)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.EPu.add(localArrayList);
        }
        i += j;
      }
    }
    this.EOI = com.tencent.mm.plugin.wallet_core.model.mall.b.gKF();
    notifyDataSetChanged();
    AppMethodBeat.o(276959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(276961);
    int i = this.EPu.size();
    AppMethodBeat.o(276961);
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
    AppMethodBeat.i(276964);
    Object localObject1;
    List localList;
    int m;
    label172:
    int k;
    int j;
    int i;
    if (paramView == null)
    {
      paramView = new b();
      localObject1 = this.mInflater.inflate(a.g.mall_function_list_line_v2, paramViewGroup, false);
      paramView.EPP = ((LinearLayout)((View)localObject1).findViewById(a.f.mall_function_list_line_container));
      paramView.EPQ = ((TextView)((View)localObject1).findViewById(a.f.mall_fucntion_list_section_title));
      paramView.EPS = ((View)localObject1).findViewById(a.f.line_margin);
      paramView.EPX = ((View)localObject1).findViewById(a.f.bottom_gap);
      paramView.EQe = ((View)localObject1).findViewById(a.f.normal_bottom_gap);
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      paramViewGroup.EPP.setVisibility(0);
      localList = (List)this.EPu.get(paramInt);
      if (localList.size() <= 0) {
        break label732;
      }
      m = ((c)localList.get(0)).EQf.SXM;
      if (this.EOI != null) {
        break label579;
      }
      localObject1 = null;
      k = 0;
      j = 0;
      if (Util.isNullOrNil((String)localObject1)) {
        break label1321;
      }
      if (paramInt != 0) {
        break label596;
      }
      i = 1;
      label193:
      if (paramInt != this.EPu.size() - 1) {
        break label664;
      }
      j = 1;
    }
    for (;;)
    {
      label211:
      LinearLayout localLinearLayout;
      label315:
      label347:
      Object localObject2;
      if (i != 0)
      {
        paramViewGroup.EPQ.setText((CharSequence)localObject1);
        paramViewGroup.EPQ.setVisibility(0);
        paramViewGroup.EPS.setVisibility(0);
        localObject1 = paramViewGroup.EPS.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8) * a.eQw()));
        paramViewGroup.EPS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.EPQ.setMinHeight((int)(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 48) * a.eQw()));
        paramViewGroup.EPS.setBackgroundColor(e.eRa());
        i = j;
        localLinearLayout = paramViewGroup.EPP;
        localLinearLayout.setFocusable(true);
        localLinearLayout.setPadding(a.eQu() / 2, 0, a.eQu() / 2, 0);
        j = 0;
        if (j >= 4) {
          break label1241;
        }
        if ((j >= localLinearLayout.getChildCount()) || (localLinearLayout.getChildAt(j) == null)) {
          break label813;
        }
        localObject1 = localLinearLayout.getChildAt(j);
        ((View)localObject1).setVisibility(0);
        if (j >= localList.size()) {
          break label756;
        }
        a((View)localObject1, (c)localList.get(j));
        label418:
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).width = (a.eQv() + a.eQu());
        ((View)localObject1).setMinimumHeight(a.eQs());
        ((View)localObject1).setPadding(a.eQu() / 2, 0, a.eQu() / 2, 0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (i == 0) {
          break label1169;
        }
        if (j != 0) {
          break label1066;
        }
        ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_bottomleft_selector));
        localObject1 = paramViewGroup.EQe.getLayoutParams();
        if (!this.EQb) {
          break label1049;
        }
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8);
        label530:
        paramViewGroup.EQe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.EQe.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_line_bg_last));
      }
      for (;;)
      {
        j += 1;
        break label347;
        paramViewGroup = (b)paramView.getTag();
        break;
        label579:
        localObject1 = (String)this.EOI.get(m);
        break label172;
        label596:
        i = j;
        if (((ArrayList)this.EPu.get(paramInt - 1)).size() <= 0) {
          break label193;
        }
        i = j;
        if (m == ((c)((ArrayList)this.EPu.get(paramInt - 1)).get(0)).EQf.SXM) {
          break label193;
        }
        i = 1;
        break label193;
        label664:
        k = i;
        if (m == ((c)((ArrayList)this.EPu.get(paramInt + 1)).get(0)).EQf.SXM) {
          break label1321;
        }
        j = 1;
        break label211;
        paramViewGroup.EPQ.setVisibility(8);
        paramViewGroup.EPS.setVisibility(8);
        i = j;
        break label315;
        label732:
        paramViewGroup.EPQ.setVisibility(8);
        paramViewGroup.EPS.setVisibility(8);
        i = 0;
        break label315;
        label756:
        localLinearLayout.getChildAt(j).setFocusable(true);
        localLinearLayout.getChildAt(j).setOnClickListener(null);
        ((a)localLinearLayout.getChildAt(j).getTag()).EPE.setVisibility(4);
        ((View)localObject1).setEnabled(false);
        ((View)localObject1).setClickable(false);
        break label418;
        label813:
        localObject2 = new a();
        localObject1 = this.mInflater.inflate(a.g.mall_index_function_item_v2, localLinearLayout, false);
        ((a)localObject2).EPE = ((View)localObject1).findViewById(a.f.mall_index_function_item_main);
        ((a)localObject2).EPF = ((ImageView)((View)localObject1).findViewById(a.f.mall_index_function_icon));
        ((a)localObject2).EPH = ((TextView)((View)localObject1).findViewById(a.f.mall_index_function_name));
        ((a)localObject2).EPI = ((TextView)((View)localObject1).findViewById(a.f.mall_index_function_activity));
        ((a)localObject2).EPG = ((ImageView)((View)localObject1).findViewById(a.f.new_pic_holder));
        ((View)localObject1).setTag(localObject2);
        if (j < localList.size()) {
          a((View)localObject1, (c)localList.get(j));
        }
        for (;;)
        {
          localObject2 = new LinearLayout.LayoutParams(a.eQv() + a.eQu(), -1, 1.0F);
          ((View)localObject1).setMinimumHeight(a.eQs());
          ((View)localObject1).setPadding(a.eQu() / 2, 0, a.eQu() / 2, 0);
          localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          break;
          ((View)localObject1).setFocusable(true);
          ((a)((View)localObject1).getTag()).EPE.setVisibility(4);
          ((View)localObject1).setOnClickListener(null);
          ((View)localObject1).setEnabled(false);
          ((View)localObject1).setClickable(false);
        }
        label1049:
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16);
        break label530;
        label1066:
        if (j != 1)
        {
          ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_bottomright_selector));
          localObject1 = paramViewGroup.EQe.getLayoutParams();
          if (this.EQb) {}
          for (((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8);; ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16))
          {
            paramViewGroup.EQe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.EQe.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_line_bg_last));
            break;
          }
        }
        label1169:
        ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_selector));
        localObject1 = paramViewGroup.EQe.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 4);
        paramViewGroup.EQe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.EQe.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_line_bg_normal));
      }
      label1241:
      if (paramInt == getCount() - 1)
      {
        paramViewGroup.EPX.setBackgroundColor(e.eRa());
        paramViewGroup.EPX.setVisibility(0);
        localObject1 = paramViewGroup.EPX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12);
        paramViewGroup.EPX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(276964);
        return paramView;
        paramViewGroup.EPX.setVisibility(8);
      }
      label1321:
      j = 0;
      i = k;
    }
  }
  
  final class a
  {
    public View EPE = null;
    public ImageView EPF = null;
    public ImageView EPG = null;
    public TextView EPH = null;
    public TextView EPI = null;
    public String EPK = null;
    public String iconUrl = null;
    
    a() {}
  }
  
  final class b
  {
    LinearLayout EPP;
    TextView EPQ;
    View EPS;
    View EPX;
    View EQe;
    
    b() {}
  }
  
  final class c
  {
    int EPZ;
    bmw EQf;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, bmw parambmw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */