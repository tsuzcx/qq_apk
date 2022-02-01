package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onModeSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mode", "", "getOnModeSelected", "()Lkotlin/jvm/functions/Function1;", "setOnModeSelected", "(Lkotlin/jvm/functions/Function1;)V", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerPreviewChangeMode
  extends FrameLayout
{
  private kotlin.g.a.b<? super Integer, ah> you;
  
  public StickerPreviewChangeMode(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(900);
    AppMethodBeat.o(900);
  }
  
  public StickerPreviewChangeMode(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(899);
    AppMethodBeat.o(899);
  }
  
  public StickerPreviewChangeMode(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(898);
    View.inflate(paramContext, a.g.yfy, (ViewGroup)this);
    findViewById(a.f.yfd).setOnClickListener(new StickerPreviewChangeMode..ExternalSyntheticLambda2(this));
    findViewById(a.f.yff).setOnClickListener(new StickerPreviewChangeMode..ExternalSyntheticLambda1(this));
    findViewById(a.f.yfe).setOnClickListener(new StickerPreviewChangeMode..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(898);
  }
  
  private static final void a(StickerPreviewChangeMode paramStickerPreviewChangeMode, View paramView)
  {
    AppMethodBeat.i(269458);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStickerPreviewChangeMode);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStickerPreviewChangeMode, "this$0");
    paramStickerPreviewChangeMode = paramStickerPreviewChangeMode.getOnModeSelected();
    if (paramStickerPreviewChangeMode != null) {
      paramStickerPreviewChangeMode.invoke(Integer.valueOf(0));
    }
    a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269458);
  }
  
  private static final void b(StickerPreviewChangeMode paramStickerPreviewChangeMode, View paramView)
  {
    AppMethodBeat.i(269462);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStickerPreviewChangeMode);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStickerPreviewChangeMode, "this$0");
    paramStickerPreviewChangeMode = paramStickerPreviewChangeMode.getOnModeSelected();
    if (paramStickerPreviewChangeMode != null) {
      paramStickerPreviewChangeMode.invoke(Integer.valueOf(1));
    }
    a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269462);
  }
  
  private static final void c(StickerPreviewChangeMode paramStickerPreviewChangeMode, View paramView)
  {
    AppMethodBeat.i(269467);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStickerPreviewChangeMode);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStickerPreviewChangeMode, "this$0");
    paramStickerPreviewChangeMode = paramStickerPreviewChangeMode.getOnModeSelected();
    if (paramStickerPreviewChangeMode != null) {
      paramStickerPreviewChangeMode.invoke(Integer.valueOf(2));
    }
    a.a(new Object(), "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269467);
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnModeSelected()
  {
    return this.you;
  }
  
  public final void setOnModeSelected(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.you = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode
 * JD-Core Version:    0.7.0.1
 */