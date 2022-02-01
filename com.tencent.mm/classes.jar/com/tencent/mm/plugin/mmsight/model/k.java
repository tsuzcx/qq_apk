package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.base.u;

public final class k
{
  static int jtg;
  public static boolean zuv = true;
  public static boolean zuw = false;
  public static boolean zux = false;
  public static p zuy;
  static double zuz;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    if (zuw)
    {
      localObject1 = MMApplicationContext.getContext();
      localObject2 = MMApplicationContext.getResources();
      if (zuy == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(zuy.zuK))
      {
        u.makeText((Context)localObject1, ((Resources)localObject2).getString(2131761758, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    Log.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ae.gKA.gIW), Boolean.valueOf(zux) });
    if (zux)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.ejr();
    int k;
    int i;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      k = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      Log.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((ae.gKA.gIV != -1) && ((ae.gKA.gIV & 0x1) == 0)) {
        break label714;
      }
      if ((ae.gKA.gIV == -1) || ((ae.gKA.gIV & 0x1) == 0)) {
        break label467;
      }
      zuy.ejQ().zuL = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (ae.gKA.gIQ != -1)
      {
        localObject2 = zuy;
        if (ae.gKA.gIQ == 1)
        {
          bool = true;
          label292:
          ((p)localObject2).isQ = bool;
          label299:
          if ((ae.gKA.gIV == -1) || ((ae.gKA.gIV & 0x2) != 0))
          {
            if ((ae.gKA.gIV == -1) || ((ae.gKA.gIV & 0x2) == 0)) {
              break label601;
            }
            paramParameters = zuy.ejO();
            paramParameters.zuL = false;
            paramParameters.ejP();
          }
        }
      }
      label712:
      for (;;)
      {
        zuy.zuK = -1;
        Log.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { zuy.toString() });
        AppMethodBeat.o(89426);
        return;
        k = Util.getInt(((a)g.af(a.class)).aqJ().getValue("SightMediaCodecMinApiLevel"), 19);
        i = Util.getInt(((a)g.af(a.class)).aqJ().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = Util.getInt(((a)g.af(a.class)).aqJ().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label467:
        if ((!com.tencent.mm.compatible.util.d.oD(i)) || (jtg < 512) || (zuz < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label714;
        }
        localObject2 = zuy;
        ((p)localObject2).zuO = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.ejr(), ((p)localObject2).irT.width * 2, paramBoolean);
        if ((((p)localObject2).zuO != null) && (((p)localObject2).zuO.zum != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label714;
          }
          zuy.ejQ().zuL = true;
          i = 1;
          break;
        }
        bool = false;
        break label292;
        zuy.isQ = false;
        break label299;
        label601:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.oD(j)) && (jtg >= 512) && (zuz >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = zuy;
          ((p)localObject1).zuO = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.ejr(), 720, paramBoolean);
          if ((((p)localObject1).zuO != null) && (((p)localObject1).zuO.zum != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label712;
            }
            zuy.ejO().zuL = true;
            break;
          }
        }
      }
      label714:
      i = 0;
    }
  }
  
  public static void a(h.c paramc)
  {
    AppMethodBeat.i(89429);
    if (paramc.zum == null)
    {
      Log.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.zum = paramc.zup;
      paramc.zun = paramc.zuq;
      paramc.zuo = paramc.zur;
      if (Math.min(paramc.zun.y, paramc.zun.x) >= zuy.irT.width + 16)
      {
        zuy.ejP();
        zuy.zuL = false;
        zuy.isQ = false;
        Log.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = a.zuB;
    zuw = false;
    zux = false;
    jtg = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    zuz = com.tencent.mm.plugin.mmsight.d.gy(MMApplicationContext.getContext());
    Object localObject2 = ck.getFingerprint();
    int i;
    label121:
    int n;
    int m;
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      i = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      Log.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (MMApplicationContext.isMMProcess())) {
        break label338;
      }
      ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      Log.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(jtg), Double.valueOf(zuz), localObject2, ae.gKA });
      if ((CaptureMMProxy.getInstance() == null) || (MMApplicationContext.isMMProcess())) {
        break label357;
      }
      n = CaptureMMProxy.getInstance().getInt(ar.a.NZc, -1);
      m = CaptureMMProxy.getInstance().getInt(ar.a.NZf, 1);
      k = CaptureMMProxy.getInstance().getInt(ar.a.Ojz, 1);
      j = CaptureMMProxy.getInstance().getInt(ar.a.OjA, 2);
      label220:
      localObject2 = p.a(n, paramVideoTransPara);
      zuy = (p)localObject2;
      if (localObject2 == null) {
        break label453;
      }
      paramVideoTransPara = zuy;
      if (m != 1) {
        break label434;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.zuM = bool1;
      zuw = true;
      localObject1 = MMApplicationContext.getContext();
      localObject2 = MMApplicationContext.getResources();
      if (zuy != null) {
        break label440;
      }
    }
    label434:
    label440:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(zuy.zuK))
    {
      u.makeText((Context)localObject1, ((Resources)localObject2).getString(2131761758, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = Util.getInt(((a)g.af(a.class)).aqJ().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label338:
      g.aAi();
      ae.DV(g.aAh().azR().gEu());
      break label121;
      label357:
      g.aAi();
      n = g.aAh().azQ().getInt(ar.a.NZc, -1);
      g.aAi();
      m = g.aAh().azQ().getInt(ar.a.NZf, 1);
      g.aAi();
      k = g.aAh().azQ().getInt(ar.a.Ojz, 1);
      g.aAi();
      j = g.aAh().azQ().getInt(ar.a.OjA, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label453:
    switch (1.zuA[localObject1.ordinal()])
    {
    default: 
      n = ae.gKA.gIW;
      Log.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        zuy = p.a(n, paramVideoTransPara);
      }
      if (zuy == null) {
        break label575;
      }
      if (m != 1) {
        break;
      }
    }
    for (zuy.zuM = true;; zuy.zuM = false)
    {
      zux = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = ae.gKB;
      n = 12;
      break;
    }
    label575:
    zuy = p.a(1, paramVideoTransPara);
    if (m == 1)
    {
      zuy.zuM = true;
      zuy.zuJ = k;
      paramVideoTransPara = zuy;
      if (j != 2) {
        break label722;
      }
      bool1 = true;
      label615:
      paramVideoTransPara.roc = bool1;
      if (ae.gKA.gIP == -1) {
        break label728;
      }
      zuy.gIP = ae.gKA.gIP;
      label643:
      if (ae.gKA.gIS != -1)
      {
        if (ae.gKA.gIS != 1) {
          break label755;
        }
        bool1 = true;
        label666:
        zuv = bool1;
      }
      if (ae.gKA.gIQ == -1) {
        break label767;
      }
      paramVideoTransPara = zuy;
      if (ae.gKA.gIQ != 1) {
        break label761;
      }
    }
    label722:
    label728:
    label755:
    label761:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.isQ = bool1;
      AppMethodBeat.o(89427);
      return;
      zuy.zuM = false;
      break;
      bool1 = false;
      break label615;
      if (com.tencent.mm.compatible.util.d.oD(i))
      {
        zuy.gIP = 2;
        break label643;
      }
      zuy.gIP = 1;
      break label643;
      bool1 = false;
      break label666;
    }
    label767:
    zuy.isQ = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean ejH()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      if (CaptureMMProxy.getInstance().getInt(ar.a.NZc, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    g.aAi();
    if (g.aAh().azQ().getInt(ar.a.NZc, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void ejI()
  {
    AppMethodBeat.i(89430);
    Log.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    p localp = new p();
    zuy = localp;
    localp.isQ = false;
    zuy.zuL = false;
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      zuy.gIP = 2;
      AppMethodBeat.o(89430);
      return;
    }
    zuy.gIP = 1;
    AppMethodBeat.o(89430);
  }
  
  public static boolean i(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (zuw)
    {
      Context localContext = MMApplicationContext.getContext();
      Resources localResources = MMApplicationContext.getResources();
      if (zuy == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(zuy.zuK))
      {
        u.makeText(localContext, localResources.getString(2131761758, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ae.gKA.gIP), Integer.valueOf(ae.gKA.gIW), Boolean.valueOf(zux) });
    if (zux)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (ae.gKA.gIP != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((zuy != null) && (1 == zuy.gIP))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.QI(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.QI(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (zuy != null)
    {
      Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      zuy.gIP = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89424);
      zuB = new a("MMSightCameraConfig", 0);
      zuC = new a("MMStoryCameraConfig", 1);
      zuD = new a[] { zuB, zuC };
      AppMethodBeat.o(89424);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */