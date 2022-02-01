package com.tencent.mm.plugin.finder.storage.data;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.b.p;
import d.k;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "blackList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlackList", "()Ljava/util/ArrayList;", "setBlackList", "(Ljava/util/ArrayList;)V", "getBaseCachePath", "getCacheFilePath", "name", "getFileName", "onAlive", "", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "readCache", "refreshByBatchSetBlackList", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "refreshByGetTagContact", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "refreshDataFromNet", "saveCache", "Companion", "plugin-finder_release"})
public final class c
  implements com.tencent.mm.al.f
{
  private static final String TAG = "Finder.FinderBlackListCache";
  private static final d.f heM;
  public static final a szF;
  private ArrayList<String> jXb;
  
  static
  {
    AppMethodBeat.i(203798);
    szF = new a((byte)0);
    heM = d.g.a(k.MKa, (a)b.szG);
    TAG = "Finder.FinderBlackListCache";
    AppMethodBeat.o(203798);
  }
  
  private c()
  {
    AppMethodBeat.i(203797);
    this.jXb = new ArrayList();
    AppMethodBeat.o(203797);
  }
  
  private static String TH(String paramString)
  {
    AppMethodBeat.i(203788);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    paramString = localStringBuilder2.append(locale.ajh()).append("finder/black_list/").toString() + paramString;
    AppMethodBeat.o(203788);
    return paramString;
  }
  
  private final void ah(LinkedList<asa> paramLinkedList)
  {
    AppMethodBeat.i(203793);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("refreshByGetTagContact size ");
    if (paramLinkedList != null) {}
    for (Object localObject = Integer.valueOf(paramLinkedList.size());; localObject = null)
    {
      ad.d(str, localObject);
      this.jXb.clear();
      if (paramLinkedList == null) {
        break label114;
      }
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (asa)paramLinkedList.next();
        this.jXb.add(((asa)localObject).contact.username);
      }
    }
    AppMethodBeat.o(203793);
    return;
    label114:
    AppMethodBeat.o(203793);
  }
  
  private final void ai(LinkedList<bzr> paramLinkedList)
  {
    AppMethodBeat.i(203794);
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
        localObject = (bzr)paramLinkedList.next();
        switch (((bzr)localObject).GUI.GUH)
        {
        default: 
          break;
        case 1: 
          if (!this.jXb.contains(((bzr)localObject).GUI.nDo))
          {
            ad.d(TAG, "refreshByBatchSetBlackList add " + ((bzr)localObject).GUI.nDo);
            this.jXb.add(((bzr)localObject).GUI.nDo);
            continue;
            localObject = null;
          }
          break;
        case 2: 
          if (this.jXb.contains(((bzr)localObject).GUI.nDo))
          {
            ad.d(TAG, "refreshByBatchSetBlackList del " + ((bzr)localObject).GUI.nDo);
            this.jXb.remove(((bzr)localObject).GUI.nDo);
          }
          break;
        }
      }
      label242:
      AppMethodBeat.o(203794);
      return;
    }
    AppMethodBeat.o(203794);
  }
  
  public static void cJa()
  {
    AppMethodBeat.i(203792);
    Object localObject = aq.rJy;
    localObject = new aq(aq.cyu());
    com.tencent.mm.kernel.g.aiU().b((n)localObject);
    AppMethodBeat.o(203792);
  }
  
  private static String getFileName()
  {
    AppMethodBeat.i(203789);
    Object localObject = u.aAu();
    p.g(localObject, "finderUserName");
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203789);
      throw ((Throwable)localObject);
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.g(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = Base64.encodeToString((byte[])localObject, 0);
    p.g(localObject, "Base64.encodeToString(fi…eArray(), Base64.DEFAULT)");
    AppMethodBeat.o(203789);
    return localObject;
  }
  
  public final ArrayList<String> cJb()
  {
    AppMethodBeat.i(203795);
    if (this.jXb.isEmpty())
    {
      Object localObject = TH(getFileName());
      if (i.fv((String)localObject)) {
        try
        {
          localObject = bt.lO(i.aYq((String)localObject), ",");
          p.g(localObject, "Util.stringToList(content, \",\")");
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            ad.d(TAG, "read cahe:".concat(String.valueOf(str)));
            this.jXb.clear();
            this.jXb.add(str);
          }
          localArrayList = this.jXb;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace(TAG, (Throwable)localException, "read unlike cache file", new Object[0]);
        }
      }
    }
    ArrayList localArrayList;
    AppMethodBeat.o(203795);
    return localArrayList;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(203790);
    com.tencent.mm.kernel.g.aiU().a(3528, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.aiU().a(3990, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(203790);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(203791);
    com.tencent.mm.kernel.g.aiU().b(3528, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.aiU().b(3990, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(203791);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203796);
    if ((paramn instanceof aq))
    {
      ad.i(TAG, "NetSceneFinderGetTagContact errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((aq)paramn).rr.aEF();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTagContactResp");
          AppMethodBeat.o(203796);
          throw paramString;
        }
        ah(((aom)paramString).Gne);
      }
    }
    Charset localCharset;
    for (;;)
    {
      ad.d(TAG, "saveCache,size = " + this.jXb.size());
      paramn = bt.m((List)this.jXb, ",");
      paramString = TH(getFileName());
      p.g(paramn, "content");
      localCharset = d.UTF_8;
      if (paramn != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203796);
      throw paramString;
      if ((paramn instanceof y))
      {
        ad.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((y)paramn).rr.aEF();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchModContactTypeResponse");
            AppMethodBeat.o(203796);
            throw paramString;
          }
          ai(((kg)paramString).FCJ);
        }
      }
    }
    paramn = paramn.getBytes(localCharset);
    p.g(paramn, "(this as java.lang.String).getBytes(charset)");
    i.C(paramString, paramn);
    AppMethodBeat.o(203796);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "getInstance", "()Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"})
  public static final class a
  {
    public static c cJc()
    {
      AppMethodBeat.i(203787);
      Object localObject = c.ari();
      a locala = c.szF;
      localObject = (c)((d.f)localObject).getValue();
      AppMethodBeat.o(203787);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/data/FinderBlackListCache;", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<c>
  {
    public static final b szG;
    
    static
    {
      AppMethodBeat.i(203786);
      szG = new b();
      AppMethodBeat.o(203786);
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