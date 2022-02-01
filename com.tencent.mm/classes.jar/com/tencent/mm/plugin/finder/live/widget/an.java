package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.protocal.protobuf.bda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "", "filterPanelRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "UNCHOOSE_TAG", "tag", "tagContentTxtView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "gotoTagUI", "", "hasNextAction", "", "isReady", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateLiveNote", "refreshTagInfo", "plugin-finder_release"})
public final class an
{
  private final String TAG;
  private String tag;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final TextView zrt;
  private final String zru;
  private final LinearLayout zrv;
  
  public an(LinearLayout paramLinearLayout, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(290589);
    this.zrv = paramLinearLayout;
    this.xYp = parama;
    this.TAG = "Finder.FinderLiveTagWidget";
    this.zrt = ((TextView)this.zrv.findViewById(b.f.finder_live_tag_text));
    this.tag = "";
    paramLinearLayout = this.zrv.getContext().getString(b.j.finder_live_not_choose);
    p.j(paramLinearLayout, "filterPanelRoot.context.…g.finder_live_not_choose)");
    this.zru = paramLinearLayout;
    dII();
    this.zrv.setClickable(true);
    AppMethodBeat.o(290589);
  }
  
  public final void dII()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(290586);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeF;
    bda localbda;
    int i;
    label168:
    label188:
    TextView localTextView;
    Object localObject4;
    if (localObject1 != null)
    {
      if (((LinkedList)localObject1).isEmpty())
      {
        this.zrv.setVisibility(8);
        AppMethodBeat.o(290586);
        return;
      }
      this.zrv.setVisibility(0);
      localObject1 = k.yBj;
      k.dDm().aCE("");
      localObject1 = this.zrt;
      p.j(localObject1, "tagContentTxtView");
      ((TextView)localObject1).setText((CharSequence)this.zrv.getContext().getString(b.j.finder_live_tag));
      localbda = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG;
      if (localbda != null)
      {
        localObject1 = (CharSequence)localbda.ugl;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label375;
        }
        i = 1;
        if (i != 0) {
          break label437;
        }
        localObject1 = localbda.SOk;
        if (localObject1 == null) {
          break label380;
        }
        localObject1 = ((bda)localObject1).ugl;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label385;
        }
        i = 1;
        if (i != 0) {
          break label437;
        }
        localTextView = this.zrt;
        p.j(localTextView, "tagContentTxtView");
        localObject1 = localbda.SOk;
        if ((localObject1 == null) || (((bda)localObject1).SOl != 1)) {
          break label390;
        }
        localObject3 = new StringBuilder().append(localbda.ugl).append('-');
        localObject4 = localbda.SOk;
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((bda)localObject4).ugl;
        }
        localObject2 = (String)localObject1;
        localObject1 = k.yBj;
        localObject3 = k.dDm();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      label286:
      ((s)localObject3).aCE((String)localObject1);
      localTextView.setText((CharSequence)this.zrv.getContext().getString(b.j.finder_live_tag_chosen, new Object[] { localObject2 }));
      for (;;)
      {
        localObject1 = k.yBj;
        localObject3 = k.dDm();
        localObject2 = localbda.ugl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((s)localObject3).setTag((String)localObject1);
        this.zrv.setOnClickListener((View.OnClickListener)new a(this));
        AppMethodBeat.o(290586);
        return;
        label375:
        i = 0;
        break;
        label380:
        localObject1 = null;
        break label168;
        label385:
        i = 0;
        break label188;
        label390:
        localObject2 = localbda.SOk;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((bda)localObject2).ugl;
        }
        localObject2 = k.yBj;
        localObject4 = k.dDm();
        if (localObject1 != null) {
          break label477;
        }
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        break label286;
        label437:
        localObject1 = this.zrt;
        p.j(localObject1, "tagContentTxtView");
        ((TextView)localObject1).setText((CharSequence)this.zrv.getContext().getString(b.j.finder_live_tag));
      }
      AppMethodBeat.o(290586);
      return;
      label477:
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(290588);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG != null)
    {
      Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeG;
      if (localObject != null)
      {
        localObject = ((bda)localObject).ugl;
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label84;
        }
      }
      label84:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label89;
        }
        AppMethodBeat.o(290588);
        return true;
        localObject = null;
        break;
      }
    }
    label89:
    AppMethodBeat.o(290588);
    return false;
  }
  
  public final void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(290587);
    Intent localIntent = new Intent();
    Object localObject1 = this.zrv.getContext();
    Object localObject2 = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass((Context)localObject1, com.tencent.mm.plugin.findersdk.e.a.enF());
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeF;
    if (localObject1 != null)
    {
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((bda)((Iterator)localObject2).next()).toByteArray());
      }
      localObject1 = (List)localObject1;
      if ((localObject1 instanceof Serializable)) {
        break label208;
      }
      localObject1 = null;
    }
    label208:
    for (;;)
    {
      localIntent.putExtra("KEY_TAG_INFO", (Serializable)localObject1);
      localIntent.putExtra("KEY_HAS_NEXT_ACTION", paramBoolean);
      localObject1 = this.zrv.getContext();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(290587);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
      }
      ((Activity)localObject1).startActivityForResult(localIntent, 1003);
      AppMethodBeat.o(290587);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$1$2"})
  static final class a
    implements View.OnClickListener
  {
    a(an paraman) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283966);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zrw.pM(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283966);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.an
 * JD-Core Version:    0.7.0.1
 */