package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.bq;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.service.n;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "oplogCallbacks", "Ljava/util/Vector;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "canAddList", "", "getCache", "getEmptyTips", "", "context", "Landroid/content/Context;", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStr", "getTips", "fromPrivacySelect", "getTitleStrId", "", "needLoadMore", "onAddUserList", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "contacts", "onSearchBarClick", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements ar
{
  public static final a FAt;
  private final g EXF;
  private Vector<ck<bpq>> FAu;
  
  static
  {
    AppMethodBeat.i(339190);
    FAt = new a((byte)0);
    AppMethodBeat.o(339190);
  }
  
  public c()
  {
    AppMethodBeat.i(339181);
    this.EXF = new g("blockPoster.fp");
    this.FAu = new Vector();
    AppMethodBeat.o(339181);
  }
  
  public final p a(final FinderContact paramFinderContact, final ar.a parama)
  {
    AppMethodBeat.i(339213);
    s.u(paramFinderContact, "contact");
    String str = paramFinderContact.username;
    if (str != null)
    {
      paramFinderContact = new b(this, parama, paramFinderContact);
      this.FAu.add(paramFinderContact);
      ((n)h.ax(n.class)).a(str, false, (ck)paramFinderContact);
    }
    AppMethodBeat.o(339213);
    return null;
  }
  
  public final int ePJ()
  {
    return e.h.finder_account_black_list;
  }
  
  public final boolean ePK()
  {
    return false;
  }
  
  public final g ePL()
  {
    return this.EXF;
  }
  
  public final LinkedList<FinderContact> ePM()
  {
    AppMethodBeat.i(339248);
    LinkedList localLinkedList = this.EXF.bTt();
    AppMethodBeat.o(339248);
    return localLinkedList;
  }
  
  public final boolean ePN()
  {
    return true;
  }
  
  public final p g(b paramb)
  {
    AppMethodBeat.i(339228);
    paramb = (p)new bq(paramb);
    AppMethodBeat.o(339228);
    return paramb;
  }
  
  public final CharSequence gR(Context paramContext)
  {
    AppMethodBeat.i(339199);
    s.u(paramContext, "context");
    paramContext = MMApplicationContext.getContext().getString(e.h.finder_mod_block_poster_sub_title);
    s.s(paramContext, "getContext().getString(R…d_block_poster_sub_title)");
    paramContext = (CharSequence)paramContext;
    AppMethodBeat.o(339199);
    return paramContext;
  }
  
  public final CharSequence gS(Context paramContext)
  {
    AppMethodBeat.i(339202);
    s.u(paramContext, "context");
    AppMethodBeat.o(339202);
    return null;
  }
  
  public final void gT(Context paramContext)
  {
    AppMethodBeat.i(339210);
    s.u(paramContext, "context");
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
        localObject = a.GfO;
        a.a(paramContext, null, localIntent);
        AppMethodBeat.o(339210);
        return;
        localObject = null;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }
  
  public final CharSequence gU(Context paramContext)
  {
    AppMethodBeat.i(339260);
    s.u(paramContext, "context");
    paramContext = MMApplicationContext.getContext().getString(e.h.finder_block_poster_empty);
    s.s(paramContext, "getContext().getString(R…inder_block_poster_empty)");
    paramContext = (CharSequence)paramContext;
    AppMethodBeat.o(339260);
    return paramContext;
  }
  
  public final Set<p> hx(List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(339221);
    s.u(paramList, "contacts");
    AppMethodBeat.o(339221);
    return null;
  }
  
  public final p hy(List<String> paramList)
  {
    AppMethodBeat.i(339253);
    s.u(paramList, "nameList");
    AppMethodBeat.o(339253);
    return null;
  }
  
  public final b i(p paramp)
  {
    AppMethodBeat.i(339233);
    if (paramp == null)
    {
      paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
      AppMethodBeat.o(339233);
      throw paramp;
    }
    paramp = ((bq)paramp).dVB();
    if (paramp == null)
    {
      AppMethodBeat.o(339233);
      return null;
    }
    paramp = paramp.lastBuffer;
    AppMethodBeat.o(339233);
    return paramp;
  }
  
  public final LinkedList<FinderContact> j(p paramp)
  {
    AppMethodBeat.i(339239);
    if (paramp == null)
    {
      paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
      AppMethodBeat.o(339239);
      throw paramp;
    }
    paramp = ((bq)paramp).dVB();
    if (paramp == null)
    {
      AppMethodBeat.o(339239);
      return null;
    }
    paramp = paramp.ZIt;
    AppMethodBeat.o(339239);
    return paramp;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$onItemDelete$1$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ck<bpq>
  {
    b(c paramc, ar.a parama, FinderContact paramFinderContact) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.c
 * JD-Core Version:    0.7.0.1
 */