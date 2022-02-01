package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b;
import com.tencent.mm.vfs.i;
import d.g.a.m;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderCropAvatarUI$f
  implements View.OnClickListener
{
  FinderCropAvatarUI$f(FinderCropAvatarUI paramFinderCropAvatarUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(167204);
    FinderCropAvatarUI.a(this.rGV);
    Object localObject2 = new b.b();
    if (FinderCropAvatarUI.b(this.rGV) == 1)
    {
      paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((b.b)localObject2).sMp = com.tencent.mm.plugin.finder.storage.b.cyi();
      paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((b.b)localObject2).sMo = com.tencent.mm.plugin.finder.storage.b.cyl();
      paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((b.b)localObject2).maxWidth = com.tencent.mm.plugin.finder.storage.b.cyj();
      paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((b.b)localObject2).maxHeight = com.tencent.mm.plugin.finder.storage.b.cyk();
    }
    for (;;)
    {
      paramView = p.rQw;
      ((b.b)localObject2).agu(p.cDo());
      Object localObject1 = FinderCropAvatarUI.c(this.rGV);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "default_finder_crop_photo.tmp";
      }
      ((b.b)localObject2).filename = paramView;
      paramView = ((b.b)localObject2).sMn + ((b.b)localObject2).filename;
      FinderCropAvatarUI.d(this.rGV);
      new StringBuilder("resultPath=").append(paramView).append(" size: ").append(i.aSp(FinderCropAvatarUI.e(this.rGV)) / 1024L);
      h.fCP();
      localObject1 = FinderCropAvatarUI.f(this.rGV).getCurrentCropInfo();
      localObject2 = new com.tencent.mm.plugin.gallery.picker.b.b((b.b)localObject2);
      String str = FinderCropAvatarUI.e(this.rGV);
      if (str == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.gallery.picker.b.b.a((com.tencent.mm.plugin.gallery.picker.b.b)localObject2, str, 1, ((WxMediaCropLayout.b)localObject1).cNu(), ((WxMediaCropLayout.b)localObject1).gUl, ((WxMediaCropLayout.b)localObject1).pvE, ((WxMediaCropLayout.b)localObject1).viewRect, 0, (m)new FinderCropAvatarUI.f.1(this, paramView));
      AppMethodBeat.o(167204);
      return;
      if (FinderCropAvatarUI.b(this.rGV) == 2)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        ((b.b)localObject2).sMo = com.tencent.mm.plugin.finder.storage.b.cyo();
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        ((b.b)localObject2).maxWidth = com.tencent.mm.plugin.finder.storage.b.cym();
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        ((b.b)localObject2).maxHeight = com.tencent.mm.plugin.finder.storage.b.cyn();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI.f
 * JD-Core Version:    0.7.0.1
 */