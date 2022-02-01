package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class pb
  implements pc.b, pd.a
{
  public static final String b = "AUTH_MARKER";
  public final bj a;
  private final rj c;
  private final qn d;
  private final pi e;
  private final mk f;
  private List<AsyncTask> g;
  private final pg h;
  private boolean i;
  private final sj j;
  
  public pb(bg parambg)
  {
    AppMethodBeat.i(225544);
    Context localContext = parambg.c;
    this.j = parambg.b;
    this.c = parambg.b.k;
    this.a = parambg.d;
    this.d = parambg.e;
    this.e = parambg.f;
    this.f = parambg.b.aB;
    this.g = new ArrayList();
    String str3 = "";
    String str4 = "";
    String str2 = str4;
    String str1 = str3;
    if (parambg.b != null)
    {
      str2 = str4;
      str1 = str3;
      if (parambg.b.K() != null)
      {
        str1 = parambg.b.K().getSubKey();
        str2 = parambg.b.K().getSubId();
      }
    }
    this.h = new pg(localContext, parambg, str1);
    this.g.add(new pc(this.a.j, str1, str2, this));
    this.g.add(new pd(parambg, this));
    AppMethodBeat.o(225544);
  }
  
  private void a(pb.a parama, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(225554);
    this.a.a(parama, paramTencentMapOptions);
    AppMethodBeat.o(225554);
  }
  
  private void a(JSONArray paramJSONArray, fo paramfo)
  {
    AppMethodBeat.i(225568);
    if (this.d == null)
    {
      AppMethodBeat.o(225568);
      return;
    }
    Object localObject = this.d;
    String str = ((qn)localObject).d.a("mapStyleList");
    if (paramJSONArray != null)
    {
      List localList = qn.a(paramJSONArray);
      if (localList != null)
      {
        ((qn)localObject).c.clear();
        ((qn)localObject).c.addAll(localList);
        if (!paramJSONArray.toString().equals(str))
        {
          ((qn)localObject).d.a();
          ((qn)localObject).d.a("mapStyleList", paramJSONArray.toString());
        }
      }
    }
    paramJSONArray = this.j.o;
    if (paramJSONArray != null)
    {
      if (paramfo == null) {
        break label305;
      }
      paramJSONArray.b = paramfo;
      kh.b("TDZ", "IndoorAuth:".concat(String.valueOf(paramfo)));
      paramJSONArray.a.a("AIEnabled", paramfo.c);
      paramJSONArray.a.a("AIType", paramfo.d);
      if (paramfo.e != null) {
        paramJSONArray.a.a("AIBuildingList", paramfo.e.toString());
      }
      if (paramJSONArray.d != null)
      {
        paramJSONArray.d.a(paramJSONArray.a());
        if (paramJSONArray.a() == 1) {
          paramJSONArray.d.a(paramJSONArray.b());
        }
      }
    }
    for (;;)
    {
      if (paramJSONArray.b == null) {
        paramJSONArray.b = new fo();
      }
      jw.a(new aa.1(paramJSONArray));
      paramJSONArray = this.h;
      localObject = this.d.a();
      str = paramJSONArray.a();
      if (!pg.e.containsKey(str)) {
        break;
      }
      paramJSONArray.a(str, paramJSONArray.f);
      AppMethodBeat.o(225568);
      return;
      label305:
      paramJSONArray.a.a(new String[] { "AIEnabled", "AIType", "AIBuildingList" });
    }
    paramJSONArray.a(str, paramJSONArray.f);
    kl.b("REQ_CONFIG_UPDATE");
    jw.b(new pg.a(paramJSONArray, (String)localObject, paramfo));
    AppMethodBeat.o(225568);
  }
  
  public final void a()
  {
    AppMethodBeat.i(225577);
    kl.b("REQ_AUTH_CHECK");
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((AsyncTask)localIterator.next()).execute(new Object[0]);
    }
    AppMethodBeat.o(225577);
  }
  
  public final void a(pc.a parama)
  {
    AppMethodBeat.i(225603);
    if (this.i)
    {
      AppMethodBeat.o(225603);
      return;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int m;
    if (parama != null)
    {
      localObject2 = parama.b;
      localObject1 = parama.a;
      if (parama.d != null)
      {
        localObject3 = this.e;
        localObject4 = parama.d;
        if ((localObject4 != null) && (((ph)localObject4).a))
        {
          ((pi)localObject3).b.clear();
          ((pi)localObject3).b.addAll(((ph)localObject4).b);
          int k;
          if ((((pi)localObject3).d.isEmpty()) && (!((pi)localObject3).b.isEmpty()))
          {
            localObject4 = ((pi)localObject3).b.iterator();
            k = 0;
          }
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (pj)((Iterator)localObject4).next();
            Object localObject6 = new pi.a((pi)localObject3, (byte)0);
            pi.a.a((pi.a)localObject6, ((pj)localObject5).a);
            pi.a.b((pi.a)localObject6, ((pj)localObject5).b);
            ((pi)localObject3).d.add(localObject6);
            k = 1;
            continue;
            localObject4 = ((pi)localObject3).b.iterator();
            for (k = 0; ((Iterator)localObject4).hasNext(); k = 1)
            {
              localObject5 = (pj)((Iterator)localObject4).next();
              localObject6 = ((pi)localObject3).d.iterator();
              pi.a locala;
              do
              {
                if (!((Iterator)localObject6).hasNext()) {
                  break;
                }
                locala = (pi.a)((Iterator)localObject6).next();
              } while (!pi.a.a(locala).equals(((pj)localObject5).a));
              if (pi.a.b(locala).equalsIgnoreCase(((pj)localObject5).b)) {
                break label911;
              }
              ((pj)localObject5).e = true;
              pi.a.b(locala, ((pj)localObject5).b);
              m = 1;
              if (m != 0) {
                break label903;
              }
              localObject6 = new pi.a((pi)localObject3, (byte)0);
              pi.a.a((pi.a)localObject6, ((pj)localObject5).a);
              pi.a.b((pi.a)localObject6, ((pj)localObject5).b);
              ((pi)localObject3).d.add(localObject6);
            }
          }
          label382:
          if (k != 0)
          {
            localObject4 = JsonUtils.collectionToJson(((pi)localObject3).d);
            kc.a(((pi)localObject3).c).a("layer-infos", (String)localObject4);
          }
        }
      }
    }
    for (;;)
    {
      if (this.d != null)
      {
        localObject3 = this.d;
        localObject4 = ((qn)localObject3).d.a("mapStyleList");
        if (localObject2 != null)
        {
          localObject5 = qn.a((JSONArray)localObject2);
          if (localObject5 != null)
          {
            ((qn)localObject3).c.clear();
            ((qn)localObject3).c.addAll((Collection)localObject5);
            if (!((JSONArray)localObject2).toString().equals(localObject4))
            {
              ((qn)localObject3).d.a();
              ((qn)localObject3).d.a("mapStyleList", ((JSONArray)localObject2).toString());
            }
          }
        }
        localObject2 = this.j.o;
        if (localObject2 != null)
        {
          if (localObject1 != null)
          {
            ((aa)localObject2).b = ((fo)localObject1);
            kh.b("TDZ", "IndoorAuth:".concat(String.valueOf(localObject1)));
            ((aa)localObject2).a.a("AIEnabled", ((fo)localObject1).c);
            ((aa)localObject2).a.a("AIType", ((fo)localObject1).d);
            if (((fo)localObject1).e != null) {
              ((aa)localObject2).a.a("AIBuildingList", ((fo)localObject1).e.toString());
            }
            if (((aa)localObject2).d != null)
            {
              ((aa)localObject2).d.a(((aa)localObject2).a());
              if (((aa)localObject2).a() == 1) {
                ((aa)localObject2).d.a(((aa)localObject2).b());
              }
            }
            if (((aa)localObject2).b == null) {
              ((aa)localObject2).b = new fo();
            }
            jw.a(new aa.1((aa)localObject2));
          }
        }
        else
        {
          localObject2 = this.h;
          localObject3 = this.d.a();
          localObject4 = ((pg)localObject2).a();
          if (!pg.e.containsKey(localObject4)) {
            break label855;
          }
          ((pg)localObject2).a((String)localObject4, ((pg)localObject2).f);
        }
      }
      else
      {
        label740:
        if ((this.f != null) && (parama != null))
        {
          if ((parama.e != qw.d) && (parama.e != qw.e)) {
            break label892;
          }
          this.f.f(true);
        }
      }
      for (;;)
      {
        localObject1 = (dv)this.f.getMapComponent(dv.class);
        if (localObject1 != null) {
          ((dv)localObject1).a(parama.c);
        }
        kl.d("REQ_AUTH_CHECK");
        AppMethodBeat.o(225603);
        return;
        ((aa)localObject2).a.a(new String[] { "AIEnabled", "AIType", "AIBuildingList" });
        break;
        label855:
        ((pg)localObject2).a((String)localObject4, ((pg)localObject2).f);
        kl.b("REQ_CONFIG_UPDATE");
        jw.b(new pg.a((pg)localObject2, (String)localObject3, (fo)localObject1));
        break label740;
        label892:
        this.f.f(false);
      }
      label903:
      break label382;
      m = 0;
      break;
      label911:
      m = 1;
      break;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  public final void a(boolean paramBoolean, ri paramri)
  {
    AppMethodBeat.i(225591);
    if ((this.j == null) || (paramri == null))
    {
      AppMethodBeat.o(225591);
      return;
    }
    this.j.a(paramBoolean, paramri.c());
    if (paramBoolean) {
      this.c.a();
    }
    this.c.d = true;
    AppMethodBeat.o(225591);
  }
  
  public final void b()
  {
    AppMethodBeat.i(225585);
    if (this.g != null)
    {
      int k = 0;
      while (k < this.g.size())
      {
        ((AsyncTask)this.g.get(k)).cancel(true);
        k += 1;
      }
      this.g.clear();
    }
    this.g = null;
    this.i = true;
    AppMethodBeat.o(225585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pb
 * JD-Core Version:    0.7.0.1
 */