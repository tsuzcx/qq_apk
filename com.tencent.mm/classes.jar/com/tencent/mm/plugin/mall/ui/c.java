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
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.ewz;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.protocal.protobuf.exg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private SparseArray<String> zjr;
  d zkK;
  private boolean zkL;
  private final int zkb;
  List<ArrayList<c>> zke;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(213545);
    this.zkb = 4;
    this.zke = new ArrayList();
    this.zjr = null;
    this.zkL = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(213545);
  }
  
  private void a(View paramView, c paramc)
  {
    AppMethodBeat.i(213549);
    if (paramView == null)
    {
      AppMethodBeat.o(213549);
      return;
    }
    paramView = (a)paramView.getTag();
    final bfv localbfv = paramc.zkP;
    final int i = paramc.zkJ;
    if (ao.isDarkMode())
    {
      paramView.iconUrl = localbfv.LPr.NuA.NuG;
      com.tencent.mm.plugin.mall.b.a.d(paramView.zkp, paramView.iconUrl, 2131691057);
      paramView.zkr.setText(localbfv.LPr.Name);
      n(paramView.zkr, a.egP());
      if (localbfv.LPx == null) {
        break label302;
      }
      paramView.zks.setText(localbfv.LPx);
      paramView.zks.setVisibility(0);
      n(paramView.zks, a.egP());
      this.zkL = true;
      label136:
      if ((localbfv.LPs == null) || (localbfv.LPs.Nut == null) || (!b(localbfv))) {
        break label341;
      }
      if (!ao.isDarkMode()) {
        break label323;
      }
      paramView.zku = localbfv.LPs.Nut.NuG;
      label184:
      com.tencent.mm.plugin.mall.b.a.t(paramView.zkq, paramView.zku);
      paramView.zkq.setVisibility(0);
      ((RelativeLayout.LayoutParams)paramView.zkq.getLayoutParams()).setMargins(a.egP() / 2 - 1, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 7), 0, 0);
      new StringBuilder().append(localbfv.LPr.Nuz);
    }
    for (;;)
    {
      paramView.zko.setVisibility(0);
      paramView.zko.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213544);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.v("MicroMsg.FunctionListAdapterNew", "on Click");
          if (c.a(c.this) != null) {
            c.a(c.this).a(i, localbfv);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapterV2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213544);
        }
      });
      AppMethodBeat.o(213549);
      return;
      paramView.iconUrl = localbfv.LPr.NuA.NuF;
      break;
      label302:
      paramView.zks.setText("");
      paramView.zks.setVisibility(8);
      break label136;
      label323:
      paramView.zku = localbfv.LPs.Nut.NuF;
      break label184;
      label341:
      paramView.zkq.setImageBitmap(null);
      paramView.zkq.setVisibility(8);
    }
  }
  
  public static boolean a(bfv parambfv)
  {
    AppMethodBeat.i(213550);
    if ((parambfv.LPs != null) && (parambfv.LPs.Nut != null) && (b(parambfv)) && (d.fSk().aVx(parambfv.LPr.Nuz) != null))
    {
      AppMethodBeat.o(213550);
      return true;
    }
    AppMethodBeat.o(213550);
    return false;
  }
  
  private static boolean b(bfv parambfv)
  {
    AppMethodBeat.i(213551);
    MallNews localMallNews = d.fSk().aVx(parambfv.LPr.Nuz);
    if ((localMallNews == null) || (Util.isNullOrNil(localMallNews.FJm)) || (!localMallNews.FJm.equals(parambfv.LPs.Nus)))
    {
      Log.d("MicroMsg.FunctionListAdapterNew", "old news null or should be replaced %s %s", new Object[] { Integer.valueOf(parambfv.LPs.Nus), parambfv.LPr.Name });
      localMallNews = new MallNews(parambfv.LPr.Nuz);
      localMallNews.FJm = parambfv.LPs.Nus;
      d.fSk().b(localMallNews);
      AppMethodBeat.o(213551);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.Icl))
      {
        Log.d("MicroMsg.FunctionListAdapterNew", "still old news or clicked, then should not show");
        AppMethodBeat.o(213551);
        return false;
      }
      Log.d("MicroMsg.FunctionListAdapterNew", "still old news and should show");
      AppMethodBeat.o(213551);
      return true;
    }
    AppMethodBeat.o(213551);
    return false;
  }
  
  private static void n(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(213552);
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView.setMaxEms(new StaticLayout(paramTextView.getText(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0));
    AppMethodBeat.o(213552);
  }
  
  public final void ax(ArrayList<bfv> paramArrayList)
  {
    AppMethodBeat.i(213546);
    this.zke.clear();
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
            if ((k >= 0) && (((bfv)paramArrayList.get(k)).LPy != ((bfv)paramArrayList.get(i + j)).LPy)) {
              break;
            }
          }
          c localc = new c();
          localc.zkJ = (i + j);
          localc.zkP = ((bfv)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.zke.add(localArrayList);
        }
        i += j;
      }
    }
    this.zjr = com.tencent.mm.plugin.wallet_core.model.mall.b.fSa();
    notifyDataSetChanged();
    AppMethodBeat.o(213546);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(213547);
    int i = this.zke.size();
    AppMethodBeat.o(213547);
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
    AppMethodBeat.i(213548);
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
      localObject1 = this.mInflater.inflate(2131495414, paramViewGroup, false);
      paramView.zkz = ((LinearLayout)((View)localObject1).findViewById(2131304349));
      paramView.zkA = ((TextView)((View)localObject1).findViewById(2131304348));
      paramView.zkC = ((View)localObject1).findViewById(2131303202);
      paramView.zkH = ((View)localObject1).findViewById(2131297677);
      paramView.zkO = ((View)localObject1).findViewById(2131305475);
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      paramViewGroup.zkz.setVisibility(0);
      localList = (List)this.zke.get(paramInt);
      if (localList.size() <= 0) {
        break label732;
      }
      m = ((c)localList.get(0)).zkP.LPy;
      if (this.zjr != null) {
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
      if (paramInt != this.zke.size() - 1) {
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
        paramViewGroup.zkA.setText((CharSequence)localObject1);
        paramViewGroup.zkA.setVisibility(0);
        paramViewGroup.zkC.setVisibility(0);
        localObject1 = paramViewGroup.zkC.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8) * a.egQ()));
        paramViewGroup.zkC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.zkA.setMinHeight((int)(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48) * a.egQ()));
        paramViewGroup.zkC.setBackgroundColor(e.eht());
        i = j;
        localLinearLayout = paramViewGroup.zkz;
        localLinearLayout.setFocusable(true);
        localLinearLayout.setPadding(a.egO() / 2, 0, a.egO() / 2, 0);
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
        ((LinearLayout.LayoutParams)localObject2).width = (a.egP() + a.egO());
        ((View)localObject1).setMinimumHeight(a.egM());
        ((View)localObject1).setPadding(a.egO() / 2, 0, a.egO() / 2, 0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (i == 0) {
          break label1169;
        }
        if (j != 0) {
          break label1066;
        }
        ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(2131233856));
        localObject1 = paramViewGroup.zkO.getLayoutParams();
        if (!this.zkL) {
          break label1049;
        }
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
        label530:
        paramViewGroup.zkO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.zkO.setBackground(this.mContext.getResources().getDrawable(2131233858));
      }
      for (;;)
      {
        j += 1;
        break label347;
        paramViewGroup = (b)paramView.getTag();
        break;
        label579:
        localObject1 = (String)this.zjr.get(m);
        break label172;
        label596:
        i = j;
        if (((ArrayList)this.zke.get(paramInt - 1)).size() <= 0) {
          break label193;
        }
        i = j;
        if (m == ((c)((ArrayList)this.zke.get(paramInt - 1)).get(0)).zkP.LPy) {
          break label193;
        }
        i = 1;
        break label193;
        label664:
        k = i;
        if (m == ((c)((ArrayList)this.zke.get(paramInt + 1)).get(0)).zkP.LPy) {
          break label1321;
        }
        j = 1;
        break label211;
        paramViewGroup.zkA.setVisibility(8);
        paramViewGroup.zkC.setVisibility(8);
        i = j;
        break label315;
        label732:
        paramViewGroup.zkA.setVisibility(8);
        paramViewGroup.zkC.setVisibility(8);
        i = 0;
        break label315;
        label756:
        localLinearLayout.getChildAt(j).setFocusable(true);
        localLinearLayout.getChildAt(j).setOnClickListener(null);
        ((a)localLinearLayout.getChildAt(j).getTag()).zko.setVisibility(4);
        ((View)localObject1).setEnabled(false);
        ((View)localObject1).setClickable(false);
        break label418;
        label813:
        localObject2 = new a();
        localObject1 = this.mInflater.inflate(2131495422, localLinearLayout, false);
        ((a)localObject2).zko = ((View)localObject1).findViewById(2131304356);
        ((a)localObject2).zkp = ((ImageView)((View)localObject1).findViewById(2131304353));
        ((a)localObject2).zkr = ((TextView)((View)localObject1).findViewById(2131304358));
        ((a)localObject2).zks = ((TextView)((View)localObject1).findViewById(2131304352));
        ((a)localObject2).zkq = ((ImageView)((View)localObject1).findViewById(2131305365));
        ((View)localObject1).setTag(localObject2);
        if (j < localList.size()) {
          a((View)localObject1, (c)localList.get(j));
        }
        for (;;)
        {
          localObject2 = new LinearLayout.LayoutParams(a.egP() + a.egO(), -1, 1.0F);
          ((View)localObject1).setMinimumHeight(a.egM());
          ((View)localObject1).setPadding(a.egO() / 2, 0, a.egO() / 2, 0);
          localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          break;
          ((View)localObject1).setFocusable(true);
          ((a)((View)localObject1).getTag()).zko.setVisibility(4);
          ((View)localObject1).setOnClickListener(null);
          ((View)localObject1).setEnabled(false);
          ((View)localObject1).setClickable(false);
        }
        label1049:
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
        break label530;
        label1066:
        if (j != 1)
        {
          ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(2131233857));
          localObject1 = paramViewGroup.zkO.getLayoutParams();
          if (this.zkL) {}
          for (((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);; ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16))
          {
            paramViewGroup.zkO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.zkO.setBackground(this.mContext.getResources().getDrawable(2131233858));
            break;
          }
        }
        label1169:
        ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(2131233860));
        localObject1 = paramViewGroup.zkO.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4);
        paramViewGroup.zkO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.zkO.setBackground(this.mContext.getResources().getDrawable(2131233859));
      }
      label1241:
      if (paramInt == getCount() - 1)
      {
        paramViewGroup.zkH.setBackgroundColor(e.eht());
        paramViewGroup.zkH.setVisibility(0);
        localObject1 = paramViewGroup.zkH.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
        paramViewGroup.zkH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(213548);
        return paramView;
        paramViewGroup.zkH.setVisibility(8);
      }
      label1321:
      j = 0;
      i = k;
    }
  }
  
  final class a
  {
    public String iconUrl = null;
    public View zko = null;
    public ImageView zkp = null;
    public ImageView zkq = null;
    public TextView zkr = null;
    public TextView zks = null;
    public String zku = null;
    
    a() {}
  }
  
  final class b
  {
    TextView zkA;
    View zkC;
    View zkH;
    View zkO;
    LinearLayout zkz;
    
    b() {}
  }
  
  final class c
  {
    int zkJ;
    bfv zkP;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, bfv parambfv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */