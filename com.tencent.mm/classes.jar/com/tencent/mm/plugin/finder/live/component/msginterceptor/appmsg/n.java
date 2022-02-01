package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.context.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveMicLinkStateInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends f
{
  public n(a parama)
  {
    super(parama);
    AppMethodBeat.i(353286);
    AppMethodBeat.o(353286);
  }
  
  /* Error */
  public final void ap(java.util.LinkedList<com.tencent.mm.protocal.protobuf.bdm> paramLinkedList)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 54
    //   8: invokestatic 35	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 58	com/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/n:eji	()Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   15: ldc 60
    //   17: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   20: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   23: astore 16
    //   25: aload_1
    //   26: ldc 68
    //   28: invokestatic 35	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload 16
    //   33: getfield 74	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:CBK	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   36: astore 15
    //   38: new 76	java/util/LinkedList
    //   41: dup
    //   42: invokespecial 79	java/util/LinkedList:<init>	()V
    //   45: astore 17
    //   47: aload_1
    //   48: checkcast 81	java/lang/Iterable
    //   51: astore 12
    //   53: new 83	java/util/ArrayList
    //   56: dup
    //   57: invokespecial 84	java/util/ArrayList:<init>	()V
    //   60: checkcast 86	java/util/Collection
    //   63: astore 11
    //   65: aload 12
    //   67: invokeinterface 90 1 0
    //   72: astore 12
    //   74: aload 12
    //   76: invokeinterface 96 1 0
    //   81: ifeq +48 -> 129
    //   84: aload 12
    //   86: invokeinterface 100 1 0
    //   91: astore 13
    //   93: aload 13
    //   95: checkcast 102	com/tencent/mm/protocal/protobuf/bdm
    //   98: astore 14
    //   100: aload 16
    //   102: getfield 106	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfN	[I
    //   105: aload 14
    //   107: getfield 110	com/tencent/mm/protocal/protobuf/bdm:msg_type	I
    //   110: invokestatic 116	kotlin/a/k:contains	([II)Z
    //   113: ifeq -39 -> 74
    //   116: aload 11
    //   118: aload 13
    //   120: invokeinterface 120 2 0
    //   125: pop
    //   126: goto -52 -> 74
    //   129: aload 17
    //   131: aload 11
    //   133: checkcast 122	java/util/List
    //   136: checkcast 86	java/util/Collection
    //   139: invokevirtual 126	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   142: pop
    //   143: aload 17
    //   145: checkcast 81	java/lang/Iterable
    //   148: invokeinterface 90 1 0
    //   153: astore 18
    //   155: aload 18
    //   157: invokeinterface 96 1 0
    //   162: ifeq +1787 -> 1949
    //   165: aload 18
    //   167: invokeinterface 100 1 0
    //   172: checkcast 102	com/tencent/mm/protocal/protobuf/bdm
    //   175: astore 21
    //   177: new 128	com/tencent/mm/protocal/protobuf/bdo
    //   180: dup
    //   181: invokespecial 129	com/tencent/mm/protocal/protobuf/bdo:<init>	()V
    //   184: astore 19
    //   186: aload 19
    //   188: checkcast 131	com/tencent/mm/bx/a
    //   191: astore 12
    //   193: aload 21
    //   195: getfield 135	com/tencent/mm/protocal/protobuf/bdm:ZNY	Lcom/tencent/mm/bx/b;
    //   198: astore 11
    //   200: aload 11
    //   202: ifnonnull +658 -> 860
    //   205: aconst_null
    //   206: astore 11
    //   208: aload 12
    //   210: aload 11
    //   212: invokevirtual 139	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   215: pop
    //   216: new 141	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 143
    //   222: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: ldc 148
    //   227: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   230: checkcast 148	com/tencent/mm/plugin/k
    //   233: invokeinterface 157 1 0
    //   238: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc 163
    //   243: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: astore 12
    //   248: aload 21
    //   250: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   253: astore 11
    //   255: aload 11
    //   257: ifnonnull +636 -> 893
    //   260: aconst_null
    //   261: astore 11
    //   263: aload 12
    //   265: aload 11
    //   267: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: ldc 175
    //   272: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: astore 12
    //   277: aload 21
    //   279: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   282: astore 11
    //   284: aload 11
    //   286: ifnonnull +635 -> 921
    //   289: aconst_null
    //   290: astore 11
    //   292: aload 12
    //   294: aload 11
    //   296: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: ldc 177
    //   301: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: astore 12
    //   306: aload 19
    //   308: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   311: astore 11
    //   313: aload 11
    //   315: ifnonnull +634 -> 949
    //   318: aconst_null
    //   319: astore 11
    //   321: ldc 183
    //   323: aload 12
    //   325: aload 11
    //   327: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: ldc 185
    //   332: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 19
    //   337: getfield 188	com/tencent/mm/protocal/protobuf/bdo:ZOf	I
    //   340: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc 193
    //   345: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 21
    //   350: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   353: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: ldc 199
    //   358: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 19
    //   363: getfield 203	com/tencent/mm/protocal/protobuf/bdo:seq	J
    //   366: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: bipush 93
    //   371: invokevirtual 209	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   374: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 21
    //   382: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   385: astore 20
    //   387: aload 20
    //   389: ifnull -234 -> 155
    //   392: ldc 148
    //   394: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   397: checkcast 148	com/tencent/mm/plugin/k
    //   400: invokeinterface 221 1 0
    //   405: ifne +571 -> 976
    //   408: aload 15
    //   410: ldc 60
    //   412: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   415: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   418: getfield 225	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfG	Ljava/util/HashMap;
    //   421: aload 20
    //   423: invokevirtual 231	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   426: checkcast 233	java/lang/Integer
    //   429: astore 11
    //   431: aload 11
    //   433: ifnonnull +526 -> 959
    //   436: aload 16
    //   438: getfield 225	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfG	Ljava/util/HashMap;
    //   441: checkcast 235	java/util/Map
    //   444: aload 20
    //   446: iconst_2
    //   447: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: invokeinterface 243 3 0
    //   455: pop
    //   456: aload 15
    //   458: ldc 60
    //   460: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   463: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   466: getfield 247	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfH	Ljava/util/List;
    //   469: astore 11
    //   471: aload 11
    //   473: ldc 249
    //   475: invokestatic 252	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   478: aload 11
    //   480: checkcast 81	java/lang/Iterable
    //   483: astore 14
    //   485: aload 14
    //   487: monitorenter
    //   488: aload 14
    //   490: invokeinterface 90 1 0
    //   495: astore 22
    //   497: aload 22
    //   499: invokeinterface 96 1 0
    //   504: ifeq +495 -> 999
    //   507: aload 22
    //   509: invokeinterface 100 1 0
    //   514: astore 13
    //   516: aload 13
    //   518: checkcast 254	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   521: astore 23
    //   523: aload 19
    //   525: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   528: astore 11
    //   530: aload 11
    //   532: ifnonnull +457 -> 989
    //   535: aconst_null
    //   536: astore 11
    //   538: aload 11
    //   540: astore 12
    //   542: aload 11
    //   544: ifnonnull +10 -> 554
    //   547: aload 19
    //   549: getfield 257	com/tencent/mm/protocal/protobuf/bdo:ZlX	Ljava/lang/String;
    //   552: astore 12
    //   554: aload 12
    //   556: aload 23
    //   558: getfield 260	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXL	Ljava/lang/String;
    //   561: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   564: istore 5
    //   566: iload 5
    //   568: ifeq -71 -> 497
    //   571: aload 13
    //   573: astore 11
    //   575: aload 14
    //   577: monitorexit
    //   578: aload 11
    //   580: checkcast 254	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   583: astore 22
    //   585: aload 19
    //   587: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   590: astore 11
    //   592: aload 11
    //   594: ifnonnull +422 -> 1016
    //   597: aconst_null
    //   598: astore 11
    //   600: aload 11
    //   602: astore 14
    //   604: aload 11
    //   606: ifnonnull +10 -> 616
    //   609: aload 19
    //   611: getfield 257	com/tencent/mm/protocal/protobuf/bdo:ZlX	Ljava/lang/String;
    //   614: astore 14
    //   616: aload 19
    //   618: getfield 269	com/tencent/mm/protocal/protobuf/bdo:ZOh	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   621: astore 11
    //   623: aload 11
    //   625: ifnonnull +401 -> 1026
    //   628: aconst_null
    //   629: astore 11
    //   631: aload 19
    //   633: getfield 269	com/tencent/mm/protocal/protobuf/bdo:ZOh	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   636: astore 12
    //   638: aload 12
    //   640: ifnonnull +414 -> 1054
    //   643: aconst_null
    //   644: astore 12
    //   646: aload 19
    //   648: getfield 269	com/tencent/mm/protocal/protobuf/bdo:ZOh	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   651: astore 13
    //   653: aload 13
    //   655: ifnonnull +427 -> 1082
    //   658: aconst_null
    //   659: astore 13
    //   661: aload 19
    //   663: getfield 188	com/tencent/mm/protocal/protobuf/bdo:ZOf	I
    //   666: istore_3
    //   667: aload 21
    //   669: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   672: astore 23
    //   674: aload 19
    //   676: getfield 269	com/tencent/mm/protocal/protobuf/bdo:ZOh	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   679: astore 24
    //   681: aload 24
    //   683: ifnonnull +427 -> 1110
    //   686: iconst_0
    //   687: istore_2
    //   688: aload 22
    //   690: ifnonnull +429 -> 1119
    //   693: iconst_0
    //   694: istore 5
    //   696: new 254	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   699: dup
    //   700: aload 14
    //   702: aload 11
    //   704: aload 12
    //   706: aload 13
    //   708: iload_3
    //   709: aload 23
    //   711: aconst_null
    //   712: iconst_0
    //   713: iconst_0
    //   714: aconst_null
    //   715: aconst_null
    //   716: iconst_0
    //   717: iload_2
    //   718: iload 5
    //   720: aconst_null
    //   721: lconst_0
    //   722: aload 19
    //   724: getfield 269	com/tencent/mm/protocal/protobuf/bdo:ZOh	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   727: iconst_0
    //   728: ldc_w 270
    //   731: invokespecial 273	com/tencent/mm/plugin/finder/live/viewmodel/data/h:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/bx/b;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;IIZLjava/lang/String;JLcom/tencent/mm/protocal/protobuf/bgh;ZI)V
    //   734: astore 11
    //   736: aload 16
    //   738: aload 11
    //   740: invokevirtual 277	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:h	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   743: iconst_0
    //   744: istore_2
    //   745: aload 15
    //   747: ldc 60
    //   749: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   752: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   755: getfield 280	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efx	Ljava/util/List;
    //   758: astore 12
    //   760: aload 12
    //   762: ldc_w 282
    //   765: invokestatic 252	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   768: aload 12
    //   770: checkcast 81	java/lang/Iterable
    //   773: astore 12
    //   775: aload 12
    //   777: monitorenter
    //   778: aload 12
    //   780: invokeinterface 90 1 0
    //   785: astore 13
    //   787: aload 13
    //   789: invokeinterface 96 1 0
    //   794: ifeq +335 -> 1129
    //   797: aload 13
    //   799: invokeinterface 100 1 0
    //   804: checkcast 254	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   807: astore 14
    //   809: aload 15
    //   811: ldc 60
    //   813: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   816: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   819: getfield 247	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfH	Ljava/util/List;
    //   822: astore 22
    //   824: aload 22
    //   826: ldc 249
    //   828: invokestatic 252	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   831: aload 22
    //   833: new 284	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j$b
    //   836: dup
    //   837: aload 14
    //   839: invokespecial 286	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j$b:<init>	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   842: checkcast 288	kotlin/g/a/b
    //   845: invokestatic 294	com/tencent/mm/ae/d:a	(Ljava/util/List;Lkotlin/g/a/b;)Z
    //   848: istore 5
    //   850: iload 5
    //   852: ifeq +2931 -> 3783
    //   855: iconst_1
    //   856: istore_2
    //   857: goto -70 -> 787
    //   860: aload 11
    //   862: invokevirtual 300	com/tencent/mm/bx/b:toByteArray	()[B
    //   865: astore 11
    //   867: goto -659 -> 208
    //   870: astore 11
    //   872: ldc_w 302
    //   875: ldc_w 303
    //   878: iconst_1
    //   879: anewarray 305	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: aload 11
    //   886: aastore
    //   887: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: goto -674 -> 216
    //   893: aload 11
    //   895: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   898: astore 11
    //   900: aload 11
    //   902: ifnonnull +9 -> 911
    //   905: aconst_null
    //   906: astore 11
    //   908: goto -645 -> 263
    //   911: aload 11
    //   913: getfield 320	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   916: astore 11
    //   918: goto -655 -> 263
    //   921: aload 11
    //   923: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   926: astore 11
    //   928: aload 11
    //   930: ifnonnull +9 -> 939
    //   933: aconst_null
    //   934: astore 11
    //   936: goto -644 -> 292
    //   939: aload 11
    //   941: getfield 323	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   944: astore 11
    //   946: goto -654 -> 292
    //   949: aload 11
    //   951: getfield 328	com/tencent/mm/protocal/protobuf/dix:aaNn	Ljava/lang/String;
    //   954: astore 11
    //   956: goto -635 -> 321
    //   959: aload 11
    //   961: invokevirtual 332	java/lang/Integer:intValue	()I
    //   964: iconst_3
    //   965: if_icmpne -529 -> 436
    //   968: ldc 183
    //   970: ldc_w 334
    //   973: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   976: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   979: astore 11
    //   981: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   984: astore 11
    //   986: goto -831 -> 155
    //   989: aload 11
    //   991: getfield 328	com/tencent/mm/protocal/protobuf/dix:aaNn	Ljava/lang/String;
    //   994: astore 11
    //   996: goto -458 -> 538
    //   999: aconst_null
    //   1000: astore 11
    //   1002: goto -427 -> 575
    //   1005: astore_1
    //   1006: aload 14
    //   1008: monitorexit
    //   1009: ldc 53
    //   1011: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1014: aload_1
    //   1015: athrow
    //   1016: aload 11
    //   1018: getfield 328	com/tencent/mm/protocal/protobuf/dix:aaNn	Ljava/lang/String;
    //   1021: astore 11
    //   1023: goto -423 -> 600
    //   1026: aload 11
    //   1028: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   1031: astore 11
    //   1033: aload 11
    //   1035: ifnonnull +9 -> 1044
    //   1038: aconst_null
    //   1039: astore 11
    //   1041: goto -410 -> 631
    //   1044: aload 11
    //   1046: getfield 343	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   1049: astore 11
    //   1051: goto -420 -> 631
    //   1054: aload 12
    //   1056: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   1059: astore 12
    //   1061: aload 12
    //   1063: ifnonnull +9 -> 1072
    //   1066: aconst_null
    //   1067: astore 12
    //   1069: goto -423 -> 646
    //   1072: aload 12
    //   1074: getfield 320	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   1077: astore 12
    //   1079: goto -433 -> 646
    //   1082: aload 13
    //   1084: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   1087: astore 13
    //   1089: aload 13
    //   1091: ifnonnull +9 -> 1100
    //   1094: aconst_null
    //   1095: astore 13
    //   1097: goto -436 -> 661
    //   1100: aload 13
    //   1102: getfield 323	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   1105: astore 13
    //   1107: goto -446 -> 661
    //   1110: aload 24
    //   1112: getfield 346	com/tencent/mm/protocal/protobuf/bgh:ZPS	I
    //   1115: istore_2
    //   1116: goto -428 -> 688
    //   1119: aload 22
    //   1121: getfield 350	com/tencent/mm/plugin/finder/live/viewmodel/data/h:EbG	Z
    //   1124: istore 5
    //   1126: goto -430 -> 696
    //   1129: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1132: astore 13
    //   1134: aload 12
    //   1136: monitorexit
    //   1137: aload 15
    //   1139: ldc 60
    //   1141: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1144: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1147: getfield 247	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfH	Ljava/util/List;
    //   1150: invokeinterface 353 1 0
    //   1155: iload_2
    //   1156: ifeq +40 -> 1196
    //   1159: aload 15
    //   1161: ldc_w 355
    //   1164: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1167: checkcast 355	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1170: aload 11
    //   1172: invokevirtual 358	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:g	(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;)V
    //   1175: aload 16
    //   1177: getfield 361	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfM	Z
    //   1180: ifeq +498 -> 1678
    //   1183: ldc 148
    //   1185: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1188: checkcast 148	com/tencent/mm/plugin/k
    //   1191: invokeinterface 364 1 0
    //   1196: aload 15
    //   1198: ldc_w 355
    //   1201: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1204: checkcast 355	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1207: invokevirtual 367	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyF	()Ljava/lang/String;
    //   1210: astore 12
    //   1212: aload 19
    //   1214: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1217: astore 11
    //   1219: aload 11
    //   1221: ifnonnull +473 -> 1694
    //   1224: aconst_null
    //   1225: astore 11
    //   1227: aload 12
    //   1229: aload 11
    //   1231: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1234: ifeq -258 -> 976
    //   1237: aload 15
    //   1239: ldc 60
    //   1241: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1244: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   1247: iconst_0
    //   1248: putfield 370	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   1251: aload 15
    //   1253: ldc_w 372
    //   1256: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1259: checkcast 372	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1262: getfield 376	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   1265: getfield 381	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   1268: lstore 9
    //   1270: aload 21
    //   1272: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   1275: astore 21
    //   1277: aload 19
    //   1279: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1282: astore 11
    //   1284: aload 11
    //   1286: ifnonnull +418 -> 1704
    //   1289: aconst_null
    //   1290: astore 14
    //   1292: aload 19
    //   1294: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1297: astore 11
    //   1299: aload 11
    //   1301: ifnonnull +413 -> 1714
    //   1304: iconst_0
    //   1305: istore_2
    //   1306: aload 19
    //   1308: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1311: astore 11
    //   1313: aload 11
    //   1315: ifnonnull +408 -> 1723
    //   1318: iconst_0
    //   1319: istore_3
    //   1320: aload 19
    //   1322: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1325: astore 11
    //   1327: aload 11
    //   1329: ifnonnull +403 -> 1732
    //   1332: iconst_0
    //   1333: istore 4
    //   1335: aload 19
    //   1337: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1340: astore 11
    //   1342: aload 11
    //   1344: ifnonnull +398 -> 1742
    //   1347: aconst_null
    //   1348: astore 11
    //   1350: aload 19
    //   1352: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1355: astore 12
    //   1357: aload 12
    //   1359: ifnonnull +411 -> 1770
    //   1362: aconst_null
    //   1363: astore 12
    //   1365: aload 19
    //   1367: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1370: astore 13
    //   1372: aload 13
    //   1374: ifnonnull +424 -> 1798
    //   1377: lconst_0
    //   1378: lstore 7
    //   1380: aload 19
    //   1382: getfield 181	com/tencent/mm/protocal/protobuf/bdo:ZOg	Lcom/tencent/mm/protocal/protobuf/dix;
    //   1385: astore 13
    //   1387: aload 13
    //   1389: ifnonnull +419 -> 1808
    //   1392: aconst_null
    //   1393: astore 13
    //   1395: new 383	com/tencent/mm/live/model/a
    //   1398: dup
    //   1399: lload 9
    //   1401: aload 21
    //   1403: aload 14
    //   1405: iload_2
    //   1406: iload_3
    //   1407: iload 4
    //   1409: aload 11
    //   1411: aload 12
    //   1413: lload 7
    //   1415: aload 13
    //   1417: aload 19
    //   1419: getfield 188	com/tencent/mm/protocal/protobuf/bdo:ZOf	I
    //   1422: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1425: aload 19
    //   1427: getfield 203	com/tencent/mm/protocal/protobuf/bdo:seq	J
    //   1430: aconst_null
    //   1431: iconst_0
    //   1432: sipush 28672
    //   1435: invokespecial 386	com/tencent/mm/live/model/a:<init>	(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JLjava/lang/String;ZI)V
    //   1438: astore 11
    //   1440: aload 15
    //   1442: ldc_w 355
    //   1445: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1448: checkcast 355	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1451: invokevirtual 367	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyF	()Ljava/lang/String;
    //   1454: aload 11
    //   1456: getfield 389	com/tencent/mm/live/model/a:userId	Ljava/lang/String;
    //   1459: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1462: ifeq +455 -> 1917
    //   1465: ldc 148
    //   1467: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1470: checkcast 148	com/tencent/mm/plugin/k
    //   1473: aload 11
    //   1475: invokeinterface 392 2 0
    //   1480: aload 15
    //   1482: ldc_w 355
    //   1485: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1488: checkcast 355	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   1491: invokevirtual 395	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyu	()I
    //   1494: istore_2
    //   1495: getstatic 401	com/tencent/mm/live/core/core/e$b:mKf	Lcom/tencent/mm/live/core/core/e$b;
    //   1498: astore 12
    //   1500: iload_2
    //   1501: invokestatic 404	com/tencent/mm/live/core/core/e$b:bct	()I
    //   1504: if_icmpne +332 -> 1836
    //   1507: ldc 148
    //   1509: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1512: checkcast 148	com/tencent/mm/plugin/k
    //   1515: aload 16
    //   1517: getfield 74	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:CBK	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   1520: aload 19
    //   1522: getfield 188	com/tencent/mm/protocal/protobuf/bdo:ZOf	I
    //   1525: invokeinterface 407 3 0
    //   1530: getstatic 413	com/tencent/mm/live/model/p:mZf	Lcom/tencent/mm/live/model/p;
    //   1533: astore 12
    //   1535: invokestatic 417	com/tencent/mm/live/model/p:bhS	()Lcom/tencent/mm/live/model/g;
    //   1538: astore 12
    //   1540: aload 12
    //   1542: ifnull +17 -> 1559
    //   1545: aload 12
    //   1547: aload 11
    //   1549: invokeinterface 422 2 0
    //   1554: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1557: astore 11
    //   1559: ldc 148
    //   1561: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1564: checkcast 148	com/tencent/mm/plugin/k
    //   1567: invokeinterface 426 1 0
    //   1572: astore 11
    //   1574: aload 11
    //   1576: ifnull +14 -> 1590
    //   1579: aload 11
    //   1581: iconst_0
    //   1582: invokevirtual 432	com/tencent/mm/live/core/core/trtc/a:muteLocalVideo	(Z)V
    //   1585: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1588: astore 11
    //   1590: ldc 148
    //   1592: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1595: checkcast 148	com/tencent/mm/plugin/k
    //   1598: invokeinterface 426 1 0
    //   1603: astore 11
    //   1605: aload 11
    //   1607: ifnull +14 -> 1621
    //   1610: aload 11
    //   1612: iconst_0
    //   1613: invokevirtual 435	com/tencent/mm/live/core/core/trtc/a:muteLocalAudio	(Z)V
    //   1616: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1619: astore 11
    //   1621: ldc 148
    //   1623: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1626: checkcast 148	com/tencent/mm/plugin/k
    //   1629: invokeinterface 438 1 0
    //   1634: ldc 148
    //   1636: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1639: astore 11
    //   1641: aload 11
    //   1643: ldc_w 440
    //   1646: invokestatic 252	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1649: aload 11
    //   1651: checkcast 148	com/tencent/mm/plugin/k
    //   1654: invokeinterface 443 1 0
    //   1659: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1662: astore 11
    //   1664: goto -688 -> 976
    //   1667: astore_1
    //   1668: aload 12
    //   1670: monitorexit
    //   1671: ldc 53
    //   1673: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1676: aload_1
    //   1677: athrow
    //   1678: ldc 148
    //   1680: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1683: checkcast 148	com/tencent/mm/plugin/k
    //   1686: invokeinterface 446 1 0
    //   1691: goto -495 -> 1196
    //   1694: aload 11
    //   1696: getfield 328	com/tencent/mm/protocal/protobuf/dix:aaNn	Ljava/lang/String;
    //   1699: astore 11
    //   1701: goto -474 -> 1227
    //   1704: aload 11
    //   1706: getfield 328	com/tencent/mm/protocal/protobuf/dix:aaNn	Ljava/lang/String;
    //   1709: astore 14
    //   1711: goto -419 -> 1292
    //   1714: aload 11
    //   1716: getfield 449	com/tencent/mm/protocal/protobuf/dix:aaOq	I
    //   1719: istore_2
    //   1720: goto -414 -> 1306
    //   1723: aload 11
    //   1725: getfield 452	com/tencent/mm/protocal/protobuf/dix:aaOs	I
    //   1728: istore_3
    //   1729: goto -409 -> 1320
    //   1732: aload 11
    //   1734: getfield 455	com/tencent/mm/protocal/protobuf/dix:aaOr	I
    //   1737: istore 4
    //   1739: goto -404 -> 1335
    //   1742: aload 11
    //   1744: getfield 458	com/tencent/mm/protocal/protobuf/dix:aaOt	Lcom/tencent/mm/bx/b;
    //   1747: astore 11
    //   1749: aload 11
    //   1751: ifnonnull +9 -> 1760
    //   1754: aconst_null
    //   1755: astore 11
    //   1757: goto -407 -> 1350
    //   1760: aload 11
    //   1762: invokevirtual 461	com/tencent/mm/bx/b:ZV	()Ljava/lang/String;
    //   1765: astore 11
    //   1767: goto -417 -> 1350
    //   1770: aload 12
    //   1772: getfield 464	com/tencent/mm/protocal/protobuf/dix:aaOu	Lcom/tencent/mm/bx/b;
    //   1775: astore 12
    //   1777: aload 12
    //   1779: ifnonnull +9 -> 1788
    //   1782: aconst_null
    //   1783: astore 12
    //   1785: goto -420 -> 1365
    //   1788: aload 12
    //   1790: invokevirtual 461	com/tencent/mm/bx/b:ZV	()Ljava/lang/String;
    //   1793: astore 12
    //   1795: goto -430 -> 1365
    //   1798: aload 13
    //   1800: getfield 467	com/tencent/mm/protocal/protobuf/dix:aaOy	J
    //   1803: lstore 7
    //   1805: goto -425 -> 1380
    //   1808: aload 13
    //   1810: getfield 470	com/tencent/mm/protocal/protobuf/dix:aaOv	Lcom/tencent/mm/bx/b;
    //   1813: astore 13
    //   1815: aload 13
    //   1817: ifnonnull +9 -> 1826
    //   1820: aconst_null
    //   1821: astore 13
    //   1823: goto -428 -> 1395
    //   1826: aload 13
    //   1828: getfield 474	com/tencent/mm/bx/b:Op	[B
    //   1831: astore 13
    //   1833: goto -438 -> 1395
    //   1836: aload 15
    //   1838: ldc_w 372
    //   1841: invokevirtual 66	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   1844: checkcast 372	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   1847: getfield 478	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:mZu	Lcom/tencent/mm/live/core/core/model/h;
    //   1850: astore 12
    //   1852: aload 12
    //   1854: ifnull -220 -> 1634
    //   1857: ldc 148
    //   1859: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1862: astore 13
    //   1864: aload 13
    //   1866: ldc_w 440
    //   1869: invokestatic 252	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1872: aload 13
    //   1874: checkcast 148	com/tencent/mm/plugin/k
    //   1877: aload 12
    //   1879: new 480	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j$c
    //   1882: dup
    //   1883: aload 15
    //   1885: aload 20
    //   1887: aload 16
    //   1889: aload 19
    //   1891: aload 11
    //   1893: invokespecial 483	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j$c:<init>	(Lcom/tencent/mm/plugin/finder/live/model/context/a;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/j;Lcom/tencent/mm/protocal/protobuf/bdo;Lcom/tencent/mm/live/model/a;)V
    //   1896: checkcast 288	kotlin/g/a/b
    //   1899: invokeinterface 487 3 0
    //   1904: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1907: astore 11
    //   1909: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1912: astore 11
    //   1914: goto -280 -> 1634
    //   1917: getstatic 413	com/tencent/mm/live/model/p:mZf	Lcom/tencent/mm/live/model/p;
    //   1920: astore 12
    //   1922: invokestatic 417	com/tencent/mm/live/model/p:bhS	()Lcom/tencent/mm/live/model/g;
    //   1925: astore 12
    //   1927: aload 12
    //   1929: ifnull -270 -> 1659
    //   1932: aload 12
    //   1934: aload 11
    //   1936: invokeinterface 422 2 0
    //   1941: getstatic 340	kotlin/ah:aiuX	Lkotlin/ah;
    //   1944: astore 11
    //   1946: goto -287 -> 1659
    //   1949: ldc 183
    //   1951: new 141	java/lang/StringBuilder
    //   1954: dup
    //   1955: ldc_w 489
    //   1958: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1961: aload 17
    //   1963: invokevirtual 492	java/util/LinkedList:size	()I
    //   1966: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1969: ldc_w 494
    //   1972: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: ldc 148
    //   1977: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1980: checkcast 148	com/tencent/mm/plugin/k
    //   1983: invokeinterface 157 1 0
    //   1988: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1991: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1994: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1997: aload 16
    //   1999: aload_1
    //   2000: invokevirtual 497	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aE	(Ljava/util/LinkedList;)V
    //   2003: aload 16
    //   2005: aload_1
    //   2006: invokevirtual 501	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aK	(Ljava/util/LinkedList;)Ljava/util/LinkedList;
    //   2009: astore 17
    //   2011: ldc 148
    //   2013: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2016: checkcast 148	com/tencent/mm/plugin/k
    //   2019: invokeinterface 157 1 0
    //   2024: ifeq +220 -> 2244
    //   2027: aload 17
    //   2029: checkcast 122	java/util/List
    //   2032: invokestatic 507	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
    //   2035: checkcast 102	com/tencent/mm/protocal/protobuf/bdm
    //   2038: astore 19
    //   2040: aload 19
    //   2042: ifnull +202 -> 2244
    //   2045: new 509	com/tencent/mm/protocal/protobuf/bdp
    //   2048: dup
    //   2049: invokespecial 510	com/tencent/mm/protocal/protobuf/bdp:<init>	()V
    //   2052: astore 18
    //   2054: aload 18
    //   2056: checkcast 131	com/tencent/mm/bx/a
    //   2059: astore 12
    //   2061: aload 19
    //   2063: getfield 135	com/tencent/mm/protocal/protobuf/bdm:ZNY	Lcom/tencent/mm/bx/b;
    //   2066: astore 11
    //   2068: aload 11
    //   2070: ifnonnull +422 -> 2492
    //   2073: aconst_null
    //   2074: astore 11
    //   2076: aload 12
    //   2078: aload 11
    //   2080: invokevirtual 139	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   2083: pop
    //   2084: ldc 183
    //   2086: new 141	java/lang/StringBuilder
    //   2089: dup
    //   2090: ldc_w 512
    //   2093: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2096: aload 18
    //   2098: getfield 515	com/tencent/mm/protocal/protobuf/bdp:ZOj	Ljava/lang/String;
    //   2101: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2104: ldc 193
    //   2106: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: aload 19
    //   2111: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   2114: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2117: ldc_w 517
    //   2120: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: aload 16
    //   2125: getfield 521	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   2128: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2131: ldc_w 523
    //   2134: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: aload 18
    //   2139: getfield 526	com/tencent/mm/protocal/protobuf/bdp:ZOm	Ljava/lang/String;
    //   2142: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2145: ldc_w 528
    //   2148: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: aload 18
    //   2153: getfield 529	com/tencent/mm/protocal/protobuf/bdp:seq	J
    //   2156: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2159: ldc_w 531
    //   2162: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: aload 16
    //   2167: getfield 534	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efr	J
    //   2170: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2173: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2176: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2179: aload 19
    //   2181: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   2184: astore 20
    //   2186: aload 20
    //   2188: ifnull +56 -> 2244
    //   2191: aload 16
    //   2193: getfield 225	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfG	Ljava/util/HashMap;
    //   2196: aload 20
    //   2198: invokevirtual 231	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2201: checkcast 233	java/lang/Integer
    //   2204: astore 11
    //   2206: aload 11
    //   2208: ifnonnull +317 -> 2525
    //   2211: aload 16
    //   2213: ldc 60
    //   2215: invokevirtual 535	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   2218: astore 11
    //   2220: aload 11
    //   2222: invokestatic 539	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   2225: aload 11
    //   2227: checkcast 60	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j
    //   2230: invokevirtual 542	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:ezb	()Z
    //   2233: ifeq +312 -> 2545
    //   2236: ldc 183
    //   2238: ldc_w 544
    //   2241: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2244: ldc 183
    //   2246: new 141	java/lang/StringBuilder
    //   2249: dup
    //   2250: ldc_w 546
    //   2253: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2256: aload 17
    //   2258: invokevirtual 492	java/util/LinkedList:size	()I
    //   2261: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2264: ldc_w 494
    //   2267: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: ldc 148
    //   2272: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2275: checkcast 148	com/tencent/mm/plugin/k
    //   2278: invokeinterface 157 1 0
    //   2283: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2286: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2289: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2292: aload 16
    //   2294: aload_1
    //   2295: invokevirtual 549	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aF	(Ljava/util/LinkedList;)V
    //   2298: aload 16
    //   2300: aload_1
    //   2301: invokevirtual 552	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aG	(Ljava/util/LinkedList;)V
    //   2304: aload 16
    //   2306: aload_1
    //   2307: invokevirtual 555	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aH	(Ljava/util/LinkedList;)V
    //   2310: aload 16
    //   2312: aload_1
    //   2313: invokevirtual 558	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aI	(Ljava/util/LinkedList;)V
    //   2316: aload 16
    //   2318: aload_1
    //   2319: invokevirtual 561	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aJ	(Ljava/util/LinkedList;)V
    //   2322: ldc 148
    //   2324: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2327: checkcast 148	com/tencent/mm/plugin/k
    //   2330: invokeinterface 157 1 0
    //   2335: ifeq +1442 -> 3777
    //   2338: aload 16
    //   2340: aload_1
    //   2341: invokevirtual 564	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:aL	(Ljava/util/LinkedList;)Ljava/util/LinkedList;
    //   2344: invokevirtual 567	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   2347: checkcast 102	com/tencent/mm/protocal/protobuf/bdm
    //   2350: astore 12
    //   2352: aload 12
    //   2354: ifnull +1423 -> 3777
    //   2357: new 569	com/tencent/mm/protocal/protobuf/bem
    //   2360: dup
    //   2361: invokespecial 570	com/tencent/mm/protocal/protobuf/bem:<init>	()V
    //   2364: checkcast 131	com/tencent/mm/bx/a
    //   2367: astore 11
    //   2369: aload 12
    //   2371: getfield 135	com/tencent/mm/protocal/protobuf/bdm:ZNY	Lcom/tencent/mm/bx/b;
    //   2374: astore_1
    //   2375: aload_1
    //   2376: ifnonnull +1242 -> 3618
    //   2379: aconst_null
    //   2380: astore_1
    //   2381: aload 11
    //   2383: aload_1
    //   2384: invokevirtual 139	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   2387: pop
    //   2388: aload 11
    //   2390: astore_1
    //   2391: aload_1
    //   2392: checkcast 569	com/tencent/mm/protocal/protobuf/bem
    //   2395: astore 11
    //   2397: new 141	java/lang/StringBuilder
    //   2400: dup
    //   2401: ldc_w 572
    //   2404: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2407: aload 12
    //   2409: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   2412: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2415: ldc_w 574
    //   2418: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2421: astore 12
    //   2423: aload 11
    //   2425: ifnonnull +1224 -> 3649
    //   2428: aconst_null
    //   2429: astore_1
    //   2430: aload 12
    //   2432: aload_1
    //   2433: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2436: ldc_w 576
    //   2439: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: astore 12
    //   2444: aload 11
    //   2446: ifnonnull +1240 -> 3686
    //   2449: aconst_null
    //   2450: astore_1
    //   2451: ldc 183
    //   2453: aload 12
    //   2455: aload_1
    //   2456: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2459: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2462: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2465: aload 11
    //   2467: ifnull +1310 -> 3777
    //   2470: aload 11
    //   2472: getfield 579	com/tencent/mm/protocal/protobuf/bem:ZOU	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2475: ifnonnull +1248 -> 3723
    //   2478: ldc 183
    //   2480: ldc_w 581
    //   2483: invokestatic 584	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2486: ldc 53
    //   2488: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2491: return
    //   2492: aload 11
    //   2494: invokevirtual 300	com/tencent/mm/bx/b:toByteArray	()[B
    //   2497: astore 11
    //   2499: goto -423 -> 2076
    //   2502: astore 11
    //   2504: ldc_w 302
    //   2507: ldc_w 303
    //   2510: iconst_1
    //   2511: anewarray 305	java/lang/Object
    //   2514: dup
    //   2515: iconst_0
    //   2516: aload 11
    //   2518: aastore
    //   2519: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2522: goto -438 -> 2084
    //   2525: aload 11
    //   2527: invokevirtual 332	java/lang/Integer:intValue	()I
    //   2530: iconst_3
    //   2531: if_icmpne -320 -> 2211
    //   2534: ldc 183
    //   2536: ldc_w 586
    //   2539: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2542: goto -298 -> 2244
    //   2545: aload 16
    //   2547: getfield 225	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfG	Ljava/util/HashMap;
    //   2550: checkcast 235	java/util/Map
    //   2553: aload 20
    //   2555: iconst_2
    //   2556: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2559: invokeinterface 243 3 0
    //   2564: pop
    //   2565: aload 16
    //   2567: getfield 521	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   2570: astore 11
    //   2572: aload 11
    //   2574: ifnonnull +719 -> 3293
    //   2577: iconst_0
    //   2578: istore 5
    //   2580: aload 18
    //   2582: getfield 589	com/tencent/mm/protocal/protobuf/bdp:ZOr	Lcom/tencent/mm/bx/b;
    //   2585: astore 11
    //   2587: aload 11
    //   2589: ifnonnull +714 -> 3303
    //   2592: iconst_0
    //   2593: istore_2
    //   2594: iload_2
    //   2595: ifle +718 -> 3313
    //   2598: iconst_1
    //   2599: istore 6
    //   2601: iload 6
    //   2603: ifeq +716 -> 3319
    //   2606: aload 18
    //   2608: getfield 589	com/tencent/mm/protocal/protobuf/bdp:ZOr	Lcom/tencent/mm/bx/b;
    //   2611: astore 15
    //   2613: aload 16
    //   2615: iload 6
    //   2617: putfield 361	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:EfM	Z
    //   2620: aload 18
    //   2622: getfield 592	com/tencent/mm/protocal/protobuf/bdp:ZOo	Ljava/lang/String;
    //   2625: astore 21
    //   2627: aload 19
    //   2629: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2632: astore 11
    //   2634: aload 11
    //   2636: ifnonnull +693 -> 3329
    //   2639: aconst_null
    //   2640: astore 11
    //   2642: aload 19
    //   2644: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2647: astore 12
    //   2649: aload 12
    //   2651: ifnonnull +706 -> 3357
    //   2654: aconst_null
    //   2655: astore 12
    //   2657: aload 19
    //   2659: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2662: astore 13
    //   2664: aload 13
    //   2666: ifnonnull +719 -> 3385
    //   2669: aconst_null
    //   2670: astore 13
    //   2672: aload 19
    //   2674: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   2677: astore 22
    //   2679: aload 18
    //   2681: getfield 595	com/tencent/mm/protocal/protobuf/bdp:ZOp	I
    //   2684: istore_2
    //   2685: aload 19
    //   2687: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2690: astore 14
    //   2692: aload 14
    //   2694: ifnonnull +719 -> 3413
    //   2697: aconst_null
    //   2698: astore 14
    //   2700: aload 16
    //   2702: new 254	com/tencent/mm/plugin/finder/live/viewmodel/data/h
    //   2705: dup
    //   2706: aload 21
    //   2708: aload 11
    //   2710: aload 12
    //   2712: aload 13
    //   2714: iconst_2
    //   2715: aload 22
    //   2717: aload 15
    //   2719: iconst_1
    //   2720: iload_2
    //   2721: aload 14
    //   2723: aconst_null
    //   2724: iconst_0
    //   2725: iconst_0
    //   2726: iconst_0
    //   2727: aload 18
    //   2729: getfield 526	com/tencent/mm/protocal/protobuf/bdp:ZOm	Ljava/lang/String;
    //   2732: lconst_0
    //   2733: aload 19
    //   2735: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2738: iconst_0
    //   2739: ldc_w 596
    //   2742: invokespecial 273	com/tencent/mm/plugin/finder/live/viewmodel/data/h:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/bx/b;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;IIZLjava/lang/String;JLcom/tencent/mm/protocal/protobuf/bgh;ZI)V
    //   2745: putfield 521	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efv	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/h;
    //   2748: ldc 183
    //   2750: ldc_w 598
    //   2753: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2756: ldc 148
    //   2758: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2761: checkcast 148	com/tencent/mm/plugin/k
    //   2764: aload 16
    //   2766: getfield 74	com/tencent/mm/plugin/finder/live/viewmodel/data/business/c:CBK	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   2769: iconst_2
    //   2770: invokeinterface 407 3 0
    //   2775: aload 16
    //   2777: aload 18
    //   2779: getfield 529	com/tencent/mm/protocal/protobuf/bdp:seq	J
    //   2782: putfield 534	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efr	J
    //   2785: new 141	java/lang/StringBuilder
    //   2788: dup
    //   2789: ldc_w 600
    //   2792: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2795: ldc 148
    //   2797: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2800: checkcast 148	com/tencent/mm/plugin/k
    //   2803: invokeinterface 157 1 0
    //   2808: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2811: ldc 163
    //   2813: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: astore 12
    //   2818: aload 19
    //   2820: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2823: astore 11
    //   2825: aload 11
    //   2827: ifnonnull +614 -> 3441
    //   2830: aconst_null
    //   2831: astore 11
    //   2833: aload 12
    //   2835: aload 11
    //   2837: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2840: ldc 175
    //   2842: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2845: astore 12
    //   2847: aload 19
    //   2849: getfield 170	com/tencent/mm/protocal/protobuf/bdm:ZOb	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   2852: astore 11
    //   2854: aload 11
    //   2856: ifnonnull +613 -> 3469
    //   2859: aconst_null
    //   2860: astore 11
    //   2862: ldc 183
    //   2864: aload 12
    //   2866: aload 11
    //   2868: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2871: ldc 177
    //   2873: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: aload 18
    //   2878: getfield 592	com/tencent/mm/protocal/protobuf/bdp:ZOo	Ljava/lang/String;
    //   2881: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2884: ldc_w 602
    //   2887: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2890: aload 18
    //   2892: getfield 595	com/tencent/mm/protocal/protobuf/bdp:ZOp	I
    //   2895: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2898: ldc 193
    //   2900: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: aload 19
    //   2905: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   2908: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2911: ldc_w 604
    //   2914: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2917: iload 5
    //   2919: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2922: ldc_w 606
    //   2925: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: iload 6
    //   2930: invokevirtual 161	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2933: bipush 93
    //   2935: invokevirtual 209	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2938: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2941: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2944: ldc 148
    //   2946: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2949: astore 11
    //   2951: aload 11
    //   2953: ldc_w 440
    //   2956: invokestatic 252	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2959: aload 11
    //   2961: checkcast 148	com/tencent/mm/plugin/k
    //   2964: invokeinterface 609 1 0
    //   2969: iload 6
    //   2971: ifeq +60 -> 3031
    //   2974: ldc 148
    //   2976: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2979: checkcast 148	com/tencent/mm/plugin/k
    //   2982: astore 13
    //   2984: aload 18
    //   2986: getfield 592	com/tencent/mm/protocal/protobuf/bdp:ZOo	Ljava/lang/String;
    //   2989: astore 12
    //   2991: aload 12
    //   2993: astore 11
    //   2995: aload 12
    //   2997: ifnonnull +8 -> 3005
    //   3000: ldc_w 303
    //   3003: astore 11
    //   3005: aload 13
    //   3007: aload 11
    //   3009: aload 18
    //   3011: getfield 595	com/tencent/mm/protocal/protobuf/bdp:ZOp	I
    //   3014: iconst_1
    //   3015: aload 20
    //   3017: invokeinterface 612 5 0
    //   3022: pop
    //   3023: invokestatic 618	com/tencent/mm/live/core/core/trtc/sdkadapter/b/b$a:bfv	()Lcom/tencent/mm/live/core/core/trtc/sdkadapter/b/b;
    //   3026: aload 20
    //   3028: invokevirtual 623	com/tencent/mm/live/core/core/trtc/sdkadapter/b/b:FT	(Ljava/lang/String;)V
    //   3031: aload 16
    //   3033: ldc_w 372
    //   3036: invokevirtual 535	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3039: checkcast 372	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   3042: getfield 376	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   3045: getfield 381	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   3048: lstore 7
    //   3050: aload 19
    //   3052: getfield 197	com/tencent/mm/protocal/protobuf/bdm:session_id	Ljava/lang/String;
    //   3055: astore 12
    //   3057: aload 18
    //   3059: getfield 592	com/tencent/mm/protocal/protobuf/bdp:ZOo	Ljava/lang/String;
    //   3062: astore 13
    //   3064: aload 16
    //   3066: ldc_w 355
    //   3069: invokevirtual 535	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3072: astore 11
    //   3074: aload 11
    //   3076: invokestatic 539	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   3079: aload 11
    //   3081: checkcast 355	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   3084: invokevirtual 626	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyH	()I
    //   3087: istore_2
    //   3088: aload 18
    //   3090: getfield 595	com/tencent/mm/protocal/protobuf/bdp:ZOp	I
    //   3093: istore_3
    //   3094: aload 18
    //   3096: getfield 529	com/tencent/mm/protocal/protobuf/bdp:seq	J
    //   3099: lstore 9
    //   3101: aload 15
    //   3103: ifnonnull +394 -> 3497
    //   3106: aconst_null
    //   3107: astore 11
    //   3109: new 383	com/tencent/mm/live/model/a
    //   3112: dup
    //   3113: lload 7
    //   3115: aload 12
    //   3117: aload 13
    //   3119: iload_2
    //   3120: iconst_0
    //   3121: iload_3
    //   3122: ldc_w 303
    //   3125: ldc_w 303
    //   3128: lconst_0
    //   3129: aconst_null
    //   3130: iconst_2
    //   3131: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3134: lload 9
    //   3136: aload 11
    //   3138: iconst_1
    //   3139: iload 5
    //   3141: invokespecial 629	com/tencent/mm/live/model/a:<init>	(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JLjava/lang/String;ZZ)V
    //   3144: astore 14
    //   3146: getstatic 413	com/tencent/mm/live/model/p:mZf	Lcom/tencent/mm/live/model/p;
    //   3149: astore 11
    //   3151: invokestatic 417	com/tencent/mm/live/model/p:bhS	()Lcom/tencent/mm/live/model/g;
    //   3154: astore 11
    //   3156: aload 11
    //   3158: ifnull +12 -> 3170
    //   3161: aload 11
    //   3163: aload 14
    //   3165: invokeinterface 422 2 0
    //   3170: iload 6
    //   3172: ifeq +341 -> 3513
    //   3175: ldc 148
    //   3177: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3180: checkcast 148	com/tencent/mm/plugin/k
    //   3183: invokeinterface 426 1 0
    //   3188: astore 11
    //   3190: aload 11
    //   3192: instanceof 631
    //   3195: ifeq +312 -> 3507
    //   3198: aload 11
    //   3200: checkcast 631	com/tencent/mm/live/core/core/a/b
    //   3203: astore 11
    //   3205: aload 11
    //   3207: ifnull -963 -> 2244
    //   3210: aload 16
    //   3212: ldc_w 355
    //   3215: invokevirtual 535	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   3218: checkcast 355	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e
    //   3221: invokevirtual 634	com/tencent/mm/plugin/finder/live/viewmodel/data/business/e:eyG	()I
    //   3224: istore_2
    //   3225: aload 14
    //   3227: getfield 637	com/tencent/mm/live/model/a:mXz	I
    //   3230: istore_3
    //   3231: aload 14
    //   3233: getfield 640	com/tencent/mm/live/model/a:mXD	Ljava/lang/String;
    //   3236: astore 13
    //   3238: aload 13
    //   3240: astore 12
    //   3242: aload 13
    //   3244: ifnonnull +8 -> 3252
    //   3247: ldc_w 303
    //   3250: astore 12
    //   3252: aload 14
    //   3254: getfield 389	com/tencent/mm/live/model/a:userId	Ljava/lang/String;
    //   3257: astore 14
    //   3259: aload 14
    //   3261: astore 13
    //   3263: aload 14
    //   3265: ifnonnull +8 -> 3273
    //   3268: ldc_w 303
    //   3271: astore 13
    //   3273: aload 11
    //   3275: iload_2
    //   3276: invokestatic 645	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3279: iload_3
    //   3280: invokestatic 645	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3283: aload 12
    //   3285: aload 13
    //   3287: invokevirtual 649	com/tencent/mm/live/core/core/a/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3290: goto -1046 -> 2244
    //   3293: aload 11
    //   3295: getfield 652	com/tencent/mm/plugin/finder/live/viewmodel/data/h:mXF	Z
    //   3298: istore 5
    //   3300: goto -720 -> 2580
    //   3303: aload 11
    //   3305: getfield 474	com/tencent/mm/bx/b:Op	[B
    //   3308: arraylength
    //   3309: istore_2
    //   3310: goto -716 -> 2594
    //   3313: iconst_0
    //   3314: istore 6
    //   3316: goto -715 -> 2601
    //   3319: aload 18
    //   3321: getfield 655	com/tencent/mm/protocal/protobuf/bdp:ZOq	Lcom/tencent/mm/bx/b;
    //   3324: astore 15
    //   3326: goto -713 -> 2613
    //   3329: aload 11
    //   3331: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3334: astore 11
    //   3336: aload 11
    //   3338: ifnonnull +9 -> 3347
    //   3341: aconst_null
    //   3342: astore 11
    //   3344: goto -702 -> 2642
    //   3347: aload 11
    //   3349: getfield 343	com/tencent/mm/protocal/protobuf/FinderContact:headUrl	Ljava/lang/String;
    //   3352: astore 11
    //   3354: goto -712 -> 2642
    //   3357: aload 12
    //   3359: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3362: astore 12
    //   3364: aload 12
    //   3366: ifnonnull +9 -> 3375
    //   3369: aconst_null
    //   3370: astore 12
    //   3372: goto -715 -> 2657
    //   3375: aload 12
    //   3377: getfield 320	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   3380: astore 12
    //   3382: goto -725 -> 2657
    //   3385: aload 13
    //   3387: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3390: astore 13
    //   3392: aload 13
    //   3394: ifnonnull +9 -> 3403
    //   3397: aconst_null
    //   3398: astore 13
    //   3400: goto -728 -> 2672
    //   3403: aload 13
    //   3405: getfield 323	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   3408: astore 13
    //   3410: goto -738 -> 2672
    //   3413: aload 14
    //   3415: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3418: astore 14
    //   3420: aload 14
    //   3422: ifnonnull +9 -> 3431
    //   3425: aconst_null
    //   3426: astore 14
    //   3428: goto -728 -> 2700
    //   3431: aload 14
    //   3433: getfield 659	com/tencent/mm/protocal/protobuf/FinderContact:authInfo	Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;
    //   3436: astore 14
    //   3438: goto -738 -> 2700
    //   3441: aload 11
    //   3443: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3446: astore 11
    //   3448: aload 11
    //   3450: ifnonnull +9 -> 3459
    //   3453: aconst_null
    //   3454: astore 11
    //   3456: goto -623 -> 2833
    //   3459: aload 11
    //   3461: getfield 320	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   3464: astore 11
    //   3466: goto -633 -> 2833
    //   3469: aload 11
    //   3471: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3474: astore 11
    //   3476: aload 11
    //   3478: ifnonnull +9 -> 3487
    //   3481: aconst_null
    //   3482: astore 11
    //   3484: goto -622 -> 2862
    //   3487: aload 11
    //   3489: getfield 323	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   3492: astore 11
    //   3494: goto -632 -> 2862
    //   3497: aload 15
    //   3499: invokevirtual 461	com/tencent/mm/bx/b:ZV	()Ljava/lang/String;
    //   3502: astore 11
    //   3504: goto -395 -> 3109
    //   3507: aconst_null
    //   3508: astore 11
    //   3510: goto -305 -> 3205
    //   3513: ldc 148
    //   3515: invokestatic 154	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3518: checkcast 148	com/tencent/mm/plugin/k
    //   3521: invokeinterface 426 1 0
    //   3526: astore 11
    //   3528: aload 11
    //   3530: instanceof 631
    //   3533: ifeq +79 -> 3612
    //   3536: aload 11
    //   3538: checkcast 631	com/tencent/mm/live/core/core/a/b
    //   3541: astore 11
    //   3543: aload 11
    //   3545: ifnull -1301 -> 2244
    //   3548: aload 14
    //   3550: getfield 637	com/tencent/mm/live/model/a:mXz	I
    //   3553: istore_2
    //   3554: aload 14
    //   3556: getfield 389	com/tencent/mm/live/model/a:userId	Ljava/lang/String;
    //   3559: astore 13
    //   3561: aload 13
    //   3563: astore 12
    //   3565: aload 13
    //   3567: ifnonnull +8 -> 3575
    //   3570: ldc_w 303
    //   3573: astore 12
    //   3575: aload 14
    //   3577: getfield 640	com/tencent/mm/live/model/a:mXD	Ljava/lang/String;
    //   3580: astore 14
    //   3582: aload 14
    //   3584: astore 13
    //   3586: aload 14
    //   3588: ifnonnull +8 -> 3596
    //   3591: ldc_w 303
    //   3594: astore 13
    //   3596: aload 11
    //   3598: iload_2
    //   3599: invokestatic 645	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3602: aload 12
    //   3604: aload 13
    //   3606: invokevirtual 663	com/tencent/mm/live/core/core/a/b:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3609: goto -1365 -> 2244
    //   3612: aconst_null
    //   3613: astore 11
    //   3615: goto -72 -> 3543
    //   3618: aload_1
    //   3619: invokevirtual 300	com/tencent/mm/bx/b:toByteArray	()[B
    //   3622: astore_1
    //   3623: goto -1242 -> 2381
    //   3626: astore_1
    //   3627: ldc_w 302
    //   3630: ldc_w 303
    //   3633: iconst_1
    //   3634: anewarray 305	java/lang/Object
    //   3637: dup
    //   3638: iconst_0
    //   3639: aload_1
    //   3640: aastore
    //   3641: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3644: aconst_null
    //   3645: astore_1
    //   3646: goto -1255 -> 2391
    //   3649: aload 11
    //   3651: getfield 579	com/tencent/mm/protocal/protobuf/bem:ZOU	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   3654: astore_1
    //   3655: aload_1
    //   3656: ifnonnull +8 -> 3664
    //   3659: aconst_null
    //   3660: astore_1
    //   3661: goto -1231 -> 2430
    //   3664: aload_1
    //   3665: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3668: astore_1
    //   3669: aload_1
    //   3670: ifnonnull +8 -> 3678
    //   3673: aconst_null
    //   3674: astore_1
    //   3675: goto -1245 -> 2430
    //   3678: aload_1
    //   3679: getfield 320	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   3682: astore_1
    //   3683: goto -1253 -> 2430
    //   3686: aload 11
    //   3688: getfield 579	com/tencent/mm/protocal/protobuf/bem:ZOU	Lcom/tencent/mm/protocal/protobuf/bgh;
    //   3691: astore_1
    //   3692: aload_1
    //   3693: ifnonnull +8 -> 3701
    //   3696: aconst_null
    //   3697: astore_1
    //   3698: goto -1247 -> 2451
    //   3701: aload_1
    //   3702: getfield 315	com/tencent/mm/protocal/protobuf/bgh:contact	Lcom/tencent/mm/protocal/protobuf/FinderContact;
    //   3705: astore_1
    //   3706: aload_1
    //   3707: ifnonnull +8 -> 3715
    //   3710: aconst_null
    //   3711: astore_1
    //   3712: goto -1261 -> 2451
    //   3715: aload_1
    //   3716: getfield 323	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   3719: astore_1
    //   3720: goto -1269 -> 2451
    //   3723: aload 16
    //   3725: getfield 370	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   3728: iconst_5
    //   3729: if_icmpeq +28 -> 3757
    //   3732: ldc 183
    //   3734: ldc_w 665
    //   3737: aload 16
    //   3739: getfield 370	com/tencent/mm/plugin/finder/live/viewmodel/data/business/j:Efy	I
    //   3742: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3745: invokestatic 669	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   3748: invokestatic 584	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   3751: ldc 53
    //   3753: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3756: return
    //   3757: getstatic 413	com/tencent/mm/live/model/p:mZf	Lcom/tencent/mm/live/model/p;
    //   3760: astore_1
    //   3761: invokestatic 417	com/tencent/mm/live/model/p:bhS	()Lcom/tencent/mm/live/model/g;
    //   3764: astore_1
    //   3765: aload_1
    //   3766: ifnull +11 -> 3777
    //   3769: aload_1
    //   3770: aload 11
    //   3772: invokeinterface 673 2 0
    //   3777: ldc 53
    //   3779: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3782: return
    //   3783: goto -2926 -> 857
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3786	0	this	n
    //   0	3786	1	paramLinkedList	java.util.LinkedList<com.tencent.mm.protocal.protobuf.bdm>
    //   687	2912	2	i	int
    //   666	2614	3	j	int
    //   1333	405	4	k	int
    //   564	2735	5	bool1	boolean
    //   2599	716	6	bool2	boolean
    //   1378	1736	7	l1	long
    //   1268	1867	9	l2	long
    //   63	803	11	localObject1	java.lang.Object
    //   870	24	11	localException1	java.lang.Exception
    //   898	1600	11	localObject2	java.lang.Object
    //   2502	24	11	localException2	java.lang.Exception
    //   2570	1201	11	localObject3	java.lang.Object
    //   91	3514	13	localObject5	java.lang.Object
    //   36	3462	15	localObject7	java.lang.Object
    //   23	3715	16	localj	com.tencent.mm.plugin.finder.live.viewmodel.data.business.j
    //   45	2212	17	localLinkedList	java.util.LinkedList
    //   153	3167	18	localObject8	java.lang.Object
    //   184	2867	19	localObject9	java.lang.Object
    //   385	2642	20	str	java.lang.String
    //   175	2532	21	localObject10	java.lang.Object
    //   495	2221	22	localObject11	java.lang.Object
    //   521	189	23	localObject12	java.lang.Object
    //   679	432	24	localbgh	com.tencent.mm.protocal.protobuf.bgh
    // Exception table:
    //   from	to	target	type
    //   208	216	870	java/lang/Exception
    //   488	497	1005	finally
    //   497	530	1005	finally
    //   547	554	1005	finally
    //   554	566	1005	finally
    //   989	996	1005	finally
    //   778	787	1667	finally
    //   787	850	1667	finally
    //   1129	1134	1667	finally
    //   2076	2084	2502	java/lang/Exception
    //   2381	2388	3626	java/lang/Exception
  }
  
  public final int[] ejj()
  {
    return new int[] { 20004, 20005, 20016, 20017, 20018, 20026, 20028, 20029, 20039 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.n
 * JD-Core Version:    0.7.0.1
 */