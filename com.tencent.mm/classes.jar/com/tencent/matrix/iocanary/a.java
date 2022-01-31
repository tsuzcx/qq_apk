package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.b.c;
import com.tencent.matrix.iocanary.core.IOCanaryJniBridge;

public final class a
  extends com.tencent.matrix.b.b
{
  public final com.tencent.matrix.iocanary.a.a bog = com.tencent.matrix.iocanary.a.a.boi;
  private com.tencent.matrix.iocanary.core.a boh;
  
  public final void a(Application paramApplication, c paramc)
  {
    super.a(paramApplication, paramc);
    com.tencent.matrix.iocanary.c.a.ag(paramApplication);
    this.boh = new com.tencent.matrix.iocanary.core.a(this);
  }
  
  public final String getTag()
  {
    return "io";
  }
  
  public final void start()
  {
    super.start();
    com.tencent.matrix.iocanary.core.a locala = this.boh;
    Object localObject1 = locala.bog;
    if ((!com.tencent.matrix.iocanary.core.a.$assertionsDisabled) && (localObject1 == null)) {
      throw new AssertionError();
    }
    if ((((com.tencent.matrix.iocanary.a.a)localObject1).ed(1)) || (((com.tencent.matrix.iocanary.a.a)localObject1).ed(4)) || (((com.tencent.matrix.iocanary.a.a)localObject1).ed(2))) {
      IOCanaryJniBridge.a((com.tencent.matrix.iocanary.a.a)localObject1, locala);
    }
    if (((com.tencent.matrix.iocanary.a.a)localObject1).ed(8))
    {
      locala.bos = new com.tencent.matrix.iocanary.b.a(locala);
      localObject1 = locala.bos;
      com.tencent.matrix.d.b.i("Matrix.CloseGuardHooker", "hook sIsTryHook=%b", new Object[] { Boolean.valueOf(((com.tencent.matrix.iocanary.b.a)localObject1).bow) });
      if (!((com.tencent.matrix.iocanary.b.a)localObject1).bow)
      {
        com.tencent.matrix.d.b.i("Matrix.CloseGuardHooker", "hook hookRet=%b", new Object[] { Boolean.valueOf(((com.tencent.matrix.iocanary.b.a)localObject1).rc()) });
        ((com.tencent.matrix.iocanary.b.a)localObject1).bow = true;
      }
    }
    try
    {
      locala.bnh = true;
      return;
    }
    finally {}
  }
  
  public final void stop()
  {
    super.stop();
    synchronized (this.boh)
    {
      ((com.tencent.matrix.iocanary.core.a)???).bnh = false;
      if (((com.tencent.matrix.iocanary.core.a)???).bos != null)
      {
        ??? = ((com.tencent.matrix.iocanary.core.a)???).bos;
        com.tencent.matrix.d.b.i("Matrix.CloseGuardHooker", "unHook unHookRet=%b", new Object[] { Boolean.valueOf(com.tencent.matrix.iocanary.b.a.rd()) });
        ((com.tencent.matrix.iocanary.b.a)???).bow = false;
      }
      IOCanaryJniBridge.ra();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a
 * JD-Core Version:    0.7.0.1
 */