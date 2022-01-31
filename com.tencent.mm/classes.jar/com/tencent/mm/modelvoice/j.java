package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqpinyin.voicerecoapi.TRSpeexNative;
import com.tencent.qqpinyin.voicerecoapi.a;
import java.io.InputStream;

public final class j
  implements d
{
  AudioTrack awx;
  com.tencent.mm.compatible.util.b bBs;
  private int bUR = 1;
  d.b eKA = null;
  private int eKB = 2;
  private int eKC = 20;
  private Runnable eKD;
  a eKE = null;
  private int eKF;
  int eKG = 0;
  boolean eKH = false;
  byte[] eKI = new byte[a.MAX_FRAME_SIZE];
  int eKJ = 0;
  InputStream eKK = null;
  int eKL = 314;
  String eKk = "";
  String eKl = "";
  boolean eKt = true;
  MediaPlayer.OnCompletionListener eKv = new MediaPlayer.OnCompletionListener()
  {
    public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      if ((j.this.bBs != null) && (j.this.eKt)) {
        j.this.bBs.zE();
      }
      try
      {
        j.this.status = 0;
        j.this.Te();
        try
        {
          j.a(j.this);
          return;
        }
        catch (InterruptedException paramAnonymousMediaPlayer)
        {
          y.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bk.j(paramAnonymousMediaPlayer) });
          return;
        }
        return;
      }
      catch (Exception paramAnonymousMediaPlayer)
      {
        y.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bk.j(paramAnonymousMediaPlayer) });
        y.e("MicroMsg.SpeexPlayer", "setCompletion File[" + j.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
      }
    }
  };
  MediaPlayer.OnErrorListener eKw = new j.2(this);
  d.a eKz = null;
  String fileName = "";
  private int nSamplerate = 16000;
  int status = 0;
  
  public j()
  {
    a locala = this.eKE;
    if (locala.wKk != 0) {
      i = -103;
    }
    for (;;)
    {
      if (i != 0) {
        y.e("speex", "res: " + i);
      }
      return;
      int j = locala.wKl.nativeTRSpeexDecodeInit();
      if ((j == -1) || (j == -100) || (j == -101) || (j == -102))
      {
        i = j;
      }
      else
      {
        locala.wKk = j;
        locala.wKi = new byte[a.MAX_FRAME_SIZE * 15];
      }
    }
  }
  
  public j(Context paramContext)
  {
    this();
    this.bBs = new com.tencent.mm.compatible.util.b(paramContext);
  }
  
  private boolean Q(String paramString, boolean paramBoolean)
  {
    if (this.status != 0)
    {
      y.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
      return false;
    }
    y.i("MicroMsg.SpeexPlayer", "startPlay");
    this.status = 1;
    this.fileName = paramString;
    try
    {
      ck(paramBoolean);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        ck(true);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
        y.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bk.j(paramString) });
        this.status = -1;
      }
    }
    return false;
  }
  
  private void ck(boolean paramBoolean)
  {
    int j = 3;
    if (!com.tencent.mm.vfs.e.bK(this.fileName)) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    label281:
    for (;;)
    {
      try
      {
        if (!q.dye.duN) {
          break label281;
        }
        q.dye.dump();
        if (q.dye.duU != 1) {
          break label281;
        }
        i = j;
        this.eKF = AudioTrack.getMinBufferSize(this.nSamplerate, this.eKB, 2);
        Te();
        this.awx = new com.tencent.mm.compatible.b.d(i, this.nSamplerate, this.eKB, this.eKF * 8);
        this.eKL = (this.nSamplerate / 1000 * this.bUR * this.eKC * 2);
        if ((this.bBs != null) && (this.eKt)) {
          this.bBs.requestFocus();
        }
        AudioTrack localAudioTrack = this.awx;
        if (localAudioTrack == null) {
          break;
        }
        i = 0;
      }
      catch (Exception localException1)
      {
        try
        {
          this.awx.play();
          this.eKD = new j.3(this);
          com.tencent.mm.sdk.f.e.post(this.eKD, "SpeexPlayer_play");
          return;
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[] { localException2.getMessage() });
          return;
        }
        localException1 = localException1;
        if ((this.bBs != null) && (this.eKt)) {
          this.bBs.zE();
        }
        Te();
        y.e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + localException1.getMessage());
        y.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bk.j(localException1) });
        return;
      }
    }
  }
  
  public final boolean P(String paramString, boolean paramBoolean)
  {
    return Q(paramString, paramBoolean);
  }
  
  public final void SX()
  {
    this.eKt = false;
  }
  
  final void Te()
  {
    if (this.awx != null)
    {
      this.awx.stop();
      this.awx.release();
      this.awx = null;
    }
  }
  
  public final void a(d.a parama)
  {
    this.eKz = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.eKA = paramb;
  }
  
  /* Error */
  public final boolean aU(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mm/modelvoice/j:status	I
    //   4: iconst_1
    //   5: if_icmpeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: iconst_2
    //   12: putfield 59	com/tencent/mm/modelvoice/j:status	I
    //   15: aload_0
    //   16: getfield 77	com/tencent/mm/modelvoice/j:eKl	Ljava/lang/String;
    //   19: astore 4
    //   21: aload 4
    //   23: monitorenter
    //   24: ldc 157
    //   26: ldc_w 278
    //   29: invokestatic 281	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   35: lstore_2
    //   36: aload_0
    //   37: getfield 77	com/tencent/mm/modelvoice/j:eKl	Ljava/lang/String;
    //   40: invokevirtual 290	java/lang/Object:wait	()V
    //   43: ldc 157
    //   45: new 110	java/lang/StringBuilder
    //   48: dup
    //   49: ldc_w 292
    //   52: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   58: lload_2
    //   59: lsub
    //   60: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 281	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   73: ifnull +22 -> 95
    //   76: iload_1
    //   77: ifeq +18 -> 95
    //   80: aload_0
    //   81: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   84: ifeq +11 -> 95
    //   87: aload_0
    //   88: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   91: invokevirtual 255	com/tencent/mm/compatible/util/b:zE	()Z
    //   94: pop
    //   95: aload 4
    //   97: monitorexit
    //   98: iconst_1
    //   99: ireturn
    //   100: astore 5
    //   102: ldc 157
    //   104: ldc 177
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 5
    //   114: invokestatic 183	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_0
    //   122: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   125: ifnull +22 -> 147
    //   128: iload_1
    //   129: ifeq +18 -> 147
    //   132: aload_0
    //   133: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   136: ifeq +11 -> 147
    //   139: aload_0
    //   140: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   143: invokevirtual 255	com/tencent/mm/compatible/util/b:zE	()Z
    //   146: pop
    //   147: aload 4
    //   149: monitorexit
    //   150: iconst_0
    //   151: ireturn
    //   152: astore 5
    //   154: aload 4
    //   156: monitorexit
    //   157: aload 5
    //   159: athrow
    //   160: astore 5
    //   162: aload_0
    //   163: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   166: ifnull +22 -> 188
    //   169: iload_1
    //   170: ifeq +18 -> 188
    //   173: aload_0
    //   174: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   177: ifeq +11 -> 188
    //   180: aload_0
    //   181: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   184: invokevirtual 255	com/tencent/mm/compatible/util/b:zE	()Z
    //   187: pop
    //   188: aload 5
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	j
    //   0	191	1	paramBoolean	boolean
    //   35	24	2	l	long
    //   19	136	4	str	String
    //   100	13	5	localException	Exception
    //   152	6	5	localObject1	Object
    //   160	29	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	69	100	java/lang/Exception
    //   69	76	152	finally
    //   80	95	152	finally
    //   95	98	152	finally
    //   121	128	152	finally
    //   132	147	152	finally
    //   147	150	152	finally
    //   154	157	152	finally
    //   162	169	152	finally
    //   173	188	152	finally
    //   188	191	152	finally
    //   24	69	160	finally
    //   102	121	160	finally
  }
  
  /* Error */
  public final void aV(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 73	com/tencent/mm/modelvoice/j:eKH	Z
    //   5: aload_0
    //   6: getfield 65	com/tencent/mm/modelvoice/j:bUR	I
    //   9: iconst_2
    //   10: if_icmpne +127 -> 137
    //   13: aload_0
    //   14: iconst_3
    //   15: putfield 61	com/tencent/mm/modelvoice/j:eKB	I
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 63	com/tencent/mm/modelvoice/j:nSamplerate	I
    //   23: aload_0
    //   24: getfield 61	com/tencent/mm/modelvoice/j:eKB	I
    //   27: iconst_2
    //   28: invokestatic 224	android/media/AudioTrack:getMinBufferSize	(III)I
    //   31: putfield 226	com/tencent/mm/modelvoice/j:eKF	I
    //   34: aload_0
    //   35: getfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   38: ifnull +22 -> 60
    //   41: aload_0
    //   42: getfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   45: invokevirtual 269	android/media/AudioTrack:stop	()V
    //   48: aload_0
    //   49: getfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   52: invokevirtual 272	android/media/AudioTrack:release	()V
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   60: iload_1
    //   61: ifeq +114 -> 175
    //   64: iconst_3
    //   65: istore_2
    //   66: iload_2
    //   67: istore_3
    //   68: getstatic 207	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   71: getfield 212	com/tencent/mm/compatible/e/b:duN	Z
    //   74: ifeq +23 -> 97
    //   77: getstatic 207	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   80: invokevirtual 215	com/tencent/mm/compatible/e/b:dump	()V
    //   83: iload_2
    //   84: istore_3
    //   85: getstatic 207	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   88: getfield 218	com/tencent/mm/compatible/e/b:duU	I
    //   91: iconst_1
    //   92: if_icmpne +5 -> 97
    //   95: iconst_3
    //   96: istore_3
    //   97: aload_0
    //   98: new 231	com/tencent/mm/compatible/b/d
    //   101: dup
    //   102: iload_3
    //   103: aload_0
    //   104: getfield 63	com/tencent/mm/modelvoice/j:nSamplerate	I
    //   107: aload_0
    //   108: getfield 61	com/tencent/mm/modelvoice/j:eKB	I
    //   111: aload_0
    //   112: getfield 226	com/tencent/mm/modelvoice/j:eKF	I
    //   115: bipush 8
    //   117: imul
    //   118: invokespecial 234	com/tencent/mm/compatible/b/d:<init>	(IIII)V
    //   121: putfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   124: aload_0
    //   125: getfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   128: invokevirtual 243	android/media/AudioTrack:play	()V
    //   131: aload_0
    //   132: iconst_0
    //   133: putfield 73	com/tencent/mm/modelvoice/j:eKH	Z
    //   136: return
    //   137: aload_0
    //   138: iconst_2
    //   139: putfield 61	com/tencent/mm/modelvoice/j:eKB	I
    //   142: goto -124 -> 18
    //   145: astore 4
    //   147: ldc 157
    //   149: aload 4
    //   151: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   162: goto -102 -> 60
    //   165: astore 4
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 236	com/tencent/mm/modelvoice/j:awx	Landroid/media/AudioTrack;
    //   172: aload 4
    //   174: athrow
    //   175: iconst_0
    //   176: istore_2
    //   177: goto -111 -> 66
    //   180: astore 4
    //   182: ldc 157
    //   184: ldc_w 262
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload 4
    //   195: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   198: aastore
    //   199: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: goto -71 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	j
    //   0	205	1	paramBoolean	boolean
    //   65	112	2	i	int
    //   67	36	3	j	int
    //   145	5	4	localException1	Exception
    //   165	8	4	localObject	Object
    //   180	14	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   41	55	145	java/lang/Exception
    //   41	55	165	finally
    //   147	157	165	finally
    //   124	131	180	java/lang/Exception
  }
  
  public final void b(b.a parama)
  {
    if ((parama != null) && (this.bBs != null)) {
      this.bBs.a(parama);
    }
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    return Q(paramString, paramBoolean);
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean isPlaying()
  {
    return this.status == 1;
  }
  
  /* Error */
  public final boolean ub()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mm/modelvoice/j:status	I
    //   4: iconst_2
    //   5: if_icmpeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 59	com/tencent/mm/modelvoice/j:status	I
    //   15: aload_0
    //   16: getfield 75	com/tencent/mm/modelvoice/j:eKk	Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: ldc 157
    //   24: ldc_w 307
    //   27: invokestatic 281	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 75	com/tencent/mm/modelvoice/j:eKk	Ljava/lang/String;
    //   34: invokevirtual 310	java/lang/Object:notify	()V
    //   37: ldc 157
    //   39: ldc_w 312
    //   42: invokestatic 281	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   49: ifnull +18 -> 67
    //   52: aload_0
    //   53: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   56: ifeq +11 -> 67
    //   59: aload_0
    //   60: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   63: invokevirtual 240	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   66: pop
    //   67: aload_1
    //   68: monitorexit
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_2
    //   72: ldc 157
    //   74: ldc 177
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_2
    //   83: invokestatic 183	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload_0
    //   91: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   94: ifnull +18 -> 112
    //   97: aload_0
    //   98: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   101: ifeq +11 -> 112
    //   104: aload_0
    //   105: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   108: invokevirtual 240	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   111: pop
    //   112: aload_1
    //   113: monitorexit
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   126: ifnull +18 -> 144
    //   129: aload_0
    //   130: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   133: ifeq +11 -> 144
    //   136: aload_0
    //   137: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   140: invokevirtual 240	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   143: pop
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	j
    //   19	99	1	str	String
    //   71	12	2	localException	Exception
    //   116	4	2	localObject1	Object
    //   121	24	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	45	71	java/lang/Exception
    //   45	67	116	finally
    //   67	69	116	finally
    //   90	112	116	finally
    //   112	114	116	finally
    //   117	119	116	finally
    //   122	144	116	finally
    //   144	146	116	finally
    //   22	45	121	finally
    //   72	90	121	finally
  }
  
  public final double ue()
  {
    return 0.0D;
  }
  
  /* Error */
  public final boolean un()
  {
    // Byte code:
    //   0: ldc 157
    //   2: new 110	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 317
    //   9: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 59	com/tencent/mm/modelvoice/j:status	I
    //   16: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 59	com/tencent/mm/modelvoice/j:status	I
    //   29: iconst_1
    //   30: if_icmpeq +38 -> 68
    //   33: aload_0
    //   34: getfield 59	com/tencent/mm/modelvoice/j:status	I
    //   37: iconst_2
    //   38: if_icmpeq +30 -> 68
    //   41: ldc 157
    //   43: new 110	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 319
    //   50: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 59	com/tencent/mm/modelvoice/j:status	I
    //   57: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: iconst_0
    //   67: ireturn
    //   68: aload_0
    //   69: iconst_3
    //   70: putfield 59	com/tencent/mm/modelvoice/j:status	I
    //   73: aload_0
    //   74: getfield 75	com/tencent/mm/modelvoice/j:eKk	Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 75	com/tencent/mm/modelvoice/j:eKk	Ljava/lang/String;
    //   84: invokevirtual 310	java/lang/Object:notify	()V
    //   87: aload_0
    //   88: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   91: ifnull +18 -> 109
    //   94: aload_0
    //   95: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   98: ifeq +11 -> 109
    //   101: aload_0
    //   102: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   105: invokevirtual 255	com/tencent/mm/compatible/util/b:zE	()Z
    //   108: pop
    //   109: aload_1
    //   110: monitorexit
    //   111: iconst_1
    //   112: ireturn
    //   113: astore_2
    //   114: ldc 157
    //   116: ldc 177
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_2
    //   125: invokestatic 183	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: invokevirtual 229	com/tencent/mm/modelvoice/j:Te	()V
    //   136: aload_0
    //   137: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   140: ifnull +18 -> 158
    //   143: aload_0
    //   144: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   147: ifeq +11 -> 158
    //   150: aload_0
    //   151: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   154: invokevirtual 255	com/tencent/mm/compatible/util/b:zE	()Z
    //   157: pop
    //   158: aload_1
    //   159: monitorexit
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload_1
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: aload_0
    //   169: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   172: ifnull +18 -> 190
    //   175: aload_0
    //   176: getfield 79	com/tencent/mm/modelvoice/j:eKt	Z
    //   179: ifeq +11 -> 190
    //   182: aload_0
    //   183: getfield 151	com/tencent/mm/modelvoice/j:bBs	Lcom/tencent/mm/compatible/util/b;
    //   186: invokevirtual 255	com/tencent/mm/compatible/util/b:zE	()Z
    //   189: pop
    //   190: aload_2
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	j
    //   77	87	1	str	String
    //   113	12	2	localException	Exception
    //   162	4	2	localObject1	Object
    //   167	24	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   80	87	113	java/lang/Exception
    //   87	109	162	finally
    //   109	111	162	finally
    //   136	158	162	finally
    //   158	160	162	finally
    //   163	165	162	finally
    //   168	190	162	finally
    //   190	192	162	finally
    //   80	87	167	finally
    //   114	136	167	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.j
 * JD-Core Version:    0.7.0.1
 */