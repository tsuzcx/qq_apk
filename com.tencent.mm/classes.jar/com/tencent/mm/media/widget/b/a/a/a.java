package com.tencent.mm.media.widget.b.a.a;

import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_CHILD", "getKEY_CHILD", "KEY_DEFAULTVALUE", "getKEY_DEFAULTVALUE", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_SUPPORTVALUE", "getKEY_SUPPORTVALUE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "childKey", "getChildKey", "setChildKey", "(Ljava/lang/String;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "parentKey", "getParentKey", "setParentKey", "stream", "getStream", "setStream", "supportValue", "getSupportValue", "setSupportValue", "vendorTag", "getVendorTag", "setVendorTag", "initEffectTag", "", "params", "Lorg/json/JSONObject;", "parseData", "parseSupportValue", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectRequestTag";
  public Object dOI;
  public String nIA;
  public Object nIB;
  public String nIC;
  public Integer nID;
  private final String nIr = "cameraId";
  private final String nIs = "parentKey";
  private final String nIt = "childKey";
  private final String nIu = "vendorTag";
  private final String nIv = "supportValue";
  private final String nIw = "stream";
  private final String nIx = "defaultValue";
  public String nIy;
  public Integer nIz;
  
  public final void D(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94192);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94192);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    s.s(localIterator, "params.keys()");
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (s.p(localObject1, this.nIr))
        {
          this.nIz = Integer.valueOf(paramJSONObject.optInt((String)localObject1));
        }
        else if (s.p(localObject1, this.nIs))
        {
          this.nIy = paramJSONObject.optString((String)localObject1);
        }
        else if (s.p(localObject1, this.nIt))
        {
          this.nIA = paramJSONObject.optString((String)localObject1);
        }
        else if (s.p(localObject1, this.nIu))
        {
          this.nIC = paramJSONObject.optString((String)localObject1);
        }
        else if (s.p(localObject1, this.nIv))
        {
          localObject1 = paramJSONObject.optString((String)localObject1);
          s.s(localObject1, "params.optString(it)");
          localObject2 = n.a((CharSequence)localObject1, new String[] { "," });
          localObject1 = (String)((List)localObject2).get(0);
          if (s.p(localObject1, "range")) {
            localObject1 = new Range((Comparable)Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(1))), (Comparable)Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(2))));
          }
        }
      }
    }
    for (;;)
    {
      this.nIB = localObject1;
      break;
      if (s.p(localObject1, "array"))
      {
        localObject1 = this.dOI;
        if ((localObject1 instanceof Boolean))
        {
          localObject1 = new ArrayList();
          localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add(Boolean.valueOf(Boolean.parseBoolean((String)((Iterator)localObject2).next())));
          }
          continue;
        }
        if ((localObject1 instanceof String))
        {
          localObject1 = new ArrayList();
          localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
          }
          continue;
        }
        if ((localObject1 instanceof Integer))
        {
          localObject1 = new ArrayList();
          localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              ((ArrayList)localObject1).add(Integer.valueOf(Integer.parseInt((String)((Iterator)localObject2).next())));
              continue;
              if (s.p(localObject1, this.nIx))
              {
                this.dOI = paramJSONObject.opt((String)localObject1);
                break;
              }
              if (!s.p(localObject1, this.nIw)) {
                break;
              }
              this.nID = Integer.valueOf(paramJSONObject.optInt((String)localObject1));
              break;
              AppMethodBeat.o(94192);
              return;
            }
          }
          continue;
        }
      }
      localObject1 = null;
    }
  }
  
  public final String btL()
  {
    AppMethodBeat.i(94193);
    Object localObject1 = this.nIB;
    Object localObject2;
    if ((localObject1 instanceof Range))
    {
      localObject1 = new StringBuilder("range:");
      localObject2 = this.nIB;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((StringBuilder)localObject1).append(((Range)localObject2).getLower()).append(" ~");
      localObject2 = this.nIB;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((Range)localObject2).getUpper();
      AppMethodBeat.o(94193);
      return localObject1;
    }
    if ((localObject1 instanceof ArrayList))
    {
      localObject1 = new StringBuffer();
      localObject2 = this.nIB;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
        AppMethodBeat.o(94193);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        ((StringBuffer)localObject1).append(localObject3 + '、');
      }
      localObject1 = s.X("array:", localObject1);
      AppMethodBeat.o(94193);
      return localObject1;
    }
    AppMethodBeat.o(94193);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */