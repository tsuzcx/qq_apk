package com.tencent.mm.plugin.hp.tinker;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.l.a;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.lib.f.a;

final class TinkerPatchResultService$2
  implements l.a
{
  TinkerPatchResultService$2(TinkerPatchResultService paramTinkerPatchResultService) {}
  
  public final void bX(boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      a.i("Tinker.TinkerPatchResultService", "app is background now, i can kill quietly", new Object[0]);
      y.cqM();
      localObject = g.Dk();
      if (((p)localObject).edC != null) {
        break label111;
      }
      paramBoolean = true;
      if (!paramBoolean) {
        break label122;
      }
      y.i("Tinker.TinkerPatchResultService", "we are in foreground, trigger reboot now.");
      localObject = this.lnr.getPackageManager().getLaunchIntentForPackage(this.lnr.getPackageName());
      localObject = PendingIntent.getActivity(this.lnr.getApplicationContext(), 1, (Intent)localObject, 1073741824);
      ((AlarmManager)this.lnr.getSystemService("alarm")).set(1, System.currentTimeMillis() + 1000L, (PendingIntent)localObject);
    }
    for (;;)
    {
      e.rVK.aL(ae.getContext());
      return;
      label111:
      paramBoolean = ((p)localObject).edC.booleanValue();
      break;
      label122:
      y.w("Tinker.TinkerPatchResultService", "we are in background, do not explicitly trigger reboot.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService.2
 * JD-Core Version:    0.7.0.1
 */