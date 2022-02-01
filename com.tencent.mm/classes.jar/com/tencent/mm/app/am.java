package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m;
import com.tencent.mm.be.s;
import com.tencent.mm.f.a.yy;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelmulti.f;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ac.a;

final class am
  implements com.tencent.mm.an.l, m, com.tencent.mm.pluginsdk.k, com.tencent.mm.pluginsdk.l
{
  public final String O(String paramString, int paramInt)
  {
    AppMethodBeat.i(19505);
    if (com.tencent.mm.pluginsdk.model.app.h.hn(paramString, paramInt) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.hn(paramString, paramInt).field_packageName;
      AppMethodBeat.o(19505);
      return paramString;
    }
    AppMethodBeat.o(19505);
    return "";
  }
  
  public final String V(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19511);
    paramString1 = com.tencent.mm.pluginsdk.model.app.q.V(paramString1, paramString2);
    AppMethodBeat.o(19511);
    return paramString1;
  }
  
  public final com.tencent.mm.an.q a(j paramj)
  {
    AppMethodBeat.i(19525);
    if (com.tencent.mm.modelmulti.l.bni())
    {
      paramj = new f(paramj);
      AppMethodBeat.o(19525);
      return paramj;
    }
    p.bnn().wE(4);
    AppMethodBeat.o(19525);
    return null;
  }
  
  public final void a(Context paramContext, as paramas, ca.a parama, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(19533);
    com.tencent.mm.ui.contact.e.a(paramContext, paramas, parama, true, true, paramBundle, paramString);
    AppMethodBeat.o(19533);
  }
  
  public final void a(Context paramContext, ca.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(19532);
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
    AppMethodBeat.o(19532);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(19512);
    com.tencent.mm.plugin.game.api.b localb = b.a.evu();
    if (localb != null) {
      localb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, "");
    }
    AppMethodBeat.o(19512);
  }
  
  public final void a(Intent paramIntent, ebp paramebp, int paramInt)
  {
    AppMethodBeat.i(19530);
    d.a(paramIntent, paramebp, paramInt);
    AppMethodBeat.o(19530);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(19534);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    AppMethodBeat.o(19534);
  }
  
  public final void a(com.tencent.mm.api.c paramc, Activity paramActivity, as paramas)
  {
    AppMethodBeat.i(19528);
    com.tencent.mm.ui.tools.c.c(paramc, paramActivity, paramas);
    AppMethodBeat.o(19528);
  }
  
  public final void a(com.tencent.mm.api.c paramc, Activity paramActivity, as paramas, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(19527);
    com.tencent.mm.ui.tools.c.a(paramc, paramActivity, paramas, paramBoolean, paramRunnable, 0);
    AppMethodBeat.o(19527);
  }
  
  public final void a(cyb paramcyb, String paramString, int paramInt)
  {
    AppMethodBeat.i(291277);
    ((com.tencent.mm.plugin.messenger.foundation.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.g.class)).processModContact(paramcyb, paramString, null, true, false, paramInt);
    AppMethodBeat.o(291277);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    AppMethodBeat.i(19513);
    com.tencent.mm.plugin.game.api.b localb = b.a.evu();
    if (localb != null) {
      localb.a(paramString1, paramString2, paramInt, 4, paramString3, paramLong, "", 0);
    }
    AppMethodBeat.o(19513);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19517);
    boolean bool = ac.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
    AppMethodBeat.o(19517);
    return bool;
  }
  
  public final boolean a(as paramas)
  {
    AppMethodBeat.i(19526);
    boolean bool = com.tencent.mm.modelmulti.a.a(paramas);
    AppMethodBeat.o(19526);
    return bool;
  }
  
  public final void abC()
  {
    AppMethodBeat.i(19502);
    p.bnn().wE(7);
    AppMethodBeat.o(19502);
  }
  
  public final com.tencent.mm.an.k abD()
  {
    AppMethodBeat.i(19504);
    com.tencent.mm.audio.a.a locala = new com.tencent.mm.audio.a.a(MMApplicationContext.getContext());
    AppMethodBeat.o(19504);
    return locala;
  }
  
  public final void abE()
  {
    AppMethodBeat.i(19514);
    yy localyy = new yy();
    localyy.fYl.fYn = true;
    EventCenter.instance.publish(localyy);
    AppMethodBeat.o(19514);
  }
  
  public final void abF()
  {
    AppMethodBeat.i(19519);
    MMAppMgr.abF();
    AppMethodBeat.o(19519);
  }
  
  public final Intent abG()
  {
    AppMethodBeat.i(19524);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    AppMethodBeat.o(19524);
    return localIntent;
  }
  
  public final void abH()
  {
    AppMethodBeat.i(19531);
    com.tencent.mm.booter.o.abH();
    AppMethodBeat.o(19531);
  }
  
  public final boolean abI()
  {
    AppMethodBeat.i(19537);
    boolean bool = com.tencent.mm.modelmulti.l.bni();
    AppMethodBeat.o(19537);
    return bool;
  }
  
  public final Bitmap b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(19523);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(19523);
      return null;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19523);
      return null;
      paramIntent = u.g(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aST());
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      Intent localIntent = new Intent(paramActivity, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aST() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", paramIntent);
      localIntent.putExtra("CropImage_from_scene", 3);
      paramActivity.startActivityForResult(localIntent, 4);
      AppMethodBeat.o(19523);
      return null;
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      localIntent = new Intent(paramActivity, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aST() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.b.a(paramActivity, paramIntent, localIntent, com.tencent.mm.loader.j.b.aST(), 4);
      AppMethodBeat.o(19523);
      return null;
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      paramActivity = paramIntent.getStringExtra("CropImage_OutputPath");
      if (paramActivity != null) {
        break;
      }
      Log.e("MicroMsg.WorkerModelCallback", "crop picture failed");
    }
    Log.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[] { paramActivity });
    paramActivity = BitmapUtil.getBitmapNative(paramActivity);
    AppMethodBeat.o(19523);
    return paramActivity;
  }
  
  public final boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19518);
    boolean bool = ac.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    AppMethodBeat.o(19518);
    return bool;
  }
  
  public final void bS(Context paramContext)
  {
    AppMethodBeat.i(19521);
    MMAppMgr.kQ(paramContext);
    AppMethodBeat.o(19521);
  }
  
  public final com.tencent.mm.an.q jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(19515);
    if (paramBoolean) {
      com.tencent.mm.be.w.bnU().wI(4);
    }
    com.tencent.mm.be.o localo = new com.tencent.mm.be.o(4);
    bh.aGY().a(localo, 0);
    AppMethodBeat.o(19515);
    return localo;
  }
  
  public final String e(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19510);
    paramContext = com.tencent.mm.pluginsdk.model.app.q.e(paramContext, paramString1, paramString2);
    AppMethodBeat.o(19510);
    return paramContext;
  }
  
  public final String gY(String paramString)
  {
    AppMethodBeat.i(19506);
    if (com.tencent.mm.pluginsdk.model.app.h.o(paramString, false, false) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, false, false).field_packageName;
      AppMethodBeat.o(19506);
      return paramString;
    }
    AppMethodBeat.o(19506);
    return "";
  }
  
  public final boolean gZ(String paramString)
  {
    AppMethodBeat.i(19508);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.gZ(paramString);
    AppMethodBeat.o(19508);
    return bool;
  }
  
  public final boolean ha(String paramString)
  {
    AppMethodBeat.i(19516);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.ha(paramString);
    AppMethodBeat.o(19516);
    return bool;
  }
  
  public final void hb(String paramString)
  {
    AppMethodBeat.i(19535);
    com.tencent.mm.av.b.blw();
    com.tencent.mm.av.b.VJ(paramString);
    AppMethodBeat.o(19535);
  }
  
  public final void kd(int paramInt)
  {
    AppMethodBeat.i(19503);
    Log.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    p.bnn().wE(paramInt);
    AppMethodBeat.o(19503);
  }
  
  public final boolean r(Activity paramActivity)
  {
    AppMethodBeat.i(19520);
    if (!com.tencent.mm.compatible.util.e.avA())
    {
      com.tencent.mm.ui.base.w.g(paramActivity, null);
      AppMethodBeat.o(19520);
      return false;
    }
    u.p(paramActivity, 2);
    AppMethodBeat.o(19520);
    return true;
  }
  
  public final void s(Activity paramActivity)
  {
    AppMethodBeat.i(19522);
    MMAppMgr.bn(paramActivity);
    AppMethodBeat.o(19522);
  }
  
  public final String t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19507);
    paramContext = com.tencent.mm.pluginsdk.model.app.h.t(paramContext, paramString);
    AppMethodBeat.o(19507);
    return paramContext;
  }
  
  public final boolean u(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19509);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.u(paramContext, paramString);
    AppMethodBeat.o(19509);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.am
 * JD-Core Version:    0.7.0.1
 */