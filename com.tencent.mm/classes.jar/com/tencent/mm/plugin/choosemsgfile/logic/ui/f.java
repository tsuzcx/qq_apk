package com.tencent.mm.plugin.choosemsgfile.logic.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.choosemsgfile.a.c;
import com.tencent.mm.plugin.choosemsgfile.logic.b.m;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;

public final class f
  extends b
{
  int Sc;
  public c wQA;
  private IListener wQB;
  private GridLayoutManager wQC;
  int wQD;
  
  public f(e parame)
  {
    super(parame);
    AppMethodBeat.i(123339);
    this.Sc = 0;
    this.wQD = 0;
    this.wQB = new ChooseMsgFileUIController.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(123339);
  }
  
  public final void c(final boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123346);
    if (paramBoolean)
    {
      this.mDataList.clear();
      this.Sc = 0;
    }
    this.wQA.wQp = true;
    this.wQl.nm(paramBoolean);
    h.baF();
    h.baH().postToWorker(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 36
        //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 44	java/util/LinkedList
        //   8: dup
        //   9: invokespecial 45	java/util/LinkedList:<init>	()V
        //   12: astore 7
        //   14: ldc 47
        //   16: invokestatic 53	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   19: checkcast 47	com/tencent/mm/plugin/messenger/foundation/a/n
        //   22: invokeinterface 57 1 0
        //   27: aload_0
        //   28: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   31: getfield 60	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:luk	Ljava/lang/String;
        //   34: aload_0
        //   35: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   38: getfield 64	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:Sc	I
        //   41: invokeinterface 70 3 0
        //   46: astore 8
        //   48: aload 8
        //   50: ifnonnull +16 -> 66
        //   53: ldc 72
        //   55: ldc 74
        //   57: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   60: ldc 36
        //   62: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: lconst_0
        //   67: lstore_3
        //   68: aload 8
        //   70: invokeinterface 89 1 0
        //   75: ifeq +139 -> 214
        //   78: aload_0
        //   79: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   82: invokestatic 93	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:b	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;)I
        //   85: pop
        //   86: new 95	com/tencent/mm/storage/cc
        //   89: dup
        //   90: invokespecial 96	com/tencent/mm/storage/cc:<init>	()V
        //   93: astore 9
        //   95: aload 9
        //   97: aload 8
        //   99: invokevirtual 100	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
        //   102: aload_0
        //   103: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   106: getfield 104	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:wQA	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/c;
        //   109: aload 9
        //   111: aload_0
        //   112: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   115: getfield 60	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:luk	Ljava/lang/String;
        //   118: aload_0
        //   119: getfield 26	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:ezi	Ljava/lang/String;
        //   122: aload_0
        //   123: getfield 28	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQw	Ljava/lang/String;
        //   126: invokestatic 110	com/tencent/mm/plugin/choosemsgfile/logic/c/c:a	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/c;Lcom/tencent/mm/storage/cc;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/choosemsgfile/logic/b/a;
        //   129: astore 10
        //   131: aload 10
        //   133: ifnull +587 -> 720
        //   136: new 112	java/util/Date
        //   139: dup
        //   140: aload 9
        //   142: invokevirtual 116	com/tencent/mm/storage/cc:getCreateTime	()J
        //   145: invokespecial 119	java/util/Date:<init>	(J)V
        //   148: astore 11
        //   150: invokestatic 125	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   153: aload 11
        //   155: invokevirtual 128	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   158: lstore 5
        //   160: lload_3
        //   161: lload 5
        //   163: lcmp
        //   164: ifeq +36 -> 200
        //   167: aload 7
        //   169: new 130	com/tencent/mm/plugin/choosemsgfile/logic/b/c
        //   172: dup
        //   173: aload_0
        //   174: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   177: getfield 104	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:wQA	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/c;
        //   180: aload 9
        //   182: invokevirtual 116	com/tencent/mm/storage/cc:getCreateTime	()J
        //   185: invokespecial 133	com/tencent/mm/plugin/choosemsgfile/logic/b/c:<init>	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/g;J)V
        //   188: invokevirtual 137	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   191: pop
        //   192: aload_0
        //   193: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   196: invokestatic 139	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:c	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;)I
        //   199: pop
        //   200: aload 7
        //   202: aload 10
        //   204: invokevirtual 137	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   207: pop
        //   208: lload 5
        //   210: lstore_3
        //   211: goto -143 -> 68
        //   214: aload 8
        //   216: invokeinterface 142 1 0
        //   221: new 44	java/util/LinkedList
        //   224: dup
        //   225: invokespecial 45	java/util/LinkedList:<init>	()V
        //   228: astore 9
        //   230: aload 7
        //   232: invokevirtual 146	java/util/LinkedList:size	()I
        //   235: aload_0
        //   236: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   239: getfield 149	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:wQD	I
        //   242: isub
        //   243: sipush 200
        //   246: if_icmpne +340 -> 586
        //   249: aload 7
        //   251: iconst_0
        //   252: invokevirtual 153	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   255: checkcast 155	com/tencent/mm/plugin/choosemsgfile/logic/b/a
        //   258: invokevirtual 158	com/tencent/mm/plugin/choosemsgfile/logic/b/a:getTimeStamp	()J
        //   261: lstore_3
        //   262: invokestatic 125	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   265: pop
        //   266: lload_3
        //   267: invokestatic 162	com/tencent/mm/ui/gridviewheaders/a:Aw	(J)J
        //   270: lstore 5
        //   272: ldc 72
        //   274: ldc 164
        //   276: iconst_3
        //   277: anewarray 4	java/lang/Object
        //   280: dup
        //   281: iconst_0
        //   282: aload 7
        //   284: invokevirtual 146	java/util/LinkedList:size	()I
        //   287: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   290: aastore
        //   291: dup
        //   292: iconst_1
        //   293: lload 5
        //   295: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   298: aastore
        //   299: dup
        //   300: iconst_2
        //   301: lload_3
        //   302: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   305: aastore
        //   306: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   309: ldc 47
        //   311: invokestatic 53	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
        //   314: checkcast 47	com/tencent/mm/plugin/messenger/foundation/a/n
        //   317: invokeinterface 57 1 0
        //   322: aload_0
        //   323: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   326: getfield 60	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:luk	Ljava/lang/String;
        //   329: lload 5
        //   331: lload_3
        //   332: invokeinterface 182 6 0
        //   337: astore 8
        //   339: new 112	java/util/Date
        //   342: dup
        //   343: lload_3
        //   344: invokespecial 119	java/util/Date:<init>	(J)V
        //   347: astore 10
        //   349: invokestatic 125	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   352: aload 10
        //   354: invokevirtual 128	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   357: lstore_3
        //   358: aload 8
        //   360: ifnull +214 -> 574
        //   363: aload 8
        //   365: invokeinterface 89 1 0
        //   370: ifeq +204 -> 574
        //   373: aload_0
        //   374: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   377: invokestatic 93	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:b	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;)I
        //   380: pop
        //   381: new 95	com/tencent/mm/storage/cc
        //   384: dup
        //   385: invokespecial 96	com/tencent/mm/storage/cc:<init>	()V
        //   388: astore 11
        //   390: aload 11
        //   392: aload 8
        //   394: invokevirtual 100	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
        //   397: aload_0
        //   398: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   401: getfield 104	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:wQA	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/c;
        //   404: aload 11
        //   406: aload_0
        //   407: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   410: getfield 60	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:luk	Ljava/lang/String;
        //   413: aload_0
        //   414: getfield 26	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:ezi	Ljava/lang/String;
        //   417: aload_0
        //   418: getfield 28	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQw	Ljava/lang/String;
        //   421: invokestatic 110	com/tencent/mm/plugin/choosemsgfile/logic/c/c:a	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/c;Lcom/tencent/mm/storage/cc;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/choosemsgfile/logic/b/a;
        //   424: astore 12
        //   426: aload 12
        //   428: ifnull +289 -> 717
        //   431: new 112	java/util/Date
        //   434: dup
        //   435: aload 11
        //   437: invokevirtual 116	com/tencent/mm/storage/cc:getCreateTime	()J
        //   440: invokespecial 119	java/util/Date:<init>	(J)V
        //   443: astore 13
        //   445: invokestatic 125	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   448: aload 13
        //   450: invokevirtual 128	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   453: lstore 5
        //   455: lload_3
        //   456: lload 5
        //   458: lcmp
        //   459: ifeq +81 -> 540
        //   462: invokestatic 125	com/tencent/mm/ui/gridviewheaders/a:jBw	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   465: aload 10
        //   467: invokevirtual 128	com/tencent/mm/ui/gridviewheaders/a:b	(Ljava/util/Date;)J
        //   470: lload 5
        //   472: lcmp
        //   473: ifeq +67 -> 540
        //   476: aload 9
        //   478: new 130	com/tencent/mm/plugin/choosemsgfile/logic/b/c
        //   481: dup
        //   482: aload_0
        //   483: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   486: getfield 104	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:wQA	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/c;
        //   489: aload 11
        //   491: invokevirtual 116	com/tencent/mm/storage/cc:getCreateTime	()J
        //   494: invokespecial 133	com/tencent/mm/plugin/choosemsgfile/logic/b/c:<init>	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/g;J)V
        //   497: invokevirtual 137	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   500: pop
        //   501: aload_0
        //   502: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   505: invokestatic 139	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:c	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;)I
        //   508: pop
        //   509: lload 5
        //   511: lstore_3
        //   512: aload 9
        //   514: aload 12
        //   516: invokevirtual 137	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   519: pop
        //   520: goto -162 -> 358
        //   523: astore 7
        //   525: aload 8
        //   527: invokeinterface 142 1 0
        //   532: ldc 36
        //   534: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   537: aload 7
        //   539: athrow
        //   540: aload 7
        //   542: invokevirtual 146	java/util/LinkedList:size	()I
        //   545: ifle +26 -> 571
        //   548: aload 9
        //   550: invokevirtual 146	java/util/LinkedList:size	()I
        //   553: ifne +18 -> 571
        //   556: aload 9
        //   558: iconst_0
        //   559: aload 7
        //   561: iconst_0
        //   562: invokevirtual 185	java/util/LinkedList:remove	(I)Ljava/lang/Object;
        //   565: checkcast 155	com/tencent/mm/plugin/choosemsgfile/logic/b/a
        //   568: invokevirtual 188	java/util/LinkedList:add	(ILjava/lang/Object;)V
        //   571: goto -59 -> 512
        //   574: aload 8
        //   576: ifnull +10 -> 586
        //   579: aload 8
        //   581: invokeinterface 142 1 0
        //   586: aload 7
        //   588: invokevirtual 146	java/util/LinkedList:size	()I
        //   591: istore_1
        //   592: aload 9
        //   594: invokevirtual 146	java/util/LinkedList:size	()I
        //   597: istore_2
        //   598: aload_0
        //   599: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   602: getfield 192	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:mDataList	Ljava/util/ArrayList;
        //   605: iconst_0
        //   606: aload 9
        //   608: invokevirtual 198	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
        //   611: pop
        //   612: aload_0
        //   613: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   616: getfield 192	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:mDataList	Ljava/util/ArrayList;
        //   619: aload 9
        //   621: invokevirtual 146	java/util/LinkedList:size	()I
        //   624: aload 7
        //   626: invokevirtual 198	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
        //   629: pop
        //   630: aload 7
        //   632: invokevirtual 201	java/util/LinkedList:clear	()V
        //   635: aload 9
        //   637: invokevirtual 201	java/util/LinkedList:clear	()V
        //   640: aload_0
        //   641: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   644: iconst_0
        //   645: putfield 149	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:wQD	I
        //   648: ldc 72
        //   650: ldc 203
        //   652: iconst_1
        //   653: anewarray 4	java/lang/Object
        //   656: dup
        //   657: iconst_0
        //   658: aload_0
        //   659: getfield 24	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4:wQE	Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f;
        //   662: getfield 192	com/tencent/mm/plugin/choosemsgfile/logic/ui/f:mDataList	Ljava/util/ArrayList;
        //   665: invokevirtual 204	java/util/ArrayList:size	()I
        //   668: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   671: aastore
        //   672: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   675: new 13	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4$1
        //   678: dup
        //   679: aload_0
        //   680: iload_1
        //   681: iload_2
        //   682: iadd
        //   683: invokespecial 207	com/tencent/mm/plugin/choosemsgfile/logic/ui/f$4$1:<init>	(Lcom/tencent/mm/plugin/choosemsgfile/logic/ui/f$4;I)V
        //   686: invokestatic 213	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   689: ldc 36
        //   691: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   694: return
        //   695: astore 7
        //   697: aload 8
        //   699: ifnull +10 -> 709
        //   702: aload 8
        //   704: invokeinterface 142 1 0
        //   709: ldc 36
        //   711: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   714: aload 7
        //   716: athrow
        //   717: goto -197 -> 520
        //   720: goto -509 -> 211
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	723	0	this	4
        //   591	92	1	i	int
        //   597	86	2	j	int
        //   67	445	3	l1	long
        //   158	352	5	l2	long
        //   12	271	7	localLinkedList	java.util.LinkedList
        //   523	108	7	localCollection	java.util.Collection
        //   695	20	7	localObject1	Object
        //   46	657	8	localCursor	android.database.Cursor
        //   93	543	9	localObject2	Object
        //   129	337	10	localObject3	Object
        //   148	342	11	localObject4	Object
        //   424	91	12	locala	com.tencent.mm.plugin.choosemsgfile.logic.b.a
        //   443	6	13	localDate	java.util.Date
        // Exception table:
        //   from	to	target	type
        //   68	131	523	finally
        //   136	160	523	finally
        //   167	200	523	finally
        //   200	208	523	finally
        //   363	426	695	finally
        //   431	455	695	finally
        //   462	509	695	finally
        //   512	520	695	finally
        //   540	571	695	finally
      }
    });
    AppMethodBeat.o(123346);
  }
  
  public final RecyclerView.a dqG()
  {
    AppMethodBeat.i(262585);
    this.wQA = new c(this.wQl, this.mDataList);
    this.wQA.wQn = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.logic.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(262586);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(262586);
          return;
        }
        Log.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.dqu();
          f.a(f.this).kA(paramAnonymousa.wPy.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.logic.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.logic.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123328);
              Log.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              f.a(f.this).kB(paramAnonymousa.wPy.field_msgId);
              f.a(f.this).a(paramAnonymousa.wPy.field_msgId, paramAnonymous2MsgFile);
              if (f.a(f.this).dqH()) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123327);
                    f.this.wQA.bZE.notifyChanged();
                    AppMethodBeat.o(123327);
                  }
                });
              }
              f.this.wQl.dqK();
              paramAnonymousa.dqv();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((m)paramAnonymousv).coverIv.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123328);
            }
            
            public final void dqj()
            {
              AppMethodBeat.i(123329);
              Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              f.a(f.this).kB(paramAnonymousa.wPy.field_msgId);
              paramAnonymousa.dqx();
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((m)paramAnonymousv).coverIv.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123329);
            }
            
            public final void dqk()
            {
              AppMethodBeat.i(123330);
              Log.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              f.a(f.this).kB(paramAnonymousa.wPy.field_msgId);
              paramAnonymousa.dqy();
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((m)paramAnonymousv).coverIv.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123330);
            }
            
            public final void dql()
            {
              AppMethodBeat.i(123331);
              Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              f.a(f.this).kB(paramAnonymousa.wPy.field_msgId);
              paramAnonymousa.dqw();
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((m)paramAnonymousv).coverIv.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123331);
            }
            
            public final void gz(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123332);
              Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.gB(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((m)paramAnonymousv).coverIv.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123332);
            }
          }, f.this.dqF());
        }
        for (;;)
        {
          paramAnonymousa.Q(paramAnonymousv);
          AppMethodBeat.o(262586);
          return;
          paramAnonymousa.dqy();
          f.a(f.this).kB(paramAnonymousa.wPy.field_msgId);
          f.a(f.this).ky(paramAnonymousa.wPy.field_msgId);
          if (f.a(f.this).dqH()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123333);
                f.this.wQA.bZE.notifyChanged();
                AppMethodBeat.o(123333);
              }
            });
          }
          f.this.wQl.dqK();
        }
      }
    };
    c localc = this.wQA;
    AppMethodBeat.o(262585);
    return localc;
  }
  
  public final <T extends RecyclerView.LayoutManager> T fT(Context paramContext)
  {
    AppMethodBeat.i(262587);
    if (this.wQC == null)
    {
      this.wQC = new GridLayoutManager(4);
      this.wQC.bWq = new GridLayoutManager.b()
      {
        public final int fJ(int paramAnonymousInt)
        {
          AppMethodBeat.i(123335);
          if (((com.tencent.mm.plugin.choosemsgfile.logic.b.a)f.this.mDataList.get(paramAnonymousInt)).getType() == 0)
          {
            AppMethodBeat.o(123335);
            return 4;
          }
          AppMethodBeat.o(123335);
          return 1;
        }
      };
    }
    paramContext = this.wQC;
    AppMethodBeat.o(262587);
    return paramContext;
  }
  
  public final void gp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123340);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
    this.wQB.alive();
    c(true, paramString1, paramString2);
    AppMethodBeat.o(123340);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123343);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
    this.wQB.dead();
    AppMethodBeat.o(123343);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(123342);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123342);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(123341);
    Log.i("MicroMsg.ChooseMsgFileUIController", "onResume");
    this.wQA.bZE.notifyChanged();
    AppMethodBeat.o(123341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.ui.f
 * JD-Core Version:    0.7.0.1
 */