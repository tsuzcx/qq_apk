package com.tencent.mm.plugin.ag.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.f.a.ju;
import com.tencent.mm.f.a.ju.b;
import com.tencent.mm.f.a.pj;
import com.tencent.mm.f.a.un;
import com.tencent.mm.f.a.uo;
import com.tencent.mm.f.a.up;
import com.tencent.mm.f.b.a.qt;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.util.r.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.f.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final SparseIntArray Hsk;
  private static final SparseIntArray Hsl;
  private static final SparseIntArray Hsm;
  
  static
  {
    AppMethodBeat.i(51552);
    Hsk = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51545);
        paramAnonymousInt = super.get(paramAnonymousInt, 1011);
        AppMethodBeat.o(51545);
        return paramAnonymousInt;
      }
    };
    Hsl = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51547);
        paramAnonymousInt = super.get(paramAnonymousInt, 1047);
        AppMethodBeat.o(51547);
        return paramAnonymousInt;
      }
    };
    Hsm = new SparseIntArray()
    {
      public final int get(int paramAnonymousInt)
      {
        AppMethodBeat.i(51549);
        paramAnonymousInt = super.get(paramAnonymousInt, 1124);
        AppMethodBeat.o(51549);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(51552);
  }
  
  private static void a(Intent paramIntent, l paraml)
  {
    AppMethodBeat.i(292723);
    if (paraml.bAm() != null) {
      paramIntent.putExtra("scan_jspermission", new JsapiPermissionWrapper(paraml.bAm().SZd));
    }
    paramIntent.putExtra("scan_general_ctrl", new GeneralControlWrapper(paraml.bAm()));
    AppMethodBeat.o(292723);
  }
  
  private static void a(a parama, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(51551);
    Log.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    if (parama != null) {}
    for (Context localContext = parama.getContext(); localContext == null; localContext = null)
    {
      AppMethodBeat.o(51551);
      return;
    }
    final ju localju = new ju();
    localju.fHe.actionCode = paramInt1;
    localju.fHe.result = paramString;
    localju.fHe.context = localContext;
    paramString = new Bundle();
    paramString.putInt("pay_channel", paramInt2);
    localju.fHe.fHg = paramString;
    localju.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51543);
        if ((this.Hsr == null) || (localju == null) || (localju.fHf == null))
        {
          AppMethodBeat.o(51543);
          return;
        }
        if (localju.fHf.ret == 1)
        {
          this.Hsr.wo(true);
          AppMethodBeat.o(51543);
          return;
        }
        if (localju.fHf.ret == 2) {
          this.Hsr.wo(false);
        }
        AppMethodBeat.o(51543);
      }
    };
    EventCenter.instance.asyncPublish(localju, Looper.myLooper());
    AppMethodBeat.o(51551);
  }
  
  public static boolean a(a parama, final l paraml, DialogInterface.OnClickListener paramOnClickListener, String paramString, final int paramInt1, final int paramInt2, Runnable paramRunnable, Bundle paramBundle)
  {
    AppMethodBeat.i(51550);
    final Context localContext = parama.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
      AppMethodBeat.o(51550);
      return false;
    }
    int i = paraml.boh();
    int j = ((bos)d.b.b(paraml.rr.lBR)).Sks;
    Log.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Log.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(paramInt1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("geta8key_scene", paramInt1);
    localIntent.putExtra("KPublisherId", "qrcode");
    localIntent.putExtra("prePublishId", "qrcode");
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(abT(paramInt1));
    boolean bool;
    switch (i)
    {
    case 5: 
    case 13: 
    case 19: 
    case 27: 
    case 28: 
    case 29: 
    case 31: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 44: 
    default: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + paraml.boh());
      AppMethodBeat.o(51550);
      return false;
    case 1: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + paraml.getContent());
      ((com.tencent.mm.plugin.expt.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.a.class)).awb(paraml.getContent());
      localIntent.putExtra("data", paraml.getContent());
      localIntent.putExtra("showShare", false);
      if (paramInt2 == 2) {
        localIntent.putExtra("stastic_scene", 13);
      }
      for (;;)
      {
        localIntent.putExtra("pay_channel", abT(paramInt1));
        localIntent.putExtra("geta8key_session_id", paraml.bon());
        a(localIntent, paraml);
        com.tencent.mm.plugin.scanner.m.cYL().h(localIntent, localContext);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        if (paramInt2 == 1) {
          localIntent.putExtra("stastic_scene", 14);
        } else {
          localIntent.putExtra("stastic_scene", 11);
        }
      }
    case 2: 
      Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + paraml.bof());
      i = l.i.IEG;
      if (!Util.isNullOrNil(paramString)) {}
      for (;;)
      {
        com.tencent.mm.ui.base.h.a(localContext, localContext.getString(i, new Object[] { paramString }), localContext.getString(l.i.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(51538);
            this.val$intent.putExtra("title", paraml.getTitle());
            this.val$intent.putExtra("rawUrl", paraml.bof());
            if (paramInt2 == 2) {
              this.val$intent.putExtra("stastic_scene", 13);
            }
            for (;;)
            {
              this.val$intent.putExtra("pay_channel", a.abT(paramInt1));
              this.val$intent.putExtra("geta8key_session_id", paraml.bon());
              this.val$intent.putExtra("geta8key_cookie", paraml.bop());
              this.val$intent.putExtra("key_enable_teen_mode_check", true);
              a.b(this.val$intent, paraml);
              com.tencent.mm.plugin.scanner.m.cYL().h(this.val$intent, localContext);
              AppMethodBeat.o(51538);
              return;
              if (paramInt2 == 1) {
                this.val$intent.putExtra("stastic_scene", 14);
              } else {
                this.val$intent.putExtra("stastic_scene", 11);
              }
            }
          }
        }, paramOnClickListener);
        AppMethodBeat.o(51550);
        return true;
        paramString = paraml.bof();
      }
    case 7: 
    case 30: 
      Log.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[] { paraml.bog(), paraml.bof(), paraml.boj() });
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vzL, 0) == 1) {
        bool = true;
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.scanner.GetA8KeyRedirect", "webViewUseOuterGetA8key:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
      try
      {
        parama = (bot)d.c.b(paraml.rr.lBS);
        localIntent.putExtra("key_scan_qr_code_get_a8key_req", ((bos)d.b.b(paraml.rr.lBR)).toByteArray());
        localIntent.putExtra("key_scan_qr_code_get_a8key_resp", parama.toByteArray());
        localIntent.putExtra("title", paraml.getTitle());
        localIntent.putExtra("rawUrl", paraml.bof());
        localIntent.putExtra("k_share_url", paraml.boj());
        if (paramInt2 == 2) {
          localIntent.putExtra("stastic_scene", 13);
        }
        Object localObject1;
        for (;;)
        {
          Log.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(abT(paramInt1))));
          localIntent.putExtra("pay_channel", abT(paramInt1));
          localIntent.putExtra("geta8key_session_id", paraml.bon());
          localIntent.putExtra("geta8key_cookie", paraml.bop());
          parama = paraml.bom();
          if (Util.isNullOrNil(parama)) {
            break label1172;
          }
          paramOnClickListener = parama.iterator();
          do
          {
            if (!paramOnClickListener.hasNext()) {
              break;
            }
            localObject1 = (ckf)paramOnClickListener.next();
          } while ((localObject1 != null) && (!Util.isNullOrNil(((ckf)localObject1).CRg)) && (!Util.isNullOrNil(((ckf)localObject1).Izj)));
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label1172;
          }
          paramOnClickListener = new String[parama.size()];
          localObject1 = new String[parama.size()];
          paramInt1 = 0;
          while (paramInt1 < parama.size())
          {
            Object localObject2 = (ckf)parama.get(paramInt1);
            String str = ((ckf)localObject2).CRg;
            localObject2 = ((ckf)localObject2).Izj;
            Log.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject2 });
            paramOnClickListener[paramInt1] = str;
            localObject1[paramInt1] = localObject2;
            paramInt1 += 1;
          }
          bool = false;
          break;
          if (paramInt2 == 1) {
            localIntent.putExtra("stastic_scene", 14);
          } else {
            localIntent.putExtra("stastic_scene", 11);
          }
        }
        localIntent.putExtra("geta8key_result_http_header_key_list", paramOnClickListener);
        localIntent.putExtra("geta8key_result_http_header_value_list", (String[])localObject1);
        localIntent.putExtra("k_has_http_header", true);
        label1172:
        if ((i == 30) && (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vyV, 1) == 1))
        {
          localIntent.putExtra("auth_raw_url", paramString);
          localIntent.putExtra("auth_from_scan", true);
          com.tencent.mm.by.c.b(localContext, "webview", ".ui.tools.SDKOAuthUI", localIntent);
          new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
          AppMethodBeat.o(51550);
          return true;
        }
        if ((paramBundle != null) && (paramBundle.getString("stat_send_msg_user") != null)) {
          localIntent.putExtra(f.r.VSV, paramBundle.getString("stat_send_msg_user"));
        }
        localIntent.putExtra("key_enable_teen_mode_check", true);
        a(localIntent, paraml);
        com.tencent.mm.plugin.scanner.m.cYL().h(localIntent, localContext);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + paraml.bof());
        localIntent.putExtra("rawUrl", paraml.bof());
        localIntent.putExtra("pay_channel", abT(paramInt1));
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("isWebwx", false);
        localIntent.putExtra("geta8key_session_id", paraml.bon());
        localIntent.putExtra("geta8key_cookie", paraml.bop());
        localIntent.putExtra("key_enable_teen_mode_check", true);
        a(localIntent, paraml);
        com.tencent.mm.plugin.scanner.m.cYL().h(localIntent, localContext);
        AppMethodBeat.o(51550);
        return true;
        AppMethodBeat.o(51550);
        return false;
        paraml = paraml.bof();
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(paraml)));
        if ((paraml == null) || (paraml.length() == 0))
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
          AppMethodBeat.o(51550);
          return false;
        }
        parama = localContext.getString(l.i.IEF);
        if (paraml.startsWith("http")) {
          parama = localContext.getString(l.i.IEG, new Object[] { paraml });
        }
        paraml = Uri.parse(paraml);
        if (paraml != null)
        {
          paraml = new Intent("android.intent.action.VIEW", paraml);
          paraml.addFlags(268435456);
          if (Util.isIntentAvailable(localContext, paraml))
          {
            com.tencent.mm.ui.base.h.a(localContext, parama, localContext.getString(l.i.app_tip), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(51539);
                if (this.val$context != null)
                {
                  paramAnonymousDialogInterface = this.val$context;
                  Object localObject = paraml;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                AppMethodBeat.o(51539);
              }
            }, paramOnClickListener);
            AppMethodBeat.o(51550);
            return true;
          }
        }
        AppMethodBeat.o(51550);
        return false;
        paraml = paraml.getContent();
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(paraml)));
        if (!Util.isNullOrNil(paraml)) {
          paramString = new ak();
        }
        try
        {
          paramString.aXl(paraml);
          paramString = new Intent(localContext, VcardContactUI.class);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, paramString.aFh(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.wo(false);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (XmlPullParserException parama)
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + parama.getMessage() + " " + paraml);
          Log.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", parama, "", new Object[0]);
          com.tencent.mm.ui.base.h.a(localContext, localContext.getString(l.i.IEI), localContext.getString(l.i.app_tip), false, paramOnClickListener);
          AppMethodBeat.o(51550);
          return true;
        }
        catch (IOException parama)
        {
          for (;;)
          {
            Log.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + parama.getMessage() + " " + paraml);
            Log.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", parama, "", new Object[0]);
          }
        }
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + paraml.bof());
        f.a(localContext, 1, paraml.bof(), abT(paramInt1), null);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        parama = new Bundle();
        parama.putInt("key_scene", 5);
        bool = com.tencent.mm.plugin.scanner.m.cYL().b(localContext, paraml.bof(), parama);
        AppMethodBeat.o(51550);
        return bool;
        a(parama, i, paraml.bof(), abT(paramInt1));
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        a(parama, i, paraml.bof(), abT(paramInt1));
        AppMethodBeat.o(51550);
        return true;
        if (paramString.contains("livescreencast"))
        {
          parama = paramString.split("ticket_s=")[1];
          paraml = new up();
          paraml.fTS.fAo = parama;
          EventCenter.instance.publish(paraml);
          new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
          AppMethodBeat.o(51550);
          return true;
        }
        AppMethodBeat.o(51550);
        return false;
        paraml = paraml.bof();
        parama = paraml;
        if (paraml != null) {
          parama = paraml.replace("wxpd://", "");
        }
        paraml = new Intent();
        paraml.putExtra("key_product_id", parama);
        paraml.putExtra("key_product_scene", 7);
        com.tencent.mm.by.c.b(localContext, "product", ".ui.MallProductUI", paraml);
        AppMethodBeat.o(51550);
        return true;
        parama = new Intent();
        parama.setClass(localContext, ProductUI.class);
        parama.putExtra("key_ProductUI_getProductInfoScene", 5);
        parama.putExtra("key_Qrcode_Url", paraml.bof());
        if (localContext != null)
        {
          parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, parama.aFh(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)parama.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.bof();
        parama = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
        paraml = Util.createExplicitFromImplicitIntent(MMApplicationContext.getContext(), parama);
        if (paraml != null) {
          parama = paraml;
        }
        for (;;)
        {
          com.tencent.mm.by.c.startService(parama.putExtra("url", paramOnClickListener).putExtra("isFromWifi", true));
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
          AppMethodBeat.o(51550);
          return true;
        }
        parama = r.aXD(paraml.bof());
        if (parama == null) {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if (r.HH(parama.qJt)) {
            break;
          }
          if (localContext != null) {
            r.bI(localContext, localContext.getString(l.i.card_not_support_card_type));
          }
        }
        paraml = new Intent();
        paraml.putExtra("key_card_id", parama.tnX);
        paraml.putExtra("key_card_ext", parama.fUM);
        paraml.putExtra("key_from_scene", 0);
        if (paramInt2 == 2) {
          paraml.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          com.tencent.mm.by.c.b(localContext, "card", ".ui.CardDetailUI", paraml);
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paraml.putExtra("key_stastic_scene", 14);
          } else {
            paraml.putExtra("key_stastic_scene", 11);
          }
        }
        parama = paraml.bof();
        paraml = r.aXE(parama);
        if ((paraml == null) || (paraml.size() == 0)) {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
        }
        for (;;)
        {
          AppMethodBeat.o(51550);
          return false;
          if ((r.ba(paraml)) || (localContext == null)) {
            break;
          }
          r.bI(localContext, localContext.getString(l.i.card_not_support_card_type));
        }
        paraml = new Intent();
        paraml.putExtra("key_from_scene", 0);
        paraml.putExtra("src_username", "");
        paraml.putExtra("js_url", "");
        paraml.putExtra("key_in_card_list", parama);
        if (paramInt2 == 2) {
          paraml.putExtra("key_stastic_scene", 13);
        }
        for (;;)
        {
          com.tencent.mm.by.c.b(localContext, "card", ".ui.CardAddEntranceUI", paraml);
          Log.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
          break;
          if (paramInt2 == 1) {
            paraml.putExtra("key_stastic_scene", 14);
          } else {
            paraml.putExtra("key_stastic_scene", 11);
          }
        }
        Log.w("MicroMsg.scanner.GetA8KeyRedirect", "freewifi had Deprecated");
        AppMethodBeat.o(51550);
        return true;
        Log.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + paraml.bof());
        parama = new com.tencent.mm.at.c(paraml.bof());
        com.tencent.mm.kernel.h.aGY().a(parama, 0);
        AppMethodBeat.o(51550);
        return true;
        if (!WeChatBrands.Business.Entries.DiscoveryScanExtDevice.checkAvailable(localContext, new androidx.core.f.a() {}))
        {
          AppMethodBeat.o(51550);
          return true;
        }
        parama = new un();
        parama.fTP.fTQ = paramString;
        EventCenter.instance.publish(parama);
        AppMethodBeat.o(51550);
        return true;
        parama = new uo();
        parama.fTR.fTQ = paramString;
        parama.fTR.deviceName = com.tencent.mm.protocal.d.RAB;
        EventCenter.instance.publish(parama);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        AppMethodBeat.o(51550);
        return true;
        parama = paraml.bof();
        if (Util.isNullOrNil(parama))
        {
          Log.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
          AppMethodBeat.o(51550);
          return true;
        }
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[] { parama });
        paraml = new ad();
        paraml.fvG.url = parama;
        EventCenter.instance.publish(paraml);
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
        AppMethodBeat.o(51550);
        return true;
        paramOnClickListener = paraml.bof();
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paramRunnable = paraml.lZf;
        paramRunnable.putLong("CgiSpeedOutSideStructResponseSize", ((bot)d.c.b(paraml.rr.lBS)).computeSize());
        paramRunnable.putInt("CgiSpeedOutSideStructBizRet", ((bot)d.c.b(paraml.rr.lBS)).BaseResponse.CqV);
        paramRunnable.putString("CgiSpeedOutSideStructNetworkType", ((n)com.tencent.mm.kernel.h.ae(n.class)).chm());
        paramString = new Bundle();
        paramString.putBundle("stat_get_a8_key_cgi_speed", paramRunnable);
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(paramOnClickListener)));
        paraml = Uri.parse(paramOnClickListener);
        if ((paraml.getQueryParameter("search_query") != null) && (paraml.getQueryParameter("search_query").length() > 0))
        {
          paramString = paraml.getQueryParameter("search_query");
          paramRunnable = paraml.getQueryParameter("appid");
          paramBundle = paraml.getQueryParameter("search_extInfo");
          paramInt1 = Util.getInt(paraml.getQueryParameter("debug"), 0);
          paramInt2 = Util.getInt(paraml.getQueryParameter("version"), 0);
          paraml = new pj();
          paraml.fOb.scene = 1;
          paraml.fOb.appId = paramRunnable;
          paraml.fOb.type = paramInt1;
          paraml.fOb.version = paramInt2;
          paraml.fOb.fOc = paramString;
          paraml.fOb.url = paramOnClickListener;
          paraml.fOb.fOd = paramBundle;
          EventCenter.instance.publish(paraml);
          paraml = ai.gQI();
          paraml.putExtra("ftsbizscene", 99999);
          paraml.putExtra("ftsQuery", paramString);
          paraml.putExtra("ftsqrcodestring", paramOnClickListener);
          paramOnClickListener = ai.j(300, false, 262144);
          paramOnClickListener.put("query", paramString);
          paramString = ai.ane(Util.safeParseInt((String)paramOnClickListener.get("scene")));
          paramOnClickListener.put("sessionid", paramString);
          paraml.putExtra("rawUrl", ai.aX(paramOnClickListener));
          paraml.putExtra("key_session_id", paramString);
          com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", paraml);
          parama.wo(false);
          AppMethodBeat.o(51550);
          return true;
        }
        if (Util.getInt(paraml.getQueryParameter("qr_type4wxa"), 0) == 2) {
          paraml = Hsm;
        }
        for (;;)
        {
          paramInt1 = paraml.get(paramInt2);
          ((s)com.tencent.mm.kernel.h.ae(s.class)).b(localContext, paramOnClickListener, paramInt1, paramBundle, paramString);
          break;
          switch (j)
          {
          default: 
            paraml = Hsk;
            break;
          case 22: 
            paraml = Hsl;
          }
        }
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "jump to forceNotify UI");
        if (localContext != null)
        {
          localIntent.putExtra("data", paraml.bog());
          localIntent.setClassName(localContext, "com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI");
          parama.wo(false);
          parama = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, parama.aFh(), "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)parama.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect", "handleGetA8KeyRedirect", "(Lcom/tencent/mm/plugin/qrcode/model/GetA8KeyRedirect$IScanQRCodeGetA8KeyRedirect;Lcom/tencent/mm/modelsimple/NetSceneGetA8Key;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(51550);
        return true;
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paraml.bof() });
        paraml = paraml.bof();
        if (localContext != null) {
          ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareStickerPreview(localContext, paraml, new a.b()
          {
            public final void ep(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(51541);
              this.Hsr.wo(paramAnonymousBoolean);
              AppMethodBeat.o(51541);
            }
          });
        }
        AppMethodBeat.o(51550);
        return true;
        Log.i("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect: %s, %s", new Object[] { paramString, paraml.bof() });
        paraml = paraml.bof();
        if (localContext != null) {
          ((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emojicapture.api.a.class)).prepareEmojiCapture(localContext, paraml, new a.b()
          {
            public final void ep(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(51542);
              this.Hsr.wo(paramAnonymousBoolean);
              AppMethodBeat.o(51542);
            }
          });
        }
        AppMethodBeat.o(51550);
        return true;
        if (localContext != null) {
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).gotoRedPacketPreviewUI(localContext, paramString);
        }
        parama.wo(false);
        AppMethodBeat.o(51550);
        return true;
        parama = new Intent();
        parama.putExtra("key_qrcode_string", paraml.bof());
        com.tencent.mm.by.c.b(localContext, "account", ".friend.ui.RecoverAccountUI1", parama);
        new MMHandler(Looper.getMainLooper()).postDelayed(paramRunnable, 200L);
        parama = new qt();
        parama.gly = 1;
        parama.bpa();
        AppMethodBeat.o(51550);
        return true;
      }
      catch (IOException parama)
      {
        for (;;)
        {
          continue;
          paramInt1 = 0;
        }
      }
    }
  }
  
  protected static int abT(int paramInt)
  {
    if ((paramInt == 30) || (paramInt == 37) || (paramInt == 38) || (paramInt == 40)) {
      return 13;
    }
    if ((paramInt == 4) || (paramInt == 47)) {
      return 12;
    }
    if (paramInt == 34) {
      return 24;
    }
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract Context getContext();
    
    public abstract void wo(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ag.a.a
 * JD-Core Version:    0.7.0.1
 */