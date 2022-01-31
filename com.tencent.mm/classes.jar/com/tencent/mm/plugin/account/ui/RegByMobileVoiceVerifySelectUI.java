package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.at.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;

public class RegByMobileVoiceVerifySelectUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private LanguagePreference.a[] fro;
  private String frp;
  
  private static LanguagePreference.a[] Yi()
  {
    String[] arrayOfString1 = ae.getContext().getString(q.j.bind_mcontact_voice_verify_Languages).trim().split(",");
    LanguagePreference.a[] arrayOfa = new LanguagePreference.a[arrayOfString1.length];
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      arrayOfa[i] = new LanguagePreference.a(arrayOfString2[1], arrayOfString2[2], arrayOfString2[0], false);
      i += 1;
    }
    return arrayOfa;
  }
  
  public static String qg(String paramString)
  {
    LanguagePreference.a[] arrayOfa = Yi();
    paramString = b.mB(paramString);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = arrayOfa[i];
      if (locala.fml.equalsIgnoreCase(paramString)) {
        return locala.fmj;
      }
      i += 1;
    }
    return "English";
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if ((paramPreference instanceof LanguagePreference))
    {
      paramf = ((LanguagePreference)paramPreference).fmi;
      if (paramf != null) {}
    }
    else
    {
      return false;
    }
    paramPreference = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("voice_verify_language", paramf.fmj);
    localBundle.putString("voice_verify_code", paramf.fml);
    paramPreference.putExtras(localBundle);
    setResult(0, paramPreference);
    finish();
    return true;
  }
  
  protected final void initView()
  {
    XM();
    this.frp = getIntent().getExtras().getString("voice_verify_code");
    setMMTitle(q.j.bind_mcontact_voice_verify_select_title);
    setBackBtn(new RegByMobileVoiceVerifySelectUI.1(this));
    this.fro = Yi();
    if ((this.fro == null) || (this.fro.length <= 0)) {}
    for (;;)
    {
      return;
      this.dnn.removeAll();
      Object localObject = new PreferenceCategory(this);
      this.dnn.a((Preference)localObject);
      localObject = this.fro;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        LanguagePreference.a locala = localObject[i];
        if (locala.fml.equalsIgnoreCase(this.frp)) {
          locala.fmm = true;
        }
        LanguagePreference localLanguagePreference = new LanguagePreference(this);
        localLanguagePreference.a(locala);
        localLanguagePreference.setKey(locala.fml);
        this.dnn.a(localLanguagePreference);
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public final int xj()
  {
    return q.g.bindmcontact_voice_select_language;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI
 * JD-Core Version:    0.7.0.1
 */