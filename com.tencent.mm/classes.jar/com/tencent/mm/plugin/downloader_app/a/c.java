package com.tencent.mm.plugin.downloader_app.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
      localObject = j.cCg();
      ((LinkedList)localObject).add(parama.appId);
      h.a((LinkedList)localObject, new h.a()
      {
        public final void kW(boolean paramAnonymousBoolean) {}
      });
      j.alB(parama.appId);
    }
    Object localObject = new g.a();
    ((g.a)localObject).alj(parama.downloadUrl);
    ((g.a)localObject).alk(parama.qKt);
    ((g.a)localObject).setFileSize(parama.qKv);
    ((g.a)localObject).all(parama.appName);
    ((g.a)localObject).setAppId(parama.appId);
    ((g.a)localObject).setFileMD5(parama.mYc);
    ((g.a)localObject).kS(parama.qKw);
    ((g.a)localObject).kT(false);
    int i;
    long l;
    if (parama.fileType == 0)
    {
      i = 1;
      ((g.a)localObject).Fl(i);
      ((g.a)localObject).gm(parama.packageName);
      ((g.a)localObject).cBE();
      ((g.a)localObject).setScene(parama.scene);
      ((g.a)localObject).Rv(parama.extInfo);
      ((g.a)localObject).kV(parama.qJg);
      ((g.a)localObject).Fp(parama.eik);
      ((g.a)localObject).Fm(parama.qJJ);
      ((g.a)localObject).Fo(parama.qJI);
      ((g.a)localObject).Fn(parama.qJH);
      ((g.a)localObject).kU(parama.qKx);
      ((g.a)localObject).V(parama.qKz);
      ((g.a)localObject).alm(parama.qKu);
      if (parama.dNv != 1) {
        break label388;
      }
      l = f.cBv().b(((g.a)localObject).qIY);
      label267:
      Log.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), parama.appId, Integer.valueOf(parama.dNv) });
      if (paramb != null)
      {
        if ((!parama.qJg) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
          break label403;
        }
        localObject = a.a.qKq;
      }
    }
    for (;;)
    {
      paramb.a((a.a)localObject, l);
      if ((parama.qJg) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
        d.alu(parama.appId);
      }
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8858);
      return l;
      i = parama.fileType;
      break;
      label388:
      l = f.cBv().a(((g.a)localObject).qIY);
      break label267;
      label403:
      if (l > 0L) {
        localObject = a.a.qKo;
      } else {
        localObject = a.a.qKp;
      }
    }
  }
  
  public static void a(final Context paramContext, final long paramLong, final a.b paramb)
  {
    AppMethodBeat.i(8865);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Cw(paramLong);
    if (locala == null)
    {
      paramb.a(a.a.qKp, -1L);
      AppMethodBeat.o(8865);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.api.b)g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new com.tencent.mm.plugin.downloader_app.api.b.a()new com.tencent.mm.plugin.downloader_app.api.b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(240201);
        d.alt(this.qIi.field_appId);
        c.a(this.qIi, false, new a.b()
        {
          public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
          {
            AppMethodBeat.i(240200);
            c.bQ(c.8.this.val$context);
            if (c.8.this.qKE != null) {
              c.8.this.qKE.a(paramAnonymous2a, paramAnonymous2Long);
            }
            AppMethodBeat.o(240200);
          }
        });
        AppMethodBeat.o(240201);
      }
    }, new com.tencent.mm.plugin.downloader_app.api.b.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(240202);
        com.tencent.mm.plugin.downloader.g.a locala = this.qIi;
        this.qIi.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
        com.tencent.mm.plugin.downloader.model.d.e(this.qIi);
        if (this.qIi.field_status == 0) {
          d.alv(this.qIi.field_appId);
        }
        if (paramb != null) {
          paramb.a(a.a.qKr, paramLong);
        }
        AppMethodBeat.o(240202);
      }
    }, null);
    AppMethodBeat.o(8865);
  }
  
  private static void a(Context paramContext, com.tencent.mm.plugin.downloader.g.a parama, i parami, final a.b paramb)
  {
    AppMethodBeat.i(8861);
    if (!NetStatusUtil.isConnected(paramContext))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131763509), paramContext.getString(2131763510), paramContext.getString(2131762113), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8853);
          this.qIi.field_status = 4;
          com.tencent.mm.plugin.downloader.model.d.e(this.qIi);
          d.CI(this.qIi.field_downloadId);
          if (paramb != null) {
            paramb.a(a.a.qKp, this.qIi.field_downloadId);
          }
          if (paramb != null) {
            paramb.a(a.a.qKp, this.qIi.field_downloadId);
          }
          AppMethodBeat.o(8853);
        }
      });
      AppMethodBeat.o(8861);
      return;
    }
    if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOq, false))
    {
      d.alt(parama.field_appId);
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
      d.alt(parama.field_appId);
      a(parama, false, paramb);
      AppMethodBeat.o(8861);
      return;
    }
    if (parami.qLi.qGy)
    {
      ((com.tencent.mm.plugin.downloader_app.api.b)g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8841);
          d.alt(this.qIi.field_appId);
          c.a(this.qIi, false, paramb);
          AppMethodBeat.o(8841);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8842);
          if ((!this.qIi.field_reserveInWifi) || (!this.qIi.field_downloadInWifi))
          {
            paramAnonymousDialogInterface = this.qIi;
            this.qIi.field_downloadInWifi = true;
            paramAnonymousDialogInterface.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(this.qIi);
          }
          paramb.a(a.a.qKq, this.qIi.field_downloadId);
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
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131768552), paramContext.getString(2131768553), paramContext.getString(2131768547), paramContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8843);
        d.alt(this.qIi.field_appId);
        c.a(this.qIi, false, paramb);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8843);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8844);
        if (this.qKF != null) {
          com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(this.qKF.type), this.qKF.position, 4, this.qKF.appId, "", "");
        }
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8844);
      }
    }, 2131101414);
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
    if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOq, false))
    {
      if (NetStatusUtil.isWifi(paramContext)) {
        bool = true;
      }
      parama.qJg = bool;
      a(parama, paramb);
      AppMethodBeat.o(8857);
      return;
    }
    if (!NetStatusUtil.isWifi(paramContext))
    {
      if (parama.qJg)
      {
        ((com.tencent.mm.plugin.downloader_app.api.b)g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8848);
            this.qKD.qJg = false;
            c.a(this.qKD, paramb);
            AppMethodBeat.o(8848);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8849);
            c.a(this.qKD, paramb);
            AppMethodBeat.o(8849);
          }
        }, null);
        AppMethodBeat.o(8857);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131768552), paramContext.getString(2131768553), paramContext.getString(2131768547), paramContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8850);
          d.alt(this.qKD.appId);
          this.qKD.qJg = false;
          c.a(this.qKD, paramb);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(8850);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(240206);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(240206);
        }
      }, 2131101414);
      AppMethodBeat.o(8857);
      return;
    }
    d.alt(parama.appId);
    parama.qJg = false;
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
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(parami.type), parami.position, 23, parami.appId, "", "");
    }
    b(paramContext, parami, paramBoolean);
    AppMethodBeat.o(8855);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean, final a.b paramb)
  {
    AppMethodBeat.i(8860);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(parami.appId);
    if (locala != null)
    {
      locala.field_extInfo = als(locala.field_extInfo);
      locala.field_downloadType = 1;
      a(paramContext, locala, parami, new a.b()
      {
        public final void a(a.a paramAnonymousa, long paramAnonymousLong)
        {
          AppMethodBeat.i(240207);
          c.bQ(this.val$context);
          if (paramb != null) {
            paramb.a(paramAnonymousa, paramAnonymousLong);
          }
          AppMethodBeat.o(240207);
        }
      });
      paramContext = new com.tencent.mm.plugin.downloader.f.b();
      paramContext.k(locala);
      com.tencent.mm.plugin.downloader.f.a.a(10, paramContext);
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(parami.type), parami.position, 6, parami.appId, "", "");
    }
    AppMethodBeat.o(8860);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(8864);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(parami.appId);
    if (locala != null) {
      f.cBv().Cn(locala.field_downloadId);
    }
    com.tencent.mm.plugin.downloader_app.b.a.a(11, com.tencent.mm.plugin.downloader_app.b.a.Fq(parami.type), parami.position, 81, parami.appId, "", "");
    AppMethodBeat.o(8864);
  }
  
  public static boolean a(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(8862);
    if (!j.contains(parama.field_appId))
    {
      localObject = j.cCg();
      ((LinkedList)localObject).add(parama.field_appId);
      h.a((LinkedList)localObject, null);
      j.alB(parama.field_appId);
    }
    parama.field_showNotification = false;
    parama.field_fromDownloadApp = true;
    parama.field_downloadInWifi = paramBoolean;
    parama.field_reserveInWifi = paramBoolean;
    com.tencent.mm.plugin.downloader.model.d.e(parama);
    paramBoolean = f.cBv().Cq(parama.field_downloadId);
    if (paramb != null) {
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (Object localObject = a.a.qKo;; localObject = a.a.qKp)
    {
      paramb.a((a.a)localObject, parama.field_downloadId);
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8862);
      return paramBoolean;
    }
  }
  
  private static String als(String paramString)
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
    AppMethodBeat.i(240208);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(parami.appId);
    if (locala != null)
    {
      f.cBv().Cp(locala.field_downloadId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(parami.type), parami.position, 5, locala.field_appId, "", "");
      if ((((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOq, false)) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
        ((com.tencent.mm.plugin.downloader_app.api.b)g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, new com.tencent.mm.plugin.downloader_app.api.b.a()new com.tencent.mm.plugin.downloader_app.api.b.a
        {
          public final void onClick()
          {
            AppMethodBeat.i(240198);
            com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(this.qKF.appId);
            if (locala == null)
            {
              AppMethodBeat.o(240198);
              return;
            }
            locala.field_downloadInWifi = false;
            locala.field_reserveInWifi = false;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
            AppMethodBeat.o(240198);
          }
        }, new com.tencent.mm.plugin.downloader_app.api.b.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(240199);
            com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(this.qKF.appId);
            if (locala == null)
            {
              AppMethodBeat.o(240199);
              return;
            }
            locala.field_downloadInWifi = true;
            locala.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
            d.alu(locala.field_appId);
            AppMethodBeat.o(240199);
          }
        });
      }
    }
    AppMethodBeat.o(240208);
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
    locala.downloadUrl = parami.qLi.gqB;
    locala.qKt = parami.qLi.qGw;
    locala.appId = parami.appId;
    locala.appName = parami.appName;
    locala.qKv = parami.qLi.qGq;
    locala.mYc = parami.qLi.qGr;
    locala.packageName = parami.qLi.qGp;
    locala.dNv = parami.qLi.qGs;
    locala.extInfo = cBV();
    if (paramBoolean) {}
    for (int i = 6003;; i = 6002)
    {
      locala.scene = i;
      locala.qJg = parami.qLi.qGy;
      locala.fileType = 1;
      locala.dNv = 1;
      locala.qKz = parami.qLi.qGz;
      com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(locala.appId, locala.scene, -1L, ""));
      if (NetStatusUtil.isConnected(paramContext)) {
        break;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131763509), paramContext.getString(2131763510), paramContext.getString(2131762113), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8840);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.downloader.model.d.alb(this.qKD.appId);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_status = 4;
            com.tencent.mm.plugin.downloader.model.d.e(paramAnonymousDialogInterface);
          }
          for (;;)
          {
            d.CI(paramAnonymousDialogInterface.field_downloadId);
            if (this.qKE != null) {
              this.qKE.a(a.a.qKp, paramAnonymousDialogInterface.field_downloadId);
            }
            AppMethodBeat.o(8840);
            return;
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.downloader.g.a();
            paramAnonymousDialogInterface.field_downloadId = System.currentTimeMillis();
            paramAnonymousDialogInterface.field_appId = this.qKD.appId;
            paramAnonymousDialogInterface.field_downloadUrl = this.qKD.downloadUrl;
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
        AppMethodBeat.i(240204);
        if (paramAnonymousa == a.a.qKo) {
          c.bQ(this.val$context);
        }
        if (this.qKE != null) {
          this.qKE.a(paramAnonymousa, paramAnonymousLong);
        }
        AppMethodBeat.o(240204);
      }
    });
    AppMethodBeat.o(8856);
  }
  
  public static boolean c(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8866);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(parami.appId);
    if (locala == null)
    {
      AppMethodBeat.o(8866);
      return false;
    }
    if (s.YS(locala.field_filePath))
    {
      com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, null);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(parami.type), parami.position, 44, parami.appId, "", "");
      AppMethodBeat.o(8866);
      return true;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131763807), paramContext.getString(2131763808), paramContext.getString(2131764627), paramContext.getString(2131766643), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(240203);
        c.a(this.val$context, parami);
        AppMethodBeat.o(240203);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8866);
    return false;
  }
  
  private static String cBV()
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
    if (q.s(paramContext, parami.qLi.qGp))
    {
      com.tencent.mm.plugin.downloader.i.a.as(paramContext, parami.appId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(parami.type), parami.position, 22, parami.appId, "", "");
      AppMethodBeat.o(8867);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131756003), paramContext.getString(2131756004), paramContext.getString(2131764627), paramContext.getString(2131766643), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(240205);
        c.a(this.val$context, parami);
        AppMethodBeat.o(240205);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.c
 * JD-Core Version:    0.7.0.1
 */