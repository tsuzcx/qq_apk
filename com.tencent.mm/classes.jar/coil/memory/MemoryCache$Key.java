package coil.memory;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "()V", "Companion", "Complex", "Simple", "Lcoil/memory/MemoryCache$Key$Simple;", "Lcoil/memory/MemoryCache$Key$Complex;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MemoryCache$Key
  implements Parcelable
{
  public static final a cos = new a((byte)0);
  
  @Metadata(d1={""}, d2={"Lcoil/memory/MemoryCache$Key$Complex;", "Lcoil/memory/MemoryCache$Key;", "base", "", "transformations", "", "size", "Lcoil/size/Size;", "parameters", "", "(Ljava/lang/String;Ljava/util/List;Lcoil/size/Size;Ljava/util/Map;)V", "getBase", "()Ljava/lang/String;", "getParameters", "()Ljava/util/Map;", "getSize", "()Lcoil/size/Size;", "getTransformations", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Complex
    extends MemoryCache.Key
  {
    public static final Parcelable.Creator<Complex> CREATOR;
    private final String base;
    public final Size cob;
    private final List<String> cot;
    private final Map<String, String> cou;
    
    static
    {
      AppMethodBeat.i(188268);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(188268);
    }
    
    public Complex(String paramString, List<String> paramList, Size paramSize, Map<String, String> paramMap)
    {
      super();
      AppMethodBeat.i(188260);
      this.base = paramString;
      this.cot = paramList;
      this.cob = paramSize;
      this.cou = paramMap;
      AppMethodBeat.o(188260);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(188294);
      if (this == paramObject)
      {
        AppMethodBeat.o(188294);
        return true;
      }
      if (!(paramObject instanceof Complex))
      {
        AppMethodBeat.o(188294);
        return false;
      }
      paramObject = (Complex)paramObject;
      if (!s.p(this.base, paramObject.base))
      {
        AppMethodBeat.o(188294);
        return false;
      }
      if (!s.p(this.cot, paramObject.cot))
      {
        AppMethodBeat.o(188294);
        return false;
      }
      if (!s.p(this.cob, paramObject.cob))
      {
        AppMethodBeat.o(188294);
        return false;
      }
      if (!s.p(this.cou, paramObject.cou))
      {
        AppMethodBeat.o(188294);
        return false;
      }
      AppMethodBeat.o(188294);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(188282);
      int j = this.base.hashCode();
      int k = this.cot.hashCode();
      if (this.cob == null) {}
      for (int i = 0;; i = this.cob.hashCode())
      {
        int m = this.cou.hashCode();
        AppMethodBeat.o(188282);
        return (i + (j * 31 + k) * 31) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188274);
      String str = "Complex(base=" + this.base + ", transformations=" + this.cot + ", size=" + this.cob + ", parameters=" + this.cou + ')';
      AppMethodBeat.o(188274);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(188313);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.base);
      paramParcel.writeStringList(this.cot);
      paramParcel.writeParcelable((Parcelable)this.cob, paramInt);
      Object localObject1 = this.cou;
      paramParcel.writeInt(((Map)localObject1).size());
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        paramParcel.writeString((String)((Map.Entry)localObject2).getKey());
        paramParcel.writeString((String)((Map.Entry)localObject2).getValue());
      }
      AppMethodBeat.o(188313);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<MemoryCache.Key.Complex>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcoil/memory/MemoryCache$Key$Simple;", "Lcoil/memory/MemoryCache$Key;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Simple
    extends MemoryCache.Key
  {
    public static final Parcelable.Creator<Simple> CREATOR;
    private final String value;
    
    static
    {
      AppMethodBeat.i(188333);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(188333);
    }
    
    public Simple(String paramString)
    {
      super();
      AppMethodBeat.i(188323);
      this.value = paramString;
      AppMethodBeat.o(188323);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(188365);
      if (this == paramObject)
      {
        AppMethodBeat.o(188365);
        return true;
      }
      if (!(paramObject instanceof Simple))
      {
        AppMethodBeat.o(188365);
        return false;
      }
      paramObject = (Simple)paramObject;
      if (!s.p(this.value, paramObject.value))
      {
        AppMethodBeat.o(188365);
        return false;
      }
      AppMethodBeat.o(188365);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(188350);
      int i = this.value.hashCode();
      AppMethodBeat.o(188350);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188342);
      String str = "Simple(value=" + this.value + ')';
      AppMethodBeat.o(188342);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(188383);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.value);
      AppMethodBeat.o(188383);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<MemoryCache.Key.Simple>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcoil/memory/MemoryCache$Key$Companion;", "", "()V", "invoke", "Lcoil/memory/MemoryCache$Key;", "value", "", "create", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.memory.MemoryCache.Key
 * JD-Core Version:    0.7.0.1
 */