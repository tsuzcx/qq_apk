package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.aw.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;

public class RegByMobileVoiceVerifySelectUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private LanguagePreference.a[] jsD;
  private String languageCode;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public static String Kz(String paramString)
  {
    AppMethodBeat.i(128622);
    LanguagePreference.a[] arrayOfa = aUW();
    paramString = b.Gv(paramString);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = arrayOfa[i];
      if (locala.jnh.equalsIgnoreCase(paramString))
      {
        paramString = locala.jnf;
        AppMethodBeat.o(128622);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(128622);
    return "English";
  }
  
  private static LanguagePreference.a[] aUW()
  {
    AppMethodBeat.i(128623);
    String[] arrayOfString1 = ak.getContext().getString(2131756516).trim().split(",");
    LanguagePreference.a[] arrayOfa = new LanguagePreference.a[arrayOfString1.length];
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      arrayOfa[i] = new LanguagePreference.a(arrayOfString2[1], arrayOfString2[2], arrayOfString2[0], false);
      i += 1;
    }
    AppMethodBeat.o(128623);
    return arrayOfa;
  }
  
  public int getResourceId()
  {
    return 2131493183;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128621);
    hideVKB();
    this.languageCode = getIntent().getExtras().getString("voice_verify_code");
    setMMTitle(2131756522);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128617);
        RegByMobileVoiceVerifySelectUI.this.hideVKB();
        RegByMobileVoiceVerifySelectUI.this.finish();
        AppMethodBeat.o(128617);
        return true;
      }
    });
    this.jsD = aUW();
    if ((this.jsD == null) || (this.jsD.length <= 0))
    {
      AppMethodBeat.o(128621);
      return;
    }
    this.screen.removeAll();
    Object localObject = new PreferenceCategory(this);
    this.screen.b((Preference)localObject);
    localObject = this.jsD;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = localObject[i];
      if (locala.jnh.equalsIgnoreCase(this.languageCode)) {
        locala.isSelected = true;
      }
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a(locala);
      localLanguagePreference.setKey(locala.jnh);
      this.screen.b(localLanguagePreference);
      i += 1;
    }
    AppMethodBeat.o(128621);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128618);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(128618);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128619);
    super.onDestroy();
    AppMethodBeat.o(128619);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(128620);
    if ((paramPreference instanceof LanguagePreference))
    {
      paramf = ((LanguagePreference)paramPreference).jne;
      if (paramf == null)
      {
        AppMethodBeat.o(128620);
        return false;
      }
      paramPreference = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("voice_verify_language", paramf.jnf);
      localBundle.putString("voice_verify_code", paramf.jnh);
      paramPreference.putExtras(localBundle);
      setResult(0, paramPreference);
      finish();
      AppMethodBeat.o(128620);
      return true;
    }
    AppMethodBeat.o(128620);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI
 * JD-Core Version:    0.7.0.1
 */