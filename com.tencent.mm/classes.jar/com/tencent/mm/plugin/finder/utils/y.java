package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w.b;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderPrivateUtil;", "", "()V", "MMFinder_ModSticky_Err_Sticky_NotAllow_Private", "", "getMMFinder_ModSticky_Err_Sticky_NotAllow_Private", "()I", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "addPrivateMenuItem", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "mediaType", "PUBLIC_ID", "PRIVATE_ID", "ifPrivate", "", "disable", "changeFeedPrivacy", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setPrivate", "changeMegaVideoFeedPrivacy", "megaVideoId", "", "finderFeedId", "objectNonceId", "plugin-finder_release"})
public final class y
{
  private static final int AEh = -4052;
  public static final y AEi;
  private static final aj<bet> xFj;
  
  static
  {
    AppMethodBeat.i(276887);
    AEi = new y();
    AEh = -4052;
    xFj = (aj)new a();
    AppMethodBeat.o(276887);
  }
  
  public static void a(final Context paramContext, long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(276886);
    p.k(paramContext, "context");
    p.k(paramString, "objectNonceId");
    ((com.tencent.mm.plugin.finder.service.l)h.ae(com.tencent.mm.plugin.finder.service.l.class)).b(paramLong2, null, paramString, paramBoolean, (aj)new b(paramLong1, paramBoolean, paramContext));
    AppMethodBeat.o(276886);
  }
  
  public static void a(Context paramContext, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(276885);
    p.k(paramContext, "context");
    p.k(paramFinderItem, "feed");
    ((com.tencent.mm.plugin.finder.service.l)h.ae(com.tencent.mm.plugin.finder.service.l.class)).b(paramFinderItem.getId(), paramFinderItem.getFeedObject(), paramFinderItem.getObjectNonceId(), paramBoolean, xFj);
    AppMethodBeat.o(276885);
  }
  
  public static void a(o paramo, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(276883);
    p.k(paramo, "menu");
    p.k(paramContext, "context");
    if (paramBoolean1)
    {
      paramo.a(paramInt1, (CharSequence)paramContext.getString(b.j.finder_set_public), b.i.icons_outlined_unlock, paramBoolean2);
      AppMethodBeat.o(276883);
      return;
    }
    paramo.a(paramInt2, (CharSequence)paramContext.getString(b.j.finder_set_private), b.i.icons_outlined_lock, paramBoolean2);
    AppMethodBeat.o(276883);
  }
  
  public static int edq()
  {
    return AEh;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements aj<bet>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class a
      implements w.b
    {
      public static final a AEj;
      
      static
      {
        AppMethodBeat.i(281802);
        AEj = new a();
        AppMethodBeat.o(281802);
      }
      
      public final void eu(View paramView)
      {
        AppMethodBeat.i(281801);
        if (paramView != null)
        {
          paramView = (TextView)paramView.findViewById(b.f.toast_text);
          if (paramView != null)
          {
            paramView.setTextSize(1, 14.0F);
            AppMethodBeat.o(281801);
            return;
          }
        }
        AppMethodBeat.o(281801);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$changeMegaVideoFeedPrivacy$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements aj<bet>
  {
    b(long paramLong, boolean paramBoolean, Context paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.y
 * JD-Core Version:    0.7.0.1
 */