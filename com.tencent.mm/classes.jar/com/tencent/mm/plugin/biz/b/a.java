package com.tencent.mm.plugin.biz.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.o;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/biz/util/BizDigestUtil;", "", "()V", "DIGEST_INFO_NO_UPDATE", "", "MILLSECONDS_OF_12HOUR", "", "TAG", "", "clickDigestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "getClickDigestInfo", "()Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "setClickDigestInfo", "(Lcom/tencent/mm/protocal/protobuf/DigestInfo;)V", "isShowBoldDigest", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingCustomDigest", "", "getShowingCustomDigest", "()Z", "setShowingCustomDigest", "(Z)V", "getDigestReportInfo", "Lkotlin/Pair;", "digestInfo", "getOfficialAccountsDigest", "", "size", "context", "Landroid/content/Context;", "conv", "Lcom/tencent/mm/storage/Conversation;", "getStartSpannableString", "Landroid/text/SpannableString;", "imgSpanSize", "isMsgDigestShow", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bold", "slot", "isShowBoldDigestOpen", "onClick", "", "onDigestExpose", "saveDigestInfo", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "key", "setDigestShowCount", "req", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortReq;", "setMsgDigestShow", "BoldDigestShowKey", "DigestKey", "DigestShowKey", "plugin-biz_release"})
public final class a
{
  private static final f iBW;
  private static int pfi;
  public static ahh pfj;
  private static boolean pfk;
  public static final a pfl;
  
  static
  {
    AppMethodBeat.i(212452);
    pfl = new a();
    iBW = kotlin.g.ah((kotlin.g.a.a)a.a.pfm);
    pfi = -1;
    AppMethodBeat.o(212452);
  }
  
  public static CharSequence a(int paramInt, Context paramContext, az paramaz)
  {
    AppMethodBeat.i(212445);
    p.h(paramContext, "context");
    p.h(paramaz, "conv");
    if ((paramaz.oV(16)) && (paramaz.ajG() > 0))
    {
      Object localObject2;
      Object localObject4;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
      {
        i = 1;
        if (i == 0) {
          break label698;
        }
        localObject1 = (CharSequence)"";
        long l1 = aTI().decodeLong("BizLastMsgId");
        long l2 = aTI().decodeLong("BizLastMsgTime");
        localObject2 = (MultiProcessMMKV)c.iNQ.getSlot();
        localObject4 = ahe(l1 + '-' + l2);
        if (!((MultiProcessMMKV)localObject2).containsKey((String)localObject4)) {
          break label324;
        }
        localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes((String)localObject4);
        if (localObject2 == null) {
          break label324;
        }
        if (localObject2.length != 0) {
          break label296;
        }
        i = 1;
        label157:
        if (i != 0) {
          break label301;
        }
        i = 1;
        label163:
        if (i == 0) {
          break label324;
        }
      }
      for (;;)
      {
        try
        {
          localObject4 = ahh.class.newInstance();
          ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject2);
          localObject2 = (com.tencent.mm.bw.a)localObject4;
          localObject2 = (ahh)localObject2;
          if (localObject2 != null) {
            break label330;
          }
          pfk = false;
          AppMethodBeat.o(212445);
          return null;
        }
        catch (Exception localException)
        {
          label296:
          label301:
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
        }
        if (pfi != -1)
        {
          if (pfi == 1)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
        pfi = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rTP, 0);
        Log.i("MicroMsg.BizDigestUtil", "isShowBoldDigestOpen open %d", new Object[] { Integer.valueOf(pfi) });
        if (pfi == 1)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        i = 0;
        break label157;
        i = 0;
        break label163;
        label324:
        localObject3 = null;
      }
      label330:
      Object localObject3 = ((ahh)localObject3).KEQ;
      if (localObject3 != null)
      {
        localObject3 = j.l((Iterable)localObject3);
        if (localObject3 != null)
        {
          localObject4 = ((Iterable)localObject3).iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject3 = (ahi)((Iterator)localObject4).next();
            SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, (CharSequence)((ahi)localObject3).iAq, paramInt);
            if (((ahi)localObject3).LqW == 1)
            {
              Log.d("MicroMsg.BizDigestUtil", "getOfficialAccountsDigest bold digest " + ((ahi)localObject3).iAq);
              localSpannableString.setSpan(new BoldForegroundColorSpan(paramContext.getResources().getColor(2131099746)), 0, localSpannableString.length(), 17);
            }
            localObject1 = TextUtils.concat(new CharSequence[] { localObject1, (CharSequence)localSpannableString });
            p.g(localObject1, "TextUtils.concat(digest, ss)");
          }
        }
      }
      localObject3 = localObject1;
      if (((CharSequence)localObject3).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        pfk = false;
        AppMethodBeat.o(212445);
        return null;
      }
      Log.d("MicroMsg.BizDigestUtil", "getOfficialAccountsDigest digest " + (CharSequence)localObject3);
      Object localObject1 = paramContext.getString(2131762820, new Object[] { Integer.valueOf(paramaz.ajG()) });
      p.g(localObject1, "context.getString(R.stri…_count, conv.unReadCount)");
      pfk = true;
      if (paramaz.oV(32))
      {
        paramContext = c(paramInt, paramContext);
        paramContext = TextUtils.concat(new CharSequence[] { (CharSequence)localObject1, (CharSequence)" ", (CharSequence)paramContext, localObject3 });
        AppMethodBeat.o(212445);
        return paramContext;
      }
      paramContext = TextUtils.concat(new CharSequence[] { (CharSequence)localObject1, (CharSequence)" ", localObject3 });
      AppMethodBeat.o(212445);
      return paramContext;
    }
    label698:
    pfk = false;
    AppMethodBeat.o(212445);
    return null;
  }
  
  public static o<String, String> a(ahh paramahh)
  {
    AppMethodBeat.i(212449);
    if (paramahh == null)
    {
      paramahh = new o("", "");
      AppMethodBeat.o(212449);
      return paramahh;
    }
    if (!pfk)
    {
      paramahh = new o("", "");
      AppMethodBeat.o(212449);
      return paramahh;
    }
    String str = "";
    Object localObject2 = paramahh.KEQ;
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = j.l((Iterable)localObject2);
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          localObject1 = str;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (ahi)((Iterator)localObject2).next();
          if (((ahi)localObject1).LqW == 1)
          {
            CharSequence localCharSequence = (CharSequence)str;
            if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label177;
              }
              str = ((ahi)localObject1).iAq;
              p.g(str, "digestItem.digest");
              break;
            }
            label177:
            str = str + ";" + ((ahi)localObject1).iAq;
          }
        }
      }
    }
    paramahh = new o(com.tencent.mm.pluginsdk.ui.tools.z.bfG(Util.nullAsNil(paramahh.nHe)), com.tencent.mm.pluginsdk.ui.tools.z.bfG((String)localObject1));
    AppMethodBeat.o(212449);
    return paramahh;
  }
  
  public static o<String, String> a(com.tencent.mm.storage.z paramz)
  {
    Object localObject3 = null;
    AppMethodBeat.i(212446);
    p.h(paramz, "info");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)c.iNQ.getSlot();
    String str = String.valueOf(System.currentTimeMillis() / 43200000L);
    if (!a(paramz, false, localMultiProcessMMKV))
    {
      localMultiProcessMMKV.encode(ahf(str), localMultiProcessMMKV.decodeInt(ahf(str), 0) + 1);
      b(paramz, false, localMultiProcessMMKV);
    }
    Object localObject1 = ahe(paramz.field_msgId + '-' + paramz.field_createTime);
    int i;
    if (localMultiProcessMMKV.containsKey((String)localObject1))
    {
      localObject1 = localMultiProcessMMKV.decodeBytes((String)localObject1);
      if (localObject1 != null) {
        if (localObject1.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label209;
          }
          i = 1;
          label146:
          if (i == 0) {
            break label230;
          }
        }
      }
    }
    Object localObject4;
    for (;;)
    {
      try
      {
        localObject4 = ahh.class.newInstance();
        ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject4;
        localObject4 = (ahh)localObject1;
        if (localObject4 != null) {
          break label235;
        }
        paramz = new o("", "");
        AppMethodBeat.o(212446);
        return paramz;
      }
      catch (Exception localException)
      {
        label209:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label146;
      label230:
      localObject2 = null;
    }
    label235:
    StringBuilder localStringBuilder = new StringBuilder("onDigestExpose digest ");
    Object localObject2 = localObject3;
    if (localObject4 != null) {
      localObject2 = ((ahh)localObject4).nHe;
    }
    Log.d("MicroMsg.BizDigestUtil", (String)localObject2 + " showingCustomDigest=" + pfk);
    if (!pfk)
    {
      paramz = new o("", "");
      AppMethodBeat.o(212446);
      return paramz;
    }
    localObject2 = ((ahh)localObject4).KEQ;
    int j;
    if (localObject2 != null)
    {
      localObject2 = j.l((Iterable)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break label381;
        }
        if (((ahi)((Iterator)localObject2).next()).LqW != 1) {
          break label444;
        }
        i = 1;
      }
    }
    label444:
    for (;;)
    {
      break;
      j = 0;
      label381:
      if ((j != 0) && (j != 0) && (!a(paramz, true, localMultiProcessMMKV)))
      {
        localMultiProcessMMKV.encode(ahg(str), localMultiProcessMMKV.decodeInt(ahg(str), 0) + 1);
        b(paramz, true, localMultiProcessMMKV);
      }
      paramz = a((ahh)localObject4);
      AppMethodBeat.o(212446);
      return paramz;
    }
  }
  
  public static void a(ahh paramahh, com.tencent.mm.storage.z paramz)
  {
    AppMethodBeat.i(212450);
    p.h(paramz, "info");
    if (paramahh == null)
    {
      AppMethodBeat.o(212450);
      return;
    }
    a(ahe(paramz.field_msgId + '-' + paramz.field_createTime), paramahh, (MultiProcessMMKV)c.iNQ.getSlot());
    AppMethodBeat.o(212450);
  }
  
  public static void a(String paramString, ahh paramahh, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(212451);
    try
    {
      paramMultiProcessMMKV.encode(paramString, paramahh.toByteArray());
      AppMethodBeat.o(212451);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo ex " + paramString.getMessage());
      AppMethodBeat.o(212451);
    }
  }
  
  private static boolean a(com.tencent.mm.storage.z paramz, boolean paramBoolean, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(212447);
    paramBoolean = paramMultiProcessMMKV.decodeBool("digest_show_" + paramBoolean + '_' + paramz.field_msgId + '_' + paramz.field_createTime, false);
    AppMethodBeat.o(212447);
    return paramBoolean;
  }
  
  public static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(212443);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(212443);
    return localMultiProcessMMKV;
  }
  
  public static String ahe(String paramString)
  {
    AppMethodBeat.i(212440);
    paramString = "digest_" + paramString + '}';
    AppMethodBeat.o(212440);
    return paramString;
  }
  
  public static String ahf(String paramString)
  {
    AppMethodBeat.i(212441);
    paramString = "digest_show_" + paramString + '}';
    AppMethodBeat.o(212441);
    return paramString;
  }
  
  public static String ahg(String paramString)
  {
    AppMethodBeat.i(212442);
    paramString = "digest_show_bold_" + paramString + '}';
    AppMethodBeat.o(212442);
    return paramString;
  }
  
  private static void b(com.tencent.mm.storage.z paramz, boolean paramBoolean, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(212448);
    paramMultiProcessMMKV.encode("digest_show_" + paramBoolean + '_' + paramz.field_msgId + '_' + paramz.field_createTime, true);
    AppMethodBeat.o(212448);
  }
  
  public static SpannableString c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(212444);
    p.h(paramContext, "context");
    paramContext = paramContext.getResources().getDrawable(2131231352);
    p.g(paramContext, "context.resources.getDra…e.biz_timeline_star_icon)");
    paramContext.setBounds(0, 0, paramInt, paramInt);
    paramContext = new com.tencent.mm.ui.widget.a(paramContext);
    SpannableString localSpannableString = new SpannableString((CharSequence)"@");
    localSpannableString.setSpan(paramContext, 0, 1, 33);
    AppMethodBeat.o(212444);
    return localSpannableString;
  }
  
  public static ahh ckr()
  {
    return pfj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.a
 * JD-Core Version:    0.7.0.1
 */