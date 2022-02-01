package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i;
import com.tencent.mm.al.n;
import com.tencent.mm.api.c;
import com.tencent.mm.api.d;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelmulti.f;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.span.r;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.y.a;

final class aj
  implements i, com.tencent.mm.api.l, k, com.tencent.mm.pluginsdk.l
{
  public final void MR()
  {
    AppMethodBeat.i(19502);
    com.tencent.mm.modelmulti.p.aJx().pM(7);
    AppMethodBeat.o(19502);
  }
  
  public final com.tencent.mm.al.h MS()
  {
    AppMethodBeat.i(19504);
    com.tencent.mm.audio.a.a locala = new com.tencent.mm.audio.a.a(com.tencent.mm.sdk.platformtools.aj.getContext());
    AppMethodBeat.o(19504);
    return locala;
  }
  
  public final void MT()
  {
    AppMethodBeat.i(19514);
    wn localwn = new wn();
    localwn.dKS.dKU = true;
    com.tencent.mm.sdk.b.a.IbL.l(localwn);
    AppMethodBeat.o(19514);
  }
  
  public final void MU()
  {
    AppMethodBeat.i(19519);
    MMAppMgr.MU();
    AppMethodBeat.o(19519);
  }
  
  public final Intent MV()
  {
    AppMethodBeat.i(19524);
    Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.aj.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    AppMethodBeat.o(19524);
    return localIntent;
  }
  
  public final boolean MW()
  {
    AppMethodBeat.i(19529);
    boolean bool = r.MW();
    AppMethodBeat.o(19529);
    return bool;
  }
  
  public final void MX()
  {
    AppMethodBeat.i(19531);
    o.MX();
    AppMethodBeat.o(19531);
  }
  
  public final boolean MY()
  {
    AppMethodBeat.i(19537);
    boolean bool = com.tencent.mm.modelmulti.l.aJs();
    AppMethodBeat.o(19537);
    return bool;
  }
  
  public final String Q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19511);
    paramString1 = com.tencent.mm.pluginsdk.model.app.q.Q(paramString1, paramString2);
    AppMethodBeat.o(19511);
    return paramString1;
  }
  
  public final Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.asc());
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      Intent localIntent = new Intent(paramActivity, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.asc() + "temp.avatar");
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
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.asc() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.a.a(paramActivity, paramIntent, localIntent, com.tencent.mm.loader.j.b.asc(), 4);
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
      ad.e("MicroMsg.WorkerModelCallback", "crop picture failed");
    }
    ad.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[] { paramActivity });
    paramActivity = com.tencent.mm.sdk.platformtools.g.aQf(paramActivity);
    AppMethodBeat.o(19523);
    return paramActivity;
  }
  
  public final n a(com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(19525);
    if (com.tencent.mm.modelmulti.l.aJs())
    {
      paramg = new f(paramg);
      AppMethodBeat.o(19525);
      return paramg;
    }
    com.tencent.mm.modelmulti.p.aJx().pM(4);
    AppMethodBeat.o(19525);
    return null;
  }
  
  public final void a(Context paramContext, am paramam, bu.a parama, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(19533);
    com.tencent.mm.ui.contact.e.a(paramContext, paramam, parama, true, true, paramBundle, paramString);
    AppMethodBeat.o(19533);
  }
  
  public final void a(Context paramContext, bu.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(19532);
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
    AppMethodBeat.o(19532);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(19512);
    com.tencent.mm.plugin.game.api.b localb = b.a.cWM();
    if (localb != null) {
      localb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, "");
    }
    AppMethodBeat.o(19512);
  }
  
  public final void a(Intent paramIntent, cyc paramcyc, int paramInt)
  {
    AppMethodBeat.i(19530);
    d.a(paramIntent, paramcyc, paramInt);
    AppMethodBeat.o(19530);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(19534);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    AppMethodBeat.o(19534);
  }
  
  public final void a(c paramc, Activity paramActivity, am paramam)
  {
    AppMethodBeat.i(19528);
    com.tencent.mm.ui.tools.b.c(paramc, paramActivity, paramam);
    AppMethodBeat.o(19528);
  }
  
  public final void a(c paramc, Activity paramActivity, am paramam, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(19527);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paramam, paramBoolean, paramRunnable, 0);
    AppMethodBeat.o(19527);
  }
  
  public final void a(bzp parambzp, String paramString, int paramInt)
  {
    AppMethodBeat.i(193081);
    ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.e.class)).processModContact(parambzp, paramString, null, true, false, paramInt);
    AppMethodBeat.o(193081);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    AppMethodBeat.i(19513);
    com.tencent.mm.plugin.game.api.b localb = b.a.cWM();
    if (localb != null) {
      localb.a(paramString1, paramString2, paramInt, 4, paramString3, paramLong, "", 0);
    }
    AppMethodBeat.o(19513);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19517);
    boolean bool = y.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
    AppMethodBeat.o(19517);
    return bool;
  }
  
  public final boolean a(am paramam)
  {
    AppMethodBeat.i(19526);
    boolean bool = com.tencent.mm.modelmulti.a.a(paramam);
    AppMethodBeat.o(19526);
    return bool;
  }
  
  public final boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19518);
    boolean bool = y.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    AppMethodBeat.o(19518);
    return bool;
  }
  
  public final void bx(Context paramContext)
  {
    AppMethodBeat.i(19521);
    MMAppMgr.jM(paramContext);
    AppMethodBeat.o(19521);
  }
  
  public final n ci(boolean paramBoolean)
  {
    AppMethodBeat.i(19515);
    if (paramBoolean) {
      com.tencent.mm.bc.t.aJZ().pQ(4);
    }
    com.tencent.mm.bc.l locall = new com.tencent.mm.bc.l(4);
    ba.aiU().a(locall, 0);
    AppMethodBeat.o(19515);
    return locall;
  }
  
  public final String e(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19510);
    paramContext = com.tencent.mm.pluginsdk.model.app.q.e(paramContext, paramString1, paramString2);
    AppMethodBeat.o(19510);
    return paramContext;
  }
  
  public final String fw(String paramString)
  {
    AppMethodBeat.i(19506);
    if (com.tencent.mm.pluginsdk.model.app.h.m(paramString, false, false) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.m(paramString, false, false).field_packageName;
      AppMethodBeat.o(19506);
      return paramString;
    }
    AppMethodBeat.o(19506);
    return "";
  }
  
  public final boolean fx(String paramString)
  {
    AppMethodBeat.i(19508);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.fx(paramString);
    AppMethodBeat.o(19508);
    return bool;
  }
  
  public final boolean fy(String paramString)
  {
    AppMethodBeat.i(19516);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.fy(paramString);
    AppMethodBeat.o(19516);
    return bool;
  }
  
  public final void fz(String paramString)
  {
    AppMethodBeat.i(19535);
    com.tencent.mm.at.b.aHW();
    com.tencent.mm.at.b.EZ(paramString);
    AppMethodBeat.o(19535);
  }
  
  public final void hu(int paramInt)
  {
    AppMethodBeat.i(19503);
    ad.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.modelmulti.p.aJx().pM(paramInt);
    AppMethodBeat.o(19503);
  }
  
  public final String r(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19507);
    paramContext = com.tencent.mm.pluginsdk.model.app.h.r(paramContext, paramString);
    AppMethodBeat.o(19507);
    return paramContext;
  }
  
  public final boolean s(Activity paramActivity)
  {
    AppMethodBeat.i(19520);
    if (!com.tencent.mm.compatible.util.e.abf())
    {
      com.tencent.mm.ui.base.t.g(paramActivity, null);
      AppMethodBeat.o(19520);
      return false;
    }
    com.tencent.mm.pluginsdk.ui.tools.q.o(paramActivity, 2);
    AppMethodBeat.o(19520);
    return true;
  }
  
  public final boolean s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19509);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, paramString);
    AppMethodBeat.o(19509);
    return bool;
  }
  
  public final void t(Activity paramActivity)
  {
    AppMethodBeat.i(19522);
    MMAppMgr.a(paramActivity, null);
    AppMethodBeat.o(19522);
  }
  
  public final String u(String paramString, int paramInt)
  {
    AppMethodBeat.i(19505);
    if (com.tencent.mm.pluginsdk.model.app.h.fX(paramString, paramInt) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.fX(paramString, paramInt).field_packageName;
      AppMethodBeat.o(19505);
      return paramString;
    }
    AppMethodBeat.o(19505);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.aj
 * JD-Core Version:    0.7.0.1
 */