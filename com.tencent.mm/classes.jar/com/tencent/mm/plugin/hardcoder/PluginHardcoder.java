package com.tencent.mm.plugin.hardcoder;

import android.os.SystemClock;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.y;

public class PluginHardcoder
  extends f
  implements b
{
  public void configure(g paramg)
  {
    if (paramg.Ex())
    {
      long l1 = SystemClock.elapsedRealtime();
      WXHardCoderJNI.initHardCoderParams(new a());
      long l2 = SystemClock.elapsedRealtime();
      y.i("MicroMsg.PluginHardcoder", "summerhardcoder initHardCoder[%d %d %d %d] take[%d]ms", new Object[] { Long.valueOf(com.tencent.mm.kernel.a.a.dLv), Long.valueOf(com.tencent.mm.kernel.a.a.dLw), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - com.tencent.mm.kernel.a.a.dLv) });
      WXHardCoderJNI.initHardCoder();
    }
  }
  
  public void dependency()
  {
    dependsOn(d.class);
    dependsOn(c.class);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    alias(b.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder
 * JD-Core Version:    0.7.0.1
 */