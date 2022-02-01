package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.report.live.s.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_STOP_LINK", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkMicIcon", "Landroid/widget/ImageView;", "linkMicTip", "Landroid/widget/TextView;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLinkMicGroup", "checkVisible", "isVisible", "", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "updateApplyLinkInfo", "plugin-finder_release"})
public final class b
{
  public final String TAG;
  final com.tencent.mm.live.c.b hOp;
  public final ViewGroup hwr;
  private final View uFA;
  public final TextView uFB;
  private final ImageView uFC;
  public final d uFw;
  o.g uhx;
  final int usX;
  e uvt;
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(248027);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    this.TAG = "Finder.FinderLiveAnchorMicEntranceWidget";
    this.uFA = this.hwr.findViewById(2131300876);
    this.uFB = ((TextView)this.hwr.findViewById(2131300877));
    this.uFC = ((ImageView)this.hwr.findViewById(2131300875));
    this.uhx = ((o.g)new c(this));
    paramViewGroup = this.uFC;
    paramb = this.hwr.getContext();
    p.g(paramb, "root.context");
    paramViewGroup.setImageDrawable(ar.e(paramb.getResources().getDrawable(2131690250), -1));
    this.uFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248022);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = com.tencent.mm.live.core.core.c.a.hAj;
        if (a.a.aDp())
        {
          u.makeText(this.uFD.hwr.getContext(), 2131760148, 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248022);
          return;
        }
        paramAnonymousView = this.uFD.uFw.getLiveData().uEB;
        Log.i(this.uFD.TAG, "click mic entrance, curLinkUser:".concat(String.valueOf(paramAnonymousView)));
        if (paramAnonymousView == null) {
          com.tencent.mm.live.c.b.b.a(this.uFD.hOp, com.tencent.mm.live.c.b.c.hNM);
        }
        for (;;)
        {
          paramAnonymousView = k.vkd;
          k.a(s.c.vnf, String.valueOf(s.x.vpw.action));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248022);
          return;
          paramAnonymousView = this.uFD;
          if (paramAnonymousView.uvt == null)
          {
            paramAnonymousView.uvt = new e(paramAnonymousView.hwr.getContext(), 1, true);
            localObject = paramAnonymousView.uvt;
            if (localObject != null) {
              ((e)localObject).hbs();
            }
          }
          localObject = paramAnonymousView.uvt;
          if (localObject != null) {
            ((e)localObject).hbr();
          }
          localObject = paramAnonymousView.uvt;
          if (localObject != null) {
            ((e)localObject).Dp(true);
          }
          localObject = paramAnonymousView.uvt;
          if (localObject != null) {
            ((e)localObject).a((o.f)new b.a(paramAnonymousView));
          }
          localObject = paramAnonymousView.uvt;
          if (localObject != null) {
            ((e)localObject).a(paramAnonymousView.uhx);
          }
          localObject = paramAnonymousView.uvt;
          if (localObject != null) {
            ((e)localObject).b((e.b)new b.b(paramAnonymousView));
          }
          paramAnonymousView = paramAnonymousView.uvt;
          if (paramAnonymousView != null) {
            paramAnonymousView.dGm();
          }
        }
      }
    });
    AppMethodBeat.o(248027);
  }
  
  public final void dju()
  {
    AppMethodBeat.i(248025);
    a.a locala = com.tencent.mm.live.core.core.c.a.hAj;
    if (a.a.aDp())
    {
      this.hwr.setVisibility(0);
      AppMethodBeat.o(248025);
      return;
    }
    if ((this.uFw.getLiveData().diZ()) && (!this.uFw.getLiveData().djm()) && (this.uFw.getLiveData().isLiveStarted()))
    {
      this.hwr.setVisibility(0);
      AppMethodBeat.o(248025);
      return;
    }
    this.hwr.setVisibility(8);
    AppMethodBeat.o(248025);
  }
  
  public final void djv()
  {
    AppMethodBeat.i(248026);
    if (!((Collection)this.uFw.getLiveData().uEz).isEmpty()) {}
    for (int i = 1; (i != 0) || (this.uFw.getLiveData().djs()) || (this.uFw.getLiveData().djr()); i = 0)
    {
      localObject1 = this.uFC;
      localObject2 = this.hwr.getContext();
      p.g(localObject2, "root.context");
      localObject2 = ((Context)localObject2).getResources().getDrawable(2131690250);
      Context localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject1).setImageDrawable(ar.e((Drawable)localObject2, localContext.getResources().getColor(2131099836)));
      localObject1 = this.uFA;
      p.g(localObject1, "linkMicGroup");
      localObject2 = this.hwr.getContext();
      p.g(localObject2, "root.context");
      ((View)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131232631));
      AppMethodBeat.o(248026);
      return;
    }
    Object localObject1 = this.uFC;
    Object localObject2 = this.hwr.getContext();
    p.g(localObject2, "root.context");
    ((ImageView)localObject1).setImageDrawable(ar.e(((Context)localObject2).getResources().getDrawable(2131690250), -1));
    localObject1 = this.uFA;
    p.g(localObject1, "linkMicGroup");
    localObject2 = this.hwr.getContext();
    p.g(localObject2, "root.context");
    ((View)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131232630));
    AppMethodBeat.o(248026);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements o.f
  {
    a(b paramb) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(248023);
      Object localObject = this.uFD.uvt;
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramm.clear();
      localObject = this.uFD;
      p.g(paramm, "menu");
      int i = ((b)localObject).usX;
      Context localContext = ((b)localObject).hwr.getContext();
      p.g(localContext, "root.context");
      int j = localContext.getResources().getColor(2131100712);
      localObject = ((b)localObject).hwr.getContext();
      p.g(localObject, "root.context");
      paramm.a(i, j, (CharSequence)((Context)localObject).getResources().getString(2131759982));
      AppMethodBeat.o(248023);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class b
    implements e.b
  {
    b(b paramb) {}
    
    public final void onDismiss()
    {
      this.uFD.uvt = null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements o.g
  {
    c(b paramb) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(248024);
      if (paramMenuItem != null) {}
      for (paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());; paramMenuItem = null)
      {
        paramInt = this.uFD.usX;
        if (paramMenuItem != null) {
          break;
        }
        AppMethodBeat.o(248024);
        return;
      }
      if (paramMenuItem.intValue() == paramInt)
      {
        Log.i(this.uFD.TAG, "SHEET_MORE_ACTION_STOP_LINK");
        if (this.uFD.hOp.getLiveRole() == 0)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.report.live.m.vli;
          com.tencent.mm.plugin.finder.report.live.m.ou(true);
        }
        com.tencent.mm.live.c.b.b.a(this.uFD.hOp, com.tencent.mm.live.c.b.c.hNP);
        paramMenuItem = this.uFD.uvt;
        if (paramMenuItem != null)
        {
          paramMenuItem.bMo();
          AppMethodBeat.o(248024);
          return;
        }
      }
      AppMethodBeat.o(248024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.b
 * JD-Core Version:    0.7.0.1
 */