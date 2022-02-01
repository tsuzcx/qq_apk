package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class d
  extends f
{
  public String dCw;
  public String desc;
  public int scene;
  public String title;
  public String tsr;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168706);
    paramStringBuilder.append("<finderEndorsement>");
    if (!Util.isNullOrNil(this.title))
    {
      paramStringBuilder.append("<username>");
      paramStringBuilder.append(k.b.HE(this.title));
      paramStringBuilder.append("</username>");
    }
    if (!Util.isNullOrNil(this.desc))
    {
      paramStringBuilder.append("<nickname>");
      paramStringBuilder.append(k.b.HE(this.desc));
      paramStringBuilder.append("</nickname>");
    }
    if (!Util.isNullOrNil(this.tsr))
    {
      paramStringBuilder.append("<relativePath>");
      paramStringBuilder.append(k.b.HE(this.tsr));
      paramStringBuilder.append("</relativePath>");
    }
    if (!Util.isNullOrNil(this.dCw))
    {
      paramStringBuilder.append("<sceneNote>");
      paramStringBuilder.append(k.b.HE(this.dCw));
      paramStringBuilder.append("</sceneNote>");
    }
    paramStringBuilder.append("<scene>");
    paramStringBuilder.append(k.b.HE(String.valueOf(this.scene)));
    paramStringBuilder.append("</scene>");
    paramStringBuilder.append("</finderEndorsement>");
    AppMethodBeat.o(168706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168707);
    this.title = ((String)paramMap.get(".msg.appmsg.finderEndorsement.username"));
    this.desc = ((String)paramMap.get(".msg.appmsg.finderEndorsement.nickname"));
    this.tsr = ((String)paramMap.get(".msg.appmsg.finderEndorsement.relativePath"));
    this.dCw = ((String)paramMap.get(".msg.appmsg.finderEndorsement.sceneNote"));
    this.scene = Util.getInt((String)paramMap.get(".msg.appmsg.finderEndorsement.scene"), 0);
    AppMethodBeat.o(168707);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(168705);
    d locald = new d();
    locald.title = this.title;
    locald.desc = this.desc;
    locald.tsr = this.tsr;
    locald.dCw = this.dCw;
    locald.scene = this.scene;
    AppMethodBeat.o(168705);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d
 * JD-Core Version:    0.7.0.1
 */