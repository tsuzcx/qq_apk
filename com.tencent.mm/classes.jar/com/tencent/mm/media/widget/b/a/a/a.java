package com.tencent.mm.media.widget.b.a.a;

import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_CHILD", "getKEY_CHILD", "KEY_DEFAULTVALUE", "getKEY_DEFAULTVALUE", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_SUPPORTVALUE", "getKEY_SUPPORTVALUE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "childKey", "getChildKey", "setChildKey", "(Ljava/lang/String;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "parentKey", "getParentKey", "setParentKey", "stream", "getStream", "setStream", "supportValue", "getSupportValue", "setSupportValue", "vendorTag", "getVendorTag", "setVendorTag", "initEffectTag", "", "params", "Lorg/json/JSONObject;", "parseData", "parseSupportValue", "plugin-mediaeditor_release"})
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectRequestTag";
  public Object aCy;
  private final String gzK = "cameraId";
  private final String gzL = "parentKey";
  private final String gzM = "childKey";
  private final String gzN = "vendorTag";
  private final String gzO = "supportValue";
  private final String gzP = "stream";
  private final String gzQ = "defaultValue";
  public String gzR;
  public Integer gzS;
  public String gzT;
  public Object gzU;
  public String gzV;
  public Integer gzW;
  
  public final String anD()
  {
    AppMethodBeat.i(94193);
    Object localObject1 = this.gzU;
    Object localObject2;
    if ((localObject1 instanceof Range))
    {
      localObject1 = new StringBuilder("range:");
      localObject2 = this.gzU;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((StringBuilder)localObject1).append((Integer)((Range)localObject2).getLower()).append(" ~");
      localObject2 = this.gzU;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
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
      localObject2 = this.gzU;
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
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
  
  public final void o(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94192);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94192);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    k.g(localIterator, "params.keys()");
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (k.g(localObject1, this.gzK))
        {
          this.gzS = Integer.valueOf(paramJSONObject.optInt((String)localObject1));
        }
        else if (k.g(localObject1, this.gzL))
        {
          this.gzR = paramJSONObject.optString((String)localObject1);
        }
        else if (k.g(localObject1, this.gzM))
        {
          this.gzT = paramJSONObject.optString((String)localObject1);
        }
        else if (k.g(localObject1, this.gzN))
        {
          this.gzV = paramJSONObject.optString((String)localObject1);
        }
        else if (k.g(localObject1, this.gzO))
        {
          localObject1 = paramJSONObject.optString((String)localObject1);
          k.g(localObject1, "params.optString(it)");
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
      this.gzU = localObject1;
      break;
      if (!((String)localObject1).equals("array")) {
        break label224;
      }
      localObject1 = this.aCy;
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
            if (k.g(localObject1, this.gzQ))
            {
              this.aCy = paramJSONObject.opt((String)localObject1);
              break;
            }
            if (!k.g(localObject1, this.gzP)) {
              break;
            }
            this.gzW = Integer.valueOf(paramJSONObject.optInt((String)localObject1));
            break;
            AppMethodBeat.o(94192);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */