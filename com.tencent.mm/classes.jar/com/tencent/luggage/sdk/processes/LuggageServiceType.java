package com.tencent.luggage.sdk.processes;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "serializeTo", "Landroid/content/Intent;", "intent", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "WASERVICE", "WAGAME", "NIL", "Companion", "luggage-wechat-full-sdk_release"})
public enum LuggageServiceType
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final a cBT;
  
  static
  {
    AppMethodBeat.i(234211);
    LuggageServiceType localLuggageServiceType1 = new LuggageServiceType("WASERVICE", 0);
    cBP = localLuggageServiceType1;
    LuggageServiceType localLuggageServiceType2 = new LuggageServiceType("WAGAME", 1);
    cBQ = localLuggageServiceType2;
    LuggageServiceType localLuggageServiceType3 = new LuggageServiceType("NIL", 2);
    cBR = localLuggageServiceType3;
    cBS = new LuggageServiceType[] { localLuggageServiceType1, localLuggageServiceType2, localLuggageServiceType3 };
    cBT = new a((byte)0);
    CREATOR = new LuggageServiceType.b();
    AppMethodBeat.o(234211);
  }
  
  private LuggageServiceType() {}
  
  public static final LuggageServiceType cj(boolean paramBoolean)
  {
    AppMethodBeat.i(234222);
    LuggageServiceType localLuggageServiceType = a.cj(paramBoolean);
    AppMethodBeat.o(234222);
    return localLuggageServiceType;
  }
  
  public static final LuggageServiceType j(Intent paramIntent)
  {
    AppMethodBeat.i(234224);
    p.k(paramIntent, "intent");
    int i = paramIntent.getIntExtra("Luggage.LuggageServiceType", cBR.ordinal());
    paramIntent = values()[i];
    AppMethodBeat.o(234224);
    return paramIntent;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(234221);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(name());
    AppMethodBeat.o(234221);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageServiceType$Companion;", "", "()V", "TAG", "", "deserializeFrom", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "intent", "Landroid/content/Intent;", "deserializeFromIsGame", "isGame", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static LuggageServiceType cj(boolean paramBoolean)
    {
      if (paramBoolean) {
        return LuggageServiceType.cBQ;
      }
      return LuggageServiceType.cBP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.LuggageServiceType
 * JD-Core Version:    0.7.0.1
 */