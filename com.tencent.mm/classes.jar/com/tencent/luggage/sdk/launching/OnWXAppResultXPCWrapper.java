package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class OnWXAppResultXPCWrapper<R extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<OnWXAppResultXPCWrapper> CREATOR;
  private final ResultReceiver MU;
  private final a<R> cBx;
  
  static
  {
    AppMethodBeat.i(146883);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146883);
  }
  
  private OnWXAppResultXPCWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(146882);
    this.MU = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    this.cBx = new a()
    {
      public final void b(R paramAnonymousR)
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
  
  private OnWXAppResultXPCWrapper(final a<R> parama)
  {
    AppMethodBeat.i(146880);
    this.cBx = parama;
    this.MU = new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(146871);
        if (paramAnonymousBundle == null)
        {
          parama.b(null);
          AppMethodBeat.o(146871);
          return;
        }
        paramAnonymousBundle.setClassLoader(OnWXAppResultXPCWrapper.SafeParcelableWrapper.class.getClassLoader());
        try
        {
          parama.b(OnWXAppResultXPCWrapper.SafeParcelableWrapper.a((OnWXAppResultXPCWrapper.SafeParcelableWrapper)paramAnonymousBundle.getParcelable("parcel")));
          AppMethodBeat.o(146871);
          return;
        }
        catch (NullPointerException paramAnonymousBundle)
        {
          Log.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "onReceiveResult, e = %s", new Object[] { paramAnonymousBundle });
          parama.b(null);
          AppMethodBeat.o(146871);
          return;
        }
        catch (ClassCastException paramAnonymousBundle)
        {
          label62:
          break label62;
        }
      }
    };
    AppMethodBeat.o(146880);
  }
  
  public static <R extends Parcelable> a<R> a(Parcel paramParcel)
  {
    AppMethodBeat.i(146879);
    paramParcel = (OnWXAppResultXPCWrapper)paramParcel.readParcelable(OnWXAppResultXPCWrapper.class.getClassLoader());
    if (paramParcel != null) {}
    for (paramParcel = paramParcel.cBx;; paramParcel = null)
    {
      AppMethodBeat.o(146879);
      return paramParcel;
    }
  }
  
  public static <R extends Parcelable> void a(a<R> parama, Parcel paramParcel)
  {
    AppMethodBeat.i(146878);
    if (parama == null)
    {
      paramParcel.writeString(null);
      AppMethodBeat.o(146878);
      return;
    }
    paramParcel.writeParcelable(new OnWXAppResultXPCWrapper(parama), 0);
    AppMethodBeat.o(146878);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146881);
    this.MU.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(146881);
  }
  
  static final class SafeParcelableWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<SafeParcelableWrapper> CREATOR;
    private Parcelable cBA;
    
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
        this.cBA = null;
        AppMethodBeat.o(146876);
        return;
      }
      try
      {
        this.cBA = paramParcel.readParcelable(Class.forName(str).getClassLoader());
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
      this.cBA = paramParcelable;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(146875);
      if (this.cBA == null)
      {
        paramParcel.writeString(null);
        AppMethodBeat.o(146875);
        return;
      }
      paramParcel.writeString(this.cBA.getClass().getName());
      paramParcel.writeParcelable(this.cBA, paramInt);
      AppMethodBeat.o(146875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper
 * JD-Core Version:    0.7.0.1
 */