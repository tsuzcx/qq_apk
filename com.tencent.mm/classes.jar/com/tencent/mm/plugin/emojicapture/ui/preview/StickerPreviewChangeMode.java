package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewChangeMode;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onModeSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mode", "", "getOnModeSelected", "()Lkotlin/jvm/functions/Function1;", "setOnModeSelected", "(Lkotlin/jvm/functions/Function1;)V", "plugin-emojicapture_release"})
public final class StickerPreviewChangeMode
  extends FrameLayout
{
  private b<? super Integer, y> oSE;
  
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
        paramAnonymousView = this.oSF.getOnModeSelected();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.aA(Integer.valueOf(0));
          AppMethodBeat.o(895);
          return;
        }
        AppMethodBeat.o(895);
      }
    });
    findViewById(2131305235).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(896);
        paramAnonymousView = this.oSF.getOnModeSelected();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.aA(Integer.valueOf(1));
          AppMethodBeat.o(896);
          return;
        }
        AppMethodBeat.o(896);
      }
    });
    findViewById(2131305234).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(897);
        paramAnonymousView = this.oSF.getOnModeSelected();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.aA(Integer.valueOf(2));
          AppMethodBeat.o(897);
          return;
        }
        AppMethodBeat.o(897);
      }
    });
    AppMethodBeat.o(898);
  }
  
  public final b<Integer, y> getOnModeSelected()
  {
    return this.oSE;
  }
  
  public final void setOnModeSelected(b<? super Integer, y> paramb)
  {
    this.oSE = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewChangeMode
 * JD-Core Version:    0.7.0.1
 */