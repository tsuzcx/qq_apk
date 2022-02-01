package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.service.i;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "oplogCallbacks", "Ljava/util/Vector;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "canAddList", "", "getCache", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStr", "getTips", "fromPrivacySelect", "getTitleStrId", "", "needLoadMore", "onAddUserList", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "contacts", "onSearchBarClick", "", "context", "Landroid/content/Context;", "Companion", "plugin-finder_release"})
public final class c
  implements aj
{
  public static final a AdT;
  private Vector<com.tencent.mm.plugin.findersdk.a.aj<bep>> AdS;
  private final g zMR;
  
  static
  {
    AppMethodBeat.i(270422);
    AdT = new a((byte)0);
    AppMethodBeat.o(270422);
  }
  
  public c()
  {
    AppMethodBeat.i(270420);
    this.zMR = new g("blockPoster.fp");
    this.AdS = new Vector();
    AppMethodBeat.o(270420);
  }
  
  public final q a(final FinderContact paramFinderContact, final aj.a parama)
  {
    AppMethodBeat.i(270411);
    p.k(paramFinderContact, "contact");
    String str = paramFinderContact.username;
    if (str != null)
    {
      paramFinderContact = new b(this, parama, paramFinderContact);
      this.AdS.add(paramFinderContact);
      parama = (i)h.ae(i.class);
      p.j(str, "it");
      parama.a(str, false, (com.tencent.mm.plugin.findersdk.a.aj)paramFinderContact);
    }
    AppMethodBeat.o(270411);
    return null;
  }
  
  public final q d(b paramb)
  {
    AppMethodBeat.i(270413);
    paramb = (q)new av(paramb);
    AppMethodBeat.o(270413);
    return paramb;
  }
  
  public final g dRA()
  {
    return this.zMR;
  }
  
  public final LinkedList<FinderContact> dRB()
  {
    AppMethodBeat.i(270416);
    LinkedList localLinkedList = this.zMR.bvg();
    AppMethodBeat.o(270416);
    return localLinkedList;
  }
  
  public final boolean dRC()
  {
    return true;
  }
  
  public final CharSequence dRD()
  {
    AppMethodBeat.i(270418);
    Object localObject = MMApplicationContext.getContext().getString(b.j.finder_block_poster_empty);
    p.j(localObject, "MMApplicationContext.get…inder_block_poster_empty)");
    localObject = (CharSequence)localObject;
    AppMethodBeat.o(270418);
    return localObject;
  }
  
  public final int dRw()
  {
    return b.j.finder_account_black_list;
  }
  
  public final CharSequence dRx()
  {
    AppMethodBeat.i(270409);
    Object localObject = MMApplicationContext.getContext().getString(b.j.finder_mod_block_poster_sub_title);
    p.j(localObject, "MMApplicationContext.get…d_block_poster_sub_title)");
    localObject = (CharSequence)localObject;
    AppMethodBeat.o(270409);
    return localObject;
  }
  
  public final CharSequence dRy()
  {
    return null;
  }
  
  public final boolean dRz()
  {
    return false;
  }
  
  public final Set<q> eL(List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(270412);
    p.k(paramList, "contacts");
    AppMethodBeat.o(270412);
    return null;
  }
  
  public final q eM(List<String> paramList)
  {
    AppMethodBeat.i(270417);
    p.k(paramList, "nameList");
    AppMethodBeat.o(270417);
    return null;
  }
  
  public final void fD(Context paramContext)
  {
    AppMethodBeat.i(270410);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject;
    if (!(paramContext instanceof Activity)) {
      localObject = localIntent;
    }
    for (;;)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      try
      {
        localIntent.putExtra("request_type", 8);
        localIntent.putExtra("need_history", false);
        label56:
        localObject = a.ACH;
        a.a(paramContext, null, localIntent);
        AppMethodBeat.o(270410);
        return;
        localObject = null;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }
  
  public final b i(q paramq)
  {
    AppMethodBeat.i(270414);
    if (paramq == null)
    {
      paramq = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
      AppMethodBeat.o(270414);
      throw paramq;
    }
    paramq = ((av)paramq).dnU();
    if (paramq != null)
    {
      paramq = paramq.lastBuffer;
      AppMethodBeat.o(270414);
      return paramq;
    }
    AppMethodBeat.o(270414);
    return null;
  }
  
  public final LinkedList<FinderContact> j(q paramq)
  {
    AppMethodBeat.i(270415);
    if (paramq == null)
    {
      paramq = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
      AppMethodBeat.o(270415);
      throw paramq;
    }
    paramq = ((av)paramq).dnU();
    if (paramq != null)
    {
      paramq = paramq.SFU;
      AppMethodBeat.o(270415);
      return paramq;
    }
    AppMethodBeat.o(270415);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$onItemDelete$1$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.findersdk.a.aj<bep>
  {
    b(c paramc, aj.a parama, FinderContact paramFinderContact) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.c
 * JD-Core Version:    0.7.0.1
 */