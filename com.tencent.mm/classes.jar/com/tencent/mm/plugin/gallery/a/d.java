package com.tencent.mm.plugin.gallery.a;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/mjtemplate/PreviewTemplateUI;", "", "uiHolder", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/gallery/ui/ImagePreviewUI;", "(Ljava/lang/ref/WeakReference;)V", "hintLayout", "Landroid/view/ViewGroup;", "hintText", "Landroid/widget/TextView;", "updateTemplateHint", "", "selectMediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final TextView FxM;
  final ViewGroup HGn;
  
  public d(WeakReference<ImagePreviewUI> paramWeakReference)
  {
    AppMethodBeat.i(289256);
    Object localObject1;
    if (paramWeakReference == null)
    {
      localObject1 = null;
      this.HGn = ((ViewGroup)localObject1);
      if (paramWeakReference != null) {
        break label74;
      }
      paramWeakReference = localObject2;
    }
    for (;;)
    {
      this.FxM = paramWeakReference;
      AppMethodBeat.o(289256);
      return;
      localObject1 = c.HFY;
      localObject1 = (ImagePreviewUI)c.h(paramWeakReference);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (ViewGroup)((ImagePreviewUI)localObject1).findViewById(b.e.template_hint_ll);
      break;
      label74:
      localObject1 = c.HFY;
      localObject1 = (ImagePreviewUI)c.h(paramWeakReference);
      paramWeakReference = localObject2;
      if (localObject1 != null) {
        paramWeakReference = (TextView)((ImagePreviewUI)localObject1).findViewById(b.e.template_hint_tv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.d
 * JD-Core Version:    0.7.0.1
 */