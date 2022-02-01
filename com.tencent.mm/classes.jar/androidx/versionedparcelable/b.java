package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends a
{
  private final int Pc;
  private final SparseIntArray aBt;
  private final Parcel aBu;
  private int aBv;
  private int aBw;
  private final int fs;
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
    this.aBt = new SparseIntArray();
    this.aBv = -1;
    this.aBw = 0;
    this.aBu = paramParcel;
    this.fs = paramInt1;
    this.Pc = paramInt2;
    this.aBw = this.fs;
    this.mPrefix = paramString;
    AppMethodBeat.o(62411);
  }
  
  public final void a(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62419);
    this.aBu.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(62419);
  }
  
  public final boolean dc(int paramInt)
  {
    AppMethodBeat.i(62412);
    int j;
    do
    {
      if (this.aBw >= this.Pc) {
        break;
      }
      this.aBu.setDataPosition(this.aBw);
      int i = this.aBu.readInt();
      j = this.aBu.readInt();
      this.aBw = (i + this.aBw);
    } while (j != paramInt);
    for (paramInt = this.aBu.dataPosition(); paramInt == -1; paramInt = -1)
    {
      AppMethodBeat.o(62412);
      return false;
    }
    this.aBu.setDataPosition(paramInt);
    AppMethodBeat.o(62412);
    return true;
  }
  
  public final void dd(int paramInt)
  {
    AppMethodBeat.i(62413);
    nw();
    this.aBv = paramInt;
    this.aBt.put(paramInt, this.aBu.dataPosition());
    writeInt(0);
    writeInt(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void nw()
  {
    AppMethodBeat.i(62414);
    if (this.aBv >= 0)
    {
      int i = this.aBt.get(this.aBv);
      int j = this.aBu.dataPosition();
      this.aBu.setDataPosition(i);
      this.aBu.writeInt(j - i);
      this.aBu.setDataPosition(j);
    }
    AppMethodBeat.o(62414);
  }
  
  protected final a nx()
  {
    AppMethodBeat.i(62415);
    Object localObject = this.aBu;
    int j = this.aBu.dataPosition();
    if (this.aBw == this.fs) {}
    for (int i = this.Pc;; i = this.aBw)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ");
      AppMethodBeat.o(62415);
      return localObject;
    }
  }
  
  public final byte[] ny()
  {
    AppMethodBeat.i(62422);
    int i = this.aBu.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(62422);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.aBu.readByteArray(arrayOfByte);
    AppMethodBeat.o(62422);
    return arrayOfByte;
  }
  
  public final <T extends Parcelable> T nz()
  {
    AppMethodBeat.i(62423);
    Parcelable localParcelable = this.aBu.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(62423);
    return localParcelable;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(62420);
    int i = this.aBu.readInt();
    AppMethodBeat.o(62420);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(62421);
    String str = this.aBu.readString();
    AppMethodBeat.o(62421);
    return str;
  }
  
  public final void writeByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62416);
    if (paramArrayOfByte != null)
    {
      this.aBu.writeInt(paramArrayOfByte.length);
      this.aBu.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(62416);
      return;
    }
    this.aBu.writeInt(-1);
    AppMethodBeat.o(62416);
  }
  
  public final void writeInt(int paramInt)
  {
    AppMethodBeat.i(62417);
    this.aBu.writeInt(paramInt);
    AppMethodBeat.o(62417);
  }
  
  public final void writeString(String paramString)
  {
    AppMethodBeat.i(62418);
    this.aBu.writeString(paramString);
    AppMethodBeat.o(62418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */