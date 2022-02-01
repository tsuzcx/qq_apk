package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/ShowAppMsgContentUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MENU_ID_COPY", "", "getMENU_ID_COPY", "()I", "TAG", "", "contentTV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContentTV", "()Landroid/widget/TextView;", "contentTV$delegate", "Lkotlin/Lazy;", "msgId", "", "getMsgId", "()J", "msgId$delegate", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "getMoreInfo", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"})
public final class ShowAppMsgContentUI
  extends MMActivity
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private ca dTX;
  final int pqh;
  private final kotlin.f pqi;
  private final kotlin.f pqj;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public ShowAppMsgContentUI()
  {
    AppMethodBeat.i(6526);
    this.TAG = "MicroMsg.ShowAppMsgContentUI";
    this.pqh = 1;
    this.pqi = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.pqj = kotlin.g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(6526);
  }
  
  private final long ajL()
  {
    AppMethodBeat.i(6523);
    long l = ((Number)this.pqj.getValue()).longValue();
    AppMethodBeat.o(6523);
    return l;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195150);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195150);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195149);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(195149);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496309;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(6524);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).eiy().Hb(ajL());
    p.g(paramBundle, "MMKernel.service(IMessen…msgInfoStg.getById(msgId)");
    this.dTX = paramBundle;
    paramBundle = this.dTX;
    if (paramBundle == null) {
      p.btv("msgInfo");
    }
    if (paramBundle != null)
    {
      paramBundle = this.dTX;
      if (paramBundle == null) {
        p.btv("msgInfo");
      }
      if (paramBundle.ajL() > 0L) {}
    }
    else
    {
      Log.w(this.TAG, "onCreate msg is invalid %d", new Object[] { Long.valueOf(ajL()) });
      finish();
      AppMethodBeat.o(6524);
      return;
    }
    paramBundle = (Context)getContext();
    getContext().getString(2131755998);
    this.tipDialog = h.a(paramBundle, getContext().getString(2131756029), true, null);
    com.tencent.mm.co.g.hio().j((com.tencent.mm.vending.c.a)new c(this)).b((com.tencent.mm.vending.c.a)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    setMMTitle(2131763040);
    addIconOptionMenu(0, getString(2131755899), 2131689495, (MenuItem.OnMenuItemClickListener)new f(this));
    AppMethodBeat.o(6524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6525);
    super.onDestroy();
    com.tencent.mm.ui.base.q localq = this.tipDialog;
    if (localq != null)
    {
      if (localq.isShowing()) {
        localq.dismiss();
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    a(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    b(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Void;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    private CharSequence cmi()
    {
      AppMethodBeat.i(175479);
      try
      {
        Object localObject = (Context)this.pqk;
        CharSequence localCharSequence2 = (CharSequence)(ShowAppMsgContentUI.a(this.pqk) + "\n" + ShowAppMsgContentUI.b(this.pqk).getContent());
        TextView localTextView = ShowAppMsgContentUI.c(this.pqk);
        p.g(localTextView, "contentTV");
        localObject = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.a((Context)localObject, localCharSequence2, (int)localTextView.getTextSize(), 1, null, null);
        AppMethodBeat.o(175479);
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(ShowAppMsgContentUI.d(this.pqk), "spanForTextViewWithExtra ex: " + localException.getMessage());
          CharSequence localCharSequence1 = (CharSequence)"";
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "str", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/CharSequence;)Lkotlin/Unit;"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6518);
      this.pqk.hideVKB();
      this.pqk.finish();
      AppMethodBeat.o(6518);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6521);
      paramMenuItem = new e((Context)this.pqk, 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(6519);
          paramAnonymousm.kV(this.pql.pqk.pqh, 2131755772);
          AppMethodBeat.o(6519);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(6520);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == this.pql.pqk.pqh)
          {
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, (CharSequence)ShowAppMsgContentUI.b(this.pql.pqk).getContent());
            h.cA((Context)this.pql.pqk.getContext(), this.pql.pqk.getContext().getString(2131755773));
            AppMethodBeat.o(6520);
            return;
          }
          Log.w(ShowAppMsgContentUI.d(this.pql.pqk), "default onMMMenuItemSelected err");
          AppMethodBeat.o(6520);
        }
      });
      paramMenuItem.dGm();
      AppMethodBeat.o(6521);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI
 * JD-Core Version:    0.7.0.1
 */