package com.tencent.liteav;

import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.g.a;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCRenderAndDec$1
  implements g.a
{
  TXCRenderAndDec$1(TXCRenderAndDec paramTXCRenderAndDec) {}
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(146791);
    Object localObject = TXCRenderAndDec.access$000(this.a);
    if (localObject != null)
    {
      TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
      localTXSVideoFrame.width = ((g)localObject).n();
      localTXSVideoFrame.height = ((g)localObject).o();
      localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
      localTXSVideoFrame.loadI420BufferFromGL();
      localObject = TXCRenderAndDec.access$100(this.a);
      if (localObject != null) {
        ((n)localObject).onRenderVideoFrame(this.a.getID(), TXCRenderAndDec.access$200(this.a), localTXSVideoFrame);
      }
    }
    AppMethodBeat.o(146791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.TXCRenderAndDec.1
 * JD-Core Version:    0.7.0.1
 */