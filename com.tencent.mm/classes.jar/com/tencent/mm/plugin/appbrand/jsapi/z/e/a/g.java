package com.tencent.mm.plugin.appbrand.jsapi.z.e.a;

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
import android.view.KeyEvent;
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
import com.tencent.mm.plugin.appbrand.h.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Landroid/support/design/widget/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"})
public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final g.a lcR;
  ViewTreeObserver adE;
  final com.tencent.mm.plugin.appbrand.jsapi.z.e.b ckb;
  View khe;
  Dialog lcA;
  b lcB;
  int lcC;
  BottomSheetBehavior<?> lcD;
  boolean lcE;
  int lcF;
  boolean lcG;
  boolean lcH;
  boolean lcI;
  int lcJ;
  m<? super c, ? super Integer, y> lcK;
  private d.g.a.a<y> lcL;
  d.g.a.b<? super Integer, y> lcM;
  d.g.a.a<y> lcN;
  private final c lcO;
  final j lcP;
  final boolean lcQ;
  Context mContext;
  View oP;
  
  static
  {
    AppMethodBeat.i(139710);
    lcR = new g.a((byte)0);
    AppMethodBeat.o(139710);
  }
  
  private g(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.z.e.b paramb, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(139709);
    this.ckb = paramb;
    this.lcP = paramj;
    this.lcQ = paramBoolean;
    this.mContext = paramContext;
    this.lcH = true;
    this.lcI = true;
    this.lcM = ((d.g.a.b)g.h.ldd);
    this.lcO = new c(this);
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
      k.g(paramContext, "(mContext as Activity).window");
      paramContext = paramContext.getDecorView();
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      this.oP = ((ViewGroup)paramContext).findViewById(16908290);
    }
    paramb = this.mContext;
    if (this.lcI)
    {
      if (paramb == null) {
        k.fOy();
      }
      paramContext = (Dialog)new com.tencent.mm.ui.widget.a.b(paramb);
      this.lcA = paramContext;
      paramContext = View.inflate(paramb, 2131494575, null);
      k.g(paramContext, "View.inflate(context, R.…video_cast_devices, null)");
      this.khe = paramContext;
      paramContext = this.khe;
      if (paramContext == null) {
        k.aVY("rootView");
      }
      paramContext.findViewById(2131306133).setOnClickListener((View.OnClickListener)new d(this));
      paramContext = this.khe;
      if (paramContext == null) {
        k.aVY("rootView");
      }
      paramContext = (RecyclerView)paramContext.findViewById(2131297464);
      paramContext.setHasFixedSize(true);
      paramb = this.khe;
      if (paramb == null) {
        k.aVY("rootView");
      }
      paramb.findViewById(2131301207).setOnClickListener((View.OnClickListener)new e(this));
      paramb = this.khe;
      if (paramb == null) {
        k.aVY("rootView");
      }
      paramb = (ImageView)paramb.findViewById(2131301206);
      if (!i.cgk.DT()) {
        break label613;
      }
      paramj = this.mContext;
      if (paramj == null) {
        k.fOy();
      }
      paramb.setImageDrawable(android.support.v4.content.b.l(paramj, 2131230851));
      label387:
      this.lcE = aly();
      i = ao.av(this.mContext, 2131165930);
      if (!this.lcE) {
        break label639;
      }
    }
    label613:
    label639:
    for (int i = (int)(i * 4.5D) + ao.av(this.mContext, 2131165923);; i = (int)(i * 6.5D) + ao.av(this.mContext, 2131165923))
    {
      this.lcC = i;
      k.g(paramContext, "mRecyclerView");
      paramContext.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      paramContext.setFocusable(false);
      this.lcB = new b();
      paramb = this.lcB;
      if (paramb == null) {
        k.aVY("recycleViewAdapter");
      }
      paramContext.setAdapter((RecyclerView.a)paramb);
      paramContext.setOverScrollMode(1);
      paramContext = this.lcA;
      if (paramContext == null) {
        k.aVY("mBottomSheetDialog");
      }
      paramb = this.khe;
      if (paramb == null) {
        k.aVY("rootView");
      }
      paramContext.setContentView(paramb);
      if (this.lcI) {
        break label694;
      }
      paramContext = this.khe;
      if (paramContext == null) {
        k.aVY("rootView");
      }
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break label663;
      }
      paramContext = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(139709);
      throw paramContext;
      if (paramb == null) {
        k.fOy();
      }
      paramContext = (Dialog)new android.support.design.widget.a(paramb);
      break;
      paramj = this.mContext;
      if (paramj == null) {
        k.fOy();
      }
      paramb.setImageDrawable(android.support.v4.content.b.l(paramj, 2131230844));
      break label387;
    }
    label663:
    this.lcD = BottomSheetBehavior.l((View)paramContext);
    paramContext = this.lcD;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.J(this.lcC);
    label694:
    paramContext = this.lcA;
    if (paramContext == null) {
      k.aVY("mBottomSheetDialog");
    }
    paramContext.setOnCancelListener((DialogInterface.OnCancelListener)new f(this));
    paramContext = this.lcA;
    if (paramContext == null) {
      k.aVY("mBottomSheetDialog");
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new g(this));
    paramContext = this.lcA;
    if (paramContext == null) {
      k.aVY("mBottomSheetDialog");
    }
    paramContext.setCancelable(false);
    this.ckb.getRuntime().a(4, -1, (aj)this.lcO);
    AppMethodBeat.o(139709);
  }
  
  final boolean aly()
  {
    AppMethodBeat.i(139706);
    Object localObject = this.mContext;
    if (localObject == null) {
      k.fOy();
    }
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "mContext!!.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(139706);
      return true;
    }
    AppMethodBeat.o(139706);
    return false;
  }
  
  public final void bmi()
  {
    AppMethodBeat.i(139708);
    if (((g)this).lcA != null)
    {
      Object localObject;
      if (this.lcD != null)
      {
        localObject = this.lcD;
        if (localObject == null) {
          k.fOy();
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
          localObject = this.lcA;
          if (localObject == null) {
            k.aVY("mBottomSheetDialog");
          }
          ((Dialog)localObject).dismiss();
        }
      }
    }
    this.ckb.getRuntime().a((aj)this.lcO);
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
      k.g(localObject, "(mContext as Activity).window");
      localObject = ((Window)localObject).getWindowManager();
      k.g(localObject, "(mContext as Activity).window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      k.g(localObject, "(mContext as Activity).w…dowManager.defaultDisplay");
      i = ((Display)localObject).getRotation();
    }
    AppMethodBeat.o(139704);
    return i;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(139705);
    if (((g)this).lcA != null)
    {
      Dialog localDialog = this.lcA;
      if (localDialog == null) {
        k.aVY("mBottomSheetDialog");
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
      View localView = this.oP;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bmi();
        AppMethodBeat.o(139707);
        return;
      }
      if ((isShowing()) && ((this.lcE != aly()) || (this.lcF != getRotation()))) {
        bmi();
      }
    }
    AppMethodBeat.o(139707);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"})
  final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    private final e to(int paramInt)
    {
      AppMethodBeat.i(139696);
      if (!((Collection)this.lcS.lcP.ldO).isEmpty()) {}
      for (int i = 1; (i != 0) && (paramInt <= this.lcS.lcP.ldO.size()); i = 0)
      {
        localObject = this.lcS.lcP.ldO.get(paramInt);
        k.g(localObject, "videoCastDeviceManager.r…tDevices[posSubFistTitle]");
        localObject = (e)localObject;
        AppMethodBeat.o(139696);
        return localObject;
      }
      if (!((Collection)this.lcS.lcP.ldO).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      label166:
      for (Object localObject = (e)this.lcS.lcP.ldN.get(paramInt - this.lcS.lcP.ldO.size() - 1);; localObject = (e)this.lcS.lcP.ldN.get(paramInt))
      {
        k.g(localObject, "if (videoCastDeviceManag…tTitle]\n                }");
        AppMethodBeat.o(139696);
        return localObject;
        i = 0;
        break;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(139693);
      k.h(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        paramViewGroup = LayoutInflater.from(g.a(this.lcS)).inflate(2131494528, paramViewGroup, false);
        k.g(paramViewGroup, "itemView");
        paramViewGroup = (RecyclerView.w)new a(paramViewGroup);
        AppMethodBeat.o(139693);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(g.a(this.lcS)).inflate(2131494576, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup);
      AppMethodBeat.o(139693);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(139695);
      k.h(paramw, "viewHolder");
      switch (getItemViewType(paramInt))
      {
      default: 
        AppMethodBeat.o(139695);
        return;
      case 3: 
        localObject2 = (a)paramw;
        final int i = paramInt - 1;
        ((a)localObject2).lcU.setOnClickListener((View.OnClickListener)new c(this, i, paramInt));
        e locale = to(i);
        ac.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "bindDeviceViewHolder: ".concat(String.valueOf(locale)));
        TextView localTextView = ((a)localObject2).lcT;
        paramw = locale.lcz.bbJ();
        if (paramw == null) {
          k.fOy();
        }
        localObject1 = paramw.jID;
        k.g(localObject1, "device.mrDevice.dlnaDevice!!.friendlyName");
        paramw = (RecyclerView.w)localObject1;
        if (bs.isNullOrNil((String)localObject1))
        {
          paramw = locale.lcz.bbJ();
          if (paramw == null) {
            k.fOy();
          }
          paramw = paramw.jIF;
          k.g(paramw, "device.mrDevice.dlnaDevice!!.modeName");
        }
        localTextView.setText((CharSequence)paramw);
        if (!this.lcS.lcQ)
        {
          ((a)localObject2).lcV.setVisibility(8);
          ((a)localObject2).lcW.setVisibility(8);
          ((a)localObject2).lcX.setVisibility(8);
          AppMethodBeat.o(139695);
          return;
        }
        if ((locale.gdP) && (locale.isSelected) && (!locale.lcy))
        {
          ((a)localObject2).lcV.setVisibility(0);
          ((a)localObject2).lcX.setVisibility(8);
          ((a)localObject2).lcW.setVisibility(8);
          AppMethodBeat.o(139695);
          return;
        }
        if ((!locale.gdP) && (locale.lcy) && (locale.isSelected))
        {
          ((a)localObject2).lcV.setVisibility(8);
          ((a)localObject2).lcX.setVisibility(8);
          ((a)localObject2).lcW.setVisibility(0);
          AppMethodBeat.o(139695);
          return;
        }
        if ((!locale.lcy) && (locale.isSelected) && (!locale.gdP))
        {
          ((a)localObject2).lcV.setVisibility(8);
          ((a)localObject2).lcX.setVisibility(8);
          ((a)localObject2).lcW.setVisibility(0);
          AppMethodBeat.o(139695);
          return;
        }
        if (!locale.isSelected)
        {
          ((a)localObject2).lcV.setVisibility(8);
          ((a)localObject2).lcX.setVisibility(8);
          ((a)localObject2).lcW.setVisibility(8);
        }
        AppMethodBeat.o(139695);
        return;
      case 1: 
        paramw = (b)paramw;
        paramw.progressBar.setVisibility(8);
        if (g.b(this.lcS))
        {
          paramw.lcZ.setText((CharSequence)"最近连接");
          AppMethodBeat.o(139695);
          return;
        }
        paramw.lcZ.setVisibility(8);
        AppMethodBeat.o(139695);
        return;
      }
      Object localObject1 = (b)paramw;
      Object localObject2 = ((b)localObject1).lcZ;
      if (g.b(this.lcS)) {}
      for (paramw = (CharSequence)"其他设备";; paramw = (CharSequence)"可连接设备")
      {
        ((TextView)localObject2).setText(paramw);
        d.c.b.aVX("progressBarHolder").schedule((TimerTask)new d(this, (b)localObject1), 10000L, 9223372036854775807L);
        break;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(139697);
      if (g.b(this.lcS)) {}
      for (int i = this.lcS.lcP.ldO.size() + this.lcS.lcP.ldN.size() + 2;; i = this.lcS.lcP.ldN.size() + this.lcS.lcP.ldO.size() + 1)
      {
        ac.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "item count = ".concat(String.valueOf(i)));
        AppMethodBeat.o(139697);
        return i;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(139694);
      if ((paramInt == 0) && (g.b(this.lcS)))
      {
        AppMethodBeat.o(139694);
        return 1;
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      if ((g.b(this.lcS)) && (paramInt == this.lcS.lcP.ldO.size() + 1))
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      AppMethodBeat.o(139694);
      return 3;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"})
    @SuppressLint({"ResourceType"})
    public final class a
      extends RecyclerView.w
    {
      TextView lcT;
      FrameLayout lcU;
      ProgressBar lcV;
      ImageView lcW;
      TextView lcX;
      
      public a()
      {
        super();
        AppMethodBeat.i(139688);
        this$1 = localObject.findViewById(2131306120);
        k.g(g.b.this, "itemView.findViewById(R.id.tv_device_name)");
        this.lcT = ((TextView)g.b.this);
        this$1 = localObject.findViewById(2131300125);
        k.g(g.b.this, "itemView.findViewById(R.id.fl_device_item)");
        this.lcU = ((FrameLayout)g.b.this);
        this$1 = localObject.findViewById(2131303200);
        k.g(g.b.this, "itemView.findViewById(R.id.pb_device_connecting)");
        this.lcV = ((ProgressBar)g.b.this);
        this$1 = localObject.findViewById(2131301208);
        k.g(g.b.this, "itemView.findViewById(R.id.iv_connected)");
        this.lcW = ((ImageView)g.b.this);
        this$1 = localObject.findViewById(2131306112);
        k.g(g.b.this, "itemView.findViewById(R.id.tv_cast_fail)");
        this.lcX = ((TextView)g.b.this);
        this.lcW.setImageResource(2131689876);
        AppMethodBeat.o(139688);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"})
    public final class b
      extends RecyclerView.w
    {
      TextView lcZ;
      ProgressBar progressBar;
      
      public b()
      {
        super();
        AppMethodBeat.i(139689);
        this$1 = localObject.findViewById(2131306151);
        k.g(g.b.this, "itemView.findViewById(R.id.tv_select_device_title)");
        this.lcZ = ((TextView)g.b.this);
        this$1 = localObject.findViewById(2131303201);
        k.g(g.b.this, "itemView.findViewById(R.id.pb_device_search)");
        this.progressBar = ((ProgressBar)g.b.this);
        AppMethodBeat.o(139689);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(g.b paramb, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(139690);
        if (g.c(this.lcY.lcS) != null)
        {
          if (!((Collection)this.lcY.lcS.lcP.ldO).isEmpty()) {}
          for (int i = 1; (i != 0) && (i <= this.lcY.lcS.lcP.ldO.size()); i = 0)
          {
            paramView = g.c(this.lcY.lcS);
            if (paramView == null) {
              k.fOy();
            }
            paramView.n(g.b.a(this.lcY, i).lcz, Integer.valueOf(paramInt));
            AppMethodBeat.o(139690);
            return;
          }
          paramView = g.c(this.lcY.lcS);
          if (paramView == null) {
            k.fOy();
          }
          paramView.n(g.b.a(this.lcY, i).lcz, Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(139690);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
    public static final class d
      extends TimerTask
    {
      public d(g.b paramb, g.b.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(139692);
        ap.f((Runnable)new a(this));
        AppMethodBeat.o(139692);
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindSearchHeader$1$1"})
      static final class a
        implements Runnable
      {
        a(g.b.d paramd) {}
        
        public final void run()
        {
          AppMethodBeat.i(139691);
          this.ldc.ldb.progressBar.setVisibility(8);
          TextView localTextView = this.ldc.ldb.lcZ;
          String str;
          if (g.b(this.ldc.lcY.lcS)) {
            str = "暂无其他设备";
          }
          for (;;)
          {
            localTextView.setText((CharSequence)str);
            AppMethodBeat.o(139691);
            return;
            if (this.ldc.lcY.lcS.lcP.ldN.isEmpty()) {
              str = "暂无可连接设备";
            } else {
              str = "可连接设备";
            }
          }
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class c
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139698);
      k.h(paramKeyEvent, "event");
      if (1 == paramKeyEvent.getAction())
      {
        AppMethodBeat.o(139698);
        return false;
      }
      paramKeyEvent = g.c(this.lcS);
      if (paramKeyEvent != null) {
        paramKeyEvent.n(null, Integer.valueOf(0));
      }
      this.lcS.bmi();
      AppMethodBeat.o(139698);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(139699);
      if (this.lcS.lcN != null)
      {
        paramView = this.lcS.lcN;
        if (paramView != null)
        {
          paramView.invoke();
          AppMethodBeat.o(139699);
          return;
        }
      }
      AppMethodBeat.o(139699);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(139700);
      paramView = g.d(this.lcS);
      if (paramView != null) {
        paramView.invoke();
      }
      paramView = g.c(this.lcS);
      if (paramView != null) {
        paramView.n(null, Integer.valueOf(0));
      }
      this.lcS.bmi();
      AppMethodBeat.o(139700);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class f
    implements DialogInterface.OnCancelListener
  {
    f(g paramg) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161188);
      paramDialogInterface = g.c(this.lcS);
      if (paramDialogInterface != null) {
        paramDialogInterface.n(null, Integer.valueOf(0));
      }
      this.lcS.ckb.getRuntime().a((aj)g.e(this.lcS));
      AppMethodBeat.o(161188);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(g paramg) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161189);
      if (g.f(this.lcS) != null)
      {
        paramDialogInterface = g.f(this.lcS);
        if (paramDialogInterface == null) {
          k.fOy();
        }
        if (!paramDialogInterface.isAlive())
        {
          paramDialogInterface = this.lcS;
          View localView = g.g(this.lcS);
          if (localView == null) {
            k.fOy();
          }
          g.a(paramDialogInterface, localView.getViewTreeObserver());
        }
        paramDialogInterface = g.f(this.lcS);
        if (paramDialogInterface == null) {
          k.fOy();
        }
        paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.lcS);
        g.a(this.lcS, null);
      }
      paramDialogInterface = this.lcS.lcM;
      int i = ((Collection)this.lcS.lcP.ldO).size();
      paramDialogInterface.ay(Integer.valueOf(((Collection)this.lcS.lcP.ldN).size() + i));
      AppMethodBeat.o(161189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.a.g
 * JD-Core Version:    0.7.0.1
 */