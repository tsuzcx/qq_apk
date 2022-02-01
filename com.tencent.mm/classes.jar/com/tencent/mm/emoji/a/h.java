package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static h fMI;
  private boolean fMJ;
  private boolean fMK;
  public boolean fML;
  private boolean fMM;
  private boolean fMN;
  public ArrayList<EmojiGroupInfo> fMO;
  public HashMap<String, ArrayList<EmojiInfo>> fMP;
  private HashMap<String, PersonalDesigner> fMQ;
  public String fMR;
  
  private h()
  {
    AppMethodBeat.i(104442);
    this.fMJ = true;
    this.fMK = true;
    this.fML = true;
    this.fMM = true;
    this.fMN = true;
    this.fMO = new ArrayList();
    this.fMP = new HashMap();
    this.fMQ = new HashMap();
    if (aj.cbe())
    {
      this.fMR = ((String)g.afB().afk().get(-29414086, z.abS()));
      AppMethodBeat.o(104442);
      return;
    }
    a.eCL();
    a.b localb = a.EMi;
    this.fMR = a.b.cC(-29414086, z.abS());
    AppMethodBeat.o(104442);
  }
  
  public static h abj()
  {
    try
    {
      AppMethodBeat.i(104441);
      if (fMI == null) {
        fMI = new h();
      }
      h localh = fMI;
      AppMethodBeat.o(104441);
      return localh;
    }
    finally {}
  }
  
  public final ArrayList<EmojiInfo> abk()
  {
    AppMethodBeat.i(104444);
    if ((!this.fMP.containsKey("download_custom")) || (this.fMJ))
    {
      if (((com.tencent.mm.kernel.b.h)g.afy().aeZ()).agu())
      {
        localObject = (ArrayList)aw.eLx().FyY.vc(true);
        this.fMP.put("download_custom", localObject);
      }
    }
    else
    {
      this.fMJ = false;
      localObject = (ArrayList)this.fMP.get("download_custom");
      AppMethodBeat.o(104444);
      return localObject;
    }
    Object localObject = new UnsupportedOperationException("need get from main process");
    AppMethodBeat.o(104444);
    throw ((Throwable)localObject);
  }
  
  public final ArrayList<EmojiGroupInfo> abl()
  {
    AppMethodBeat.i(104446);
    if (this.fMM) {
      if (!((com.tencent.mm.kernel.b.h)g.afy().aeZ()).agu()) {
        break label57;
      }
    }
    ArrayList localArrayList;
    for (this.fMO = aw.eLx().FyZ.eNn();; this.fMO = localArrayList)
    {
      this.fMM = false;
      localArrayList = this.fMO;
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
            ad.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          }
        }
      }
    }
  }
  
  public final ArrayList<EmojiInfo> di(boolean paramBoolean)
  {
    AppMethodBeat.i(104443);
    ad.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    if ((!this.fMP.containsKey("custom")) || (this.fMK))
    {
      ad.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", new Object[] { Boolean.valueOf(this.fMK) });
      if (!((com.tencent.mm.kernel.b.h)g.afy().aeZ()).agu()) {
        break label276;
      }
      localObject3 = aw.eLx().FyY;
      localObject4 = new ArrayList();
      localObject2 = ((f)localObject3).aS(EmojiGroupInfo.LBO, false);
      localObject1 = localObject2;
      if (((List)localObject2).size() < 2)
      {
        ((f)localObject3).init(aj.getContext());
        localObject1 = ((f)localObject3).aS(EmojiGroupInfo.LBO, false);
        com.tencent.mm.plugin.report.service.h.vKh.dB(1062, 0);
      }
      ((List)localObject4).addAll(((f)localObject3).aS(EmojiGroupInfo.LBP, false));
      ((List)localObject4).addAll((Collection)localObject1);
      localObject1 = (ArrayList)localObject4;
    }
    for (;;)
    {
      this.fMP.put("custom", localObject1);
      this.fMK = false;
      localObject1 = (ArrayList)this.fMP.get("custom");
      if ((localObject1 == null) || (!paramBoolean)) {
        break label386;
      }
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (EmojiInfo)((Iterator)localObject3).next();
        if (EmojiInfo.a.FBv != ((EmojiInfo)localObject4).fZV()) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
      label276:
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
            ad.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
            localObject1 = localObject2;
          }
        }
      }
    }
    ((ArrayList)localObject1).removeAll((Collection)localObject2);
    label386:
    AppMethodBeat.o(104443);
    return localObject1;
  }
  
  public final ArrayList<EmojiInfo> dj(boolean paramBoolean)
  {
    AppMethodBeat.i(104447);
    ad.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", new Object[] { Boolean.valueOf(this.fMN), Boolean.valueOf(paramBoolean) });
    Object localObject2;
    if ((!this.fMP.containsKey("capture")) || (this.fMN))
    {
      if (((com.tencent.mm.kernel.b.h)g.afy().aeZ()).agu())
      {
        localObject1 = (ArrayList)aw.eLx().FyY.vd(false);
        ad.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", new Object[] { Boolean.valueOf(this.fMN), Integer.valueOf(((ArrayList)localObject1).size()) });
        this.fMP.put("capture", localObject1);
      }
    }
    else
    {
      this.fMN = false;
      localObject2 = (ArrayList)this.fMP.get("capture");
      if (!paramBoolean) {
        break label308;
      }
      if (localObject2 != null) {
        break label299;
      }
    }
    Object localObject3;
    label299:
    for (int i = 0;; i = ((ArrayList)localObject2).size())
    {
      ad.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji list size: %s.", new Object[] { Integer.valueOf(i) });
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
      ad.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      localObject1 = localObject2;
      break;
    }
    label308:
    Object localObject1 = new ArrayList();
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EmojiInfo)((Iterator)localObject2).next();
        if (((EmojiInfo)localObject3).fZV() == EmojiInfo.a.FBv) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    ad.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    AppMethodBeat.o(104447);
    return localObject1;
  }
  
  public final void dk(boolean paramBoolean)
  {
    AppMethodBeat.i(104448);
    this.fMK = true;
    ad.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fSj, EmojiUpdateReceiver.fSk);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104448);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(104449);
    this.fMJ = true;
    ad.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fSj, EmojiUpdateReceiver.fSl);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104449);
  }
  
  public final void dm(boolean paramBoolean)
  {
    AppMethodBeat.i(104450);
    this.fMM = true;
    ad.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fSj, EmojiUpdateReceiver.fSn);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104450);
  }
  
  public final void dn(boolean paramBoolean)
  {
    AppMethodBeat.i(104451);
    this.fMN = true;
    if (paramBoolean)
    {
      String str = EmojiUpdateReceiver.fSo;
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.fSj, str);
      aj.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104451);
  }
  
  public final boolean l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104452);
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = this.fMP.values().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      }
    } while (!((EmojiInfo)localIterator2.next()).JS().equals(paramEmojiInfo.JS()));
    AppMethodBeat.o(104452);
    return true;
    AppMethodBeat.o(104452);
    return false;
  }
  
  public final ArrayList<EmojiInfo> pU(String paramString)
  {
    AppMethodBeat.i(104445);
    if (this.fML)
    {
      this.fMP.clear();
      this.fML = false;
    }
    Object localObject1;
    if (!this.fMP.containsKey(paramString))
    {
      if (!((com.tencent.mm.kernel.b.h)g.afy().aeZ()).agu()) {
        break label95;
      }
      localObject1 = (ArrayList)aw.eLx().FyY.TC(paramString);
    }
    for (;;)
    {
      this.fMP.put(paramString, localObject1);
      paramString = (ArrayList)this.fMP.get(paramString);
      AppMethodBeat.o(104445);
      return paramString;
      label95:
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
            ad.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localArrayList;
          }
        }
      }
    }
  }
  
  public final PersonalDesigner pV(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(183920);
    if (!this.fMQ.containsKey(paramString))
    {
      if (!((com.tencent.mm.kernel.b.h)g.afy().aeZ()).agu()) {
        break label125;
      }
      localObject1 = aw.eLx().Fzc.aJE(paramString);
      if (localObject1 == null) {
        break label175;
      }
    }
    label125:
    Object localObject2;
    label175:
    for (localObject1 = ((k)localObject1).field_content;; localObject2 = null) {
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
            this.fMQ.put(paramString, ((GetEmotionDetailResponse)localObject3).EmotionDetail.PersonalDesigner);
          }
          paramString = (PersonalDesigner)this.fMQ.get(paramString);
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
            ad.printErrStackTrace("MicroMsg.EmojiStorageCache", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */