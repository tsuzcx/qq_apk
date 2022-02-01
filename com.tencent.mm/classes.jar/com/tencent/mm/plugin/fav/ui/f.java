package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/ui/FavFinderLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getAppMsgContent", "Lcom/tencent/mm/message/AppMessage$Content;", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "goFinderItem", "", "context", "Landroid/content/Context;", "finderItem", "sendFavFinderToConversation", "toUser", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "ui-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Ahd;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(164109);
    Ahd = new f();
    TAG = "MicroMsg.Fav.FavFinderLogic";
    AppMethodBeat.o(164109);
  }
  
  public static void a(Context paramContext, bvl parambvl)
  {
    AppMethodBeat.i(164108);
    s.u(paramContext, "context");
    s.u(parambvl, "finderItem");
    Intent localIntent = new Intent();
    localIntent.putExtra("report_scene", 4);
    localIntent.putExtra("from_user", z.bAM());
    localIntent.putExtra("feed_object_id", d.FK(parambvl.objectId));
    localIntent.putExtra("feed_object_nonceId", parambvl.objectNonceId);
    k.b localb = new k.b();
    com.tencent.mm.plugin.findersdk.a.f localf = new com.tencent.mm.plugin.findersdk.a.f();
    localf.c(parambvl);
    localb.a((com.tencent.mm.message.f)localf);
    localb.type = 51;
    localb.title = MMApplicationContext.getContext().getString(q.i.low_version_upgrade_tip);
    localb.url = MMApplicationContext.getContext().getString(q.i.low_version_upgrade_url);
    localIntent.putExtra("KEY_AUTHORIZATION_CONTENT", k.b.a(localb, null, null));
    localIntent.putExtra("key_finder_teen_mode_check", true);
    localIntent.putExtra("key_finder_teen_mode_scene", 3);
    localIntent.putExtra("key_finder_teen_mode_user_name", parambvl.nickname);
    localIntent.putExtra("key_finder_teen_mode_user_id", parambvl.username);
    localIntent.putExtra("business_type", 0);
    localIntent.putExtra("finder_user_name", parambvl.username);
    ((cn)h.az(cn.class)).enterFinderShareFeedUI(paramContext, localIntent);
    AppMethodBeat.o(164108);
  }
  
  public static void a(String paramString, g paramg)
  {
    AppMethodBeat.i(164107);
    s.u(paramString, "toUser");
    if (paramg == null)
    {
      Log.w(TAG, "item info is null, send fav url fail, return");
      AppMethodBeat.o(164107);
      return;
    }
    paramg = paramg.field_favProto;
    if (paramg != null)
    {
      bvl localbvl = paramg.ZAB;
      if (localbvl != null)
      {
        k.b localb = new k.b();
        com.tencent.mm.plugin.findersdk.a.f localf = new com.tencent.mm.plugin.findersdk.a.f();
        localf.oUc.objectId = localbvl.objectId;
        localf.oUc.objectNonceId = localbvl.objectNonceId;
        localf.oUc.GfT = localbvl.GfT;
        Object localObject2 = localf.oUc;
        Object localObject1 = localbvl.avatar;
        paramg = (g)localObject1;
        if (localObject1 == null) {
          paramg = "";
        }
        ((bvl)localObject2).avatar = paramg;
        localf.oUc.nickname = localbvl.nickname;
        localf.oUc.desc = localbvl.desc;
        localf.oUc.hGP = localbvl.hGP;
        paramg = localf.oUc.mediaList;
        localObject1 = localbvl.mediaList;
        s.s(localObject1, "favFeedItem.mediaList");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bvj localbvj1 = (bvj)((Iterator)localObject2).next();
          bvj localbvj2 = new bvj();
          localbvj2.mediaType = localbvj1.mediaType;
          localbvj2.url = localbvj1.url;
          localbvj2.thumbUrl = localbvj1.thumbUrl;
          localbvj2.width = localbvj1.width;
          localbvj2.height = localbvj1.height;
          ((Collection)localObject1).add(localbvj2);
        }
        paramg.addAll((Collection)localObject1);
        localf.oUc.mIK = localbvl.mIK;
        localf.oUc.aacV = localbvl.aacV;
        localf.oUc.hUQ = localbvl.hUQ;
        localf.oUc.aacW = localbvl.aacW;
        localb.a((com.tencent.mm.message.f)localf);
        localb.type = 51;
        localb.title = MMApplicationContext.getContext().getString(q.i.low_version_upgrade_tip);
        localb.url = MMApplicationContext.getContext().getString(q.i.low_version_upgrade_url);
        Log.i(TAG, "share finderObject %s to %s", new Object[] { localbvl.objectId, paramString });
        w.a.bwq().a(localb, "", "", paramString, "", null);
      }
    }
    AppMethodBeat.o(164107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.f
 * JD-Core Version:    0.7.0.1
 */