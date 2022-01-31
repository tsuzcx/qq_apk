package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends a
{
  private final int Fb;
  private final int Fe;
  private final SparseIntArray aqL;
  private final Parcel aqM;
  private int aqN;
  private int aqO;
  private final String mPrefix;
  
  b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "");
    AppMethodBeat.i(145818);
    AppMethodBeat.o(145818);
  }
  
  private b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(145819);
    this.aqL = new SparseIntArray();
    this.aqN = -1;
    this.aqO = 0;
    this.aqM = paramParcel;
    this.Fb = paramInt1;
    this.Fe = paramInt2;
    this.aqO = this.Fb;
    this.mPrefix = paramString;
    AppMethodBeat.o(145819);
  }
  
  public final void a(Parcelable paramParcelable)
  {
    AppMethodBeat.i(145827);
    this.aqM.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(145827);
  }
  
  public final boolean cM(int paramInt)
  {
    AppMethodBeat.i(145820);
    int j;
    do
    {
      if (this.aqO >= this.Fe) {
        break;
      }
      this.aqM.setDataPosition(this.aqO);
      int i = this.aqM.readInt();
      j = this.aqM.readInt();
      this.aqO = (i + this.aqO);
    } while (j != paramInt);
    for (paramInt = this.aqM.dataPosition(); paramInt == -1; paramInt = -1)
    {
      AppMethodBeat.o(145820);
      return false;
    }
    this.aqM.setDataPosition(paramInt);
    AppMethodBeat.o(145820);
    return true;
  }
  
  public final void cN(int paramInt)
  {
    AppMethodBeat.i(145821);
    lg();
    this.aqN = paramInt;
    this.aqL.put(paramInt, this.aqM.dataPosition());
    writeInt(0);
    writeInt(paramInt);
    AppMethodBeat.o(145821);
  }
  
  public final void lg()
  {
    AppMethodBeat.i(145822);
    if (this.aqN >= 0)
    {
      int i = this.aqL.get(this.aqN);
      int j = this.aqM.dataPosition();
      this.aqM.setDataPosition(i);
      this.aqM.writeInt(j - i);
      this.aqM.setDataPosition(j);
    }
    AppMethodBeat.o(145822);
  }
  
  protected final a lh()
  {
    AppMethodBeat.i(145823);
    Object localObject = this.aqM;
    int j = this.aqM.dataPosition();
    if (this.aqO == this.Fb) {}
    for (int i = this.Fe;; i = this.aqO)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ");
      AppMethodBeat.o(145823);
      return localObject;
    }
  }
  
  public final byte[] li()
  {
    AppMethodBeat.i(145830);
    int i = this.aqM.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(145830);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.aqM.readByteArray(arrayOfByte);
    AppMethodBeat.o(145830);
    return arrayOfByte;
  }
  
  public final <T extends Parcelable> T lj()
  {
    AppMethodBeat.i(145831);
    Parcelable localParcelable = this.aqM.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(145831);
    return localParcelable;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(145828);
    int i = this.aqM.readInt();
    AppMethodBeat.o(145828);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(145829);
    String str = this.aqM.readString();
    AppMethodBeat.o(145829);
    return str;
  }
  
  public final void writeByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145824);
    if (paramArrayOfByte != null)
    {
      this.aqM.writeInt(paramArrayOfByte.length);
      this.aqM.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(145824);
      return;
    }
    this.aqM.writeInt(-1);
    AppMethodBeat.o(145824);
  }
  
  public final void writeInt(int paramInt)
  {
    AppMethodBeat.i(145825);
    this.aqM.writeInt(paramInt);
    AppMethodBeat.o(145825);
  }
  
  public final void writeString(String paramString)
  {
    AppMethodBeat.i(145826);
    this.aqM.writeString(paramString);
    AppMethodBeat.o(145826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */