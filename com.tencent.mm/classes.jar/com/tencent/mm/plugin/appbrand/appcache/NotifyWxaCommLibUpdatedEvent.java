package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "(Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;)V", "describeContents", "", "publish", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "UpdateResult", "plugin-appbrand-integration_release"})
public final class NotifyWxaCommLibUpdatedEvent
  extends IEvent
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final a nEU;
  public final UpdateResult nET;
  
  static
  {
    AppMethodBeat.i(271596);
    nEU = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(271596);
  }
  
  public NotifyWxaCommLibUpdatedEvent(UpdateResult paramUpdateResult)
  {
    AppMethodBeat.i(271595);
    this.nET = paramUpdateResult;
    AppMethodBeat.o(271595);
  }
  
  public static final void b(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(271599);
    p.k(paramICommLibReader, "reader");
    a(new NotifyWxaCommLibUpdatedEvent((UpdateResult)new NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed(paramICommLibReader)));
    AppMethodBeat.o(271599);
  }
  
  public static final void bGL()
  {
    AppMethodBeat.i(271600);
    a(new NotifyWxaCommLibUpdatedEvent((UpdateResult)new NotifyWxaCommLibUpdatedEvent.UpdateResult.Failed()));
    AppMethodBeat.o(271600);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(271598);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable(this.nET, paramInt);
    AppMethodBeat.o(271598);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "Landroid/os/Parcelable;", "()V", "isSucceed", "", "()Z", "Failed", "Succeed", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Succeed;", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Failed;", "plugin-appbrand-integration_release"})
  public static abstract class UpdateResult
    implements Parcelable
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Failed;", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class Failed
      extends NotifyWxaCommLibUpdatedEvent.UpdateResult
    {
      public static final Parcelable.Creator CREATOR;
      
      static
      {
        AppMethodBeat.i(271686);
        CREATOR = new a();
        AppMethodBeat.o(271686);
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
        AppMethodBeat.i(271685);
        p.k(paramParcel, "parcel");
        paramParcel.writeInt(1);
        AppMethodBeat.o(271685);
      }
      
      @l(iBK={1, 1, 16})
      public static final class a
        implements Parcelable.Creator
      {
        public final Object createFromParcel(Parcel paramParcel)
        {
          AppMethodBeat.i(268426);
          p.k(paramParcel, "in");
          if (paramParcel.readInt() != 0)
          {
            paramParcel = new NotifyWxaCommLibUpdatedEvent.UpdateResult.Failed();
            AppMethodBeat.o(268426);
            return paramParcel;
          }
          AppMethodBeat.o(268426);
          return null;
        }
        
        public final Object[] newArray(int paramInt)
        {
          return new NotifyWxaCommLibUpdatedEvent.UpdateResult.Failed[paramInt];
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult$Succeed;", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$UpdateResult;", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class Succeed
      extends NotifyWxaCommLibUpdatedEvent.UpdateResult
    {
      public static final Parcelable.Creator CREATOR;
      public final ICommLibReader nEV;
      
      static
      {
        AppMethodBeat.i(267396);
        CREATOR = new a();
        AppMethodBeat.o(267396);
      }
      
      public Succeed(ICommLibReader paramICommLibReader)
      {
        super();
        AppMethodBeat.i(267392);
        this.nEV = paramICommLibReader;
        AppMethodBeat.o(267392);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(267395);
        p.k(paramParcel, "parcel");
        paramParcel.writeParcelable(this.nEV, paramInt);
        AppMethodBeat.o(267395);
      }
      
      @l(iBK={1, 1, 16})
      public static final class a
        implements Parcelable.Creator
      {
        public final Object createFromParcel(Parcel paramParcel)
        {
          AppMethodBeat.i(278321);
          p.k(paramParcel, "in");
          paramParcel = new NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed((ICommLibReader)paramParcel.readParcelable(NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed.class.getClassLoader()));
          AppMethodBeat.o(278321);
          return paramParcel;
        }
        
        public final Object[] newArray(int paramInt)
        {
          return new NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed[paramInt];
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent$Companion;", "", "()V", "publishFailed", "", "publishSucceed", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(278028);
      p.k(paramParcel, "in");
      paramParcel = new NotifyWxaCommLibUpdatedEvent((NotifyWxaCommLibUpdatedEvent.UpdateResult)paramParcel.readParcelable(NotifyWxaCommLibUpdatedEvent.class.getClassLoader()));
      AppMethodBeat.o(278028);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new NotifyWxaCommLibUpdatedEvent[paramInt];
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/NotifyWxaCommLibUpdatedEvent;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Parcelable;", "invoke"})
  static final class c<InputType, ResultType>
    implements d<NotifyWxaCommLibUpdatedEvent, Parcelable>
  {
    public static final c nEW;
    
    static
    {
      AppMethodBeat.i(252516);
      nEW = new c();
      AppMethodBeat.o(252516);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent
 * JD-Core Version:    0.7.0.1
 */