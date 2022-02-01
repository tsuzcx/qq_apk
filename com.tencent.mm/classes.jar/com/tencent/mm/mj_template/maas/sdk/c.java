package com.tencent.mm.mj_template.maas.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResConfig;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "baseVersion", "", "getBaseVersion", "()I", "setBaseVersion", "(I)V", "compatVersion", "getCompatVersion", "setCompatVersion", "fullSha1", "", "getFullSha1", "()Ljava/lang/String;", "setFullSha1", "(Ljava/lang/String;)V", "isCompatible", "", "()Z", "isPatch", "isValid", "resVersion", "getResVersion", "setResVersion", "sha1", "getSha1", "setSha1", "subtype", "getSubtype", "setSubtype", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toString", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final int Ue = 8;
  int obC;
  int obD;
  int obE;
  String obF = "";
  String obG = "";
  int subtype;
  
  public final a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(240096);
    s.u(paramJSONObject, "jsonObj");
    this.obC = paramJSONObject.optInt("compatVersion");
    this.obD = paramJSONObject.optInt("resVersion");
    this.obE = paramJSONObject.optInt("baseVersion");
    String str = paramJSONObject.optString("sha1");
    s.s(str, "jsonObj.optString(\"sha1\")");
    this.obF = str;
    str = paramJSONObject.optString("fullSha1");
    s.s(str, "jsonObj.optString(\"fullSha1\")");
    this.obG = str;
    paramJSONObject = super.G(paramJSONObject);
    AppMethodBeat.o(240096);
    return paramJSONObject;
  }
  
  public final boolean axM()
  {
    return this.obC == 10100003;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(240081);
    if ((this.obD > 0) && (this.obE > 0))
    {
      if (((CharSequence)this.obF).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label78;
        }
        if (((CharSequence)this.obG).length() <= 0) {
          break label73;
        }
      }
      label73:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label78;
        }
        AppMethodBeat.o(240081);
        return true;
        i = 0;
        break;
      }
    }
    label78:
    AppMethodBeat.o(240081);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240103);
    String str = "MaasSdkResConfig(compatVersion=" + this.obC + ", resVersion=" + this.obD + ", baseVersion=" + this.obE + ", sha1='" + this.obF + "', fullSha1='" + this.obG + "')";
    AppMethodBeat.o(240103);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.c
 * JD-Core Version:    0.7.0.1
 */