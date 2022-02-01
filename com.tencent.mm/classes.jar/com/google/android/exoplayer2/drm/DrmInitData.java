package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Parcelable, Comparator<SchemeData>
{
  public static final Parcelable.Creator<DrmInitData> CREATOR;
  private int cHb;
  public final SchemeData[] cLc;
  public final int cLd;
  
  static
  {
    AppMethodBeat.i(91882);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(91882);
  }
  
  DrmInitData(Parcel paramParcel)
  {
    AppMethodBeat.i(91876);
    this.cLc = ((SchemeData[])paramParcel.createTypedArray(SchemeData.CREATOR));
    this.cLd = this.cLc.length;
    AppMethodBeat.o(91876);
  }
  
  public DrmInitData(List<SchemeData> paramList)
  {
    this(false, (SchemeData[])paramList.toArray(new SchemeData[paramList.size()]));
    AppMethodBeat.i(91874);
    AppMethodBeat.o(91874);
  }
  
  private DrmInitData(boolean paramBoolean, SchemeData... paramVarArgs)
  {
    AppMethodBeat.i(91875);
    if (paramBoolean) {
      paramVarArgs = (SchemeData[])paramVarArgs.clone();
    }
    for (;;)
    {
      Arrays.sort(paramVarArgs, this);
      int i = 1;
      while (i < paramVarArgs.length)
      {
        if (SchemeData.a(paramVarArgs[(i - 1)]).equals(SchemeData.a(paramVarArgs[i])))
        {
          paramVarArgs = new IllegalArgumentException("Duplicate data for uuid: " + SchemeData.a(paramVarArgs[i]));
          AppMethodBeat.o(91875);
          throw paramVarArgs;
        }
        i += 1;
      }
      this.cLc = paramVarArgs;
      this.cLd = paramVarArgs.length;
      AppMethodBeat.o(91875);
      return;
    }
  }
  
  public DrmInitData(SchemeData... paramVarArgs)
  {
    this(true, paramVarArgs);
  }
  
  public final DrmInitData cJ(String paramString)
  {
    AppMethodBeat.i(91877);
    Object localObject = this.cLc;
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (x.p(localObject[i].type, paramString)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        SchemeData[] arrayOfSchemeData = new SchemeData[this.cLc.length];
        i = 0;
        label54:
        if (i < arrayOfSchemeData.length)
        {
          localObject = this.cLc[i];
          if (x.p(((SchemeData)localObject).type, paramString)) {}
          for (;;)
          {
            arrayOfSchemeData[i] = localObject;
            i += 1;
            break label54;
            i += 1;
            break;
            localObject = new SchemeData(((SchemeData)localObject).cLe, paramString, ((SchemeData)localObject).mimeType, ((SchemeData)localObject).data, ((SchemeData)localObject).cLf);
          }
        }
        paramString = new DrmInitData(arrayOfSchemeData);
        AppMethodBeat.o(91877);
        return paramString;
      }
      AppMethodBeat.o(91877);
      return this;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(91879);
    if (this == paramObject)
    {
      AppMethodBeat.o(91879);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(91879);
      return false;
    }
    boolean bool = Arrays.equals(this.cLc, ((DrmInitData)paramObject).cLc);
    AppMethodBeat.o(91879);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(91878);
    if (this.cHb == 0) {
      this.cHb = Arrays.hashCode(this.cLc);
    }
    int i = this.cHb;
    AppMethodBeat.o(91878);
    return i;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(91880);
    paramParcel.writeTypedArray(this.cLc, 0);
    AppMethodBeat.o(91880);
  }
  
  public static final class SchemeData
    implements Parcelable
  {
    public static final Parcelable.Creator<SchemeData> CREATOR;
    private int cHb;
    final UUID cLe;
    public final boolean cLf;
    public final byte[] data;
    public final String mimeType;
    public final String type;
    
    static
    {
      AppMethodBeat.i(91873);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(91873);
    }
    
    SchemeData(Parcel paramParcel)
    {
      AppMethodBeat.i(91869);
      this.cLe = new UUID(paramParcel.readLong(), paramParcel.readLong());
      this.type = paramParcel.readString();
      this.mimeType = paramParcel.readString();
      this.data = paramParcel.createByteArray();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cLf = bool;
        AppMethodBeat.o(91869);
        return;
      }
    }
    
    public SchemeData(UUID paramUUID, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(91868);
      this.cLe = ((UUID)a.checkNotNull(paramUUID));
      this.type = paramString1;
      this.mimeType = ((String)a.checkNotNull(paramString2));
      this.data = ((byte[])a.checkNotNull(paramArrayOfByte));
      this.cLf = paramBoolean;
      AppMethodBeat.o(91868);
    }
    
    public SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte)
    {
      this(paramUUID, null, paramString, paramArrayOfByte, false);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(91870);
      if (!(paramObject instanceof SchemeData))
      {
        AppMethodBeat.o(91870);
        return false;
      }
      if (paramObject == this)
      {
        AppMethodBeat.o(91870);
        return true;
      }
      paramObject = (SchemeData)paramObject;
      if ((this.mimeType.equals(paramObject.mimeType)) && (x.p(this.cLe, paramObject.cLe)) && (x.p(this.type, paramObject.type)) && (Arrays.equals(this.data, paramObject.data)))
      {
        AppMethodBeat.o(91870);
        return true;
      }
      AppMethodBeat.o(91870);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(91871);
      int j;
      if (this.cHb == 0)
      {
        j = this.cLe.hashCode();
        if (this.type != null) {
          break label73;
        }
      }
      label73:
      for (int i = 0;; i = this.type.hashCode())
      {
        this.cHb = (((i + j * 31) * 31 + this.mimeType.hashCode()) * 31 + Arrays.hashCode(this.data));
        i = this.cHb;
        AppMethodBeat.o(91871);
        return i;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(91872);
      paramParcel.writeLong(this.cLe.getMostSignificantBits());
      paramParcel.writeLong(this.cLe.getLeastSignificantBits());
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.mimeType);
      paramParcel.writeByteArray(this.data);
      if (this.cLf) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(91872);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.7.0.1
 */