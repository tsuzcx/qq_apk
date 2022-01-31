package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.i;
import com.tencent.mm.ba.r;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.d.q;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.v.a;

final class aa
  implements i, com.tencent.mm.pluginsdk.h, j, com.tencent.mm.pluginsdk.m
{
  public final void BO()
  {
    AppMethodBeat.i(15424);
    com.tencent.mm.modelmulti.n.aio().lL(7);
    AppMethodBeat.o(15424);
  }
  
  public final com.tencent.mm.ai.h BP()
  {
    AppMethodBeat.i(15426);
    com.tencent.mm.audio.a.a locala = new com.tencent.mm.audio.a.a(ah.getContext());
    AppMethodBeat.o(15426);
    return locala;
  }
  
  public final void BQ()
  {
    AppMethodBeat.i(15436);
    tm localtm = new tm();
    localtm.cJY.cKa = true;
    com.tencent.mm.sdk.b.a.ymk.l(localtm);
    AppMethodBeat.o(15436);
  }
  
  public final void BR()
  {
    AppMethodBeat.i(15441);
    MMAppMgr.BR();
    AppMethodBeat.o(15441);
  }
  
  public final Intent BS()
  {
    AppMethodBeat.i(15446);
    Intent localIntent = new Intent(ah.getContext(), LauncherUI.class);
    localIntent.putExtra("nofification_type", "talkroom_notification");
    localIntent.addFlags(67108864);
    AppMethodBeat.o(15446);
    return localIntent;
  }
  
  public final boolean BT()
  {
    AppMethodBeat.i(15451);
    boolean bool = q.BT();
    AppMethodBeat.o(15451);
    return bool;
  }
  
  public final void BU()
  {
    AppMethodBeat.i(15453);
    com.tencent.mm.booter.o.BU();
    AppMethodBeat.o(15453);
  }
  
  public final boolean BV()
  {
    AppMethodBeat.i(15459);
    boolean bool = com.tencent.mm.modelmulti.k.ail();
    AppMethodBeat.o(15459);
    return bool;
  }
  
  public final String H(String paramString1, String paramString2)
  {
    AppMethodBeat.i(15433);
    paramString1 = com.tencent.mm.pluginsdk.model.app.p.H(paramString1, paramString2);
    AppMethodBeat.o(15433);
    return paramString1;
  }
  
  public final Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(15445);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(15445);
      return null;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(15445);
      return null;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h(paramActivity.getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.esy);
      if (paramIntent == null)
      {
        AppMethodBeat.o(15445);
        return null;
      }
      Intent localIntent = new Intent();
      localIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.esy + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", paramIntent);
      paramActivity.startActivityForResult(localIntent, 4);
      AppMethodBeat.o(15445);
      return null;
      if (paramIntent == null)
      {
        AppMethodBeat.o(15445);
        return null;
      }
      localIntent = new Intent();
      localIntent.setClassName(paramActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
      localIntent.putExtra("CropImageMode", 1);
      localIntent.putExtra("CropImage_Filter", true);
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.esy + "temp.avatar");
      localIntent.putExtra("CropImage_ImgPath", null);
      com.tencent.mm.ui.tools.a.a(paramActivity, paramIntent, localIntent, com.tencent.mm.compatible.util.e.esy, 4);
      AppMethodBeat.o(15445);
      return null;
      if (paramIntent == null)
      {
        AppMethodBeat.o(15445);
        return null;
      }
      paramActivity = paramIntent.getStringExtra("CropImage_OutputPath");
      if (paramActivity != null) {
        break;
      }
      ab.e("MicroMsg.WorkerModelCallback", "crop picture failed");
    }
    ab.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", new Object[] { paramActivity });
    paramActivity = com.tencent.mm.sdk.platformtools.d.aoV(paramActivity);
    AppMethodBeat.o(15445);
    return paramActivity;
  }
  
  public final com.tencent.mm.ai.m a(com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(15447);
    if (com.tencent.mm.modelmulti.k.ail())
    {
      paramg = new com.tencent.mm.modelmulti.e(paramg);
      AppMethodBeat.o(15447);
      return paramg;
    }
    com.tencent.mm.modelmulti.n.aio().lL(4);
    AppMethodBeat.o(15447);
    return null;
  }
  
  public final void a(Context paramContext, ad paramad, bi.a parama, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(15455);
    com.tencent.mm.ui.contact.e.a(paramContext, paramad, parama, true, true, paramBundle, paramString);
    AppMethodBeat.o(15455);
  }
  
  public final void a(Context paramContext, bi.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(15454);
    com.tencent.mm.ui.contact.e.a(paramContext, parama, true, true, paramBundle);
    AppMethodBeat.o(15454);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(15434);
    com.tencent.mm.plugin.game.api.b localb = b.a.bEX();
    if (localb != null) {
      localb.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, "");
    }
    AppMethodBeat.o(15434);
  }
  
  public final void a(Intent paramIntent, bxh parambxh, int paramInt)
  {
    AppMethodBeat.i(15452);
    com.tencent.mm.api.b.a(paramIntent, parambxh, paramInt);
    AppMethodBeat.o(15452);
  }
  
  public final void a(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(15456);
    com.tencent.mm.ui.contact.e.a(paramIntent, paramString);
    AppMethodBeat.o(15456);
  }
  
  public final void a(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad)
  {
    AppMethodBeat.i(15450);
    com.tencent.mm.ui.tools.b.c(paramd, paramActivity, paramad);
    AppMethodBeat.o(15450);
  }
  
  public final void a(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(15449);
    com.tencent.mm.ui.tools.b.a(paramd, paramActivity, paramad, paramBoolean, paramRunnable, 0);
    AppMethodBeat.o(15449);
  }
  
  public final void a(bdt parambdt, String paramString)
  {
    AppMethodBeat.i(15458);
    ((com.tencent.mm.plugin.messenger.foundation.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(parambdt, paramString);
    AppMethodBeat.o(15458);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong)
  {
    AppMethodBeat.i(153478);
    com.tencent.mm.plugin.game.api.b localb = b.a.bEX();
    if (localb != null) {
      localb.a(paramString1, paramString2, paramInt, 4, paramString3, paramLong, "");
    }
    AppMethodBeat.o(153478);
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(15439);
    boolean bool = v.a.a(paramContext, paramInt1, paramInt2, paramString, 4);
    AppMethodBeat.o(15439);
    return bool;
  }
  
  public final boolean a(ad paramad)
  {
    AppMethodBeat.i(15448);
    boolean bool = com.tencent.mm.modelmulti.a.a(paramad);
    AppMethodBeat.o(15448);
    return bool;
  }
  
  public final boolean b(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(15440);
    boolean bool = v.a.a(paramContext, paramInt1, paramInt2, paramString, 7);
    AppMethodBeat.o(15440);
    return bool;
  }
  
  public final void bh(Context paramContext)
  {
    AppMethodBeat.i(15443);
    MMAppMgr.hK(paramContext);
    AppMethodBeat.o(15443);
  }
  
  public final com.tencent.mm.ai.m bs(boolean paramBoolean)
  {
    AppMethodBeat.i(15437);
    if (paramBoolean) {
      r.aiP().lR(4);
    }
    com.tencent.mm.ba.k localk = new com.tencent.mm.ba.k(4);
    aw.Rc().a(localk, 0);
    AppMethodBeat.o(15437);
    return localk;
  }
  
  public final String dE(String paramString)
  {
    AppMethodBeat.i(15428);
    if (com.tencent.mm.pluginsdk.model.app.g.ca(paramString, false) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, false).field_packageName;
      AppMethodBeat.o(15428);
      return paramString;
    }
    AppMethodBeat.o(15428);
    return "";
  }
  
  public final boolean dF(String paramString)
  {
    AppMethodBeat.i(15430);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.dF(paramString);
    AppMethodBeat.o(15430);
    return bool;
  }
  
  public final boolean dG(String paramString)
  {
    AppMethodBeat.i(15438);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.dG(paramString);
    AppMethodBeat.o(15438);
    return bool;
  }
  
  public final void dH(String paramString)
  {
    AppMethodBeat.i(15457);
    com.tencent.mm.aq.b.agX();
    com.tencent.mm.aq.b.sS(paramString);
    AppMethodBeat.o(15457);
  }
  
  public final String f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(15432);
    paramContext = com.tencent.mm.pluginsdk.model.app.p.f(paramContext, paramString1, paramString2);
    AppMethodBeat.o(15432);
    return paramContext;
  }
  
  public final void gf(int paramInt)
  {
    AppMethodBeat.i(15425);
    ab.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.modelmulti.n.aio().lL(paramInt);
    AppMethodBeat.o(15425);
  }
  
  public final boolean n(Activity paramActivity)
  {
    AppMethodBeat.i(15442);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      t.ii(paramActivity);
      AppMethodBeat.o(15442);
      return false;
    }
    com.tencent.mm.pluginsdk.ui.tools.n.m(paramActivity, 2);
    AppMethodBeat.o(15442);
    return true;
  }
  
  public final void o(Activity paramActivity)
  {
    AppMethodBeat.i(15444);
    MMAppMgr.a(paramActivity, null);
    AppMethodBeat.o(15444);
  }
  
  public final String t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(15429);
    paramContext = com.tencent.mm.pluginsdk.model.app.g.t(paramContext, paramString);
    AppMethodBeat.o(15429);
    return paramContext;
  }
  
  public final String t(String paramString, int paramInt)
  {
    AppMethodBeat.i(15427);
    if (com.tencent.mm.pluginsdk.model.app.g.em(paramString, paramInt) != null)
    {
      paramString = com.tencent.mm.pluginsdk.model.app.g.em(paramString, paramInt).field_packageName;
      AppMethodBeat.o(15427);
      return paramString;
    }
    AppMethodBeat.o(15427);
    return "";
  }
  
  public final boolean u(Context paramContext, String paramString)
  {
    AppMethodBeat.i(15431);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.u(paramContext, paramString);
    AppMethodBeat.o(15431);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.aa
 * JD-Core Version:    0.7.0.1
 */