package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI
  extends MMPreference
{
  private int ksb;
  private boolean lxH = false;
  private f lxI;
  private Preference lxJ;
  private AppBrandAuthPreference lxK;
  private AppBrandAuthPreference lxL;
  private AppBrandAuthPreference lxM;
  
  private void bnT()
  {
    AppMethodBeat.i(48524);
    if (this.lxH)
    {
      ad.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.ksb) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.ksb);
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
    bnT();
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
    if ((getIntent() != null) && (!bt.isNullOrNil(getIntent().getStringExtra("key_title"))))
    {
      setMMTitle(getIntent().getStringExtra("key_title"));
      this.lxI = getPreferenceScreen();
      this.lxI.removeAll();
      if ((getIntent() == null) || (bt.isNullOrNil(getIntent().getStringExtra("key_desc")))) {
        break label420;
      }
      paramBundle = getIntent().getStringExtra("key_desc");
      paramBundle = String.format(getString(2131755339), new Object[] { paramBundle });
      if (!bt.isNullOrNil(paramBundle))
      {
        this.lxJ = new Preference(this);
        this.lxJ.setTitle(paramBundle);
        this.lxJ.setLayoutResource(2131493026);
        this.lxI.b(this.lxJ);
      }
      this.lxK = new AppBrandAuthPreference(this);
      this.lxK.setKey("none");
      this.lxK.qR(2131755333);
      this.lxI.b(this.lxK);
      this.lxL = new AppBrandAuthPreference(this);
      this.lxL.setKey("foreground");
      this.lxL.qR(2131755332);
      this.lxI.b(this.lxL);
      if (getIntent() == null) {
        break label425;
      }
      bool = getIntent().getBooleanExtra("key_three_state", false);
      label282:
      if (bool)
      {
        this.lxM = new AppBrandAuthPreference(this);
        this.lxM.setKey("both");
        this.lxM.qR(2131755331);
        this.lxI.b(this.lxM);
      }
      if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
        this.ksb = getIntent().getIntExtra("key_state", 0);
      }
      switch (this.ksb)
      {
      default: 
        this.lxK.setChecked(true);
      }
    }
    for (;;)
    {
      this.lxI.notifyDataSetChanged();
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
      if (this.lxM != null)
      {
        this.lxM.setChecked(true);
        continue;
        this.lxL.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    ad.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.lxH = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label99;
      }
      this.ksb = 2;
      this.lxK.setChecked(false);
      this.lxL.setChecked(false);
      if (this.lxM != null) {
        this.lxM.setChecked(true);
      }
    }
    for (;;)
    {
      this.lxI.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label99:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.ksb = 1;
        this.lxL.setChecked(true);
        this.lxK.setChecked(false);
        if (this.lxM != null) {
          this.lxM.setChecked(false);
        }
      }
      else
      {
        this.ksb = 0;
        this.lxK.setChecked(true);
        this.lxL.setChecked(false);
        if (this.lxM != null) {
          this.lxM.setChecked(false);
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