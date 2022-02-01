package com.tencent.matrix;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class e
{
  private static MultiProcessMMKV cQD = MultiProcessMMKV.getMMKV("MatrixDelegate");
  
  public static boolean VC()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Settings.canDrawOverlays(MMApplicationContext.getContext());
    }
    return true;
  }
  
  public static void addAction(IntentFilter paramIntentFilter)
  {
    paramIntentFilter.addAction("ENABLE_FPS");
    paramIntentFilter.addAction("MODIFY_EVIL_THRESHOLD");
    paramIntentFilter.addAction("ENABLE_METHOD_BEAT");
    paramIntentFilter.addAction("ENABLE_ANR");
    paramIntentFilter.addAction("ENABLE_START_UP");
    paramIntentFilter.addAction("ENABLE_EVIL_METHOD");
    paramIntentFilter.addAction("ENABLE_FPS_FLOAT");
    paramIntentFilter.addAction("ENABLE_DEV_LOG");
  }
  
  public static void k(Intent paramIntent)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i = 1;
    Object localObject = (com.tencent.matrix.trace.b)b.Vu().Y(com.tencent.matrix.trace.b.class);
    if (localObject == null) {}
    label99:
    label632:
    do
    {
      long l;
      do
      {
        return;
        if ("ENABLE_FPS".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).deH;
          bool = paramIntent.getBooleanExtra("ENABLE_FPS", ((f)localObject).dfl);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.c)localObject).Yk();
            if (!MMApplicationContext.isMainProcess()) {
              break label143;
            }
            paramIntent = cQD;
            localObject = a.a.Zbq.name();
            if (!bool) {
              break label145;
            }
          }
          for (i = 1;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.c)localObject).Yl();
            break label99;
            break;
          }
        }
        if ("ENABLE_FPS_FLOAT".equals(paramIntent.getAction()))
        {
          localObject = com.tencent.matrix.trace.view.a.bw(MMApplicationContext.getContext());
          ((com.tencent.matrix.trace.view.a)localObject).fL(MMApplicationContext.getProcessName());
          ((com.tencent.matrix.trace.view.a)localObject).dig = new e.1();
          bool = paramIntent.getBooleanExtra("ENABLE_FPS_FLOAT", false);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if ((bool) && (!VC()))
          {
            Log.e("Matrix.UISettingHandler", "permission denied for window type");
            return;
          }
          ((com.tencent.matrix.trace.view.a)localObject).dih = true;
          if (bool) {
            if (a.cQs.cQt)
            {
              ((com.tencent.matrix.trace.view.a)localObject).show();
              if (!MMApplicationContext.isMainProcess()) {
                break label319;
              }
              paramIntent = cQD;
              if (!bool) {
                break label321;
              }
            }
          }
          for (;;)
          {
            paramIntent.putInt("ENABLE_FPS_FLOAT", i).apply();
            return;
            Log.w("Matrix.UISettingHandler", "not in the foreground now!");
            break label269;
            ((com.tencent.matrix.trace.view.a)localObject).dismiss();
            ((com.tencent.matrix.trace.view.a)localObject).dih = false;
            break label269;
            break;
            i = -1;
          }
        }
        if ("ENABLE_START_UP".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).deG;
          bool = paramIntent.getBooleanExtra("ENABLE_START_UP", ((f)localObject).dfl);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.e)localObject).Yk();
            if (!MMApplicationContext.isMainProcess()) {
              break label438;
            }
            paramIntent = cQD;
            localObject = a.a.ZbA.name();
            if (!bool) {
              break label440;
            }
          }
          for (i = j;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.e)localObject).Yl();
            break label394;
            break;
          }
        }
        if ("ENABLE_EVIL_METHOD".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).deF;
          bool = paramIntent.getBooleanExtra("ENABLE_EVIL_METHOD", ((f)localObject).dfl);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.b)localObject).Yk();
            if (!MMApplicationContext.isMainProcess()) {
              break label557;
            }
            paramIntent = cQD;
            localObject = a.a.Zby.name();
            if (!bool) {
              break label559;
            }
          }
          for (i = k;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.b)localObject).Yl();
            break label513;
            break;
          }
        }
        if ("ENABLE_ANR".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).deI;
          bool = paramIntent.getBooleanExtra("ENABLE_ANR", ((f)localObject).dfl);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.a)localObject).Yk();
            if (!MMApplicationContext.isMainProcess()) {
              break label677;
            }
            paramIntent = cQD;
            localObject = a.a.Zbz.name();
            if (!bool) {
              break label679;
            }
          }
          for (i = m;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.a)localObject).Yl();
            break label632;
            break;
          }
        }
        if ("ENABLE_METHOD_BEAT".equals(paramIntent.getAction()))
        {
          localObject = com.tencent.matrix.trace.b.XX();
          bool = paramIntent.getBooleanExtra("ENABLE_METHOD_BEAT", ((AppMethodBeat)localObject).isAlive());
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((AppMethodBeat)localObject).onStart();
            return;
          }
          ((AppMethodBeat)localObject).onStop();
          return;
        }
        if ("ENABLE_DEV_LOG".equals(paramIntent.getAction()))
        {
          bool = paramIntent.getBooleanExtra("ENABLE_DEV_LOG", false);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          ((com.tencent.matrix.trace.b)localObject).deE.deR = bool;
          return;
        }
        if (!"MODIFY_EVIL_THRESHOLD".equals(paramIntent.getAction())) {
          break;
        }
        l = paramIntent.getLongExtra("MODIFY_EVIL_THRESHOLD", 700L);
        ((com.tencent.matrix.trace.b)localObject).deF.dgk = l;
      } while (!MMApplicationContext.isMainProcess());
      cQD.putLong(a.a.Zbt.name(), l).apply();
      return;
    } while (!"ENABLE_BATTERY".equals(paramIntent.getAction()));
    label143:
    label145:
    label319:
    label321:
    boolean bool = paramIntent.getBooleanExtra("ENABLE_BATTERY", false);
    label269:
    label438:
    label440:
    Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
    label394:
    label557:
    label559:
    paramIntent = (com.tencent.matrix.a.c)b.Vu().Y(com.tencent.matrix.a.c.class);
    label513:
    label677:
    label679:
    if (bool)
    {
      paramIntent.start();
      label945:
      if (!MMApplicationContext.isMainProcess()) {
        break label982;
      }
      paramIntent = cQD;
      if (!bool) {
        break label984;
      }
    }
    label982:
    label984:
    for (i = n;; i = -1)
    {
      paramIntent.putInt("ENABLE_BATTERY", i).apply();
      return;
      paramIntent.stop();
      break label945;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.e
 * JD-Core Version:    0.7.0.1
 */