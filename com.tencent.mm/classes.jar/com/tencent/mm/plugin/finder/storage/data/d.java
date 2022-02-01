package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.plugin.finder.cgi.br;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdk;>;
import java.util.List;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class d
  implements i
{
  private static final String TAG = "Finder.FinderBlackListCache";
  private static final f iax;
  public static final a vFS;
  private ArrayList<String> ldu;
  
  static
  {
    AppMethodBeat.i(251966);
    vFS = new a((byte)0);
    iax = kotlin.g.a(k.SWP, (a)b.vFT);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(251966);
  }
  
  private d()
  {
    AppMethodBeat.i(251965);
    this.ldu = new ArrayList();
    AppMethodBeat.o(251965);
  }
  
  private static String aee(String paramString)
  {
    AppMethodBeat.i(251956);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    paramString = localStringBuilder2.append(locale.azM()).append("finder/black_list/").toString() + paramString;
    AppMethodBeat.o(251956);
    return paramString;
  }
  
  private final void ay(LinkedList<bdk> paramLinkedList)
  {
    AppMethodBeat.i(251961);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("refreshByGetTagContact size ");
    if (paramLinkedList != null) {}
    for (Object localObject1 = Integer.valueOf(paramLinkedList.size());; localObject1 = null)
    {
      Log.d((String)localObject2, localObject1);
      this.ldu.clear();
      if (paramLinkedList == null) {
        break label135;
      }
      localObject2 = ((Iterable)paramLinkedList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramLinkedList = (bdk)((Iterator)localObject2).next();
        localObject3 = this.ldu;
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          localObject1 = paramLinkedList.username;
          paramLinkedList = (LinkedList<bdk>)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramLinkedList = "";
        }
        ((ArrayList)localObject3).add(paramLinkedList);
      }
    }
    AppMethodBeat.o(251961);
    return;
    label135:
    AppMethodBeat.o(251961);
  }
  
  private final void az(LinkedList<cpn> paramLinkedList)
  {
    AppMethodBeat.i(251962);
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
        localObject = (cpn)paramLinkedList.next();
        switch (((cpn)localObject).MvE.MvD)
        {
        default: 
          break;
        case 1: 
          if (!this.ldu.contains(((cpn)localObject).MvE.UserName))
          {
            Log.d(TAG, "refreshByBatchSetBlackList add " + ((cpn)localObject).MvE.UserName);
            this.ldu.add(((cpn)localObject).MvE.UserName);
            continue;
            localObject = null;
          }
          break;
        case 2: 
          if (this.ldu.contains(((cpn)localObject).MvE.UserName))
          {
            Log.d(TAG, "refreshByBatchSetBlackList del " + ((cpn)localObject).MvE.UserName);
            this.ldu.remove(((cpn)localObject).MvE.UserName);
          }
          break;
        }
      }
      label242:
      AppMethodBeat.o(251962);
      return;
    }
    AppMethodBeat.o(251962);
  }
  
  public static void dyu()
  {
    AppMethodBeat.i(251960);
    Object localObject = br.tvA;
    localObject = new br(br.cYG());
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localObject);
    AppMethodBeat.o(251960);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(251957);
    Object localObject = z.aUg();
    p.g(localObject, "finderUserName");
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251957);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    p.g(localObject, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(251957);
    return localObject;
  }
  
  public final ArrayList<String> dyv()
  {
    AppMethodBeat.i(251963);
    if (this.ldu.isEmpty())
    {
      Object localObject = aee(getFileName());
      if (s.YS((String)localObject)) {
        try
        {
          localObject = Util.stringToList(s.boY((String)localObject), ",");
          p.g(localObject, "Util.stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            Log.d(TAG, "read cahe:".concat(String.valueOf(str)));
            this.ldu.clear();
            this.ldu.add(str);
          }
          localArrayList = this.ldu;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(251963);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(251958);
    com.tencent.mm.kernel.g.azz().a(3528, (i)this);
    com.tencent.mm.kernel.g.azz().a(3990, (i)this);
    AppMethodBeat.o(251958);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(251959);
    com.tencent.mm.kernel.g.azz().b(3528, (i)this);
    com.tencent.mm.kernel.g.azz().b(3990, (i)this);
    AppMethodBeat.o(251959);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(251964);
    if ((paramq instanceof br))
    {
      Log.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        ay(((br)paramq).cYF());
      }
    }
    Charset localCharset;
    for (;;)
    {
      Log.d(TAG, "saveCache,size = " + this.ldu.size());
      paramq = Util.listToString((List)this.ldu, ",");
      paramString = aee(getFileName());
      p.g(paramq, "content");
      localCharset = kotlin.n.d.UTF_8;
      if (paramq != null) {
        break;
      }
      paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251964);
      throw paramString;
      if ((paramq instanceof c))
      {
        Log.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          az(((c)paramq).bdI().KOP);
        }
      }
    }
    paramq = paramq.getBytes(localCharset);
    p.g(paramq, "(this as java.lang.String).getBytes(charset)");
    s.C(paramString, paramq);
    AppMethodBeat.o(251964);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
  public static final class a
  {
    public static d dyw()
    {
      AppMethodBeat.i(251955);
      Object localObject = d.aJW();
      a locala = d.vFS;
      localObject = (d)((f)localObject).getValue();
      AppMethodBeat.o(251955);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<d>
  {
    public static final b vFT;
    
    static
    {
      AppMethodBeat.i(251954);
      vFT = new b();
      AppMethodBeat.o(251954);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */