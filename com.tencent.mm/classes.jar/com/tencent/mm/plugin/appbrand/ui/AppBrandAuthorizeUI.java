package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandAuthorizeUI
  extends MMPreference
{
  private p ehb;
  protected f iLA;
  private boolean iLB;
  private boolean iLC;
  private boolean iLD;
  private com.tencent.mm.ui.statusbar.b iLE;
  List<fs> iLy;
  private v iLz;
  private String ikj;
  private String mAppId;
  
  public AppBrandAuthorizeUI()
  {
    AppMethodBeat.i(132909);
    this.iLy = new ArrayList();
    this.iLB = false;
    this.iLC = true;
    this.iLD = false;
    this.iLE = null;
    AppMethodBeat.o(132909);
  }
  
  private void a(final AppBrandAuthorizeUI.a parama)
  {
    AppMethodBeat.i(132912);
    if (!at.isConnected(ah.getContext()))
    {
      t.makeText(this, getString(2131297190), 1).show();
      if (parama != null) {
        parama.cd(false);
      }
      AppMethodBeat.o(132912);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132905);
        if (AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this))
        {
          AppBrandAuthorizeUI.c(AppBrandAuthorizeUI.this);
          AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.d(AppBrandAuthorizeUI.this), AppBrandAuthorizeUI.this.iLy, parama);
        }
        AppMethodBeat.o(132905);
      }
    });
    AppMethodBeat.o(132912);
  }
  
  private void aMa()
  {
    AppMethodBeat.i(132917);
    if (!this.iLD)
    {
      AppMethodBeat.o(132917);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.iLy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      fs localfs = (fs)((Iterator)localObject).next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("scope", localfs.scope);
        localJSONObject.put("state", localfs.state);
        localJSONObject.put("desc", localfs.wrI);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", localJSONException, "", new Object[0]);
      }
    }
    ab.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", new Object[] { localJSONArray });
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_app_authorize_state", localJSONArray.toString());
    setResult(-1, (Intent)localObject);
    AppMethodBeat.o(132917);
  }
  
  private void eO(boolean paramBoolean)
  {
    AppMethodBeat.i(132913);
    runOnUiThread(new AppBrandAuthorizeUI.5(this, paramBoolean));
    AppMethodBeat.o(132913);
  }
  
  public int getResourceId()
  {
    return 2131165190;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(132915);
    ab.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
    aMa();
    super.onBackPressed();
    AppMethodBeat.o(132915);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(132910);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setBackBtn(new AppBrandAuthorizeUI.1(this));
    setMMTitle(2131296584);
    setActionbarColor(getActionbarColor());
    this.iLA = getPreferenceScreen();
    paramBundle = getIntent().getStringExtra("key_username");
    this.ikj = paramBundle;
    if (bo.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(132910);
      return;
    }
    this.iLD = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
    this.iLz = q.Ak(this.ikj);
    if (this.iLz == null)
    {
      ab.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
      AppMethodBeat.o(132910);
      return;
    }
    this.mAppId = this.iLz.appId;
    paramBundle = this.mAppId;
    b.a locala = new b.a();
    locala.fsX = new czk();
    locala.fsY = new czl();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
    locala.funcId = 1115;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    czk localczk = new czk();
    localczk.appId = paramBundle;
    locala.fsX = localczk;
    w.a(locala.ado(), new AppBrandAuthorizeUI.14(this), true);
    AppMethodBeat.o(132910);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(132916);
    super.onDestroy();
    AppMethodBeat.o(132916);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(132914);
    if (this.iLB) {
      ab.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
    }
    super.onPause();
    AppMethodBeat.o(132914);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(132911);
    ab.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if (this.iLy == null)
    {
      ab.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
      AppMethodBeat.o(132911);
      return false;
    }
    String str = paramPreference.mKey;
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
      AppMethodBeat.o(132911);
      return false;
    }
    Iterator localIterator = this.iLy.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (fs)localIterator.next();
      if (str.equals(bo.nullAsNil(((fs)localObject).scope)))
      {
        this.iLB = true;
        if (((CheckBoxPreference)paramPreference).isChecked())
        {
          ((fs)localObject).state = 1;
          a(new AppBrandAuthorizeUI.8(this, paramPreference, paramf, (fs)localObject));
        }
        else if (this.iLC)
        {
          this.iLC = false;
          c.a locala = new c.a(this);
          locala.avn(getString(2131296575));
          locala.avs(getString(2131296574));
          locala.a(new AppBrandAuthorizeUI.9(this, (fs)localObject, paramPreference, paramf));
          locala.avt(getString(2131296888));
          locala.b(new AppBrandAuthorizeUI.10(this, (fs)localObject, paramPreference, paramf));
          locala.e(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(132903);
              ab.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
              this.iLP.state = 1;
              ((CheckBoxPreference)paramPreference).vxW = true;
              paramf.notifyDataSetChanged();
              AppMethodBeat.o(132903);
            }
          });
          localObject = locala.aLZ();
          ((c)localObject).setCanceledOnTouchOutside(false);
          ((c)localObject).show();
        }
        else
        {
          ((fs)localObject).state = 2;
          a(new AppBrandAuthorizeUI.12(this, paramPreference, paramf, (fs)localObject));
        }
      }
    }
    AppMethodBeat.o(132911);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI
 * JD-Core Version:    0.7.0.1
 */