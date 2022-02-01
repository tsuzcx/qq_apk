package com.tencent.mm.plugin.finder.utils;

import android.util.Base64;
import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.a.k;
import com.tencent.d.a.a.a.b.a.k.a;
import com.tencent.d.a.a.a.b.c.c;
import com.tencent.d.a.a.a.b.c.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/BoxCommon;", "", "()V", "TAG", "", "diskDataLog", "", "tag", "str", "genBoxId", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "boxId", "getNickname", "context", "Landroid/content/Context;", "username", "nickname", "liveDataLog", "localLikeLog", "mainFlowLog", "memDataLog", "redDotFlowLog", "isBoxLive", "", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "isFriend", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "logInfo", "Lcom/tencent/mm/protobuf/ByteString;", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "safeSetValue", "T", "Landroidx/lifecycle/MutableLiveData;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
{
  private static final String TAG;
  public static final bq akii;
  
  static
  {
    AppMethodBeat.i(370219);
    akii = new bq();
    TAG = "Finder.BoxCommon";
    AppMethodBeat.o(370219);
  }
  
  public static boolean B(a parama)
  {
    AppMethodBeat.i(370207);
    s.u(parama, "<this>");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.kLy().bmg()).intValue() == 1)
      {
        AppMethodBeat.o(370207);
        return true;
      }
    }
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.kLz().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(TAG, "eventId:" + ((e)parama.business(e.class)).mIY + ", enable:" + bool);
      int i = ((e)parama.business(e.class)).mIY;
      parama = a.k.akmT;
      if ((i != a.k.a.kMF()) || (!bool)) {
        break;
      }
      AppMethodBeat.o(370207);
      return true;
    }
    AppMethodBeat.o(370207);
    return false;
  }
  
  public static <T> void a(x<T> paramx, kotlin.g.a.b<? super T, ah> paramb)
  {
    AppMethodBeat.i(370217);
    if (paramx != null)
    {
      Object localObject = paramx.getValue();
      if (localObject != null)
      {
        if (paramb != null) {
          paramb.invoke(localObject);
        }
        paramx.setValue(localObject);
      }
    }
    AppMethodBeat.o(370217);
  }
  
  public static bfv bLz(String paramString)
  {
    AppMethodBeat.i(370208);
    s.u(paramString, "boxId");
    bfv localbfv = new bfv();
    c.c.a locala = c.c.aknf;
    localbfv.type = c.c.a.kML();
    localbfv.id = paramString;
    AppMethodBeat.o(370208);
    return localbfv;
  }
  
  public static String c(anc paramanc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(370215);
    s.u(paramanc, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("hashCode:").append(paramanc.hashCode()).append(", liveId:").append(com.tencent.mm.ae.d.hF(paramanc.mMJ)).append(", boxId:");
    Object localObject1 = paramanc.Don;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = localStringBuilder.append(localObject1).append(", lastEnterTimeStamp:").append(paramanc.adlC).append(", dataSize:").append(paramanc.akjP.size()).append(", lastBuffer:");
      paramanc = paramanc.ZEQ;
      if (paramanc != null) {
        break label141;
      }
    }
    label141:
    for (paramanc = localObject2;; paramanc = l(paramanc))
    {
      paramanc = paramanc + '}';
      AppMethodBeat.o(370215);
      return paramanc;
      localObject1 = ((bfv)localObject1).id;
      break;
    }
  }
  
  public static String l(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(370216);
    s.u(paramb, "<this>");
    try
    {
      paramb = Base64.encodeToString(paramb.toByteArray(), 2);
      s.s(paramb, "encodeToString(this.toByteArray(), Base64.NO_WRAP)");
      AppMethodBeat.o(370216);
      return paramb;
    }
    finally
    {
      Log.i("Finder", "ByteString encode failed.");
      AppMethodBeat.o(370216);
    }
    return "";
  }
  
  public static void rP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370209);
    s.u(paramString1, "tag");
    s.u(paramString2, "str");
    Log.i(paramString1, s.X("diskDataLog ", paramString2));
    AppMethodBeat.o(370209);
  }
  
  public static void rQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370210);
    s.u(paramString1, "tag");
    s.u(paramString2, "str");
    Log.i(paramString1, s.X("memDataLog ", paramString2));
    AppMethodBeat.o(370210);
  }
  
  public static void rR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370211);
    s.u(paramString1, "tag");
    s.u(paramString2, "str");
    Log.i(paramString1, s.X("mainFlowLog ", paramString2));
    AppMethodBeat.o(370211);
  }
  
  public static void rS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370212);
    s.u(paramString1, "tag");
    s.u(paramString2, "str");
    Log.i(paramString1, s.X("redDotFlowLog ", paramString2));
    AppMethodBeat.o(370212);
  }
  
  public static void rT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370213);
    s.u(paramString1, "tag");
    s.u(paramString2, "str");
    Log.i(paramString1, s.X("localLikeLog ", paramString2));
    AppMethodBeat.o(370213);
  }
  
  public static void rU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(370214);
    s.u(paramString1, "tag");
    s.u(paramString2, "str");
    Log.i(paramString1, s.X("liveDataLog ", paramString2));
    AppMethodBeat.o(370214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bq
 * JD-Core Version:    0.7.0.1
 */