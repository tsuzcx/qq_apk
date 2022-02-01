package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "(Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;)V", "describeContents", "", "internalPublish", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "UpdateResult", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NotifyWxaCommLibUpdatedEvent
  extends IEvent
  implements Parcelable
{
  public static final Parcelable.Creator<NotifyWxaCommLibUpdatedEvent> CREATOR;
  public static final NotifyWxaCommLibUpdatedEvent.a qEQ;
  public final UpdateResult qER;
  
  static
  {
    AppMethodBeat.i(320312);
    qEQ = new NotifyWxaCommLibUpdatedEvent.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(320312);
  }
  
  public NotifyWxaCommLibUpdatedEvent(UpdateResult paramUpdateResult)
  {
    AppMethodBeat.i(320295);
    this.qER = paramUpdateResult;
    AppMethodBeat.o(320295);
  }
  
  private static final void a(NotifyWxaCommLibUpdatedEvent paramNotifyWxaCommLibUpdatedEvent, f paramf)
  {
    AppMethodBeat.i(320304);
    if (paramNotifyWxaCommLibUpdatedEvent != null) {
      paramNotifyWxaCommLibUpdatedEvent.asyncPublish(Looper.getMainLooper());
    }
    AppMethodBeat.o(320304);
  }
  
  public static final void c(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(320306);
    s.u(paramICommLibReader, "reader");
    new NotifyWxaCommLibUpdatedEvent((UpdateResult)new NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed(paramICommLibReader)).cgj();
    AppMethodBeat.o(320306);
  }
  
  private final void cgj()
  {
    AppMethodBeat.i(320300);
    publish();
    Object localObject = h.mDj;
    s.s(localObject, "PROCESS_APPBRAND_SUFFIX_ARRAY");
    localObject = (Object[])localObject;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = (String)localObject[i];
      str = s.X(MMApplicationContext.getApplicationId(), str);
      if (MMApplicationContext.isProcessExist(str)) {
        a.a(str, (Parcelable)this, NotifyWxaCommLibUpdatedEvent..ExternalSyntheticLambda0.INSTANCE);
      }
      i += 1;
    }
    AppMethodBeat.o(320300);
  }
  
  public static final void cgk()
  {
    AppMethodBeat.i(320309);
    new NotifyWxaCommLibUpdatedEvent((UpdateResult)new NotifyWxaCommLibUpdatedEvent.UpdateResult.Failed()).cgj();
    AppMethodBeat.o(320309);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320321);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.qER, paramInt);
    AppMethodBeat.o(320321);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "Landroid/os/Parcelable;", "()V", "isSucceed", "", "()Z", "Failed", "Succeed", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Succeed;", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Failed;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class UpdateResult
    implements Parcelable
  {
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Failed;", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class Failed
      extends NotifyWxaCommLibUpdatedEvent.UpdateResult
    {
      public static final Parcelable.Creator<Failed> CREATOR;
      
      static
      {
        AppMethodBeat.i(320238);
        CREATOR = (Parcelable.Creator)new a();
        AppMethodBeat.o(320238);
      }
      
      public Failed()
      {
        super();
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(320246);
        s.u(paramParcel, "out");
        paramParcel.writeInt(1);
        AppMethodBeat.o(320246);
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      public static final class a
        implements Parcelable.Creator<NotifyWxaCommLibUpdatedEvent.UpdateResult.Failed>
      {}
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Succeed;", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class Succeed
      extends NotifyWxaCommLibUpdatedEvent.UpdateResult
    {
      public static final Parcelable.Creator<Succeed> CREATOR;
      public final ICommLibReader qES;
      
      static
      {
        AppMethodBeat.i(320349);
        CREATOR = (Parcelable.Creator)new a();
        AppMethodBeat.o(320349);
      }
      
      public Succeed(ICommLibReader paramICommLibReader)
      {
        super();
        AppMethodBeat.i(320345);
        this.qES = paramICommLibReader;
        AppMethodBeat.o(320345);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(320356);
        s.u(paramParcel, "out");
        paramParcel.writeParcelable((Parcelable)this.qES, paramInt);
        AppMethodBeat.o(320356);
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      public static final class a
        implements Parcelable.Creator<NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed>
      {}
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<NotifyWxaCommLibUpdatedEvent>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent
 * JD-Core Version:    0.7.0.1
 */