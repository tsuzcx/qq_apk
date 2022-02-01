package com.tencent.liteav.basic.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
  
  public static byte[] getHttpPostRsp(Map<String, String> paramMap, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14705);
    TXCLog.i("TXHttpRequest", "getHttpPostRsp->request: ".concat(String.valueOf(paramString)));
    TXCLog.i("TXHttpRequest", "getHttpPostRsp->data size: " + paramArrayOfByte.length);
    paramString = (HttpURLConnection)new URL(paramString.replace(" ", "%20")).openConnection();
    paramString.setDoInput(true);
    paramString.setDoOutput(true);
    paramString.setConnectTimeout(5000);
    paramString.setReadTimeout(5000);
    paramString.setRequestMethod("POST");
    Object localObject;
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramMap = new DataOutputStream(paramString.getOutputStream());
    paramMap.write(paramArrayOfByte);
    paramMap.flush();
    paramMap.close();
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      paramMap = paramString.getInputStream();
      localObject = new ByteArrayOutputStream();
      for (;;)
      {
        i = paramMap.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, 0, i);
      }
      ((ByteArrayOutputStream)localObject).flush();
      paramMap.close();
      paramString.disconnect();
      TXCLog.i("TXHttpRequest", "getHttpsPostRsp->rsp size: " + ((ByteArrayOutputStream)localObject).size());
      paramMap = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(14705);
      return paramMap;
    }
    TXCLog.i("TXHttpRequest", "getHttpPostRsp->response code: ".concat(String.valueOf(i)));
    paramMap = new Exception("response: ".concat(String.valueOf(i)));
    AppMethodBeat.o(14705);
    throw paramMap;
  }
  
  public static byte[] getHttpsPostRsp(Map<String, String> paramMap, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14708);
    TXCLog.i("TXHttpRequest", "getHttpsPostRsp->request: ".concat(String.valueOf(paramString)));
    TXCLog.i("TXHttpRequest", "getHttpsPostRsp->data: " + paramArrayOfByte.length);
    paramString = (HttpsURLConnection)new URL(paramString.replace(" ", "%20")).openConnection();
    paramString.setDoInput(true);
    paramString.setDoOutput(true);
    paramString.setConnectTimeout(5000);
    paramString.setReadTimeout(5000);
    paramString.setRequestMethod("POST");
    Object localObject;
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramMap = new DataOutputStream(paramString.getOutputStream());
    paramMap.write(paramArrayOfByte);
    paramMap.flush();
    paramMap.close();
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      paramMap = paramString.getInputStream();
      localObject = new ByteArrayOutputStream();
      for (;;)
      {
        i = paramMap.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, 0, i);
      }
      ((ByteArrayOutputStream)localObject).flush();
      paramMap.close();
      paramString.disconnect();
      TXCLog.i("TXHttpRequest", "getHttpsPostRsp->rsp size: " + ((ByteArrayOutputStream)localObject).size());
      paramMap = ((ByteArrayOutputStream)localObject).toByteArray();
      AppMethodBeat.o(14708);
      return paramMap;
    }
    TXCLog.i("TXHttpRequest", "getHttpsPostRsp->response code: ".concat(String.valueOf(i)));
    paramMap = new Exception("response: ".concat(String.valueOf(i)));
    AppMethodBeat.o(14708);
    throw paramMap;
  }
  
  private native void nativeOnRecvMessage(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public void asyncPostRequest(Map<String, String> paramMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(14709);
    new a(this, paramMap).execute(new byte[][] { paramArrayOfByte1, paramArrayOfByte2 });
    AppMethodBeat.o(14709);
  }
  
  public int sendHttpsRequest(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14707);
    TXCLog.i("TXHttpRequest", "sendHttpsRequest->enter action: " + paramString + ", data size: " + paramArrayOfByte.length);
    asyncPostRequest(null, paramString.getBytes(), paramArrayOfByte);
    AppMethodBeat.o(14707);
    return 0;
  }
  
  public int sendHttpsRequest(Map<String, String> paramMap, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14706);
    TXCLog.i("TXHttpRequest", "sendHttpsRequest->enter action: " + paramString + ", data size: " + paramArrayOfByte.length);
    asyncPostRequest(paramMap, paramString.getBytes(), paramArrayOfByte);
    AppMethodBeat.o(14706);
    return 0;
  }
  
  static class a
    extends AsyncTask<byte[], Void, TXHttpRequest.b>
  {
    private WeakReference<TXHttpRequest> a;
    private Handler b;
    private Map<String, String> c;
    
    public a(TXHttpRequest paramTXHttpRequest, Map<String, String> paramMap)
    {
      AppMethodBeat.i(14728);
      this.b = null;
      this.c = paramMap;
      this.a = new WeakReference(paramTXHttpRequest);
      paramTXHttpRequest = Looper.myLooper();
      if (paramTXHttpRequest != null)
      {
        this.b = new Handler(paramTXHttpRequest);
        AppMethodBeat.o(14728);
        return;
      }
      this.b = null;
      AppMethodBeat.o(14728);
    }
    
    protected TXHttpRequest.b a(byte[]... paramVarArgs)
    {
      AppMethodBeat.i(14729);
      localb = new TXHttpRequest.b();
      for (;;)
      {
        try
        {
          if (!new String(paramVarArgs[0]).startsWith("https")) {
            continue;
          }
          localb.c = TXHttpRequest.getHttpsPostRsp(this.c, new String(paramVarArgs[0]), paramVarArgs[1]);
          localb.a = 0;
        }
        catch (Exception paramVarArgs)
        {
          localb.b = paramVarArgs.toString();
          localb.a = 1;
          continue;
        }
        TXCLog.i("TXHttpRequest", "TXPostRequest->result: " + localb.a + "|" + localb.b);
        AppMethodBeat.o(14729);
        return localb;
        localb.c = TXHttpRequest.getHttpPostRsp(this.c, new String(paramVarArgs[0]), paramVarArgs[1]);
      }
    }
    
    protected void a(final TXHttpRequest.b paramb)
    {
      AppMethodBeat.i(14730);
      super.onPostExecute(paramb);
      final TXHttpRequest localTXHttpRequest = (TXHttpRequest)this.a.get();
      if ((localTXHttpRequest != null) && (localTXHttpRequest.mNativeHttps != 0L))
      {
        if (this.b != null)
        {
          this.b.post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(14704);
              TXCLog.i("TXHttpRequest", "TXPostRequest->recvMsg: " + paramb.a + "|" + paramb.b);
              TXHttpRequest.access$100(localTXHttpRequest, localTXHttpRequest.mNativeHttps, paramb.a, paramb.c);
              AppMethodBeat.o(14704);
            }
          });
          AppMethodBeat.o(14730);
          return;
        }
        TXCLog.i("TXHttpRequest", "TXPostRequest->recvMsg: " + paramb.a + "|" + paramb.b);
        TXHttpRequest.access$100(localTXHttpRequest, localTXHttpRequest.mNativeHttps, paramb.a, paramb.c);
      }
      AppMethodBeat.o(14730);
    }
  }
  
  static class b
  {
    public int a;
    public String b;
    public byte[] c;
    
    b()
    {
      AppMethodBeat.i(14698);
      this.a = 1;
      this.b = "";
      this.c = "".getBytes();
      AppMethodBeat.o(14698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXHttpRequest
 * JD-Core Version:    0.7.0.1
 */