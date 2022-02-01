package com.tencent.mm.plugin.hld.c;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.hld.model.c;
import com.tencent.mm.plugin.hld.model.j;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.m;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.n.d;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/dict/WxImeDictFetcher;", "", "()V", "DEFAULT_CIPHER_ALGORITHM", "", "DEFAULT_GCM_PARAMETER_IV", "MAX_CDN_RETRY_DOWNLOAD_TIME", "", "TAG", "cdnCallback", "com/tencent/mm/plugin/hld/dict/WxImeDictFetcher$cdnCallback$1", "Lcom/tencent/mm/plugin/hld/dict/WxImeDictFetcher$cdnCallback$1;", "currentBaseCloudDictMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "Lkotlin/collections/HashMap;", "currentCommonCloudDictMap", "currentOptionalCloudDictMap", "currentUserLocalDictMap", "Lcom/tencent/mm/protocal/protobuf/ImeLocalRawDictInfo;", "deleteDictMap", "downloadTaskHistoryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "downloadTaskMap", "fetchFail", "", "fetching", "getFetching", "()Z", "setFetching", "(Z)V", "firstFetchCloudDictHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "num", "addDownTask", "", "cloudDict", "decryptStringResource", "", "content", "password", "deleteLocalDict", "doGetImeDictCallback", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "doGetImeDictListConfigCallback", "doGetImeDictRawCallback", "downloadImp", "mediaId", "existDict", "fetchCloudDictListConfig", "getBaseDict", "", "getCommonDict", "getDictCachePath", "typeSuffix", "getDictKey", "getDictPath", "getImeDict", "recommendationType", "getImeDictRaws", "rawDictList", "", "getLocalUserDict", "getMediaId", "getOptionalDict", "getPatchBaseDict", "patchDict", "getRawDictPath", "rawDictInfo", "Lcom/tencent/mm/protocal/protobuf/ImeRawDictInfo;", "handleAttrChange", "safetyMode", "oriAttr", "reFetch", "removeDictFromCloudKV", "dict", "newCloud", "unZlib", "inputPath", "outputPath", "updateCloudDict", "newDicts", "Ljava/util/LinkedList;", "fromGetImeDict", "updateCurrentCloudDictMap", "updateCurrentLocalUserDictMap", "updateDictToCurrentKV", "IPCCgiImeGetImeDict", "IPCCgiImeGetImeDictRaw", "IPCGetImeDictListConfig", "plugin-hld_release"})
public final class a
{
  private static final HashMap<String, cll> DvA;
  private static final HashMap<String, clh> DvB;
  private static final HashMap<String, clh> DvC;
  private static final ArrayList<String> DvD;
  private static volatile boolean DvE;
  private static boolean DvF;
  private static final e DvG;
  public static final a DvH;
  private static final MMHandler Dvw;
  private static final HashMap<String, clh> Dvx;
  private static final HashMap<String, clh> Dvy;
  private static final HashMap<String, clh> Dvz;
  private static int num;
  
  static
  {
    AppMethodBeat.i(209578);
    DvH = new a();
    Dvw = (MMHandler)new h(Looper.getMainLooper());
    Dvx = new HashMap();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new cli();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject2 = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((cli)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject1 = ((cli)localObject1).TsR.iterator();
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (clh)((Iterator)localObject1).next();
      kotlin.g.b.p.j(localObject2, "cloudDict");
      localObject3 = c((clh)localObject2);
      if (((clh)localObject2).TsM == com.tencent.mm.plugin.hld.model.l.DDO.value) {
        localHashMap.put(localObject3, localObject2);
      }
      for (;;)
      {
        Log.i("WxIme.WxImeDictFetcher", "currentCloudDictMap init " + ((clh)localObject2).name + ' ' + ((clh)localObject2).version + ' ' + ((clh)localObject2).ddx);
        break;
        if (((clh)localObject2).TsM == com.tencent.mm.plugin.hld.model.l.DDQ.value) {
          ((Map)Dvx).put(localObject3, localObject2);
        }
      }
    }
    Dvy = localHashMap;
    Dvz = new HashMap();
    localHashMap = new HashMap();
    localObject1 = new clo();
    localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject2 = com.tencent.mm.plugin.hld.f.l.eHB();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((clo)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject2 = ((clo)localObject1).Ttc.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cll)((Iterator)localObject2).next();
      localHashMap.put(((cll)localObject3).TsZ, localObject3);
      Log.i("WxIme.WxImeDictFetcher", "currentUserLocalDictMap init " + ((cll)localObject3).type + ' ' + ((cll)localObject3).TsZ);
    }
    localObject1 = ((clo)localObject1).Ttb;
    if (localObject1 != null)
    {
      localObject1 = ((cli)localObject1).TsR.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (clh)((Iterator)localObject1).next();
        kotlin.g.b.p.j(localObject2, "cloudDict");
        localObject3 = c((clh)localObject2);
        ((Map)Dvz).put(localObject3, localObject2);
        Log.i("WxIme.WxImeDictFetcher", "currentUserLocalDictMap optionalDicts init " + ((clh)localObject2).name + ' ' + ((clh)localObject2).version + ' ' + ((clh)localObject2).ddx);
      }
    }
    DvA = localHashMap;
    DvB = new HashMap();
    DvC = new HashMap();
    DvD = new ArrayList();
    DvG = new e();
    AppMethodBeat.o(209578);
  }
  
  private static void a(clh paramclh, boolean paramBoolean)
  {
    AppMethodBeat.i(209562);
    String str = c(paramclh);
    paramclh = com.tencent.mm.plugin.hld.f.l.DHK;
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.hld.f.l.getKV();
    cli localcli;
    Object localObject;
    if (localMultiProcessMMKV != null)
    {
      localcli = new cli();
      if (paramBoolean)
      {
        paramclh = "key_new_cloud_dicts";
        localObject = localMultiProcessMMKV.decodeBytes(paramclh);
        if (localObject != null) {
          localcli.parseFrom((byte[])localObject);
        }
        Iterator localIterator = localcli.TsR.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (clh)localIterator.next();
          kotlin.g.b.p.j(localObject, "cloudDict");
        } while (!Util.isEqual(c((clh)localObject), str));
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localcli.TsR.remove(localObject);
      }
      localMultiProcessMMKV.encode(paramclh, localcli.toByteArray());
      AppMethodBeat.o(209562);
      return;
      paramclh = "key_current_cloud_dicts";
      break;
      AppMethodBeat.o(209562);
      return;
      localObject = null;
    }
  }
  
  private static String b(clh paramclh)
  {
    AppMethodBeat.i(209567);
    if (paramclh == null)
    {
      AppMethodBeat.o(209567);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.plugin.hld.f.f localf = com.tencent.mm.plugin.hld.f.f.DGX;
    paramclh = com.tencent.mm.plugin.hld.f.f.eGt() + "/" + paramclh.name + "/" + paramclh.version;
    AppMethodBeat.o(209567);
    return paramclh;
  }
  
  public static String c(clh paramclh)
  {
    AppMethodBeat.i(209574);
    kotlin.g.b.p.k(paramclh, "cloudDict");
    paramclh = String.valueOf(paramclh.name);
    AppMethodBeat.o(209574);
    return paramclh;
  }
  
  private static void e(LinkedList<clh> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(209558);
    if (paramLinkedList.isEmpty())
    {
      Log.w("WxIme.WxImeDictFetcher", "updateCloudDict newDicts is empty, fromGetImeDict:".concat(String.valueOf(paramBoolean)));
      if (!paramBoolean)
      {
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.eHg();
        eCU();
        AppMethodBeat.o(209558);
      }
    }
    else
    {
      Log.w("WxIme.WxImeDictFetcher", "updateCloudDict newDicts is " + paramLinkedList.size() + ", fromGetImeDict:" + paramBoolean);
      Object localObject1 = new HashMap();
      Object localObject2 = paramLinkedList.iterator();
      Object localObject3;
      Object localObject4;
      int i;
      label199:
      Object localObject5;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (clh)((Iterator)localObject2).next();
        kotlin.g.b.p.j(localObject3, "localCloudDict");
        localObject4 = c((clh)localObject3);
        i = -1;
        int j;
        boolean bool;
        label308:
        label366:
        StringBuilder localStringBuilder;
        if (Dvy.containsKey(localObject4))
        {
          paramLinkedList = (clh)Dvy.get(localObject4);
          if (paramLinkedList == null) {
            break label887;
          }
          if (u.agG(paramLinkedList.path))
          {
            j = paramLinkedList.version;
            i = j;
            if (paramLinkedList.version >= ((clh)localObject3).version)
            {
              bool = false;
              i = j;
              localObject5 = new StringBuilder("dict ").append(((clh)localObject3).TsM).append(' ').append(((clh)localObject3).dataType).append(' ').append(((clh)localObject3).lZN).append(' ').append(((clh)localObject3).name).append(' ').append(((clh)localObject3).version).append(' ').append(((clh)localObject3).ddx).append(' ');
              paramLinkedList = ((clh)localObject3).TsI;
              if (paramLinkedList == null) {
                break label895;
              }
              paramLinkedList = Integer.valueOf(paramLinkedList.UH.length);
              localObject5 = ((StringBuilder)localObject5).append(paramLinkedList).append(' ').append(((clh)localObject3).smT).append(' ').append(((clh)localObject3).md5).append(' ');
              paramLinkedList = ((clh)localObject3).TsJ;
              if (paramLinkedList == null) {
                break label900;
              }
              paramLinkedList = Integer.valueOf(paramLinkedList.UH.length);
              localObject5 = ((StringBuilder)localObject5).append(paramLinkedList).append(' ');
              paramLinkedList = ((clh)localObject3).TsN;
              if (paramLinkedList == null) {
                break label905;
              }
              paramLinkedList = Integer.valueOf(paramLinkedList.UH.length);
              label398:
              Log.i("WxIme.WxImeDictFetcher", paramLinkedList + ' ' + ((clh)localObject3).path + " currentVersion:" + i + " needUpdate:" + bool);
              localObject5 = ((clh)localObject3).TsP;
              if (localObject5 != null)
              {
                localStringBuilder = new StringBuilder("dict(patch) ").append(((clh)localObject5).TsM).append(' ').append(((clh)localObject5).dataType).append(' ').append(((clh)localObject5).lZN).append(' ').append(((clh)localObject5).name).append(' ').append(((clh)localObject5).version).append(' ').append(((clh)localObject5).TsO).append(' ').append(((clh)localObject5).ddx).append(' ');
                paramLinkedList = ((clh)localObject5).TsI;
                if (paramLinkedList == null) {
                  break label910;
                }
                paramLinkedList = Integer.valueOf(paramLinkedList.UH.length);
                label580:
                localStringBuilder = localStringBuilder.append(paramLinkedList).append(' ').append(((clh)localObject5).smT).append(' ').append(((clh)localObject5).md5).append(' ');
                paramLinkedList = ((clh)localObject5).TsJ;
                if (paramLinkedList == null) {
                  break label915;
                }
                paramLinkedList = Integer.valueOf(paramLinkedList.UH.length);
                label638:
                localStringBuilder = localStringBuilder.append(paramLinkedList).append(' ');
                paramLinkedList = ((clh)localObject5).TsN;
                if (paramLinkedList == null) {
                  break label920;
                }
              }
            }
          }
        }
        label900:
        label905:
        label910:
        label915:
        label920:
        for (paramLinkedList = Integer.valueOf(paramLinkedList.UH.length);; paramLinkedList = null)
        {
          Log.i("WxIme.WxImeDictFetcher", paramLinkedList + ' ' + ((clh)localObject5).path + " currentVersion:" + i + " needUpdate:" + bool);
          if (!bool) {
            break;
          }
          ((Map)localObject1).put(localObject4, localObject3);
          break;
          bool = true;
          break label199;
          if (Dvz.containsKey(localObject4))
          {
            paramLinkedList = (clh)Dvz.get(localObject4);
            if (paramLinkedList == null) {
              break label887;
            }
            if (u.agG(paramLinkedList.path))
            {
              j = paramLinkedList.version;
              i = j;
              if (paramLinkedList.version >= ((clh)localObject3).version)
              {
                bool = false;
                i = j;
                break label199;
              }
            }
            bool = true;
            break label199;
          }
          if (Dvx.containsKey(localObject4))
          {
            paramLinkedList = (clh)Dvx.get(localObject4);
            if (paramLinkedList != null)
            {
              if (u.agG(paramLinkedList.path))
              {
                j = paramLinkedList.version;
                i = j;
                if (paramLinkedList.version >= ((clh)localObject3).version)
                {
                  bool = false;
                  i = j;
                  break label199;
                }
              }
              bool = true;
              break label199;
            }
          }
          label887:
          bool = true;
          i = -1;
          break label199;
          label895:
          paramLinkedList = null;
          break label308;
          paramLinkedList = null;
          break label366;
          paramLinkedList = null;
          break label398;
          paramLinkedList = null;
          break label580;
          paramLinkedList = null;
          break label638;
        }
      }
      Log.i("WxIme.WxImeDictFetcher", "updateCloudDict cloudDictMap:" + ((HashMap)localObject1).size());
      if (!((Map)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.DHK;
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.getKV();
        if (paramLinkedList != null)
        {
          localObject2 = new cli();
          localObject3 = paramLinkedList.decodeBytes("key_new_cloud_dicts");
          if (localObject3 != null) {
            ((cli)localObject2).parseFrom((byte[])localObject3);
          }
          localObject3 = ((cli)localObject2).TsR.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (clh)((Iterator)localObject3).next();
              kotlin.g.b.p.j(localObject4, "cloudDict");
              localObject5 = (clh)((HashMap)localObject1).get(c((clh)localObject4));
              if (localObject5 != null)
              {
                ((clh)localObject4).TsM = ((clh)localObject5).TsM;
                ((clh)localObject4).dataType = ((clh)localObject5).dataType;
                ((clh)localObject4).lZN = ((clh)localObject5).lZN;
                ((clh)localObject4).name = ((clh)localObject5).name;
                ((clh)localObject4).version = ((clh)localObject5).version;
                ((clh)localObject4).ddx = ((clh)localObject5).ddx;
                ((clh)localObject4).TsI = ((clh)localObject5).TsI;
                ((clh)localObject4).smT = ((clh)localObject5).smT;
                ((clh)localObject4).TsJ = ((clh)localObject5).TsJ;
                ((clh)localObject4).md5 = ((clh)localObject5).md5;
                ((clh)localObject4).TsN = ((clh)localObject5).TsN;
                ((clh)localObject4).lNK = ((clh)localObject5).lNK;
                ((clh)localObject4).SoN = ((clh)localObject5).SoN;
                ((clh)localObject4).TsO = ((clh)localObject5).TsO;
                ((clh)localObject4).TsP = ((clh)localObject5).TsP;
                continue;
                i = 0;
                break;
              }
            }
          }
          localObject3 = ((HashMap)localObject1).keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            ((cli)localObject2).TsR.add(((HashMap)localObject1).get(localObject4));
          }
          paramLinkedList.encode("key_new_cloud_dicts", ((cli)localObject2).toByteArray());
          DvC.clear();
          paramLinkedList = ((cli)localObject2).TsR.iterator();
          while (paramLinkedList.hasNext())
          {
            localObject1 = (clh)paramLinkedList.next();
            kotlin.g.b.p.j(localObject1, "cloudDict");
            com.tencent.e.h.ZvG.d((Runnable)new d((clh)localObject1), "WxIme.WxImeDictFetcheraddDownTask");
          }
          AppMethodBeat.o(209558);
          return;
        }
        AppMethodBeat.o(209558);
        return;
      }
      if (!paramBoolean)
      {
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.eHg();
        eCU();
      }
    }
    AppMethodBeat.o(209558);
  }
  
  public static boolean eCT()
  {
    return DvF;
  }
  
  private static void eCU()
  {
    AppMethodBeat.i(209541);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    long l1;
    if (com.tencent.mm.plugin.hld.f.l.eHf())
    {
      if (num > 6)
      {
        AppMethodBeat.o(209541);
        return;
      }
      int i = num + 1;
      num = i;
      switch (i)
      {
      default: 
        l1 = 1800000L;
      }
      for (;;)
      {
        Dvw.removeMessages(0);
        Dvw.sendEmptyMessageDelayed(0, l1);
        Log.i("WxIme.WxImeDictFetcher", "reFetch " + num + ' ' + l1);
        AppMethodBeat.o(209541);
        return;
        l1 = 30000L;
        continue;
        l1 = 60000L;
        continue;
        l1 = 300000L;
        continue;
        l1 = 600000L;
        continue;
        l1 = 1200000L;
      }
    }
    Dvw.removeMessages(0);
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    long l2;
    if (localObject != null)
    {
      l2 = ((MultiProcessMMKV)localObject).getLong("ime_get_dict_list_next_time", 0L);
      if (l2 != 0L) {
        break label265;
      }
      l1 = 43200000L;
    }
    for (;;)
    {
      Dvw.sendEmptyMessageDelayed(0, l1);
      Log.i("WxIme.WxImeDictFetcher", "reFetch " + l2 + ' ' + l1);
      AppMethodBeat.o(209541);
      return;
      l2 = 0L;
      break;
      label265:
      if (l2 < cm.bfG()) {
        l1 = 10800000L;
      } else {
        l1 = l2 - cm.bfG();
      }
    }
  }
  
  public static void eCV()
  {
    AppMethodBeat.i(209543);
    Object localObject1 = com.tencent.mm.plugin.hld.model.p.DEH;
    if (com.tencent.mm.plugin.hld.model.p.eFn())
    {
      AppMethodBeat.o(209543);
      return;
    }
    localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    if (!com.tencent.mm.plugin.hld.f.l.eHf())
    {
      long l2 = cm.bfG();
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject1 != null) {}
      for (long l1 = ((MultiProcessMMKV)localObject1).getLong("ime_get_dict_list_next_time", 0L); (l1 != 0L) && (l2 < l1); l1 = 0L)
      {
        eCU();
        AppMethodBeat.o(209543);
        return;
      }
      Log.i("WxIme.WxImeDictFetcher", "fetchCloudDictListConfig currentTime:" + l2 + " nextTime:" + l1);
    }
    DvF = true;
    Object localObject4 = eCZ();
    Object localObject3 = eDa();
    Object localObject2 = eDb();
    localObject1 = new clg();
    localObject4 = ((Collection)localObject4).iterator();
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (clh)((Iterator)localObject4).next();
      localObject6 = ((clg)localObject1).TfX;
      abc localabc = new abc();
      localabc.name = ((clh)localObject5).name;
      localabc.version = ((clh)localObject5).version;
      ((LinkedList)localObject6).add(localabc);
    }
    localObject3 = ((Collection)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (clh)((Iterator)localObject3).next();
      localObject5 = ((clg)localObject1).TfX;
      localObject6 = new abc();
      ((abc)localObject6).name = ((clh)localObject4).name;
      ((abc)localObject6).version = ((clh)localObject4).version;
      ((LinkedList)localObject5).add(localObject6);
    }
    localObject2 = ((Collection)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (clh)((Iterator)localObject2).next();
      localObject4 = ((clg)localObject1).TfX;
      localObject5 = new abc();
      ((abc)localObject5).name = ((clh)localObject3).name;
      ((abc)localObject5).version = ((clh)localObject3).version;
      ((LinkedList)localObject4).add(localObject5);
    }
    Log.i("WxIme.WxImeDictFetcher", "initializeCloudDict " + Dvy.size() + ' ' + Dvz.size() + ' ' + Dvx.size() + ' ' + DvA.size() + ' ' + Util.getStack());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putByteArray("dictList", ((clg)localObject1).toByteArray());
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject2, a.c.class, (com.tencent.mm.ipcinvoker.f)g.DvN);
    AppMethodBeat.o(209543);
  }
  
  public static void eCW()
  {
    AppMethodBeat.i(209546);
    Log.i("WxIme.WxImeDictFetcher", "deleteLocalDict deleteSize:" + DvB.size() + " downloadSize:" + DvC.size());
    if ((DvC.size() == 0) && (DvB.size() != 0)) {
      com.tencent.e.h.ZvG.d((Runnable)f.DvM, "WxIme.WxImeDictFetcherdeleteDictMap");
    }
    AppMethodBeat.o(209546);
  }
  
  public static void eCX()
  {
    AppMethodBeat.i(209550);
    Log.i("WxIme.WxImeDictFetcher", "updateCurrentCloudDictMap");
    Dvy.clear();
    Dvx.clear();
    Object localObject1 = new cli();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject2 = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((cli)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject1 = ((cli)localObject1).TsR.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (clh)((Iterator)localObject1).next();
      kotlin.g.b.p.j(localObject2, "cloudDict");
      String str = c((clh)localObject2);
      if (((clh)localObject2).TsM == com.tencent.mm.plugin.hld.model.l.DDO.value) {
        Dvy.put(str, localObject2);
      }
      for (;;)
      {
        Log.i("WxIme.WxImeDictFetcher", "currentCloudDictMap init " + ((clh)localObject2).name + ' ' + ((clh)localObject2).version + ' ' + ((clh)localObject2).ddx + ' ' + ((clh)localObject2).TsM);
        break;
        if (((clh)localObject2).TsM == com.tencent.mm.plugin.hld.model.l.DDQ.value) {
          ((Map)Dvx).put(str, localObject2);
        }
      }
    }
    AppMethodBeat.o(209550);
  }
  
  public static void eCY()
  {
    AppMethodBeat.i(209553);
    Log.i("WxIme.WxImeDictFetcher", "updateCurrentCloudDictMap");
    DvA.clear();
    Dvz.clear();
    Object localObject1 = new clo();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject2 = com.tencent.mm.plugin.hld.f.l.eHB();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((clo)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject2 = ((clo)localObject1).Ttc.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cll)((Iterator)localObject2).next();
      DvA.put(((cll)localObject3).TsZ, localObject3);
      Log.i("WxIme.WxImeDictFetcher", "currentUserCloudDictMap init " + ((cll)localObject3).type + ' ' + ((cll)localObject3).TsZ);
    }
    localObject1 = ((clo)localObject1).Ttb;
    if (localObject1 != null)
    {
      localObject1 = ((cli)localObject1).TsR.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (clh)((Iterator)localObject1).next();
        kotlin.g.b.p.j(localObject2, "cloudDict");
        localObject3 = c((clh)localObject2);
        ((Map)Dvz).put(localObject3, localObject2);
        Log.i("WxIme.WxImeDictFetcher", "currentUserLocalDictMap optionalDicts init " + ((clh)localObject2).name + ' ' + ((clh)localObject2).version + ' ' + ((clh)localObject2).ddx);
      }
      AppMethodBeat.o(209553);
      return;
    }
    AppMethodBeat.o(209553);
  }
  
  public static Collection<clh> eCZ()
  {
    AppMethodBeat.i(209569);
    Collection localCollection = (Collection)new ArrayList(Dvy.values());
    AppMethodBeat.o(209569);
    return localCollection;
  }
  
  public static Collection<clh> eDa()
  {
    AppMethodBeat.i(209570);
    Collection localCollection = (Collection)new ArrayList(Dvz.values());
    AppMethodBeat.o(209570);
    return localCollection;
  }
  
  public static Collection<clh> eDb()
  {
    AppMethodBeat.i(209571);
    Collection localCollection = (Collection)new ArrayList(Dvx.values());
    AppMethodBeat.o(209571);
    return localCollection;
  }
  
  public static Collection<cll> eDc()
  {
    AppMethodBeat.i(209573);
    Collection localCollection = (Collection)new ArrayList(DvA.values());
    AppMethodBeat.o(209573);
    return localCollection;
  }
  
  private static void fC(List<Integer> paramList)
  {
    AppMethodBeat.i(209545);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(209545);
      return;
    }
    Log.i("WxIme.WxImeDictFetcher", "getImeDicts " + paramList.size());
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("rawDictList", new ArrayList((Collection)paramList));
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.b.class, (com.tencent.mm.ipcinvoker.f)j.DvP);
    AppMethodBeat.o(209545);
  }
  
  /* Error */
  public static void iq(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 1009
    //   5: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc_w 1010
    //   12: invokestatic 702	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc_w 1011
    //   19: invokestatic 702	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   22: ldc 246
    //   24: new 248	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 1013
    //   31: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1015
    //   41: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: iconst_0
    //   56: iconst_m1
    //   57: invokestatic 1019	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   60: astore_3
    //   61: new 1021	java/util/zip/Inflater
    //   64: dup
    //   65: invokespecial 1022	java/util/zip/Inflater:<init>	()V
    //   68: astore_0
    //   69: aload_0
    //   70: aload_3
    //   71: invokevirtual 1026	java/util/zip/Inflater:setInput	([B)V
    //   74: aload_1
    //   75: invokestatic 1030	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   78: checkcast 1032	java/io/Closeable
    //   81: astore_3
    //   82: aload_3
    //   83: checkcast 1034	java/io/OutputStream
    //   86: astore_1
    //   87: sipush 1024
    //   90: newarray byte
    //   92: astore 4
    //   94: aload_0
    //   95: invokevirtual 1037	java/util/zip/Inflater:finished	()Z
    //   98: ifne +42 -> 140
    //   101: aload_1
    //   102: aload 4
    //   104: iconst_0
    //   105: aload_0
    //   106: aload 4
    //   108: invokevirtual 1041	java/util/zip/Inflater:inflate	([B)I
    //   111: invokevirtual 1045	java/io/OutputStream:write	([BII)V
    //   114: goto -20 -> 94
    //   117: astore_1
    //   118: ldc_w 1009
    //   121: invokestatic 335	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_0
    //   127: aload_3
    //   128: aload_1
    //   129: invokestatic 1050	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   132: ldc_w 1009
    //   135: invokestatic 335	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: athrow
    //   140: getstatic 772	kotlin/x:aazN	Lkotlin/x;
    //   143: astore_0
    //   144: aload_3
    //   145: aconst_null
    //   146: invokestatic 1050	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   149: ldc_w 1009
    //   152: invokestatic 335	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: astore_0
    //   157: aload_2
    //   158: astore_1
    //   159: goto -32 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString1	String
    //   0	162	1	paramString2	String
    //   1	157	2	localObject1	Object
    //   60	85	3	localObject2	Object
    //   92	15	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   82	94	117	java/lang/Throwable
    //   94	114	117	java/lang/Throwable
    //   140	144	117	java/lang/Throwable
    //   118	126	126	finally
    //   82	94	156	finally
    //   94	114	156	finally
    //   140	144	156	finally
  }
  
  private static byte[] j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(209559);
    if (paramArrayOfByte2 == null)
    {
      Log.e("WxIme.WxImeDictFetcher", "password is null");
      AppMethodBeat.o(209559);
      return null;
    }
    try
    {
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
      Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
      Object localObject = "0000000000000000".getBytes(d.UTF_8);
      kotlin.g.b.p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      localObject = new GCMParameterSpec(128, (byte[])localObject);
      localCipher.init(2, (Key)paramArrayOfByte2, (AlgorithmParameterSpec)localObject);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(209559);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("WxIme.WxImeDictFetcher", Util.stackTraceToString((Throwable)paramArrayOfByte1));
      AppMethodBeat.o(209559);
    }
    return null;
  }
  
  public static void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(209544);
    if (!paramBoolean)
    {
      int i = j.DCV.value;
      Log.i("WxIme.WxImeDictFetcher", "getImeDict ".concat(String.valueOf(i)));
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("type", i);
      Object localObject2 = eDa();
      clg localclg = new clg();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        clh localclh = (clh)((Iterator)localObject2).next();
        LinkedList localLinkedList = localclg.TfX;
        abc localabc = new abc();
        localabc.name = localclh.name;
        localabc.version = localclh.version;
        localLinkedList.add(localabc);
      }
      ((Bundle)localObject1).putByteArray("dictList", localclg.toByteArray());
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject1, a.a.class, (com.tencent.mm.ipcinvoker.f)i.DvO);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(Integer.valueOf(com.tencent.mm.plugin.hld.model.i.DCT.value));
      fC((List)localObject1);
    }
    AppMethodBeat.o(209544);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(clh paramclh) {}
    
    public final void run()
    {
      AppMethodBeat.i(212768);
      Object localObject1 = a.DvH;
      String str = a.d(this.DvL);
      localObject1 = a.DvH;
      if (a.eDe().contains(str))
      {
        Log.i("WxIme.WxImeDictFetcher", "exist task ".concat(String.valueOf(str)));
        AppMethodBeat.o(212768);
        return;
      }
      localObject1 = a.DvH;
      if (a.e(this.DvL))
      {
        localObject1 = a.DvH;
        a.f(this.DvL);
        localObject1 = a.DvH;
        a.a(this.DvL);
        Log.i("WxIme.WxImeDictFetcher", "addDownTask " + this.DvL.name + ' ' + this.DvL.md5 + " exist");
        AppMethodBeat.o(212768);
        return;
      }
      Object localObject2 = this.DvL;
      localObject1 = this.DvL.TsP;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = a.DvH;
        clh localclh = a.g((clh)localObject1);
        if (localclh != null)
        {
          Log.i("WxIme.WxImeDictFetcher", "addDownTask: exist_base_version:" + localclh.version + ", patch_base_version:" + this.DvL.TsP.TsO + ", base_exist:" + u.agG(localclh.path));
          localObject3 = localObject2;
          localObject1 = str;
          if (localclh.version == this.DvL.TsP.TsO)
          {
            localObject3 = localObject2;
            localObject1 = str;
            if (u.agG(localclh.path))
            {
              localObject3 = this.DvL.TsP;
              kotlin.g.b.p.j(localObject3, "cloudDict.patchDict");
              localObject1 = a.DvH;
              localObject1 = a.d((clh)localObject3);
              localObject2 = a.DvH;
              if (a.eDe().contains(localObject1))
              {
                Log.i("WxIme.WxImeDictFetcher", "exist task ".concat(String.valueOf(localObject1)));
                AppMethodBeat.o(212768);
                return;
              }
              ((clh)localObject3).isPatch = true;
              ((clh)localObject3).TsQ = this.DvL;
              Log.i("WxIme.WxImeDictFetcher", "addDownTask use patch:" + ((clh)localObject3).name + "  " + ((clh)localObject3).version + ' ' + ((clh)localObject3).TsO);
            }
          }
          localObject2 = localObject3;
        }
      }
      for (;;)
      {
        localObject3 = a.DvH;
        ((clh)localObject2).path = a.a((clh)localObject2, "download");
        ((clh)localObject2).ELb = 0;
        localObject3 = a.DvH;
        ((Map)a.eDf()).put(localObject1, localObject2);
        localObject3 = a.DvH;
        a.eDe().add(localObject1);
        localObject3 = a.DvH;
        a.b((clh)localObject2, (String)localObject1);
        AppMethodBeat.o(212768);
        return;
        localObject1 = str;
        continue;
        localObject1 = str;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/dict/WxImeDictFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "retryDownload", "localDict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "plugin-hld_release"})
  public static final class e
    implements CdnLogic.DownloadCallback
  {
    private static boolean i(clh paramclh)
    {
      AppMethodBeat.i(214036);
      paramclh.ELb += 1;
      if (paramclh.ELb < 3)
      {
        a locala = a.DvH;
        locala = a.DvH;
        a.b(paramclh, a.d(paramclh));
        AppMethodBeat.o(214036);
        return true;
      }
      AppMethodBeat.o(214036);
      return false;
    }
    
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(214035);
      Object localObject2 = new StringBuilder("onC2CDownloadCompleted: ").append(paramString).append(", ");
      Object localObject1;
      long l1;
      label232:
      String str2;
      if (paramC2CDownloadResult != null)
      {
        localObject1 = Integer.valueOf(paramC2CDownloadResult.errorCode);
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(' ');
        localObject2 = a.DvH;
        Log.i("WxIme.WxImeDictFetcher", a.eDf().size());
        l1 = System.currentTimeMillis();
        if (paramString != null)
        {
          if (paramC2CDownloadResult == null) {
            break label1565;
          }
          localObject1 = a.DvH;
          localObject2 = (clh)a.eDf().get(paramString);
          if (paramC2CDownloadResult.errorCode != 0) {
            break label1454;
          }
          if (localObject2 == null) {
            break label1443;
          }
          Log.i("WxIme.WxImeDictFetcher", "handle: " + ((clh)localObject2).name + ' ' + ((clh)localObject2).version + ' ' + ((clh)localObject2).path + ' ' + u.buc(((clh)localObject2).path) + ' ');
          if (!u.agG(((clh)localObject2).path)) {
            break label1424;
          }
          localObject1 = u.aY(((clh)localObject2).path, 0, -1);
          paramC2CDownloadResult = a.DvH;
          paramC2CDownloadResult = ((clh)localObject2).TsJ;
          if (paramC2CDownloadResult == null) {
            break label680;
          }
          paramC2CDownloadResult = paramC2CDownloadResult.UH;
          paramC2CDownloadResult = a.k((byte[])localObject1, paramC2CDownloadResult);
          if (paramC2CDownloadResult == null) {
            break label1367;
          }
          localObject1 = a.DvH;
          str2 = a.a((clh)localObject2, "patch");
          localObject1 = u.bBT(str2);
          if (!u.agG((String)localObject1)) {
            u.bBD((String)localObject1);
          }
          u.deleteFile(str2);
          Log.i("WxIme.WxImeDictFetcher", "decrypt: oriPath:" + ((clh)localObject2).path + ", compressType:" + ((clh)localObject2).lNK + ", isPatch:" + ((clh)localObject2).isPatch);
          if (((clh)localObject2).lNK != c.DBx.value) {
            break label685;
          }
          u.bBV(str2);
          u.H(str2, paramC2CDownloadResult);
          label362:
          paramC2CDownloadResult = u.buc(str2);
          if (Util.isEqual(paramC2CDownloadResult, ((clh)localObject2).md5)) {
            break label855;
          }
          Log.e("WxIme.WxImeDictFetcher", "fail: " + str2 + " md5(" + paramC2CDownloadResult + ") no equal(" + ((clh)localObject2).md5 + ')');
          if (((clh)localObject2).lNK != c.DBx.value) {
            break label848;
          }
        }
      }
      label680:
      label685:
      label834:
      label848:
      for (paramC2CDownloadResult = m.DDU;; paramC2CDownloadResult = m.DDV)
      {
        localObject1 = k.DDb;
        k.a(paramC2CDownloadResult, (clh)localObject2);
        if (!i((clh)localObject2))
        {
          paramC2CDownloadResult = a.DvH;
          a.eDf().remove(paramString);
          paramString = a.DvH;
          a.sL(true);
        }
        for (;;)
        {
          paramString = x.aazN;
          label490:
          if (paramString == null)
          {
            Log.e("WxIme.WxImeDictFetcher", "filekey is null");
            paramString = x.aazN;
          }
          paramString = new StringBuilder("cdnCallback downloadTaskMap:");
          paramC2CDownloadResult = a.DvH;
          paramString = paramString.append(a.eDf().size()).append(", isFirst:");
          paramC2CDownloadResult = com.tencent.mm.plugin.hld.f.l.DHK;
          paramString = paramString.append(com.tencent.mm.plugin.hld.f.l.eHf()).append(", fetchFail:");
          paramC2CDownloadResult = a.DvH;
          Log.i("WxIme.WxImeDictFetcher", a.eDg() + ", internal:" + (System.currentTimeMillis() - l1));
          paramString = a.DvH;
          if (a.eDf().isEmpty())
          {
            paramString = com.tencent.mm.plugin.hld.f.l.DHK;
            if (com.tencent.mm.plugin.hld.f.l.eHf())
            {
              paramString = a.DvH;
              if (a.eDg()) {}
            }
            else
            {
              paramString = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.eHg();
              paramString = com.tencent.mm.plugin.hld.f.l.DHK;
              paramString = com.tencent.mm.plugin.hld.f.l.getKV();
              if (paramString != null) {
                paramString.putLong("ime_get_dict_list_last_time", cm.bfG());
              }
            }
            paramString = a.DvH;
            a.sL(false);
            paramString = a.DvH;
            a.eDh();
          }
          AppMethodBeat.o(214035);
          return;
          localObject1 = null;
          break;
          paramC2CDownloadResult = null;
          break label232;
          localObject1 = str2 + "_decrypt";
          u.deleteFile((String)localObject1);
          u.H((String)localObject1, paramC2CDownloadResult);
          paramC2CDownloadResult = u.buc((String)localObject1);
          if (Util.isEqual(((clh)localObject2).SoN, paramC2CDownloadResult)) {
            break label834;
          }
          Log.e("WxIme.WxImeDictFetcher", "unZlip(error): " + (String)localObject1 + " zipFileMd5:(" + paramC2CDownloadResult + ") no equal(" + ((clh)localObject2).SoN + ')');
          paramC2CDownloadResult = k.DDb;
          k.a(m.DDU, (clh)localObject2, 1);
          if (!i((clh)localObject2))
          {
            paramC2CDownloadResult = a.DvH;
            a.eDf().remove(paramString);
            paramString = a.DvH;
            a.sL(true);
          }
        }
        paramC2CDownloadResult = a.DvH;
        a.iq((String)localObject1, str2);
        break label362;
      }
      label855:
      paramC2CDownloadResult = a.DvH;
      String str1 = a.h((clh)localObject2);
      paramC2CDownloadResult = u.bBT(str1);
      if (!u.agG(paramC2CDownloadResult)) {
        u.bBD(paramC2CDownloadResult);
      }
      u.deleteFile(str1);
      int i;
      long l2;
      if (((clh)localObject2).isPatch)
      {
        paramC2CDownloadResult = a.DvH;
        clh localclh = a.g((clh)localObject2);
        i = 1;
        paramC2CDownloadResult = "";
        l2 = System.currentTimeMillis();
        if (localclh == null) {
          break label1570;
        }
        localObject1 = u.buc(localclh.path);
        kotlin.g.b.p.j(localObject1, "VFSFileOp.getFileMD5String(baseDict.path)");
        paramC2CDownloadResult = u.buc(str2);
        kotlin.g.b.p.j(paramC2CDownloadResult, "VFSFileOp.getFileMD5String(tempDictPath)");
        i = ((IBSPatchJNIService)com.tencent.mm.kernel.h.ae(IBSPatchJNIService.class)).bspatch(localclh.path, str1, str2);
      }
      for (;;)
      {
        Log.i("WxIme.WxImeDictFetcher", "bsDiff: mergeWithRetCode:" + i + ", baseMd5:" + (String)localObject1 + ", tempMd5:" + paramC2CDownloadResult + ", inter:" + (System.currentTimeMillis() - l2));
        boolean bool;
        if (i != 0)
        {
          bool = false;
          if (bool) {
            break label1211;
          }
          paramC2CDownloadResult = k.DDb;
          k.a(m.DDW, (clh)localObject2, i);
          paramC2CDownloadResult = a.DvH;
          a.eDf().remove(paramString);
          if (((clh)localObject2).TsQ == null) {
            break label1200;
          }
          paramString = ((clh)localObject2).TsQ;
          paramC2CDownloadResult = a.DvH;
          paramC2CDownloadResult = a.d(paramString);
          localObject1 = a.DvH;
          paramString.path = a.a(paramString, "download");
          paramString.ELb = 0;
          localObject1 = a.DvH;
          localObject1 = (Map)a.eDf();
          kotlin.g.b.p.j(paramString, "completionDict");
          ((Map)localObject1).put(paramC2CDownloadResult, paramString);
          localObject1 = a.DvH;
          a.b(paramString, paramC2CDownloadResult);
          break;
        }
        localObject1 = u.buc(str1);
        paramC2CDownloadResult = ((clh)localObject2).TsQ;
        if (paramC2CDownloadResult != null) {}
        for (paramC2CDownloadResult = paramC2CDownloadResult.md5;; paramC2CDownloadResult = null)
        {
          bool = Util.isEqual((String)localObject1, paramC2CDownloadResult);
          break;
        }
        label1200:
        paramString = a.DvH;
        a.sL(true);
        break;
        label1211:
        paramC2CDownloadResult = ((clh)localObject2).TsQ;
        if (paramC2CDownloadResult != null)
        {
          paramC2CDownloadResult = paramC2CDownloadResult.md5;
          label1226:
          ((clh)localObject2).md5 = paramC2CDownloadResult;
          label1232:
          ((clh)localObject2).path = str1;
          ((clh)localObject2).TsP = null;
          ((clh)localObject2).TsQ = null;
          Log.i("WxIme.WxImeDictFetcher", "success: " + str1 + ' ' + u.buc(str1) + ' ' + u.bBQ(str1));
          paramC2CDownloadResult = a.DvH;
          a.f((clh)localObject2);
          paramC2CDownloadResult = a.DvH;
          a.a((clh)localObject2);
          paramC2CDownloadResult = k.DDb;
          k.a(m.DDS, (clh)localObject2);
        }
        for (;;)
        {
          paramC2CDownloadResult = a.DvH;
          a.eDf().remove(paramString);
          break;
          paramC2CDownloadResult = null;
          break label1226;
          u.oo(str2, str1);
          u.deleteFile(str2);
          break label1232;
          label1367:
          Log.e("WxIme.WxImeDictFetcher", "output is null, reTryTime:" + ((clh)localObject2).ELb);
          paramC2CDownloadResult = k.DDb;
          k.a(m.DDU, (clh)localObject2);
          if (i((clh)localObject2)) {
            break;
          }
          paramC2CDownloadResult = a.DvH;
          a.sL(true);
          continue;
          label1424:
          Log.e("WxIme.WxImeDictFetcher", "file no exist");
          paramC2CDownloadResult = a.DvH;
          a.sL(true);
        }
        label1443:
        Log.e("WxIme.WxImeDictFetcher", "dict is null");
        break;
        label1454:
        if (paramC2CDownloadResult.errorCode <= -5103000)
        {
          localObject1 = a.DvH;
          a.eDf().remove(paramString);
          paramString = a.DvH;
          a.sL(true);
        }
        for (;;)
        {
          paramString = k.DDb;
          k.a(m.DDT, (clh)localObject2, paramC2CDownloadResult.errorCode);
          break;
          if (localObject2 != null)
          {
            Log.e("WxIme.WxImeDictFetcher", "download fail, reTryTime:" + ((clh)localObject2).ELb);
            if (!i((clh)localObject2))
            {
              paramString = a.DvH;
              a.sL(true);
            }
          }
          else
          {
            Log.e("WxIme.WxImeDictFetcher", "dict is null????");
          }
        }
        label1565:
        paramString = null;
        break label490;
        label1570:
        localObject1 = "";
      }
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f DvM;
    
    static
    {
      AppMethodBeat.i(213775);
      DvM = new f();
      AppMethodBeat.o(213775);
    }
    
    public final void run()
    {
      AppMethodBeat.i(213772);
      Object localObject1 = a.DvH;
      localObject1 = ((Map)a.eDd()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        Object localObject2 = a.DvH;
        a.b((clh)localEntry.getValue(), true);
        localObject2 = a.DvH;
        a.b((clh)localEntry.getValue(), false);
        u.deleteFile(((clh)localEntry.getValue()).path);
        localObject2 = new StringBuilder("deleteLocalDict dict:");
        com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
        Log.i("WxIme.WxImeDictFetcher", com.tencent.mm.plugin.hld.f.l.k((clh)localEntry.getValue()));
      }
      localObject1 = a.DvH;
      a.eDd().clear();
      AppMethodBeat.o(213772);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class g<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    public static final g DvN;
    
    static
    {
      AppMethodBeat.i(210757);
      DvN = new g();
      AppMethodBeat.o(210757);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/dict/WxImeDictFetcher$firstFetchCloudDictHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-hld_release"})
  public static final class h
    extends MMHandler
  {
    h(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(210299);
      kotlin.g.b.p.k(paramMessage, "msg");
      Log.d("WxIme.WxImeDictFetcher", "firstFetchCloudDictHandler");
      paramMessage = a.DvH;
      a.eCV();
      AppMethodBeat.o(210299);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class i<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    public static final i DvO;
    
    static
    {
      AppMethodBeat.i(209648);
      DvO = new i();
      AppMethodBeat.o(209648);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class j<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    public static final j DvP;
    
    static
    {
      AppMethodBeat.i(211157);
      DvP = new j();
      AppMethodBeat.o(211157);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.c.a
 * JD-Core Version:    0.7.0.1
 */