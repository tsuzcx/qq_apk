package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSubTagUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveSubTagUIC
  extends FinderLiveTagBaseUIC
{
  public static final a wyz;
  public FinderLiveSubTagConstract.Presenter uXC;
  
  static
  {
    AppMethodBeat.i(255792);
    wyz = new a((byte)0);
    AppMethodBeat.o(255792);
  }
  
  public FinderLiveSubTagUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255791);
    AppMethodBeat.o(255791);
  }
  
  private static ArrayList<bo> eJ(List<? extends axk> paramList)
  {
    AppMethodBeat.i(255788);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new al((axk)paramList.next()));
      }
    }
    AppMethodBeat.o(255788);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return 2131494461;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    FinderLiveSubTagConstract.Presenter localPresenter = null;
    AppMethodBeat.i(255789);
    super.onCreate(paramBundle);
    dIl();
    boolean bool = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
    paramBundle = (a)new axk();
    Object localObject = getIntent().getByteArrayExtra("KEY_TAG_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      localObject = (axk)paramBundle;
      paramBundle = localPresenter;
      if (localObject != null) {
        paramBundle = ((axk)localObject).LHT;
      }
      this.uXC = new FinderLiveSubTagConstract.Presenter((axk)localObject, eJ((List)paramBundle), bool);
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255789);
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
      localPresenter = this.uXC;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      paramBundle = new FinderLiveSubTagConstract.ViewCallback(paramBundle, localPresenter);
      localPresenter = this.uXC;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.a(paramBundle);
      AppMethodBeat.o(255789);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255790);
    super.onDestroy();
    if (((FinderLiveSubTagUIC)this).uXC != null)
    {
      FinderLiveSubTagConstract.Presenter localPresenter = this.uXC;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(255790);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSubTagUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveSubTagUIC
 * JD-Core Version:    0.7.0.1
 */