package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.cd;
import com.tencent.mm.ui.base.t;

public final class k
{
  static int ixR;
  public static boolean waq = true;
  public static boolean war = false;
  public static boolean was = false;
  public static p wat;
  static double wau;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    if (war)
    {
      localObject1 = ak.getContext();
      localObject2 = ak.getResources();
      if (wat == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(wat.waF))
      {
        t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geT.gdy), Boolean.valueOf(was) });
    if (was)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.dpC();
    int k;
    int i;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!ak.cpe()))
    {
      k = bu.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = bu.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = bu.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx != -1) && ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx & 0x1) == 0)) {
        break label714;
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx & 0x1) == 0)) {
        break label467;
      }
      wat.dqa().waG = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gds != -1)
      {
        localObject2 = wat;
        if (com.tencent.mm.compatible.deviceinfo.ae.geT.gds == 1)
        {
          bool = true;
          label292:
          ((p)localObject2).hyP = bool;
          label299:
          if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx & 0x2) != 0))
          {
            if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx & 0x2) == 0)) {
              break label601;
            }
            paramParameters = wat.dpY();
            paramParameters.waG = false;
            paramParameters.dpZ();
          }
        }
      }
      label712:
      for (;;)
      {
        wat.waF = -1;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { wat.toString() });
        AppMethodBeat.o(89426);
        return;
        k = bu.getInt(((a)g.ab(a.class)).acL().getValue("SightMediaCodecMinApiLevel"), 19);
        i = bu.getInt(((a)g.ab(a.class)).acL().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = bu.getInt(((a)g.ab(a.class)).acL().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label467:
        if ((!com.tencent.mm.compatible.util.d.lA(i)) || (ixR < 512) || (wau < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label714;
        }
        localObject2 = wat;
        ((p)localObject2).waJ = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.dpC(), ((p)localObject2).hxV.width * 2, paramBoolean);
        if ((((p)localObject2).waJ != null) && (((p)localObject2).waJ.wah != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label714;
          }
          wat.dqa().waG = true;
          i = 1;
          break;
        }
        bool = false;
        break label292;
        wat.hyP = false;
        break label299;
        label601:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.lA(j)) && (ixR >= 512) && (wau >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = wat;
          ((p)localObject1).waJ = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.dpC(), 720, paramBoolean);
          if ((((p)localObject1).waJ != null) && (((p)localObject1).waJ.wah != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label712;
            }
            wat.dpY().waG = true;
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
    if (paramc.wah == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.wah = paramc.wak;
      paramc.wai = paramc.wal;
      paramc.waj = paramc.wam;
      if (Math.min(paramc.wai.y, paramc.wai.x) >= wat.hxV.width + 16)
      {
        wat.dpZ();
        wat.waG = false;
        wat.hyP = false;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = a.waw;
    war = false;
    was = false;
    ixR = ((ActivityManager)ak.getContext().getSystemService("activity")).getLargeMemoryClass();
    wau = com.tencent.mm.plugin.mmsight.d.fT(ak.getContext());
    Object localObject2 = cd.fwK();
    int i;
    label121:
    int n;
    int m;
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!ak.cpe()))
    {
      i = bu.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (ak.cpe())) {
        break label338;
      }
      com.tencent.mm.compatible.deviceinfo.ae.vE(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(ixR), Double.valueOf(wau), localObject2, com.tencent.mm.compatible.deviceinfo.ae.geT });
      if ((CaptureMMProxy.getInstance() == null) || (ak.cpe())) {
        break label357;
      }
      n = CaptureMMProxy.getInstance().getInt(am.a.IRa, -1);
      m = CaptureMMProxy.getInstance().getInt(am.a.IRd, 1);
      k = CaptureMMProxy.getInstance().getInt(am.a.JaS, 1);
      j = CaptureMMProxy.getInstance().getInt(am.a.JaT, 2);
      label220:
      localObject2 = p.a(n, paramVideoTransPara);
      wat = (p)localObject2;
      if (localObject2 == null) {
        break label453;
      }
      paramVideoTransPara = wat;
      if (m != 1) {
        break label434;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.waH = bool1;
      war = true;
      localObject1 = ak.getContext();
      localObject2 = ak.getResources();
      if (wat != null) {
        break label440;
      }
    }
    label434:
    label440:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(wat.waF))
    {
      t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = bu.getInt(((a)g.ab(a.class)).acL().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label338:
      g.ajS();
      com.tencent.mm.compatible.deviceinfo.ae.vE(g.ajR().ajB().fwI());
      break label121;
      label357:
      g.ajS();
      n = g.ajR().ajA().getInt(am.a.IRa, -1);
      g.ajS();
      m = g.ajR().ajA().getInt(am.a.IRd, 1);
      g.ajS();
      k = g.ajR().ajA().getInt(am.a.JaS, 1);
      g.ajS();
      j = g.ajR().ajA().getInt(am.a.JaT, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label453:
    switch (1.wav[localObject1.ordinal()])
    {
    default: 
      n = com.tencent.mm.compatible.deviceinfo.ae.geT.gdy;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        wat = p.a(n, paramVideoTransPara);
      }
      if (wat == null) {
        break label575;
      }
      if (m != 1) {
        break;
      }
    }
    for (wat.waH = true;; wat.waH = false)
    {
      was = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = com.tencent.mm.compatible.deviceinfo.ae.geU;
      n = 12;
      break;
    }
    label575:
    wat = p.a(1, paramVideoTransPara);
    if (m == 1)
    {
      wat.waH = true;
      wat.waE = k;
      paramVideoTransPara = wat;
      if (j != 2) {
        break label722;
      }
      bool1 = true;
      label615:
      paramVideoTransPara.pXd = bool1;
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdr == -1) {
        break label728;
      }
      wat.gdr = com.tencent.mm.compatible.deviceinfo.ae.geT.gdr;
      label643:
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdu != -1)
      {
        if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdu != 1) {
          break label755;
        }
        bool1 = true;
        label666:
        waq = bool1;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gds == -1) {
        break label767;
      }
      paramVideoTransPara = wat;
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gds != 1) {
        break label761;
      }
    }
    label722:
    label728:
    label755:
    label761:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.hyP = bool1;
      AppMethodBeat.o(89427);
      return;
      wat.waH = false;
      break;
      bool1 = false;
      break label615;
      if (com.tencent.mm.compatible.util.d.lA(i))
      {
        wat.gdr = 2;
        break label643;
      }
      wat.gdr = 1;
      break label643;
      bool1 = false;
      break label666;
    }
    label767:
    wat.hyP = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean dpS()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!ak.cpe()))
    {
      if (CaptureMMProxy.getInstance().getInt(am.a.IRa, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    g.ajS();
    if (g.ajR().ajA().getInt(am.a.IRa, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void dpT()
  {
    AppMethodBeat.i(89430);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    p localp = new p();
    wat = localp;
    localp.hyP = false;
    wat.waG = false;
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      wat.gdr = 2;
      AppMethodBeat.o(89430);
      return;
    }
    wat.gdr = 1;
    AppMethodBeat.o(89430);
  }
  
  public static boolean h(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (war)
    {
      Context localContext = ak.getContext();
      Resources localResources = ak.getResources();
      if (wat == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(wat.waF))
      {
        t.makeText(localContext, localResources.getString(2131760316, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geT.gdr), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geT.gdy), Boolean.valueOf(was) });
    if (was)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdr != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((wat != null) && (1 == wat.gdr))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.KH(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.KH(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (wat != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      wat.gdr = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89424);
      waw = new a("MMSightCameraConfig", 0);
      wax = new a("MMStoryCameraConfig", 1);
      way = new a[] { waw, wax };
      AppMethodBeat.o(89424);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */