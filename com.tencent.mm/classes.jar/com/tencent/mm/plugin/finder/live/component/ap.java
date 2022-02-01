package com.tencent.mm.plugin.finder.live.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.viewmodel.component.h;
import com.tencent.mm.plugin.finder.model.ar;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveSubTagUIC;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends h
{
  public static final ap.a CAR;
  public FinderLiveSubTagConstract.Presenter CAS;
  
  static
  {
    AppMethodBeat.i(352775);
    CAR = new ap.a((byte)0);
    AppMethodBeat.o(352775);
  }
  
  public ap(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(352749);
    AppMethodBeat.o(352749);
  }
  
  private FinderLiveSubTagConstract.Presenter eiR()
  {
    AppMethodBeat.i(352756);
    FinderLiveSubTagConstract.Presenter localPresenter = this.CAS;
    if (localPresenter != null)
    {
      AppMethodBeat.o(352756);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(352756);
    return null;
  }
  
  private static ArrayList<cc> gq(List<? extends bno> paramList)
  {
    AppMethodBeat.i(352769);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new ar((bno)paramList.next()));
      }
    }
    AppMethodBeat.o(352769);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return p.f.CfP;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(352785);
    super.onCreate(paramBundle);
    ehN();
    boolean bool = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
    paramBundle = (a)new bno();
    Object localObject2 = getIntent().getByteArrayExtra("KEY_TAG_INFO");
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      localObject2 = (bno)paramBundle;
      if (localObject2 == null)
      {
        paramBundle = localObject1;
        paramBundle = new FinderLiveSubTagConstract.Presenter((bno)localObject2, gq((List)paramBundle), bool);
        s.u(paramBundle, "<set-?>");
        this.CAS = paramBundle;
        paramBundle = new FinderLiveSubTagConstract.ViewCallback((MMActivity)getActivity(), eiR());
        eiR().a(paramBundle);
        AppMethodBeat.o(352785);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        paramBundle = ((bno)localObject2).ZWj;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(352790);
    super.onDestroy();
    if (this.CAS != null) {
      eiR().onDetach();
    }
    AppMethodBeat.o(352790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ap
 * JD-Core Version:    0.7.0.1
 */