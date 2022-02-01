package com.tencent.luggage.sdk.processes;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "serializeTo", "Landroid/content/Intent;", "intent", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "WASERVICE", "WAGAME", "NIL", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum LuggageServiceType
  implements Parcelable
{
  public static final Parcelable.Creator<LuggageServiceType> CREATOR;
  public static final a euu;
  
  static
  {
    AppMethodBeat.i(220457);
    euv = new LuggageServiceType("WASERVICE", 0);
    euw = new LuggageServiceType("WAGAME", 1);
    eux = new LuggageServiceType("NIL", 2);
    euy = new LuggageServiceType[] { euv, euw, eux };
    euu = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(220457);
  }
  
  private LuggageServiceType() {}
  
  public static final LuggageServiceType cQ(boolean paramBoolean)
  {
    AppMethodBeat.i(220445);
    LuggageServiceType localLuggageServiceType = a.cQ(paramBoolean);
    AppMethodBeat.o(220445);
    return localLuggageServiceType;
  }
  
  public static final LuggageServiceType k(Intent paramIntent)
  {
    AppMethodBeat.i(220451);
    s.u(paramIntent, "intent");
    int i = paramIntent.getIntExtra("Luggage.LuggageServiceType", eux.ordinal());
    paramIntent = values()[i];
    AppMethodBeat.o(220451);
    return paramIntent;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220469);
    s.u(paramParcel, "out");
    paramParcel.writeString(name());
    AppMethodBeat.o(220469);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageServiceType$Companion;", "", "()V", "TAG", "", "deserializeFrom", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "intent", "Landroid/content/Intent;", "deserializeFromIsGame", "isGame", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static LuggageServiceType cQ(boolean paramBoolean)
    {
      if (paramBoolean) {
        return LuggageServiceType.euw;
      }
      return LuggageServiceType.euv;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<LuggageServiceType>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.LuggageServiceType
 * JD-Core Version:    0.7.0.1
 */