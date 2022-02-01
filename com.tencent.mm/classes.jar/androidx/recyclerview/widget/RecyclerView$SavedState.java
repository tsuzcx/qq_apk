package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RecyclerView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  Parcelable alF;
  
  static
  {
    AppMethodBeat.i(262404);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(262404);
  }
  
  RecyclerView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    AppMethodBeat.i(262399);
    if (paramClassLoader != null) {}
    for (;;)
    {
      this.alF = paramParcel.readParcelable(paramClassLoader);
      AppMethodBeat.o(262399);
      return;
      paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
    }
  }
  
  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(262402);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.alF, 0);
    AppMethodBeat.o(262402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.SavedState
 * JD-Core Version:    0.7.0.1
 */