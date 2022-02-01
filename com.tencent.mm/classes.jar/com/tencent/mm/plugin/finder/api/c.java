package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class c
  extends f
{
  public String dbt;
  public String desc;
  public String qoa;
  public int scene;
  public String title;
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168707);
    this.title = ((String)paramMap.get(".msg.appmsg.finderEndorsement.username"));
    this.desc = ((String)paramMap.get(".msg.appmsg.finderEndorsement.nickname"));
    this.qoa = ((String)paramMap.get(".msg.appmsg.finderEndorsement.relativePath"));
    this.dbt = ((String)paramMap.get(".msg.appmsg.finderEndorsement.sceneNote"));
    this.scene = bt.getInt((String)paramMap.get(".msg.appmsg.finderEndorsement.scene"), 0);
    AppMethodBeat.o(168707);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(168705);
    c localc = new c();
    localc.title = this.title;
    localc.desc = this.desc;
    localc.qoa = this.qoa;
    localc.dbt = this.dbt;
    localc.scene = this.scene;
    AppMethodBeat.o(168705);
    return localc;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168706);
    paramStringBuilder.append("<finderEndorsement>");
    if (!bt.isNullOrNil(this.title))
    {
      paramStringBuilder.append("<username>");
      paramStringBuilder.append(k.b.ry(this.title));
      paramStringBuilder.append("</username>");
    }
    if (!bt.isNullOrNil(this.desc))
    {
      paramStringBuilder.append("<nickname>");
      paramStringBuilder.append(k.b.ry(this.desc));
      paramStringBuilder.append("</nickname>");
    }
    if (!bt.isNullOrNil(this.qoa))
    {
      paramStringBuilder.append("<relativePath>");
      paramStringBuilder.append(k.b.ry(this.qoa));
      paramStringBuilder.append("</relativePath>");
    }
    if (!bt.isNullOrNil(this.dbt))
    {
      paramStringBuilder.append("<sceneNote>");
      paramStringBuilder.append(k.b.ry(this.dbt));
      paramStringBuilder.append("</sceneNote>");
    }
    paramStringBuilder.append("<scene>");
    paramStringBuilder.append(k.b.ry(String.valueOf(this.scene)));
    paramStringBuilder.append("</scene>");
    paramStringBuilder.append("</finderEndorsement>");
    AppMethodBeat.o(168706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */