package com.tencent.mm.plugin.appbrand.jsapi.al.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.luggage.l.k;
import com.tencent.luggage.xweb_ext.a.a;
import com.tencent.luggage.xweb_ext.a.b;
import com.tencent.luggage.xweb_ext.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final g.a sRp;
  private final com.tencent.mm.plugin.appbrand.jsapi.al.e.b eDp;
  Context mContext;
  View mF;
  ViewTreeObserver mP;
  View rootView;
  boolean sRA;
  int sRB;
  m<? super c, ? super Integer, ah> sRC;
  private kotlin.g.a.a<ah> sRD;
  kotlin.g.a.b<? super Integer, ah> sRE;
  kotlin.g.a.a<ah> sRF;
  private final c sRG;
  final i sRq;
  final boolean sRr;
  Dialog sRs;
  b sRt;
  int sRu;
  BottomSheetBehavior<?> sRv;
  boolean sRw;
  int sRx;
  boolean sRy;
  boolean sRz;
  
  static
  {
    AppMethodBeat.i(139710);
    sRp = new g.a((byte)0);
    AppMethodBeat.o(139710);
  }
  
  private g(Context paramContext, com.tencent.mm.plugin.appbrand.jsapi.al.e.b paramb, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(139709);
    this.eDp = paramb;
    this.sRq = parami;
    this.sRr = paramBoolean;
    this.mContext = paramContext;
    this.sRz = true;
    this.sRA = true;
    this.sRE = ((kotlin.g.a.b)g.d.sRR);
    this.sRG = new c(this);
    if ((this.mContext instanceof Activity))
    {
      paramContext = this.mContext;
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(139709);
        throw paramContext;
      }
      this.mF = ((ViewGroup)((Activity)paramContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramb = this.mContext;
    if (this.sRA)
    {
      s.checkNotNull(paramb);
      paramContext = (Dialog)new com.tencent.mm.ui.widget.a.b(paramb);
      this.sRs = paramContext;
      paramContext = View.inflate(paramb, a.c.layout_video_cast_devices, null);
      s.s(paramContext, "inflate(context, R.layou…video_cast_devices, null)");
      this.rootView = paramContext;
      paramb = this.rootView;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("rootView");
        paramContext = null;
      }
      paramContext.findViewById(a.b.tv_help_click_area).setOnClickListener(new g..ExternalSyntheticLambda2(this));
      paramb = this.rootView;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("rootView");
        paramContext = null;
      }
      parami = (RecyclerView)paramContext.findViewById(a.b.bottom_sheet_menu_reccycleview);
      parami.setHasFixedSize(true);
      paramb = this.rootView;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("rootView");
        paramContext = null;
      }
      paramContext.findViewById(a.b.iv_close_bottom_sheet_click_area).setOnClickListener(new g..ExternalSyntheticLambda3(this));
      paramb = this.rootView;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("rootView");
        paramContext = null;
      }
      paramContext = (ImageView)paramContext.findViewById(a.b.iv_close_bottom_sheet);
      if (!k.exm.isDarkMode()) {
        break label595;
      }
      paramb = this.mContext;
      s.checkNotNull(paramb);
      paramContext.setImageDrawable(androidx.core.content.a.m(paramb, a.a.actionbar_icon_light_close));
      label363:
      this.sRw = isLandscape();
      i = bd.bs(this.mContext, com.tencent.mm.ck.a.d.bottomsheet_list_item_height);
      if (!this.sRw) {
        break label618;
      }
    }
    label595:
    label618:
    for (int i = (int)(i * 4.5D) + bd.bs(this.mContext, com.tencent.mm.ck.a.d.bottomsheet_dividing_line_height);; i = (int)(i * 6.5D) + bd.bs(this.mContext, com.tencent.mm.ck.a.d.bottomsheet_dividing_line_height))
    {
      this.sRu = i;
      parami.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      parami.setFocusable(false);
      this.sRt = new b();
      paramb = this.sRt;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("recycleViewAdapter");
        paramContext = null;
      }
      parami.setAdapter((RecyclerView.a)paramContext);
      parami.setOverScrollMode(1);
      paramb = this.sRs;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("mBottomSheetDialog");
        paramContext = null;
      }
      parami = this.rootView;
      paramb = parami;
      if (parami == null)
      {
        s.bIx("rootView");
        paramb = null;
      }
      paramContext.setContentView(paramb);
      if (this.sRA) {
        break label670;
      }
      paramb = this.rootView;
      paramContext = paramb;
      if (paramb == null)
      {
        s.bIx("rootView");
        paramContext = null;
      }
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break label642;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(139709);
      throw paramContext;
      s.checkNotNull(paramb);
      paramContext = (Dialog)new com.google.android.material.bottomsheet.a(paramb);
      break;
      paramb = this.mContext;
      s.checkNotNull(paramb);
      paramContext.setImageDrawable(androidx.core.content.a.m(paramb, a.a.actionbar_icon_dark_close));
      break label363;
    }
    label642:
    this.sRv = BottomSheetBehavior.cC((View)paramContext);
    paramContext = this.sRv;
    s.checkNotNull(paramContext);
    paramContext.setPeekHeight(this.sRu);
    label670:
    paramb = this.sRs;
    paramContext = paramb;
    if (paramb == null)
    {
      s.bIx("mBottomSheetDialog");
      paramContext = null;
    }
    paramContext.setOnCancelListener(new g..ExternalSyntheticLambda0(this));
    paramb = this.sRs;
    paramContext = paramb;
    if (paramb == null)
    {
      s.bIx("mBottomSheetDialog");
      paramContext = null;
    }
    paramContext.setOnDismissListener(new g..ExternalSyntheticLambda1(this));
    paramContext = this.sRs;
    if (paramContext == null)
    {
      s.bIx("mBottomSheetDialog");
      paramContext = localObject;
    }
    for (;;)
    {
      paramContext.setCancelable(false);
      this.eDp.getRuntime().a(4, -1, (ar)this.sRG);
      AppMethodBeat.o(139709);
      return;
    }
  }
  
  private static final void a(g paramg, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(327222);
    s.u(paramg, "this$0");
    paramDialogInterface = paramg.sRC;
    if (paramDialogInterface != null) {
      paramDialogInterface.invoke(null, Integer.valueOf(0));
    }
    paramg.eDp.getRuntime().a((ar)paramg.sRG);
    AppMethodBeat.o(327222);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(327210);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    if (paramg.sRF != null)
    {
      paramg = paramg.sRF;
      if (paramg != null) {
        paramg.invoke();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(327210);
  }
  
  private static final void b(g paramg, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(327225);
    s.u(paramg, "this$0");
    if (paramg.mP != null)
    {
      paramDialogInterface = paramg.mP;
      s.checkNotNull(paramDialogInterface);
      if (!paramDialogInterface.isAlive())
      {
        paramDialogInterface = paramg.mF;
        s.checkNotNull(paramDialogInterface);
        paramg.mP = paramDialogInterface.getViewTreeObserver();
      }
      paramDialogInterface = paramg.mP;
      s.checkNotNull(paramDialogInterface);
      paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)paramg);
      paramg.mP = null;
    }
    paramDialogInterface = paramg.sRE;
    int i = ((Collection)paramg.sRq.sSs).size();
    paramDialogInterface.invoke(Integer.valueOf(((Collection)paramg.sRq.sSr).size() + i));
    AppMethodBeat.o(327225);
  }
  
  private static final void b(g paramg, View paramView)
  {
    AppMethodBeat.i(327218);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramView = paramg.sRD;
    if (paramView != null) {
      paramView.invoke();
    }
    paramView = paramg.sRC;
    if (paramView != null) {
      paramView.invoke(null, Integer.valueOf(0));
    }
    paramg.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(327218);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(139708);
    if (this.sRs != null)
    {
      Object localObject;
      if (this.sRv != null)
      {
        localObject = this.sRv;
        s.checkNotNull(localObject);
        ((BottomSheetBehavior)localObject).dqC = true;
      }
      if (this.mContext != null)
      {
        localObject = this.mContext;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(139708);
          throw ((Throwable)localObject);
        }
        if (!((Activity)localObject).isFinishing())
        {
          Dialog localDialog = this.sRs;
          localObject = localDialog;
          if (localDialog == null)
          {
            s.bIx("mBottomSheetDialog");
            localObject = null;
          }
          ((Dialog)localObject).dismiss();
        }
      }
    }
    this.eDp.getRuntime().a((ar)this.sRG);
    AppMethodBeat.o(139708);
  }
  
  final int getRotation()
  {
    AppMethodBeat.i(139704);
    int i = 0;
    if ((this.mContext instanceof Activity))
    {
      Object localObject = this.mContext;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(139704);
        throw ((Throwable)localObject);
      }
      i = ((Activity)localObject).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(139704);
    return i;
  }
  
  final boolean isLandscape()
  {
    AppMethodBeat.i(139706);
    Context localContext = this.mContext;
    s.checkNotNull(localContext);
    if (localContext.getResources().getConfiguration().orientation == 2)
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
    if (this.sRs != null)
    {
      Dialog localDialog2 = this.sRs;
      Dialog localDialog1 = localDialog2;
      if (localDialog2 == null)
      {
        s.bIx("mBottomSheetDialog");
        localDialog1 = null;
      }
      if (localDialog1.isShowing())
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
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(139707);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(139707);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    public b()
    {
      AppMethodBeat.i(327191);
      AppMethodBeat.o(327191);
    }
    
    private final e BJ(int paramInt)
    {
      AppMethodBeat.i(139696);
      if (!((Collection)this.sRH.sRq.sSs).isEmpty()) {}
      for (int i = 1; (i != 0) && (paramInt <= this.sRH.sRq.sSs.size()); i = 0)
      {
        localObject = this.sRH.sRq.sSs.get(paramInt);
        s.s(localObject, "{\n                videoC…bFistTitle]\n            }");
        localObject = (e)localObject;
        AppMethodBeat.o(139696);
        return localObject;
      }
      if (!((Collection)this.sRH.sRq.sSs).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      label166:
      for (Object localObject = (e)this.sRH.sRq.sSr.get(paramInt - this.sRH.sRq.sSs.size() - 1);; localObject = (e)this.sRH.sRq.sSr.get(paramInt))
      {
        s.s(localObject, "{\n                if (vi…          }\n            }");
        AppMethodBeat.o(139696);
        return localObject;
        i = 0;
        break;
      }
    }
    
    private static final void a(g paramg, int paramInt1, b paramb, int paramInt2, View paramView)
    {
      AppMethodBeat.i(327201);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramg);
      localb.sc(paramInt1);
      localb.cH(paramb);
      localb.sc(paramInt2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramg, "this$0");
      s.u(paramb, "this$1");
      int i;
      if (g.c(paramg) != null)
      {
        if (((Collection)paramg.sRq.sSs).isEmpty()) {
          break label183;
        }
        i = 1;
        if ((i == 0) || (paramInt1 > paramg.sRq.sSs.size())) {
          break label189;
        }
        paramg = g.c(paramg);
        s.checkNotNull(paramg);
        paramg.invoke(paramb.BJ(paramInt1).sRn, Integer.valueOf(paramInt2));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(327201);
        return;
        label183:
        i = 0;
        break;
        label189:
        paramg = g.c(paramg);
        s.checkNotNull(paramg);
        paramg.invoke(paramb.BJ(paramInt1).sRn, Integer.valueOf(paramInt2));
      }
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(327213);
      s.u(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        paramViewGroup = LayoutInflater.from(g.a(this.sRH)).inflate(a.c.item_vido_cast_device, paramViewGroup, false);
        s.s(paramViewGroup, "itemView");
        paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
        AppMethodBeat.o(327213);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(g.a(this.sRH)).inflate(a.c.layout_video_cast_item_header, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
      AppMethodBeat.o(327213);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(327227);
      s.u(paramv, "viewHolder");
      switch (getItemViewType(paramInt))
      {
      default: 
        AppMethodBeat.o(327227);
        return;
      case 3: 
        localObject2 = (a)paramv;
        int i = paramInt - 1;
        ((a)localObject2).sRJ.setOnClickListener(new g.b..ExternalSyntheticLambda0(this.sRH, i, this, paramInt));
        e locale = BJ(i);
        Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", s.X("bindDeviceViewHolder: ", locale));
        TextView localTextView = ((a)localObject2).sRI;
        paramv = locale.sRn.cmY();
        s.checkNotNull(paramv);
        localObject1 = paramv.rif;
        s.s(localObject1, "device.mrDevice.dlnaDevice!!.friendlyName");
        paramv = (RecyclerView.v)localObject1;
        if (Util.isNullOrNil((String)localObject1))
        {
          paramv = locale.sRn.cmY();
          s.checkNotNull(paramv);
          paramv = paramv.rih;
          s.s(paramv, "device.mrDevice.dlnaDevice!!.modeName");
        }
        localTextView.setText((CharSequence)paramv);
        if (!this.sRH.sRr)
        {
          ((a)localObject2).sRK.setVisibility(8);
          ((a)localObject2).sRL.setVisibility(8);
          ((a)localObject2).sRM.setVisibility(8);
          AppMethodBeat.o(327227);
          return;
        }
        if ((locale.myA) && (locale.isSelected) && (!locale.sRo))
        {
          ((a)localObject2).sRK.setVisibility(0);
          ((a)localObject2).sRM.setVisibility(8);
          ((a)localObject2).sRL.setVisibility(8);
          AppMethodBeat.o(327227);
          return;
        }
        if ((!locale.myA) && (locale.sRo) && (locale.isSelected))
        {
          ((a)localObject2).sRK.setVisibility(8);
          ((a)localObject2).sRM.setVisibility(8);
          ((a)localObject2).sRL.setVisibility(0);
          AppMethodBeat.o(327227);
          return;
        }
        if ((!locale.sRo) && (locale.isSelected) && (!locale.myA))
        {
          ((a)localObject2).sRK.setVisibility(8);
          ((a)localObject2).sRM.setVisibility(8);
          ((a)localObject2).sRL.setVisibility(0);
          AppMethodBeat.o(327227);
          return;
        }
        if (!locale.isSelected)
        {
          ((a)localObject2).sRK.setVisibility(8);
          ((a)localObject2).sRM.setVisibility(8);
          ((a)localObject2).sRL.setVisibility(8);
        }
        AppMethodBeat.o(327227);
        return;
      case 1: 
        paramv = (b)paramv;
        paramv.progressBar.setVisibility(8);
        if (g.b(this.sRH))
        {
          paramv.sRO.setText((CharSequence)"最近连接");
          AppMethodBeat.o(327227);
          return;
        }
        paramv.sRO.setVisibility(8);
        AppMethodBeat.o(327227);
        return;
      }
      Object localObject1 = (b)paramv;
      Object localObject2 = ((b)localObject1).sRO;
      if (g.b(this.sRH)) {}
      for (paramv = (CharSequence)"其他设备";; paramv = (CharSequence)"可连接设备")
      {
        ((TextView)localObject2).setText(paramv);
        paramv = this.sRH;
        kotlin.c.b.bIw("progressBarHolder").schedule((TimerTask)new c((b)localObject1, paramv), 10000L, 9223372036854775807L);
        break;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(139697);
      if (g.b(this.sRH)) {}
      for (int i = this.sRH.sRq.sSs.size() + this.sRH.sRq.sSr.size() + 2;; i = this.sRH.sRq.sSr.size() + this.sRH.sRq.sSs.size() + 1)
      {
        Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", s.X("item count = ", Integer.valueOf(i)));
        AppMethodBeat.o(139697);
        return i;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(139694);
      if ((paramInt == 0) && (g.b(this.sRH)))
      {
        AppMethodBeat.o(139694);
        return 1;
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      if ((g.b(this.sRH)) && (paramInt == this.sRH.sRq.sSs.size() + 1))
      {
        AppMethodBeat.o(139694);
        return 2;
      }
      AppMethodBeat.o(139694);
      return 3;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      extends RecyclerView.v
    {
      TextView sRI;
      FrameLayout sRJ;
      ProgressBar sRK;
      ImageView sRL;
      TextView sRM;
      
      public a()
      {
        super();
        AppMethodBeat.i(139688);
        this$1 = localObject.findViewById(a.b.tv_device_name);
        s.s(g.b.this, "itemView.findViewById(R.id.tv_device_name)");
        this.sRI = ((TextView)g.b.this);
        this$1 = localObject.findViewById(a.b.fl_device_item);
        s.s(g.b.this, "itemView.findViewById(R.id.fl_device_item)");
        this.sRJ = ((FrameLayout)g.b.this);
        this$1 = localObject.findViewById(a.b.pb_device_connecting);
        s.s(g.b.this, "itemView.findViewById(R.id.pb_device_connecting)");
        this.sRK = ((ProgressBar)g.b.this);
        this$1 = localObject.findViewById(a.b.iv_connected);
        s.s(g.b.this, "itemView.findViewById(R.id.iv_connected)");
        this.sRL = ((ImageView)g.b.this);
        this$1 = localObject.findViewById(a.b.tv_cast_fail);
        s.s(g.b.this, "itemView.findViewById(R.id.tv_cast_fail)");
        this.sRM = ((TextView)g.b.this);
        this.sRL.setImageResource(com.tencent.luggage.xweb_ext.a.d.cast_successful);
        AppMethodBeat.o(139688);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class b
      extends RecyclerView.v
    {
      ProgressBar progressBar;
      TextView sRO;
      
      public b()
      {
        super();
        AppMethodBeat.i(139689);
        this$1 = localObject.findViewById(a.b.tv_select_device_title);
        s.s(g.b.this, "itemView.findViewById(R.id.tv_select_device_title)");
        this.sRO = ((TextView)g.b.this);
        this$1 = localObject.findViewById(a.b.pb_device_search);
        s.s(g.b.this, "itemView.findViewById(R.id.pb_device_search)");
        this.progressBar = ((ProgressBar)g.b.this);
        AppMethodBeat.o(139689);
      }
    }
    
    @Metadata(d1={""}, d2={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
    public static final class c
      extends TimerTask
    {
      public c(g.b.b paramb, g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(139692);
        MMHandlerThread.postToMainThread((Runnable)new g.b.d(this.sRP, paramv));
        AppMethodBeat.o(139692);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      implements Runnable
    {
      d(g.b.b paramb, g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(327228);
        this.sRQ.progressBar.setVisibility(8);
        TextView localTextView = this.sRQ.sRO;
        String str;
        if (g.b(this.sRH)) {
          str = "暂无其他设备";
        }
        for (;;)
        {
          localTextView.setText((CharSequence)str);
          AppMethodBeat.o(327228);
          return;
          if (this.sRH.sRq.sSr.isEmpty()) {
            str = "暂无可连接设备";
          } else {
            str = "可连接设备";
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ar
  {
    c(g paramg) {}
    
    public final boolean i(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139698);
      s.u(paramKeyEvent, "event");
      if (1 == paramKeyEvent.getAction())
      {
        AppMethodBeat.o(139698);
        return false;
      }
      paramKeyEvent = g.c(this.sRH);
      if (paramKeyEvent != null) {
        paramKeyEvent.invoke(null, Integer.valueOf(0));
      }
      this.sRH.cyW();
      AppMethodBeat.o(139698);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a.g
 * JD-Core Version:    0.7.0.1
 */