package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.apn;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderPrivateUtil;", "", "()V", "TAG", "", "addPrivateMenuItem", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "mediaType", "", "PUBLIC_ID", "PRIVATE_ID", "ifPrivate", "", "changeFeedPrivacy", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setPrivate", "plugin-finder_release"})
public final class l
{
  public static final l sLx;
  
  static
  {
    AppMethodBeat.i(204491);
    sLx = new l();
    AppMethodBeat.o(204491);
  }
  
  public static void a(Context paramContext, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(204490);
    p.h(paramContext, "context");
    p.h(paramFinderItem, "feed");
    ((com.tencent.mm.plugin.i.a.l)g.ab(com.tencent.mm.plugin.i.a.l.class)).b(paramFinderItem.getId(), paramFinderItem.getFeedObject(), paramFinderItem.getObjectNonceId(), paramBoolean, (s)new a(paramContext));
    AppMethodBeat.o(204490);
  }
  
  public static void a(com.tencent.mm.ui.base.l paraml, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(204489);
    p.h(paraml, "menu");
    p.h(paramContext, "context");
    if (paramBoolean)
    {
      paraml.a(paramInt1, (CharSequence)paramContext.getString(2131767034), 2131690671);
      AppMethodBeat.o(204489);
      return;
    }
    paraml.a(paramInt2, (CharSequence)paramContext.getString(2131767032), 2131690590);
    AppMethodBeat.o(204489);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/utils/FinderPrivateUtil$changeFeedPrivacy$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements s<apn>
  {
    a(Context paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.l
 * JD-Core Version:    0.7.0.1
 */