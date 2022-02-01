package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.c.a;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import com.tencent.wxhld.info.DictInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeDictUtil;", "", "()V", "TAG", "", "filterDictForEngine", "", "dict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "finishLocalUserDictGenerator", "", "finishLocalUserDictLoad", "finishPhoneContactLoad", "finish", "getAssetsCacheFile", "context", "Landroid/content/Context;", "fileName", "getWxImeCloudDictPath", "data", "getWxImeLocalDictPath", "getWxImeUserDictPath", "getWximeBaseDictInfos", "", "Lcom/tencent/wxhld/info/DictInfo;", "(Landroid/content/Context;)[Lcom/tencent/wxhld/info/DictInfo;", "getWximeOptionalDictInfos", "()[Lcom/tencent/wxhld/info/DictInfo;", "isFinishLocalUserDictGenerator", "isFinishLocalUserDictLoad", "isFinishPhoneContactDataLoad", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Jyn;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(311633);
    Jyn = new f();
    TAG = "WxIme.WxImeDictUtil";
    AppMethodBeat.o(311633);
  }
  
  public static DictInfo[] fOf()
  {
    Object localObject2 = null;
    AppMethodBeat.i(311589);
    Object localObject1 = e.Jym;
    if (!e.fOc())
    {
      AppMethodBeat.o(311589);
      return null;
    }
    localObject1 = a.JoL;
    Object localObject4 = a.fLc();
    Object localObject3 = new ArrayList();
    Log.i(TAG, s.X("getWximeOptionalDictInfos use commonDicts:", Integer.valueOf(((Collection)localObject4).size())));
    localObject1 = new ArrayList();
    localObject4 = ((Collection)localObject4).iterator();
    Object localObject7;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (dbp)((Iterator)localObject4).next();
      localObject6 = TAG;
      localObject7 = l.JyV;
      Log.i((String)localObject6, s.X("getWximeOptionalDictInfos ", l.n((dbp)localObject5)));
      localObject6 = l.JyV;
      if (!l.m((dbp)localObject5))
      {
        localObject6 = a.JoL;
        ((ArrayList)localObject1).add(a.f((dbp)localObject5));
      }
      else
      {
        localObject6 = new DictInfo();
        ((DictInfo)localObject6).id = ((dbp)localObject5).typeId;
        ((DictInfo)localObject6).path = ((dbp)localObject5).path;
        localObject7 = ah.aiuX;
        ((ArrayList)localObject3).add(localObject6);
        Log.i(TAG, "cloud dict:" + ((dbp)localObject5).path + ' ' + y.bub(((dbp)localObject5).path));
      }
    }
    Log.i(TAG, s.X("getWximeOptionalDictInfos commonDicts invalidDictList:", Integer.valueOf(((ArrayList)localObject1).size())));
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        localObject4 = l.JyV;
        localObject4 = l.getKV();
        if (localObject4 != null) {
          break label380;
        }
      }
    }
    label380:
    Object localObject8;
    Object localObject9;
    for (localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.e(TAG, "getWximeOptionalDictInfos commonDicts getKv is null");
      }
      localObject1 = l.JyV;
      if (l.bGa())
      {
        localObject1 = i.JyA;
        if (!i.fOo()) {
          break label561;
        }
      }
      localObject1 = new DictInfo[((ArrayList)localObject3).size()];
      localObject2 = ((ArrayList)localObject3).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((DictInfo)((Iterator)localObject2).next());
        i += 1;
      }
      i = 0;
      break;
      localObject5 = new dbq();
      localObject6 = ((MultiProcessMMKV)localObject4).decodeBytes("key_current_cloud_dicts");
      if (localObject6 != null) {
        ((dbq)localObject5).parseFrom((byte[])localObject6);
      }
      localObject6 = new ArrayList();
      localObject7 = ((dbq)localObject5).aaHc.iterator();
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = (dbp)((Iterator)localObject7).next();
        localObject9 = a.JoL;
        s.s(localObject8, "cloudDict");
        if (((ArrayList)localObject1).contains(a.f((dbp)localObject8))) {
          ((ArrayList)localObject6).add(localObject8);
        }
      }
      localObject1 = ((ArrayList)localObject6).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject6 = (dbp)((Iterator)localObject1).next();
        ((dbq)localObject5).aaHc.remove(localObject6);
      }
      ((MultiProcessMMKV)localObject4).encode("key_current_cloud_dicts", ((dbq)localObject5).toByteArray());
      localObject1 = a.JoL;
      a.fKY();
    }
    AppMethodBeat.o(311589);
    return localObject1;
    label561:
    localObject1 = a.JoL;
    Object localObject6 = a.fLb();
    localObject1 = a.JoL;
    localObject4 = a.fLd();
    Log.i(TAG, "getWximeOptionalDictInfos use cloudict:" + ((Collection)localObject6).size() + ", userDicts:" + ((Collection)localObject4).size());
    if ((((Collection)localObject6).isEmpty()) && (((Collection)localObject4).isEmpty()))
    {
      AppMethodBeat.o(311589);
      return null;
    }
    Object localObject5 = new ArrayList();
    localObject1 = new ArrayList();
    localObject6 = ((Collection)localObject6).iterator();
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (dbp)((Iterator)localObject6).next();
      localObject8 = TAG;
      localObject9 = l.JyV;
      Log.i((String)localObject8, s.X("getWximeOptionalDictInfos ", l.n((dbp)localObject7)));
      localObject8 = l.JyV;
      if (!l.m((dbp)localObject7))
      {
        localObject8 = a.JoL;
        ((ArrayList)localObject1).add(a.f((dbp)localObject7));
      }
      else
      {
        localObject8 = new DictInfo();
        ((DictInfo)localObject8).id = ((dbp)localObject7).typeId;
        ((DictInfo)localObject8).path = ((dbp)localObject7).path;
        localObject9 = ah.aiuX;
        ((ArrayList)localObject5).add(localObject8);
        Log.i(TAG, "cloud dict:" + ((dbp)localObject7).path + ' ' + y.bub(((dbp)localObject7).path));
      }
    }
    Log.i(TAG, s.X("getWximeOptionalDictInfos invalidDictList:", Integer.valueOf(((ArrayList)localObject1).size())));
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        localObject6 = l.JyV;
        localObject6 = l.fPk();
        if (localObject6 != null) {
          break label979;
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.e(TAG, "getWximeOptionalDictInfos getKv is null");
      }
      localObject1 = new DictInfo[((ArrayList)localObject3).size() + ((ArrayList)localObject5).size() + ((Collection)localObject4).size()];
      localObject2 = ((ArrayList)localObject3).iterator();
      int j = 0;
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[j] = ((DictInfo)((Iterator)localObject2).next());
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      label979:
      localObject2 = new dbw();
      localObject7 = ((MultiProcessMMKV)localObject6).decodeBytes("key_current_cloud_dicts");
      if (localObject7 != null) {
        ((dbw)localObject2).parseFrom((byte[])localObject7);
      }
      localObject7 = ((dbw)localObject2).aaHm;
      if (localObject7 != null)
      {
        localObject8 = new ArrayList();
        localObject9 = ((dbq)localObject7).aaHc.iterator();
        while (((Iterator)localObject9).hasNext())
        {
          dbp localdbp = (dbp)((Iterator)localObject9).next();
          a locala = a.JoL;
          s.s(localdbp, "cloudDict");
          if (((ArrayList)localObject1).contains(a.f(localdbp))) {
            ((ArrayList)localObject8).add(localdbp);
          }
        }
        localObject1 = ((ArrayList)localObject8).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject8 = (dbp)((Iterator)localObject1).next();
          ((dbq)localObject7).aaHc.remove(localObject8);
        }
      }
      ((MultiProcessMMKV)localObject6).encode("key_current_cloud_dicts", ((dbw)localObject2).toByteArray());
      localObject1 = a.JoL;
      a.fKZ();
    }
    localObject2 = ((ArrayList)localObject5).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1[i] = ((DictInfo)((Iterator)localObject2).next());
      i += 1;
    }
    localObject2 = ((Collection)localObject4).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dbt)((Iterator)localObject2).next();
      localObject4 = new DictInfo();
      ((DictInfo)localObject4).id = 0;
      ((DictInfo)localObject4).path = ((dbt)localObject3).path;
      localObject5 = ah.aiuX;
      localObject1[i] = localObject4;
      i += 1;
      Log.i(TAG, "getWximeOptionalDictInfos user dict:" + ((dbt)localObject3).path + ' ' + y.bub(((dbt)localObject3).path));
    }
    AppMethodBeat.o(311589);
    return localObject1;
  }
  
  public static String fOg()
  {
    AppMethodBeat.i(311596);
    Object localObject = l.JyV;
    localObject = s.X(l.fOC(), "/dict/local");
    if (!y.ZC((String)localObject)) {
      y.bDX((String)localObject);
    }
    AppMethodBeat.o(311596);
    return localObject;
  }
  
  public static String fOh()
  {
    AppMethodBeat.i(311603);
    Object localObject = l.JyV;
    localObject = s.X(l.fOC(), "/dict/cloud");
    if (!y.ZC((String)localObject)) {
      y.bDX((String)localObject);
    }
    AppMethodBeat.o(311603);
    return localObject;
  }
  
  public static String fOi()
  {
    AppMethodBeat.i(311613);
    Object localObject = l.JyV;
    String str1 = l.fOD();
    if (str1 != null) {}
    for (localObject = s.X(str1, "/userdict");; localObject = s.X((String)localObject, "/userdict"))
    {
      if (!y.ZC((String)localObject)) {
        y.bDX((String)localObject);
      }
      String str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("getWxImeUserDictPath ");
      l locall = l.JyV;
      Log.i(str2, l.fPf() + ' ' + y.bEl(str1));
      AppMethodBeat.o(311613);
      return localObject;
      localObject = l.JyV;
      localObject = s.X(l.fOC(), "/common");
      if (!y.ZC((String)localObject)) {
        y.bDX((String)localObject);
      }
    }
  }
  
  public static boolean fOj()
  {
    AppMethodBeat.i(311618);
    Object localObject = l.JyV;
    localObject = l.fPk();
    if (localObject == null)
    {
      AppMethodBeat.o(311618);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_local_user_dict_load_finish", false);
    AppMethodBeat.o(311618);
    return bool;
  }
  
  public static boolean fOk()
  {
    AppMethodBeat.i(311624);
    Object localObject = l.JyV;
    localObject = l.fPk();
    if (localObject == null)
    {
      AppMethodBeat.o(311624);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_phone_contact_data_load_finish", false);
    AppMethodBeat.o(311624);
    return bool;
  }
  
  public static DictInfo[] io(Context paramContext)
  {
    Object localObject2 = null;
    int j = 0;
    AppMethodBeat.i(311555);
    s.u(paramContext, "context");
    Object localObject1 = e.Jym;
    Object localObject3;
    Object localObject4;
    if (!e.fOc())
    {
      localObject3 = new DictInfo[2];
      localObject1 = new DictInfo();
      ((DictInfo)localObject1).id = 524288;
      localObject4 = l.JyV;
      ((DictInfo)localObject1).path = l.L(paramContext, "config/", "static_required_dicts.bin");
      ((DictInfo)localObject1).version = 0;
      localObject4 = ah.aiuX;
      localObject3[0] = localObject1;
      localObject4 = TAG;
      localObject1 = localObject3[0];
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.d((String)localObject4, s.X("getWximeBaseDictInfos ", localObject1));
        localObject1 = new DictInfo();
        ((DictInfo)localObject1).id = 262144;
        localObject4 = l.JyV;
        ((DictInfo)localObject1).path = l.L(paramContext, "config/", "hyper_params.bin");
        ((DictInfo)localObject1).version = 0;
        paramContext = ah.aiuX;
        localObject3[1] = localObject1;
        localObject1 = TAG;
        paramContext = localObject3[1];
        if (paramContext != null) {
          break label212;
        }
      }
      label212:
      for (paramContext = (Context)localObject2;; paramContext = paramContext.path)
      {
        Log.d((String)localObject1, s.X("getWximeBaseDictInfos ", paramContext));
        Log.i(TAG, "user local dict");
        AppMethodBeat.o(311555);
        return localObject3;
        localObject1 = ((DictInfo)localObject1).path;
        break;
      }
    }
    paramContext = a.JoL;
    paramContext = a.fLa();
    Log.i(TAG, s.X("getWximeBaseDictInfos use cloudict:", Integer.valueOf(paramContext.size())));
    if (paramContext.isEmpty())
    {
      paramContext = l.JyV;
      l.fOQ();
      AppMethodBeat.o(311555);
      return null;
    }
    localObject2 = new ArrayList();
    paramContext = paramContext.iterator();
    if (paramContext.hasNext())
    {
      localObject1 = (dbp)paramContext.next();
      localObject3 = TAG;
      localObject4 = l.JyV;
      Log.i((String)localObject3, s.X("getWximeBaseDictInfos ", l.n((dbp)localObject1)));
      switch (((dbp)localObject1).typeId)
      {
      }
      for (i = 0; i != 0; i = 1)
      {
        ((ArrayList)localObject2).add(localObject1);
        break;
      }
    }
    Log.i(TAG, "getWximeBaseDictInfos " + ((ArrayList)localObject2).size() + " 2");
    if (((ArrayList)localObject2).size() != 2)
    {
      paramContext = l.JyV;
      l.fOQ();
      AppMethodBeat.o(311555);
      return null;
    }
    paramContext = new ArrayList();
    localObject1 = new DictInfo[2];
    localObject2 = ((ArrayList)localObject2).iterator();
    int i = 0;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dbp)((Iterator)localObject2).next();
      localObject4 = l.JyV;
      if (!l.m((dbp)localObject3))
      {
        localObject4 = a.JoL;
        paramContext.add(a.f((dbp)localObject3));
      }
      else
      {
        localObject4 = new DictInfo();
        ((DictInfo)localObject4).id = ((dbp)localObject3).typeId;
        ((DictInfo)localObject4).path = ((dbp)localObject3).path;
        ((DictInfo)localObject4).version = ((dbp)localObject3).version;
        localObject5 = ah.aiuX;
        localObject1[i] = localObject4;
        i += 1;
        Log.i(TAG, "getWximeBaseDictInfos cloud dict:" + ((dbp)localObject3).path + ' ' + y.bub(((dbp)localObject3).path));
      }
    }
    i = j;
    if (!((Collection)paramContext).isEmpty()) {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = l.JyV;
      localObject1 = l.getKV();
      if (localObject1 == null) {}
      for (paramContext = null;; paramContext = ah.aiuX)
      {
        if (paramContext == null) {
          Log.e(TAG, "getKv is null");
        }
        Log.e(TAG, "getWximeBaseDictInfos force get dict");
        AppMethodBeat.o(311555);
        return null;
        localObject2 = new dbq();
        localObject3 = ((MultiProcessMMKV)localObject1).decodeBytes("key_current_cloud_dicts");
        if (localObject3 != null) {
          ((dbq)localObject2).parseFrom((byte[])localObject3);
        }
        localObject3 = new ArrayList();
        localObject4 = ((dbq)localObject2).aaHc.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (dbp)((Iterator)localObject4).next();
          a locala = a.JoL;
          s.s(localObject5, "cloudDict");
          if (paramContext.contains(a.f((dbp)localObject5))) {
            ((ArrayList)localObject3).add(localObject5);
          }
        }
        paramContext = ((ArrayList)localObject3).iterator();
        while (paramContext.hasNext())
        {
          localObject3 = (dbp)paramContext.next();
          ((dbq)localObject2).aaHc.remove(localObject3);
        }
        ((MultiProcessMMKV)localObject1).encode("key_current_cloud_dicts", ((dbq)localObject2).toByteArray());
        paramContext = a.JoL;
        a.fKY();
        paramContext = l.JyV;
        l.fOQ();
      }
    }
    AppMethodBeat.o(311555);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.f
 * JD-Core Version:    0.7.0.1
 */