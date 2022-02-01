package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onModeSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mode", "", "getOnModeSelected", "()Lkotlin/jvm/functions/Function1;", "setOnModeSelected", "(Lkotlin/jvm/functions/Function1;)V", "plugin-emojicapture_release"})
public final class StickerPreviewChangeMode
  extends FrameLayout
{
  private kotlin.g.a.b<? super Integer, x> vcB;
  
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
    View.inflate(paramContext, a.g.uSK, (ViewGroup)this);
    findViewById(a.f.uSp).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(895);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.vcC.getOnModeSelected();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(895);
      }
    });
    findViewById(a.f.uSr).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(896);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.vcC.getOnModeSelected();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(896);
      }
    });
    findViewById(a.f.uSq).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.vcC.getOnModeSelected();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(2));
        }
        a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(897);
      }
    });
    AppMethodBeat.o(898);
  }
  
  public final kotlin.g.a.b<Integer, x> getOnModeSelected()
  {
    return this.vcB;
  }
  
  public final void setOnModeSelected(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.vcB = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode
 * JD-Core Version:    0.7.0.1
 */