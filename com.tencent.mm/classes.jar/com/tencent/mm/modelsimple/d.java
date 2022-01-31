package com.tencent.mm.modelsimple;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brn;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.protocal.c.brq;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.util.c;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends m
  implements k
{
  private f dmL;
  private b esv;
  private List<String> eyS;
  private String eyT;
  private int type;
  
  public d(int paramInt, List<String> paramList, String paramString)
  {
    this.type = paramInt;
    this.eyS = paramList;
    this.eyT = paramString;
  }
  
  /* Error */
  private void X(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mm/modelsimple/d:esv	Lcom/tencent/mm/ah/b;
    //   4: getfield 43	com/tencent/mm/ah/b:ecE	Lcom/tencent/mm/ah/b$b;
    //   7: getfield 49	com/tencent/mm/ah/b$b:ecN	Lcom/tencent/mm/bv/a;
    //   10: checkcast 51	com/tencent/mm/protocal/c/po
    //   13: astore 7
    //   15: aload 7
    //   17: iconst_3
    //   18: putfield 54	com/tencent/mm/protocal/c/po:hQR	I
    //   21: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   24: lstore_3
    //   25: aload_1
    //   26: invokeinterface 66 1 0
    //   31: astore 8
    //   33: aload 8
    //   35: invokeinterface 72 1 0
    //   40: ifeq +271 -> 311
    //   43: aload 8
    //   45: invokeinterface 76 1 0
    //   50: checkcast 78	java/lang/String
    //   53: astore 9
    //   55: ldc 80
    //   57: ldc 82
    //   59: iconst_1
    //   60: anewarray 84	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload 9
    //   67: aastore
    //   68: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 92	com/tencent/mm/protocal/c/brr
    //   74: dup
    //   75: invokespecial 93	com/tencent/mm/protocal/c/brr:<init>	()V
    //   78: astore 10
    //   80: new 95	android/media/MediaMetadataRetriever
    //   83: dup
    //   84: invokespecial 96	android/media/MediaMetadataRetriever:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: astore_1
    //   92: aload 5
    //   94: aload 9
    //   96: invokevirtual 100	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   99: aload 5
    //   101: astore_1
    //   102: aload 5
    //   104: bipush 9
    //   106: invokevirtual 104	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: iconst_m1
    //   110: invokestatic 110	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   113: istore_2
    //   114: aload 5
    //   116: astore_1
    //   117: ldc 80
    //   119: ldc 112
    //   121: iconst_1
    //   122: anewarray 84	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: iload_2
    //   128: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload 5
    //   137: astore_1
    //   138: aload 10
    //   140: iload_2
    //   141: putfield 121	com/tencent/mm/protocal/c/brr:tIl	I
    //   144: aload 5
    //   146: invokevirtual 124	android/media/MediaMetadataRetriever:release	()V
    //   149: aload 10
    //   151: new 126	java/io/File
    //   154: dup
    //   155: aload 9
    //   157: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: invokestatic 134	com/tencent/xweb/util/c:m	(Ljava/io/File;)Ljava/lang/String;
    //   163: putfield 137	com/tencent/mm/protocal/c/brr:sRE	Ljava/lang/String;
    //   166: aload 7
    //   168: getfield 141	com/tencent/mm/protocal/c/po:sNs	Ljava/util/LinkedList;
    //   171: aload 10
    //   173: invokevirtual 147	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   176: pop
    //   177: goto -144 -> 33
    //   180: astore_1
    //   181: ldc 80
    //   183: aload_1
    //   184: ldc 149
    //   186: iconst_1
    //   187: anewarray 84	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: aastore
    //   197: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: goto -51 -> 149
    //   203: astore 6
    //   205: aconst_null
    //   206: astore 5
    //   208: aload 5
    //   210: astore_1
    //   211: ldc 80
    //   213: aload 6
    //   215: ldc 159
    //   217: iconst_2
    //   218: anewarray 84	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload 9
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload 6
    //   230: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload 5
    //   239: ifnull -90 -> 149
    //   242: aload 5
    //   244: invokevirtual 124	android/media/MediaMetadataRetriever:release	()V
    //   247: goto -98 -> 149
    //   250: astore_1
    //   251: ldc 80
    //   253: aload_1
    //   254: ldc 149
    //   256: iconst_1
    //   257: anewarray 84	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_1
    //   263: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: goto -121 -> 149
    //   273: astore 5
    //   275: aconst_null
    //   276: astore_1
    //   277: aload_1
    //   278: ifnull +7 -> 285
    //   281: aload_1
    //   282: invokevirtual 124	android/media/MediaMetadataRetriever:release	()V
    //   285: aload 5
    //   287: athrow
    //   288: astore_1
    //   289: ldc 80
    //   291: aload_1
    //   292: ldc 149
    //   294: iconst_1
    //   295: anewarray 84	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_1
    //   301: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 157	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -23 -> 285
    //   311: ldc 80
    //   313: ldc 161
    //   315: iconst_1
    //   316: anewarray 84	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   324: lload_3
    //   325: lsub
    //   326: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   329: aastore
    //   330: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: return
    //   334: astore 5
    //   336: goto -59 -> 277
    //   339: astore 6
    //   341: goto -133 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	d
    //   0	344	1	paramList	List<String>
    //   113	28	2	i	int
    //   24	301	3	l	long
    //   87	156	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   273	13	5	localObject1	Object
    //   334	1	5	localObject2	Object
    //   203	26	6	localException1	java.lang.Exception
    //   339	1	6	localException2	java.lang.Exception
    //   13	154	7	localpo	po
    //   31	13	8	localIterator	Iterator
    //   53	171	9	str	String
    //   78	94	10	localbrr	com.tencent.mm.protocal.c.brr
    // Exception table:
    //   from	to	target	type
    //   144	149	180	java/lang/Exception
    //   80	89	203	java/lang/Exception
    //   242	247	250	java/lang/Exception
    //   80	89	273	finally
    //   281	285	288	java/lang/Exception
    //   92	99	334	finally
    //   102	114	334	finally
    //   117	135	334	finally
    //   138	144	334	finally
    //   211	237	334	finally
    //   92	99	339	java/lang/Exception
    //   102	114	339	java/lang/Exception
    //   117	135	339	java/lang/Exception
    //   138	144	339	java/lang/Exception
  }
  
  private void Y(List<String> paramList)
  {
    po localpo = (po)this.esv.ecE.ecN;
    localpo.hQR = 5;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      y.i("MicroMsg.NetSceneCheckSysShare", "share text %s", new Object[] { str });
      int i = str.indexOf("|");
      brq localbrq = new brq();
      if ((i >= 0) && (i + 1 < str.length())) {
        localbrq.bGw = str.substring(0, i);
      }
      for (localbrq.URL = str.substring(i + 1);; localbrq.URL = str)
      {
        localbrq.sRE = c.o(localbrq.URL.getBytes());
        localpo.sNv.add(localbrq);
        break;
        localbrq.bGw = "";
      }
    }
    y.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void Z(List<String> paramList)
  {
    po localpo = (po)this.esv.ecE.ecN;
    localpo.hQR = 4;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      brn localbrn = new brn();
      localObject = new File((String)localObject);
      localbrn.ndo = ((int)((File)localObject).length());
      localbrn.sRE = c.m((File)localObject);
      localpo.sNu.add(localbrn);
    }
    y.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    Object localObject = new po();
    if (!bk.bl(this.eyT)) {
      ((po)localObject).sNq = this.eyT;
    }
    paramf.ecH = ((com.tencent.mm.bv.a)localObject);
    paramf.ecI = new pp();
    paramf.uri = "/cgi-bin/micromsg-bin/checksystemshare";
    paramf.ecG = 837;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.esv = paramf.Kt();
    int i;
    long l4;
    long l2;
    long l3;
    long l1;
    label235:
    brp localbrp;
    switch (this.type)
    {
    case 2: 
    default: 
      i = 1;
      if (com.tencent.mm.kernel.g.DK()) {
        i = bk.getInt(com.tencent.mm.m.g.AA().getValue("ShareExtCheckSwitch"), 1);
      }
      if (i != 1)
      {
        this.dmL.onSceneEnd(0, 0, "need not check", this);
        return 0;
      }
      break;
    case 1: 
      paramf = this.eyS;
      po localpo = (po)this.esv.ecE.ecN;
      localpo.hQR = 1;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      l4 = System.currentTimeMillis();
      l2 = 0L;
      l3 = 0L;
      Iterator localIterator = paramf.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        y.i("MicroMsg.NetSceneCheckSysShare", "img file %s", new Object[] { localObject });
        paramf = com.tencent.mm.a.e.c((String)localObject, 0, -1);
        if ((paramf == null) || (paramf.length <= 0)) {
          break label813;
        }
        localbrp = new brp();
        localbrp.sRE = c.o(paramf);
        l2 = System.currentTimeMillis();
        MMBitmapFactory.decodeByteArray(paramf, 0, paramf.length, localOptions);
        y.i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
        localbrp.Width = localOptions.outWidth;
        localbrp.Height = localOptions.outHeight;
        l3 = System.currentTimeMillis();
        paramf = ae.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { localObject }, null);
        if (paramf != null) {
          if (paramf.moveToFirst())
          {
            i = paramf.getInt(paramf.getColumnIndex("_id"));
            paramf.close();
            paramf = MediaStore.Images.Thumbnails.getThumbnail(ae.getContext().getContentResolver(), i, 1, null);
            label468:
            if (paramf == null) {
              break label635;
            }
            localObject = new com.tencent.mm.plugin.ad.a.a().b(paramf, 0);
            y.i("MicroMsg.NetSceneCheckSysShare", "have thumbnail(w:%d, h:%d)", new Object[] { Integer.valueOf(paramf.getWidth()), Integer.valueOf(paramf.getHeight()) });
            paramf = (f)localObject;
            label521:
            l1 = System.currentTimeMillis();
            if (paramf != null)
            {
              y.i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", new Object[] { paramf.nkn, paramf.result });
              if (!bk.bl(paramf.nkn))
              {
                if ((!paramf.nkn.equals("QR_CODE")) && (!paramf.nkn.equals("WX_CODE"))) {
                  break label651;
                }
                localbrp.tFz = paramf.result;
                label601:
                localbrp.tIk = paramf.nkn;
              }
            }
            localpo.sNr.add(localbrp);
          }
        }
      }
      break;
    }
    label651:
    label813:
    for (;;)
    {
      break label235;
      paramf.close();
      paramf = null;
      break label468;
      label635:
      paramf = new com.tencent.mm.plugin.ad.a.a().Lu((String)localObject);
      break label521;
      i = paramf.result.indexOf(",");
      if ((i >= 0) && (i + 1 < paramf.result.length()))
      {
        localbrp.tFz = paramf.result.substring(i + 1);
        break label601;
      }
      localbrp.tFz = paramf.result;
      break label601;
      y.i("MicroMsg.NetSceneCheckSysShare", "cost %d(%d, %d, %d)ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l4), Long.valueOf(l2 - l4), Long.valueOf(l3 - l2), Long.valueOf(l1 - l3) });
      break;
      X(this.eyS);
      break;
      Y(this.eyS);
      break;
      Z(this.eyS);
      break;
      return a(parame, this.esv, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 837;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.d
 * JD-Core Version:    0.7.0.1
 */