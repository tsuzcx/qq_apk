package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator="WebImageCreator")
public final class WebImage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getWidth", id=3)
  private final int zzps;
  @SafeParcelable.Field(getter="getHeight", id=4)
  private final int zzpt;
  @SafeParcelable.Field(getter="getUrl", id=2)
  private final Uri zzpu;
  
  static
  {
    AppMethodBeat.i(61254);
    CREATOR = new WebImageCreator();
    AppMethodBeat.o(61254);
  }
  
  @SafeParcelable.Constructor
  WebImage(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) Uri paramUri, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) int paramInt3)
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
    AppMethodBeat.i(61246);
    if (paramUri == null)
    {
      paramUri = new IllegalArgumentException("url cannot be null");
      AppMethodBeat.o(61246);
      throw paramUri;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      paramUri = new IllegalArgumentException("width and height must not be negative");
      AppMethodBeat.o(61246);
      throw paramUri;
    }
    AppMethodBeat.o(61246);
  }
  
  public WebImage(JSONObject paramJSONObject)
  {
    this(zza(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
    AppMethodBeat.i(61247);
    AppMethodBeat.o(61247);
  }
  
  private static Uri zza(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(61248);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject.has("url")) {}
    try
    {
      localObject1 = Uri.parse(paramJSONObject.getString("url"));
      AppMethodBeat.o(61248);
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
    AppMethodBeat.i(61251);
    if (this == paramObject)
    {
      AppMethodBeat.o(61251);
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof WebImage)))
    {
      AppMethodBeat.o(61251);
      return false;
    }
    paramObject = (WebImage)paramObject;
    if ((Objects.equal(this.zzpu, paramObject.zzpu)) && (this.zzps == paramObject.zzps) && (this.zzpt == paramObject.zzpt))
    {
      AppMethodBeat.o(61251);
      return true;
    }
    AppMethodBeat.o(61251);
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
    AppMethodBeat.i(61252);
    int i = Objects.hashCode(new Object[] { this.zzpu, Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt) });
    AppMethodBeat.o(61252);
    return i;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(61250);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.zzpu.toString());
      localJSONObject.put("width", this.zzps);
      localJSONObject.put("height", this.zzpt);
      label49:
      AppMethodBeat.o(61250);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label49;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61249);
    String str = String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.zzps), Integer.valueOf(this.zzpt), this.zzpu.toString() });
    AppMethodBeat.o(61249);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61253);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUrl(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 4, getHeight());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(61253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.7.0.1
 */