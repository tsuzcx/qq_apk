package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onModeSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mode", "", "getOnModeSelected", "()Lkotlin/jvm/functions/Function1;", "setOnModeSelected", "(Lkotlin/jvm/functions/Function1;)V", "plugin-emojicapture_release"})
public final class StickerPreviewChangeMode
  extends FrameLayout
{
  private d.g.a.b<? super Integer, z> pZu;
  
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
    View.inflate(paramContext, 2131495641, (ViewGroup)this);
    findViewById(2131305233).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(895);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.pZv.getOnModeSelected();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(895);
      }
    });
    findViewById(2131305235).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(896);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.pZv.getOnModeSelected();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(896);
      }
    });
    findViewById(2131305234).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.pZv.getOnModeSelected();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(2));
        }
        a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(897);
      }
    });
    AppMethodBeat.o(898);
  }
  
  public final d.g.a.b<Integer, z> getOnModeSelected()
  {
    return this.pZu;
  }
  
  public final void setOnModeSelected(d.g.a.b<? super Integer, z> paramb)
  {
    this.pZu = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode
 * JD-Core Version:    0.7.0.1
 */