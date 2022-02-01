package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.b.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class RemoteMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR;
  Bundle dEg;
  private Map<String, String> dEh;
  
  static
  {
    AppMethodBeat.i(116787);
    CREATOR = new f();
    AppMethodBeat.o(116787);
  }
  
  public RemoteMessage(Bundle paramBundle)
  {
    this.dEg = paramBundle;
  }
  
  public final Map<String, String> YF()
  {
    AppMethodBeat.i(208658);
    if (this.dEh == null)
    {
      this.dEh = new a();
      localObject1 = this.dEg.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = this.dEg.get(str);
        if ((localObject2 instanceof String))
        {
          localObject2 = (String)localObject2;
          if ((!str.startsWith("google.")) && (!str.startsWith("gcm.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
            this.dEh.put(str, localObject2);
          }
        }
      }
    }
    Object localObject1 = this.dEh;
    AppMethodBeat.o(208658);
    return localObject1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(116786);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.dEg, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(116786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.messaging.RemoteMessage
 * JD-Core Version:    0.7.0.1
 */