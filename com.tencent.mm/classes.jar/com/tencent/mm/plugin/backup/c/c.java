package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.g.l.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class c
{
  public boolean mSW = false;
  b.b mSX;
  com.tencent.mm.plugin.backup.b.d mSY;
  long mSZ = 0L;
  private int mSg;
  public long mTa = 0L;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.mSY = paramd;
    this.mSg = paramInt;
    this.mSX = paramb;
    this.mSW = false;
  }
  
  public final void a(final LinkedList<f.a> paramLinkedList, final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21254);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ac.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      paramLinkedList = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "backupPackThread";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21232);
          if (paramLinkedList == null)
          {
            ac.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
            if (c.this.mSX != null)
            {
              c.this.mSX.bCM();
              c.this.mSY.bCP().mSk = -21;
              c.this.mSX.wJ(-21);
            }
            AppMethodBeat.o(21232);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bEu();
          Object localObject2 = paramLinkedList;
          Object localObject1 = new HashSet();
          if (localObject2 == null) {}
          for (int i = 0;; i = ((HashSet)localObject1).size())
          {
            c.this.mSY.bCP().P(14, 1, i);
            c.this.mSX.wJ(14);
            localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bEP().bEQ().agA().get(2, null);
            c.this.mTa = bs.eWj();
            localObject2 = new c.c(c.this);
            Iterator localIterator = paramLinkedList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              f.a locala = (f.a)localIterator.next();
              c.this.a(locala, (c.c)localObject2, (String)localObject1, paramLong, this.mTd);
            } while (!c.this.mSW);
            if (!c.this.mSW) {
              break;
            }
            ac.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            AppMethodBeat.o(21232);
            return;
            localObject2 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).mSx);
            }
          }
          long l1 = bs.eWj();
          long l2 = bs.eWj();
          ((c.c)localObject2).mTD.offer(((c.c)localObject2).mTE);
          ((c.c)localObject2).mTE.block();
          ac.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(bs.Ap(l2)) });
          Assert.assertTrue(((c.c)localObject2).mTD.isEmpty());
          ac.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(bs.Ap(c.this.mTa)), Long.valueOf(bs.Ap(l1)) });
          c.this.bDi();
          c.this.mSY.bCP().P(15, i, i);
          c.this.mSX.wJ(15);
          c.this.iq(true);
          com.tencent.mm.plugin.backup.g.b.bEt();
          com.tencent.mm.plugin.backup.g.b.bEv();
          c.this.mSX.bCL();
          ac.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(c.this.mSZ), Long.valueOf(bs.Ap(c.this.mTa)), Long.valueOf(c.this.mTa) });
          AppMethodBeat.o(21232);
        }
      };
      com.tencent.e.h.JZN.aV(paramLinkedList);
      AppMethodBeat.o(21254);
      return;
    }
  }
  
  /* Error */
  final boolean a(f.a parama, c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 21255
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 129	com/tencent/mm/plugin/backup/h/d:bEP	()Lcom/tencent/mm/plugin/backup/h/d;
    //   9: invokevirtual 133	com/tencent/mm/plugin/backup/h/d:bEQ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   12: invokevirtual 139	com/tencent/mm/plugin/backup/h/b:awG	()Lcom/tencent/mm/storage/bk;
    //   15: aload_1
    //   16: getfield 145	com/tencent/mm/plugin/backup/b/f$a:mSx	Ljava/lang/String;
    //   19: invokeinterface 151 2 0
    //   24: astore 26
    //   26: aload 26
    //   28: ifnull +180 -> 208
    //   31: aload 26
    //   33: getfield 156	com/tencent/mm/g/c/az:field_unReadCount	I
    //   36: istore 7
    //   38: ldc 71
    //   40: ldc 158
    //   42: iconst_5
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: getfield 161	com/tencent/mm/plugin/backup/b/f$a:mSy	I
    //   52: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_1
    //   59: getfield 145	com/tencent/mm/plugin/backup/b/f$a:mSx	Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: aload_1
    //   66: getfield 164	com/tencent/mm/plugin/backup/b/f$a:startTime	J
    //   69: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   72: aastore
    //   73: dup
    //   74: iconst_3
    //   75: aload_1
    //   76: getfield 167	com/tencent/mm/plugin/backup/b/f$a:endTime	J
    //   79: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   82: aastore
    //   83: dup
    //   84: iconst_4
    //   85: iload 7
    //   87: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   97: lstore 19
    //   99: iconst_0
    //   100: istore 9
    //   102: lconst_0
    //   103: lstore 11
    //   105: lconst_0
    //   106: lstore 13
    //   108: lconst_0
    //   109: lstore 15
    //   111: iload 7
    //   113: istore 8
    //   115: iload 9
    //   117: istore 7
    //   119: new 114	java/util/LinkedList
    //   122: dup
    //   123: invokespecial 174	java/util/LinkedList:<init>	()V
    //   126: astore 28
    //   128: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   131: lstore 17
    //   133: invokestatic 129	com/tencent/mm/plugin/backup/h/d:bEP	()Lcom/tencent/mm/plugin/backup/h/d;
    //   136: invokevirtual 133	com/tencent/mm/plugin/backup/h/d:bEQ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   139: invokevirtual 178	com/tencent/mm/plugin/backup/h/b:awD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   142: aload_1
    //   143: getfield 145	com/tencent/mm/plugin/backup/b/f$a:mSx	Ljava/lang/String;
    //   146: aload_1
    //   147: getfield 164	com/tencent/mm/plugin/backup/b/f$a:startTime	J
    //   150: aload_1
    //   151: getfield 167	com/tencent/mm/plugin/backup/b/f$a:endTime	J
    //   154: iload 7
    //   156: invokeinterface 183 7 0
    //   161: astore 26
    //   163: aload 26
    //   165: invokeinterface 189 1 0
    //   170: ifeq +93 -> 263
    //   173: iload 7
    //   175: iconst_1
    //   176: iadd
    //   177: istore 9
    //   179: aload_0
    //   180: getfield 51	com/tencent/mm/plugin/backup/c/c:mSW	Z
    //   183: ifeq +31 -> 214
    //   186: ldc 71
    //   188: ldc 191
    //   190: invokestatic 195	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 26
    //   195: invokeinterface 198 1 0
    //   200: sipush 21255
    //   203: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    //   208: iconst_0
    //   209: istore 7
    //   211: goto -173 -> 38
    //   214: new 200	com/tencent/mm/storage/bo
    //   217: dup
    //   218: invokespecial 201	com/tencent/mm/storage/bo:<init>	()V
    //   221: astore 27
    //   223: aload 27
    //   225: aload 26
    //   227: invokevirtual 205	com/tencent/mm/storage/bo:convertFrom	(Landroid/database/Cursor;)V
    //   230: iload 6
    //   232: ifeq +16 -> 248
    //   235: iload 9
    //   237: istore 7
    //   239: aload 27
    //   241: invokevirtual 208	com/tencent/mm/storage/bo:getType	()I
    //   244: iconst_1
    //   245: if_icmpne -82 -> 163
    //   248: aload 28
    //   250: aload 27
    //   252: invokevirtual 212	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: iload 9
    //   258: istore 7
    //   260: goto -97 -> 163
    //   263: aload 26
    //   265: invokeinterface 198 1 0
    //   270: lload 15
    //   272: lload 17
    //   274: lsub
    //   275: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   278: ladd
    //   279: lstore 17
    //   281: aload 28
    //   283: invokevirtual 118	java/util/LinkedList:size	()I
    //   286: ifeq +418 -> 704
    //   289: iconst_0
    //   290: istore 9
    //   292: iload 9
    //   294: aload 28
    //   296: invokevirtual 118	java/util/LinkedList:size	()I
    //   299: if_icmpge +398 -> 697
    //   302: aload_0
    //   303: getfield 51	com/tencent/mm/plugin/backup/c/c:mSW	Z
    //   306: ifeq +18 -> 324
    //   309: ldc 71
    //   311: ldc 214
    //   313: invokestatic 195	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: sipush 21255
    //   319: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_0
    //   323: ireturn
    //   324: aload 28
    //   326: iload 9
    //   328: invokevirtual 218	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   331: checkcast 200	com/tencent/mm/storage/bo
    //   334: astore 31
    //   336: new 220	com/tencent/mm/pointers/PLong
    //   339: dup
    //   340: invokespecial 221	com/tencent/mm/pointers/PLong:<init>	()V
    //   343: astore 32
    //   345: new 114	java/util/LinkedList
    //   348: dup
    //   349: invokespecial 174	java/util/LinkedList:<init>	()V
    //   352: astore 29
    //   354: new 223	java/util/HashMap
    //   357: dup
    //   358: invokespecial 224	java/util/HashMap:<init>	()V
    //   361: astore 30
    //   363: lload 13
    //   365: lstore 15
    //   367: lload 13
    //   369: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   372: lsub
    //   373: lstore 13
    //   375: iload 8
    //   377: ifle +282 -> 659
    //   380: iconst_1
    //   381: istore 25
    //   383: lload 13
    //   385: lstore 15
    //   387: aload 31
    //   389: iconst_0
    //   390: aload_3
    //   391: aload 32
    //   393: aload 29
    //   395: aload 30
    //   397: iload 25
    //   399: iconst_0
    //   400: lload 4
    //   402: invokestatic 229	com/tencent/mm/plugin/backup/f/h:a	(Lcom/tencent/mm/storage/bo;ZLjava/lang/String;Lcom/tencent/mm/pointers/PLong;Ljava/util/LinkedList;Ljava/util/HashMap;ZZJ)Lcom/tencent/mm/protocal/protobuf/hy;
    //   405: astore 26
    //   407: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   410: lstore 15
    //   412: lload 15
    //   414: lload 13
    //   416: ladd
    //   417: lstore 13
    //   419: aload 26
    //   421: ifnonnull +270 -> 691
    //   424: iconst_1
    //   425: istore 25
    //   427: ldc 71
    //   429: ldc 231
    //   431: bipush 8
    //   433: anewarray 4	java/lang/Object
    //   436: dup
    //   437: iconst_0
    //   438: iload 25
    //   440: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   443: aastore
    //   444: dup
    //   445: iconst_1
    //   446: aload 29
    //   448: invokevirtual 118	java/util/LinkedList:size	()I
    //   451: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: aastore
    //   455: dup
    //   456: iconst_2
    //   457: aload 32
    //   459: getfield 234	com/tencent/mm/pointers/PLong:value	J
    //   462: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   465: aastore
    //   466: dup
    //   467: iconst_3
    //   468: aload 30
    //   470: invokevirtual 235	java/util/HashMap:size	()I
    //   473: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: dup
    //   478: iconst_4
    //   479: aload 31
    //   481: getfield 240	com/tencent/mm/g/c/dy:field_msgSvrId	J
    //   484: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   487: aastore
    //   488: dup
    //   489: iconst_5
    //   490: aload 31
    //   492: invokevirtual 208	com/tencent/mm/storage/bo:getType	()I
    //   495: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: dup
    //   500: bipush 6
    //   502: aload 31
    //   504: getfield 243	com/tencent/mm/g/c/dy:field_createTime	J
    //   507: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   510: aastore
    //   511: dup
    //   512: bipush 7
    //   514: aload 31
    //   516: getfield 246	com/tencent/mm/g/c/dy:field_talker	Ljava/lang/String;
    //   519: aastore
    //   520: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   523: lload 11
    //   525: lstore 15
    //   527: iload 8
    //   529: istore 10
    //   531: aload 26
    //   533: ifnull +109 -> 642
    //   536: iload 8
    //   538: iconst_1
    //   539: isub
    //   540: istore 10
    //   542: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   545: lstore 15
    //   547: aload 32
    //   549: getfield 234	com/tencent/mm/pointers/PLong:value	J
    //   552: lstore 21
    //   554: aload 31
    //   556: getfield 243	com/tencent/mm/g/c/dy:field_createTime	J
    //   559: lstore 23
    //   561: aload_2
    //   562: getfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   565: ifnonnull +41 -> 606
    //   568: aload_2
    //   569: getfield 254	com/tencent/mm/plugin/backup/c/c$c:mTD	Ljava/util/concurrent/LinkedBlockingQueue;
    //   572: astore 27
    //   574: new 11	com/tencent/mm/plugin/backup/c/c$b
    //   577: dup
    //   578: aload_2
    //   579: getfield 258	com/tencent/mm/plugin/backup/c/c$c:mTe	Lcom/tencent/mm/plugin/backup/c/c;
    //   582: aload_2
    //   583: getfield 262	com/tencent/mm/plugin/backup/c/c$c:mTj	Lcom/tencent/mm/plugin/backup/c/c$a;
    //   586: aload_1
    //   587: invokespecial 265	com/tencent/mm/plugin/backup/c/c$b:<init>	(Lcom/tencent/mm/plugin/backup/c/c;Lcom/tencent/mm/plugin/backup/c/c$a;Lcom/tencent/mm/plugin/backup/b/f$a;)V
    //   590: astore 31
    //   592: aload_2
    //   593: aload 31
    //   595: putfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   598: aload 27
    //   600: aload 31
    //   602: invokevirtual 270	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   605: pop
    //   606: aload_2
    //   607: getfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   610: aload 26
    //   612: lload 21
    //   614: lload 23
    //   616: aload 29
    //   618: aload 30
    //   620: invokevirtual 273	com/tencent/mm/plugin/backup/c/c$b:a	(Lcom/tencent/mm/protocal/protobuf/hy;JJLjava/util/LinkedList;Ljava/util/HashMap;)Z
    //   623: ifeq +8 -> 631
    //   626: aload_2
    //   627: aconst_null
    //   628: putfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   631: lload 11
    //   633: lload 15
    //   635: lsub
    //   636: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   639: ladd
    //   640: lstore 15
    //   642: iload 9
    //   644: iconst_1
    //   645: iadd
    //   646: istore 9
    //   648: lload 15
    //   650: lstore 11
    //   652: iload 10
    //   654: istore 8
    //   656: goto -364 -> 292
    //   659: iconst_0
    //   660: istore 25
    //   662: goto -279 -> 383
    //   665: astore 27
    //   667: aconst_null
    //   668: astore 26
    //   670: lload 15
    //   672: lstore 13
    //   674: ldc 71
    //   676: aload 27
    //   678: ldc_w 275
    //   681: iconst_0
    //   682: anewarray 4	java/lang/Object
    //   685: invokestatic 279	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: goto -269 -> 419
    //   691: iconst_0
    //   692: istore 25
    //   694: goto -267 -> 427
    //   697: lload 17
    //   699: lstore 15
    //   701: goto -582 -> 119
    //   704: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   707: lstore 4
    //   709: aload_2
    //   710: getfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   713: ifnonnull +39 -> 752
    //   716: aload_2
    //   717: getfield 254	com/tencent/mm/plugin/backup/c/c$c:mTD	Ljava/util/concurrent/LinkedBlockingQueue;
    //   720: astore_3
    //   721: new 11	com/tencent/mm/plugin/backup/c/c$b
    //   724: dup
    //   725: aload_2
    //   726: getfield 258	com/tencent/mm/plugin/backup/c/c$c:mTe	Lcom/tencent/mm/plugin/backup/c/c;
    //   729: aload_2
    //   730: getfield 262	com/tencent/mm/plugin/backup/c/c$c:mTj	Lcom/tencent/mm/plugin/backup/c/c$a;
    //   733: aload_1
    //   734: invokespecial 265	com/tencent/mm/plugin/backup/c/c$b:<init>	(Lcom/tencent/mm/plugin/backup/c/c;Lcom/tencent/mm/plugin/backup/c/c$a;Lcom/tencent/mm/plugin/backup/b/f$a;)V
    //   737: astore 26
    //   739: aload_2
    //   740: aload 26
    //   742: putfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   745: aload_3
    //   746: aload 26
    //   748: invokevirtual 270	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   751: pop
    //   752: aload_2
    //   753: getfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   756: invokevirtual 282	com/tencent/mm/plugin/backup/c/c$b:bDj	()V
    //   759: aload_2
    //   760: aconst_null
    //   761: putfield 250	com/tencent/mm/plugin/backup/c/c$c:mTF	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   764: invokestatic 173	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   767: lstore 15
    //   769: ldc 71
    //   771: ldc_w 284
    //   774: bipush 7
    //   776: anewarray 4	java/lang/Object
    //   779: dup
    //   780: iconst_0
    //   781: aload_1
    //   782: getfield 161	com/tencent/mm/plugin/backup/b/f$a:mSy	I
    //   785: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aastore
    //   789: dup
    //   790: iconst_1
    //   791: aload_1
    //   792: getfield 145	com/tencent/mm/plugin/backup/b/f$a:mSx	Ljava/lang/String;
    //   795: aastore
    //   796: dup
    //   797: iconst_2
    //   798: iload 7
    //   800: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   803: aastore
    //   804: dup
    //   805: iconst_3
    //   806: lload 19
    //   808: invokestatic 288	com/tencent/mm/sdk/platformtools/bs:Ap	(J)J
    //   811: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   814: aastore
    //   815: dup
    //   816: iconst_4
    //   817: lload 17
    //   819: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   822: aastore
    //   823: dup
    //   824: iconst_5
    //   825: lload 13
    //   827: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   830: aastore
    //   831: dup
    //   832: bipush 6
    //   834: lload 11
    //   836: lload 4
    //   838: lsub
    //   839: lload 15
    //   841: ladd
    //   842: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   845: aastore
    //   846: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   849: sipush 21255
    //   852: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   855: iconst_1
    //   856: ireturn
    //   857: astore 27
    //   859: goto -185 -> 674
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	this	c
    //   0	862	1	parama	f.a
    //   0	862	2	paramc	c
    //   0	862	3	paramString	String
    //   0	862	4	paramLong	long
    //   0	862	6	paramBoolean	boolean
    //   36	763	7	i	int
    //   113	542	8	j	int
    //   100	547	9	k	int
    //   529	124	10	m	int
    //   103	732	11	l1	long
    //   106	720	13	l2	long
    //   109	731	15	l3	long
    //   131	687	17	l4	long
    //   97	710	19	l5	long
    //   552	61	21	l6	long
    //   559	56	23	l7	long
    //   381	312	25	bool	boolean
    //   24	723	26	localObject1	Object
    //   221	378	27	localObject2	Object
    //   665	12	27	localException1	Exception
    //   857	1	27	localException2	Exception
    //   126	199	28	localLinkedList1	LinkedList
    //   352	265	29	localLinkedList2	LinkedList
    //   361	258	30	localHashMap	HashMap
    //   334	267	31	localObject3	Object
    //   343	205	32	localPLong	com.tencent.mm.pointers.PLong
    // Exception table:
    //   from	to	target	type
    //   367	375	665	java/lang/Exception
    //   387	407	665	java/lang/Exception
    //   407	412	857	java/lang/Exception
  }
  
  public final long bDh()
  {
    return this.mSZ / 1024L;
  }
  
  public final void bDi()
  {
    AppMethodBeat.i(21253);
    ac.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.mSY.mSc;
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(locald.toByteArray(), 8);
      AppMethodBeat.o(21253);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21253);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21251);
    ac.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { as.eVo() });
    this.mSW = true;
    AppMethodBeat.o(21251);
  }
  
  public final void iq(boolean paramBoolean)
  {
    AppMethodBeat.i(21252);
    ac.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.mSg == 1)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKK, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.bCU().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.mSg != 1) {
          break label155;
        }
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
    for (;;)
    {
      localEditor.commit();
      AppMethodBeat.o(21252);
      return;
      if (this.mSg != 2) {
        break;
      }
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKN, Boolean.FALSE);
      break;
      label155:
      if (this.mSg == 2)
      {
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
  }
  
  final class a
  {
    volatile AtomicLong mTf;
    al mTg;
    al mTh;
    
    private a()
    {
      AppMethodBeat.i(21233);
      this.mTf = new AtomicLong(0L);
      this.mTg = new al(true);
      this.mTh = new al(true);
      AppMethodBeat.o(21233);
    }
  }
  
  final class b
  {
    String TAG;
    String bLs;
    boolean jHx;
    long mSA;
    long mSB;
    int mSy;
    LinkedBlockingQueue<Runnable> mTi;
    c.a mTj;
    private long mTk;
    String mTl;
    Vector<String> mTm;
    private Vector<hy> mTn;
    HashMap<Long, h.a> mTo;
    long mTp;
    private final com.tencent.mm.plugin.backup.g.c.b mTq;
    private final Runnable mTr;
    final Runnable mTs;
    String talker;
    
    public b(c.a parama, f.a parama1)
    {
      AppMethodBeat.i(21245);
      this.TAG = "";
      this.mTi = new LinkedBlockingQueue();
      this.mSA = 0L;
      this.mSB = 0L;
      this.mTk = 0L;
      this.mTl = "";
      this.mTm = new Vector();
      this.mTn = new Vector();
      this.mTo = new HashMap();
      this.mTp = 0L;
      this.jHx = false;
      this.mTq = new com.tencent.mm.plugin.backup.g.c.b()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(21234);
          c.a locala = c.b.this.mTj;
          long l1 = paramAnonymousInt;
          locala.mTf.addAndGet(0L - l1);
          if (locala.mTf.get() < 8388608L) {
            locala.mTg.open();
          }
          if (locala.mTf.get() < 16777216L) {
            locala.mTh.open();
          }
          long l2 = locala.mTf.get();
          boolean bool1;
          if (locala.mTf.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.mTf.get() < 16777216L) {
              break label266;
            }
          }
          label266:
          for (boolean bool2 = true;; bool2 = false)
          {
            ac.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(locala.mTg.GrQ), Boolean.valueOf(locala.mTh.GrQ) });
            c.this.mSZ += paramAnonymousInt;
            ac.i(c.b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
            AppMethodBeat.o(21234);
            return;
            bool1 = false;
            break;
          }
        }
      };
      this.mTr = new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(21241);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.jHx);
          ac.i(c.b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(c.b.this.mTo.size()), Long.valueOf(bs.Ap(c.b.this.mTp)), as.eVo() });
          if (!c.b.this.mTo.isEmpty()) {}
          for (;;)
          {
            Assert.assertTrue("BigFileMap should not Empty", bool);
            l.a local1 = new l.a()
            {
              public final void E(final LinkedList<Long> paramAnonymous2LinkedList)
              {
                AppMethodBeat.i(21239);
                com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
                {
                  public final String getKey()
                  {
                    return "AddBigFileToQueue";
                  }
                  
                  public final void run()
                  {
                    AppMethodBeat.i(21238);
                    int i = 0;
                    if ((paramAnonymous2LinkedList != null) && (i < paramAnonymous2LinkedList.size()))
                    {
                      Long localLong = (Long)paramAnonymous2LinkedList.get(i);
                      h.a locala = (h.a)c.b.this.mTo.get(localLong);
                      String str3 = c.b.this.TAG;
                      int j = paramAnonymous2LinkedList.size();
                      String str1;
                      if (locala == null)
                      {
                        str1 = "null";
                        label93:
                        if (locala != null) {
                          break label220;
                        }
                      }
                      label220:
                      for (String str2 = "null";; str2 = locala.mWT.path)
                      {
                        ac.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
                        if (locala != null)
                        {
                          c.b.this.mTm.add(locala.mWT.mediaId);
                          c.b.this.l(locala.mWT.mediaId, locala.mWT.path, true);
                        }
                        i += 1;
                        break;
                        str1 = locala.mWT.mediaId;
                        break label93;
                      }
                    }
                    c.b.this.mTi.offer(c.b.this.mTs);
                    AppMethodBeat.o(21238);
                  }
                });
                AppMethodBeat.o(21239);
              }
            };
            new l(c.b.this.talker, c.b.this.mTo, local1).bEA();
            AppMethodBeat.o(21241);
            return;
            bool = false;
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(21240);
          String str = c.b.this.TAG + ".reqBigFile";
          AppMethodBeat.o(21240);
          return str;
        }
      };
      this.mTs = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21244);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.jHx);
          final boolean bool1;
          switch (com.tencent.mm.plugin.backup.b.d.bCS())
          {
          default: 
            if (c.b.this.mSy == c.this.mSY.bCP().mSm - 1)
            {
              bool1 = true;
              label106:
              if (bool1) {
                break label767;
              }
            }
            break;
          }
          label767:
          for (boolean bool2 = true;; bool2 = false)
          {
            Object localObject = new al(bool2);
            g local1 = new g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(21242);
                paramAnonymous2n = ((aa)((com.tencent.mm.plugin.backup.g.d)paramAnonymous2n).mYT).ndV;
                ac.i(c.b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(bool1), this.mTB, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.b.this.mTl, paramAnonymous2n });
                if ((bool1) && (c.b.this.mTl.equals(paramAnonymous2n))) {
                  this.mTB.open();
                }
                AppMethodBeat.o(21242);
              }
            };
            new com.tencent.mm.plugin.backup.g.d(c.b.this.talker, c.b.this.mSA, c.b.this.mSB, c.b.this.mTl, c.b.this.bLs, new LinkedList(c.b.this.mTm), local1).bEA();
            if (bool1)
            {
              ac.w(c.b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(c.b.this.mSy), Integer.valueOf(c.this.mSY.bCP().mSm - 1) });
              ((al)localObject).block();
            }
            c.b.this.jHx = false;
            AppMethodBeat.o(21244);
            return;
            ac.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.mSY.bCP().mSl), Long.valueOf(c.b.this.mSA), Long.valueOf(c.b.this.mSB), Integer.valueOf(c.b.this.mTm.size()), c.b.this.bLs, c.b.this.mTl, Long.valueOf(bs.Ap(c.b.this.mTp)) });
            if (c.this.mSY.bCP().mSl >= c.b.this.mSy + 1) {
              break;
            }
            int i = c.this.mSY.bCP().mSm;
            localObject = c.this.mSY.bCP();
            if (c.b.this.mSy + 1 > i) {}
            for (;;)
            {
              ((e)localObject).mSl = i;
              c.this.mSX.wJ(c.this.mSY.bCP().mSk);
              break;
              i = c.b.this.mSy + 1;
            }
            ac.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.mSY.bCP().mSl), Long.valueOf(c.b.this.mSA), Long.valueOf(c.b.this.mSB), Integer.valueOf(c.b.this.mTm.size()), c.b.this.bLs, c.b.this.mTl, Long.valueOf(bs.Ap(c.b.this.mTp)) });
            if (c.this.mSY.bCP().mSl >= c.b.this.mSy + 1) {
              break;
            }
            i = c.this.mSY.bCP().mSm;
            localObject = c.this.mSY.bCP();
            if (c.b.this.mSy + 1 > i) {}
            for (;;)
            {
              ((e)localObject).mSl = i;
              c.this.mSX.wJ(c.this.mSY.bCP().mSk);
              break;
              i = c.b.this.mSy + 1;
            }
            bool1 = false;
            break label106;
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(21243);
          String str = c.b.this.TAG + ".sendTag";
          AppMethodBeat.o(21243);
          return str;
        }
      };
      this.mTp = bs.eWj();
      this.mTj = parama;
      this.talker = parama1.mSx;
      this.mSy = parama1.mSy;
      if (w.sQ(this.talker))
      {
        this$1 = v.getDisplayName(this.talker, this.talker);
        this.bLs = c.this;
        parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
        if (!this.jHx) {
          break label299;
        }
      }
      label299:
      for (this$1 = "S.";; this$1 = "W.")
      {
        this.TAG = (c.this + this.mSy + "." + this.bLs);
        ac.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.mSy), this.bLs, this.talker, as.eVo() });
        AppMethodBeat.o(21245);
        return;
        this$1 = v.wk(this.talker);
        break;
      }
    }
    
    public final boolean a(hy paramhy, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
    {
      AppMethodBeat.i(21246);
      this.mTn.add(paramhy);
      long l2 = this.mTk;
      if (paramLong1 > 0L) {}
      for (long l1 = paramLong1;; l1 = 0L)
      {
        this.mTk = (l1 + l2);
        if (this.mSA == 0L) {
          this.mSA = paramLong2;
        }
        this.mSB = paramLong2;
        this.mTo.putAll(paramHashMap);
        paramhy = paramLinkedList.iterator();
        while (paramhy.hasNext())
        {
          paramHashMap = (u)paramhy.next();
          l(paramHashMap.mediaId, paramHashMap.path, false);
        }
      }
      ac.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.mSA), Long.valueOf(this.mSB), Long.valueOf(paramLong1), Long.valueOf(this.mTk), Integer.valueOf(this.mTn.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(bs.Ap(this.mTp)) });
      if ((this.mTk > 83886080L) || (this.mTn.size() > 80))
      {
        bDj();
        AppMethodBeat.o(21246);
        return true;
      }
      AppMethodBeat.o(21246);
      return false;
    }
    
    public final void bDj()
    {
      AppMethodBeat.i(21247);
      this.mTl = ("MSG_" + this.mTn.size() + "_" + this.talker + "_" + bs.eWj());
      ac.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.mSA), Long.valueOf(this.mSB), Long.valueOf(this.mTk), Integer.valueOf(this.mTn.size()), Integer.valueOf(this.mTo.size()), this.mTl, Long.valueOf(bs.Ap(this.mTp)) });
      if (this.mTn.size() > 0)
      {
        l(this.mTl, null, false);
        if (this.mTo.isEmpty())
        {
          this.mTi.offer(this.mTs);
          AppMethodBeat.o(21247);
          return;
        }
        this.mTi.offer(this.mTr);
        AppMethodBeat.o(21247);
        return;
      }
      ac.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.mTn.size()), Integer.valueOf(this.mTm.size()), Integer.valueOf(this.mTo.size()) });
      Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.mTn.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.mTm.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.mTo.isEmpty());
      this.mTi.offer(this.mTs);
      AppMethodBeat.o(21247);
    }
    
    final void l(String paramString1, String paramString2, boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(21248);
      com.tencent.mm.plugin.backup.g.c.c local2 = new com.tencent.mm.plugin.backup.g.c.c()
      {
        public final void a(final com.tencent.mm.plugin.backup.g.c paramAnonymousc)
        {
          AppMethodBeat.i(21237);
          final long l2 = bs.eWj();
          c.a locala = c.b.this.mTj;
          long l3 = paramAnonymousc.bEH();
          boolean bool3 = c.b.this.jHx;
          long l1 = locala.mTf.get();
          boolean bool1;
          label81:
          long l4;
          if (locala.mTf.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.mTf.get() < 16777216L) {
              break label379;
            }
            bool2 = true;
            ac.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (locala.mTf.get() + l3 >= 8388608L) {
              locala.mTg.close();
            }
            if (locala.mTf.get() >= 16777216L) {
              locala.mTh.close();
            }
            l4 = bs.eWj();
            if (!locala.mTe.mSW)
            {
              long l5 = locala.mTf.get();
              if (!bool3) {
                break label385;
              }
              l1 = 16777216L;
              label215:
              if (l5 >= l1) {
                break label404;
              }
              locala.mTf.addAndGet(l3);
              l1 = bs.Ap(l4);
              l4 = locala.mTf.get();
              if (locala.mTf.get() < 8388608L) {
                break label392;
              }
              bool1 = true;
              label267:
              if (locala.mTf.get() < 16777216L) {
                break label398;
              }
            }
          }
          label385:
          label392:
          label398:
          for (boolean bool2 = true;; bool2 = false)
          {
            ac.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            c.b.this.mTi.offer(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(21236);
                Assert.assertTrue(toString() + ", check running. ", c.b.this.jHx);
                long l1 = bs.eWj();
                paramAnonymousc.bEA();
                long l2 = bs.eWj();
                ac.i(c.b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(paramAnonymousc.bEH()), Long.valueOf(l2 - l2), Long.valueOf(l2 - l1), paramAnonymousc.mYK.ndM });
                AppMethodBeat.o(21236);
              }
              
              public final String toString()
              {
                AppMethodBeat.i(21235);
                String str = c.b.this.TAG + ".sendFile";
                AppMethodBeat.o(21235);
                return str;
              }
            });
            AppMethodBeat.o(21237);
            return;
            bool1 = false;
            break;
            label379:
            bool2 = false;
            break label81;
            l1 = 8388608L;
            break label215;
            bool1 = false;
            break label267;
          }
          label404:
          if (bool3) {}
          for (al localal = locala.mTh;; localal = locala.mTg)
          {
            localal.eVj();
            break;
          }
        }
      };
      ac.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mTn.size()), paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString2))
      {
        this.mTm.add(paramString1);
        if (paramString1 != null)
        {
          com.tencent.mm.plugin.backup.g.c.a(this.mTq, local2, paramString1, paramString2, c.this.mSY.mSi);
          AppMethodBeat.o(21248);
        }
      }
      else
      {
        if (this.mTn.isEmpty()) {
          break label171;
        }
      }
      label171:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assert.assertTrue("chatMsgList should not empty", paramBoolean);
        if (paramString1 != null) {
          com.tencent.mm.plugin.backup.g.c.a(this.mTq, local2, paramString1, new LinkedList(this.mTn), c.this.mSY.mSi);
        }
        AppMethodBeat.o(21248);
        return;
      }
    }
    
    public final String toString()
    {
      return this.TAG;
    }
  }
  
  final class c
  {
    LinkedBlockingQueue<Object> mTD;
    al mTE;
    c.b mTF;
    private Runnable mTG;
    c.a mTj;
    
    public c()
    {
      AppMethodBeat.i(21250);
      this.mTD = new LinkedBlockingQueue();
      this.mTj = new c.a(c.this, (byte)0);
      this.mTE = new al();
      this.mTF = null;
      this.mTG = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "tagRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21249);
          while (!c.this.mSW)
          {
            Object localObject1 = null;
            label273:
            try
            {
              localObject2 = c.c.this.mTD.poll(500L, TimeUnit.MILLISECONDS);
              localObject1 = localObject2;
            }
            catch (Exception localException2)
            {
              Object localObject2;
              label44:
              c.b localb;
              label146:
              label182:
              label221:
              break label44;
            }
            ac.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(c.c.this.mTD.size()), localObject1 });
            if (localObject1 != null)
            {
              if (localObject1 == c.c.this.mTE)
              {
                c.c.this.mTE.open();
                AppMethodBeat.o(21249);
                return;
              }
              localb = (c.b)localObject1;
              localb.jHx = true;
              localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
              if (localb.jHx)
              {
                localObject1 = "S.";
                localb.TAG = ((String)localObject1 + localb.mSy + "." + localb.bLs);
                while (!c.this.mSW)
                {
                  localObject1 = null;
                  try
                  {
                    localObject2 = (Runnable)localb.mTi.poll(500L, TimeUnit.MILLISECONDS);
                    localObject1 = localObject2;
                  }
                  catch (Exception localException1)
                  {
                    long l1;
                    int k;
                    long l2;
                    int i;
                    int j;
                    break label221;
                  }
                  if (localObject1 != null)
                  {
                    l1 = bs.eWj();
                    ((Runnable)localObject1).run();
                    k = localb.mTi.size();
                    l2 = c.c.this.mTj.mTf.get();
                    if (l2 < 8388608L) {
                      break label389;
                    }
                    i = 1;
                    if (l2 < 16777216L) {
                      break label394;
                    }
                  }
                }
              }
              label389:
              label394:
              for (j = 1;; j = 0)
              {
                ac.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(bs.Ap(l1)), localObject1, localb, c.c.this.mTF });
                if (localb.jHx) {
                  break label182;
                }
                System.gc();
                break;
                localObject1 = "W.";
                break label146;
                i = 0;
                break label273;
              }
            }
          }
          AppMethodBeat.o(21249);
        }
      };
      com.tencent.e.h.JZN.aV(this.mTG);
      AppMethodBeat.o(21250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */