package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.game.b.b.j;
import com.tencent.mm.plugin.game.b.b.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class f
  implements com.tencent.mm.plugin.game.api.c
{
  private HashMap<String, n> sZi;
  
  public f()
  {
    AppMethodBeat.i(40957);
    this.sZi = new HashMap();
    AppMethodBeat.o(40957);
  }
  
  private String a(final int paramInt, final e parame, final boolean paramBoolean)
  {
    AppMethodBeat.i(40962);
    if (bs.isNullOrNil(parame.field_localIdList)) {
      a(parame.field_taskId, parame.field_publishSource, null, parame.field_BusinessData);
    }
    for (;;)
    {
      parame = parame.field_taskId;
      AppMethodBeat.o(40962);
      return parame;
      h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40953);
          if (!f.a(f.this, paramInt, parame))
          {
            AppMethodBeat.o(40953);
            return;
          }
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().dv(parame.field_taskId, 2);
          final LinkedList localLinkedList = com.tencent.mm.plugin.game.f.c.ahS(parame.field_localIdList);
          n localn = new n(parame.field_taskId, paramInt, localLinkedList, paramBoolean);
          localn.taE = new n.a()
          {
            public final void mI(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(40952);
              n localn = (n)f.a(f.this).remove(f.1.this.sZk.field_taskId);
              if (localn != null) {
                localn.reset();
              }
              if (paramAnonymous2Boolean)
              {
                ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().dw(f.1.this.sZk.field_taskId, 2);
                f.a(f.this, f.1.this.sZk.field_taskId, f.1.this.sZk.field_publishSource, localLinkedList, f.1.this.sZk.field_BusinessData);
                AppMethodBeat.o(40952);
                return;
              }
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().dw(f.1.this.sZk.field_taskId, 1);
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().ahh(f.1.this.sZk.field_taskId);
              f.du(f.1.this.sZk.field_taskId, -1);
              AppMethodBeat.o(40952);
            }
          };
          localn.cPA();
          f.a(f.this).put(parame.field_taskId, localn);
          AppMethodBeat.o(40953);
        }
      });
    }
  }
  
  private void a(final String paramString1, final int paramInt, LinkedList<String> paramLinkedList, final String paramString2)
  {
    AppMethodBeat.i(40964);
    final b.a locala = new b.a();
    locala.uri = "/cgi-bin/mmgame-bin/publishugctogamecenter";
    locala.funcId = 2989;
    j localj = new j();
    localj.sVo = paramInt;
    int j = 0;
    int k = 0;
    Object localObject = null;
    int m = 0;
    int i = 0;
    long l = 0L;
    if (!bs.gY(paramLinkedList))
    {
      Map localMap = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOq().at(paramLinkedList);
      if (localMap != null)
      {
        localj.sVR = new LinkedList();
        Iterator localIterator = paramLinkedList.iterator();
        j = k;
        paramLinkedList = (LinkedList<String>)localObject;
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localMap.containsKey(localObject))
          {
            localObject = (c)localMap.get(localObject);
            com.tencent.mm.plugin.game.b.b.i locali = new com.tencent.mm.plugin.game.b.b.i();
            if (((c)localObject).field_mediaType == 1)
            {
              locali.sVK = 1;
              j = 1;
            }
            for (;;)
            {
              locali.sVL = ((c)localObject).field_mediaUrl;
              locali.sVM = ((c)localObject).field_thumbPicUrl;
              locali.sVO = ((c)localObject).field_duration;
              locali.Width = ((c)localObject).field_width;
              locali.Height = ((c)localObject).field_height;
              locali.sVP = ((c)localObject).field_size;
              locali.sVN = ((c)localObject).field_isGif;
              locali.sVQ = ((c)localObject).field_editFlag;
              localj.sVR.add(locali);
              break;
              if (((c)localObject).field_mediaType == 4)
              {
                locali.sVK = 2;
                j = 2;
                paramLinkedList = ((c)localObject).field_filePath;
                i = ((c)localObject).field_duration;
                l = ((c)localObject).field_size;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localj.sVS = paramString2;
      localj.sVT = paramString1;
      locala.hvt = localj;
      locala.hvu = new k();
      paramString2 = new HashMap();
      paramString2.put("pushid", paramString1);
      paramString2.put("type", Integer.valueOf(j));
      if (paramLinkedList != null)
      {
        paramString2.put("videoid", paramLinkedList);
        paramString2.put("origtime", Integer.valueOf(i));
        paramString2.put("origsize", Long.valueOf(l));
      }
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40956);
          if (paramString2.containsKey("videoid")) {
            paramString2.put("videoid", com.tencent.mm.vfs.i.aKe((String)paramString2.get("videoid")));
          }
          final long l = System.currentTimeMillis();
          IPCRunCgi.a(locala.aAz(), new IPCRunCgi.a()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
            {
              AppMethodBeat.i(40955);
              ac.i("MicroMsg.Haowan.GameHaowanPublishImpl", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              f.3.this.sZo.put("costtime", Long.valueOf(System.currentTimeMillis() - l));
              f.3.this.sZo.put("topicid", Integer.valueOf(((k)paramAnonymous2b.hvs.hvw).sVU));
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2String = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp();
                paramAnonymous2b = f.3.this.jVf;
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(paramAnonymous2b);
                paramAnonymous2String.au(localLinkedList);
                f.du(f.3.this.jVf, 0);
                com.tencent.mm.game.report.b.a.a(ai.getContext(), 8765, 0, 48, com.tencent.mm.game.report.b.a.a(f.3.this.sZq, f.3.this.sZo));
                AppMethodBeat.o(40955);
                return;
              }
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().ahh(f.3.this.jVf);
              paramAnonymous2String = f.3.this.jVf;
              if (paramAnonymous2Int2 > 0) {}
              for (paramAnonymous2Int1 = -paramAnonymous2Int2;; paramAnonymous2Int1 = paramAnonymous2Int2)
              {
                f.du(paramAnonymous2String, paramAnonymous2Int1);
                f.3.this.sZo.put("failid", Integer.valueOf(paramAnonymous2Int2));
                com.tencent.mm.game.report.b.a.a(ai.getContext(), 8765, 0, 56, com.tencent.mm.game.report.b.a.a(f.3.this.sZq, f.3.this.sZo));
                AppMethodBeat.o(40955);
                return;
              }
            }
          });
          AppMethodBeat.o(40956);
        }
      });
      AppMethodBeat.o(40964);
      return;
      paramLinkedList = null;
      i = m;
    }
  }
  
  private void ahf(final String paramString)
  {
    AppMethodBeat.i(40963);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().dv(paramString, 1);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().ahh(paramString);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40954);
        f.du(paramString, -2);
        AppMethodBeat.o(40954);
      }
    }, 2000L);
    AppMethodBeat.o(40963);
  }
  
  public final String a(int paramInt1, int paramInt2, JSONArray paramJSONArray, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(40958);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    String str = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis()).getBytes());
    paramJSONArray = com.tencent.mm.plugin.game.f.c.x(paramJSONArray);
    localObject = new e();
    ((e)localObject).field_taskId = str;
    ((e)localObject).field_createTime = (System.currentTimeMillis() / 1000L);
    ((e)localObject).field_publishSource = paramInt1;
    ((e)localObject).field_mediaType = paramInt2;
    if (!bs.gY(paramJSONArray)) {}
    for (paramJSONArray = paramJSONArray.toString();; paramJSONArray = "")
    {
      ((e)localObject).field_localIdList = paramJSONArray;
      ((e)localObject).field_BusinessData = paramString;
      ((e)localObject).field_compressImg = paramBoolean;
      ac.i("MicroMsg.Haowan.GameHaowanPublishImpl", "addToDB: ".concat(String.valueOf(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().insert((com.tencent.mm.sdk.e.c)localObject))));
      paramJSONArray = a(paramInt2, (e)localObject, paramBoolean);
      AppMethodBeat.o(40958);
      return paramJSONArray;
    }
  }
  
  public final String agN(String paramString)
  {
    AppMethodBeat.i(40959);
    Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp();
    paramString = String.format("select * from %s where %s=\"%s\" and %s<>%d", new Object[] { "GameHaowanPublishEdition", "taskId", paramString, "publishState", Integer.valueOf(2) });
    ac.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryWhenPublishNotSuccess, sql : %s", new Object[] { paramString });
    localObject = ((g)localObject).rawQuery(paramString, new String[0]);
    if (localObject == null)
    {
      paramString = null;
      if (paramString == null)
      {
        AppMethodBeat.o(40959);
        return null;
      }
    }
    else
    {
      if (!((Cursor)localObject).moveToNext()) {
        break label158;
      }
      paramString = new e();
      paramString.convertFrom((Cursor)localObject);
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      break;
      paramString = a(paramString.field_mediaType, paramString, paramString.field_compressImg);
      AppMethodBeat.o(40959);
      return paramString;
      label158:
      paramString = null;
    }
  }
  
  public final JSONArray b(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(40960);
    JSONArray localJSONArray = new JSONArray();
    e locale;
    if (paramBoolean)
    {
      paramJSONArray = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().cPn();
      if (bs.gY(paramJSONArray))
      {
        AppMethodBeat.o(40960);
        return null;
      }
      paramJSONArray = paramJSONArray.iterator();
      while (paramJSONArray.hasNext())
      {
        locale = (e)paramJSONArray.next();
        localJSONArray.put(new b(locale.field_taskId, locale.field_publishState, locale.field_localIdList, locale.field_BusinessData, locale.field_createTime, locale.field_mixState).toJson());
      }
      AppMethodBeat.o(40960);
      return localJSONArray;
    }
    paramJSONArray = com.tencent.mm.plugin.game.f.c.x(paramJSONArray);
    if (bs.gY(paramJSONArray))
    {
      AppMethodBeat.o(40960);
      return null;
    }
    paramJSONArray = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().av(paramJSONArray);
    if (bs.gY(paramJSONArray))
    {
      AppMethodBeat.o(40960);
      return null;
    }
    paramJSONArray = paramJSONArray.iterator();
    while (paramJSONArray.hasNext())
    {
      locale = (e)paramJSONArray.next();
      localJSONArray.put(new b(locale.field_taskId, locale.field_publishState, locale.field_localIdList, locale.field_BusinessData, locale.field_createTime, locale.field_mixState).toJson());
    }
    AppMethodBeat.o(40960);
    return localJSONArray;
  }
  
  public final void c(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(40961);
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      paramJSONArray = this.sZi.keySet().iterator();
      while (paramJSONArray.hasNext())
      {
        localObject1 = (String)paramJSONArray.next();
        ((n)this.sZi.get(localObject1)).cPC();
      }
      localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp();
      paramJSONArray = String.format("select * from %s", new Object[] { "GameHaowanPublishEdition" });
      ac.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAll, sql : %s", new Object[] { paramJSONArray });
      localObject2 = ((g)localObject1).rawQuery(paramJSONArray, new String[0]);
      if (localObject2 == null) {
        paramJSONArray = null;
      }
      while (bs.gY(paramJSONArray))
      {
        paramJSONArray = paramJSONArray.iterator();
        while (paramJSONArray.hasNext())
        {
          localObject2 = com.tencent.mm.plugin.game.f.c.ahS(((e)paramJSONArray.next()).field_localIdList);
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOq().au((LinkedList)localObject2);
        }
        paramJSONArray = new LinkedList();
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new e();
          ((e)localObject3).convertFrom((Cursor)localObject2);
          paramJSONArray.add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      paramJSONArray = String.format("delete from %s", new Object[] { "GameHaowanPublishEdition" });
      ac.i("MicroMsg.Haowan.GameHaowanPublishStorage", "deleteAll, sql : %s", new Object[] { paramJSONArray });
      ((g)localObject1).execSQL("GameHaowanPublishEdition", paramJSONArray);
      this.sZi.clear();
      com.tencent.mm.plugin.game.api.a.dr("", 1);
      AppMethodBeat.o(40961);
      return;
    }
    paramJSONArray = com.tencent.mm.plugin.game.f.c.x(paramJSONArray);
    if (bs.gY(paramJSONArray))
    {
      AppMethodBeat.o(40961);
      return;
    }
    Object localObject1 = paramJSONArray.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (n)this.sZi.remove(localObject2);
      if (localObject3 != null) {
        ((n)localObject3).cPC();
      }
      com.tencent.mm.plugin.game.api.a.dr((String)localObject2, 1);
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp().au(paramJSONArray);
    AppMethodBeat.o(40961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.f
 * JD-Core Version:    0.7.0.1
 */