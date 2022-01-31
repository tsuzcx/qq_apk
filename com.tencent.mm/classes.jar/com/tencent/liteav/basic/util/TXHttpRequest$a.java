package com.tencent.liteav.basic.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class TXHttpRequest$a
  extends AsyncTask<byte[], Void, TXHttpRequest.b>
{
  private WeakReference<TXHttpRequest> a;
  private Handler b;
  
  public TXHttpRequest$a(TXHttpRequest paramTXHttpRequest)
  {
    AppMethodBeat.i(146628);
    this.b = null;
    this.a = new WeakReference(paramTXHttpRequest);
    paramTXHttpRequest = Looper.myLooper();
    if (paramTXHttpRequest != null)
    {
      this.b = new Handler(paramTXHttpRequest);
      AppMethodBeat.o(146628);
      return;
    }
    this.b = null;
    AppMethodBeat.o(146628);
  }
  
  protected TXHttpRequest.b a(byte[]... paramVarArgs)
  {
    AppMethodBeat.i(146629);
    localb = new TXHttpRequest.b();
    for (;;)
    {
      try
      {
        if (!new String(paramVarArgs[0]).startsWith("https")) {
          continue;
        }
        localb.c = TXHttpRequest.getHttpsPostRsp(new String(paramVarArgs[0]), paramVarArgs[1]);
        localb.a = 0;
      }
      catch (Exception paramVarArgs)
      {
        localb.b = paramVarArgs.toString();
        continue;
      }
      TXCLog.i("TXHttpRequest", "TXPostRequest->result: " + localb.a + "|" + localb.b);
      AppMethodBeat.o(146629);
      return localb;
      localb.c = TXHttpRequest.getHttpPostRsp(new String(paramVarArgs[0]), paramVarArgs[1]);
    }
  }
  
  protected void a(TXHttpRequest.b paramb)
  {
    AppMethodBeat.i(146630);
    super.onPostExecute(paramb);
    TXHttpRequest localTXHttpRequest = (TXHttpRequest)this.a.get();
    if ((localTXHttpRequest != null) && (TXHttpRequest.access$000(localTXHttpRequest) != 0L))
    {
      if (this.b != null)
      {
        this.b.post(new TXHttpRequest.a.1(this, localTXHttpRequest, paramb));
        AppMethodBeat.o(146630);
        return;
      }
      TXHttpRequest.access$100(localTXHttpRequest, TXHttpRequest.access$000(localTXHttpRequest), paramb.a, paramb.c);
    }
    AppMethodBeat.o(146630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXHttpRequest.a
 * JD-Core Version:    0.7.0.1
 */