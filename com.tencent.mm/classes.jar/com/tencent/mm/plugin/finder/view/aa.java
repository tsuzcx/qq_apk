package com.tencent.mm.plugin.finder.view;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.h;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet;", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;", "selectListener", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "helpBottomPage", "Lcom/tencent/mm/plugin/finder/view/GameTeamCoinNoteBottomPage;", "inputCoinValueBottomPage", "Lcom/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage;", "selectCoinBottomPage", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage;", "getSelectListener", "()Lkotlin/jvm/functions/Function2;", "clickHelpButton", "createData", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "source", "createItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "onItemClick", "", "position", "data", "selectOther", "selectValue", "value", "showSelectCoinBottomPanel", "Companion", "GameTeamConvert", "TeamInfoData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends m<des>
  implements ac.a
{
  public static final aa.a GEr;
  private final kotlin.g.a.m<des, Integer, ah> FaF;
  private final ac GEs;
  private final ab GEt;
  private final z GEu;
  
  static
  {
    AppMethodBeat.i(344768);
    GEr = new aa.a((byte)0);
    AppMethodBeat.o(344768);
  }
  
  public aa(kotlin.g.a.m<? super des, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(344762);
    this.FaF = paramm;
    this.GEs = new ac((ac.a)this);
    this.GEt = new ab((ac.a)this);
    this.GEu = new z();
    AppMethodBeat.o(344762);
  }
  
  public final void UK(int paramInt)
  {
    AppMethodBeat.i(344774);
    Log.i("MicroMsg.GameTeamConditionBottomSheet", s.X("selectValue ", Integer.valueOf(paramInt)));
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((des)((m.a)localObject).cpt).value == 7)
      {
        i = 1;
        label71:
        if (i == 0) {
          break label118;
        }
      }
    }
    for (;;)
    {
      localObject = (m.a)localObject;
      if (localObject != null) {
        this.FaF.invoke(((m.a)localObject).cpt, Integer.valueOf(paramInt));
      }
      getBottomSheet().cyW();
      AppMethodBeat.o(344774);
      return;
      i = 0;
      break label71;
      label118:
      break;
      localObject = null;
    }
  }
  
  public final boolean a(m.a<des> parama)
  {
    AppMethodBeat.i(344802);
    s.u(parama, "data");
    Object localObject2;
    Object localObject1;
    int i;
    if (((des)parama.cpt).value == 7)
    {
      getBottomSheet().a((h.b)this.GEs);
      localObject2 = ((Iterable)this.pUj).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (((des)((m.a)localObject1).cpt).value == 7)
        {
          i = 1;
          label92:
          if (i == 0) {
            break label208;
          }
          label96:
          m.a locala = (m.a)localObject1;
          if (locala != null)
          {
            localObject1 = ((des)locala.cpt).ZGd;
            if (localObject1 != null) {
              break label215;
            }
            localObject1 = null;
            label125:
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = (List)new LinkedList();
            }
            this.GEs.hM((List)localObject2);
            localObject1 = this.GEt;
            localObject2 = ((des)locala.cpt).ZGd;
            if (localObject2 != null) {
              break label306;
            }
            i = 0;
            label178:
            ((ab)localObject1).pxI = i;
          }
        }
      }
    }
    for (;;)
    {
      if (((des)parama.cpt).value == 7) {
        break label336;
      }
      AppMethodBeat.o(344802);
      return true;
      i = 0;
      break label92;
      label208:
      break;
      localObject1 = null;
      break label96;
      label215:
      localObject1 = ((cca)localObject1).aalr;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label125;
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(Integer.valueOf(((ahu)((Iterator)localObject2).next()).ZqJ));
      }
      localObject1 = (List)localObject1;
      break label125;
      label306:
      i = ((cca)localObject2).aalp;
      break label178;
      this.FaF.invoke(parama.cpt, Integer.valueOf(0));
    }
    label336:
    AppMethodBeat.o(344802);
    return false;
  }
  
  public final void flB()
  {
    AppMethodBeat.i(344780);
    getBottomSheet().a((h.b)this.GEt);
    AppMethodBeat.o(344780);
  }
  
  public final void flC()
  {
    AppMethodBeat.i(344786);
    getBottomSheet().a((h.b)this.GEu);
    AppMethodBeat.o(344786);
  }
  
  public final f<?> flg()
  {
    AppMethodBeat.i(344793);
    f localf = (f)new b((b)new d(this));
    AppMethodBeat.o(344793);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet$GameTeamConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "isLast", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends f<m.a<des>>
  {
    private final b<Integer, Boolean> GEv;
    
    public b(b<? super Integer, Boolean> paramb)
    {
      AppMethodBeat.i(344379);
      this.GEv = paramb;
      AppMethodBeat.o(344379);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(344389);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      AppMethodBeat.o(344389);
    }
    
    public final int getLayoutId()
    {
      return p.f.CdU;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet$TeamInfoData;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "source", "(Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends m.a<des>
  {
    public c(des paramdes)
    {
      super((byte)0);
      AppMethodBeat.i(344341);
      AppMethodBeat.o(344341);
    }
    
    public final int a(k paramk)
    {
      AppMethodBeat.i(344359);
      s.u(paramk, "obj");
      if ((paramk instanceof c))
      {
        if (((des)this.cpt).value == ((des)((c)paramk).cpt).value)
        {
          AppMethodBeat.o(344359);
          return 0;
        }
        AppMethodBeat.o(344359);
        return 1;
      }
      AppMethodBeat.o(344359);
      return 1;
    }
    
    public final long bZA()
    {
      return ((des)this.cpt).value;
    }
    
    public final int bZB()
    {
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<Integer, Boolean>
  {
    d(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.aa
 * JD-Core Version:    0.7.0.1
 */