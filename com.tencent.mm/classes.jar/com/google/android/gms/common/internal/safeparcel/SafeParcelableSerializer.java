package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
public final class SafeParcelableSerializer
{
  public static <T extends SafeParcelable> T deserializeFromBytes(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89852);
    Preconditions.checkNotNull(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(89852);
    return paramArrayOfByte;
  }
  
  public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89858);
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null)
    {
      AppMethodBeat.o(89858);
      return null;
    }
    paramIntent = deserializeFromBytes(paramIntent, paramCreator);
    AppMethodBeat.o(89858);
    return paramIntent;
  }
  
  public static <T extends SafeParcelable> T deserializeFromString(String paramString, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89856);
    paramString = deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
    AppMethodBeat.o(89856);
    return paramString;
  }
  
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89854);
    paramString = (ArrayList)paramBundle.getSerializable(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(89854);
      return null;
    }
    paramBundle = new ArrayList(paramString.size());
    paramString = (ArrayList)paramString;
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString.get(i);
      i += 1;
      paramBundle.add(deserializeFromBytes((byte[])localObject, paramCreator));
    }
    AppMethodBeat.o(89854);
    return paramBundle;
  }
  
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89860);
    paramString = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(89860);
      return null;
    }
    paramIntent = new ArrayList(paramString.size());
    paramString = (ArrayList)paramString;
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString.get(i);
      i += 1;
      paramIntent.add(deserializeFromBytes((byte[])localObject, paramCreator));
    }
    AppMethodBeat.o(89860);
    return paramIntent;
  }
  
  public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> paramIterable, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(89853);
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(serializeToBytes((SafeParcelable)paramIterable.next()));
    }
    paramBundle.putSerializable(paramString, localArrayList);
    AppMethodBeat.o(89853);
  }
  
  public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> paramIterable, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(89859);
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(serializeToBytes((SafeParcelable)paramIterable.next()));
    }
    paramIntent.putExtra(paramString, localArrayList);
    AppMethodBeat.o(89859);
  }
  
  public static <T extends SafeParcelable> byte[] serializeToBytes(T paramT)
  {
    AppMethodBeat.i(89851);
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = localParcel.marshall();
    localParcel.recycle();
    AppMethodBeat.o(89851);
    return paramT;
  }
  
  public static <T extends SafeParcelable> void serializeToIntentExtra(T paramT, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(89857);
    paramIntent.putExtra(paramString, serializeToBytes(paramT));
    AppMethodBeat.o(89857);
  }
  
  public static <T extends SafeParcelable> String serializeToString(T paramT)
  {
    AppMethodBeat.i(89855);
    paramT = Base64Utils.encodeUrlSafe(serializeToBytes(paramT));
    AppMethodBeat.o(89855);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer
 * JD-Core Version:    0.7.0.1
 */