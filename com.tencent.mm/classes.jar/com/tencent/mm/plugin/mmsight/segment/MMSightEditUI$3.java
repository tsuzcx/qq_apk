package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class MMSightEditUI$3
  implements f.a
{
  MMSightEditUI$3(MMSightEditUI paramMMSightEditUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    if (MMSightEditUI.h(this.mlC) != null)
    {
      MMSightEditUI.h(this.mlC).start();
      MMSightEditUI.h(this.mlC).setLoop(true);
      MMSightEditUI.h(this.mlC).setAlpha(1.0F);
      ai.l(new MMSightEditUI.3.1(this), 300L);
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(this.mlC.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void ug()
  {
    MMSightEditUI.h(this.mlC).d(0.0D, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.3
 * JD-Core Version:    0.7.0.1
 */