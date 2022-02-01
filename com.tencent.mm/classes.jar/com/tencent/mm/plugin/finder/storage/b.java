package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.protocal.protobuf.ayu;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "()V", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "canAddList", "", "getCache", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStrId", "getTitleStrId", "needLoadMore", "onAddUserList", "", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onSearchBarClick", "context", "Landroid/content/Context;", "Companion", "plugin-finder_release"})
public final class b
  implements ak
{
  public static final a vwr;
  private final com.tencent.mm.plugin.finder.storage.data.g uWD;
  
  static
  {
    AppMethodBeat.i(251522);
    vwr = new a((byte)0);
    AppMethodBeat.o(251522);
  }
  
  public b()
  {
    AppMethodBeat.i(251521);
    this.uWD = new com.tencent.mm.plugin.finder.storage.data.g("blockPoster.fp");
    AppMethodBeat.o(251521);
  }
  
  public final void a(final FinderContact paramFinderContact, ak.a parama)
  {
    AppMethodBeat.i(251515);
    p.h(paramFinderContact, "contact");
    String str = paramFinderContact.username;
    if (str != null)
    {
      r localr = (r)com.tencent.mm.kernel.g.af(r.class);
      p.g(str, "it");
      localr.a(str, false, (ai)new b(parama, paramFinderContact));
      AppMethodBeat.o(251515);
      return;
    }
    AppMethodBeat.o(251515);
  }
  
  public final q c(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(251516);
    paramb = (q)new as(paramb);
    AppMethodBeat.o(251516);
    return paramb;
  }
  
  public final int dql()
  {
    return 2131759479;
  }
  
  public final int dqm()
  {
    return 2131760271;
  }
  
  public final boolean dqn()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.storage.data.g dqo()
  {
    return this.uWD;
  }
  
  public final LinkedList<FinderContact> dqp()
  {
    AppMethodBeat.i(251519);
    LinkedList localLinkedList = this.uWD.blq();
    AppMethodBeat.o(251519);
    return localLinkedList;
  }
  
  public final boolean dqq()
  {
    return true;
  }
  
  public final int dqr()
  {
    return 2131759565;
  }
  
  public final void es(List<String> paramList)
  {
    AppMethodBeat.i(251520);
    p.h(paramList, "nameList");
    AppMethodBeat.o(251520);
  }
  
  public final void fq(Context paramContext)
  {
    AppMethodBeat.i(251514);
    p.h(paramContext, "context");
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
        localObject = a.vUU;
        a.a(paramContext, null, localIntent);
        AppMethodBeat.o(251514);
        return;
        localObject = null;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }
  
  public final com.tencent.mm.bw.b i(q paramq)
  {
    AppMethodBeat.i(251517);
    if (paramq == null)
    {
      paramq = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
      AppMethodBeat.o(251517);
      throw paramq;
    }
    paramq = ((as)paramq).cYd();
    if (paramq != null)
    {
      paramq = paramq.lastBuffer;
      AppMethodBeat.o(251517);
      return paramq;
    }
    AppMethodBeat.o(251517);
    return null;
  }
  
  public final LinkedList<FinderContact> j(q paramq)
  {
    AppMethodBeat.i(251518);
    if (paramq == null)
    {
      paramq = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneBlockPosterList");
      AppMethodBeat.o(251518);
      throw paramq;
    }
    paramq = ((as)paramq).cYd();
    if (paramq != null)
    {
      paramq = paramq.LCI;
      AppMethodBeat.o(251518);
      return paramq;
    }
    AppMethodBeat.o(251518);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderBlockPosterConfig$onItemDelete$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements ai<ayu>
  {
    b(ak.a parama, FinderContact paramFinderContact) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */