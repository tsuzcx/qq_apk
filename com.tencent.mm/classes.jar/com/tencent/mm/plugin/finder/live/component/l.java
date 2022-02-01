package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "root", "Landroid/view/View;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;)V", "DEVICE_STATUS_LINKED", "", "DEVICE_STATUS_LINKING", "DEVICE_STATUS_UNLINKED", "MODE_DEFAULT", "MODE_LINKED", "MODE_NO_DEVICE", "MODE_RESULT", "MODE_SEARCH", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter;", "backBtn", "kotlin.jvm.PlatformType", "blankArea", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "deviceList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceInfo;", "Lkotlin/collections/ArrayList;", "deviceListGroup", "deviceListView", "Landroidx/recyclerview/widget/RecyclerView;", "linkedBtn", "Landroid/widget/TextView;", "linkedDesc", "linkedGroup", "mode", "noDeviceGroup", "noDeviceTv", "searchGroup", "selectedDevice", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "titleGroup", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "hidePanel", "", "afterAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "initView", "landscapeLayout", "onAddDevice", "mrDevice", "onLinkBreakDevice", "onLinkError", "errCode", "onLinkedDevice", "onLinkingDevice", "onRemoveDevice", "onSearchTimeout", "onUpdateDevice", "portraitLayout", "refreshByMode", "newMode", "release", "showPanel", "DeviceAdapter", "DeviceHolder", "DeviceInfo", "plugin-finder_release"})
public final class l
  implements j.b
{
  final String TAG;
  private final MMActivity activity;
  private final View jac;
  final com.tencent.mm.live.c.b kCL;
  private final int kEu;
  private final View kFU;
  private final LiveBottomSheetPanel kFV;
  private final View kGo;
  int mode;
  c xZD;
  final int xZK;
  final int xZL;
  final int xZM;
  final int xZN;
  private final int xZO;
  private final int xZP;
  private final View xZQ;
  private final View xZR;
  private final View xZS;
  private final TextView xZT;
  private final View xZU;
  private final RecyclerView xZV;
  private final View xZW;
  private final TextView xZX;
  private final TextView xZY;
  final ArrayList<c> xZZ;
  final a yaa;
  final j.a yab;
  
  public l(View paramView, com.tencent.mm.live.c.b paramb, MMActivity paramMMActivity, j.a parama)
  {
    AppMethodBeat.i(278555);
    this.jac = paramView;
    this.kCL = paramb;
    this.activity = paramMMActivity;
    this.yab = parama;
    this.TAG = "Finder.FinderLiveCastScreenViewCallback";
    this.kEu = -1;
    this.xZL = 1;
    this.xZM = 2;
    this.xZN = 3;
    this.xZO = 1;
    this.xZP = 2;
    this.kFV = ((LiveBottomSheetPanel)this.jac.findViewById(b.f.finder_live_cast_screen_content_area));
    this.kGo = this.jac.findViewById(b.f.finder_live_cast_screen_title_content);
    this.kFU = this.jac.findViewById(b.f.finder_live_cast_screen_blank_area);
    this.xZQ = this.jac.findViewById(b.f.finder_live_cast_screen_icon_btn_group);
    this.xZR = this.jac.findViewById(b.f.finder_live_cast_screen_searching_group);
    this.xZS = this.jac.findViewById(b.f.finder_live_cast_screen_no_device_group);
    this.xZT = ((TextView)this.jac.findViewById(b.f.finder_live_cast_screen_no_device_tv));
    this.xZU = this.jac.findViewById(b.f.finder_live_cast_screen_list_group);
    this.xZV = ((RecyclerView)this.jac.findViewById(b.f.finder_live_cast_screen_list_view));
    this.xZW = this.jac.findViewById(b.f.finder_live_cast_screen_linked_group);
    this.xZX = ((TextView)this.jac.findViewById(b.f.finder_live_cast_screen_linked_desc));
    this.xZY = ((TextView)this.jac.findViewById(b.f.finder_live_cast_screen_linked_btn));
    this.xZZ = new ArrayList();
    this.yaa = new a();
    this.mode = this.kEu;
    AppMethodBeat.o(278555);
  }
  
  public final void J(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(278543);
    if (this.xZD == null)
    {
      j.a locala = this.yab;
      if (locala != null) {
        locala.chi();
      }
    }
    this.kFV.setOnVisibilityListener(paramb);
    this.kFV.hide();
    AppMethodBeat.o(278543);
  }
  
  public final void Nc(int paramInt)
  {
    AppMethodBeat.i(278553);
    Log.i(this.TAG, "onLinkError errCode:".concat(String.valueOf(paramInt)));
    m.yCt.a(s.i.yFy);
    AppMethodBeat.o(278553);
  }
  
  final void Nd(int paramInt)
  {
    AppMethodBeat.i(278540);
    TextView localTextView;
    Resources localResources;
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      paramInt = this.mode;
      if (paramInt == this.xZK)
      {
        localObject = this.kGo;
        p.j(localObject, "titleGroup");
        ((View)localObject).setVisibility(0);
        localObject = this.xZR;
        p.j(localObject, "searchGroup");
        ((View)localObject).setVisibility(0);
        localObject = this.xZS;
        p.j(localObject, "noDeviceGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZU;
        p.j(localObject, "deviceListGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZW;
        p.j(localObject, "linkedGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.yab;
        if (localObject != null)
        {
          ((j.a)localObject).bYL();
          AppMethodBeat.o(278540);
          return;
        }
        AppMethodBeat.o(278540);
        return;
      }
      if (paramInt == this.xZL)
      {
        localObject = this.kGo;
        p.j(localObject, "titleGroup");
        ((View)localObject).setVisibility(0);
        localObject = this.xZR;
        p.j(localObject, "searchGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZS;
        p.j(localObject, "noDeviceGroup");
        ((View)localObject).setVisibility(0);
        localObject = this.xZU;
        p.j(localObject, "deviceListGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZW;
        p.j(localObject, "linkedGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.jac.getContext();
        p.j(localObject, "root.context");
        localObject = new SpannableString((CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_cast_screen_no_device));
        paramInt = n.a((CharSequence)localObject, "，", 0, false, 6);
        if ((paramInt != -1) && (paramInt > 0) && (paramInt < ((SpannableString)localObject).length() - 1))
        {
          ((SpannableString)localObject).setSpan(new n(this), paramInt + 1, ((SpannableString)localObject).length(), 33);
          localTextView = this.xZT;
          p.j(localTextView, "noDeviceTv");
          localTextView.setText((CharSequence)localObject);
        }
        m.yCt.a(s.i.yFz);
        AppMethodBeat.o(278540);
        return;
      }
      if (paramInt == this.xZM)
      {
        localObject = this.kGo;
        p.j(localObject, "titleGroup");
        ((View)localObject).setVisibility(0);
        localObject = this.xZR;
        p.j(localObject, "searchGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZS;
        p.j(localObject, "noDeviceGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZU;
        p.j(localObject, "deviceListGroup");
        ((View)localObject).setVisibility(0);
        localObject = this.xZW;
        p.j(localObject, "linkedGroup");
        ((View)localObject).setVisibility(8);
        AppMethodBeat.o(278540);
        return;
      }
      if (paramInt == this.xZN)
      {
        localObject = this.kGo;
        p.j(localObject, "titleGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZR;
        p.j(localObject, "searchGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZS;
        p.j(localObject, "noDeviceGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZU;
        p.j(localObject, "deviceListGroup");
        ((View)localObject).setVisibility(8);
        localObject = this.xZW;
        p.j(localObject, "linkedGroup");
        ((View)localObject).setVisibility(0);
        localTextView = this.xZX;
        p.j(localTextView, "linkedDesc");
        localObject = this.jac.getContext();
        p.j(localObject, "root.context");
        localResources = ((Context)localObject).getResources();
        paramInt = b.j.finder_live_cast_screen_linked_device;
        localObject = this.xZD;
        if (localObject == null) {
          break label660;
        }
        localObject = ((c)localObject).bMJ();
        if (localObject == null) {
          break label660;
        }
      }
    }
    label660:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject).oeA;; localObject = null)
    {
      localTextView.setText((CharSequence)localResources.getString(paramInt, new Object[] { localObject }));
      AppMethodBeat.o(278540);
      return;
    }
  }
  
  public final void a(final c paramc)
  {
    AppMethodBeat.i(278549);
    d.uiThread((kotlin.g.a.a)new g(this, paramc));
    AppMethodBeat.o(278549);
  }
  
  public final void b(final c paramc)
  {
    AppMethodBeat.i(278547);
    d.uiThread((kotlin.g.a.a)new k(this, paramc));
    AppMethodBeat.o(278547);
  }
  
  public final void c(final c paramc)
  {
    AppMethodBeat.i(278548);
    d.uiThread((kotlin.g.a.a)new m(this, paramc));
    AppMethodBeat.o(278548);
  }
  
  public final MMFragmentActivity dsB()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void dxo()
  {
    AppMethodBeat.i(278542);
    this.kFV.show();
    if (this.xZD == null)
    {
      this.mode = this.kEu;
      j.a locala = this.yab;
      if (locala != null) {
        locala.prepare();
      }
      Nd(this.xZK);
    }
    AppMethodBeat.o(278542);
  }
  
  public final void dxp()
  {
    AppMethodBeat.i(278544);
    LiveBottomSheetPanel localLiveBottomSheetPanel = this.kFV;
    p.j(localLiveBottomSheetPanel, "contentGroup");
    localLiveBottomSheetPanel.getLayoutParams().width = ax.au(this.jac.getContext()).y;
    localLiveBottomSheetPanel = this.kFV;
    p.j(localLiveBottomSheetPanel, "contentGroup");
    localLiveBottomSheetPanel.getLayoutParams().height = ax.au(this.jac.getContext()).y;
    localLiveBottomSheetPanel = this.kFV;
    p.j(localLiveBottomSheetPanel, "contentGroup");
    localLiveBottomSheetPanel.setTranslationX(ax.au(this.jac.getContext()).x);
    AppMethodBeat.o(278544);
  }
  
  public final void dxq()
  {
    AppMethodBeat.i(278545);
    LiveBottomSheetPanel localLiveBottomSheetPanel1 = this.kFV;
    p.j(localLiveBottomSheetPanel1, "contentGroup");
    localLiveBottomSheetPanel1.setTranslationY(ax.au(this.jac.getContext()).y);
    localLiveBottomSheetPanel1 = this.kFV;
    LiveBottomSheetPanel localLiveBottomSheetPanel2 = this.kFV;
    p.j(localLiveBottomSheetPanel2, "contentGroup");
    int i = localLiveBottomSheetPanel2.getPaddingLeft();
    localLiveBottomSheetPanel2 = this.kFV;
    p.j(localLiveBottomSheetPanel2, "contentGroup");
    int j = localLiveBottomSheetPanel2.getPaddingTop();
    localLiveBottomSheetPanel2 = this.kFV;
    p.j(localLiveBottomSheetPanel2, "contentGroup");
    int k = localLiveBottomSheetPanel2.getPaddingRight();
    localLiveBottomSheetPanel2 = this.kFV;
    p.j(localLiveBottomSheetPanel2, "contentGroup");
    localLiveBottomSheetPanel1.setPadding(i, j, k, localLiveBottomSheetPanel2.getPaddingBottom() + ax.aB(this.jac.getContext()));
    AppMethodBeat.o(278545);
  }
  
  public final void dxr()
  {
    AppMethodBeat.i(278546);
    d.uiThread((kotlin.g.a.a)new l(this));
    AppMethodBeat.o(278546);
  }
  
  public final void i(final c paramc)
  {
    AppMethodBeat.i(278550);
    d.uiThread((kotlin.g.a.a)new i(this, paramc));
    AppMethodBeat.o(278550);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(278541);
    RecyclerView localRecyclerView = this.xZV;
    p.j(localRecyclerView, "deviceListView");
    this.jac.getContext();
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localRecyclerView = this.xZV;
    p.j(localRecyclerView, "deviceListView");
    localRecyclerView.setAdapter((RecyclerView.a)this.yaa);
    this.xZQ.setOnClickListener((View.OnClickListener)new d(this));
    this.kFU.setOnClickListener((View.OnClickListener)new e(this));
    this.xZY.setOnClickListener((View.OnClickListener)new f(this));
    AppMethodBeat.o(278541);
  }
  
  public final void j(final c paramc)
  {
    AppMethodBeat.i(278551);
    d.uiThread((kotlin.g.a.a)new j(this, paramc));
    AppMethodBeat.o(278551);
  }
  
  public final void k(final c paramc)
  {
    AppMethodBeat.i(278552);
    d.uiThread((kotlin.g.a.a)new h(this, paramc));
    AppMethodBeat.o(278552);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceHolder;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<l.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(268385);
      int i = this.yac.xZZ.size();
      AppMethodBeat.o(268385);
      return i;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter$onBindViewHolder$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(l.c paramc, l.a parama, l.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(270749);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.yae.yac.yab;
        if (paramView != null) {
          paramView.h(this.yad.yag);
        }
        m.yCt.a(s.i.yFw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270749);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getNameTv", "()Landroid/widget/TextView;", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    final TextView jbF;
    final ProgressBar rUC;
    
    public b()
    {
      super();
      AppMethodBeat.i(269355);
      this.jbF = ((TextView)localObject.findViewById(b.f.cast_screen_device_name_tv));
      this.rUC = ((ProgressBar)localObject.findViewById(b.f.cast_screen_device_loading));
      AppMethodBeat.o(269355);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$DeviceInfo;", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "getDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setDevice", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class c
  {
    c yag;
    
    public c(c paramc)
    {
      this.yag = paramc;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(273190);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (!p.h(this.yag, paramObject.yag)) {}
        }
      }
      else
      {
        AppMethodBeat.o(273190);
        return true;
      }
      AppMethodBeat.o(273190);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273189);
      c localc = this.yag;
      if (localc != null)
      {
        int i = localc.hashCode();
        AppMethodBeat.o(273189);
        return i;
      }
      AppMethodBeat.o(273189);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273187);
      String str = "DeviceInfo(device=" + this.yag + ")";
      AppMethodBeat.o(273187);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291173);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.b.a(this.yac.kCL, b.c.kBp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291173);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279854);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.b.a(this.yac.kCL, b.c.kBp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279854);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275049);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.yac.yab;
      if (paramView != null) {
        paramView.dxn();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275049);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(l paraml, c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(l paraml, c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(l paraml, c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(l paraml, c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(l paraml, c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(l paraml, c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenViewCallback$refreshByMode$clickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class n
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(268453);
      p.k(paramView, "widget");
      this.yac.Nd(this.yac.xZK);
      AppMethodBeat.o(268453);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(268454);
      p.k(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(268454);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.l
 * JD-Core Version:    0.7.0.1
 */