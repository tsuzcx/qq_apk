package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public final class e
  implements com.tencent.mm.plugin.game.api.c
{
  private HashMap<String, g> nkW;
  
  public e()
  {
    AppMethodBeat.i(151811);
    this.nkW = new HashMap();
    AppMethodBeat.o(151811);
  }
  
  private String a(int paramInt, d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(151816);
    if (bo.isNullOrNil(paramd.field_localIdList)) {
      a(paramd.field_taskId, paramd.field_publishSource, null, paramd.field_BusinessData);
    }
    for (;;)
    {
      paramd = paramd.field_taskId;
      AppMethodBeat.o(151816);
      return paramd;
      com.tencent.mm.sdk.g.d.ysm.execute(new e.1(this, paramd, paramInt, paramBoolean1, paramBoolean2));
    }
  }
  
  private void a(String paramString1, int paramInt, LinkedList<String> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151817);
    b.a locala1 = new b.a();
    locala1.uri = "/cgi-bin/mmgame-bin/publishugctogamecenter";
    locala1.funcId = 2989;
    com.tencent.mm.plugin.game.b.a.b localb = new com.tencent.mm.plugin.game.b.a.b();
    localb.niK = paramInt;
    int k = 0;
    int i = 0;
    Iterator localIterator = null;
    com.tencent.mm.plugin.game.b.a.a locala = null;
    Object localObject = localIterator;
    int j = k;
    if (!bo.es(paramLinkedList))
    {
      Map localMap = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().X(paramLinkedList);
      localObject = localIterator;
      j = k;
      if (localMap != null)
      {
        localb.niL = new LinkedList();
        localIterator = paramLinkedList.iterator();
        paramLinkedList = locala;
        do
        {
          localObject = paramLinkedList;
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
        } while (!localMap.containsKey(localObject));
        localObject = (b)localMap.get(localObject);
        locala = new com.tencent.mm.plugin.game.b.a.a();
        if (((b)localObject).field_mediaType == 1)
        {
          locala.niE = 1;
          i = 1;
        }
        for (;;)
        {
          locala.niF = ((b)localObject).field_mediaUrl;
          locala.niG = ((b)localObject).field_thumbPicUrl;
          locala.niI = ((b)localObject).field_duration;
          locala.Width = ((b)localObject).field_width;
          locala.Height = ((b)localObject).field_height;
          locala.niJ = ((b)localObject).field_size;
          locala.niH = ((b)localObject).field_isGif;
          localb.niL.add(locala);
          break;
          if (((b)localObject).field_mediaType == 4)
          {
            locala.niE = 2;
            i = 2;
            paramLinkedList = ((b)localObject).field_filePath;
          }
        }
      }
    }
    localb.niM = paramString2;
    localb.niN = paramString1;
    locala1.fsX = localb;
    locala1.fsY = new com.tencent.mm.plugin.game.b.a.c();
    paramLinkedList = new HashMap();
    paramLinkedList.put("pushid", paramString1);
    paramLinkedList.put("type", Integer.valueOf(j));
    if (localObject != null) {
      paramLinkedList.put("videoid", localObject);
    }
    com.tencent.mm.ch.a.post(new e.2(this, paramLinkedList, locala1, paramInt, paramString1));
    AppMethodBeat.o(151817);
  }
  
  public final String PM(String paramString)
  {
    AppMethodBeat.i(151813);
    Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV();
    paramString = String.format("select * from %s where %s=\"%s\" and %s<>%d", new Object[] { "GameHaowanPublishEdition", "taskId", paramString, "publishState", Integer.valueOf(2) });
    ab.i("MicroMsg.GameHaowanPublishStorage", "queryWhenPublishNotSuccess, sql : %s", new Object[] { paramString });
    localObject = ((f)localObject).rawQuery(paramString, new String[0]);
    if (localObject == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(151813);
      return null;
      paramString = new d();
      if (((Cursor)localObject).moveToNext()) {
        paramString.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    paramString = a(paramString.field_mediaType, paramString, paramString.field_compressImg, true);
    AppMethodBeat.o(151813);
    return paramString;
  }
  
  public final String a(int paramInt1, int paramInt2, JSONArray paramJSONArray, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151812);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    String str = com.tencent.mm.a.g.w((com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis()).getBytes());
    paramJSONArray = com.tencent.mm.plugin.game.f.c.v(paramJSONArray);
    localObject = new d();
    ((d)localObject).field_taskId = str;
    ((d)localObject).field_createTime = (System.currentTimeMillis() / 1000L);
    ((d)localObject).field_publishSource = paramInt1;
    ((d)localObject).field_mediaType = paramInt2;
    if (!bo.es(paramJSONArray)) {}
    for (paramJSONArray = paramJSONArray.toString();; paramJSONArray = "")
    {
      ((d)localObject).field_localIdList = paramJSONArray;
      ((d)localObject).field_BusinessData = paramString;
      ((d)localObject).field_compressImg = paramBoolean;
      ab.i("MicroMsg.GameHaowanPublishImpl", "addToDB: ".concat(String.valueOf(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().insert((com.tencent.mm.sdk.e.c)localObject))));
      paramJSONArray = a(paramInt2, (d)localObject, paramBoolean, false);
      AppMethodBeat.o(151812);
      return paramJSONArray;
    }
  }
  
  public final JSONArray b(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(151814);
    JSONArray localJSONArray = new JSONArray();
    d locald;
    if (paramBoolean)
    {
      paramJSONArray = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().bFG();
      if (bo.es(paramJSONArray))
      {
        AppMethodBeat.o(151814);
        return null;
      }
      paramJSONArray = paramJSONArray.iterator();
      while (paramJSONArray.hasNext())
      {
        locald = (d)paramJSONArray.next();
        localJSONArray.put(new a(locald.field_taskId, locald.field_publishState, locald.field_localIdList, locald.field_BusinessData).toJson());
      }
      AppMethodBeat.o(151814);
      return localJSONArray;
    }
    paramJSONArray = com.tencent.mm.plugin.game.f.c.v(paramJSONArray);
    if (bo.es(paramJSONArray))
    {
      AppMethodBeat.o(151814);
      return null;
    }
    paramJSONArray = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().Z(paramJSONArray);
    if (bo.es(paramJSONArray))
    {
      AppMethodBeat.o(151814);
      return null;
    }
    paramJSONArray = paramJSONArray.iterator();
    while (paramJSONArray.hasNext())
    {
      locald = (d)paramJSONArray.next();
      localJSONArray.put(new a(locald.field_taskId, locald.field_publishState, locald.field_localIdList, locald.field_BusinessData).toJson());
    }
    AppMethodBeat.o(151814);
    return localJSONArray;
  }
  
  public final void c(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(151815);
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      paramJSONArray = this.nkW.keySet().iterator();
      while (paramJSONArray.hasNext())
      {
        localObject1 = (String)paramJSONArray.next();
        ((g)this.nkW.get(localObject1)).bFK();
      }
      localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV();
      paramJSONArray = String.format("select * from %s", new Object[] { "GameHaowanPublishEdition" });
      ab.i("MicroMsg.GameHaowanPublishStorage", "queryAll, sql : %s", new Object[] { paramJSONArray });
      localObject2 = ((f)localObject1).rawQuery(paramJSONArray, new String[0]);
      if (localObject2 == null) {
        paramJSONArray = null;
      }
      while (bo.es(paramJSONArray))
      {
        paramJSONArray = paramJSONArray.iterator();
        while (paramJSONArray.hasNext())
        {
          localObject2 = com.tencent.mm.plugin.game.f.c.QC(((d)paramJSONArray.next()).field_localIdList);
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().Y((LinkedList)localObject2);
        }
        paramJSONArray = new LinkedList();
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new d();
          ((d)localObject3).convertFrom((Cursor)localObject2);
          paramJSONArray.add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      paramJSONArray = String.format("delete from %s", new Object[] { "GameHaowanPublishEdition" });
      ab.i("MicroMsg.GameHaowanPublishStorage", "deleteAll, sql : %s", new Object[] { paramJSONArray });
      ((f)localObject1).execSQL("GameHaowanPublishEdition", paramJSONArray);
      this.nkW.clear();
      com.tencent.mm.plugin.game.api.a.cp("", 1);
      AppMethodBeat.o(151815);
      return;
    }
    paramJSONArray = com.tencent.mm.plugin.game.f.c.v(paramJSONArray);
    if (bo.es(paramJSONArray))
    {
      AppMethodBeat.o(151815);
      return;
    }
    Object localObject1 = paramJSONArray.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (g)this.nkW.remove(localObject2);
      if (localObject3 != null) {
        ((g)localObject3).bFK();
      }
      com.tencent.mm.plugin.game.api.a.cp((String)localObject2, 1);
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().Y(paramJSONArray);
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e
 * JD-Core Version:    0.7.0.1
 */