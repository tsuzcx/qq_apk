package com.tencent.mm.mj_template.template_res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.mmdata.rpt.jp;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/template_res/MaasTemplateResMgr;", "", "resId", "", "resRootDir", "", "(ILjava/lang/String;)V", "TAG", "resEventListener", "com/tencent/mm/mj_template/template_res/MaasTemplateResMgr$resEventListener$1", "Lcom/tencent/mm/mj_template/template_res/MaasTemplateResMgr$resEventListener$1;", "getResId", "()I", "resLock", "resRecord", "Lcom/tencent/mm/mj_template/template_res/MaasTemplateResRecord;", "getResRootDir", "()Ljava/lang/String;", "checkMergeRes", "", "checkRes", "", "destroy", "getListDir", "getResultDir", "getTempDir", "init", "isEmpty", "mergeRes", "resList", "", "unzipRes", "subtype", "path", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final int Ue;
  public static final c.a ofY;
  private static final c ogd;
  private static final c oge;
  private final String TAG;
  private final String ofZ;
  private final Object oga;
  private final d ogb;
  private final MaasTemplateResMgr.resEventListener.1 ogc;
  final int resId;
  
  static
  {
    AppMethodBeat.i(239555);
    ofY = new c.a((byte)0);
    Ue = 8;
    ogd = new c(106, s.X(com.tencent.mm.loader.i.b.bms(), "maas-template/album"));
    oge = new c(107, s.X(com.tencent.mm.loader.i.b.bms(), "maas-template/camera"));
    AppMethodBeat.o(239555);
  }
  
  private c(int paramInt, String paramString)
  {
    AppMethodBeat.i(239510);
    this.resId = paramInt;
    this.ofZ = paramString;
    this.TAG = s.X("MicroMsg.MaasTemplateResMgr_", Integer.valueOf(this.resId));
    this.oga = new Object();
    this.ogb = new d(this.resId);
    this.ogc = new MaasTemplateResMgr.resEventListener.1(this, f.hfK);
    AppMethodBeat.o(239510);
  }
  
  private final boolean N(int paramInt, String paramString)
  {
    AppMethodBeat.i(239534);
    Object localObject = this.oga;
    if (paramString == null)
    {
      AppMethodBeat.o(239534);
      return false;
    }
    try
    {
      String str1 = s.X(this.ofZ, "/temp");
      y.bDX(str1);
      String str2 = byN() + '/' + paramInt;
      y.ew(str1, true);
      y.bDX(str1);
      paramInt = y.aA(paramString, str1);
      if (paramInt != 0)
      {
        Log.w(this.TAG, s.X("unzipRes: unzip fail ", Integer.valueOf(paramInt)));
        return false;
      }
      y.ew(str2, true);
      y.qp(str1, str2);
      paramString = this.ogb;
      paramString.bxX().putLong(paramString.ogh, System.currentTimeMillis());
      return true;
    }
    finally
    {
      AppMethodBeat.o(239534);
    }
  }
  
  private final void bP(List<Integer> paramList)
  {
    AppMethodBeat.i(239520);
    Object localObject = this.ogb;
    ((d)localObject).bxX().putLong(((d)localObject).ogi, System.currentTimeMillis());
    localObject = byO();
    y.ew((String)localObject, true);
    y.bDX((String)localObject);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      int i = ((Number)paramList.next()).intValue();
      Log.i(this.TAG, s.X("mergeRes: copy ", Integer.valueOf(i)));
      y.qo(byN() + '/' + i, (String)localObject);
    }
    AppMethodBeat.o(239520);
  }
  
  private final void byM()
  {
    AppMethodBeat.i(239514);
    synchronized (this.oga)
    {
      Object localObject2 = this.ogb;
      long l = ((d)localObject2).bxX().getLong(((d)localObject2).ogh, 0L);
      if (((d)localObject2).bxX().getLong(((d)localObject2).ogi, 0L) < l) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = isEmpty();
        Log.i(this.TAG, "checkMergeRes: update:" + bool1 + ", empty:" + bool2);
        if ((bool1) || (bool2)) {
          break;
        }
        AppMethodBeat.o(239514);
        return;
      }
      localObject2 = new ArrayList();
      Object localObject4 = y.eB(byN(), false);
      if (localObject4 != null)
      {
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          i = Util.getInt(((j)((Iterator)localObject4).next()).name, -1);
          if (i >= 0) {
            ((ArrayList)localObject2).add(Integer.valueOf(i));
          }
        }
      }
    }
    p.N((List)localObject3);
    Log.i(this.TAG, s.X("checkMergeRes: merge res ", localObject3));
    if (!((Collection)localObject3).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bP((List)localObject3);
      }
      ah localah = ah.aiuX;
      AppMethodBeat.o(239514);
      return;
    }
  }
  
  private String byN()
  {
    AppMethodBeat.i(239523);
    String str = s.X(this.ofZ, "/list");
    y.bDX(str);
    AppMethodBeat.o(239523);
    return str;
  }
  
  private final boolean isEmpty()
  {
    AppMethodBeat.i(239528);
    Iterable localIterable = y.eB(byO(), false);
    if (localIterable == null) {}
    for (int i = 0; i <= 0; i = p.v(localIterable))
    {
      AppMethodBeat.o(239528);
      return true;
    }
    AppMethodBeat.o(239528);
    return false;
  }
  
  public final String byO()
  {
    AppMethodBeat.i(239573);
    String str = s.X(this.ofZ, "/result");
    y.bDX(str);
    AppMethodBeat.o(239573);
    return str;
  }
  
  public final boolean byP()
  {
    AppMethodBeat.i(239581);
    jp localjp = new jp();
    localjp.iUt = this.resId;
    Object localObject1 = new b();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    Object localObject2 = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avT(this.resId);
    s.s(localObject2, "resList");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      r localr = (r)((Iterator)localObject2).next();
      a locala = new a();
      locala.subtype = localr.field_subType;
      locala.hCi = Util.getInt(localr.field_fileVersion, 0);
      ((b)localObject1).obH.add(locala);
    }
    localObject1 = ((b)localObject1).toJson().toString();
    s.s(localObject1, "listConfig.toJson().toString()");
    localjp.iUu = localjp.F("SubTypeList", n.a((String)localObject1, ',', ';'), true);
    localjp.bMH();
    Log.i(this.TAG, s.X("checkRes: ", localjp.aIF()));
    if (!isEmpty())
    {
      AppMethodBeat.o(239581);
      return true;
    }
    AppMethodBeat.o(239581);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(239567);
    Log.i(this.TAG, "init: ");
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    Object localObject = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avT(this.resId);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((r)((Iterator)localObject).next()).field_subType;
        if (!y.ZC(byN() + '/' + i))
        {
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
          String str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(this.resId, i);
          Log.i(this.TAG, "init: get cached file " + i + ", " + str);
          if (str != null) {
            N(i, str);
          }
        }
      }
    }
    this.ogc.alive();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(this.resId);
    byM();
    AppMethodBeat.o(239567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.template_res.c
 * JD-Core Version:    0.7.0.1
 */