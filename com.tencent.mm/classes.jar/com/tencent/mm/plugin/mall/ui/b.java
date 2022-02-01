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
  private final int KJO;
  private final int KJP;
  private final int KJQ;
  List<ArrayList<c>> KJR;
  d KJS;
  private boolean KJT;
  private int KJU;
  private int KJV;
  private boolean KJW;
  private boolean KJX;
  private SparseArray<String> KJg;
  private int KJh;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.KJO = 3;
    this.KJP = 9;
    this.KJQ = 3;
    this.KJR = new ArrayList();
    this.KJg = null;
    this.KJT = true;
    this.KJU = 0;
    this.KJV = 0;
    this.KJW = false;
    this.KJX = false;
    this.mContext = paramContext;
    this.KJh = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private View P(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66041);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(a.g.mall_index_function_item, paramViewGroup, false);
    locala.KKb = paramViewGroup.findViewById(a.f.mall_index_function_item_main);
    locala.KKc = ((ImageView)paramViewGroup.findViewById(a.f.mall_index_function_icon));
    locala.KKe = ((TextView)paramViewGroup.findViewById(a.f.mall_index_function_name));
    locala.KKf = ((TextView)paramViewGroup.findViewById(a.f.mall_index_function_activity));
    locala.KKd = ((ImageView)paramViewGroup.findViewById(a.f.new_pic_holder));
    locala.KKi = ((ImageView)paramViewGroup.findViewById(a.f.divider_top));
    locala.KKj = ((ImageView)paramViewGroup.findViewById(a.f.divider_right));
    locala.KKk = ((ImageView)paramViewGroup.findViewById(a.f.divider_bottom));
    locala.KKl = ((ImageView)paramViewGroup.findViewById(a.f.divider_left));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.KJR.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).KKv.type;
      localObject = aao(m);
      j = 0;
      k = 0;
      if (Util.isNullOrNil((String)localObject)) {
        break label683;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.KJR.size() - 1) {
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
        paramb.KKn.setText((CharSequence)localObject);
        paramb.KKn.setVisibility(0);
        paramb.KKo.setVisibility(8);
        paramb.KKp.setVisibility(0);
        paramb.KKn.setMinHeight(a.fZe());
        paramb.KKp.setBackgroundColor(e.fZI());
        localObject = paramb.KKm;
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
        if (((ArrayList)this.KJR.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.KJR.get(paramInt1 - 1)).get(0)).KKv.type) {
          break;
        }
        i = 1;
        break;
        label356:
        j = i;
        if (m == ((c)((ArrayList)this.KJR.get(paramInt1 + 1)).get(0)).KKv.type) {
          break label683;
        }
        paramInt1 = 1;
        break label104;
        paramb.KKn.setVisibility(8);
        paramb.KKo.setVisibility(8);
        paramb.KKp.setVisibility(8);
        break label163;
        paramb.KKn.setVisibility(8);
        paramb.KKo.setVisibility(8);
        paramb.KKp.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label460:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(false);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.KKb.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = P((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.fZc(), 1.0F));
          break;
          paramb.setFocusable(false);
          locala = (a)paramb.getTag();
          locala.KKb.setVisibility(4);
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
    final MallFunction localMallFunction = paramc.KKv;
    final int i = paramc.KKw;
    locala.KKh = localMallFunction.KKh;
    locala.KKg = localMallFunction.KKg;
    com.tencent.mm.plugin.mall.b.b.f(locala.KKc, locala.KKg, a.h.mall_index_icon_default);
    locala.KKe.setText(localMallFunction.idA);
    locala.KKd.setVisibility(8);
    if ((localMallFunction.VKI != null) && (!Util.isNullOrNil(localMallFunction.VKI.VKQ)) && (b(localMallFunction)))
    {
      if (d.ikh().bgQ(localMallFunction.qBb) != null)
      {
        Log.w("MicroMsg.FunctionListAdapter", "show the news : " + d.ikh().bgQ(localMallFunction.qBb).VKQ);
        locala.KKf.setText(localMallFunction.VKI.VKQ);
        locala.KKf.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.b.t(locala.KKd, locala.KKh);
        locala.KKd.setVisibility(0);
        locala.KKb.setTag(a.f.tag_key_data, localMallFunction.idA + this.mContext.getString(a.i.accessibility_wallet_new_function_text));
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66034);
          }
        });
        locala.KKb.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        paramView.setFocusable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.KKf.setVisibility(8);
      }
    }
    if ((localMallFunction.VKI != null) && (localMallFunction.VKI.VKU == 1))
    {
      locala.KKf.setText(localMallFunction.VKI.VKQ);
      locala.KKf.setVisibility(0);
    }
    for (;;)
    {
      locala.KKd.setImageBitmap(null);
      locala.KKd.setVisibility(8);
      locala.KKb.setTag(a.f.tag_key_data, localMallFunction.idA);
      break;
      locala.KKf.setText("");
      locala.KKf.setVisibility(8);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.KKi.setVisibility(0);
    parama.KKj.setVisibility(4);
    parama.KKk.setVisibility(4);
    parama.KKl.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.KKl.setVisibility(4);
    if (paramInt1 == 0) {
      parama.KKj.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.KKi.setVisibility(0);
      parama.KKk.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.KKj.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.KKj.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.KKi.setVisibility(4);
      parama.KKk.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.KKi.setVisibility(0);
    parama.KKk.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.VKI != null) && (!Util.isNullOrNil(paramMallFunction.VKI.VKQ)) && (b(paramMallFunction)) && (d.ikh().bgQ(paramMallFunction.qBb) != null))
    {
      AppMethodBeat.o(66045);
      return true;
    }
    AppMethodBeat.o(66045);
    return false;
  }
  
  private boolean aan(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.KJU > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.KJR.get(j)).size();
        j += 1;
      }
      if (this.KJV > 3)
      {
        j = 3;
        if (i < 9) {
          break label119;
        }
        if ((!this.KJT) || (paramInt != j)) {
          break label98;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.KJV;
      break;
      label98:
      if ((paramInt == this.KJV) && (!this.KJT)) {
        bool = true;
      } else {
        label119:
        bool = false;
      }
    }
  }
  
  private String aao(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.KJg == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.KJg.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private static boolean b(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66047);
    MallNews localMallNews = d.ikh().bgQ(paramMallFunction.qBb);
    if ((localMallNews == null) || (Util.isNullOrNil(localMallNews.rBJ)) || (!localMallNews.rBJ.equals(paramMallFunction.VKI.rBJ)))
    {
      Log.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.VKI.rBJ, paramMallFunction.idA });
      d.ikh().b(paramMallFunction.VKI);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.VKO))
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
  
  private boolean fZh()
  {
    AppMethodBeat.i(66044);
    if (this.KJR.size() > 3)
    {
      Object localObject = (ArrayList)this.KJR.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).KKv.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.KKv.type == i) {
            if (a(localc.KKv))
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
  
  public final void aX(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.KJR.clear();
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
          localc.KKw = (i + j);
          localc.KKv = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.KJR.add(localArrayList);
        }
        i += j;
      }
      this.KJU = 0;
      this.KJV = 0;
      paramArrayList = this.KJR.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).KKv.type))
        {
          this.KJU += localArrayList.size();
          this.KJV += 1;
          i = ((c)localArrayList.get(0)).KKv.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.KJV -= 1;
      this.KJg = k.fZb().aal(this.KJh).KJg;
      this.KJW = fZh();
      Log.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.KJW) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.KJR.size();
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
    boolean bool2 = aan(paramInt);
    if (this.KJU > 9) {
      if (this.KJV <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.KJR.size())) {}
      for (boolean bool1 = aan(paramInt + 1);; bool1 = false)
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
            paramView.KKm = ((LinearLayout)localView.findViewById(a.f.mall_function_list_line_container));
            paramView.KKn = ((TextView)localView.findViewById(a.f.mall_fucntion_list_section_title));
            paramView.KKo = localView.findViewById(a.f.divider);
            paramView.KKp = localView.findViewById(a.f.line_margin);
            paramView.KKq = localView.findViewById(a.f.mall_show_more_function_switch);
            paramView.KKs = ((TextView)localView.findViewById(a.f.mall_show_more_tv));
            paramView.KKr = ((ImageView)localView.findViewById(a.f.mall_show_more_arrow));
            paramView.KKt = localView.findViewById(a.f.more_function_reddot);
            paramView.KKu = localView.findViewById(a.f.bottom_gap);
            paramView.KKq.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(66033);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
            paramViewGroup.KKn.setVisibility(8);
            paramViewGroup.KKo.setVisibility(8);
            paramViewGroup.KKp.setVisibility(8);
            paramViewGroup.KKq.setVisibility(0);
            paramViewGroup.KKr.setImageResource(a.h.icons_outlined_arrow);
            paramViewGroup.KKr.setColorFilter(this.mContext.getResources().getColor(a.c.link_color), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.KKr.setPivotX(paramViewGroup.KKr.getWidth() / 2);
            paramViewGroup.KKr.setPivotY(paramViewGroup.KKr.getHeight() / 2);
            paramViewGroup.KKr.setRotation(90.0F);
            paramViewGroup.KKs.setText(this.mContext.getString(a.i.mall_index_show_more));
            if ((!this.KJW) || (this.KJX)) {
              break label504;
            }
            paramViewGroup.KKt.setVisibility(0);
            label400:
            if (!this.KJT) {
              break label516;
            }
            paramViewGroup.KKm.setVisibility(8);
            paramViewGroup.KKs.setText(this.mContext.getString(a.i.mall_index_show_more));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.KKu.setBackgroundColor(e.fZI());
            paramViewGroup.KKu.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.KJV;
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
            paramViewGroup.KKt.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.KKm.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.KKr.setImageResource(a.h.icons_outlined_arrow);
            paramViewGroup.KKr.setColorFilter(this.mContext.getResources().getColor(a.c.link_color), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.KKr.setPivotX(paramViewGroup.KKr.getWidth() / 2);
            paramViewGroup.KKr.setPivotY(paramViewGroup.KKr.getHeight() / 2);
            paramViewGroup.KKr.setRotation(270.0F);
            paramViewGroup.KKs.setText(this.mContext.getString(a.i.mall_index_hide_more));
            break label433;
            label629:
            if ((j > 0) && (this.KJT) && (paramInt >= j) && (paramInt <= this.KJV))
            {
              paramViewGroup.KKm.setVisibility(8);
              paramViewGroup.KKq.setVisibility(8);
              paramViewGroup.KKt.setVisibility(8);
              paramViewGroup.KKn.setVisibility(8);
              paramViewGroup.KKo.setVisibility(8);
              paramViewGroup.KKp.setVisibility(8);
              break label433;
            }
            paramViewGroup.KKm.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.KKq.setVisibility(8);
            paramViewGroup.KKt.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.KKu.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View KKb = null;
    public ImageView KKc = null;
    public ImageView KKd = null;
    public TextView KKe = null;
    public TextView KKf = null;
    public String KKg = null;
    public String KKh = null;
    public ImageView KKi = null;
    public ImageView KKj = null;
    public ImageView KKk = null;
    public ImageView KKl = null;
    
    a() {}
  }
  
  final class b
  {
    LinearLayout KKm;
    TextView KKn;
    View KKo;
    View KKp;
    View KKq;
    ImageView KKr;
    TextView KKs;
    View KKt = null;
    View KKu;
    
    b() {}
  }
  
  final class c
  {
    MallFunction KKv;
    int KKw;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, MallFunction paramMallFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */