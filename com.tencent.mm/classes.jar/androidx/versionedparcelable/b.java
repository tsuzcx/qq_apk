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
  private final SparseIntArray avd;
  private final Parcel ave;
  private int avf;
  private int avh;
  private int avi;
  private final String mPrefix;
  private final int tI;
  private final int zP;
  
  b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new androidx.b.a(), new androidx.b.a(), new androidx.b.a());
    AppMethodBeat.i(62410);
    AppMethodBeat.o(62410);
  }
  
  private b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, androidx.b.a<String, Method> parama1, androidx.b.a<String, Method> parama2, androidx.b.a<String, Class> parama)
  {
    super(parama1, parama2, parama);
    AppMethodBeat.i(243971);
    this.avd = new SparseIntArray();
    this.avf = -1;
    this.avh = 0;
    this.avi = -1;
    this.ave = paramParcel;
    this.zP = paramInt1;
    this.tI = paramInt2;
    this.avh = this.zP;
    this.mPrefix = paramString;
    AppMethodBeat.o(243971);
  }
  
  public final void T(String paramString)
  {
    AppMethodBeat.i(62418);
    this.ave.writeString(paramString);
    AppMethodBeat.o(62418);
  }
  
  public final void a(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62419);
    this.ave.writeParcelable(paramParcelable, 0);
    AppMethodBeat.o(62419);
  }
  
  public final void aF(boolean paramBoolean)
  {
    AppMethodBeat.i(243972);
    Parcel localParcel = this.ave;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localParcel.writeInt(i);
      AppMethodBeat.o(243972);
      return;
    }
  }
  
  public final void bV(int paramInt)
  {
    AppMethodBeat.i(62417);
    this.ave.writeInt(paramInt);
    AppMethodBeat.o(62417);
  }
  
  public final boolean dC(int paramInt)
  {
    AppMethodBeat.i(62412);
    while (this.avh < this.tI)
    {
      if (this.avi == paramInt)
      {
        AppMethodBeat.o(62412);
        return true;
      }
      if (String.valueOf(this.avi).compareTo(String.valueOf(paramInt)) > 0)
      {
        AppMethodBeat.o(62412);
        return false;
      }
      this.ave.setDataPosition(this.avh);
      int i = this.ave.readInt();
      this.avi = this.ave.readInt();
      this.avh = (i + this.avh);
    }
    if (this.avi == paramInt)
    {
      AppMethodBeat.o(62412);
      return true;
    }
    AppMethodBeat.o(62412);
    return false;
  }
  
  public final void dD(int paramInt)
  {
    AppMethodBeat.i(62413);
    nE();
    this.avf = paramInt;
    this.avd.put(paramInt, this.ave.dataPosition());
    bV(0);
    bV(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62416);
    if (paramArrayOfByte != null)
    {
      this.ave.writeInt(paramArrayOfByte.length);
      this.ave.writeByteArray(paramArrayOfByte);
      AppMethodBeat.o(62416);
      return;
    }
    this.ave.writeInt(-1);
    AppMethodBeat.o(62416);
  }
  
  public final void nE()
  {
    AppMethodBeat.i(62414);
    if (this.avf >= 0)
    {
      int i = this.avd.get(this.avf);
      int j = this.ave.dataPosition();
      this.ave.setDataPosition(i);
      this.ave.writeInt(j - i);
      this.ave.setDataPosition(j);
    }
    AppMethodBeat.o(62414);
  }
  
  protected final a nF()
  {
    AppMethodBeat.i(62415);
    Object localObject = this.ave;
    int j = this.ave.dataPosition();
    if (this.avh == this.zP) {}
    for (int i = this.tI;; i = this.avh)
    {
      localObject = new b((Parcel)localObject, j, i, this.mPrefix + "  ", this.ava, this.avb, this.avc);
      AppMethodBeat.o(62415);
      return localObject;
    }
  }
  
  public final byte[] nG()
  {
    AppMethodBeat.i(62422);
    int i = this.ave.readInt();
    if (i < 0)
    {
      AppMethodBeat.o(62422);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.ave.readByteArray(arrayOfByte);
    AppMethodBeat.o(62422);
    return arrayOfByte;
  }
  
  protected final CharSequence nH()
  {
    AppMethodBeat.i(243974);
    CharSequence localCharSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.ave);
    AppMethodBeat.o(243974);
    return localCharSequence;
  }
  
  public final <T extends Parcelable> T nI()
  {
    AppMethodBeat.i(62423);
    Parcelable localParcelable = this.ave.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(62423);
    return localParcelable;
  }
  
  public final boolean readBoolean()
  {
    AppMethodBeat.i(243975);
    if (this.ave.readInt() != 0)
    {
      AppMethodBeat.o(243975);
      return true;
    }
    AppMethodBeat.o(243975);
    return false;
  }
  
  public final int readInt()
  {
    AppMethodBeat.i(62420);
    int i = this.ave.readInt();
    AppMethodBeat.o(62420);
    return i;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(62421);
    String str = this.ave.readString();
    AppMethodBeat.o(62421);
    return str;
  }
  
  protected final void v(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(243973);
    TextUtils.writeToParcel(paramCharSequence, this.ave, 0);
    AppMethodBeat.o(243973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */