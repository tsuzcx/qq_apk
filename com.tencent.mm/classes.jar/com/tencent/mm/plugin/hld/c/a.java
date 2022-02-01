package com.tencent.mm.plugin.hld.c;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.hld.f.f;
import com.tencent.mm.plugin.hld.model.c;
import com.tencent.mm.plugin.hld.model.e;
import com.tencent.mm.plugin.hld.model.j;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.m;
import com.tencent.mm.plugin.hld.model.o;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.OutputStream;
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
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/dict/WxImeDictFetcher;", "", "()V", "DEFAULT_CIPHER_ALGORITHM", "", "DEFAULT_GCM_PARAMETER_IV", "MAX_CDN_RETRY_DOWNLOAD_TIME", "", "TAG", "cdnCallback", "com/tencent/mm/plugin/hld/dict/WxImeDictFetcher$cdnCallback$1", "Lcom/tencent/mm/plugin/hld/dict/WxImeDictFetcher$cdnCallback$1;", "currentBaseCloudDictMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "Lkotlin/collections/HashMap;", "currentCommonCloudDictMap", "currentOptionalCloudDictMap", "currentUserLocalDictMap", "Lcom/tencent/mm/protocal/protobuf/ImeLocalRawDictInfo;", "deleteDictMap", "downloadTaskHistoryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "downloadTaskMap", "fetchFail", "", "fetching", "getFetching", "()Z", "setFetching", "(Z)V", "firstFetchCloudDictHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "num", "addDownTask", "", "cloudDict", "decryptStringResource", "", "content", "password", "deleteLocalDict", "doGetImeDictCallback", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "doGetImeDictListConfigCallback", "doGetImeDictRawCallback", "downloadImp", "mediaId", "existDict", "fetchCloudDictListConfig", "getBaseDict", "", "getCommonDict", "getDictCachePath", "typeSuffix", "getDictKey", "getDictPath", "getImeDict", "recommendationType", "getImeDictRaws", "rawDictList", "", "getLocalUserDict", "getMediaId", "getOptionalDict", "getPatchBaseDict", "patchDict", "getRawDictPath", "rawDictInfo", "Lcom/tencent/mm/protocal/protobuf/ImeRawDictInfo;", "handleAttrChange", "safetyMode", "oriAttr", "reFetch", "removeDictFromCloudKV", "dict", "newCloud", "unZlib", "inputPath", "outputPath", "updateCloudDict", "newDicts", "Ljava/util/LinkedList;", "fromGetImeDict", "updateCurrentCloudDictMap", "updateCurrentLocalUserDictMap", "updateDictToCurrentKV", "IPCCgiImeGetImeDict", "IPCCgiImeGetImeDictRaw", "IPCGetImeDictListConfig", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a JoL;
  private static final MMHandler JoM;
  private static final HashMap<String, dbp> JoN;
  private static final HashMap<String, dbp> JoO;
  private static final HashMap<String, dbp> JoP;
  private static final HashMap<String, dbt> JoQ;
  private static final HashMap<String, dbp> JoR;
  private static final HashMap<String, dbp> JoS;
  private static final ArrayList<String> JoT;
  private static volatile boolean JoU;
  private static boolean JoV;
  private static final d JoW;
  private static int num;
  
  static
  {
    AppMethodBeat.i(311916);
    JoL = new a();
    JoM = (MMHandler)new e(Looper.getMainLooper());
    JoN = new HashMap();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new dbq();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject2 = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((dbq)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject1 = ((dbq)localObject1).aaHc.iterator();
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dbp)((Iterator)localObject1).next();
      s.s(localObject2, "cloudDict");
      localObject3 = f((dbp)localObject2);
      if (((dbp)localObject2).aaGX == com.tencent.mm.plugin.hld.model.l.JvM.value) {
        localHashMap.put(localObject3, localObject2);
      }
      for (;;)
      {
        Log.i("WxIme.WxImeDictFetcher", "currentCloudDictMap init " + ((dbp)localObject2).name + ' ' + ((dbp)localObject2).version + ' ' + ((dbp)localObject2).typeId);
        break;
        if (((dbp)localObject2).aaGX == com.tencent.mm.plugin.hld.model.l.JvO.value) {
          ((Map)JoN).put(localObject3, localObject2);
        }
      }
    }
    JoO = localHashMap;
    JoP = new HashMap();
    localHashMap = new HashMap();
    localObject1 = new dbw();
    localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject2 = com.tencent.mm.plugin.hld.f.l.fPk();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((dbw)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject2 = ((dbw)localObject1).aaHn.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dbt)((Iterator)localObject2).next();
      localHashMap.put(((dbt)localObject3).aaHk, localObject3);
      Log.i("WxIme.WxImeDictFetcher", "currentUserLocalDictMap init " + ((dbt)localObject3).type + ' ' + ((dbt)localObject3).aaHk);
    }
    localObject1 = ((dbw)localObject1).aaHm;
    if (localObject1 != null)
    {
      localObject1 = ((dbq)localObject1).aaHc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dbp)((Iterator)localObject1).next();
        s.s(localObject2, "cloudDict");
        localObject3 = f((dbp)localObject2);
        ((Map)JoP).put(localObject3, localObject2);
        Log.i("WxIme.WxImeDictFetcher", "currentUserLocalDictMap optionalDicts init " + ((dbp)localObject2).name + ' ' + ((dbp)localObject2).version + ' ' + ((dbp)localObject2).typeId);
      }
    }
    JoQ = localHashMap;
    JoR = new HashMap();
    JoS = new HashMap();
    JoT = new ArrayList();
    JoW = new d();
    AppMethodBeat.o(311916);
  }
  
  private static dbp a(dbp paramdbp)
  {
    AppMethodBeat.i(311662);
    dbp localdbp = null;
    int i = paramdbp.aaGX;
    if (i == com.tencent.mm.plugin.hld.model.l.JvM.value) {
      localdbp = (dbp)JoO.get(paramdbp.name);
    }
    for (;;)
    {
      AppMethodBeat.o(311662);
      return localdbp;
      if (i == com.tencent.mm.plugin.hld.model.l.JvO.value) {
        localdbp = (dbp)JoN.get(paramdbp.name);
      } else if (i == com.tencent.mm.plugin.hld.model.l.JvN.value) {
        localdbp = (dbp)JoP.get(paramdbp.name);
      }
    }
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString, esc paramesc)
  {
    AppMethodBeat.i(311599);
    Log.i("WxIme.WxImeDictFetcher", "[onCgiBack] doGetImeDictListConfigCallback errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString);
    if ((paramesc instanceof clh)) {}
    for (paramesc = (clh)paramesc; paramesc == null; paramesc = null)
    {
      paramString = null;
      if (paramString == null) {
        Log.e("WxIme.WxImeDictFetcher", "doGetImeDictListConfigCallback resp is null");
      }
      AppMethodBeat.o(311599);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramesc.BaseResponse.Idd == 0)
      {
        paramString = paramesc.aatt;
        long l1;
        HashMap localHashMap1;
        Object localObject2;
        HashMap localHashMap2;
        HashMap localHashMap3;
        label373:
        dbp localdbp;
        Object localObject1;
        if (paramString != null)
        {
          if (paramString.interval * 1000L < 43200000L)
          {
            l1 = 43200000L;
            long l2 = cn.bDx();
            paramString = com.tencent.mm.plugin.hld.f.l.JyV;
            paramString = com.tencent.mm.plugin.hld.f.l.getKV();
            if (paramString != null) {
              paramString.putLong("ime_get_dict_list_next_time", l2 + l1);
            }
            Log.i("WxIme.WxImeDictFetcher", "CgiImeGetImeDictListConfig currentTime:" + l2 + " interval:" + l1);
            paramString = ah.aiuX;
            paramString = ah.aiuX;
          }
        }
        else
        {
          paramString = com.tencent.mm.plugin.hld.f.l.JyV;
          boolean bool = com.tencent.mm.plugin.hld.f.l.fOO();
          if (!bool) {
            fKV();
          }
          Log.i("WxIme.WxImeDictFetcher", "CgiImeGetImeDictListConfig isFirstFetchRes" + bool + " status:" + paramesc.status + " size:" + paramesc.aats.size() + " rawDictList:" + paramesc.aatu);
          if (paramesc.status == com.tencent.mm.plugin.hld.model.a.Juh.value) {
            break label1297;
          }
          if (paramesc.status == com.tencent.mm.plugin.hld.model.a.Juf.value) {
            JoR.clear();
          }
          localHashMap1 = new HashMap();
          localObject2 = new dbr();
          localHashMap2 = new HashMap();
          localHashMap3 = new HashMap();
          Iterator localIterator = paramesc.aats.iterator();
          dbm localdbm;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            paramString = (dbl)localIterator.next();
            Log.i("WxIme.WxImeDictFetcher", "dictBaseInfo " + paramString.name + ' ' + paramString.version + ' ' + paramString.typeId + ' ' + paramString.aaGW);
            localdbm = paramString.aaGS;
          } while (localdbm == null);
          Log.i("WxIme.WxImeDictFetcher", "dictBaseInfo " + localdbm.aaGX + ' ' + localdbm.KPQ + ' ');
          if (localdbm.KPQ != e.JuF.value)
          {
            localdbp = new dbp();
            localObject1 = paramString.aaGS;
            if (localObject1 != null)
            {
              localdbp.aaGX = ((dbm)localObject1).aaGX;
              localdbp.dataType = ((dbm)localObject1).dataType;
              localdbp.KPQ = ((dbm)localObject1).KPQ;
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
            }
            localdbp.name = paramString.name;
            localdbp.version = paramString.version;
            localdbp.typeId = paramString.typeId;
            localdbp.aaGT = paramString.aaGT;
            localdbp.mOI = paramString.mOI;
            localdbp.aaGU = paramString.aaGU;
            localdbp.md5 = paramString.md5;
            localdbp.aaGZ = paramString.aaGW;
            localObject1 = paramString.aaGV;
            if (localObject1 != null) {
              break label886;
            }
            paramInt1 = 0;
            label671:
            localdbp.oGu = paramInt1;
            paramString = paramString.aaGV;
            if (paramString != null) {
              break label895;
            }
            paramString = "";
            label690:
            localdbp.Znz = paramString;
            paramString = ah.aiuX;
            if (localdbp.aaGZ != 0) {
              break label944;
            }
            paramString = (Map)localHashMap2;
            localObject1 = localdbp.name;
            s.s(localObject1, "cloudDict.name");
            paramString.put(localObject1, localdbp);
            ((dbr)localObject2).aaHd.add(localdbp);
            if (localdbm.aaGX == com.tencent.mm.plugin.hld.model.l.JvM.value) {
              ((Map)localHashMap1).put(f(localdbp), localdbp);
            }
            if (localHashMap3.containsKey(localdbp.name))
            {
              paramString = (dbp)localHashMap3.get(localdbp.name);
              if (paramString != null) {
                break label916;
              }
              paramString = null;
              label816:
              if (paramString == null) {
                Log.e("WxIme.WxImeDictFetcher", "no find patch res(" + localdbp.name + "), patch version(" + localdbp.version);
              }
            }
          }
        }
        label916:
        label1059:
        for (;;)
        {
          paramString = ah.aiuX;
          paramString = ah.aiuX;
          break label373;
          l1 = paramString.interval * 1000L;
          break;
          label886:
          paramInt1 = ((afe)localObject1).Zny;
          break label671;
          label895:
          localObject1 = paramString.Znz;
          paramString = (String)localObject1;
          if (localObject1 != null) {
            break label690;
          }
          paramString = "";
          break label690;
          localHashMap2.remove(localdbp.name);
          localdbp.aaHa = paramString;
          paramString = ah.aiuX;
          paramString = ah.aiuX;
          break label816;
          label944:
          if (localHashMap2.containsKey(localdbp.name))
          {
            paramString = (dbp)localHashMap2.get(localdbp.name);
            if (paramString == null) {}
            for (paramString = null;; paramString = ah.aiuX)
            {
              if (paramString != null) {
                break label1059;
              }
              Log.e("WxIme.WxImeDictFetcher", "no find base res(" + localdbp.name + "), patch version(" + localdbp.version + ", " + localdbp.aaGZ + ')');
              break;
              paramString.aaHa = localdbp;
              paramString = ah.aiuX;
            }
          }
          else
          {
            paramString = (Map)localHashMap3;
            localObject1 = localdbp.name;
            s.s(localObject1, "cloudDict.name");
            paramString.put(localObject1, localdbp);
          }
        }
        paramString = ((dbr)localObject2).aaHd;
        s.s(paramString, "downloadDictList.localDicts");
        e(paramString, false);
        if (paramesc.status == com.tencent.mm.plugin.hld.model.a.Juf.value)
        {
          paramString = ((Map)JoO).entrySet().iterator();
          while (paramString.hasNext())
          {
            localObject1 = (Map.Entry)paramString.next();
            localObject2 = f((dbp)((Map.Entry)localObject1).getValue());
            if (!localHashMap1.containsKey(localObject2))
            {
              ((Map)JoR).put(localObject2, ((Map.Entry)localObject1).getValue());
              Log.i("WxIme.WxImeDictFetcher", s.X("delet dict:", localObject2));
            }
          }
          Log.i("WxIme.WxImeDictFetcher", s.X("delete dict size:", Integer.valueOf(JoR.size())));
        }
        paramString = paramesc.aatu;
        s.s(paramString, "dictListConfigResp.rawDictList");
        if (!((Collection)paramString).isEmpty())
        {
          paramInt1 = 1;
          label1274:
          if (paramInt1 != 0)
          {
            paramString = paramesc.aatu;
            s.s(paramString, "dictListConfigResp.rawDictList");
            iz((List)paramString);
          }
        }
      }
    }
    for (;;)
    {
      label1297:
      paramString = ah.aiuX;
      paramString = ah.aiuX;
      break;
      paramInt1 = 0;
      break label1274;
      Log.w("WxIme.WxImeDictFetcher", "CgiImeGetImeDictListConfig BaseResponse.Ret:" + paramesc.BaseResponse.Idd + ' ' + paramesc.BaseResponse.akjO);
      fKV();
    }
  }
  
  private static void a(dbp paramdbp, String paramString)
  {
    AppMethodBeat.i(311654);
    com.tencent.mm.plugin.cdndownloader.c.a.dpY().bHX();
    int i = com.tencent.mm.modelcdntran.d.a(paramString, paramdbp.mOI, paramdbp.path, (CdnLogic.DownloadCallback)JoW);
    Log.i("WxIme.WxImeDictFetcher", "fetch: start " + paramdbp.name + ' ' + paramdbp.md5 + ' ' + paramdbp.path + ' ' + paramString + ' ' + i);
    AppMethodBeat.o(311654);
  }
  
  private static void a(dbp paramdbp, boolean paramBoolean)
  {
    AppMethodBeat.i(311721);
    String str = f(paramdbp);
    paramdbp = com.tencent.mm.plugin.hld.f.l.JyV;
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.hld.f.l.getKV();
    dbq localdbq;
    Object localObject;
    if (localMultiProcessMMKV != null)
    {
      localdbq = new dbq();
      if (!paramBoolean) {
        break label139;
      }
      paramdbp = "key_new_cloud_dicts";
      localObject = localMultiProcessMMKV.decodeBytes(paramdbp);
      if (localObject != null) {
        localdbq.parseFrom((byte[])localObject);
      }
      Iterator localIterator = localdbq.aaHc.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (dbp)localIterator.next();
        s.s(localObject, "cloudDict");
      } while (!Util.isEqual(f((dbp)localObject), str));
    }
    for (;;)
    {
      if (localObject != null) {
        localdbq.aaHc.remove(localObject);
      }
      localMultiProcessMMKV.encode(paramdbp, localdbq.toByteArray());
      AppMethodBeat.o(311721);
      return;
      label139:
      paramdbp = "key_current_cloud_dicts";
      break;
      localObject = null;
    }
  }
  
  private static final void aB(Bundle paramBundle)
  {
    AppMethodBeat.i(311799);
    int i = paramBundle.getInt("errType");
    int j = paramBundle.getInt("errCode");
    String str = paramBundle.getString("errMsg");
    Object localObject = clh.class.newInstance();
    if (localObject == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ResponseProtoBuf");
      AppMethodBeat.o(311799);
      throw paramBundle;
    }
    localObject = (esc)localObject;
    ((esc)localObject).parseFrom(paramBundle.getByteArray("resp"));
    a(i, j, str, (esc)localObject);
    AppMethodBeat.o(311799);
  }
  
  private static final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(311812);
    int i = paramBundle.getInt("errType");
    int j = paramBundle.getInt("errCode");
    Object localObject1 = paramBundle.getString("errMsg");
    Object localObject2 = cll.class.newInstance();
    ((cll)localObject2).parseFrom(paramBundle.getByteArray("resp"));
    paramBundle = (esc)localObject2;
    Log.i("WxIme.WxImeDictFetcher", "[onCgiBack] doGetImeDictCallback errType=" + i + " errCode=" + j + " errMsg=" + localObject1);
    if ((paramBundle instanceof cll)) {}
    for (paramBundle = (cll)paramBundle; paramBundle == null; paramBundle = null)
    {
      paramBundle = null;
      if (paramBundle == null) {
        Log.e("WxIme.WxImeDictFetcher", "doGetImeDictCallback resp is null");
      }
      AppMethodBeat.o(311812);
      return;
    }
    if ((i == 0) && (j == 0)) {
      if (paramBundle.BaseResponse.Idd == 0)
      {
        localObject2 = new LinkedList();
        Log.i("WxIme.WxImeDictFetcher", s.X("doGetImeDictCallback size:", Integer.valueOf(paramBundle.aatA.size())));
        Iterator localIterator = paramBundle.aatA.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (dbl)localIterator.next();
          Log.i("WxIme.WxImeDictFetcher", "doGetImeDictCallback " + ((dbl)localObject1).name + ' ' + ((dbl)localObject1).version + ' ' + ((dbl)localObject1).typeId + ' ');
          paramBundle = ((dbl)localObject1).aaGS;
          if (paramBundle != null)
          {
            Log.i("WxIme.WxImeDictFetcher", "dictBaseInfo " + paramBundle.aaGX + ' ' + paramBundle.KPQ + ' ');
            if (paramBundle.KPQ != e.JuF.value)
            {
              dbp localdbp = new dbp();
              paramBundle = ((dbl)localObject1).aaGS;
              if (paramBundle != null)
              {
                localdbp.aaGX = paramBundle.aaGX;
                localdbp.dataType = paramBundle.dataType;
                localdbp.KPQ = paramBundle.KPQ;
              }
              localdbp.name = ((dbl)localObject1).name;
              localdbp.version = ((dbl)localObject1).version;
              localdbp.typeId = ((dbl)localObject1).typeId;
              localdbp.aaGT = ((dbl)localObject1).aaGT;
              localdbp.mOI = ((dbl)localObject1).mOI;
              localdbp.aaGU = ((dbl)localObject1).aaGU;
              localdbp.md5 = ((dbl)localObject1).md5;
              localdbp.aaGZ = ((dbl)localObject1).aaGW;
              paramBundle = ((dbl)localObject1).aaGV;
              if (paramBundle == null)
              {
                paramBundle = null;
                label476:
                if (paramBundle != null) {
                  break label534;
                }
                i = c.Juw.value;
                label487:
                localdbp.oGu = i;
                paramBundle = ((dbl)localObject1).aaGV;
                if (paramBundle != null) {
                  break label542;
                }
                paramBundle = "";
              }
              for (;;)
              {
                localdbp.Znz = paramBundle;
                ((LinkedList)localObject2).add(localdbp);
                break;
                paramBundle = Integer.valueOf(paramBundle.Zny);
                break label476;
                label534:
                i = paramBundle.intValue();
                break label487;
                label542:
                localObject1 = paramBundle.Znz;
                paramBundle = (Bundle)localObject1;
                if (localObject1 == null) {
                  paramBundle = "";
                }
              }
            }
          }
        }
        e((LinkedList)localObject2, true);
      }
    }
    for (;;)
    {
      paramBundle = ah.aiuX;
      break;
      Log.w("WxIme.WxImeDictFetcher", "getImeDicts BaseResponse.Ret:" + paramBundle.BaseResponse.Idd + ' ' + paramBundle.BaseResponse.akjO);
      fKV();
    }
  }
  
  private static final void aD(Bundle paramBundle)
  {
    dbw localdbw = null;
    AppMethodBeat.i(311825);
    int i = paramBundle.getInt("errType");
    int j = paramBundle.getInt("errCode");
    Object localObject1 = paramBundle.getString("errMsg");
    Object localObject2 = clj.class.newInstance();
    ((clj)localObject2).parseFrom(paramBundle.getByteArray("resp"));
    paramBundle = (esc)localObject2;
    Log.i("WxIme.WxImeDictFetcher", "[onCgiBack] doGetImeDictRawCallback errType=" + i + " errCode=" + j + " errMsg=" + localObject1);
    if ((paramBundle instanceof clj))
    {
      localObject1 = (clj)paramBundle;
      if (localObject1 != null) {
        break label153;
      }
      paramBundle = localdbw;
    }
    for (;;)
    {
      if (paramBundle == null) {
        Log.e("WxIme.WxImeDictFetcher", "doGetImeDictCallback resp is null");
      }
      AppMethodBeat.o(311825);
      return;
      localObject1 = null;
      break;
      label153:
      if ((i == 0) && (j == 0))
      {
        if (((clj)localObject1).BaseResponse.Idd == 0)
        {
          new LinkedList();
          localObject2 = new StringBuilder("doGetImeDictRawCallback type:");
          paramBundle = ((clj)localObject1).aatv;
          if (paramBundle == null)
          {
            paramBundle = null;
            label202:
            localObject2 = ((StringBuilder)localObject2).append(paramBundle).append(" id:");
            paramBundle = ((clj)localObject1).aatv;
            if (paramBundle != null) {
              break label531;
            }
          }
          for (paramBundle = null;; paramBundle = paramBundle.aaHk)
          {
            Log.i("WxIme.WxImeDictFetcher", paramBundle);
            localObject2 = ((clj)localObject1).aatv;
            paramBundle = localdbw;
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((clj)localObject1).aatw;
            paramBundle = localdbw;
            if (localObject1 == null) {
              break;
            }
            if (((com.tencent.mm.bx.b)localObject1).Op.length > 0)
            {
              paramBundle = f.Jyn;
              paramBundle = s.X(f.fOh(), "/raw");
              if (!y.ZC(paramBundle)) {
                y.bDX(paramBundle);
              }
              paramBundle = paramBundle + '/' + ((dby)localObject2).type + '_' + ((dby)localObject2).aaHk;
              localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray();
              i = y.f(paramBundle, (byte[])localObject1, localObject1.length);
              if (i == 0)
              {
                localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
                localObject1 = com.tencent.mm.plugin.hld.f.l.fPk();
                if (localObject1 != null)
                {
                  localdbw = new dbw();
                  Object localObject3 = ((MultiProcessMMKV)localObject1).decodeBytes("key_current_cloud_dicts");
                  if (localObject3 != null) {
                    localdbw.parseFrom((byte[])localObject3);
                  }
                  localdbw.aaHn.clear();
                  localObject3 = localdbw.aaHn;
                  dbt localdbt = new dbt();
                  localdbt.type = ((dby)localObject2).type;
                  localdbt.aaHk = ((dby)localObject2).aaHk;
                  localdbt.path = paramBundle;
                  localObject2 = ah.aiuX;
                  ((LinkedList)localObject3).add(localdbt);
                  ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", localdbw.toByteArray());
                  fKZ();
                }
              }
              Log.i("WxIme.WxImeDictFetcher", "doGetImeDictRawCallback write " + paramBundle + ", result:" + i);
            }
            paramBundle = ah.aiuX;
            break;
            paramBundle = Integer.valueOf(paramBundle.type);
            break label202;
          }
        }
        Log.w("WxIme.WxImeDictFetcher", "getImeDicts BaseResponse.Ret:" + ((clj)localObject1).BaseResponse.Idd + ' ' + ((clj)localObject1).BaseResponse.akjO);
      }
      label531:
      fKV();
      paramBundle = ah.aiuX;
    }
  }
  
  private static final void aE(Bundle paramBundle)
  {
    AppMethodBeat.i(311832);
    com.tencent.threadpool.h.ahAA.g(new a..ExternalSyntheticLambda3(paramBundle), "WxIme.WxImeDictFetchergetImeDictRaws");
    AppMethodBeat.o(311832);
  }
  
  private static String b(dbp paramdbp)
  {
    AppMethodBeat.i(311667);
    if (paramdbp == null)
    {
      AppMethodBeat.o(311667);
      return "";
    }
    String str = "";
    int i = paramdbp.aaGZ;
    if (i != 0) {
      str = s.X("_", Integer.valueOf(i));
    }
    paramdbp = paramdbp.name + '_' + paramdbp.version + str;
    AppMethodBeat.o(311667);
    return paramdbp;
  }
  
  private static String b(dbp paramdbp, String paramString)
  {
    AppMethodBeat.i(311675);
    if (paramdbp == null)
    {
      AppMethodBeat.o(311675);
      return "";
    }
    Object localObject = "";
    int i = paramdbp.aaGZ;
    if (i != 0) {
      localObject = s.X("_", Integer.valueOf(i));
    }
    paramString = (String)localObject + '_' + paramString;
    localObject = new StringBuilder();
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.JyV;
    paramdbp = com.tencent.mm.plugin.hld.f.l.fOE() + '/' + paramdbp.name + '/' + paramdbp.version + paramString;
    AppMethodBeat.o(311675);
    return paramdbp;
  }
  
  private static void c(dbp paramdbp)
  {
    int i = 1;
    AppMethodBeat.i(311708);
    String str = f(paramdbp);
    int j = paramdbp.aaGX;
    Object localObject1;
    MultiProcessMMKV localMultiProcessMMKV;
    Object localObject2;
    Object localObject3;
    if (j == com.tencent.mm.plugin.hld.model.l.JvM.value)
    {
      if (i == 0) {
        break label229;
      }
      localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
      localMultiProcessMMKV = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localMultiProcessMMKV == null) {
        break label432;
      }
      localObject2 = new dbq();
      localObject1 = localMultiProcessMMKV.decodeBytes("key_current_cloud_dicts");
      if (localObject1 != null) {
        ((dbq)localObject2).parseFrom((byte[])localObject1);
      }
      localObject3 = ((dbq)localObject2).aaHc.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (dbp)((Iterator)localObject3).next();
        s.s(localObject1, "cloudDict");
      } while (!Util.isEqual(f((dbp)localObject1), str));
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((dbq)localObject2).aaHc.remove(localObject1);
      }
      ((dbq)localObject2).aaHc.add(paramdbp);
      if (paramdbp.aaGX == com.tencent.mm.plugin.hld.model.l.JvM.value) {
        ((Map)JoO).put(str, paramdbp);
      }
      for (;;)
      {
        localMultiProcessMMKV.encode("key_current_cloud_dicts", ((dbq)localObject2).toByteArray());
        AppMethodBeat.o(311708);
        return;
        if (j == com.tencent.mm.plugin.hld.model.l.JvO.value) {
          break;
        }
        i = 0;
        break;
        ((Map)JoN).put(str, paramdbp);
      }
      label229:
      if (j == com.tencent.mm.plugin.hld.model.l.JvN.value)
      {
        localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
        localMultiProcessMMKV = com.tencent.mm.plugin.hld.f.l.fPk();
        if (localMultiProcessMMKV != null)
        {
          localObject2 = new dbw();
          localObject1 = localMultiProcessMMKV.decodeBytes("key_current_cloud_dicts");
          if (localObject1 != null) {
            ((dbw)localObject2).parseFrom((byte[])localObject1);
          }
          if (((dbw)localObject2).aaHm == null) {
            ((dbw)localObject2).aaHm = new dbq();
          }
          localObject1 = ((dbw)localObject2).aaHm;
          if (localObject1 == null) {
            break label439;
          }
          localObject3 = ((dbq)localObject1).aaHc.iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (dbp)((Iterator)localObject3).next();
            s.s(localObject1, "cloudDict");
          } while (!Util.isEqual(f((dbp)localObject1), str));
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject3 = ((dbw)localObject2).aaHm;
          if (localObject3 != null) {
            ((dbq)localObject3).aaHc.remove(localObject1);
          }
        }
        localObject1 = ((dbw)localObject2).aaHm;
        if (localObject1 != null) {
          ((dbq)localObject1).aaHc.add(paramdbp);
        }
        ((Map)JoP).put(str, paramdbp);
        localMultiProcessMMKV.encode("key_current_cloud_dicts", ((dbw)localObject2).toByteArray());
        label432:
        AppMethodBeat.o(311708);
        return;
        label439:
        localObject1 = null;
      }
      localObject1 = null;
    }
  }
  
  private static String e(dbp paramdbp)
  {
    AppMethodBeat.i(311743);
    if (paramdbp == null)
    {
      AppMethodBeat.o(311743);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    f localf = f.Jyn;
    paramdbp = f.fOh() + '/' + paramdbp.name + '/' + paramdbp.version;
    AppMethodBeat.o(311743);
    return paramdbp;
  }
  
  private static void e(LinkedList<dbp> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(311646);
    if (paramLinkedList.isEmpty())
    {
      Log.w("WxIme.WxImeDictFetcher", s.X("updateCloudDict newDicts is empty, fromGetImeDict:", Boolean.valueOf(paramBoolean)));
      if (!paramBoolean)
      {
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.JyV;
        com.tencent.mm.plugin.hld.f.l.fOP();
        fKV();
        AppMethodBeat.o(311646);
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
      label201:
      Object localObject5;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (dbp)((Iterator)localObject2).next();
        s.s(localObject3, "localCloudDict");
        localObject4 = f((dbp)localObject3);
        i = -1;
        int j;
        boolean bool;
        StringBuilder localStringBuilder1;
        if (JoO.containsKey(localObject4))
        {
          paramLinkedList = (dbp)JoO.get(localObject4);
          if (paramLinkedList == null) {
            break label871;
          }
          if (y.ZC(paramLinkedList.path))
          {
            j = paramLinkedList.version;
            i = j;
            if (paramLinkedList.version >= ((dbp)localObject3).version)
            {
              bool = false;
              i = j;
              localObject5 = new StringBuilder();
              localStringBuilder1 = ((StringBuilder)localObject5).append("dict ").append(((dbp)localObject3).aaGX).append(' ').append(((dbp)localObject3).dataType).append(' ').append(((dbp)localObject3).KPQ).append(' ').append(((dbp)localObject3).name).append(' ').append(((dbp)localObject3).version).append(' ').append(((dbp)localObject3).typeId).append(' ');
              paramLinkedList = ((dbp)localObject3).aaGT;
              if (paramLinkedList != null) {
                break label879;
              }
              paramLinkedList = null;
              label310:
              localStringBuilder1 = localStringBuilder1.append(paramLinkedList).append(' ').append(((dbp)localObject3).mOI).append(' ').append(((dbp)localObject3).md5).append(' ');
              paramLinkedList = ((dbp)localObject3).aaGU;
              if (paramLinkedList != null) {
                break label891;
              }
              paramLinkedList = null;
              label361:
              localStringBuilder1 = localStringBuilder1.append(paramLinkedList).append(' ');
              paramLinkedList = ((dbp)localObject3).aaGY;
              if (paramLinkedList != null) {
                break label903;
              }
              paramLinkedList = null;
              label386:
              localStringBuilder1.append(paramLinkedList).append(' ');
              ((StringBuilder)localObject5).append(((dbp)localObject3).path).append(" currentVersion:").append(i).append(" needUpdate:").append(bool);
              Log.i("WxIme.WxImeDictFetcher", ((StringBuilder)localObject5).toString());
              localObject5 = ((dbp)localObject3).aaHa;
              if (localObject5 != null)
              {
                localStringBuilder1 = new StringBuilder();
                StringBuilder localStringBuilder2 = localStringBuilder1.append("dict(patch) ").append(((dbp)localObject5).aaGX).append(' ').append(((dbp)localObject5).dataType).append(' ').append(((dbp)localObject5).KPQ).append(' ').append(((dbp)localObject5).name).append(' ').append(((dbp)localObject5).version).append(' ').append(((dbp)localObject5).aaGZ).append(' ').append(((dbp)localObject5).typeId).append(' ');
                paramLinkedList = ((dbp)localObject5).aaGT;
                if (paramLinkedList != null) {
                  break label915;
                }
                paramLinkedList = null;
                label575:
                localStringBuilder2 = localStringBuilder2.append(paramLinkedList).append(' ').append(((dbp)localObject5).mOI).append(' ').append(((dbp)localObject5).md5).append(' ');
                paramLinkedList = ((dbp)localObject5).aaGU;
                if (paramLinkedList != null) {
                  break label927;
                }
                paramLinkedList = null;
                label626:
                localStringBuilder2.append(paramLinkedList).append(' ');
                paramLinkedList = ((dbp)localObject5).aaGY;
                if (paramLinkedList != null) {
                  break label939;
                }
              }
            }
          }
        }
        label903:
        label915:
        label927:
        label939:
        for (paramLinkedList = null;; paramLinkedList = Integer.valueOf(paramLinkedList.Op.length))
        {
          localStringBuilder1.append(paramLinkedList).append(' ').append(((dbp)localObject5).path).append(" currentVersion:").append(i).append(" needUpdate:").append(bool);
          Log.i("WxIme.WxImeDictFetcher", localStringBuilder1.toString());
          if (!bool) {
            break;
          }
          ((Map)localObject1).put(localObject4, localObject3);
          break;
          bool = true;
          break label201;
          if (JoP.containsKey(localObject4))
          {
            paramLinkedList = (dbp)JoP.get(localObject4);
            if (paramLinkedList == null) {
              break label871;
            }
            if (y.ZC(paramLinkedList.path))
            {
              j = paramLinkedList.version;
              i = j;
              if (paramLinkedList.version >= ((dbp)localObject3).version)
              {
                bool = false;
                i = j;
                break label201;
              }
            }
            bool = true;
            break label201;
          }
          if (JoN.containsKey(localObject4))
          {
            paramLinkedList = (dbp)JoN.get(localObject4);
            if (paramLinkedList != null)
            {
              if (y.ZC(paramLinkedList.path))
              {
                j = paramLinkedList.version;
                i = j;
                if (paramLinkedList.version >= ((dbp)localObject3).version)
                {
                  bool = false;
                  i = j;
                  break label201;
                }
              }
              bool = true;
              break label201;
            }
          }
          label871:
          bool = true;
          i = -1;
          break label201;
          label879:
          paramLinkedList = Integer.valueOf(paramLinkedList.Op.length);
          break label310;
          label891:
          paramLinkedList = Integer.valueOf(paramLinkedList.Op.length);
          break label361;
          paramLinkedList = Integer.valueOf(paramLinkedList.Op.length);
          break label386;
          paramLinkedList = Integer.valueOf(paramLinkedList.Op.length);
          break label575;
          paramLinkedList = Integer.valueOf(paramLinkedList.Op.length);
          break label626;
        }
      }
      Log.i("WxIme.WxImeDictFetcher", s.X("updateCloudDict cloudDictMap:", Integer.valueOf(((HashMap)localObject1).size())));
      if (!((Map)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.JyV;
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.getKV();
        if (paramLinkedList == null) {
          break label1403;
        }
        localObject2 = new dbq();
        localObject3 = paramLinkedList.decodeBytes("key_new_cloud_dicts");
        if (localObject3 != null) {
          ((dbq)localObject2).parseFrom((byte[])localObject3);
        }
        localObject3 = ((dbq)localObject2).aaHc.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (dbp)((Iterator)localObject3).next();
            s.s(localObject4, "cloudDict");
            localObject5 = (dbp)((HashMap)localObject1).get(f((dbp)localObject4));
            if (localObject5 != null)
            {
              ((dbp)localObject4).aaGX = ((dbp)localObject5).aaGX;
              ((dbp)localObject4).dataType = ((dbp)localObject5).dataType;
              ((dbp)localObject4).KPQ = ((dbp)localObject5).KPQ;
              ((dbp)localObject4).name = ((dbp)localObject5).name;
              ((dbp)localObject4).version = ((dbp)localObject5).version;
              ((dbp)localObject4).typeId = ((dbp)localObject5).typeId;
              ((dbp)localObject4).aaGT = ((dbp)localObject5).aaGT;
              ((dbp)localObject4).mOI = ((dbp)localObject5).mOI;
              ((dbp)localObject4).aaGU = ((dbp)localObject5).aaGU;
              ((dbp)localObject4).md5 = ((dbp)localObject5).md5;
              ((dbp)localObject4).aaGY = ((dbp)localObject5).aaGY;
              ((dbp)localObject4).oGu = ((dbp)localObject5).oGu;
              ((dbp)localObject4).Znz = ((dbp)localObject5).Znz;
              ((dbp)localObject4).aaGZ = ((dbp)localObject5).aaGZ;
              ((dbp)localObject4).aaHa = ((dbp)localObject5).aaHa;
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
          ((dbq)localObject2).aaHc.add(((HashMap)localObject1).get(localObject4));
        }
        paramLinkedList.encode("key_new_cloud_dicts", ((dbq)localObject2).toByteArray());
        JoS.clear();
        paramLinkedList = ((dbq)localObject2).aaHc.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject1 = (dbp)paramLinkedList.next();
          s.s(localObject1, "cloudDict");
          com.tencent.threadpool.h.ahAA.g(new a..ExternalSyntheticLambda4((dbp)localObject1), "WxIme.WxImeDictFetcheraddDownTask");
        }
        AppMethodBeat.o(311646);
        return;
      }
      if (!paramBoolean)
      {
        paramLinkedList = com.tencent.mm.plugin.hld.f.l.JyV;
        com.tencent.mm.plugin.hld.f.l.fOP();
        fKV();
      }
    }
    label1403:
    AppMethodBeat.o(311646);
  }
  
  public static String f(dbp paramdbp)
  {
    AppMethodBeat.i(311779);
    s.u(paramdbp, "cloudDict");
    paramdbp = String.valueOf(paramdbp.name);
    AppMethodBeat.o(311779);
    return paramdbp;
  }
  
  public static boolean fKU()
  {
    return JoV;
  }
  
  private static void fKV()
  {
    AppMethodBeat.i(311533);
    Object localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    long l1;
    if (com.tencent.mm.plugin.hld.f.l.fOO())
    {
      if (num > 6)
      {
        AppMethodBeat.o(311533);
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
        JoM.removeMessages(0);
        JoM.sendEmptyMessageDelayed(0, l1);
        Log.i("WxIme.WxImeDictFetcher", "reFetch " + num + ' ' + l1);
        AppMethodBeat.o(311533);
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
    JoM.removeMessages(0);
    localObject = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject = com.tencent.mm.plugin.hld.f.l.getKV();
    long l2;
    if (localObject == null)
    {
      l2 = 0L;
      if (l2 != 0L) {
        break label267;
      }
      l1 = 43200000L;
    }
    for (;;)
    {
      JoM.sendEmptyMessageDelayed(0, l1);
      Log.i("WxIme.WxImeDictFetcher", "reFetch " + l2 + ' ' + l1);
      AppMethodBeat.o(311533);
      return;
      l2 = ((MultiProcessMMKV)localObject).getLong("ime_get_dict_list_next_time", 0L);
      break;
      label267:
      if (l2 < cn.bDx()) {
        l1 = 10800000L;
      } else {
        l1 = l2 - cn.bDx();
      }
    }
  }
  
  public static void fKW()
  {
    AppMethodBeat.i(311542);
    Object localObject1 = o.Jwm;
    if (o.fNe())
    {
      AppMethodBeat.o(311542);
      return;
    }
    localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
    if (!com.tencent.mm.plugin.hld.f.l.fOO())
    {
      long l2 = cn.bDx();
      localObject1 = com.tencent.mm.plugin.hld.f.l.JyV;
      localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
      if (localObject1 == null) {}
      for (long l1 = 0L; (l1 != 0L) && (l2 < l1); l1 = ((MultiProcessMMKV)localObject1).getLong("ime_get_dict_list_next_time", 0L))
      {
        fKV();
        AppMethodBeat.o(311542);
        return;
      }
      Log.i("WxIme.WxImeDictFetcher", "fetchCloudDictListConfig currentTime:" + l2 + " nextTime:" + l1);
    }
    JoV = true;
    Object localObject4 = fLa();
    Object localObject3 = fLb();
    Object localObject2 = fLc();
    localObject1 = new dbo();
    localObject4 = ((Collection)localObject4).iterator();
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject7 = (dbp)((Iterator)localObject4).next();
      localObject5 = ((dbo)localObject1).aatr;
      localObject6 = new ade();
      ((ade)localObject6).name = ((dbp)localObject7).name;
      ((ade)localObject6).version = ((dbp)localObject7).version;
      localObject7 = ah.aiuX;
      ((LinkedList)localObject5).add(localObject6);
    }
    localObject3 = ((Collection)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject6 = (dbp)((Iterator)localObject3).next();
      localObject4 = ((dbo)localObject1).aatr;
      localObject5 = new ade();
      ((ade)localObject5).name = ((dbp)localObject6).name;
      ((ade)localObject5).version = ((dbp)localObject6).version;
      localObject6 = ah.aiuX;
      ((LinkedList)localObject4).add(localObject5);
    }
    localObject2 = ((Collection)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject5 = (dbp)((Iterator)localObject2).next();
      localObject3 = ((dbo)localObject1).aatr;
      localObject4 = new ade();
      ((ade)localObject4).name = ((dbp)localObject5).name;
      ((ade)localObject4).version = ((dbp)localObject5).version;
      localObject5 = ah.aiuX;
      ((LinkedList)localObject3).add(localObject4);
    }
    Log.i("WxIme.WxImeDictFetcher", "initializeCloudDict " + JoO.size() + ' ' + JoP.size() + ' ' + JoN.size() + ' ' + JoQ.size() + ' ' + Util.getStack());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putByteArray("dictList", ((dbo)localObject1).toByteArray());
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject2, a.c.class, a..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(311542);
  }
  
  public static void fKX()
  {
    AppMethodBeat.i(311568);
    Log.i("WxIme.WxImeDictFetcher", "deleteLocalDict deleteSize:" + JoR.size() + " downloadSize:" + JoS.size());
    if ((JoS.size() == 0) && (JoR.size() != 0)) {
      com.tencent.threadpool.h.ahAA.g(a..ExternalSyntheticLambda5.INSTANCE, "WxIme.WxImeDictFetcherdeleteDictMap");
    }
    AppMethodBeat.o(311568);
  }
  
  public static void fKY()
  {
    AppMethodBeat.i(311611);
    Log.i("WxIme.WxImeDictFetcher", "updateCurrentCloudDictMap");
    JoO.clear();
    JoN.clear();
    Object localObject1 = new dbq();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject2 = com.tencent.mm.plugin.hld.f.l.getKV();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((dbq)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject1 = ((dbq)localObject1).aaHc.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dbp)((Iterator)localObject1).next();
      s.s(localObject2, "cloudDict");
      String str = f((dbp)localObject2);
      if (((dbp)localObject2).aaGX == com.tencent.mm.plugin.hld.model.l.JvM.value) {
        JoO.put(str, localObject2);
      }
      for (;;)
      {
        Log.i("WxIme.WxImeDictFetcher", "currentCloudDictMap init " + ((dbp)localObject2).name + ' ' + ((dbp)localObject2).version + ' ' + ((dbp)localObject2).typeId + ' ' + ((dbp)localObject2).aaGX);
        break;
        if (((dbp)localObject2).aaGX == com.tencent.mm.plugin.hld.model.l.JvO.value) {
          ((Map)JoN).put(str, localObject2);
        }
      }
    }
    AppMethodBeat.o(311611);
  }
  
  public static void fKZ()
  {
    AppMethodBeat.i(311621);
    Log.i("WxIme.WxImeDictFetcher", "updateCurrentCloudDictMap");
    JoQ.clear();
    JoP.clear();
    Object localObject1 = new dbw();
    Object localObject2 = com.tencent.mm.plugin.hld.f.l.JyV;
    localObject2 = com.tencent.mm.plugin.hld.f.l.fPk();
    if (localObject2 != null)
    {
      localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes("key_current_cloud_dicts");
      if (localObject2 != null) {
        ((dbw)localObject1).parseFrom((byte[])localObject2);
      }
    }
    localObject2 = ((dbw)localObject1).aaHn.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dbt)((Iterator)localObject2).next();
      JoQ.put(((dbt)localObject3).aaHk, localObject3);
      Log.i("WxIme.WxImeDictFetcher", "currentUserCloudDictMap init " + ((dbt)localObject3).type + ' ' + ((dbt)localObject3).aaHk);
    }
    localObject1 = ((dbw)localObject1).aaHm;
    if (localObject1 != null)
    {
      localObject1 = ((dbq)localObject1).aaHc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dbp)((Iterator)localObject1).next();
        s.s(localObject2, "cloudDict");
        localObject3 = f((dbp)localObject2);
        ((Map)JoP).put(localObject3, localObject2);
        Log.i("WxIme.WxImeDictFetcher", "currentUserLocalDictMap optionalDicts init " + ((dbp)localObject2).name + ' ' + ((dbp)localObject2).version + ' ' + ((dbp)localObject2).typeId);
      }
    }
    AppMethodBeat.o(311621);
  }
  
  public static Collection<dbp> fLa()
  {
    AppMethodBeat.i(311751);
    Collection localCollection = (Collection)new ArrayList(JoO.values());
    AppMethodBeat.o(311751);
    return localCollection;
  }
  
  public static Collection<dbp> fLb()
  {
    AppMethodBeat.i(311761);
    Collection localCollection = (Collection)new ArrayList(JoP.values());
    AppMethodBeat.o(311761);
    return localCollection;
  }
  
  public static Collection<dbp> fLc()
  {
    AppMethodBeat.i(311764);
    Collection localCollection = (Collection)new ArrayList(JoN.values());
    AppMethodBeat.o(311764);
    return localCollection;
  }
  
  public static Collection<dbt> fLd()
  {
    AppMethodBeat.i(311773);
    Collection localCollection = (Collection)new ArrayList(JoQ.values());
    AppMethodBeat.o(311773);
    return localCollection;
  }
  
  private static final void fLe()
  {
    AppMethodBeat.i(311842);
    Iterator localIterator = ((Map)JoR).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((dbp)localEntry.getValue(), true);
      a((dbp)localEntry.getValue(), false);
      y.deleteFile(((dbp)localEntry.getValue()).path);
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.JyV;
      Log.i("WxIme.WxImeDictFetcher", s.X("deleteLocalDict dict:", com.tencent.mm.plugin.hld.f.l.n((dbp)localEntry.getValue())));
    }
    JoR.clear();
    AppMethodBeat.o(311842);
  }
  
  private static final void g(dbp paramdbp)
  {
    AppMethodBeat.i(311855);
    s.u(paramdbp, "$cloudDict");
    String str = b(paramdbp);
    if (JoT.contains(str))
    {
      Log.i("WxIme.WxImeDictFetcher", s.X("exist task ", str));
      AppMethodBeat.o(311855);
      return;
    }
    Object localObject = e(paramdbp);
    if ((y.ZC((String)localObject)) && (Util.isEqual(y.bub((String)localObject), paramdbp.md5)))
    {
      paramdbp.path = ((String)localObject);
      Log.i("WxIme.WxImeDictFetcher", "dataPath(" + (String)localObject + ") exist");
    }
    for (int i = 1; i != 0; i = 0)
    {
      c(paramdbp);
      d(paramdbp);
      Log.i("WxIme.WxImeDictFetcher", "addDownTask " + paramdbp.name + ' ' + paramdbp.md5 + " exist");
      AppMethodBeat.o(311855);
      return;
    }
    localObject = paramdbp.aaHa;
    if (localObject != null)
    {
      localObject = a((dbp)localObject);
      if (localObject != null)
      {
        Log.i("WxIme.WxImeDictFetcher", "addDownTask: exist_base_version:" + ((dbp)localObject).version + ", patch_base_version:" + paramdbp.aaHa.aaGZ + ", base_exist:" + y.ZC(((dbp)localObject).path));
        if ((((dbp)localObject).version == paramdbp.aaHa.aaGZ) && (y.ZC(((dbp)localObject).path)))
        {
          localObject = paramdbp.aaHa;
          s.s(localObject, "cloudDict.patchDict");
          str = b((dbp)localObject);
          if (JoT.contains(str))
          {
            Log.i("WxIme.WxImeDictFetcher", s.X("exist task ", str));
            AppMethodBeat.o(311855);
            return;
          }
          ((dbp)localObject).isPatch = true;
          ((dbp)localObject).aaHb = paramdbp;
          Log.i("WxIme.WxImeDictFetcher", "addDownTask use patch:" + ((dbp)localObject).name + "  " + ((dbp)localObject).version + ' ' + ((dbp)localObject).aaGZ);
          paramdbp = (dbp)localObject;
        }
      }
    }
    for (;;)
    {
      paramdbp.path = b(paramdbp, "download");
      paramdbp.KFe = 0;
      ((Map)JoS).put(str, paramdbp);
      JoT.add(str);
      a(paramdbp, str);
      AppMethodBeat.o(311855);
      return;
    }
  }
  
  private static void iz(List<Integer> paramList)
  {
    AppMethodBeat.i(311560);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(311560);
      return;
    }
    Log.i("WxIme.WxImeDictFetcher", s.X("getImeDicts ", Integer.valueOf(paramList.size())));
    Bundle localBundle = new Bundle();
    localBundle.putIntegerArrayList("rawDictList", new ArrayList((Collection)paramList));
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.b.class, a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(311560);
  }
  
  public static void jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(311792);
    s.u(paramString1, "inputPath");
    s.u(paramString2, "outputPath");
    Log.i("WxIme.WxImeDictFetcher", "unZlib: inputPath:" + paramString1 + " outputPath:" + paramString2);
    paramString1 = y.bi(paramString1, 0, -1);
    Inflater localInflater = new Inflater();
    localInflater.setInput(paramString1);
    paramString1 = (Closeable)y.ev(paramString2, false);
    try
    {
      paramString2 = (OutputStream)paramString1;
      byte[] arrayOfByte = new byte[1024];
      while (!localInflater.finished()) {
        paramString2.write(arrayOfByte, 0, localInflater.inflate(arrayOfByte));
      }
      return;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(311792);
        throw paramString2;
      }
      finally
      {
        kotlin.f.b.a(paramString1, paramString2);
        AppMethodBeat.o(311792);
      }
      paramString2 = ah.aiuX;
      kotlin.f.b.a(paramString1, null);
      AppMethodBeat.o(311792);
    }
  }
  
  private static byte[] k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(311692);
    if (paramArrayOfByte2 == null)
    {
      Log.e("WxIme.WxImeDictFetcher", "password is null");
      AppMethodBeat.o(311692);
      return null;
    }
    try
    {
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
      Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
      Object localObject = "0000000000000000".getBytes(kotlin.n.d.UTF_8);
      s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      localObject = new GCMParameterSpec(128, (byte[])localObject);
      localCipher.init(2, (Key)paramArrayOfByte2, (AlgorithmParameterSpec)localObject);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(311692);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("WxIme.WxImeDictFetcher", Util.stackTraceToString((Throwable)paramArrayOfByte1));
      AppMethodBeat.o(311692);
    }
    return null;
  }
  
  public static void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(311550);
    if (!paramBoolean)
    {
      int i = j.JvE.value;
      Log.i("WxIme.WxImeDictFetcher", s.X("getImeDict ", Integer.valueOf(i)));
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("type", i);
      Object localObject3 = fLb();
      Object localObject2 = new dbo();
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (dbp)((Iterator)localObject3).next();
        LinkedList localLinkedList = ((dbo)localObject2).aatr;
        ade localade = new ade();
        localade.name = ((dbp)localObject4).name;
        localade.version = ((dbp)localObject4).version;
        localObject4 = ah.aiuX;
        localLinkedList.add(localade);
      }
      ((Bundle)localObject1).putByteArray("dictList", ((dbo)localObject2).toByteArray());
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject1, a.a.class, a..ExternalSyntheticLambda1.INSTANCE);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(Integer.valueOf(com.tencent.mm.plugin.hld.model.i.JvC.value));
      localObject2 = ah.aiuX;
      iz((List)localObject1);
    }
    AppMethodBeat.o(311550);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/dict/WxImeDictFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "retryDownload", "localDict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements CdnLogic.DownloadCallback
  {
    private static boolean l(dbp paramdbp)
    {
      AppMethodBeat.i(311459);
      paramdbp.KFe += 1;
      if (paramdbp.KFe < 3)
      {
        a locala = a.JoL;
        locala = a.JoL;
        a.c(paramdbp, a.h(paramdbp));
        AppMethodBeat.o(311459);
        return true;
      }
      AppMethodBeat.o(311459);
      return false;
    }
    
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(311489);
      Object localObject2 = new StringBuilder("onC2CDownloadCompleted: ").append(paramString).append(", ");
      Object localObject1;
      long l1;
      if (paramC2CDownloadResult == null)
      {
        localObject1 = null;
        Log.i("WxIme.WxImeDictFetcher", localObject1 + ' ' + a.fLf().size());
        l1 = System.currentTimeMillis();
        if (paramString != null) {
          break label238;
        }
        paramString = null;
      }
      for (;;)
      {
        if (paramString == null) {
          Log.e("WxIme.WxImeDictFetcher", "filekey is null");
        }
        paramString = new StringBuilder("cdnCallback downloadTaskMap:").append(a.fLf().size()).append(", isFirst:");
        paramC2CDownloadResult = com.tencent.mm.plugin.hld.f.l.JyV;
        Log.i("WxIme.WxImeDictFetcher", com.tencent.mm.plugin.hld.f.l.fOO() + ", fetchFail:" + a.fLg() + ", internal:" + (System.currentTimeMillis() - l1));
        if (a.fLf().isEmpty())
        {
          paramString = com.tencent.mm.plugin.hld.f.l.JyV;
          if ((!com.tencent.mm.plugin.hld.f.l.fOO()) || (!a.fLg()))
          {
            paramString = com.tencent.mm.plugin.hld.f.l.JyV;
            com.tencent.mm.plugin.hld.f.l.fOP();
            paramString = com.tencent.mm.plugin.hld.f.l.JyV;
            paramString = com.tencent.mm.plugin.hld.f.l.getKV();
            if (paramString != null) {
              paramString.putLong("ime_get_dict_list_last_time", cn.bDx());
            }
          }
          paramString = a.JoL;
          a.wR(false);
          paramString = a.JoL;
          a.fLh();
        }
        AppMethodBeat.o(311489);
        return;
        localObject1 = Integer.valueOf(paramC2CDownloadResult.errorCode);
        break;
        label238:
        if (paramC2CDownloadResult == null)
        {
          paramString = null;
        }
        else
        {
          localObject2 = (dbp)a.fLf().get(paramString);
          if (paramC2CDownloadResult.errorCode != 0) {
            break label1407;
          }
          if (localObject2 != null) {
            break label295;
          }
          paramString = null;
          if (paramString == null) {
            Log.e("WxIme.WxImeDictFetcher", "dict is null");
          }
          paramString = ah.aiuX;
          paramString = ah.aiuX;
        }
      }
      label295:
      Log.i("WxIme.WxImeDictFetcher", "handle: " + ((dbp)localObject2).name + ' ' + ((dbp)localObject2).version + ' ' + ((dbp)localObject2).path + ' ' + y.bub(((dbp)localObject2).path) + ' ');
      label406:
      String str2;
      label541:
      label683:
      label818:
      label832:
      label839:
      String str1;
      label664:
      int i;
      long l2;
      if (y.ZC(((dbp)localObject2).path))
      {
        localObject1 = y.bi(((dbp)localObject2).path, 0, -1);
        paramC2CDownloadResult = a.JoL;
        paramC2CDownloadResult = ((dbp)localObject2).aaGU;
        if (paramC2CDownloadResult == null)
        {
          paramC2CDownloadResult = null;
          paramC2CDownloadResult = a.l((byte[])localObject1, paramC2CDownloadResult);
          if (paramC2CDownloadResult == null) {
            break label1338;
          }
          localObject1 = a.JoL;
          str2 = a.d((dbp)localObject2, "patch");
          localObject1 = y.bEo(str2);
          if (!y.ZC((String)localObject1)) {
            y.bDX((String)localObject1);
          }
          y.deleteFile(str2);
          Log.i("WxIme.WxImeDictFetcher", "decrypt: oriPath:" + ((dbp)localObject2).path + ", compressType:" + ((dbp)localObject2).oGu + ", isPatch:" + ((dbp)localObject2).isPatch);
          if (((dbp)localObject2).oGu != c.Juw.value) {
            break label683;
          }
          y.bEp(str2);
          y.f(str2, paramC2CDownloadResult, paramC2CDownloadResult.length);
          paramC2CDownloadResult = y.bub(str2);
          if (Util.isEqual(paramC2CDownloadResult, ((dbp)localObject2).md5)) {
            break label839;
          }
          Log.e("WxIme.WxImeDictFetcher", "fail: " + str2 + " md5(" + paramC2CDownloadResult + ") no equal(" + ((dbp)localObject2).md5 + ')');
          if (((dbp)localObject2).oGu != c.Juw.value) {
            break label832;
          }
        }
        for (paramC2CDownloadResult = m.JvS;; paramC2CDownloadResult = m.JvT)
        {
          localObject1 = k.JvH;
          k.a(paramC2CDownloadResult, (dbp)localObject2);
          if (!l((dbp)localObject2))
          {
            a.fLf().remove(paramString);
            paramString = a.JoL;
            a.wR(true);
          }
          for (;;)
          {
            paramString = ah.aiuX;
            paramString = ah.aiuX;
            break;
            paramC2CDownloadResult = paramC2CDownloadResult.Op;
            break label406;
            localObject1 = s.X(str2, "_decrypt");
            y.deleteFile((String)localObject1);
            y.f((String)localObject1, paramC2CDownloadResult, paramC2CDownloadResult.length);
            paramC2CDownloadResult = y.bub((String)localObject1);
            if (Util.isEqual(((dbp)localObject2).Znz, paramC2CDownloadResult)) {
              break label818;
            }
            Log.e("WxIme.WxImeDictFetcher", "unZlip(error): " + (String)localObject1 + " zipFileMd5:(" + paramC2CDownloadResult + ") no equal(" + ((dbp)localObject2).Znz + ')');
            paramC2CDownloadResult = k.JvH;
            k.a(m.JvS, (dbp)localObject2, 1);
            if (!l((dbp)localObject2))
            {
              a.fLf().remove(paramString);
              paramString = a.JoL;
              a.wR(true);
            }
          }
          paramC2CDownloadResult = a.JoL;
          a.jz((String)localObject1, str2);
          break label541;
        }
        paramC2CDownloadResult = a.JoL;
        str1 = a.i((dbp)localObject2);
        paramC2CDownloadResult = y.bEo(str1);
        if (!y.ZC(paramC2CDownloadResult)) {
          y.bDX(paramC2CDownloadResult);
        }
        y.deleteFile(str1);
        if (((dbp)localObject2).isPatch)
        {
          paramC2CDownloadResult = a.JoL;
          dbp localdbp = a.j((dbp)localObject2);
          i = 1;
          paramC2CDownloadResult = "";
          l2 = System.currentTimeMillis();
          if (localdbp == null) {
            break label1520;
          }
          localObject1 = y.bub(localdbp.path);
          s.s(localObject1, "getFileMD5String(baseDict.path)");
          paramC2CDownloadResult = y.bub(str2);
          s.s(paramC2CDownloadResult, "getFileMD5String(tempDictPath)");
          i = ((IBSPatchJNIService)com.tencent.mm.kernel.h.ax(IBSPatchJNIService.class)).bspatch(localdbp.path, str1, str2);
        }
      }
      for (;;)
      {
        Log.i("WxIme.WxImeDictFetcher", "bsDiff: mergeWithRetCode:" + i + ", baseMd5:" + (String)localObject1 + ", tempMd5:" + paramC2CDownloadResult + ", inter:" + (System.currentTimeMillis() - l2));
        boolean bool;
        if (i != 0)
        {
          bool = false;
          if (bool) {
            break label1186;
          }
          paramC2CDownloadResult = k.JvH;
          k.a(m.JvU, (dbp)localObject2, i);
          a.fLf().remove(paramString);
          if (((dbp)localObject2).aaHb == null) {
            break label1175;
          }
          paramString = ((dbp)localObject2).aaHb;
          paramC2CDownloadResult = a.JoL;
          paramC2CDownloadResult = a.h(paramString);
          localObject1 = a.JoL;
          paramString.path = a.d(paramString, "download");
          paramString.KFe = 0;
          localObject1 = (Map)a.fLf();
          s.s(paramString, "completionDict");
          ((Map)localObject1).put(paramC2CDownloadResult, paramString);
          localObject1 = a.JoL;
          a.c(paramString, paramC2CDownloadResult);
          break label664;
        }
        localObject1 = y.bub(str1);
        paramC2CDownloadResult = ((dbp)localObject2).aaHb;
        if (paramC2CDownloadResult == null) {}
        for (paramC2CDownloadResult = null;; paramC2CDownloadResult = paramC2CDownloadResult.md5)
        {
          bool = Util.isEqual((String)localObject1, paramC2CDownloadResult);
          break;
        }
        label1175:
        paramString = a.JoL;
        a.wR(true);
        break label664;
        label1186:
        paramC2CDownloadResult = ((dbp)localObject2).aaHb;
        if (paramC2CDownloadResult == null)
        {
          paramC2CDownloadResult = null;
          label1198:
          ((dbp)localObject2).md5 = paramC2CDownloadResult;
          label1204:
          ((dbp)localObject2).path = str1;
          ((dbp)localObject2).aaHa = null;
          ((dbp)localObject2).aaHb = null;
          Log.i("WxIme.WxImeDictFetcher", "success: " + str1 + ' ' + y.bub(str1) + ' ' + y.bEl(str1));
          paramC2CDownloadResult = a.JoL;
          a.k((dbp)localObject2);
          paramC2CDownloadResult = a.JoL;
          a.d((dbp)localObject2);
          paramC2CDownloadResult = k.JvH;
          k.a(m.JvQ, (dbp)localObject2);
        }
        for (;;)
        {
          a.fLf().remove(paramString);
          break;
          paramC2CDownloadResult = paramC2CDownloadResult.md5;
          break label1198;
          y.qn(str2, str1);
          y.deleteFile(str2);
          break label1204;
          label1338:
          Log.e("WxIme.WxImeDictFetcher", s.X("output is null, reTryTime:", Integer.valueOf(((dbp)localObject2).KFe)));
          paramC2CDownloadResult = k.JvH;
          k.a(m.JvS, (dbp)localObject2);
          if (l((dbp)localObject2)) {
            break;
          }
          paramC2CDownloadResult = a.JoL;
          a.wR(true);
          continue;
          Log.e("WxIme.WxImeDictFetcher", "file no exist");
          paramC2CDownloadResult = a.JoL;
          a.wR(true);
        }
        label1407:
        if (paramC2CDownloadResult.errorCode <= -5103000)
        {
          a.fLf().remove(paramString);
          paramString = a.JoL;
          a.wR(true);
        }
        label1518:
        for (;;)
        {
          paramString = k.JvH;
          k.a(m.JvR, (dbp)localObject2, paramC2CDownloadResult.errorCode);
          break;
          if (localObject2 == null) {}
          for (paramString = null;; paramString = ah.aiuX)
          {
            if (paramString != null) {
              break label1518;
            }
            Log.e("WxIme.WxImeDictFetcher", "dict is null????");
            break;
            Log.e("WxIme.WxImeDictFetcher", s.X("download fail, reTryTime:", Integer.valueOf(((dbp)localObject2).KFe)));
            if (!l((dbp)localObject2))
            {
              paramString = a.JoL;
              a.wR(true);
            }
            paramString = ah.aiuX;
          }
        }
        label1520:
        localObject1 = "";
      }
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/dict/WxImeDictFetcher$firstFetchCloudDictHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends MMHandler
  {
    e(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(311450);
      s.u(paramMessage, "msg");
      Log.d("WxIme.WxImeDictFetcher", "firstFetchCloudDictHandler");
      paramMessage = a.JoL;
      a.fKW();
      AppMethodBeat.o(311450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.c.a
 * JD-Core Version:    0.7.0.1
 */