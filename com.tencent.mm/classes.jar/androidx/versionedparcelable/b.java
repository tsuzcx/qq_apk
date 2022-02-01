package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends a
{
  private final int OQ;
  private final SparseIntArray aBv;
  private final Parcel aBw;
  private int aBx;
  private int aBy;
  private final int fq;
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
    this.aBv = new SparseIntArray();
    this.aBx = -1;
    this.aBy = 0;
    this.aBw = paramParcel;
    this.fq = paramInt1;
    this.OQ = paramInt2;
    this.aBy = this.fq;
    this.mPrefix = paramString;
    AppMethodBeat.o(62411);
  }
  
  public final void a(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62419);
    this.aBw.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(62419);
  }
  
  public final boolean di(int paramInt)
  {
    AppMethodBeat.i(62412);
    int j;
    do
    {
      if (this.aBy >= this.OQ) {
        break;
      }
      this.aBw.setDataPosition(this.aBy);
      int i = this.aBw.readInt();
      j = this.aBw.readInt();
      this.aBy = (i + this.aBy);
    } while (j != paramInt);
    for (paramInt = this.aBw.dataPosition(); paramInt == -1; paramInt = -1)
    {
      AppMethodBeat.o(62412);
      return false;
    }
    this.aBw.setDataPosition(paramInt);
    AppMethodBeat.o(62412);
    return true;
  }
  
  public final void dj(int paramInt)
  {
    AppMethodBeat.i(62413);
    nu();
    this.aBx = paramInt;
    this.aBv.put(paramInt, this.aBw.dataPosition());
    writeInt(0);
    writeInt(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void nu()
  {
    AppMethodBeat.i(62414);
    if (this.aBx >= 0)
    {
      int i = this.aBv.get(this.aBx);
      int j = this.aBw.dataPosition();
      this.aBw.setDataPosition(i);
      this.aBw.writeInt(j - i);
      this.aBw.setDataPosition(j);
    }
    AppMethodBeat.o(62414);
  }
  
  protected final a nv()
  {
    AppMethodBeat.i(62415);
    Object localObject = this.aBw;
    int j = this.aBw.dataPosition();
    if (this.aBy == this.fq) {}
    for (int i = this.OQ;; i = this.aBy)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ");
      AppMethodBeat.o(62415);
      return localObject;
    }
  }
  
  public final byte[] nw()
  {
    AppMethodBeat.i(62422);
    int i = this.aBw.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(62422);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.aBw.readByteArray(arrayOfByte);
    AppMethodBeat.o(62422);
    return arrayOfByte;
  }
  
  public final <T extends Parcelable> T nx()
  {
    AppMethodBeat.i(62423);
    Parcelable localParcelable = this.aBw.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(62423);
    return localParcelable;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(62420);
    int i = this.aBw.readInt();
    AppMethodBeat.o(62420);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(62421);
    String str = this.aBw.readString();
    AppMethodBeat.o(62421);
    return str;
  }
  
  public final void writeByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62416);
    if (paramArrayOfByte != null)
    {
      this.aBw.writeInt(paramArrayOfByte.length);
      this.aBw.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(62416);
      return;
    }
    this.aBw.writeInt(-1);
    AppMethodBeat.o(62416);
  }
  
  public final void writeInt(int paramInt)
  {
    AppMethodBeat.i(62417);
    this.aBw.writeInt(paramInt);
    AppMethodBeat.o(62417);
  }
  
  public final void writeString(String paramString)
  {
    AppMethodBeat.i(62418);
    this.aBw.writeString(paramString);
    AppMethodBeat.o(62418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */