package com.tencent.mm.plugin.finder.live.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.viewmodel.component.f;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSubTagUIC;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class ac
  extends f
{
  public static final a ycG;
  public FinderLiveSubTagConstract.Presenter ycF;
  
  static
  {
    AppMethodBeat.i(227425);
    ycG = new a((byte)0);
    AppMethodBeat.o(227425);
  }
  
  public ac(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(227422);
    AppMethodBeat.o(227422);
  }
  
  private static ArrayList<bu> em(List<? extends bda> paramList)
  {
    AppMethodBeat.i(227415);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new an((bda)paramList.next()));
      }
    }
    AppMethodBeat.o(227415);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_sub_tag_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    FinderLiveSubTagConstract.Presenter localPresenter = null;
    AppMethodBeat.i(227418);
    super.onCreate(paramBundle);
    dxg();
    boolean bool = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
    paramBundle = (a)new bda();
    Object localObject = getIntent().getByteArrayExtra("KEY_TAG_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      localObject = (bda)paramBundle;
      paramBundle = localPresenter;
      if (localObject != null) {
        paramBundle = ((bda)localObject).SOj;
      }
      this.ycF = new FinderLiveSubTagConstract.Presenter((bda)localObject, em((List)paramBundle), bool);
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(227418);
        throw paramBundle;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
      paramBundle = (MMActivity)paramBundle;
      localPresenter = this.ycF;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      paramBundle = new FinderLiveSubTagConstract.ViewCallback(paramBundle, localPresenter);
      localPresenter = this.ycF;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.a(paramBundle);
      AppMethodBeat.o(227418);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(227420);
    super.onDestroy();
    if (((ac)this).ycF != null)
    {
      FinderLiveSubTagConstract.Presenter localPresenter = this.ycF;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(227420);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSubTagUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ac
 * JD-Core Version:    0.7.0.1
 */