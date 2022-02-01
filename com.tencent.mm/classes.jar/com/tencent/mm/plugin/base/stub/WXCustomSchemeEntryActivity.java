package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.kf;
import com.tencent.mm.autogen.a.rt;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> vss;
  
  private String dal()
  {
    AppMethodBeat.i(22272);
    if (d.rd(21)) {
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
    switch (WXCustomSchemeEntryActivity.7.vrD[parama.ordinal()])
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
        localUri = Uri.parse(com.tencent.mm.pluginsdk.g.boS(localUri.toString()));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Uri localUri;
          Log.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { localException.getMessage() });
          locala = parama;
        }
        if (!((Boolean)com.tencent.mm.pluginsdk.wallet.g.iOZ().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue()) {
          break;
        }
        k.a(this, getString(R.l.wallet_is_paying_tips), "", getString(R.l.button_ok), new DialogInterface.OnClickListener()
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
        parama = new rt();
        parama.hUN.ret = 1;
        parama.publish();
        if (locala == null) {
          break label523;
        }
      }
    } while (localUri == null);
    u.q(this, localUri.toString());
    if (!((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      k.a(this, getString(R.l.wallet_is_paying_tips), "", getString(R.l.button_ok), new DialogInterface.OnClickListener()
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
    String str1 = dal();
    Object localObject1 = u.cF(this, str1);
    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName：" + str1 + "  signature：" + (String)localObject1);
    if (parama == null) {
      parama = new Bundle();
    }
    for (;;)
    {
      parama.putString("pay_package", str1);
      if (com.tencent.mm.pluginsdk.g.boT(locala.toString())) {
        if (com.tencent.mm.pluginsdk.g.p(locala))
        {
          boolean bool = com.tencent.mm.pluginsdk.g.q(locala);
          Log.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { locala.toString(), Boolean.valueOf(bool) });
          if (bool)
          {
            com.tencent.mm.pluginsdk.g.a(this, locala.toString(), i, parama, new g.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(22264);
                Log.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
                {
                  paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                  if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing()) && (!Util.isNullOrNil(paramAnonymousString.abQg))) {
                    aa.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.l.app_tip) + " : " + Util.nullAsNil(paramAnonymousString.abQg), 0).show();
                  }
                }
                WXCustomSchemeEntryActivity.this.finish();
                AppMethodBeat.o(22264);
              }
            }, str1, (String)localObject1);
            i = 1;
            label489:
            if (i == 0) {
              break label730;
            }
            AppMethodBeat.o(22271);
            return;
          }
          com.tencent.mm.pluginsdk.g.a(this, locala.toString(), i, parama, new g.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22265);
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22265);
            }
          }, str1, (String)localObject1);
        }
      }
      label1281:
      for (;;)
      {
        label523:
        i = 0;
        break label489;
        String str2;
        if (com.tencent.mm.pluginsdk.g.boU(locala.toString()))
        {
          if (i == 1)
          {
            localObject1 = com.tencent.mm.model.ad.bCb().Jm("key_data_center_session_id");
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
            com.tencent.mm.model.ad.bCb().Jn("key_data_center_session_id");
            if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
            {
              Log.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
              finish();
              continue;
            }
          }
          com.tencent.mm.pluginsdk.g.a(this, locala.toString(), i, parama, new g.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22266);
              Log.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
              if ((paramAnonymousp != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousp instanceof com.tencent.mm.modelsimple.ad)))
              {
                paramAnonymousString = ((com.tencent.mm.modelsimple.ad)paramAnonymousp).bMA();
                if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing()) && (!Util.isNullOrNil(paramAnonymousString.abQg))) {
                  aa.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.l.app_tip) + " : " + Util.nullAsNil(paramAnonymousString.abQg), 0).show();
                }
              }
              WXCustomSchemeEntryActivity.this.finish();
              AppMethodBeat.o(22266);
            }
          }, paramIntent.getStringExtra("key_package_name"), paramIntent.getStringExtra("key_package_signature"));
          i = 1;
          break label489;
          label730:
          break;
        }
        parama = z.bAM();
        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { locala.toString() });
        com.tencent.mm.pluginsdk.g.a(this, locala.toString(), parama, 23, locala.toString(), new g.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(22267);
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.o(22267);
          }
        });
        continue;
        Object localObject2 = locala.getScheme();
        parama = locala.getHost();
        localObject1 = locala.getQuery();
        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, parama, localObject1 });
        if ((!Util.isNullOrNil(parama)) && (this.vss.contains(parama)))
        {
          if ((parama.equals("cardpackage")) && (!Util.isNullOrNil(locala.getQueryParameter("encrystr"))))
          {
            paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramIntent.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity", "handleDeepLinkPostLogin", "(Landroid/net/Uri;Landroid/content/Intent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          if (parama.equals("connectToFreeWifi"))
          {
            if ((Util.isNullOrNil((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
              break label1226;
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
                break label1199;
              }
              Log.w("MicroMsg.WXCustomSchemeEntryActivity", "freewifi had Deprecated");
            }
          }
          for (;;)
          {
            if ((!parama.equals("wap")) || (!locala.toString().startsWith("weixin://wap/pay"))) {
              break label1281;
            }
            Log.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[] { str1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            f.a(this, com.tencent.mm.pluginsdk.f.a.bpd((String)localObject1), false, str1);
            break;
            label1199:
            localObject2 = new kf();
            ((kf)localObject2).hLP.intent = paramIntent;
            ((kf)localObject2).publish();
            continue;
            label1226:
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
  
  public final boolean ad(Intent paramIntent)
  {
    AppMethodBeat.i(22270);
    try
    {
      paramIntent = getIntent().getData();
      localObject = paramIntent;
      if (paramIntent != null) {
        localObject = Uri.parse(com.tencent.mm.pluginsdk.g.boS(paramIntent.toString()));
      }
      if (localObject != null) {
        if (com.tencent.mm.pluginsdk.g.boT(((Uri)localObject).toString()))
        {
          AppMethodBeat.o(22270);
          return true;
        }
      }
    }
    catch (Exception paramIntent)
    {
      Object localObject;
      for (;;)
      {
        Log.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { paramIntent.getMessage() });
        paramIntent = null;
      }
      String str2 = ((Uri)localObject).getScheme();
      paramIntent = ((Uri)localObject).getHost();
      String str1 = ((Uri)localObject).getQuery();
      Log.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { ((Uri)localObject).toString(), str2, paramIntent, str1 });
      if ((!Util.isNullOrNil(paramIntent)) && (this.vss.contains(paramIntent)))
      {
        Log.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { paramIntent });
        if (paramIntent.equals("cardpackage"))
        {
          str2 = ((Uri)localObject).getQueryParameter("encrystr");
          Log.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str2 });
          if ((!Util.isNullOrNil(str2)) && (str2.length() < 1024))
          {
            AppMethodBeat.o(22270);
            return true;
          }
        }
        if (paramIntent.equals("connectToFreeWifi")) {
          if ((!Util.isNullOrNil(str1)) && (str1.startsWith("apKey=")) && (str1.length() > 6))
          {
            str1 = str1.substring(6);
            Log.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str1 });
            if ((!Util.isNullOrNil(str1)) && (str1.length() < 1024))
            {
              AppMethodBeat.o(22270);
              return true;
            }
          }
          else if (((Uri)localObject).toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
          {
            AppMethodBeat.o(22270);
            return true;
          }
        }
        if ((paramIntent.equals("wap")) && (((Uri)localObject).toString().startsWith("weixin://wap/pay")))
        {
          Log.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
          AppMethodBeat.o(22270);
          return true;
        }
      }
      finish();
      AppMethodBeat.o(22270);
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return R.i.geK;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22269);
    Log.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.vss = new ArrayList();
    this.vss.add("cardpackage");
    this.vss.add("connectToFreeWifi");
    this.vss.add("wap");
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