package com.tencent.tmassistant.common;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.jce.JceCmd;
import com.tencent.tmassistant.common.jce.ReportLogRequest;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.RspHead;
import com.tencent.tmassistant.common.jce.Terminal;
import com.tencent.tmassistantbase.a.e;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.p;
import java.util.List;

public class a
{
  public static JceStruct a(byte paramByte, List paramList, String paramString1, int paramInt, String paramString2)
  {
    ReportLogRequest localReportLogRequest = new ReportLogRequest();
    localReportLogRequest.logType = paramByte;
    localReportLogRequest.logData = a(paramList);
    localReportLogRequest.hostAppPackageName = paramString1;
    localReportLogRequest.hostAppVersion = paramInt;
    localReportLogRequest.hostUserId = paramString2;
    return localReportLogRequest;
  }
  
  public static JceStruct a(JceStruct paramJceStruct, byte[] paramArrayOfByte)
  {
    if ((paramJceStruct != null) && (paramArrayOfByte != null))
    {
      paramJceStruct = d(paramJceStruct);
      if (paramJceStruct != null) {
        try
        {
          paramArrayOfByte = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte.setServerEncoding("utf-8");
          paramJceStruct.readFrom(paramArrayOfByte);
          return paramJceStruct;
        }
        catch (Exception paramJceStruct)
        {
          paramJceStruct.printStackTrace();
          return null;
        }
      }
    }
    return null;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, Class paramClass)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static ReqHead a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    ReqHead localReqHead = new ReqHead();
    localReqHead.requestId = f.i();
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    localReqHead.cmdId = JceCmd.convert(paramJceStruct.substring(0, paramJceStruct.length() - "Request".length())).value();
    localReqHead.qua = f.a().d;
    localReqHead.phoneGuid = f.a().e();
    paramJceStruct = new Terminal();
    paramJceStruct.androidId = f.a().d();
    paramJceStruct.androidIdSdCard = f.a().e();
    paramJceStruct.imei = f.a().f();
    paramJceStruct.imsi = f.a().g();
    paramJceStruct.macAdress = f.a().h();
    localReqHead.terminal = paramJceStruct;
    localReqHead.assistantAPILevel = f.a().k();
    localReqHead.assistantVersionCode = f.a().l();
    return localReqHead;
  }
  
  public static Response a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Response localResponse = new Response();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localResponse;
        if (localResponse.head.ret == 0)
        {
          if ((localResponse.head.encryptWithPack & 0x2) == 2) {
            localResponse.body = b(localResponse.body, "ji*9^&43U0X-~./(".getBytes());
          }
          if ((localResponse.head.encryptWithPack & 0x1) == 1) {
            localResponse.body = p.b(localResponse.body);
          }
          f.a().a(localResponse.head.phoneGuid);
          return localResponse;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(Request paramRequest)
  {
    if (paramRequest == null) {
      return null;
    }
    paramRequest.head.encryptWithPack = 0;
    if (paramRequest.body.length > 256)
    {
      paramRequest.body = p.a(paramRequest.body);
      paramRequest.head.encryptWithPack = ((byte)(paramRequest.head.encryptWithPack | 0x1));
    }
    paramRequest.body = a(paramRequest.body, "ji*9^&43U0X-~./(".getBytes());
    paramRequest.head.encryptWithPack = ((byte)(paramRequest.head.encryptWithPack | 0x2));
    return c(paramRequest);
  }
  
  /* Error */
  public static byte[] a(List paramList)
  {
    // Byte code:
    //   0: new 231	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 232	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 234	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 237	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload_0
    //   24: invokeinterface 243 1 0
    //   29: astore_0
    //   30: aload 4
    //   32: astore_3
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: invokeinterface 249 1 0
    //   41: ifeq +83 -> 124
    //   44: aload 4
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_0
    //   50: invokeinterface 252 1 0
    //   55: checkcast 253	[B
    //   58: astore 5
    //   60: aload 4
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: aload 5
    //   69: arraylength
    //   70: invokevirtual 257	java/io/DataOutputStream:writeInt	(I)V
    //   73: aload 4
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 260	java/io/DataOutputStream:write	([B)V
    //   85: goto -55 -> 30
    //   88: astore_2
    //   89: aload 4
    //   91: astore_0
    //   92: aload_2
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: aload 4
    //   101: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 264	java/io/DataOutputStream:close	()V
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: areturn
    //   124: aload 4
    //   126: astore_3
    //   127: aload_1
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 267	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   133: astore_0
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   142: aload_0
    //   143: astore_1
    //   144: aload 4
    //   146: ifnull -24 -> 122
    //   149: aload 4
    //   151: invokevirtual 264	java/io/DataOutputStream:close	()V
    //   154: aload_0
    //   155: areturn
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   161: aload_0
    //   162: areturn
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   168: goto -26 -> 142
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   176: goto -64 -> 112
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   184: goto -64 -> 120
    //   187: astore_0
    //   188: aconst_null
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 263	java/io/ByteArrayOutputStream:close	()V
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 264	java/io/DataOutputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   215: goto -15 -> 200
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 268	java/io/IOException:printStackTrace	()V
    //   223: goto -15 -> 208
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -37 -> 192
    //   232: astore_0
    //   233: aload_2
    //   234: astore_1
    //   235: goto -43 -> 192
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_1
    //   244: goto -149 -> 95
    //   247: astore 4
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -156 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramList	List
    //   7	137	1	localObject1	Object
    //   156	2	1	localIOException1	java.io.IOException
    //   163	2	1	localIOException2	java.io.IOException
    //   171	2	1	localIOException3	java.io.IOException
    //   191	6	1	localObject2	Object
    //   210	2	1	localIOException4	java.io.IOException
    //   218	2	1	localIOException5	java.io.IOException
    //   234	10	1	localObject3	Object
    //   22	56	2	localObject4	Object
    //   88	5	2	localException1	Exception
    //   98	136	2	localObject5	Object
    //   20	209	3	localObject6	Object
    //   16	134	4	localObject7	Object
    //   238	1	4	localException2	Exception
    //   247	1	4	localException3	Exception
    //   58	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	30	88	java/lang/Exception
    //   35	44	88	java/lang/Exception
    //   49	60	88	java/lang/Exception
    //   65	73	88	java/lang/Exception
    //   78	85	88	java/lang/Exception
    //   129	134	88	java/lang/Exception
    //   149	154	156	java/io/IOException
    //   138	142	163	java/io/IOException
    //   108	112	171	java/io/IOException
    //   116	120	179	java/io/IOException
    //   0	8	187	finally
    //   196	200	210	java/io/IOException
    //   204	208	218	java/io/IOException
    //   8	18	226	finally
    //   23	30	232	finally
    //   35	44	232	finally
    //   49	60	232	finally
    //   65	73	232	finally
    //   78	85	232	finally
    //   99	104	232	finally
    //   129	134	232	finally
    //   0	8	238	java/lang/Exception
    //   8	18	247	java/lang/Exception
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new e().b(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static Request b(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    Request localRequest = new Request();
    localRequest.head = a(paramJceStruct);
    localRequest.body = c(paramJceStruct);
    return localRequest;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new e().a(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] c(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  private static JceStruct d(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct = paramJceStruct.getClass().getName();
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - "Request".length()) + "Response";
    try
    {
      paramJceStruct = (JceStruct)Class.forName(paramJceStruct).newInstance();
      return paramJceStruct;
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (IllegalAccessException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (InstantiationException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.a
 * JD-Core Version:    0.7.0.1
 */