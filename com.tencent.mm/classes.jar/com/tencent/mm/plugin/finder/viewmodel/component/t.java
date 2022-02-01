package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.ui.FinderFloatBallDetailUI;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.megavideo.floatball.a.a;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFloatMiniViewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "videoFloatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "addVideoFloatBall", "", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isFromHorizontal", "", "Companion", "plugin-finder_release"})
public final class t
  extends UIComponent
{
  public static final a Bke;
  private cwl zxK;
  
  static
  {
    AppMethodBeat.i(271702);
    Bke = new a((byte)0);
    AppMethodBeat.o(271702);
  }
  
  public t(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(271701);
    paramAppCompatActivity = new cwl();
    n localn = n.zWF;
    paramAppCompatActivity.key = n.dPD();
    this.zxK = paramAppCompatActivity;
    AppMethodBeat.o(271701);
  }
  
  public final void a(bs parambs, RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(271699);
    p.k(parambs, "item");
    p.k(paramRecyclerView, "recyclerView");
    Log.i("FinderFloatMiniViewUIC", "addVideoFloatBall: id = " + parambs.mf());
    Object localObject1 = am.zZN;
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)getActivity());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((aj)localObject1).ekY();
      if (!paramBoolean) {
        break label201;
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("ref_eid", "transpose_video_card");
    }
    for (;;)
    {
      am.a((bid)localObject1, "add_pictureinpicture", 1, (JSONObject)localObject2);
      if ((!com.tencent.mm.q.a.p((Context)getContext(), true)) && (!com.tencent.mm.q.a.r((Context)getContext(), true)) && (!com.tencent.mm.q.a.cB((Context)getContext())) && (!com.tencent.mm.q.a.cA((Context)getContext()))) {
        break label207;
      }
      Log.w("FinderFloatMiniViewUIC", "addVideoFloatBall: failed to add video float ball, id = " + parambs.mf());
      AppMethodBeat.o(271699);
      return;
      localObject1 = null;
      break;
      label201:
      localObject2 = null;
    }
    label207:
    if (com.tencent.mm.q.a.q(null, false))
    {
      localObject1 = ah.yhC;
      ah.dzx();
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (!b.ct((Context)getContext()))
      {
        Log.w("FinderFloatMiniViewUIC", "addVideoFloatBall: showVideoTalking, permission denied");
        RequestFloatWindowPermissionDialog.a((Context)getContext(), getContext().getString(b.j.mega_video_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new b(), false, com.tencent.mm.bx.a.awc());
        AppMethodBeat.o(271699);
        return;
      }
      localObject2 = paramRecyclerView.getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof LinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 != null)
      {
        int j = ((LinearLayoutManager)localObject1).kJ();
        localObject1 = paramRecyclerView.cJ(j);
        paramRecyclerView = (RecyclerView)localObject1;
        if (!(localObject1 instanceof i)) {
          paramRecyclerView = null;
        }
        paramRecyclerView = (i)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          localObject1 = (FinderVideoLayout)paramRecyclerView.RD(b.f.finder_banner_video_layout);
          if (localObject1 != null) {
            i = ((FinderVideoLayout)localObject1).getCurrentPosSec();
          }
          Log.i("FinderFloatMiniViewUIC", "addVideoFloatBall: videoCurrPlayTimes = ".concat(String.valueOf(i)));
          localObject1 = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
          localObject1 = a.a.dJH();
          this.zxK.TFi = i;
          this.zxK.TFg.clear();
          this.zxK.TFk.clear();
          this.zxK.TFk.add(parambs.getFeedObject());
          ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject1).n("KEY_VIDEO_FLOAT_BALL_INFO", this.zxK.toByteArray());
          ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject1).a(paramRecyclerView, paramBoolean, parambs.mf(), parambs.dKW());
          if ((getContext() instanceof FinderFloatBallDetailUI)) {
            getContext().finish();
          }
          AppMethodBeat.o(271699);
          return;
        }
        Log.e("FinderFloatMiniViewUIC", "addVideoFloatBall: holder is null, pos = ".concat(String.valueOf(j)));
        AppMethodBeat.o(271699);
        return;
      }
      Log.e("FinderFloatMiniViewUIC", "addVideoFloatBall: layout manager is not linear layout manager");
      AppMethodBeat.o(271699);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFloatMiniViewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFloatMiniViewUIC$addVideoFloatBall$2", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
  public static final class b
    implements RequestFloatWindowPermissionDialog.a
  {
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(275944);
      p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(275944);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(275945);
      p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(275945);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(275946);
      p.k(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(275946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.t
 * JD-Core Version:    0.7.0.1
 */