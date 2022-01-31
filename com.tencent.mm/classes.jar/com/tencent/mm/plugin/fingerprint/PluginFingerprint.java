package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fingerprint.a.a;

public class PluginFingerprint
  extends f
  implements a
{
  public void configure(g paramg)
  {
    paramg.Ex();
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    paramg.Ex();
  }
  
  public void installed()
  {
    alias(PluginFingerprint.class);
  }
  
  public String name()
  {
    return "plugin-fingerprint";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.PluginFingerprint
 * JD-Core Version:    0.7.0.1
 */