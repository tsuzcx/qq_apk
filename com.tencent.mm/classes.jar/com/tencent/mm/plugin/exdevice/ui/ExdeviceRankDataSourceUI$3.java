package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpn;
import java.util.Iterator;
import java.util.List;

final class ExdeviceRankDataSourceUI$3
  implements Runnable
{
  ExdeviceRankDataSourceUI$3(ExdeviceRankDataSourceUI paramExdeviceRankDataSourceUI, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(20116);
    ExdeviceRankDataSourceUI.b localb = ExdeviceRankDataSourceUI.b(this.lOR);
    Object localObject = this.lOS;
    localb.lOV.clear();
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      ExdeviceRankDataSourceUI.b(this.lOR).notifyDataSetChanged();
      AppMethodBeat.o(20116);
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cpn localcpn = (cpn)((Iterator)localObject).next();
        if (localcpn != null) {
          localb.lOV.add(ExdeviceRankDataSourceUI.a(localcpn));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.3
 * JD-Core Version:    0.7.0.1
 */