package com.tencent.mm.plugin.finder.ui;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class FinderMediaCropUI$n$1
  extends u
  implements a<ah>
{
  FinderMediaCropUI$n$1(FinderMediaCropUI paramFinderMediaCropUI, m<? super List<? extends MediaSelectedData>, ? super Boolean, ah> paramm, ArrayList<MediaSelectedData> paramArrayList)
  {
    super(0);
  }
  
  private static final void a(m paramm, ArrayList paramArrayList, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(346795);
    s.u(paramm, "$callback");
    s.u(paramArrayList, "$failList");
    paramm.invoke(paramArrayList, Boolean.FALSE);
    AppMethodBeat.o(346795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.n.1
 * JD-Core Version:    0.7.0.1
 */