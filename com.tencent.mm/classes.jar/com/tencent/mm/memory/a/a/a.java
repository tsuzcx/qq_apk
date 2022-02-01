package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
  implements c<String>
{
  String hzN;
  WeakReference<f.b> hzO;
  WeakReference<f.c> hzP;
  public int hzQ;
  long hzR;
  String hzS;
  public String key;
  Object object;
  
  public a(String paramString1, String paramString2, Object paramObject, int paramInt, f.b paramb, f.c paramc)
  {
    AppMethodBeat.i(156490);
    this.hzQ = 0;
    this.hzR = 0L;
    this.key = paramString1;
    this.hzN = paramString2;
    this.object = paramObject;
    this.hzQ = paramInt;
    this.hzO = new WeakReference(paramb);
    this.hzP = new WeakReference(paramc);
    this.hzR = System.currentTimeMillis();
    this.hzS = new SimpleDateFormat("HH:mm:ss").format(new Date(this.hzR));
    if (com.tencent.mm.memory.a.a.a.a.hAc) {
      ae.i("MicroMsg.BusinessBitmap", "BusinessBitmap build key %s sizes: %s cacheTime %s object %s stack [%s]", new Object[] { paramString1, bu.sL(paramInt), this.hzS, paramObject, bu.fpN().toString() });
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
    String str = String.format("StructBitmap %s key:%s size %s realObj %s cacheTime %s now %s", new Object[] { Integer.valueOf(hashCode()), this.key, bu.sL(this.hzQ), this.object, this.hzS, new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())) });
    AppMethodBeat.o(156493);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a
 * JD-Core Version:    0.7.0.1
 */