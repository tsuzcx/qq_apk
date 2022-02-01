package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.model.cgi.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.aj.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.view.adapter.o;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFastCommentWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "bottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "canSendBtnEnable", "Lkotlin/Function1;", "", "", "getCanSendBtnEnable", "()Lkotlin/jvm/functions/Function1;", "cancelBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clickArea", "Landroid/view/View;", "commentList", "Landroidx/recyclerview/widget/RecyclerView;", "commentListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter;", "contentArea", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "isEdit", "okBtn", "root", "checkIfShowViolationMsg", "hide", "initContent", "initListener", "onClick", "v", "saveToCommSlice", "dataListCache", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "sendFastComment", "show", "showViolationsFailDialog", "errMsg", "unMount", "updateContent", "dataList", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends p
  implements View.OnClickListener
{
  public static final a Eqo;
  private boolean Ake;
  private com.tencent.mm.plugin.finder.view.d Bml;
  private final kotlin.g.a.b<Boolean, ah> DQT;
  private final TextView DlW;
  private final RecyclerView EnC;
  private final LiveBottomSheetPanel EoS;
  private o Eqp;
  public final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final View clickArea;
  private final View lBX;
  private final TextView pOq;
  
  static
  {
    AppMethodBeat.i(361790);
    Eqo = new a((byte)0);
    AppMethodBeat.o(361790);
  }
  
  public ad(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(361731);
    this.buContext = parama;
    parama = LayoutInflater.from(paramContext).inflate(p.f.CcN, (ViewGroup)this, true);
    s.s(parama, "from(context).inflate(R.…nt_widget_ui, this, true)");
    this.lBX = parama;
    this.clickArea = this.lBX.findViewById(p.e.BDV);
    this.EoS = ((LiveBottomSheetPanel)this.lBX.findViewById(p.e.BDX));
    this.pOq = ((TextView)this.EoS.findViewById(p.e.BDW));
    this.DlW = ((TextView)this.EoS.findViewById(p.e.BEa));
    this.EnC = ((RecyclerView)this.EoS.findViewById(p.e.BEb));
    this.Eqp = new o(paramContext);
    this.DQT = ((kotlin.g.a.b)new b(this));
    this.EoS.setOnVisibilityListener((kotlin.g.a.b)new c(this));
    paramContext = this.EnC;
    this.lBX.getContext();
    paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    parama = this.Eqp;
    kotlin.g.a.b localb = (kotlin.g.a.b)new d(this);
    s.u(localb, "callback");
    parama.DQT = localb;
    paramContext.setAdapter((RecyclerView.a)this.Eqp);
    this.DlW.setEnabled(false);
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramContext = this.DlW;
    s.s(paramContext, "okBtn");
    com.tencent.mm.plugin.finder.live.utils.a.d(paramContext, false);
    this.clickArea.setOnClickListener((View.OnClickListener)this);
    this.EoS.setOnClickListener((View.OnClickListener)this);
    this.pOq.setOnClickListener((View.OnClickListener)this);
    this.DlW.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(361731);
  }
  
  private static final ah a(ad paramad, ArrayList paramArrayList, JSONObject paramJSONObject, b.a parama)
  {
    AppMethodBeat.i(361766);
    s.u(paramad, "this$0");
    s.u(paramArrayList, "$dataListCache");
    s.u(paramJSONObject, "$js");
    Object localObject = ((bjr)parama.ott).ZTg;
    s.s(localObject, "it.resp.ret_list");
    localObject = (aux)kotlin.a.p.oL((List)localObject);
    int i;
    int j;
    if (localObject == null)
    {
      localObject = null;
      if ((parama.errType != 0) || (parama.errCode != 0)) {
        break label260;
      }
      if (localObject == null) {
        break label168;
      }
      paramad.ayA((String)localObject);
      paramad = paramad.Eqp;
      paramad.pUj.clear();
      i = 0;
      j = paramad.DQQ - 1;
      if (j < 0) {}
    }
    for (;;)
    {
      paramad.pUj.add("");
      if (i == j)
      {
        paramad.bZE.notifyChanged();
        for (;;)
        {
          paramad = ah.aiuX;
          AppMethodBeat.o(361766);
          return paramad;
          localObject = ((aux)localObject).wZb;
          break;
          label168:
          paramad.aq(paramArrayList);
          paramJSONObject.put("anchor_status", "2");
          j.Dob.a(q.c.DrY, paramJSONObject.toString());
          if (paramad.Ake) {
            aa.db(paramad.lBX.getContext(), paramad.lBX.getContext().getString(p.h.ChG));
          }
          for (;;)
          {
            paramad.hide();
            break;
            aa.db(paramad.lBX.getContext(), paramad.lBX.getContext().getString(p.h.ChF));
          }
          label260:
          Log.i("FinderLivecommentListWidget", "errType = " + parama.errType + ", errCode = " + parama.errCode + ", errMsg = " + parama.errMsg);
          aa.dc(paramad.lBX.getContext(), paramad.lBX.getContext().getString(p.h.ChH));
        }
      }
      i += 1;
    }
  }
  
  private static final void a(ad paramad, com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(361775);
    s.u(paramad, "this$0");
    paramad.lBX.getContext();
    AppMethodBeat.o(361775);
  }
  
  private final void ap(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(361742);
    this.Eqp.h(paramArrayList, paramArrayList.size());
    if (this.Eqp.getItemCount() <= 0)
    {
      this.EnC.setVisibility(8);
      AppMethodBeat.o(361742);
      return;
    }
    this.EnC.setVisibility(0);
    this.Eqp.bZE.notifyChanged();
    AppMethodBeat.o(361742);
  }
  
  private void aq(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(361752);
    s.u(paramArrayList, "dataListCache");
    ((e)this.buContext.business(e.class)).EdT.clear();
    List localList = ((e)this.buContext.business(e.class)).EdT;
    bmw localbmw = new bmw();
    localbmw.YVU.addAll((Collection)paramArrayList);
    paramArrayList = ah.aiuX;
    localList.add(localbmw);
    AppMethodBeat.o(361752);
  }
  
  public final void ayA(String paramString)
  {
    AppMethodBeat.i(361862);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramString, this));
    AppMethodBeat.o(361862);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getBuContext()
  {
    return this.buContext;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getCanSendBtnEnable()
  {
    return this.DQT;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(361854);
    com.tencent.mm.plugin.finder.view.d locald = this.Bml;
    if (locald != null) {
      locald.cyW();
    }
    this.Bml = null;
    this.EoS.setTranslationY(0.0F);
    AppMethodBeat.o(361854);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361846);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFastCommentWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BDV;
      if (paramView != null) {
        break label103;
      }
      label53:
      i = p.e.BDW;
      if (paramView != null) {
        break label118;
      }
      label61:
      i = p.e.BEa;
      if (paramView != null) {
        break label133;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFastCommentWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361846);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label103:
      if (paramView.intValue() != i) {
        break label53;
      }
      hide();
      continue;
      label118:
      if (paramView.intValue() != i) {
        break label61;
      }
      hide();
      continue;
      label133:
      if (paramView.intValue() == i)
      {
        localObject1 = new JSONObject();
        paramView = new ArrayList();
        Object localObject2 = ((Iterable)this.Eqp.pUj).iterator();
        label228:
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (((CharSequence)str).length() > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label228;
            }
            paramView.add(str);
            break;
          }
        }
        localObject2 = aj.CKd;
        localObject2 = aj.a.ah(paramView);
        if (!((e)this.buContext.business(e.class)).isLiveStarted()) {
          break label336;
        }
        new aj(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, 1, (auw)localObject2).bFJ().g(new ad..ExternalSyntheticLambda0(this, paramView, (JSONObject)localObject1)).a(new ad..ExternalSyntheticLambda1(this));
      }
    }
    label336:
    ((JSONObject)localObject1).put("anchor_status", "1");
    aq(paramView);
    j.Dob.a(q.c.DrY, ((JSONObject)localObject1).toString());
    localObject1 = (e)this.buContext.business(e.class);
    s.u(paramView, "<set-?>");
    ((e)localObject1).EdV = paramView;
    if (this.Ake) {
      aa.db(this.lBX.getContext(), this.lBX.getContext().getString(p.h.ChG));
    }
    for (;;)
    {
      hide();
      break;
      aa.db(this.lBX.getContext(), this.lBX.getContext().getString(p.h.ChF));
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(361826);
    Object localObject2 = ((e)this.buContext.business(e.class)).EdT;
    Object localObject1 = new ArrayList();
    localObject2 = (bmw)kotlin.a.p.oL((List)localObject2);
    if (localObject2 != null)
    {
      ((ArrayList)localObject1).addAll((Collection)((bmw)localObject2).YVU);
      if (((ArrayList)localObject1).isEmpty()) {
        break label161;
      }
    }
    label161:
    for (this.Ake = true;; this.Ake = false)
    {
      ap((ArrayList)localObject1);
      localObject1 = new com.tencent.mm.plugin.finder.view.d(this.lBX.getContext());
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg(this.lBX);
      ((com.tencent.mm.plugin.finder.view.d)localObject1).a(this.lBX, new FrameLayout.LayoutParams(-1, -1));
      ((com.tencent.mm.plugin.finder.view.d)localObject1).fkh();
      ((com.tencent.mm.plugin.finder.view.d)localObject1).dDn();
      localObject2 = ah.aiuX;
      this.Bml = ((com.tencent.mm.plugin.finder.view.d)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        localObject1 = g.ElM;
        g.a.report("4");
      }
      AppMethodBeat.o(361826);
      return;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(361833);
    super.unMount();
    hide();
    this.EoS.setOnVisibilityListener(null);
    AppMethodBeat.o(361833);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFastCommentWidget$Companion;", "", "()V", "LOAD_MORE_THRESHOLD", "", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "canSend", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(ad paramad)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "show", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(ad paramad)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "canSend", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(ad paramad)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(String paramString, ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ad
 * JD-Core Version:    0.7.0.1
 */