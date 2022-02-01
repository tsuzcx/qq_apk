package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.c.a;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import com.tencent.wxhld.info.DictInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeDictUtil;", "", "()V", "TAG", "", "filterDictForEngine", "", "dict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "finishLocalUserDictGenerator", "", "finishLocalUserDictLoad", "finishPhoneContactLoad", "finish", "getAssetsCacheFile", "context", "Landroid/content/Context;", "fileName", "getWxImeCloudDictPath", "data", "getWxImeLocalDictPath", "getWxImeUserDictPath", "getWximeBaseDictInfos", "", "Lcom/tencent/wxhld/info/DictInfo;", "(Landroid/content/Context;)[Lcom/tencent/wxhld/info/DictInfo;", "getWximeOptionalDictInfos", "()[Lcom/tencent/wxhld/info/DictInfo;", "isFinishLocalUserDictGenerator", "isFinishLocalUserDictLoad", "isFinishPhoneContactDataLoad", "plugin-hld_release"})
public final class f
{
  public static final f DGX;
  private static final String TAG = "WxIme.WxImeDictUtil";
  
  static
  {
    AppMethodBeat.i(213852);
    DGX = new f();
    TAG = "WxIme.WxImeDictUtil";
    AppMethodBeat.o(213852);
  }
  
  public static DictInfo[] eGs()
  {
    AppMethodBeat.i(213838);
    Object localObject1 = e.DGW;
    localObject1 = a.DvH;
    Object localObject3 = a.eDb();
    localObject1 = new ArrayList();
    Log.i(TAG, "getWximeOptionalDictInfos use commonDicts:" + ((Collection)localObject3).size());
    Object localObject2 = new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject6;
    Object localObject7;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (clh)((Iterator)localObject3).next();
      localObject5 = TAG;
      localObject6 = new StringBuilder("getWximeOptionalDictInfos ");
      localObject7 = l.DHK;
      Log.i((String)localObject5, l.k((clh)localObject4));
      localObject5 = l.DHK;
      if (!l.j((clh)localObject4))
      {
        localObject5 = a.DvH;
        ((ArrayList)localObject2).add(a.c((clh)localObject4));
      }
      else
      {
        localObject5 = new DictInfo();
        ((DictInfo)localObject5).id = ((clh)localObject4).ddx;
        ((DictInfo)localObject5).path = ((clh)localObject4).path;
        ((ArrayList)localObject1).add(localObject5);
        Log.i(TAG, "cloud dict:" + ((clh)localObject4).path + ' ' + u.buc(((clh)localObject4).path));
      }
    }
    Log.i(TAG, "getWximeOptionalDictInfos commonDicts invalidDictList:" + ((ArrayList)localObject2).size());
    int i;
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    Object localObject8;
    while (i != 0)
    {
      localObject3 = l.DHK;
      localObject3 = l.getKV();
      if (localObject3 == null) {
        break label545;
      }
      localObject4 = new cli();
      localObject5 = ((MultiProcessMMKV)localObject3).decodeBytes("key_current_cloud_dicts");
      if (localObject5 != null) {
        ((cli)localObject4).parseFrom((byte[])localObject5);
      }
      localObject5 = new ArrayList();
      localObject6 = ((cli)localObject4).TsR.iterator();
      for (;;)
      {
        if (((Iterator)localObject6).hasNext())
        {
          localObject7 = (clh)((Iterator)localObject6).next();
          localObject8 = a.DvH;
          p.j(localObject7, "cloudDict");
          if (((ArrayList)localObject2).contains(a.c((clh)localObject7)))
          {
            ((ArrayList)localObject5).add(localObject7);
            continue;
            i = 0;
            break;
          }
        }
      }
      localObject2 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (clh)((Iterator)localObject2).next();
        ((cli)localObject4).TsR.remove(localObject5);
      }
      ((MultiProcessMMKV)localObject3).encode("key_current_cloud_dicts", ((cli)localObject4).toByteArray());
      localObject2 = a.DvH;
      a.eCX();
    }
    for (;;)
    {
      localObject2 = l.DHK;
      if (l.biq())
      {
        localObject2 = i.DHq;
        if (!i.eGC()) {
          break label563;
        }
      }
      localObject2 = new DictInfo[((ArrayList)localObject1).size()];
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2[i] = ((DictInfo)((Iterator)localObject1).next());
        i += 1;
      }
      label545:
      Log.e(TAG, "getWximeOptionalDictInfos commonDicts getKv is null");
    }
    AppMethodBeat.o(213838);
    return localObject2;
    label563:
    localObject2 = a.DvH;
    Object localObject5 = a.eDa();
    localObject2 = a.DvH;
    localObject2 = a.eDc();
    Log.i(TAG, "getWximeOptionalDictInfos use cloudict:" + ((Collection)localObject5).size() + ", userDicts:" + ((Collection)localObject2).size());
    if ((((Collection)localObject5).isEmpty()) && (((Collection)localObject2).isEmpty()))
    {
      AppMethodBeat.o(213838);
      return null;
    }
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    localObject5 = ((Iterable)localObject5).iterator();
    Object localObject9;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (clh)((Iterator)localObject5).next();
      localObject7 = TAG;
      localObject8 = new StringBuilder("getWximeOptionalDictInfos ");
      localObject9 = l.DHK;
      Log.i((String)localObject7, l.k((clh)localObject6));
      localObject7 = l.DHK;
      if (!l.j((clh)localObject6))
      {
        localObject7 = a.DvH;
        ((ArrayList)localObject4).add(a.c((clh)localObject6));
      }
      else
      {
        localObject7 = new DictInfo();
        ((DictInfo)localObject7).id = ((clh)localObject6).ddx;
        ((DictInfo)localObject7).path = ((clh)localObject6).path;
        ((ArrayList)localObject3).add(localObject7);
        Log.i(TAG, "cloud dict:" + ((clh)localObject6).path + ' ' + u.buc(((clh)localObject6).path));
      }
    }
    Log.i(TAG, "getWximeOptionalDictInfos invalidDictList:" + ((ArrayList)localObject4).size());
    if (!((Collection)localObject4).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject5 = l.DHK;
      localObject5 = l.eHB();
      if (localObject5 == null) {
        break label1174;
      }
      localObject6 = new clo();
      localObject7 = ((MultiProcessMMKV)localObject5).decodeBytes("key_current_cloud_dicts");
      if (localObject7 != null) {
        ((clo)localObject6).parseFrom((byte[])localObject7);
      }
      localObject7 = ((clo)localObject6).Ttb;
      if (localObject7 != null)
      {
        localObject8 = new ArrayList();
        localObject9 = ((cli)localObject7).TsR.iterator();
        for (;;)
        {
          if (((Iterator)localObject9).hasNext())
          {
            clh localclh = (clh)((Iterator)localObject9).next();
            a locala = a.DvH;
            p.j(localclh, "cloudDict");
            if (((ArrayList)localObject4).contains(a.c(localclh)))
            {
              ((ArrayList)localObject8).add(localclh);
              continue;
              i = 0;
              break;
            }
          }
        }
        localObject4 = ((ArrayList)localObject8).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject8 = (clh)((Iterator)localObject4).next();
          ((cli)localObject7).TsR.remove(localObject8);
        }
      }
      ((MultiProcessMMKV)localObject5).encode("key_current_cloud_dicts", ((clo)localObject6).toByteArray());
      localObject4 = a.DvH;
      a.eCY();
    }
    for (;;)
    {
      localObject4 = new DictInfo[((ArrayList)localObject1).size() + ((ArrayList)localObject3).size() + ((Collection)localObject2).size()];
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      int j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject4[j] = ((DictInfo)((Iterator)localObject1).next());
        j += 1;
        i += 1;
      }
      label1174:
      Log.e(TAG, "getWximeOptionalDictInfos getKv is null");
    }
    localObject1 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4[i] = ((DictInfo)((Iterator)localObject1).next());
      i += 1;
    }
    localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cll)((Iterator)localObject1).next();
      localObject3 = new DictInfo();
      ((DictInfo)localObject3).id = 0;
      ((DictInfo)localObject3).path = ((cll)localObject2).path;
      localObject4[i] = localObject3;
      i += 1;
      Log.i(TAG, "getWximeOptionalDictInfos user dict:" + ((cll)localObject2).path + ' ' + u.buc(((cll)localObject2).path));
    }
    AppMethodBeat.o(213838);
    return localObject4;
  }
  
  public static String eGt()
  {
    AppMethodBeat.i(213840);
    Object localObject = new StringBuilder();
    l locall = l.DHK;
    localObject = l.eGU() + "/dict/cloud";
    if (!u.agG((String)localObject)) {
      u.bBD((String)localObject);
    }
    AppMethodBeat.o(213840);
    return localObject;
  }
  
  public static String eGu()
  {
    AppMethodBeat.i(213841);
    Object localObject1 = l.DHK;
    String str = l.eGV();
    if (str != null) {}
    Object localObject2;
    for (localObject1 = str + "/userdict";; localObject1 = (String)localObject2 + "/userdict")
    {
      if (!u.agG((String)localObject1)) {
        u.bBD((String)localObject1);
      }
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("getWxImeUserDictPath ");
      l locall = l.DHK;
      Log.i((String)localObject2, l.eHw() + ' ' + u.bBQ(str));
      AppMethodBeat.o(213841);
      return localObject1;
      localObject1 = new StringBuilder();
      localObject2 = l.DHK;
      localObject2 = l.eGU() + "/common";
      if (!u.agG((String)localObject2)) {
        u.bBD((String)localObject2);
      }
    }
  }
  
  public static boolean eGv()
  {
    AppMethodBeat.i(213843);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_local_user_dict_load_finish", false);
      AppMethodBeat.o(213843);
      return bool;
    }
    AppMethodBeat.o(213843);
    return false;
  }
  
  public static boolean eGw()
  {
    AppMethodBeat.i(213845);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_phone_contact_data_load_finish", false);
      AppMethodBeat.o(213845);
      return bool;
    }
    AppMethodBeat.o(213845);
    return false;
  }
  
  public static DictInfo[] gS(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(213832);
    p.k(paramContext, "context");
    paramContext = e.DGW;
    paramContext = a.DvH;
    paramContext = a.eCZ();
    Log.i(TAG, "getWximeBaseDictInfos use cloudict:" + paramContext.size());
    if (paramContext.isEmpty())
    {
      paramContext = l.DHK;
      l.eHh();
      AppMethodBeat.o(213832);
      return null;
    }
    Object localObject1 = new ArrayList();
    paramContext = ((Iterable)paramContext).iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (paramContext.hasNext())
    {
      localObject2 = (clh)paramContext.next();
      localObject3 = TAG;
      localObject4 = new StringBuilder("getWximeBaseDictInfos ");
      localObject5 = l.DHK;
      Log.i((String)localObject3, l.k((clh)localObject2));
      switch (((clh)localObject2).ddx)
      {
      }
      for (i = 0; i != 0; i = 1)
      {
        ((ArrayList)localObject1).add(localObject2);
        break;
      }
    }
    Log.i(TAG, "getWximeBaseDictInfos " + ((ArrayList)localObject1).size() + " 2");
    if (((ArrayList)localObject1).size() != 2)
    {
      paramContext = l.DHK;
      l.eHh();
      AppMethodBeat.o(213832);
      return null;
    }
    paramContext = new ArrayList();
    Object localObject2 = new DictInfo[2];
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (clh)((Iterator)localObject1).next();
      localObject4 = l.DHK;
      if (!l.j((clh)localObject3))
      {
        localObject4 = a.DvH;
        paramContext.add(a.c((clh)localObject3));
      }
      else
      {
        localObject4 = new DictInfo();
        ((DictInfo)localObject4).id = ((clh)localObject3).ddx;
        ((DictInfo)localObject4).path = ((clh)localObject3).path;
        ((DictInfo)localObject4).version = ((clh)localObject3).version;
        localObject2[i] = localObject4;
        i += 1;
        Log.i(TAG, "getWximeBaseDictInfos cloud dict:" + ((clh)localObject3).path + ' ' + u.buc(((clh)localObject3).path));
      }
    }
    i = j;
    if (!((Collection)paramContext).isEmpty()) {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = l.DHK;
      localObject1 = l.getKV();
      if (localObject1 != null)
      {
        localObject2 = new cli();
        localObject3 = ((MultiProcessMMKV)localObject1).decodeBytes("key_current_cloud_dicts");
        if (localObject3 != null) {
          ((cli)localObject2).parseFrom((byte[])localObject3);
        }
        localObject3 = new ArrayList();
        localObject4 = ((cli)localObject2).TsR.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (clh)((Iterator)localObject4).next();
          a locala = a.DvH;
          p.j(localObject5, "cloudDict");
          if (paramContext.contains(a.c((clh)localObject5))) {
            ((ArrayList)localObject3).add(localObject5);
          }
        }
        paramContext = ((ArrayList)localObject3).iterator();
        while (paramContext.hasNext())
        {
          localObject3 = (clh)paramContext.next();
          ((cli)localObject2).TsR.remove(localObject3);
        }
        ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", ((cli)localObject2).toByteArray());
        paramContext = a.DvH;
        a.eCX();
        paramContext = l.DHK;
        l.eHh();
      }
      for (;;)
      {
        Log.e(TAG, "getWximeBaseDictInfos force get dict");
        AppMethodBeat.o(213832);
        return null;
        Log.e(TAG, "getKv is null");
      }
    }
    AppMethodBeat.o(213832);
    return localObject2;
  }
  
  public static void tc(boolean paramBoolean)
  {
    AppMethodBeat.i(213848);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null)
    {
      ((MultiProcessMMKV)localObject).putBoolean("ime_phone_contact_data_load_finish", paramBoolean);
      AppMethodBeat.o(213848);
      return;
    }
    AppMethodBeat.o(213848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.f
 * JD-Core Version:    0.7.0.1
 */