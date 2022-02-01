package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.a.a;
import d.g.b.p;
import d.k;
import d.l;
import d.n.d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.asp;>;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class c
  implements com.tencent.mm.ak.f
{
  private static final String TAG = "Finder.FinderBlackListCache";
  private static final d.f hhA;
  public static final a sKz;
  private ArrayList<String> kaq;
  
  static
  {
    AppMethodBeat.i(204382);
    sKz = new a((byte)0);
    hhA = d.g.a(k.Nhd, (a)b.sKA);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(204382);
  }
  
  private c()
  {
    AppMethodBeat.i(204381);
    this.kaq = new ArrayList();
    AppMethodBeat.o(204381);
  }
  
  private static String Uq(String paramString)
  {
    AppMethodBeat.i(204372);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    paramString = localStringBuilder2.append(locale.ajw()).append("finder/black_list/").toString() + paramString;
    AppMethodBeat.o(204372);
    return paramString;
  }
  
  private final void ah(LinkedList<asp> paramLinkedList)
  {
    AppMethodBeat.i(204377);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("refreshByGetTagContact size ");
    if (paramLinkedList != null) {}
    for (Object localObject1 = Integer.valueOf(paramLinkedList.size());; localObject1 = null)
    {
      ae.d((String)localObject2, localObject1);
      this.kaq.clear();
      if (paramLinkedList == null) {
        break label135;
      }
      localObject2 = ((Iterable)paramLinkedList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramLinkedList = (asp)((Iterator)localObject2).next();
        localObject3 = this.kaq;
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          localObject1 = paramLinkedList.username;
          paramLinkedList = (LinkedList<asp>)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramLinkedList = "";
        }
        ((ArrayList)localObject3).add(paramLinkedList);
      }
    }
    AppMethodBeat.o(204377);
    return;
    label135:
    AppMethodBeat.o(204377);
  }
  
  private final void ai(LinkedList<cal> paramLinkedList)
  {
    AppMethodBeat.i(204378);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByBatchSetBlackList size ");
    Object localObject;
    if (paramLinkedList != null)
    {
      localObject = Integer.valueOf(paramLinkedList.size());
      ae.d(str, localObject);
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
        localObject = (cal)paramLinkedList.next();
        switch (((cal)localObject).Hoj.Hoi)
        {
        default: 
          break;
        case 1: 
          if (!this.kaq.contains(((cal)localObject).Hoj.nIJ))
          {
            ae.d(TAG, "refreshByBatchSetBlackList add " + ((cal)localObject).Hoj.nIJ);
            this.kaq.add(((cal)localObject).Hoj.nIJ);
            continue;
            localObject = null;
          }
          break;
        case 2: 
          if (this.kaq.contains(((cal)localObject).Hoj.nIJ))
          {
            ae.d(TAG, "refreshByBatchSetBlackList del " + ((cal)localObject).Hoj.nIJ);
            this.kaq.remove(((cal)localObject).Hoj.nIJ);
          }
          break;
        }
      }
      label242:
      AppMethodBeat.o(204378);
      return;
    }
    AppMethodBeat.o(204378);
  }
  
  public static void cLC()
  {
    AppMethodBeat.i(204376);
    Object localObject = ar.rRM;
    localObject = new ar(ar.czV());
    com.tencent.mm.kernel.g.ajj().b((n)localObject);
    AppMethodBeat.o(204376);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(204373);
    Object localObject = com.tencent.mm.model.v.aAK();
    p.g(localObject, "finderUserName");
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(204373);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    p.g(localObject, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(204373);
    return localObject;
  }
  
  public final ArrayList<String> cLD()
  {
    AppMethodBeat.i(204379);
    if (this.kaq.isEmpty())
    {
      Object localObject = Uq(getFileName());
      if (o.fB((String)localObject)) {
        try
        {
          localObject = bu.lV(o.aZT((String)localObject), ",");
          p.g(localObject, "Util.stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            ae.d(TAG, "read cahe:".concat(String.valueOf(str)));
            this.kaq.clear();
            this.kaq.add(str);
          }
          localArrayList = this.kaq;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(204379);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(204374);
    com.tencent.mm.kernel.g.ajj().a(3528, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().a(3990, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(204374);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(204375);
    com.tencent.mm.kernel.g.ajj().b(3528, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().b(3990, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(204375);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(204380);
    if ((paramn instanceof ar))
    {
      ae.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((ar)paramn).rr.aEV();
        if (paramString == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTagContactResp");
          AppMethodBeat.o(204380);
          throw paramString;
        }
        ah(((aoz)paramString).GGk);
      }
    }
    Charset localCharset;
    for (;;)
    {
      ae.d(TAG, "saveCache,size = " + this.kaq.size());
      paramn = bu.m((List)this.kaq, ",");
      paramString = Uq(getFileName());
      p.g(paramn, "content");
      localCharset = d.UTF_8;
      if (paramn != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(204380);
      throw paramString;
      if ((paramn instanceof z))
      {
        ae.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((z)paramn).rr.aEV();
          if (paramString == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchModContactTypeResponse");
            AppMethodBeat.o(204380);
            throw paramString;
          }
          ai(((kg)paramString).FVe);
        }
      }
    }
    paramn = paramn.getBytes(localCharset);
    p.g(paramn, "(this as java.lang.String).getBytes(charset)");
    o.C(paramString, paramn);
    AppMethodBeat.o(204380);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
  public static final class a
  {
    public static c cLE()
    {
      AppMethodBeat.i(204371);
      Object localObject = c.arx();
      a locala = c.sKz;
      localObject = (c)((d.f)localObject).getValue();
      AppMethodBeat.o(204371);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<c>
  {
    public static final b sKA;
    
    static
    {
      AppMethodBeat.i(204370);
      sKA = new b();
      AppMethodBeat.o(204370);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.c
 * JD-Core Version:    0.7.0.1
 */