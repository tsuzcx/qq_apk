package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class TXHttpRequest
{
  private static final int CON_TIMEOUT = 5000;
  private static final int READ_TIMEOUT = 5000;
  private static final String TAG = "TXHttpRequest";
  private long mNativeHttps = 0L;
  
  public TXHttpRequest(long paramLong)
  {
    this.mNativeHttps = paramLong;
  }
  
  public static byte[] getHttpPostRsp(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146649);
    TXCLog.i("TXHttpRequest", "getHttpPostRsp->request: ".concat(String.valueOf(paramString)));
    TXCLog.i("TXHttpRequest", "getHttpPostRsp->data size: " + paramArrayOfByte.length);
    paramString = (HttpURLConnection)new URL(paramString.replace(" ", "%20")).openConnection();
    paramString.setDoInput(true);
    paramString.setDoOutput(true);
    paramString.setConnectTimeout(5000);
    paramString.setReadTimeout(5000);
    paramString.setRequestMethod("POST");
    Object localObject = new DataOutputStream(paramString.getOutputStream());
    ((DataOutputStream)localObject).write(paramArrayOfByte);
    ((DataOutputStream)localObject).flush();
    ((DataOutputStream)localObject).close();
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      localObject = paramString.getInputStream();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        i = ((InputStream)localObject).read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
      ((InputStream)localObject).close();
      paramString.disconnect();
      TXCLog.i("TXHttpRequest", "getHttpsPostRsp->rsp size: " + localByteArrayOutputStream.size());
      paramString = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(146649);
      return paramString;
    }
    TXCLog.i("TXHttpRequest", "getHttpPostRsp->response code: ".concat(String.valueOf(i)));
    paramString = new Exception("response: ".concat(String.valueOf(i)));
    AppMethodBeat.o(146649);
    throw paramString;
  }
  
  public static byte[] getHttpsPostRsp(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146651);
    TXCLog.i("TXHttpRequest", "getHttpsPostRsp->request: ".concat(String.valueOf(paramString)));
    TXCLog.i("TXHttpRequest", "getHttpsPostRsp->data: " + paramArrayOfByte.length);
    paramString = (HttpsURLConnection)new URL(paramString.replace(" ", "%20")).openConnection();
    paramString.setDoInput(true);
    paramString.setDoOutput(true);
    paramString.setConnectTimeout(5000);
    paramString.setReadTimeout(5000);
    paramString.setRequestMethod("POST");
    Object localObject = new DataOutputStream(paramString.getOutputStream());
    ((DataOutputStream)localObject).write(paramArrayOfByte);
    ((DataOutputStream)localObject).flush();
    ((DataOutputStream)localObject).close();
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      localObject = paramString.getInputStream();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        i = ((InputStream)localObject).read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
      ((InputStream)localObject).close();
      paramString.disconnect();
      TXCLog.i("TXHttpRequest", "getHttpsPostRsp->rsp size: " + localByteArrayOutputStream.size());
      paramString = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(146651);
      return paramString;
    }
    TXCLog.i("TXHttpRequest", "getHttpsPostRsp->response code: ".concat(String.valueOf(i)));
    paramString = new Exception("response: ".concat(String.valueOf(i)));
    AppMethodBeat.o(146651);
    throw paramString;
  }
  
  private native void nativeOnRecvMessage(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public void asyncPostRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(146652);
    new TXHttpRequest.a(this).execute(new byte[][] { paramArrayOfByte1, paramArrayOfByte2 });
    AppMethodBeat.o(146652);
  }
  
  public int sendHttpsRequest(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146650);
    TXCLog.i("TXHttpRequest", "sendHttpsRequest->enter action: " + paramString + ", data size: " + paramArrayOfByte.length);
    asyncPostRequest(paramString.getBytes(), paramArrayOfByte);
    AppMethodBeat.o(146650);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXHttpRequest
 * JD-Core Version:    0.7.0.1
 */