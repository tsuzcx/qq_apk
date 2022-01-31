package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bw;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements a
{
  private d iMo;
  
  c(d paramd)
  {
    this.iMo = paramd;
  }
  
  private boolean b(final Context paramContext, String[] paramArrayOfString)
  {
    int i = -1;
    int j = 0;
    final String str1 = com.tencent.mm.kernel.g.DP().cachePath;
    Object localObject = str1 + "ctest/";
    str1 = str1 + "EnMicroMsg.db";
    final String str2 = (String)localObject + "EnMicroMsg.db";
    final String[] arrayOfString = new String[5];
    arrayOfString[0] = "";
    arrayOfString[1] = "-journal";
    arrayOfString[2] = "-wal";
    arrayOfString[3] = ".sm";
    arrayOfString[4] = ".bak";
    if (paramArrayOfString.length > 1)
    {
      paramArrayOfString = paramArrayOfString[1];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return false;
          if (paramArrayOfString.equals("make-test"))
          {
            i = 0;
            continue;
            if (paramArrayOfString.equals("recover-test"))
            {
              i = 1;
              continue;
              if (paramArrayOfString.equals("clear-test")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      if (com.tencent.mm.vfs.e.bK((String)localObject))
      {
        Toast.makeText(paramContext, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
        return true;
      }
      au.Hx();
      com.tencent.mm.model.c.Dv().cxg().close();
      com.tencent.mm.vfs.e.nb((String)localObject);
      i = j;
      while (i < 5)
      {
        paramArrayOfString = arrayOfString[i];
        com.tencent.mm.vfs.e.aA(str1 + paramArrayOfString, str2 + paramArrayOfString);
        i += 1;
      }
      d.cT(paramContext);
      return true;
      if (!com.tencent.mm.vfs.e.bK((String)localObject))
      {
        Toast.makeText(paramContext, "Corruption test database not exist.", 0).show();
        return true;
      }
      com.tencent.mm.ui.base.h.a(paramContext, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          au.Hx();
          com.tencent.mm.model.c.Dv().cxg().close();
          paramAnonymousDialogInterface = arrayOfString;
          int i = paramAnonymousDialogInterface.length;
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            String str = paramAnonymousDialogInterface[paramAnonymousInt];
            com.tencent.mm.vfs.e.deleteFile(str1 + str);
            com.tencent.mm.vfs.e.aA(str2 + str, str1 + str);
            paramAnonymousInt += 1;
          }
          com.tencent.mm.vfs.e.K(this.iMA, true);
          d.cT(paramContext);
        }
      }, null);
      return true;
      if (!com.tencent.mm.vfs.e.bK((String)localObject))
      {
        Toast.makeText(paramContext, "Corruption test database not exist.", 0).show();
        return true;
      }
      com.tencent.mm.ui.base.h.a(paramContext, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new c.6(this, (String)localObject, paramContext), null);
      return true;
    }
    localObject = new StringBuilder(512);
    str1 = com.tencent.mm.kernel.g.DP().Du();
    ((StringBuilder)localObject).append("Corrupted DB: ");
    if (str1 == null)
    {
      ((StringBuilder)localObject).append("not exist");
      paramArrayOfString = new TextView(paramContext);
      paramArrayOfString.setText((CharSequence)localObject);
      paramArrayOfString.setGravity(8388627);
      paramArrayOfString.setTextSize(1, 10.0F);
      paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramArrayOfString.setTextColor(-16744704);
      paramArrayOfString.setTypeface(Typeface.MONOSPACE);
      paramArrayOfString.setMovementMethod(new ScrollingMovementMethod());
      i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      paramArrayOfString.setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, paramArrayOfString, null);
      return true;
    }
    if (str1.contains("/ctest/")) {}
    for (paramArrayOfString = "test";; paramArrayOfString = "exists")
    {
      ((StringBuilder)localObject).append(paramArrayOfString);
      ((StringBuilder)localObject).append("\nCorrupted DB size: ").append(com.tencent.mm.vfs.e.aeQ(str1));
      ((StringBuilder)localObject).append("\nSaved master exists: ").append(com.tencent.mm.vfs.e.bK(str1 + ".sm"));
      ((StringBuilder)localObject).append("\nContent backup exists: ").append(com.tencent.mm.vfs.e.bK(str1 + ".bak"));
      break;
    }
  }
  
  private static boolean c(Context paramContext, String[] paramArrayOfString)
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    int i;
    if (paramArrayOfString.length > 1) {
      try
      {
        i = Integer.decode(paramArrayOfString[1]).intValue();
        if ((i > 2) || (i < 0)) {
          throw new NumberFormatException();
        }
      }
      catch (NumberFormatException paramArrayOfString)
      {
        paramArrayOfString = "Recovery status must be 0, 1 or 2";
      }
    }
    for (;;)
    {
      Toast.makeText(paramContext, paramArrayOfString, 0).show();
      return true;
      localz.o(89, Integer.valueOf(i));
      localz.mC(true);
      paramArrayOfString = "Recovery status set to " + i;
      continue;
      i = localz.getInt(89, 0);
      paramArrayOfString = "Recovery status is " + i;
    }
  }
  
  private boolean cR(Context paramContext)
  {
    if (com.tencent.mm.kernel.g.DP().Du() == null)
    {
      com.tencent.mm.ui.base.h.h(paramContext, R.l.recover_db_no_datafile, R.l.app_tip);
      return true;
    }
    paramContext.getString(R.l.app_tip);
    Object localObject2 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.recover_db_loading), false, null);
    Object localObject3 = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.b.class)).ckh();
    ((bw)localObject3).Il();
    Object localObject1 = this.iMo;
    localObject3 = new c.1(this, (bw)localObject3, (ProgressDialog)localObject2, paramContext);
    paramContext = new com.tencent.mm.vfs.b(ae.getContext().getFilesDir(), "DBRecoverStarted");
    localObject2 = new WakerLock(ae.getContext(), "MicroMsg.SubCoreDBBackup");
    localObject1 = new d.5((d)localObject1, paramContext, (b)localObject3, (WakerLock)localObject2);
    y.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
    ((WakerLock)localObject2).lock();
    com.tencent.mm.plugin.report.service.h.nFQ.a(181L, 28L, 1L, true);
    try
    {
      paramContext.createNewFile();
      label161:
      ((b)localObject1).pC(-1);
      return true;
    }
    catch (IOException paramContext)
    {
      break label161;
    }
  }
  
  private static boolean cS(Context paramContext)
  {
    int i = SQLiteDebug.getLastErrorLine();
    Object localObject1 = SQLiteDebug.getLastIOTraceStats();
    if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
      return true;
    }
    Object localObject2 = (SQLiteDebug.IOTraceStats)((ArrayList)localObject1).get(0);
    localObject1 = "";
    try
    {
      au.Hx();
      int j = com.tencent.mm.model.c.CK();
      str1 = q.zf();
      str1 = com.tencent.mm.a.g.o((str1 + j).getBytes()).substring(0, 7);
      localObject1 = str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str3;
        continue;
        String str2 = "";
      }
    }
    str3 = String.format("DB corrupted (line: %d, hash: %s) => %s", new Object[] { Integer.valueOf(i), localObject1, ((SQLiteDebug.IOTraceStats)localObject2).toString() });
    localObject1 = "";
    if (((SQLiteDebug.IOTraceStats)localObject2).lastReadPage != null) {
      localObject1 = Base64.encodeToString(((SQLiteDebug.IOTraceStats)localObject2).lastReadPage, 0);
    }
    if (((SQLiteDebug.IOTraceStats)localObject2).lastJournalReadPage != null)
    {
      str1 = Base64.encodeToString(((SQLiteDebug.IOTraceStats)localObject2).lastJournalReadPage, 0);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("lastReadPage", localObject1);
      ((HashMap)localObject2).put("lastJournalReadPage", str1);
      com.tencent.mm.plugin.report.service.h.nFQ.d("DBCorrupt", str3, (Map)localObject2);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText(str3);
      ((TextView)localObject1).setGravity(8388627);
      ((TextView)localObject1).setTextSize(1, 10.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(-16744704);
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      ((TextView)localObject1).setMovementMethod(new ScrollingMovementMethod());
      i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      ((TextView)localObject1).setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, (View)localObject1, null);
      return true;
    }
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    boolean bool2 = true;
    Object localObject = paramArrayOfString[0];
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        bool2 = false;
      }
      break;
    }
    label504:
    do
    {
      return bool2;
      if (!((String)localObject).equals("//recover-old")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("//recover")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("//post-recover")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("//backupdb")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("//recoverdb")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject).equals("//repairdb")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject).equals("//corruptdb")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject).equals("//iotracedb")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject).equals("//recover-status")) {
        break;
      }
      i = 8;
      break;
      return cR(paramContext);
      paramArrayOfString = new Intent(paramContext, DBRecoveryUI.class);
      paramArrayOfString.putExtra("scene", 2);
      paramArrayOfString.setFlags(268435456);
      paramContext.startActivity(paramArrayOfString);
      return true;
      au.Hx();
      d.aFy();
      Toast.makeText(paramContext, "Post recovery cleanup done.", 0).show();
      return true;
      if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].equals("cipher")))
      {
        au.Hx();
        localObject = com.tencent.mm.model.c.Dz();
        if (paramArrayOfString.length > 2)
        {
          paramArrayOfString = paramArrayOfString[2];
          i = -1;
        }
        switch (paramArrayOfString.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            if (((z)localObject).getInt(237571, 0) != 0) {}
            break;
          }
          break;
        }
        for (bool1 = true;; bool1 = false)
        {
          Toast.makeText(paramContext, "Database backup with cipher: " + bool1, 0).show();
          return true;
          if (!paramArrayOfString.equals("yes")) {
            break;
          }
          i = 0;
          break;
          if (!paramArrayOfString.equals("on")) {
            break;
          }
          i = 1;
          break;
          if (!paramArrayOfString.equals("1")) {
            break;
          }
          i = 2;
          break;
          if (!paramArrayOfString.equals("no")) {
            break;
          }
          i = 3;
          break;
          if (!paramArrayOfString.equals("off")) {
            break;
          }
          i = 4;
          break;
          if (!paramArrayOfString.equals("0")) {
            break;
          }
          i = 5;
          break;
          ((z)localObject).setInt(237571, 0);
          ((z)localObject).mC(true);
          break label504;
          ((z)localObject).setInt(237571, 1);
          ((z)localObject).mC(true);
          break label504;
        }
      }
      if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].equals("incremental"))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        l = System.nanoTime();
        paramArrayOfString = com.tencent.mm.ui.base.h.b(paramContext, "Backing database up. Please wait...", false, null);
        if (this.iMo.a(bool1, new c.2(this, paramArrayOfString, bool1, l, paramContext))) {
          break;
        }
        if (paramArrayOfString != null) {
          paramArrayOfString.dismiss();
        }
        Toast.makeText(paramContext, "Database is busy.", 0).show();
        return true;
      }
      if (paramArrayOfString.length > 1) {}
      for (paramArrayOfString = paramArrayOfString[1];; paramArrayOfString = null)
      {
        l = System.nanoTime();
        paramContext.getString(R.l.app_tip);
        localObject = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.recover_db_loading), false, null);
        this.iMo.a(paramArrayOfString, new c.3(this, (ProgressDialog)localObject, l, paramContext));
        return true;
      }
      if (paramArrayOfString.length <= 1) {
        break label947;
      }
      paramArrayOfString = paramArrayOfString[1];
      long l = System.nanoTime();
      paramContext.getString(R.l.app_tip);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.recover_db_loading), false, null);
      i = this.iMo.b(paramArrayOfString, new c.4(this, (ProgressDialog)localObject, l, paramContext));
    } while (i == 0);
    if (localObject != null) {
      ((ProgressDialog)localObject).dismiss();
    }
    switch (i)
    {
    default: 
      i = R.l.recover_db_fail;
    }
    for (;;)
    {
      Toast.makeText(paramContext, i, 1).show();
      return true;
      label947:
      paramArrayOfString = null;
      break;
      i = R.l.recover_db_no_enough_space;
      continue;
      i = R.l.recover_db_no_datafile;
    }
    return b(paramContext, paramArrayOfString);
    return cS(paramContext);
    return c(paramContext, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c
 * JD-Core Version:    0.7.0.1
 */