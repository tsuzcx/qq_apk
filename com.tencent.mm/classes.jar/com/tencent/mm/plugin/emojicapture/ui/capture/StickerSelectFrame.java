package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.loader.g;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frame", "Landroid/view/View;", "frameBg", "frameLoadingBg", "lensId", "", "loading", "loadingCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1;", "bindLensId", "", "notifyLoadingResult", "result", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onDetachedFromWindow", "setSelected", "selected", "", "plugin-emojicapture_release"})
public final class StickerSelectFrame
  extends FrameLayout
{
  private String pWT;
  final int qcU;
  final int qcV;
  final View qcW;
  final View qcX;
  private final a qcY;
  
  public StickerSelectFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(675);
    AppMethodBeat.o(675);
  }
  
  public StickerSelectFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(674);
    this.qcU = 2131232078;
    this.qcV = 2131232077;
    this.qcY = new a(this);
    View.inflate(paramContext, 2131493793, (ViewGroup)this);
    paramContext = findViewById(2131299436);
    p.g(paramContext, "findViewById(R.id.emoji_sticker_select_frame)");
    this.qcW = paramContext;
    paramContext = findViewById(2131299437);
    p.g(paramContext, "findViewById(R.id.emoji_sticker_select_loading)");
    this.qcX = paramContext;
    AppMethodBeat.o(674);
  }
  
  public final void adh(String paramString)
  {
    AppMethodBeat.i(671);
    this.pWT = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.qcW.setBackgroundResource(this.qcV);
      this.qcX.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    localObject = e.IGU;
    if (e.aTC(paramString))
    {
      this.qcW.setBackgroundResource(this.qcV);
      this.qcX.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    this.qcW.setBackgroundResource(this.qcU);
    this.qcX.setVisibility(0);
    AppMethodBeat.o(671);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(673);
    super.onDetachedFromWindow();
    e locale = e.IGU;
    e.b((f)this.qcY);
    AppMethodBeat.o(673);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(672);
    super.setSelected(paramBoolean);
    if (!paramBoolean)
    {
      locale = e.IGU;
      e.b((f)this.qcY);
      setVisibility(8);
      AppMethodBeat.o(672);
      return;
    }
    e locale = e.IGU;
    e.a((f)this.qcY);
    setVisibility(0);
    AppMethodBeat.o(672);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements f<g>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame
 * JD-Core Version:    0.7.0.1
 */