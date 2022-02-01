package com.tencent.mm.plugin.downloader_app.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static long a(a parama, a.b paramb)
  {
    AppMethodBeat.i(8858);
    if (!j.contains(parama.appId))
    {
      localObject = j.cQK();
      ((LinkedList)localObject).add(parama.appId);
      h.a((LinkedList)localObject, new h.a()
      {
        public final void mi(boolean paramAnonymousBoolean) {}
      });
      j.atu(parama.appId);
    }
    Object localObject = new g.a();
    ((g.a)localObject).atc(parama.downloadUrl);
    ((g.a)localObject).atd(parama.ulF);
    ((g.a)localObject).setFileSize(parama.ulH);
    ((g.a)localObject).ate(parama.appName);
    ((g.a)localObject).setAppId(parama.appId);
    ((g.a)localObject).setFileMD5(parama.pYB);
    ((g.a)localObject).me(parama.ulI);
    ((g.a)localObject).mf(false);
    int i;
    long l;
    if (parama.fileType == 0)
    {
      i = 1;
      ((g.a)localObject).IS(i);
      ((g.a)localObject).setPackageName(parama.packageName);
      ((g.a)localObject).cQi();
      ((g.a)localObject).setScene(parama.scene);
      ((g.a)localObject).YS(parama.extInfo);
      ((g.a)localObject).mh(parama.uij);
      ((g.a)localObject).IW(parama.gcB);
      ((g.a)localObject).IT(parama.uiO);
      ((g.a)localObject).IV(parama.uiN);
      ((g.a)localObject).IU(parama.uiM);
      ((g.a)localObject).mg(parama.ulJ);
      ((g.a)localObject).T(parama.ulL);
      ((g.a)localObject).atf(parama.ulG);
      if (parama.fGH != 1) {
        break label388;
      }
      l = f.cPZ().b(((g.a)localObject).uhY);
      label267:
      Log.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), parama.appId, Integer.valueOf(parama.fGH) });
      if (paramb != null)
      {
        if ((!parama.uij) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          break label403;
        }
        localObject = a.a.ulC;
      }
    }
    for (;;)
    {
      paramb.a((a.a)localObject, l);
      if ((parama.uij) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
        d.atn(parama.appId);
      }
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8858);
      return l;
      i = parama.fileType;
      break;
      label388:
      l = f.cPZ().a(((g.a)localObject).uhY);
      break label267;
      label403:
      if (l > 0L) {
        localObject = a.a.ulA;
      } else {
        localObject = a.a.ulB;
      }
    }
  }
  
  public static void a(final Context paramContext, final long paramLong, final a.b paramb)
  {
    AppMethodBeat.i(8865);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if (locala == null)
    {
      paramb.a(a.a.ulB, -1L);
      AppMethodBeat.o(8865);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new com.tencent.mm.plugin.downloader_app.api.b.a()new com.tencent.mm.plugin.downloader_app.api.b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(242936);
        d.atm(this.uhi.field_appId);
        c.a(this.uhi, false, new a.b()
        {
          public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
          {
            AppMethodBeat.i(243214);
            c.bQ(c.8.this.val$context);
            if (c.8.this.ulQ != null) {
              c.8.this.ulQ.a(paramAnonymous2a, paramAnonymous2Long);
            }
            AppMethodBeat.o(243214);
          }
        });
        AppMethodBeat.o(242936);
      }
    }, new com.tencent.mm.plugin.downloader_app.api.b.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(243109);
        com.tencent.mm.plugin.downloader.g.a locala = this.uhi;
        this.uhi.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
        com.tencent.mm.plugin.downloader.model.d.e(this.uhi);
        if (this.uhi.field_status == 0) {
          d.ato(this.uhi.field_appId);
        }
        if (paramb != null) {
          paramb.a(a.a.ulD, paramLong);
        }
        AppMethodBeat.o(243109);
      }
    }, null);
    AppMethodBeat.o(8865);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.downloader.g.a parama, i parami, final a.b paramb)
  {
    AppMethodBeat.i(8861);
    if (!NetStatusUtil.isConnected(paramContext))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(e.h.ulh), paramContext.getString(e.h.uli), paramContext.getString(e.h.ule), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8853);
          this.uhi.field_status = 4;
          com.tencent.mm.plugin.downloader.model.d.e(this.uhi);
          d.IR(this.uhi.field_downloadId);
          if (paramb != null) {
            paramb.a(a.a.ulB, this.uhi.field_downloadId);
          }
          if (paramb != null) {
            paramb.a(a.a.ulB, this.uhi.field_downloadId);
          }
          AppMethodBeat.o(8853);
        }
      });
      AppMethodBeat.o(8861);
      return;
    }
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vul, false))
    {
      d.atm(parama.field_appId);
      if (NetStatusUtil.isWifi(paramContext)) {}
      for (boolean bool = true;; bool = false)
      {
        a(parama, bool, paramb);
        AppMethodBeat.o(8861);
        return;
      }
    }
    if (NetStatusUtil.isWifi(paramContext))
    {
      d.atm(parama.field_appId);
      a(parama, false, paramb);
      AppMethodBeat.o(8861);
      return;
    }
    if (parami.umu.ufz)
    {
      ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8841);
          d.atm(this.uhi.field_appId);
          c.a(this.uhi, false, paramb);
          AppMethodBeat.o(8841);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8842);
          if ((!this.uhi.field_reserveInWifi) || (!this.uhi.field_downloadInWifi))
          {
            paramAnonymousDialogInterface = this.uhi;
            this.uhi.field_downloadInWifi = true;
            paramAnonymousDialogInterface.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(this.uhi);
          }
          paramb.a(a.a.ulC, this.uhi.field_downloadId);
          AppMethodBeat.o(8842);
        }
      }, null);
      AppMethodBeat.o(8861);
      return;
    }
    if (parama.field_reserveInWifi)
    {
      parama.field_downloadInWifi = false;
      parama.field_reserveInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(parama);
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_title), paramContext.getString(e.h.webview_download_ui_btn_state_to_download), paramContext.getString(e.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8843);
        d.atm(this.uhi.field_appId);
        c.a(this.uhi, false, paramb);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8843);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8844);
        if (this.ulR != null) {
          com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(this.ulR.type), this.ulR.position, 4, this.ulR.appId, "", "");
        }
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8844);
      }
    }, e.b.wechat_green);
    AppMethodBeat.o(8861);
  }
  
  private static void a(Context paramContext, a parama, final a.b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(8857);
    if ((paramContext == null) || (!parama.isValid()))
    {
      AppMethodBeat.o(8857);
      return;
    }
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vul, false))
    {
      if (NetStatusUtil.isWifi(paramContext)) {
        bool = true;
      }
      parama.uij = bool;
      a(parama, paramb);
      AppMethodBeat.o(8857);
      return;
    }
    if (!NetStatusUtil.isWifi(paramContext))
    {
      if (parama.uij)
      {
        ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8848);
            this.ulP.uij = false;
            c.a(this.ulP, paramb);
            AppMethodBeat.o(8848);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8849);
            c.a(this.ulP, paramb);
            AppMethodBeat.o(8849);
          }
        }, null);
        AppMethodBeat.o(8857);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_title), paramContext.getString(e.h.webview_download_ui_btn_state_to_download), paramContext.getString(e.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8850);
          d.atm(this.ulP.appId);
          this.ulP.uij = false;
          c.a(this.ulP, paramb);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(8850);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(242938);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(242938);
        }
      }, e.b.wechat_green);
      AppMethodBeat.o(8857);
      return;
    }
    d.atm(parama.appId);
    parama.uij = false;
    a(parama, paramb);
    AppMethodBeat.o(8857);
  }
  
  public static void a(Context paramContext, i parami)
  {
    AppMethodBeat.i(8854);
    a(paramContext, parami, false);
    AppMethodBeat.o(8854);
  }
  
  public static void a(Context paramContext, i parami, a.b paramb)
  {
    AppMethodBeat.i(8859);
    a(paramContext, parami, true, paramb);
    AppMethodBeat.o(8859);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(8855);
    if (!paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(parami.type), parami.position, 23, parami.appId, "", "");
    }
    b(paramContext, parami, paramBoolean);
    AppMethodBeat.o(8855);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean, final a.b paramb)
  {
    AppMethodBeat.i(8860);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(parami.appId);
    if (locala != null)
    {
      locala.field_extInfo = atl(locala.field_extInfo);
      locala.field_downloadType = 1;
      a(paramContext, locala, parami, new a.b()
      {
        public final void a(a.a paramAnonymousa, long paramAnonymousLong)
        {
          AppMethodBeat.i(242808);
          c.bQ(this.val$context);
          if (paramb != null) {
            paramb.a(paramAnonymousa, paramAnonymousLong);
          }
          AppMethodBeat.o(242808);
        }
      });
      paramContext = new com.tencent.mm.plugin.downloader.f.b();
      paramContext.k(locala);
      com.tencent.mm.plugin.downloader.f.a.a(10, paramContext);
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(parami.type), parami.position, 6, parami.appId, "", "");
    }
    AppMethodBeat.o(8860);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(8864);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(parami.appId);
    if (locala != null) {
      f.cPZ().Iw(locala.field_downloadId);
    }
    com.tencent.mm.plugin.downloader_app.b.a.a(11, com.tencent.mm.plugin.downloader_app.b.a.IX(parami.type), parami.position, 81, parami.appId, "", "");
    AppMethodBeat.o(8864);
  }
  
  public static boolean a(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(8862);
    if (!j.contains(parama.field_appId))
    {
      localObject = j.cQK();
      ((LinkedList)localObject).add(parama.field_appId);
      h.a((LinkedList)localObject, null);
      j.atu(parama.field_appId);
    }
    parama.field_showNotification = false;
    parama.field_fromDownloadApp = true;
    parama.field_downloadInWifi = paramBoolean;
    parama.field_reserveInWifi = paramBoolean;
    com.tencent.mm.plugin.downloader.model.d.e(parama);
    paramBoolean = f.cPZ().Iz(parama.field_downloadId);
    if (paramb != null) {
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (Object localObject = a.a.ulA;; localObject = a.a.ulB)
    {
      paramb.a((a.a)localObject, parama.field_downloadId);
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8862);
      return paramBoolean;
    }
  }
  
  private static String atl(String paramString)
  {
    AppMethodBeat.i(8869);
    if ((paramString != null) && (paramString.contains("OpInWidget")))
    {
      AppMethodBeat.o(8869);
      return paramString;
    }
    if (!Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      try
      {
        str1 = URLDecoder.decode(paramString, "utf-8");
      }
      catch (UnsupportedEncodingException paramString)
      {
        try
        {
          String str1;
          paramString = new JSONObject(str1);
          localObject = paramString;
          if (paramString == null) {
            localObject = new JSONObject();
          }
        }
        catch (Exception paramString)
        {
          try
          {
            ((JSONObject)localObject).put("OpInWidget", 1);
            try
            {
              paramString = URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8");
              AppMethodBeat.o(8869);
              return paramString;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              str2 = paramString;
              continue;
              paramString = paramString;
              paramString = null;
            }
            catch (UnsupportedEncodingException paramString)
            {
              paramString = str2;
              continue;
            }
          }
          catch (JSONException paramString)
          {
            continue;
          }
        }
      }
      Object localObject = null;
      String str2 = paramString;
      paramString = (String)localObject;
    }
  }
  
  public static void b(Context paramContext, i parami)
  {
    AppMethodBeat.i(243142);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(parami.appId);
    if (locala != null)
    {
      f.cPZ().Iy(locala.field_downloadId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(parami.type), parami.position, 5, locala.field_appId, "", "");
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vul, false)) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
        ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, new com.tencent.mm.plugin.downloader_app.api.b.a()new com.tencent.mm.plugin.downloader_app.api.b.a
        {
          public final void onClick()
          {
            AppMethodBeat.i(243092);
            com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(this.ulR.appId);
            if (locala == null)
            {
              AppMethodBeat.o(243092);
              return;
            }
            locala.field_downloadInWifi = false;
            locala.field_reserveInWifi = false;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
            AppMethodBeat.o(243092);
          }
        }, new com.tencent.mm.plugin.downloader_app.api.b.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(242978);
            com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(this.ulR.appId);
            if (locala == null)
            {
              AppMethodBeat.o(242978);
              return;
            }
            locala.field_downloadInWifi = true;
            locala.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
            d.atn(locala.field_appId);
            AppMethodBeat.o(242978);
          }
        });
      }
    }
    AppMethodBeat.o(243142);
  }
  
  private static void b(Context paramContext, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(8856);
    if ((paramContext == null) || (parami == null))
    {
      AppMethodBeat.o(8856);
      return;
    }
    a locala = new a();
    locala.downloadUrl = parami.umu.iUJ;
    locala.ulF = parami.umu.ufx;
    locala.appId = parami.appId;
    locala.appName = parami.appName;
    locala.ulH = parami.umu.ufr;
    locala.pYB = parami.umu.ufs;
    locala.packageName = parami.umu.ufq;
    locala.fGH = parami.umu.uft;
    locala.extInfo = cQz();
    if (paramBoolean) {}
    for (int i = 6003;; i = 6002)
    {
      locala.scene = i;
      locala.uij = parami.umu.ufz;
      locala.fileType = 1;
      locala.fGH = 1;
      locala.ulL = parami.umu.ufA;
      com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(locala.appId, locala.scene, -1L, ""));
      if (NetStatusUtil.isConnected(paramContext)) {
        break;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(e.h.ulh), paramContext.getString(e.h.uli), paramContext.getString(e.h.ule), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8840);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.downloader.model.d.asU(this.ulP.appId);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_status = 4;
            com.tencent.mm.plugin.downloader.model.d.e(paramAnonymousDialogInterface);
          }
          for (;;)
          {
            d.IR(paramAnonymousDialogInterface.field_downloadId);
            if (this.ulQ != null) {
              this.ulQ.a(a.a.ulB, paramAnonymousDialogInterface.field_downloadId);
            }
            AppMethodBeat.o(8840);
            return;
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.downloader.g.a();
            paramAnonymousDialogInterface.field_downloadId = System.currentTimeMillis();
            paramAnonymousDialogInterface.field_appId = this.ulP.appId;
            paramAnonymousDialogInterface.field_downloadUrl = this.ulP.downloadUrl;
            paramAnonymousDialogInterface.field_status = 4;
            com.tencent.mm.plugin.downloader.model.d.d(paramAnonymousDialogInterface);
          }
        }
      });
      AppMethodBeat.o(8856);
      return;
    }
    a(paramContext, locala, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(243226);
        if (paramAnonymousa == a.a.ulA) {
          c.bQ(this.val$context);
        }
        if (this.ulQ != null) {
          this.ulQ.a(paramAnonymousa, paramAnonymousLong);
        }
        AppMethodBeat.o(243226);
      }
    });
    AppMethodBeat.o(8856);
  }
  
  public static boolean c(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8866);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(parami.appId);
    if (locala == null)
    {
      AppMethodBeat.o(8866);
      return false;
    }
    if (u.agG(locala.field_filePath))
    {
      com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, null);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(parami.type), parami.position, 44, parami.appId, "", "");
      AppMethodBeat.o(8866);
      return true;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(e.h.ulp), paramContext.getString(e.h.ulq), paramContext.getString(e.h.ulr), paramContext.getString(e.h.ult), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(243212);
        c.a(this.val$context, parami);
        AppMethodBeat.o(243212);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8866);
    return false;
  }
  
  private static String cQz()
  {
    AppMethodBeat.i(8868);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("DownloadInWidget", 1);
      ((JSONObject)localObject2).put("OpInWidget", 1);
      label32:
      Object localObject1 = null;
      try
      {
        localObject2 = URLEncoder.encode(((JSONObject)localObject2).toString(), "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label47:
        break label47;
      }
      AppMethodBeat.o(8868);
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      break label32;
    }
  }
  
  public static void d(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8867);
    if (q.u(paramContext, parami.umu.ufq))
    {
      com.tencent.mm.plugin.downloader.i.a.as(paramContext, parami.appId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.IX(parami.type), parami.position, 22, parami.appId, "", "");
      AppMethodBeat.o(8867);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(e.h.ukI), paramContext.getString(e.h.ukJ), paramContext.getString(e.h.ulr), paramContext.getString(e.h.ult), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(243011);
        c.a(this.val$context, parami);
        AppMethodBeat.o(243011);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.c
 * JD-Core Version:    0.7.0.1
 */