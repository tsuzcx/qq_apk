package com.tencent.matrix;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.e;
import com.tencent.matrix.trace.tracer.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class f
{
  private static MultiProcessMMKV eLH = MultiProcessMMKV.getMMKV("MatrixDelegate");
  
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
  
  public static boolean awl()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Settings.canDrawOverlays(MMApplicationContext.getContext());
    }
    return true;
  }
  
  public static void l(Intent paramIntent)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i = 1;
    Object localObject = (com.tencent.matrix.trace.b)c.avW().ai(com.tencent.matrix.trace.b.class);
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
          localObject = ((com.tencent.matrix.trace.b)localObject).fdr;
          bool = paramIntent.getBooleanExtra("ENABLE_FPS", ((g)localObject).fez);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.tracer.b)localObject).aAa();
            if (!MMApplicationContext.isMainProcess()) {
              break label143;
            }
            paramIntent = eLH;
            localObject = a.a.agZX.name();
            if (!bool) {
              break label145;
            }
          }
          for (i = 1;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.tracer.b)localObject).aAb();
            break label99;
            break;
          }
        }
        if ("ENABLE_FPS_FLOAT".equals(paramIntent.getAction()))
        {
          localObject = com.tencent.matrix.trace.view.a.cj(MMApplicationContext.getContext());
          ((com.tencent.matrix.trace.view.a)localObject).hn(MMApplicationContext.getProcessName());
          ((com.tencent.matrix.trace.view.a)localObject).fhU = new f.1();
          bool = paramIntent.getBooleanExtra("ENABLE_FPS_FLOAT", false);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if ((bool) && (!awl()))
          {
            Log.e("Matrix.UISettingHandler", "permission denied for window type");
            return;
          }
          ((com.tencent.matrix.trace.view.a)localObject).egk = true;
          if (bool) {
            if (a.eLw.eLx)
            {
              ((com.tencent.matrix.trace.view.a)localObject).show();
              if (!MMApplicationContext.isMainProcess()) {
                break label319;
              }
              paramIntent = eLH;
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
            ((com.tencent.matrix.trace.view.a)localObject).egk = false;
            break label269;
            break;
            i = -1;
          }
        }
        if ("ENABLE_START_UP".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).fdq;
          bool = paramIntent.getBooleanExtra("ENABLE_START_UP", ((g)localObject).fez);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.tracer.f)localObject).aAa();
            if (!MMApplicationContext.isMainProcess()) {
              break label438;
            }
            paramIntent = eLH;
            localObject = a.a.ahah.name();
            if (!bool) {
              break label440;
            }
          }
          for (i = j;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.tracer.f)localObject).aAb();
            break label394;
            break;
          }
        }
        if ("ENABLE_EVIL_METHOD".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).fdp;
          bool = paramIntent.getBooleanExtra("ENABLE_EVIL_METHOD", ((g)localObject).fez);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.tracer.a)localObject).aAa();
            if (!MMApplicationContext.isMainProcess()) {
              break label557;
            }
            paramIntent = eLH;
            localObject = a.a.ahaf.name();
            if (!bool) {
              break label559;
            }
          }
          for (i = k;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.tracer.a)localObject).aAb();
            break label513;
            break;
          }
        }
        if ("ENABLE_ANR".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.b)localObject).fds;
          bool = paramIntent.getBooleanExtra("ENABLE_ANR", ((g)localObject).fez);
          Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((e)localObject).aAa();
            if (!MMApplicationContext.isMainProcess()) {
              break label677;
            }
            paramIntent = eLH;
            localObject = a.a.ahag.name();
            if (!bool) {
              break label679;
            }
          }
          for (i = m;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((e)localObject).aAb();
            break label632;
            break;
          }
        }
        if ("ENABLE_METHOD_BEAT".equals(paramIntent.getAction()))
        {
          localObject = com.tencent.matrix.trace.b.azC();
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
          ((com.tencent.matrix.trace.b)localObject).fdo.fdK = bool;
          return;
        }
        if (!"MODIFY_EVIL_THRESHOLD".equals(paramIntent.getAction())) {
          break;
        }
        l = paramIntent.getLongExtra("MODIFY_EVIL_THRESHOLD", 700L);
        ((com.tencent.matrix.trace.b)localObject).fdp.ffr = l;
      } while (!MMApplicationContext.isMainProcess());
      eLH.putLong(a.a.ahaa.name(), l).apply();
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
    paramIntent = (com.tencent.matrix.a.c)c.avW().ai(com.tencent.matrix.a.c.class);
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
      paramIntent = eLH;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.f
 * JD-Core Version:    0.7.0.1
 */