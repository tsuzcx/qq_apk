package com.tencent.mm.plugin.flutter.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.d.b.aa;
import com.tencent.d.b.ab;
import com.tencent.d.b.ac;
import com.tencent.d.b.ad;
import com.tencent.d.b.af;
import com.tencent.d.b.ah;
import com.tencent.d.b.ai;
import com.tencent.d.b.aj;
import com.tencent.d.b.ak;
import com.tencent.d.b.al;
import com.tencent.d.b.am;
import com.tencent.d.b.an;
import com.tencent.d.b.ar;
import com.tencent.d.b.as;
import com.tencent.d.b.at;
import com.tencent.d.b.c;
import com.tencent.d.b.d;
import com.tencent.d.b.f;
import com.tencent.d.b.g;
import com.tencent.d.b.i;
import com.tencent.d.b.j;
import com.tencent.d.b.k;
import com.tencent.d.b.l;
import com.tencent.d.b.m;
import com.tencent.d.b.n;
import com.tencent.d.b.o;
import com.tencent.d.b.p;
import com.tencent.d.b.q;
import com.tencent.d.b.r;
import com.tencent.d.b.s;
import com.tencent.d.b.t;
import com.tencent.d.b.u;
import com.tencent.d.b.v;
import com.tencent.d.b.w;
import com.tencent.d.b.x;
import com.tencent.d.b.y;
import com.tencent.d.b.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.ui.FinderPostUI;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.plugin.flutter.e.a.a.a.b;
import com.tencent.mm.plugin.flutter.e.a.a.c;
import com.tencent.mm.plugin.flutter.e.a.a.f.a;
import com.tencent.mm.plugin.flutter.e.a.a.f.c;
import com.tencent.mm.plugin.flutter.e.a.a.f.d;
import com.tencent.mm.plugin.flutter.e.a.a.h.a;
import com.tencent.mm.plugin.flutter.e.a.a.j.b;
import com.tencent.mm.plugin.flutter.e.a.a.k;
import com.tencent.mm.plugin.flutter.e.a.a.k.b;
import com.tencent.mm.plugin.flutter.e.a.a.l.a;
import com.tencent.mm.plugin.flutter.e.a.a.m.b;
import com.tencent.mm.plugin.flutter.e.a.a.n.b;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.flutter.e.a.a.o.a;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/MMVideoEditorCompositionApiPlugin;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoEditorCompositionApi;", "()V", "DeleteEmoji", "", "arg", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$DeleteEmojiRequest;", "MoveEmojiToFront", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MoveEmojiToFrontRequest;", "addMember", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioLrcInfo;", "addMember10", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TransitionInfoProto;", "addMember2", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioInfo;", "addMember3", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicSearchResponse;", "addMember4", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicSearchLrcInfo;", "addMember5", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TransitionDataResponse;", "addMember6", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TrackInfoProtoFlutter;", "addMember7", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoTemplateInfoProto;", "addMember8", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionOutputConfig;", "addMember9", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "bitmapToBase64", "", "bitmap", "Landroid/graphics/Bitmap;", "checkFontFamilyRes", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$FontFamilyResResponse;", "checkTransitionRes", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TransitionResResponse;", "doMusicSearchRequest", "request", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicSearchRequest;", "downloadMusic", "info", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$MusicDownloadInfo;", "getAudioRecommend", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioRecommendResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$AudioRecommendRequest;", "getCaptionData", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CaptionDataRequest;", "getCustomEmojiCapture", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomCaptureEmojiResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomCaptureEmojiRequest;", "getCustomEmojiCaptureMd5List", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomCaptureMd5ListResponse;", "getCustomEmojiData", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomEmojiNormalResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomEmojiDataRequest;", "getCustomEmojiMd5List", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CustomEmojiMd5Data;", "getEmojiDataBase64", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataBase64Response;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataBase64Request;", "getEmojiGIFData", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiGIFDataResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiGIFDataRequest;", "getEmojiMd5ListByProductId", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiInfoMd5Response;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiInfoMd5Request;", "getFontDataResponse", "getGroupProductId", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiProductIdResponse;", "getNetWorkType", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$IntReply;", "getSystemEmojiMd5List", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SystemEmojiMd5Response;", "getTransitionData", "getVideoGOPStr", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$StringResponse;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoGOPStrRequest;", "idkeyStat", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$IdkeyRequest;", "improveVideoQuality", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$BoolRequest;", "jumpToPostUI", "jumpToPostUI2", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$IntRequest;", "loadEmoji", "response", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataResponse;", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "saveImageByteToPath", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SaveImageByteToPath;", "showeEmojiGroupDetail", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$ShoweEmojiGroupDetailRequest;", "simple", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SimpleReply;", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$SimpleRequest;", "simple2", "testEmoji", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$EmojiDataRequest;", "textToSpeech", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$TextToSpeechRequest;", "Companion", "plugin-flutter_release"})
public final class a
  extends b.as
{
  public static final a.a wJw;
  
  static
  {
    AppMethodBeat.i(241039);
    wJw = new a.a((byte)0);
    AppMethodBeat.o(241039);
  }
  
  public final b.aj a(b.ak paramak)
  {
    AppMethodBeat.i(240999);
    b.aj localaj = new b.aj();
    if (paramak == null) {
      localaj.bpS("fail");
    }
    for (;;)
    {
      AppMethodBeat.o(240999);
      return localaj;
      new StringBuilder("arg.requestName").append(paramak.hjZ());
      localaj.bpS("wecaht success");
    }
  }
  
  public final b.al a(b.at paramat)
  {
    AppMethodBeat.i(241028);
    b.al localal = new b.al();
    Object localObject1 = paramat.hkb();
    paramat = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (localObject2 == null)
        {
          paramat = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(241028);
          throw paramat;
        }
        paramat.add((String)localObject2);
      }
    }
    localal.bpT(com.tencent.mm.plugin.flutter.e.a.a.e.eK((List)paramat));
    AppMethodBeat.o(241028);
    return localal;
  }
  
  public final b.d a(b.c paramc)
  {
    AppMethodBeat.i(241007);
    new b.d();
    Object localObject = com.tencent.mm.plugin.flutter.e.a.a.f.wJV;
    localObject = f.a.dLQ();
    String str = paramc.getPath();
    kotlin.g.b.p.g(str, "request.path");
    Long localLong = paramc.hjA();
    kotlin.g.b.p.g(localLong, "request.startTime");
    long l1 = localLong.longValue();
    paramc = paramc.hjB();
    kotlin.g.b.p.g(paramc, "request.endTime");
    long l2 = paramc.longValue();
    kotlin.g.b.p.h(str, "videoPath");
    Log.i(((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).TAG, "getRecommendAudio111");
    kotlin.g.b.p.h(str, "videoPath");
    Log.i(((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).TAG, "startGetRecommendAudio");
    com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 19);
    Log.i(((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).vRb, "start to get music recommend");
    ((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).wJS = ((com.tencent.mm.plugin.recordvideo.model.audio.a)new com.tencent.mm.plugin.recordvideo.model.audio.h((com.tencent.mm.vending.e.b)((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).wJT, str, l1, l2, com.tencent.mm.plugin.recordvideo.b.i.BNI.ordinal()));
    paramc = ((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).wJS;
    if (paramc != null) {
      paramc.callback = ((kotlin.g.a.b)new f.d((com.tencent.mm.plugin.flutter.e.a.a.f)localObject));
    }
    paramc = ((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).wJS;
    if (paramc != null) {
      paramc.qdn = false;
    }
    paramc = ((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).wJS;
    if (paramc != null) {
      paramc.eJQ();
    }
    paramc = ((com.tencent.mm.plugin.flutter.e.a.a.f)localObject).wJS;
    if (paramc != null) {
      paramc.cJk();
    }
    paramc = new b.d();
    AppMethodBeat.o(241007);
    return paramc;
  }
  
  public final b.j a(b.i parami)
  {
    AppMethodBeat.i(241025);
    b.j localj = new b.j();
    h.a locala = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    localj.cS(com.tencent.mm.plugin.flutter.e.a.a.h.axu(parami.getMd5()));
    AppMethodBeat.o(241025);
    return localj;
  }
  
  public final b.n a(b.l paraml)
  {
    AppMethodBeat.i(241011);
    b.n localn = new b.n();
    h.a locala = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    localn.cS(com.tencent.mm.plugin.flutter.e.a.a.h.axu(paraml.getMd5()));
    AppMethodBeat.o(241011);
    return localn;
  }
  
  public final b.q a(b.p paramp)
  {
    AppMethodBeat.i(241004);
    b.q localq = new b.q();
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    Object localObject2 = paramp.getProductId();
    kotlin.g.b.p.g(localObject2, "request.productId");
    localObject1 = paramp.hjP();
    kotlin.g.b.p.g(localObject1, "request.emojiMd5");
    kotlin.g.b.p.h(localObject2, "productId");
    kotlin.g.b.p.h(localObject1, "md5");
    Object localObject3 = com.tencent.mm.plugin.flutter.e.a.a.h.axq((String)localObject2);
    localObject2 = new c();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject3).next();
      if (kotlin.g.b.p.j(localEmojiInfo.getMd5(), localObject1))
      {
        ((c)localObject2).zy = com.tencent.mm.plugin.flutter.e.a.a.h.ab(localEmojiInfo.A((Context)((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aAZ(), 480));
        if (localEmojiInfo.field_catalog != EmojiGroupInfo.Uun) {
          break label235;
        }
      }
    }
    label235:
    for (boolean bool = true;; bool = false)
    {
      ((c)localObject2).wJQ = Boolean.valueOf(bool);
      localq.cS(((c)localObject2).zy);
      localq.v(((c)localObject2).wJQ);
      localObject1 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
      h.a.dLW();
      paramp = paramp.hjP();
      kotlin.g.b.p.g(paramp, "request.emojiMd5");
      localq.bpO(com.tencent.mm.plugin.flutter.e.a.a.h.axv(paramp));
      AppMethodBeat.o(241004);
      return localq;
    }
  }
  
  public final b.s a(b.r paramr)
  {
    AppMethodBeat.i(241001);
    b.s locals = new b.s();
    new StringBuilder("emoji request ").append(paramr.hjQ());
    locals.bpP("emoji response from java!");
    paramr = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    paramr = com.tencent.mm.plugin.flutter.e.a.a.h.dLS().iterator();
    while (paramr.hasNext())
    {
      EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)paramr.next();
      new StringBuilder("produce id is ").append(localEmojiGroupInfo.hRu());
    }
    AppMethodBeat.o(241001);
    return locals;
  }
  
  public final b.u a(b.t paramt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(241009);
    kotlin.g.b.p.h(paramt, "arg");
    b.u localu = new b.u();
    Object localObject2 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    localObject2 = paramt.getMd5();
    kotlin.g.b.p.g(localObject2, "arg.md5");
    localu.setData(com.tencent.mm.plugin.flutter.e.a.a.h.axr((String)localObject2));
    localObject2 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    paramt = paramt.getMd5();
    kotlin.g.b.p.g(paramt, "arg.md5");
    localObject2 = com.tencent.mm.plugin.flutter.e.a.a.h.axs(paramt);
    paramt = ((com.tencent.mm.plugin.flutter.e.a.a.d)localObject2).irm;
    if (paramt != null) {}
    for (paramt = Long.valueOf(paramt.intValue());; paramt = null)
    {
      localu.m(paramt);
      localObject2 = ((com.tencent.mm.plugin.flutter.e.a.a.d)localObject2).irl;
      paramt = localObject1;
      if (localObject2 != null) {
        paramt = Long.valueOf(((Integer)localObject2).intValue());
      }
      localu.n(paramt);
      AppMethodBeat.o(241009);
      return localu;
    }
  }
  
  public final b.w a(b.v paramv)
  {
    Object localObject1 = null;
    AppMethodBeat.i(241003);
    Object localObject2 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    Object localObject3 = com.tencent.mm.plugin.flutter.e.a.a.h.axq(paramv.getProductId());
    localObject2 = new b.w();
    ((b.w)localObject2).bw(new ArrayList());
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject3).next();
      ((b.w)localObject2).hjR().add(localEmojiInfo.getMd5());
    }
    localObject3 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    localObject3 = com.tencent.mm.plugin.flutter.e.a.a.h.axw(paramv.getProductId());
    if (localObject3 != null)
    {
      paramv = ((PersonalDesigner)localObject3).HeadUrl;
      ((b.w)localObject2).bpR(paramv);
      if (localObject3 == null) {
        break label176;
      }
    }
    label176:
    for (paramv = ((PersonalDesigner)localObject3).Name;; paramv = null)
    {
      ((b.w)localObject2).bpQ(paramv);
      paramv = localObject1;
      if (localObject3 != null) {
        paramv = Long.valueOf(((PersonalDesigner)localObject3).DesignerUin);
      }
      ((b.w)localObject2).o(paramv);
      AppMethodBeat.o(241003);
      return localObject2;
      paramv = null;
      break;
    }
  }
  
  public final void a(b.ab paramab)
  {
    com.tencent.mm.hellhoundlib.b.a locala = null;
    AppMethodBeat.i(241021);
    kotlin.g.b.p.h(paramab, "arg");
    com.tencent.mm.plugin.flutter.e.a.a.j localj = new com.tencent.mm.plugin.flutter.e.a.a.j();
    paramab = paramab.hjS();
    kotlin.g.b.p.g(paramab, "arg.id");
    long l = paramab.longValue();
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.j.wKi;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("thumb");
    }
    Object localObject2 = Bitmap.CompressFormat.JPEG;
    paramab = com.tencent.mm.plugin.flutter.e.a.a.j.wKj;
    if (paramab == null) {
      kotlin.g.b.p.btv("compositionInfo2");
    }
    if (paramab != null)
    {
      paramab = paramab.aQn();
      BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 60, (Bitmap.CompressFormat)localObject2, paramab, true);
      localObject1 = new Intent();
      paramab = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
      if (paramab == null) {
        kotlin.g.b.p.btv("cp");
      }
      if (paramab == null) {
        break label475;
      }
    }
    label475:
    for (paramab = paramab.toByteArray();; paramab = null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramab);
      ((Intent)localObject1).putExtra("postType", 4);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)kotlin.a.j.ac(new String[] { "" }));
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)kotlin.a.j.ac(new Integer[] { Integer.valueOf(4) }));
      localObject2 = com.tencent.mm.plugin.flutter.e.a.a.j.wKj;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("compositionInfo2");
      }
      paramab = locala;
      if (localObject2 != null) {
        paramab = ((b.g)localObject2).aQn();
      }
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)kotlin.a.j.ac(new String[] { paramab }));
      ((Intent)localObject1).putExtra("post_id", localj.postId);
      ((Intent)localObject1).putExtra("key_finder_post_from", 5);
      ((Intent)localObject1).putExtra("KEY_FINDER_POST_FORM_FLUTTER", true);
      ((Intent)localObject1).putExtra("KEY_FINDER_POST_EXPORT_START_TIME", l);
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).setClass(MMApplicationContext.getContext(), FinderPostUI.class);
      paramab = MMApplicationContext.getContext();
      locala = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramab, locala.axQ(), "com/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI", "jumpToPostUI2", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramab.startActivity((Intent)locala.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramab, "com/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI", "jumpToPostUI2", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramab = com.tencent.mm.kernel.g.ah(PluginFlutter.class);
      kotlin.g.b.p.g(paramab, "MMKernel.plugin(PluginFlutter::class.java)");
      paramab = ((PluginFlutter)paramab).getFlutterEngineMgr();
      kotlin.g.b.p.g(paramab, "MMKernel.plugin(PluginFl…ss.java).flutterEngineMgr");
      paramab = paramab.dLs();
      kotlin.g.b.p.g(paramab, "MMKernel.plugin(PluginFl…ngineMgr.currentContainer");
      paramab = paramab.getActivity();
      if ((paramab instanceof MMFlutterActivity)) {
        paramab.setResult(-1);
      }
      paramab.finish();
      AppMethodBeat.o(241021);
      return;
      paramab = null;
      break;
    }
  }
  
  public final void a(b.ac paramac)
  {
    AppMethodBeat.i(241006);
    Long localLong = paramac.hjC();
    if (localLong != null)
    {
      int i = (int)localLong.longValue();
      com.tencent.mm.plugin.flutter.e.a.a.i.dLX().bs(i, paramac.getMd5());
      AppMethodBeat.o(241006);
      return;
    }
    AppMethodBeat.o(241006);
  }
  
  public final void a(b.ad paramad)
  {
    AppMethodBeat.i(241016);
    AudioCacheInfo localAudioCacheInfo = new AudioCacheInfo();
    localAudioCacheInfo.BOX = ((int)paramad.hjV().longValue());
    localAudioCacheInfo.musicUrl = paramad.hjW();
    localAudioCacheInfo.cachePath = paramad.azM();
    paramad = com.tencent.mm.plugin.flutter.e.a.a.f.wJV;
    paramad = f.a.dLQ();
    kotlin.g.b.p.h(localAudioCacheInfo, "info");
    Log.i(paramad.TAG, "downloadMusic : " + localAudioCacheInfo.cachePath + ", " + localAudioCacheInfo.BOX);
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.eKl();
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    ((com.tencent.mm.plugin.recordvideo.model.audio.i)localObject).a(localContext, localAudioCacheInfo, (kotlin.g.a.m)new f.c(paramad));
    AppMethodBeat.o(241016);
  }
  
  public final void a(b.af paramaf)
  {
    AppMethodBeat.i(241008);
    if (paramaf.getName() != null)
    {
      Object localObject = k.wKs;
      if (k.dLZ() == null) {
        k.e(new k((byte)0));
      }
      localObject = k.dLZ();
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      String str = paramaf.getName();
      kotlin.g.b.p.g(str, "request.name");
      int i = (int)paramaf.hjX().longValue();
      kotlin.g.b.p.h(str, "researchString");
      com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 22);
      Log.i(((k)localObject).vRb, "start to search music");
      Log.i(((k)localObject).TAG, "music search name: " + str + ", offset: " + i);
      new com.tencent.mm.plugin.recordvideo.model.audio.f(((k)localObject).wKp, str, i, ((k)localObject).wKq, (byte)0).aYI().b((com.tencent.mm.vending.c.a)new k.b((k)localObject, str));
    }
    AppMethodBeat.o(241008);
  }
  
  public final void a(b.ah paramah)
  {
    boolean bool = true;
    AppMethodBeat.i(241019);
    Object localObject1 = new com.tencent.mm.plugin.flutter.e.a.a.p();
    Object localObject2 = paramah.hjY();
    String str = paramah.getPath();
    kotlin.g.b.p.g(str, "request.path");
    kotlin.g.b.p.h(str, "path");
    if (localObject2 == null)
    {
      Log.e(((com.tencent.mm.plugin.flutter.e.a.a.p)localObject1).TAG, "bytesToBitmap save image data is null");
      paramah = null;
      if ((paramah != null) && (!org.apache.commons.b.g.eP(str))) {
        break label156;
      }
      localObject1 = ((com.tencent.mm.plugin.flutter.e.a.a.p)localObject1).TAG;
      localObject2 = new StringBuilder("bitmap or path null: ");
      if (paramah != null) {
        break label151;
      }
    }
    for (;;)
    {
      Log.e((String)localObject1, bool + ", " + org.apache.commons.b.g.eP(str));
      AppMethodBeat.o(241019);
      return;
      new BitmapFactory.Options().inMutable = true;
      paramah = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
      break;
      label151:
      bool = false;
    }
    label156:
    localObject2 = new File(str);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (!((File)localObject2).exists()) {
      ((File)localObject2).createNewFile();
    }
    localObject2 = new FileOutputStream(str);
    try
    {
      Log.i(((com.tencent.mm.plugin.flutter.e.a.a.p)localObject1).TAG, "save pat: ".concat(String.valueOf(str)));
      paramah.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      ((FileOutputStream)localObject2).write(new byte[1052672]);
      ((FileOutputStream)localObject2).flush();
      ((FileOutputStream)localObject2).close();
      AppMethodBeat.o(241019);
      return;
    }
    catch (Exception localException)
    {
      Log.e(((com.tencent.mm.plugin.flutter.e.a.a.p)localObject1).TAG, "saveImageToPath error: " + localException.getLocalizedMessage());
      try
      {
        ((FileOutputStream)localObject2).close();
        paramah.recycle();
        AppMethodBeat.o(241019);
        return;
      }
      catch (Exception paramah)
      {
        AppMethodBeat.o(241019);
      }
    }
  }
  
  public final void a(b.ai paramai)
  {
    AppMethodBeat.i(241026);
    h.a locala = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    com.tencent.mm.plugin.flutter.e.a.a.h.axt(paramai.getProductId());
    AppMethodBeat.o(241026);
  }
  
  public final void a(b.an paraman)
  {
    AppMethodBeat.i(241029);
    kotlin.g.b.p.h(paraman, "arg");
    Object localObject = paraman.getText();
    paraman = paraman.hka();
    kotlin.g.b.p.g(paraman, "uniqueString");
    paraman = new com.tencent.mm.plugin.flutter.e.a.a.b(paraman);
    kotlin.g.b.p.g(localObject, "speechText");
    kotlin.g.b.p.h(localObject, "text");
    String str = z.aUg();
    kotlin.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    Log.i("vison", "doNetRequest");
    localObject = new com.tencent.mm.plugin.vlog.ui.plugin.read.b(str, (String)localObject);
    int i = com.tencent.mm.plugin.flutter.e.a.a.b.wJJ;
    com.tencent.mm.plugin.flutter.e.a.a.b.wJJ = i + 1;
    paraman.wJG = i;
    ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)localObject).wJG = paraman.wJG;
    paraman = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(paraman, "MMKernel.network()");
    paraman.azz().b((q)localObject);
    AppMethodBeat.o(241029);
  }
  
  public final void a(b.f paramf)
  {
    AppMethodBeat.i(241022);
    kotlin.g.b.p.h(paramf, "arg");
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.g.wJZ;
    if (com.tencent.mm.plugin.flutter.e.a.a.g.dLR() == null) {
      com.tencent.mm.plugin.flutter.e.a.a.g.a(new com.tencent.mm.plugin.flutter.e.a.a.g((byte)0));
    }
    localObject1 = com.tencent.mm.plugin.flutter.e.a.a.g.dLR();
    if (localObject1 == null) {
      kotlin.g.b.p.hyc();
    }
    int i = (int)paramf.hjC().longValue();
    Object localObject2 = paramf.getFilePath();
    kotlin.g.b.p.g(localObject2, "arg.filePath");
    kotlin.g.b.p.h(localObject2, "filePath");
    paramf = new com.tencent.mm.plugin.flutter.e.a.a.a();
    com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 14);
    Log.i(((com.tencent.mm.plugin.flutter.e.a.a.g)localObject1).TAG, "start to get caption result");
    kotlin.g.b.p.h(localObject2, "filePath");
    Log.i("MicroMsg.EditCaptionDataManager", "[" + paramf.hashCode() + "]prepare translate file:" + (String)localObject2);
    if ((paramf.wJB) || (!kotlin.g.b.p.j(localObject2, paramf.filePath)))
    {
      paramf.wJB = false;
      paramf.tUq = true;
      paramf.hFV = null;
      paramf.filePath = ((String)localObject2);
      int j = paramf.axp((String)localObject2);
      if (j != 0)
      {
        paramf.tUq = false;
        paramf = new ArrayList();
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(Boolean.TRUE);
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(localObject2);
        localObject2 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        paramf.add(localObject1);
        paramf.add(localArrayList1);
        paramf.add(localObject2);
        paramf.add(localArrayList2);
        paramf.add(localArrayList3);
        com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 15);
        Log.i("MicroMsg.EditCaptionDataManager.FlutterVideoEditor_DataReport", "get caption result success");
        localObject1 = o.wKI;
        o.a.dMh().t("onGetCaptionDaraCompleted", paramf);
        AppMethodBeat.o(241022);
        return;
      }
      paramf.wJC = j;
      kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (kotlin.g.a.m)new a.b(paramf, i, null), 2);
    }
    AppMethodBeat.o(241022);
  }
  
  public final void a(b.g paramg)
  {
    AppMethodBeat.i(241020);
    Object localObject = new com.tencent.mm.plugin.flutter.e.a.a.j();
    if (paramg != null)
    {
      kotlin.g.b.p.h(paramg, "compositionInfo");
      Log.i(((com.tencent.mm.plugin.flutter.e.a.a.j)localObject).TAG, "jumpToPostUI: " + paramg.aQn());
      com.tencent.mm.plugin.flutter.e.a.a.j.wKk = new acn();
      com.tencent.mm.plugin.flutter.e.a.a.j.wKj = paramg;
      acn localacn = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
      if (localacn == null) {
        kotlin.g.b.p.btv("cp");
      }
      if (localacn == null) {
        kotlin.g.b.p.hyc();
      }
      ((com.tencent.mm.plugin.flutter.e.a.a.j)localObject).a(localacn, paramg);
      localObject = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
      if (localObject == null) {
        kotlin.g.b.p.btv("cp");
      }
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = com.tencent.mm.plugin.vlog.model.i.d((acn)localObject, new EffectManager()).getComposition();
      localacn = com.tencent.mm.plugin.flutter.e.a.a.j.wKk;
      if (localacn == null) {
        kotlin.g.b.p.btv("cp");
      }
      if (localacn == null) {
        kotlin.g.b.p.hyc();
      }
      ((com.tencent.mm.videocomposition.n)localObject).c(localacn.Gxw.targetWidth, (kotlin.g.a.b)new j.b(paramg));
    }
    AppMethodBeat.o(241020);
  }
  
  public final void a(b.o paramo)
  {
    AppMethodBeat.i(241005);
    Long localLong = paramo.hjC();
    if (localLong != null)
    {
      int i = (int)localLong.longValue();
      com.tencent.mm.plugin.flutter.e.a.a.i.dLX().br(i, paramo.getMd5());
      AppMethodBeat.o(241005);
      return;
    }
    AppMethodBeat.o(241005);
  }
  
  public final void a(b.z paramz)
  {
    AppMethodBeat.i(241027);
    kotlin.g.b.p.h(paramz, "arg");
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    Long localLong = paramz.hjS();
    kotlin.g.b.p.g(localLong, "arg.id");
    long l1 = localLong.longValue();
    localLong = paramz.hjT();
    kotlin.g.b.p.g(localLong, "arg.key");
    long l2 = localLong.longValue();
    paramz = paramz.hjU();
    kotlin.g.b.p.g(paramz, "arg.value");
    localh.n(l1, l2, paramz.longValue());
    AppMethodBeat.o(241027);
  }
  
  public final b.aj b(b.ak paramak)
  {
    AppMethodBeat.i(241000);
    b.aj localaj = new b.aj();
    if (paramak == null) {
      localaj.bpS("fail");
    }
    for (;;)
    {
      AppMethodBeat.o(241000);
      return localaj;
      new StringBuilder("arg.requestName").append(paramak.hjZ());
      localaj.bpS("wecaht success");
    }
  }
  
  public final b.m dLA()
  {
    AppMethodBeat.i(241014);
    b.m localm = new b.m();
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    Object localObject2 = com.tencent.mm.plugin.flutter.e.a.a.h.dLT();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((EmojiInfo)((Iterator)localObject2).next()).getMd5());
    }
    localm.bw((ArrayList)localObject1);
    AppMethodBeat.o(241014);
    return localm;
  }
  
  public final b.am dLB()
  {
    AppMethodBeat.i(241015);
    b.am localam = new b.am();
    h.a locala = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    localam.bw(com.tencent.mm.plugin.flutter.e.a.a.h.dLU());
    AppMethodBeat.o(241015);
    return localam;
  }
  
  public final b.k dLC()
  {
    AppMethodBeat.i(241017);
    b.k localk = new b.k();
    Object localObject = com.tencent.mm.emoji.b.j.auL().dU(false);
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      kotlin.g.b.p.g(localEmojiInfo, "info");
      localArrayList.add(localEmojiInfo.getMd5());
    }
    localk.bw(localArrayList);
    AppMethodBeat.o(241017);
    return localk;
  }
  
  public final b.aa dLD()
  {
    AppMethodBeat.i(241018);
    b.aa localaa = new b.aa();
    localaa.p(Long.valueOf(com.tencent.mm.plugin.flutter.e.a.a.e.bAX()));
    AppMethodBeat.o(241018);
    return localaa;
  }
  
  public final void dLE()
  {
    int j = 0;
    AppMethodBeat.i(241023);
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.l.wKw;
    if (l.a.dMc().dMa())
    {
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = new ArrayList();
      if (com.tencent.mm.plugin.recordvideo.res.e.BYn.BXZ)
      {
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("name", "default");
        ((JSONObject)localObject3).put("key", "default");
        ((JSONObject)localObject3).put("path", "default");
        ((ArrayList)localObject2).add(localObject3);
        localObject3 = com.tencent.mm.plugin.recordvideo.res.e.BYn.eLn();
        if (localObject3 != null)
        {
          int k = ((JSONArray)localObject3).length();
          i = 0;
          while (i < k)
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject3).optJSONObject(i));
            i += 1;
          }
        }
        localObject2 = ((Iterable)localObject2).iterator();
        int i = j;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          Object localObject4 = (JSONObject)localObject3;
          localObject3 = ((JSONObject)localObject4).optString("name");
          localObject4 = com.tencent.mm.plugin.recordvideo.res.e.BYn.eLk() + ((JSONObject)localObject4).optString("path");
          if ((kotlin.g.b.p.j(localObject3, "default") ^ true))
          {
            ((ArrayList)localObject1).add(localObject3);
            localArrayList.add(localObject4);
          }
          i += 1;
        }
      }
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      ((ArrayList)localObject2).add(localArrayList);
      localObject1 = o.wKI;
      o.a.dMh().t("getFontData", localObject2);
    }
    localObject1 = x.SXb;
    AppMethodBeat.o(241023);
  }
  
  public final void dLF()
  {
    AppMethodBeat.i(241024);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241024);
    throw localThrowable;
  }
  
  public final void dLG()
  {
    AppMethodBeat.i(241030);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241030);
    throw localThrowable;
  }
  
  public final void dLH()
  {
    AppMethodBeat.i(241031);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241031);
    throw localThrowable;
  }
  
  public final void dLI()
  {
    AppMethodBeat.i(241032);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241032);
    throw localThrowable;
  }
  
  public final void dLJ()
  {
    AppMethodBeat.i(241033);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241033);
    throw localThrowable;
  }
  
  public final void dLK()
  {
    AppMethodBeat.i(241034);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241034);
    throw localThrowable;
  }
  
  public final void dLL()
  {
    AppMethodBeat.i(241035);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241035);
    throw localThrowable;
  }
  
  public final void dLM()
  {
    AppMethodBeat.i(241036);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241036);
    throw localThrowable;
  }
  
  public final void dLN()
  {
    AppMethodBeat.i(241037);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241037);
    throw localThrowable;
  }
  
  public final void dLO()
  {
    AppMethodBeat.i(241038);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(241038);
    throw localThrowable;
  }
  
  public final b.x dLw()
  {
    AppMethodBeat.i(241002);
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.h.wKb;
    h.a.dLW();
    Object localObject2 = com.tencent.mm.plugin.flutter.e.a.a.h.dLS();
    localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    b.x localx = new b.x();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject2).next();
      ((ArrayList)localObject1).add(localEmojiGroupInfo.field_productID);
      localArrayList1.add(localEmojiGroupInfo.field_packName);
      localArrayList2.add(localEmojiGroupInfo.field_packGrayIconUrl);
    }
    localx.by((ArrayList)localObject1);
    localx.bz(localArrayList1);
    localx.bx(localArrayList2);
    AppMethodBeat.o(241002);
    return localx;
  }
  
  public final void dLx()
  {
    AppMethodBeat.i(241010);
    Object localObject1 = com.tencent.mm.plugin.flutter.e.a.a.m.wKB;
    if (com.tencent.mm.plugin.flutter.e.a.a.m.dMe() == null) {
      com.tencent.mm.plugin.flutter.e.a.a.m.a(new com.tencent.mm.plugin.flutter.e.a.a.m((byte)0));
    }
    Object localObject2 = com.tencent.mm.plugin.flutter.e.a.a.m.dMe();
    if (localObject2 == null) {
      kotlin.g.b.p.hyc();
    }
    localObject1 = new ArrayList();
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put("name", "无转场");
    ((HashMap)localObject3).put("data", "wu.svg");
    ((HashMap)localObject3).put("effectPath", "");
    ((ArrayList)localObject1).add(localObject3);
    localObject2 = ((com.tencent.mm.plugin.flutter.e.a.a.m)localObject2).wKy.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (m.b)((Iterator)localObject2).next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("name", ((m.b)localObject3).name);
      localHashMap.put("data", ((m.b)localObject3).wKC);
      localHashMap.put("effectPath", ((m.b)localObject3).assetPath);
      ((ArrayList)localObject1).add(localHashMap);
    }
    localObject2 = o.wKI;
    o.a.dMh().t("onTransitionResourceGetted", localObject1);
    AppMethodBeat.o(241010);
  }
  
  public final b.y dLy()
  {
    AppMethodBeat.i(241012);
    b.y localy = new b.y();
    l.a locala = com.tencent.mm.plugin.flutter.e.a.a.l.wKw;
    localy.w(Boolean.valueOf(l.a.dMc().dMa()));
    AppMethodBeat.o(241012);
    return localy;
  }
  
  public final b.ar dLz()
  {
    AppMethodBeat.i(241013);
    b.ar localar = new b.ar();
    Object localObject = com.tencent.mm.plugin.flutter.e.a.a.n.wKF;
    if (com.tencent.mm.plugin.flutter.e.a.a.n.dMf() == null) {
      com.tencent.mm.plugin.flutter.e.a.a.n.a(new com.tencent.mm.plugin.flutter.e.a.a.n((byte)0));
    }
    localObject = com.tencent.mm.plugin.flutter.e.a.a.n.dMf();
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    if (localObject != null)
    {
      if (!com.tencent.mm.plugin.recordvideo.res.f.BYo.BXZ)
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 16);
        Log.d(((com.tencent.mm.plugin.flutter.e.a.a.n)localObject).vRb, "start to download transition");
        com.tencent.mm.plugin.recordvideo.res.f.BYo.BYa = ((kotlin.g.a.a)new n.b((com.tencent.mm.plugin.flutter.e.a.a.n)localObject));
      }
      com.tencent.mm.plugin.recordvideo.res.f.BYo.bbA();
    }
    for (localObject = Boolean.valueOf(com.tencent.mm.plugin.recordvideo.res.f.BYo.BXZ);; localObject = null)
    {
      localar.w(Boolean.valueOf(((Boolean)localObject).booleanValue()));
      AppMethodBeat.o(241013);
      return localar;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a
 * JD-Core Version:    0.7.0.1
 */