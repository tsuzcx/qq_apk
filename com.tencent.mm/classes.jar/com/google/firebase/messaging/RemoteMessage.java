package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.b.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator="RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR;
  @SafeParcelable.Field(id=2)
  Bundle bKy;
  private Map<String, String> bKz;
  
  static
  {
    AppMethodBeat.i(116787);
    CREATOR = new f();
    AppMethodBeat.o(116787);
  }
  
  @SafeParcelable.Constructor
  public RemoteMessage(@SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.bKy = paramBundle;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(116786);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.bKy, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(116786);
  }
  
  public final Map<String, String> yU()
  {
    AppMethodBeat.i(188618);
    if (this.bKz == null)
    {
      this.bKz = new a();
      localObject1 = this.bKy.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = this.bKy.get(str);
        if ((localObject2 instanceof String))
        {
          localObject2 = (String)localObject2;
          if ((!str.startsWith("google.")) && (!str.startsWith("gcm.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
            this.bKz.put(str, localObject2);
          }
        }
      }
    }
    Object localObject1 = this.bKz;
    AppMethodBeat.o(188618);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.firebase.messaging.RemoteMessage
 * JD-Core Version:    0.7.0.1
 */