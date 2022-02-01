package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.h.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vfs.e;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow;", "", "mComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "mSourceType", "", "mCapture", "mMediaType", "mShowRawButton", "", "maxDuration", "maxCount", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;IIIZII)V", "mMaxCount", "mMaxDuration", "goAlbumUI", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "goSightCaptureUI", "startChoose", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  public static final a kSY;
  private final com.tencent.mm.plugin.appbrand.jsapi.c cnl;
  private final int kST;
  private final int kSU;
  private final int kSV;
  private final int kSW;
  private final boolean kSX;
  private final int mMaxCount;
  
  static
  {
    AppMethodBeat.i(50542);
    kSY = new a((byte)0);
    AppMethodBeat.o(50542);
  }
  
  public c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(50541);
    this.cnl = paramc;
    this.kSU = paramInt1;
    this.kSV = paramInt2;
    this.kSW = paramInt3;
    this.kSX = paramBoolean;
    this.kST = Math.min(Math.max(paramInt4, 1), 60);
    this.mMaxCount = Math.min(Math.max(1, 1), 9);
    AppMethodBeat.o(50541);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(c paramc) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "<anonymous parameter 0>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(c paramc) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "sightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(c paramc) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(c paramc) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(c paramc) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$1"})
    static final class a
      implements e.a
    {
      a(c.f paramf, b paramb) {}
      
      public final void onClick()
      {
        AppMethodBeat.i(160624);
        this.kTd.G(new Object[] { b.a.kSR });
        AppMethodBeat.o(160624);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$2"})
    static final class b
      implements View.OnCreateContextMenuListener
    {
      b(c.f paramf, b paramb) {}
      
      public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(160625);
        paramContextMenu.add(0, 1, 0, (CharSequence)c.a(this.kTc.kSZ).getContext().getString(2131755747));
        paramContextMenu.add(0, 2, 1, (CharSequence)c.a(this.kTc.kSZ).getContext().getString(2131755754));
        AppMethodBeat.o(160625);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$3"})
    static final class c
      implements n.e
    {
      c(c.f paramf, b paramb) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(160627);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        default: 
          paramMenuItem = g.er(b.a.kSR);
        }
        for (;;)
        {
          paramMenuItem.b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
          AppMethodBeat.o(160627);
          return;
          paramMenuItem = c.c(this.kTc.kSZ);
          continue;
          paramMenuItem = c.d(this.kTc.kSZ);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$4"})
    static final class d
      implements com.tencent.mm.ui.widget.a.e.b
    {
      d(c.f paramf, b paramb) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(160628);
        this.kTd.G(new Object[] { b.a.kSR });
        AppMethodBeat.o(160628);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c
 * JD-Core Version:    0.7.0.1
 */