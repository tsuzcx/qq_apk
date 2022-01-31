package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class MMSightEditUI$3
  implements e.a
{
  MMSightEditUI$3(MMSightEditUI paramMMSightEditUI) {}
  
  public final void Es()
  {
    AppMethodBeat.i(54967);
    MMSightEditUI.j(this.oKK).e(0.0D, true);
    AppMethodBeat.o(54967);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(54966);
    if (MMSightEditUI.j(this.oKK) != null)
    {
      MMSightEditUI.j(this.oKK).start();
      MMSightEditUI.j(this.oKK).setLoop(true);
      MMSightEditUI.j(this.oKK).setAlpha(1.0F);
      al.p(new MMSightEditUI.3.1(this), 300L);
    }
    AppMethodBeat.o(54966);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54965);
    ab.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(this.oKK.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(54965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.3
 * JD-Core Version:    0.7.0.1
 */