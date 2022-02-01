package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.i.a.s;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderPrivateUtil;", "", "()V", "TAG", "", "addPrivateMenuItem", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "mediaType", "", "PUBLIC_ID", "PRIVATE_ID", "ifPrivate", "", "changeFeedPrivacy", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setPrivate", "plugin-finder_release"})
public final class l
{
  public static final l sWI;
  
  static
  {
    AppMethodBeat.i(205111);
    sWI = new l();
    AppMethodBeat.o(205111);
  }
  
  public static void a(Context paramContext, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(205110);
    p.h(paramContext, "context");
    p.h(paramFinderItem, "feed");
    ((com.tencent.mm.plugin.i.a.l)g.ab(com.tencent.mm.plugin.i.a.l.class)).b(paramFinderItem.getId(), paramFinderItem.getFeedObject(), paramFinderItem.getObjectNonceId(), paramBoolean, (s)new l.a(paramContext));
    AppMethodBeat.o(205110);
  }
  
  public static void a(com.tencent.mm.ui.base.l paraml, Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(205109);
    p.h(paraml, "menu");
    p.h(paramContext, "context");
    if (paramBoolean)
    {
      paraml.a(paramInt1, (CharSequence)paramContext.getString(2131767034), 2131690671);
      AppMethodBeat.o(205109);
      return;
    }
    paraml.a(paramInt2, (CharSequence)paramContext.getString(2131767032), 2131690590);
    AppMethodBeat.o(205109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.l
 * JD-Core Version:    0.7.0.1
 */