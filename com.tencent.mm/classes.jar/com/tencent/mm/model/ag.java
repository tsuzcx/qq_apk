package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.e;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public final class ag
{
  MMHandler handler;
  BlockingQueue<c> okA;
  public b okB;
  public a okx;
  boolean oky;
  String okz;
  
  public ag(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(150160);
    this.okx = null;
    this.oky = false;
    this.okz = "";
    this.okA = new ArrayBlockingQueue(80);
    this.okB = null;
    com.tencent.mm.kernel.h.baF();
    this.handler = new MMHandler(com.tencent.mm.kernel.h.baH().getLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(150157);
        for (;;)
        {
          try
          {
            Bitmap localBitmap;
            if (ag.this.okB != null)
            {
              paramAnonymousMessage = (ag.c)paramAnonymousMessage.obj;
              if ((paramAnonymousMessage.okJ) && (com.tencent.mm.modelimage.u.bKj()))
              {
                String str = com.tencent.mm.modelimage.u.On(paramAnonymousMessage.url);
                Log.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", new Object[] { str, paramAnonymousMessage.filename, paramAnonymousMessage.url });
                localBitmap = BitmapUtil.getBitmapNative(paramAnonymousMessage.filename);
                if (localBitmap == null) {
                  break label227;
                }
                if (!Util.isNullOrNil(str))
                {
                  if (!str.toLowerCase().contains("png")) {
                    continue;
                  }
                  Log.d("MicroMsg.GetPicService", "convert webp to png");
                  BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousMessage.filename, true);
                }
              }
              int i = (int)y.bEl(paramAnonymousMessage.filename);
              if ((i > 0) && (com.tencent.mm.kernel.h.baz())) {
                az.a.okQ.eB(i, 0);
              }
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(150156);
                  if (ag.this.okB != null) {
                    ag.this.okB.l(paramAnonymousMessage.url, paramAnonymousMessage.filename, paramAnonymousMessage.pos);
                  }
                  AppMethodBeat.o(150156);
                }
              });
            }
            else
            {
              AppMethodBeat.o(150157);
              return;
            }
            Log.d("MicroMsg.GetPicService", "convert webp to jpg");
            BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, paramAnonymousMessage.filename, true);
            continue;
            Log.d("MicroMsg.GetPicService", "decode webp picture failed");
          }
          catch (Exception paramAnonymousMessage)
          {
            Log.e("MicroMsg.GetPicService", "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousMessage) });
            AppMethodBeat.o(150157);
            return;
          }
          label227:
          ag.a(ag.this, 14L, 1L);
        }
      }
    };
    this.okx = null;
    this.oky = paramBoolean;
    this.okz = paramString;
    Log.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b isFromWebViewReffer:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppMethodBeat.o(150160);
  }
  
  public final String c(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(150161);
    Object localObject;
    if (paramString1 == null) {
      localObject = null;
    }
    for (;;)
    {
      Log.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + paramInt1 + " url:" + paramString1 + " filename:" + (String)localObject);
      try
      {
        boolean bool = y.ZC((String)localObject);
        if (!bool) {
          break label258;
        }
        AppMethodBeat.o(150161);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.GetPicService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
      if (!com.tencent.mm.kernel.h.baz())
      {
        Log.i("MicroMsg.GetPicService", "genFileName, account not ready");
        localObject = new com.tencent.mm.vfs.u(com.tencent.mm.kernel.h.baE().mCI + "/imagecache");
        if (!((com.tencent.mm.vfs.u)localObject).jKS()) {
          ((com.tencent.mm.vfs.u)localObject).jKY();
        }
        localObject = ah.v(((com.tencent.mm.vfs.u)localObject).jKT()) + "/reader_" + paramInt1 + "_" + g.getMessageDigest(paramString1.getBytes()) + ".jpg";
      }
      else
      {
        localObject = d.bzL() + "/reader_" + paramInt1 + "_" + g.getMessageDigest(paramString1.getBytes()) + ".jpg";
      }
    }
    for (;;)
    {
      try
      {
        label258:
        this.okA.add(new c(paramString1, (String)localObject, paramInt2, paramString2));
        if (this.okx != null)
        {
          paramString1 = this.okx;
          if ((paramString1.dBj == null) || (paramString1.dBj.isDone())) {
            continue;
          }
          paramInt1 = 1;
          break label407;
        }
        if (this.okx != null)
        {
          paramString1 = this.okx;
          if (paramString1.dBj != null) {
            paramString1.dBj.cancel(false);
          }
        }
        this.okx = new a();
        com.tencent.threadpool.h.ahAA.bm(this.okx);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.GetPicService", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
        continue;
      }
      AppMethodBeat.o(150161);
      return null;
      paramInt1 = 0;
      label407:
      if (paramInt1 != 0) {}
    }
  }
  
  public final class a
    implements e, com.tencent.threadpool.i.h
  {
    Future<?> dBj;
    public boolean okF = true;
    ag.c okG = null;
    final int okH = 15;
    int okI = 0;
    
    a() {}
    
    private boolean uZ(int paramInt)
    {
      return (ag.this.oky) && (this.okI < 15) && ((paramInt == 301) || (paramInt == 302));
    }
    
    public final void c(Future<?> paramFuture)
    {
      this.dBj = paramFuture;
    }
    
    public final String getKey()
    {
      return "GetPicService_getPic";
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 58
      //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: iconst_0
      //   7: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   10: iconst_0
      //   11: istore_1
      //   12: aload_0
      //   13: getfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   16: ifne +4341 -> 4357
      //   19: iload_1
      //   20: bipush 10
      //   22: if_icmple +14 -> 36
      //   25: aload_0
      //   26: iconst_1
      //   27: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   30: ldc 58
      //   32: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   35: return
      //   36: aconst_null
      //   37: astore 12
      //   39: aconst_null
      //   40: astore 13
      //   42: aconst_null
      //   43: astore 19
      //   45: aconst_null
      //   46: astore 14
      //   48: aconst_null
      //   49: astore 18
      //   51: aconst_null
      //   52: astore 16
      //   54: aconst_null
      //   55: astore 20
      //   57: aconst_null
      //   58: astore 15
      //   60: aconst_null
      //   61: astore 21
      //   63: aconst_null
      //   64: astore 11
      //   66: aconst_null
      //   67: astore 17
      //   69: aconst_null
      //   70: astore 22
      //   72: aload 22
      //   74: astore 9
      //   76: aload 20
      //   78: astore 10
      //   80: aload_0
      //   81: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   84: ifne +87 -> 171
      //   87: iconst_1
      //   88: istore_2
      //   89: iload_2
      //   90: ifeq +86 -> 176
      //   93: aload 22
      //   95: astore 9
      //   97: aload 20
      //   99: astore 10
      //   101: aload_0
      //   102: aload_0
      //   103: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   106: getfield 71	com/tencent/mm/model/ag:okA	Ljava/util/concurrent/BlockingQueue;
      //   109: ldc2_w 72
      //   112: getstatic 79	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   115: invokeinterface 85 4 0
      //   120: checkcast 87	com/tencent/mm/model/ag$c
      //   123: putfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   126: aload 22
      //   128: astore 9
      //   130: aload 20
      //   132: astore 10
      //   134: aload_0
      //   135: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   138: ifnull +26 -> 164
      //   141: aload 22
      //   143: astore 9
      //   145: aload 20
      //   147: astore 10
      //   149: aload_0
      //   150: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   153: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   156: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   159: istore_3
      //   160: iload_3
      //   161: ifeq +15 -> 176
      //   164: iload_1
      //   165: iconst_1
      //   166: iadd
      //   167: istore_1
      //   168: goto -156 -> 12
      //   171: iconst_0
      //   172: istore_2
      //   173: goto -84 -> 89
      //   176: aload 22
      //   178: astore 9
      //   180: aload 20
      //   182: astore 10
      //   184: ldc 99
      //   186: new 101	java/lang/StringBuilder
      //   189: dup
      //   190: ldc 103
      //   192: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   195: aload_0
      //   196: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   199: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   202: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: ldc 112
      //   207: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: aload_0
      //   211: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   214: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   217: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   223: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   226: aload 22
      //   228: astore 9
      //   230: aload 20
      //   232: astore 10
      //   234: aload_0
      //   235: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   238: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   241: invokestatic 129	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   244: ifeq +43 -> 287
      //   247: aload 22
      //   249: astore 9
      //   251: aload 20
      //   253: astore 10
      //   255: ldc 99
      //   257: new 101	java/lang/StringBuilder
      //   260: dup
      //   261: ldc 131
      //   263: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   266: aload_0
      //   267: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   270: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   273: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   279: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   282: iconst_0
      //   283: istore_1
      //   284: goto -272 -> 12
      //   287: aload 22
      //   289: astore 9
      //   291: aload 20
      //   293: astore 10
      //   295: aload_0
      //   296: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   299: lconst_0
      //   300: lconst_1
      //   301: invokestatic 134	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   304: aload 22
      //   306: astore 9
      //   308: aload 20
      //   310: astore 10
      //   312: invokestatic 138	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   315: lstore 4
      //   317: aload 22
      //   319: astore 9
      //   321: aload 20
      //   323: astore 10
      //   325: ldc 99
      //   327: ldc 140
      //   329: iconst_1
      //   330: anewarray 4	java/lang/Object
      //   333: dup
      //   334: iconst_0
      //   335: aload_0
      //   336: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   339: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   342: aastore
      //   343: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   346: aload 22
      //   348: astore 9
      //   350: aload 20
      //   352: astore 10
      //   354: invokestatic 148	java/lang/System:currentTimeMillis	()J
      //   357: lstore 6
      //   359: aload 22
      //   361: astore 9
      //   363: aload 20
      //   365: astore 10
      //   367: aload_0
      //   368: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   371: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   374: invokestatic 153	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   377: ifeq +2681 -> 3058
      //   380: aload 22
      //   382: astore 9
      //   384: aload 20
      //   386: astore 10
      //   388: ldc 155
      //   390: invokestatic 161	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   393: checkcast 155	com/tencent/mm/plugin/expt/b/c
      //   396: getstatic 167	com/tencent/mm/plugin/expt/b/c$a:zmZ	Lcom/tencent/mm/plugin/expt/b/c$a;
      //   399: iconst_0
      //   400: invokeinterface 170 3 0
      //   405: ifne +1685 -> 2090
      //   408: aload 22
      //   410: astore 9
      //   412: aload 20
      //   414: astore 10
      //   416: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   419: ldc2_w 177
      //   422: ldc2_w 179
      //   425: lconst_1
      //   426: iconst_0
      //   427: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   430: aload 22
      //   432: astore 9
      //   434: aload 20
      //   436: astore 10
      //   438: aload_0
      //   439: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   442: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   445: invokestatic 190	com/tencent/mm/network/d:Ru	(Ljava/lang/String;)Lcom/tencent/mm/network/ab;
      //   448: astore 8
      //   450: aload 8
      //   452: ifnonnull +42 -> 494
      //   455: aload 22
      //   457: astore 9
      //   459: aload 8
      //   461: astore 10
      //   463: ldc 99
      //   465: ldc 192
      //   467: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   470: aload 8
      //   472: ifnull +8 -> 480
      //   475: aload 8
      //   477: invokevirtual 197	com/tencent/mm/network/ab:disconnect	()V
      //   480: ldc 58
      //   482: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   485: return
      //   486: astore 8
      //   488: ldc 58
      //   490: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   493: return
      //   494: aload 22
      //   496: astore 9
      //   498: aload 8
      //   500: astore 10
      //   502: invokestatic 203	com/tencent/mm/modelimage/u:bKj	()Z
      //   505: ifeq +79 -> 584
      //   508: aload 22
      //   510: astore 9
      //   512: aload 8
      //   514: astore 10
      //   516: aload_0
      //   517: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   520: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   523: invokestatic 206	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
      //   526: ifeq +58 -> 584
      //   529: aload 22
      //   531: astore 9
      //   533: aload 8
      //   535: astore 10
      //   537: getstatic 211	com/tencent/mm/protocal/d:Yxh	I
      //   540: invokestatic 215	com/tencent/mm/modelimage/u:wy	(I)Ljava/lang/String;
      //   543: astore 14
      //   545: aload 22
      //   547: astore 9
      //   549: aload 8
      //   551: astore 10
      //   553: ldc 99
      //   555: ldc 217
      //   557: iconst_1
      //   558: anewarray 4	java/lang/Object
      //   561: dup
      //   562: iconst_0
      //   563: aload 14
      //   565: aastore
      //   566: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   569: aload 22
      //   571: astore 9
      //   573: aload 8
      //   575: astore 10
      //   577: aload 8
      //   579: aload 14
      //   581: invokevirtual 220	com/tencent/mm/network/ab:Ry	(Ljava/lang/String;)V
      //   584: aload 22
      //   586: astore 9
      //   588: aload 8
      //   590: astore 10
      //   592: aload_0
      //   593: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   596: getfield 44	com/tencent/mm/model/ag:oky	Z
      //   599: ifeq +73 -> 672
      //   602: aload 22
      //   604: astore 9
      //   606: aload 8
      //   608: astore 10
      //   610: aload_0
      //   611: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   614: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   617: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   620: ifne +52 -> 672
      //   623: aload 22
      //   625: astore 9
      //   627: aload 8
      //   629: astore 10
      //   631: ldc 99
      //   633: ldc 225
      //   635: iconst_1
      //   636: anewarray 4	java/lang/Object
      //   639: dup
      //   640: iconst_0
      //   641: aload_0
      //   642: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   645: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   648: aastore
      //   649: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   652: aload 22
      //   654: astore 9
      //   656: aload 8
      //   658: astore 10
      //   660: aload 8
      //   662: aload_0
      //   663: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   666: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   669: invokevirtual 220	com/tencent/mm/network/ab:Ry	(Ljava/lang/String;)V
      //   672: aload 22
      //   674: astore 9
      //   676: aload 8
      //   678: astore 10
      //   680: ldc 99
      //   682: ldc 227
      //   684: iconst_2
      //   685: anewarray 4	java/lang/Object
      //   688: dup
      //   689: iconst_0
      //   690: aload_0
      //   691: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   694: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   697: aastore
      //   698: dup
      //   699: iconst_1
      //   700: aload_0
      //   701: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   704: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   707: aastore
      //   708: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   711: aload 22
      //   713: astore 9
      //   715: aload 8
      //   717: astore 10
      //   719: aload_0
      //   720: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   723: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   726: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   729: ifne +40 -> 769
      //   732: aload 22
      //   734: astore 9
      //   736: aload 8
      //   738: astore 10
      //   740: aload_0
      //   741: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   744: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   747: astore 14
      //   749: aload 22
      //   751: astore 9
      //   753: aload 8
      //   755: astore 10
      //   757: aload 8
      //   759: getfield 236	com/tencent/mm/network/ab:ppu	Ljavax/net/ssl/HttpsURLConnection;
      //   762: ldc 238
      //   764: aload 14
      //   766: invokevirtual 243	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   769: aload 22
      //   771: astore 9
      //   773: aload 8
      //   775: astore 10
      //   777: aload 8
      //   779: invokevirtual 246	com/tencent/mm/network/ab:bRk	()V
      //   782: aload 22
      //   784: astore 9
      //   786: aload 8
      //   788: astore 10
      //   790: aload 8
      //   792: sipush 3000
      //   795: invokevirtual 249	com/tencent/mm/network/ab:xx	(I)V
      //   798: aload 22
      //   800: astore 9
      //   802: aload 8
      //   804: astore 10
      //   806: aload 8
      //   808: sipush 3000
      //   811: invokevirtual 252	com/tencent/mm/network/ab:xy	(I)V
      //   814: aload 22
      //   816: astore 9
      //   818: aload 8
      //   820: astore 10
      //   822: aload 8
      //   824: getfield 236	com/tencent/mm/network/ab:ppu	Ljavax/net/ssl/HttpsURLConnection;
      //   827: invokevirtual 256	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
      //   830: istore_1
      //   831: aload 22
      //   833: astore 9
      //   835: aload 8
      //   837: astore 10
      //   839: aload_0
      //   840: iload_1
      //   841: invokespecial 258	com/tencent/mm/model/ag$a:uZ	(I)Z
      //   844: ifeq +467 -> 1311
      //   847: aload 22
      //   849: astore 9
      //   851: aload 8
      //   853: astore 10
      //   855: aload_0
      //   856: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   859: aload 8
      //   861: getfield 236	com/tencent/mm/network/ab:ppu	Ljavax/net/ssl/HttpsURLConnection;
      //   864: ldc_w 260
      //   867: invokevirtual 264	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   870: putfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   873: aload 22
      //   875: astore 9
      //   877: aload 8
      //   879: astore 10
      //   881: aload_0
      //   882: aload_0
      //   883: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   886: iconst_1
      //   887: iadd
      //   888: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   891: aload 22
      //   893: astore 9
      //   895: aload 8
      //   897: astore 10
      //   899: aload_0
      //   900: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   903: bipush 15
      //   905: if_icmpge +38 -> 943
      //   908: aload 22
      //   910: astore 9
      //   912: aload 8
      //   914: astore 10
      //   916: aload_0
      //   917: iconst_0
      //   918: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   921: aload 8
      //   923: ifnull +8 -> 931
      //   926: aload 8
      //   928: invokevirtual 197	com/tencent/mm/network/ab:disconnect	()V
      //   931: iconst_0
      //   932: istore_1
      //   933: goto -921 -> 12
      //   936: astore 8
      //   938: iconst_0
      //   939: istore_1
      //   940: goto -928 -> 12
      //   943: aload 22
      //   945: astore 9
      //   947: aload 8
      //   949: astore 10
      //   951: aload_0
      //   952: iconst_1
      //   953: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   956: aload 22
      //   958: astore 9
      //   960: aload 8
      //   962: astore 10
      //   964: aload_0
      //   965: iconst_0
      //   966: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   969: aconst_null
      //   970: astore 9
      //   972: aload 11
      //   974: astore 14
      //   976: aload 8
      //   978: astore 13
      //   980: aload 9
      //   982: astore 10
      //   984: sipush 1024
      //   987: newarray byte
      //   989: astore 16
      //   991: aload 11
      //   993: astore 14
      //   995: aload 8
      //   997: astore 13
      //   999: aload 9
      //   1001: astore 10
      //   1003: new 101	java/lang/StringBuilder
      //   1006: dup
      //   1007: invokespecial 265	java/lang/StringBuilder:<init>	()V
      //   1010: aload_0
      //   1011: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1014: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   1017: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1020: ldc_w 267
      //   1023: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1026: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1029: iconst_0
      //   1030: invokestatic 271	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   1033: astore 11
      //   1035: aload 11
      //   1037: astore 10
      //   1039: aload 17
      //   1041: astore 14
      //   1043: aload 8
      //   1045: astore 13
      //   1047: aload 9
      //   1049: astore 12
      //   1051: aload 10
      //   1053: astore 11
      //   1055: aload 9
      //   1057: aload 16
      //   1059: invokevirtual 277	java/io/InputStream:read	([B)I
      //   1062: istore_2
      //   1063: iload_2
      //   1064: iconst_m1
      //   1065: if_icmpeq +288 -> 1353
      //   1068: aload 17
      //   1070: astore 14
      //   1072: aload 8
      //   1074: astore 13
      //   1076: aload 9
      //   1078: astore 12
      //   1080: aload 10
      //   1082: astore 11
      //   1084: aload 10
      //   1086: aload 16
      //   1088: iconst_0
      //   1089: iload_2
      //   1090: invokevirtual 283	java/io/OutputStream:write	([BII)V
      //   1093: goto -54 -> 1039
      //   1096: astore 12
      //   1098: aconst_null
      //   1099: astore 11
      //   1101: iconst_0
      //   1102: istore_1
      //   1103: aload 8
      //   1105: astore 15
      //   1107: aload 9
      //   1109: astore 14
      //   1111: aload 10
      //   1113: astore 13
      //   1115: aload 11
      //   1117: astore 16
      //   1119: aload_0
      //   1120: iconst_0
      //   1121: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   1124: aload 8
      //   1126: astore 15
      //   1128: aload 9
      //   1130: astore 14
      //   1132: aload 10
      //   1134: astore 13
      //   1136: aload 11
      //   1138: astore 16
      //   1140: ldc 99
      //   1142: ldc_w 285
      //   1145: iconst_1
      //   1146: anewarray 4	java/lang/Object
      //   1149: dup
      //   1150: iconst_0
      //   1151: aload 12
      //   1153: invokestatic 289	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1156: aastore
      //   1157: invokestatic 292	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1160: aload 8
      //   1162: astore 15
      //   1164: aload 9
      //   1166: astore 14
      //   1168: aload 10
      //   1170: astore 13
      //   1172: aload 11
      //   1174: astore 16
      //   1176: aload_0
      //   1177: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   1180: ldc2_w 293
      //   1183: lconst_1
      //   1184: invokestatic 134	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1187: aload 8
      //   1189: astore 15
      //   1191: aload 9
      //   1193: astore 14
      //   1195: aload 10
      //   1197: astore 13
      //   1199: aload 11
      //   1201: astore 16
      //   1203: aload_0
      //   1204: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1207: ifnull +59 -> 1266
      //   1210: aload 8
      //   1212: astore 15
      //   1214: aload 9
      //   1216: astore 14
      //   1218: aload 10
      //   1220: astore 13
      //   1222: aload 11
      //   1224: astore 16
      //   1226: aload_0
      //   1227: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1230: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   1233: invokestatic 206	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
      //   1236: ifeq +30 -> 1266
      //   1239: aload 8
      //   1241: astore 15
      //   1243: aload 9
      //   1245: astore 14
      //   1247: aload 10
      //   1249: astore 13
      //   1251: aload 11
      //   1253: astore 16
      //   1255: aload_0
      //   1256: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   1259: ldc2_w 295
      //   1262: lconst_1
      //   1263: invokestatic 134	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1266: aload 10
      //   1268: ifnull +8 -> 1276
      //   1271: aload 10
      //   1273: invokevirtual 299	java/io/OutputStream:close	()V
      //   1276: aload 9
      //   1278: ifnull +8 -> 1286
      //   1281: aload 9
      //   1283: invokevirtual 300	java/io/InputStream:close	()V
      //   1286: aload 11
      //   1288: ifnull +10 -> 1298
      //   1291: aload 11
      //   1293: invokeinterface 303 1 0
      //   1298: aload 8
      //   1300: ifnull +8 -> 1308
      //   1303: aload 8
      //   1305: invokevirtual 197	com/tencent/mm/network/ab:disconnect	()V
      //   1308: goto -1296 -> 12
      //   1311: aload 22
      //   1313: astore 9
      //   1315: aload 8
      //   1317: astore 10
      //   1319: aload 8
      //   1321: getfield 236	com/tencent/mm/network/ab:ppu	Ljavax/net/ssl/HttpsURLConnection;
      //   1324: invokevirtual 307	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   1327: astore 14
      //   1329: aload 14
      //   1331: astore 9
      //   1333: aload 9
      //   1335: astore 10
      //   1337: aload 21
      //   1339: astore 13
      //   1341: aload 8
      //   1343: astore 14
      //   1345: aload_0
      //   1346: iconst_0
      //   1347: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   1350: goto -378 -> 972
      //   1353: aload 17
      //   1355: astore 14
      //   1357: aload 8
      //   1359: astore 13
      //   1361: aload 9
      //   1363: astore 12
      //   1365: aload 10
      //   1367: astore 11
      //   1369: new 309	com/tencent/mm/vfs/u
      //   1372: dup
      //   1373: new 101	java/lang/StringBuilder
      //   1376: dup
      //   1377: invokespecial 265	java/lang/StringBuilder:<init>	()V
      //   1380: aload_0
      //   1381: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1384: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   1387: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1390: ldc_w 267
      //   1393: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1396: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1399: invokespecial 310	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   1402: new 309	com/tencent/mm/vfs/u
      //   1405: dup
      //   1406: aload_0
      //   1407: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1410: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   1413: invokespecial 310	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   1416: invokevirtual 314	com/tencent/mm/vfs/u:am	(Lcom/tencent/mm/vfs/u;)Z
      //   1419: pop
      //   1420: aload 17
      //   1422: astore 14
      //   1424: aload 8
      //   1426: astore 13
      //   1428: aload 9
      //   1430: astore 12
      //   1432: aload 10
      //   1434: astore 11
      //   1436: aload 8
      //   1438: getfield 236	com/tencent/mm/network/ab:ppu	Ljavax/net/ssl/HttpsURLConnection;
      //   1441: invokevirtual 317	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
      //   1444: astore 16
      //   1446: iload_1
      //   1447: sipush 200
      //   1450: if_icmpne +120 -> 1570
      //   1453: aload 17
      //   1455: astore 14
      //   1457: aload 8
      //   1459: astore 13
      //   1461: aload 9
      //   1463: astore 12
      //   1465: aload 10
      //   1467: astore 11
      //   1469: invokestatic 148	java/lang/System:currentTimeMillis	()J
      //   1472: lload 6
      //   1474: lsub
      //   1475: lstore 6
      //   1477: aload 17
      //   1479: astore 14
      //   1481: aload 8
      //   1483: astore 13
      //   1485: aload 9
      //   1487: astore 12
      //   1489: aload 10
      //   1491: astore 11
      //   1493: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   1496: ldc2_w 177
      //   1499: ldc2_w 318
      //   1502: lload 6
      //   1504: iconst_0
      //   1505: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1508: aload 17
      //   1510: astore 14
      //   1512: aload 8
      //   1514: astore 13
      //   1516: aload 9
      //   1518: astore 12
      //   1520: aload 10
      //   1522: astore 11
      //   1524: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   1527: ldc2_w 177
      //   1530: ldc2_w 320
      //   1533: lconst_1
      //   1534: iconst_0
      //   1535: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1538: aload 17
      //   1540: astore 14
      //   1542: aload 8
      //   1544: astore 13
      //   1546: aload 9
      //   1548: astore 12
      //   1550: aload 10
      //   1552: astore 11
      //   1554: ldc 99
      //   1556: ldc_w 323
      //   1559: lload 6
      //   1561: invokestatic 329	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1564: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1567: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1570: aload 16
      //   1572: astore 12
      //   1574: ldc 99
      //   1576: ldc_w 336
      //   1579: iconst_1
      //   1580: anewarray 4	java/lang/Object
      //   1583: dup
      //   1584: iconst_0
      //   1585: aload 12
      //   1587: aastore
      //   1588: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1591: aconst_null
      //   1592: astore 11
      //   1594: aload 8
      //   1596: astore 15
      //   1598: aload 9
      //   1600: astore 14
      //   1602: aload 10
      //   1604: astore 13
      //   1606: aload 11
      //   1608: astore 16
      //   1610: invokestatic 203	com/tencent/mm/modelimage/u:bKj	()Z
      //   1613: ifeq +2642 -> 4255
      //   1616: aload 8
      //   1618: astore 15
      //   1620: aload 9
      //   1622: astore 14
      //   1624: aload 10
      //   1626: astore 13
      //   1628: aload 11
      //   1630: astore 16
      //   1632: aload_0
      //   1633: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1636: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   1639: invokestatic 206	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
      //   1642: ifeq +2613 -> 4255
      //   1645: aload 8
      //   1647: astore 15
      //   1649: aload 9
      //   1651: astore 14
      //   1653: aload 10
      //   1655: astore 13
      //   1657: aload 11
      //   1659: astore 16
      //   1661: aload 12
      //   1663: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   1666: ifne +2589 -> 4255
      //   1669: aload 8
      //   1671: astore 15
      //   1673: aload 9
      //   1675: astore 14
      //   1677: aload 10
      //   1679: astore 13
      //   1681: aload 11
      //   1683: astore 16
      //   1685: aload 12
      //   1687: ldc_w 338
      //   1690: invokevirtual 342	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1693: ifeq +2562 -> 4255
      //   1696: aload 8
      //   1698: astore 15
      //   1700: aload 9
      //   1702: astore 14
      //   1704: aload 10
      //   1706: astore 13
      //   1708: aload 11
      //   1710: astore 16
      //   1712: ldc 99
      //   1714: ldc_w 344
      //   1717: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   1720: aload 8
      //   1722: astore 15
      //   1724: aload 9
      //   1726: astore 14
      //   1728: aload 10
      //   1730: astore 13
      //   1732: aload 11
      //   1734: astore 16
      //   1736: aload_0
      //   1737: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1740: iconst_1
      //   1741: putfield 347	com/tencent/mm/model/ag$c:okJ	Z
      //   1744: aload 8
      //   1746: astore 15
      //   1748: aload 9
      //   1750: astore 14
      //   1752: aload 10
      //   1754: astore 13
      //   1756: aload 11
      //   1758: astore 16
      //   1760: aload_0
      //   1761: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   1764: ldc2_w 348
      //   1767: lconst_1
      //   1768: invokestatic 134	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1771: aload 8
      //   1773: astore 15
      //   1775: aload 9
      //   1777: astore 14
      //   1779: aload 10
      //   1781: astore 13
      //   1783: aload 11
      //   1785: astore 16
      //   1787: new 351	android/os/Message
      //   1790: dup
      //   1791: invokespecial 352	android/os/Message:<init>	()V
      //   1794: astore 12
      //   1796: aload 8
      //   1798: astore 15
      //   1800: aload 9
      //   1802: astore 14
      //   1804: aload 10
      //   1806: astore 13
      //   1808: aload 11
      //   1810: astore 16
      //   1812: aload 12
      //   1814: aload_0
      //   1815: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1818: putfield 356	android/os/Message:obj	Ljava/lang/Object;
      //   1821: aload 8
      //   1823: astore 15
      //   1825: aload 9
      //   1827: astore 14
      //   1829: aload 10
      //   1831: astore 13
      //   1833: aload 11
      //   1835: astore 16
      //   1837: aload 12
      //   1839: aload_0
      //   1840: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1843: getfield 359	com/tencent/mm/model/ag$c:pos	I
      //   1846: putfield 362	android/os/Message:arg1	I
      //   1849: aload 8
      //   1851: astore 15
      //   1853: aload 9
      //   1855: astore 14
      //   1857: aload 10
      //   1859: astore 13
      //   1861: aload 11
      //   1863: astore 16
      //   1865: aload_0
      //   1866: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   1869: getfield 366	com/tencent/mm/model/ag:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   1872: aload 12
      //   1874: invokevirtual 372	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
      //   1877: pop
      //   1878: aload 8
      //   1880: astore 15
      //   1882: aload 9
      //   1884: astore 14
      //   1886: aload 10
      //   1888: astore 13
      //   1890: aload 11
      //   1892: astore 16
      //   1894: invokestatic 138	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   1897: lload 4
      //   1899: lsub
      //   1900: lstore 4
      //   1902: aload 8
      //   1904: astore 15
      //   1906: aload 9
      //   1908: astore 14
      //   1910: aload 10
      //   1912: astore 13
      //   1914: aload 11
      //   1916: astore 16
      //   1918: ldc 99
      //   1920: ldc_w 374
      //   1923: iconst_1
      //   1924: anewarray 4	java/lang/Object
      //   1927: dup
      //   1928: iconst_0
      //   1929: lload 4
      //   1931: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1934: aastore
      //   1935: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1938: aload 8
      //   1940: astore 15
      //   1942: aload 9
      //   1944: astore 14
      //   1946: aload 10
      //   1948: astore 13
      //   1950: aload 11
      //   1952: astore 16
      //   1954: aload_0
      //   1955: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   1958: ldc2_w 380
      //   1961: lload 4
      //   1963: invokestatic 134	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1966: aload 8
      //   1968: astore 15
      //   1970: aload 9
      //   1972: astore 14
      //   1974: aload 10
      //   1976: astore 13
      //   1978: aload 11
      //   1980: astore 16
      //   1982: aload_0
      //   1983: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   1986: ifnull +57 -> 2043
      //   1989: aload 8
      //   1991: astore 15
      //   1993: aload 9
      //   1995: astore 14
      //   1997: aload 10
      //   1999: astore 13
      //   2001: aload 11
      //   2003: astore 16
      //   2005: aload_0
      //   2006: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2009: getfield 347	com/tencent/mm/model/ag$c:okJ	Z
      //   2012: ifeq +31 -> 2043
      //   2015: aload 8
      //   2017: astore 15
      //   2019: aload 9
      //   2021: astore 14
      //   2023: aload 10
      //   2025: astore 13
      //   2027: aload 11
      //   2029: astore 16
      //   2031: aload_0
      //   2032: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   2035: ldc2_w 382
      //   2038: lload 4
      //   2040: invokestatic 134	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   2043: aload 10
      //   2045: ifnull +8 -> 2053
      //   2048: aload 10
      //   2050: invokevirtual 299	java/io/OutputStream:close	()V
      //   2053: aload 9
      //   2055: ifnull +8 -> 2063
      //   2058: aload 9
      //   2060: invokevirtual 300	java/io/InputStream:close	()V
      //   2063: aload 11
      //   2065: ifnull +10 -> 2075
      //   2068: aload 11
      //   2070: invokeinterface 303 1 0
      //   2075: aload 8
      //   2077: ifnull +8 -> 2085
      //   2080: aload 8
      //   2082: invokevirtual 197	com/tencent/mm/network/ab:disconnect	()V
      //   2085: iconst_0
      //   2086: istore_1
      //   2087: goto -2075 -> 12
      //   2090: aload 22
      //   2092: astore 9
      //   2094: aload 20
      //   2096: astore 10
      //   2098: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   2101: ldc2_w 177
      //   2104: ldc2_w 384
      //   2107: lconst_1
      //   2108: iconst_0
      //   2109: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2112: aload 22
      //   2114: astore 9
      //   2116: aload 20
      //   2118: astore 10
      //   2120: aload_0
      //   2121: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2124: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2127: invokestatic 389	com/tencent/mm/network/d:Rt	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
      //   2130: astore 19
      //   2132: aload 19
      //   2134: ifnonnull +24 -> 2158
      //   2137: aload 22
      //   2139: astore 9
      //   2141: aload 20
      //   2143: astore 10
      //   2145: ldc 99
      //   2147: ldc 192
      //   2149: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   2152: ldc 58
      //   2154: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2157: return
      //   2158: aload 22
      //   2160: astore 9
      //   2162: aload 20
      //   2164: astore 10
      //   2166: aload 19
      //   2168: sipush 1222
      //   2171: putfield 394	com/tencent/mm/network/aa:pps	I
      //   2174: aload 22
      //   2176: astore 9
      //   2178: aload 20
      //   2180: astore 10
      //   2182: invokestatic 203	com/tencent/mm/modelimage/u:bKj	()Z
      //   2185: ifeq +79 -> 2264
      //   2188: aload 22
      //   2190: astore 9
      //   2192: aload 20
      //   2194: astore 10
      //   2196: aload_0
      //   2197: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2200: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2203: invokestatic 206	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
      //   2206: ifeq +58 -> 2264
      //   2209: aload 22
      //   2211: astore 9
      //   2213: aload 20
      //   2215: astore 10
      //   2217: getstatic 211	com/tencent/mm/protocal/d:Yxh	I
      //   2220: invokestatic 215	com/tencent/mm/modelimage/u:wy	(I)Ljava/lang/String;
      //   2223: astore 8
      //   2225: aload 22
      //   2227: astore 9
      //   2229: aload 20
      //   2231: astore 10
      //   2233: ldc 99
      //   2235: ldc 217
      //   2237: iconst_1
      //   2238: anewarray 4	java/lang/Object
      //   2241: dup
      //   2242: iconst_0
      //   2243: aload 8
      //   2245: aastore
      //   2246: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2249: aload 22
      //   2251: astore 9
      //   2253: aload 20
      //   2255: astore 10
      //   2257: aload 19
      //   2259: aload 8
      //   2261: invokevirtual 395	com/tencent/mm/network/aa:Ry	(Ljava/lang/String;)V
      //   2264: aload 22
      //   2266: astore 9
      //   2268: aload 20
      //   2270: astore 10
      //   2272: aload_0
      //   2273: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   2276: getfield 44	com/tencent/mm/model/ag:oky	Z
      //   2279: ifeq +73 -> 2352
      //   2282: aload 22
      //   2284: astore 9
      //   2286: aload 20
      //   2288: astore 10
      //   2290: aload_0
      //   2291: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   2294: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   2297: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   2300: ifne +52 -> 2352
      //   2303: aload 22
      //   2305: astore 9
      //   2307: aload 20
      //   2309: astore 10
      //   2311: ldc 99
      //   2313: ldc 225
      //   2315: iconst_1
      //   2316: anewarray 4	java/lang/Object
      //   2319: dup
      //   2320: iconst_0
      //   2321: aload_0
      //   2322: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   2325: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   2328: aastore
      //   2329: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2332: aload 22
      //   2334: astore 9
      //   2336: aload 20
      //   2338: astore 10
      //   2340: aload 19
      //   2342: aload_0
      //   2343: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   2346: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   2349: invokevirtual 395	com/tencent/mm/network/aa:Ry	(Ljava/lang/String;)V
      //   2352: aload 22
      //   2354: astore 9
      //   2356: aload 20
      //   2358: astore 10
      //   2360: ldc 99
      //   2362: ldc 227
      //   2364: iconst_2
      //   2365: anewarray 4	java/lang/Object
      //   2368: dup
      //   2369: iconst_0
      //   2370: aload_0
      //   2371: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2374: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   2377: aastore
      //   2378: dup
      //   2379: iconst_1
      //   2380: aload_0
      //   2381: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2384: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2387: aastore
      //   2388: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2391: aload 22
      //   2393: astore 9
      //   2395: aload 20
      //   2397: astore 10
      //   2399: aload_0
      //   2400: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2403: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   2406: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   2409: ifne +25 -> 2434
      //   2412: aload 22
      //   2414: astore 9
      //   2416: aload 20
      //   2418: astore 10
      //   2420: aload 19
      //   2422: ldc 238
      //   2424: aload_0
      //   2425: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2428: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   2431: invokevirtual 396	com/tencent/mm/network/aa:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   2434: aload 22
      //   2436: astore 9
      //   2438: aload 20
      //   2440: astore 10
      //   2442: aload 19
      //   2444: iconst_1
      //   2445: putfield 399	com/tencent/mm/network/aa:ppi	Z
      //   2448: aload 22
      //   2450: astore 9
      //   2452: aload 20
      //   2454: astore 10
      //   2456: aload 19
      //   2458: sipush 3000
      //   2461: putfield 402	com/tencent/mm/network/aa:ppc	I
      //   2464: aload 22
      //   2466: astore 9
      //   2468: aload 20
      //   2470: astore 10
      //   2472: aload 19
      //   2474: sipush 3000
      //   2477: putfield 405	com/tencent/mm/network/aa:ppd	I
      //   2480: aload 22
      //   2482: astore 9
      //   2484: aload 20
      //   2486: astore 10
      //   2488: aload 19
      //   2490: invokevirtual 406	com/tencent/mm/network/aa:getResponseCode	()I
      //   2493: istore_1
      //   2494: aload 22
      //   2496: astore 9
      //   2498: aload 20
      //   2500: astore 10
      //   2502: aload_0
      //   2503: iload_1
      //   2504: invokespecial 258	com/tencent/mm/model/ag$a:uZ	(I)Z
      //   2507: ifeq +265 -> 2772
      //   2510: aload 22
      //   2512: astore 9
      //   2514: aload 20
      //   2516: astore 10
      //   2518: aload_0
      //   2519: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2522: aload 19
      //   2524: ldc_w 260
      //   2527: invokevirtual 407	com/tencent/mm/network/aa:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   2530: putfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2533: aload 22
      //   2535: astore 9
      //   2537: aload 20
      //   2539: astore 10
      //   2541: aload_0
      //   2542: aload_0
      //   2543: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   2546: iconst_1
      //   2547: iadd
      //   2548: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   2551: aload 22
      //   2553: astore 9
      //   2555: aload 20
      //   2557: astore 10
      //   2559: aload_0
      //   2560: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   2563: bipush 15
      //   2565: if_icmpge +21 -> 2586
      //   2568: aload 22
      //   2570: astore 9
      //   2572: aload 20
      //   2574: astore 10
      //   2576: aload_0
      //   2577: iconst_0
      //   2578: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   2581: iconst_0
      //   2582: istore_1
      //   2583: goto -2571 -> 12
      //   2586: aload 22
      //   2588: astore 9
      //   2590: aload 20
      //   2592: astore 10
      //   2594: aload_0
      //   2595: iconst_1
      //   2596: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   2599: aload 22
      //   2601: astore 9
      //   2603: aload 20
      //   2605: astore 10
      //   2607: aload_0
      //   2608: iconst_0
      //   2609: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   2612: aconst_null
      //   2613: astore 8
      //   2615: aload 11
      //   2617: astore 14
      //   2619: aload 18
      //   2621: astore 13
      //   2623: aload 8
      //   2625: astore 10
      //   2627: sipush 1024
      //   2630: newarray byte
      //   2632: astore 20
      //   2634: aload 11
      //   2636: astore 14
      //   2638: aload 18
      //   2640: astore 13
      //   2642: aload 8
      //   2644: astore 10
      //   2646: new 101	java/lang/StringBuilder
      //   2649: dup
      //   2650: invokespecial 265	java/lang/StringBuilder:<init>	()V
      //   2653: aload_0
      //   2654: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2657: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   2660: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2663: ldc_w 267
      //   2666: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2669: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2672: iconst_0
      //   2673: invokestatic 271	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   2676: astore 9
      //   2678: aload 17
      //   2680: astore 14
      //   2682: aload 16
      //   2684: astore 13
      //   2686: aload 8
      //   2688: astore 12
      //   2690: aload 9
      //   2692: astore 11
      //   2694: aload 8
      //   2696: aload 20
      //   2698: invokevirtual 277	java/io/InputStream:read	([B)I
      //   2701: istore_2
      //   2702: iload_2
      //   2703: iconst_m1
      //   2704: if_icmpeq +107 -> 2811
      //   2707: aload 17
      //   2709: astore 14
      //   2711: aload 16
      //   2713: astore 13
      //   2715: aload 8
      //   2717: astore 12
      //   2719: aload 9
      //   2721: astore 11
      //   2723: aload 9
      //   2725: aload 20
      //   2727: iconst_0
      //   2728: iload_2
      //   2729: invokevirtual 283	java/io/OutputStream:write	([BII)V
      //   2732: goto -54 -> 2678
      //   2735: astore 12
      //   2737: aconst_null
      //   2738: astore 13
      //   2740: aconst_null
      //   2741: astore 14
      //   2743: aload 8
      //   2745: astore 10
      //   2747: aload 9
      //   2749: astore 11
      //   2751: iconst_0
      //   2752: istore_1
      //   2753: aload 14
      //   2755: astore 8
      //   2757: aload 10
      //   2759: astore 9
      //   2761: aload 11
      //   2763: astore 10
      //   2765: aload 13
      //   2767: astore 11
      //   2769: goto -1666 -> 1103
      //   2772: aload 22
      //   2774: astore 9
      //   2776: aload 20
      //   2778: astore 10
      //   2780: aload 19
      //   2782: invokevirtual 408	com/tencent/mm/network/aa:getInputStream	()Ljava/io/InputStream;
      //   2785: astore 8
      //   2787: aload 8
      //   2789: astore 9
      //   2791: aload 9
      //   2793: astore 10
      //   2795: aload 21
      //   2797: astore 13
      //   2799: aload_0
      //   2800: iconst_0
      //   2801: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   2804: aload 9
      //   2806: astore 8
      //   2808: goto -193 -> 2615
      //   2811: aload 17
      //   2813: astore 14
      //   2815: aload 16
      //   2817: astore 13
      //   2819: aload 8
      //   2821: astore 12
      //   2823: aload 9
      //   2825: astore 11
      //   2827: new 309	com/tencent/mm/vfs/u
      //   2830: dup
      //   2831: new 101	java/lang/StringBuilder
      //   2834: dup
      //   2835: invokespecial 265	java/lang/StringBuilder:<init>	()V
      //   2838: aload_0
      //   2839: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2842: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   2845: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2848: ldc_w 267
      //   2851: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2854: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2857: invokespecial 310	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   2860: new 309	com/tencent/mm/vfs/u
      //   2863: dup
      //   2864: aload_0
      //   2865: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   2868: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   2871: invokespecial 310	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   2874: invokevirtual 314	com/tencent/mm/vfs/u:am	(Lcom/tencent/mm/vfs/u;)Z
      //   2877: pop
      //   2878: aload 17
      //   2880: astore 14
      //   2882: aload 16
      //   2884: astore 13
      //   2886: aload 8
      //   2888: astore 12
      //   2890: aload 9
      //   2892: astore 11
      //   2894: aload 19
      //   2896: ldc_w 410
      //   2899: invokevirtual 407	com/tencent/mm/network/aa:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   2902: astore 18
      //   2904: iload_1
      //   2905: sipush 200
      //   2908: if_icmpne +120 -> 3028
      //   2911: aload 17
      //   2913: astore 14
      //   2915: aload 16
      //   2917: astore 13
      //   2919: aload 8
      //   2921: astore 12
      //   2923: aload 9
      //   2925: astore 11
      //   2927: invokestatic 148	java/lang/System:currentTimeMillis	()J
      //   2930: lload 6
      //   2932: lsub
      //   2933: lstore 6
      //   2935: aload 17
      //   2937: astore 14
      //   2939: aload 16
      //   2941: astore 13
      //   2943: aload 8
      //   2945: astore 12
      //   2947: aload 9
      //   2949: astore 11
      //   2951: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   2954: ldc2_w 177
      //   2957: ldc2_w 411
      //   2960: lload 6
      //   2962: iconst_0
      //   2963: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2966: aload 17
      //   2968: astore 14
      //   2970: aload 16
      //   2972: astore 13
      //   2974: aload 8
      //   2976: astore 12
      //   2978: aload 9
      //   2980: astore 11
      //   2982: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   2985: ldc2_w 177
      //   2988: ldc2_w 413
      //   2991: lconst_1
      //   2992: iconst_0
      //   2993: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2996: aload 17
      //   2998: astore 14
      //   3000: aload 16
      //   3002: astore 13
      //   3004: aload 8
      //   3006: astore 12
      //   3008: aload 9
      //   3010: astore 11
      //   3012: ldc 99
      //   3014: ldc_w 416
      //   3017: lload 6
      //   3019: invokestatic 329	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   3022: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   3025: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   3028: aconst_null
      //   3029: astore 13
      //   3031: aload 8
      //   3033: astore 10
      //   3035: aload 9
      //   3037: astore 11
      //   3039: aload 18
      //   3041: astore 12
      //   3043: aload 13
      //   3045: astore 8
      //   3047: aload 10
      //   3049: astore 9
      //   3051: aload 11
      //   3053: astore 10
      //   3055: goto -1481 -> 1574
      //   3058: aload 22
      //   3060: astore 9
      //   3062: aload 20
      //   3064: astore 10
      //   3066: ldc 155
      //   3068: invokestatic 161	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   3071: checkcast 155	com/tencent/mm/plugin/expt/b/c
      //   3074: getstatic 167	com/tencent/mm/plugin/expt/b/c$a:zmZ	Lcom/tencent/mm/plugin/expt/b/c$a;
      //   3077: iconst_0
      //   3078: invokeinterface 170 3 0
      //   3083: istore_3
      //   3084: iload_3
      //   3085: ifeq +95 -> 3180
      //   3088: aload 22
      //   3090: astore 9
      //   3092: aload 20
      //   3094: astore 10
      //   3096: aload_0
      //   3097: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3100: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3103: invokestatic 389	com/tencent/mm/network/d:Rt	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
      //   3106: astore 8
      //   3108: aload 8
      //   3110: astore 11
      //   3112: aload 8
      //   3114: checkcast 391	com/tencent/mm/network/aa
      //   3117: sipush 1222
      //   3120: putfield 394	com/tencent/mm/network/aa:pps	I
      //   3123: aload 8
      //   3125: astore 11
      //   3127: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   3130: ldc2_w 177
      //   3133: ldc2_w 417
      //   3136: lconst_1
      //   3137: iconst_0
      //   3138: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3141: aload 8
      //   3143: ifnonnull +87 -> 3230
      //   3146: aload 8
      //   3148: astore 9
      //   3150: aload 20
      //   3152: astore 10
      //   3154: ldc 99
      //   3156: ldc_w 420
      //   3159: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   3162: aload 8
      //   3164: ifnull +10 -> 3174
      //   3167: aload 8
      //   3169: invokeinterface 303 1 0
      //   3174: ldc 58
      //   3176: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   3179: return
      //   3180: aload 22
      //   3182: astore 9
      //   3184: aload 20
      //   3186: astore 10
      //   3188: aload_0
      //   3189: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3192: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3195: aconst_null
      //   3196: invokestatic 423	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
      //   3199: astore 8
      //   3201: aload 8
      //   3203: astore 11
      //   3205: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   3208: ldc2_w 177
      //   3211: ldc2_w 424
      //   3214: lconst_1
      //   3215: iconst_0
      //   3216: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3219: goto -78 -> 3141
      //   3222: astore 8
      //   3224: ldc 58
      //   3226: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   3229: return
      //   3230: aload 8
      //   3232: astore 9
      //   3234: aload 20
      //   3236: astore 10
      //   3238: invokestatic 203	com/tencent/mm/modelimage/u:bKj	()Z
      //   3241: ifeq +81 -> 3322
      //   3244: aload 8
      //   3246: astore 9
      //   3248: aload 20
      //   3250: astore 10
      //   3252: aload_0
      //   3253: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3256: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3259: invokestatic 206	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
      //   3262: ifeq +60 -> 3322
      //   3265: aload 8
      //   3267: astore 9
      //   3269: aload 20
      //   3271: astore 10
      //   3273: getstatic 211	com/tencent/mm/protocal/d:Yxh	I
      //   3276: invokestatic 215	com/tencent/mm/modelimage/u:wy	(I)Ljava/lang/String;
      //   3279: astore 11
      //   3281: aload 8
      //   3283: astore 9
      //   3285: aload 20
      //   3287: astore 10
      //   3289: ldc 99
      //   3291: ldc 217
      //   3293: iconst_1
      //   3294: anewarray 4	java/lang/Object
      //   3297: dup
      //   3298: iconst_0
      //   3299: aload 11
      //   3301: aastore
      //   3302: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3305: aload 8
      //   3307: astore 9
      //   3309: aload 20
      //   3311: astore 10
      //   3313: aload 8
      //   3315: aload 11
      //   3317: invokeinterface 426 2 0
      //   3322: aload 8
      //   3324: astore 9
      //   3326: aload 20
      //   3328: astore 10
      //   3330: aload_0
      //   3331: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   3334: getfield 44	com/tencent/mm/model/ag:oky	Z
      //   3337: ifeq +75 -> 3412
      //   3340: aload 8
      //   3342: astore 9
      //   3344: aload 20
      //   3346: astore 10
      //   3348: aload_0
      //   3349: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   3352: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   3355: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   3358: ifne +54 -> 3412
      //   3361: aload 8
      //   3363: astore 9
      //   3365: aload 20
      //   3367: astore 10
      //   3369: ldc 99
      //   3371: ldc 225
      //   3373: iconst_1
      //   3374: anewarray 4	java/lang/Object
      //   3377: dup
      //   3378: iconst_0
      //   3379: aload_0
      //   3380: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   3383: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   3386: aastore
      //   3387: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3390: aload 8
      //   3392: astore 9
      //   3394: aload 20
      //   3396: astore 10
      //   3398: aload 8
      //   3400: aload_0
      //   3401: getfield 27	com/tencent/mm/model/ag$a:okC	Lcom/tencent/mm/model/ag;
      //   3404: getfield 223	com/tencent/mm/model/ag:okz	Ljava/lang/String;
      //   3407: invokeinterface 426 2 0
      //   3412: aload 8
      //   3414: astore 9
      //   3416: aload 20
      //   3418: astore 10
      //   3420: ldc 99
      //   3422: ldc 227
      //   3424: iconst_2
      //   3425: anewarray 4	java/lang/Object
      //   3428: dup
      //   3429: iconst_0
      //   3430: aload_0
      //   3431: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3434: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   3437: aastore
      //   3438: dup
      //   3439: iconst_1
      //   3440: aload_0
      //   3441: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3444: getfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3447: aastore
      //   3448: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3451: aload 8
      //   3453: astore 9
      //   3455: aload 20
      //   3457: astore 10
      //   3459: aload_0
      //   3460: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3463: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   3466: invokestatic 97	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   3469: ifne +27 -> 3496
      //   3472: aload 8
      //   3474: astore 9
      //   3476: aload 20
      //   3478: astore 10
      //   3480: aload 8
      //   3482: ldc 238
      //   3484: aload_0
      //   3485: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3488: getfield 230	com/tencent/mm/model/ag$c:okK	Ljava/lang/String;
      //   3491: invokeinterface 427 3 0
      //   3496: aload 8
      //   3498: astore 9
      //   3500: aload 20
      //   3502: astore 10
      //   3504: aload 8
      //   3506: iconst_1
      //   3507: invokeinterface 431 2 0
      //   3512: aload 8
      //   3514: astore 9
      //   3516: aload 20
      //   3518: astore 10
      //   3520: aload 8
      //   3522: sipush 3000
      //   3525: invokeinterface 432 2 0
      //   3530: aload 8
      //   3532: astore 9
      //   3534: aload 20
      //   3536: astore 10
      //   3538: aload 8
      //   3540: sipush 3000
      //   3543: invokeinterface 433 2 0
      //   3548: aload 8
      //   3550: astore 9
      //   3552: aload 20
      //   3554: astore 10
      //   3556: aload 8
      //   3558: invokeinterface 434 1 0
      //   3563: istore_1
      //   3564: aload 8
      //   3566: astore 9
      //   3568: aload 20
      //   3570: astore 10
      //   3572: aload_0
      //   3573: iload_1
      //   3574: invokespecial 258	com/tencent/mm/model/ag$a:uZ	(I)Z
      //   3577: ifeq +267 -> 3844
      //   3580: aload 8
      //   3582: astore 9
      //   3584: aload 20
      //   3586: astore 10
      //   3588: aload_0
      //   3589: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3592: aload 8
      //   3594: ldc_w 260
      //   3597: invokeinterface 435 2 0
      //   3602: putfield 91	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3605: aload 8
      //   3607: astore 9
      //   3609: aload 20
      //   3611: astore 10
      //   3613: aload_0
      //   3614: aload_0
      //   3615: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   3618: iconst_1
      //   3619: iadd
      //   3620: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   3623: aload 8
      //   3625: astore 9
      //   3627: aload 20
      //   3629: astore 10
      //   3631: aload_0
      //   3632: getfield 38	com/tencent/mm/model/ag$a:okI	I
      //   3635: bipush 15
      //   3637: if_icmpge +40 -> 3677
      //   3640: aload 8
      //   3642: astore 9
      //   3644: aload 20
      //   3646: astore 10
      //   3648: aload_0
      //   3649: iconst_0
      //   3650: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   3653: aload 8
      //   3655: ifnull +10 -> 3665
      //   3658: aload 8
      //   3660: invokeinterface 303 1 0
      //   3665: iconst_0
      //   3666: istore_1
      //   3667: goto -3655 -> 12
      //   3670: astore 8
      //   3672: iconst_0
      //   3673: istore_1
      //   3674: goto -3662 -> 12
      //   3677: aload 8
      //   3679: astore 9
      //   3681: aload 20
      //   3683: astore 10
      //   3685: aload_0
      //   3686: iconst_1
      //   3687: putfield 32	com/tencent/mm/model/ag$a:okF	Z
      //   3690: aload 8
      //   3692: astore 9
      //   3694: aload 20
      //   3696: astore 10
      //   3698: aload_0
      //   3699: iconst_0
      //   3700: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   3703: aconst_null
      //   3704: astore 9
      //   3706: aload 8
      //   3708: astore 14
      //   3710: aload 18
      //   3712: astore 13
      //   3714: aload 9
      //   3716: astore 10
      //   3718: sipush 1024
      //   3721: newarray byte
      //   3723: astore 15
      //   3725: aload 8
      //   3727: astore 14
      //   3729: aload 18
      //   3731: astore 13
      //   3733: aload 9
      //   3735: astore 10
      //   3737: new 101	java/lang/StringBuilder
      //   3740: dup
      //   3741: invokespecial 265	java/lang/StringBuilder:<init>	()V
      //   3744: aload_0
      //   3745: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3748: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   3751: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3754: ldc_w 267
      //   3757: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3760: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3763: iconst_0
      //   3764: invokestatic 271	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   3767: astore 11
      //   3769: aload 11
      //   3771: astore 10
      //   3773: aload 8
      //   3775: astore 14
      //   3777: aload 16
      //   3779: astore 13
      //   3781: aload 9
      //   3783: astore 12
      //   3785: aload 10
      //   3787: astore 11
      //   3789: aload 9
      //   3791: aload 15
      //   3793: invokevirtual 277	java/io/InputStream:read	([B)I
      //   3796: istore_2
      //   3797: iload_2
      //   3798: iconst_m1
      //   3799: if_icmpeq +82 -> 3881
      //   3802: aload 8
      //   3804: astore 14
      //   3806: aload 16
      //   3808: astore 13
      //   3810: aload 9
      //   3812: astore 12
      //   3814: aload 10
      //   3816: astore 11
      //   3818: aload 10
      //   3820: aload 15
      //   3822: iconst_0
      //   3823: iload_2
      //   3824: invokevirtual 283	java/io/OutputStream:write	([BII)V
      //   3827: goto -54 -> 3773
      //   3830: astore 12
      //   3832: aload 8
      //   3834: astore 11
      //   3836: aconst_null
      //   3837: astore 8
      //   3839: iconst_0
      //   3840: istore_1
      //   3841: goto -2738 -> 1103
      //   3844: aload 8
      //   3846: astore 9
      //   3848: aload 20
      //   3850: astore 10
      //   3852: aload 8
      //   3854: invokeinterface 436 1 0
      //   3859: astore 11
      //   3861: aload 11
      //   3863: astore 9
      //   3865: aload 9
      //   3867: astore 10
      //   3869: aload 8
      //   3871: astore 13
      //   3873: aload_0
      //   3874: iconst_0
      //   3875: putfield 38	com/tencent/mm/model/ag$a:okI	I
      //   3878: goto -172 -> 3706
      //   3881: aload 8
      //   3883: astore 14
      //   3885: aload 16
      //   3887: astore 13
      //   3889: aload 9
      //   3891: astore 12
      //   3893: aload 10
      //   3895: astore 11
      //   3897: new 309	com/tencent/mm/vfs/u
      //   3900: dup
      //   3901: new 101	java/lang/StringBuilder
      //   3904: dup
      //   3905: invokespecial 265	java/lang/StringBuilder:<init>	()V
      //   3908: aload_0
      //   3909: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3912: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   3915: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3918: ldc_w 267
      //   3921: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3924: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3927: invokespecial 310	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   3930: new 309	com/tencent/mm/vfs/u
      //   3933: dup
      //   3934: aload_0
      //   3935: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   3938: getfield 115	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   3941: invokespecial 310	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   3944: invokevirtual 314	com/tencent/mm/vfs/u:am	(Lcom/tencent/mm/vfs/u;)Z
      //   3947: pop
      //   3948: aload 8
      //   3950: astore 14
      //   3952: aload 16
      //   3954: astore 13
      //   3956: aload 9
      //   3958: astore 12
      //   3960: aload 10
      //   3962: astore 11
      //   3964: aload 8
      //   3966: invokeinterface 439 1 0
      //   3971: astore 15
      //   3973: aload 8
      //   3975: astore 14
      //   3977: aload 16
      //   3979: astore 13
      //   3981: aload 9
      //   3983: astore 12
      //   3985: aload 10
      //   3987: astore 11
      //   3989: ldc 99
      //   3991: ldc_w 336
      //   3994: iconst_1
      //   3995: anewarray 4	java/lang/Object
      //   3998: dup
      //   3999: iconst_0
      //   4000: aload 15
      //   4002: aastore
      //   4003: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4006: iload_1
      //   4007: sipush 200
      //   4010: if_icmpne +231 -> 4241
      //   4013: aload 8
      //   4015: astore 14
      //   4017: aload 16
      //   4019: astore 13
      //   4021: aload 9
      //   4023: astore 12
      //   4025: aload 10
      //   4027: astore 11
      //   4029: invokestatic 148	java/lang/System:currentTimeMillis	()J
      //   4032: lload 6
      //   4034: lsub
      //   4035: lstore 6
      //   4037: iload_3
      //   4038: ifeq +110 -> 4148
      //   4041: aload 8
      //   4043: astore 14
      //   4045: aload 16
      //   4047: astore 13
      //   4049: aload 9
      //   4051: astore 12
      //   4053: aload 10
      //   4055: astore 11
      //   4057: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   4060: ldc2_w 177
      //   4063: ldc2_w 440
      //   4066: lload 6
      //   4068: iconst_0
      //   4069: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   4072: aload 8
      //   4074: astore 14
      //   4076: aload 16
      //   4078: astore 13
      //   4080: aload 9
      //   4082: astore 12
      //   4084: aload 10
      //   4086: astore 11
      //   4088: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   4091: ldc2_w 177
      //   4094: ldc2_w 442
      //   4097: lconst_1
      //   4098: iconst_0
      //   4099: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   4102: aload 8
      //   4104: astore 14
      //   4106: aload 16
      //   4108: astore 13
      //   4110: aload 9
      //   4112: astore 12
      //   4114: aload 10
      //   4116: astore 11
      //   4118: ldc 99
      //   4120: ldc_w 445
      //   4123: lload 6
      //   4125: invokestatic 329	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   4128: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   4131: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   4134: aload 8
      //   4136: astore 11
      //   4138: aconst_null
      //   4139: astore 8
      //   4141: aload 15
      //   4143: astore 12
      //   4145: goto -2551 -> 1594
      //   4148: aload 8
      //   4150: astore 14
      //   4152: aload 16
      //   4154: astore 13
      //   4156: aload 9
      //   4158: astore 12
      //   4160: aload 10
      //   4162: astore 11
      //   4164: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   4167: ldc2_w 177
      //   4170: ldc2_w 446
      //   4173: lload 6
      //   4175: iconst_0
      //   4176: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   4179: aload 8
      //   4181: astore 14
      //   4183: aload 16
      //   4185: astore 13
      //   4187: aload 9
      //   4189: astore 12
      //   4191: aload 10
      //   4193: astore 11
      //   4195: getstatic 176	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   4198: ldc2_w 177
      //   4201: ldc2_w 448
      //   4204: lconst_1
      //   4205: iconst_0
      //   4206: invokevirtual 184	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   4209: aload 8
      //   4211: astore 14
      //   4213: aload 16
      //   4215: astore 13
      //   4217: aload 9
      //   4219: astore 12
      //   4221: aload 10
      //   4223: astore 11
      //   4225: ldc 99
      //   4227: ldc_w 451
      //   4230: lload 6
      //   4232: invokestatic 329	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   4235: invokevirtual 332	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   4238: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   4241: aload 8
      //   4243: astore 11
      //   4245: aconst_null
      //   4246: astore 8
      //   4248: aload 15
      //   4250: astore 12
      //   4252: goto -2658 -> 1594
      //   4255: aload 8
      //   4257: astore 15
      //   4259: aload 9
      //   4261: astore 14
      //   4263: aload 10
      //   4265: astore 13
      //   4267: aload 11
      //   4269: astore 16
      //   4271: aload_0
      //   4272: getfield 34	com/tencent/mm/model/ag$a:okG	Lcom/tencent/mm/model/ag$c;
      //   4275: iconst_0
      //   4276: putfield 347	com/tencent/mm/model/ag$c:okJ	Z
      //   4279: goto -2508 -> 1771
      //   4282: astore 12
      //   4284: iconst_0
      //   4285: istore_1
      //   4286: goto -3183 -> 1103
      //   4289: astore 8
      //   4291: iconst_0
      //   4292: istore_1
      //   4293: goto -4281 -> 12
      //   4296: astore 8
      //   4298: goto -4286 -> 12
      //   4301: astore 8
      //   4303: aload 13
      //   4305: astore 11
      //   4307: aload 12
      //   4309: ifnull +8 -> 4317
      //   4312: aload 12
      //   4314: invokevirtual 299	java/io/OutputStream:close	()V
      //   4317: aload 11
      //   4319: ifnull +8 -> 4327
      //   4322: aload 11
      //   4324: invokevirtual 300	java/io/InputStream:close	()V
      //   4327: aload 9
      //   4329: ifnull +10 -> 4339
      //   4332: aload 9
      //   4334: invokeinterface 303 1 0
      //   4339: aload 10
      //   4341: ifnull +8 -> 4349
      //   4344: aload 10
      //   4346: invokevirtual 197	com/tencent/mm/network/ab:disconnect	()V
      //   4349: ldc 58
      //   4351: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   4354: aload 8
      //   4356: athrow
      //   4357: ldc 58
      //   4359: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   4362: return
      //   4363: astore 9
      //   4365: goto -16 -> 4349
      //   4368: astore 8
      //   4370: aload 10
      //   4372: astore 11
      //   4374: aload 13
      //   4376: astore 9
      //   4378: aload 14
      //   4380: astore 10
      //   4382: goto -75 -> 4307
      //   4385: astore 8
      //   4387: aload 10
      //   4389: astore 11
      //   4391: aload 14
      //   4393: astore 9
      //   4395: aload 13
      //   4397: astore 10
      //   4399: goto -92 -> 4307
      //   4402: astore 8
      //   4404: aload 11
      //   4406: astore 9
      //   4408: aload 12
      //   4410: astore 11
      //   4412: aload 9
      //   4414: astore 12
      //   4416: aload 14
      //   4418: astore 9
      //   4420: aload 13
      //   4422: astore 10
      //   4424: goto -117 -> 4307
      //   4427: astore 11
      //   4429: aload 8
      //   4431: astore 13
      //   4433: aload 11
      //   4435: astore 8
      //   4437: aload 9
      //   4439: astore 11
      //   4441: aload 10
      //   4443: astore 12
      //   4445: aload 15
      //   4447: astore 9
      //   4449: aload 13
      //   4451: astore 10
      //   4453: goto -146 -> 4307
      //   4456: astore 10
      //   4458: aload 8
      //   4460: astore 9
      //   4462: aload 10
      //   4464: astore 8
      //   4466: aload 13
      //   4468: astore 11
      //   4470: aload 19
      //   4472: astore 10
      //   4474: goto -167 -> 4307
      //   4477: astore 10
      //   4479: aload 8
      //   4481: astore 9
      //   4483: aload 10
      //   4485: astore 8
      //   4487: aload 13
      //   4489: astore 11
      //   4491: aload 19
      //   4493: astore 10
      //   4495: goto -188 -> 4307
      //   4498: astore 8
      //   4500: aload 16
      //   4502: astore 9
      //   4504: aload 15
      //   4506: astore 10
      //   4508: aload 14
      //   4510: astore 11
      //   4512: aload 13
      //   4514: astore 12
      //   4516: goto -209 -> 4307
      //   4519: astore 12
      //   4521: aconst_null
      //   4522: astore 11
      //   4524: aconst_null
      //   4525: astore 8
      //   4527: aconst_null
      //   4528: astore 9
      //   4530: aconst_null
      //   4531: astore 10
      //   4533: goto -3430 -> 1103
      //   4536: astore 12
      //   4538: aconst_null
      //   4539: astore 11
      //   4541: aconst_null
      //   4542: astore 8
      //   4544: aconst_null
      //   4545: astore 9
      //   4547: aconst_null
      //   4548: astore 10
      //   4550: iconst_0
      //   4551: istore_1
      //   4552: goto -3449 -> 1103
      //   4555: astore 12
      //   4557: aconst_null
      //   4558: astore 11
      //   4560: aconst_null
      //   4561: astore 9
      //   4563: aconst_null
      //   4564: astore 10
      //   4566: iconst_0
      //   4567: istore_1
      //   4568: goto -3465 -> 1103
      //   4571: astore 12
      //   4573: aconst_null
      //   4574: astore 11
      //   4576: aconst_null
      //   4577: astore 10
      //   4579: iconst_0
      //   4580: istore_1
      //   4581: goto -3478 -> 1103
      //   4584: astore 12
      //   4586: aconst_null
      //   4587: astore 11
      //   4589: aconst_null
      //   4590: astore 10
      //   4592: iconst_0
      //   4593: istore_1
      //   4594: goto -3491 -> 1103
      //   4597: astore 12
      //   4599: aconst_null
      //   4600: astore 11
      //   4602: aconst_null
      //   4603: astore 8
      //   4605: aconst_null
      //   4606: astore 10
      //   4608: iconst_0
      //   4609: istore_1
      //   4610: goto -3507 -> 1103
      //   4613: astore 12
      //   4615: aconst_null
      //   4616: astore 11
      //   4618: aconst_null
      //   4619: astore 13
      //   4621: aload 8
      //   4623: astore 9
      //   4625: aconst_null
      //   4626: astore 10
      //   4628: iconst_0
      //   4629: istore_1
      //   4630: aload 13
      //   4632: astore 8
      //   4634: goto -3531 -> 1103
      //   4637: astore 12
      //   4639: aconst_null
      //   4640: astore 11
      //   4642: iconst_0
      //   4643: istore_1
      //   4644: goto -3541 -> 1103
      //   4647: astore 12
      //   4649: aconst_null
      //   4650: astore 8
      //   4652: aconst_null
      //   4653: astore 9
      //   4655: aconst_null
      //   4656: astore 10
      //   4658: iconst_0
      //   4659: istore_1
      //   4660: goto -3557 -> 1103
      //   4663: astore 12
      //   4665: aload 8
      //   4667: astore 11
      //   4669: aconst_null
      //   4670: astore 8
      //   4672: aconst_null
      //   4673: astore 9
      //   4675: aconst_null
      //   4676: astore 10
      //   4678: iconst_0
      //   4679: istore_1
      //   4680: goto -3577 -> 1103
      //   4683: astore 12
      //   4685: aload 8
      //   4687: astore 11
      //   4689: aconst_null
      //   4690: astore 8
      //   4692: aconst_null
      //   4693: astore 10
      //   4695: iconst_0
      //   4696: istore_1
      //   4697: goto -3594 -> 1103
      //   4700: astore 12
      //   4702: aload 8
      //   4704: astore 11
      //   4706: aconst_null
      //   4707: astore 8
      //   4709: aconst_null
      //   4710: astore 10
      //   4712: iconst_0
      //   4713: istore_1
      //   4714: goto -3611 -> 1103
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	4717	0	this	a
      //   11	4703	1	i	int
      //   88	3736	2	j	int
      //   159	3879	3	bool	boolean
      //   315	1724	4	l1	long
      //   357	3874	6	l2	long
      //   448	28	8	localab	com.tencent.mm.network.ab
      //   486	441	8	localException1	Exception
      //   936	1145	8	localException2	Exception
      //   2223	979	8	localObject1	Object
      //   3222	437	8	localException3	Exception
      //   3670	163	8	localException4	Exception
      //   3837	419	8	localObject2	Object
      //   4289	1	8	localException5	Exception
      //   4296	1	8	localException6	Exception
      //   4301	54	8	localObject3	Object
      //   4368	1	8	localObject4	Object
      //   4385	1	8	localObject5	Object
      //   4402	28	8	localObject6	Object
      //   4435	51	8	localObject7	Object
      //   4498	1	8	localObject8	Object
      //   4525	183	8	localObject9	Object
      //   74	4259	9	localObject10	Object
      //   4363	1	9	localException7	Exception
      //   4376	298	9	localObject11	Object
      //   78	4374	10	localObject12	Object
      //   4456	7	10	localObject13	Object
      //   4472	1	10	localaa1	com.tencent.mm.network.aa
      //   4477	7	10	localObject14	Object
      //   4493	218	10	localObject15	Object
      //   64	4347	11	localObject16	Object
      //   4427	7	11	localObject17	Object
      //   4439	266	11	localObject18	Object
      //   37	1042	12	localObject19	Object
      //   1096	56	12	localException8	Exception
      //   1363	1355	12	localObject20	Object
      //   2735	1	12	localException9	Exception
      //   2821	992	12	localObject21	Object
      //   3830	1	12	localException10	Exception
      //   3891	360	12	localObject22	Object
      //   4282	127	12	localException11	Exception
      //   4414	101	12	localObject23	Object
      //   4519	1	12	localException12	Exception
      //   4536	1	12	localException13	Exception
      //   4555	1	12	localException14	Exception
      //   4571	1	12	localException15	Exception
      //   4584	1	12	localException16	Exception
      //   4597	1	12	localException17	Exception
      //   4613	1	12	localException18	Exception
      //   4637	1	12	localException19	Exception
      //   4647	1	12	localException20	Exception
      //   4663	1	12	localException21	Exception
      //   4683	1	12	localException22	Exception
      //   4700	1	12	localException23	Exception
      //   40	4591	13	localObject24	Object
      //   46	4463	14	localObject25	Object
      //   58	4447	15	localObject26	Object
      //   52	4449	16	localObject27	Object
      //   67	2930	17	localObject28	Object
      //   49	3681	18	str	String
      //   43	4449	19	localaa2	com.tencent.mm.network.aa
      //   55	3794	20	arrayOfByte	byte[]
      //   61	2735	21	localObject29	Object
      //   70	3111	22	localObject30	Object
      // Exception table:
      //   from	to	target	type
      //   475	480	486	java/lang/Exception
      //   926	931	936	java/lang/Exception
      //   1055	1063	1096	java/lang/Exception
      //   1084	1093	1096	java/lang/Exception
      //   1369	1420	1096	java/lang/Exception
      //   1436	1446	1096	java/lang/Exception
      //   1469	1477	1096	java/lang/Exception
      //   1493	1508	1096	java/lang/Exception
      //   1524	1538	1096	java/lang/Exception
      //   1554	1570	1096	java/lang/Exception
      //   2694	2702	2735	java/lang/Exception
      //   2723	2732	2735	java/lang/Exception
      //   2827	2878	2735	java/lang/Exception
      //   2894	2904	2735	java/lang/Exception
      //   2927	2935	2735	java/lang/Exception
      //   2951	2966	2735	java/lang/Exception
      //   2982	2996	2735	java/lang/Exception
      //   3012	3028	2735	java/lang/Exception
      //   3167	3174	3222	java/lang/Exception
      //   3658	3665	3670	java/lang/Exception
      //   3789	3797	3830	java/lang/Exception
      //   3818	3827	3830	java/lang/Exception
      //   3897	3948	3830	java/lang/Exception
      //   3964	3973	3830	java/lang/Exception
      //   3989	4006	3830	java/lang/Exception
      //   4029	4037	3830	java/lang/Exception
      //   4057	4072	3830	java/lang/Exception
      //   4088	4102	3830	java/lang/Exception
      //   4118	4134	3830	java/lang/Exception
      //   4164	4179	3830	java/lang/Exception
      //   4195	4209	3830	java/lang/Exception
      //   4225	4241	3830	java/lang/Exception
      //   1610	1616	4282	java/lang/Exception
      //   1632	1645	4282	java/lang/Exception
      //   1661	1669	4282	java/lang/Exception
      //   1685	1696	4282	java/lang/Exception
      //   1712	1720	4282	java/lang/Exception
      //   1736	1744	4282	java/lang/Exception
      //   1760	1771	4282	java/lang/Exception
      //   1787	1796	4282	java/lang/Exception
      //   1812	1821	4282	java/lang/Exception
      //   1837	1849	4282	java/lang/Exception
      //   1865	1878	4282	java/lang/Exception
      //   1894	1902	4282	java/lang/Exception
      //   1918	1938	4282	java/lang/Exception
      //   1954	1966	4282	java/lang/Exception
      //   1982	1989	4282	java/lang/Exception
      //   2005	2015	4282	java/lang/Exception
      //   2031	2043	4282	java/lang/Exception
      //   4271	4279	4282	java/lang/Exception
      //   2048	2053	4289	java/lang/Exception
      //   2058	2063	4289	java/lang/Exception
      //   2068	2075	4289	java/lang/Exception
      //   2080	2085	4289	java/lang/Exception
      //   1271	1276	4296	java/lang/Exception
      //   1281	1286	4296	java/lang/Exception
      //   1291	1298	4296	java/lang/Exception
      //   1303	1308	4296	java/lang/Exception
      //   80	87	4301	finally
      //   101	126	4301	finally
      //   134	141	4301	finally
      //   149	160	4301	finally
      //   184	226	4301	finally
      //   234	247	4301	finally
      //   255	282	4301	finally
      //   295	304	4301	finally
      //   312	317	4301	finally
      //   325	346	4301	finally
      //   354	359	4301	finally
      //   367	380	4301	finally
      //   388	408	4301	finally
      //   416	430	4301	finally
      //   438	450	4301	finally
      //   463	470	4301	finally
      //   502	508	4301	finally
      //   516	529	4301	finally
      //   537	545	4301	finally
      //   553	569	4301	finally
      //   577	584	4301	finally
      //   592	602	4301	finally
      //   610	623	4301	finally
      //   631	652	4301	finally
      //   660	672	4301	finally
      //   680	711	4301	finally
      //   719	732	4301	finally
      //   740	749	4301	finally
      //   757	769	4301	finally
      //   777	782	4301	finally
      //   790	798	4301	finally
      //   806	814	4301	finally
      //   822	831	4301	finally
      //   839	847	4301	finally
      //   855	873	4301	finally
      //   881	891	4301	finally
      //   899	908	4301	finally
      //   916	921	4301	finally
      //   951	956	4301	finally
      //   964	969	4301	finally
      //   1319	1329	4301	finally
      //   2098	2112	4301	finally
      //   2120	2132	4301	finally
      //   2145	2152	4301	finally
      //   2166	2174	4301	finally
      //   2182	2188	4301	finally
      //   2196	2209	4301	finally
      //   2217	2225	4301	finally
      //   2233	2249	4301	finally
      //   2257	2264	4301	finally
      //   2272	2282	4301	finally
      //   2290	2303	4301	finally
      //   2311	2332	4301	finally
      //   2340	2352	4301	finally
      //   2360	2391	4301	finally
      //   2399	2412	4301	finally
      //   2420	2434	4301	finally
      //   2442	2448	4301	finally
      //   2456	2464	4301	finally
      //   2472	2480	4301	finally
      //   2488	2494	4301	finally
      //   2502	2510	4301	finally
      //   2518	2533	4301	finally
      //   2541	2551	4301	finally
      //   2559	2568	4301	finally
      //   2576	2581	4301	finally
      //   2594	2599	4301	finally
      //   2607	2612	4301	finally
      //   2780	2787	4301	finally
      //   3066	3084	4301	finally
      //   3096	3108	4301	finally
      //   3154	3162	4301	finally
      //   3188	3201	4301	finally
      //   3238	3244	4301	finally
      //   3252	3265	4301	finally
      //   3273	3281	4301	finally
      //   3289	3305	4301	finally
      //   3313	3322	4301	finally
      //   3330	3340	4301	finally
      //   3348	3361	4301	finally
      //   3369	3390	4301	finally
      //   3398	3412	4301	finally
      //   3420	3451	4301	finally
      //   3459	3472	4301	finally
      //   3480	3496	4301	finally
      //   3504	3512	4301	finally
      //   3520	3530	4301	finally
      //   3538	3548	4301	finally
      //   3556	3564	4301	finally
      //   3572	3580	4301	finally
      //   3588	3605	4301	finally
      //   3613	3623	4301	finally
      //   3631	3640	4301	finally
      //   3648	3653	4301	finally
      //   3685	3690	4301	finally
      //   3698	3703	4301	finally
      //   3852	3861	4301	finally
      //   4312	4317	4363	java/lang/Exception
      //   4322	4327	4363	java/lang/Exception
      //   4332	4339	4363	java/lang/Exception
      //   4344	4349	4363	java/lang/Exception
      //   1345	1350	4368	finally
      //   2799	2804	4368	finally
      //   3873	3878	4368	finally
      //   984	991	4385	finally
      //   1003	1035	4385	finally
      //   2627	2634	4385	finally
      //   2646	2678	4385	finally
      //   3718	3725	4385	finally
      //   3737	3769	4385	finally
      //   1055	1063	4402	finally
      //   1084	1093	4402	finally
      //   1369	1420	4402	finally
      //   1436	1446	4402	finally
      //   1469	1477	4402	finally
      //   1493	1508	4402	finally
      //   1524	1538	4402	finally
      //   1554	1570	4402	finally
      //   2694	2702	4402	finally
      //   2723	2732	4402	finally
      //   2827	2878	4402	finally
      //   2894	2904	4402	finally
      //   2927	2935	4402	finally
      //   2951	2966	4402	finally
      //   2982	2996	4402	finally
      //   3012	3028	4402	finally
      //   3789	3797	4402	finally
      //   3818	3827	4402	finally
      //   3897	3948	4402	finally
      //   3964	3973	4402	finally
      //   3989	4006	4402	finally
      //   4029	4037	4402	finally
      //   4057	4072	4402	finally
      //   4088	4102	4402	finally
      //   4118	4134	4402	finally
      //   4164	4179	4402	finally
      //   4195	4209	4402	finally
      //   4225	4241	4402	finally
      //   1574	1591	4427	finally
      //   3112	3123	4456	finally
      //   3127	3141	4456	finally
      //   3205	3219	4477	finally
      //   1119	1124	4498	finally
      //   1140	1160	4498	finally
      //   1176	1187	4498	finally
      //   1203	1210	4498	finally
      //   1226	1239	4498	finally
      //   1255	1266	4498	finally
      //   1610	1616	4498	finally
      //   1632	1645	4498	finally
      //   1661	1669	4498	finally
      //   1685	1696	4498	finally
      //   1712	1720	4498	finally
      //   1736	1744	4498	finally
      //   1760	1771	4498	finally
      //   1787	1796	4498	finally
      //   1812	1821	4498	finally
      //   1837	1849	4498	finally
      //   1865	1878	4498	finally
      //   1894	1902	4498	finally
      //   1918	1938	4498	finally
      //   1954	1966	4498	finally
      //   1982	1989	4498	finally
      //   2005	2015	4498	finally
      //   2031	2043	4498	finally
      //   4271	4279	4498	finally
      //   80	87	4519	java/lang/Exception
      //   101	126	4519	java/lang/Exception
      //   134	141	4519	java/lang/Exception
      //   149	160	4519	java/lang/Exception
      //   184	226	4536	java/lang/Exception
      //   234	247	4536	java/lang/Exception
      //   255	282	4536	java/lang/Exception
      //   295	304	4536	java/lang/Exception
      //   312	317	4536	java/lang/Exception
      //   325	346	4536	java/lang/Exception
      //   354	359	4536	java/lang/Exception
      //   367	380	4536	java/lang/Exception
      //   388	408	4536	java/lang/Exception
      //   416	430	4536	java/lang/Exception
      //   438	450	4536	java/lang/Exception
      //   2098	2112	4536	java/lang/Exception
      //   2120	2132	4536	java/lang/Exception
      //   2145	2152	4536	java/lang/Exception
      //   2166	2174	4536	java/lang/Exception
      //   2182	2188	4536	java/lang/Exception
      //   2196	2209	4536	java/lang/Exception
      //   2217	2225	4536	java/lang/Exception
      //   2233	2249	4536	java/lang/Exception
      //   2257	2264	4536	java/lang/Exception
      //   2272	2282	4536	java/lang/Exception
      //   2290	2303	4536	java/lang/Exception
      //   2311	2332	4536	java/lang/Exception
      //   2340	2352	4536	java/lang/Exception
      //   2360	2391	4536	java/lang/Exception
      //   2399	2412	4536	java/lang/Exception
      //   2420	2434	4536	java/lang/Exception
      //   2442	2448	4536	java/lang/Exception
      //   2456	2464	4536	java/lang/Exception
      //   2472	2480	4536	java/lang/Exception
      //   2488	2494	4536	java/lang/Exception
      //   2502	2510	4536	java/lang/Exception
      //   2518	2533	4536	java/lang/Exception
      //   2541	2551	4536	java/lang/Exception
      //   2559	2568	4536	java/lang/Exception
      //   2576	2581	4536	java/lang/Exception
      //   2594	2599	4536	java/lang/Exception
      //   2607	2612	4536	java/lang/Exception
      //   2780	2787	4536	java/lang/Exception
      //   3066	3084	4536	java/lang/Exception
      //   3096	3108	4536	java/lang/Exception
      //   3188	3201	4536	java/lang/Exception
      //   463	470	4555	java/lang/Exception
      //   502	508	4555	java/lang/Exception
      //   516	529	4555	java/lang/Exception
      //   537	545	4555	java/lang/Exception
      //   553	569	4555	java/lang/Exception
      //   577	584	4555	java/lang/Exception
      //   592	602	4555	java/lang/Exception
      //   610	623	4555	java/lang/Exception
      //   631	652	4555	java/lang/Exception
      //   660	672	4555	java/lang/Exception
      //   680	711	4555	java/lang/Exception
      //   719	732	4555	java/lang/Exception
      //   740	749	4555	java/lang/Exception
      //   757	769	4555	java/lang/Exception
      //   777	782	4555	java/lang/Exception
      //   790	798	4555	java/lang/Exception
      //   806	814	4555	java/lang/Exception
      //   822	831	4555	java/lang/Exception
      //   839	847	4555	java/lang/Exception
      //   855	873	4555	java/lang/Exception
      //   881	891	4555	java/lang/Exception
      //   899	908	4555	java/lang/Exception
      //   916	921	4555	java/lang/Exception
      //   951	956	4555	java/lang/Exception
      //   964	969	4555	java/lang/Exception
      //   1319	1329	4555	java/lang/Exception
      //   1345	1350	4571	java/lang/Exception
      //   984	991	4584	java/lang/Exception
      //   1003	1035	4584	java/lang/Exception
      //   2799	2804	4597	java/lang/Exception
      //   2627	2634	4613	java/lang/Exception
      //   2646	2678	4613	java/lang/Exception
      //   1574	1591	4637	java/lang/Exception
      //   3112	3123	4647	java/lang/Exception
      //   3127	3141	4647	java/lang/Exception
      //   3205	3219	4647	java/lang/Exception
      //   3154	3162	4663	java/lang/Exception
      //   3238	3244	4663	java/lang/Exception
      //   3252	3265	4663	java/lang/Exception
      //   3273	3281	4663	java/lang/Exception
      //   3289	3305	4663	java/lang/Exception
      //   3313	3322	4663	java/lang/Exception
      //   3330	3340	4663	java/lang/Exception
      //   3348	3361	4663	java/lang/Exception
      //   3369	3390	4663	java/lang/Exception
      //   3398	3412	4663	java/lang/Exception
      //   3420	3451	4663	java/lang/Exception
      //   3459	3472	4663	java/lang/Exception
      //   3480	3496	4663	java/lang/Exception
      //   3504	3512	4663	java/lang/Exception
      //   3520	3530	4663	java/lang/Exception
      //   3538	3548	4663	java/lang/Exception
      //   3556	3564	4663	java/lang/Exception
      //   3572	3580	4663	java/lang/Exception
      //   3588	3605	4663	java/lang/Exception
      //   3613	3623	4663	java/lang/Exception
      //   3631	3640	4663	java/lang/Exception
      //   3648	3653	4663	java/lang/Exception
      //   3685	3690	4663	java/lang/Exception
      //   3698	3703	4663	java/lang/Exception
      //   3852	3861	4663	java/lang/Exception
      //   3873	3878	4683	java/lang/Exception
      //   3718	3725	4700	java/lang/Exception
      //   3737	3769	4700	java/lang/Exception
    }
  }
  
  public static abstract interface b
  {
    public abstract void l(String paramString1, String paramString2, int paramInt);
  }
  
  final class c
  {
    String filename;
    boolean okJ;
    String okK;
    int pos;
    String url;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(150159);
      this.okJ = false;
      this.url = paramString1;
      if (ag.this.oky) {
        this.url = com.tencent.mm.modelimage.u.Om(this.url);
      }
      this.filename = paramString2;
      this.pos = paramInt;
      this.okJ = false;
      this.okK = paramString3;
      AppMethodBeat.o(150159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.ag
 * JD-Core Version:    0.7.0.1
 */