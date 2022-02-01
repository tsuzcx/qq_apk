package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kt/IAssert;", "", "assertEquals", "", "key", "", "expected", "actual", "level", "Lcom/tencent/mm/kt/IAssert$LEVEL;", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "LEVEL", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void a(String paramString, Object paramObject, b paramb, boolean paramBoolean1, boolean paramBoolean2, a<String> parama);
  
  public abstract void a(String paramString, boolean paramBoolean1, b paramb, boolean paramBoolean2, boolean paramBoolean3, a<String> parama);
  
  public abstract void b(String paramString, boolean paramBoolean1, b paramb, boolean paramBoolean2, boolean paramBoolean3, a<String> parama);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<String>
    {
      public static final a mHP;
      
      static
      {
        AppMethodBeat.i(233449);
        mHP = new a();
        AppMethodBeat.o(233449);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/kt/IAssert$LEVEL;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TRICK", "WARNING", "ERROR", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(233462);
      mHL = new b("TRICK", 0, 0);
      mHM = new b("WARNING", 1, 1);
      mHN = new b("ERROR", 2, 110);
      mHO = new b[] { mHL, mHM, mHN };
      AppMethodBeat.o(233462);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.e
 * JD-Core Version:    0.7.0.1
 */