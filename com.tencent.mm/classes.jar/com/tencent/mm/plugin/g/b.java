package com.tencent.mm.plugin.g;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class b
  extends a
{
  public final void execute(g paramg)
  {
    k.b("FFmpeg", getClass().getClassLoader());
    k.b("wechatpack", getClass().getClassLoader());
  }
  
  public final String name()
  {
    return "boot-load-FFmpeg-and-wechatpack-libraries";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.g.b
 * JD-Core Version:    0.7.0.1
 */