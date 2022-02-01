package com.tencent.mm.msgsubscription.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "Lcom/tencent/mm/kernel/service/IService;", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", "username", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", "getStorage", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "SubscribeStatusOpCallback", "SubscribeStatusResult", "plugin-comm_release"})
public abstract interface ISubscribeMsgService
  extends com.tencent.mm.kernel.c.a
{
  public static final ISubscribeMsgService.Companion moz = ISubscribeMsgService.Companion.moA;
  
  public abstract boolean YQ(String paramString);
  
  public abstract void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void a(c paramc);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, List<String> paramList, a parama);
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void b(String paramString, a parama);
  
  public abstract SubscribeMsgTmpItem bI(String paramString1, String paramString2);
  
  public abstract void g(String paramString1, String paramString2, long paramLong);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "Landroid/os/Parcelable;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeSwitchOpened", "", "(Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "getSubscribeSwitchOpened", "()Z", "setSubscribeSwitchOpened", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-comm_release"})
  public static final class Companion$SubscribeMsgListWrapper
    implements Parcelable
  {
    public static final ISubscribeMsgService.Companion.SubscribeMsgListWrapper.a CREATOR;
    public List<SubscribeMsgTmpItem> moB;
    public boolean moC;
    
    static
    {
      AppMethodBeat.i(237550);
      CREATOR = new ISubscribeMsgService.Companion.SubscribeMsgListWrapper.a((byte)0);
      AppMethodBeat.o(237550);
    }
    
    public Companion$SubscribeMsgListWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(237547);
      this.moB = ((List)new ArrayList());
      try
      {
        paramParcel.readTypedList(this.moB, SubscribeMsgTmpItem.CREATOR);
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.moC = bool;
          AppMethodBeat.o(237547);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        Log.printErrStackTrace("MicroMsg.SubscribeMsgListWrapper", (Throwable)paramParcel, "alvinluo SubscribeMsgListWrapper read parcel exception and clear storage", new Object[0]);
        paramParcel = b.moG;
        paramParcel = b.YR("name_biz");
        if (paramParcel != null)
        {
          paramParcel = paramParcel.mpb;
          if (paramParcel != null) {
            paramParcel.bsx();
          }
        }
        paramParcel = b.moG;
        paramParcel = b.YR("name_wxa");
        if (paramParcel != null)
        {
          paramParcel = paramParcel.mpb;
          if (paramParcel != null)
          {
            paramParcel.bsx();
            AppMethodBeat.o(237547);
            return;
          }
        }
        AppMethodBeat.o(237547);
      }
    }
    
    public Companion$SubscribeMsgListWrapper(List<SubscribeMsgTmpItem> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(237545);
      this.moB = ((List)new ArrayList());
      this.moB.addAll((Collection)paramList);
      this.moC = paramBoolean;
      AppMethodBeat.o(237545);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(237542);
      p.k(paramParcel, "parcel");
      paramParcel.writeTypedList(this.moB);
      if (this.moC) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(237542);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static abstract interface b
  {
    public abstract void a(String paramString, ISubscribeMsgService.c paramc);
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.ISubscribeMsgService
 * JD-Core Version:    0.7.0.1
 */