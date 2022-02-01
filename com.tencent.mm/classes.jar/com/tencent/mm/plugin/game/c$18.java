package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.sdk.event.IListener;

final class c$18
  extends IListener<ox>
{
  c$18(c paramc)
  {
    AppMethodBeat.i(161126);
    this.__eventId = ox.class.getName().hashCode();
    AppMethodBeat.o(161126);
  }
  
  /* Error */
  private static boolean a(ox paramox)
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 54
    //   7: astore 4
    //   9: ldc 54
    //   11: astore 7
    //   13: aload 4
    //   15: astore 5
    //   17: aload 4
    //   19: astore 6
    //   21: new 56	org/json/JSONObject
    //   24: dup
    //   25: aload_0
    //   26: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   29: getfield 66	com/tencent/mm/g/a/ox$a:extraInfo	Ljava/lang/String;
    //   32: invokespecial 69	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: astore 8
    //   37: aload 4
    //   39: astore 5
    //   41: aload 4
    //   43: astore 6
    //   45: aload 8
    //   47: ldc 71
    //   49: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: astore 5
    //   58: aload 4
    //   60: astore 6
    //   62: aload 8
    //   64: ldc 77
    //   66: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: iconst_0
    //   70: invokestatic 83	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   73: istore_1
    //   74: aload 7
    //   76: astore 5
    //   78: aload 8
    //   80: ldc 85
    //   82: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 5
    //   91: aload 6
    //   93: astore 7
    //   95: aload 8
    //   97: ldc 87
    //   99: iconst_0
    //   100: invokevirtual 90	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   103: istore_3
    //   104: iload_1
    //   105: istore_2
    //   106: iload_3
    //   107: istore_1
    //   108: new 92	android/content/Intent
    //   111: dup
    //   112: invokespecial 93	android/content/Intent:<init>	()V
    //   115: astore 5
    //   117: aload_0
    //   118: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   121: getfield 96	com/tencent/mm/g/a/ox$a:dUY	I
    //   124: tableswitch	default:+32 -> 156, 0:+135->259, 1:+276->400, 2:+417->541, 3:+576->700
    //   157: caload
    //   158: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore 6
    //   165: ldc 54
    //   167: astore 7
    //   169: iconst_0
    //   170: istore_1
    //   171: aload 5
    //   173: astore 4
    //   175: aload 7
    //   177: astore 5
    //   179: ldc 98
    //   181: ldc 100
    //   183: iconst_1
    //   184: anewarray 102	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload 6
    //   191: invokevirtual 105	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   194: aastore
    //   195: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: iconst_0
    //   199: istore_3
    //   200: iload_1
    //   201: istore_2
    //   202: iload_3
    //   203: istore_1
    //   204: aload 5
    //   206: astore 6
    //   208: goto -100 -> 108
    //   211: astore 7
    //   213: ldc 54
    //   215: astore 5
    //   217: iconst_0
    //   218: istore_1
    //   219: aload 6
    //   221: astore 4
    //   223: aload 7
    //   225: astore 6
    //   227: ldc 98
    //   229: ldc 100
    //   231: iconst_1
    //   232: anewarray 102	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 6
    //   239: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: iconst_0
    //   247: istore_3
    //   248: iload_1
    //   249: istore_2
    //   250: iload_3
    //   251: istore_1
    //   252: aload 5
    //   254: astore 6
    //   256: goto -148 -> 108
    //   259: aload 5
    //   261: aload_0
    //   262: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   265: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   268: ldc 118
    //   270: invokevirtual 122	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   273: pop
    //   274: aload_0
    //   275: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   278: getfield 125	com/tencent/mm/g/a/ox$a:jumpType	I
    //   281: iconst_1
    //   282: if_icmpne +13 -> 295
    //   285: aload 5
    //   287: ldc 127
    //   289: ldc 127
    //   291: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   294: pop
    //   295: aload 5
    //   297: ldc 133
    //   299: iconst_5
    //   300: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   303: pop
    //   304: aload_0
    //   305: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   308: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   311: astore 4
    //   313: new 138	com/tencent/mm/hellhoundlib/b/a
    //   316: dup
    //   317: invokespecial 139	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   320: aload 5
    //   322: invokevirtual 143	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   325: astore 5
    //   327: aload 4
    //   329: aload 5
    //   331: invokevirtual 147	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   334: ldc 149
    //   336: ldc 151
    //   338: ldc 153
    //   340: ldc 155
    //   342: ldc 157
    //   344: ldc 159
    //   346: invokestatic 164	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload 4
    //   351: aload 5
    //   353: iconst_0
    //   354: invokevirtual 168	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   357: checkcast 92	android/content/Intent
    //   360: invokevirtual 172	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   363: aload 4
    //   365: ldc 149
    //   367: ldc 151
    //   369: ldc 153
    //   371: ldc 155
    //   373: ldc 157
    //   375: ldc 159
    //   377: invokestatic 175	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload_0
    //   381: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   384: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   387: iconst_5
    //   388: iconst_5
    //   389: iconst_1
    //   390: bipush 6
    //   392: iload_2
    //   393: aconst_null
    //   394: invokestatic 180	com/tencent/mm/game/report/f:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
    //   397: goto -241 -> 156
    //   400: aload 5
    //   402: aload_0
    //   403: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   406: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   409: ldc 182
    //   411: invokevirtual 122	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_0
    //   416: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   419: getfield 125	com/tencent/mm/g/a/ox$a:jumpType	I
    //   422: iconst_1
    //   423: if_icmpne +13 -> 436
    //   426: aload 5
    //   428: ldc 184
    //   430: ldc 184
    //   432: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   435: pop
    //   436: aload 5
    //   438: ldc 133
    //   440: iconst_5
    //   441: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   444: pop
    //   445: aload_0
    //   446: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   449: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   452: astore 4
    //   454: new 138	com/tencent/mm/hellhoundlib/b/a
    //   457: dup
    //   458: invokespecial 139	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   461: aload 5
    //   463: invokevirtual 143	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   466: astore 5
    //   468: aload 4
    //   470: aload 5
    //   472: invokevirtual 147	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   475: ldc 149
    //   477: ldc 151
    //   479: ldc 153
    //   481: ldc 155
    //   483: ldc 157
    //   485: ldc 159
    //   487: invokestatic 164	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   490: aload 4
    //   492: aload 5
    //   494: iconst_0
    //   495: invokevirtual 168	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   498: checkcast 92	android/content/Intent
    //   501: invokevirtual 172	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   504: aload 4
    //   506: ldc 149
    //   508: ldc 151
    //   510: ldc 153
    //   512: ldc 155
    //   514: ldc 157
    //   516: ldc 159
    //   518: invokestatic 175	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload_0
    //   522: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   525: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   528: iconst_5
    //   529: iconst_5
    //   530: iconst_1
    //   531: bipush 6
    //   533: iload_2
    //   534: aconst_null
    //   535: invokestatic 180	com/tencent/mm/game/report/f:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
    //   538: goto -382 -> 156
    //   541: aload 4
    //   543: invokestatic 188	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   546: ifne -390 -> 156
    //   549: aload 5
    //   551: aload_0
    //   552: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   555: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   558: ldc 190
    //   560: invokevirtual 122	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   563: pop
    //   564: aload 5
    //   566: ldc 192
    //   568: aload 4
    //   570: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   573: pop
    //   574: aload_0
    //   575: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   578: getfield 125	com/tencent/mm/g/a/ox$a:jumpType	I
    //   581: iconst_1
    //   582: if_icmpne +13 -> 595
    //   585: aload 5
    //   587: ldc 184
    //   589: ldc 184
    //   591: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   594: pop
    //   595: aload 5
    //   597: ldc 133
    //   599: iconst_5
    //   600: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   603: pop
    //   604: aload_0
    //   605: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   608: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   611: astore 4
    //   613: new 138	com/tencent/mm/hellhoundlib/b/a
    //   616: dup
    //   617: invokespecial 139	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   620: aload 5
    //   622: invokevirtual 143	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   625: astore 5
    //   627: aload 4
    //   629: aload 5
    //   631: invokevirtual 147	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   634: ldc 149
    //   636: ldc 151
    //   638: ldc 153
    //   640: ldc 155
    //   642: ldc 157
    //   644: ldc 159
    //   646: invokestatic 164	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   649: aload 4
    //   651: aload 5
    //   653: iconst_0
    //   654: invokevirtual 168	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   657: checkcast 92	android/content/Intent
    //   660: invokevirtual 172	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   663: aload 4
    //   665: ldc 149
    //   667: ldc 151
    //   669: ldc 153
    //   671: ldc 155
    //   673: ldc 157
    //   675: ldc 159
    //   677: invokestatic 175	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload_0
    //   681: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   684: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   687: iconst_5
    //   688: iconst_5
    //   689: iconst_1
    //   690: bipush 6
    //   692: iload_2
    //   693: aconst_null
    //   694: invokestatic 180	com/tencent/mm/game/report/f:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
    //   697: goto -541 -> 156
    //   700: ldc 194
    //   702: invokestatic 200	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   705: checkcast 194	com/tencent/mm/game/report/a/b
    //   708: getstatic 206	com/tencent/mm/plugin/expt/b/b$a:rOP	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   711: iconst_1
    //   712: invokeinterface 209 3 0
    //   717: iconst_1
    //   718: if_icmpne +148 -> 866
    //   721: iconst_1
    //   722: istore_3
    //   723: iload_3
    //   724: ifeq +147 -> 871
    //   727: aload 5
    //   729: aload_0
    //   730: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   733: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   736: ldc 211
    //   738: invokevirtual 122	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   741: pop
    //   742: aload 5
    //   744: ldc 133
    //   746: iload_2
    //   747: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   750: pop
    //   751: aload 5
    //   753: ldc 213
    //   755: aload 6
    //   757: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   760: pop
    //   761: aload 5
    //   763: ldc 215
    //   765: iload_1
    //   766: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   769: pop
    //   770: aload_0
    //   771: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   774: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   777: astore 4
    //   779: new 138	com/tencent/mm/hellhoundlib/b/a
    //   782: dup
    //   783: invokespecial 139	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   786: aload 5
    //   788: invokevirtual 143	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   791: astore 5
    //   793: aload 4
    //   795: aload 5
    //   797: invokevirtual 147	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   800: ldc 149
    //   802: ldc 151
    //   804: ldc 153
    //   806: ldc 155
    //   808: ldc 157
    //   810: ldc 159
    //   812: invokestatic 164	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload 4
    //   817: aload 5
    //   819: iconst_0
    //   820: invokevirtual 168	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   823: checkcast 92	android/content/Intent
    //   826: invokevirtual 172	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   829: aload 4
    //   831: ldc 149
    //   833: ldc 151
    //   835: ldc 153
    //   837: ldc 155
    //   839: ldc 157
    //   841: ldc 159
    //   843: invokestatic 175	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   846: aload_0
    //   847: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   850: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   853: iconst_5
    //   854: iconst_5
    //   855: iconst_1
    //   856: bipush 6
    //   858: iload_2
    //   859: aconst_null
    //   860: invokestatic 180	com/tencent/mm/game/report/f:a	(Landroid/content/Context;IIIIILjava/lang/String;)V
    //   863: goto -707 -> 156
    //   866: iconst_0
    //   867: istore_3
    //   868: goto -145 -> 723
    //   871: aload 5
    //   873: aload_0
    //   874: getfield 60	com/tencent/mm/g/a/ox:dUX	Lcom/tencent/mm/g/a/ox$a;
    //   877: getfield 116	com/tencent/mm/g/a/ox$a:context	Landroid/content/Context;
    //   880: ldc 217
    //   882: invokevirtual 122	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   885: pop
    //   886: goto -144 -> 742
    //   889: astore 6
    //   891: goto -664 -> 227
    //   894: astore 6
    //   896: aload 7
    //   898: astore 5
    //   900: goto -721 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	paramox	ox
    //   73	693	1	i	int
    //   105	754	2	j	int
    //   103	765	3	k	int
    //   7	823	4	localObject1	java.lang.Object
    //   15	884	5	localObject2	java.lang.Object
    //   19	73	6	localObject3	java.lang.Object
    //   163	27	6	localJSONException1	org.json.JSONException
    //   206	550	6	localObject4	java.lang.Object
    //   889	1	6	localException1	java.lang.Exception
    //   894	1	6	localJSONException2	org.json.JSONException
    //   11	165	7	localObject5	java.lang.Object
    //   211	686	7	localException2	java.lang.Exception
    //   35	61	8	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   21	37	163	org/json/JSONException
    //   45	54	163	org/json/JSONException
    //   62	74	163	org/json/JSONException
    //   21	37	211	java/lang/Exception
    //   45	54	211	java/lang/Exception
    //   62	74	211	java/lang/Exception
    //   78	87	889	java/lang/Exception
    //   95	104	889	java/lang/Exception
    //   78	87	894	org/json/JSONException
    //   95	104	894	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.18
 * JD-Core Version:    0.7.0.1
 */