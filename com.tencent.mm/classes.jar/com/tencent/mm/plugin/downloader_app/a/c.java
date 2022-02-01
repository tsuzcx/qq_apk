package com.tencent.mm.plugin.downloader_app.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.api.b.a;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
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
      localObject = j.dvd();
      ((LinkedList)localObject).add(parama.appId);
      h.a((LinkedList)localObject, new h.a()
      {
        public final void nE(boolean paramAnonymousBoolean) {}
      });
      j.anj(parama.appId);
    }
    Object localObject = new g.a();
    ((g.a)localObject).amR(parama.downloadUrl);
    ((g.a)localObject).amS(parama.xrR);
    ((g.a)localObject).setFileSize(parama.xrT);
    ((g.a)localObject).amT(parama.appName);
    ((g.a)localObject).setAppId(parama.appId);
    ((g.a)localObject).setFileMD5(parama.tdo);
    ((g.a)localObject).nA(parama.xrU);
    ((g.a)localObject).nB(false);
    int i;
    long l;
    if (parama.fileType == 0)
    {
      i = 1;
      ((g.a)localObject).JA(i);
      ((g.a)localObject).setPackageName(parama.packageName);
      ((g.a)localObject).duE();
      ((g.a)localObject).setScene(parama.scene);
      ((g.a)localObject).QX(parama.extInfo);
      ((g.a)localObject).nD(parama.xoo);
      ((g.a)localObject).JE(parama.iiN);
      ((g.a)localObject).JB(parama.xoR);
      ((g.a)localObject).JD(parama.xoQ);
      ((g.a)localObject).JC(parama.xoP);
      ((g.a)localObject).nC(parama.xrV);
      ((g.a)localObject).V(parama.xrX);
      ((g.a)localObject).amU(parama.xrS);
      if (parama.hMd != 1) {
        break label388;
      }
      l = f.duv().b(((g.a)localObject).xoe);
      label267:
      Log.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), parama.appId, Integer.valueOf(parama.hMd) });
      if (paramb != null)
      {
        if ((!parama.xoo) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          break label403;
        }
        localObject = a.a.xrO;
      }
    }
    for (;;)
    {
      paramb.a((a.a)localObject, l);
      if ((parama.xoo) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
        d.anc(parama.appId);
      }
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8858);
      return l;
      i = parama.fileType;
      break;
      label388:
      l = f.duv().a(((g.a)localObject).xoe);
      break label267;
      label403:
      if (l > 0L) {
        localObject = a.a.xrM;
      } else {
        localObject = a.a.xrN;
      }
    }
  }
  
  public static void a(final Context paramContext, final long paramLong, final a.b paramb)
  {
    AppMethodBeat.i(8865);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if (locala == null)
    {
      paramb.a(a.a.xrN, -1L);
      AppMethodBeat.o(8865);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new b.a()new b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(269705);
        d.anb(c.this.field_appId);
        c.a(c.this, false, new a.b()
        {
          public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
          {
            AppMethodBeat.i(269692);
            c.cD(c.8.this.val$context);
            if (c.8.this.xsc != null) {
              c.8.this.xsc.a(paramAnonymous2a, paramAnonymous2Long);
            }
            AppMethodBeat.o(269692);
          }
        });
        AppMethodBeat.o(269705);
      }
    }, new b.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(269706);
        com.tencent.mm.plugin.downloader.f.a locala = c.this;
        c.this.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
        com.tencent.mm.plugin.downloader.model.d.e(c.this);
        if (c.this.field_status == 0) {
          d.and(c.this.field_appId);
        }
        if (paramb != null) {
          paramb.a(a.a.xrP, paramLong);
        }
        AppMethodBeat.o(269706);
      }
    }, null);
    AppMethodBeat.o(8865);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.downloader.f.a parama, i parami, final a.b paramb)
  {
    AppMethodBeat.i(8861);
    if (!NetStatusUtil.isConnected(paramContext))
    {
      k.a(paramContext, paramContext.getString(e.h.xrt), paramContext.getString(e.h.xru), paramContext.getString(e.h.xrq), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8853);
          c.this.field_status = 4;
          com.tencent.mm.plugin.downloader.model.d.e(c.this);
          d.lm(c.this.field_downloadId);
          if (paramb != null) {
            paramb.a(a.a.xrN, c.this.field_downloadId);
          }
          if (paramb != null) {
            paramb.a(a.a.xrN, c.this.field_downloadId);
          }
          AppMethodBeat.o(8853);
        }
      });
      AppMethodBeat.o(8861);
      return;
    }
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGQ, false))
    {
      d.anb(parama.field_appId);
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
      d.anb(parama.field_appId);
      a(parama, false, paramb);
      AppMethodBeat.o(8861);
      return;
    }
    if (parami.xsG.xlA)
    {
      ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8841);
          d.anb(c.this.field_appId);
          c.a(c.this, false, paramb);
          AppMethodBeat.o(8841);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8842);
          if ((!c.this.field_reserveInWifi) || (!c.this.field_downloadInWifi))
          {
            paramAnonymousDialogInterface = c.this;
            c.this.field_downloadInWifi = true;
            paramAnonymousDialogInterface.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(c.this);
          }
          paramb.a(a.a.xrO, c.this.field_downloadId);
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
    k.a(paramContext, paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_title), paramContext.getString(e.h.webview_download_ui_btn_state_to_download), paramContext.getString(e.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8843);
        d.anb(c.this.field_appId);
        c.a(c.this, false, paramb);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8843);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8844);
        if (c.this != null) {
          com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(c.this.type), c.this.position, 4, c.this.appId, "", "");
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
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGQ, false))
    {
      if (NetStatusUtil.isWifi(paramContext)) {
        bool = true;
      }
      parama.xoo = bool;
      a(parama, paramb);
      AppMethodBeat.o(8857);
      return;
    }
    if (!NetStatusUtil.isWifi(paramContext))
    {
      if (parama.xoo)
      {
        ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8848);
            c.this.xoo = false;
            c.a(c.this, paramb);
            AppMethodBeat.o(8848);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8849);
            c.a(c.this, paramb);
            AppMethodBeat.o(8849);
          }
        }, null);
        AppMethodBeat.o(8857);
        return;
      }
      k.a(paramContext, paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(e.h.webview_download_ui_download_not_in_wifi_title), paramContext.getString(e.h.webview_download_ui_btn_state_to_download), paramContext.getString(e.h.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8850);
          d.anb(c.this.appId);
          c.this.xoo = false;
          c.a(c.this, paramb);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(8850);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(269695);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(269695);
        }
      }, e.b.wechat_green);
      AppMethodBeat.o(8857);
      return;
    }
    d.anb(parama.appId);
    parama.xoo = false;
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
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(parami.type), parami.position, 23, parami.appId, "", "");
    }
    b(paramContext, parami, paramBoolean);
    AppMethodBeat.o(8855);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean, final a.b paramb)
  {
    AppMethodBeat.i(8860);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(parami.appId);
    if (locala != null)
    {
      locala.field_extInfo = ana(locala.field_extInfo);
      locala.field_downloadType = 1;
      a(paramContext, locala, parami, new a.b()
      {
        public final void a(a.a paramAnonymousa, long paramAnonymousLong)
        {
          AppMethodBeat.i(269709);
          c.cD(c.this);
          if (paramb != null) {
            paramb.a(paramAnonymousa, paramAnonymousLong);
          }
          AppMethodBeat.o(269709);
        }
      });
      paramContext = new com.tencent.mm.plugin.downloader.e.b();
      paramContext.k(locala);
      com.tencent.mm.plugin.downloader.e.a.a(10, paramContext);
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(parami.type), parami.position, 6, parami.appId, "", "");
    }
    AppMethodBeat.o(8860);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(8864);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(parami.appId);
    if (locala != null) {
      f.duv().kR(locala.field_downloadId);
    }
    com.tencent.mm.plugin.downloader_app.b.a.a(11, com.tencent.mm.plugin.downloader_app.b.a.JF(parami.type), parami.position, 81, parami.appId, "", "");
    AppMethodBeat.o(8864);
  }
  
  public static boolean a(com.tencent.mm.plugin.downloader.f.a parama, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(8862);
    if (!j.contains(parama.field_appId))
    {
      localObject = j.dvd();
      ((LinkedList)localObject).add(parama.field_appId);
      h.a((LinkedList)localObject, null);
      j.anj(parama.field_appId);
    }
    parama.field_showNotification = false;
    parama.field_fromDownloadApp = true;
    parama.field_downloadInWifi = paramBoolean;
    parama.field_reserveInWifi = paramBoolean;
    com.tencent.mm.plugin.downloader.model.d.e(parama);
    paramBoolean = f.duv().kU(parama.field_downloadId);
    if (paramb != null) {
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (Object localObject = a.a.xrM;; localObject = a.a.xrN)
    {
      paramb.a((a.a)localObject, parama.field_downloadId);
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8862);
      return paramBoolean;
    }
  }
  
  private static String ana(String paramString)
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
    AppMethodBeat.i(269716);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(parami.appId);
    if (locala != null)
    {
      f.duv().kT(locala.field_downloadId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(parami.type), parami.position, 5, locala.field_appId, "", "");
      if ((((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGQ, false)) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
        ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, new b.a()new b.a
        {
          public final void onClick()
          {
            AppMethodBeat.i(269703);
            com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(c.this.appId);
            if (locala == null)
            {
              AppMethodBeat.o(269703);
              return;
            }
            locala.field_downloadInWifi = false;
            locala.field_reserveInWifi = false;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
            AppMethodBeat.o(269703);
          }
        }, new b.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(269704);
            com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(c.this.appId);
            if (locala == null)
            {
              AppMethodBeat.o(269704);
              return;
            }
            locala.field_downloadInWifi = true;
            locala.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
            d.anc(locala.field_appId);
            AppMethodBeat.o(269704);
          }
        });
      }
    }
    AppMethodBeat.o(269716);
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
    locala.downloadUrl = parami.xsG.lwO;
    locala.xrR = parami.xsG.xly;
    locala.appId = parami.appId;
    locala.appName = parami.appName;
    locala.xrT = parami.xsG.xls;
    locala.tdo = parami.xsG.xlt;
    locala.packageName = parami.xsG.xlr;
    locala.hMd = parami.xsG.xlu;
    locala.extInfo = duS();
    if (paramBoolean) {}
    for (int i = 6003;; i = 6002)
    {
      locala.scene = i;
      locala.xoo = parami.xsG.xlA;
      locala.fileType = 1;
      locala.hMd = 1;
      locala.xrX = parami.xsG.xlB;
      com.tencent.mm.plugin.downloader.e.a.a(9, new com.tencent.mm.plugin.downloader.e.b(locala.appId, locala.scene, -1L, ""));
      if (NetStatusUtil.isConnected(paramContext)) {
        break;
      }
      k.a(paramContext, paramContext.getString(e.h.xrt), paramContext.getString(e.h.xru), paramContext.getString(e.h.xrq), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8840);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.downloader.model.d.amJ(c.this.appId);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_status = 4;
            com.tencent.mm.plugin.downloader.model.d.e(paramAnonymousDialogInterface);
          }
          for (;;)
          {
            d.lm(paramAnonymousDialogInterface.field_downloadId);
            if (this.xsc != null) {
              this.xsc.a(a.a.xrN, paramAnonymousDialogInterface.field_downloadId);
            }
            AppMethodBeat.o(8840);
            return;
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.downloader.f.a();
            paramAnonymousDialogInterface.field_downloadId = System.currentTimeMillis();
            paramAnonymousDialogInterface.field_appId = c.this.appId;
            paramAnonymousDialogInterface.field_downloadUrl = c.this.downloadUrl;
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
        AppMethodBeat.i(269697);
        if (paramAnonymousa == a.a.xrM) {
          c.cD(c.this);
        }
        if (this.xsc != null) {
          this.xsc.a(paramAnonymousa, paramAnonymousLong);
        }
        AppMethodBeat.o(269697);
      }
    });
    AppMethodBeat.o(8856);
  }
  
  public static boolean c(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8866);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ(parami.appId);
    if (locala == null)
    {
      AppMethodBeat.o(8866);
      return false;
    }
    if (y.ZC(locala.field_filePath))
    {
      com.tencent.mm.plugin.downloader.h.a.a(locala.field_downloadId, false, null);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(parami.type), parami.position, 44, parami.appId, "", "");
      AppMethodBeat.o(8866);
      return true;
    }
    k.a(paramContext, paramContext.getString(e.h.xrB), paramContext.getString(e.h.xrC), paramContext.getString(e.h.xrD), paramContext.getString(e.h.xrF), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(269698);
        c.a(c.this, parami);
        AppMethodBeat.o(269698);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8866);
    return false;
  }
  
  public static void d(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8867);
    if (u.y(paramContext, parami.xsG.xlr))
    {
      com.tencent.mm.plugin.downloader.h.a.at(paramContext, parami.appId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.JF(parami.type), parami.position, 22, parami.appId, "", "");
      AppMethodBeat.o(8867);
      return;
    }
    k.a(paramContext, paramContext.getString(e.h.xqU), paramContext.getString(e.h.xqV), paramContext.getString(e.h.xrD), paramContext.getString(e.h.xrF), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(269696);
        c.a(c.this, parami);
        AppMethodBeat.o(269696);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8867);
  }
  
  private static String duS()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.c
 * JD-Core Version:    0.7.0.1
 */