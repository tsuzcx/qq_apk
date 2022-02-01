package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
      paramMenuItem = this.vbI;
      Object localObject = this.vbJ;
      paramInt = this.vbK;
      l locall;
      int i;
      if (((k)localObject).field_addressId > 0L)
      {
        locall = i.dgF();
        long l = ((k)localObject).field_addressId;
        if (l > 0L)
        {
          i = locall.db.delete("IPCallRecord", "addressId=?", new String[] { String.valueOf(l) });
          if (i < 0) {
            ae.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
          }
        }
      }
      for (;;)
      {
        localObject = paramMenuItem.vbz;
        ((h)localObject).veB.remove(paramInt);
        ((h)localObject).notifyDataSetChanged();
        if (paramMenuItem.vbz.getCount() <= 0) {
          break;
        }
        paramMenuItem.vbA.setVisibility(8);
        AppMethodBeat.o(25657);
        return;
        locall = i.dgF();
        localObject = ((k)localObject).field_phonenumber;
        if (!bu.isNullOrNil((String)localObject))
        {
          i = locall.db.delete("IPCallRecord", "phonenumber=?", new String[] { localObject });
          if (i < 0) {
            ae.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[] { Integer.valueOf(i), localObject });
          }
        }
      }
      paramMenuItem.vbA.setVisibility(0);
    }
    AppMethodBeat.o(25657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.9
 * JD-Core Version:    0.7.0.1
 */