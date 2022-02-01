package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI
  extends MMPreference
{
  private int kTr;
  private boolean lZB = false;
  private f lZC;
  private Preference lZD;
  private AppBrandAuthPreference lZE;
  private AppBrandAuthPreference lZF;
  private AppBrandAuthPreference lZG;
  
  private void buP()
  {
    AppMethodBeat.i(48524);
    if (this.lZB)
    {
      ac.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.kTr) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.kTr);
      setResult(-1, localIntent);
      AppMethodBeat.o(48524);
      return;
    }
    setResult(0, null);
    AppMethodBeat.o(48524);
  }
  
  public int getResourceId()
  {
    return 2131951623;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48523);
    buP();
    super.onBackPressed();
    AppMethodBeat.o(48523);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48522);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48521);
        AppBrandAuthorizeDetailUI.a(AppBrandAuthorizeDetailUI.this);
        AppBrandAuthorizeDetailUI.this.finish();
        AppMethodBeat.o(48521);
        return false;
      }
    });
    label129:
    boolean bool;
    if ((getIntent() != null) && (!bs.isNullOrNil(getIntent().getStringExtra("key_title"))))
    {
      setMMTitle(getIntent().getStringExtra("key_title"));
      this.lZC = getPreferenceScreen();
      this.lZC.removeAll();
      if ((getIntent() == null) || (bs.isNullOrNil(getIntent().getStringExtra("key_desc")))) {
        break label420;
      }
      paramBundle = getIntent().getStringExtra("key_desc");
      paramBundle = String.format(getString(2131755339), new Object[] { paramBundle });
      if (!bs.isNullOrNil(paramBundle))
      {
        this.lZD = new Preference(this);
        this.lZD.setTitle(paramBundle);
        this.lZD.setLayoutResource(2131493026);
        this.lZC.b(this.lZD);
      }
      this.lZE = new AppBrandAuthPreference(this);
      this.lZE.setKey("none");
      this.lZE.rE(2131755333);
      this.lZC.b(this.lZE);
      this.lZF = new AppBrandAuthPreference(this);
      this.lZF.setKey("foreground");
      this.lZF.rE(2131755332);
      this.lZC.b(this.lZF);
      if (getIntent() == null) {
        break label425;
      }
      bool = getIntent().getBooleanExtra("key_three_state", false);
      label282:
      if (bool)
      {
        this.lZG = new AppBrandAuthPreference(this);
        this.lZG.setKey("both");
        this.lZG.rE(2131755331);
        this.lZC.b(this.lZG);
      }
      if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
        this.kTr = getIntent().getIntExtra("key_state", 0);
      }
      switch (this.kTr)
      {
      default: 
        this.lZE.setChecked(true);
      }
    }
    for (;;)
    {
      this.lZC.notifyDataSetChanged();
      AppMethodBeat.o(48522);
      return;
      setMMTitle(2131755335);
      break;
      label420:
      paramBundle = null;
      break label129;
      label425:
      bool = false;
      break label282;
      if (this.lZG != null)
      {
        this.lZG.setChecked(true);
        continue;
        this.lZF.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    ac.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.lZB = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label99;
      }
      this.kTr = 2;
      this.lZE.setChecked(false);
      this.lZF.setChecked(false);
      if (this.lZG != null) {
        this.lZG.setChecked(true);
      }
    }
    for (;;)
    {
      this.lZC.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label99:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.kTr = 1;
        this.lZF.setChecked(true);
        this.lZE.setChecked(false);
        if (this.lZG != null) {
          this.lZG.setChecked(false);
        }
      }
      else
      {
        this.kTr = 0;
        this.lZE.setChecked(true);
        this.lZF.setChecked(false);
        if (this.lZG != null) {
          this.lZG.setChecked(false);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeDetailUI
 * JD-Core Version:    0.7.0.1
 */