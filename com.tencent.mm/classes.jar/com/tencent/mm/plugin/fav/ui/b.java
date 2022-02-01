package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void C(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106606);
    paramg.field_updateTime = System.currentTimeMillis();
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      paramg.field_localId = System.currentTimeMillis();
    }
    D(paramg);
    com.tencent.mm.plugin.fav.a.b.j(paramg);
    AppMethodBeat.o(106606);
  }
  
  private static void D(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106607);
    h.vw(paramg.field_localId);
    if (paramg.field_favProto.nZa.size() > 0)
    {
      com.tencent.mm.sdk.g.b.c(new a(paramg), "AddFavService_copy");
      AppMethodBeat.o(106607);
      return;
    }
    paramg.field_itemStatus = 9;
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(paramg);
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      AppMethodBeat.o(106607);
      return;
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramg, new String[0]);
    }
  }
  
  private static boolean E(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(106609);
    if ((paramg.field_sourceId == null) || (paramg.field_sourceId.equals("")))
    {
      AppMethodBeat.o(106609);
      return false;
    }
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().agw(paramg.field_sourceId);
    if ((paramg != null) && (paramg.field_id > 0)) {
      Eb(paramg.field_id);
    }
    if (paramg != null)
    {
      AppMethodBeat.o(106609);
      return true;
    }
    AppMethodBeat.o(106609);
    return false;
  }
  
  private static void Eb(int paramInt)
  {
    AppMethodBeat.i(106610);
    if (paramInt <= 0)
    {
      ad.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(106610);
      return;
    }
    Object localObject = new LinkedList();
    bzw localbzw = new bzw();
    localbzw.GUM = 1;
    localbzw.GUN = ((int)(System.currentTimeMillis() / 1000L));
    ((LinkedList)localObject).add(localbzw);
    localObject = new am(paramInt, (LinkedList)localObject, null);
    com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    AppMethodBeat.o(106610);
  }
  
  public static boolean a(cv paramcv)
  {
    AppMethodBeat.i(106604);
    if ((paramcv.dnG.dnI != null) && (paramcv.dnG.dnI.nZa != null))
    {
      paramcv = paramcv.dnG.dnI.nZa.iterator();
      while (paramcv.hasNext())
      {
        ajn localajn = (ajn)paramcv.next();
        if ((localajn.GhL == null) || (localajn.GhL.GiM == null))
        {
          int i = localajn.dataType;
          if (((i == 2) || (i == 4) || (i == 15) || (i == 8)) && (bt.isNullOrNil(localajn.GgR)))
          {
            if (bt.isNullOrNil(localajn.Ghp))
            {
              AppMethodBeat.o(106604);
              return false;
            }
            if (!i.fv(localajn.Ghp))
            {
              AppMethodBeat.o(106604);
              return false;
            }
          }
        }
      }
    }
    AppMethodBeat.o(106604);
    return true;
  }
  
  static int b(cv paramcv)
  {
    AppMethodBeat.i(106605);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_favProto = paramcv.dnG.dnI;
    localg.field_sessionId = paramcv.dnG.sessionId;
    if (!b(localg, paramcv.dnG.dnM))
    {
      paramcv = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().agw(localg.field_sourceId);
      if (paramcv != null) {
        com.tencent.mm.plugin.fav.a.b.vt(paramcv.field_localId);
      }
      AppMethodBeat.o(106605);
      return 0;
    }
    localg.field_flag = 0;
    localg.field_updateTime = System.currentTimeMillis();
    localg.field_localId = System.currentTimeMillis();
    com.tencent.mm.plugin.fav.a.b.vt(localg.field_localId);
    localg.field_type = paramcv.dnG.type;
    if ((paramcv.dnG.desc != null) && (paramcv.dnG.desc.length() >= 10001))
    {
      ad.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
      localg.field_favProto.aPe(paramcv.dnG.desc.substring(0, 10001));
      localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
      D(localg);
      com.tencent.mm.plugin.fav.a.b.j(localg);
      localg.agm("MicroMsg.Fav.FavAddService");
      if (5 == paramcv.dnG.type)
      {
        paramcv = "";
        if (localg.field_favProto.Giw != null) {
          paramcv = localg.field_favProto.Giw.GjX;
        }
        if ((localg.field_favProto.Gjv == null) || (!bt.isNullOrNil(paramcv))) {
          break label308;
        }
        paramcv = localg.field_favProto.Gjv.link;
      }
    }
    label308:
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.ab(ae.class)).Ej(paramcv);
      AppMethodBeat.o(106605);
      return 0;
      localg.field_favProto.aPe(paramcv.dnG.desc);
      break;
    }
  }
  
  private static boolean b(com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(106608);
    akj localakj = paramg.field_favProto.Gjv;
    if (localakj != null)
    {
      paramg.field_sourceId = localakj.GjD;
      if (E(paramg))
      {
        ad.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
        AppMethodBeat.o(106608);
        return false;
      }
      switch (localakj.sourceType)
      {
      case 2: 
      default: 
        paramg.field_sourceType = localakj.sourceType;
      }
    }
    for (;;)
    {
      paramg.field_fromUser = localakj.dyU;
      paramg.field_toUser = localakj.toUser;
      paramg.field_sourceId = localakj.GjD;
      paramg.field_sourceCreateTime = localakj.createTime;
      ad.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[] { paramg.field_fromUser, paramg.field_toUser, paramg.field_sourceId, Integer.valueOf(paramg.field_sourceType) });
      AppMethodBeat.o(106608);
      return true;
      if (w.zE(paramg.field_fromUser))
      {
        paramg.field_sourceType = 23;
      }
      else if (w.vF(paramg.field_fromUser))
      {
        paramg.field_sourceType = 22;
      }
      else
      {
        paramg.field_sourceType = 21;
        continue;
        if (paramInt == 1) {
          paramg.field_sourceType = 24;
        } else if (paramInt == 2) {
          paramg.field_sourceType = 25;
        } else if (paramInt == 3) {
          paramg.field_sourceType = 26;
        } else {
          paramg.field_sourceType = localakj.sourceType;
        }
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    com.tencent.mm.plugin.fav.a.g rtA;
    
    public a(com.tencent.mm.plugin.fav.a.g paramg)
    {
      this.rtA = paramg;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   9: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/akd;
      //   12: getfield 45	com/tencent/mm/protocal/protobuf/akd:nZa	Ljava/util/LinkedList;
      //   15: astore 13
      //   17: aload 13
      //   19: invokeinterface 51 1 0
      //   24: ifle +901 -> 925
      //   27: iconst_0
      //   28: istore 4
      //   30: iconst_0
      //   31: istore_3
      //   32: aload 13
      //   34: invokeinterface 51 1 0
      //   39: istore_2
      //   40: ldc 53
      //   42: ldc 55
      //   44: iconst_1
      //   45: anewarray 4	java/lang/Object
      //   48: dup
      //   49: iconst_0
      //   50: aload_0
      //   51: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   54: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   57: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   60: aastore
      //   61: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   64: aload_0
      //   65: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   68: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   71: bipush 18
      //   73: if_icmpne +63 -> 136
      //   76: aload_0
      //   77: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   80: getfield 73	com/tencent/mm/plugin/fav/a/g:field_sourceType	I
      //   83: bipush 6
      //   85: if_icmpne +51 -> 136
      //   88: iconst_0
      //   89: istore_1
      //   90: iload_3
      //   91: istore 4
      //   93: iload_1
      //   94: iload_2
      //   95: if_icmpge +817 -> 912
      //   98: aload 13
      //   100: iload_1
      //   101: invokeinterface 77 2 0
      //   106: checkcast 79	com/tencent/mm/protocal/protobuf/ajn
      //   109: astore 9
      //   111: aload 9
      //   113: getfield 83	com/tencent/mm/protocal/protobuf/ajn:GhD	Z
      //   116: ifeq +11 -> 127
      //   119: aload 9
      //   121: getfield 86	com/tencent/mm/protocal/protobuf/ajn:GhF	Z
      //   124: ifne +827 -> 951
      //   127: iconst_1
      //   128: istore_3
      //   129: iload_1
      //   130: iconst_1
      //   131: iadd
      //   132: istore_1
      //   133: goto -43 -> 90
      //   136: iconst_0
      //   137: istore_1
      //   138: iload 4
      //   140: istore_3
      //   141: iload_3
      //   142: istore 4
      //   144: iload_1
      //   145: iload_2
      //   146: if_icmpge +766 -> 912
      //   149: aload 13
      //   151: iload_1
      //   152: invokeinterface 77 2 0
      //   157: checkcast 79	com/tencent/mm/protocal/protobuf/ajn
      //   160: astore 14
      //   162: aload 14
      //   164: getfield 90	com/tencent/mm/protocal/protobuf/ajn:dsU	Ljava/lang/String;
      //   167: invokestatic 96	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   170: ifeq +24 -> 194
      //   173: aload 14
      //   175: aload 14
      //   177: invokevirtual 100	java/lang/Object:toString	()Ljava/lang/String;
      //   180: aload_0
      //   181: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   184: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   187: invokestatic 106	com/tencent/mm/plugin/fav/a/b:di	(Ljava/lang/String;I)Ljava/lang/String;
      //   190: invokevirtual 110	com/tencent/mm/protocal/protobuf/ajn:aOs	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   193: pop
      //   194: iload_3
      //   195: istore 4
      //   197: aload 14
      //   199: getfield 113	com/tencent/mm/protocal/protobuf/ajn:dataType	I
      //   202: iconst_1
      //   203: if_icmpeq +25 -> 228
      //   206: aload 14
      //   208: getfield 83	com/tencent/mm/protocal/protobuf/ajn:GhD	Z
      //   211: ifeq +14 -> 225
      //   214: iload_3
      //   215: istore 4
      //   217: aload 14
      //   219: getfield 86	com/tencent/mm/protocal/protobuf/ajn:GhF	Z
      //   222: ifne +6 -> 228
      //   225: iconst_1
      //   226: istore 4
      //   228: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   231: lstore 5
      //   233: aload 14
      //   235: getfield 122	com/tencent/mm/protocal/protobuf/ajn:Ghp	Ljava/lang/String;
      //   238: astore 15
      //   240: aload 15
      //   242: invokestatic 127	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
      //   245: ifeq +473 -> 718
      //   248: aload 15
      //   250: invokestatic 131	com/tencent/mm/vfs/i:aPK	(Ljava/lang/String;)Ljava/lang/String;
      //   253: astore 9
      //   255: aload 15
      //   257: invokestatic 136	com/tencent/mm/b/g:ep	(Ljava/lang/String;)Ljava/lang/String;
      //   260: astore 10
      //   262: aload 14
      //   264: aload 9
      //   266: invokevirtual 139	com/tencent/mm/protocal/protobuf/ajn:aOq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   269: pop
      //   270: aload 14
      //   272: aload 10
      //   274: invokevirtual 142	com/tencent/mm/protocal/protobuf/ajn:aOr	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   277: pop
      //   278: aload 14
      //   280: new 144	com/tencent/mm/vfs/e
      //   283: dup
      //   284: aload 15
      //   286: invokespecial 147	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   289: invokevirtual 150	com/tencent/mm/vfs/e:length	()J
      //   292: invokevirtual 154	com/tencent/mm/protocal/protobuf/ajn:CG	(J)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   295: pop
      //   296: aload 14
      //   298: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/ajn;)Ljava/lang/String;
      //   301: astore 9
      //   303: aload 15
      //   305: aload 9
      //   307: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   310: ifne +11 -> 321
      //   313: aload 15
      //   315: aload 9
      //   317: invokestatic 168	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
      //   320: pop2
      //   321: aload 14
      //   323: getfield 171	com/tencent/mm/protocal/protobuf/ajn:Ghr	Ljava/lang/String;
      //   326: astore 9
      //   328: aload 9
      //   330: astore 11
      //   332: aload 9
      //   334: invokestatic 96	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   337: ifeq +179 -> 516
      //   340: aload 9
      //   342: astore 11
      //   344: aload 15
      //   346: invokestatic 127	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
      //   349: ifeq +167 -> 516
      //   352: aload 9
      //   354: astore 11
      //   356: aload_0
      //   357: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   360: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   363: iconst_4
      //   364: if_icmpne +152 -> 516
      //   367: aload 9
      //   369: astore 11
      //   371: aload_0
      //   372: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   375: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/akd;
      //   378: getfield 175	com/tencent/mm/protocal/protobuf/akd:Gjv	Lcom/tencent/mm/protocal/protobuf/akj;
      //   381: getfield 180	com/tencent/mm/protocal/protobuf/akj:sourceType	I
      //   384: bipush 13
      //   386: if_icmpne +130 -> 516
      //   389: new 182	java/lang/StringBuilder
      //   392: dup
      //   393: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   396: aload 14
      //   398: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/ajn;)Ljava/lang/String;
      //   401: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   404: ldc 189
      //   406: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   409: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   412: astore 12
      //   414: aload 15
      //   416: invokestatic 196	com/tencent/mm/plugin/fav/ui/e:agH	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   419: astore 9
      //   421: aload 9
      //   423: ifnull +24 -> 447
      //   426: ldc 53
      //   428: ldc 198
      //   430: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   433: aload 9
      //   435: bipush 60
      //   437: getstatic 207	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   440: aload 12
      //   442: iconst_1
      //   443: invokestatic 212	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   446: pop
      //   447: aload 14
      //   449: aload 12
      //   451: invokevirtual 215	com/tencent/mm/protocal/protobuf/ajn:aOu	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   454: pop
      //   455: ldc 53
      //   457: ldc 217
      //   459: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   462: new 219	com/tencent/mm/compatible/h/d
      //   465: dup
      //   466: invokespecial 220	com/tencent/mm/compatible/h/d:<init>	()V
      //   469: astore 10
      //   471: aload 10
      //   473: astore 9
      //   475: aload 10
      //   477: aload 15
      //   479: invokevirtual 225	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
      //   482: aload 10
      //   484: astore 9
      //   486: aload 14
      //   488: aload 10
      //   490: bipush 9
      //   492: invokevirtual 229	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   495: iconst_0
      //   496: invokestatic 233	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
      //   499: i2l
      //   500: invokestatic 237	com/tencent/mm/sdk/platformtools/bt:Dg	(J)I
      //   503: invokevirtual 241	com/tencent/mm/protocal/protobuf/ajn:ZH	(I)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   506: pop
      //   507: aload 10
      //   509: invokevirtual 244	android/media/MediaMetadataRetriever:release	()V
      //   512: aload 12
      //   514: astore 11
      //   516: aload 11
      //   518: invokestatic 127	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
      //   521: ifeq +371 -> 892
      //   524: aconst_null
      //   525: astore 10
      //   527: aconst_null
      //   528: astore 9
      //   530: aload 11
      //   532: invokestatic 248	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   535: astore 12
      //   537: aload 12
      //   539: astore 9
      //   541: aload 12
      //   543: astore 10
      //   545: aload 12
      //   547: sipush 4096
      //   550: invokestatic 252	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
      //   553: invokestatic 255	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   556: astore 15
      //   558: aload 12
      //   560: astore 9
      //   562: aload 12
      //   564: astore 10
      //   566: aload 11
      //   568: invokestatic 259	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
      //   571: lstore 7
      //   573: aload 12
      //   575: astore 9
      //   577: aload 12
      //   579: astore 10
      //   581: aload 12
      //   583: invokestatic 263	com/tencent/mm/b/g:r	(Ljava/io/InputStream;)Ljava/lang/String;
      //   586: astore 16
      //   588: aload 12
      //   590: astore 9
      //   592: aload 12
      //   594: astore 10
      //   596: aload 14
      //   598: aload 15
      //   600: invokevirtual 266	com/tencent/mm/protocal/protobuf/ajn:aOv	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   603: pop
      //   604: aload 12
      //   606: astore 9
      //   608: aload 12
      //   610: astore 10
      //   612: aload 14
      //   614: aload 16
      //   616: invokevirtual 269	com/tencent/mm/protocal/protobuf/ajn:aOw	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   619: pop
      //   620: aload 12
      //   622: astore 9
      //   624: aload 12
      //   626: astore 10
      //   628: aload 14
      //   630: lload 7
      //   632: invokevirtual 272	com/tencent/mm/protocal/protobuf/ajn:CH	(J)Lcom/tencent/mm/protocal/protobuf/ajn;
      //   635: pop
      //   636: aload 12
      //   638: ifnull +8 -> 646
      //   641: aload 12
      //   643: invokevirtual 277	java/io/InputStream:close	()V
      //   646: aload 14
      //   648: invokestatic 279	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/ajn;)Ljava/lang/String;
      //   651: astore 9
      //   653: aload 11
      //   655: aload 9
      //   657: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   660: ifne +11 -> 671
      //   663: aload 11
      //   665: aload 9
      //   667: invokestatic 168	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
      //   670: pop2
      //   671: ldc 53
      //   673: ldc_w 281
      //   676: iconst_2
      //   677: anewarray 4	java/lang/Object
      //   680: dup
      //   681: iconst_0
      //   682: aload_0
      //   683: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:rtA	Lcom/tencent/mm/plugin/fav/a/g;
      //   686: getfield 285	com/tencent/mm/plugin/fav/a/g:field_localId	J
      //   689: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   692: aastore
      //   693: dup
      //   694: iconst_1
      //   695: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   698: lload 5
      //   700: lsub
      //   701: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   704: aastore
      //   705: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   708: iload_1
      //   709: iconst_1
      //   710: iadd
      //   711: istore_1
      //   712: iload 4
      //   714: istore_3
      //   715: goto -574 -> 141
      //   718: ldc 53
      //   720: ldc_w 292
      //   723: iconst_2
      //   724: anewarray 4	java/lang/Object
      //   727: dup
      //   728: iconst_0
      //   729: aload 14
      //   731: getfield 113	com/tencent/mm/protocal/protobuf/ajn:dataType	I
      //   734: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   737: aastore
      //   738: dup
      //   739: iconst_1
      //   740: aload 15
      //   742: aastore
      //   743: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   746: goto -425 -> 321
      //   749: astore 9
      //   751: ldc 53
      //   753: aload 9
      //   755: ldc_w 294
      //   758: iconst_0
      //   759: anewarray 4	java/lang/Object
      //   762: invokestatic 298	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   765: goto -318 -> 447
      //   768: astore 11
      //   770: aconst_null
      //   771: astore 10
      //   773: aload 10
      //   775: astore 9
      //   777: ldc 53
      //   779: aload 11
      //   781: ldc_w 300
      //   784: iconst_1
      //   785: anewarray 4	java/lang/Object
      //   788: dup
      //   789: iconst_0
      //   790: aload 15
      //   792: aastore
      //   793: invokestatic 298	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   796: aload 12
      //   798: astore 11
      //   800: aload 10
      //   802: ifnull -286 -> 516
      //   805: aload 10
      //   807: invokevirtual 244	android/media/MediaMetadataRetriever:release	()V
      //   810: aload 12
      //   812: astore 11
      //   814: goto -298 -> 516
      //   817: astore 10
      //   819: aconst_null
      //   820: astore 9
      //   822: aload 9
      //   824: ifnull +8 -> 832
      //   827: aload 9
      //   829: invokevirtual 244	android/media/MediaMetadataRetriever:release	()V
      //   832: ldc 27
      //   834: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   837: aload 10
      //   839: athrow
      //   840: astore 10
      //   842: aload 9
      //   844: astore 10
      //   846: ldc 53
      //   848: ldc_w 305
      //   851: invokestatic 308	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   854: aload 9
      //   856: ifnull -210 -> 646
      //   859: aload 9
      //   861: invokevirtual 277	java/io/InputStream:close	()V
      //   864: goto -218 -> 646
      //   867: astore 9
      //   869: goto -223 -> 646
      //   872: astore 9
      //   874: aload 10
      //   876: ifnull +8 -> 884
      //   879: aload 10
      //   881: invokevirtual 277	java/io/InputStream:close	()V
      //   884: ldc 27
      //   886: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   889: aload 9
      //   891: athrow
      //   892: ldc 53
      //   894: ldc_w 310
      //   897: iconst_1
      //   898: anewarray 4	java/lang/Object
      //   901: dup
      //   902: iconst_0
      //   903: aload 11
      //   905: aastore
      //   906: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   909: goto -238 -> 671
      //   912: new 11	com/tencent/mm/plugin/fav/ui/b$a$1
      //   915: dup
      //   916: aload_0
      //   917: iload 4
      //   919: invokespecial 313	com/tencent/mm/plugin/fav/ui/b$a$1:<init>	(Lcom/tencent/mm/plugin/fav/ui/b$a;Z)V
      //   922: invokestatic 319	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
      //   925: ldc 27
      //   927: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   930: return
      //   931: astore 9
      //   933: goto -287 -> 646
      //   936: astore 10
      //   938: goto -54 -> 884
      //   941: astore 10
      //   943: goto -121 -> 822
      //   946: astore 11
      //   948: goto -175 -> 773
      //   951: goto -822 -> 129
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	954	0	this	a
      //   89	623	1	i	int
      //   39	108	2	j	int
      //   31	684	3	bool1	boolean
      //   28	890	4	bool2	boolean
      //   231	468	5	l1	long
      //   571	60	7	l2	long
      //   109	557	9	localObject1	Object
      //   749	5	9	localException1	java.lang.Exception
      //   775	85	9	localObject2	Object
      //   867	1	9	localException2	java.lang.Exception
      //   872	18	9	localObject3	Object
      //   931	1	9	localException3	java.lang.Exception
      //   260	546	10	localObject4	Object
      //   817	21	10	localObject5	Object
      //   840	1	10	localFileNotFoundException	java.io.FileNotFoundException
      //   844	36	10	localObject6	Object
      //   936	1	10	localException4	java.lang.Exception
      //   941	1	10	localObject7	Object
      //   330	334	11	localObject8	Object
      //   768	12	11	localException5	java.lang.Exception
      //   798	106	11	localObject9	Object
      //   946	1	11	localException6	java.lang.Exception
      //   412	399	12	localObject10	Object
      //   15	135	13	localLinkedList	LinkedList
      //   160	570	14	localajn	ajn
      //   238	553	15	str1	String
      //   586	29	16	str2	String
      // Exception table:
      //   from	to	target	type
      //   426	447	749	java/lang/Exception
      //   455	471	768	java/lang/Exception
      //   455	471	817	finally
      //   530	537	840	java/io/FileNotFoundException
      //   545	558	840	java/io/FileNotFoundException
      //   566	573	840	java/io/FileNotFoundException
      //   581	588	840	java/io/FileNotFoundException
      //   596	604	840	java/io/FileNotFoundException
      //   612	620	840	java/io/FileNotFoundException
      //   628	636	840	java/io/FileNotFoundException
      //   859	864	867	java/lang/Exception
      //   530	537	872	finally
      //   545	558	872	finally
      //   566	573	872	finally
      //   581	588	872	finally
      //   596	604	872	finally
      //   612	620	872	finally
      //   628	636	872	finally
      //   846	854	872	finally
      //   641	646	931	java/lang/Exception
      //   879	884	936	java/lang/Exception
      //   475	482	941	finally
      //   486	507	941	finally
      //   777	796	941	finally
      //   475	482	946	java/lang/Exception
      //   486	507	946	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b
 * JD-Core Version:    0.7.0.1
 */