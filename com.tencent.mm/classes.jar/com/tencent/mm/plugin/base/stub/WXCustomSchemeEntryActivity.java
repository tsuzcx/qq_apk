package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.JgClassChecked;
import com.tencent.mm.R.i;
import com.tencent.mm.h.a.gl;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=50, fComment="checked", lastDate="20141016", reviewer=50, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> hSz;
  
  private String awf()
  {
    if (com.tencent.mm.compatible.util.d.gH(21)) {
      try
      {
        Object localObject = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
        ((Field)localObject).setAccessible(true);
        localObject = (String)((Field)localObject).get(this);
        return localObject;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", localException, "", new Object[0]);
        return "No referrer";
      }
    }
    return "";
  }
  
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    switch (WXCustomSchemeEntryActivity.5.hSj[parama.ordinal()])
    {
    }
    label921:
    for (;;)
    {
      finish();
      return;
      label562:
      label951:
      try
      {
        localUri = getIntent().getData();
        if (localUri == null) {
          continue;
        }
        if (localUri != null)
        {
          i = 2;
          if (paramIntent != null) {
            i = t.a(paramIntent, "translate_link_scene", 2);
          }
          int j = t.a(paramIntent, "pay_channel", -1);
          y.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          parama = null;
          if (j >= 0)
          {
            y.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", new Object[] { Integer.valueOf(j) });
            parama = new Bundle();
            parama.putInt("pay_channel", j);
          }
          str1 = awf();
          y.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", new Object[] { str1 });
          if (parama != null) {
            break label1008;
          }
          parama = new Bundle();
          parama.putString("pay_package", str1);
          if (!com.tencent.mm.pluginsdk.d.Vz(localUri.toString())) {
            break label562;
          }
          if (!com.tencent.mm.pluginsdk.d.j(localUri)) {
            break label318;
          }
          boolean bool = com.tencent.mm.pluginsdk.d.k(localUri);
          y.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { localUri.toString(), Boolean.valueOf(bool) });
          if (bool)
          {
            com.tencent.mm.pluginsdk.d.a(this, localUri.toString(), i, parama, new WXCustomSchemeEntryActivity.1(this));
            i = 1;
            if (i == 0) {
              continue;
            }
            return;
          }
        }
      }
      catch (Exception parama)
      {
        label318:
        label1006:
        label1008:
        for (;;)
        {
          int i;
          String str1;
          y.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { parama.getMessage() });
          Uri localUri = null;
          continue;
          com.tencent.mm.pluginsdk.d.a(this, localUri.toString(), i, parama, new WXCustomSchemeEntryActivity.2(this));
          for (;;)
          {
            i = 0;
            break;
            String str2;
            if (com.tencent.mm.pluginsdk.d.VA(localUri.toString()))
            {
              if (i == 1)
              {
                localObject1 = u.Hc().ih("key_data_center_session_id");
                if (localObject1 == null)
                {
                  y.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                  finish();
                  continue;
                }
                str1 = ((u.b)localObject1).getString("key_package_name", "");
                localObject1 = ((u.b)localObject1).getString("key_package_signature", "");
                localObject2 = paramIntent.getStringExtra("key_package_name");
                str2 = paramIntent.getStringExtra("key_package_signature");
                y.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[] { str1, localObject1, localObject2, str2 });
                u.Hc().ii("key_data_center_session_id");
                if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
                {
                  y.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                  finish();
                  continue;
                }
              }
              com.tencent.mm.pluginsdk.d.a(this, localUri.toString(), i, parama, new WXCustomSchemeEntryActivity.3(this), paramIntent.getStringExtra("key_package_name"), paramIntent.getStringExtra("key_package_signature"));
              i = 1;
              break;
            }
            parama = q.Gj();
            y.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { localUri.toString() });
            com.tencent.mm.pluginsdk.d.a(this, localUri.toString(), parama, 23, localUri.toString(), new WXCustomSchemeEntryActivity.4(this));
            continue;
            Object localObject2 = localUri.getScheme();
            parama = localUri.getHost();
            Object localObject1 = localUri.getQuery();
            y.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, parama, localObject1 });
            if ((!bk.bl(parama)) && (this.hSz.contains(parama)))
            {
              if ((parama.equals("cardpackage")) && (!bk.bl(localUri.getQueryParameter("encrystr"))))
              {
                paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                startActivity(paramIntent);
              }
              if (parama.equals("connectToFreeWifi"))
              {
                if ((bk.bl((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
                  break label951;
                }
                localObject2 = localUri.getQueryParameter("apKey");
                y.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { localObject2 });
                str2 = localUri.getQueryParameter("ticket");
                if ((!bk.bl((String)localObject2)) && (((String)localObject2).length() < 1024))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("free_wifi_schema_uri", localUri.toString());
                  paramIntent.putExtra("free_wifi_ap_key", (String)localObject2);
                  paramIntent.putExtra("free_wifi_source", 5);
                  paramIntent.putExtra("free_wifi_threeone_startup_type", 1);
                  if (!bk.bl(str2)) {
                    paramIntent.putExtra("free_wifi_schema_ticket", str2);
                  }
                  if ((!((String)localObject2).startsWith("_")) && (!bk.bl(str2))) {
                    break label921;
                  }
                  paramIntent.addFlags(67108864);
                  com.tencent.mm.br.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
                }
              }
              for (;;)
              {
                if ((!parama.equals("wap")) || (!localUri.toString().startsWith("weixin://wap/pay"))) {
                  break label1006;
                }
                y.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[] { str1 });
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                h.a(this, com.tencent.mm.pluginsdk.e.a.VI((String)localObject1), false, str1);
                break;
                localObject2 = new gl();
                ((gl)localObject2).bOk.intent = paramIntent;
                com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
                continue;
                if (localUri.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("key_connected_router", localUri.toString());
                  com.tencent.mm.br.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", paramIntent);
                  y.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.biz_share_check;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.hSz = new ArrayList();
    this.hSz.add("cardpackage");
    this.hSz.add("connectToFreeWifi");
    this.hSz.add("wap");
    super.onCreate(paramBundle);
    setTitleVisibility(0);
  }
  
  protected final boolean w(Intent paramIntent)
  {
    try
    {
      paramIntent = getIntent().getData();
      if (paramIntent != null) {
        if (com.tencent.mm.pluginsdk.d.Vz(paramIntent.toString())) {
          return true;
        }
      }
    }
    catch (Exception paramIntent)
    {
      String str1;
      String str2;
      do
      {
        String str3;
        do
        {
          for (;;)
          {
            y.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { paramIntent.getMessage() });
            paramIntent = null;
          }
          str3 = paramIntent.getScheme();
          str1 = paramIntent.getHost();
          str2 = paramIntent.getQuery();
          y.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { paramIntent.toString(), str3, str1, str2 });
          if ((bk.bl(str1)) || (!this.hSz.contains(str1))) {
            break label312;
          }
          y.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { str1 });
          if (!str1.equals("cardpackage")) {
            break;
          }
          str3 = paramIntent.getQueryParameter("encrystr");
          y.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str3 });
        } while ((!bk.bl(str3)) && (str3.length() < 1024));
        if (!str1.equals("connectToFreeWifi")) {
          break;
        }
        if ((bk.bl(str2)) || (!str2.startsWith("apKey=")) || (str2.length() <= 6)) {
          break label297;
        }
        str2 = str2.substring(6);
        y.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str2 });
      } while ((!bk.bl(str2)) && (str2.length() < 1024));
      while ((str1.equals("wap")) && (paramIntent.toString().startsWith("weixin://wap/pay")))
      {
        y.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
        return true;
        label297:
        if (paramIntent.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
          return true;
        }
      }
      label312:
      finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity
 * JD-Core Version:    0.7.0.1
 */