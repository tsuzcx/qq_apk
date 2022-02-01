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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.og;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=50, fComment="checked", lastDate="20141016", reviewer=50, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> nnr;
  
  private String bId()
  {
    AppMethodBeat.i(22272);
    if (com.tencent.mm.compatible.util.d.lb(21)) {
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
        ac.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", localException, "", new Object[0]);
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
        if (com.tencent.mm.pluginsdk.f.aFJ(paramIntent.toString()))
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
        ac.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { paramIntent.getMessage() });
        paramIntent = null;
      }
      String str3 = paramIntent.getScheme();
      String str1 = paramIntent.getHost();
      String str2 = paramIntent.getQuery();
      ac.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { paramIntent.toString(), str3, str1, str2 });
      if ((!bs.isNullOrNil(str1)) && (this.nnr.contains(str1)))
      {
        ac.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { str1 });
        if (str1.equals("cardpackage"))
        {
          str3 = paramIntent.getQueryParameter("encrystr");
          ac.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str3 });
          if ((!bs.isNullOrNil(str3)) && (str3.length() < 1024))
          {
            AppMethodBeat.o(22270);
            return true;
          }
        }
        if (str1.equals("connectToFreeWifi")) {
          if ((!bs.isNullOrNil(str2)) && (str2.startsWith("apKey=")) && (str2.length() > 6))
          {
            str2 = str2.substring(6);
            ac.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str2 });
            if ((!bs.isNullOrNil(str2)) && (str2.length() < 1024))
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
          ac.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
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
    switch (WXCustomSchemeEntryActivity.7.nmN[parama.ordinal()])
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
          ac.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
          localUri = null;
        }
        if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.eQA().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
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
        parama = new og();
        parama.dqH.ret = 1;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
        if (localUri == null) {
          break label475;
        }
      }
    }
    int i = 2;
    if (paramIntent != null) {
      i = x.getIntExtra(paramIntent, "translate_link_scene", 2);
    }
    int j = x.getIntExtra(paramIntent, "pay_channel", -1);
    ac.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    parama = null;
    if (j >= 0)
    {
      ac.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", new Object[] { Integer.valueOf(j) });
      parama = new Bundle();
      parama.putInt("pay_channel", j);
    }
    String str1 = bId();
    ac.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", new Object[] { str1 });
    if (parama == null) {
      parama = new Bundle();
    }
    label1155:
    label1185:
    for (;;)
    {
      parama.putString("pay_package", str1);
      if (com.tencent.mm.pluginsdk.f.aFJ(localUri.toString())) {
        if (com.tencent.mm.pluginsdk.f.v(localUri))
        {
          boolean bool = com.tencent.mm.pluginsdk.f.w(localUri);
          ac.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { localUri.toString(), Boolean.valueOf(bool) });
          if (bool)
          {
            com.tencent.mm.pluginsdk.f.a(this, localUri.toString(), i, parama, new f.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22264);
                ac.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
                {
                  paramAnonymousString = ((ab)paramAnonymousn).aHS();
                  if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing())) {
                    t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(2131755906) + " : " + bs.nullAsNil(paramAnonymousString.FTm), 0).show();
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
        if (com.tencent.mm.pluginsdk.f.aFK(localUri.toString()))
        {
          if (i == 1)
          {
            localObject1 = y.ayq().xH("key_data_center_session_id");
            if (localObject1 == null)
            {
              ac.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
              finish();
              continue;
            }
            str1 = ((y.b)localObject1).getString("key_package_name", "");
            localObject1 = ((y.b)localObject1).getString("key_package_signature", "");
            localObject2 = paramIntent.getStringExtra("key_package_name");
            str2 = paramIntent.getStringExtra("key_package_signature");
            ac.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[] { str1, localObject1, localObject2, str2 });
            y.ayq().xI("key_data_center_session_id");
            if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
            {
              ac.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
              finish();
              continue;
            }
          }
          com.tencent.mm.pluginsdk.f.a(this, localUri.toString(), i, parama, new f.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22266);
              ac.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
              if ((paramAnonymousn != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousn instanceof ab)))
              {
                paramAnonymousString = ((ab)paramAnonymousn).aHS();
                if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing())) {
                  t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(2131755906) + " : " + bs.nullAsNil(paramAnonymousString.FTm), 0).show();
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
        parama = u.axw();
        ac.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { localUri.toString() });
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
        ac.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, parama, localObject1 });
        if ((!bs.isNullOrNil(parama)) && (this.nnr.contains(parama)))
        {
          if ((parama.equals("cardpackage")) && (!bs.isNullOrNil(localUri.getQueryParameter("encrystr"))))
          {
            paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramIntent.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          if (parama.equals("connectToFreeWifi"))
          {
            if ((bs.isNullOrNil((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
              break label1185;
            }
            localObject2 = localUri.getQueryParameter("apKey");
            ac.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { localObject2 });
            str2 = localUri.getQueryParameter("ticket");
            if ((!bs.isNullOrNil((String)localObject2)) && (((String)localObject2).length() < 1024))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("free_wifi_schema_uri", localUri.toString());
              paramIntent.putExtra("free_wifi_ap_key", (String)localObject2);
              paramIntent.putExtra("free_wifi_source", 5);
              paramIntent.putExtra("free_wifi_threeone_startup_type", 1);
              if (!bs.isNullOrNil(str2)) {
                paramIntent.putExtra("free_wifi_schema_ticket", str2);
              }
              if ((!((String)localObject2).startsWith("_")) && (!bs.isNullOrNil(str2))) {
                break label1155;
              }
              paramIntent.addFlags(67108864);
              com.tencent.mm.br.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
            }
          }
          for (;;)
          {
            if ((!parama.equals("wap")) || (!localUri.toString().startsWith("weixin://wap/pay"))) {
              break label1239;
            }
            ac.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[] { str1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            com.tencent.mm.pluginsdk.wallet.f.a(this, com.tencent.mm.pluginsdk.e.a.aFS((String)localObject1), false, str1);
            break;
            localObject2 = new hr();
            ((hr)localObject2).diJ.intent = paramIntent;
            com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
            continue;
            if (localUri.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("key_connected_router", localUri.toString());
              com.tencent.mm.br.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", paramIntent);
              ac.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
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
    ac.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.nnr = new ArrayList();
    this.nnr.add("cardpackage");
    this.nnr.add("connectToFreeWifi");
    this.nnr.add("wap");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity
 * JD-Core Version:    0.7.0.1
 */