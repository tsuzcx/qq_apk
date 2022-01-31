package com.tencent.mm.plugin.backup.backupui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    int i = d.atq();
    y.i(a.access$100(), "backupbanner onclick, backupMode[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      return;
    case 1: 
      i = com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu;
      y.i(a.access$100(), "backupbanner onclick, backupPcState[%d]", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        y.i(a.access$100(), "click backup banner, BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu) });
        return;
      case -4: 
      case 4: 
      case 5: 
      case 12: 
      case 14: 
      case 15: 
      case 22: 
      case 23: 
      case 28: 
        y.i(a.access$100(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu) });
        a.a(this.hNe, false);
        return;
      }
      y.i(a.access$100(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.auw().atn().hFu) });
      a.a(this.hNe, true);
      return;
    }
    i = com.tencent.mm.plugin.backup.d.b.atS().atn().hFu;
    y.i(a.access$100(), "backupbanner onclick, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      y.i(a.access$100(), "click backup banner,backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
      return;
    case -4: 
    case 4: 
    case 5: 
    case 12: 
    case 22: 
    case 23: 
    case 28: 
    case 52: 
      y.i(a.access$100(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
      a.b(this.hNe, false);
      return;
    }
    y.i(a.access$100(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[] { Integer.valueOf(i) });
    a.b(this.hNe, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a.1
 * JD-Core Version:    0.7.0.1
 */