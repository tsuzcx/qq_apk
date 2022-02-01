package com.tencent.mm.plugin.gamelive.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class a
  implements HeadsetReceiver.b, e
{
  private boolean CGI;
  public HeadsetReceiver EKB;
  public a JeA;
  public WeakReference<com.tencent.mm.plugin.appbrand.game.b> JeB;
  public String JeC;
  Runnable JeD;
  public final com.tencent.threadpool.b Jes;
  public ObjectOutputStream Jet;
  public MMHandler Jeu;
  public LocalServerSocket Jev;
  public final Map<Short, c> Jew;
  public final b Jex;
  public AudioManager Jey;
  int Jez;
  public FileOutputStream dke;
  private long egK;
  com.tencent.mm.plugin.music.b.a ete;
  public MMHandler handler;
  private long hvL;
  public boolean orA;
  public int wYi;
  
  public a()
  {
    AppMethodBeat.i(277506);
    this.Jes = com.tencent.threadpool.h.ahAA.a("gamelive_audio_mix", 2, 2, new LinkedBlockingQueue());
    this.Jet = null;
    this.Jew = new HashMap();
    this.Jex = new b();
    this.egK = 0L;
    this.dke = null;
    this.Jey = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    this.Jez = this.Jey.getStreamMaxVolume(3);
    this.orA = false;
    this.CGI = false;
    this.JeA = new a();
    this.hvL = 0L;
    this.JeC = "MicroMsgGameLiveAudio";
    this.EKB = new HeadsetReceiver();
    this.ete = new com.tencent.mm.plugin.music.b.a()
    {
      public final void a(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(277519);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(277519);
          return;
        }
        a.a(a.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277490);
            a.b(a.this).put(Short.valueOf(paramAnonymousa.LIB), new c(paramAnonymousa.LIB));
            Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onStart sessionId: " + paramAnonymousa.LIB + " audioType: " + paramAnonymousa.LIC + " audioId: " + paramAnonymousa.hqQ + " streams: " + a.b(a.this).size());
            AppMethodBeat.o(277490);
          }
        });
        AppMethodBeat.o(277519);
      }
      
      public final void a(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa, final int paramAnonymousInt1, final int paramAnonymousInt2, final byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(277528);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(277528);
          return;
        }
        try
        {
          if ((a.c(a.this)) || (a.d(a.this))) {
            return;
          }
          paramAnonymousArrayOfByte = (byte[])paramAnonymousArrayOfByte.clone();
          final long l = System.currentTimeMillis();
          a.a(a.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277483);
              c localc = (c)a.b(a.this).get(Short.valueOf(paramAnonymousa.LIB));
              if (localc == null)
              {
                Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onOutput failed, sessionId: " + paramAnonymousa.LIB + " audioType: " + paramAnonymousa.LIC + " audioId: " + paramAnonymousa.hqQ + " format: " + this.eWZ + " channel: " + paramAnonymousInt1 + " samplerate: " + paramAnonymousInt2 + " size: " + paramAnonymousArrayOfByte.length);
                AppMethodBeat.o(277483);
                return;
              }
              localc.a((short)paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte, l);
              AppMethodBeat.o(277483);
            }
          });
          AppMethodBeat.o(277528);
          return;
        }
        finally
        {
          AppMethodBeat.o(277528);
        }
      }
      
      public final void a(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa, final int paramAnonymousInt1, final int paramAnonymousInt2, final float[] paramAnonymousArrayOfFloat)
      {
        AppMethodBeat.i(277534);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(277534);
          return;
        }
        try
        {
          if ((a.c(a.this)) || (a.d(a.this))) {
            return;
          }
          paramAnonymousArrayOfFloat = (float[])paramAnonymousArrayOfFloat.clone();
          a.a(a.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277502);
              c localc = (c)a.b(a.this).get(Short.valueOf(paramAnonymousa.LIB));
              if (localc == null)
              {
                Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onOutput failed, sessionId: " + paramAnonymousa.LIB + " audioType: " + paramAnonymousa.LIC + " audioId: " + paramAnonymousa.hqQ + " format: " + this.eWZ + " channel: " + paramAnonymousInt1 + " samplerate: " + paramAnonymousInt2 + " size: " + paramAnonymousArrayOfFloat.length);
                AppMethodBeat.o(277502);
                return;
              }
              short s = (short)paramAnonymousInt1;
              int i = paramAnonymousInt2;
              float[] arrayOfFloat = paramAnonymousArrayOfFloat;
              localc.d(s, i);
              ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfFloat.length * 4);
              localByteBuffer.asFloatBuffer().put(arrayOfFloat);
              localc.a(s, i, localByteBuffer.array(), System.currentTimeMillis());
              AppMethodBeat.o(277502);
            }
          });
          AppMethodBeat.o(277534);
          return;
        }
        finally
        {
          AppMethodBeat.o(277534);
        }
      }
      
      public final void b(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(277541);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(277541);
          return;
        }
        a.a(a.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277499);
            Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onStop sessionId: " + paramAnonymousa.LIB + " audioType: " + paramAnonymousa.LIC + " audioId: " + paramAnonymousa.hqQ + " streams: " + a.b(a.this).size());
            c localc = (c)a.b(a.this).remove(Short.valueOf(paramAnonymousa.LIB));
            if (localc == null)
            {
              Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onStop, not found sessionId: " + paramAnonymousa.LIB + " audioType: " + paramAnonymousa.LIC + " audioId: " + paramAnonymousa.hqQ + " streams: " + a.b(a.this).size());
              AppMethodBeat.o(277499);
              return;
            }
            localc.onStop();
            AppMethodBeat.o(277499);
          }
        });
        AppMethodBeat.o(277541);
      }
    };
    this.JeD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277535);
        long l1 = System.currentTimeMillis();
        Object localObject1;
        if (!a.b(a.this).isEmpty())
        {
          localObject1 = a.b(a.this).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            c localc = (c)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if (localc.IYL)
            {
              byte[] arrayOfByte = localc.getData();
              a.h(a.this).a(localc.JeU, localc.JeW, localc.JeV, arrayOfByte);
            }
          }
          localObject1 = a.h(a.this).getData();
          if (localObject1 == null)
          {
            Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] getData fail");
            AppMethodBeat.o(277535);
            return;
          }
          a.a((byte[])localObject1, a.this.wYi / a.this.Jez);
          if (!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getEnableAudioDebug()) {}
        }
        try
        {
          a.this.dke.write((byte[])localObject1);
          label197:
          localObject1 = new g((byte[])((byte[])localObject1).clone(), System.currentTimeMillis());
          a.a(a.this, (g)localObject1);
          if (a.i(a.this) == 0L) {
            a.a(a.this, SystemClock.uptimeMillis());
          }
          a.b(a.this, b.JeO);
          long l2 = SystemClock.uptimeMillis();
          if (l2 > a.i(a.this))
          {
            Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "fix next update time, now:%d updateTime:%d", new Object[] { Long.valueOf(l2), Long.valueOf(a.i(a.this)) });
            a.a(a.this, l2 + b.JeO);
          }
          try
          {
            if ((a.a(a.this) != null) && (!a.d(a.this))) {
              a.a(a.this).postAtTime(a.this.JeD, a.i(a.this));
            }
            if (System.currentTimeMillis() - a.j(a.this) > 10000L)
            {
              a.c(a.this, System.currentTimeMillis());
              Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "send audio data, cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
            }
            AppMethodBeat.o(277535);
            return;
          }
          finally
          {
            AppMethodBeat.o(277535);
          }
        }
        catch (IOException localIOException)
        {
          break label197;
        }
      }
    };
    AppMethodBeat.o(277506);
  }
  
  public static boolean fIS()
  {
    AppMethodBeat.i(277513);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zdt, 0) == 1)
    {
      AppMethodBeat.o(277513);
      return true;
    }
    AppMethodBeat.o(277513);
    return false;
  }
  
  /* Error */
  public final void av(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 231
    //   4: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 233	com/tencent/mm/plugin/gamelive/a/a:fIS	()Z
    //   10: ifeq +21 -> 31
    //   13: ldc 235
    //   15: ldc 237
    //   17: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 144	com/tencent/mm/plugin/gamelive/a/a:CGI	Z
    //   25: ldc 231
    //   27: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: iload_1
    //   32: ifeq +89 -> 121
    //   35: ldc 244
    //   37: invokestatic 213	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   40: checkcast 244	com/tencent/mm/plugin/gamelive/b
    //   43: invokeinterface 248 1 0
    //   48: invokevirtual 253	java/lang/Boolean:booleanValue	()Z
    //   51: ifne +77 -> 128
    //   54: iconst_1
    //   55: istore_1
    //   56: ldc 235
    //   58: ldc 255
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: iload_2
    //   67: invokestatic 259	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: iload_1
    //   74: invokestatic 259	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: aastore
    //   78: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_0
    //   82: monitorenter
    //   83: aload_0
    //   84: getfield 144	com/tencent/mm/plugin/gamelive/a/a:CGI	Z
    //   87: istore 4
    //   89: iload_2
    //   90: ifne +43 -> 133
    //   93: iload_1
    //   94: ifne +39 -> 133
    //   97: iload_3
    //   98: istore_1
    //   99: aload_0
    //   100: iload_1
    //   101: putfield 144	com/tencent/mm/plugin/gamelive/a/a:CGI	Z
    //   104: iload 4
    //   106: aload_0
    //   107: getfield 144	com/tencent/mm/plugin/gamelive/a/a:CGI	Z
    //   110: if_icmpne +28 -> 138
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc 231
    //   117: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: return
    //   121: invokestatic 265	com/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver:fsb	()Z
    //   124: istore_2
    //   125: goto -90 -> 35
    //   128: iconst_0
    //   129: istore_1
    //   130: goto -74 -> 56
    //   133: iconst_0
    //   134: istore_1
    //   135: goto -36 -> 99
    //   138: aload_0
    //   139: getfield 144	com/tencent/mm/plugin/gamelive/a/a:CGI	Z
    //   142: ifeq +29 -> 171
    //   145: aload_0
    //   146: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   149: ifnull +14 -> 163
    //   152: aload_0
    //   153: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   156: aload_0
    //   157: getfield 166	com/tencent/mm/plugin/gamelive/a/a:JeD	Ljava/lang/Runnable;
    //   160: invokevirtual 269	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   163: aload_0
    //   164: monitorexit
    //   165: ldc 231
    //   167: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   175: ifnull -12 -> 163
    //   178: aload_0
    //   179: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   182: aload_0
    //   183: getfield 166	com/tencent/mm/plugin/gamelive/a/a:JeD	Ljava/lang/Runnable;
    //   186: invokevirtual 191	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   189: pop
    //   190: goto -27 -> 163
    //   193: astore 5
    //   195: aload_0
    //   196: monitorexit
    //   197: ldc 231
    //   199: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload 5
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	a
    //   0	205	1	paramBoolean1	boolean
    //   0	205	2	paramBoolean2	boolean
    //   1	97	3	bool1	boolean
    //   87	24	4	bool2	boolean
    //   193	10	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   83	89	193	finally
    //   99	115	193	finally
    //   138	163	193	finally
    //   163	165	193	finally
    //   171	190	193	finally
  }
  
  /* Error */
  public final void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 271
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 235
    //   10: ldc_w 273
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 142	com/tencent/mm/plugin/gamelive/a/a:orA	Z
    //   23: invokestatic 259	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 142	com/tencent/mm/plugin/gamelive/a/a:orA	Z
    //   34: ifeq +12 -> 46
    //   37: ldc_w 271
    //   40: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 142	com/tencent/mm/plugin/gamelive/a/a:orA	Z
    //   51: aload_0
    //   52: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   55: ifnull +14 -> 69
    //   58: aload_0
    //   59: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   62: aload_0
    //   63: getfield 166	com/tencent/mm/plugin/gamelive/a/a:JeD	Ljava/lang/Runnable;
    //   66: invokevirtual 269	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   69: ldc_w 271
    //   72: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -32 -> 43
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   78	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	78	finally
    //   46	69	78	finally
    //   69	75	78	finally
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 275
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 235
    //   10: ldc_w 277
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 142	com/tencent/mm/plugin/gamelive/a/a:orA	Z
    //   23: invokestatic 259	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 142	com/tencent/mm/plugin/gamelive/a/a:orA	Z
    //   34: ifne +12 -> 46
    //   37: ldc_w 275
    //   40: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 142	com/tencent/mm/plugin/gamelive/a/a:orA	Z
    //   51: aload_0
    //   52: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   55: ifnull +15 -> 70
    //   58: aload_0
    //   59: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   62: aload_0
    //   63: getfield 166	com/tencent/mm/plugin/gamelive/a/a:JeD	Ljava/lang/Runnable;
    //   66: invokevirtual 191	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   69: pop
    //   70: ldc_w 275
    //   73: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -33 -> 43
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	a
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	79	finally
    //   46	70	79	finally
    //   70	76	79	finally
  }
  
  public final void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(277639);
    Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "onHeadsetStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    av(true, paramBoolean);
    AppMethodBeat.o(277639);
  }
  
  final class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return false;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(277522);
      int i = a.this.Jey.getStreamVolume(3);
      Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "user vol changed old:%d new:%d max:%d", new Object[] { Integer.valueOf(a.this.wYi), Integer.valueOf(i), Integer.valueOf(a.this.Jez) });
      a.this.wYi = i;
      AppMethodBeat.o(277522);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.a
 * JD-Core Version:    0.7.0.1
 */