package com.tencent.mm.plugin.biz.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/biz/util/BizDigestUtil;", "", "()V", "DIGEST_INFO_NO_UPDATE", "", "MILLSECONDS_OF_12HOUR", "", "TAG", "", "clickDigestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "getClickDigestInfo", "()Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "setClickDigestInfo", "(Lcom/tencent/mm/protocal/protobuf/DigestInfo;)V", "isShowBoldDigest", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingCustomDigest", "", "getShowingCustomDigest", "()Z", "setShowingCustomDigest", "(Z)V", "getDigestReportInfo", "Lkotlin/Pair;", "digestInfo", "getFinderLiveRedDotDigest", "", "size", "context", "Landroid/content/Context;", "conv", "Lcom/tencent/mm/storage/Conversation;", "getOfficialAccountsDigest", "getStartSpannableString", "Landroid/text/SpannableString;", "imgSpanSize", "isMsgDigestShow", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bold", "isShowBoldDigestOpen", "onClick", "", "onDigestExpose", "saveDigestInfo", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "key", "slot", "setDigestShowCount", "req", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortReq;", "setMsgDigestShow", "BoldDigestShowKey", "DigestKey", "DigestShowKey", "plugin-biz_release"})
public final class a
{
  private static final f lrB;
  private static int shm;
  public static ahs shn;
  private static boolean sho;
  public static final a shp;
  
  static
  {
    AppMethodBeat.i(206947);
    shp = new a();
    lrB = g.ar((kotlin.g.a.a)a.a.shq);
    shm = -1;
    AppMethodBeat.o(206947);
  }
  
  public static CharSequence a(int paramInt, Context paramContext, az paramaz)
  {
    AppMethodBeat.i(206935);
    p.k(paramContext, "context");
    p.k(paramaz, "conv");
    Object localObject1;
    if (!paramaz.rp(128))
    {
      localObject1 = null;
      if ((localObject1 != null) && (!n.ba((CharSequence)localObject1))) {
        break label219;
      }
    }
    label81:
    Object localObject3;
    label209:
    label219:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label224;
      }
      AppMethodBeat.o(206935);
      return localObject1;
      bool1 = paramaz.rp(256);
      localObject1 = paramContext.getResources();
      if (bool1)
      {
        i = b.c.finder_live_red_icon;
        localObject1 = ((Resources)localObject1).getDrawable(i);
        ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
        localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
        localObject3 = new SpannableString((CharSequence)"@");
        ((SpannableString)localObject3).setSpan(localObject1, 0, 1, 33);
        if (!paramaz.rp(32)) {
          break label209;
        }
      }
      for (localObject1 = (CharSequence)c(paramInt, paramContext);; localObject1 = (CharSequence)"")
      {
        localObject1 = TextUtils.concat(new CharSequence[] { (CharSequence)localObject3, localObject1, (CharSequence)paramaz.getDigest() });
        break;
        if (ar.isDarkMode())
        {
          i = b.c.finder_live_grey_icon_dm;
          break label81;
        }
        i = b.c.finder_live_grey_icon;
        break label81;
      }
    }
    label224:
    boolean bool1 = paramaz.rp(16);
    int j;
    label335:
    Object localObject4;
    label452:
    Object localObject5;
    if (!bool1)
    {
      localObject1 = (CharSequence)paramaz.getContent();
      if ((localObject1 == null) || (n.ba((CharSequence)localObject1)))
      {
        i = 1;
        if (i != 0) {
          break label742;
        }
        localObject1 = paramaz.getContent();
        p.j(localObject1, "conv.content");
        if (!n.M((String)localObject1, paramaz.apB() + ":", false)) {
          break label742;
        }
        j = paramaz.getContent().length();
        localObject1 = paramaz.apB();
        if (localObject1 == null) {
          break label668;
        }
        i = ((String)localObject1).length();
        if (j <= i) {
          break label742;
        }
        localObject1 = paramaz.getContent().subSequence(paramaz.apB().length() + 1, paramaz.getContent().length());
        if (localObject1 != null)
        {
          localObject3 = localObject1.toString();
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localObject4 = XmlParser.parseXml((String)localObject1, "digest_items", null);
        if ((localObject4 == null) || (((Map)localObject4).size() <= 1)) {
          break label742;
        }
        boolean bool2 = paramaz.rp(64);
        localObject1 = (CharSequence)"";
        j = (((Map)localObject4).size() - 1) / 3;
        if (j < 0) {
          break label682;
        }
        i = 0;
        localObject5 = new StringBuilder(".digest_items.item");
        if (i != 0) {
          break label673;
        }
        localObject3 = "";
        label472:
        localObject5 = localObject3;
        localObject3 = (String)((Map)localObject4).get((String)localObject5 + ".font_bold");
        localObject5 = (String)((Map)localObject4).get((String)localObject5 + ".content");
        if ((localObject3 == null) || (localObject5 == null)) {
          break label1460;
        }
        localObject5 = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, (CharSequence)localObject5, paramInt);
        if ((bool2) && (p.h(localObject3, "1"))) {
          ((SpannableString)localObject5).setSpan(new BoldForegroundColorSpan(androidx.core.content.a.w(paramContext, b.b.FG_0)), 0, ((SpannableString)localObject5).length(), 17);
        }
        localObject1 = TextUtils.concat(new CharSequence[] { localObject1, (CharSequence)localObject5 });
        p.j(localObject1, "TextUtils.concat(digest, ss)");
      }
    }
    label668:
    label673:
    label682:
    label1067:
    label1073:
    label1460:
    for (;;)
    {
      localObject3 = localObject1;
      if (i != j)
      {
        i += 1;
        break label452;
        i = 0;
        break;
        i = 0;
        break label335;
        localObject3 = Integer.valueOf(i);
        break label472;
        localObject3 = localObject1;
      }
      Log.i("MicroMsg.BizDigestUtil", "getOfficialAccountsDigest digest_items digest: " + (CharSequence)localObject3);
      if ((localObject3 == null) || (n.ba((CharSequence)localObject3))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(206935);
        return localObject3;
      }
      label742:
      if ((bool1) && (paramaz.apz() > 0))
      {
        if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
        {
          i = 1;
          if (i == 0) {
            break label1449;
          }
          localObject3 = (CharSequence)"";
          long l1 = bcJ().decodeLong("BizLastMsgId");
          long l2 = bcJ().decodeLong("BizLastMsgTime");
          localObject4 = (MMKVSlotManager)c.lEh;
          localObject1 = aoK(l1 + '-' + l2);
          localObject4 = (MultiProcessMMKV)((MMKVSlotManager)localObject4).findSlot((String)localObject1);
          if (localObject4 == null) {
            break label1073;
          }
          if (!((MultiProcessMMKV)localObject4).containsKey((String)localObject1)) {
            break label1067;
          }
          localObject1 = ((MultiProcessMMKV)localObject4).decodeBytes((String)localObject1);
          if (localObject1 == null) {
            break label1067;
          }
          if (localObject1.length != 0) {
            break label1037;
          }
          i = 1;
          label894:
          if (i != 0) {
            break label1042;
          }
          i = 1;
          if (i == 0) {
            break label1067;
          }
        }
        for (;;)
        {
          try
          {
            localObject4 = ahs.class.newInstance();
            ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
            localObject1 = (com.tencent.mm.cd.a)localObject4;
            localObject1 = (ahs)localObject1;
            if (localObject1 != null) {
              break label1079;
            }
            sho = false;
            AppMethodBeat.o(206935);
            return null;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
          }
          if (shm != -1)
          {
            if (shm == 1)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          shm = ((b)h.ae(b.class)).a(b.a.vAv, 0);
          Log.i("MicroMsg.BizDigestUtil", "isShowBoldDigestOpen open %d", new Object[] { Integer.valueOf(shm) });
          if (shm == 1)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          i = 0;
          break label894;
          i = 0;
          break label900;
          localObject2 = null;
          continue;
          localObject2 = null;
        }
        Object localObject2 = ((ahs)localObject2).RGi;
        if (localObject2 != null)
        {
          localObject2 = j.l((Iterable)localObject2);
          if (localObject2 != null)
          {
            localObject4 = ((Iterable)localObject2).iterator();
            localObject2 = localObject3;
            for (;;)
            {
              localObject3 = localObject2;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject3 = (aht)((Iterator)localObject4).next();
              localObject5 = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, (CharSequence)((aht)localObject3).lpM, paramInt);
              if (((aht)localObject3).Sst == 1)
              {
                Log.d("MicroMsg.BizDigestUtil", "getOfficialAccountsDigest bold digest " + ((aht)localObject3).lpM);
                ((SpannableString)localObject5).setSpan(new BoldForegroundColorSpan(paramContext.getResources().getColor(b.b.FG_0)), 0, ((SpannableString)localObject5).length(), 17);
              }
              localObject2 = TextUtils.concat(new CharSequence[] { localObject2, (CharSequence)localObject5 });
              p.j(localObject2, "TextUtils.concat(digest, ss)");
            }
          }
        }
        if (((CharSequence)localObject3).length() == 0) {}
        for (i = 1; i != 0; i = 0)
        {
          sho = false;
          AppMethodBeat.o(206935);
          return null;
        }
        Log.d("MicroMsg.BizDigestUtil", "getOfficialAccountsDigest digest " + (CharSequence)localObject3);
        localObject2 = paramContext.getString(b.f.main_conversation_biz_time_line_unread_count, new Object[] { Integer.valueOf(paramaz.apz()) });
        p.j(localObject2, "context.getString(R.stri…_count, conv.unReadCount)");
        sho = true;
        if (paramaz.rp(32))
        {
          paramContext = c(paramInt, paramContext);
          paramContext = TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)paramContext, localObject3 });
          AppMethodBeat.o(206935);
          return paramContext;
        }
        paramContext = TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", localObject3 });
        AppMethodBeat.o(206935);
        return paramContext;
      }
      label1079:
      sho = false;
      AppMethodBeat.o(206935);
      return null;
    }
  }
  
  public static o<String, String> a(ahs paramahs)
  {
    AppMethodBeat.i(206940);
    if (paramahs == null)
    {
      paramahs = new o("", "");
      AppMethodBeat.o(206940);
      return paramahs;
    }
    if (!sho)
    {
      paramahs = new o("", "");
      AppMethodBeat.o(206940);
      return paramahs;
    }
    String str = "";
    Object localObject2 = paramahs.RGi;
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
          localObject1 = (aht)((Iterator)localObject2).next();
          if (((aht)localObject1).Sst == 1)
          {
            CharSequence localCharSequence = (CharSequence)str;
            if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label177;
              }
              str = ((aht)localObject1).lpM;
              p.j(str, "digestItem.digest");
              break;
            }
            label177:
            str = str + ";" + ((aht)localObject1).lpM;
          }
        }
      }
    }
    paramahs = new o(ab.aXb(Util.nullAsNil(paramahs.qJq)), ab.aXb((String)localObject1));
    AppMethodBeat.o(206940);
    return paramahs;
  }
  
  public static o<String, String> a(z paramz)
  {
    Object localObject3 = null;
    AppMethodBeat.i(206936);
    p.k(paramz, "info");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)c.lEh.getSlotForWrite();
    String str = String.valueOf(System.currentTimeMillis() / 43200000L);
    if (!a(paramz, false))
    {
      localMultiProcessMMKV.encode(aoL(str), c.lEh.decodeInt(aoL(str), 0) + 1);
      a(paramz, false, localMultiProcessMMKV);
    }
    Object localObject4 = (MMKVSlotManager)c.lEh;
    Object localObject1 = aoK(paramz.field_msgId + '-' + paramz.field_createTime);
    localObject4 = (MultiProcessMMKV)((MMKVSlotManager)localObject4).findSlot((String)localObject1);
    int i;
    if (localObject4 != null) {
      if (((MultiProcessMMKV)localObject4).containsKey((String)localObject1))
      {
        localObject1 = ((MultiProcessMMKV)localObject4).decodeBytes((String)localObject1);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label233;
            }
            i = 1;
            label169:
            if (i == 0) {
              break label256;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = ahs.class.newInstance();
        ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.cd.a)localObject4;
        localObject4 = (ahs)localObject1;
        if (localObject4 != null) {
          break label266;
        }
        paramz = new o("", "");
        AppMethodBeat.o(206936);
        return paramz;
      }
      catch (Exception localException)
      {
        label233:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label169;
      label256:
      localObject2 = null;
      continue;
      localObject2 = null;
    }
    label266:
    StringBuilder localStringBuilder = new StringBuilder("onDigestExpose digest ");
    Object localObject2 = localObject3;
    if (localObject4 != null) {
      localObject2 = ((ahs)localObject4).qJq;
    }
    Log.d("MicroMsg.BizDigestUtil", (String)localObject2 + " showingCustomDigest=" + sho);
    if (!sho)
    {
      paramz = new o("", "");
      AppMethodBeat.o(206936);
      return paramz;
    }
    localObject2 = ((ahs)localObject4).RGi;
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
          break label413;
        }
        if (((aht)((Iterator)localObject2).next()).Sst != 1) {
          break label475;
        }
        i = 1;
      }
    }
    label413:
    label475:
    for (;;)
    {
      break;
      j = 0;
      if ((j != 0) && (j != 0) && (!a(paramz, true)))
      {
        localMultiProcessMMKV.encode(aoM(str), c.lEh.decodeInt(aoM(str), 0) + 1);
        a(paramz, true, localMultiProcessMMKV);
      }
      paramz = a((ahs)localObject4);
      AppMethodBeat.o(206936);
      return paramz;
    }
  }
  
  public static void a(ahs paramahs, z paramz)
  {
    AppMethodBeat.i(206942);
    p.k(paramz, "info");
    if (paramahs == null)
    {
      AppMethodBeat.o(206942);
      return;
    }
    a(aoK(paramz.field_msgId + '-' + paramz.field_createTime), paramahs, (MultiProcessMMKV)c.lEh.getSlotForWrite());
    AppMethodBeat.o(206942);
  }
  
  private static void a(z paramz, boolean paramBoolean, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(206938);
    paramMultiProcessMMKV.encode("digest_show_" + paramBoolean + '_' + paramz.field_msgId + '_' + paramz.field_createTime, true);
    AppMethodBeat.o(206938);
  }
  
  public static void a(String paramString, ahs paramahs, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(206944);
    try
    {
      paramMultiProcessMMKV.encode(paramString, paramahs.toByteArray());
      AppMethodBeat.o(206944);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo ex " + paramString.getMessage());
      AppMethodBeat.o(206944);
    }
  }
  
  private static boolean a(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(206937);
    paramz = "digest_show_" + paramBoolean + '_' + paramz.field_msgId + '_' + paramz.field_createTime;
    paramBoolean = c.lEh.decodeBool(paramz, false);
    AppMethodBeat.o(206937);
    return paramBoolean;
  }
  
  public static String aoK(String paramString)
  {
    AppMethodBeat.i(206928);
    paramString = "digest_" + paramString + '}';
    AppMethodBeat.o(206928);
    return paramString;
  }
  
  public static String aoL(String paramString)
  {
    AppMethodBeat.i(206930);
    paramString = "digest_show_" + paramString + '}';
    AppMethodBeat.o(206930);
    return paramString;
  }
  
  public static String aoM(String paramString)
  {
    AppMethodBeat.i(206932);
    paramString = "digest_show_bold_" + paramString + '}';
    AppMethodBeat.o(206932);
    return paramString;
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(206933);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(206933);
    return localMultiProcessMMKV;
  }
  
  public static SpannableString c(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(206934);
    p.k(paramContext, "context");
    paramContext = paramContext.getResources().getDrawable(b.c.biz_timeline_star_icon);
    p.j(paramContext, "context.resources.getDra…e.biz_timeline_star_icon)");
    paramContext.setBounds(0, 0, paramInt, paramInt);
    paramContext = new com.tencent.mm.ui.widget.a(paramContext, 1);
    SpannableString localSpannableString = new SpannableString((CharSequence)"@");
    localSpannableString.setSpan(paramContext, 0, 1, 33);
    AppMethodBeat.o(206934);
    return localSpannableString;
  }
  
  public static ahs cxJ()
  {
    return shn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.a
 * JD-Core Version:    0.7.0.1
 */