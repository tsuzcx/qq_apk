package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.a.j;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Fav.FavFinderLogic";
  public static final f qMB;
  
  static
  {
    AppMethodBeat.i(164109);
    qMB = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, anx paramanx)
  {
    AppMethodBeat.i(164108);
    k.h(paramContext, "context");
    k.h(paramanx, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", u.axw());
    String str = paramanx.objectId;
    k.g(str, "finderItem.objectId");
    localIntent.putExtra("feed_object_id", c.ur(str));
    localIntent.putExtra("feed_object_nonceId", paramanx.objectNonceId);
    ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(164107);
    k.h(paramString, "toUser");
    if (paramg == null)
    {
      ac.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      anx localanx = paramg.eRJ();
      if (localanx != null)
      {
        k.b localb = new k.b();
        b localb1 = new b();
        localb1.hTI.objectId = localanx.objectId;
        localb1.hTI.objectNonceId = localanx.objectNonceId;
        localb1.hTI.EGJ = localanx.EGJ;
        Object localObject2 = localb1.hTI;
        Object localObject1 = localanx.ruB;
        paramg = (com.tencent.mm.plugin.fav.a.g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((anx)localObject2).ruB = paramg;
        localb1.hTI.nickname = localanx.nickname;
        localb1.hTI.desc = localanx.desc;
        localb1.hTI.dfy = localanx.dfy;
        paramg = localb1.hTI.mediaList;
        localObject1 = localanx.mediaList;
        k.g(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          anw localanw1 = (anw)((Iterator)localObject2).next();
          anw localanw2 = new anw();
          localanw2.mediaType = localanw1.mediaType;
          localanw2.url = localanw1.url;
          localanw2.thumbUrl = localanw1.thumbUrl;
          localanw2.width = localanw1.width;
          localanw2.height = localanw1.height;
          ((Collection)localObject1).add(localanw2);
        }
        paramg.addAll((Collection)localObject1);
        localb.a((com.tencent.mm.ah.f)localb1);
        localb.type = 51;
        localb.title = ai.getContext().getString(2131760809);
        localb.url = ai.getContext().getString(2131760810);
        ac.i(TAG, "share finderObject %s to %s", new Object[] { localanx.objectId, paramString });
        w.a.awq().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(164107);
        return;
      }
    }
    AppMethodBeat.o(164107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f
 * JD-Core Version:    0.7.0.1
 */