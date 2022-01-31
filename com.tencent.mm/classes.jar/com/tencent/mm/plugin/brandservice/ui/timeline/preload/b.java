package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.a.ac;
import a.f.b.j;
import a.l;
import a.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mmkv.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"SLOT_DURATION", "", "SLOT_SIZE", "currentSlotId", "", "getCurrentSlotId", "()J", "urlHashCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearSlots", "", "getContentId", "url", "getInfoId", "getInvalidId", "getSlot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "id", "getSlotMMKV", "slot", "getStrip", "openScene", "hashUrl", "mmkvSlot", "verifySlot", "", "getBuff", "buffer", "Lcom/tencent/mmkv/NativeBuffer;", "getBuffSize", "getContent", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "hasContent", "slotKey", "plugin-brandservice_release"})
public final class b
{
  private static final int jZD = 900000;
  private static final int jZE = 3;
  private static HashMap<String, String> jZF;
  
  static
  {
    AppMethodBeat.i(14798);
    jZD = 900000;
    jZE = 3;
    jZF = new HashMap();
    AppMethodBeat.o(14798);
  }
  
  private static final String GP(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(14786);
    Object localObject2;
    if (jZF.containsKey(paramString))
    {
      localObject2 = (Map)jZF;
      j.q(localObject2, "receiver$0");
      j.q(localObject2, "receiver$0");
      if ((localObject2 instanceof ac)) {}
      for (paramString = ((ac)localObject2).eaU();; paramString = (String)localObject1)
      {
        paramString = (String)paramString;
        AppMethodBeat.o(14786);
        return paramString;
        localObject1 = ((Map)localObject2).get(paramString);
        if ((localObject1 == null) && (!((Map)localObject2).containsKey(paramString)))
        {
          paramString = (Throwable)new NoSuchElementException("Key " + paramString + " is missing in the map.");
          AppMethodBeat.o(14786);
          throw paramString;
        }
      }
    }
    Object localObject1 = new StringBuilder("matched_");
    while (i < 3)
    {
      localObject2 = new String[] { "__biz", "mid", "idx" }[i];
      String str = p.dj(paramString, (String)localObject2);
      if (str == null)
      {
        localObject1 = Integer.toString(("not_matched_" + p.Hb(paramString)).hashCode(), a.We(16));
        j.p(localObject1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        jZF.put(paramString, localObject1);
        AppMethodBeat.o(14786);
        return localObject1;
      }
      ((StringBuilder)localObject1).append((String)localObject2 + ':' + str + '-');
      i += 1;
    }
    localObject1 = Integer.toString(((StringBuilder)localObject1).toString().hashCode(), a.We(16));
    j.p(localObject1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    jZF.put(paramString, localObject1);
    AppMethodBeat.o(14786);
    return localObject1;
  }
  
  public static final String GQ(String paramString)
  {
    AppMethodBeat.i(14787);
    j.q(paramString, "url");
    paramString = "_info_" + GP(paramString);
    AppMethodBeat.o(14787);
    return paramString;
  }
  
  public static final String GR(String paramString)
  {
    AppMethodBeat.i(14788);
    j.q(paramString, "url");
    paramString = "_content_" + GP(paramString);
    AppMethodBeat.o(14788);
    return paramString;
  }
  
  public static final String GS(String paramString)
  {
    AppMethodBeat.i(14789);
    j.q(paramString, "url");
    paramString = "_invalid_" + GP(paramString);
    AppMethodBeat.o(14789);
    return paramString;
  }
  
  public static final as GT(String paramString)
  {
    AppMethodBeat.i(14790);
    j.q(paramString, "id");
    long l = aXd();
    as localas = hU(l);
    if (localas.containsKey(paramString))
    {
      AppMethodBeat.o(14790);
      return localas;
    }
    localas = hU(Math.abs(l - 1L));
    if (localas.containsKey(paramString))
    {
      AppMethodBeat.o(14790);
      return localas;
    }
    AppMethodBeat.o(14790);
    return null;
  }
  
  public static final String GU(String paramString)
  {
    AppMethodBeat.i(14794);
    j.q(paramString, "receiver$0");
    Object localObject = GT(paramString);
    if (localObject != null)
    {
      localObject = ((as)localObject).getString(paramString, "");
      paramString = (String)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramString = "";
    }
    AppMethodBeat.o(14794);
    return paramString;
  }
  
  public static final int GV(String paramString)
  {
    AppMethodBeat.i(14796);
    j.q(paramString, "receiver$0");
    as localas = GT(paramString);
    if (localas != null)
    {
      int i = localas.getValueActualSize(paramString);
      AppMethodBeat.o(14796);
      return i;
    }
    AppMethodBeat.o(14796);
    return -1;
  }
  
  public static final int a(String paramString, d paramd)
  {
    AppMethodBeat.i(14795);
    j.q(paramString, "receiver$0");
    j.q(paramd, "buffer");
    as localas = GT(paramString);
    if (localas != null)
    {
      int i = localas.writeValueToNativeBuffer(paramString, paramd);
      AppMethodBeat.o(14795);
      return i;
    }
    AppMethodBeat.o(14795);
    return -1;
  }
  
  public static final String a(eh parameh)
  {
    AppMethodBeat.i(14792);
    j.q(parameh, "receiver$0");
    parameh = parameh.Url;
    j.p(parameh, "this.Url");
    parameh = GR(parameh);
    AppMethodBeat.o(14792);
    return parameh;
  }
  
  public static final long aXd()
  {
    AppMethodBeat.i(152679);
    long l = System.currentTimeMillis() / jZD;
    AppMethodBeat.o(152679);
    return l;
  }
  
  public static final void aXe()
  {
    AppMethodBeat.i(14791);
    long l = aXd();
    hV(Math.abs(l - 1L));
    hV(l);
    hV(l + 1L);
    AppMethodBeat.o(14791);
  }
  
  public static final boolean b(eh parameh)
  {
    AppMethodBeat.i(14793);
    j.q(parameh, "receiver$0");
    if (GT(a(parameh)) != null)
    {
      AppMethodBeat.o(14793);
      return true;
    }
    AppMethodBeat.o(14793);
    return false;
  }
  
  private static final String hS(long paramLong)
  {
    AppMethodBeat.i(14782);
    String str = "_slots_id_" + paramLong % jZE;
    AppMethodBeat.o(14782);
    return str;
  }
  
  private static final as hT(long paramLong)
  {
    AppMethodBeat.i(14783);
    as localas = as.eu(hS(paramLong), 2);
    j.p(localas, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
    AppMethodBeat.o(14783);
    return localas;
  }
  
  public static final as hU(long paramLong)
  {
    AppMethodBeat.i(14784);
    if (!hV(paramLong)) {
      o.aXO().putLong(hS(paramLong), paramLong);
    }
    as localas = hT(paramLong);
    AppMethodBeat.o(14784);
    return localas;
  }
  
  private static final boolean hV(long paramLong)
  {
    AppMethodBeat.i(14785);
    if (o.aXO().getLong(hS(paramLong), 0L) != paramLong)
    {
      hT(paramLong).clear();
      AppMethodBeat.o(14785);
      return false;
    }
    AppMethodBeat.o(14785);
    return true;
  }
  
  public static final int si(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(14797);
    Object localObject1 = o.aXO().decodeBytes("_msg_scene_strip");
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {}
      Object localObject2;
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          j = 1;
        }
        if (j != 1) {
          break label210;
        }
        localObject2 = new bwu();
        ((bwu)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((bwu)localObject2).wuM;
        j.p(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label210;
          }
          localObject2 = (bwt)((Iterator)localObject1).next();
          if (((bwt)localObject2).Scene == paramInt)
          {
            if (((bwt)localObject2).xJX > 0) {
              break;
            }
            ab.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((bwt)localObject2).xJX);
          }
        }
      }
      ab.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((bwt)localObject2).xJX);
      paramInt = ((bwt)localObject2).xJX;
      AppMethodBeat.o(14797);
      return paramInt;
    }
    label210:
    AppMethodBeat.o(14797);
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b
 * JD-Core Version:    0.7.0.1
 */