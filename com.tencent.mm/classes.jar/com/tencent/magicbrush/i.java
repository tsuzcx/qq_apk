package com.tencent.magicbrush;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class i
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(140106);
    cyr = new i();
    AppMethodBeat.o(140106);
  }
  
  public final String HC()
  {
    return "getAsset_manager()Landroid/content/res/AssetManager;";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(140107);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140107);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).asset_manager;
  }
  
  public final String getName()
  {
    return "asset_manager";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).asset_manager = ((AssetManager)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.i
 * JD-Core Version:    0.7.0.1
 */