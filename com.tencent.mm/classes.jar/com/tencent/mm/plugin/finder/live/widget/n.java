package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI7;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.axk;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "", "filterPanelRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "TAG", "", "UNCHOOSE_TAG", "tag", "tagContentTxtView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "gotoTagUI", "", "hasNextAction", "", "isReady", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateLiveNote", "refreshTagInfo", "Companion", "plugin-finder_release"})
public final class n
{
  public static final int uHx = 1;
  public static final a uHy;
  private final String TAG;
  private final g liveData;
  private String tag;
  private final TextView uHu;
  private final String uHv;
  private final LinearLayout uHw;
  
  static
  {
    AppMethodBeat.i(248154);
    uHy = new a((byte)0);
    uHx = 1;
    AppMethodBeat.o(248154);
  }
  
  public n(LinearLayout paramLinearLayout, g paramg)
  {
    AppMethodBeat.i(248153);
    this.uHw = paramLinearLayout;
    this.liveData = paramg;
    this.TAG = "Finder.FinderLiveTagWidget";
    this.uHu = ((TextView)this.uHw.findViewById(2131301289));
    this.tag = "";
    paramLinearLayout = this.uHw.getContext().getString(2131760129);
    p.g(paramLinearLayout, "filterPanelRoot.context.…g.finder_live_not_choose)");
    this.uHv = paramLinearLayout;
    djO();
    this.uHw.setClickable(true);
    AppMethodBeat.o(248153);
  }
  
  public final void djO()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(248150);
    Object localObject1 = this.liveData.uiw;
    Object localObject4;
    int i;
    label151:
    label171:
    TextView localTextView;
    if (localObject1 != null)
    {
      if (((LinkedList)localObject1).isEmpty())
      {
        this.uHw.setVisibility(8);
        AppMethodBeat.o(248150);
        return;
      }
      this.uHw.setVisibility(0);
      localObject1 = k.vkd;
      k.dpl().auS("");
      localObject1 = this.uHu;
      p.g(localObject1, "tagContentTxtView");
      ((TextView)localObject1).setText((CharSequence)this.uHw.getContext().getString(2131760197));
      localObject4 = this.liveData.uix;
      if (localObject4 != null)
      {
        localObject1 = (CharSequence)((axk)localObject4).qHk;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label357;
        }
        i = 1;
        if (i != 0) {
          break label419;
        }
        localObject1 = ((axk)localObject4).LHU;
        if (localObject1 == null) {
          break label362;
        }
        localObject1 = ((axk)localObject1).qHk;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label367;
        }
        i = 1;
        if (i != 0) {
          break label419;
        }
        localTextView = this.uHu;
        p.g(localTextView, "tagContentTxtView");
        localObject1 = ((axk)localObject4).LHU;
        if ((localObject1 == null) || (((axk)localObject1).LHV != 1)) {
          break label372;
        }
        localObject3 = new StringBuilder().append(((axk)localObject4).qHk).append('-');
        localObject4 = ((axk)localObject4).LHU;
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((axk)localObject4).qHk;
        }
        localObject2 = (String)localObject1;
        localObject1 = k.vkd;
        localObject3 = k.dpl();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      label269:
      ((s)localObject3).auS((String)localObject1);
      localTextView.setText((CharSequence)this.uHw.getContext().getString(2131760198, new Object[] { localObject2 }));
      for (;;)
      {
        localObject1 = k.vkd;
        localObject1 = k.dpl();
        localObject2 = this.uHu;
        p.g(localObject2, "tagContentTxtView");
        ((s)localObject1).setTag(((TextView)localObject2).getText().toString());
        this.uHw.setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(248150);
        return;
        label357:
        i = 0;
        break;
        label362:
        localObject1 = null;
        break label151;
        label367:
        i = 0;
        break label171;
        label372:
        localObject2 = ((axk)localObject4).LHU;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((axk)localObject2).qHk;
        }
        localObject2 = k.vkd;
        localObject4 = k.dpl();
        if (localObject1 != null) {
          break label458;
        }
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        break label269;
        label419:
        localObject1 = this.uHu;
        p.g(localObject1, "tagContentTxtView");
        ((TextView)localObject1).setText((CharSequence)this.uHw.getContext().getString(2131760197));
      }
      AppMethodBeat.o(248150);
      return;
      label458:
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(248152);
    if (this.liveData.uix != null)
    {
      Object localObject = this.liveData.uix;
      if (localObject != null)
      {
        localObject = ((axk)localObject).qHk;
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label68;
        }
      }
      label68:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label73;
        }
        AppMethodBeat.o(248152);
        return true;
        localObject = null;
        break;
      }
    }
    label73:
    AppMethodBeat.o(248152);
    return false;
  }
  
  public final void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(248151);
    Intent localIntent = new Intent();
    localIntent.setClass(this.uHw.getContext(), OccupyFinderUI7.class);
    Object localObject1 = this.liveData.uiw;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((axk)((Iterator)localObject2).next()).toByteArray());
      }
      localObject1 = (List)localObject1;
      if ((localObject1 instanceof Serializable)) {
        break label192;
      }
      localObject1 = null;
    }
    label192:
    for (;;)
    {
      localIntent.putExtra("KEY_TAG_INFO", (Serializable)localObject1);
      localIntent.putExtra("KEY_HAS_NEXT_ACTION", paramBoolean);
      localObject1 = this.uHw.getContext();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(248151);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
      }
      ((Activity)localObject1).startActivityForResult(localIntent, uHx);
      AppMethodBeat.o(248151);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$Companion;", "", "()V", "REQUEST_CODE_SELECT_TAG", "", "getREQUEST_CODE_SELECT_TAG", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$1$2"})
  static final class b
    implements View.OnClickListener
  {
    b(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248149);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.uHz.nF(false);
      a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.n
 * JD-Core Version:    0.7.0.1
 */