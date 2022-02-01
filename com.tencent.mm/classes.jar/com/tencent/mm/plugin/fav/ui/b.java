package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
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
    h.DQ(paramg.field_localId);
    if (paramg.field_favProto.ppH.size() > 0)
    {
      ThreadPool.post(new a(paramg), "AddFavService_copy");
      AppMethodBeat.o(106607);
      return;
    }
    paramg.field_itemStatus = 9;
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(paramg);
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
      AppMethodBeat.o(106607);
      return;
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramg, new String[0]);
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
    paramg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().asb(paramg.field_sourceId);
    if ((paramg != null) && (paramg.field_id > 0)) {
      HZ(paramg.field_id);
    }
    if (paramg != null)
    {
      AppMethodBeat.o(106609);
      return true;
    }
    AppMethodBeat.o(106609);
    return false;
  }
  
  private static void HZ(int paramInt)
  {
    AppMethodBeat.i(106610);
    if (paramInt <= 0)
    {
      Log.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(106610);
      return;
    }
    Object localObject = new LinkedList();
    cps localcps = new cps();
    localcps.MvI = 1;
    localcps.MvJ = ((int)(System.currentTimeMillis() / 1000L));
    ((LinkedList)localObject).add(localcps);
    localObject = new am(paramInt, (LinkedList)localObject, null);
    com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    AppMethodBeat.o(106610);
  }
  
  public static boolean a(cz paramcz)
  {
    AppMethodBeat.i(106604);
    if ((paramcz.dFZ.dGb != null) && (paramcz.dFZ.dGb.ppH != null))
    {
      paramcz = paramcz.dFZ.dGb.ppH.iterator();
      while (paramcz.hasNext())
      {
        aml localaml = (aml)paramcz.next();
        if ((localaml.Lwh == null) || (localaml.Lwh.Lxi == null))
        {
          int i = localaml.dataType;
          if (((i == 2) || (i == 4) || (i == 15) || (i == 8)) && (Util.isNullOrNil(localaml.KuR)))
          {
            if (Util.isNullOrNil(localaml.LvL))
            {
              AppMethodBeat.o(106604);
              return false;
            }
            if (!s.YS(localaml.LvL))
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
  
  static int b(cz paramcz)
  {
    AppMethodBeat.i(106605);
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_favProto = paramcz.dFZ.dGb;
    localg.field_sessionId = paramcz.dFZ.sessionId;
    if (!b(localg, paramcz.dFZ.dGf))
    {
      paramcz = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().asb(localg.field_sourceId);
      if (paramcz != null) {
        com.tencent.mm.plugin.fav.a.b.DN(paramcz.field_localId);
      }
      AppMethodBeat.o(106605);
      return 0;
    }
    localg.field_flag = 0;
    localg.field_updateTime = System.currentTimeMillis();
    localg.field_localId = System.currentTimeMillis();
    com.tencent.mm.plugin.fav.a.b.DN(localg.field_localId);
    localg.field_type = paramcz.dFZ.type;
    if ((paramcz.dFZ.desc != null) && (paramcz.dFZ.desc.length() >= 10001))
    {
      Log.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
      localg.field_favProto.bhe(paramcz.dFZ.desc.substring(0, 10001));
      localg.field_xml = com.tencent.mm.plugin.fav.a.g.t(localg);
      D(localg);
      com.tencent.mm.plugin.fav.a.b.j(localg);
      localg.arR("MicroMsg.Fav.FavAddService");
      if (5 == paramcz.dFZ.type)
      {
        paramcz = "";
        if (localg.field_favProto.LwS != null) {
          paramcz = localg.field_favProto.LwS.LyC;
        }
        if ((localg.field_favProto.Lya == null) || (!Util.isNullOrNil(paramcz))) {
          break label308;
        }
        paramcz = localg.field_favProto.Lya.link;
      }
    }
    label308:
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.af(ae.class)).add(paramcz);
      AppMethodBeat.o(106605);
      return 0;
      localg.field_favProto.bhe(paramcz.dFZ.desc);
      break;
    }
  }
  
  private static boolean b(com.tencent.mm.plugin.fav.a.g paramg, int paramInt)
  {
    AppMethodBeat.i(106608);
    anh localanh = paramg.field_favProto.Lya;
    if (localanh != null)
    {
      paramg.field_sourceId = localanh.Lyi;
      if (E(paramg))
      {
        Log.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
        AppMethodBeat.o(106608);
        return false;
      }
      switch (localanh.sourceType)
      {
      case 2: 
      default: 
        paramg.field_sourceType = localanh.sourceType;
      }
    }
    for (;;)
    {
      paramg.field_fromUser = localanh.dRL;
      paramg.field_toUser = localanh.toUser;
      paramg.field_sourceId = localanh.Lyi;
      paramg.field_sourceCreateTime = localanh.createTime;
      Log.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[] { paramg.field_fromUser, paramg.field_toUser, paramg.field_sourceId, Integer.valueOf(paramg.field_sourceType) });
      AppMethodBeat.o(106608);
      return true;
      if (ab.IT(paramg.field_fromUser))
      {
        paramg.field_sourceType = 23;
      }
      else if (ab.Eq(paramg.field_fromUser))
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
          paramg.field_sourceType = localanh.sourceType;
        }
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    com.tencent.mm.plugin.fav.a.g tbr;
    
    public a(com.tencent.mm.plugin.fav.a.g paramg)
    {
      this.tbr = paramg;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   9: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/anb;
      //   12: getfield 45	com/tencent/mm/protocal/protobuf/anb:ppH	Ljava/util/LinkedList;
      //   15: astore 13
      //   17: aload 13
      //   19: invokeinterface 51 1 0
      //   24: ifle +905 -> 929
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
      //   51: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   54: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   57: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   60: aastore
      //   61: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   64: aload_0
      //   65: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   68: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   71: bipush 18
      //   73: if_icmpne +63 -> 136
      //   76: aload_0
      //   77: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   80: getfield 73	com/tencent/mm/plugin/fav/a/g:field_sourceType	I
      //   83: bipush 6
      //   85: if_icmpne +51 -> 136
      //   88: iconst_0
      //   89: istore_1
      //   90: iload_3
      //   91: istore 4
      //   93: iload_1
      //   94: iload_2
      //   95: if_icmpge +821 -> 916
      //   98: aload 13
      //   100: iload_1
      //   101: invokeinterface 77 2 0
      //   106: checkcast 79	com/tencent/mm/protocal/protobuf/aml
      //   109: astore 9
      //   111: aload 9
      //   113: getfield 83	com/tencent/mm/protocal/protobuf/aml:LvZ	Z
      //   116: ifeq +11 -> 127
      //   119: aload 9
      //   121: getfield 86	com/tencent/mm/protocal/protobuf/aml:Lwb	Z
      //   124: ifne +831 -> 955
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
      //   146: if_icmpge +770 -> 916
      //   149: aload 13
      //   151: iload_1
      //   152: invokeinterface 77 2 0
      //   157: checkcast 79	com/tencent/mm/protocal/protobuf/aml
      //   160: astore 14
      //   162: aload 14
      //   164: getfield 90	com/tencent/mm/protocal/protobuf/aml:dLl	Ljava/lang/String;
      //   167: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   170: ifeq +24 -> 194
      //   173: aload 14
      //   175: aload 14
      //   177: invokevirtual 100	java/lang/Object:toString	()Ljava/lang/String;
      //   180: aload_0
      //   181: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   184: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   187: invokestatic 106	com/tencent/mm/plugin/fav/a/b:ds	(Ljava/lang/String;I)Ljava/lang/String;
      //   190: invokevirtual 110	com/tencent/mm/protocal/protobuf/aml:bgs	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
      //   193: pop
      //   194: iload_3
      //   195: istore 4
      //   197: aload 14
      //   199: getfield 113	com/tencent/mm/protocal/protobuf/aml:dataType	I
      //   202: iconst_1
      //   203: if_icmpeq +25 -> 228
      //   206: aload 14
      //   208: getfield 83	com/tencent/mm/protocal/protobuf/aml:LvZ	Z
      //   211: ifeq +14 -> 225
      //   214: iload_3
      //   215: istore 4
      //   217: aload 14
      //   219: getfield 86	com/tencent/mm/protocal/protobuf/aml:Lwb	Z
      //   222: ifne +6 -> 228
      //   225: iconst_1
      //   226: istore 4
      //   228: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   231: lstore 5
      //   233: aload 14
      //   235: getfield 122	com/tencent/mm/protocal/protobuf/aml:LvL	Ljava/lang/String;
      //   238: astore 15
      //   240: aload 15
      //   242: invokestatic 127	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
      //   245: ifeq +477 -> 722
      //   248: aload 15
      //   250: invokestatic 131	com/tencent/mm/vfs/s:bhK	(Ljava/lang/String;)Ljava/lang/String;
      //   253: astore 9
      //   255: aload 15
      //   257: invokestatic 136	com/tencent/mm/b/g:fb	(Ljava/lang/String;)Ljava/lang/String;
      //   260: astore 10
      //   262: aload 14
      //   264: aload 9
      //   266: invokevirtual 139	com/tencent/mm/protocal/protobuf/aml:bgq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
      //   269: pop
      //   270: aload 14
      //   272: aload 10
      //   274: invokevirtual 142	com/tencent/mm/protocal/protobuf/aml:bgr	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
      //   277: pop
      //   278: aload 14
      //   280: new 144	com/tencent/mm/vfs/o
      //   283: dup
      //   284: aload 15
      //   286: invokespecial 147	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
      //   289: invokevirtual 150	com/tencent/mm/vfs/o:length	()J
      //   292: invokevirtual 154	com/tencent/mm/protocal/protobuf/aml:Mu	(J)Lcom/tencent/mm/protocal/protobuf/aml;
      //   295: pop
      //   296: aload 14
      //   298: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/aml;)Ljava/lang/String;
      //   301: astore 9
      //   303: aload 15
      //   305: aload 9
      //   307: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   310: ifne +11 -> 321
      //   313: aload 15
      //   315: aload 9
      //   317: invokestatic 168	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
      //   320: pop2
      //   321: aload 14
      //   323: getfield 171	com/tencent/mm/protocal/protobuf/aml:LvN	Ljava/lang/String;
      //   326: astore 9
      //   328: aload 9
      //   330: astore 11
      //   332: aload 9
      //   334: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   337: ifeq +179 -> 516
      //   340: aload 9
      //   342: astore 11
      //   344: aload 15
      //   346: invokestatic 127	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
      //   349: ifeq +167 -> 516
      //   352: aload 9
      //   354: astore 11
      //   356: aload_0
      //   357: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   360: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   363: iconst_4
      //   364: if_icmpne +152 -> 516
      //   367: aload 9
      //   369: astore 11
      //   371: aload_0
      //   372: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   375: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/anb;
      //   378: getfield 175	com/tencent/mm/protocal/protobuf/anb:Lya	Lcom/tencent/mm/protocal/protobuf/anh;
      //   381: getfield 180	com/tencent/mm/protocal/protobuf/anh:sourceType	I
      //   384: bipush 13
      //   386: if_icmpne +130 -> 516
      //   389: new 182	java/lang/StringBuilder
      //   392: dup
      //   393: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   396: aload 14
      //   398: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/aml;)Ljava/lang/String;
      //   401: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   404: ldc 189
      //   406: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   409: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   412: astore 12
      //   414: aload 15
      //   416: invokestatic 196	com/tencent/mm/plugin/fav/ui/e:asm	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   419: astore 9
      //   421: aload 9
      //   423: ifnull +24 -> 447
      //   426: ldc 53
      //   428: ldc 198
      //   430: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   433: aload 9
      //   435: bipush 60
      //   437: getstatic 207	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   440: aload 12
      //   442: iconst_1
      //   443: invokestatic 213	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   446: pop
      //   447: aload 14
      //   449: aload 12
      //   451: invokevirtual 216	com/tencent/mm/protocal/protobuf/aml:bgu	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
      //   454: pop
      //   455: ldc 53
      //   457: ldc 218
      //   459: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   462: new 220	com/tencent/mm/compatible/i/d
      //   465: dup
      //   466: invokespecial 221	com/tencent/mm/compatible/i/d:<init>	()V
      //   469: astore 10
      //   471: aload 10
      //   473: astore 9
      //   475: aload 10
      //   477: aload 15
      //   479: invokevirtual 226	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
      //   482: aload 10
      //   484: astore 9
      //   486: aload 14
      //   488: aload 10
      //   490: bipush 9
      //   492: invokevirtual 230	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   495: iconst_0
      //   496: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   499: i2l
      //   500: invokestatic 238	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
      //   503: invokevirtual 242	com/tencent/mm/protocal/protobuf/aml:ajc	(I)Lcom/tencent/mm/protocal/protobuf/aml;
      //   506: pop
      //   507: aload 10
      //   509: invokevirtual 245	android/media/MediaMetadataRetriever:release	()V
      //   512: aload 12
      //   514: astore 11
      //   516: aload 11
      //   518: invokestatic 127	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
      //   521: ifeq +375 -> 896
      //   524: aconst_null
      //   525: astore 10
      //   527: aconst_null
      //   528: astore 9
      //   530: aload 11
      //   532: invokestatic 249	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   535: astore 12
      //   537: aload 12
      //   539: astore 9
      //   541: aload 12
      //   543: astore 10
      //   545: aload 12
      //   547: sipush 4096
      //   550: invokestatic 253	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
      //   553: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   556: astore 15
      //   558: aload 12
      //   560: astore 9
      //   562: aload 12
      //   564: astore 10
      //   566: aload 11
      //   568: invokestatic 260	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
      //   571: lstore 7
      //   573: aload 12
      //   575: astore 9
      //   577: aload 12
      //   579: astore 10
      //   581: aload 12
      //   583: iconst_0
      //   584: sipush 256
      //   587: invokestatic 263	com/tencent/mm/b/g:a	(Ljava/io/InputStream;II)Ljava/lang/String;
      //   590: astore 16
      //   592: aload 12
      //   594: astore 9
      //   596: aload 12
      //   598: astore 10
      //   600: aload 14
      //   602: aload 15
      //   604: invokevirtual 266	com/tencent/mm/protocal/protobuf/aml:bgv	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
      //   607: pop
      //   608: aload 12
      //   610: astore 9
      //   612: aload 12
      //   614: astore 10
      //   616: aload 14
      //   618: aload 16
      //   620: invokevirtual 269	com/tencent/mm/protocal/protobuf/aml:bgw	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aml;
      //   623: pop
      //   624: aload 12
      //   626: astore 9
      //   628: aload 12
      //   630: astore 10
      //   632: aload 14
      //   634: lload 7
      //   636: invokevirtual 272	com/tencent/mm/protocal/protobuf/aml:Mv	(J)Lcom/tencent/mm/protocal/protobuf/aml;
      //   639: pop
      //   640: aload 12
      //   642: ifnull +8 -> 650
      //   645: aload 12
      //   647: invokevirtual 277	java/io/InputStream:close	()V
      //   650: aload 14
      //   652: invokestatic 279	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/aml;)Ljava/lang/String;
      //   655: astore 9
      //   657: aload 11
      //   659: aload 9
      //   661: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   664: ifne +11 -> 675
      //   667: aload 11
      //   669: aload 9
      //   671: invokestatic 168	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
      //   674: pop2
      //   675: ldc 53
      //   677: ldc_w 281
      //   680: iconst_2
      //   681: anewarray 4	java/lang/Object
      //   684: dup
      //   685: iconst_0
      //   686: aload_0
      //   687: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:tbr	Lcom/tencent/mm/plugin/fav/a/g;
      //   690: getfield 285	com/tencent/mm/plugin/fav/a/g:field_localId	J
      //   693: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   696: aastore
      //   697: dup
      //   698: iconst_1
      //   699: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   702: lload 5
      //   704: lsub
      //   705: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   708: aastore
      //   709: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   712: iload_1
      //   713: iconst_1
      //   714: iadd
      //   715: istore_1
      //   716: iload 4
      //   718: istore_3
      //   719: goto -578 -> 141
      //   722: ldc 53
      //   724: ldc_w 292
      //   727: iconst_2
      //   728: anewarray 4	java/lang/Object
      //   731: dup
      //   732: iconst_0
      //   733: aload 14
      //   735: getfield 113	com/tencent/mm/protocal/protobuf/aml:dataType	I
      //   738: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   741: aastore
      //   742: dup
      //   743: iconst_1
      //   744: aload 15
      //   746: aastore
      //   747: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   750: goto -429 -> 321
      //   753: astore 9
      //   755: ldc 53
      //   757: aload 9
      //   759: ldc_w 294
      //   762: iconst_0
      //   763: anewarray 4	java/lang/Object
      //   766: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   769: goto -322 -> 447
      //   772: astore 11
      //   774: aconst_null
      //   775: astore 10
      //   777: aload 10
      //   779: astore 9
      //   781: ldc 53
      //   783: aload 11
      //   785: ldc_w 300
      //   788: iconst_1
      //   789: anewarray 4	java/lang/Object
      //   792: dup
      //   793: iconst_0
      //   794: aload 15
      //   796: aastore
      //   797: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   800: aload 12
      //   802: astore 11
      //   804: aload 10
      //   806: ifnull -290 -> 516
      //   809: aload 10
      //   811: invokevirtual 245	android/media/MediaMetadataRetriever:release	()V
      //   814: aload 12
      //   816: astore 11
      //   818: goto -302 -> 516
      //   821: astore 10
      //   823: aconst_null
      //   824: astore 9
      //   826: aload 9
      //   828: ifnull +8 -> 836
      //   831: aload 9
      //   833: invokevirtual 245	android/media/MediaMetadataRetriever:release	()V
      //   836: ldc 27
      //   838: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   841: aload 10
      //   843: athrow
      //   844: astore 10
      //   846: aload 9
      //   848: astore 10
      //   850: ldc 53
      //   852: ldc_w 305
      //   855: invokestatic 308	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   858: aload 9
      //   860: ifnull -210 -> 650
      //   863: aload 9
      //   865: invokevirtual 277	java/io/InputStream:close	()V
      //   868: goto -218 -> 650
      //   871: astore 9
      //   873: goto -223 -> 650
      //   876: astore 9
      //   878: aload 10
      //   880: ifnull +8 -> 888
      //   883: aload 10
      //   885: invokevirtual 277	java/io/InputStream:close	()V
      //   888: ldc 27
      //   890: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   893: aload 9
      //   895: athrow
      //   896: ldc 53
      //   898: ldc_w 310
      //   901: iconst_1
      //   902: anewarray 4	java/lang/Object
      //   905: dup
      //   906: iconst_0
      //   907: aload 11
      //   909: aastore
      //   910: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   913: goto -238 -> 675
      //   916: new 11	com/tencent/mm/plugin/fav/ui/b$a$1
      //   919: dup
      //   920: aload_0
      //   921: iload 4
      //   923: invokespecial 313	com/tencent/mm/plugin/fav/ui/b$a$1:<init>	(Lcom/tencent/mm/plugin/fav/ui/b$a;Z)V
      //   926: invokestatic 319	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
      //   929: ldc 27
      //   931: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   934: return
      //   935: astore 9
      //   937: goto -287 -> 650
      //   940: astore 10
      //   942: goto -54 -> 888
      //   945: astore 10
      //   947: goto -121 -> 826
      //   950: astore 11
      //   952: goto -175 -> 777
      //   955: goto -826 -> 129
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	958	0	this	a
      //   89	627	1	i	int
      //   39	108	2	j	int
      //   31	688	3	bool1	boolean
      //   28	894	4	bool2	boolean
      //   231	472	5	l1	long
      //   571	64	7	l2	long
      //   109	561	9	localObject1	Object
      //   753	5	9	localException1	java.lang.Exception
      //   779	85	9	localObject2	Object
      //   871	1	9	localException2	java.lang.Exception
      //   876	18	9	localObject3	Object
      //   935	1	9	localException3	java.lang.Exception
      //   260	550	10	localObject4	Object
      //   821	21	10	localObject5	Object
      //   844	1	10	localFileNotFoundException	java.io.FileNotFoundException
      //   848	36	10	localObject6	Object
      //   940	1	10	localException4	java.lang.Exception
      //   945	1	10	localObject7	Object
      //   330	338	11	localObject8	Object
      //   772	12	11	localException5	java.lang.Exception
      //   802	106	11	localObject9	Object
      //   950	1	11	localException6	java.lang.Exception
      //   412	403	12	localObject10	Object
      //   15	135	13	localLinkedList	LinkedList
      //   160	574	14	localaml	aml
      //   238	557	15	str1	String
      //   590	29	16	str2	String
      // Exception table:
      //   from	to	target	type
      //   426	447	753	java/lang/Exception
      //   455	471	772	java/lang/Exception
      //   455	471	821	finally
      //   530	537	844	java/io/FileNotFoundException
      //   545	558	844	java/io/FileNotFoundException
      //   566	573	844	java/io/FileNotFoundException
      //   581	592	844	java/io/FileNotFoundException
      //   600	608	844	java/io/FileNotFoundException
      //   616	624	844	java/io/FileNotFoundException
      //   632	640	844	java/io/FileNotFoundException
      //   863	868	871	java/lang/Exception
      //   530	537	876	finally
      //   545	558	876	finally
      //   566	573	876	finally
      //   581	592	876	finally
      //   600	608	876	finally
      //   616	624	876	finally
      //   632	640	876	finally
      //   850	858	876	finally
      //   645	650	935	java/lang/Exception
      //   883	888	940	java/lang/Exception
      //   475	482	945	finally
      //   486	507	945	finally
      //   781	800	945	finally
      //   475	482	950	java/lang/Exception
      //   486	507	950	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b
 * JD-Core Version:    0.7.0.1
 */