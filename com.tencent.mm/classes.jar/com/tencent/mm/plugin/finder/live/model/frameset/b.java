package com.tencent.mm.plugin.finder.live.model.frameset;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;", "", "()V", "bit", "", "getBit", "()I", "setBit", "(I)V", "canClearScreen", "", "getCanClearScreen", "()Z", "setCanClearScreen", "(Z)V", "height", "getHeight", "setHeight", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "landscape", "getLandscape", "setLandscape", "layout_above", "getLayout_above", "setLayout_above", "layout_alignBottom", "getLayout_alignBottom", "setLayout_alignBottom", "layout_alignLeft", "getLayout_alignLeft", "setLayout_alignLeft", "layout_alignParentBottom", "getLayout_alignParentBottom", "setLayout_alignParentBottom", "layout_alignParentEnd", "getLayout_alignParentEnd", "setLayout_alignParentEnd", "layout_alignParentLeft", "getLayout_alignParentLeft", "setLayout_alignParentLeft", "layout_alignParentRight", "getLayout_alignParentRight", "setLayout_alignParentRight", "layout_alignParentStart", "getLayout_alignParentStart", "setLayout_alignParentStart", "layout_alignParentTop", "getLayout_alignParentTop", "setLayout_alignParentTop", "layout_alignRight", "getLayout_alignRight", "setLayout_alignRight", "layout_alignTop", "getLayout_alignTop", "setLayout_alignTop", "layout_alignWithParentIfMissing", "getLayout_alignWithParentIfMissing", "setLayout_alignWithParentIfMissing", "layout_below", "getLayout_below", "setLayout_below", "layout_centerHorizontal", "getLayout_centerHorizontal", "setLayout_centerHorizontal", "layout_centerInParent", "getLayout_centerInParent", "setLayout_centerInParent", "layout_centerVertical", "getLayout_centerVertical", "setLayout_centerVertical", "layout_toEndOf", "getLayout_toEndOf", "setLayout_toEndOf", "layout_toLeftOf", "getLayout_toLeftOf", "setLayout_toLeftOf", "layout_toRightOf", "getLayout_toRightOf", "setLayout_toRightOf", "layout_toStartOf", "getLayout_toStartOf", "setLayout_toStartOf", "marginBottom", "getMarginBottom", "setMarginBottom", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "parentId", "getParentId", "setParentId", "portrait", "getPortrait", "setPortrait", "width", "getWidth", "setWidth", "Companion", "FinderLiveFrameSetLayoutParamFactory", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a CMv;
  private static final String TAG;
  public int CMA;
  public int CMB;
  public boolean CMC;
  public boolean CMD;
  public boolean CME;
  public boolean CMF;
  public boolean CMG;
  public boolean CMH;
  public boolean CMI;
  public boolean CMJ;
  public boolean CMK;
  boolean CML;
  public String CMM = "";
  public String CMN = "";
  public String CMO = "";
  public String CMP = "";
  public String CMQ = "";
  public String CMR = "";
  public String CMS = "";
  public String CMT = "";
  public String CMU = "";
  public String CMV = "";
  public boolean CMw;
  public boolean CMx;
  public boolean CMy = true;
  public int CMz;
  public int height;
  public String id;
  String parentId;
  public int uLf;
  public int uLg;
  public int width;
  
  static
  {
    AppMethodBeat.i(359850);
    CMv = new a((byte)0);
    TAG = "Finder.FinderLiveFrameSetLayoutParam";
    AppMethodBeat.o(359850);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam$FinderLiveFrameSetLayoutParamFactory;", "", "()V", "parseFrameSetParam", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;", "Lkotlin/collections/ArrayList;", "paramsJson", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b CMW;
    
    static
    {
      AppMethodBeat.i(359847);
      CMW = new b();
      AppMethodBeat.o(359847);
    }
    
    public static ArrayList<b> awG(String paramString)
    {
      AppMethodBeat.i(359843);
      ArrayList localArrayList = new ArrayList();
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        paramString = b.CMv;
        Log.e(b.access$getTAG$cp(), "paramJson is empty");
        AppMethodBeat.o(359843);
        return localArrayList;
      }
      localObject1 = b.CMv;
      Log.i(b.access$getTAG$cp(), "parseFrameSetParam:%s", new Object[] { paramString });
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString.length() == 0)
        {
          AppMethodBeat.o(359843);
          return localArrayList;
        }
        k = paramString.length();
        if (k <= 0) {
          break label911;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int k;
          int j;
          Object localObject2;
          int m;
          localObject1 = b.CMv;
          Log.printErrStackTrace(b.access$getTAG$cp(), (Throwable)paramString, "parseFrameSetParam", new Object[0]);
          continue;
          ((b)localObject1).height = m;
          continue;
          boolean bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
          continue;
          int i = j;
        }
      }
      j = i + 1;
      localObject2 = paramString.getJSONObject(i);
      localObject1 = new b();
      ((b)localObject1).id = ((JSONObject)localObject2).getString("id");
      ((b)localObject1).parentId = ((JSONObject)localObject2).getString("parentId");
      if (((JSONObject)localObject2).optInt("portrait", 0) == 1)
      {
        bool = true;
        ((b)localObject1).CMw = bool;
        if (((JSONObject)localObject2).optInt("landscape", 0) != 1) {
          break label925;
        }
        bool = true;
        label181:
        ((b)localObject1).CMx = bool;
        if (((JSONObject)localObject2).optInt("clearScreen", 0) != 1) {
          break label931;
        }
        bool = true;
        label203:
        ((b)localObject1).CMy = bool;
        ((b)localObject1).CMz = ((int)Math.pow(2.0D, ((JSONObject)localObject2).optInt("bit", 0)));
        ((b)localObject1).CMA = a.fromDPToPix(MMApplicationContext.getContext(), ((JSONObject)localObject2).optInt("marginTop", 0));
        ((b)localObject1).uLf = a.fromDPToPix(MMApplicationContext.getContext(), ((JSONObject)localObject2).optInt("marginLeft", 0));
        ((b)localObject1).uLg = a.fromDPToPix(MMApplicationContext.getContext(), ((JSONObject)localObject2).optInt("marginRight", 0));
        ((b)localObject1).CMB = a.fromDPToPix(MMApplicationContext.getContext(), ((JSONObject)localObject2).optInt("marginBottom", 0));
        i = ((JSONObject)localObject2).optInt("width", 0);
        m = ((JSONObject)localObject2).optInt("height", 0);
        if (i < 0) {
          break label937;
        }
      }
      label911:
      label925:
      label931:
      label937:
      for (((b)localObject1).width = a.fromDPToPix(MMApplicationContext.getContext(), i);; ((b)localObject1).width = i)
      {
        if (m < 0) {
          break label972;
        }
        ((b)localObject1).height = a.fromDPToPix(MMApplicationContext.getContext(), m);
        if (((JSONObject)localObject2).optInt("alignParentTop", 0) != 1) {
          break label982;
        }
        bool = true;
        ((b)localObject1).CMC = bool;
        if (((JSONObject)localObject2).optInt("alignParentLeft", 0) != 1) {
          break label988;
        }
        bool = true;
        ((b)localObject1).CMD = bool;
        if (((JSONObject)localObject2).optInt("alignParentRight", 0) != 1) {
          break label994;
        }
        bool = true;
        ((b)localObject1).CME = bool;
        if (((JSONObject)localObject2).optInt("alignParentBottom", 0) != 1) {
          break label1000;
        }
        bool = true;
        ((b)localObject1).CMF = bool;
        if (((JSONObject)localObject2).optInt("alignParentStart", 0) != 1) {
          break label1006;
        }
        bool = true;
        ((b)localObject1).CMG = bool;
        if (((JSONObject)localObject2).optInt("alignParentEnd", 0) != 1) {
          break label1012;
        }
        bool = true;
        ((b)localObject1).CMH = bool;
        if (((JSONObject)localObject2).optInt("centerInParent", 0) != 1) {
          break label1018;
        }
        bool = true;
        ((b)localObject1).CMI = bool;
        if (((JSONObject)localObject2).optInt("centerHorizontal", 0) != 1) {
          break label1024;
        }
        bool = true;
        ((b)localObject1).CMJ = bool;
        if (((JSONObject)localObject2).optInt("centerVertical", 0) != 1) {
          break label1030;
        }
        bool = true;
        ((b)localObject1).CMK = bool;
        if (((JSONObject)localObject2).optInt("alignWithParentIfMissing", 0) != 1) {
          break label1036;
        }
        bool = true;
        ((b)localObject1).CML = bool;
        String str = ((JSONObject)localObject2).optString("alignTop");
        s.s(str, "paramObj.optString(\"alignTop\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMM = str;
        str = ((JSONObject)localObject2).optString("alignBottom");
        s.s(str, "paramObj.optString(\"alignBottom\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMN = str;
        str = ((JSONObject)localObject2).optString("alignLeft");
        s.s(str, "paramObj.optString(\"alignLeft\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMO = str;
        str = ((JSONObject)localObject2).optString("alignRight");
        s.s(str, "paramObj.optString(\"alignRight\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMP = str;
        str = ((JSONObject)localObject2).optString("below");
        s.s(str, "paramObj.optString(\"below\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMQ = str;
        str = ((JSONObject)localObject2).optString("above");
        s.s(str, "paramObj.optString(\"above\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMR = str;
        str = ((JSONObject)localObject2).optString("toLeftOf");
        s.s(str, "paramObj.optString(\"toLeftOf\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMS = str;
        str = ((JSONObject)localObject2).optString("toRightOf");
        s.s(str, "paramObj.optString(\"toRightOf\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMT = str;
        str = ((JSONObject)localObject2).optString("toStartOf");
        s.s(str, "paramObj.optString(\"toStartOf\")");
        s.u(str, "<set-?>");
        ((b)localObject1).CMU = str;
        localObject2 = ((JSONObject)localObject2).optString("toEndOf");
        s.s(localObject2, "paramObj.optString(\"toEndOf\")");
        s.u(localObject2, "<set-?>");
        ((b)localObject1).CMV = ((String)localObject2);
        localArrayList.add(localObject1);
        if (j < k) {
          break label1042;
        }
        AppMethodBeat.o(359843);
        return localArrayList;
        bool = false;
        break;
        bool = false;
        break label181;
        bool = false;
        break label203;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.frameset.b
 * JD-Core Version:    0.7.0.1
 */