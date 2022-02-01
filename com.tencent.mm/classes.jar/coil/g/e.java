package coil.g;

import android.graphics.drawable.Drawable;
import coil.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/fetch/DrawableResult;", "Lcoil/fetch/FetchResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f
{
  public final boolean cmZ;
  public final b cnH;
  public final Drawable drawable;
  
  public e(Drawable paramDrawable, boolean paramBoolean, b paramb)
  {
    super((byte)0);
    AppMethodBeat.i(188359);
    this.drawable = paramDrawable;
    this.cmZ = paramBoolean;
    this.cnH = paramb;
    AppMethodBeat.o(188359);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188393);
    if (this == paramObject)
    {
      AppMethodBeat.o(188393);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(188393);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.drawable, paramObject.drawable))
    {
      AppMethodBeat.o(188393);
      return false;
    }
    if (this.cmZ != paramObject.cmZ)
    {
      AppMethodBeat.o(188393);
      return false;
    }
    if (this.cnH != paramObject.cnH)
    {
      AppMethodBeat.o(188393);
      return false;
    }
    AppMethodBeat.o(188393);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188373);
    String str = "DrawableResult(drawable=" + this.drawable + ", isSampled=" + this.cmZ + ", dataSource=" + this.cnH + ')';
    AppMethodBeat.o(188373);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.g.e
 * JD-Core Version:    0.7.0.1
 */