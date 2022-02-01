package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "T", "Landroidx/compose/runtime/SnapshotMutableStateImpl;", "Landroid/os/Parcelable;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ParcelableSnapshotMutableState<T>
  extends bh<T>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSnapshotMutableState<Object>> CREATOR;
  public static final ParcelableSnapshotMutableState.a aow;
  
  static
  {
    AppMethodBeat.i(202314);
    aow = new ParcelableSnapshotMutableState.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(202314);
  }
  
  public ParcelableSnapshotMutableState(T paramT, bi<T> parambi)
  {
    super(paramT, parambi);
    AppMethodBeat.i(202307);
    AppMethodBeat.o(202307);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(202324);
    s.u(paramParcel, "parcel");
    paramParcel.writeValue(getValue());
    bi localbi = qg();
    if (s.p(localbi, bj.qj())) {
      paramInt = 0;
    }
    for (;;)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(202324);
      return;
      if (s.p(localbi, bj.qi()))
      {
        paramInt = 1;
      }
      else
      {
        if (!s.p(localbi, bj.qh())) {
          break;
        }
        paramInt = 2;
      }
    }
    paramParcel = new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
    AppMethodBeat.o(202324);
    throw paramParcel;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/ParcelableSnapshotMutableState$Companion$CREATOR$1", "Landroid/os/Parcelable$ClassLoaderCreator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "newArray", "", "size", "", "(I)[Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.ClassLoaderCreator<ParcelableSnapshotMutableState<Object>>
  {
    private ParcelableSnapshotMutableState<Object> b(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      AppMethodBeat.i(202268);
      s.u(paramParcel, "parcel");
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      paramClassLoader = paramParcel.readValue(localClassLoader);
      int i = paramParcel.readInt();
      switch (i)
      {
      default: 
        paramParcel = new IllegalStateException("Unsupported MutableState policy " + i + " was restored");
        AppMethodBeat.o(202268);
        throw paramParcel;
      case 0: 
        paramParcel = bj.qj();
      }
      for (;;)
      {
        paramParcel = new ParcelableSnapshotMutableState(paramClassLoader, paramParcel);
        AppMethodBeat.o(202268);
        return paramParcel;
        paramParcel = bj.qi();
        continue;
        paramParcel = bj.qh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.ParcelableSnapshotMutableState
 * JD-Core Version:    0.7.0.1
 */