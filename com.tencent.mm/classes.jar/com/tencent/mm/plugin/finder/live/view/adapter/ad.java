package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.b;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$ProductEditViewHolder;", "enableSetRecommend", "", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/EditData;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getEnableSetRecommend", "()Z", "setEnableSetRecommend", "itemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "product", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "otherItem", "", "getOtherItem", "()Ljava/util/List;", "setOtherItem", "(Ljava/util/List;)V", "priceViewConfig", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "getPriceViewConfig", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "setPriceViewConfig", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;)V", "recommendWordingCallback", "Lkotlin/Function2;", "", "productId", "", "wording", "getRecommendWordingCallback", "()Lkotlin/jvm/functions/Function2;", "setRecommendWordingCallback", "(Lkotlin/jvm/functions/Function2;)V", "removedList", "getRemovedList", "bindProductItem", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "select", "holder", "position", "deleteProducts", "getItemCount", "getPositionText", "getProductIdList", "haveSelectAllProduct", "haveSelectProduct", "moveProductItem", "from", "to", "moveSelectItem", "notifyItemRangeRefresh", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "onItemClickListener", "printInfo", "list", "tag", "printRvListInfo", "resetSelectProductItems", "selectAllProducts", "selectCount", "showInput", "et", "Landroid/widget/EditText;", "showRecommendBottomSheet", "context", "Landroid/content/Context;", "promotingWording", "updateProductList", "Ljava/util/LinkedList;", "updateProductRecommendWording", "Companion", "ProductEditViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends RecyclerView.a<b>
{
  public static final ad.a DSN;
  public q<? super View, ? super Integer, ? super cc, ah> DPR;
  public boolean DSO;
  public final ArrayList<Long> DSP;
  public List<? extends cc> DSQ;
  public FinderLiveShoppingPriceView.b DSR;
  public m<? super Long, ? super String, ah> DSS;
  public ArrayList<a> pUj;
  
  static
  {
    AppMethodBeat.i(358995);
    DSN = new ad.a((byte)0);
    AppMethodBeat.o(358995);
  }
  
  private ad()
  {
    AppMethodBeat.i(358863);
    this.DSO = true;
    this.pUj = new ArrayList();
    this.DSP = new ArrayList();
    FinderLiveShoppingPriceView.a locala = FinderLiveShoppingPriceView.DPr;
    this.DSR = FinderLiveShoppingPriceView.evI();
    AppMethodBeat.o(358863);
  }
  
  private final String Pz(int paramInt)
  {
    AppMethodBeat.i(358892);
    int i = getItemCount();
    AppMethodBeat.o(358892);
    return String.valueOf(i - paramInt);
  }
  
  private static final void a(Context paramContext, ad paramad, long paramLong, EditText paramEditText, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(358956);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramad, "this$0");
    kotlin.g.b.s.u(paramString1, "$promotingWording");
    ((MMActivity)paramContext).hideVKB();
    if (paramBoolean)
    {
      paramContext = new JSONObject();
      paramContext.put("type", "4");
      paramContext.put("product", com.tencent.mm.ae.d.hF(paramLong));
      paramContext.put("comment", paramString1);
      paramString1 = j.Dob;
      paramContext = paramContext.toString();
      kotlin.g.b.s.s(paramContext, "this.toString()");
      paramString1.axp(n.bV(paramContext, ",", ";"));
      paramContext = paramad.DSS;
      if (paramContext != null)
      {
        paramContext.invoke(Long.valueOf(paramLong), paramEditText.getText().toString());
        AppMethodBeat.o(358956);
      }
    }
    else
    {
      paramContext = new JSONObject();
      paramContext.put("type", "5");
      paramContext.put("product", com.tencent.mm.ae.d.hF(paramLong));
      paramContext.put("comment", paramString1);
      paramad = j.Dob;
      paramContext = paramContext.toString();
      kotlin.g.b.s.s(paramContext, "this.toString()");
      paramad.axp(n.bV(paramContext, ",", ";"));
    }
    AppMethodBeat.o(358956);
  }
  
  private static final void a(Context paramContext, String paramString1, String paramString2, ad paramad, long paramLong, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(358966);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramString1, "$promotingWording");
    kotlin.g.b.s.u(paramString2, "$actionWording");
    kotlin.g.b.s.u(paramad, "this$0");
    paramMenuItem = View.inflate(paramContext, p.f.Cfk, null);
    EditText localEditText = (EditText)paramMenuItem.findViewById(p.e.BVF);
    ImageView localImageView = (ImageView)paramMenuItem.findViewById(p.e.fEU);
    localImageView.setImageDrawable(bb.m(MMApplicationContext.getContext(), p.g.icons_filled_close2, paramContext.getResources().getColor(p.b.BW_0_Alpha_0_3)));
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(localEditText, null, 30, 15, false, (kotlin.g.a.a)new ad.c(localEditText, localImageView));
    localImageView.setOnClickListener(new ad..ExternalSyntheticLambda0(localEditText));
    localEditText.setText((CharSequence)paramString1);
    localEditText.postDelayed(new ad..ExternalSyntheticLambda8(localEditText, paramString1, paramad), 300L);
    paramString1 = new g.a(paramContext).bf((CharSequence)paramString2).mg(paramMenuItem).c(new ad..ExternalSyntheticLambda7(paramContext, paramad, paramLong, localEditText, paramString1));
    paramString1.show();
    paramString1 = paramString1.pRv;
    paramString1.setBackground(p.d.popup_bg_without_shadow);
    paramString1.ayj(paramContext.getResources().getColor(p.b.normal_text_color));
    paramString1.setTitleColor(paramContext.getResources().getColor(p.b.normal_text_color));
    AppMethodBeat.o(358966);
  }
  
  private static final void a(EditText paramEditText, View paramView)
  {
    AppMethodBeat.i(358935);
    paramEditText.setText((CharSequence)"");
    AppMethodBeat.o(358935);
  }
  
  private static final void a(EditText paramEditText, String paramString, ad paramad)
  {
    Object localObject = null;
    AppMethodBeat.i(358944);
    kotlin.g.b.s.u(paramString, "$promotingWording");
    kotlin.g.b.s.u(paramad, "this$0");
    for (;;)
    {
      try
      {
        paramEditText.setSelection(paramString.length());
        if (paramEditText == null) {
          break label107;
        }
        paramEditText.requestFocus();
      }
      catch (Exception paramEditText)
      {
        paramString = aw.Gjk;
        aw.a(paramEditText, "FinderLiveShoppingEditAdapter");
        AppMethodBeat.o(358944);
        return;
      }
      paramString = (InputMethodManager)paramString;
      if (paramString != null) {
        paramString.showSoftInput((View)paramEditText, 0);
      }
      AppMethodBeat.o(358944);
      return;
      paramad = paramEditText.getContext();
      paramString = localObject;
      if (paramad != null)
      {
        paramString = paramad.getSystemService("input_method");
        continue;
        label107:
        if (paramEditText == null) {
          paramString = localObject;
        }
      }
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(358907);
    kotlin.g.b.s.u(paramb, "holder");
    Object localObject1 = this.pUj.get(paramInt);
    kotlin.g.b.s.s(localObject1, "dataList[position]");
    a locala = (a)localObject1;
    k localk = locala.DPG;
    boolean bool2 = locala.CIw;
    localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject1 = com.tencent.mm.plugin.finder.loader.p.eCn();
    Object localObject2 = localk.DVl;
    kotlin.g.b.s.s(localObject2, "item.img_urls");
    localObject2 = new com.tencent.mm.plugin.finder.loader.b((String)kotlin.a.p.oL((List)localObject2));
    Object localObject3 = paramb.DST;
    kotlin.g.b.s.s(localObject3, "holder.productImg");
    Object localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExV));
    paramb.DSU.setText((CharSequence)Pz(paramInt));
    localObject1 = ae.DTf;
    localObject4 = paramb.DSV;
    kotlin.g.b.s.s(localObject4, "holder.productDesc");
    localObject2 = localk.DUT;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject3 = localk.title;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    ae.a.a((TextView)localObject4, (String)localObject1, (String)localObject2);
    localObject2 = localk.ewd();
    localObject1 = ae.DTf;
    localObject3 = paramb.DSX;
    kotlin.g.b.s.s(localObject3, "holder.productStock");
    localObject4 = paramb.DSZ;
    kotlin.g.b.s.s(localObject4, "holder.sourceDivider");
    TextView localTextView = paramb.DSY;
    kotlin.g.b.s.s(localTextView, "holder.productSource");
    int i;
    label289:
    boolean bool1;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label499;
      }
      i = localk.DVm;
      if (localObject2 == null) {
        break label508;
      }
      bool1 = true;
      label297:
      localObject2 = localk.DUT;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ae.a.a((TextView)localObject3, (View)localObject4, localTextView, i, bool1, (String)localObject1, localk.DVs);
      localObject1 = paramb.DTa;
      kotlin.g.b.s.s(localObject1, "holder.priceView");
      FinderLiveShoppingPriceView.a((FinderLiveShoppingPriceView)localObject1, localk, this.DSR);
      paramb.checkBox.setChecked(bool2);
      if (!this.DSO) {
        break label548;
      }
      localObject1 = (CharSequence)localk.DVj.ZVe;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label514;
      }
      i = 1;
      label408:
      if (i == 0) {
        break label519;
      }
      paramb.DSW.setText((CharSequence)"");
      paramb.DSW.setVisibility(8);
      label434:
      paramb.DTb.setVisibility(0);
      paramb.DTb.setOnClickListener(new ad..ExternalSyntheticLambda2(this, paramb, localk));
    }
    for (;;)
    {
      paramb.caK.setOnClickListener(new ad..ExternalSyntheticLambda1(this, paramb, paramInt, locala));
      AppMethodBeat.o(358907);
      return;
      localObject1 = Integer.valueOf(((aoj)localObject2).DVm);
      break;
      label499:
      i = ((Integer)localObject1).intValue();
      break label289;
      label508:
      bool1 = false;
      break label297;
      label514:
      i = 0;
      break label408;
      label519:
      paramb.DSW.setText((CharSequence)localk.DVj.ZVe);
      paramb.DSW.setVisibility(0);
      break label434;
      label548:
      paramb.DSW.setVisibility(8);
      paramb.DTb.setVisibility(8);
    }
  }
  
  private static final void a(ad paramad, b paramb, int paramInt, a parama, View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(358988);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramad, "this$0");
    kotlin.g.b.s.u(paramb, "$holder");
    kotlin.g.b.s.u(parama, "$item");
    if (!parama.CIw)
    {
      bool1 = true;
      parama.CIw = bool1;
      paramView = paramb.checkBox;
      if (parama.CIw != true) {
        break label213;
      }
    }
    label213:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      paramad = paramad.DPR;
      if (paramad != null)
      {
        paramb = paramb.caK;
        kotlin.g.b.s.s(paramb, "holder.itemView");
        paramad.invoke(paramb, Integer.valueOf(paramInt), parama.DPG);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358988);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static final void a(ad paramad, b paramb, k paramk, View paramView)
  {
    AppMethodBeat.i(358982);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramb);
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramad, "this$0");
    kotlin.g.b.s.u(paramb, "$holder");
    kotlin.g.b.s.u(paramk, "$item");
    localObject = new JSONObject();
    ((JSONObject)localObject).put("type", "1");
    ((JSONObject)localObject).put("product", com.tencent.mm.ae.d.hF(paramk.DVk));
    paramView = j.Dob;
    localObject = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(localObject, "this.toString()");
    paramView.axp(n.bV((String)localObject, ",", ";"));
    paramView = paramb.caK.getContext();
    kotlin.g.b.s.s(paramView, "holder.itemView.context");
    long l = paramk.DVk;
    paramk = paramk.DVj.ZVe;
    paramb = paramk;
    if (paramk == null) {
      paramb = "";
    }
    int i;
    if (((CharSequence)paramb).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label411;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", "2");
      ((JSONObject)localObject).put("product", com.tencent.mm.ae.d.hF(l));
      paramk = j.Dob;
      localObject = ((JSONObject)localObject).toString();
      kotlin.g.b.s.s(localObject, "this.toString()");
      paramk.axp(n.bV((String)localObject, ",", ";"));
    }
    for (paramk = paramView.getString(p.h.CsE);; paramk = paramView.getString(p.h.CsF))
    {
      kotlin.g.b.s.s(paramk, "if (promotingWording.isE…ommend_wording)\n        }");
      localObject = new f(paramView, 1, false);
      ((f)localObject).Vtg = new ad..ExternalSyntheticLambda3(paramb, paramk);
      ((f)localObject).ages = new ad..ExternalSyntheticLambda5(paramb, l);
      ((f)localObject).aeLi = ad..ExternalSyntheticLambda6.INSTANCE;
      ((f)localObject).GAC = new ad..ExternalSyntheticLambda4(paramView, paramb, paramk, paramad, l);
      ((f)localObject).dDn();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358982);
      return;
      i = 0;
      break;
      label411:
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", "6");
      ((JSONObject)localObject).put("product", com.tencent.mm.ae.d.hF(l));
      ((JSONObject)localObject).put("comment", paramb);
      paramk = j.Dob;
      localObject = ((JSONObject)localObject).toString();
      kotlin.g.b.s.s(localObject, "this.toString()");
      paramk.axp(n.bV((String)localObject, ",", ";"));
    }
  }
  
  private static final void a(String paramString1, String paramString2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(358914);
    kotlin.g.b.s.u(paramString1, "$promotingWording");
    kotlin.g.b.s.u(paramString2, "$actionWording");
    int i;
    if (((CharSequence)paramString1).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label74;
      }
      params.c(1001, (CharSequence)paramString2);
    }
    for (;;)
    {
      Log.i("FinderLiveShoppingEditAdapter", kotlin.g.b.s.X("promotingWording:", paramString1));
      AppMethodBeat.o(358914);
      return;
      i = 0;
      break;
      label74:
      params.c(1001, (CharSequence)paramString2);
    }
  }
  
  private static final void aC(String paramString, long paramLong)
  {
    AppMethodBeat.i(358920);
    kotlin.g.b.s.u(paramString, "$promotingWording");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", "3");
      ((JSONObject)localObject).put("product", com.tencent.mm.ae.d.hF(paramLong));
      paramString = j.Dob;
      localObject = ((JSONObject)localObject).toString();
      kotlin.g.b.s.s(localObject, "this.toString()");
      paramString.axp(n.bV((String)localObject, ",", ";"));
      AppMethodBeat.o(358920);
      return;
    }
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("type", "7");
    ((JSONObject)localObject).put("product", com.tencent.mm.ae.d.hF(paramLong));
    ((JSONObject)localObject).put("comment", paramString);
    paramString = j.Dob;
    localObject = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(localObject, "this.toString()");
    paramString.axp(n.bV((String)localObject, ",", ";"));
    AppMethodBeat.o(358920);
  }
  
  public static void e(ArrayList<a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(358884);
    Object localObject = aw.Gjk;
    if (aw.bgV())
    {
      paramString = new StringBuilder(kotlin.g.b.s.X(paramString, ":"));
      if (paramArrayList != null)
      {
        paramArrayList = ((Iterable)paramArrayList).iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localObject = paramArrayList.next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject = (a)localObject;
          paramString.append("[" + i + ',' + ((a)localObject).DPG.DVk + ']');
          i += 1;
        }
      }
      Log.i("FinderLiveShoppingEditAdapter", paramString.toString());
    }
    AppMethodBeat.o(358884);
  }
  
  private static final void evW()
  {
    AppMethodBeat.i(358929);
    Log.i("FinderLiveShoppingEditAdapter", "onDismissclick");
    AppMethodBeat.o(358929);
  }
  
  public static void m(List<? extends cc> paramList, String paramString)
  {
    AppMethodBeat.i(358876);
    paramString = new StringBuilder(kotlin.g.b.s.X(paramString, ":"));
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject = (cc)localObject;
        paramString.append("[" + i + ',' + ((cc)localObject).bZA() + ']');
        i += 1;
      }
    }
    Log.i("FinderLiveShoppingEditAdapter", paramString.toString());
    AppMethodBeat.o(358876);
  }
  
  public final List<Long> evR()
  {
    AppMethodBeat.i(359064);
    Object localObject2 = (Iterable)this.pUj;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Long.valueOf(((a)((Iterator)localObject2).next()).DPG.DVk));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(359064);
    return localObject1;
  }
  
  public final int evS()
  {
    AppMethodBeat.i(359067);
    Object localObject = (Iterable)this.pUj;
    if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty()))
    {
      AppMethodBeat.o(359067);
      return 0;
    }
    localObject = ((Iterable)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((a)((Iterator)localObject).next()).CIw) {
        break label100;
      }
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        kotlin.a.p.kkX();
        i = j;
      }
    }
    label100:
    for (;;)
    {
      break;
      AppMethodBeat.o(359067);
      return i;
    }
  }
  
  public final void evT()
  {
    AppMethodBeat.i(359071);
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).CIw = false;
    }
    AppMethodBeat.o(359071);
  }
  
  public final void evU()
  {
    AppMethodBeat.i(359077);
    e(0, getItemCount(), Integer.valueOf(1));
    AppMethodBeat.o(359077);
  }
  
  public final void evV()
  {
    AppMethodBeat.i(359085);
    try
    {
      Iterator localIterator = this.pUj.iterator();
      kotlin.g.b.s.s(localIterator, "dataList.iterator()");
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        kotlin.g.b.s.s(localObject, "iterator.next()");
        localObject = (a)localObject;
        if (((a)localObject).CIw)
        {
          localIterator.remove();
          this.DSP.add(Long.valueOf(((a)localObject).DPG.DVk));
        }
      }
      e(this.pUj, "after deleteProducts");
    }
    catch (Exception localException)
    {
      localObject = aw.Gjk;
      aw.a(localException, "FinderLiveShoppingEditAdapter,deleteProducts:");
      AppMethodBeat.o(359085);
      return;
    }
    AppMethodBeat.o(359085);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(359092);
    int i = this.pUj.size();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveShoppingEditAdapter", kotlin.g.b.s.X("getItemCount ", Integer.valueOf(i)));
    AppMethodBeat.o(359092);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter$ProductEditViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingEditAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "priceView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;", "getPriceView", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;", "setPriceView", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;)V", "productDesc", "Landroid/widget/TextView;", "getProductDesc", "()Landroid/widget/TextView;", "setProductDesc", "(Landroid/widget/TextView;)V", "productImg", "Landroid/widget/ImageView;", "getProductImg", "()Landroid/widget/ImageView;", "setProductImg", "(Landroid/widget/ImageView;)V", "productSeq", "getProductSeq", "setProductSeq", "productSource", "getProductSource", "setProductSource", "productStock", "getProductStock", "setProductStock", "recommendEdit", "getRecommendEdit", "setRecommendEdit", "recommendWording", "getRecommendWording", "setRecommendWording", "sourceDivider", "getSourceDivider", "()Landroid/view/View;", "setSourceDivider", "(Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    ImageView DST;
    TextView DSU;
    TextView DSV;
    TextView DSW;
    TextView DSX;
    TextView DSY;
    View DSZ;
    FinderLiveShoppingPriceView DTa;
    ImageView DTb;
    CheckBox checkBox;
    
    public b()
    {
      super();
      AppMethodBeat.i(358839);
      this.checkBox = ((CheckBox)localObject.findViewById(p.e.CaR));
      this.DST = ((ImageView)localObject.findViewById(p.e.BZP));
      this.DSU = ((TextView)localObject.findViewById(p.e.BZV));
      this.DSV = ((TextView)localObject.findViewById(p.e.BZN));
      this.DSW = ((TextView)localObject.findViewById(p.e.Cah));
      this.DSX = ((TextView)localObject.findViewById(p.e.BZY));
      this.DSY = ((TextView)localObject.findViewById(p.e.BZW));
      this.DSZ = localObject.findViewById(p.e.BZX);
      this.DTa = ((FinderLiveShoppingPriceView)localObject.findViewById(p.e.BZK));
      this.DTb = ((ImageView)localObject.findViewById(p.e.BZR));
      AppMethodBeat.o(358839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ad
 * JD-Core Version:    0.7.0.1
 */