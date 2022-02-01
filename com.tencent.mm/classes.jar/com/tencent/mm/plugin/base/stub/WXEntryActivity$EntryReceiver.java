package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.h.a;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public class WXEntryActivity$EntryReceiver
  extends BroadcastReceiver
{
  private static MMHandler handler;
  private String appId;
  private String appName;
  private String bJH;
  private Context context;
  private int sdkVersion;
  private long vsE;
  
  private void b(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(22284);
    if (!u.a(this.context, paramg, this.bJH, false))
    {
      Log.e("MicroMsg.WXEntryActivity", "reg fail, check app fail");
      as.gxm().bpP(this.appId);
      AppMethodBeat.o(22284);
      return;
    }
    if ((paramg != null) && (paramg.aqJ()))
    {
      localObject1 = b.a.fCn();
      if (localObject1 != null) {
        ((b)localObject1).o(this.context, this.appId, this.bJH);
      }
    }
    localObject1 = null;
    try
    {
      localObject2 = this.context.getPackageManager();
      ApplicationInfo localApplicationInfo = ((PackageManager)localObject2).getApplicationInfo(this.bJH, 0);
      if (localApplicationInfo == null)
      {
        Log.e("MicroMsg.WXEntryActivity", "package not installed");
        AppMethodBeat.o(22284);
        return;
      }
      this.appName = localApplicationInfo.loadLabel((PackageManager)localObject2).toString();
      localObject2 = localApplicationInfo.loadIcon((PackageManager)localObject2);
      if (!(localObject2 instanceof BitmapDrawable)) {
        break label625;
      }
      localObject2 = ((BitmapDrawable)localObject2).getBitmap();
      localObject1 = localObject2;
    }
    catch (IncompatibleClassChangeError paramg)
    {
      Object localObject2;
      Log.printErrStackTrace("MicroMsg.Crash", paramg, "May cause dvmFindCatchBlock crash!", new Object[0]);
      paramg = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramg);
      AppMethodBeat.o(22284);
      throw paramg;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WXEntryActivity", localThrowable, "package not installed", new Object[0]);
        continue;
        boolean bool = y.ZC(j.it(localThrowable, 1));
        continue;
        int i;
        if ((paramg.field_appInfoFlag & 0x2000) != 0) {
          if (this.vsE != paramg.field_appSupportContentType)
          {
            i = 1;
            paramg.field_appSupportContentType = this.vsE;
          }
        }
        for (;;)
        {
          if ((paramg.field_status == 2) || (paramg.field_status == 3) || (paramg.field_status == 4) || (i != 0))
          {
            if (!paramg.aqJ()) {
              d.brx(this.appId);
            }
            paramg.field_status = 0;
            Log.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, updateRet = ".concat(String.valueOf(as.gxn().a(paramg, new String[0]))));
          }
          if (Util.isNullOrNil(paramg.field_openId))
          {
            Log.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + this.appId);
            as.gxp().add(this.appId);
          }
          AppMethodBeat.o(22284);
          return;
          i = 0;
          break;
          i = 0;
        }
        localObject1 = null;
      }
    }
    if (paramg != null)
    {
      as.gxn();
      localObject2 = this.appId;
      if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
        break label444;
      }
      Log.e("MicroMsg.AppInfoStorage", "hasIcon, appId is null");
      bool = false;
      if (bool) {}
    }
    else
    {
      as.gxn().u(this.appId, (Bitmap)localObject1);
    }
    if (paramg == null)
    {
      paramg = new com.tencent.mm.pluginsdk.model.app.g();
      paramg.field_appId = this.appId;
      paramg.field_appName = "";
      paramg.field_packageName = this.bJH;
      paramg.field_status = 0;
      localObject1 = u.cE(this.context, this.bJH);
      if (localObject1 != null) {
        paramg.field_signature = ((String)localObject1);
      }
      paramg.field_modifyTime = System.currentTimeMillis();
      paramg.field_appSupportContentType = this.vsE;
      bool = as.gxn().r(paramg);
      d.brx(this.appId);
      if ((bool) && (Util.isNullOrNil(paramg.field_openId)))
      {
        Log.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + this.appId);
        as.gxp().add(this.appId);
      }
      AppMethodBeat.o(22284);
      return;
    }
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(22283);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(22283);
      return;
    }
    if (c.iPe())
    {
      Log.i("MicroMsg.WXEntryActivity", "lite version do not suport open api");
      AppMethodBeat.o(22283);
      return;
    }
    if (handler == null) {
      handler = new MMHandler("WXEntryReceiver");
    }
    if (!h.baF().mDl.mDG)
    {
      h.baF().a(new com.tencent.mm.kernel.api.g()
      {
        public final void aDv()
        {
          AppMethodBeat.i(22280);
          h.baF().b(this);
          WXEntryActivity.EntryReceiver.a(WXEntryActivity.EntryReceiver.this, paramContext, paramIntent);
          AppMethodBeat.o(22280);
        }
        
        public final void dZ(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(22283);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22281);
        long l = System.currentTimeMillis();
        WXEntryActivity.EntryReceiver.a(WXEntryActivity.EntryReceiver.this, paramContext, paramIntent);
        Log.i("MicroMsg.WXEntryActivity", "cost:%s", new Object[] { System.currentTimeMillis() - l });
        AppMethodBeat.o(22281);
      }
    });
    AppMethodBeat.o(22283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver
 * JD-Core Version:    0.7.0.1
 */