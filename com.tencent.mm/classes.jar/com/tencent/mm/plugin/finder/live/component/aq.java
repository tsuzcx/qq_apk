package com.tencent.mm.plugin.finder.live.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.viewmodel.component.h;
import com.tencent.mm.plugin.finder.model.ar;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveTagUIC;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  extends h
{
  public static final aq.a CAT;
  public FinderLiveTagConstract.Presenter CAU;
  
  static
  {
    AppMethodBeat.i(352777);
    CAT = new aq.a((byte)0);
    AppMethodBeat.o(352777);
  }
  
  public aq(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(352754);
    AppMethodBeat.o(352754);
  }
  
  private FinderLiveTagConstract.Presenter eiS()
  {
    AppMethodBeat.i(352762);
    FinderLiveTagConstract.Presenter localPresenter = this.CAU;
    if (localPresenter != null)
    {
      AppMethodBeat.o(352762);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(352762);
    return null;
  }
  
  private static ArrayList<cc> gq(List<? extends bno> paramList)
  {
    AppMethodBeat.i(352770);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ar((bno)paramList.next()));
    }
    AppMethodBeat.o(352770);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return p.f.CfR;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(352801);
    paramIntent = eiS();
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.EYL;
      if (paramIntent != null) {
        paramIntent.aMV();
      }
    }
    AppMethodBeat.o(352801);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(352788);
    super.onCreate(paramBundle);
    ehN();
    boolean bool = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
    ArrayList localArrayList = new ArrayList();
    paramBundle = getIntent().getSerializableExtra("KEY_TAG_INFO");
    if ((paramBundle instanceof List)) {}
    for (paramBundle = (List)paramBundle; paramBundle != null; paramBundle = null)
    {
      paramBundle = ((Iterable)paramBundle).iterator();
      while (paramBundle.hasNext())
      {
        Object localObject = (byte[])paramBundle.next();
        bno localbno = new bno();
        localbno.parseFrom((byte[])localObject);
        localObject = ah.aiuX;
        localArrayList.add(localbno);
      }
    }
    paramBundle = new FinderLiveTagConstract.Presenter(gq((List)localArrayList), bool);
    s.u(paramBundle, "<set-?>");
    this.CAU = paramBundle;
    paramBundle = new FinderLiveTagConstract.ViewCallback((MMActivity)getActivity(), eiS());
    eiS().a(paramBundle);
    AppMethodBeat.o(352788);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(352794);
    super.onDestroy();
    if (this.CAU != null) {
      eiS().onDetach();
    }
    AppMethodBeat.o(352794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.aq
 * JD-Core Version:    0.7.0.1
 */