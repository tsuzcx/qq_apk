package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "buffer", "", "getBuffer", "()[B", "setBuffer", "([B)V", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "extInfo", "getExtInfo", "setExtInfo", "forRequestDialog", "getForRequestDialog", "setForRequestDialog", "replaced", "getReplaced", "setReplaced", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "switchOpened", "getSwitchOpened", "setSwitchOpened", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUiData", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "setUiData", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", "username", "getUsername", "setUsername", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public String appId;
  public byte[] buffer;
  public String extInfo;
  public boolean piA;
  public a piB;
  public boolean piC;
  public boolean piD;
  public List<SubscribeMsgTmpItem> pis;
  public boolean piy;
  public SubscribeMsgRequestDialogUiData piz;
  public String username;
  
  public c()
  {
    AppMethodBeat.i(236663);
    this.username = "";
    this.appId = "";
    this.pis = ((List)new ArrayList());
    this.buffer = new byte[] { 0 };
    this.extInfo = "";
    AppMethodBeat.o(236663);
  }
  
  public final void QX(String paramString)
  {
    AppMethodBeat.i(236685);
    s.u(paramString, "<set-?>");
    this.extInfo = paramString;
    AppMethodBeat.o(236685);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(236675);
    s.u(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(236675);
  }
  
  public final void setBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236680);
    s.u(paramArrayOfByte, "<set-?>");
    this.buffer = paramArrayOfByte;
    AppMethodBeat.o(236680);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(236670);
    s.u(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(236670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.c
 * JD-Core Version:    0.7.0.1
 */