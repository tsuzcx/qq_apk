package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.res.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTransitionFetcher;", "", "()V", "TAG", "", "TransEffectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTransitionFetcher$TransEffectInfo;", "getTransEffectList", "()Ljava/util/LinkedList;", "transitionResMap", "", "", "convertSVGResourceToByte", "", "svgResource", "getDataToFlutter", "", "initTransEffect", "Companion", "TransEffectInfo", "plugin-flutter_release"})
public final class m
{
  private static m wKA;
  public static final m.a wKB;
  private final String TAG;
  public final LinkedList<b> wKy;
  private final Map<String, Integer> wKz;
  
  static
  {
    AppMethodBeat.i(241108);
    wKB = new m.a((byte)0);
    AppMethodBeat.o(241108);
  }
  
  private m()
  {
    AppMethodBeat.i(241107);
    this.TAG = "MMVideoEditorTransitionFetcher";
    this.wKy = new LinkedList();
    this.wKz = ae.e(new o[] { s.U("diehua.svg", Integer.valueOf(2131690086)), s.U("shanhei.svg", Integer.valueOf(2131691476)), s.U("shanbai.svg", Integer.valueOf(2131691474)), s.U("zuoyi.svg", Integer.valueOf(2131691819)), s.U("youyi.svg", Integer.valueOf(2131691817)), s.U("shangyi.svg", Integer.valueOf(2131691475)), s.U("xiayi.svg", Integer.valueOf(2131691816)), s.U("fangda.svg", Integer.valueOf(2131690165)), s.U("suoxiao.svg", Integer.valueOf(2131691597)), s.U("youzhuan.svg", Integer.valueOf(2131691818)), s.U("zuozhuan.svg", Integer.valueOf(2131691820)) });
    dMd();
    AppMethodBeat.o(241107);
  }
  
  private final void dMd()
  {
    AppMethodBeat.i(241106);
    String str1 = f.BYo.eLk();
    try
    {
      JSONArray localJSONArray = f.BYo.eLn();
      if (localJSONArray == null) {
        p.hyc();
      }
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        localObject1 = localJSONArray.optJSONObject(i);
        String str2 = ((JSONObject)localObject1).optString("name");
        String str3 = ((JSONObject)localObject1).getString("pag");
        Object localObject2 = ((JSONObject)localObject1).getString("svg");
        int k = ((JSONObject)localObject1).getInt("order");
        str3 = str1 + str3;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = this.wKy;
        p.g(str2, "transEffectName");
        ((LinkedList)localObject2).add(new b(str2, k, str3, (String)localObject1, -1L));
        i += 1;
      }
      Object localObject1 = (List)this.wKy;
      if (((List)localObject1).size() > 1) {
        j.a((List)localObject1, (Comparator)new c());
      }
      AppMethodBeat.o(241106);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localJSONException, "Cannot load transEffect config", new Object[0]);
      AppMethodBeat.o(241106);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTransitionFetcher$TransEffectInfo;", "", "name", "", "order", "", "assetPath", "svgPath", "duration", "", "effectId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)V", "getAssetPath", "()Ljava/lang/String;", "setAssetPath", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "setEffectId", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getSvgPath", "setSvgPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-flutter_release"})
  public static final class b
  {
    public String assetPath;
    private long duration;
    public String name;
    int order;
    public String wKC;
    private long wKD;
    
    public b(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
    {
      AppMethodBeat.i(241100);
      this.name = paramString1;
      this.order = paramInt;
      this.assetPath = paramString2;
      this.wKC = paramString3;
      this.duration = 500L;
      this.wKD = paramLong;
      AppMethodBeat.o(241100);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(241104);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.name, paramObject.name)) || (this.order != paramObject.order) || (!p.j(this.assetPath, paramObject.assetPath)) || (!p.j(this.wKC, paramObject.wKC)) || (this.duration != paramObject.duration) || (this.wKD != paramObject.wKD)) {}
        }
      }
      else
      {
        AppMethodBeat.o(241104);
        return true;
      }
      AppMethodBeat.o(241104);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(241103);
      String str = this.name;
      int i;
      int m;
      if (str != null)
      {
        i = str.hashCode();
        m = this.order;
        str = this.assetPath;
        if (str == null) {
          break label138;
        }
      }
      label138:
      for (int j = str.hashCode();; j = 0)
      {
        str = this.wKC;
        if (str != null) {
          k = str.hashCode();
        }
        long l = this.duration;
        int n = (int)(l ^ l >>> 32);
        l = this.wKD;
        int i1 = (int)(l ^ l >>> 32);
        AppMethodBeat.o(241103);
        return (((j + (i * 31 + m) * 31) * 31 + k) * 31 + n) * 31 + i1;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(241102);
      String str = "TransEffectInfo(name=" + this.name + ", order=" + this.order + ", assetPath=" + this.assetPath + ", svgPath=" + this.wKC + ", duration=" + this.duration + ", effectId=" + this.wKD + ")";
      AppMethodBeat.o(241102);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(241105);
      int i = a.a((Comparable)Integer.valueOf(((m.b)paramT1).order), (Comparable)Integer.valueOf(((m.b)paramT2).order));
      AppMethodBeat.o(241105);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.m
 * JD-Core Version:    0.7.0.1
 */