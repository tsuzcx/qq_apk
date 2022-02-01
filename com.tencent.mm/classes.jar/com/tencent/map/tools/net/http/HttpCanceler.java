package com.tencent.map.tools.net.http;

import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HttpCanceler
{
  private Callback<Boolean> mCancelCallback;
  private boolean mCanceled;
  private NetAdapter mConnection;
  
  public void cancel()
  {
    AppMethodBeat.i(172938);
    if ((this.mConnection != null) && (this.mConnection.cancel())) {
      this.mCanceled = true;
    }
    if (this.mCancelCallback != null) {
      this.mCancelCallback.callback(Boolean.valueOf(this.mCanceled));
    }
    AppMethodBeat.o(172938);
  }
  
  public boolean isCanceled()
  {
    return this.mCanceled;
  }
  
  public void setHttpAccessRequest(NetAdapter paramNetAdapter, Callback<Boolean> paramCallback)
  {
    this.mConnection = paramNetAdapter;
    this.mCancelCallback = paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpCanceler
 * JD-Core Version:    0.7.0.1
 */