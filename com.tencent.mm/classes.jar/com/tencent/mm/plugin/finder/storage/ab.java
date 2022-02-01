package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitle", "fromPrivacySelect", "getSubTitleStr", "getTips", "getTitleStrId", "", "needLoadMore", "onAddUserList", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "contacts", "onSearchBarClick", "", "context", "Landroid/content/Context;", "setContactFlag", "userName", "setFlag", "Companion", "plugin-finder_release"})
public final class ab
  implements aj
{
  public static final a Amh;
  
  static
  {
    AppMethodBeat.i(232157);
    Amh = new a((byte)0);
    AppMethodBeat.o(232157);
  }
  
  private static void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(232148);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(n.class);
    p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((n)locala).bbL().RG(paramString);
    if (paramString != null)
    {
      if (paramBoolean) {
        paramString.axJ();
      }
      for (;;)
      {
        locala = com.tencent.mm.kernel.h.ae(n.class);
        p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((n)locala).bbL().c(paramString.getUsername(), paramString);
        AppMethodBeat.o(232148);
        return;
        paramString.axK();
      }
    }
    AppMethodBeat.o(232148);
  }
  
  private static CharSequence qJ(boolean paramBoolean)
  {
    AppMethodBeat.i(232125);
    Object localObject1 = MMApplicationContext.getContext();
    String str = ((Context)localObject1).getString(b.j.finder_can_not_see_him_sns);
    p.j(str, "context.getString(R.stri…nder_can_not_see_him_sns)");
    Object localObject2 = ((Context)localObject1).getString(b.j.finder_like_feed_not_recommend, new Object[] { str });
    p.j(localObject2, "context.getString(R.stri…_recommend, subTitleLink)");
    localObject2 = new SpannableString((CharSequence)localObject2);
    p.j(localObject1, "context");
    ((SpannableString)localObject2).setSpan(new o(str, ((Context)localObject1).getResources().getColor(b.c.Link_80), ((Context)localObject1).getResources().getColor(b.c.transparent), false, false, (kotlin.g.a.b)new ab.b(paramBoolean, (Context)localObject1)), 0, str.length(), 17);
    localObject1 = (CharSequence)localObject2;
    AppMethodBeat.o(232125);
    return localObject1;
  }
  
  public final q a(FinderContact paramFinderContact, aj.a parama)
  {
    AppMethodBeat.i(232132);
    p.k(paramFinderContact, "contact");
    LinkedList localLinkedList = new LinkedList();
    Log.d("FinderNotSeeHimListConfig", "deleted user:" + paramFinderContact.username);
    paramFinderContact = paramFinderContact.username;
    if (paramFinderContact != null) {
      localLinkedList.add(paramFinderContact);
    }
    int i = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    paramFinderContact = com.tencent.mm.kernel.h.aHF();
    p.j(paramFinderContact, "MMKernel.network()");
    paramFinderContact.aGY().a(3990, (i)new e(parama));
    paramFinderContact = new com.tencent.mm.modelmulti.c((List)localLinkedList, 33554432, 2, i);
    com.tencent.mm.kernel.h.aGY().b((q)paramFinderContact);
    paramFinderContact = (q)paramFinderContact;
    AppMethodBeat.o(232132);
    return paramFinderContact;
  }
  
  public final q d(com.tencent.mm.cd.b paramb)
  {
    return null;
  }
  
  public final g dRA()
  {
    return null;
  }
  
  public final LinkedList<FinderContact> dRB()
  {
    AppMethodBeat.i(232141);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((n)localObject1).bbL().d(null, "", "@finder.block.his.liked.android", "", null);
    Object localObject2 = new StringBuilder("count = ");
    p.j(localObject1, "dataCursor");
    Log.i("FinderNotSeeHimListConfig", ((Cursor)localObject1).getCount());
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new as();
      ((as)localObject2).convertFrom((Cursor)localObject1);
      FinderContact localFinderContact = new FinderContact();
      localFinderContact.username = ((as)localObject2).getUsername();
      localLinkedList.add(localFinderContact);
    }
    AppMethodBeat.o(232141);
    return localLinkedList;
  }
  
  public final boolean dRC()
  {
    return false;
  }
  
  public final CharSequence dRD()
  {
    AppMethodBeat.i(232153);
    CharSequence localCharSequence = qJ(false);
    AppMethodBeat.o(232153);
    return localCharSequence;
  }
  
  public final int dRw()
  {
    return b.j.finder_not_see_he_like_feed;
  }
  
  public final CharSequence dRx()
  {
    AppMethodBeat.i(232119);
    CharSequence localCharSequence = qJ(false);
    AppMethodBeat.o(232119);
    return localCharSequence;
  }
  
  public final CharSequence dRy()
  {
    AppMethodBeat.i(232121);
    CharSequence localCharSequence = qJ(true);
    AppMethodBeat.o(232121);
    return localCharSequence;
  }
  
  public final boolean dRz()
  {
    return true;
  }
  
  public final Set<q> eL(List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(232131);
    p.k(paramList, "contacts");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = ((FinderContact)paramList.next()).username;
      if (localObject != null) {
        localLinkedList.add(localObject);
      }
    }
    int k = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    paramList = com.tencent.mm.kernel.h.aHF();
    p.j(paramList, "MMKernel.network()");
    paramList.aGY().a(3990, (i)new d());
    paramList = new HashSet();
    paramList.clear();
    int i = 0;
    while (i < localLinkedList.size())
    {
      localObject = new LinkedList();
      int j = 0;
      while ((i < localLinkedList.size()) && (j < k))
      {
        ((LinkedList)localObject).add(localLinkedList.get(j));
        i += 1;
        j += 1;
      }
      localObject = new com.tencent.mm.modelmulti.c((List)localLinkedList, 33554432, 2, k);
      com.tencent.mm.kernel.h.aGY().b((q)localObject);
      paramList.add(localObject);
    }
    paramList = (Set)paramList;
    AppMethodBeat.o(232131);
    return paramList;
  }
  
  public final q eM(final List<String> paramList)
  {
    AppMethodBeat.i(232145);
    p.k(paramList, "nameList");
    LinkedList localLinkedList = new LinkedList();
    Log.d("FinderNotSeeHimListConfig", "add user:" + paramList.size());
    localLinkedList.addAll((Collection)paramList);
    Object localObject = ((Iterable)localLinkedList).iterator();
    while (((Iterator)localObject).hasNext()) {
      bz((String)((Iterator)localObject).next(), true);
    }
    localObject = com.tencent.mm.kernel.h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3990, (i)new c(this, paramList));
    int i = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    paramList = new com.tencent.mm.modelmulti.c((List)localLinkedList, 33554432, 1, i);
    com.tencent.mm.kernel.h.aGY().b((q)paramList);
    paramList = (q)paramList;
    AppMethodBeat.o(232145);
    return paramList;
  }
  
  public final void fD(Context paramContext)
  {
    AppMethodBeat.i(232129);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.aG(paramContext, "@finder.block.his.liked.android");
    AppMethodBeat.o(232129);
  }
  
  public final com.tencent.mm.cd.b i(q paramq)
  {
    return null;
  }
  
  public final LinkedList<FinderContact> j(q paramq)
  {
    AppMethodBeat.i(232136);
    LinkedList localLinkedList = new LinkedList();
    if (paramq == null)
    {
      paramq = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetTagContact");
      AppMethodBeat.o(232136);
      throw paramq;
    }
    paramq = ((bu)paramq).dot();
    if (paramq != null)
    {
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        FinderContact localFinderContact = ((bkh)paramq.next()).contact;
        if (localFinderContact != null) {
          localLinkedList.add(localFinderContact);
        }
      }
    }
    AppMethodBeat.o(232136);
    return localLinkedList;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onAddUserList$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class c
    implements i
  {
    c(List paramList) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(283578);
      paramString = com.tencent.mm.kernel.h.aHF();
      p.j(paramString, "MMKernel.network()");
      paramString.aGY().b(3990, (i)this);
      if ((paramq instanceof com.tencent.mm.modelmulti.c))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.modelmulti.c)paramq).bnd();
          if (paramString != null)
          {
            paramString = paramString.RPN;
            if (paramString != null)
            {
              paramString = ((Iterable)paramString).iterator();
              while (paramString.hasNext())
              {
                paramq = ((cyd)paramString.next()).TGC.UserName;
                p.j(paramq, "it.ModOperation.UserName");
                ab.bA(paramq, true);
              }
              AppMethodBeat.o(283578);
              return;
            }
          }
          AppMethodBeat.o(283578);
          return;
        }
        paramString = ((Iterable)paramList).iterator();
        while (paramString.hasNext()) {
          ab.bA((String)paramString.next(), false);
        }
      }
      AppMethodBeat.o(283578);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onItemDelete$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class d
    implements i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(283724);
      paramString = com.tencent.mm.kernel.h.aHF();
      p.j(paramString, "MMKernel.network()");
      paramString.aGY().b(3990, (i)this);
      paramString = this.Aml;
      if (paramString != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.pX(bool);
          AppMethodBeat.o(283724);
          return;
        }
      }
      AppMethodBeat.o(283724);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onItemDelete$4", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class e
    implements i
  {
    e(aj.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(281970);
      paramString = com.tencent.mm.kernel.h.aHF();
      p.j(paramString, "MMKernel.network()");
      paramString.aGY().b(3990, (i)this);
      paramString = this.Aml;
      if (paramString != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.pX(bool);
          AppMethodBeat.o(281970);
          return;
        }
      }
      AppMethodBeat.o(281970);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ab
 * JD-Core Version:    0.7.0.1
 */