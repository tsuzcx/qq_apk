package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cs;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bxj;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.am.h
{
  public static final a FML;
  private static final String TAG;
  private static final j<d> nqI;
  private ArrayList<String> qXB;
  
  static
  {
    AppMethodBeat.i(339384);
    FML = new a((byte)0);
    nqI = k.a(o.aiuF, (a)b.FMM);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(339384);
  }
  
  private d()
  {
    AppMethodBeat.i(339356);
    this.qXB = new ArrayList();
    AppMethodBeat.o(339356);
  }
  
  private final void aW(LinkedList<bxj> paramLinkedList)
  {
    AppMethodBeat.i(339366);
    Object localObject2 = TAG;
    Object localObject1;
    label46:
    ArrayList localArrayList;
    if (paramLinkedList == null)
    {
      localObject1 = null;
      Log.d((String)localObject2, kotlin.g.b.s.X("refreshByGetTagContact size ", localObject1));
      this.qXB.clear();
      if (paramLinkedList == null) {
        break label121;
      }
      localObject2 = ((Iterable)paramLinkedList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label121;
      }
      paramLinkedList = (bxj)((Iterator)localObject2).next();
      localArrayList = this.qXB;
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList != null) {
        break label104;
      }
      paramLinkedList = "";
    }
    for (;;)
    {
      localArrayList.add(paramLinkedList);
      break label46;
      localObject1 = Integer.valueOf(paramLinkedList.size());
      break;
      label104:
      localObject1 = paramLinkedList.username;
      paramLinkedList = (LinkedList<bxj>)localObject1;
      if (localObject1 == null) {
        paramLinkedList = "";
      }
    }
    label121:
    AppMethodBeat.o(339366);
  }
  
  private final void aX(LinkedList<dpj> paramLinkedList)
  {
    AppMethodBeat.i(339372);
    String str = TAG;
    Object localObject;
    if (paramLinkedList == null)
    {
      localObject = null;
      Log.d(str, kotlin.g.b.s.X("refreshByBatchSetBlackList size ", localObject));
      if (paramLinkedList != null) {
        paramLinkedList = ((Iterable)paramLinkedList).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramLinkedList.hasNext()) {
          break label208;
        }
        localObject = (dpj)paramLinkedList.next();
        switch (((dpj)localObject).aaWj.aaWi)
        {
        default: 
          break;
        case 1: 
          if (!this.qXB.contains(((dpj)localObject).aaWj.UserName))
          {
            Log.d(TAG, kotlin.g.b.s.X("refreshByBatchSetBlackList add ", ((dpj)localObject).aaWj.UserName));
            this.qXB.add(((dpj)localObject).aaWj.UserName);
            continue;
            localObject = Integer.valueOf(paramLinkedList.size());
          }
          break;
        case 2: 
          if (this.qXB.contains(((dpj)localObject).aaWj.UserName))
          {
            Log.d(TAG, kotlin.g.b.s.X("refreshByBatchSetBlackList del ", ((dpj)localObject).aaWj.UserName));
            this.qXB.remove(((dpj)localObject).aaWj.UserName);
          }
          break;
        }
      }
    }
    label208:
    AppMethodBeat.o(339372);
  }
  
  private static String afg(String paramString)
  {
    AppMethodBeat.i(339349);
    paramString = kotlin.g.b.s.X(kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().cachePath, "finder/black_list/"), paramString);
    AppMethodBeat.o(339349);
    return paramString;
  }
  
  public static void eZV()
  {
    AppMethodBeat.i(339361);
    Object localObject = cs.ACD;
    localObject = new cs(cs.dWg());
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(339361);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(339353);
    Object localObject = z.bAW();
    kotlin.g.b.s.s(localObject, "finderUserName");
    localObject = ((String)localObject).getBytes(kotlin.n.d.UTF_8);
    kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    kotlin.g.b.s.s(localObject, "encodeToString(finderUse…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(339353);
    return localObject;
  }
  
  public final ArrayList<String> eZW()
  {
    AppMethodBeat.i(339396);
    if (this.qXB.isEmpty())
    {
      Object localObject = afg(getFileName());
      if (y.ZC((String)localObject)) {
        try
        {
          localObject = Util.stringToList(y.bEn((String)localObject), ",");
          kotlin.g.b.s.s(localObject, "stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            Log.d(TAG, kotlin.g.b.s.X("read cahe:", str));
            this.qXB.clear();
            this.qXB.add(str);
          }
          localArrayList = this.qXB;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(339396);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(339389);
    com.tencent.mm.kernel.h.aZW().a(3528, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3990, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(339389);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(339392);
    com.tencent.mm.kernel.h.aZW().b(3528, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3990, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(339392);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(339419);
    if ((paramp instanceof cs))
    {
      Log.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        aW(((cs)paramp).dWf());
      }
    }
    for (;;)
    {
      Log.d(TAG, kotlin.g.b.s.X("saveCache,size = ", Integer.valueOf(this.qXB.size())));
      paramp = Util.listToString((List)this.qXB, ",");
      paramString = afg(getFileName());
      kotlin.g.b.s.s(paramp, "content");
      paramp = paramp.getBytes(kotlin.n.d.UTF_8);
      kotlin.g.b.s.s(paramp, "(this as java.lang.String).getBytes(charset)");
      y.f(paramString, paramp, paramp.length);
      AppMethodBeat.o(339419);
      return;
      if ((paramp instanceof com.tencent.mm.modelmulti.h))
      {
        Log.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          aX(((com.tencent.mm.modelmulti.h)paramp).bKO().YNb);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d eZX()
    {
      AppMethodBeat.i(339364);
      d locald = (d)d.blL().getValue();
      AppMethodBeat.o(339364);
      return locald;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<d>
  {
    public static final b FMM;
    
    static
    {
      AppMethodBeat.i(339377);
      FMM = new b();
      AppMethodBeat.o(339377);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */