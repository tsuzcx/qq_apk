package com.tencent.mm.plugin.gamelive.a;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive.c;
import com.tencent.mm.plugin.music.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class a
  implements HeadsetReceiver.b, e
{
  private final com.tencent.e.b Dli;
  private ObjectOutputStream Dlj;
  private MMHandler Dlk;
  private LocalServerSocket Dll;
  private final Map<Short, c> Dlm;
  private final b Dln;
  AudioManager Dlo;
  int Dlp;
  private boolean Dlq;
  a.a Dlr;
  private WeakReference<com.tencent.mm.plugin.appbrand.game.b> Dls;
  private String Dlt;
  Runnable Dlu;
  FileOutputStream bqA;
  com.tencent.mm.plugin.music.b.a cAJ;
  private long coZ;
  private long frB;
  MMHandler handler;
  private boolean lzZ;
  int tUM;
  private HeadsetReceiver zFi;
  
  public a()
  {
    AppMethodBeat.i(208620);
    this.Dli = com.tencent.e.h.ZvG.a("gamelive_audio_mix", 2, 2, new LinkedBlockingQueue());
    this.Dlj = null;
    this.Dlm = new HashMap();
    this.Dln = new b();
    this.coZ = 0L;
    this.bqA = null;
    this.Dlo = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    this.Dlp = this.Dlo.getStreamMaxVolume(3);
    this.lzZ = false;
    this.Dlq = false;
    this.Dlr = new a.a(this);
    this.frB = 0L;
    this.Dlt = "MicroMsgGameLiveAudio";
    this.zFi = new HeadsetReceiver();
    this.cAJ = new com.tencent.mm.plugin.music.b.a()
    {
      public final void a(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(208609);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(208609);
          return;
        }
        a.a(a.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208473);
            a.b(a.this).put(Short.valueOf(paramAnonymousa.FNF), new c(paramAnonymousa.FNF));
            Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onStart sessionId: " + paramAnonymousa.FNF + " audioType: " + paramAnonymousa.FNG + " audioId: " + paramAnonymousa.fmF + " streams: " + a.b(a.this).size());
            AppMethodBeat.o(208473);
          }
        });
        AppMethodBeat.o(208609);
      }
      
      public final void a(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa, final int paramAnonymousInt1, final int paramAnonymousInt2, final byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(208611);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(208611);
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
              AppMethodBeat.i(208147);
              c localc = (c)a.b(a.this).get(Short.valueOf(paramAnonymousa.FNF));
              if (localc == null)
              {
                Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onOutput failed, sessionId: " + paramAnonymousa.FNF + " audioType: " + paramAnonymousa.FNG + " audioId: " + paramAnonymousa.fmF + " format: " + this.ooM + " channel: " + paramAnonymousInt1 + " samplerate: " + paramAnonymousInt2 + " size: " + paramAnonymousArrayOfByte.length);
                AppMethodBeat.o(208147);
                return;
              }
              localc.a((short)paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte, l);
              AppMethodBeat.o(208147);
            }
          });
          AppMethodBeat.o(208611);
          return;
        }
        finally
        {
          AppMethodBeat.o(208611);
        }
      }
      
      public final void a(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa, final int paramAnonymousInt1, final int paramAnonymousInt2, final float[] paramAnonymousArrayOfFloat)
      {
        AppMethodBeat.i(208612);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(208612);
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
              AppMethodBeat.i(208164);
              c localc = (c)a.b(a.this).get(Short.valueOf(paramAnonymousa.FNF));
              if (localc == null)
              {
                Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onOutput failed, sessionId: " + paramAnonymousa.FNF + " audioType: " + paramAnonymousa.FNG + " audioId: " + paramAnonymousa.fmF + " format: " + this.ooM + " channel: " + paramAnonymousInt1 + " samplerate: " + paramAnonymousInt2 + " size: " + paramAnonymousArrayOfFloat.length);
                AppMethodBeat.o(208164);
                return;
              }
              short s = (short)paramAnonymousInt1;
              int i = paramAnonymousInt2;
              float[] arrayOfFloat = paramAnonymousArrayOfFloat;
              localc.c(s, i);
              ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfFloat.length * 4);
              localByteBuffer.asFloatBuffer().put(arrayOfFloat);
              localc.a(s, i, localByteBuffer.array(), System.currentTimeMillis());
              AppMethodBeat.o(208164);
            }
          });
          AppMethodBeat.o(208612);
          return;
        }
        finally
        {
          AppMethodBeat.o(208612);
        }
      }
      
      public final void b(final com.tencent.mm.plugin.music.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(208613);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(208613);
          return;
        }
        a.a(a.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208389);
            Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onStop sessionId: " + paramAnonymousa.FNF + " audioType: " + paramAnonymousa.FNG + " audioId: " + paramAnonymousa.fmF + " streams: " + a.b(a.this).size());
            c localc = (c)a.b(a.this).remove(Short.valueOf(paramAnonymousa.FNF));
            if (localc == null)
            {
              Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] AbstractAudioOutputListener onStop, not found sessionId: " + paramAnonymousa.FNF + " audioType: " + paramAnonymousa.FNG + " audioId: " + paramAnonymousa.fmF + " streams: " + a.b(a.this).size());
              AppMethodBeat.o(208389);
              return;
            }
            localc.onStop();
            AppMethodBeat.o(208389);
          }
        });
        AppMethodBeat.o(208613);
      }
    };
    this.Dlu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208355);
        long l1 = System.currentTimeMillis();
        Object localObject1;
        if (!a.b(a.this).isEmpty())
        {
          localObject1 = a.b(a.this).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            c localc = (c)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if (localc.Deu)
            {
              byte[] arrayOfByte = localc.getData();
              a.h(a.this).a(localc.DlL, localc.DlN, localc.DlM, arrayOfByte);
            }
          }
          localObject1 = a.h(a.this).getData();
          if (localObject1 == null)
          {
            Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "[hilive] getData fail");
            AppMethodBeat.o(208355);
            return;
          }
          a.a((byte[])localObject1, a.this.tUM / a.this.Dlp);
          if (!((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getEnableAudioDebug()) {}
        }
        try
        {
          a.this.bqA.write((byte[])localObject1);
          label197:
          localObject1 = new g(localObject1.length, (byte[])((byte[])localObject1).clone(), System.currentTimeMillis());
          a.a(a.this, (g)localObject1);
          if (a.i(a.this) == 0L) {
            a.a(a.this, SystemClock.uptimeMillis());
          }
          a.a(a.this, a.i(a.this) + b.DlF);
          long l2 = SystemClock.uptimeMillis();
          if (l2 > a.i(a.this))
          {
            Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "fix next update time, now:%d updateTime:%d", new Object[] { Long.valueOf(l2), Long.valueOf(a.i(a.this)) });
            a.a(a.this, l2 + b.DlF);
          }
          try
          {
            if ((a.a(a.this) != null) && (!a.d(a.this))) {
              a.a(a.this).postAtTime(a.this.Dlu, a.i(a.this));
            }
            if (System.currentTimeMillis() - a.j(a.this) > 10000L)
            {
              a.b(a.this, System.currentTimeMillis());
              Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "send audio data, cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
            }
            AppMethodBeat.o(208355);
            return;
          }
          finally
          {
            AppMethodBeat.o(208355);
          }
        }
        catch (IOException localIOException)
        {
          break label197;
        }
      }
    };
    AppMethodBeat.o(208620);
  }
  
  private static boolean eAQ()
  {
    AppMethodBeat.i(208625);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vMN, 0) == 1)
    {
      AppMethodBeat.o(208625);
      return true;
    }
    AppMethodBeat.o(208625);
    return false;
  }
  
  public final void U(final t paramt)
  {
    AppMethodBeat.i(208623);
    this.Dlt = com.tencent.mm.b.g.getMessageDigest(String.format(Locale.US, "%s%d", new Object[] { "MicroMsgGameLiveAudio", Integer.valueOf(paramt.bDy().uin) }).getBytes());
    paramt = (com.tencent.mm.plugin.appbrand.game.b)paramt.bDA().R(com.tencent.mm.plugin.appbrand.game.b.class);
    Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "start appbrand audio %s %s", new Object[] { paramt, this.Dlt });
    this.Dls = new WeakReference(paramt);
    this.lzZ = false;
    this.Dli.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208701);
        Looper.prepare();
        a.a(a.this, new MMHandler(Looper.myLooper()));
        Looper.loop();
        Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "handler thread quited");
        AppMethodBeat.o(208701);
      }
    });
    this.Dli.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208503);
        Looper.prepare();
        a.b(a.this, new MMHandler(Looper.myLooper()));
        try
        {
          a.a(a.this, new LocalServerSocket(a.e(a.this)));
          LocalSocket localLocalSocket = a.f(a.this).accept();
          Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "vira: got client");
          if (a.a(a.this) == null)
          {
            Log.w("MicroMsg.GameLiveAppbrandAudioMgrService", "handle is null!");
            AppMethodBeat.o(208503);
            return;
          }
          com.tencent.mm.plugin.music.b.i.fcS().c(a.this.cAJ);
          paramt.b(a.this.cAJ);
          a locala = a.this;
          locala.handler.post(locala.Dlu);
          a.this.ad(false, false);
          a.a(a.this, new ObjectOutputStream(localLocalSocket.getOutputStream()));
          Looper.loop();
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "io exception", new Object[] { localIOException });
          }
        }
        Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "ipcHandler thread quited");
        AppMethodBeat.o(208503);
      }
    });
    if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getEnableAudioDebug()) {}
    try
    {
      this.bqA = new FileOutputStream(new File("/sdcard/pcm/mix.pcm"));
      label167:
      this.Dln.eAR();
      this.tUM = this.Dlo.getStreamVolume(3);
      MMApplicationContext.getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.Dlr);
      if (!eAQ()) {
        this.zFi.a(MMApplicationContext.getContext(), this);
      }
      AppMethodBeat.o(208623);
      return;
    }
    catch (FileNotFoundException paramt)
    {
      break label167;
    }
  }
  
  /* Error */
  public final void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 365
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 359	com/tencent/mm/plugin/gamelive/a/a:eAQ	()Z
    //   11: ifeq +24 -> 35
    //   14: ldc_w 288
    //   17: ldc_w 367
    //   20: invokestatic 370	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 144	com/tencent/mm/plugin/gamelive/a/a:Dlq	Z
    //   28: ldc_w 365
    //   31: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: return
    //   35: iload_1
    //   36: ifeq +93 -> 129
    //   39: ldc_w 372
    //   42: invokestatic 211	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   45: checkcast 372	com/tencent/mm/plugin/gamelive/c
    //   48: invokeinterface 376 1 0
    //   53: invokevirtual 381	java/lang/Boolean:booleanValue	()Z
    //   56: ifne +80 -> 136
    //   59: iconst_1
    //   60: istore_1
    //   61: ldc_w 288
    //   64: ldc_w 383
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: iload_2
    //   74: invokestatic 386	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: iload_1
    //   81: invokestatic 386	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: getfield 144	com/tencent/mm/plugin/gamelive/a/a:Dlq	Z
    //   94: istore 4
    //   96: iload_2
    //   97: ifne +44 -> 141
    //   100: iload_1
    //   101: ifne +40 -> 141
    //   104: iload_3
    //   105: istore_1
    //   106: aload_0
    //   107: iload_1
    //   108: putfield 144	com/tencent/mm/plugin/gamelive/a/a:Dlq	Z
    //   111: iload 4
    //   113: aload_0
    //   114: getfield 144	com/tencent/mm/plugin/gamelive/a/a:Dlq	Z
    //   117: if_icmpne +29 -> 146
    //   120: aload_0
    //   121: monitorexit
    //   122: ldc_w 365
    //   125: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: invokestatic 389	com/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver:enr	()Z
    //   132: istore_2
    //   133: goto -94 -> 39
    //   136: iconst_0
    //   137: istore_1
    //   138: goto -77 -> 61
    //   141: iconst_0
    //   142: istore_1
    //   143: goto -37 -> 106
    //   146: aload_0
    //   147: getfield 144	com/tencent/mm/plugin/gamelive/a/a:Dlq	Z
    //   150: ifeq +30 -> 180
    //   153: aload_0
    //   154: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   157: ifnull +14 -> 171
    //   160: aload_0
    //   161: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   164: aload_0
    //   165: getfield 166	com/tencent/mm/plugin/gamelive/a/a:Dlu	Ljava/lang/Runnable;
    //   168: invokevirtual 392	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   171: aload_0
    //   172: monitorexit
    //   173: ldc_w 365
    //   176: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: aload_0
    //   181: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   184: ifnull -13 -> 171
    //   187: aload_0
    //   188: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   191: aload_0
    //   192: getfield 166	com/tencent/mm/plugin/gamelive/a/a:Dlu	Ljava/lang/Runnable;
    //   195: invokevirtual 191	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   198: pop
    //   199: goto -28 -> 171
    //   202: astore 5
    //   204: aload_0
    //   205: monitorexit
    //   206: ldc_w 365
    //   209: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload 5
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	a
    //   0	215	1	paramBoolean1	boolean
    //   0	215	2	paramBoolean2	boolean
    //   1	104	3	bool1	boolean
    //   94	24	4	bool2	boolean
    //   202	11	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   90	96	202	finally
    //   106	122	202	finally
    //   146	171	202	finally
    //   171	173	202	finally
    //   180	199	202	finally
  }
  
  public final void pR(boolean paramBoolean)
  {
    AppMethodBeat.i(208631);
    Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "onHeadsetStateChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad(true, paramBoolean);
    AppMethodBeat.o(208631);
  }
  
  /* Error */
  public final void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 401
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 288
    //   11: ldc_w 403
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 142	com/tencent/mm/plugin/gamelive/a/a:lzZ	Z
    //   24: invokestatic 386	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: getfield 142	com/tencent/mm/plugin/gamelive/a/a:lzZ	Z
    //   35: ifeq +12 -> 47
    //   38: ldc_w 401
    //   41: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 142	com/tencent/mm/plugin/gamelive/a/a:lzZ	Z
    //   52: aload_0
    //   53: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   56: ifnull +14 -> 70
    //   59: aload_0
    //   60: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   63: aload_0
    //   64: getfield 166	com/tencent/mm/plugin/gamelive/a/a:Dlu	Ljava/lang/Runnable;
    //   67: invokevirtual 392	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   70: ldc_w 401
    //   73: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -32 -> 44
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
    //   2	44	79	finally
    //   47	70	79	finally
    //   70	76	79	finally
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 405
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc_w 288
    //   11: ldc_w 407
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 142	com/tencent/mm/plugin/gamelive/a/a:lzZ	Z
    //   24: invokestatic 386	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: getfield 142	com/tencent/mm/plugin/gamelive/a/a:lzZ	Z
    //   35: ifne +12 -> 47
    //   38: ldc_w 405
    //   41: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 142	com/tencent/mm/plugin/gamelive/a/a:lzZ	Z
    //   52: aload_0
    //   53: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   56: ifnull +15 -> 71
    //   59: aload_0
    //   60: getfield 177	com/tencent/mm/plugin/gamelive/a/a:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   63: aload_0
    //   64: getfield 166	com/tencent/mm/plugin/gamelive/a/a:Dlu	Ljava/lang/Runnable;
    //   67: invokevirtual 191	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   70: pop
    //   71: ldc_w 405
    //   74: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -33 -> 44
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	a
    //   80	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	80	finally
    //   47	71	80	finally
    //   71	77	80	finally
  }
  
  public final void stop()
  {
    AppMethodBeat.i(208624);
    Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "stop appbrand audio");
    Object localObject1 = com.tencent.mm.plugin.music.b.i.fcS();
    Object localObject2 = ((com.tencent.mm.plugin.music.b.i)localObject1).FOj;
    ((com.tencent.mm.audio.mix.f.c)localObject2).dv(false);
    ((com.tencent.mm.audio.mix.f.c)localObject2).dx(false);
    ((com.tencent.mm.audio.mix.f.c)localObject2).dw(false);
    ((com.tencent.mm.plugin.music.b.i)localObject1).cAJ = null;
    localObject1 = ((com.tencent.mm.plugin.music.b.i)localObject1).FNM.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (l)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((l)localObject2).cAJ = null;
      }
    }
    if ((this.Dls != null) && (this.Dls.get() != null)) {
      ((com.tencent.mm.plugin.appbrand.game.b)this.Dls.get()).b(null);
    }
    try
    {
      if (this.bqA != null) {
        this.bqA.close();
      }
      label135:
      localObject1 = this.Dlm.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((c)((Iterator)localObject1).next()).onStop();
      }
      this.Dlm.clear();
      if (this.handler != null)
      {
        this.handler.getLooper().quit();
        this.handler.quit();
      }
      if (this.Dlk != null)
      {
        this.Dlk.getLooper().quit();
        this.Dlk.quit();
      }
      if (this.Dll != null) {}
      try
      {
        this.Dlj.write(1);
        this.Dlj.flush();
        this.Dlj.close();
        this.Dlj = null;
        this.Dll.close();
        this.Dll = null;
        this.handler = null;
        this.Dlk = null;
        MMApplicationContext.getContext().getContentResolver().unregisterContentObserver(this.Dlr);
        if (!eAQ()) {
          this.zFi.gd(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(208624);
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "close localServerSocket exception", new Object[] { localIOException1 });
        }
      }
    }
    catch (IOException localIOException2)
    {
      break label135;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.a
 * JD-Core Version:    0.7.0.1
 */