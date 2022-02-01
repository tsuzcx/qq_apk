package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlaceHolderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlaceHolder;", "onClickRefresh", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "tabType", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;I)V", "autoPlayNextVideoTv", "Landroid/widget/TextView;", "curCountDown", "isCountDownFinish", "", "isUnselected", "mHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "mPos", "getTabType", "()I", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getLayoutId", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "reset", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends f<ad>
{
  private final i AIh;
  private final kotlin.g.a.b<Integer, ah> AKr;
  private TextView AKs;
  private com.tencent.mm.view.recyclerview.j AKt;
  private boolean AKu;
  boolean AKv;
  private final int hJx;
  int mPos;
  private int njK;
  private final MTimerHandler timerHandler;
  
  public ab(kotlin.g.a.b<? super Integer, ah> paramb, i parami, int paramInt)
  {
    AppMethodBeat.i(350119);
    this.AKr = paramb;
    this.AIh = parami;
    this.hJx = paramInt;
    this.njK = 3;
    this.timerHandler = new MTimerHandler(new ab..ExternalSyntheticLambda1(this), true);
    paramb = this.AIh.getActivity();
    if (paramb != null)
    {
      paramb = paramb.getContext();
      if (paramb != null)
      {
        parami = as.GSQ;
        paramb = as.a.hu((Context)paramb);
        if (paramb != null)
        {
          paramb = paramb.Vm(this.hJx);
          if (paramb != null) {
            paramb.a((d)new a(this));
          }
        }
      }
    }
    AppMethodBeat.o(350119);
  }
  
  private static final void a(ab paramab, View paramView)
  {
    AppMethodBeat.i(350132);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramab);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderFeedPlaceHolderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    paramab.reset();
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedPlaceHolderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350132);
  }
  
  private static final boolean a(ab paramab)
  {
    AppMethodBeat.i(350126);
    s.u(paramab, "this$0");
    if (paramab.njK > 0)
    {
      paramab.njK -= 1;
      TextView localTextView = paramab.AKs;
      if (localTextView != null) {
        localTextView.setText((CharSequence)MMApplicationContext.getContext().getString(e.h.finder_auto_play_next_video, new Object[] { Integer.valueOf(paramab.njK) }));
      }
      if (paramab.njK == 0) {
        paramab.reset();
      }
      AppMethodBeat.o(350126);
      return true;
    }
    AppMethodBeat.o(350126);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350150);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350150);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350153);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    reset();
    AppMethodBeat.o(350153);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_timeline_tips;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(350156);
    Object localObject = this.AKr;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(Integer.valueOf(this.mPos));
    }
    this.AKu = true;
    localObject = this.AKs;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.AKt = null;
    this.mPos = 0;
    this.timerHandler.stopTimer();
    AppMethodBeat.o(350156);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedPlaceHolderConvert$1$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "onEventHappen", "", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    a(ab paramab) {}
    
    private static final void a(com.tencent.mm.plugin.finder.event.base.b paramb, ab paramab)
    {
      AppMethodBeat.i(349760);
      s.u(paramb, "$ev");
      s.u(paramab, "this$0");
      if ((((com.tencent.mm.plugin.finder.event.base.j)paramb).pos != paramab.mPos) && (!paramab.AKv))
      {
        paramab.reset();
        paramab.AKv = true;
      }
      AppMethodBeat.o(349760);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(349788);
      s.u(paramb, "ev");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.j)) && (((com.tencent.mm.plugin.finder.event.base.j)paramb).type == 1)) {
        o.runOnUiThread(new ab.a..ExternalSyntheticLambda0(paramb, this.AKw));
      }
      AppMethodBeat.o(349788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ab
 * JD-Core Version:    0.7.0.1
 */