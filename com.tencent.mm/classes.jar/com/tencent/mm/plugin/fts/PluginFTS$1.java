package com.tencent.mm.plugin.fts;

final class PluginFTS$1
  implements Runnable
{
  PluginFTS$1(PluginFTS paramPluginFTS) {}
  
  public final void run()
  {
    if (PluginFTS.access$200(this.kuy) != null) {
      PluginFTS.access$200(this.kuy).rollback();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.1
 * JD-Core Version:    0.7.0.1
 */