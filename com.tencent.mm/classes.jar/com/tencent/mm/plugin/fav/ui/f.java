package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Fav.FavFinderLogic";
  public static final f wKG;
  
  static
  {
    AppMethodBeat.i(164109);
    wKG = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, bje parambje)
  {
    AppMethodBeat.i(164108);
    p.k(paramContext, "context");
    p.k(parambje, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", z.bcZ());
    localIntent.putExtra("feed_object_id", d.Nb(parambje.objectId));
    localIntent.putExtra("feed_object_nonceId", parambje.objectNonceId);
    localIntent.putExtra("key_finder_teen_mode_check", true);
    localIntent.putExtra("key_finder_teen_mode_scene", 3);
    localIntent.putExtra("key_finder_teen_mode_user_name", parambje.nickname);
    localIntent.putExtra("key_finder_teen_mode_user_id", parambje.username);
    localIntent.putExtra("business_type", 0);
    localIntent.putExtra("finder_user_name", parambje.username);
    ((ak)h.ag(ak.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, g paramg)
  {
    AppMethodBeat.i(164107);
    p.k(paramString, "toUser");
    if (paramg == null)
    {
      Log.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      bje localbje = paramg.hpG();
      if (localbje != null)
      {
        k.b localb = new k.b();
        com.tencent.mm.plugin.findersdk.a.f localf = new com.tencent.mm.plugin.findersdk.a.f();
        localf.mbi.objectId = localbje.objectId;
        localf.mbi.objectNonceId = localbje.objectNonceId;
        localf.mbi.ACQ = localbje.ACQ;
        Object localObject2 = localf.mbi;
        Object localObject1 = localbje.avatar;
        paramg = (g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((bje)localObject2).avatar = paramg;
        localf.mbi.nickname = localbje.nickname;
        localf.mbi.desc = localbje.desc;
        localf.mbi.fCa = localbje.fCa;
        paramg = localf.mbi.mediaList;
        localObject1 = localbje.mediaList;
        p.j(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bjc localbjc1 = (bjc)((Iterator)localObject2).next();
          bjc localbjc2 = new bjc();
          localbjc2.mediaType = localbjc1.mediaType;
          localbjc2.url = localbjc1.url;
          localbjc2.thumbUrl = localbjc1.thumbUrl;
          localbjc2.width = localbjc1.width;
          localbjc2.height = localbjc1.height;
          ((Collection)localObject1).add(localbjc2);
        }
        paramg.addAll((Collection)localObject1);
        localb.a((com.tencent.mm.aj.f)localf);
        localb.type = 51;
        localb.title = MMApplicationContext.getContext().getString(s.i.low_version_upgrade_tip);
        localb.url = MMApplicationContext.getContext().getString(s.i.low_version_upgrade_url);
        Log.i(TAG, "share finderObject %s to %s", new Object[] { localbje.objectId, paramString });
        w.a.bbx().a(localb, "", "", paramString, "", null);
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