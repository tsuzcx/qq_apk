package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;

public final class a$a
{
  Class btN;
  Object mEG;
  Set mEK;
  
  a$a(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(158352);
    this.mEK = new HashSet();
    this.mEG = paramObject;
    if (paramClass != null) {
      this.btN = paramClass;
    }
    da(this.mEG);
    AppMethodBeat.o(158352);
  }
  
  private void da(Object paramObject)
  {
    AppMethodBeat.i(158353);
    Assert.assertNotNull(paramObject);
    Assert.assertNotNull(this.btN);
    if (!this.btN.isInstance(paramObject))
    {
      paramObject = new IllegalArgumentException("Your depend object " + paramObject + " must implement your type " + this.btN);
      AppMethodBeat.o(158353);
      throw paramObject;
    }
    AppMethodBeat.o(158353);
  }
  
  public final a db(Object paramObject)
  {
    AppMethodBeat.i(158354);
    this.mEK.add(paramObject);
    da(paramObject);
    AppMethodBeat.o(158354);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */