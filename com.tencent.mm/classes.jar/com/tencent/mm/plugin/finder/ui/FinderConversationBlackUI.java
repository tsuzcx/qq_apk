package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.d;
import androidx.paging.ap;
import androidx.paging.ap.a;
import androidx.paging.ap.e;
import androidx.paging.ap.e.a;
import androidx.paging.aq;
import androidx.paging.e;
import androidx.paging.e.2;
import androidx.paging.m.c;
import androidx.paging.z;
import androidx.paging.z.1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ContactDataSource", "ContactDataSourceFactory", "ContactHolder", "ContactItem", "ContactListAdapter", "PageParam", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConversationBlackUI
  extends MMFinderUI
{
  public static final FinderConversationBlackUI.a FOP;
  private final FinderConversationBlackUI.f FOQ;
  
  static
  {
    AppMethodBeat.i(346816);
    FOP = new FinderConversationBlackUI.a((byte)0);
    AppMethodBeat.o(346816);
  }
  
  public FinderConversationBlackUI()
  {
    AppMethodBeat.i(346786);
    this.FOQ = new FinderConversationBlackUI.f();
    AppMethodBeat.o(346786);
  }
  
  private static final void a(FinderConversationBlackUI paramFinderConversationBlackUI, g paramg, ap paramap)
  {
    AppMethodBeat.i(346808);
    s.u(paramFinderConversationBlackUI, "this$0");
    s.u(paramg, "$boundaryCallback");
    paramFinderConversationBlackUI = paramFinderConversationBlackUI.FOQ.bPV;
    int i;
    if (paramap != null)
    {
      if ((paramFinderConversationBlackUI.bKQ == null) && (paramFinderConversationBlackUI.bKR == null)) {
        paramFinderConversationBlackUI.bKP = paramap.isContiguous();
      }
    }
    else
    {
      i = paramFinderConversationBlackUI.bKS + 1;
      paramFinderConversationBlackUI.bKS = i;
      if (paramap != paramFinderConversationBlackUI.bKQ)
      {
        if (paramap != null) {
          break label243;
        }
        i = paramFinderConversationBlackUI.getItemCount();
        if (paramFinderConversationBlackUI.bKQ == null) {
          break label228;
        }
        paramFinderConversationBlackUI.bKQ.a(paramFinderConversationBlackUI.bKT);
        paramFinderConversationBlackUI.bKQ = null;
        label103:
        paramFinderConversationBlackUI.bKL.aS(0, i);
      }
    }
    for (;;)
    {
      Log.i("Finder.ConversationBlackUI", "[onItemsChangeLoaded]");
      if ((((MMProcessBar)paramg.FOU.findViewById(e.e.loadingIcon)).getVisibility() == 0) && (((RecyclerView)paramg.FOU.findViewById(e.e.conversationRecyclerView)).getVisibility() != 0))
      {
        ((MMProcessBar)paramg.FOU.findViewById(e.e.loadingIcon)).setVisibility(8);
        ((RecyclerView)paramg.FOU.findViewById(e.e.conversationRecyclerView)).setVisibility(0);
      }
      AppMethodBeat.o(346808);
      return;
      if (paramap.isContiguous() == paramFinderConversationBlackUI.bKP) {
        break;
      }
      paramFinderConversationBlackUI = new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
      AppMethodBeat.o(346808);
      throw paramFinderConversationBlackUI;
      label228:
      if (paramFinderConversationBlackUI.bKR == null) {
        break label103;
      }
      paramFinderConversationBlackUI.bKR = null;
      break label103;
      label243:
      if ((paramFinderConversationBlackUI.bKQ == null) && (paramFinderConversationBlackUI.bKR == null))
      {
        paramFinderConversationBlackUI.bKQ = paramap;
        paramap.a(null, paramFinderConversationBlackUI.bKT);
        paramFinderConversationBlackUI.bKL.aR(0, paramap.size());
      }
      else
      {
        if (paramFinderConversationBlackUI.bKQ != null)
        {
          paramFinderConversationBlackUI.bKQ.a(paramFinderConversationBlackUI.bKT);
          paramFinderConversationBlackUI.bKR = ((ap)paramFinderConversationBlackUI.bKQ.HX());
          paramFinderConversationBlackUI.bKQ = null;
        }
        if ((paramFinderConversationBlackUI.bKR == null) || (paramFinderConversationBlackUI.bKQ != null))
        {
          paramFinderConversationBlackUI = new IllegalStateException("must be in snapshot state to diff");
          AppMethodBeat.o(346808);
          throw paramFinderConversationBlackUI;
        }
        ap localap1 = paramFinderConversationBlackUI.bKR;
        ap localap2 = (ap)paramap.HX();
        paramFinderConversationBlackUI.bKM.bUq.execute(new e.2(paramFinderConversationBlackUI, localap1, localap2, i, paramap));
      }
    }
  }
  
  private static final boolean a(FinderConversationBlackUI paramFinderConversationBlackUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346792);
    s.u(paramFinderConversationBlackUI, "this$0");
    paramFinderConversationBlackUI.finish();
    AppMethodBeat.o(346792);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_conversation_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346856);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    Log.i("Finder.ConversationBlackUI", s.X("[onCreate] talkerType==", Integer.valueOf(i)));
    setMMTitle(e.h.finder_un_accept_msg_title);
    setBackBtn(new FinderConversationBlackUI..ExternalSyntheticLambda0(this));
    paramBundle = new ap.e.a();
    ((ap.e.a)paramBundle).pageSize = 60;
    paramBundle = (ap.e.a)paramBundle;
    ((ap.e.a)paramBundle).bPM = false;
    paramBundle = (ap.e.a)paramBundle;
    ((ap.e.a)paramBundle).bPN = 15;
    paramBundle = (ap.e.a)paramBundle;
    ((ap.e.a)paramBundle).bPL = 30;
    paramBundle = (ap.e.a)paramBundle;
    if (paramBundle.bPL < 0) {
      paramBundle.bPL = paramBundle.pageSize;
    }
    if (paramBundle.bPN < 0) {
      paramBundle.bPN = (paramBundle.pageSize * 3);
    }
    if ((!paramBundle.bPM) && (paramBundle.bPL == 0))
    {
      paramBundle = (Throwable)new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
      AppMethodBeat.o(346856);
      throw paramBundle;
    }
    if ((paramBundle.maxSize != 2147483647) && (paramBundle.maxSize < paramBundle.pageSize + paramBundle.bPL * 2))
    {
      paramBundle = (Throwable)new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + paramBundle.pageSize + ", prefetchDist=" + paramBundle.bPL + ", maxSize=" + paramBundle.maxSize);
      AppMethodBeat.o(346856);
      throw paramBundle;
    }
    Object localObject1 = new ap.e(paramBundle.pageSize, paramBundle.bPL, paramBundle.bPM, paramBundle.bPN, paramBundle.maxSize);
    paramBundle = (RecyclerView)findViewById(e.e.conversationRecyclerView);
    paramBundle.getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setAdapter(paramBundle.getAdapter());
    Object localObject2 = paramBundle.getItemAnimator();
    if (localObject2 != null) {
      ((RecyclerView.f)localObject2).bZL = 0L;
    }
    paramBundle = paramBundle.getItemAnimator();
    if (paramBundle != null) {
      paramBundle.bZK = 0L;
    }
    paramBundle = new g(this);
    Object localObject3 = new z((m.c)new FinderConversationBlackUI.c(i), (ap.e)localObject1);
    ((z)localObject3).bNj = ((ap.a)paramBundle);
    ((z)localObject3).bNk = ((Executor)com.tencent.mm.plugin.finder.a.dTo());
    localObject1 = ((z)localObject3).bNg;
    localObject2 = ((z)localObject3).bNh;
    ap.a locala = ((z)localObject3).bNj;
    m.c localc = ((z)localObject3).bNi;
    Executor localExecutor = androidx.a.a.a.a.fH();
    localObject3 = ((z)localObject3).bNk;
    localObject1 = new z.1((Executor)localObject3, localObject1, localc, (ap.e)localObject2, localExecutor, (Executor)localObject3, locala).bGX;
    s.s(localObject1, "LivePagedListBuilder(Con…tor)\n            .build()");
    ((LiveData)localObject1).a((androidx.lifecycle.q)this, new FinderConversationBlackUI..ExternalSyntheticLambda1(this, paramBundle));
    AppMethodBeat.o(346856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$onCreate$boundaryCallback$1", "Landroidx/paging/PagedList$BoundaryCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "onItemAtEndLoaded", "", "itemAtEnd", "onItemAtFrontLoaded", "itemAtFront", "onItemsChangeLoaded", "onZeroItemsLoaded", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends ap.a<FinderConversationBlackUI.e>
  {
    g(FinderConversationBlackUI paramFinderConversationBlackUI) {}
    
    public final void Ic()
    {
      AppMethodBeat.i(346588);
      super.Ic();
      Log.i("Finder.ConversationBlackUI", "[onZeroItemsLoaded]");
      AppMethodBeat.o(346588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationBlackUI
 * JD-Core Version:    0.7.0.1
 */