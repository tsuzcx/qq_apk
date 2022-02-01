package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.webview.k.c;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.au;
import java.util.LinkedList;

public final class a
{
  public static void C(g paramg)
  {
    AppMethodBeat.i(106606);
    paramg.field_updateTime = System.currentTimeMillis();
    if (!b.k(paramg)) {
      paramg.field_localId = System.currentTimeMillis();
    }
    D(paramg);
    b.j(paramg);
    AppMethodBeat.o(106606);
  }
  
  private static void D(g paramg)
  {
    AppMethodBeat.i(106607);
    com.tencent.mm.plugin.fav.a.h.mC(paramg.field_localId);
    if (paramg.field_favProto.vEn.size() > 0)
    {
      ThreadPool.post(new a(paramg), "AddFavService_copy");
      AppMethodBeat.o(106607);
      return;
    }
    paramg.field_itemStatus = 9;
    if (!b.k(paramg)) {
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().z(paramg);
    }
    for (;;)
    {
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
      AppMethodBeat.o(106607);
      return;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(paramg, new String[0]);
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
    paramg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().auj(paramg.field_sourceId);
    if ((paramg != null) && (paramg.field_id > 0)) {
      MG(paramg.field_id);
    }
    if (paramg != null)
    {
      AppMethodBeat.o(106609);
      return true;
    }
    AppMethodBeat.o(106609);
    return false;
  }
  
  private static void MG(int paramInt)
  {
    AppMethodBeat.i(106610);
    if (paramInt <= 0)
    {
      Log.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(106610);
      return;
    }
    Object localObject = new LinkedList();
    dpo localdpo = new dpo();
    localdpo.aaWn = 1;
    localdpo.aaWo = ((int)(System.currentTimeMillis() / 1000L));
    ((LinkedList)localObject).add(localdpo);
    localObject = new ao(paramInt, (LinkedList)localObject, null);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(106610);
  }
  
  static int a(dn paramdn)
  {
    int i = -1;
    AppMethodBeat.i(106605);
    g localg = new g();
    String str;
    if (5 == paramdn.hDr.type)
    {
      str = paramdn.hDr.hDt.ZBt.link;
      if (!Util.isNullOrNil(str))
      {
        if (!isMpUrl(str)) {
          break label206;
        }
        if (paramdn.hDr.hDt.WKx != null) {
          i = paramdn.hDr.hDt.WKx.nQm;
        }
        str = c.XsF.ih(str, i);
        Log.i("MicroMsg.Fav.FavAddService", "use keyURL ".concat(String.valueOf(str)));
        if (!Util.isNullOrNil(str)) {
          paramdn.hDr.hDt.ZBt.btq(String.valueOf(str));
        }
      }
    }
    localg.field_favProto = paramdn.hDr.hDt;
    localg.field_sessionId = paramdn.hDr.sessionId;
    if (!b(localg, paramdn.hDr.hDy))
    {
      paramdn = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().auj(localg.field_sourceId);
      if (paramdn != null) {
        b.mz(paramdn.field_localId);
      }
      AppMethodBeat.o(106605);
      return 0;
      label206:
      i = str.indexOf("#");
      if (i == -1) {
        break label483;
      }
      str = str.substring(0, i);
    }
    label480:
    label483:
    for (;;)
    {
      Log.i("MicroMsg.Fav.FavAddService", "use original URL ".concat(String.valueOf(str)));
      paramdn.hDr.hDt.ZBt.btq(String.valueOf(str));
      break;
      localg.field_flag = 0;
      localg.field_updateTime = System.currentTimeMillis();
      localg.field_localId = System.currentTimeMillis();
      b.mz(localg.field_localId);
      localg.field_type = paramdn.hDr.type;
      if ((paramdn.hDr.desc != null) && (paramdn.hDr.desc.length() >= 10001))
      {
        Log.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
        localg.field_favProto.btn(paramdn.hDr.desc.substring(0, 10001));
        localg.field_xml = g.t(localg);
        D(localg);
        b.j(localg);
        localg.atY("MicroMsg.Fav.FavAddService");
        if (5 == paramdn.hDr.type)
        {
          paramdn = "";
          if (localg.field_favProto.ZAj != null) {
            paramdn = localg.field_favProto.ZAj.ZBV;
          }
          if ((localg.field_favProto.ZBt == null) || (!Util.isNullOrNil(paramdn))) {
            break label480;
          }
          paramdn = localg.field_favProto.ZBt.link;
        }
      }
      for (;;)
      {
        ((ag)com.tencent.mm.kernel.h.ax(ag.class)).add(paramdn);
        AppMethodBeat.o(106605);
        return 0;
        localg.field_favProto.btn(paramdn.hDr.desc);
        break;
      }
    }
  }
  
  private static boolean b(g paramg, int paramInt)
  {
    AppMethodBeat.i(106608);
    asb localasb = paramg.field_favProto.ZBt;
    if (localasb != null)
    {
      paramg.field_sourceId = localasb.ZBB;
      if (E(paramg))
      {
        Log.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
        AppMethodBeat.o(106608);
        return false;
      }
      switch (localasb.sourceType)
      {
      case 2: 
      default: 
        paramg.field_sourceType = localasb.sourceType;
      }
    }
    for (;;)
    {
      paramg.field_fromUser = localasb.hQQ;
      paramg.field_toUser = localasb.toUser;
      paramg.field_sourceId = localasb.ZBB;
      paramg.field_sourceCreateTime = localasb.createTime;
      Log.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[] { paramg.field_fromUser, paramg.field_toUser, paramg.field_sourceId, Integer.valueOf(paramg.field_sourceType) });
      AppMethodBeat.o(106608);
      return true;
      if (ab.IS(paramg.field_fromUser))
      {
        paramg.field_sourceType = 23;
      }
      else if (au.bwE(paramg.field_fromUser))
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
          paramg.field_sourceType = localasb.sourceType;
        }
      }
    }
  }
  
  private static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(274420);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(274420);
      return false;
    }
    if ((paramString.startsWith("https://" + WeChatHosts.domainString(c.h.host_mp_weixin_qq_com) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(c.h.host_mp_weixin_qq_com) + "/")))
    {
      AppMethodBeat.o(274420);
      return true;
    }
    AppMethodBeat.o(274420);
    return false;
  }
  
  static final class a
    implements Runnable
  {
    g AdF;
    
    public a(g paramg)
    {
      this.AdF = paramg;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   9: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/arv;
      //   12: getfield 45	com/tencent/mm/protocal/protobuf/arv:vEn	Ljava/util/LinkedList;
      //   15: astore 15
      //   17: aload 15
      //   19: invokeinterface 51 1 0
      //   24: ifle +971 -> 995
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
      //   53: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   56: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   59: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   62: aastore
      //   63: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   66: aload_0
      //   67: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   70: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   73: bipush 18
      //   75: if_icmpne +66 -> 141
      //   78: aload_0
      //   79: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   82: getfield 73	com/tencent/mm/plugin/fav/a/g:field_sourceType	I
      //   85: bipush 6
      //   87: if_icmpne +54 -> 141
      //   90: iconst_0
      //   91: istore_1
      //   92: iload 5
      //   94: istore 6
      //   96: iload_1
      //   97: iload 4
      //   99: if_icmpge +883 -> 982
      //   102: aload 15
      //   104: iload_1
      //   105: invokeinterface 77 2 0
      //   110: checkcast 79	com/tencent/mm/protocal/protobuf/arf
      //   113: astore 11
      //   115: aload 11
      //   117: getfield 83	com/tencent/mm/protocal/protobuf/arf:Zzq	Z
      //   120: ifeq +11 -> 131
      //   123: aload 11
      //   125: getfield 86	com/tencent/mm/protocal/protobuf/arf:Zzs	Z
      //   128: ifne +893 -> 1021
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
      //   154: if_icmpge +828 -> 982
      //   157: aload 15
      //   159: iload_1
      //   160: invokeinterface 77 2 0
      //   165: checkcast 79	com/tencent/mm/protocal/protobuf/arf
      //   168: astore 16
      //   170: aload 16
      //   172: getfield 90	com/tencent/mm/protocal/protobuf/arf:hIQ	Ljava/lang/String;
      //   175: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   178: ifeq +24 -> 202
      //   181: aload 16
      //   183: aload 16
      //   185: invokevirtual 100	java/lang/Object:toString	()Ljava/lang/String;
      //   188: aload_0
      //   189: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   192: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   195: invokestatic 106	com/tencent/mm/plugin/fav/a/b:er	(Ljava/lang/String;I)Ljava/lang/String;
      //   198: invokevirtual 110	com/tencent/mm/protocal/protobuf/arf:bsB	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
      //   201: pop
      //   202: iload 5
      //   204: istore 6
      //   206: aload 16
      //   208: getfield 113	com/tencent/mm/protocal/protobuf/arf:dataType	I
      //   211: iconst_1
      //   212: if_icmpeq +26 -> 238
      //   215: aload 16
      //   217: getfield 83	com/tencent/mm/protocal/protobuf/arf:Zzq	Z
      //   220: ifeq +15 -> 235
      //   223: iload 5
      //   225: istore 6
      //   227: aload 16
      //   229: getfield 86	com/tencent/mm/protocal/protobuf/arf:Zzs	Z
      //   232: ifne +6 -> 238
      //   235: iconst_1
      //   236: istore 6
      //   238: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   241: lstore 7
      //   243: aload 16
      //   245: getfield 122	com/tencent/mm/protocal/protobuf/arf:Zzd	Ljava/lang/String;
      //   248: astore 17
      //   250: aload 17
      //   252: invokestatic 127	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   255: ifeq +533 -> 788
      //   258: aload 17
      //   260: invokestatic 131	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
      //   263: astore 11
      //   265: aload 17
      //   267: invokestatic 136	com/tencent/mm/b/g:hu	(Ljava/lang/String;)Ljava/lang/String;
      //   270: astore 12
      //   272: aload 16
      //   274: aload 11
      //   276: invokevirtual 139	com/tencent/mm/protocal/protobuf/arf:bsz	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
      //   279: pop
      //   280: aload 16
      //   282: aload 12
      //   284: invokevirtual 142	com/tencent/mm/protocal/protobuf/arf:bsA	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
      //   287: pop
      //   288: aload 16
      //   290: new 144	com/tencent/mm/vfs/u
      //   293: dup
      //   294: aload 17
      //   296: invokespecial 147	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   299: invokevirtual 150	com/tencent/mm/vfs/u:length	()J
      //   302: invokevirtual 154	com/tencent/mm/protocal/protobuf/arf:yo	(J)Lcom/tencent/mm/protocal/protobuf/arf;
      //   305: pop
      //   306: aload 16
      //   308: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/arf;)Ljava/lang/String;
      //   311: astore 11
      //   313: aload 17
      //   315: aload 11
      //   317: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   320: ifne +65 -> 385
      //   323: iconst_0
      //   324: istore_3
      //   325: iload_3
      //   326: istore_2
      //   327: getstatic 169	android/os/Build$VERSION:SDK_INT	I
      //   330: bipush 30
      //   332: if_icmplt +40 -> 372
      //   335: invokestatic 175	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   338: aload 17
      //   340: invokestatic 181	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:filePathToUri	(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;
      //   343: astore 12
      //   345: iload_3
      //   346: istore_2
      //   347: aload 12
      //   349: ifnull +23 -> 372
      //   352: iload_3
      //   353: istore_2
      //   354: aload 12
      //   356: invokevirtual 184	android/net/Uri:toString	()Ljava/lang/String;
      //   359: aload 11
      //   361: iconst_0
      //   362: invokestatic 188	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
      //   365: lconst_0
      //   366: lcmp
      //   367: ifle +5 -> 372
      //   370: iconst_1
      //   371: istore_2
      //   372: iload_2
      //   373: ifne +12 -> 385
      //   376: aload 17
      //   378: aload 11
      //   380: iconst_0
      //   381: invokestatic 188	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
      //   384: pop2
      //   385: aload 16
      //   387: getfield 191	com/tencent/mm/protocal/protobuf/arf:Zzf	Ljava/lang/String;
      //   390: astore 11
      //   392: aload 11
      //   394: astore 13
      //   396: aload 11
      //   398: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   401: ifeq +179 -> 580
      //   404: aload 11
      //   406: astore 13
      //   408: aload 17
      //   410: invokestatic 127	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   413: ifeq +167 -> 580
      //   416: aload 11
      //   418: astore 13
      //   420: aload_0
      //   421: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   424: getfield 59	com/tencent/mm/plugin/fav/a/g:field_type	I
      //   427: iconst_4
      //   428: if_icmpne +152 -> 580
      //   431: aload 11
      //   433: astore 13
      //   435: aload_0
      //   436: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   439: getfield 39	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/protobuf/arv;
      //   442: getfield 195	com/tencent/mm/protocal/protobuf/arv:ZBt	Lcom/tencent/mm/protocal/protobuf/asb;
      //   445: getfield 200	com/tencent/mm/protocal/protobuf/asb:sourceType	I
      //   448: bipush 13
      //   450: if_icmpne +130 -> 580
      //   453: new 202	java/lang/StringBuilder
      //   456: dup
      //   457: invokespecial 203	java/lang/StringBuilder:<init>	()V
      //   460: aload 16
      //   462: invokestatic 158	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/arf;)Ljava/lang/String;
      //   465: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   468: ldc 209
      //   470: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   473: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   476: astore 14
      //   478: aload 17
      //   480: invokestatic 216	com/tencent/mm/plugin/fav/ui/e:auu	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   483: astore 11
      //   485: aload 11
      //   487: ifnull +24 -> 511
      //   490: ldc 53
      //   492: ldc 218
      //   494: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   497: aload 11
      //   499: bipush 60
      //   501: getstatic 227	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   504: aload 14
      //   506: iconst_1
      //   507: invokestatic 233	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
      //   510: pop
      //   511: aload 16
      //   513: aload 14
      //   515: invokevirtual 236	com/tencent/mm/protocal/protobuf/arf:bsD	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
      //   518: pop
      //   519: ldc 53
      //   521: ldc 238
      //   523: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   526: new 240	com/tencent/mm/compatible/i/d
      //   529: dup
      //   530: invokespecial 241	com/tencent/mm/compatible/i/d:<init>	()V
      //   533: astore 12
      //   535: aload 12
      //   537: astore 11
      //   539: aload 12
      //   541: aload 17
      //   543: invokevirtual 246	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
      //   546: aload 12
      //   548: astore 11
      //   550: aload 16
      //   552: aload 12
      //   554: bipush 9
      //   556: invokevirtual 250	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   559: iconst_0
      //   560: invokestatic 254	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   563: i2l
      //   564: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
      //   567: invokevirtual 262	com/tencent/mm/protocal/protobuf/arf:axx	(I)Lcom/tencent/mm/protocal/protobuf/arf;
      //   570: pop
      //   571: aload 12
      //   573: invokevirtual 265	android/media/MediaMetadataRetriever:release	()V
      //   576: aload 14
      //   578: astore 13
      //   580: aload 13
      //   582: invokestatic 127	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   585: ifeq +377 -> 962
      //   588: aconst_null
      //   589: astore 12
      //   591: aconst_null
      //   592: astore 11
      //   594: aload 13
      //   596: invokestatic 269	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
      //   599: astore 14
      //   601: aload 14
      //   603: astore 11
      //   605: aload 14
      //   607: astore 12
      //   609: aload 14
      //   611: sipush 4096
      //   614: invokestatic 273	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
      //   617: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
      //   620: astore 17
      //   622: aload 14
      //   624: astore 11
      //   626: aload 14
      //   628: astore 12
      //   630: aload 13
      //   632: invokestatic 280	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
      //   635: lstore 9
      //   637: aload 14
      //   639: astore 11
      //   641: aload 14
      //   643: astore 12
      //   645: aload 14
      //   647: iconst_0
      //   648: sipush 256
      //   651: invokestatic 284	com/tencent/mm/b/g:b	(Ljava/io/InputStream;II)Ljava/lang/String;
      //   654: astore 18
      //   656: aload 14
      //   658: astore 11
      //   660: aload 14
      //   662: astore 12
      //   664: aload 16
      //   666: aload 17
      //   668: invokevirtual 287	com/tencent/mm/protocal/protobuf/arf:bsE	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
      //   671: pop
      //   672: aload 14
      //   674: astore 11
      //   676: aload 14
      //   678: astore 12
      //   680: aload 16
      //   682: aload 18
      //   684: invokevirtual 290	com/tencent/mm/protocal/protobuf/arf:bsF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/arf;
      //   687: pop
      //   688: aload 14
      //   690: astore 11
      //   692: aload 14
      //   694: astore 12
      //   696: aload 16
      //   698: lload 9
      //   700: invokevirtual 293	com/tencent/mm/protocal/protobuf/arf:yp	(J)Lcom/tencent/mm/protocal/protobuf/arf;
      //   703: pop
      //   704: aload 14
      //   706: ifnull +8 -> 714
      //   709: aload 14
      //   711: invokevirtual 298	java/io/InputStream:close	()V
      //   714: aload 16
      //   716: invokestatic 300	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/arf;)Ljava/lang/String;
      //   719: astore 11
      //   721: aload 13
      //   723: aload 11
      //   725: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   728: ifne +12 -> 740
      //   731: aload 13
      //   733: aload 11
      //   735: iconst_0
      //   736: invokestatic 188	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
      //   739: pop2
      //   740: ldc 53
      //   742: ldc_w 302
      //   745: iconst_2
      //   746: anewarray 4	java/lang/Object
      //   749: dup
      //   750: iconst_0
      //   751: aload_0
      //   752: getfield 20	com/tencent/mm/plugin/fav/ui/a$a:AdF	Lcom/tencent/mm/plugin/fav/a/g;
      //   755: getfield 306	com/tencent/mm/plugin/fav/a/g:field_localId	J
      //   758: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   761: aastore
      //   762: dup
      //   763: iconst_1
      //   764: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   767: lload 7
      //   769: lsub
      //   770: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   773: aastore
      //   774: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   777: iload_1
      //   778: iconst_1
      //   779: iadd
      //   780: istore_1
      //   781: iload 6
      //   783: istore 5
      //   785: goto -638 -> 147
      //   788: ldc 53
      //   790: ldc_w 313
      //   793: iconst_2
      //   794: anewarray 4	java/lang/Object
      //   797: dup
      //   798: iconst_0
      //   799: aload 16
      //   801: getfield 113	com/tencent/mm/protocal/protobuf/arf:dataType	I
      //   804: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   807: aastore
      //   808: dup
      //   809: iconst_1
      //   810: aload 17
      //   812: aastore
      //   813: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   816: goto -431 -> 385
      //   819: astore 11
      //   821: ldc 53
      //   823: aload 11
      //   825: ldc_w 315
      //   828: iconst_0
      //   829: anewarray 4	java/lang/Object
      //   832: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   835: goto -324 -> 511
      //   838: astore 13
      //   840: aconst_null
      //   841: astore 12
      //   843: aload 12
      //   845: astore 11
      //   847: ldc 53
      //   849: aload 13
      //   851: ldc_w 321
      //   854: iconst_1
      //   855: anewarray 4	java/lang/Object
      //   858: dup
      //   859: iconst_0
      //   860: aload 17
      //   862: aastore
      //   863: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   866: aload 14
      //   868: astore 13
      //   870: aload 12
      //   872: ifnull -292 -> 580
      //   875: aload 12
      //   877: invokevirtual 265	android/media/MediaMetadataRetriever:release	()V
      //   880: aload 14
      //   882: astore 13
      //   884: goto -304 -> 580
      //   887: astore 12
      //   889: aconst_null
      //   890: astore 11
      //   892: aload 11
      //   894: ifnull +8 -> 902
      //   897: aload 11
      //   899: invokevirtual 265	android/media/MediaMetadataRetriever:release	()V
      //   902: ldc 27
      //   904: invokestatic 324	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   907: aload 12
      //   909: athrow
      //   910: astore 12
      //   912: aload 11
      //   914: astore 12
      //   916: ldc 53
      //   918: ldc_w 326
      //   921: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   924: aload 11
      //   926: ifnull -212 -> 714
      //   929: aload 11
      //   931: invokevirtual 298	java/io/InputStream:close	()V
      //   934: goto -220 -> 714
      //   937: astore 11
      //   939: goto -225 -> 714
      //   942: astore 11
      //   944: aload 12
      //   946: ifnull +8 -> 954
      //   949: aload 12
      //   951: invokevirtual 298	java/io/InputStream:close	()V
      //   954: ldc 27
      //   956: invokestatic 324	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   959: aload 11
      //   961: athrow
      //   962: ldc 53
      //   964: ldc_w 330
      //   967: iconst_1
      //   968: anewarray 4	java/lang/Object
      //   971: dup
      //   972: iconst_0
      //   973: aload 13
      //   975: aastore
      //   976: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   979: goto -239 -> 740
      //   982: new 11	com/tencent/mm/plugin/fav/ui/a$a$1
      //   985: dup
      //   986: aload_0
      //   987: iload 6
      //   989: invokespecial 333	com/tencent/mm/plugin/fav/ui/a$a$1:<init>	(Lcom/tencent/mm/plugin/fav/ui/a$a;Z)V
      //   992: invokestatic 339	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
      //   995: ldc 27
      //   997: invokestatic 324	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1000: return
      //   1001: astore 11
      //   1003: goto -289 -> 714
      //   1006: astore 12
      //   1008: goto -54 -> 954
      //   1011: astore 12
      //   1013: goto -121 -> 892
      //   1016: astore 13
      //   1018: goto -175 -> 843
      //   1021: goto -887 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1024	0	this	a
      //   91	690	1	i	int
      //   326	47	2	j	int
      //   324	29	3	k	int
      //   40	115	4	m	int
      //   31	753	5	bool1	boolean
      //   28	960	6	bool2	boolean
      //   241	527	7	l1	long
      //   635	64	9	l2	long
      //   113	621	11	localObject1	Object
      //   819	5	11	localException1	java.lang.Exception
      //   845	85	11	localObject2	Object
      //   937	1	11	localException2	java.lang.Exception
      //   942	18	11	localObject3	Object
      //   1001	1	11	localException3	java.lang.Exception
      //   270	606	12	localObject4	Object
      //   887	21	12	localObject5	Object
      //   910	1	12	localFileNotFoundException	java.io.FileNotFoundException
      //   914	36	12	localObject6	Object
      //   1006	1	12	localException4	java.lang.Exception
      //   1011	1	12	localObject7	Object
      //   394	338	13	localObject8	Object
      //   838	12	13	localException5	java.lang.Exception
      //   868	106	13	localObject9	Object
      //   1016	1	13	localException6	java.lang.Exception
      //   476	405	14	localObject10	Object
      //   15	143	15	localLinkedList	LinkedList
      //   168	632	16	localarf	com.tencent.mm.protocal.protobuf.arf
      //   248	613	17	str1	String
      //   654	29	18	str2	String
      // Exception table:
      //   from	to	target	type
      //   490	511	819	java/lang/Exception
      //   519	535	838	java/lang/Exception
      //   519	535	887	finally
      //   594	601	910	java/io/FileNotFoundException
      //   609	622	910	java/io/FileNotFoundException
      //   630	637	910	java/io/FileNotFoundException
      //   645	656	910	java/io/FileNotFoundException
      //   664	672	910	java/io/FileNotFoundException
      //   680	688	910	java/io/FileNotFoundException
      //   696	704	910	java/io/FileNotFoundException
      //   929	934	937	java/lang/Exception
      //   594	601	942	finally
      //   609	622	942	finally
      //   630	637	942	finally
      //   645	656	942	finally
      //   664	672	942	finally
      //   680	688	942	finally
      //   696	704	942	finally
      //   916	924	942	finally
      //   709	714	1001	java/lang/Exception
      //   949	954	1006	java/lang/Exception
      //   539	546	1011	finally
      //   550	571	1011	finally
      //   847	866	1011	finally
      //   539	546	1016	java/lang/Exception
      //   550	571	1016	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a
 * JD-Core Version:    0.7.0.1
 */