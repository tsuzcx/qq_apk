package com.tencent.mm.mj_template.template_res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/template_res/MaasTemplateResConfigList;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "configList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/mj_template/template_res/MaasTemplateResConfig;", "getConfigList", "()Ljava/util/LinkedList;", "toJson", "Lorg/json/JSONObject;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.sticker.a
{
  public static final int Ue = 8;
  final LinkedList<a> obH;
  
  public b()
  {
    AppMethodBeat.i(239508);
    this.obH = new LinkedList();
    AppMethodBeat.o(239508);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(239513);
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((Iterable)this.obH).iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((a)localIterator.next()).toJson());
    }
    localJSONObject.put("list", localJSONArray);
    AppMethodBeat.o(239513);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.template_res.b
 * JD-Core Version:    0.7.0.1
 */