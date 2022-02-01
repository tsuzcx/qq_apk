package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/config/ExptMapping;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "reportValue", "getReportValue", "()Ljava/lang/String;", "applyToWxConfig", "", "wxConfig", "Lorg/json/JSONObject;", "toReportValue", "Companion", "ExptManager", "Factory", "luggage-wechat-nano-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final a eqR;
  private String eqS;
  public final HashMap<String, String> map;
  
  static
  {
    AppMethodBeat.i(220312);
    eqR = new a((byte)0);
    AppMethodBeat.o(220312);
  }
  
  private a()
  {
    AppMethodBeat.i(220298);
    this.map = new HashMap();
    AppMethodBeat.o(220298);
  }
  
  private final String ark()
  {
    AppMethodBeat.i(220301);
    Object localObject1 = (CharSequence)this.eqS;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        try
        {
          Object localObject2 = (Map)this.map;
          localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            String str2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            ((Collection)localObject1).add(str2 + '=' + (String)localObject3);
            continue;
            str1 = this.eqS;
          }
        }
        catch (Exception localException)
        {
          Log.e("Luggage.ExptMapping", s.X("reportValue::get exception:", localException));
        }
      }
    }
    for (;;)
    {
      String str1;
      AppMethodBeat.o(220301);
      return str1;
      i = 0;
      break;
      this.eqS = p.a((Iterable)str1, (CharSequence)"&", null, null, 0, null, null, 62);
    }
  }
  
  public final String arl()
  {
    AppMethodBeat.i(220315);
    String str2 = ark();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(220315);
    return str1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/config/ExptMapping$Companion;", "", "()V", "TAG", "", "luggage-wechat-nano-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */