package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.au.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;

public class RegByMobileVoiceVerifySelectUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private LanguagePreference.a[] gIQ;
  private String gIR;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private static LanguagePreference.a[] arR()
  {
    AppMethodBeat.i(125460);
    String[] arrayOfString1 = ah.getContext().getString(2131297623).trim().split(",");
    LanguagePreference.a[] arrayOfa = new LanguagePreference.a[arrayOfString1.length];
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      arrayOfa[i] = new LanguagePreference.a(arrayOfString2[1], arrayOfString2[2], arrayOfString2[0], false);
      i += 1;
    }
    AppMethodBeat.o(125460);
    return arrayOfa;
  }
  
  public static String xA(String paramString)
  {
    AppMethodBeat.i(125459);
    LanguagePreference.a[] arrayOfa = arR();
    paramString = b.tL(paramString);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = arrayOfa[i];
      if (locala.gDF.equalsIgnoreCase(paramString))
      {
        paramString = locala.gDD;
        AppMethodBeat.o(125459);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(125459);
    return "English";
  }
  
  public int getResourceId()
  {
    return 2130968851;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125458);
    hideVKB();
    this.gIR = getIntent().getExtras().getString("voice_verify_code");
    setMMTitle(2131297629);
    setBackBtn(new RegByMobileVoiceVerifySelectUI.1(this));
    this.gIQ = arR();
    if ((this.gIQ == null) || (this.gIQ.length <= 0))
    {
      AppMethodBeat.o(125458);
      return;
    }
    this.screen.removeAll();
    Object localObject = new PreferenceCategory(this);
    this.screen.b((Preference)localObject);
    localObject = this.gIQ;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = localObject[i];
      if (locala.gDF.equalsIgnoreCase(this.gIR)) {
        locala.gDG = true;
      }
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a(locala);
      localLanguagePreference.setKey(locala.gDF);
      this.screen.b(localLanguagePreference);
      i += 1;
    }
    AppMethodBeat.o(125458);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125455);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(125455);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125456);
    super.onDestroy();
    AppMethodBeat.o(125456);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(125457);
    if ((paramPreference instanceof LanguagePreference))
    {
      paramf = ((LanguagePreference)paramPreference).gDC;
      if (paramf == null)
      {
        AppMethodBeat.o(125457);
        return false;
      }
      paramPreference = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("voice_verify_language", paramf.gDD);
      localBundle.putString("voice_verify_code", paramf.gDF);
      paramPreference.putExtras(localBundle);
      setResult(0, paramPreference);
      finish();
      AppMethodBeat.o(125457);
      return true;
    }
    AppMethodBeat.o(125457);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI
 * JD-Core Version:    0.7.0.1
 */