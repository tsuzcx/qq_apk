package com.tencent.mm.media.widget.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "", "()V", "KEY_NAME", "", "getKEY_NAME", "()Ljava/lang/String;", "KEY_SUPPORTTAG", "getKEY_SUPPORTTAG", "KEY_VALUE", "getKEY_VALUE", "TAG", "getTAG", "sessionTypeName", "getSessionTypeName", "setSessionTypeName", "(Ljava/lang/String;)V", "sessionValue", "", "getSessionValue", "()I", "setSessionValue", "(I)V", "supportTag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSupportTag", "()Ljava/util/ArrayList;", "setSupportTag", "(Ljava/util/ArrayList;)V", "checkVendorTagSupported", "", "vendorTags", "initSessionType", "", "params", "Lorg/json/JSONObject;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final String KEY_NAME;
  private final String TAG;
  private final String nJb;
  private final String nJc;
  private String nJd;
  public int nJe;
  private ArrayList<String> nJf;
  
  public a()
  {
    AppMethodBeat.i(94213);
    this.TAG = "MicroMsg.WCCameraEffectSessionType";
    this.KEY_NAME = "name";
    this.nJb = "value";
    this.nJc = "supportTag";
    this.nJf = new ArrayList();
    AppMethodBeat.o(94213);
  }
  
  public final void F(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94211);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94211);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    s.s(localIterator, "params.keys()");
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      if (s.p(localObject1, this.KEY_NAME))
      {
        this.nJd = paramJSONObject.optString((String)localObject1);
      }
      else if (s.p(localObject1, this.nJb))
      {
        this.nJe = paramJSONObject.optInt((String)localObject1);
      }
      else if (s.p(localObject1, this.nJc))
      {
        localObject1 = paramJSONObject.optString((String)localObject1);
        s.s(localObject1, "params.optString(it)");
        Object localObject2 = n.a((CharSequence)localObject1, new String[] { "," });
        localObject1 = new ArrayList();
        if (s.p((String)((List)localObject2).get(0), "array"))
        {
          localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
          }
        }
        s.u(localObject1, "<set-?>");
        this.nJf = ((ArrayList)localObject1);
      }
    }
    AppMethodBeat.o(94211);
  }
  
  public final boolean u(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(94212);
    s.u(paramArrayList, "vendorTags");
    Iterator localIterator1 = paramArrayList.iterator();
    boolean bool2 = false;
    if (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = ((Iterable)this.nJf).iterator();
      while (localIterator2.hasNext())
      {
        paramArrayList = localIterator2.next();
        if (s.p((String)paramArrayList, str)) {
          label85:
          if (paramArrayList == null) {
            break label109;
          }
        }
      }
      label109:
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        AppMethodBeat.o(94212);
        return bool1;
        paramArrayList = null;
        break label85;
      }
    }
    AppMethodBeat.o(94212);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */