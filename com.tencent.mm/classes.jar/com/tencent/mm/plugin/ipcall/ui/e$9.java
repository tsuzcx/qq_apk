package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

final class e$9
  implements n.d
{
  e$9(e parame, k paramk, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject;
    l locall;
    int i;
    if (paramInt == 0)
    {
      paramMenuItem = this.lup;
      localObject = this.luq;
      paramInt = this.lur;
      if (((k)localObject).field_addressId <= 0L) {
        break label147;
      }
      locall = i.bcn();
      long l = ((k)localObject).field_addressId;
      if (l > 0L)
      {
        i = locall.dXw.delete("IPCallRecord", "addressId=?", new String[] { String.valueOf(l) });
        if (i < 0) {
          y.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
        }
      }
    }
    for (;;)
    {
      localObject = paramMenuItem.lug;
      ((h)localObject).lxo.remove(paramInt);
      ((h)localObject).notifyDataSetChanged();
      if (paramMenuItem.lug.getCount() <= 0) {
        break;
      }
      paramMenuItem.luh.setVisibility(8);
      return;
      label147:
      locall = i.bcn();
      localObject = ((k)localObject).field_phonenumber;
      if (!bk.bl((String)localObject))
      {
        i = locall.dXw.delete("IPCallRecord", "phonenumber=?", new String[] { localObject });
        if (i < 0) {
          y.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[] { Integer.valueOf(i), localObject });
        }
      }
    }
    paramMenuItem.luh.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.9
 * JD-Core Version:    0.7.0.1
 */