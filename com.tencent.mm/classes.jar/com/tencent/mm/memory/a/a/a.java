package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
  implements c<String>
{
  String itU;
  WeakReference<f.b> itV;
  WeakReference<f.c> itW;
  public int itX;
  long itY;
  String itZ;
  public String key;
  Object object;
  
  public a(String paramString1, String paramString2, Object paramObject, int paramInt, f.b paramb, f.c paramc)
  {
    AppMethodBeat.i(156490);
    this.itX = 0;
    this.itY = 0L;
    this.key = paramString1;
    this.itU = paramString2;
    this.object = paramObject;
    this.itX = paramInt;
    this.itV = new WeakReference(paramb);
    this.itW = new WeakReference(paramc);
    this.itY = System.currentTimeMillis();
    this.itZ = new SimpleDateFormat("HH:mm:ss").format(new Date(this.itY));
    if (com.tencent.mm.memory.a.a.a.a.iuj) {
      Log.i("MicroMsg.BusinessBitmap", "BusinessBitmap build key %s sizes: %s cacheTime %s object %s stack [%s]", new Object[] { paramString1, Util.getSizeKB(paramInt), this.itZ, paramObject, Util.getStack().toString() });
    }
    AppMethodBeat.o(156490);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156492);
    if ((paramObject != null) && ((paramObject instanceof a)) && (((a)paramObject).object != null))
    {
      bool = ((a)paramObject).object.equals(this.object);
      AppMethodBeat.o(156492);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(156492);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(156491);
    if (this.object != null)
    {
      i = this.object.hashCode();
      AppMethodBeat.o(156491);
      return i;
    }
    int i = super.hashCode();
    AppMethodBeat.o(156491);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156493);
    String str = String.format("StructBitmap %s key:%s size %s realObj %s cacheTime %s now %s", new Object[] { Integer.valueOf(hashCode()), this.key, Util.getSizeKB(this.itX), this.object, this.itZ, new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())) });
    AppMethodBeat.o(156493);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a
 * JD-Core Version:    0.7.0.1
 */