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
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private final int vPX;
  private SparseArray<String> vPn;
  d vQG;
  private boolean vQH;
  List<ArrayList<c>> vQa;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(189868);
    this.vPX = 4;
    this.vQa = new ArrayList();
    this.vPn = null;
    this.vQH = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(189868);
  }
  
  private void a(View paramView, c paramc)
  {
    AppMethodBeat.i(189872);
    if (paramView == null)
    {
      AppMethodBeat.o(189872);
      return;
    }
    paramView = (a)paramView.getTag();
    final aum localaum = paramc.vQL;
    final int i = paramc.vQF;
    if (al.isDarkMode())
    {
      paramView.iconUrl = localaum.GLn.IhW.Iic;
      com.tencent.mm.plugin.mall.b.a.d(paramView.vQl, paramView.iconUrl, 2131690773);
      paramView.vQn.setText(localaum.GLn.Name);
      n(paramView.vQn, a.dnd());
      if (localaum.GLt == null) {
        break label302;
      }
      paramView.vQo.setText(localaum.GLt);
      paramView.vQo.setVisibility(0);
      n(paramView.vQo, a.dnd());
      this.vQH = true;
      label136:
      if ((localaum.GLo == null) || (localaum.GLo.IhP == null) || (!b(localaum))) {
        break label341;
      }
      if (!al.isDarkMode()) {
        break label323;
      }
      paramView.vQq = localaum.GLo.IhP.Iic;
      label184:
      com.tencent.mm.plugin.mall.b.a.q(paramView.vQm, paramView.vQq);
      paramView.vQm.setVisibility(0);
      ((RelativeLayout.LayoutParams)paramView.vQm.getLayoutParams()).setMargins(a.dnd() / 2 - 1, com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 7), 0, 0);
      new StringBuilder().append(localaum.GLn.IhV);
    }
    for (;;)
    {
      paramView.vQk.setVisibility(0);
      paramView.vQk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189867);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.v("MicroMsg.FunctionListAdapterNew", "on Click");
          if (c.a(c.this) != null) {
            c.a(c.this).a(i, localaum);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189867);
        }
      });
      AppMethodBeat.o(189872);
      return;
      paramView.iconUrl = localaum.GLn.IhW.Iib;
      break;
      label302:
      paramView.vQo.setText("");
      paramView.vQo.setVisibility(8);
      break label136;
      label323:
      paramView.vQq = localaum.GLo.IhP.Iib;
      break label184;
      label341:
      paramView.vQm.setImageBitmap(null);
      paramView.vQm.setVisibility(8);
    }
  }
  
  public static boolean a(aum paramaum)
  {
    AppMethodBeat.i(189873);
    if ((paramaum.GLo != null) && (paramaum.GLo.IhP != null) && (b(paramaum)) && (d.eKF().aFY(paramaum.GLn.IhV) != null))
    {
      AppMethodBeat.o(189873);
      return true;
    }
    AppMethodBeat.o(189873);
    return false;
  }
  
  private static boolean b(aum paramaum)
  {
    AppMethodBeat.i(189874);
    MallNews localMallNews = d.eKF().aFY(paramaum.GLn.IhV);
    if ((localMallNews == null) || (bu.isNullOrNil(localMallNews.ByB)) || (!localMallNews.ByB.equals(paramaum.GLo.IhO)))
    {
      ae.d("MicroMsg.FunctionListAdapterNew", "old news null or should be replaced %s %s", new Object[] { Integer.valueOf(paramaum.GLo.IhO), paramaum.GLn.Name });
      localMallNews = new MallNews(paramaum.GLn.IhV);
      localMallNews.ByB = paramaum.GLo.IhO;
      d.eKF().b(localMallNews);
      AppMethodBeat.o(189874);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.DsZ))
      {
        ae.d("MicroMsg.FunctionListAdapterNew", "still old news or clicked, then should not show");
        AppMethodBeat.o(189874);
        return false;
      }
      ae.d("MicroMsg.FunctionListAdapterNew", "still old news and should show");
      AppMethodBeat.o(189874);
      return true;
    }
    AppMethodBeat.o(189874);
    return false;
  }
  
  private static void n(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(189875);
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView.setMaxEms(new StaticLayout(paramTextView.getText(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0));
    AppMethodBeat.o(189875);
  }
  
  public final void aj(ArrayList<aum> paramArrayList)
  {
    AppMethodBeat.i(189869);
    this.vQa.clear();
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
            if ((k >= 0) && (((aum)paramArrayList.get(k)).GLu != ((aum)paramArrayList.get(i + j)).GLu)) {
              break;
            }
          }
          c localc = new c();
          localc.vQF = (i + j);
          localc.vQL = ((aum)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.vQa.add(localArrayList);
        }
        i += j;
      }
    }
    this.vPn = com.tencent.mm.plugin.wallet_core.model.mall.b.eKv();
    notifyDataSetChanged();
    AppMethodBeat.o(189869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(189870);
    int i = this.vQa.size();
    AppMethodBeat.o(189870);
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
    AppMethodBeat.i(189871);
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
      paramView.vQv = ((LinearLayout)localView.findViewById(2131302010));
      paramView.vQw = ((TextView)localView.findViewById(2131302009));
      paramView.vQy = localView.findViewById(2131301426);
      paramView.vQD = localView.findViewById(2131297448);
      paramView.vQK = localView.findViewById(2131308366);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.vQv.setVisibility(0);
      localList = (List)this.vQa.get(paramInt);
      if (localList.size() <= 0) {
        break label664;
      }
      m = ((c)localList.get(0)).vQL.GLu;
      if (this.vPn != null) {
        break label512;
      }
      paramView = null;
      k = 0;
      j = 0;
      if (bu.isNullOrNil(paramView)) {
        break label1223;
      }
      if (paramInt != 0) {
        break label528;
      }
      i = 1;
      label188:
      if (paramInt != this.vQa.size() - 1) {
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
        paramViewGroup.vQw.setText(paramView);
        paramViewGroup.vQw.setVisibility(0);
        paramViewGroup.vQy.setVisibility(0);
        paramView = paramViewGroup.vQy.getLayoutParams();
        paramView.height = ((int)(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8) * a.dne()));
        paramViewGroup.vQy.setLayoutParams(paramView);
        paramViewGroup.vQw.setMinHeight((int)(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48) * a.dne()));
        paramViewGroup.vQy.setBackgroundColor(e.dnH());
        i = j;
        label306:
        localLinearLayout = paramViewGroup.vQv;
        localLinearLayout.setFocusable(true);
        localLinearLayout.setPadding(a.dnc() / 2, 0, a.dnc() / 2, 0);
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
        paramView = paramViewGroup.vQK.getLayoutParams();
        if (!this.vQH) {
          break label963;
        }
        paramView.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
        label461:
        paramViewGroup.vQK.setLayoutParams(paramView);
        paramViewGroup.vQK.setBackground(this.mContext.getResources().getDrawable(2131235060));
      }
      for (;;)
      {
        j += 1;
        break label338;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label512:
        paramView = (String)this.vPn.get(m);
        break label168;
        label528:
        i = j;
        if (((ArrayList)this.vQa.get(paramInt - 1)).size() <= 0) {
          break label188;
        }
        i = j;
        if (m == ((c)((ArrayList)this.vQa.get(paramInt - 1)).get(0)).vQL.GLu) {
          break label188;
        }
        i = 1;
        break label188;
        label596:
        k = i;
        if (m == ((c)((ArrayList)this.vQa.get(paramInt + 1)).get(0)).vQL.GLu) {
          break label1223;
        }
        j = 1;
        break label206;
        paramViewGroup.vQw.setVisibility(8);
        paramViewGroup.vQy.setVisibility(8);
        i = j;
        break label306;
        label664:
        paramViewGroup.vQw.setVisibility(8);
        paramViewGroup.vQy.setVisibility(8);
        i = 0;
        break label306;
        label688:
        localLinearLayout.getChildAt(j).setFocusable(true);
        localLinearLayout.getChildAt(j).setOnClickListener(null);
        ((a)localLinearLayout.getChildAt(j).getTag()).vQk.setVisibility(4);
        paramView.setEnabled(false);
        paramView.setClickable(false);
        break label406;
        label743:
        Object localObject = new a();
        paramView = this.mInflater.inflate(2131496475, localLinearLayout, false);
        ((a)localObject).vQk = paramView.findViewById(2131302017);
        ((a)localObject).vQl = ((ImageView)paramView.findViewById(2131302014));
        ((a)localObject).vQn = ((TextView)paramView.findViewById(2131302019));
        ((a)localObject).vQo = ((TextView)paramView.findViewById(2131302013));
        ((a)localObject).vQm = ((ImageView)paramView.findViewById(2131302795));
        paramView.setTag(localObject);
        if (j < localList.size()) {
          a(paramView, (c)localList.get(j));
        }
        for (;;)
        {
          localObject = new LinearLayout.LayoutParams(a.dnd() + a.dnc(), -1, 1.0F);
          paramView.setMinimumHeight(a.dna());
          paramView.setPadding(a.dnc() / 2, 0, a.dnc() / 2, 0);
          localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
          break;
          paramView.setFocusable(true);
          ((a)paramView.getTag()).vQk.setVisibility(4);
          paramView.setOnClickListener(null);
          paramView.setEnabled(false);
          paramView.setClickable(false);
        }
        label963:
        paramView.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
        break label461;
        label979:
        if (j != 1)
        {
          paramView.setBackground(this.mContext.getResources().getDrawable(2131233199));
          paramView = paramViewGroup.vQK.getLayoutParams();
          if (this.vQH) {}
          for (paramView.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);; paramView.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16))
          {
            paramViewGroup.vQK.setLayoutParams(paramView);
            paramViewGroup.vQK.setBackground(this.mContext.getResources().getDrawable(2131235060));
            break;
          }
        }
        label1077:
        paramView.setBackground(this.mContext.getResources().getDrawable(2131233200));
        paramView = paramViewGroup.vQK.getLayoutParams();
        paramView.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4);
        paramViewGroup.vQK.setLayoutParams(paramView);
        paramViewGroup.vQK.setBackground(this.mContext.getResources().getDrawable(2131235061));
      }
      label1145:
      if (paramInt == getCount() - 1)
      {
        paramViewGroup.vQD.setBackgroundColor(e.dnH());
        paramViewGroup.vQD.setVisibility(0);
        paramView = paramViewGroup.vQD.getLayoutParams();
        paramView.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
        paramViewGroup.vQD.setLayoutParams(paramView);
      }
      for (;;)
      {
        AppMethodBeat.o(189871);
        return localView;
        paramViewGroup.vQD.setVisibility(8);
      }
      label1223:
      j = 0;
      i = k;
    }
  }
  
  final class a
  {
    public String iconUrl = null;
    public View vQk = null;
    public ImageView vQl = null;
    public ImageView vQm = null;
    public TextView vQn = null;
    public TextView vQo = null;
    public String vQq = null;
    
    a() {}
  }
  
  final class b
  {
    View vQD;
    View vQK;
    LinearLayout vQv;
    TextView vQw;
    View vQy;
    
    b() {}
  }
  
  final class c
  {
    int vQF;
    aum vQL;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, aum paramaum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */