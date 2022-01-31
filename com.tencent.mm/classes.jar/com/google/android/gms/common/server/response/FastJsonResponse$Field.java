package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SafeParcelable.Class(creator="FieldCreator")
@VisibleForTesting
public class FastJsonResponse$Field<I, O>
  extends AbstractSafeParcelable
{
  public static final FieldCreator CREATOR;
  protected final Class<? extends FastJsonResponse> mConcreteType;
  @SafeParcelable.Field(getter="getConcreteTypeName", id=8)
  protected final String mConcreteTypeName;
  @SafeParcelable.Field(getter="getOutputFieldName", id=6)
  protected final String mOutputFieldName;
  @SafeParcelable.Field(getter="getSafeParcelableFieldId", id=7)
  protected final int mSafeParcelableFieldId;
  @SafeParcelable.Field(getter="getTypeIn", id=2)
  protected final int mTypeIn;
  @SafeParcelable.Field(getter="isTypeInArray", id=3)
  protected final boolean mTypeInArray;
  @SafeParcelable.Field(getter="getTypeOut", id=4)
  protected final int mTypeOut;
  @SafeParcelable.Field(getter="isTypeOutArray", id=5)
  protected final boolean mTypeOutArray;
  @SafeParcelable.VersionField(getter="getVersionCode", id=1)
  private final int zzal;
  private FieldMappingDictionary zzwn;
  @SafeParcelable.Field(getter="getWrappedConverter", id=9, type="com.google.android.gms.common.server.converter.ConverterWrapper")
  private FastJsonResponse.FieldConverter<I, O> zzwo;
  
  static
  {
    AppMethodBeat.i(61521);
    CREATOR = new FieldCreator();
    AppMethodBeat.o(61521);
  }
  
  @SafeParcelable.Constructor
  FastJsonResponse$Field(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) boolean paramBoolean1, @SafeParcelable.Param(id=4) int paramInt3, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) String paramString1, @SafeParcelable.Param(id=7) int paramInt4, @SafeParcelable.Param(id=8) String paramString2, @SafeParcelable.Param(id=9) ConverterWrapper paramConverterWrapper)
  {
    AppMethodBeat.i(61465);
    this.zzal = paramInt1;
    this.mTypeIn = paramInt2;
    this.mTypeInArray = paramBoolean1;
    this.mTypeOut = paramInt3;
    this.mTypeOutArray = paramBoolean2;
    this.mOutputFieldName = paramString1;
    this.mSafeParcelableFieldId = paramInt4;
    if (paramString2 == null) {
      this.mConcreteType = null;
    }
    for (this.mConcreteTypeName = null; paramConverterWrapper == null; this.mConcreteTypeName = paramString2)
    {
      this.zzwo = null;
      AppMethodBeat.o(61465);
      return;
      this.mConcreteType = SafeParcelResponse.class;
    }
    this.zzwo = paramConverterWrapper.unwrap();
    AppMethodBeat.o(61465);
  }
  
  protected FastJsonResponse$Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends FastJsonResponse> paramClass, FastJsonResponse.FieldConverter<I, O> paramFieldConverter)
  {
    AppMethodBeat.i(61466);
    this.zzal = 1;
    this.mTypeIn = paramInt1;
    this.mTypeInArray = paramBoolean1;
    this.mTypeOut = paramInt2;
    this.mTypeOutArray = paramBoolean2;
    this.mOutputFieldName = paramString;
    this.mSafeParcelableFieldId = paramInt3;
    this.mConcreteType = paramClass;
    if (paramClass == null) {}
    for (this.mConcreteTypeName = null;; this.mConcreteTypeName = paramClass.getCanonicalName())
    {
      this.zzwo = paramFieldConverter;
      AppMethodBeat.o(61466);
      return;
    }
  }
  
  public static Field<byte[], byte[]> forBase64(String paramString)
  {
    AppMethodBeat.i(61513);
    paramString = new Field(8, false, 8, false, paramString, -1, null, null);
    AppMethodBeat.o(61513);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<byte[], byte[]> forBase64(String paramString, int paramInt)
  {
    AppMethodBeat.i(61489);
    paramString = new Field(8, false, 8, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61489);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<byte[], byte[]> forBase64UrlSafe(String paramString)
  {
    AppMethodBeat.i(61514);
    paramString = new Field(9, false, 9, false, paramString, -1, null, null);
    AppMethodBeat.o(61514);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<byte[], byte[]> forBase64UrlSafe(String paramString, int paramInt)
  {
    AppMethodBeat.i(61490);
    paramString = new Field(9, false, 9, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61490);
    return paramString;
  }
  
  public static Field<BigDecimal, BigDecimal> forBigDecimal(String paramString)
  {
    AppMethodBeat.i(61507);
    paramString = new Field(5, false, 5, false, paramString, -1, null, null);
    AppMethodBeat.o(61507);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<BigDecimal, BigDecimal> forBigDecimal(String paramString, int paramInt)
  {
    AppMethodBeat.i(61483);
    paramString = new Field(5, false, 5, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61483);
    return paramString;
  }
  
  public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String paramString)
  {
    AppMethodBeat.i(61508);
    paramString = new Field(5, true, 5, true, paramString, -1, null, null);
    AppMethodBeat.o(61508);
    return paramString;
  }
  
  public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String paramString, int paramInt)
  {
    AppMethodBeat.i(61484);
    paramString = new Field(5, true, 5, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61484);
    return paramString;
  }
  
  public static Field<BigInteger, BigInteger> forBigInteger(String paramString)
  {
    AppMethodBeat.i(61499);
    paramString = new Field(1, false, 1, false, paramString, -1, null, null);
    AppMethodBeat.o(61499);
    return paramString;
  }
  
  public static Field<BigInteger, BigInteger> forBigInteger(String paramString, int paramInt)
  {
    AppMethodBeat.i(61475);
    paramString = new Field(1, false, 1, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61475);
    return paramString;
  }
  
  public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String paramString)
  {
    AppMethodBeat.i(61500);
    paramString = new Field(0, true, 1, true, paramString, -1, null, null);
    AppMethodBeat.o(61500);
    return paramString;
  }
  
  public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String paramString, int paramInt)
  {
    AppMethodBeat.i(61476);
    paramString = new Field(0, true, 1, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61476);
    return paramString;
  }
  
  public static Field<Boolean, Boolean> forBoolean(String paramString)
  {
    AppMethodBeat.i(61509);
    paramString = new Field(6, false, 6, false, paramString, -1, null, null);
    AppMethodBeat.o(61509);
    return paramString;
  }
  
  public static Field<Boolean, Boolean> forBoolean(String paramString, int paramInt)
  {
    AppMethodBeat.i(61485);
    paramString = new Field(6, false, 6, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61485);
    return paramString;
  }
  
  public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String paramString)
  {
    AppMethodBeat.i(61510);
    paramString = new Field(6, true, 6, true, paramString, -1, null, null);
    AppMethodBeat.o(61510);
    return paramString;
  }
  
  public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String paramString, int paramInt)
  {
    AppMethodBeat.i(61486);
    paramString = new Field(6, true, 6, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61486);
    return paramString;
  }
  
  public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String paramString, int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(61492);
    paramString = new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
    AppMethodBeat.o(61492);
    return paramString;
  }
  
  public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(61516);
    paramString = new Field(11, false, 11, false, paramString, -1, paramClass, null);
    AppMethodBeat.o(61516);
    return paramString;
  }
  
  public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String paramString, int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(61493);
    paramString = new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
    AppMethodBeat.o(61493);
    return paramString;
  }
  
  public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(61517);
    paramString = new Field(11, true, 11, true, paramString, -1, paramClass, null);
    AppMethodBeat.o(61517);
    return paramString;
  }
  
  public static Field<Double, Double> forDouble(String paramString)
  {
    AppMethodBeat.i(61505);
    paramString = new Field(4, false, 4, false, paramString, -1, null, null);
    AppMethodBeat.o(61505);
    return paramString;
  }
  
  public static Field<Double, Double> forDouble(String paramString, int paramInt)
  {
    AppMethodBeat.i(61481);
    paramString = new Field(4, false, 4, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61481);
    return paramString;
  }
  
  public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String paramString)
  {
    AppMethodBeat.i(61506);
    paramString = new Field(4, true, 4, true, paramString, -1, null, null);
    AppMethodBeat.o(61506);
    return paramString;
  }
  
  public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String paramString, int paramInt)
  {
    AppMethodBeat.i(61482);
    paramString = new Field(4, true, 4, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61482);
    return paramString;
  }
  
  public static Field<Float, Float> forFloat(String paramString)
  {
    AppMethodBeat.i(61503);
    paramString = new Field(3, false, 3, false, paramString, -1, null, null);
    AppMethodBeat.o(61503);
    return paramString;
  }
  
  public static Field<Float, Float> forFloat(String paramString, int paramInt)
  {
    AppMethodBeat.i(61479);
    paramString = new Field(3, false, 3, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61479);
    return paramString;
  }
  
  public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String paramString)
  {
    AppMethodBeat.i(61504);
    paramString = new Field(3, true, 3, true, paramString, -1, null, null);
    AppMethodBeat.o(61504);
    return paramString;
  }
  
  public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String paramString, int paramInt)
  {
    AppMethodBeat.i(61480);
    paramString = new Field(3, true, 3, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61480);
    return paramString;
  }
  
  public static Field<Integer, Integer> forInteger(String paramString)
  {
    AppMethodBeat.i(61497);
    paramString = new Field(0, false, 0, false, paramString, -1, null, null);
    AppMethodBeat.o(61497);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<Integer, Integer> forInteger(String paramString, int paramInt)
  {
    AppMethodBeat.i(61473);
    paramString = new Field(0, false, 0, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61473);
    return paramString;
  }
  
  public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String paramString)
  {
    AppMethodBeat.i(61498);
    paramString = new Field(0, true, 0, true, paramString, -1, null, null);
    AppMethodBeat.o(61498);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String paramString, int paramInt)
  {
    AppMethodBeat.i(61474);
    paramString = new Field(0, true, 0, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61474);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<Long, Long> forLong(String paramString)
  {
    AppMethodBeat.i(61501);
    paramString = new Field(2, false, 2, false, paramString, -1, null, null);
    AppMethodBeat.o(61501);
    return paramString;
  }
  
  public static Field<Long, Long> forLong(String paramString, int paramInt)
  {
    AppMethodBeat.i(61477);
    paramString = new Field(2, false, 2, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61477);
    return paramString;
  }
  
  @VisibleForTesting
  public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String paramString)
  {
    AppMethodBeat.i(61502);
    paramString = new Field(2, true, 2, true, paramString, -1, null, null);
    AppMethodBeat.o(61502);
    return paramString;
  }
  
  public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String paramString, int paramInt)
  {
    AppMethodBeat.i(61478);
    paramString = new Field(2, true, 2, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61478);
    return paramString;
  }
  
  public static Field<String, String> forString(String paramString)
  {
    AppMethodBeat.i(61511);
    paramString = new Field(7, false, 7, false, paramString, -1, null, null);
    AppMethodBeat.o(61511);
    return paramString;
  }
  
  public static Field<String, String> forString(String paramString, int paramInt)
  {
    AppMethodBeat.i(61487);
    paramString = new Field(7, false, 7, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61487);
    return paramString;
  }
  
  public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String paramString)
  {
    AppMethodBeat.i(61515);
    paramString = new Field(10, false, 10, false, paramString, -1, null, null);
    AppMethodBeat.o(61515);
    return paramString;
  }
  
  public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String paramString, int paramInt)
  {
    AppMethodBeat.i(61491);
    paramString = new Field(10, false, 10, false, paramString, paramInt, null, null);
    AppMethodBeat.o(61491);
    return paramString;
  }
  
  public static Field<ArrayList<String>, ArrayList<String>> forStrings(String paramString)
  {
    AppMethodBeat.i(61512);
    paramString = new Field(7, true, 7, true, paramString, -1, null, null);
    AppMethodBeat.o(61512);
    return paramString;
  }
  
  public static Field<ArrayList<String>, ArrayList<String>> forStrings(String paramString, int paramInt)
  {
    AppMethodBeat.i(61488);
    paramString = new Field(7, true, 7, true, paramString, paramInt, null, null);
    AppMethodBeat.o(61488);
    return paramString;
  }
  
  public static Field withConverter(String paramString, int paramInt, FastJsonResponse.FieldConverter<?, ?> paramFieldConverter, boolean paramBoolean)
  {
    AppMethodBeat.i(61496);
    paramString = new Field(paramFieldConverter.getTypeIn(), paramBoolean, paramFieldConverter.getTypeOut(), false, paramString, paramInt, null, paramFieldConverter);
    AppMethodBeat.o(61496);
    return paramString;
  }
  
  public static <T extends FastJsonResponse.FieldConverter> Field withConverter(String paramString, int paramInt, Class<T> paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(61494);
    try
    {
      paramString = withConverter(paramString, paramInt, (FastJsonResponse.FieldConverter)paramClass.newInstance(), paramBoolean);
      AppMethodBeat.o(61494);
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(61494);
      throw paramString;
    }
    catch (IllegalAccessException paramString)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(61494);
      throw paramString;
    }
  }
  
  public static Field withConverter(String paramString, FastJsonResponse.FieldConverter<?, ?> paramFieldConverter, boolean paramBoolean)
  {
    AppMethodBeat.i(61495);
    paramString = withConverter(paramString, -1, paramFieldConverter, paramBoolean);
    AppMethodBeat.o(61495);
    return paramString;
  }
  
  public static <T extends FastJsonResponse.FieldConverter> Field withConverter(String paramString, Class<T> paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(61518);
    paramString = withConverter(paramString, -1, paramClass, paramBoolean);
    AppMethodBeat.o(61518);
    return paramString;
  }
  
  private final String zzcz()
  {
    if (this.mConcreteTypeName == null) {
      return null;
    }
    return this.mConcreteTypeName;
  }
  
  private final ConverterWrapper zzda()
  {
    AppMethodBeat.i(61468);
    if (this.zzwo == null)
    {
      AppMethodBeat.o(61468);
      return null;
    }
    ConverterWrapper localConverterWrapper = ConverterWrapper.wrap(this.zzwo);
    AppMethodBeat.o(61468);
    return localConverterWrapper;
  }
  
  public O convert(I paramI)
  {
    AppMethodBeat.i(61471);
    paramI = this.zzwo.convert(paramI);
    AppMethodBeat.o(61471);
    return paramI;
  }
  
  public I convertBack(O paramO)
  {
    AppMethodBeat.i(61472);
    paramO = this.zzwo.convertBack(paramO);
    AppMethodBeat.o(61472);
    return paramO;
  }
  
  public Field<I, O> copyForDictionary()
  {
    AppMethodBeat.i(61467);
    Field localField = new Field(this.zzal, this.mTypeIn, this.mTypeInArray, this.mTypeOut, this.mTypeOutArray, this.mOutputFieldName, this.mSafeParcelableFieldId, this.mConcreteTypeName, zzda());
    AppMethodBeat.o(61467);
    return localField;
  }
  
  public Class<? extends FastJsonResponse> getConcreteType()
  {
    return this.mConcreteType;
  }
  
  public Map<String, Field<?, ?>> getConcreteTypeFieldMappingFromDictionary()
  {
    AppMethodBeat.i(61470);
    Preconditions.checkNotNull(this.mConcreteTypeName);
    Preconditions.checkNotNull(this.zzwn);
    Map localMap = this.zzwn.getFieldMapping(this.mConcreteTypeName);
    AppMethodBeat.o(61470);
    return localMap;
  }
  
  public String getOutputFieldName()
  {
    return this.mOutputFieldName;
  }
  
  public int getSafeParcelableFieldId()
  {
    return this.mSafeParcelableFieldId;
  }
  
  public int getTypeIn()
  {
    return this.mTypeIn;
  }
  
  public int getTypeOut()
  {
    return this.mTypeOut;
  }
  
  public int getVersionCode()
  {
    return this.zzal;
  }
  
  public boolean hasConverter()
  {
    return this.zzwo != null;
  }
  
  public boolean isTypeInArray()
  {
    return this.mTypeInArray;
  }
  
  public boolean isTypeOutArray()
  {
    return this.mTypeOutArray;
  }
  
  public boolean isValidSafeParcelableFieldId()
  {
    return this.mSafeParcelableFieldId != -1;
  }
  
  public FastJsonResponse newConcreteTypeInstance()
  {
    AppMethodBeat.i(61469);
    if (this.mConcreteType == SafeParcelResponse.class)
    {
      Preconditions.checkNotNull(this.zzwn, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
      localObject = new SafeParcelResponse(this.zzwn, this.mConcreteTypeName);
      AppMethodBeat.o(61469);
      return localObject;
    }
    Object localObject = (FastJsonResponse)this.mConcreteType.newInstance();
    AppMethodBeat.o(61469);
    return localObject;
  }
  
  public void setFieldMappingDictionary(FieldMappingDictionary paramFieldMappingDictionary)
  {
    this.zzwn = paramFieldMappingDictionary;
  }
  
  public String toString()
  {
    AppMethodBeat.i(61520);
    Object localObject = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zzal)).add("typeIn", Integer.valueOf(this.mTypeIn)).add("typeInArray", Boolean.valueOf(this.mTypeInArray)).add("typeOut", Integer.valueOf(this.mTypeOut)).add("typeOutArray", Boolean.valueOf(this.mTypeOutArray)).add("outputFieldName", this.mOutputFieldName).add("safeParcelFieldId", Integer.valueOf(this.mSafeParcelableFieldId)).add("concreteTypeName", zzcz());
    Class localClass = getConcreteType();
    if (localClass != null) {
      ((Objects.ToStringHelper)localObject).add("concreteType.class", localClass.getCanonicalName());
    }
    if (this.zzwo != null) {
      ((Objects.ToStringHelper)localObject).add("converterName", this.zzwo.getClass().getCanonicalName());
    }
    localObject = ((Objects.ToStringHelper)localObject).toString();
    AppMethodBeat.o(61520);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61519);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getVersionCode());
    SafeParcelWriter.writeInt(paramParcel, 2, getTypeIn());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isTypeInArray());
    SafeParcelWriter.writeInt(paramParcel, 4, getTypeOut());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isTypeOutArray());
    SafeParcelWriter.writeString(paramParcel, 6, getOutputFieldName(), false);
    SafeParcelWriter.writeInt(paramParcel, 7, getSafeParcelableFieldId());
    SafeParcelWriter.writeString(paramParcel, 8, zzcz(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 9, zzda(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(61519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse.Field
 * JD-Core Version:    0.7.0.1
 */