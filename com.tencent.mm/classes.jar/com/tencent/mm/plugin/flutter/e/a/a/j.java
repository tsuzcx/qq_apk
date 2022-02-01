package com.tencent.mm.plugin.flutter.e.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.d.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "postId", "generateCompositionInfo", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "originInfo", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "jumpToPostUI1", "jumpToPostUI2", "exportStartTime", "", "Companion", "plugin-flutter_release"})
public final class j
{
  public static Bitmap wKi;
  public static b.g wKj;
  public static acn wKk;
  public static final a wKl;
  public String TAG;
  public String postId;
  
  static
  {
    AppMethodBeat.i(241092);
    wKl = new a((byte)0);
    AppMethodBeat.o(241092);
  }
  
  public j()
  {
    AppMethodBeat.i(241091);
    this.TAG = "MMVideoEditorJumpToPostUI";
    this.postId = "";
    StringBuilder localStringBuilder = new StringBuilder();
    p.g(g.aAf(), "MMKernel.account()");
    this.postId = (a.ayV() + '_' + Util.nowMilliSecond());
    AppMethodBeat.o(241091);
  }
  
  public final void a(acn paramacn, b.g paramg)
  {
    AppMethodBeat.i(241090);
    Log.i(this.TAG, "generateCompositionInfo");
    paramacn.Gxx = new acm();
    Object localObject2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    label570:
    int i;
    if (paramg.hjE() != null)
    {
      localObject1 = paramg.hjE();
      if (localObject1 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      localObject2 = ((HashMap)localObject1).get("drawingRect");
      if (localObject2 == null)
      {
        paramacn = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      localObject2 = (ArrayList)localObject2;
      if (localObject2 != null)
      {
        paramacn.Gxx.LmZ = new dlh();
        paramacn.Gxx.LmZ.Msu = new LinkedList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          paramacn.Gxx.LmZ.Msu.add(localObject3);
        }
      }
      localObject2 = paramacn.Gxx;
      localObject3 = ((HashMap)localObject1).get("recordVideo");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((acm)localObject2).Lnb = ((Boolean)localObject3).booleanValue();
      localObject2 = ((HashMap)localObject1).get("validRect");
      if (localObject2 == null)
      {
        paramacn = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      localObject2 = (ArrayList)localObject2;
      if (localObject2 != null)
      {
        paramacn.Gxx.Lnc = new dlh();
        paramacn.Gxx.Lnc.Msu = new LinkedList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          paramacn.Gxx.Lnc.Msu.add(localObject3);
        }
      }
      localObject1 = ((HashMap)localObject1).get("stickerEffectList");
      if (localObject1 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */>");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      localObject1 = (List)localObject1;
      localObject2 = new LinkedList();
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (HashMap)((Iterator)localObject3).next();
        localObject4 = new ecy();
        localObject1 = ((HashMap)localObject5).get("type");
        if (localObject1 != null) {}
        for (localObject1 = Boolean.valueOf(localObject1.equals("emoji"));; localObject1 = null)
        {
          if (localObject1 == null) {
            p.hyc();
          }
          if (!((Boolean)localObject1).booleanValue()) {
            break label570;
          }
          localObject1 = ((HashMap)localObject5).get("path");
          if (localObject1 != null) {
            break;
          }
          paramacn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ecy)localObject4).path = ((String)localObject1);
        for (;;)
        {
          localObject1 = new aiq();
          localObject6 = ((HashMap)localObject5).get("startTime");
          if (localObject6 != null) {
            break;
          }
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
          localObject1 = ((HashMap)localObject5).get("type");
          if (localObject1 != null) {}
          for (localObject1 = Boolean.valueOf(localObject1.equals("text"));; localObject1 = null)
          {
            if (localObject1 == null) {
              p.hyc();
            }
            if (!((Boolean)localObject1).booleanValue()) {
              break;
            }
            localObject1 = ((HashMap)localObject5).get("width");
            if (localObject1 != null) {
              break label649;
            }
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          label649:
          i = ((Integer)localObject1).intValue();
          localObject1 = ((HashMap)localObject5).get("height");
          if (localObject1 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          int j = ((Integer)localObject1).intValue();
          localObject1 = ((HashMap)localObject5).get("bytes");
          if (localObject1 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.ByteArray");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          localObject6 = (byte[])localObject1;
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject1).copyPixelsFromBuffer((Buffer)ByteBuffer.wrap((byte[])localObject6));
          p.g(localObject1, "bmp");
          i = ((Bitmap)localObject1).getWidth();
          j = ((Bitmap)localObject1).getHeight();
          localObject6 = ByteBuffer.allocate(((Bitmap)localObject1).getByteCount());
          ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject6);
          ((ecy)localObject4).Ndn = b.cD(((ByteBuffer)localObject6).array());
          ((ecy)localObject4).width = i;
          ((ecy)localObject4).height = j;
          localObject1 = new aiq();
          ((aiq)localObject1).startTimeMs = 0L;
          ((aiq)localObject1).endTimeMs = 10000L;
          localObject6 = x.SXb;
          ((ecy)localObject4).Ndo = ((aiq)localObject1);
          localObject1 = new aip();
          ((aip)localObject1).centerX = 300;
          ((aip)localObject1).centerY = 1000;
          ((aip)localObject1).scale = 1.0F;
          ((aip)localObject1).mat = 0.0F;
          localObject6 = x.SXb;
          ((ecy)localObject4).Ndp = ((aip)localObject1);
        }
        ((aiq)localObject1).startTimeMs = ((Integer)localObject6).intValue();
        Object localObject6 = ((HashMap)localObject5).get("endTime");
        if (localObject6 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((aiq)localObject1).endTimeMs = ((Integer)localObject6).intValue();
        ((ecy)localObject4).Ndo = ((aiq)localObject1);
        localObject1 = new aip();
        localObject6 = ((HashMap)localObject5).get("centerX");
        if (localObject6 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((aip)localObject1).centerX = ((Integer)localObject6).intValue();
        localObject6 = ((HashMap)localObject5).get("centerY");
        if (localObject6 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((aip)localObject1).centerY = ((Integer)localObject6).intValue();
        localObject6 = ((HashMap)localObject5).get("scale");
        if (localObject6 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Double");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((aip)localObject1).scale = ((float)((Double)localObject6).doubleValue());
        localObject5 = ((HashMap)localObject5).get("rotate");
        if (localObject5 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Double");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((aip)localObject1).mat = ((float)((Double)localObject5).doubleValue());
        ((ecy)localObject4).Ndp = ((aip)localObject1);
        ((LinkedList)localObject2).add(localObject4);
      }
      i.p((Collection)localObject2);
    }
    Object localObject1 = paramg.hjG();
    p.g(localObject1, "originInfo.enableVideoEnhanceMent");
    paramacn.Gzp = ((Boolean)localObject1).booleanValue();
    if (paramg.hjO() != null)
    {
      localObject1 = paramg.hjO().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((Iterator)localObject1).next();
        localObject2 = new acp();
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        localObject3 = (HashMap)localObject3;
        localObject4 = ((HashMap)localObject3).get("path");
        if (localObject4 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((acp)localObject2).path = ((String)localObject4);
        localObject4 = ((HashMap)localObject3).get("label");
        if (localObject4 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((acp)localObject2).label = ((Integer)localObject4).intValue();
        localObject3 = ((HashMap)localObject3).get("cost");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((acp)localObject2).Lns = ((Integer)localObject3).intValue();
        paramacn.Lnj.add(localObject2);
      }
    }
    localObject1 = paramg.hjF();
    p.g(localObject1, "originInfo.enableOriginAudio");
    paramacn.Gzo = ((Boolean)localObject1).booleanValue();
    localObject1 = paramg.hjG();
    p.g(localObject1, "originInfo.enableVideoEnhanceMent");
    paramacn.Gzp = ((Boolean)localObject1).booleanValue();
    paramacn.iiv = paramg.hjH();
    paramacn.editId = paramg.hjD();
    localObject1 = paramg.hjI();
    p.g(localObject1, "originInfo.needPlay");
    paramacn.Lng = ((Boolean)localObject1).booleanValue();
    paramacn.Gxw = new aco();
    if (paramg.hjM() != null)
    {
      localObject1 = paramg.hjM();
      if (localObject1 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("absSwitch");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).iTg = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("outputPath");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).rpE = ((String)localObject3);
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("originWidth");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).xlg = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("originHeight");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).xlh = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("outputScale");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Double");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).Lnn = ((float)((Double)localObject3).doubleValue());
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("videoBitrate");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).videoBitrate = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("fps");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).fps = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("iFrame");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).iiH = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("audioBitrate");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).audioBitrate = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("audioSampleRate");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).audioSampleRate = ((Integer)localObject3).intValue();
      localObject2 = paramacn.Gxw;
      localObject3 = ((HashMap)localObject1).get("audioChannelCount");
      if (localObject3 == null)
      {
        paramacn = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      ((aco)localObject2).audioChannelCount = ((Integer)localObject3).intValue();
      paramacn.Gxw.Lnm = new dlh();
      paramacn.Gxw.Lnm.Msu = new LinkedList();
      localObject1 = ((HashMap)localObject1).get("originRect");
      if (localObject1 == null)
      {
        paramacn = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
        AppMethodBeat.o(241090);
        throw paramacn;
      }
      localObject1 = (ArrayList)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          paramacn.Gxw.Lnm.Msu.add(localObject3);
        }
      }
      paramacn.Gxw.Lno = new LinkedList();
      localObject2 = paramacn.Gxw;
      i = ((Number)((ArrayList)localObject1).get(2)).intValue();
      localObject3 = ((ArrayList)localObject1).get(0);
      p.g(localObject3, "originRect[0]");
      ((aco)localObject2).targetWidth = (i - ((Number)localObject3).intValue());
      localObject2 = paramacn.Gxw;
      i = ((Number)((ArrayList)localObject1).get(3)).intValue();
      localObject1 = ((ArrayList)localObject1).get(1);
      p.g(localObject1, "originRect[1]");
      ((aco)localObject2).targetHeight = (i - ((Number)localObject1).intValue());
    }
    localObject1 = paramg.hjJ();
    p.g(localObject1, "originInfo.playEndMs");
    paramacn.Lnf = ((Long)localObject1).longValue();
    localObject1 = paramg.hjK();
    p.g(localObject1, "originInfo.playStartMs");
    paramacn.Lne = ((Long)localObject1).longValue();
    paramacn.Lnd = new LinkedList();
    if (paramg.hjL() != null)
    {
      paramg = paramg.hjL().iterator();
      while (paramg.hasNext())
      {
        localObject2 = paramg.next();
        localObject1 = new ejf();
        if (localObject2 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        localObject2 = (HashMap)localObject2;
        localObject3 = ((HashMap)localObject2).get("path");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).path = ((String)localObject3);
        localObject3 = ((HashMap)localObject2).get("endTimeMs");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).endTimeMs = ((Integer)localObject3).intValue();
        localObject3 = ((HashMap)localObject2).get("startTimeMs");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).startTimeMs = ((Integer)localObject3).intValue();
        localObject3 = ((HashMap)localObject2).get("trackStartTimeMs");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).GGz = ((Integer)localObject3).intValue();
        localObject3 = ((HashMap)localObject2).get("trackEndTimeMs");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).GGA = ((Integer)localObject3).intValue();
        localObject3 = ((HashMap)localObject2).get("sourceDuration");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).GJB = ((Integer)localObject3).intValue();
        localObject3 = ((HashMap)localObject2).get("volume");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Double");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).volume = ((float)((Double)localObject3).doubleValue());
        localObject3 = ((HashMap)localObject2).get("type");
        if (localObject3 == null)
        {
          paramacn = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(241090);
          throw paramacn;
        }
        ((ejf)localObject1).type = ((Integer)localObject3).intValue();
        if (((ejf)localObject1).type == 2)
        {
          localObject3 = ((HashMap)localObject2).get("sourceWidth");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((ejf)localObject1).Gzu = ((Integer)localObject3).intValue();
          localObject3 = ((HashMap)localObject2).get("sourceHeight");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((ejf)localObject1).Gzv = ((Integer)localObject3).intValue();
          localObject3 = ((HashMap)localObject2).get("sourceScale");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Double");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((ejf)localObject1).Gzw = ((float)((Double)localObject3).doubleValue());
          localObject3 = ((HashMap)localObject2).get("fromCamera");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((ejf)localObject1).Gze = ((Integer)localObject3).intValue();
          ((ejf)localObject1).NiP = new aeo();
          ((ejf)localObject1).NiP.LpR = new dlh();
          ((ejf)localObject1).NiP.LpR.Msu = new LinkedList();
          localObject3 = ((HashMap)localObject2).get("cropInfo");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          localObject3 = (HashMap)localObject3;
          localObject4 = ((ejf)localObject1).NiP.LpR.Msu;
          localObject5 = ((Map)localObject3).get("left");
          if (localObject5 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject5);
          localObject4 = ((ejf)localObject1).NiP.LpR.Msu;
          localObject5 = ((Map)localObject3).get("top");
          if (localObject5 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject5);
          localObject4 = ((ejf)localObject1).NiP.LpR.Msu;
          localObject5 = ((Map)localObject3).get("width");
          if (localObject5 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject5);
          localObject4 = ((ejf)localObject1).NiP.LpR.Msu;
          localObject3 = ((Map)localObject3).get("height");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject3);
          ((ejf)localObject1).NiP.LpT = new dlh();
          ((ejf)localObject1).NiP.LpT.Msu = new LinkedList();
          localObject3 = ((HashMap)localObject2).get("contentInfo");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          localObject3 = (HashMap)localObject3;
          localObject4 = ((ejf)localObject1).NiP.LpT.Msu;
          localObject5 = ((Map)localObject3).get("left");
          if (localObject5 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject5);
          localObject4 = ((ejf)localObject1).NiP.LpT.Msu;
          localObject5 = ((Map)localObject3).get("top");
          if (localObject5 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject5);
          localObject4 = ((ejf)localObject1).NiP.LpT.Msu;
          localObject5 = ((Map)localObject3).get("right");
          if (localObject5 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject5);
          localObject4 = ((ejf)localObject1).NiP.LpT.Msu;
          localObject3 = ((Map)localObject3).get("bottom");
          if (localObject3 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject4).add((Integer)localObject3);
          ((ejf)localObject1).NiP.LpU = new dlh();
          ((ejf)localObject1).NiP.LpU.Msu = new LinkedList();
          localObject2 = ((HashMap)localObject2).get("trackCropInfo");
          if (localObject2 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          localObject2 = (HashMap)localObject2;
          localObject3 = ((ejf)localObject1).NiP.LpU.Msu;
          localObject4 = ((Map)localObject2).get("left");
          if (localObject4 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject3).add((Integer)localObject4);
          localObject3 = ((ejf)localObject1).NiP.LpU.Msu;
          localObject4 = ((Map)localObject2).get("top");
          if (localObject4 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject3).add((Integer)localObject4);
          localObject3 = ((ejf)localObject1).NiP.LpU.Msu;
          localObject4 = ((Map)localObject2).get("right");
          if (localObject4 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject3).add((Integer)localObject4);
          localObject3 = ((ejf)localObject1).NiP.LpU.Msu;
          localObject2 = ((Map)localObject2).get("bottom");
          if (localObject2 == null)
          {
            paramacn = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(241090);
            throw paramacn;
          }
          ((LinkedList)localObject3).add((Integer)localObject2);
          ((ejf)localObject1).NiP.LpS = new dlh();
          ((ejf)localObject1).NiP.LpS.Msu = new LinkedList();
          ((ejf)localObject1).NiP.LpS.Msu.add(Integer.valueOf(0));
          ((ejf)localObject1).NiP.LpS.Msu.add(Integer.valueOf(0));
          ((ejf)localObject1).NiP.LpS.Msu.add(Integer.valueOf(0));
          ((ejf)localObject1).NiP.LpS.Msu.add(Integer.valueOf(0));
          ((ejf)localObject1).NiP.LpQ = new cmv();
          ((ejf)localObject1).NiP.LpQ.Msu = new LinkedList();
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(1.63F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(0.0F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(0.0F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(0.0F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(1.63F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(-12.833F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(0.0F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(0.0F));
          ((ejf)localObject1).NiP.LpQ.Msu.add(Float.valueOf(1.0F));
        }
        paramacn.Lnd.add(localObject1);
      }
    }
    AppMethodBeat.o(241090);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI$Companion;", "", "()V", "compositionInfo2", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "getCompositionInfo2", "()Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "setCompositionInfo2", "(Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;)V", "cp", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCp", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCp", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "thumb", "Landroid/graphics/Bitmap;", "getThumb", "()Landroid/graphics/Bitmap;", "setThumb", "(Landroid/graphics/Bitmap;)V", "plugin-flutter_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.j
 * JD-Core Version:    0.7.0.1
 */