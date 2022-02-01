package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "activity", "Landroid/content/Context;", "initAddress", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/address/model/RcptItem;", "", "MAX_TAB_COUNT", "", "addrMgr", "Lcom/tencent/mm/plugin/address/model/WalletAddrMgr;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ILcom/tencent/mm/plugin/address/model/WalletAddrMgr;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "curAddress", "getInitAddress", "()Ljava/lang/String;", "mTabFour", "Landroid/widget/TextView;", "getMTabFour", "()Landroid/widget/TextView;", "mTabFour$delegate", "Lkotlin/Lazy;", "mTabOne", "getMTabOne", "mTabOne$delegate", "mTabThree", "getMTabThree", "mTabThree$delegate", "mTabTwo", "getMTabTwo", "mTabTwo$delegate", "mViewPager", "Lcom/tencent/mm/ui/base/CustomViewPager;", "getMViewPager", "()Lcom/tencent/mm/ui/base/CustomViewPager;", "mViewPager$delegate", "selectAddrPath", "", "value", "tabCount", "setTabCount", "(I)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "inflateContentView", "Landroid/view/View;", "initContentView", "show", "setTextBold", "setTextNormal", "AddressConvert", "AddressItem", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.ui.f.a
{
  public static final a.c qjP;
  private static RcptItem qkb;
  final kotlin.g.a.b<RcptItem, ah> callback;
  private final String qjQ;
  private final int qjR;
  private final com.tencent.mm.plugin.address.model.j qjS;
  private final kotlin.j qjT;
  private final kotlin.j qjU;
  private final kotlin.j qjV;
  private final kotlin.j qjW;
  private final kotlin.j qjX;
  private RcptItem qjY;
  private int qjZ;
  private List<RcptItem> qka;
  
  static
  {
    AppMethodBeat.i(267221);
    qjP = new a.c((byte)0);
    qkb = new RcptItem("暂不选择", "000000000", "000000");
    AppMethodBeat.o(267221);
  }
  
  public a(Context paramContext, String paramString, kotlin.g.a.b<? super RcptItem, ah> paramb, byte paramByte)
  {
    this(paramContext, paramString, paramb);
    AppMethodBeat.i(267190);
    AppMethodBeat.o(267190);
  }
  
  public a(Context paramContext, String paramString, kotlin.g.a.b<? super RcptItem, ah> paramb, int paramInt, com.tencent.mm.plugin.address.model.j paramj)
  {
    super(paramContext);
    AppMethodBeat.i(267179);
    this.qjQ = paramString;
    this.callback = paramb;
    this.qjR = paramInt;
    this.qjS = paramj;
    this.qjT = kotlin.k.cm((kotlin.g.a.a)new a.k(this));
    this.qjU = kotlin.k.cm((kotlin.g.a.a)new a.h(this));
    this.qjV = kotlin.k.cm((kotlin.g.a.a)new a.j(this));
    this.qjW = kotlin.k.cm((kotlin.g.a.a)new a.i(this));
    this.qjX = kotlin.k.cm((kotlin.g.a.a)new a.g(this));
    this.qjZ = 1;
    yE(1);
    this.qka = ((List)new ArrayList());
    paramContext = (CharSequence)this.qjQ;
    paramContext = new kotlin.n.k("\\s+").o(paramContext, 0);
    if (paramContext.size() >= 3)
    {
      paramString = this.qjS;
      paramb = (String)paramContext.get(0);
      paramj = (String)paramContext.get(1);
      String str = (String)paramContext.get(2);
      if (paramContext.size() == 3)
      {
        paramContext = null;
        this.qjY = paramString.g(paramb, paramj, str, paramContext);
        if (this.qjY == null) {
          break label450;
        }
        this.qka.add(this.qjY);
        paramString = this.qjS;
        paramContext = this.qjY;
        if (paramContext != null) {
          break label367;
        }
      }
      label367:
      for (paramContext = null;; paramContext = Integer.valueOf(paramContext.qhR))
      {
        s.checkNotNull(paramContext);
        for (paramContext = paramString.yB(paramContext.intValue()); paramContext != null; paramContext = this.qjS.yB(paramContext.qhR)) {
          this.qka.add(0, paramContext);
        }
        paramContext = (String)paramContext.get(3);
        break;
      }
      paramString = this.qjS;
      paramContext = this.qjY;
      if (paramContext == null) {}
      for (paramContext = localObject; paramString.TB(paramContext).size() == 0; paramContext = paramContext.code)
      {
        yE(this.qka.size());
        AppMethodBeat.o(267179);
        return;
      }
      yE(this.qka.size() + 1);
    }
    label450:
    AppMethodBeat.o(267179);
  }
  
  private static final WindowInsets a(a parama, View paramView, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(267191);
    s.u(parama, "this$0");
    parama = parama.jBi();
    if (parama != null) {
      parama.setPadding(paramWindowInsets.getSystemWindowInsetLeft(), 0, paramWindowInsets.getSystemWindowInsetRight(), 0);
    }
    AppMethodBeat.o(267191);
    return paramWindowInsets;
  }
  
  private static final void a(a parama, int paramInt, View paramView)
  {
    AppMethodBeat.i(267195);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/SelectAddressDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.bZt();
    if (parama != null) {
      parama.setCurrentItem(paramInt, true);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/address/ui/SelectAddressDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267195);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(267193);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/SelectAddressDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/address/ui/SelectAddressDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267193);
  }
  
  private final CustomViewPager bZt()
  {
    AppMethodBeat.i(267181);
    CustomViewPager localCustomViewPager = (CustomViewPager)this.qjT.getValue();
    AppMethodBeat.o(267181);
    return localCustomViewPager;
  }
  
  private final TextView bZu()
  {
    AppMethodBeat.i(267182);
    TextView localTextView = (TextView)this.qjU.getValue();
    AppMethodBeat.o(267182);
    return localTextView;
  }
  
  private final TextView bZv()
  {
    AppMethodBeat.i(267183);
    TextView localTextView = (TextView)this.qjV.getValue();
    AppMethodBeat.o(267183);
    return localTextView;
  }
  
  private final TextView bZw()
  {
    AppMethodBeat.i(267184);
    TextView localTextView = (TextView)this.qjW.getValue();
    AppMethodBeat.o(267184);
    return localTextView;
  }
  
  private final TextView bZx()
  {
    AppMethodBeat.i(267185);
    TextView localTextView = (TextView)this.qjX.getValue();
    AppMethodBeat.o(267185);
    return localTextView;
  }
  
  public static void j(TextView paramTextView)
  {
    AppMethodBeat.i(267188);
    s.u(paramTextView, "<this>");
    aw.e((Paint)paramTextView.getPaint());
    AppMethodBeat.o(267188);
  }
  
  public static void setTextBold(TextView paramTextView)
  {
    AppMethodBeat.i(267187);
    s.u(paramTextView, "<this>");
    aw.a((Paint)paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(267187);
  }
  
  private final void yE(int paramInt)
  {
    AppMethodBeat.i(267186);
    this.qjZ = Math.min(paramInt, this.qjR);
    AppMethodBeat.o(267186);
  }
  
  public final View bZy()
  {
    AppMethodBeat.i(267235);
    View localView = LayoutInflater.from(getContext()).inflate(R.i.gnM, null);
    s.s(localView, "from(context).inflate(R.…ect_address_dialog, null)");
    AppMethodBeat.o(267235);
    return localView;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(267238);
    super.initContentView();
    Object localObject1 = jBj();
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(R.h.close_btn);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      }
    }
    localObject1 = bZt();
    if (localObject1 != null) {
      ((CustomViewPager)localObject1).setOnPageChangeListener((ViewPager.OnPageChangeListener)new e(this));
    }
    localObject1 = bZu();
    Object localObject2 = bZv();
    TextView localTextView1 = bZw();
    TextView localTextView2 = bZx();
    int j = 0;
    int i = 0;
    while (j < 4)
    {
      TextView localTextView3 = new TextView[] { localObject1, localObject2, localTextView1, localTextView2 }[j];
      if (localTextView3 != null) {
        localTextView3.setOnClickListener(new a..ExternalSyntheticLambda2(this, i));
      }
      j += 1;
      i += 1;
    }
    localObject1 = new HashMap();
    localObject2 = bZt();
    if (localObject2 != null) {
      ((CustomViewPager)localObject2).setAdapter((androidx.viewpager.widget.a)new f(this, (HashMap)localObject1, getContext()));
    }
    localObject1 = bZt();
    if (localObject1 != null) {
      ((CustomViewPager)localObject1).setCurrentItem(this.qjZ - 1, false);
    }
    AppMethodBeat.o(267238);
  }
  
  public final void show()
  {
    Object localObject2 = null;
    AppMethodBeat.i(267230);
    super.show();
    aw.g(getWindow());
    Object localObject1 = getWindow();
    ViewGroup localViewGroup;
    label49:
    int i;
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof ViewGroup)) {
        break label161;
      }
      localViewGroup = (ViewGroup)localObject1;
      if (localViewGroup != null)
      {
        i = 0;
        k = localViewGroup.getChildCount();
        localObject1 = localObject2;
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      localObject1 = localViewGroup.getChildAt(i);
      if ((s.p("android:status:background", ((View)localObject1).getTransitionName())) || (s.p("android:navigation:background", ((View)localObject1).getTransitionName())))
      {
        if (j < k) {
          break label173;
        }
        localObject1 = localObject2;
        label119:
        if (localObject1 != null) {
          break label170;
        }
        localObject1 = (View)localViewGroup;
      }
      label161:
      label170:
      for (;;)
      {
        ((View)localObject1).setOnApplyWindowInsetsListener(new a..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(267230);
        return;
        localObject1 = ((Window)localObject1).getDecorView();
        break;
        localViewGroup = null;
        break label49;
        break label119;
      }
      label173:
      i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$2", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ViewPager.OnPageChangeListener
  {
    e(a parama) {}
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(267146);
      com.tencent.e.f.h.jXD();
      TextView localTextView1 = a.a(this.qkc);
      TextView localTextView2 = a.b(this.qkc);
      TextView localTextView3 = a.c(this.qkc);
      TextView localTextView4 = a.d(this.qkc);
      a locala = this.qkc;
      int j = 0;
      int i = 0;
      if (j < 4)
      {
        TextView localTextView5 = new TextView[] { localTextView1, localTextView2, localTextView3, localTextView4 }[j];
        Object localObject;
        label104:
        int k;
        if (i >= a.e(locala).size())
        {
          localObject = null;
          if (localObject == null) {
            break label220;
          }
          if (localTextView5 != null) {
            localTextView5.setText((CharSequence)((RcptItem)localObject).name);
          }
          if (localTextView5 != null) {
            localTextView5.setTextColor(locala.getContext().getResources().getColor(R.e.normal_text_color));
          }
          if (localTextView5 != null)
          {
            if (a.f(locala) <= i) {
              break label298;
            }
            k = 0;
            label168:
            localTextView5.setVisibility(k);
          }
          if (paramInt != i) {
            break label304;
          }
          if (localTextView5 != null) {
            a.setTextBold(localTextView5);
          }
        }
        for (;;)
        {
          j += 1;
          i += 1;
          break;
          localObject = (RcptItem)a.e(locala).get(i);
          break label104;
          label220:
          if (localTextView5 != null)
          {
            if (localTextView5 != null) {
              break label270;
            }
            localObject = null;
          }
          for (;;)
          {
            localTextView5.setText((CharSequence)localObject);
            if (localTextView5 == null) {
              break;
            }
            localTextView5.setTextColor(locala.getContext().getResources().getColor(R.e.hint_text_color));
            break;
            label270:
            localObject = localTextView5.getHint();
            if (localObject == null) {
              localObject = null;
            } else {
              localObject = localObject.toString();
            }
          }
          label298:
          k = 4;
          break label168;
          label304:
          if (localTextView5 != null) {
            a.j(localTextView5);
          }
        }
      }
      AppMethodBeat.o(267146);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4", "Lcom/tencent/mm/ui/base/CustomPagerAdapter;", "getActualItemCount", "", "getCount", "getRegions", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "Lkotlin/collections/ArrayList;", "pos", "getView", "Landroid/view/View;", "convertView", "container", "Landroid/view/ViewGroup;", "position", "removeView", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends d
  {
    f(a parama, HashMap<Integer, View> paramHashMap, Context paramContext)
    {
      super();
    }
    
    public final View a(View paramView, ViewGroup paramViewGroup, final int paramInt)
    {
      AppMethodBeat.i(267155);
      paramView = (View)this.qke.get(Integer.valueOf(paramInt));
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.context).inflate(R.i.gnO, paramViewGroup, false);
        s.s(paramView, "from(context).inflate(R.…s_view, container, false)");
      }
      for (;;)
      {
        this.qke.put(Integer.valueOf(paramInt), paramView);
        paramViewGroup = paramView.getTag();
        if ((paramViewGroup == null) || (((Integer)paramViewGroup).compareTo(Integer.valueOf(a.e(this.qkc).size())) >= 0)) {
          break;
        }
        AppMethodBeat.o(267155);
        return paramView;
      }
      paramViewGroup = ((ViewGroup)paramView).findViewById(R.h.recycler_view);
      s.s(paramViewGroup, "_convertView as ViewGrou…View>(R.id.recycler_view)");
      final WxRecyclerView localWxRecyclerView = (WxRecyclerView)paramViewGroup;
      localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      Object localObject1 = new ArrayList();
      if (paramInt == 0) {
        i = 0;
      }
      Object localObject2;
      for (;;)
      {
        paramViewGroup = a.h(this.qkc).yA(i);
        s.s(paramViewGroup, "addrMgr.getRegionByParent(hash)");
        paramViewGroup = ((Iterable)paramViewGroup).iterator();
        while (paramViewGroup.hasNext())
        {
          localObject2 = (RcptItem)paramViewGroup.next();
          s.s(localObject2, "it");
          ((ArrayList)localObject1).add(new a.b((RcptItem)localObject2));
        }
        paramViewGroup = (RcptItem)a.e(this.qkc).get(paramInt - 1);
        if (paramViewGroup == null) {}
        for (paramViewGroup = null;; paramViewGroup = paramViewGroup.code)
        {
          if (paramViewGroup == null) {
            break label279;
          }
          i = paramViewGroup.hashCode();
          break;
        }
        label279:
        i = 0;
      }
      if (((a.b)((ArrayList)localObject1).get(0)).qkd.bZh())
      {
        paramViewGroup = a.qjP;
        ((ArrayList)localObject1).add(new a.b(a.bZz()));
      }
      localWxRecyclerView.setAdapter((RecyclerView.a)new a((ArrayList)localObject1, a.g(this.qkc)));
      localObject1 = (Iterable)localObject1;
      paramViewGroup = this.qkc;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      int j = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (a.b)localObject2;
        if (!a.e(paramViewGroup).contains(((a.b)localObject2).qkd)) {
          break label623;
        }
        j = i;
      }
      label623:
      for (;;)
      {
        i += 1;
        break;
        if (j >= 0)
        {
          paramViewGroup = localWxRecyclerView.getLayoutManager();
          if (paramViewGroup == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(267155);
            throw paramView;
          }
          paramViewGroup = (LinearLayoutManager)paramViewGroup;
          localObject1 = c.a(j, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramViewGroup, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4", "getView", "(Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "Undefined", "scrollToPosition", "(I)V");
          paramViewGroup.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramViewGroup, "com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4", "getView", "(Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "Undefined", "scrollToPosition", "(I)V");
        }
        paramViewGroup = localWxRecyclerView.getAdapter();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<com.tencent.mm.plugin.address.ui.SelectAddressDialog.AddressItem>");
          AppMethodBeat.o(267155);
          throw paramView;
        }
        ((WxRecyclerAdapter)paramViewGroup).agOO = ((com.tencent.mm.view.recyclerview.h)new b(this.qkc, paramInt, localWxRecyclerView, this));
        paramView.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(267155);
        return paramView;
      }
    }
    
    public final int bZC()
    {
      AppMethodBeat.i(267157);
      int i = a.f(this.qkc);
      AppMethodBeat.o(267157);
      return i;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(267149);
      int i = a.f(this.qkc);
      AppMethodBeat.o(267149);
      return i;
    }
    
    public final void yG(int paramInt) {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4$getView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "needBindClickEvent", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends WxRecyclerAdapter<a.b>
    {
      a(ArrayList<a.b> paramArrayList, g paramg)
      {
        super(paramArrayList, true);
      }
      
      public final boolean bZD()
      {
        return true;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/address/ui/SelectAddressDialog$initContentView$4$getView$3", "Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "onClick", "", "itemView", "Landroid/view/View;", "data", "unused", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements com.tencent.mm.view.recyclerview.h<a.b>
    {
      b(a parama, int paramInt, WxRecyclerView paramWxRecyclerView, a.f paramf) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.a
 * JD-Core Version:    0.7.0.1
 */