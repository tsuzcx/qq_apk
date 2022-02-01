package com.tencent.mm.chatroom.c;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.li;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Future;

public class b
{
  private String iiw;
  private Future lya;
  public ConcurrentLinkedDeque<String> lyb;
  public ConcurrentHashMap<String, String> lyc;
  private Runnable lyd;
  private MMHandler mHandler;
  
  public b()
  {
    AppMethodBeat.i(241460);
    this.lya = null;
    this.lyb = new ConcurrentLinkedDeque();
    this.lyc = new ConcurrentHashMap();
    this.iiw = "";
    this.mHandler = new MMHandler("OpenImMigrateService")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(241459);
        Log.i("MicroMsg.openIm.OpenImMigrateService", "handleMessage running, %s", new Object[] { Integer.valueOf(b.a(b.this).size()) });
        if (!b.a(b.this).isEmpty()) {
          b.a(b.this, h.ahAA.g(b.b(b.this), "migrate_tag"));
        }
        AppMethodBeat.o(241459);
      }
    };
    this.lyd = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   8: lstore 8
        //   10: iconst_0
        //   11: istore_3
        //   12: iconst_0
        //   13: istore 4
        //   15: iconst_0
        //   16: istore_1
        //   17: iconst_0
        //   18: istore_2
        //   19: ldc 36
        //   21: astore 16
        //   23: invokestatic 42	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
        //   26: invokevirtual 48	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
        //   29: getstatic 54	com/tencent/mm/storage/at$a:adgp	Lcom/tencent/mm/storage/at$a;
        //   32: ldc 36
        //   34: invokevirtual 60	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
        //   37: checkcast 62	java/lang/String
        //   40: astore 12
        //   42: aload 12
        //   44: invokestatic 68	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   47: ifeq +223 -> 270
        //   50: aload_0
        //   51: getfield 14	com/tencent/mm/chatroom/c/b$2:lye	Lcom/tencent/mm/chatroom/c/b;
        //   54: invokestatic 72	com/tencent/mm/chatroom/c/b:a	(Lcom/tencent/mm/chatroom/c/b;)Ljava/util/concurrent/ConcurrentLinkedDeque;
        //   57: invokevirtual 78	java/util/concurrent/ConcurrentLinkedDeque:removeFirst	()Ljava/lang/Object;
        //   60: checkcast 62	java/lang/String
        //   63: astore 12
        //   65: aload 12
        //   67: astore 13
        //   69: aload 12
        //   71: astore 14
        //   73: aload_0
        //   74: getfield 14	com/tencent/mm/chatroom/c/b$2:lye	Lcom/tencent/mm/chatroom/c/b;
        //   77: invokestatic 82	com/tencent/mm/chatroom/c/b:c	(Lcom/tencent/mm/chatroom/c/b;)Ljava/util/concurrent/ConcurrentHashMap;
        //   80: aload 12
        //   82: invokevirtual 88	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
        //   85: checkcast 62	java/lang/String
        //   88: astore 15
        //   90: invokestatic 42	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
        //   93: invokevirtual 48	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
        //   96: getstatic 54	com/tencent/mm/storage/at$a:adgp	Lcom/tencent/mm/storage/at$a;
        //   99: aload 12
        //   101: invokevirtual 92	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
        //   104: invokestatic 42	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
        //   107: invokevirtual 48	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
        //   110: getstatic 95	com/tencent/mm/storage/at$a:adgo	Lcom/tencent/mm/storage/at$a;
        //   113: aload 15
        //   115: invokevirtual 92	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
        //   118: aload 15
        //   120: astore 13
        //   122: iload_2
        //   123: istore_3
        //   124: aload 13
        //   126: astore 15
        //   128: aload 12
        //   130: astore 16
        //   132: iload 4
        //   134: istore_1
        //   135: aload 12
        //   137: invokestatic 68	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   140: ifne +24 -> 164
        //   143: iload_2
        //   144: istore_3
        //   145: aload 13
        //   147: astore 15
        //   149: aload 12
        //   151: astore 16
        //   153: iload 4
        //   155: istore_1
        //   156: aload 13
        //   158: invokestatic 68	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   161: ifeq +143 -> 304
        //   164: iload_2
        //   165: istore_3
        //   166: aload 13
        //   168: astore 15
        //   170: aload 12
        //   172: astore 16
        //   174: iload 4
        //   176: istore_1
        //   177: ldc 97
        //   179: ldc 99
        //   181: iconst_2
        //   182: anewarray 4	java/lang/Object
        //   185: dup
        //   186: iconst_0
        //   187: aload 12
        //   189: ldc 36
        //   191: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   194: aastore
        //   195: dup
        //   196: iconst_1
        //   197: aload 13
        //   199: ldc 36
        //   201: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   204: aastore
        //   205: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   208: ldc 97
        //   210: ldc 111
        //   212: iconst_5
        //   213: anewarray 4	java/lang/Object
        //   216: dup
        //   217: iconst_0
        //   218: aload 13
        //   220: ldc 36
        //   222: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   225: aastore
        //   226: dup
        //   227: iconst_1
        //   228: aload 12
        //   230: ldc 36
        //   232: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   235: aastore
        //   236: dup
        //   237: iconst_2
        //   238: iconst_0
        //   239: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   242: aastore
        //   243: dup
        //   244: iconst_3
        //   245: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   248: lload 8
        //   250: lsub
        //   251: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   254: aastore
        //   255: dup
        //   256: iconst_4
        //   257: getstatic 128	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
        //   260: aastore
        //   261: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   264: ldc 22
        //   266: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   269: return
        //   270: aload 12
        //   272: astore 13
        //   274: aload 12
        //   276: astore 14
        //   278: invokestatic 42	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
        //   281: invokevirtual 48	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
        //   284: getstatic 95	com/tencent/mm/storage/at$a:adgo	Lcom/tencent/mm/storage/at$a;
        //   287: ldc 36
        //   289: invokevirtual 60	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
        //   292: checkcast 62	java/lang/String
        //   295: astore 15
        //   297: aload 15
        //   299: astore 13
        //   301: goto -179 -> 122
        //   304: iload_2
        //   305: istore_3
        //   306: aload 13
        //   308: astore 15
        //   310: aload 12
        //   312: astore 16
        //   314: iload 4
        //   316: istore_1
        //   317: ldc 135
        //   319: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   322: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   325: invokeinterface 143 1 0
        //   330: aload 13
        //   332: invokeinterface 149 2 0
        //   337: iload_2
        //   338: istore_3
        //   339: aload 13
        //   341: astore 15
        //   343: aload 12
        //   345: astore 16
        //   347: iload 4
        //   349: istore_1
        //   350: ldc 135
        //   352: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   355: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   358: invokeinterface 153 1 0
        //   363: aload 13
        //   365: bipush 50
        //   367: invokeinterface 159 3 0
        //   372: astore 14
        //   374: iload_2
        //   375: istore_3
        //   376: aload 13
        //   378: astore 15
        //   380: aload 12
        //   382: astore 16
        //   384: iload 4
        //   386: istore_1
        //   387: aload 14
        //   389: invokeinterface 165 1 0
        //   394: iconst_0
        //   395: iadd
        //   396: istore_2
        //   397: iload_2
        //   398: istore_3
        //   399: aload 13
        //   401: astore 15
        //   403: aload 12
        //   405: astore 16
        //   407: iload_2
        //   408: istore_1
        //   409: ldc 97
        //   411: ldc 167
        //   413: iconst_1
        //   414: anewarray 4	java/lang/Object
        //   417: dup
        //   418: iconst_0
        //   419: aload 14
        //   421: invokeinterface 165 1 0
        //   426: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   429: aastore
        //   430: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   433: iload_2
        //   434: istore_3
        //   435: aload 13
        //   437: astore 15
        //   439: aload 12
        //   441: astore 16
        //   443: iload_2
        //   444: istore_1
        //   445: aload 14
        //   447: invokeinterface 174 1 0
        //   452: astore 17
        //   454: iload_2
        //   455: istore_3
        //   456: aload 13
        //   458: astore 15
        //   460: aload 12
        //   462: astore 16
        //   464: iload_2
        //   465: istore_1
        //   466: aload 17
        //   468: invokeinterface 180 1 0
        //   473: ifeq +224 -> 697
        //   476: iload_2
        //   477: istore_3
        //   478: aload 13
        //   480: astore 15
        //   482: aload 12
        //   484: astore 16
        //   486: iload_2
        //   487: istore_1
        //   488: aload 17
        //   490: invokeinterface 183 1 0
        //   495: checkcast 185	com/tencent/mm/storage/cc
        //   498: astore 18
        //   500: iload_2
        //   501: istore_3
        //   502: aload 13
        //   504: astore 15
        //   506: aload 12
        //   508: astore 16
        //   510: iload_2
        //   511: istore_1
        //   512: aload 18
        //   514: aload 12
        //   516: invokevirtual 188	com/tencent/mm/storage/cc:BS	(Ljava/lang/String;)V
        //   519: iload_2
        //   520: istore_3
        //   521: aload 13
        //   523: astore 15
        //   525: aload 12
        //   527: astore 16
        //   529: iload_2
        //   530: istore_1
        //   531: ldc 97
        //   533: ldc 190
        //   535: iconst_1
        //   536: anewarray 4	java/lang/Object
        //   539: dup
        //   540: iconst_0
        //   541: aload 18
        //   543: getfield 196	com/tencent/mm/autogen/b/fi:field_msgId	J
        //   546: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   549: aastore
        //   550: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   553: iload_2
        //   554: istore_3
        //   555: aload 13
        //   557: astore 15
        //   559: aload 12
        //   561: astore 16
        //   563: iload_2
        //   564: istore_1
        //   565: ldc 135
        //   567: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   570: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   573: invokeinterface 153 1 0
        //   578: aload 18
        //   580: getfield 196	com/tencent/mm/autogen/b/fi:field_msgId	J
        //   583: aload 18
        //   585: invokeinterface 199 4 0
        //   590: goto -136 -> 454
        //   593: astore 14
        //   595: aload 13
        //   597: astore 15
        //   599: aload 12
        //   601: astore 16
        //   603: iload_3
        //   604: istore_1
        //   605: ldc 97
        //   607: ldc 201
        //   609: iconst_2
        //   610: anewarray 4	java/lang/Object
        //   613: dup
        //   614: iconst_0
        //   615: aload 14
        //   617: invokevirtual 205	java/lang/Object:getClass	()Ljava/lang/Class;
        //   620: invokevirtual 211	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   623: aastore
        //   624: dup
        //   625: iconst_1
        //   626: aload 14
        //   628: invokevirtual 214	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   631: aastore
        //   632: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   635: ldc 97
        //   637: ldc 111
        //   639: iconst_5
        //   640: anewarray 4	java/lang/Object
        //   643: dup
        //   644: iconst_0
        //   645: aload 13
        //   647: ldc 36
        //   649: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   652: aastore
        //   653: dup
        //   654: iconst_1
        //   655: aload 12
        //   657: ldc 36
        //   659: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   662: aastore
        //   663: dup
        //   664: iconst_2
        //   665: iload_3
        //   666: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   669: aastore
        //   670: dup
        //   671: iconst_3
        //   672: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   675: lload 8
        //   677: lsub
        //   678: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   681: aastore
        //   682: dup
        //   683: iconst_4
        //   684: getstatic 128	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
        //   687: aastore
        //   688: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   691: ldc 22
        //   693: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   696: return
        //   697: iload_2
        //   698: istore_3
        //   699: aload 13
        //   701: astore 15
        //   703: aload 12
        //   705: astore 16
        //   707: iload_2
        //   708: istore_1
        //   709: iload_2
        //   710: istore 4
        //   712: aload 14
        //   714: invokeinterface 165 1 0
        //   719: bipush 50
        //   721: if_icmpne +380 -> 1101
        //   724: iconst_0
        //   725: istore 5
        //   727: iload_2
        //   728: istore 4
        //   730: iload 5
        //   732: ifne +369 -> 1101
        //   735: iload_2
        //   736: istore_3
        //   737: aload 13
        //   739: astore 15
        //   741: aload 12
        //   743: astore 16
        //   745: iload_2
        //   746: istore_1
        //   747: ldc 135
        //   749: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   752: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   755: invokeinterface 153 1 0
        //   760: aload 13
        //   762: sipush 500
        //   765: invokeinterface 159 3 0
        //   770: astore 17
        //   772: aload 17
        //   774: ifnull +789 -> 1563
        //   777: iload_2
        //   778: istore_3
        //   779: aload 13
        //   781: astore 15
        //   783: aload 12
        //   785: astore 16
        //   787: iload_2
        //   788: istore_1
        //   789: aload 17
        //   791: invokeinterface 165 1 0
        //   796: ifne +6 -> 802
        //   799: goto +764 -> 1563
        //   802: iload_2
        //   803: istore_3
        //   804: aload 13
        //   806: astore 15
        //   808: aload 12
        //   810: astore 16
        //   812: iload_2
        //   813: istore_1
        //   814: ldc 97
        //   816: ldc 167
        //   818: iconst_1
        //   819: anewarray 4	java/lang/Object
        //   822: dup
        //   823: iconst_0
        //   824: aload 14
        //   826: invokeinterface 165 1 0
        //   831: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   834: aastore
        //   835: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   838: iload_2
        //   839: istore_3
        //   840: aload 13
        //   842: astore 15
        //   844: aload 12
        //   846: astore 16
        //   848: iload_2
        //   849: istore_1
        //   850: aload 17
        //   852: invokeinterface 174 1 0
        //   857: astore 18
        //   859: iload_2
        //   860: istore_3
        //   861: aload 13
        //   863: astore 15
        //   865: aload 12
        //   867: astore 16
        //   869: iload_2
        //   870: istore_1
        //   871: aload 18
        //   873: invokeinterface 180 1 0
        //   878: ifeq +194 -> 1072
        //   881: iload_2
        //   882: istore_3
        //   883: aload 13
        //   885: astore 15
        //   887: aload 12
        //   889: astore 16
        //   891: iload_2
        //   892: istore_1
        //   893: aload 18
        //   895: invokeinterface 183 1 0
        //   900: checkcast 185	com/tencent/mm/storage/cc
        //   903: astore 19
        //   905: iload_2
        //   906: istore_3
        //   907: aload 13
        //   909: astore 15
        //   911: aload 12
        //   913: astore 16
        //   915: iload_2
        //   916: istore_1
        //   917: aload 19
        //   919: aload 12
        //   921: invokevirtual 188	com/tencent/mm/storage/cc:BS	(Ljava/lang/String;)V
        //   924: iload_2
        //   925: istore_3
        //   926: aload 13
        //   928: astore 15
        //   930: aload 12
        //   932: astore 16
        //   934: iload_2
        //   935: istore_1
        //   936: ldc 97
        //   938: ldc 219
        //   940: iconst_1
        //   941: anewarray 4	java/lang/Object
        //   944: dup
        //   945: iconst_0
        //   946: aload 19
        //   948: getfield 196	com/tencent/mm/autogen/b/fi:field_msgId	J
        //   951: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   954: aastore
        //   955: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   958: iload_2
        //   959: istore_3
        //   960: aload 13
        //   962: astore 15
        //   964: aload 12
        //   966: astore 16
        //   968: iload_2
        //   969: istore_1
        //   970: ldc 135
        //   972: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   975: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   978: invokeinterface 153 1 0
        //   983: aload 19
        //   985: getfield 196	com/tencent/mm/autogen/b/fi:field_msgId	J
        //   988: aload 19
        //   990: invokeinterface 199 4 0
        //   995: goto -136 -> 859
        //   998: astore 14
        //   1000: aload 16
        //   1002: astore 12
        //   1004: aload 15
        //   1006: astore 13
        //   1008: ldc 97
        //   1010: ldc 111
        //   1012: iconst_5
        //   1013: anewarray 4	java/lang/Object
        //   1016: dup
        //   1017: iconst_0
        //   1018: aload 13
        //   1020: ldc 36
        //   1022: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1025: aastore
        //   1026: dup
        //   1027: iconst_1
        //   1028: aload 12
        //   1030: ldc 36
        //   1032: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1035: aastore
        //   1036: dup
        //   1037: iconst_2
        //   1038: iload_1
        //   1039: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1042: aastore
        //   1043: dup
        //   1044: iconst_3
        //   1045: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   1048: lload 8
        //   1050: lsub
        //   1051: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   1054: aastore
        //   1055: dup
        //   1056: iconst_4
        //   1057: getstatic 128	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
        //   1060: aastore
        //   1061: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1064: ldc 22
        //   1066: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1069: aload 14
        //   1071: athrow
        //   1072: iload_2
        //   1073: istore_3
        //   1074: aload 13
        //   1076: astore 15
        //   1078: aload 12
        //   1080: astore 16
        //   1082: iload_2
        //   1083: istore_1
        //   1084: aload 17
        //   1086: invokeinterface 165 1 0
        //   1091: istore 4
        //   1093: iload_2
        //   1094: iload 4
        //   1096: iadd
        //   1097: istore_2
        //   1098: goto -371 -> 727
        //   1101: ldc 135
        //   1103: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1106: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   1109: invokeinterface 143 1 0
        //   1114: aload 12
        //   1116: invokeinterface 223 2 0
        //   1121: astore 14
        //   1123: aload 14
        //   1125: ifnonnull +432 -> 1557
        //   1128: iconst_1
        //   1129: istore 11
        //   1131: new 225	com/tencent/mm/storage/bb
        //   1134: dup
        //   1135: aload 12
        //   1137: invokespecial 227	com/tencent/mm/storage/bb:<init>	(Ljava/lang/String;)V
        //   1140: astore 15
        //   1142: ldc 135
        //   1144: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1147: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   1150: invokeinterface 231 1 0
        //   1155: aload 12
        //   1157: invokeinterface 237 2 0
        //   1162: astore 16
        //   1164: iload 11
        //   1166: istore 10
        //   1168: aload 15
        //   1170: astore 14
        //   1172: aload 16
        //   1174: ifnull +58 -> 1232
        //   1177: iload 11
        //   1179: istore 10
        //   1181: aload 15
        //   1183: astore 14
        //   1185: aload 16
        //   1187: getfield 243	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
        //   1190: invokestatic 68	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   1193: ifne +39 -> 1232
        //   1196: iload 11
        //   1198: istore 10
        //   1200: aload 15
        //   1202: astore 14
        //   1204: aload 16
        //   1206: invokevirtual 248	com/tencent/mm/storage/au:aSQ	()Z
        //   1209: ifeq +23 -> 1232
        //   1212: aload 15
        //   1214: aload 15
        //   1216: iconst_2
        //   1217: lconst_0
        //   1218: invokestatic 253	com/tencent/mm/plugin/messenger/foundation/a/a/a:a	(Lcom/tencent/mm/storage/bb;IJ)J
        //   1221: invokevirtual 257	com/tencent/mm/storage/bb:gS	(J)V
        //   1224: aload 15
        //   1226: astore 14
        //   1228: iload 11
        //   1230: istore 10
        //   1232: aload 14
        //   1234: aload 14
        //   1236: getfield 260	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
        //   1239: invokestatic 266	com/tencent/mm/model/br:JL	(Ljava/lang/String;)I
        //   1242: invokevirtual 269	com/tencent/mm/storage/bb:pF	(I)V
        //   1245: iload 10
        //   1247: ifeq +190 -> 1437
        //   1250: ldc 135
        //   1252: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1255: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   1258: invokeinterface 143 1 0
        //   1263: aload 14
        //   1265: invokeinterface 273 2 0
        //   1270: lstore 6
        //   1272: ldc 97
        //   1274: ldc_w 275
        //   1277: iconst_4
        //   1278: anewarray 4	java/lang/Object
        //   1281: dup
        //   1282: iconst_0
        //   1283: aload 12
        //   1285: aastore
        //   1286: dup
        //   1287: iconst_1
        //   1288: iload 10
        //   1290: invokestatic 278	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   1293: aastore
        //   1294: dup
        //   1295: iconst_2
        //   1296: lload 6
        //   1298: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   1301: aastore
        //   1302: dup
        //   1303: iconst_3
        //   1304: aload 14
        //   1306: getfield 282	com/tencent/mm/autogen/b/bd:field_msgCount	I
        //   1309: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1312: aastore
        //   1313: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1316: aload 12
        //   1318: invokestatic 285	com/tencent/mm/chatroom/c/b:CT	(Ljava/lang/String;)V
        //   1321: aload 13
        //   1323: invokestatic 285	com/tencent/mm/chatroom/c/b:CT	(Ljava/lang/String;)V
        //   1326: aload 12
        //   1328: aload 13
        //   1330: iconst_1
        //   1331: invokestatic 288	com/tencent/mm/chatroom/c/b:i	(Ljava/lang/String;Ljava/lang/String;I)V
        //   1334: invokestatic 42	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
        //   1337: invokevirtual 48	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
        //   1340: getstatic 54	com/tencent/mm/storage/at$a:adgp	Lcom/tencent/mm/storage/at$a;
        //   1343: ldc 36
        //   1345: invokevirtual 92	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
        //   1348: invokestatic 42	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
        //   1351: invokevirtual 48	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
        //   1354: getstatic 95	com/tencent/mm/storage/at$a:adgo	Lcom/tencent/mm/storage/at$a;
        //   1357: ldc 36
        //   1359: invokevirtual 92	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
        //   1362: ldc 97
        //   1364: ldc 111
        //   1366: iconst_5
        //   1367: anewarray 4	java/lang/Object
        //   1370: dup
        //   1371: iconst_0
        //   1372: aload 13
        //   1374: ldc 36
        //   1376: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1379: aastore
        //   1380: dup
        //   1381: iconst_1
        //   1382: aload 12
        //   1384: ldc 36
        //   1386: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1389: aastore
        //   1390: dup
        //   1391: iconst_2
        //   1392: iload 4
        //   1394: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1397: aastore
        //   1398: dup
        //   1399: iconst_3
        //   1400: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   1403: lload 8
        //   1405: lsub
        //   1406: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   1409: aastore
        //   1410: dup
        //   1411: iconst_4
        //   1412: getstatic 291	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   1415: aastore
        //   1416: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1419: aload_0
        //   1420: getfield 14	com/tencent/mm/chatroom/c/b$2:lye	Lcom/tencent/mm/chatroom/c/b;
        //   1423: invokestatic 294	com/tencent/mm/chatroom/c/b:d	(Lcom/tencent/mm/chatroom/c/b;)Lcom/tencent/mm/sdk/platformtools/MMHandler;
        //   1426: iconst_0
        //   1427: invokevirtual 300	com/tencent/mm/sdk/platformtools/MMHandler:sendEmptyMessage	(I)Z
        //   1430: pop
        //   1431: ldc 22
        //   1433: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1436: return
        //   1437: ldc 135
        //   1439: invokestatic 139	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1442: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/n
        //   1445: invokeinterface 143 1 0
        //   1450: aload 14
        //   1452: aload 12
        //   1454: invokeinterface 303 3 0
        //   1459: istore_1
        //   1460: iload_1
        //   1461: i2l
        //   1462: lstore 6
        //   1464: goto -192 -> 1272
        //   1467: astore 14
        //   1469: ldc 36
        //   1471: astore 12
        //   1473: aload 16
        //   1475: astore 13
        //   1477: goto -469 -> 1008
        //   1480: astore 14
        //   1482: aload 13
        //   1484: astore 12
        //   1486: aload 16
        //   1488: astore 13
        //   1490: goto -482 -> 1008
        //   1493: astore 14
        //   1495: aload 15
        //   1497: astore 13
        //   1499: goto -491 -> 1008
        //   1502: astore 14
        //   1504: iload 4
        //   1506: istore_1
        //   1507: goto -499 -> 1008
        //   1510: astore 14
        //   1512: ldc 36
        //   1514: astore 12
        //   1516: aload 16
        //   1518: astore 13
        //   1520: goto -925 -> 595
        //   1523: astore 13
        //   1525: aload 14
        //   1527: astore 12
        //   1529: aload 13
        //   1531: astore 14
        //   1533: aload 16
        //   1535: astore 13
        //   1537: goto -942 -> 595
        //   1540: astore 14
        //   1542: aload 15
        //   1544: astore 13
        //   1546: goto -951 -> 595
        //   1549: astore 14
        //   1551: iload 4
        //   1553: istore_3
        //   1554: goto -959 -> 595
        //   1557: iconst_0
        //   1558: istore 10
        //   1560: goto -328 -> 1232
        //   1563: iconst_1
        //   1564: istore 5
        //   1566: goto -839 -> 727
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1569	0	this	2
        //   16	1491	1	i	int
        //   18	1080	2	j	int
        //   11	1543	3	k	int
        //   13	1539	4	m	int
        //   725	840	5	n	int
        //   1270	193	6	l1	long
        //   8	1396	8	l2	long
        //   1166	393	10	bool1	boolean
        //   1129	100	11	bool2	boolean
        //   40	1488	12	localObject1	Object
        //   67	1452	13	localObject2	Object
        //   1523	7	13	localException1	java.lang.Exception
        //   1535	10	13	localObject3	Object
        //   71	375	14	localObject4	Object
        //   593	232	14	localException2	java.lang.Exception
        //   998	72	14	localObject5	Object
        //   1121	330	14	localObject6	Object
        //   1467	1	14	localObject7	Object
        //   1480	1	14	localObject8	Object
        //   1493	1	14	localObject9	Object
        //   1502	1	14	localObject10	Object
        //   1510	16	14	localException3	java.lang.Exception
        //   1531	1	14	localException4	java.lang.Exception
        //   1540	1	14	localException5	java.lang.Exception
        //   1549	1	14	localException6	java.lang.Exception
        //   88	1455	15	localObject11	Object
        //   21	1513	16	localObject12	Object
        //   452	633	17	localObject13	Object
        //   498	396	18	localObject14	Object
        //   903	86	19	localcc	com.tencent.mm.storage.cc
        // Exception table:
        //   from	to	target	type
        //   135	143	593	java/lang/Exception
        //   156	164	593	java/lang/Exception
        //   177	208	593	java/lang/Exception
        //   317	337	593	java/lang/Exception
        //   350	374	593	java/lang/Exception
        //   387	397	593	java/lang/Exception
        //   409	433	593	java/lang/Exception
        //   445	454	593	java/lang/Exception
        //   466	476	593	java/lang/Exception
        //   488	500	593	java/lang/Exception
        //   512	519	593	java/lang/Exception
        //   531	553	593	java/lang/Exception
        //   565	590	593	java/lang/Exception
        //   712	724	593	java/lang/Exception
        //   747	772	593	java/lang/Exception
        //   789	799	593	java/lang/Exception
        //   814	838	593	java/lang/Exception
        //   850	859	593	java/lang/Exception
        //   871	881	593	java/lang/Exception
        //   893	905	593	java/lang/Exception
        //   917	924	593	java/lang/Exception
        //   936	958	593	java/lang/Exception
        //   970	995	593	java/lang/Exception
        //   1084	1093	593	java/lang/Exception
        //   135	143	998	finally
        //   156	164	998	finally
        //   177	208	998	finally
        //   317	337	998	finally
        //   350	374	998	finally
        //   387	397	998	finally
        //   409	433	998	finally
        //   445	454	998	finally
        //   466	476	998	finally
        //   488	500	998	finally
        //   512	519	998	finally
        //   531	553	998	finally
        //   565	590	998	finally
        //   605	635	998	finally
        //   712	724	998	finally
        //   747	772	998	finally
        //   789	799	998	finally
        //   814	838	998	finally
        //   850	859	998	finally
        //   871	881	998	finally
        //   893	905	998	finally
        //   917	924	998	finally
        //   936	958	998	finally
        //   970	995	998	finally
        //   1084	1093	998	finally
        //   23	65	1467	finally
        //   73	90	1480	finally
        //   278	297	1480	finally
        //   90	118	1493	finally
        //   1101	1123	1502	finally
        //   1131	1164	1502	finally
        //   1185	1196	1502	finally
        //   1204	1224	1502	finally
        //   1232	1245	1502	finally
        //   1250	1272	1502	finally
        //   1272	1362	1502	finally
        //   1437	1460	1502	finally
        //   23	65	1510	java/lang/Exception
        //   73	90	1523	java/lang/Exception
        //   278	297	1523	java/lang/Exception
        //   90	118	1540	java/lang/Exception
        //   1101	1123	1549	java/lang/Exception
        //   1131	1164	1549	java/lang/Exception
        //   1185	1196	1549	java/lang/Exception
        //   1204	1224	1549	java/lang/Exception
        //   1232	1245	1549	java/lang/Exception
        //   1250	1272	1549	java/lang/Exception
        //   1272	1362	1549	java/lang/Exception
        //   1437	1460	1549	java/lang/Exception
      }
    };
    AppMethodBeat.o(241460);
  }
  
  public static void i(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(241465);
    li localli = new li();
    localli.iZO = localli.F("roomID", paramString1, true);
    localli.iZP = localli.F("oldRoomID", paramString2, true);
    localli.ila = paramInt;
    localli.bMH();
    AppMethodBeat.o(241465);
  }
  
  private void run()
  {
    AppMethodBeat.i(241463);
    if ((this.lya == null) || (this.lya.isDone()))
    {
      this.lya = h.ahAA.g(this.lyd, "migrate_tag");
      Log.w("MicroMsg.openIm.OpenImMigrateService", "run stack:%s", new Object[] { Util.getStack() });
      AppMethodBeat.o(241463);
      return;
    }
    Log.w("MicroMsg.openIm.OpenImMigrateService", "running stack:%s", new Object[] { Util.getStack() });
    AppMethodBeat.o(241463);
  }
  
  public final void CS(String paramString)
  {
    AppMethodBeat.i(241486);
    Log.i("MicroMsg.openIm.OpenImMigrateService", "setCurChatName:%s", new Object[] { Util.nullAs(paramString, "") });
    this.iiw = paramString;
    AppMethodBeat.o(241486);
  }
  
  public final void an(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241491);
    Log.i("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask %s %s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, "") });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(241491);
      return;
    }
    if (Util.isEqual(paramString2, this.iiw))
    {
      Log.w("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask in curChatName");
      AppMethodBeat.o(241491);
      return;
    }
    if (this.lyb.contains(paramString1))
    {
      Log.i("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask %s exist", new Object[] { Util.nullAs(paramString1, "") });
      AppMethodBeat.o(241491);
      return;
    }
    this.lyc.put(paramString1, paramString2);
    this.lyb.add(paramString1);
    run();
    AppMethodBeat.o(241491);
  }
  
  public final void ao(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241494);
    Log.i("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask %s %s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, "") });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(241494);
      return;
    }
    if (Util.isEqual(paramString2, this.iiw))
    {
      Log.w("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask in curChatName");
      AppMethodBeat.o(241494);
      return;
    }
    if (this.lyb.contains(paramString1))
    {
      Log.i("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask %s exist", new Object[] { Util.nullAs(paramString1, "") });
      this.lyb.remove(paramString1);
    }
    for (;;)
    {
      this.lyb.addFirst(paramString1);
      run();
      AppMethodBeat.o(241494);
      return;
      this.lyc.put(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.b
 * JD-Core Version:    0.7.0.1
 */