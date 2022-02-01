package com.tencent.magicbrush;

import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class x
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(140160);
    cyr = new x();
    AppMethodBeat.o(140160);
  }
  
  public final String HC()
  {
    return "getFile_system_()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(140161);
    b localb = z.bp(MBRuntime.MBParams.class);
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