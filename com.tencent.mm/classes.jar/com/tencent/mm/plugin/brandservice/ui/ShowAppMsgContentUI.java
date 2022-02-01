package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.u;
import d.g.b.w;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/ShowAppMsgContentUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MENU_ID_COPY", "", "getMENU_ID_COPY", "()I", "TAG", "", "contentTV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContentTV", "()Landroid/widget/TextView;", "contentTV$delegate", "Lkotlin/Lazy;", "msgId", "", "getMsgId", "()J", "msgId$delegate", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "getMoreInfo", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"})
public final class ShowAppMsgContentUI
  extends MMActivity
{
  private final String TAG;
  private bl drF;
  final int mVC;
  private final d.f mVD;
  private final d.f mVE;
  private p tipDialog;
  
  static
  {
    AppMethodBeat.i(6522);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(ShowAppMsgContentUI.class), "contentTV", "getContentTV()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(ShowAppMsgContentUI.class), "msgId", "getMsgId()J")) };
    AppMethodBeat.o(6522);
  }
  
  public ShowAppMsgContentUI()
  {
    AppMethodBeat.i(6526);
    this.TAG = "MicroMsg.ShowAppMsgContentUI";
    this.mVC = 1;
    this.mVD = d.g.E((d.g.a.a)new a(this));
    this.mVE = d.g.E((d.g.a.a)new b(this));
    AppMethodBeat.o(6526);
  }
  
  private final long SF()
  {
    AppMethodBeat.i(6523);
    long l = ((Number)this.mVE.getValue()).longValue();
    AppMethodBeat.o(6523);
    return l;
  }
  
  public final int getLayoutId()
  {
    return 2131495437;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(6524);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramBundle).cOI().rm(SF());
    d.g.b.k.g(paramBundle, "MMKernel.service(IMessen…msgInfoStg.getById(msgId)");
    this.drF = paramBundle;
    paramBundle = this.drF;
    if (paramBundle == null) {
      d.g.b.k.aPZ("msgInfo");
    }
    if (paramBundle != null)
    {
      paramBundle = this.drF;
      if (paramBundle == null) {
        d.g.b.k.aPZ("msgInfo");
      }
      if (paramBundle.SF() > 0L) {}
    }
    else
    {
      ad.w(this.TAG, "onCreate msg is invalid %d", new Object[] { Long.valueOf(SF()) });
      finish();
      AppMethodBeat.o(6524);
      return;
    }
    paramBundle = (Context)getContext();
    getContext().getString(2131755906);
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getContext().getString(2131755936), true, null);
    com.tencent.mm.co.g.fkM().j((com.tencent.mm.vending.c.a)new c(this)).b((com.tencent.mm.vending.c.a)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    setMMTitle(2131761225);
    addIconOptionMenu(0, getString(2131755815), 2131689493, (MenuItem.OnMenuItemClickListener)new f(this));
    AppMethodBeat.o(6524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6525);
    super.onDestroy();
    p localp = this.tipDialog;
    if (localp != null)
    {
      if (localp.isShowing()) {
        localp.dismiss();
      }
      AppMethodBeat.o(6525);
      return;
    }
    AppMethodBeat.o(6525);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    a(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Long>
  {
    b(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Void;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    private CharSequence bCE()
    {
      AppMethodBeat.i(175479);
      try
      {
        Object localObject = (Context)this.mVF;
        CharSequence localCharSequence2 = (CharSequence)(ShowAppMsgContentUI.a(this.mVF) + "\n" + ShowAppMsgContentUI.b(this.mVF).getContent());
        TextView localTextView = ShowAppMsgContentUI.c(this.mVF);
        d.g.b.k.g(localTextView, "contentTV");
        localObject = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject, localCharSequence2, (int)localTextView.getTextSize(), 1, null, null);
        AppMethodBeat.o(175479);
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e(ShowAppMsgContentUI.d(this.mVF), "spanForTextViewWithExtra ex: " + localException.getMessage());
          CharSequence localCharSequence1 = (CharSequence)"";
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "str", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/CharSequence;)Lkotlin/Unit;"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6518);
      this.mVF.hideVKB();
      this.mVF.finish();
      AppMethodBeat.o(6518);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6521);
      paramMenuItem = new e((Context)this.mVF, 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(6519);
          paramAnonymousl.jj(this.mVG.mVF.mVC, 2131755701);
          AppMethodBeat.o(6519);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(6520);
          d.g.b.k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == this.mVG.mVF.mVC)
          {
            paramAnonymousMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
              AppMethodBeat.o(6520);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText((CharSequence)ShowAppMsgContentUI.b(this.mVG.mVF).getContent());
            com.tencent.mm.ui.base.h.cc((Context)this.mVG.mVF.getContext(), this.mVG.mVF.getContext().getString(2131755702));
            AppMethodBeat.o(6520);
            return;
          }
          ad.w(ShowAppMsgContentUI.d(this.mVG.mVF), "default onMMMenuItemSelected err");
          AppMethodBeat.o(6520);
        }
      });
      paramMenuItem.csG();
      AppMethodBeat.o(6521);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI
 * JD-Core Version:    0.7.0.1
 */