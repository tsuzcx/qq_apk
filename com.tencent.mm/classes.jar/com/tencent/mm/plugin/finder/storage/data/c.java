package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.a.a;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class c
  implements com.tencent.mm.ak.g
{
  private static final String TAG = "Finder.FinderBlackListCache";
  private static final f gKX;
  public static final c.a rEC;
  private ArrayList<String> jDf;
  
  static
  {
    AppMethodBeat.i(203022);
    rEC = new c.a((byte)0);
    gKX = d.g.a(d.k.KTc, (a)c.b.rED);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(203022);
  }
  
  private c()
  {
    AppMethodBeat.i(203021);
    this.jDf = new ArrayList();
    AppMethodBeat.o(203021);
  }
  
  private static String Qc(String paramString)
  {
    AppMethodBeat.i(203012);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    paramString = localStringBuilder2.append(locale.agv()).append("finder/black_list/").toString() + paramString;
    AppMethodBeat.o(203012);
    return paramString;
  }
  
  private final void af(LinkedList<aol> paramLinkedList)
  {
    AppMethodBeat.i(203017);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByGetTagContact size ");
    if (paramLinkedList != null) {}
    for (Object localObject = Integer.valueOf(paramLinkedList.size());; localObject = null)
    {
      ac.d(str, localObject);
      this.jDf.clear();
      if (paramLinkedList == null) {
        break label114;
      }
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (aol)paramLinkedList.next();
        this.jDf.add(((aol)localObject).contact.username);
      }
    }
    AppMethodBeat.o(203017);
    return;
    label114:
    AppMethodBeat.o(203017);
  }
  
  private final void ag(LinkedList<bvc> paramLinkedList)
  {
    AppMethodBeat.i(203018);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByBatchSetBlackList size ");
    Object localObject;
    if (paramLinkedList != null)
    {
      localObject = Integer.valueOf(paramLinkedList.size());
      ac.d(str, localObject);
      if (paramLinkedList != null) {
        paramLinkedList = ((Iterable)paramLinkedList).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramLinkedList.hasNext()) {
          break label242;
        }
        localObject = (bvc)paramLinkedList.next();
        switch (((bvc)localObject).Fla.FkZ)
        {
        default: 
          break;
        case 1: 
          if (!this.jDf.contains(((bvc)localObject).Fla.ncR))
          {
            ac.d(TAG, "refreshByBatchSetBlackList add " + ((bvc)localObject).Fla.ncR);
            this.jDf.add(((bvc)localObject).Fla.ncR);
            continue;
            localObject = null;
          }
          break;
        case 2: 
          if (this.jDf.contains(((bvc)localObject).Fla.ncR))
          {
            ac.d(TAG, "refreshByBatchSetBlackList del " + ((bvc)localObject).Fla.ncR);
            this.jDf.remove(((bvc)localObject).Fla.ncR);
          }
          break;
        }
      }
      label242:
      AppMethodBeat.o(203018);
      return;
    }
    AppMethodBeat.o(203018);
  }
  
  public static void cBa()
  {
    AppMethodBeat.i(203016);
    Object localObject = aj.qYm;
    localObject = new aj(aj.csD());
    com.tencent.mm.kernel.g.agi().b((n)localObject);
    AppMethodBeat.o(203016);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(203013);
    Object localObject = u.axE();
    d.g.b.k.g(localObject, "finderUserName");
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203013);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).getBytes(localCharset);
    d.g.b.k.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    d.g.b.k.g(localObject, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(203013);
    return localObject;
  }
  
  public final ArrayList<String> cBb()
  {
    AppMethodBeat.i(203019);
    if (this.jDf.isEmpty())
    {
      Object localObject = Qc(getFileName());
      if (i.eA((String)localObject)) {
        try
        {
          localObject = bs.lp(i.aSr((String)localObject), ",");
          d.g.b.k.g(localObject, "Util.stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            ac.d(TAG, "read cahe:".concat(String.valueOf(str)));
            this.jDf.clear();
            this.jDf.add(str);
          }
          localArrayList = this.jDf;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(203019);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(203014);
    com.tencent.mm.kernel.g.agi().a(3528, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(3990, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(203014);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(203015);
    com.tencent.mm.kernel.g.agi().b(3528, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3990, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(203015);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203020);
    if ((paramn instanceof aj))
    {
      ac.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((aj)paramn).rr.aBD();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTagContactResp");
          AppMethodBeat.o(203020);
          throw paramString;
        }
        af(((alh)paramString).EEY);
      }
    }
    Charset localCharset;
    for (;;)
    {
      ac.d(TAG, "saveCache,size = " + this.jDf.size());
      paramn = bs.n((List)this.jDf, ",");
      paramString = Qc(getFileName());
      d.g.b.k.g(paramn, "content");
      localCharset = d.UTF_8;
      if (paramn != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203020);
      throw paramString;
      if ((paramn instanceof t))
      {
        ac.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((t)paramn).rr.aBD();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchModContactTypeResponse");
            AppMethodBeat.o(203020);
            throw paramString;
          }
          ag(((jx)paramString).DXn);
        }
      }
    }
    paramn = paramn.getBytes(localCharset);
    d.g.b.k.g(paramn, "(this as java.lang.String).getBytes(charset)");
    i.B(paramString, paramn);
    AppMethodBeat.o(203020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.c
 * JD-Core Version:    0.7.0.1
 */