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
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse
  extends FastSafeParcelableJsonResponse
{
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR;
  private final String mClassName;
  private final int zzal;
  private final FieldMappingDictionary zzwn;
  private final Parcel zzxq;
  private final int zzxr;
  private int zzxs;
  private int zzxt;
  
  static
  {
    AppMethodBeat.i(12114);
    CREATOR = new SafeParcelResponseCreator();
    AppMethodBeat.o(12114);
  }
  
  SafeParcelResponse(int paramInt, Parcel paramParcel, FieldMappingDictionary paramFieldMappingDictionary)
  {
    AppMethodBeat.i(12081);
    this.zzal = paramInt;
    this.zzxq = ((Parcel)Preconditions.checkNotNull(paramParcel));
    this.zzxr = 2;
    this.zzwn = paramFieldMappingDictionary;
    if (this.zzwn == null) {}
    for (this.mClassName = null;; this.mClassName = this.zzwn.getRootClassName())
    {
      this.zzxs = 2;
      AppMethodBeat.o(12081);
      return;
    }
  }
  
  private SafeParcelResponse(SafeParcelable paramSafeParcelable, FieldMappingDictionary paramFieldMappingDictionary, String paramString)
  {
    AppMethodBeat.i(12075);
    this.zzal = 1;
    this.zzxq = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.zzxq, 0);
    this.zzxr = 1;
    this.zzwn = ((FieldMappingDictionary)Preconditions.checkNotNull(paramFieldMappingDictionary));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zzxs = 2;
    AppMethodBeat.o(12075);
  }
  
  public SafeParcelResponse(FieldMappingDictionary paramFieldMappingDictionary)
  {
    this(paramFieldMappingDictionary, paramFieldMappingDictionary.getRootClassName());
    AppMethodBeat.i(12073);
    AppMethodBeat.o(12073);
  }
  
  public SafeParcelResponse(FieldMappingDictionary paramFieldMappingDictionary, String paramString)
  {
    AppMethodBeat.i(12074);
    this.zzal = 1;
    this.zzxq = Parcel.obtain();
    this.zzxr = 0;
    this.zzwn = ((FieldMappingDictionary)Preconditions.checkNotNull(paramFieldMappingDictionary));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zzxs = 0;
    AppMethodBeat.o(12074);
  }
  
  public static HashMap<String, String> convertBundleToStringMap(Bundle paramBundle)
  {
    AppMethodBeat.i(12112);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    AppMethodBeat.o(12112);
    return localHashMap;
  }
  
  public static Bundle convertStringMapToBundle(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(12113);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)paramHashMap.get(str));
    }
    AppMethodBeat.o(12113);
    return localBundle;
  }
  
  public static <T extends FastJsonResponse,  extends SafeParcelable> SafeParcelResponse from(T paramT)
  {
    AppMethodBeat.i(12076);
    String str = paramT.getClass().getCanonicalName();
    FieldMappingDictionary localFieldMappingDictionary = zza(paramT);
    paramT = new SafeParcelResponse((SafeParcelable)paramT, localFieldMappingDictionary, str);
    AppMethodBeat.o(12076);
    return paramT;
  }
  
  public static FieldMappingDictionary generateDictionary(Class<? extends FastJsonResponse> paramClass)
  {
    AppMethodBeat.i(12080);
    try
    {
      FieldMappingDictionary localFieldMappingDictionary = zza((FastJsonResponse)paramClass.newInstance());
      AppMethodBeat.o(12080);
      return localFieldMappingDictionary;
    }
    catch (InstantiationException localInstantiationException)
    {
      paramClass = String.valueOf(paramClass.getCanonicalName());
      if (paramClass.length() != 0) {}
      for (paramClass = "Could not instantiate an object of type ".concat(paramClass);; paramClass = new String("Could not instantiate an object of type "))
      {
        paramClass = new IllegalStateException(paramClass, localInstantiationException);
        AppMethodBeat.o(12080);
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
      AppMethodBeat.o(12080);
      throw paramClass;
    }
  }
  
  private static FieldMappingDictionary zza(FastJsonResponse paramFastJsonResponse)
  {
    AppMethodBeat.i(12077);
    FieldMappingDictionary localFieldMappingDictionary = new FieldMappingDictionary(paramFastJsonResponse.getClass());
    zza(localFieldMappingDictionary, paramFastJsonResponse);
    localFieldMappingDictionary.copyInternalFieldMappings();
    localFieldMappingDictionary.linkFields();
    AppMethodBeat.o(12077);
    return localFieldMappingDictionary;
  }
  
  private static void zza(FieldMappingDictionary paramFieldMappingDictionary, FastJsonResponse paramFastJsonResponse)
  {
    AppMethodBeat.i(12078);
    Object localObject = paramFastJsonResponse.getClass();
    if (!paramFieldMappingDictionary.hasFieldMappingForClass((Class)localObject))
    {
      Map localMap = paramFastJsonResponse.getFieldMappings();
      paramFieldMappingDictionary.put((Class)localObject, localMap);
      localObject = localMap.keySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label210;
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
              AppMethodBeat.o(12078);
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
        AppMethodBeat.o(12078);
        throw paramFieldMappingDictionary;
      }
    }
    label210:
    AppMethodBeat.o(12078);
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(12111);
    switch (paramInt)
    {
    default: 
      paramStringBuilder = new IllegalArgumentException(26 + "Unknown type = " + paramInt);
      AppMethodBeat.o(12111);
      throw paramStringBuilder;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      AppMethodBeat.o(12111);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(JsonUtils.escapeString(paramObject.toString())).append("\"");
      AppMethodBeat.o(12111);
      return;
    case 8: 
      paramStringBuilder.append("\"").append(Base64Utils.encode((byte[])paramObject)).append("\"");
      AppMethodBeat.o(12111);
      return;
    case 9: 
      paramStringBuilder.append("\"").append(Base64Utils.encodeUrlSafe((byte[])paramObject));
      paramStringBuilder.append("\"");
      AppMethodBeat.o(12111);
      return;
    case 10: 
      MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)paramObject);
      AppMethodBeat.o(12111);
      return;
    }
    paramStringBuilder = new IllegalArgumentException("Method does not accept concrete type.");
    AppMethodBeat.o(12111);
    throw paramStringBuilder;
  }
  
  private final void zza(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    AppMethodBeat.i(12109);
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
            AppMethodBeat.o(12109);
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
          AppMethodBeat.o(12109);
          throw paramStringBuilder;
          if (paramMap.isTypeOutArray())
          {
            paramStringBuilder.append("[");
            switch (paramMap.getTypeOut())
            {
            default: 
              paramStringBuilder = new IllegalStateException("Unknown field type out.");
              AppMethodBeat.o(12109);
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
              AppMethodBeat.o(12109);
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
            AppMethodBeat.o(12109);
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
      AppMethodBeat.o(12109);
      throw paramStringBuilder;
    }
    paramStringBuilder.append('}');
    AppMethodBeat.o(12109);
  }
  
  private final void zzb(FastJsonResponse.Field<?, ?> paramField)
  {
    AppMethodBeat.i(12087);
    if (!paramField.isValidSafeParcelableFieldId())
    {
      paramField = new IllegalStateException("Field does not have a valid safe parcelable field id.");
      AppMethodBeat.o(12087);
      throw paramField;
    }
    if (this.zzxq == null)
    {
      paramField = new IllegalStateException("Internal Parcel object is null.");
      AppMethodBeat.o(12087);
      throw paramField;
    }
    switch (this.zzxs)
    {
    default: 
      paramField = new IllegalStateException("Unknown parse state in SafeParcelResponse.");
      AppMethodBeat.o(12087);
      throw paramField;
    case 0: 
      this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
      this.zzxs = 1;
      AppMethodBeat.o(12087);
      return;
    case 1: 
      AppMethodBeat.o(12087);
      return;
    }
    paramField = new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
    AppMethodBeat.o(12087);
    throw paramField;
  }
  
  private final void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    AppMethodBeat.i(12110);
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
      AppMethodBeat.o(12110);
      return;
    }
    zza(paramStringBuilder, paramField.getTypeIn(), paramObject);
    AppMethodBeat.o(12110);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(12107);
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
    AppMethodBeat.o(12107);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    AppMethodBeat.i(12106);
    zzb(paramField);
    paramString = ((SafeParcelResponse)paramT).getParcel();
    SafeParcelWriter.writeParcel(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(12106);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    AppMethodBeat.i(12084);
    if (this.zzwn == null)
    {
      AppMethodBeat.o(12084);
      return null;
    }
    Map localMap = this.zzwn.getFieldMapping(this.mClassName);
    AppMethodBeat.o(12084);
    return localMap;
  }
  
  public Parcel getParcel()
  {
    AppMethodBeat.i(12083);
    switch (this.zzxs)
    {
    }
    for (;;)
    {
      Parcel localParcel = this.zzxq;
      AppMethodBeat.o(12083);
      return localParcel;
      this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
      SafeParcelWriter.finishObjectHeader(this.zzxq, this.zzxt);
      this.zzxs = 2;
    }
  }
  
  public Object getValueObject(String paramString)
  {
    AppMethodBeat.i(12085);
    paramString = new UnsupportedOperationException("Converting to JSON does not require this method.");
    AppMethodBeat.o(12085);
    throw paramString;
  }
  
  public int getVersionCode()
  {
    return this.zzal;
  }
  
  public <T extends SafeParcelable> T inflate(Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(12079);
    Parcel localParcel = getParcel();
    localParcel.setDataPosition(0);
    paramCreator = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    AppMethodBeat.o(12079);
    return paramCreator;
  }
  
  public boolean isPrimitiveFieldSet(String paramString)
  {
    AppMethodBeat.i(12086);
    paramString = new UnsupportedOperationException("Converting to JSON does not require this method.");
    AppMethodBeat.o(12086);
    throw paramString;
  }
  
  protected void setBigDecimalInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    AppMethodBeat.i(12098);
    zzb(paramField);
    SafeParcelWriter.writeBigDecimal(this.zzxq, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
    AppMethodBeat.o(12098);
  }
  
  protected void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    AppMethodBeat.i(12099);
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
    AppMethodBeat.o(12099);
  }
  
  protected void setBigIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    AppMethodBeat.i(12090);
    zzb(paramField);
    SafeParcelWriter.writeBigInteger(this.zzxq, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
    AppMethodBeat.o(12090);
  }
  
  protected void setBigIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    AppMethodBeat.i(12091);
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
    AppMethodBeat.o(12091);
  }
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(12100);
    zzb(paramField);
    SafeParcelWriter.writeBoolean(this.zzxq, paramField.getSafeParcelableFieldId(), paramBoolean);
    AppMethodBeat.o(12100);
  }
  
  protected void setBooleansInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    AppMethodBeat.i(12101);
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
    AppMethodBeat.o(12101);
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12104);
    zzb(paramField);
    SafeParcelWriter.writeByteArray(this.zzxq, paramField.getSafeParcelableFieldId(), paramArrayOfByte, true);
    AppMethodBeat.o(12104);
  }
  
  protected void setDoubleInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble)
  {
    AppMethodBeat.i(12096);
    zzb(paramField);
    SafeParcelWriter.writeDouble(this.zzxq, paramField.getSafeParcelableFieldId(), paramDouble);
    AppMethodBeat.o(12096);
  }
  
  protected void setDoublesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    AppMethodBeat.i(12097);
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
    AppMethodBeat.o(12097);
  }
  
  protected void setFloatInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat)
  {
    AppMethodBeat.i(12094);
    zzb(paramField);
    SafeParcelWriter.writeFloat(this.zzxq, paramField.getSafeParcelableFieldId(), paramFloat);
    AppMethodBeat.o(12094);
  }
  
  protected void setFloatsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    AppMethodBeat.i(12095);
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
    AppMethodBeat.o(12095);
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    AppMethodBeat.i(12088);
    zzb(paramField);
    SafeParcelWriter.writeInt(this.zzxq, paramField.getSafeParcelableFieldId(), paramInt);
    AppMethodBeat.o(12088);
  }
  
  protected void setIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(12089);
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
    AppMethodBeat.o(12089);
  }
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong)
  {
    AppMethodBeat.i(12092);
    zzb(paramField);
    SafeParcelWriter.writeLong(this.zzxq, paramField.getSafeParcelableFieldId(), paramLong);
    AppMethodBeat.o(12092);
  }
  
  protected void setLongsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(12093);
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
    AppMethodBeat.o(12093);
  }
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    AppMethodBeat.i(12102);
    zzb(paramField);
    SafeParcelWriter.writeString(this.zzxq, paramField.getSafeParcelableFieldId(), paramString2, true);
    AppMethodBeat.o(12102);
  }
  
  protected void setStringMapInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(12105);
    zzb(paramField);
    paramString = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.putString(str, (String)paramMap.get(str));
    }
    SafeParcelWriter.writeBundle(this.zzxq, paramField.getSafeParcelableFieldId(), paramString, true);
    AppMethodBeat.o(12105);
  }
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(12103);
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
    AppMethodBeat.o(12103);
  }
  
  public String toString()
  {
    AppMethodBeat.i(12108);
    Preconditions.checkNotNull(this.zzwn, "Cannot convert to JSON on client side.");
    Object localObject = getParcel();
    ((Parcel)localObject).setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, this.zzwn.getFieldMapping(this.mClassName), (Parcel)localObject);
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(12108);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12082);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getVersionCode());
    SafeParcelWriter.writeParcel(paramParcel, 2, getParcel(), false);
    Object localObject;
    switch (this.zzxr)
    {
    default: 
      paramInt = this.zzxr;
      paramParcel = new IllegalStateException(34 + "Invalid creation type: " + paramInt);
      AppMethodBeat.o(12082);
      throw paramParcel;
    case 0: 
      localObject = null;
    }
    for (;;)
    {
      SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)localObject, paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      AppMethodBeat.o(12082);
      return;
      localObject = this.zzwn;
      continue;
      localObject = this.zzwn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.response.SafeParcelResponse
 * JD-Core Version:    0.7.0.1
 */