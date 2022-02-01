package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.luggage.xweb_ext.a.a;
import com.tencent.luggage.xweb_ext.a.b;
import com.tencent.luggage.xweb_ext.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.am;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"})
public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final g.a pMQ;
  final com.tencent.mm.plugin.appbrand.jsapi.ai.e.b cJG;
  View lJ;
  ViewTreeObserver lS;
  Context mContext;
  View oFW;
  b pMA;
  int pMB;
  BottomSheetBehavior<?> pMC;
  boolean pMD;
  int pME;
  boolean pMF;
  boolean pMG;
  boolean pMH;
  int pMI;
  m<? super c, ? super Integer, x> pMJ;
  private kotlin.g.a.a<x> pMK;
  kotlin.g.a.b<? super Integer, x> pML;
  kotlin.g.a.a<x> pMM;
  private final g.c pMN;
  final j pMO;
  final boolean pMP;
  Dialog pMz;
  
  static
  {
    AppMethodBeat.i(139710);
    pMQ = new g.a((byte)0);
    AppMethodBeat.o(139710);
  }
  
  private g(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.ai.e.b paramb, j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(139709);
    this.cJG = paramb;
    this.pMO = paramj;
    this.pMP = paramBoolean;
    this.mContext = paramContext;
    this.pMG = true;
    this.pMH = true;
    this.pML = ((kotlin.g.a.b)g.h.pNc);
    this.pMN = new g.c(this);
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
      p.j(paramContext, "(mContext as Activity).window");
      paramContext = paramContext.getDecorView();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      this.lJ = ((ViewGroup)paramContext).findViewById(16908290);
    }
    paramb = this.mContext;
    if (this.pMH)
    {
      if (paramb == null) {
        p.iCn();
      }
      paramContext = (Dialog)new com.tencent.mm.ui.widget.a.b(paramb);
      this.pMz = paramContext;
      paramContext = View.inflate(paramb, a.c.layout_video_cast_devices, null);
      p.j(paramContext, "View.inflate(context, R.…video_cast_devices, null)");
      this.oFW = paramContext;
      paramContext = this.oFW;
      if (paramContext == null) {
        p.bGy("rootView");
      }
      paramContext.findViewById(a.b.tv_help_click_area).setOnClickListener((View.OnClickListener)new g.d(this));
      paramContext = this.oFW;
      if (paramContext == null) {
        p.bGy("rootView");
      }
      paramContext = (RecyclerView)paramContext.findViewById(a.b.bottom_sheet_menu_reccycleview);
      paramContext.setHasFixedSize(true);
      paramb = this.oFW;
      if (paramb == null) {
        p.bGy("rootView");
      }
      paramb.findViewById(a.b.iv_close_bottom_sheet_click_area).setOnClickListener((View.OnClickListener)new g.e(this));
      paramb = this.oFW;
      if (paramb == null) {
        p.bGy("rootView");
      }
      paramb = (ImageView)paramb.findViewById(a.b.iv_close_bottom_sheet);
      if (!com.tencent.luggage.k.j.cEc.isDarkMode()) {
        break label613;
      }
      paramj = this.mContext;
      if (paramj == null) {
        p.iCn();
      }
      paramb.setImageDrawable(androidx.core.content.a.m(paramj, a.a.actionbar_icon_light_close));
      label387:
      this.pMD = isLandscape();
      i = aw.aZ(this.mContext, com.tencent.mm.cr.a.d.bottomsheet_list_item_height);
      if (!this.pMD) {
        break label639;
      }
    }
    label613:
    label639:
    for (int i = (int)(i * 4.5D) + aw.aZ(this.mContext, com.tencent.mm.cr.a.d.bottomsheet_dividing_line_height);; i = (int)(i * 6.5D) + aw.aZ(this.mContext, com.tencent.mm.cr.a.d.bottomsheet_dividing_line_height))
    {
      this.pMB = i;
      p.j(paramContext, "mRecyclerView");
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramContext.setFocusable(false);
      this.pMA = new b();
      paramb = this.pMA;
      if (paramb == null) {
        p.bGy("recycleViewAdapter");
      }
      paramContext.setAdapter((RecyclerView.a)paramb);
      paramContext.setOverScrollMode(1);
      paramContext = this.pMz;
      if (paramContext == null) {
        p.bGy("mBottomSheetDialog");
      }
      paramb = this.oFW;
      if (paramb == null) {
        p.bGy("rootView");
      }
      paramContext.setContentView(paramb);
      if (this.pMH) {
        break label694;
      }
      paramContext = this.oFW;
      if (paramContext == null) {
        p.bGy("rootView");
      }
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break label663;
      }
      paramContext = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(139709);
      throw paramContext;
      if (paramb == null) {
        p.iCn();
      }
      paramContext = (Dialog)new com.google.android.material.bottomsheet.a(paramb);
      break;
      paramj = this.mContext;
      if (paramj == null) {
        p.iCn();
      }
      paramb.setImageDrawable(androidx.core.content.a.m(paramj, a.a.actionbar_icon_dark_close));
      break label387;
    }
    label663:
    this.pMC = BottomSheetBehavior.cg((View)paramContext);
    paramContext = this.pMC;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.D(this.pMB);
    label694:
    paramContext = this.pMz;
    if (paramContext == null) {
      p.bGy("mBottomSheetDialog");
    }
    paramContext.setOnCancelListener((DialogInterface.OnCancelListener)new f(this));
    paramContext = this.pMz;
    if (paramContext == null) {
      p.bGy("mBottomSheetDialog");
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new g.g(this));
    paramContext = this.pMz;
    if (paramContext == null) {
      p.bGy("mBottomSheetDialog");
    }
    paramContext.setCancelable(false);
    this.cJG.getRuntime().a(4, -1, (am)this.pMN);
    AppMethodBeat.o(139709);
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(139708);
    if (((g)this).pMz != null)
    {
      Object localObject;
      if (this.pMC != null)
      {
        localObject = this.pMC;
        if (localObject == null) {
          p.iCn();
        }
        ((BottomSheetBehavior)localObject).bd(true);
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
          localObject = this.pMz;
          if (localObject == null) {
            p.bGy("mBottomSheetDialog");
          }
          ((Dialog)localObject).dismiss();
        }
      }
    }
    this.cJG.getRuntime().a((am)this.pMN);
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
      p.j(localObject, "(mContext as Activity).window");
      localObject = ((Window)localObject).getWindowManager();
      p.j(localObject, "(mContext as Activity).window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.j(localObject, "(mContext as Activity).w…dowManager.defaultDisplay");
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
      p.iCn();
    }
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "mContext!!.resources");
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
    if (((g)this).pMz != null)
    {
      Dialog localDialog = this.pMz;
      if (localDialog == null) {
        p.bGy("mBottomSheetDialog");
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
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(139707);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(139707);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"})
  final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private final e Bw(int paramInt)
    {
      AppMethodBeat.i(139696);
      if (!((Collection)this.pMR.pMO.pNN).isEmpty()) {}
      for (int i = 1; (i != 0) && (paramInt <= this.pMR.pMO.pNN.size()); i = 0)
      {
        localObject = this.pMR.pMO.pNN.get(paramInt);
        p.j(localObject, "videoCastDeviceManager.r…tDevices[posSubFistTitle]");
        localObject = (e)localObject;
        AppMethodBeat.o(139696);
        return localObject;
      }
      if (!((Collection)this.pMR.pMO.pNN).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      label166:
      for (Object localObject = (e)this.pMR.pMO.pNM.get(paramInt - this.pMR.pMO.pNN.size() - 1);; localObject = (e)this.pMR.pMO.pNM.get(paramInt))
      {
        p.j(localObject, "if (videoCastDeviceManag…tTitle]\n                }");
        AppMethodBeat.o(139696);
        return localObject;
        i = 0;
        break;
      }
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(226096);
      p.k(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        paramViewGroup = LayoutInflater.from(g.a(this.pMR)).inflate(a.c.item_vido_cast_device, paramViewGroup, false);
        p.j(paramViewGroup, "itemView");
        paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
        AppMethodBeat.o(226096);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(g.a(this.pMR)).inflate(a.c.layout_video_cast_item_header, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
      AppMethodBeat.o(226096);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(226104);
      p.k(paramv, "viewHolder");
      switch (getItemViewType(paramInt))
      {
      default: 
        AppMethodBeat.o(226104);
        return;
      case 3: 
        localObject2 = (a)paramv;
        int i = paramInt - 1;
        ((a)localObject2).pMT.setOnClickListener((View.OnClickListener)new g.b.c(this, i, paramInt));
        e locale = Bw(i);
        Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "bindDeviceViewHolder: ".concat(String.valueOf(locale)));
        TextView localTextView = ((a)localObject2).pMS;
        paramv = locale.pMy.bMJ();
        if (paramv == null) {
          p.iCn();
        }
        localObject1 = paramv.oeA;
        p.j(localObject1, "device.mrDevice.dlnaDevice!!.friendlyName");
        paramv = (RecyclerView.v)localObject1;
        if (Util.isNullOrNil((String)localObject1))
        {
          paramv = locale.pMy.bMJ();
          if (paramv == null) {
            p.iCn();
          }
          paramv = paramv.oeC;
          p.j(paramv, "device.mrDevice.dlnaDevice!!.modeName");
        }
        localTextView.setText((CharSequence)paramv);
        if (!this.pMR.pMP)
        {
          ((a)localObject2).pMU.setVisibility(8);
          ((a)localObject2).pMV.setVisibility(8);
          ((a)localObject2).pMW.setVisibility(8);
          AppMethodBeat.o(226104);
          return;
        }
        if ((locale.jYF) && (locale.isSelected) && (!locale.pMx))
        {
          ((a)localObject2).pMU.setVisibility(0);
          ((a)localObject2).pMW.setVisibility(8);
          ((a)localObject2).pMV.setVisibility(8);
          AppMethodBeat.o(226104);
          return;
        }
        if ((!locale.jYF) && (locale.pMx) && (locale.isSelected))
        {
          ((a)localObject2).pMU.setVisibility(8);
          ((a)localObject2).pMW.setVisibility(8);
          ((a)localObject2).pMV.setVisibility(0);
          AppMethodBeat.o(226104);
          return;
        }
        if ((!locale.pMx) && (locale.isSelected) && (!locale.jYF))
        {
          ((a)localObject2).pMU.setVisibility(8);
          ((a)localObject2).pMW.setVisibility(8);
          ((a)localObject2).pMV.setVisibility(0);
          AppMethodBeat.o(226104);
          return;
        }
        if (!locale.isSelected)
        {
          ((a)localObject2).pMU.setVisibility(8);
          ((a)localObject2).pMW.setVisibility(8);
          ((a)localObject2).pMV.setVisibility(8);
        }
        AppMethodBeat.o(226104);
        return;
      case 1: 
        paramv = (b)paramv;
        paramv.progressBar.setVisibility(8);
        if (g.b(this.pMR))
        {
          paramv.pMY.setText((CharSequence)"最近连接");
          AppMethodBeat.o(226104);
          return;
        }
        paramv.pMY.setVisibility(8);
        AppMethodBeat.o(226104);
        return;
      }
      Object localObject1 = (b)paramv;
      Object localObject2 = ((b)localObject1).pMY;
      if (g.b(this.pMR)) {}
      for (paramv = (CharSequence)"其他设备";; paramv = (CharSequence)"可连接设备")
      {
        ((TextView)localObject2).setText(paramv);
        kotlin.c.b.bGx("progressBarHolder").schedule((TimerTask)new d(this, (b)localObject1), 10000L, 9223372036854775807L);
        break;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(139697);
      if (g.b(this.pMR)) {}
      for (int i = this.pMR.pMO.pNN.size() + this.pMR.pMO.pNM.size() + 2;; i = this.pMR.pMO.pNM.size() + this.pMR.pMO.pNN.size() + 1)
      {
        Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "item count = ".concat(String.valueOf(i)));
        AppMethodBeat.o(139697);
        return i;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(139694);
      if ((paramInt == 0) && (g.b(this.pMR)))
      {
        AppMethodBeat.o(139694);
        return 1;
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      if ((g.b(this.pMR)) && (paramInt == this.pMR.pMO.pNN.size() + 1))
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      AppMethodBeat.o(139694);
      return 3;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"})
    @SuppressLint({"ResourceType"})
    public final class a
      extends RecyclerView.v
    {
      TextView pMS;
      FrameLayout pMT;
      ProgressBar pMU;
      ImageView pMV;
      TextView pMW;
      
      public a()
      {
        super();
        AppMethodBeat.i(139688);
        this$1 = localObject.findViewById(a.b.tv_device_name);
        p.j(g.b.this, "itemView.findViewById(R.id.tv_device_name)");
        this.pMS = ((TextView)g.b.this);
        this$1 = localObject.findViewById(a.b.fl_device_item);
        p.j(g.b.this, "itemView.findViewById(R.id.fl_device_item)");
        this.pMT = ((FrameLayout)g.b.this);
        this$1 = localObject.findViewById(a.b.pb_device_connecting);
        p.j(g.b.this, "itemView.findViewById(R.id.pb_device_connecting)");
        this.pMU = ((ProgressBar)g.b.this);
        this$1 = localObject.findViewById(a.b.iv_connected);
        p.j(g.b.this, "itemView.findViewById(R.id.iv_connected)");
        this.pMV = ((ImageView)g.b.this);
        this$1 = localObject.findViewById(a.b.tv_cast_fail);
        p.j(g.b.this, "itemView.findViewById(R.id.tv_cast_fail)");
        this.pMW = ((TextView)g.b.this);
        this.pMV.setImageResource(com.tencent.luggage.xweb_ext.a.d.cast_successful);
        AppMethodBeat.o(139688);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"})
    public final class b
      extends RecyclerView.v
    {
      TextView pMY;
      ProgressBar progressBar;
      
      public b()
      {
        super();
        AppMethodBeat.i(139689);
        this$1 = localObject.findViewById(a.b.tv_select_device_title);
        p.j(g.b.this, "itemView.findViewById(R.id.tv_select_device_title)");
        this.pMY = ((TextView)g.b.this);
        this$1 = localObject.findViewById(a.b.pb_device_search);
        p.j(g.b.this, "itemView.findViewById(R.id.pb_device_search)");
        this.progressBar = ((ProgressBar)g.b.this);
        AppMethodBeat.o(139689);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
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
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindSearchHeader$1$1"})
      static final class a
        implements Runnable
      {
        a(g.b.d paramd) {}
        
        public final void run()
        {
          AppMethodBeat.i(139691);
          this.pNb.pNa.progressBar.setVisibility(8);
          TextView localTextView = this.pNb.pNa.pMY;
          String str;
          if (g.b(this.pNb.pMX.pMR)) {
            str = "暂无其他设备";
          }
          for (;;)
          {
            localTextView.setText((CharSequence)str);
            AppMethodBeat.o(139691);
            return;
            if (this.pNb.pMX.pMR.pMO.pNM.isEmpty()) {
              str = "暂无可连接设备";
            } else {
              str = "可连接设备";
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class f
    implements DialogInterface.OnCancelListener
  {
    f(g paramg) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(161188);
      paramDialogInterface = g.c(this.pMR);
      if (paramDialogInterface != null) {
        paramDialogInterface.invoke(null, Integer.valueOf(0));
      }
      this.pMR.cJG.getRuntime().a((am)g.e(this.pMR));
      AppMethodBeat.o(161188);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.g
 * JD-Core Version:    0.7.0.1
 */