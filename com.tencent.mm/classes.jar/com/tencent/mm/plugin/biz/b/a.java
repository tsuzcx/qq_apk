package com.tencent.mm.plugin.biz.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/biz/util/BizDigestUtil;", "", "()V", "DIGEST_INFO_NO_UPDATE", "", "MILLSECONDS_OF_12HOUR", "", "TAG", "", "clickDigestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "getClickDigestInfo", "()Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "setClickDigestInfo", "(Lcom/tencent/mm/protocal/protobuf/DigestInfo;)V", "isShowBoldDigest", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingCustomDigest", "", "getShowingCustomDigest", "()Z", "setShowingCustomDigest", "(Z)V", "getDigestReportInfo", "Lkotlin/Pair;", "digestInfo", "getFinderLiveRedDotDigest", "", "size", "context", "Landroid/content/Context;", "conv", "Lcom/tencent/mm/storage/Conversation;", "getOfficialAccountsDigest", "getStartSpannableString", "Landroid/text/SpannableString;", "imgSpanSize", "isMsgDigestShow", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bold", "isShowBoldDigestOpen", "onClick", "", "onDigestExpose", "saveDigestInfo", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "key", "slot", "setDigestShowCount", "req", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortReq;", "setMsgDigestShow", "BoldDigestShowKey", "DigestKey", "DigestShowKey", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final j exj;
  public static final a vtj;
  private static int vtk;
  public static akj vtl;
  private static boolean vtm;
  
  static
  {
    AppMethodBeat.i(260780);
    vtj = new a();
    exj = k.cm((kotlin.g.a.a)a.a.vtn);
    vtk = -1;
    AppMethodBeat.o(260780);
  }
  
  public static CharSequence a(int paramInt, Context paramContext, bb parambb)
  {
    AppMethodBeat.i(260733);
    s.u(paramContext, "context");
    s.u(parambb, "conv");
    Object localObject1;
    if (!parambb.rx(128))
    {
      localObject1 = null;
      if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
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
      AppMethodBeat.o(260733);
      return localObject1;
      bool1 = parambb.rx(256);
      localObject1 = paramContext.getResources();
      if (bool1)
      {
        i = b.c.finder_live_red_icon;
        localObject1 = ((Resources)localObject1).getDrawable(i);
        ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
        localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
        localObject3 = new SpannableString((CharSequence)"@");
        ((SpannableString)localObject3).setSpan(localObject1, 0, 1, 33);
        if (!parambb.rx(32)) {
          break label209;
        }
      }
      for (localObject1 = (CharSequence)e(paramInt, paramContext);; localObject1 = (CharSequence)"")
      {
        localObject1 = TextUtils.concat(new CharSequence[] { (CharSequence)localObject3, localObject1, (CharSequence)parambb.field_digest });
        break;
        if (aw.isDarkMode())
        {
          i = b.c.finder_live_grey_icon_dm;
          break label81;
        }
        i = b.c.finder_live_grey_icon;
        break label81;
      }
    }
    label224:
    boolean bool1 = parambb.rx(16);
    int j;
    label318:
    label358:
    Object localObject4;
    label423:
    label431:
    Object localObject5;
    if (!bool1)
    {
      localObject1 = (CharSequence)parambb.field_content;
      if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
      {
        i = 1;
        if (i != 0) {
          break label674;
        }
        localObject1 = parambb.field_content;
        s.s(localObject1, "conv.content");
        if (!n.U((String)localObject1, s.X(parambb.field_digestUser, ":"), false)) {
          break label674;
        }
        j = parambb.field_content.length();
        localObject1 = parambb.field_digestUser;
        if (localObject1 != null) {
          break label628;
        }
        i = 0;
        if (j <= i) {
          break label674;
        }
        localObject1 = parambb.field_content.subSequence(parambb.field_digestUser.length() + 1, parambb.field_content.length());
        if (localObject1 != null) {
          break label637;
        }
        localObject1 = "";
        localObject4 = XmlParser.parseXml((String)localObject1, "digest_items", null);
        if ((localObject4 == null) || (((Map)localObject4).size() <= 1)) {
          break label674;
        }
        boolean bool2 = parambb.rx(64);
        localObject1 = (CharSequence)"";
        j = (((Map)localObject4).size() - 1) / 3;
        localObject3 = localObject1;
        if (j >= 0)
        {
          i = 0;
          if (i != 0) {
            break label660;
          }
          localObject3 = "";
          localObject5 = s.X(".digest_items.item", localObject3);
          localObject3 = (String)((Map)localObject4).get(s.X((String)localObject5, ".font_bold"));
          localObject5 = (String)((Map)localObject4).get(s.X((String)localObject5, ".content"));
          if ((localObject3 == null) || (localObject5 == null)) {
            break label1391;
          }
          localObject5 = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, (CharSequence)localObject5, paramInt);
          if ((bool2) && (s.p(localObject3, "1"))) {
            ((SpannableString)localObject5).setSpan(new BoldForegroundColorSpan(androidx.core.content.a.w(paramContext, b.b.FG_0)), 0, ((SpannableString)localObject5).length(), 17);
          }
          localObject1 = TextUtils.concat(new CharSequence[] { localObject1, (CharSequence)localObject5 });
          s.s(localObject1, "concat(digest, ss)");
        }
      }
    }
    label660:
    label674:
    label933:
    label977:
    label1002:
    label1391:
    for (;;)
    {
      if (i == j)
      {
        localObject3 = localObject1;
        Log.i("MicroMsg.BizDigestUtil", s.X("getOfficialAccountsDigest digest_items digest: ", localObject3));
        if (n.bp((CharSequence)localObject3)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label674;
          }
          AppMethodBeat.o(260733);
          return localObject3;
          i = 0;
          break;
          label628:
          i = ((String)localObject1).length();
          break label318;
          label637:
          localObject3 = localObject1.toString();
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label358;
          }
          localObject1 = "";
          break label358;
          localObject3 = Integer.valueOf(i);
          break label431;
        }
        Object localObject2;
        if ((bool1) && (parambb.field_unReadCount > 0))
        {
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
          {
            i = 1;
            if (i == 0) {
              break label1366;
            }
            localObject3 = "";
            long l1 = atj().decodeLong("BizLastMsgId");
            long l2 = atj().decodeLong("BizLastMsgTime");
            localObject4 = (MMKVSlotManager)com.tencent.mm.an.c.ovO;
            localObject1 = aig(l1 + '-' + l2);
            localObject4 = (MultiProcessMMKV)((MMKVSlotManager)localObject4).findSlot((String)localObject1);
            if (localObject4 != null) {
              break label901;
            }
          }
          for (localObject1 = null;; localObject2 = null)
          {
            localObject1 = (akj)localObject1;
            if (localObject1 != null) {
              break label1008;
            }
            vtm = false;
            AppMethodBeat.o(260733);
            return null;
            if (vtk != -1)
            {
              if (vtk == 1)
              {
                i = 1;
                break;
              }
              i = 0;
              break;
            }
            vtk = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOl, 0);
            Log.i("MicroMsg.BizDigestUtil", "isShowBoldDigestOpen open %d", new Object[] { Integer.valueOf(vtk) });
            if (vtk == 1)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            if (((MultiProcessMMKV)localObject4).containsKey((String)localObject1))
            {
              localObject1 = ((MultiProcessMMKV)localObject4).decodeBytes((String)localObject1);
              if (localObject1 != null)
              {
                if (localObject1.length == 0)
                {
                  i = 1;
                  if (i != 0) {
                    break label977;
                  }
                }
                for (i = 1;; i = 0)
                {
                  for (;;)
                  {
                    if (i == 0) {
                      break label1002;
                    }
                    try
                    {
                      localObject4 = akj.class.newInstance();
                      ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
                      localObject1 = (com.tencent.mm.bx.a)localObject4;
                    }
                    catch (Exception localException)
                    {
                      Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
                    }
                  }
                  i = 0;
                  break label933;
                }
              }
            }
          }
          label1008:
          localObject2 = ((akj)localObject2).YCW;
          if (localObject2 == null) {
            break label1377;
          }
          localObject2 = kotlin.a.p.l((Iterable)localObject2);
          if (localObject2 == null) {
            break label1377;
          }
          localObject4 = ((Iterable)localObject2).iterator();
          localObject2 = localObject3;
          while (((Iterator)localObject4).hasNext())
          {
            localObject3 = (akk)((Iterator)localObject4).next();
            localObject5 = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, (CharSequence)((akk)localObject3).nUO, paramInt);
            if (((akk)localObject3).ZrB == 1)
            {
              Log.d("MicroMsg.BizDigestUtil", s.X("getOfficialAccountsDigest bold digest ", ((akk)localObject3).nUO));
              ((SpannableString)localObject5).setSpan(new BoldForegroundColorSpan(paramContext.getResources().getColor(b.b.FG_0)), 0, ((SpannableString)localObject5).length(), 17);
            }
            localObject2 = TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)localObject5 });
            s.s(localObject2, "concat(digest, ss)");
          }
        }
        for (;;)
        {
          if (((CharSequence)localObject2).length() == 0) {}
          for (i = 1; i != 0; i = 0)
          {
            vtm = false;
            AppMethodBeat.o(260733);
            return null;
          }
          Log.d("MicroMsg.BizDigestUtil", s.X("getOfficialAccountsDigest digest ", localObject2));
          localObject3 = paramContext.getString(b.f.main_conversation_biz_time_line_unread_count, new Object[] { Integer.valueOf(parambb.field_unReadCount) });
          s.s(localObject3, "context.getString(R.stri…_count, conv.unReadCount)");
          vtm = true;
          if (parambb.rx(32))
          {
            paramContext = e(paramInt, paramContext);
            paramContext = TextUtils.concat(new CharSequence[] { (CharSequence)localObject3, (CharSequence)" ", (CharSequence)paramContext, (CharSequence)localObject2 });
            AppMethodBeat.o(260733);
            return paramContext;
          }
          paramContext = TextUtils.concat(new CharSequence[] { (CharSequence)localObject3, (CharSequence)" ", (CharSequence)localObject2 });
          AppMethodBeat.o(260733);
          return paramContext;
          vtm = false;
          AppMethodBeat.o(260733);
          return null;
          localObject2 = "";
        }
      }
      i += 1;
      break label423;
    }
  }
  
  public static r<String, String> a(akj paramakj)
  {
    AppMethodBeat.i(260761);
    if (paramakj == null)
    {
      paramakj = new r("", "");
      AppMethodBeat.o(260761);
      return paramakj;
    }
    if (!vtm)
    {
      paramakj = new r("", "");
      AppMethodBeat.o(260761);
      return paramakj;
    }
    String str = "";
    Object localObject2 = paramakj.YCW;
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = kotlin.a.p.l((Iterable)localObject2);
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
          localObject1 = (akk)((Iterator)localObject2).next();
          if (((akk)localObject1).ZrB == 1)
          {
            CharSequence localCharSequence = (CharSequence)str;
            if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label177;
              }
              str = ((akk)localObject1).nUO;
              s.s(str, "digestItem.digest");
              break;
            }
            label177:
            str = str + ';' + ((akk)localObject1).nUO;
          }
        }
      }
    }
    paramakj = new r(aa.aUC(Util.nullAsNil(paramakj.tNT)), aa.aUC((String)localObject1));
    AppMethodBeat.o(260761);
    return paramakj;
  }
  
  public static void a(akj paramakj, ab paramab)
  {
    AppMethodBeat.i(260772);
    s.u(paramab, "info");
    if (paramakj == null)
    {
      AppMethodBeat.o(260772);
      return;
    }
    a(aig(paramab.field_msgId + '-' + paramab.field_createTime), paramakj, (MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite());
    AppMethodBeat.o(260772);
  }
  
  public static void a(pz parampz, ab paramab)
  {
    int i = 1;
    AppMethodBeat.i(260766);
    s.u(parampz, "item");
    s.u(paramab, "info");
    String str = aig(paramab.field_msgId + '-' + paramab.field_createTime);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)com.tencent.mm.an.c.ovO.findSlot(str);
    if ((parampz.YUs == null) || (Util.isNullOrNil((List)parampz.YUs.YCW)))
    {
      if ((localMultiProcessMMKV != null) && (localMultiProcessMMKV.containsKey(str) == true)) {}
      for (;;)
      {
        if (i != 0)
        {
          if (localMultiProcessMMKV != null) {
            localMultiProcessMMKV.removeValueForKey(str);
          }
          Log.i("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo remove " + paramab.field_msgId + "  " + paramab.field_bizClientMsgId);
        }
        AppMethodBeat.o(260766);
        return;
        i = 0;
      }
    }
    if ((parampz.eQp & 0x1) != 0)
    {
      if ((localMultiProcessMMKV != null) && (localMultiProcessMMKV.containsKey(str) == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.d("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo not update " + paramab.field_msgId + "  " + paramab.field_bizClientMsgId);
        AppMethodBeat.o(260766);
        return;
      }
    }
    Log.i("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo " + paramab.field_msgId + "  " + paramab.field_bizClientMsgId);
    parampz = parampz.YUs;
    s.s(parampz, "item.digest_info");
    a(str, parampz, (MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite());
    AppMethodBeat.o(260766);
  }
  
  private static void a(ab paramab, boolean paramBoolean, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(260756);
    paramMultiProcessMMKV.encode("digest_show_" + paramBoolean + '_' + paramab.field_msgId + '_' + paramab.field_createTime, true);
    AppMethodBeat.o(260756);
  }
  
  private static void a(String paramString, akj paramakj, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(260775);
    try
    {
      paramMultiProcessMMKV.encode(paramString, paramakj.toByteArray());
      AppMethodBeat.o(260775);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.BizDigestUtil", s.X("saveWebViewAlbumInfoInfo ex ", paramString.getMessage()));
      AppMethodBeat.o(260775);
    }
  }
  
  private static boolean a(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(260747);
    paramab = "digest_show_" + paramBoolean + '_' + paramab.field_msgId + '_' + paramab.field_createTime;
    paramBoolean = com.tencent.mm.an.c.ovO.decodeBool(paramab, false);
    AppMethodBeat.o(260747);
    return paramBoolean;
  }
  
  public static String aig(String paramString)
  {
    AppMethodBeat.i(260682);
    paramString = "digest_" + paramString + '}';
    AppMethodBeat.o(260682);
    return paramString;
  }
  
  public static String aih(String paramString)
  {
    AppMethodBeat.i(260690);
    paramString = "digest_show_" + paramString + '}';
    AppMethodBeat.o(260690);
    return paramString;
  }
  
  public static String aii(String paramString)
  {
    AppMethodBeat.i(260697);
    paramString = "digest_show_bold_" + paramString + '}';
    AppMethodBeat.o(260697);
    return paramString;
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(260703);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(260703);
    return localMultiProcessMMKV;
  }
  
  public static r<String, String> b(ab paramab)
  {
    AppMethodBeat.i(260740);
    s.u(paramab, "info");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)com.tencent.mm.an.c.ovO.getSlotForWrite();
    String str = String.valueOf(System.currentTimeMillis() / 43200000L);
    if (!a(paramab, false))
    {
      localMultiProcessMMKV.encode(aih(str), com.tencent.mm.an.c.ovO.decodeInt(aih(str), 0) + 1);
      a(paramab, false, localMultiProcessMMKV);
    }
    Object localObject2 = (MMKVSlotManager)com.tencent.mm.an.c.ovO;
    Object localObject1 = aig(paramab.field_msgId + '-' + paramab.field_createTime);
    localObject2 = (MultiProcessMMKV)((MMKVSlotManager)localObject2).findSlot((String)localObject1);
    if (localObject2 == null) {}
    int i;
    label191:
    label233:
    akj localakj;
    label256:
    for (localObject1 = null;; localakj = null)
    {
      localObject1 = (akj)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramab = new r("", "");
      AppMethodBeat.o(260740);
      return paramab;
      if (((MultiProcessMMKV)localObject2).containsKey((String)localObject1))
      {
        localObject1 = ((MultiProcessMMKV)localObject2).decodeBytes((String)localObject1);
        if (localObject1 != null)
        {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label233;
            }
          }
          for (i = 1;; i = 0)
          {
            for (;;)
            {
              if (i == 0) {
                break label256;
              }
              try
              {
                localObject2 = akj.class.newInstance();
                ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject1);
                localObject1 = (com.tencent.mm.bx.a)localObject2;
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
              }
            }
            i = 0;
            break label191;
          }
        }
      }
    }
    Log.d("MicroMsg.BizDigestUtil", "onDigestExpose digest " + localakj.tNT + " showingCustomDigest=" + vtm);
    if (!vtm)
    {
      paramab = new r("", "");
      AppMethodBeat.o(260740);
      return paramab;
    }
    localObject2 = localakj.YCW;
    int j;
    if (localObject2 != null)
    {
      localObject2 = kotlin.a.p.l((Iterable)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break label401;
        }
        if (((akk)((Iterator)localObject2).next()).ZrB != 1) {
          break label462;
        }
        i = 1;
      }
    }
    label401:
    label462:
    for (;;)
    {
      break;
      j = 0;
      if ((j != 0) && (j != 0) && (!a(paramab, true)))
      {
        localMultiProcessMMKV.encode(aii(str), com.tencent.mm.an.c.ovO.decodeInt(aii(str), 0) + 1);
        a(paramab, true, localMultiProcessMMKV);
      }
      paramab = a(localakj);
      AppMethodBeat.o(260740);
      return paramab;
    }
  }
  
  public static akj daz()
  {
    return vtl;
  }
  
  public static SpannableString e(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(260716);
    s.u(paramContext, "context");
    paramContext = paramContext.getResources().getDrawable(b.c.biz_timeline_star_icon);
    s.s(paramContext, "context.resources.getDra…e.biz_timeline_star_icon)");
    paramContext.setBounds(0, 0, paramInt, paramInt);
    paramContext = new com.tencent.mm.ui.widget.a(paramContext, 1);
    SpannableString localSpannableString = new SpannableString((CharSequence)"@");
    localSpannableString.setSpan(paramContext, 0, 1, 33);
    AppMethodBeat.o(260716);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.a
 * JD-Core Version:    0.7.0.1
 */