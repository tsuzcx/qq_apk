package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "type", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "getLayoutId", "initView", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlockListUI
  extends MMFinderUI
{
  public static final FinderBlockListUI.a FOL;
  private static final int FOM;
  private static final int FON;
  private static final int FOO;
  private ar ECo;
  private FinderBlockListContract.BlockListViewCallback EXw;
  private FinderBlockListContract.BlockListPresenter EXy;
  private final String TAG = "Finder.FinderBlockListUI";
  private int type;
  
  static
  {
    AppMethodBeat.i(346482);
    FOL = new FinderBlockListUI.a((byte)0);
    FOM = 1;
    FON = 20;
    FOO = 1;
    AppMethodBeat.o(346482);
  }
  
  private static final boolean a(FinderBlockListUI paramFinderBlockListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346469);
    s.u(paramFinderBlockListUI, "this$0");
    paramFinderBlockListUI.finish();
    AppMethodBeat.o(346469);
    return true;
  }
  
  private static final boolean b(FinderBlockListUI paramFinderBlockListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346477);
    s.u(paramFinderBlockListUI, "this$0");
    Log.i(paramFinderBlockListUI.TAG, "doCallSelectContactUIForMultiRetransmit");
    paramMenuItem = new Intent();
    paramMenuItem.setClassName((Context)paramFinderBlockListUI, "com.tencent.mm.ui.contact.SelectContactUI");
    paramMenuItem.putExtra("list_type", 1);
    paramMenuItem.putExtra("titile", paramFinderBlockListUI.getString(e.h.finder_mod_block_select_user));
    paramMenuItem.putExtra("list_attr", w.affp);
    Object localObject1 = paramFinderBlockListUI.EXy;
    s.checkNotNull(localObject1);
    Object localObject2 = (Iterable)((FinderBlockListContract.BlockListPresenter)localObject1).pUj;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.model.p)((Iterator)localObject2).next()).contact.username);
    }
    paramMenuItem.putExtra("always_select_contact", Util.listToString((List)localObject1, ","));
    paramMenuItem.putExtra("block_contact", z.bAM());
    paramMenuItem.putExtra("max_limit_num", FON);
    paramMenuItem.putExtra("Forbid_SelectChatRoom", true);
    paramMenuItem.putExtra("show_too_many_member", false);
    paramFinderBlockListUI.getContext().startActivityForResult(paramMenuItem, FOO);
    AppMethodBeat.o(346477);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_block_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(346506);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    Object localObject1;
    switch (this.type)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      this.ECo = ((ar)localObject1);
      if (this.ECo == null) {
        finish();
      }
      localObject1 = this.ECo;
      s.checkNotNull(localObject1);
      setMMTitle(((ar)localObject1).ePJ());
      setBackBtn(new FinderBlockListUI..ExternalSyntheticLambda0(this));
      localObject1 = this.ECo;
      s.checkNotNull(localObject1);
      this.EXy = new FinderBlockListContract.BlockListPresenter((ar)localObject1);
      localObject1 = (MMActivity)this;
      Object localObject2 = getContentView();
      s.s(localObject2, "contentView");
      FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.EXy;
      s.checkNotNull(localBlockListPresenter);
      localObject1 = new FinderBlockListContract.BlockListViewCallback((MMActivity)localObject1, (View)localObject2, localBlockListPresenter);
      localObject2 = this.EXy;
      s.checkNotNull(localObject2);
      ((FinderBlockListContract.BlockListPresenter)localObject2).a((FinderBlockListContract.BlockListViewCallback)localObject1);
      ((FinderBlockListContract.BlockListViewCallback)localObject1).initView();
      localObject2 = ah.aiuX;
      this.EXw = ((FinderBlockListContract.BlockListViewCallback)localObject1);
      localObject1 = this.ECo;
      s.checkNotNull(localObject1);
      if (((ar)localObject1).ePK()) {
        addIconOptionMenu(0, e.g.icons_outlined_add_friends, new FinderBlockListUI..ExternalSyntheticLambda1(this));
      }
      AppMethodBeat.o(346506);
      return;
      localObject1 = (ar)new c();
      continue;
      localObject1 = (ar)new ae();
      continue;
      localObject1 = (ar)new af();
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(346514);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == FOO)
    {
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("Select_Contact"))
      {
        paramIntent = Util.stringToList(paramIntent, ",");
        s.s(paramIntent, "nameList");
        localObject = (Iterable)paramIntent;
        paramIntent = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          FinderContact localFinderContact = new FinderContact();
          localFinderContact.username = str;
          paramIntent.add(localFinderContact);
        }
      }
      paramIntent = (List)paramIntent;
      Object localObject = this.EXy;
      if (localObject != null) {
        ((FinderBlockListContract.BlockListPresenter)localObject).hn(paramIntent);
      }
    }
    AppMethodBeat.o(346514);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346497);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(346497);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346525);
    super.onDestroy();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.EXy;
    if (localBlockListPresenter != null) {
      localBlockListPresenter.onDetach();
    }
    AppMethodBeat.o(346525);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(346529);
    super.onResume();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.EXy;
    if (localBlockListPresenter != null) {
      localBlockListPresenter.aNi();
    }
    AppMethodBeat.o(346529);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */