package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends a
{
  private final int LZ;
  private final int Mc;
  private final SparseIntArray ayK;
  private final Parcel ayL;
  private int ayM;
  private int ayN;
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
    this.ayK = new SparseIntArray();
    this.ayM = -1;
    this.ayN = 0;
    this.ayL = paramParcel;
    this.LZ = paramInt1;
    this.Mc = paramInt2;
    this.ayN = this.LZ;
    this.mPrefix = paramString;
    AppMethodBeat.o(62411);
  }
  
  public final void a(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62419);
    this.ayL.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(62419);
  }
  
  public final boolean dj(int paramInt)
  {
    AppMethodBeat.i(62412);
    int j;
    do
    {
      if (this.ayN >= this.Mc) {
        break;
      }
      this.ayL.setDataPosition(this.ayN);
      int i = this.ayL.readInt();
      j = this.ayL.readInt();
      this.ayN = (i + this.ayN);
    } while (j != paramInt);
    for (paramInt = this.ayL.dataPosition(); paramInt == -1; paramInt = -1)
    {
      AppMethodBeat.o(62412);
      return false;
    }
    this.ayL.setDataPosition(paramInt);
    AppMethodBeat.o(62412);
    return true;
  }
  
  public final void dk(int paramInt)
  {
    AppMethodBeat.i(62413);
    mS();
    this.ayM = paramInt;
    this.ayK.put(paramInt, this.ayL.dataPosition());
    writeInt(0);
    writeInt(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void mS()
  {
    AppMethodBeat.i(62414);
    if (this.ayM >= 0)
    {
      int i = this.ayK.get(this.ayM);
      int j = this.ayL.dataPosition();
      this.ayL.setDataPosition(i);
      this.ayL.writeInt(j - i);
      this.ayL.setDataPosition(j);
    }
    AppMethodBeat.o(62414);
  }
  
  protected final a mT()
  {
    AppMethodBeat.i(62415);
    Object localObject = this.ayL;
    int j = this.ayL.dataPosition();
    if (this.ayN == this.LZ) {}
    for (int i = this.Mc;; i = this.ayN)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ");
      AppMethodBeat.o(62415);
      return localObject;
    }
  }
  
  public final byte[] mU()
  {
    AppMethodBeat.i(62422);
    int i = this.ayL.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(62422);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.ayL.readByteArray(arrayOfByte);
    AppMethodBeat.o(62422);
    return arrayOfByte;
  }
  
  public final <T extends Parcelable> T mV()
  {
    AppMethodBeat.i(62423);
    Parcelable localParcelable = this.ayL.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(62423);
    return localParcelable;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(62420);
    int i = this.ayL.readInt();
    AppMethodBeat.o(62420);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(62421);
    String str = this.ayL.readString();
    AppMethodBeat.o(62421);
    return str;
  }
  
  public final void writeByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62416);
    if (paramArrayOfByte != null)
    {
      this.ayL.writeInt(paramArrayOfByte.length);
      this.ayL.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(62416);
      return;
    }
    this.ayL.writeInt(-1);
    AppMethodBeat.o(62416);
  }
  
  public final void writeInt(int paramInt)
  {
    AppMethodBeat.i(62417);
    this.ayL.writeInt(paramInt);
    AppMethodBeat.o(62417);
  }
  
  public final void writeString(String paramString)
  {
    AppMethodBeat.i(62418);
    this.ayL.writeString(paramString);
    AppMethodBeat.o(62418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */