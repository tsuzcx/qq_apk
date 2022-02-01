package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Landroid/support/design/widget/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"})
public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final g.a mLY;
  ViewTreeObserver afI;
  final com.tencent.mm.plugin.appbrand.jsapi.ag.e.b cJc;
  View lJI;
  Context mContext;
  Dialog mLH;
  b mLI;
  int mLJ;
  BottomSheetBehavior<?> mLK;
  boolean mLL;
  int mLM;
  boolean mLN;
  boolean mLO;
  boolean mLP;
  int mLQ;
  m<? super c, ? super Integer, x> mLR;
  private kotlin.g.a.a<x> mLS;
  kotlin.g.a.b<? super Integer, x> mLT;
  kotlin.g.a.a<x> mLU;
  private final g.c mLV;
  final j mLW;
  final boolean mLX;
  View qK;
  
  static
  {
    AppMethodBeat.i(139710);
    mLY = new g.a((byte)0);
    AppMethodBeat.o(139710);
  }
  
  private g(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.ag.e.b paramb, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(139709);
    this.cJc = paramb;
    this.mLW = paramj;
    this.mLX = paramBoolean;
    this.mContext = paramContext;
    this.mLO = true;
    this.mLP = true;
    this.mLT = ((kotlin.g.a.b)g.h.mMk);
    this.mLV = new g.c(this);
    if ((this.mContext instanceof Activity))
    {
      paramContext = this.mContext;
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      paramContext = ((Activity)paramContext).getWindow();
      p.g(paramContext, "(mContext as Activity).window");
      paramContext = paramContext.getDecorView();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      this.qK = ((ViewGroup)paramContext).findViewById(16908290);
    }
    paramb = this.mContext;
    if (this.mLP)
    {
      if (paramb == null) {
        p.hyc();
      }
      paramContext = (Dialog)new com.tencent.mm.ui.widget.a.b(paramb);
      this.mLH = paramContext;
      paramContext = View.inflate(paramb, 2131495201, null);
      p.g(paramContext, "View.inflate(context, R.…video_cast_devices, null)");
      this.lJI = paramContext;
      paramContext = this.lJI;
      if (paramContext == null) {
        p.btv("rootView");
      }
      paramContext.findViewById(2131309493).setOnClickListener((View.OnClickListener)new g.d(this));
      paramContext = this.lJI;
      if (paramContext == null) {
        p.btv("rootView");
      }
      paramContext = (RecyclerView)paramContext.findViewById(2131297699);
      paramContext.setHasFixedSize(true);
      paramb = this.lJI;
      if (paramb == null) {
        p.btv("rootView");
      }
      paramb.findViewById(2131302887).setOnClickListener((View.OnClickListener)new g.e(this));
      paramb = this.lJI;
      if (paramb == null) {
        p.btv("rootView");
      }
      paramb = (ImageView)paramb.findViewById(2131302886);
      if (!com.tencent.luggage.h.j.cDv.isDarkMode()) {
        break label612;
      }
      paramj = this.mContext;
      if (paramj == null) {
        p.hyc();
      }
      paramb.setImageDrawable(android.support.v4.content.b.l(paramj, 2131230864));
      label386:
      this.mLL = isLandscape();
      i = at.aH(this.mContext, 2131165957);
      if (!this.mLL) {
        break label638;
      }
    }
    label612:
    label638:
    for (int i = (int)(i * 4.5D) + at.aH(this.mContext, 2131165950);; i = (int)(i * 6.5D) + at.aH(this.mContext, 2131165950))
    {
      this.mLJ = i;
      p.g(paramContext, "mRecyclerView");
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramContext.setFocusable(false);
      this.mLI = new b();
      paramb = this.mLI;
      if (paramb == null) {
        p.btv("recycleViewAdapter");
      }
      paramContext.setAdapter((RecyclerView.a)paramb);
      paramContext.setOverScrollMode(1);
      paramContext = this.mLH;
      if (paramContext == null) {
        p.btv("mBottomSheetDialog");
      }
      paramb = this.lJI;
      if (paramb == null) {
        p.btv("rootView");
      }
      paramContext.setContentView(paramb);
      if (this.mLP) {
        break label693;
      }
      paramContext = this.lJI;
      if (paramContext == null) {
        p.btv("rootView");
      }
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break label662;
      }
      paramContext = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(139709);
      throw paramContext;
      if (paramb == null) {
        p.hyc();
      }
      paramContext = (Dialog)new android.support.design.widget.a(paramb);
      break;
      paramj = this.mContext;
      if (paramj == null) {
        p.hyc();
      }
      paramb.setImageDrawable(android.support.v4.content.b.l(paramj, 2131230857));
      break label386;
    }
    label662:
    this.mLK = BottomSheetBehavior.l((View)paramContext);
    paramContext = this.mLK;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.J(this.mLJ);
    label693:
    paramContext = this.mLH;
    if (paramContext == null) {
      p.btv("mBottomSheetDialog");
    }
    paramContext.setOnCancelListener((DialogInterface.OnCancelListener)new f(this));
    paramContext = this.mLH;
    if (paramContext == null) {
      p.btv("mBottomSheetDialog");
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new g(this));
    paramContext = this.mLH;
    if (paramContext == null) {
      p.btv("mBottomSheetDialog");
    }
    paramContext.setCancelable(false);
    this.cJc.getRuntime().a(4, -1, (al)this.mLV);
    AppMethodBeat.o(139709);
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(139708);
    if (((g)this).mLH != null)
    {
      Object localObject;
      if (this.mLK != null)
      {
        localObject = this.mLK;
        if (localObject == null) {
          p.hyc();
        }
        ((BottomSheetBehavior)localObject).u(true);
      }
      if (this.mContext != null)
      {
        localObject = this.mContext;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(139708);
          throw ((Throwable)localObject);
        }
        if (!((Activity)localObject).isFinishing())
        {
          localObject = this.mLH;
          if (localObject == null) {
            p.btv("mBottomSheetDialog");
          }
          ((Dialog)localObject).dismiss();
        }
      }
    }
    this.cJc.getRuntime().a((al)this.mLV);
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
        localObject = new t("null cannot be cast to non-null type android.app.Activity");
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
  
  final boolean isLandscape()
  {
    AppMethodBeat.i(139706);
    Object localObject = this.mContext;
    if (localObject == null) {
      p.hyc();
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
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(139705);
    if (((g)this).mLH != null)
    {
      Dialog localDialog = this.mLH;
      if (localDialog == null) {
        p.btv("mBottomSheetDialog");
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
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(139707);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(139707);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"})
  final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private final e xW(int paramInt)
    {
      AppMethodBeat.i(139696);
      if (!((Collection)this.mLZ.mLW.mMV).isEmpty()) {}
      for (int i = 1; (i != 0) && (paramInt <= this.mLZ.mLW.mMV.size()); i = 0)
      {
        localObject = this.mLZ.mLW.mMV.get(paramInt);
        p.g(localObject, "videoCastDeviceManager.r…tDevices[posSubFistTitle]");
        localObject = (e)localObject;
        AppMethodBeat.o(139696);
        return localObject;
      }
      if (!((Collection)this.mLZ.mLW.mMV).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      label166:
      for (Object localObject = (e)this.mLZ.mLW.mMU.get(paramInt - this.mLZ.mLW.mMV.size() - 1);; localObject = (e)this.mLZ.mLW.mMU.get(paramInt))
      {
        p.g(localObject, "if (videoCastDeviceManag…tTitle]\n                }");
        AppMethodBeat.o(139696);
        return localObject;
        i = 0;
        break;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(139693);
      p.h(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        paramViewGroup = LayoutInflater.from(g.a(this.mLZ)).inflate(2131495124, paramViewGroup, false);
        p.g(paramViewGroup, "itemView");
        paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
        AppMethodBeat.o(139693);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(g.a(this.mLZ)).inflate(2131495202, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
      AppMethodBeat.o(139693);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(139695);
      p.h(paramv, "viewHolder");
      switch (getItemViewType(paramInt))
      {
      default: 
        AppMethodBeat.o(139695);
        return;
      case 3: 
        localObject2 = (a)paramv;
        final int i = paramInt - 1;
        ((a)localObject2).mMb.setOnClickListener((View.OnClickListener)new c(this, i, paramInt));
        e locale = xW(i);
        Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "bindDeviceViewHolder: ".concat(String.valueOf(locale)));
        TextView localTextView = ((a)localObject2).mMa;
        paramv = locale.mLG.bBo();
        if (paramv == null) {
          p.hyc();
        }
        localObject1 = paramv.ljP;
        p.g(localObject1, "device.mrDevice.dlnaDevice!!.friendlyName");
        paramv = (RecyclerView.v)localObject1;
        if (Util.isNullOrNil((String)localObject1))
        {
          paramv = locale.mLG.bBo();
          if (paramv == null) {
            p.hyc();
          }
          paramv = paramv.ljR;
          p.g(paramv, "device.mrDevice.dlnaDevice!!.modeName");
        }
        localTextView.setText((CharSequence)paramv);
        if (!this.mLZ.mLX)
        {
          ((a)localObject2).mMc.setVisibility(8);
          ((a)localObject2).mMd.setVisibility(8);
          ((a)localObject2).mMe.setVisibility(8);
          AppMethodBeat.o(139695);
          return;
        }
        if ((locale.hmV) && (locale.isSelected) && (!locale.mLF))
        {
          ((a)localObject2).mMc.setVisibility(0);
          ((a)localObject2).mMe.setVisibility(8);
          ((a)localObject2).mMd.setVisibility(8);
          AppMethodBeat.o(139695);
          return;
        }
        if ((!locale.hmV) && (locale.mLF) && (locale.isSelected))
        {
          ((a)localObject2).mMc.setVisibility(8);
          ((a)localObject2).mMe.setVisibility(8);
          ((a)localObject2).mMd.setVisibility(0);
          AppMethodBeat.o(139695);
          return;
        }
        if ((!locale.mLF) && (locale.isSelected) && (!locale.hmV))
        {
          ((a)localObject2).mMc.setVisibility(8);
          ((a)localObject2).mMe.setVisibility(8);
          ((a)localObject2).mMd.setVisibility(0);
          AppMethodBeat.o(139695);
          return;
        }
        if (!locale.isSelected)
        {
          ((a)localObject2).mMc.setVisibility(8);
          ((a)localObject2).mMe.setVisibility(8);
          ((a)localObject2).mMd.setVisibility(8);
        }
        AppMethodBeat.o(139695);
        return;
      case 1: 
        paramv = (b)paramv;
        paramv.progressBar.setVisibility(8);
        if (g.b(this.mLZ))
        {
          paramv.mMg.setText((CharSequence)"最近连接");
          AppMethodBeat.o(139695);
          return;
        }
        paramv.mMg.setVisibility(8);
        AppMethodBeat.o(139695);
        return;
      }
      Object localObject1 = (b)paramv;
      Object localObject2 = ((b)localObject1).mMg;
      if (g.b(this.mLZ)) {}
      for (paramv = (CharSequence)"其他设备";; paramv = (CharSequence)"可连接设备")
      {
        ((TextView)localObject2).setText(paramv);
        kotlin.c.b.btu("progressBarHolder").schedule((TimerTask)new d(this, (b)localObject1), 10000L, 9223372036854775807L);
        break;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(139697);
      if (g.b(this.mLZ)) {}
      for (int i = this.mLZ.mLW.mMV.size() + this.mLZ.mLW.mMU.size() + 2;; i = this.mLZ.mLW.mMU.size() + this.mLZ.mLW.mMV.size() + 1)
      {
        Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "item count = ".concat(String.valueOf(i)));
        AppMethodBeat.o(139697);
        return i;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(139694);
      if ((paramInt == 0) && (g.b(this.mLZ)))
      {
        AppMethodBeat.o(139694);
        return 1;
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      if ((g.b(this.mLZ)) && (paramInt == this.mLZ.mLW.mMV.size() + 1))
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      AppMethodBeat.o(139694);
      return 3;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"})
    @SuppressLint({"ResourceType"})
    public final class a
      extends RecyclerView.v
    {
      TextView mMa;
      FrameLayout mMb;
      ProgressBar mMc;
      ImageView mMd;
      TextView mMe;
      
      public a()
      {
        super();
        AppMethodBeat.i(139688);
        this$1 = localObject.findViewById(2131309476);
        p.g(g.b.this, "itemView.findViewById(R.id.tv_device_name)");
        this.mMa = ((TextView)g.b.this);
        this$1 = localObject.findViewById(2131301566);
        p.g(g.b.this, "itemView.findViewById(R.id.fl_device_item)");
        this.mMb = ((FrameLayout)g.b.this);
        this$1 = localObject.findViewById(2131305866);
        p.g(g.b.this, "itemView.findViewById(R.id.pb_device_connecting)");
        this.mMc = ((ProgressBar)g.b.this);
        this$1 = localObject.findViewById(2131302888);
        p.g(g.b.this, "itemView.findViewById(R.id.iv_connected)");
        this.mMd = ((ImageView)g.b.this);
        this$1 = localObject.findViewById(2131309465);
        p.g(g.b.this, "itemView.findViewById(R.id.tv_cast_fail)");
        this.mMe = ((TextView)g.b.this);
        this.mMd.setImageResource(2131689891);
        AppMethodBeat.o(139688);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"})
    public final class b
      extends RecyclerView.v
    {
      TextView mMg;
      ProgressBar progressBar;
      
      public b()
      {
        super();
        AppMethodBeat.i(139689);
        this$1 = localObject.findViewById(2131309523);
        p.g(g.b.this, "itemView.findViewById(R.id.tv_select_device_title)");
        this.mMg = ((TextView)g.b.this);
        this$1 = localObject.findViewById(2131305867);
        p.g(g.b.this, "itemView.findViewById(R.id.pb_device_search)");
        this.progressBar = ((ProgressBar)g.b.this);
        AppMethodBeat.o(139689);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(g.b paramb, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(139690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i;
        if (g.c(this.mMf.mLZ) != null)
        {
          if (((Collection)this.mMf.mLZ.mLW.mMV).isEmpty()) {
            break label164;
          }
          i = 1;
          if ((i == 0) || (i > this.mMf.mLZ.mLW.mMV.size())) {
            break label169;
          }
          paramView = g.c(this.mMf.mLZ);
          if (paramView == null) {
            p.hyc();
          }
          paramView.invoke(g.b.a(this.mMf, i).mLG, Integer.valueOf(paramInt));
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
          paramView = g.c(this.mMf.mLZ);
          if (paramView == null) {
            p.hyc();
          }
          paramView.invoke(g.b.a(this.mMf, i).mLG, Integer.valueOf(paramInt));
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
    public static final class d
      extends TimerTask
    {
      public d(g.b paramb, g.b.b paramb1) {}
      
      public final void run()
      {
        AppMethodBeat.i(139692);
        MMHandlerThread.postToMainThread((Runnable)new a(this));
        AppMethodBeat.o(139692);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindSearchHeader$1$1"})
      static final class a
        implements Runnable
      {
        a(g.b.d paramd) {}
        
        public final void run()
        {
          AppMethodBeat.i(139691);
          this.mMj.mMi.progressBar.setVisibility(8);
          TextView localTextView = this.mMj.mMi.mMg;
          String str;
          if (g.b(this.mMj.mMf.mLZ)) {
            str = "暂无其他设备";
          }
          for (;;)
          {
            localTextView.setText((CharSequence)str);
            AppMethodBeat.o(139691);
            return;
            if (this.mMj.mMf.mLZ.mLW.mMU.isEmpty()) {
              str = "暂无可连接设备";
            } else {
              str = "可连接设备";
            }
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class f
    implements DialogInterface.OnCancelListener
  {
    f(g paramg) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161188);
      paramDialogInterface = g.c(this.mLZ);
      if (paramDialogInterface != null) {
        paramDialogInterface.invoke(null, Integer.valueOf(0));
      }
      this.mLZ.cJc.getRuntime().a((al)g.e(this.mLZ));
      AppMethodBeat.o(161188);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(g paramg) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161189);
      if (g.f(this.mLZ) != null)
      {
        paramDialogInterface = g.f(this.mLZ);
        if (paramDialogInterface == null) {
          p.hyc();
        }
        if (!paramDialogInterface.isAlive())
        {
          paramDialogInterface = this.mLZ;
          View localView = g.g(this.mLZ);
          if (localView == null) {
            p.hyc();
          }
          g.a(paramDialogInterface, localView.getViewTreeObserver());
        }
        paramDialogInterface = g.f(this.mLZ);
        if (paramDialogInterface == null) {
          p.hyc();
        }
        paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.mLZ);
        g.a(this.mLZ, null);
      }
      paramDialogInterface = this.mLZ.mLT;
      int i = ((Collection)this.mLZ.mLW.mMV).size();
      paramDialogInterface.invoke(Integer.valueOf(((Collection)this.mLZ.mLW.mMU).size() + i));
      AppMethodBeat.o(161189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.g
 * JD-Core Version:    0.7.0.1
 */