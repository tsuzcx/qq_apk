package com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;

import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "", "clearToken", "", "getToken", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "getTokenCallback", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$GetTokenCallback;", "saveToken", "token", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$TokenInfo;", "GetTokenCallback", "TokenInfo", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void a(TransferRequestInfo paramTransferRequestInfo, a parama);
  
  public abstract void dgR();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$GetTokenCallback;", "", "onResult", "", "token", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$TokenInfo;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(a.b paramb);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$TokenInfo;", "", "()V", "h5AuthToken", "", "getH5AuthToken", "()Ljava/lang/String;", "setH5AuthToken", "(Ljava/lang/String;)V", "h5AuthTokenExpireTime", "", "getH5AuthTokenExpireTime", "()I", "setH5AuthTokenExpireTime", "(I)V", "copyFrom", "", "token", "isValid", "", "reset", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public String vBk = "";
    int vWe = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a
 * JD-Core Version:    0.7.0.1
 */