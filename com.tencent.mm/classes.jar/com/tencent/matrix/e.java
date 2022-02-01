package com.tencent.matrix;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.c.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;

public final class e
{
  private static aw cqo = aw.aKT("MatrixDelegate");
  
  public static boolean Gx()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Settings.canDrawOverlays(ai.getContext());
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
  
  public static void j(Intent paramIntent)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i = 1;
    Object localObject = (com.tencent.matrix.trace.a)b.Gq().V(com.tencent.matrix.trace.a.class);
    if (localObject == null) {}
    label102:
    label635:
    do
    {
      long l;
      do
      {
        return;
        if ("ENABLE_FPS".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.a)localObject).cyD;
          bool = paramIntent.getBooleanExtra("ENABLE_FPS", ((f)localObject).czg);
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((c)localObject).HP();
            if (!ai.cin()) {
              break label146;
            }
            paramIntent = cqo;
            localObject = a.a.JIF.name();
            if (!bool) {
              break label148;
            }
          }
          for (i = 1;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((c)localObject).HQ();
            break label102;
            break;
          }
        }
        if ("ENABLE_FPS_FLOAT".equals(paramIntent.getAction()))
        {
          localObject = com.tencent.matrix.trace.view.a.aN(ai.getContext());
          ((com.tencent.matrix.trace.view.a)localObject).cY(ai.getProcessName());
          ((com.tencent.matrix.trace.view.a)localObject).cBW = new e.1();
          bool = paramIntent.getBooleanExtra("ENABLE_FPS_FLOAT", false);
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if ((bool) && (!Gx()))
          {
            ac.e("Matrix.UISettingHandler", "permission denied for window type");
            return;
          }
          ((com.tencent.matrix.trace.view.a)localObject).cBX = true;
          if (bool) {
            if (a.cqa.cqc)
            {
              ((com.tencent.matrix.trace.view.a)localObject).show();
              if (!ai.cin()) {
                break label322;
              }
              paramIntent = cqo;
              if (!bool) {
                break label324;
              }
            }
          }
          for (;;)
          {
            paramIntent.putInt("ENABLE_FPS_FLOAT", i).apply();
            return;
            ac.w("Matrix.UISettingHandler", "not in the foreground now!");
            break label272;
            ((com.tencent.matrix.trace.view.a)localObject).dismiss();
            ((com.tencent.matrix.trace.view.a)localObject).cBX = false;
            break label272;
            break;
            i = -1;
          }
        }
        if ("ENABLE_START_UP".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.a)localObject).cyC;
          bool = paramIntent.getBooleanExtra("ENABLE_START_UP", ((f)localObject).czg);
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.e)localObject).HP();
            if (!ai.cin()) {
              break label441;
            }
            paramIntent = cqo;
            localObject = a.a.JIP.name();
            if (!bool) {
              break label443;
            }
          }
          for (i = j;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.e)localObject).HQ();
            break label397;
            break;
          }
        }
        if ("ENABLE_EVIL_METHOD".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.a)localObject).cyB;
          bool = paramIntent.getBooleanExtra("ENABLE_EVIL_METHOD", ((f)localObject).czg);
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.b)localObject).HP();
            if (!ai.cin()) {
              break label560;
            }
            paramIntent = cqo;
            localObject = a.a.JIN.name();
            if (!bool) {
              break label562;
            }
          }
          for (i = k;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.b)localObject).HQ();
            break label516;
            break;
          }
        }
        if ("ENABLE_ANR".equals(paramIntent.getAction()))
        {
          localObject = ((com.tencent.matrix.trace.a)localObject).cyE;
          bool = paramIntent.getBooleanExtra("ENABLE_ANR", ((f)localObject).czg);
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          if (bool)
          {
            ((com.tencent.matrix.trace.f.a)localObject).HP();
            if (!ai.cin()) {
              break label680;
            }
            paramIntent = cqo;
            localObject = a.a.JIO.name();
            if (!bool) {
              break label682;
            }
          }
          for (i = m;; i = -1)
          {
            paramIntent.putInt((String)localObject, i).apply();
            return;
            ((com.tencent.matrix.trace.f.a)localObject).HQ();
            break label635;
            break;
          }
        }
        if ("ENABLE_METHOD_BEAT".equals(paramIntent.getAction()))
        {
          localObject = com.tencent.matrix.trace.a.HB();
          bool = paramIntent.getBooleanExtra("ENABLE_METHOD_BEAT", ((AppMethodBeat)localObject).isAlive());
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
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
          ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
          ((com.tencent.matrix.trace.a)localObject).cyA.cyM = bool;
          return;
        }
        if (!"MODIFY_EVIL_THRESHOLD".equals(paramIntent.getAction())) {
          break;
        }
        l = paramIntent.getLongExtra("MODIFY_EVIL_THRESHOLD", 700L);
        ((com.tencent.matrix.trace.a)localObject).cyB.cAd = l;
      } while (!ai.cin());
      cqo.putLong(a.a.JII.name(), l).apply();
      return;
      if ("ENABLE_BATTERY".equals(paramIntent.getAction()))
      {
        bool = paramIntent.getBooleanExtra("ENABLE_BATTERY", false);
        ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
        paramIntent = (com.tencent.matrix.a.c.a)b.Gq().V(com.tencent.matrix.a.c.a.class);
        if (bool)
        {
          paramIntent.start();
          if (!ai.cin()) {
            break label985;
          }
          paramIntent = cqo;
          if (!bool) {
            break label987;
          }
        }
        for (i = n;; i = -1)
        {
          paramIntent.putInt("ENABLE_BATTERY", i).apply();
          return;
          paramIntent.stop();
          break label948;
          break;
        }
      }
    } while (!"ENABLE_THREAD".equals(paramIntent.getAction()));
    label146:
    label148:
    label322:
    label324:
    label985:
    label987:
    boolean bool = paramIntent.getBooleanExtra("ENABLE_THREAD", false);
    label272:
    label441:
    label443:
    ac.i("Matrix.UISettingHandler", "action=%s isEnable=%s", new Object[] { paramIntent.getAction(), Boolean.valueOf(bool) });
    label397:
    label560:
    label562:
    label948:
    paramIntent = (com.tencent.matrix.f.a)b.Gq().V(com.tencent.matrix.f.a.class);
    label516:
    label680:
    label682:
    if (bool)
    {
      paramIntent.start();
      if (!ai.cin()) {
        break label1100;
      }
      paramIntent = cqo;
      if (!bool) {
        break label1102;
      }
    }
    label1063:
    label1100:
    label1102:
    for (i = i1;; i = -1)
    {
      paramIntent.putInt("ENABLE_THREAD", i).apply();
      return;
      paramIntent.stop();
      break label1063;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.e
 * JD-Core Version:    0.7.0.1
 */