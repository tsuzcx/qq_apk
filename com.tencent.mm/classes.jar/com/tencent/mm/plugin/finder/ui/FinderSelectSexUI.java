package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelectSexUI
  extends MMPreference
{
  private SelectPreference FTP;
  private SelectPreference FTQ;
  private final String TAG = "Finder.FinderSelectSexUI";
  
  private static final boolean a(FinderSelectSexUI paramFinderSelectSexUI, MenuItem paramMenuItem)
  {
    Object localObject = null;
    AppMethodBeat.i(346433);
    s.u(paramFinderSelectSexUI, "this$0");
    Intent localIntent = new Intent();
    SelectPreference localSelectPreference = paramFinderSelectSexUI.FTP;
    paramMenuItem = localSelectPreference;
    if (localSelectPreference == null)
    {
      s.bIx("selectMale");
      paramMenuItem = null;
    }
    if (paramMenuItem.isSelected)
    {
      paramMenuItem = "male";
      s.X("outputSex = ", paramMenuItem);
      h.jXD();
      localIntent.putExtra("key_output_sex", paramMenuItem);
      paramFinderSelectSexUI.setResult(-1, localIntent);
      paramFinderSelectSexUI.finish();
    }
    label117:
    for (;;)
    {
      AppMethodBeat.o(346433);
      return true;
      paramMenuItem = paramFinderSelectSexUI.FTQ;
      if (paramMenuItem == null)
      {
        s.bIx("selectFeMale");
        paramMenuItem = localObject;
      }
      for (;;)
      {
        if (!paramMenuItem.isSelected) {
          break label117;
        }
        paramMenuItem = "female";
        break;
      }
    }
  }
  
  private static final boolean b(FinderSelectSexUI paramFinderSelectSexUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346440);
    s.u(paramFinderSelectSexUI, "this$0");
    paramFinderSelectSexUI.finish();
    AppMethodBeat.o(346440);
    return false;
  }
  
  private final void fbL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.FTQ;
    Object localObject1 = localSelectPreference;
    if (localSelectPreference == null)
    {
      s.bIx("selectFeMale");
      localObject1 = null;
    }
    if (!((SelectPreference)localObject1).isSelected)
    {
      localObject1 = this.FTP;
      if (localObject1 != null) {
        break label67;
      }
      s.bIx("selectMale");
      localObject1 = localObject2;
    }
    label67:
    while (((SelectPreference)localObject1).isSelected)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(167566);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(167566);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getFooterResourceId()
  {
    return e.f.finder_select_sex_footer;
  }
  
  public final int getResourceId()
  {
    return e.k.finder_select_sex;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167565);
    super.onCreate(paramBundle);
    paramBundle = getPreferenceScreen().bAi("select_male");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.FTP = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().bAi("select_female");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.FTQ = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    s.X("inputSex = ", paramBundle);
    h.jXD();
    SelectPreference localSelectPreference = this.FTP;
    localObject = localSelectPreference;
    if (localSelectPreference == null)
    {
      s.bIx("selectMale");
      localObject = null;
    }
    ((SelectPreference)localObject).setEnabled(true);
    localSelectPreference = this.FTQ;
    localObject = localSelectPreference;
    if (localSelectPreference == null)
    {
      s.bIx("selectFeMale");
      localObject = null;
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (s.p(paramBundle, "male"))
    {
      localObject = this.FTP;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("selectMale");
        paramBundle = null;
      }
      paramBundle.isSelected = true;
      localObject = this.FTQ;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("selectFeMale");
        paramBundle = null;
      }
      paramBundle.isSelected = false;
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(e.h.app_finish), new FinderSelectSexUI..ExternalSyntheticLambda0(this), null, y.b.adEJ);
      setBackBtn(new FinderSelectSexUI..ExternalSyntheticLambda1(this));
      fbL();
      AppMethodBeat.o(167565);
      return;
      if (s.p(paramBundle, "female"))
      {
        localObject = this.FTP;
        paramBundle = (Bundle)localObject;
        if (localObject == null)
        {
          s.bIx("selectMale");
          paramBundle = null;
        }
        paramBundle.isSelected = false;
        localObject = this.FTQ;
        paramBundle = (Bundle)localObject;
        if (localObject == null)
        {
          s.bIx("selectFeMale");
          paramBundle = null;
        }
        paramBundle.isSelected = true;
      }
      else
      {
        localObject = this.FTP;
        paramBundle = (Bundle)localObject;
        if (localObject == null)
        {
          s.bIx("selectMale");
          paramBundle = null;
        }
        paramBundle.isSelected = false;
        localObject = this.FTQ;
        paramBundle = (Bundle)localObject;
        if (localObject == null)
        {
          s.bIx("selectFeMale");
          paramBundle = null;
        }
        paramBundle.isSelected = false;
      }
    }
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    SelectPreference localSelectPreference2 = null;
    Object localObject = null;
    SelectPreference localSelectPreference1 = null;
    AppMethodBeat.i(167567);
    if (paramPreference == null)
    {
      paramPreference = "";
      if (!s.p(paramPreference, "select_male")) {
        break label130;
      }
      localSelectPreference2 = this.FTP;
      paramPreference = localSelectPreference2;
      if (localSelectPreference2 == null)
      {
        s.bIx("selectMale");
        paramPreference = null;
      }
      paramPreference.isSelected = true;
      paramPreference = this.FTQ;
      if (paramPreference != null) {
        break label127;
      }
      s.bIx("selectFeMale");
      paramPreference = localSelectPreference1;
    }
    label127:
    for (;;)
    {
      paramPreference.isSelected = false;
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      fbL();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      String str = paramPreference.mKey;
      paramPreference = str;
      if (str != null) {
        break;
      }
      paramPreference = "";
      break;
    }
    label130:
    if (s.p(paramPreference, "select_female"))
    {
      localSelectPreference1 = this.FTP;
      paramPreference = localSelectPreference1;
      if (localSelectPreference1 == null)
      {
        s.bIx("selectMale");
        paramPreference = null;
      }
      paramPreference.isSelected = false;
      paramPreference = this.FTQ;
      if (paramPreference == null)
      {
        s.bIx("selectFeMale");
        paramPreference = localSelectPreference2;
      }
      for (;;)
      {
        paramPreference.isSelected = true;
        break;
      }
    }
    localSelectPreference1 = this.FTP;
    paramPreference = localSelectPreference1;
    if (localSelectPreference1 == null)
    {
      s.bIx("selectMale");
      paramPreference = null;
    }
    paramPreference.isSelected = false;
    paramPreference = this.FTQ;
    if (paramPreference == null)
    {
      s.bIx("selectFeMale");
      paramPreference = localObject;
    }
    for (;;)
    {
      paramPreference.isSelected = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */