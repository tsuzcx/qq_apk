package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.finder.cgi.cs;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "context", "Landroid/content/Context;", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitle", "fromPrivacySelect", "getSubTitleStr", "getTips", "getTitleStrId", "", "needLoadMore", "onAddUserList", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "contacts", "onSearchBarClick", "", "setContactFlag", "userName", "setFlag", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements ar
{
  public static final a FMa;
  
  static
  {
    AppMethodBeat.i(339455);
    FMa = new a((byte)0);
    AppMethodBeat.o(339455);
  }
  
  private static CharSequence K(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(339433);
    String str = paramContext.getString(e.h.finder_can_not_see_him_sns);
    kotlin.g.b.s.s(str, "context.getString(R.stri…nder_can_not_see_him_sns)");
    Object localObject = paramContext.getString(e.h.finder_like_feed_not_recommend, new Object[] { str });
    kotlin.g.b.s.s(localObject, "context.getString(R.stri…_recommend, subTitleLink)");
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new q(str, paramContext.getResources().getColor(e.b.Link_80), paramContext.getResources().getColor(e.b.transparent), false, (kotlin.g.a.b)new ae.b(paramBoolean, paramContext)), 0, str.length(), 17);
    paramContext = (CharSequence)localObject;
    AppMethodBeat.o(339433);
    return paramContext;
  }
  
  private static void bP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(339441);
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label67;
      }
      paramString.aSl();
    }
    for (;;)
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(paramString.field_username, paramString);
      AppMethodBeat.o(339441);
      return;
      label67:
      paramString.aSm();
    }
  }
  
  public final p a(FinderContact paramFinderContact, ar.a parama)
  {
    AppMethodBeat.i(339497);
    kotlin.g.b.s.u(paramFinderContact, "contact");
    LinkedList localLinkedList = new LinkedList();
    Log.d("FinderNotSeeHimListConfig", kotlin.g.b.s.X("deleted user:", paramFinderContact.username));
    paramFinderContact = paramFinderContact.username;
    if (paramFinderContact != null) {
      localLinkedList.add(paramFinderContact);
    }
    int i = i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    com.tencent.mm.kernel.h.baD().mCm.a(3990, (com.tencent.mm.am.h)new e(parama));
    paramFinderContact = new com.tencent.mm.modelmulti.h((List)localLinkedList, 33554432, 2, i);
    com.tencent.mm.kernel.h.aZW().a((p)paramFinderContact, 0);
    paramFinderContact = (p)paramFinderContact;
    AppMethodBeat.o(339497);
    return paramFinderContact;
  }
  
  public final int ePJ()
  {
    return e.h.finder_not_see_he_like_feed;
  }
  
  public final boolean ePK()
  {
    return true;
  }
  
  public final g ePL()
  {
    return null;
  }
  
  public final LinkedList<FinderContact> ePM()
  {
    AppMethodBeat.i(339531);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(null, "", "@finder.block.his.liked.android", "", null);
    Log.i("FinderNotSeeHimListConfig", kotlin.g.b.s.X("count = ", Integer.valueOf(localCursor.getCount())));
    while (localCursor.moveToNext())
    {
      Object localObject = new au();
      ((au)localObject).convertFrom(localCursor);
      FinderContact localFinderContact = new FinderContact();
      localFinderContact.username = ((az)localObject).field_username;
      localObject = ah.aiuX;
      localLinkedList.add(localFinderContact);
    }
    AppMethodBeat.o(339531);
    return localLinkedList;
  }
  
  public final boolean ePN()
  {
    return false;
  }
  
  public final p g(com.tencent.mm.bx.b paramb)
  {
    return null;
  }
  
  public final CharSequence gR(Context paramContext)
  {
    AppMethodBeat.i(339465);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = K(paramContext, false);
    AppMethodBeat.o(339465);
    return paramContext;
  }
  
  public final CharSequence gS(Context paramContext)
  {
    AppMethodBeat.i(339472);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = K(paramContext, true);
    AppMethodBeat.o(339472);
    return paramContext;
  }
  
  public final void gT(Context paramContext)
  {
    AppMethodBeat.i(339481);
    kotlin.g.b.s.u(paramContext, "context");
    a locala = a.GfO;
    a.aI(paramContext, "@finder.block.his.liked.android");
    AppMethodBeat.o(339481);
  }
  
  public final CharSequence gU(Context paramContext)
  {
    AppMethodBeat.i(339554);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = K(paramContext, false);
    AppMethodBeat.o(339554);
    return paramContext;
  }
  
  public final Set<p> hx(List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(339490);
    kotlin.g.b.s.u(paramList, "contacts");
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
    int k = i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    com.tencent.mm.kernel.h.baD().mCm.a(3990, (com.tencent.mm.am.h)new d());
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
        j += 1;
        i += 1;
      }
      localObject = new com.tencent.mm.modelmulti.h((List)localLinkedList, 33554432, 2, k);
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
      paramList.add(localObject);
    }
    paramList = (Set)paramList;
    AppMethodBeat.o(339490);
    return paramList;
  }
  
  public final p hy(List<String> paramList)
  {
    AppMethodBeat.i(339543);
    kotlin.g.b.s.u(paramList, "nameList");
    LinkedList localLinkedList = new LinkedList();
    Log.d("FinderNotSeeHimListConfig", kotlin.g.b.s.X("add user:", Integer.valueOf(paramList.size())));
    localLinkedList.addAll((Collection)paramList);
    Iterator localIterator = ((Iterable)localLinkedList).iterator();
    while (localIterator.hasNext()) {
      bP((String)localIterator.next(), true);
    }
    com.tencent.mm.kernel.h.baD().mCm.a(3990, (com.tencent.mm.am.h)new c(paramList, this));
    int i = i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    paramList = new com.tencent.mm.modelmulti.h((List)localLinkedList, 33554432, 1, i);
    com.tencent.mm.kernel.h.aZW().a((p)paramList, 0);
    paramList = (p)paramList;
    AppMethodBeat.o(339543);
    return paramList;
  }
  
  public final com.tencent.mm.bx.b i(p paramp)
  {
    return null;
  }
  
  public final LinkedList<FinderContact> j(p paramp)
  {
    AppMethodBeat.i(339515);
    LinkedList localLinkedList = new LinkedList();
    if (paramp == null)
    {
      paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetTagContact");
      AppMethodBeat.o(339515);
      throw paramp;
    }
    paramp = ((cs)paramp).dWf();
    if (paramp != null)
    {
      paramp = ((Iterable)paramp).iterator();
      while (paramp.hasNext())
      {
        FinderContact localFinderContact = ((bxj)paramp.next()).contact;
        if (localFinderContact != null) {
          localLinkedList.add(localFinderContact);
        }
      }
    }
    AppMethodBeat.o(339515);
    return localLinkedList;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onAddUserList$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.am.h
  {
    c(List<String> paramList, ae paramae) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(338910);
      com.tencent.mm.kernel.h.baD().mCm.b(3990, (com.tencent.mm.am.h)this);
      if ((paramp instanceof com.tencent.mm.modelmulti.h)) {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.modelmulti.h)paramp).bKO();
          if (paramString != null)
          {
            paramString = paramString.YNb;
            if (paramString != null)
            {
              paramString = ((Iterable)paramString).iterator();
              while (paramString.hasNext())
              {
                paramp = ((dpj)paramString.next()).aaWj.UserName;
                kotlin.g.b.s.s(paramp, "it.ModOperation.UserName");
                ae.bQ(paramp, true);
              }
              AppMethodBeat.o(338910);
            }
          }
        }
        else
        {
          paramString = ((Iterable)this.FMc).iterator();
          while (paramString.hasNext()) {
            ae.bQ((String)paramString.next(), false);
          }
        }
      }
      AppMethodBeat.o(338910);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onItemDelete$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.am.h
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(338901);
      com.tencent.mm.kernel.h.baD().mCm.b(3990, (com.tencent.mm.am.h)this);
      paramString = this.FAw;
      if (paramString != null) {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label55;
        }
      }
      label55:
      for (boolean bool = true;; bool = false)
      {
        paramString.tb(bool);
        AppMethodBeat.o(338901);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderNotSeeHimListConfig$onItemDelete$4", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.am.h
  {
    e(ar.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(338891);
      com.tencent.mm.kernel.h.baD().mCm.b(3990, (com.tencent.mm.am.h)this);
      paramString = this.FAw;
      if (paramString != null) {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label55;
        }
      }
      label55:
      for (boolean bool = true;; bool = false)
      {
        paramString.tb(bool);
        AppMethodBeat.o(338891);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ae
 * JD-Core Version:    0.7.0.1
 */