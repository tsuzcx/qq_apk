package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.component.a.a;
import com.tencent.mm.plugin.finder.live.component.a.a.a;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.b.a;
import com.tencent.mm.plugin.finder.live.report.s.ai;
import com.tencent.mm.plugin.finder.live.view.adapter.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bottomArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBottomArea", "()Landroid/view/View;", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "checkAll", "Landroid/widget/CheckBox;", "getCheckAll", "()Landroid/widget/CheckBox;", "deleteSelect", "getDeleteSelect", "editAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;", "getEditAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;", "editRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getEditRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "finishTv", "getFinishTv", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelperCallback", "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$itemTouchHelperCallback$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$itemTouchHelperCallback$1;", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "getRoot", "()Landroid/view/ViewGroup;", "onClick", "", "v", "setDeleteTxtState", "select", "", "setLoadingState", "visible", "setVisible", "withAnim", "showEditView", "plugin-finder_release"})
public final class h
  implements View.OnClickListener
{
  final String TAG;
  final ViewGroup kiF;
  private final ProgressBar pDL;
  private final TextView xPY;
  private final TextView xPZ;
  private final a.a xYU;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final WxRecyclerView zlL;
  private final View zlM;
  private final CheckBox zlN;
  private final TextView zlO;
  final f zlP;
  private final b zlQ;
  private final androidx.recyclerview.widget.l zlR;
  
  public h(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.model.context.a parama, a.a parama1)
  {
    AppMethodBeat.i(287758);
    this.kiF = paramViewGroup;
    this.xYp = parama;
    this.xYU = parama1;
    this.TAG = "FinderLiveAnchorMusicEditWidget";
    this.xPY = ((TextView)this.kiF.findViewById(b.f.music_edit_cancel_tv));
    this.xPZ = ((TextView)this.kiF.findViewById(b.f.music_edit_finish_tv));
    this.zlL = ((WxRecyclerView)this.kiF.findViewById(b.f.music_edit_rv_view));
    this.zlM = this.kiF.findViewById(b.f.finder_live_anchor_music_edit_delete_item_root);
    this.zlN = ((CheckBox)this.kiF.findViewById(b.f.music_edit_check_all));
    this.zlO = ((TextView)this.kiF.findViewById(b.f.music_edit_delete_select));
    this.pDL = ((ProgressBar)this.kiF.findViewById(b.f.music_edit_loading));
    this.zlP = new f();
    this.zlQ = new b(this);
    this.zlR = new androidx.recyclerview.widget.l((l.a)this.zlQ);
    this.xPY.setOnClickListener((View.OnClickListener)this);
    this.xPZ.setOnClickListener((View.OnClickListener)this);
    this.zlN.setOnClickListener((View.OnClickListener)this);
    this.zlO.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.zlP;
    paramViewGroup.yWa = ((kotlin.g.a.q)new a(paramViewGroup, this));
    paramViewGroup = this.zlL;
    p.j(paramViewGroup, "this");
    paramViewGroup.setAdapter((RecyclerView.a)this.zlP);
    paramViewGroup.getContext();
    paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.zlR.a((RecyclerView)paramViewGroup);
    AppMethodBeat.o(287758);
  }
  
  private final void dHO()
  {
    AppMethodBeat.i(287756);
    CheckBox localCheckBox = this.zlN;
    p.j(localCheckBox, "checkAll");
    localCheckBox.setChecked(false);
    pG(false);
    pH(false);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxP();
    this.zlP.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydh, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxN());
    this.zlP.notifyDataSetChanged();
    AppMethodBeat.o(287756);
  }
  
  private final void pG(boolean paramBoolean)
  {
    AppMethodBeat.i(287754);
    if (paramBoolean)
    {
      localTextView = this.zlO;
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localTextView.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_8));
      AppMethodBeat.o(287754);
      return;
    }
    TextView localTextView = this.zlO;
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    localTextView.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_3));
    AppMethodBeat.o(287754);
  }
  
  private final void pH(boolean paramBoolean)
  {
    AppMethodBeat.i(287757);
    if (paramBoolean)
    {
      localObject = this.pDL;
      p.j(localObject, "loading");
      ((ProgressBar)localObject).setVisibility(0);
      localObject = this.zlL;
      p.j(localObject, "editRv");
      ((WxRecyclerView)localObject).setVisibility(4);
      localObject = this.zlM;
      p.j(localObject, "bottomArea");
      ((View)localObject).setVisibility(4);
      AppMethodBeat.o(287757);
      return;
    }
    Object localObject = this.pDL;
    p.j(localObject, "loading");
    ((ProgressBar)localObject).setVisibility(8);
    localObject = this.zlL;
    p.j(localObject, "editRv");
    ((WxRecyclerView)localObject).setVisibility(0);
    localObject = this.zlM;
    p.j(localObject, "bottomArea");
    ((View)localObject).setVisibility(0);
    AppMethodBeat.o(287757);
  }
  
  public final void W(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(287755);
    if (paramBoolean1)
    {
      this.kiF.setVisibility(0);
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxR())
      {
        dHO();
        AppMethodBeat.o(287755);
        return;
      }
      pH(true);
      a.a locala = this.xYU;
      if (locala != null)
      {
        locala.a(true, (kotlin.g.a.b)new c(this));
        AppMethodBeat.o(287755);
        return;
      }
      AppMethodBeat.o(287755);
      return;
    }
    if (paramBoolean2)
    {
      this.kiF.animate().translationY(ax.au(MMApplicationContext.getContext()).y).setListener((Animator.AnimatorListener)new d(this)).start();
      AppMethodBeat.o(287755);
      return;
    }
    this.zlP.dxP();
    this.kiF.setVisibility(8);
    AppMethodBeat.o(287755);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287753);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.music_edit_cancel_tv;
      if (paramView != null) {
        break label114;
      }
      label62:
      i = b.f.music_edit_finish_tv;
      if (paramView != null) {
        break label176;
      }
    }
    label86:
    label114:
    while (paramView.intValue() != i)
    {
      i = b.f.music_edit_check_all;
      if (paramView != null) {
        break label1067;
      }
      i = b.f.music_edit_delete_select;
      if (paramView != null) {
        break label1131;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287753);
        return;
        paramView = null;
        break;
        if (paramView.intValue() != i) {
          break label62;
        }
        paramView = this.xYU;
        if (paramView != null) {
          paramView.dwV();
        }
        W(false, false);
        paramView = com.tencent.mm.plugin.finder.live.component.x.ych;
        com.tencent.mm.plugin.finder.live.component.x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIP.action, 0);
      }
    }
    label176:
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxN();
    Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
    Object localObject3 = this.zlP.ydh;
    ArrayList localArrayList = this.zlP.mXB;
    p.k(localObject3, "songIdList");
    p.k(localArrayList, "musicList");
    for (;;)
    {
      int j;
      try
      {
        paramView = ((com.tencent.mm.plugin.finder.live.model.b)localObject2).dxN();
        Log.i("FinderLiveAnchorMusicData", "before replaceAnchorMusicData songId size:" + ((LinkedList)localObject3).size() + ", musicList id size:" + localArrayList.size() + ", curPlayPos:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw + ",playItem:" + paramView);
        ((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw = -1;
        ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydh.clear();
        ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydh.addAll((Collection)localObject3);
        ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydi.clear();
        ((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydi.addAll((Collection)localArrayList);
        if (paramView == null) {
          break label1223;
        }
        com.tencent.mm.plugin.finder.live.model.b localb = (com.tencent.mm.plugin.finder.live.model.b)localObject2;
        Iterator localIterator = ((Iterable)localb.ydi).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject4 = localIterator.next();
          j = i + 1;
          if (i < 0) {
            j.iBO();
          }
          localObject4 = (aq)localObject4;
          int k = ((aq)localObject4).yin.SMT;
          if (paramView == null) {
            break label1226;
          }
          Object localObject5 = paramView.yin;
          if (localObject5 == null) {
            break label1226;
          }
          if (k != ((bbg)localObject5).SMT) {
            continue;
          }
          localObject5 = (Integer)localb.ydh.get(i);
          if (localObject5 == null)
          {
            i = j;
            continue;
          }
          if (k != ((Integer)localObject5).intValue()) {
            continue;
          }
          if (paramView == null) {
            continue;
          }
          j = paramView.mfx;
          ((aq)localObject4).mfx = j;
          localb.fFw = i;
        }
        paramView = ((com.tencent.mm.plugin.finder.live.model.b)localObject2).dxN();
        Log.i("FinderLiveAnchorMusicData", "after replaceAnchorMusicData songId size:" + ((LinkedList)localObject3).size() + ", musicList id size:" + localArrayList.size() + ", curPlayPos:" + ((com.tencent.mm.plugin.finder.live.model.b)localObject2).fFw + ",playItem:" + paramView);
        b.a.c(((com.tencent.mm.plugin.finder.live.model.b)localObject2).ydi, "replaceAnchorMusicData", true);
      }
      catch (Exception paramView)
      {
        long l1;
        long l2;
        localObject2 = ak.AGL;
        ak.a(paramView, "FinderLiveAnchorMusicData,replaceAnchorMusicData:");
        continue;
        i = 0;
        continue;
        paramView = null;
        continue;
        paramView = null;
        continue;
      }
      paramView = this.zlP.yWj;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
      if (paramView != null)
      {
        localObject3 = paramView.yin;
        if (localObject3 != null)
        {
          i = ((bbg)localObject3).SMT;
          localObject2 = ((com.tencent.mm.plugin.finder.live.model.b)localObject2).Nm(i);
          Log.i(this.TAG, "music_edit_finish_tv nextPlayItem:" + paramView + ",find playItem:" + (aq)((o)localObject2).Mx + ", pos:" + ((Integer)((o)localObject2).My).intValue());
          if (localObject1 == null) {
            continue;
          }
          paramView = ((aq)localObject1).yin;
          if (paramView != null)
          {
            i = ((aq)localObject1).yin.SMT;
            paramView = (aq)((o)localObject2).Mx;
            if (paramView != null)
            {
              paramView = paramView.yin;
              if ((paramView != null) && (i == paramView.SMT) && (((aq)localObject1).mfx == 1)) {
                continue;
              }
            }
          }
          paramView = (aq)((o)localObject2).Mx;
          if (paramView != null)
          {
            localObject1 = this.xYU;
            if (localObject1 == null) {
              continue;
            }
            a.a.a.a((a.a)localObject1, paramView, ((Number)((o)localObject2).My).intValue());
            paramView = kotlin.x.aazN;
            if (paramView != null) {}
          }
          else
          {
            paramView = ((h)this).xYU;
            if (paramView != null)
            {
              paramView.bnv();
              paramView = kotlin.x.aazN;
            }
          }
          paramView = this.xYU;
          if (paramView != null) {
            paramView.dwV();
          }
          W(false, false);
          paramView = com.tencent.mm.plugin.finder.live.ui.a.yOj;
          l1 = ((c)this.xYp.business(c.class)).liveInfo.liveId;
          paramView = ((c)this.xYp.business(c.class)).kvN;
          localObject1 = z.bdh();
          l2 = ((c)this.xYp.business(c.class)).xbk;
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxQ();
          localObject3 = com.tencent.mm.plugin.finder.live.ui.a.yOj;
          com.tencent.mm.plugin.finder.live.ui.a.a(l1, paramView, (String)localObject1, l2, (ayk)localObject2, com.tencent.mm.plugin.finder.live.ui.a.dDS());
          paramView = com.tencent.mm.plugin.finder.live.component.x.ych;
          com.tencent.mm.plugin.finder.live.component.x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIM.action, 0);
          break label86;
          j = 0;
          continue;
          i = j;
          continue;
        }
      }
      label1067:
      if (paramView.intValue() != i) {
        break;
      }
      paramView = this.zlN;
      p.j(paramView, "checkAll");
      if (paramView.isChecked())
      {
        this.zlP.dFm();
        pG(true);
      }
      for (;;)
      {
        this.zlP.notifyDataSetChanged();
        break;
        this.zlP.dxP();
        pG(false);
      }
      label1131:
      if (paramView.intValue() != i) {
        break label86;
      }
      paramView = this.zlP.dFn();
      this.zlP.notifyDataSetChanged();
      pG(false);
      if (paramView.size() <= 0) {
        break label86;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.component.x.ych;
      com.tencent.mm.plugin.finder.live.component.x.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIL.action, new ArrayList((Collection)paramView.subList(0, i.ow(paramView.size(), 10))));
      break label86;
      label1223:
      continue;
      label1226:
      i = j;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "pos", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "invoke", "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, Integer, aq, kotlin.x>
  {
    a(f paramf, h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$itemTouchHelperCallback$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMovementFlags", "", "p0", "p1", "isItemViewSwipeEnabled", "", "onMove", "source", "target", "onSwiped", "plugin-finder_release"})
  public static final class b
    extends l.a
  {
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(285065);
      p.k(paramRecyclerView, "p0");
      p.k(paramv, "p1");
      int i = l.a.cA(3);
      AppMethodBeat.o(285065);
      return i;
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(285066);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv1, "source");
      p.k(paramv2, "target");
      int i = paramv1.md();
      int j = paramv2.md();
      paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha(this.zlT.TAG, "onMove from:" + i + " - to:" + j);
      paramRecyclerView = this.zlT.zlP;
      try
      {
        Collections.swap((List)paramRecyclerView.mXB, i, j);
        Collections.swap((List)paramRecyclerView.ydh, i, j);
        this.zlT.zlP.aF(i, j);
        AppMethodBeat.o(285066);
        return true;
      }
      catch (Exception paramv1)
      {
        for (;;)
        {
          paramv2 = aj.AGc;
          aj.a(paramv1, paramRecyclerView.TAG + ",moveMusicItem:");
        }
      }
    }
    
    public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(285068);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha(this.zlT.TAG, "clearView pos:" + paramv.md());
      AppMethodBeat.o(285068);
    }
    
    public final void g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(285067);
      p.k(paramv, "p0");
      AppMethodBeat.o(285067);
    }
    
    public final boolean kA()
    {
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, kotlin.x>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$setVisible$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287986);
      this.zlT.kiF.setTranslationY(0.0F);
      AppMethodBeat.o(287986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.h
 * JD-Core Version:    0.7.0.1
 */