package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/BeautySuitDataManager;", "", "()V", "MMKV_BEAUTY_VALUE", "", "MMKV_KEY_SUIT_ID", "SUIT_NOT_SELECT", "", "TAG", "value", "currentSuitSelect", "getCurrentSuitSelect", "()I", "setCurrentSuitSelect", "(I)V", "isLowDevice", "", "()Z", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "buildBeautyKey", "suitId", "beautyId", "getBeauty", "isMale", "invalidValue", "getDefaultBeauty", "isUseToShownDefaultPoint", "isAllDefault", "setBeauty", "", "beautyValue", "setBeautyToDefault", "ReportTools", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a CDv;
  private static final boolean CDw;
  private static final j exj;
  
  static
  {
    AppMethodBeat.i(359325);
    CDv = new a();
    Object localObject1 = q.aPo();
    s.s(localObject1, "getModel()");
    String str2 = ((String)localObject1).toLowerCase();
    s.s(str2, "(this as java.lang.String).toLowerCase()");
    Object localObject2 = ((c)h.ax(c.class)).a(c.a.zwt, "");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = ((c)h.ax(c.class)).a(c.a.zwu, "");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    String str1 = ((c)h.ax(c.class)).a(c.a.zwv, "");
    localObject3 = str1;
    if (str1 == null) {
      localObject3 = "";
    }
    Log.i("Finder.BeautySuitDataManager", "#init this=" + str2 + " cfg0=" + (String)localObject1 + " cfg1=" + (String)localObject2 + " cfg2=" + (String)localObject3);
    if ((n.i((CharSequence)localObject1, (CharSequence)str2)) || (n.i((CharSequence)localObject2, (CharSequence)str2)) || (n.i((CharSequence)localObject3, (CharSequence)str2))) {}
    for (boolean bool = true;; bool = false)
    {
      CDw = bool;
      exj = k.cm((kotlin.g.a.a)a.b.CDy);
      AppMethodBeat.o(359325);
      return;
    }
  }
  
  public static void OK(int paramInt)
  {
    AppMethodBeat.i(359266);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    h.baC();
    localMultiProcessMMKV.putInt(s.X("MMKV_KEY_SUIT_ID_", Integer.valueOf(b.getUin())), paramInt);
    AppMethodBeat.o(359266);
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(359272);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(359272);
    return localMultiProcessMMKV;
  }
  
  public static void ax(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(359307);
    Log.i("Finder.BeautySuitDataManager", "#setBeauty suitId=" + paramInt1 + " beautyId=" + paramInt2 + " beautyValue" + paramInt3);
    switch (paramInt1)
    {
    default: 
      String str = hF(paramInt1, paramInt2);
      atj().putInt(str, paramInt3);
      AppMethodBeat.o(359307);
      return;
    }
    AppMethodBeat.o(359307);
  }
  
  public static int b(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(359292);
    if (paramInt2 == 20)
    {
      AppMethodBeat.o(359292);
      return paramInt3;
    }
    if (CDw) {}
    switch (paramInt2)
    {
    case 18: 
    case 19: 
    default: 
      String str = hF(paramInt1, paramInt2);
      paramInt1 = atj().getInt(str, g(paramInt1, paramInt2, paramBoolean, false));
      AppMethodBeat.o(359292);
      return paramInt1;
    }
    AppMethodBeat.o(359292);
    return paramInt3;
  }
  
  public static boolean ejZ()
  {
    return CDw;
  }
  
  public static int eka()
  {
    AppMethodBeat.i(359260);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    h.baC();
    int i = localMultiProcessMMKV.getInt(s.X("MMKV_KEY_SUIT_ID_", Integer.valueOf(b.getUin())), -1000);
    AppMethodBeat.o(359260);
    return i;
  }
  
  public static int g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
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
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 10: 
      case 4: 
      case 6: 
      case 7: 
      case 13: 
      case 11: 
      case 12: 
      case 9: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
        do
        {
          return 0;
          return 35;
          return 20;
          return 20;
          return 0;
          return 0;
          return 10;
          return 80;
          return 80;
          return 20;
          return 10;
          return 10;
          return 30;
          return 10;
          return 0;
          return 0;
          return 0;
          if (paramBoolean2) {
            return 20;
          }
          if (paramBoolean1) {
            return 20;
          }
          return 0;
          if (paramBoolean2) {
            return 20;
          }
        } while (paramBoolean1);
        return 20;
      case 20: 
        return 10;
      }
      return 30;
    case 1: 
      paramInt1 = i;
      switch (paramInt2)
      {
      case 2: 
      case 5: 
      case 21: 
      default: 
      case 0: 
      case 8: 
      case 1: 
      case 3: 
      case 10: 
      case 4: 
      case 6: 
      case 7: 
      case 13: 
      case 11: 
      case 12: 
      case 9: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
        do
        {
          return 0;
          return 60;
          return 50;
          return 30;
          return 0;
          return 0;
          return 30;
          return 90;
          return 90;
          return 30;
          return 20;
          return 30;
          return 30;
          return 30;
          return 0;
          return 0;
          return 0;
          if (paramBoolean2) {
            return 30;
          }
          if (paramBoolean1) {
            return 30;
          }
          return 0;
          if (paramBoolean2) {
            return 30;
          }
        } while (paramBoolean1);
        return 30;
      }
      return 20;
    }
    paramInt1 = i;
    switch (paramInt2)
    {
    case 1: 
    case 5: 
    case 11: 
    case 13: 
    case 20: 
    default: 
    case 0: 
    case 8: 
    case 2: 
    case 3: 
    case 10: 
    case 4: 
    case 6: 
    case 7: 
    case 12: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
      do
      {
        return 0;
        return 90;
        return 60;
        return 70;
        return 0;
        return 0;
        return 35;
        return 100;
        return 100;
        return 50;
        return 30;
        return 35;
        return 0;
        return 0;
        return 0;
        paramInt1 = i;
        if (paramBoolean2) {
          break;
        }
        paramInt1 = i;
        if (paramBoolean1) {
          break;
        }
        return 0;
        paramInt1 = i;
        if (paramBoolean2) {
          break;
        }
      } while (paramBoolean1);
      return 40;
    }
    return 50;
  }
  
  public static String hF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(359314);
    Object localObject = new StringBuilder("MMKV_BEAUTY_VALUE_");
    h.baC();
    localObject = b.getUin() + '_' + paramInt1 + '_' + paramInt2;
    AppMethodBeat.o(359314);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.a
 * JD-Core Version:    0.7.0.1
 */