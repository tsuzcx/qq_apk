package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.c;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.f;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.z.a;

final class ak
  implements com.tencent.mm.ak.l, m, com.tencent.mm.pluginsdk.k, com.tencent.mm.pluginsdk.l
{
  public final String R(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19511);
    paramString1 = com.tencent.mm.pluginsdk.model.app.q.R(paramString1, paramString2);
    AppMethodBeat.o(19511);
    return paramString1;
  }
  
  public final void WZ()
  {
    AppMethodBeat.i(19502);
    p.bdS().tE(7);
    AppMethodBeat.o(19502);
  }
  
  public final com.tencent.mm.ak.k Xa()
  {
    AppMethodBeat.i(19504);
    com.tencent.mm.audio.a.a locala = new com.tencent.mm.audio.a.a(MMApplicationContext.getContext());
    AppMethodBeat.o(19504);
    return locala;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(19514);
    xr localxr = new xr();
    localxr.edW.edY = true;
    EventCenter.instance.publish(localxr);
    AppMethodBeat.o(19514);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(19519);
    MMAppMgr.Xc();
    AppMethodBeat.o(19519);
  }
  
  public final Intent Xd()
  {
    AppMethodBeat.i(19524);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    AppMethodBeat.o(19524);
    return localIntent;
  }
  
  public final void Xe()
  {
    AppMethodBeat.i(19531);
    o.Xe();
    AppMethodBeat.o(19531);
  }
  
  public final boolean Xf()
  {
    AppMethodBeat.i(19537);
    boolean bool = com.tencent.mm.modelmulti.l.bdN();
    AppMethodBeat.o(19537);
    return bool;
  }
  
  public final com.tencent.mm.ak.q a(j paramj)
  {
    AppMethodBeat.i(19525);
    if (com.tencent.mm.modelmulti.l.bdN())
    {
      paramj = new f(paramj);
      AppMethodBeat.o(19525);
      return paramj;
    }
    p.bdS().tE(4);
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
    com.tencent.mm.plugin.game.api.b localb = b.a.dSQ();
    if (localb != null) {
      localb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, "");
    }
    AppMethodBeat.o(19512);
  }
  
  public final void a(Intent paramIntent, drt paramdrt, int paramInt)
  {
    AppMethodBeat.i(19530);
    d.a(paramIntent, paramdrt, paramInt);
    AppMethodBeat.o(19530);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(19534);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    AppMethodBeat.o(19534);
  }
  
  public final void a(c paramc, Activity paramActivity, as paramas)
  {
    AppMethodBeat.i(19528);
    com.tencent.mm.ui.tools.b.c(paramc, paramActivity, paramas);
    AppMethodBeat.o(19528);
  }
  
  public final void a(c paramc, Activity paramActivity, as paramas, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(19527);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paramas, paramBoolean, paramRunnable, 0);
    AppMethodBeat.o(19527);
  }
  
  public final void a(cpl paramcpl, String paramString, int paramInt)
  {
    AppMethodBeat.i(231411);
    ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.e.class)).processModContact(paramcpl, paramString, null, true, false, paramInt);
    AppMethodBeat.o(231411);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    AppMethodBeat.i(19513);
    com.tencent.mm.plugin.game.api.b localb = b.a.dSQ();
    if (localb != null) {
      localb.a(paramString1, paramString2, paramInt, 4, paramString3, paramLong, "", 0);
    }
    AppMethodBeat.o(19513);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19517);
    boolean bool = z.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
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
      paramIntent = s.h(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aKR());
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      Intent localIntent = new Intent(paramActivity, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
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
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.a.a(paramActivity, paramIntent, localIntent, com.tencent.mm.loader.j.b.aKR(), 4);
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
    boolean bool = z.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    AppMethodBeat.o(19518);
    return bool;
  }
  
  public final void bU(Context paramContext)
  {
    AppMethodBeat.i(19521);
    MMAppMgr.jO(paramContext);
    AppMethodBeat.o(19521);
  }
  
  public final com.tencent.mm.ak.q cR(boolean paramBoolean)
  {
    AppMethodBeat.i(19515);
    if (paramBoolean) {
      v.bev().tI(4);
    }
    n localn = new n(4);
    bg.azz().a(localn, 0);
    AppMethodBeat.o(19515);
    return localn;
  }
  
  public final String e(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19510);
    paramContext = com.tencent.mm.pluginsdk.model.app.q.e(paramContext, paramString1, paramString2);
    AppMethodBeat.o(19510);
    return paramContext;
  }
  
  public final String go(String paramString)
  {
    AppMethodBeat.i(19506);
    if (h.o(paramString, false, false) != null)
    {
      paramString = h.o(paramString, false, false).field_packageName;
      AppMethodBeat.o(19506);
      return paramString;
    }
    AppMethodBeat.o(19506);
    return "";
  }
  
  public final boolean gp(String paramString)
  {
    AppMethodBeat.i(19508);
    boolean bool = h.gp(paramString);
    AppMethodBeat.o(19508);
    return bool;
  }
  
  public final boolean gq(String paramString)
  {
    AppMethodBeat.i(19516);
    boolean bool = h.gq(paramString);
    AppMethodBeat.o(19516);
    return bool;
  }
  
  public final void gr(String paramString)
  {
    AppMethodBeat.i(19535);
    com.tencent.mm.as.b.bch();
    com.tencent.mm.as.b.Om(paramString);
    AppMethodBeat.o(19535);
  }
  
  public final void iO(int paramInt)
  {
    AppMethodBeat.i(19503);
    Log.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    p.bdS().tE(paramInt);
    AppMethodBeat.o(19503);
  }
  
  public final String r(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19507);
    paramContext = h.r(paramContext, paramString);
    AppMethodBeat.o(19507);
    return paramContext;
  }
  
  public final boolean s(Activity paramActivity)
  {
    AppMethodBeat.i(19520);
    if (!com.tencent.mm.compatible.util.e.apn())
    {
      u.g(paramActivity, null);
      AppMethodBeat.o(19520);
      return false;
    }
    s.o(paramActivity, 2);
    AppMethodBeat.o(19520);
    return true;
  }
  
  public final boolean s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19509);
    boolean bool = h.s(paramContext, paramString);
    AppMethodBeat.o(19509);
    return bool;
  }
  
  public final void t(Activity paramActivity)
  {
    AppMethodBeat.i(19522);
    MMAppMgr.a(paramActivity, null);
    AppMethodBeat.o(19522);
  }
  
  public final String w(String paramString, int paramInt)
  {
    AppMethodBeat.i(19505);
    if (h.gE(paramString, paramInt) != null)
    {
      paramString = h.gE(paramString, paramInt).field_packageName;
      AppMethodBeat.o(19505);
      return paramString;
    }
    AppMethodBeat.o(19505);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ak
 * JD-Core Version:    0.7.0.1
 */