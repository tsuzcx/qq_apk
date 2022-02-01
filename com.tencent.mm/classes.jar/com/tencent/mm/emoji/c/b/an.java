package com.tencent.mm.emoji.c.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "empty", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "hasNew", "getHasNew", "()Z", "setHasNew", "(Z)V", "isDownloaded", "reportCount", "", "getDataCount", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends a
{
  private final List<EmojiInfo> mip;
  private int miq;
  public boolean mjf;
  
  public an(EmojiGroupInfo paramEmojiGroupInfo, boolean paramBoolean)
  {
    super(paramEmojiGroupInfo);
    AppMethodBeat.i(242708);
    if (!aVB())
    {
      this.mip = ((List)ab.aivy);
      this.mio.add(new v(paramEmojiGroupInfo));
      AppMethodBeat.o(242708);
      return;
    }
    if (paramBoolean)
    {
      this.mip = ((List)ab.aivy);
      this.miq = this.mip.size();
      paramEmojiGroupInfo = ((Iterable)this.mip).iterator();
      while (paramEmojiGroupInfo.hasNext())
      {
        localObject1 = (EmojiInfo)paramEmojiGroupInfo.next();
        this.mio.add(new h((EmojiInfo)localObject1, 2));
      }
    }
    l locall = l.aUF();
    String str = paramEmojiGroupInfo.field_productID;
    if (locall.mhO)
    {
      locall.mhT.evictAll();
      locall.mhO = false;
    }
    Object localObject2 = (ArrayList)locall.mhT.get(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
      {
        localObject1 = (ArrayList)bl.jba().adju.aoh(str);
        label220:
        locall.mhT.put(str, localObject1);
      }
    }
    else {
      if (localObject1 != null) {
        break label436;
      }
    }
    label436:
    for (localObject1 = (List)ab.aivy;; localObject1 = (List)localObject1)
    {
      this.mip = ((List)localObject1);
      paramEmojiGroupInfo = l.aUF().Ep(paramEmojiGroupInfo.field_productID);
      if (paramEmojiGroupInfo != null)
      {
        aVd().mje = paramEmojiGroupInfo;
        localObject1 = aVd();
        localObject2 = bi.a.adiZ;
        ((w)localObject1).mjf = bi.a.ayV(paramEmojiGroupInfo.ZtX).jaZ();
        this.mjf = aVd().mjf;
      }
      this.mio.add(aVd());
      break;
      localObject2 = new ArrayList();
      Object localObject3 = com.tencent.mm.cc.a.a(com.tencent.mm.cc.a.getUri(), "getEmojiListByGroupId", String.valueOf(str), null);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label220;
      }
      ((Bundle)localObject3).setClassLoader(EmojiInfo.class.getClassLoader());
      localObject1 = localObject2;
      if (!((Bundle)localObject3).containsKey("data")) {
        break label220;
      }
      localObject3 = ((Bundle)localObject3).getParcelableArrayList("data");
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label220;
      }
      ((ArrayList)localObject2).addAll((Collection)localObject3);
      Log.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      localObject1 = localObject2;
      break label220;
    }
    AppMethodBeat.o(242708);
  }
  
  public final boolean aVB()
  {
    AppMethodBeat.i(242709);
    if ((aVd().mgd.field_sync == 2) || (Util.isEqual(aVd().mgd.field_productID, String.valueOf(EmojiGroupInfo.aklD))))
    {
      AppMethodBeat.o(242709);
      return true;
    }
    AppMethodBeat.o(242709);
    return false;
  }
  
  public final int getDataCount()
  {
    return this.miq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.an
 * JD-Core Version:    0.7.0.1
 */