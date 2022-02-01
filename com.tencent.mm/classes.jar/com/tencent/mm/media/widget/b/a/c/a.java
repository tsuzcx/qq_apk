package com.tencent.mm.media.widget.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "", "()V", "KEY_NAME", "", "getKEY_NAME", "()Ljava/lang/String;", "KEY_SUPPORTTAG", "getKEY_SUPPORTTAG", "KEY_VALUE", "getKEY_VALUE", "TAG", "getTAG", "sessionTypeName", "getSessionTypeName", "setSessionTypeName", "(Ljava/lang/String;)V", "sessionValue", "", "getSessionValue", "()I", "setSessionValue", "(I)V", "supportTag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSupportTag", "()Ljava/util/ArrayList;", "setSupportTag", "(Ljava/util/ArrayList;)V", "checkVendorTagSupported", "", "vendorTags", "initSessionType", "", "params", "Lorg/json/JSONObject;", "plugin-mediaeditor_release"})
public final class a
{
  private final String KEY_NAME;
  private final String TAG;
  private final String ler;
  private final String les;
  private String let;
  public int leu;
  private ArrayList<String> lev;
  
  public a()
  {
    AppMethodBeat.i(94213);
    this.TAG = "MicroMsg.WCCameraEffectSessionType";
    this.KEY_NAME = "name";
    this.ler = "value";
    this.les = "supportTag";
    this.lev = new ArrayList();
    AppMethodBeat.o(94213);
  }
  
  public final boolean r(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(94212);
    p.k(paramArrayList, "vendorTags");
    Iterator localIterator1 = paramArrayList.iterator();
    boolean bool2 = false;
    if (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Iterator localIterator2 = ((Iterable)this.lev).iterator();
      while (localIterator2.hasNext())
      {
        paramArrayList = localIterator2.next();
        if (p.h((String)paramArrayList, str)) {
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
  
  public final void w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94211);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94211);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    p.j(localIterator, "params.keys()");
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      if (p.h(localObject1, this.KEY_NAME))
      {
        this.let = paramJSONObject.optString((String)localObject1);
      }
      else if (p.h(localObject1, this.ler))
      {
        this.leu = paramJSONObject.optInt((String)localObject1);
      }
      else if (p.h(localObject1, this.les))
      {
        localObject1 = paramJSONObject.optString((String)localObject1);
        p.j(localObject1, "params.optString(it)");
        Object localObject2 = n.a((CharSequence)localObject1, new String[] { "," });
        localObject1 = new ArrayList();
        String str = (String)((List)localObject2).get(0);
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          this.lev = ((ArrayList)localObject1);
          break;
          if (str.equals("array"))
          {
            localObject2 = ((Iterable)((List)localObject2).subList(1, ((List)localObject2).size())).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
            }
          }
        }
      }
    }
    AppMethodBeat.o(94211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */