package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.game.autogen.b.j;
import com.tencent.mm.plugin.game.autogen.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class f
  implements com.tencent.mm.plugin.game.api.d
{
  private HashMap<String, n> Iyv;
  
  public f()
  {
    AppMethodBeat.i(40957);
    this.Iyv = new HashMap();
    AppMethodBeat.o(40957);
  }
  
  private String a(final int paramInt, final e parame, final boolean paramBoolean)
  {
    AppMethodBeat.i(40962);
    if (Util.isNullOrNil(parame.field_localIdList)) {
      a(parame.field_taskId, parame.field_publishSource, null, parame.field_BusinessData, parame.field_sourceSceneId);
    }
    for (;;)
    {
      parame = parame.field_taskId;
      AppMethodBeat.o(40962);
      return parame;
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40953);
          if (!f.a(f.this, paramInt, parame))
          {
            AppMethodBeat.o(40953);
            return;
          }
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().ft(parame.field_taskId, 2);
          final LinkedList localLinkedList = com.tencent.mm.plugin.game.d.c.aHo(parame.field_localIdList);
          n localn = new n(parame.field_taskId, paramInt, localLinkedList, paramBoolean);
          localn.IzU = new n.a()
          {
            public final void wp(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(40952);
              n localn = (n)f.a(f.this).remove(f.1.this.Iyx.field_taskId);
              if (localn != null) {
                localn.reset();
              }
              if (paramAnonymous2Boolean)
              {
                ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().fu(f.1.this.Iyx.field_taskId, 2);
                f.a(f.this, f.1.this.Iyx.field_taskId, f.1.this.Iyx.field_publishSource, localLinkedList, f.1.this.Iyx.field_BusinessData, f.1.this.Iyx.field_sourceSceneId);
                AppMethodBeat.o(40952);
                return;
              }
              ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().fu(f.1.this.Iyx.field_taskId, 1);
              ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().aGx(f.1.this.Iyx.field_taskId);
              f.fs(f.1.this.Iyx.field_taskId, -1);
              AppMethodBeat.o(40952);
            }
          };
          localn.fFA();
          f.a(f.this).put(parame.field_taskId, localn);
          AppMethodBeat.o(40953);
        }
      });
    }
  }
  
  private void a(final String paramString1, final int paramInt1, LinkedList<String> paramLinkedList, final String paramString2, final int paramInt2)
  {
    AppMethodBeat.i(276825);
    final c.a locala = new c.a();
    locala.uri = "/cgi-bin/mmgame-bin/publishugctogamecenter";
    locala.funcId = 2989;
    j localj = new j();
    localj.IcB = paramInt1;
    int j = 0;
    int k = 0;
    Object localObject = null;
    int m = 0;
    int i = 0;
    long l = 0L;
    if (!Util.isNullOrNil(paramLinkedList))
    {
      Map localMap = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCl().bq(paramLinkedList);
      if (localMap != null)
      {
        localj.Idy = new LinkedList();
        Iterator localIterator = paramLinkedList.iterator();
        j = k;
        paramLinkedList = (LinkedList<String>)localObject;
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localMap.containsKey(localObject))
          {
            localObject = (c)localMap.get(localObject);
            com.tencent.mm.plugin.game.autogen.b.i locali = new com.tencent.mm.plugin.game.autogen.b.i();
            if (((c)localObject).field_mediaType == 1)
            {
              locali.Idt = 1;
              j = 1;
            }
            for (;;)
            {
              locali.Idu = ((c)localObject).field_mediaUrl;
              locali.Idv = ((c)localObject).field_thumbPicUrl;
              locali.crr = ((c)localObject).field_duration;
              locali.Width = ((c)localObject).field_width;
              locali.Height = ((c)localObject).field_height;
              locali.IcI = ((c)localObject).field_size;
              locali.Idw = ((c)localObject).field_isGif;
              locali.Idx = ((c)localObject).field_editFlag;
              localj.Idy.add(locali);
              break;
              if (((c)localObject).field_mediaType == 4)
              {
                locali.Idt = 2;
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
      localj.Idz = paramString2;
      localj.IdA = paramString1;
      locala.otE = localj;
      locala.otF = new k();
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
            paramString2.put("videoid", y.bub((String)paramString2.get("videoid")));
          }
          final long l = System.currentTimeMillis();
          IPCRunCgi.a(locala.bEF(), new IPCRunCgi.a()
          {
            public final void callback(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.am.c paramAnonymous2c)
            {
              AppMethodBeat.i(40955);
              Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              f.3.this.IyB.put("costtime", Long.valueOf(System.currentTimeMillis() - l));
              f.3.this.IyB.put("topicid", Integer.valueOf(((k)c.c.b(paramAnonymous2c.otC)).IdB));
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                paramAnonymous2String = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk();
                paramAnonymous2c = f.3.this.ruW;
                LinkedList localLinkedList = new LinkedList();
                localLinkedList.add(paramAnonymous2c);
                paramAnonymous2String.br(localLinkedList);
                f.fs(f.3.this.ruW, 0);
                com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8765, 0, 48, f.3.this.IyD, com.tencent.mm.game.report.b.a.a(f.3.this.IyE, f.3.this.IyB));
                AppMethodBeat.o(40955);
                return;
              }
              ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().aGx(f.3.this.ruW);
              paramAnonymous2String = f.3.this.ruW;
              if (paramAnonymous2Int2 > 0) {}
              for (paramAnonymous2Int1 = -paramAnonymous2Int2;; paramAnonymous2Int1 = paramAnonymous2Int2)
              {
                f.fs(paramAnonymous2String, paramAnonymous2Int1);
                f.3.this.IyB.put("failid", Integer.valueOf(paramAnonymous2Int2));
                com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8765, 0, 56, f.3.this.IyD, com.tencent.mm.game.report.b.a.a(f.3.this.IyE, f.3.this.IyB));
                AppMethodBeat.o(40955);
                return;
              }
            }
          });
          AppMethodBeat.o(40956);
        }
      });
      AppMethodBeat.o(276825);
      return;
      paramLinkedList = null;
      i = m;
    }
  }
  
  private void aGv(final String paramString)
  {
    AppMethodBeat.i(40963);
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().ft(paramString, 1);
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().aGx(paramString);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40954);
        f.fs(paramString, -2);
        AppMethodBeat.o(40954);
      }
    }, 2000L);
    AppMethodBeat.o(40963);
  }
  
  public final String a(int paramInt1, int paramInt2, JSONArray paramJSONArray, String paramString, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(276844);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    String str = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.kernel.b.getUin() + "_" + System.currentTimeMillis()).getBytes());
    paramJSONArray = com.tencent.mm.plugin.game.d.c.D(paramJSONArray);
    localObject = new e();
    ((e)localObject).field_taskId = str;
    ((e)localObject).field_createTime = (System.currentTimeMillis() / 1000L);
    ((e)localObject).field_publishSource = paramInt1;
    ((e)localObject).field_mediaType = paramInt2;
    if (!Util.isNullOrNil(paramJSONArray)) {}
    for (paramJSONArray = paramJSONArray.toString();; paramJSONArray = "")
    {
      ((e)localObject).field_localIdList = paramJSONArray;
      ((e)localObject).field_BusinessData = paramString;
      ((e)localObject).field_compressImg = paramBoolean;
      ((e)localObject).field_sourceSceneId = paramInt3;
      Log.i("MicroMsg.Haowan.GameHaowanPublishImpl", "addToDB: ".concat(String.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().insert((IAutoDBItem)localObject))));
      paramJSONArray = a(paramInt2, (e)localObject, paramBoolean);
      AppMethodBeat.o(276844);
      return paramJSONArray;
    }
  }
  
  public final String aFn(String paramString)
  {
    AppMethodBeat.i(40959);
    Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk();
    paramString = String.format("select * from %s where %s=\"%s\" and %s<>%d", new Object[] { "GameHaowanPublishEdition", "taskId", paramString, "publishState", Integer.valueOf(2) });
    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryWhenPublishNotSuccess, sql : %s", new Object[] { paramString });
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
      paramJSONArray = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().fFn();
      if (Util.isNullOrNil(paramJSONArray))
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
    paramJSONArray = com.tencent.mm.plugin.game.d.c.D(paramJSONArray);
    if (Util.isNullOrNil(paramJSONArray))
    {
      AppMethodBeat.o(40960);
      return null;
    }
    paramJSONArray = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().bs(paramJSONArray);
    if (Util.isNullOrNil(paramJSONArray))
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
      paramJSONArray = this.Iyv.keySet().iterator();
      while (paramJSONArray.hasNext())
      {
        localObject1 = (String)paramJSONArray.next();
        ((n)this.Iyv.get(localObject1)).fFC();
      }
      localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk();
      paramJSONArray = String.format("select * from %s", new Object[] { "GameHaowanPublishEdition" });
      Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAll, sql : %s", new Object[] { paramJSONArray });
      localObject2 = ((g)localObject1).rawQuery(paramJSONArray, new String[0]);
      if (localObject2 == null) {
        paramJSONArray = null;
      }
      while (Util.isNullOrNil(paramJSONArray))
      {
        paramJSONArray = paramJSONArray.iterator();
        while (paramJSONArray.hasNext())
        {
          localObject2 = com.tencent.mm.plugin.game.d.c.aHo(((e)paramJSONArray.next()).field_localIdList);
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCl().br((LinkedList)localObject2);
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
      Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "deleteAll, sql : %s", new Object[] { paramJSONArray });
      ((g)localObject1).execSQL("GameHaowanPublishEdition", paramJSONArray);
      this.Iyv.clear();
      com.tencent.mm.plugin.game.api.a.fm("", 1);
      AppMethodBeat.o(40961);
      return;
    }
    paramJSONArray = com.tencent.mm.plugin.game.d.c.D(paramJSONArray);
    if (Util.isNullOrNil(paramJSONArray))
    {
      AppMethodBeat.o(40961);
      return;
    }
    Object localObject1 = paramJSONArray.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (n)this.Iyv.remove(localObject2);
      if (localObject3 != null) {
        ((n)localObject3).fFC();
      }
      com.tencent.mm.plugin.game.api.a.fm((String)localObject2, 1);
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().br(paramJSONArray);
    AppMethodBeat.o(40961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.f
 * JD-Core Version:    0.7.0.1
 */