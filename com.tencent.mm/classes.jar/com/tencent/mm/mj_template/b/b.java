package com.tencent.mm.mj_template.b;

import android.util.ArrayMap;
import com.tencent.maas.MJMaasCore.TemplateServiceProvider;
import com.tencent.maas.model.MJTemplateInfo;
import com.tencent.maas.model.MJTemplateMetadata;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.d<-Ljava.util.List<+Lcom.tencent.mm.protocal.protobuf.fxr;>;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/svr_model/TemplateInfoHolder;", "", "()V", "CACHE_KEY_FINDER_ALBUM", "", "CACHE_KEY_FINDER_RECORD", "CACHE_KEY_SNS", "SCENE_FINDER_CUT_SAME", "", "SCENE_FINDER_DEFAULT", "SCENE_SNS_CUT_DEFAULT", "SCENE_SNS_CUT_SAME", "TAG", "awaitJobs", "Landroid/util/ArrayMap;", "Lkotlinx/coroutines/Job;", "cachedCategoryJob", "currentAvailableList", "Lcom/tencent/mm/mj_template/svr_model/TemplateInfoHolder$CachedTemplateListInfo;", "infoHolder", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "listDataHolder", "mainScope", "mjTemplateHolder", "Lcom/tencent/maas/model/MJTemplateInfo;", "templateIdSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "awaitCameraTemplateList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInfo", "templateId", "scene", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRecommendTemplate", "cacheKey", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheCameraListImpl", "", "cacheCategoryListImpl", "cacheMJTemplate", "template", "cacheVideoTemplate", "getInfo", "getTemplateServiceProvider", "Lcom/tencent/maas/MJMaasCore$TemplateServiceProvider;", "loadCameraTemplateList", "loadInfo", "preloadCategoryTemplateList", "reqImpl", "CachedTemplateListInfo", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final int Ue;
  private static final aq mainScope;
  private static final aq obv;
  public static final b ofM;
  private static final ConcurrentHashMap<String, fxr> ofN;
  private static final ConcurrentHashMap<String, b.a> ofO;
  private static final HashSet<String> ofP;
  private static final ArrayMap<String, cb> ofQ;
  private static b.a ofR;
  private static cb ofS;
  private static final ArrayMap<String, MJTemplateInfo> ofT;
  
  static
  {
    AppMethodBeat.i(239795);
    ofM = new b();
    ofN = new ConcurrentHashMap();
    ofO = new ConcurrentHashMap();
    ofP = new HashSet();
    obv = ar.d(bg.kCi().plus((f)cx.g(null)));
    mainScope = ar.kBZ();
    ofQ = new ArrayMap();
    ofT = new ArrayMap();
    Ue = 8;
    AppMethodBeat.o(239795);
  }
  
  public static fxr HR(String paramString)
  {
    AppMethodBeat.i(239622);
    s.u(paramString, "templateId");
    Object localObject = ofN.get(paramString);
    fxr localfxr = (fxr)localObject;
    paramString = new StringBuilder("get ").append(paramString).append(" info ");
    if (localfxr != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", bool);
      paramString = (fxr)localObject;
      AppMethodBeat.o(239622);
      return paramString;
    }
  }
  
  private static final MJTemplateMetadata HS(String paramString)
  {
    AppMethodBeat.i(239728);
    s.u(paramString, "templateId");
    paramString = (MJTemplateMetadata)kotlinx.coroutines.k.x((m)new g(paramString, null));
    AppMethodBeat.o(239728);
    return paramString;
  }
  
  public static void O(int paramInt, final String paramString)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(239631);
    s.u(paramString, "cacheKey");
    b.a locala = (b.a)ofO.get(paramString);
    long l2 = System.currentTimeMillis();
    long l1;
    if (locala == null)
    {
      l1 = 0L;
      if (l2 <= l1) {
        break label155;
      }
      localObject2 = ofS;
      if ((localObject2 == null) || (((cb)localObject2).isActive() != true)) {
        break label137;
      }
      label68:
      if (i != 0) {
        break label155;
      }
      if (locala != null) {
        break label142;
      }
    }
    label137:
    label142:
    for (localObject1 = null;; localObject1 = Long.valueOf(locala.ofU))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", s.X("preloadTemplateList cached list expire ", localObject1));
      ofR = null;
      ofS = j.a(obv, null, null, (m)new j(paramInt, paramString, null), 3);
      AppMethodBeat.o(239631);
      return;
      l1 = locala.ofU;
      break;
      i = 0;
      break label68;
    }
    label155:
    ofR = locala;
    Object localObject2 = new StringBuilder("preloadTemplateList not expired ");
    if (locala == null)
    {
      paramString = null;
      localObject2 = ((StringBuilder)localObject2).append(paramString).append(", loading: ");
      paramString = ofS;
      if (paramString != null) {
        break label241;
      }
    }
    label241:
    for (paramString = (String)localObject1;; paramString = Boolean.valueOf(paramString.isActive()))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", paramString + ' ');
      AppMethodBeat.o(239631);
      return;
      paramString = Long.valueOf(locala.ofU);
      break;
    }
  }
  
  private final Object P(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(239701);
    if ((paramd instanceof e))
    {
      localObject1 = (e)paramd;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new e(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239701);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", "cacheCameraListImpl");
    Object localObject1 = a.ofK;
    paramd.label = 1;
    localObject1 = ((a)localObject1).N(paramd);
    paramd = (kotlin.d.d<? super ah>)localObject1;
    if (localObject1 == localObject2)
    {
      AppMethodBeat.o(239701);
      return localObject2;
      ResultKt.throwOnFailure(localObject1);
      paramd = (kotlin.d.d<? super ah>)localObject1;
    }
    localObject1 = (cgc)paramd;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder("cacheCameraListImpl rsp, max_age: ").append(((cgc)localObject1).aapp).append(", listSize: ");
      paramd = ((cgc)localObject1).ZeM;
      long l1;
      long l2;
      if (paramd == null)
      {
        paramd = null;
        Log.i("MicroMsg.Maas.CreationSameInfoHolder", paramd);
        l1 = System.currentTimeMillis();
        l2 = ((cgc)localObject1).aapp * 1000;
        paramd = ((cgc)localObject1).ZeM;
        if (paramd != null) {
          break label404;
        }
      }
      label404:
      for (paramd = (List)ab.aivy;; paramd = (List)paramd)
      {
        paramd = new b.a(l1 + l2, paramd);
        ofR = paramd;
        ((Map)ofO).put("cache_key_finder_record", paramd);
        paramd = ((cgc)localObject1).ZeM;
        if (paramd == null) {
          break label412;
        }
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          localObject1 = (fxr)paramd.next();
          ofP.add(((fxr)localObject1).id);
          localObject2 = (Map)ofN;
          String str = ((fxr)localObject1).id;
          s.s(str, "it.id");
          ((Map)localObject2).put(str, localObject1);
        }
        paramd = Integer.valueOf(paramd.size());
        break;
      }
    }
    label412:
    paramd = ah.aiuX;
    AppMethodBeat.o(239701);
    return paramd;
  }
  
  public static void a(MJTemplateInfo paramMJTemplateInfo)
  {
    AppMethodBeat.i(239644);
    s.u(paramMJTemplateInfo, "template");
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", "cacheMJTemplate:" + paramMJTemplateInfo.getTemplateID() + ", " + paramMJTemplateInfo.getTemplateDescVersion() + ", " + paramMJTemplateInfo.getTemplateDescURL() + ", " + paramMJTemplateInfo.getThumbnailURL());
    ((Map)ofT).put(paramMJTemplateInfo.getTemplateID(), paramMJTemplateInfo);
    AppMethodBeat.o(239644);
  }
  
  public static void aJ(String paramString, final int paramInt)
  {
    AppMethodBeat.i(239613);
    s.u(paramString, "templateId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.Maas.CreationSameInfoHolder", "template id is empty");
      AppMethodBeat.o(239613);
      return;
    }
    ((Map)ofQ).put(paramString, j.a(mainScope, null, null, (m)new i(paramString, paramInt, null), 3));
    AppMethodBeat.o(239613);
  }
  
  private final Object b(int paramInt, String paramString, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(239688);
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new f(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239688);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", s.X("cacheCategoryListImpl ", Integer.valueOf(paramInt)));
    Object localObject1 = a.ofK;
    paramd.L$0 = paramString;
    paramd.aai = paramInt;
    paramd.label = 1;
    localObject1 = ((a)localObject1).b(paramInt, paramd);
    paramd = (kotlin.d.d<? super ah>)localObject1;
    if (localObject1 == localObject2)
    {
      AppMethodBeat.o(239688);
      return localObject2;
      paramInt = paramd.aai;
      paramString = (String)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      paramd = (kotlin.d.d<? super ah>)localObject1;
    }
    localObject1 = (ctm)paramd;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder("cacheCategoryListImpl rsp ").append(paramInt).append(", max_age: ").append(((ctm)localObject1).aapp).append(", listSize: ");
      paramd = ((ctm)localObject1).ZeM;
      long l1;
      long l2;
      if (paramd == null)
      {
        paramd = null;
        Log.i("MicroMsg.Maas.CreationSameInfoHolder", paramd);
        l1 = System.currentTimeMillis();
        l2 = ((ctm)localObject1).aapp * 1000;
        paramd = ((ctm)localObject1).ZeM;
        if (paramd != null) {
          break label441;
        }
      }
      label441:
      for (paramd = (List)ab.aivy;; paramd = (List)paramd)
      {
        paramd = new b.a(l1 + l2, paramd);
        ofR = paramd;
        ((Map)ofO).put(paramString, paramd);
        paramString = ((ctm)localObject1).ZeM;
        if (paramString == null) {
          break label449;
        }
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          paramd = (fxr)paramString.next();
          ofP.add(paramd.id);
          localObject1 = (Map)ofN;
          localObject2 = paramd.id;
          s.s(localObject2, "it.id");
          ((Map)localObject1).put(localObject2, paramd);
        }
        paramd = Integer.valueOf(paramd.size());
        break;
      }
    }
    label449:
    paramString = ah.aiuX;
    AppMethodBeat.o(239688);
    return paramString;
  }
  
  public static void b(fxr paramfxr)
  {
    AppMethodBeat.i(239654);
    s.u(paramfxr, "template");
    Map localMap = (Map)ofN;
    String str = paramfxr.id;
    s.s(str, "template.id");
    localMap.put(str, paramfxr);
    AppMethodBeat.o(239654);
  }
  
  public static MJMaasCore.TemplateServiceProvider byI()
  {
    return b..ExternalSyntheticLambda0.INSTANCE;
  }
  
  private final Object c(String paramString, int paramInt, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(239712);
    if ((paramd instanceof k))
    {
      localObject = (k)paramd;
      if ((((k)localObject).label & 0x80000000) != 0) {
        ((k)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject;; paramd = new k(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239712);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject);
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", "reqImpl templateId: " + paramString + ", scene: " + paramInt);
    Object localObject = (f)bg.kCi();
    m localm = (m)new b.l(paramString, paramInt, null);
    paramd.L$0 = paramString;
    paramd.label = 1;
    localObject = l.a((f)localObject, localm, paramd);
    paramd = (kotlin.d.d<? super ah>)localObject;
    if (localObject == locala)
    {
      AppMethodBeat.o(239712);
      return locala;
      paramString = (String)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
      paramd = (kotlin.d.d<? super ah>)localObject;
    }
    paramd = (fxr)paramd;
    if (paramd == null) {}
    for (paramd = null;; paramd = ah.aiuX)
    {
      if (paramd == null) {
        ofP.remove(paramString);
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(239712);
      return paramString;
      ((Map)ofN).put(paramString, paramd);
    }
  }
  
  public final Object O(kotlin.d.d<? super List<? extends fxr>> paramd)
  {
    AppMethodBeat.i(239851);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super List<? extends fxr>>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239851);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", "awaitCameraTemplateList");
    Object localObject1 = (b.a)ofO.get("cache_key_finder_record");
    long l2 = System.currentTimeMillis();
    long l1;
    int i;
    if (localObject1 == null)
    {
      l1 = 0L;
      if (l2 <= l1) {
        break label301;
      }
      localObject2 = ofS;
      if ((localObject2 == null) || (((cb)localObject2).isActive() != true)) {
        break label283;
      }
      i = 1;
      label185:
      if (i != 0) {
        break label301;
      }
      if (localObject1 != null) {
        break label288;
      }
    }
    label283:
    label288:
    for (localObject1 = null;; localObject1 = Long.valueOf(((b.a)localObject1).ofU))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", s.X("preloadTemplateList cached list expire ", localObject1));
      ofR = null;
      ofS = j.a(obv, null, null, (m)new h(null), 3);
      localObject1 = ofS;
      if (localObject1 == null) {
        break label410;
      }
      paramd.label = 1;
      if (((cb)localObject1).ay(paramd) != locala) {
        break label410;
      }
      AppMethodBeat.o(239851);
      return locala;
      l1 = ((b.a)localObject1).ofU;
      break;
      i = 0;
      break label185;
    }
    label301:
    ofR = (b.a)localObject1;
    Object localObject2 = new StringBuilder("preloadTemplateList not expired ");
    if (localObject1 == null)
    {
      localObject1 = null;
      label326:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", loading: ");
      localObject1 = ofS;
      if (localObject1 != null) {
        break label390;
      }
    }
    label390:
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((cb)localObject1).isActive()))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", localObject1 + ' ');
      break;
      localObject1 = Long.valueOf(((b.a)localObject1).ofU);
      break label326;
    }
    ResultKt.throwOnFailure(localObject1);
    label410:
    localObject1 = new StringBuilder("template list size ");
    paramd = ofR;
    if (paramd == null)
    {
      paramd = null;
      localObject1 = ((StringBuilder)localObject1).append(paramd).append(" expire time: ");
      paramd = ofR;
      if (paramd != null) {
        break label507;
      }
    }
    label507:
    for (paramd = null;; paramd = kotlin.d.b.a.b.BF(paramd.ofU))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", paramd + ' ');
      paramd = ofR;
      if (paramd != null) {
        break label518;
      }
      AppMethodBeat.o(239851);
      return null;
      paramd = Integer.valueOf(paramd.dataList.size());
      break;
    }
    label518:
    paramd = paramd.dataList;
    AppMethodBeat.o(239851);
    return paramd;
  }
  
  public final Object a(int paramInt, String paramString, kotlin.d.d<? super List<? extends fxr>> paramd)
  {
    AppMethodBeat.i(239829);
    Object localObject1;
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super List<? extends fxr>>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239829);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", s.X("await category list ", Integer.valueOf(paramInt)));
    O(paramInt, paramString);
    paramString = ofS;
    if (paramString != null)
    {
      paramd.label = 1;
      if (paramString.ay(paramd) == localObject1)
      {
        AppMethodBeat.o(239829);
        return localObject1;
        ResultKt.throwOnFailure(localObject2);
      }
    }
    paramd = new StringBuilder("template list size ");
    paramString = ofR;
    if (paramString == null)
    {
      paramString = null;
      paramd = paramd.append(paramString).append(" expire time: ");
      paramString = ofR;
      if (paramString != null) {
        break label273;
      }
    }
    label273:
    for (paramString = null;; paramString = kotlin.d.b.a.b.BF(paramString.ofU))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", paramString + ' ');
      paramString = ofR;
      if (paramString != null) {
        break label284;
      }
      AppMethodBeat.o(239829);
      return null;
      paramString = Integer.valueOf(paramString.dataList.size());
      break;
    }
    label284:
    paramString = paramString.dataList;
    AppMethodBeat.o(239829);
    return paramString;
  }
  
  public final Object b(String paramString, int paramInt, kotlin.d.d<? super fxr> paramd)
  {
    Object localObject2 = null;
    AppMethodBeat.i(239814);
    c localc;
    if ((paramd instanceof c))
    {
      localc = (c)paramd;
      if ((localc.label & 0x80000000) != 0) {
        localc.label += -2147483648;
      }
    }
    Object localObject1;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = localc.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localc.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239814);
        throw paramString;
        localc = new c(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.Maas.CreationSameInfoHolder", s.X("await info ", paramString));
    if (!ofN.contains(paramString))
    {
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", "awaitInfo no cache, need await");
      localObject1 = (cb)ofQ.get(paramString);
      if (localObject1 == null) {
        localObject1 = this;
      }
      for (;;)
      {
        paramd = paramString;
        if (localObject2 != null) {
          break;
        }
        Log.w("MicroMsg.Maas.CreationSameInfoHolder", "awaitInfo template not been preloaded");
        localObject2 = ofM;
        localc.L$0 = localObject1;
        localc.Uf = paramString;
        localc.label = 2;
        paramd = paramString;
        if (((b)localObject2).c(paramString, paramInt, localc) != locala) {
          break;
        }
        AppMethodBeat.o(239814);
        return locala;
        if (((cb)localObject1).isActive()) {}
        for (;;)
        {
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = this;
          break;
          localObject1 = null;
        }
        label271:
        localc.L$0 = this;
        localc.Uf = paramString;
        localc.aai = paramInt;
        localc.label = 1;
        paramd = this;
        if (((cb)localObject1).ay(localc) == locala)
        {
          AppMethodBeat.o(239814);
          return locala;
          paramInt = localc.aai;
          paramString = (String)localc.Uf;
          paramd = (b)localc.L$0;
          ResultKt.throwOnFailure(localObject1);
        }
        localObject2 = ah.aiuX;
        localObject1 = paramd;
      }
      paramd = (String)localc.Uf;
      ResultKt.throwOnFailure(localObject1);
    }
    for (;;)
    {
      paramString = HR(paramd);
      AppMethodBeat.o(239814);
      return paramString;
      Log.i("MicroMsg.Maas.CreationSameInfoHolder", "awaitInfo load template from cache");
      paramd = paramString;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239543);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofV.O((kotlin.d.d)this);
      AppMethodBeat.o(239543);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int aai;
    int label;
    
    c(b paramb, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239579);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofV.b(null, 0, (kotlin.d.d)this);
      AppMethodBeat.o(239579);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    int label;
    
    d(b paramb, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239578);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofV.a(0, null, (kotlin.d.d)this);
      AppMethodBeat.o(239578);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    int label;
    
    e(b paramb, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239587);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(this.ofV, (kotlin.d.d)this);
      AppMethodBeat.o(239587);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int aai;
    int label;
    
    f(b paramb, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239580);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(this.ofV, 0, null, (kotlin.d.d)this);
      AppMethodBeat.o(239580);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/maas/model/MJTemplateMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super MJTemplateMetadata>, Object>
  {
    Object L$0;
    int label;
    
    g(String paramString, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239612);
      paramObject = (kotlin.d.d)new g(this.oad, paramd);
      AppMethodBeat.o(239612);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239605);
      Object localObject3 = kotlin.d.a.a.aiwj;
      Object localObject2;
      Object localObject1;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239605);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.ofM;
        paramObject = this.oad;
        s.s(paramObject, "templateId");
        localObject2 = b.HR(paramObject);
        paramObject = (MJTemplateInfo)b.byL().get(this.oad);
        if ((localObject2 == null) && (paramObject == null))
        {
          localObject1 = b.ofM;
          localObject2 = this.oad;
          s.s(localObject2, "templateId");
          localObject4 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          localObject1 = ((b)localObject1).b((String)localObject2, 2, (kotlin.d.d)localObject4);
          if (localObject1 == localObject3)
          {
            AppMethodBeat.o(239605);
            return localObject3;
          }
        }
        break;
      case 1: 
        localObject2 = (MJTemplateInfo)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = (fxr)localObject1;
        localObject1 = paramObject;
      }
      for (paramObject = localObject2;; paramObject = localObject2)
      {
        label232:
        label254:
        int i;
        if (paramObject == null)
        {
          localObject2 = null;
          localObject4 = new StringBuilder("request template info ").append(this.oad).append(", ");
          if (localObject2 != null) {
            break label326;
          }
          localObject3 = null;
          localObject4 = ((StringBuilder)localObject4).append(localObject3).append(", ");
          if (localObject2 != null) {
            break label339;
          }
          localObject3 = null;
          Log.i("MicroMsg.Maas.CreationSameInfoHolder", localObject3);
          if (localObject2 != null)
          {
            localObject3 = (CharSequence)((aex)localObject2).ZmX;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label349;
            }
            i = 1;
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            if (localObject1 == null)
            {
              AppMethodBeat.o(239605);
              return null;
              localObject2 = paramObject.abVq;
              break;
              label326:
              localObject3 = Integer.valueOf(((aex)localObject2).ZmY);
              break label232;
              label339:
              localObject3 = ((aex)localObject2).ZmX;
              break label254;
              label349:
              i = 0;
              continue;
            }
            Log.i("MicroMsg.Maas.CreationSameInfoHolder", "get cached " + ((MJTemplateInfo)localObject1).getTemplateDescVersion() + ", " + ((MJTemplateInfo)localObject1).getTemplateDescURL());
            paramObject = new MJTemplateMetadata(((MJTemplateInfo)localObject1).getTemplateID(), ((MJTemplateInfo)localObject1).getTemplateDescVersion(), ((MJTemplateInfo)localObject1).getTemplateDescURL(), ((MJTemplateInfo)localObject1).getMinimumiOSSDKVersion(), ((MJTemplateInfo)localObject1).getMinimumAndroidSDKVersion());
            AppMethodBeat.o(239605);
            return paramObject;
          }
        }
        localObject3 = this.oad;
        long l1 = ((aex)localObject2).ZmY;
        localObject2 = ((aex)localObject2).ZmX;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        long l2;
        if (paramObject == null)
        {
          i = 0;
          l2 = i;
          if (paramObject != null) {
            break label530;
          }
          i = 0;
        }
        for (;;)
        {
          paramObject = new MJTemplateMetadata((String)localObject3, l1, (String)localObject1, l2, i);
          AppMethodBeat.o(239605);
          return paramObject;
          localObject2 = paramObject.aahY;
          if (localObject2 == null)
          {
            i = 0;
            break;
          }
          i = ((fxe)localObject2).abMC;
          break;
          label530:
          paramObject = paramObject.aahY;
          if (paramObject == null) {
            i = 0;
          } else {
            i = paramObject.abME;
          }
        }
        break;
        localObject1 = paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239594);
      paramObject = (kotlin.d.d)new h(paramd);
      AppMethodBeat.o(239594);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239590);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239590);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.ofM;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (b.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(239590);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239590);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(String paramString, int paramInt, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239607);
      paramObject = (kotlin.d.d)new i(this.oad, paramInt, paramd);
      AppMethodBeat.o(239607);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239600);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239600);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (b.byJ().contains(this.oad)) {
          break label182;
        }
        Log.i("MicroMsg.Maas.CreationSameInfoHolder", "add " + this.oad + " to pool");
        b.byJ().add(this.oad);
        paramObject = b.ofM;
        String str = this.oad;
        int i = paramInt;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (b.a(paramObject, str, i, locald) == locala)
        {
          AppMethodBeat.o(239600);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      b.byK().remove(this.oad);
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(239600);
        return paramObject;
        label182:
        Log.i("MicroMsg.Maas.CreationSameInfoHolder", s.X(this.oad, " was added"));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    j(int paramInt, String paramString, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239608);
      paramObject = (kotlin.d.d)new j(this.ofW, paramString, paramd);
      AppMethodBeat.o(239608);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239601);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239601);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = b.ofM;
        int i = this.ofW;
        String str = paramString;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (b.a(paramObject, i, str, locald) == locala)
        {
          AppMethodBeat.o(239601);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(239601);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    k(b paramb, kotlin.d.d<? super k> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239595);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(this.ofV, null, 0, (kotlin.d.d)this);
      AppMethodBeat.o(239595);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.b.b
 * JD-Core Version:    0.7.0.1
 */