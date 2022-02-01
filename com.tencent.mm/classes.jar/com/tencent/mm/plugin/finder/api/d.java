package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class d
  extends f
{
  public String desc;
  public String dkh;
  public String rHp;
  public int scene;
  public String title;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168706);
    paramStringBuilder.append("<finderEndorsement>");
    if (!bt.isNullOrNil(this.title))
    {
      paramStringBuilder.append("<username>");
      paramStringBuilder.append(k.b.ys(this.title));
      paramStringBuilder.append("</username>");
    }
    if (!bt.isNullOrNil(this.desc))
    {
      paramStringBuilder.append("<nickname>");
      paramStringBuilder.append(k.b.ys(this.desc));
      paramStringBuilder.append("</nickname>");
    }
    if (!bt.isNullOrNil(this.rHp))
    {
      paramStringBuilder.append("<relativePath>");
      paramStringBuilder.append(k.b.ys(this.rHp));
      paramStringBuilder.append("</relativePath>");
    }
    if (!bt.isNullOrNil(this.dkh))
    {
      paramStringBuilder.append("<sceneNote>");
      paramStringBuilder.append(k.b.ys(this.dkh));
      paramStringBuilder.append("</sceneNote>");
    }
    paramStringBuilder.append("<scene>");
    paramStringBuilder.append(k.b.ys(String.valueOf(this.scene)));
    paramStringBuilder.append("</scene>");
    paramStringBuilder.append("</finderEndorsement>");
    AppMethodBeat.o(168706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168707);
    this.title = ((String)paramMap.get(".msg.appmsg.finderEndorsement.username"));
    this.desc = ((String)paramMap.get(".msg.appmsg.finderEndorsement.nickname"));
    this.rHp = ((String)paramMap.get(".msg.appmsg.finderEndorsement.relativePath"));
    this.dkh = ((String)paramMap.get(".msg.appmsg.finderEndorsement.sceneNote"));
    this.scene = bt.getInt((String)paramMap.get(".msg.appmsg.finderEndorsement.scene"), 0);
    AppMethodBeat.o(168707);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(168705);
    d locald = new d();
    locald.title = this.title;
    locald.desc = this.desc;
    locald.rHp = this.rHp;
    locald.dkh = this.dkh;
    locald.scene = this.scene;
    AppMethodBeat.o(168705);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d
 * JD-Core Version:    0.7.0.1
 */