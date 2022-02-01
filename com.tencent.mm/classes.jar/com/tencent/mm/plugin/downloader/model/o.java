package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.api.b.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.k;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  private static void a(Context paramContext, final long paramLong, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(267121);
    final com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if (locala == null)
    {
      parama.j("fail", null);
      AppMethodBeat.o(267121);
      return;
    }
    PBool localPBool = new PBool();
    final JSONObject localJSONObject = new JSONObject();
    ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new b.a()new b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(267115);
        o.this.value = true;
        o.a(locala, false, paramBoolean, parama);
        AppMethodBeat.o(267115);
      }
    }, new b.a()new b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(267114);
        o.this.value = true;
        try
        {
          localJSONObject.put("reserve_for_wifi", 0);
          localJSONObject.put("download_id", paramLong);
          label38:
          com.tencent.mm.plugin.downloader.f.a locala = parama;
          parama.field_downloadInWifi = false;
          locala.field_reserveInWifi = false;
          d.e(parama);
          if (parama.field_status == 0) {
            ((c)com.tencent.mm.kernel.h.ax(c.class)).Em(parama.field_appId);
          }
          this.xoy.j(null, localJSONObject);
          AppMethodBeat.o(267114);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label38;
        }
      }
    }, new b.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(267113);
        if (o.this.value)
        {
          AppMethodBeat.o(267113);
          return;
        }
        parama.j("cancel", null);
        AppMethodBeat.o(267113);
      }
    });
    AppMethodBeat.o(267121);
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(267118);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(paramLong)));
      parama.j("invalid_downloadid", null);
      AppMethodBeat.o(267118);
      return;
    }
    final com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if (locala == null)
    {
      parama.j("fail", null);
      AppMethodBeat.o(267118);
      return;
    }
    Object localObject = f.duv().kS(locala.field_downloadId);
    if (localObject != null)
    {
      if (((FileDownloadTaskInfo)localObject).status == 1)
      {
        parama.j(null, null);
        AppMethodBeat.o(267118);
        return;
      }
      if (((FileDownloadTaskInfo)localObject).status == 3)
      {
        com.tencent.mm.plugin.downloader.h.a.a(((FileDownloadTaskInfo)localObject).id, false, null);
        parama.j(null, null);
        AppMethodBeat.o(267118);
        return;
      }
    }
    if ((paramBoolean2) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.c.a.yGQ, false))) {}
    for (int i = 1;; i = 0)
    {
      if (NetStatusUtil.isWifi(paramContext))
      {
        a(locala, false, paramBoolean2, parama);
        AppMethodBeat.o(267118);
        return;
      }
      if (paramBoolean1)
      {
        if (locala.field_reserveInWifi)
        {
          a(paramContext, locala.field_downloadId, paramBoolean2, parama);
          AppMethodBeat.o(267118);
          return;
        }
        if (i != 0)
        {
          a(locala, false, paramBoolean2, parama);
          AppMethodBeat.o(267118);
          return;
        }
        localObject = new PBool();
        ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89047);
            o.this.value = true;
            o.a(locala, false, paramBoolean2, parama);
            AppMethodBeat.o(89047);
          }
        }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89048);
            o.this.value = true;
            o.a(locala, true, paramBoolean2, parama);
            AppMethodBeat.o(89048);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(89049);
            if (o.this.value)
            {
              AppMethodBeat.o(89049);
              return;
            }
            parama.j("cancel", null);
            AppMethodBeat.o(89049);
          }
        });
        AppMethodBeat.o(267118);
        return;
      }
      if (locala.field_reserveInWifi)
      {
        locala.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
        d.e(locala);
      }
      k.a(paramContext, paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_title), paramContext.getString(c.d.webview_download_ui_btn_state_to_download), paramContext.getString(c.d.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89050);
          o.a(o.this, false, paramBoolean2, parama);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(89050);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89051);
          paramAnonymousDialogInterface.dismiss();
          o.this.j("fail_network_not_wifi", null);
          AppMethodBeat.o(89051);
        }
      }, com.tencent.mm.plugin.downloader.c.a.wechat_green);
      AppMethodBeat.o(267118);
      return;
    }
  }
  
  public static void a(Context paramContext, final com.tencent.mm.plugin.downloader_app.a.a parama, final a parama1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89064);
    if ((parama == null) || (!parama.isValid()))
    {
      parama1.j("fail", null);
      AppMethodBeat.o(89064);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(paramContext))
    {
      parama1.j("network_not_connected", null);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89046);
          Toast.makeText(o.this, o.this.getString(c.d.game_download_network_unavailable), 0).show();
          AppMethodBeat.o(89046);
        }
      });
      Log.i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
      AppMethodBeat.o(89064);
      return;
    }
    if (!e.aPU())
    {
      parama1.j("sdcard_not_ready", null);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89056);
          Toast.makeText(o.this, o.this.getString(c.d.game_download_sdcard_unavailable), 0).show();
          AppMethodBeat.o(89056);
        }
      });
      Log.i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
      AppMethodBeat.o(89064);
      return;
    }
    if ((parama.xrT > 0L) && (!h.lj(parama.xrT)) && (!h.li(parama.xrT)))
    {
      parama1.j("has_not_enough_space", null);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89057);
          Toast.makeText(o.this, o.this.getString(c.d.game_download_not_enough_space), 0).show();
          AppMethodBeat.o(89057);
        }
      });
      Log.i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + parama.xrT);
      AppMethodBeat.o(89064);
      return;
    }
    if ((parama.xrY) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.c.a.yGQ, false))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.downloader.f.a locala = d.amM(parama.downloadUrl);
      Object localObject = new JSONObject();
      FileDownloadTaskInfo localFileDownloadTaskInfo;
      if (locala != null)
      {
        localFileDownloadTaskInfo = f.duv().kS(locala.field_downloadId);
        if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status != 1)) {}
      }
      try
      {
        ((JSONObject)localObject).put("download_id", localFileDownloadTaskInfo.id);
        label290:
        parama1.j(null, (JSONObject)localObject);
        AppMethodBeat.o(89064);
        return;
        if (localFileDownloadTaskInfo.status == 3) {
          com.tencent.mm.plugin.downloader.h.a.a(localFileDownloadTaskInfo.id, false, null);
        }
        try
        {
          ((JSONObject)localObject).put("download_id", localFileDownloadTaskInfo.id);
          label338:
          parama1.j(null, (JSONObject)localObject);
          AppMethodBeat.o(89064);
          return;
          if (i != 0) {
            if (NetStatusUtil.isWifi(paramContext))
            {
              bool1 = true;
              a(locala, bool1, parama.xrY, parama1);
              label379:
              if (i == 0) {
                break label461;
              }
              if (!NetStatusUtil.isWifi(paramContext)) {
                break label455;
              }
            }
          }
          label455:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            a(parama, parama1, bool1);
            AppMethodBeat.o(89064);
            return;
            bool1 = false;
            break;
            if ((!parama.xoo) || (!locala.field_reserveInWifi) || (NetStatusUtil.isWifi(paramContext))) {
              break label379;
            }
            a(paramContext, locala.field_downloadId, parama.xrY, parama1);
            AppMethodBeat.o(89064);
            return;
          }
          label461:
          if (NetStatusUtil.isWifi(paramContext))
          {
            a(parama, parama1, false);
            AppMethodBeat.o(89064);
            return;
          }
          if (parama.xoo)
          {
            localObject = new PBool();
            ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89058);
                o.this.value = true;
                o.a(parama, parama1, false);
                AppMethodBeat.o(89058);
              }
            }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89059);
                o.this.value = true;
                o.a(parama, parama1, true);
                AppMethodBeat.o(89059);
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(89060);
                if (o.this.value)
                {
                  AppMethodBeat.o(89060);
                  return;
                }
                parama1.j("cancel", null);
                AppMethodBeat.o(89060);
              }
            });
            AppMethodBeat.o(89064);
            return;
          }
          k.a(paramContext, paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_title), paramContext.getString(c.d.webview_download_ui_btn_state_to_download), paramContext.getString(c.d.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(89061);
              o.a(o.this, parama1, false);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(89061);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(89062);
              paramAnonymousDialogInterface.dismiss();
              o.this.j("network_not_wifi", null);
              AppMethodBeat.o(89062);
            }
          }, com.tencent.mm.plugin.downloader.c.a.wechat_green);
          AppMethodBeat.o(89064);
          return;
        }
        catch (JSONException paramContext)
        {
          break label338;
        }
      }
      catch (JSONException paramContext)
      {
        break label290;
      }
    }
  }
  
  static void a(com.tencent.mm.plugin.downloader.f.a parama, final boolean paramBoolean1, boolean paramBoolean2, final a parama1)
  {
    AppMethodBeat.i(267119);
    com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
    ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama.field_downloadId, paramBoolean1, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(267122);
        if (paramAnonymousa == a.a.xrM) {
          paramAnonymousa = new JSONObject();
        }
        try
        {
          paramAnonymousa.put("download_id", paramAnonymousLong);
          o.j(this.xox, paramAnonymousa);
          if ((paramBoolean1) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
            paramAnonymousa.put("reserve_for_wifi", 1);
          }
          label60:
          parama1.j(null, paramAnonymousa);
          AppMethodBeat.o(267122);
          return;
          if (paramAnonymousa == a.a.xrP)
          {
            parama1.j("cancel", null);
            AppMethodBeat.o(267122);
            return;
          }
          parama1.j("fail", null);
          AppMethodBeat.o(267122);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label60;
        }
      }
    });
    AppMethodBeat.o(267119);
  }
  
  static void a(com.tencent.mm.plugin.downloader_app.a.a parama, final a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(89065);
    parama.xoo = paramBoolean;
    ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(89063);
        JSONObject localJSONObject = new JSONObject();
        if (paramAnonymousa == a.a.xrM)
        {
          com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
          try
          {
            localJSONObject.put("download_id", paramAnonymousLong);
            o.j(o.this.xrY, localJSONObject);
            parama1.j(null, localJSONObject);
            AppMethodBeat.o(89063);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            parama1.j(null, null);
            AppMethodBeat.o(89063);
            return;
          }
        }
        if (paramAnonymousa == a.a.xrO) {
          try
          {
            localJSONObject.put("download_id", paramAnonymousLong);
            localJSONObject.put("reserve_for_wifi", 1);
            parama1.j(null, localJSONObject);
            AppMethodBeat.o(89063);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            parama1.j(null, null);
            AppMethodBeat.o(89063);
            return;
          }
        }
        if (paramAnonymousa == a.a.xrP)
        {
          parama1.j("cancel", null);
          AppMethodBeat.o(89063);
          return;
        }
        if (paramAnonymousa == a.a.xrN) {
          parama1.j("fail", null);
        }
        AppMethodBeat.o(89063);
      }
    });
    AppMethodBeat.o(89065);
  }
  
  public static abstract interface a
  {
    public abstract void j(String paramString, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o
 * JD-Core Version:    0.7.0.1
 */