package com.tencent.mm.emoji.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.a.b.ad;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
{
  private static i gmn;
  private boolean gmo;
  private boolean gmp;
  public boolean gmq;
  private boolean gmr;
  private boolean gms;
  public ArrayList<EmojiGroupInfo> gmt;
  public final Map<String, ArrayList<EmojiInfo>> gmu;
  private HashMap<String, PersonalDesigner> gmv;
  private agu gmw;
  public String gmx;
  
  private i()
  {
    AppMethodBeat.i(104442);
    this.gmo = true;
    this.gmp = true;
    this.gmq = true;
    this.gmr = true;
    this.gms = true;
    this.gmt = new ArrayList();
    this.gmu = Collections.synchronizedMap(new HashMap());
    this.gmv = new HashMap();
    this.gmw = new agu();
    if (ak.coh())
    {
      this.gmx = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(-29414086, ad.afN()));
      byte[] arrayOfByte = be.fvc().JfX.get("cache_type_user_data");
      if (!bu.cF(arrayOfByte)) {
        try
        {
          this.gmw.parseFrom(arrayOfByte);
          AppMethodBeat.o(104442);
          return;
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.EmojiStorageCache", localIOException, "parse user data error", new Object[0]);
        }
      }
      AppMethodBeat.o(104442);
      return;
    }
    a.flq();
    a.b localb = a.Ipp;
    this.gmx = a.b.cM(-29414086, ad.afN());
    AppMethodBeat.o(104442);
  }
  
  public static i aeX()
  {
    try
    {
      AppMethodBeat.i(104441);
      if (gmn == null) {
        gmn = new i();
      }
      i locali = gmn;
      AppMethodBeat.o(104441);
      return locali;
    }
    finally {}
  }
  
  public final agu aeY()
  {
    return this.gmw;
  }
  
  public final void aeZ()
  {
    AppMethodBeat.i(188498);
    try
    {
      byte[] arrayOfByte = this.gmw.toByteArray();
      be.fvc().JfX.l("cache_type_user_data", arrayOfByte);
      AppMethodBeat.o(188498);
      return;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.EmojiStorageCache", localIOException, "save user data error", new Object[0]);
      AppMethodBeat.o(188498);
    }
  }
  
  public final ArrayList<EmojiInfo> afa()
  {
    AppMethodBeat.i(104444);
    if ((!this.gmu.containsKey("download_custom")) || (this.gmo))
    {
      if (((h)com.tencent.mm.kernel.g.ajO().ajq()).akL())
      {
        localObject = be.fvc().JfU;
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(((f)localObject).bj(EmojiGroupInfo.OzT, true));
        localObject = (ArrayList)localArrayList;
        this.gmu.put("download_custom", localObject);
      }
    }
    else
    {
      this.gmo = false;
      localObject = (ArrayList)this.gmu.get("download_custom");
      AppMethodBeat.o(104444);
      return localObject;
    }
    Object localObject = new UnsupportedOperationException("need get from main process");
    AppMethodBeat.o(104444);
    throw ((Throwable)localObject);
  }
  
  public final ArrayList<EmojiGroupInfo> afb()
  {
    AppMethodBeat.i(104446);
    if (this.gmr) {
      if (!((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
        break label57;
      }
    }
    ArrayList localArrayList;
    for (this.gmt = be.fvc().JfV.fwZ();; this.gmt = localArrayList)
    {
      this.gmr = false;
      localArrayList = this.gmt;
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
            ae.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
          }
        }
      }
    }
  }
  
  public final ArrayList<EmojiInfo> dj(boolean paramBoolean)
  {
    AppMethodBeat.i(104443);
    ae.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    if ((!this.gmu.containsKey("custom")) || (this.gmp))
    {
      ae.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", new Object[] { Boolean.valueOf(this.gmp) });
      if (!((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
        break label284;
      }
      localObject3 = be.fvc().JfU;
      localObject4 = new ArrayList();
      localObject2 = ((f)localObject3).bj(EmojiGroupInfo.OzS, false);
      localObject1 = localObject2;
      if (((List)localObject2).size() < 2)
      {
        ((f)localObject3).init(ak.getContext());
        localObject1 = ((f)localObject3).bj(EmojiGroupInfo.OzS, false);
        com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 0);
      }
      ((List)localObject4).addAll(((f)localObject3).bj(EmojiGroupInfo.OzT, false));
      ((List)localObject4).addAll((Collection)localObject1);
      localObject1 = (ArrayList)localObject4;
    }
    for (;;)
    {
      this.gmu.put("custom", localObject1);
      this.gmp = false;
      localObject1 = (ArrayList)this.gmu.get("custom");
      if ((localObject1 == null) || (!paramBoolean)) {
        break label396;
      }
      localObject2 = new ArrayList();
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (EmojiInfo)((Iterator)localObject3).next();
        if (EmojiInfo.a.Jir != ((EmojiInfo)localObject4).fxx()) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
      label284:
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
            ae.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
            localObject1 = localObject2;
          }
        }
      }
    }
    ((ArrayList)localObject1).removeAll((Collection)localObject2);
    label396:
    AppMethodBeat.o(104443);
    return localObject1;
  }
  
  public final ArrayList<EmojiInfo> dk(boolean paramBoolean)
  {
    AppMethodBeat.i(104447);
    ae.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", new Object[] { Boolean.valueOf(this.gms), Boolean.valueOf(paramBoolean) });
    Object localObject2;
    if ((!this.gmu.containsKey("capture")) || (this.gms))
    {
      if (((h)com.tencent.mm.kernel.g.ajO().ajq()).akL())
      {
        localObject1 = (ArrayList)be.fvc().JfU.wZ(false);
        ae.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", new Object[] { Boolean.valueOf(this.gms), Integer.valueOf(((ArrayList)localObject1).size()) });
        this.gmu.put("capture", localObject1);
      }
    }
    else
    {
      this.gms = false;
      localObject2 = (ArrayList)this.gmu.get("capture");
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
      ae.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji list size: %s.", new Object[] { Integer.valueOf(i) });
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
      ae.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject3).size()) });
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
        if (((EmojiInfo)localObject3).fxx() == EmojiInfo.a.Jir) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    ae.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    AppMethodBeat.o(104447);
    return localObject1;
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(104448);
    this.gmp = true;
    ae.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gsc, EmojiUpdateReceiver.gsd);
      ak.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104448);
  }
  
  public final void dm(boolean paramBoolean)
  {
    AppMethodBeat.i(104449);
    this.gmo = true;
    ae.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gsc, EmojiUpdateReceiver.gse);
      ak.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104449);
  }
  
  public final void dn(boolean paramBoolean)
  {
    AppMethodBeat.i(104450);
    this.gmr = true;
    ae.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gsc, EmojiUpdateReceiver.gsg);
      ak.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104450);
  }
  
  public final void jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(104451);
    this.gms = true;
    if (paramBoolean)
    {
      String str = EmojiUpdateReceiver.gsh;
      Intent localIntent = new Intent();
      localIntent.setAction(EmojiUpdateReceiver.ACTION);
      localIntent.putExtra(EmojiUpdateReceiver.gsc, str);
      ak.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(104451);
  }
  
  public final boolean l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104452);
    synchronized (this.gmu)
    {
      Iterator localIterator2;
      do
      {
        Iterator localIterator1 = this.gmu.values().iterator();
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((ArrayList)localIterator1.next()).iterator();
        }
      } while (!((EmojiInfo)localIterator2.next()).Lj().equals(paramEmojiInfo.Lj()));
      AppMethodBeat.o(104452);
      return true;
      AppMethodBeat.o(104452);
      return false;
    }
  }
  
  public final ArrayList<EmojiInfo> wB(String paramString)
  {
    AppMethodBeat.i(104445);
    if (this.gmq)
    {
      this.gmu.clear();
      this.gmq = false;
    }
    Object localObject1;
    if (!this.gmu.containsKey(paramString))
    {
      if (!((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
        break label103;
      }
      localObject1 = (ArrayList)be.fvc().JfU.acl(paramString);
    }
    for (;;)
    {
      this.gmu.put(paramString, localObject1);
      paramString = (ArrayList)this.gmu.get(paramString);
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
            ae.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localArrayList;
          }
        }
      }
    }
  }
  
  public final PersonalDesigner wC(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(183920);
    if (!this.gmv.containsKey(paramString))
    {
      if (!((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
        break label125;
      }
      localObject1 = be.fvc().JfY.aWu(paramString);
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
            this.gmv.put(paramString, ((GetEmotionDetailResponse)localObject3).EmotionDetail.PersonalDesigner);
          }
          paramString = (PersonalDesigner)this.gmv.get(paramString);
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
            ae.printErrStackTrace("MicroMsg.EmojiStorageCache", localException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */