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
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frame", "Landroid/view/View;", "frameBg", "frameLoadingBg", "lensId", "", "loading", "loadingCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1;", "bindLensId", "", "notifyLoadingResult", "result", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onDetachedFromWindow", "setSelected", "selected", "", "plugin-emojicapture_release"})
public final class StickerSelectFrame
  extends FrameLayout
{
  private String pmO;
  final int psJ;
  final int psK;
  final View psL;
  final View psM;
  private final a psN;
  
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
    this.psJ = 2131232078;
    this.psK = 2131232077;
    this.psN = new a(this);
    View.inflate(paramContext, 2131493793, (ViewGroup)this);
    paramContext = findViewById(2131299436);
    k.g(paramContext, "findViewById(R.id.emoji_sticker_select_frame)");
    this.psL = paramContext;
    paramContext = findViewById(2131299437);
    k.g(paramContext, "findViewById(R.id.emoji_sticker_select_loading)");
    this.psM = paramContext;
    AppMethodBeat.o(674);
  }
  
  public final void YK(String paramString)
  {
    AppMethodBeat.i(671);
    this.pmO = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.psL.setBackgroundResource(this.psK);
      this.psM.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    localObject = e.GAP;
    if (e.aMy(paramString))
    {
      this.psL.setBackgroundResource(this.psK);
      this.psM.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    this.psL.setBackgroundResource(this.psJ);
    this.psM.setVisibility(0);
    AppMethodBeat.o(671);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(673);
    super.onDetachedFromWindow();
    e locale = e.GAP;
    e.b((f)this.psN);
    AppMethodBeat.o(673);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(672);
    super.setSelected(paramBoolean);
    if (!paramBoolean)
    {
      locale = e.GAP;
      e.b((f)this.psN);
      setVisibility(8);
      AppMethodBeat.o(672);
      return;
    }
    e locale = e.GAP;
    e.a((f)this.psN);
    setVisibility(0);
    AppMethodBeat.o(672);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements f<g>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame
 * JD-Core Version:    0.7.0.1
 */