package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.j;
import com.tencent.mm.am.s;
import com.tencent.mm.api.d;
import com.tencent.mm.api.n;
import com.tencent.mm.autogen.a.aar;
import com.tencent.mm.booter.o;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.aa;

final class aq
  implements com.tencent.mm.am.k, n, com.tencent.mm.pluginsdk.k, l
{
  public final String X(String paramString, int paramInt)
  {
    AppMethodBeat.i(19505);
    if (com.tencent.mm.pluginsdk.model.app.h.is(paramString, paramInt) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.is(paramString, paramInt).field_packageName;
      AppMethodBeat.o(19505);
      return paramString;
    }
    AppMethodBeat.o(19505);
    return "";
  }
  
  public final com.tencent.mm.am.p a(i parami)
  {
    AppMethodBeat.i(19525);
    if (q.bKT())
    {
      parami = new com.tencent.mm.modelmulti.k(parami);
      AppMethodBeat.o(19525);
      return parami;
    }
    com.tencent.mm.modelmulti.u.bKY().wG(4);
    AppMethodBeat.o(19525);
    return null;
  }
  
  public final void a(Context paramContext, au paramau, cc.a parama, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(19533);
    com.tencent.mm.ui.contact.e.a(paramContext, paramau, parama, true, true, paramBundle, paramString);
    AppMethodBeat.o(19533);
  }
  
  public final void a(Context paramContext, cc.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(19532);
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
    AppMethodBeat.o(19532);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(19512);
    com.tencent.mm.plugin.game.api.b localb = b.a.fCn();
    if (localb != null) {
      localb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, "");
    }
    AppMethodBeat.o(19512);
  }
  
  public final void a(Intent paramIntent, evg paramevg, int paramInt)
  {
    AppMethodBeat.i(19530);
    d.a(paramIntent, paramevg, paramInt);
    AppMethodBeat.o(19530);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(19534);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    AppMethodBeat.o(19534);
  }
  
  public final void a(com.tencent.mm.api.c paramc, Activity paramActivity, au paramau)
  {
    AppMethodBeat.i(19528);
    com.tencent.mm.ui.tools.c.c(paramc, paramActivity, paramau);
    AppMethodBeat.o(19528);
  }
  
  public final void a(com.tencent.mm.api.c paramc, Activity paramActivity, au paramau, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(19527);
    com.tencent.mm.ui.tools.c.a(paramc, paramActivity, paramau, paramBoolean, paramRunnable, 0);
    AppMethodBeat.o(19527);
  }
  
  public final void a(dph paramdph, String paramString, int paramInt)
  {
    AppMethodBeat.i(239269);
    ((com.tencent.mm.plugin.messenger.foundation.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.g.class)).processModContact(paramdph, paramString, null, true, false, paramInt);
    AppMethodBeat.o(239269);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    AppMethodBeat.i(19513);
    com.tencent.mm.plugin.game.api.b localb = b.a.fCn();
    if (localb != null) {
      localb.a(paramString1, paramString2, paramInt, 4, paramString3, paramLong, "", 0);
    }
    AppMethodBeat.o(19513);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19517);
    boolean bool = ae.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
    AppMethodBeat.o(19517);
    return bool;
  }
  
  public final boolean a(au paramau)
  {
    AppMethodBeat.i(19526);
    boolean bool = com.tencent.mm.modelmulti.a.a(paramau);
    AppMethodBeat.o(19526);
    return bool;
  }
  
  public final void aDA()
  {
    AppMethodBeat.i(19519);
    MMAppMgr.aDA();
    AppMethodBeat.o(19519);
  }
  
  public final Intent aDB()
  {
    AppMethodBeat.i(19524);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    AppMethodBeat.o(19524);
    return localIntent;
  }
  
  public final boolean aDC()
  {
    AppMethodBeat.i(19529);
    AppMethodBeat.o(19529);
    return false;
  }
  
  public final void aDD()
  {
    AppMethodBeat.i(19531);
    o.aDD();
    AppMethodBeat.o(19531);
  }
  
  public final boolean aDE()
  {
    AppMethodBeat.i(19537);
    boolean bool = q.bKT();
    AppMethodBeat.o(19537);
    return bool;
  }
  
  public final void aDx()
  {
    AppMethodBeat.i(19502);
    com.tencent.mm.modelmulti.u.bKY().wG(7);
    AppMethodBeat.o(19502);
  }
  
  public final j aDy()
  {
    AppMethodBeat.i(19504);
    com.tencent.mm.audio.a.a locala = new com.tencent.mm.audio.a.a(MMApplicationContext.getContext());
    AppMethodBeat.o(19504);
    return locala;
  }
  
  public final void aDz()
  {
    AppMethodBeat.i(19514);
    aar localaar = new aar();
    localaar.iel.ien = true;
    localaar.publish();
    AppMethodBeat.o(19514);
  }
  
  public final String ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19511);
    paramString1 = com.tencent.mm.pluginsdk.model.app.u.ab(paramString1, paramString2);
    AppMethodBeat.o(19511);
    return paramString1;
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.t.g(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.loader.i.b.bmH());
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      Intent localIntent = new Intent(paramActivity, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", paramIntent);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(4, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/app/WorkerModelCallbackImpl", "setAvatarResult", "(Landroid/app/Activity;IILandroid/content/Intent;)Landroid/graphics/Bitmap;", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
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
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.b.a(paramActivity, paramIntent, localIntent, com.tencent.mm.loader.i.b.bmH(), 4);
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
    boolean bool = ae.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    AppMethodBeat.o(19518);
    return bool;
  }
  
  public final void cE(Context paramContext)
  {
    AppMethodBeat.i(19521);
    MMAppMgr.mS(paramContext);
    AppMethodBeat.o(19521);
  }
  
  public final com.tencent.mm.am.p ea(boolean paramBoolean)
  {
    AppMethodBeat.i(19515);
    if (paramBoolean) {
      com.tencent.mm.modelpackage.u.bLH().wJ(4);
    }
    com.tencent.mm.modelpackage.p localp = new com.tencent.mm.modelpackage.p(4);
    bh.aZW().a(localp, 0);
    AppMethodBeat.o(19515);
    return localp;
  }
  
  public final String i(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19510);
    paramContext = com.tencent.mm.pluginsdk.model.app.u.i(paramContext, paramString1, paramString2);
    AppMethodBeat.o(19510);
    return paramContext;
  }
  
  public final boolean iA(String paramString)
  {
    AppMethodBeat.i(19508);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.iA(paramString);
    AppMethodBeat.o(19508);
    return bool;
  }
  
  public final boolean iB(String paramString)
  {
    AppMethodBeat.i(19516);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.iB(paramString);
    AppMethodBeat.o(19516);
    return bool;
  }
  
  public final void iC(String paramString)
  {
    AppMethodBeat.i(19535);
    com.tencent.mm.modelgetchatroommsg.b.bJr();
    com.tencent.mm.modelgetchatroommsg.b.NJ(paramString);
    AppMethodBeat.o(19535);
  }
  
  public final String iz(String paramString)
  {
    AppMethodBeat.i(19506);
    if (com.tencent.mm.pluginsdk.model.app.h.s(paramString, false, false) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, false, false).field_packageName;
      AppMethodBeat.o(19506);
      return paramString;
    }
    AppMethodBeat.o(19506);
    return "";
  }
  
  public final void nK(int paramInt)
  {
    AppMethodBeat.i(19503);
    Log.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.modelmulti.u.bKY().wG(paramInt);
    AppMethodBeat.o(19503);
  }
  
  public final boolean t(Activity paramActivity)
  {
    AppMethodBeat.i(19520);
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      aa.j(paramActivity, null);
      AppMethodBeat.o(19520);
      return false;
    }
    com.tencent.mm.pluginsdk.ui.tools.t.r(paramActivity, 2);
    AppMethodBeat.o(19520);
    return true;
  }
  
  public final void u(Activity paramActivity)
  {
    AppMethodBeat.i(19522);
    MMAppMgr.a(paramActivity, null);
    AppMethodBeat.o(19522);
  }
  
  public final String x(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19507);
    paramContext = com.tencent.mm.pluginsdk.model.app.h.x(paramContext, paramString);
    AppMethodBeat.o(19507);
    return paramContext;
  }
  
  public final boolean y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19509);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.y(paramContext, paramString);
    AppMethodBeat.o(19509);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.aq
 * JD-Core Version:    0.7.0.1
 */