package com.pay.network.model;

import com.pay.http.APBaseHttpAns;
import com.pay.http.APBaseHttpReq;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.tool.APProductItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APMpAns
  extends APBaseHttpAns
{
  private String beginTime;
  private String endTime;
  private String firstsave_present_count;
  private List<APProductItem> mGoodsList;
  private String mpJson;
  private List<String> mpList;
  private List<String> mpPresentList;
  private List<String> mpValueList;
  private String rate;
  
  public APMpAns(APHttpHandle paramAPHttpHandle, IAPHttpAnsObserver paramIAPHttpAnsObserver, HashMap<String, APBaseHttpReq> paramHashMap, String paramString)
  {
    super(paramAPHttpHandle, paramIAPHttpAnsObserver, paramHashMap, paramString);
    AppMethodBeat.i(207459);
    this.rate = "";
    this.firstsave_present_count = "";
    this.beginTime = "";
    this.endTime = "";
    this.mpJson = "";
    this.mpValueList = new ArrayList();
    this.mpPresentList = new ArrayList();
    this.mpList = new ArrayList();
    this.mGoodsList = new ArrayList();
    AppMethodBeat.o(207459);
  }
  
  public String getBeginTime()
  {
    return this.beginTime;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getFirstsave_present_count()
  {
    return this.firstsave_present_count;
  }
  
  public String getMpJson()
  {
    return this.mpJson;
  }
  
  public List<String> getMpList()
  {
    return this.mpList;
  }
  
  public List<String> getMpPresentList()
  {
    return this.mpPresentList;
  }
  
  public List<String> getMpValueList()
  {
    return this.mpValueList;
  }
  
  public List<APProductItem> getProductList()
  {
    return this.mGoodsList;
  }
  
  public String getRate()
  {
    return this.rate;
  }
  
  public void onErrorAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  /* Error */
  public void onFinishAns(byte[] paramArrayOfByte, APBaseHttpReq paramAPBaseHttpReq)
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 81	com/pay/http/APBaseHttpAns:onFinishAns	([BLcom/pay/http/APBaseHttpReq;)V
    //   11: new 83	java/lang/String
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 86	java/lang/String:<init>	([B)V
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 40	com/pay/network/model/APMpAns:mpJson	Ljava/lang/String;
    //   25: ldc 88
    //   27: ldc 90
    //   29: aload_1
    //   30: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokevirtual 98	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 103	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 105	org/json/JSONObject
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 108	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   47: astore_1
    //   48: aload_0
    //   49: aload_1
    //   50: ldc 110
    //   52: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokevirtual 116	java/lang/String:toString	()Ljava/lang/String;
    //   58: invokestatic 122	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: putfield 126	com/pay/network/model/APMpAns:resultCode	I
    //   64: aload_0
    //   65: getfield 126	com/pay/network/model/APMpAns:resultCode	I
    //   68: ifne +197 -> 265
    //   71: aload_1
    //   72: ldc 128
    //   74: invokevirtual 132	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   77: ifeq +112 -> 189
    //   80: aload_1
    //   81: ldc 128
    //   83: invokevirtual 136	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   86: astore_2
    //   87: aload_0
    //   88: getfield 53	com/pay/network/model/APMpAns:mGoodsList	Ljava/util/List;
    //   91: invokeinterface 141 1 0
    //   96: iconst_0
    //   97: istore_3
    //   98: iload_3
    //   99: aload_2
    //   100: invokevirtual 147	org/json/JSONArray:length	()I
    //   103: if_icmpge +86 -> 189
    //   106: aload_2
    //   107: iload_3
    //   108: invokevirtual 151	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   111: astore 4
    //   113: new 153	com/pay/tool/APProductItem
    //   116: dup
    //   117: invokespecial 154	com/pay/tool/APProductItem:<init>	()V
    //   120: astore 5
    //   122: aload 5
    //   124: aload 4
    //   126: ldc 156
    //   128: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 158	com/pay/tool/APProductItem:name	Ljava/lang/String;
    //   134: aload 5
    //   136: aload 4
    //   138: ldc 160
    //   140: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 163	com/pay/tool/APProductItem:productId	Ljava/lang/String;
    //   146: aload 5
    //   148: aload 4
    //   150: ldc 165
    //   152: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: putfield 167	com/pay/tool/APProductItem:price	Ljava/lang/String;
    //   158: aload 5
    //   160: aload 4
    //   162: ldc 169
    //   164: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: putfield 171	com/pay/tool/APProductItem:num	Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 53	com/pay/network/model/APMpAns:mGoodsList	Ljava/util/List;
    //   174: aload 5
    //   176: invokeinterface 175 2 0
    //   181: pop
    //   182: iload_3
    //   183: iconst_1
    //   184: iadd
    //   185: istore_3
    //   186: goto -88 -> 98
    //   189: aload_0
    //   190: aload_1
    //   191: ldc 176
    //   193: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: putfield 32	com/pay/network/model/APMpAns:rate	Ljava/lang/String;
    //   199: aload_1
    //   200: ldc 178
    //   202: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 51	com/pay/network/model/APMpAns:mpList	Ljava/util/List;
    //   209: invokestatic 184	com/pay/network/model/APCommMethod:transformStrToList	(Ljava/lang/String;Ljava/util/List;)V
    //   212: aload_0
    //   213: aload_1
    //   214: ldc 185
    //   216: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 34	com/pay/network/model/APMpAns:firstsave_present_count	Ljava/lang/String;
    //   222: aload_1
    //   223: ldc 187
    //   225: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   228: aload_0
    //   229: getfield 47	com/pay/network/model/APMpAns:mpValueList	Ljava/util/List;
    //   232: aload_0
    //   233: getfield 49	com/pay/network/model/APMpAns:mpPresentList	Ljava/util/List;
    //   236: invokestatic 191	com/pay/network/model/APCommMethod:transformStrToMpInfoList	(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   239: aload_0
    //   240: aload_1
    //   241: ldc 193
    //   243: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: putfield 36	com/pay/network/model/APMpAns:beginTime	Ljava/lang/String;
    //   249: aload_0
    //   250: aload_1
    //   251: ldc 195
    //   253: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: putfield 38	com/pay/network/model/APMpAns:endTime	Ljava/lang/String;
    //   259: ldc 79
    //   261: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: return
    //   265: aload_0
    //   266: aload_1
    //   267: ldc 197
    //   269: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: putfield 200	com/pay/network/model/APMpAns:resultMsg	Ljava/lang/String;
    //   275: aload_1
    //   276: ldc 202
    //   278: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokevirtual 116	java/lang/String:toString	()Ljava/lang/String;
    //   284: astore_1
    //   285: aload_1
    //   286: ldc 30
    //   288: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +28 -> 319
    //   294: aload_0
    //   295: new 207	java/lang/StringBuilder
    //   298: dup
    //   299: ldc 209
    //   301: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload_1
    //   305: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 216
    //   310: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: putfield 200	com/pay/network/model/APMpAns:resultMsg	Ljava/lang/String;
    //   319: ldc 79
    //   321: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: return
    //   325: astore_1
    //   326: ldc 79
    //   328: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: return
    //   332: astore 4
    //   334: goto -152 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	APMpAns
    //   0	337	1	paramArrayOfByte	byte[]
    //   0	337	2	paramAPBaseHttpReq	APBaseHttpReq
    //   97	89	3	i	int
    //   111	50	4	localJSONObject	org.json.JSONObject
    //   332	1	4	localException	java.lang.Exception
    //   120	55	5	localAPProductItem	APProductItem
    // Exception table:
    //   from	to	target	type
    //   39	96	325	java/lang/Exception
    //   98	122	325	java/lang/Exception
    //   189	264	325	java/lang/Exception
    //   265	319	325	java/lang/Exception
    //   122	182	332	java/lang/Exception
  }
  
  public void onReceiveAns(byte[] paramArrayOfByte, int paramInt, long paramLong, APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStartAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void onStopAns(APBaseHttpReq paramAPBaseHttpReq) {}
  
  public void setBeginTime(String paramString)
  {
    this.beginTime = paramString;
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setFirstsave_present_count(String paramString)
  {
    this.firstsave_present_count = paramString;
  }
  
  public void setMpList(List<String> paramList)
  {
    this.mpList = paramList;
  }
  
  public void setMpPresentList(List<String> paramList)
  {
    this.mpPresentList = paramList;
  }
  
  public void setMpValueList(List<String> paramList)
  {
    this.mpValueList = paramList;
  }
  
  public void setRate(String paramString)
  {
    this.rate = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.network.model.APMpAns
 * JD-Core Version:    0.7.0.1
 */