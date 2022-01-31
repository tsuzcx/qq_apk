package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.appbrand.y.l;
import com.tencent.mm.protocal.c.clt;
import com.tencent.mm.protocal.c.clu;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandAuthorizeUI
  extends MMPreference
{
  private String hcm;
  List<ep> hcn = new ArrayList();
  private u hco;
  protected f hcp;
  private boolean hcq = false;
  private boolean hcr = true;
  private boolean hcs = false;
  private b hct = null;
  private String mAppId;
  
  private void aoQ()
  {
    if (!this.hcs) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.hcn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ep localep = (ep)((Iterator)localObject).next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("scope", localep.scope);
        localJSONObject.put("state", localep.state);
        localJSONObject.put("desc", localep.syf);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        y.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", localJSONException, "", new Object[0]);
      }
    }
    y.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", new Object[] { localJSONArray });
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_app_authorize_state", localJSONArray.toString());
    setResult(-1, (Intent)localObject);
  }
  
  private void dB(boolean paramBoolean)
  {
    runOnUiThread(new AppBrandAuthorizeUI.7(this, paramBoolean));
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if (this.hcn == null) {
      y.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
    }
    for (;;)
    {
      return false;
      String str = paramPreference.mKey;
      if (bk.bl(str))
      {
        y.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
        return false;
      }
      Iterator localIterator = this.hcn.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ep)localIterator.next();
        if (str.equals(bk.pm(((ep)localObject).scope)))
        {
          this.hcq = true;
          if (((CheckBoxPreference)paramPreference).isChecked())
          {
            ((ep)localObject).state = 1;
          }
          else if (this.hcr)
          {
            this.hcr = false;
            c.a locala = new c.a(this);
            locala.aeA(getString(y.j.app_brand_auth_close_tips));
            locala.aeD(getString(y.j.app_brand_auth_close_auth));
            locala.a(new AppBrandAuthorizeUI.2(this, (ep)localObject));
            locala.aeE(getString(y.j.app_cancel));
            locala.b(new AppBrandAuthorizeUI.3(this, (ep)localObject, paramPreference, paramf));
            locala.e(new AppBrandAuthorizeUI.4(this, (ep)localObject, paramPreference, paramf));
            localObject = locala.aoP();
            ((c)localObject).setCanceledOnTouchOutside(false);
            ((c)localObject).show();
          }
          else
          {
            ((ep)localObject).state = 2;
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
    aoQ();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    setBackBtn(new AppBrandAuthorizeUI.1(this));
    setMMTitle(y.j.app_brand_authorize_settings);
    ta(this.mController.czv());
    this.hcp = this.vdd;
    paramBundle = getIntent().getStringExtra("key_username");
    this.hcm = paramBundle;
    if (bk.bl(paramBundle))
    {
      finish();
      return;
    }
    this.hcs = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
    this.hco = r.sq(this.hcm);
    if (this.hco == null)
    {
      y.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
      return;
    }
    this.mAppId = this.hco.appId;
    paramBundle = this.mAppId;
    b.a locala = new b.a();
    locala.ecH = new clt();
    locala.ecI = new clu();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
    locala.ecG = 1115;
    locala.ecJ = 0;
    locala.ecK = 0;
    clt localclt = new clt();
    localclt.appId = paramBundle;
    locala.ecH = localclt;
    w.a(locala.Kt(), new AppBrandAuthorizeUI.5(this), true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.hcq)
    {
      y.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
      ai.d(new AppBrandAuthorizeUI.9(this));
    }
    super.onPause();
  }
  
  public final int xj()
  {
    return y.l.app_brand_authorize_pref;
  }
  
  public static final class AuthStateChangedByUserEvent
    implements Parcelable
  {
    public static final Parcelable.Creator<AuthStateChangedByUserEvent> CREATOR = new AppBrandAuthorizeUI.AuthStateChangedByUserEvent.1();
    
    public AuthStateChangedByUserEvent() {}
    
    AuthStateChangedByUserEvent(byte paramByte) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI
 * JD-Core Version:    0.7.0.1
 */