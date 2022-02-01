package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fc;
import com.tencent.mm.protocal.protobuf.fim;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends fc
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(163696);
    info = fc.aJm();
    AppMethodBeat.o(163696);
  }
  
  public static c a(fim paramfim, String paramString)
  {
    AppMethodBeat.i(163694);
    c localc = new c();
    if (paramfim != null)
    {
      localc.field_packet_id = paramString;
      localc.field_height = paramfim.height;
      localc.field_width = paramfim.width;
      localc.field_media_type = paramfim.abJk;
      localc.field_media_md5 = paramfim.abJm;
      localc.field_media_url = paramfim.abJl;
      localc.field_media_fuzzy_thumbnail_url = paramfim.abJn;
      localc.field_media_fuzzy_thumbnail_md5 = paramfim.abJo;
    }
    AppMethodBeat.o(163694);
    return localc;
  }
  
  public static fim a(c paramc)
  {
    AppMethodBeat.i(163695);
    fim localfim = new fim();
    localfim.height = paramc.field_height;
    localfim.width = paramc.field_width;
    localfim.abJk = paramc.field_media_type;
    localfim.abJl = paramc.field_media_url;
    localfim.abJm = paramc.field_media_md5;
    localfim.abJn = paramc.field_media_fuzzy_thumbnail_url;
    localfim.abJo = paramc.field_media_fuzzy_thumbnail_md5;
    AppMethodBeat.o(163695);
    return localfim;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.c
 * JD-Core Version:    0.7.0.1
 */