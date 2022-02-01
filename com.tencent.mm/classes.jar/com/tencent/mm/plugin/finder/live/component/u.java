package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "root", "Landroid/view/View;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;)V", "DEVICE_STATUS_LINKED", "", "DEVICE_STATUS_LINKING", "DEVICE_STATUS_UNLINKED", "MODE_DEFAULT", "MODE_LINKED", "MODE_NO_DEVICE", "MODE_RESULT", "MODE_SEARCH", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter;", "backBtn", "kotlin.jvm.PlatformType", "blankArea", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "deviceList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceInfo;", "Lkotlin/collections/ArrayList;", "deviceListGroup", "deviceListView", "Landroidx/recyclerview/widget/RecyclerView;", "linkedBtn", "Landroid/widget/TextView;", "linkedDesc", "linkedGroup", "mode", "noDeviceGroup", "noDeviceTv", "searchGroup", "selectedDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "titleGroup", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "hidePanel", "", "afterAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "initView", "landscapeLayout", "onAddDevice", "mrDevice", "onLinkBreakDevice", "onLinkError", "errCode", "onLinkedDevice", "onLinkingDevice", "onRemoveDevice", "onSearchTimeout", "onUpdateDevice", "portraitLayout", "refreshByMode", "newMode", "release", "showPanel", "DeviceAdapter", "DeviceHolder", "DeviceInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements s.b
{
  c CxK;
  final s.a CxP;
  final int CxQ;
  final int CxR;
  final int CxS;
  final int CxT;
  private final int CxU;
  private final int CxV;
  private final View CxW;
  private final View CxX;
  private final View CxY;
  private final TextView CxZ;
  private final View Cya;
  private final RecyclerView Cyb;
  private final View Cyc;
  private final TextView Cyd;
  private final TextView Cye;
  final ArrayList<c> Cyf;
  final a Cyg;
  final String TAG;
  private final MMActivity activity;
  private final View lBX;
  int mode;
  private final com.tencent.mm.live.b.b nfT;
  private final int nhE;
  private final View niW;
  private final LiveBottomSheetPanel niX;
  private final View njm;
  
  public u(View paramView, com.tencent.mm.live.b.b paramb, MMActivity paramMMActivity, s.a parama)
  {
    AppMethodBeat.i(352888);
    this.lBX = paramView;
    this.nfT = paramb;
    this.activity = paramMMActivity;
    this.CxP = parama;
    this.TAG = "Finder.FinderLiveCastScreenViewCallback";
    this.nhE = -1;
    this.CxR = 1;
    this.CxS = 2;
    this.CxT = 3;
    this.CxU = 1;
    this.CxV = 2;
    this.niX = ((LiveBottomSheetPanel)this.lBX.findViewById(p.e.BJd));
    this.njm = this.lBX.findViewById(p.e.BJn);
    this.niW = this.lBX.findViewById(p.e.BJc);
    this.CxW = this.lBX.findViewById(p.e.BJe);
    this.CxX = this.lBX.findViewById(p.e.BJm);
    this.CxY = this.lBX.findViewById(p.e.BJk);
    this.CxZ = ((TextView)this.lBX.findViewById(p.e.BJl));
    this.Cya = this.lBX.findViewById(p.e.BJi);
    this.Cyb = ((RecyclerView)this.lBX.findViewById(p.e.BJj));
    this.Cyc = this.lBX.findViewById(p.e.BJh);
    this.Cyd = ((TextView)this.lBX.findViewById(p.e.BJg));
    this.Cye = ((TextView)this.lBX.findViewById(p.e.BJf));
    this.Cyf = new ArrayList();
    this.Cyg = new a();
    this.mode = this.nhE;
    AppMethodBeat.o(352888);
  }
  
  private final void OE(int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(352909);
    TextView localTextView;
    Resources localResources;
    Object localObject2;
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      paramInt = this.mode;
      if (paramInt == this.CxQ)
      {
        this.njm.setVisibility(0);
        this.CxX.setVisibility(0);
        this.CxY.setVisibility(8);
        this.Cya.setVisibility(8);
        this.Cyc.setVisibility(8);
        localObject1 = this.CxP;
        if (localObject1 != null)
        {
          ((s.a)localObject1).czb();
          AppMethodBeat.o(352909);
        }
      }
      else
      {
        if (paramInt == this.CxR)
        {
          this.njm.setVisibility(0);
          this.CxX.setVisibility(8);
          this.CxY.setVisibility(0);
          this.Cya.setVisibility(8);
          this.Cyc.setVisibility(8);
          localObject1 = new SpannableString((CharSequence)this.lBX.getContext().getResources().getString(p.h.CiS));
          paramInt = n.a((CharSequence)localObject1, "，", 0, false, 6);
          if ((paramInt != -1) && (paramInt > 0) && (paramInt < ((SpannableString)localObject1).length() - 1))
          {
            ((SpannableString)localObject1).setSpan(new k(), paramInt + 1, ((SpannableString)localObject1).length(), 33);
            this.CxZ.setText((CharSequence)localObject1);
            this.CxZ.setOnClickListener(new u..ExternalSyntheticLambda1(this));
          }
          k.Doi.a(q.k.Dtd);
          AppMethodBeat.o(352909);
          return;
        }
        if (paramInt == this.CxS)
        {
          this.njm.setVisibility(0);
          this.CxX.setVisibility(8);
          this.CxY.setVisibility(8);
          this.Cya.setVisibility(0);
          this.Cyc.setVisibility(8);
          AppMethodBeat.o(352909);
          return;
        }
        if (paramInt == this.CxT)
        {
          this.njm.setVisibility(8);
          this.CxX.setVisibility(8);
          this.CxY.setVisibility(8);
          this.Cya.setVisibility(8);
          this.Cyc.setVisibility(0);
          localTextView = this.Cyd;
          localResources = this.lBX.getContext().getResources();
          paramInt = p.h.CiR;
          localObject2 = this.CxK;
          if (localObject2 != null) {
            break label443;
          }
        }
      }
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localResources.getString(paramInt, new Object[] { localObject1 }));
      AppMethodBeat.o(352909);
      return;
      label443:
      localObject2 = ((c)localObject2).cmY();
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).rif;
      }
    }
  }
  
  private static final void a(u paramu, View paramView)
  {
    AppMethodBeat.i(352919);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    paramu.OE(paramu.CxQ);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352919);
  }
  
  private static final void b(u paramu, View paramView)
  {
    AppMethodBeat.i(352929);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    b.b.a(paramu.nfT, b.c.neP);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352929);
  }
  
  private static final void c(u paramu, View paramView)
  {
    AppMethodBeat.i(352936);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    b.b.a(paramu.nfT, b.c.neP);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352936);
  }
  
  private static final void d(u paramu, View paramView)
  {
    AppMethodBeat.i(352946);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    paramu = paramu.CxP;
    if (paramu != null) {
      paramu.ehU();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352946);
  }
  
  public final void OD(int paramInt)
  {
    AppMethodBeat.i(353106);
    Log.i(this.TAG, s.X("onLinkError errCode:", Integer.valueOf(paramInt)));
    k.Doi.a(q.k.Dtc);
    AppMethodBeat.o(353106);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(353070);
    d.uiThread((kotlin.g.a.a)new d(paramc, this));
    AppMethodBeat.o(353070);
  }
  
  public final void am(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(353025);
    if (this.CxK == null)
    {
      s.a locala = this.CxP;
      if (locala != null) {
        locala.cIf();
      }
    }
    this.niX.setOnVisibilityListener(paramb);
    this.niX.hide();
    AppMethodBeat.o(353025);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(353057);
    d.uiThread((kotlin.g.a.a)new h(paramc, this));
    AppMethodBeat.o(353057);
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(353061);
    d.uiThread((kotlin.g.a.a)new j(paramc, this));
    AppMethodBeat.o(353061);
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void ehV()
  {
    AppMethodBeat.i(353018);
    this.niX.show();
    if (this.CxK == null)
    {
      this.mode = this.nhE;
      s.a locala = this.CxP;
      if (locala != null) {
        locala.prepare();
      }
      OE(this.CxQ);
    }
    AppMethodBeat.o(353018);
  }
  
  public final void ehW()
  {
    AppMethodBeat.i(353035);
    this.niX.getLayoutParams().width = bf.bf(this.lBX.getContext()).y;
    this.niX.getLayoutParams().height = bf.bf(this.lBX.getContext()).y;
    this.niX.setTranslationX(bf.bf(this.lBX.getContext()).x);
    AppMethodBeat.o(353035);
  }
  
  public final void ehX()
  {
    AppMethodBeat.i(353043);
    this.niX.setTranslationY(bf.bf(this.lBX.getContext()).y);
    this.niX.setPadding(this.niX.getPaddingLeft(), this.niX.getPaddingTop(), this.niX.getPaddingRight(), this.niX.getPaddingBottom() + bf.bk(this.lBX.getContext()));
    AppMethodBeat.o(353043);
  }
  
  public final void ehY()
  {
    AppMethodBeat.i(353049);
    d.uiThread((kotlin.g.a.a)new i(this));
    AppMethodBeat.o(353049);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(353003);
    RecyclerView localRecyclerView = this.Cyb;
    this.lBX.getContext();
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.Cyb.setAdapter((RecyclerView.a)this.Cyg);
    this.CxW.setOnClickListener(new u..ExternalSyntheticLambda2(this));
    this.niW.setOnClickListener(new u..ExternalSyntheticLambda3(this));
    this.Cye.setOnClickListener(new u..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(353003);
  }
  
  public final void j(final c paramc)
  {
    AppMethodBeat.i(353076);
    d.uiThread((kotlin.g.a.a)new f(this, paramc));
    AppMethodBeat.o(353076);
  }
  
  public final void k(final c paramc)
  {
    AppMethodBeat.i(353088);
    d.uiThread((kotlin.g.a.a)new g(this, paramc));
    AppMethodBeat.o(353088);
  }
  
  public final void l(final c paramc)
  {
    AppMethodBeat.i(353096);
    d.uiThread((kotlin.g.a.a)new e(this, paramc));
    AppMethodBeat.o(353096);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceHolder;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<u.b>
  {
    public a()
    {
      AppMethodBeat.i(352654);
      AppMethodBeat.o(352654);
    }
    
    private static final void a(u paramu, u.c paramc, View paramView)
    {
      AppMethodBeat.i(352658);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramu);
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramu, "this$0");
      s.u(paramc, "$device");
      paramu = paramu.CxP;
      if (paramu != null) {
        paramu.i(paramc.Cyi);
      }
      k.Doi.a(q.k.Dta);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(352658);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(352671);
      int i = this.Cyh.Cyf.size();
      AppMethodBeat.o(352671);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNameTv", "()Landroid/widget/TextView;", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    final TextView lDF;
    final ProgressBar vfR;
    
    public b()
    {
      super();
      AppMethodBeat.i(352649);
      this.lDF = ((TextView)localObject.findViewById(p.e.BBW));
      this.vfR = ((ProgressBar)localObject.findViewById(p.e.BBV));
      AppMethodBeat.o(352649);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceInfo;", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "getDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setDevice", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    c Cyi;
    
    public c(c paramc)
    {
      this.Cyi = paramc;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(352662);
      if (this == paramObject)
      {
        AppMethodBeat.o(352662);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(352662);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.Cyi, paramObject.Cyi))
      {
        AppMethodBeat.o(352662);
        return false;
      }
      AppMethodBeat.o(352662);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(352657);
      if (this.Cyi == null)
      {
        AppMethodBeat.o(352657);
        return 0;
      }
      int i = this.Cyi.hashCode();
      AppMethodBeat.o(352657);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(352651);
      String str = "DeviceInfo(device=" + this.Cyi + ')';
      AppMethodBeat.o(352651);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(c paramc, u paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(u paramu, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(u paramu, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(u paramu, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(c paramc, u paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(u paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(c paramc, u paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$refreshByMode$clickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(352669);
      s.u(paramView, "widget");
      AppMethodBeat.o(352669);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(352677);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(352677);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.u
 * JD-Core Version:    0.7.0.1
 */