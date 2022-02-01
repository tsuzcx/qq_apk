package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(16)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "fileName", "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderCropAvatarUI
  extends MMFinderUI
{
  public static final a rGU;
  private final String TAG;
  private HashMap _$_findViewCache;
  private int dbL;
  private String dmK;
  private String fileName;
  private WxMediaCropLayout rGN;
  private final f rGO;
  private final f rGP;
  private final f rGQ;
  private final f rGR;
  private final f rGS;
  private final Runnable rGT;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167213);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderCropAvatarUI.class), "cropStyle", "getCropStyle()I")), (d.l.k)w.a(new u(w.bn(FinderCropAvatarUI.class), "rotateUndoBtn", "getRotateUndoBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderCropAvatarUI.class), "rotateBtn", "getRotateBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderCropAvatarUI.class), "finishBtn", "getFinishBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(FinderCropAvatarUI.class), "cancelBtn", "getCancelBtn()Landroid/view/View;")) };
    rGU = new a((byte)0);
    AppMethodBeat.o(167213);
  }
  
  public FinderCropAvatarUI()
  {
    AppMethodBeat.i(167218);
    this.TAG = "Finder.FinderCropAvatarUI";
    this.rGO = g.K((d.g.a.a)new c(this));
    this.rGP = g.K((d.g.a.a)new m(this));
    this.rGQ = g.K((d.g.a.a)new l(this));
    this.rGR = g.K((d.g.a.a)new d(this));
    this.rGS = g.K((d.g.a.a)new b(this));
    this.rGT = ((Runnable)new k(this));
    AppMethodBeat.o(167218);
  }
  
  private final int cBE()
  {
    AppMethodBeat.i(167214);
    int i = ((Number)this.rGO.getValue()).intValue();
    AppMethodBeat.o(167214);
    return i;
  }
  
  private final RectF cBF()
  {
    AppMethodBeat.i(167217);
    Object localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    d.g.b.k.g(localObject, "context.resources");
    float f1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    f1 -= ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    d.g.b.k.g(localObject, "context.resources");
    float f2 = (((Resources)localObject).getDisplayMetrics().heightPixels - f1) / 2.0F;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165292);
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(2131165292) + f1, f1 + f2);
    AppMethodBeat.o(167217);
    return localObject;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203104);
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
    AppMethodBeat.o(203104);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494026;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167216);
    Object localObject = findViewById(2131304254);
    d.g.b.k.g(localObject, "findViewById(R.id.round_crop)");
    this.rGN = ((WxMediaCropLayout)localObject);
    localObject = this.rGN;
    if (localObject == null) {
      d.g.b.k.aVY("roundCropLayout");
    }
    ((WxMediaCropLayout)localObject).setShowBorder(false);
    if (cBE() == 0)
    {
      localObject = this.rGN;
      if (localObject == null) {
        d.g.b.k.aVY("roundCropLayout");
      }
      ((WxMediaCropLayout)localObject).a(cBF(), WxCropOperationLayout.j.wzG);
    }
    for (;;)
    {
      localObject = this.rGN;
      if (localObject == null) {
        d.g.b.k.aVY("roundCropLayout");
      }
      long l = System.currentTimeMillis();
      String str = this.dmK;
      if (str == null) {
        d.g.b.k.fOy();
      }
      WxMediaCropLayout.a((WxMediaCropLayout)localObject, l, str, true, null, null, 24);
      AppMethodBeat.o(167216);
      return;
      if (cBE() == 1)
      {
        localObject = this.rGN;
        if (localObject == null) {
          d.g.b.k.aVY("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject).a(cBF(), WxCropOperationLayout.j.wzI);
      }
      else
      {
        localObject = this.rGN;
        if (localObject == null) {
          d.g.b.k.aVY("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject).a(cBF(), WxCropOperationLayout.j.wzH);
      }
    }
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(167215);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(201327616, 201327616);
    setLightNavigationbarIcon();
    paramBundle = findViewById(2131298860);
    paramBundle.setPadding(0, 0, 0, ap.ej((Context)getContext()));
    paramBundle.post((Runnable)new e(this, paramBundle));
    setActionbarColor(2131101053);
    this.dmK = getIntent().getStringExtra("key_source_img_path");
    this.fileName = getIntent().getStringExtra("key_result_file_name");
    this.dbL = getIntent().getIntExtra("key_crop_source", 0);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099654));
    initView();
    ((View)this.rGR.getValue()).setOnClickListener((View.OnClickListener)new FinderCropAvatarUI.f(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    ((View)this.rGQ.getValue()).setOnClickListener((View.OnClickListener)new h(this));
    ((View)this.rGS.getValue()).setOnClickListener((View.OnClickListener)new i(this));
    ((View)this.rGP.getValue()).setOnClickListener((View.OnClickListener)new j(this));
    AppMethodBeat.o(167215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$Companion;", "", "()V", "SOURCE_AVATAR_CROP", "", "SOURCE_COVER_CROP", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    b(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    c(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    d(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(167201);
      paramBundle.setPadding(0, 0, 0, ap.ej((Context)this.rGV.getContext()));
      AppMethodBeat.o(167201);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167205);
      this.rGV.finish();
      AppMethodBeat.o(167205);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167206);
      FinderCropAvatarUI.f(this.rGV).getLayout().fve();
      AppMethodBeat.o(167206);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167207);
      this.rGV.finish();
      AppMethodBeat.o(167207);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167208);
      FinderCropAvatarUI.f(this.rGV).getLayout().fvf();
      AppMethodBeat.o(167208);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167210);
      Object localObject = FinderCropAvatarUI.h(this.rGV);
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        AppMethodBeat.o(167210);
        return;
      }
      localObject = this.rGV;
      Context localContext = (Context)localObject;
      ((FinderCropAvatarUI)localObject).getString(2131755906);
      FinderCropAvatarUI.a((FinderCropAvatarUI)localObject, (Dialog)h.b(localContext, ((FinderCropAvatarUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)a.rGZ));
      AppMethodBeat.o(167210);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a rGZ;
      
      static
      {
        AppMethodBeat.i(167209);
        rGZ = new a();
        AppMethodBeat.o(167209);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    l(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    m(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI
 * JD-Core Version:    0.7.0.1
 */