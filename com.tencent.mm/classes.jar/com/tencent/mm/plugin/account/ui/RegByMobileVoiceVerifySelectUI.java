package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.az.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;

public class RegByMobileVoiceVerifySelectUI
  extends MMPreference
  implements i
{
  private String languageCode;
  private LanguagePreference.a[] niF;
  private f screen;
  
  public static String abe(String paramString)
  {
    AppMethodBeat.i(128622);
    LanguagePreference.a[] arrayOfa = bzU();
    paramString = b.WE(paramString);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = arrayOfa[i];
      if (locala.ndg.equalsIgnoreCase(paramString))
      {
        paramString = locala.nde;
        AppMethodBeat.o(128622);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(128622);
    return "English";
  }
  
  private static LanguagePreference.a[] bzU()
  {
    AppMethodBeat.i(128623);
    String[] arrayOfString1 = MMApplicationContext.getContext().getString(r.j.bind_mcontact_voice_verify_Languages).trim().split(",");
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
    return r.g.bindmcontact_voice_select_language;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128621);
    hideVKB();
    this.languageCode = getIntent().getExtras().getString("voice_verify_code");
    setMMTitle(r.j.bind_mcontact_voice_verify_select_title);
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
    this.niF = bzU();
    if ((this.niF == null) || (this.niF.length <= 0))
    {
      AppMethodBeat.o(128621);
      return;
    }
    this.screen.removeAll();
    Object localObject = new PreferenceCategory(this);
    this.screen.b((Preference)localObject);
    localObject = this.niF;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = localObject[i];
      if (locala.ndg.equalsIgnoreCase(this.languageCode)) {
        locala.isSelected = true;
      }
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a(locala);
      localLanguagePreference.setKey(locala.ndg);
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
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(128620);
    if ((paramPreference instanceof LanguagePreference))
    {
      paramf = ((LanguagePreference)paramPreference).ndd;
      if (paramf == null)
      {
        AppMethodBeat.o(128620);
        return false;
      }
      paramPreference = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("voice_verify_language", paramf.nde);
      localBundle.putString("voice_verify_code", paramf.ndg);
      paramPreference.putExtras(localBundle);
      setResult(0, paramPreference);
      finish();
      AppMethodBeat.o(128620);
      return true;
    }
    AppMethodBeat.o(128620);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI
 * JD-Core Version:    0.7.0.1
 */