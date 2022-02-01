package com.tencent.mm.media.widget.b.a.a;

import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_CHILD", "getKEY_CHILD", "KEY_DEFAULTVALUE", "getKEY_DEFAULTVALUE", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_SUPPORTVALUE", "getKEY_SUPPORTVALUE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "childKey", "getChildKey", "setChildKey", "(Ljava/lang/String;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "parentKey", "getParentKey", "setParentKey", "stream", "getStream", "setStream", "supportValue", "getSupportValue", "setSupportValue", "vendorTag", "getVendorTag", "setVendorTag", "initEffectTag", "", "params", "Lorg/json/JSONObject;", "parseData", "parseSupportValue", "plugin-mediaeditor_release"})
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectRequestTag";
  public Object aEX;
  private final String ioC = "cameraId";
  private final String ioD = "parentKey";
  private final String ioE = "childKey";
  private final String ioF = "vendorTag";
  private final String ioG = "supportValue";
  private final String ioH = "stream";
  private final String ioI = "defaultValue";
  public String ioJ;
  public Integer ioK;
  public String ioL;
  public Object ioM;
  public String ioN;
  public Integer ioO;
  
  public final String aPV()
  {
    AppMethodBeat.i(94193);
    Object localObject1 = this.ioM;
    Object localObject2;
    if ((localObject1 instanceof Range))
    {
      localObject1 = new StringBuilder("range:");
      localObject2 = this.ioM;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((StringBuilder)localObject1).append((Integer)((Range)localObject2).getLower()).append(" ~");
      localObject2 = this.ioM;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject1 = (Integer)((Range)localObject2).getUpper();
      AppMethodBeat.o(94193);
      return localObject1;
    }
    if ((localObject1 instanceof ArrayList))
    {
      localObject1 = new StringBuffer();
      localObject2 = this.ioM;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        ((StringBuffer)localObject1).append(localObject3 + '、');
      }
      localObject1 = "array:" + (StringBuffer)localObject1;
      AppMethodBeat.o(94193);
      return localObject1;
    }
    AppMethodBeat.o(94193);
    return "";
  }
  
  public final void s(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94192);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94192);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    p.g(localIterator, "params.keys()");
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (p.j(localObject1, this.ioC))
        {
          this.ioK = Integer.valueOf(paramJSONObject.optInt((String)localObject1));
        }
        else if (p.j(localObject1, this.ioD))
        {
          this.ioJ = paramJSONObject.optString((String)localObject1);
        }
        else if (p.j(localObject1, this.ioE))
        {
          this.ioL = paramJSONObject.optString((String)localObject1);
        }
        else if (p.j(localObject1, this.ioF))
        {
          this.ioN = paramJSONObject.optString((String)localObject1);
        }
        else if (p.j(localObject1, this.ioG))
        {
          localObject1 = paramJSONObject.optString((String)localObject1);
          p.g(localObject1, "params.optString(it)");
          localObject2 = n.a((CharSequence)localObject1, new String[] { "," });
          localObject1 = (String)((List)localObject2).get(0);
          switch (((String)localObject1).hashCode())
          {
          default: 
            label224:
            localObject1 = null;
          }
        }
      }
    }
    for (;;)
    {
      label226:
      this.ioM = localObject1;
      break;
      if (!((String)localObject1).equals("array")) {
        break label224;
      }
      localObject1 = this.aEX;
      if ((localObject1 instanceof Boolean))
      {
        localObject1 = new ArrayList();
        localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((ArrayList)localObject1).add(Boolean.valueOf(Boolean.parseBoolean((String)((Iterator)localObject2).next())));
            continue;
            if (!((String)localObject1).equals("range")) {
              break;
            }
            localObject1 = new Range((Comparable)Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(1))), (Comparable)Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(2))));
            break label226;
          }
        }
      }
      else if ((localObject1 instanceof String))
      {
        localObject1 = new ArrayList();
        localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
        }
      }
      else
      {
        if (!(localObject1 instanceof Integer)) {
          break label224;
        }
        localObject1 = new ArrayList();
        localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((ArrayList)localObject1).add(Integer.valueOf(Integer.parseInt((String)((Iterator)localObject2).next())));
            continue;
            if (p.j(localObject1, this.ioI))
            {
              this.aEX = paramJSONObject.opt((String)localObject1);
              break;
            }
            if (!p.j(localObject1, this.ioH)) {
              break;
            }
            this.ioO = Integer.valueOf(paramJSONObject.optInt((String)localObject1));
            break;
            AppMethodBeat.o(94192);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */