package com.tencent.mm.mj_template.album_template;

import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/MaasExportAutoFallback;", "", "()V", "KeyMassAutoFallbackOutputSize", "", "MaasAutoFallbackOutputSizeConfig", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "TAG", "dimensionLeveSizeMapping", "", "", "enableAutoFallback", "", "getEnableAutoFallback", "()Z", "enableAutoFallback$delegate", "Lkotlin/Lazy;", "sizeDimensionLevelMapping", "getSizeDimensionLevelMapping", "()Ljava/util/Map;", "supportedEncodeDimens", "", "calcFallbackDimensionLevel", "Lcom/tencent/maas/instamovie/mediafoundation/DimensionLevel;", "level", "getAutoFallbackSize", "markExportFailed", "", "dimension", "dimensionLevelToSize", "sizeToDimensionLevel", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final int Ue;
  public static final d nWs;
  public static final MultiProcessMMKV nWt;
  private static final j nWu;
  private static final Map<Integer, Integer> nWv;
  public static final Map<Integer, Integer> nWw;
  private static final List<Integer> nWx;
  
  static
  {
    AppMethodBeat.i(240493);
    nWs = new d();
    nWt = MultiProcessMMKV.getMMKV("MaasAutoFallbackOutputSizeConfig");
    nWu = kotlin.k.cm((a)d.a.nWy);
    Map localMap = ak.e(new r[] { v.Y(Integer.valueOf(b.eFU.id), Integer.valueOf(144)), v.Y(Integer.valueOf(b.eFV.id), Integer.valueOf(224)), v.Y(Integer.valueOf(b.eFW.id), Integer.valueOf(360)), v.Y(Integer.valueOf(b.eFX.id), Integer.valueOf(480)), v.Y(Integer.valueOf(b.eFY.id), Integer.valueOf(540)), v.Y(Integer.valueOf(b.eFZ.id), Integer.valueOf(720)), v.Y(Integer.valueOf(b.eGa.id), Integer.valueOf(1080)), v.Y(Integer.valueOf(b.eGb.id), Integer.valueOf(1440)), v.Y(Integer.valueOf(b.eGc.id), Integer.valueOf(2160)) });
    nWv = localMap;
    Object localObject1 = (Iterable)localMap.entrySet();
    localMap = (Map)new LinkedHashMap(kotlin.k.k.qu(ak.aKi(p.a((Iterable)localObject1, 10)), 16));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localMap.put(Integer.valueOf(((Number)((Map.Entry)localObject2).getValue()).intValue()), Integer.valueOf(((Number)((Map.Entry)localObject2).getKey()).intValue()));
    }
    nWw = localMap;
    nWx = p.p((Iterable)nWv.values());
    Ue = 8;
    AppMethodBeat.o(240493);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(240459);
    s.u(paramb, "dimension");
    if (bwP())
    {
      int i = ((c)h.ax(c.class)).a(c.a.zeM, 720);
      int j = b(paramb);
      if (j >= i)
      {
        int k = b(uH(paramb.id));
        nWt.encode("KeyMassAutoFallbackOutputSize", k);
        Log.i("MicroMsg.MaasExportAutoFallback", "markExportFailed fallbackDimensionThreshold:" + i + ", size:" + j + ", fallbackSize:" + k);
      }
    }
    AppMethodBeat.o(240459);
  }
  
  private static int b(b paramb)
  {
    AppMethodBeat.i(240476);
    if (nWv.containsKey(Integer.valueOf(paramb.id)))
    {
      paramb = (Integer)nWv.get(Integer.valueOf(paramb.id));
      if (paramb == null)
      {
        AppMethodBeat.o(240476);
        return -1;
      }
      int i = paramb.intValue();
      AppMethodBeat.o(240476);
      return i;
    }
    AppMethodBeat.o(240476);
    return -1;
  }
  
  public static boolean bwP()
  {
    AppMethodBeat.i(240446);
    boolean bool = ((Boolean)nWu.getValue()).booleanValue();
    AppMethodBeat.o(240446);
    return bool;
  }
  
  public static Map<Integer, Integer> bwQ()
  {
    return nWw;
  }
  
  public static b uH(int paramInt)
  {
    if (paramInt == b.eGb.id) {
      return b.eGa;
    }
    if (paramInt == b.eGa.id) {
      return b.eFZ;
    }
    return b.eFY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.d
 * JD-Core Version:    0.7.0.1
 */