package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.api.b;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  private static void a(Context paramContext, final long paramLong, final a parama)
  {
    AppMethodBeat.i(89068);
    final com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if (locala == null)
    {
      parama.f("fail", null);
      AppMethodBeat.o(89068);
      return;
    }
    PBool localPBool = new PBool();
    final JSONObject localJSONObject = new JSONObject();
    ((b)g.ab(b.class)).b(paramContext, locala.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89053);
        this.ofY.value = true;
        o.a(locala, false, parama);
        AppMethodBeat.o(89053);
      }
    }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89054);
        this.ofY.value = true;
        try
        {
          localJSONObject.put("reserve_for_wifi", 0);
          localJSONObject.put("download_id", paramLong);
          label38:
          paramAnonymousDialogInterface = parama;
          parama.field_downloadInWifi = false;
          paramAnonymousDialogInterface.field_reserveInWifi = false;
          d.e(parama);
          if (parama.field_status == 0) {
            ((c)g.ab(c.class)).pR(parama.field_appId);
          }
          this.ofW.f(null, localJSONObject);
          AppMethodBeat.o(89054);
          return;
        }
        catch (JSONException paramAnonymousDialogInterface)
        {
          break label38;
        }
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89055);
        if (this.ofY.value)
        {
          AppMethodBeat.o(89055);
          return;
        }
        parama.f("cancel", null);
        AppMethodBeat.o(89055);
      }
    });
    AppMethodBeat.o(89068);
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(89066);
    if (paramLong <= 0L)
    {
      ad.e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(paramLong)));
      parama.f("invalid_downloadid", null);
      AppMethodBeat.o(89066);
      return;
    }
    final com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if (locala == null)
    {
      parama.f("fail", null);
      AppMethodBeat.o(89066);
      return;
    }
    Object localObject = f.bQt().oh(locala.field_downloadId);
    if (localObject != null)
    {
      if (((FileDownloadTaskInfo)localObject).status == 1)
      {
        parama.f(null, null);
        AppMethodBeat.o(89066);
        return;
      }
      if (((FileDownloadTaskInfo)localObject).status == 3)
      {
        com.tencent.mm.plugin.downloader.i.a.a(((FileDownloadTaskInfo)localObject).id, false, null);
        parama.f(null, null);
        AppMethodBeat.o(89066);
        return;
      }
    }
    if (ay.isWifi(paramContext))
    {
      a(locala, false, parama);
      AppMethodBeat.o(89066);
      return;
    }
    if (paramBoolean)
    {
      if (locala.field_reserveInWifi)
      {
        a(paramContext, locala.field_downloadId, parama);
        AppMethodBeat.o(89066);
        return;
      }
      localObject = new PBool();
      ((b)g.ab(b.class)).a(paramContext, locala.field_appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89047);
          this.ofV.value = true;
          o.a(locala, false, parama);
          AppMethodBeat.o(89047);
        }
      }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89048);
          this.ofV.value = true;
          o.a(locala, true, parama);
          AppMethodBeat.o(89048);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(89049);
          if (this.ofV.value)
          {
            AppMethodBeat.o(89049);
            return;
          }
          parama.f("cancel", null);
          AppMethodBeat.o(89049);
        }
      });
      AppMethodBeat.o(89066);
      return;
    }
    if (locala.field_reserveInWifi)
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766086), paramContext.getString(2131766087), paramContext.getString(2131766081), paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89050);
        o.a(this.oeS, false, parama);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(89050);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89051);
        paramAnonymousDialogInterface.dismiss();
        this.ofW.f("fail_network_not_wifi", null);
        AppMethodBeat.o(89051);
      }
    }, 2131101171);
    AppMethodBeat.o(89066);
  }
  
  public static void a(Context paramContext, final com.tencent.mm.plugin.downloader_app.a.a parama, final a parama1)
  {
    AppMethodBeat.i(89064);
    if ((parama == null) || (!parama.isValid()))
    {
      parama1.f("fail", null);
      AppMethodBeat.o(89064);
      return;
    }
    if (!ay.isNetworkConnected(paramContext))
    {
      parama1.f("network_not_connected", null);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89046);
          Toast.makeText(this.val$context, this.val$context.getString(2131759864), 0).show();
          AppMethodBeat.o(89046);
        }
      });
      ad.i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
      AppMethodBeat.o(89064);
      return;
    }
    if (!e.XG())
    {
      parama1.f("sdcard_not_ready", null);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89056);
          Toast.makeText(this.val$context, this.val$context.getString(2131759868), 0).show();
          AppMethodBeat.o(89056);
        }
      });
      ad.i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
      AppMethodBeat.o(89064);
      return;
    }
    if ((parama.ohs > 0L) && (!h.oA(parama.ohs)) && (!h.oz(parama.ohs)))
    {
      parama1.f("has_not_enough_space", null);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89057);
          Toast.makeText(this.val$context, this.val$context.getString(2131759865), 0).show();
          AppMethodBeat.o(89057);
        }
      });
      ad.i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + parama.ohs);
      AppMethodBeat.o(89064);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Sn(parama.downloadUrl);
    Object localObject = new JSONObject();
    FileDownloadTaskInfo localFileDownloadTaskInfo;
    if (locala != null)
    {
      localFileDownloadTaskInfo = f.bQt().oh(locala.field_downloadId);
      if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status != 1)) {}
    }
    try
    {
      ((JSONObject)localObject).put("download_id", localFileDownloadTaskInfo.id);
      label252:
      parama1.f(null, (JSONObject)localObject);
      AppMethodBeat.o(89064);
      return;
      if (localFileDownloadTaskInfo.status == 3) {
        com.tencent.mm.plugin.downloader.i.a.a(localFileDownloadTaskInfo.id, false, null);
      }
      try
      {
        ((JSONObject)localObject).put("download_id", localFileDownloadTaskInfo.id);
        label298:
        parama1.f(null, (JSONObject)localObject);
        AppMethodBeat.o(89064);
        return;
        if ((parama.ofN) && (locala.field_reserveInWifi) && (!ay.isWifi(paramContext)))
        {
          a(paramContext, locala.field_downloadId, parama1);
          AppMethodBeat.o(89064);
          return;
        }
        if (ay.isWifi(paramContext))
        {
          a(parama, parama1, false);
          AppMethodBeat.o(89064);
          return;
        }
        if (parama.ofN)
        {
          localObject = new PBool();
          ((b)g.ab(b.class)).a(paramContext, parama.appId, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(89058);
              this.ofV.value = true;
              o.a(parama, parama1, false);
              AppMethodBeat.o(89058);
            }
          }, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(89059);
              this.ofV.value = true;
              o.a(parama, parama1, true);
              AppMethodBeat.o(89059);
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(89060);
              if (this.ofV.value)
              {
                AppMethodBeat.o(89060);
                return;
              }
              parama1.f("cancel", null);
              AppMethodBeat.o(89060);
            }
          });
          AppMethodBeat.o(89064);
          return;
        }
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766086), paramContext.getString(2131766087), paramContext.getString(2131766081), paramContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89061);
            o.a(this.oga, parama1, false);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(89061);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89062);
            paramAnonymousDialogInterface.dismiss();
            this.ofW.f("network_not_wifi", null);
            AppMethodBeat.o(89062);
          }
        }, 2131101171);
        AppMethodBeat.o(89064);
        return;
      }
      catch (JSONException paramContext)
      {
        break label298;
      }
    }
    catch (JSONException paramContext)
    {
      break label252;
    }
  }
  
  static void a(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, final a parama1)
  {
    AppMethodBeat.i(89067);
    com.tencent.mm.modelstat.d.c(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
    ((c)g.ab(c.class)).a(parama.field_downloadId, paramBoolean, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(89052);
        if (paramAnonymousa == a.a.ogO) {
          paramAnonymousa = new JSONObject();
        }
        try
        {
          paramAnonymousa.put("download_id", paramAnonymousLong);
          if ((this.ofX) && (!ay.isWifi(aj.getContext()))) {
            paramAnonymousa.put("reserve_for_wifi", 1);
          }
          label52:
          parama1.f(null, paramAnonymousa);
          AppMethodBeat.o(89052);
          return;
          if (paramAnonymousa == a.a.ogR)
          {
            parama1.f("cancel", null);
            AppMethodBeat.o(89052);
            return;
          }
          parama1.f("fail", null);
          AppMethodBeat.o(89052);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label52;
        }
      }
    });
    AppMethodBeat.o(89067);
  }
  
  static void a(com.tencent.mm.plugin.downloader_app.a.a parama, a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(89065);
    parama.ofN = paramBoolean;
    ((c)g.ab(c.class)).a(parama, new a.b()
    {
      public final void a(a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(89063);
        JSONObject localJSONObject = new JSONObject();
        if (paramAnonymousa == a.a.ogO)
        {
          com.tencent.mm.modelstat.d.c(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
          try
          {
            localJSONObject.put("download_id", paramAnonymousLong);
            this.ofW.f(null, localJSONObject);
            AppMethodBeat.o(89063);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            this.ofW.f(null, null);
            AppMethodBeat.o(89063);
            return;
          }
        }
        if (paramAnonymousa == a.a.ogQ) {
          try
          {
            localJSONObject.put("download_id", paramAnonymousLong);
            localJSONObject.put("reserve_for_wifi", 1);
            this.ofW.f(null, localJSONObject);
            AppMethodBeat.o(89063);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            this.ofW.f(null, null);
            AppMethodBeat.o(89063);
            return;
          }
        }
        if (paramAnonymousa == a.a.ogR)
        {
          this.ofW.f("cancel", null);
          AppMethodBeat.o(89063);
          return;
        }
        if (paramAnonymousa == a.a.ogP) {
          this.ofW.f("fail", null);
        }
        AppMethodBeat.o(89063);
      }
    });
    AppMethodBeat.o(89065);
  }
  
  public static abstract interface a
  {
    public abstract void f(String paramString, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o
 * JD-Core Version:    0.7.0.1
 */