package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16})
public final class PhoneItem$b
  implements Parcelable.Creator
{
  public final Object createFromParcel(Parcel paramParcel)
  {
    boolean bool4 = true;
    AppMethodBeat.i(192393);
    p.h(paramParcel, "in");
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    boolean bool1;
    boolean bool2;
    label62:
    boolean bool3;
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      if (paramParcel.readInt() == 0) {
        break label115;
      }
      bool2 = true;
      if (paramParcel.readInt() == 0) {
        break label120;
      }
      bool3 = true;
      label72:
      if (paramParcel.readInt() == 0) {
        break label126;
      }
    }
    for (;;)
    {
      paramParcel = new PhoneItem(str1, str2, str3, str4, str5, bool1, bool2, bool3, bool4);
      AppMethodBeat.o(192393);
      return paramParcel;
      bool1 = false;
      break;
      label115:
      bool2 = false;
      break label62;
      label120:
      bool3 = false;
      break label72;
      label126:
      bool4 = false;
    }
  }
  
  public final Object[] newArray(int paramInt)
  {
    return new PhoneItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.b
 * JD-Core Version:    0.7.0.1
 */