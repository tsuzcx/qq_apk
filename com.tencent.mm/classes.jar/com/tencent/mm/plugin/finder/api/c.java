package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class c
  extends f
{
  public String cYP;
  public String desc;
  public String qWv;
  public int scene;
  public String title;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168706);
    paramStringBuilder.append("<finderEndorsement>");
    if (!bs.isNullOrNil(this.title))
    {
      paramStringBuilder.append("<username>");
      paramStringBuilder.append(k.b.vB(this.title));
      paramStringBuilder.append("</username>");
    }
    if (!bs.isNullOrNil(this.desc))
    {
      paramStringBuilder.append("<nickname>");
      paramStringBuilder.append(k.b.vB(this.desc));
      paramStringBuilder.append("</nickname>");
    }
    if (!bs.isNullOrNil(this.qWv))
    {
      paramStringBuilder.append("<relativePath>");
      paramStringBuilder.append(k.b.vB(this.qWv));
      paramStringBuilder.append("</relativePath>");
    }
    if (!bs.isNullOrNil(this.cYP))
    {
      paramStringBuilder.append("<sceneNote>");
      paramStringBuilder.append(k.b.vB(this.cYP));
      paramStringBuilder.append("</sceneNote>");
    }
    paramStringBuilder.append("<scene>");
    paramStringBuilder.append(k.b.vB(String.valueOf(this.scene)));
    paramStringBuilder.append("</scene>");
    paramStringBuilder.append("</finderEndorsement>");
    AppMethodBeat.o(168706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168707);
    this.title = ((String)paramMap.get(".msg.appmsg.finderEndorsement.username"));
    this.desc = ((String)paramMap.get(".msg.appmsg.finderEndorsement.nickname"));
    this.qWv = ((String)paramMap.get(".msg.appmsg.finderEndorsement.relativePath"));
    this.cYP = ((String)paramMap.get(".msg.appmsg.finderEndorsement.sceneNote"));
    this.scene = bs.getInt((String)paramMap.get(".msg.appmsg.finderEndorsement.scene"), 0);
    AppMethodBeat.o(168707);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(168705);
    c localc = new c();
    localc.title = this.title;
    localc.desc = this.desc;
    localc.qWv = this.qWv;
    localc.cYP = this.cYP;
    localc.scene = this.scene;
    AppMethodBeat.o(168705);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */