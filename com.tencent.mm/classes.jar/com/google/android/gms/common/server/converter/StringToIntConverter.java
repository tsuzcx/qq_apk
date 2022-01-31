package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@SafeParcelable.Class(creator="StringToIntConverterCreator")
public final class StringToIntConverter
  extends AbstractSafeParcelable
  implements FastJsonResponse.FieldConverter<String, Integer>
{
  public static final Parcelable.Creator<StringToIntConverter> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  private final HashMap<String, Integer> zzwe;
  private final SparseArray<String> zzwf;
  @SafeParcelable.Field(getter="getSerializedMap", id=2)
  private final ArrayList<StringToIntConverter.Entry> zzwg;
  
  static
  {
    AppMethodBeat.i(61458);
    CREATOR = new StringToIntConverterCreator();
    AppMethodBeat.o(61458);
  }
  
  public StringToIntConverter()
  {
    AppMethodBeat.i(61451);
    this.zzal = 1;
    this.zzwe = new HashMap();
    this.zzwf = new SparseArray();
    this.zzwg = null;
    AppMethodBeat.o(61451);
  }
  
  @SafeParcelable.Constructor
  StringToIntConverter(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ArrayList<StringToIntConverter.Entry> paramArrayList)
  {
    AppMethodBeat.i(61450);
    this.zzal = paramInt;
    this.zzwe = new HashMap();
    this.zzwf = new SparseArray();
    this.zzwg = null;
    paramArrayList = (ArrayList)paramArrayList;
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramArrayList.get(paramInt);
      paramInt += 1;
      localObject = (StringToIntConverter.Entry)localObject;
      add(((StringToIntConverter.Entry)localObject).zzwh, ((StringToIntConverter.Entry)localObject).zzwi);
    }
    AppMethodBeat.o(61450);
  }
  
  public final StringToIntConverter add(String paramString, int paramInt)
  {
    AppMethodBeat.i(61452);
    this.zzwe.put(paramString, Integer.valueOf(paramInt));
    this.zzwf.put(paramInt, paramString);
    AppMethodBeat.o(61452);
    return this;
  }
  
  public final Integer convert(String paramString)
  {
    AppMethodBeat.i(61453);
    Integer localInteger = (Integer)this.zzwe.get(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = (Integer)this.zzwe.get("gms_unknown");
    }
    AppMethodBeat.o(61453);
    return paramString;
  }
  
  public final String convertBack(Integer paramInteger)
  {
    AppMethodBeat.i(61454);
    paramInteger = (String)this.zzwf.get(paramInteger.intValue());
    if ((paramInteger == null) && (this.zzwe.containsKey("gms_unknown")))
    {
      AppMethodBeat.o(61454);
      return "gms_unknown";
    }
    AppMethodBeat.o(61454);
    return paramInteger;
  }
  
  public final int getTypeIn()
  {
    return 7;
  }
  
  public final int getTypeOut()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61455);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzwe.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new StringToIntConverter.Entry(str, ((Integer)this.zzwe.get(str)).intValue()));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(61455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter
 * JD-Core Version:    0.7.0.1
 */