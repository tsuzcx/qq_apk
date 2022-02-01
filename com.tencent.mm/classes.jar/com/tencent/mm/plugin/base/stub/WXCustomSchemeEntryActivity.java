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
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=50, fComment="checked", lastDate="20141016", reviewer=50, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> pex;
  
  private String ckg()
  {
    AppMethodBeat.i(22272);
    if (d.oF(21)) {
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
        Log.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", localException, "", new Object[0]);
        AppMethodBeat.o(22272);
        return "No referrer";
      }
    }
    AppMethodBeat.o(22272);
    return "";
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(22271);
    switch (WXCustomSchemeEntryActivity.7.pdF[parama.ordinal()])
    {
    }
    do
    {
      finish();
      AppMethodBeat.o(22271);
      return;
      parama = null;
      try
      {
        localUri = getIntent().getData();
        parama = localUri;
        localUri = Uri.parse(com.tencent.mm.pluginsdk.g.bcY(localUri.toString()));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Uri localUri;
          Log.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { localException.getMessage() });
          locala = parama;
        }
        if (!((Boolean)com.tencent.mm.pluginsdk.wallet.g.gsU().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue()) {
          break;
        }
        h.a(this, getString(2131767779), "", getString(2131756920), new DialogInterface.OnClickListener()
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
        parama = new pi();
        parama.dVr.ret = 1;
        EventCenter.instance.publish(parama);
        if (locala == null) {
          break label489;
        }
      }
    } while (localUri == null);
    com.tencent.mm.pluginsdk.model.app.q.n(this, localUri.toString());
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      h.a(this, getString(2131767779), "", getString(2131756920), new DialogInterface.OnClickListener()
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
    AutoLoginActivity.a locala;
    int i = 2;
    if (paramIntent != null) {
      i = IntentUtil.getIntExtra(paramIntent, "translate_link_scene", 2);
    }
    int j = IntentUtil.getIntExtra(paramIntent, "pay_channel", -1);
    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    parama = null;
    if (j >= 0)
    {
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", new Object[] { Integer.valueOf(j) });
      parama = new Bundle();
      parama.putInt("pay_channel", j);
    }
    String str1 = ckg();
    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", new Object[] { str1 });
    if (parama == null) {
      parama = new Bundle();
    }
    label696:
    for (;;)
    {
      parama.putString("pay_package", str1);
      if (com.tencent.mm.pluginsdk.g.bcZ(locala.toString())) {
        if (com.tencent.mm.pluginsdk.g.w(locala))
        {
          boolean bool = com.tencent.mm.pluginsdk.g.x(locala);
          Log.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { locala.toString(), Boolean.valueOf(bool) });
          if (bool)
          {
            com.tencent.mm.pluginsdk.g.a(this, locala.toString(), i, parama, new g.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22264);
                Log.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
                {
                  paramAnonymousString = ((ac)paramAnonymousq).bfD();
                  if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing()) && (!Util.isNullOrNil(paramAnonymousString.NjR))) {
                    u.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(2131755998) + " : " + Util.nullAsNil(paramAnonymousString.NjR), 0).show();
                  }
                }
                WXCustomSchemeEntryActivity.this.finish();
                AppMethodBeat.o(22264);
              }
            });
            i = 1;
            label459:
            if (i == 0) {
              break label696;
            }
            AppMethodBeat.o(22271);
            return;
          }
          com.tencent.mm.pluginsdk.g.a(this, locala.toString(), i, parama, new g.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22265);
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22265);
            }
          });
        }
      }
      label489:
      label1261:
      for (;;)
      {
        i = 0;
        break label459;
        String str2;
        if (com.tencent.mm.pluginsdk.g.bda(locala.toString()))
        {
          if (i == 1)
          {
            localObject1 = ad.aVe().JV("key_data_center_session_id");
            if (localObject1 == null)
            {
              Log.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
              finish();
              continue;
            }
            str1 = ((ad.b)localObject1).getString("key_package_name", "");
            localObject1 = ((ad.b)localObject1).getString("key_package_signature", "");
            localObject2 = paramIntent.getStringExtra("key_package_name");
            str2 = paramIntent.getStringExtra("key_package_signature");
            Log.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[] { str1, localObject1, localObject2, str2 });
            ad.aVe().JW("key_data_center_session_id");
            if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
            {
              Log.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
              finish();
              continue;
            }
          }
          com.tencent.mm.pluginsdk.g.a(this, locala.toString(), i, parama, new g.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22266);
              Log.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
              if ((paramAnonymousq != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousq instanceof ac)))
              {
                paramAnonymousString = ((ac)paramAnonymousq).bfD();
                if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing()) && (!Util.isNullOrNil(paramAnonymousString.NjR))) {
                  u.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(2131755998) + " : " + Util.nullAsNil(paramAnonymousString.NjR), 0).show();
                }
              }
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22266);
            }
          }, paramIntent.getStringExtra("key_package_name"), paramIntent.getStringExtra("key_package_signature"));
          i = 1;
          break label459;
          break;
        }
        parama = z.aTY();
        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { locala.toString() });
        com.tencent.mm.pluginsdk.g.a(this, locala.toString(), parama, 23, locala.toString(), new g.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(22267);
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.o(22267);
          }
        });
        continue;
        Object localObject2 = locala.getScheme();
        parama = locala.getHost();
        Object localObject1 = locala.getQuery();
        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, parama, localObject1 });
        if ((!Util.isNullOrNil(parama)) && (this.pex.contains(parama)))
        {
          if ((parama.equals("cardpackage")) && (!Util.isNullOrNil(locala.getQueryParameter("encrystr"))))
          {
            paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramIntent.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          if (parama.equals("connectToFreeWifi"))
          {
            if ((Util.isNullOrNil((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
              break label1206;
            }
            localObject2 = locala.getQueryParameter("apKey");
            Log.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { localObject2 });
            str2 = locala.getQueryParameter("ticket");
            if ((!Util.isNullOrNil((String)localObject2)) && (((String)localObject2).length() < 1024))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("free_wifi_schema_uri", locala.toString());
              paramIntent.putExtra("free_wifi_ap_key", (String)localObject2);
              paramIntent.putExtra("free_wifi_source", 5);
              paramIntent.putExtra("free_wifi_threeone_startup_type", 1);
              if (!Util.isNullOrNil(str2)) {
                paramIntent.putExtra("free_wifi_schema_ticket", str2);
              }
              if ((!((String)localObject2).startsWith("_")) && (!Util.isNullOrNil(str2))) {
                break label1176;
              }
              paramIntent.addFlags(67108864);
              c.b(this, "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
            }
          }
          for (;;)
          {
            if ((!parama.equals("wap")) || (!locala.toString().startsWith("weixin://wap/pay"))) {
              break label1261;
            }
            Log.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[] { str1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            f.a(this, com.tencent.mm.pluginsdk.e.a.bdk((String)localObject1), false, str1);
            break;
            localObject2 = new io();
            ((io)localObject2).dNh.intent = paramIntent;
            EventCenter.instance.publish((IEvent)localObject2);
            continue;
            if (locala.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
            {
              paramIntent = new Intent();
              paramIntent.putExtra("key_connected_router", locala.toString());
              c.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", paramIntent);
              Log.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
            }
          }
        }
      }
    }
  }
  
  public final boolean ab(Intent paramIntent)
  {
    AppMethodBeat.i(22270);
    paramIntent = null;
    try
    {
      Uri localUri = getIntent().getData();
      paramIntent = localUri;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { localException.getMessage() });
      }
      String str3 = paramIntent.getScheme();
      String str1 = paramIntent.getHost();
      String str2 = paramIntent.getQuery();
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { paramIntent.toString(), str3, str1, str2 });
      if ((Util.isNullOrNil(str1)) || (!this.pex.contains(str1))) {
        break label365;
      }
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { str1 });
      if (!str1.equals("cardpackage")) {
        break label221;
      }
      str3 = paramIntent.getQueryParameter("encrystr");
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str3 });
      if ((Util.isNullOrNil(str3)) || (str3.length() >= 1024)) {
        break label221;
      }
      AppMethodBeat.o(22270);
      return true;
      label221:
      if (!str1.equals("connectToFreeWifi")) {
        break label326;
      }
      if ((Util.isNullOrNil(str2)) || (!str2.startsWith("apKey=")) || (str2.length() <= 6)) {
        break label305;
      }
      str2 = str2.substring(6);
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str2 });
      if ((Util.isNullOrNil(str2)) || (str2.length() >= 1024)) {
        break label326;
      }
      AppMethodBeat.o(22270);
      return true;
      label305:
      if (!paramIntent.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
        break label326;
      }
      AppMethodBeat.o(22270);
      return true;
      label326:
      if ((!str1.equals("wap")) || (!paramIntent.toString().startsWith("weixin://wap/pay"))) {
        break label365;
      }
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
      AppMethodBeat.o(22270);
      return true;
      label365:
      finish();
      AppMethodBeat.o(22270);
    }
    paramIntent = Uri.parse(com.tencent.mm.pluginsdk.g.bcY(paramIntent.toString()));
    if (paramIntent != null) {
      if (com.tencent.mm.pluginsdk.g.bcZ(paramIntent.toString()))
      {
        AppMethodBeat.o(22270);
        return true;
      }
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493246;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22269);
    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.pex = new ArrayList();
    this.pex.add("cardpackage");
    this.pex.add("connectToFreeWifi");
    this.pex.add("wap");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity
 * JD-Core Version:    0.7.0.1
 */