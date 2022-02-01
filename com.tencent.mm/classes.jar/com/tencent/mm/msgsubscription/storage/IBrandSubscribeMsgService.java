package com.tencent.mm.msgsubscription.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService;", "Lcom/tencent/mm/kernel/service/IService;", "storage", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "getStorage", "()Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "goToSettingManagerUI", "nickname", "isTemplateMsgSubscribed", "templateId", "saveSubscribeMsgUiStatus", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "switchSubscribeStatus", "tmpItem", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSwitchOpened", "Companion", "SubscribeStatusOpCallback", "SubscribeStatusResult", "plugin-comm_release"})
public abstract interface IBrandSubscribeMsgService
  extends com.tencent.mm.kernel.c.a
{
  public static final IBrandSubscribeMsgService.Companion hHM = IBrandSubscribeMsgService.Companion.hHN;
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract d aEs();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "Landroid/os/Parcelable;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeSwitchOpened", "", "(Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "getSubscribeSwitchOpened", "()Z", "setSubscribeSwitchOpened", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-comm_release"})
  public static final class Companion$SubscribeMsgListWrapper
    implements Parcelable
  {
    public static final a CREATOR;
    public List<SubscribeMsgTmpItem> hHO;
    public boolean hHP;
    
    static
    {
      AppMethodBeat.i(149640);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(149640);
    }
    
    public Companion$SubscribeMsgListWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(149639);
      this.hHO = ((List)new ArrayList());
      try
      {
        paramParcel.readTypedList(this.hHO, SubscribeMsgTmpItem.CREATOR);
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.hHP = bool;
          AppMethodBeat.o(149639);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        ad.printErrStackTrace("MicroMsg.SubscribeMsgListWrapper", (Throwable)paramParcel, "alvinluo SubscribeMsgListWrapper read parcel exception and clear storage", new Object[0]);
        paramParcel = f.hHV;
        paramParcel = f.AN("name_biz");
        if (paramParcel != null)
        {
          paramParcel = paramParcel.aEs();
          if (paramParcel != null) {
            paramParcel.awD();
          }
        }
        paramParcel = f.hHV;
        paramParcel = f.AN("name_wxa");
        if (paramParcel != null)
        {
          paramParcel = paramParcel.aEs();
          if (paramParcel != null)
          {
            paramParcel.awD();
            AppMethodBeat.o(149639);
            return;
          }
        }
        AppMethodBeat.o(149639);
      }
    }
    
    public Companion$SubscribeMsgListWrapper(List<SubscribeMsgTmpItem> paramList, boolean paramBoolean)
    {
      AppMethodBeat.i(149638);
      this.hHO = ((List)new ArrayList());
      this.hHO.addAll((Collection)paramList);
      this.hHP = paramBoolean;
      AppMethodBeat.o(149638);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(149637);
      k.h(paramParcel, "parcel");
      paramParcel.writeTypedList(this.hHO);
      if (this.hHP) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(149637);
        return;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "plugin-comm_release"})
    public static final class a
      implements Parcelable.Creator<IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper>
    {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "plugin-comm_release"})
  public static final class Companion$SubscribeMsgListWrapper$a
    implements Parcelable.Creator<IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper>
  {}
  
  @l(fvt={1, 1, 16})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static abstract interface b
  {
    public abstract void c(String paramString, IBrandSubscribeMsgService.c paramc);
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService
 * JD-Core Version:    0.7.0.1
 */