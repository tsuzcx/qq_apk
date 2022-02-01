package com.tencent.mm.chatroom.c;

import android.os.Message;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Future;

public final class b
{
  private String ehT;
  Future grQ;
  public ConcurrentLinkedDeque<String> grR;
  public ConcurrentHashMap<String, String> grS;
  Runnable grT;
  MMHandler mHandler;
  
  public b()
  {
    AppMethodBeat.i(194014);
    this.grQ = null;
    this.grR = new ConcurrentLinkedDeque();
    this.grS = new ConcurrentHashMap();
    this.ehT = "";
    this.mHandler = new MMHandler("OpenImMigrateService")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(194012);
        Log.i("MicroMsg.openIm.OpenImMigrateService", "handleMessage running, %s", new Object[] { Integer.valueOf(b.this.grR.size()) });
        if (!b.this.grR.isEmpty()) {
          b.this.grQ = h.RTc.b(b.this.grT, "migrate_tag");
        }
        AppMethodBeat.o(194012);
      }
    };
    this.grT = new Runnable()
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
        //   23: invokestatic 42	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   26: invokevirtual 48	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   29: getstatic 54	com/tencent/mm/storage/ar$a:OnZ	Lcom/tencent/mm/storage/ar$a;
        //   32: ldc 36
        //   34: invokevirtual 60	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
        //   37: checkcast 62	java/lang/String
        //   40: astore 12
        //   42: aload 12
        //   44: invokestatic 68	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   47: ifeq +223 -> 270
        //   50: aload_0
        //   51: getfield 14	com/tencent/mm/chatroom/c/b$2:grU	Lcom/tencent/mm/chatroom/c/b;
        //   54: getfield 72	com/tencent/mm/chatroom/c/b:grR	Ljava/util/concurrent/ConcurrentLinkedDeque;
        //   57: invokevirtual 78	java/util/concurrent/ConcurrentLinkedDeque:removeFirst	()Ljava/lang/Object;
        //   60: checkcast 62	java/lang/String
        //   63: astore 12
        //   65: aload 12
        //   67: astore 13
        //   69: aload 12
        //   71: astore 14
        //   73: aload_0
        //   74: getfield 14	com/tencent/mm/chatroom/c/b$2:grU	Lcom/tencent/mm/chatroom/c/b;
        //   77: getfield 82	com/tencent/mm/chatroom/c/b:grS	Ljava/util/concurrent/ConcurrentHashMap;
        //   80: aload 12
        //   82: invokevirtual 88	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
        //   85: checkcast 62	java/lang/String
        //   88: astore 15
        //   90: invokestatic 42	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   93: invokevirtual 48	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   96: getstatic 54	com/tencent/mm/storage/ar$a:OnZ	Lcom/tencent/mm/storage/ar$a;
        //   99: aload 12
        //   101: invokevirtual 92	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
        //   104: invokestatic 42	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   107: invokevirtual 48	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   110: getstatic 95	com/tencent/mm/storage/ar$a:OnY	Lcom/tencent/mm/storage/ar$a;
        //   113: aload 15
        //   115: invokevirtual 92	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
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
        //   278: invokestatic 42	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   281: invokevirtual 48	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   284: getstatic 95	com/tencent/mm/storage/ar$a:OnY	Lcom/tencent/mm/storage/ar$a;
        //   287: ldc 36
        //   289: invokevirtual 60	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
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
        //   319: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   322: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
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
        //   352: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   355: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
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
        //   495: checkcast 185	com/tencent/mm/storage/ca
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
        //   516: invokevirtual 188	com/tencent/mm/storage/ca:Cy	(Ljava/lang/String;)V
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
        //   543: getfield 196	com/tencent/mm/g/c/eo:field_msgId	J
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
        //   567: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   570: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   573: invokeinterface 153 1 0
        //   578: aload 18
        //   580: getfield 196	com/tencent/mm/g/c/eo:field_msgId	J
        //   583: aload 18
        //   585: invokeinterface 200 4 0
        //   590: goto -136 -> 454
        //   593: astore 14
        //   595: aload 13
        //   597: astore 15
        //   599: aload 12
        //   601: astore 16
        //   603: iload_3
        //   604: istore_1
        //   605: ldc 97
        //   607: ldc 202
        //   609: iconst_2
        //   610: anewarray 4	java/lang/Object
        //   613: dup
        //   614: iconst_0
        //   615: aload 14
        //   617: invokevirtual 206	java/lang/Object:getClass	()Ljava/lang/Class;
        //   620: invokevirtual 212	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   623: aastore
        //   624: dup
        //   625: iconst_1
        //   626: aload 14
        //   628: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   631: aastore
        //   632: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   721: if_icmpne +378 -> 1099
        //   724: iconst_0
        //   725: istore 5
        //   727: iload_2
        //   728: istore 4
        //   730: iload 5
        //   732: ifne +367 -> 1099
        //   735: iload_2
        //   736: istore_3
        //   737: aload 13
        //   739: astore 15
        //   741: aload 12
        //   743: astore 16
        //   745: iload_2
        //   746: istore_1
        //   747: ldc 135
        //   749: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   752: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   755: invokeinterface 153 1 0
        //   760: aload 13
        //   762: sipush 500
        //   765: invokeinterface 159 3 0
        //   770: astore 17
        //   772: iload_2
        //   773: istore_3
        //   774: aload 13
        //   776: astore 15
        //   778: aload 12
        //   780: astore 16
        //   782: iload_2
        //   783: istore_1
        //   784: aload 17
        //   786: invokeinterface 165 1 0
        //   791: ifne +9 -> 800
        //   794: iconst_1
        //   795: istore 5
        //   797: goto -70 -> 727
        //   800: iload_2
        //   801: istore_3
        //   802: aload 13
        //   804: astore 15
        //   806: aload 12
        //   808: astore 16
        //   810: iload_2
        //   811: istore_1
        //   812: ldc 97
        //   814: ldc 167
        //   816: iconst_1
        //   817: anewarray 4	java/lang/Object
        //   820: dup
        //   821: iconst_0
        //   822: aload 14
        //   824: invokeinterface 165 1 0
        //   829: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   832: aastore
        //   833: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   836: iload_2
        //   837: istore_3
        //   838: aload 13
        //   840: astore 15
        //   842: aload 12
        //   844: astore 16
        //   846: iload_2
        //   847: istore_1
        //   848: aload 17
        //   850: invokeinterface 174 1 0
        //   855: astore 18
        //   857: iload_2
        //   858: istore_3
        //   859: aload 13
        //   861: astore 15
        //   863: aload 12
        //   865: astore 16
        //   867: iload_2
        //   868: istore_1
        //   869: aload 18
        //   871: invokeinterface 180 1 0
        //   876: ifeq +194 -> 1070
        //   879: iload_2
        //   880: istore_3
        //   881: aload 13
        //   883: astore 15
        //   885: aload 12
        //   887: astore 16
        //   889: iload_2
        //   890: istore_1
        //   891: aload 18
        //   893: invokeinterface 183 1 0
        //   898: checkcast 185	com/tencent/mm/storage/ca
        //   901: astore 19
        //   903: iload_2
        //   904: istore_3
        //   905: aload 13
        //   907: astore 15
        //   909: aload 12
        //   911: astore 16
        //   913: iload_2
        //   914: istore_1
        //   915: aload 19
        //   917: aload 12
        //   919: invokevirtual 188	com/tencent/mm/storage/ca:Cy	(Ljava/lang/String;)V
        //   922: iload_2
        //   923: istore_3
        //   924: aload 13
        //   926: astore 15
        //   928: aload 12
        //   930: astore 16
        //   932: iload_2
        //   933: istore_1
        //   934: ldc 97
        //   936: ldc 220
        //   938: iconst_1
        //   939: anewarray 4	java/lang/Object
        //   942: dup
        //   943: iconst_0
        //   944: aload 19
        //   946: getfield 196	com/tencent/mm/g/c/eo:field_msgId	J
        //   949: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   952: aastore
        //   953: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   956: iload_2
        //   957: istore_3
        //   958: aload 13
        //   960: astore 15
        //   962: aload 12
        //   964: astore 16
        //   966: iload_2
        //   967: istore_1
        //   968: ldc 135
        //   970: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   973: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   976: invokeinterface 153 1 0
        //   981: aload 19
        //   983: getfield 196	com/tencent/mm/g/c/eo:field_msgId	J
        //   986: aload 19
        //   988: invokeinterface 200 4 0
        //   993: goto -136 -> 857
        //   996: astore 14
        //   998: aload 16
        //   1000: astore 12
        //   1002: aload 15
        //   1004: astore 13
        //   1006: ldc 97
        //   1008: ldc 111
        //   1010: iconst_5
        //   1011: anewarray 4	java/lang/Object
        //   1014: dup
        //   1015: iconst_0
        //   1016: aload 13
        //   1018: ldc 36
        //   1020: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1023: aastore
        //   1024: dup
        //   1025: iconst_1
        //   1026: aload 12
        //   1028: ldc 36
        //   1030: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1033: aastore
        //   1034: dup
        //   1035: iconst_2
        //   1036: iload_1
        //   1037: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1040: aastore
        //   1041: dup
        //   1042: iconst_3
        //   1043: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   1046: lload 8
        //   1048: lsub
        //   1049: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   1052: aastore
        //   1053: dup
        //   1054: iconst_4
        //   1055: getstatic 128	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
        //   1058: aastore
        //   1059: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1062: ldc 22
        //   1064: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1067: aload 14
        //   1069: athrow
        //   1070: iload_2
        //   1071: istore_3
        //   1072: aload 13
        //   1074: astore 15
        //   1076: aload 12
        //   1078: astore 16
        //   1080: iload_2
        //   1081: istore_1
        //   1082: aload 17
        //   1084: invokeinterface 165 1 0
        //   1089: istore 4
        //   1091: iload_2
        //   1092: iload 4
        //   1094: iadd
        //   1095: istore_2
        //   1096: goto -369 -> 727
        //   1099: ldc 135
        //   1101: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1104: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   1107: invokeinterface 143 1 0
        //   1112: aload 12
        //   1114: invokeinterface 224 2 0
        //   1119: astore 14
        //   1121: aload 14
        //   1123: ifnonnull +432 -> 1555
        //   1126: iconst_1
        //   1127: istore 11
        //   1129: new 226	com/tencent/mm/storage/az
        //   1132: dup
        //   1133: aload 12
        //   1135: invokespecial 228	com/tencent/mm/storage/az:<init>	(Ljava/lang/String;)V
        //   1138: astore 15
        //   1140: ldc 135
        //   1142: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1145: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   1148: invokeinterface 232 1 0
        //   1153: aload 12
        //   1155: invokeinterface 238 2 0
        //   1160: astore 16
        //   1162: iload 11
        //   1164: istore 10
        //   1166: aload 15
        //   1168: astore 14
        //   1170: aload 16
        //   1172: ifnull +58 -> 1230
        //   1175: iload 11
        //   1177: istore 10
        //   1179: aload 15
        //   1181: astore 14
        //   1183: aload 16
        //   1185: getfield 244	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
        //   1188: invokestatic 68	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   1191: ifne +39 -> 1230
        //   1194: iload 11
        //   1196: istore 10
        //   1198: aload 15
        //   1200: astore 14
        //   1202: aload 16
        //   1204: invokevirtual 249	com/tencent/mm/storage/as:arE	()Z
        //   1207: ifeq +23 -> 1230
        //   1210: aload 15
        //   1212: aload 15
        //   1214: iconst_2
        //   1215: lconst_0
        //   1216: invokestatic 254	com/tencent/mm/plugin/messenger/foundation/a/a/a:a	(Lcom/tencent/mm/storage/az;IJ)J
        //   1219: invokevirtual 258	com/tencent/mm/storage/az:yB	(J)V
        //   1222: aload 15
        //   1224: astore 14
        //   1226: iload 11
        //   1228: istore 10
        //   1230: aload 14
        //   1232: aload 14
        //   1234: getfield 261	com/tencent/mm/g/c/bb:field_username	Ljava/lang/String;
        //   1237: invokestatic 267	com/tencent/mm/model/bp:Ku	(Ljava/lang/String;)I
        //   1240: invokevirtual 270	com/tencent/mm/storage/az:ns	(I)V
        //   1243: iload 10
        //   1245: ifeq +190 -> 1435
        //   1248: ldc 135
        //   1250: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1253: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   1256: invokeinterface 143 1 0
        //   1261: aload 14
        //   1263: invokeinterface 273 2 0
        //   1268: lstore 6
        //   1270: ldc 97
        //   1272: ldc_w 275
        //   1275: iconst_4
        //   1276: anewarray 4	java/lang/Object
        //   1279: dup
        //   1280: iconst_0
        //   1281: aload 12
        //   1283: aastore
        //   1284: dup
        //   1285: iconst_1
        //   1286: iload 10
        //   1288: invokestatic 278	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   1291: aastore
        //   1292: dup
        //   1293: iconst_2
        //   1294: lload 6
        //   1296: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   1299: aastore
        //   1300: dup
        //   1301: iconst_3
        //   1302: aload 14
        //   1304: getfield 282	com/tencent/mm/g/c/bb:field_msgCount	I
        //   1307: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1310: aastore
        //   1311: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1314: aload 12
        //   1316: invokestatic 285	com/tencent/mm/chatroom/c/b:Dx	(Ljava/lang/String;)V
        //   1319: aload 13
        //   1321: invokestatic 285	com/tencent/mm/chatroom/c/b:Dx	(Ljava/lang/String;)V
        //   1324: aload 12
        //   1326: aload 13
        //   1328: iconst_1
        //   1329: invokestatic 289	com/tencent/mm/chatroom/c/b:f	(Ljava/lang/String;Ljava/lang/String;I)V
        //   1332: invokestatic 42	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   1335: invokevirtual 48	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   1338: getstatic 54	com/tencent/mm/storage/ar$a:OnZ	Lcom/tencent/mm/storage/ar$a;
        //   1341: ldc 36
        //   1343: invokevirtual 92	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
        //   1346: invokestatic 42	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   1349: invokevirtual 48	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   1352: getstatic 95	com/tencent/mm/storage/ar$a:OnY	Lcom/tencent/mm/storage/ar$a;
        //   1355: ldc 36
        //   1357: invokevirtual 92	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
        //   1360: ldc 97
        //   1362: ldc 111
        //   1364: iconst_5
        //   1365: anewarray 4	java/lang/Object
        //   1368: dup
        //   1369: iconst_0
        //   1370: aload 13
        //   1372: ldc 36
        //   1374: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1377: aastore
        //   1378: dup
        //   1379: iconst_1
        //   1380: aload 12
        //   1382: ldc 36
        //   1384: invokestatic 103	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1387: aastore
        //   1388: dup
        //   1389: iconst_2
        //   1390: iload 4
        //   1392: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1395: aastore
        //   1396: dup
        //   1397: iconst_3
        //   1398: invokestatic 34	java/lang/System:currentTimeMillis	()J
        //   1401: lload 8
        //   1403: lsub
        //   1404: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   1407: aastore
        //   1408: dup
        //   1409: iconst_4
        //   1410: getstatic 292	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   1413: aastore
        //   1414: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1417: aload_0
        //   1418: getfield 14	com/tencent/mm/chatroom/c/b$2:grU	Lcom/tencent/mm/chatroom/c/b;
        //   1421: getfield 296	com/tencent/mm/chatroom/c/b:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
        //   1424: iconst_0
        //   1425: invokevirtual 302	com/tencent/mm/sdk/platformtools/MMHandler:sendEmptyMessage	(I)Z
        //   1428: pop
        //   1429: ldc 22
        //   1431: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1434: return
        //   1435: ldc 135
        //   1437: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   1440: checkcast 135	com/tencent/mm/plugin/messenger/foundation/a/l
        //   1443: invokeinterface 143 1 0
        //   1448: aload 14
        //   1450: aload 12
        //   1452: invokeinterface 305 3 0
        //   1457: istore_1
        //   1458: iload_1
        //   1459: i2l
        //   1460: lstore 6
        //   1462: goto -192 -> 1270
        //   1465: astore 14
        //   1467: ldc 36
        //   1469: astore 12
        //   1471: aload 16
        //   1473: astore 13
        //   1475: goto -469 -> 1006
        //   1478: astore 14
        //   1480: aload 13
        //   1482: astore 12
        //   1484: aload 16
        //   1486: astore 13
        //   1488: goto -482 -> 1006
        //   1491: astore 14
        //   1493: aload 15
        //   1495: astore 13
        //   1497: goto -491 -> 1006
        //   1500: astore 14
        //   1502: iload 4
        //   1504: istore_1
        //   1505: goto -499 -> 1006
        //   1508: astore 14
        //   1510: ldc 36
        //   1512: astore 12
        //   1514: aload 16
        //   1516: astore 13
        //   1518: goto -923 -> 595
        //   1521: astore 13
        //   1523: aload 14
        //   1525: astore 12
        //   1527: aload 13
        //   1529: astore 14
        //   1531: aload 16
        //   1533: astore 13
        //   1535: goto -940 -> 595
        //   1538: astore 14
        //   1540: aload 15
        //   1542: astore 13
        //   1544: goto -949 -> 595
        //   1547: astore 14
        //   1549: iload 4
        //   1551: istore_3
        //   1552: goto -957 -> 595
        //   1555: iconst_0
        //   1556: istore 10
        //   1558: goto -328 -> 1230
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1561	0	this	2
        //   16	1489	1	i	int
        //   18	1078	2	j	int
        //   11	1541	3	k	int
        //   13	1537	4	m	int
        //   725	71	5	n	int
        //   1268	193	6	l1	long
        //   8	1394	8	l2	long
        //   1164	393	10	bool1	boolean
        //   1127	100	11	bool2	boolean
        //   40	1486	12	localObject1	Object
        //   67	1450	13	localObject2	Object
        //   1521	7	13	localException1	java.lang.Exception
        //   1533	10	13	localObject3	Object
        //   71	375	14	localObject4	Object
        //   593	230	14	localException2	java.lang.Exception
        //   996	72	14	localObject5	Object
        //   1119	330	14	localObject6	Object
        //   1465	1	14	localObject7	Object
        //   1478	1	14	localObject8	Object
        //   1491	1	14	localObject9	Object
        //   1500	1	14	localObject10	Object
        //   1508	16	14	localException3	java.lang.Exception
        //   1529	1	14	localException4	java.lang.Exception
        //   1538	1	14	localException5	java.lang.Exception
        //   1547	1	14	localException6	java.lang.Exception
        //   88	1453	15	localObject11	Object
        //   21	1511	16	localObject12	Object
        //   452	631	17	localObject13	Object
        //   498	394	18	localObject14	Object
        //   901	86	19	localca	com.tencent.mm.storage.ca
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
        //   784	794	593	java/lang/Exception
        //   812	836	593	java/lang/Exception
        //   848	857	593	java/lang/Exception
        //   869	879	593	java/lang/Exception
        //   891	903	593	java/lang/Exception
        //   915	922	593	java/lang/Exception
        //   934	956	593	java/lang/Exception
        //   968	993	593	java/lang/Exception
        //   1082	1091	593	java/lang/Exception
        //   135	143	996	finally
        //   156	164	996	finally
        //   177	208	996	finally
        //   317	337	996	finally
        //   350	374	996	finally
        //   387	397	996	finally
        //   409	433	996	finally
        //   445	454	996	finally
        //   466	476	996	finally
        //   488	500	996	finally
        //   512	519	996	finally
        //   531	553	996	finally
        //   565	590	996	finally
        //   605	635	996	finally
        //   712	724	996	finally
        //   747	772	996	finally
        //   784	794	996	finally
        //   812	836	996	finally
        //   848	857	996	finally
        //   869	879	996	finally
        //   891	903	996	finally
        //   915	922	996	finally
        //   934	956	996	finally
        //   968	993	996	finally
        //   1082	1091	996	finally
        //   23	65	1465	finally
        //   73	90	1478	finally
        //   278	297	1478	finally
        //   90	118	1491	finally
        //   1099	1121	1500	finally
        //   1129	1162	1500	finally
        //   1183	1194	1500	finally
        //   1202	1222	1500	finally
        //   1230	1243	1500	finally
        //   1248	1270	1500	finally
        //   1270	1360	1500	finally
        //   1435	1458	1500	finally
        //   23	65	1508	java/lang/Exception
        //   73	90	1521	java/lang/Exception
        //   278	297	1521	java/lang/Exception
        //   90	118	1538	java/lang/Exception
        //   1099	1121	1547	java/lang/Exception
        //   1129	1162	1547	java/lang/Exception
        //   1183	1194	1547	java/lang/Exception
        //   1202	1222	1547	java/lang/Exception
        //   1230	1243	1547	java/lang/Exception
        //   1248	1270	1547	java/lang/Exception
        //   1270	1360	1547	java/lang/Exception
        //   1435	1458	1547	java/lang/Exception
      }
    };
    AppMethodBeat.o(194014);
  }
  
  public static void f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(194019);
    gt localgt = new gt();
    localgt.uw(paramString1);
    localgt.ux(paramString2);
    localgt.ejW = paramInt;
    localgt.bfK();
    AppMethodBeat.o(194019);
  }
  
  private void run()
  {
    AppMethodBeat.i(194018);
    if ((this.grQ == null) || (this.grQ.isDone()))
    {
      this.grQ = h.RTc.b(this.grT, "migrate_tag");
      Log.w("MicroMsg.openIm.OpenImMigrateService", "run stack:%s", new Object[] { Util.getStack() });
      AppMethodBeat.o(194018);
      return;
    }
    Log.w("MicroMsg.openIm.OpenImMigrateService", "running stack:%s", new Object[] { Util.getStack() });
    AppMethodBeat.o(194018);
  }
  
  public final void Dw(String paramString)
  {
    AppMethodBeat.i(194015);
    Log.i("MicroMsg.openIm.OpenImMigrateService", "setCurChatName:%s", new Object[] { Util.nullAs(paramString, "") });
    this.ehT = paramString;
    AppMethodBeat.o(194015);
  }
  
  public final void ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194016);
    Log.i("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask %s %s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, "") });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(194016);
      return;
    }
    if (Util.isEqual(paramString2, this.ehT))
    {
      Log.w("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask in curChatName");
      AppMethodBeat.o(194016);
      return;
    }
    if (this.grR.contains(paramString1))
    {
      Log.i("MicroMsg.openIm.OpenImMigrateService", "addMigrateTask %s exist", new Object[] { Util.nullAs(paramString1, "") });
      AppMethodBeat.o(194016);
      return;
    }
    this.grS.put(paramString1, paramString2);
    this.grR.add(paramString1);
    run();
    AppMethodBeat.o(194016);
  }
  
  public final void af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194017);
    Log.i("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask %s %s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, "") });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(194017);
      return;
    }
    if (Util.isEqual(paramString2, this.ehT))
    {
      Log.w("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask in curChatName");
      AppMethodBeat.o(194017);
      return;
    }
    if (this.grR.contains(paramString1))
    {
      Log.i("MicroMsg.openIm.OpenImMigrateService", "addFirstMigrateTask %s exist", new Object[] { Util.nullAs(paramString1, "") });
      this.grR.remove(paramString1);
    }
    for (;;)
    {
      this.grR.addFirst(paramString1);
      run();
      AppMethodBeat.o(194017);
      return;
      this.grS.put(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.b
 * JD-Core Version:    0.7.0.1
 */