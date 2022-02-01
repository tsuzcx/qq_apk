package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR;
  private final int zzal;
  private final int zzps;
  private final int zzpt;
  private final Uri zzpu;
  
  static
  {
    AppMethodBeat.i(11746);
    CREATOR = new WebImageCreator();
    AppMethodBeat.o(11746);
  }
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.zzal = paramInt1;
    this.zzpu = paramUri;
    this.zzps = paramInt2;
    this.zzpt = paramInt3;
  }
  
  public WebImage(Uri paramUri)
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
  {
    this(1, paramUri, paramInt1, paramInt2);
    AppMethodBeat.i(11738);
    if (paramUri == null)
    {
      paramUri = new IllegalArgumentException("url cannot be null");
      AppMethodBeat.o(11738);
      throw paramUri;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      paramUri = new IllegalArgumentException("width and height must not be negative");
      AppMethodBeat.o(11738);
      throw paramUri;
    }
    AppMethodBeat.o(11738);
  }
  
  public WebImage(JSONObject paramJSONObject)
  {
    this(zza(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
    AppMethodBeat.i(11739);
    AppMethodBeat.o(11739);
  }
  
  private static Uri zza(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(11740);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject.has("url")) {}
    try
    {
      localObject1 = Uri.parse(paramJSONObject.getString("url"));
      AppMethodBeat.o(11740);
      return localObject1;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(11743);
    if (this == paramObject)
    {
      AppMethodBeat.o(11743);
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof WebImage)))
    {
      AppMethodBeat.o(11743);
      return false;
    }
    paramObject = (WebImage)paramObject;
    if ((Objects.equal(this.zzpu, paramObject.zzpu)) && (this.zzps == paramObject.zzps) && (this.zzpt == paramObject.zzpt))
    {
      AppMethodBeat.o(11743);
      return true;
    }
    AppMethodBeat.o(11743);
    return false;
  }
  
  public final int getHeight()
  {
    return this.zzpt;
  }
  
  public final Uri getUrl()
  {
    return this.zzpu;
  }
  
  public final int getWidth()
  {
    return this.zzps;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(11744);
    int i = Objects.hashCode(new Object[] { this.zzpu, Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt) });
    AppMethodBeat.o(11744);
    return i;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(11742);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.zzpu.toString());
      localJSONObject.put("width", this.zzps);
      localJSONObject.put("height", this.zzpt);
      label50:
      AppMethodBeat.o(11742);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label50;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(11741);
    String str = String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt), this.zzpu.toString() });
    AppMethodBeat.o(11741);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11745);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUrl(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 4, getHeight());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(11745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.7.0.1
 */