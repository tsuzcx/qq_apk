package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator="AuthenticatorAnnotatedDataCreator")
public class zzu
  extends zzbs
{
  public static final Parcelable.Creator<zzu> CREATOR;
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbk;
  @SafeParcelable.Field(getter="getPackageName", id=4)
  private String mPackageName;
  @SafeParcelable.Indicator
  private final Set<Integer> zzbl;
  @SafeParcelable.Field(getter="getInfo", id=2)
  private zzw zzbv;
  @SafeParcelable.Field(getter="getSignature", id=3)
  private String zzbw;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10681);
    CREATOR = new zzv();
    HashMap localHashMap = new HashMap();
    zzbk = localHashMap;
    localHashMap.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzw.class));
    zzbk.put("signature", FastJsonResponse.Field.forString("signature", 3));
    zzbk.put("package", FastJsonResponse.Field.forString("package", 4));
    AppMethodBeat.o(10681);
  }
  
  public zzu()
  {
    AppMethodBeat.i(10675);
    this.zzbl = new HashSet(3);
    this.zzy = 1;
    AppMethodBeat.o(10675);
  }
  
  @SafeParcelable.Constructor
  zzu(@SafeParcelable.Indicator Set<Integer> paramSet, @SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) zzw paramzzw, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) String paramString2)
  {
    this.zzbl = paramSet;
    this.zzy = paramInt;
    this.zzbv = paramzzw;
    this.zzbw = paramString1;
    this.mPackageName = paramString2;
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    AppMethodBeat.i(10680);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[] { Integer.valueOf(i), paramT.getClass().getCanonicalName() }));
      AppMethodBeat.o(10680);
      throw paramField;
    }
    this.zzbv = ((zzw)paramT);
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(10680);
  }
  
  public Object getFieldValue(FastJsonResponse.Field paramField)
  {
    AppMethodBeat.i(10678);
    int i;
    switch (paramField.getSafeParcelableFieldId())
    {
    default: 
      i = paramField.getSafeParcelableFieldId();
      paramField = new IllegalStateException(37 + "Unknown SafeParcelable id=" + i);
      AppMethodBeat.o(10678);
      throw paramField;
    case 1: 
      i = this.zzy;
      AppMethodBeat.o(10678);
      return Integer.valueOf(i);
    case 2: 
      paramField = this.zzbv;
      AppMethodBeat.o(10678);
      return paramField;
    case 3: 
      paramField = this.zzbw;
      AppMethodBeat.o(10678);
      return paramField;
    }
    paramField = this.mPackageName;
    AppMethodBeat.o(10678);
    return paramField;
  }
  
  public boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    AppMethodBeat.i(10677);
    boolean bool = this.zzbl.contains(Integer.valueOf(paramField.getSafeParcelableFieldId()));
    AppMethodBeat.o(10677);
    return bool;
  }
  
  public void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10679);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(10679);
      throw paramField;
    case 3: 
      this.zzbw = paramString2;
    }
    for (;;)
    {
      this.zzbl.add(Integer.valueOf(i));
      AppMethodBeat.o(10679);
      return;
      this.mPackageName = paramString2;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10676);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Set localSet = this.zzbl;
    if (localSet.contains(Integer.valueOf(1))) {
      SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzbv, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      SafeParcelWriter.writeString(paramParcel, 3, this.zzbw, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      SafeParcelWriter.writeString(paramParcel, 4, this.mPackageName, true);
    }
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(10676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzu
 * JD-Core Version:    0.7.0.1
 */