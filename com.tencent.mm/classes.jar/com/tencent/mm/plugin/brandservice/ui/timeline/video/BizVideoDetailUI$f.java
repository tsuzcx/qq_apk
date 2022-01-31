package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "callback"})
final class BizVideoDetailUI$f
  implements b.a
{
  BizVideoDetailUI$f(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(152814);
    BizVideoDetailUI.j(this.kgi).aZf();
    if (paramb == null)
    {
      AppMethodBeat.o(152814);
      return;
    }
    ab.i(BizVideoDetailUI.u(this.kgi), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramb.getType());
    Object localObject = paramb.adm();
    if ((((localObject instanceof ek)) && (((ek)localObject).wqb != BizVideoDetailUI.j(this.kgi).kfv)) || (((localObject instanceof ej)) && (((ej)localObject).wqb != BizVideoDetailUI.j(this.kgi).kfv)))
    {
      AppMethodBeat.o(152814);
      return;
    }
    if (paramb.getType() == 1179)
    {
      this.kgi.kgb = true;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        BizVideoDetailUI.p(this.kgi);
        paramString = paramb.adn();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
          AppMethodBeat.o(152814);
          throw paramString;
        }
        paramString = (el)paramString;
        paramb = BizVideoDetailUI.u(this.kgi);
        localObject = new StringBuilder("url_info size is ");
        LinkedList localLinkedList;
        if (paramString.wqw != null)
        {
          localLinkedList = paramString.wqw;
          if (localLinkedList == null) {
            j.ebi();
          }
        }
        for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
        {
          ab.i(paramb, paramInt1);
          if ((paramString.wqx == 0) || (bo.isNullOrNil(paramString.wqy))) {
            break;
          }
          ab.i(BizVideoDetailUI.u(this.kgi), "onSceneEnd redirect %s", new Object[] { paramString.wqy });
          paramb = this.kgi;
          paramString = paramString.wqy;
          j.p(paramString, "resp.redirect_url");
          paramb.Hg(paramString);
          AppMethodBeat.o(152814);
          return;
        }
        this.kgi.a(paramString);
        AppMethodBeat.o(152814);
        return;
      }
      this.kgi.a(null);
      BizVideoDetailUI.o(this.kgi);
      paramb = BizVideoDetailUI.n(this.kgi);
      paramb.kgA.setBackgroundResource(2130838005);
      if (!bo.isNullOrNil(paramString)) {
        paramb.kgz.setText((CharSequence)(paramb.getContext().getString(2131301634) + ' ' + paramString));
      }
      for (;;)
      {
        paramb.kgr.setClickable(true);
        if (paramInt1 != 2) {
          break;
        }
        com.tencent.mm.plugin.webview.ui.tools.b.Ko(2);
        AppMethodBeat.o(152814);
        return;
        paramb.kgz.setText((CharSequence)paramb.getContext().getString(2131301634));
      }
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(3);
      AppMethodBeat.o(152814);
      return;
    }
    AppMethodBeat.o(152814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.f
 * JD-Core Version:    0.7.0.1
 */