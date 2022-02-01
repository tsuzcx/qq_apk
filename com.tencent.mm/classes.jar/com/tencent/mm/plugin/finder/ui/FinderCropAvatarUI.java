package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@com.tencent.mm.ui.base.a(16)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "coverRatio", "", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "cropType", "getCropType", "cropType$delegate", "fileName", "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getCoverVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getLayoutId", "getNormalVisibleRect", "widthMargin", "", "whRatio", "heightMinMargin", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCropAvatarUI
  extends MMFinderUI
{
  private WxMediaCropLayout FQg;
  private final j FQh;
  private final j FQi;
  private final double FQj;
  private final j FQk;
  private final j FQl;
  private final j FQm;
  private final j FQn;
  private final Runnable FQo;
  private final String TAG;
  private String fileName;
  private String hQn;
  private int source;
  private Dialog tipDialog;
  
  public FinderCropAvatarUI()
  {
    AppMethodBeat.i(167218);
    this.TAG = "Finder.FinderCropAvatarUI";
    this.FQh = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.FQi = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.FQj = 1.777777777777778D;
    this.FQk = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.FQl = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.FQm = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.FQn = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.FQo = new FinderCropAvatarUI..ExternalSyntheticLambda7(this);
    AppMethodBeat.o(167218);
  }
  
  private static final void a(View paramView, FinderCropAvatarUI paramFinderCropAvatarUI)
  {
    AppMethodBeat.i(346986);
    s.u(paramFinderCropAvatarUI, "this$0");
    paramView.setPadding(0, 0, 0, bf.bk((Context)paramFinderCropAvatarUI.getContext()));
    AppMethodBeat.o(346986);
  }
  
  private static final void a(FinderCropAvatarUI paramFinderCropAvatarUI)
  {
    AppMethodBeat.i(347029);
    s.u(paramFinderCropAvatarUI, "this$0");
    Object localObject = paramFinderCropAvatarUI.tipDialog;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = (Context)paramFinderCropAvatarUI;
        paramFinderCropAvatarUI.getString(l.i.app_tip);
        paramFinderCropAvatarUI.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a((Context)localObject, paramFinderCropAvatarUI.getString(l.i.app_waiting), false, FinderCropAvatarUI..ExternalSyntheticLambda0.INSTANCE));
      }
      AppMethodBeat.o(347029);
      return;
      ((Dialog)localObject).show();
    }
  }
  
  private static final void a(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView)
  {
    AppMethodBeat.i(346999);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderCropAvatarUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderCropAvatarUI, "this$0");
    MMHandlerThread.postToMainThreadDelayed(paramFinderCropAvatarUI.FQo, 300L);
    localObject2 = new b.b();
    if (paramFinderCropAvatarUI.source == 1)
    {
      paramView = d.FAy;
      ((b.b)localObject2).HJG = d.eQs();
      paramView = d.FAy;
      ((b.b)localObject2).HJF = d.eQv();
      paramView = d.FAy;
      ((b.b)localObject2).maxWidth = d.eQt();
      paramView = d.FAy;
      ((b.b)localObject2).maxHeight = d.eQu();
    }
    for (;;)
    {
      paramView = bm.GlZ;
      ((b.b)localObject2).aES(bm.fil());
      localObject1 = paramFinderCropAvatarUI.fileName;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "default_finder_crop_photo.tmp";
      }
      ((b.b)localObject2).filename = paramView;
      final String str = s.X(((b.b)localObject2).HJE, ((b.b)localObject2).filename);
      new StringBuilder("resultPath=").append(str).append(" size: ").append(y.bEl(paramFinderCropAvatarUI.hQn) / 1024L);
      h.jXD();
      localObject1 = paramFinderCropAvatarUI.FQg;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("roundCropLayout");
        paramView = null;
      }
      paramView = paramView.getCurrentCropInfo();
      localObject1 = new com.tencent.mm.plugin.gallery.picker.b.b((b.b)localObject2);
      localObject2 = paramFinderCropAvatarUI.hQn;
      s.checkNotNull(localObject2);
      com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject1, (String)localObject2, 1, paramView.fBj(), paramView.Gl, paramView.yok, paramView.viewRect, 0, (m)new e(paramFinderCropAvatarUI, str));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346999);
      return;
      if (paramFinderCropAvatarUI.source == 2)
      {
        paramView = d.FAy;
        ((b.b)localObject2).HJF = d.eQy();
        paramView = d.FAy;
        ((b.b)localObject2).maxWidth = d.eQw();
        paramView = d.FAy;
        ((b.b)localObject2).maxHeight = d.eQx();
      }
    }
  }
  
  private static final boolean a(FinderCropAvatarUI paramFinderCropAvatarUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347005);
    s.u(paramFinderCropAvatarUI, "this$0");
    paramFinderCropAvatarUI.finish();
    AppMethodBeat.o(347005);
    return true;
  }
  
  private static final void b(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView)
  {
    AppMethodBeat.i(347013);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCropAvatarUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCropAvatarUI, "this$0");
    paramView = paramFinderCropAvatarUI.FQg;
    paramFinderCropAvatarUI = paramView;
    if (paramView == null)
    {
      s.bIx("roundCropLayout");
      paramFinderCropAvatarUI = null;
    }
    paramFinderCropAvatarUI.getLayout().jHq();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347013);
  }
  
  private static final void c(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView)
  {
    AppMethodBeat.i(347019);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCropAvatarUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCropAvatarUI, "this$0");
    paramFinderCropAvatarUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347019);
  }
  
  private static final void d(FinderCropAvatarUI paramFinderCropAvatarUI, View paramView)
  {
    AppMethodBeat.i(347023);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCropAvatarUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCropAvatarUI, "this$0");
    paramView = paramFinderCropAvatarUI.FQg;
    paramFinderCropAvatarUI = paramView;
    if (paramView == null)
    {
      s.bIx("roundCropLayout");
      paramFinderCropAvatarUI = null;
    }
    paramFinderCropAvatarUI.getLayout().jHr();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347023);
  }
  
  private final int faY()
  {
    AppMethodBeat.i(167214);
    int i = ((Number)this.FQh.getValue()).intValue();
    AppMethodBeat.o(167214);
    return i;
  }
  
  private final int faZ()
  {
    AppMethodBeat.i(346976);
    int i = ((Number)this.FQi.getValue()).intValue();
    AppMethodBeat.o(346976);
    return i;
  }
  
  private final RectF fba()
  {
    AppMethodBeat.i(167217);
    Object localObject = aw.bf((Context)getContext());
    float f1 = ((Point)localObject).x - getContext().getResources().getDimension(l.c.Edge_6A);
    float f2 = (((Point)localObject).y - f1) / 2.0F;
    localObject = new RectF(getContext().getResources().getDimension(l.c.Edge_3A), f2, getContext().getResources().getDimension(l.c.Edge_3A) + f1, f1 + f2);
    AppMethodBeat.o(167217);
    return localObject;
  }
  
  private static final void o(DialogInterface paramDialogInterface) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return l.f.finder_crop_avatar_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167216);
    Object localObject1 = findViewById(l.e.round_crop);
    s.s(localObject1, "findViewById(R.id.round_crop)");
    this.FQg = ((WxMediaCropLayout)localObject1);
    Object localObject2 = this.FQg;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("roundCropLayout");
      localObject1 = null;
    }
    ((WxMediaCropLayout)localObject1).setShowBorder(false);
    if (faY() == 0)
    {
      localObject2 = this.FQg;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("roundCropLayout");
        localObject1 = null;
      }
      ((WxMediaCropLayout)localObject1).a(fba(), WxCropOperationLayout.j.NTj);
    }
    for (;;)
    {
      localObject2 = this.FQg;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("roundCropLayout");
        localObject1 = null;
      }
      long l = System.currentTimeMillis();
      localObject2 = this.hQn;
      s.checkNotNull(localObject2);
      WxMediaCropLayout.a((WxMediaCropLayout)localObject1, l, (String)localObject2, true, null, null, 24);
      AppMethodBeat.o(167216);
      return;
      float f3;
      float f1;
      float f2;
      float f4;
      float f5;
      if (faY() == 1)
      {
        if (faZ() == 1)
        {
          localObject2 = this.FQg;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("roundCropLayout");
            localObject1 = null;
          }
          f3 = getContext().getResources().getDimension(l.c.Edge_3A);
          f1 = getContext().getResources().getDimension(l.c.Edge_3A);
          f2 = getContext().getResources().getDisplayMetrics().heightPixels / 2.0F;
          f4 = getContext().getResources().getDisplayMetrics().widthPixels - f3 * 2.0F;
          f5 = (float)(this.FQj / 2.0D) * f4;
          if (f2 >= f5 + f1) {
            f1 = f2 - f5;
          }
          for (f2 += f5;; f2 = getContext().getResources().getDisplayMetrics().heightPixels - f1)
          {
            ((WxMediaCropLayout)localObject1).a(new RectF(f3, f1, f4 + f3, f2), WxCropOperationLayout.j.NTl);
            break;
          }
        }
        localObject2 = this.FQg;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("roundCropLayout");
          localObject1 = null;
        }
        ((WxMediaCropLayout)localObject1).a(fba(), WxCropOperationLayout.j.NTl);
      }
      else
      {
        if (faY() == 2)
        {
          f3 = getContext().getResources().getDimension(l.c.Edge_2_5_A);
          localObject2 = this.FQg;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("roundCropLayout");
            localObject1 = null;
          }
          localObject2 = at.GiI;
          f4 = at.getScreenWidth() - 2.0F * f3;
          f2 = f4 * 1.0F;
          localObject2 = at.GiI;
          int i = at.getScreenHeight() / 2;
          if (f2 / 2.0F + f3 > i)
          {
            f2 = i * 2 - f3;
            f1 = f3;
          }
          for (;;)
          {
            ((WxMediaCropLayout)localObject1).a(new RectF(f3, f1, f4 + f3, f2), WxCropOperationLayout.j.NTl);
            break;
            f1 = i - f2 / 2.0F;
            f5 = i;
            f2 = f2 / 2.0F + f5;
          }
        }
        localObject2 = this.FQg;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("roundCropLayout");
          localObject1 = null;
        }
        ((WxMediaCropLayout)localObject1).a(fba(), WxCropOperationLayout.j.NTk);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167215);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(201327616, 201327616);
    setLightNavigationbarIcon();
    paramBundle = findViewById(l.e.crop_content_layout);
    paramBundle.setPadding(0, 0, 0, bf.bk((Context)getContext()));
    paramBundle.post(new FinderCropAvatarUI..ExternalSyntheticLambda6(paramBundle, this));
    setActionbarColor(l.b.transparent);
    this.hQn = getIntent().getStringExtra("key_source_img_path");
    this.fileName = getIntent().getStringExtra("key_result_file_name");
    this.source = getIntent().getIntExtra("key_crop_source", 0);
    setMMTitle("");
    setActionbarColor(getResources().getColor(l.b.BW_0));
    initView();
    ((View)this.FQm.getValue()).setOnClickListener(new FinderCropAvatarUI..ExternalSyntheticLambda2(this));
    setBackBtn(new FinderCropAvatarUI..ExternalSyntheticLambda1(this));
    ((View)this.FQl.getValue()).setOnClickListener(new FinderCropAvatarUI..ExternalSyntheticLambda3(this));
    ((View)this.FQn.getValue()).setOnClickListener(new FinderCropAvatarUI..ExternalSyntheticLambda5(this));
    ((View)this.FQk.getValue()).setOnClickListener(new FinderCropAvatarUI..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(167215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<View>
  {
    a(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    b(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    c(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<Boolean, b.f, ah>
  {
    e(FinderCropAvatarUI paramFinderCropAvatarUI, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<View>
  {
    g(FinderCropAvatarUI paramFinderCropAvatarUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI
 * JD-Core Version:    0.7.0.1
 */