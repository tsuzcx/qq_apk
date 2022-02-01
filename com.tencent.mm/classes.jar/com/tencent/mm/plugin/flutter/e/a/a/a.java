package com.tencent.mm.plugin.flutter.e.a.a;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.ui.plugin.caption.e;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ai;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/CaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "profile", "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-flutter_release"})
public final class a
  implements i
{
  public static final a.a wJE;
  public String filePath;
  public r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> hFV;
  private volatile boolean ife;
  private c igg;
  private int jcu;
  private int profile;
  private int sampleRate;
  public boolean tUq;
  private boolean wJA;
  public boolean wJB;
  public int wJC;
  private int wJD;
  private e wJx;
  private ArrayList<sy> wJy;
  private ByteBuffer wJz;
  
  static
  {
    AppMethodBeat.i(241048);
    wJE = new a.a((byte)0);
    AppMethodBeat.o(241048);
  }
  
  public a()
  {
    AppMethodBeat.i(241047);
    this.wJy = new ArrayList();
    this.filePath = "";
    this.wJB = true;
    this.profile = 2;
    this.sampleRate = 44100;
    this.wJD = 1;
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3835, (i)this);
    AppMethodBeat.o(241047);
  }
  
  private final void a(int paramInt1, com.tencent.mm.bw.b paramb, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(241044);
    int i = this.jcu;
    Object localObject1 = this.wJx;
    e locale;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).GLl;
      locale = new e(paramInt1, paramb, paramInt2, paramInt3, i, (com.tencent.mm.bw.b)localObject1);
      localStringBuilder = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
      localObject1 = locale.GLl;
      if (localObject1 == null) {
        break label212;
      }
    }
    label212:
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toString("UTF-8");; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" seq:").append(paramInt2).append(" size:");
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Integer.valueOf(paramb.zy.length);
      }
      Log.i("MicroMsg.EditCaptionDataManager", localObject1 + " offset:" + paramInt3);
      locale.setFilePath(this.filePath);
      this.wJx = locale;
      paramb = g.aAg();
      p.g(paramb, "MMKernel.network()");
      paramb.azz().b((q)this.wJx);
      AppMethodBeat.o(241044);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(241046);
    Object localObject = g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3835, (i)this);
    try
    {
      this.ife = true;
      localObject = this.igg;
      if (localObject != null) {
        ((c)localObject).release();
      }
      this.igg = null;
      AppMethodBeat.o(241046);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(241046);
    }
  }
  
  public final int axp(String paramString)
  {
    AppMethodBeat.i(241043);
    for (;;)
    {
      try
      {
        if (this.igg == null)
        {
          this.igg = new c();
          localObject = this.igg;
          if (localObject != null) {
            ((c)localObject).setDataSource(paramString);
          }
          paramString = this.igg;
          if (paramString != null)
          {
            i = paramString.getTrackCount();
            break label533;
            if (j >= i) {
              break label528;
            }
            paramString = this.igg;
            if (paramString == null) {
              break label283;
            }
            paramString = paramString.getTrackFormat(j);
            if (paramString == null) {
              break label288;
            }
            localObject = paramString.getString("mime");
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (localObject == null) || (n.J((String)localObject, "audio/", false) != true)) {
              break label297;
            }
            localObject = this.igg;
            if (localObject == null) {
              break label294;
            }
            ((c)localObject).selectTrack(j);
            if (paramString != null) {
              break label306;
            }
            Log.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
            paramString = this.igg;
            if (paramString != null) {
              paramString.release();
            }
            this.igg = null;
            this.wJC = -2;
            AppMethodBeat.o(241043);
            return -2;
          }
        }
        else
        {
          Log.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
          AppMethodBeat.o(241043);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        localObject = this.igg;
        if (localObject != null) {
          ((c)localObject).release();
        }
        this.igg = null;
        Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)paramString, "", new Object[0]);
        this.wJC = -3;
        AppMethodBeat.o(241043);
        return -3;
      }
      int i = 0;
      break label533;
      label283:
      paramString = null;
      continue;
      label288:
      Object localObject = null;
      continue;
      label294:
      continue;
      label297:
      j += 1;
      continue;
      label306:
      long l = paramString.getLong("durationUs");
      i = paramString.getInteger("bitrate");
      this.profile = paramString.getInteger("profile", this.profile);
      this.sampleRate = paramString.getInteger("sample-rate", this.sampleRate);
      this.wJD = paramString.getInteger("channel-count", this.wJD);
      float f1 = 2.0F * (i * ((float)l / 1000.0F / 1000.0F) / 8.0F);
      float f2 = (float)l / 1000.0F / 20.0F * 7.0F;
      this.wJz = ByteBuffer.allocateDirect((int)(f1 + f2));
      localObject = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
      paramString = this.wJz;
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.capacity());; paramString = null)
      {
        Log.i("MicroMsg.EditCaptionDataManager", paramString + ", voiceSize:" + f1 + ", adtsSize:" + f2 + ", duration:" + l + ", bitrate:" + i);
        AppMethodBeat.o(241043);
        return 0;
      }
      label528:
      paramString = null;
      continue;
      label533:
      int j = 0;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(241045);
    if (paramq == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(241045);
      throw paramString;
    }
    if ((p.j(((e)paramq).filePath, this.filePath)) && (!this.ife))
    {
      Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      int i = ((e)paramq).GKp;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      ArrayList localArrayList4;
      Object localObject1;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.wJy = ((e)paramq).GLj;
        Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e)paramq).jlm + " isLastRequest:" + ((e)paramq).GLk + " progress:" + ((e)paramq).getProgress());
        Log.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((e)paramq).GLk)
        {
          if (((e)paramq).getProgress() >= 100)
          {
            this.tUq = false;
            paramString = this.hFV;
            if (paramString != null) {
              paramString.invoke(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.wJy);
            }
            paramString = new ArrayList();
            paramq = new ArrayList();
            paramq.add(Boolean.TRUE);
            localArrayList1 = new ArrayList();
            localArrayList1.add(this.filePath);
            localArrayList2 = new ArrayList();
            localArrayList3 = new ArrayList();
            localArrayList4 = new ArrayList();
            localObject1 = (Iterable)this.wJy;
            paramInt1 = 0;
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              if (paramInt1 < 0) {
                kotlin.a.j.hxH();
              }
              localObject2 = (sy)localObject2;
              Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((sy)localObject2).LaT + " end:" + ((sy)localObject2).LaU + " text:" + ((sy)localObject2).LaS.toString("UTF-8"));
              localArrayList2.add(((sy)localObject2).LaS.toString("UTF-8"));
              localArrayList3.add(Long.valueOf(((sy)localObject2).LaT));
              localArrayList4.add(Long.valueOf(((sy)localObject2).LaU));
              paramInt1 += 1;
            }
            paramString.add(paramq);
            paramString.add(localArrayList1);
            paramString.add(localArrayList2);
            paramString.add(localArrayList3);
            paramString.add(localArrayList4);
            h.CyF.dN(1565, 15);
            Log.i("MicroMsg.EditCaptionDataManager.FlutterVideoEditor_DataReport", "get caption result success");
            paramq = o.wKI;
            o.a.dMh().t("onGetCaptionDaraCompleted", paramString);
            release();
            AppMethodBeat.o(241045);
            return;
          }
          paramString = this.hFV;
          if (paramString != null) {
            paramString.invoke(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.wJy);
          }
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.wJx;
          if (paramString == null) {
            p.hyc();
          }
          a(i, null, paramString.jlm, 0);
          AppMethodBeat.o(241045);
        }
      }
      else if (((e)paramq).GLk)
      {
        this.wJC = -1;
        this.tUq = false;
        paramString = new ArrayList();
        paramq = new ArrayList();
        paramq.add(Boolean.FALSE);
        localArrayList1 = new ArrayList();
        localArrayList1.add(this.filePath);
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList4 = new ArrayList();
        localObject1 = (Iterable)this.wJy;
        paramInt1 = 0;
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (paramInt1 < 0) {
            kotlin.a.j.hxH();
          }
          localObject2 = (sy)localObject2;
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((sy)localObject2).LaT + " end:" + ((sy)localObject2).LaU + " text:" + ((sy)localObject2).LaS.toString("UTF-8"));
          localArrayList2.add(((sy)localObject2).LaS.toString("UTF-8"));
          localArrayList3.add(Long.valueOf(((sy)localObject2).LaT));
          localArrayList4.add(Long.valueOf(((sy)localObject2).LaU));
          paramInt1 += 1;
        }
        paramString.add(paramq);
        paramString.add(localArrayList1);
        paramString.add(localArrayList2);
        paramString.add(localArrayList3);
        paramString.add(localArrayList4);
        h.CyF.dN(1565, 15);
        Log.i("MicroMsg.EditCaptionDataManager.FlutterVideoEditor_DataReport", "get caption result success");
        paramq = o.wKI;
        o.a.dMh().t("onGetCaptionDaraCompleted", paramString);
        release();
        paramString = this.hFV;
        if (paramString != null) {
          paramString.invoke(Integer.valueOf(i), this.filePath, Integer.valueOf(-1), null);
        }
        this.wJB = true;
      }
    }
    AppMethodBeat.o(241045);
  }
  
  @f(c="com.tencent.mm.plugin.flutter.plugins.video.api.CaptionDataManager$voiceTransLate$1", f="CaptionDataManager.kt", hxM={}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class b
    extends kotlin.d.b.a.j
    implements m<ai, d<? super x>, Object>
  {
    int label;
    private ai p$;
    
    public b(a parama, int paramInt, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(241041);
      p.h(paramd, "completion");
      paramd = new b(this.wJF, this.$type, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(241041);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(241042);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(241042);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(241040);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(241040);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      a.a(this.wJF);
      a.a(this.wJF, this.$type);
      paramObject = x.SXb;
      AppMethodBeat.o(241040);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.a
 * JD-Core Version:    0.7.0.1
 */