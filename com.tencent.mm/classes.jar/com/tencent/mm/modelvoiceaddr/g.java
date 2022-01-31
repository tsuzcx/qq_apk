package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.util.Set;

public final class g
  implements f, b
{
  private static int bEl = 5000;
  private static final String eLH;
  public static int eLT = 1;
  public static int eLU = 2;
  public static int eLV = 4;
  private com.tencent.mm.f.b.c.a bCP = new g.1(this);
  private com.tencent.mm.f.b.c bCc;
  private int eLJ = 0;
  private int eLK = 0;
  private boolean eLL = false;
  private com.tencent.mm.f.c.a eLP;
  private a eLR = null;
  private boolean eLW = false;
  private g.b eLX = null;
  private com.tencent.mm.modelvoiceaddr.a.c eLY;
  private com.tencent.mm.modelvoiceaddr.a.c.a eLZ = new g.2(this);
  private int eLu = eLT;
  private int scene = 0;
  
  static
  {
    eLH = ac.dOP + "voice_temp.silk";
  }
  
  public g() {}
  
  public g(int paramInt1, int paramInt2, g.b paramb)
  {
    this.eLu = paramInt1;
    this.eLX = paramb;
    this.scene = paramInt2;
  }
  
  /* Error */
  private void k(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 120
    //   2: ldc 156
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: iload_1
    //   11: invokestatic 161	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: iload_2
    //   18: invokestatic 161	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 163	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 82	com/tencent/mm/modelvoiceaddr/g:eLW	Z
    //   32: aload_0
    //   33: getfield 109	com/tencent/mm/modelvoiceaddr/g:bCc	Lcom/tencent/mm/f/b/c;
    //   36: ifnull +16 -> 52
    //   39: aload_0
    //   40: getfield 109	com/tencent/mm/modelvoiceaddr/g:bCc	Lcom/tencent/mm/f/b/c;
    //   43: invokevirtual 169	com/tencent/mm/f/b/c:uh	()Z
    //   46: pop
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 109	com/tencent/mm/modelvoiceaddr/g:bCc	Lcom/tencent/mm/f/b/c;
    //   52: aload_0
    //   53: getfield 113	com/tencent/mm/modelvoiceaddr/g:eLP	Lcom/tencent/mm/f/c/a;
    //   56: ifnull +17 -> 73
    //   59: aload_0
    //   60: getfield 113	com/tencent/mm/modelvoiceaddr/g:eLP	Lcom/tencent/mm/f/c/a;
    //   63: invokeinterface 174 1 0
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 113	com/tencent/mm/modelvoiceaddr/g:eLP	Lcom/tencent/mm/f/c/a;
    //   73: aload_0
    //   74: getfield 116	com/tencent/mm/modelvoiceaddr/g:eLY	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   77: astore 4
    //   79: aload 4
    //   81: ifnull +15 -> 96
    //   84: aload_0
    //   85: getfield 116	com/tencent/mm/modelvoiceaddr/g:eLY	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   88: invokevirtual 179	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 116	com/tencent/mm/modelvoiceaddr/g:eLY	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 78	com/tencent/mm/modelvoiceaddr/g:eLK	I
    //   101: aload_0
    //   102: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   105: ifnull +38 -> 143
    //   108: aload_0
    //   109: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   112: instanceof 181
    //   115: ifeq +28 -> 143
    //   118: aload_0
    //   119: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   122: invokevirtual 186	com/tencent/mm/modelvoiceaddr/a:Tp	()V
    //   125: getstatic 70	com/tencent/mm/modelvoiceaddr/g:eLH	Ljava/lang/String;
    //   128: invokestatic 192	com/tencent/mm/a/e:bJ	(Ljava/lang/String;)I
    //   131: istore_3
    //   132: aload_0
    //   133: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   136: checkcast 181	com/tencent/mm/modelvoiceaddr/c
    //   139: iload_3
    //   140: invokevirtual 196	com/tencent/mm/modelvoiceaddr/c:jA	(I)V
    //   143: iload_1
    //   144: ifne +10 -> 154
    //   147: aload_0
    //   148: getfield 80	com/tencent/mm/modelvoiceaddr/g:eLL	Z
    //   151: ifne +56 -> 207
    //   154: aload_0
    //   155: monitorexit
    //   156: return
    //   157: astore 4
    //   159: ldc 120
    //   161: aload 4
    //   163: ldc 198
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 202	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: goto -76 -> 96
    //   175: astore 4
    //   177: aload_0
    //   178: monitorexit
    //   179: aload 4
    //   181: athrow
    //   182: astore 4
    //   184: ldc 120
    //   186: aload 4
    //   188: ldc 204
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 202	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: bipush 6
    //   200: iconst_m1
    //   201: invokevirtual 208	com/tencent/mm/modelvoiceaddr/g:bA	(II)V
    //   204: goto -61 -> 143
    //   207: aload_0
    //   208: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   211: ifnull +55 -> 266
    //   214: aload_0
    //   215: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   218: instanceof 181
    //   221: ifeq +45 -> 266
    //   224: ldc 120
    //   226: ldc 210
    //   228: iconst_1
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: iload_2
    //   235: invokestatic 161	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   238: aastore
    //   239: invokestatic 163	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: iload_2
    //   243: ifeq +13 -> 256
    //   246: aload_0
    //   247: getfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   250: checkcast 181	com/tencent/mm/modelvoiceaddr/c
    //   253: invokevirtual 213	com/tencent/mm/modelvoiceaddr/c:Tv	()V
    //   256: invokestatic 219	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   259: sipush 235
    //   262: aload_0
    //   263: invokevirtual 224	com/tencent/mm/ah/p:b	(ILcom/tencent/mm/ah/f;)V
    //   266: aload_0
    //   267: aconst_null
    //   268: putfield 90	com/tencent/mm/modelvoiceaddr/g:eLR	Lcom/tencent/mm/modelvoiceaddr/a;
    //   271: aload_0
    //   272: iconst_0
    //   273: putfield 80	com/tencent/mm/modelvoiceaddr/g:eLL	Z
    //   276: aload_0
    //   277: monitorexit
    //   278: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	g
    //   0	279	1	paramBoolean1	boolean
    //   0	279	2	paramBoolean2	boolean
    //   131	9	3	i	int
    //   77	3	4	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   157	5	4	localException1	java.lang.Exception
    //   175	5	4	localObject	Object
    //   182	5	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   84	96	157	java/lang/Exception
    //   27	52	175	finally
    //   52	73	175	finally
    //   73	79	175	finally
    //   84	96	175	finally
    //   96	132	175	finally
    //   132	143	175	finally
    //   147	154	175	finally
    //   154	156	175	finally
    //   159	172	175	finally
    //   177	179	175	finally
    //   184	204	175	finally
    //   207	242	175	finally
    //   246	256	175	finally
    //   256	266	175	finally
    //   266	278	175	finally
    //   132	143	182	java/lang/Exception
  }
  
  public final void bA(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(-1) });
    if (this.eLX != null) {
      this.eLX.c(paramInt1, paramInt2, -1, -1L);
    }
    k(false, true);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.eLX = null;
    k(false, paramBoolean);
  }
  
  public final int getMaxAmplitudeRate()
  {
    int i = this.eLJ;
    this.eLJ = 0;
    if (i > bEl) {
      bEl = i;
    }
    return i * 100 / bEl;
  }
  
  public final void init(int paramInt1, int paramInt2, g.b paramb)
  {
    this.eLu = paramInt1;
    this.eLX = paramb;
    this.scene = paramInt2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    String[] arrayOfString = ((a)paramm).Tq();
    Set localSet = ((a)paramm).Tt();
    long l = System.currentTimeMillis();
    int i;
    int j;
    if (arrayOfString == null)
    {
      i = -1;
      int k = paramm.hashCode();
      if (this.eLR != null) {
        break label148;
      }
      j = -1;
      label50:
      y.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.eLR != null) && (paramm.hashCode() == this.eLR.hashCode())) {
        break label160;
      }
      y.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
    }
    label148:
    label160:
    do
    {
      do
      {
        return;
        i = arrayOfString.length;
        break;
        j = this.eLR.hashCode();
        break label50;
      } while (this.eLX == null);
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.eLX.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          cancel(false);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.eLX.c(13, 133, -1, -1L);
          } else {
            this.eLX.c(11, paramInt1, paramInt2, ((a)paramm).Ts());
          }
        }
      }
      this.eLX.a(arrayOfString, localSet);
    } while ((!(paramm instanceof c)) || (this.eLK != 0) || (!((c)paramm).eLp.TE()));
    this.eLX.TC();
    cancel(false);
  }
  
  public final void start()
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "start record");
    e.a(new g.a(this, (byte)0), "SceneVoiceInputAddr_record", 10);
  }
  
  public final void stop(boolean paramBoolean)
  {
    y.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (this.eLX != null)) {
      this.eLX.Ty();
    }
    k(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g
 * JD-Core Version:    0.7.0.1
 */