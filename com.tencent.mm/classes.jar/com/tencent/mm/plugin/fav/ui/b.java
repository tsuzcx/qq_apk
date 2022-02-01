package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void C(g paramg)
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
  
  private static void D(g paramg)
  {
    AppMethodBeat.i(106607);
    com.tencent.mm.plugin.fav.a.h.Ke(paramg.field_localId);
    if (paramg.field_favProto.syG.size() > 0)
    {
      ThreadPool.post(new a(paramg), "AddFavService_copy");
      AppMethodBeat.o(106607);
      return;
    }
    paramg.field_itemStatus = 9;
    if (!com.tencent.mm.plugin.fav.a.b.k(paramg)) {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().z(paramg);
    }
    for (;;)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getSendService().run();
      AppMethodBeat.o(106607);
      return;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a(paramg, new String[0]);
    }
  }
  
  private static boolean E(g paramg)
  {
    AppMethodBeat.i(106609);
    if ((paramg.field_sourceId == null) || (paramg.field_sourceId.equals("")))
    {
      AppMethodBeat.o(106609);
      return false;
    }
    paramg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().aAc(paramg.field_sourceId);
    if ((paramg != null) && (paramg.field_id > 0)) {
      LJ(paramg.field_id);
    }
    if (paramg != null)
    {
      AppMethodBeat.o(106609);
      return true;
    }
    AppMethodBeat.o(106609);
    return false;
  }
  
  private static void LJ(int paramInt)
  {
    AppMethodBeat.i(106610);
    if (paramInt <= 0)
    {
      Log.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(106610);
      return;
    }
    Object localObject = new LinkedList();
    cyi localcyi = new cyi();
    localcyi.TGG = 1;
    localcyi.TGH = ((int)(System.currentTimeMillis() / 1000L));
    ((LinkedList)localObject).add(localcyi);
    localObject = new an(paramInt, (LinkedList)localObject, null);
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    AppMethodBeat.o(106610);
  }
  
  public static boolean a(dd paramdd)
  {
    AppMethodBeat.i(106604);
    if ((paramdd.fyI.fyK != null) && (paramdd.fyI.fyK.syG != null))
    {
      paramdd = paramdd.fyI.fyK.syG.iterator();
      while (paramdd.hasNext())
      {
        anm localanm = (anm)paramdd.next();
        if ((localanm.SyG == null) || (localanm.SyG.SzH == null))
        {
          int i = localanm.dataType;
          if (((i == 2) || (i == 4) || (i == 15) || (i == 8)) && (Util.isNullOrNil(localanm.Rwb)))
          {
            if (Util.isNullOrNil(localanm.Syl))
            {
              AppMethodBeat.o(106604);
              return false;
            }
            if (!u.agG(localanm.Syl))
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
  
  static int b(dd paramdd)
  {
    AppMethodBeat.i(106605);
    g localg = new g();
    localg.field_favProto = paramdd.fyI.fyK;
    localg.field_sessionId = paramdd.fyI.sessionId;
    if (!b(localg, paramdd.fyI.fyP))
    {
      paramdd = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().aAc(localg.field_sourceId);
      if (paramdd != null) {
        com.tencent.mm.plugin.fav.a.b.Kb(paramdd.field_localId);
      }
      AppMethodBeat.o(106605);
      return 0;
    }
    localg.field_flag = 0;
    localg.field_updateTime = System.currentTimeMillis();
    localg.field_localId = System.currentTimeMillis();
    com.tencent.mm.plugin.fav.a.b.Kb(localg.field_localId);
    localg.field_type = paramdd.fyI.type;
    if ((paramdd.fyI.desc != null) && (paramdd.fyI.desc.length() >= 10001))
    {
      Log.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
      localg.field_favProto.btw(paramdd.fyI.desc.substring(0, 10001));
      localg.field_xml = g.t(localg);
      D(localg);
      com.tencent.mm.plugin.fav.a.b.j(localg);
      localg.azS("MicroMsg.Fav.FavAddService");
      if (5 == paramdd.fyI.type)
      {
        paramdd = "";
        if (localg.field_favProto.Szr != null) {
          paramdd = localg.field_favProto.Szr.SBc;
        }
        if ((localg.field_favProto.SAB == null) || (!Util.isNullOrNil(paramdd))) {
          break label308;
        }
        paramdd = localg.field_favProto.SAB.link;
      }
    }
    label308:
    for (;;)
    {
      ((af)com.tencent.mm.kernel.h.ae(af.class)).add(paramdd);
      AppMethodBeat.o(106605);
      return 0;
      localg.field_favProto.btw(paramdd.fyI.desc);
      break;
    }
  }
  
  private static boolean b(g paramg, int paramInt)
  {
    AppMethodBeat.i(106608);
    aoi localaoi = paramg.field_favProto.SAB;
    if (localaoi != null)
    {
      paramg.field_sourceId = localaoi.SAJ;
      if (E(paramg))
      {
        Log.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
        AppMethodBeat.o(106608);
        return false;
      }
      switch (localaoi.sourceType)
      {
      case 2: 
      default: 
        paramg.field_sourceType = localaoi.sourceType;
      }
    }
    for (;;)
    {
      paramg.field_fromUser = localaoi.fLi;
      paramg.field_toUser = localaoi.toUser;
      paramg.field_sourceId = localaoi.SAJ;
      paramg.field_sourceCreateTime = localaoi.createTime;
      Log.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[] { paramg.field_fromUser, paramg.field_toUser, paramg.field_sourceId, Integer.valueOf(paramg.field_sourceType) });
      AppMethodBeat.o(106608);
      return true;
      if (ab.Qm(paramg.field_fromUser))
      {
        paramg.field_sourceType = 23;
      }
      else if (ab.Lj(paramg.field_fromUser))
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
          paramg.field_sourceType = localaoi.sourceType;
        }
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    g wHw;
    
    public a(g paramg)
    {
      this.wHw = paramg;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   9: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/aoc;
      //   12: getfield 45	com/tencent/mm/protocal/protobuf/aoc:syG	Ljava/util/LinkedList;
      //   15: astore 15
      //   17: aload 15
      //   19: invokeinterface 51 1 0
      //   24: ifle +968 -> 992
      //   27: iconst_0
      //   28: istore 6
      //   30: iconst_0
      //   31: istore 5
      //   33: aload 15
      //   35: invokeinterface 51 1 0
      //   40: istore 4
      //   42: ldc 53
      //   44: ldc 55
      //   46: iconst_1
      //   47: anewarray 4	java/lang/Object
      //   50: dup
      //   51: iconst_0
      //   52: aload_0
      //   53: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   56: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   59: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   62: aastore
      //   63: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   66: aload_0
      //   67: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   70: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   73: bipush 18
      //   75: if_icmpne +66 -> 141
      //   78: aload_0
      //   79: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   82: getfield 73	com/tencent/mm/plugin/fav/a/g:field_sourceType	I
      //   85: bipush 6
      //   87: if_icmpne +54 -> 141
      //   90: iconst_0
      //   91: istore_1
      //   92: iload 5
      //   94: istore 6
      //   96: iload_1
      //   97: iload 4
      //   99: if_icmpge +880 -> 979
      //   102: aload 15
      //   104: iload_1
      //   105: invokeinterface 77 2 0
      //   110: checkcast 79	com/tencent/mm/protocal/protobuf/anm
      //   113: astore 11
      //   115: aload 11
      //   117: getfield 83	com/tencent/mm/protocal/protobuf/anm:Syy	Z
      //   120: ifeq +11 -> 131
      //   123: aload 11
      //   125: getfield 86	com/tencent/mm/protocal/protobuf/anm:SyA	Z
      //   128: ifne +890 -> 1018
      //   131: iconst_1
      //   132: istore 5
      //   134: iload_1
      //   135: iconst_1
      //   136: iadd
      //   137: istore_1
      //   138: goto -46 -> 92
      //   141: iconst_0
      //   142: istore_1
      //   143: iload 6
      //   145: istore 5
      //   147: iload 5
      //   149: istore 6
      //   151: iload_1
      //   152: iload 4
      //   154: if_icmpge +825 -> 979
      //   157: aload 15
      //   159: iload_1
      //   160: invokeinterface 77 2 0
      //   165: checkcast 79	com/tencent/mm/protocal/protobuf/anm
      //   168: astore 16
      //   170: aload 16
      //   172: getfield 90	com/tencent/mm/protocal/protobuf/anm:fEa	Ljava/lang/String;
      //   175: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   178: ifeq +24 -> 202
      //   181: aload 16
      //   183: aload 16
      //   185: invokevirtual 100	java/lang/Object:toString	()Ljava/lang/String;
      //   188: aload_0
      //   189: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   192: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   195: invokestatic 106	com/tencent/mm/plugin/fav/a/b:dN	(Ljava/lang/String;I)Ljava/lang/String;
      //   198: invokevirtual 110	com/tencent/mm/protocal/protobuf/anm:bsK	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
      //   201: pop
      //   202: iload 5
      //   204: istore 6
      //   206: aload 16
      //   208: getfield 113	com/tencent/mm/protocal/protobuf/anm:dataType	I
      //   211: iconst_1
      //   212: if_icmpeq +26 -> 238
      //   215: aload 16
      //   217: getfield 83	com/tencent/mm/protocal/protobuf/anm:Syy	Z
      //   220: ifeq +15 -> 235
      //   223: iload 5
      //   225: istore 6
      //   227: aload 16
      //   229: getfield 86	com/tencent/mm/protocal/protobuf/anm:SyA	Z
      //   232: ifne +6 -> 238
      //   235: iconst_1
      //   236: istore 6
      //   238: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   241: lstore 7
      //   243: aload 16
      //   245: getfield 122	com/tencent/mm/protocal/protobuf/anm:Syl	Ljava/lang/String;
      //   248: astore 17
      //   250: aload 17
      //   252: invokestatic 127	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   255: ifeq +530 -> 785
      //   258: aload 17
      //   260: invokestatic 131	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
      //   263: astore 11
      //   265: aload 17
      //   267: invokestatic 136	com/tencent/mm/b/g:fR	(Ljava/lang/String;)Ljava/lang/String;
      //   270: astore 12
      //   272: aload 16
      //   274: aload 11
      //   276: invokevirtual 139	com/tencent/mm/protocal/protobuf/anm:bsI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
      //   279: pop
      //   280: aload 16
      //   282: aload 12
      //   284: invokevirtual 142	com/tencent/mm/protocal/protobuf/anm:bsJ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
      //   287: pop
      //   288: aload 16
      //   290: new 144	com/tencent/mm/vfs/q
      //   293: dup
      //   294: aload 17
      //   296: invokespecial 147	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   299: invokevirtual 150	com/tencent/mm/vfs/q:length	()J
      //   302: invokevirtual 154	com/tencent/mm/protocal/protobuf/anm:TY	(J)Lcom/tencent/mm/protocal/protobuf/anm;
      //   305: pop
      //   306: aload 16
      //   308: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/anm;)Ljava/lang/String;
      //   311: astore 11
      //   313: aload 17
      //   315: aload 11
      //   317: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   320: ifne +63 -> 383
      //   323: iconst_0
      //   324: istore_3
      //   325: iload_3
      //   326: istore_2
      //   327: getstatic 169	android/os/Build$VERSION:SDK_INT	I
      //   330: bipush 30
      //   332: if_icmplt +39 -> 371
      //   335: invokestatic 175	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   338: aload 17
      //   340: invokestatic 181	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:filePathToUri	(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;
      //   343: astore 12
      //   345: iload_3
      //   346: istore_2
      //   347: aload 12
      //   349: ifnull +22 -> 371
      //   352: iload_3
      //   353: istore_2
      //   354: aload 12
      //   356: invokevirtual 184	android/net/Uri:toString	()Ljava/lang/String;
      //   359: aload 11
      //   361: invokestatic 188	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
      //   364: lconst_0
      //   365: lcmp
      //   366: ifle +5 -> 371
      //   369: iconst_1
      //   370: istore_2
      //   371: iload_2
      //   372: ifne +11 -> 383
      //   375: aload 17
      //   377: aload 11
      //   379: invokestatic 188	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
      //   382: pop2
      //   383: aload 16
      //   385: getfield 191	com/tencent/mm/protocal/protobuf/anm:Syn	Ljava/lang/String;
      //   388: astore 11
      //   390: aload 11
      //   392: astore 13
      //   394: aload 11
      //   396: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   399: ifeq +179 -> 578
      //   402: aload 11
      //   404: astore 13
      //   406: aload 17
      //   408: invokestatic 127	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   411: ifeq +167 -> 578
      //   414: aload 11
      //   416: astore 13
      //   418: aload_0
      //   419: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   422: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   425: iconst_4
      //   426: if_icmpne +152 -> 578
      //   429: aload 11
      //   431: astore 13
      //   433: aload_0
      //   434: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   437: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/aoc;
      //   440: getfield 195	com/tencent/mm/protocal/protobuf/aoc:SAB	Lcom/tencent/mm/protocal/protobuf/aoi;
      //   443: getfield 200	com/tencent/mm/protocal/protobuf/aoi:sourceType	I
      //   446: bipush 13
      //   448: if_icmpne +130 -> 578
      //   451: new 202	java/lang/StringBuilder
      //   454: dup
      //   455: invokespecial 203	java/lang/StringBuilder:<init>	()V
      //   458: aload 16
      //   460: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/anm;)Ljava/lang/String;
      //   463: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   466: ldc 209
      //   468: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   471: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   474: astore 14
      //   476: aload 17
      //   478: invokestatic 216	com/tencent/mm/plugin/fav/ui/e:aAn	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   481: astore 11
      //   483: aload 11
      //   485: ifnull +24 -> 509
      //   488: ldc 53
      //   490: ldc 218
      //   492: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   495: aload 11
      //   497: bipush 60
      //   499: getstatic 227	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   502: aload 14
      //   504: iconst_1
      //   505: invokestatic 233	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   508: pop
      //   509: aload 16
      //   511: aload 14
      //   513: invokevirtual 236	com/tencent/mm/protocal/protobuf/anm:bsM	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
      //   516: pop
      //   517: ldc 53
      //   519: ldc 238
      //   521: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   524: new 240	com/tencent/mm/compatible/i/d
      //   527: dup
      //   528: invokespecial 241	com/tencent/mm/compatible/i/d:<init>	()V
      //   531: astore 12
      //   533: aload 12
      //   535: astore 11
      //   537: aload 12
      //   539: aload 17
      //   541: invokevirtual 246	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
      //   544: aload 12
      //   546: astore 11
      //   548: aload 16
      //   550: aload 12
      //   552: bipush 9
      //   554: invokevirtual 250	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   557: iconst_0
      //   558: invokestatic 254	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   561: i2l
      //   562: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
      //   565: invokevirtual 262	com/tencent/mm/protocal/protobuf/anm:arp	(I)Lcom/tencent/mm/protocal/protobuf/anm;
      //   568: pop
      //   569: aload 12
      //   571: invokevirtual 265	android/media/MediaMetadataRetriever:release	()V
      //   574: aload 14
      //   576: astore 13
      //   578: aload 13
      //   580: invokestatic 127	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   583: ifeq +376 -> 959
      //   586: aconst_null
      //   587: astore 12
      //   589: aconst_null
      //   590: astore 11
      //   592: aload 13
      //   594: invokestatic 269	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
      //   597: astore 14
      //   599: aload 14
      //   601: astore 11
      //   603: aload 14
      //   605: astore 12
      //   607: aload 14
      //   609: sipush 4096
      //   612: invokestatic 273	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
      //   615: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   618: astore 17
      //   620: aload 14
      //   622: astore 11
      //   624: aload 14
      //   626: astore 12
      //   628: aload 13
      //   630: invokestatic 280	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
      //   633: lstore 9
      //   635: aload 14
      //   637: astore 11
      //   639: aload 14
      //   641: astore 12
      //   643: aload 14
      //   645: iconst_0
      //   646: sipush 256
      //   649: invokestatic 283	com/tencent/mm/b/g:a	(Ljava/io/InputStream;II)Ljava/lang/String;
      //   652: astore 18
      //   654: aload 14
      //   656: astore 11
      //   658: aload 14
      //   660: astore 12
      //   662: aload 16
      //   664: aload 17
      //   666: invokevirtual 286	com/tencent/mm/protocal/protobuf/anm:bsN	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
      //   669: pop
      //   670: aload 14
      //   672: astore 11
      //   674: aload 14
      //   676: astore 12
      //   678: aload 16
      //   680: aload 18
      //   682: invokevirtual 289	com/tencent/mm/protocal/protobuf/anm:bsO	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
      //   685: pop
      //   686: aload 14
      //   688: astore 11
      //   690: aload 14
      //   692: astore 12
      //   694: aload 16
      //   696: lload 9
      //   698: invokevirtual 292	com/tencent/mm/protocal/protobuf/anm:TZ	(J)Lcom/tencent/mm/protocal/protobuf/anm;
      //   701: pop
      //   702: aload 14
      //   704: ifnull +8 -> 712
      //   707: aload 14
      //   709: invokevirtual 297	java/io/InputStream:close	()V
      //   712: aload 16
      //   714: invokestatic 299	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/anm;)Ljava/lang/String;
      //   717: astore 11
      //   719: aload 13
      //   721: aload 11
      //   723: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   726: ifne +11 -> 737
      //   729: aload 13
      //   731: aload 11
      //   733: invokestatic 188	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
      //   736: pop2
      //   737: ldc 53
      //   739: ldc_w 301
      //   742: iconst_2
      //   743: anewarray 4	java/lang/Object
      //   746: dup
      //   747: iconst_0
      //   748: aload_0
      //   749: getfield 20	com/tencent/mm/plugin/fav/ui/b$a:wHw	Lcom/tencent/mm/plugin/fav/a/g;
      //   752: getfield 305	com/tencent/mm/plugin/fav/a/g:field_localId	J
      //   755: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   758: aastore
      //   759: dup
      //   760: iconst_1
      //   761: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   764: lload 7
      //   766: lsub
      //   767: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   770: aastore
      //   771: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   774: iload_1
      //   775: iconst_1
      //   776: iadd
      //   777: istore_1
      //   778: iload 6
      //   780: istore 5
      //   782: goto -635 -> 147
      //   785: ldc 53
      //   787: ldc_w 312
      //   790: iconst_2
      //   791: anewarray 4	java/lang/Object
      //   794: dup
      //   795: iconst_0
      //   796: aload 16
      //   798: getfield 113	com/tencent/mm/protocal/protobuf/anm:dataType	I
      //   801: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   804: aastore
      //   805: dup
      //   806: iconst_1
      //   807: aload 17
      //   809: aastore
      //   810: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   813: goto -430 -> 383
      //   816: astore 11
      //   818: ldc 53
      //   820: aload 11
      //   822: ldc_w 314
      //   825: iconst_0
      //   826: anewarray 4	java/lang/Object
      //   829: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   832: goto -323 -> 509
      //   835: astore 13
      //   837: aconst_null
      //   838: astore 12
      //   840: aload 12
      //   842: astore 11
      //   844: ldc 53
      //   846: aload 13
      //   848: ldc_w 320
      //   851: iconst_1
      //   852: anewarray 4	java/lang/Object
      //   855: dup
      //   856: iconst_0
      //   857: aload 17
      //   859: aastore
      //   860: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   863: aload 14
      //   865: astore 13
      //   867: aload 12
      //   869: ifnull -291 -> 578
      //   872: aload 12
      //   874: invokevirtual 265	android/media/MediaMetadataRetriever:release	()V
      //   877: aload 14
      //   879: astore 13
      //   881: goto -303 -> 578
      //   884: astore 12
      //   886: aconst_null
      //   887: astore 11
      //   889: aload 11
      //   891: ifnull +8 -> 899
      //   894: aload 11
      //   896: invokevirtual 265	android/media/MediaMetadataRetriever:release	()V
      //   899: ldc 27
      //   901: invokestatic 323	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   904: aload 12
      //   906: athrow
      //   907: astore 12
      //   909: aload 11
      //   911: astore 12
      //   913: ldc 53
      //   915: ldc_w 325
      //   918: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   921: aload 11
      //   923: ifnull -211 -> 712
      //   926: aload 11
      //   928: invokevirtual 297	java/io/InputStream:close	()V
      //   931: goto -219 -> 712
      //   934: astore 11
      //   936: goto -224 -> 712
      //   939: astore 11
      //   941: aload 12
      //   943: ifnull +8 -> 951
      //   946: aload 12
      //   948: invokevirtual 297	java/io/InputStream:close	()V
      //   951: ldc 27
      //   953: invokestatic 323	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   956: aload 11
      //   958: athrow
      //   959: ldc 53
      //   961: ldc_w 330
      //   964: iconst_1
      //   965: anewarray 4	java/lang/Object
      //   968: dup
      //   969: iconst_0
      //   970: aload 13
      //   972: aastore
      //   973: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   976: goto -239 -> 737
      //   979: new 11	com/tencent/mm/plugin/fav/ui/b$a$1
      //   982: dup
      //   983: aload_0
      //   984: iload 6
      //   986: invokespecial 333	com/tencent/mm/plugin/fav/ui/b$a$1:<init>	(Lcom/tencent/mm/plugin/fav/ui/b$a;Z)V
      //   989: invokestatic 339	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
      //   992: ldc 27
      //   994: invokestatic 323	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   997: return
      //   998: astore 11
      //   1000: goto -288 -> 712
      //   1003: astore 12
      //   1005: goto -54 -> 951
      //   1008: astore 12
      //   1010: goto -121 -> 889
      //   1013: astore 13
      //   1015: goto -175 -> 840
      //   1018: goto -884 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1021	0	this	a
      //   91	687	1	i	int
      //   326	46	2	j	int
      //   324	29	3	k	int
      //   40	115	4	m	int
      //   31	750	5	bool1	boolean
      //   28	957	6	bool2	boolean
      //   241	524	7	l1	long
      //   633	64	9	l2	long
      //   113	619	11	localObject1	Object
      //   816	5	11	localException1	java.lang.Exception
      //   842	85	11	localObject2	Object
      //   934	1	11	localException2	java.lang.Exception
      //   939	18	11	localObject3	Object
      //   998	1	11	localException3	java.lang.Exception
      //   270	603	12	localObject4	Object
      //   884	21	12	localObject5	Object
      //   907	1	12	localFileNotFoundException	java.io.FileNotFoundException
      //   911	36	12	localObject6	Object
      //   1003	1	12	localException4	java.lang.Exception
      //   1008	1	12	localObject7	Object
      //   392	338	13	localObject8	Object
      //   835	12	13	localException5	java.lang.Exception
      //   865	106	13	localObject9	Object
      //   1013	1	13	localException6	java.lang.Exception
      //   474	404	14	localObject10	Object
      //   15	143	15	localLinkedList	LinkedList
      //   168	629	16	localanm	anm
      //   248	610	17	str1	String
      //   652	29	18	str2	String
      // Exception table:
      //   from	to	target	type
      //   488	509	816	java/lang/Exception
      //   517	533	835	java/lang/Exception
      //   517	533	884	finally
      //   592	599	907	java/io/FileNotFoundException
      //   607	620	907	java/io/FileNotFoundException
      //   628	635	907	java/io/FileNotFoundException
      //   643	654	907	java/io/FileNotFoundException
      //   662	670	907	java/io/FileNotFoundException
      //   678	686	907	java/io/FileNotFoundException
      //   694	702	907	java/io/FileNotFoundException
      //   926	931	934	java/lang/Exception
      //   592	599	939	finally
      //   607	620	939	finally
      //   628	635	939	finally
      //   643	654	939	finally
      //   662	670	939	finally
      //   678	686	939	finally
      //   694	702	939	finally
      //   913	921	939	finally
      //   707	712	998	java/lang/Exception
      //   946	951	1003	java/lang/Exception
      //   537	544	1008	finally
      //   548	569	1008	finally
      //   844	863	1008	finally
      //   537	544	1013	java/lang/Exception
      //   548	569	1013	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b
 * JD-Core Version:    0.7.0.1
 */