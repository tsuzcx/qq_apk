package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.service.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bpu;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderPrivateUtil;", "", "()V", "MMFinder_ModSticky_Err_Sticky_NotAllow_Private", "", "getMMFinder_ModSticky_Err_Sticky_NotAllow_Private", "()I", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "addPrivateMenuItem", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "mediaType", "PUBLIC_ID", "PRIVATE_ID", "ifPrivate", "", "disable", "changeFeedPrivacy", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setPrivate", "changeMegaVideoFeedPrivacy", "megaVideoId", "", "finderFeedId", "objectNonceId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  private static final ck<bpu> Bcx;
  public static final ag Ghl;
  private static final int Ghm;
  
  static
  {
    AppMethodBeat.i(333575);
    Ghl = new ag();
    Ghm = -4052;
    Bcx = (ck)new a();
    AppMethodBeat.o(333575);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(333565);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "objectNonceId");
    ((q)h.ax(q.class)).b(paramLong2, null, paramString, paramBoolean, (ck)new b(paramLong1, paramContext, paramBoolean));
    AppMethodBeat.o(333565);
  }
  
  public static void a(Context paramContext, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(333559);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderItem, "feed");
    ((q)h.ax(q.class)).b(paramFinderItem.getId(), paramFinderItem.getFeedObject(), paramFinderItem.getObjectNonceId(), paramBoolean, Bcx);
    AppMethodBeat.o(333559);
  }
  
  public static void a(com.tencent.mm.ui.base.s params, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(333540);
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramContext, "context");
    if (paramBoolean1)
    {
      params.a(paramInt1, (CharSequence)paramContext.getString(e.h.finder_set_public), e.g.icons_outlined_unlock, paramBoolean2);
      AppMethodBeat.o(333540);
      return;
    }
    params.a(paramInt2, (CharSequence)paramContext.getString(e.h.finder_set_private), e.g.icons_outlined_lock, paramBoolean2);
    AppMethodBeat.o(333540);
  }
  
  public static int ffg()
  {
    return Ghm;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ck<bpu>
  {
    private static final void fG(View paramView)
    {
      AppMethodBeat.i(333264);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(e.e.toast_text);
        if (paramView != null) {
          paramView.setTextSize(1, 14.0F);
        }
      }
      AppMethodBeat.o(333264);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$changeMegaVideoFeedPrivacy$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ck<bpu>
  {
    b(long paramLong, Context paramContext, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ag
 * JD-Core Version:    0.7.0.1
 */