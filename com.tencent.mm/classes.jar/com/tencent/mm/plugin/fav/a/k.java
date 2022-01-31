package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  implements w
{
  public boolean jZa = true;
  
  public static boolean h(xv paramxv)
  {
    if (paramxv == null) {}
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramxv.aYU)
          {
          case 3: 
          case 5: 
          case 6: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          default: 
            return false;
          }
        } while (!new com.tencent.mm.vfs.b(b.b(paramxv)).exists());
        return false;
        if (bk.ZR(com.tencent.mm.m.g.AA().getValue("SIGHTCannotTransmitForFav")) != 0)
        {
          y.w("MicroMsg.FavSendFilter", "can not retransmit short video");
          return true;
        }
      } while (!new com.tencent.mm.vfs.b(b.b(paramxv)).exists());
      return false;
      if (new com.tencent.mm.vfs.b(b.b(paramxv)).exists()) {
        return false;
      }
      return bk.bl(paramxv.sUN);
    } while ((bk.bl(paramxv.sUN)) && (bk.bl(paramxv.sUP)) && (bk.bl(paramxv.sUR)) && (bk.bl(paramxv.sUR)));
    return false;
  }
  
  public static boolean u(g paramg)
  {
    if (paramg == null) {
      return false;
    }
    if ((paramg.field_itemStatus > 0) && (!b.g(paramg))) {
      return false;
    }
    Object localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramg.field_localId);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(b.b(b.c(paramg)));
    switch (paramg.field_type)
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
          if ((paramg.field_id <= 0) && (localObject != null)) {
            return false;
          }
          if ((paramg.field_favProto == null) || (paramg.field_favProto.sXc.size() <= 1)) {
            return false;
          }
          paramg = paramg.field_favProto.sXc.iterator();
          do
          {
            if (!paramg.hasNext()) {
              break;
            }
            localObject = (xv)paramg.next();
          } while ((bk.bl(((xv)localObject).sUG)) || (bk.bl(((xv)localObject).sUI)) || (com.tencent.mm.vfs.e.bK(b.b((xv)localObject))));
          return true;
        } while (localb.exists());
        return true;
        if (bk.ZR(com.tencent.mm.m.g.AA().getValue("SIGHTCannotTransmitForFav")) != 0)
        {
          y.w("MicroMsg.FavSendFilter", "can not retransmit short video");
          return false;
        }
      } while (localb.exists());
      return true;
    } while ((!bk.bl(b.c(paramg).sUN)) || (localb.exists()));
    return true;
  }
  
  /* Error */
  public final boolean t(g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: aload_1
    //   7: invokestatic 169	com/tencent/mm/plugin/fav/a/b:f	(Lcom/tencent/mm/plugin/fav/a/g;)Z
    //   10: ifeq +5 -> 15
    //   13: iconst_1
    //   14: ireturn
    //   15: ldc 94
    //   17: invokestatic 100	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   20: checkcast 94	com/tencent/mm/plugin/fav/a/ae
    //   23: invokeinterface 104 1 0
    //   28: aload_1
    //   29: getfield 108	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   32: invokeinterface 114 3 0
    //   37: astore 6
    //   39: aload_1
    //   40: getfield 121	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   43: tableswitch	default:+85 -> 128, 1:+274->317, 2:+285->328, 3:+804->847, 4:+569->612, 5:+664->707, 6:+601->644, 7:+615->658, 8:+285->328, 9:+85->128, 10:+726->769, 11:+778->821, 12:+85->128, 13:+85->128, 14:+87->130, 15:+752->795, 16:+309->352, 17:+85->128, 18:+87->130
    //   129: ireturn
    //   130: aload_1
    //   131: getfield 124	com/tencent/mm/plugin/fav/a/g:field_id	I
    //   134: ifgt +10 -> 144
    //   137: aload 6
    //   139: ifnull +5 -> 144
    //   142: iconst_1
    //   143: ireturn
    //   144: aload_1
    //   145: getfield 121	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   148: bipush 18
    //   150: if_icmpne +26 -> 176
    //   153: aload_1
    //   154: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   157: ifnull +17 -> 174
    //   160: aload_1
    //   161: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   164: getfield 134	com/tencent/mm/protocal/c/yj:sXc	Ljava/util/LinkedList;
    //   167: invokevirtual 140	java/util/LinkedList:size	()I
    //   170: iconst_1
    //   171: if_icmpgt +5 -> 176
    //   174: iconst_1
    //   175: ireturn
    //   176: aload_1
    //   177: getfield 121	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   180: bipush 18
    //   182: if_icmpne +51 -> 233
    //   185: aload_1
    //   186: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   189: getfield 134	com/tencent/mm/protocal/c/yj:sXc	Ljava/util/LinkedList;
    //   192: iconst_0
    //   193: invokevirtual 173	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   196: checkcast 19	com/tencent/mm/protocal/c/xv
    //   199: getfield 156	com/tencent/mm/protocal/c/xv:sUG	Ljava/lang/String;
    //   202: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   205: ifne +26 -> 231
    //   208: aload_1
    //   209: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   212: getfield 134	com/tencent/mm/protocal/c/yj:sXc	Ljava/util/LinkedList;
    //   215: iconst_0
    //   216: invokevirtual 173	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   219: checkcast 19	com/tencent/mm/protocal/c/xv
    //   222: getfield 159	com/tencent/mm/protocal/c/xv:sUI	Ljava/lang/String;
    //   225: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   228: ifeq +5 -> 233
    //   231: iconst_1
    //   232: ireturn
    //   233: aload_1
    //   234: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   237: getfield 134	com/tencent/mm/protocal/c/yj:sXc	Ljava/util/LinkedList;
    //   240: invokevirtual 144	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   243: astore_1
    //   244: aload_1
    //   245: invokeinterface 149 1 0
    //   250: ifeq +65 -> 315
    //   253: aload_1
    //   254: invokeinterface 153 1 0
    //   259: checkcast 19	com/tencent/mm/protocal/c/xv
    //   262: astore 6
    //   264: aload 6
    //   266: getfield 23	com/tencent/mm/protocal/c/xv:aYU	I
    //   269: iconst_2
    //   270: if_icmpeq +32 -> 302
    //   273: aload 6
    //   275: getfield 23	com/tencent/mm/protocal/c/xv:aYU	I
    //   278: bipush 8
    //   280: if_icmpeq +22 -> 302
    //   283: aload 6
    //   285: getfield 23	com/tencent/mm/protocal/c/xv:aYU	I
    //   288: bipush 15
    //   290: if_icmpeq +12 -> 302
    //   293: aload 6
    //   295: getfield 23	com/tencent/mm/protocal/c/xv:aYU	I
    //   298: iconst_4
    //   299: if_icmpne -55 -> 244
    //   302: aload 6
    //   304: invokestatic 31	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   307: invokestatic 164	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   310: ifne -66 -> 244
    //   313: iconst_1
    //   314: ireturn
    //   315: iconst_0
    //   316: ireturn
    //   317: aload_1
    //   318: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   321: getfield 176	com/tencent/mm/protocal/c/yj:desc	Ljava/lang/String;
    //   324: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   327: ireturn
    //   328: new 25	com/tencent/mm/vfs/b
    //   331: dup
    //   332: aload_1
    //   333: invokestatic 118	com/tencent/mm/plugin/fav/a/b:c	(Lcom/tencent/mm/plugin/fav/a/g;)Lcom/tencent/mm/protocal/c/xv;
    //   336: invokestatic 31	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   339: invokespecial 34	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   342: invokevirtual 38	com/tencent/mm/vfs/b:exists	()Z
    //   345: ifne +5 -> 350
    //   348: iconst_1
    //   349: ireturn
    //   350: iconst_0
    //   351: ireturn
    //   352: invokestatic 44	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   355: ldc 46
    //   357: invokevirtual 52	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   360: invokestatic 58	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   363: ifeq +12 -> 375
    //   366: ldc 60
    //   368: ldc 62
    //   370: invokestatic 68	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: iconst_1
    //   374: ireturn
    //   375: aload_1
    //   376: invokestatic 118	com/tencent/mm/plugin/fav/a/b:c	(Lcom/tencent/mm/plugin/fav/a/g;)Lcom/tencent/mm/protocal/c/xv;
    //   379: astore 8
    //   381: new 25	com/tencent/mm/vfs/b
    //   384: dup
    //   385: aload 8
    //   387: invokestatic 31	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   390: invokespecial 34	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   393: astore 6
    //   395: ldc 60
    //   397: ldc 178
    //   399: iconst_4
    //   400: anewarray 4	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: aload_1
    //   406: getfield 124	com/tencent/mm/plugin/fav/a/g:field_id	I
    //   409: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   412: aastore
    //   413: dup
    //   414: iconst_1
    //   415: aload_1
    //   416: getfield 108	com/tencent/mm/plugin/fav/a/g:field_localId	J
    //   419: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   422: aastore
    //   423: dup
    //   424: iconst_2
    //   425: aload 6
    //   427: invokevirtual 193	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   430: invokestatic 199	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   433: aastore
    //   434: dup
    //   435: iconst_3
    //   436: aload 6
    //   438: invokevirtual 38	com/tencent/mm/vfs/b:exists	()Z
    //   441: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   444: aastore
    //   445: invokestatic 208	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: aload 6
    //   450: invokevirtual 38	com/tencent/mm/vfs/b:exists	()Z
    //   453: ifeq +157 -> 610
    //   456: aload 6
    //   458: invokevirtual 212	com/tencent/mm/vfs/b:length	()J
    //   461: lstore_2
    //   462: aload 8
    //   464: getfield 215	com/tencent/mm/protocal/c/xv:sVb	J
    //   467: lstore 4
    //   469: lload 4
    //   471: lload_2
    //   472: lsub
    //   473: invokestatic 221	java/lang/Math:abs	(J)J
    //   476: ldc2_w 222
    //   479: lcmp
    //   480: ifle +128 -> 608
    //   483: aload 6
    //   485: getfield 227	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   488: aconst_null
    //   489: invokestatic 230	com/tencent/mm/vfs/e:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/FileSystemManager$d;)Ljava/io/InputStream;
    //   492: astore_1
    //   493: aload_1
    //   494: sipush 4096
    //   497: invokestatic 235	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   500: astore 7
    //   502: aload 7
    //   504: astore 6
    //   506: aload_1
    //   507: ifnull +11 -> 518
    //   510: aload_1
    //   511: invokevirtual 240	java/io/InputStream:close	()V
    //   514: aload 7
    //   516: astore 6
    //   518: ldc 60
    //   520: ldc 242
    //   522: iconst_4
    //   523: anewarray 4	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: lload_2
    //   529: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   532: aastore
    //   533: dup
    //   534: iconst_1
    //   535: aload 6
    //   537: aastore
    //   538: dup
    //   539: iconst_2
    //   540: lload 4
    //   542: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   545: aastore
    //   546: dup
    //   547: iconst_3
    //   548: aload 8
    //   550: getfield 245	com/tencent/mm/protocal/c/xv:sUX	Ljava/lang/String;
    //   553: aastore
    //   554: invokestatic 247	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: iconst_1
    //   558: ireturn
    //   559: astore_1
    //   560: aconst_null
    //   561: astore_1
    //   562: aconst_null
    //   563: astore 7
    //   565: aload 7
    //   567: astore 6
    //   569: aload_1
    //   570: ifnull -52 -> 518
    //   573: aload_1
    //   574: invokevirtual 240	java/io/InputStream:close	()V
    //   577: aload 7
    //   579: astore 6
    //   581: goto -63 -> 518
    //   584: astore_1
    //   585: aload 7
    //   587: astore 6
    //   589: goto -71 -> 518
    //   592: astore_1
    //   593: aconst_null
    //   594: astore 6
    //   596: aload 6
    //   598: ifnull +8 -> 606
    //   601: aload 6
    //   603: invokevirtual 240	java/io/InputStream:close	()V
    //   606: aload_1
    //   607: athrow
    //   608: iconst_0
    //   609: ireturn
    //   610: iconst_1
    //   611: ireturn
    //   612: aload_1
    //   613: invokestatic 118	com/tencent/mm/plugin/fav/a/b:c	(Lcom/tencent/mm/plugin/fav/a/g;)Lcom/tencent/mm/protocal/c/xv;
    //   616: astore_1
    //   617: new 25	com/tencent/mm/vfs/b
    //   620: dup
    //   621: aload_1
    //   622: invokestatic 31	com/tencent/mm/plugin/fav/a/b:b	(Lcom/tencent/mm/protocal/c/xv;)Ljava/lang/String;
    //   625: invokespecial 34	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   628: invokevirtual 38	com/tencent/mm/vfs/b:exists	()Z
    //   631: ifeq +5 -> 636
    //   634: iconst_0
    //   635: ireturn
    //   636: aload_1
    //   637: getfield 72	com/tencent/mm/protocal/c/xv:sUN	Ljava/lang/String;
    //   640: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   643: ireturn
    //   644: aload_1
    //   645: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   648: getfield 251	com/tencent/mm/protocal/c/yj:sWf	Lcom/tencent/mm/protocal/c/yc;
    //   651: ifnonnull +5 -> 656
    //   654: iconst_1
    //   655: ireturn
    //   656: iconst_0
    //   657: ireturn
    //   658: aload_1
    //   659: invokestatic 118	com/tencent/mm/plugin/fav/a/b:c	(Lcom/tencent/mm/plugin/fav/a/g;)Lcom/tencent/mm/protocal/c/xv;
    //   662: astore_1
    //   663: aload_1
    //   664: getfield 72	com/tencent/mm/protocal/c/xv:sUN	Ljava/lang/String;
    //   667: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   670: ifeq +35 -> 705
    //   673: aload_1
    //   674: getfield 79	com/tencent/mm/protocal/c/xv:sUP	Ljava/lang/String;
    //   677: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   680: ifeq +25 -> 705
    //   683: aload_1
    //   684: getfield 82	com/tencent/mm/protocal/c/xv:sUR	Ljava/lang/String;
    //   687: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   690: ifeq +15 -> 705
    //   693: aload_1
    //   694: getfield 82	com/tencent/mm/protocal/c/xv:sUR	Ljava/lang/String;
    //   697: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   700: ifeq +5 -> 705
    //   703: iconst_1
    //   704: ireturn
    //   705: iconst_0
    //   706: ireturn
    //   707: aload_1
    //   708: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   711: getfield 255	com/tencent/mm/protocal/c/yj:sXa	Lcom/tencent/mm/protocal/c/yp;
    //   714: astore 7
    //   716: aload_1
    //   717: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   720: getfield 259	com/tencent/mm/protocal/c/yj:sWh	Lcom/tencent/mm/protocal/c/yy;
    //   723: astore 6
    //   725: aconst_null
    //   726: astore_1
    //   727: aload 6
    //   729: ifnull +9 -> 738
    //   732: aload 6
    //   734: getfield 264	com/tencent/mm/protocal/c/yy:sXG	Ljava/lang/String;
    //   737: astore_1
    //   738: aload_1
    //   739: astore 6
    //   741: aload 7
    //   743: ifnull +20 -> 763
    //   746: aload_1
    //   747: astore 6
    //   749: aload_1
    //   750: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   753: ifeq +10 -> 763
    //   756: aload 7
    //   758: getfield 269	com/tencent/mm/protocal/c/yp:eAl	Ljava/lang/String;
    //   761: astore 6
    //   763: aload 6
    //   765: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   768: ireturn
    //   769: aload_1
    //   770: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   773: getfield 273	com/tencent/mm/protocal/c/yj:sWj	Lcom/tencent/mm/protocal/c/yi;
    //   776: astore_1
    //   777: aload_1
    //   778: ifnull +13 -> 791
    //   781: aload_1
    //   782: getfield 278	com/tencent/mm/protocal/c/yi:info	Ljava/lang/String;
    //   785: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   788: ifeq +5 -> 793
    //   791: iconst_1
    //   792: ireturn
    //   793: iconst_0
    //   794: ireturn
    //   795: aload_1
    //   796: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   799: getfield 282	com/tencent/mm/protocal/c/yj:sWl	Lcom/tencent/mm/protocal/c/ys;
    //   802: astore_1
    //   803: aload_1
    //   804: ifnull +13 -> 817
    //   807: aload_1
    //   808: getfield 285	com/tencent/mm/protocal/c/ys:info	Ljava/lang/String;
    //   811: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   814: ifeq +5 -> 819
    //   817: iconst_1
    //   818: ireturn
    //   819: iconst_0
    //   820: ireturn
    //   821: aload_1
    //   822: getfield 128	com/tencent/mm/plugin/fav/a/g:field_favProto	Lcom/tencent/mm/protocal/c/yj;
    //   825: getfield 273	com/tencent/mm/protocal/c/yj:sWj	Lcom/tencent/mm/protocal/c/yi;
    //   828: astore_1
    //   829: aload_1
    //   830: ifnull +13 -> 843
    //   833: aload_1
    //   834: getfield 278	com/tencent/mm/protocal/c/yi:info	Ljava/lang/String;
    //   837: invokestatic 76	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   840: ifeq +5 -> 845
    //   843: iconst_1
    //   844: ireturn
    //   845: iconst_0
    //   846: ireturn
    //   847: aload_0
    //   848: getfield 14	com/tencent/mm/plugin/fav/a/k:jZa	Z
    //   851: ifeq +5 -> 856
    //   854: iconst_1
    //   855: ireturn
    //   856: iconst_0
    //   857: ireturn
    //   858: astore_1
    //   859: aload 7
    //   861: astore 6
    //   863: goto -345 -> 518
    //   866: astore 6
    //   868: goto -262 -> 606
    //   871: astore 6
    //   873: aload_1
    //   874: astore 7
    //   876: aload 6
    //   878: astore_1
    //   879: aload 7
    //   881: astore 6
    //   883: goto -287 -> 596
    //   886: astore 6
    //   888: goto -326 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	k
    //   0	891	1	paramg	g
    //   461	68	2	l1	long
    //   467	74	4	l2	long
    //   37	825	6	localObject1	Object
    //   866	1	6	localIOException1	java.io.IOException
    //   871	6	6	localObject2	Object
    //   881	1	6	localObject3	Object
    //   886	1	6	localIOException2	java.io.IOException
    //   500	380	7	localObject4	Object
    //   379	170	8	localxv	xv
    // Exception table:
    //   from	to	target	type
    //   483	493	559	java/io/IOException
    //   573	577	584	java/io/IOException
    //   483	493	592	finally
    //   510	514	858	java/io/IOException
    //   601	606	866	java/io/IOException
    //   493	502	871	finally
    //   493	502	886	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.k
 * JD-Core Version:    0.7.0.1
 */