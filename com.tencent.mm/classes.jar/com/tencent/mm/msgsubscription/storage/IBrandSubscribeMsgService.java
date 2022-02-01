package com.tencent.mm.msgsubscription.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService;", "Lcom/tencent/mm/kernel/service/IService;", "storage", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "getStorage", "()Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "goToSettingManagerUI", "nickname", "isTemplateMsgSubscribed", "templateId", "saveSubscribeMsgUiStatus", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "switchSubscribeStatus", "tmpItem", "callback", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSwitchOpened", "Companion", "SubscribeStatusOpCallback", "SubscribeStatusResult", "plugin-comm_release"})
public abstract interface IBrandSubscribeMsgService
  extends com.tencent.mm.kernel.c.a
{
  public static final IBrandSubscribeMsgService.Companion iEB = IBrandSubscribeMsgService.Companion.iEC;
  
  public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract d aOQ();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "Landroid/os/Parcelable;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeSwitchOpened", "", "(Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "getSubscribeSwitchOpened", "()Z", "setSubscribeSwitchOpened", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-comm_release"})
  public static final class Companion$SubscribeMsgListWrapper
    implements Parcelable
  {
    public static final a CREATOR;
    public List<SubscribeMsgTmpItem> iED;
    public boolean iEE;
    
    static
    {
      AppMethodBeat.i(149640);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(149640);
    }
    
    public Companion$SubscribeMsgListWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(149639);
      this.iED = ((List)new ArrayList());
      try
      {
        paramParcel.readTypedList(this.iED, SubscribeMsgTmpItem.CREATOR);
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.iEE = bool;
          AppMethodBeat.o(149639);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        ae.printErrStackTrace("MicroMsg.SubscribeMsgListWrapper", (Throwable)paramParcel, "alvinluo SubscribeMsgListWrapper read parcel exception and clear storage", new Object[0]);
        paramParcel = f.iEK;
        paramParcel = f.II("name_biz");
        if (paramParcel != null)
        {
          paramParcel = paramParcel.aOQ();
          if (paramParcel != null) {
            paramParcel.aGO();
          }
        }
        paramParcel = f.iEK;
        paramParcel = f.II("name_wxa");
        if (paramParcel != null)
        {
          paramParcel = paramParcel.aOQ();
          if (paramParcel != null)
          {
            paramParcel.aGO();
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
      this.iED = ((List)new ArrayList());
      this.iED.addAll((Collection)paramList);
      this.iEE = paramBoolean;
      AppMethodBeat.o(149638);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(149637);
      p.h(paramParcel, "parcel");
      paramParcel.writeTypedList(this.iED);
      if (this.iEE) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(149637);
        return;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "plugin-comm_release"})
    public static final class a
      implements Parcelable.Creator<IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$Companion$SubscribeMsgListWrapper;", "plugin-comm_release"})
  public static final class Companion$SubscribeMsgListWrapper$a
    implements Parcelable.Creator<IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper>
  {}
  
  @l(gjZ={1, 1, 16})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusOpCallback;", "", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static abstract interface b
  {
    public abstract void c(String paramString, IBrandSubscribeMsgService.c paramc);
    
    public abstract void onError();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgService$SubscribeStatusResult;", "", "isSubscribed", "", "isSwitchOpened", "(ZZ)V", "()Z", "setSubscribed", "(Z)V", "setSwitchOpened", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-comm_release"})
  public static final class c
  {
    public boolean iEF;
    public boolean iEG;
    
    public c(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.iEF = paramBoolean1;
      this.iEG = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.iEF != paramObject.iEF) || (this.iEG != paramObject.iEG)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(149643);
      String str = "SubscribeStatusResult(isSubscribed=" + this.iEF + ", isSwitchOpened=" + this.iEG + ")";
      AppMethodBeat.o(149643);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService
 * JD-Core Version:    0.7.0.1
 */