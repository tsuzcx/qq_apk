package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  extends BaseAdapter
{
  private LayoutInflater Lu;
  private final int lYK = 3;
  private final int lYL = 9;
  private final int lYM = 3;
  List<ArrayList<b.c>> lYN = new ArrayList();
  b.d lYO;
  private boolean lYP = true;
  int lYQ = 0;
  int lYR = 0;
  boolean lYS = false;
  private boolean lYT = false;
  SparseArray<String> lYm = null;
  int lYn;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.lYn = paramInt;
    this.Lu = LayoutInflater.from(this.mContext);
  }
  
  private void a(int paramInt, b.b paramb)
  {
    List localList = (List)this.lYN.get(paramInt);
    int i = ((b.c)localList.get(0)).lZq.type;
    Object localObject;
    if (localList.size() > 0)
    {
      i = ((b.c)localList.get(0)).lZq.type;
      if (this.lYm == null)
      {
        localObject = null;
        if (bk.bl((String)localObject)) {
          break label671;
        }
        if (paramInt != 0) {
          break label219;
        }
        paramInt = 1;
      }
    }
    for (;;)
    {
      label85:
      if (paramInt != 0)
      {
        paramb.lZj.setText((CharSequence)localObject);
        paramb.lZj.setVisibility(0);
        paramb.lZk.setVisibility(0);
        paramb.lZl.setVisibility(0);
        label122:
        paramb = paramb.lZi;
        paramb.setFocusable(true);
        paramInt = 0;
        if (paramInt >= 3) {
          break label670;
        }
        if ((paramInt >= paramb.getChildCount()) || (paramb.getChildAt(paramInt) == null)) {
          break label397;
        }
        localObject = paramb.getChildAt(paramInt);
        ((View)localObject).setVisibility(0);
        if (paramInt >= localList.size()) {
          break label337;
        }
        a((View)localObject, (b.c)localList.get(paramInt));
      }
      for (;;)
      {
        label134:
        paramInt += 1;
        break label134;
        localObject = (String)this.lYm.get(i);
        break;
        label219:
        if ((((ArrayList)this.lYN.get(paramInt - 1)).size() <= 0) || (i == ((b.c)((ArrayList)this.lYN.get(paramInt - 1)).get(0)).lZq.type)) {
          break label671;
        }
        paramInt = 1;
        break label85;
        paramb.lZj.setVisibility(8);
        paramb.lZk.setVisibility(8);
        paramb.lZl.setVisibility(8);
        break label122;
        paramb.lZj.setVisibility(8);
        paramb.lZk.setVisibility(8);
        paramb.lZl.setVisibility(8);
        break label122;
        label337:
        paramb.getChildAt(paramInt).setFocusable(true);
        paramb.getChildAt(paramInt).setOnClickListener(null);
        locala = (a)paramb.getChildAt(paramInt).getTag();
        locala.lYX.setVisibility(4);
        ((View)localObject).setEnabled(false);
        ((View)localObject).setClickable(false);
        a(locala);
      }
      label397:
      a locala = new a();
      localObject = this.Lu.inflate(a.g.mall_index_function_item, paramb, false);
      locala.lYX = ((View)localObject).findViewById(a.f.mall_index_function_item_main);
      locala.lYY = ((ImageView)((View)localObject).findViewById(a.f.mall_index_function_icon));
      locala.lZa = ((TextView)((View)localObject).findViewById(a.f.mall_index_function_name));
      locala.lZb = ((TextView)((View)localObject).findViewById(a.f.mall_index_function_activity));
      locala.lYZ = ((ImageView)((View)localObject).findViewById(a.f.new_pic_holder));
      locala.lZe = ((ImageView)((View)localObject).findViewById(a.f.divider_top));
      locala.lZf = ((ImageView)((View)localObject).findViewById(a.f.divider_right));
      locala.lZg = ((ImageView)((View)localObject).findViewById(a.f.divider_bottom));
      locala.lZh = ((ImageView)((View)localObject).findViewById(a.f.divider_left));
      ((View)localObject).setTag(locala);
      if (paramInt < localList.size()) {
        a((View)localObject, (b.c)localList.get(paramInt));
      }
      for (;;)
      {
        paramb.addView((View)localObject, new LinearLayout.LayoutParams(-2, a.bgA(), 1.0F));
        break;
        ((View)localObject).setFocusable(true);
        locala = (a)((View)localObject).getTag();
        locala.lYX.setVisibility(4);
        ((View)localObject).setOnClickListener(null);
        ((View)localObject).setEnabled(false);
        ((View)localObject).setClickable(false);
        a(locala);
      }
      label670:
      return;
      label671:
      paramInt = 0;
    }
  }
  
  private void a(View paramView, b.c paramc)
  {
    if (paramView == null) {
      return;
    }
    a locala = (a)paramView.getTag();
    MallFunction localMallFunction = paramc.lZq;
    int i = paramc.lZr;
    locala.lZd = localMallFunction.lZd;
    locala.lZc = localMallFunction.lZc;
    com.tencent.mm.plugin.mall.b.a.f(locala.lYY, locala.lZc, a.h.mall_index_icon_default);
    locala.lZa.setText(localMallFunction.caU);
    locala.lYZ.setVisibility(8);
    if ((localMallFunction.qzx != null) && (!bk.bl(localMallFunction.qzx.qzF)) && (b(localMallFunction)))
    {
      if (d.bWk().Qz(localMallFunction.npy) != null)
      {
        y.w("MicroMsg.FunctionListAdapter", "show the news : " + d.bWk().Qz(localMallFunction.npy).qzF);
        locala.lZb.setText(localMallFunction.qzx.qzF);
        locala.lZb.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.j(locala.lYZ, locala.lZd);
        locala.lYZ.setVisibility(0);
        paramc = localMallFunction.npy;
        paramView.setOnClickListener(new b.2(this, i, localMallFunction));
        locala.lYX.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        locala.lZf.setVisibility(0);
        locala.lZg.setVisibility(0);
        return;
        locala.lZb.setVisibility(4);
      }
    }
    if ((localMallFunction.qzx != null) && (localMallFunction.qzx.qzK == 1))
    {
      locala.lZb.setText(localMallFunction.qzx.qzF);
      locala.lZb.setVisibility(0);
    }
    for (;;)
    {
      locala.lYZ.setImageBitmap(null);
      locala.lYZ.setVisibility(8);
      break;
      locala.lZb.setText("");
      locala.lZb.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    parama.lZf.setVisibility(4);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    return (paramMallFunction.qzx != null) && (!bk.bl(paramMallFunction.qzx.qzF)) && (b(paramMallFunction)) && (d.bWk().Qz(paramMallFunction.npy) != null);
  }
  
  private static boolean b(MallFunction paramMallFunction)
  {
    boolean bool = false;
    Object localObject = d.bWk().Qz(paramMallFunction.npy);
    if ((localObject == null) || (bk.bl(((MallNews)localObject).pva)) || (!((MallNews)localObject).pva.equals(paramMallFunction.qzx.pva)))
    {
      y.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.qzx.pva, paramMallFunction.caU });
      localObject = d.bWk();
      paramMallFunction = paramMallFunction.qzx;
      if (paramMallFunction == null)
      {
        y.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
        bool = true;
      }
    }
    while (localObject == null) {
      for (;;)
      {
        return bool;
        paramMallFunction.qzL = ("<sysmsg><mallactivitynew><functionid>" + paramMallFunction.ecR + "</functionid><activityid>" + paramMallFunction.pva + "</activityid><type>" + paramMallFunction.type + "</type><showflag>" + paramMallFunction.qzD + "</showflag><newsTipFlag>" + paramMallFunction.qzE + "</newsTipFlag></mallactivitynew></sysmsg>;");
        ((d)localObject).qzO.put(paramMallFunction.ecR, paramMallFunction);
        ((d)localObject).bsi();
      }
    }
    if (!"0".equals(((MallNews)localObject).qzD))
    {
      y.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
      return false;
    }
    y.d("MicroMsg.FunctionListAdapter", "still old news and should show");
    return true;
  }
  
  final boolean bgD()
  {
    if (this.lYN.size() > 3)
    {
      Object localObject = (ArrayList)this.lYN.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((b.c)((ArrayList)localObject).get(0)).lZq.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b.c localc = (b.c)((Iterator)localObject).next();
          if (localc.lZq.type == i) {
            if (a(localc.lZq)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public final int getCount()
  {
    return this.lYN.size();
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
    int j = -1;
    int i;
    if (this.lYQ > 9)
    {
      i = 0;
      int k = 0;
      while (i <= paramInt)
      {
        k += ((ArrayList)this.lYN.get(i)).size();
        i += 1;
      }
      if (this.lYR > 3)
      {
        i = 3;
        j = i;
        if (k < 9) {
          break label592;
        }
        if ((!this.lYP) || (paramInt != i)) {
          break label385;
        }
        j = 1;
      }
    }
    for (;;)
    {
      label93:
      View localView;
      if (paramView == null)
      {
        paramView = new b.b(this);
        localView = this.Lu.inflate(a.g.mall_function_list_line, paramViewGroup, false);
        paramView.lZi = ((LinearLayout)localView.findViewById(a.f.mall_function_list_line_container));
        paramView.lZj = ((TextView)localView.findViewById(a.f.mall_fucntion_list_section_title));
        paramView.lZk = localView.findViewById(a.f.divider);
        paramView.lZl = localView.findViewById(a.f.line_margin);
        paramView.lZm = localView.findViewById(a.f.mall_show_more_function_switch);
        paramView.lZo = ((TextView)localView.findViewById(a.f.mall_show_more_tv));
        paramView.lZn = ((ImageView)localView.findViewById(a.f.mall_show_more_arrow));
        paramView.lZp = localView.findViewById(a.f.more_function_reddot);
        paramView.lZm.setOnClickListener(new b.1(this));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        label251:
        if (j == 0) {
          break label474;
        }
        paramViewGroup.lZj.setVisibility(8);
        paramViewGroup.lZk.setVisibility(8);
        paramViewGroup.lZl.setVisibility(8);
        paramViewGroup.lZm.setVisibility(0);
        paramViewGroup.lZn.setImageResource(a.h.wallet_arrow_down);
        paramViewGroup.lZo.setText(this.mContext.getString(a.i.mall_index_show_more));
        if ((!this.lYS) || (this.lYT)) {
          break label428;
        }
        paramViewGroup.lZp.setVisibility(0);
      }
      for (;;)
      {
        if (!this.lYP) {
          break label440;
        }
        paramViewGroup.lZi.setVisibility(8);
        paramViewGroup.lZo.setText(this.mContext.getString(a.i.mall_index_show_more));
        return localView;
        i = this.lYR;
        break;
        label385:
        j = i;
        if (paramInt != this.lYR) {
          break label592;
        }
        j = i;
        if (this.lYP) {
          break label592;
        }
        j = 1;
        break label93;
        paramViewGroup = (b.b)paramView.getTag();
        localView = paramView;
        break label251;
        label428:
        paramViewGroup.lZp.setVisibility(8);
      }
      label440:
      paramViewGroup.lZi.setVisibility(0);
      a(paramInt, paramViewGroup);
      paramViewGroup.lZo.setText(this.mContext.getString(a.i.mall_index_hide_more));
      return localView;
      label474:
      if ((i > 0) && (this.lYP) && (paramInt >= i) && (paramInt <= this.lYR))
      {
        paramViewGroup.lZi.setVisibility(8);
        paramViewGroup.lZm.setVisibility(8);
        paramViewGroup.lZp.setVisibility(8);
        paramViewGroup.lZj.setVisibility(8);
        paramViewGroup.lZk.setVisibility(8);
        paramViewGroup.lZl.setVisibility(8);
        return localView;
      }
      paramViewGroup.lZi.setVisibility(0);
      a(paramInt, paramViewGroup);
      paramViewGroup.lZm.setVisibility(8);
      paramViewGroup.lZp.setVisibility(8);
      return localView;
      label592:
      i = j;
      j = 0;
    }
  }
  
  final class a
  {
    public View lYX = null;
    public ImageView lYY = null;
    public ImageView lYZ = null;
    public TextView lZa = null;
    public TextView lZb = null;
    public String lZc = null;
    public String lZd = null;
    public ImageView lZe = null;
    public ImageView lZf = null;
    public ImageView lZg = null;
    public ImageView lZh = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */