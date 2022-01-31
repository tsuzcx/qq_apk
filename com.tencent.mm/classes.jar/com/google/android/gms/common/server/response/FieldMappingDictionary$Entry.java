package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator="FieldMappingDictionaryEntryCreator")
public class FieldMappingDictionary$Entry
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Entry> CREATOR;
  @SafeParcelable.Field(id=2)
  final String className;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=3)
  final ArrayList<FieldMappingDictionary.FieldMapPair> zzxn;
  
  static
  {
    AppMethodBeat.i(61561);
    CREATOR = new FieldMappingDictionaryEntryCreator();
    AppMethodBeat.o(61561);
  }
  
  @SafeParcelable.Constructor
  FieldMappingDictionary$Entry(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
  {
    this.versionCode = paramInt;
    this.className = paramString;
    this.zzxn = paramArrayList;
  }
  
  FieldMappingDictionary$Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    AppMethodBeat.i(61559);
    this.versionCode = 1;
    this.className = paramString;
    if (paramMap == null) {
      paramString = null;
    }
    for (;;)
    {
      this.zzxn = paramString;
      AppMethodBeat.o(61559);
      return;
      paramString = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.add(new FieldMappingDictionary.FieldMapPair(str, (FastJsonResponse.Field)paramMap.get(str)));
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61560);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.className, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzxn, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(61560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary.Entry
 * JD-Core Version:    0.7.0.1
 */