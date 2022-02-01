package com.tencent.mm.plugin.findersdk.b;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "T", "", "errType", "", "errCode", "errMsg", "", "response", "updateTimeMs", "", "(IILjava/lang/String;Ljava/lang/Object;J)V", "getErrCode", "()I", "setErrCode", "(I)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getErrType", "setErrType", "getResponse", "()Ljava/lang/Object;", "setResponse", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getUpdateTimeMs", "()J", "setUpdateTimeMs", "(J)V", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<T>
{
  public int errCode;
  public String errMsg;
  public int errType;
  public T hKP;
  public long zIH;
  
  public i(int paramInt1, int paramInt2, String paramString, T paramT, long paramLong)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.hKP = paramT;
    this.zIH = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.i
 * JD-Core Version:    0.7.0.1
 */