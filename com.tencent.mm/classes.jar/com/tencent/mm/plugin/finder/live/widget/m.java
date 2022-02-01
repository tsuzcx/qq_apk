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
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.component.al;
import com.tencent.mm.plugin.finder.live.component.j.a;
import com.tencent.mm.plugin.finder.live.component.j.a.a;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.model.c.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.q.at;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bottomArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBottomArea", "()Landroid/view/View;", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "checkAll", "Landroid/widget/CheckBox;", "getCheckAll", "()Landroid/widget/CheckBox;", "deleteSelect", "getDeleteSelect", "editAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;", "getEditAdapter", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicEditAdapter;", "editRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getEditRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "finishTv", "getFinishTv", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelperCallback", "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$itemTouchHelperCallback$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$itemTouchHelperCallback$1;", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "getRoot", "()Landroid/view/ViewGroup;", "onClick", "", "v", "setDeleteTxtState", "select", "", "setLoadingState", "visible", "setVisible", "withAnim", "showEditView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements View.OnClickListener
{
  private final TextView BpM;
  private final TextView BpN;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final j.a CwN;
  private final WxRecyclerView Emi;
  private final View Emj;
  private final CheckBox Emk;
  private final TextView Eml;
  final com.tencent.mm.plugin.finder.live.view.adapter.f Emm;
  private final b Emn;
  private final androidx.recyclerview.widget.k Emo;
  final String TAG;
  final ViewGroup mJe;
  private final ProgressBar sIX;
  
  public m(final ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.model.context.a parama, j.a parama1)
  {
    AppMethodBeat.i(361096);
    this.mJe = paramViewGroup;
    this.CvU = parama;
    this.CwN = parama1;
    this.TAG = "FinderLiveAnchorMusicEditWidget";
    this.BpM = ((TextView)this.mJe.findViewById(p.e.BYf));
    this.BpN = ((TextView)this.mJe.findViewById(p.e.BYj));
    this.Emi = ((WxRecyclerView)this.mJe.findViewById(p.e.BYl));
    this.Emj = this.mJe.findViewById(p.e.BGi);
    this.Emk = ((CheckBox)this.mJe.findViewById(p.e.BYg));
    this.Eml = ((TextView)this.mJe.findViewById(p.e.BYi));
    this.sIX = ((ProgressBar)this.mJe.findViewById(p.e.BYk));
    this.Emm = new com.tencent.mm.plugin.finder.live.view.adapter.f();
    this.Emn = new b(this);
    this.Emo = new androidx.recyclerview.widget.k((k.a)this.Emn);
    this.BpM.setOnClickListener((View.OnClickListener)this);
    this.BpN.setOnClickListener((View.OnClickListener)this);
    this.Emk.setOnClickListener((View.OnClickListener)this);
    this.Eml.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.Emm;
    paramViewGroup.DPR = ((q)new a(this, paramViewGroup));
    paramViewGroup = this.Emi;
    paramViewGroup.setAdapter((RecyclerView.a)this.Emm);
    paramViewGroup.getContext();
    paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.Emo.a((RecyclerView)paramViewGroup);
    AppMethodBeat.o(361096);
  }
  
  private final void eAb()
  {
    AppMethodBeat.i(361111);
    this.Emk.setChecked(false);
    sx(false);
    sy(false);
    ((e)this.CvU.business(e.class)).Eee.eke();
    this.Emm.a(((e)this.CvU.business(e.class)).Eee.CDG, ((e)this.CvU.business(e.class)).Eee.CDH, ((e)this.CvU.business(e.class)).Eee.ekc());
    this.Emm.bZE.notifyChanged();
    AppMethodBeat.o(361111);
  }
  
  private final void sx(boolean paramBoolean)
  {
    AppMethodBeat.i(361103);
    if (paramBoolean)
    {
      this.Eml.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
      AppMethodBeat.o(361103);
      return;
    }
    this.Eml.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
    AppMethodBeat.o(361103);
  }
  
  private final void sy(boolean paramBoolean)
  {
    AppMethodBeat.i(361115);
    if (paramBoolean)
    {
      this.sIX.setVisibility(0);
      this.Emi.setVisibility(4);
      this.Emj.setVisibility(4);
      AppMethodBeat.o(361115);
      return;
    }
    this.sIX.setVisibility(8);
    this.Emi.setVisibility(0);
    this.Emj.setVisibility(0);
    AppMethodBeat.o(361115);
  }
  
  public final void ag(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(361161);
    if (paramBoolean1)
    {
      this.mJe.setVisibility(0);
      if (((e)this.CvU.business(e.class)).Eee.ekg())
      {
        eAb();
        AppMethodBeat.o(361161);
        return;
      }
      sy(true);
      j.a locala = this.CwN;
      if (locala != null)
      {
        locala.a(true, (kotlin.g.a.b)new c(this));
        AppMethodBeat.o(361161);
      }
    }
    else
    {
      if (paramBoolean2)
      {
        this.mJe.animate().translationY(bf.bf(MMApplicationContext.getContext()).y).setListener((Animator.AnimatorListener)new d(this)).start();
        AppMethodBeat.o(361161);
        return;
      }
      this.Emm.eke();
      this.mJe.setVisibility(8);
    }
    AppMethodBeat.o(361161);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361154);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BYf;
      if (paramView != null) {
        break label114;
      }
      label56:
      i = p.e.BYj;
      if (paramView != null) {
        break label176;
      }
    }
    label80:
    label114:
    while (paramView.intValue() != i)
    {
      i = p.e.BYg;
      if (paramView != null) {
        break label1116;
      }
      i = p.e.BYi;
      if (paramView != null) {
        break label1174;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(361154);
        return;
        paramView = Integer.valueOf(paramView.getId());
        break;
        if (paramView.intValue() != i) {
          break label56;
        }
        paramView = this.CwN;
        if (paramView != null) {
          paramView.ehC();
        }
        ag(false, false);
        paramView = al.CAw;
        al.j(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.DzH.action, 0);
      }
    }
    label176:
    localObject1 = ((e)this.CvU.business(e.class)).Eee.ekc();
    Object localObject2 = ((e)this.CvU.business(e.class)).Eee;
    Object localObject3 = this.Emm.CDG;
    Object localObject4 = this.Emm.pUj;
    s.u(localObject3, "songIdList");
    s.u(localObject4, "musicList");
    for (;;)
    {
      try
      {
        paramView = ((c)localObject2).ekc();
        Log.i("FinderLiveAnchorMusicData", "before replaceAnchorMusicData songId size:" + ((LinkedList)localObject3).size() + ", musicList id size:" + ((ArrayList)localObject4).size() + ", curPlayPos:" + ((c)localObject2).hKr + ",playItem:" + paramView);
        ((c)localObject2).hKr = -1;
        ((c)localObject2).CDG.clear();
        ((c)localObject2).CDG.addAll((Collection)localObject3);
        ((c)localObject2).CDH.clear();
        ((c)localObject2).CDH.addAll((Collection)localObject4);
        if (paramView == null) {
          break label1269;
        }
        c localc = (c)localObject2;
        Iterator localIterator = ((Iterable)localc.CDH).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject5 = localIterator.next();
          j = i + 1;
          if (i < 0) {
            p.kkW();
          }
          localObject5 = (at)localObject5;
          int m = ((at)localObject5).CIu.ZTv;
          if (m != paramView.CIu.ZTv) {
            break label1272;
          }
          k = 1;
          if (k == 0) {
            continue;
          }
          Integer localInteger = (Integer)localc.CDG.get(i);
          if (localInteger == null)
          {
            i = j;
            continue;
          }
          if (m != localInteger.intValue()) {
            continue;
          }
          ((at)localObject5).oYt = paramView.oYt;
          localc.hKr = i;
        }
        paramView = ((c)localObject2).ekc();
        Log.i("FinderLiveAnchorMusicData", "after replaceAnchorMusicData songId size:" + ((LinkedList)localObject3).size() + ", musicList id size:" + ((ArrayList)localObject4).size() + ", curPlayPos:" + ((c)localObject2).hKr + ",playItem:" + paramView);
        c.a.c(((c)localObject2).CDH, "replaceAnchorMusicData", true);
      }
      catch (Exception paramView)
      {
        int j;
        long l1;
        long l2;
        localObject2 = aw.Gjk;
        aw.a(paramView, "FinderLiveAnchorMusicData,replaceAnchorMusicData:");
        continue;
        localObject3 = paramView.CIu;
        if (localObject3 != null) {
          continue;
        }
        i = 0;
        continue;
        i = ((bkh)localObject3).ZTv;
        continue;
        paramView = (at)((r)localObject2).bsC;
        continue;
        paramView = (Integer)((r)localObject2).bsD;
        continue;
        paramView = ((at)localObject1).CIu;
        continue;
        i = 0;
        continue;
        paramView = (at)((r)localObject2).bsC;
        if (paramView != null) {
          continue;
        }
        paramView = null;
        continue;
        localObject1 = this.CwN;
        if (localObject1 != null) {
          continue;
        }
        paramView = null;
        continue;
        j.a.a.a((j.a)localObject1, paramView, ((Number)((r)localObject2).bsD).intValue());
        paramView = ah.aiuX;
        continue;
      }
      paramView = this.Emm.DQa;
      localObject2 = ((e)this.CvU.business(e.class)).Eee;
      if (paramView == null)
      {
        i = 0;
        localObject2 = ((c)localObject2).OL(i);
        localObject3 = this.TAG;
        localObject4 = new StringBuilder("music_edit_finish_tv nextPlayItem:").append(paramView).append(",find playItem:");
        if (localObject2 != null) {
          continue;
        }
        paramView = null;
        localObject4 = ((StringBuilder)localObject4).append(paramView).append(", pos:");
        if (localObject2 != null) {
          continue;
        }
        paramView = null;
        Log.i((String)localObject3, paramView);
        if (localObject1 != null) {
          continue;
        }
        paramView = null;
        if (paramView != null)
        {
          i = ((at)localObject1).CIu.ZTv;
          if (localObject2 == null) {
            continue;
          }
          paramView = (at)((r)localObject2).bsC;
          if (paramView == null) {
            continue;
          }
          paramView = paramView.CIu;
          if ((paramView == null) || (i != paramView.ZTv)) {
            continue;
          }
          i = 1;
          if ((i != 0) && (((at)localObject1).oYt == 1)) {}
        }
        else
        {
          if (localObject2 != null) {
            continue;
          }
          paramView = null;
          if (paramView == null)
          {
            paramView = ((m)this).CwN;
            if (paramView != null) {
              paramView.bLi();
            }
          }
        }
        paramView = this.CwN;
        if (paramView != null) {
          paramView.ehC();
        }
        ag(false, false);
        paramView = com.tencent.mm.plugin.finder.live.ui.a.DHB;
        l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
        localObject1 = z.bAW();
        l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        localObject2 = ((e)this.CvU.business(e.class)).Eee.ekf();
        localObject3 = com.tencent.mm.plugin.finder.live.ui.a.DHB;
        com.tencent.mm.plugin.finder.live.ui.a.a(l1, paramView, (String)localObject1, l2, (bfk)localObject2, com.tencent.mm.plugin.finder.live.ui.a.eue());
        paramView = al.CAw;
        al.j(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.DzE.action, 0);
        break label80;
        i = j;
        continue;
      }
      label1116:
      if (paramView.intValue() != i) {
        break;
      }
      if (this.Emk.isChecked())
      {
        this.Emm.evJ();
        sx(true);
      }
      for (;;)
      {
        this.Emm.bZE.notifyChanged();
        break;
        this.Emm.eke();
        sx(false);
      }
      label1174:
      if (paramView.intValue() != i) {
        break label80;
      }
      paramView = this.Emm.evK();
      this.Emm.bZE.notifyChanged();
      sx(false);
      if (paramView.size() <= 0) {
        break label80;
      }
      localObject1 = al.CAw;
      al.a(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.DzD.action, new ArrayList((Collection)paramView.subList(0, kotlin.k.k.qv(paramView.size(), 10))));
      break label80;
      label1269:
      continue;
      label1272:
      int k = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "pos", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<View, Integer, at, ah>
  {
    a(m paramm, com.tencent.mm.plugin.finder.live.view.adapter.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$itemTouchHelperCallback$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMovementFlags", "", "p0", "p1", "isItemViewSwipeEnabled", "", "onMove", "source", "target", "onSwiped", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k.a
  {
    b(m paramm) {}
    
    public final boolean Jj()
    {
      return false;
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(361133);
      s.u(paramRecyclerView, "p0");
      s.u(paramv, "p1");
      int i = k.a.bk(3, 0);
      AppMethodBeat.o(361133);
      return i;
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(361141);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv1, "source");
      s.u(paramv2, "target");
      int i = paramv1.KJ();
      int j = paramv2.KJ();
      paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(this.Emp.TAG, "onMove from:" + i + " - to:" + j);
      paramRecyclerView = this.Emp.Emm;
      try
      {
        Collections.swap((List)paramRecyclerView.pUj, i, j);
        Collections.swap((List)paramRecyclerView.CDG, i, j);
        this.Emp.Emm.bz(i, j);
        AppMethodBeat.o(361141);
        return true;
      }
      catch (Exception paramv1)
      {
        for (;;)
        {
          paramv2 = aw.Gjk;
          aw.a(paramv1, s.X(paramRecyclerView.TAG, ",moveMusicItem:"));
        }
      }
    }
    
    public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(361157);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(this.Emp.TAG, s.X("clearView pos:", Integer.valueOf(paramv.KJ())));
      AppMethodBeat.o(361157);
    }
    
    public final void h(RecyclerView.v paramv)
    {
      AppMethodBeat.i(361149);
      s.u(paramv, "p0");
      AppMethodBeat.o(361149);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget$setVisible$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(m paramm) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361139);
      this.Emp.mJe.setTranslationY(0.0F);
      AppMethodBeat.o(361139);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.m
 * JD-Core Version:    0.7.0.1
 */