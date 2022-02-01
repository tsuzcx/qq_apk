package com.tencent.mm.plugin.finder.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/dialog/FinderBottomSheetConfirmLivePostDialog;", "Lcom/tencent/mm/plugin/finder/view/dialog/IFinderDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "(Landroid/content/Context;Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "createDialog", "hide", "", "show", "Companion", "plugin-finder_release"})
public final class b
{
  public static final a BeA;
  private final q.g Bez;
  private final Context context;
  com.tencent.mm.ui.widget.a.e kCR;
  
  static
  {
    AppMethodBeat.i(270923);
    BeA = new a((byte)0);
    AppMethodBeat.o(270923);
  }
  
  public b(Context paramContext, q.g paramg)
  {
    AppMethodBeat.i(270922);
    this.context = paramContext;
    this.Bez = paramg;
    paramContext = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
    paramg = ad.kS(this.context).inflate(b.g.finder_sheet_header_post_live, null);
    Object localObject2 = (TextView)paramg.findViewById(b.f.nickname);
    ImageView localImageView = (ImageView)paramg.findViewById(b.f.avatar);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject1 = d.a.aAK(z.bdh());
    if (localObject1 != null)
    {
      p.j(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.context, (CharSequence)((i)localObject1).getNickname()));
      localObject2 = t.ztT;
      localObject2 = t.dJh();
      localObject1 = new com.tencent.mm.plugin.finder.loader.e(((i)localObject1).field_avatarUrl);
      p.j(localImageView, "avatarIv");
      t localt = t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, t.a(t.a.ztX));
    }
    paramContext.Z(paramg, true);
    paramContext.a((q.f)b.BeB);
    paramContext.a(this.Bez);
    paramContext.b((e.b)c.BeC);
    this.kCR = paramContext;
    AppMethodBeat.o(270922);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/dialog/FinderBottomSheetConfirmLivePostDialog$Companion;", "", "()V", "MENU_ID_CREATE_NOTICE", "", "MENU_ID_OPEN_LIVE", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    public static final b BeB;
    
    static
    {
      AppMethodBeat.i(263799);
      BeB = new b();
      AppMethodBeat.o(263799);
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(263797);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(10001, b.j.finder_create_live);
        paramo.mn(10002, b.j.finder_create_live_notice);
      }
      AppMethodBeat.o(263797);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    public static final c BeC;
    
    static
    {
      AppMethodBeat.i(271027);
      BeC = new c();
      AppMethodBeat.o(271027);
    }
    
    public final void onDismiss() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.dialog.b
 * JD-Core Version:    0.7.0.1
 */