package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/ShowAppMsgContentUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MENU_ID_COPY", "", "getMENU_ID_COPY", "()I", "TAG", "", "contentTV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContentTV", "()Landroid/widget/TextView;", "contentTV$delegate", "Lkotlin/Lazy;", "msgId", "", "getMsgId", "()J", "msgId$delegate", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "getMoreInfo", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"})
public final class ShowAppMsgContentUI
  extends MMActivity
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private ca fNz;
  final int szg;
  private final kotlin.f szh;
  private final kotlin.f szi;
  private s tipDialog;
  
  public ShowAppMsgContentUI()
  {
    AppMethodBeat.i(6526);
    this.TAG = "MicroMsg.ShowAppMsgContentUI";
    this.szg = 1;
    this.szh = kotlin.g.ar((kotlin.g.a.a)new a(this));
    this.szi = kotlin.g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(6526);
  }
  
  private final long apG()
  {
    AppMethodBeat.i(6523);
    long l = ((Number)this.szi.getValue()).longValue();
    AppMethodBeat.o(6523);
    return l;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(258000);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(258000);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(257999);
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
    AppMethodBeat.o(257999);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return d.f.suz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(6524);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.h.ae(n.class);
    p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((n)paramBundle).eSe().Oq(apG());
    p.j(paramBundle, "MMKernel.service(IMessen…msgInfoStg.getById(msgId)");
    this.fNz = paramBundle;
    paramBundle = this.fNz;
    if (paramBundle == null) {
      p.bGy("msgInfo");
    }
    if (paramBundle != null)
    {
      paramBundle = this.fNz;
      if (paramBundle == null) {
        p.bGy("msgInfo");
      }
      if (paramBundle.apG() > 0L) {}
    }
    else
    {
      Log.w(this.TAG, "onCreate msg is invalid %d", new Object[] { Long.valueOf(apG()) });
      finish();
      AppMethodBeat.o(6524);
      return;
    }
    paramBundle = (Context)getContext();
    getContext().getString(d.i.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getContext().getString(d.i.app_waiting), true, null);
    com.tencent.mm.cw.g.ijP().j((com.tencent.mm.vending.c.a)new c(this)).b((com.tencent.mm.vending.c.a)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    setMMTitle(d.i.menu_show_app_msg_content);
    addIconOptionMenu(0, getString(d.i.app_more), d.h.actionbar_icon_dark_more, (MenuItem.OnMenuItemClickListener)new f(this));
    AppMethodBeat.o(6524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6525);
    super.onDestroy();
    s locals = this.tipDialog;
    if (locals != null)
    {
      if (locals.isShowing()) {
        locals.dismiss();
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<TextView>
  {
    a(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Long>
  {
    b(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Void;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    private CharSequence czM()
    {
      AppMethodBeat.i(175479);
      try
      {
        Object localObject = (Context)this.szj;
        CharSequence localCharSequence2 = (CharSequence)(ShowAppMsgContentUI.a(this.szj) + "\n" + ShowAppMsgContentUI.b(this.szj).getContent());
        TextView localTextView = ShowAppMsgContentUI.c(this.szj);
        p.j(localTextView, "contentTV");
        localObject = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.a((Context)localObject, localCharSequence2, (int)localTextView.getTextSize(), null, null);
        AppMethodBeat.o(175479);
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(ShowAppMsgContentUI.d(this.szj), "spanForTextViewWithExtra ex: " + localException.getMessage());
          CharSequence localCharSequence1 = (CharSequence)"";
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "str", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/CharSequence;)Lkotlin/Unit;"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6518);
      this.szj.hideVKB();
      this.szj.finish();
      AppMethodBeat.o(6518);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(ShowAppMsgContentUI paramShowAppMsgContentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(6521);
      paramMenuItem = new e((Context)this.szj, 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(6519);
          paramAnonymouso.mn(this.szk.szj.szg, d.i.app_copy);
          AppMethodBeat.o(6519);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(6520);
          p.j(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == this.szk.szj.szg)
          {
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, (CharSequence)ShowAppMsgContentUI.b(this.szk.szj).getContent());
            com.tencent.mm.ui.base.h.cL((Context)this.szk.szj.getContext(), this.szk.szj.getContext().getString(d.i.app_copy_ok));
            AppMethodBeat.o(6520);
            return;
          }
          Log.w(ShowAppMsgContentUI.d(this.szk.szj), "default onMMMenuItemSelected err");
          AppMethodBeat.o(6520);
        }
      });
      paramMenuItem.eik();
      AppMethodBeat.o(6521);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI
 * JD-Core Version:    0.7.0.1
 */