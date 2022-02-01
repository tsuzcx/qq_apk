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
  private int aFZ;
  public final SchemeData[] aXj;
  public final int aXk;
  
  static
  {
    AppMethodBeat.i(91882);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(91882);
  }
  
  DrmInitData(Parcel paramParcel)
  {
    AppMethodBeat.i(91876);
    this.aXj = ((SchemeData[])paramParcel.createTypedArray(SchemeData.CREATOR));
    this.aXk = this.aXj.length;
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
      this.aXj = paramVarArgs;
      this.aXk = paramVarArgs.length;
      AppMethodBeat.o(91875);
      return;
    }
  }
  
  public DrmInitData(SchemeData... paramVarArgs)
  {
    this(true, paramVarArgs);
  }
  
  public final DrmInitData an(String paramString)
  {
    AppMethodBeat.i(91877);
    Object localObject = this.aXj;
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (x.g(localObject[i].type, paramString)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        SchemeData[] arrayOfSchemeData = new SchemeData[this.aXj.length];
        i = 0;
        label54:
        if (i < arrayOfSchemeData.length)
        {
          localObject = this.aXj[i];
          if (x.g(((SchemeData)localObject).type, paramString)) {}
          for (;;)
          {
            arrayOfSchemeData[i] = localObject;
            i += 1;
            break label54;
            i += 1;
            break;
            localObject = new SchemeData(((SchemeData)localObject).uuid, paramString, ((SchemeData)localObject).mimeType, ((SchemeData)localObject).data, ((SchemeData)localObject).aXl);
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
    boolean bool = Arrays.equals(this.aXj, ((DrmInitData)paramObject).aXj);
    AppMethodBeat.o(91879);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(91878);
    if (this.aFZ == 0) {
      this.aFZ = Arrays.hashCode(this.aXj);
    }
    int i = this.aFZ;
    AppMethodBeat.o(91878);
    return i;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(91880);
    paramParcel.writeTypedArray(this.aXj, 0);
    AppMethodBeat.o(91880);
  }
  
  public static final class SchemeData
    implements Parcelable
  {
    public static final Parcelable.Creator<SchemeData> CREATOR;
    private int aFZ;
    public final boolean aXl;
    public final byte[] data;
    public final String mimeType;
    public final String type;
    final UUID uuid;
    
    static
    {
      AppMethodBeat.i(91873);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(91873);
    }
    
    SchemeData(Parcel paramParcel)
    {
      AppMethodBeat.i(91869);
      this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
      this.type = paramParcel.readString();
      this.mimeType = paramParcel.readString();
      this.data = paramParcel.createByteArray();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.aXl = bool;
        AppMethodBeat.o(91869);
        return;
      }
    }
    
    public SchemeData(UUID paramUUID, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(91868);
      this.uuid = ((UUID)a.checkNotNull(paramUUID));
      this.type = paramString1;
      this.mimeType = ((String)a.checkNotNull(paramString2));
      this.data = ((byte[])a.checkNotNull(paramArrayOfByte));
      this.aXl = paramBoolean;
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
      if ((this.mimeType.equals(paramObject.mimeType)) && (x.g(this.uuid, paramObject.uuid)) && (x.g(this.type, paramObject.type)) && (Arrays.equals(this.data, paramObject.data)))
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
      if (this.aFZ == 0)
      {
        j = this.uuid.hashCode();
        if (this.type != null) {
          break label73;
        }
      }
      label73:
      for (int i = 0;; i = this.type.hashCode())
      {
        this.aFZ = (((i + j * 31) * 31 + this.mimeType.hashCode()) * 31 + Arrays.hashCode(this.data));
        i = this.aFZ;
        AppMethodBeat.o(91871);
        return i;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(91872);
      paramParcel.writeLong(this.uuid.getMostSignificantBits());
      paramParcel.writeLong(this.uuid.getLeastSignificantBits());
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.mimeType);
      paramParcel.writeByteArray(this.data);
      if (this.aXl) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(91872);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.7.0.1
 */