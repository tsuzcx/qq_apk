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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frame", "Landroid/view/View;", "frameBg", "frameLoadingBg", "lensId", "", "loading", "loadingCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1;", "bindLensId", "", "notifyLoadingResult", "result", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onDetachedFromWindow", "setSelected", "selected", "", "plugin-emojicapture_release"})
public final class StickerSelectFrame
  extends FrameLayout
{
  private String rnS;
  final int rtS;
  final int rtT;
  final View rtU;
  final View rtV;
  private final a rtW;
  
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
    this.rtS = 2131232170;
    this.rtT = 2131232169;
    this.rtW = new a(this);
    View.inflate(paramContext, 2131493947, (ViewGroup)this);
    paramContext = findViewById(2131300050);
    p.g(paramContext, "findViewById(R.id.emoji_sticker_select_frame)");
    this.rtU = paramContext;
    paramContext = findViewById(2131300051);
    p.g(paramContext, "findViewById(R.id.emoji_sticker_select_loading)");
    this.rtV = paramContext;
    AppMethodBeat.o(674);
  }
  
  public final void anq(String paramString)
  {
    AppMethodBeat.i(671);
    this.rnS = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.rtU.setBackgroundResource(this.rtT);
      this.rtV.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    localObject = e.NNN;
    if (e.bix(paramString))
    {
      this.rtU.setBackgroundResource(this.rtT);
      this.rtV.setVisibility(8);
      AppMethodBeat.o(671);
      return;
    }
    this.rtU.setBackgroundResource(this.rtS);
    this.rtV.setVisibility(0);
    AppMethodBeat.o(671);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(673);
    super.onDetachedFromWindow();
    e locale = e.NNN;
    e.b((f)this.rtW);
    AppMethodBeat.o(673);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(672);
    super.setSelected(paramBoolean);
    if (!paramBoolean)
    {
      locale = e.NNN;
      e.b((f)this.rtW);
      setVisibility(8);
      AppMethodBeat.o(672);
      return;
    }
    e locale = e.NNN;
    e.a((f)this.rtW);
    setVisibility(0);
    AppMethodBeat.o(672);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame$loadingCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
  public static final class a
    implements f<g>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame
 * JD-Core Version:    0.7.0.1
 */