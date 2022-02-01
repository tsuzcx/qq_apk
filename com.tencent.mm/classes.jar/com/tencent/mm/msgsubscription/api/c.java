package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "buffer", "", "getBuffer", "()[B", "setBuffer", "([B)V", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "extInfo", "getExtInfo", "setExtInfo", "forRequestDialog", "getForRequestDialog", "setForRequestDialog", "replaced", "getReplaced", "setReplaced", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "switchOpened", "getSwitchOpened", "setSwitchOpened", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUiData", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "setUiData", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", "username", "getUsername", "setUsername", "plugin-comm_release"})
public final class c
{
  public String appId;
  public byte[] buffer;
  public String extInfo;
  public List<SubscribeMsgTmpItem> moB;
  public boolean moH;
  public SubscribeMsgRequestDialogUiData moI;
  public boolean moJ;
  public a moK;
  public boolean moL;
  public boolean moM;
  public String username;
  
  public c()
  {
    AppMethodBeat.i(193866);
    this.username = "";
    this.appId = "";
    this.moB = ((List)new ArrayList());
    this.buffer = new byte[] { 0 };
    this.extInfo = "";
    AppMethodBeat.o(193866);
  }
  
  public final void YS(String paramString)
  {
    AppMethodBeat.i(193863);
    p.k(paramString, "<set-?>");
    this.extInfo = paramString;
    AppMethodBeat.o(193863);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(193861);
    p.k(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(193861);
  }
  
  public final void setBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193862);
    p.k(paramArrayOfByte, "<set-?>");
    this.buffer = paramArrayOfByte;
    AppMethodBeat.o(193862);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(193860);
    p.k(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(193860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.c
 * JD-Core Version:    0.7.0.1
 */