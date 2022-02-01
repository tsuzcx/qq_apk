package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.view.aa;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "gameTeamLayout", "Landroid/view/ViewGroup;", "gameTeamInfo", "Lcom/tencent/mm/protocal/protobuf/GameLiveJoinTeamSettingInfo;", "lastSelectValue", "", "lastSelectCoinValue", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/GameLiveJoinTeamSettingInfo;II)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "<set-?>", "Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet;", "bottomSheet", "getBottomSheet", "()Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet;", "descTv", "Landroid/widget/TextView;", "getGameTeamInfo", "()Lcom/tencent/mm/protocal/protobuf/GameLiveJoinTeamSettingInfo;", "getGameTeamLayout", "()Landroid/view/ViewGroup;", "getLastSelectCoinValue", "()I", "setLastSelectCoinValue", "(I)V", "getLastSelectValue", "setLastSelectValue", "buildCoinTipText", "", "value", "getLastSelectTeamIndex", "getLastSelectTeamInfo", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "getSelectCoinSettingForPost", "Lcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;", "getSelectValueForPost", "updateTips", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  private final ViewGroup EqL;
  private final cbr EqM;
  public int EqN;
  int EqO;
  public aa EqP;
  final String TAG;
  private final MMActivity activity;
  private final TextView descTv;
  
  public ah(MMActivity paramMMActivity, ViewGroup paramViewGroup, cbr paramcbr, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(361606);
    this.activity = paramMMActivity;
    this.EqL = paramViewGroup;
    this.EqM = paramcbr;
    this.EqN = paramInt1;
    this.EqO = paramInt2;
    this.TAG = "Finder.FinderLiveGamePostTeamWidget";
    this.descTv = ((TextView)this.EqL.findViewById(p.e.BVp));
    eAS();
    this.EqL.setOnClickListener(new ah..ExternalSyntheticLambda0(this));
    Log.i(this.TAG, "init size:" + this.EqM.aakZ.size() + ", last:" + this.EqN);
    AppMethodBeat.o(361606);
  }
  
  private final CharSequence Qj(int paramInt)
  {
    AppMethodBeat.i(361633);
    Object localObject1 = (Context)this.activity;
    CharSequence localCharSequence1 = (CharSequence)this.activity.getString(p.h.Chm);
    CharSequence localCharSequence2 = (CharSequence)String.valueOf(paramInt);
    Object localObject2 = this.descTv;
    if (localObject2 == null) {}
    for (float f = 0.0F;; f = ((TextView)localObject2).getTextSize())
    {
      localObject2 = bb.m((Context)this.activity, p.g.coin_icon, this.activity.getResources().getColor(p.b.UN_Brand));
      ((Drawable)localObject2).setBounds(0, 0, com.tencent.mm.cd.a.bs((Context)this.activity, p.c.Edge_2A), com.tencent.mm.cd.a.bs((Context)this.activity, p.c.Edge_2A));
      kotlin.ah localah = kotlin.ah.aiuX;
      localObject1 = p.a((Context)localObject1, localCharSequence1, localCharSequence2, f, (Drawable)localObject2, false);
      kotlin.g.b.s.s(localObject1, "insertSpanIconAtMedium(\n… }, true, false\n        )");
      localObject1 = (CharSequence)localObject1;
      AppMethodBeat.o(361633);
      return localObject1;
    }
  }
  
  private static final void a(ah paramah, View paramView)
  {
    AppMethodBeat.i(361660);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramah);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    kotlin.g.b.s.u(paramah, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
    if (com.tencent.mm.plugin.finder.utils.s.feR() == 18L)
    {
      paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.TU(4);
    }
    paramah.EqP = new aa((m)new a(paramah));
    paramView = paramah.EqP;
    if (paramView != null)
    {
      localObject1 = paramah.activity.getString(p.h.CgX);
      kotlin.g.b.s.s(localObject1, "activity.getString(R.str…ive_team_condition_title)");
      localObject2 = paramah.EqM.aakZ;
      kotlin.g.b.s.s(localObject2, "gameTeamInfo.qualifications_infos");
      paramView.c((String)localObject1, (List)localObject2, paramah.eAU());
    }
    paramView = paramah.EqP;
    if (paramView != null) {
      paramView.FyH = true;
    }
    paramView = paramah.EqP;
    if (paramView != null) {
      paramView.hs((Context)paramah.activity);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361660);
  }
  
  private final void eAS()
  {
    AppMethodBeat.i(361618);
    TextView localTextView;
    Object localObject;
    if (this.EqN == 7)
    {
      localTextView = this.descTv;
      if (localTextView != null) {
        localObject = Qj(this.EqO);
      }
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      do
      {
        AppMethodBeat.o(361618);
        return;
        localTextView = this.descTv;
      } while (localTextView == null);
      localObject = eAT();
      if (localObject == null)
      {
        localObject = (CharSequence)"";
      }
      else
      {
        localObject = ((des)localObject).lym;
        if (localObject == null) {
          localObject = (CharSequence)"";
        } else {
          localObject = (CharSequence)localObject;
        }
      }
    }
  }
  
  private final des eAT()
  {
    AppMethodBeat.i(361643);
    Object localObject = this.EqM.aakZ;
    kotlin.g.b.s.s(localObject, "gameTeamInfo.qualifications_infos");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((des)localObject).value == this.EqN)
      {
        i = 1;
        label63:
        if (i == 0) {
          break label83;
        }
      }
    }
    for (;;)
    {
      localObject = (des)localObject;
      AppMethodBeat.o(361643);
      return localObject;
      i = 0;
      break label63;
      label83:
      break;
      localObject = null;
    }
  }
  
  private final int eAU()
  {
    AppMethodBeat.i(361647);
    Object localObject = this.EqM.aakZ;
    kotlin.g.b.s.s(localObject, "gameTeamInfo.qualifications_infos");
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (((des)((Iterator)localObject).next()).value == this.EqN) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(361647);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(361647);
    return -1;
  }
  
  public final cca eAV()
  {
    AppMethodBeat.i(361679);
    Object localObject = this.EqM.aakZ;
    kotlin.g.b.s.s(localObject, "gameTeamInfo.qualifications_infos");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((des)localObject).value == 7)
      {
        i = 1;
        label61:
        if (i == 0) {
          break label85;
        }
      }
    }
    for (;;)
    {
      localObject = (des)localObject;
      if (localObject != null) {
        break label92;
      }
      AppMethodBeat.o(361679);
      return null;
      i = 0;
      break label61;
      label85:
      break;
      localObject = null;
    }
    label92:
    localObject = ((des)localObject).ZGd;
    if (localObject == null)
    {
      AppMethodBeat.o(361679);
      return null;
    }
    ((cca)localObject).aalq = this.EqO;
    AppMethodBeat.o(361679);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "setValue", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<des, Integer, kotlin.ah>
  {
    a(ah paramah)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ah
 * JD-Core Version:    0.7.0.1
 */