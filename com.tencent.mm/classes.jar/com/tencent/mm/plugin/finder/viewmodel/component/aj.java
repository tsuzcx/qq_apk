package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.pluginsdk.ui.span.p.b;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.protocal.protobuf.gim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinEncashLogicDelegate;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "bottomNoteText", "Landroid/widget/TextView;", "currentEntryCount", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$FinderLiveIncomePageItemData;", "Lkotlin/collections/ArrayList;", "entryContainer", "Landroid/widget/LinearLayout;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveIncomePageResponse;", "encashDidFail", "", "encashDidSuccess", "getLayoutId", "initData", "initView", "insertEntry", "wording", "", "actionType", "actionUrl", "appId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "realNameDidSuccess", "refreshEncashInfo", "Companion", "FinderLiveIncomePageItemData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends UIComponent
  implements com.tencent.mm.plugin.wallet.wecoin.a.j
{
  public static final a GSf;
  private WxRecyclerView BrC;
  private LinearLayout GSg;
  private TextView GSh;
  private final azj GSi;
  private int GSj;
  private final ArrayList<b> data;
  
  static
  {
    AppMethodBeat.i(338786);
    GSf = new a((byte)0);
    AppMethodBeat.o(338786);
  }
  
  public aj(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338751);
    this.data = new ArrayList();
    this.GSi = new azj();
    AppMethodBeat.o(338751);
  }
  
  public aj(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338757);
    this.data = new ArrayList();
    this.GSi = new azj();
    AppMethodBeat.o(338757);
  }
  
  private static final void a(int paramInt, String paramString1, TextView paramTextView, String paramString2, String paramString3)
  {
    AppMethodBeat.i(338775);
    s.u(paramTextView, "$this_apply");
    if (paramInt == 0)
    {
      paramString2 = new Intent();
      paramString2.putExtra("rawUrl", paramString1);
      c.b(paramTextView.getContext(), "webview", ".ui.tools.WebViewUI", paramString2);
      AppMethodBeat.o(338775);
      return;
    }
    paramString3 = new com.tencent.mm.plugin.appbrand.api.g();
    paramString3.appId = paramString2;
    paramString3.qAF = paramString1;
    paramString3.scene = 1205;
    ((t)h.ax(t.class)).a(paramTextView.getContext(), paramString3);
    AppMethodBeat.o(338775);
  }
  
  private final void foc()
  {
    AppMethodBeat.i(338767);
    Log.i("MicroMsg.FinderLiveIncomeListUIC", "refreshEncashInfo");
    d locald = (d)h.ax(d.class);
    Object localObject = (Iterable)this.data;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(Integer.valueOf(((b)((Iterator)localObject).next()).GSk.ZRM));
    }
    locald.a(new LinkedList((Collection)localCollection), (com.tencent.mm.plugin.wallet.wecoin.a.i)new d(this));
    AppMethodBeat.o(338767);
  }
  
  public final void fod()
  {
    AppMethodBeat.i(338844);
    Log.i("MicroMsg.FinderLiveIncomeListUIC", "realNameDidSuccess callback");
    foc();
    AppMethodBeat.o(338844);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_live_income_list_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338835);
    super.onCreate(paramBundle);
    paramBundle = findViewById(e.e.entry_container);
    s.s(paramBundle, "findViewById(R.id.entry_container)");
    this.GSg = ((LinearLayout)paramBundle);
    paramBundle = findViewById(e.e.list);
    Object localObject1 = (WxRecyclerView)paramBundle;
    ((WxRecyclerView)localObject1).getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    localObject1 = ah.aiuX;
    s.s(paramBundle, "findViewById<WxRecyclerV…ERTICAL, false)\n        }");
    this.BrC = ((WxRecyclerView)paramBundle);
    paramBundle = findViewById(e.e.bottom_note);
    s.s(paramBundle, "findViewById(R.id.bottom_note)");
    this.GSh = ((TextView)paramBundle);
    try
    {
      this.GSi.parseFrom(getIntent().getByteArrayExtra("PARAMS_DATA"));
      Log.i("MicroMsg.FinderLiveIncomeListUIC", s.X("initData ", com.tencent.mm.ae.f.dg(this.GSi)));
      if (this.GSi.nUC.isEmpty())
      {
        getActivity().finish();
        AppMethodBeat.o(338835);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FinderLiveIncomeListUIC", paramBundle, String.valueOf(paramBundle.getMessage()), new Object[0]);
      }
      paramBundle = this.GSi.lym;
      int i;
      if (paramBundle != null) {
        if (((CharSequence)paramBundle).length() > 0)
        {
          i = 1;
          if (i != 1) {
            break label447;
          }
          i = 1;
          label231:
          if (i == 0) {
            break label455;
          }
          localObject1 = this.GSh;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            s.bIx("bottomNoteText");
            paramBundle = null;
          }
          paramBundle.setVisibility(0);
          paramBundle = this.GSh;
          if (paramBundle != null) {
            break label452;
          }
          s.bIx("bottomNoteText");
          paramBundle = null;
          label279:
          paramBundle.setText((CharSequence)getResources().getString(e.h.finder_live_income_cocert_activate_title_2, new Object[] { this.GSi.lym }));
          label310:
          paramBundle = this.GSi.nUC;
          s.s(paramBundle, "resp.items");
          localObject1 = (Iterable)paramBundle;
          paramBundle = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
        }
      }
      label351:
      Object localObject3;
      label413:
      label420:
      label447:
      label452:
      label455:
      label491:
      label496:
      label499:
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label501;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (bio)localObject2;
        if (((bio)localObject3).YEX == 2)
        {
          localObject3 = ((bio)localObject3).wording;
          if (localObject3 != null) {
            if (((CharSequence)localObject3).length() > 0)
            {
              i = 1;
              if (i != 1) {
                break label491;
              }
              i = 1;
              if (i == 0) {
                break label496;
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label499;
          }
          paramBundle.add(localObject2);
          break label351;
          i = 0;
          break;
          i = 0;
          break label231;
          break label279;
          localObject1 = this.GSh;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            s.bIx("bottomNoteText");
            paramBundle = null;
          }
          paramBundle.setVisibility(8);
          break label310;
          i = 0;
          break label413;
          i = 0;
          break label420;
        }
      }
      label501:
      Object localObject2 = ((Iterable)paramBundle).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (bio)((Iterator)localObject2).next();
        localObject1 = ((bio)localObject4).wording;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        i = ((bio)localObject4).wuj;
        localObject3 = ((bio)localObject4).Kru;
        localObject4 = ((bio)localObject4).ZRN;
        int j = this.GSj;
        this.GSj = (j + 1);
        Object localObject5;
        if (j > 0)
        {
          localObject5 = new View((Context)getContext());
          ((View)localObject5).setBackgroundResource(e.b.small_line_color);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 1), com.tencent.mm.cd.a.bs((Context)getContext(), e.c.Edge_2A));
          localLayoutParams.setMargins(com.tencent.mm.cd.a.bs((Context)getContext(), e.c.Edge_A), 0, com.tencent.mm.cd.a.bs((Context)getContext(), e.c.Edge_A), 0);
          localObject1 = this.GSg;
          if (localObject1 == null)
          {
            s.bIx("entryContainer");
            localObject1 = null;
            label702:
            ((LinearLayout)localObject1).addView((View)localObject5, (ViewGroup.LayoutParams)localLayoutParams);
          }
        }
        else
        {
          localObject1 = new TextView((Context)getContext());
          ((TextView)localObject1).setTextSize(1, 14.0F);
          com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject1);
          localObject5 = new SpannableString((CharSequence)paramBundle);
          ((SpannableString)localObject5).setSpan(new p.b("", ((TextView)localObject1).getContext().getResources().getColor(e.b.link_color), ((TextView)localObject1).getContext().getResources().getColor(e.b.BW_0_Alpha_0_2), true, new aj..ExternalSyntheticLambda0(i, (String)localObject3, (TextView)localObject1, (String)localObject4)), 0, paramBundle.length(), 17);
          ((TextView)localObject1).setText((CharSequence)localObject5);
          com.tencent.mm.pluginsdk.ui.span.p.a((TextView)localObject1, (Spannable)localObject5);
          paramBundle = this.GSg;
          if (paramBundle != null) {
            break label888;
          }
          s.bIx("entryContainer");
          paramBundle = null;
        }
        label888:
        for (;;)
        {
          paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
          break;
          break label702;
        }
      }
      this.data.clear();
      paramBundle = this.data;
      localObject1 = this.GSi.nUC;
      s.s(localObject1, "resp.items");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label1001:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((bio)localObject3).YEX == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1001;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bio)((Iterator)localObject2).next();
        s.s(localObject3, "it");
        ((Collection)localObject1).add(new b((bio)localObject3));
      }
      paramBundle.addAll((Collection)localObject1);
      paramBundle = this.BrC;
      if (paramBundle != null) {
        break label1161;
      }
    }
    s.bIx("listView");
    paramBundle = null;
    label1161:
    for (;;)
    {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new c(this), this.data));
      foc();
      AppMethodBeat.o(338835);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$Companion;", "", "()V", "ACTION_TYPE_H5", "", "ACTION_TYPE_WEAPP", "PAGE_TYPE_BOTTOM_ACTIVITIY", "PAGE_TYPE_WECOIN", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$FinderLiveIncomePageItemData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "item", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIncomePageItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveIncomePageItem;)V", "authInfo", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "getAuthInfo", "()Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "setAuthInfo", "(Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;)V", "balance", "", "getBalance", "()Ljava/lang/Long;", "setBalance", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "incomeBillUrl", "", "getIncomeBillUrl", "()Ljava/lang/String;", "setIncomeBillUrl", "(Ljava/lang/String;)V", "getItem", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveIncomePageItem;", "taxCutInfo", "Lcom/tencent/mm/protocal/protobuf/WecoinTaxCutEntranceInfo;", "getTaxCutInfo", "()Lcom/tencent/mm/protocal/protobuf/WecoinTaxCutEntranceInfo;", "setTaxCutInfo", "(Lcom/tencent/mm/protocal/protobuf/WecoinTaxCutEntranceInfo;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements cc
  {
    final bio GSk;
    Long GSl;
    gim GSm;
    emd GSn;
    String GSo;
    
    public b(bio parambio)
    {
      AppMethodBeat.i(337801);
      this.GSk = parambio;
      AppMethodBeat.o(337801);
    }
    
    public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
    {
      AppMethodBeat.i(337824);
      s.u(paramk, "obj");
      if ((paramk instanceof b)) {
        paramk = (b)paramk;
      }
      while (paramk != null) {
        if (Util.isEqual(paramk.bZA(), bZA()))
        {
          AppMethodBeat.o(337824);
          return 0;
          paramk = null;
        }
        else
        {
          AppMethodBeat.o(337824);
          return -1;
        }
      }
      AppMethodBeat.o(337824);
      return -1;
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(337810);
      long l = (this.GSk.wuj + '_' + this.GSk.wording + '_' + this.GSk.ZRM).hashCode();
      AppMethodBeat.o(337810);
      return l;
    }
    
    public final int bZB()
    {
      AppMethodBeat.i(337817);
      int i = b.class.hashCode();
      AppMethodBeat.o(337817);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$initData$5", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    c(aj paramaj) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(337830);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this.GSp);
      AppMethodBeat.o(337830);
      return localf;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$initData$5$getItemConvert$1", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$FinderLiveIncomePageItemData;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends com.tencent.mm.view.recyclerview.f<aj.b>
    {
      a(aj paramaj) {}
      
      private static final void a(aj.b paramb, aj paramaj, View paramView)
      {
        AppMethodBeat.i(337854);
        Object localObject1 = new Object();
        Object localObject2 = new b();
        ((b)localObject2).cH(paramb);
        ((b)localObject2).cH(paramaj);
        ((b)localObject2).cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$initData$5$getItemConvert$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
        s.u(paramb, "$item");
        s.u(paramaj, "this$0");
        paramView = paramb.GSl;
        Long localLong;
        if (paramView == null)
        {
          l = 0L;
          if (l > 0L)
          {
            paramView = (d)h.ax(d.class);
            localObject1 = (MMActivity)paramaj.getContext();
            localObject2 = new com.tencent.mm.plugin.wallet.wecoin.a.k();
            ((com.tencent.mm.plugin.wallet.wecoin.a.k)localObject2).Vuf = paramb.GSk.ZRM;
            localLong = paramb.GSl;
            if (localLong != null) {
              break label219;
            }
          }
        }
        label219:
        for (long l = 0L;; l = localLong.longValue())
        {
          ((com.tencent.mm.plugin.wallet.wecoin.a.k)localObject2).Vug = l;
          ((com.tencent.mm.plugin.wallet.wecoin.a.k)localObject2).GSm = paramb.GSm;
          ((com.tencent.mm.plugin.wallet.wecoin.a.k)localObject2).GSn = paramb.GSn;
          paramb = ah.aiuX;
          paramView.a((MMActivity)localObject1, (com.tencent.mm.plugin.wallet.wecoin.a.k)localObject2, new WeakReference(paramaj));
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$initData$5$getItemConvert$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(337854);
          return;
          l = paramView.longValue();
          break;
        }
      }
      
      private static final void b(aj.b paramb, aj paramaj, View paramView)
      {
        AppMethodBeat.i(337869);
        Object localObject = new Object();
        b localb = new b();
        localb.cH(paramb);
        localb.cH(paramaj);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$initData$5$getItemConvert$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramb, "$item");
        s.u(paramaj, "this$0");
        paramView = paramb.GSo;
        if (paramView != null) {
          if (((CharSequence)paramView).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label193;
            }
          }
        }
        label193:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramView = new Intent();
            paramView.putExtra("allow_mix_content_mode", false);
            paramView.putExtra("rawUrl", paramb.GSo);
            paramView.putExtra("showShare", false);
            paramView.putExtra(f.s.adxf, true);
            c.b((Context)paramaj.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$initData$5$getItemConvert$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(337869);
          return;
          i = 0;
          break;
        }
      }
      
      public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
      {
        AppMethodBeat.i(337892);
        s.u(paramRecyclerView, "recyclerView");
        s.u(paramj, "holder");
        AppMethodBeat.o(337892);
      }
      
      public final int getLayoutId()
      {
        return e.f.finder_live_income_list_item;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveIncomeListUIC$refreshEncashInfo$2", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Lcom/tencent/mm/protocal/protobuf/GetEncashPrepareInfoResponse;", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.wallet.wecoin.a.i<cjj>
  {
    d(aj paramaj) {}
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(337775);
      Log.e("MicroMsg.FinderLiveIncomeListUIC", "getEncashPrepareInfo failed: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
      if (paramString != null) {
        if (((CharSequence)paramString).length() > 0)
        {
          paramInt1 = 1;
          if (paramInt1 != 1) {
            break label98;
          }
        }
      }
      label98:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label103;
        }
        aa.dc((Context)this.GSp.getContext(), paramString);
        AppMethodBeat.o(337775);
        return;
        paramInt1 = 0;
        break;
      }
      label103:
      aa.dc((Context)this.GSp.getContext(), this.GSp.getContext().getString(e.h.finder_cgi_failed));
      AppMethodBeat.o(337775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aj
 * JD-Core Version:    0.7.0.1
 */