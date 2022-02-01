package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.cgi.e.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.j.a;
import com.tencent.mm.plugin.finder.live.report.q.ba;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.plugin.finder.view.aa;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "tv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "checkVisible", "", "getIndex", "", "value", "modeList", "", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "isVisible", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  final TextView ElR;
  final String TAG;
  public final ViewGroup mJe;
  final com.tencent.mm.live.b.b nfT;
  
  public h(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361026);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveAnchorGameTeamWidget";
    this.ElR = ((TextView)this.mJe.findViewById(p.e.BKU));
    this.mJe.setVisibility(8);
    AppMethodBeat.o(361026);
  }
  
  private static int C(int paramInt, List<? extends des> paramList)
  {
    AppMethodBeat.i(361035);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      if (((des)paramList.next()).value == paramInt) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(361035);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(361035);
    return -1;
  }
  
  private static final void a(h paramh, LinkedList paramLinkedList, final bha parambha, View paramView)
  {
    AppMethodBeat.i(361045);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramLinkedList);
    localb.cH(parambha);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramView = new aa((m)new a(paramh, parambha));
    localObject = paramh.mJe.getContext().getString(p.h.CgX);
    s.s(localObject, "root.context.getString(R…ive_team_condition_title)");
    paramView.c((String)localObject, (List)paramLinkedList, C(parambha.ZQz, (List)paramLinkedList));
    paramView.FyH = true;
    paramh = paramh.mJe.getContext();
    s.s(paramh, "root.context");
    paramView.hs(paramh);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361045);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(361068);
    bha localbha = ((e)this.CwG.getBuContext().business(e.class)).CFy;
    Object localObject1;
    if (localbha == null)
    {
      localObject1 = null;
      localObject3 = this.TAG;
      localObject4 = new StringBuilder("gamteam checkVisible gameInfo.show_teamup_button:");
      if (localbha != null) {
        break label196;
      }
      localObject2 = null;
      label57:
      localObject4 = ((StringBuilder)localObject4).append(localObject2).append(", modeList size:");
      if (localObject1 != null) {
        break label209;
      }
      localObject2 = null;
      label78:
      localObject4 = ((StringBuilder)localObject4).append(localObject2).append(", last:");
      if (localbha != null) {
        break label221;
      }
    }
    label196:
    label209:
    label221:
    for (Object localObject2 = null;; localObject2 = Integer.valueOf(localbha.ZQz))
    {
      Log.i((String)localObject3, localObject2);
      if ((localbha != null) && (localbha.ZQB == 1) && (localObject1 != null) && (((LinkedList)localObject1).size() > 0) && (localbha.ZQz != 1) && (localbha.ZQz != 0)) {
        break label234;
      }
      this.mJe.setVisibility(8);
      AppMethodBeat.o(361068);
      return;
      localObject1 = localbha.ZQy;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((cbr)localObject1).aakZ;
      break;
      localObject2 = Integer.valueOf(localbha.ZQB);
      break label57;
      localObject2 = Integer.valueOf(((LinkedList)localObject1).size());
      break label78;
    }
    label234:
    this.mJe.setVisibility(0);
    Object localObject4 = this.ElR;
    localObject2 = t.GgN;
    int j = localbha.ZQz;
    Context localContext = this.mJe.getContext();
    s.s(localContext, "root.context");
    Object localObject3 = ((Iterable)localObject1).iterator();
    int i;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      if (((des)localObject2).value == localbha.ZQz)
      {
        i = 1;
        label323:
        if (i == 0) {
          break label387;
        }
        label327:
        localObject2 = (des)localObject2;
        if (localObject2 != null) {
          break label395;
        }
        localObject2 = "";
      }
    }
    for (;;)
    {
      ((TextView)localObject4).setText((CharSequence)t.a(j, localContext, (String)localObject2));
      this.mJe.setOnClickListener(new h..ExternalSyntheticLambda0(this, (LinkedList)localObject1, localbha));
      AppMethodBeat.o(361068);
      return;
      i = 0;
      break label323;
      label387:
      break;
      localObject2 = null;
      break label327;
      label395:
      localObject3 = ((des)localObject2).lym;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "setValue", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<des, Integer, ah>
  {
    a(h paramh, bha parambha)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.h
 * JD-Core Version:    0.7.0.1
 */