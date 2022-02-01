package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
{
  private static i gjU;
  private boolean gjV;
  private boolean gjW;
  public boolean gjX;
  private boolean gjY;
  private boolean gjZ;
  public ArrayList<EmojiGroupInfo> gka;
  public final Map<String, ArrayList<EmojiInfo>> gkb;
  private HashMap<String, PersonalDesigner> gkc;
  public String gkd;
  
  private i()
  {
    AppMethodBeat.i(104442);
    this.gjV = true;
    this.gjW = true;
    this.gjX = true;
    this.gjY = true;
    this.gjZ = true;
    this.gka = new ArrayList();
    this.gkb = Collections.synchronizedMap(new HashMap());
    this.gkc = new HashMap();
    if (aj.cmR())
    {
      this.gkd = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(-29414086, com.tencent.mm.emoji.a.a.ad.afz()));
      AppMethodBeat.o(104442);
      return;
    }
    a.fhy();
    a.b localb = a.HVh;
    this.gkd = a.b.cM(-29414086, com.tencent.mm.emoji.a.a.ad.afz());
    AppMethodBeat.o(104442);
  }
  
  public static i aeL()
  {
    try
    {
      AppMethodBeat.i(104441);
      if (gjU == null) {
        gjU = new i();
      }
      i locali = gjU;
      AppMethodBeat.o(104441);
      return locali;
    }
    finally {}
  }
  
  public final ArrayList<EmojiInfo> aeM()
  {
    AppMethodBeat.i(104444);
    if ((!this.gkb.containsKey("download_custom")) || (this.gjV))
    {
      if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
      {
        localObject = (ArrayList)bd.frc().ILn.wQ(true);
        this.gkb.put("download_custom", localObject);
      }
    }
    else
    {
      this.gjV = false;
      localObject = (ArrayList)this.gkb.get("download_custom");
      AppMethodBeat.o(104444);
      return localObject;
    }
    Object localObject = new UnsupportedOperationException("need get from main process");
    AppMethodBeat.o(104444);
    throw ((Throwable)localObject);
  }
  
  public final ArrayList<EmojiGroupInfo> aeN()
  {
    AppMethodBeat.i(104446);
    if (this.gjY) {
      if (!((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        break label57;
      }
    }
    ArrayList localArrayList;
    for (this.gka = bd.frc().ILo.fsY();; this.gka = localArrayList)
    {
      this.gjY = false;
      localArrayList = this.gka;
      AppMethodBeat.o(104446);
      return localArrayList;
      label57:
      localArrayList = new ArrayList();
      Object localObject = a.call(a.getUri(), "getEmojiGroupInfoList", null, null);
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(EmojiGroupInfo.class.getClassLoader());
        if (((Bundle)localObject).containsKey("data"))
        {
          localObject = ((Bundle)localObject).getParcelableArrayList("data");
          if (localObject != null)
          {
            localArrayList.addAll((Collection)localObject);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          }
        }
      }
    }
  }
  
  public final ArrayList<EmojiInfo> dj(boolean paramBoolean)
  {
    AppMethodBeat.i(104443);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    if ((!this.gkb.containsKey("custom")) || (this.gjW))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", new Object[] { Boolean.valueOf(this.gjW) });
      if (!((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        break label283;
      }
      localObject3 = bd.frc().ILn;
      localObject4 = new ArrayList();
      localObject2 = ((f)localObject3).bd(EmojiGroupInfo.OeL, false);
      localObject1 = localObject2;
      if (((List)localObject2).size() < 2)
      {
        ((f)localObject3).init(aj.getContext());
        localObject1 = ((f)localObject3).bd(EmojiGroupInfo.OeL, false);
        com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 0);
      }
      ((List)localObject4).addAll(((f)localObject3).bd(EmojiGroupInfo.OeM, false));
      ((List)localObject4).addAll((Collection)localObject1);
      localObject1 = (ArrayList)localObject4;
    }
    for (;;)
    {
      this.gkb.put("custom", localObject1);
      this.gjW = false;
      localObject1 = (ArrayList)this.gkb.get("custom");
      if ((localObject1 == null) || (!paramBoolean)) {
        break label393;
      }
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (EmojiInfo)((Iterator)localObject3).next();
        if (EmojiInfo.a.INK != ((EmojiInfo)localObject4).gzL()) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
      label283:
      localObject2 = new ArrayList();
      localObject3 = a.call(a.getUri(), "getAllCustomEmoji", null, null);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        ((Bundle)localObject3).setClassLoader(EmojiInfo.class.getClassLoader());
        localObject1 = localObject2;
        if (((Bundle)localObject3).containsKey("data"))
        {
          localObject3 = ((Bundle)localObject3).getParcelableArrayList("data");
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            ((ArrayList)localObject2).addAll((Collection)localObject3);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
            localObject1 = localObject2;
          }
        }
      }
    }
    ((ArrayList)localObject1).removeAll((Collection)localObject2);
    label393:
    AppMethodBeat.o(104443);
    return localObject1;
  }
  
  public final ArrayList<EmojiInfo> dk(boolean paramBoolean)
  {
    AppMethodBeat.i(104447);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", new Object[] { Boolean.valueOf(this.gjZ), Boolean.valueOf(paramBoolean) });
    Object localObject2;
    if ((!this.gkb.containsKey("capture")) || (this.gjZ))
    {
      if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
      {
        localObject1 = (ArrayList)bd.frc().ILn.wR(false);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", new Object[] { Boolean.valueOf(this.gjZ), Integer.valueOf(((ArrayList)localObject1).size()) });
        this.gkb.put("capture", localObject1);
      }
    }
    else
    {
      this.gjZ = false;
      localObject2 = (ArrayList)this.gkb.get("capture");
      if (!paramBoolean) {
        break label314;
      }
      if (localObject2 != null) {
        break label305;
      }
    }
    Object localObject3;
    label305:
    for (int i = 0;; i = ((ArrayList)localObject2).size())
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji list size: %s.", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(104447);
      return localObject2;
      localObject2 = new ArrayList();
      localObject3 = a.call(a.getUri(), "getCaptureEmoji", null, null);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      localObject1 = localObject2;
      break;
    }
    label314:
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EmojiInfo)((Iterator)localObject2).next();
        if (((EmojiInfo)localObject3).gzL() == EmojiInfo.a.INK) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    AppMethodBeat.o(104447);
    return localObject1;
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(104448);
    this.gjW = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gpH, EmojiUpdateReceiver.gpI);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104448);
  }
  
  public final void dm(boolean paramBoolean)
  {
    AppMethodBeat.i(104449);
    this.gjV = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gpH, EmojiUpdateReceiver.gpJ);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104449);
  }
  
  public final void dn(boolean paramBoolean)
  {
    AppMethodBeat.i(104450);
    this.gjY = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gpH, EmojiUpdateReceiver.gpL);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104450);
  }
  
  public final void jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(104451);
    this.gjZ = true;
    if (paramBoolean)
    {
      String str = EmojiUpdateReceiver.gpM;
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gpH, str);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104451);
  }
  
  public final boolean l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104452);
    synchronized (this.gkb)
    {
      Iterator localIterator2;
      do
      {
        Iterator localIterator1 = this.gkb.values().iterator();
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((ArrayList)localIterator1.next()).iterator();
        }
      } while (!((EmojiInfo)localIterator2.next()).Lb().equals(paramEmojiInfo.Lb()));
      AppMethodBeat.o(104452);
      return true;
      AppMethodBeat.o(104452);
      return false;
    }
  }
  
  public final ArrayList<EmojiInfo> vU(String paramString)
  {
    AppMethodBeat.i(104445);
    if (this.gjX)
    {
      this.gkb.clear();
      this.gjX = false;
    }
    Object localObject1;
    if (!this.gkb.containsKey(paramString))
    {
      if (!((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        break label103;
      }
      localObject1 = (ArrayList)bd.frc().ILn.abu(paramString);
    }
    for (;;)
    {
      this.gkb.put(paramString, localObject1);
      paramString = (ArrayList)this.gkb.get(paramString);
      AppMethodBeat.o(104445);
      return paramString;
      label103:
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = a.call(a.getUri(), "getEmojiListByGroupId", String.valueOf(paramString), null);
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localArrayList;
          }
        }
      }
    }
  }
  
  public final PersonalDesigner vV(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(183920);
    if (!this.gkc.containsKey(paramString))
    {
      if (!((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        break label125;
      }
      localObject1 = bd.frc().ILr.aUT(paramString);
      if (localObject1 == null) {
        break label175;
      }
    }
    label125:
    Object localObject2;
    label175:
    for (localObject1 = ((l)localObject1).field_content;; localObject2 = null) {
      for (;;)
      {
        Object localObject3;
        if (localObject1 != null) {
          localObject3 = new GetEmotionDetailResponse();
        }
        try
        {
          ((GetEmotionDetailResponse)localObject3).parseFrom((byte[])localObject1);
          if ((((GetEmotionDetailResponse)localObject3).EmotionDetail != null) && (((GetEmotionDetailResponse)localObject3).EmotionDetail.PersonalDesigner != null)) {
            this.gkc.put(paramString, ((GetEmotionDetailResponse)localObject3).EmotionDetail.PersonalDesigner);
          }
          paramString = (PersonalDesigner)this.gkc.get(paramString);
          AppMethodBeat.o(183920);
          return paramString;
          localObject3 = a.call(a.getUri(), "getDesignerInfo", paramString, null);
          if (((Bundle)localObject3).containsKey("buffer")) {
            localObject1 = ((Bundle)localObject3).getByteArray("buffer");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.EmojiStorageCache", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */