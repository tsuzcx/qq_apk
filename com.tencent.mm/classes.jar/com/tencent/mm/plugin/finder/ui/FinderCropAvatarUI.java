package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.vfs.i;
import d.f;
import d.g;
import d.g.a.m;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(16)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "fileName", "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderCropAvatarUI
  extends MMFinderUI
{
  public static final a qLZ;
  private final String TAG;
  private HashMap _$_findViewCache;
  private int dep;
  private String dpa;
  private String fileName;
  private WxMediaCropLayout qLS;
  private final f qLT;
  private final f qLU;
  private final f qLV;
  private final f qLW;
  private final f qLX;
  private final Runnable qLY;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167213);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderCropAvatarUI.class), "cropStyle", "getCropStyle()I")), (d.l.k)w.a(new u(w.bk(FinderCropAvatarUI.class), "rotateUndoBtn", "getRotateUndoBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderCropAvatarUI.class), "rotateBtn", "getRotateBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderCropAvatarUI.class), "finishBtn", "getFinishBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderCropAvatarUI.class), "cancelBtn", "getCancelBtn()Landroid/view/View;")) };
    qLZ = new a((byte)0);
    AppMethodBeat.o(167213);
  }
  
  public FinderCropAvatarUI()
  {
    AppMethodBeat.i(167218);
    this.TAG = "Finder.FinderCropAvatarUI";
    this.qLT = g.E((d.g.a.a)new FinderCropAvatarUI.c(this));
    this.qLU = g.E((d.g.a.a)new m(this));
    this.qLV = g.E((d.g.a.a)new l(this));
    this.qLW = g.E((d.g.a.a)new d(this));
    this.qLX = g.E((d.g.a.a)new b(this));
    this.qLY = ((Runnable)new FinderCropAvatarUI.k(this));
    AppMethodBeat.o(167218);
  }
  
  private final int cqW()
  {
    AppMethodBeat.i(167214);
    int i = ((Number)this.qLT.getValue()).intValue();
    AppMethodBeat.o(167214);
    return i;
  }
  
  private final RectF cqX()
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
    AppMethodBeat.i(199134);
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
    AppMethodBeat.o(199134);
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
    this.qLS = ((WxMediaCropLayout)localObject);
    localObject = this.qLS;
    if (localObject == null) {
      d.g.b.k.aPZ("roundCropLayout");
    }
    ((WxMediaCropLayout)localObject).setShowBorder(false);
    if (cqW() == 0)
    {
      localObject = this.qLS;
      if (localObject == null) {
        d.g.b.k.aPZ("roundCropLayout");
      }
      ((WxMediaCropLayout)localObject).a(cqX(), WxCropOperationLayout.j.LpJ);
    }
    for (;;)
    {
      localObject = this.qLS;
      if (localObject == null) {
        d.g.b.k.aPZ("roundCropLayout");
      }
      long l = System.currentTimeMillis();
      String str = this.dpa;
      if (str == null) {
        d.g.b.k.fvU();
      }
      WxMediaCropLayout.a((WxMediaCropLayout)localObject, l, str, true, null, null, 24);
      AppMethodBeat.o(167216);
      return;
      if (cqW() == 1)
      {
        localObject = this.qLS;
        if (localObject == null) {
          d.g.b.k.aPZ("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject).a(cqX(), WxCropOperationLayout.j.LpL);
      }
      else
      {
        localObject = this.qLS;
        if (localObject == null) {
          d.g.b.k.aPZ("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject).a(cqX(), WxCropOperationLayout.j.LpK);
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
    paramBundle.setPadding(0, 0, 0, ap.eb((Context)getContext()));
    paramBundle.post((Runnable)new e(this, paramBundle));
    setActionbarColor(2131101053);
    this.dpa = getIntent().getStringExtra("key_source_img_path");
    this.fileName = getIntent().getStringExtra("key_result_file_name");
    this.dep = getIntent().getIntExtra("key_crop_source", 0);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099654));
    initView();
    ((View)this.qLW.getValue()).setOnClickListener((View.OnClickListener)new f(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    ((View)this.qLV.getValue()).setOnClickListener((View.OnClickListener)new h(this));
    ((View)this.qLX.getValue()).setOnClickListener((View.OnClickListener)new i(this));
    ((View)this.qLU.getValue()).setOnClickListener((View.OnClickListener)new j(this));
    AppMethodBeat.o(167215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$Companion;", "", "()V", "SOURCE_AVATAR_CROP", "", "SOURCE_COVER_CROP", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    b(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    d(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(167201);
      paramBundle.setPadding(0, 0, 0, ap.eb((Context)this.qMa.getContext()));
      AppMethodBeat.o(167201);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(167204);
      FinderCropAvatarUI.a(this.qMa);
      Object localObject2 = new b.b();
      if (FinderCropAvatarUI.b(this.qMa) == 1)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        ((b.b)localObject2).rDw = com.tencent.mm.plugin.finder.storage.b.coK();
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        ((b.b)localObject2).rDv = com.tencent.mm.plugin.finder.storage.b.coN();
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        ((b.b)localObject2).maxWidth = com.tencent.mm.plugin.finder.storage.b.coL();
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        ((b.b)localObject2).maxHeight = com.tencent.mm.plugin.finder.storage.b.coM();
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.finder.utils.k.qTp;
        ((b.b)localObject2).abC(com.tencent.mm.plugin.finder.utils.k.crX());
        Object localObject1 = FinderCropAvatarUI.c(this.qMa);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "default_finder_crop_photo.tmp";
        }
        ((b.b)localObject2).filename = paramView;
        paramView = ((b.b)localObject2).rDu + ((b.b)localObject2).filename;
        FinderCropAvatarUI.d(this.qMa);
        new StringBuilder("resultPath=").append(paramView).append(" size: ").append(i.aMN(FinderCropAvatarUI.f(this.qMa)) / 1024L);
        h.fmz();
        localObject1 = FinderCropAvatarUI.e(this.qMa).getCurrentCropInfo();
        localObject2 = new com.tencent.mm.plugin.gallery.picker.b.b((b.b)localObject2);
        String str = FinderCropAvatarUI.f(this.qMa);
        if (str == null) {
          d.g.b.k.fvU();
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject2, str, 1, ((WxMediaCropLayout.b)localObject1).cAl(), ((WxMediaCropLayout.b)localObject1).gtE, ((WxMediaCropLayout.b)localObject1).oSt, ((WxMediaCropLayout.b)localObject1).viewRect, 0, (m)new d.g.b.l(paramView) {});
        AppMethodBeat.o(167204);
        return;
        if (FinderCropAvatarUI.b(this.qMa) == 2)
        {
          paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
          ((b.b)localObject2).rDv = com.tencent.mm.plugin.finder.storage.b.coQ();
          paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
          ((b.b)localObject2).maxWidth = com.tencent.mm.plugin.finder.storage.b.coO();
          paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
          ((b.b)localObject2).maxHeight = com.tencent.mm.plugin.finder.storage.b.coP();
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167205);
      this.qMa.finish();
      AppMethodBeat.o(167205);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167206);
      FinderCropAvatarUI.e(this.qMa).getLayout().ffi();
      AppMethodBeat.o(167206);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167207);
      this.qMa.finish();
      AppMethodBeat.o(167207);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167208);
      FinderCropAvatarUI.e(this.qMa).getLayout().ffj();
      AppMethodBeat.o(167208);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    l(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI
 * JD-Core Version:    0.7.0.1
 */