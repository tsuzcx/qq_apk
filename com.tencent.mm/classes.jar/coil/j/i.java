package coil.j;

import android.graphics.drawable.Drawable;
import coil.e.b;
import coil.memory.MemoryCache.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/request/ImageResult;", "", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "getRequest", "()Lcoil/request/ImageRequest;", "Metadata", "Lcoil/request/SuccessResult;", "Lcoil/request/ErrorResult;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
{
  public abstract h MR();
  
  public abstract Drawable getDrawable();
  
  @Metadata(d1={""}, d2={"Lcoil/request/ImageResult$Metadata;", "", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "isPlaceholderMemoryCacheKeyPresent", "(Lcoil/memory/MemoryCache$Key;ZLcoil/decode/DataSource;Z)V", "getDataSource", "()Lcoil/decode/DataSource;", "()Z", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final boolean cmZ;
    public final b cnH;
    public final boolean cpM;
    private final MemoryCache.Key cpv;
    
    public a(MemoryCache.Key paramKey, boolean paramBoolean1, b paramb, boolean paramBoolean2)
    {
      AppMethodBeat.i(187874);
      this.cpv = paramKey;
      this.cmZ = paramBoolean1;
      this.cnH = paramb;
      this.cpM = paramBoolean2;
      AppMethodBeat.o(187874);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(187897);
      if (this == paramObject)
      {
        AppMethodBeat.o(187897);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(187897);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.cpv, paramObject.cpv))
      {
        AppMethodBeat.o(187897);
        return false;
      }
      if (this.cmZ != paramObject.cmZ)
      {
        AppMethodBeat.o(187897);
        return false;
      }
      if (this.cnH != paramObject.cnH)
      {
        AppMethodBeat.o(187897);
        return false;
      }
      if (this.cpM != paramObject.cpM)
      {
        AppMethodBeat.o(187897);
        return false;
      }
      AppMethodBeat.o(187897);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(187884);
      String str = "Metadata(memoryCacheKey=" + this.cpv + ", isSampled=" + this.cmZ + ", dataSource=" + this.cnH + ", isPlaceholderMemoryCacheKeyPresent=" + this.cpM + ')';
      AppMethodBeat.o(187884);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.j.i
 * JD-Core Version:    0.7.0.1
 */