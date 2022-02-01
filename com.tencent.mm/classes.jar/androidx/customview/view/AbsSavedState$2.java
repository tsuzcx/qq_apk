package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AbsSavedState$2
  implements Parcelable.ClassLoaderCreator<AbsSavedState>
{
  private static AbsSavedState c(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(192486);
    if (paramParcel.readParcelable(paramClassLoader) != null)
    {
      paramParcel = new IllegalStateException("superState must be null");
      AppMethodBeat.o(192486);
      throw paramParcel;
    }
    paramParcel = AbsSavedState.bxr;
    AppMethodBeat.o(192486);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.customview.view.AbsSavedState.2
 * JD-Core Version:    0.7.0.1
 */