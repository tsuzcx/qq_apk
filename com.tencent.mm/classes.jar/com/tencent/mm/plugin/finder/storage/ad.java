package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.finder.cgi.br;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStrId", "getTitleStrId", "needLoadMore", "onAddUserList", "", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onSearchBarClick", "context", "Landroid/content/Context;", "setContactFlag", "userName", "setFlag", "Companion", "plugin-finder_release"})
public final class ad
  implements ak
{
  public static final a vES;
  
  static
  {
    AppMethodBeat.i(251838);
    vES = new a((byte)0);
    AppMethodBeat.o(251838);
  }
  
  private static void bu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(251837);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().Kn(paramString);
    if (paramString != null)
    {
      if (paramBoolean) {
        paramString.arj();
      }
      for (;;)
      {
        locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().c(paramString.getUsername(), paramString);
        AppMethodBeat.o(251837);
        return;
        paramString.ark();
      }
    }
    AppMethodBeat.o(251837);
  }
  
  public final void a(FinderContact paramFinderContact, ak.a parama)
  {
    AppMethodBeat.i(251833);
    p.h(paramFinderContact, "contact");
    LinkedList localLinkedList = new LinkedList();
    Log.d("FinderNotSeeHimListConfig", "deleted user:" + paramFinderContact.username);
    paramFinderContact = paramFinderContact.username;
    if (paramFinderContact != null) {
      localLinkedList.add(paramFinderContact);
    }
    int i = h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    paramFinderContact = com.tencent.mm.kernel.g.aAg();
    p.g(paramFinderContact, "MMKernel.network()");
    paramFinderContact.azz().a(3990, (i)new c(parama));
    paramFinderContact = new c((List)localLinkedList, 33554432, 2, i);
    com.tencent.mm.kernel.g.azz().b((q)paramFinderContact);
    AppMethodBeat.o(251833);
  }
  
  public final q c(com.tencent.mm.bw.b paramb)
  {
    return null;
  }
  
  public final int dql()
  {
    return 2131760351;
  }
  
  public final int dqm()
  {
    return -1;
  }
  
  public final boolean dqn()
  {
    return true;
  }
  
  public final com.tencent.mm.plugin.finder.storage.data.g dqo()
  {
    return null;
  }
  
  public final LinkedList<FinderContact> dqp()
  {
    AppMethodBeat.i(251835);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().d(null, "", "@finder.block.his.liked.android", "", null);
    Object localObject2 = new StringBuilder("count = ");
    p.g(localObject1, "dataCursor");
    Log.i("FinderNotSeeHimListConfig", ((Cursor)localObject1).getCount());
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new as();
      ((as)localObject2).convertFrom((Cursor)localObject1);
      FinderContact localFinderContact = new FinderContact();
      localFinderContact.username = ((as)localObject2).getUsername();
      localLinkedList.add(localFinderContact);
    }
    AppMethodBeat.o(251835);
    return localLinkedList;
  }
  
  public final boolean dqq()
  {
    return false;
  }
  
  public final int dqr()
  {
    return 2131759563;
  }
  
  public final void es(final List<String> paramList)
  {
    AppMethodBeat.i(251836);
    p.h(paramList, "nameList");
    LinkedList localLinkedList = new LinkedList();
    Log.d("FinderNotSeeHimListConfig", "add user:" + paramList.size());
    localLinkedList.addAll((Collection)paramList);
    Object localObject = ((Iterable)localLinkedList).iterator();
    while (((Iterator)localObject).hasNext()) {
      bu((String)((Iterator)localObject).next(), true);
    }
    localObject = com.tencent.mm.kernel.g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().a(3990, (i)new b(this, paramList));
    int i = h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    paramList = new c((List)localLinkedList, 33554432, 1, i);
    com.tencent.mm.kernel.g.azz().b((q)paramList);
    AppMethodBeat.o(251836);
  }
  
  public final void fq(Context paramContext)
  {
    AppMethodBeat.i(251832);
    p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.aE(paramContext, "@finder.block.his.liked.android");
    AppMethodBeat.o(251832);
  }
  
  public final com.tencent.mm.bw.b i(q paramq)
  {
    return null;
  }
  
  public final LinkedList<FinderContact> j(q paramq)
  {
    AppMethodBeat.i(251834);
    LinkedList localLinkedList = new LinkedList();
    if (paramq == null)
    {
      paramq = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetTagContact");
      AppMethodBeat.o(251834);
      throw paramq;
    }
    paramq = ((br)paramq).cYF();
    if (paramq != null)
    {
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        FinderContact localFinderContact = ((bdk)paramq.next()).contact;
        if (localFinderContact != null) {
          localLinkedList.add(localFinderContact);
        }
      }
    }
    AppMethodBeat.o(251834);
    return localLinkedList;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onAddUserList$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    implements i
  {
    b(List paramList) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(251830);
      paramString = com.tencent.mm.kernel.g.aAg();
      p.g(paramString, "MMKernel.network()");
      paramString.azz().b(3990, (i)this);
      if ((paramq instanceof c))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((c)paramq).bdI();
          if (paramString != null)
          {
            paramString = paramString.KOP;
            if (paramString != null)
            {
              paramString = ((Iterable)paramString).iterator();
              while (paramString.hasNext())
              {
                paramq = ((cpn)paramString.next()).MvE.UserName;
                p.g(paramq, "it.ModOperation.UserName");
                ad.avw(paramq);
              }
              AppMethodBeat.o(251830);
              return;
            }
          }
          AppMethodBeat.o(251830);
          return;
        }
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext()) {
          ad.avw((String)paramString.next());
        }
      }
      AppMethodBeat.o(251830);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onItemDelete$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class c
    implements i
  {
    c(ak.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(251831);
      paramString = com.tencent.mm.kernel.g.aAg();
      p.g(paramString, "MMKernel.network()");
      paramString.azz().b(3990, (i)this);
      paramString = this.vEV;
      if (paramString != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.nN(bool);
          AppMethodBeat.o(251831);
          return;
        }
      }
      AppMethodBeat.o(251831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ad
 * JD-Core Version:    0.7.0.1
 */