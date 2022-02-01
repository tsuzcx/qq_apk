package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(16)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "coverRatio", "", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "cropType", "getCropType", "cropType$delegate", "fileName", "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getCoverVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderCropAvatarUI
  extends MMFinderUI
{
  public static final a Aqv;
  private WxMediaCropLayout Aqm;
  private final f Aqn;
  private final f Aqo;
  private final double Aqp;
  private final f Aqq;
  private final f Aqr;
  private final f Aqs;
  private final f Aqt;
  private final Runnable Aqu;
  private final String TAG;
  private HashMap _$_findViewCache;
  private String fKH;
  private String fileName;
  private int source;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(167213);
    Aqv = new a((byte)0);
    AppMethodBeat.o(167213);
  }
  
  public FinderCropAvatarUI()
  {
    AppMethodBeat.i(167218);
    this.TAG = "Finder.FinderCropAvatarUI";
    this.Aqn = g.ar((kotlin.g.a.a)new c(this));
    this.Aqo = g.ar((kotlin.g.a.a)new d(this));
    this.Aqp = 1.777777777777778D;
    this.Aqq = g.ar((kotlin.g.a.a)new n(this));
    this.Aqr = g.ar((kotlin.g.a.a)new m(this));
    this.Aqs = g.ar((kotlin.g.a.a)new e(this));
    this.Aqt = g.ar((kotlin.g.a.a)new b(this));
    this.Aqu = ((Runnable)new l(this));
    AppMethodBeat.o(167218);
  }
  
  private final int eal()
  {
    AppMethodBeat.i(167214);
    int i = ((Number)this.Aqn.getValue()).intValue();
    AppMethodBeat.o(167214);
    return i;
  }
  
  private final int eam()
  {
    AppMethodBeat.i(284060);
    int i = ((Number)this.Aqo.getValue()).intValue();
    AppMethodBeat.o(284060);
    return i;
  }
  
  private final RectF ean()
  {
    AppMethodBeat.i(167217);
    Object localObject = ar.au((Context)getContext());
    float f1 = ((Point)localObject).x;
    AppCompatActivity localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    f1 -= localAppCompatActivity.getResources().getDimension(b.d.Edge_6A);
    float f2 = (((Point)localObject).y - f1) / 2.0F;
    localObject = getContext();
    p.j(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(b.d.Edge_3A);
    localObject = getContext();
    p.j(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(b.d.Edge_3A) + f1, f1 + f2);
    AppMethodBeat.o(167217);
    return localObject;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(284066);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(284066);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(284065);
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
    AppMethodBeat.o(284065);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_crop_avatar_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167216);
    Object localObject1 = findViewById(com.tencent.mm.plugin.finder.b.f.round_crop);
    p.j(localObject1, "findViewById(R.id.round_crop)");
    this.Aqm = ((WxMediaCropLayout)localObject1);
    localObject1 = this.Aqm;
    if (localObject1 == null) {
      p.bGy("roundCropLayout");
    }
    ((WxMediaCropLayout)localObject1).setShowBorder(false);
    if (eal() == 0)
    {
      localObject1 = this.Aqm;
      if (localObject1 == null) {
        p.bGy("roundCropLayout");
      }
      ((WxMediaCropLayout)localObject1).a(ean(), WxCropOperationLayout.j.HWw);
    }
    for (;;)
    {
      localObject1 = this.Aqm;
      if (localObject1 == null) {
        p.bGy("roundCropLayout");
      }
      long l = System.currentTimeMillis();
      Object localObject2 = this.fKH;
      if (localObject2 == null) {
        p.iCn();
      }
      WxMediaCropLayout.a((WxMediaCropLayout)localObject1, l, (String)localObject2, true, null, null, 24);
      AppMethodBeat.o(167216);
      return;
      if (eal() == 1)
      {
        if (eam() == 1)
        {
          localObject1 = this.Aqm;
          if (localObject1 == null) {
            p.bGy("roundCropLayout");
          }
          localObject2 = getContext();
          p.j(localObject2, "context");
          float f3 = ((AppCompatActivity)localObject2).getResources().getDimension(b.d.Edge_3A);
          localObject2 = getContext();
          p.j(localObject2, "context");
          float f1 = ((AppCompatActivity)localObject2).getResources().getDimension(b.d.Edge_3A);
          localObject2 = getContext();
          p.j(localObject2, "context");
          localObject2 = ((AppCompatActivity)localObject2).getResources();
          p.j(localObject2, "context.resources");
          float f2 = ((Resources)localObject2).getDisplayMetrics().heightPixels / 2.0F;
          localObject2 = getContext();
          p.j(localObject2, "context");
          localObject2 = ((AppCompatActivity)localObject2).getResources();
          p.j(localObject2, "context.resources");
          float f4 = ((Resources)localObject2).getDisplayMetrics().widthPixels - f3 * 2.0F;
          float f5 = (float)(this.Aqp / 2.0D) * f4;
          if (f2 >= f5 + f1) {
            f1 = f2 - f5;
          }
          for (f2 += f5;; f2 = ((Resources)localObject2).getDisplayMetrics().heightPixels - f1)
          {
            ((WxMediaCropLayout)localObject1).a(new RectF(f3, f1, f4 + f3, f2), WxCropOperationLayout.j.HWy);
            break;
            localObject2 = getContext();
            p.j(localObject2, "context");
            localObject2 = ((AppCompatActivity)localObject2).getResources();
            p.j(localObject2, "context.resources");
          }
        }
        localObject1 = this.Aqm;
        if (localObject1 == null) {
          p.bGy("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject1).a(ean(), WxCropOperationLayout.j.HWy);
      }
      else
      {
        localObject1 = this.Aqm;
        if (localObject1 == null) {
          p.bGy("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject1).a(ean(), WxCropOperationLayout.j.HWx);
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
    paramBundle = findViewById(com.tencent.mm.plugin.finder.b.f.crop_content_layout);
    paramBundle.setPadding(0, 0, 0, ax.aB((Context)getContext()));
    paramBundle.post((Runnable)new f(this, paramBundle));
    setActionbarColor(b.c.transparent);
    this.fKH = getIntent().getStringExtra("key_source_img_path");
    this.fileName = getIntent().getStringExtra("key_result_file_name");
    this.source = getIntent().getIntExtra("key_crop_source", 0);
    setMMTitle("");
    setActionbarColor(getResources().getColor(b.c.BW_0));
    initView();
    ((View)this.Aqs.getValue()).setOnClickListener((View.OnClickListener)new g(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    ((View)this.Aqr.getValue()).setOnClickListener((View.OnClickListener)new i(this));
    ((View)this.Aqt.getValue()).setOnClickListener((View.OnClickListener)new j(this));
    ((View)this.Aqq.getValue()).setOnClickListener((View.OnClickListener)new k(this));
    AppMethodBeat.o(167215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$Companion;", "", "()V", "SOURCE_AVATAR_CROP", "", "SOURCE_COVER_CROP", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Integer>
  {
    c(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(167201);
      paramBundle.setPadding(0, 0, 0, ax.aB((Context)this.Aqw.getContext()));
      AppMethodBeat.o(167201);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(167204);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      FinderCropAvatarUI.a(this.Aqw);
      Object localObject2 = new b.b();
      if (FinderCropAvatarUI.b(this.Aqw) == 1)
      {
        paramView = d.AjH;
        ((b.b)localObject2).BXt = d.dSf();
        paramView = d.AjH;
        ((b.b)localObject2).BXs = d.dSi();
        paramView = d.AjH;
        ((b.b)localObject2).maxWidth = d.dSg();
        paramView = d.AjH;
        ((b.b)localObject2).maxHeight = d.dSh();
      }
      for (;;)
      {
        paramView = av.AJz;
        ((b.b)localObject2).aIu(av.egn());
        localObject1 = FinderCropAvatarUI.c(this.Aqw);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "default_finder_crop_photo.tmp";
        }
        ((b.b)localObject2).filename = paramView;
        paramView = ((b.b)localObject2).BXr + ((b.b)localObject2).filename;
        FinderCropAvatarUI.d(this.Aqw);
        new StringBuilder("resultPath=").append(paramView).append(" size: ").append(u.bBQ(FinderCropAvatarUI.e(this.Aqw)) / 1024L);
        com.tencent.d.f.h.ioq();
        localObject1 = FinderCropAvatarUI.f(this.Aqw).getCurrentCropInfo();
        localObject2 = new com.tencent.mm.plugin.gallery.picker.b.b((b.b)localObject2);
        String str = FinderCropAvatarUI.e(this.Aqw);
        if (str == null) {
          p.iCn();
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject2, str, 1, ((WxMediaCropLayout.b)localObject1).eum(), ((WxMediaCropLayout.b)localObject1).kXj, ((WxMediaCropLayout.b)localObject1).vcr, ((WxMediaCropLayout.b)localObject1).viewRect, 0, (m)new q(paramView) {});
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167204);
        return;
        if (FinderCropAvatarUI.b(this.Aqw) == 2)
        {
          paramView = d.AjH;
          ((b.b)localObject2).BXs = d.dSl();
          paramView = d.AjH;
          ((b.b)localObject2).maxWidth = d.dSj();
          paramView = d.AjH;
          ((b.b)localObject2).maxHeight = d.dSk();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167205);
      this.Aqw.finish();
      AppMethodBeat.o(167205);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167206);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderCropAvatarUI.f(this.Aqw).getLayout().icc();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167206);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167207);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Aqw.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167207);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167208);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderCropAvatarUI.f(this.Aqw).getLayout().icd();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167208);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167210);
      Object localObject = FinderCropAvatarUI.h(this.Aqw);
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        AppMethodBeat.o(167210);
        return;
      }
      localObject = this.Aqw;
      Context localContext = (Context)localObject;
      ((FinderCropAvatarUI)localObject).getString(b.j.app_tip);
      FinderCropAvatarUI.a((FinderCropAvatarUI)localObject, (Dialog)com.tencent.mm.ui.base.h.a(localContext, ((FinderCropAvatarUI)localObject).getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.AqA));
      AppMethodBeat.o(167210);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a AqA;
      
      static
      {
        AppMethodBeat.i(167209);
        AqA = new a();
        AppMethodBeat.o(167209);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<View>
  {
    m(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<View>
  {
    n(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI
 * JD-Core Version:    0.7.0.1
 */