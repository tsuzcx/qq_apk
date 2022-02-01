package com.tencent.mm.modelsimple;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.k.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.fbl;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.qbar.a.a;
import com.tencent.qbar.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private c oDw;
  private List<String> oSh;
  private String oSi;
  private int type;
  
  public i(int paramInt, List<String> paramList, String paramString)
  {
    this.type = paramInt;
    this.oSh = paramList;
    this.oSi = paramString;
  }
  
  /* Error */
  private void cg(List<String> paramList)
  {
    // Byte code:
    //   0: sipush 20604
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 43	com/tencent/mm/modelsimple/i:oDw	Lcom/tencent/mm/am/c;
    //   10: getfield 49	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   13: invokestatic 55	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   16: checkcast 57	com/tencent/mm/protocal/protobuf/abl
    //   19: astore 7
    //   21: aload 7
    //   23: iconst_3
    //   24: putfield 60	com/tencent/mm/protocal/protobuf/abl:vhJ	I
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
    //   74: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: new 97	com/tencent/mm/protocal/protobuf/fbp
    //   80: dup
    //   81: invokespecial 98	com/tencent/mm/protocal/protobuf/fbp:<init>	()V
    //   84: astore 10
    //   86: new 100	com/tencent/mm/compatible/i/d
    //   89: dup
    //   90: invokespecial 101	com/tencent/mm/compatible/i/d:<init>	()V
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
    //   116: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   138: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 5
    //   143: astore_1
    //   144: aload 10
    //   146: iload_2
    //   147: putfield 128	com/tencent/mm/protocal/protobuf/fbp:abzG	I
    //   150: aload 5
    //   152: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   155: aload 10
    //   157: aload 9
    //   159: invokestatic 137	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   162: putfield 140	com/tencent/mm/protocal/protobuf/fbp:MD5	Ljava/lang/String;
    //   165: aload 7
    //   167: getfield 144	com/tencent/mm/protocal/protobuf/abl:ZjZ	Ljava/util/LinkedList;
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
    //   196: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   233: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   266: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   310: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   335: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: sipush 20604
    //   341: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: return
    //   345: astore 5
    //   347: goto -71 -> 276
    //   350: astore 6
    //   352: goto -145 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	i
    //   0	355	1	paramList	List<String>
    //   119	28	2	i	int
    //   30	300	3	l	long
    //   93	149	5	locald	com.tencent.mm.compatible.i.d
    //   272	19	5	localObject1	Object
    //   345	1	5	localObject2	Object
    //   202	26	6	localException1	java.lang.Exception
    //   350	1	6	localException2	java.lang.Exception
    //   19	147	7	localabl	abl
    //   37	13	8	localIterator	Iterator
    //   59	164	9	str	String
    //   84	87	10	localfbp	com.tencent.mm.protocal.protobuf.fbp
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
  
  private void ch(List<String> paramList)
  {
    AppMethodBeat.i(20605);
    abl localabl = (abl)c.b.b(this.oDw.otB);
    localabl.vhJ = 5;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Log.i("MicroMsg.NetSceneCheckSysShare", "share text %s", new Object[] { str });
      int i = str.indexOf("|");
      fbo localfbo = new fbo();
      if ((i >= 0) && (i + 1 < str.length())) {
        localfbo.hAP = str.substring(0, i);
      }
      for (localfbo.URL = str.substring(i + 1);; localfbo.URL = str)
      {
        localfbo.MD5 = com.tencent.mm.b.g.getMessageDigest(localfbo.URL.getBytes());
        localabl.Zkc.add(localfbo);
        break;
        localfbo.hAP = "";
      }
    }
    Log.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20605);
  }
  
  private void ci(List<String> paramList)
  {
    AppMethodBeat.i(20606);
    abl localabl = (abl)c.b.b(this.oDw.otB);
    localabl.vhJ = 4;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      fbl localfbl = new fbl();
      localObject = new u((String)localObject);
      localfbl.Nju = ((int)((u)localObject).length());
      localfbl.MD5 = y.bub(ah.v(((u)localObject).mUri));
      localabl.Zkb.add(localfbl);
    }
    Log.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20606);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20607);
    this.callback = paramh;
    paramh = new c.a();
    abl localabl = new abl();
    if (!Util.isNullOrNil(this.oSi)) {
      localabl.ZjX = this.oSi;
    }
    paramh.otE = localabl;
    paramh.otF = new abm();
    paramh.uri = "/cgi-bin/micromsg-bin/checksystemshare";
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.oDw = paramh.bEF();
    switch (this.type)
    {
    }
    for (;;)
    {
      i = 1;
      if (com.tencent.mm.kernel.h.baz()) {
        i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("ShareExtCheckSwitch"), 1);
      }
      if (i == 1) {
        break;
      }
      this.callback.onSceneEnd(0, 0, "need not check", this);
      AppMethodBeat.o(20607);
      return 0;
      paramh = this.oSh;
      localabl = (abl)c.b.b(this.oDw.otB);
      localabl.vhJ = 1;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      long l4 = System.currentTimeMillis();
      long l3 = 0L;
      long l2 = 0L;
      long l1 = 0L;
      Iterator localIterator = paramh.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.i("MicroMsg.NetSceneCheckSysShare", "img file %s", new Object[] { str });
        fbn localfbn = new fbn();
        localfbn.MD5 = com.tencent.mm.b.g.getMD5(str);
        l3 = System.currentTimeMillis();
        MMBitmapFactory.decodeFile(str, localOptions);
        Log.i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
        localfbn.Width = localOptions.outWidth;
        localfbn.Height = localOptions.outHeight;
        l2 = System.currentTimeMillis();
        boolean bool = b.k(MMApplicationContext.getContext(), "android.permission.READ_EXTERNAL_STORAGE", false);
        Log.i("MicroMsg.NetSceneCheckSysShare", "checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramh = MMApplicationContext.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { str }, null);
          if (paramh != null) {
            if (paramh.moveToFirst())
            {
              i = paramh.getInt(paramh.getColumnIndex("_id"));
              paramh.close();
              paramh = MediaStore.Images.Thumbnails.getThumbnail(MMApplicationContext.getContext().getContentResolver(), i, 1, null);
              label501:
              if (paramh == null) {
                break label637;
              }
              Log.i("MicroMsg.NetSceneCheckSysShare", "have thumbnail(w:%d, h:%d)", new Object[] { Integer.valueOf(paramh.getWidth()), Integer.valueOf(paramh.getHeight()) });
            }
          }
        }
        label637:
        for (paramh = a.b(paramh, new int[] { 0 });; paramh = a.b(BitmapUtil.decodeFileWithSample(str), new int[] { 0 }))
        {
          l1 = System.currentTimeMillis();
          if (paramh != null)
          {
            Log.i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", new Object[] { paramh.typeName, paramh.data });
            if (!Util.isNullOrNil(paramh.typeName))
            {
              localfbn.abBn = paramh.typeName;
              localfbn.abvZ = paramh.data;
            }
          }
          localabl.ZjY.add(localfbn);
          break;
          paramh.close();
          paramh = null;
          break label501;
        }
      }
      Log.i("MicroMsg.NetSceneCheckSysShare", "cost %d(%d, %d, %d)ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l4), Long.valueOf(l3 - l4), Long.valueOf(l2 - l3), Long.valueOf(l1 - l2) });
      continue;
      cg(this.oSh);
      continue;
      ch(this.oSh);
      continue;
      ci(this.oSh);
    }
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(20607);
    return i;
  }
  
  public final int getType()
  {
    return 837;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20608);
    Log.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.i
 * JD-Core Version:    0.7.0.1
 */