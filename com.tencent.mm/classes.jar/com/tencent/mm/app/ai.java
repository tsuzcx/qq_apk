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
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.span.r;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.x.a;

final class ai
  implements com.tencent.mm.al.j, com.tencent.mm.api.l, com.tencent.mm.pluginsdk.j, k
{
  public final void Ll()
  {
    AppMethodBeat.i(19502);
    com.tencent.mm.modelmulti.o.azv().ov(7);
    AppMethodBeat.o(19502);
  }
  
  public final i Lm()
  {
    AppMethodBeat.i(19504);
    com.tencent.mm.audio.a.a locala = new com.tencent.mm.audio.a.a(aj.getContext());
    AppMethodBeat.o(19504);
    return locala;
  }
  
  public final void Ln()
  {
    AppMethodBeat.i(19514);
    vk localvk = new vk();
    localvk.dAU.dAW = true;
    com.tencent.mm.sdk.b.a.ESL.l(localvk);
    AppMethodBeat.o(19514);
  }
  
  public final void Lo()
  {
    AppMethodBeat.i(19519);
    MMAppMgr.Lo();
    AppMethodBeat.o(19519);
  }
  
  public final Intent Lp()
  {
    AppMethodBeat.i(19524);
    Intent localIntent = new Intent(aj.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    AppMethodBeat.o(19524);
    return localIntent;
  }
  
  public final boolean Lq()
  {
    AppMethodBeat.i(19529);
    boolean bool = r.Lq();
    AppMethodBeat.o(19529);
    return bool;
  }
  
  public final void Lr()
  {
    AppMethodBeat.i(19531);
    com.tencent.mm.booter.o.Lr();
    AppMethodBeat.o(19531);
  }
  
  public final boolean Ls()
  {
    AppMethodBeat.i(19537);
    boolean bool = com.tencent.mm.modelmulti.l.azs();
    AppMethodBeat.o(19537);
    return bool;
  }
  
  public final String O(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19511);
    paramString1 = com.tencent.mm.pluginsdk.model.app.q.O(paramString1, paramString2);
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aio());
      if (paramIntent == null)
      {
        AppMethodBeat.o(19523);
        return null;
      }
      Intent localIntent = new Intent(paramActivity, ImageCropUI.class);
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aio() + "temp.avatar");
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
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.loader.j.b.aio() + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      localIntent.putExtra("CropImage_from_scene", 3);
      com.tencent.mm.ui.tools.a.a(paramActivity, paramIntent, localIntent, com.tencent.mm.loader.j.b.aio(), 4);
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
    paramActivity = com.tencent.mm.sdk.platformtools.f.aFi(paramActivity);
    AppMethodBeat.o(19523);
    return paramActivity;
  }
  
  public final n a(com.tencent.mm.al.h paramh)
  {
    AppMethodBeat.i(19525);
    if (com.tencent.mm.modelmulti.l.azs())
    {
      paramh = new com.tencent.mm.modelmulti.f(paramh);
      AppMethodBeat.o(19525);
      return paramh;
    }
    com.tencent.mm.modelmulti.o.azv().ov(4);
    AppMethodBeat.o(19525);
    return null;
  }
  
  public final void a(Context paramContext, af paramaf, bl.a parama, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(19533);
    com.tencent.mm.ui.contact.e.a(paramContext, paramaf, parama, true, true, paramBundle, paramString);
    AppMethodBeat.o(19533);
  }
  
  public final void a(Context paramContext, bl.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(19532);
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
    AppMethodBeat.o(19532);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(19512);
    com.tencent.mm.plugin.game.api.b localb = b.a.cBi();
    if (localb != null) {
      localb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, "");
    }
    AppMethodBeat.o(19512);
  }
  
  public final void a(Intent paramIntent, cnl paramcnl, int paramInt)
  {
    AppMethodBeat.i(19530);
    com.tencent.mm.api.d.a(paramIntent, paramcnl, paramInt);
    AppMethodBeat.o(19530);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(19534);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    AppMethodBeat.o(19534);
  }
  
  public final void a(c paramc, Activity paramActivity, af paramaf)
  {
    AppMethodBeat.i(19528);
    com.tencent.mm.ui.tools.b.c(paramc, paramActivity, paramaf);
    AppMethodBeat.o(19528);
  }
  
  public final void a(c paramc, Activity paramActivity, af paramaf, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(19527);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paramaf, paramBoolean, paramRunnable, 0);
    AppMethodBeat.o(19527);
  }
  
  public final void a(bqj parambqj, String paramString)
  {
    AppMethodBeat.i(19536);
    ((com.tencent.mm.plugin.messenger.foundation.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.d.class)).processModContact(parambqj, paramString, null, true, false);
    AppMethodBeat.o(19536);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    AppMethodBeat.i(19513);
    com.tencent.mm.plugin.game.api.b localb = b.a.cBi();
    if (localb != null) {
      localb.a(paramString1, paramString2, paramInt, 4, paramString3, paramLong, "", 0);
    }
    AppMethodBeat.o(19513);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19517);
    boolean bool = x.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
    AppMethodBeat.o(19517);
    return bool;
  }
  
  public final boolean a(af paramaf)
  {
    AppMethodBeat.i(19526);
    boolean bool = com.tencent.mm.modelmulti.a.a(paramaf);
    AppMethodBeat.o(19526);
    return bool;
  }
  
  public final boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19518);
    boolean bool = x.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    AppMethodBeat.o(19518);
    return bool;
  }
  
  public final void bv(Context paramContext)
  {
    AppMethodBeat.i(19521);
    MMAppMgr.jq(paramContext);
    AppMethodBeat.o(19521);
  }
  
  public final n cf(boolean paramBoolean)
  {
    AppMethodBeat.i(19515);
    if (paramBoolean) {
      com.tencent.mm.bc.t.azY().oz(4);
    }
    com.tencent.mm.bc.l locall = new com.tencent.mm.bc.l(4);
    az.aeS().a(locall, 0);
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
  
  public final String eL(String paramString)
  {
    AppMethodBeat.i(19506);
    if (com.tencent.mm.pluginsdk.model.app.h.j(paramString, false, false) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.j(paramString, false, false).field_packageName;
      AppMethodBeat.o(19506);
      return paramString;
    }
    AppMethodBeat.o(19506);
    return "";
  }
  
  public final boolean eM(String paramString)
  {
    AppMethodBeat.i(19508);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.eM(paramString);
    AppMethodBeat.o(19508);
    return bool;
  }
  
  public final boolean eN(String paramString)
  {
    AppMethodBeat.i(19516);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.eN(paramString);
    AppMethodBeat.o(19516);
    return bool;
  }
  
  public final void eO(String paramString)
  {
    AppMethodBeat.i(19535);
    com.tencent.mm.at.b.axZ();
    com.tencent.mm.at.b.xV(paramString);
    AppMethodBeat.o(19535);
  }
  
  public final void hD(int paramInt)
  {
    AppMethodBeat.i(19503);
    ad.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.modelmulti.o.azv().ov(paramInt);
    AppMethodBeat.o(19503);
  }
  
  public final String s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19507);
    paramContext = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, paramString);
    AppMethodBeat.o(19507);
    return paramContext;
  }
  
  public final String s(String paramString, int paramInt)
  {
    AppMethodBeat.i(19505);
    if (com.tencent.mm.pluginsdk.model.app.h.fv(paramString, paramInt) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.h.fv(paramString, paramInt).field_packageName;
      AppMethodBeat.o(19505);
      return paramString;
    }
    AppMethodBeat.o(19505);
    return "";
  }
  
  public final boolean s(Activity paramActivity)
  {
    AppMethodBeat.i(19520);
    if (!com.tencent.mm.compatible.util.e.XG())
    {
      com.tencent.mm.ui.base.t.g(paramActivity, null);
      AppMethodBeat.o(19520);
      return false;
    }
    com.tencent.mm.pluginsdk.ui.tools.q.o(paramActivity, 2);
    AppMethodBeat.o(19520);
    return true;
  }
  
  public final void t(Activity paramActivity)
  {
    AppMethodBeat.i(19522);
    MMAppMgr.a(paramActivity, null);
    AppMethodBeat.o(19522);
  }
  
  public final boolean t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19509);
    boolean bool = com.tencent.mm.pluginsdk.model.app.h.t(paramContext, paramString);
    AppMethodBeat.o(19509);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ai
 * JD-Core Version:    0.7.0.1
 */