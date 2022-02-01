package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class by
  extends JsonComposer
{
  @Json(ignore=true)
  public String a;
  @Json(name="md5")
  public String b;
  @Json(name="pinyin")
  public String c;
  @Json(name="size")
  public int d;
  @Json(name="ver")
  public int e;
  
  private boolean a(OfflineItem paramOfflineItem)
  {
    AppMethodBeat.i(222352);
    boolean bool = paramOfflineItem.getPinyin().equals(this.c);
    AppMethodBeat.o(222352);
    return bool;
  }
  
  private boolean a(mb parammb)
  {
    AppMethodBeat.i(222381);
    if (parammb != null)
    {
      String str = parammb.a(this.c + "-md5");
      int i = parammb.b(this.c + "-version", -1);
      if ((this.e != i) || ((str != null) && (!str.equals(this.b))))
      {
        AppMethodBeat.o(222381);
        return true;
      }
      AppMethodBeat.o(222381);
      return false;
    }
    AppMethodBeat.o(222381);
    return false;
  }
  
  private String b()
  {
    AppMethodBeat.i(222361);
    String str = this.c + ".zip";
    AppMethodBeat.o(222361);
    return str;
  }
  
  private void b(mb parammb)
  {
    AppMethodBeat.i(222389);
    if (parammb != null)
    {
      parammb.a(this.c + "-md5", this.b);
      parammb.a(this.c + "-version", this.e);
    }
    AppMethodBeat.o(222389);
  }
  
  private String c()
  {
    AppMethodBeat.i(222369);
    String str = this.a + File.separator + this.c + this.e + ".zip";
    AppMethodBeat.o(222369);
    return str;
  }
  
  public final String a()
  {
    AppMethodBeat.i(222399);
    String str = this.c + ".dat";
    AppMethodBeat.o(222399);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(222409);
    Object localObject = new StringBuffer("OfflineMapConfigCity{");
    ((StringBuffer)localObject).append("url='").append(this.a).append('\'');
    ((StringBuffer)localObject).append(", md5='").append(this.b).append('\'');
    ((StringBuffer)localObject).append(", pinyin='").append(this.c).append('\'');
    ((StringBuffer)localObject).append(", size=").append(this.d);
    ((StringBuffer)localObject).append(", version=").append(this.e);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222409);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.by
 * JD-Core Version:    0.7.0.1
 */