package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.vfs.o;
import d.f;
import d.g;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(16)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "fileName", "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getDefaultVisibilityRect", "Landroid/graphics/RectF;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderCropAvatarUI
  extends MMFinderUI
{
  public static final FinderCropAvatarUI.a sNi;
  private final String TAG;
  private HashMap _$_findViewCache;
  private int doj;
  private String dzD;
  private String fileName;
  private WxMediaCropLayout sNb;
  private final f sNc;
  private final f sNd;
  private final f sNe;
  private final f sNf;
  private final f sNg;
  private final Runnable sNh;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167213);
    sNi = new FinderCropAvatarUI.a((byte)0);
    AppMethodBeat.o(167213);
  }
  
  public FinderCropAvatarUI()
  {
    AppMethodBeat.i(167218);
    this.TAG = "Finder.FinderCropAvatarUI";
    this.sNc = g.O((d.g.a.a)new c(this));
    this.sNd = g.O((d.g.a.a)new m(this));
    this.sNe = g.O((d.g.a.a)new l(this));
    this.sNf = g.O((d.g.a.a)new d(this));
    this.sNg = g.O((d.g.a.a)new b(this));
    this.sNh = ((Runnable)new k(this));
    AppMethodBeat.o(167218);
  }
  
  private final int cMk()
  {
    AppMethodBeat.i(167214);
    int i = ((Number)this.sNc.getValue()).intValue();
    AppMethodBeat.o(167214);
    return i;
  }
  
  private final RectF cMl()
  {
    AppMethodBeat.i(167217);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "context.resources");
    float f1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = getContext();
    p.g(localObject, "context");
    f1 -= ((AppCompatActivity)localObject).getResources().getDimension(2131165298);
    localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "context.resources");
    float f2 = (((Resources)localObject).getDisplayMetrics().heightPixels - f1) / 2.0F;
    localObject = getContext();
    p.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165292);
    localObject = getContext();
    p.g(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(2131165292) + f1, f1 + f2);
    AppMethodBeat.o(167217);
    return localObject;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204550);
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
    AppMethodBeat.o(204550);
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
    p.g(localObject, "findViewById(R.id.round_crop)");
    this.sNb = ((WxMediaCropLayout)localObject);
    localObject = this.sNb;
    if (localObject == null) {
      p.bdF("roundCropLayout");
    }
    ((WxMediaCropLayout)localObject).setShowBorder(false);
    if (cMk() == 0)
    {
      localObject = this.sNb;
      if (localObject == null) {
        p.bdF("roundCropLayout");
      }
      ((WxMediaCropLayout)localObject).a(cMl(), WxCropOperationLayout.j.xYP);
    }
    for (;;)
    {
      localObject = this.sNb;
      if (localObject == null) {
        p.bdF("roundCropLayout");
      }
      long l = System.currentTimeMillis();
      String str = this.dzD;
      if (str == null) {
        p.gkB();
      }
      WxMediaCropLayout.a((WxMediaCropLayout)localObject, l, str, true, null, null, 24);
      AppMethodBeat.o(167216);
      return;
      if (cMk() == 1)
      {
        localObject = this.sNb;
        if (localObject == null) {
          p.bdF("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject).a(cMl(), WxCropOperationLayout.j.xYR);
      }
      else
      {
        localObject = this.sNb;
        if (localObject == null) {
          p.bdF("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject).a(cMl(), WxCropOperationLayout.j.xYQ);
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
    paramBundle.setPadding(0, 0, 0, ar.en((Context)getContext()));
    paramBundle.post((Runnable)new e(this, paramBundle));
    setActionbarColor(2131101053);
    this.dzD = getIntent().getStringExtra("key_source_img_path");
    this.fileName = getIntent().getStringExtra("key_result_file_name");
    this.doj = getIntent().getIntExtra("key_crop_source", 0);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099654));
    initView();
    ((View)this.sNf.getValue()).setOnClickListener((View.OnClickListener)new f(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    ((View)this.sNe.getValue()).setOnClickListener((View.OnClickListener)new h(this));
    ((View)this.sNg.getValue()).setOnClickListener((View.OnClickListener)new i(this));
    ((View)this.sNd.getValue()).setOnClickListener((View.OnClickListener)new j(this));
    AppMethodBeat.o(167215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<View>
  {
    b(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Integer>
  {
    c(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<View>
  {
    d(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(167201);
      paramBundle.setPadding(0, 0, 0, ar.en((Context)this.sNj.getContext()));
      AppMethodBeat.o(167201);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(167204);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      FinderCropAvatarUI.a(this.sNj);
      Object localObject2 = new b.b();
      if (FinderCropAvatarUI.b(this.sNj) == 1)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        ((b.b)localObject2).tTN = com.tencent.mm.plugin.finder.storage.b.cHh();
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        ((b.b)localObject2).tTM = com.tencent.mm.plugin.finder.storage.b.cHk();
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        ((b.b)localObject2).maxWidth = com.tencent.mm.plugin.finder.storage.b.cHi();
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        ((b.b)localObject2).maxHeight = com.tencent.mm.plugin.finder.storage.b.cHj();
      }
      for (;;)
      {
        paramView = r.sYn;
        ((b.b)localObject2).alQ(r.cOq());
        localObject1 = FinderCropAvatarUI.c(this.sNj);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "default_finder_crop_photo.tmp";
        }
        ((b.b)localObject2).filename = paramView;
        paramView = ((b.b)localObject2).tTL + ((b.b)localObject2).filename;
        FinderCropAvatarUI.d(this.sNj);
        new StringBuilder("resultPath=").append(paramView).append(" size: ").append(o.aZR(FinderCropAvatarUI.e(this.sNj)) / 1024L);
        com.tencent.d.f.h.fYG();
        localObject1 = FinderCropAvatarUI.f(this.sNj).getCurrentCropInfo();
        localObject2 = new com.tencent.mm.plugin.gallery.picker.b.b((b.b)localObject2);
        String str = FinderCropAvatarUI.e(this.sNj);
        if (str == null) {
          p.gkB();
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject2, str, 1, ((WxMediaCropLayout.b)localObject1).cYr(), ((WxMediaCropLayout.b)localObject1).hpa, ((WxMediaCropLayout.b)localObject1).qfO, ((WxMediaCropLayout.b)localObject1).viewRect, 0, (m)new q(paramView) {});
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167204);
        return;
        if (FinderCropAvatarUI.b(this.sNj) == 2)
        {
          paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
          ((b.b)localObject2).tTM = com.tencent.mm.plugin.finder.storage.b.cHn();
          paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
          ((b.b)localObject2).maxWidth = com.tencent.mm.plugin.finder.storage.b.cHl();
          paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
          ((b.b)localObject2).maxHeight = com.tencent.mm.plugin.finder.storage.b.cHm();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167205);
      this.sNj.finish();
      AppMethodBeat.o(167205);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167206);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderCropAvatarUI.f(this.sNj).getLayout().fQj();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167206);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167207);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.sNj.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167207);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167208);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderCropAvatarUI.f(this.sNj).getLayout().fQk();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167208);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167210);
      Object localObject = FinderCropAvatarUI.h(this.sNj);
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        AppMethodBeat.o(167210);
        return;
      }
      localObject = this.sNj;
      Context localContext = (Context)localObject;
      ((FinderCropAvatarUI)localObject).getString(2131755906);
      FinderCropAvatarUI.a((FinderCropAvatarUI)localObject, (Dialog)com.tencent.mm.ui.base.h.b(localContext, ((FinderCropAvatarUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)FinderCropAvatarUI.k.a.sNn));
      AppMethodBeat.o(167210);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<View>
  {
    l(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<View>
  {
    m(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI
 * JD-Core Version:    0.7.0.1
 */