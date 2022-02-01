package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.au.k;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI
  extends MMPreference
{
  private f mrf;
  private int pzp;
  private boolean qSP = false;
  private Preference qSQ;
  private AppBrandAuthPreference qSR;
  private AppBrandAuthPreference qSS;
  private AppBrandAuthPreference qST;
  
  private void bsz()
  {
    AppMethodBeat.i(48524);
    if (this.qSP)
    {
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.pzp) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.pzp);
      setResult(-1, localIntent);
      AppMethodBeat.o(48524);
      return;
    }
    setResult(0, null);
    AppMethodBeat.o(48524);
  }
  
  public int getResourceId()
  {
    return au.k.app_brand_authorize_pref;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48523);
    bsz();
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
    label130:
    boolean bool;
    if ((getIntent() != null) && (!Util.isNullOrNil(getIntent().getStringExtra("key_title"))))
    {
      setMMTitle(getIntent().getStringExtra("key_title"));
      this.mrf = getPreferenceScreen();
      this.mrf.removeAll();
      if ((getIntent() == null) || (Util.isNullOrNil(getIntent().getStringExtra("key_desc")))) {
        break label425;
      }
      paramBundle = getIntent().getStringExtra("key_desc");
      paramBundle = String.format(getString(au.i.app_brand_authorize_usage_desc), new Object[] { paramBundle });
      if (!Util.isNullOrNil(paramBundle))
      {
        this.qSQ = new Preference(this);
        this.qSQ.setTitle(paramBundle);
        this.qSQ.setLayoutResource(au.g.app_brand_preference_auth_desc);
        this.mrf.b(this.qSQ);
      }
      this.qSR = new AppBrandAuthPreference(this);
      this.qSR.setKey("none");
      this.qSR.zo(au.i.app_brand_authorize_full_desc_none);
      this.mrf.b(this.qSR);
      this.qSS = new AppBrandAuthPreference(this);
      this.qSS.setKey("foreground");
      this.qSS.zo(au.i.app_brand_authorize_full_desc_foreground);
      this.mrf.b(this.qSS);
      if (getIntent() == null) {
        break label430;
      }
      bool = getIntent().getBooleanExtra("key_three_state", false);
      label286:
      if (bool)
      {
        this.qST = new AppBrandAuthPreference(this);
        this.qST.setKey("both");
        this.qST.zo(au.i.app_brand_authorize_full_desc_both);
        this.mrf.b(this.qST);
      }
      if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
        this.pzp = getIntent().getIntExtra("key_state", 0);
      }
      switch (this.pzp)
      {
      default: 
        this.qSR.setChecked(true);
      }
    }
    for (;;)
    {
      this.mrf.notifyDataSetChanged();
      AppMethodBeat.o(48522);
      return;
      setMMTitle(au.i.app_brand_authorize_settings);
      break;
      label425:
      paramBundle = null;
      break label130;
      label430:
      bool = false;
      break label286;
      if (this.qST != null)
      {
        this.qST.setChecked(true);
        continue;
        this.qSS.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.qSP = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label99;
      }
      this.pzp = 2;
      this.qSR.setChecked(false);
      this.qSS.setChecked(false);
      if (this.qST != null) {
        this.qST.setChecked(true);
      }
    }
    for (;;)
    {
      this.mrf.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label99:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.pzp = 1;
        this.qSS.setChecked(true);
        this.qSR.setChecked(false);
        if (this.qST != null) {
          this.qST.setChecked(false);
        }
      }
      else
      {
        this.pzp = 0;
        this.qSR.setChecked(true);
        this.qSS.setChecked(false);
        if (this.qST != null) {
          this.qST.setChecked(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeDetailUI
 * JD-Core Version:    0.7.0.1
 */