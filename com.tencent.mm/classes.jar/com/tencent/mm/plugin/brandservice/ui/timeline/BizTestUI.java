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
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.plugin.webcanvas.g;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "copyText", "", "text", "getLayoutId", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"})
public final class BizTestUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestUI";
  
  public final int getLayoutId()
  {
    return 2131496428;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209676);
    p.h(paramView, "view");
    Object localObject1 = ax.aQA("brandService");
    int i = paramView.getId();
    if (i == 2131308373) {
      ax.aQA("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 1);
    }
    do
    {
      for (;;)
      {
        ((ax)localObject1).apply();
        paramView = a.nVw;
        a.a.onSuccess();
        paramView = new Intent();
        paramView.addFlags(67108864);
        paramView.putExtra("preferred_tab", 0);
        com.tencent.mm.bs.d.f((Context)this, ".ui.LauncherUI", paramView);
        AppMethodBeat.o(209676);
        return;
        if (i == 2131308403)
        {
          ax.aQA("WebCanvasStorage").encode("BizTimeLineAdPreviewMode", 0);
        }
        else if (i == 2131296730)
        {
          ((ax)localObject1).encode("BizTimeLineAdOpen", 1);
        }
        else if (i == 2131296429)
        {
          ((ax)localObject1).encode("BizTimeLineAdOpen", 0);
        }
        else if (i == 2131298534)
        {
          ((ax)localObject1).encode("BizTimeLineAdTestMode", 0);
        }
        else if (i == 2131300070)
        {
          ((ax)localObject1).encode("BizTimeLineAdTestMode", 1);
        }
        else
        {
          if (i != 2131300071) {
            break;
          }
          ((ax)localObject1).encode("BizTimeLineAdTestMode", 2);
        }
      }
    } while (i != 2131308371);
    localObject1 = new com.tencent.mm.ui.widget.a.d((Context)this);
    ((com.tencent.mm.ui.widget.a.d)localObject1).setTitle((CharSequence)"Pkg Info");
    paramView = "";
    Object localObject2 = g.Dzc;
    localObject2 = g.aFC("wxfedb0854e2b1820d");
    if (localObject2 != null) {
      paramView = "" + "BasePkg:md5=" + ((sn)localObject2).md5 + "\tversion=" + ((sn)localObject2).version + '\n';
    }
    localObject2 = g.Dzc;
    localObject2 = g.aFC("wxf337cbaa27790d8e");
    if (localObject2 != null) {
      paramView = paramView + "BizPkg:md5=" + ((sn)localObject2).md5 + " \tversion=" + ((sn)localObject2).version;
    }
    for (;;)
    {
      ((com.tencent.mm.ui.widget.a.d)localObject1).setMessage((CharSequence)paramView);
      ((com.tencent.mm.ui.widget.a.d)localObject1).afd(3);
      ((com.tencent.mm.ui.widget.a.d)localObject1).afc(3);
      ((com.tencent.mm.ui.widget.a.d)localObject1).a((CharSequence)getString(2131760315), true, null);
      ((com.tencent.mm.ui.widget.a.d)localObject1).show();
      localObject1 = getSystemService("clipboard");
      if (localObject1 != null) {
        break;
      }
      paramView = new v("null cannot be cast to non-null type android.text.ClipboardManager");
      AppMethodBeat.o(209676);
      throw paramView;
    }
    localObject1 = (ClipboardManager)localObject1;
    if (localObject1 != null) {
      try
      {
        ((ClipboardManager)localObject1).setText((CharSequence)paramView);
        AppMethodBeat.o(209676);
        return;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramView, "clip.setText error", new Object[0]);
        AppMethodBeat.o(209676);
        return;
      }
    }
    ad.e(this.TAG, "clipboard manager is null");
    AppMethodBeat.o(209676);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(209674);
    super.onCreate(paramBundle);
    setMMTitle(2131761225);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(209674);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(209675);
    super.onDestroy();
    AppMethodBeat.o(209675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(BizTestUI paramBizTestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(209673);
      this.oab.finish();
      AppMethodBeat.o(209673);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI
 * JD-Core Version:    0.7.0.1
 */