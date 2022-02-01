package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bkh;>;
import java.util.List;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class d
  implements i
{
  public static final a AmR;
  private static final String TAG = "Finder.FinderBlackListCache";
  private static final kotlin.f kPd;
  private ArrayList<String> nXH;
  
  static
  {
    AppMethodBeat.i(285539);
    AmR = new a((byte)0);
    kPd = g.a(k.aazB, (a)b.AmS);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(285539);
  }
  
  private d()
  {
    AppMethodBeat.i(285538);
    this.nXH = new ArrayList();
    AppMethodBeat.o(285538);
  }
  
  private final void aP(LinkedList<bkh> paramLinkedList)
  {
    AppMethodBeat.i(285534);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("refreshByGetTagContact size ");
    if (paramLinkedList != null) {}
    for (Object localObject1 = Integer.valueOf(paramLinkedList.size());; localObject1 = null)
    {
      Log.d((String)localObject2, localObject1);
      this.nXH.clear();
      if (paramLinkedList == null) {
        break label135;
      }
      localObject2 = ((Iterable)paramLinkedList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramLinkedList = (bkh)((Iterator)localObject2).next();
        localObject3 = this.nXH;
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          localObject1 = paramLinkedList.username;
          paramLinkedList = (LinkedList<bkh>)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramLinkedList = "";
        }
        ((ArrayList)localObject3).add(paramLinkedList);
      }
    }
    AppMethodBeat.o(285534);
    return;
    label135:
    AppMethodBeat.o(285534);
  }
  
  private final void aQ(LinkedList<cyd> paramLinkedList)
  {
    AppMethodBeat.i(285535);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByBatchSetBlackList size ");
    Object localObject;
    if (paramLinkedList != null)
    {
      localObject = Integer.valueOf(paramLinkedList.size());
      Log.d(str, localObject);
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
        localObject = (cyd)paramLinkedList.next();
        switch (((cyd)localObject).TGC.TGB)
        {
        default: 
          break;
        case 1: 
          if (!this.nXH.contains(((cyd)localObject).TGC.UserName))
          {
            Log.d(TAG, "refreshByBatchSetBlackList add " + ((cyd)localObject).TGC.UserName);
            this.nXH.add(((cyd)localObject).TGC.UserName);
            continue;
            localObject = null;
          }
          break;
        case 2: 
          if (this.nXH.contains(((cyd)localObject).TGC.UserName))
          {
            Log.d(TAG, "refreshByBatchSetBlackList del " + ((cyd)localObject).TGC.UserName);
            this.nXH.remove(((cyd)localObject).TGC.UserName);
          }
          break;
        }
      }
      label242:
      AppMethodBeat.o(285535);
      return;
    }
    AppMethodBeat.o(285535);
  }
  
  private static String alY(String paramString)
  {
    AppMethodBeat.i(285529);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    paramString = localStringBuilder2.append(localf.aHl()).append("finder/black_list/").toString() + paramString;
    AppMethodBeat.o(285529);
    return paramString;
  }
  
  public static void dZm()
  {
    AppMethodBeat.i(285533);
    Object localObject = bu.xdi;
    localObject = new bu(bu.dou());
    h.aGY().b((com.tencent.mm.an.q)localObject);
    AppMethodBeat.o(285533);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(285530);
    Object localObject = z.bdh();
    p.j(localObject, "finderUserName");
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(285530);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.j(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    p.j(localObject, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(285530);
    return localObject;
  }
  
  public final ArrayList<String> dZn()
  {
    AppMethodBeat.i(285536);
    if (this.nXH.isEmpty())
    {
      Object localObject = alY(getFileName());
      if (u.agG((String)localObject)) {
        try
        {
          localObject = Util.stringToList(u.bBS((String)localObject), ",");
          p.j(localObject, "Util.stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            Log.d(TAG, "read cahe:".concat(String.valueOf(str)));
            this.nXH.clear();
            this.nXH.add(str);
          }
          localArrayList = this.nXH;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(285536);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(285531);
    h.aGY().a(3528, (i)this);
    h.aGY().a(3990, (i)this);
    AppMethodBeat.o(285531);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(285532);
    h.aGY().b(3528, (i)this);
    h.aGY().b(3990, (i)this);
    AppMethodBeat.o(285532);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(285537);
    if ((paramq instanceof bu))
    {
      Log.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        aP(((bu)paramq).dot());
      }
    }
    Charset localCharset;
    for (;;)
    {
      Log.d(TAG, "saveCache,size = " + this.nXH.size());
      paramq = Util.listToString((List)this.nXH, ",");
      paramString = alY(getFileName());
      p.j(paramq, "content");
      localCharset = kotlin.n.d.UTF_8;
      if (paramq != null) {
        break;
      }
      paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(285537);
      throw paramString;
      if ((paramq instanceof c))
      {
        Log.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          aQ(((c)paramq).bnd().RPN);
        }
      }
    }
    paramq = paramq.getBytes(localCharset);
    p.j(paramq, "(this as java.lang.String).getBytes(charset)");
    u.H(paramString, paramq);
    AppMethodBeat.o(285537);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
  public static final class a
  {
    public static d dZo()
    {
      AppMethodBeat.i(266871);
      Object localObject = d.aRW();
      a locala = d.AmR;
      localObject = (d)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(266871);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<d>
  {
    public static final b AmS;
    
    static
    {
      AppMethodBeat.i(291973);
      AmS = new b();
      AppMethodBeat.o(291973);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */