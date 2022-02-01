package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.report.q.z;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMiniWindowPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "isLiving", "", "()Z", "setLiving", "(Z)V", "miniWindowBtn", "Landroid/widget/RelativeLayout;", "canClearScreen", "miniWindow", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cr
  extends b
{
  private static final cr.a DmA;
  private final RelativeLayout DmB;
  private final com.tencent.mm.live.b.b nfT;
  boolean njA;
  
  static
  {
    AppMethodBeat.i(354507);
    DmA = new cr.a((byte)0);
    AppMethodBeat.o(354507);
  }
  
  public cr(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354476);
    this.nfT = paramb;
    paramViewGroup = paramViewGroup.findViewById(p.e.BXg);
    s.s(paramViewGroup, "root.findViewById(R.id.l…or_mini_window_btn_group)");
    this.DmB = ((RelativeLayout)paramViewGroup);
    this.DmB.setOnClickListener(new cr..ExternalSyntheticLambda0(this));
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
    AppMethodBeat.o(354476);
  }
  
  private static final void a(cr paramcr, View paramView)
  {
    AppMethodBeat.i(354494);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcr);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMiniWindowPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcr, "this$0");
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.e("Finder.FinderLiveVisitorMiniWindowPlugin", "showVideoTalking, permission denied");
      b.b.a(paramcr.nfT, b.c.ncz);
      RequestFloatWindowPermissionDialog.a(paramcr.mJe.getContext(), paramcr.mJe.getContext().getString(p.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new c(paramcr), false, com.tencent.mm.bq.a.aQB());
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveVisitorMiniWindowPlugin", "miniWindow click!");
      ce.a.a((ce)j.Dob, q.s.Duw);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMiniWindowPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354494);
      return;
      paramView = new Bundle();
      paramView.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
      paramView.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
      paramcr.nfT.statusChange(b.c.ncx, paramView);
      if (paramcr.nfT.getLiveRole() == 1)
      {
        paramcr = j.Dob;
        j.Doc.Dqr = true;
        paramcr = j.Dob;
        j.Doc.Dqs = false;
        j.Dob.a(q.c.Dri, String.valueOf(q.z.Dxy.type));
      }
      else if (paramcr.nfT.getLiveRole() == 0)
      {
        k.Doi.a(true, q.z.Dxy);
      }
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354529);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354529);
      return;
      tO(4);
      this.njA = false;
      AppMethodBeat.o(354529);
      return;
      ce.a.a((ce)j.Dob, q.t.DvG);
      this.njA = true;
      AppMethodBeat.o(354529);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMiniWindowPlugin$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements RequestFloatWindowPermissionDialog.a
  {
    c(cr paramcr) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(354243);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      if (this.DmC.njA)
      {
        if (cr.a(this.DmC).getLiveRole() == 1)
        {
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.n(this.DmC.getBuContext()))
          {
            paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.o(this.DmC.getBuContext())) {}
          }
          else
          {
            paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.e.a.mRf;
            com.tencent.mm.live.core.core.e.a.a.beN().mRB.mNF = true;
          }
        }
        for (;;)
        {
          paramRequestFloatWindowPermissionDialog = new Bundle();
          cr localcr = this.DmC;
          paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
          paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
          cr.a(localcr).statusChange(b.c.ncx, paramRequestFloatWindowPermissionDialog);
          if (cr.a(this.DmC).getLiveRole() != 1) {
            break;
          }
          paramRequestFloatWindowPermissionDialog = j.Dob;
          j.Doc.Dqr = true;
          paramRequestFloatWindowPermissionDialog = j.Dob;
          j.Doc.Dqs = false;
          j.Dob.a(q.c.Dri, String.valueOf(q.z.Dxy.type));
          AppMethodBeat.o(354243);
          return;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.mMo;
          b.a.bej().mRB.mNF = true;
          continue;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.f.a.mUf;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.f.a.a.hH(((f)this.DmC.business(f.class)).liveInfo.liveId);
          if (paramRequestFloatWindowPermissionDialog != null)
          {
            paramRequestFloatWindowPermissionDialog = paramRequestFloatWindowPermissionDialog.mRB;
            if (paramRequestFloatWindowPermissionDialog != null) {
              paramRequestFloatWindowPermissionDialog.mNF = true;
            }
          }
        }
        k.Doi.a(true, q.z.Dxy);
      }
      AppMethodBeat.o(354243);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(354250);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      b.b.a(cr.a(this.DmC), b.c.ncA);
      AppMethodBeat.o(354250);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(354258);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      b.b.a(cr.a(this.DmC), b.c.ncC);
      AppMethodBeat.o(354258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cr
 * JD-Core Version:    0.7.0.1
 */