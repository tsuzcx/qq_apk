package com.tencent.matrix.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public final class a
{
  private static boolean aLU = false;
  private static int cNX = 0;
  private static Timer cNY = new Timer();
  private static TimerTask cNZ;
  private static String cOa = "";
  private static volatile SparseBooleanArray cOb = new SparseBooleanArray(5);
  private static int cOc = -1;
  private static volatile boolean cOd = true;
  
  private static void F(int paramInt1, int paramInt2, int paramInt3)
  {
    if (cOb.get(paramInt1)) {
      return;
    }
    cOb.put(paramInt1, true);
    e.ygI.idkeyStat(1470L, paramInt2, 1L, true);
    String str2 = AppMethodBeat.getVisibleScene();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    ad.i("SyncBarrierWatchDogPlus", "sync barrier leak happens in scene : %s, type : %d", new Object[] { str1, Integer.valueOf(paramInt3) });
    e.ygI.f(20739, new Object[] { str1, Integer.valueOf(paramInt3) });
  }
  
  public static void Jw()
  {
    ad.i("SyncBarrierWatchDogPlus", "startDetect sync barrier, isStarted =%b , oncCheckFinished = %b", new Object[] { Boolean.valueOf(aLU), Boolean.valueOf(cOd) });
    if (!aLU)
    {
      aLU = true;
      cNZ = new TimerTask()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: invokestatic 20	com/tencent/matrix/h/a:access$000	()Z
          //   3: ifne +4 -> 7
          //   6: return
          //   7: getstatic 26	com/tencent/matrix/a:cAS	Lcom/tencent/matrix/a;
          //   10: getfield 30	com/tencent/matrix/a:cAU	Z
          //   13: istore_3
          //   14: iload_3
          //   15: ifne +8 -> 23
          //   18: invokestatic 33	com/tencent/matrix/h/a:Jy	()Z
          //   21: pop
          //   22: return
          //   23: ldc 35
          //   25: ldc 37
          //   27: invokestatic 43	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   30: invokestatic 49	android/os/Looper:getMainLooper	()Landroid/os/Looper;
          //   33: invokevirtual 53	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
          //   36: astore 4
          //   38: aload 4
          //   40: invokevirtual 59	java/lang/Object:getClass	()Ljava/lang/Class;
          //   43: ldc 61
          //   45: invokevirtual 67	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
          //   48: astore 5
          //   50: aload 5
          //   52: iconst_1
          //   53: invokevirtual 73	java/lang/reflect/Field:setAccessible	(Z)V
          //   56: aload 5
          //   58: aload 4
          //   60: invokevirtual 77	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   63: checkcast 79	android/os/Message
          //   66: astore 4
          //   68: aload 4
          //   70: ifnull +152 -> 222
          //   73: aload 4
          //   75: invokevirtual 83	android/os/Message:toString	()Ljava/lang/String;
          //   78: invokestatic 87	com/tencent/matrix/h/a:eg	(Ljava/lang/String;)Ljava/lang/String;
          //   81: pop
          //   82: ldc 35
          //   84: ldc 89
          //   86: iconst_1
          //   87: anewarray 55	java/lang/Object
          //   90: dup
          //   91: iconst_0
          //   92: invokestatic 92	com/tencent/matrix/h/a:access$100	()Ljava/lang/String;
          //   95: aastore
          //   96: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   99: aload 4
          //   101: invokevirtual 99	android/os/Message:getWhen	()J
          //   104: invokestatic 104	android/os/SystemClock:uptimeMillis	()J
          //   107: lsub
          //   108: ldc2_w 105
          //   111: lcmp
          //   112: ifge +110 -> 222
          //   115: aload 4
          //   117: invokevirtual 110	android/os/Message:getTarget	()Landroid/os/Handler;
          //   120: ifnonnull +107 -> 227
          //   123: aload 4
          //   125: getfield 114	android/os/Message:arg1	I
          //   128: istore_1
          //   129: invokestatic 118	com/tencent/matrix/h/a:access$200	()I
          //   132: istore_2
          //   133: iload_1
          //   134: iload_2
          //   135: if_icmpne +61 -> 196
          //   138: invokestatic 33	com/tencent/matrix/h/a:Jy	()Z
          //   141: pop
          //   142: return
          //   143: astore 5
          //   145: ldc 120
          //   147: invokestatic 87	com/tencent/matrix/h/a:eg	(Ljava/lang/String;)Ljava/lang/String;
          //   150: pop
          //   151: ldc 35
          //   153: new 122	java/lang/StringBuilder
          //   156: dup
          //   157: ldc 124
          //   159: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   162: aload 5
          //   164: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   170: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   173: invokestatic 138	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   176: goto -77 -> 99
          //   179: astore 4
          //   181: ldc 140
          //   183: aload 4
          //   185: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   188: invokestatic 138	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   191: invokestatic 33	com/tencent/matrix/h/a:Jy	()Z
          //   194: pop
          //   195: return
          //   196: invokestatic 92	com/tencent/matrix/h/a:access$100	()Ljava/lang/String;
          //   199: ifnull +23 -> 222
          //   202: invokestatic 92	com/tencent/matrix/h/a:access$100	()Ljava/lang/String;
          //   205: ldc 142
          //   207: invokevirtual 148	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
          //   210: ifeq +12 -> 222
          //   213: iload_1
          //   214: invokestatic 152	com/tencent/matrix/h/a:hd	(I)V
          //   217: iload_1
          //   218: invokestatic 156	com/tencent/matrix/h/a:he	(I)I
          //   221: pop
          //   222: invokestatic 33	com/tencent/matrix/h/a:Jy	()Z
          //   225: pop
          //   226: return
          //   227: ldc 35
          //   229: ldc 158
          //   231: invokestatic 43	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   234: goto -12 -> 222
          //   237: astore 4
          //   239: invokestatic 33	com/tencent/matrix/h/a:Jy	()Z
          //   242: pop
          //   243: aload 4
          //   245: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	246	0	this	1
          //   128	90	1	i	int
          //   132	4	2	j	int
          //   13	2	3	bool	boolean
          //   36	88	4	localObject1	Object
          //   179	5	4	localException1	Exception
          //   237	7	4	localObject2	Object
          //   48	9	5	localField	Field
          //   143	20	5	localException2	Exception
          // Exception table:
          //   from	to	target	type
          //   73	99	143	java/lang/Exception
          //   7	14	179	java/lang/Exception
          //   23	68	179	java/lang/Exception
          //   99	133	179	java/lang/Exception
          //   145	176	179	java/lang/Exception
          //   196	222	179	java/lang/Exception
          //   227	234	179	java/lang/Exception
          //   7	14	237	finally
          //   23	68	237	finally
          //   73	99	237	finally
          //   99	133	237	finally
          //   145	176	237	finally
          //   181	191	237	finally
          //   196	222	237	finally
          //   227	234	237	finally
        }
      };
      cNY.schedule(cNZ, 4500L, 4500L);
    }
  }
  
  private static int Jx()
  {
    try
    {
      Object localObject = Looper.getMainLooper().getQueue();
      Field localField = localObject.getClass().getDeclaredField("mMessages");
      localField.setAccessible(true);
      localObject = (Message)localField.get(localObject);
      if ((localObject != null) && (((Message)localObject).getTarget() == null))
      {
        int i = ((Message)localObject).arg1;
        return i;
      }
      return -1;
    }
    catch (Exception localException) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.h.a
 * JD-Core Version:    0.7.0.1
 */