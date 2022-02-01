package oicq.wlogin_sdk.tools;

import android.content.Context;

public class RSACrypt
{
  protected static final String DEFAULT_PRIV_KEY = "3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9";
  public static final String DEFAULT_PUB_KEY = "30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001";
  private Context _context;
  private byte[] _priv_key = new byte[0];
  private byte[] _pub_key = new byte[0];
  
  public RSACrypt(Context paramContext)
  {
    this._context = paramContext;
    try
    {
      util.loadLibrary("wtecdh", this._context);
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  private native byte[] decryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native byte[] encryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native int genrsakey();
  
  /* Error */
  public byte[] DecryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: ifnonnull +13 -> 17
    //   7: ldc 48
    //   9: ldc 50
    //   11: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload 5
    //   16: areturn
    //   17: aload_1
    //   18: astore 4
    //   20: aload_1
    //   21: ifnonnull +30 -> 51
    //   24: aload_0
    //   25: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   28: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +11 -> 44
    //   36: aload_1
    //   37: astore 4
    //   39: aload_1
    //   40: arraylength
    //   41: ifne +10 -> 51
    //   44: ldc 8
    //   46: invokestatic 62	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   49: astore 4
    //   51: aload_0
    //   52: aload 4
    //   54: aload_2
    //   55: invokespecial 64	oicq/wlogin_sdk/tools/RSACrypt:decryptdata	([B[B)[B
    //   58: astore 5
    //   60: aload 5
    //   62: ifnull +12 -> 74
    //   65: aload 5
    //   67: astore_1
    //   68: aload 5
    //   70: arraylength
    //   71: ifne +14 -> 85
    //   74: aload_0
    //   75: ldc 8
    //   77: invokestatic 62	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   80: aload_2
    //   81: invokespecial 64	oicq/wlogin_sdk/tools/RSACrypt:decryptdata	([B[B)[B
    //   84: astore_1
    //   85: aload_1
    //   86: astore 5
    //   88: aload_1
    //   89: ifnonnull -75 -> 14
    //   92: aload_2
    //   93: aload 4
    //   95: invokestatic 68	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJNI	([B)Ljava/security/Key;
    //   98: invokestatic 72	oicq/wlogin_sdk/tools/util:RSADecrypt	([BLjava/security/Key;)[B
    //   101: astore 4
    //   103: aload 4
    //   105: astore_1
    //   106: new 74	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   113: ldc 77
    //   115: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: astore 5
    //   120: aload 4
    //   122: ifnonnull +161 -> 283
    //   125: iconst_0
    //   126: istore_3
    //   127: aload 4
    //   129: astore_1
    //   130: aload 5
    //   132: iload_3
    //   133: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: ldc 50
    //   141: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 4
    //   146: ifnull +16 -> 162
    //   149: aload 4
    //   151: astore 5
    //   153: aload 4
    //   155: astore_1
    //   156: aload 4
    //   158: arraylength
    //   159: ifne -145 -> 14
    //   162: aload 4
    //   164: astore_1
    //   165: aload_2
    //   166: ldc 8
    //   168: invokestatic 62	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   171: invokestatic 68	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJNI	([B)Ljava/security/Key;
    //   174: invokestatic 72	oicq/wlogin_sdk/tools/util:RSADecrypt	([BLjava/security/Key;)[B
    //   177: astore_2
    //   178: aload_2
    //   179: astore_1
    //   180: new 74	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   187: ldc 90
    //   189: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: astore 4
    //   194: aload_2
    //   195: ifnonnull +98 -> 293
    //   198: iconst_0
    //   199: istore_3
    //   200: aload_2
    //   201: astore_1
    //   202: aload 4
    //   204: iload_3
    //   205: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: ldc 50
    //   213: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_2
    //   217: areturn
    //   218: astore_2
    //   219: new 74	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   226: ldc 92
    //   228: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: ldc 50
    //   243: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_1
    //   247: areturn
    //   248: astore 5
    //   250: aconst_null
    //   251: astore_1
    //   252: new 74	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   259: ldc 95
    //   261: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 5
    //   266: invokestatic 101	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   269: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: ldc 50
    //   277: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: goto -195 -> 85
    //   283: aload 4
    //   285: astore_1
    //   286: aload 4
    //   288: arraylength
    //   289: istore_3
    //   290: goto -163 -> 127
    //   293: aload_2
    //   294: astore_1
    //   295: aload_2
    //   296: arraylength
    //   297: istore_3
    //   298: goto -98 -> 200
    //   301: astore 6
    //   303: aload 5
    //   305: astore_1
    //   306: aload 6
    //   308: astore 5
    //   310: goto -58 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	RSACrypt
    //   0	313	1	paramArrayOfByte1	byte[]
    //   0	313	2	paramArrayOfByte2	byte[]
    //   126	172	3	i	int
    //   18	269	4	localObject1	Object
    //   1	151	5	localObject2	Object
    //   248	56	5	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   308	1	5	localObject3	Object
    //   301	6	6	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   92	103	218	java/lang/Exception
    //   106	120	218	java/lang/Exception
    //   130	144	218	java/lang/Exception
    //   156	162	218	java/lang/Exception
    //   165	178	218	java/lang/Exception
    //   180	194	218	java/lang/Exception
    //   202	216	218	java/lang/Exception
    //   286	290	218	java/lang/Exception
    //   295	298	218	java/lang/Exception
    //   51	60	248	java/lang/UnsatisfiedLinkError
    //   68	74	301	java/lang/UnsatisfiedLinkError
    //   74	85	301	java/lang/UnsatisfiedLinkError
  }
  
  public byte[] EncryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null) {
        break label24;
      }
      localObject2 = localObject3;
    }
    label24:
    label35:
    do
    {
      return localObject2;
      try
      {
        localObject2 = encryptdata(paramArrayOfByte1, paramArrayOfByte2);
        localObject1 = localObject2;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        break label35;
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return util.RSAEncrypt(paramArrayOfByte2, util.RSAPubKeyFromJNI(paramArrayOfByte1));
  }
  
  /* Error */
  public int GenRSAKey()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: iconst_0
    //   5: istore 4
    //   7: iconst_0
    //   8: istore 5
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 6
    //   15: aload_0
    //   16: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   19: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   28: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   31: astore 8
    //   33: aload 7
    //   35: ifnull +49 -> 84
    //   38: aload 7
    //   40: arraylength
    //   41: ifle +43 -> 84
    //   44: aload 8
    //   46: ifnull +38 -> 84
    //   49: aload 8
    //   51: arraylength
    //   52: ifle +32 -> 84
    //   55: aload_0
    //   56: aload 7
    //   58: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   61: checkcast 115	[B
    //   64: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   67: aload_0
    //   68: aload 8
    //   70: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   73: checkcast 115	[B
    //   76: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   79: iload 6
    //   81: istore_2
    //   82: iload_2
    //   83: ireturn
    //   84: ldc 2
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   91: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   94: astore 7
    //   96: aload_0
    //   97: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   100: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   103: astore 8
    //   105: aload 7
    //   107: ifnull +141 -> 248
    //   110: aload 7
    //   112: arraylength
    //   113: ifle +135 -> 248
    //   116: aload 8
    //   118: ifnull +130 -> 248
    //   121: aload 8
    //   123: arraylength
    //   124: ifle +124 -> 248
    //   127: aload_0
    //   128: aload 7
    //   130: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   133: checkcast 115	[B
    //   136: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   139: aload_0
    //   140: aload 8
    //   142: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   145: checkcast 115	[B
    //   148: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   151: ldc 121
    //   153: ldc 50
    //   155: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iconst_1
    //   159: istore_3
    //   160: ldc 2
    //   162: monitorexit
    //   163: iload_1
    //   164: istore_2
    //   165: iload_3
    //   166: ifne -84 -> 82
    //   169: ldc 2
    //   171: monitorenter
    //   172: aload_0
    //   173: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   176: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   179: astore 7
    //   181: aload_0
    //   182: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   185: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   188: astore 8
    //   190: aload 7
    //   192: ifnull +247 -> 439
    //   195: aload 7
    //   197: arraylength
    //   198: ifle +241 -> 439
    //   201: aload 8
    //   203: ifnull +236 -> 439
    //   206: aload 8
    //   208: arraylength
    //   209: ifle +230 -> 439
    //   212: aload_0
    //   213: aload 7
    //   215: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   218: checkcast 115	[B
    //   221: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   224: aload_0
    //   225: aload 8
    //   227: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   230: checkcast 115	[B
    //   233: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   236: ldc 123
    //   238: ldc 50
    //   240: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: ldc 2
    //   245: monitorexit
    //   246: iload_1
    //   247: ireturn
    //   248: ldc 125
    //   250: ldc 50
    //   252: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: invokespecial 127	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   259: istore_1
    //   260: iload_1
    //   261: istore 4
    //   263: new 74	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   270: ldc 129
    //   272: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload_1
    //   276: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: ldc 50
    //   284: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: iconst_0
    //   288: istore_3
    //   289: goto -129 -> 160
    //   292: iload_1
    //   293: istore_3
    //   294: iload_2
    //   295: istore 4
    //   297: ldc 2
    //   299: monitorexit
    //   300: aload 7
    //   302: athrow
    //   303: astore 7
    //   305: iload_1
    //   306: istore_3
    //   307: iload_2
    //   308: istore_1
    //   309: invokestatic 133	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   312: astore 7
    //   314: aload 7
    //   316: ifnull +37 -> 353
    //   319: aload_0
    //   320: aload 7
    //   322: invokevirtual 139	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   325: invokeinterface 145 1 0
    //   330: invokestatic 149	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   333: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   336: aload_0
    //   337: aload 7
    //   339: invokevirtual 153	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   342: invokeinterface 156 1 0
    //   347: invokestatic 159	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   350: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   353: iload_1
    //   354: istore_2
    //   355: iload_3
    //   356: ifne -274 -> 82
    //   359: ldc 2
    //   361: monitorenter
    //   362: aload_0
    //   363: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   366: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   369: astore 7
    //   371: aload_0
    //   372: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   375: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   378: astore 8
    //   380: aload 7
    //   382: ifnull +104 -> 486
    //   385: aload 7
    //   387: arraylength
    //   388: ifle +98 -> 486
    //   391: aload 8
    //   393: ifnull +93 -> 486
    //   396: aload 8
    //   398: arraylength
    //   399: ifle +87 -> 486
    //   402: aload_0
    //   403: aload 7
    //   405: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   408: checkcast 115	[B
    //   411: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   414: aload_0
    //   415: aload 8
    //   417: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   420: checkcast 115	[B
    //   423: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   426: ldc 123
    //   428: ldc 50
    //   430: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: ldc 2
    //   435: monitorexit
    //   436: goto -190 -> 246
    //   439: ldc 161
    //   441: ldc 50
    //   443: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_0
    //   447: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   450: aload_0
    //   451: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   454: invokestatic 165	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   457: aload_0
    //   458: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   461: aload_0
    //   462: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   465: invokestatic 168	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   468: ldc 170
    //   470: ldc 50
    //   472: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: goto -232 -> 243
    //   478: astore 7
    //   480: ldc 2
    //   482: monitorexit
    //   483: aload 7
    //   485: athrow
    //   486: ldc 161
    //   488: ldc 50
    //   490: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_0
    //   494: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   497: aload_0
    //   498: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   501: invokestatic 165	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   504: aload_0
    //   505: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   508: aload_0
    //   509: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   512: invokestatic 168	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   515: ldc 170
    //   517: ldc 50
    //   519: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: goto -89 -> 433
    //   525: astore 7
    //   527: ldc 2
    //   529: monitorexit
    //   530: aload 7
    //   532: athrow
    //   533: astore 7
    //   535: iconst_0
    //   536: istore_3
    //   537: iload 5
    //   539: istore_1
    //   540: iload_1
    //   541: istore_2
    //   542: iload_3
    //   543: ifne -461 -> 82
    //   546: ldc 2
    //   548: monitorenter
    //   549: aload_0
    //   550: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   553: invokestatic 114	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   556: astore 8
    //   558: aload_0
    //   559: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   562: invokestatic 58	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   565: astore 9
    //   567: aload 8
    //   569: ifnull +57 -> 626
    //   572: aload 8
    //   574: arraylength
    //   575: ifle +51 -> 626
    //   578: aload 9
    //   580: ifnull +46 -> 626
    //   583: aload 9
    //   585: arraylength
    //   586: ifle +40 -> 626
    //   589: aload_0
    //   590: aload 8
    //   592: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   595: checkcast 115	[B
    //   598: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   601: aload_0
    //   602: aload 9
    //   604: invokevirtual 119	[B:clone	()Ljava/lang/Object;
    //   607: checkcast 115	[B
    //   610: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   613: ldc 123
    //   615: ldc 50
    //   617: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: ldc 2
    //   622: monitorexit
    //   623: aload 7
    //   625: athrow
    //   626: ldc 161
    //   628: ldc 50
    //   630: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload_0
    //   634: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   637: aload_0
    //   638: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   641: invokestatic 165	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   644: aload_0
    //   645: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   648: aload_0
    //   649: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   652: invokestatic 168	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   655: ldc 170
    //   657: ldc 50
    //   659: invokestatic 54	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: goto -42 -> 620
    //   665: astore 7
    //   667: ldc 2
    //   669: monitorexit
    //   670: aload 7
    //   672: athrow
    //   673: astore 7
    //   675: iload_1
    //   676: istore_3
    //   677: iload_2
    //   678: istore_1
    //   679: goto -139 -> 540
    //   682: astore 7
    //   684: goto -144 -> 540
    //   687: astore 7
    //   689: iconst_0
    //   690: istore_3
    //   691: iload 4
    //   693: istore_1
    //   694: goto -385 -> 309
    //   697: astore 7
    //   699: iload_3
    //   700: istore_1
    //   701: iload 4
    //   703: istore_2
    //   704: goto -412 -> 292
    //   707: astore 7
    //   709: iload_1
    //   710: istore_2
    //   711: iload_3
    //   712: istore_1
    //   713: goto -421 -> 292
    //   716: astore 7
    //   718: iconst_0
    //   719: istore_3
    //   720: iload_2
    //   721: istore_1
    //   722: iload_3
    //   723: istore_2
    //   724: goto -432 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	this	RSACrypt
    //   1	721	1	i	int
    //   3	721	2	j	int
    //   11	712	3	k	int
    //   5	697	4	m	int
    //   8	530	5	n	int
    //   13	67	6	i1	int
    //   22	279	7	arrayOfByte1	byte[]
    //   303	1	7	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   312	92	7	localObject1	Object
    //   478	6	7	localObject2	Object
    //   525	6	7	localObject3	Object
    //   533	91	7	localObject4	Object
    //   665	6	7	localObject5	Object
    //   673	1	7	localObject6	Object
    //   682	1	7	localObject7	Object
    //   687	1	7	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   697	1	7	localObject8	Object
    //   707	1	7	localObject9	Object
    //   716	1	7	localObject10	Object
    //   31	560	8	arrayOfByte2	byte[]
    //   565	38	9	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   300	303	303	java/lang/UnsatisfiedLinkError
    //   172	190	478	finally
    //   195	201	478	finally
    //   206	243	478	finally
    //   243	246	478	finally
    //   439	475	478	finally
    //   480	483	478	finally
    //   362	380	525	finally
    //   385	391	525	finally
    //   396	433	525	finally
    //   433	436	525	finally
    //   486	522	525	finally
    //   527	530	525	finally
    //   84	87	533	finally
    //   549	567	665	finally
    //   572	578	665	finally
    //   583	620	665	finally
    //   620	623	665	finally
    //   626	662	665	finally
    //   667	670	665	finally
    //   300	303	673	finally
    //   309	314	682	finally
    //   319	353	682	finally
    //   84	87	687	java/lang/UnsatisfiedLinkError
    //   263	287	697	finally
    //   297	300	697	finally
    //   160	163	707	finally
    //   87	105	716	finally
    //   110	116	716	finally
    //   121	158	716	finally
    //   248	260	716	finally
  }
  
  public byte[] get_priv_key()
  {
    return this._priv_key;
  }
  
  public byte[] get_pub_key()
  {
    return this._pub_key;
  }
  
  public void set_priv_key(byte[] paramArrayOfByte)
  {
    this._priv_key = paramArrayOfByte;
  }
  
  public void set_pub_key(byte[] paramArrayOfByte)
  {
    this._pub_key = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.RSACrypt
 * JD-Core Version:    0.7.0.1
 */