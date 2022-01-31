package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.memory.a.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
  implements c<String>
{
  String fef;
  WeakReference<f.b> feg;
  WeakReference<f.c> feh;
  public int fei;
  long fej;
  String fek;
  public String key;
  Object object;
  
  public a(String paramString1, String paramString2, Object paramObject, int paramInt, f.b paramb, f.c paramc)
  {
    AppMethodBeat.i(115444);
    this.fei = 0;
    this.fej = 0L;
    this.key = paramString1;
    this.fef = paramString2;
    this.object = paramObject;
    this.fei = paramInt;
    this.feg = new WeakReference(paramb);
    this.feh = new WeakReference(paramc);
    this.fej = System.currentTimeMillis();
    this.fek = new SimpleDateFormat("HH:mm:ss").format(new Date(this.fej));
    if (com.tencent.mm.memory.a.a.a.a.feu) {
      ab.i("MicroMsg.BusinessBitmap", "BusinessBitmap build key %s sizes: %s cacheTime %s object %s stack [%s]", new Object[] { paramString1, bo.hk(paramInt), this.fek, paramObject, bo.dtY().toString() });
    }
    AppMethodBeat.o(115444);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(115446);
    if ((paramObject != null) && ((paramObject instanceof a)) && (((a)paramObject).object != null))
    {
      bool = ((a)paramObject).object.equals(this.object);
      AppMethodBeat.o(115446);
      return bool;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(115446);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(115445);
    if (this.object != null)
    {
      i = this.object.hashCode();
      AppMethodBeat.o(115445);
      return i;
    }
    int i = super.hashCode();
    AppMethodBeat.o(115445);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115447);
    String str = String.format("StructBitmap %s key:%s size %s realObj %s cacheTime %s now %s", new Object[] { Integer.valueOf(hashCode()), this.key, bo.hk(this.fei), this.object, this.fek, new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())) });
    AppMethodBeat.o(115447);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.memory.a.a.a
 * JD-Core Version:    0.7.0.1
 */