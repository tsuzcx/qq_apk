package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  extends AbstractSafeParcelable
  implements FastJsonResponse.FieldConverter<String, Integer>
{
  public static final Parcelable.Creator<StringToIntConverter> CREATOR;
  private final int zzal;
  private final HashMap<String, Integer> zzwe;
  private final SparseArray<String> zzwf;
  private final ArrayList<Entry> zzwg;
  
  static
  {
    AppMethodBeat.i(11950);
    CREATOR = new StringToIntConverterCreator();
    AppMethodBeat.o(11950);
  }
  
  public StringToIntConverter()
  {
    AppMethodBeat.i(11943);
    this.zzal = 1;
    this.zzwe = new HashMap();
    this.zzwf = new SparseArray();
    this.zzwg = null;
    AppMethodBeat.o(11943);
  }
  
  StringToIntConverter(int paramInt, ArrayList<Entry> paramArrayList)
  {
    AppMethodBeat.i(11942);
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
      localObject = (Entry)localObject;
      add(((Entry)localObject).zzwh, ((Entry)localObject).zzwi);
    }
    AppMethodBeat.o(11942);
  }
  
  public final StringToIntConverter add(String paramString, int paramInt)
  {
    AppMethodBeat.i(11944);
    this.zzwe.put(paramString, Integer.valueOf(paramInt));
    this.zzwf.put(paramInt, paramString);
    AppMethodBeat.o(11944);
    return this;
  }
  
  public final Integer convert(String paramString)
  {
    AppMethodBeat.i(11945);
    Integer localInteger = (Integer)this.zzwe.get(paramString);
    paramString = localInteger;
    if (localInteger == null) {
      paramString = (Integer)this.zzwe.get("gms_unknown");
    }
    AppMethodBeat.o(11945);
    return paramString;
  }
  
  public final String convertBack(Integer paramInteger)
  {
    AppMethodBeat.i(11946);
    paramInteger = (String)this.zzwf.get(paramInteger.intValue());
    if ((paramInteger == null) && (this.zzwe.containsKey("gms_unknown")))
    {
      AppMethodBeat.o(11946);
      return "gms_unknown";
    }
    AppMethodBeat.o(11946);
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
    AppMethodBeat.i(11947);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzwe.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, ((Integer)this.zzwe.get(str)).intValue()));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(11947);
  }
  
  public static final class Entry
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Entry> CREATOR;
    private final int versionCode;
    final String zzwh;
    final int zzwi;
    
    static
    {
      AppMethodBeat.i(11941);
      CREATOR = new StringToIntConverterEntryCreator();
      AppMethodBeat.o(11941);
    }
    
    Entry(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.zzwh = paramString;
      this.zzwi = paramInt2;
    }
    
    Entry(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.zzwh = paramString;
      this.zzwi = paramInt;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(11940);
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
      SafeParcelWriter.writeString(paramParcel, 2, this.zzwh, false);
      SafeParcelWriter.writeInt(paramParcel, 3, this.zzwi);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
      AppMethodBeat.o(11940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter
 * JD-Core Version:    0.7.0.1
 */