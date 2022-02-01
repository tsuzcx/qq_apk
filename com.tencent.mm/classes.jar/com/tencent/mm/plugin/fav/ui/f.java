package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Fav.FavFinderLogic";
  public static final f rwD;
  
  static
  {
    AppMethodBeat.i(164109);
    rwD = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, arj paramarj)
  {
    AppMethodBeat.i(164108);
    p.h(paramContext, "context");
    p.h(paramarj, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", u.aAm());
    String str = paramarj.objectId;
    p.g(str, "finderItem.objectId");
    localIntent.putExtra("feed_object_id", c.xh(str));
    localIntent.putExtra("feed_object_nonceId", paramarj.objectNonceId);
    ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(164107);
    p.h(paramString, "toUser");
    if (paramg == null)
    {
      ad.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      arj localarj = paramg.fgN();
      if (localarj != null)
      {
        k.b localb = new k.b();
        b localb1 = new b();
        localb1.inc.objectId = localarj.objectId;
        localb1.inc.objectNonceId = localarj.objectNonceId;
        localb1.inc.Gpi = localarj.Gpi;
        Object localObject2 = localb1.inc;
        Object localObject1 = localarj.sjU;
        paramg = (com.tencent.mm.plugin.fav.a.g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((arj)localObject2).sjU = paramg;
        localb1.inc.nickname = localarj.nickname;
        localb1.inc.desc = localarj.desc;
        localb1.inc.dqU = localarj.dqU;
        paramg = localb1.inc.mediaList;
        localObject1 = localarj.mediaList;
        p.g(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ari localari1 = (ari)((Iterator)localObject2).next();
          ari localari2 = new ari();
          localari2.mediaType = localari1.mediaType;
          localari2.url = localari1.url;
          localari2.thumbUrl = localari1.thumbUrl;
          localari2.width = localari1.width;
          localari2.height = localari1.height;
          ((Collection)localObject1).add(localari2);
        }
        paramg.addAll((Collection)localObject1);
        localb.a((com.tencent.mm.ai.f)localb1);
        localb.type = 51;
        localb.title = aj.getContext().getString(2131760809);
        localb.url = aj.getContext().getString(2131760810);
        ad.i(TAG, "share finderObject %s to %s", new Object[] { localarj.objectId, paramString });
        w.a.azd().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(164107);
        return;
      }
    }
    AppMethodBeat.o(164107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f
 * JD-Core Version:    0.7.0.1
 */