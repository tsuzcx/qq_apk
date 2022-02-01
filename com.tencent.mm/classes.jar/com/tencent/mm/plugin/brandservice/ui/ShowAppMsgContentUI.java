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
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.q;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/ShowAppMsgContentUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MENU_ID_COPY", "", "getMENU_ID_COPY", "()I", "TAG", "", "contentTV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContentTV", "()Landroid/widget/TextView;", "contentTV$delegate", "Lkotlin/Lazy;", "msgId", "", "getMsgId", "()J", "msgId$delegate", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "getMoreInfo", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"})
public final class ShowAppMsgContentUI
  extends MMActivity
{
  private final String TAG;
  private bu dBd;
  final int nZA;
  private final d.f nZB;
  private final d.f nZC;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public ShowAppMsgContentUI()
  {
    AppMethodBeat.i(6526);
    this.TAG = "MicroMsg.ShowAppMsgContentUI";
    this.nZA = 1;
    this.nZB = d.g.O((d.g.a.a)new a(this));
    this.nZC = d.g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(6526);
  }
  
  private final long VP()
  {
    AppMethodBeat.i(6523);
    long l = ((Number)this.nZC.getValue()).longValue();
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
    paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).dlK().xY(VP());
    d.g.b.p.g(paramBundle, "MMKernel.service(IMessen…msgInfoStg.getById(msgId)");
    this.dBd = paramBundle;
    paramBundle = this.dBd;
    if (paramBundle == null) {
      d.g.b.p.bcb("msgInfo");
    }
    if (paramBundle != null)
    {
      paramBundle = this.dBd;
      if (paramBundle == null) {
        d.g.b.p.bcb("msgInfo");
      }
      if (paramBundle.VP() > 0L) {}
    }
    else
    {
      ad.w(this.TAG, "onCreate msg is invalid %d", new Object[] { Long.valueOf(VP()) });
      finish();
      AppMethodBeat.o(6524);
      return;
    }
    paramBundle = (Context)getContext();
    getContext().getString(2131755906);
    this.tipDialog = h.b(paramBundle, getContext().getString(2131755936), true, null);
    com.tencent.mm.cn.g.fSm().j((com.tencent.mm.vending.c.a)new c(this)).b((com.tencent.mm.vending.c.a)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    setMMTitle(2131761225);
    addIconOptionMenu(0, getString(2131755815), 2131689493, (MenuItem.OnMenuItemClickListener)new f(this));
    AppMethodBeat.o(6524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6525);
    super.onDestroy();
    com.tencent.mm.ui.base.p localp = this.tipDialog;
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<TextView>
  {
    a(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Long>
  {
    b(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Void;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    private CharSequence bOf()
    {
      AppMethodBeat.i(175479);
      try
      {
        Object localObject = (Context)this.nZD;
        CharSequence localCharSequence2 = (CharSequence)(ShowAppMsgContentUI.a(this.nZD) + "\n" + ShowAppMsgContentUI.b(this.nZD).getContent());
        TextView localTextView = ShowAppMsgContentUI.c(this.nZD);
        d.g.b.p.g(localTextView, "contentTV");
        localObject = (CharSequence)k.a((Context)localObject, localCharSequence2, (int)localTextView.getTextSize(), 1, null, null);
        AppMethodBeat.o(175479);
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e(ShowAppMsgContentUI.d(this.nZD), "spanForTextViewWithExtra ex: " + localException.getMessage());
          CharSequence localCharSequence1 = (CharSequence)"";
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "str", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/CharSequence;)Lkotlin/Unit;"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6518);
      this.nZD.hideVKB();
      this.nZD.finish();
      AppMethodBeat.o(6518);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6521);
      paramMenuItem = new e((Context)this.nZD, 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(6519);
          paramAnonymousl.jI(this.nZE.nZD.nZA, 2131755701);
          AppMethodBeat.o(6519);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(6520);
          d.g.b.p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == this.nZE.nZD.nZA)
          {
            paramAnonymousMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
              AppMethodBeat.o(6520);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText((CharSequence)ShowAppMsgContentUI.b(this.nZE.nZD).getContent());
            h.ci((Context)this.nZE.nZD.getContext(), this.nZE.nZD.getContext().getString(2131755702));
            AppMethodBeat.o(6520);
            return;
          }
          ad.w(ShowAppMsgContentUI.d(this.nZE.nZD), "default onMMMenuItemSelected err");
          AppMethodBeat.o(6520);
        }
      });
      paramMenuItem.cMW();
      AppMethodBeat.o(6521);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI
 * JD-Core Version:    0.7.0.1
 */