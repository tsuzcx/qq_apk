package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.protocal.c.cch;
import java.util.Iterator;
import java.util.List;

final class ExdeviceRankDataSourceUI$3
  implements Runnable
{
  ExdeviceRankDataSourceUI$3(ExdeviceRankDataSourceUI paramExdeviceRankDataSourceUI, List paramList) {}
  
  public final void run()
  {
    ExdeviceRankDataSourceUI.b localb = ExdeviceRankDataSourceUI.b(this.jFt);
    Object localObject = this.jFu;
    localb.jFx.clear();
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      ExdeviceRankDataSourceUI.b(this.jFt).notifyDataSetChanged();
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cch localcch = (cch)((Iterator)localObject).next();
        if (localcch != null) {
          localb.jFx.add(ExdeviceRankDataSourceUI.a(localcch));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.3
 * JD-Core Version:    0.7.0.1
 */