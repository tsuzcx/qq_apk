package com.tencent.mm.msgsubscription.api;

import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  
  public abstract void j(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.a
 * JD-Core Version:    0.7.0.1
 */