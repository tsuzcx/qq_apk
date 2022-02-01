package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Fav.FavFinderLogic";
  public static final f teu;
  
  static
  {
    AppMethodBeat.i(164109);
    teu = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, bcj parambcj)
  {
    AppMethodBeat.i(164108);
    p.h(paramContext, "context");
    p.h(parambcj, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", z.aTY());
    localIntent.putExtra("feed_object_id", d.Ga(parambcj.objectId));
    localIntent.putExtra("feed_object_nonceId", parambcj.objectNonceId);
    localIntent.putExtra("key_finder_teen_mode_check", true);
    localIntent.putExtra("key_finder_teen_mode_scene", 3);
    localIntent.putExtra("key_finder_teen_mode_user_name", parambcj.nickname);
    localIntent.putExtra("key_finder_teen_mode_user_id", parambcj.username);
    localIntent.putExtra("business_type", 0);
    localIntent.putExtra("finder_user_name", parambcj.username);
    ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(164107);
    p.h(paramString, "toUser");
    if (paramg == null)
    {
      Log.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      bcj localbcj = paramg.guk();
      if (localbcj != null)
      {
        k.b localb = new k.b();
        com.tencent.mm.plugin.i.a.f localf = new com.tencent.mm.plugin.i.a.f();
        localf.jlg.objectId = localbcj.objectId;
        localf.jlg.objectNonceId = localbcj.objectNonceId;
        localf.jlg.vXJ = localbcj.vXJ;
        Object localObject2 = localf.jlg;
        Object localObject1 = localbcj.uNR;
        paramg = (com.tencent.mm.plugin.fav.a.g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((bcj)localObject2).uNR = paramg;
        localf.jlg.nickname = localbcj.nickname;
        localf.jlg.desc = localbcj.desc;
        localf.jlg.dJl = localbcj.dJl;
        paramg = localf.jlg.mediaList;
        localObject1 = localbcj.mediaList;
        p.g(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bch localbch1 = (bch)((Iterator)localObject2).next();
          bch localbch2 = new bch();
          localbch2.mediaType = localbch1.mediaType;
          localbch2.url = localbch1.url;
          localbch2.thumbUrl = localbch1.thumbUrl;
          localbch2.width = localbch1.width;
          localbch2.height = localbch1.height;
          ((Collection)localObject1).add(localbch2);
        }
        paramg.addAll((Collection)localObject1);
        localb.a((com.tencent.mm.ag.f)localf);
        localb.type = 51;
        localb.title = MMApplicationContext.getContext().getString(2131762562);
        localb.url = MMApplicationContext.getContext().getString(2131762563);
        Log.i(TAG, "share finderObject %s to %s", new Object[] { localbcj.objectId, paramString });
        w.a.aSz().a(localb, "", "", paramString, "", null);
        AppMethodBeat.o(164107);
        return;
      }
    }
    AppMethodBeat.o(164107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f
 * JD-Core Version:    0.7.0.1
 */