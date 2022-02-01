package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardCdnImageView;", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "plugin-card_release"})
public final class CardCdnImageView
  extends CdnImageView
{
  public CardCdnImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112402);
    init();
    AppMethodBeat.o(112402);
  }
  
  public CardCdnImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112403);
    init();
    AppMethodBeat.o(112403);
  }
  
  private final void init()
  {
    AppMethodBeat.i(112401);
    setImgSavedPath(m.ozF + "/");
    AppMethodBeat.o(112401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardCdnImageView
 * JD-Core Version:    0.7.0.1
 */