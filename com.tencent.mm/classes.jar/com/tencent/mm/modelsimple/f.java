package com.tencent.mm.modelsimple;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.qbar.a.a;
import com.tencent.qbar.a.a;
import com.tencent.xweb.util.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private b hdD;
  private List<String> hrl;
  private String hrm;
  private int type;
  
  public f(int paramInt, List<String> paramList, String paramString)
  {
    this.type = paramInt;
    this.hrl = paramList;
    this.hrm = paramString;
  }
  
  /* Error */
  private void aw(List<String> paramList)
  {
    // Byte code:
    //   0: sipush 20604
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 43	com/tencent/mm/modelsimple/f:hdD	Lcom/tencent/mm/al/b;
    //   10: getfield 49	com/tencent/mm/al/b:gUS	Lcom/tencent/mm/al/b$b;
    //   13: getfield 55	com/tencent/mm/al/b$b:gUX	Lcom/tencent/mm/bx/a;
    //   16: checkcast 57	com/tencent/mm/protocal/protobuf/vl
    //   19: astore 7
    //   21: aload 7
    //   23: iconst_3
    //   24: putfield 60	com/tencent/mm/protocal/protobuf/vl:mBH	I
    //   27: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   30: lstore_3
    //   31: aload_1
    //   32: invokeinterface 72 1 0
    //   37: astore 8
    //   39: aload 8
    //   41: invokeinterface 78 1 0
    //   46: ifeq +270 -> 316
    //   49: aload 8
    //   51: invokeinterface 82 1 0
    //   56: checkcast 84	java/lang/String
    //   59: astore 9
    //   61: ldc 86
    //   63: ldc 88
    //   65: iconst_1
    //   66: anewarray 90	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 9
    //   73: aastore
    //   74: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: new 97	com/tencent/mm/protocal/protobuf/csu
    //   80: dup
    //   81: invokespecial 98	com/tencent/mm/protocal/protobuf/csu:<init>	()V
    //   84: astore 10
    //   86: new 100	com/tencent/mm/compatible/h/d
    //   89: dup
    //   90: invokespecial 101	com/tencent/mm/compatible/h/d:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: astore_1
    //   98: aload 5
    //   100: aload 9
    //   102: invokevirtual 107	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   105: aload 5
    //   107: astore_1
    //   108: aload 5
    //   110: bipush 9
    //   112: invokevirtual 111	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   115: iconst_m1
    //   116: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   119: istore_2
    //   120: aload 5
    //   122: astore_1
    //   123: ldc 86
    //   125: ldc 119
    //   127: iconst_1
    //   128: anewarray 90	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iload_2
    //   134: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 5
    //   143: astore_1
    //   144: aload 10
    //   146: iload_2
    //   147: putfield 128	com/tencent/mm/protocal/protobuf/csu:Ekx	I
    //   150: aload 5
    //   152: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   155: aload 10
    //   157: aload 9
    //   159: invokestatic 137	com/tencent/mm/vfs/i:aEN	(Ljava/lang/String;)Ljava/lang/String;
    //   162: putfield 140	com/tencent/mm/protocal/protobuf/csu:MD5	Ljava/lang/String;
    //   165: aload 7
    //   167: getfield 144	com/tencent/mm/protocal/protobuf/vl:CXA	Ljava/util/LinkedList;
    //   170: aload 10
    //   172: invokevirtual 150	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   175: pop
    //   176: goto -137 -> 39
    //   179: astore_1
    //   180: ldc 86
    //   182: aload_1
    //   183: ldc 152
    //   185: iconst_1
    //   186: anewarray 90	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_1
    //   192: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: goto -44 -> 155
    //   202: astore 6
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: astore_1
    //   210: ldc 86
    //   212: aload 6
    //   214: ldc 162
    //   216: iconst_2
    //   217: anewarray 90	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload 9
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: aload 6
    //   229: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload 5
    //   238: ifnull -83 -> 155
    //   241: aload 5
    //   243: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   246: goto -91 -> 155
    //   249: astore_1
    //   250: ldc 86
    //   252: aload_1
    //   253: ldc 152
    //   255: iconst_1
    //   256: anewarray 90	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload_1
    //   262: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   265: aastore
    //   266: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: goto -114 -> 155
    //   272: astore 5
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_1
    //   277: ifnull +7 -> 284
    //   280: aload_1
    //   281: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   284: sipush 20604
    //   287: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload 5
    //   292: athrow
    //   293: astore_1
    //   294: ldc 86
    //   296: aload_1
    //   297: ldc 152
    //   299: iconst_1
    //   300: anewarray 90	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload_1
    //   306: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   309: aastore
    //   310: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: goto -29 -> 284
    //   316: ldc 86
    //   318: ldc 167
    //   320: iconst_1
    //   321: anewarray 90	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   329: lload_3
    //   330: lsub
    //   331: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   334: aastore
    //   335: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: sipush 20604
    //   341: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: return
    //   345: astore 5
    //   347: goto -71 -> 276
    //   350: astore 6
    //   352: goto -145 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	f
    //   0	355	1	paramList	List<String>
    //   119	28	2	i	int
    //   30	300	3	l	long
    //   93	149	5	locald	com.tencent.mm.compatible.h.d
    //   272	19	5	localObject1	Object
    //   345	1	5	localObject2	Object
    //   202	26	6	localException1	java.lang.Exception
    //   350	1	6	localException2	java.lang.Exception
    //   19	147	7	localvl	vl
    //   37	13	8	localIterator	Iterator
    //   59	164	9	str	String
    //   84	87	10	localcsu	com.tencent.mm.protocal.protobuf.csu
    // Exception table:
    //   from	to	target	type
    //   150	155	179	java/lang/Exception
    //   86	95	202	java/lang/Exception
    //   241	246	249	java/lang/Exception
    //   86	95	272	finally
    //   280	284	293	java/lang/Exception
    //   98	105	345	finally
    //   108	120	345	finally
    //   123	141	345	finally
    //   144	150	345	finally
    //   210	236	345	finally
    //   98	105	350	java/lang/Exception
    //   108	120	350	java/lang/Exception
    //   123	141	350	java/lang/Exception
    //   144	150	350	java/lang/Exception
  }
  
  private void ax(List<String> paramList)
  {
    AppMethodBeat.i(20605);
    vl localvl = (vl)this.hdD.gUS.gUX;
    localvl.mBH = 5;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ad.i("MicroMsg.NetSceneCheckSysShare", "share text %s", new Object[] { str });
      int i = str.indexOf("|");
      cst localcst = new cst();
      if ((i >= 0) && (i + 1 < str.length())) {
        localcst.Title = str.substring(0, i);
      }
      for (localcst.URL = str.substring(i + 1);; localcst.URL = str)
      {
        localcst.MD5 = d.getMessageDigest(localcst.URL.getBytes());
        localvl.CXD.add(localcst);
        break;
        localcst.Title = "";
      }
    }
    ad.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20605);
  }
  
  private void ay(List<String> paramList)
  {
    AppMethodBeat.i(20606);
    vl localvl = (vl)this.hdD.gUS.gUX;
    localvl.mBH = 4;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      csq localcsq = new csq();
      localObject = new com.tencent.mm.vfs.e((String)localObject);
      localcsq.FileSize = ((int)((com.tencent.mm.vfs.e)localObject).length());
      localcsq.MD5 = i.aEN(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).mUri));
      localvl.CXC.add(localcsq);
    }
    ad.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20606);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(20607);
    this.callback = paramg;
    paramg = new b.a();
    vl localvl = new vl();
    if (!bt.isNullOrNil(this.hrm)) {
      localvl.CXy = this.hrm;
    }
    paramg.gUU = localvl;
    paramg.gUV = new vm();
    paramg.uri = "/cgi-bin/micromsg-bin/checksystemshare";
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.hdD = paramg.atI();
    int i;
    long l4;
    long l2;
    long l3;
    long l1;
    label249:
    String str;
    switch (this.type)
    {
    case 2: 
    default: 
      i = 1;
      if (com.tencent.mm.kernel.g.afw()) {
        i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("ShareExtCheckSwitch"), 1);
      }
      if (i != 1)
      {
        this.callback.onSceneEnd(0, 0, "need not check", this);
        AppMethodBeat.o(20607);
        return 0;
      }
      break;
    case 1: 
      paramg = this.hrl;
      localvl = (vl)this.hdD.gUS.gUX;
      localvl.mBH = 1;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      l4 = System.currentTimeMillis();
      l2 = 0L;
      l3 = 0L;
      Iterator localIterator = paramg.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        ad.i("MicroMsg.NetSceneCheckSysShare", "img file %s", new Object[] { str });
        paramg = i.aR(str, 0, -1);
        if ((paramg == null) || (paramg.length <= 0)) {
          break label749;
        }
        css localcss = new css();
        localcss.MD5 = d.getMessageDigest(paramg);
        l2 = System.currentTimeMillis();
        MMBitmapFactory.decodeByteArray(paramg, 0, paramg.length, localOptions);
        ad.i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
        localcss.Width = localOptions.outWidth;
        localcss.Height = localOptions.outHeight;
        l3 = System.currentTimeMillis();
        paramg = aj.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { str }, null);
        if (paramg != null) {
          if (paramg.moveToFirst())
          {
            i = paramg.getInt(paramg.getColumnIndex("_id"));
            paramg.close();
            paramg = MediaStore.Images.Thumbnails.getThumbnail(aj.getContext().getContentResolver(), i, 1, null);
            label482:
            if (paramg == null) {
              break label618;
            }
            ad.i("MicroMsg.NetSceneCheckSysShare", "have thumbnail(w:%d, h:%d)", new Object[] { Integer.valueOf(paramg.getWidth()), Integer.valueOf(paramg.getHeight()) });
            paramg = a.b(paramg, new int[] { 0 });
            label530:
            l1 = System.currentTimeMillis();
            if (paramg != null)
            {
              ad.i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", new Object[] { paramg.typeName, paramg.data });
              if (!bt.isNullOrNil(paramg.typeName))
              {
                localcss.Ekw = paramg.typeName;
                localcss.EgH = paramg.data;
              }
            }
            localvl.CXz.add(localcss);
          }
        }
      }
      break;
    }
    label618:
    label749:
    for (;;)
    {
      break label249;
      paramg.close();
      paramg = null;
      break label482;
      paramg = a.b(com.tencent.mm.sdk.platformtools.f.aFj(str), new int[] { 0 });
      break label530;
      ad.i("MicroMsg.NetSceneCheckSysShare", "cost %d(%d, %d, %d)ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l4), Long.valueOf(l2 - l4), Long.valueOf(l3 - l2), Long.valueOf(l1 - l3) });
      break;
      aw(this.hrl);
      break;
      ax(this.hrl);
      break;
      ay(this.hrl);
      break;
      i = dispatch(parame, this.hdD, this);
      AppMethodBeat.o(20607);
      return i;
    }
  }
  
  public final int getType()
  {
    return 837;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20608);
    ad.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.f
 * JD-Core Version:    0.7.0.1
 */