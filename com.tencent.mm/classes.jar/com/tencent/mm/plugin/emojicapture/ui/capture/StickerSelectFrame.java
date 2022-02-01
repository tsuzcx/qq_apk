package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.sticker.loader.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frame", "Landroid/view/View;", "frameBg", "frameLoadingBg", "lensId", "", "loading", "loadingCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1;", "bindLensId", "", "notifyLoadingResult", "result", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onDetachedFromWindow", "setSelected", "selected", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerSelectFrame
  extends FrameLayout
{
  private String ygo;
  final int ylA;
  final int ylB;
  final View ylC;
  final View ylD;
  private final a ylE;
  
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
    this.ylA = a.e.yej;
    this.ylB = a.e.yei;
    this.ylE = new a(this);
    View.inflate(paramContext, a.g.yfx, (ViewGroup)this);
    paramContext = findViewById(a.f.yei);
    s.s(paramContext, "findViewById(R.id.emoji_sticker_select_frame)");
    this.ylC = paramContext;
    paramContext = findViewById(a.f.yeS);
    s.s(paramContext, "findViewById(R.id.emoji_sticker_select_loading)");
    this.ylD = paramContext;
    AppMethodBeat.o(674);
  }
  
  public final void app(String paramString)
  {
    AppMethodBeat.i(671);
    this.ygo = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.ylC.setBackgroundResource(this.ylB);
      this.ylD.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    localObject = com.tencent.mm.sticker.loader.e.acCJ;
    if (com.tencent.mm.sticker.loader.e.buV(paramString))
    {
      this.ylC.setBackgroundResource(this.ylB);
      this.ylD.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    this.ylC.setBackgroundResource(this.ylA);
    this.ylD.setVisibility(0);
    AppMethodBeat.o(671);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(673);
    super.onDetachedFromWindow();
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.f.e)this.ylE);
    AppMethodBeat.o(673);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(672);
    super.setSelected(paramBoolean);
    if (!paramBoolean)
    {
      locale = com.tencent.mm.sticker.loader.e.acCJ;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.f.e)this.ylE);
      setVisibility(8);
      AppMethodBeat.o(672);
      return;
    }
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
    com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.f.e)this.ylE);
    setVisibility(0);
    AppMethodBeat.o(672);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.loader.f.e<g>
  {
    a(StickerSelectFrame paramStickerSelectFrame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame
 * JD-Core Version:    0.7.0.1
 */