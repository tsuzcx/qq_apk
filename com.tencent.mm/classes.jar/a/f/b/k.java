package a.f.b;

import a.l;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class k<R>
  implements h<R>, Serializable
{
  private final int BNe;
  
  public k(int paramInt)
  {
    this.BNe = paramInt;
  }
  
  public final int eaY()
  {
    return this.BNe;
  }
  
  public String toString()
  {
    String str = v.a(this);
    j.p(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.k
 * JD-Core Version:    0.7.0.1
 */