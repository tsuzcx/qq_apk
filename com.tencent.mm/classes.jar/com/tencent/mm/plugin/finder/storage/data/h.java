package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.a.a;
import d.g.b.w;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class h
  implements com.tencent.mm.al.g
{
  public static final a KXp;
  private static final String TAG = "Finder.FinderBlackListCache";
  private static final f gkk;
  private ArrayList<String> jcS;
  
  static
  {
    AppMethodBeat.i(199058);
    KXp = new a((byte)0);
    gkk = d.g.a(d.k.JfI, (a)b.KXq);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(199058);
  }
  
  private h()
  {
    AppMethodBeat.i(199057);
    this.jcS = new ArrayList();
    AppMethodBeat.o(199057);
  }
  
  private static String LW(String paramString)
  {
    AppMethodBeat.i(199048);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    paramString = localStringBuilder2.append(locale.aff()).append("finder/black_list/").toString() + paramString;
    AppMethodBeat.o(199048);
    return paramString;
  }
  
  private final void ak(LinkedList<dzu> paramLinkedList)
  {
    AppMethodBeat.i(199053);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByGetTagContact size ");
    if (paramLinkedList != null) {}
    for (Object localObject = Integer.valueOf(paramLinkedList.size());; localObject = null)
    {
      ad.d(str, localObject);
      this.jcS.clear();
      if (paramLinkedList == null) {
        break label114;
      }
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (dzu)paramLinkedList.next();
        this.jcS.add(((dzu)localObject).contact.username);
      }
    }
    AppMethodBeat.o(199053);
    return;
    label114:
    AppMethodBeat.o(199053);
  }
  
  private final void bn(LinkedList<bql> paramLinkedList)
  {
    AppMethodBeat.i(199054);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByBatchSetBlackList size ");
    Object localObject;
    if (paramLinkedList != null)
    {
      localObject = Integer.valueOf(paramLinkedList.size());
      ad.d(str, localObject);
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
        localObject = (bql)paramLinkedList.next();
        switch (((bql)localObject).DOJ.DOI)
        {
        default: 
          break;
        case 1: 
          if (!this.jcS.contains(((bql)localObject).DOJ.mAQ))
          {
            ad.d(TAG, "refreshByBatchSetBlackList add " + ((bql)localObject).DOJ.mAQ);
            this.jcS.add(((bql)localObject).DOJ.mAQ);
            continue;
            localObject = null;
          }
          break;
        case 2: 
          if (this.jcS.contains(((bql)localObject).DOJ.mAQ))
          {
            ad.d(TAG, "refreshByBatchSetBlackList del " + ((bql)localObject).DOJ.mAQ);
            this.jcS.remove(((bql)localObject).DOJ.mAQ);
          }
          break;
        }
      }
      label242:
      AppMethodBeat.o(199054);
      return;
    }
    AppMethodBeat.o(199054);
  }
  
  public static void fVc()
  {
    AppMethodBeat.i(199052);
    Object localObject = aw.KJM;
    localObject = new aw(aw.fSd());
    com.tencent.mm.kernel.g.aeS().b((n)localObject);
    AppMethodBeat.o(199052);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(199049);
    Object localObject = com.tencent.mm.model.u.aqO();
    d.g.b.k.g(localObject, "finderUserName");
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(199049);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).getBytes(localCharset);
    d.g.b.k.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    d.g.b.k.g(localObject, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(199049);
    return localObject;
  }
  
  public final ArrayList<String> fVd()
  {
    AppMethodBeat.i(199055);
    if (this.jcS.isEmpty())
    {
      Object localObject = LW(getFileName());
      if (i.eK((String)localObject)) {
        try
        {
          localObject = bt.kS(i.aMP((String)localObject), ",");
          d.g.b.k.g(localObject, "Util.stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            ad.d(TAG, "read cahe:".concat(String.valueOf(str)));
            this.jcS.clear();
            this.jcS.add(str);
          }
          localArrayList = this.jcS;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(199055);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(199050);
    com.tencent.mm.kernel.g.aeS().a(3528, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(3990, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(199050);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(199051);
    com.tencent.mm.kernel.g.aeS().b(3528, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3990, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(199051);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(199056);
    if ((paramn instanceof aw))
    {
      ad.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((aw)paramn).rr.auM();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTagContactResp");
          AppMethodBeat.o(199056);
          throw paramString;
        }
        ak(((dzc)paramString).DmI);
      }
    }
    Charset localCharset;
    for (;;)
    {
      ad.d(TAG, "saveCache,size = " + this.jcS.size());
      paramn = bt.n((List)this.jcS, ",");
      paramString = LW(getFileName());
      d.g.b.k.g(paramn, "content");
      localCharset = d.UTF_8;
      if (paramn != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(199056);
      throw paramString;
      if ((paramn instanceof ao))
      {
        ad.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((ao)paramn).rr.auM();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchModContactTypeResponse");
            AppMethodBeat.o(199056);
            throw paramString;
          }
          bn(((jr)paramString).CEN);
        }
      }
    }
    paramn = paramn.getBytes(localCharset);
    d.g.b.k.g(paramn, "(this as java.lang.String).getBytes(charset)");
    i.B(paramString, paramn);
    AppMethodBeat.o(199056);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(199046);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(a.class), "instance", "getInstance()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;")) };
      AppMethodBeat.o(199046);
    }
    
    public static h fVe()
    {
      AppMethodBeat.i(199047);
      Object localObject = h.ahu();
      a locala = h.KXp;
      localObject = (h)((f)localObject).getValue();
      AppMethodBeat.o(199047);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<h>
  {
    public static final b KXq;
    
    static
    {
      AppMethodBeat.i(199045);
      KXq = new b();
      AppMethodBeat.o(199045);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.h
 * JD-Core Version:    0.7.0.1
 */