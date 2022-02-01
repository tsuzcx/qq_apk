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
  private int lpU;
  private AppBrandAuthPreference mzA;
  private AppBrandAuthPreference mzB;
  private boolean mzw = false;
  private f mzx;
  private Preference mzy;
  private AppBrandAuthPreference mzz;
  
  private void byU()
  {
    AppMethodBeat.i(48524);
    if (this.mzw)
    {
      ad.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.lpU) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.lpU);
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
    byU();
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
      this.mzx = getPreferenceScreen();
      this.mzx.removeAll();
      if ((getIntent() == null) || (bt.isNullOrNil(getIntent().getStringExtra("key_desc")))) {
        break label420;
      }
      paramBundle = getIntent().getStringExtra("key_desc");
      paramBundle = String.format(getString(2131755339), new Object[] { paramBundle });
      if (!bt.isNullOrNil(paramBundle))
      {
        this.mzy = new Preference(this);
        this.mzy.setTitle(paramBundle);
        this.mzy.setLayoutResource(2131493026);
        this.mzx.b(this.mzy);
      }
      this.mzz = new AppBrandAuthPreference(this);
      this.mzz.setKey("none");
      this.mzz.se(2131755333);
      this.mzx.b(this.mzz);
      this.mzA = new AppBrandAuthPreference(this);
      this.mzA.setKey("foreground");
      this.mzA.se(2131755332);
      this.mzx.b(this.mzA);
      if (getIntent() == null) {
        break label425;
      }
      bool = getIntent().getBooleanExtra("key_three_state", false);
      label282:
      if (bool)
      {
        this.mzB = new AppBrandAuthPreference(this);
        this.mzB.setKey("both");
        this.mzB.se(2131755331);
        this.mzx.b(this.mzB);
      }
      if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
        this.lpU = getIntent().getIntExtra("key_state", 0);
      }
      switch (this.lpU)
      {
      default: 
        this.mzz.setChecked(true);
      }
    }
    for (;;)
    {
      this.mzx.notifyDataSetChanged();
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
      if (this.mzB != null)
      {
        this.mzB.setChecked(true);
        continue;
        this.mzA.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    ad.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.mzw = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label99;
      }
      this.lpU = 2;
      this.mzz.setChecked(false);
      this.mzA.setChecked(false);
      if (this.mzB != null) {
        this.mzB.setChecked(true);
      }
    }
    for (;;)
    {
      this.mzx.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label99:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.lpU = 1;
        this.mzA.setChecked(true);
        this.mzz.setChecked(false);
        if (this.mzB != null) {
          this.mzB.setChecked(false);
        }
      }
      else
      {
        this.lpU = 0;
        this.mzz.setChecked(true);
        this.mzA.setChecked(false);
        if (this.mzB != null) {
          this.mzB.setChecked(false);
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