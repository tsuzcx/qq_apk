package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.c;

public class PluginFace
  extends com.tencent.mm.kernel.b.f
  implements a
{
  public void execute(g paramg)
  {
    y.i("MicroMsg.PluginFace", "hy: starting execute.");
    if (paramg.Ex()) {
      com.tencent.mm.vending.g.f.cLb().d(new b()).a(new PluginFace.1(this));
    }
  }
  
  public String name()
  {
    return "plugin-facedetect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.PluginFace
 * JD-Core Version:    0.7.0.1
 */