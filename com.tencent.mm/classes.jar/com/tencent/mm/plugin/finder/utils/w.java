package com.tencent.mm.plugin.finder.utils;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.h;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderLiveMpLinkVerifier;", "", "()V", "ERROR_CODE_OK", "", "getERROR_CODE_OK", "()I", "ERROR_CODE_OUT_OF_TIME", "getERROR_CODE_OUT_OF_TIME", "ERROR_CODE_PARSE_FAILED", "getERROR_CODE_PARSE_FAILED", "ERROR_CODE_SVR_RESULT_INVALID", "getERROR_CODE_SVR_RESULT_INVALID", "ERROR_CODE_URL_INVALID", "getERROR_CODE_URL_INVALID", "TAG", "", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "setPattern", "(Ljava/util/regex/Pattern;)V", "pattern2", "getPattern2", "setPattern2", "match", "p", "html", "verify", "", "type", "link", "onResult", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "url", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsArticleItem;", "articleItem", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  private static final int ABu = 0;
  private static final int ABv;
  private static final int ABw;
  private static final int ABx;
  private static final int ABy;
  public static final w GgV;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333748);
    GgV = new w();
    TAG = "Finder.FinderLiveMpLinkVerifier";
    ABv = -100;
    ABw = -200;
    ABx = -300;
    ABy = -400;
    AppMethodBeat.o(333748);
  }
  
  private static final ah a(r paramr, String paramString, b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(333723);
    s.u(paramr, "$onResult");
    s.u(paramString, "$link");
    Object localObject1;
    label64:
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (parama == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label325;
        }
        localObject1 = aw.Gjk;
        if (aw.bgV())
        {
          if (parama != null) {
            break label198;
          }
          localObject1 = null;
          localObject1 = (CharSequence)localObject1;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label246;
          }
          i = 1;
          label88:
          if (i != 0) {
            aa.makeText(MMApplicationContext.getContext(), (CharSequence)"img is empty", 0).show();
          }
        }
        String str = TAG;
        if (parama != null) {
          break label251;
        }
        localObject1 = null;
        label119:
        Log.i(str, s.X("imgUrl: ", localObject1));
        i = ABu;
        if (parama != null) {
          break label299;
        }
        parama = localObject2;
        label142:
        paramr.a(Integer.valueOf(i), "", paramString, parama);
      }
    }
    for (;;)
    {
      paramr = ah.aiuX;
      AppMethodBeat.o(333723);
      return paramr;
      localObject1 = (byw)parama.ott;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((byw)localObject1).aahT;
      break;
      label198:
      localObject1 = (byw)parama.ott;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label64;
      }
      localObject1 = ((byw)localObject1).aahT;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label64;
      }
      localObject1 = ((byt)localObject1).aahQ;
      break label64;
      label246:
      i = 0;
      break label88;
      label251:
      localObject1 = (byw)parama.ott;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label119;
      }
      localObject1 = ((byw)localObject1).aahT;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label119;
      }
      localObject1 = ((byt)localObject1).aahQ;
      break label119;
      label299:
      localObject1 = (byw)parama.ott;
      parama = localObject2;
      if (localObject1 == null) {
        break label142;
      }
      parama = ((byw)localObject1).aahT;
      break label142;
      label325:
      paramr.a(Integer.valueOf(ABy), "", "", null);
      continue;
      paramr.a(Integer.valueOf(parama.errCode), parama.errMsg, "", null);
    }
  }
  
  public static void a(int paramInt, String paramString, r<? super Integer, ? super String, ? super String, ? super byt, ah> paramr)
  {
    AppMethodBeat.i(370230);
    s.u(paramString, "link");
    s.u(paramr, "onResult");
    h.ahAA.bm(new w..ExternalSyntheticLambda1(paramString, paramInt, paramr));
    AppMethodBeat.o(370230);
  }
  
  private static final void a(String paramString, int paramInt, r paramr)
  {
    AppMethodBeat.i(370231);
    s.u(paramString, "$link");
    s.u(paramr, "$onResult");
    Log.i(TAG, s.X("verify ", paramString));
    Object localObject2;
    Object localObject1;
    Object localObject3;
    try
    {
      localObject2 = com.tencent.mm.k.i.aRC().getValue("FinderExtendedReadingPrefix");
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = "https://" + WeChatHosts.domainString(p.h.host_mp_weixin_qq_com) + ';';
      }
      s.s(localObject1, "prefixs");
      localObject2 = (Iterable)n.a((CharSequence)n.bq((CharSequence)localObject1).toString(), new char[] { ';' }, 0, 6);
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        String str;
        Log.printErrStackTrace(TAG, (Throwable)paramString, "MalformedURLException", new Object[0]);
        paramr.a(Integer.valueOf(ABv), "", "", null);
        AppMethodBeat.o(370231);
        return;
        if (Util.isNullOrNil(n.bq((CharSequence)str).toString())) {
          break;
        }
        i = 1;
        if (i != 0) {
          ((Collection)localObject1).add(localObject3);
        }
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramString, "IOException", new Object[0]);
        paramr.a(Integer.valueOf(ABx), null, "", null);
        AppMethodBeat.o(370231);
        return;
        i = 0;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label455;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = paramString.toLowerCase();
      s.s(localObject3, "(this as java.lang.String).toLowerCase()");
      if (localObject2 != null) {
        break label430;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(370231);
      throw paramString;
    }
    finally
    {
      Log.printErrStackTrace(TAG, paramString, "Throwable", new Object[0]);
      paramr.a(Integer.valueOf(ABx), "", "", null);
      AppMethodBeat.o(370231);
      return;
    }
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      str = (String)localObject3;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(370231);
        throw paramString;
      }
    }
    int i;
    for (;;)
    {
      label430:
      if (n.U((String)localObject3, n.bq((CharSequence)localObject2).toString(), false)) {
        i = 1;
      }
    }
    label455:
    if (i != 0)
    {
      localObject1 = av.AAI;
      new av(paramInt, paramString, av.dVq()).bFJ().g(new w..ExternalSyntheticLambda0(paramr, paramString));
      AppMethodBeat.o(370231);
      return;
    }
    Log.i(TAG, "scheme or host not valid");
    paramr.a(Integer.valueOf(ABv), "", "", null);
    AppMethodBeat.o(370231);
  }
  
  public static int dVx()
  {
    return ABu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.w
 * JD-Core Version:    0.7.0.1
 */