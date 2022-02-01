package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Fav.FavFinderLogic";
  public static final f rEP;
  
  static
  {
    AppMethodBeat.i(164109);
    rEP = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, ary paramary)
  {
    AppMethodBeat.i(164108);
    p.h(paramContext, "context");
    p.h(paramary, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", v.aAC());
    String str = paramary.objectId;
    p.g(str, "finderItem.objectId");
    localIntent.putExtra("feed_object_id", c.xQ(str));
    localIntent.putExtra("feed_object_nonceId", paramary.objectNonceId);
    ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(164107);
    p.h(paramString, "toUser");
    if (paramg == null)
    {
      ae.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      ary localary = paramg.fkE();
      if (localary != null)
      {
        k.b localb = new k.b();
        b localb1 = new b();
        localb1.ipW.objectId = localary.objectId;
        localb1.ipW.objectNonceId = localary.objectNonceId;
        localb1.ipW.GIy = localary.GIy;
        Object localObject2 = localb1.ipW;
        Object localObject1 = localary.ssR;
        paramg = (com.tencent.mm.plugin.fav.a.g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((ary)localObject2).ssR = paramg;
        localb1.ipW.nickname = localary.nickname;
        localb1.ipW.desc = localary.desc;
        localb1.ipW.drZ = localary.drZ;
        paramg = localb1.ipW.mediaList;
        localObject1 = localary.mediaList;
        p.g(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          arx localarx1 = (arx)((Iterator)localObject2).next();
          arx localarx2 = new arx();
          localarx2.mediaType = localarx1.mediaType;
          localarx2.url = localarx1.url;
          localarx2.thumbUrl = localarx1.thumbUrl;
          localarx2.width = localarx1.width;
          localarx2.height = localarx1.height;
          ((Collection)localObject1).add(localarx2);
        }
        paramg.addAll((Collection)localObject1);
        localb.a((com.tencent.mm.ah.f)localb1);
        localb.type = 51;
        localb.title = ak.getContext().getString(2131760809);
        localb.url = ak.getContext().getString(2131760810);
        ae.i(TAG, "share finderObject %s to %s", new Object[] { localary.objectId, paramString });
        w.a.azs().a(localb, "", "", paramString, "", null);
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