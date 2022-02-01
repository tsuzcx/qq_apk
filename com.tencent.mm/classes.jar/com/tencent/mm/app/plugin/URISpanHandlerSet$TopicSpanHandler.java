package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.f.b.a.od;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.protocal.protobuf.eqn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

@URISpanHandlerSet.a
class URISpanHandlerSet$TopicSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$TopicSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  private static String a(int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(201134);
    if ((paramInt1 == 3) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = paramString.split("#");
      if ((arrayOfString != null) && (arrayOfString.length >= 2))
      {
        Object localObject = arrayOfString[1];
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.equals("0", (CharSequence)localObject))) {
          paramInt1 = 1;
        }
        while ((paramInt1 != 0) && (paramInt2 != 0))
        {
          Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "need correct feeId");
          localObject = aj.fOI().agI(paramInt2);
          if ((localObject != null) && (((SnsInfo)localObject).field_snsId != 0L))
          {
            arrayOfString[1] = t.Qu(((SnsInfo)localObject).field_snsId);
            paramString = new StringBuilder();
            paramInt1 = i;
            for (;;)
            {
              if (paramInt1 < arrayOfString.length)
              {
                paramString.append(arrayOfString[paramInt1]);
                if (paramInt1 != arrayOfString.length - 1) {
                  paramString.append("#");
                }
                paramInt1 += 1;
                continue;
                paramInt1 = 0;
                break;
              }
            }
            paramString = paramString.toString();
            AppMethodBeat.o(201134);
            return paramString;
          }
        }
      }
    }
    AppMethodBeat.o(201134);
    return paramString;
  }
  
  public static void a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, String paramString)
  {
    AppMethodBeat.i(201132);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (eqn)a.a.ga(paramView);
    Log.i("MicroMsg.URISpanHandlerSet", "TopicSpanHandler click %s %s", new Object[] { paramu.url, localObject });
    int j = 0;
    paramView = "";
    long l = cm.bfF();
    int i;
    if (localObject != null)
    {
      j = ((eqn)localObject).UsY;
      paramView = ((eqn)localObject).UsZ;
      l = ((eqn)localObject).RMZ;
      i = ((eqn)localObject).Uta;
      paramView = a(j, paramView, ((eqn)localObject).Utc);
    }
    for (;;)
    {
      localObject = paramu.url;
      paramu = new od();
      paramu.giq = 1L;
      paramu.gqh = cm.bfF();
      paramu.haV = 1L;
      localObject = paramu.ES(hj((String)localObject));
      ((od)localObject).haX = j;
      paramView = ((od)localObject).ET(paramView);
      paramView.haZ = l;
      paramView.hba = i;
      paramView.EU(paramString).bpa();
      ar.a(paramu);
      AppMethodBeat.o(201132);
      return;
      i = 0;
    }
  }
  
  private static String hj(String paramString)
  {
    AppMethodBeat.i(201137);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("#")))
    {
      paramString = paramString.substring(1);
      AppMethodBeat.o(201137);
      return paramString;
    }
    AppMethodBeat.o(201137);
    return paramString;
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(201118);
    int m;
    long l2;
    int k;
    int j;
    long l3;
    Object localObject;
    int i;
    if (paramu.type == 58)
    {
      parami = com.tencent.mm.plugin.secdata.ui.a.JbV;
      parami = (eqn)a.a.ga(paramView);
      Log.i("MicroMsg.URISpanHandlerSet", "TopicSpanHandler click %s %s", new Object[] { paramu.url, parami });
      long l1 = 0L;
      m = 0;
      paramView = "";
      l2 = cm.bfF();
      k = 0;
      j = 0;
      if (parami != null)
      {
        l1 = parami.RNc;
        m = parami.UsY;
        paramView = parami.UsZ;
        l2 = parami.RMZ;
        k = parami.Uta;
        j = parami.Utb;
        paramView = a(m, paramView, parami.Utc);
      }
      l3 = l1;
      if (paramu.bnW != null)
      {
        l3 = l1;
        if ((paramu.bnW instanceof Bundle)) {
          l3 = ((Bundle)paramu.bnW).getLong("msgSvrId");
        }
      }
      localObject = paramu.url;
      i = 73;
      if ((m != 1) && (m != 2)) {
        break label454;
      }
      i = 73;
    }
    for (;;)
    {
      paramu = d.Sx(i);
      parami = new ag();
      parami.context = URISpanHandlerSet.a(this.fgB);
      parami.scene = i;
      parami.query = ((String)localObject);
      parami.title = ((String)localObject);
      parami.sessionId = paramu;
      parami.PyA = true;
      parami.PyB = true;
      parami.PyC = true;
      parami.PyD = 1;
      parami.PyE = com.tencent.mm.ci.a.w(URISpanHandlerSet.a(this.fgB), R.e.white);
      parami.PyF = true;
      parami.fPy.put("msgSvrId", String.valueOf(l3));
      parami.fPy.put("parentSearchID", "");
      parami.fPy.put("fromTagSearch", "1");
      parami.PyL.put("ShareSceneId", paramView);
      parami.PyL.put("SnsContentType", String.valueOf(j));
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(parami);
      parami = new od();
      parami.giq = 1L;
      parami.gqh = cm.bfF();
      parami.haV = 1L;
      localObject = parami.ES(hj((String)localObject));
      ((od)localObject).haX = m;
      paramView = ((od)localObject).ET(paramView);
      paramView.haZ = l2;
      paramView.hba = k;
      paramView.EU(paramu).bpa();
      ar.a(parami);
      AppMethodBeat.o(201118);
      return true;
      label454:
      if (m == 3) {
        i = 79;
      } else if ((m == 4) || (m == 5)) {
        i = 80;
      }
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 58 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.TopicSpanHandler
 * JD-Core Version:    0.7.0.1
 */