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
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(16)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "coverRatio", "", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "cropType", "getCropType", "cropType$delegate", "fileName", "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getCoverVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderCropAvatarUI
  extends MMFinderUI
{
  public static final a vJD;
  private final String TAG;
  private HashMap _$_findViewCache;
  private String dRr;
  private String fileName;
  private int source;
  private Dialog tipDialog;
  private final f vJA;
  private final f vJB;
  private final Runnable vJC;
  private WxMediaCropLayout vJu;
  private final f vJv;
  private final f vJw;
  private final double vJx;
  private final f vJy;
  private final f vJz;
  
  static
  {
    AppMethodBeat.i(167213);
    vJD = new a((byte)0);
    AppMethodBeat.o(167213);
  }
  
  public FinderCropAvatarUI()
  {
    AppMethodBeat.i(167218);
    this.TAG = "Finder.FinderCropAvatarUI";
    this.vJv = g.ah((kotlin.g.a.a)new c(this));
    this.vJw = g.ah((kotlin.g.a.a)new d(this));
    this.vJx = 1.777777777777778D;
    this.vJy = g.ah((kotlin.g.a.a)new n(this));
    this.vJz = g.ah((kotlin.g.a.a)new m(this));
    this.vJA = g.ah((kotlin.g.a.a)new e(this));
    this.vJB = g.ah((kotlin.g.a.a)new b(this));
    this.vJC = ((Runnable)new l(this));
    AppMethodBeat.o(167218);
  }
  
  private final int dzr()
  {
    AppMethodBeat.i(167214);
    int i = ((Number)this.vJv.getValue()).intValue();
    AppMethodBeat.o(167214);
    return i;
  }
  
  private final int dzs()
  {
    AppMethodBeat.i(252305);
    int i = ((Number)this.vJw.getValue()).intValue();
    AppMethodBeat.o(252305);
    return i;
  }
  
  private final RectF dzt()
  {
    AppMethodBeat.i(167217);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "context.resources");
    float f1 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = getContext();
    p.g(localObject, "context");
    f1 -= ((AppCompatActivity)localObject).getResources().getDimension(2131165308);
    localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources();
    p.g(localObject, "context.resources");
    float f2 = (((Resources)localObject).getDisplayMetrics().heightPixels - f1) / 2.0F;
    localObject = getContext();
    p.g(localObject, "context");
    float f3 = ((AppCompatActivity)localObject).getResources().getDimension(2131165299);
    localObject = getContext();
    p.g(localObject, "context");
    localObject = new RectF(f3, f2, ((AppCompatActivity)localObject).getResources().getDimension(2131165299) + f1, f1 + f2);
    AppMethodBeat.o(167217);
    return localObject;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252308);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252308);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252307);
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
    AppMethodBeat.o(252307);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494234;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167216);
    Object localObject1 = findViewById(2131307177);
    p.g(localObject1, "findViewById(R.id.round_crop)");
    this.vJu = ((WxMediaCropLayout)localObject1);
    localObject1 = this.vJu;
    if (localObject1 == null) {
      p.btv("roundCropLayout");
    }
    ((WxMediaCropLayout)localObject1).setShowBorder(false);
    if (dzr() == 0)
    {
      localObject1 = this.vJu;
      if (localObject1 == null) {
        p.btv("roundCropLayout");
      }
      ((WxMediaCropLayout)localObject1).a(dzt(), WxCropOperationLayout.j.BZH);
    }
    for (;;)
    {
      localObject1 = this.vJu;
      if (localObject1 == null) {
        p.btv("roundCropLayout");
      }
      long l = System.currentTimeMillis();
      Object localObject2 = this.dRr;
      if (localObject2 == null) {
        p.hyc();
      }
      WxMediaCropLayout.a((WxMediaCropLayout)localObject1, l, (String)localObject2, true, null, null, 24);
      AppMethodBeat.o(167216);
      return;
      if (dzr() == 1)
      {
        if (dzs() == 1)
        {
          localObject1 = this.vJu;
          if (localObject1 == null) {
            p.btv("roundCropLayout");
          }
          localObject2 = getContext();
          p.g(localObject2, "context");
          float f3 = ((AppCompatActivity)localObject2).getResources().getDimension(2131165299);
          localObject2 = getContext();
          p.g(localObject2, "context");
          float f1 = ((AppCompatActivity)localObject2).getResources().getDimension(2131165299);
          localObject2 = getContext();
          p.g(localObject2, "context");
          localObject2 = ((AppCompatActivity)localObject2).getResources();
          p.g(localObject2, "context.resources");
          float f2 = ((Resources)localObject2).getDisplayMetrics().heightPixels / 2.0F;
          localObject2 = getContext();
          p.g(localObject2, "context");
          localObject2 = ((AppCompatActivity)localObject2).getResources();
          p.g(localObject2, "context.resources");
          float f4 = ((Resources)localObject2).getDisplayMetrics().widthPixels - f3 * 2.0F;
          float f5 = (float)(this.vJx / 2.0D) * f4;
          if (f2 >= f5 + f1) {
            f1 = f2 - f5;
          }
          for (f2 += f5;; f2 = ((Resources)localObject2).getDisplayMetrics().heightPixels - f1)
          {
            ((WxMediaCropLayout)localObject1).a(new RectF(f3, f1, f4 + f3, f2), WxCropOperationLayout.j.BZJ);
            break;
            localObject2 = getContext();
            p.g(localObject2, "context");
            localObject2 = ((AppCompatActivity)localObject2).getResources();
            p.g(localObject2, "context.resources");
          }
        }
        localObject1 = this.vJu;
        if (localObject1 == null) {
          p.btv("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject1).a(dzt(), WxCropOperationLayout.j.BZJ);
      }
      else
      {
        localObject1 = this.vJu;
        if (localObject1 == null) {
          p.btv("roundCropLayout");
        }
        ((WxMediaCropLayout)localObject1).a(dzt(), WxCropOperationLayout.j.BZI);
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
    paramBundle = findViewById(2131299332);
    paramBundle.setPadding(0, 0, 0, au.aD((Context)getContext()));
    paramBundle.post((Runnable)new f(this, paramBundle));
    setActionbarColor(2131101287);
    this.dRr = getIntent().getStringExtra("key_source_img_path");
    this.fileName = getIntent().getStringExtra("key_result_file_name");
    this.source = getIntent().getIntExtra("key_crop_source", 0);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099654));
    initView();
    ((View)this.vJA.getValue()).setOnClickListener((View.OnClickListener)new g(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    ((View)this.vJz.getValue()).setOnClickListener((View.OnClickListener)new i(this));
    ((View)this.vJB.getValue()).setOnClickListener((View.OnClickListener)new j(this));
    ((View)this.vJy.getValue()).setOnClickListener((View.OnClickListener)new k(this));
    AppMethodBeat.o(167215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$Companion;", "", "()V", "SOURCE_AVATAR_CROP", "", "SOURCE_COVER_CROP", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Integer>
  {
    c(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    d(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(167201);
      paramBundle.setPadding(0, 0, 0, au.aD((Context)this.vJE.getContext()));
      AppMethodBeat.o(167201);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(167204);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      FinderCropAvatarUI.a(this.vJE);
      Object localObject2 = new b.b();
      if (FinderCropAvatarUI.b(this.vJE) == 1)
      {
        paramView = c.vCb;
        ((b.b)localObject2).xkZ = c.dqR();
        paramView = c.vCb;
        ((b.b)localObject2).xkY = c.dqU();
        paramView = c.vCb;
        ((b.b)localObject2).maxWidth = c.dqS();
        paramView = c.vCb;
        ((b.b)localObject2).maxHeight = c.dqT();
      }
      for (;;)
      {
        paramView = al.waC;
        ((b.b)localObject2).ayU(al.dEA());
        localObject1 = FinderCropAvatarUI.c(this.vJE);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "default_finder_crop_photo.tmp";
        }
        ((b.b)localObject2).filename = paramView;
        paramView = ((b.b)localObject2).xkX + ((b.b)localObject2).filename;
        FinderCropAvatarUI.d(this.vJE);
        new StringBuilder("resultPath=").append(paramView).append(" size: ").append(s.boW(FinderCropAvatarUI.e(this.vJE)) / 1024L);
        com.tencent.e.f.h.hkS();
        localObject1 = FinderCropAvatarUI.f(this.vJE).getCurrentCropInfo();
        localObject2 = new com.tencent.mm.plugin.gallery.picker.b.b((b.b)localObject2);
        String str = FinderCropAvatarUI.e(this.vJE);
        if (str == null) {
          p.hyc();
        }
        com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject2, str, 1, ((WxMediaCropLayout.b)localObject1).dRK(), ((WxMediaCropLayout.b)localObject1).iiw, ((WxMediaCropLayout.b)localObject1).rwL, ((WxMediaCropLayout.b)localObject1).viewRect, 0, (m)new q(paramView) {});
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167204);
        return;
        if (FinderCropAvatarUI.b(this.vJE) == 2)
        {
          paramView = c.vCb;
          ((b.b)localObject2).xkY = c.dqX();
          paramView = c.vCb;
          ((b.b)localObject2).maxWidth = c.dqV();
          paramView = c.vCb;
          ((b.b)localObject2).maxHeight = c.dqW();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167205);
      this.vJE.finish();
      AppMethodBeat.o(167205);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167206);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderCropAvatarUI.f(this.vJE).getLayout().hba();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167206);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167207);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vJE.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167207);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167208);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderCropAvatarUI.f(this.vJE).getLayout().hbb();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167208);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderCropAvatarUI paramFinderCropAvatarUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167210);
      Object localObject = FinderCropAvatarUI.h(this.vJE);
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        AppMethodBeat.o(167210);
        return;
      }
      localObject = this.vJE;
      Context localContext = (Context)localObject;
      ((FinderCropAvatarUI)localObject).getString(2131755998);
      FinderCropAvatarUI.a((FinderCropAvatarUI)localObject, (Dialog)com.tencent.mm.ui.base.h.a(localContext, ((FinderCropAvatarUI)localObject).getString(2131756029), false, (DialogInterface.OnCancelListener)a.vJI));
      AppMethodBeat.o(167210);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a vJI;
      
      static
      {
        AppMethodBeat.i(167209);
        vJI = new a();
        AppMethodBeat.o(167209);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<View>
  {
    m(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI
 * JD-Core Version:    0.7.0.1
 */