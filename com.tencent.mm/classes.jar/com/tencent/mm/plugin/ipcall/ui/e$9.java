package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

final class e$9
  implements n.d
{
  e$9(e parame, k paramk, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(22041);
    if (paramInt == 0)
    {
      paramMenuItem = this.nRH;
      Object localObject = this.nRI;
      paramInt = this.nRJ;
      l locall;
      int i;
      if (((k)localObject).field_addressId > 0L)
      {
        locall = i.bJu();
        long l = ((k)localObject).field_addressId;
        if (l > 0L)
        {
          i = locall.db.delete("IPCallRecord", "addressId=?", new String[] { String.valueOf(l) });
          if (i < 0) {
            ab.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
          }
        }
      }
      for (;;)
      {
        localObject = paramMenuItem.nRy;
        ((h)localObject).nUB.remove(paramInt);
        ((h)localObject).notifyDataSetChanged();
        if (paramMenuItem.nRy.getCount() <= 0) {
          break;
        }
        paramMenuItem.nRz.setVisibility(8);
        AppMethodBeat.o(22041);
        return;
        locall = i.bJu();
        localObject = ((k)localObject).field_phonenumber;
        if (!bo.isNullOrNil((String)localObject))
        {
          i = locall.db.delete("IPCallRecord", "phonenumber=?", new String[] { localObject });
          if (i < 0) {
            ab.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[] { Integer.valueOf(i), localObject });
          }
        }
      }
      paramMenuItem.nRz.setVisibility(0);
    }
    AppMethodBeat.o(22041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.9
 * JD-Core Version:    0.7.0.1
 */