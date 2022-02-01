package com.tencent.mm.plugin.emojicapture.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sticker.loader.a;
import com.tencent.mm.sticker.loader.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$e
  extends b.a
{
  public b$e(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(557);
    AppMethodBeat.o(557);
  }
  
  public final void c(dhp paramdhp)
  {
    AppMethodBeat.i(556);
    s.u(paramdhp, "info");
    Object localObject = h.acCW;
    localObject = h.getLoader().dk(new a(paramdhp));
    ImageView localImageView = dEI();
    s.s(localImageView, "icon");
    ((b)localObject).d(localImageView);
    dEJ().setText((CharSequence)paramdhp.IGU);
    AppMethodBeat.o(556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.b.e
 * JD-Core Version:    0.7.0.1
 */