package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameWelfareTaskProgressItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "icon", "Landroid/widget/ImageView;", "progress", "Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;", "progressGroup", "Landroid/widget/RelativeLayout;", "text", "Landroid/widget/TextView;", "render", "", "task", "Lcom/tencent/mm/protocal/protobuf/GameWelfareTaskInfo;", "transHtml", "", "wording", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGameWelfareTaskProgressItemView
  extends LinearLayout
{
  public static final FinderLiveGameWelfareTaskProgressItemView.a DNp;
  private final RelativeLayout DNq;
  private final RoundProgressBtn DNr;
  private final ImageView dpM;
  private final TextView wdg;
  
  static
  {
    AppMethodBeat.i(357893);
    DNp = new FinderLiveGameWelfareTaskProgressItemView.a((byte)0);
    AppMethodBeat.o(357893);
  }
  
  public FinderLiveGameWelfareTaskProgressItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357873);
    paramContext = LinearLayout.inflate(paramContext, p.f.CdR, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(p.e.BVn);
    s.s(paramAttributeSet, "parent.findViewById(R.id…ask_progress_round_group)");
    this.DNq = ((RelativeLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(p.e.BVm);
    s.s(paramAttributeSet, "parent.findViewById(R.id.game_task_progress_round)");
    this.DNr = ((RoundProgressBtn)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(p.e.BVl);
    s.s(paramAttributeSet, "parent.findViewById(R.id.game_task_progress_iv)");
    this.dpM = ((ImageView)paramAttributeSet);
    paramContext = paramContext.findViewById(p.e.BVo);
    s.s(paramContext, "parent.findViewById(R.id.game_task_progress_tv)");
    this.wdg = ((TextView)paramContext);
    AppMethodBeat.o(357873);
  }
  
  private static final void a(FinderLiveGameWelfareTaskProgressItemView paramFinderLiveGameWelfareTaskProgressItemView, String paramString)
  {
    AppMethodBeat.i(357886);
    s.u(paramFinderLiveGameWelfareTaskProgressItemView, "this$0");
    paramFinderLiveGameWelfareTaskProgressItemView = paramFinderLiveGameWelfareTaskProgressItemView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("forceHideShare", true);
    paramString = ah.aiuX;
    com.tencent.mm.br.c.b(paramFinderLiveGameWelfareTaskProgressItemView, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(357886);
  }
  
  public final void a(ccg paramccg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(357914);
    s.u(paramccg, "task");
    Object localObject1 = paramccg.aalH;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label238;
      }
      i = 1;
      label45:
      if (i != 0)
      {
        localObject1 = paramccg.aalH;
        if ((localObject1 == null) || (((ccc)localObject1).akkT != true)) {
          break label243;
        }
        i = 1;
        label68:
        if (i == 0) {
          break label331;
        }
      }
      localObject1 = paramccg.aalH;
      if ((localObject1 == null) || (((ccc)localObject1).akkT != true)) {
        break label248;
      }
      i = 1;
      label91:
      if (i == 0) {
        break label253;
      }
      this.dpM.setImageResource(p.d.HHA);
      this.DNq.setVisibility(0);
      if (!paramccg.aalI) {
        break label319;
      }
      this.DNr.setVisibility(0);
      this.DNr.setProgressColor(Color.parseColor(paramccg.aalK));
      this.DNr.setProgress(paramccg.aalJ);
      label153:
      localObject2 = this.wdg;
      localObject1 = paramccg.aalL;
      paramccg = (ccg)localObject1;
      if (localObject1 == null) {
        paramccg = "";
      }
      Log.i("FinderLiveGameWelfareTaskProgressItemView", s.X("#getLicenseText wording=", paramccg));
      if (((CharSequence)paramccg).length() != 0) {
        break label343;
      }
      i = 1;
      label198:
      if (i == 0) {
        break label348;
      }
      paramccg = (CharSequence)new SpannableString((CharSequence)"");
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramccg);
      AppMethodBeat.o(357914);
      return;
      localObject1 = ((ccc)localObject1).DUR;
      break;
      label238:
      i = 0;
      break label45;
      label243:
      i = 0;
      break label68;
      label248:
      i = 0;
      break label91;
      label253:
      localObject1 = p.ExI;
      d locald = p.eCl();
      localObject1 = paramccg.aalH;
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((ccc)localObject1).DUR)
      {
        localObject1 = new b((String)localObject1);
        localObject2 = this.dpM;
        p localp = p.ExI;
        locald.a(localObject1, (ImageView)localObject2, p.a(p.a.ExS));
        break;
      }
      label319:
      this.DNr.setVisibility(8);
      break label153;
      label331:
      this.DNq.setVisibility(8);
      break label153;
      label343:
      i = 0;
      break label198;
      label348:
      paramccg = com.tencent.mm.plugin.appbrand.utils.html.c.a(paramccg, false, new FinderLiveGameWelfareTaskProgressItemView..ExternalSyntheticLambda0(this));
      s.s(paramccg, "fromHtmlToSpanned(wordin…             })\n        }");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGameWelfareTaskProgressItemView
 * JD-Core Version:    0.7.0.1
 */