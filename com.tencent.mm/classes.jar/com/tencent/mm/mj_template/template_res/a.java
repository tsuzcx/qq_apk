package com.tencent.mm.mj_template.template_res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/template_res/MaasTemplateResConfig;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "fileVersion", "", "getFileVersion", "()I", "setFileVersion", "(I)V", "subtype", "getSubtype", "setSubtype", "toJson", "Lorg/json/JSONObject;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.sticker.a
{
  public static final int Ue = 8;
  int hCi;
  int subtype;
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(239515);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("st", this.subtype);
    localJSONObject.put("v", this.hCi);
    AppMethodBeat.o(239515);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.template_res.a
 * JD-Core Version:    0.7.0.1
 */