package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;

final class BackupSelectExtUI$1
  implements DatePickerDialog.OnDateSetListener
{
  BackupSelectExtUI$1(BackupSelectExtUI paramBackupSelectExtUI, int paramInt) {}
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    paramDatePicker = new StringBuffer().append(String.format("%02d", new Object[] { Integer.valueOf(paramInt1) })).append(String.format("%02d", new Object[] { Integer.valueOf(paramInt2 + 1) })).append(String.format("%02d", new Object[] { Integer.valueOf(paramInt3) }));
    switch (this.val$id)
    {
    default: 
      return;
    case 1: 
      l = g.xt("000000");
      BackupSelectExtUI.a(this.hNo, l / 1000L * 1000L);
      BackupSelectExtUI.b(this.hNo).setSummary(BackupSelectExtUI.a(this.hNo).format(new Date(l)));
      BackupSelectExtUI.c(this.hNo).notifyDataSetChanged();
      paramDatePicker = this.hNo;
      if ((BackupSelectExtUI.d(this.hNo) != 0L) && (BackupSelectExtUI.e(this.hNo) != 0L)) {}
      for (bool = true;; bool = false)
      {
        paramDatePicker.enableOptionMenu(bool);
        return;
      }
    }
    long l = g.xt("000000");
    BackupSelectExtUI.b(this.hNo, l / 1000L * 1000L + 86400000L);
    BackupSelectExtUI.f(this.hNo).setSummary(BackupSelectExtUI.a(this.hNo).format(new Date(l)));
    BackupSelectExtUI.c(this.hNo).notifyDataSetChanged();
    paramDatePicker = this.hNo;
    if ((BackupSelectExtUI.d(this.hNo) != 0L) && (BackupSelectExtUI.e(this.hNo) != 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      paramDatePicker.enableOptionMenu(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI.1
 * JD-Core Version:    0.7.0.1
 */