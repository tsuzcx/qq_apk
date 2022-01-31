package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.m;
import com.tencent.mm.az.r;
import com.tencent.mm.h.a.rv;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.pluginsdk.ui.d.q;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.ui.w.a;

final class u
  implements com.tencent.mm.ah.i, com.tencent.mm.pluginsdk.g, com.tencent.mm.pluginsdk.i, com.tencent.mm.pluginsdk.l
{
  public final Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      do
      {
        do
        {
          return null;
          switch (paramInt1)
          {
          default: 
            return null;
          }
        } while (paramIntent == null);
        localIntent = new Intent();
        localIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
        localIntent.putExtra("CropImageMode", 1);
        localIntent.putExtra("CropImage_Filter", true);
        localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.dzK + "temp.avatar");
        localIntent.putExtra("CropImage_ImgPath", null);
        com.tencent.mm.ui.tools.a.a(paramActivity, paramIntent, localIntent, com.tencent.mm.compatible.util.e.dzK, 4);
        return null;
        paramIntent = com.tencent.mm.pluginsdk.ui.tools.l.f(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.dzK);
      } while (paramIntent == null);
      Intent localIntent = new Intent();
      localIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.dzK + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", paramIntent);
      paramActivity.startActivityForResult(localIntent, 4);
      return null;
    } while (paramIntent == null);
    paramActivity = paramIntent.getStringExtra("CropImage_OutputPath");
    if (paramActivity == null)
    {
      y.e("MicroMsg.WorkerModelCallback", "crop picture failed");
      return null;
    }
    y.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[] { paramActivity });
    return com.tencent.mm.sdk.platformtools.c.YW(paramActivity);
  }
  
  public final m a(com.tencent.mm.ah.g paramg)
  {
    if (com.tencent.mm.modelmulti.k.Pj()) {
      return new com.tencent.mm.modelmulti.e(paramg);
    }
    com.tencent.mm.modelmulti.n.Pm().iT(4);
    return null;
  }
  
  public final void a(Context paramContext, ad paramad, bi.a parama, Bundle paramBundle, String paramString)
  {
    com.tencent.mm.ui.contact.e.a(paramContext, paramad, parama, true, true, paramBundle, paramString);
  }
  
  public final void a(Context paramContext, bi.a parama, Bundle paramBundle)
  {
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    com.tencent.mm.plugin.game.a.a locala = a.a.aYi();
    if (locala != null) {
      locala.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5);
    }
  }
  
  public final void a(Intent paramIntent, bnm parambnm, int paramInt)
  {
    com.tencent.mm.pluginsdk.ui.tools.c.a(paramIntent, parambnm, paramInt);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
  }
  
  public final void a(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad)
  {
    b.c(paramd, paramActivity, paramad);
  }
  
  public final void a(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, Runnable paramRunnable)
  {
    b.a(paramd, paramActivity, paramad, paramBoolean, paramRunnable, 0);
  }
  
  public final void a(axd paramaxd, String paramString)
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(paramaxd, paramString);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    com.tencent.mm.plugin.game.a.a locala = a.a.aYi();
    if (locala != null) {
      locala.a(paramString1, paramString2, 2, 4, paramString3, paramLong);
    }
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return w.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
  }
  
  public final boolean a(ad paramad)
  {
    return com.tencent.mm.modelmulti.a.a(paramad);
  }
  
  public final void aJ(Context paramContext)
  {
    MMAppMgr.gr(paramContext);
  }
  
  public final m aQ(boolean paramBoolean)
  {
    if (paramBoolean) {
      r.PK().iZ(4);
    }
    com.tencent.mm.az.k localk = new com.tencent.mm.az.k(4);
    au.Dk().a(localk, 0);
    return localk;
  }
  
  public final boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return w.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
  }
  
  public final String cs(String paramString)
  {
    if (com.tencent.mm.pluginsdk.model.app.g.by(paramString, false) != null) {
      return com.tencent.mm.pluginsdk.model.app.g.by(paramString, false).field_packageName;
    }
    return "";
  }
  
  public final boolean ct(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.g.ct(paramString);
  }
  
  public final boolean cu(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.g.cu(paramString);
  }
  
  public final void es(int paramInt)
  {
    y.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.modelmulti.n.Pm().iT(paramInt);
  }
  
  public final String f(Context paramContext, String paramString1, String paramString2)
  {
    return com.tencent.mm.pluginsdk.model.app.p.f(paramContext, paramString1, paramString2);
  }
  
  public final boolean m(Activity paramActivity)
  {
    if (!com.tencent.mm.compatible.util.f.zF())
    {
      s.gM(paramActivity);
      return false;
    }
    com.tencent.mm.pluginsdk.ui.tools.l.k(paramActivity, 2);
    return true;
  }
  
  public final String n(Context paramContext, String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.g.n(paramContext, paramString);
  }
  
  public final void n(Activity paramActivity)
  {
    MMAppMgr.a(paramActivity, null);
  }
  
  public final boolean o(Context paramContext, String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.g.o(paramContext, paramString);
  }
  
  public final String q(String paramString, int paramInt)
  {
    if (com.tencent.mm.pluginsdk.model.app.g.dh(paramString, paramInt) != null) {
      return com.tencent.mm.pluginsdk.model.app.g.dh(paramString, paramInt).field_packageName;
    }
    return "";
  }
  
  public final void tk()
  {
    com.tencent.mm.modelmulti.n.Pm().iT(7);
  }
  
  public final h tl()
  {
    return new com.tencent.mm.f.a.a(ae.getContext());
  }
  
  public final void tm()
  {
    rv localrv = new rv();
    localrv.cbv.cbx = true;
    com.tencent.mm.sdk.b.a.udP.m(localrv);
  }
  
  public final void tn() {}
  
  public final Intent to()
  {
    Intent localIntent = new Intent(ae.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    return localIntent;
  }
  
  public final boolean tp()
  {
    return q.tp();
  }
  
  public final void tq() {}
  
  public final boolean tr()
  {
    return com.tencent.mm.modelmulti.k.Pj();
  }
  
  public final String u(String paramString1, String paramString2)
  {
    return com.tencent.mm.pluginsdk.model.app.p.u(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.u
 * JD-Core Version:    0.7.0.1
 */