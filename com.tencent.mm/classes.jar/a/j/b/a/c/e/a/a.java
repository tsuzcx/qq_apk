package a.j.b.a.c.e.a;

import a.a.e;
import a.a.v;
import java.util.ArrayList;
import java.util.List;

public abstract class a
{
  public static final a.a Cog = new a.a((byte)0);
  public final int Cod;
  private final List<Integer> Coe;
  private final int[] Cof;
  public final int major;
  public final int minor;
  
  public a(int... paramVarArgs)
  {
    this.Cof = paramVarArgs;
    paramVarArgs = e.j(this.Cof, 0);
    int i;
    if (paramVarArgs != null)
    {
      i = paramVarArgs.intValue();
      this.major = i;
      paramVarArgs = e.j(this.Cof, 1);
      if (paramVarArgs == null) {
        break label133;
      }
      i = paramVarArgs.intValue();
      label58:
      this.minor = i;
      paramVarArgs = e.j(this.Cof, 2);
      i = j;
      if (paramVarArgs != null) {
        i = paramVarArgs.intValue();
      }
      this.Cod = i;
      if (this.Cof.length <= 3) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramVarArgs = a.a.j.m((Iterable)e.L(this.Cof).subList(3, this.Cof.length));; paramVarArgs = (List)v.BMx)
    {
      this.Coe = paramVarArgs;
      return;
      i = -1;
      break;
      i = -1;
      break label58;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && (a.f.b.j.e(getClass(), paramObject.getClass())) && (this.major == ((a)paramObject).major) && (this.minor == ((a)paramObject).minor) && (this.Cod == ((a)paramObject).Cod) && (a.f.b.j.e(this.Coe, ((a)paramObject).Coe));
  }
  
  public int hashCode()
  {
    int i = this.major;
    i += i * 31 + this.minor;
    i += i * 31 + this.Cod;
    return i + (i * 31 + this.Coe.hashCode());
  }
  
  public String toString()
  {
    Object localObject = this.Cof;
    ArrayList localArrayList = new ArrayList();
    int k = localObject.length;
    int i = 0;
    if (i < k)
    {
      int m = localObject[i];
      if (m != -1) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label67;
        }
        localArrayList.add(Integer.valueOf(m));
        i += 1;
        break;
      }
    }
    label67:
    localObject = (List)localArrayList;
    if (((List)localObject).isEmpty()) {
      return "unknown";
    }
    return a.a.j.a((Iterable)localObject, (CharSequence)".", null, null, 0, null, null, 62);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.e.a.a
 * JD-Core Version:    0.7.0.1
 */