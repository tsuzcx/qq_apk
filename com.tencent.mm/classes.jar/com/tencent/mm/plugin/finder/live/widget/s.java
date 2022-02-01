package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.view.w;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "gameTeamLayout", "Landroid/view/ViewGroup;", "gameTeamInfo", "Lcom/tencent/mm/protocal/protobuf/GameLiveJoinTeamSettingInfo;", "lastSelectValue", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/GameLiveJoinTeamSettingInfo;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "descTv", "Landroid/widget/TextView;", "getGameTeamInfo", "()Lcom/tencent/mm/protocal/protobuf/GameLiveJoinTeamSettingInfo;", "getGameTeamLayout", "()Landroid/view/ViewGroup;", "getLastSelectValue", "()I", "setLastSelectValue", "(I)V", "getLastSelectTeamIndex", "getLastSelectTeamInfo", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "getSelectValueForPost", "plugin-finder_release"})
public final class s
{
  final String TAG;
  final MMActivity activity;
  final TextView kEs;
  private final ViewGroup zoh;
  final bns zoi;
  public int zoj;
  
  public s(MMActivity paramMMActivity, ViewGroup paramViewGroup, bns parambns, int paramInt)
  {
    AppMethodBeat.i(274710);
    this.activity = paramMMActivity;
    this.zoh = paramViewGroup;
    this.zoi = parambns;
    this.zoj = paramInt;
    this.TAG = "Finder.FinderLiveGamePostTeamWidget";
    this.kEs = ((TextView)this.zoh.findViewById(b.f.game_team_condition_desc_tv));
    paramMMActivity = dIn();
    paramViewGroup = this.kEs;
    if (paramViewGroup != null)
    {
      if (paramMMActivity == null) {
        break label176;
      }
      paramMMActivity = paramMMActivity.tsf;
      if (paramMMActivity == null) {
        break label176;
      }
    }
    label176:
    for (paramMMActivity = (CharSequence)paramMMActivity;; paramMMActivity = (CharSequence)"")
    {
      paramViewGroup.setText(paramMMActivity);
      this.zoh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(279199);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          paramAnonymousView = o.ADA;
          if (o.ecW() == 18L)
          {
            paramAnonymousView = o.ADA;
            o.QJ(4);
          }
          paramAnonymousView = new w((kotlin.g.a.b)new a(this));
          localObject1 = this.zok.activity.getString(b.j.finder_game_live_team_condition_title);
          p.j(localObject1, "activity.getString(R.str…ive_team_condition_title)");
          Object localObject2 = this.zok.zoi.SYM;
          p.j(localObject2, "gameTeamInfo.qualifications_infos");
          localObject2 = (List)localObject2;
          s locals = this.zok;
          Object localObject3 = locals.zoi.SYM;
          p.j(localObject3, "gameTeamInfo.qualifications_infos");
          localObject3 = ((List)localObject3).iterator();
          int i = 0;
          int j;
          if (((Iterator)localObject3).hasNext()) {
            if (((cny)((Iterator)localObject3).next()).value == locals.zoj)
            {
              j = 1;
              label196:
              if (j == 0) {
                break label252;
              }
            }
          }
          for (;;)
          {
            paramAnonymousView.b((String)localObject1, (List)localObject2, i);
            paramAnonymousView.AZM = true;
            paramAnonymousView.fX((Context)this.zok.activity);
            a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(279199);
            return;
            j = 0;
            break label196;
            label252:
            i += 1;
            break;
            i = -1;
          }
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "invoke"})
        static final class a
          extends q
          implements kotlin.g.a.b<cny, x>
        {
          a(s.1 param1)
          {
            super();
          }
        }
      });
      Log.i(this.TAG, "init size:" + this.zoi.SYM.size() + ", last:" + this.zoj);
      AppMethodBeat.o(274710);
      return;
    }
  }
  
  private final cny dIn()
  {
    AppMethodBeat.i(274709);
    Object localObject = this.zoi.SYM;
    p.j(localObject, "gameTeamInfo.qualifications_infos");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((cny)localObject).value == this.zoj)
      {
        i = 1;
        label61:
        if (i == 0) {
          break label80;
        }
      }
    }
    for (;;)
    {
      localObject = (cny)localObject;
      AppMethodBeat.o(274709);
      return localObject;
      i = 0;
      break label61;
      label80:
      break;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.s
 * JD-Core Version:    0.7.0.1
 */