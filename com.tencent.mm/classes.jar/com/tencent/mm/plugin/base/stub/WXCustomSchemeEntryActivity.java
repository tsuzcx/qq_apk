package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=50, fComment="checked", lastDate="20141016", reviewer=50, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> mLi;
  
  private String bBh()
  {
    AppMethodBeat.i(22272);
    if (com.tencent.mm.compatible.util.d.lh(21)) {
      try
      {
        Object localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
        ((Field)localObject).setAccessible(true);
        localObject = (String)((Field)localObject).get(this);
        AppMethodBeat.o(22272);
        return localObject;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", localException, "", new Object[0]);
        AppMethodBeat.o(22272);
        return "No referrer";
      }
    }
    AppMethodBeat.o(22272);
    return "";
  }
  
  public final boolean Z(Intent paramIntent)
  {
    AppMethodBeat.i(22270);
    try
    {
      paramIntent = getIntent().getData();
      if (paramIntent != null) {
        if (com.tencent.mm.pluginsdk.f.aAr(paramIntent.toString()))
        {
          AppMethodBeat.o(22270);
          return true;
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ad.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { paramIntent.getMessage() });
        paramIntent = null;
      }
      String str3 = paramIntent.getScheme();
      String str1 = paramIntent.getHost();
      String str2 = paramIntent.getQuery();
      ad.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { paramIntent.toString(), str3, str1, str2 });
      if ((!bt.isNullOrNil(str1)) && (this.mLi.contains(str1)))
      {
        ad.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { str1 });
        if (str1.equals("cardpackage"))
        {
          str3 = paramIntent.getQueryParameter("encrystr");
          ad.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str3 });
          if ((!bt.isNullOrNil(str3)) && (str3.length() < 1024))
          {
            AppMethodBeat.o(22270);
            return true;
          }
        }
        if (str1.equals("connectToFreeWifi")) {
          if ((!bt.isNullOrNil(str2)) && (str2.startsWith("apKey=")) && (str2.length() > 6))
          {
            str2 = str2.substring(6);
            ad.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str2 });
            if ((!bt.isNullOrNil(str2)) && (str2.length() < 1024))
            {
              AppMethodBeat.o(22270);
              return true;
            }
          }
          else if (paramIntent.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
          {
            AppMethodBeat.o(22270);
            return true;
          }
        }
        if ((str1.equals("wap")) && (paramIntent.toString().startsWith("weixin://wap/pay")))
        {
          ad.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
          AppMethodBeat.o(22270);
          return true;
        }
      }
      finish();
      AppMethodBeat.o(22270);
    }
    return false;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(22271);
    switch (WXCustomSchemeEntryActivity.7.mKE[parama.ordinal()])
    {
    }
    Uri localUri;
    for (;;)
    {
      finish();
      AppMethodBeat.o(22271);
      return;
      try
      {
        localUri = getIntent().getData();
        if (localUri != null)
        {
          q.j(this, localUri.toString());
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
          {
            h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(22262);
                WXCustomSchemeEntryActivity.this.finish();
                AppMethodBeat.o(22262);
              }
            });
            AppMethodBeat.o(22271);
            return;
          }
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          ad.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
          localUri = null;
        }
        if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.eBg().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
        {
          h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(22263);
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22263);
            }
          });
          AppMethodBeat.o(22271);
          return;
        }
        parama = new nx();
        parama.dsX.ret = 1;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
        if (localUri == null) {
          break label475;
        }
      }
    }
    int i = 2;
    if (paramIntent != null) {
      i = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "translate_link_scene", 2);
    }
    int j = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "pay_channel", -1);
    ad.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    parama = null;
    if (j >= 0)
    {
      ad.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", new Object[] { Integer.valueOf(j) });
      parama = new Bundle();
      parama.putInt("pay_channel", j);
    }
    String str1 = bBh();
    ad.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", new Object[] { str1 });
    if (parama == null) {
      parama = new Bundle();
    }
    label1155:
    label1185:
    for (;;)
    {
      parama.putString("pay_package", str1);
      if (com.tencent.mm.pluginsdk.f.aAr(localUri.toString())) {
        if (com.tencent.mm.pluginsdk.f.v(localUri))
        {
          boolean bool = com.tencent.mm.pluginsdk.f.w(localUri);
          ad.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { localUri.toString(), Boolean.valueOf(bool) });
          if (bool)
          {
            com.tencent.mm.pluginsdk.f.a(this, localUri.toString(), i, parama, new f.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22264);
                ad.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                {
                  paramAnonymousString = ((ab)paramAnonymousn).aBc();
                  if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing())) {
                    t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(2131755906) + " : " + bt.nullAsNil(paramAnonymousString.Ewj), 0).show();
                  }
                }
                WXCustomSchemeEntryActivity.this.finish();
                AppMethodBeat.o(22264);
              }
            });
            i = 1;
            label445:
            if (i == 0) {
              break label682;
            }
            AppMethodBeat.o(22271);
            return;
          }
          com.tencent.mm.pluginsdk.f.a(this, localUri.toString(), i, parama, new f.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22265);
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22265);
            }
          });
        }
      }
      label682:
      label1239:
      for (;;)
      {
        label475:
        i = 0;
        break label445;
        String str2;
        if (com.tencent.mm.pluginsdk.f.aAs(localUri.toString()))
        {
          if (i == 1)
          {
            localObject1 = com.tencent.mm.model.y.arz().tB("key_data_center_session_id");
            if (localObject1 == null)
            {
              ad.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
              finish();
              continue;
            }
            str1 = ((y.b)localObject1).getString("key_package_name", "");
            localObject1 = ((y.b)localObject1).getString("key_package_signature", "");
            localObject2 = paramIntent.getStringExtra("key_package_name");
            str2 = paramIntent.getStringExtra("key_package_signature");
            ad.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[] { str1, localObject1, localObject2, str2 });
            com.tencent.mm.model.y.arz().tC("key_data_center_session_id");
            if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
            {
              ad.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
              finish();
              continue;
            }
          }
          com.tencent.mm.pluginsdk.f.a(this, localUri.toString(), i, parama, new f.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22266);
              ad.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
              if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
              {
                paramAnonymousString = ((ab)paramAnonymousn).aBc();
                if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing())) {
                  t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(2131755906) + " : " + bt.nullAsNil(paramAnonymousString.Ewj), 0).show();
                }
              }
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22266);
            }
          }, paramIntent.getStringExtra("key_package_name"), paramIntent.getStringExtra("key_package_signature"));
          i = 1;
          break label445;
          break;
        }
        parama = u.aqG();
        ad.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { localUri.toString() });
        com.tencent.mm.pluginsdk.f.a(this, localUri.toString(), parama, 23, localUri.toString(), new f.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(22267);
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.o(22267);
          }
        });
        continue;
        Object localObject2 = localUri.getScheme();
        parama = localUri.getHost();
        Object localObject1 = localUri.getQuery();
        ad.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, parama, localObject1 });
        if ((!bt.isNullOrNil(parama)) && (this.mLi.contains(parama)))
        {
          if ((parama.equals("cardpackage")) && (!bt.isNullOrNil(localUri.getQueryParameter("encrystr"))))
          {
            paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramIntent.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          if (parama.equals("connectToFreeWifi"))
          {
            if ((bt.isNullOrNil((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
              break label1185;
            }
            localObject2 = localUri.getQueryParameter("apKey");
            ad.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { localObject2 });
            str2 = localUri.getQueryParameter("ticket");
            if ((!bt.isNullOrNil((String)localObject2)) && (((String)localObject2).length() < 1024))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("free_wifi_schema_uri", localUri.toString());
              paramIntent.putExtra("free_wifi_ap_key", (String)localObject2);
              paramIntent.putExtra("free_wifi_source", 5);
              paramIntent.putExtra("free_wifi_threeone_startup_type", 1);
              if (!bt.isNullOrNil(str2)) {
                paramIntent.putExtra("free_wifi_schema_ticket", str2);
              }
              if ((!((String)localObject2).startsWith("_")) && (!bt.isNullOrNil(str2))) {
                break label1155;
              }
              paramIntent.addFlags(67108864);
              com.tencent.mm.bs.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
            }
          }
          for (;;)
          {
            if ((!parama.equals("wap")) || (!localUri.toString().startsWith("weixin://wap/pay"))) {
              break label1239;
            }
            ad.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[] { str1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            com.tencent.mm.pluginsdk.wallet.f.a(this, com.tencent.mm.pluginsdk.e.a.aAA((String)localObject1), false, str1);
            break;
            localObject2 = new hk();
            ((hk)localObject2).dla.intent = paramIntent;
            com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
            continue;
            if (localUri.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("key_connected_router", localUri.toString());
              com.tencent.mm.bs.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", paramIntent);
              ad.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
            }
          }
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131493200;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22269);
    ad.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.mLi = new ArrayList();
    this.mLi.add("cardpackage");
    this.mLi.add("connectToFreeWifi");
    this.mLi.add("wap");
    super.onCreate(paramBundle);
    setTitleVisibility(0);
    AppMethodBeat.o(22269);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity
 * JD-Core Version:    0.7.0.1
 */