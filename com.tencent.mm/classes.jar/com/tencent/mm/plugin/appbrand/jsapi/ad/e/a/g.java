package com.tencent.mm.plugin.appbrand.jsapi.ad.e.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aj;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Landroid/support/design/widget/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"})
public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final g.a lEp;
  ViewTreeObserver afv;
  final com.tencent.mm.plugin.appbrand.jsapi.ad.e.b cve;
  View kFh;
  Dialog lDY;
  b lDZ;
  int lEa;
  BottomSheetBehavior<?> lEb;
  boolean lEc;
  int lEd;
  boolean lEe;
  boolean lEf;
  boolean lEg;
  int lEh;
  m<? super c, ? super Integer, z> lEi;
  private d.g.a.a<z> lEj;
  d.g.a.b<? super Integer, z> lEk;
  d.g.a.a<z> lEl;
  private final g.c lEm;
  final j lEn;
  final boolean lEo;
  Context mContext;
  View qI;
  
  static
  {
    AppMethodBeat.i(139710);
    lEp = new g.a((byte)0);
    AppMethodBeat.o(139710);
  }
  
  private g(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.ad.e.b paramb, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(139709);
    this.cve = paramb;
    this.lEn = paramj;
    this.lEo = paramBoolean;
    this.mContext = paramContext;
    this.lEf = true;
    this.lEg = true;
    this.lEk = ((d.g.a.b)g.h.lEB);
    this.lEm = new g.c(this);
    if ((this.mContext instanceof Activity))
    {
      paramContext = this.mContext;
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      paramContext = ((Activity)paramContext).getWindow();
      p.g(paramContext, "(mContext as Activity).window");
      paramContext = paramContext.getDecorView();
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      this.qI = ((ViewGroup)paramContext).findViewById(16908290);
    }
    paramb = this.mContext;
    if (this.lEg)
    {
      if (paramb == null) {
        p.gkB();
      }
      paramContext = (Dialog)new com.tencent.mm.ui.widget.a.b(paramb);
      this.lDY = paramContext;
      paramContext = View.inflate(paramb, 2131494575, null);
      p.g(paramContext, "View.inflate(context, R.…video_cast_devices, null)");
      this.kFh = paramContext;
      paramContext = this.kFh;
      if (paramContext == null) {
        p.bdF("rootView");
      }
      paramContext.findViewById(2131306133).setOnClickListener((View.OnClickListener)new g.d(this));
      paramContext = this.kFh;
      if (paramContext == null) {
        p.bdF("rootView");
      }
      paramContext = (RecyclerView)paramContext.findViewById(2131297464);
      paramContext.setHasFixedSize(true);
      paramb = this.kFh;
      if (paramb == null) {
        p.bdF("rootView");
      }
      paramb.findViewById(2131301207).setOnClickListener((View.OnClickListener)new g.e(this));
      paramb = this.kFh;
      if (paramb == null) {
        p.bdF("rootView");
      }
      paramb = (ImageView)paramb.findViewById(2131301206);
      if (!i.cre.isDarkMode()) {
        break label612;
      }
      paramj = this.mContext;
      if (paramj == null) {
        p.gkB();
      }
      paramb.setImageDrawable(android.support.v4.content.b.l(paramj, 2131230851));
      label386:
      this.lEc = aoA();
      i = aq.ay(this.mContext, 2131165930);
      if (!this.lEc) {
        break label638;
      }
    }
    label612:
    label638:
    for (int i = (int)(i * 4.5D) + aq.ay(this.mContext, 2131165923);; i = (int)(i * 6.5D) + aq.ay(this.mContext, 2131165923))
    {
      this.lEa = i;
      p.g(paramContext, "mRecyclerView");
      paramContext.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      paramContext.setFocusable(false);
      this.lDZ = new b();
      paramb = this.lDZ;
      if (paramb == null) {
        p.bdF("recycleViewAdapter");
      }
      paramContext.setAdapter((RecyclerView.a)paramb);
      paramContext.setOverScrollMode(1);
      paramContext = this.lDY;
      if (paramContext == null) {
        p.bdF("mBottomSheetDialog");
      }
      paramb = this.kFh;
      if (paramb == null) {
        p.bdF("rootView");
      }
      paramContext.setContentView(paramb);
      if (this.lEg) {
        break label693;
      }
      paramContext = this.kFh;
      if (paramContext == null) {
        p.bdF("rootView");
      }
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break label662;
      }
      paramContext = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(139709);
      throw paramContext;
      if (paramb == null) {
        p.gkB();
      }
      paramContext = (Dialog)new android.support.design.widget.a(paramb);
      break;
      paramj = this.mContext;
      if (paramj == null) {
        p.gkB();
      }
      paramb.setImageDrawable(android.support.v4.content.b.l(paramj, 2131230844));
      break label386;
    }
    label662:
    this.lEb = BottomSheetBehavior.l((View)paramContext);
    paramContext = this.lEb;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.J(this.lEa);
    label693:
    paramContext = this.lDY;
    if (paramContext == null) {
      p.bdF("mBottomSheetDialog");
    }
    paramContext.setOnCancelListener((DialogInterface.OnCancelListener)new f(this));
    paramContext = this.lDY;
    if (paramContext == null) {
      p.bdF("mBottomSheetDialog");
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new g(this));
    paramContext = this.lDY;
    if (paramContext == null) {
      p.bdF("mBottomSheetDialog");
    }
    paramContext.setCancelable(false);
    this.cve.getRuntime().a(4, -1, (aj)this.lEm);
    AppMethodBeat.o(139709);
  }
  
  final boolean aoA()
  {
    AppMethodBeat.i(139706);
    Object localObject = this.mContext;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "mContext!!.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(139706);
      return true;
    }
    AppMethodBeat.o(139706);
    return false;
  }
  
  public final void bqD()
  {
    AppMethodBeat.i(139708);
    if (((g)this).lDY != null)
    {
      Object localObject;
      if (this.lEb != null)
      {
        localObject = this.lEb;
        if (localObject == null) {
          p.gkB();
        }
        ((BottomSheetBehavior)localObject).u(true);
      }
      if (this.mContext != null)
      {
        localObject = this.mContext;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(139708);
          throw ((Throwable)localObject);
        }
        if (!((Activity)localObject).isFinishing())
        {
          localObject = this.lDY;
          if (localObject == null) {
            p.bdF("mBottomSheetDialog");
          }
          ((Dialog)localObject).dismiss();
        }
      }
    }
    this.cve.getRuntime().a((aj)this.lEm);
    AppMethodBeat.o(139708);
  }
  
  @SuppressLint({"WrongConstant"})
  final int getRotation()
  {
    AppMethodBeat.i(139704);
    int i = 0;
    if ((this.mContext instanceof Activity))
    {
      Object localObject = this.mContext;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(139704);
        throw ((Throwable)localObject);
      }
      localObject = ((Activity)localObject).getWindow();
      p.g(localObject, "(mContext as Activity).window");
      localObject = ((Window)localObject).getWindowManager();
      p.g(localObject, "(mContext as Activity).window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "(mContext as Activity).w…dowManager.defaultDisplay");
      i = ((Display)localObject).getRotation();
    }
    AppMethodBeat.o(139704);
    return i;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(139705);
    if (((g)this).lDY != null)
    {
      Dialog localDialog = this.lDY;
      if (localDialog == null) {
        p.bdF("mBottomSheetDialog");
      }
      if (localDialog.isShowing())
      {
        AppMethodBeat.o(139705);
        return true;
      }
    }
    AppMethodBeat.o(139705);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(139707);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bqD();
        AppMethodBeat.o(139707);
        return;
      }
      if ((isShowing()) && ((this.lEc != aoA()) || (this.lEd != getRotation()))) {
        bqD();
      }
    }
    AppMethodBeat.o(139707);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"})
  final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    private final e tX(int paramInt)
    {
      AppMethodBeat.i(139696);
      if (!((Collection)this.lEq.lEn.lFm).isEmpty()) {}
      for (int i = 1; (i != 0) && (paramInt <= this.lEq.lEn.lFm.size()); i = 0)
      {
        localObject = this.lEq.lEn.lFm.get(paramInt);
        p.g(localObject, "videoCastDeviceManager.r…tDevices[posSubFistTitle]");
        localObject = (e)localObject;
        AppMethodBeat.o(139696);
        return localObject;
      }
      if (!((Collection)this.lEq.lEn.lFm).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      label166:
      for (Object localObject = (e)this.lEq.lEn.lFl.get(paramInt - this.lEq.lEn.lFm.size() - 1);; localObject = (e)this.lEq.lEn.lFl.get(paramInt))
      {
        p.g(localObject, "if (videoCastDeviceManag…tTitle]\n                }");
        AppMethodBeat.o(139696);
        return localObject;
        i = 0;
        break;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(139693);
      p.h(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        paramViewGroup = LayoutInflater.from(g.a(this.lEq)).inflate(2131494528, paramViewGroup, false);
        p.g(paramViewGroup, "itemView");
        paramViewGroup = (RecyclerView.w)new a(paramViewGroup);
        AppMethodBeat.o(139693);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(g.a(this.lEq)).inflate(2131494576, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup);
      AppMethodBeat.o(139693);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(139695);
      p.h(paramw, "viewHolder");
      switch (getItemViewType(paramInt))
      {
      default: 
        AppMethodBeat.o(139695);
        return;
      case 3: 
        localObject2 = (a)paramw;
        final int i = paramInt - 1;
        ((a)localObject2).lEs.setOnClickListener((View.OnClickListener)new c(this, i, paramInt));
        e locale = tX(i);
        ae.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "bindDeviceViewHolder: ".concat(String.valueOf(locale)));
        TextView localTextView = ((a)localObject2).lEr;
        paramw = locale.lDX.bfV();
        if (paramw == null) {
          p.gkB();
        }
        localObject1 = paramw.kgg;
        p.g(localObject1, "device.mrDevice.dlnaDevice!!.friendlyName");
        paramw = (RecyclerView.w)localObject1;
        if (bu.isNullOrNil((String)localObject1))
        {
          paramw = locale.lDX.bfV();
          if (paramw == null) {
            p.gkB();
          }
          paramw = paramw.kgi;
          p.g(paramw, "device.mrDevice.dlnaDevice!!.modeName");
        }
        localTextView.setText((CharSequence)paramw);
        if (!this.lEq.lEo)
        {
          ((a)localObject2).lEt.setVisibility(8);
          ((a)localObject2).lEu.setVisibility(8);
          ((a)localObject2).lEv.setVisibility(8);
          AppMethodBeat.o(139695);
          return;
        }
        if ((locale.gAg) && (locale.isSelected) && (!locale.lDW))
        {
          ((a)localObject2).lEt.setVisibility(0);
          ((a)localObject2).lEv.setVisibility(8);
          ((a)localObject2).lEu.setVisibility(8);
          AppMethodBeat.o(139695);
          return;
        }
        if ((!locale.gAg) && (locale.lDW) && (locale.isSelected))
        {
          ((a)localObject2).lEt.setVisibility(8);
          ((a)localObject2).lEv.setVisibility(8);
          ((a)localObject2).lEu.setVisibility(0);
          AppMethodBeat.o(139695);
          return;
        }
        if ((!locale.lDW) && (locale.isSelected) && (!locale.gAg))
        {
          ((a)localObject2).lEt.setVisibility(8);
          ((a)localObject2).lEv.setVisibility(8);
          ((a)localObject2).lEu.setVisibility(0);
          AppMethodBeat.o(139695);
          return;
        }
        if (!locale.isSelected)
        {
          ((a)localObject2).lEt.setVisibility(8);
          ((a)localObject2).lEv.setVisibility(8);
          ((a)localObject2).lEu.setVisibility(8);
        }
        AppMethodBeat.o(139695);
        return;
      case 1: 
        paramw = (b)paramw;
        paramw.progressBar.setVisibility(8);
        if (g.b(this.lEq))
        {
          paramw.lEx.setText((CharSequence)"最近连接");
          AppMethodBeat.o(139695);
          return;
        }
        paramw.lEx.setVisibility(8);
        AppMethodBeat.o(139695);
        return;
      }
      Object localObject1 = (b)paramw;
      Object localObject2 = ((b)localObject1).lEx;
      if (g.b(this.lEq)) {}
      for (paramw = (CharSequence)"其他设备";; paramw = (CharSequence)"可连接设备")
      {
        ((TextView)localObject2).setText(paramw);
        d.c.b.bdE("progressBarHolder").schedule((TimerTask)new d(this, (b)localObject1), 10000L, 9223372036854775807L);
        break;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(139697);
      if (g.b(this.lEq)) {}
      for (int i = this.lEq.lEn.lFm.size() + this.lEq.lEn.lFl.size() + 2;; i = this.lEq.lEn.lFl.size() + this.lEq.lEn.lFm.size() + 1)
      {
        ae.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "item count = ".concat(String.valueOf(i)));
        AppMethodBeat.o(139697);
        return i;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(139694);
      if ((paramInt == 0) && (g.b(this.lEq)))
      {
        AppMethodBeat.o(139694);
        return 1;
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      if ((g.b(this.lEq)) && (paramInt == this.lEq.lEn.lFm.size() + 1))
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      AppMethodBeat.o(139694);
      return 3;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"})
    @SuppressLint({"ResourceType"})
    public final class a
      extends RecyclerView.w
    {
      TextView lEr;
      FrameLayout lEs;
      ProgressBar lEt;
      ImageView lEu;
      TextView lEv;
      
      public a()
      {
        super();
        AppMethodBeat.i(139688);
        this$1 = localObject.findViewById(2131306120);
        p.g(g.b.this, "itemView.findViewById(R.id.tv_device_name)");
        this.lEr = ((TextView)g.b.this);
        this$1 = localObject.findViewById(2131300125);
        p.g(g.b.this, "itemView.findViewById(R.id.fl_device_item)");
        this.lEs = ((FrameLayout)g.b.this);
        this$1 = localObject.findViewById(2131303200);
        p.g(g.b.this, "itemView.findViewById(R.id.pb_device_connecting)");
        this.lEt = ((ProgressBar)g.b.this);
        this$1 = localObject.findViewById(2131301208);
        p.g(g.b.this, "itemView.findViewById(R.id.iv_connected)");
        this.lEu = ((ImageView)g.b.this);
        this$1 = localObject.findViewById(2131306112);
        p.g(g.b.this, "itemView.findViewById(R.id.tv_cast_fail)");
        this.lEv = ((TextView)g.b.this);
        this.lEu.setImageResource(2131689876);
        AppMethodBeat.o(139688);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"})
    public final class b
      extends RecyclerView.w
    {
      TextView lEx;
      ProgressBar progressBar;
      
      public b()
      {
        super();
        AppMethodBeat.i(139689);
        this$1 = localObject.findViewById(2131306151);
        p.g(g.b.this, "itemView.findViewById(R.id.tv_select_device_title)");
        this.lEx = ((TextView)g.b.this);
        this$1 = localObject.findViewById(2131303201);
        p.g(g.b.this, "itemView.findViewById(R.id.pb_device_search)");
        this.progressBar = ((ProgressBar)g.b.this);
        AppMethodBeat.o(139689);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(g.b paramb, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(139690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i;
        if (g.c(this.lEw.lEq) != null)
        {
          if (((Collection)this.lEw.lEq.lEn.lFm).isEmpty()) {
            break label164;
          }
          i = 1;
          if ((i == 0) || (i > this.lEw.lEq.lEn.lFm.size())) {
            break label169;
          }
          paramView = g.c(this.lEw.lEq);
          if (paramView == null) {
            p.gkB();
          }
          paramView.p(g.b.a(this.lEw, i).lDX, Integer.valueOf(paramInt));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(139690);
          return;
          label164:
          i = 0;
          break;
          label169:
          paramView = g.c(this.lEw.lEq);
          if (paramView == null) {
            p.gkB();
          }
          paramView.p(g.b.a(this.lEw, i).lDX, Integer.valueOf(paramInt));
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
    public static final class d
      extends TimerTask
    {
      public d(g.b paramb, g.b.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(139692);
        ar.f((Runnable)new a(this));
        AppMethodBeat.o(139692);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindSearchHeader$1$1"})
      static final class a
        implements Runnable
      {
        a(g.b.d paramd) {}
        
        public final void run()
        {
          AppMethodBeat.i(139691);
          this.lEA.lEz.progressBar.setVisibility(8);
          TextView localTextView = this.lEA.lEz.lEx;
          String str;
          if (g.b(this.lEA.lEw.lEq)) {
            str = "暂无其他设备";
          }
          for (;;)
          {
            localTextView.setText((CharSequence)str);
            AppMethodBeat.o(139691);
            return;
            if (this.lEA.lEw.lEq.lEn.lFl.isEmpty()) {
              str = "暂无可连接设备";
            } else {
              str = "可连接设备";
            }
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class f
    implements DialogInterface.OnCancelListener
  {
    f(g paramg) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161188);
      paramDialogInterface = g.c(this.lEq);
      if (paramDialogInterface != null) {
        paramDialogInterface.p(null, Integer.valueOf(0));
      }
      this.lEq.cve.getRuntime().a((aj)g.e(this.lEq));
      AppMethodBeat.o(161188);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(g paramg) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161189);
      if (g.f(this.lEq) != null)
      {
        paramDialogInterface = g.f(this.lEq);
        if (paramDialogInterface == null) {
          p.gkB();
        }
        if (!paramDialogInterface.isAlive())
        {
          paramDialogInterface = this.lEq;
          View localView = g.g(this.lEq);
          if (localView == null) {
            p.gkB();
          }
          g.a(paramDialogInterface, localView.getViewTreeObserver());
        }
        paramDialogInterface = g.f(this.lEq);
        if (paramDialogInterface == null) {
          p.gkB();
        }
        paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.lEq);
        g.a(this.lEq, null);
      }
      paramDialogInterface = this.lEq.lEk;
      int i = ((Collection)this.lEq.lEn.lFm).size();
      paramDialogInterface.invoke(Integer.valueOf(((Collection)this.lEq.lEn.lFl).size() + i));
      AppMethodBeat.o(161189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.g
 * JD-Core Version:    0.7.0.1
 */