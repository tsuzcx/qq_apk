package com.tencent.mm.openim.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenImOccupyUI5;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenImOccupyUI5
  extends MMActivity
{
  public static final a puv;
  
  static
  {
    AppMethodBeat.i(235928);
    puv = new a((byte)0);
    AppMethodBeat.o(235928);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return 0;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenImOccupyUI5$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.ui.OpenImOccupyUI5
 * JD-Core Version:    0.7.0.1
 */