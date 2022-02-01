package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "onBackPress", "onSwipeBack", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends a
{
  private Context context;
  private final b nfT;
  private boolean njA;
  private final ImageView njB;
  private final RelativeLayout njC;
  
  public v(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247194);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_minimiza_icon_btn);
    s.s(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.njB = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(b.e.live_minimiza_icon_btn_click_area);
    s.s(paramViewGroup, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.njC = ((RelativeLayout)paramViewGroup);
    tO(4);
    this.njB.setImageDrawable(bb.e(this.context.getResources().getDrawable(b.g.icons_outlined_mini_window), -1));
    this.njC.setOnClickListener(new v..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(247194);
  }
  
  private static final void a(v paramv, View paramView)
  {
    AppMethodBeat.i(247209);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveMinimizePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "this$0");
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
      b.b.a(paramv.nfT, b.c.ncz);
      RequestFloatWindowPermissionDialog.a(paramv.context, paramv.context.getString(b.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new a(paramv), false, com.tencent.mm.bq.a.aQB());
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveMinimizePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247209);
      return;
      paramView = new Bundle();
      paramView.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
      paramView.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
      paramv.nfT.statusChange(b.c.ncx, paramView);
    }
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247252);
    if (this.nfT.isLiving())
    {
      this.njC.performClick();
      AppMethodBeat.o(247252);
      return true;
    }
    AppMethodBeat.o(247252);
    return false;
  }
  
  public final boolean onSwipeBack()
  {
    AppMethodBeat.i(247257);
    if (this.nfT.isLiving())
    {
      this.njC.performClick();
      AppMethodBeat.o(247257);
      return true;
    }
    AppMethodBeat.o(247257);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247243);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247243);
      return;
      tO(4);
      this.njA = false;
      AppMethodBeat.o(247243);
      return;
      tO(0);
      this.njA = true;
      AppMethodBeat.o(247243);
      return;
      if (this.nfT.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
        while (i != 0)
        {
          tO(4);
          AppMethodBeat.o(247243);
          return;
          i = 0;
        }
        tO(0);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveMinimizePlugin$1$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements RequestFloatWindowPermissionDialog.a
  {
    a(v paramv) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(247477);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      if (v.a(this.njD))
      {
        if (v.b(this.njD).getLiveRole() != 1) {
          break label102;
        }
        paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.mMo;
      }
      for (b.a.bej().mRB.mNF = true;; d.a.bfM().mRB.mNF = true)
      {
        paramRequestFloatWindowPermissionDialog = new Bundle();
        v localv = this.njD;
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
        paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
        v.b(localv).statusChange(b.c.ncx, paramRequestFloatWindowPermissionDialog);
        AppMethodBeat.o(247477);
        return;
        label102:
        paramRequestFloatWindowPermissionDialog = d.mUj;
      }
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(247482);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      b.b.a(v.b(this.njD), b.c.ncA);
      AppMethodBeat.o(247482);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(247487);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      b.b.a(v.b(this.njD), b.c.ncC);
      AppMethodBeat.o(247487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.v
 * JD-Core Version:    0.7.0.1
 */