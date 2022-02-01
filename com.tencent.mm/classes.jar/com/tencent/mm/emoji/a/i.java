package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.az;
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
  private static i fQu;
  public ArrayList<EmojiGroupInfo> fQA;
  public final Map<String, ArrayList<EmojiInfo>> fQB;
  private HashMap<String, PersonalDesigner> fQC;
  public String fQD;
  private boolean fQv;
  private boolean fQw;
  public boolean fQx;
  private boolean fQy;
  private boolean fQz;
  
  private i()
  {
    AppMethodBeat.i(104442);
    this.fQv = true;
    this.fQw = true;
    this.fQx = true;
    this.fQy = true;
    this.fQz = true;
    this.fQA = new ArrayList();
    this.fQB = Collections.synchronizedMap(new HashMap());
    this.fQC = new HashMap();
    if (ai.cin())
    {
      this.fQD = ((String)g.agR().agA().get(-29414086, z.acS()));
      AppMethodBeat.o(104442);
      return;
    }
    a.eSf();
    a.b localb = a.Gju;
    this.fQD = a.b.cF(-29414086, z.acS());
    AppMethodBeat.o(104442);
  }
  
  public static i ach()
  {
    try
    {
      AppMethodBeat.i(104441);
      if (fQu == null) {
        fQu = new i();
      }
      i locali = fQu;
      AppMethodBeat.o(104441);
      return locali;
    }
    finally {}
  }
  
  public final ArrayList<EmojiInfo> aci()
  {
    AppMethodBeat.i(104444);
    if ((!this.fQB.containsKey("download_custom")) || (this.fQv))
    {
      if (((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL())
      {
        localObject = (ArrayList)az.faZ().GXZ.we(true);
        this.fQB.put("download_custom", localObject);
      }
    }
    else
    {
      this.fQv = false;
      localObject = (ArrayList)this.fQB.get("download_custom");
      AppMethodBeat.o(104444);
      return localObject;
    }
    Object localObject = new UnsupportedOperationException("need get from main process");
    AppMethodBeat.o(104444);
    throw ((Throwable)localObject);
  }
  
  public final ArrayList<EmojiGroupInfo> acj()
  {
    AppMethodBeat.i(104446);
    if (this.fQy) {
      if (!((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL()) {
        break label57;
      }
    }
    ArrayList localArrayList;
    for (this.fQA = az.faZ().GYa.fcR();; this.fQA = localArrayList)
    {
      this.fQy = false;
      localArrayList = this.fQA;
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
            ac.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          }
        }
      }
    }
  }
  
  public final ArrayList<EmojiInfo> dh(boolean paramBoolean)
  {
    AppMethodBeat.i(104443);
    ac.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    if ((!this.fQB.containsKey("custom")) || (this.fQw))
    {
      ac.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", new Object[] { Boolean.valueOf(this.fQw) });
      if (!((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL()) {
        break label283;
      }
      localObject3 = az.faZ().GXZ;
      localObject4 = new ArrayList();
      localObject2 = ((f)localObject3).aW(EmojiGroupInfo.Jsq, false);
      localObject1 = localObject2;
      if (((List)localObject2).size() < 2)
      {
        ((f)localObject3).init(ai.getContext());
        localObject1 = ((f)localObject3).aW(EmojiGroupInfo.Jsq, false);
        com.tencent.mm.plugin.report.service.h.wUl.dB(1062, 0);
      }
      ((List)localObject4).addAll(((f)localObject3).aW(EmojiGroupInfo.Jsr, false));
      ((List)localObject4).addAll((Collection)localObject1);
      localObject1 = (ArrayList)localObject4;
    }
    for (;;)
    {
      this.fQB.put("custom", localObject1);
      this.fQw = false;
      localObject1 = (ArrayList)this.fQB.get("custom");
      if ((localObject1 == null) || (!paramBoolean)) {
        break label393;
      }
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (EmojiInfo)((Iterator)localObject3).next();
        if (EmojiInfo.a.Hav != ((EmojiInfo)localObject4).fFY()) {
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
            ac.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
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
  
  public final ArrayList<EmojiInfo> di(boolean paramBoolean)
  {
    AppMethodBeat.i(104447);
    ac.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", new Object[] { Boolean.valueOf(this.fQz), Boolean.valueOf(paramBoolean) });
    Object localObject2;
    if ((!this.fQB.containsKey("capture")) || (this.fQz))
    {
      if (((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL())
      {
        localObject1 = (ArrayList)az.faZ().GXZ.wf(false);
        ac.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", new Object[] { Boolean.valueOf(this.fQz), Integer.valueOf(((ArrayList)localObject1).size()) });
        this.fQB.put("capture", localObject1);
      }
    }
    else
    {
      this.fQz = false;
      localObject2 = (ArrayList)this.fQB.get("capture");
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
      ac.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji list size: %s.", new Object[] { Integer.valueOf(i) });
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
      ac.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
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
        if (((EmojiInfo)localObject3).fFY() == EmojiInfo.a.Hav) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    ac.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    AppMethodBeat.o(104447);
    return localObject1;
  }
  
  public final void dj(boolean paramBoolean)
  {
    AppMethodBeat.i(104448);
    this.fQw = true;
    ac.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fWe, EmojiUpdateReceiver.fWf);
      ai.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104448);
  }
  
  public final void dk(boolean paramBoolean)
  {
    AppMethodBeat.i(104449);
    this.fQv = true;
    ac.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fWe, EmojiUpdateReceiver.fWg);
      ai.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104449);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(104450);
    this.fQy = true;
    ac.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fWe, EmojiUpdateReceiver.fWi);
      ai.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104450);
  }
  
  public final void dm(boolean paramBoolean)
  {
    AppMethodBeat.i(104451);
    this.fQz = true;
    if (paramBoolean)
    {
      String str = EmojiUpdateReceiver.fWj;
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fWe, str);
      ai.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104451);
  }
  
  public final boolean l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104452);
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.fQB.values().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      }
    } while (!((EmojiInfo)localIterator2.next()).JC().equals(paramEmojiInfo.JC()));
    AppMethodBeat.o(104452);
    return true;
    AppMethodBeat.o(104452);
    return false;
  }
  
  public final ArrayList<EmojiInfo> tf(String paramString)
  {
    AppMethodBeat.i(104445);
    if (this.fQx)
    {
      this.fQB.clear();
      this.fQx = false;
    }
    Object localObject1;
    if (!this.fQB.containsKey(paramString))
    {
      if (!((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL()) {
        break label103;
      }
      localObject1 = (ArrayList)az.faZ().GXZ.XO(paramString);
    }
    for (;;)
    {
      this.fQB.put(paramString, localObject1);
      paramString = (ArrayList)this.fQB.get(paramString);
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
            ac.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localArrayList;
          }
        }
      }
    }
  }
  
  public final PersonalDesigner tg(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(183920);
    if (!this.fQC.containsKey(paramString))
    {
      if (!((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL()) {
        break label125;
      }
      localObject1 = az.faZ().GYd.aPc(paramString);
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
            this.fQC.put(paramString, ((GetEmotionDetailResponse)localObject3).EmotionDetail.PersonalDesigner);
          }
          paramString = (PersonalDesigner)this.fQC.get(paramString);
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
            ac.printErrStackTrace("MicroMsg.EmojiStorageCache", localException, "", new Object[0]);
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