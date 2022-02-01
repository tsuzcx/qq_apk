package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ba.k;
import com.tencent.mm.plugin.appbrand.backgroundrunning.preference.AppBrandAuthPreference;
import com.tencent.mm.plugin.appbrand.utils.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AppBrandAuthorizeDetailUI
  extends MMPreference
{
  private static int[] tXu = { 0, 1, 2 };
  private f pkD;
  private int sEu;
  private boolean tXv = false;
  private Preference tXw;
  private AppBrandAuthPreference tXx;
  private AppBrandAuthPreference tXy;
  private AppBrandAuthPreference tXz;
  
  private void bQf()
  {
    AppMethodBeat.i(48524);
    if (this.tXv)
    {
      Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "setResData, has changed, state:%s", new Object[] { Integer.valueOf(this.sEu) });
      Intent localIntent = new Intent();
      localIntent.putExtra("key_result_state", this.sEu);
      setResult(-1, localIntent);
      AppMethodBeat.o(48524);
      return;
    }
    setResult(0, null);
    AppMethodBeat.o(48524);
  }
  
  public int getResourceId()
  {
    return ba.k.app_brand_authorize_pref;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48523);
    bQf();
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
    label96:
    label103:
    al localal1;
    al localal2;
    al localal3;
    if ((getIntent() != null) && (!Util.isNullOrNil(getIntent().getStringExtra("key_title"))))
    {
      setMMTitle(getIntent().getStringExtra("key_title"));
      this.pkD = getPreferenceScreen();
      this.pkD.removeAll();
      if (getIntent() == null) {
        break label281;
      }
      paramBundle = getIntent().getStringExtra("key_override_authorize_usage_desc");
      if (TextUtils.isEmpty(paramBundle)) {
        break label286;
      }
      if (!Util.isNullOrNil(paramBundle))
      {
        this.tXw = new Preference(this);
        this.tXw.setTitle(paramBundle);
        this.tXw.setLayoutResource(ba.g.app_brand_preference_auth_desc);
        this.pkD.c(this.tXw);
      }
      localal1 = new al(new AppBrandAuthorizeDetailUI..ExternalSyntheticLambda1(this));
      localal2 = new al(new AppBrandAuthorizeDetailUI..ExternalSyntheticLambda0(this));
      localal3 = new al(new AppBrandAuthorizeDetailUI..ExternalSyntheticLambda2(this));
      if (getIntent() == null) {
        break label345;
      }
      paramBundle = getIntent().getIntArrayExtra("key_override_authorize_option_order");
      if (paramBundle == null) {
        break label345;
      }
      label225:
      int j = paramBundle.length;
      i = 0;
      label230:
      if (i >= j) {
        break label376;
      }
      switch (paramBundle[i])
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label230;
      setMMTitle(ba.i.app_brand_authorize_settings);
      break;
      label281:
      paramBundle = null;
      break label96;
      label286:
      if ((getIntent() != null) && (!Util.isNullOrNil(getIntent().getStringExtra("key_desc"))))
      {
        paramBundle = getIntent().getStringExtra("key_desc");
        paramBundle = String.format(getString(ba.i.app_brand_authorize_usage_desc), new Object[] { paramBundle });
        break label103;
      }
      paramBundle = null;
      break label103;
      label345:
      paramBundle = tXu;
      break label225;
      localal1.run();
      continue;
      localal2.run();
      continue;
      localal3.run();
    }
    label376:
    int i = 0;
    while (i < 3)
    {
      paramBundle = new al[] { localal1, localal2, localal3 }[i];
      if (!paramBundle.urv) {
        paramBundle.run();
      }
      i += 1;
    }
    if ((getIntent() != null) && (getIntent().hasExtra("key_state"))) {
      this.sEu = getIntent().getIntExtra("key_state", 0);
    }
    switch (this.sEu)
    {
    default: 
      this.tXx.setChecked(true);
    }
    for (;;)
    {
      this.pkD.notifyDataSetChanged();
      AppMethodBeat.o(48522);
      return;
      if (this.tXz != null)
      {
        this.tXz.setChecked(true);
        continue;
        this.tXy.setChecked(true);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(48525);
    Log.i("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", new Object[] { paramPreference.mKey });
    if ((paramPreference instanceof AppBrandAuthPreference))
    {
      this.tXv = true;
      if (!paramPreference.mKey.equalsIgnoreCase("both")) {
        break label102;
      }
      this.sEu = 2;
      this.tXx.setChecked(false);
      this.tXy.setChecked(false);
      if (this.tXz != null) {
        this.tXz.setChecked(true);
      }
    }
    for (;;)
    {
      this.pkD.notifyDataSetChanged();
      AppMethodBeat.o(48525);
      return false;
      label102:
      if (paramPreference.mKey.equalsIgnoreCase("foreground"))
      {
        this.sEu = 1;
        this.tXy.setChecked(true);
        this.tXx.setChecked(false);
        if (this.tXz != null) {
          this.tXz.setChecked(false);
        }
      }
      else
      {
        this.sEu = 0;
        this.tXx.setChecked(true);
        this.tXy.setChecked(false);
        if (this.tXz != null) {
          this.tXz.setChecked(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeDetailUI
 * JD-Core Version:    0.7.0.1
 */