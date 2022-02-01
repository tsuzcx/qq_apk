package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "", "filterPanelRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "UNCHOOSE_TAG", "tag", "tagContentTxtView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "gotoTagUI", "", "hasNextAction", "", "isReady", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "refreshTagInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final LinearLayout EuA;
  private final TextView EuB;
  private final String EuC;
  private final String TAG;
  private String tag;
  
  public bc(LinearLayout paramLinearLayout, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(361379);
    this.EuA = paramLinearLayout;
    this.CvU = parama;
    this.TAG = "Finder.FinderLiveTagWidget";
    this.EuB = ((TextView)this.EuA.findViewById(p.e.BSY));
    this.tag = "";
    paramLinearLayout = this.EuA.getContext().getString(p.h.CoQ);
    s.s(paramLinearLayout, "filterPanelRoot.context.…g.finder_live_not_choose)");
    this.EuC = paramLinearLayout;
    eBC();
    this.EuA.setClickable(true);
    AppMethodBeat.o(361379);
  }
  
  private static final void a(bc parambc, View paramView)
  {
    AppMethodBeat.i(361389);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parambc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambc, "this$0");
    parambc.sG(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361389);
  }
  
  public final void eBC()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(361412);
    Object localObject1 = ((e)this.CvU.business(e.class)).CFd;
    bno localbno;
    int i;
    if (localObject1 != null)
    {
      if (((LinkedList)localObject1).isEmpty())
      {
        this.EuA.setVisibility(8);
        AppMethodBeat.o(361412);
        return;
      }
      this.EuA.setVisibility(0);
      localObject1 = j.Dob;
      j.Doc.axB("");
      this.EuB.setText((CharSequence)this.EuA.getContext().getString(p.h.Ctd));
      localbno = ((e)this.CvU.business(e.class)).CFe;
      if (localbno != null)
      {
        localObject1 = (CharSequence)localbno.xms;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label352;
        }
        i = 1;
        if (i != 0) {
          break label448;
        }
        localObject1 = localbno.ZWk;
        if (localObject1 != null) {
          break label357;
        }
        localObject1 = null;
        label157:
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label365;
        }
        i = 1;
        label177:
        if (i != 0) {
          break label448;
        }
        TextView localTextView = this.EuB;
        localObject1 = localbno.ZWk;
        if ((localObject1 == null) || (((bno)localObject1).ZWl != 1)) {
          break label370;
        }
        i = 1;
        label207:
        if (i == 0) {
          break label383;
        }
        localObject3 = new StringBuilder().append(localbno.xms).append('-');
        localObject1 = localbno.ZWk;
        if (localObject1 != null) {
          break label375;
        }
        localObject1 = localObject2;
        label245:
        localObject2 = localObject1;
        localObject1 = j.Dob;
        localObject3 = j.Doc;
        localObject1 = localObject2;
        label266:
        ((q)localObject3).axB((String)localObject1);
        localTextView.setText((CharSequence)this.EuA.getContext().getString(p.h.Cte, new Object[] { localObject2 }));
      }
    }
    for (;;)
    {
      localObject1 = j.Dob;
      localObject3 = j.Doc;
      localObject2 = localbno.xms;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((q)localObject3).setTag((String)localObject1);
      this.EuA.setOnClickListener(new bc..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(361412);
      return;
      label352:
      i = 0;
      break;
      label357:
      localObject1 = ((bno)localObject1).xms;
      break label157;
      label365:
      i = 0;
      break label177;
      label370:
      i = 0;
      break label207;
      label375:
      localObject1 = ((bno)localObject1).xms;
      break label245;
      label383:
      localObject1 = localbno.ZWk;
      if (localObject1 == null) {}
      q localq;
      for (localObject1 = localObject3;; localObject1 = ((bno)localObject1).xms)
      {
        localObject2 = j.Dob;
        localq = j.Doc;
        if (localObject1 != null) {
          break label433;
        }
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localq;
        break;
      }
      label433:
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localq;
      break label266;
      label448:
      this.EuB.setText((CharSequence)this.EuA.getContext().getString(p.h.Ctd));
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(361431);
    if (((e)this.CvU.business(e.class)).CFe != null)
    {
      Object localObject = ((e)this.CvU.business(e.class)).CFe;
      if (localObject == null)
      {
        localObject = null;
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label86;
        }
      }
      label86:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label91;
        }
        AppMethodBeat.o(361431);
        return true;
        localObject = ((bno)localObject).xms;
        break;
      }
    }
    label91:
    AppMethodBeat.o(361431);
    return false;
  }
  
  public final void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(361424);
    Intent localIntent = new Intent();
    Object localObject1 = this.EuA.getContext();
    Object localObject2 = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass((Context)localObject1, com.tencent.mm.plugin.findersdk.e.a.fsu());
    localObject1 = ((e)this.CvU.business(e.class)).CFd;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof Serializable)) {
        break label193;
      }
    }
    label193:
    for (localObject1 = (Serializable)localObject1;; localObject1 = null)
    {
      localIntent.putExtra("KEY_TAG_INFO", (Serializable)localObject1);
      localIntent.putExtra("KEY_HAS_NEXT_ACTION", paramBoolean);
      localObject1 = this.EuA.getContext();
      if (localObject1 != null) {
        break label198;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(361424);
      throw ((Throwable)localObject1);
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((bno)((Iterator)localObject2).next()).toByteArray());
      }
      localObject1 = (List)localObject1;
      break;
    }
    label198:
    com.tencent.mm.hellhoundlib.a.a.a((Activity)localObject1, c.a(1003, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget", "gotoTagUI", "(Z)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(361424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bc
 * JD-Core Version:    0.7.0.1
 */