package com.tencent.mm.plugin.emojicapture.ui.a;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
public final class a$d
  extends a.a
{
  public a$d(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(2937);
    AppMethodBeat.o(2937);
  }
  
  public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
  {
    AppMethodBeat.i(2936);
    j.q(paramb, "info");
    Object localObject = e.eME;
    localObject = e.SX().mJ(paramb.hPe);
    ImageView localImageView = this.iTH;
    j.p(localImageView, "icon");
    ((com.tencent.mm.loader.a.b)localObject).d(localImageView);
    localObject = this.gJk;
    j.p(localObject, "text");
    ((TextView)localObject).setText((CharSequence)paramb.name);
    AppMethodBeat.o(2936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a.d
 * JD-Core Version:    0.7.0.1
 */