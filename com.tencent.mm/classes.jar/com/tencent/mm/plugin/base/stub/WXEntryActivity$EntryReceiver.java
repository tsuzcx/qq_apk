package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.HandlerThread;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class WXEntryActivity$EntryReceiver
  extends BroadcastReceiver
{
  private static ak handler;
  private String Ca;
  private String appId;
  private String appName;
  private Context context;
  private int jLB;
  private long jMr;
  
  private void b(f paramf)
  {
    AppMethodBeat.i(153512);
    if (!p.a(this.context, paramf, this.Ca, false))
    {
      ab.e("MicroMsg.WXEntryActivity", "reg fail, check app fail");
      al.cab().alr(this.appId);
      AppMethodBeat.o(153512);
      return;
    }
    if ((paramf != null) && (paramf.vY()))
    {
      localObject1 = b.a.bEX();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.game.api.b)localObject1).j(this.context, this.appId, this.Ca);
      }
    }
    localObject1 = null;
    try
    {
      localObject2 = this.context.getPackageManager();
      ApplicationInfo localApplicationInfo = ((PackageManager)localObject2).getApplicationInfo(this.Ca, 0);
      if (localApplicationInfo == null)
      {
        ab.e("MicroMsg.WXEntryActivity", "package not installed");
        AppMethodBeat.o(153512);
        return;
      }
      this.appName = localApplicationInfo.loadLabel((PackageManager)localObject2).toString();
      localObject2 = localApplicationInfo.loadIcon((PackageManager)localObject2);
      if (!(localObject2 instanceof BitmapDrawable)) {
        break label628;
      }
      localObject2 = ((BitmapDrawable)localObject2).getBitmap();
      localObject1 = localObject2;
    }
    catch (IncompatibleClassChangeError paramf)
    {
      Object localObject2;
      ab.printErrStackTrace("MicroMsg.Crash", paramf, "May cause dvmFindCatchBlock crash!", new Object[0]);
      paramf = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramf);
      AppMethodBeat.o(153512);
      throw paramf;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WXEntryActivity", localThrowable, "package not installed", new Object[0]);
        continue;
        boolean bool = e.cN(i.en(localThrowable, 1));
        continue;
        int i;
        if ((paramf.field_appInfoFlag & 0x2000) != 0) {
          if (this.jMr != paramf.field_appSupportContentType)
          {
            i = 1;
            paramf.field_appSupportContentType = this.jMr;
          }
        }
        for (;;)
        {
          if ((paramf.field_status == 2) || (paramf.field_status == 3) || (paramf.field_status == 4) || (i != 0))
          {
            if (!paramf.vY()) {
              com.tencent.mm.pluginsdk.ui.tools.b.amD(this.appId);
            }
            paramf.field_status = 0;
            ab.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, updateRet = ".concat(String.valueOf(al.cac().a(paramf, new String[0]))));
          }
          if (ah.isNullOrNil(paramf.field_openId))
          {
            ab.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + this.appId);
            al.cae().xB(this.appId);
          }
          AppMethodBeat.o(153512);
          return;
          i = 0;
          break;
          i = 0;
        }
        localObject1 = null;
      }
    }
    if (paramf != null)
    {
      al.cac();
      localObject2 = this.appId;
      if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
        break label447;
      }
      ab.e("MicroMsg.AppInfoStorage", "hasIcon, appId is null");
      bool = false;
      if (bool) {}
    }
    else
    {
      al.cac().t(this.appId, (Bitmap)localObject1);
    }
    if (paramf == null)
    {
      paramf = new f();
      paramf.field_appId = this.appId;
      paramf.field_appName = "";
      paramf.field_packageName = this.Ca;
      paramf.field_status = 0;
      localObject1 = p.bu(this.context, this.Ca);
      if (localObject1 != null) {
        paramf.field_signature = ((String)localObject1);
      }
      paramf.field_modifyTime = System.currentTimeMillis();
      paramf.field_appSupportContentType = this.jMr;
      bool = al.cac().p(paramf);
      com.tencent.mm.pluginsdk.ui.tools.b.amD(this.appId);
      if ((bool) && (ah.isNullOrNil(paramf.field_openId)))
      {
        ab.d("MicroMsg.WXEntryActivity", "handleAppRegisteration, trigger getAppSetting, appId = " + this.appId);
        al.cae().xB(this.appId);
      }
      AppMethodBeat.o(153512);
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(18196);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(18196);
      return;
    }
    com.tencent.mm.bq.d.dpU();
    if (handler == null)
    {
      HandlerThread localHandlerThread = com.tencent.mm.sdk.g.d.aqu("WXEntryReceiver");
      localHandlerThread.start();
      handler = new ak(localHandlerThread.getLooper());
    }
    if (!g.RM().eIn.eIH)
    {
      g.RM().a(new WXEntryActivity.EntryReceiver.1(this, paramContext, paramIntent));
      AppMethodBeat.o(18196);
      return;
    }
    handler.post(new WXEntryActivity.EntryReceiver.2(this, paramContext, paramIntent));
    AppMethodBeat.o(18196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver
 * JD-Core Version:    0.7.0.1
 */