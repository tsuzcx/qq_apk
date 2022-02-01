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
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Fav.FavFinderLogic";
  public static final f qdY;
  
  static
  {
    AppMethodBeat.i(164109);
    qdY = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, ald paramald)
  {
    AppMethodBeat.i(164108);
    k.h(paramContext, "context");
    k.h(paramald, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", u.aqG());
    String str = paramald.objectId;
    k.g(str, "finderItem.objectId");
    localIntent.putExtra("feed_object_id", c.rc(str));
    localIntent.putExtra("feed_object_nonceId", paramald.objectNonceId);
    ((com.tencent.mm.plugin.i.a.j)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(164107);
    k.h(paramString, "toUser");
    if (paramg == null)
    {
      ad.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      ald localald = paramg.eCo();
      if (localald != null)
      {
        k.b localb = new k.b();
        b localb1 = new b();
        localb1.htg.objectId = localald.objectId;
        localb1.htg.objectNonceId = localald.objectNonceId;
        localb1.htg.Dmx = localald.Dmx;
        Object localObject2 = localb1.htg;
        Object localObject1 = localald.qDs;
        paramg = (com.tencent.mm.plugin.fav.a.g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((ald)localObject2).qDs = paramg;
        localb1.htg.nickname = localald.nickname;
        localb1.htg.desc = localald.desc;
        localb1.htg.did = localald.did;
        paramg = localb1.htg.mediaList;
        localObject1 = localald.mediaList;
        k.g(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          alc localalc1 = (alc)((Iterator)localObject2).next();
          alc localalc2 = new alc();
          localalc2.mediaType = localalc1.mediaType;
          localalc2.url = localalc1.url;
          localalc2.thumbUrl = localalc1.thumbUrl;
          localalc2.width = localalc1.width;
          localalc2.height = localalc1.height;
          ((Collection)localObject1).add(localalc2);
        }
        paramg.addAll((Collection)localObject1);
        localb.a((com.tencent.mm.ai.f)localb1);
        localb.type = 51;
        localb.title = aj.getContext().getString(2131760809);
        localb.url = aj.getContext().getString(2131760810);
        ad.i(TAG, "share finderObject %s to %s", new Object[] { localald.objectId, paramString });
        w.a.apB().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(164107);
        return;
      }
    }
    AppMethodBeat.o(164107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f
 * JD-Core Version:    0.7.0.1
 */