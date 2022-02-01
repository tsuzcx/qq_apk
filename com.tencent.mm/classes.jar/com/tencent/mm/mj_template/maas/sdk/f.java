package com.tencent.mm.mj_template.maas.sdk;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jo;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.a.a;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResMgr;", "", "()V", "BinFileName", "", "ConfigFileName", "SdkCompatVersion", "", "SoFileName", "TAG", "isLoaded", "", "resEventListener", "com/tencent/mm/mj_template/maas/sdk/MaasSdkResMgr$resEventListener$1", "Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResMgr$resEventListener$1;", "resLock", "Ljava/util/concurrent/locks/ReentrantLock;", "soFilePath", "getSoFilePath", "()Ljava/lang/String;", "soLock", "checkMergeBin", "", "checkMergeBinNoLock", "checkSoSha1Async", "destroy", "findCompatibleChain", "Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfigChain;", "configList", "", "Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfig;", "startIndex", "getSha1", "filePath", "init", "isValid", "loadSdk", "loadSdkNoLock", "mergeBin", "chain", "unzipRes", "subtype", "path", "unzipResNoLock", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final String TAG;
  public static final int Ue;
  public static final f obN;
  public static boolean obO;
  private static final ReentrantLock obP;
  private static final ReentrantLock obQ;
  public static final MaasSdkResMgr.resEventListener.1 obR;
  
  static
  {
    AppMethodBeat.i(240185);
    obN = new f();
    TAG = "MicroMsg.MaasSdkResMgr";
    obP = new ReentrantLock();
    obQ = new ReentrantLock();
    obR = new MaasSdkResMgr.resEventListener.1(com.tencent.mm.app.f.hfK);
    Ue = 8;
    AppMethodBeat.o(240185);
  }
  
  private static String HL(String paramString)
  {
    AppMethodBeat.i(240153);
    try
    {
      long l = Util.nowMilliSecond();
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      if (y.ZC(paramString))
      {
        Object localObject1 = new byte[4096];
        paramString = (Closeable)y.Lh(paramString);
        try
        {
          InputStream localInputStream = (InputStream)paramString;
          for (int i = localInputStream.read((byte[])localObject1); i > 0; i = localInputStream.read((byte[])localObject1)) {
            localMessageDigest.update((byte[])localObject1, 0, i);
          }
          localObject1 = ah.aiuX;
          kotlin.f.b.a(paramString, null);
          paramString = localMessageDigest.digest();
          Log.i(TAG, s.X("getSha1: cost ", Long.valueOf(Util.milliSecondsToNow(l))));
          paramString = Util.encodeHexString(paramString);
          AppMethodBeat.o(240153);
          return paramString;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(240153);
            throw localThrowable;
          }
          finally
          {
            kotlin.f.b.a(paramString, localThrowable);
            AppMethodBeat.o(240153);
          }
        }
      }
      return null;
    }
    finally
    {
      Log.printErrStackTrace(TAG, paramString, "getSha1 error", new Object[0]);
      AppMethodBeat.o(240153);
    }
  }
  
  public static boolean N(int paramInt, String paramString)
  {
    AppMethodBeat.i(240145);
    obP.lock();
    for (;;)
    {
      Object localObject1;
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = com.tencent.mm.mj_template.maas.b.d.obB;
        localObject1 = com.tencent.mm.mj_template.maas.b.d.uM(paramInt);
        if (paramString == null)
        {
          Log.w(TAG, "unzipRes: path is null");
          com.tencent.mm.mj_template.maas.b.e.a((jo)localObject1, false);
          bool = false;
          return bool;
        }
        localObject2 = e.obI;
        localObject2 = e.bxO();
        y.ew((String)localObject2, true);
        y.bDX((String)localObject2);
        int i = y.aA(paramString, (String)localObject2);
        if (i != 0)
        {
          Log.w(TAG, s.X("unzipRes: unzip failed ", Integer.valueOf(i)));
          continue;
        }
        localObject3 = s.X((String)localObject2, "/config.json");
      }
      finally
      {
        obP.unlock();
        AppMethodBeat.o(240145);
      }
      Object localObject3;
      paramString = new c();
      Object localObject4 = com.tencent.mm.sticker.a.acBM;
      a.a.a((String)localObject3, (com.tencent.mm.sticker.a)paramString);
      if (!paramString.isValid())
      {
        Log.w(TAG, s.X("unzipRes: config is invalid ", paramString));
      }
      else
      {
        ((jo)localObject1).iUm = paramString.obC;
        ((jo)localObject1).iUr = paramString.obD;
        ((jo)localObject1).sn(paramString.obF);
        if (Util.isEqual(HL(s.X((String)localObject2, "/bin")), paramString.obF))
        {
          localObject3 = new StringBuilder();
          localObject4 = e.obI;
          localObject3 = e.bxN() + '/' + paramInt;
          y.ew((String)localObject3, true);
          localObject4 = e.obI;
          y.bDX(e.bxN());
          y.qo((String)localObject2, (String)localObject3);
          if (paramString.axM())
          {
            paramString = g.obV;
            g.bxX().putLong("KEY_RES_UPDATE_TIME", System.currentTimeMillis());
          }
          com.tencent.mm.mj_template.maas.b.e.a((jo)localObject1, true);
          bool = true;
        }
      }
    }
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(240117);
    Object localObject1 = g.obV;
    g.bxX().putLong("KEY_SDK_UPDATE_TIME", System.currentTimeMillis());
    g.bxX().putInt("KEY_SDK_LOAD_START", 0);
    g.bxX().putInt("KEY_SDK_LOAD_END", 0);
    localObject1 = e.obI;
    y.ew(e.bxP(), true);
    localObject1 = e.obI;
    y.bDX(e.bxP());
    localObject1 = e.obI;
    Object localObject2 = s.X(e.bxP(), "/libMaasSDK.so");
    String str = s.X((String)localObject2, "_temp");
    Iterator localIterator = ((Iterable)paramd.obH).iterator();
    localObject1 = null;
    label378:
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localObject1 = new StringBuilder();
      e locale = e.obI;
      localObject1 = e.bxN() + '/' + localc.subtype + "/bin";
      if (localc.obD != localc.obE) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.i(TAG, s.X("mergeBin: base ", localc));
        y.O((String)localObject1, (String)localObject2, false);
        localObject1 = HL((String)localObject2);
        if (s.p(localObject1, localc.obG)) {
          break label378;
        }
        y.deleteFile((String)localObject2);
        AppMethodBeat.o(240117);
        return false;
      }
      i = b.a(new File((String)localObject2), new File(str), new File((String)localObject1));
      Log.i(TAG, "mergeBin: patch ret=" + i + ' ' + localc);
      if (i == 1)
      {
        localObject1 = HL(str);
        Log.i(TAG, s.X("mergeBin: patch sha1=", localObject1));
        if (Util.isEqual((String)localObject1, localc.obG))
        {
          y.qn(str, (String)localObject2);
        }
        else
        {
          AppMethodBeat.o(240117);
          return false;
        }
      }
      else
      {
        AppMethodBeat.o(240117);
        return false;
      }
    }
    localObject2 = g.obV;
    int i = paramd.bxM();
    g.bxX().putInt("KEY_SDK_COMPAT_VERSION", i);
    localObject2 = g.obV;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    s.u(localObject2, "sha1");
    g.bxX().putString("KEY_SDK_SHA1", (String)localObject2);
    localObject1 = g.obV;
    paramd = ((Iterable)paramd.obH).iterator();
    if (!paramd.hasNext())
    {
      paramd = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(240117);
      throw paramd;
    }
    i = ((c)paramd.next()).obD;
    while (paramd.hasNext())
    {
      int j = ((c)paramd.next()).obD;
      if (i < j) {
        i = j;
      }
    }
    g.bxX().putInt("KEY_SDK_RES_VERSION", i);
    Log.i(TAG, "mergeBin: merge end");
    bxU();
    AppMethodBeat.o(240117);
    return true;
  }
  
  private static String bxQ()
  {
    AppMethodBeat.i(240083);
    Object localObject = e.obI;
    localObject = s.X(e.bxP(), "/libMaasSDK.so");
    AppMethodBeat.o(240083);
    return localObject;
  }
  
  private final void bxS()
  {
    boolean bool2 = false;
    AppMethodBeat.i(240100);
    Object localObject1 = g.obV;
    boolean bool1 = g.bxY();
    localObject1 = g.obV;
    int i = g.bxM();
    boolean bool3 = y.ZC(bxQ());
    localObject1 = TAG;
    Object localObject2 = new StringBuilder("mergeBin: need update ").append(bool1).append(", ").append(i).append(", target version 10100003, currentSha1:");
    Object localObject3 = g.obV;
    Log.i((String)localObject1, g.byb() + ", file:" + bool3);
    if ((!bool1) && (i == 10100003) && (bool3))
    {
      AppMethodBeat.o(240100);
      return;
    }
    localObject1 = com.tencent.mm.mj_template.maas.b.d.obB;
    localObject1 = com.tencent.mm.mj_template.maas.b.d.bxK();
    localObject3 = new SparseArray();
    localObject2 = new ArrayList();
    Object localObject4 = e.obI;
    localObject4 = y.eB(e.bxN(), false);
    if (localObject4 != null)
    {
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (j)((Iterator)localObject4).next();
        i = Util.getInt(((j)localObject5).name, -1);
        if (i >= 0)
        {
          Object localObject6 = new StringBuilder();
          Object localObject7 = e.obI;
          localObject5 = e.bxN() + '/' + ((j)localObject5).name + "/config.json";
          localObject6 = new c();
          localObject7 = com.tencent.mm.sticker.a.acBM;
          a.a.a((String)localObject5, (com.tencent.mm.sticker.a)localObject6);
          if (((c)localObject6).isValid())
          {
            ((c)localObject6).subtype = i;
            ((ArrayList)localObject2).add(localObject6);
            ((SparseArray)localObject3).put(i, localObject6);
          }
        }
      }
    }
    localObject3 = (List)localObject2;
    if (((List)localObject3).size() > 1) {
      p.a((List)localObject3, (Comparator)new a());
    }
    Log.i(TAG, s.X("mergeBin: list ", p.a((Iterable)localObject2, null, null, null, 0, null, (kotlin.g.a.b)b.obS, 31)));
    localObject2 = m((List)localObject2, 0);
    bool1 = bool2;
    if (localObject2 != null)
    {
      bool1 = bool2;
      if (((d)localObject2).axM())
      {
        bool1 = bool2;
        if (((d)localObject2).obH.size() > 0) {
          bool1 = true;
        }
      }
    }
    com.tencent.mm.mj_template.maas.b.e.a((jo)localObject1, bool1);
    if ((bool1) && (localObject2 != null))
    {
      localObject1 = com.tencent.mm.mj_template.maas.b.d.obB;
      localObject1 = com.tencent.mm.mj_template.maas.b.d.bxL();
      bool1 = a((d)localObject2);
      com.tencent.mm.mj_template.maas.b.e.a((jo)localObject1, bool1);
      if (!bool1)
      {
        localObject1 = e.obI;
        y.ew(e.bxP(), true);
      }
    }
    AppMethodBeat.o(240100);
  }
  
  public static void bxU()
  {
    AppMethodBeat.i(240122);
    com.tencent.mm.ae.d.B((kotlin.g.a.a)c.obT);
    AppMethodBeat.o(240122);
  }
  
  private static d m(List<c> paramList, int paramInt)
  {
    AppMethodBeat.i(240131);
    Log.i(TAG, s.X("findCompatibleChain: from ", Integer.valueOf(paramInt)));
    d locald = new d();
    int m = paramList.size();
    int i;
    Object localObject1;
    if (paramInt < m)
    {
      i = -1;
      localObject1 = null;
    }
    for (;;)
    {
      int k = paramInt + 1;
      c localc = (c)paramList.get(paramInt);
      int j;
      Object localObject2;
      if (localObject1 == null)
      {
        if (!localc.axM()) {
          break label288;
        }
        j = paramInt;
        localObject2 = localc;
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          locald.obH.add(localObject2);
          if (((c)localObject2).obE == ((c)localObject2).obD)
          {
            p.oJ((List)locald.obH);
            Log.i(TAG, "findCompatibleChain: find index:[" + j + ", " + paramInt + "], subtype:[" + p.a((Iterable)locald.obH, null, null, null, 0, null, (kotlin.g.a.b)d.obU, 31) + ']');
            AppMethodBeat.o(240131);
            return locald;
            localObject2 = localc;
            j = i;
            if (localc.obD == localObject1.obE) {
              continue;
            }
            Log.w(TAG, "findCompatibleChain: version error " + localc.obD + ", " + localObject1.obE);
            paramInt = i + 1;
            break;
          }
        }
        if (k < m) {
          break label297;
        }
        AppMethodBeat.o(240131);
        return null;
        label288:
        localObject2 = localObject1;
        j = i;
      }
      label297:
      localObject1 = localObject2;
      paramInt = k;
      i = j;
    }
  }
  
  public final void bxR()
  {
    AppMethodBeat.i(240190);
    obP.lock();
    obQ.lock();
    try
    {
      boolean bool = obO;
      if (bool) {
        return;
      }
      bxS();
      return;
    }
    finally
    {
      obP.unlock();
      obQ.unlock();
      AppMethodBeat.o(240190);
    }
  }
  
  public final boolean bxT()
  {
    boolean bool2 = true;
    AppMethodBeat.i(240201);
    obQ.lock();
    for (;;)
    {
      try
      {
        if (!BuildInfo.IS_ARM64)
        {
          Log.w(TAG, "load sdk only arm64");
          bool1 = false;
          return bool1;
        }
        Boolean localBoolean = com.tencent.mm.mj_template.plugin.a.ocw;
        s.s(localBoolean, "MAAS_IN_PKG");
        if (localBoolean.booleanValue())
        {
          Log.i(TAG, "maas in pkg");
          obO = true;
          k.load("MaasSDK");
          bool1 = bool2;
          continue;
        }
        Log.i(TAG, s.X("loadSdk: isLoaded:", Boolean.valueOf(obO)));
      }
      finally
      {
        obQ.unlock();
        AppMethodBeat.o(240201);
      }
      boolean bool1 = bool2;
      if (!obO)
      {
        bxR();
        Object localObject2 = com.tencent.mm.mj_template.maas.b.d.obB;
        localObject2 = com.tencent.mm.mj_template.maas.b.d.bxJ();
        Object localObject3 = g.obV;
        int i = g.bxZ() - g.bya();
        localObject3 = g.obV;
        ((jo)localObject2).iUm = g.bxM();
        ((jo)localObject2).iUq = i;
        localObject3 = g.obV;
        ((jo)localObject2).iUr = g.bxX().getInt("KEY_SDK_RES_VERSION", 0);
        localObject3 = g.obV;
        ((jo)localObject2).sn(g.byb());
        localObject3 = g.obV;
        int j = g.bxM();
        Log.i(TAG, "loadSdk: load fail count:" + i + "; compat version " + j);
        if (i > 1)
        {
          com.tencent.mm.mj_template.maas.b.e.a((jo)localObject2, false);
        }
        else if (j != 10100003)
        {
          com.tencent.mm.mj_template.maas.b.e.a((jo)localObject2, false);
        }
        else if (y.ZC(bxQ()))
        {
          Log.i(TAG, "loadSdk: start");
          obO = true;
          localObject3 = g.obV;
          i = g.bxZ();
          g.bxX().putInt("KEY_SDK_LOAD_START", i + 1);
          localObject3 = e.obI;
          k.Dz(e.bxP());
          k.load("MaasSDK");
          localObject3 = g.obV;
          i = g.bya();
          g.bxX().putInt("KEY_SDK_LOAD_END", i + 1);
          Log.i(TAG, "loadSdk: end");
          com.tencent.mm.mj_template.maas.b.e.a((jo)localObject2, true);
          bool1 = bool2;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(240115);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((c)paramT2).subtype), (Comparable)Integer.valueOf(((c)paramT1).subtype));
      AppMethodBeat.o(240115);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<c, CharSequence>
  {
    public static final b obS;
    
    static
    {
      AppMethodBeat.i(240087);
      obS = new b();
      AppMethodBeat.o(240087);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final c obT;
    
    static
    {
      AppMethodBeat.i(240085);
      obT = new c();
      AppMethodBeat.o(240085);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<c, CharSequence>
  {
    public static final d obU;
    
    static
    {
      AppMethodBeat.i(240091);
      obU = new d();
      AppMethodBeat.o(240091);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.f
 * JD-Core Version:    0.7.0.1
 */