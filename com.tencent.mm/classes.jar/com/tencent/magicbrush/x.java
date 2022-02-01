package com.tencent.magicbrush;

import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class x
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140160);
    cnf = new x();
    AppMethodBeat.o(140160);
  }
  
  public final String FZ()
  {
    return "getFile_system_()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140161);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140161);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).file_system_;
  }
  
  public final String getName()
  {
    return "file_system_";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).file_system_ = ((IMBFileSystem)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.x
 * JD-Core Version:    0.7.0.1
 */