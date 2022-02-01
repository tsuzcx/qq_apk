package com.tencent.mm.plugin.finder.live.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.viewmodel.component.f;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveTagUIC;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class ad
  extends f
{
  public static final a ycI;
  public FinderLiveTagConstract.Presenter ycH;
  
  static
  {
    AppMethodBeat.i(285382);
    ycI = new a((byte)0);
    AppMethodBeat.o(285382);
  }
  
  public ad(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(285381);
    AppMethodBeat.o(285381);
  }
  
  private static ArrayList<bu> em(List<? extends bda> paramList)
  {
    AppMethodBeat.i(285377);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new an((bda)paramList.next()));
    }
    AppMethodBeat.o(285377);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_tag_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(285380);
    paramIntent = this.ycH;
    if (paramIntent == null) {
      p.bGy("presenter");
    }
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent = paramIntent.zNT;
      if (paramIntent != null)
      {
        paramIntent.asU();
        AppMethodBeat.o(285380);
        return;
      }
    }
    AppMethodBeat.o(285380);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(285378);
    super.onCreate(paramBundle);
    dxg();
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
        bda localbda = new bda();
        localbda.parseFrom((byte[])localObject);
        localArrayList.add(localbda);
      }
    }
    this.ycH = new FinderLiveTagConstract.Presenter(em((List)localArrayList), bool);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(285378);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.ycH;
    if (localObject == null) {
      p.bGy("presenter");
    }
    paramBundle = new FinderLiveTagConstract.ViewCallback(paramBundle, (FinderLiveTagConstract.Presenter)localObject);
    localObject = this.ycH;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((FinderLiveTagConstract.Presenter)localObject).a(paramBundle);
    AppMethodBeat.o(285378);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285379);
    super.onDestroy();
    if (((ad)this).ycH != null)
    {
      FinderLiveTagConstract.Presenter localPresenter = this.ycH;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(285379);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveTagUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ad
 * JD-Core Version:    0.7.0.1
 */