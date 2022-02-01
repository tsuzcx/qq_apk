package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.g.b.p;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "copyText", "", "text", "getLayoutId", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "testFastLoad", "plugin-brandservice_release"})
public final class BizTestUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestUI";
  
  public final int getLayoutId()
  {
    return 2131496428;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(208650);
    p.h(paramView, "view");
    Object localObject = ay.aRX("brandService");
    int i = paramView.getId();
    if (i == 2131308373) {
      ay.aRX("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 1);
    }
    label539:
    label747:
    do
    {
      for (;;)
      {
        ((ay)localObject).apply();
        paramView = com.tencent.mm.plugin.brandservice.a.obd;
        a.a.onSuccess();
        paramView = new Intent();
        paramView.addFlags(67108864);
        paramView.putExtra("preferred_tab", 0);
        com.tencent.mm.br.d.f((Context)this, ".ui.LauncherUI", paramView);
        AppMethodBeat.o(208650);
        return;
        if (i == 2131308403)
        {
          ay.aRX("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 0);
        }
        else if (i == 2131296730)
        {
          ((ay)localObject).encode("BizTimeLineAdOpen", 1);
        }
        else if (i == 2131296429)
        {
          ((ay)localObject).encode("BizTimeLineAdOpen", 0);
        }
        else if (i == 2131298534)
        {
          ((ay)localObject).encode("BizTimeLineAdTestMode", 0);
        }
        else if (i == 2131297695)
        {
          ((ay)localObject).encode("BizLastExposeAdTime", 0L);
        }
        else if (i == 2131300070)
        {
          ((ay)localObject).encode("BizTimeLineAdTestMode", 1);
        }
        else
        {
          if (i != 2131300071) {
            break;
          }
          ((ay)localObject).encode("BizTimeLineAdTestMode", 2);
        }
      }
      if (i == 2131308471)
      {
        paramView = new Intent((Context)getContext(), BizTestCanvasUI.class);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(208650);
        return;
      }
      if (i == 2131308371)
      {
        com.tencent.mm.ui.widget.a.d locald = new com.tencent.mm.ui.widget.a.d((Context)this);
        locald.setTitle((CharSequence)"Pkg Info");
        localObject = "";
        if (ay.aRX("WebCanvasStorage").decodeInt("BizTimeLineAdPreviewMode", 0) == 0)
        {
          paramView = com.tencent.mm.plugin.webcanvas.h.DQL;
          paramView = com.tencent.mm.plugin.webcanvas.h.aGW("wxfedb0854e2b1820d");
          if (paramView != null)
          {
            paramView = "" + "BasePkg:md5=" + paramView.md5 + "\tversion=" + paramView.version + '\n';
            localObject = com.tencent.mm.plugin.webcanvas.h.DQL;
            localObject = com.tencent.mm.plugin.webcanvas.h.aGW("wxf337cbaa27790d8e");
            if (localObject == null) {
              break label539;
            }
            paramView = paramView + "BizPkg:md5=" + ((sp)localObject).md5 + " \tversion=" + ((sp)localObject).version;
          }
        }
        for (;;)
        {
          locald.setMessage((CharSequence)paramView);
          locald.afM(3);
          locald.afL(3);
          locald.a((CharSequence)getString(2131760315), true, null);
          locald.show();
          localObject = getSystemService("clipboard");
          if (localObject != null) {
            break label747;
          }
          paramView = new v("null cannot be cast to non-null type android.text.ClipboardManager");
          AppMethodBeat.o(208650);
          throw paramView;
          paramView = "";
          break;
          continue;
          paramView = g.ab(com.tencent.mm.plugin.appbrand.api.e.class);
          p.g(paramView, "MMKernel.service(IWxaPkg…orageService::class.java)");
          paramView = ((com.tencent.mm.plugin.appbrand.api.e)paramView).aYP().a("wxfedb0854e2b1820d", 2, new String[] { "version", "pkgPath", "versionMd5" });
          if (paramView != null) {
            localObject = "" + "BasePkg:md5=" + paramView.field_versionMd5 + "\tversion=" + paramView.field_version + '\n';
          }
          paramView = g.ab(com.tencent.mm.plugin.appbrand.api.e.class);
          p.g(paramView, "MMKernel.service(IWxaPkg…orageService::class.java)");
          bd localbd = ((com.tencent.mm.plugin.appbrand.api.e)paramView).aYP().a("wxf337cbaa27790d8e", 2, new String[] { "version", "pkgPath", "versionMd5" });
          paramView = (View)localObject;
          if (localbd != null) {
            paramView = (String)localObject + "BizPkg:md5=" + localbd.field_versionMd5 + " \tversion=" + localbd.field_version;
          }
        }
        localObject = (ClipboardManager)localObject;
        if (localObject != null) {
          try
          {
            ((ClipboardManager)localObject).setText((CharSequence)paramView);
            AppMethodBeat.o(208650);
            return;
          }
          catch (Exception paramView)
          {
            ae.printErrStackTrace(this.TAG, (Throwable)paramView, "clip.setText error", new Object[0]);
            AppMethodBeat.o(208650);
            return;
          }
        }
        ae.e(this.TAG, "clipboard manager is null");
        AppMethodBeat.o(208650);
        return;
      }
    } while (i != 2131308486);
    paramView = ay.aRW("_webview_tmpl_command");
    localObject = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject).a((n.d)b.ofQ);
    ((com.tencent.mm.ui.widget.a.e)localObject).a((n.e)new c(this, paramView));
    ((com.tencent.mm.ui.widget.a.e)localObject).p((CharSequence)" ", 1);
    ((com.tencent.mm.ui.widget.a.e)localObject).fQz();
    ((com.tencent.mm.ui.widget.a.e)localObject).cPF();
    AppMethodBeat.o(208650);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208648);
    super.onCreate(paramBundle);
    setMMTitle(2131761225);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(208648);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(208649);
    super.onDestroy();
    AppMethodBeat.o(208649);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(BizTestUI paramBizTestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(208644);
      this.ofP.finish();
      AppMethodBeat.o(208644);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.d
  {
    public static final b ofQ;
    
    static
    {
      AppMethodBeat.i(208646);
      ofQ = new b();
      AppMethodBeat.o(208646);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(208645);
      paraml.c(0, (CharSequence)"清理模板");
      paraml.c(1, (CharSequence)"清理数据");
      paraml.c(2, (CharSequence)"检查模板更新");
      paraml.c(3, (CharSequence)"noredir");
      paraml.c(4, (CharSequence)"redir");
      AppMethodBeat.o(208645);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements n.e
  {
    c(BizTestUI paramBizTestUI, ay paramay) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(208647);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208647);
        return;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.clear();
        com.tencent.mm.ui.base.h.cj((Context)this.ofP, "clear all tmpl info");
        AppMethodBeat.o(208647);
        return;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.bPR();
        com.tencent.mm.ui.base.h.cj((Context)this.ofP, "clear all cached data");
        AppMethodBeat.o(208647);
        return;
        paramView.putBoolean("preload_tmpl_always_check_tmpl_ver", true);
        com.tencent.mm.ui.base.h.cj((Context)this.ofP, "enable tmpl always check");
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zm(90);
        AppMethodBeat.o(208647);
        return;
        paramView.putBoolean("preload_tmpl_test_noredir", true);
        com.tencent.mm.ui.base.h.cj((Context)this.ofP, "disable re-direct");
        AppMethodBeat.o(208647);
        return;
        paramView.remove("preload_tmpl_test_noredir");
        com.tencent.mm.ui.base.h.cj((Context)this.ofP, "enable re-direct");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI
 * JD-Core Version:    0.7.0.1
 */