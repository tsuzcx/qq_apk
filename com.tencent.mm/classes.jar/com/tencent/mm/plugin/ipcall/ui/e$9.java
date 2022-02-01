package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.e;
import java.util.ArrayList;

final class e$9
  implements n.e
{
  e$9(e parame, k paramk, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(25657);
    if (paramInt == 0)
    {
      paramMenuItem = this.uPW;
      Object localObject = this.uPX;
      paramInt = this.uPY;
      l locall;
      int i;
      if (((k)localObject).field_addressId > 0L)
      {
        locall = i.ddN();
        long l = ((k)localObject).field_addressId;
        if (l > 0L)
        {
          i = locall.db.delete("IPCallRecord", "addressId=?", new String[] { String.valueOf(l) });
          if (i < 0) {
            ad.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
          }
        }
      }
      for (;;)
      {
        localObject = paramMenuItem.uPN;
        ((h)localObject).uSO.remove(paramInt);
        ((h)localObject).notifyDataSetChanged();
        if (paramMenuItem.uPN.getCount() <= 0) {
          break;
        }
        paramMenuItem.uPO.setVisibility(8);
        AppMethodBeat.o(25657);
        return;
        locall = i.ddN();
        localObject = ((k)localObject).field_phonenumber;
        if (!bt.isNullOrNil((String)localObject))
        {
          i = locall.db.delete("IPCallRecord", "phonenumber=?", new String[] { localObject });
          if (i < 0) {
            ad.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[] { Integer.valueOf(i), localObject });
          }
        }
      }
      paramMenuItem.uPO.setVisibility(0);
    }
    AppMethodBeat.o(25657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.9
 * JD-Core Version:    0.7.0.1
 */