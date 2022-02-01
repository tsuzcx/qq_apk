package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;

public class MessageForQQWalletMsg
  extends ChatMessage
{
  private static int QQWALLET_MSGTYPE_REDPACKET = 17;
  private static int QQWALLET_MSGTYPE_TRANSFER;
  private static int VERSION = 2;
  public QQWalletRedPacketMsg mQQWalletRedPacketMsg;
  public QQWalletTransferMsg mQQWalletTransferMsg;
  
  static
  {
    QQWALLET_MSGTYPE_TRANSFER = 1;
  }
  
  public MessageForQQWalletMsg() {}
  
  public MessageForQQWalletMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[QQWallet Msg]", paramLong4, -2025, paramInt, paramLong5);
  }
  
  public static boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (paramMessageRecord != null)
    {
      bool2 = bool3;
      if ((paramMessageRecord instanceof MessageForQQWalletMsg))
      {
        if (((MessageForQQWalletMsg)paramMessageRecord).mQQWalletRedPacketMsg != null) {
          bool1 = true;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("MessageForQQWaletMsg", 2, "isRedPacketMsg : " + bool1);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 68	java/io/ObjectInputStream
    //   3: dup
    //   4: new 70	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 74	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   12: invokespecial 77	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 80	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_3
    //   22: invokevirtual 84	java/io/ObjectInputStream:readInt	()I
    //   25: istore_1
    //   26: aload_3
    //   27: astore_2
    //   28: iload_1
    //   29: getstatic 16	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION	I
    //   32: if_icmpne +48 -> 80
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: invokevirtual 84	java/io/ObjectInputStream:readInt	()I
    //   41: getstatic 18	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_MSGTYPE_TRANSFER	I
    //   44: if_icmpne +27 -> 71
    //   47: aload_3
    //   48: astore_2
    //   49: aload_0
    //   50: new 86	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   53: dup
    //   54: invokespecial 87	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   57: putfield 89	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 89	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   66: iload_1
    //   67: aload_3
    //   68: invokevirtual 93	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(ILjava/io/ObjectInput;)V
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 96	java/io/ObjectInputStream:close	()V
    //   79: return
    //   80: aload_3
    //   81: astore_2
    //   82: iload_1
    //   83: getstatic 20	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_MSGTYPE_REDPACKET	I
    //   86: if_icmpne -15 -> 71
    //   89: aload_3
    //   90: astore_2
    //   91: aload_0
    //   92: new 98	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   95: dup
    //   96: invokespecial 99	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   99: putfield 35	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   102: aload_3
    //   103: astore_2
    //   104: aload_0
    //   105: getfield 35	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   108: aload_3
    //   109: invokevirtual 102	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   112: goto -41 -> 71
    //   115: astore 4
    //   117: aload_3
    //   118: astore_2
    //   119: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +15 -> 137
    //   125: aload_3
    //   126: astore_2
    //   127: ldc 104
    //   129: iconst_2
    //   130: ldc 106
    //   132: aload 4
    //   134: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload_3
    //   138: astore_2
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 89	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   144: aload_3
    //   145: astore_2
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 35	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   151: aload_3
    //   152: ifnull -73 -> 79
    //   155: aload_3
    //   156: invokevirtual 96	java/io/ObjectInputStream:close	()V
    //   159: return
    //   160: astore_2
    //   161: aload_2
    //   162: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   171: return
    //   172: astore_3
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 96	java/io/ObjectInputStream:close	()V
    //   183: aload_3
    //   184: athrow
    //   185: astore_2
    //   186: aload_2
    //   187: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   190: goto -7 -> 183
    //   193: astore_3
    //   194: goto -19 -> 175
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_3
    //   201: goto -84 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	MessageForQQWalletMsg
    //   25	62	1	i	int
    //   20	126	2	localObjectInputStream1	java.io.ObjectInputStream
    //   160	2	2	localException1	java.lang.Exception
    //   166	2	2	localException2	java.lang.Exception
    //   174	6	2	localObject1	java.lang.Object
    //   185	2	2	localException3	java.lang.Exception
    //   18	138	3	localObjectInputStream2	java.io.ObjectInputStream
    //   172	12	3	localObject2	java.lang.Object
    //   193	1	3	localObject3	java.lang.Object
    //   200	1	3	localObject4	java.lang.Object
    //   115	18	4	localException4	java.lang.Exception
    //   197	1	4	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	26	115	java/lang/Exception
    //   28	35	115	java/lang/Exception
    //   37	47	115	java/lang/Exception
    //   49	60	115	java/lang/Exception
    //   62	71	115	java/lang/Exception
    //   82	89	115	java/lang/Exception
    //   91	102	115	java/lang/Exception
    //   104	112	115	java/lang/Exception
    //   155	159	160	java/lang/Exception
    //   75	79	166	java/lang/Exception
    //   0	19	172	finally
    //   179	183	185	java/lang/Exception
    //   21	26	193	finally
    //   28	35	193	finally
    //   37	47	193	finally
    //   49	60	193	finally
    //   62	71	193	finally
    //   82	89	193	finally
    //   91	102	193	finally
    //   104	112	193	finally
    //   119	125	193	finally
    //   127	137	193	finally
    //   139	144	193	finally
    //   146	151	193	finally
    //   0	19	197	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getMsgSummary()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.notice;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.notice;
    }
    return "[QQ红包]";
  }
  
  public String getMsgTitle()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.title;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.title;
    }
    return "";
  }
  
  public String getNativeAndroid()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.nativeAndroid;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.nativeAndroid;
    }
    return "";
  }
  
  public boolean isMsgEmpty()
  {
    if ((this.mQQWalletTransferMsg == null) && (this.mQQWalletRedPacketMsg == null)) {}
    while (this.msgData == null) {
      return true;
    }
    return false;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 89	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   6: ifnull +200 -> 206
    //   9: new 149	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 150	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: new 152	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 155	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: getstatic 16	com/tencent/mobileqq/data/MessageForQQWalletMsg:VERSION	I
    //   34: invokevirtual 159	java/io/ObjectOutputStream:writeInt	(I)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: getstatic 18	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_MSGTYPE_TRANSFER	I
    //   43: invokevirtual 159	java/io/ObjectOutputStream:writeInt	(I)V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 89	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   52: aload_2
    //   53: invokevirtual 163	com/tencent/mobileqq/data/QQWalletTransferMsg:writeExternal	(Ljava/io/ObjectOutput;)V
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: aload 4
    //   67: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   70: putfield 74	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   81: aload 4
    //   83: ifnull +8 -> 91
    //   86: aload 4
    //   88: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   97: goto -16 -> 81
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   105: return
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +14 -> 128
    //   117: aload_2
    //   118: astore_1
    //   119: ldc 104
    //   121: iconst_2
    //   122: ldc 170
    //   124: aload_3
    //   125: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: astore_1
    //   130: aload_3
    //   131: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   142: aload 4
    //   144: ifnull -53 -> 91
    //   147: aload 4
    //   149: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   152: return
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   158: return
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   164: goto -22 -> 142
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   178: aload 4
    //   180: ifnull +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   195: goto -17 -> 178
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   203: goto -15 -> 188
    //   206: aload_0
    //   207: getfield 35	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   210: ifnull -119 -> 91
    //   213: new 149	java/io/ByteArrayOutputStream
    //   216: dup
    //   217: invokespecial 150	java/io/ByteArrayOutputStream:<init>	()V
    //   220: astore 4
    //   222: new 152	java/io/ObjectOutputStream
    //   225: dup
    //   226: aload 4
    //   228: invokespecial 155	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   231: astore_2
    //   232: aload_2
    //   233: getstatic 20	com/tencent/mobileqq/data/MessageForQQWalletMsg:QQWALLET_MSGTYPE_REDPACKET	I
    //   236: invokevirtual 159	java/io/ObjectOutputStream:writeInt	(I)V
    //   239: aload_0
    //   240: getfield 35	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   243: aload_2
    //   244: invokevirtual 171	com/tencent/mobileqq/data/QQWalletRedPacketMsg:writeExternal	(Ljava/io/ObjectOutput;)V
    //   247: aload_2
    //   248: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   251: aload_0
    //   252: aload 4
    //   254: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   257: putfield 74	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   260: aload_2
    //   261: ifnull +7 -> 268
    //   264: aload_2
    //   265: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   268: aload 4
    //   270: ifnull -179 -> 91
    //   273: aload 4
    //   275: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   278: return
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   284: return
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   290: goto -22 -> 268
    //   293: astore_2
    //   294: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +12 -> 309
    //   300: ldc 104
    //   302: iconst_2
    //   303: ldc 170
    //   305: aload_2
    //   306: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: aload_2
    //   310: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   321: aload 4
    //   323: ifnull -232 -> 91
    //   326: aload 4
    //   328: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   331: return
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   337: return
    //   338: astore_1
    //   339: aload_1
    //   340: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   343: goto -22 -> 321
    //   346: astore_1
    //   347: aconst_null
    //   348: astore_2
    //   349: aload_2
    //   350: ifnull +7 -> 357
    //   353: aload_2
    //   354: invokevirtual 164	java/io/ObjectOutputStream:close	()V
    //   357: aload 4
    //   359: ifnull +8 -> 367
    //   362: aload 4
    //   364: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   367: aload_1
    //   368: athrow
    //   369: astore_2
    //   370: aload_2
    //   371: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   374: goto -17 -> 357
    //   377: astore_2
    //   378: aload_2
    //   379: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   382: goto -15 -> 367
    //   385: astore_1
    //   386: goto -37 -> 349
    //   389: astore_3
    //   390: aload_1
    //   391: astore_2
    //   392: aload_3
    //   393: astore_1
    //   394: goto -45 -> 349
    //   397: astore_3
    //   398: aload_2
    //   399: astore_1
    //   400: aload_3
    //   401: astore_2
    //   402: goto -108 -> 294
    //   405: astore_2
    //   406: goto -236 -> 170
    //   409: astore_3
    //   410: goto -301 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	MessageForQQWalletMsg
    //   1	63	1	localObject1	java.lang.Object
    //   92	2	1	localException1	java.lang.Exception
    //   100	2	1	localException2	java.lang.Exception
    //   110	20	1	localObject2	java.lang.Object
    //   153	2	1	localException3	java.lang.Exception
    //   159	2	1	localException4	java.lang.Exception
    //   169	6	1	localObject3	java.lang.Object
    //   190	2	1	localException5	java.lang.Exception
    //   198	2	1	localException6	java.lang.Exception
    //   279	2	1	localException7	java.lang.Exception
    //   285	33	1	localException8	java.lang.Exception
    //   332	2	1	localException9	java.lang.Exception
    //   338	2	1	localException10	java.lang.Exception
    //   346	22	1	localObject4	java.lang.Object
    //   385	6	1	localObject5	java.lang.Object
    //   393	7	1	localObject6	java.lang.Object
    //   27	112	2	localObjectOutputStream1	java.io.ObjectOutputStream
    //   167	22	2	localObject7	java.lang.Object
    //   231	34	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   293	17	2	localException11	java.lang.Exception
    //   348	6	2	localObject8	java.lang.Object
    //   369	2	2	localException12	java.lang.Exception
    //   377	2	2	localException13	java.lang.Exception
    //   391	11	2	localObject9	java.lang.Object
    //   405	1	2	localObject10	java.lang.Object
    //   106	25	3	localException14	java.lang.Exception
    //   389	4	3	localObject11	java.lang.Object
    //   397	4	3	localException15	java.lang.Exception
    //   409	1	3	localException16	java.lang.Exception
    //   16	347	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   77	81	92	java/lang/Exception
    //   86	91	100	java/lang/Exception
    //   18	28	106	java/lang/Exception
    //   147	152	153	java/lang/Exception
    //   138	142	159	java/lang/Exception
    //   18	28	167	finally
    //   174	178	190	java/lang/Exception
    //   183	188	198	java/lang/Exception
    //   273	278	279	java/lang/Exception
    //   264	268	285	java/lang/Exception
    //   222	232	293	java/lang/Exception
    //   326	331	332	java/lang/Exception
    //   317	321	338	java/lang/Exception
    //   222	232	346	finally
    //   353	357	369	java/lang/Exception
    //   362	367	377	java/lang/Exception
    //   232	260	385	finally
    //   294	309	389	finally
    //   309	313	389	finally
    //   232	260	397	java/lang/Exception
    //   30	37	405	finally
    //   39	46	405	finally
    //   48	56	405	finally
    //   58	62	405	finally
    //   64	73	405	finally
    //   111	117	405	finally
    //   119	128	405	finally
    //   130	134	405	finally
    //   30	37	409	java/lang/Exception
    //   39	46	409	java/lang/Exception
    //   48	56	409	java/lang/Exception
    //   58	62	409	java/lang/Exception
    //   64	73	409	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletMsg
 * JD-Core Version:    0.7.0.1
 */