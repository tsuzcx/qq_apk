package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class d$a$c
  implements DialogInterface.OnClickListener
{
  d$a$c(d.a parama, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(197704);
    paramDialogInterface = u.aqO();
    k.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
    paramDialogInterface = new m(paramDialogInterface, this.qug.feedObject.getId(), this.qug.feedObject.getObjectNonceId());
    Object localObject = this.qvn.tipDialog;
    if (localObject != null) {
      ((Dialog)localObject).show();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aeS().a(paramDialogInterface.getType(), (com.tencent.mm.al.g)new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(197703);
          if (((paramAnonymousn instanceof m)) && (((m)paramAnonymousn).objectId == paramDialogInterface.objectId)) {
            com.tencent.mm.kernel.g.aeS().b(paramDialogInterface.getType(), (com.tencent.mm.al.g)this);
          }
          paramAnonymousString = this.KNp.qvn.tipDialog;
          if (paramAnonymousString != null) {
            paramAnonymousString.dismiss();
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            this.KNp.qvn.imP.finish();
            AppMethodBeat.o(197703);
            return;
          }
          t.makeText((Context)this.KNp.qvn.imP, 2131766471, 0).show();
          AppMethodBeat.o(197703);
        }
      });
      com.tencent.mm.kernel.g.aeS().b((n)paramDialogInterface);
      AppMethodBeat.o(197704);
      return;
      localObject = this.qvn;
      Context localContext = (Context)((a.a)localObject).imP;
      ((a.a)localObject).imP.getString(2131755906);
      ((d.a)localObject).tipDialog = ((Dialog)h.b(localContext, ((a.a)localObject).imP.getString(2131755936), false, (DialogInterface.OnCancelListener)a.KNo));
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a KNo;
    
    static
    {
      AppMethodBeat.i(197702);
      KNo = new a();
      AppMethodBeat.o(197702);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d.a.c
 * JD-Core Version:    0.7.0.1
 */