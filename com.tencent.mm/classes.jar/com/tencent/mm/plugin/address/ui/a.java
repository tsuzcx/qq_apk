package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "activity", "Landroid/content/Context;", "initAddress", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/address/model/RcptItem;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "addrMgr", "Lcom/tencent/mm/plugin/address/model/WalletAddrMgr;", "kotlin.jvm.PlatformType", "getCallback", "()Lkotlin/jvm/functions/Function1;", "curAddress", "getInitAddress", "()Ljava/lang/String;", "mTabFour", "Landroid/widget/TextView;", "getMTabFour", "()Landroid/widget/TextView;", "mTabFour$delegate", "Lkotlin/Lazy;", "mTabOne", "getMTabOne", "mTabOne$delegate", "mTabThree", "getMTabThree", "mTabThree$delegate", "mTabTwo", "getMTabTwo", "mTabTwo$delegate", "mViewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMViewPager", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "mViewPager$delegate", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "inflateContentView", "Landroid/view/View;", "initContentView", "setTextBold", "setTextNormal", "AddressConvert", "AddressItem", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.ui.f.a
{
  private static int nmP;
  private static RcptItem nmU;
  public static final a.c nmV;
  public static List<RcptItem> rrs;
  final b<RcptItem, x> callback;
  private final kotlin.f nmG;
  private RcptItem nmL;
  private final com.tencent.mm.plugin.address.model.l nmM;
  private final String nmN;
  private final kotlin.f rnG;
  private final kotlin.f rrm;
  private final kotlin.f rro;
  private final kotlin.f rrq;
  
  static
  {
    AppMethodBeat.i(278925);
    nmV = new a.c((byte)0);
    nmP = 1;
    nmU = new RcptItem("暂不选择", "000000000", "000000");
    AppMethodBeat.o(278925);
  }
  
  public a(Context paramContext, String paramString, b<? super RcptItem, x> paramb)
  {
    super(paramContext);
    AppMethodBeat.i(293320);
    this.nmN = paramString;
    this.callback = paramb;
    this.nmG = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.rnG = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.rrm = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.rro = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.rrq = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.nmM = com.tencent.mm.plugin.address.a.a.bAp();
    nmP = 1;
    rrs = (List)new ArrayList();
    paramContext = (CharSequence)this.nmN;
    paramContext = new k("\\s+").u(paramContext, 0);
    if (paramContext.size() >= 3)
    {
      paramString = this.nmM;
      paramb = (String)paramContext.get(0);
      String str1 = (String)paramContext.get(1);
      String str2 = (String)paramContext.get(2);
      if (paramContext.size() == 3)
      {
        paramContext = null;
        this.nmL = paramString.g(paramb, str1, str2, paramContext);
        if (this.nmL == null) {
          break label469;
        }
        paramContext = rrs;
        if (paramContext == null) {
          p.bGy("selectAddrPath");
        }
        paramContext.add(this.nmL);
        paramString = this.nmM;
        paramContext = this.nmL;
        if (paramContext == null) {
          break label377;
        }
      }
      label377:
      for (paramContext = Integer.valueOf(paramContext.nkI);; paramContext = null)
      {
        if (paramContext == null) {
          p.iCn();
        }
        for (paramContext = paramString.vw(paramContext.intValue()); paramContext != null; paramContext = this.nmM.vw(paramContext.nkI))
        {
          paramString = rrs;
          if (paramString == null) {
            p.bGy("selectAddrPath");
          }
          paramString.add(0, paramContext);
        }
        paramContext = (String)paramContext.get(3);
        break;
      }
      paramString = this.nmM;
      paramb = this.nmL;
      paramContext = localObject;
      if (paramb != null) {
        paramContext = paramb.code;
      }
      if (paramString.bkE(paramContext).size() == 0)
      {
        paramContext = rrs;
        if (paramContext == null) {
          p.bGy("selectAddrPath");
        }
        nmP = paramContext.size();
        AppMethodBeat.o(293320);
        return;
      }
      paramContext = rrs;
      if (paramContext == null) {
        p.bGy("selectAddrPath");
      }
      nmP = paramContext.size() + 1;
    }
    label469:
    AppMethodBeat.o(293320);
  }
  
  private final CustomViewPager bAD()
  {
    AppMethodBeat.i(278910);
    CustomViewPager localCustomViewPager = (CustomViewPager)this.nmG.getValue();
    AppMethodBeat.o(278910);
    return localCustomViewPager;
  }
  
  private final TextView bAF()
  {
    AppMethodBeat.i(293316);
    TextView localTextView = (TextView)this.rnG.getValue();
    AppMethodBeat.o(293316);
    return localTextView;
  }
  
  private final TextView bAG()
  {
    AppMethodBeat.i(293317);
    TextView localTextView = (TextView)this.rrm.getValue();
    AppMethodBeat.o(293317);
    return localTextView;
  }
  
  private final TextView bAH()
  {
    AppMethodBeat.i(293318);
    TextView localTextView = (TextView)this.rro.getValue();
    AppMethodBeat.o(293318);
    return localTextView;
  }
  
  private final TextView bAL()
  {
    AppMethodBeat.i(293319);
    TextView localTextView = (TextView)this.rrq.getValue();
    AppMethodBeat.o(293319);
    return localTextView;
  }
  
  public static void i(TextView paramTextView)
  {
    AppMethodBeat.i(278921);
    p.k(paramTextView, "$this$setTextBold");
    ar.a((Paint)paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(278921);
  }
  
  public static void j(TextView paramTextView)
  {
    AppMethodBeat.i(278922);
    p.k(paramTextView, "$this$setTextNormal");
    ar.b((Paint)paramTextView.getPaint());
    AppMethodBeat.o(278922);
  }
  
  public final View bAI()
  {
    AppMethodBeat.i(278918);
    View localView = LayoutInflater.from(getContext()).inflate(R.i.ekI, null);
    p.j(localView, "LayoutInflater.from(cont…ect_address_dialog, null)");
    AppMethodBeat.o(278918);
    return localView;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(278920);
    super.initContentView();
    Object localObject1 = hWQ();
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(R.h.close_btn);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new a.f(this));
      }
    }
    localObject1 = bAD();
    if (localObject1 != null) {
      ((CustomViewPager)localObject1).setOnPageChangeListener((ViewPager.OnPageChangeListener)new g(this));
    }
    localObject1 = bAF();
    Object localObject2 = bAG();
    TextView localTextView1 = bAH();
    TextView localTextView2 = bAL();
    int j = 0;
    int i = 0;
    while (j < 4)
    {
      TextView localTextView3 = new TextView[] { localObject1, localObject2, localTextView1, localTextView2 }[j];
      if (localTextView3 != null) {
        localTextView3.setOnClickListener((View.OnClickListener)new a.e(i, this));
      }
      j += 1;
      i += 1;
    }
    localObject1 = new HashMap();
    localObject2 = bAD();
    if (localObject2 != null) {
      ((CustomViewPager)localObject2).setAdapter((androidx.viewpager.widget.a)new h(this, (HashMap)localObject1, getContext()));
    }
    localObject1 = bAD();
    if (localObject1 != null)
    {
      ((CustomViewPager)localObject1).setCurrentItem(nmP - 1, false);
      AppMethodBeat.o(278920);
      return;
    }
    AppMethodBeat.o(278920);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "addressItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"})
  public static final class a
    extends e<a.b>
  {
    public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
    {
      AppMethodBeat.i(282083);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      AppMethodBeat.o(282083);
    }
    
    public final int getLayoutId()
    {
      return R.i.ekJ;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "item", "Lcom/tencent/mm/plugin/address/model/RcptItem;", "(Lcom/tencent/mm/plugin/address/model/RcptItem;)V", "getItem", "()Lcom/tencent/mm/plugin/address/model/RcptItem;", "setItem", "getItemId", "", "getItemType", "", "toString", "", "app_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    RcptItem nmW;
    
    public b(RcptItem paramRcptItem)
    {
      AppMethodBeat.i(244416);
      this.nmW = paramRcptItem;
      AppMethodBeat.o(244416);
    }
    
    public final int bAQ()
    {
      return 1;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(244414);
      long l = hashCode();
      AppMethodBeat.o(244414);
      return l;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(244415);
      String str = super.toString();
      AppMethodBeat.o(244415);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(286412);
      e locale = (e)new a.a();
      AppMethodBeat.o(286412);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$2", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"})
  public static final class g
    implements ViewPager.OnPageChangeListener
  {
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(271191);
      h.ioq();
      TextView localTextView1 = a.a(this.nmY);
      TextView localTextView2 = a.b(this.nmY);
      TextView localTextView3 = a.c(this.nmY);
      TextView localTextView4 = a.d(this.nmY);
      int j = 0;
      int i = 0;
      if (j < 4)
      {
        TextView localTextView5 = new TextView[] { localTextView1, localTextView2, localTextView3, localTextView4 }[j];
        Object localObject = a.nmV;
        label101:
        int k;
        if (i >= a.c.bAN().size())
        {
          localObject = null;
          if (localObject == null) {
            break label225;
          }
          if (localTextView5 != null) {
            localTextView5.setText((CharSequence)((RcptItem)localObject).name);
          }
          if (localTextView5 != null) {
            localTextView5.setTextColor(this.nmY.getContext().getResources().getColor(R.e.normal_text_color));
          }
          if (localTextView5 != null)
          {
            localObject = a.nmV;
            if (a.bAK() <= i) {
              break label294;
            }
            k = 0;
            label170:
            localTextView5.setVisibility(k);
          }
          if (paramInt != i) {
            break label300;
          }
          if (localTextView5 != null) {
            a.i(localTextView5);
          }
        }
        for (;;)
        {
          j += 1;
          i += 1;
          break;
          localObject = a.nmV;
          localObject = (RcptItem)a.c.bAN().get(i);
          break label101;
          label225:
          if (localTextView5 != null)
          {
            localObject = localTextView5.getHint();
            if (localObject == null) {
              break label288;
            }
          }
          label288:
          for (localObject = localObject.toString();; localObject = null)
          {
            localTextView5.setText((CharSequence)localObject);
            if (localTextView5 == null) {
              break;
            }
            localTextView5.setTextColor(this.nmY.getContext().getResources().getColor(R.e.hint_text_color));
            break;
          }
          label294:
          k = 4;
          break label170;
          label300:
          if (localTextView5 != null) {
            a.j(localTextView5);
          }
        }
      }
      AppMethodBeat.o(271191);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4", "Lcom/tencent/mm/ui/base/CustomPagerAdapter;", "getActualItemCount", "", "getCount", "getRegions", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "Lkotlin/collections/ArrayList;", "pos", "getView", "Landroid/view/View;", "convertView", "container", "Landroid/view/ViewGroup;", "position", "removeView", "", "app_release"})
  public static final class h
    extends d
  {
    h(HashMap paramHashMap, Context paramContext)
    {
      super();
    }
    
    public final View a(View paramView, ViewGroup paramViewGroup, final int paramInt)
    {
      AppMethodBeat.i(290802);
      paramView = (View)this.nmZ.get(Integer.valueOf(paramInt));
      if (paramView == null)
      {
        paramView = LayoutInflater.from(getContext()).inflate(R.i.ekK, paramViewGroup, false);
        p.j(paramView, "LayoutInflater.from(cont…s_view, container, false)");
      }
      for (;;)
      {
        this.nmZ.put(Integer.valueOf(paramInt), paramView);
        paramViewGroup = paramView.getTag();
        if (paramViewGroup != null)
        {
          paramViewGroup = (Integer)paramViewGroup;
          localObject1 = a.nmV;
          if (paramViewGroup.compareTo(Integer.valueOf(a.c.bAN().size())) < 0)
          {
            if (paramView == null) {
              p.iCn();
            }
            AppMethodBeat.o(290802);
            return paramView;
          }
        }
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(290802);
          throw paramView;
        }
        paramViewGroup = ((ViewGroup)paramView).findViewById(R.h.recycler_view);
        p.j(paramViewGroup, "(_convertView as ViewGro…View>(R.id.recycler_view)");
        Object localObject1 = (WxRecyclerView)paramViewGroup;
        getContext();
        ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        Object localObject2 = new ArrayList();
        if (paramInt == 0) {
          i = 0;
        }
        Object localObject3;
        for (;;)
        {
          paramViewGroup = com.tencent.mm.plugin.address.a.a.bAp().kc(i);
          p.j(paramViewGroup, "SubCoreAddress.getWallet…).getRegionByParent(hash)");
          paramViewGroup = ((Iterable)paramViewGroup).iterator();
          while (paramViewGroup.hasNext())
          {
            localObject3 = (RcptItem)paramViewGroup.next();
            p.j(localObject3, "it");
            ((ArrayList)localObject2).add(new a.b((RcptItem)localObject3));
          }
          paramViewGroup = a.nmV;
          paramViewGroup = (RcptItem)a.c.bAN().get(paramInt - 1);
          if (paramViewGroup != null) {}
          for (paramViewGroup = paramViewGroup.code;; paramViewGroup = null)
          {
            if (paramViewGroup == null) {
              break label308;
            }
            i = paramViewGroup.hashCode();
            break;
          }
          label308:
          i = 0;
        }
        if (((a.b)((ArrayList)localObject2).get(0)).nmW.bAq())
        {
          paramViewGroup = a.nmV;
          ((ArrayList)localObject2).add(new a.b(a.bAP()));
        }
        ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)new a(this, (ArrayList)localObject2, a.bAJ(), (ArrayList)localObject2));
        paramViewGroup = (Iterable)localObject2;
        int i = 0;
        paramViewGroup = paramViewGroup.iterator();
        int j = -1;
        if (paramViewGroup.hasNext())
        {
          localObject2 = paramViewGroup.next();
          if (i < 0) {
            j.iBO();
          }
          localObject2 = (a.b)localObject2;
          localObject3 = a.nmV;
          if (!a.c.bAN().contains(((a.b)localObject2).nmW)) {
            break label641;
          }
          j = i;
        }
        label641:
        for (;;)
        {
          i += 1;
          break;
          if (j >= 0)
          {
            paramViewGroup = ((WxRecyclerView)localObject1).getLayoutManager();
            if (paramViewGroup == null)
            {
              paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
              AppMethodBeat.o(290802);
              throw paramView;
            }
            paramViewGroup = (LinearLayoutManager)paramViewGroup;
            localObject2 = c.a(j, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramViewGroup, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4", "getView", "(Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "Undefined", "scrollToPosition", "(I)V");
            paramViewGroup.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramViewGroup, "com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4", "getView", "(Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "Undefined", "scrollToPosition", "(I)V");
          }
          paramViewGroup = ((WxRecyclerView)localObject1).getAdapter();
          if (paramViewGroup == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<com.tencent.mm.plugin.address.ui.SelectAddressDialog.AddressItem>");
            AppMethodBeat.o(290802);
            throw paramView;
          }
          ((WxRecyclerAdapter)paramViewGroup).YSW = ((com.tencent.mm.view.recyclerview.g)new b(this, paramInt, (WxRecyclerView)localObject1));
          paramView.setTag(Integer.valueOf(paramInt));
          AppMethodBeat.o(290802);
          return paramView;
        }
      }
    }
    
    public final int bAR()
    {
      AppMethodBeat.i(290804);
      a.c localc = a.nmV;
      int i = a.bAK();
      AppMethodBeat.o(290804);
      return i;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(290799);
      a.c localc = a.nmV;
      int i = a.bAK();
      AppMethodBeat.o(290799);
      return i;
    }
    
    public final void yy(int paramInt) {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4$getView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "needBindClickEvent", "", "app_release"})
    public static final class a
      extends WxRecyclerAdapter<a.b>
    {
      a(ArrayList paramArrayList1, com.tencent.mm.view.recyclerview.f paramf, ArrayList paramArrayList2)
      {
        super(localArrayList, true);
      }
      
      public final boolean bAS()
      {
        return true;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4$getView$3", "Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "onClick", "", "itemView", "Landroid/view/View;", "data", "unused", "", "app_release"})
    public static final class b
      implements com.tencent.mm.view.recyclerview.g<a.b>
    {
      b(int paramInt, WxRecyclerView paramWxRecyclerView) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<TextView>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<TextView>
  {
    j(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<TextView>
  {
    k(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<TextView>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/base/CustomViewPager;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<CustomViewPager>
  {
    m(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.a
 * JD-Core Version:    0.7.0.1
 */