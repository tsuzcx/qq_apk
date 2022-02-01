package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public final class OnWXAppResultXPCWrapper<R extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<OnWXAppResultXPCWrapper> CREATOR;
  private final ResultReceiver dK;
  private final b<R> etE;
  
  static
  {
    AppMethodBeat.i(146883);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146883);
  }
  
  private OnWXAppResultXPCWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(146882);
    this.dK = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    this.etE = new b()
    {
      public final void onWXAppResult(R paramAnonymousR)
      {
        AppMethodBeat.i(146872);
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("parcel", new OnWXAppResultXPCWrapper.SafeParcelableWrapper(paramAnonymousR));
        OnWXAppResultXPCWrapper.a(OnWXAppResultXPCWrapper.this).send(-1, localBundle);
        AppMethodBeat.o(146872);
      }
    };
    AppMethodBeat.o(146882);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146881);
    this.dK.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(146881);
  }
  
  static final class SafeParcelableWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<SafeParcelableWrapper> CREATOR;
    private Parcelable etH;
    
    static
    {
      AppMethodBeat.i(146877);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(146877);
    }
    
    SafeParcelableWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(146876);
      String str = paramParcel.readString();
      if (TextUtils.isEmpty(str))
      {
        this.etH = null;
        AppMethodBeat.o(146876);
        return;
      }
      try
      {
        this.etH = paramParcel.readParcelable(Class.forName(str).getClassLoader());
        AppMethodBeat.o(146876);
        return;
      }
      catch (ClassNotFoundException paramParcel)
      {
        Log.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "ClassNotFoundException with %s", new Object[] { str });
        AppMethodBeat.o(146876);
      }
    }
    
    SafeParcelableWrapper(Parcelable paramParcelable)
    {
      this.etH = paramParcelable;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146875);
      if (this.etH == null)
      {
        paramParcel.writeString(null);
        AppMethodBeat.o(146875);
        return;
      }
      paramParcel.writeString(this.etH.getClass().getName());
      paramParcel.writeParcelable(this.etH, paramInt);
      AppMethodBeat.o(146875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper
 * JD-Core Version:    0.7.0.1
 */