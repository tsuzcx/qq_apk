package com.tencent.mm.plugin.appbrand.game.f;

import com.tencent.magicbrush.engine.d;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.Callable;

final class a$a
  implements Callable<MBCanvasContentHolder>
{
  private int gdj;
  
  private a$a(int paramInt)
  {
    this.gdj = paramInt;
  }
  
  public final MBCanvasContentHolder ahn()
  {
    y.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: before");
    long l = System.currentTimeMillis();
    MBCanvasContentHolder localMBCanvasContentHolder = d.ec(this.gdj);
    y.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: capture using : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localMBCanvasContentHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a
 * JD-Core Version:    0.7.0.1
 */