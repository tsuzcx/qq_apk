package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SafeParcelable.Class(creator="SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse
  extends FastSafeParcelableJsonResponse
{
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR;
  private final String mClassName;
  @SafeParcelable.VersionField(getter="getVersionCode", id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getFieldMappingDictionary", id=3)
  private final FieldMappingDictionary zzwn;
  @SafeParcelable.Field(getter="getParcel", id=2)
  private final Parcel zzxq;
  private final int zzxr;
  private int zzxs;
  private int zzxt;
  
  static
  {
    AppMethodBeat.i(61622);
    CREATOR = new SafeParcelResponseCreator();
    AppMethodBeat.o(61622);
  }
  
  @SafeParcelable.Constructor
  SafeParcelResponse(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) Parcel paramParcel, @SafeParcelable.Param(id=3) FieldMappingDictionary paramFieldMappingDictionary)
  {
    AppMethodBeat.i(61589);
    this.zzal = paramInt;
    this.zzxq = ((Parcel)Preconditions.checkNotNull(paramParcel));
    this.zzxr = 2;
    this.zzwn = paramFieldMappingDictionary;
    if (this.zzwn == null) {}
    for (this.mClassName = null;; this.mClassName = this.zzwn.getRootClassName())
    {
      this.zzxs = 2;
      AppMethodBeat.o(61589);
      return;
    }
  }
  
  private SafeParcelResponse(SafeParcelable paramSafeParcelable, FieldMappingDictionary paramFieldMappingDictionary, String paramString)
  {
    AppMethodBeat.i(61583);
    this.zzal = 1;
    this.zzxq = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.zzxq, 0);
    this.zzxr = 1;
    this.zzwn = ((FieldMappingDictionary)Preconditions.checkNotNull(paramFieldMappingDictionary));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zzxs = 2;
    AppMethodBeat.o(61583);
  }
  
  public SafeParcelResponse(FieldMappingDictionary paramFieldMappingDictionary)
  {
    this(paramFieldMappingDictionary, paramFieldMappingDictionary.getRootClassName());
    AppMethodBeat.i(61581);
    AppMethodBeat.o(61581);
  }
  
  public SafeParcelResponse(FieldMappingDictionary paramFieldMappingDictionary, String paramString)
  {
    AppMethodBeat.i(61582);
    this.zzal = 1;
    this.zzxq = Parcel.obtain();
    this.zzxr = 0;
    this.zzwn = ((FieldMappingDictionary)Preconditions.checkNotNull(paramFieldMappingDictionary));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zzxs = 0;
    AppMethodBeat.o(61582);
  }
  
  public static HashMap<String, String> convertBundleToStringMap(Bundle paramBundle)
  {
    AppMethodBeat.i(61620);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    AppMethodBeat.o(61620);
    return localHashMap;
  }
  
  public static Bundle convertStringMapToBundle(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(61621);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)paramHashMap.get(str));
    }
    AppMethodBeat.o(61621);
    return localBundle;
  }
  
  public static <T extends FastJsonResponse,  extends SafeParcelable> SafeParcelResponse from(T paramT)
  {
    AppMethodBeat.i(61584);
    String str = paramT.getClass().getCanonicalName();
    FieldMappingDictionary localFieldMappingDictionary = zza(paramT);
    paramT = new SafeParcelResponse((SafeParcelable)paramT, localFieldMappingDictionary, str);
    AppMethodBeat.o(61584);
    return paramT;
  }
  
  public static FieldMappingDictionary generateDictionary(Class<? extends FastJsonResponse> paramClass)
  {
    AppMethodBeat.i(61588);
    try
    {
      FieldMappingDictionary localFieldMappingDictionary = zza((FastJsonResponse)paramClass.newInstance());
      AppMethodBeat.o(61588);
      return localFieldMappingDictionary;
    }
    catch (InstantiationException localInstantiationException)
    {
      paramClass = String.valueOf(paramClass.getCanonicalName());
      if (paramClass.length() != 0) {}
      for (paramClass = "Could not instantiate an object of type ".concat(paramClass);; paramClass = new String("Could not instantiate an object of type "))
      {
        paramClass = new IllegalStateException(paramClass, localInstantiationException);
        AppMethodBeat.o(61588);
        throw paramClass;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramClass = String.valueOf(paramClass.getCanonicalName());
      if (paramClass.length() == 0) {}
    }
    for (paramClass = "Could not access object of type ".concat(paramClass);; paramClass = new String("Could not access object of type "))
    {
      paramClass = new IllegalStateException(paramClass, localIllegalAccessException);
      AppMethodBeat.o(61588);
      throw paramClass;
    }
  }
  
  private static FieldMappingDictionary zza(FastJsonResponse paramFastJsonResponse)
  {
    AppMethodBeat.i(61585);
    FieldMappingDictionary localFieldMappingDictionary = new FieldMappingDictionary(paramFastJsonResponse.getClass());
    zza(localFieldMappingDictionary, paramFastJsonResponse);
    localFieldMappingDictionary.copyInternalFieldMappings();
    localFieldMappingDictionary.linkFields();
    AppMethodBeat.o(61585);
    return localFieldMappingDictionary;
  }
  
  private static void zza(FieldMappingDictionary paramFieldMappingDictionary, FastJsonResponse paramFastJsonResponse)
  {
    AppMethodBeat.i(61586);
    Object localObject = paramFastJsonResponse.getClass();
    if (!paramFieldMappingDictionary.hasFieldMappingForClass((Class)localObject))
    {
      Map localMap = paramFastJsonResponse.getFieldMappings();
      paramFieldMappingDictionary.put((Class)localObject, localMap);
      localObject = localMap.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label207;
        }
        paramFastJsonResponse = (FastJsonResponse.Field)localMap.get((String)((Iterator)localObject).next());
        Class localClass = paramFastJsonResponse.getConcreteType();
        if (localClass != null) {
          try
          {
            zza(paramFieldMappingDictionary, (FastJsonResponse)localClass.newInstance());
          }
          catch (InstantiationException localInstantiationException)
          {
            paramFieldMappingDictionary = String.valueOf(paramFastJsonResponse.getConcreteType().getCanonicalName());
            if (paramFieldMappingDictionary.length() != 0) {}
            for (paramFieldMappingDictionary = "Could not instantiate an object of type ".concat(paramFieldMappingDictionary);; paramFieldMappingDictionary = new String("Could not instantiate an object of type "))
            {
              paramFieldMappingDictionary = new IllegalStateException(paramFieldMappingDictionary, localInstantiationException);
              AppMethodBeat.o(61586);
              throw paramFieldMappingDictionary;
            }
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            paramFieldMappingDictionary = String.valueOf(paramFastJsonResponse.getConcreteType().getCanonicalName());
            if (paramFieldMappingDictionary.length() == 0) {}
          }
        }
      }
      for (paramFieldMappingDictionary = "Could not access object of type ".concat(paramFieldMappingDictionary);; paramFieldMappingDictionary = new String("Could not access object of type "))
      {
        paramFieldMappingDictionary = new IllegalStateException(paramFieldMappingDictionary, localIllegalAccessException);
        AppMethodBeat.o(61586);
        throw paramFieldMappingDictionary;
      }
    }
    label207:
    AppMethodBeat.o(61586);
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(61619);
    switch (paramInt)
    {
    default: 
      paramStringBuilder = new IllegalArgumentException(26 + "Unknown type = " + paramInt);
      AppMethodBeat.o(61619);
      throw paramStringBuilder;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      AppMethodBeat.o(61619);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(JsonUtils.escapeString(paramObject.toString())).append("\"");
      AppMethodBeat.o(61619);
      return;
    case 8: 
      paramStringBuilder.append("\"").append(Base64Utils.encode((byte[])paramObject)).append("\"");
      AppMethodBeat.o(61619);
      return;
    case 9: 
      paramStringBuilder.append("\"").append(Base64Utils.encodeUrlSafe((byte[])paramObject));
      paramStringBuilder.append("\"");
      AppMethodBeat.o(61619);
      return;
    case 10: 
      MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)paramObject);
      AppMethodBeat.o(61619);
      return;
    }
    paramStringBuilder = new IllegalArgumentException("Method does not accept concrete type.");
    AppMethodBeat.o(61619);
    throw paramStringBuilder;
  }
  
  private final void zza(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    AppMethodBeat.i(61617);
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    Object localObject;
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      localSparseArray.put(((FastJsonResponse.Field)((Map.Entry)localObject).getValue()).getSafeParcelableFieldId(), localObject);
    }
    paramStringBuilder.append('{');
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      paramMap = (Map.Entry)localSparseArray.get(SafeParcelReader.getFieldId(k));
      if (paramMap != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        localObject = (String)paramMap.getKey();
        paramMap = (FastJsonResponse.Field)paramMap.getValue();
        paramStringBuilder.append("\"").append((String)localObject).append("\":");
        if (paramMap.hasConverter()) {
          switch (paramMap.getTypeOut())
          {
          default: 
            i = paramMap.getTypeOut();
            paramStringBuilder = new IllegalArgumentException(36 + "Unknown field out type = " + i);
            AppMethodBeat.o(61617);
            throw paramStringBuilder;
          case 0: 
            zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, Integer.valueOf(SafeParcelReader.readInt(paramParcel, k))));
          }
        }
        for (;;)
        {
          i = 1;
          break;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, SafeParcelReader.createBigInteger(paramParcel, k)));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, Long.valueOf(SafeParcelReader.readLong(paramParcel, k))));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, Float.valueOf(SafeParcelReader.readFloat(paramParcel, k))));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, Double.valueOf(SafeParcelReader.readDouble(paramParcel, k))));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, SafeParcelReader.createBigDecimal(paramParcel, k)));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, Boolean.valueOf(SafeParcelReader.readBoolean(paramParcel, k))));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, SafeParcelReader.createString(paramParcel, k)));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, SafeParcelReader.createByteArray(paramParcel, k)));
          continue;
          zzb(paramStringBuilder, paramMap, getOriginalValue(paramMap, convertBundleToStringMap(SafeParcelReader.createBundle(paramParcel, k))));
          continue;
          paramStringBuilder = new IllegalArgumentException("Method does not accept concrete type.");
          AppMethodBeat.o(61617);
          throw paramStringBuilder;
          if (paramMap.isTypeOutArray())
          {
            paramStringBuilder.append("[");
            switch (paramMap.getTypeOut())
            {
            default: 
              paramStringBuilder = new IllegalStateException("Unknown field type out.");
              AppMethodBeat.o(61617);
              throw paramStringBuilder;
            case 0: 
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createIntArray(paramParcel, k));
            }
            for (;;)
            {
              paramStringBuilder.append("]");
              break;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigIntegerArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createLongArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createFloatArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createDoubleArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigDecimalArray(paramParcel, k));
              continue;
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBooleanArray(paramParcel, k));
              continue;
              ArrayUtils.writeStringArray(paramStringBuilder, SafeParcelReader.createStringArray(paramParcel, k));
              continue;
              paramStringBuilder = new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
              AppMethodBeat.o(61617);
              throw paramStringBuilder;
              localObject = SafeParcelReader.createParcelArray(paramParcel, k);
              k = localObject.length;
              i = 0;
              while (i < k)
              {
                if (i > 0) {
                  paramStringBuilder.append(",");
                }
                localObject[i].setDataPosition(0);
                zza(paramStringBuilder, paramMap.getConcreteTypeFieldMappingFromDictionary(), localObject[i]);
                i += 1;
              }
            }
          }
          switch (paramMap.getTypeOut())
          {
          default: 
            paramStringBuilder = new IllegalStateException("Unknown field type out");
            AppMethodBeat.o(61617);
            throw paramStringBuilder;
          case 0: 
            paramStringBuilder.append(SafeParcelReader.readInt(paramParcel, k));
            break;
          case 1: 
            paramStringBuilder.append(SafeParcelReader.createBigInteger(paramParcel, k));
            break;
          case 2: 
            paramStringBuilder.append(SafeParcelReader.readLong(paramParcel, k));
            break;
          case 3: 
            paramStringBuilder.append(SafeParcelReader.readFloat(paramParcel, k));
            break;
          case 4: 
            paramStringBuilder.append(SafeParcelReader.readDouble(paramParcel, k));
            break;
          case 5: 
            paramStringBuilder.append(SafeParcelReader.createBigDecimal(paramParcel, k));
            break;
          case 6: 
            paramStringBuilder.append(SafeParcelReader.readBoolean(paramParcel, k));
            break;
          case 7: 
            paramMap = SafeParcelReader.createString(paramParcel, k);
            paramStringBuilder.append("\"").append(JsonUtils.escapeString(paramMap)).append("\"");
            break;
          case 8: 
            paramMap = SafeParcelReader.createByteArray(paramParcel, k);
            paramStringBuilder.append("\"").append(Base64Utils.encode(paramMap)).append("\"");
            break;
          case 9: 
            paramMap = SafeParcelReader.createByteArray(paramParcel, k);
            paramStringBuilder.append("\"").append(Base64Utils.encodeUrlSafe(paramMap));
            paramStringBuilder.append("\"");
            break;
          case 10: 
            paramMap = SafeParcelReader.createBundle(paramParcel, k);
            localObject = paramMap.keySet();
            ((Set)localObject).size();
            paramStringBuilder.append("{");
            localObject = ((Set)localObject).iterator();
            for (i = 1; ((Iterator)localObject).hasNext(); i = 0)
            {
              String str = (String)((Iterator)localObject).next();
              if (i == 0) {
                paramStringBuilder.append(",");
              }
              paramStringBuilder.append("\"").append(str).append("\"");
              paramStringBuilder.append(":");
              paramStringBuilder.append("\"").append(JsonUtils.escapeString(paramMap.getString(str))).append("\"");
            }
            paramStringBuilder.append("}");
            break;
          case 11: 
            localObject = SafeParcelReader.createParcel(paramParcel, k);
            ((Parcel)localObject).setDataPosition(0);
            zza(paramStringBuilder, paramMap.getConcreteTypeFieldMappingFromDictionary(), (Parcel)localObject);
          }
        }
      }
    }
    if (paramParcel.dataPosition() != j)
    {
      paramStringBuilder = new SafeParcelReader.ParseException(37 + "Overread allowed size end=" + j, paramParcel);
      AppMethodBeat.o(61617);
      throw paramStringBuilder;
    }
    paramStringBuilder.append('}');
    AppMethodBeat.o(61617);
  }
  
  private final void zzb(FastJsonResponse.Field<?, ?> paramField)
  {
    AppMethodBeat.i(61595);
    if (!paramField.isValidSafeParcelableFieldId())
    {
      paramField = new IllegalStateException("Field does not have a valid safe parcelable field id.");
      AppMethodBeat.o(61595);
      throw paramField;
    }
    if (this.zzxq == null)
    {
      paramField = new IllegalStateException("Internal Parcel object is null.");
      AppMethodBeat.o(61595);
      throw paramField;
    }
    switch (this.zzxs)
    {
    default: 
      paramField = new IllegalStateException("Unknown parse state in SafeParcelResponse.");
      AppMethodBeat.o(61595);
      throw paramField;
    case 0: 
      this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
      this.zzxs = 1;
      AppMethodBeat.o(61595);
      return;
    case 1: 
      AppMethodBeat.o(61595);
      return;
    }
    paramField = new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
    AppMethodBeat.o(61595);
    throw paramField;
  }
  
  private final void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    AppMethodBeat.i(61618);
    if (paramField.isTypeInArray())
    {
      paramObject = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        zza(paramStringBuilder, paramField.getTypeIn(), paramObject.get(i));
        i += 1;
      }
      paramStringBuilder.append("]");
      AppMethodBeat.o(61618);
      return;
    }
    zza(paramStringBuilder, paramField.getTypeIn(), paramObject);
    AppMethodBeat.o(61618);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(61615);
    zzb(paramField);
    paramString = new ArrayList();
    paramArrayList.size();
    paramArrayList = (ArrayList)paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      i += 1;
      paramString.add(((SafeParcelResponse)localObject).getParcel());
    }
    SafeParcelWriter.writeParcelList(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61615);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    AppMethodBeat.i(61614);
    zzb(paramField);
    paramString = ((SafeParcelResponse)paramT).getParcel();
    SafeParcelWriter.writeParcel(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61614);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    AppMethodBeat.i(61592);
    if (this.zzwn == null)
    {
      AppMethodBeat.o(61592);
      return null;
    }
    Map localMap = this.zzwn.getFieldMapping(this.mClassName);
    AppMethodBeat.o(61592);
    return localMap;
  }
  
  public Parcel getParcel()
  {
    AppMethodBeat.i(61591);
    switch (this.zzxs)
    {
    }
    for (;;)
    {
      Parcel localParcel = this.zzxq;
      AppMethodBeat.o(61591);
      return localParcel;
      this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
      SafeParcelWriter.finishObjectHeader(this.zzxq, this.zzxt);
      this.zzxs = 2;
    }
  }
  
  public Object getValueObject(String paramString)
  {
    AppMethodBeat.i(61593);
    paramString = new UnsupportedOperationException("Converting to JSON does not require this method.");
    AppMethodBeat.o(61593);
    throw paramString;
  }
  
  public int getVersionCode()
  {
    return this.zzal;
  }
  
  public <T extends SafeParcelable> T inflate(Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(61587);
    Parcel localParcel = getParcel();
    localParcel.setDataPosition(0);
    paramCreator = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    AppMethodBeat.o(61587);
    return paramCreator;
  }
  
  public boolean isPrimitiveFieldSet(String paramString)
  {
    AppMethodBeat.i(61594);
    paramString = new UnsupportedOperationException("Converting to JSON does not require this method.");
    AppMethodBeat.o(61594);
    throw paramString;
  }
  
  protected void setBigDecimalInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    AppMethodBeat.i(61606);
    zzb(paramField);
    SafeParcelWriter.writeBigDecimal(this.zzxq, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
    AppMethodBeat.o(61606);
  }
  
  protected void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    AppMethodBeat.i(61607);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new BigDecimal[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigDecimal)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeBigDecimalArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61607);
  }
  
  protected void setBigIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    AppMethodBeat.i(61598);
    zzb(paramField);
    SafeParcelWriter.writeBigInteger(this.zzxq, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
    AppMethodBeat.o(61598);
  }
  
  protected void setBigIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    AppMethodBeat.i(61599);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new BigInteger[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigInteger)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeBigIntegerArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61599);
  }
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(61608);
    zzb(paramField);
    SafeParcelWriter.writeBoolean(this.zzxq, paramField.getSafeParcelableFieldId(), paramBoolean);
    AppMethodBeat.o(61608);
  }
  
  protected void setBooleansInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    AppMethodBeat.i(61609);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new boolean[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Boolean)paramArrayList.get(i)).booleanValue();
      i += 1;
    }
    SafeParcelWriter.writeBooleanArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61609);
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(61612);
    zzb(paramField);
    SafeParcelWriter.writeByteArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramArrayOfByte, true);
    AppMethodBeat.o(61612);
  }
  
  protected void setDoubleInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble)
  {
    AppMethodBeat.i(61604);
    zzb(paramField);
    SafeParcelWriter.writeDouble(this.zzxq, paramField.getSafeParcelableFieldId(), paramDouble);
    AppMethodBeat.o(61604);
  }
  
  protected void setDoublesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    AppMethodBeat.i(61605);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new double[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Double)paramArrayList.get(i)).doubleValue();
      i += 1;
    }
    SafeParcelWriter.writeDoubleArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61605);
  }
  
  protected void setFloatInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat)
  {
    AppMethodBeat.i(61602);
    zzb(paramField);
    SafeParcelWriter.writeFloat(this.zzxq, paramField.getSafeParcelableFieldId(), paramFloat);
    AppMethodBeat.o(61602);
  }
  
  protected void setFloatsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(61603);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new float[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Float)paramArrayList.get(i)).floatValue();
      i += 1;
    }
    SafeParcelWriter.writeFloatArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61603);
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    AppMethodBeat.i(61596);
    zzb(paramField);
    SafeParcelWriter.writeInt(this.zzxq, paramField.getSafeParcelableFieldId(), paramInt);
    AppMethodBeat.o(61596);
  }
  
  protected void setIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(61597);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new int[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Integer)paramArrayList.get(i)).intValue();
      i += 1;
    }
    SafeParcelWriter.writeIntArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61597);
  }
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong)
  {
    AppMethodBeat.i(61600);
    zzb(paramField);
    SafeParcelWriter.writeLong(this.zzxq, paramField.getSafeParcelableFieldId(), paramLong);
    AppMethodBeat.o(61600);
  }
  
  protected void setLongsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(61601);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new long[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Long)paramArrayList.get(i)).longValue();
      i += 1;
    }
    SafeParcelWriter.writeLongArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61601);
  }
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    AppMethodBeat.i(61610);
    zzb(paramField);
    SafeParcelWriter.writeString(this.zzxq, paramField.getSafeParcelableFieldId(), paramString2, true);
    AppMethodBeat.o(61610);
  }
  
  protected void setStringMapInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(61613);
    zzb(paramField);
    paramString = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.putString(str, (String)paramMap.get(str));
    }
    SafeParcelWriter.writeBundle(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61613);
  }
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(61611);
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((String)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeStringArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(61611);
  }
  
  public String toString()
  {
    AppMethodBeat.i(61616);
    Preconditions.checkNotNull(this.zzwn, "Cannot convert to JSON on client side.");
    Object localObject = getParcel();
    ((Parcel)localObject).setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, this.zzwn.getFieldMapping(this.mClassName), (Parcel)localObject);
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(61616);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61590);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getVersionCode());
    SafeParcelWriter.writeParcel(paramParcel, 2, getParcel(), false);
    Object localObject;
    switch (this.zzxr)
    {
    default: 
      paramInt = this.zzxr;
      paramParcel = new IllegalStateException(34 + "Invalid creation type: " + paramInt);
      AppMethodBeat.o(61590);
      throw paramParcel;
    case 0: 
      localObject = null;
    }
    for (;;)
    {
      SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)localObject, paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      AppMethodBeat.o(61590);
      return;
      localObject = this.zzwn;
      continue;
      localObject = this.zzwn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.server.response.SafeParcelResponse
 * JD-Core Version:    0.7.0.1
 */