package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends a
{
  private final int MW;
  private final int MZ;
  private final SparseIntArray azE;
  private final Parcel azF;
  private int azG;
  private int azH;
  private final String mPrefix;
  
  b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "");
    AppMethodBeat.i(62410);
    AppMethodBeat.o(62410);
  }
  
  private b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(62411);
    this.azE = new SparseIntArray();
    this.azG = -1;
    this.azH = 0;
    this.azF = paramParcel;
    this.MW = paramInt1;
    this.MZ = paramInt2;
    this.azH = this.MW;
    this.mPrefix = paramString;
    AppMethodBeat.o(62411);
  }
  
  public final void a(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62419);
    this.azF.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(62419);
  }
  
  public final boolean di(int paramInt)
  {
    AppMethodBeat.i(62412);
    int j;
    do
    {
      if (this.azH >= this.MZ) {
        break;
      }
      this.azF.setDataPosition(this.azH);
      int i = this.azF.readInt();
      j = this.azF.readInt();
      this.azH = (i + this.azH);
    } while (j != paramInt);
    for (paramInt = this.azF.dataPosition(); paramInt == -1; paramInt = -1)
    {
      AppMethodBeat.o(62412);
      return false;
    }
    this.azF.setDataPosition(paramInt);
    AppMethodBeat.o(62412);
    return true;
  }
  
  public final void dj(int paramInt)
  {
    AppMethodBeat.i(62413);
    nc();
    this.azG = paramInt;
    this.azE.put(paramInt, this.azF.dataPosition());
    writeInt(0);
    writeInt(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void nc()
  {
    AppMethodBeat.i(62414);
    if (this.azG >= 0)
    {
      int i = this.azE.get(this.azG);
      int j = this.azF.dataPosition();
      this.azF.setDataPosition(i);
      this.azF.writeInt(j - i);
      this.azF.setDataPosition(j);
    }
    AppMethodBeat.o(62414);
  }
  
  protected final a nd()
  {
    AppMethodBeat.i(62415);
    Object localObject = this.azF;
    int j = this.azF.dataPosition();
    if (this.azH == this.MW) {}
    for (int i = this.MZ;; i = this.azH)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ");
      AppMethodBeat.o(62415);
      return localObject;
    }
  }
  
  public final byte[] ne()
  {
    AppMethodBeat.i(62422);
    int i = this.azF.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(62422);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.azF.readByteArray(arrayOfByte);
    AppMethodBeat.o(62422);
    return arrayOfByte;
  }
  
  public final <T extends Parcelable> T nf()
  {
    AppMethodBeat.i(62423);
    Parcelable localParcelable = this.azF.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(62423);
    return localParcelable;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(62420);
    int i = this.azF.readInt();
    AppMethodBeat.o(62420);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(62421);
    String str = this.azF.readString();
    AppMethodBeat.o(62421);
    return str;
  }
  
  public final void writeByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62416);
    if (paramArrayOfByte != null)
    {
      this.azF.writeInt(paramArrayOfByte.length);
      this.azF.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(62416);
      return;
    }
    this.azF.writeInt(-1);
    AppMethodBeat.o(62416);
  }
  
  public final void writeInt(int paramInt)
  {
    AppMethodBeat.i(62417);
    this.azF.writeInt(paramInt);
    AppMethodBeat.o(62417);
  }
  
  public final void writeString(String paramString)
  {
    AppMethodBeat.i(62418);
    this.azF.writeString(paramString);
    AppMethodBeat.o(62418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */