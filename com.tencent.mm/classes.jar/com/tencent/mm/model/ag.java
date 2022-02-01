package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.e.i.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.t;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public final class ag
{
  MMHandler handler;
  public a lsX;
  boolean lsY;
  String lsZ;
  BlockingQueue<c> lta;
  public b ltb;
  
  public ag(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(150160);
    this.lsX = null;
    this.lsY = false;
    this.lsZ = "";
    this.lta = new ArrayBlockingQueue(80);
    this.ltb = null;
    com.tencent.mm.kernel.h.aHH();
    this.handler = new MMHandler(com.tencent.mm.kernel.h.aHJ().getLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(150157);
        for (;;)
        {
          try
          {
            Bitmap localBitmap;
            if (ag.this.ltb != null)
            {
              paramAnonymousMessage = (ag.c)paramAnonymousMessage.obj;
              if ((paramAnonymousMessage.ltj) && (t.bmq()))
              {
                String str = t.Wn(paramAnonymousMessage.url);
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
              int i = (int)u.bBQ(paramAnonymousMessage.filename);
              if ((i > 0) && (com.tencent.mm.kernel.h.aHB())) {
                az.a.lts.dH(i, 0);
              }
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(150156);
                  if (ag.this.ltb != null) {
                    ag.this.ltb.i(paramAnonymousMessage.url, paramAnonymousMessage.filename, paramAnonymousMessage.pos);
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
    this.lsX = null;
    this.lsY = paramBoolean;
    this.lsZ = paramString;
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
        boolean bool = u.agG((String)localObject);
        if (!bool) {
          break label255;
        }
        AppMethodBeat.o(150161);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.GetPicService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
      if (!com.tencent.mm.kernel.h.aHB())
      {
        Log.i("MicroMsg.GetPicService", "genFileName, account not ready");
        localObject = new q(com.tencent.mm.kernel.h.aHG().kcA + "/imagecache");
        if (!((q)localObject).ifE()) {
          ((q)localObject).ifL();
        }
        localObject = ((q)localObject).bOF() + "/reader_" + paramInt1 + "_" + g.getMessageDigest(paramString1.getBytes()) + ".jpg";
      }
      else
      {
        localObject = d.bbW() + "/reader_" + paramInt1 + "_" + g.getMessageDigest(paramString1.getBytes()) + ".jpg";
      }
    }
    for (;;)
    {
      try
      {
        label255:
        this.lta.add(new c(paramString1, (String)localObject, paramInt2, paramString2));
        if (this.lsX != null)
        {
          paramString1 = this.lsX;
          if ((paramString1.fuk == null) || (paramString1.fuk.isDone())) {
            continue;
          }
          paramInt1 = 1;
          break label404;
        }
        if (this.lsX != null)
        {
          paramString1 = this.lsX;
          if (paramString1.fuk != null) {
            paramString1.fuk.cancel(false);
          }
        }
        this.lsX = new a();
        com.tencent.e.h.ZvG.be(this.lsX);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.GetPicService", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
        continue;
      }
      AppMethodBeat.o(150161);
      return null;
      paramInt1 = 0;
      label404:
      if (paramInt1 != 0) {}
    }
  }
  
  public final class a
    implements e, com.tencent.e.i.h
  {
    Future<?> fuk;
    public boolean ltf = true;
    ag.c ltg = null;
    final int lth = 15;
    int lti = 0;
    
    a() {}
    
    private boolean uO(int paramInt)
    {
      return (ag.this.lsY) && (this.lti < 15) && ((paramInt == 301) || (paramInt == 302));
    }
    
    public final void a(Future<?> paramFuture)
    {
      this.fuk = paramFuture;
    }
    
    public final String getKey()
    {
      return "GetPicService_getPic";
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: iconst_0
      //   7: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   10: iconst_0
      //   11: istore_1
      //   12: aload_0
      //   13: getfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   16: ifne +4208 -> 4224
      //   19: iload_1
      //   20: bipush 10
      //   22: if_icmple +14 -> 36
      //   25: aload_0
      //   26: iconst_1
      //   27: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   30: ldc 57
      //   32: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   81: getfield 38	com/tencent/mm/model/ag$a:lti	I
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
      //   103: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   106: getfield 70	com/tencent/mm/model/ag:lta	Ljava/util/concurrent/BlockingQueue;
      //   109: ldc2_w 71
      //   112: getstatic 78	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   115: invokeinterface 84 4 0
      //   120: checkcast 86	com/tencent/mm/model/ag$c
      //   123: putfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   126: aload 22
      //   128: astore 9
      //   130: aload 20
      //   132: astore 10
      //   134: aload_0
      //   135: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   138: ifnull +26 -> 164
      //   141: aload 22
      //   143: astore 9
      //   145: aload 20
      //   147: astore 10
      //   149: aload_0
      //   150: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   153: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   156: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
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
      //   184: ldc 98
      //   186: new 100	java/lang/StringBuilder
      //   189: dup
      //   190: ldc 102
      //   192: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   195: aload_0
      //   196: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   199: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   202: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: ldc 111
      //   207: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: aload_0
      //   211: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   214: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   217: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   223: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   226: aload 22
      //   228: astore 9
      //   230: aload 20
      //   232: astore 10
      //   234: aload_0
      //   235: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   238: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   241: invokestatic 128	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   244: ifeq +43 -> 287
      //   247: aload 22
      //   249: astore 9
      //   251: aload 20
      //   253: astore 10
      //   255: ldc 98
      //   257: new 100	java/lang/StringBuilder
      //   260: dup
      //   261: ldc 130
      //   263: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   266: aload_0
      //   267: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   270: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   273: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   279: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   282: iconst_0
      //   283: istore_1
      //   284: goto -272 -> 12
      //   287: aload 22
      //   289: astore 9
      //   291: aload 20
      //   293: astore 10
      //   295: aload_0
      //   296: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   299: lconst_0
      //   300: lconst_1
      //   301: invokestatic 133	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   304: aload 22
      //   306: astore 9
      //   308: aload 20
      //   310: astore 10
      //   312: invokestatic 137	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   315: lstore 4
      //   317: aload 22
      //   319: astore 9
      //   321: aload 20
      //   323: astore 10
      //   325: ldc 98
      //   327: ldc 139
      //   329: iconst_1
      //   330: anewarray 4	java/lang/Object
      //   333: dup
      //   334: iconst_0
      //   335: aload_0
      //   336: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   339: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   342: aastore
      //   343: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   346: aload 22
      //   348: astore 9
      //   350: aload 20
      //   352: astore 10
      //   354: invokestatic 147	java/lang/System:currentTimeMillis	()J
      //   357: lstore 6
      //   359: aload 22
      //   361: astore 9
      //   363: aload 20
      //   365: astore 10
      //   367: aload_0
      //   368: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   371: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   374: invokestatic 152	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   377: ifeq +2602 -> 2979
      //   380: aload 22
      //   382: astore 9
      //   384: aload 20
      //   386: astore 10
      //   388: ldc 154
      //   390: invokestatic 160	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   393: checkcast 154	com/tencent/mm/plugin/expt/b/b
      //   396: getstatic 166	com/tencent/mm/plugin/expt/b/b$a:vUw	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   399: iconst_0
      //   400: invokeinterface 169 3 0
      //   405: ifne +1634 -> 2039
      //   408: aload 22
      //   410: astore 9
      //   412: aload 20
      //   414: astore 10
      //   416: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   419: ldc2_w 176
      //   422: ldc2_w 178
      //   425: lconst_1
      //   426: iconst_0
      //   427: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   430: aload 22
      //   432: astore 9
      //   434: aload 20
      //   436: astore 10
      //   438: aload_0
      //   439: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   442: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   445: invokestatic 189	com/tencent/mm/network/d:Zr	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
      //   448: astore 8
      //   450: aload 22
      //   452: astore 9
      //   454: aload 8
      //   456: astore 10
      //   458: invokestatic 195	com/tencent/mm/ay/t:bmq	()Z
      //   461: ifeq +79 -> 540
      //   464: aload 22
      //   466: astore 9
      //   468: aload 8
      //   470: astore 10
      //   472: aload_0
      //   473: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   476: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   479: invokestatic 198	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
      //   482: ifeq +58 -> 540
      //   485: aload 22
      //   487: astore 9
      //   489: aload 8
      //   491: astore 10
      //   493: getstatic 203	com/tencent/mm/protocal/d:RAD	I
      //   496: invokestatic 207	com/tencent/mm/ay/t:wt	(I)Ljava/lang/String;
      //   499: astore 14
      //   501: aload 22
      //   503: astore 9
      //   505: aload 8
      //   507: astore 10
      //   509: ldc 98
      //   511: ldc 209
      //   513: iconst_1
      //   514: anewarray 4	java/lang/Object
      //   517: dup
      //   518: iconst_0
      //   519: aload 14
      //   521: aastore
      //   522: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   525: aload 22
      //   527: astore 9
      //   529: aload 8
      //   531: astore 10
      //   533: aload 8
      //   535: aload 14
      //   537: invokevirtual 214	com/tencent/mm/network/aa:Zw	(Ljava/lang/String;)V
      //   540: aload 22
      //   542: astore 9
      //   544: aload 8
      //   546: astore 10
      //   548: aload_0
      //   549: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   552: getfield 44	com/tencent/mm/model/ag:lsY	Z
      //   555: ifeq +73 -> 628
      //   558: aload 22
      //   560: astore 9
      //   562: aload 8
      //   564: astore 10
      //   566: aload_0
      //   567: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   570: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   573: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   576: ifne +52 -> 628
      //   579: aload 22
      //   581: astore 9
      //   583: aload 8
      //   585: astore 10
      //   587: ldc 98
      //   589: ldc 219
      //   591: iconst_1
      //   592: anewarray 4	java/lang/Object
      //   595: dup
      //   596: iconst_0
      //   597: aload_0
      //   598: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   601: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   604: aastore
      //   605: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   608: aload 22
      //   610: astore 9
      //   612: aload 8
      //   614: astore 10
      //   616: aload 8
      //   618: aload_0
      //   619: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   622: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   625: invokevirtual 214	com/tencent/mm/network/aa:Zw	(Ljava/lang/String;)V
      //   628: aload 22
      //   630: astore 9
      //   632: aload 8
      //   634: astore 10
      //   636: ldc 98
      //   638: ldc 221
      //   640: iconst_2
      //   641: anewarray 4	java/lang/Object
      //   644: dup
      //   645: iconst_0
      //   646: aload_0
      //   647: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   650: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   653: aastore
      //   654: dup
      //   655: iconst_1
      //   656: aload_0
      //   657: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   660: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   663: aastore
      //   664: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   667: aload 22
      //   669: astore 9
      //   671: aload 8
      //   673: astore 10
      //   675: aload_0
      //   676: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   679: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   682: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   685: ifne +40 -> 725
      //   688: aload 22
      //   690: astore 9
      //   692: aload 8
      //   694: astore 10
      //   696: aload_0
      //   697: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   700: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   703: astore 14
      //   705: aload 22
      //   707: astore 9
      //   709: aload 8
      //   711: astore 10
      //   713: aload 8
      //   715: getfield 230	com/tencent/mm/network/aa:mvV	Ljavax/net/ssl/HttpsURLConnection;
      //   718: ldc 232
      //   720: aload 14
      //   722: invokevirtual 237	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   725: aload 22
      //   727: astore 9
      //   729: aload 8
      //   731: astore 10
      //   733: aload 8
      //   735: invokevirtual 240	com/tencent/mm/network/aa:btG	()V
      //   738: aload 22
      //   740: astore 9
      //   742: aload 8
      //   744: astore 10
      //   746: aload 8
      //   748: sipush 3000
      //   751: invokevirtual 243	com/tencent/mm/network/aa:xz	(I)V
      //   754: aload 22
      //   756: astore 9
      //   758: aload 8
      //   760: astore 10
      //   762: aload 8
      //   764: sipush 3000
      //   767: invokevirtual 246	com/tencent/mm/network/aa:xA	(I)V
      //   770: aload 22
      //   772: astore 9
      //   774: aload 8
      //   776: astore 10
      //   778: aload 8
      //   780: getfield 230	com/tencent/mm/network/aa:mvV	Ljavax/net/ssl/HttpsURLConnection;
      //   783: invokevirtual 250	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
      //   786: istore_1
      //   787: aload 22
      //   789: astore 9
      //   791: aload 8
      //   793: astore 10
      //   795: aload_0
      //   796: iload_1
      //   797: invokespecial 252	com/tencent/mm/model/ag$a:uO	(I)Z
      //   800: ifeq +460 -> 1260
      //   803: aload 22
      //   805: astore 9
      //   807: aload 8
      //   809: astore 10
      //   811: aload_0
      //   812: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   815: aload 8
      //   817: getfield 230	com/tencent/mm/network/aa:mvV	Ljavax/net/ssl/HttpsURLConnection;
      //   820: ldc 254
      //   822: invokevirtual 258	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   825: putfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   828: aload 22
      //   830: astore 9
      //   832: aload 8
      //   834: astore 10
      //   836: aload_0
      //   837: aload_0
      //   838: getfield 38	com/tencent/mm/model/ag$a:lti	I
      //   841: iconst_1
      //   842: iadd
      //   843: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   846: aload 22
      //   848: astore 9
      //   850: aload 8
      //   852: astore 10
      //   854: aload_0
      //   855: getfield 38	com/tencent/mm/model/ag$a:lti	I
      //   858: bipush 15
      //   860: if_icmpge +33 -> 893
      //   863: aload 22
      //   865: astore 9
      //   867: aload 8
      //   869: astore 10
      //   871: aload_0
      //   872: iconst_0
      //   873: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   876: aload 8
      //   878: invokevirtual 261	com/tencent/mm/network/aa:disconnect	()V
      //   881: iconst_0
      //   882: istore_1
      //   883: goto -871 -> 12
      //   886: astore 8
      //   888: iconst_0
      //   889: istore_1
      //   890: goto -878 -> 12
      //   893: aload 22
      //   895: astore 9
      //   897: aload 8
      //   899: astore 10
      //   901: aload_0
      //   902: iconst_1
      //   903: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   906: aload 22
      //   908: astore 9
      //   910: aload 8
      //   912: astore 10
      //   914: aload_0
      //   915: iconst_0
      //   916: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   919: aconst_null
      //   920: astore 9
      //   922: aload 11
      //   924: astore 14
      //   926: aload 8
      //   928: astore 13
      //   930: aload 9
      //   932: astore 10
      //   934: sipush 1024
      //   937: newarray byte
      //   939: astore 16
      //   941: aload 11
      //   943: astore 14
      //   945: aload 8
      //   947: astore 13
      //   949: aload 9
      //   951: astore 10
      //   953: new 100	java/lang/StringBuilder
      //   956: dup
      //   957: invokespecial 262	java/lang/StringBuilder:<init>	()V
      //   960: aload_0
      //   961: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   964: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   967: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   970: ldc_w 264
      //   973: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   976: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   979: invokestatic 268	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   982: astore 11
      //   984: aload 11
      //   986: astore 10
      //   988: aload 17
      //   990: astore 14
      //   992: aload 8
      //   994: astore 13
      //   996: aload 9
      //   998: astore 12
      //   1000: aload 10
      //   1002: astore 11
      //   1004: aload 9
      //   1006: aload 16
      //   1008: invokevirtual 274	java/io/InputStream:read	([B)I
      //   1011: istore_2
      //   1012: iload_2
      //   1013: iconst_m1
      //   1014: if_icmpeq +288 -> 1302
      //   1017: aload 17
      //   1019: astore 14
      //   1021: aload 8
      //   1023: astore 13
      //   1025: aload 9
      //   1027: astore 12
      //   1029: aload 10
      //   1031: astore 11
      //   1033: aload 10
      //   1035: aload 16
      //   1037: iconst_0
      //   1038: iload_2
      //   1039: invokevirtual 280	java/io/OutputStream:write	([BII)V
      //   1042: goto -54 -> 988
      //   1045: astore 12
      //   1047: aconst_null
      //   1048: astore 11
      //   1050: iconst_0
      //   1051: istore_1
      //   1052: aload 8
      //   1054: astore 15
      //   1056: aload 9
      //   1058: astore 14
      //   1060: aload 10
      //   1062: astore 13
      //   1064: aload 11
      //   1066: astore 16
      //   1068: aload_0
      //   1069: iconst_0
      //   1070: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   1073: aload 8
      //   1075: astore 15
      //   1077: aload 9
      //   1079: astore 14
      //   1081: aload 10
      //   1083: astore 13
      //   1085: aload 11
      //   1087: astore 16
      //   1089: ldc 98
      //   1091: ldc_w 282
      //   1094: iconst_1
      //   1095: anewarray 4	java/lang/Object
      //   1098: dup
      //   1099: iconst_0
      //   1100: aload 12
      //   1102: invokestatic 286	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1105: aastore
      //   1106: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1109: aload 8
      //   1111: astore 15
      //   1113: aload 9
      //   1115: astore 14
      //   1117: aload 10
      //   1119: astore 13
      //   1121: aload 11
      //   1123: astore 16
      //   1125: aload_0
      //   1126: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   1129: ldc2_w 290
      //   1132: lconst_1
      //   1133: invokestatic 133	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1136: aload 8
      //   1138: astore 15
      //   1140: aload 9
      //   1142: astore 14
      //   1144: aload 10
      //   1146: astore 13
      //   1148: aload 11
      //   1150: astore 16
      //   1152: aload_0
      //   1153: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1156: ifnull +59 -> 1215
      //   1159: aload 8
      //   1161: astore 15
      //   1163: aload 9
      //   1165: astore 14
      //   1167: aload 10
      //   1169: astore 13
      //   1171: aload 11
      //   1173: astore 16
      //   1175: aload_0
      //   1176: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1179: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   1182: invokestatic 198	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
      //   1185: ifeq +30 -> 1215
      //   1188: aload 8
      //   1190: astore 15
      //   1192: aload 9
      //   1194: astore 14
      //   1196: aload 10
      //   1198: astore 13
      //   1200: aload 11
      //   1202: astore 16
      //   1204: aload_0
      //   1205: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   1208: ldc2_w 292
      //   1211: lconst_1
      //   1212: invokestatic 133	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1215: aload 10
      //   1217: ifnull +8 -> 1225
      //   1220: aload 10
      //   1222: invokevirtual 296	java/io/OutputStream:close	()V
      //   1225: aload 9
      //   1227: ifnull +8 -> 1235
      //   1230: aload 9
      //   1232: invokevirtual 297	java/io/InputStream:close	()V
      //   1235: aload 11
      //   1237: ifnull +10 -> 1247
      //   1240: aload 11
      //   1242: invokeinterface 300 1 0
      //   1247: aload 8
      //   1249: ifnull +8 -> 1257
      //   1252: aload 8
      //   1254: invokevirtual 261	com/tencent/mm/network/aa:disconnect	()V
      //   1257: goto -1245 -> 12
      //   1260: aload 22
      //   1262: astore 9
      //   1264: aload 8
      //   1266: astore 10
      //   1268: aload 8
      //   1270: getfield 230	com/tencent/mm/network/aa:mvV	Ljavax/net/ssl/HttpsURLConnection;
      //   1273: invokevirtual 304	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
      //   1276: astore 14
      //   1278: aload 14
      //   1280: astore 9
      //   1282: aload 9
      //   1284: astore 10
      //   1286: aload 21
      //   1288: astore 13
      //   1290: aload 8
      //   1292: astore 14
      //   1294: aload_0
      //   1295: iconst_0
      //   1296: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   1299: goto -377 -> 922
      //   1302: aload 17
      //   1304: astore 14
      //   1306: aload 8
      //   1308: astore 13
      //   1310: aload 9
      //   1312: astore 12
      //   1314: aload 10
      //   1316: astore 11
      //   1318: new 306	com/tencent/mm/vfs/q
      //   1321: dup
      //   1322: new 100	java/lang/StringBuilder
      //   1325: dup
      //   1326: invokespecial 262	java/lang/StringBuilder:<init>	()V
      //   1329: aload_0
      //   1330: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1333: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   1336: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1339: ldc_w 264
      //   1342: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1345: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1348: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   1351: new 306	com/tencent/mm/vfs/q
      //   1354: dup
      //   1355: aload_0
      //   1356: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1359: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   1362: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   1365: invokevirtual 311	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
      //   1368: pop
      //   1369: aload 17
      //   1371: astore 14
      //   1373: aload 8
      //   1375: astore 13
      //   1377: aload 9
      //   1379: astore 12
      //   1381: aload 10
      //   1383: astore 11
      //   1385: aload 8
      //   1387: getfield 230	com/tencent/mm/network/aa:mvV	Ljavax/net/ssl/HttpsURLConnection;
      //   1390: invokevirtual 314	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
      //   1393: astore 16
      //   1395: iload_1
      //   1396: sipush 200
      //   1399: if_icmpne +120 -> 1519
      //   1402: aload 17
      //   1404: astore 14
      //   1406: aload 8
      //   1408: astore 13
      //   1410: aload 9
      //   1412: astore 12
      //   1414: aload 10
      //   1416: astore 11
      //   1418: invokestatic 147	java/lang/System:currentTimeMillis	()J
      //   1421: lload 6
      //   1423: lsub
      //   1424: lstore 6
      //   1426: aload 17
      //   1428: astore 14
      //   1430: aload 8
      //   1432: astore 13
      //   1434: aload 9
      //   1436: astore 12
      //   1438: aload 10
      //   1440: astore 11
      //   1442: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   1445: ldc2_w 176
      //   1448: ldc2_w 315
      //   1451: lload 6
      //   1453: iconst_0
      //   1454: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1457: aload 17
      //   1459: astore 14
      //   1461: aload 8
      //   1463: astore 13
      //   1465: aload 9
      //   1467: astore 12
      //   1469: aload 10
      //   1471: astore 11
      //   1473: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   1476: ldc2_w 176
      //   1479: ldc2_w 317
      //   1482: lconst_1
      //   1483: iconst_0
      //   1484: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1487: aload 17
      //   1489: astore 14
      //   1491: aload 8
      //   1493: astore 13
      //   1495: aload 9
      //   1497: astore 12
      //   1499: aload 10
      //   1501: astore 11
      //   1503: ldc 98
      //   1505: ldc_w 320
      //   1508: lload 6
      //   1510: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1513: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1516: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1519: aload 16
      //   1521: astore 12
      //   1523: ldc 98
      //   1525: ldc_w 333
      //   1528: iconst_1
      //   1529: anewarray 4	java/lang/Object
      //   1532: dup
      //   1533: iconst_0
      //   1534: aload 12
      //   1536: aastore
      //   1537: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1540: aconst_null
      //   1541: astore 11
      //   1543: aload 8
      //   1545: astore 15
      //   1547: aload 9
      //   1549: astore 14
      //   1551: aload 10
      //   1553: astore 13
      //   1555: aload 11
      //   1557: astore 16
      //   1559: invokestatic 195	com/tencent/mm/ay/t:bmq	()Z
      //   1562: ifeq +2560 -> 4122
      //   1565: aload 8
      //   1567: astore 15
      //   1569: aload 9
      //   1571: astore 14
      //   1573: aload 10
      //   1575: astore 13
      //   1577: aload 11
      //   1579: astore 16
      //   1581: aload_0
      //   1582: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1585: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   1588: invokestatic 198	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
      //   1591: ifeq +2531 -> 4122
      //   1594: aload 8
      //   1596: astore 15
      //   1598: aload 9
      //   1600: astore 14
      //   1602: aload 10
      //   1604: astore 13
      //   1606: aload 11
      //   1608: astore 16
      //   1610: aload 12
      //   1612: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   1615: ifne +2507 -> 4122
      //   1618: aload 8
      //   1620: astore 15
      //   1622: aload 9
      //   1624: astore 14
      //   1626: aload 10
      //   1628: astore 13
      //   1630: aload 11
      //   1632: astore 16
      //   1634: aload 12
      //   1636: ldc_w 335
      //   1639: invokevirtual 339	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1642: ifeq +2480 -> 4122
      //   1645: aload 8
      //   1647: astore 15
      //   1649: aload 9
      //   1651: astore 14
      //   1653: aload 10
      //   1655: astore 13
      //   1657: aload 11
      //   1659: astore 16
      //   1661: ldc 98
      //   1663: ldc_w 341
      //   1666: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   1669: aload 8
      //   1671: astore 15
      //   1673: aload 9
      //   1675: astore 14
      //   1677: aload 10
      //   1679: astore 13
      //   1681: aload 11
      //   1683: astore 16
      //   1685: aload_0
      //   1686: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1689: iconst_1
      //   1690: putfield 344	com/tencent/mm/model/ag$c:ltj	Z
      //   1693: aload 8
      //   1695: astore 15
      //   1697: aload 9
      //   1699: astore 14
      //   1701: aload 10
      //   1703: astore 13
      //   1705: aload 11
      //   1707: astore 16
      //   1709: aload_0
      //   1710: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   1713: ldc2_w 345
      //   1716: lconst_1
      //   1717: invokestatic 133	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1720: aload 8
      //   1722: astore 15
      //   1724: aload 9
      //   1726: astore 14
      //   1728: aload 10
      //   1730: astore 13
      //   1732: aload 11
      //   1734: astore 16
      //   1736: new 348	android/os/Message
      //   1739: dup
      //   1740: invokespecial 349	android/os/Message:<init>	()V
      //   1743: astore 12
      //   1745: aload 8
      //   1747: astore 15
      //   1749: aload 9
      //   1751: astore 14
      //   1753: aload 10
      //   1755: astore 13
      //   1757: aload 11
      //   1759: astore 16
      //   1761: aload 12
      //   1763: aload_0
      //   1764: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1767: putfield 353	android/os/Message:obj	Ljava/lang/Object;
      //   1770: aload 8
      //   1772: astore 15
      //   1774: aload 9
      //   1776: astore 14
      //   1778: aload 10
      //   1780: astore 13
      //   1782: aload 11
      //   1784: astore 16
      //   1786: aload 12
      //   1788: aload_0
      //   1789: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1792: getfield 356	com/tencent/mm/model/ag$c:pos	I
      //   1795: putfield 359	android/os/Message:arg1	I
      //   1798: aload 8
      //   1800: astore 15
      //   1802: aload 9
      //   1804: astore 14
      //   1806: aload 10
      //   1808: astore 13
      //   1810: aload 11
      //   1812: astore 16
      //   1814: aload_0
      //   1815: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   1818: getfield 363	com/tencent/mm/model/ag:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
      //   1821: aload 12
      //   1823: invokevirtual 369	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
      //   1826: pop
      //   1827: aload 8
      //   1829: astore 15
      //   1831: aload 9
      //   1833: astore 14
      //   1835: aload 10
      //   1837: astore 13
      //   1839: aload 11
      //   1841: astore 16
      //   1843: invokestatic 137	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   1846: lload 4
      //   1848: lsub
      //   1849: lstore 4
      //   1851: aload 8
      //   1853: astore 15
      //   1855: aload 9
      //   1857: astore 14
      //   1859: aload 10
      //   1861: astore 13
      //   1863: aload 11
      //   1865: astore 16
      //   1867: ldc 98
      //   1869: ldc_w 371
      //   1872: iconst_1
      //   1873: anewarray 4	java/lang/Object
      //   1876: dup
      //   1877: iconst_0
      //   1878: lload 4
      //   1880: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1883: aastore
      //   1884: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1887: aload 8
      //   1889: astore 15
      //   1891: aload 9
      //   1893: astore 14
      //   1895: aload 10
      //   1897: astore 13
      //   1899: aload 11
      //   1901: astore 16
      //   1903: aload_0
      //   1904: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   1907: ldc2_w 377
      //   1910: lload 4
      //   1912: invokestatic 133	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1915: aload 8
      //   1917: astore 15
      //   1919: aload 9
      //   1921: astore 14
      //   1923: aload 10
      //   1925: astore 13
      //   1927: aload 11
      //   1929: astore 16
      //   1931: aload_0
      //   1932: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1935: ifnull +57 -> 1992
      //   1938: aload 8
      //   1940: astore 15
      //   1942: aload 9
      //   1944: astore 14
      //   1946: aload 10
      //   1948: astore 13
      //   1950: aload 11
      //   1952: astore 16
      //   1954: aload_0
      //   1955: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   1958: getfield 344	com/tencent/mm/model/ag$c:ltj	Z
      //   1961: ifeq +31 -> 1992
      //   1964: aload 8
      //   1966: astore 15
      //   1968: aload 9
      //   1970: astore 14
      //   1972: aload 10
      //   1974: astore 13
      //   1976: aload 11
      //   1978: astore 16
      //   1980: aload_0
      //   1981: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   1984: ldc2_w 379
      //   1987: lload 4
      //   1989: invokestatic 133	com/tencent/mm/model/ag:a	(Lcom/tencent/mm/model/ag;JJ)V
      //   1992: aload 10
      //   1994: ifnull +8 -> 2002
      //   1997: aload 10
      //   1999: invokevirtual 296	java/io/OutputStream:close	()V
      //   2002: aload 9
      //   2004: ifnull +8 -> 2012
      //   2007: aload 9
      //   2009: invokevirtual 297	java/io/InputStream:close	()V
      //   2012: aload 11
      //   2014: ifnull +10 -> 2024
      //   2017: aload 11
      //   2019: invokeinterface 300 1 0
      //   2024: aload 8
      //   2026: ifnull +8 -> 2034
      //   2029: aload 8
      //   2031: invokevirtual 261	com/tencent/mm/network/aa:disconnect	()V
      //   2034: iconst_0
      //   2035: istore_1
      //   2036: goto -2024 -> 12
      //   2039: aload 22
      //   2041: astore 9
      //   2043: aload 20
      //   2045: astore 10
      //   2047: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   2050: ldc2_w 176
      //   2053: ldc2_w 381
      //   2056: lconst_1
      //   2057: iconst_0
      //   2058: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2061: aload 22
      //   2063: astore 9
      //   2065: aload 20
      //   2067: astore 10
      //   2069: aload_0
      //   2070: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2073: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2076: invokestatic 386	com/tencent/mm/network/d:Zq	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
      //   2079: astore 19
      //   2081: aload 22
      //   2083: astore 9
      //   2085: aload 20
      //   2087: astore 10
      //   2089: aload 19
      //   2091: sipush 1222
      //   2094: putfield 391	com/tencent/mm/network/z:mvT	I
      //   2097: aload 22
      //   2099: astore 9
      //   2101: aload 20
      //   2103: astore 10
      //   2105: invokestatic 195	com/tencent/mm/ay/t:bmq	()Z
      //   2108: ifeq +79 -> 2187
      //   2111: aload 22
      //   2113: astore 9
      //   2115: aload 20
      //   2117: astore 10
      //   2119: aload_0
      //   2120: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2123: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2126: invokestatic 198	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
      //   2129: ifeq +58 -> 2187
      //   2132: aload 22
      //   2134: astore 9
      //   2136: aload 20
      //   2138: astore 10
      //   2140: getstatic 203	com/tencent/mm/protocal/d:RAD	I
      //   2143: invokestatic 207	com/tencent/mm/ay/t:wt	(I)Ljava/lang/String;
      //   2146: astore 8
      //   2148: aload 22
      //   2150: astore 9
      //   2152: aload 20
      //   2154: astore 10
      //   2156: ldc 98
      //   2158: ldc 209
      //   2160: iconst_1
      //   2161: anewarray 4	java/lang/Object
      //   2164: dup
      //   2165: iconst_0
      //   2166: aload 8
      //   2168: aastore
      //   2169: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2172: aload 22
      //   2174: astore 9
      //   2176: aload 20
      //   2178: astore 10
      //   2180: aload 19
      //   2182: aload 8
      //   2184: invokevirtual 392	com/tencent/mm/network/z:Zw	(Ljava/lang/String;)V
      //   2187: aload 22
      //   2189: astore 9
      //   2191: aload 20
      //   2193: astore 10
      //   2195: aload_0
      //   2196: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   2199: getfield 44	com/tencent/mm/model/ag:lsY	Z
      //   2202: ifeq +73 -> 2275
      //   2205: aload 22
      //   2207: astore 9
      //   2209: aload 20
      //   2211: astore 10
      //   2213: aload_0
      //   2214: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   2217: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   2220: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   2223: ifne +52 -> 2275
      //   2226: aload 22
      //   2228: astore 9
      //   2230: aload 20
      //   2232: astore 10
      //   2234: ldc 98
      //   2236: ldc 219
      //   2238: iconst_1
      //   2239: anewarray 4	java/lang/Object
      //   2242: dup
      //   2243: iconst_0
      //   2244: aload_0
      //   2245: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   2248: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   2251: aastore
      //   2252: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2255: aload 22
      //   2257: astore 9
      //   2259: aload 20
      //   2261: astore 10
      //   2263: aload 19
      //   2265: aload_0
      //   2266: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   2269: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   2272: invokevirtual 392	com/tencent/mm/network/z:Zw	(Ljava/lang/String;)V
      //   2275: aload 22
      //   2277: astore 9
      //   2279: aload 20
      //   2281: astore 10
      //   2283: ldc 98
      //   2285: ldc 221
      //   2287: iconst_2
      //   2288: anewarray 4	java/lang/Object
      //   2291: dup
      //   2292: iconst_0
      //   2293: aload_0
      //   2294: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2297: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   2300: aastore
      //   2301: dup
      //   2302: iconst_1
      //   2303: aload_0
      //   2304: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2307: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2310: aastore
      //   2311: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2314: aload 22
      //   2316: astore 9
      //   2318: aload 20
      //   2320: astore 10
      //   2322: aload_0
      //   2323: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2326: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   2329: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   2332: ifne +25 -> 2357
      //   2335: aload 22
      //   2337: astore 9
      //   2339: aload 20
      //   2341: astore 10
      //   2343: aload 19
      //   2345: ldc 232
      //   2347: aload_0
      //   2348: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2351: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   2354: invokevirtual 395	com/tencent/mm/network/z:bP	(Ljava/lang/String;Ljava/lang/String;)V
      //   2357: aload 22
      //   2359: astore 9
      //   2361: aload 20
      //   2363: astore 10
      //   2365: aload 19
      //   2367: iconst_1
      //   2368: putfield 398	com/tencent/mm/network/z:mvJ	Z
      //   2371: aload 22
      //   2373: astore 9
      //   2375: aload 20
      //   2377: astore 10
      //   2379: aload 19
      //   2381: sipush 3000
      //   2384: putfield 401	com/tencent/mm/network/z:mvD	I
      //   2387: aload 22
      //   2389: astore 9
      //   2391: aload 20
      //   2393: astore 10
      //   2395: aload 19
      //   2397: sipush 3000
      //   2400: putfield 404	com/tencent/mm/network/z:mvE	I
      //   2403: aload 22
      //   2405: astore 9
      //   2407: aload 20
      //   2409: astore 10
      //   2411: aload 19
      //   2413: invokevirtual 405	com/tencent/mm/network/z:getResponseCode	()I
      //   2416: istore_1
      //   2417: aload 22
      //   2419: astore 9
      //   2421: aload 20
      //   2423: astore 10
      //   2425: aload_0
      //   2426: iload_1
      //   2427: invokespecial 252	com/tencent/mm/model/ag$a:uO	(I)Z
      //   2430: ifeq +263 -> 2693
      //   2433: aload 22
      //   2435: astore 9
      //   2437: aload 20
      //   2439: astore 10
      //   2441: aload_0
      //   2442: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2445: aload 19
      //   2447: ldc 254
      //   2449: invokevirtual 408	com/tencent/mm/network/z:Zv	(Ljava/lang/String;)Ljava/lang/String;
      //   2452: putfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   2455: aload 22
      //   2457: astore 9
      //   2459: aload 20
      //   2461: astore 10
      //   2463: aload_0
      //   2464: aload_0
      //   2465: getfield 38	com/tencent/mm/model/ag$a:lti	I
      //   2468: iconst_1
      //   2469: iadd
      //   2470: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   2473: aload 22
      //   2475: astore 9
      //   2477: aload 20
      //   2479: astore 10
      //   2481: aload_0
      //   2482: getfield 38	com/tencent/mm/model/ag$a:lti	I
      //   2485: bipush 15
      //   2487: if_icmpge +21 -> 2508
      //   2490: aload 22
      //   2492: astore 9
      //   2494: aload 20
      //   2496: astore 10
      //   2498: aload_0
      //   2499: iconst_0
      //   2500: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   2503: iconst_0
      //   2504: istore_1
      //   2505: goto -2493 -> 12
      //   2508: aload 22
      //   2510: astore 9
      //   2512: aload 20
      //   2514: astore 10
      //   2516: aload_0
      //   2517: iconst_1
      //   2518: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   2521: aload 22
      //   2523: astore 9
      //   2525: aload 20
      //   2527: astore 10
      //   2529: aload_0
      //   2530: iconst_0
      //   2531: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   2534: aconst_null
      //   2535: astore 8
      //   2537: aload 11
      //   2539: astore 14
      //   2541: aload 18
      //   2543: astore 13
      //   2545: aload 8
      //   2547: astore 10
      //   2549: sipush 1024
      //   2552: newarray byte
      //   2554: astore 20
      //   2556: aload 11
      //   2558: astore 14
      //   2560: aload 18
      //   2562: astore 13
      //   2564: aload 8
      //   2566: astore 10
      //   2568: new 100	java/lang/StringBuilder
      //   2571: dup
      //   2572: invokespecial 262	java/lang/StringBuilder:<init>	()V
      //   2575: aload_0
      //   2576: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2579: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   2582: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2585: ldc_w 264
      //   2588: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2591: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2594: invokestatic 268	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   2597: astore 9
      //   2599: aload 17
      //   2601: astore 14
      //   2603: aload 16
      //   2605: astore 13
      //   2607: aload 8
      //   2609: astore 12
      //   2611: aload 9
      //   2613: astore 11
      //   2615: aload 8
      //   2617: aload 20
      //   2619: invokevirtual 274	java/io/InputStream:read	([B)I
      //   2622: istore_2
      //   2623: iload_2
      //   2624: iconst_m1
      //   2625: if_icmpeq +107 -> 2732
      //   2628: aload 17
      //   2630: astore 14
      //   2632: aload 16
      //   2634: astore 13
      //   2636: aload 8
      //   2638: astore 12
      //   2640: aload 9
      //   2642: astore 11
      //   2644: aload 9
      //   2646: aload 20
      //   2648: iconst_0
      //   2649: iload_2
      //   2650: invokevirtual 280	java/io/OutputStream:write	([BII)V
      //   2653: goto -54 -> 2599
      //   2656: astore 12
      //   2658: aconst_null
      //   2659: astore 13
      //   2661: aconst_null
      //   2662: astore 14
      //   2664: aload 8
      //   2666: astore 10
      //   2668: aload 9
      //   2670: astore 11
      //   2672: iconst_0
      //   2673: istore_1
      //   2674: aload 14
      //   2676: astore 8
      //   2678: aload 10
      //   2680: astore 9
      //   2682: aload 11
      //   2684: astore 10
      //   2686: aload 13
      //   2688: astore 11
      //   2690: goto -1638 -> 1052
      //   2693: aload 22
      //   2695: astore 9
      //   2697: aload 20
      //   2699: astore 10
      //   2701: aload 19
      //   2703: invokevirtual 409	com/tencent/mm/network/z:getInputStream	()Ljava/io/InputStream;
      //   2706: astore 8
      //   2708: aload 8
      //   2710: astore 9
      //   2712: aload 9
      //   2714: astore 10
      //   2716: aload 21
      //   2718: astore 13
      //   2720: aload_0
      //   2721: iconst_0
      //   2722: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   2725: aload 9
      //   2727: astore 8
      //   2729: goto -192 -> 2537
      //   2732: aload 17
      //   2734: astore 14
      //   2736: aload 16
      //   2738: astore 13
      //   2740: aload 8
      //   2742: astore 12
      //   2744: aload 9
      //   2746: astore 11
      //   2748: new 306	com/tencent/mm/vfs/q
      //   2751: dup
      //   2752: new 100	java/lang/StringBuilder
      //   2755: dup
      //   2756: invokespecial 262	java/lang/StringBuilder:<init>	()V
      //   2759: aload_0
      //   2760: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2763: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   2766: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2769: ldc_w 264
      //   2772: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2775: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2778: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   2781: new 306	com/tencent/mm/vfs/q
      //   2784: dup
      //   2785: aload_0
      //   2786: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   2789: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   2792: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   2795: invokevirtual 311	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
      //   2798: pop
      //   2799: aload 17
      //   2801: astore 14
      //   2803: aload 16
      //   2805: astore 13
      //   2807: aload 8
      //   2809: astore 12
      //   2811: aload 9
      //   2813: astore 11
      //   2815: aload 19
      //   2817: ldc_w 411
      //   2820: invokevirtual 408	com/tencent/mm/network/z:Zv	(Ljava/lang/String;)Ljava/lang/String;
      //   2823: astore 18
      //   2825: iload_1
      //   2826: sipush 200
      //   2829: if_icmpne +120 -> 2949
      //   2832: aload 17
      //   2834: astore 14
      //   2836: aload 16
      //   2838: astore 13
      //   2840: aload 8
      //   2842: astore 12
      //   2844: aload 9
      //   2846: astore 11
      //   2848: invokestatic 147	java/lang/System:currentTimeMillis	()J
      //   2851: lload 6
      //   2853: lsub
      //   2854: lstore 6
      //   2856: aload 17
      //   2858: astore 14
      //   2860: aload 16
      //   2862: astore 13
      //   2864: aload 8
      //   2866: astore 12
      //   2868: aload 9
      //   2870: astore 11
      //   2872: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   2875: ldc2_w 176
      //   2878: ldc2_w 412
      //   2881: lload 6
      //   2883: iconst_0
      //   2884: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2887: aload 17
      //   2889: astore 14
      //   2891: aload 16
      //   2893: astore 13
      //   2895: aload 8
      //   2897: astore 12
      //   2899: aload 9
      //   2901: astore 11
      //   2903: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   2906: ldc2_w 176
      //   2909: ldc2_w 414
      //   2912: lconst_1
      //   2913: iconst_0
      //   2914: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2917: aload 17
      //   2919: astore 14
      //   2921: aload 16
      //   2923: astore 13
      //   2925: aload 8
      //   2927: astore 12
      //   2929: aload 9
      //   2931: astore 11
      //   2933: ldc 98
      //   2935: ldc_w 417
      //   2938: lload 6
      //   2940: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   2943: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   2946: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   2949: aconst_null
      //   2950: astore 13
      //   2952: aload 8
      //   2954: astore 10
      //   2956: aload 9
      //   2958: astore 11
      //   2960: aload 18
      //   2962: astore 12
      //   2964: aload 13
      //   2966: astore 8
      //   2968: aload 10
      //   2970: astore 9
      //   2972: aload 11
      //   2974: astore 10
      //   2976: goto -1453 -> 1523
      //   2979: aload 22
      //   2981: astore 9
      //   2983: aload 20
      //   2985: astore 10
      //   2987: ldc 154
      //   2989: invokestatic 160	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   2992: checkcast 154	com/tencent/mm/plugin/expt/b/b
      //   2995: getstatic 166	com/tencent/mm/plugin/expt/b/b$a:vUw	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   2998: iconst_0
      //   2999: invokeinterface 169 3 0
      //   3004: istore_3
      //   3005: iload_3
      //   3006: ifeq +490 -> 3496
      //   3009: aload 22
      //   3011: astore 9
      //   3013: aload 20
      //   3015: astore 10
      //   3017: aload_0
      //   3018: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3021: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3024: invokestatic 386	com/tencent/mm/network/d:Zq	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
      //   3027: astore 8
      //   3029: aload 8
      //   3031: astore 11
      //   3033: aload 8
      //   3035: checkcast 388	com/tencent/mm/network/z
      //   3038: sipush 1222
      //   3041: putfield 391	com/tencent/mm/network/z:mvT	I
      //   3044: aload 8
      //   3046: astore 11
      //   3048: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   3051: ldc2_w 176
      //   3054: ldc2_w 418
      //   3057: lconst_1
      //   3058: iconst_0
      //   3059: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3062: aload 8
      //   3064: astore 9
      //   3066: aload 20
      //   3068: astore 10
      //   3070: invokestatic 195	com/tencent/mm/ay/t:bmq	()Z
      //   3073: ifeq +81 -> 3154
      //   3076: aload 8
      //   3078: astore 9
      //   3080: aload 20
      //   3082: astore 10
      //   3084: aload_0
      //   3085: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3088: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3091: invokestatic 198	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
      //   3094: ifeq +60 -> 3154
      //   3097: aload 8
      //   3099: astore 9
      //   3101: aload 20
      //   3103: astore 10
      //   3105: getstatic 203	com/tencent/mm/protocal/d:RAD	I
      //   3108: invokestatic 207	com/tencent/mm/ay/t:wt	(I)Ljava/lang/String;
      //   3111: astore 11
      //   3113: aload 8
      //   3115: astore 9
      //   3117: aload 20
      //   3119: astore 10
      //   3121: ldc 98
      //   3123: ldc 209
      //   3125: iconst_1
      //   3126: anewarray 4	java/lang/Object
      //   3129: dup
      //   3130: iconst_0
      //   3131: aload 11
      //   3133: aastore
      //   3134: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3137: aload 8
      //   3139: astore 9
      //   3141: aload 20
      //   3143: astore 10
      //   3145: aload 8
      //   3147: aload 11
      //   3149: invokeinterface 420 2 0
      //   3154: aload 8
      //   3156: astore 9
      //   3158: aload 20
      //   3160: astore 10
      //   3162: aload_0
      //   3163: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   3166: getfield 44	com/tencent/mm/model/ag:lsY	Z
      //   3169: ifeq +75 -> 3244
      //   3172: aload 8
      //   3174: astore 9
      //   3176: aload 20
      //   3178: astore 10
      //   3180: aload_0
      //   3181: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   3184: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   3187: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   3190: ifne +54 -> 3244
      //   3193: aload 8
      //   3195: astore 9
      //   3197: aload 20
      //   3199: astore 10
      //   3201: ldc 98
      //   3203: ldc 219
      //   3205: iconst_1
      //   3206: anewarray 4	java/lang/Object
      //   3209: dup
      //   3210: iconst_0
      //   3211: aload_0
      //   3212: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   3215: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   3218: aastore
      //   3219: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3222: aload 8
      //   3224: astore 9
      //   3226: aload 20
      //   3228: astore 10
      //   3230: aload 8
      //   3232: aload_0
      //   3233: getfield 27	com/tencent/mm/model/ag$a:ltc	Lcom/tencent/mm/model/ag;
      //   3236: getfield 217	com/tencent/mm/model/ag:lsZ	Ljava/lang/String;
      //   3239: invokeinterface 420 2 0
      //   3244: aload 8
      //   3246: astore 9
      //   3248: aload 20
      //   3250: astore 10
      //   3252: ldc 98
      //   3254: ldc 221
      //   3256: iconst_2
      //   3257: anewarray 4	java/lang/Object
      //   3260: dup
      //   3261: iconst_0
      //   3262: aload_0
      //   3263: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3266: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   3269: aastore
      //   3270: dup
      //   3271: iconst_1
      //   3272: aload_0
      //   3273: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3276: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3279: aastore
      //   3280: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3283: aload 8
      //   3285: astore 9
      //   3287: aload 20
      //   3289: astore 10
      //   3291: aload_0
      //   3292: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3295: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   3298: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   3301: ifne +27 -> 3328
      //   3304: aload 8
      //   3306: astore 9
      //   3308: aload 20
      //   3310: astore 10
      //   3312: aload 8
      //   3314: ldc 232
      //   3316: aload_0
      //   3317: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3320: getfield 224	com/tencent/mm/model/ag$c:ltk	Ljava/lang/String;
      //   3323: invokeinterface 421 3 0
      //   3328: aload 8
      //   3330: astore 9
      //   3332: aload 20
      //   3334: astore 10
      //   3336: aload 8
      //   3338: iconst_1
      //   3339: invokeinterface 425 2 0
      //   3344: aload 8
      //   3346: astore 9
      //   3348: aload 20
      //   3350: astore 10
      //   3352: aload 8
      //   3354: sipush 3000
      //   3357: invokeinterface 426 2 0
      //   3362: aload 8
      //   3364: astore 9
      //   3366: aload 20
      //   3368: astore 10
      //   3370: aload 8
      //   3372: sipush 3000
      //   3375: invokeinterface 427 2 0
      //   3380: aload 8
      //   3382: astore 9
      //   3384: aload 20
      //   3386: astore 10
      //   3388: aload 8
      //   3390: invokeinterface 428 1 0
      //   3395: istore_1
      //   3396: aload 8
      //   3398: astore 9
      //   3400: aload 20
      //   3402: astore 10
      //   3404: aload_0
      //   3405: iload_1
      //   3406: invokespecial 252	com/tencent/mm/model/ag$a:uO	(I)Z
      //   3409: ifeq +302 -> 3711
      //   3412: aload 8
      //   3414: astore 9
      //   3416: aload 20
      //   3418: astore 10
      //   3420: aload_0
      //   3421: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3424: aload 8
      //   3426: ldc 254
      //   3428: invokeinterface 429 2 0
      //   3433: putfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3436: aload 8
      //   3438: astore 9
      //   3440: aload 20
      //   3442: astore 10
      //   3444: aload_0
      //   3445: aload_0
      //   3446: getfield 38	com/tencent/mm/model/ag$a:lti	I
      //   3449: iconst_1
      //   3450: iadd
      //   3451: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   3454: aload 8
      //   3456: astore 9
      //   3458: aload 20
      //   3460: astore 10
      //   3462: aload_0
      //   3463: getfield 38	com/tencent/mm/model/ag$a:lti	I
      //   3466: bipush 15
      //   3468: if_icmpge +77 -> 3545
      //   3471: aload 8
      //   3473: astore 9
      //   3475: aload 20
      //   3477: astore 10
      //   3479: aload_0
      //   3480: iconst_0
      //   3481: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   3484: aload 8
      //   3486: invokeinterface 300 1 0
      //   3491: iconst_0
      //   3492: istore_1
      //   3493: goto -3481 -> 12
      //   3496: aload 22
      //   3498: astore 9
      //   3500: aload 20
      //   3502: astore 10
      //   3504: aload_0
      //   3505: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3508: getfield 90	com/tencent/mm/model/ag$c:url	Ljava/lang/String;
      //   3511: aconst_null
      //   3512: invokestatic 432	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
      //   3515: astore 8
      //   3517: aload 8
      //   3519: astore 11
      //   3521: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   3524: ldc2_w 176
      //   3527: ldc2_w 433
      //   3530: lconst_1
      //   3531: iconst_0
      //   3532: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3535: goto -473 -> 3062
      //   3538: astore 8
      //   3540: iconst_0
      //   3541: istore_1
      //   3542: goto -3530 -> 12
      //   3545: aload 8
      //   3547: astore 9
      //   3549: aload 20
      //   3551: astore 10
      //   3553: aload_0
      //   3554: iconst_1
      //   3555: putfield 32	com/tencent/mm/model/ag$a:ltf	Z
      //   3558: aload 8
      //   3560: astore 9
      //   3562: aload 20
      //   3564: astore 10
      //   3566: aload_0
      //   3567: iconst_0
      //   3568: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   3571: aconst_null
      //   3572: astore 9
      //   3574: aload 8
      //   3576: astore 14
      //   3578: aload 18
      //   3580: astore 13
      //   3582: aload 9
      //   3584: astore 10
      //   3586: sipush 1024
      //   3589: newarray byte
      //   3591: astore 15
      //   3593: aload 8
      //   3595: astore 14
      //   3597: aload 18
      //   3599: astore 13
      //   3601: aload 9
      //   3603: astore 10
      //   3605: new 100	java/lang/StringBuilder
      //   3608: dup
      //   3609: invokespecial 262	java/lang/StringBuilder:<init>	()V
      //   3612: aload_0
      //   3613: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3616: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   3619: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3622: ldc_w 264
      //   3625: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3628: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3631: invokestatic 268	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   3634: astore 11
      //   3636: aload 11
      //   3638: astore 10
      //   3640: aload 8
      //   3642: astore 14
      //   3644: aload 16
      //   3646: astore 13
      //   3648: aload 9
      //   3650: astore 12
      //   3652: aload 10
      //   3654: astore 11
      //   3656: aload 9
      //   3658: aload 15
      //   3660: invokevirtual 274	java/io/InputStream:read	([B)I
      //   3663: istore_2
      //   3664: iload_2
      //   3665: iconst_m1
      //   3666: if_icmpeq +82 -> 3748
      //   3669: aload 8
      //   3671: astore 14
      //   3673: aload 16
      //   3675: astore 13
      //   3677: aload 9
      //   3679: astore 12
      //   3681: aload 10
      //   3683: astore 11
      //   3685: aload 10
      //   3687: aload 15
      //   3689: iconst_0
      //   3690: iload_2
      //   3691: invokevirtual 280	java/io/OutputStream:write	([BII)V
      //   3694: goto -54 -> 3640
      //   3697: astore 12
      //   3699: aload 8
      //   3701: astore 11
      //   3703: aconst_null
      //   3704: astore 8
      //   3706: iconst_0
      //   3707: istore_1
      //   3708: goto -2656 -> 1052
      //   3711: aload 8
      //   3713: astore 9
      //   3715: aload 20
      //   3717: astore 10
      //   3719: aload 8
      //   3721: invokeinterface 435 1 0
      //   3726: astore 11
      //   3728: aload 11
      //   3730: astore 9
      //   3732: aload 9
      //   3734: astore 10
      //   3736: aload 8
      //   3738: astore 13
      //   3740: aload_0
      //   3741: iconst_0
      //   3742: putfield 38	com/tencent/mm/model/ag$a:lti	I
      //   3745: goto -171 -> 3574
      //   3748: aload 8
      //   3750: astore 14
      //   3752: aload 16
      //   3754: astore 13
      //   3756: aload 9
      //   3758: astore 12
      //   3760: aload 10
      //   3762: astore 11
      //   3764: new 306	com/tencent/mm/vfs/q
      //   3767: dup
      //   3768: new 100	java/lang/StringBuilder
      //   3771: dup
      //   3772: invokespecial 262	java/lang/StringBuilder:<init>	()V
      //   3775: aload_0
      //   3776: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3779: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   3782: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3785: ldc_w 264
      //   3788: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3791: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3794: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   3797: new 306	com/tencent/mm/vfs/q
      //   3800: dup
      //   3801: aload_0
      //   3802: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   3805: getfield 114	com/tencent/mm/model/ag$c:filename	Ljava/lang/String;
      //   3808: invokespecial 307	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   3811: invokevirtual 311	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
      //   3814: pop
      //   3815: aload 8
      //   3817: astore 14
      //   3819: aload 16
      //   3821: astore 13
      //   3823: aload 9
      //   3825: astore 12
      //   3827: aload 10
      //   3829: astore 11
      //   3831: aload 8
      //   3833: invokeinterface 438 1 0
      //   3838: astore 15
      //   3840: aload 8
      //   3842: astore 14
      //   3844: aload 16
      //   3846: astore 13
      //   3848: aload 9
      //   3850: astore 12
      //   3852: aload 10
      //   3854: astore 11
      //   3856: ldc 98
      //   3858: ldc_w 333
      //   3861: iconst_1
      //   3862: anewarray 4	java/lang/Object
      //   3865: dup
      //   3866: iconst_0
      //   3867: aload 15
      //   3869: aastore
      //   3870: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3873: iload_1
      //   3874: sipush 200
      //   3877: if_icmpne +231 -> 4108
      //   3880: aload 8
      //   3882: astore 14
      //   3884: aload 16
      //   3886: astore 13
      //   3888: aload 9
      //   3890: astore 12
      //   3892: aload 10
      //   3894: astore 11
      //   3896: invokestatic 147	java/lang/System:currentTimeMillis	()J
      //   3899: lload 6
      //   3901: lsub
      //   3902: lstore 6
      //   3904: iload_3
      //   3905: ifeq +110 -> 4015
      //   3908: aload 8
      //   3910: astore 14
      //   3912: aload 16
      //   3914: astore 13
      //   3916: aload 9
      //   3918: astore 12
      //   3920: aload 10
      //   3922: astore 11
      //   3924: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   3927: ldc2_w 176
      //   3930: ldc2_w 439
      //   3933: lload 6
      //   3935: iconst_0
      //   3936: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3939: aload 8
      //   3941: astore 14
      //   3943: aload 16
      //   3945: astore 13
      //   3947: aload 9
      //   3949: astore 12
      //   3951: aload 10
      //   3953: astore 11
      //   3955: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   3958: ldc2_w 176
      //   3961: ldc2_w 441
      //   3964: lconst_1
      //   3965: iconst_0
      //   3966: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3969: aload 8
      //   3971: astore 14
      //   3973: aload 16
      //   3975: astore 13
      //   3977: aload 9
      //   3979: astore 12
      //   3981: aload 10
      //   3983: astore 11
      //   3985: ldc 98
      //   3987: ldc_w 444
      //   3990: lload 6
      //   3992: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   3995: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   3998: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   4001: aload 8
      //   4003: astore 11
      //   4005: aconst_null
      //   4006: astore 8
      //   4008: aload 15
      //   4010: astore 12
      //   4012: goto -2469 -> 1543
      //   4015: aload 8
      //   4017: astore 14
      //   4019: aload 16
      //   4021: astore 13
      //   4023: aload 9
      //   4025: astore 12
      //   4027: aload 10
      //   4029: astore 11
      //   4031: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   4034: ldc2_w 176
      //   4037: ldc2_w 445
      //   4040: lload 6
      //   4042: iconst_0
      //   4043: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   4046: aload 8
      //   4048: astore 14
      //   4050: aload 16
      //   4052: astore 13
      //   4054: aload 9
      //   4056: astore 12
      //   4058: aload 10
      //   4060: astore 11
      //   4062: getstatic 175	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   4065: ldc2_w 176
      //   4068: ldc2_w 447
      //   4071: lconst_1
      //   4072: iconst_0
      //   4073: invokevirtual 183	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   4076: aload 8
      //   4078: astore 14
      //   4080: aload 16
      //   4082: astore 13
      //   4084: aload 9
      //   4086: astore 12
      //   4088: aload 10
      //   4090: astore 11
      //   4092: ldc 98
      //   4094: ldc_w 450
      //   4097: lload 6
      //   4099: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   4102: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   4105: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   4108: aload 8
      //   4110: astore 11
      //   4112: aconst_null
      //   4113: astore 8
      //   4115: aload 15
      //   4117: astore 12
      //   4119: goto -2576 -> 1543
      //   4122: aload 8
      //   4124: astore 15
      //   4126: aload 9
      //   4128: astore 14
      //   4130: aload 10
      //   4132: astore 13
      //   4134: aload 11
      //   4136: astore 16
      //   4138: aload_0
      //   4139: getfield 34	com/tencent/mm/model/ag$a:ltg	Lcom/tencent/mm/model/ag$c;
      //   4142: iconst_0
      //   4143: putfield 344	com/tencent/mm/model/ag$c:ltj	Z
      //   4146: goto -2426 -> 1720
      //   4149: astore 12
      //   4151: iconst_0
      //   4152: istore_1
      //   4153: goto -3101 -> 1052
      //   4156: astore 8
      //   4158: iconst_0
      //   4159: istore_1
      //   4160: goto -4148 -> 12
      //   4163: astore 8
      //   4165: goto -4153 -> 12
      //   4168: astore 8
      //   4170: aload 13
      //   4172: astore 11
      //   4174: aload 12
      //   4176: ifnull +8 -> 4184
      //   4179: aload 12
      //   4181: invokevirtual 296	java/io/OutputStream:close	()V
      //   4184: aload 11
      //   4186: ifnull +8 -> 4194
      //   4189: aload 11
      //   4191: invokevirtual 297	java/io/InputStream:close	()V
      //   4194: aload 9
      //   4196: ifnull +10 -> 4206
      //   4199: aload 9
      //   4201: invokeinterface 300 1 0
      //   4206: aload 10
      //   4208: ifnull +8 -> 4216
      //   4211: aload 10
      //   4213: invokevirtual 261	com/tencent/mm/network/aa:disconnect	()V
      //   4216: ldc 57
      //   4218: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   4221: aload 8
      //   4223: athrow
      //   4224: ldc 57
      //   4226: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   4229: return
      //   4230: astore 9
      //   4232: goto -16 -> 4216
      //   4235: astore 8
      //   4237: aload 10
      //   4239: astore 11
      //   4241: aload 13
      //   4243: astore 9
      //   4245: aload 14
      //   4247: astore 10
      //   4249: goto -75 -> 4174
      //   4252: astore 8
      //   4254: aload 10
      //   4256: astore 11
      //   4258: aload 14
      //   4260: astore 9
      //   4262: aload 13
      //   4264: astore 10
      //   4266: goto -92 -> 4174
      //   4269: astore 8
      //   4271: aload 11
      //   4273: astore 9
      //   4275: aload 12
      //   4277: astore 11
      //   4279: aload 9
      //   4281: astore 12
      //   4283: aload 14
      //   4285: astore 9
      //   4287: aload 13
      //   4289: astore 10
      //   4291: goto -117 -> 4174
      //   4294: astore 11
      //   4296: aload 8
      //   4298: astore 13
      //   4300: aload 11
      //   4302: astore 8
      //   4304: aload 9
      //   4306: astore 11
      //   4308: aload 10
      //   4310: astore 12
      //   4312: aload 15
      //   4314: astore 9
      //   4316: aload 13
      //   4318: astore 10
      //   4320: goto -146 -> 4174
      //   4323: astore 10
      //   4325: aload 8
      //   4327: astore 9
      //   4329: aload 10
      //   4331: astore 8
      //   4333: aload 13
      //   4335: astore 11
      //   4337: aload 19
      //   4339: astore 10
      //   4341: goto -167 -> 4174
      //   4344: astore 10
      //   4346: aload 8
      //   4348: astore 9
      //   4350: aload 10
      //   4352: astore 8
      //   4354: aload 13
      //   4356: astore 11
      //   4358: aload 19
      //   4360: astore 10
      //   4362: goto -188 -> 4174
      //   4365: astore 8
      //   4367: aload 16
      //   4369: astore 9
      //   4371: aload 15
      //   4373: astore 10
      //   4375: aload 14
      //   4377: astore 11
      //   4379: aload 13
      //   4381: astore 12
      //   4383: goto -209 -> 4174
      //   4386: astore 12
      //   4388: aconst_null
      //   4389: astore 11
      //   4391: aconst_null
      //   4392: astore 8
      //   4394: aconst_null
      //   4395: astore 9
      //   4397: aconst_null
      //   4398: astore 10
      //   4400: goto -3348 -> 1052
      //   4403: astore 12
      //   4405: aconst_null
      //   4406: astore 11
      //   4408: aconst_null
      //   4409: astore 8
      //   4411: aconst_null
      //   4412: astore 9
      //   4414: aconst_null
      //   4415: astore 10
      //   4417: iconst_0
      //   4418: istore_1
      //   4419: goto -3367 -> 1052
      //   4422: astore 12
      //   4424: aconst_null
      //   4425: astore 11
      //   4427: aconst_null
      //   4428: astore 9
      //   4430: aconst_null
      //   4431: astore 10
      //   4433: iconst_0
      //   4434: istore_1
      //   4435: goto -3383 -> 1052
      //   4438: astore 12
      //   4440: aconst_null
      //   4441: astore 11
      //   4443: aconst_null
      //   4444: astore 10
      //   4446: iconst_0
      //   4447: istore_1
      //   4448: goto -3396 -> 1052
      //   4451: astore 12
      //   4453: aconst_null
      //   4454: astore 11
      //   4456: aconst_null
      //   4457: astore 10
      //   4459: iconst_0
      //   4460: istore_1
      //   4461: goto -3409 -> 1052
      //   4464: astore 12
      //   4466: aconst_null
      //   4467: astore 11
      //   4469: aconst_null
      //   4470: astore 8
      //   4472: aconst_null
      //   4473: astore 10
      //   4475: iconst_0
      //   4476: istore_1
      //   4477: goto -3425 -> 1052
      //   4480: astore 12
      //   4482: aconst_null
      //   4483: astore 11
      //   4485: aconst_null
      //   4486: astore 13
      //   4488: aload 8
      //   4490: astore 9
      //   4492: aconst_null
      //   4493: astore 10
      //   4495: iconst_0
      //   4496: istore_1
      //   4497: aload 13
      //   4499: astore 8
      //   4501: goto -3449 -> 1052
      //   4504: astore 12
      //   4506: aconst_null
      //   4507: astore 11
      //   4509: iconst_0
      //   4510: istore_1
      //   4511: goto -3459 -> 1052
      //   4514: astore 12
      //   4516: aconst_null
      //   4517: astore 8
      //   4519: aconst_null
      //   4520: astore 9
      //   4522: aconst_null
      //   4523: astore 10
      //   4525: iconst_0
      //   4526: istore_1
      //   4527: goto -3475 -> 1052
      //   4530: astore 12
      //   4532: aload 8
      //   4534: astore 11
      //   4536: aconst_null
      //   4537: astore 8
      //   4539: aconst_null
      //   4540: astore 9
      //   4542: aconst_null
      //   4543: astore 10
      //   4545: iconst_0
      //   4546: istore_1
      //   4547: goto -3495 -> 1052
      //   4550: astore 12
      //   4552: aload 8
      //   4554: astore 11
      //   4556: aconst_null
      //   4557: astore 8
      //   4559: aconst_null
      //   4560: astore 10
      //   4562: iconst_0
      //   4563: istore_1
      //   4564: goto -3512 -> 1052
      //   4567: astore 12
      //   4569: aload 8
      //   4571: astore 11
      //   4573: aconst_null
      //   4574: astore 8
      //   4576: aconst_null
      //   4577: astore 10
      //   4579: iconst_0
      //   4580: istore_1
      //   4581: goto -3529 -> 1052
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	4584	0	this	a
      //   11	4570	1	i	int
      //   88	3603	2	j	int
      //   159	3746	3	bool	boolean
      //   315	1673	4	l1	long
      //   357	3741	6	l2	long
      //   448	429	8	localaa	com.tencent.mm.network.aa
      //   886	1144	8	localException1	Exception
      //   2146	1372	8	localObject1	Object
      //   3538	162	8	localException2	Exception
      //   3704	419	8	localObject2	Object
      //   4156	1	8	localException3	Exception
      //   4163	1	8	localException4	Exception
      //   4168	54	8	localObject3	Object
      //   4235	1	8	localObject4	Object
      //   4252	1	8	localObject5	Object
      //   4269	28	8	localObject6	Object
      //   4302	51	8	localObject7	Object
      //   4365	1	8	localObject8	Object
      //   4392	183	8	localObject9	Object
      //   74	4126	9	localObject10	Object
      //   4230	1	9	localException5	Exception
      //   4243	298	9	localObject11	Object
      //   78	4241	10	localObject12	Object
      //   4323	7	10	localObject13	Object
      //   4339	1	10	localz1	com.tencent.mm.network.z
      //   4344	7	10	localObject14	Object
      //   4360	218	10	localObject15	Object
      //   64	4214	11	localObject16	Object
      //   4294	7	11	localObject17	Object
      //   4306	266	11	localObject18	Object
      //   37	991	12	localObject19	Object
      //   1045	56	12	localException6	Exception
      //   1312	1327	12	localObject20	Object
      //   2656	1	12	localException7	Exception
      //   2742	938	12	localObject21	Object
      //   3697	1	12	localException8	Exception
      //   3758	360	12	localObject22	Object
      //   4149	127	12	localException9	Exception
      //   4281	101	12	localObject23	Object
      //   4386	1	12	localException10	Exception
      //   4403	1	12	localException11	Exception
      //   4422	1	12	localException12	Exception
      //   4438	1	12	localException13	Exception
      //   4451	1	12	localException14	Exception
      //   4464	1	12	localException15	Exception
      //   4480	1	12	localException16	Exception
      //   4504	1	12	localException17	Exception
      //   4514	1	12	localException18	Exception
      //   4530	1	12	localException19	Exception
      //   4550	1	12	localException20	Exception
      //   4567	1	12	localException21	Exception
      //   40	4458	13	localObject24	Object
      //   46	4330	14	localObject25	Object
      //   58	4314	15	localObject26	Object
      //   52	4316	16	localObject27	Object
      //   67	2851	17	localObject28	Object
      //   49	3549	18	str	String
      //   43	4316	19	localz2	com.tencent.mm.network.z
      //   55	3661	20	arrayOfByte	byte[]
      //   61	2656	21	localObject29	Object
      //   70	3427	22	localObject30	Object
      // Exception table:
      //   from	to	target	type
      //   876	881	886	java/lang/Exception
      //   1004	1012	1045	java/lang/Exception
      //   1033	1042	1045	java/lang/Exception
      //   1318	1369	1045	java/lang/Exception
      //   1385	1395	1045	java/lang/Exception
      //   1418	1426	1045	java/lang/Exception
      //   1442	1457	1045	java/lang/Exception
      //   1473	1487	1045	java/lang/Exception
      //   1503	1519	1045	java/lang/Exception
      //   2615	2623	2656	java/lang/Exception
      //   2644	2653	2656	java/lang/Exception
      //   2748	2799	2656	java/lang/Exception
      //   2815	2825	2656	java/lang/Exception
      //   2848	2856	2656	java/lang/Exception
      //   2872	2887	2656	java/lang/Exception
      //   2903	2917	2656	java/lang/Exception
      //   2933	2949	2656	java/lang/Exception
      //   3484	3491	3538	java/lang/Exception
      //   3656	3664	3697	java/lang/Exception
      //   3685	3694	3697	java/lang/Exception
      //   3764	3815	3697	java/lang/Exception
      //   3831	3840	3697	java/lang/Exception
      //   3856	3873	3697	java/lang/Exception
      //   3896	3904	3697	java/lang/Exception
      //   3924	3939	3697	java/lang/Exception
      //   3955	3969	3697	java/lang/Exception
      //   3985	4001	3697	java/lang/Exception
      //   4031	4046	3697	java/lang/Exception
      //   4062	4076	3697	java/lang/Exception
      //   4092	4108	3697	java/lang/Exception
      //   1559	1565	4149	java/lang/Exception
      //   1581	1594	4149	java/lang/Exception
      //   1610	1618	4149	java/lang/Exception
      //   1634	1645	4149	java/lang/Exception
      //   1661	1669	4149	java/lang/Exception
      //   1685	1693	4149	java/lang/Exception
      //   1709	1720	4149	java/lang/Exception
      //   1736	1745	4149	java/lang/Exception
      //   1761	1770	4149	java/lang/Exception
      //   1786	1798	4149	java/lang/Exception
      //   1814	1827	4149	java/lang/Exception
      //   1843	1851	4149	java/lang/Exception
      //   1867	1887	4149	java/lang/Exception
      //   1903	1915	4149	java/lang/Exception
      //   1931	1938	4149	java/lang/Exception
      //   1954	1964	4149	java/lang/Exception
      //   1980	1992	4149	java/lang/Exception
      //   4138	4146	4149	java/lang/Exception
      //   1997	2002	4156	java/lang/Exception
      //   2007	2012	4156	java/lang/Exception
      //   2017	2024	4156	java/lang/Exception
      //   2029	2034	4156	java/lang/Exception
      //   1220	1225	4163	java/lang/Exception
      //   1230	1235	4163	java/lang/Exception
      //   1240	1247	4163	java/lang/Exception
      //   1252	1257	4163	java/lang/Exception
      //   80	87	4168	finally
      //   101	126	4168	finally
      //   134	141	4168	finally
      //   149	160	4168	finally
      //   184	226	4168	finally
      //   234	247	4168	finally
      //   255	282	4168	finally
      //   295	304	4168	finally
      //   312	317	4168	finally
      //   325	346	4168	finally
      //   354	359	4168	finally
      //   367	380	4168	finally
      //   388	408	4168	finally
      //   416	430	4168	finally
      //   438	450	4168	finally
      //   458	464	4168	finally
      //   472	485	4168	finally
      //   493	501	4168	finally
      //   509	525	4168	finally
      //   533	540	4168	finally
      //   548	558	4168	finally
      //   566	579	4168	finally
      //   587	608	4168	finally
      //   616	628	4168	finally
      //   636	667	4168	finally
      //   675	688	4168	finally
      //   696	705	4168	finally
      //   713	725	4168	finally
      //   733	738	4168	finally
      //   746	754	4168	finally
      //   762	770	4168	finally
      //   778	787	4168	finally
      //   795	803	4168	finally
      //   811	828	4168	finally
      //   836	846	4168	finally
      //   854	863	4168	finally
      //   871	876	4168	finally
      //   901	906	4168	finally
      //   914	919	4168	finally
      //   1268	1278	4168	finally
      //   2047	2061	4168	finally
      //   2069	2081	4168	finally
      //   2089	2097	4168	finally
      //   2105	2111	4168	finally
      //   2119	2132	4168	finally
      //   2140	2148	4168	finally
      //   2156	2172	4168	finally
      //   2180	2187	4168	finally
      //   2195	2205	4168	finally
      //   2213	2226	4168	finally
      //   2234	2255	4168	finally
      //   2263	2275	4168	finally
      //   2283	2314	4168	finally
      //   2322	2335	4168	finally
      //   2343	2357	4168	finally
      //   2365	2371	4168	finally
      //   2379	2387	4168	finally
      //   2395	2403	4168	finally
      //   2411	2417	4168	finally
      //   2425	2433	4168	finally
      //   2441	2455	4168	finally
      //   2463	2473	4168	finally
      //   2481	2490	4168	finally
      //   2498	2503	4168	finally
      //   2516	2521	4168	finally
      //   2529	2534	4168	finally
      //   2701	2708	4168	finally
      //   2987	3005	4168	finally
      //   3017	3029	4168	finally
      //   3070	3076	4168	finally
      //   3084	3097	4168	finally
      //   3105	3113	4168	finally
      //   3121	3137	4168	finally
      //   3145	3154	4168	finally
      //   3162	3172	4168	finally
      //   3180	3193	4168	finally
      //   3201	3222	4168	finally
      //   3230	3244	4168	finally
      //   3252	3283	4168	finally
      //   3291	3304	4168	finally
      //   3312	3328	4168	finally
      //   3336	3344	4168	finally
      //   3352	3362	4168	finally
      //   3370	3380	4168	finally
      //   3388	3396	4168	finally
      //   3404	3412	4168	finally
      //   3420	3436	4168	finally
      //   3444	3454	4168	finally
      //   3462	3471	4168	finally
      //   3479	3484	4168	finally
      //   3504	3517	4168	finally
      //   3553	3558	4168	finally
      //   3566	3571	4168	finally
      //   3719	3728	4168	finally
      //   4179	4184	4230	java/lang/Exception
      //   4189	4194	4230	java/lang/Exception
      //   4199	4206	4230	java/lang/Exception
      //   4211	4216	4230	java/lang/Exception
      //   1294	1299	4235	finally
      //   2720	2725	4235	finally
      //   3740	3745	4235	finally
      //   934	941	4252	finally
      //   953	984	4252	finally
      //   2549	2556	4252	finally
      //   2568	2599	4252	finally
      //   3586	3593	4252	finally
      //   3605	3636	4252	finally
      //   1004	1012	4269	finally
      //   1033	1042	4269	finally
      //   1318	1369	4269	finally
      //   1385	1395	4269	finally
      //   1418	1426	4269	finally
      //   1442	1457	4269	finally
      //   1473	1487	4269	finally
      //   1503	1519	4269	finally
      //   2615	2623	4269	finally
      //   2644	2653	4269	finally
      //   2748	2799	4269	finally
      //   2815	2825	4269	finally
      //   2848	2856	4269	finally
      //   2872	2887	4269	finally
      //   2903	2917	4269	finally
      //   2933	2949	4269	finally
      //   3656	3664	4269	finally
      //   3685	3694	4269	finally
      //   3764	3815	4269	finally
      //   3831	3840	4269	finally
      //   3856	3873	4269	finally
      //   3896	3904	4269	finally
      //   3924	3939	4269	finally
      //   3955	3969	4269	finally
      //   3985	4001	4269	finally
      //   4031	4046	4269	finally
      //   4062	4076	4269	finally
      //   4092	4108	4269	finally
      //   1523	1540	4294	finally
      //   3033	3044	4323	finally
      //   3048	3062	4323	finally
      //   3521	3535	4344	finally
      //   1068	1073	4365	finally
      //   1089	1109	4365	finally
      //   1125	1136	4365	finally
      //   1152	1159	4365	finally
      //   1175	1188	4365	finally
      //   1204	1215	4365	finally
      //   1559	1565	4365	finally
      //   1581	1594	4365	finally
      //   1610	1618	4365	finally
      //   1634	1645	4365	finally
      //   1661	1669	4365	finally
      //   1685	1693	4365	finally
      //   1709	1720	4365	finally
      //   1736	1745	4365	finally
      //   1761	1770	4365	finally
      //   1786	1798	4365	finally
      //   1814	1827	4365	finally
      //   1843	1851	4365	finally
      //   1867	1887	4365	finally
      //   1903	1915	4365	finally
      //   1931	1938	4365	finally
      //   1954	1964	4365	finally
      //   1980	1992	4365	finally
      //   4138	4146	4365	finally
      //   80	87	4386	java/lang/Exception
      //   101	126	4386	java/lang/Exception
      //   134	141	4386	java/lang/Exception
      //   149	160	4386	java/lang/Exception
      //   184	226	4403	java/lang/Exception
      //   234	247	4403	java/lang/Exception
      //   255	282	4403	java/lang/Exception
      //   295	304	4403	java/lang/Exception
      //   312	317	4403	java/lang/Exception
      //   325	346	4403	java/lang/Exception
      //   354	359	4403	java/lang/Exception
      //   367	380	4403	java/lang/Exception
      //   388	408	4403	java/lang/Exception
      //   416	430	4403	java/lang/Exception
      //   438	450	4403	java/lang/Exception
      //   2047	2061	4403	java/lang/Exception
      //   2069	2081	4403	java/lang/Exception
      //   2089	2097	4403	java/lang/Exception
      //   2105	2111	4403	java/lang/Exception
      //   2119	2132	4403	java/lang/Exception
      //   2140	2148	4403	java/lang/Exception
      //   2156	2172	4403	java/lang/Exception
      //   2180	2187	4403	java/lang/Exception
      //   2195	2205	4403	java/lang/Exception
      //   2213	2226	4403	java/lang/Exception
      //   2234	2255	4403	java/lang/Exception
      //   2263	2275	4403	java/lang/Exception
      //   2283	2314	4403	java/lang/Exception
      //   2322	2335	4403	java/lang/Exception
      //   2343	2357	4403	java/lang/Exception
      //   2365	2371	4403	java/lang/Exception
      //   2379	2387	4403	java/lang/Exception
      //   2395	2403	4403	java/lang/Exception
      //   2411	2417	4403	java/lang/Exception
      //   2425	2433	4403	java/lang/Exception
      //   2441	2455	4403	java/lang/Exception
      //   2463	2473	4403	java/lang/Exception
      //   2481	2490	4403	java/lang/Exception
      //   2498	2503	4403	java/lang/Exception
      //   2516	2521	4403	java/lang/Exception
      //   2529	2534	4403	java/lang/Exception
      //   2701	2708	4403	java/lang/Exception
      //   2987	3005	4403	java/lang/Exception
      //   3017	3029	4403	java/lang/Exception
      //   3504	3517	4403	java/lang/Exception
      //   458	464	4422	java/lang/Exception
      //   472	485	4422	java/lang/Exception
      //   493	501	4422	java/lang/Exception
      //   509	525	4422	java/lang/Exception
      //   533	540	4422	java/lang/Exception
      //   548	558	4422	java/lang/Exception
      //   566	579	4422	java/lang/Exception
      //   587	608	4422	java/lang/Exception
      //   616	628	4422	java/lang/Exception
      //   636	667	4422	java/lang/Exception
      //   675	688	4422	java/lang/Exception
      //   696	705	4422	java/lang/Exception
      //   713	725	4422	java/lang/Exception
      //   733	738	4422	java/lang/Exception
      //   746	754	4422	java/lang/Exception
      //   762	770	4422	java/lang/Exception
      //   778	787	4422	java/lang/Exception
      //   795	803	4422	java/lang/Exception
      //   811	828	4422	java/lang/Exception
      //   836	846	4422	java/lang/Exception
      //   854	863	4422	java/lang/Exception
      //   871	876	4422	java/lang/Exception
      //   901	906	4422	java/lang/Exception
      //   914	919	4422	java/lang/Exception
      //   1268	1278	4422	java/lang/Exception
      //   1294	1299	4438	java/lang/Exception
      //   934	941	4451	java/lang/Exception
      //   953	984	4451	java/lang/Exception
      //   2720	2725	4464	java/lang/Exception
      //   2549	2556	4480	java/lang/Exception
      //   2568	2599	4480	java/lang/Exception
      //   1523	1540	4504	java/lang/Exception
      //   3033	3044	4514	java/lang/Exception
      //   3048	3062	4514	java/lang/Exception
      //   3521	3535	4514	java/lang/Exception
      //   3070	3076	4530	java/lang/Exception
      //   3084	3097	4530	java/lang/Exception
      //   3105	3113	4530	java/lang/Exception
      //   3121	3137	4530	java/lang/Exception
      //   3145	3154	4530	java/lang/Exception
      //   3162	3172	4530	java/lang/Exception
      //   3180	3193	4530	java/lang/Exception
      //   3201	3222	4530	java/lang/Exception
      //   3230	3244	4530	java/lang/Exception
      //   3252	3283	4530	java/lang/Exception
      //   3291	3304	4530	java/lang/Exception
      //   3312	3328	4530	java/lang/Exception
      //   3336	3344	4530	java/lang/Exception
      //   3352	3362	4530	java/lang/Exception
      //   3370	3380	4530	java/lang/Exception
      //   3388	3396	4530	java/lang/Exception
      //   3404	3412	4530	java/lang/Exception
      //   3420	3436	4530	java/lang/Exception
      //   3444	3454	4530	java/lang/Exception
      //   3462	3471	4530	java/lang/Exception
      //   3479	3484	4530	java/lang/Exception
      //   3553	3558	4530	java/lang/Exception
      //   3566	3571	4530	java/lang/Exception
      //   3719	3728	4530	java/lang/Exception
      //   3740	3745	4550	java/lang/Exception
      //   3586	3593	4567	java/lang/Exception
      //   3605	3636	4567	java/lang/Exception
    }
  }
  
  public static abstract interface b
  {
    public abstract void i(String paramString1, String paramString2, int paramInt);
  }
  
  final class c
  {
    String filename;
    boolean ltj;
    String ltk;
    int pos;
    String url;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(150159);
      this.ltj = false;
      this.url = paramString1;
      if (ag.this.lsY) {
        this.url = t.Wm(this.url);
      }
      this.filename = paramString2;
      this.pos = paramInt;
      this.ltj = false;
      this.ltk = paramString3;
      AppMethodBeat.o(150159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ag
 * JD-Core Version:    0.7.0.1
 */