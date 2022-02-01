package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveTagUIC
  extends FinderLiveTagBaseUIC
{
  public static final a wyB;
  public FinderLiveTagConstract.Presenter uXI;
  
  static
  {
    AppMethodBeat.i(255798);
    wyB = new a((byte)0);
    AppMethodBeat.o(255798);
  }
  
  public FinderLiveTagUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255797);
    AppMethodBeat.o(255797);
  }
  
  private static ArrayList<bo> eJ(List<? extends axk> paramList)
  {
    AppMethodBeat.i(255793);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new al((axk)paramList.next()));
    }
    AppMethodBeat.o(255793);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return 2131494465;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255796);
    paramIntent = this.uXI;
    if (paramIntent == null) {
      p.btv("presenter");
    }
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.uXF;
      if (paramIntent != null)
      {
        paramIntent.amT();
        AppMethodBeat.o(255796);
        return;
      }
    }
    AppMethodBeat.o(255796);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255794);
    super.onCreate(paramBundle);
    dIl();
    boolean bool = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
    ArrayList localArrayList = new ArrayList();
    Object localObject = getIntent().getSerializableExtra("KEY_TAG_INFO");
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      paramBundle = ((Iterable)paramBundle).iterator();
      while (paramBundle.hasNext())
      {
        localObject = (byte[])paramBundle.next();
        axk localaxk = new axk();
        localaxk.parseFrom((byte[])localObject);
        localArrayList.add(localaxk);
      }
    }
    this.uXI = new FinderLiveTagConstract.Presenter(eJ((List)localArrayList), bool);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255794);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.uXI;
    if (localObject == null) {
      p.btv("presenter");
    }
    paramBundle = new FinderLiveTagConstract.ViewCallback(paramBundle, (FinderLiveTagConstract.Presenter)localObject);
    localObject = this.uXI;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((FinderLiveTagConstract.Presenter)localObject).a(paramBundle);
    AppMethodBeat.o(255794);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255795);
    super.onDestroy();
    if (((FinderLiveTagUIC)this).uXI != null)
    {
      FinderLiveTagConstract.Presenter localPresenter = this.uXI;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(255795);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveTagUIC
 * JD-Core Version:    0.7.0.1
 */