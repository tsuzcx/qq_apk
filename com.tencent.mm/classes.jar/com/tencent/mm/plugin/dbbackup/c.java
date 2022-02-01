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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private d pgL;
  private ap pgM = null;
  
  c(d paramd)
  {
    this.pgL = paramd;
  }
  
  private boolean b(final Context paramContext, final String[] paramArrayOfString)
  {
    int i = -1;
    int j = 0;
    AppMethodBeat.i(23048);
    final String str1 = com.tencent.mm.kernel.g.ajC().cachePath;
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
          AppMethodBeat.o(23048);
          return false;
          if (paramArrayOfString.equals("dump"))
          {
            i = 0;
            continue;
            if (paramArrayOfString.equals("make-test"))
            {
              i = 1;
              continue;
              if (paramArrayOfString.equals("recover-test"))
              {
                i = 2;
                continue;
                if (paramArrayOfString.equals("clear-test")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      paramArrayOfString = com.tencent.mm.kernel.g.ajC().ajg();
      if (paramArrayOfString == null)
      {
        com.tencent.mm.ui.base.h.c(paramContext, "没有找到损坏信息", "", true);
        AppMethodBeat.o(23048);
        return true;
      }
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193201);
          i.aYg(com.tencent.mm.loader.j.b.arQ() + "/MicroMsg");
          i.mC(i.aYr(paramArrayOfString), com.tencent.mm.loader.j.b.arQ() + "/MicroMsg/corrupted.zip");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193200);
              if (c.5.this.pgW != null) {
                c.5.this.pgW.dismiss();
              }
              com.tencent.mm.ui.base.h.c(c.5.this.val$context, "损坏信息已保存", "", true);
              AppMethodBeat.o(193200);
            }
          });
          AppMethodBeat.o(193201);
        }
      }, "DBCommand");
      AppMethodBeat.o(23048);
      return true;
      if (i.fv((String)localObject))
      {
        Toast.makeText(paramContext, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
        AppMethodBeat.o(23048);
        return true;
      }
      ba.aBQ();
      com.tencent.mm.model.c.getDataDB().ftT().close();
      i.aYg((String)localObject);
      i = j;
      while (i < 5)
      {
        paramArrayOfString = arrayOfString[i];
        i.mA(str1 + paramArrayOfString, str2 + paramArrayOfString);
        i += 1;
      }
      d.ew(paramContext);
      AppMethodBeat.o(23048);
      return true;
      if (!i.fv((String)localObject))
      {
        Toast.makeText(paramContext, "Corruption test database not exist.", 0).show();
        AppMethodBeat.o(23048);
        return true;
      }
      com.tencent.mm.ui.base.h.a(paramContext, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(23045);
          ba.aBQ();
          com.tencent.mm.model.c.getDataDB().ftT().close();
          paramAnonymousDialogInterface = arrayOfString;
          int i = paramAnonymousDialogInterface.length;
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            String str = paramAnonymousDialogInterface[paramAnonymousInt];
            i.deleteFile(str1 + str);
            i.mA(str2 + str, str1 + str);
            paramAnonymousInt += 1;
          }
          i.cZ(this.phb, true);
          d.ew(paramContext);
          AppMethodBeat.o(23045);
        }
      }, null);
      AppMethodBeat.o(23048);
      return true;
      if (!i.fv((String)localObject))
      {
        Toast.makeText(paramContext, "Corruption test database not exist.", 0).show();
        AppMethodBeat.o(23048);
        return true;
      }
      com.tencent.mm.ui.base.h.a(paramContext, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(193202);
          i.cZ(this.phb, true);
          Toast.makeText(paramContext, "Corruption test database cleared.", 0).show();
          AppMethodBeat.o(193202);
        }
      }, null);
      AppMethodBeat.o(23048);
      return true;
    }
    localObject = new StringBuilder(512);
    str1 = com.tencent.mm.kernel.g.ajC().ajg();
    ((StringBuilder)localObject).append("Corrupted DB: ");
    if (str1 == null)
    {
      ((StringBuilder)localObject).append("not exist");
      paramArrayOfString = new TextView(paramContext);
      paramArrayOfString.setText((CharSequence)localObject);
      paramArrayOfString.setGravity(8388627);
      paramArrayOfString.setTextSize(1, 10.0F);
      paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramArrayOfString.setTextColor(paramContext.getResources().getColor(2131099732));
      paramArrayOfString.setTypeface(Typeface.MONOSPACE);
      paramArrayOfString.setMovementMethod(new ScrollingMovementMethod());
      i = paramContext.getResources().getDimensionPixelSize(2131165480);
      paramArrayOfString.setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, paramArrayOfString, null);
      AppMethodBeat.o(23048);
      return true;
    }
    if (str1.contains("/ctest/")) {}
    for (paramArrayOfString = "test";; paramArrayOfString = "exists")
    {
      ((StringBuilder)localObject).append(paramArrayOfString);
      ((StringBuilder)localObject).append("\nCorrupted DB size: ").append(i.aYo(str1));
      ((StringBuilder)localObject).append("\nSaved master exists: ").append(i.fv(str1 + ".sm"));
      ((StringBuilder)localObject).append("\nContent backup exists: ").append(i.fv(str1 + ".bak"));
      break;
    }
  }
  
  private static boolean c(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(23050);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    int i;
    if (paramArrayOfString.length > 1) {
      try
      {
        i = Integer.decode(paramArrayOfString[1]).intValue();
        if ((i > 2) || (i < 0))
        {
          paramArrayOfString = new NumberFormatException();
          AppMethodBeat.o(23050);
          throw paramArrayOfString;
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
      AppMethodBeat.o(23050);
      return true;
      localai.set(89, Integer.valueOf(i));
      localai.fqc();
      paramArrayOfString = "Recovery status set to ".concat(String.valueOf(i));
      continue;
      paramArrayOfString = "Recovery status is ".concat(String.valueOf(localai.getInt(89, 0)));
    }
  }
  
  private boolean eu(final Context paramContext)
  {
    AppMethodBeat.i(23047);
    if (com.tencent.mm.kernel.g.ajC().ajg() == null)
    {
      com.tencent.mm.ui.base.h.l(paramContext, 2131762258, 2131755906);
      AppMethodBeat.o(23047);
      return true;
    }
    paramContext.getString(2131755906);
    Object localObject2 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131762257), false, null);
    Object localObject3 = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.b.class)).eYC();
    ((cc)localObject3).aCD();
    Object localObject1 = this.pgL;
    localObject3 = new b()
    {
      public final void Bo(final int paramAnonymousInt)
      {
        AppMethodBeat.i(23037);
        this.pgN.aCE();
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23036);
            if (c.1.this.pgO != null) {
              c.1.this.pgO.dismiss();
            }
            int i;
            switch (paramAnonymousInt)
            {
            case -1: 
            default: 
              i = 2131762256;
            }
            for (;;)
            {
              com.tencent.mm.ui.base.h.l(c.1.this.val$context, i, 2131755906);
              AppMethodBeat.o(23036);
              return;
              i = 2131762260;
              continue;
              i = 2131762259;
              continue;
              i = 2131762258;
            }
          }
        });
        AppMethodBeat.o(23037);
      }
    };
    paramContext = new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "DBRecoverStarted");
    localObject2 = new WakerLock(aj.getContext(), "MicroMsg.SubCoreDBBackup");
    localObject1 = new d.5((d)localObject1, paramContext, (b)localObject3, (WakerLock)localObject2);
    ad.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
    ((WakerLock)localObject2).lock();
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(181L, 28L, 1L, true);
    try
    {
      paramContext.createNewFile();
      label173:
      ((b)localObject1).Bo(-1);
      AppMethodBeat.o(23047);
      return true;
    }
    catch (IOException paramContext)
    {
      break label173;
    }
  }
  
  private static boolean ev(Context paramContext)
  {
    AppMethodBeat.i(23049);
    int i = SQLiteDebug.getLastErrorLine();
    Object localObject1 = SQLiteDebug.getLastIOTraceStats();
    if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
    {
      AppMethodBeat.o(23049);
      return true;
    }
    Object localObject2 = (SQLiteDebug.IOTraceStats)((ArrayList)localObject1).get(0);
    localObject1 = "";
    try
    {
      ba.aBQ();
      int j = com.tencent.mm.model.c.getUin();
      str1 = q.cH(true);
      str1 = com.tencent.mm.b.g.getMessageDigest((str1 + j).getBytes()).substring(0, 7);
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
      com.tencent.mm.plugin.report.service.g.yhR.g("DBCorrupt", str3, (Map)localObject2);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText(str3);
      ((TextView)localObject1).setGravity(8388627);
      ((TextView)localObject1).setTextSize(1, 10.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(paramContext.getResources().getColor(2131099732));
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      ((TextView)localObject1).setMovementMethod(new ScrollingMovementMethod());
      i = paramContext.getResources().getDimensionPixelSize(2131165480);
      ((TextView)localObject1).setPadding(i, i, i, i);
      com.tencent.mm.ui.base.h.a(paramContext, null, (View)localObject1, null);
      AppMethodBeat.o(23049);
      return true;
    }
  }
  
  public final boolean a(Context paramContext, final String[] paramArrayOfString, final String paramString)
  {
    AppMethodBeat.i(23051);
    paramString = paramArrayOfString[0];
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(23051);
        return false;
        if (paramString.equals("//recover-old"))
        {
          i = 0;
          continue;
          if (paramString.equals("//recover"))
          {
            i = 1;
            continue;
            if (paramString.equals("//post-recover"))
            {
              i = 2;
              continue;
              if (paramString.equals("//backupdb"))
              {
                i = 3;
                continue;
                if (paramString.equals("//recoverdb"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("//repairdb"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("//corruptdb"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("//iotracedb"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("//recover-status"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("//dbbusy"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("//fixdb")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    final boolean bool = eu(paramContext);
    AppMethodBeat.o(23051);
    return bool;
    paramArrayOfString = new Intent(paramContext, DBRecoveryUI.class);
    paramArrayOfString.putExtra("scene", 2);
    paramArrayOfString.setFlags(268435456);
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.ahp(), "com/tencent/mm/plugin/dbbackup/DBCommand", "newRecover", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/dbbackup/DBCommand", "newRecover", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(23051);
    return true;
    ba.aBQ();
    d.cbO();
    Toast.makeText(paramContext, "Post recovery cleanup done.", 0).show();
    AppMethodBeat.o(23051);
    return true;
    if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].equals("cipher")))
    {
      ba.aBQ();
      paramString = com.tencent.mm.model.c.ajl();
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
          label656:
          if (paramString.getInt(237571, 0) != 0) {}
          break;
        }
        break;
      }
      for (bool = true;; bool = false)
      {
        Toast.makeText(paramContext, "Database backup with cipher: ".concat(String.valueOf(bool)), 0).show();
        AppMethodBeat.o(23051);
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
        paramString.setInt(237571, 0);
        paramString.fqc();
        break label656;
        paramString.setInt(237571, 1);
        paramString.fqc();
        break label656;
      }
    }
    if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].equals("incremental"))) {}
    final long l;
    for (bool = true;; bool = false)
    {
      l = System.nanoTime();
      paramArrayOfString = com.tencent.mm.ui.base.h.b(paramContext, "Backing database up. Please wait...", false, null);
      if (this.pgL.a(bool, new b()
      {
        public final void Bo(final int paramAnonymousInt)
        {
          AppMethodBeat.i(23039);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23038);
              if (c.2.this.pgO != null) {
                c.2.this.pgO.dismiss();
              }
              String str;
              if (paramAnonymousInt == 0) {
                if (c.2.this.pgR)
                {
                  str = "incremental";
                  str = String.format("Database (%s) backup succeeded, elapsed %.2f seconds.", new Object[] { str, Float.valueOf((float)(System.nanoTime() - c.2.this.iaJ) / 1.0E+009F) });
                }
              }
              for (;;)
              {
                Toast.makeText(c.2.this.val$context, str, 0).show();
                AppMethodBeat.o(23038);
                return;
                str = "new";
                break;
                if (paramAnonymousInt == 1) {
                  str = "Database backup canceled.";
                } else {
                  str = "Database backup failed.";
                }
              }
            }
          });
          AppMethodBeat.o(23039);
        }
      })) {
        break;
      }
      if (paramArrayOfString != null) {
        paramArrayOfString.dismiss();
      }
      Toast.makeText(paramContext, "Database is busy.", 0).show();
      break;
    }
    if (paramArrayOfString.length > 1) {}
    for (paramArrayOfString = paramArrayOfString[1];; paramArrayOfString = null)
    {
      l = System.nanoTime();
      paramContext.getString(2131755906);
      paramString = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131762257), false, null);
      this.pgL.a(paramArrayOfString, new b()
      {
        public final void Bo(final int paramAnonymousInt)
        {
          AppMethodBeat.i(23041);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23040);
              if (c.3.this.pgO != null) {
                c.3.this.pgO.dismiss();
              }
              String str;
              if (paramAnonymousInt == 0) {
                str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - c.3.this.iaJ) / 1.0E+009F) });
              }
              for (;;)
              {
                Toast.makeText(c.3.this.val$context, str, 0).show();
                AppMethodBeat.o(23040);
                return;
                if (paramAnonymousInt == 1) {
                  str = "Database recovery canceled.";
                } else {
                  str = "Database recovery failed.";
                }
              }
            }
          });
          AppMethodBeat.o(23041);
        }
      });
      AppMethodBeat.o(23051);
      return true;
    }
    if (paramArrayOfString.length > 1)
    {
      paramArrayOfString = paramArrayOfString[1];
      l = System.nanoTime();
      paramContext.getString(2131755906);
      paramString = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131762257), false, null);
      i = this.pgL.b(paramArrayOfString, new b()
      {
        public final void Bo(final int paramAnonymousInt)
        {
          AppMethodBeat.i(23043);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23042);
              if (c.4.this.pgO != null) {
                c.4.this.pgO.dismiss();
              }
              String str;
              if (paramAnonymousInt == 0) {
                str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - c.4.this.iaJ) / 1.0E+009F) });
              }
              for (;;)
              {
                Toast.makeText(c.4.this.val$context, str, 0).show();
                AppMethodBeat.o(23042);
                return;
                if (paramAnonymousInt == 1) {
                  str = "Database recovery canceled.";
                } else {
                  str = "Database recovery failed.";
                }
              }
            }
          });
          AppMethodBeat.o(23043);
        }
      });
      if (i != 0)
      {
        if (paramString != null) {
          paramString.dismiss();
        }
        switch (i)
        {
        default: 
          i = 2131762256;
        }
      }
    }
    for (;;)
    {
      Toast.makeText(paramContext, i, 1).show();
      AppMethodBeat.o(23051);
      return true;
      paramArrayOfString = null;
      break;
      i = 2131762259;
      continue;
      i = 2131762258;
    }
    bool = b(paramContext, paramArrayOfString);
    AppMethodBeat.o(23051);
    return bool;
    bool = ev(paramContext);
    AppMethodBeat.o(23051);
    return bool;
    bool = c(paramContext, paramArrayOfString);
    AppMethodBeat.o(23051);
    return bool;
    if (this.pgM == null)
    {
      this.pgM = new ap("DBBusyTest", new c.8(this));
      this.pgM.sendEmptyMessage(1);
      Toast.makeText(paramContext, "TEST: Begin transaction", 1).show();
    }
    for (;;)
    {
      AppMethodBeat.o(23051);
      return true;
      this.pgM.sendEmptyMessage(2);
      this.pgM.quitSafely();
      this.pgM = null;
      Toast.makeText(paramContext, "TEST: End transaction", 1).show();
    }
    if (paramArrayOfString.length > 1)
    {
      paramArrayOfString = paramArrayOfString[1];
      i = -1;
      switch (paramArrayOfString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramArrayOfString = null;
        }
        break;
      }
      for (;;)
      {
        if (paramArrayOfString == null) {
          break label1424;
        }
        com.tencent.mm.sdk.g.b.c(new c.9(this, paramArrayOfString, com.tencent.mm.ui.base.h.b(paramContext, "正在执行修复", false, null), paramContext), "DBCommand");
        AppMethodBeat.o(23051);
        return true;
        if (!paramArrayOfString.equals("rconv-dirty")) {
          break;
        }
        i = 0;
        break;
        if (!paramArrayOfString.equals("duplicated-messages")) {
          break;
        }
        i = 1;
        break;
        paramArrayOfString = "DELETE FROM rconversation WHERE typeof(flag) <> 'integer'";
        continue;
        paramArrayOfString = "DELETE FROM message WHERE rowid NOT IN (SELECT max(rowid) FROM message GROUP BY talker,msgSvrId,createTime)";
      }
    }
    label1424:
    AppMethodBeat.o(23051);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c
 * JD-Core Version:    0.7.0.1
 */