package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class e
  extends f
{
  public String Axg;
  public String appid;
  public String desc;
  public int scene;
  public String title;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168706);
    paramStringBuilder.append("<finderGuarantee>");
    if (!Util.isNullOrNil(this.title))
    {
      paramStringBuilder.append("<title>");
      paramStringBuilder.append(k.b.Hg(this.title));
      paramStringBuilder.append("</title>");
    }
    if (!Util.isNullOrNil(this.desc))
    {
      paramStringBuilder.append("<desc>");
      paramStringBuilder.append(k.b.Hg(this.desc));
      paramStringBuilder.append("</desc>");
    }
    if (!Util.isNullOrNil(this.Axg))
    {
      paramStringBuilder.append("<relativePath>");
      paramStringBuilder.append(k.b.Hg(this.Axg));
      paramStringBuilder.append("</relativePath>");
    }
    if (!Util.isNullOrNil(this.appid))
    {
      paramStringBuilder.append("<appid>");
      paramStringBuilder.append(k.b.Hg(this.appid));
      paramStringBuilder.append("</appid>");
    }
    paramStringBuilder.append("<scene>");
    paramStringBuilder.append(k.b.Hg(String.valueOf(this.scene)));
    paramStringBuilder.append("</scene>");
    paramStringBuilder.append("</finderGuarantee>");
    AppMethodBeat.o(168706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168707);
    this.title = ((String)paramMap.get(".msg.appmsg.finderGuarantee.title"));
    this.desc = ((String)paramMap.get(".msg.appmsg.finderGuarantee.desc"));
    this.Axg = ((String)paramMap.get(".msg.appmsg.finderGuarantee.relativePath"));
    this.appid = ((String)paramMap.get(".msg.appmsg.finderGuarantee.appid"));
    this.scene = Util.getInt((String)paramMap.get(".msg.appmsg.finderGuarantee.scene"), 0);
    AppMethodBeat.o(168707);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(168705);
    e locale = new e();
    locale.title = this.title;
    locale.desc = this.desc;
    locale.Axg = this.Axg;
    locale.scene = this.scene;
    locale.appid = this.appid;
    AppMethodBeat.o(168705);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.e
 * JD-Core Version:    0.7.0.1
 */