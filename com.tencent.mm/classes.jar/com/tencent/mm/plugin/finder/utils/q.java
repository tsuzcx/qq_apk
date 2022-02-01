package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.ui.base.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderPrivateUtil;", "", "()V", "MMFinder_ModSticky_Err_Sticky_NotAllow_Private", "", "getMMFinder_ModSticky_Err_Sticky_NotAllow_Private", "()I", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "addPrivateMenuItem", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "mediaType", "PUBLIC_ID", "PRIVATE_ID", "ifPrivate", "", "disable", "changeFeedPrivacy", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setPrivate", "changeMegaVideoFeedPrivacy", "megaVideoId", "", "finderFeedId", "objectNonceId", "plugin-finder_release"})
public final class q
{
  private static final ai<ayy> tUo;
  private static final int vWa = -4052;
  public static final q vWb;
  
  static
  {
    AppMethodBeat.i(253475);
    vWb = new q();
    vWa = -4052;
    tUo = (ai)new a();
    AppMethodBeat.o(253475);
  }
  
  public static void a(final Context paramContext, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(253474);
    p.h(paramContext, "context");
    p.h(paramString, "objectNonceId");
    ((v)g.af(v.class)).b(paramLong2, null, paramString, paramBoolean, (ai)new b(paramLong1, paramBoolean, paramContext));
    AppMethodBeat.o(253474);
  }
  
  public static void a(Context paramContext, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(253473);
    p.h(paramContext, "context");
    p.h(paramFinderItem, "feed");
    ((v)g.af(v.class)).b(paramFinderItem.getId(), paramFinderItem.getFeedObject(), paramFinderItem.getObjectNonceId(), paramBoolean, tUo);
    AppMethodBeat.o(253473);
  }
  
  public static void a(m paramm, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(253471);
    p.h(paramm, "menu");
    p.h(paramContext, "context");
    if (paramBoolean1)
    {
      paramm.a(paramInt1, (CharSequence)paramContext.getString(2131760553), 2131690927, paramBoolean2);
      AppMethodBeat.o(253471);
      return;
    }
    paramm.a(paramInt2, (CharSequence)paramContext.getString(2131760551), 2131690827, paramBoolean2);
    AppMethodBeat.o(253471);
  }
  
  public static int dCb()
  {
    return vWa;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements ai<ayy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$changeMegaVideoFeedPrivacy$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements ai<ayy>
  {
    b(long paramLong, boolean paramBoolean, Context paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.q
 * JD-Core Version:    0.7.0.1
 */