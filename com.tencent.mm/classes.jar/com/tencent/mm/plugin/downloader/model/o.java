package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  private static void a(Context paramContext, final long paramLong, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(220233);
    final com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if (locala == null)
    {
      parama.i("fail", null);
      AppMethodBeat.o(220233);
      return;
    }
    PBool localPBool = new PBool();
    final JSONObject localJSONObject = new JSONObject();
    ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new com.tencent.mm.plugin.downloader_app.api.b.a()new com.tencent.mm.plugin.downloader_app.api.b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(220436);
        this.uiy.value = true;
        o.a(locala, false, paramBoolean, parama);
        AppMethodBeat.o(220436);
      }
    }, new com.tencent.mm.plugin.downloader_app.api.b.a()new com.tencent.mm.plugin.downloader_app.api.b.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(219769);
        this.uiy.value = true;
        try
        {
          localJSONObject.put("reserve_for_wifi", 0);
          localJSONObject.put("download_id", paramLong);
          label38:
          com.tencent.mm.plugin.downloader.g.a locala = parama;
          parama.field_downloadInWifi = false;
          locala.field_reserveInWifi = false;
          d.e(parama);
          if (parama.field_status == 0) {
            ((c)com.tencent.mm.kernel.h.ae(c.class)).LG(parama.field_appId);
          }
          this.uiv.i(null, localJSONObject);
          AppMethodBeat.o(219769);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label38;
        }
      }
    }, new com.tencent.mm.plugin.downloader_app.api.b.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(219649);
        if (this.uiy.value)
        {
          AppMethodBeat.o(219649);
          return;
        }
        parama.i("cancel", null);
        AppMethodBeat.o(219649);
      }
    });
    AppMethodBeat.o(220233);
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean1, final boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(220226);
    if (paramLong <= 0L)
    {
      Log.e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(paramLong)));
      parama.i("invalid_downloadid", null);
      AppMethodBeat.o(220226);
      return;
    }
    final com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if (locala == null)
    {
      parama.i("fail", null);
      AppMethodBeat.o(220226);
      return;
    }
    Object localObject = f.cPZ().Ix(locala.field_downloadId);
    if (localObject != null)
    {
      if (((FileDownloadTaskInfo)localObject).status == 1)
      {
        parama.i(null, null);
        AppMethodBeat.o(220226);
        return;
      }
      if (((FileDownloadTaskInfo)localObject).status == 3)
      {
        com.tencent.mm.plugin.downloader.i.a.a(((FileDownloadTaskInfo)localObject).id, false, null);
        parama.i(null, null);
        AppMethodBeat.o(220226);
        return;
      }
    }
    if ((paramBoolean2) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vul, false))) {}
    for (int i = 1;; i = 0)
    {
      if (NetStatusUtil.isWifi(paramContext))
      {
        a(locala, false, paramBoolean2, parama);
        AppMethodBeat.o(220226);
        return;
      }
      if (paramBoolean1)
      {
        if (locala.field_reserveInWifi)
        {
          a(paramContext, locala.field_downloadId, paramBoolean2, parama);
          AppMethodBeat.o(220226);
          return;
        }
        if (i != 0)
        {
          a(locala, false, paramBoolean2, parama);
          AppMethodBeat.o(220226);
          return;
        }
        localObject = new PBool();
        ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, locala.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89047);
            this.uit.value = true;
            o.a(locala, false, paramBoolean2, parama);
            AppMethodBeat.o(89047);
          }
        }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89048);
            this.uit.value = true;
            o.a(locala, true, paramBoolean2, parama);
            AppMethodBeat.o(89048);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(89049);
            if (this.uit.value)
            {
              AppMethodBeat.o(89049);
              return;
            }
            parama.i("cancel", null);
            AppMethodBeat.o(89049);
          }
        });
        AppMethodBeat.o(220226);
        return;
      }
      if (locala.field_reserveInWifi)
      {
        locala.field_downloadInWifi = false;
        locala.field_reserveInWifi = false;
        d.e(locala);
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_title), paramContext.getString(c.d.webview_download_ui_btn_state_to_download), paramContext.getString(c.d.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89050);
          o.a(this.uhi, false, paramBoolean2, parama);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(89050);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89051);
          paramAnonymousDialogInterface.dismiss();
          this.uiv.i("fail_network_not_wifi", null);
          AppMethodBeat.o(89051);
        }
      }, c.a.wechat_green);
      AppMethodBeat.o(220226);
      return;
    }
  }
  
  public static void a(Context paramContext, final com.tencent.mm.plugin.downloader_app.a.a parama, final a parama1)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89064);
    if ((parama == null) || (!parama.isValid()))
    {
      parama1.i("fail", null);
      AppMethodBeat.o(89064);
      return;
    }
    if (!NetStatusUtil.isNetworkConnected(paramContext))
    {
      parama1.i("network_not_connected", null);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89046);
          Toast.makeText(this.val$context, this.val$context.getString(c.d.game_download_network_unavailable), 0).show();
          AppMethodBeat.o(89046);
        }
      });
      Log.i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
      AppMethodBeat.o(89064);
      return;
    }
    if (!e.avA())
    {
      parama1.i("sdcard_not_ready", null);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89056);
          Toast.makeText(this.val$context, this.val$context.getString(c.d.game_download_sdcard_unavailable), 0).show();
          AppMethodBeat.o(89056);
        }
      });
      Log.i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
      AppMethodBeat.o(89064);
      return;
    }
    if ((parama.ulH > 0L) && (!h.IO(parama.ulH)) && (!h.IN(parama.ulH)))
    {
      parama1.i("has_not_enough_space", null);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89057);
          Toast.makeText(this.val$context, this.val$context.getString(c.d.game_download_not_enough_space), 0).show();
          AppMethodBeat.o(89057);
        }
      });
      Log.i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + parama.ulH);
      AppMethodBeat.o(89064);
      return;
    }
    if ((parama.ulM) && (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vul, false))) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.downloader.g.a locala = d.asX(parama.downloadUrl);
      Object localObject = new JSONObject();
      FileDownloadTaskInfo localFileDownloadTaskInfo;
      if (locala != null)
      {
        localFileDownloadTaskInfo = f.cPZ().Ix(locala.field_downloadId);
        if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status != 1)) {}
      }
      try
      {
        ((JSONObject)localObject).put("download_id", localFileDownloadTaskInfo.id);
        label290:
        parama1.i(null, (JSONObject)localObject);
        AppMethodBeat.o(89064);
        return;
        if (localFileDownloadTaskInfo.status == 3) {
          com.tencent.mm.plugin.downloader.i.a.a(localFileDownloadTaskInfo.id, false, null);
        }
        try
        {
          ((JSONObject)localObject).put("download_id", localFileDownloadTaskInfo.id);
          label338:
          parama1.i(null, (JSONObject)localObject);
          AppMethodBeat.o(89064);
          return;
          if (i != 0) {
            if (NetStatusUtil.isWifi(paramContext))
            {
              bool1 = true;
              a(locala, bool1, parama.ulM, parama1);
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
            if ((!parama.uij) || (!locala.field_reserveInWifi) || (NetStatusUtil.isWifi(paramContext))) {
              break label379;
            }
            a(paramContext, locala.field_downloadId, parama.ulM, parama1);
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
          if (parama.uij)
          {
            localObject = new PBool();
            ((com.tencent.mm.plugin.downloader_app.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89058);
                this.uit.value = true;
                o.a(parama, parama1, false);
                AppMethodBeat.o(89058);
              }
            }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(89059);
                this.uit.value = true;
                o.a(parama, parama1, true);
                AppMethodBeat.o(89059);
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(89060);
                if (this.uit.value)
                {
                  AppMethodBeat.o(89060);
                  return;
                }
                parama1.i("cancel", null);
                AppMethodBeat.o(89060);
              }
            });
            AppMethodBeat.o(89064);
            return;
          }
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_tips), paramContext.getString(c.d.webview_download_ui_download_not_in_wifi_title), paramContext.getString(c.d.webview_download_ui_btn_state_to_download), paramContext.getString(c.d.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(89061);
              o.a(this.uiz, parama1, false);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(89061);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(89062);
              paramAnonymousDialogInterface.dismiss();
              this.uiv.i("network_not_wifi", null);
              AppMethodBeat.o(89062);
            }
          }, c.a.wechat_green);
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
  
  static void a(com.tencent.mm.plugin.downloader.g.a parama, final boolean paramBoolean1, boolean paramBoolean2, final a parama1)
  {
    AppMethodBeat.i(220230);
    com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
    ((c)com.tencent.mm.kernel.h.ae(c.class)).a(parama.field_downloadId, paramBoolean1, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(220210);
        if (paramAnonymousa == a.a.ulA) {
          paramAnonymousa = new JSONObject();
        }
        try
        {
          paramAnonymousa.put("download_id", paramAnonymousLong);
          o.j(this.uiu, paramAnonymousa);
          if ((paramBoolean1) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
            paramAnonymousa.put("reserve_for_wifi", 1);
          }
          label60:
          parama1.i(null, paramAnonymousa);
          AppMethodBeat.o(220210);
          return;
          if (paramAnonymousa == a.a.ulD)
          {
            parama1.i("cancel", null);
            AppMethodBeat.o(220210);
            return;
          }
          parama1.i("fail", null);
          AppMethodBeat.o(220210);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label60;
        }
      }
    });
    AppMethodBeat.o(220230);
  }
  
  static void a(com.tencent.mm.plugin.downloader_app.a.a parama, final a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(89065);
    parama.uij = paramBoolean;
    ((c)com.tencent.mm.kernel.h.ae(c.class)).a(parama, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(89063);
        JSONObject localJSONObject = new JSONObject();
        if (paramAnonymousa == a.a.ulA)
        {
          com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
          try
          {
            localJSONObject.put("download_id", paramAnonymousLong);
            o.j(this.uiz.ulM, localJSONObject);
            parama1.i(null, localJSONObject);
            AppMethodBeat.o(89063);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            parama1.i(null, null);
            AppMethodBeat.o(89063);
            return;
          }
        }
        if (paramAnonymousa == a.a.ulC) {
          try
          {
            localJSONObject.put("download_id", paramAnonymousLong);
            localJSONObject.put("reserve_for_wifi", 1);
            parama1.i(null, localJSONObject);
            AppMethodBeat.o(89063);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            parama1.i(null, null);
            AppMethodBeat.o(89063);
            return;
          }
        }
        if (paramAnonymousa == a.a.ulD)
        {
          parama1.i("cancel", null);
          AppMethodBeat.o(89063);
          return;
        }
        if (paramAnonymousa == a.a.ulB) {
          parama1.i("fail", null);
        }
        AppMethodBeat.o(89063);
      }
    });
    AppMethodBeat.o(89065);
  }
  
  public static abstract interface a
  {
    public abstract void i(String paramString, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o
 * JD-Core Version:    0.7.0.1
 */