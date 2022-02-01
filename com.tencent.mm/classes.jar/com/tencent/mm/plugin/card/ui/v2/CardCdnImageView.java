package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardCdnImageView;", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    setImgSavedPath(s.X(m.wun, "/"));
    AppMethodBeat.o(112401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardCdnImageView
 * JD-Core Version:    0.7.0.1
 */