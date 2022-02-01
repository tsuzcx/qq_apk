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
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private final int vDT;
  List<ArrayList<c>> vDW;
  private SparseArray<String> vDj;
  d vEC;
  private boolean vED;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(199033);
    this.vDT = 4;
    this.vDW = new ArrayList();
    this.vDj = null;
    this.vED = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(199033);
  }
  
  private void a(View paramView, c paramc)
  {
    AppMethodBeat.i(199037);
    if (paramView == null)
    {
      AppMethodBeat.o(199037);
      return;
    }
    paramView = (a)paramView.getTag();
    final atw localatw = paramc.vEH;
    final int i = paramc.vEB;
    if (al.isDarkMode())
    {
      paramView.iconUrl = localatw.GrP.HNP.HNV;
      com.tencent.mm.plugin.mall.b.a.d(paramView.vEh, paramView.iconUrl, 2131690773);
      paramView.vEj.setText(localatw.GrP.Name);
      m(paramView.vEj, a.dke());
      if (localatw.GrV == null) {
        break label302;
      }
      paramView.vEk.setText(localatw.GrV);
      paramView.vEk.setVisibility(0);
      m(paramView.vEk, a.dke());
      this.vED = true;
      label136:
      if ((localatw.GrQ == null) || (localatw.GrQ.HNI == null) || (!b(localatw))) {
        break label341;
      }
      if (!al.isDarkMode()) {
        break label323;
      }
      paramView.vEm = localatw.GrQ.HNI.HNV;
      label184:
      com.tencent.mm.plugin.mall.b.a.q(paramView.vEi, paramView.vEm);
      paramView.vEi.setVisibility(0);
      ((RelativeLayout.LayoutParams)paramView.vEi.getLayoutParams()).setMargins(a.dke() / 2 - 1, com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 7), 0, 0);
      new StringBuilder().append(localatw.GrP.HNO);
    }
    for (;;)
    {
      paramView.vEg.setVisibility(0);
      paramView.vEg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199032);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.v("MicroMsg.FunctionListAdapterNew", "on Click");
          if (c.a(c.this) != null) {
            c.a(c.this).a(i, localatw);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199032);
        }
      });
      AppMethodBeat.o(199037);
      return;
      paramView.iconUrl = localatw.GrP.HNP.HNU;
      break;
      label302:
      paramView.vEk.setText("");
      paramView.vEk.setVisibility(8);
      break label136;
      label323:
      paramView.vEm = localatw.GrQ.HNI.HNU;
      break label184;
      label341:
      paramView.vEi.setImageBitmap(null);
      paramView.vEi.setVisibility(8);
    }
  }
  
  public static boolean a(atw paramatw)
  {
    AppMethodBeat.i(199038);
    if ((paramatw.GrQ != null) && (paramatw.GrQ.HNI != null) && (b(paramatw)) && (d.eGX().aEE(paramatw.GrP.HNO) != null))
    {
      AppMethodBeat.o(199038);
      return true;
    }
    AppMethodBeat.o(199038);
    return false;
  }
  
  private static boolean b(atw paramatw)
  {
    AppMethodBeat.i(199039);
    MallNews localMallNews = d.eGX().aEE(paramatw.GrP.HNO);
    if ((localMallNews == null) || (bt.isNullOrNil(localMallNews.Bhd)) || (!localMallNews.Bhd.equals(paramatw.GrQ.HNH)))
    {
      ad.d("MicroMsg.FunctionListAdapterNew", "old news null or should be replaced %s %s", new Object[] { Integer.valueOf(paramatw.GrQ.HNH), paramatw.GrP.Name });
      localMallNews = new MallNews(paramatw.GrP.HNO);
      localMallNews.Bhd = paramatw.GrQ.HNH;
      d.eGX().b(localMallNews);
      AppMethodBeat.o(199039);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.Dbv))
      {
        ad.d("MicroMsg.FunctionListAdapterNew", "still old news or clicked, then should not show");
        AppMethodBeat.o(199039);
        return false;
      }
      ad.d("MicroMsg.FunctionListAdapterNew", "still old news and should show");
      AppMethodBeat.o(199039);
      return true;
    }
    AppMethodBeat.o(199039);
    return false;
  }
  
  private static void m(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(199040);
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView.setMaxEms(new StaticLayout(paramTextView.getText(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0));
    AppMethodBeat.o(199040);
  }
  
  public final void aj(ArrayList<atw> paramArrayList)
  {
    AppMethodBeat.i(199034);
    this.vDW.clear();
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
            if ((k >= 0) && (((atw)paramArrayList.get(k)).GrW != ((atw)paramArrayList.get(i + j)).GrW)) {
              break;
            }
          }
          c localc = new c();
          localc.vEB = (i + j);
          localc.vEH = ((atw)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.vDW.add(localArrayList);
        }
        i += j;
      }
    }
    this.vDj = com.tencent.mm.plugin.wallet_core.model.mall.b.eGO();
    notifyDataSetChanged();
    AppMethodBeat.o(199034);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(199035);
    int i = this.vDW.size();
    AppMethodBeat.o(199035);
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
    AppMethodBeat.i(199036);
    View localView;
    List localList;
    int m;
    label168:
    int k;
    int j;
    int i;
    if (paramView == null)
    {
      paramView = new b();
      localView = this.mInflater.inflate(2131496474, paramViewGroup, false);
      paramView.vEr = ((LinearLayout)localView.findViewById(2131302010));
      paramView.vEs = ((TextView)localView.findViewById(2131302009));
      paramView.vEu = localView.findViewById(2131301426);
      paramView.vEz = localView.findViewById(2131297448);
      paramView.vEG = localView.findViewById(2131308366);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.vEr.setVisibility(0);
      localList = (List)this.vDW.get(paramInt);
      if (localList.size() <= 0) {
        break label664;
      }
      m = ((c)localList.get(0)).vEH.GrW;
      if (this.vDj != null) {
        break label512;
      }
      paramView = null;
      k = 0;
      j = 0;
      if (bt.isNullOrNil(paramView)) {
        break label1223;
      }
      if (paramInt != 0) {
        break label528;
      }
      i = 1;
      label188:
      if (paramInt != this.vDW.size() - 1) {
        break label596;
      }
      j = 1;
    }
    for (;;)
    {
      label206:
      LinearLayout localLinearLayout;
      if (i != 0)
      {
        paramViewGroup.vEs.setText(paramView);
        paramViewGroup.vEs.setVisibility(0);
        paramViewGroup.vEu.setVisibility(0);
        paramView = paramViewGroup.vEu.getLayoutParams();
        paramView.height = ((int)(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8) * a.dkf()));
        paramViewGroup.vEu.setLayoutParams(paramView);
        paramViewGroup.vEs.setMinHeight((int)(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 48) * a.dkf()));
        paramViewGroup.vEu.setBackgroundColor(e.dkH());
        i = j;
        label306:
        localLinearLayout = paramViewGroup.vEr;
        localLinearLayout.setFocusable(true);
        localLinearLayout.setPadding(a.dkd() / 2, 0, a.dkd() / 2, 0);
        j = 0;
        label338:
        if (j >= 4) {
          break label1145;
        }
        if ((j >= localLinearLayout.getChildCount()) || (localLinearLayout.getChildAt(j) == null)) {
          break label743;
        }
        paramView = localLinearLayout.getChildAt(j);
        paramView.setVisibility(0);
        if (j >= localList.size()) {
          break label688;
        }
        a(paramView, (c)localList.get(j));
        label406:
        if (i == 0) {
          break label1077;
        }
        if (j != 0) {
          break label979;
        }
        paramView.setBackground(this.mContext.getResources().getDrawable(2131233198));
        paramView = paramViewGroup.vEG.getLayoutParams();
        if (!this.vED) {
          break label963;
        }
        paramView.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8);
        label461:
        paramViewGroup.vEG.setLayoutParams(paramView);
        paramViewGroup.vEG.setBackground(this.mContext.getResources().getDrawable(2131235060));
      }
      for (;;)
      {
        j += 1;
        break label338;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label512:
        paramView = (String)this.vDj.get(m);
        break label168;
        label528:
        i = j;
        if (((ArrayList)this.vDW.get(paramInt - 1)).size() <= 0) {
          break label188;
        }
        i = j;
        if (m == ((c)((ArrayList)this.vDW.get(paramInt - 1)).get(0)).vEH.GrW) {
          break label188;
        }
        i = 1;
        break label188;
        label596:
        k = i;
        if (m == ((c)((ArrayList)this.vDW.get(paramInt + 1)).get(0)).vEH.GrW) {
          break label1223;
        }
        j = 1;
        break label206;
        paramViewGroup.vEs.setVisibility(8);
        paramViewGroup.vEu.setVisibility(8);
        i = j;
        break label306;
        label664:
        paramViewGroup.vEs.setVisibility(8);
        paramViewGroup.vEu.setVisibility(8);
        i = 0;
        break label306;
        label688:
        localLinearLayout.getChildAt(j).setFocusable(true);
        localLinearLayout.getChildAt(j).setOnClickListener(null);
        ((a)localLinearLayout.getChildAt(j).getTag()).vEg.setVisibility(4);
        paramView.setEnabled(false);
        paramView.setClickable(false);
        break label406;
        label743:
        Object localObject = new a();
        paramView = this.mInflater.inflate(2131496475, localLinearLayout, false);
        ((a)localObject).vEg = paramView.findViewById(2131302017);
        ((a)localObject).vEh = ((ImageView)paramView.findViewById(2131302014));
        ((a)localObject).vEj = ((TextView)paramView.findViewById(2131302019));
        ((a)localObject).vEk = ((TextView)paramView.findViewById(2131302013));
        ((a)localObject).vEi = ((ImageView)paramView.findViewById(2131302795));
        paramView.setTag(localObject);
        if (j < localList.size()) {
          a(paramView, (c)localList.get(j));
        }
        for (;;)
        {
          localObject = new LinearLayout.LayoutParams(a.dke() + a.dkd(), -1, 1.0F);
          paramView.setMinimumHeight(a.dkb());
          paramView.setPadding(a.dkd() / 2, 0, a.dkd() / 2, 0);
          localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
          break;
          paramView.setFocusable(true);
          ((a)paramView.getTag()).vEg.setVisibility(4);
          paramView.setOnClickListener(null);
          paramView.setEnabled(false);
          paramView.setClickable(false);
        }
        label963:
        paramView.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 16);
        break label461;
        label979:
        if (j != 1)
        {
          paramView.setBackground(this.mContext.getResources().getDrawable(2131233199));
          paramView = paramViewGroup.vEG.getLayoutParams();
          if (this.vED) {}
          for (paramView.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 8);; paramView.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 16))
          {
            paramViewGroup.vEG.setLayoutParams(paramView);
            paramViewGroup.vEG.setBackground(this.mContext.getResources().getDrawable(2131235060));
            break;
          }
        }
        label1077:
        paramView.setBackground(this.mContext.getResources().getDrawable(2131233200));
        paramView = paramViewGroup.vEG.getLayoutParams();
        paramView.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 4);
        paramViewGroup.vEG.setLayoutParams(paramView);
        paramViewGroup.vEG.setBackground(this.mContext.getResources().getDrawable(2131235061));
      }
      label1145:
      if (paramInt == getCount() - 1)
      {
        paramViewGroup.vEz.setBackgroundColor(e.dkH());
        paramViewGroup.vEz.setVisibility(0);
        paramView = paramViewGroup.vEz.getLayoutParams();
        paramView.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
        paramViewGroup.vEz.setLayoutParams(paramView);
      }
      for (;;)
      {
        AppMethodBeat.o(199036);
        return localView;
        paramViewGroup.vEz.setVisibility(8);
      }
      label1223:
      j = 0;
      i = k;
    }
  }
  
  final class a
  {
    public String iconUrl = null;
    public View vEg = null;
    public ImageView vEh = null;
    public ImageView vEi = null;
    public TextView vEj = null;
    public TextView vEk = null;
    public String vEm = null;
    
    a() {}
  }
  
  final class b
  {
    View vEG;
    LinearLayout vEr;
    TextView vEs;
    View vEu;
    View vEz;
    
    b() {}
  }
  
  final class c
  {
    int vEB;
    atw vEH;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, atw paramatw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */