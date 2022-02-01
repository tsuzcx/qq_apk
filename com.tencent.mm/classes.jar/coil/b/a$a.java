package coil.b;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/bitmap/AttributeStrategy$Key;", "", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "(IILandroid/graphics/Bitmap$Config;)V", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getHeight", "()I", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a$a
{
  private final Bitmap.Config clE;
  private final int height;
  private final int width;
  
  public a$a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188163);
    this.width = paramInt1;
    this.height = paramInt2;
    this.clE = paramConfig;
    AppMethodBeat.o(188163);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
      if (this.height != paramObject.height) {
        return false;
      }
    } while (this.clE == paramObject.clE);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188188);
    int i = this.width;
    int j = this.height;
    int k = this.clE.hashCode();
    AppMethodBeat.o(188188);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188176);
    String str = "Key(width=" + this.width + ", height=" + this.height + ", config=" + this.clE + ')';
    AppMethodBeat.o(188176);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.b.a.a
 * JD-Core Version:    0.7.0.1
 */