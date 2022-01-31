package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureStickerHint;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "plugin-emojicapture_release"})
public final class CaptureStickerHint
  extends FrameLayout
{
  private final String TAG;
  private final ImageView lyF;
  private final TextView lyG;
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(3002);
    AppMethodBeat.o(3002);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3001);
    this.TAG = "MicroMsg.CaptureStickerHint";
    View.inflate(paramContext, 2130969360, (ViewGroup)this);
    paramContext = findViewById(2131823553);
    j.p(paramContext, "findViewById(R.id.emoji_capture_sticker_hint_icon)");
    this.lyF = ((ImageView)paramContext);
    paramContext = findViewById(2131823554);
    j.p(paramContext, "findViewById(R.id.emoji_capture_sticker_hint_text)");
    this.lyG = ((TextView)paramContext);
    AppMethodBeat.o(3001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */