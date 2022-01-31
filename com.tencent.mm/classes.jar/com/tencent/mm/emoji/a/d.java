package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static d ewq;
  private boolean ewr;
  private boolean ews;
  public boolean ewt;
  private boolean ewu;
  private boolean ewv;
  public ArrayList<EmojiGroupInfo> eww;
  public HashMap<String, ArrayList<EmojiInfo>> ewx;
  
  private d()
  {
    AppMethodBeat.i(62231);
    this.ewr = true;
    this.ews = true;
    this.ewt = true;
    this.ewu = true;
    this.ewv = true;
    this.eww = new ArrayList();
    this.ewx = new HashMap();
    AppMethodBeat.o(62231);
  }
  
  public static d Oz()
  {
    try
    {
      AppMethodBeat.i(62230);
      if (ewq == null) {
        ewq = new d();
      }
      d locald = ewq;
      AppMethodBeat.o(62230);
      return locald;
    }
    finally {}
  }
  
  public final ArrayList<EmojiInfo> OA()
  {
    AppMethodBeat.i(62233);
    if ((!this.ewx.containsKey("download_custom")) || (this.ewr))
    {
      if (((h)g.RI().Rj()).SD())
      {
        localObject = (ArrayList)at.dxt().yNn.pU(true);
        this.ewx.put("download_custom", localObject);
      }
    }
    else
    {
      this.ewr = false;
      localObject = (ArrayList)this.ewx.get("download_custom");
      AppMethodBeat.o(62233);
      return localObject;
    }
    Object localObject = new UnsupportedOperationException("need get from main process");
    AppMethodBeat.o(62233);
    throw ((Throwable)localObject);
  }
  
  public final ArrayList<EmojiGroupInfo> OB()
  {
    AppMethodBeat.i(62235);
    if (this.ewu) {
      if (!((h)g.RI().Rj()).SD()) {
        break label57;
      }
    }
    ArrayList localArrayList;
    for (this.eww = at.dxt().yNo.dzb();; this.eww = localArrayList)
    {
      this.ewu = false;
      localArrayList = this.eww;
      AppMethodBeat.o(62235);
      return localArrayList;
      label57:
      localArrayList = new ArrayList();
      Object localObject = com.tencent.mm.ca.a.call(com.tencent.mm.ca.a.getUri(), "getEmojiGroupInfoList", null, null);
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(EmojiGroupInfo.class.getClassLoader());
        if (((Bundle)localObject).containsKey("data"))
        {
          localObject = ((Bundle)localObject).getParcelableArrayList("data");
          if (localObject != null)
          {
            localArrayList.addAll((Collection)localObject);
            ab.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          }
        }
      }
    }
  }
  
  public final ArrayList<EmojiInfo> ch(boolean paramBoolean)
  {
    AppMethodBeat.i(62232);
    ab.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject1;
    ArrayList localArrayList;
    if ((!this.ewx.containsKey("custom")) || (this.ews))
    {
      ab.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", new Object[] { Boolean.valueOf(this.ews) });
      if (!((h)g.RI().Rj()).SD()) {
        break label220;
      }
      localObject1 = at.dxt().yNn;
      localArrayList = new ArrayList();
      localArrayList.addAll(((com.tencent.mm.storage.emotion.d)localObject1).NE(EmojiGroupInfo.yPf));
      localArrayList.addAll(((com.tencent.mm.storage.emotion.d)localObject1).NE(EmojiGroupInfo.yPe));
      localObject1 = (ArrayList)localArrayList;
    }
    for (;;)
    {
      this.ewx.put("custom", localObject1);
      this.ews = false;
      localObject1 = (ArrayList)this.ewx.get("custom");
      if ((localObject1 == null) || (!paramBoolean)) {
        break label327;
      }
      localArrayList = new ArrayList();
      Object localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject2).next();
        if (EmojiInfo.a.yPB != localEmojiInfo.dzx()) {
          localArrayList.add(localEmojiInfo);
        }
      }
      label220:
      localArrayList = new ArrayList();
      localObject2 = com.tencent.mm.ca.a.call(com.tencent.mm.ca.a.getUri(), "getAllCustomEmoji", null, null);
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        ((Bundle)localObject2).setClassLoader(EmojiInfo.class.getClassLoader());
        localObject1 = localArrayList;
        if (((Bundle)localObject2).containsKey("data"))
        {
          localObject2 = ((Bundle)localObject2).getParcelableArrayList("data");
          localObject1 = localArrayList;
          if (localObject2 != null)
          {
            localArrayList.addAll((Collection)localObject2);
            ab.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localArrayList;
          }
        }
      }
    }
    ((ArrayList)localObject1).removeAll(localArrayList);
    label327:
    AppMethodBeat.o(62232);
    return localObject1;
  }
  
  public final ArrayList<EmojiInfo> ci(boolean paramBoolean)
  {
    AppMethodBeat.i(62236);
    ab.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", new Object[] { Boolean.valueOf(this.ewv), Boolean.valueOf(paramBoolean) });
    Object localObject2;
    Object localObject3;
    if ((!this.ewx.containsKey("capture")) || (this.ewv))
    {
      if (((h)g.RI().Rj()).SD())
      {
        localObject2 = at.dxt().yNn;
        localObject1 = new ArrayList();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("select * from EmojiInfo where groupId = \"capture\"");
        ((StringBuilder)localObject3).append(" and state != ").append(EmojiInfo.yPv);
        ((StringBuilder)localObject3).append(" order by idx asc ");
        localObject2 = ((com.tencent.mm.storage.emotion.d)localObject2).db.rawQuery(((StringBuilder)localObject3).toString(), null);
        if (localObject2 != null)
        {
          if (((Cursor)localObject2).moveToFirst()) {
            do
            {
              localObject3 = new EmojiInfo();
              ((EmojiInfo)localObject3).convertFrom((Cursor)localObject2);
              ((List)localObject1).add(localObject3);
            } while (((Cursor)localObject2).moveToNext());
          }
          ((Cursor)localObject2).close();
        }
        localObject1 = (ArrayList)localObject1;
        ab.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", new Object[] { Boolean.valueOf(this.ewv), Integer.valueOf(((ArrayList)localObject1).size()) });
        this.ewx.put("capture", localObject1);
      }
    }
    else
    {
      this.ewv = false;
      localObject2 = (ArrayList)this.ewx.get("capture");
      if (!paramBoolean) {
        break label431;
      }
      if (localObject2 != null) {
        break label422;
      }
    }
    label422:
    for (int i = 0;; i = ((ArrayList)localObject2).size())
    {
      ab.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji list size: %s.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(62236);
      return localObject2;
      localObject2 = new ArrayList();
      localObject3 = com.tencent.mm.ca.a.call(com.tencent.mm.ca.a.getUri(), "getCaptureEmoji", null, null);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      ((Bundle)localObject3).setClassLoader(EmojiInfo.class.getClassLoader());
      localObject1 = localObject2;
      if (!((Bundle)localObject3).containsKey("key_data")) {
        break;
      }
      localObject3 = ((Bundle)localObject3).getParcelableArrayList("key_data");
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      ((ArrayList)localObject2).addAll((Collection)localObject3);
      ab.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      localObject1 = localObject2;
      break;
    }
    label431:
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EmojiInfo)((Iterator)localObject2).next();
        if (((EmojiInfo)localObject3).dzx() == EmojiInfo.a.yPB) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    ab.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    AppMethodBeat.o(62236);
    return localObject1;
  }
  
  public final void cj(boolean paramBoolean)
  {
    AppMethodBeat.i(62237);
    this.ews = true;
    ab.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.exU, EmojiUpdateReceiver.exV);
      ah.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(62237);
  }
  
  public final void ck(boolean paramBoolean)
  {
    AppMethodBeat.i(62238);
    this.ewr = true;
    ab.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.exU, EmojiUpdateReceiver.exW);
      ah.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(62238);
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(62239);
    this.ewu = true;
    ab.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.exU, EmojiUpdateReceiver.exY);
      ah.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(62239);
  }
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(62240);
    this.ewv = true;
    if (paramBoolean)
    {
      String str = EmojiUpdateReceiver.exZ;
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.exU, str);
      ah.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(62240);
  }
  
  public final ArrayList<EmojiInfo> lL(String paramString)
  {
    AppMethodBeat.i(62234);
    if (this.ewt)
    {
      this.ewx.clear();
      this.ewt = false;
    }
    Object localObject1;
    if (!this.ewx.containsKey(paramString))
    {
      if (!((h)g.RI().Rj()).SD()) {
        break label95;
      }
      localObject1 = (ArrayList)at.dxt().yNn.Kw(paramString);
    }
    for (;;)
    {
      this.ewx.put(paramString, localObject1);
      paramString = (ArrayList)this.ewx.get(paramString);
      AppMethodBeat.o(62234);
      return paramString;
      label95:
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = com.tencent.mm.ca.a.call(com.tencent.mm.ca.a.getUri(), "getEmojiListByGroupId", String.valueOf(paramString), null);
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        ((Bundle)localObject2).setClassLoader(EmojiInfo.class.getClassLoader());
        localObject1 = localArrayList;
        if (((Bundle)localObject2).containsKey("data"))
        {
          localObject2 = ((Bundle)localObject2).getParcelableArrayList("data");
          localObject1 = localArrayList;
          if (localObject2 != null)
          {
            localArrayList.addAll((Collection)localObject2);
            ab.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localArrayList;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */