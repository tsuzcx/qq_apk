package com.tencent.mm.modelsimple;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private b fBd;
  private List<String> fOH;
  private String fOI;
  private int type;
  
  public f(int paramInt, List<String> paramList, String paramString)
  {
    this.type = paramInt;
    this.fOH = paramList;
    this.fOI = paramString;
  }
  
  /* Error */
  private void ae(List<String> paramList)
  {
    // Byte code:
    //   0: sipush 16559
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 43	com/tencent/mm/modelsimple/f:fBd	Lcom/tencent/mm/ai/b;
    //   10: getfield 49	com/tencent/mm/ai/b:fsV	Lcom/tencent/mm/ai/b$b;
    //   13: getfield 55	com/tencent/mm/ai/b$b:fta	Lcom/tencent/mm/bv/a;
    //   16: checkcast 57	com/tencent/mm/protocal/protobuf/ss
    //   19: astore 7
    //   21: aload 7
    //   23: iconst_3
    //   24: putfield 60	com/tencent/mm/protocal/protobuf/ss:jKs	I
    //   27: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   30: lstore_3
    //   31: aload_1
    //   32: invokeinterface 72 1 0
    //   37: astore 8
    //   39: aload 8
    //   41: invokeinterface 78 1 0
    //   46: ifeq +277 -> 323
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
    //   74: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: new 97	com/tencent/mm/protocal/protobuf/ccc
    //   80: dup
    //   81: invokespecial 98	com/tencent/mm/protocal/protobuf/ccc:<init>	()V
    //   84: astore 10
    //   86: new 100	android/media/MediaMetadataRetriever
    //   89: dup
    //   90: invokespecial 101	android/media/MediaMetadataRetriever:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: astore_1
    //   98: aload 5
    //   100: aload 9
    //   102: invokevirtual 105	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   105: aload 5
    //   107: astore_1
    //   108: aload 5
    //   110: bipush 9
    //   112: invokevirtual 109	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   115: iconst_m1
    //   116: invokestatic 115	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   119: istore_2
    //   120: aload 5
    //   122: astore_1
    //   123: ldc 86
    //   125: ldc 117
    //   127: iconst_1
    //   128: anewarray 90	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iload_2
    //   134: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 5
    //   143: astore_1
    //   144: aload 10
    //   146: iload_2
    //   147: putfield 126	com/tencent/mm/protocal/protobuf/ccc:xMz	I
    //   150: aload 5
    //   152: invokevirtual 129	android/media/MediaMetadataRetriever:release	()V
    //   155: aload 10
    //   157: new 131	java/io/File
    //   160: dup
    //   161: aload 9
    //   163: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: invokestatic 139	com/tencent/xweb/util/d:r	(Ljava/io/File;)Ljava/lang/String;
    //   169: putfield 142	com/tencent/mm/protocal/protobuf/ccc:wQr	Ljava/lang/String;
    //   172: aload 7
    //   174: getfield 146	com/tencent/mm/protocal/protobuf/ss:wLi	Ljava/util/LinkedList;
    //   177: aload 10
    //   179: invokevirtual 152	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   182: pop
    //   183: goto -144 -> 39
    //   186: astore_1
    //   187: ldc 86
    //   189: aload_1
    //   190: ldc 154
    //   192: iconst_1
    //   193: anewarray 90	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -51 -> 155
    //   209: astore 6
    //   211: aconst_null
    //   212: astore 5
    //   214: aload 5
    //   216: astore_1
    //   217: ldc 86
    //   219: aload 6
    //   221: ldc 164
    //   223: iconst_2
    //   224: anewarray 90	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload 9
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: aload 6
    //   236: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: aastore
    //   240: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload 5
    //   245: ifnull -90 -> 155
    //   248: aload 5
    //   250: invokevirtual 129	android/media/MediaMetadataRetriever:release	()V
    //   253: goto -98 -> 155
    //   256: astore_1
    //   257: ldc 86
    //   259: aload_1
    //   260: ldc 154
    //   262: iconst_1
    //   263: anewarray 90	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload_1
    //   269: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: aastore
    //   273: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: goto -121 -> 155
    //   279: astore 5
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 129	android/media/MediaMetadataRetriever:release	()V
    //   291: sipush 16559
    //   294: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aload 5
    //   299: athrow
    //   300: astore_1
    //   301: ldc 86
    //   303: aload_1
    //   304: ldc 154
    //   306: iconst_1
    //   307: anewarray 90	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload_1
    //   313: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: goto -29 -> 291
    //   323: ldc 86
    //   325: ldc 169
    //   327: iconst_1
    //   328: anewarray 90	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   336: lload_3
    //   337: lsub
    //   338: invokestatic 174	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   341: aastore
    //   342: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: sipush 16559
    //   348: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: return
    //   352: astore 5
    //   354: goto -71 -> 283
    //   357: astore 6
    //   359: goto -145 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	f
    //   0	362	1	paramList	List<String>
    //   119	28	2	i	int
    //   30	307	3	l	long
    //   93	156	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   279	19	5	localObject1	Object
    //   352	1	5	localObject2	Object
    //   209	26	6	localException1	java.lang.Exception
    //   357	1	6	localException2	java.lang.Exception
    //   19	154	7	localss	ss
    //   37	13	8	localIterator	Iterator
    //   59	171	9	str	String
    //   84	94	10	localccc	com.tencent.mm.protocal.protobuf.ccc
    // Exception table:
    //   from	to	target	type
    //   150	155	186	java/lang/Exception
    //   86	95	209	java/lang/Exception
    //   248	253	256	java/lang/Exception
    //   86	95	279	finally
    //   287	291	300	java/lang/Exception
    //   98	105	352	finally
    //   108	120	352	finally
    //   123	141	352	finally
    //   144	150	352	finally
    //   217	243	352	finally
    //   98	105	357	java/lang/Exception
    //   108	120	357	java/lang/Exception
    //   123	141	357	java/lang/Exception
    //   144	150	357	java/lang/Exception
  }
  
  private void af(List<String> paramList)
  {
    AppMethodBeat.i(16560);
    ss localss = (ss)this.fBd.fsV.fta;
    localss.jKs = 5;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ab.i("MicroMsg.NetSceneCheckSysShare", "share text %s", new Object[] { str });
      int i = str.indexOf("|");
      ccb localccb = new ccb();
      if ((i >= 0) && (i + 1 < str.length())) {
        localccb.Title = str.substring(0, i);
      }
      for (localccb.URL = str.substring(i + 1);; localccb.URL = str)
      {
        localccb.wQr = com.tencent.xweb.util.d.w(localccb.URL.getBytes());
        localss.wLl.add(localccb);
        break;
        localccb.Title = "";
      }
    }
    ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(16560);
  }
  
  private void ag(List<String> paramList)
  {
    AppMethodBeat.i(16561);
    ss localss = (ss)this.fBd.fsV.fta;
    localss.jKs = 4;
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      cby localcby = new cby();
      localObject = new File((String)localObject);
      localcby.FileSize = ((int)((File)localObject).length());
      localcby.wQr = com.tencent.xweb.util.d.r((File)localObject);
      localss.wLk.add(localcby);
    }
    ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(16561);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(16562);
    this.callback = paramf;
    paramf = new b.a();
    Object localObject = new ss();
    if (!bo.isNullOrNil(this.fOI)) {
      ((ss)localObject).wLg = this.fOI;
    }
    paramf.fsX = ((com.tencent.mm.bv.a)localObject);
    paramf.fsY = new st();
    paramf.uri = "/cgi-bin/micromsg-bin/checksystemshare";
    paramf.funcId = getType();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.fBd = paramf.ado();
    int i;
    long l4;
    long l2;
    long l3;
    long l1;
    label249:
    cca localcca;
    switch (this.type)
    {
    case 2: 
    default: 
      i = 1;
      if (com.tencent.mm.kernel.g.RG()) {
        i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("ShareExtCheckSwitch"), 1);
      }
      if (i != 1)
      {
        this.callback.onSceneEnd(0, 0, "need not check", this);
        AppMethodBeat.o(16562);
        return 0;
      }
      break;
    case 1: 
      paramf = this.fOH;
      ss localss = (ss)this.fBd.fsV.fta;
      localss.jKs = 1;
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
        ab.i("MicroMsg.NetSceneCheckSysShare", "img file %s", new Object[] { localObject });
        paramf = com.tencent.mm.a.e.i((String)localObject, 0, -1);
        if ((paramf == null) || (paramf.length <= 0)) {
          break label834;
        }
        localcca = new cca();
        localcca.wQr = com.tencent.xweb.util.d.w(paramf);
        l2 = System.currentTimeMillis();
        MMBitmapFactory.decodeByteArray(paramf, 0, paramf.length, localOptions);
        ab.i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
        localcca.Width = localOptions.outWidth;
        localcca.Height = localOptions.outHeight;
        l3 = System.currentTimeMillis();
        paramf = ah.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { localObject }, null);
        if (paramf != null) {
          if (paramf.moveToFirst())
          {
            i = paramf.getInt(paramf.getColumnIndex("_id"));
            paramf.close();
            paramf = MediaStore.Images.Thumbnails.getThumbnail(ah.getContext().getContentResolver(), i, 1, null);
            label482:
            if (paramf == null) {
              break label648;
            }
            localObject = new com.tencent.mm.plugin.u.a.a().N(paramf);
            ab.i("MicroMsg.NetSceneCheckSysShare", "have thumbnail(w:%d, h:%d)", new Object[] { Integer.valueOf(paramf.getWidth()), Integer.valueOf(paramf.getHeight()) });
            paramf = (com.tencent.mm.ai.f)localObject;
            label534:
            l1 = System.currentTimeMillis();
            if (paramf != null)
            {
              ab.i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", new Object[] { paramf.pPC, paramf.result });
              if (!bo.isNullOrNil(paramf.pPC))
              {
                if ((!paramf.pPC.equals("QR_CODE")) && (!paramf.pPC.equals("WX_CODE"))) {
                  break label664;
                }
                localcca.xJh = paramf.result;
                label614:
                localcca.xMy = paramf.pPC;
              }
            }
            localss.wLh.add(localcca);
          }
        }
      }
      break;
    }
    label648:
    label664:
    label834:
    for (;;)
    {
      break label249;
      paramf.close();
      paramf = null;
      break label482;
      paramf = new com.tencent.mm.plugin.u.a.a().XE((String)localObject);
      break label534;
      i = paramf.result.indexOf(",");
      if ((i >= 0) && (i + 1 < paramf.result.length()))
      {
        localcca.xJh = paramf.result.substring(i + 1);
        break label614;
      }
      localcca.xJh = paramf.result;
      break label614;
      ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d(%d, %d, %d)ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l4), Long.valueOf(l2 - l4), Long.valueOf(l3 - l2), Long.valueOf(l1 - l3) });
      break;
      ae(this.fOH);
      break;
      af(this.fOH);
      break;
      ag(this.fOH);
      break;
      i = dispatch(parame, this.fBd, this);
      AppMethodBeat.o(16562);
      return i;
    }
  }
  
  public final int getType()
  {
    return 837;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16563);
    ab.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.f
 * JD-Core Version:    0.7.0.1
 */