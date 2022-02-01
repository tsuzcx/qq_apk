package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class b
  extends a
{
  private final int Sc;
  private final SparseIntArray cjA;
  private final Parcel cjB;
  private int cjC;
  private int cjD;
  private int cjE;
  private final String mPrefix;
  private final int uH;
  
  b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new androidx.b.a(), new androidx.b.a(), new androidx.b.a());
    AppMethodBeat.i(62410);
    AppMethodBeat.o(62410);
  }
  
  private b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, androidx.b.a<String, Method> parama1, androidx.b.a<String, Method> parama2, androidx.b.a<String, Class> parama)
  {
    super(parama1, parama2, parama);
    AppMethodBeat.i(192925);
    this.cjA = new SparseIntArray();
    this.cjC = -1;
    this.cjD = 0;
    this.cjE = -1;
    this.cjB = paramParcel;
    this.Sc = paramInt1;
    this.uH = paramInt2;
    this.cjD = this.Sc;
    this.mPrefix = paramString;
    AppMethodBeat.o(192925);
  }
  
  protected final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(193006);
    TextUtils.writeToParcel(paramCharSequence, this.cjB, 0);
    AppMethodBeat.o(193006);
  }
  
  public final void Mj()
  {
    AppMethodBeat.i(62414);
    if (this.cjC >= 0)
    {
      int i = this.cjA.get(this.cjC);
      int j = this.cjB.dataPosition();
      this.cjB.setDataPosition(i);
      this.cjB.writeInt(j - i);
      this.cjB.setDataPosition(j);
    }
    AppMethodBeat.o(62414);
  }
  
  protected final a Mk()
  {
    AppMethodBeat.i(62415);
    Object localObject = this.cjB;
    int j = this.cjB.dataPosition();
    if (this.cjD == this.Sc) {}
    for (int i = this.uH;; i = this.cjD)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ", this.cjx, this.cjy, this.cjz);
      AppMethodBeat.o(62415);
      return localObject;
    }
  }
  
  public final byte[] Ml()
  {
    AppMethodBeat.i(62422);
    int i = this.cjB.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(62422);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.cjB.readByteArray(arrayOfByte);
    AppMethodBeat.o(62422);
    return arrayOfByte;
  }
  
  protected final CharSequence Mm()
  {
    AppMethodBeat.i(193031);
    CharSequence localCharSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.cjB);
    AppMethodBeat.o(193031);
    return localCharSequence;
  }
  
  public final <T extends Parcelable> T Mn()
  {
    AppMethodBeat.i(62423);
    Parcelable localParcelable = this.cjB.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(62423);
    return localParcelable;
  }
  
  public final void aU(String paramString)
  {
    AppMethodBeat.i(62418);
    this.cjB.writeString(paramString);
    AppMethodBeat.o(62418);
  }
  
  public final void aX(int paramInt)
  {
    AppMethodBeat.i(62417);
    this.cjB.writeInt(paramInt);
    AppMethodBeat.o(62417);
  }
  
  public final void b(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62419);
    this.cjB.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(62419);
  }
  
  public final void bn(boolean paramBoolean)
  {
    AppMethodBeat.i(192997);
    Parcel localParcel = this.cjB;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localParcel.writeInt(i);
      AppMethodBeat.o(192997);
      return;
    }
  }
  
  public final boolean gM(int paramInt)
  {
    AppMethodBeat.i(62412);
    while (this.cjD < this.uH)
    {
      if (this.cjE == paramInt)
      {
        AppMethodBeat.o(62412);
        return true;
      }
      if (String.valueOf(this.cjE).compareTo(String.valueOf(paramInt)) > 0)
      {
        AppMethodBeat.o(62412);
        return false;
      }
      this.cjB.setDataPosition(this.cjD);
      int i = this.cjB.readInt();
      this.cjE = this.cjB.readInt();
      this.cjD = (i + this.cjD);
    }
    if (this.cjE == paramInt)
    {
      AppMethodBeat.o(62412);
      return true;
    }
    AppMethodBeat.o(62412);
    return false;
  }
  
  public final void gN(int paramInt)
  {
    AppMethodBeat.i(62413);
    Mj();
    this.cjC = paramInt;
    this.cjA.put(paramInt, this.cjB.dataPosition());
    aX(0);
    aX(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void o(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62416);
    if (paramArrayOfByte != null)
    {
      this.cjB.writeInt(paramArrayOfByte.length);
      this.cjB.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(62416);
      return;
    }
    this.cjB.writeInt(-1);
    AppMethodBeat.o(62416);
  }
  
  public final boolean readBoolean()
  {
    AppMethodBeat.i(193056);
    if (this.cjB.readInt() != 0)
    {
      AppMethodBeat.o(193056);
      return true;
    }
    AppMethodBeat.o(193056);
    return false;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(62420);
    int i = this.cjB.readInt();
    AppMethodBeat.o(62420);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(62421);
    String str = this.cjB.readString();
    AppMethodBeat.o(62421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */