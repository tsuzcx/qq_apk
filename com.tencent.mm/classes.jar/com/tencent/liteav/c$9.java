package com.tencent.liteav;

import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.g.a;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class c$9
  implements g.a
{
  c$9(c paramc, WeakReference paramWeakReference) {}
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(146203);
    Object localObject = c.i(this.b);
    TXSVideoFrame localTXSVideoFrame;
    if (localObject != null)
    {
      localTXSVideoFrame = new TXSVideoFrame();
      localTXSVideoFrame.width = ((g)localObject).n();
      localTXSVideoFrame.height = ((g)localObject).o();
      localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
      if (c.j(this.b) != 2) {
        break label180;
      }
      if ((c.k(this.b) == null) || (c.k(this.b).length != localTXSVideoFrame.width * localTXSVideoFrame.height * 3 / 2)) {
        c.a(this.b, new byte[localTXSVideoFrame.width * localTXSVideoFrame.height * 3 / 2]);
      }
      localTXSVideoFrame.loadI420BufferFromGL(c.k(this.b));
      localTXSVideoFrame.data = c.k(this.b);
    }
    for (;;)
    {
      localObject = (n)this.a.get();
      if (localObject != null) {
        ((n)localObject).onRenderVideoFrame(this.b.getID(), c.l(this.b), localTXSVideoFrame);
      }
      AppMethodBeat.o(146203);
      return;
      label180:
      localTXSVideoFrame.loadI420BufferFromGL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.c.9
 * JD-Core Version:    0.7.0.1
 */