package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=50, fComment="checked", lastDate="20141016", reviewer=50, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> jMi;
  
  private String aVI()
  {
    AppMethodBeat.i(18189);
    if (com.tencent.mm.compatible.util.d.iU(21)) {
      try
      {
        Object localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
        ((Field)localObject).setAccessible(true);
        localObject = (String)((Field)localObject).get(this);
        AppMethodBeat.o(18189);
        return localObject;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", localException, "", new Object[0]);
        AppMethodBeat.o(18189);
        return "No referrer";
      }
    }
    AppMethodBeat.o(18189);
    return "";
  }
  
  public final boolean O(Intent paramIntent)
  {
    AppMethodBeat.i(18187);
    try
    {
      paramIntent = getIntent().getData();
      if (paramIntent != null) {
        if (e.akV(paramIntent.toString()))
        {
          AppMethodBeat.o(18187);
          return true;
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { paramIntent.getMessage() });
        paramIntent = null;
      }
      String str3 = paramIntent.getScheme();
      String str1 = paramIntent.getHost();
      String str2 = paramIntent.getQuery();
      ab.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { paramIntent.toString(), str3, str1, str2 });
      if ((!bo.isNullOrNil(str1)) && (this.jMi.contains(str1)))
      {
        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { str1 });
        if (str1.equals("cardpackage"))
        {
          str3 = paramIntent.getQueryParameter("encrystr");
          ab.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str3 });
          if ((!bo.isNullOrNil(str3)) && (str3.length() < 1024))
          {
            AppMethodBeat.o(18187);
            return true;
          }
        }
        if (str1.equals("connectToFreeWifi")) {
          if ((!bo.isNullOrNil(str2)) && (str2.startsWith("apKey=")) && (str2.length() > 6))
          {
            str2 = str2.substring(6);
            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str2 });
            if ((!bo.isNullOrNil(str2)) && (str2.length() < 1024))
            {
              AppMethodBeat.o(18187);
              return true;
            }
          }
          else if (paramIntent.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
          {
            AppMethodBeat.o(18187);
            return true;
          }
        }
        if ((str1.equals("wap")) && (paramIntent.toString().startsWith("weixin://wap/pay")))
        {
          ab.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
          AppMethodBeat.o(18187);
          return true;
        }
      }
      finish();
      AppMethodBeat.o(18187);
    }
    return false;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(18188);
    switch (WXCustomSchemeEntryActivity.7.jLR[parama.ordinal()])
    {
    }
    Uri localUri;
    for (;;)
    {
      finish();
      AppMethodBeat.o(18188);
      return;
      try
      {
        localUri = getIntent().getData();
        if (localUri != null)
        {
          p.i(this, localUri.toString());
          if (!((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).canOpenKindaCashier(this))
          {
            com.tencent.mm.ui.base.h.a(this, getString(2131305144), "", getString(2131297828), new WXCustomSchemeEntryActivity.1(this));
            AppMethodBeat.o(18188);
            return;
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          ab.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
          localUri = null;
        }
        if (((Boolean)i.dpR().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.ui.base.h.a(this, getString(2131305144), "", getString(2131297828), new WXCustomSchemeEntryActivity.2(this));
          AppMethodBeat.o(18188);
          return;
        }
        parama = new ml();
        parama.cCz.ret = 1;
        com.tencent.mm.sdk.b.a.ymk.l(parama);
        if (localUri == null) {
          break label475;
        }
      }
    }
    int i = 2;
    if (paramIntent != null) {
      i = w.a(paramIntent, "translate_link_scene", 2);
    }
    int j = w.a(paramIntent, "pay_channel", -1);
    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    parama = null;
    if (j >= 0)
    {
      ab.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", new Object[] { Integer.valueOf(j) });
      parama = new Bundle();
      parama.putInt("pay_channel", j);
    }
    String str1 = aVI();
    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", new Object[] { str1 });
    if (parama == null) {
      parama = new Bundle();
    }
    for (;;)
    {
      parama.putString("pay_package", str1);
      if (e.akV(localUri.toString())) {
        if (e.l(localUri))
        {
          boolean bool = e.m(localUri);
          ab.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { localUri.toString(), Boolean.valueOf(bool) });
          if (bool)
          {
            e.a(this, localUri.toString(), i, parama, new WXCustomSchemeEntryActivity.3(this));
            i = 1;
            label445:
            if (i == 0) {
              break label682;
            }
            AppMethodBeat.o(18188);
            return;
          }
          e.a(this, localUri.toString(), i, parama, new WXCustomSchemeEntryActivity.4(this));
        }
      }
      label1172:
      for (;;)
      {
        label475:
        i = 0;
        break label445;
        String str2;
        if (e.akW(localUri.toString()))
        {
          if (i == 1)
          {
            localObject1 = v.aae().oO("key_data_center_session_id");
            if (localObject1 == null)
            {
              ab.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
              finish();
              continue;
            }
            str1 = ((v.b)localObject1).getString("key_package_name", "");
            localObject1 = ((v.b)localObject1).getString("key_package_signature", "");
            localObject2 = paramIntent.getStringExtra("key_package_name");
            str2 = paramIntent.getStringExtra("key_package_signature");
            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[] { str1, localObject1, localObject2, str2 });
            v.aae().oP("key_data_center_session_id");
            if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
            {
              ab.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
              finish();
              continue;
            }
          }
          e.a(this, localUri.toString(), i, parama, new WXCustomSchemeEntryActivity.5(this), paramIntent.getStringExtra("key_package_name"), paramIntent.getStringExtra("key_package_signature"));
          i = 1;
          break label445;
          label682:
          break;
        }
        parama = r.Zn();
        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { localUri.toString() });
        e.a(this, localUri.toString(), parama, 23, localUri.toString(), new WXCustomSchemeEntryActivity.6(this));
        continue;
        Object localObject2 = localUri.getScheme();
        parama = localUri.getHost();
        Object localObject1 = localUri.getQuery();
        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, parama, localObject1 });
        if ((!bo.isNullOrNil(parama)) && (this.jMi.contains(parama)))
        {
          if ((parama.equals("cardpackage")) && (!bo.isNullOrNil(localUri.getQueryParameter("encrystr"))))
          {
            paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
            startActivity(paramIntent);
          }
          if (parama.equals("connectToFreeWifi"))
          {
            if ((bo.isNullOrNil((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
              break label1118;
            }
            localObject2 = localUri.getQueryParameter("apKey");
            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { localObject2 });
            str2 = localUri.getQueryParameter("ticket");
            if ((!bo.isNullOrNil((String)localObject2)) && (((String)localObject2).length() < 1024))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("free_wifi_schema_uri", localUri.toString());
              paramIntent.putExtra("free_wifi_ap_key", (String)localObject2);
              paramIntent.putExtra("free_wifi_source", 5);
              paramIntent.putExtra("free_wifi_threeone_startup_type", 1);
              if (!bo.isNullOrNil(str2)) {
                paramIntent.putExtra("free_wifi_schema_ticket", str2);
              }
              if ((!((String)localObject2).startsWith("_")) && (!bo.isNullOrNil(str2))) {
                break label1088;
              }
              paramIntent.addFlags(67108864);
              com.tencent.mm.bq.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
            }
          }
          for (;;)
          {
            if ((!parama.equals("wap")) || (!localUri.toString().startsWith("weixin://wap/pay"))) {
              break label1172;
            }
            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[] { str1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            com.tencent.mm.pluginsdk.wallet.h.a(this, com.tencent.mm.pluginsdk.e.a.alf((String)localObject1), false, str1);
            break;
            label1088:
            localObject2 = new gq();
            ((gq)localObject2).cvC.intent = paramIntent;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
            continue;
            label1118:
            if (localUri.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("key_connected_router", localUri.toString());
              com.tencent.mm.bq.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", paramIntent);
              ab.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
            }
          }
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130968865;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18186);
    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.jMi = new ArrayList();
    this.jMi.add("cardpackage");
    this.jMi.add("connectToFreeWifi");
    this.jMi.add("wap");
    super.onCreate(paramBundle);
    setTitleVisibility(0);
    AppMethodBeat.o(18186);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity
 * JD-Core Version:    0.7.0.1
 */