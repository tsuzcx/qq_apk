package a.j.b.a.e;

import a.f.b.j;
import a.j.b.a.c.d.a.e.v;
import a.l;
import java.lang.reflect.Type;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "()V", "reflectType", "Ljava/lang/reflect/Type;", "getReflectType", "()Ljava/lang/reflect/Type;", "equals", "", "other", "", "hashCode", "", "toString", "", "Factory", "descriptors.runtime"})
public abstract class w
  implements v
{
  public static final w.a CFZ = new w.a((byte)0);
  
  protected abstract Type epg();
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof w)) && (j.e(epg(), ((w)paramObject).epg()));
  }
  
  public int hashCode()
  {
    return epg().hashCode();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + epg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.e.w
 * JD-Core Version:    0.7.0.1
 */