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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
      localObject = j.ceq();
      ((LinkedList)localObject).add(parama.appId);
      h.a((LinkedList)localObject, new h.a()
      {
        public final void jT(boolean paramAnonymousBoolean) {}
      });
      j.abv(parama.appId);
    }
    Object localObject = new g.a();
    ((g.a)localObject).abb(parama.downloadUrl);
    ((g.a)localObject).abc(parama.pve);
    ((g.a)localObject).uz(parama.pvg);
    ((g.a)localObject).abd(parama.appName);
    ((g.a)localObject).setAppId(parama.appId);
    ((g.a)localObject).abe(parama.lQS);
    ((g.a)localObject).jP(parama.pvh);
    ((g.a)localObject).jQ(false);
    int i;
    long l;
    if (parama.fileType == 0)
    {
      i = 1;
      ((g.a)localObject).BB(i);
      ((g.a)localObject).fz(parama.packageName);
      ((g.a)localObject).cdJ();
      ((g.a)localObject).setScene(parama.scene);
      ((g.a)localObject).abf(parama.extInfo);
      ((g.a)localObject).jS(parama.ptC);
      ((g.a)localObject).BF(parama.dQh);
      ((g.a)localObject).BC(parama.pue);
      ((g.a)localObject).BE(parama.pud);
      ((g.a)localObject).BD(parama.puc);
      ((g.a)localObject).jR(parama.pvi);
      ((g.a)localObject).T(parama.pvk);
      ((g.a)localObject).abg(parama.pvf);
      if (parama.dvO != 1) {
        break label388;
      }
      l = f.cdA().b(((g.a)localObject).ptu);
      label267:
      ae.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), parama.appId, Integer.valueOf(parama.dvO) });
      if (paramb != null)
      {
        if ((!parama.ptC) || (az.isWifi(ak.getContext()))) {
          break label403;
        }
        localObject = a.a.puE;
      }
    }
    for (;;)
    {
      paramb.a((a.a)localObject, l);
      if ((parama.ptC) && (!az.isWifi(ak.getContext()))) {
        d.abo(parama.appId);
      }
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8858);
      return l;
      i = parama.fileType;
      break;
      label388:
      l = f.cdA().a(((g.a)localObject).ptu);
      break label267;
      label403:
      if (l > 0L) {
        localObject = a.a.puC;
      } else {
        localObject = a.a.puD;
      }
    }
  }
  
  public static void a(Context paramContext, final long paramLong, final a.b paramb)
  {
    AppMethodBeat.i(8865);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if (locala == null)
    {
      paramb.a(a.a.puD, -1L);
      AppMethodBeat.o(8865);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.api.b)g.ab(com.tencent.mm.plugin.downloader_app.api.b.class)).b(paramContext, locala.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8843);
        d.abn(this.psD.field_appId);
        c.a(this.psD, false, paramb);
        AppMethodBeat.o(8843);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8844);
        paramAnonymousDialogInterface = this.psD;
        this.psD.field_downloadInWifi = false;
        paramAnonymousDialogInterface.field_reserveInWifi = false;
        com.tencent.mm.plugin.downloader.model.d.e(this.psD);
        if (this.psD.field_status == 0) {
          d.abp(this.psD.field_appId);
        }
        if (paramb != null) {
          paramb.a(a.a.puF, paramLong);
        }
        AppMethodBeat.o(8844);
      }
    }, null);
    AppMethodBeat.o(8865);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.downloader.g.a parama, i parami, final a.b paramb)
  {
    AppMethodBeat.i(8861);
    if (!az.isConnected(paramContext))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131761543), paramContext.getString(2131761544), paramContext.getString(2131760601), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8851);
          this.psD.field_status = 4;
          com.tencent.mm.plugin.downloader.model.d.e(this.psD);
          d.uE(this.psD.field_downloadId);
          if (paramb != null) {
            paramb.a(a.a.puD, this.psD.field_downloadId);
          }
          if (paramb != null) {
            paramb.a(a.a.puD, this.psD.field_downloadId);
          }
          AppMethodBeat.o(8851);
        }
      });
      AppMethodBeat.o(8861);
      return;
    }
    if (az.isWifi(paramContext))
    {
      d.abn(parama.field_appId);
      a(parama, false, paramb);
      AppMethodBeat.o(8861);
      return;
    }
    if (parami.pvR.pqT)
    {
      ((com.tencent.mm.plugin.downloader_app.api.b)g.ab(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8852);
          d.abn(this.psD.field_appId);
          c.a(this.psD, false, paramb);
          AppMethodBeat.o(8852);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8853);
          if ((!this.psD.field_reserveInWifi) || (!this.psD.field_downloadInWifi))
          {
            paramAnonymousDialogInterface = this.psD;
            this.psD.field_downloadInWifi = true;
            paramAnonymousDialogInterface.field_reserveInWifi = true;
            com.tencent.mm.plugin.downloader.model.d.e(this.psD);
          }
          paramb.a(a.a.puE, this.psD.field_downloadId);
          AppMethodBeat.o(8853);
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
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766086), paramContext.getString(2131766087), paramContext.getString(2131766081), paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8841);
        d.abn(this.psD.field_appId);
        c.a(this.psD, false, paramb);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8841);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8842);
        if (this.pvp != null) {
          com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(this.pvp.type), this.pvp.position, 4, this.pvp.appId, "", "");
        }
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(8842);
      }
    }, 2131101171);
    AppMethodBeat.o(8861);
  }
  
  public static void a(Context paramContext, a parama, final a.b paramb)
  {
    AppMethodBeat.i(8857);
    if ((paramContext == null) || (!parama.isValid()))
    {
      AppMethodBeat.o(8857);
      return;
    }
    if (!az.isWifi(paramContext))
    {
      if (parama.ptC)
      {
        ((com.tencent.mm.plugin.downloader_app.api.b)g.ab(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8847);
            this.pvn.ptC = false;
            c.a(this.pvn, paramb);
            AppMethodBeat.o(8847);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(8848);
            c.a(this.pvn, paramb);
            AppMethodBeat.o(8848);
          }
        }, null);
        AppMethodBeat.o(8857);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766086), paramContext.getString(2131766087), paramContext.getString(2131766081), paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8849);
          d.abn(this.pvn.appId);
          this.pvn.ptC = false;
          c.a(this.pvn, paramb);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(8849);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8850);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(8850);
        }
      }, 2131101171);
      AppMethodBeat.o(8857);
      return;
    }
    d.abn(parama.appId);
    parama.ptC = false;
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
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(parami.type), parami.position, 23, parami.appId, "", "");
    }
    b(paramContext, parami, paramBoolean);
    AppMethodBeat.o(8855);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(8860);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU(parami.appId);
    if (locala != null)
    {
      locala.field_extInfo = abm(locala.field_extInfo);
      locala.field_downloadType = 1;
      a(paramContext, locala, parami, paramb);
      paramContext = new com.tencent.mm.plugin.downloader.f.b();
      paramContext.k(locala);
      com.tencent.mm.plugin.downloader.f.a.a(10, paramContext);
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(parami.type), parami.position, 6, parami.appId, "", "");
    }
    AppMethodBeat.o(8860);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(8863);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU(parami.appId);
    if (locala != null)
    {
      f.cdA().uk(locala.field_downloadId);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(parami.type), parami.position, 5, locala.field_appId, "", "");
    }
    AppMethodBeat.o(8863);
  }
  
  public static boolean a(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(8862);
    if (!j.contains(parama.field_appId))
    {
      localObject = j.ceq();
      ((LinkedList)localObject).add(parama.field_appId);
      h.a((LinkedList)localObject, null);
      j.abv(parama.field_appId);
    }
    parama.field_showNotification = false;
    parama.field_fromDownloadApp = true;
    parama.field_downloadInWifi = paramBoolean;
    parama.field_reserveInWifi = paramBoolean;
    com.tencent.mm.plugin.downloader.model.d.e(parama);
    paramBoolean = f.cdA().ul(parama.field_downloadId);
    if (paramb != null) {
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (Object localObject = a.a.puC;; localObject = a.a.puD)
    {
      paramb.a((a.a)localObject, parama.field_downloadId);
      com.tencent.mm.modelstat.d.d(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(8862);
      return paramBoolean;
    }
  }
  
  private static String abm(String paramString)
  {
    AppMethodBeat.i(8869);
    if ((paramString != null) && (paramString.contains("OpInWidget")))
    {
      AppMethodBeat.o(8869);
      return paramString;
    }
    if (!bu.isNullOrNil(paramString)) {}
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
  
  private static void b(Context paramContext, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(8856);
    if ((paramContext == null) || (parami == null))
    {
      AppMethodBeat.o(8856);
      return;
    }
    a locala = new a();
    locala.downloadUrl = parami.pvR.fLp;
    locala.pve = parami.pvR.pqR;
    locala.appId = parami.appId;
    locala.appName = parami.appName;
    locala.pvg = parami.pvR.pqL;
    locala.lQS = parami.pvR.pqM;
    locala.packageName = parami.pvR.pqK;
    locala.dvO = parami.pvR.pqN;
    locala.extInfo = cef();
    if (paramBoolean) {}
    for (int i = 6003;; i = 6002)
    {
      locala.scene = i;
      locala.ptC = parami.pvR.pqT;
      locala.fileType = 1;
      locala.dvO = 1;
      locala.pvk = parami.pvR.pqU;
      com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(locala.appId, locala.scene, -1L, ""));
      if (az.isConnected(paramContext)) {
        break;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131761543), paramContext.getString(2131761544), paramContext.getString(2131760601), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(8840);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.downloader.model.d.aaU(this.pvn.appId);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_status = 4;
            com.tencent.mm.plugin.downloader.model.d.e(paramAnonymousDialogInterface);
          }
          for (;;)
          {
            d.uE(paramAnonymousDialogInterface.field_downloadId);
            if (this.pvo != null) {
              this.pvo.a(a.a.puD, paramAnonymousDialogInterface.field_downloadId);
            }
            AppMethodBeat.o(8840);
            return;
            paramAnonymousDialogInterface = new com.tencent.mm.plugin.downloader.g.a();
            paramAnonymousDialogInterface.field_downloadId = System.currentTimeMillis();
            paramAnonymousDialogInterface.field_appId = this.pvn.appId;
            paramAnonymousDialogInterface.field_downloadUrl = this.pvn.downloadUrl;
            paramAnonymousDialogInterface.field_status = 4;
            com.tencent.mm.plugin.downloader.model.d.d(paramAnonymousDialogInterface);
          }
        }
      });
      AppMethodBeat.o(8856);
      return;
    }
    a(paramContext, locala, null);
    AppMethodBeat.o(8856);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(8864);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU(parami.appId);
    if (locala != null) {
      f.cdA().ui(locala.field_downloadId);
    }
    com.tencent.mm.plugin.downloader_app.b.a.a(11, com.tencent.mm.plugin.downloader_app.b.a.BG(parami.type), parami.position, 81, parami.appId, "", "");
    AppMethodBeat.o(8864);
  }
  
  public static boolean b(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8866);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU(parami.appId);
    if (locala == null)
    {
      AppMethodBeat.o(8866);
      return false;
    }
    if (o.fB(locala.field_filePath))
    {
      com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, null);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(parami.type), parami.position, 44, parami.appId, "", "");
      AppMethodBeat.o(8866);
      return true;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131761828), paramContext.getString(2131761829), paramContext.getString(2131762558), paramContext.getString(2131764382), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8845);
        c.a(this.val$context, parami);
        AppMethodBeat.o(8845);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8866);
    return false;
  }
  
  public static void c(Context paramContext, final i parami)
  {
    AppMethodBeat.i(8867);
    if (q.s(paramContext, parami.pvR.pqK))
    {
      com.tencent.mm.plugin.downloader.i.a.a(paramContext, parami.appId, null);
      com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.BG(parami.type), parami.position, 22, parami.appId, "", "");
      AppMethodBeat.o(8867);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131755911), paramContext.getString(2131755912), paramContext.getString(2131762558), paramContext.getString(2131764382), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8846);
        c.a(this.val$context, parami);
        AppMethodBeat.o(8846);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(8867);
  }
  
  private static String cef()
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