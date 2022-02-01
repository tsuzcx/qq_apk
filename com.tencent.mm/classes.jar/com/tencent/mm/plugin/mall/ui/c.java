package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.gdy;
import com.tencent.mm.protocal.protobuf.geb;
import com.tencent.mm.protocal.protobuf.gef;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.ui.k;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private final int KJO;
  List<ArrayList<c>> KJR;
  private SparseArray<String> KJg;
  d KKx;
  private boolean KKy;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(262436);
    this.KJO = 4;
    this.KJR = new ArrayList();
    this.KJg = null;
    this.KKy = false;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(262436);
  }
  
  private void a(View paramView, c paramc)
  {
    AppMethodBeat.i(262438);
    if (paramView == null)
    {
      AppMethodBeat.o(262438);
      return;
    }
    paramView = (a)paramView.getTag();
    final caq localcaq = paramc.KKC;
    final int i = paramc.KKw;
    if (aw.isDarkMode())
    {
      paramView.iconUrl = localcaq.aajz.acbK.acbQ;
      com.tencent.mm.plugin.mall.b.b.f(paramView.KKc, paramView.iconUrl, a.h.mall_index_icon_default);
      paramView.KKe.setText(localcaq.aajz.IGU);
      p(paramView.KKe, a.fZf());
      if (localcaq.aajF == null) {
        break label303;
      }
      paramView.KKf.setText(localcaq.aajF);
      paramView.KKf.setVisibility(0);
      p(paramView.KKf, a.fZf());
      this.KKy = true;
      label137:
      if ((localcaq.aajA == null) || (localcaq.aajA.acbE == null) || (!b(localcaq))) {
        break label342;
      }
      if (!aw.isDarkMode()) {
        break label324;
      }
      paramView.KKh = localcaq.aajA.acbE.acbQ;
      label185:
      com.tencent.mm.plugin.mall.b.b.t(paramView.KKd, paramView.KKh);
      paramView.KKd.setVisibility(0);
      ((RelativeLayout.LayoutParams)paramView.KKd.getLayoutParams()).setMargins(a.fZf() / 2 - 1, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 7), 0, 0);
      new StringBuilder().append(localcaq.aajz.acbJ);
    }
    for (;;)
    {
      paramView.KKb.setVisibility(0);
      paramView.KKb.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(262442);
          Log.v("MicroMsg.FunctionListAdapterNew", "on Click");
          if (c.a(c.this) != null) {
            c.a(c.this).a(i, localcaq);
          }
          AppMethodBeat.o(262442);
        }
      });
      AppMethodBeat.o(262438);
      return;
      paramView.iconUrl = localcaq.aajz.acbK.acbP;
      break;
      label303:
      paramView.KKf.setText("");
      paramView.KKf.setVisibility(8);
      break label137;
      label324:
      paramView.KKh = localcaq.aajA.acbE.acbP;
      break label185;
      label342:
      paramView.KKd.setImageBitmap(null);
      paramView.KKd.setVisibility(8);
    }
  }
  
  public static boolean a(caq paramcaq)
  {
    AppMethodBeat.i(262441);
    if ((paramcaq.aajA != null) && (paramcaq.aajA.acbE != null) && (b(paramcaq)) && (d.ikh().bgQ(paramcaq.aajz.acbJ) != null))
    {
      AppMethodBeat.o(262441);
      return true;
    }
    AppMethodBeat.o(262441);
    return false;
  }
  
  private static boolean b(caq paramcaq)
  {
    AppMethodBeat.i(262445);
    MallNews localMallNews = d.ikh().bgQ(paramcaq.aajz.acbJ);
    if ((localMallNews == null) || (Util.isNullOrNil(localMallNews.rBJ)) || (!localMallNews.rBJ.equals(paramcaq.aajA.acbD)))
    {
      Log.d("MicroMsg.FunctionListAdapterNew", "old news null or should be replaced %s %s", new Object[] { Integer.valueOf(paramcaq.aajA.acbD), paramcaq.aajz.IGU });
      localMallNews = new MallNews(paramcaq.aajz.acbJ);
      localMallNews.rBJ = paramcaq.aajA.acbD;
      d.ikh().b(localMallNews);
      AppMethodBeat.o(262445);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.VKO))
      {
        Log.d("MicroMsg.FunctionListAdapterNew", "still old news or clicked, then should not show");
        AppMethodBeat.o(262445);
        return false;
      }
      Log.d("MicroMsg.FunctionListAdapterNew", "still old news and should show");
      AppMethodBeat.o(262445);
      return true;
    }
    AppMethodBeat.o(262445);
    return false;
  }
  
  private static void p(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(262446);
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView.setMaxEms(new StaticLayout(paramTextView.getText(), localTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0));
    AppMethodBeat.o(262446);
  }
  
  public final void aX(ArrayList<caq> paramArrayList)
  {
    AppMethodBeat.i(262454);
    this.KJR.clear();
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
            if ((k >= 0) && (((caq)paramArrayList.get(k)).aajG != ((caq)paramArrayList.get(i + j)).aajG)) {
              break;
            }
          }
          c localc = new c();
          localc.KKw = (i + j);
          localc.KKC = ((caq)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.KJR.add(localArrayList);
        }
        i += j;
      }
    }
    this.KJg = com.tencent.mm.plugin.wallet_core.model.mall.b.ijX();
    notifyDataSetChanged();
    AppMethodBeat.o(262454);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(262457);
    int i = this.KJR.size();
    AppMethodBeat.o(262457);
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
    AppMethodBeat.i(262465);
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
      paramView.KKm = ((LinearLayout)((View)localObject1).findViewById(a.f.mall_function_list_line_container));
      paramView.KKn = ((TextView)((View)localObject1).findViewById(a.f.mall_fucntion_list_section_title));
      paramView.KKp = ((View)localObject1).findViewById(a.f.line_margin);
      paramView.KKu = ((View)localObject1).findViewById(a.f.bottom_gap);
      paramView.KKB = ((View)localObject1).findViewById(a.f.normal_bottom_gap);
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
      paramViewGroup.KKm.setVisibility(0);
      localList = (List)this.KJR.get(paramInt);
      if (localList.size() <= 0) {
        break label732;
      }
      m = ((c)localList.get(0)).KKC.aajG;
      if (this.KJg != null) {
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
      if (paramInt != this.KJR.size() - 1) {
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
        paramViewGroup.KKn.setText((CharSequence)localObject1);
        paramViewGroup.KKn.setVisibility(0);
        paramViewGroup.KKp.setVisibility(0);
        localObject1 = paramViewGroup.KKp.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8) * a.fZg()));
        paramViewGroup.KKp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.KKn.setMinHeight((int)(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 48) * a.fZg()));
        paramViewGroup.KKp.setBackgroundColor(e.fZI());
        i = j;
        localLinearLayout = paramViewGroup.KKm;
        localLinearLayout.setFocusable(true);
        localLinearLayout.setPadding(a.fZe() / 2, 0, a.fZe() / 2, 0);
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
        ((LinearLayout.LayoutParams)localObject2).width = (a.fZf() + a.fZe());
        ((View)localObject1).setMinimumHeight(a.fZc());
        ((View)localObject1).setPadding(a.fZe() / 2, 0, a.fZe() / 2, 0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (i == 0) {
          break label1169;
        }
        if (j != 0) {
          break label1066;
        }
        ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_bottomleft_selector));
        localObject1 = paramViewGroup.KKB.getLayoutParams();
        if (!this.KKy) {
          break label1049;
        }
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8);
        label530:
        paramViewGroup.KKB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.KKB.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_line_bg_last));
      }
      for (;;)
      {
        j += 1;
        break label347;
        paramViewGroup = (b)paramView.getTag();
        break;
        label579:
        localObject1 = (String)this.KJg.get(m);
        break label172;
        label596:
        i = j;
        if (((ArrayList)this.KJR.get(paramInt - 1)).size() <= 0) {
          break label193;
        }
        i = j;
        if (m == ((c)((ArrayList)this.KJR.get(paramInt - 1)).get(0)).KKC.aajG) {
          break label193;
        }
        i = 1;
        break label193;
        label664:
        k = i;
        if (m == ((c)((ArrayList)this.KJR.get(paramInt + 1)).get(0)).KKC.aajG) {
          break label1321;
        }
        j = 1;
        break label211;
        paramViewGroup.KKn.setVisibility(8);
        paramViewGroup.KKp.setVisibility(8);
        i = j;
        break label315;
        label732:
        paramViewGroup.KKn.setVisibility(8);
        paramViewGroup.KKp.setVisibility(8);
        i = 0;
        break label315;
        label756:
        localLinearLayout.getChildAt(j).setFocusable(true);
        localLinearLayout.getChildAt(j).setOnClickListener(null);
        ((a)localLinearLayout.getChildAt(j).getTag()).KKb.setVisibility(4);
        ((View)localObject1).setEnabled(false);
        ((View)localObject1).setClickable(false);
        break label418;
        label813:
        localObject2 = new a();
        localObject1 = this.mInflater.inflate(a.g.mall_index_function_item_v2, localLinearLayout, false);
        ((a)localObject2).KKb = ((View)localObject1).findViewById(a.f.mall_index_function_item_main);
        ((a)localObject2).KKc = ((ImageView)((View)localObject1).findViewById(a.f.mall_index_function_icon));
        ((a)localObject2).KKe = ((TextView)((View)localObject1).findViewById(a.f.mall_index_function_name));
        ((a)localObject2).KKf = ((TextView)((View)localObject1).findViewById(a.f.mall_index_function_activity));
        ((a)localObject2).KKd = ((ImageView)((View)localObject1).findViewById(a.f.new_pic_holder));
        ((View)localObject1).setTag(localObject2);
        if (j < localList.size()) {
          a((View)localObject1, (c)localList.get(j));
        }
        for (;;)
        {
          localObject2 = new LinearLayout.LayoutParams(a.fZf() + a.fZe(), -1, 1.0F);
          ((View)localObject1).setMinimumHeight(a.fZc());
          ((View)localObject1).setPadding(a.fZe() / 2, 0, a.fZe() / 2, 0);
          localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          break;
          ((View)localObject1).setFocusable(true);
          ((a)((View)localObject1).getTag()).KKb.setVisibility(4);
          ((View)localObject1).setOnClickListener(null);
          ((View)localObject1).setEnabled(false);
          ((View)localObject1).setClickable(false);
        }
        label1049:
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
        break label530;
        label1066:
        if (j != 1)
        {
          ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_bottomright_selector));
          localObject1 = paramViewGroup.KKB.getLayoutParams();
          if (this.KKy) {}
          for (((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8);; ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16))
          {
            paramViewGroup.KKB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.KKB.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_line_bg_last));
            break;
          }
        }
        label1169:
        ((View)localObject1).setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_selector));
        localObject1 = paramViewGroup.KKB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 4);
        paramViewGroup.KKB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.KKB.setBackground(this.mContext.getResources().getDrawable(a.e.mall_index_function_grid_line_bg_normal));
      }
      label1241:
      if (paramInt == getCount() - 1)
      {
        paramViewGroup.KKu.setBackgroundColor(e.fZI());
        paramViewGroup.KKu.setVisibility(0);
        localObject1 = paramViewGroup.KKu.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
        paramViewGroup.KKu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(262465);
        return paramView;
        paramViewGroup.KKu.setVisibility(8);
      }
      label1321:
      j = 0;
      i = k;
    }
  }
  
  final class a
  {
    public View KKb = null;
    public ImageView KKc = null;
    public ImageView KKd = null;
    public TextView KKe = null;
    public TextView KKf = null;
    public String KKh = null;
    public String iconUrl = null;
    
    a() {}
  }
  
  final class b
  {
    View KKB;
    LinearLayout KKm;
    TextView KKn;
    View KKp;
    View KKu;
    
    b() {}
  }
  
  final class c
  {
    caq KKC;
    int KKw;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, caq paramcaq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.c
 * JD-Core Version:    0.7.0.1
 */