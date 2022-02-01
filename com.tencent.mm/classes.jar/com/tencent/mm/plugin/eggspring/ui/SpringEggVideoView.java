package com.tencent.mm.plugin.eggspring.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setFilepath", "", "filepath", "", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SpringEggVideoView
  extends MMVideoView
{
  public SpringEggVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(108227);
    setScaleType(i.e.XYL);
    setIsShowBasicControls(false);
    AppMethodBeat.o(108227);
  }
  
  public SpringEggVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(108228);
    setScaleType(i.e.XYL);
    setIsShowBasicControls(false);
    AppMethodBeat.o(108228);
  }
  
  public final void setFilepath(String paramString)
  {
    AppMethodBeat.i(108226);
    super.setFilepath(paramString);
    AppMethodBeat.o(108226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringEggVideoView
 * JD-Core Version:    0.7.0.1
 */