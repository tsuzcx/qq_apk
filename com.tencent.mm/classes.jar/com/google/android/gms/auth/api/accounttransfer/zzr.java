package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.b.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzr
  extends zzbs
{
  public static final Parcelable.Creator<zzr> CREATOR;
  private static final a<String, FastJsonResponse.Field<?, ?>> zzbp;
  private List<String> zzbq;
  private List<String> zzbr;
  private List<String> zzbs;
  private List<String> zzbt;
  private List<String> zzbu;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10673);
    CREATOR = new zzs();
    a locala = new a();
    zzbp = locala;
    locala.put("registered", FastJsonResponse.Field.forStrings("registered", 2));
    zzbp.put("in_progress", FastJsonResponse.Field.forStrings("in_progress", 3));
    zzbp.put("success", FastJsonResponse.Field.forStrings("success", 4));
    zzbp.put("failed", FastJsonResponse.Field.forStrings("failed", 5));
    zzbp.put("escrowed", FastJsonResponse.Field.forStrings("escrowed", 6));
    AppMethodBeat.o(10673);
  }
  
  public zzr()
  {
    this.zzy = 1;
  }
  
  zzr(int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5)
  {
    this.zzy = paramInt;
    this.zzbq = paramList1;
    this.zzbr = paramList2;
    this.zzbs = paramList3;
    this.zzbt = paramList4;
    this.zzbu = paramList5;
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    return zzbp;
  }
  
  public Object getFieldValue(FastJsonResponse.Field paramField)
  {
    AppMethodBeat.i(10671);
    int i;
    switch (paramField.getSafeParcelableFieldId())
    {
    default: 
      i = paramField.getSafeParcelableFieldId();
      paramField = new IllegalStateException(37 + "Unknown SafeParcelable id=" + i);
      AppMethodBeat.o(10671);
      throw paramField;
    case 1: 
      i = this.zzy;
      AppMethodBeat.o(10671);
      return Integer.valueOf(i);
    case 2: 
      paramField = this.zzbq;
      AppMethodBeat.o(10671);
      return paramField;
    case 3: 
      paramField = this.zzbr;
      AppMethodBeat.o(10671);
      return paramField;
    case 4: 
      paramField = this.zzbs;
      AppMethodBeat.o(10671);
      return paramField;
    case 5: 
      paramField = this.zzbt;
      AppMethodBeat.o(10671);
      return paramField;
    }
    paramField = this.zzbu;
    AppMethodBeat.o(10671);
    return paramField;
  }
  
  public boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    return true;
  }
  
  public void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(10672);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(10672);
      throw paramField;
    case 2: 
      this.zzbq = paramArrayList;
      AppMethodBeat.o(10672);
      return;
    case 3: 
      this.zzbr = paramArrayList;
      AppMethodBeat.o(10672);
      return;
    case 4: 
      this.zzbs = paramArrayList;
      AppMethodBeat.o(10672);
      return;
    case 5: 
      this.zzbt = paramArrayList;
      AppMethodBeat.o(10672);
      return;
    }
    this.zzbu = paramArrayList;
    AppMethodBeat.o(10672);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10670);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeStringList(paramParcel, 2, this.zzbq, false);
    SafeParcelWriter.writeStringList(paramParcel, 3, this.zzbr, false);
    SafeParcelWriter.writeStringList(paramParcel, 4, this.zzbs, false);
    SafeParcelWriter.writeStringList(paramParcel, 5, this.zzbt, false);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzbu, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzr
 * JD-Core Version:    0.7.0.1
 */