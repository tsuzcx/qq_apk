package com.tencent.mm.plugin.finder.live.b;

import android.content.Context;
import androidx.lifecycle.af;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.d;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$BoxMsgNotifier;", "context", "Landroid/content/Context;", "liveRole", "", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "(Landroid/content/Context;ILcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;)V", "getContext", "()Landroid/content/Context;", "getLiveRole", "()I", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "readCount", "", "getReadCount", "()J", "setReadCount", "(J)V", "afterUpdateMessageProcess", "", "reachLast", "", "unreadCount", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "commentScrollToEnd", "isSmooth", "(Ljava/lang/Boolean;)V", "commentScrollToPos", "pos", "(ILjava/lang/Boolean;)V", "handleNotifyInsert", "notifyMsg", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$NotifyMsg;", "handleNotifyRemove", "handleNotifyUpdate", "notifyAdd", "notifyAllData", "notifyRemove", "notifyUpdate", "recordCommmentStatus", "recoveryCommentStatus", "listSize", "unMount", "updateAtMeMsgPos", "remove", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements f.a
{
  public static final d.a Zvl;
  private final int Zus;
  public final cy Zut;
  private final Context context;
  public long hqR;
  
  static
  {
    AppMethodBeat.i(370990);
    Zvl = new d.a((byte)0);
    AppMethodBeat.o(370990);
  }
  
  public d(Context paramContext, cy paramcy)
  {
    AppMethodBeat.i(370936);
    this.context = paramContext;
    this.Zus = 0;
    this.Zut = paramcy;
    AppMethodBeat.o(370936);
  }
  
  private static final void a(d paramd, int paramInt)
  {
    AppMethodBeat.i(370985);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.hqR = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).EgL;
    if ((paramd.fAM()) || (paramd.Zut.jdz())) {}
    int i;
    long l;
    for (boolean bool = true;; bool = false)
    {
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgS;
      l = paramInt - paramd.hqR;
      Log.i("BoxCommentListPresenter", "[updateMessagesOnViewAttach] listSize:" + paramInt + " readCount:" + paramd.hqR + ", reachLastVisibleComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgT + ",unreadCount" + l + ",reachLast:" + bool + ", last position:" + i);
      if (!bool) {
        break;
      }
      paramd.Zut.jdt().post(new d..ExternalSyntheticLambda0(paramd));
      AppMethodBeat.o(370985);
      return;
    }
    paramInt = k.qv(k.qu(i, 0), paramInt - 1);
    WxRecyclerView localWxRecyclerView = paramd.Zut.jdt();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter", "recoveryCommentStatus$lambda-1", "(Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter;I)V", "Undefined", "scrollToPosition", "(I)V");
    localWxRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter", "recoveryCommentStatus$lambda-1", "(Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter;I)V", "Undefined", "scrollToPosition", "(I)V");
    paramd.Zut.jdw().op(l);
    AppMethodBeat.o(370985);
  }
  
  private final void a(f.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(370960);
    Object localObject = this.Zut.agxw;
    if (localObject != null)
    {
      localObject = (List)((WxRecyclerAdapter)localObject).data;
      if (localObject == null) {}
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        i = paramd.start + paramd.count;
        if (paramBoolean)
        {
          j = paramd.start;
          k = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU;
          if (j > k) {
            break label240;
          }
          if (k >= i) {
            break label235;
          }
          i = 1;
          if (i != 0)
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).aNA(0);
            AppMethodBeat.o(370960);
          }
        }
        else if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU <= 0)
        {
          k = k.qv(i, this.Zut.jdy() - 1);
          i = paramd.start;
          if (i < k)
          {
            j = i + 1;
            paramd = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.f((b)((List)localObject).get(i))) {
              break label215;
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).aNA(i);
            AppMethodBeat.o(370960);
            return;
          }
        }
      }
      catch (Exception paramd)
      {
        localObject = aw.Gjk;
        aw.a(paramd, "updateAtMeMsg");
      }
      AppMethodBeat.o(370960);
      return;
      label215:
      if (j >= k)
      {
        AppMethodBeat.o(370960);
        return;
      }
      int i = j;
      continue;
      label235:
      i = 0;
      continue;
      label240:
      i = 0;
    }
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(370978);
    kotlin.g.b.s.u(paramd, "this$0");
    a(paramd);
    AppMethodBeat.o(370978);
  }
  
  private <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(370943);
    kotlin.g.b.s.u(paramClass, "bu");
    paramClass = this.Zut.getBuContext().business(paramClass);
    AppMethodBeat.o(370943);
    return paramClass;
  }
  
  private static final void c(d paramd)
  {
    AppMethodBeat.i(370988);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.t(Boolean.TRUE);
    i locali = i.GzZ;
    i.fkK();
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).aNA(0);
    AppMethodBeat.o(370988);
  }
  
  private boolean fAM()
  {
    AppMethodBeat.i(370948);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgT)
    {
      i locali = i.GzZ;
      if (!i.isShowing())
      {
        AppMethodBeat.o(370948);
        return true;
      }
    }
    AppMethodBeat.o(370948);
    return false;
  }
  
  private void t(Boolean paramBoolean)
  {
    AppMethodBeat.i(370965);
    b(this.Zut.jdy() - 1, paramBoolean);
    this.hqR = this.Zut.jdy();
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).aNA(0);
    AppMethodBeat.o(370965);
  }
  
  private final void v(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(370974);
    if (this.Zut.jdy() > 0)
    {
      if (paramBoolean)
      {
        this.Zut.jdt().post(new d..ExternalSyntheticLambda1(this));
        AppMethodBeat.o(370974);
        return;
      }
      if (paramLong > 0L) {
        this.Zut.jdw().op(paramLong);
      }
    }
    AppMethodBeat.o(370974);
  }
  
  public final void a(f.d paramd)
  {
    AppMethodBeat.i(371020);
    kotlin.g.b.s.u(paramd, "notifyMsg");
    Log.i("BoxCommentListPresenter", "notifyAdd commentListVisible:" + this.Zut.agxs + " size:" + this.Zut.jdy() + ' ' + paramd);
    this.Zut.a("notifyAddInfo", paramd);
    if (this.Zut.agxs) {
      if ((!fAM()) && (!this.Zut.jdz())) {
        break label174;
      }
    }
    label174:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        a(paramd, false);
      }
      long l1 = this.Zut.jdy();
      long l2 = this.hqR;
      WxRecyclerAdapter localWxRecyclerAdapter = this.Zut.agxw;
      if (localWxRecyclerAdapter != null) {
        localWxRecyclerAdapter.bA(paramd.start, paramd.count);
      }
      v(bool, l1 - l2);
      AppMethodBeat.o(371020);
      return;
    }
  }
  
  public final void aqk(int paramInt)
  {
    AppMethodBeat.i(371005);
    if (paramInt > 0)
    {
      this.Zut.jdt().post(new d..ExternalSyntheticLambda2(this, paramInt));
      AppMethodBeat.o(371005);
      return;
    }
    Log.i("BoxCommentListPresenter", kotlin.g.b.s.X("[updateMessagesOnViewAttach] curVisiableFirstPosition:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgS)));
    AppMethodBeat.o(371005);
  }
  
  public final void b(int paramInt, Boolean paramBoolean)
  {
    AppMethodBeat.i(371009);
    if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE))
    {
      paramBoolean = this.Zut.jdt();
      locala = c.a(k.qu(k.qv(paramInt, this.Zut.jdy() - 1), 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBoolean, locala.aYi(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter", "commentScrollToPos", "(ILjava/lang/Boolean;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramBoolean.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBoolean, "com/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter", "commentScrollToPos", "(ILjava/lang/Boolean;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(371009);
      return;
    }
    paramBoolean = this.Zut.jdt();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(k.qu(k.qv(paramInt, this.Zut.jdy() - 1), 0), new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramBoolean, locala.aYi(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter", "commentScrollToPos", "(ILjava/lang/Boolean;)V", "Undefined", "scrollToPosition", "(I)V");
    paramBoolean.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramBoolean, "com/tencent/mm/plugin/finder/live/comment/BoxCommentListPresenter", "commentScrollToPos", "(ILjava/lang/Boolean;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(371009);
  }
  
  public final void b(f.d paramd)
  {
    AppMethodBeat.i(371025);
    kotlin.g.b.s.u(paramd, "notifyMsg");
    Log.i("BoxCommentListPresenter", "notifyRemove commentListVisible:" + this.Zut.agxs + " size:" + this.Zut.jdy() + ' ' + paramd);
    this.Zut.a("notifyRemoveInfo", paramd);
    if (this.Zut.agxs)
    {
      boolean bool = fAM();
      if (!bool) {
        a(paramd, true);
      }
      long l1 = this.Zut.jdy();
      long l2 = this.hqR;
      WxRecyclerAdapter localWxRecyclerAdapter = this.Zut.agxw;
      if (localWxRecyclerAdapter != null) {
        localWxRecyclerAdapter.bB(paramd.start, paramd.count);
      }
      v(bool, l1 - l2);
    }
    AppMethodBeat.o(371025);
  }
  
  public final void c(f.d paramd)
  {
    AppMethodBeat.i(371030);
    kotlin.g.b.s.u(paramd, "notifyMsg");
    Log.i("BoxCommentListPresenter", "boxCommentLikeTrack notifyUpdate commentListVisible:" + this.Zut.agxs + " notifyUpdate size:" + this.Zut.jdy() + ' ' + paramd);
    this.Zut.a("notifyUpdateInfo", paramd);
    if (this.Zut.agxs)
    {
      Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ("BoxCommentListPresenter", "boxCommentLikeTrack notifyUpdate size:" + this.Zut.jdy() + ' ' + paramd);
      boolean bool = fAM();
      long l1 = this.Zut.jdy();
      long l2 = this.hqR;
      localObject = this.Zut.agxw;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).e(paramd.start, paramd.count, paramd.bUn);
      }
      v(bool, l1 - l2);
    }
    AppMethodBeat.o(371030);
  }
  
  public final void epQ()
  {
    AppMethodBeat.i(371003);
    Object localObject;
    if (this.Zut.jdu().hqR > 0L)
    {
      localObject = this.Zut.jdt().getLayoutManager();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(371003);
        throw ((Throwable)localObject);
      }
      localObject = (LinearLayoutManager)localObject;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgS = ((LinearLayoutManager)localObject).Jw();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgR = ((LinearLayoutManager)localObject).Ju();
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgS != this.Zut.jdy() - 1) {
        break label177;
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject).PX(bool);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).EgL = k.bR(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).EgL, this.Zut.jdu().hqR);
      AppMethodBeat.o(371003);
      return;
    }
  }
  
  public final void gOb()
  {
    AppMethodBeat.i(371015);
    Log.i("BoxCommentListPresenter", "notifyAllData commentListVisible:" + this.Zut.agxs + " size:" + this.Zut.jdy());
    if (this.Zut.agxs)
    {
      WxRecyclerAdapter localWxRecyclerAdapter = this.Zut.agxw;
      if (localWxRecyclerAdapter != null) {
        localWxRecyclerAdapter.bZE.notifyChanged();
      }
    }
    AppMethodBeat.o(371015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.d
 * JD-Core Version:    0.7.0.1
 */