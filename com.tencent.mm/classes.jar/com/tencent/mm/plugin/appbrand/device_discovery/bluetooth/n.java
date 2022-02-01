package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fh;
import com.tencent.mm.plugin.appbrand.device_discovery.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "blockAppInfo", "", "appId", "", "deleteAppInfo", "versionType", "", "deleteInfo", "wechatToken", "getAllAppInfo", "getAllInfo", "setInfo", "", "info", "unblockAppInfo", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends MAutoStorage<MonitoredBluetoothDeviceInfo>
{
  public static final String[] nVW;
  public static final a rhn;
  private static final String[] rho;
  private static final String[] rhp;
  
  static
  {
    AppMethodBeat.i(321636);
    rhn = new a((byte)0);
    rho = new String[] { "wechatToken" };
    rhp = new String[] { "appId", "versionType" };
    nVW = new String[] { MAutoStorage.getCreateSQLs(MonitoredBluetoothDeviceInfo.nVV, "MonitoredBluetoothDeviceInfo") };
    AppMethodBeat.o(321636);
  }
  
  public n(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, MonitoredBluetoothDeviceInfo.nVV, "MonitoredBluetoothDeviceInfo", fh.INDEX_CREATE);
    AppMethodBeat.i(321618);
    AppMethodBeat.o(321618);
  }
  
  /* Error */
  private final java.util.List<MonitoredBluetoothDeviceInfo> YK(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 105
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   10: astore_2
    //   11: ldc 113
    //   13: ldc 115
    //   15: aload_1
    //   16: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   19: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: new 124	java/lang/StringBuilder
    //   25: dup
    //   26: ldc 126
    //   28: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: invokevirtual 133	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getTableName	()Ljava/lang/String;
    //   35: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: ldc 139
    //   40: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: bipush 39
    //   49: invokevirtual 145	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   52: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: getstatic 154	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/g:DEBUG	Z
    //   59: ifeq +18 -> 77
    //   62: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   65: astore_2
    //   66: ldc 113
    //   68: ldc 156
    //   70: aload_1
    //   71: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokestatic 159	com/tencent/mm/plugin/appbrand/device_discovery/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: aload_1
    //   79: iconst_0
    //   80: anewarray 61	java/lang/String
    //   83: invokevirtual 163	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnonnull +31 -> 119
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnonnull +94 -> 188
    //   97: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   100: astore_1
    //   101: ldc 113
    //   103: ldc 165
    //   105: invokestatic 168	com/tencent/mm/plugin/appbrand/device_discovery/a:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: ldc 105
    //   110: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: areturn
    //   119: aload_2
    //   120: invokeinterface 174 1 0
    //   125: ifne +19 -> 144
    //   128: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   131: astore_1
    //   132: ldc 113
    //   134: ldc 176
    //   136: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -48 -> 93
    //   144: new 178	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 180	java/util/ArrayList:<init>	()V
    //   151: astore_1
    //   152: new 70	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo
    //   155: dup
    //   156: invokespecial 181	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:<init>	()V
    //   159: astore_3
    //   160: aload_3
    //   161: aload_2
    //   162: invokevirtual 185	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:convertFrom	(Landroid/database/Cursor;)V
    //   165: getstatic 191	kotlin/ah:aiuX	Lkotlin/ah;
    //   168: astore 4
    //   170: aload_1
    //   171: aload_3
    //   172: invokevirtual 195	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   175: pop
    //   176: aload_2
    //   177: invokeinterface 198 1 0
    //   182: ifne -30 -> 152
    //   185: goto -92 -> 93
    //   188: aload_1
    //   189: checkcast 200	java/util/List
    //   192: astore_1
    //   193: ldc 105
    //   195: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: goto -83 -> 115
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	n
    //   0	206	1	paramString	String
    //   10	167	2	localObject	Object
    //   159	13	3	localMonitoredBluetoothDeviceInfo	MonitoredBluetoothDeviceInfo
    //   168	1	4	localah	kotlin.ah
    // Exception table:
    //   from	to	target	type
    //   2	77	201	finally
    //   77	87	201	finally
    //   97	113	201	finally
    //   119	139	201	finally
    //   144	152	201	finally
    //   152	185	201	finally
    //   188	198	201	finally
  }
  
  /* Error */
  private final java.util.List<MonitoredBluetoothDeviceInfo> cv(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 205
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   10: astore_3
    //   11: ldc 113
    //   13: new 124	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 115
    //   19: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 207
    //   28: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_2
    //   32: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: new 124	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 126
    //   47: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 133	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getTableName	()Ljava/lang/String;
    //   54: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc 139
    //   59: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 212
    //   68: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: getstatic 154	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/g:DEBUG	Z
    //   82: ifeq +18 -> 100
    //   85: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   88: astore_3
    //   89: ldc 113
    //   91: ldc 156
    //   93: aload_1
    //   94: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokestatic 159	com/tencent/mm/plugin/appbrand/device_discovery/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: aload_1
    //   102: iconst_0
    //   103: anewarray 61	java/lang/String
    //   106: invokevirtual 163	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore_3
    //   110: aload_3
    //   111: ifnonnull +31 -> 142
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: ifnonnull +97 -> 214
    //   120: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   123: astore_1
    //   124: ldc 113
    //   126: ldc 165
    //   128: invokestatic 168	com/tencent/mm/plugin/appbrand/device_discovery/a:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc 205
    //   133: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: areturn
    //   142: aload_3
    //   143: invokeinterface 174 1 0
    //   148: ifne +19 -> 167
    //   151: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   154: astore_1
    //   155: ldc 113
    //   157: ldc 176
    //   159: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -48 -> 116
    //   167: new 178	java/util/ArrayList
    //   170: dup
    //   171: invokespecial 180	java/util/ArrayList:<init>	()V
    //   174: astore_1
    //   175: new 70	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo
    //   178: dup
    //   179: invokespecial 181	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:<init>	()V
    //   182: astore 4
    //   184: aload 4
    //   186: aload_3
    //   187: invokevirtual 185	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:convertFrom	(Landroid/database/Cursor;)V
    //   190: getstatic 191	kotlin/ah:aiuX	Lkotlin/ah;
    //   193: astore 5
    //   195: aload_1
    //   196: aload 4
    //   198: invokevirtual 195	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   201: pop
    //   202: aload_3
    //   203: invokeinterface 198 1 0
    //   208: ifne -33 -> 175
    //   211: goto -95 -> 116
    //   214: aload_1
    //   215: checkcast 200	java/util/List
    //   218: astore_1
    //   219: ldc 205
    //   221: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: goto -86 -> 138
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	n
    //   0	232	1	paramString	String
    //   0	232	2	paramInt	int
    //   10	193	3	localObject	Object
    //   182	15	4	localMonitoredBluetoothDeviceInfo	MonitoredBluetoothDeviceInfo
    //   193	1	5	localah	kotlin.ah
    // Exception table:
    //   from	to	target	type
    //   2	100	227	finally
    //   100	110	227	finally
    //   120	136	227	finally
    //   142	162	227	finally
    //   167	175	227	finally
    //   175	211	227	finally
    //   214	224	227	finally
  }
  
  /* Error */
  public final java.util.List<MonitoredBluetoothDeviceInfo> YH(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 215
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc 65
    //   12: invokestatic 93	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   18: astore_3
    //   19: ldc 113
    //   21: ldc 217
    //   23: aload_1
    //   24: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 219	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:YK	(Ljava/lang/String;)Ljava/util/List;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnonnull +14 -> 51
    //   40: ldc 215
    //   42: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: new 124	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 221
    //   57: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: invokevirtual 133	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getTableName	()Ljava/lang/String;
    //   64: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: ldc 223
    //   69: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: bipush 39
    //   78: invokevirtual 145	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   81: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: getstatic 154	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/g:DEBUG	Z
    //   88: ifeq +19 -> 107
    //   91: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   94: astore 4
    //   96: ldc 113
    //   98: ldc 225
    //   100: aload_1
    //   101: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokestatic 159	com/tencent/mm/plugin/appbrand/device_discovery/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: aload_0
    //   109: invokevirtual 133	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getTableName	()Ljava/lang/String;
    //   112: aload_1
    //   113: invokevirtual 229	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   116: ifeq +13 -> 129
    //   119: ldc 215
    //   121: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_3
    //   125: astore_1
    //   126: goto -79 -> 47
    //   129: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   132: astore_1
    //   133: ldc 113
    //   135: ldc 231
    //   137: invokestatic 168	com/tencent/mm/plugin/appbrand/device_discovery/a:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 215
    //   142: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_2
    //   146: astore_1
    //   147: goto -100 -> 47
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	n
    //   0	155	1	paramString	String
    //   1	145	2	localObject1	Object
    //   18	107	3	localObject2	Object
    //   94	1	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   4	36	150	finally
    //   40	45	150	finally
    //   51	107	150	finally
    //   107	124	150	finally
    //   129	145	150	finally
  }
  
  /* Error */
  public final java.util.List<MonitoredBluetoothDeviceInfo> YI(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 233
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc 65
    //   12: invokestatic 93	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   18: astore_3
    //   19: ldc 113
    //   21: ldc 235
    //   23: aload_1
    //   24: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 219	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:YK	(Ljava/lang/String;)Ljava/util/List;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnonnull +14 -> 51
    //   40: ldc 233
    //   42: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: new 124	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 221
    //   57: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: invokevirtual 133	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getTableName	()Ljava/lang/String;
    //   64: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: ldc 237
    //   69: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: bipush 39
    //   78: invokevirtual 145	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   81: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: getstatic 154	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/g:DEBUG	Z
    //   88: ifeq +19 -> 107
    //   91: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   94: astore 4
    //   96: ldc 113
    //   98: ldc 239
    //   100: aload_1
    //   101: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokestatic 159	com/tencent/mm/plugin/appbrand/device_discovery/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: aload_0
    //   109: invokevirtual 133	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getTableName	()Ljava/lang/String;
    //   112: aload_1
    //   113: invokevirtual 229	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   116: ifeq +13 -> 129
    //   119: ldc 233
    //   121: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_3
    //   125: astore_1
    //   126: goto -79 -> 47
    //   129: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   132: astore_1
    //   133: ldc 113
    //   135: ldc 241
    //   137: invokestatic 168	com/tencent/mm/plugin/appbrand/device_discovery/a:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 233
    //   142: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_2
    //   146: astore_1
    //   147: goto -100 -> 47
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	n
    //   0	155	1	paramString	String
    //   1	145	2	localObject1	Object
    //   18	107	3	localObject2	Object
    //   94	1	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   4	36	150	finally
    //   40	45	150	finally
    //   51	107	150	finally
    //   107	124	150	finally
    //   129	145	150	finally
  }
  
  /* Error */
  public final MonitoredBluetoothDeviceInfo YJ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 244
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 62
    //   10: invokestatic 93	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   16: astore_2
    //   17: ldc 113
    //   19: ldc 246
    //   21: aload_1
    //   22: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   25: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: new 70	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo
    //   31: dup
    //   32: invokespecial 181	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:<init>	()V
    //   35: astore_2
    //   36: aload_2
    //   37: aload_1
    //   38: putfield 250	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:field_wechatToken	Ljava/lang/String;
    //   41: aload_2
    //   42: checkcast 252	com/tencent/mm/sdk/storage/IAutoDBItem
    //   45: astore_1
    //   46: getstatic 64	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:rho	[Ljava/lang/String;
    //   49: astore_3
    //   50: aload_0
    //   51: aload_1
    //   52: aload_3
    //   53: aload_3
    //   54: arraylength
    //   55: invokestatic 258	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   58: checkcast 259	[Ljava/lang/String;
    //   61: invokevirtual 263	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:get	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   64: ifeq +40 -> 104
    //   67: aload_2
    //   68: checkcast 252	com/tencent/mm/sdk/storage/IAutoDBItem
    //   71: astore_1
    //   72: getstatic 64	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:rho	[Ljava/lang/String;
    //   75: astore_3
    //   76: aload_0
    //   77: aload_1
    //   78: aload_3
    //   79: aload_3
    //   80: arraylength
    //   81: invokestatic 258	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   84: checkcast 259	[Ljava/lang/String;
    //   87: invokevirtual 266	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:delete	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   90: ifeq +14 -> 104
    //   93: ldc 244
    //   95: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: areturn
    //   104: aconst_null
    //   105: astore_1
    //   106: ldc 244
    //   108: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -11 -> 100
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	n
    //   0	119	1	paramString	String
    //   16	83	2	localObject	Object
    //   49	31	3	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	98	114	finally
    //   106	111	114	finally
  }
  
  public final boolean c(MonitoredBluetoothDeviceInfo paramMonitoredBluetoothDeviceInfo)
  {
    try
    {
      AppMethodBeat.i(321651);
      s.u(paramMonitoredBluetoothDeviceInfo, "info");
      if (g.DEBUG)
      {
        a locala = a.rfZ;
        a.d("MicroMsg.AppBrand.MonitoredBluetoothDeviceInfoStorage", s.X("setInfo, info: ", paramMonitoredBluetoothDeviceInfo));
      }
      boolean bool = replace((IAutoDBItem)paramMonitoredBluetoothDeviceInfo);
      AppMethodBeat.o(321651);
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public final java.util.List<MonitoredBluetoothDeviceInfo> cmq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 279
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 283	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:getAll	()Landroid/database/Cursor;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +38 -> 52
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +112 -> 132
    //   23: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   26: astore_1
    //   27: ldc 113
    //   29: ldc_w 285
    //   32: invokestatic 168	com/tencent/mm/plugin/appbrand/device_discovery/a:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: getstatic 291	kotlin/a/ab:aivy	Lkotlin/a/ab;
    //   38: checkcast 200	java/util/List
    //   41: astore_1
    //   42: ldc_w 279
    //   45: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: aload_1
    //   53: invokeinterface 174 1 0
    //   58: ifne +25 -> 83
    //   61: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   64: astore_1
    //   65: ldc 113
    //   67: ldc_w 293
    //   70: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: getstatic 291	kotlin/a/ab:aivy	Lkotlin/a/ab;
    //   76: checkcast 200	java/util/List
    //   79: astore_1
    //   80: goto -61 -> 19
    //   83: new 178	java/util/ArrayList
    //   86: dup
    //   87: invokespecial 180	java/util/ArrayList:<init>	()V
    //   90: astore_2
    //   91: new 70	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo
    //   94: dup
    //   95: invokespecial 181	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:<init>	()V
    //   98: astore_3
    //   99: aload_3
    //   100: aload_1
    //   101: invokevirtual 185	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:convertFrom	(Landroid/database/Cursor;)V
    //   104: getstatic 191	kotlin/ah:aiuX	Lkotlin/ah;
    //   107: astore 4
    //   109: aload_2
    //   110: aload_3
    //   111: invokevirtual 195	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_1
    //   116: invokeinterface 198 1 0
    //   121: ifne -30 -> 91
    //   124: aload_2
    //   125: checkcast 200	java/util/List
    //   128: astore_1
    //   129: goto -110 -> 19
    //   132: ldc_w 279
    //   135: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -90 -> 48
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	n
    //   12	117	1	localObject1	Object
    //   141	4	1	localObject2	Object
    //   90	35	2	localArrayList	java.util.ArrayList
    //   98	13	3	localMonitoredBluetoothDeviceInfo	MonitoredBluetoothDeviceInfo
    //   107	1	4	localah	kotlin.ah
    // Exception table:
    //   from	to	target	type
    //   2	13	141	finally
    //   23	48	141	finally
    //   52	80	141	finally
    //   83	91	141	finally
    //   91	129	141	finally
    //   132	138	141	finally
  }
  
  /* Error */
  public final java.util.List<MonitoredBluetoothDeviceInfo> cu(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 296
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 65
    //   11: invokestatic 93	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   17: astore_3
    //   18: ldc 113
    //   20: new 124	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 298
    //   27: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 207
    //   36: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_2
    //   40: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 122	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: iload_2
    //   52: invokespecial 300	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:cv	(Ljava/lang/String;I)Ljava/util/List;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +15 -> 72
    //   60: ldc_w 296
    //   63: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: areturn
    //   72: new 70	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo
    //   75: dup
    //   76: invokespecial 181	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: aload_1
    //   84: putfield 303	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:field_appId	Ljava/lang/String;
    //   87: aload 4
    //   89: iload_2
    //   90: putfield 307	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfo:field_versionType	I
    //   93: aload 4
    //   95: checkcast 252	com/tencent/mm/sdk/storage/IAutoDBItem
    //   98: astore_1
    //   99: getstatic 68	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:rhp	[Ljava/lang/String;
    //   102: astore 4
    //   104: aload_0
    //   105: aload_1
    //   106: aload 4
    //   108: aload 4
    //   110: arraylength
    //   111: invokestatic 258	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   114: checkcast 259	[Ljava/lang/String;
    //   117: invokevirtual 266	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/n:delete	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   120: ifeq +14 -> 134
    //   123: ldc_w 296
    //   126: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_3
    //   130: astore_1
    //   131: goto -63 -> 68
    //   134: getstatic 111	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   137: astore_1
    //   138: ldc 113
    //   140: ldc_w 309
    //   143: invokestatic 168	com/tencent/mm/plugin/appbrand/device_discovery/a:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc_w 296
    //   149: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: astore_1
    //   154: goto -86 -> 68
    //   157: astore_1
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	n
    //   0	162	1	paramString	String
    //   0	162	2	paramInt	int
    //   17	113	3	localObject1	Object
    //   79	30	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	56	157	finally
    //   60	66	157	finally
    //   72	129	157	finally
    //   134	152	157	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfoStorage$Companion;", "", "()V", "KEYS_APP_ID_VERSION_TYPE", "", "", "[Ljava/lang/String;", "KEYS_WECHAT_TOKEN", "TABLE_CREATE", "kotlin.jvm.PlatformType", "TAG", "get", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/MonitoredBluetoothDeviceInfoStorage;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.n
 * JD-Core Version:    0.7.0.1
 */