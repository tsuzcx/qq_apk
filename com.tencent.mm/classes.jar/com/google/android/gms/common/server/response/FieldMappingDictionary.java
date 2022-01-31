package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator="FieldMappingDictionaryCreator")
public class FieldMappingDictionary
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<FieldMappingDictionary> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzxk;
  @SafeParcelable.Field(getter="getSerializedDictionary", id=2)
  private final ArrayList<FieldMappingDictionary.Entry> zzxl;
  @SafeParcelable.Field(getter="getRootClassName", id=3)
  private final String zzxm;
  
  static
  {
    AppMethodBeat.i(61574);
    CREATOR = new FieldMappingDictionaryCreator();
    AppMethodBeat.o(61574);
  }
  
  @SafeParcelable.Constructor
  FieldMappingDictionary(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ArrayList<FieldMappingDictionary.Entry> paramArrayList, @SafeParcelable.Param(id=3) String paramString)
  {
    AppMethodBeat.i(61564);
    this.zzal = paramInt;
    this.zzxl = null;
    HashMap localHashMap1 = new HashMap();
    int j = paramArrayList.size();
    paramInt = 0;
    while (paramInt < j)
    {
      FieldMappingDictionary.Entry localEntry = (FieldMappingDictionary.Entry)paramArrayList.get(paramInt);
      String str = localEntry.className;
      HashMap localHashMap2 = new HashMap();
      int k = localEntry.zzxn.size();
      int i = 0;
      while (i < k)
      {
        FieldMappingDictionary.FieldMapPair localFieldMapPair = (FieldMappingDictionary.FieldMapPair)localEntry.zzxn.get(i);
        localHashMap2.put(localFieldMapPair.zzxo, localFieldMapPair.zzxp);
        i += 1;
      }
      localHashMap1.put(str, localHashMap2);
      paramInt += 1;
    }
    this.zzxk = localHashMap1;
    this.zzxm = ((String)Preconditions.checkNotNull(paramString));
    linkFields();
    AppMethodBeat.o(61564);
  }
  
  public FieldMappingDictionary(Class<? extends FastJsonResponse> paramClass)
  {
    AppMethodBeat.i(61567);
    this.zzal = 1;
    this.zzxl = null;
    this.zzxk = new HashMap();
    this.zzxm = paramClass.getCanonicalName();
    AppMethodBeat.o(61567);
  }
  
  public void copyInternalFieldMappings()
  {
    AppMethodBeat.i(61566);
    Iterator localIterator1 = this.zzxk.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)this.zzxk.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).copyForDictionary());
      }
      this.zzxk.put(str1, localHashMap);
    }
    AppMethodBeat.o(61566);
  }
  
  @VisibleForTesting
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(Class<? extends FastJsonResponse> paramClass)
  {
    AppMethodBeat.i(61569);
    paramClass = (Map)this.zzxk.get(paramClass.getCanonicalName());
    AppMethodBeat.o(61569);
    return paramClass;
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(String paramString)
  {
    AppMethodBeat.i(61570);
    paramString = (Map)this.zzxk.get(paramString);
    AppMethodBeat.o(61570);
    return paramString;
  }
  
  public String getRootClassName()
  {
    return this.zzxm;
  }
  
  public boolean hasFieldMappingForClass(Class<? extends FastJsonResponse> paramClass)
  {
    AppMethodBeat.i(61571);
    boolean bool = this.zzxk.containsKey(paramClass.getCanonicalName());
    AppMethodBeat.o(61571);
    return bool;
  }
  
  public void linkFields()
  {
    AppMethodBeat.i(61565);
    Iterator localIterator1 = this.zzxk.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)this.zzxk.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).setFieldMappingDictionary(this);
      }
    }
    AppMethodBeat.o(61565);
  }
  
  public void put(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    AppMethodBeat.i(61568);
    this.zzxk.put(paramClass.getCanonicalName(), paramMap);
    AppMethodBeat.o(61568);
  }
  
  public String toString()
  {
    AppMethodBeat.i(61572);
    Object localObject1 = new StringBuilder();
    Iterator localIterator1 = this.zzxk.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject2 = (String)localIterator1.next();
      ((StringBuilder)localObject1).append((String)localObject2).append(":\n");
      localObject2 = (Map)this.zzxk.get(localObject2);
      Iterator localIterator2 = ((Map)localObject2).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        ((StringBuilder)localObject1).append("  ").append(str).append(": ");
        ((StringBuilder)localObject1).append(((Map)localObject2).get(str));
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(61572);
    return localObject1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61573);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzxk.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new FieldMappingDictionary.Entry(str, (Map)this.zzxk.get(str)));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.writeString(paramParcel, 3, getRootClassName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(61573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary
 * JD-Core Version:    0.7.0.1
 */