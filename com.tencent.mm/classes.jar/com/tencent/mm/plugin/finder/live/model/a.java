package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/BeautySuitDataManager;", "", "()V", "MMKV_BEAUTY_VALUE", "", "MMKV_KEY_SUIT_ID", "SUIT_NOT_SELECT", "", "TAG", "value", "currentSuitSelect", "getCurrentSuitSelect", "()I", "setCurrentSuitSelect", "(I)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "buildBeautyKey", "suitId", "beautyId", "getBeauty", "getDefaultBeauty", "setBeauty", "", "beautyValue", "setBeautyToDefault", "ReportTools", "plugin-finder_release"})
public final class a
{
  private static final f lrB;
  public static final a ydb;
  
  static
  {
    AppMethodBeat.i(255339);
    ydb = new a();
    lrB = g.ar((kotlin.g.a.a)a.b.ydd);
    AppMethodBeat.o(255339);
  }
  
  public static void Nl(int paramInt)
  {
    AppMethodBeat.i(255320);
    MultiProcessMMKV localMultiProcessMMKV = bcJ();
    StringBuilder localStringBuilder = new StringBuilder("MMKV_KEY_SUIT_ID_");
    p.j(h.aHE(), "MMKernel.account()");
    localMultiProcessMMKV.putInt(b.getUin(), paramInt);
    AppMethodBeat.o(255320);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(255323);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(255323);
    return localMultiProcessMMKV;
  }
  
  public static int dxL()
  {
    AppMethodBeat.i(255317);
    MultiProcessMMKV localMultiProcessMMKV = bcJ();
    StringBuilder localStringBuilder = new StringBuilder("MMKV_KEY_SUIT_ID_");
    p.j(h.aHE(), "MMKernel.account()");
    int i = localMultiProcessMMKV.getInt(b.getUin(), -1000);
    AppMethodBeat.o(255317);
    return i;
  }
  
  public static int gE(int paramInt1, int paramInt2)
  {
    int i = 40;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      return paramInt1;
    case 0: 
      paramInt1 = i;
      switch (paramInt2)
      {
      case 5: 
      case 8: 
      default: 
        return 0;
      case 0: 
        return 35;
      case 1: 
        return 20;
      case 2: 
        return 20;
      case 3: 
        return 0;
      case 10: 
        return 0;
      case 4: 
        return 10;
      case 6: 
        return 80;
      case 7: 
        return 80;
      case 13: 
        return 10;
      case 11: 
        return 10;
      case 12: 
        return 10;
      }
      return 30;
    case 1: 
      paramInt1 = i;
      switch (paramInt2)
      {
      case 2: 
      case 5: 
      case 8: 
      default: 
        return 0;
      case 0: 
        return 60;
      case 1: 
        return 30;
      case 3: 
        return 0;
      case 10: 
        return 0;
      case 4: 
        return 30;
      case 6: 
        return 90;
      case 7: 
        return 90;
      case 13: 
        return 20;
      case 11: 
        return 20;
      case 12: 
        return 30;
      }
      return 30;
    }
    paramInt1 = i;
    switch (paramInt2)
    {
    case 1: 
    case 5: 
    case 8: 
    case 11: 
    default: 
      return 0;
    case 0: 
      return 90;
    case 2: 
      return 70;
    case 3: 
      return 0;
    case 10: 
      return 0;
    case 4: 
      return 35;
    case 6: 
      return 100;
    case 7: 
      return 100;
    case 13: 
      return 30;
    case 12: 
      return 50;
    }
    return 30;
  }
  
  public static int gF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255330);
    String str = gG(paramInt1, paramInt2);
    paramInt1 = bcJ().getInt(str, gE(paramInt1, paramInt2));
    AppMethodBeat.o(255330);
    return paramInt1;
  }
  
  public static String gG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255333);
    Object localObject = new StringBuilder("MMKV_BEAUTY_VALUE_");
    p.j(h.aHE(), "MMKernel.account()");
    localObject = b.getUin() + "_" + paramInt1 + "_" + paramInt2;
    AppMethodBeat.o(255333);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/BeautySuitDataManager$ReportTools;", "", "()V", "makeBeautyInfoJson", "", "plugin-finder_release"})
  public static final class a
  {
    public static final a ydc;
    
    static
    {
      AppMethodBeat.i(227930);
      ydc = new a();
      AppMethodBeat.o(227930);
    }
    
    public static String dxM()
    {
      AppMethodBeat.i(227928);
      Object localObject1 = new JSONObject();
      Object localObject2 = a.ydb;
      int i = a.dxL();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a.gF(i, 0)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 8)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 1)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 2)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 3)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 10)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 4)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 5)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 6)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 7)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 13)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 11)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 12)).append(";");
      ((StringBuilder)localObject2).append(a.gF(i, 9));
      ((JSONObject)localObject1).put("type", i + 1);
      ((JSONObject)localObject1).put("result", ((StringBuilder)localObject2).toString());
      localObject1 = ((JSONObject)localObject1).toString();
      p.j(localObject1, "beautyJson.toString()");
      localObject1 = n.l((String)localObject1, ",", ";", false);
      AppMethodBeat.o(227928);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.a
 * JD-Core Version:    0.7.0.1
 */