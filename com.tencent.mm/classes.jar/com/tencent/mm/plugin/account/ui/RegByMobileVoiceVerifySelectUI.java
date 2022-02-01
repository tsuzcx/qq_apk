package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;

public class RegByMobileVoiceVerifySelectUI
  extends MMPreference
  implements i
{
  private LanguagePreference.a[] kqS;
  private String languageCode;
  private f screen;
  
  public static String Ty(String paramString)
  {
    AppMethodBeat.i(128622);
    LanguagePreference.a[] arrayOfa = bpI();
    paramString = b.Ph(paramString);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = arrayOfa[i];
      if (locala.klq.equalsIgnoreCase(paramString))
      {
        paramString = locala.klo;
        AppMethodBeat.o(128622);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(128622);
    return "English";
  }
  
  private static LanguagePreference.a[] bpI()
  {
    AppMethodBeat.i(128623);
    String[] arrayOfString1 = MMApplicationContext.getContext().getString(2131756652).trim().split(",");
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
    return 2131493229;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128621);
    hideVKB();
    this.languageCode = getIntent().getExtras().getString("voice_verify_code");
    setMMTitle(2131756658);
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
    this.kqS = bpI();
    if ((this.kqS == null) || (this.kqS.length <= 0))
    {
      AppMethodBeat.o(128621);
      return;
    }
    this.screen.removeAll();
    Object localObject = new PreferenceCategory(this);
    this.screen.c((Preference)localObject);
    localObject = this.kqS;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = localObject[i];
      if (locala.klq.equalsIgnoreCase(this.languageCode)) {
        locala.isSelected = true;
      }
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a(locala);
      localLanguagePreference.setKey(locala.klq);
      this.screen.c(localLanguagePreference);
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
      paramf = ((LanguagePreference)paramPreference).kln;
      if (paramf == null)
      {
        AppMethodBeat.o(128620);
        return false;
      }
      paramPreference = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("voice_verify_language", paramf.klo);
      localBundle.putString("voice_verify_code", paramf.klq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI
 * JD-Core Version:    0.7.0.1
 */