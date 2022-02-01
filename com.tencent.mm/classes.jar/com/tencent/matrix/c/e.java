package com.tencent.matrix.c;

import android.os.Bundle;
import com.tencent.matrix.a.a.a.b;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.f;
import com.tencent.matrix.a.a.a.m.a;
import com.tencent.matrix.a.a.a.m.a.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
  extends f
{
  Map<Class<? extends b>, List<m.a.a<b.a>>> eWr = new HashMap();
  final Bundle mExtras = new Bundle();
  
  public e(com.tencent.matrix.a.a.d paramd)
  {
    super(paramd);
  }
  
  public final void a(Class<? extends b> paramClass, List<m.a.a<b.a>> paramList)
  {
    this.eWr.put(paramClass, paramList);
  }
  
  public final m.a<?> aq(Class<? extends m.a<?>> paramClass)
  {
    if (paramClass == a.a.class)
    {
      a.a locala = a.a.ayw();
      this.eQY.put(paramClass, locala);
      return locala;
    }
    return super.aq(paramClass);
  }
  
  public final void ar(Class<? extends b> paramClass)
  {
    a(paramClass, new e..ExternalSyntheticLambda0(this, paramClass));
  }
  
  public final List<m.a.a<b.a>> as(Class<? extends b> paramClass)
  {
    List localList = (List)this.eWr.get(paramClass);
    paramClass = localList;
    if (localList == null) {
      paramClass = Collections.emptyList();
    }
    return paramClass;
  }
  
  public final void clear()
  {
    super.clear();
    this.eWr.clear();
  }
  
  public final void e(Class<? extends b> paramClass, com.tencent.matrix.a.b.d<List<m.a.a<b.a>>> paramd)
  {
    paramClass = (List)this.eWr.get(paramClass);
    if (paramClass != null) {
      paramd.accept(paramClass);
    }
  }
  
  public final String getModuleName()
  {
    return this.mExtras.getString("extra_module_name", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.e
 * JD-Core Version:    0.7.0.1
 */